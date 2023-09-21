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

			Date fd = DateUtils.formatDate("01/01/2023", "dd/MM/yyyy");
			Date fh = DateUtils.formatDate("31/03/2023", "dd/MM/yyyy");

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
												   //.eq("expediente_id",27473)
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

			for(Pago f:lf) {// ACA VOY A TENER TODOS LOS PAGOS

				Integer tc = 413;
				Integer cuentaPagoBanco = null;
				if(f.tipo_cuenta_id.compareTo(TipoCuenta.PROFE) == 0) {
					tc = 414;
					cuentaPagoBanco = 289;
				}else {
					tc = 413;
					cuentaPagoBanco = 288;
				}

				if(!idsfacturaCargadas.contains(f.factura_id)) {
					boolean ISHONORARIO = false;
					boolean SUELDOSPARQUE = false;
					boolean SUELDOSCONVENIO = false;


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
					}


					Balance b = new Balance();//ACA CARGO EL TOTAL DE LA FACTURA
					b.fecha = f.fecha_pago;
					b.fecha_debito = f.fecha_pago;
					b.haber= BigDecimal.ZERO;
					b.expediente_id = f.expediente_id;
					b.orden_pago_id = f.orden_pago_id;
					b.debe = f.factura.getBase(); //f.total.subtract(f.total_credito);
					b.cuenta_propia_id = getCuentaPropiaId(f.tipo_cuenta_id.intValue());


					if(ISHONORARIO) {
						tc = 415;//	2.1.1.01.03 Honorarios a Pagar
					}else if(SUELDOSCONVENIO){
						tc = 437;//2.1.4.01.01 Sueldos a Pagar Convenio
					}else if(SUELDOSPARQUE){
						tc = 437;//2.1.4.01.02 Sueldos a Pagar Parque

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
