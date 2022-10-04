package jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.avaje.ebean.SqlRow;

import models.Proveedor;
import models.TareaAutomatica;
import models.TipoTarea;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;
import play.Logger;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.ReportesExcelsUtils;
import views.html.dashboard.deudasGlobalizadas.deudasMail;
import views.html.dashboard.deudasGlobalizadas.pagadoNoEntregados;


public class DeudasInformesMails {

  public File getArchivoExcelDeudasOtros(Map<String, List<SqlRow>> listaSql) {
    String dirTemp = System.getProperty("java.io.tmpdir");
    Date ahora = new Date();
    File archivo = new File(dirTemp + "/INFORME-DEUDAS-OTROS-" + utils.DateUtils.formatDate(ahora, "dd-MM-yyyy") + ".xls");
    try {
      if (archivo.exists())
        archivo.delete();
      archivo.createNewFile();
      FileOutputStream archivoTmp = new FileOutputStream(archivo);
      Workbook libro = new HSSFWorkbook();

      Sheet hoja = getDeudasSheet(libro, 0, false, listaSql, false, false);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, false, false, Proveedor.getProveedoresDestacadosYRA(), true);
      hoja = getDeudasSheet(libro, 0, false, listaSql, true, false);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, false, true, Proveedor.getProveedoresDestacadosYRA(), true);

      libro.write(archivoTmp);
      return archivo;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public File getArchivoExcelDeudasDestacados(Map<String, List<SqlRow>> listaSql) {
    String dirTemp = System.getProperty("java.io.tmpdir");
    Date ahora = new Date();
    File archivo = new File(dirTemp + "/INFORME-DEUDAS-DESTACADOS-" + utils.DateUtils.formatDate(ahora, "dd-MM-yyyy") + ".xls");
    try {
      if (archivo.exists())
        archivo.delete();
      archivo.createNewFile();
      FileOutputStream archivoTmp = new FileOutputStream(archivo);
      Workbook libro = new HSSFWorkbook();

      Sheet hoja = getDeudasSheet(libro, 0, false, listaSql, false, true);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, true, false, Proveedor.getProveedoresDestacados(), false);
      hoja = getDeudasSheet(libro, 0, false, listaSql, true, true);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, true, true, Proveedor.getProveedoresDestacados(), false);

      libro.write(archivoTmp);
      return archivo;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public File getArchivoExcelDeudasRA(Map<String, List<SqlRow>> listaSql) {
    String dirTemp = System.getProperty("java.io.tmpdir");
    Date ahora = new Date();
    File archivo = new File(dirTemp + "/INFORME-DEUDAS-RA-" + utils.DateUtils.formatDate(ahora, "dd-MM-yyyy") + ".xls");
    try {
      if (archivo.exists())
        archivo.delete();
      archivo.createNewFile();
      FileOutputStream archivoTmp = new FileOutputStream(archivo);
      Workbook libro = new HSSFWorkbook();

      Sheet hoja = getDeudasSheet(libro, 0, true, listaSql, false, false);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, true, false, Proveedor.getProveedoresDestacadosRAInt(), false);
      Logger.debug("----------------- DETALLE OPERATIVA");
      hoja = getDeudasSheet(libro, 0, true, listaSql, true, false);
      hoja = getDeudasDetallePorAntiguedadSheet(libro, true, true, Proveedor.getProveedoresDestacadosRAInt(), false);
      Logger.debug("----------------- DETALLE PROFE");
      libro.write(archivoTmp);
      return archivo;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public File getArchivoExcelPagadoNoEntregado(List<InformeDeudaProveedoresMaterializada> list) {
    String dirTemp = System.getProperty("java.io.tmpdir");
    Date ahora = new Date();
    File archivo = new File(dirTemp + "/INFORME-PAGADO-NOENTREGADO-" + utils.DateUtils.formatDate(ahora, "dd-MM-yyyy") + ".xls");
    try {
      if (archivo.exists())
        archivo.delete();
      archivo.createNewFile();
      FileOutputStream archivoTmp = new FileOutputStream(archivo);
      Workbook libro = new HSSFWorkbook();

      Sheet hoja = getPagadoNoEntregadoSheet(libro, list);

      Logger.debug("----------------- DETALLE OPERATIVA");

      libro.write(archivoTmp);
      return archivo;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static Sheet getDeudasDetallePorAntiguedadSheet(Workbook libro, boolean ra, boolean profe, List<Integer> proveedores, boolean noDestacados) {
    String titulo = (profe) ? "PROFE" : "OPERATIVA";

    ReportesExcelsUtils reu = new ReportesExcelsUtils();
    CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
    CellStyle comun = reu.getEstiloComun(libro);
    CellStyle cabeceraPrincipal = reu.getCabecera(libro, 14);
    CellStyle cabecera = reu.getCabecera(libro, 10);

    int x = 0;
    Sheet hoja = libro.createSheet("DETALLE-" + titulo);

    hoja.setColumnWidth(0, 3000);
    hoja.setColumnWidth(1, 3000);
    hoja.setColumnWidth(2, 15000);
    hoja.setColumnWidth(3, 4200);
    hoja.setColumnWidth(4, 3000);
    hoja.setColumnWidth(5, 5000);
    hoja.setColumnWidth(6, 20000);

    Row fila = hoja.createRow(x);
    Cell celda0 = fila.createCell(0);
    celda0 = fila.createCell(0);
    celda0.setCellValue("PERIODO");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(1);
    celda0.setCellValue("N° EXP");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(2);
    celda0.setCellValue("PROVEEDOR");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(3);
    celda0.setCellValue("DEUDA");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(4);
    celda0.setCellValue("INST.");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(5);
    celda0.setCellValue("RUBRO");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(6);
    celda0.setCellValue("DETALLE");
    celda0.setCellStyle(cabecera);
    x++;


    List<SqlRow> lista =
        InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadDetalles(proveedores, profe, null, noDestacados, null, false);
    if (lista.size() > 0) {
      BigDecimal mtdoh = new BigDecimal(0);
      for (SqlRow s : lista) {
        fila = hoja.createRow(x);
        celda0 = fila.createCell(0);
        celda0.setCellValue(s.getString("fecha_mes_ano"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(1);
        celda0.setCellValue(s.getString("expediente"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(2);
        celda0.setCellValue(s.getString("nombre_proveedor"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(3);
        celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(4);
        celda0.setCellValue(s.getString("deposito"));
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(5);
        celda0.setCellValue(s.getString("rubro"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(6);
        celda0.setCellValue(s.getString("descripcion"));
        celda0.setCellStyle(comun);
        x++;
        mtdoh = mtdoh.add(s.getBigDecimal("total_deuda"));
      }

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("");
      celda0.setCellStyle(comun);
      hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 1));

      celda0 = fila.createCell(2);
      celda0.setCellValue("TOTAL");
      celda0.setCellStyle(estiloMoneda);

      celda0 = fila.createCell(3);
      celda0.setCellValue(mtdoh.doubleValue());
      celda0.setCellStyle(estiloMoneda);

      celda0 = fila.createCell(4);
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(5);
      celda0.setCellStyle(comun);
      hoja.addMergedRegion(new CellRangeAddress(x, x, 4, 6));
      x++;
    }


    return hoja;
  }

  public static Sheet getDeudasSheet(Workbook libro, Integer deposito, boolean ra, Map<String, List<SqlRow>> listaRow, boolean profe,
      boolean solosDestacados) {

    String titulo = (profe) ? "PROFE" : "OPERATIVA";

    List<SqlRow> proveedoresDestacados = listaRow.get("proveedoresDestacados" + titulo);
    List<SqlRow> proveedoresDestacadosServicios = listaRow.get("proveedoresDestacadosServicios" + titulo);
    List<SqlRow> rubros = InformeDeudaProveedoresMaterializada.getDeudaRubroAgrupados(solosDestacados, profe, ra);
    Logger.debug("----------------- RUBROS OPERATIVA");
    List<SqlRow> depositos = InformeDeudaProveedoresMaterializada.getDeudaDepositoAgrupados(solosDestacados, profe, ra);
    Logger.debug("----------------- DEPOSITOS OPERATIVA");
    ReportesExcelsUtils reu = new ReportesExcelsUtils();
    CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
    CellStyle comun = reu.getEstiloComun(libro);
    CellStyle cabeceraPrincipal = reu.getCabecera(libro, 14);
    CellStyle cabecera = reu.getCabecera(libro, 10);


    Sheet hoja = libro.createSheet("RESUMEN-" + titulo);
    hoja.setColumnWidth(0, 15000);
    hoja.setColumnWidth(1, 5000);
    hoja.setColumnWidth(2, 5000);
    hoja.setDefaultRowHeight((short) 400);

    int x = 0;

    Row fila = hoja.createRow(x);
    Cell celda0 = fila.createCell(0);
    celda0.setCellValue("RESUMEN - " + utils.DateUtils.getNow());
    celda0.setCellStyle(cabeceraPrincipal);
    hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
    x++;

    fila = hoja.createRow(x);
    celda0 = fila.createCell(0);
    celda0.setCellValue(titulo);
    celda0.setCellStyle(cabeceraPrincipal);
    hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
    x++;

    fila = hoja.createRow(x);
    celda0 = fila.createCell(0);
    celda0.setCellValue("PROVEDORES");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(1);
    celda0.setCellValue("MONTO DEUDA");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(2);
    celda0.setCellValue("MONTO COMPROMISO");
    celda0.setCellStyle(cabecera);
    x++;

    // DESCADOS
    BigDecimal monto_total_deuda = new BigDecimal(0);
    BigDecimal monto_total_compromiso = new BigDecimal(0);
    BigDecimal monto_total_deuda_ser = new BigDecimal(0);
    BigDecimal monto_total_compromiso_ser = new BigDecimal(0);
    BigDecimal monto_total_deuda_rubro = new BigDecimal(0);
    BigDecimal monto_total_compromiso_rubro = new BigDecimal(0);
    BigDecimal monto_total_deuda_depo = new BigDecimal(0);
    BigDecimal monto_total_compromiso_depo = new BigDecimal(0);


    boolean hayra = false;
    if (proveedoresDestacados.size() > 0) {

      for (SqlRow pd : proveedoresDestacados) {
        fila = hoja.createRow(x);
        celda0 = fila.createCell(0);
        celda0.setCellValue(pd.getString("nombre_proveedor"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(1);
        celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(2);
        celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        monto_total_deuda = monto_total_deuda.add(pd.getBigDecimal("total_deuda"));
        monto_total_compromiso = monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"));
        x++;
      }

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("TOTAL");
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(1);
      celda0.setCellValue(monto_total_deuda.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      celda0 = fila.createCell(2);
      celda0.setCellValue(monto_total_compromiso.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      x++;

    }

    if (proveedoresDestacadosServicios.size() > 0) {

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("SERVICIOS");
      celda0.setCellStyle(cabeceraPrincipal);
      hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
      x++;
      for (SqlRow pd : proveedoresDestacadosServicios) {
        fila = hoja.createRow(x);
        celda0 = fila.createCell(0);
        celda0.setCellValue(pd.getString("nombre_proveedor"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(1);
        celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(2);
        celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        monto_total_deuda_ser = monto_total_deuda_ser.add(pd.getBigDecimal("total_deuda"));
        monto_total_compromiso_ser = monto_total_compromiso_ser.add(pd.getBigDecimal("total_compromiso"));
        x++;
      }

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("TOTAL");
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(1);
      celda0.setCellValue(monto_total_deuda_ser.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      celda0 = fila.createCell(2);
      celda0.setCellValue(monto_total_compromiso_ser.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      x++;
    }

    fila = hoja.createRow(x);
    celda0 = fila.createCell(0);
    celda0.setCellValue("");
    celda0.setCellStyle(cabeceraPrincipal);
    hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
    x++;

    if (rubros.size() > 0) {
      x++;
      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("POR RUBRO");
      celda0.setCellStyle(cabeceraPrincipal);
      hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
      x++;
      for (SqlRow pd : rubros) {
        fila = hoja.createRow(x);
        celda0 = fila.createCell(0);
        celda0.setCellValue(pd.getString("rubro"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(1);
        celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(2);
        celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        monto_total_deuda_rubro = monto_total_deuda_rubro.add(pd.getBigDecimal("total_deuda"));
        monto_total_compromiso_rubro = monto_total_compromiso_rubro.add(pd.getBigDecimal("total_compromiso"));
        x++;
      }

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("TOTAL");
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(1);
      celda0.setCellValue(monto_total_deuda_rubro.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      celda0 = fila.createCell(2);
      celda0.setCellValue(monto_total_compromiso_rubro.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      x++;
    }

    if (depositos.size() > 0) {
      x++;
      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("POR INSTITUCION");
      celda0.setCellStyle(cabeceraPrincipal);
      hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 2));
      x++;
      for (SqlRow pd : depositos) {
        fila = hoja.createRow(x);
        celda0 = fila.createCell(0);
        celda0.setCellValue(pd.getString("nombre"));
        celda0.setCellStyle(comun);
        celda0 = fila.createCell(1);
        celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        celda0 = fila.createCell(2);
        celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
        celda0.setCellStyle(estiloMoneda);
        monto_total_deuda_depo = monto_total_deuda_depo.add(pd.getBigDecimal("total_deuda"));
        monto_total_compromiso_depo = monto_total_compromiso_depo.add(pd.getBigDecimal("total_compromiso"));
        x++;
      }

      fila = hoja.createRow(x);
      celda0 = fila.createCell(0);
      celda0.setCellValue("TOTAL");
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(1);
      celda0.setCellValue(monto_total_deuda_depo.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      celda0 = fila.createCell(2);
      celda0.setCellValue(monto_total_compromiso_depo.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      x++;
    }

    return hoja;

  }

  public static Sheet getPagadoNoEntregadoSheet(Workbook libro, List<InformeDeudaProveedoresMaterializada> listaRow) {

    String titulo = "PAGADO NO ENTREGADO";


    ReportesExcelsUtils reu = new ReportesExcelsUtils();
    CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
    CellStyle comun = reu.getEstiloComun(libro);
    CellStyle cabeceraPrincipal = reu.getCabecera(libro, 14);
    CellStyle cabecera = reu.getCabecera(libro, 10);


    Sheet hoja = libro.createSheet("PAGADO NO ENTREGADO");
    hoja.setColumnWidth(0, 2000);
    hoja.setColumnWidth(1, 3000);
    hoja.setColumnWidth(2, 5000);
    hoja.setColumnWidth(3, 10000);
    hoja.setColumnWidth(4, 15000);
    hoja.setColumnWidth(5, 5000);
    hoja.setColumnWidth(6, 5000);
    hoja.setColumnWidth(7, 5000);
    hoja.setDefaultRowHeight((short) 400);


    int x = 0;

    Row fila = hoja.createRow(x);
    Cell celda0 = fila.createCell(0);
    celda0.setCellValue("PAGADO NO ENTREGADO - " + utils.DateUtils.getNow());
    celda0.setCellStyle(cabeceraPrincipal);
    hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 7));
    x++;


    fila = hoja.createRow(x);

    celda0 = fila.createCell(0);
    celda0.setCellValue("N°");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(1);
    celda0.setCellValue("EXP");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(2);
    celda0.setCellValue("RUBRO");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(3);
    celda0.setCellValue("INST.");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(4);
    celda0.setCellValue("PROVEDORES");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(5);
    celda0.setCellValue("MONTO PAGADO");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(6);
    celda0.setCellValue("MONTO ENTREGADO");
    celda0.setCellStyle(cabecera);
    celda0 = fila.createCell(7);
    celda0.setCellValue("DIFERENCIA");
    celda0.setCellStyle(cabecera);
    x++;

    // DESCADOS
    BigDecimal monto_total_pagado = new BigDecimal(0);
    BigDecimal monto_total_entregado = new BigDecimal(0);

    for (InformeDeudaProveedoresMaterializada pd : listaRow) {
      fila = hoja.createRow(x);

      celda0 = fila.createCell(0);
      celda0.setCellValue(pd.numero_orden_provision);
      celda0.setCellStyle(comun);

      celda0 = fila.createCell(1);
      celda0.setCellValue(pd.expediente);
      celda0.setCellStyle(comun);

      celda0 = fila.createCell(2);
      celda0.setCellValue(pd.rubro);
      celda0.setCellStyle(comun);

      celda0 = fila.createCell(3);
      celda0.setCellValue(pd.deposito.nombre);
      celda0.setCellStyle(comun);


      celda0 = fila.createCell(4);
      celda0.setCellValue(pd.nombreProveedor);
      celda0.setCellStyle(comun);
      celda0 = fila.createCell(5);
      celda0.setCellValue(pd.totalPagado.doubleValue());
      celda0.setCellStyle(estiloMoneda);
      celda0 = fila.createCell(6);
      celda0.setCellValue(pd.totalActasSinAdelanto.doubleValue());
      celda0.setCellStyle(estiloMoneda);

      celda0 = fila.createCell(7);
      celda0.setCellValue(pd.totalPagado.subtract(pd.totalActasSinAdelanto).doubleValue());
      celda0.setCellStyle(estiloMoneda);


      monto_total_pagado = monto_total_pagado.add(pd.totalPagado);
      monto_total_entregado = monto_total_entregado.add(pd.totalActasSinAdelanto);
      x++;
    }

    fila = hoja.createRow(x);
    celda0 = fila.createCell(4);
    celda0.setCellValue("TOTAL");
    celda0.setCellStyle(comun);
    celda0 = fila.createCell(5);
    celda0.setCellValue(monto_total_pagado.doubleValue());
    celda0.setCellStyle(estiloMoneda);
    celda0 = fila.createCell(6);
    celda0.setCellValue(monto_total_entregado.doubleValue());
    celda0.setCellStyle(estiloMoneda);
    celda0 = fila.createCell(7);
    celda0.setCellValue(monto_total_pagado.subtract(monto_total_entregado).doubleValue());
    celda0.setCellStyle(estiloMoneda);
    x++;


    return hoja;

  }

  public boolean envioMailsDeudasRA() {
    boolean r = false;

    try {
      Calendar now = Calendar.getInstance();
      int weekday = now.get(Calendar.DAY_OF_WEEK);

      if (weekday != Calendar.SUNDAY && weekday != Calendar.SATURDAY) {
        List<SqlRow> proveedoresDestacados =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, false, 0, true, false, false, false);
        Logger.debug("----------------- OPERATIVA");
        List<SqlRow> proveedoresDestacadosServicios =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, false, 0, true, true, false, false);
        Logger.debug("----------------- SERVICIOS OPERATIVA");
        List<SqlRow> proveedoresDestacadosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, true, 0, true, false, false, false);
        Logger.debug("----------------- PROFE");
        List<SqlRow> proveedoresDestacadosServiciosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, true, 0, true, true, false, false);
        Logger.debug("----------------- SERVICIOS PROFE");
        Map<String, List<SqlRow>> listaSql = new HashMap<>();
        listaSql.put("proveedoresDestacadosOPERATIVA", proveedoresDestacados);
        listaSql.put("proveedoresDestacadosServiciosOPERATIVA", proveedoresDestacadosServicios);
        listaSql.put("proveedoresDestacadosPROFE", proveedoresDestacadosProfe);
        listaSql.put("proveedoresDestacadosServiciosPROFE", proveedoresDestacadosServiciosProfe);


        File xx = getArchivoExcelDeudasRA(listaSql);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(xx.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Recibo");
        attachment.setName(xx.getName());


        Object c = deudasMail
            .render(proveedoresDestacados, proveedoresDestacadosServicios, proveedoresDestacadosProfe, proveedoresDestacadosServiciosProfe, "R.A.");

        EmailUtilis eu = new EmailUtilis();

        eu.setSubject("INFORME DEUDAS PARQUE SALUD AUTOMATICO RA - " + DateUtils.formatDate(new Date(), "dd/MM/yyyy-HH") + "hs");
        eu.setHtmlMsg(c.toString());
        eu.setFrom("admin@parquesaludmnes.org.ar");

        List<String> adds = new ArrayList<>();

        List<TareaAutomatica> ta = TareaAutomatica.find.where().eq("tipo_tarea_id", TipoTarea.MAIL_DEUDA_RA).findList();
        for (TareaAutomatica tx : ta) {
          if (tx.usuario.email != null) {
            adds.add(tx.usuario.email);
          }
        }

        eu.setAttach(attachment);
        eu.setAdds(adds);
        eu.enviar();

      }

    } catch (EmailException e) {
      Logger.debug("----------------- " + e.toString());
    }


    return r;
  }

  public boolean envioMailsDeudasDestacados() {
    boolean r = false;

    try {
      Calendar now = Calendar.getInstance();
      int weekday = now.get(Calendar.DAY_OF_WEEK);

      if (weekday != Calendar.SUNDAY && weekday != Calendar.SATURDAY) {
        // proveedoresDestacados, profe, deposito, ra, servicios, equipamiento, honorarios, null)
        List<SqlRow> proveedoresDestacados =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, false, 0, false, false, false, false, true);
        List<SqlRow> proveedoresDestacadosServicios =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, false, 0, false, true, false, false, true);

        List<SqlRow> proveedoresDestacadosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, true, 0, false, false, false, false, true);
        List<SqlRow> proveedoresDestacadosServiciosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true, true, 0, false, true, false, false, true);

        Map<String, List<SqlRow>> listaSql = new HashMap<>();
        listaSql.put("proveedoresDestacadosOPERATIVA", proveedoresDestacados);
        listaSql.put("proveedoresDestacadosServiciosOPERATIVA", proveedoresDestacadosServicios);
        listaSql.put("proveedoresDestacadosPROFE", proveedoresDestacadosProfe);
        listaSql.put("proveedoresDestacadosServiciosPROFE", proveedoresDestacadosServiciosProfe);


        File xx = getArchivoExcelDeudasDestacados(listaSql);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(xx.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Recibo");
        attachment.setName(xx.getName());


        Object c = deudasMail.render(proveedoresDestacados,
            proveedoresDestacadosServicios,
            proveedoresDestacadosProfe,
            proveedoresDestacadosServiciosProfe,
            "PROVEEDORES DESTACADOS");

        EmailUtilis eu = new EmailUtilis();

        eu.setSubject("INFORME DEUDAS PARQUE SALUD AUTOMATICO DESTACADOS -" + DateUtils.formatDate(new Date(), "dd/MM/yyyy-HH") + "hs");
        eu.setHtmlMsg(c.toString());
        eu.setFrom("admin@parquesaludmnes.org.ar");

        List<String> adds = new ArrayList<>();

        List<TareaAutomatica> ta = TareaAutomatica.find.where().eq("tipo_tarea_id", TipoTarea.MAIL_DEUDA_RA).findList();
        for (TareaAutomatica tx : ta) {
          if (tx.usuario.email != null) {
            adds.add(tx.usuario.email);
          }
        }

        eu.setAttach(attachment);
        eu.setAdds(adds);
        eu.enviar();

      }

    } catch (Exception e) {
      // TODO: handle exception
    }


    return r;
  }

  public boolean envioMailsDeudasOtros() {
    boolean r = false;

    try {

      Calendar now = Calendar.getInstance();
      int weekday = now.get(Calendar.DAY_OF_WEEK);

      if (weekday != Calendar.SUNDAY && weekday != Calendar.SATURDAY) {
        // proveedoresDestacados, profe, deposito, ra, servicios, equipamiento, honorarios, null)
        List<SqlRow> proveedoresDestacados =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false, false, 0, false, false, true, false, false);
        List<SqlRow> proveedoresDestacadosServicios =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false, false, 0, false, true, true, false, false);

        List<SqlRow> proveedoresDestacadosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false, true, 0, false, false, true, false, false);
        List<SqlRow> proveedoresDestacadosServiciosProfe =
            InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false, true, 0, false, true, true, false, false);

        Map<String, List<SqlRow>> listaSql = new HashMap<>();
        listaSql.put("proveedoresDestacadosOPERATIVA", proveedoresDestacados);
        listaSql.put("proveedoresDestacadosServiciosOPERATIVA", proveedoresDestacadosServicios);
        listaSql.put("proveedoresDestacadosPROFE", proveedoresDestacadosProfe);
        listaSql.put("proveedoresDestacadosServiciosPROFE", proveedoresDestacadosServiciosProfe);


        File xx = getArchivoExcelDeudasOtros(listaSql);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(xx.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Recibo");
        attachment.setName(xx.getName());


        Object c = deudasMail.render(proveedoresDestacados,
            proveedoresDestacadosServicios,
            proveedoresDestacadosProfe,
            proveedoresDestacadosServiciosProfe,
            "PROVEEDORES OTROS");


        EmailUtilis eu = new EmailUtilis();

        eu.setSubject("INFORME DEUDAS PARQUE SALUD AUTOMATICO OTROS - " + DateUtils.formatDate(new Date(), "dd/MM/yyyy-HH") + "hs");
        eu.setHtmlMsg(c.toString());
        eu.setFrom("admin@parquesaludmnes.org.ar");

        List<String> adds = new ArrayList<>();

        List<TareaAutomatica> ta = TareaAutomatica.find.where().eq("tipo_tarea_id", TipoTarea.MAIL_DEUDA_RA).findList();
        for (TareaAutomatica tx : ta) {
          if (tx.usuario.email != null) {
            adds.add(tx.usuario.email);
          }
        }

        eu.setAttach(attachment);
        eu.setAdds(adds);
        eu.enviar();
      }

    } catch (Exception e) {
      // TODO: handle exception
    }


    return r;
  }


  public boolean envioMailsPagadoNoEntregado() {
    boolean r = false;

    try {

      Calendar now = Calendar.getInstance();
      int weekday = now.get(Calendar.DAY_OF_WEEK);

      if (weekday != Calendar.SUNDAY && weekday != Calendar.SATURDAY) {


        List<InformeDeudaProveedoresMaterializada> idpm = InformeDeudaProveedoresMaterializada.find.fetch("ordenProvision", "orden_compra_id")
            .fetch("expedienteObj")
            .fetch("deposito")
            .where()
            .raw("(totalActasSinAdelanto < totalPagado)")
            .isNotNull("numero_orden_provision")
            .orderBy("expediente_id ASC")
            .findList();


        File xx = getArchivoExcelPagadoNoEntregado(idpm);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(xx.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Recibo");
        attachment.setName(xx.getName());


        Object c = pagadoNoEntregados.render(idpm, "PAGADOS NO ENTREGADOS");


        EmailUtilis eu = new EmailUtilis();

        eu.setSubject("INFORME DEUDAS PARQUE SALUD AUTOMATICO PAGADOS NO ENTREGADOS - " + DateUtils.formatDate(new Date(), "dd/MM/yyyy-HH") + "hs");
        eu.setHtmlMsg(c.toString());
        eu.setFrom("admin@parquesaludmnes.org.ar");

        List<String> adds = new ArrayList<>();

        List<TareaAutomatica> ta = TareaAutomatica.find.where().eq("tipo_tarea_id", TipoTarea.MAIL_DEUDA_RA).findList();
        for (TareaAutomatica tx : ta) {
          if (tx.usuario.email != null) {
            adds.add(tx.usuario.email);
          }
        }

        eu.setAttach(attachment);
        eu.setAdds(adds);
        eu.enviar();

      }

    } catch (Exception e) {
      // TODO: handle exception
    }


    return r;
  }


}
