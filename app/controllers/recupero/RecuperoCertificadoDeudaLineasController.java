package controllers.recupero;

import static play.data.Form.form;

import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.recupero.RecuperoCerficadoDeudaLinea;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.recuperoCerficadoDeudaLineas.*;

@Security.Authenticated(Secured.class)
public class RecuperoCertificadoDeudaLineasController extends Controller {

	final static Form<RecuperoCerficadoDeudaLinea> lineaForm = form(RecuperoCerficadoDeudaLinea.class);

	public static Result index(Long certId, Boolean editable) {

		Pagination<RecuperoCerficadoDeudaLinea> lineas = RecuperoCerficadoDeudaLinea.page(certId);

		return ok(indexRecuperoCerficadoDeudaLinea.render(lineas, editable));
	}

	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		Ebean.beginTransaction();

		try {

			RecuperoCerficadoDeudaLinea rcpTmp = RecuperoCerficadoDeudaLinea.find.byId(id);

			Long rcd = rcpTmp.recupero_certificado_deuda_id;

			rcpTmp.delete();

			List<RecuperoFactura> rf = RecuperoFactura.find.where().eq("recupero_certificado_deuda_id",rcd).findList();

			for(RecuperoFactura rfx:rf) {
				rfx.recupero_certificado_deuda_id = null;
				rfx.save();
			}
			Ebean.commitTransaction();

		} catch (PersistenceException pe) {
			Ebean.rollbackTransaction();
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}finally {
			Ebean.endTransaction();
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
