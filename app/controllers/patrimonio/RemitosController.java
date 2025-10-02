package controllers.patrimonio;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.CuentaAnalitica;
import models.Estado;
import models.Factura;
import models.Recepcion;
import models.Remito;
import models.RemitoBaul;
import models.RemitoLinea;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.contabilidad.facturas.acciones.modalCargarOrdenPago;
import views.html.patrimonio.baul.crearRemitoBaul;
import views.html.patrimonio.remitos.*;

@Security.Authenticated(Secured.class)
public class RemitosController extends Controller {
	final static Form<Remito> oForm = form(Remito.class);

	@CheckPermiso(key = "remitosVer")
	public static Result index(){
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		Pagination<Remito> remitos = Remito.page(RequestVar.get("recepcion_id"),
												RequestVar.get("numero"),
												RequestVar.get("acta"),
												RequestVar.get("orden_provision"),
												RequestVar.get("expediente_id"),
												RequestVar.get("producto_id"),
												RequestVar.get("responsable_id"),
												RequestVar.get("proveedor_id"),
												RequestVar.get("tipo_moneda"),
												RequestVar.get("fecha_remito_desde"),
												RequestVar.get("fecha_remito_hasta"),
												RequestVar.get("create_date_desde"),
												RequestVar.get("create_date_hasta"),
												RequestVar.get("deposito_id"),
												RequestVar.get("numeroRecepcion")
												);

		return ok(indexRemitos.render(remitos, d, pf));
	}

	public static Result indexAjax(){
		DynamicForm d = form().bindFromRequest();
		Pagination<Remito> remitos = Remito.page(RequestVar.get("recepcion_id"),
												RequestVar.get("numero"),
												RequestVar.get("acta"),
												RequestVar.get("orden_provision"),
												RequestVar.get("expediente_id"),
												RequestVar.get("producto_id"),
												RequestVar.get("responsable_id"),
												RequestVar.get("proveedor_id"),
												RequestVar.get("tipo_moneda"),
												RequestVar.get("fecha_remito_desde"),
												RequestVar.get("fecha_remito_hasta"),
												RequestVar.get("create_date_desde"),
												RequestVar.get("create_date_hasta"),
												RequestVar.get("deposito_id"),
												RequestVar.get("numeroRecepcion")
												);

		return ok(indexRemitosAjax.render(remitos, d));
	}

	@CheckPermiso(key = "remitosVer")
	public static Result ver(Long id){
		Remito r = Remito.find.byId(id);

		if(r != null) {
			if(!r.controlPermisoDeposito()) {
				flash("error", "El remito de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
			}
			PaginadorFicha pf = new PaginadorFicha(UriTrack.code());
			return ok(verRemito.render(r,pf));
		}else {
			flash("error", "No se encuentra el remito.");
			return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "remitosCrear")
	public static Result crear(Long recepcion_id){
		Form<Remito> rForm = form(Remito.class);

		Recepcion r = Recepcion.find.byId(recepcion_id);
		if(r.acta != null && r.acta.estado_id != Estado.ACTA_ESTADO_BORRADOR) {
			flash("error", "El acta de esta recepción debe estar en estado borrador para agregar remitos.");
			return ok(crearRemito.render(rForm));
		}

		rForm.data().put("recepcion_id", recepcion_id.toString());
		return ok(crearRemito.render(rForm));
	}

	@CheckPermiso(key = "remitosCrear")
	public static Result guardar(){
		Form<Remito> rForm = form(Remito.class).bindFromRequest();

		if(rForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(crearRemito.render(rForm));
		}

		Remito r = rForm.get();

		Recepcion rec = Recepcion.find.byId(r.recepcion_id);

		List<Remito> reclist = Remito.find.where()
				   .eq("numero", r.numero)
				   .eq("recepcion.ordenProvision.ordenCompra.proveedor.id", rec.ordenProvision.ordenCompra.proveedor.id)
				   .findList();

		if(reclist.size() > 0){
			flash("error", "Ya existe este numero de remito para este proveedor.");
			return ok(crearRemito.render(rForm));
		}

		if(rec.acta != null && rec.acta.estado_id != Estado.ACTA_ESTADO_BORRADOR) {
			flash("error", "El acta de esta recepción debe estar en estado borrador para agregar remitos.");
			return ok(crearRemito.render(rForm));
		}


		if(rec.ordenProvision.ordenCompra.fecha_presupueso != null ) {

			if(!r.sin_control_fecha && r.fecha_remito.before(rec.ordenProvision.ordenCompra.fecha_presupueso)) {
	        	flash("error", "La Fecha no puede ser menor a la fecha de PRESUPUESTO.");
				return ok(crearRemito.render(rForm));
	        }

		}

		Date dt =  rec.ordenProvision.ordenCompra.expediente.fecha;
		if(!r.sin_control_fecha && r.fecha_remito.before(dt)) {
        	flash("error", "La Fecha no puede ser menor a la fecha de Expediente.");
			return ok(crearRemito.render(rForm));
        }

		try {

			if(!r.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
			}

			r.create_date = new Date();
			r.create_usuario_id = (long) Usuario.getUsuarioSesion();
			r.save();

			r = Remito.find.byId(r.id);



			List<RemitoBaul> reclistb = RemitoBaul.find.where()
					   .eq("numero", r.numero)
					   .eq("proveedor_id", r.recepcion.ordenProvision.ordenCompra.proveedor_id)
					   .findList();

			if(reclistb.size() > 0){
				for(RemitoBaul rbx:reclistb) {
					rbx.write_date = new Date();
					rbx.write_usuario_id = (long) Usuario.getUsuarioSesion();
					rbx.borrado = true;
					rbx.update();
				}
			}



			flash("success", "Se ha creado el remito número <b>"+r.numero+"</b>");

			return redirect(controllers.patrimonio.routes.RemitosController.ver(r.id)+UriTrack.get("&"));
		} catch (Exception e) {
			flash("error", "Problemas al crear el remito "+e);
			return ok(crearRemito.render(rForm));
		}
	}

	@CheckPermiso(key = "remitosCrear")
	public static Result editar(Long id){

		Remito r = Remito.find.byId(id);

		if(r.recepcion.acta_id != null && (r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_APROBADA || r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_CANCELADA)){
			flash("error", "El remito solo se puede aprobar cuando el acta se encuentra en estado borrador.");
			return redirect(request().getHeader("referer"));
		}
		if(!r.controlPermisoDeposito()) {
			flash("error", "El remito de la orden no corresponde a su institucion asignada.");
			return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
		}

		return ok(editarRemito.render(form(Remito.class).fill(r),r));
	}

	@CheckPermiso(key = "remitosCrear")
	public static Result actualizar(Long id){

		Form<Remito> rForm = form(Remito.class).bindFromRequest();
		Remito rf = rForm.get();
		Remito r = Remito.find.byId(id);

		Integer x = new Integer(r.recepcion.ordenProvision.ordenCompra.proveedor.id.toString());

		List<Remito> reclist = Remito.find.where()
				   .eq("numero", rf.numero)
				   .eq("recepcion.ordenProvision.ordenCompra.proveedor.id", x)
				   .ne("id",id)
				   .findList();

		if(reclist.size() > 0){
			flash("error", "Ya existe este numero de remito para este proveedor.");
			return ok(editarRemito.render(rForm,r));
		}


		if(rForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarRemito.render(rForm,r));
		}

		if(r.recepcion.ordenProvision.ordenCompra.fecha_presupueso != null ) {

			if( !r.sin_control_fecha   && r.fecha_remito.before(r.recepcion.ordenProvision.ordenCompra.fecha_presupueso)) {
	        	flash("error", "La Fecha no puede ser menor a la fecha de PRESUPUESTO.");
				return ok(editarRemito.render(rForm,r));
	        }

		}

		Date dt =  r.recepcion.ordenProvision.ordenCompra.expediente.fecha;
        //Date fechaExpedienteMas7Dias = new Date(dt.getTime() + (7000 * 60 * 60 * 24));
		if(!rf.sin_control_fecha && rf.fecha_remito.before(dt)) {
        	flash("error", "La Fecha no puede ser menor a la fecha de Expediente.");
        	return badRequest(editarRemito.render(rForm,r));
        }

		try {

			r = rForm.get();
			Long idr = rForm.get().id;
			if(!r.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
			}

			r.write_date = new Date();
			r.write_usuario_id = (long) Usuario.getUsuarioSesion();
			r.update();
			flash("success", "El remito se ha modificado correctamente.");

			return redirect(controllers.patrimonio.routes.RemitosController.ver(idr)+UriTrack.get("&"));
		} catch (Exception e) {
			flash("error", "Problemas al modificar el remito."+e);
			return ok(editarRemito.render(rForm,r));
		}

	}

	@CheckPermiso(key = "remitosEliminar")
	public static Result eliminar(Long id){
		Remito r = Remito.find.where().eq("id", id).findUnique();

		if(r.recepcion.acta_id != null || (r.recepcion.acta != null && (r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_APROBADA || r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || r.recepcion.acta.estado_id == Estado.ACTA_ESTADO_CANCELADA))){
			flash("error", "El remito no se puede eliminar. El acta debe estar en estado <b>borrador</b>.");
			return redirect(request().getHeader("referer"));
		}

		String numero = r.numero;
		ObjectNode restJs = Json.newObject();
		Long opId = r.recepcion.orden_provision_id;
		try {
			r.delete();
			flash("success", "Se ha eliminado el remito número <b>"+numero+"</b>.");

			/*
			//Actualiza los totales
			Connection conn = null;
			try {
				conn = play.db.DB.getConnection();
				conn.prepareStatement("SELECT actualiza_totales_ordenes_recepcionados("+opId+")").executeQuery();

			}catch (SQLException e) {
				Logger.error("Error: "+e);
	        } finally {
	            if (conn != null) try { conn.close(); } catch (Exception e) { }
	        }
			*/


			return redirect(controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?"));
		} catch (Exception e) {
			flash("error", "Problemas al eliminar el remito"+e);
			return redirect(controllers.patrimonio.routes.RemitosController.ver(id)+UriTrack.get("&"));
		}
	}


	public static Result eliminarMasivo () {
		flash().clear();

		String url = controllers.patrimonio.routes.RemitosController.index()+UriTrack.get("?");

		List<Integer> rSeleccionados = getSeleccionados();

		List<Integer> oSeleccionados = new ArrayList();
		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado remitos.");
			return ok(url);
		}

		//Guardo las OP
		SqlQuery sqlOps = Ebean.createSqlQuery("select orden_provision_id from remitos r "
				+" inner join recepciones rec on r.recepcion_id = rec.id "
				+" where r.id in (:ids) "
				+" group by orden_provision_id");
		sqlOps.setParameter("ids", rSeleccionados);
		List<SqlRow> list = sqlOps.findList();
		for (SqlRow row : list) {
			oSeleccionados.add(row.getInteger("orden_provision_id"));
		}


		try {
			int count = Ebean.delete(Remito.find.where().in("id", rSeleccionados).findList());
			flash("success", "Se han eliminado <b>"+count+"</b> remito.");

		} catch (Exception e) {
			flash("error", "Problemas al eliminar remitos");
		}


		/*
		Connection conn = null;
		try {
			conn = play.db.DB.getConnection();

			for (Integer opId : oSeleccionados) {
				conn.prepareStatement("SELECT actualiza_totales_ordenes_recepcionados("+opId+")").executeQuery();
			}

		}catch (SQLException e) {
			Logger.error("Error: "+e);
        } finally {
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 */

		return ok();

	}


	public static Result reporteDatosRemitos(){

		List<Integer> rSeleccionados = getSeleccionados();

		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado remitos.");
			return ok(modalReporteRemito.render(null,null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/listaDatosRemitos-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);


			Sheet hoja = libro.createSheet("reporte");

			List<Remito> re = Remito.find.where().in("id", rSeleccionados).findList();

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("N°");
			fila.createCell(1).setCellValue("OP");
			fila.createCell(2).setCellValue("Institucion");
			fila.createCell(3).setCellValue("Expediente");
			fila.createCell(4).setCellValue("Proveedor");
			fila.createCell(5).setCellValue("Fecha");

			fila.createCell(6).setCellValue("Producto");
			fila.createCell(7).setCellValue("Precio");
			fila.createCell(8).setCellValue("Cantidad");
			fila.createCell(9).setCellValue("Total");


			int f = 1;

			boolean errores = false;
			for (Remito m : re) {
				for(RemitoLinea x :m.lineas) {
					fila = hoja.createRow(f);
					for(int c=0;c<11;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(m.numero);
							break;
						case 1:
							celda.setCellValue(m.recepcion.ordenProvision.numero);
							break;
						case 2:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.deposito.nombre);
							break;
						case 3:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
							break;
						case 4:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.proveedor.nombre);
							break;
						case 5:
							celda.setCellValue(DateUtils.formatDate(m.fecha_remito));
							break;

						case 6:
							celda.setCellValue(x.lineaOrden.producto.nombre);
							break;

						case 7:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.lineaOrden.precio.doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;

						case 8:
							celda.setCellValue(x.cantidad.doubleValue());
							break;
						case 9:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;

						default:
							break;
						}
					}
					f++;
				}
				f++;
			}

			if(errores){
				flash("error", "No se puede crear el archivo.");
				return ok(modalReporteRemito.render(null,error));
			}else{

				libro.write(archivoTmp);
				Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
				out.flush();
				out.close();

				flash("success", "El archivo fue creado correctamente.");
				return ok(modalReporteRemito.render(archivo.getPath(),null));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug("zzzzzzzzzz "+e);
		}

		return ok();
	}

	public static Result reporteDatosRemitosGeneral(){

		List<Integer> rSeleccionados = getSeleccionados();

		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado remitos.");
			return ok(modalReporteRemito.render(null,null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/listaDatosRemitos-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);


			Sheet hoja = libro.createSheet("reporte");

			List<Remito> re = Remito.find.where().in("id", rSeleccionados).findList();

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("N°");
			fila.createCell(1).setCellValue("OP");
			fila.createCell(2).setCellValue("Acta");
			fila.createCell(3).setCellValue("Institucion");
			fila.createCell(4).setCellValue("Expediente");
			fila.createCell(5).setCellValue("Proveedor");
			fila.createCell(6).setCellValue("Fecha");
			fila.createCell(7).setCellValue("Total");


			int f = 1;

			boolean errores = false;
			for (Remito m : re) {

					fila = hoja.createRow(f);
					for(int c=0;c<11;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(m.numero);
							break;
						case 1:
							celda.setCellValue(m.recepcion.ordenProvision.numero);
							break;
						case 2:

							String acta = (m.recepcion.acta != null)?m.recepcion.acta.numero:"";
							celda.setCellValue(acta);
							break;
						case 3:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.deposito.nombre);
							break;
						case 4:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
							break;
						case 5:
							celda.setCellValue(m.recepcion.ordenProvision.ordenCompra.proveedor.nombre);
							break;
						case 6:
							celda.setCellValue(DateUtils.formatDate(m.fecha_remito));
							break;

						case 7:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(m.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;

						default:
							break;
						}
					}
					f++;

			}

			if(errores){
				flash("error", "No se puede crear el archivo.");
				return ok(modalReporteRemito.render(null,error));
			}else{

				libro.write(archivoTmp);
				Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
				out.flush();
				out.close();

				flash("success", "El archivo fue creado correctamente.");
				return ok(modalReporteRemito.render(archivo.getPath(),null));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug("zzzzzzzzzz "+e);
		}

		return ok();
	}

	@CheckPermiso(key = "cambiarRecepcionDeRemitos")
	public static Result modalCambiarRecepcion() {

		List<Integer> rSeleccionados = getSeleccionados();
		Long idOrdenProvision = null;

		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado remitos.");
			return ok(modalCambiarRecepcion.render(null,null));
		}

		String sqlOrdenDistinta = "SELECT re.orden_provision_id as id FROM remitos r "+
								  "INNER JOIN recepciones re on r.recepcion_id = re.id "+
								  "WHERE r.id in(:ids) GROUP BY re.orden_provision_id" ;

		List<SqlRow> remitosOrdenDistinta = Ebean.createSqlQuery(sqlOrdenDistinta).setParameter("ids", rSeleccionados).findList();

		if(remitosOrdenDistinta.size() > 1) {
			flash("error", "Debe seleccionar remitos de la misma OP.");
			return ok(modalCambiarRecepcion.render(null,null));
		}else {
			idOrdenProvision = remitosOrdenDistinta.get(0).getLong("id");
		}

		return ok(modalCambiarRecepcion.render(form().bindFromRequest(),idOrdenProvision));
	}

	@CheckPermiso(key = "cambiarRecepcionDeRemitos")
	public static Result cambiarRecepcion() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();


		List<Integer> remSeleccionados = getSeleccionados();


		Integer idRecepcion = null;
		if(!request().body().asFormUrlEncoded().get("recepcion_id_modal")[0].isEmpty()){
			idRecepcion = new Integer(request().body().asFormUrlEncoded().get("recepcion_id_modal")[0]);
		}else {
			flash("error", "No se puede modificar los registros. No se encuentra la recepcion");
			return ok(modalCambiarRecepcion.render(d,null));
		}



		Long idOrdenProvision = null;
		if(!request().body().asFormUrlEncoded().get("idOrdenProvision_modal")[0].isEmpty()){
			idOrdenProvision = new Long(request().body().asFormUrlEncoded().get("idOrdenProvision_modal")[0]);
		}else {
			flash("error", "No se puede modificar los registros. No se encuentra la orden de provision");
			return ok(modalCambiarRecepcion.render(d,null));
		}

		Recepcion rec = Recepcion.find.byId(idRecepcion.longValue());

		if(rec == null) {
			flash("error", "No se puede modificar los registros. No se encuentra la recepcion");
			return ok(modalCambiarRecepcion.render(d,null));
		}

		if(rec.acta_id != null) {
			flash("error", "No se puede modificar remitos a recepciones q tengan asiganda un acta.");
			return ok(modalCambiarRecepcion.render(d,idOrdenProvision));
		}

		if(d.hasErrors())
			return ok(modalCambiarRecepcion.render(d,idOrdenProvision));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Remito.cambiarRecepcion(idRecepcion, remSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ remSeleccionados.size() +" seleccionados.");
			result.put("html", modalCambiarRecepcion.render(d,idOrdenProvision).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCambiarRecepcion.render(d,idOrdenProvision));
		}


	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

}
