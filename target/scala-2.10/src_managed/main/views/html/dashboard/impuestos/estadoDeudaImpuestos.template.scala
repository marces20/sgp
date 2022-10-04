
package views.html.dashboard.impuestos

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
object estadoDeudaImpuestos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaImpuestos:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.dashboard.mainDashboard("Impuestos Deuda")/*4.55*/ {_display_(Seq[Any](format.raw/*4.57*/("""

<script src=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Assets.at("javascripts/dashboard/impuestos.js"))),format.raw/*6.69*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Estado de deudas - Impuestos</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>


<div class="row">
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Impuesto</th>
				<th>Cantidad</th>
				<th>Monto total Deuda</th>
				<th>#</th>
			</tr>
		</thead>		
		<tbody>
			"""),_display_(Seq[Any](/*37.5*/for(lc <- listaImpuestos) yield /*37.30*/ {_display_(Seq[Any](format.raw/*37.32*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*39.11*/lc/*39.13*/.getString("cuenta"))),format.raw/*39.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*40.11*/lc/*40.13*/.getInteger("cantidad"))),format.raw/*40.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*41.11*/utils/*41.16*/.NumberUtils.moneda(lc.getBigDecimal("monto")))),format.raw/*41.62*/("""</td>
					<td><a data-url=""""),_display_(Seq[Any](/*42.24*/controllers/*42.35*/.dashboard.routes.ImpuestosController.detalleImpuestos(lc.getLong("id")))),format.raw/*42.107*/(""""  class="btn btn-default trImpuestos"><i class="glyphicon glyphicon-list"></i> Detalle</a></td>
				</tr>	
			""")))})),format.raw/*44.5*/("""
		</tbody>
	</table>	
</div>
<div class="row" id="div-detalle-impuestos">

</div>

""")))})),format.raw/*52.2*/("""	"""))}
    }
    
    def render(listaImpuestos:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(listaImpuestos)
    
    def f:((List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (listaImpuestos) => apply(listaImpuestos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/impuestos/estadoDeudaImpuestos.scala.html
                    HASH: 127fd2276547a5ade502162513cca9a470a88aa2
                    MATRIX: 831->1|978->65|1010->89|1084->46|1112->133|1149->136|1161->141|1217->189|1256->191|1307->207|1321->213|1390->261|2204->1040|2245->1065|2285->1067|2341->1087|2352->1089|2394->1109|2446->1125|2457->1127|2502->1150|2554->1166|2568->1171|2636->1217|2701->1246|2721->1257|2816->1329|2959->1441|3075->1526
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|34->6|65->37|65->37|65->37|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|72->44|80->52
                    -- GENERATED --
                */
            