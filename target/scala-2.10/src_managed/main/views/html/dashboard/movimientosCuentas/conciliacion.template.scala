
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
object conciliacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,java.util.Map[String, java.util.Map[String, java.math.BigDecimal]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,cuentaMovimientoMonto:java.util.Map[String,java.util.Map[String,java.math.BigDecimal]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import java.math.BigDecimal;var totalGastos=new java.math.BigDecimal(0);

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.116*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.dashboard.mainDashboard("Conciliacion")/*6.52*/ {_display_(Seq[Any](format.raw/*6.54*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.movimientosCuentas.navmovimientoscuentas())),format.raw/*8.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Conciliacion</h1>
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


<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*37.4*/for((key,value) <- cuentaMovimientoMonto) yield /*37.45*/{_display_(Seq[Any](format.raw/*37.46*/("""
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th colspan="2" style="text-align: center;">"""),_display_(Seq[Any](/*41.52*/key)),format.raw/*41.55*/("""</th>
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
							<td>SALDO</td>
							<td>"""),_display_(Seq[Any](/*53.13*/utils/*53.18*/.NumberUtils.moneda(value.get("SALDO")))),format.raw/*53.57*/("""</td>
						</tr>
						<tr>
							<td>CHEQUES NO ENTREGADOS</td>
							<td>"""),_display_(Seq[Any](/*57.13*/utils/*57.18*/.NumberUtils.moneda(value.get("CHEQUE_NO_ENTREGADOS")))),format.raw/*57.72*/("""</td>
						</tr>
						<tr>
							<td>CHEQUES SIN DEPOSITAR</td>
							<td>"""),_display_(Seq[Any](/*61.13*/utils/*61.18*/.NumberUtils.moneda(value.get("CHEQUE_SIN_DEPOSITAR")))),format.raw/*61.72*/("""</td>
						</tr>
					
				</tbody>
				
			</table>
		""")))})),format.raw/*67.4*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/conciliacion.scala.html
                    HASH: d75b0f8ea9ef393c7f622942663de2dbbbf4491a
                    MATRIX: 882->1|1188->134|1220->158|1295->115|1323->202|1360->295|1372->300|1425->345|1464->347|1501->350|1513->355|1592->413|2259->1045|2272->1050|2319->1075|2422->1143|2479->1184|2518->1185|2694->1325|2719->1328|2936->1509|2950->1514|3011->1553|3126->1632|3140->1637|3216->1691|3331->1770|3345->1775|3421->1829|3509->1886
                    LINES: 26->1|33->3|33->3|34->1|35->3|36->6|36->6|36->6|36->6|38->8|38->8|38->8|62->32|62->32|62->32|67->37|67->37|67->37|71->41|71->41|83->53|83->53|83->53|87->57|87->57|87->57|91->61|91->61|91->61|97->67
                    -- GENERATED --
                */
            