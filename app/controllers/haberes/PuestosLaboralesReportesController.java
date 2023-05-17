package controllers.haberes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.common.base.Strings;

import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import models.Estado;
import models.EstadoCivil;
import models.Provincia;
import models.haberes.PuestoLaboral;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.StringUtils;
import views.html.haberes.puestosLaborales.respuestaModal;
import views.html.haberes.puestosLaborales.reportes.descargarArchivo;

public class PuestosLaboralesReportesController extends Controller  {

	public static Result reportef649() throws IOException {

		List<Integer> puestosSeleccionadas = getSeleccionados();

		if(puestosSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar un puesto.");
		 	return ok(descargarArchivo.render(null));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/f649.odt");

		try {

			  // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/f649.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		      flash("success", "El archivo fue creado correctamente.");
			  return ok(descargarArchivo.render(archivo.getPath()));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

		 	flash("Error", "No se puedo crear el archivo.");
		 	return ok(descargarArchivo.render(null));
	}

	@CheckPermiso(key = "puestoLaboralForm649")
	public static Result formulario6492023(Long id, Integer ejercicio_id) {

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			String nombreArchivo = "";


			String sql = "";

			sql = " select * from query_649_2023 where puesto_laboral_id = :id ";
			nombreArchivo = dirTemp+"/formulario649-2023.xls";


			SqlRow s = Ebean.createSqlQuery(sql).setParameter("id", id).findUnique();


			if(s == null) {
				flash("error", "El puesto laboral no tiene datos de ganancia");
				return redirect(request().getHeader("referer"));
			}



			File archivo = new File(nombreArchivo);
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/ganancias/formulario649-2023.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Row f;

			f = hoja.getRow(2);
		    Font boldFont = libro.createFont();
		    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    RichTextString richFecha = new HSSFRichTextString("Fecha: " + DateUtils.formatDate(new Date()));
		    richFecha.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richFecha);

			f = hoja.getRow(3);
		    RichTextString richString = new HSSFRichTextString("Empleado: " + s.getString("agente_apellido"));
		    richString.applyFont(0, 9, boldFont);
		    f.getCell(0).setCellValue(richString);

		    f = hoja.getRow(4);
		    RichTextString richCuit = new HSSFRichTextString("CUIT: " + s.getString("agente_cuil"));
		    richCuit.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richCuit);

		    f = hoja.getRow(6);
		    RichTextString richPeriodo = new HSSFRichTextString("Período Fiscal: " + s.getString("anio"));
		    richPeriodo.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodo);

		    f = hoja.getRow(7);
		    RichTextString richPeriodoDesde = new HSSFRichTextString("Período trabajado (desde): " + s.getString("periodo_desde"));
		    richPeriodoDesde.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodoDesde);

		    f = hoja.getRow(8);
		    RichTextString richPeriodoHasta = new HSSFRichTextString("Período trabajado (hasta): " + s.getString("periodo_hasta"));
		    richPeriodoHasta.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodoHasta);



		    f = hoja.getRow(9);
			f.getCell(1).setCellValue("SIN BENEFICIO Año 2022");//Transporte a larga distancia

		    f = hoja.getRow(10);
			f.getCell(1).setCellValue("NO");//Transporte a larga distancia
			f = hoja.getRow(11);
			f.getCell(1).setCellValue("NO");//Beneficio promocional 27424?

			f = hoja.getRow(12);
			f.getCell(1).setCellValue((s.getBigDecimal("regimen_teletrabajo_ley_27555").compareTo(BigDecimal.ZERO)== 0)?"NO":"SI");//El trabajador labora bajo el régimen de teletrabajo (Ley 27555)?
			f = hoja.getRow(13);
			f.getCell(1).setCellValue((s.getBigDecimal("personal_militar_en_actividad").compareTo(BigDecimal.ZERO)== 0)?"NO":"SI");//El trabajador es personal militar en actividad?
			f = hoja.getRow(14);
			f.getCell(1).setCellValue((s.getBigDecimal("transporte_larga_distancia_convenio_40_1989").compareTo(BigDecimal.ZERO)== 0)?"NO":"SI");//El trabajador desarrolla la actividad de transporte terrestre de larga distancia bajo el convenio 40/1989


			boolean test = false;

			Integer i = 18;
			f = hoja.getRow(i++);
			//f.getCell(1).setCellValue("1999999999999999999999999999999999");
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta").doubleValue());//19
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneraciones_no_habit").doubleValue());//20
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota").doubleValue());//21
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota").doubleValue());//22
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav").doubleValue());//23
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav").doubleValue());//24
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav").doubleValue());//25
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe").doubleValue());//26
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retribuciones_no_habit_exentas").doubleValue());//27
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe").doubleValue());//28
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe").doubleValue());//29
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe").doubleValue());//30
			f = hoja.getRow(i++);

			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exenta_ley_27549").doubleValue());//31
			f = hoja.getRow(i++);

			//bonos productividad gravado
			f.getCell(1).setCellValue(s.getBigDecimal("bono_productividad_gravado").doubleValue());//32
			f = hoja.getRow(i++);
			//fallos de caja gravado
			f.getCell(1).setCellValue(s.getBigDecimal("fallo_caja_gravado").doubleValue());//33
			f = hoja.getRow(i++);
			//conceptos de similar
			f.getCell(1).setCellValue(s.getBigDecimal("concepto_similar_naturaleza_gravado").doubleValue());//34
			f = hoja.getRow(i++);
			//bonos productividad exento
			f.getCell(1).setCellValue(s.getBigDecimal("bono_productividad_exento").doubleValue());//35
			f = hoja.getRow(i++);
			//fallos de caja excento
			f.getCell(1).setCellValue(s.getBigDecimal("fallo_caja_exento").doubleValue());//36
			f = hoja.getRow(i++);
			//Concepto de similar naturaleza
			f.getCell(1).setCellValue(s.getBigDecimal("concepto_similar_naturaleza_exento").doubleValue());//37
			f = hoja.getRow(i++);
			//compensacion de gastos teletrabajo
			f.getCell(1).setCellValue(s.getBigDecimal("compensacion_gastos_teletrabajo_exento").doubleValue());//38
			f = hoja.getRow(i++);
			//personal militar
			f.getCell(1).setCellValue(s.getBigDecimal("personal_militar_complementos_art_57").doubleValue());//39
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_no_alcanzado").doubleValue());//40
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_no_alcanzado").doubleValue());//41
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_gravado").doubleValue());//42
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_no_gravado").doubleValue());//43
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_no_gravado").doubleValue());//44
			//f.getCell(1).setCellValue("43333333333333333333333333");

			//////////////////////////////////Otros Empleos/////////////////////////////////////////
			i = 45;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta_otros_emp").doubleValue());//46
			//f.getCell(1).setCellValue("46666666666");//46
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_no_habit_otros_emp").doubleValue());//47
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_otros_emp").doubleValue());//48
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_otros_emp").doubleValue());//49
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav_otros_emp").doubleValue());//50
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav_otros_emp").doubleValue());//51
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav_otros_emp").doubleValue());//52
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe_otros_emp").doubleValue());//53
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_retribuciones_no_habit_exentas").doubleValue());//54
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe_otros_emp").doubleValue());//55
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe_otros_emp").doubleValue());//56
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe_otros_emp").doubleValue());//57
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_remuneracion_exenta_ley_27549").doubleValue());//58
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_bono_productividad_gravado").doubleValue());//59
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_fallo_caja_gravado").doubleValue());//60
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_concepto_similar_naturaleza_gravado").doubleValue());//61
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_bono_productividad_exento").doubleValue());//62
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_fallo_caja_exento").doubleValue());//63
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_concepto_similar_naturaleza_exento").doubleValue());//64
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_compensacion_gastos_teletrabajo_exento").doubleValue());//65
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_personal_militar_complementos_art_57").doubleValue());//66
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_primera_cuota_exe").doubleValue());//67
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_segunda_cuota_exe").doubleValue());//68
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_gravado").doubleValue());//69
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_no_gravado").doubleValue());//70


			i++;//71
			//i++;//72
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_gravada").doubleValue());//72
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_exenta").doubleValue());//73
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_remuneraciones").doubleValue());//73
			//f.getCell(1).setCellValue("7444444444");



			//////////////////////////////////DEDUCCIONES GENERALES/////////////////////////////////////////
			i = 76;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc").doubleValue()); //76
			//f.getCell(1).setCellValue("777777777777");//101
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc_otros_emp").doubleValue());//77
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social").doubleValue());//78
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social_otros_emp").doubleValue());//79
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical").doubleValue());//80
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical_otros_emp").doubleValue());//81
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_medico_asist").doubleValue());//82
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte").doubleValue());//83
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte_ssn").doubleValue());//84
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retiro_ssn").doubleValue());//85
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuotas_fci").doubleValue());//86
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gastos_sepelio").doubleValue());//87
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("amort_e_interes_rodados").doubleValue());//88
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("donaciones_fisco").doubleValue());//89
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dtos_obligatorios_leyes_nac_prov_munic").doubleValue());//90
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("honorarios_serv_medico").doubleValue());//91
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("int_credito_hipot").doubleValue());//92
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_captial_social").doubleValue());//93
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_cajas_complem").doubleValue());//94
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("alquileres").doubleValue());//95
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("serv_domestico").doubleValue());//96
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("viaticos").doubleValue());//97
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("indumentaria").doubleValue());//98
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("servicios_educativos").doubleValue());//99
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_deducciones").doubleValue());//100
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_gen").doubleValue());//101
			//f.getCell(1).setCellValue("111111000000000001111111");//101

			//////////////////////////////////DEDUCCIONES PERSONALES/////////////////////////////////////////
			i = 104;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gan_no_imponible").doubleValue());
			//f.getCell(1).setCellValue("10000005");
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especial").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_primera_parte_inc_c").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_segunda_parte_inc_c").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especifica").doubleValue());
			//f.getCell(1).setCellValue("100000099999");

			//////////////////////////////////Cargas de Familia/////////////////////////////////////////
			i = 111;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("conyuge").doubleValue());
			//f.getCell(1).setCellValue("1122222222");
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_100").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_incapacitado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_incapacitado_100").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("valor_hijos_incapacitado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_educ_50").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_educ_100").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_pers").doubleValue());
			//f.getCell(1).setCellValue("1211");

			//////////////////////////////////DETERMINACIÓN DEL IMPUESTO/////////////////////////////////////////
			i = 123;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto_antes_dei").doubleValue());
			//f.getCell(1).setCellValue("1244444");
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_en_deducciones_primera_parte").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_en_deducciones_segunda_parte").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota_sin_hs_ex").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_determinada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_retenida").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pagos_a_cuenta_imp_deb_cred").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retenc_aduaneras").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("resol_38192015").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("bono_ley_27424").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_a").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_b").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_c").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_d").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_e").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_deb_cred_fondos_propios").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("resol_38192015_transporte_exterior").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_pagos_a_cuenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("impuesto_saldo").doubleValue());
			//f.getCell(1).setCellValue("14444");

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok();
	}

	@CheckPermiso(key = "puestoLaboralForm649")
	public static Result formulario6492021(Long id, Integer ejercicio_id) {

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			String nombreArchivo = "";


			String sql = "";

			sql = " select * from query_649_2021 where puesto_laboral_id = :id ";
			nombreArchivo = dirTemp+"/formulario649-2021.xls";


			SqlRow s = Ebean.createSqlQuery(sql).setParameter("id", id).findUnique();


			if(s == null) {
				flash("error", "El puesto laboral no tiene datos de ganancia");
				return redirect(request().getHeader("referer"));
			}



			File archivo = new File(nombreArchivo);
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/ganancias/formulario649-2021.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Row f;

			f = hoja.getRow(2);
		    Font boldFont = libro.createFont();
		    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    RichTextString richFecha = new HSSFRichTextString("Fecha: " + DateUtils.formatDate(new Date()));
		    richFecha.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richFecha);

			f = hoja.getRow(3);
		    RichTextString richString = new HSSFRichTextString("Empleado: " + s.getString("agente_apellido"));
		    richString.applyFont(0, 9, boldFont);
		    f.getCell(0).setCellValue(richString);

		    f = hoja.getRow(4);
		    RichTextString richCuit = new HSSFRichTextString("CUIT: " + s.getString("agente_cuil"));
		    richCuit.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richCuit);

		    f = hoja.getRow(6);
		    RichTextString richPeriodo = new HSSFRichTextString("Período Fiscal: " + s.getString("anio"));
		    richPeriodo.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodo);

			Integer i = 10;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneraciones_no_habit").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retribuciones_no_habit_exentas").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exenta_ley_27549").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_no_alcanzado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_no_alcanzado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_no_gravado").doubleValue());


			i = 29;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_no_habit_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_retribuciones_no_habit_exentas").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_remuneracion_exenta_ley_27549").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_primera_cuota_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_segunda_cuota_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_no_gravado").doubleValue());
			i++;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_gravada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_exenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_remuneraciones").doubleValue());




			i = 52;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc").doubleValue()); //53
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc_otros_emp").doubleValue());//54
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social").doubleValue());//55
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social_otros_emp").doubleValue());//56
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical").doubleValue());//57
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical_otros_emp").doubleValue());//58
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_medico_asist").doubleValue());//59
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte").doubleValue());//60
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte_ssn").doubleValue());//61
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retiro_ssn").doubleValue());//62
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuotas_fci").doubleValue());//63
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gastos_sepelio").doubleValue());//64
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("amort_e_interes_rodados").doubleValue());//65
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("donaciones_fisco").doubleValue());//66
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dtos_obligatorios_leyes_nac_prov_munic").doubleValue());//67
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("honorarios_serv_medico").doubleValue());//68
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("int_credito_hipot").doubleValue());//69
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_captial_social").doubleValue());//70
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_cajas_complem").doubleValue());//71
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("alquileres").doubleValue());//72
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("serv_domestico").doubleValue());//73
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("viaticos").doubleValue());//74
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("indumentaria").doubleValue());//75
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_deducciones").doubleValue());//76
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_gen").doubleValue());//77


			i = 79;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gan_no_imponible").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especial").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especifica").doubleValue());


			i = 84;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("conyuge").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_pers").doubleValue());


			i = 90;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota_sin_hs_ex").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_determinada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_retenida").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_pagos_a_cuenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("impuesto_saldo").doubleValue());


			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok();
	}


	@CheckPermiso(key = "puestoLaboralForm649")
	public static Result formulario6492022(Long id, Integer ejercicio_id) {

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			String nombreArchivo = "";


			String sql = "";

			sql = " select * from query_649_2022 where puesto_laboral_id = :id ";
			nombreArchivo = dirTemp+"/formulario649-2021.xls";


			SqlRow s = Ebean.createSqlQuery(sql).setParameter("id", id).findUnique();


			if(s == null) {
				flash("error", "El puesto laboral no tiene datos de ganancia");
				return redirect(request().getHeader("referer"));
			}



			File archivo = new File(nombreArchivo);
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/ganancias/formulario649-2022.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Row f;

			f = hoja.getRow(2);
		    Font boldFont = libro.createFont();
		    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    RichTextString richFecha = new HSSFRichTextString("Fecha: " + DateUtils.formatDate(new Date()));
		    richFecha.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richFecha);

			f = hoja.getRow(3);
		    RichTextString richString = new HSSFRichTextString("Empleado: " + s.getString("agente_apellido"));
		    richString.applyFont(0, 9, boldFont);
		    f.getCell(0).setCellValue(richString);

		    f = hoja.getRow(4);
		    RichTextString richCuit = new HSSFRichTextString("CUIT: " + s.getString("agente_cuil"));
		    richCuit.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richCuit);

		    f = hoja.getRow(6);
		    RichTextString richPeriodo = new HSSFRichTextString("Período Fiscal: " + s.getString("anio"));
		    richPeriodo.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodo);

			Integer i = 17;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneraciones_no_habit").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retribuciones_no_habit_exentas").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exenta_ley_27549").doubleValue());
			f = hoja.getRow(i++);



			//bonos productividad gravado
			f.getCell(1).setCellValue(s.getBigDecimal("bono_productividad_gravado").doubleValue());
			f = hoja.getRow(i++);
			//fallos de caja gravado
			f.getCell(1).setCellValue(s.getBigDecimal("fallo_caja_gravado").doubleValue());
			f = hoja.getRow(i++);
			//conceptos de similar
			f.getCell(1).setCellValue(s.getBigDecimal("concepto_similar_naturaleza_gravado").doubleValue());
			f = hoja.getRow(i++);
			//bonos productividad exento
			f.getCell(1).setCellValue(s.getBigDecimal("bono_productividad_exento").doubleValue());
			f = hoja.getRow(i++);
			//fallos de caja excento
			f.getCell(1).setCellValue(s.getBigDecimal("fallo_caja_exento").doubleValue());
			f = hoja.getRow(i++);
			//Concepto de similar naturaleza
			f.getCell(1).setCellValue(s.getBigDecimal("concepto_similar_naturaleza_exento").doubleValue());
			f = hoja.getRow(i++);
			//compensacion de gastos teletrabajo
			f.getCell(1).setCellValue(s.getBigDecimal("compensacion_gastos_teletrabajo_exento").doubleValue());
			f = hoja.getRow(i++);
			//personal militar
			f.getCell(1).setCellValue(s.getBigDecimal("personal_militar_complementos_art_57").doubleValue());
			f = hoja.getRow(i++);


			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_no_alcanzado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_no_alcanzado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ajuste_periodos_anteriores_no_gravado").doubleValue());


			i = 44;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_no_habit_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_retribuciones_no_habit_exentas").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_remuneracion_exenta_ley_27549").doubleValue());

			//nuevos
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_bono_productividad_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_fallo_caja_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_concepto_similar_naturaleza_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_bono_productividad_exento").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_fallo_caja_exento").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_concepto_similar_naturaleza_exento").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_compensacion_gastos_teletrabajo_exento").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_personal_militar_complementos_art_57").doubleValue());
			//fin nuevo


			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_primera_cuota_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_sac_segunda_cuota_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_gravado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otros_empleos_ajuste_periodos_anteriores_no_gravado").doubleValue());

			i = 70;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_gravada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_exenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_remuneraciones").doubleValue());




			i = 75;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc").doubleValue()); //53
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc_otros_emp").doubleValue());//54
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social").doubleValue());//55
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social_otros_emp").doubleValue());//56
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical").doubleValue());//57
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical_otros_emp").doubleValue());//58
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_medico_asist").doubleValue());//59
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte").doubleValue());//60
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte_ssn").doubleValue());//61
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retiro_ssn").doubleValue());//62
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuotas_fci").doubleValue());//63
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gastos_sepelio").doubleValue());//64
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("amort_e_interes_rodados").doubleValue());//65
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("donaciones_fisco").doubleValue());//66
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dtos_obligatorios_leyes_nac_prov_munic").doubleValue());//67
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("honorarios_serv_medico").doubleValue());//68
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("int_credito_hipot").doubleValue());//69
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_captial_social").doubleValue());//70
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_cajas_complem").doubleValue());//71
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("alquileres").doubleValue());//72
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("serv_domestico").doubleValue());//73
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("viaticos").doubleValue());//74
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("indumentaria").doubleValue());//75
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_deducciones").doubleValue());//76
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_gen").doubleValue());//77


			i = 102;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gan_no_imponible").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especial").doubleValue());
			//nuevo
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_primera_parte_inc_c").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_segunda_parte_inc_c").doubleValue());

			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especifica").doubleValue());


			i = 109;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("conyuge").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hijos").doubleValue());
			//nuevos
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos_incapacitado").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("valor_hijos_incapacitado").doubleValue());

			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_pers").doubleValue());


			i = 117;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto_antes_dei").doubleValue());
			//nuevos 3
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_en_deducciones_primera_parte").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dei_en_deducciones_segunda_parte").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto").doubleValue());


			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota_sin_hs_ex").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_determinada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_retenida").doubleValue());
			//nuevos 11
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pagos_a_cuenta_imp_deb_cred").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retenc_aduaneras").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("resol_38192015").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("bono_ley_27424").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_a").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_b").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_c").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_d").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_ley4815_inc_e").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pago_a_cta_deb_cred_fondos_propios").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("resol_38192015_transporte_exterior").doubleValue());


			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_pagos_a_cuenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("impuesto_saldo").doubleValue());


			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok();
	}



	@CheckPermiso(key = "puestoLaboralForm649")
	public static Result formulario6492019(Long id, Integer ejercicio_id) {

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			String nombreArchivo = "";


			String sql = "";
			if (ejercicio_id == 5) {
				sql = " select * from vista_f_649_2016 where id_puesto_laboral = :id ";
				nombreArchivo = dirTemp+"/formulario649-2016.xls";
			} else if (ejercicio_id == 6) {
				sql = " select * from vista_f_649_2017 where id_puesto_laboral = :id ";
				nombreArchivo = dirTemp+"/formulario649-2017.xls";
			} else if (ejercicio_id == 7) {
				sql = " select * from query_649_2019 where puesto_laboral_id = :id ";
				nombreArchivo = dirTemp+"/formulario649-2018.xls";
			} else if (ejercicio_id == 8) {
				sql = " select * from query_649_2020 where puesto_laboral_id = :id ";
				nombreArchivo = dirTemp+"/formulario649-2019.xls";
			}

			SqlRow s = Ebean.createSqlQuery(sql).setParameter("id", id).findUnique();


			if(s == null) {
				flash("error", "El puesto laboral no tiene datos de ganancia");
				return redirect(request().getHeader("referer"));
			}



			File archivo = new File(nombreArchivo);
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/ganancias/formulario649-2019.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Row f;

			f = hoja.getRow(2);
		    Font boldFont = libro.createFont();
		    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    RichTextString richFecha = new HSSFRichTextString("Fecha: " + DateUtils.formatDate(new Date()));
		    richFecha.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richFecha);

			f = hoja.getRow(3);
		    RichTextString richString = new HSSFRichTextString("Empleado: " + s.getString("agente_apellido"));
		    richString.applyFont(0, 9, boldFont);
		    f.getCell(0).setCellValue(richString);

		    f = hoja.getRow(4);
		    RichTextString richCuit = new HSSFRichTextString("CUIT: " + s.getString("agente_cuil"));
		    richCuit.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richCuit);

		    f = hoja.getRow(6);
		    RichTextString richPeriodo = new HSSFRichTextString("Período Fiscal: " + s.getString("anio"));
		    richPeriodo.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodo);

			Integer i = 10;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneraciones_no_habit").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe").doubleValue());




			i = 22;
			f = hoja.getRow(i++);
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_bruta_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_no_habit_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_primera_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sac_segunda_cuota_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_grav_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("remuneracion_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hs_extras_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("mov_viat_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pers_doc_exe_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_gravada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_rem_exenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_remuneraciones").doubleValue());


			i = 40;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_jub_pens_etc_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_obra_social_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_sindical_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_medico_asist").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_muerte_ssn").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("retiro_ssn").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuotas_fci").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gastos_sepelio").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("amort_e_interes_rodados").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("donaciones_fisco").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("dtos_obligatorios_leyes_nac_prov_munic").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("honorarios_serv_medico").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("int_credito_hipot").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_captial_social").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ap_cajas_complem").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("alquileres").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("serv_domestico").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("viaticos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("indumentaria").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_deducciones").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_gen").doubleValue());


			i = 67;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gan_no_imponible").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especial").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especifica").doubleValue());

			f = hoja.getRow(i++);
			f = hoja.getRow(i++);

			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("conyuge").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cant_hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("total_deducciones_pers").doubleValue());


			i = 78;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("rem_sujeta_a_impuesto").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("porcentaje_alicuota_sin_hs_ex").divide(new BigDecimal(100)).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_determinada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_retenida").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("ganancias_pagos_a_cuenta").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("impuesto_saldo").doubleValue());


			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok();
	}



	@CheckPermiso(key = "puestoLaboralForm649")
	public static Result formulario649(Long id, Integer ejercicio_id) {





		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			String nombreArchivo = "";


			String sql = "";
			if (ejercicio_id == 5) {
				sql = " select * from vista_f_649_2016 where id_puesto_laboral = :id ";
				nombreArchivo = dirTemp+"/formulario649-2016.xls";
			} else if (ejercicio_id == 6) {
				sql = " select * from vista_f_649_2017 where id_puesto_laboral = :id ";
				nombreArchivo = dirTemp+"/formulario649-2017.xls";
			}
			SqlRow s = Ebean.createSqlQuery(sql).setParameter("id", id).findUnique();






			File archivo = new File(nombreArchivo);
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/ganancias/formulario649.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Row f;

			f = hoja.getRow(2);
		    Font boldFont = libro.createFont();
		    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    RichTextString richFecha = new HSSFRichTextString("Fecha: " + DateUtils.formatDate(new Date()));
		    richFecha.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richFecha);

			f = hoja.getRow(3);
		    RichTextString richString = new HSSFRichTextString("Empleado: " + s.getString("agente_apellido"));
		    richString.applyFont(0, 9, boldFont);
		    f.getCell(0).setCellValue(richString);

		    f = hoja.getRow(4);
		    RichTextString richCuit = new HSSFRichTextString("CUIT: " + s.getString("agente_cuit"));
		    richCuit.applyFont(0, 5, boldFont);
		    f.getCell(0).setCellValue(richCuit);

		    f = hoja.getRow(6);
		    RichTextString richPeriodo = new HSSFRichTextString("Período Fiscal: " + s.getString("periodo_actual"));
		    richPeriodo.applyFont(0, 15, boldFont);
		    f.getCell(0).setCellValue(richPeriodo);

			Integer i = 9;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("s_bto_hospital").add(s.getBigDecimal("s_bto_otros")).doubleValue());

			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0);//no alcanzada
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("s_bto_no_alcanzado").doubleValue());  //exenta
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); // remuneracion otros emp


			i = 15;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("jubilac").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("obra_social").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0);
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("jub_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("os_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("sind_otros_emp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cuota_med_otros_emp").add(s.getBigDecimal("asist_medica")).doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_vida").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("seguro_sepelio").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //gastos estimativos
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //donaciones a fiscos
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //descuentos establecidos por ley nacional
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //horarios por servicios
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cred_hipot").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //aportes de capital
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("domestica").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(0); //caja complementaria
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_deducciones").doubleValue());



			i = 35;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("gan_no_imp").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_especial").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("deduccion_incrementada").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("cargas_familia").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("conyuge").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("hijos").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("otras_cargas").doubleValue());


			i = 44;
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("imp_determinado").doubleValue()); //imuesto determinado
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("imp_retenido").doubleValue());
			f = hoja.getRow(i++);
			f.getCell(1).setCellValue(s.getBigDecimal("pagos_a_cuenta").doubleValue()); // pagos a cuenta

			//leyenda
			f = hoja.getRow(i + 4);
			f.getCell(0).setCellValue(s.getString("leyenda_01")); // leyenda

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok();
	}

	public static Result listadoPuestosLaborales() {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/Listado.xls");

		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado puestos laborales.");
			return ok(respuestaModal.render());
		}

		try {

			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			Sheet hoja = libro.createSheet("Listado");

			List<PuestoLaboral> pl = PuestoLaboral.find
									.fetch("legajo")
									.fetch("legajo.agente")
									.where().in("id", seleccionadas).findList();

			if(pl.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);

				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Apellido y Nombre");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuit");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Relacion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("Fecha Alta");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Fecha Baja");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(5);
				celda0.setCellValue("Cuenta Bancaria");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(6);
				celda0.setCellValue("legajo");
				celda0.setCellStyle(comun);


				for(PuestoLaboral xx : pl){
					x++;
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(xx.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(xx.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue((xx.convenio_ministerio)?"CONVENIO":"PARQUE");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(utils.DateUtils.formatDate(xx.fecha_posesion));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(utils.DateUtils.formatDate(xx.fecha_baja));
					celda0.setCellStyle(comun);


					String cb = "";
					String sql = "SELECT c.id id,c.numero_cuenta numero_cuenta, sb.codigo sucursal " +
							" FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " INNER JOIN agentes a ON a.id = p.agente_id  "
							+ " WHERE a.id = :agente_id and c.estado_id = :estadoCuenta " +
							"order by id desc limit 1 ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("agente_id",xx.legajo.agente.id);
					sqlQuery.setParameter("estadoCuenta",Estado.CUENTA_BANCARIA_ESTADO_APROBADO);
					SqlRow row = sqlQuery.findUnique();
					if(row != null){
						cb  = row.getString("numero_cuenta");
					}

					celda0 = fila.createCell(5);
					celda0.setCellValue(cb);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(xx.legajo.numero);
					celda0.setCellStyle(comun);
				}
			}

			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(descargarArchivo.render(archivo.getPath()));
	}

	public static Result altasMacroSueldo(Boolean nuevo) {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado puestos laborales.");
			return ok(respuestaModal.render());
		}

		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/altas-masivas.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), Charset.forName( "UTF8")));

			String sql = "" +
					" select " +
					" 	a.id agenteId, " +
					" 	'001' sucursal, " +
					" 	trim(split_part(apellido, ',', 1)) apellido, " +
					"   trim(split_part(apellido, ',', 2)) nombre, " +
					" 	to_char(fnacimiento, 'dd/MM/yyyy') fecha_nacimiento, " +
					" 	case sexo when 'male' then 'M' else 'F' end sexo, " +
					" 	estado_civil, " +
					" 	'001' tipo_documento, " +
					" 	dni, " +
					" 	'08' tipo_identificacion_tributaria, " +
					" 	cuit numero_identificacion_tributaria, " +
					" 	zip codigo_postal, " +
					" 	prov.pais_id id_pais, " +
					" 	prov.id provincia, " +
					" 	prov.macro_id provincia_macro, " +
					" 	loc.nombre localidad, " +
					"   a.calle calle, " +
					"   a.numero calle_numero, " +
					" 	CAST(l.numero AS text) legajo, " +
					" 	CAST(el.importe_referencia AS text) sueldo_bruto " +
					" from puestos_laborales pl " +
					" inner join escalas_laborales_montos el on el.escala_laboral_id = pl.escala_laboral_id and el.liquidacion_concepto_id = 15 and el.activo =true " +
					" inner join legajos l on l.id = pl.legajo_id " +
					" inner join agentes a on a.id = l.agente_id " +
					" inner join localidades loc on loc.id = a.localidad_id " +
					" inner join provincias prov on prov.id = loc.provincia_id " +
					" where pl.id in (:listId)";

			List<SqlRow> lineas = Ebean.createSqlQuery(sql).setParameter("listId", seleccionadas).findList();

			String linea = "";

			Integer i = 1;
			boolean error = false;

			String stringError2 ="";
			for (SqlRow s : lineas) {
				String stringError = "";
				List<String> cadena = new ArrayList<>();

				if(nuevo) {




					//sucursal	3	numerico
					cadena.add(StringUtils.cortarString("1", 3)+"\t");

					//apellido	32	texto
					cadena.add(StringUtils.cortarString(s.getString("apellido"), 32)+"\t");
					//nombre		32	texto
					if(s.getString("nombre") != null &&  !s.getString("nombre").isEmpty()){
						cadena.add(StringUtils.cortarString(s.getString("nombre"), 32)+"\t");
					}else{
						error = true;
						stringError += "No tiene nombre.<br>";
					}



					//fechanacimiento	10	dd/mm/aaaa
					if(s.getString("fecha_nacimiento") != null && !s.getString("fecha_nacimiento").isEmpty()){
						cadena.add(s.getString("fecha_nacimiento")+"\t");
					}else{
						error = true;
						stringError += "No tiene fecha nacimiento.<br>";
					}
					//sexo		1	F o M
					if(s.getString("sexo") != null &&  !s.getString("sexo").isEmpty()){
						cadena.add(s.getString("sexo")+"\t");
					}else{
						error = true;
						stringError += "No tiene sexo.<br>";
					}
					//estadocivl	1	C o D o S o V
					String ec = s.getString("estado_civil");

					if(ec == null || ec.isEmpty()) {
						ec = "S";
					} else {
						ec = EstadoCivil.getBancoId(s.getString("estado_civil"));
					}
					cadena.add(ec+"\t");

					//tipoDocumento	2	01 o 02 o 03
					cadena.add("01"+"\t");
					//dni		8	numerico
					cadena.add(StringUtils.cortarString(s.getString("dni"), 8)+"\t");

					//tipoidentivcacion2	08 o 09 o 11
					cadena.add("08"+"\t");
					//numero		11	numerico
					cadena.add(StringUtils.cortarString(s.getString("numero_identificacion_tributaria"), 11)+"\t");

					//codigonacional	3	tabla
					if(s.getString("id_pais") != null && !s.getString("id_pais").isEmpty() && s.getString("id_pais").compareTo("11") == 0){

						cadena.add(StringUtils.cortarString("80", 3)+"\t");

					}else{
						error = true;
						stringError += "No tiene Pais Argentina Cargado.<br>";
					}

					//codigoposta	4	numerico
					if(s.getString("codigo_postal") != null && !s.getString("codigo_postal").isEmpty()){
						cadena.add(StringUtils.cortarString(s.getString("codigo_postal"), 4)+"\t");
					}else{
						error = true;
						stringError += "No tiene CP.<br>";
					}
					//codprovinci	2	tabla
					if(s.getString("provincia_macro") != null && !s.getString("provincia_macro").isEmpty()){
						cadena.add(StringUtils.cortarString(s.getString("provincia_macro"), 2)+"\t");
					}else{
						error = true;
						stringError += "No tiene Codigo de Provincia Banco Macro<br>";
					}


					//localidad	64	texto
					if(s.getString("localidad") != null && !s.getString("localidad").isEmpty()){
						cadena.add(StringUtils.cortarString(s.getString("localidad"), 64)+"\t");
					}else{
						error = true;
						stringError += "No tiene localidad<br>";
					}

					//calle		27	texto
					if(s.getString("calle") != null && !s.getString("calle").isEmpty()){
						//cadena.add(StringUtils.cortarString(s.getString("calle"), 27));
						cadena.add("MÁRCONI"+"\t");
					}else{
						error = true;
						stringError += "No calle<br>";
					}

					//numero		5	numerico
					if(s.getString("calle_numero") != null && !s.getString("calle_numero").isEmpty()){
						//cadena.add(StringUtils.cortarString(s.getString("calle_numero"),5));
						cadena.add("3736"+"\t");
					}else{
						//cadena.add(StringUtils.cortarString("0",5)+"\t");
						cadena.add("3736"+"\t");
					}
					cadena.add("\t");//piso
					cadena.add("\t");//depto
					cadena.add("\t");//barrio
					cadena.add("\t");//	telefono
					cadena.add("\t");//codigo
					cadena.add("\t");//telefono
					cadena.add("\t");//interno
					cadena.add("\r\n");//mail




				}else {

					cadena.add(numerico(s.getString("legajo"), 10));

					if(s.getString("nombre") != null &&  !s.getString("nombre").isEmpty()){
						cadena.add(alfanumerico(s.getString("nombre"), 32));
					}else{
						error = true;
						stringError += "No tiene nombre.<br>";
					}
					cadena.add(alfanumerico(s.getString("apellido"), 32));

					if(s.getString("fecha_nacimiento") != null && !s.getString("fecha_nacimiento").isEmpty()){
						cadena.add(s.getString("fecha_nacimiento"));
					}else{
						error = true;
						stringError += "No tiene fecha nacimiento.<br>";
					}

					if(s.getString("sexo") != null &&  !s.getString("sexo").isEmpty()){
						cadena.add(s.getString("sexo"));
					}else{
						error = true;
						stringError += "No tiene sexo.<br>";
					}

					String ec = s.getString("estado_civil");

					if(ec == null || ec.isEmpty()) {
						ec = "S";
					} else {
						ec = EstadoCivil.getBancoId(s.getString("estado_civil"));
					}
					cadena.add(ec);

					//cadena.add(alfanumerico(s.getString("calle").replace("\"","").replace("  "," ").replace("ñ","n").replace("Ñ","N").replace(".","").replace(";","").replace("º","").replace("°","").replace("-","").replace("_","").replace("/",""), 100));
					cadena.add(alfanumerico("Marconi", 100));
					cadena.add(numerico("3736", 5)); //numero
					cadena.add(alfanumerico("", 2)); //piso
					cadena.add(alfanumerico("", 2)); //depto

					if(s.getString("codigo_postal") != null && !s.getString("codigo_postal").isEmpty()){
						cadena.add(numerico(s.getString("codigo_postal"), 4));
					}else{
						error = true;
						stringError += "No tiene CP.<br>";
					}

					if(s.getString("localidad") != null && !s.getString("localidad").isEmpty()){
						cadena.add(alfanumerico(s.getString("localidad"), 30));
						//cadena.add(alfanumerico("POSADAS", 30));
					}else{
						error = true;
						stringError += "No Localidad.<br>";
					}

					//cadena.add(Provincia.getBancoId(s.getInteger("provincia")));
					cadena.add("14");
					cadena.add(s.getString("tipo_documento"));
					cadena.add(alfanumerico(s.getString("dni"), 11));
					cadena.add(s.getString("tipo_identificacion_tributaria"));
					cadena.add(numerico(s.getString("numero_identificacion_tributaria"), 11));

					/*String sql2 = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " INNER JOIN agentes a ON a.id = p.agente_id  "
							+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND a.id = :agente_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql2);
					sqlQuery.setParameter("agente_id",s.getInteger("agenteId"));

					SqlRow row = sqlQuery.findUnique();
					if(row == null){
						stringError += "No tiene cuenta bancaria cargada o aprobada nombre:"+ s.getString("nombre")+".<br>";
						flash("error", stringError);
						return ok(descargarArchivo.render(null));
					}*/


					cadena.add(alfanumerico("001", 3));
					cadena.add(alfanumerico("4", 1));
					//cadena.add(alfanumerico(row.getString("numero_cuenta"), 15));
					cadena.add(alfanumerico("000000000000000", 15));
					cadena.add(alfanumerico("61310", 5));
					cadena.add(alfanumerico("5000", 4));

					if(!stringError.isEmpty()){
						stringError2 += s.getString("apellido")+"<br>"+stringError+"<br><br>";
					}
					cadena.add("\r\n");

				}










				//cadena.add(newLine);
				out.append(StringUtils.implode(cadena, ""));
				//out.append("\r\n");
				i++;


			}

			out.flush();
			out.close();

			if(error){
				flash("error", stringError2);
				return ok(descargarArchivo.render(null));
			}else{
				flash("success", "El archivo fue creado correctamente.");
				return ok(descargarArchivo.render(archivo.getPath()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());
	}

	public static Result altasMasivas() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado puestos laborales.");
			return ok(respuestaModal.render());
		}

		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/altas-masivas.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));


			out.append(
					"AMS" + //tipo de registro fijo
					DateUtils.formatDate(new Date(), "ddMMyyyy") + //fecha de creació
					"AM02" + //versión fijo Fijo
					Strings.padStart("61310", 7, '0') + //convenio ???
					"00" + //release
					Strings.padEnd("Parque de la salud", 30, ' ') + //razón social
					newLine
			);


			String sql = "" +
					" select " +
					" 	'001' sucursal, " +
					" 	trim(split_part(apellido, ',', 1)) apellido, " +
					"   trim(split_part(apellido, ',', 2)) nombre, " +
					" 	to_char(fnacimiento, 'ddMMyyyy') fecha_nacimiento, " +
					" 	case sexo when 'male' then 'M' else 'F' end sexo, " +
					" 	estado_civil, " +
					" 	'001' tipo_documento, " +
					" 	dni, " +
					" 	'08' tipo_identificacion_tributaria, " +
					" 	cuit numero_identificacion_tributaria, " +
					" 	zip codigo_postal, " +
					" 	prov.id provincia, " +
					" 	loc.nombre localidad, " +
					"   a.calle calle, " +
					" 	CAST(l.numero AS text) legajo, " +
					" 	CAST(el.importe_referencia AS text) sueldo_bruto " +
					" from puestos_laborales pl " +
					" inner join escalas_laborales_montos el on el.escala_laboral_id = pl.escala_laboral_id and el.liquidacion_concepto_id = 15 and el.activo =true " +
					" inner join legajos l on l.id = pl.legajo_id " +
					" inner join agentes a on a.id = l.agente_id " +
					" inner join localidades loc on loc.id = a.localidad_id " +
					" inner join provincias prov on prov.id = loc.provincia_id " +
					" where pl.id in (:listId)";

			List<SqlRow> lineas = Ebean.createSqlQuery(sql).setParameter("listId", seleccionadas).findList();

			String linea = "";

			Integer i = 1;
			boolean error = false;

			String stringError2 ="";
			for (SqlRow s : lineas) {
				String stringError = "";
				List<String> cadena = new ArrayList<>();
				cadena.add(numerico(i.toString(), 6));
				cadena.add(numerico(s.getString("sucursal"), 3));
				cadena.add(alfanumerico(s.getString("apellido"), 32));


				if(s.getString("nombre") != null &&  !s.getString("nombre").isEmpty()){
					cadena.add(alfanumerico(s.getString("nombre"), 32));
				}else{
					error = true;
					stringError += "No tiene nombre.<br>";
				}

				if(s.getString("fecha_nacimiento") != null && !s.getString("fecha_nacimiento").isEmpty()){
					cadena.add(s.getString("fecha_nacimiento"));
				}else{
					error = true;
					stringError += "No tiene fecha nacimiento.<br>";
				}

				if(s.getString("sexo") != null &&  !s.getString("sexo").isEmpty()){
					cadena.add(s.getString("sexo"));
				}else{
					error = true;
					stringError += "No tiene sexo.<br>";
				}


				String ec = s.getString("estado_civil");

				if(ec == null || ec.isEmpty()) {
					ec = "S";
				} else {
					ec = EstadoCivil.getBancoId(s.getString("estado_civil"));
				}


				cadena.add(ec);
				cadena.add(s.getString("tipo_documento"));
				cadena.add(alfanumerico(s.getString("dni"), 13));
				cadena.add(s.getString("tipo_identificacion_tributaria"));
				cadena.add(numerico(s.getString("numero_identificacion_tributaria"), 13));

				if(s.getString("codigo_postal") != null && !s.getString("codigo_postal").isEmpty()){
					cadena.add(numerico(s.getString("codigo_postal"), 4));
				}else{
					error = true;
					stringError += "No tiene CP.<br>";
				}
				cadena.add(Provincia.getBancoId(s.getInteger("provincia")));

				if(s.getString("localidad") != null && !s.getString("localidad").isEmpty()){
					cadena.add(alfanumerico(s.getString("localidad"), 30));
				}else{
					error = true;
					stringError += "No Localidad.<br>";
				}

				cadena.add(alfanumerico(s.getString("calle"), 100));
				cadena.add(numerico("", 5)); //numero
				cadena.add(alfanumerico("", 2)); //depto
				cadena.add(alfanumerico("", 2)); //piso

				cadena.add(alfanumerico("", 11)); //telefono
				cadena.add(numerico(s.getString("legajo"), 10));

				if(s.getString("sueldo_bruto") != null && !s.getString("sueldo_bruto").isEmpty() ){
					cadena.add(numerico(s.getString("sueldo_bruto"), 10)); //legajo
				}else{
					cadena.add(numerico("0", 10)); //legajo
					//error = true;
					//stringError += "No Sueldo Referencia.<br>";
				}

				if(!stringError.isEmpty()){
					stringError2 += s.getString("apellido")+"<br>"+stringError+"<br><br>";
				}

				cadena.add(newLine);
				i++;

				out.append(StringUtils.implode(cadena, ""));
			}




			System.out.println("+++"+"000001001ACUÑA                           CARLOS ALEJANDRO                01091972MS00116071209     080020160712091000014POSADAS                       CH 19- Bº SAN MIGUEL                                                                                00000               00000000080000008529".length());

			out.flush();
			out.close();

			if(error){
				flash("error", stringError2);
				return ok(descargarArchivo.render(null));
			}else{
				flash("success", "El archivo fue creado correctamente.");
				return ok(descargarArchivo.render(archivo.getPath()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());
	}

	private static String numerico(String valor, Integer longitud) {
		if (valor != null) {
			valor = valor.trim();
			if(valor.length() > longitud) {
				valor = valor.substring(0,longitud);
			}
		} else {
			valor = "";
		}

		return Strings.padStart(valor, longitud, '0');
	}
	private static String alfanumerico(String valor, Integer longitud) {
		if (valor != null) {
			valor = valor.trim();
			if(valor.length() > longitud) {
				valor = valor.substring(0,longitud);
			}
		} else {
			valor = "";
		}

		return Strings.padEnd(valor, longitud, ' ');
	}

	public static Result descargarArchivo(String url){
		return ok(new File(url));
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

}
