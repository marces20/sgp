package controllers.auth;

import models.auth.Permiso;
import views.*;
import views.html.index;
import views.html.sinPermiso;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;
import utils.UriTrack;

public class CheckPermisoAction extends Action<CheckPermiso>  {

	public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {

		if(ctx.session().get("nick") == null || ctx.session().get("id") == null) {
			return F.Promise.pure((SimpleResult) redirect(controllers.routes.Authentication.logout()));//F.Promise.pure((SimpleResult) ok(sinPermiso.render(refererUrl)));
		}

		if(Permiso.check(configuration.key())){
			return delegate.call(ctx);
		}



		String refererUrl = ctx.request().getHeader("referer");
	    return F.Promise.pure((SimpleResult) ok(sinPermiso.render(refererUrl)));
	}

  }
