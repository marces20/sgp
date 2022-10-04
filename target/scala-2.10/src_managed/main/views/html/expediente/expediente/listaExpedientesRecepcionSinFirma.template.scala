
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
object listaExpedientesRecepcionSinFirma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[OrdenProvision],play.api.templates.HtmlFormat.Appendable] {

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
			<tr><td colspan="7" align="left"> <a href=""""),_display_(Seq[Any](/*11.48*/controllers/*11.59*/.expediente.routes.ExpedientesController.getExpedientesRecepcionSinFirmaReporte())),format.raw/*11.140*/("""" ><span id="getExpedientesRecepcionSinFirmaReporte" 
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/listaExpedientesRecepcionSinFirma.scala.html
                    HASH: 0b45b8fd39e4ae08a5c8e6f8ca3935d6d0aa6d36
                    MATRIX: 838->1|1171->251|1203->275|1277->26|1305->319|1533->511|1553->522|1657->603|2089->1000|2118->1013|2157->1014|2203->1025|2267->1067|2308->1073|2411->1154|2468->1175|2479->1177|2549->1225|2601->1241|2612->1243|2663->1272|2715->1288|2729->1293|2802->1344|2854->1360|2868->1365|2936->1411|2989->1428|3003->1433|3056->1464|3109->1481|3120->1483|3179->1520|3231->1536|3260->1556|3372->1645|3428->1666|3511->1727|3552->1733|3638->1797|3679->1803|3742->1844|3778->1849|3915->1950|3929->1955|3982->1986|4040->2008|4054->2013|4111->2048|4170->2071|4184->2076|4237->2107
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|55->26|55->26|55->26|57->28|57->28|58->29|58->29|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|68->39|68->39|69->40|69->40|70->41|70->41|71->42|77->48|77->48|77->48|78->49|78->49|78->49|79->50|79->50|79->50
                    -- GENERATED --
                */
            