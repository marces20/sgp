
package views.html.dashboard.deudasPorAntiguedad

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
object deudasResumenMensual extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[java.util.Map[String, List[com.avaje.ebean.SqlRow]],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:java.util.Map[String,List[com.avaje.ebean.SqlRow]],formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var totaloperativa=new java.math.BigDecimal(0);var totalprofe=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.91*/("""
"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.dashboard.mainDashboard("Deudas Detalles")/*3.55*/ {_display_(Seq[Any](format.raw/*3.57*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*5.66*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Resumen Mensual</h1>
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
				  href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasMensualReporte())),format.raw/*23.103*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*33.4*/if(listaFinal.get("OPERATIVA") != null)/*33.43*/{_display_(Seq[Any](format.raw/*33.44*/("""
			<table class="table table-striped table-bordered table-hover" id="listaInforme">
				<thead>
					<th colspan="2" align="center">OPERATIVA</th>
				</thead>
				<thead>
					<th>PERIODO</th>
					<th>MONTO</th>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*43.7*/for(sx <- listaFinal.get("OPERATIVA")) yield /*43.45*/{_display_(Seq[Any](format.raw/*43.46*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*45.13*/sx/*45.15*/.getString("fecha_mes_ano"))),format.raw/*45.42*/("""</td>
							<td>"""),_display_(Seq[Any](/*46.13*/utils/*46.18*/.NumberUtils.moneda(sx.getBigDecimal("total_deuda")))),format.raw/*46.70*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*48.8*/{totaloperativa= totaloperativa.add(sx.getBigDecimal("total_deuda"))})),format.raw/*48.77*/("""
					""")))})),format.raw/*49.7*/("""
				</tbody>
				<tfoot>
					<tr>
						<td align="right"><b>TOTALES</b></td>
						<td><b>"""),_display_(Seq[Any](/*54.15*/utils/*54.20*/.NumberUtils.moneda(totaloperativa))),format.raw/*54.55*/("""</b></td>
						
					</tr>
				</tfoot>
			</table>
		""")))})),format.raw/*59.4*/("""
		
		"""),_display_(Seq[Any](/*61.4*/if(listaFinal.get("PROFE") != null)/*61.39*/{_display_(Seq[Any](format.raw/*61.40*/("""
			<table class="table table-striped table-bordered table-hover" id="listaInforme">
				<thead>
					<th colspan="2" align="center">PROFE</th>
				</thead>
				<thead>
					<th>PERIODO</th>
					<th>MONTO</th>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*71.7*/for(sx <- listaFinal.get("PROFE")) yield /*71.41*/{_display_(Seq[Any](format.raw/*71.42*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*73.13*/sx/*73.15*/.getString("fecha_mes_ano"))),format.raw/*73.42*/("""</td>
							<td>"""),_display_(Seq[Any](/*74.13*/utils/*74.18*/.NumberUtils.moneda(sx.getBigDecimal("total_deuda")))),format.raw/*74.70*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*76.8*/{totalprofe= totalprofe.add(sx.getBigDecimal("total_deuda"))})),format.raw/*76.69*/("""
					""")))})),format.raw/*77.7*/("""
				</tbody>
				<tfoot>
					<tr>
						<td align="right"><b>TOTALES</b></td>
						<td><b>"""),_display_(Seq[Any](/*82.15*/utils/*82.20*/.NumberUtils.moneda(totalprofe))),format.raw/*82.51*/("""</b></td>
						
					</tr>
				</tfoot>
			</table>
		""")))})),format.raw/*87.4*/("""
		
	</div>
</div>





""")))})))}
    }
    
    def render(listaFinal:java.util.Map[String, List[com.avaje.ebean.SqlRow]],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,formBuscador)
    
    def f:((java.util.Map[String, List[com.avaje.ebean.SqlRow]],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,formBuscador) => apply(listaFinal,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:59 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasResumenMensual.scala.html
                    HASH: 624008ddaf29a9bcd2123d4c05aee1f727bc4b1a
                    MATRIX: 876->1|1178->90|1214->212|1226->217|1282->265|1321->267|1358->270|1370->275|1450->334|2058->906|2078->917|2179->995|2357->1138|2405->1177|2444->1178|2725->1424|2779->1462|2818->1463|2878->1487|2889->1489|2938->1516|2992->1534|3006->1539|3080->1591|3140->1616|3231->1685|3269->1692|3399->1786|3413->1791|3470->1826|3557->1882|3599->1889|3643->1924|3682->1925|3959->2167|4009->2201|4048->2202|4108->2226|4119->2228|4168->2255|4222->2273|4236->2278|4310->2330|4370->2355|4453->2416|4491->2423|4621->2517|4635->2522|4688->2553|4775->2609
                    LINES: 26->1|30->1|31->3|31->3|31->3|31->3|33->5|33->5|33->5|51->23|51->23|51->23|61->33|61->33|61->33|71->43|71->43|71->43|73->45|73->45|73->45|74->46|74->46|74->46|76->48|76->48|77->49|82->54|82->54|82->54|87->59|89->61|89->61|89->61|99->71|99->71|99->71|101->73|101->73|101->73|102->74|102->74|102->74|104->76|104->76|105->77|110->82|110->82|110->82|115->87
                    -- GENERATED --
                */
            