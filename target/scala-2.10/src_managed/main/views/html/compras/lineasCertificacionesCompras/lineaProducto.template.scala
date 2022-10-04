
package views.html.compras.lineasCertificacionesCompras

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[CertificacionCompraLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CertificacionCompraLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar">
			<a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*6.63*/controllers/*6.74*/.compras.routes.CertificacionesComprasLineasController.editar(linea.id))),format.raw/*6.145*/(""""><i class="glyphicon glyphicon-edit"></i></a>
		</td>
	""")))})),format.raw/*8.3*/("""
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.producto.nombre)),format.raw/*9.28*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*10.38*/if(linea.cuentaAnalitica == null)/*10.71*/{_display_(Seq[Any](format.raw/*10.72*/("""No asociada""")))}/*10.85*/else/*10.90*/{_display_(Seq[Any](_display_(Seq[Any](/*10.92*/linea/*10.97*/.cuentaAnalitica.codigo)),format.raw/*10.120*/(""" """),_display_(Seq[Any](/*10.122*/linea/*10.127*/.cuentaAnalitica.nombre))))})),format.raw/*10.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.cantidad)),format.raw/*11.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.udm.nombre)),format.raw/*12.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*13.49*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/linea/*14.12*/.descuento)),format.raw/*14.22*/("""</td>
	<td>"""),_display_(Seq[Any](/*15.7*/utils/*15.12*/.NumberUtils.moneda(  linea.getTotalDescuento()   ,10))),format.raw/*15.66*/("""</td>
	<td>"""),_display_(Seq[Any](/*16.7*/utils/*16.12*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*16.53*/("""</td>
	"""),_display_(Seq[Any](/*17.3*/if(editable)/*17.15*/{_display_(Seq[Any](format.raw/*17.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*18.65*/controllers/*18.76*/.compras.routes.CertificacionesComprasLineasController.eliminar(linea.id))),format.raw/*18.149*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*19.3*/("""
</tr>"""))}
    }
    
    def render(linea:CertificacionCompraLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((CertificacionCompraLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificacionesCompras/lineaProducto.scala.html
                    HASH: c8f7ede82480acc4bb76d25afbb935b8faf418d0
                    MATRIX: 845->1|991->53|1044->71|1057->76|1081->79|1121->85|1141->97|1179->98|1308->192|1327->203|1420->274|1509->333|1551->341|1564->346|1601->362|1681->406|1723->439|1762->440|1793->453|1806->458|1854->460|1868->465|1914->488|1953->490|1968->495|2019->519|2067->532|2081->537|2112->546|2160->559|2174->564|2207->575|2255->588|2269->593|2328->630|2376->643|2390->648|2422->658|2470->671|2484->676|2560->730|2608->743|2622->748|2685->789|2729->798|2750->810|2789->811|2891->877|2911->888|3007->961|3109->1032
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            