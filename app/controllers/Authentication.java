package controllers;

import com.avaje.ebean.Ebean;

import models.Usuario;
import models.auth.LoginForm;
import models.auth.Permiso;
 
import play.mvc.Controller;
import play.mvc.Result;
import play.cache.Cache;
import play.data.Form; 
import static play.data.Form.form;

import views.html.login;



public final class Authentication extends Controller {
	 
    public static Result login() {
        return ok(login.render(form(LoginForm.class)));
    }
   
    public static Result authenticate() {
    	Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();

    	if(loginForm.hasErrors()) {
        	return badRequest(login.render(loginForm));
    	}
    	
    	return redirect(routes.Application.index());
    }
   
    public static Usuario authenticate(final String nick, final String password){
    	Usuario usuario = Ebean.find(Usuario.class)
			     .where()
			     .eq("nick", nick)
			     .eq("password", password)
			     .findUnique();
    	
    	if(usuario != null){
    		session("id", String.valueOf(usuario.id));
    		session("nick", usuario.nick);
    	}
    	
    	return usuario;
    }
 
 
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.Authentication.login());
    }
 
}


