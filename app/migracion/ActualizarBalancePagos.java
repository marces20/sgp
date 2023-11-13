package migracion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Expr;

import models.Balance;
import models.BalanceExpediente;
import models.BalanceOrdenPago;
import models.Estado;
import models.FacturaLinea;
import models.Pago;
import models.TipoCuenta;
import models.Usuario;
import models.haberes.LiquidacionMes;
import server.Configuracion2;
import utils.DateUtils;

public class ActualizarBalancePagos {

	public static boolean xxx(){
		System.out.println("Empezo a ActualizarBalance");
		Connection conn2 = null;
		try {

			Date fd = DateUtils.formatDate("01/06/2023", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("30/06/2023", "dd/MM/yyyy");
			System.out.println("Tffffffffffffffffffffffffffffffffffffff");
			List<Integer> idsExpLiq = new ArrayList<Integer>();
			idsExpLiq.add(34720);
			idsExpLiq.add(35055);
			idsExpLiq.add(36129);
			idsExpLiq.add(36130);
			idsExpLiq.add(36611);

			List<Pago> lf = Pago.find.where()	   .ge("fecha_pago", fd)
												   .le("fecha_pago", fh)
												   .eq("tipo", "payment")
												   //.in("expediente_id", idsExpLiq)
												   //.eq("expediente_id",37237)
												   //.eq("orden_pago_id",35787)
												   //.eq("tipo_cuenta_id", TipoCuenta.PLAN_SUMAR_LACMI)
												   .disjunction()
												   .eq("state_id", Estado.PAGO_ESTADO_PAGADO)
												   .eq("state_id", Estado.PAGO_ESTADO_CONCILIADO)
												   .endJunction()
												   .findList();

			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select max(asiento)+1 from balances ");
			ResultSet rs1 = stmt1.executeQuery();
			int asiento = 0;
			while (rs1.next()) {
				asiento = rs1.getInt(1);
			}

			List<Integer> idsfacturaCargadas = new ArrayList<Integer>();
			List<Long> idsPagosCargadas = new ArrayList<Long>();
			List<Long> listaOpSueldo = new ArrayList<Long>();
			List<Long> listaOpSueldoConvenio = new ArrayList<Long>();

			System.out.println("Tffffffffffffffffffffffffffffffffffffff "+lf.size());

			for(Pago f:lf) {// ACA VOY A TENER TODOS LOS PAGOS

				Integer tc = 413;
				Integer cuentaPagoBanco = null;
				if(f.tipo_cuenta_id.compareTo(TipoCuenta.PROFE) == 0) {
					tc = 414;
					cuentaPagoBanco = 289;
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.FONDO_PERMANENTE_MATERNO) == 0) {
					cuentaPagoBanco = 562; //111/02/13 Bco Macro C/C $ Nº 0942042260/7 Fondo Perm. Matern
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.FONDO_PERMANENTE_OBERA) == 0) {
						cuentaPagoBanco = 563; //Bco Macro C/C $ Nº 0942033812/6 Fondo Perm. Obera2
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.PLAN_SUMAR_FATIMA) == 0) {
					cuentaPagoBanco = 296; //1.1.1.02.09 Bco Macro C/C $ N 0941661279/1 Prog Sumar Fátima
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.PLAN_SUMAR_HEARM) == 0) {
					cuentaPagoBanco = 294; //1.1.1.02.07 Bco Macro C/C $ N 0941423613/9 Prog Sumar HEARM
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.PLAN_SUMAR_LACMI) == 0) {
					cuentaPagoBanco = 295; //1.1.1.02.08 Bco Macro C/C $ N 0941646917/7 Prog Sumar Lacmi
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.PLAN_SUMAR_MATERNO) == 0) {
					cuentaPagoBanco = 561; //111/02/12 Bco Macro C/C $ Nº 0942037597/4 Sumar Materno
				}else if(f.tipo_cuenta_id.compareTo(TipoCuenta.PLAN_SUMAR_OBERA) == 0) {
					cuentaPagoBanco = 564; //111/02/15 Bco Macro C/C $ Nº 0942035024/5 Sumar Obera
				}else {
					tc = 413;
					cuentaPagoBanco = 288;
				}

            /*
                <option value="4">PLAN SUMAR LACMI</option>
                <option value="3">PLAN SUMAR HEARM</option>
                <option value="1">OPERATIVA</option>
                <option value="2">PROFE</option>
                <option value="6">PLAN SUMAR MATERNO</option>
                <option value="5">PLAN SUMAR FATIMA</option>
                <option value="8">FONDO PERMANENTE OBERA</option>
                <option value="7">FONDO PERMANENTE MATERNO</option>
                <option value="9">PLAN SUMAR OBERA</option>*/


				boolean ISHONORARIONEW = false;

				if(!idsfacturaCargadas.contains(f.factura_id)) {
					boolean ISHONORARIO = false;
					boolean SUELDOSPARQUE = false;
					boolean SUELDOSCONVENIO = false;

					System.out.println("Tffffffffffffffffff222222222222222222 "+lf.size());

					List<FacturaLinea> fll = FacturaLinea.find.where().eq("factura_id", f.factura_id).findList();
					for(FacturaLinea fllx :fll) {

						if(fllx.cuenta_analitica_original_id.equals((long)178)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS
							if(fllx.factura.orden.orden_rubro_id.equals((long)8)) {//HONORARIOS
								ISHONORARIO = true;
							}
						}

						if(fllx.cuenta_analitica_original_id.equals((long)286)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (IMC)
							ISHONORARIO = true;
						}

						if(fllx.cuenta_analitica_original_id.equals((long)692)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (JME)
							ISHONORARIO = true;
						}

						if(fllx.cuenta_analitica_original_id.equals((long)609)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (LACMI)
							ISHONORARIO = true;
						}

						if(fllx.cuenta_analitica_original_id.equals((long)343)) {//HONORARIOS Y RETRIBUCIONES A TERCEROS (PTM)
							ISHONORARIO = true;
						}

						if(fllx.factura.orden.orden_subrubro_id != null && fllx.factura.orden.orden_subrubro_id.equals((long)553)) {//PASANTIAS
							tc = 600;//2.1.4.01.03 Pasantias
							ISHONORARIO = false;
							SUELDOSCONVENIO= false;
							SUELDOSPARQUE = false;
						}


						if(fllx.cuenta_analitica_original_id.equals((long)222)) {//ADICIONALES	HONORARIOS

							if(!listaOpSueldo.contains(f.orden_pago_id) && !listaOpSueldoConvenio.contains(f.orden_pago_id)) {
								List<LiquidacionMes> lm = LiquidacionMes.find.where().eq("orden_pago_id", f.orden_pago_id).findList();
								if(lm.size() > 0) {
									if(lm.get(0).convenio_ministerio) {
										SUELDOSCONVENIO = true;
									}else {
										SUELDOSPARQUE = true;
										listaOpSueldo.add(f.orden_pago_id);
									}
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

						if(SUELDOSPARQUE || SUELDOSCONVENIO) {
							if(fllx.producto_id.equals((long)40224)) {// 2.1.4.02.01 Aportes Reg. Nac. Seguridad Social
								tc = 440;// 2.1.4.02.01 Aportes Reg. Nac. Seguridad Socialx
								ISHONORARIONEW = true;
							}
							if(fllx.producto_id.equals((long)40337)) {// 2.1.4.02.03 Aportes Reg. Nac. Obra Social
								tc = 442;// 2.1.4.02.03 Aportes Reg. Nac. Obra Socialx
								ISHONORARIONEW = true;
							}
							if(fllx.factura.proveedor_id.equals(3172)){//NACIÓN SEGUROS

								if(fllx.producto_id.equals((long)42201) || fllx.producto_id.equals((long)36881)) {
									if(SUELDOSPARQUE) {
										tc = 445;//2.1.4.02.06 - Seguro Sepelio - x
										ISHONORARIONEW = true;
									}else if(SUELDOSCONVENIO) {
										tc = 445;//2.1.4.02.06 - Seguro Sepelio - x
										ISHONORARIONEW = true;
									}

								}else if(fllx.producto_id.equals((long)42202) || fllx.producto_id.equals((long)36882)) {
									if(SUELDOSPARQUE) {
										tc = 444;//2.1.4.02.05 - Seguro de vida -x
										ISHONORARIONEW = true;
									}else if(SUELDOSCONVENIO) {
										tc = 444;//2.1.4.02.05 - Seguro de vida -x
										ISHONORARIONEW = true;
									}

								}
							}
							if(fllx.factura.proveedor_id.equals(1366)){//AFIP
								if(fllx.producto_id.equals((long)52513)) {//IMPUESTO A LAS GANANCIAS (30100)
									tc = 446;//2.1.4.02.07 AFIP- Retención Ganancias Art 79x
									ISHONORARIONEW = true;
								}
							}
							if(fllx.factura.proveedor_id.equals(12770) ||  fllx.factura.proveedor_id.equals(16546) ||  fllx.factura.proveedor_id.equals(16564) ||  fllx.factura.proveedor_id.equals(15669)  ){// ORANGEDATA S.A. || GRUPO PRESTAFACIL S.A. || ASOCIACIÓN MUTUAL UNIÓN SOLIDARIA (AMUS) || IPRODHA
								tc = 448;//2.1.4.02.09 Convenio Prestafácilx
								ISHONORARIONEW = true;
							}
						}
					}


					Balance b = new Balance();//ACA CARGO EL TOTAL DE LA FACTURA
					b.fecha = f.fecha_pago;
					b.fecha_debito = f.fecha_pago;
					b.haber= BigDecimal.ZERO;
					b.expediente_id = f.expediente_id;
					b.orden_pago_id = f.orden_pago_id;
					b.debe = f.factura.getBase(); //f.total.subtract(f.total_credito);
					b.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());


					if(!ISHONORARIONEW){
						if(ISHONORARIO) {
							tc = 415;//	2.1.1.01.03 Honorarios a Pagar
						}else if(SUELDOSCONVENIO){
							tc = 437;//2.1.4.01.01 Sueldos a Pagar Convenio
						}else if(SUELDOSPARQUE){
							tc = 437;//2.1.4.01.02 Sueldos a Pagar Parque
						}
					}



					b.cuenta_id = tc;
					b.estado_id = (long) Estado.BALANCE_BORRADOR;
					b.asiento = asiento;
					b.tipo = "pagos";
					b.orden_id = f.factura.orden_id;
					b.create_date = new Date();
					b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					b.save();

					BalanceExpediente be = new BalanceExpediente();
					be.balance_id = b.id;
					be.expediente_id= f.expediente_id.longValue();
					be.save();

					BalanceOrdenPago bo = new BalanceOrdenPago();
					bo.balance_id = b.id;
					bo.orden_pago_id = f.orden_pago_id;
					bo.save();


					List<Pago> pagosPayments = Pago.find.where().eq("factura_id", f.factura_id)
																.eq("tipo", "payment")
																.disjunction()
															    .eq("state_id", Estado.PAGO_ESTADO_PAGADO)
															    .eq("state_id", Estado.PAGO_ESTADO_CONCILIADO)
															    .endJunction()
															    .findList();



					if((SUELDOSPARQUE || SUELDOSCONVENIO) && pagosPayments.size() > 1) {
						int x = 0;

						System.out.println("AAAAAAAAAAAAAAAAAAAAAA ");
						for(Pago pay:pagosPayments) {



							if(x == 0 ) {



							}else {
								b.debe = f.factura.getBase().subtract(pay.total.subtract(pay.total_credito));//DEBEEEEEEEEEEEEE
								b.save();

								///////////////////////////////////////////////////////////////////////
								Balance bx = new Balance();//DEBEEEEEEEEEEEEEEE
								bx.fecha = pay.fecha_pago;
								bx.fecha_debito = pay.fecha_pago;
								bx.haber= BigDecimal.ZERO;
								bx.expediente_id = f.expediente_id;
								bx.orden_pago_id = f.orden_pago_id;
								bx.debe = pay.total.subtract(pay.total_credito); //f.total.subtract(f.total_credito);
								bx.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());
								bx.cuenta_id = tc;
								bx.estado_id = (long) Estado.BALANCE_BORRADOR;
								bx.asiento = asiento;
								bx.tipo = "pagos";
								bx.orden_id = f.factura.orden_id;
								bx.create_date = new Date();
								bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
								bx.save();

								BalanceExpediente bex = new BalanceExpediente();
								bex.balance_id = bx.id;
								bex.expediente_id= f.expediente_id.longValue();
								bex.save();

								BalanceOrdenPago box = new BalanceOrdenPago();
								box.balance_id = bx.id;
								box.orden_pago_id = f.orden_pago_id;
								box.save();
								System.out.println("1111111111111111 "+pay.total.subtract(pay.total_credito));
								//////////////////////////////////////////////////////////////////////
							}


							Balance bx2 = new Balance();//HABEEEEEEEEEEEEER
							bx2.fecha = pay.fecha_pago;
							bx2.fecha_debito = pay.fecha_pago;
							bx2.haber= pay.total.subtract(pay.total_credito);
							bx2.expediente_id = pay.expediente_id;
							bx2.orden_pago_id = pay.orden_pago_id;
							bx2.debe = BigDecimal.ZERO;
							bx2.cuenta_propia_id = getCuentaPropiaId(pay.tipo_cuenta_id.intValue());
							bx2.cuenta_id = cuentaPagoBanco;
							bx2.estado_id = (long) Estado.BALANCE_BORRADOR;
							bx2.asiento = asiento;
							bx2.tipo = "pagos";
							bx2.orden_id = f.factura.orden_id;
							bx2.create_date = new Date();
							bx2.create_usuario_id = new Long(Usuario.getUsuarioSesion());
							bx2.save();
							System.out.println("222222222222222 "+pay.total.subtract(pay.total_credito));
							BalanceExpediente bex2 = new BalanceExpediente();
							bex2.balance_id = bx2.id;
							bex2.expediente_id= pay.expediente_id.longValue();
							bex2.save();

							BalanceOrdenPago box2 = new BalanceOrdenPago();
							box2.balance_id = bx2.id;
							box2.orden_pago_id = pay.orden_pago_id;
							box2.save();

							x++;
						}


						System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ ");



					}else {
						for(Pago pay:pagosPayments) {

							Balance bx = new Balance();//ACA HABER DEL PAGO PRINCIPAL
							bx.fecha = pay.fecha_pago;
							bx.fecha_debito = pay.fecha_pago;
							bx.haber= pay.total.subtract(pay.total_credito);
							bx.expediente_id = pay.expediente_id;
							bx.orden_pago_id = pay.orden_pago_id;
							bx.debe = BigDecimal.ZERO;;
							bx.cuenta_propia_id = getCuentaPropiaId(pay.tipo_cuenta_id.intValue());
							bx.cuenta_id = cuentaPagoBanco;
							bx.estado_id = (long) Estado.BALANCE_BORRADOR;
							bx.asiento = asiento;
							bx.tipo = "pagos";
							bx.orden_id = f.factura.orden_id;
							bx.create_date = new Date();
							bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
							bx.save();

							BalanceExpediente bex = new BalanceExpediente();
							bex.balance_id = bx.id;
							bex.expediente_id= pay.expediente_id.longValue();
							bex.save();

							BalanceOrdenPago box = new BalanceOrdenPago();
							box.balance_id = bx.id;
							box.orden_pago_id = pay.orden_pago_id;
							box.save();
						}
					}

				}
				idsfacturaCargadas.add(f.factura_id);
				////////////////////////////////////////////////////////////////////////////////////////////////////
				List<Pago> pagosImpuestos = Pago.find.where().eq("factura_id", f.factura_id)
						.eq("tipo", "impuestos")
						.ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
						//.not(Expr.in("id",idsPagosCargadas))
						/*.disjunction()
					    .eq("state_id", Estado.PAGO_ESTADO_PAGADO)
					    .eq("state_id", Estado.PAGO_ESTADO_CONCILIADO)
					    .endJunction()*/
					    .findList();

				for(Pago imp:pagosImpuestos) {

					Integer cuentaImpuesto = null;

					if(imp.cuenta_impuesto_id != null) {

						if(f.tipo_cuenta_id.compareTo(TipoCuenta.PROFE) == 0) {
							if(imp.cuenta_impuesto_id.compareTo(94) == 0) {
								cuentaImpuesto = 414;
							}else if(imp.cuenta_impuesto_id.compareTo(109) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(259) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(260) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(277) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(282) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(545) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(258) == 0) {
								cuentaImpuesto = 427;
							}else if(imp.cuenta_impuesto_id.compareTo(110) == 0) {
								cuentaImpuesto = 432;
							}else if(imp.cuenta_impuesto_id.compareTo(276) == 0) {
								cuentaImpuesto = 432;
							}else if(imp.cuenta_impuesto_id.compareTo(263) == 0) {
								cuentaImpuesto = 434;
							}else if(imp.cuenta_impuesto_id.compareTo(540) == 0) {
								cuentaImpuesto = 434;
							}else if(imp.cuenta_impuesto_id.compareTo(108) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(281) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(284) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(544) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(565) == 0) {
								cuentaImpuesto = 425;
							}

						}else {
							if(imp.cuenta_impuesto_id.compareTo(94) == 0) {
								cuentaImpuesto = 413;
							}else if(imp.cuenta_impuesto_id.compareTo(109) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(259) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(260) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(277) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(282) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(545) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(258) == 0) {
								cuentaImpuesto = 426;
							}else if(imp.cuenta_impuesto_id.compareTo(110) == 0) {
								cuentaImpuesto = 431;
							}else if(imp.cuenta_impuesto_id.compareTo(276) == 0) {
								cuentaImpuesto = 431;
							}else if(imp.cuenta_impuesto_id.compareTo(263) == 0) {
								cuentaImpuesto = 433;
							}else if(imp.cuenta_impuesto_id.compareTo(540) == 0) {
								cuentaImpuesto = 433;
							}else if(imp.cuenta_impuesto_id.compareTo(108) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(281) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(284) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(544) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(565) == 0) {
								cuentaImpuesto = 424;
							}
						}


					}else {

					}

					if(!idsPagosCargadas.contains(imp.id)) {
						Balance bx = new Balance();//ACA HABER DE LOS IMPUESTOS
						bx.fecha = f.fecha_pago;
						bx.fecha_debito = f.fecha_pago;
						bx.haber= imp.total.subtract(imp.total_credito);
						bx.expediente_id = imp.expediente_id;
						bx.orden_pago_id = imp.orden_pago_id;
						bx.debe = BigDecimal.ZERO;;
						bx.cuenta_propia_id = getCuentaPropiaId(imp.tipo_cuenta_id.intValue());
						bx.cuenta_id = cuentaImpuesto;
						bx.estado_id = (long) Estado.BALANCE_BORRADOR;
						bx.asiento = asiento;
						bx.tipo = "pagos";
						bx.orden_id = f.factura.orden_id;
						bx.create_date = new Date();
						bx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						bx.save();

						BalanceExpediente bex = new BalanceExpediente();
						bex.balance_id = bx.id;
						bex.expediente_id= imp.expediente_id.longValue();
						bex.save();

						BalanceOrdenPago box = new BalanceOrdenPago();
						box.balance_id = bx.id;
						box.orden_pago_id = imp.orden_pago_id;
						box.save();
					}
					System.out.println("/*****************************************/"+asiento);

						idsPagosCargadas.add(imp.id);

				}
				asiento = asiento+1;
				for(Pago imp:pagosImpuestos) {

					Integer cuentaImpuesto = null;

					if(imp.cuenta_impuesto_id != null) {

						if(f.tipo_cuenta_id.compareTo(TipoCuenta.PROFE) == 0) {
							if(imp.cuenta_impuesto_id.compareTo(94) == 0) {
								cuentaImpuesto = 414;
							}else if(imp.cuenta_impuesto_id.compareTo(109) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(259) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(260) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(277) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(282) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(545) == 0) {
								cuentaImpuesto = 429;
							}else if(imp.cuenta_impuesto_id.compareTo(258) == 0) {
								cuentaImpuesto = 427;
							}else if(imp.cuenta_impuesto_id.compareTo(110) == 0) {
								cuentaImpuesto = 432;
							}else if(imp.cuenta_impuesto_id.compareTo(276) == 0) {
								cuentaImpuesto = 432;
							}else if(imp.cuenta_impuesto_id.compareTo(263) == 0) {
								cuentaImpuesto = 434;
							}else if(imp.cuenta_impuesto_id.compareTo(540) == 0) {
								cuentaImpuesto = 434;
							}else if(imp.cuenta_impuesto_id.compareTo(108) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(281) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(284) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(544) == 0) {
								cuentaImpuesto = 425;
							}else if(imp.cuenta_impuesto_id.compareTo(565) == 0) {
								cuentaImpuesto = 425;
							}

						}else {
							if(imp.cuenta_impuesto_id.compareTo(94) == 0) {
								cuentaImpuesto = 413;
							}else if(imp.cuenta_impuesto_id.compareTo(109) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(259) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(260) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(277) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(282) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(545) == 0) {
								cuentaImpuesto = 428;
							}else if(imp.cuenta_impuesto_id.compareTo(258) == 0) {
								cuentaImpuesto = 426;
							}else if(imp.cuenta_impuesto_id.compareTo(110) == 0) {
								cuentaImpuesto = 431;
							}else if(imp.cuenta_impuesto_id.compareTo(276) == 0) {
								cuentaImpuesto = 431;
							}else if(imp.cuenta_impuesto_id.compareTo(263) == 0) {
								cuentaImpuesto = 433;
							}else if(imp.cuenta_impuesto_id.compareTo(540) == 0) {
								cuentaImpuesto = 433;
							}else if(imp.cuenta_impuesto_id.compareTo(108) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(281) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(284) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(544) == 0) {
								cuentaImpuesto = 424;
							}else if(imp.cuenta_impuesto_id.compareTo(565) == 0) {
								cuentaImpuesto = 424;
							}
						}


					}else {

					}


					if(imp.estado_id.compareTo((long)Estado.PAGO_ESTADO_PAGADO) == 0 || imp.estado_id.compareTo((long)Estado.PAGO_ESTADO_CONCILIADO) == 0) {

						if(!idsPagosCargadas.contains(imp.id)) {
						Balance bxx = new Balance();
						bxx.fecha = imp.fecha_pago;
						bxx.fecha_debito =imp.fecha_pago;
						bxx.haber= BigDecimal.ZERO;
						bxx.expediente_id = imp.expediente_id;
						bxx.orden_pago_id = imp.orden_pago_id;
						bxx.debe = imp.total.subtract(imp.total_credito);
						bxx.cuenta_propia_id = getCuentaPropiaId(imp.tipo_cuenta_id.intValue());
						bxx.cuenta_id = cuentaImpuesto;
						bxx.estado_id = (long) Estado.BALANCE_BORRADOR;
						bxx.asiento = asiento;
						bxx.tipo = "pagos";
						bxx.orden_id = f.factura.orden_id;
						bxx.create_date = new Date();
						bxx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						bxx.save();

						BalanceExpediente bexx = new BalanceExpediente();
						bexx.balance_id = bxx.id;
						bexx.expediente_id= imp.expediente_id.longValue();
						bexx.save();

						BalanceOrdenPago boxx = new BalanceOrdenPago();
						boxx.balance_id = bxx.id;
						boxx.orden_pago_id = imp.orden_pago_id;
						boxx.save();

						Balance bxxx = new Balance();
						bxxx.fecha = imp.fecha_pago;
						bxxx.fecha_debito =imp.fecha_pago;
						bxxx.haber=imp.total.subtract(imp.total_credito);
						bxxx.expediente_id = imp.expediente_id;
						bxxx.orden_pago_id = imp.orden_pago_id;
						bxxx.debe =  BigDecimal.ZERO;
						bxxx.cuenta_propia_id = getCuentaPropiaId(imp.tipo_cuenta_id.intValue());
						bxxx.cuenta_id = cuentaPagoBanco;
						bxxx.estado_id = (long) Estado.BALANCE_BORRADOR;
						bxxx.asiento = asiento;
						bxxx.tipo = "pagos";
						bxxx.orden_id = f.factura.orden_id;
						bxxx.create_date = new Date();
						bxxx.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						bxxx.save();

						BalanceExpediente bexxx = new BalanceExpediente();
						bexxx.balance_id = bxxx.id;
						bexxx.expediente_id= imp.expediente_id.longValue();
						bexxx.save();

						BalanceOrdenPago boxxx = new BalanceOrdenPago();
						boxxx.balance_id = bxxx.id;
						boxxx.orden_pago_id = imp.orden_pago_id;
						boxxx.save();
						}
					}
					asiento = asiento+1;
				}



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
				r = 7;
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
}
