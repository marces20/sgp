
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
object deudasOtrosProveedoresResumen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String,Boolean,Boolean,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorHEARM:List[com.avaje.ebean.SqlRow],
proveedorOtros:List[com.avaje.ebean.SqlRow],
cuenta:String,profe:Boolean,
equipamientos:Boolean,
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0

import java.lang.String;var proveedorNombre =""

implicit def /*9.2*/implicitFieldConstructor/*9.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*5.27*/("""
"""),format.raw/*9.70*/("""
"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.dashboard.mainDashboard("Deudas Otros RESUMEN")/*13.60*/ {_display_(Seq[Any](format.raw/*13.62*/("""
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*14.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Deudas Otros Proveedores RESUMEN """),_display_(Seq[Any](/*19.42*/if(equipamientos)/*19.59*/{_display_(Seq[Any](format.raw/*19.60*/("""- EQUIPAMIENTOS""")))})),format.raw/*19.76*/("""</h1>
		</div>
		<div class="col-sm-3">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
				  <a id="" role="menuitem" tabindex="-1" 
				  href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasDetallesOtrosProveedoresResumen(profe,equipamientos))),format.raw/*31.138*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			<thead>
				<th colspan="2" align="center" style="font-size:20px;text-align:center;">"""),_display_(Seq[Any](/*42.79*/cuenta)),format.raw/*42.85*/(""" """),_display_(Seq[Any](/*42.87*/if(equipamientos)/*42.104*/{_display_(Seq[Any](format.raw/*42.105*/("""- EQUIPAMIENTOS""")))})),format.raw/*42.121*/("""</th>
			</thead>
			<thead>
				<th>PROVEEDOR</th>
				<th>DEUDA</th>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*49.6*/for(s <- proveedorHEARM) yield /*49.30*/{_display_(Seq[Any](format.raw/*49.31*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*51.12*/s/*51.13*/.getString("nombre_proveedor"))),format.raw/*51.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*52.12*/utils/*52.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*52.68*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*54.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*54.57*/("""
				""")))})),format.raw/*55.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*60.14*/utils/*60.19*/.NumberUtils.moneda(mtdoh))),format.raw/*60.45*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>


""")))})))}
    }
    
    def render(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],cuenta:String,profe:Boolean,equipamientos:Boolean,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String,Boolean,Boolean,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador) => apply(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasOtrosProveedoresResumen.scala.html
                    HASH: 077d52e15bd21aaa6be99f0683e4ce722b6d4fd8
                    MATRIX: 913->1|1601->227|1633->251|1707->170|1735->295|1772->676|1785->681|1847->734|1887->736|1924->738|1937->743|2017->801|2166->914|2192->931|2231->932|2279->948|2783->1416|2803->1427|2939->1540|3266->1831|3294->1837|3332->1839|3359->1856|3399->1857|3448->1873|3582->1972|3622->1996|3661->1997|3753->2053|3763->2054|3815->2084|3868->2101|3882->2106|3955->2157|4013->2180|4085->2230|4122->2236|4281->2359|4295->2364|4343->2390
                    LINES: 26->1|43->9|43->9|44->5|45->9|46->13|46->13|46->13|46->13|47->14|47->14|47->14|52->19|52->19|52->19|52->19|64->31|64->31|64->31|75->42|75->42|75->42|75->42|75->42|75->42|82->49|82->49|82->49|84->51|84->51|84->51|85->52|85->52|85->52|87->54|87->54|88->55|93->60|93->60|93->60
                    -- GENERATED --
                */
            