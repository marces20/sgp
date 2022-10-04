
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
object resumenFinancieroDetallePorInstitucion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],java.util.Map[String, List[com.avaje.ebean.SqlRow]],play.api.templates.HtmlFormat.Appendable] {

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

<div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead><tr><th colspan="2" style="text-align: center;">OPERATIVA</th></tr></thead>
			<thead><tr><th>MOVIMIENTO</th><th>SALDO</th></tr></thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*64.12*/utils/*64.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDOINICIAL")))),format.raw/*64.96*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*68.12*/utils/*68.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("INGRESO")))),format.raw/*68.91*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*70.7*/if(cuentasListaGastos.containsKey("OPERATIVA"))/*70.54*/{_display_(Seq[Any](format.raw/*70.55*/("""
						"""),_display_(Seq[Any](/*71.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*71.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*80.10*/for(z <- cuentasListaGastos.get("OPERATIVA")) yield /*80.55*/{_display_(Seq[Any](format.raw/*80.56*/("""
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
							<td>"""),_display_(Seq[Any](/*97.13*/utils/*97.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("GASTO")))),format.raw/*97.90*/("""</td>
						</tr>
					""")))})),format.raw/*99.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*102.12*/utils/*102.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDO")))),format.raw/*102.89*/("""</td>
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
						<td>"""),_display_(Seq[Any](/*114.12*/utils/*114.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDOINICIAL")))),format.raw/*114.92*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*118.12*/utils/*118.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("INGRESO")))),format.raw/*118.87*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*120.7*/if(cuentasListaGastos.containsKey("PROFE"))/*120.50*/{_display_(Seq[Any](format.raw/*120.51*/("""
						"""),_display_(Seq[Any](/*121.8*/{totalGastos = new java.math.BigDecimal(0)})),format.raw/*121.51*/("""
						<tr>
							<td colspan="2">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<td colspan="2" align="center">
										GASTOS
									</td>
								</tr>
								"""),_display_(Seq[Any](/*130.10*/for(z <- cuentasListaGastos.get("PROFE")) yield /*130.51*/{_display_(Seq[Any](format.raw/*130.52*/("""
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
							<td>"""),_display_(Seq[Any](/*147.13*/utils/*147.18*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("GASTO")))),format.raw/*147.86*/("""</td>
						</tr>
					""")))})),format.raw/*149.7*/("""
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*152.12*/utils/*152.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDO")))),format.raw/*152.85*/("""</td>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/resumenFinancieroDetallePorInstitucion.scala.html
                    HASH: c485040cc6676845bb2b1637d28930cc6588a3e8
                    MATRIX: 960->1|1336->204|1368->228|1443->185|1471->272|1508->365|1520->370|1587->429|1626->431|1663->434|1675->439|1754->497|2435->1143|2448->1148|2495->1173|2703->1346|2844->1464|2886->1471|3027->1589|3707->2233|3721->2238|3822->2317|3920->2379|3934->2384|4030->2458|4088->2481|4144->2528|4183->2529|4226->2537|4291->2580|4542->2795|4603->2840|4642->2841|4708->2871|4718->2872|4759->2891|4816->2912|4830->2917|4898->2963|4965->2994|5045->3052|5087->3062|5202->3141|5216->3146|5270->3178|5364->3254|5377->3258|5416->3259|5499->3306|5513->3311|5607->3383|5662->3407|5742->3450|5757->3455|5852->3527|6240->3878|6255->3883|6353->3958|6452->4020|6467->4025|6560->4095|6619->4118|6672->4161|6712->4162|6756->4170|6822->4213|7074->4428|7132->4469|7172->4470|7239->4500|7250->4501|7292->4520|7350->4541|7365->4546|7434->4592|7502->4623|7583->4681|7626->4691|7742->4770|7757->4775|7812->4807|7907->4883|7921->4887|7961->4888|8045->4935|8060->4940|8151->5008|8207->5032|8287->5075|8302->5080|8393->5148
                    LINES: 26->1|33->3|33->3|34->1|35->3|36->6|36->6|36->6|36->6|38->8|38->8|38->8|62->32|62->32|62->32|69->39|69->39|70->40|70->40|94->64|94->64|94->64|98->68|98->68|98->68|100->70|100->70|100->70|101->71|101->71|110->80|110->80|110->80|112->82|112->82|112->82|113->83|113->83|113->83|115->85|115->85|116->86|119->89|119->89|119->89|124->94|124->94|124->94|127->97|127->97|127->97|129->99|132->102|132->102|132->102|144->114|144->114|144->114|148->118|148->118|148->118|150->120|150->120|150->120|151->121|151->121|160->130|160->130|160->130|162->132|162->132|162->132|163->133|163->133|163->133|165->135|165->135|166->136|169->139|169->139|169->139|174->144|174->144|174->144|177->147|177->147|177->147|179->149|182->152|182->152|182->152
                    -- GENERATED --
                */
            