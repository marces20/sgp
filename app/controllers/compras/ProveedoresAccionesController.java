package controllers.compras;

import static play.data.Form.form;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.Agente;
import models.DireccionProveedor;
import models.Proveedor;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.compras.proveedores.modales.modalInformacionProveedor;
import views.html.compras.ordenes.modales.*;

@Security.Authenticated(Secured.class)
public class ProveedoresAccionesController extends Controller {
	
	public static Result modalInformacionProveedor(Long id) {
		
		//dni cuit ncuenta domicilio telefono mail 
		Proveedor p = Proveedor.find.byId(id);
		
		return ok(modalInformacionProveedor.render(p));
	}
	
	public static Result actualizarMail(){
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
 
		ObjectNode result = Json.newObject();
		try {
			
			Long ordenId = null;
			if(!request().body().asFormUrlEncoded().get("ordenId")[0].isEmpty()){
				ordenId =  new Long(request().body().asFormUrlEncoded().get("ordenId")[0]);
			}	
			
			String email = null;
			if(!request().body().asFormUrlEncoded().get("email")[0].isEmpty()){
				email =  request().body().asFormUrlEncoded().get("email")[0];
			}		
			
			if(email == null ){
				flash("error", "Debe escribir un mail");
				result.put("error", true);
				result.put("html", modalOrdenProvisionMail.render(d,ordenId,null).toString());
				return ok(result); 
			}
			
			Long idDireProveedor = null;
			if(!request().body().asFormUrlEncoded().get("id_direccion")[0].isEmpty()){
				idDireProveedor = new Long(request().body().asFormUrlEncoded().get("id_direccion")[0]);
			}
			
			if(idDireProveedor == null ){
				flash("error", "No se encuentra la direccion");
				result.put("error", true);
				result.put("html", modalOrdenProvisionMail.render(d,ordenId,null).toString());
				return ok(result);
			}
			
			
 
			DireccionProveedor dpl = DireccionProveedor.find.where().eq("id",idDireProveedor).findUnique();
			dpl.email = email;
			dpl.write_date = new Date();
			dpl.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
			dpl.update();
			
			List<DireccionProveedor> dp = DireccionProveedor.find.where().eq("proveedor_id", dpl.proveedor_id).findList();
			result.put("success", true);
			flash("success", "Se actualizo el mail.");
			result.put("html", modalOrdenProvisionMail.render(d,ordenId,dp).toString());
			return ok(result);
			
		} catch (Exception e){
			Logger.debug("333333333333333333333333 "+e);
			flash("error", "No se puede modificar los registros.");
			return ok(modalOrdenProvisionMail.render(d,null,null));
		}	
	}
}
