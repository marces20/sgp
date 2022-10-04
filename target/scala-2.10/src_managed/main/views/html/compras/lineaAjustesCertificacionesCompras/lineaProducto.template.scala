
package views.html.compras.lineaAjustesCertificacionesCompras

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[CertificacionesComprasLineaAjustes,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CertificacionesComprasLineaAjustes, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.64*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	
	<td>"""),_display_(Seq[Any](/*5.7*/linea/*5.12*/.producto.nombre)),format.raw/*5.28*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*6.38*/if(linea.cuentaAnalitica == null)/*6.71*/{_display_(Seq[Any](format.raw/*6.72*/("""No asociada""")))}/*6.85*/else/*6.90*/{_display_(Seq[Any](_display_(Seq[Any](/*6.92*/linea/*6.97*/.cuentaAnalitica.codigo)),format.raw/*6.120*/(""" """),_display_(Seq[Any](/*6.122*/linea/*6.127*/.cuentaAnalitica.nombre))))})),format.raw/*6.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*7.7*/linea/*7.12*/.udm.nombre)),format.raw/*7.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/linea/*8.12*/.cantidad)),format.raw/*8.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/utils/*9.12*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*9.49*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/utils/*10.12*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*10.53*/("""</td>
</tr>"""))}
    }
    
    def render(linea:CertificacionesComprasLineaAjustes,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((CertificacionesComprasLineaAjustes,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineaAjustesCertificacionesCompras/lineaProducto.scala.html
                    HASH: 63d83886de818e80bf9611e864bd3d0211057c61
                    MATRIX: 861->1|1017->63|1070->81|1083->86|1107->89|1154->102|1167->107|1204->123|1283->167|1324->200|1362->201|1392->214|1404->219|1451->221|1464->226|1509->249|1547->251|1561->256|1611->280|1658->293|1671->298|1703->309|1750->322|1763->327|1793->336|1840->349|1853->354|1911->391|1959->404|1973->409|2036->450
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10
                    -- GENERATED --
                */
            