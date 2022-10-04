package controllers.contabilidad;

import static play.data.Form.form;
import models.OrdenPagoCircuitoLinea;
import controllers.Secured;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.contabilidad.ordenesPagosCircuitosLineas.*;

@Security.Authenticated(Secured.class)
public class OrdenesPagosCircuitosLineasController extends Controller {
	
	final static Form<OrdenPagoCircuitoLinea> lineaForm = form(OrdenPagoCircuitoLinea.class);
	
	public static Result index(Long orden_pago_circuito_id) {
		
		Pagination<OrdenPagoCircuitoLinea> lineas = OrdenPagoCircuitoLinea.page(orden_pago_circuito_id);

		return ok(indexOrdenPagoCircuitoLinea.render(lineas));
	}
}
