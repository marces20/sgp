
package views.html.contabilidad.facturasLineasImpuestos

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
object lineaImpuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[FacturaLineaImpuesto,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: FacturaLineaImpuesto, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("facturasCargarRetencones"))/*5.60*/{_display_(Seq[Any](format.raw/*5.61*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarImpuesto" href=""""),_display_(Seq[Any](/*6.88*/controllers/*6.99*/.contabilidad.routes.FacturasLineasImpuestosController.editar(linea.id))),format.raw/*6.170*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
		<td>"""),_display_(Seq[Any](/*8.8*/linea/*8.13*/.nombre)),format.raw/*8.20*/("""</td>
		<td>"""),_display_(Seq[Any](/*9.8*/linea/*9.13*/.cuenta.nombre)),format.raw/*9.27*/("""</td>
		<td>"""),_display_(Seq[Any](/*10.8*/utils/*10.13*/.NumberUtils.moneda(linea.base))),format.raw/*10.44*/("""</td>
		<td>"""),_display_(Seq[Any](/*11.8*/utils/*11.13*/.NumberUtils.moneda(linea.monto))),format.raw/*11.45*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/if(linea.tipo != null)/*12.30*/{_display_(Seq[Any](format.raw/*12.31*/("""
			 
				"""),_display_(Seq[Any](/*14.6*/linea/*14.11*/.tipo.intValue()/*14.27*/ match/*14.33*/ {/*15.9*/case 1 =>/*15.18*/ {_display_(Seq[Any](format.raw/*15.20*/("""SERVICIO""")))}/*16.6*/case 2 =>/*16.15*/ {_display_(Seq[Any](format.raw/*16.17*/("""BIENES""")))}/*17.6*/case 3 =>/*17.15*/ {_display_(Seq[Any](format.raw/*17.17*/("""SERVICIOS AGENTES""")))}})),format.raw/*18.6*/("""
			 
		""")))})),format.raw/*20.4*/("""</td>
	"""),_display_(Seq[Any](/*21.3*/if(editable && Permiso.check("facturasCargarRetencones"))/*21.60*/{_display_(Seq[Any](format.raw/*21.61*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarImpuesto" href=""""),_display_(Seq[Any](/*22.85*/controllers/*22.96*/.contabilidad.routes.FacturasLineasImpuestosController.eliminar(linea.id))),format.raw/*22.169*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*23.3*/("""
</tr>"""))}
    }
    
    def render(linea:FacturaLineaImpuesto,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((FacturaLineaImpuesto,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasImpuestos/lineaImpuesto.scala.html
                    HASH: 993241ad74645358d4d524191353bf8787f903e9
                    MATRIX: 841->1|1005->49|1033->74|1084->90|1097->95|1121->98|1161->104|1226->161|1264->162|1388->251|1407->262|1500->333|1585->388|1628->397|1641->402|1669->409|1717->423|1730->428|1765->442|1814->456|1828->461|1881->492|1930->506|1944->511|1998->543|2047->557|2078->579|2117->580|2165->593|2179->598|2204->614|2219->620|2229->632|2247->641|2287->643|2314->659|2332->668|2372->670|2397->684|2415->693|2455->695|2505->720|2547->731|2591->740|2657->797|2696->798|2818->884|2838->895|2934->968|3036->1039
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->15|42->15|42->15|42->16|42->16|42->16|42->17|42->17|42->17|42->18|44->20|45->21|45->21|45->21|46->22|46->22|46->22|47->23
                    -- GENERATED --
                */
            