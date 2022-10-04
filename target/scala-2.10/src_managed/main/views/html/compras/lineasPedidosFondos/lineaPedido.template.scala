
package views.html.compras.lineasPedidosFondos

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
object lineaPedido extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[PedidoFondoLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: PedidoFondoLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.46*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarPedido" href=""""),_display_(Seq[Any](/*5.86*/controllers/*5.97*/.compras.routes.LineasPedidosFondosController.editar(linea.id))),format.raw/*5.159*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/linea/*7.12*/.expediente.nombre)),format.raw/*7.30*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/if(linea.proveedor != null)/*8.34*/{_display_(Seq[Any](_display_(Seq[Any](/*8.36*/linea/*8.41*/.proveedor.nombre))))})),format.raw/*8.59*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/utils/*9.12*/.NumberUtils.moneda(linea.monto, 10))),format.raw/*9.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.concepto)),format.raw/*10.21*/("""</td>
	"""),_display_(Seq[Any](/*11.3*/if(editable)/*11.15*/{_display_(Seq[Any](format.raw/*11.16*/("""
		<td><a class="btn btn-default btn-xs eliminarPedido" href=""""),_display_(Seq[Any](/*12.63*/controllers/*12.74*/.compras.routes.LineasPedidosFondosController.eliminar(linea.id))),format.raw/*12.138*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*13.3*/("""
</tr>"""))}
    }
    
    def render(linea:PedidoFondoLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((PedidoFondoLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasPedidosFondos/lineaPedido.scala.html
                    HASH: 7e18a5a4326652133b4bd51abb98433f8cdc1403
                    MATRIX: 826->1|964->45|1017->63|1030->68|1054->71|1094->77|1114->89|1152->90|1274->177|1293->188|1377->250|1462->305|1504->313|1517->318|1556->336|1603->349|1638->376|1685->378|1698->383|1741->401|1788->414|1801->419|1858->455|1906->468|1920->473|1951->482|1995->491|2016->503|2055->504|2155->568|2175->579|2262->643|2364->714
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13
                    -- GENERATED --
                */
            