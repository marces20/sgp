package controllers.patrimonio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.velocity.tools.generic.MathTool;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.google.common.collect.Lists;

import controllers.Secured;

import models.ActaRecepcion;
import models.ActaRecepcionLinea;
import models.DireccionProveedor;
import models.OrdenProvision;
import models.Recepcion;
import models.Remito;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.StringUtils;
import views.html.patrimonio.ordenesProvision.reportes.modalReporteOrdenProvision;

@Security.Authenticated(Secured.class)
public class ActasRecepcionReportes2Controller extends Controller {

	
	public static Result reporte(Long id) {
		return ok();
		
	}
	
	/*
	 * Reviso un número y compruebo el siguiente si es correlativo, cuando no lo es creo la "cadena desde hasta" en el método 'agregarNumerosInventario'
	 */
	private static void crearIntervalo (List<SqlRow> li, List listaInventario) {
		 
	}
	
	/*
	 * Agrego a la lista "inventario" las lineas que van a ser "desde/hasta", la clave es el id de producto, la clave prefijo se utiliza en el odt
	 */
	private static void agregarNumerosInventario (SqlRow sqlRow, String desde, String hasta, List listaInventario) {
		 
	}
	
	
}