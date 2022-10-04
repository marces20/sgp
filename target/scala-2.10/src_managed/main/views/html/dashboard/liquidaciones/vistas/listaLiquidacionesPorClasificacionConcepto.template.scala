
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
object listaLiquidacionesPorClasificacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[java.util.List[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

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
			<th align="center">Haber Contrato</th>
			<th align="center">Adicionales</th>		
			<th align="center">Guardias</th>	
			<th align="center">Produccion</th>	
			<th align="center">Descuentos Ley</th>	
			<th align="center">Total a cobrar</th>
			<th align="center">Recibo</th>
		</tr>
	</thead>					
	"""),_display_(Seq[Any](/*21.3*/for(x <- lp) yield /*21.15*/{_display_(Seq[Any](format.raw/*21.16*/("""
		<tr class="trUltimasLiquidaciones pointer" data-url=""""),_display_(Seq[Any](/*22.57*/controllers/*22.68*/.haberes.routes.LiquidacionDetallesController.index(x.id, false))),format.raw/*22.132*/("""">
			<td align="center">"""),_display_(Seq[Any](/*23.24*/x/*23.25*/.liquidacionMes.nro_liquidacion_parque)),format.raw/*23.63*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*24.24*/x/*24.25*/.liquidacionMes.periodo.nombre)),format.raw/*24.55*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*25.24*/utils/*25.29*/.NumberUtils.moneda(x.getTotalClasificacionHaberContrato()))),format.raw/*25.88*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*26.24*/utils/*26.29*/.NumberUtils.moneda(x.getTotalClasificacionAdicional()))),format.raw/*26.84*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*27.24*/utils/*27.29*/.NumberUtils.moneda(x.getTotalClasificacionGuardia()))),format.raw/*27.82*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*28.24*/utils/*28.29*/.NumberUtils.moneda(x.getTotalClasificacionProduccion()))),format.raw/*28.85*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*29.24*/utils/*29.29*/.NumberUtils.moneda(x.getTotalClasificacionDescuento()))),format.raw/*29.84*/("""</td>
			<td align="center">"""),_display_(Seq[Any](/*30.24*/utils/*30.29*/.NumberUtils.moneda(x.getTotalACobrar()))),format.raw/*30.69*/("""</td>
			<td align="center" class="notSeleccion">
				<a id="reporteReciboSueldo"  href="#" data-url=""""),_display_(Seq[Any](/*32.54*/controllers/*32.65*/.haberes.routes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(x.id))),format.raw/*32.145*/(""""><i class="glyphicon glyphicon-list-alt"></i></a>
			</td>
		</tr>
	""")))})),format.raw/*35.3*/("""
</table>"""))}
    }
    
    def render(lp:java.util.List[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(lp)
    
    def f:((java.util.List[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (lp) => apply(lp)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:02 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/vistas/listaLiquidacionesPorClasificacionConcepto.scala.html
                    HASH: 5099430bad6b118140f44c6dfe7f978367ba163b
                    MATRIX: 884->1|1078->112|1110->136|1184->55|1212->180|1678->611|1706->623|1745->624|1838->681|1858->692|1945->756|2007->782|2017->783|2077->821|2142->850|2152->851|2204->881|2269->910|2283->915|2364->974|2429->1003|2443->1008|2520->1063|2585->1092|2599->1097|2674->1150|2739->1179|2753->1184|2831->1240|2896->1269|2910->1274|2987->1329|3052->1358|3066->1363|3128->1403|3267->1506|3287->1517|3390->1597|3491->1667
                    LINES: 26->1|33->5|33->5|34->1|35->5|51->21|51->21|51->21|52->22|52->22|52->22|53->23|53->23|53->23|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|57->27|57->27|57->27|58->28|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|62->32|62->32|62->32|65->35
                    -- GENERATED --
                */
            