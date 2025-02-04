package controllers.recupero;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import controllers.auth.CheckPermiso;
import models.Cliente;
import models.Estado;
import models.OrdenLineaCliente;
import models.Periodo;
import models.auth.Permiso;
import models.recupero.InformeTotal;
import models.recupero.RecuperoFactura;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.recupero.recuperoCliente.*;

public class RecuperoClientesController extends Controller {

	@CheckPermiso(key = "clientesVer")
	public static Result index(Long tipoCliente) {
		DynamicForm d = form().bindFromRequest();

		return ok(
				 index.render(
						 Cliente.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("idPaciente"),
								 RequestVar.get("dni"),
								 RequestVar.get("cuit"),
								 tipoCliente.toString()
								 ),
								 d,tipoCliente));
	}

	public static Result ver(Long id,Long tipoCliente) {
		Cliente cliente = Cliente.find.byId(id);

		Form<Cliente> recuperoClienteForm = form(Cliente.class).fill(cliente);
		BigDecimal totalDeuda = InformeTotal.getDeudaPorIdCliente(id, null,null);
		Periodo p = Periodo.getPeriodoByDate(new Date());
		Periodo pMenosTres = Periodo.find.byId(p.id-3);
		String menos90 = DateUtils.formatDate(pMenosTres.date_stop, "dd/MM/yyyy");
		BigDecimal totalDeuda90Dias = InformeTotal.getDeudaPorIdCliente(id, null,menos90);

		return ok(verClienteRecupero.render(cliente,tipoCliente,recuperoClienteForm,totalDeuda,totalDeuda90Dias,menos90));
	}

	public static Result listaDeuda(Long id) {

		Pagination<InformeTotal> i = InformeTotal.page(id.toString(),
				RequestVar.get("periodo_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio"),
				"0",
				RequestVar.get("deuda_menor"),
				RequestVar.get("pago_mayor"),
				RequestVar.get("pago_menor"),
				RequestVar.get("cliente_tipo_id"),
				RequestVar.get("fecha_factura_desde"),
				RequestVar.get("fecha_factura_hasta"),
				RequestVar.get("deposito_id")
				);

		return ok(listaDeudaTab.render(i, form().bindFromRequest()));
	}
}
