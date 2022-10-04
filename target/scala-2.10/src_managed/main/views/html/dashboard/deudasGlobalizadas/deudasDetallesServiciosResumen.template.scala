
package views.html.dashboard.deudasGlobalizadas

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
object deudasDetallesServiciosResumen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[com.avaje.ebean.SqlRow],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorTodos:List[com.avaje.ebean.SqlRow],
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalDeudaOtros=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var columnas =6

import java.lang.String;var proveedorNombre =""

implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*2.27*/("""

"""),format.raw/*7.70*/("""
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.mainDashboard("Deudas Servicios")/*11.56*/ {_display_(Seq[Any](format.raw/*11.58*/("""
"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*12.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Servicios Resumen</h1>
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
				  href=""""),_display_(Seq[Any](/*29.14*/controllers/*29.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasServiciosProveedoresResumenReportes())),format.raw/*29.123*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			<thead>
				<th colspan="2" align="center" style="font-size:20px;text-align:center;">Operativa</th>
			</thead>
			<thead>
				<th>PROVEEDOR</th>
				<th>DEUDA</th>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*47.6*/for(s <- proveedorTodos) yield /*47.30*/{_display_(Seq[Any](format.raw/*47.31*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*49.12*/s/*49.13*/.getString("nombre_proveedor"))),format.raw/*49.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*50.12*/utils/*50.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*50.68*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*52.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*52.57*/("""
				""")))})),format.raw/*53.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*58.14*/utils/*58.19*/.NumberUtils.moneda(mtdoh))),format.raw/*58.45*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>


""")))})))}
    }
    
    def render(proveedorTodos:List[com.avaje.ebean.SqlRow],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorTodos,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorTodos,formBuscador) => apply(proveedorTodos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallesServiciosResumen.scala.html
                    HASH: 4f5420b378b49beac848ce1f5376eb329e854333
                    MATRIX: 862->1|1428->131|1460->155|1534->73|1563->199|1600->555|1613->560|1671->609|1711->611|1748->613|1761->618|1841->676|2459->1258|2479->1269|2600->1367|3033->1765|3073->1789|3112->1790|3204->1846|3214->1847|3266->1877|3319->1894|3333->1899|3406->1950|3464->1973|3536->2023|3573->2029|3732->2152|3746->2157|3794->2183
                    LINES: 26->1|40->7|40->7|41->2|43->7|44->11|44->11|44->11|44->11|45->12|45->12|45->12|62->29|62->29|62->29|80->47|80->47|80->47|82->49|82->49|82->49|83->50|83->50|83->50|85->52|85->52|86->53|91->58|91->58|91->58
                    -- GENERATED --
                */
            