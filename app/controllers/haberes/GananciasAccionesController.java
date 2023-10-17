package controllers.haberes;

import static play.data.Form.form;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import models.Agente;
import models.haberes.PuestoLaboral;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.postgresql.util.PSQLException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import play.Play;
import play.libs.XPath;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import utils.DateUtils;
import views.html.contabilidad.facturas.acciones.reporte322;
import views.html.haberes.puestosLaborales.acciones.*;
import views.html.haberes.puestosLaborales.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;

public class GananciasAccionesController extends Controller {

	/*
	 * -documentos_tipos
	 * -parentesco_tipos
	 * -ganancias_presentaciones
	 * -ganancias_cargas_familia
	 * -ganancias_deducciones_572
	 * -ganancias_deducciones_572_tipos
	 * -ganancias_ajustes
	 * -ganancias_liq_otros_emp_ant
	 * -ganancias_ingresos_aportes
	 * -ganancias_ret_per_pagos
	 */

	public static Result modalFormularioF649() throws ZipException {

		List<Integer> facturasSeleccionados = getSeleccionados();
		if (facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar al menos un puesto laboral.");
			return ok(modalFormularioF649.render(null));
		}

		String sql = "select " +
				" a.cuit,  " +
				" a.apellido,  " +
				" a.calle, " +
				" a.numero, " +
				" 'FUNDACION PARQUE DE LA SALUD' razon_social, " +
				" '30111636842' cuit_parque, " +
				" coalesce(sum(total_haberes.bruto_ganancias),0) bruto_ganancias,  " +
				" coalesce(sum(total_desc.ap_jub),0) aportes_jubilatorios, " +
				" coalesce(sum(total_desc.ap_os),0) aportes_obra_social, " +
				" coalesce(sum(total_desc.ap_svida),0) aportes_seg_vida, " +
				" coalesce(sum(total_desc.ap_ssepelio),0) aportes_seg_sepelio, " +
				" coalesce((SELECT bc_deduccionesadmitidas_649(cast(e.nombre as integer),a.id, 2)),0) deduccion_especial, "
				+
				" coalesce((SELECT bc_deduccionesadmitidas_649(cast(e.nombre as integer),a.id, 4)),0) deduccion_gan_no_imponible, "
				+
				" coalesce((SELECT bc_deduccionesadmitidas_649(cast(e.nombre as integer),a.id, 1)),0) deduccion_conyuge,     "
				+
				" coalesce((SELECT bc_deduccionesadmitidas_649(cast(e.nombre as integer),a.id, 0)),0) deduccion_hijos "
				+
				" from liquidacion_puestos lp " +
				" join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id " +
				" join puestos_laborales pl on lp.puesto_laboral_id = pl.id " +
				" join legajos l on pl.legajo_id = l.id " +
				" join agentes a on l.agente_id = a.id " +
				" join periodos p on lm.periodo_id = p.id     " +
				" join ejercicios e on p.ejercicio_id = e.id " +
				" left join ( " +
				" select lp.id, sum(ld.importe*ld.cantidad) bruto_ganancias " +
				" from liquidacion_detalles ld " +
				" join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id " +
				" join liquidacion_concepto_tipos lct on lc.liquidacion_concepto_tipo_id = lct.id " +
				" join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id " +
				" join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id " +
				" join puestos_laborales pl on lp.puesto_laboral_id = pl.id " +
				" where (lct.id = 1 or lct.id = 2) and lc.deduce_ganancias is true " +
				" group by lp.id " +
				" ) total_haberes on total_haberes.id = lp.id " +
				" left join ( " +
				" select lp.id, " +
				" sum(case when lc.codigo = '30002' then (ld.importe*ld.cantidad) end) ap_jub, " +
				" sum(case when lc.codigo = '30001' then (ld.importe*ld.cantidad) end) ap_os, " +
				" sum(case when lc.codigo = '30003' then (ld.importe*ld.cantidad) end) ap_svida, " +
				" sum(case when lc.codigo = '30004' then (ld.importe*ld.cantidad) end) ap_ssepelio " +
				" from liquidacion_detalles ld " +
				" join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id " +
				" join liquidacion_concepto_tipos lct on lc.liquidacion_concepto_tipo_id = lct.id " +
				" join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id " +
				" join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id " +
				" join puestos_laborales pl on lp.puesto_laboral_id = pl.id " +
				" where (lct.id = 3)  " +
				" group by lp.id " +
				" ) total_desc on total_desc.id = lp.id " +
				" where cast(e.nombre as integer) = 2015 AND pl.id IN(:listId) " +
				" group by a.cuit, a.apellido,a.calle,a.numero, e.nombre, a.id;";

		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		String salida = "rrrr";
		File archivo = null;
		List<String> fileList = new ArrayList<String>();
		byte[] buffer = new byte[1024];

		try {

			if (l.size() > 1) {
				salida = System.getProperty("java.io.tmpdir") + "listaF649.zip";
				FileOutputStream fos = new FileOutputStream(salida);
				ZipOutputStream zos = new ZipOutputStream(fos);

				for (SqlRow r : l) {
					archivo = crearArchivo649(r);
					FileInputStream fis = new FileInputStream(archivo);
					zos.putNextEntry(new ZipEntry(archivo.getName()));

					int length;
					while ((length = fis.read(buffer)) > 0) {
						zos.write(buffer, 0, length);
					}
					zos.closeEntry();
					fis.close();
				}

				zos.close();

			} else {
				archivo = crearArchivo649(l.get(0));
				salida = archivo.getAbsolutePath();
			}

		} catch (IOException e) {
			flash("error", "No se pudo crear el archivo");
			e.printStackTrace();
		} catch (Exception e) {
			flash("error", "No se pudo completar la operación");
			e.printStackTrace();
		}

		return ok(modalFormularioF649.render(salida));
	}

	private static File crearArchivo649(SqlRow r) throws IOException, ZipException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp + "/F649-" + r.getString("cuit") + ".xls");

		if (archivo.exists())
			archivo.delete();

		FileInputStream file = new FileInputStream(
				Play.application().getFile("conf/resources/reportes/haberes/ganancias/F649.xls"));

		Workbook libro = new HSSFWorkbook(file);
		FileOutputStream archivoTmp = new FileOutputStream(archivo);
		Sheet hoja = libro.getSheetAt(0);
		Row row;

		row = hoja.getRow(3);

		// Cuit y cuil
		row.getCell(4).setCellValue(r.getString("cuit"));
		row.getCell(7).setCellValue(r.getString("cuil"));

		// Nombre
		row = hoja.getRow(4);
		row.getCell(6).setCellValue(r.getString("apellido"));

		// Domicilio
		row = hoja.getRow(6);
		row.getCell(3).setCellValue(r.getString("calle"));
		row.getCell(7).setCellValue(r.getString("numero"));
		row.getCell(8).setCellValue("piso");
		row.getCell(9).setCellValue("depto");

		// Importes

		row = hoja.getRow(23);
		row.getCell(9).setCellValue(r.getDouble("bruto_ganancias"));

		row = hoja.getRow(32);
		row.getCell(9).setCellValue(new Double(1.1));

		libro.write(archivoTmp);

		libro.getSheetAt(1);
		row = hoja.getRow(6);
		row.getCell(9).setCellValue(new Double(1.2));
		libro.write(archivoTmp);

		return archivo;
	}

	public static Result modalBuscarDatosGananciasEnArchivos() {
		return ok(modalBuscarDatosGananciasEnArchivos.render(form().bindFromRequest()));
	}

	private static final int BUFFER_SIZE = 4096;

	/**
	 * Extracts a zip file specified by the zipFilePath to a directory specified by
	 * destDirectory (will be created if does not exists)
	 *
	 * @param zipFilePath
	 * @param destDirectory
	 * @throws IOException
	 */
	public static void unzip(String zipFilePath, String destDirectory) throws IOException {
		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
		ZipEntry entry = zipIn.getNextEntry();
		// iterates over entries in the zip file

		while (entry != null) {
			String filePath = destDirectory + File.separator + entry.getName();
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath);
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdir();
			}
			zipIn.closeEntry();
			entry = zipIn.getNextEntry();
		}
		zipIn.close();
	}

	/**
	 * Extracts a zip entry (file entry)
	 *
	 * @param zipIn
	 * @param filePath
	 * @throws IOException
	 */
	private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}

	public static Result buscarDatosGananciasEnArchivos() throws IOException {
		MultipartFormData body = request().body().asMultipartFormData();

		String dirTemp = System.getProperty("java.io.tmpdir");
		String ahora = "ganancias-" + Calendar.getInstance().getTime().getTime();
		String ruta = dirTemp + "/" + ahora;
		File archivo = new File(ruta);
		archivo.mkdirs();

		try {
			File myfile = body.getFile("myfile").getFile();
			String absolutePath = myfile.getAbsolutePath();

			new ZipFile(myfile);

			unzip(absolutePath, ruta);
		} catch (NullPointerException e) {
			flash("error", "Debe seleccionar el archivo.");
			return ok(modalBuscarDatosGananciasEnArchivos.render(form().bindFromRequest()));
		} catch (ZipException e) {
			flash("error", "Debe seleccionar un archivo ZIP.");
			return ok(modalBuscarDatosGananciasEnArchivos.render(form().bindFromRequest()));
		} catch (Exception e) {
			flash("error", "Error en archivo. - " + e);
			return ok(modalBuscarDatosGananciasEnArchivos.render(form().bindFromRequest()));
		}

		Boolean todoOk = true;

		try {
			Ebean.beginTransaction();

			for (File fileEntry : archivo.listFiles()) {
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder;

				docBuilder = docBuilderFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(fileEntry);
				System.out.println("++++++++" + fileEntry.getName());
				if (!procesarXml(doc)) {
					todoOk = false;
					break;
				}

			}

			if (todoOk) {
				flash("success", "Se han procesado " + archivo.listFiles().length + " archivos.");
				Ebean.commitTransaction();
			} else {
				Ebean.rollbackTransaction();
			}

		} catch (ParserConfigurationException e) {
			flash("error", "No se puedo procesar los archivos.");
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} catch (SAXException e) {
			flash("error", "No se puedo leer los archivos.");
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} catch (PSQLException p) {
			flash("error", "No se puedo lmacenar los datos.");
			Ebean.rollbackTransaction();
			p.printStackTrace();
		} catch (Exception e) {
			flash("error", "No se puedo realizar la operación.");
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalBuscarDatosGananciasEnArchivos.render(form().bindFromRequest()));
	}

	private static Boolean procesarXml(Document doc) throws PSQLException {
		try {
			doc.getDocumentElement().normalize();
		} catch (Exception e) {

		}

		String cuit = XPath.selectText("/presentacion/empleado/cuit", doc);

		// Compruebo que esxista el cuit y el agente
		Agente a = Agente.find.where().eq("cuit", cuit).findUnique();

		if (a == null) {
			flash("error", "No se encuentra el agente con cuit <b>" + cuit + "</b>.");
			return false;
		}
		Integer idPresentacion = null;

		Integer periodo = Integer.parseInt(XPath.selectText("//periodo", doc).toString());
		Integer nroPresentacion = Integer.parseInt(XPath.selectText("//nroPresentacion", doc).toString());
		String fechaPresentacion = XPath.selectText("//fechaPresentacion", doc).toString();

		// Elimino el registro de puesto laboral y mismo periodo
		Ebean.createSqlUpdate("delete from ganancias_presentaciones where agente_id = " + a.id
				+ " AND presentacion_nro = " + nroPresentacion + " AND periodo_anio = " + periodo).execute();

		// Cargo datos en la tabla ganancias_presentaciones
		Boolean procesoPresentacion = cargarPresentacion(a.id, periodo, nroPresentacion, fechaPresentacion);

		if (procesoPresentacion) {
			idPresentacion = Ebean.createSqlQuery("SELECT currval('ganancias_presentaciones_id_seq') id;").findUnique()
					.getInteger("id");
		} else {
			flash("error", "La presentación de " + a.apellido + " no se puedo insertar");
			return false;
		}

		// Cargo archivos _b

		NodeList otrosEmpleadores = XPath.selectNodes("//agenteRetencion", doc);
		for (int i = 0; i < otrosEmpleadores.getLength(); i++) {
			Element oe = (Element) otrosEmpleadores.item(i);

			Boolean procesoOtrosEmpleadores = cargarOtrosEmpleadores(
					idPresentacion,
					XPath.selectText("cuit", oe),
					XPath.selectText("denominacion", oe));

			if (!procesoOtrosEmpleadores) {
				flash("error", "La carga de otros empleadores de " + a.apellido + " no se pudo insertar");
				return false;
			}
		}

		// Cargo datos en la tabla ganancias_cargas_familia

		NodeList familias = XPath.selectNodes("//cargasFamilia/cargaFamilia", doc);

		for (int i = 0; i < familias.getLength(); i++) {
			Element f = (Element) familias.item(i);

			String porDed = XPath.selectText("porcentajeDeduccion", f).toString();

			Boolean procesoFamilia = cargarFamilia(
					idPresentacion,
					Integer.parseInt(XPath.selectText("tipoDoc", f).toString()),
					Long.valueOf(XPath.selectText("nroDoc", f).toString()),
					XPath.selectText("apellido", f).toString(),
					XPath.selectText("nombre", f).toString(),
					XPath.selectText("fechaNac", f).toString(),
					Integer.parseInt(XPath.selectText("mesDesde", f).toString()),
					Integer.parseInt(XPath.selectText("mesHasta", f).toString()),
					Integer.parseInt(XPath.selectText("parentesco", f).toString()),
					(XPath.selectText("vigenteProximosPeriodos", f).toString() == "S"),
					XPath.selectText("fechaLimite", f).toString(),
					(porDed.isEmpty()) ? null : new BigDecimal(porDed));
			if (!procesoFamilia) {
				flash("error", "La carga de familia de " + a.apellido + " no se puedo insertar");
				return false;
			}

		}

		// Cargo deducciones

		/*NodeList listaEmpleados = doc.getElementsByTagName("deduccion");
		for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
            Node nodo = listaEmpleados.item(temp);

            System.out.println("Elemento:" + nodo.getNodeName());

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                System.out.println("tipo: " + element.getAttribute("tipo"));
                System.out.println("tipoDoc: " + element.getElementsByTagName("tipoDoc").item(0).getTextContent());

                System.out.println("detalles: " + element.getElementsByTagName("detalles").item(0).getChildNodes().item(0).getTextContent().toString());


            }
        }*/



		NodeList deducciones = XPath.selectNodes("//deducciones/deduccion", doc);
		for (int i = 0; i < deducciones.getLength(); i++) {
			Element d = (Element) deducciones.item(i);

			Integer idDeducciones = cargarDeduccion(
					idPresentacion,
					Integer.parseInt(XPath.selectText("@tipo", d).toString()),
					Integer.parseInt(XPath.selectText("tipoDoc", d).toString()),
					Long.valueOf(XPath.selectText("nroDoc", d).toString()),
					XPath.selectText("denominacion", d).toString(),
					XPath.selectText("descBasica", d).toString(),
					XPath.selectText("descAdicional", d).toString(),
					new BigDecimal(XPath.selectText("montoTotal", d).toString()),
					1);
			if (idDeducciones == null) {
				flash("error", "La carga de deducciones de " + a.apellido + " no se puedo insertar");
				return false;
			} else {



				NodeList detallesDeducciones = XPath.selectNodes("detalles", d);

				for (int dd = 0; dd < detallesDeducciones.getLength(); dd++) {
					Element edd = (Element) detallesDeducciones.item(dd);
					NodeList detalles = XPath.selectNodes("detalle", edd);
					for (int ddh = 0; ddh < detalles.getLength(); ddh++) {
						Element eddh = (Element) detalles.item(ddh);
						System.out.println("---------- ---------- ---------- ----------");

						System.out.println("---------- "+eddh.getNodeName());
						System.out.println("---------- "+XPath.selectText("@nombre", eddh).toString());
						System.out.println("---------- "+XPath.selectText("@valor", eddh).toString());
						//<detalle nombre="motivo" valor="2"/>
						System.out.println("---------- ---------- ---------- ----------");

						cargarDeduccionDetalle(idDeducciones, XPath.selectText("@nombre", eddh).toString(),XPath.selectText("@valor", eddh).toString());
					}
				}

				NodeList periodosDeducciones = XPath.selectNodes("periodos", d);

				for (int dd = 0; dd < periodosDeducciones.getLength(); dd++) {

					Element edd = (Element) periodosDeducciones.item(dd);
					NodeList periodox = XPath.selectNodes("periodo", edd);
					for (int ddh = 0; ddh < periodox.getLength(); ddh++) {
						Element eddh = (Element) periodox.item(ddh);
						System.out.println("---------- ---------- ---------- ----------");
						//<periodo mesDesde="1" mesHasta="1" montoMensual="27370.00"/>

						System.out.println("---------- "+eddh.getNodeName());
						System.out.println("---------- "+XPath.selectText("@mesDesde", eddh).toString());
						System.out.println("---------- "+XPath.selectText("@mesHasta", eddh).toString());
						System.out.println("---------- "+XPath.selectText("@montoMensual", eddh).toString());

						System.out.println("---------- ---------- ---------- ----------");

						cargarDeduccionPeriodos(idDeducciones, XPath.selectText("@mesDesde", eddh).toString(),XPath.selectText("@mesHasta", eddh).toString(),new BigDecimal(XPath.selectText("@montoMensual", eddh).toString()));
					}
				}

				System.out.print("---------- Se cargó cargarDeduccion");
			}

		}

		System.out.print("---------- Se cargó cargarDeduccion");
		// Cargo retPerPago
		NodeList retPerPagos = XPath.selectNodes("//retPerPagos/retPerPago ", doc);
		System.out.println("-----------------" + retPerPagos.getLength());
		for (int i = 0; i < retPerPagos.getLength(); i++) {
			Element r = (Element) retPerPagos.item(i);

			String tipoDoc = XPath.selectText("ret_tipo", r).toString();
			String nroDoc = XPath.selectText("nroDoc", r).toString();
			String deno = XPath.selectText("denominacion", r).toString();

			Integer tipoAttr = Integer.parseInt(XPath.selectText("@tipo", r).toString());
			System.out.println("-----------------" + tipoAttr);
			Boolean procesoRetPerPagos = cargarRetPerPagos(
					idPresentacion,
					(tipoDoc.isEmpty()) ? null : Integer.parseInt(tipoDoc),
					(nroDoc.isEmpty()) ? null : Long.valueOf(nroDoc),
					(deno.isEmpty()) ? "" : deno,
					XPath.selectText("descBasica", r).toString(),
					XPath.selectText("descr_adicional", r).toString(),
					new BigDecimal(XPath.selectText("montoTotal", r).toString()),
					tipoAttr);
			if (!procesoRetPerPagos) {
				flash("error", "La carga de retPerPagos de " + a.apellido + " no se puedo insertar");
				return false;
			} else {
				System.out.print("---------- Se cargó cargarRetPerPagos");
			}

		}

		// Cargo ganancias_liq_otros_emp_ent
		NodeList ganLiqOtrosEmpEnt = XPath.selectNodes("//ganLiqOtrosEmpEnt/empEnt ", doc);
		for (int i = 0; i < ganLiqOtrosEmpEnt.getLength(); i++) {
			Element e = (Element) ganLiqOtrosEmpEnt.item(i);
			String tipoDoc = XPath.selectText("tipoDoc", e).toString();
			String nroDoc = XPath.selectText("nroDoc", e).toString();
			String deno = XPath.selectText("denominacion", e).toString();

			Integer idEmpEnt = cargarEmpEnt(
					idPresentacion,
					(tipoDoc.isEmpty()) ? null : Integer.parseInt(tipoDoc),
					(nroDoc.isEmpty()) ? null : Long.valueOf(nroDoc),
					(deno.isEmpty()) ? "" : deno);

			if (idEmpEnt == null) {
				flash("error", "La carga de empEnt de " + a.apellido + " no se puedo insertar");
				return false;
			} else {
				System.out.print("---------- Se cargó cargarEmpEnt");
			}

			NodeList ingresosAportes = XPath.selectNodes("ingresosAportes/ingAp", e);

			for (int c = 0; c < ingresosAportes.getLength(); c++) {
				Element g = (Element) ingresosAportes.item(c);

				String exeNoAlc = XPath.selectText("exeNoAlc", g).toString();
				String sac = XPath.selectText("sac", g).toString();
				String gastosMovViat = XPath.selectText("gastosMovViat", g).toString();
				cargarIngresosAportes(
						idEmpEnt,
						Integer.parseInt(g.getAttribute("mes")),
						new BigDecimal(XPath.selectText("obraSoc", g).toString()),
						new BigDecimal(XPath.selectText("segSoc", g).toString()),
						new BigDecimal(XPath.selectText("sind", g).toString()),
						new BigDecimal(XPath.selectText("ganBrut", g).toString()),
						new BigDecimal(XPath.selectText("retGan", g).toString()),
						new BigDecimal(XPath.selectText("retribNoHab", g).toString()),
						new BigDecimal(XPath.selectText("ajuste", g).toString()),
						(exeNoAlc.isEmpty()) ? null : new BigDecimal(exeNoAlc),
						(sac.isEmpty()) ? null : new BigDecimal(sac),
						new BigDecimal(XPath.selectText("horasExtGr", g).toString()),
						new BigDecimal(XPath.selectText("horasExtEx", g).toString()),
						new BigDecimal(XPath.selectText("matDid", g).toString()),
						(gastosMovViat.isEmpty()) ? null : new BigDecimal(gastosMovViat));
			}

		}

		// Cargo deducciones
		NodeList ajustes = XPath.selectNodes("//ajustes", doc);
		for (int i = 0; i < deducciones.getLength(); i++) {

			Element d = (Element) deducciones.item(i);

			String descBasica = XPath.selectText("descBasica", d).toString();
			String descr_adicional = XPath.selectText("descAdicional", d).toString();

			Boolean procesoDeducciones = cargarAjustes(
					idPresentacion,
					XPath.selectText("cuit", d).toString(),
					XPath.selectText("denominacion", d).toString(),
					(descBasica.isEmpty()) ? null : descBasica,
					(descr_adicional.isEmpty()) ? null : descr_adicional,
					new BigDecimal(1.2));
			if (!procesoDeducciones) {
				flash("error", "La carga de deducciones de " + a.apellido + " no se puedo insertar");
				return false;
			} else {
				System.out.print("---------- Se cargó cargarAjustes");
			}

		}

		// Cargo datos adicionales
		NodeList datosAdicionales = XPath.selectNodes("//datosAdicionales/datoAdicional", doc);
		for (int i = 0; i < datosAdicionales.getLength(); i++) {

			Element da = (Element) datosAdicionales.item(i);

			Boolean procesoDatosAdicionales = cargarDatosAdicionales(
					idPresentacion,
					da.getAttribute("nombre"),
					da.getAttribute("valor"));
			if (!procesoDatosAdicionales) {
				flash("error", "Los datos adicionales de " + a.apellido + " no se puedo insertar");
				return false;
			}

		}

		return true;
	}

	private static Boolean cargarDatosAdicionales(Integer idPresentacion, String nombre, String valor) {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_datos_adicionales (ganancias_presentacion_id, nombre, valor) VALUES (:ganancias_presentacion_id, :nombre, :valor)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("nombre", nombre);
		insert.setParameter("valor", valor);

		if (insert.execute() == 0) {
			return null;
		}

		return true;

	}

	private static Integer cargarEmpEnt(Integer idPresentacion, Integer tipoDoc, Long nroDoc, String denominacion)
			throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_liq_otros_emp_ent (ganancias_presentacion_id, documento_tipo, documento_nro, denominacion) VALUES (:ganancias_presentacion_id, :documento_tipo, :documento_nro, :denominacion)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("documento_tipo", tipoDoc);
		insert.setParameter("documento_nro", nroDoc);
		insert.setParameter("denominacion", denominacion);

		if (insert.execute() == 0) {
			return null;
		}

		return Ebean.createSqlQuery("SELECT currval('ganancias_liq_otros_emp_ent_id_seq') id;").findUnique()
				.getInteger("id");
	}

	private static Integer cargarIngresosAportes(Integer idEmpEnt, Integer mes, BigDecimal obraSoc, BigDecimal segSoc,
			BigDecimal sind, BigDecimal ganBrut, BigDecimal retGan, BigDecimal retribNoHab, BigDecimal ajuste,
			BigDecimal exeNoAlc, BigDecimal sac, BigDecimal horasExtGr, BigDecimal horasExtEx, BigDecimal matDid,
			BigDecimal gastosMovViat) throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_liq_otros_emp_ent_det (liq_emp_ent_id, mes, obra_soc, seg_soc, sind, gan_brut, ret_gan, retrib_no_hab, ajuste, exe_no_alc, sac, hs_ext_gr, hs_ext_ex, mat_did, mov_viat) VALUES (:liq_emp_ent_id, :mes, :obra_soc, :seg_soc, :sind, :gan_brut, :ret_gan, :retrib_no_hab, :ajuste, :exeNoAlc, :sac, :horasExtGr, :horasExtEx, :matDid, :gastosMovViat)");

		insert.setParameter("liq_emp_ent_id", idEmpEnt);
		insert.setParameter("mes", mes);
		insert.setParameter("obra_soc", obraSoc);
		insert.setParameter("seg_soc", segSoc);
		insert.setParameter("sind", sind);
		insert.setParameter("gan_brut", ganBrut);
		insert.setParameter("ret_gan", retGan);
		insert.setParameter("retrib_no_hab", retribNoHab);
		insert.setParameter("ajuste", ajuste);
		insert.setParameter("exeNoAlc", exeNoAlc);
		insert.setParameter("sac", sac);
		insert.setParameter("horasExtGr", horasExtGr);
		insert.setParameter("horasExtEx", horasExtEx);
		insert.setParameter("matDid", matDid);
		insert.setParameter("gastosMovViat", gastosMovViat);

		if (insert.execute() == 0) {
			return null;
		}

		return Ebean.createSqlQuery("SELECT currval('ganancias_liq_otros_emp_ent_id_seq') id;").findUnique()
				.getInteger("id");
	}

	private static Boolean cargarRetPerPagos(Integer idPresentacion, Integer tipoDoc, Long nroDoc, String denominacion,
			String descBasica, String descr_adicional, BigDecimal montoTotal, Integer ret_tipo) throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_ret_per_pagos (ganancias_presentacion_id, documento_tipo, documento_nro, denominacion, descr_basica, descr_adicional, monto, ret_tipo) VALUES (:ganancias_presentacion_id, :documento_tipo, :documento_nro, :denominacion, :descr_basica, :descr_adicional, :monto, :ret_tipo)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("documento_tipo", tipoDoc);
		insert.setParameter("documento_nro", nroDoc);
		insert.setParameter("denominacion", denominacion);
		insert.setParameter("descr_basica", descBasica);
		insert.setParameter("descr_adicional", descr_adicional);
		insert.setParameter("monto", montoTotal);
		insert.setParameter("ret_tipo", ret_tipo);

		return (insert.execute() > 0);
	}

	private static Integer cargarDeduccion(Integer idPresentacion, Integer tipo, Integer tipoDoc, Long nroDoc,
			String denominacion, String descBasica, String descr_adicional, BigDecimal montoTotal, Integer motivo)
			throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_deducciones_572 (ganancias_presentacion_id, ganancias_deducciones_572_tipo_id, documento_tipo, documento_nro, denominacion, descr_basica, descr_adicional, monto, motivo) VALUES (:ganancias_presentacion_id, :ganancias_deducciones_572_tipo_id, :documento_tipo, :documento_nro, :denominacion, :descr_basica, :descr_adicional, :monto, :motivo)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("ganancias_deducciones_572_tipo_id", tipo);
		insert.setParameter("documento_tipo", tipoDoc);
		insert.setParameter("documento_nro", nroDoc);
		insert.setParameter("denominacion", denominacion);
		insert.setParameter("descr_basica", (descBasica.isEmpty()) ? null : descBasica);
		insert.setParameter("descr_adicional", (descr_adicional.isEmpty()) ? null : descr_adicional);
		insert.setParameter("monto", montoTotal);
		insert.setParameter("motivo", motivo);

		//return (insert.execute() > 0);

		if (insert.execute() == 0) {
			return null;
		}

		return Ebean.createSqlQuery("SELECT currval('ganancias_deducciones_572_id_seq') id;").findUnique()
				.getInteger("id");


	}

	private static Integer cargarDeduccionDetalle(Integer idDeduccion, String nombre, String valor)
			throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_deducciones_572_detalles (ganancias_deducciones_572_id, nombre, valor) VALUES "
				+ "(:ganancias_deducciones_572_id, :nombre, :valor)");

		insert.setParameter("ganancias_deducciones_572_id", idDeduccion);
		insert.setParameter("nombre", nombre);
		insert.setParameter("valor", valor);

		//return (insert.execute() > 0);

		if (insert.execute() == 0) {
			return null;
		}

		return Ebean.createSqlQuery("SELECT currval('ganancias_deducciones_572_id_seq') id;").findUnique()
				.getInteger("id");


	}

	private static Integer cargarDeduccionPeriodos(Integer idDeduccion, String mesDesde, String mesHasta,BigDecimal monto)
			throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_deducciones_572_periodos (ganancias_deducciones_572_id, mesdesde, meshasta ,monto) VALUES "
				+ "(:ganancias_deducciones_572_id, :mesDesde,:mesHasta, :monto)");

		insert.setParameter("ganancias_deducciones_572_id", idDeduccion);
		insert.setParameter("mesDesde", mesDesde);
		insert.setParameter("mesHasta", mesHasta);
		insert.setParameter("monto", monto);

		//return (insert.execute() > 0);

		if (insert.execute() == 0) {
			return null;
		}

		return Ebean.createSqlQuery("SELECT currval('ganancias_deducciones_572_id_seq') id;").findUnique()
				.getInteger("id");


	}

	private static Boolean cargarOtrosEmpleadores(Integer idPresentacion, String cuit, String denominacion)
			throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_otros_empleadores (ganancias_presentacion_id, cuit_agente_retencion, denomincion_agente_retencion) VALUES (:ganancias_presentacion_id, :cuit_agente_retencion, :denomincion_agente_retencion)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("cuit_agente_retencion", cuit);
		insert.setParameter("denomincion_agente_retencion", denominacion);

		return (insert.execute() > 0);
	}

	private static Boolean cargarAjustes(Integer idPresentacion, String cuit, String denominacion, String descBasica,
			String descr_adicional, BigDecimal montoTotal) throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_ajustes (ganancias_presentacion_id, cuit, denominacion, descr_basica, descr_adicional, monto_total) VALUES (:ganancias_presentacion_id, :cuit, :denominacion, :descr_basica, :descr_adicional, :monto)");

		insert.setParameter("ganancias_presentacion_id", idPresentacion);
		insert.setParameter("cuit", cuit);
		insert.setParameter("denominacion", denominacion);
		insert.setParameter("descr_basica", descBasica);
		insert.setParameter("descr_adicional", descr_adicional);
		insert.setParameter("monto", montoTotal);

		return (insert.execute() > 0);
	}

	private static Boolean cargarPresentacion(Long puestoLaboralId, Integer periodo, Integer nroPresentacion,
			String fechaPresentacion) throws PSQLException {
		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_presentaciones (periodo_anio, presentacion_nro, presentacion_date, agente_id) VALUES (:periodo,:numero,:fecha,:puesto)");

		insert.setParameter("puesto", puestoLaboralId);
		insert.setParameter("periodo", periodo);
		insert.setParameter("numero", nroPresentacion);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");

		insert.setParameter("fecha", DateUtils.formatDate(fechaPresentacion, "yyyy-MM-dd"));

		return (insert.execute() > 0);
	}

	private static Boolean cargarFamilia(Integer idPresentacion, Integer tipoDoc, Long nroDoc, String apellido,
			String nombre, String fechaNac, Integer mesDesde, Integer mesHasta, Integer parentesco,
			Boolean vigenteProximosPeriodos, String fechaLimite, BigDecimal porcentajeDeduccion) throws PSQLException {

		SqlUpdate insert = Ebean.createSqlUpdate(
				"INSERT INTO ganancias_cargas_familias (ganancias_presentacion_id, documento_tipo, documento_nro, apellido, nombre, fecha_nacimiento, mes_desde, mes_hasta, parentesco, vigente_proximos_periodos, fecha_limite, porcentaje_deduccion) VALUES (:presentacionId, :documentoTipo, :documentoNro, :apellido, :nombres, :nacimientoFecha, :mesDesde, :mesHasta, :parentescoId, :vigente, :fechaLimite, :porcentajeDeduccion)");

		insert.setParameter("presentacionId", idPresentacion);
		insert.setParameter("documentoTipo", tipoDoc);
		insert.setParameter("documentoNro", nroDoc);
		insert.setParameter("apellido", apellido);
		insert.setParameter("nombres", nombre);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
		insert.setParameter("nacimientoFecha", DateUtils.formatDate(fechaNac, "yyyy-MM-dd"));
		insert.setParameter("mesDesde", mesDesde);
		insert.setParameter("mesHasta", mesHasta);
		insert.setParameter("parentescoId", parentesco);
		insert.setParameter("vigente", vigenteProximosPeriodos);
		insert.setParameter("fechaLimite",
				(fechaLimite != null) ? DateUtils.formatDate(fechaLimite, "yyyy-MM-dd") : "");
		insert.setParameter("porcentajeDeduccion", porcentajeDeduccion);
		System.out.println("asdsadsadsadsadsadsadsdasd---------------------------------------");

		return (insert.execute() > 0);

	}

	public static List<Integer> getSeleccionados() {
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if (checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

}
