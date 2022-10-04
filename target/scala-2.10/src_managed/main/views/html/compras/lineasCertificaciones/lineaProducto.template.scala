
package views.html.compras.lineasCertificaciones

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[CertificacionLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CertificacionLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*5.88*/controllers/*5.99*/.compras.routes.LineasCertificacionesController.editar(linea.id))),format.raw/*5.163*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/linea/*7.12*/.producto.nombre)),format.raw/*7.28*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*8.38*/if(linea.cuentaAnalitica == null)/*8.71*/{_display_(Seq[Any](format.raw/*8.72*/("""No asociada""")))}/*8.85*/else/*8.90*/{_display_(Seq[Any](_display_(Seq[Any](/*8.92*/linea/*8.97*/.cuentaAnalitica.codigo)),format.raw/*8.120*/(""" """),_display_(Seq[Any](/*8.122*/linea/*8.127*/.cuentaAnalitica.nombre))))})),format.raw/*8.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.cantidad)),format.raw/*9.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.udm.nombre)),format.raw/*10.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/utils/*11.12*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*11.49*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.descuento)),format.raw/*12.22*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(  linea.getTotalDescuento()   ,10))),format.raw/*13.66*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*14.53*/("""</td>
	"""),_display_(Seq[Any](/*15.3*/if(editable)/*15.15*/{_display_(Seq[Any](format.raw/*15.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*16.65*/controllers/*16.76*/.compras.routes.LineasCertificacionesController.eliminar(linea.id))),format.raw/*16.142*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*17.3*/("""
</tr>"""))}
    }
    
    def render(linea:CertificacionLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((CertificacionLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificaciones/lineaProducto.scala.html
                    HASH: 9f3c03a6bed4648929f91d2b3c7726e595ae4603
                    MATRIX: 832->1|972->47|1025->65|1038->70|1062->73|1102->79|1122->91|1160->92|1284->181|1303->192|1389->256|1474->311|1516->319|1529->324|1566->340|1645->384|1686->417|1724->418|1754->431|1766->436|1813->438|1826->443|1871->466|1909->468|1923->473|1973->497|2020->510|2033->515|2063->524|2111->537|2125->542|2158->553|2206->566|2220->571|2279->608|2327->621|2341->626|2373->636|2421->649|2435->654|2511->708|2559->721|2573->726|2636->767|2680->776|2701->788|2740->789|2842->855|2862->866|2951->932|3053->1003
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            