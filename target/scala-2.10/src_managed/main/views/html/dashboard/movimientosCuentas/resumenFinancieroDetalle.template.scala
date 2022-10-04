
package views.html.dashboard.movimientosCuentas

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
object resumenFinancieroDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],java.util.Map[String, List[com.avaje.ebean.SqlRow]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,cuentaMovimientoMonto:java.util.Map[String,java.util.Map[String,java.math.BigDecimal]],cuentasListaGastos:java.util.Map[String,List[com.avaje.ebean.SqlRow]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import java.math.BigDecimal;var totalGastos=new java.math.BigDecimal(0);

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.186*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.dashboard.mainDashboard("Resumen Financiero Detalle")/*6.66*/ {_display_(Seq[Any](format.raw/*6.68*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.movimientosCuentas.navmovimientoscuentas())),format.raw/*8.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Resumen Financiero Detalle</h1>
		</div>
		
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
				  <a id="" role="menuitem" tabindex="-1" 
				  href="">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*32.2*/views/*32.7*/.html.tags.successError())),format.raw/*32.32*/("""
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			 <div class="col-sm-2 input-group">
				<label class="control-label">Fecha</label>
				<div>
					"""),_display_(Seq[Any](/*39.7*/inputText(formBuscador("fdesde"), 'class -> "form-control inputDateMascara", 'id -> "fdesde", 'placeholder -> "Desde"))),format.raw/*39.125*/("""
					"""),_display_(Seq[Any](/*40.7*/inputText(formBuscador("fhasta"), 'class -> "form-control inputDateMascara", 'id -> "fhasta", 'placeholder -> "Hasta"))),format.raw/*40.125*/("""
				</div>
			</div>
			 
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			 
		</div>
	</form>
</div>
<hr>

<!-- <div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">FONDOS PROVINCIALES</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*64.12*/utils/*64.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("SALDOINICIAL")))),format.raw/*64.106*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*68.12*/utils/*68.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("INGRESO")))),format.raw/*68.101*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*70.7*/if(cuentasListaGastos.containsKey("FONDOS PROVINCIALES"))/*70.64*/{_display_(Seq[Any](format.raw/*70.65*/("""
						"""),_display_(Seq[Any](/*71.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*71.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*80.10*/for(z <- cuentasListaGastos.get("FONDOS PROVINCIALES")) yield /*80.65*/{_display_(Seq[Any](format.raw/*80.66*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*82.16*/z/*82.17*/.getString("rubro"))),format.raw/*82.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*83.16*/utils/*83.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*83.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*85.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*85.69*/("""
								""")))})),format.raw/*86.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*89.18*/utils/*89.23*/.NumberUtils.moneda(totalGastos))),format.raw/*89.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*94.7*/else/*94.11*/{_display_(Seq[Any](format.raw/*94.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*97.13*/utils/*97.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("GASTO")))),format.raw/*97.100*/("""</td>
						</tr>
					""")))})),format.raw/*99.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*102.12*/utils/*102.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("SALDO")))),format.raw/*102.99*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">FONDOS VARIOS</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*114.12*/utils/*114.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("SALDOINICIAL")))),format.raw/*114.100*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*118.12*/utils/*118.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("INGRESO")))),format.raw/*118.95*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*120.7*/if(cuentasListaGastos.containsKey("FONDOS VARIOS"))/*120.58*/{_display_(Seq[Any](format.raw/*120.59*/("""
						"""),_display_(Seq[Any](/*121.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*121.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*130.10*/for(z <- cuentasListaGastos.get("FONDOS VARIOS")) yield /*130.59*/{_display_(Seq[Any](format.raw/*130.60*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*132.16*/z/*132.17*/.getString("rubro"))),format.raw/*132.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*133.16*/utils/*133.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*133.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*135.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*135.69*/("""
								""")))})),format.raw/*136.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*139.18*/utils/*139.23*/.NumberUtils.moneda(totalGastos))),format.raw/*139.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*144.7*/else/*144.11*/{_display_(Seq[Any](format.raw/*144.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*147.13*/utils/*147.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("GASTO")))),format.raw/*147.94*/("""</td>
						</tr>
					""")))})),format.raw/*149.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*152.12*/utils/*152.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("SALDO")))),format.raw/*152.93*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">FONDOS PROFE</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*167.12*/utils/*167.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("SALDOINICIAL")))),format.raw/*167.99*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*171.12*/utils/*171.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("INGRESO")))),format.raw/*171.94*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*173.7*/if(cuentasListaGastos.containsKey("FONDOS PROFE"))/*173.57*/{_display_(Seq[Any](format.raw/*173.58*/("""
						"""),_display_(Seq[Any](/*174.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*174.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*183.10*/for(z <- cuentasListaGastos.get("FONDOS PROFE")) yield /*183.58*/{_display_(Seq[Any](format.raw/*183.59*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*185.16*/z/*185.17*/.getString("rubro"))),format.raw/*185.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*186.16*/utils/*186.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*186.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*188.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*188.69*/("""
								""")))})),format.raw/*189.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*192.18*/utils/*192.23*/.NumberUtils.moneda(totalGastos))),format.raw/*192.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*197.7*/else/*197.11*/{_display_(Seq[Any](format.raw/*197.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*200.13*/utils/*200.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("GASTO")))),format.raw/*200.93*/("""</td>
						</tr>
					""")))})),format.raw/*202.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*205.12*/utils/*205.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("SALDO")))),format.raw/*205.92*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">FONDOS SOLIDARIO DE SALUD</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*217.12*/utils/*217.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("SALDOINICIAL")))),format.raw/*217.112*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*221.12*/utils/*221.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("INGRESO")))),format.raw/*221.107*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*223.7*/if(cuentasListaGastos.containsKey("FONDOS SOLIDARIO DE SALUD"))/*223.70*/{_display_(Seq[Any](format.raw/*223.71*/("""
						"""),_display_(Seq[Any](/*224.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*224.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*233.10*/for(z <- cuentasListaGastos.get("FONDOS SOLIDARIO DE SALUD")) yield /*233.71*/{_display_(Seq[Any](format.raw/*233.72*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*235.16*/z/*235.17*/.getString("rubro"))),format.raw/*235.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*236.16*/utils/*236.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*236.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*238.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*238.69*/("""
								""")))})),format.raw/*239.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*242.18*/utils/*242.23*/.NumberUtils.moneda(totalGastos))),format.raw/*242.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*247.7*/else/*247.11*/{_display_(Seq[Any](format.raw/*247.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*250.13*/utils/*250.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("GASTO")))),format.raw/*250.106*/("""</td>
						</tr>
					""")))})),format.raw/*252.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*255.12*/utils/*255.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("SALDO")))),format.raw/*255.105*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div> -->

<div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">OPERATIVA</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*270.12*/utils/*270.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDOINICIAL")))),format.raw/*270.96*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*274.12*/utils/*274.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("INGRESO")))),format.raw/*274.91*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*276.7*/if(cuentasListaGastos.containsKey("OPERATIVA"))/*276.54*/{_display_(Seq[Any](format.raw/*276.55*/("""
						"""),_display_(Seq[Any](/*277.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*277.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*286.10*/for(z <- cuentasListaGastos.get("OPERATIVA")) yield /*286.55*/{_display_(Seq[Any](format.raw/*286.56*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*288.16*/z/*288.17*/.getString("rubro"))),format.raw/*288.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*289.16*/utils/*289.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*289.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*291.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*291.69*/("""
								""")))})),format.raw/*292.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*295.18*/utils/*295.23*/.NumberUtils.moneda(totalGastos))),format.raw/*295.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*300.7*/else/*300.11*/{_display_(Seq[Any](format.raw/*300.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*303.13*/utils/*303.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("GASTO")))),format.raw/*303.90*/("""</td>
						</tr>
					""")))})),format.raw/*305.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*308.12*/utils/*308.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDO")))),format.raw/*308.89*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">PROFE</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*320.12*/utils/*320.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDOINICIAL")))),format.raw/*320.92*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*324.12*/utils/*324.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("INGRESO")))),format.raw/*324.87*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*326.7*/if(cuentasListaGastos.containsKey("PROFE"))/*326.50*/{_display_(Seq[Any](format.raw/*326.51*/("""
						"""),_display_(Seq[Any](/*327.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*327.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*336.10*/for(z <- cuentasListaGastos.get("PROFE")) yield /*336.51*/{_display_(Seq[Any](format.raw/*336.52*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*338.16*/z/*338.17*/.getString("rubro"))),format.raw/*338.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*339.16*/utils/*339.21*/.NumberUtils.moneda(z.getBigDecimal("debito")))),format.raw/*339.67*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*341.11*/{totalGastos = totalGastos.add(z.getBigDecimal("debito"))})),format.raw/*341.69*/("""
								""")))})),format.raw/*342.10*/("""			
								<tr>
									<td align="right">TOTAL GASTOS</td>
									<td><b>"""),_display_(Seq[Any](/*345.18*/utils/*345.23*/.NumberUtils.moneda(totalGastos))),format.raw/*345.55*/("""</b></td>
								</tr>					
							</table>
							</td>
						</tr>
					""")))}/*350.7*/else/*350.11*/{_display_(Seq[Any](format.raw/*350.12*/("""
						<tr>
							<td>GASTOS</td>
							<td>"""),_display_(Seq[Any](/*353.13*/utils/*353.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("GASTO")))),format.raw/*353.86*/("""</td>
						</tr>
					""")))})),format.raw/*355.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*358.12*/utils/*358.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDO")))),format.raw/*358.85*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>

""")))})))}
    }
    
    def render(formBuscador:DynamicForm,cuentaMovimientoMonto:java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],cuentasListaGastos:java.util.Map[String, List[com.avaje.ebean.SqlRow]]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,cuentaMovimientoMonto,cuentasListaGastos)
    
    def f:((DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],java.util.Map[String, List[com.avaje.ebean.SqlRow]]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,cuentaMovimientoMonto,cuentasListaGastos) => apply(formBuscador,cuentaMovimientoMonto,cuentasListaGastos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/resumenFinancieroDetalle.scala.html
                    HASH: cbbb1c909fed8368a8f238ed835f068e5074b756
                    MATRIX: 946->1|1322->204|1354->228|1429->185|1457->272|1494->365|1506->370|1573->429|1612->431|1649->434|1661->439|1740->497|2421->1143|2434->1148|2481->1173|2689->1346|2830->1464|2872->1471|3013->1589|3708->2248|3722->2253|3834->2342|3932->2404|3946->2409|4053->2493|4111->2516|4177->2573|4216->2574|4259->2582|4324->2625|4575->2840|4646->2895|4685->2896|4751->2926|4761->2927|4802->2946|4859->2967|4873->2972|4941->3018|5008->3049|5088->3107|5130->3117|5245->3196|5259->3201|5313->3233|5407->3309|5420->3313|5459->3314|5542->3361|5556->3366|5661->3448|5716->3472|5796->3515|5811->3520|5916->3602|6312->3961|6327->3966|6434->4049|6533->4111|6548->4116|6649->4194|6708->4217|6769->4268|6809->4269|6853->4277|6919->4320|7171->4535|7237->4584|7277->4585|7344->4615|7355->4616|7397->4635|7455->4656|7470->4661|7539->4707|7607->4738|7688->4796|7731->4806|7847->4885|7862->4890|7917->4922|8012->4998|8026->5002|8066->5003|8150->5050|8165->5055|8264->5131|8320->5155|8400->5198|8415->5203|8514->5279|8945->5673|8960->5678|9065->5760|9164->5822|9179->5827|9279->5904|9338->5927|9398->5977|9438->5978|9482->5986|9548->6029|9800->6244|9865->6292|9905->6293|9972->6323|9983->6324|10025->6343|10083->6364|10098->6369|10167->6415|10235->6446|10316->6504|10359->6514|10475->6593|10490->6598|10545->6630|10640->6706|10654->6710|10694->6711|10778->6758|10793->6763|10891->6838|10947->6862|11027->6905|11042->6910|11140->6985|11548->7356|11563->7361|11682->7456|11781->7518|11796->7523|11910->7613|11969->7636|12042->7699|12082->7700|12126->7708|12192->7751|12444->7966|12522->8027|12562->8028|12629->8058|12640->8059|12682->8078|12740->8099|12755->8104|12824->8150|12892->8181|12973->8239|13016->8249|13132->8328|13147->8333|13202->8365|13297->8441|13311->8445|13351->8446|13435->8493|13450->8498|13562->8586|13618->8610|13698->8653|13713->8658|13825->8746|14257->9141|14272->9146|14374->9225|14473->9287|14488->9292|14585->9366|14644->9389|14701->9436|14741->9437|14785->9445|14851->9488|15103->9703|15165->9748|15205->9749|15272->9779|15283->9780|15325->9799|15383->9820|15398->9825|15467->9871|15535->9902|15616->9960|15659->9970|15775->10049|15790->10054|15845->10086|15940->10162|15954->10166|15994->10167|16078->10214|16093->10219|16188->10291|16244->10315|16324->10358|16339->10363|16434->10435|16822->10786|16837->10791|16935->10866|17034->10928|17049->10933|17142->11003|17201->11026|17254->11069|17294->11070|17338->11078|17404->11121|17656->11336|17714->11377|17754->11378|17821->11408|17832->11409|17874->11428|17932->11449|17947->11454|18016->11500|18084->11531|18165->11589|18208->11599|18324->11678|18339->11683|18394->11715|18489->11791|18503->11795|18543->11796|18627->11843|18642->11848|18733->11916|18789->11940|18869->11983|18884->11988|18975->12056
                    LINES: 26->1|33->3|33->3|34->1|35->3|36->6|36->6|36->6|36->6|38->8|38->8|38->8|62->32|62->32|62->32|69->39|69->39|70->40|70->40|94->64|94->64|94->64|98->68|98->68|98->68|100->70|100->70|100->70|101->71|101->71|110->80|110->80|110->80|112->82|112->82|112->82|113->83|113->83|113->83|115->85|115->85|116->86|119->89|119->89|119->89|124->94|124->94|124->94|127->97|127->97|127->97|129->99|132->102|132->102|132->102|144->114|144->114|144->114|148->118|148->118|148->118|150->120|150->120|150->120|151->121|151->121|160->130|160->130|160->130|162->132|162->132|162->132|163->133|163->133|163->133|165->135|165->135|166->136|169->139|169->139|169->139|174->144|174->144|174->144|177->147|177->147|177->147|179->149|182->152|182->152|182->152|197->167|197->167|197->167|201->171|201->171|201->171|203->173|203->173|203->173|204->174|204->174|213->183|213->183|213->183|215->185|215->185|215->185|216->186|216->186|216->186|218->188|218->188|219->189|222->192|222->192|222->192|227->197|227->197|227->197|230->200|230->200|230->200|232->202|235->205|235->205|235->205|247->217|247->217|247->217|251->221|251->221|251->221|253->223|253->223|253->223|254->224|254->224|263->233|263->233|263->233|265->235|265->235|265->235|266->236|266->236|266->236|268->238|268->238|269->239|272->242|272->242|272->242|277->247|277->247|277->247|280->250|280->250|280->250|282->252|285->255|285->255|285->255|300->270|300->270|300->270|304->274|304->274|304->274|306->276|306->276|306->276|307->277|307->277|316->286|316->286|316->286|318->288|318->288|318->288|319->289|319->289|319->289|321->291|321->291|322->292|325->295|325->295|325->295|330->300|330->300|330->300|333->303|333->303|333->303|335->305|338->308|338->308|338->308|350->320|350->320|350->320|354->324|354->324|354->324|356->326|356->326|356->326|357->327|357->327|366->336|366->336|366->336|368->338|368->338|368->338|369->339|369->339|369->339|371->341|371->341|372->342|375->345|375->345|375->345|380->350|380->350|380->350|383->353|383->353|383->353|385->355|388->358|388->358|388->358
                    -- GENERATED --
                */
            