
package views.html.contabilidad.ordenesPagosCircuitosLineas

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
object lineaOrdenPagoCircuitoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[OrdenPagoCircuitoLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: OrdenPagoCircuitoLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	<td>"""),_display_(Seq[Any](/*4.7*/if(linea.id == null)/*4.27*/{_display_(Seq[Any](format.raw/*4.28*/("""No asociada""")))}/*4.41*/else/*4.46*/{_display_(Seq[Any](_display_(Seq[Any](/*4.48*/linea/*4.53*/.id))))})),format.raw/*4.57*/("""</td>
	<td>"""),_display_(Seq[Any](/*5.7*/if(linea.pago == null)/*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""No asociado""")))}/*5.43*/else/*5.48*/{_display_(Seq[Any](_display_(Seq[Any](/*5.50*/linea/*5.55*/.pago.nombre))))})),format.raw/*5.68*/("""</td>
	<td>"""),_display_(Seq[Any](/*6.7*/if(linea.pago == null)/*6.29*/{_display_(Seq[Any](format.raw/*6.30*/("""No asociado""")))}/*6.43*/else/*6.48*/{_display_(Seq[Any](_display_(Seq[Any](/*6.50*/linea/*6.55*/.pago.proveedor.nombre))))})),format.raw/*6.78*/("""</td>
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.pago.periodo != null)/*7.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*7.40*/linea/*7.45*/.pago.periodo.nombre))))})),format.raw/*7.66*/("""</td>
	<td class="total" rel=""""),_display_(Seq[Any](/*8.26*/linea/*8.31*/.pago.total)),format.raw/*8.42*/("""">"""),_display_(Seq[Any](/*8.45*/(utils.NumberUtils.moneda(linea.pago.total)))),format.raw/*8.89*/("""</td>
</tr>"""))}
    }
    
    def render(linea:OrdenPagoCircuitoLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((OrdenPagoCircuitoLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitosLineas/lineaOrdenPagoCircuitoLinea.scala.html
                    HASH: dc85d2d80b8e587b77ee2947821261bf2d53c804
                    MATRIX: 853->1|978->32|1031->50|1044->55|1068->58|1112->68|1140->88|1178->89|1208->102|1220->107|1267->109|1280->114|1309->118|1356->131|1386->153|1424->154|1454->167|1466->172|1513->174|1526->179|1564->192|1611->205|1641->227|1679->228|1709->241|1721->246|1768->248|1781->253|1829->276|1876->289|1914->319|1962->322|1975->327|2021->348|2088->380|2101->385|2133->396|2171->399|2236->443
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8
                    -- GENERATED --
                */
            