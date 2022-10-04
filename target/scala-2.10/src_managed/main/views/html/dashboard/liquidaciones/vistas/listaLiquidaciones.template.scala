
package views.html.dashboard.liquidaciones.vistas

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
object listaLiquidaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[java.util.List[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lp: java.util.List[models.haberes.LiquidacionPuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*5.70*/("""

<table class="table table-bordered">
	<thead>
		<tr>
			<th align="center">N° Liq.</th>	
			<th align="center">Periodo</th>		
			<th align="center">Total C/A</th>	
			<th align="center">Total S/A</th>	
			<th align="center">Total Ret.</th>	
			<th  align="center">Total A Cobrar</th>		
			<th  align="center">Recibo</th>	
		</tr>
	</thead>					
	"""),_display_(Seq[Any](/*19.3*/for(x <- lp) yield /*19.15*/{_display_(Seq[Any](format.raw/*19.16*/("""
		<tr class="trUltimasLiquidaciones pointer" data-url=""""),_display_(Seq[Any](/*20.57*/controllers/*20.68*/.haberes.routes.LiquidacionDetallesController.index(x.id, false))),format.raw/*20.132*/("""">
			<td align="center">"""),_display_(Seq[Any](/*21.24*/x/*21.25*/.liquidacionMes.nro_liquidacion_parque)),format.raw/*21.63*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*22.24*/x/*22.25*/.liquidacionMes.periodo.nombre)),format.raw/*22.55*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*23.24*/utils/*23.29*/.NumberUtils.moneda(x.getTotalCA()))),format.raw/*23.64*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*24.24*/utils/*24.29*/.NumberUtils.moneda(x.getTotalSA()))),format.raw/*24.64*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*25.24*/utils/*25.29*/.NumberUtils.moneda(x.getTotalRetenciones()))),format.raw/*25.73*/("""</td>
			<td align="center"><b>"""),_display_(Seq[Any](/*26.27*/utils/*26.32*/.NumberUtils.moneda(x.getTotalACobrar()))),format.raw/*26.72*/("""</b></td>
			<td align="center" class="notSeleccion">
				<a id="reporteReciboSueldo"  href="#" data-url=""""),_display_(Seq[Any](/*28.54*/controllers/*28.65*/.haberes.routes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(x.id))),format.raw/*28.145*/(""""><i class="glyphicon glyphicon-list-alt"></i></a>
			</td>
		</tr>
	""")))})),format.raw/*31.3*/("""
</table>"""))}
    }
    
    def render(lp:java.util.List[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(lp)
    
    def f:((java.util.List[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (lp) => apply(lp)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:02 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/vistas/listaLiquidaciones.scala.html
                    HASH: 31fd40b4a8379cc682e2e4443940b90256f20d25
                    MATRIX: 860->1|1054->112|1086->136|1160->55|1188->180|1572->529|1600->541|1639->542|1732->599|1752->610|1839->674|1901->700|1911->701|1971->739|2036->768|2046->769|2098->799|2163->828|2177->833|2234->868|2299->897|2313->902|2370->937|2435->966|2449->971|2515->1015|2583->1047|2597->1052|2659->1092|2802->1199|2822->1210|2925->1290|3026->1360
                    LINES: 26->1|33->5|33->5|34->1|35->5|49->19|49->19|49->19|50->20|50->20|50->20|51->21|51->21|51->21|52->22|52->22|52->22|53->23|53->23|53->23|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|58->28|58->28|58->28|61->31
                    -- GENERATED --
                */
            