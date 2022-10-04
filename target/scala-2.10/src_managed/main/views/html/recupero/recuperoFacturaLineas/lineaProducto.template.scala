
package views.html.recupero.recuperoFacturaLineas

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.recupero.RecuperoFacturaLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: models.recupero.RecuperoFacturaLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.66*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*5.88*/controllers/*5.99*/.recupero.routes.RecuperoFacturaLineasController.editar(linea.id))),format.raw/*5.164*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.producto != null && linea.producto.codigo_ips != null )/*7.71*/{_display_(Seq[Any](_display_(Seq[Any](/*7.73*/linea/*7.78*/.producto.codigo_ips))))})),format.raw/*7.99*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/linea/*8.12*/.producto.nombre)),format.raw/*8.28*/("""</td>
	<!-- <td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*9.43*/if(linea.cuentaAnalitica == null)/*9.76*/{_display_(Seq[Any](format.raw/*9.77*/("""No asociada""")))}/*9.90*/else/*9.95*/{_display_(Seq[Any](_display_(Seq[Any](/*9.97*/linea/*9.102*/.cuentaAnalitica.codigo)),format.raw/*9.125*/(""" """),_display_(Seq[Any](/*9.127*/linea/*9.132*/.cuentaAnalitica.nombre))))})),format.raw/*9.156*/("""</td> -->
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.udm.nombre)),format.raw/*10.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.cantidad)),format.raw/*11.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/utils/*12.12*/.NumberUtils.moneda(linea.precio, 2))),format.raw/*12.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(linea.getTotal(), 2))),format.raw/*13.52*/("""</td>
	"""),_display_(Seq[Any](/*14.3*/if(editable)/*14.15*/{_display_(Seq[Any](format.raw/*14.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto delete-confirm-link" href=""""),_display_(Seq[Any](/*15.85*/controllers/*15.96*/.recupero.routes.RecuperoFacturaLineasController.eliminar(linea.id))),format.raw/*15.163*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*16.3*/("""
</tr>"""))}
    }
    
    def render(linea:models.recupero.RecuperoFacturaLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((models.recupero.RecuperoFacturaLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFacturaLineas/lineaProducto.scala.html
                    HASH: fade37f89ad9105e7bf144c24c9a47dfef10235e
                    MATRIX: 851->1|1009->65|1062->83|1075->88|1099->91|1139->97|1159->109|1197->110|1321->199|1340->210|1427->275|1512->330|1554->338|1626->402|1673->404|1686->409|1732->430|1779->443|1792->448|1829->464|1913->513|1954->546|1992->547|2022->560|2034->565|2081->567|2095->572|2140->595|2178->597|2192->602|2242->626|2294->643|2308->648|2341->659|2389->672|2403->677|2434->686|2482->699|2496->704|2554->740|2602->753|2616->758|2678->798|2722->807|2743->819|2782->820|2904->906|2924->917|3014->984|3116->1055
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16
                    -- GENERATED --
                */
            