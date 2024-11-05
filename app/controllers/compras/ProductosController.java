package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.Articulo;
import models.Categoria;
import models.Cliente;
import models.Cuenta;
import models.Deposito;
import models.Estado;
import models.Producto;
import models.ProductoDeposito;
import models.Proveedor;
import models.Solicitud;
import models.Udm;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import akka.japi.Util;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ArrayUtils;
import utils.DateUtils;
import utils.NumberUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.compras.productos.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;

import controllers.Secured;
import controllers.auth.CheckPermiso;


public class ProductosController extends Controller {

	final static Form<Producto> productoForm = form(Producto.class);
	final static Long ID_UDM_PREDETERMINADO = (long) 1;
	final static Long ID_CUENTA_INGRESO = (long) 226;
	final static Long ID_CUENTA_GASTO = (long) 255;
	final static double PRECIO_COSTE = (double) 1.00;

	public static Result URL_LISTA_PRODUCTOS = redirect(
			controllers.compras.routes.ProductosController.indexProducto()
	);

	@CheckPermiso(key = "productosGeneral")
	public static Result indexProducto() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(indexProducto.render(Producto.page(
													RequestVar.get("nombre"),
													RequestVar.get("categoria_id")
													),
				 d, pf));
	}

	@CheckPermiso(key = "productosCrear")
	public static Result crearProducto() {

		Udm udmPredeterminado = Udm.find.byId(ID_UDM_PREDETERMINADO);
		Cuenta cuentaIngresoPredeterminado = Cuenta.find.byId(ID_CUENTA_INGRESO);
		Cuenta cuentaGastoPredeterminado = Cuenta.find.byId(ID_CUENTA_GASTO);
		Map<String,String> b = new HashMap<String, String>();
		b.put("udm.nombre", udmPredeterminado.nombre);
		b.put("cuenta_ingreso.nombre", cuentaIngresoPredeterminado.nombre);
		b.put("cuenta_gasto.nombre", cuentaGastoPredeterminado.nombre);
		b.put("udm_id", udmPredeterminado.id.toString());
		b.put("cuenta_ingreso_id", cuentaIngresoPredeterminado.id.toString());
		b.put("cuenta_gasto_id", cuentaGastoPredeterminado.id.toString());
		b.put("precio_coste", new Double(1.00).toString());

 		Form<Producto> productoForm = form(Producto.class).bind(b);
 		productoForm.discardErrors();
 		List<Integer> productoDepositos = new ArrayList<Integer>();
 		for(Deposito pd : Deposito.find.all()){productoDepositos.add(pd.id.intValue());};


		return ok(crearProducto.render(productoForm,productoDepositos));
	}

	@CheckPermiso(key = "productosCrear")
	public static Result guardarProducto() throws Exception{

		Form<Producto> productoForm = form(Producto.class).bindFromRequest();
		List<Integer> productoDepositos = ArrayUtils.convertArrayStringToIntenger(request().body().asFormUrlEncoded().get("productoDeposito[]"));
		try {





			/*if(productoForm.field("articulo_id").value().isEmpty()){
				productoForm.reject("articulo_id","El Articulo es obligatorio.");
			}*/
			if(productoForm.field("tipo_producto_id").value().isEmpty()){
				productoForm.reject("tipo_producto_id","El Tipo de Producto es obligatorio.");
			}
			if(productoForm.field("categoria_id").value().isEmpty()){
				productoForm.reject("categoria_id","La Categoria es obligatoria.");
			}
			if(productoForm.field("cuenta_ingreso_id").value().isEmpty()){
				productoForm.reject("cuenta_ingreso_id","La Cuenta de ingreso es obligatoria.");
			}
			if(productoForm.field("cuenta_gasto_id").value().isEmpty()){
				productoForm.reject("cuenta_gasto_id","La Cuenta de gasto es obligatoria.");
			}
			if(productoForm.field("udm_id").value().isEmpty()){
				productoForm.reject("udm_id","La Udm es obligatoria.");
			}


			if(productoForm.hasErrors()) {
				flash("error", "Error en formulario "+productoForm.errors());
				return badRequest(crearProducto.render(productoForm,productoDepositos));
			} else {
				Producto p = productoForm.get();

				String slug = p.nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
				List<Producto> px = Producto.find.where().eq("slug", slug).findList();

				if(px.size() > 0) {
					String errore = "";
					for(Producto pxx :px) {
						errore += "<br>"+pxx.nombre;
					}

					flash("error", "Error este producto ya existe."+errore);
					return badRequest(crearProducto.render(productoForm,productoDepositos));
				}


				p.slug = slug;
				p.activo = true;
				p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.create_date = new Date();
				p.save();

				ProductoDeposito.deleteProducto(p.id);

				for(Integer i :productoDepositos){
					ProductoDeposito pd = new ProductoDeposito();
					pd.producto_id = p.id;
					pd.deposito_id = i.longValue();
					pd.save();
				}

				flash("success", "El producto ha actualizado");
				return ok(verProducto.render(p, new PaginadorFicha(UriTrack.code()),productoDepositos));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el producto");
			return badRequest(crearProducto.render(productoForm,productoDepositos));
		}
	}

	public static Result modalCarga() {
		Udm udmPredeterminado = Udm.find.byId(ID_UDM_PREDETERMINADO);
		Map<String,String> b = new HashMap<String, String>();
		b.put("udm.nombre", udmPredeterminado.nombre);
		b.put("udm_id", udmPredeterminado.id.toString());
		b.put("precio_coste", new Double(1.00).toString());

 		Form<Producto> productoForm = form(Producto.class).bind(b);
 		productoForm.discardErrors();
 		List<Integer> productoDepositos = new ArrayList<Integer>();
 		for(Deposito pd : Deposito.find.all()){productoDepositos.add(pd.id.intValue());};

		return ok(modalCargaProductos.render(productoForm,productoDepositos));
	}

	public static Result guardarProductoDesdeModal() {



		Form<Producto> productoForm = form(Producto.class).bindFromRequest();
		List<Integer> productoDepositos = ArrayUtils.convertArrayStringToIntenger(request().body().asFormUrlEncoded().get("productoDeposito[]"));

		if(!Permiso.check("productosCrear")) {
			flash("error", "No tiene permisos para Crear productos. DEBE CREAR LOS PRODUCTOS DESDE RISMI.");
			return ok(modalCargaProductos.render(productoForm,productoDepositos));
		}

		try {

			if(productoForm.field("tipo_producto_id").value().isEmpty()){
				productoForm.reject("tipo_producto_id","El Tipo de Producto es obligatorio.");
			}
			if(productoForm.field("categoria_id").value().isEmpty()){
				productoForm.reject("categoria_id","La Categoria es obligatoria.");
			}
			if(productoForm.field("udm_id").value().isEmpty()){
				productoForm.reject("udm_id","La Udm es obligatoria.");
			}

			if(productoForm.hasErrors()) {
				flash("error", "Compruebe los errores en el formulario.");
				return ok(modalCargaProductos.render(productoForm,productoDepositos));
			}else{

				ObjectNode result = Json.newObject();
				try {
					Producto p = productoForm.get();

					String slug = p.nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
					List<Producto> px = Producto.find.where().eq("slug", slug).findList();

					if(px.size() > 0) {
						String errore = "";
						for(Producto pxx :px) {
							errore += "<br>"+pxx.nombre;
						}

						flash("error", "Error este producto ya existe."+errore);
						return badRequest(crearProducto.render(productoForm,productoDepositos));
					}

					p.slug = slug;
					p.activo = true;
					p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					p.create_date = new Date();
					p.save();

					ProductoDeposito.deleteProducto(p.id);
					for(Integer i :productoDepositos){
						ProductoDeposito pd = new ProductoDeposito();
						pd.producto_id = p.id;
						pd.deposito_id = i.longValue();
						pd.save();
					}

					result.put("success", true);
					result.put("nombre", p.nombre);
					result.put("idProducto", p.id);
					result.put("html", modalCargaProductos.render(productoForm,productoDepositos).toString());
					return ok(result);

				} catch (Exception e){
					flash("error", "No se puede modificar los registros.");
					return ok(modalCargaProductos.render(productoForm,productoDepositos));
				}
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el producto");
			return badRequest(modalCargaProductos.render(productoForm,productoDepositos));
		}
	}


	@CheckPermiso(key = "productosCrear")
	public static Result editarProducto(Long id) {
		Producto producto = Producto.find.byId(id);
		Boolean editarNombre = false;

		List<Integer> productoDepositos = ProductoDeposito.getDepositoByProducto(id);

		Logger.debug(productoDepositos.toString());

		if(Usuario.getUsuarioSesion().compareTo(1) == 0 || Usuario.getUsuarioSesion().compareTo(19) == 0 || Usuario.getUsuarioSesion().compareTo(31) == 0){
			editarNombre = true;
		}

		return ok(editarProducto.render(productoForm.fill(producto),editarNombre,productoDepositos));
	}

	@CheckPermiso(key = "productosCrear")
	public static Result actualizarProducto() throws Exception{

		Boolean editarNombre = false;
		if(Usuario.getUsuarioSesion().compareTo(1) == 0 || Usuario.getUsuarioSesion().compareTo(19) == 0 || Usuario.getUsuarioSesion().compareTo(31) == 0){
			editarNombre = true;
		}

		List<Integer> productoDepositos = ArrayUtils.convertArrayStringToIntenger(request().body().asFormUrlEncoded().get("productoDeposito[]"));

		Form<Producto> productoForm = form(Producto.class).bindFromRequest();
		try {

			/*if(productoForm.field("articulo.id").value().isEmpty()){
				productoForm.reject("articulo.id","El Articulo es obligatorio.");
			}*/
			if(productoForm.field("tipo_producto_id").value().isEmpty()){
				productoForm.reject("tipo_producto_id","El Tipo de Producto es obligatorio.");
			}
			if(productoForm.field("categoria_id").value().isEmpty()){
				productoForm.reject("categoria_id","La Categoria es obligatoria.");
			}
			if(productoForm.field("cuenta_ingreso_id").value().isEmpty()){
				productoForm.reject("cuenta_ingreso_id","La Cuenta de ingreso es obligatoria.");
			}
			if(productoForm.field("cuenta_gasto_id").value().isEmpty()){
				productoForm.reject("cuenta_gasto_id","La Cuenta de gasto es obligatoria.");
			}
			if(productoForm.field("udm_id").value().isEmpty()){
				productoForm.reject("udm_id","La Udm es obligatoria.");
			}


			if(productoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarProducto.render(productoForm,editarNombre,productoDepositos));
			} else {
				Producto p = productoForm.get();

				String slug = p.nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
				List<Producto> px = Producto.find.where().eq("slug", slug).ne("id", p.id).findList();

				if(px.size() > 0) {
					String errore = "";
					for(Producto pxx :px) {
						errore += "<br>"+pxx.nombre;
					}

					flash("error", "Error este producto ya existe."+errore);
					return badRequest(crearProducto.render(productoForm,productoDepositos));
				}

				p.slug = slug;
				p.activo = true;
				p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.write_date = new Date();
				p.update();

				ProductoDeposito.deleteProducto(p.id);
				for(Integer i :productoDepositos){
					ProductoDeposito pd = new ProductoDeposito();
					pd.producto_id = p.id;
					pd.deposito_id = i.longValue();
					pd.save();
				}


				flash("success", "El producto ha actualizado");
				return ok(verProducto.render(p, new PaginadorFicha(UriTrack.code()),productoDepositos));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el producto.");
			return badRequest(editarProducto.render(productoForm,editarNombre,productoDepositos));
		}

	}


	@CheckPermiso(key = "productosGeneral")
	public static Result listarProducto() {

		return ok(listarProducto.render());
	}

	@CheckPermiso(key = "productosEliminar")
	public static Result eliminarProducto(Long id) {
		try {
			Producto.find.byId(id).delete();
			flash("success", "Se ha eliminado el producto");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el producto");
		}

		return URL_LISTA_PRODUCTOS;
	}

	public static Result suggestUdm(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode udm = rpta.arrayNode();

	    Udm ad = new Udm();

		for(Udm a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        udm.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", udm);

		return ok(response);
	}

	public static Result suggestProducto(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode udm = rpta.arrayNode();

	    Producto ad = new Producto();

		for(Producto a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", (a.precio_coste != null)?a.precio_coste:new BigDecimal(0));
	        udm.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", udm);

		return ok(response);
	}

	public static Result getDataSuggestSolicitud(String input,Long idDeposito) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode udm = rpta.arrayNode();

	    Producto ad = new Producto();

		for(Producto a : ad.getDataSuggestSolicitud(input, 25,idDeposito)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        String cat = (a.categoria != null)? a.categoria.nombre:"";
	        restJs.put("info",cat);
	        udm.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", udm);

		return ok(response);
	}

	public static Result suggestProductoPresupuesto(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode udm = rpta.arrayNode();

	    List<Producto> ad = Producto.find.where()
	    		.disjunction()
	    		.ilike("nombre", "%"+input+"%")
	    		.ilike("codigo_ips", "%"+input+"%")
	    		.ilike("referencia", "%"+input+"%")
	    		.endJunction()
	    		.eq("activo", true)
	    		.eq("categoria_id", Producto.CATEGORIA_IPS)
	    		.setMaxRows(25).orderBy("nombre").findList();

		for(Producto a :  ad){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        String codigoIps = (a.codigo_ips != null)?a.codigo_ips:"";
	        restJs.put("value",codigoIps+" - "+a.nombre);
	        BigDecimal precio = (a.precio_coste != null)?a.precio_coste:BigDecimal.ZERO;
	        restJs.put("info",  codigoIps+" - "+utils.NumberUtils.moneda(precio));
	        restJs.put("precio",  precio);

	        udm.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", udm);

		return ok(response);
	}



	public static Result modalBuscar() {
    	Pagination<Producto> p = new Pagination<Producto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(Producto.find.where().eq("activo", true).ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaProducto.render(p, form().bindFromRequest()) );
	}

	public static Result modalBuscarSolicitudes(Long idSolicitud) {

		Solicitud s = Solicitud.find.byId(idSolicitud);

    	Pagination<Producto> p = new Pagination<Producto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Producto> l = Producto.find.where().eq("activo", true).ilike("nombre", "%"+RequestVar.get("nombre")+"%");


		if(Usuario.getUsurioSesion().organigrama_id != null && Usuario.getUsurioSesion().organigrama_id.compareTo(new Long(90)) == 0){
			l= l.disjunction();
			l= l.eq("categoria_id", 20);
			l= l.eq("categoria_id", 21);
			l= l.eq("categoria_id", 24);
			l= l.endJunction();
		}

		//l.in("productosDepositos.deposito_id", s.deposito_id);


    	p.setExpressionList(l);
		return ok( modalBusquedaProductoSolicitudes.render(p, form().bindFromRequest(),s) );
	}

	public static Result modalBuscarIps() {
    	Pagination<Producto> p = new Pagination<Producto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");



    	ExpressionList<Producto> e = Producto.find.where();
    	e = e.eq("categoria_id", Producto.CATEGORIA_IPS);
    	e = e.eq("activo", true);

    	if(Usuario.getUsurioSesion().id.compareTo(new Integer(83)) == 0) {
    		e = e.eq("referencia", "PROD. TR.");
    	}else {

	    	if(!RequestVar.get("codigo").isEmpty() || !RequestVar.get("nombre").isEmpty()){
		    	e = e.disjunction();
		    	if(!RequestVar.get("codigo").isEmpty()){
		    		e = e.ilike("codigo_ips", "%" + RequestVar.get("codigo") + "%");
		    	}
		    	if(!RequestVar.get("nombre").isEmpty()){
		    		e = e.ilike("nombre", "%" + RequestVar.get("nombre") + "%");
		    	}
		    	e = e.endJunction();
	    	}
    	}
    	p.setExpressionList(e);

		return ok(modalBusquedaProductoIps.render(p, form().bindFromRequest()));
	}

    public static Result get(int id){
    	Producto producto = Producto.find.select("id, nombre").where().eq("id", id).eq("activo", true).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(producto == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el producto");
		} else {
			restJs.put("success", true);
			restJs.put("id", producto.id);
			restJs.put("nombre", producto.nombre);
			restJs.put("costo", producto.precio_coste);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

    public static Result getPrecioProducto(int producto_id){

    	Producto producto = Producto.find.select("id, nombre,precio_coste").where().eq("id", producto_id).eq("activo", true).findUnique();

    	ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(producto == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el producto");
		} else {
			restJs.put("success", true);
			restJs.put("id", producto.id);
			restJs.put("nombre", producto.nombre);
			restJs.put("precio", producto.precio_coste);
		}
		nodo.add(restJs);
		return ok(restJs);
    }

    @CheckPermiso(key = "productosGeneral")
    public static Result ver(Long id) {
    	Producto producto = Producto.find.byId(id);
    	List<Integer> productoDepositos = ProductoDeposito.getDepositoByProducto(id);
		return ok(verProducto.render(producto, new PaginadorFicha(UriTrack.code()),productoDepositos));
	}

    public static Result cargaProductoRismi() {


    	Logger.debug("------------------------------ "+RequestVar.get("id"));
    	Logger.debug("------------------------------ "+RequestVar.get("nombre"));
    	Logger.debug("------------------------------ "+RequestVar.get("tipo_producto_id"));
    	Logger.debug("------------------------------ "+RequestVar.get("categoria_id"));
    	Logger.debug("------------------------------ "+RequestVar.get("articulo_id"));
    	Logger.debug("------------------------------ "+RequestVar.get("udm_id"));
    	Logger.debug("------------------------------ "+RequestVar.get("activo"));
    	Logger.debug("------------------------------ "+RequestVar.getArray("array_dominio[]")[0]);


    	try{

    		String codigo_rismi = (!RequestVar.get("id").isEmpty())?RequestVar.get("id"):null;
    		String nombre = (!RequestVar.get("nombre").isEmpty())?RequestVar.get("nombre"):null;
    		Integer tipoProductoId = (!RequestVar.get("tipo_producto_id").isEmpty())?new Integer(RequestVar.get("tipo_producto_id")):2;
    		Integer categoriaId = (!RequestVar.get("categoria_id").isEmpty())?new Integer(RequestVar.get("categoria_id")):14;
    		Integer articuloId = (!RequestVar.get("articulo_id").isEmpty())?new Integer(RequestVar.get("articulo_id")):null;
    		Integer udmId = (!RequestVar.get("udm_id").isEmpty())?new Integer(RequestVar.get("udm_id")):1;
    		Boolean activo = (!RequestVar.get("activo").isEmpty() && RequestVar.get("activo").compareToIgnoreCase("A") == 0)?true:false;

    		Producto pe = new Producto();
    		pe.activo =  activo;
    		pe.nombre = nombre;
    		pe.articulo_id = articuloId;
    		pe.categoria_id = categoriaId;
    		pe.tipo_producto_id = tipoProductoId;
    		pe.udm_id = udmId;
    		pe.codigo_rismi = codigo_rismi;

    		List<Long> idDominios = new ArrayList<Long>();

    		for(String x : RequestVar.getArray("array_dominio[]")){
    			idDominios.add(new Long(x));
    		}

    		Producto ps = Producto.cargarProductosDesdeRismi(pe,idDominios);



    		/*Producto p = Producto.find.where().eq("codigo_rismi",codigo_rismi).findUnique();

    		if(udmId != null){
    			Udm u = Udm.find.byId(udmId.longValue());
    			if(u == null){
    				udmId = null;
    			}
    		}


    		if(articuloId != null){
    			Articulo a = Articulo.find.byId((long)articuloId);
    			if(a == null){
    				articuloId = 1537;
    			}
    		}

    		if(categoriaId != null){
    			Categoria c = Categoria.find.byId((long)categoriaId);
    			if(c == null){
    				categoriaId = 14;
    			}
    		}

    		if(p != null){
    			Logger.debug("UPDATE");
    			p.activo =  activo;
        		p.write_date =  new Date();
        		p.nombre = nombre;
        		p.articulo_id = articuloId;
        		p.categoria_id = categoriaId;
        		p.tipo_producto_id = tipoProductoId;
        		p.udm_id = udmId;
        		p.write_date = new Date();
        		p.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
        		p.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
        		p.update();
    		}else{
    			p = Producto.find.where().ilike("nombre","%" + nombre + "%").setMaxRows(1).findUnique();
    			if(p != null){
    				Logger.debug("UPDATE POR NOMBRE");
    				p.activo =  activo;
            		p.write_date =  new Date();
            		p.nombre = nombre;
            		p.articulo_id = articuloId;
            		p.categoria_id = categoriaId;
            		p.tipo_producto_id = tipoProductoId;
            		p.udm_id = udmId;
            		p.write_date = new Date();
            		p.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
            		p.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
            		p.codigo_rismi = codigo_rismi;
            		p.update();
    			}else{
	    			Logger.debug("INSERT");
	    			Producto p2 = new Producto();
	    			p2.activo =  activo;
	        		p2.create_date =  new Date();
	        		p2.nombre = nombre;
	        		p2.articulo_id = articuloId;
	        		p2.categoria_id = categoriaId;
	        		p2.tipo_producto_id = tipoProductoId;
	        		p2.udm_id = udmId;
	        		p2.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
	        		p2.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
	        		p2.codigo_rismi = codigo_rismi;
	    			p2.save();
	    			p= p2;
    			}
    		}

    		List<ProductoDeposito> pd = ProductoDeposito.find.where().eq("producto_id", p.id).findList();
    		for(ProductoDeposito pdx : pd){
    			pdx.delete();
    		}


    		for(String x : RequestVar.getArray("array_dominio[]")){
    			Long idDeposito = new Long(x);
    			if(idDeposito == 3){
					idDeposito = (long) 25;
				}else if(idDeposito == 6){
					idDeposito = (long) 3;
				}else if(idDeposito == 15){
					idDeposito = (long) 30;
				}

    			ProductoDeposito pdi = new ProductoDeposito();
    			pdi.producto_id = p.id;
    			pdi.deposito_id = idDeposito;
    			pdi.save();
    		}*/


    	}catch(Exception e){
    		Logger.debug("------------------------------ "+e);
    	}

    	return ok();
    	/*
    	$url = "http://10.1.2.235:9000/cargaProductoRismi";
    	$postData = array("i" => productoId,
    					  "nombre" => nombreProducto,
    					  "tipoProductoId" => tipoProductoId,
    					  "categoriaId" => categoriaId,
    					  "articuloId" => articuloId,
    					  "udmId" => udmId);

    	$elements = array();
    	foreach ($postData as $name=>$value) {
    	   $elements[] = "{$name}=".urlencode($value);
    	}
    	$handler = curl_init();
    	curl_setopt($handler, CURLOPT_URL, $url);
    	curl_setopt($handler, CURLOPT_POST,true);
    	curl_setopt($handler, CURLOPT_POSTFIELDS, $elements);
    	$response = curl_exec ($handler);
    	curl_close($handler);
    	*/
    }

    public static Result cargaNdMaterno() {
    	JsonNode json = Controller.request().body().asJson();
    	Logger.debug("idfactura -> " + json.get("idfactura").asInt());//x
		Logger.debug("cuit------------------------------ "+json.get("cuit").textValue());
    	Logger.debug("razonsocial------------------------------ "+json.get("razonsocial").textValue());
    	Logger.debug("domicilio------------------------------ "+json.get("domicilio").textValue());
    	Logger.debug("tipo_doc_id------------------------------ "+json.get("tipo_doc_id").textValue());
    	Logger.debug("doc------------------------------ "+json.get("doc").textValue());
    	Logger.debug("pv_id------------------------------ "+json.get("pv_id").textValue());//x
    	Logger.debug("nrofactura------------------------------ "+json.get("nrofactura").textValue());//x
    	Logger.debug("condiva_id------------------------------ "+json.get("condiva_id").textValue());//x
    	Logger.debug("condventa_id------------------------------ "+json.get("condventa_id").textValue());//x
    	Logger.debug("total------------------------------ "+json.get("total").asDouble());
    	Logger.debug("cae------------------------------ "+json.get("cae").textValue());//x
    	Logger.debug("fecha_vencimiento------------------------------ "+json.get("fecha_vencimiento").textValue());//x
    	Logger.debug("fecha_emision------------------------------ "+json.get("fecha_emision").textValue());//x
    	Logger.debug("fecha_desde------------------------------ "+json.get("fecha_desde").textValue());//x
    	Logger.debug("fecha_hasta------------------------------ "+json.get("fecha_hasta").textValue());//x
    	for (JsonNode data : json.withArray("lineas")) {
			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));
		}

    	try{

    		RecuperoFactura rf = RecuperoFactura.find.where().eq("id_factura_materno", json.get("factura_assoc_id").asInt()).findUnique();
    		Integer nro = new Integer(json.get("nrofactura").textValue());

    		List<RecuperoNotaDebito> rffnro = RecuperoNotaDebito.find.where()
					.eq("numero", NumberUtils.agregarCerosAlaIzquierda(nro,8))
					.eq("puntoventa_id", 7)
					.findList();

    		if(rf != null && rffnro.size() == 0) {

    			Long idProducto = null;

    			BigDecimal precio = new BigDecimal(0);

    			for (JsonNode data : json.withArray("lineas")) {
        			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));
        			BigDecimal precioTmp = new BigDecimal(0);
		    		List<Producto> pe =  Producto.find.where().eq("nombre",  data.get("productoNombre").textValue()).findList();

					if(pe.size() > 0) {
						idProducto = pe.get(0).id;
					}else {

						String slug = data.get("productoNombre").textValue().replace(" ", "").replace(".","").replace("-","").toUpperCase();
						List<Producto> px = Producto.find.where().eq("slug", slug).findList();

						if(px.size() > 0) {
							idProducto = px.get(0).id;
						}else {

							Producto peNew = new Producto();
							peNew.activo =  true ;
							peNew.nombre = data.get("productoNombre").textValue();
							peNew.articulo_id = 3042;
							peNew.categoria_id = 36;
							peNew.tipo_producto_id = 2;
							peNew.udm_id = 1;
							peNew.codigo_rismi = null;
							peNew.save();

							idProducto = peNew.id;
						}
					}

					precioTmp =  new BigDecimal(data.get("monto").textValue()).multiply(new BigDecimal(data.get("cantidad").textValue()));
					precio = precio.add(precioTmp);
    			}


	    		RecuperoNotaDebito nc = new RecuperoNotaDebito();

	    		nc.recupero_factura_id = rf.id;//nro;
	    		nc.id_nota_materno = json.get("idfactura").asInt();


	    		nc.producto_id = idProducto;

	    		nc.precio= precio;//new BigDecimal(data.get("monto").textValue());
	    		nc.cantidad=new BigDecimal(1);//new BigDecimal(data.get("cantidad").textValue());

	    		nc.udm_id= new Long(1);
	    		nc.create_usuario_id= new Long(1);
	    		nc.create_date= new Date();
	    		nc.fecha = DateUtils.formatDate(json.get("fecha_desde").textValue(), "yyyy-MM-dd");

	     		nc.numero= NumberUtils.agregarCerosAlaIzquierda(nro,8);
	    		nc.puntoventa_id = 7;
	    		nc.cae = json.get("cae").textValue();
	    		nc.fecha_vencimiento= DateUtils.formatDate(json.get("fecha_vencimiento").textValue(), "yyyy-MM-dd");

	    		nc.save();
    		}else {
    			return ok("NO SE ENCUENTRA LA FACTURA MATERNO");
    		}


    	}catch (Exception e) {
    		return ok("ERROR ND "+e);
		}
    	return ok();

    }

    public static Result cargaNcMaterno() {
    	JsonNode json = Controller.request().body().asJson();

    	Logger.debug("idfactura -> " + json.get("idfactura").asInt());//x
		Logger.debug("cuit------------------------------ "+json.get("cuit").textValue());
    	Logger.debug("razonsocial------------------------------ "+json.get("razonsocial").textValue());
    	Logger.debug("domicilio------------------------------ "+json.get("domicilio").textValue());
    	Logger.debug("tipo_doc_id------------------------------ "+json.get("tipo_doc_id").textValue());
    	Logger.debug("doc------------------------------ "+json.get("doc").textValue());
    	Logger.debug("pv_id------------------------------ "+json.get("pv_id").textValue());//x
    	Logger.debug("nrofactura------------------------------ "+json.get("nrofactura").textValue());//x
    	Logger.debug("condiva_id------------------------------ "+json.get("condiva_id").textValue());//x
    	Logger.debug("condventa_id------------------------------ "+json.get("condventa_id").textValue());//x
    	Logger.debug("total------------------------------ "+json.get("total").asDouble());
    	Logger.debug("cae------------------------------ "+json.get("cae").textValue());//x
    	Logger.debug("fecha_vencimiento------------------------------ "+json.get("fecha_vencimiento").textValue());//x
    	Logger.debug("fecha_emision------------------------------ "+json.get("fecha_emision").textValue());//x
    	Logger.debug("fecha_desde------------------------------ "+json.get("fecha_desde").textValue());//x
    	Logger.debug("fecha_hasta------------------------------ "+json.get("fecha_hasta").textValue());//x
    	for (JsonNode data : json.withArray("lineas")) {
			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));
		}

    	try{

    		RecuperoFactura rf = RecuperoFactura.find.where().eq("id_factura_materno", json.get("factura_assoc_id").asInt()).findUnique();
    		Integer nro = new Integer(json.get("nrofactura").textValue());

    		List<RecuperoNotaCredito> rffnro = RecuperoNotaCredito.find.where()
					.eq("numero", NumberUtils.agregarCerosAlaIzquierda(nro,8))
					.eq("puntoventa_id", 7)
					.findList();

    		if(rf != null && rffnro.size() == 0) {

    			Long idProducto = null;

    			BigDecimal precio = new BigDecimal(0);

    			for (JsonNode data : json.withArray("lineas")) {
        			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));
        			BigDecimal precioTmp = new BigDecimal(0);
		    		List<Producto> pe =  Producto.find.where().eq("nombre",  data.get("productoNombre").textValue()).findList();

					if(pe.size() > 0) {
						idProducto = pe.get(0).id;
					}else {

						String slug = data.get("productoNombre").textValue().replace(" ", "").replace(".","").replace("-","").toUpperCase();
						List<Producto> px = Producto.find.where().eq("slug", slug).findList();

						if(px.size() > 0) {
							idProducto = px.get(0).id;
						}else {

							Producto peNew = new Producto();
							peNew.activo =  true ;
							peNew.nombre = data.get("productoNombre").textValue();
							peNew.articulo_id = 3042;
							peNew.categoria_id = 36;
							peNew.tipo_producto_id = 2;
							peNew.udm_id = 1;
							peNew.codigo_rismi = null;
							peNew.save();

							idProducto = peNew.id;
						}
					}

					precioTmp =  new BigDecimal(data.get("monto").textValue()).multiply(new BigDecimal(data.get("cantidad").textValue()));
					precio = precio.add(precioTmp);
    			}


	    		RecuperoNotaCredito nc = new RecuperoNotaCredito();

	    		nc.recupero_factura_id = rf.id;//nro;
	    		nc.id_nota_materno = json.get("idfactura").asInt();

	    		nc.producto_id = idProducto;

	    		nc.precio= precio;//new BigDecimal(data.get("monto").textValue());
	    		nc.cantidad=new BigDecimal(1);//new BigDecimal(data.get("cantidad").textValue());

	    		nc.udm_id= new Long(1);
	    		nc.create_usuario_id= new Long(1);
	    		nc.create_date= new Date();
	    		nc.fecha = DateUtils.formatDate(json.get("fecha_desde").textValue(), "yyyy-MM-dd");

	     		nc.numero= NumberUtils.agregarCerosAlaIzquierda(nro,8);
	    		nc.puntoventa_id = 7;
	    		nc.cae = json.get("cae").textValue();
	    		nc.fecha_vencimiento= DateUtils.formatDate(json.get("fecha_vencimiento").textValue(), "yyyy-MM-dd");

	    		nc.save();
    		}else {
    			return ok("NO SE ENCUENTRA LA FACTURA MATERNO");
    		}


    	}catch (Exception e) {
    		return ok("ERROR NC "+e);
		}
    	return ok();
    }

    public static Result cargaFacturaMaterno() {





    	/*IdFactura
    	CuitFactura
    	Pv_Id
    	NroFactura
    	TipoDoc_Id
    	NroDoc
    	CondIva_Id
    	CondVenta_Id
    	RazonSocial
    	Domicilio
    	Total
    	Cae
    	FechaVto
    	FechaEmiFact
    	FechaDesde
    	FechaHasta*/

    	/*
    	$url = "http://10.1.2.235:9000/cargaFacturaMaterno";


    	$linea = array("productoId"=> productoId,
    				   "productoNombre"=> productoNombre,
    				   "cantidad"=> cantidad,
    				   "monto"=> monto);



    	$lineasData = array("lineas"=>lineas);

    	$postData = array("idfactura" => idfactura,
    					  "cuit" => cuit,
    					  "pv_id" => pv_id,
    					  "nrofactura" => nrofactura,
    					  "doc" => doc,
    					  "condiva_id" => condiva_id,
    					  "condventa_id" => condventa_id,
    					  "razonsocial" => razonsocial,
    					  "domicilio" => domicilio,
    					  "total" => total,
    					  "cae" => cae,
    					  "fecha_vencimiento" => fecha_vencimiento,
    					  "fecha_emision" => fecha_emision,
    					  "fecha_desde" => fecha_desde,
    					  "fecha_hasta" => fecha_hasta,
    					  "lineas" => lineasData
    					  );

    	$elements = array();
    	foreach ($postData as $name=>$value) {
    	   $elements[] = "{$name}=".urlencode($value);
    	}

    	$handler = curl_init();
    	curl_setopt($handler, CURLOPT_URL, $url);
    	curl_setopt($handler, CURLOPT_POST,true);
    	curl_setopt($handler, CURLOPT_POSTFIELDS, $elements);
    	$response = curl_exec ($handler);
    	curl_close($handler);
    	*/

		Logger.debug("-------xxxxxxxxxxxx------------ "+Controller.request().toString());

		Logger.debug("-------asJson()------------ "+request().body().asJson());

		/*foreach($dominios as $d) {
		    $url .= "&array_dominio[]=" . $d->id_dominio;
		}*/





    	//Logger.debug("lineas------------------------------ "+request().body().asFormUrlEncoded().get("lineas[]").toString() );//


    	//Logger.debug("------------------------------ "+RequestVar.getArray("array_dominio[]")[0]);


    	JsonNode json = Controller.request().body().asJson();

		Logger.debug("idfactura -> " + json.get("idfactura").asInt());//x
		//Logger.debug("idfactura------------------------------ "+request().body().asFormUrlEncoded().get("idfactura")[0]);

    	Logger.debug("cuit------------------------------ "+json.get("cuit").textValue());
    	Logger.debug("razonsocial------------------------------ "+json.get("razonsocial").textValue());
    	Logger.debug("domicilio------------------------------ "+json.get("domicilio").textValue());
    	Logger.debug("tipo_doc_id------------------------------ "+json.get("tipo_doc_id").textValue());

    	Logger.debug("doc------------------------------ "+json.get("doc").textValue());

    	Logger.debug("pv_id------------------------------ "+json.get("pv_id").textValue());//x
    	Logger.debug("nrofactura------------------------------ "+json.get("nrofactura").textValue());//x
    	Logger.debug("condiva_id------------------------------ "+json.get("condiva_id").textValue());//x
    	Logger.debug("condventa_id------------------------------ "+json.get("condventa_id").textValue());//x


    	Logger.debug("total------------------------------ "+json.get("total").asDouble());
    	Logger.debug("cae------------------------------ "+json.get("cae").textValue());//x
    	Logger.debug("fecha_vencimiento------------------------------ "+json.get("fecha_vencimiento").textValue());//x
    	Logger.debug("fecha_emision------------------------------ "+json.get("fecha_emision").textValue());//x
    	Logger.debug("fecha_desde------------------------------ "+json.get("fecha_desde").textValue());//x
    	Logger.debug("fecha_hasta------------------------------ "+json.get("fecha_hasta").textValue());//x


		//Logger.debug("lineas -> " + json.get("lineas").);
		for (JsonNode data : json.withArray("lineas")) {
			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));
		}

		List<RecuperoFactura> rff = RecuperoFactura.find.where()
									.eq("id_factura_materno", new Long(json.get("idfactura").asInt()))
									.findList();
		if(rff.size()>0) {
			return ok("ERROR - YA SE ENCUENTRA CARGA LA FACTURA: "+json.get("idfactura").asInt());
		}


    	try{


    		//{"idfactura":"11046","cuit":30712131310,"pv_id":7,"nrofactura":"3","doc":"2856584","tipo_doc_id":"91","condiva_id":"5","condventa_id":"1","razonsocial":"ACOSTA NU\u00d1EZ, ROCIO","domicilio":"ENCARNACION - CALLE PADRE ANTONIO RIERA 2220 - B\u00ba LA PAZ","total":"72932.53","cae":"72270300226369","fecha_vencimiento":"72270300226369","fecha_emision":"72270300226369","fecha_desde":"2022-06-30","fecha_hasta":"2022-07-06",

    		List<Cliente> lc = new ArrayList<Cliente>();

    		if(json.get("tipo_doc_id").textValue().compareTo("80") == 0 || json.get("tipo_doc_id").textValue().compareTo("86") == 0) {

    			lc = Cliente.find.where().eq("cuit2",json.get("doc").textValue().replace(" ","")).findList();

    		}else if(json.get("tipo_doc_id").textValue().compareTo("96") == 0){

    			lc = Cliente.find.where().eq("dni",new Integer(json.get("doc").asText().replace(" ",""))).findList();

    		}else if(json.get("tipo_doc_id").textValue().compareTo("91") == 0){

    			lc = Cliente.find.where().eq("cie",json.get("doc").textValue().replace(" ","")).findList();

    		}


    		Long idCLiente = null;
    		if(lc.size() > 0) {
    			idCLiente = lc.get(0).id;
    		}else {

    			Cliente clnew = new Cliente();
    			clnew.nombre = json.get("razonsocial").textValue();
    			clnew.create_usuario_id = new Long(1);
    			clnew.create_date = new Date();
    			clnew.activo = true;

    			String tipo_doc_id = json.get("tipo_doc_id").textValue();

    			if(tipo_doc_id.compareTo("96") == 0) {
    				clnew.dni = new Integer(json.get("doc").textValue());
    				clnew.cliente_tipo_id = new Long(7);
    			}else if(tipo_doc_id.compareTo("91") == 0) {
    				clnew.cie  = json.get("doc").textValue();
    				clnew.cliente_tipo_id = new Long(2);
    			}else if(tipo_doc_id.compareTo("80") == 0 || tipo_doc_id.compareTo("86") == 0) {
    				clnew.cuit2  = json.get("doc").textValue();
    				clnew.cliente_tipo_id = new Long(1);
    			}
    			clnew.save();
    			idCLiente = clnew.id;


    		}

    		Integer nro = new Integer(json.get("nrofactura").textValue());

    		List<RecuperoFactura> rffnro = RecuperoFactura.find.where()
					.eq("numero", NumberUtils.agregarCerosAlaIzquierda(nro,8))
					.eq("puntoventa_id", 7)
					.ne("numero", "847")
					.ne("numero", "848")
					.ne("numero", "2529")
					.ne("numero", "2606")
					.findList();


    		if(rffnro.size() > 0) {

    			rffnro.get(0).cae = json.get("cae").textValue();
    			rffnro.get(0).fecha_vencimiento = DateUtils.formatDate(json.get("fecha_vencimiento").textValue(), "yyyy-MM-dd"); //new Date(json.get("fecha_vencimiento").textValue());
    			rffnro.get(0).id_factura_materno = new Long(json.get("idfactura").asInt());
    			rffnro.get(0).save();

    		}else {

    			RecuperoFactura rf = new RecuperoFactura();

	    		rf.cliente_id = idCLiente;

	    		rf.fecha = DateUtils.formatDate(json.get("fecha_emision").textValue(), "yyyy-MM-dd");
	    		rf.serie = "C";

	    		String nroFactura = json.get("nrofactura").textValue();
	    		int widht = 8 - nroFactura.length();
	    		String formatted = String.format("%0" + widht + "d", Integer.valueOf(nroFactura));





	    		Long tipo_factura = new Long(json.get("tipo_factura").asInt());
	    		if(tipo_factura.compareTo(new Long(0)) == 0) {
	    			tipo_factura = new Long(1);
	    		}else {
	    			tipo_factura = new Long(2);
	    		}

	    		rf.recupero_tipo_pago_id = tipo_factura;
	    		rf.numero= NumberUtils.agregarCerosAlaIzquierda(nro,8);
	    		rf.nombre = null;//?
	    		rf.nota = null;
	    		rf.estado_id = (long) Estado.RECUPERO_FACTURA_BORRADOR;
	    		rf.periodo_id = null;
	    		rf.expediente_id = null;
	    		rf.planilla_id = null;
	    		rf.presupuesto_id = null;
	    		rf.puntoventa_id = 7;

	     		rf.id_factura_materno = new Long(json.get("idfactura").asInt());
	    		rf.condicionventa_id = new Integer(json.get("condventa_id").textValue());
	    		rf.condicioniva_id = new Integer(json.get("condiva_id").textValue());
	    		rf.cae = json.get("cae").textValue();
	    		rf.fecha_vencimiento = DateUtils.formatDate(json.get("fecha_vencimiento").textValue(), "yyyy-MM-dd"); //new Date(json.get("fecha_vencimiento").textValue());
	    		rf.fecha_emision = DateUtils.formatDate(json.get("fecha_emision").textValue(), "yyyy-MM-dd"); //new Date(json.get("fecha_emision").textValue());
	    		rf.fecha_desde = DateUtils.formatDate(json.get("fecha_desde").textValue(), "yyyy-MM-dd"); //new Date(json.get("fecha_desde").textValue());
	    		rf.fecha_hasta = DateUtils.formatDate(json.get("fecha_hasta").textValue(), "yyyy-MM-dd"); //new Date(json.get("fecha_hasta").textValue());
	    		rf.create_usuario_id = new Long(1);
	    		rf.create_date = new Date();

	    		rf.save();

	    		for (JsonNode data : json.withArray("lineas")) {
	    			Logger.debug("-------asJson()------------ "+data.get("productoNombre"));

	    			List<Producto> pe = Producto.find.where().eq("nombre",  data.get("productoNombre").textValue()).findList();
	    			Long idProducto = null;
	    			if(pe.size() > 0) {
	    				idProducto = pe.get(0).id;
	    			}else {

						String slug = data.get("productoNombre").textValue().replace(" ", "").replace(".","").replace("-","").toUpperCase();
						List<Producto> px = Producto.find.where().eq("slug", slug).findList();

						if(px.size() > 0) {
							idProducto = px.get(0).id;
						}else {

							Producto peNew = new Producto();
							peNew.activo =  true ;
							peNew.nombre = data.get("productoNombre").textValue();
							peNew.articulo_id = 3042;
							peNew.categoria_id = 36;
							peNew.tipo_producto_id = 2;
							peNew.udm_id = 1;
							peNew.codigo_rismi = null;
							peNew.save();

							idProducto = peNew.id;
						}
					}




	    			RecuperoFacturaLinea rfl = new RecuperoFacturaLinea();
	    			rfl.recupero_factura_id = rf.id;
	    			rfl.producto_id = idProducto;
	    			rfl.cuenta_analitica_id= new Long(478);
	    			rfl.cuenta_id =new Long(226);
	    			rfl.precio= new BigDecimal(data.get("monto").textValue());
	    			rfl.cantidad=new BigDecimal(data.get("cantidad").textValue());
	    			rfl.udm_id= new Long(1);
	    			rfl.create_usuario_id= new Long(1);
	    			rfl.create_date = new Date();
	    			rfl.save();


	    		}
    		}



    	}catch(Exception e){
    		Logger.debug("------------------------------ "+e);
    	}

    	return ok();
	}
}
