
package views.html.dashboard.impuestos.vistas

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
object detalleImpuestos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[java.util.Map[Long, java.util.List[Pago]],java.util.Map[Long, String],String,java.util.Map[Long, java.math.BigDecimal],java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listPago: java.util.Map[Long,java.util.List[Pago]],
mapPeriodo: java.util.Map[Long,String],nombreCuenta:String,totalPeriodo: java.util.Map[Long,java.math.BigDecimal],total:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.142*/("""
<hr>
<table class="table table-bordered">
		<tr>
			<td colspan="7" align="center"><b style="font-size: 18px;">"""),_display_(Seq[Any](/*6.64*/nombreCuenta)),format.raw/*6.76*/("""</b></td>
		</tr>
	"""),_display_(Seq[Any](/*8.3*/for((key,value) <- listPago) yield /*8.31*/ {_display_(Seq[Any](format.raw/*8.33*/("""
		
		<tr>
			<td colspan="7" align="center"><b>"""),_display_(Seq[Any](/*11.39*/mapPeriodo/*11.49*/.get(key))),format.raw/*11.58*/("""</b></td>
		</tr>
		<tr>
			<td>#</td>
			<td><b>Proveedor</b></td>
			<td align="center"><b>Fecha Pago</b></td>
			<td align="center"><b>Expediente</b></td>
			<td align="center"><b>OP</b></td>
			<td align="center"><b>Cuenta</b></td>
			<td align="center"><b>Total</b></td>
			
		</tr>
		"""),_display_(Seq[Any](/*23.4*/for(pago <- value) yield /*23.22*/ {_display_(Seq[Any](format.raw/*23.24*/("""
			<tr>
				<td>
					<a class="btn btn-default btn-xs" target="_blank" href=""""),_display_(Seq[Any](/*26.63*/controllers/*26.74*/.contabilidad.routes.PagosController.ver(pago.id))),format.raw/*26.123*/("""">
						<i class="glyphicon glyphicon-list"></i>
					</a>
				</td>
				<td>"""),_display_(Seq[Any](/*30.10*/pago/*30.14*/.factura.proveedor.nombre)),format.raw/*30.39*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*31.25*/if(pago.fecha_pago != null)/*31.52*/{_display_(Seq[Any](_display_(Seq[Any](/*31.54*/(utils.DateUtils.formatDate(pago.fecha_pago))))))})),format.raw/*31.100*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*32.25*/pago/*32.29*/.expediente.getExpedienteEjercicio())),format.raw/*32.65*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*33.25*/pago/*33.29*/.ordenPago.numero)),format.raw/*33.46*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*34.25*/if(pago.tipoCuenta != null)/*34.52*/{_display_(Seq[Any](_display_(Seq[Any](/*34.54*/pago/*34.58*/.tipoCuenta.nombre))))})),format.raw/*34.77*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*35.25*/utils/*35.30*/.NumberUtils.moneda(pago.total))),format.raw/*35.61*/("""</td>
			</tr>	
		""")))})),format.raw/*37.4*/("""
		<tr>
			<td colspan="6" align="right"><b>SUB-TOTAL</b></td>
			<td>"""),_display_(Seq[Any](/*40.9*/utils/*40.14*/.NumberUtils.moneda(totalPeriodo.get(key)))),format.raw/*40.56*/("""</td>
		</tr>
	""")))})),format.raw/*42.3*/("""
	<tr>
		<td colspan="7" align="center"><b style="font-size: 20px;">TOTAL """),_display_(Seq[Any](/*44.69*/utils/*44.74*/.NumberUtils.moneda(total))),format.raw/*44.100*/("""</b></td>
	</tr>		
</table>"""))}
    }
    
    def render(listPago:java.util.Map[Long, java.util.List[Pago]],mapPeriodo:java.util.Map[Long, String],nombreCuenta:String,totalPeriodo:java.util.Map[Long, java.math.BigDecimal],total:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(listPago,mapPeriodo,nombreCuenta,totalPeriodo,total)
    
    def f:((java.util.Map[Long, java.util.List[Pago]],java.util.Map[Long, String],String,java.util.Map[Long, java.math.BigDecimal],java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (listPago,mapPeriodo,nombreCuenta,totalPeriodo,total) => apply(listPago,mapPeriodo,nombreCuenta,totalPeriodo,total)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/impuestos/vistas/detalleImpuestos.scala.html
                    HASH: 6f77dd3d16a7d46e52432230e944c1a802c72804
                    MATRIX: 945->1|1234->195|1382->308|1415->320|1469->340|1512->368|1551->370|1636->419|1655->429|1686->438|2012->729|2046->747|2086->749|2202->829|2222->840|2294->889|2409->968|2422->972|2469->997|2535->1027|2571->1054|2619->1056|2692->1102|2758->1132|2771->1136|2829->1172|2895->1202|2908->1206|2947->1223|3013->1253|3049->1280|3097->1282|3110->1286|3155->1305|3221->1335|3235->1340|3288->1371|3338->1390|3444->1461|3458->1466|3522->1508|3569->1524|3680->1599|3694->1604|3743->1630
                    LINES: 26->1|30->2|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|51->23|51->23|51->23|54->26|54->26|54->26|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|65->37|68->40|68->40|68->40|70->42|72->44|72->44|72->44
                    -- GENERATED --
                */
            