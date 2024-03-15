package controllers.haberes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import models.Estado;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;
import models.haberes.LiquidacionTipo;
import models.haberes.PuestoLaboral;
import play.mvc.Controller;
import play.mvc.Result;
import scala.math.BigInt;
import utils.StringUtils;
import views.html.haberes.liquidacionAcciones.*;
import views.html.haberes.liquidacionMeses.reportes.*;
//import views.html.haberes.puestosLaborales.respuestaModal;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.common.base.Strings;

import controllers.auth.CheckPermiso;

public class LiquidacionAccionesController extends Controller {

	@CheckPermiso(key = "liquidacionMesExportBanco")
	public static Result exportMacroSueldosLista(Boolean nuevo) {
		// obtengo datos de la liquidacion
		//LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionId);

		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado liquidaciones");
			return ok(modalExportMacroSueldosLista.render(null));
		}

		List<LiquidacionMes> lm = LiquidacionMes.find.where().in("id",seleccionadas).ne("estado_id", Estado.LIQUIDACION_MES_APROBADO).findList();
		if(lm.size() > 0) {
			flash("error", "LAS LIQUIDACIONES DEBEN ESTAR EN ESTADO APROBADAS.");
			return ok(modalExportMacroSueldosLista.render(null));
		}



		// obtengo la liquidacion para cada puesto laboral
		List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
													.fetch("puestoLaboral")
									    			.fetch("puestoLaboral.legajo")
									    			.fetch("puestoLaboral.legajo.agente")
													.where()
													.in("liquidacion_mes_id",seleccionadas)
													.eq("estado_id", Estado.LIQUIDACION_PUESTOS_APROBADO).findList();

		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			int random_int = (int)Math.floor(Math.random()*(10000-0+1)+0);
			File archivo = new File(dirTemp + "/export_banco_"+random_int+".txt");
			File tempFile = new File(dirTemp + "/tmp_export_banco_"+random_int+".txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), Charset.forName( "UTF8")));

			String data = "";
			boolean b = true;
			boolean listo = false;
			for (LiquidacionPuesto liquidacionPuesto : liquidacionPuestos) {



				if (liquidacionPuesto.puestoLaboral != null) {

					// busco cuenta bancaria
					String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " INNER JOIN agentes a ON a.id = p.agente_id  "
							+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND a.id = :agente_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("agente_id",liquidacionPuesto.puestoLaboral.legajo.agente.id);

					SqlRow row = sqlQuery.findUnique();
					String numeroCuenta = "";
					if(row == null){
						flash("error", "No tiene cuenta bancaria cargada o aprobada:"+ liquidacionPuesto.puestoLaboral.legajo.agente.apellido);
						return ok(reporteBanco.render(null));
					}else {
						numeroCuenta = row.getString("numero_cuenta");
					}


					if(liquidacionPuesto.getTotalACobrar().compareTo(BigDecimal.ZERO) > 0) {
						if(nuevo) {
							/*
							 \t
							legajo	7	numerico	NO
							cuil	11	numerico	SI
							apellido	64	texto 	SI
							cuenta 	15	numerico	NI
							CBU	22		numerico	NI
							importe	14	numerico	SI
							comprobante	7	numerico	no
							*/
							data += StringUtils.cortarString(liquidacionPuesto.puestoLaboral.legajo.numero.toString(),7)+"\t"; // legajo
							data += StringUtils.cortarString(liquidacionPuesto.puestoLaboral.legajo.agente.cuit.toString(),11)+"\t";//cuil

							String apellido = liquidacionPuesto.puestoLaboral.legajo.agente.apellido;
							String[] split = apellido.split(",");

							if(b && !listo){

								StringBuilder sb = new StringBuilder();
								String x = "";

								for (int n = 0; n < split[1].length (); n ++){
									char c = split[1].charAt(n);

									if(!listo) {
										listo= true;
										if(c == 'A') {
											c = 'Á';
										}else if(c == 'E') {
											c = 'É';
										}else if(c == 'I') {
											c = 'Í';
										}else if(c == 'O') {
											c = 'Ó';
										}else if(c == 'U') {
											c = 'O';
										}else {
											listo= false;
										}

									}
									sb.append(c);
								}
								apellido = split[0]+" "+sb.toString();
							}else {
								apellido = liquidacionPuesto.puestoLaboral.legajo.agente.apellido;
							}


							data += StringUtils.cortarString(apellido,64)+"\t"; // apellido


							data += StringUtils.cortarString(numeroCuenta,15)+"\t"; // cuenta
							data += "\t";//StringUtils.alfanumerico("", 22)+"\t"; // cbu

							//String df = new DecimalFormat("00000000000.00").format(liquidacionPuesto.getTotalACobrar());
							//data += df.replace(",", "");// importe
							data += liquidacionPuesto.getTotalACobrar().toString()+"\t";
							data += "";//StringUtils.alfanumerico("", 7)+"\t"; // comprobante
						}else {
							data += StringUtils.numerico(liquidacionPuesto.puestoLaboral.legajo.numero.toString(), 10); // ID_Cliente
							String df = new DecimalFormat("000000000.00").format(liquidacionPuesto.getTotalACobrar());
							data += df.replace(",", "");// importe
							data += StringUtils.alfanumerico("61310", 5); // Convenio
							data += StringUtils.numerico(liquidacionPuesto.puestoLaboral.legajo.agente.dni.toString(), 10); // ID_Cliente
						}
						data += "\r\n";


					}
				}
			}



			out.append(data);
			out.flush();
			out.close();



			flash("success", "El archivo fue creado correctamente.");
			return ok(modalExportMacroSueldosLista.render(archivo.getPath()));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	@CheckPermiso(key = "liquidacionMesExportBanco")
	public static Result exportMacroSueldos(Long liquidacionId,Boolean nuevo) {
		// obtengo datos de la liquidacion
		LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionId);

		// obtengo la liquidacion para cada puesto laboral
		List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
													.fetch("puestoLaboral")
									    			.fetch("puestoLaboral.legajo")
									    			.fetch("puestoLaboral.legajo.agente")
													.where()
													.eq("liquidacion_mes_id", liquidacion.id)
													.eq("estado_id", Estado.LIQUIDACION_PUESTOS_APROBADO)
													.findList();

		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			int random_int = (int)Math.floor(Math.random()*(10000-0+1)+0);
			File archivo = new File(dirTemp + "/export_banco_"+random_int+".txt");
			File tempFile = new File(dirTemp + "/tmp_export_banco_"+random_int+".txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8));

			String data = "";
			boolean b = true;
			boolean listo = false;
			for (LiquidacionPuesto liquidacionPuesto : liquidacionPuestos) {

				if (liquidacionPuesto.puestoLaboral != null) {

					// busco cuenta bancaria
					String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " INNER JOIN agentes a ON a.id = p.agente_id  "
							+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND a.id = :agente_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("agente_id",liquidacionPuesto.puestoLaboral.legajo.agente.id);

					SqlRow row = sqlQuery.findUnique();
					String numeroCuenta = "";
					if(row == null){
						flash("error", "No tiene cuenta bancaria cargada o aprobada:"+ liquidacionPuesto.puestoLaboral.legajo.agente.apellido);
						return ok(reporteBanco.render(null));
					}else {
						numeroCuenta = row.getString("numero_cuenta");
					}


					if(liquidacionPuesto.getTotalACobrar().compareTo(BigDecimal.ZERO) > 0) {
						if(nuevo) {


							/*
							 \t
							legajo	7	numerico	NO
							cuil	11	numerico	SI
							apellido	64	texto 	SI
							cuenta 	15	numerico	NI
							CBU	22		numerico	NI
							importe	14	numerico	SI
							comprobante	7	numerico	no
							*/
							data += StringUtils.cortarString(liquidacionPuesto.puestoLaboral.legajo.numero.toString(),7)+"\t"; // legajo
							data += StringUtils.cortarString(liquidacionPuesto.puestoLaboral.legajo.agente.cuit.toString(),11)+"\t";//cuil

							String apellido = liquidacionPuesto.puestoLaboral.legajo.agente.apellido;
							String[] split = apellido.split(",");

							if(b && !listo){

								StringBuilder sb = new StringBuilder();
								String x = "";

								for (int n = 0; n < split[1].length (); n ++){
									char c = split[1].charAt(n);

									if(!listo) {
										listo= true;
										if(c == 'A') {
											c = 'Á';
										}else if(c == 'E') {
											c = 'É';
										}else if(c == 'I') {
											c = 'Í';
										}else if(c == 'O') {
											c = 'Ó';
										}else if(c == 'U') {
											c = 'O';
										}else {
											listo= false;
										}

									}
									sb.append(c);
								}
								apellido = split[0]+" "+sb.toString();
							}else {
								apellido = liquidacionPuesto.puestoLaboral.legajo.agente.apellido;
							}


							data += StringUtils.cortarString(apellido,64)+"\t"; // apellido


							data += StringUtils.cortarString(numeroCuenta,15)+"\t"; // cuenta
							data += "\t";//StringUtils.alfanumerico("", 22)+"\t"; // cbu

							data += liquidacionPuesto.getTotalACobrar().toString()+"\t";
							data += "";//StringUtils.alfanumerico("", 7)+"\t"; // comprobante




						}else {
							data += StringUtils.numerico(liquidacionPuesto.puestoLaboral.legajo.numero.toString(), 10); // ID_Cliente
							String df = new DecimalFormat("000000000.00").format(liquidacionPuesto.getTotalACobrar());
							data += df.replace(",", "");// importe
							data += StringUtils.alfanumerico("61310", 5); // Convenio
							data += StringUtils.numerico(liquidacionPuesto.puestoLaboral.legajo.agente.dni.toString(), 10); // ID_Cliente
						}
						data += "\r\n";
					}

				}
			}


			//byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

			//String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

			out.append(data);
			//out.append("ññ");
			out.flush();
	        out.close();


	        /*BufferedReader reader = new BufferedReader(new FileReader(archivo));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	        String lineToRemove = "ññ";
	        String currentLine;

	        while((currentLine = reader.readLine()) != null) {
	            // trim newline when comparing with lineToRemove
	            String trimmedLine = currentLine.trim();
	            System.out.println(trimmedLine);
	            if(trimmedLine.equals(lineToRemove)) continue;
	            writer.write(currentLine + System.getProperty("line.separator"));
	        }
	        writer.close();
	        reader.close();
	        boolean successful = tempFile.renameTo(archivo);*/


	        /*byte inbytes[] = new byte[1024];

	        FileInputStream fis = new FileInputStream(dirTemp + "/export_banco_"+random_int+".txt");
	        fis.read(inbytes);
	        FileOutputStream fos = new FileOutputStream(dirTemp + "/response-2.txt");
	        String in = new String(inbytes, "UTF8");
	        fos.write(in.getBytes());*/

	        //String fileName = archivo.getPath();


			flash("success", "El archivo fue creado correctamente.");
			return ok(reporteBanco.render(archivo.getPath()));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	@CheckPermiso(key = "liquidacionMesExportBanco")
	public static Result exportBanco(Long liquidacionId) {

		// obtengo datos de la liquidacion
		LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionId);

		// obtengo la liquidacion para cada puesto laboral
		List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
				.where().eq("liquidacion_mes_id", liquidacion.id).findList();

		// creacion de archivo temp
		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			File archivo = new File(dirTemp + "/export_banco.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(archivo), "Cp1252"));

			/*
			 * Encabezado 1
			 */
			String data = "";
			data += "0"; // Tipo_registro
			data += "1"; // Tipo_archivo
			data += Strings.padEnd("", 159, ' ');// blancos
			out.append(data).append("\r\n");

			/*
			 * Encabezado 2
			 */
			data = "";
			data += "1"; // Tipo_registro
			data += "285"; // Tipo_archivo
			data += "61310"; // codigo convenio

			// parametro carga dia mes
			Calendar cal = Calendar.getInstance();
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			String dayOfMonthStr = Strings.padStart(String.valueOf(dayOfMonth),
					2, '0');
			int month = cal.get(Calendar.MONTH);
			String monthStr = Strings.padStart(String.valueOf(month + 1), 2,
					'0');
			data += dayOfMonthStr.concat(monthStr);

			data += "01"; // secuencial (pantalla)
			data += "0"; // cod rectifictiva
			data += "000"; // grupo acred
			data += "00"; // carga grupo acred
			data += "S"; // marca
			data += Strings.padEnd("", 139, ' ');// blancos

			// data +=StringUtils.rightPad("",159, " ");// blancos
			out.append(data).append("\r\n");

			/*
			 * agrego una linea para cada puesto laboral
			 */

			String error = "";
			boolean errorb = false;
			for (LiquidacionPuesto liquidacionPuesto : liquidacionPuestos) {

				if (liquidacionPuesto.puestoLaboral != null) {

					// busco cuenta bancaria
					String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " INNER JOIN agentes a ON a.id = p.agente_id  "
							+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND a.id = :agente_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("agente_id",
							liquidacionPuesto.puestoLaboral.legajo.agente.id);

					SqlRow row = sqlQuery.findUnique();
					if(row == null){
						flash("error", "No tiene cuenta bancaria cargada o aprobada:"+ liquidacionPuesto.puestoLaboral.legajo.agente.apellido);
						return ok(reporteBanco.render(null));
					}
					data = "";
					// data += liquidacionPuesto.puestoLaboral.id;

					data += "2"; // Tipo_registro
					data += "285"; // Código de Banco
					data += "61310"; // Convenio

					data += Strings
							.padEnd(Integer
									.toString(liquidacionPuesto.puestoLaboral.legajo.numero),
									7, ' '); // ID_Cliente
					data += "4"; // Tipo_cuenta

					// if (sqlQuery.findUnique() != null) {
					data += Strings.padStart(row.getString("sucursal"), 3, '0');// Suc_cuenta
					// } else {
					// data += "023";
					// }

					String nro_cuenta = Strings.padStart(
							row.getString("numero_cuenta"), 15, '0');
					data += nro_cuenta;// Nro_cuenta

					data += " "; // espacio

					Date ahora = new Date();
					SimpleDateFormat formateador = new SimpleDateFormat(
							"yyyyMMdd");
					data += formateador.format(ahora); // fechapago (pantalla)

					String df = new DecimalFormat("000000000.00")
							.format(liquidacionPuesto.getTotalACobrar());
					data += df.replace(",", "");// importe

					data += "S";// marca
					data += "01";// secuencial
					data += "14";// provincia
					data += "00";// tipodoc
					data += "             ";// numerodoc
					data += "                              ";// apeynom
					data += "000";// grupoacred
					data += "00";// carga grupo acre
					data += "0000000";// comprobante
					data += "0000000000";// cortecontrol
					data += "00000";// periodo liq

					// fechaliq
					String fecha = new SimpleDateFormat("yyyyMMdd")
							.format(liquidacion.fecha_liquidacion);
					data += Strings.padStart(fecha, 8, ' ');

					data += " ";// estado
					data += "                    ";// libres

					// agrego la linea al archivo
					out.append(data).append("\r\n");

				}
			}

			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(reporteBanco.render(archivo.getPath()));
			//return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();

	}

	public static Result descargarBanco(String url) {
		return ok(new File(url));
	}

	@CheckPermiso(key = "liquidacionMesExportIps")
	public static Result exportIps(Long liquidacionId) {

		// obtengo datos de la liquidacion
		LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionId);

		// obtengo la liquidacion para cada puesto laboral
		List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
				.where().eq("liquidacion_mes_id", liquidacion.id).findList();

		// creacion de archivo temp
		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			File archivo = new File(dirTemp + "/export_ips.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(archivo), "Cp1252"));

			/*
			 * agrego una linea para cada puesto laboral
			 */
			Integer i = 1;
			for (LiquidacionPuesto liquidacionPuesto : liquidacionPuestos) {

				if (liquidacionPuesto.puestoLaboral != null && !liquidacionPuesto.getTotalCA().equals(new BigDecimal(0))) {

					String data = "";

					// legajo N
					data += Strings.padStart(
							liquidacionPuesto.puestoLaboral.legajo.numero
									.toString(), 8, '0');

					// lugar de pago N
					data += Strings.padStart("009701", 6, '0');

					// nro documento N
					data += Strings.padStart(
							liquidacionPuesto.puestoLaboral.legajo.agente.dni
									.toString(), 8, ' ');

					// funcion N
					data += Strings.padStart("95", 2, '0');

					// categoria/cargo N
					data += Strings.padStart(
							liquidacionPuesto.puestoLaboral.escalaLaboral.id
									.toString(), 3, ' ');

					// regimen jubilatorio N
					data += Strings.padStart("01", 2, '0');

					// tipo agente N
					data += Strings.padStart("0", 1, '0');

					// apellido y nombre del trabajador X
					data += Strings
							.padEnd(liquidacionPuesto.puestoLaboral.legajo.agente.apellido,
									25, ' ').substring(0, 25);

					// sexo X
					String sex = "";
					// if(sex == "male") {
					if (liquidacionPuesto.puestoLaboral.legajo.agente.sexo != null && liquidacionPuesto.puestoLaboral.legajo.agente.sexo.compareTo("male") == 0) {
						sex = "M";
					} else {
						sex = "F";
					}
					data += Strings.padEnd(sex, 1, ' ');

					////////////////////////////////////////////////////////////// cantidad de adherentes N
					data += Strings.padStart("0", 1, '0');

					//////////////////////////////////////////////////////////////////////////////////////

					// remun imponible jub N


					String remun = new DecimalFormat("0000000.00").format(liquidacionPuesto.getTotalCA());
					int f= 9;
					if(liquidacionPuesto.getTotalCA().compareTo(BigDecimal.ZERO) < 0) {
						remun = new DecimalFormat("000000.00").format(liquidacionPuesto.getTotalCA());
						f= 8;
					}

					remun = remun.replace(",", "").toString();
					data += Strings.padStart(remun, f, '0');

					//////////////////////////////////////////////////////////////////////////////////////

					// remun imponible obra soc N
					if(liquidacion.liquidacion_tipo_id == LiquidacionTipo.SAC){
						data += "000000000";
					}else{
						data += Strings.padStart(remun, f, '0');
					}

					//////////////////////////////////////////////////////////////////////////////////////

					// aporte jubilatorio N
					String aport = new DecimalFormat("00000.00").format(liquidacionPuesto.getTotalCA().multiply(new BigDecimal(0.19)));
					aport = aport.replace(",", "").toString();
					//data += Strings.padStart(aport, 7, '0');
					data += Strings.padStart("0", 7, '0');//APORTES JUBILACION DEJAMOS TODOS EN CERO PQ SE PASA EL VALOR

					// aporte obra social N
					String aportS = new DecimalFormat("00000.00").format(liquidacionPuesto.getTotalCA().multiply(new BigDecimal(0.05)));
					if(liquidacion.liquidacion_tipo_id == LiquidacionTipo.SAC){
						aportS= new DecimalFormat("00000.00").format(new BigDecimal(0));
					}

					aportS = aportS.replace(",", "").toString();
					//data += Strings.padStart(aportS, 7, '0');
					data += Strings.padStart("0", 7, '0');//APORTES OBRA SOCIAL DEJAMOS TODOS EN CERO PQ SE PASA EL VALOR

					// aporte serv funerario N
					data += Strings.padStart("0", 7, '0');

					// aporte adherentes obra s N
					data += Strings.padStart("0", 7, '0');

					// aporte adherentes serv fun N
					data += Strings.padStart("0", 7, '0');

					// conceptos de haberes
					Integer x = 0;
					for (LiquidacionDetalle liquidacionDetalle : liquidacionPuesto.liquidacionDetalle) {

						if (liquidacionDetalle.liquidacionConcepto.liquidacion_concepto_tipo_id == 1 || liquidacionDetalle.liquidacionConcepto.liquidacion_concepto_tipo_id == 4) {

							if (x == 20) {
								break;
							}

							// id concepto
							data += Strings
									.padStart(
											liquidacionDetalle.liquidacion_concepto_id
													.toString(), 4, '0')
									.substring(0, 4);

							// unidades
							String canti = new DecimalFormat("00000.00")
									.format(liquidacionDetalle.cantidad);
							canti = canti.replace(",", "").toString();
							data += Strings.padStart(canti, 7, '0');

							// importe
							BigDecimal importe = liquidacionDetalle.importe.multiply(liquidacionDetalle.cantidad);
							if(importe.compareTo(BigDecimal.ZERO) < 0){
								String imp = new DecimalFormat("000000.00").format(importe);
								imp = imp.replace(",", "").toString();
								data += Strings.padStart(imp, 8, '0');
 							}else{
								String imp = new DecimalFormat("0000000.00").format(importe);
								imp = imp.replace(",", "").toString();
								data += Strings.padStart(imp, 9, '0');
							}

							x++;
						}
					}

					// completa espcios en blanco
					data += Strings.padEnd("", 400 - (x * 20), ' ');

					// nro secuencia registro
					data += Strings.padStart(i.toString(), 6, '0');

					i++;

					// agrego la linea al archivo
					out.append(data).append("\r\n");

				}
			}

			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			// return ok(reporteIps.render(archivo.getPath()));
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();

	}

	public static Result descargarIps(String url) {
		return ok(new File(url));
	}

	@CheckPermiso(key = "liquidacionMesExportAfip")
	public static Result exportAfip(Long liquidacionId) {

		// obtengo datos de la liquidacion
		LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionId);

		// obtengo la liquidacion para cada puesto laboral
		List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
				.where().eq("liquidacion_mes_id", liquidacion.id).findList();

		// creacion de archivo temp
		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			File archivo = new File(dirTemp + "/export_afip.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(archivo), "Cp1252"));

			/*
			 * agrego una linea para cada puesto laboral
			 */
			for (LiquidacionPuesto liquidacionPuesto : liquidacionPuestos) {

				if (liquidacionPuesto.puestoLaboral != null) {

					String data = "";
					// data += liquidacionPuesto.puestoLaboral.id;

					data += Strings.padEnd(
							liquidacionPuesto.puestoLaboral.legajo.agente.cuit,
							11, ' '); // cuit
					data += Strings
							.padEnd(liquidacionPuesto.puestoLaboral.legajo.agente.apellido,
									30, ' ').substring(0, 30); // apellido

					// conyuge
					if (liquidacionPuesto.puestoLaboral.legajo.agente.conyugue_dni != null
							&& liquidacionPuesto.puestoLaboral.legajo.agente.sexo == "male") {
						data += "1";
					} else {
						data += "0";
					}

					// catidad de hijos
					String sql = "select count(*) hijos from agente_familias where tipo_familia_id = 1 and agente_id = :agente_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("agente_id",liquidacionPuesto.puestoLaboral.legajo.agente.id);
					SqlRow row = sqlQuery.findUnique();
					data += Strings.padStart(row.getString("hijos"), 2, '0');

					data += Strings.padEnd("01", 2, '0'); // cod situcion
					data += Strings.padEnd("01", 2, '0'); // cod condicion
					data += Strings.padEnd("905", 3, '0'); // cod actividad
					data += Strings.padEnd("51", 2, '0'); // cod zona
					data += Strings.padEnd("00,00", 5, '0'); // porc aporte adic
																// ss
					data += Strings.padEnd("008", 3, '0'); // cod modalidad
															// contratacion
					data += Strings.padEnd("", 6, '0'); // cod obra social
					data += Strings.padEnd("", 2, '0'); // cantidad de aderentes



					BigDecimal remuns2 = liquidacionPuesto.getTotalCA().add(
							liquidacionPuesto.getTotalSA());

					NumberFormat numberFormat = NumberFormat.getInstance();
					numberFormat.setMaximumFractionDigits(2);
					//String remuns = numberFormat.format(remuns2);
					String remuns = new DecimalFormat("###.##").format(remuns2);

					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remuneracion total

					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remuneracion
					// imponible
					data += Strings.padStart("0,00", 9, ' '); // asig familiares
																// pag
					data += Strings.padStart("0,00", 9, ' '); // importe aporte
																// vol
					data += Strings.padStart("0,00", 9, ' '); // importe
																// adicional os
					data += Strings.padStart("0,00", 9, ' '); // importe
																// exedente
					// aporte ss
					data += Strings.padStart("0,00", 9, ' '); // importe
																// exedente
					// aporte os
					data += Strings.padEnd("Misiones Posadas", 50, ' '); // prov
																			// localidad
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 2
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 3
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 4
					data += Strings.padEnd("00", 2, '0'); // codigo de
															// siniestrado
					data += Strings.padEnd("0", 1, '0'); // marca de corresponde
															// rediccion
					data += Strings.padStart("0,00", 9, ' '); // capital lrt
					data += Strings.padEnd("9", 1, ' '); // tipo de empresa
					data += Strings.padStart("0,00", 9, ' '); // aporte
																// adicional de
					// obre social
					data += Strings.padEnd("1", 1, ' '); // regimen
					data += Strings.padEnd("01", 2, ' '); // sit revista 1
					data += Strings.padEnd("01", 2, ' '); // dia inicio sit
															// revista 1
					data += Strings.padEnd("00", 2, ' '); // sit revista 2
					data += Strings.padEnd("00", 2, ' '); // dia inicio sit
															// revista 2
					data += Strings.padEnd("00", 2, ' '); // sit revista 3
					data += Strings.padEnd("00", 2, ' '); // dia inicio sit
															// revista 3
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // sueldo +
															// adicionales
					data += Strings.padStart("0,00", 12, ' '); // sac
					data += Strings.padStart("0,00", 12, ' '); // horas extra
					data += Strings.padStart("0,00", 12, ' '); // zona
																// desfavorable
					data += Strings.padStart("0,00", 12, ' '); // vacaciones
					data += Strings.padEnd("30", 9, ' '); // cant dias
															// trabajados
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 5
					data += Strings.padEnd("1", 1, ' '); // trabajador
															// convencionado
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun
																			// imponible
																			// 6
					data += Strings.padEnd("0", 1, ' '); // tipo de operacion
					data += Strings.padStart("0,00", 12, ' '); // adicionales
					data += Strings.padStart("0,00", 12, ' '); // premios
					data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // 788/05 rem impon 8
					data += Strings.padStart("0,00", 12, ' '); // remun
																// imponible 7
					data += Strings.padEnd("000", 3, ' '); // cant horas extras
					data += Strings.padStart("0,00", 12, ' '); // conc no
																// remunerativos
					data += Strings.padStart("0,00", 12, ' '); // maternidad
					data += Strings.padStart("0,00", 9, ' '); // rectificacion
																// de
					// remuneracion
					//data += Strings.padStart("0,00", 12, ' '); // remun  imponible 9
					data += Strings.padStart(remuns.replace('.', ','), 12, ' ');// remun  imponible 9

					data += Strings.padStart("0,00", 9, ' '); // contrib tarea
					// diferencial
					data += Strings.padEnd("0", 3, '0'); // horas trabajadas
					data += Strings.padEnd("F", 1, ' '); // seguro vida oblig

					// agrego la linea al archivo
					out.append(data).append("\r\n");

				}
			}

			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			// return ok(reporteAfip.render(archivo.getPath()));
			return ok(archivo);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();

	}

	public static Result descargarAfip(String url) {
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
