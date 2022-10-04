
package views.html.recupero.presupuestoLineas

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.recupero.PresupuestoLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: models.recupero.PresupuestoLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*5.88*/controllers/*5.99*/.recupero.routes.PresupuestoLineasController.editar(linea.id))),format.raw/*5.160*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.producto != null && linea.producto.codigo_ips != null )/*7.71*/{_display_(Seq[Any](_display_(Seq[Any](/*7.73*/linea/*7.78*/.producto.codigo_ips))))})),format.raw/*7.99*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/linea/*8.12*/.producto.nombre)),format.raw/*8.28*/("""</td>
	<!-- <td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*9.43*/if(linea.cuentaAnalitica == null)/*9.76*/{_display_(Seq[Any](format.raw/*9.77*/("""No asociada""")))}/*9.90*/else/*9.95*/{_display_(Seq[Any](_display_(Seq[Any](/*9.97*/linea/*9.102*/.cuentaAnalitica.codigo)),format.raw/*9.125*/(""" """),_display_(Seq[Any](/*9.127*/linea/*9.132*/.cuentaAnalitica.nombre))))})),format.raw/*9.156*/("""</td> -->
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.udm.nombre)),format.raw/*10.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.cantidad)),format.raw/*11.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/utils/*12.12*/.NumberUtils.moneda(linea.precio,2))),format.raw/*12.47*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(linea.getTotal(), 2))),format.raw/*13.52*/("""</td>
	"""),_display_(Seq[Any](/*14.3*/if(editable)/*14.15*/{_display_(Seq[Any](format.raw/*14.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*15.65*/controllers/*15.76*/.recupero.routes.PresupuestoLineasController.eliminar(linea.id))),format.raw/*15.139*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*16.3*/("""
</tr>"""))}
    }
    
    def render(linea:models.recupero.PresupuestoLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((models.recupero.PresupuestoLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuestoLineas/lineaProducto.scala.html
                    HASH: 812fc3d177bc2ba06609355bf4fdb08d46fffb02
                    MATRIX: 843->1|997->61|1050->79|1063->84|1087->87|1127->93|1147->105|1185->106|1309->195|1328->206|1411->267|1496->322|1538->330|1610->394|1657->396|1670->401|1716->422|1763->435|1776->440|1813->456|1897->505|1938->538|1976->539|2006->552|2018->557|2065->559|2079->564|2124->587|2162->589|2176->594|2226->618|2278->635|2292->640|2325->651|2373->664|2387->669|2418->678|2466->691|2480->696|2537->731|2585->744|2599->749|2661->789|2705->798|2726->810|2765->811|2867->877|2887->888|2973->951|3075->1022
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16
                    -- GENERATED --
                */
            