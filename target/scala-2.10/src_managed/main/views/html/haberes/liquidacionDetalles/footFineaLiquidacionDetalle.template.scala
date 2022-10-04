
package views.html.haberes.liquidacionDetalles

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
object footFineaLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.haberes.LiquidacionPuesto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lc:  models.haberes.LiquidacionPuesto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""



<tr>
	<td colspan="3" align="right"> <b>TOTALES</b></td>
	<td align="center"><b>"""),_display_(Seq[Any](/*7.25*/utils/*7.30*/.NumberUtils.moneda(lc.getTotalCA()))),format.raw/*7.66*/("""</b></td>
	<td align="center"><b>"""),_display_(Seq[Any](/*8.25*/utils/*8.30*/.NumberUtils.moneda(lc.getTotalSA() ))),format.raw/*8.67*/("""</b></td>
	<td align="center"><b>"""),_display_(Seq[Any](/*9.25*/utils/*9.30*/.NumberUtils.moneda(lc.getTotalRetenciones() ))),format.raw/*9.76*/("""</b></td>
	<td></td>
</tr>

<tr>
	<td colspan="3" align="right"> <b style="font-size: 20px;color:green;">IMPORTE A COBRAR</b></td>
	<td colspan="3" align="center"><b style="font-size: 20px;color:green;">"""),_display_(Seq[Any](/*15.74*/utils/*15.79*/.NumberUtils.moneda(lc.getTotalACobrar()))),format.raw/*15.120*/("""</b></td>
	<td></td>
</tr>

"""))}
    }
    
    def render(lc:models.haberes.LiquidacionPuesto): play.api.templates.HtmlFormat.Appendable = apply(lc)
    
    def f:((models.haberes.LiquidacionPuesto) => play.api.templates.HtmlFormat.Appendable) = (lc) => apply(lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/footFineaLiquidacionDetalle.scala.html
                    HASH: cf725948f9a07c2e295f7ef00569290e224875be
                    MATRIX: 850->1|983->40|1103->125|1116->130|1173->166|1242->200|1255->205|1313->242|1382->276|1395->281|1462->327|1702->531|1716->536|1780->577
                    LINES: 26->1|29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|43->15|43->15|43->15
                    -- GENERATED --
                */
            