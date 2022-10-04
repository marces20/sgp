
package views.html.expediente.expediente

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
object listaExpedientesSinFirma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[OrdenProvision],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lr:List[OrdenProvision]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var diferencia=new java.math.BigDecimal(0);var totalOrden=new java.math.BigDecimal(0);var totalRecepcion=new java.math.BigDecimal(0);var totalDeuda=new java.math.BigDecimal(0);

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.27*/("""
"""),format.raw/*4.70*/(""" 


<div id="modalBusquedaExpedientes" class="contenedorPaginador ajaxPaginador">

	<table class="table table-striped table-bordered">
		<thead>
			<tr><td colspan="7" align="left"> <a href=""""),_display_(Seq[Any](/*11.48*/controllers/*11.59*/.expediente.routes.ExpedientesController.getExpedientesSinFirmaReporte())),format.raw/*11.131*/("""" ><span id="getExpedientesRecepcionSinFirmaReporte" 
			class="glyphicon glyphicon-print pointer" 
			data-url=""></span></a>
			</td></tr>
			 <tr>
				<td><b>Expediente</b></td>
				<td><b>Proveedor</b></td>
				<td><b>Total Orden</b></td>
				<td><b>Recepcionado</b></td> 
				<td><b>Diferencia</b></td> 
				<td><b>Servicio<b></td>
				<td><b>Tiempo<b></td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*26.5*/for(op <- lr) yield /*26.18*/{_display_(Seq[Any](format.raw/*26.19*/("""
				
				"""),_display_(Seq[Any](/*28.6*/{diferencia = new java.math.BigDecimal(0)})),format.raw/*28.48*/("""
				"""),_display_(Seq[Any](/*29.6*/{diferencia = op.ordenCompra.getTotalTotal().subtract(op.getTotalRecepcionado())})),format.raw/*29.87*/("""
				<tr>
				 	<td>"""),_display_(Seq[Any](/*31.12*/op/*31.14*/.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*31.62*/("""</td>
					<td>"""),_display_(Seq[Any](/*32.11*/op/*32.13*/.ordenCompra.proveedor.nombre)),format.raw/*32.42*/("""</td>
					<td>"""),_display_(Seq[Any](/*33.11*/utils/*33.16*/.NumberUtils.moneda(op.ordenCompra.getTotalTotal()))),format.raw/*33.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*34.11*/utils/*34.16*/.NumberUtils.moneda(op.getTotalRecepcionado()))),format.raw/*34.62*/("""</td> 
					<td>"""),_display_(Seq[Any](/*35.11*/utils/*35.16*/.NumberUtils.moneda(diferencia))),format.raw/*35.47*/("""</td> 
					<td>"""),_display_(Seq[Any](/*36.11*/op/*36.13*/.ordenCompra.expediente.getServicio())),format.raw/*36.50*/("""</td>
					<td>"""),_display_(Seq[Any](/*37.11*/ExpedienteMovimiento/*37.31*/.tiempoEnMovimiento(ExpedienteMovimiento.getLastMovimiento(op.ordenCompra.expediente.id)))),format.raw/*37.120*/("""</td>
				</tr>
				"""),_display_(Seq[Any](/*39.6*/{totalOrden = totalOrden.add(op.ordenCompra.getTotalTotal())})),format.raw/*39.67*/("""
				"""),_display_(Seq[Any](/*40.6*/{totalRecepcion = totalRecepcion.add(op.getTotalRecepcionado())})),format.raw/*40.70*/("""
				"""),_display_(Seq[Any](/*41.6*/{totalDeuda = totalDeuda.add(diferencia)})),format.raw/*41.47*/("""
			""")))})),format.raw/*42.5*/("""
			 
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" align="right"><b>Totales</b></td>
				<td><b>"""),_display_(Seq[Any](/*48.13*/utils/*48.18*/.NumberUtils.moneda(totalOrden))),format.raw/*48.49*/("""</b></td>
				<td><b>"""),_display_(Seq[Any](/*49.13*/utils/*49.18*/.NumberUtils.moneda(totalRecepcion))),format.raw/*49.53*/("""</b></td> 
				<td><b>"""),_display_(Seq[Any](/*50.13*/utils/*50.18*/.NumberUtils.moneda(totalDeuda))),format.raw/*50.49*/("""</b></td> 
				<td colspan="2">
				</td>
			</tr>
		</tfoot>
	</table>	

</div>"""))}
    }
    
    def render(lr:List[OrdenProvision]): play.api.templates.HtmlFormat.Appendable = apply(lr)
    
    def f:((List[OrdenProvision]) => play.api.templates.HtmlFormat.Appendable) = (lr) => apply(lr)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/listaExpedientesSinFirma.scala.html
                    HASH: 98decbe8b426a028245d901eeeb2876ea249835f
                    MATRIX: 829->1|1162->251|1194->275|1268->26|1296->319|1524->511|1544->522|1639->594|2071->991|2100->1004|2139->1005|2185->1016|2249->1058|2290->1064|2393->1145|2450->1166|2461->1168|2531->1216|2583->1232|2594->1234|2645->1263|2697->1279|2711->1284|2784->1335|2836->1351|2850->1356|2918->1402|2971->1419|2985->1424|3038->1455|3091->1472|3102->1474|3161->1511|3213->1527|3242->1547|3354->1636|3410->1657|3493->1718|3534->1724|3620->1788|3661->1794|3724->1835|3760->1840|3897->1941|3911->1946|3964->1977|4022->1999|4036->2004|4093->2039|4152->2062|4166->2067|4219->2098
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|55->26|55->26|55->26|57->28|57->28|58->29|58->29|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|68->39|68->39|69->40|69->40|70->41|70->41|71->42|77->48|77->48|77->48|78->49|78->49|78->49|79->50|79->50|79->50
                    -- GENERATED --
                */
            