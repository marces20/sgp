
package views.html.presupuesto.balancePresupuestario

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object indexBalancePresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[BalancePresupuestario],DynamicForm,List[BalancePresupuestario],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[BalancePresupuestario], formBuscador: DynamicForm,lbp:List[BalancePresupuestario],idEjercicio:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var saldoTotal=new java.math.BigDecimal(0);var saldoDisponible=new java.math.BigDecimal(0);var preventivoTotal=new java.math.BigDecimal(0);var preventivoDisponible=new java.math.BigDecimal(0);var definitivoTotal=new java.math.BigDecimal(0);var definitivoDisponible=new java.math.BigDecimal(0);var obligaciónTotal=new java.math.BigDecimal(0);var obligaciónDisponible=new java.math.BigDecimal(0);var pago=new java.math.BigDecimal(0);var epreventivoTotal=new java.math.BigDecimal(0);var epreventivoDisponible=new java.math.BigDecimal(0);var edefinitivoTotal=new java.math.BigDecimal(0);var edefinitivoDisponible=new java.math.BigDecimal(0);var eobligaciónTotal=new java.math.BigDecimal(0);var eobligaciónDisponible=new java.math.BigDecimal(0);var epago=new java.math.BigDecimal(0);

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.142*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.presupuesto.mainPresupuesto("Balance presupuestario")/*5.66*/ {_display_(Seq[Any](format.raw/*5.68*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Balance presupuestario</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  
				  	
 				  	
				  	
				  	<li role="presentation"><a role="menuitem" id="accionReporteGeneralPorExpedientePorCuenta" 
				    tabindex="-1" 
				    href="#" data-url=""""),_display_(Seq[Any](/*26.29*/controllers/*26.40*/.presupuesto.routes.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente(1))),format.raw/*26.144*/("""">
				    Reporte General por Cuenta por Expedientes</a></li>
				  	
				  	<li role="presentation"><a role="menuitem" id="accionReporteGeneralPorExpedientePorCuentaResumido" 
				    tabindex="-1" 
				    href="#" data-url=""""),_display_(Seq[Any](/*31.29*/controllers/*31.40*/.presupuesto.routes.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente(2))),format.raw/*31.144*/("""">
				    Reporte General por Cuenta por Expedientes Resumido</a></li>
				  	 
				   	<!--  ---------------------------------------------------------------------------- -->
				   	<li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*37.16*/controllers/*37.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(13))),format.raw/*37.135*/("""">
				    Reporte 2022 Saldos en Preventivos</a></li>
				   	<li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(12))),format.raw/*41.135*/("""">
				    Reporte 2021 Saldos en Preventivos</a></li>
				   	<li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*45.16*/controllers/*45.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(9))),format.raw/*45.134*/("""">
				    Reporte 2020 Saldos en Preventivos</a></li>
				   	<li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(8))),format.raw/*49.134*/("""">
				    Reporte 2019 Saldos en Preventivos</a></li>
				  
				    <!-- <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*54.16*/controllers/*54.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(6))),format.raw/*54.134*/("""">
				    Reporte 2017 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*58.16*/controllers/*58.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(5))),format.raw/*58.134*/("""">
				    Reporte 2016 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*62.16*/controllers/*62.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(4))),format.raw/*62.134*/("""">
				    Reporte 2015 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*66.16*/controllers/*66.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(3))),format.raw/*66.134*/("""">
				    Reporte 2014 Saldos en Preventivos</a></li> -->
				    <li><a id="reporteBalancePorFecha" href="#" 
				    data-url=""""),_display_(Seq[Any](/*69.20*/controllers/*69.31*/.presupuesto.routes.BalancePresupuestarioReportesController.modalReporteBalancePorFecha())),format.raw/*69.120*/("""">Reporte por Fecha</a></li>
				  </ul>
				</div>
				
			</div>
		</div>
	</div>
	
	
	<div id="actions">

		
		<form action="" method="GET">

				
		<div class="row">		
			<div class="col-sm-4">
				<label for="cuenta" class="control-label">Cuenta Presupuestaria Padre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*88.7*/inputText(formBuscador("cuenta"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*88.92*/("""
					"""),_display_(Seq[Any](/*89.7*/inputText(formBuscador("cuenta_analitica_padre_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*89.109*/("""
					<span class="input-group-addon">
						<a href="#" 
						   id="searchCuentaAnalitica" 
						   class="searchModal"
						   data-title="Selección de cuenta analítica" 
						   data-url=""""),_display_(Seq[Any](/*95.21*/controllers/*95.32*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*95.94*/("""" 
						   data-height="650" 
						   data-width="700" 
						   data-listen="modal.seleccion.cuentaAnalitica.simple" 
						   data-label="#cuentaAnalitica" 
						   data-field="#cuentaAnalitica_id">
						   <i class="glyphicon glyphicon-search"></i>
						 </a>
					</span>
				</div>
			</div>
			<div class="col-sm-4">
				<label for="cuenta" class="control-label">Cuenta Presupuestaria Hija</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*109.7*/inputText(formBuscador("cuentaHija"), 'class -> "form-control", 'id -> "cuentaAnaliticaHija"))),format.raw/*109.100*/("""
					"""),_display_(Seq[Any](/*110.7*/inputText(formBuscador("cuenta_analitica_hija_id"), 'hidden -> "hidden", 'id -> "cuentaAnaliticaHija_id"))),format.raw/*110.112*/("""
					<span class="input-group-addon">
						<a href="#" 
						   id="searchCuentaAnalitica" 
						   class="searchModal"
						   data-title="Selección de cuenta analítica" 
						   data-url=""""),_display_(Seq[Any](/*116.21*/controllers/*116.32*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*116.94*/("""" 
						   data-height="650" 
						   data-width="700" 
						   data-listen="modal.seleccion.cuentaAnalitica.simple" 
						   data-label="#cuentaAnaliticaHija" 
						   data-field="#cuentaAnaliticaHija_id">
						   <i class="glyphicon glyphicon-search"></i>
						 </a>
					</span>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*130.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*130.112*/("""
						"""),_display_(Seq[Any](/*131.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*131.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*136.22*/controllers/*136.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*136.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>			
		 	<div class="col-sm-2">
				<label class="control-label">Ejercicio
				"""),_display_(Seq[Any](/*149.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select"))),format.raw/*150.37*/("""
				</label>
			</div>
		</div>		
		<div class="row">		
			<!-- <div class="col-sm-2">
				<label class="control-label"> 
					PROFE
					"""),_display_(Seq[Any](/*158.7*/select(formBuscador("profe"),options(""->"","true"->"SI","false"->"NO"), 'class -> "form-control select"))),format.raw/*158.112*/("""
				</label>
			</div>		 -->	
			<div class="col-sm-2">
					<label class="control-label"> 
						Tipo Cuenta
						"""),_display_(Seq[Any](/*164.8*/select(formBuscador("tipo_cuenta_id"), 
						TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*165.128*/("""
					</label>
				</div>
			<div class="col-sm-2">
				<label for="obpaciente" class="control-label">Obra Social Pac.</label>
				<div class="input-group"> 
					"""),_display_(Seq[Any](/*171.7*/inputText(formBuscador("obrasocial.nombre"),'class -> "form-control", 'id -> "obrasocial", 'autocomplete -> "off"))),format.raw/*171.121*/("""
					"""),_display_(Seq[Any](/*172.7*/inputText(formBuscador("obrasocial_id"),'hidden -> "hidden", 'id -> "obrasocial_id"))),format.raw/*172.91*/("""
					<span class="input-group-addon">
						<a href="#" id="searchObraSocial" 
						data-title="Selección de obra social" 
						data-url=""""),_display_(Seq[Any](/*176.18*/controllers/*176.29*/.compras.routes.ObrasSocialesController.modalBuscar())),format.raw/*176.82*/("""" 
						data-height="650" data-width="700" 
						data-listen="modal.seleccion.ob.simple" 
						data-label="#obrasocial" data-field="#obrasocial_id"><i class="glyphicon glyphicon-search"></i></a>
					</span>
				</div>
			</div>
		</div>	
		<div class="row">		
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*194.15*/controllers/*194.26*/.presupuesto.routes.BalancePresupuestarioController.index())),format.raw/*194.85*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*201.3*/if(buscador.getTotalRowCount == 0)/*201.37*/ {_display_(Seq[Any](format.raw/*201.39*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*207.7*/else/*207.12*/{_display_(Seq[Any](format.raw/*207.13*/("""
		
		<!-- Mostrando """),_display_(Seq[Any](/*209.19*/buscador/*209.27*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*209.59*/(""" resultado(s).  -->
		<table class="table table-bordered tablaPresupuesto">
			<thead>
				<tr>
					<th width="30" >Cuenta</th>
					<th width="30" colspan="2">Saldo</th>
					<th width="30" colspan="2">Preventivo</th>
					<th width="30" colspan="2">Definitivo</th>
					<th width="30" colspan="2">Obligación</th>
					<th width="30" colspan="2">Pago</th>
				</tr>
				<tr>
					<th></th>
					<th>Total</th>
					<th>Disponible</th>
					<th>Total</th>
					<th>Disponible</th>
					<th>Total</th>
					<th>Disponible</th>
					<th>Total</th>
					<th>Disponible</th>
					<th colspan="2">Total</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*234.5*/for(presupuesto <- buscador.getList) yield /*234.41*/ {_display_(Seq[Any](format.raw/*234.43*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*236.11*/presupuesto/*236.22*/.nombre)),format.raw/*236.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*237.11*/(utils.NumberUtils.moneda(BalancePresupuestario.getSaldoTotalPorCuenta(presupuesto.cuenta_analitica_padre_id,idEjercicio))))),format.raw/*237.134*/("""
						<!-- """),_display_(Seq[Any](/*238.13*/(utils.NumberUtils.moneda(presupuesto.saldo)))),format.raw/*238.58*/(""" -->
					</td>
					<td class=""""),_display_(Seq[Any](/*240.18*/if(BalancePresupuestario.getSaldoTotalPorCuenta(presupuesto.cuenta_analitica_padre_id,idEjercicio).subtract(presupuesto.preventivo).compareTo(java.math.BigDecimal.ZERO) < 0)/*240.191*/{_display_(Seq[Any](format.raw/*240.192*/("""negativo""")))})),format.raw/*240.201*/("""">
						"""),_display_(Seq[Any](/*241.8*/(utils.NumberUtils.moneda(BalancePresupuestario.getSaldoTotalPorCuenta(presupuesto.cuenta_analitica_padre_id,idEjercicio).subtract(presupuesto.preventivo))))),format.raw/*241.164*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*243.11*/(utils.NumberUtils.moneda(presupuesto.preventivo)))),format.raw/*243.61*/("""</td>
					<td class=""""),_display_(Seq[Any](/*244.18*/if(presupuesto.preventivo.subtract(presupuesto.definitivo).compareTo(java.math.BigDecimal.ZERO) < 0)/*244.118*/{_display_(Seq[Any](format.raw/*244.119*/("""negativo""")))})),format.raw/*244.128*/("""">
						"""),_display_(Seq[Any](/*245.8*/(utils.NumberUtils.moneda(presupuesto.preventivo.subtract(presupuesto.definitivo))))),format.raw/*245.91*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*247.11*/(utils.NumberUtils.moneda(presupuesto.definitivo)))),format.raw/*247.61*/("""</td>
					<td class=""""),_display_(Seq[Any](/*248.18*/if(presupuesto.definitivo.subtract(presupuesto.obligacion).compareTo(java.math.BigDecimal.ZERO) < 0)/*248.118*/{_display_(Seq[Any](format.raw/*248.119*/("""negativo""")))})),format.raw/*248.128*/("""">
						"""),_display_(Seq[Any](/*249.8*/(utils.NumberUtils.moneda(presupuesto.definitivo.subtract(presupuesto.obligacion))))),format.raw/*249.91*/("""
					</td>
					
					<td>"""),_display_(Seq[Any](/*252.11*/(utils.NumberUtils.moneda(presupuesto.obligacion)))),format.raw/*252.61*/("""</td>
					<td class=""""),_display_(Seq[Any](/*253.18*/if(presupuesto.obligacion.subtract(presupuesto.pago).compareTo(java.math.BigDecimal.ZERO) < 0)/*253.112*/{_display_(Seq[Any](format.raw/*253.113*/("""negativo""")))})),format.raw/*253.122*/("""">
						"""),_display_(Seq[Any](/*254.8*/(utils.NumberUtils.moneda(presupuesto.obligacion.subtract(presupuesto.pago))))),format.raw/*254.85*/("""
					</td>
					
					<td colspan="2">"""),_display_(Seq[Any](/*257.23*/(utils.NumberUtils.moneda(presupuesto.pago)))),format.raw/*257.67*/("""</td>
				</tr>
			
				"""),_display_(Seq[Any](/*260.6*/{saldoTotal = saldoTotal.add(BalancePresupuestario.getSaldoTotalPorCuenta(presupuesto.cuenta_analitica_padre_id,idEjercicio))})),format.raw/*260.132*/("""
				"""),_display_(Seq[Any](/*261.6*/{saldoDisponible = saldoDisponible.add(BalancePresupuestario.getSaldoTotalPorCuenta(presupuesto.cuenta_analitica_padre_id,idEjercicio).subtract(presupuesto.preventivo))})),format.raw/*261.175*/("""
				"""),_display_(Seq[Any](/*262.6*/{preventivoTotal = preventivoTotal.add(presupuesto.preventivo)})),format.raw/*262.69*/("""
				"""),_display_(Seq[Any](/*263.6*/{preventivoDisponible = preventivoDisponible.add(presupuesto.preventivo.subtract(presupuesto.definitivo))})),format.raw/*263.112*/("""
				"""),_display_(Seq[Any](/*264.6*/{definitivoTotal = definitivoTotal.add(presupuesto.definitivo)})),format.raw/*264.69*/("""
				"""),_display_(Seq[Any](/*265.6*/{definitivoDisponible = definitivoDisponible.add(presupuesto.definitivo.subtract(presupuesto.obligacion))})),format.raw/*265.112*/("""
				"""),_display_(Seq[Any](/*266.6*/{obligaciónTotal = obligaciónTotal.add(presupuesto.obligacion)})),format.raw/*266.69*/("""
				"""),_display_(Seq[Any](/*267.6*/{obligaciónDisponible = obligaciónDisponible.add(presupuesto.obligacion.subtract(presupuesto.pago))})),format.raw/*267.106*/("""
				"""),_display_(Seq[Any](/*268.6*/{pago = pago.add(presupuesto.pago)})),format.raw/*268.41*/("""
			""")))})),format.raw/*269.5*/("""
            </tbody>
            <tfoot>
				<tr>
					<td align="right"><b>TOTALES</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*274.29*/utils/*274.34*/.NumberUtils.moneda(saldoTotal))),format.raw/*274.65*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*275.29*/utils/*275.34*/.NumberUtils.moneda(saldoDisponible))),format.raw/*275.70*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*276.29*/utils/*276.34*/.NumberUtils.moneda(preventivoTotal))),format.raw/*276.70*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*277.29*/utils/*277.34*/.NumberUtils.moneda(preventivoDisponible))),format.raw/*277.75*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*278.29*/utils/*278.34*/.NumberUtils.moneda(definitivoTotal))),format.raw/*278.70*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*279.29*/utils/*279.34*/.NumberUtils.moneda(definitivoDisponible))),format.raw/*279.75*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*280.29*/utils/*280.34*/.NumberUtils.moneda(obligaciónTotal))),format.raw/*280.70*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*281.29*/utils/*281.34*/.NumberUtils.moneda(obligaciónDisponible))),format.raw/*281.75*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*282.29*/utils/*282.34*/.NumberUtils.moneda(pago))),format.raw/*282.59*/("""</b></td>
				</tr>
			</tfoot>
        </table>
		
		"""),_display_(Seq[Any](/*287.4*/if(lbp != null)/*287.19*/{_display_(Seq[Any](format.raw/*287.20*/("""
			<table class="table table-bordered tablaPresupuesto">
				<thead>
					<tr>
						<th width="30" >Expediente</th>
						<th width="30" colspan="2">Preventivo</th>
						<th width="30" colspan="2">Definitivo</th>
						<th width="30" colspan="2">Obligación</th>
						<th width="30" colspan="2">Pago</th>
					</tr>
					<tr>
					<th></th>
						<th>Total</th>
						<th>Disponible</th>
						<th>Total</th>
						<th>Disponible</th>
						<th>Total</th>
						<th>Disponible</th>
						<th colspan="2">Total</th>
					</tr>
				</thead>
				<tbody>	
			"""),_display_(Seq[Any](/*309.5*/for(l <- lbp) yield /*309.18*/ {_display_(Seq[Any](format.raw/*309.20*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*311.11*/l/*311.12*/.expediente.nombre)),format.raw/*311.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*312.11*/(utils.NumberUtils.moneda(l.preventivo)))),format.raw/*312.51*/("""</td>
					<td class=""""),_display_(Seq[Any](/*313.18*/if(l.preventivo.subtract(l.definitivo).compareTo(java.math.BigDecimal.ZERO) < 0)/*313.98*/{_display_(Seq[Any](format.raw/*313.99*/("""negativo""")))})),format.raw/*313.108*/("""">
						"""),_display_(Seq[Any](/*314.8*/(utils.NumberUtils.moneda(l.preventivo.subtract(l.definitivo))))),format.raw/*314.71*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*316.11*/(utils.NumberUtils.moneda(l.definitivo)))),format.raw/*316.51*/("""</td>
					<td class=""""),_display_(Seq[Any](/*317.18*/if(l.definitivo.subtract(l.obligacion).compareTo(java.math.BigDecimal.ZERO) < 0)/*317.98*/{_display_(Seq[Any](format.raw/*317.99*/("""negativo""")))})),format.raw/*317.108*/("""">
						"""),_display_(Seq[Any](/*318.8*/(utils.NumberUtils.moneda(l.definitivo.subtract(l.obligacion))))),format.raw/*318.71*/("""
					</td>
					
					<td>"""),_display_(Seq[Any](/*321.11*/(utils.NumberUtils.moneda(l.obligacion)))),format.raw/*321.51*/("""</td>
					<td class=""""),_display_(Seq[Any](/*322.18*/if(l.obligacion.subtract(l.pago).compareTo(java.math.BigDecimal.ZERO) < 0)/*322.92*/{_display_(Seq[Any](format.raw/*322.93*/("""negativo""")))})),format.raw/*322.102*/("""">
						"""),_display_(Seq[Any](/*323.8*/(utils.NumberUtils.moneda(l.obligacion.subtract(l.pago))))),format.raw/*323.65*/("""
					</td>
					
					<td colspan="2">"""),_display_(Seq[Any](/*326.23*/(utils.NumberUtils.moneda(l.pago)))),format.raw/*326.57*/("""</td>
				</tr>	
				"""),_display_(Seq[Any](/*328.6*/{epreventivoTotal = epreventivoTotal.add(l.preventivo)})),format.raw/*328.61*/("""
				"""),_display_(Seq[Any](/*329.6*/{epreventivoDisponible = epreventivoDisponible.add(l.preventivo.subtract(l.definitivo))})),format.raw/*329.94*/("""
				"""),_display_(Seq[Any](/*330.6*/{edefinitivoTotal = edefinitivoTotal.add(l.definitivo)})),format.raw/*330.61*/("""
				"""),_display_(Seq[Any](/*331.6*/{edefinitivoDisponible = edefinitivoDisponible.add(l.definitivo.subtract(l.obligacion))})),format.raw/*331.94*/("""
				"""),_display_(Seq[Any](/*332.6*/{eobligaciónTotal = eobligaciónTotal.add(l.obligacion)})),format.raw/*332.61*/("""
				"""),_display_(Seq[Any](/*333.6*/{eobligaciónDisponible = eobligaciónDisponible.add(l.obligacion.subtract(l.pago))})),format.raw/*333.88*/("""
				"""),_display_(Seq[Any](/*334.6*/{epago = epago.add(l.pago)})),format.raw/*334.33*/("""
			""")))})),format.raw/*335.5*/("""
				</tbody>
				<tfoot>
					<tr>
						<td align="right"><b>TOTALES</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*340.30*/utils/*340.35*/.NumberUtils.moneda(epreventivoTotal))),format.raw/*340.72*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*341.30*/utils/*341.35*/.NumberUtils.moneda(epreventivoDisponible))),format.raw/*341.77*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*342.30*/utils/*342.35*/.NumberUtils.moneda(edefinitivoTotal))),format.raw/*342.72*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*343.30*/utils/*343.35*/.NumberUtils.moneda(edefinitivoDisponible))),format.raw/*343.77*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*344.30*/utils/*344.35*/.NumberUtils.moneda(eobligaciónTotal))),format.raw/*344.72*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*345.30*/utils/*345.35*/.NumberUtils.moneda(eobligaciónDisponible))),format.raw/*345.77*/("""</b></td>
						<td align="center"><b>"""),_display_(Seq[Any](/*346.30*/utils/*346.35*/.NumberUtils.moneda(epago))),format.raw/*346.61*/("""</b></td>
					</tr>
				</tfoot>
				
        	</table>
		""")))})),format.raw/*351.4*/("""
		
		
 	 """)))})),format.raw/*354.5*/("""

""")))})),format.raw/*356.2*/("""
		
<script>
$(function()"""),format.raw/*359.13*/("""{"""),format.raw/*359.14*/("""
	$('#searchCuentaAnalitica').modalSearch();
	$('#searchExpediente').modalSearch();
	$('#searchObraSocial').modalSearch();
	
	$('#reporteBalancePorFecha').click( function() """),format.raw/*364.49*/("""{"""),format.raw/*364.50*/("""  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog("""),format.raw/*367.31*/("""{"""),format.raw/*367.32*/("""title: "Reporte Balance por Fecha",width:850,height: 300,"""),format.raw/*367.89*/("""}"""),format.raw/*367.90*/(""");
	"""),format.raw/*368.2*/("""}"""),format.raw/*368.3*/(""");
	
	$('#accionReporteGeneralPorExpedientePorCuenta').click( function() """),format.raw/*370.69*/("""{"""),format.raw/*370.70*/("""  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog("""),format.raw/*373.31*/("""{"""),format.raw/*373.32*/("""title: "Reporte Balance","""),format.raw/*373.57*/("""}"""),format.raw/*373.58*/(""");
	"""),format.raw/*374.2*/("""}"""),format.raw/*374.3*/(""");
	
	$('#accionReporteGeneralPorExpedientePorCuentaResumido').click( function() """),format.raw/*376.77*/("""{"""),format.raw/*376.78*/("""  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog("""),format.raw/*379.31*/("""{"""),format.raw/*379.32*/("""title: "Reporte Balance Resumido","""),format.raw/*379.66*/("""}"""),format.raw/*379.67*/(""");
	"""),format.raw/*380.2*/("""}"""),format.raw/*380.3*/(""");
	
"""),format.raw/*382.1*/("""}"""),format.raw/*382.2*/(""");
</script>
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[BalancePresupuestario],formBuscador:DynamicForm,lbp:List[BalancePresupuestario],idEjercicio:String): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,lbp,idEjercicio)
    
    def f:((utils.pagination.Pagination[BalancePresupuestario],DynamicForm,List[BalancePresupuestario],String) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,lbp,idEjercicio) => apply(buscador,formBuscador,lbp,idEjercicio)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/balancePresupuestario/indexBalancePresupuestario.scala.html
                    HASH: 6a062afd25dbd6fcc48f0348b02fb9d3dae06ba8
                    MATRIX: 920->1|1972->162|2004->186|2079->141|2108->230|2146->1043|2158->1048|2225->1107|2264->1109|2995->1804|3015->1815|3142->1919|3412->2153|3432->2164|3559->2268|3921->2594|3941->2605|4072->2713|4311->2916|4331->2927|4462->3035|4701->3238|4721->3249|4851->3356|5090->3559|5110->3570|5240->3677|5492->3893|5512->3904|5642->4011|5881->4214|5901->4225|6031->4332|6270->4535|6290->4546|6420->4653|6659->4856|6679->4867|6809->4974|6979->5108|6999->5119|7111->5208|7481->5543|7588->5628|7631->5636|7756->5738|7995->5941|8015->5952|8099->6014|8594->6473|8711->6566|8755->6574|8884->6679|9124->6882|9145->6893|9230->6955|9706->7395|9834->7499|9879->7508|9987->7593|10210->7779|10231->7790|10308->7844|10728->8228|10888->8365|11072->8513|11201->8618|11361->8742|11553->8910|11759->9080|11897->9194|11941->9202|12048->9286|12231->9432|12252->9443|12328->9496|13023->10154|13044->10165|13126->10224|13273->10335|13317->10369|13358->10371|13498->10493|13512->10498|13552->10499|13613->10523|13631->10531|13686->10563|14388->11229|14441->11265|14482->11267|14541->11289|14562->11300|14592->11307|14646->11324|14793->11447|14844->11461|14912->11506|14984->11541|15168->11714|15209->11715|15252->11724|15299->11735|15479->11891|15540->11915|15613->11965|15674->11989|15785->12089|15826->12090|15869->12099|15916->12110|16022->12193|16083->12217|16156->12267|16217->12291|16328->12391|16369->12392|16412->12401|16459->12412|16565->12495|16633->12526|16706->12576|16767->12600|16872->12694|16913->12695|16956->12704|17003->12715|17103->12792|17183->12835|17250->12879|17314->12907|17464->13033|17507->13040|17700->13209|17743->13216|17829->13279|17872->13286|18002->13392|18045->13399|18131->13462|18174->13469|18304->13575|18347->13582|18433->13645|18476->13652|18600->13752|18643->13759|18701->13794|18739->13800|18903->13927|18918->13932|18972->13963|19048->14002|19063->14007|19122->14043|19198->14082|19213->14087|19272->14123|19348->14162|19363->14167|19427->14208|19503->14247|19518->14252|19577->14288|19653->14327|19668->14332|19732->14373|19808->14412|19823->14417|19882->14453|19958->14492|19973->14497|20037->14538|20113->14577|20128->14582|20176->14607|20272->14667|20297->14682|20337->14683|20954->15264|20984->15277|21025->15279|21084->15301|21095->15302|21136->15320|21190->15337|21253->15377|21314->15401|21404->15481|21444->15482|21487->15491|21534->15502|21620->15565|21681->15589|21744->15629|21805->15653|21895->15733|21935->15734|21978->15743|22025->15754|22111->15817|22179->15848|22242->15888|22303->15912|22387->15986|22427->15987|22470->15996|22517->16007|22597->16064|22677->16107|22734->16141|22794->16165|22872->16220|22915->16227|23026->16315|23069->16322|23147->16377|23190->16384|23301->16472|23344->16479|23422->16534|23465->16541|23570->16623|23613->16630|23663->16657|23701->16663|23852->16777|23867->16782|23927->16819|24004->16859|24019->16864|24084->16906|24161->16946|24176->16951|24236->16988|24313->17028|24328->17033|24393->17075|24470->17115|24485->17120|24545->17157|24622->17197|24637->17202|24702->17244|24779->17284|24794->17289|24843->17315|24940->17380|24986->17394|25023->17399|25080->17427|25110->17428|25317->17606|25347->17607|25501->17732|25531->17733|25617->17790|25647->17791|25680->17796|25709->17797|25813->17872|25843->17873|25997->17998|26027->17999|26081->18024|26111->18025|26144->18030|26173->18031|26285->18114|26315->18115|26469->18240|26499->18241|26562->18275|26592->18276|26625->18281|26654->18282|26689->18289|26718->18290
                    LINES: 26->1|31->3|31->3|32->1|33->3|34->5|34->5|34->5|34->5|55->26|55->26|55->26|60->31|60->31|60->31|66->37|66->37|66->37|70->41|70->41|70->41|74->45|74->45|74->45|78->49|78->49|78->49|83->54|83->54|83->54|87->58|87->58|87->58|91->62|91->62|91->62|95->66|95->66|95->66|98->69|98->69|98->69|117->88|117->88|118->89|118->89|124->95|124->95|124->95|138->109|138->109|139->110|139->110|145->116|145->116|145->116|159->130|159->130|160->131|160->131|165->136|165->136|165->136|178->149|179->150|187->158|187->158|193->164|194->165|200->171|200->171|201->172|201->172|205->176|205->176|205->176|223->194|223->194|223->194|230->201|230->201|230->201|236->207|236->207|236->207|238->209|238->209|238->209|263->234|263->234|263->234|265->236|265->236|265->236|266->237|266->237|267->238|267->238|269->240|269->240|269->240|269->240|270->241|270->241|272->243|272->243|273->244|273->244|273->244|273->244|274->245|274->245|276->247|276->247|277->248|277->248|277->248|277->248|278->249|278->249|281->252|281->252|282->253|282->253|282->253|282->253|283->254|283->254|286->257|286->257|289->260|289->260|290->261|290->261|291->262|291->262|292->263|292->263|293->264|293->264|294->265|294->265|295->266|295->266|296->267|296->267|297->268|297->268|298->269|303->274|303->274|303->274|304->275|304->275|304->275|305->276|305->276|305->276|306->277|306->277|306->277|307->278|307->278|307->278|308->279|308->279|308->279|309->280|309->280|309->280|310->281|310->281|310->281|311->282|311->282|311->282|316->287|316->287|316->287|338->309|338->309|338->309|340->311|340->311|340->311|341->312|341->312|342->313|342->313|342->313|342->313|343->314|343->314|345->316|345->316|346->317|346->317|346->317|346->317|347->318|347->318|350->321|350->321|351->322|351->322|351->322|351->322|352->323|352->323|355->326|355->326|357->328|357->328|358->329|358->329|359->330|359->330|360->331|360->331|361->332|361->332|362->333|362->333|363->334|363->334|364->335|369->340|369->340|369->340|370->341|370->341|370->341|371->342|371->342|371->342|372->343|372->343|372->343|373->344|373->344|373->344|374->345|374->345|374->345|375->346|375->346|375->346|380->351|383->354|385->356|388->359|388->359|393->364|393->364|396->367|396->367|396->367|396->367|397->368|397->368|399->370|399->370|402->373|402->373|402->373|402->373|403->374|403->374|405->376|405->376|408->379|408->379|408->379|408->379|409->380|409->380|411->382|411->382
                    -- GENERATED --
                */
            