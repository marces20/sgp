package controllers.contabilidad;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Cuenta;
import models.Factura;
import models.FacturaLinea;
import models.FacturaLineaImpuesto;
import models.Grupo;
import models.ProveedorAtributo;
import models.TipoCuenta;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ArrayUtils;
import utils.NumberUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.facturasLineasImpuestos.crearLineaImpuesto;
import views.html.contabilidad.facturasLineasImpuestos.editarLineaImpuesto;
import views.html.contabilidad.facturasLineasImpuestos.verLineaImpuesto;
import views.html.contabilidad.facturasLineasImpuestos.indexFacturaLineaImpuesto;

@Security.Authenticated(Secured.class)
public class FacturasLineasImpuestosController extends Controller {
	
	final static Form<FacturaLineaImpuesto> lineaForm = form(FacturaLineaImpuesto.class);

	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<FacturaLineaImpuesto> lineas = FacturaLineaImpuesto.page(facturaId);

		return ok(indexFacturaLineaImpuesto.render(lineas, editable,facturaId));
	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result crear(String facturaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("factura_id", facturaId);
		Form<FacturaLineaImpuesto> linea = form(FacturaLineaImpuesto.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaImpuesto.render(linea));
	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			FacturaLineaImpuesto.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result precalcular(Long id) throws ParseException {
		
		String tipoProductoCalculo = RequestVar.get("tipoProductoCalculo");
		String tipoAlicuota = RequestVar.get("tipoAlicuota");
		BigDecimal alicuota = FacturaLineaImpuesto.MONTO_CALCULO_NETO;
		Integer tipo = null;
		Factura f = Factura.find.byId(id);
		FacturaLineaImpuesto fl;
		String htmlLinea = "";
		ProveedorAtributo pa = f.proveedor.getLastAtributo();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 
		Date hoy = format.parse(format.format(new Date()));
		
		if(tipoProductoCalculo.compareToIgnoreCase("bien") == 0){
			tipo = 2;
		}else if(tipoProductoCalculo.compareToIgnoreCase("seriviciosAgentes") == 0){
			tipo = 3;
		}else{ 
			tipo = 1;
		}
		
		if(tipoAlicuota.compareToIgnoreCase("2") == 0){
			alicuota = FacturaLineaImpuesto.MONTO_ALICUOTA_10;
		}else if(tipoAlicuota.compareToIgnoreCase("3") == 0){
			alicuota = null;
		}
		
		
		if(pa != null){
			if(pa.afip_condicion != null){
				
				/*BigDecimal total = new BigDecimal(0);
				BigDecimal base = new BigDecimal(0);
				
				if(pa.afip_condicion.compareTo(2) == 0){//responsable
					total = FacturaLineaImpuesto.preCalcularMontoNetoRetMunicipal(f.getBase()).multiply(FacturaLineaImpuesto.MONTO_MUNICIPAL_DERECHO_INSPECCION);
					base = FacturaLineaImpuesto.preCalcularMontoNetoRetMunicipal(f.getBase());
				}else if(pa.afip_condicion.compareTo(1) == 0){//monotributo
					total = f.getBase().multiply(FacturaLineaImpuesto.MONTO_MUNICIPAL_DERECHO_INSPECCION);
					base = f.getBase();
				}
				
				if(f.getBase().compareTo(FacturaLineaImpuesto.MONTO_MINIMO_MUNICIPAL_DERECHO_INSPECCION) >= 0){
					BigDecimal montorm = new BigDecimal(0); 
					BigDecimal baserm = new BigDecimal(0); 
					String secrm = "RM";
					if(pa.exento_municipal.compareTo(1) != 0){
						montorm = total.setScale(2, BigDecimal.ROUND_HALF_UP); 
						baserm = base.setScale(2, BigDecimal.ROUND_HALF_UP);
						secrm = FacturaLineaImpuesto.getSecuenciaRetMunicipal().toString();
					}
					
					
					fl = new FacturaLineaImpuesto();
					fl.base = baserm;
					fl.monto = montorm;
					fl.cuenta_id = Cuenta.RET_MUNICIPAL_DERECHO_INSPECCION;
					fl.nombre = secrm;
					fl.factura_id = id;
					fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					fl.create_date = new Date();
					fl.save();
					FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
					htmlLinea += verLineaImpuesto.render(linea, true).toString();
				} */
			}
			
			if(pa.afip_ganancia){
				//SI EL PROVEEDOR TIENE MARCADO GANANCIAS Y ES MAYOR A $20.. AGREGA
				
				BigDecimal totalGciasBienes = new BigDecimal(0);
				BigDecimal totalGciasServicios = new BigDecimal(0);
				BigDecimal totalNetoServicios = new BigDecimal(0); 
				BigDecimal totalNetoBienes = new BigDecimal(0); 
				
				if(tipoProductoCalculo.compareToIgnoreCase("bien") == 0){
					//BIENES DE CONSUMO
					//BigDecimal totalBienes = Factura.getTotalPorBienes(f.id);
					BigDecimal totalBienes = f.getBase();
					if(totalBienes.compareTo(BigDecimal.ZERO) > 0){
						totalNetoBienes = FacturaLineaImpuesto.preCalcularMontoNeto(f,totalBienes,false,false,alicuota);
						totalGciasBienes = FacturaLineaImpuesto.preCalcularGanacias(totalNetoBienes);
					}
				}else if(tipoProductoCalculo.compareToIgnoreCase("seriviciosAgentes") == 0){
					BigDecimal totalServicios = f.getBase(); 
					if(totalServicios.compareTo(BigDecimal.ZERO) > 0){
						totalNetoServicios = FacturaLineaImpuesto.preCalcularMontoNeto(f,totalServicios,true,true,alicuota);
						totalGciasServicios = FacturaLineaImpuesto.preCalcularGanacias(totalNetoServicios);
					}
				}else{ 
				
					//SERVICIOS
					//BigDecimal totalServicios = Factura.getTotalPorServicios(f.id);
					BigDecimal totalServicios = f.getBase(); 
					if(totalServicios.compareTo(BigDecimal.ZERO) > 0){
						totalNetoServicios = FacturaLineaImpuesto.preCalcularMontoNeto(f,totalServicios,true,false,alicuota);
						totalGciasServicios = FacturaLineaImpuesto.preCalcularGanacias(totalNetoServicios);
					}
				} 
				
				BigDecimal totalGcias = totalGciasBienes.add(totalGciasServicios);
				
				if(totalGcias.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_GANANCIAS_4245_19) >= 0){
					if(pa.fecha_extento_afip_gcia != null && pa.fecha_extento_afip_gcia.compareTo(hoy) >= 0) {
						Logger.debug("ESTA EXENTO DE GCIAS");
					}else {
						fl = new FacturaLineaImpuesto();
						fl.base = totalNetoServicios.add(totalNetoBienes);
						fl.monto = totalGcias;
						//fl.cuenta_id = Cuenta.RET_GCIAS;
						fl.cuenta_id = Cuenta.RET_GCIAS_4245_19;
						fl.nombre = FacturaLineaImpuesto.getSecuenciaGanancias().toString();
						//fl.nombre = "GCIAS";
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}
			}
			
			if(!pa.exento_sello) {
				BigDecimal sellos = FacturaLineaImpuesto.preCalcularSellos(f);
				if(sellos.compareTo(BigDecimal.ZERO) > 0){
					//SI NO TIENE UN FACTURA CON AL MISMA ORDEN QUE YA TENGA SELLOS O TIENE MARCADO LA FACTURA EL CAMPO PRODUCCION AGREGA
					
					if(pa.fecha_extento_dgr_sellos != null && pa.fecha_extento_dgr_sellos.compareTo(hoy) >= 0) {
						Logger.debug("ESTA EXENTO DE SELLOS");
					}else {
						fl = new FacturaLineaImpuesto();
						fl.base = (f.orden != null && f.orden.tipo_moneda == null  && (f.tipo_cuenta_id.compareTo(TipoCuenta.FONDO_PERMANENTE_OBERA) != 0) && (f.tipo_cuenta_id.compareTo(TipoCuenta.FONDO_PERMANENTE_MATERNO) != 0))?f.orden.total:f.getBase();
						fl.monto = sellos;
						fl.cuenta_id = Cuenta.RET_DGR_SELLOS;
						fl.nombre = FacturaLineaImpuesto.getSecuenciaSellos().toString();
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}
			}
			
			BigDecimal suss = new BigDecimal(0);
			if((pa.fecha_extento_afip_suss != null && pa.fecha_extento_afip_suss.compareTo(hoy) >= 0) || (tipoAlicuota.compareToIgnoreCase("3") == 0)) {
				Logger.debug("ESTA EXENTO DE SUSS");
			}else {
				if(pa.suss_tipo != null && pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_COMUN)){
					suss = FacturaLineaImpuesto.preCalcularSuss(f,alicuota);
					if(suss.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_SUSS_3883) >= 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = suss;
						fl.cuenta_id = Cuenta.RET_SUSS1;
						fl.nombre = "SUSS";
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}else if(pa.suss_tipo != null && pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_LIMPIEZA)){
					suss = FacturaLineaImpuesto.preCalcularSussLimpieza(f,alicuota);
					if(suss.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_SUSS_3883) >= 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = suss;
						fl.cuenta_id = Cuenta.RET_LIMPIEZA;
						fl.nombre = "SUSS";
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}else if(pa.suss_tipo != null && pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_SERVICIO)){
					suss = FacturaLineaImpuesto.preCalcularSussSeguridad(f,alicuota);
					if(suss.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_SUSS_3883) >= 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = suss;
						fl.cuenta_id = Cuenta.RET_SEGURIDAD;
						fl.nombre = "SUSS";
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}else if(pa.suss_tipo != null && pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_CONSTRUCTORA)){
					suss = FacturaLineaImpuesto.preCalcularSussConstructora(f,alicuota);
					
					if(suss.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_SUSS_3883) >= 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = suss;
						fl.cuenta_id = Cuenta.RET_SUSS_2682_09;
						fl.nombre = "SUSS";
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}
				
				if(pa.suss_tipo != null && (pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_LIMPIEZA) || pa.suss_tipo.equals(ProveedorAtributo.SUSS_TIPO_SERVICIO))){
					BigDecimal iva = FacturaLineaImpuesto.preCalcularIva(f);
					if(FacturaLineaImpuesto.preCalcularIva(f).compareTo(BigDecimal.ZERO) > 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = iva;
						fl.cuenta_id = Cuenta.RET_IVA;
						fl.nombre = FacturaLineaImpuesto.getSecuenciaIva().toString();
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}
			}
			//if( (pa.dgr_condicion != null && pa.dgr_condicion.equals(ProveedorAtributo.DGR_CONDICION_DIRECTO)) || (pa.fecha_extento_dgr != null && pa.fecha_extento_dgr.compareTo(new Date()) <= 0)){
			if(pa.fecha_extento_dgr_iibb != null && pa.fecha_extento_dgr_iibb.compareTo(hoy) >= 0) {
				Logger.debug("ESTA EXENTO DE IIBB");
				
			}else if(pa.dgr_condicion != null && pa.dgr_condicion.equals(ProveedorAtributo.DGR_CONDICION_CM)){
				BigDecimal dgrCm = FacturaLineaImpuesto.preCalcularDgrCm(f,alicuota);
				if(dgrCm.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_DGR) >= 0){
					fl = new FacturaLineaImpuesto();
					fl.base = (pa.afip_condicion == 1)?f.getBase():FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
					fl.monto = dgrCm;
					fl.cuenta_id = Cuenta.RET_IIBB;
					fl.nombre = FacturaLineaImpuesto.getSecuenciaIIBB().toString();
					fl.factura_id = id;
					fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					fl.create_date = new Date();
					fl.tipo = tipo;
					fl.save();
					FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
					htmlLinea += verLineaImpuesto.render(linea, true).toString();
				}
			}else if(pa.dgr_condicion != null && pa.dgr_condicion.equals(ProveedorAtributo.DGR_CONDICION_NOCM)){
				BigDecimal dgrNoCm = FacturaLineaImpuesto.preCalcularDgrNoCm(f,alicuota);
				if(dgrNoCm.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_DGR) >= 0){
					BigDecimal dgrDirecto = FacturaLineaImpuesto.preCalcularDgrNoCm(f,alicuota);
					if(dgrDirecto.compareTo(FacturaLineaImpuesto.MONTO_MINIMO_DGR) >= 0){
						fl = new FacturaLineaImpuesto();
						fl.base = FacturaLineaImpuesto.preCalcularMontoSinIva(f,alicuota);
						fl.monto = dgrDirecto;
						fl.cuenta_id = Cuenta.RET_IIBB_331;
						fl.nombre = FacturaLineaImpuesto.getSecuenciaIIBB().toString();
						fl.factura_id = id;
						fl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						fl.create_date = new Date();
						fl.tipo = tipo;
						fl.save();
						FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", fl.id).findUnique();
						htmlLinea += verLineaImpuesto.render(linea, true).toString();
					}
				}
			}
			
			ObjectNode restJs = Json.newObject();
			restJs.put("success", true);
			restJs.put("nuevo", true);
			restJs.put("html", htmlLinea.toString());
			return ok(restJs);
			
		}else{
			ObjectNode restJs = Json.newObject();
			restJs.put("success", false);
			restJs.put("error", true);
			restJs.put("html","El proveedor no tiene cargado atributos");
			return ok(restJs);
		}
	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result guardar() {
		Form<FacturaLineaImpuesto> lineaForm = form(FacturaLineaImpuesto.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaImpuesto.render(lineaForm));
			} else {
				FacturaLineaImpuesto f = lineaForm.get();
				
				if(ArrayUtils.contains(Cuenta.CUENTAS_INACTIVAS,f.cuenta_id)) {
					flash("error", "Esta cuenta se encuentra inactiva");
					return ok(crearLineaImpuesto.render(lineaForm));
				}
				
				if(f.cuenta_id.compareTo(Cuenta.RET_GCIAS_4245) == 0 || f.cuenta_id.compareTo(Cuenta.RET_GCIAS_4245_19) == 0) {
					
					if(!NumberUtils.isInteger(f.nombre)) {
						flash("error", "Debe ingresar una numero para esta cuenta en el numero de comprobante.");
						return ok(crearLineaImpuesto.render(lineaForm));
					}
					
					List<FacturaLineaImpuesto> fx =FacturaLineaImpuesto.find.where()
												  .disjunction()
												  .eq("cuenta_id", Cuenta.RET_GCIAS_4245)
												  .eq("cuenta_id", Cuenta.RET_GCIAS_4245_19)
												  .endJunction()
												  .eq("nombre",f.nombre)
												  .findList();
					if(fx.size() > 0) {
						flash("error", "Ya existe ese numero de comprobante para esta cuenta");
						return ok(crearLineaImpuesto.render(lineaForm));
					}
				
				}
				
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaImpuesto.render(lineaForm));
		}
		
		FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaImpuesto.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result editar(Long id) {
		flash().clear();
		FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.byId(id);
		return ok(editarLineaImpuesto.render(lineaForm.fill(linea)));
	}
	
	@CheckPermiso(key = "facturasCargarRetencones")
	public static Result actualizar() {
		
		Form<FacturaLineaImpuesto> lineaForm = form(FacturaLineaImpuesto.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaImpuesto.render(lineaForm));
			} else {
				FacturaLineaImpuesto f = lineaForm.get();
				
				if(ArrayUtils.contains(Cuenta.CUENTAS_INACTIVAS,f.cuenta_id)) {
					flash("error", "Esta cuenta se encuentra inactiva");
					return ok(crearLineaImpuesto.render(lineaForm));
				}
				
				if(f.cuenta_id.compareTo(Cuenta.RET_GCIAS_4245) == 0 || f.cuenta_id.compareTo(Cuenta.RET_GCIAS_4245_19)  == 0) {
					
					if(!NumberUtils.isInteger(f.nombre)) {
						flash("error", "Debe ingresar una numero para esta cuenta en el numero de comprobante.");
						return ok(crearLineaImpuesto.render(lineaForm));
					}
					
					List<FacturaLineaImpuesto> fx =FacturaLineaImpuesto.find.where().ne("id", f.id)
												   .disjunction()
												   .eq("cuenta_id", Cuenta.RET_GCIAS_4245)
												   .eq("cuenta_id", Cuenta.RET_GCIAS_4245_19)
												   .endJunction()
												   .eq("nombre",f.nombre)
												   .findList();
					if(fx.size() > 0) {
						flash("error", "Ya existe ese numero de comprobante para esta cuenta");
						return ok(crearLineaImpuesto.render(lineaForm));
					}
				
				}
				
				
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaImpuesto.render(lineaForm));
		}
		
		FacturaLineaImpuesto linea = FacturaLineaImpuesto.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaImpuesto.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result getSecuenciaRetencionSellos(){
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		Long s = FacturaLineaImpuesto.getSecuenciaSellos();
		
		if(s == null || s.equals(0)) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la secuencia");
		} else {
			restJs.put("success", true);
			restJs.put("sec", s);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result getSecuenciaGanancias(){
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		Long s = FacturaLineaImpuesto.getSecuenciaGanancias();
		
		if(s == null || s.equals(0)) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la secuencia");
		} else {
			restJs.put("success", true);
			restJs.put("sec", s);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result getSecuenciaIIBB(){
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		Long s = FacturaLineaImpuesto.getSecuenciaIIBB();
		
		if(s == null || s.equals(0)) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la secuencia");
		} else {
			restJs.put("success", true);
			restJs.put("sec", s);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result getSecuenciaIva(){
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		Long s = FacturaLineaImpuesto.getSecuenciaIva();
		
		if(s == null || s.equals(0)) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la secuencia");
		} else {
			restJs.put("success", true);
			restJs.put("sec", s);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result getSecuenciaRetencionMunicipal(){
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		Long s = FacturaLineaImpuesto.getSecuenciaRetMunicipal();
		
		if(s == null || s.equals(0)) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la secuencia");
		} else {
			restJs.put("success", true);
			restJs.put("sec", s);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
}
