
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
object deudasDetallesHonorariosResumen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[com.avaje.ebean.SqlRow],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorTodos:List[com.avaje.ebean.SqlRow], 
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0

import java.lang.String;var proveedorNombre =""

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*2.27*/("""
"""),format.raw/*6.70*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Deudas Servicios")/*10.56*/ {_display_(Seq[Any](format.raw/*10.58*/("""
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*11.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Honorarios RESUMEN</h1>
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
				  href=""""),_display_(Seq[Any](/*28.14*/controllers/*28.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasHonorariosProveedoresResumenReportes())),format.raw/*28.124*/("""">Reporte Excel</a></li>
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
				"""),_display_(Seq[Any](/*46.6*/for(s <- proveedorTodos) yield /*46.30*/{_display_(Seq[Any](format.raw/*46.31*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*48.12*/s/*48.13*/.getString("nombre_proveedor"))),format.raw/*48.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*49.12*/utils/*49.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*49.68*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*51.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*51.57*/("""
				""")))})),format.raw/*52.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*57.14*/utils/*57.19*/.NumberUtils.moneda(mtdoh))),format.raw/*57.45*/("""</b></td>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallesHonorariosResumen.scala.html
                    HASH: 9ef4aad0d8ed686f50b076b6d043775d66403d59
                    MATRIX: 863->1|1455->131|1487->155|1561->74|1589->199|1626->580|1639->585|1697->634|1737->636|1774->638|1787->643|1867->701|2475->1273|2495->1284|2617->1383|3050->1781|3090->1805|3129->1806|3221->1862|3231->1863|3283->1893|3336->1910|3350->1915|3423->1966|3481->1989|3553->2039|3590->2045|3749->2168|3763->2173|3811->2199
                    LINES: 26->1|40->6|40->6|41->2|42->6|43->10|43->10|43->10|43->10|44->11|44->11|44->11|61->28|61->28|61->28|79->46|79->46|79->46|81->48|81->48|81->48|82->49|82->49|82->49|84->51|84->51|85->52|90->57|90->57|90->57
                    -- GENERATED --
                */
            