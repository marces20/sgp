package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Cliente;
import models.ClienteTipo;
import models.DireccionCliente;
import models.DireccionProveedor;
import models.Estado;
import models.Factura;
import models.OrdenLineaCliente;
import models.Proveedor;
import models.Usuario;
import models.auth.Permiso;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import utils.validation.RequiredValidation;
import utils.validation.Validator;
import views.html.compras.clientes.*;
import views.html.compras.proveedores.formProvDirecciones;
import views.html.contabilidad.facturas.acciones.modalMarcadoresMasivos;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class ClientesController extends Controller {
	
	final static Form<Cliente> clienteForm = form(Cliente.class);
	
	public static Result URL_LISTA = redirect(
			controllers.compras.routes.ClientesController.index()
	);
	
	@CheckPermiso(key = "clientesVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(
				 indexCliente.render(
						 Cliente.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("idPaciente"),
								 RequestVar.get("dni"),
								 RequestVar.get("cuit"),
								 RequestVar.get("cliente_tipo_id")
								 ),
								 d));
	}
	
	public static Result ver(Long id) {
		Cliente cliente = Cliente.find.byId(id);
		
		List<OrdenLineaCliente> olc = null;
		
		if(Permiso.check("verEstadosClientes")) {
			olc = OrdenLineaCliente.find.where().eq("cliente_id", cliente.id).eq("ordenLinea.orden.estado_id", Estado.ORDEN_ESTADO_APROBADO).findList();
		}
		return ok(verCliente.render(clienteForm.fill(cliente),cliente,olc));
	}
	
	@CheckPermiso(key = "clientesEliminar")
	public static Result eliminar(Long id){
		try {
			Cliente.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro.");
		} catch (PersistenceException pe) {
			System.out.println(pe);
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro.");
		}

		return URL_LISTA;
	}
	
	@CheckPermiso(key = "clientesCrear")
	public static Result crear() {
		return ok(crearCliente.render(clienteForm));
	}

	@CheckPermiso(key = "clientesCrear")
	public static Result guardar() {
		Form<Cliente> clienteForm = form(Cliente.class).bindFromRequest();
		
		formValidations(clienteForm);
		
		if(clienteForm.hasErrors()) {
			flash("error", "Compruebe los errores en el formulario.");
			return badRequest(crearCliente.render(clienteForm));
		}
		
		try {
			Cliente p =  clienteForm.get();
			if(p.cliente_tipo_id != null){
				if(p.cliente_tipo_id.compareTo(ClienteTipo.OBRAS_SOCIALES) == 0 || 
				   p.cliente_tipo_id.compareTo(ClienteTipo.PREPAGAS) == 0 || 
				   p.cliente_tipo_id.compareTo(ClienteTipo.SEGUROS) == 0 ||
				   p.cliente_tipo_id.compareTo(ClienteTipo.EMPLEADORES) == 0){
					
					if(p.cuit2 == null || p.cuit2.isEmpty()){
						flash("error", "Debe ingresar un CUIT para este tipo de cliente.");
						return badRequest(crearCliente.render(clienteForm));
					}else{
						List<Cliente> cl = Cliente.find.where().eq("cuit2",p.cuit2).findList();
						if(cl.size() > 0){
							flash("error", "Ya existe un Cliente con este CUIT.");
							return badRequest(crearCliente.render(clienteForm));
						}
					}
					
				}else if(p.cliente_tipo_id.compareTo(ClienteTipo.PACIENTES) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.PARTICULARES_ROBOTICA) == 0){
					if(p.obrasocial_id == null){
						flash("error", "Debe ingresar una OBRA SOCIAL.");
						return badRequest(crearCliente.render(clienteForm));
					}
					
					if(p.dni == null){
						flash("error", "Debe ingresar un DNI para este tipo de cliente.");
						return badRequest(crearCliente.render(clienteForm));
					}else{
						List<Cliente> cl = Cliente.find.where().eq("dni",p.dni).findList();
						if(cl.size() > 0){
							flash("error", "Ya existe un Cliente con este DNI.");
							return badRequest(crearCliente.render(clienteForm));
						}
					}
					if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
						flash("error", "Debe ingresar un ID PACIENTE para este tipo de cliente.");
						return badRequest(crearCliente.render(clienteForm));
					}else{
						List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).findList();
						if(cl.size() > 0){
							flash("error", "Ya existe un Cliente con este ID PACIENTE.");
							return badRequest(crearCliente.render(clienteForm));
						}
					}
				}else if(p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS_SIN_RESIDENCIA) == 0){
					/*if(p.referencia == null || p.referencia.isEmpty() || p.referencia_2 == null || p.referencia_2.isEmpty()){
						flash("error", "Debe ingresar una REFERENCIA para este tipo de cliente EXTRANJEROS.");
						return badRequest(crearCliente.render(clienteForm));
					}*/
					if(p.cie == null || p.cie.isEmpty()){
						flash("error", "Debe ingresar un CIE para este tipo de cliente EXTRANJEROS.");
						return badRequest(crearCliente.render(clienteForm));
					}
					if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
						flash("error", "Debe ingresar un ID PACIENTE para este tipo de cliente.");
						return badRequest(crearCliente.render(clienteForm));
					}else{
						List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).findList();
						if(cl.size() > 0){
							flash("error", "Ya existe un Cliente con este ID PACIENTE.");
							return badRequest(crearCliente.render(clienteForm));
						}
					}
				}
			}			
			
			p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			p.create_date = new Date();
			p.activo = true;
			p.save();
			
			flash("success", "El registro se almacenó correctamente.");
			return redirect(controllers.compras.routes.ClientesController.ver(p.id) );
		} catch (PersistenceException pe){
			System.out.println(pe);
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(crearCliente.render(clienteForm));
		}
		

	}
	
	@CheckPermiso(key = "clientesCrear")
	public static Result editar(Long id) {
		Cliente cliente = Cliente.find.byId(id);
		
		return ok(editarCliente.render(clienteForm.fill(cliente)));
	}
	
	@CheckPermiso(key = "clientesCrear")
	public static Result actualizar() {
		Form<Cliente> clienteForm = form(Cliente.class).bindFromRequest();

		formValidations(clienteForm);
		
		if(clienteForm.hasErrors()) {
			flash("error", "Error en formulario ");
			 
			return badRequest(editarCliente.render(clienteForm));
		} else {
			try {
				Cliente p =  clienteForm.get();
				
				if(p.cliente_tipo_id != null){
					if(p.cliente_tipo_id.compareTo(ClienteTipo.OBRAS_SOCIALES) == 0 || 
					   p.cliente_tipo_id.compareTo(ClienteTipo.PREPAGAS) == 0 || 
					   p.cliente_tipo_id.compareTo(ClienteTipo.SEGUROS) == 0 ||
					   p.cliente_tipo_id.compareTo(ClienteTipo.EMPLEADORES) == 0){
						
						if(p.cuit2 == null || p.cuit2.isEmpty()){
							flash("error", "Debe ingresar un CUIT para este tipo de cliente.");
							return badRequest(editarCliente.render(clienteForm));
						}else{
							List<Cliente> cl = Cliente.find.where().eq("cuit2",p.cuit2).ne("id",p.id).findList();
							if(cl.size() > 0){
								flash("error", "Ya existe un Cliente con este CUIT.");
								return badRequest(editarCliente.render(clienteForm));
							}
						}
						
					}else if(p.cliente_tipo_id.compareTo(ClienteTipo.OTROS) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.PACIENTES) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.PARTICULARES_ROBOTICA) == 0){
						if(p.obrasocial_id == null){
							flash("error", "Debe ingresar una OBRA SOCIAL.");
							return badRequest(editarCliente.render(clienteForm));
						}
						if(p.dni == null){
							flash("error", "Debe ingresar un DNI para este tipo de cliente.");
							return badRequest(editarCliente.render(clienteForm));
						}else{
							List<Cliente> cl = Cliente.find.where().eq("dni",p.dni).ne("id",p.id).findList();
							if(cl.size() > 0){
								flash("error", "Ya existe un Cliente con este DNI.");
								return badRequest(editarCliente.render(clienteForm));
							}
						}
						if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
							flash("error", "Debe ingresar un ID PACIENTE para este tipo de cliente.");
							return badRequest(editarCliente.render(clienteForm));
						}else{
							List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).ne("id",p.id).findList();
							 
							if(cl.size() > 0){
								flash("error", "Ya existe un Cliente con este ID PACIENTE.");
								return badRequest(editarCliente.render(clienteForm));
							}
						}
					}else if(p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS_SIN_RESIDENCIA) == 0){
						/*if(p.referencia == null || p.referencia.isEmpty() || p.referencia_2 == null || p.referencia_2.isEmpty()){
							flash("error", "Debe ingresar una REFERENCIA para este tipo de cliente EXTRANJEROS.");
							return badRequest(editarCliente.render(clienteForm));
						}*/
						if(p.cie == null || p.cie.isEmpty()){
							flash("error", "Debe ingresar un CIE para este tipo de cliente EXTRANJEROS.");
							return badRequest(crearCliente.render(clienteForm));
						}
						if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
							flash("error", "Debe ingresar un ID PACIENTE para este tipo de cliente.");
							return badRequest(editarCliente.render(clienteForm));
						}else{
							List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).ne("id",p.id).findList();
							if(cl.size() > 0){
								flash("error", "Ya existe un Cliente con este ID PACIENTE.");
								return badRequest(editarCliente.render(clienteForm));
							}
						}
					}
				}			
				
				p.cuit2 = (clienteForm.get().cuit2 != null)?p.cuit2:"";
				p.dni = (clienteForm.get().dni != null)?p.dni:0;
				p.id_paciente_rismi  = (clienteForm.get().id_paciente_rismi != null)?p.id_paciente_rismi:"";
				
				p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.write_date = new Date();
				p.update();
				flash("success", "El registro se ha modificado correctamente.");
				return redirect(controllers.compras.routes.ClientesController.ver(Long.parseLong(clienteForm.data().get("id"))));
			} catch (PersistenceException pe){
				System.out.println(pe);
				flash("error", "No se ha podido almacenar el registro.");
				return redirect(controllers.compras.routes.ClientesController.editar(Long.parseLong(clienteForm.data().get("id"))));
			}
		}
	}
	
    @CheckPermiso(key = "proveedoresCrear")
	public static Result actualizarContacto() {
		Form<DireccionCliente> clienteForm = form(DireccionCliente.class).bindFromRequest();

		if(clienteForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(formClienteContacto.render(clienteForm, Long.parseLong(clienteForm.data().get("cliente_id")), true));
		} else {
			DireccionCliente dp = clienteForm.get();
			
			if(dp.id == null) {
				dp.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				dp.create_date = new Date();
				dp.save();
			} else {
				dp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				dp.write_date = new Date();
				dp.update();
			}
						
			ObjectNode restJs = Json.newObject();
			restJs.put("success", true);
			restJs.put("redirect", controllers.compras.routes.ClientesController.ver( Long.parseLong(clienteForm.data().get("cliente_id"))).toString() );
			return ok(restJs);
		}
	}
	
	public static Result formularioContacto(Long clienteId, Long id) {
		Form<DireccionCliente> fp = form(DireccionCliente.class);
		
		if(id > 0){
			DireccionCliente p = DireccionCliente.find.byId(id);
			p.cliente_id = clienteId;
			return ok(formClienteContacto.render( fp.fill(p), clienteId, true ));
		}

		return ok(formClienteContacto.render(fp, clienteId, true));
	}   
	
	
	public static Result eliminarContacto(Long id, Long cId){
		
		if( DireccionCliente.find.where().eq("cliente_id", id).findRowCount() > 1 ){
			try {
				DireccionCliente.find.byId(cId).delete();
				flash("success", "Se ha eliminado el registro.");
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el registro.");
			}
		} else {
			flash("error", "No se puede eliminar el único contacto existente.");
		}

		return redirect(controllers.compras.routes.ClientesController.editar(id));
	}
	
	private static Form<Cliente> formValidations(Form<Cliente> filledForm) {
		Validator v = new Validator(filledForm);
		v.add(new RequiredValidation("direcciones[0].localidad.id", "Localidad requerida"));
		return v.validate();
	}	
	
	public static Result suggestCliente(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cliente = rpta.arrayNode();
	    
	    Cliente ad = new Cliente();
		 
		for(Cliente a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        //String b = (a.referencia != null)?"ID:"+a.referencia.toString():"";
	        String b = "";
	        restJs.put("value",a.nombre);
	        restJs.put("info", "id: "+a.id_paciente_rismi);
	        cliente.add(restJs);
		}
		 
		ObjectNode response = Json.newObject();
		response.put("results", cliente);
		 
		return ok(response);
	}
	
	public static Result modalBuscar() {
    	Pagination<Cliente> p = new Pagination<Cliente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Cliente.find.where().eq("activo", true).ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaClientes.render(p, form().bindFromRequest()) );
	}
	
	public static Result modalCarga() {
		return ok(modalCargaClientes.render(clienteForm));
	}
	
	@CheckPermiso(key = "clientesCrear")
	public static Result guardarDesdeModal() {
		Form<Cliente> clienteForm = form(Cliente.class).bindFromRequest();
		
		formValidations(clienteForm);
		
		if(clienteForm.hasErrors()) {
			flash("error", "Compruebe los errores en el formulario.");
			return ok(modalCargaClientes.render(clienteForm));
		}
		
		try {
			
			ObjectNode result = Json.newObject();
			try {
				Cliente p =  clienteForm.get();
				boolean error = false;
				String errorStr = "";
				
				if(p.cliente_tipo_id != null){
					if(p.cliente_tipo_id.compareTo(ClienteTipo.OBRAS_SOCIALES) == 0 || 
					   p.cliente_tipo_id.compareTo(ClienteTipo.PREPAGAS) == 0 || 
					   p.cliente_tipo_id.compareTo(ClienteTipo.SEGUROS) == 0 ||
					   p.cliente_tipo_id.compareTo(ClienteTipo.EMPLEADORES) == 0){
						
						if(p.cuit2 == null || p.cuit2.isEmpty()){
							error = true;
							errorStr += "Debe ingresar un CUIT para este tipo de cliente.";
						}else{
							List<Cliente> cl = Cliente.find.where().eq("cuit2",p.cuit2).findList();
							if(cl.size() > 0){
								error = true;
								errorStr += "Ya existe un Cliente con este CUIT.";
							}
						}
						
					}else if(p.cliente_tipo_id.compareTo(ClienteTipo.PACIENTES) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.PARTICULARES_ROBOTICA) == 0){
						if(p.obrasocial_id == null){
							error = true;
							errorStr += "Debe ingresar una OBRA SOCIAL.";
						}
						if(p.dni == null){
							error = true;
							errorStr += "Debe ingresar un DNI para este tipo de cliente.";
						}else{
							List<Cliente> cl = Cliente.find.where().eq("dni",p.dni).findList();
							if(cl.size() > 0){
								error = true;
								errorStr += "Ya existe un Cliente con este DNI.";
							}
						}
						if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
							error = true;
							errorStr += "Debe ingresar un ID PACIENTE para este tipo de cliente.";
						}else{
							List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).findList();
							if(cl.size() > 0){
								error = true;
								errorStr += "Ya existe un Cliente con este ID PACIENTE.";
							}
						}
					}else if(p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS) == 0 || p.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS_SIN_RESIDENCIA) == 0){
						if(p.referencia == null || p.referencia.isEmpty()){
							error = true;
							errorStr += "Debe ingresar una REFERENCIA para este tipo de cliente EXTRANJEROS.";
						}
						if(p.id_paciente_rismi == null || p.id_paciente_rismi.isEmpty()){
							error = true;
							errorStr += "Debe ingresar un ID PACIENTE para este tipo de cliente.";
						}else{
							List<Cliente> cl = Cliente.find.where().eq("id_paciente_rismi",p.id_paciente_rismi).findList();
							if(cl.size() > 0){
								error = true;
								errorStr += "Ya existe un Cliente con este ID PACIENTE.";
							}
						}
					}
					if(error){
						result.put("success", false);
						result.put("error", true);
						flash("error", errorStr);
						result.put("html", modalCargaClientes.render(clienteForm).toString());
						return ok(result);
					}
				}
				
				
				
				p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.create_date = new Date();
				p.activo = true;
				p.save();
				
				result.put("success", true);
				result.put("nombre", p.nombre);
				result.put("idCliente", p.id);
				//result.put("osCliente", p.profe);
				result.put("html", modalCargaClientes.render(clienteForm).toString());
				return ok(result);
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return ok(modalCargaClientes.render(clienteForm));
			}
			
		}catch (PersistenceException pe){
			System.out.println(pe);
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(modalCargaClientes.render(clienteForm));
		}
	}
	
	public static Result get(int id){
		Cliente cliente = Cliente.find.select("id, nombre").where().eq("id", id).eq("activo", true).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(cliente == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el usuario");
		} else {
			restJs.put("success", true);
			restJs.put("id", cliente.id);
			restJs.put("nombre", cliente.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
}
