package migracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import com.avaje.ebean.Expr;

import models.Balance;
import models.BalanceExpediente;
import models.BalanceOrdenPago;
import models.Cuenta;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.FacturaLinea;
import models.FacturaLineaImpuesto;
import models.OrdenLinea;
import models.OrdenRubro;
import models.Usuario;
import models.haberes.LiquidacionMes;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoPago;
import play.Logger;
import server.Configuracion2;
import utils.DateUtils;
import play.mvc.Controller;
import play.mvc.Result;

public class ActualizarBalance extends Controller {

	public static boolean actualizarRp(){

		System.out.println("Empezo a ActualizarBalance FACTURA RP");
		Connection conn2 = null;

		
		try {

			Date fd = DateUtils.formatDate("01/01/2023", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("29/02/2023", "dd/MM/yyyy");


			conn2 = Configuracion2.get2().getConnection2();

			List<Factura> lf = Factura.find.where().ge("fecha_orden_pago", fd)
					   			.le("fecha_orden_pago", fh)
					   			.eq("state_id", Estado.FACTURA_ESTADO_APROBADO)
					   			//.eq("id",54788)
					   			.findList();

			for(Factura f:lf) {
				PreparedStatement stmt1 = conn2.prepareStatement("select id,cuenta_analitica_id from factura_lineas fl "
						+ "	where cuenta_analitica_id in(528,376,234,234,529,590,794,832) and  factura_id = ? ");
				stmt1.setLong(1,f.id);
				ResultSet rs1 = stmt1.executeQuery();

				if (rs1.next()) {
					System.out.println("BUSCANDO FACTURAS "+f.id);
					PreparedStatement stmt2 = conn2.prepareStatement("select cuenta_analitica_id from ordenes o "
							+ "inner join orden_lineas ol on ol.orden_id = o.id "
							+ "where o.id = ? group by cuenta_analitica_id");
					stmt2.setLong(1,f.orden_id);
					ResultSet rs2 = stmt2.executeQuery();

					int i = 0 ;
					Long cc = null;
					while(rs2.next()) {
						cc = rs2.getLong(1);
						i++;
					}

					if(i == 1) {
						//FacturaLinea flc =  FacturaLinea.find.where().eq("factura_id", f.id).f
						PreparedStatement stmt4 = conn2.prepareStatement("UPDATE factura_lineas SET cuenta_analitica_original_id= ? WHERE factura_id = ? ");
						stmt4.setLong(1, cc);
						stmt4.setLong(2, f.id);
						stmt4.executeUpdate();
					}
				}
			}


		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {

        }

		System.out.println("Termino a ActualizarBalance FACTURA RP");

		return true;
	}

	public static boolean facturaRecupero(){

		System.out.println("Empezo a ActualizarBalance FACTURA RECUPERO");
		Connection conn2 = null;

		try {

			Date fd = DateUtils.formatDate("01/11/2022", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/12/2022", "dd/MM/yyyy");


			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();

			int asiento = 0;

			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}

			List<RecuperoFactura> lf = RecuperoFactura.find.where().ge("fecha", fd)
					   .le("fecha", fh)
					   .eq("estado_id", Estado.RECUPERO_FACTURA_APROBADO)
					   //.not(Expr.in("expediente_id",idsExpLiq))
					   //.eq("id", 52641)
					   .findList();

			System.out.println("-------------- "+lf.size());

			for(RecuperoFactura f:lf) {
				Balance b = new Balance();
				b.fecha = f.fecha;
				b.fecha_debito = f.fecha;
				b.haber= f.base;
				b.expediente_id = (f.expediente_id != null)?f.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//b.orden_pago_id = f.orden_pago_id;
				b.debe = BigDecimal.ZERO;
				b.cuenta_propia_id = 2;
				b.estado_id = (long) Estado.BALANCE_BORRADOR;
				b.cuenta_id = 470;
				b.tipo = "factura_recupero";
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.asiento = asiento;
				//b.orden_id = f.orden_id;
				b.referencia = "fac-"+f.id.toString();
				b.save();

				Integer cc = 320;

				if(f.cliente_id.equals((long) 11281) || f.cliente_id.equals((long) 7705) || f.cliente_id.equals((long) 9951)) {
					cc = 316;//316	1.1.3.03.02 Entidades de Medicina Prepaga
				}else {

					if(f.cliente.cliente_tipo_id.equals((long) 1)) {//"1";"Obras sociales"
						cc = 315;//315	1.1.3.03.01 Obras Sociales
					}else if(f.cliente.cliente_tipo_id.equals((long) 2) ||  f.cliente.cliente_tipo_id.equals((long) 7)) {//"2";"Extranjeros" || "7";"Pacientes"
						cc = 319;//319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
					}else if(f.cliente.cliente_tipo_id.equals((long) 3) || f.cliente.cliente_tipo_id.equals((long) 9)) {//"3";"Compañías de seguro" || "9";"ART"
						cc = 317;//317	1.1.3.03.03 Compañias de Seguro <option value="9">ART</option>
					}else if(f.cliente.cliente_tipo_id.equals((long) 10)) {//"10";"Otros"
						cc = 320;//320	1.1.3.03.06 Otros Creditos
					}
				}
				/*315	1.1.3.03.01 Obras Sociales
				319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
				317	1.1.3.03.03 Compañias de Seguro
				320	1.1.3.03.06 Otros Creditos






					<option class="blank" value="">Seleccionar</option>
	            	<option value="7">Pacientes</option>


				*/

				Balance bx = new Balance();
				bx.fecha = f.fecha;
				bx.fecha_debito = f.fecha;
				bx.haber= BigDecimal.ZERO;
				bx.debe = f.base;
				bx.expediente_id = (f.expediente_id != null)?f.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//bx.orden_pago_id = f.orden_pago_id;
				bx.cuenta_propia_id = 2;
				bx.cuenta_id = cc;
				bx.tipo = "factura_recupero";
				bx.asiento = asiento;
				bx.create_date = new Date();
				bx.estado_id = (long) Estado.BALANCE_BORRADOR;
				bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//bx.orden_id = f.orden_id;
				bx.referencia = "fac-"+f.id.toString();
				bx.save();


				asiento ++;
			}



		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance FACTURA RECUPERO");

		return true;
	}

	public static boolean pagoRecupero(){

		System.out.println("Empezo a ActualizarBalance PAGO RECUPERO");
		Connection conn2 = null;

		try {

			Date fd = DateUtils.formatDate("01/11/2022", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/12/2022", "dd/MM/yyyy");


			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();

			int asiento = 0;

			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}

			List<RecuperoPago> lf = RecuperoPago.find.where().ge("fecha", fd)
					   .le("fecha", fh)
					   .eq("estado_id", Estado.RECUPERO_PAGO_PAGADO)
					   //.not(Expr.in("expediente_id",idsExpLiq))
					   //.eq("id", 52641)
					   .findList();

			System.out.println("-------------- "+lf.size());

			for(RecuperoPago f:lf) {
				Balance b = new Balance();
				b.fecha = f.fecha;
				b.fecha_debito = f.fecha;

				b.expediente_id = (f.expediente_id != null)?f.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//b.orden_pago_id = f.orden_pago_id;
				b.haber= BigDecimal.ZERO;
				b.debe = f.total;
				b.cuenta_propia_id = 2;
				b.estado_id = (long) Estado.BALANCE_BORRADOR;
				b.cuenta_id = 292;//1.1.1.02.05 Bco Macro C/C $ N 0940876918/4 Rec Fondos Sol Sal
				b.tipo = "pago_recupero";
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.asiento = asiento;
				//b.orden_id = f.orden_id;
				b.referencia = "pago-"+f.id.toString();
				b.save();

				Integer cc = 320;

				if(f.cliente_id.equals((long) 11281) || f.cliente_id.equals((long) 7705) || f.cliente_id.equals((long) 9951)) {
					cc = 316;//316	1.1.3.03.02 Entidades de Medicina Prepaga
				}else {

					if(f.cliente.cliente_tipo_id.equals((long) 1)) {//"1";"Obras sociales"
						cc = 315;//315	1.1.3.03.01 Obras Sociales
					}else if(f.cliente.cliente_tipo_id.equals((long) 2) ||  f.cliente.cliente_tipo_id.equals((long) 7)) {//"2";"Extranjeros" || "7";"Pacientes"
						cc = 319;//319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
					}else if(f.cliente.cliente_tipo_id.equals((long) 3) || f.cliente.cliente_tipo_id.equals((long) 9)) {//"3";"Compañías de seguro" || "9";"ART"
						cc = 317;//317	1.1.3.03.03 Compañias de Seguro <option value="9">ART</option>
					}else if(f.cliente.cliente_tipo_id.equals((long) 10)) {//"10";"Otros"
						cc = 320;//320	1.1.3.03.06 Otros Creditos
					}
				}
				/*315	1.1.3.03.01 Obras Sociales
				319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
				317	1.1.3.03.03 Compañias de Seguro
				320	1.1.3.03.06 Otros Creditos






					<option class="blank" value="">Seleccionar</option>
	            	<option value="7">Pacientes</option>


				*/

				Balance bx = new Balance();
				bx.fecha = f.fecha;
				bx.fecha_debito = f.fecha;
				bx.haber= f.total;
				bx.debe = BigDecimal.ZERO;
				bx.expediente_id = (f.expediente_id != null)?f.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//bx.orden_pago_id = f.orden_pago_id;
				bx.cuenta_propia_id = 2;
				bx.cuenta_id = cc;
				bx.tipo = "pago_recupero";
				bx.asiento = asiento;
				bx.create_date = new Date();
				bx.estado_id = (long) Estado.BALANCE_BORRADOR;
				bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//bx.orden_id = f.orden_id;
				bx.referencia = "pago-"+f.id.toString();
				bx.save();


				asiento ++;
			}



		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance FACTURA RECUPERO");

		return true;
	}

	public static boolean notaCreditoRecupero(){

		System.out.println("Empezo a ActualizarBalance PAGO RECUPERO");
		Connection conn2 = null;

		try {

			Date fd = DateUtils.formatDate("01/04/2022", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/12/2022", "dd/MM/yyyy");


			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();

			int asiento = 0;

			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}

			List<RecuperoNotaCredito> lf = RecuperoNotaCredito.find.where().ge("fecha", fd)
					   .le("fecha", fh)
					   .eq("recupero_factura.estado_id", Estado.RECUPERO_FACTURA_APROBADO)
					   //.not(Expr.in("expediente_id",idsExpLiq))
					   //.eq("id", 52641)
					   .findList();

			System.out.println("-------------- "+lf.size());


			for(RecuperoNotaCredito f:lf) {
				Balance b = new Balance();
				b.fecha = f.fecha;
				b.fecha_debito = f.fecha;

				b.expediente_id = (f.recupero_factura.expediente_id != null)?f.recupero_factura.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//b.orden_pago_id = f.orden_pago_id;
				b.debe = f.getTotal();
				b.haber= BigDecimal.ZERO;
				b.cuenta_propia_id = 2;
				b.estado_id = (long) Estado.BALANCE_BORRADOR;
				b.cuenta_id = 555;//4.2.2.04.02 Descuentos Otorgados
				b.tipo = "nt_recupero";
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.asiento = asiento;
				//b.orden_id = f.orden_id;
				b.referencia = "fac-"+f.recupero_factura.id.toString();
				b.save();

				Integer cc = 320;

				if(f.recupero_factura.cliente_id.equals((long) 11281) || f.recupero_factura.cliente_id.equals((long) 7705) || f.recupero_factura.cliente_id.equals((long) 9951)) {
					cc = 316;//316	1.1.3.03.02 Entidades de Medicina Prepaga
				}else {

					if(f.recupero_factura.cliente.cliente_tipo_id.equals((long) 1)) {//"1";"Obras sociales"
						cc = 315;//315	1.1.3.03.01 Obras Sociales
					}else if(f.recupero_factura.cliente.cliente_tipo_id.equals((long) 2) ||  f.recupero_factura.cliente.cliente_tipo_id.equals((long) 7)) {//"2";"Extranjeros" || "7";"Pacientes"
						cc = 319;//319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
					}else if(f.recupero_factura.cliente.cliente_tipo_id.equals((long) 3) || f.recupero_factura.cliente.cliente_tipo_id.equals((long) 9)) {//"3";"Compañías de seguro" || "9";"ART"
						cc = 317;//317	1.1.3.03.03 Compañias de Seguro <option value="9">ART</option>
					}else if(f.recupero_factura.cliente.cliente_tipo_id.equals((long) 10)) {//"10";"Otros"
						cc = 320;//320	1.1.3.03.06 Otros Creditos
					}
				}
				/*315	1.1.3.03.01 Obras Sociales
				319	1.1.3.03.05 Extranjeros sin Residencia Legal en el Pais
				317	1.1.3.03.03 Compañias de Seguro
				320	1.1.3.03.06 Otros Creditos
				<option class="blank" value="">Seleccionar</option>
	            	<option value="7">Pacientes</option>


				*/

				Balance bx = new Balance();
				bx.fecha = f.fecha;
				bx.fecha_debito = f.fecha;
				bx.haber= f.getTotal();
				bx.debe = BigDecimal.ZERO;
				bx.expediente_id = (f.recupero_factura.expediente_id != null)?f.recupero_factura.expediente_id:(f.planilla != null && f.planilla.expediente_id != null)?f.planilla.expediente_id:null;
				//bx.orden_pago_id = f.orden_pago_id;
				bx.cuenta_propia_id = 2;
				bx.cuenta_id = cc;
				bx.tipo = "nt_recupero";
				bx.asiento = asiento;
				bx.create_date = new Date();
				bx.estado_id = (long) Estado.BALANCE_BORRADOR;
				bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//bx.orden_id = f.orden_id;
				bx.referencia = "fac-"+f.recupero_factura.id.toString();
				bx.save();

				asiento ++;
			}


		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance FACTURA RECUPERO");

		return true;
	}

	public static boolean facturas(){

		System.out.println("Empezo a ActualizarBalance");
		Connection conn2 = null;

		try {

			Date fd = DateUtils.formatDate("01/01/2023", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/01/2023", "dd/MM/yyyy");


			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();

			int asiento = 0;

			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}


			/*List<LiquidacionMes> lmm = LiquidacionMes.find.findList();
			List<Integer> idsExpLiq = new ArrayList<Integer>();
			for(LiquidacionMes lmx :lmm) {
				if(!idsExpLiq.contains(lmx.expediente_id)) {
					idsExpLiq.add(lmx.expediente_id);
				}

				if(!idsExpLiq.contains(lmx.expediente_aporte_id)) {
					idsExpLiq.add(lmx.expediente_aporte_id);
				}
				if(!idsExpLiq.contains(lmx.expediente_segurovida_id)) {
					idsExpLiq.add(lmx.expediente_segurovida_id);
				}
				if(!idsExpLiq.contains(lmx.expediente_segurosepelio_id)) {
					idsExpLiq.add(lmx.expediente_segurosepelio_id);
				}
				if(!idsExpLiq.contains(lmx.expediente_contribuciones_id)) {
					idsExpLiq.add(lmx.expediente_contribuciones_id);
				}
			}
			*/
			List<Integer> idsExpLiq = new ArrayList<Integer>();






			List<Factura> lf = Factura.find.where().ge("fecha_orden_pago", fd)
													.le("fecha_orden_pago", fh)
													.eq("state_id", Estado.FACTURA_ESTADO_APROBADO)
													//.in("id", idsExpLiq)


												   //.not(Expr.in("expediente_id",idsExpLiq))
													//.eq("id", 66556)
												   //.eq("orden_pago_id",29783)
													.findList();

			System.out.println("-------------- "+lf.size());

			/*for(Factura f:lf) {
				System.out.println("-------------- "+f.id);
				if(f.id.compareTo(new Long(74518)) == 0) {
					System.out.println("aaaaaaaayyyyyyyyyyyyy");
					return true;
				}
			}*/

			List<Long> listaOpSueldo = new ArrayList<Long>();
			List<Long> listaOpSueldoConvenio = new ArrayList<Long>();

			if(true) {
			for(Factura f:lf) {




				boolean ISHONORARIO = false;
				boolean SUELDOSPARQUE = false;
				boolean SUELDOSCONVENIO = false;
				boolean IMPUESTO_GANANCIAS = false;
				boolean PRESTAFACIL = false;
				boolean PASANTIAS = false;

				Map<Long,BigDecimal> montoPorCuenta = new HashMap<Long, BigDecimal>();
				Long cuentaId=null;
				for(FacturaLinea fl :f.facturaLinea) {

					cuentaId=new Long(546);

					Logger.debug("00000000000 "+fl.cuenta_analitica_id);

					Long cuenta_analitica_original_id= (fl.cuenta_analitica_original_id != null)?fl.cuenta_analitica_original_id:fl.cuenta_analitica_id;

					Long cuenta_analitica_reporta_id= fl.cuentaAnaliticaOriginal.cuentaReporta.id;
					if(cuenta_analitica_reporta_id == null) {
						Logger.debug("ERRRORRRRRRRRRRRR VIENE EN NULL cuenta_analitica_reporta_id: "+ cuenta_analitica_reporta_id);
						return false;
					}

					if(cuenta_analitica_original_id.equals((long)590) || cuenta_analitica_original_id.equals((long)794)) {
						 Logger.debug("1111111111111111111");
						List<OrdenLinea> ol = OrdenLinea.find.where().eq("producto_id", fl.producto_id).eq("orden_id", f.orden_id).findList();
						if(ol.size() >0) {
							 Logger.debug("22222222");
							 cuenta_analitica_original_id= ol.get(0).cuenta_analitica_id;
							 Logger.debug("aaaaaaaaaaaaaaaaaaaaa"+cuentaId);
						}else {
							 Logger.debug("3333333333333");
							List<OrdenLinea> olx = OrdenLinea.find.where().eq("orden_id", f.orden_id).findList();
							 if(olx.size() >0) {
								 Logger.debug("444444");
								 cuenta_analitica_original_id= olx.get(0).cuenta_analitica_id;
							 }
						}

					}
					Logger.debug("111111111");

					if(cuenta_analitica_original_id.equals((long)222)) {//ADICIONALES	HONORARIOS
						if(fl.factura.proveedor_id.equals(11081)) { //INSTITUTO DE PREVISIÓN SOCIAL MISIONES
							cuentaId = new Long(516);//4.2.2/02/20 Aportes y Contribuciones
						}else if(fl.factura.proveedor_id.equals(3172)){//NACIÓN SEGUROS
							if(fl.producto_id.equals((long)42201) || fl.producto_id.equals((long)36881)) {
								cuentaId = new Long(517);//4.2.2/02/21 Seguro Sepelio
							}else if(fl.producto_id.equals((long)42202) || fl.producto_id.equals((long)36882)) {
								cuentaId = new Long(518);//4.2.2/02/22 Seguro Vida
							}
						}else if(fl.factura.proveedor_id.equals(1366)){//AFIP
							if(fl.producto_id.equals((long)52513)) {//IMPUESTO A LAS GANANCIAS (30100)
								cuentaId = new Long(515);//4.2.2/02/19 Haberes
								IMPUESTO_GANANCIAS = true;
							}
						}else if(fl.factura.proveedor_id.equals(12770)){//GRUPO PRESTAFACIL S.A.
							cuentaId = new Long(515);//4.2.2/02/19 Haberes
							PRESTAFACIL = true;

						}else {
							cuentaId = new Long(515);//4.2.2/02/19 Haberes
						}
						Logger.debug("cuentaIdcuentaIdcuentaIdcuentaIdcuentaIdcuentaIdcuentaId");
						Logger.debug(cuentaId.toString());
						Logger.debug("ssssss "+fl.factura.proveedor_id.equals(3172));
						Logger.debug(fl.factura.proveedor_id.toString());



						if(!listaOpSueldo.contains(f.orden_pago_id) && !listaOpSueldoConvenio.contains(f.orden_pago_id)) {
							List<LiquidacionMes> lm = LiquidacionMes.find.where().eq("orden_pago_id", f.orden_pago_id).findList();
							if(lm.get(0).convenio_ministerio) {
								SUELDOSCONVENIO = true;
								listaOpSueldoConvenio.add(f.orden_pago_id);
							}else {
								SUELDOSPARQUE = true;
								listaOpSueldo.add(f.orden_pago_id);
							}

						}else {
							if(listaOpSueldo.contains(f.orden_pago_id)){
								SUELDOSPARQUE = true;
							}else if(listaOpSueldoConvenio.contains(f.orden_pago_id)) {
								SUELDOSCONVENIO = true;
							}
						}

					}


					if(cuenta_analitica_original_id.equals((long)269)) {//Banco de Protesis	PROTESIS
						cuentaId = new Long(349);//1.1.5/02/00 Protesis- Ortesis
					}


					if(cuenta_analitica_original_id.equals((long)178)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS
						if(fl.factura.orden.orden_rubro_id.equals((long)8)) {//HONORARIOS
							cuentaId = new Long(489);//4.2.1/02/04 Honorarios Profesionales
							ISHONORARIO = true;
						}else if(fl.factura.orden.orden_rubro_id.equals((long)5)) {//OTROS SERVICIOS
							cuentaId = new Long(497);//	4.2.2/02/01
						}
					}

					if(cuenta_analitica_original_id.equals((long)286)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (IMC)
						cuentaId = new Long(520);//4.2.2/02/24 Transferencias a IMC
						ISHONORARIO = true;
					}

					if(cuenta_analitica_original_id.equals((long)692)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (JME)
						cuentaId = new Long(521);//4.2.2/02/25 Transferencias a Otras Instituciones
						ISHONORARIO = true;
					}

					if(cuenta_analitica_original_id.equals((long)609)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (LACMI)
						cuentaId = new Long(522);//.2.2/02/26 Transferencias a LACMI
						ISHONORARIO = true;
					}

					if(cuenta_analitica_original_id.equals((long)343)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (PTM)
						cuentaId = new Long(525);//4.2.2/02/29 Transferencias a Transplante de Medula
						ISHONORARIO = true;
					}

					if(cuenta_analitica_original_id.equals((long)183)) {//IMPUESTOS, DERECHOS Y TASAS
						cuentaId = new Long(511);//4.2.2/02/15 Impuestos y Tasas DGR
					}

					//OTROS BIENES DE CONSUMO (HMN)
					if(cuenta_analitica_original_id.equals((long)1015)) {
						cuentaId = new Long(519);
					}
					//974 OTROS BIENES DE CONSUMO (OBERA)
					if(cuenta_analitica_original_id.equals((long)974)) {
						cuentaId = new Long(560);
					}
					//849	OTROS BIENES DE CONSUMO (UCEyT)
					if(cuenta_analitica_original_id.equals((long)849)) {
						cuentaId = new Long(557);
					}
					//933	OTROS BIENES DE CONSUMO (LEMIS)
					if(cuenta_analitica_original_id.equals((long)933)) {
						cuentaId = new Long(559);
					}
					//894	OTROS BIENES DE CONSUMO (HEO)
					if(cuenta_analitica_original_id.equals((long)894)) {
						cuentaId = new Long(558);
					}
					//807	OTROS BIENES DE CONSUMO (IMR)
					if(cuenta_analitica_original_id.equals((long)807)) {
						cuentaId = new Long(556);
					}

					if(cuenta_analitica_original_id.equals((long)60)) {//OTROS BIENES DE CONSUMO
						cuentaId = new Long(493);//4.2.2/01/01 Insumos Varios
						if(fl.factura.orden.deposito_id.equals((long)30)) {
							if(fl.factura.orden.orden_rubro_id.equals((long)4) || fl.factura.orden.orden_rubro_id.equals((long)2)) {
								cuentaId = new Long(523);//4.2.2/02/27 Transferencias a Banco de Sangre
							}
						}


						if(fl.factura.orden.deposito_id.equals((long)25)) {
							if(fl.factura.orden.orden_rubro_id.equals((long)4)) {
								cuentaId = new Long(527);//4.2.2/02/31 Transferencias a Pediatrico
							}
						}
						//"2";"HOSPITAL MATERNO NEONATAL"
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(519);
						}
						//"4";"HOSPITAL SAMIC DE OBERA"
						if(fl.factura.orden.deposito_id.equals((long)4)) {
							cuentaId = new Long(560);
						}
						//"27";"UNIDAD DE TRASLADO"
						if(fl.factura.orden.deposito_id.equals((long)27)) {
							cuentaId = new Long(557);
						}
						//"29";"LEMIS"
						if(fl.factura.orden.deposito_id.equals((long)29)) {
							cuentaId = new Long(559);
						}

					}



					if(cuenta_analitica_original_id.equals((long)642)) {//OTROS BIENES DE CONSUMO (FATIMA)
						cuentaId = new Long(528);//4.2.2/02/32 Transferencias a Fatima
					}

					if(cuenta_analitica_original_id.equals((long)339)) {//OTROS BIENES DE CONSUMO (IGH)
						cuentaId = new Long(526);
					}

					if(cuenta_analitica_original_id.equals((long)306)) {//OTROS BIENES DE CONSUMO (IMC)
						cuentaId = new Long(520);//4.2.2/02/24 Transferencias a IMC
					}

					if(cuenta_analitica_original_id.equals((long)606)) {//"OTROS BIENES DE CONSUMO (LACMI)"
						cuentaId = new Long(522);//4.2.2/02/26 Transferencias a LACMI
					}


					if(cuenta_analitica_original_id.equals((long)738)) {//OTROS BIENES DE CONSUMO (PLAN SUMAR FATIMA)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//INSUMOS VARIOS
							cuentaId = new Long(493);//4.2.2/01/01 Insumos Varios
						}else if(fl.factura.orden.orden_rubro_id.equals((long)1)) {//EQUIPAMIENTOS
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)540)) {//OTROS BIENES DE CONSUMO (PLAN SUMAR)
						cuentaId = new Long(352);//4.2.2/02/26 bienes de uso
					}


					if(cuenta_analitica_original_id.equals((long)174)) {//OTROS BIENES DE CONSUMO (PROFE)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//INSUMOS VARIOS
							cuentaId = new Long(493);//4.2.2/01/01 Insumos Varios
						}else if(fl.factura.orden.orden_rubro_id.equals((long)4)) {
							cuentaId = new Long(493);//4.2.2/01/01 Insumos Varios
						}
					}


					if(cuenta_analitica_original_id.equals((long)25)) {//OTROS BIENES DE CONSUMO (PTM)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//INSUMOS VARIOS
							cuentaId = new Long(525);//4.2.2/01/01 Insumos Varios
						}else if(fl.factura.orden.orden_rubro_id.equals((long)4)) {
							cuentaId = new Long(525);//4.2.2/01/01 Insumos Varios
						}
					}


					if(cuenta_analitica_original_id.equals((long)111)) {//OTROS EQUIPOS
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//	bienes de uso
							cuentaId = new Long(352);//	bienes de uso
						}else if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)667)) {//OTROS EQUIPOS (FATIMA)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//	bienes de uso
							cuentaId = new Long(352);//	bienes de uso
						}else if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)460)) {//OTROS EQUIPOS (IGH)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {//	bienes de uso
							cuentaId = new Long(352);//	bienes de uso
						}else if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)626)) {//OTROS EQUIPOS (LACMI)
						if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)564)) {//OTROS EQUIPOS (PTM)
						if(fl.factura.orden.orden_rubro_id.equals((long)3)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)786)) {//OTROS EQUIPOS(PLAN SUMAR FATIMA)
						if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)780)) {//OTROS EQUIPOS(PLAN SUMAR LACMI)
						if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}

					if(cuenta_analitica_original_id.equals((long)586)) {//OTROS EQUIPOS(PLAN SUMAR)
						if(fl.factura.orden.orden_rubro_id.equals((long)1)) {
							cuentaId = new Long(352);//	bienes de uso
						}
					}






					if(cuenta_analitica_original_id.equals((long)187)) {//OTROS SS. NO PERSONALES
						cuentaId = new Long(497);//497	4.2.2/02/01
						if(fl.factura.proveedor_id.equals(2328)) {//reñe
							cuentaId = new Long(488);//		4.2.1/02/03 Insumos de Oncologia
						}else if(fl.factura.proveedor_id.equals(1591)) {//policia
							cuentaId = new Long(505);//			4.2.2/02/09 Servicios Seguridad Policial
						}else if(fl.factura.proveedor_id.equals(1585) ||fl.factura.proveedor_id.equals(13752) ) {//SAPEM o PANORAMA
							cuentaId = new Long(505);//507	4.2.2/02/11 Publicidad y Propaganda
						}else if(fl.factura.proveedor_id.equals(1838)) {//PACIFIC
							cuentaId = new Long(512);//512	4.2.2/02/16 Vuelos Sanitarios
						}

						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(527);//527	4.2.2/02/31 Transferencias a Pediatrico
						}

						//"2";"HOSPITAL MATERNO NEONATAL"
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(519);
						}
						//"4";"HOSPITAL SAMIC DE OBERA"
						if(fl.factura.orden.deposito_id.equals((long)4)) {
							cuentaId = new Long(560);
						}
						//"27";"UNIDAD DE TRASLADO"
						if(fl.factura.orden.deposito_id.equals((long)27)) {
							cuentaId = new Long(557);
						}
						//"29";"LEMIS"
						if(fl.factura.orden.deposito_id.equals((long)29)) {
							cuentaId = new Long(559);
						}



					}

					//1027	OTROS SS. NO PERSONALES (HMN)
					if(cuenta_analitica_original_id.equals((long)1027)) {
						cuentaId = new Long(519);
					}
					//986	OTROS SS. NO PERSONALES (OBERA)
					if(cuenta_analitica_original_id.equals((long)986)) {
						cuentaId = new Long(560);
					}
					//861	OTROS SS. NO PERSONALES (UCEyT)
					if(cuenta_analitica_original_id.equals((long)861)) {
						cuentaId = new Long(557);
					}
					//945	OTROS SS. NO PERSONALES (LEMIS)
					if(cuenta_analitica_original_id.equals((long)945)) {
						cuentaId = new Long(559);
					}
					//906	OTROS SS. NO PERSONALES (HEO)
					if(cuenta_analitica_original_id.equals((long)906)) {
						cuentaId = new Long(558);
					}
					//828	OTROS SS. NO PERSONALES (IMR)
					if(cuenta_analitica_original_id.equals((long)828)) {
						cuentaId = new Long(556);
					}



					if(cuenta_analitica_original_id.equals((long)653)) {//OTROS SS. NO PERSONALES (FATIMA)
						if(fl.factura.orden.orden_rubro_id.equals((long)7) || fl.factura.orden.orden_rubro_id.equals((long)2) || fl.factura.orden.orden_rubro_id.equals((long)5)) {
							cuentaId = new Long(528);//4.2.2/02/32 Transferencias a Fatima
						}
					}

					if(cuenta_analitica_original_id.equals((long)318)) {//OTROS SS. NO PERSONALES (IGH)
						if(fl.factura.orden.orden_rubro_id.equals((long)5) ||
								fl.factura.orden.orden_rubro_id.equals((long)3) ||
								fl.factura.orden.orden_rubro_id.equals((long)2)
							) {
							cuentaId = new Long(526);//Transferencias a Genetica
						}
					}

					if(cuenta_analitica_original_id.equals((long)295)) {//OTROS SS. NO PERSONALES (IMC)
						if(fl.factura.orden.orden_rubro_id.equals((long)5) ||
								fl.factura.orden.orden_rubro_id.equals((long)7) ||
								fl.factura.orden.orden_rubro_id.equals((long)8) ||
								fl.factura.orden.orden_rubro_id.equals((long)3) ||
								fl.factura.orden.orden_rubro_id.equals((long)2)
							) {
							cuentaId = new Long(520);//4.2.2/02/24 Transferencias a IMC
						}
					}

					if(cuenta_analitica_original_id.equals((long)618)) {//OTROS SS. NO PERSONALES (LACMI)
						if(fl.factura.orden.orden_rubro_id.equals((long)8) ||
								fl.factura.orden.orden_rubro_id.equals((long)5) ||
								fl.factura.orden.orden_rubro_id.equals((long)7) ||
								fl.factura.orden.orden_rubro_id.equals((long)2)
							) {
							cuentaId = new Long(522);//4.2.2/02/26 Transferencias a LACMI
						}
					}

					if(cuenta_analitica_original_id.equals((long)73)) {//OTROS SS. NO PERSONALES (PROFE)
						if(fl.factura.orden.orden_rubro_id.equals((long)5) ||
								fl.factura.orden.orden_rubro_id.equals((long)2) ||
								fl.factura.orden.orden_rubro_id.equals((long)4)
							) {
							cuentaId = new Long(497);//4.2.2/02/01
							}
					}

					if(cuenta_analitica_original_id.equals((long)352)) {//OTROS SS. NO PERSONALES (PTM)
						if(fl.factura.orden.orden_rubro_id.equals((long)5) ||
								fl.factura.orden.orden_rubro_id.equals((long)8) ||
								fl.factura.orden.orden_rubro_id.equals((long)2)
							) {
							cuentaId = new Long(525);//4.2.2/02/29 Transferencias a Transplante de Medula
						}
					}

					if(cuenta_analitica_original_id.equals((long)56)) {//PRODUCTOS QUIMICOS Y MEDICINA
						if(fl.factura.orden.orden_rubro_id.equals((long)7) || fl.factura.orden.orden_rubro_id.equals((long)4)) {
							cuentaId = new Long(552);//1.1.5/01/00 Medicamentos y Descartables
						}else if (fl.factura.orden.orden_rubro_id.equals((long)3)) {
							cuentaId = new Long(493);//4.2.2/01/01 Insumos Varios
						}
					}

					if(cuenta_analitica_original_id.equals((long)644)) {//PRODUCTOS QUIMICOS Y MEDICINA (FATIMA)
						if(fl.factura.orden.orden_rubro_id.equals((long)7) ||
								fl.factura.orden.orden_rubro_id.equals((long)4)
							) {
							cuentaId = new Long(528);//4.2.2/02/32 Transferencias a Fatima
						}
					}

					if(cuenta_analitica_original_id.equals((long)304)) {//PRODUCTOS QUIMICOS Y MEDICINA (IMC)
						if(fl.factura.orden.orden_rubro_id.equals((long)4)
							) {
							cuentaId = new Long(520);//4.2.2/02/24 Transferencias a IMC
						}
					}

					if(cuenta_analitica_original_id.equals((long)170)) {//PRODUCTOS QUIMICOS Y MEDICINA (PROFE)
						if(fl.factura.orden.orden_rubro_id.equals((long)4)
							) {
							cuentaId = new Long(479);//4.2.1/01/01 Medicamentos y descartables
						}
					}

					if(cuenta_analitica_original_id.equals((long)523)) {//PRODUCTOS QUIMICOS Y MEDICINA (PTM)
						if(fl.factura.orden.orden_rubro_id.equals((long)4)
							) {
							cuentaId = new Long(525);//4.2.2/02/29 Transferencias a Transplante de Medula
						}
					}

					if(cuenta_analitica_original_id.equals((long)116)) {//REFACCION Y AMPLIACION
						if(fl.factura.orden.orden_rubro_id.equals((long)9)
							) {
							cuentaId = new Long(498);//4.2.2/02/02 Serv. Mantenimiento Edilicio
						}
					}


					if(cuenta_analitica_original_id.equals((long)791)) {//REFACCION Y AMPLIACION (PLAN SUMAR LACMI)
						if(fl.factura.orden.orden_rubro_id.equals((long)9)
							) {
							cuentaId = new Long(498);//4.2.2/02/02 Serv. Mantenimiento Edilicio
						}
					}

					if(cuenta_analitica_original_id.equals((long)228)) {//SEGUROS Y COMISIONES
						if(fl.factura.orden.orden_rubro_id.equals((long)7)) {
							if(fl.factura.proveedor_id.equals(11101) || fl.factura.proveedor_id.equals(2756)) { //INTERBANKING SA / Banco Macro S.A.
								cuentaId = new Long(499);//4.2.2/02/03 Gastos y Comisiones Bancarias
							}
						}
					}

					if(cuenta_analitica_original_id.equals((long)184)) {//VIATICOS Y MOVILIDAD
						if(fl.factura.orden.orden_rubro_id.equals((long)8) || fl.factura.orden.orden_rubro_id.equals((long)5)) {
							cuentaId = new Long(506);//	4.2.2/02/10 Serv. Varios Operativos
						}
					}

					if(cuenta_analitica_original_id.equals((long)315)) {//VIATICOS Y MOVILIDAD (IGH)
						if(fl.factura.orden.orden_rubro_id.equals((long)8)) {
							cuentaId = new Long(526);//Transferencias a Genetica
						}
					}


					if(cuenta_analitica_original_id.equals((long)292)) {//VIATICOS Y MOVILIDAD (IMC)
						if(fl.factura.orden.orden_rubro_id.equals((long)8)) {
							cuentaId = new Long(520);//4.2.2/02/24 Transferencias a IMC
						}
					}

					Integer idProveedor = fl.factura.proveedor_id;

					if(idProveedor.equals(13448) || idProveedor.equals(2176) || idProveedor.equals(1587) || idProveedor.equals(3843)) {//Proveedor: TELECOM ARGENTINA SOCIEDAD ANONIMA/ FEDERAL GAS S.A./ ATMEDO: SERVICIO DE ATENCION DOMICILIARIAS/ SAIDMAN: SERVICIO DE BIOINGENIERIA/
						cuentaId = new Long(497);//4.2.2/02/01	Proveedores de Servicios
					}else if(idProveedor.equals(1590)) {//Proveedores:  Industria del Lavado de Bravo Hector Alberto
						cuentaId = new Long(501);//4.2.2/02/05	Servicio de Lavado de Ropas
					}else if(idProveedor.equals(1592)) {//Proveedor: Constructora Pindoi S.R.L./
						cuentaId = new Long(502);//4.2.2/02/06	Servicio Limpieza
					}else if(idProveedor == null) {//Proveedor:./ SERVICIO DE LIMPIEZA Y MANTENIMIENTO DE ESPACIOS VERDES
						cuentaId = new Long(503);//4.2.2/02/07	Servicio Limpieza de Terceros
					}else if(idProveedor.equals(1588)) {//Proveedor:./ COMPAÑIA MISIONERA DE SEGURIDAD S.R.L.
						cuentaId = new Long(504);//4.2.2/02/08	Servicio Vigilancia
					}else if(idProveedor.equals(1591)) {//Proveedor:./ JEFATURA DE POLICIA DE MISIONES
						cuentaId = new Long(505);//4.2.2/02/09	Servicios Seguridad Policial
					}else if(idProveedor.equals(1585)) {//Proveedor:.Multimedios SAPEM
						cuentaId = new Long(507);//4.2.2/02/11	Publicidad y Propaganda
					}else if(idProveedor.equals(1838)) {//Proveedor:PACIFIC OCEAN S.A./En Producto dice : SERVICIO DE VUELO SANITARIO
						if(fl.producto.nombre.toLowerCase().contains("vuelo") ){
							cuentaId = new Long(512);//4.2.2/02/16	Vuelos Sanitarios
						}
					}else if(idProveedor.equals(3172)) {//Proveedor:NACION SEGUROS
						if(fl.producto_id.equals((long)16648) || fl.producto_id.equals((long)16580)) {// Producto: Contratacion de Seguro de Responsabilidad Civil Comprensiva ||  CONTRATACION DE SEGURO DE RESPONSABILIDAD CIVIL PROFESIONAL MEDICA INSTITUCIONAL (MALA PRAXIS)
							cuentaId = new Long(513);//4.2.2/02/17	Seg. Mala Praxis y Responsabilidad Civil
						}else if(fl.producto_id.equals((long)16579)) {//Contratacion de Seguro de Incendio de Edificio y contenido a Prorrata
							cuentaId = new Long(514);//4.2.2/02/18	Seg. Incendio
						}
					}



					/*
					 * "1";"EQUIPAMIENTOS"
						"2";"ESTUDIOS MEDICOS"
						"3";"INSUMOS VARIOS"
						"4";"MEDICAMENTOS"
						"5";"OTROS SERVICIOS"
						"6";"PROTESIS"
						"7";"SERVICIOS"
						"8";"HONORARIOS"
						"9";"REFACCIONES"
					RESIDUO PASIVO 2017	INSUMOS VARIOS
					RESIDUO PASIVO 2017	PROTESIS
					RESIDUO PASIVO 2018	MEDICAMENTOS
					RESIDUO PASIVO 2018	INSUMOS VARIOS
					RESIDUO PASIVO 2018	PROTESIS
					RESIDUO PASIVO 2018	ESTUDIOS MEDICOS
					RESIDUO PASIVO 2018	EQUIPAMIENTOS
					RESIDUO PASIVO 2018	SERVICIOS
					RESIDUO PASIVO 2018	OTROS SERVICIOS
					RESIDUO PASIVO 2018	HONORARIOS
					RESIDUO PASIVO 2018	REFACCIONES

					 */

//**************************************NUEVOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*********************************************

					cuentaId = getCuentaTransferencia(fl.factura.orden.deposito_id);

					//HONORARIOS-------------------------------------------------------
					if(fl.factura.orden.orden_rubro_id.equals((long)8)) {//HONORARIOS
						cuentaId = new Long(489);//4.2.1/02/04 Honorarios Profesionales
						ISHONORARIO = true;
					}

					//MEDICAMENTOS-------------------------------------------------------
					if(fl.factura.orden.orden_rubro_id.equals((long)4)) {//MEDICAMENTOS
						if(fl.factura.orden.deposito_id.equals((long)1) ||
								fl.factura.orden.deposito_id.equals((long)32) ||
								fl.factura.orden.deposito_id.equals((long)2) ) {//1	"HOSPITAL ESCUELA DE AGUDOS" LACMI o FATIMA
							cuentaId = new Long(552);
						}else {

							cuentaId = getCuentaTransferencia(fl.factura.orden.deposito_id);
						}
					}

					//EQUIPOS-------------------------------------------------------
					/*HOSPITAL ESCUELA DE AGUDOSX
					INSTITUTO DE GENETICA HUMANAX
					LACMIX
					HOSPITAL FATIMAX

					INSTITUTO MISIONERO DEL CANCER
					HOSPITAL FAVALORO
					UNIDAD DE TRASLADO
					HOSPITAL PEDIATRICO
					LEMIS
					HOSPITAL MATERNO NEONATAL
					HOSPITAL SAMIC DE OBERA
					BANCO DE SANGRE
					EL RESTO*/


					if(cuenta_analitica_original_id.equals((long)667)) {//OTROS EQUIPOS (FATIMA)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)460)) {//OTROS EQUIPOS (IGH)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)626)) {//OTROS EQUIPOS (LACMI)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)564)) {//OTROS EQUIPOS (PTM)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)786)) {//OTROS EQUIPOS(PLAN SUMAR FATIMA)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)780)) {//OTROS EQUIPOS(PLAN SUMAR LACMI)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)586)) {//OTROS EQUIPOS(PLAN SUMAR)
						cuentaId = new Long(352);//	bienes de uso
					}

					if(cuenta_analitica_original_id.equals((long)111)) {//OTROS EQUIPOS
						if(isParque(fl.factura.orden.deposito_id)) {
							cuentaId = new Long(352);//	bienes de uso
						}else {
							cuentaId = new Long(521);//	bienes de uso
						}

					}

					///04 04-3-10-1-01-012-01220 (PTM) || 04 04-3-10-1-01-012-01210 (PTM)
					if(cuenta_analitica_reporta_id.equals((long)517) || cuenta_analitica_reporta_id.equals((long)255)) {//
						cuentaId = new Long(525);//	4.2.2.02.29 Transferencias a Transplante de Medula
					}

					//LIMPIEZA Pindoi
					if(idProveedor.equals(1592)) {//Proveedor: Constructora Pindoi S.R.L./

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.06 Servicio Limpieza
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(502);
						}

						//INSTITUTO MISIONERO DEL CANCER	4.2.2.05.02 Servicio Limpieza IMC
						if(fl.factura.orden.deposito_id.equals((long)34)) {
							cuentaId = new Long(576);
						}

						//HOSPITAL FAVALORO	4.2.2.02.27 Transferencias a otras Instituciones
						if(fl.factura.orden.deposito_id.equals((long)21)) {
							cuentaId = new Long(521);
						}

						//HOSPITAL PEDIATRICO	4.2.2.07.02 Servicio Limpieza Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(581);
						}

						//HOSPITAL FATIMA	4.2.2.06.02 Servicio Limpieza Fatima
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(577);
						}

						//"2";"HOSPITAL MATERNO NEONATAL" 4.2.2.08.02 Servicio Limpieza Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(582);
						}

						//BANCO DE SANGRE	4.2.2.02.27 Transferencia Bco Sangre
						if(fl.factura.orden.deposito_id.equals((long)30)) {
							cuentaId = new Long(523);
						}

						//"27";"UNIDAD DE TRASLADO" 4.2.2.02.37 Servicio Limpieza Ud Traslado
						if(fl.factura.orden.deposito_id.equals((long)27)) {
							cuentaId = new Long(557);
						}
					}

					//NR CONSTRUCCIONES S.A.
					if(idProveedor.equals(1589)) {//NR CONSTRUCCIONES S.A.

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.02 Serv. Mantenimiento Edilicio
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(498);
						}

						//INSTITUTO MISIONERO DEL CANCER 4.2.2.05.03 Serv. Mantenimiento Edilicio IMC
						if(fl.factura.orden.deposito_id.equals((long)34)) {
							cuentaId = new Long(584);
						}

						//HOSPITAL FATIMA	4.2.2.06.03 Serv. Mantenimiento Edilicio Fatima
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(585);
						}


						//HOSPITAL PEDIATRICO 4.2.2.07.03 Serv. Mantenimiento Edilicio Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(586);
						}

						//"2";"HOSPITAL MATERNO NEONATAL" 	4.2.2.08.03 Serv. Mantenimiento Edilicio Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(587);
						}

						//"2";"LACMI	4.2.2.09.02 Serv. Mantenimiento Edilicio LACMI
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(588);
						}
					}

					//SAIDMAN RICARDO DANIEL
					if(idProveedor.equals(1587)) {//SAIDMAN RICARDO DANIEL

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.14 Mantenimiento y Reparacion de Equipos
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(510);
						}

						//HOSPITAL MATERNO NEONATAL	4.2.2.08.01 Transferencia a Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(583);
						}

						//HOSPITAL PEDIATRICO	4.2.2.07.01 Transferencia a Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(580);
						}

						//"2";"LEMIS	4.2.2.02.39 Transferencias a LEMIS
						if(fl.factura.orden.deposito_id.equals((long)29)) {
							cuentaId = new Long(559);
						}

						//MSP	4.2.2.02.25 Transferencias a otras Instituciones
						if(fl.factura.orden.deposito_id.equals((long)31)) {
							cuentaId = new Long(521);
						}
					}

					//PRAXAIR ARGENTINA S.R.L.
					if(idProveedor.equals(1852)) {//PRAXAIR ARGENTINA S.R.L.

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.01 Proveedores de Servicios
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(497);
						}

						//HOSPITAL MATERNO NEONATAL	4.2.2.08.01 Transferencia a Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(583);
						}

						//HOSPITAL PEDIATRICO	4.2.2.07.01 Transferencia a Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(580);
						}

						//HOSPITAL FATIMA	4.2.2.06.01 Transferencia a Fatima
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(579);
						}

						//HOSPITAL SAMIC DE OBERA	4.2.2.02.40 Transferencias a SAMIC Obera
						if(fl.factura.orden.deposito_id.equals((long)4)) {
							cuentaId = new Long(560);
						}
					}

					//COMPAÑIA MISIONERA DE SEGURIDAD S.R.L.
					if(idProveedor.equals(1588)) {//COMPAÑIA MISIONERA DE SEGURIDAD S.R.L.

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.08 Servicio Vigilancia
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(504);
						}

						//HOSPITAL MATERNO NEONATAL	4.2.2.08.05 Servicio Vigilancia Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(598);
						}

						//HOSPITAL FATIMA	4.2.2.06.05 Servicio Vigilancia Fatima
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(597);
						}

						//BANCO DE SANGRE	4.2.2.02.27 Transferencias a Banco de Sangre
						if(fl.factura.orden.deposito_id.equals((long)30)) {
							cuentaId = new Long(523);
						}

						//LACMI	4.2.2.09.04 Servicio Vigilancia LACMI
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(599);
						}
					}

					//JEFATURA DE POLICIA DE MISIONES
					if(idProveedor.equals(1591)) {//JEFATURA DE POLICIA DE MISIONES

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	   4.2.2.02.09 Servicios Seguridad Policial
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(505);
						}

						//INSTITUTO MISIONERO DEL CANCER	   4.2.2.05.04 Servicios Seguridad Policial IMC
						if(fl.factura.orden.deposito_id.equals((long)34)) {
							cuentaId = new Long(591);
						}

						//HOSPITAL FATIMA	   4.2.2.06.04 Servicios Seguridad Policial Fatima
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(592);
						}

						//HOSPITAL PEDIATRICO	   4.2.2.07.04 Servicios Seguridad Policial Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(593);
						}

						//HOSPITAL MATERNO NEONATAL	   4.2.2.08.04 Servicios Seguridad Policial Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(590);
						}

						//LACMI	   4.2.2.09.03 Servicios Seguridad Policial LACMI
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(594);
						}
					}

					//LAVICENTRO S.R.L.
					if(idProveedor.equals(17344)) {//LAVICENTRO S.R.L.

						cuentaId = new Long(546);//EL RESTO	00000 - SIN CUENTA ASIGNADA

						//HOSPITAL ESCUELA DE AGUDOS	4.2.2.02.05 Servicio de Lavado de Ropas
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(501);
						}
						//HOSPITAL PEDIATRICO	4.2.2.07.01 Transferencia a Pediatrico
						if(fl.factura.orden.deposito_id.equals((long)25)) {
							cuentaId = new Long(580);
						}

						//HOSPITAL FATIMA	4.2.2.06.01 Transferencia a Fatima 
						if(fl.factura.orden.deposito_id.equals((long)32)) {
							cuentaId = new Long(579);
						}

						//HOSPITAL MATERNO NEONATAL	4.2.2.08.01 Transferencia a Materno
						if(fl.factura.orden.deposito_id.equals((long)2)) {
							cuentaId = new Long(583);
						}
					}


					//BISIONES S.R.L.
					if(idProveedor.equals(14733)) {//BISIONES S.R.L.
						if(fl.factura.orden.orden_rubro_id.equals((long)7)) {
							if(fl.factura.orden.deposito_id.equals((long)1)) {
								cuentaId = new Long(509);
							}
						}
					}

					//BIO ANALITICA ARGENTINA SOCIEDAD ANONIMA
					if(idProveedor.equals(13733)) {//BIO ANALITICA ARGENTINA SOCIEDAD ANONIMA
						if(fl.factura.orden.deposito_id.equals((long)1)) {
							cuentaId = new Long(510);
						}
					}

					//Multimedios SAPEM
					if(idProveedor.equals(1585)) {//Multimedios SAPEM
						cuentaId = new Long(507);
					}

					//SAFITA S.R.L.
					if(idProveedor.equals(2713)) {//SAFITA S.R.L.

						if(fl.factura.orden.orden_subrubro_id != null && fl.factura.orden.orden_subrubro_id.equals((long)548)) {//VIANDAS
							if(fl.factura.orden.deposito_id.equals((long)1)) {
								cuentaId = new Long(508);
							}
						}

						if(fl.factura.orden.orden_subrubro_id != null && fl.factura.orden.orden_subrubro_id.equals((long)520)) {//LAVADO
							if(fl.factura.orden.deposito_id.equals((long)1)) {
								cuentaId = new Long(501);
							}
						}

					}

					//MAVICSIL SRL
					if(idProveedor.equals(15269)) {//MAVICSIL SRL
						cuentaId = new Long(498);
					}
					//AT.ME.DO. S.R.L
					if(idProveedor.equals(2176)) {//AT.ME.DO. S.R.L
						cuentaId = new Long(497);
					}

					if(fl.factura.orden.orden_subrubro_id != null && fl.factura.orden.orden_subrubro_id.equals((long)553)) {
						cuentaId = new Long(515);
						ISHONORARIO = false;
						SUELDOSCONVENIO= false;
						SUELDOSPARQUE = false;
						PASANTIAS = true;
					}



					if(!montoPorCuenta.containsKey(cuentaId)) {
						montoPorCuenta.put(cuentaId, fl.getTotal());
					}else {
						BigDecimal montoTmp = montoPorCuenta.get(cuentaId);
						montoTmp = montoTmp.add(fl.getTotal());
						montoPorCuenta.put(cuentaId, montoTmp);
					}
				}


				Balance b = new Balance();
				b.fecha = f.fecha_orden_pago;
				b.fecha_debito = f.fecha_orden_pago;
				b.haber= f.base;
				b.expediente_id = f.expediente_id;
				b.orden_pago_id = f.orden_pago_id;
				b.debe = BigDecimal.ZERO;
				b.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());

				//HABERRRRRRR
				Integer ci = null;

				if(cuentaId.equals((long)516)) { //4.2.2/02/20 Aportes y Contribuciones
					ci = new Integer(440);
				}else if(cuentaId.equals((long)517) ) {//4.2.2/02/21 Seguro Sepelio
					ci = new Integer(445);
				}else if(cuentaId.equals((long)518)) {//4.2.2/02/22 Seguro Vida
					ci = new Integer(444);
				}else if(IMPUESTO_GANANCIAS) {	//2.1.4/02/07 AFIP- Retención Ganancias Art 79
					ci = new Integer(440);
				}else if(PRESTAFACIL) {
					ci = new Integer(448);
				}else {
					if(ISHONORARIO) {
						ci = 415;//	2.1.1.01.03 Honorarios a Pagar
					}else if(SUELDOSCONVENIO){
						ci = 437;//2.1.4.01.01 Sueldos a Pagar Convenio
					}else if(SUELDOSPARQUE){
						ci = 438;//2.1.4.01.02 Sueldos a Pagar Parque
					}else if(PASANTIAS) {
						ci = new Integer(600);//2.1.4.01.03 Pasantias
					} else {
						ci =  (f.tipo_cuenta_id.compareTo(new Long(2)) == 0)?414:413;
					}
				}










				b.estado_id = (long) Estado.BALANCE_BORRADOR;
				b.cuenta_id = ci;
				b.tipo = "facturas";
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.asiento = asiento;
				b.orden_id = f.orden_id;
				b.marca = true;
				b.factura_id= f.id.intValue();
				b.save();

				BalanceExpediente be = new BalanceExpediente();
				be.balance_id = b.id;
				be.expediente_id= f.expediente_id.longValue();
				be.save();

				BalanceOrdenPago bo = new BalanceOrdenPago();
				bo.balance_id = b.id;
				bo.orden_pago_id = f.orden_pago_id;
				bo.save();




				for (Map.Entry<Long,BigDecimal> entry : montoPorCuenta.entrySet()) {

					Long key = entry.getKey();
					BigDecimal value = entry.getValue();
					//DEBEEEEEEEEE
					Balance bx = new Balance();
					bx.fecha = f.fecha_orden_pago;
					bx.fecha_debito = f.fecha_orden_pago;
					bx.haber= BigDecimal.ZERO;
					bx.debe = value;
					bx.expediente_id = f.expediente_id;
					bx.orden_pago_id = f.orden_pago_id;
					bx.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());
					bx.cuenta_id = key.intValue();
					bx.tipo = "facturas";
					bx.asiento = asiento;
					bx.create_date = new Date();
					bx.estado_id = (long) Estado.BALANCE_BORRADOR;
					bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					bx.orden_id = f.orden_id;
					bx.marca = true;
					bx.factura_id= f.id.intValue();
					bx.save();

					BalanceExpediente bex = new BalanceExpediente();
					bex.balance_id = bx.id;
					bex.expediente_id= f.expediente_id.longValue();
					bex.save();

					BalanceOrdenPago box = new BalanceOrdenPago();
					box.balance_id = bx.id;
					box.orden_pago_id = f.orden_pago_id;
					box.save();
				}
				asiento = asiento+1;




			}
			}
			/*
1	"HOSPITAL ESCUELA DE AGUDOS"
2	"HOSPITAL MATERNO NEONATAL"
3	"LACMI"
4	"HOSPITAL SAMIC DE OBERA"
5	"ZONA DE SALUD SUR"
7	"ZONA CAPITAL"
8	"HOSPITAL SAMIC ELDORADO"
9	"CAPS NRO 23"
10	"ZONA DE SALUD NORESTE"
11	"ZONA CENTRO PARANA"
12	"ZONA NORTE PARANA"
13	"ZONA CENTRO URUGUAY"
14	"HOSPITAL SAMIC DE ALEM"
21	"HOSPITAL FAVALORO"
25	"HOSPITAL PEDIATRICO"
27	"UNIDAD DE TRASLADO"
28	"CEMIS"
29	"LEMIS"
30	"BANCO DE SANGRE"
31	"MINISTERIO DE SALUD PUBLICA"
32	"HOSPITAL FATIMA"
33	"BANCO DE PROTESIS"
34	"INSTITUTO MISIONERO DEL CANCER"
35	"INSTITUTO DE GENETICA HUMANA"
36	"VICEGOBERNACION"
37	"FAPS MADARIAGA"
38	"HOSPITAL DE CAMPO GRANDE"
39	"CAPS NRO 17"
40	"CIC LEANDRO N ALEM "
41	"HOSPITAL BALIÑA"
42	"HOSPITAL SAMIC DE IGUAZU"
43	"LABORATORIO DE ATENCION PRIMARIA DE LA SALUD (LAPS)"
44	"TUBERCULOSIS"
45	"CONTADURIA GENERAL DE LA PROVINCIA"
46	"GOBERNACION"
47	"HOSPITAL DR. RAMON CARRILLO"
48	"HOSPITAL MONOCLINICO DE GERIATRIA"
49	"CAPS N° 23 NUEVA ESPERANZA"
50	"CAPS N° 32 ITAEBE MINI"
51	"CAPS N° 33 SAN ISIDRO"
52	"HOSPITAL DE CANDELARIA"
53	"HOSPITAL DE CORPUS"
54	"HOSPITAL DE PUERTO RICO"
55	"HOSPITAL DE CAPIOVI"
56	"HOSPITAL DE MONTECARLO"
57	"HOSPITAL RAMON GARDES"
61	"HOSPITAL JARDIN AMERICA"
62	"CENTRO MONOCLINICO MANANTIAL"
63	"HOGAR DE DIA POSADAS"
64	"HOSPITAL SAN VICENTE"
65	"FUND. HOGARES GUILLERMO HAYES"
66	"CENTRO DE INFORMACION PARQUE DE LA SALUD"
67	"CONV. PROGR. BARRIOS ACTIVOS"
68	"MINISTERIO DE PREVENCION DE ADICCIONES Y CONTROL DE DROGAS"
69	"MINISTERIO DE EDUCACION"
100	"JARDIN MATERNAL EVITA"
			 * */
			/*List<LiquidacionMes> lim = LiquidacionMes.find.where()
					    .ge("fecha_orden_pago", fd)
					   .le("fecha_orden_pago", fh)
					   .eq("id", 52641)
					   .findList();
			for(LiquidacionMes limx:lim) {

			}*/
			System.out.println("22222222222");


		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance");

		return true;
	}

	public static Long getCuentaTransferencia(Long idInstitucion) {
		Long ret= new Long(521); //4.2.2.02.25 Transferencias a otras Instituciones

		//IMC 4.2.2.05.01 Transferencia a IMC
		if(idInstitucion.equals((long)34)) {// IMC
			ret = new Long(575);
		}
		//HOSPITAL FATIMA 4.2.2.06.01 Transferencia a Fatima
		if(idInstitucion.equals((long)32)) {
			ret = new Long(579);
		}

		//HOSPITAL PEDIATRICO 4.2.2.07.01 Transferencia a Pediatrico
		if(idInstitucion.equals((long)25)) {
			ret = new Long(580);
		}

		//"2";"HOSPITAL MATERNO NEONATAL" 4.2.2.08.01 Transferencia a Materno
		if(idInstitucion.equals((long)2)) {
			ret = new Long(583);
		}

		//"2";"LACMI 4.2.2.09.01 Transferencia a LACMI
		if(idInstitucion.equals((long)2)) {
			ret = new Long(595);
		}

		//30	"BANCO DE SANGRE" 	4.2.2.02.27 Transferencias a Banco de Sangre
		if(idInstitucion.equals((long)30)) {
			ret = new Long(523);
		}

		// 4.2.2.02.28 Transferencias a Diabeticos
		/*if(idInstitucion.equals((long))) {
			ret = new Long();
		}   */

		// 4.2.2.02.29 Transferencias a Transplante de Medula
		/*if(idInstitucion.equals((long))) {
			ret = new Long();
		}    */

		//35	"INSTITUTO DE GENETICA HUMANA" 4.2.2.02.30 Transferencias a Genetica
		if(idInstitucion.equals((long)35)) {
			ret = new Long(526);
		}

		//	4.2.2.02.36 Transferencias a Inst. Medicina Regenerativa   
		/*if(idInstitucion.equals((long))) {
			ret = new Long();
		}  */

		//27	"UNIDAD DE TRASLADO 4.2.2.02.37 Transferencias a Unidad Central de Traslado
		if(idInstitucion.equals((long)27)) {
			ret = new Long(557);
		}

		//4.2.2.02.38 Transferencias a Hospital Esc. Odontología
		/*if(idInstitucion.equals((long))) {
			ret = new Long();
		}  */

		//29	"LEMIS" 4.2.2.02.39 Transferencias a LEMIS
		if(idInstitucion.equals((long)29)) {
			ret = new Long(559);
		}

		//4	"HOSPITAL SAMIC DE OBERA" 4.2.2.02.40 Transferencias a SAMIC Obera
		if(idInstitucion.equals((long)4)) {
			ret = new Long(560);
		}

		return ret;
	}

	public static boolean isParque(Long id) {
		boolean ret = false;

		if(id.equals((long)1)) {//HOSPITAL ESCUELA DE AGUDOS
			ret= true;
		}else if(id.equals((long)34)) {//INSTITUTO MISIONERO DEL CANCER
			ret= true;
		}else if(id.equals((long)35)) {//INSTITUTO DE GENETICA HUMANA
			ret= true;
		}else if(id.equals((long)3)) {//LACMI
			ret= true;
		}else if(id.equals((long)21)) {//HOSPITAL FAVALORO
			ret= true;
		}else if(id.equals((long)27)) {//UNIDAD DE TRASLADO
			ret= true;
		}else if(id.equals((long)25)) {//HOSPITAL PEDIATRICO
			ret= true;
		}else if(id.equals((long)32)) {//HOSPITAL FATIMA
			ret= true;
		}else if(id.equals((long)29)) {//LEMIS
			ret= true;
		}else if(id.equals((long)2)) {//HOSPITAL MATERNO NEONATAL
			ret= true;
		}else if(id.equals((long)4)) {//HOSPITAL SAMIC DE OBERA
			ret= true;
		}else if(id.equals((long)30)) {//BANCO DE SANGRE
			ret= true;
		}
		return ret ;
	}

	public static boolean xxx2(){
		Connection conn2 = null;


		try {

			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();

			int asiento = 0;

			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}


			Date fd = DateUtils.formatDate("01/01/2020", "dd/MM/yyyy");
			List<Balance> d =Balance.find.where()
			.ge("fecha", fd)
			.eq("cuenta_propia_id",2)
			.eq("tipo","facturas").orderBy("id asc").findList();

			int i =0;
			for(Balance f:d) {

				if(i == 0 || i%2==0) {
					asiento++;
				}

				f.asiento= asiento;
				f.save();

				i++;

				System.out.println(" --- "+f.id);
			}

		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance");

		return true;
	}

	public static Integer getCuentaPropiaId(Integer tipo_cuenta_id) {
		int r = 2;
		/*
		<select id="cuenta_propia_id" name="cuenta_propia_id" class="form-control select">
                <option value="1">PROFE</option>
                <option value="2" selected="">OPERATIVA</option>
                <option value="7">CTA. CTE. PROGRAMA SUMAR HEARM</option>
                <option value="3">FONDOS PROVINCIALES</option>
                <option value="4">FONDOS VARIOS</option>
                <option value="5">FONDOS PROFE</option>
                <option value="6">FONDOS SOLIDARIO DE SALUD</option>
                <option value="9">PROGRAMA SUMAR FATIMA</option>
                <option value="8">PROGRAMA SUMAR LACMI </option>
                <option value="11">FONDO PERMANENTE MATERNO</option>
                <option value="12">FONDO PERMANENTE OBERA</option>
                <option value="10">PROGRAMA PLAN SUMAR MATERNO</option>
            	<option value="13">PROGRAMA SUMAR OBERA</option>

        </select>*/

		/*
"1";"PROFE"
"2";"OPERATIVA"
"3";"FONDOS PROVINCIALES"
"4";"FONDOS VARIOS"
"5";"FONDOS PROFE"
"6";"FONDOS SOLIDARIO DE SALUD"
"7";"CTA. CTE. PROGRAMA SUMAR HEARM"
"8";"PROGRAMA SUMAR LACMI "
"9";"PROGRAMA SUMAR FATIMA"
"10";"PROGRAMA PLAN SUMAR MATERNO"
"11";"FONDO PERMANENTE MATERNO"
"12";"FONDO PERMANENTE OBERA"
"13";"PROGRAMA SUMAR OBERA"

TIPOS DE CUENTAS
1	"OPERATIVA"
2	"PROFE"
3	"PLAN SUMAR HEARM"
4	"PLAN SUMAR LACMI"
5	"PLAN SUMAR FATIMA"
6	"PLAN SUMAR MATERNO"
7	"FONDO PERMANENTE MATERNO"
8	"FONDO PERMANENTE OBERA"
9	"PLAN SUMAR OBERA"

		*/
		switch (tipo_cuenta_id) {
			case 1:
				 r = 2;
				break;
			case 2:
				 r = 1;
				break;
			case 3:
				r = 7;
				break;
			case 4:
				r = 8;
				break;
			case 5:
				r = 9;
				break;
			case 6:
				r = 10;
				break;
			case 7:
				r = 11;
				break;
			case 8:
				r = 12;
				break;
			case 9:
				r = 13;
			default:
				break;
		}
		return r;

	}


	public static boolean arregloFacturas(){

		System.out.println("Empezo a ActualizarBalance");
		Connection conn2 = null;

		try {

			Date fd = DateUtils.formatDate("01/01/2022", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/12/2022", "dd/MM/yyyy");




			List<Factura> lf = Factura.find.where().ge("fecha_orden_pago", fd)
													.le("fecha_orden_pago", fh)
													.eq("state_id", Estado.FACTURA_ESTADO_APROBADO)
													//.eq("expediente_id", 31492)
													//.in("expediente_id", idsExpLiq)
												   //.not(Expr.in("expediente_id",idsExpLiq))
													//.eq("id", 66556)
												   //.eq("orden_pago_id",29783)
													.findList();

			System.out.println("-------------- "+lf.size());

			String xx= "";
			String xx2= "";

			for(Factura f:lf) {

				List<Balance> bb = Balance.find.where().eq("fecha", f.fecha_orden_pago)
				 					.eq("haber", f.base)
				 					.eq("expediente_id", f.expediente_id)
				 					.eq("orden_pago_id", f.orden_pago_id)
				 					.eq("debe", BigDecimal.ZERO)
				 					.eq("tipo", "facturas")
				 					.eq("orden_id", f.orden_id).findList();


				 if(bb.size() == 0) {
					 xx+= " - "+f.id;

				 }else  if(bb.size() > 1) {
					 xx2+= " - "+f.orden_pago_id;
				 }


				/*Balance b = new Balance();
				b.fecha = f.fecha_orden_pago;
				b.fecha_debito = f.fecha_orden_pago;
				b.haber= f.base;
				b.expediente_id = f.expediente_id;
				b.orden_pago_id = f.orden_pago_id;
				b.debe = BigDecimal.ZERO;
				b.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());
				//HABERRRRRRR
				Integer ci = null;
				b.estado_id = (long) Estado.BALANCE_BORRADOR;
				b.cuenta_id = ci;
				b.tipo = "facturas";
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.asiento = 1;
				b.orden_id = f.orden_id;
				b.save();

				BalanceExpediente be = new BalanceExpediente();
				be.balance_id = b.id;
				be.expediente_id= f.expediente_id.longValue();
				be.save();

				BalanceOrdenPago bo = new BalanceOrdenPago();
				bo.balance_id = b.id;
				bo.orden_pago_id = f.orden_pago_id;
				bo.save();
				*/





			}
			System.out.println("facturas: "+ xx);
			System.out.println("op mas de 2: "+ xx2);
			System.out.println("22222222222");


		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {



        }

		System.out.println("Termino a ActualizarBalance");

		return true;
	}


}
