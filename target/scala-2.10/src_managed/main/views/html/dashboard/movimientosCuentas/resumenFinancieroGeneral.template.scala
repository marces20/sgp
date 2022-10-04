
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
object resumenFinancieroGeneral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,cuentaMovimientoMonto:java.util.Map[String,java.util.Map[String,java.math.BigDecimal]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.116*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.dashboard.mainDashboard("Resumen Financiero General")/*6.66*/ {_display_(Seq[Any](format.raw/*6.68*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.movimientosCuentas.navmovimientoscuentas())),format.raw/*8.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Resumen Financiero General</h1>
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
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">FONDOS PROVINCIALES</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*79.12*/utils/*79.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("SALDOINICIAL")))),format.raw/*79.106*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*83.12*/utils/*83.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("INGRESO")))),format.raw/*83.101*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*87.12*/utils/*87.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("GASTO")))),format.raw/*87.99*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*91.12*/utils/*91.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROVINCIALES").get("SALDO")))),format.raw/*91.99*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">FONDOS VARIOS</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*112.12*/utils/*112.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("SALDOINICIAL")))),format.raw/*112.100*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*116.12*/utils/*116.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("INGRESO")))),format.raw/*116.95*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*120.12*/utils/*120.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("GASTO")))),format.raw/*120.93*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*124.12*/utils/*124.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS VARIOS").get("SALDO")))),format.raw/*124.93*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">FONDOS PROFE</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*148.12*/utils/*148.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("SALDOINICIAL")))),format.raw/*148.99*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*152.12*/utils/*152.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("INGRESO")))),format.raw/*152.94*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*156.12*/utils/*156.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("GASTO")))),format.raw/*156.92*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*160.12*/utils/*160.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS PROFE").get("SALDO")))),format.raw/*160.92*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">FONDOS SOLIDARIO DE SALUD</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*181.12*/utils/*181.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("SALDOINICIAL")))),format.raw/*181.112*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*185.12*/utils/*185.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("INGRESO")))),format.raw/*185.107*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*189.12*/utils/*189.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("GASTO")))),format.raw/*189.105*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*193.12*/utils/*193.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("FONDOS SOLIDARIO DE SALUD").get("SALDO")))),format.raw/*193.105*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
 
 <div class="row"  style="">
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">OPERATIVA</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*217.12*/utils/*217.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDOINICIAL")))),format.raw/*217.96*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*221.12*/utils/*221.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("INGRESO")))),format.raw/*221.91*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*225.12*/utils/*225.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("GASTO")))),format.raw/*225.89*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*229.12*/utils/*229.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("OPERATIVA").get("SALDO")))),format.raw/*229.89*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6" style="">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center;">PROFE</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>MOVIMIENTO</th>
					<th>SALDO</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>SALDO INICIAL</td>
						<td>"""),_display_(Seq[Any](/*250.12*/utils/*250.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDOINICIAL")))),format.raw/*250.92*/("""</td>
					</tr>
					<tr>
						<td>INGRESOS</td>
						<td>"""),_display_(Seq[Any](/*254.12*/utils/*254.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("INGRESO")))),format.raw/*254.87*/("""</td>
					</tr>
					<tr>
						<td>GASTOS</td>
						<td>"""),_display_(Seq[Any](/*258.12*/utils/*258.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("GASTO")))),format.raw/*258.85*/("""</td>
					</tr>
					<tr>
						<td>SALDO</td>
						<td>"""),_display_(Seq[Any](/*262.12*/utils/*262.17*/.NumberUtils.moneda(cuentaMovimientoMonto.get("PROFE").get("SALDO")))),format.raw/*262.85*/("""</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>

 
 

 
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,cuentaMovimientoMonto:java.util.Map[String, java.util.Map[String, java.math.BigDecimal]]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,cuentaMovimientoMonto)
    
    def f:((DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,cuentaMovimientoMonto) => apply(formBuscador,cuentaMovimientoMonto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/resumenFinancieroGeneral.scala.html
                    HASH: 8ff75c59522e4b193b9bc8c31062b786efe2c6d0
                    MATRIX: 894->1|1126->134|1158->158|1233->115|1261->202|1289->220|1325->222|1337->227|1404->286|1443->288|1480->291|1492->296|1571->354|2252->1000|2265->1005|2312->1030|2520->1203|2661->1321|2703->1328|2844->1446|3586->2152|3600->2157|3712->2246|3810->2308|3824->2313|3931->2397|4027->2457|4041->2462|4145->2544|4240->2603|4254->2608|4358->2690|4800->3095|4815->3100|4922->3183|5021->3245|5036->3250|5137->3328|5234->3388|5249->3393|5348->3469|5444->3528|5459->3533|5558->3609|6035->4049|6050->4054|6155->4136|6254->4198|6269->4203|6369->4280|6466->4340|6481->4345|6579->4420|6675->4479|6690->4484|6788->4559|7242->4976|7257->4981|7376->5076|7475->5138|7490->5143|7604->5233|7701->5293|7716->5298|7828->5386|7924->5445|7939->5450|8051->5538|8527->5977|8542->5982|8644->6061|8743->6123|8758->6128|8855->6202|8952->6262|8967->6267|9062->6339|9158->6398|9173->6403|9268->6475|9702->6872|9717->6877|9815->6952|9914->7014|9929->7019|10022->7089|10119->7149|10134->7154|10225->7222|10321->7281|10336->7286|10427->7354
                    LINES: 26->1|31->3|31->3|32->1|33->3|34->5|35->6|35->6|35->6|35->6|37->8|37->8|37->8|61->32|61->32|61->32|68->39|68->39|69->40|69->40|108->79|108->79|108->79|112->83|112->83|112->83|116->87|116->87|116->87|120->91|120->91|120->91|141->112|141->112|141->112|145->116|145->116|145->116|149->120|149->120|149->120|153->124|153->124|153->124|177->148|177->148|177->148|181->152|181->152|181->152|185->156|185->156|185->156|189->160|189->160|189->160|210->181|210->181|210->181|214->185|214->185|214->185|218->189|218->189|218->189|222->193|222->193|222->193|246->217|246->217|246->217|250->221|250->221|250->221|254->225|254->225|254->225|258->229|258->229|258->229|279->250|279->250|279->250|283->254|283->254|283->254|287->258|287->258|287->258|291->262|291->262|291->262
                    -- GENERATED --
                */
            