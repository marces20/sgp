package controllers.patrimonio;

import static play.data.Form.form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oauth.signpost.http.HttpResponse;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lowagie.text.pdf.codec.Base64.InputStream;

import controllers.Secured;

import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import models.ActaRecepcion;
import models.Inventario;
import models.Recepcion;
import models.RemitoLinea;
import play.api.libs.ws.WS;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.patrimonio.inventario.*;

@Security.Authenticated(Secured.class)
public class InventarioController extends Controller {

	
	public static Result index() throws ParseException, IOException{
		Pagination<Inventario> inventario = Inventario.page(RequestVar.get("prefijo_inventario_id"), RequestVar.get("numero"), RequestVar.get("remito_numero"), RequestVar.get("proveedor_id"), RequestVar.get("producto_id"));

        
        
		DynamicForm d = form().bindFromRequest();
		return ok(indexInventario.render(inventario, d));
	}

	public static Result registrarModal(Long remito_linea_id){
		
		RemitoLinea rl = RemitoLinea.find.where().eq("id", remito_linea_id).findUnique();
		
		if(rl.cantidad.compareTo(BigDecimal.ZERO) <= 0) {
			flash("error", "No se han cargado productos en el remito.");
			return ok(resultadoAgregarInventario.render());
		}

		Form<Inventario> iForm = form(Inventario.class).bindFromRequest();

		Inventario i = Inventario.find.where().eq("remito_id", rl.remito_id).eq("producto_id", rl.lineaOrden.producto_id).setMaxRows(1).findUnique();

		if(i != null) {
			iForm.data().put("prefijo_inventario_id", i.nomenclador_inventario_id.toString());
		}
		
		iForm.data().put("remito_id", rl.remito_id.toString() );
		return ok(registrarModal.render(rl, iForm));
	}
	
	
	public static Result actualizar() {
		Form<Inventario> iForm = form(Inventario.class).bindFromRequest();
		ObjectNode result = Json.newObject();
		
		if(iForm.hasErrors()) {
			System.out.println(iForm.errors());
			result.put("message", "Error en formulario.");
			return ok(result);
		} 
		
		Inventario i = iForm.get();
		
		List<Inventario> ir = Inventario.find.where().eq("numero", i.numero).eq("division", i.division).ne("id", i.id).findList();
		
		if(!ir.isEmpty()) {
			result.put("message", "El número ya se encuentra asignado.");
			return ok(result);
		}
		
		try {
			i.update();
			result.put("success", true);
			result.put("message", "El inventario se ha modificado correctamente.");
		} catch (Exception e) {
			result.put("message", "Se ha producido un error."+e.getMessage());
		}
		
		
		return ok(result);
	}
	
	public static Result guardar() {
		Form<Inventario> iForm = form(Inventario.class).bindFromRequest();
		ObjectNode result = Json.newObject();
		
		if(iForm.hasErrors()) {
			System.out.println(iForm.errors());
			result.put("message", "Error en formulario.");
			return ok(result);
		} 
		
		Inventario i = iForm.get();
		
		Inventario ir = Inventario.find.where().eq("numero", i.numero).eq("division", i.division).findUnique();
		
		if(ir != null) {
			result.put("message", "El número ya se encuentra asignado.");
			return ok(result);
		}	
		
		try {
			i.save();
			result.put("id", i.id);
			result.put("success", true);
			result.put("message", "El inventario se ha creado correctamente.");
		} catch (Exception e) {
			result.put("message", "Se ha producido un errors."+e.getMessage());
		}
		
		
		return ok(result);
	}
	
	public static Result eliminar(Long id) {
		ObjectNode result = Json.newObject();
		
		try {
			Inventario.find.byId(id).delete();
			result.put("success", true);
			result.put("message", "El inventario se ha eliminado correctamente.");
		} catch (Exception e) {
			result.put("error", true);
			result.put("message", "El inventario no se pudo eliminar.");
		}
		
		return ok(result);
	}
	
}
