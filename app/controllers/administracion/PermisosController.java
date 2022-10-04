package controllers.administracion;

import java.util.HashSet;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Usuario;
import models.auth.Componente;
import models.auth.Modulo;
import models.auth.Permiso;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Security;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.cache.Cache;
import views.html.sinPermiso;
import views.html.administracion.permisos.*;

@Security.Authenticated(Secured.class)
public class PermisosController extends Controller {
	
	public static Result index(Integer id) {
		
		if(Usuario.getUsuarioSesion() != 1) {
			return ok(sinPermiso.render(request().getHeader("referer")));
		}
				
		Usuario usuario = Usuario.find.byId(id);
		HashSet<String> permisos = null;

		if(usuario != null) {
			permisos = Permiso.getAsignados(usuario.id);
		}
		
		return ok(index.render(usuario, permisos));
	}
	
	public static Result asignar() {
		
		if(Usuario.getUsuarioSesion() != 1) {
			return ok(sinPermiso.render(request().getHeader("referer")));
		}
		
		int result = 0;
		Integer usuario = Integer.parseInt(request().getQueryString("usuario"));
		try {
			String s = "INSERT INTO auth_asignaciones VALUES (DEFAULT, :usuario, :permiso)";
			SqlUpdate update = Ebean.createSqlUpdate(s);
			update.setParameter("usuario", usuario);
			update.setParameter("permiso", request().getQueryString("permiso"));
			result = Ebean.execute(update);	
			Cache.remove("permisos.asignados."+usuario);
			Cache.remove("permisos.modulos."+usuario);
			Cache.remove("permisos.componentes."+usuario);
		} catch (Exception e) {
			
		}
		
		ObjectNode restJs = Json.newObject();
	    restJs.put("success", result > 0);
		return ok(restJs);
	}

	public static Result desasignar() {
		
		if(Usuario.getUsuarioSesion() != 1) {
			return ok(sinPermiso.render(request().getHeader("referer")));
		}
		
		int result = 0;
		Integer usuario = Integer.parseInt(request().getQueryString("usuario"));
		try {
			String s = "DELETE FROM auth_asignaciones WHERE usuario_id = :usuario AND permiso_id = :permiso";
			SqlUpdate delete = Ebean.createSqlUpdate(s);
			delete.setParameter("usuario", Integer.parseInt(request().getQueryString("usuario"))  );
			delete.setParameter("permiso", request().getQueryString("permiso"));
			result = Ebean.execute(delete);
			Cache.remove("permisos.asignados."+usuario);
			Cache.remove("permisos.modulos."+usuario);
			Cache.remove("permisos.componentes."+usuario);
		} catch (Exception e) {
			
		}
		ObjectNode restJs = Json.newObject();
	    restJs.put("success", result > 0);
		return ok(restJs);
	}
	
}
