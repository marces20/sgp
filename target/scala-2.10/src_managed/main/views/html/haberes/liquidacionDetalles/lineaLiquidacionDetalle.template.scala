
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
object lineaLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.haberes.LiquidacionDetalle,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(detalle: models.haberes.LiquidacionDetalle, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.65*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/detalle/*3.22*/.id)),format.raw/*3.25*/("""">
		
		<td class="accion-editar">
			"""),_display_(Seq[Any](/*6.5*/if(editable)/*6.17*/{_display_(Seq[Any](format.raw/*6.18*/("""
				<a class="btn btn-default btn-xs modificarLiquidacionDetalle" href=""""),_display_(Seq[Any](/*7.74*/controllers/*7.85*/.haberes.routes.LiquidacionDetallesController.editar(detalle.id))),format.raw/*7.149*/("""">
				<i class="glyphicon glyphicon-edit"></i></a>
			""")))})),format.raw/*9.5*/("""
		</td>
		
	
	<td>"""),_display_(Seq[Any](/*13.7*/detalle/*13.14*/.liquidacionConcepto.codigo)),format.raw/*13.41*/(""" - """),_display_(Seq[Any](/*13.45*/detalle/*13.52*/.liquidacionConcepto.denominacion)),format.raw/*13.85*/("""</td>
	<td align="center">"""),_display_(Seq[Any](/*14.22*/utils/*14.27*/.NumberUtils.formatNumber(detalle.cantidad.doubleValue()))),format.raw/*14.84*/("""</td>
	<td align="center">
		"""),_display_(Seq[Any](/*16.4*/if(detalle.liquidacionConcepto.liquidacionConceptoTipo.id == models.haberes.LiquidacionConceptoTipo.HABERES_CON_APORTE)/*16.123*/{_display_(Seq[Any](format.raw/*16.124*/("""
			"""),_display_(Seq[Any](/*17.5*/utils/*17.10*/.NumberUtils.moneda(detalle.getTotal()))),format.raw/*17.49*/("""
		""")))})),format.raw/*18.4*/("""
		"""),_display_(Seq[Any](/*19.4*/if(detalle.liquidacionConcepto.liquidacionConceptoTipo.id == models.haberes.LiquidacionConceptoTipo.DESCUENTOS)/*19.115*/{_display_(Seq[Any](format.raw/*19.116*/("""
			"""),_display_(Seq[Any](/*20.5*/utils/*20.10*/.NumberUtils.moneda(detalle.getTotal()))),format.raw/*20.49*/("""
		""")))})),format.raw/*21.4*/("""
	</td>
	<td align="center">
		"""),_display_(Seq[Any](/*24.4*/if(detalle.liquidacionConcepto.liquidacionConceptoTipo.id == models.haberes.LiquidacionConceptoTipo.HABERES_SIN_APORTE)/*24.123*/{_display_(Seq[Any](format.raw/*24.124*/("""
			"""),_display_(Seq[Any](/*25.5*/utils/*25.10*/.NumberUtils.moneda(detalle.getTotal()))),format.raw/*25.49*/("""
		""")))})),format.raw/*26.4*/("""
	</td>
	<td align="center">
		"""),_display_(Seq[Any](/*29.4*/if(detalle.liquidacionConcepto.liquidacionConceptoTipo.id == models.haberes.LiquidacionConceptoTipo.RETENCIONES)/*29.116*/{_display_(Seq[Any](format.raw/*29.117*/("""
			"""),_display_(Seq[Any](/*30.5*/utils/*30.10*/.NumberUtils.moneda(detalle.getTotal()))),format.raw/*30.49*/("""
		""")))})),format.raw/*31.4*/("""
	</td>
	<td>
	"""),_display_(Seq[Any](/*34.3*/if(editable)/*34.15*/{_display_(Seq[Any](format.raw/*34.16*/("""	
		<a class="btn btn-default btn-xs eliminarLiquidacionDetalle" href=""""),_display_(Seq[Any](/*35.71*/controllers/*35.82*/.haberes.routes.LiquidacionDetallesController.eliminar(detalle.id))),format.raw/*35.148*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a>
	""")))})),format.raw/*36.3*/("""
	</td>
	
</tr>"""))}
    }
    
    def render(detalle:models.haberes.LiquidacionDetalle,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(detalle,editable)
    
    def f:((models.haberes.LiquidacionDetalle,Boolean) => play.api.templates.HtmlFormat.Appendable) = (detalle,editable) => apply(detalle,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/lineaLiquidacionDetalle.scala.html
                    HASH: 92e5128fa6bf32ebefaa3342f403308db0cd95d7
                    MATRIX: 855->1|1012->64|1065->82|1080->89|1104->92|1180->134|1200->146|1238->147|1348->222|1367->233|1453->297|1541->355|1600->379|1616->386|1665->413|1705->417|1721->424|1776->457|1840->485|1854->490|1933->547|2000->579|2129->698|2169->699|2210->705|2224->710|2285->749|2321->754|2361->759|2482->870|2522->871|2563->877|2577->882|2638->921|2674->926|2744->961|2873->1080|2913->1081|2954->1087|2968->1092|3029->1131|3065->1136|3135->1171|3257->1283|3297->1284|3338->1290|3352->1295|3413->1334|3449->1339|3503->1358|3524->1370|3563->1371|3672->1444|3692->1455|3781->1521|3878->1587
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|37->9|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|44->16|44->16|44->16|45->17|45->17|45->17|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|52->24|52->24|52->24|53->25|53->25|53->25|54->26|57->29|57->29|57->29|58->30|58->30|58->30|59->31|62->34|62->34|62->34|63->35|63->35|63->35|64->36
                    -- GENERATED --
                */
            