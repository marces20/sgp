package models.auth;

import play.data.validation.Constraints.Required;
import controllers.Authentication;


public class LoginForm {
	@Required(message="No indicó el nick")
	public String nick;
	 
	@Required(message="No indicó el password")
	public String password;
	 
	 
    public String validate() {
	    if(Authentication.authenticate(this.nick, this.password) == null) {
	      return "Usuario o Password Invalido";
	    }
	    return null;
    }
}
