package controllers.auth;

import models.auth.Permiso;
import views.*;
import views.html.index;
import views.html.sinPermiso;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class CheckPermisoAction extends Action<CheckPermiso>  {
	
	public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {

		if(Permiso.check(configuration.key())){
			return delegate.call(ctx);
		}
		String refererUrl = ctx.request().getHeader("referer");
	    return F.Promise.pure((SimpleResult) ok(sinPermiso.render(refererUrl)));
	}
	
  }
