
package views.html.compras.cajaChica.presupuestoLineas

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
object lineaPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[CajaChicaPresupuestoLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CajaChicaPresupuestoLinea,  editable: Boolean = false):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.64*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*4.38*/if(linea.cuentaAnalitica == null)/*4.71*/{_display_(Seq[Any](format.raw/*4.72*/("""No asociada""")))}/*4.85*/else/*4.90*/{_display_(Seq[Any](_display_(Seq[Any](/*4.92*/linea/*4.97*/.cuentaAnalitica.codigo)),format.raw/*4.120*/(""" """),_display_(Seq[Any](/*4.122*/linea/*4.127*/.cuentaAnalitica.nombre))))})),format.raw/*4.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*5.7*/utils/*5.12*/.NumberUtils.moneda(linea.monto, 10))),format.raw/*5.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*6.7*/if(linea.ajuste)/*6.23*/{_display_(Seq[Any](format.raw/*6.24*/("""AJUSTE""")))}/*6.31*/else/*6.35*/{_display_(Seq[Any](format.raw/*6.36*/("""INICIAL""")))})),format.raw/*6.44*/("""</td>
</tr>

"""))}
    }
    
    def render(linea:CajaChicaPresupuestoLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((CajaChicaPresupuestoLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/presupuestoLineas/lineaPresupuesto.scala.html
                    HASH: bd4ddc9a9352a56871899769f981bcb7e746ccfa
                    MATRIX: 848->1|1004->63|1057->81|1070->86|1094->89|1170->130|1211->163|1249->164|1279->177|1291->182|1338->184|1351->189|1396->212|1434->214|1448->219|1498->243|1545->256|1558->261|1615->297|1662->310|1686->326|1724->327|1749->334|1761->338|1799->339|1838->347
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6
                    -- GENERATED --
                */
            