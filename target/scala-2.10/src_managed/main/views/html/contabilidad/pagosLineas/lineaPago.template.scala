
package views.html.contabilidad.pagosLineas

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
object lineaPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[PagoLinea,Boolean,Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: PagoLinea, editable: Boolean,pago:Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.49*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable && pago.estado_id == models.Estado.PAGO_ESTADO_BORRADOR)/*4.71*/{_display_(Seq[Any](format.raw/*4.72*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarPago" href=""""),_display_(Seq[Any](/*5.84*/controllers/*5.95*/.contabilidad.routes.PagosLineasController.editar(linea.id))),format.raw/*5.154*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.pago == null)/*7.29*/{_display_(Seq[Any](format.raw/*7.30*/("""No asociado""")))}/*7.43*/else/*7.48*/{_display_(Seq[Any](_display_(Seq[Any](/*7.50*/linea/*7.55*/.pago.proveedor.nombre))))})),format.raw/*7.78*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/if(linea.cuenta == null)/*8.31*/{_display_(Seq[Any](format.raw/*8.32*/("""No asociada""")))}/*8.45*/else/*8.50*/{_display_(Seq[Any](_display_(Seq[Any](/*8.52*/linea/*8.57*/.cuenta.nombre))))})),format.raw/*8.72*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/if(linea.cuentaAnalitica == null)/*9.40*/{_display_(Seq[Any](format.raw/*9.41*/("""No asociada""")))}/*9.54*/else/*9.59*/{_display_(Seq[Any](_display_(Seq[Any](/*9.61*/linea/*9.66*/.cuentaAnalitica.codigo)),format.raw/*9.89*/(""" """),_display_(Seq[Any](/*9.91*/linea/*9.96*/.cuentaAnalitica.nombre))))})),format.raw/*9.120*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/if(linea.periodo == null)/*10.32*/{_display_(Seq[Any](format.raw/*10.33*/("""No asociado""")))}/*10.46*/else/*10.51*/{_display_(Seq[Any](_display_(Seq[Any](/*10.53*/linea/*10.58*/.periodo.nombre))))})),format.raw/*10.74*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.pago == null)/*11.29*/{_display_(Seq[Any](format.raw/*11.30*/("""No asociado""")))}/*11.43*/else/*11.48*/{_display_(Seq[Any](_display_(Seq[Any](/*11.50*/utils/*11.55*/.DateUtils.formatDate(linea.pago.fecha_pago)))))})),format.raw/*11.100*/("""</td>
	<!--<td> """),_display_(Seq[Any](/*12.12*/utils/*12.17*/.NumberUtils.moneda(linea.monto_original, 10))),format.raw/*12.62*/(""" </td>-->
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(linea.monto, 2))),format.raw/*13.47*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.NumberUtils.moneda(linea.monto_credito, 2))),format.raw/*14.55*/("""</td>
	"""),_display_(Seq[Any](/*15.3*/if(editable && pago.estado_id == models.Estado.PAGO_ESTADO_BORRADOR)/*15.71*/{_display_(Seq[Any](format.raw/*15.72*/("""
		<td><a class="btn btn-default btn-xs eliminarPago" href=""""),_display_(Seq[Any](/*16.61*/controllers/*16.72*/.contabilidad.routes.PagosLineasController.eliminar(linea.id))),format.raw/*16.133*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*17.3*/("""
</tr>"""))}
    }
    
    def render(linea:PagoLinea,editable:Boolean,pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,pago)
    
    def f:((PagoLinea,Boolean,Pago) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,pago) => apply(linea,editable,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagosLineas/lineaPago.scala.html
                    HASH: c8d75789e6ec6f3c8eb2d998753f993faf85485e
                    MATRIX: 819->1|960->48|1013->66|1026->71|1050->74|1090->80|1166->148|1204->149|1324->234|1343->245|1424->304|1509->359|1551->367|1581->389|1619->390|1649->403|1661->408|1708->410|1721->415|1769->438|1816->451|1848->475|1886->476|1916->489|1928->494|1975->496|1988->501|2028->516|2075->529|2116->562|2154->563|2184->576|2196->581|2243->583|2256->588|2300->611|2337->613|2350->618|2400->642|2448->655|2482->680|2521->681|2552->694|2565->699|2613->701|2627->706|2669->722|2717->735|2748->757|2787->758|2818->771|2831->776|2879->778|2893->783|2965->828|3019->846|3033->851|3100->896|3152->913|3166->918|3223->953|3271->966|3285->971|3350->1014|3394->1023|3471->1091|3510->1092|3608->1154|3628->1165|3712->1226|3814->1297
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            