package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.Periodo;
import models.Usuario;
import models.rismi.RismiFactura;
import models.rismi.RismiFacturaDetalle;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import views.html.compras.solicitudes.modales.modalImportarListaProductosCantidades;
import views.html.dashboard.rismi.*;
import views.html.dashboard.rismi.rismiFactura.*;
import views.html.recupero.recuperoFactura.verRecuperoFactura;

public class FacturacionRismiController  extends Controller {

	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexRismiFactura.render(
				RismiFactura.page(RequestVar.get("nombre")),d));
	}

	public static Result ver(Long id) {
		RismiFactura p = RismiFactura.find.byId(id);

		if(p != null){
			Form<RismiFactura> rismiFacturaForm = form(RismiFactura.class).fill(p);
			return ok(verRismiFactura.render(rismiFacturaForm, p));
		}else{
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.dashboard.routes.FacturacionRismiController.index()+UriTrack.get("?"));
		}
	}

	public static Result modalImportarFacturas() {
		return ok(modalImportarFacturas.render(form().bindFromRequest()));
	}

	public static Result importarFacturas() throws IOException{
		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		String error = "";
		Boolean lineasValidas = true;
		String ok = "";

		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("myfile");

		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		try{


					Ebean.beginTransaction();



					if (upload != null) {
						//String fileName = upload.getFilename();
						//String contentType = upload.getContentType();
					    File file = upload.getFile();

					    FileInputStream input = new FileInputStream(file.getAbsolutePath());
						POIFSFileSystem fs = new POIFSFileSystem(input);
						HSSFWorkbook wb = new HSSFWorkbook(fs);
						HSSFSheet sheet = wb.getSheetAt(0);
						Row row;
						int cantidadDeRowProcesadas = 0;


						for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				            row = sheet.getRow(i);



						    Integer IDEPISODIO = (int) row.getCell(0).getNumericCellValue();// row.getCell(0).getStringCellValue();//IDEPISODIO
						    Integer IDPACIENTE =   (int) row.getCell(1).getNumericCellValue(); //row.getCell(1).getStringCellValue();//IDPACIENTE
							String NOMBREPACIENTE = row.getCell(2).getStringCellValue();//NOMBREPACIENTE
							String FECHAINGRESO = row.getCell(3).getStringCellValue();//FECHAINGRESO
							String FECHAEGRESO = row.getCell(4).getStringCellValue();//FECHAEGRESO

							String DOMINIO = row.getCell(5).getStringCellValue();//DOMINIO

							Double totalPrestaciones = row.getCell(6).getNumericCellValue();
							Double totalFarmacos = row.getCell(7).getNumericCellValue();
							Double totalCama = row.getCell(8).getNumericCellValue();
							Double totalTotal = row.getCell(9).getNumericCellValue();


							String ff = FECHAEGRESO;
							Date fechaEgreso = DateUtils.formatDate(ff, "dd/MM/yyyy");

							String ff2 = FECHAINGRESO;
							Date fechaIngreso = DateUtils.formatDate(ff2, "dd/MM/yyyy");



							Long proximaSec = Ebean.createSqlQuery("SELECT nextval('rismi_facturas_id_seq') id").findUnique().getLong("id");
							RismiFactura rf = new RismiFactura();
							rf.id = proximaSec;
							rf.dominio = DOMINIO;
							rf.episodio_id = IDEPISODIO.toString();
							rf.fecha_egreso =fechaEgreso;
							rf.fecha_ingreso = fechaIngreso;
							rf.nombre_paciente = NOMBREPACIENTE;
							rf.paciente_id =IDPACIENTE.toString();
							rf.total_total = new BigDecimal(totalTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
							rf.create_date = new Date();
							rf.save();

							RismiFacturaDetalle rdf = new RismiFacturaDetalle();
							rdf.monto = new BigDecimal(totalPrestaciones).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf.producto = "Total Prestaciones";
							rdf.rismi_factura_id  = proximaSec;
							rdf.save();

							RismiFacturaDetalle rdf2 = new RismiFacturaDetalle();
							rdf2.monto = new BigDecimal(totalFarmacos).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf2.producto = "Total Fármacos";
							rdf2.rismi_factura_id  = proximaSec;
							rdf2.save();

							RismiFacturaDetalle rdf3 = new RismiFacturaDetalle();
							rdf3.monto = new BigDecimal(totalCama).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf3.producto = "Total Días Cama";
							rdf3.rismi_factura_id  = proximaSec;
							rdf3.save();

				            String insert = "INSERT INTO rismi_facturas(nombre_paciente,dominio,fecha_ingreso,fecha_egreso,episodio_id,paciente_id) VALUES " +
					           		"('"+NOMBREPACIENTE+"','"+DOMINIO+"',"+FECHAINGRESO+","+FECHAEGRESO+","+IDEPISODIO+","+IDPACIENTE+");";

				            cantidadDeRowProcesadas ++;
						}

						ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" lineas.</p>";

					} else {
						error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
					}
					Ebean.commitTransaction();
		}catch(Exception e){
			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx21 "+e);
			  flash("error", "No se pudo crear las facturas " + e);
		      Ebean.rollbackTransaction();
		}finally {
		      Ebean.endTransaction();
	    }

		String ret = error+ok;
		return ok(ret);
	}


	public static Result datosMensualesResumenGeneral() {

		Periodo px = Periodo.getPeriodoByDate(new Date());

		String sql2 = "SELECT count(*) as total " +
				"FROM rismi_facturas rf " +
				"where rf.fecha_egreso  BETWEEN :fdesde AND :fhasta ";

		SqlRow tt = Ebean.createSqlQuery(sql2)
							 .setParameter("fdesde", px.date_start)
							 .setParameter("fhasta", px.date_stop).findUnique();


		String sql = "SELECT count(*),round(sum(monto),2) as total,producto " +
				"FROM rismi_factura_detalle rd " +
				"inner join rismi_facturas rf on rf.id = rd.rismi_factura_id " +
				"where rf.fecha_egreso  BETWEEN :fdesde AND :fhasta " +
				"group by producto  ";

		List<SqlRow> todos = Ebean.createSqlQuery(sql)
							 .setParameter("fdesde", px.date_start)
							 .setParameter("fhasta", px.date_stop)
							 .findList();

		BigDecimal diasCama = BigDecimal.ZERO;
		BigDecimal prestaciones = BigDecimal.ZERO;
		BigDecimal farmacos = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;

		for(SqlRow x:todos) {
			total = total.add(x.getBigDecimal("total"));
			switch (x.getString("producto")) {

			case "Total Días Cama"://"
				diasCama = x.getBigDecimal("total");
				break;
			case "Total Prestaciones"://"
				prestaciones = x.getBigDecimal("total");
				break;
			case "Total Fármacos":
				farmacos = x.getBigDecimal("total");
				break;

			default:
				break;
			}
		}

		Map<String, BigDecimal> totales = new HashMap<String, BigDecimal>();
		totales.put("diasCama", diasCama);
		totales.put("prestaciones", prestaciones);
		totales.put("farmacos", farmacos);
		totales.put("total", total);

		Integer totalPacientes = tt.getInteger("total");

		return ok( facturacion.render(totales,totalPacientes) );
	}

	/*
	  1. Estadísticas generales
	  WITH base AS (
  SELECT
    rf.id AS factura_id,
    MAX(CASE WHEN rd.producto = 'Total Prestaciones' THEN rd.monto ELSE 0 END) AS total_prestaciones,
    MAX(CASE WHEN rd.producto = 'Total Fármacos'     THEN rd.monto ELSE 0 END) AS total_farmacos,
    MAX(CASE WHEN rd.producto = 'Total Días Cama'    THEN rd.monto ELSE 0 END) AS total_dias_cama
  FROM rismi_factura_detalle rd
  INNER JOIN rismi_facturas rf ON rf.id = rd.rismi_factura_id
  GROUP BY rf.id
)
SELECT
  -- PRESTACIONES
  ROUND(AVG(total_prestaciones)::numeric, 2)                                                      AS avg_prestaciones,
  ROUND(PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2)              AS mediana_prestaciones,
  ROUND(MIN(total_prestaciones)::numeric, 2)                                                      AS min_prestaciones,
  ROUND(MAX(total_prestaciones)::numeric, 2)                                                      AS max_prestaciones,
  ROUND(STDDEV(total_prestaciones)::numeric, 2)                                                   AS desvio_prestaciones,
  -- FÁRMACOS
  ROUND(AVG(total_farmacos)::numeric, 2)                                                          AS avg_farmacos,
  ROUND(PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2)                  AS mediana_farmacos,
  ROUND(MIN(total_farmacos)::numeric, 2)                                                          AS min_farmacos,
  ROUND(MAX(total_farmacos)::numeric, 2)                                                          AS max_farmacos,
  ROUND(STDDEV(total_farmacos)::numeric, 2)                                                       AS desvio_farmacos,
  -- DÍAS CAMA
  ROUND(AVG(total_dias_cama)::numeric, 2)                                                         AS avg_dias_cama,
  ROUND(PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2)                 AS mediana_dias_cama,
  ROUND(MIN(total_dias_cama)::numeric, 2)                                                         AS min_dias_cama,
  ROUND(MAX(total_dias_cama)::numeric, 2)                                                         AS max_dias_cama,
  ROUND(STDDEV(total_dias_cama)::numeric, 2)                                                      AS desvio_dias_cama
FROM base;

2. Participación porcentual (pie/donut chart)
WITH base AS (
  SELECT
    rf.id AS factura_id,
    MAX(CASE WHEN rd.producto = 'Total Prestaciones' THEN rd.monto ELSE 0 END) AS total_prestaciones,
    MAX(CASE WHEN rd.producto = 'Total Fármacos'     THEN rd.monto ELSE 0 END) AS total_farmacos,
    MAX(CASE WHEN rd.producto = 'Total Días Cama'    THEN rd.monto ELSE 0 END) AS total_dias_cama
  FROM rismi_factura_detalle rd
  INNER JOIN rismi_facturas rf ON rf.id = rd.rismi_factura_id
  GROUP BY rf.id
)
SELECT
  ROUND(SUM(total_prestaciones)::numeric, 2)                                                      AS sum_prestaciones,
  ROUND(SUM(total_farmacos)::numeric, 2)                                                          AS sum_farmacos,
  ROUND(SUM(total_dias_cama)::numeric, 2)                                                         AS sum_dias_cama,
  ROUND((SUM(total_prestaciones + total_farmacos + total_dias_cama))::numeric, 2)                 AS gran_total,
  ROUND(SUM(total_prestaciones) * 100.0 / NULLIF(SUM(total_prestaciones + total_farmacos + total_dias_cama), 0), 2) AS pct_prestaciones,
  ROUND(SUM(total_farmacos)     * 100.0 / NULLIF(SUM(total_prestaciones + total_farmacos + total_dias_cama), 0), 2) AS pct_farmacos,
  ROUND(SUM(total_dias_cama)    * 100.0 / NULLIF(SUM(total_prestaciones + total_farmacos + total_dias_cama), 0), 2) AS pct_dias_cama
FROM base;

3. Distribución por rangos / histograma
WITH base AS (
  SELECT
    rf.id AS factura_id,
    MAX(CASE WHEN rd.producto = 'Total Prestaciones' THEN rd.monto ELSE 0 END) AS total_prestaciones,
    MAX(CASE WHEN rd.producto = 'Total Fármacos'     THEN rd.monto ELSE 0 END) AS total_farmacos,
    MAX(CASE WHEN rd.producto = 'Total Días Cama'    THEN rd.monto ELSE 0 END) AS total_dias_cama
  FROM rismi_factura_detalle rd
  INNER JOIN rismi_facturas rf ON rf.id = rd.rismi_factura_id
  GROUP BY rf.id
),
rangos AS (
  SELECT
    factura_id,
    CASE
      WHEN total_prestaciones = 0                          THEN '1 - Sin costo'
      WHEN total_prestaciones BETWEEN 1 AND 100000         THEN '2 - Hasta 100k'
      WHEN total_prestaciones BETWEEN 100001 AND 500000    THEN '3 - 100k a 500k'
      WHEN total_prestaciones BETWEEN 500001 AND 1000000   THEN '4 - 500k a 1M'
      WHEN total_prestaciones BETWEEN 1000001 AND 5000000  THEN '5 - 1M a 5M'
      ELSE                                                      '6 - Más de 5M'
    END AS rango_prestaciones,
    CASE
      WHEN total_farmacos = 0                              THEN '1 - Sin costo'
      WHEN total_farmacos BETWEEN 1 AND 100000             THEN '2 - Hasta 100k'
      WHEN total_farmacos BETWEEN 100001 AND 500000        THEN '3 - 100k a 500k'
      WHEN total_farmacos BETWEEN 500001 AND 1000000       THEN '4 - 500k a 1M'
      WHEN total_farmacos BETWEEN 1000001 AND 5000000      THEN '5 - 1M a 5M'
      ELSE                                                      '6 - Más de 5M'
    END AS rango_farmacos,
    CASE
      WHEN total_dias_cama = 0                             THEN '1 - Sin costo'
      WHEN total_dias_cama BETWEEN 1 AND 100000            THEN '2 - Hasta 100k'
      WHEN total_dias_cama BETWEEN 100001 AND 500000       THEN '3 - 100k a 500k'
      WHEN total_dias_cama BETWEEN 500001 AND 1000000      THEN '4 - 500k a 1M'
      WHEN total_dias_cama BETWEEN 1000001 AND 5000000     THEN '5 - 1M a 5M'
      ELSE                                                      '6 - Más de 5M'
    END AS rango_dias_cama
  FROM base
)
-- Cambiá rango_prestaciones por rango_farmacos o rango_dias_cama según el gráfico
SELECT
  rango_prestaciones                                       AS rango,
  COUNT(*)                                                 AS cantidad,
  ROUND(COUNT(*) * 100.0 / SUM(COUNT(*)) OVER (), 2)      AS porcentaje
FROM rangos
GROUP BY 1
ORDER BY 1;

4. Percentiles / box plot
WITH base AS (
  SELECT
    rf.id AS factura_id,
    MAX(CASE WHEN rd.producto = 'Total Prestaciones' THEN rd.monto ELSE 0 END) AS total_prestaciones,
    MAX(CASE WHEN rd.producto = 'Total Fármacos'     THEN rd.monto ELSE 0 END) AS total_farmacos,
    MAX(CASE WHEN rd.producto = 'Total Días Cama'    THEN rd.monto ELSE 0 END) AS total_dias_cama
  FROM rismi_factura_detalle rd
  INNER JOIN rismi_facturas rf ON rf.id = rd.rismi_factura_id
  GROUP BY rf.id
)
SELECT concepto, q1, mediana, q3, p90, p95 FROM (

  SELECT 'Prestaciones' AS concepto,
    ROUND(PERCENTILE_CONT(0.25) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2) AS q1,
    ROUND(PERCENTILE_CONT(0.50) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2) AS mediana,
    ROUND(PERCENTILE_CONT(0.75) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2) AS q3,
    ROUND(PERCENTILE_CONT(0.90) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2) AS p90,
    ROUND(PERCENTILE_CONT(0.95) WITHIN GROUP (ORDER BY total_prestaciones)::numeric, 2) AS p95
  FROM base

  UNION ALL

  SELECT 'Fármacos',
    ROUND(PERCENTILE_CONT(0.25) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.50) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.75) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.90) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.95) WITHIN GROUP (ORDER BY total_farmacos)::numeric, 2)
  FROM base

  UNION ALL

  SELECT 'Días Cama',
    ROUND(PERCENTILE_CONT(0.25) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.50) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.75) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.90) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2),
    ROUND(PERCENTILE_CONT(0.95) WITHIN GROUP (ORDER BY total_dias_cama)::numeric, 2)
  FROM base

) t;
5. Top facturas por costo total (bar chart / Pareto)
WITH base AS (
  SELECT
    rf.id AS factura_id,
    MAX(CASE WHEN rd.producto = 'Total Prestaciones' THEN rd.monto ELSE 0 END) AS total_prestaciones,
    MAX(CASE WHEN rd.producto = 'Total Fármacos'     THEN rd.monto ELSE 0 END) AS total_farmacos,
    MAX(CASE WHEN rd.producto = 'Total Días Cama'    THEN rd.monto ELSE 0 END) AS total_dias_cama
  FROM rismi_factura_detalle rd
  INNER JOIN rismi_facturas rf ON rf.id = rd.rismi_factura_id
  GROUP BY rf.id
)
SELECT
  factura_id,
  total_prestaciones,
  total_farmacos,
  total_dias_cama,
  ROUND((total_prestaciones + total_farmacos + total_dias_cama)::numeric, 2)  AS total_fila,
  ROUND(
    (total_prestaciones + total_farmacos + total_dias_cama) * 100.0
    / SUM(total_prestaciones + total_farmacos + total_dias_cama) OVER ()
  , 2)                                                                         AS pct_sobre_total,
  ROUND(SUM(total_prestaciones + total_farmacos + total_dias_cama)
    OVER (ORDER BY (total_prestaciones + total_farmacos + total_dias_cama) DESC) * 100.0
    / SUM(total_prestaciones + total_farmacos + total_dias_cama) OVER ()
  , 2)                                                                         AS pct_acumulado  -- útil para curva de Pareto
FROM base
ORDER BY total_fila DESC
LIMIT 50;
	 *
	 */
}
