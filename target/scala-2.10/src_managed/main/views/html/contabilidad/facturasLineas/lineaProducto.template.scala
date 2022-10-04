
package views.html.contabilidad.facturasLineas

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[FacturaLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: FacturaLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*5.61*/linea/*5.66*/.id)),format.raw/*5.69*/("""" class="check_listado notSeleccion" id="check-"""),_display_(Seq[Any](/*5.117*/linea/*5.122*/.id)),format.raw/*5.125*/(""""/></td>
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*6.88*/controllers/*6.99*/.contabilidad.routes.FacturasLineasController.editar(linea.id))),format.raw/*6.161*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
	<td>"""),_display_(Seq[Any](/*8.7*/linea/*8.12*/.producto.nombre)),format.raw/*8.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/if(linea.cuenta == null)/*9.31*/{_display_(Seq[Any](format.raw/*9.32*/("""No asociada""")))}/*9.45*/else/*9.50*/{_display_(Seq[Any](_display_(Seq[Any](/*9.52*/linea/*9.57*/.cuenta.nombre))))})),format.raw/*9.72*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/if(linea.cuentaAnalitica == null)/*10.40*/{_display_(Seq[Any](format.raw/*10.41*/("""No asociada""")))}/*10.54*/else/*10.59*/{_display_(Seq[Any](_display_(Seq[Any](/*10.61*/linea/*10.66*/.cuentaAnalitica.codigo)),format.raw/*10.89*/(""" """),_display_(Seq[Any](/*10.91*/linea/*10.96*/.cuentaAnalitica.nombre))))})),format.raw/*10.120*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.cuentaAnaliticaOriginal == null)/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/("""No asociada""")))}/*11.62*/else/*11.67*/{_display_(Seq[Any](_display_(Seq[Any](/*11.69*/linea/*11.74*/.cuentaAnaliticaOriginal.codigo)),format.raw/*11.105*/(""" """),_display_(Seq[Any](/*11.107*/linea/*11.112*/.cuentaAnaliticaOriginal.nombre))))})),format.raw/*11.144*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/utils/*12.12*/.NumberUtils.formatNumber(linea.cantidad.doubleValue()))),format.raw/*12.67*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/linea/*13.12*/.udm.nombre)),format.raw/*13.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.NumberUtils.moneda(linea.precio))),format.raw/*14.45*/("""</td>
	<td>"""),_display_(Seq[Any](/*15.7*/linea/*15.12*/.descuento)),format.raw/*15.22*/("""</td>
	<td>"""),_display_(Seq[Any](/*16.7*/utils/*16.12*/.NumberUtils.moneda(linea.getTotalDescuento()))),format.raw/*16.58*/("""</td>
	<td>"""),_display_(Seq[Any](/*17.7*/utils/*17.12*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*17.49*/("""</td>
	"""),_display_(Seq[Any](/*18.3*/if(editable)/*18.15*/{_display_(Seq[Any](format.raw/*18.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*19.65*/controllers/*19.76*/.contabilidad.routes.FacturasLineasController.eliminar(linea.id))),format.raw/*19.140*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*20.3*/("""
</tr>
"""))}
    }
    
    def render(linea:FacturaLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((FacturaLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineas/lineaProducto.scala.html
                    HASH: eb8971ccc56a3fee928bb5b6995972768dec6fa8
                    MATRIX: 824->1|958->41|1011->59|1024->64|1048->67|1088->73|1108->85|1146->86|1243->148|1256->153|1280->156|1364->204|1378->209|1403->212|1535->309|1554->320|1638->382|1723->437|1765->445|1778->450|1815->466|1862->479|1894->503|1932->504|1962->517|1974->522|2021->524|2034->529|2074->544|2122->557|2164->590|2203->591|2234->604|2247->609|2295->611|2309->616|2354->639|2392->641|2406->646|2457->670|2505->683|2555->724|2594->725|2625->738|2638->743|2686->745|2700->750|2754->781|2793->783|2808->788|2867->820|2915->833|2929->838|3006->893|3054->906|3068->911|3101->922|3149->935|3163->940|3218->973|3266->986|3280->991|3312->1001|3360->1014|3374->1019|3442->1065|3490->1078|3504->1083|3563->1120|3607->1129|3628->1141|3667->1142|3769->1208|3789->1219|3876->1283|3978->1354
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20
                    -- GENERATED --
                */
            