
package views.html.patrimonio.actaRecepcionAjustes

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
object lineaActaRecepcionLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ActaRecepcionLineaAjuste,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: ActaRecepcionLineaAjuste, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar">
			<a class="btn btn-default btn-xs modificarLineaAjuste" href=""""),_display_(Seq[Any](/*6.66*/controllers/*6.77*/.patrimonio.routes.ActaRecepcionLineaAjusteController.editar(linea.id))),format.raw/*6.147*/("""">
			<i class="glyphicon glyphicon-edit"></i></a>
		</td>
	""")))})),format.raw/*9.3*/("""
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.producto.nombre)),format.raw/*10.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.cuentaAnalitica == null)/*11.40*/{_display_(Seq[Any](format.raw/*11.41*/("""No asociada""")))}/*11.54*/else/*11.59*/{_display_(Seq[Any](_display_(Seq[Any](/*11.61*/linea/*11.66*/.cuentaAnalitica.codigo)),format.raw/*11.89*/(""" """),_display_(Seq[Any](/*11.91*/linea/*11.96*/.cuentaAnalitica.nombre))))})),format.raw/*11.120*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.udm.nombre)),format.raw/*12.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/linea/*13.12*/.cantidad)),format.raw/*13.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.NumberUtils.moneda(linea.precio))),format.raw/*14.45*/("""</td>
	<td>"""),_display_(Seq[Any](/*15.7*/utils/*15.12*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*15.49*/("""</td>
	"""),_display_(Seq[Any](/*16.3*/if(editable)/*16.15*/{_display_(Seq[Any](format.raw/*16.16*/("""
		<td><a class="btn btn-default btn-xs eliminarLineaAjuste delete-confirm-link" href=""""),_display_(Seq[Any](/*17.88*/controllers/*17.99*/.patrimonio.routes.ActaRecepcionLineaAjusteController.eliminar(linea.id))),format.raw/*17.171*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*18.3*/("""
</tr>"""))}
    }
    
    def render(linea:ActaRecepcionLineaAjuste,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ActaRecepcionLineaAjuste,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/lineaActaRecepcionLineaAjuste.scala.html
                    HASH: 5fcce9c1e525c8e8a1535c21fdb04cde1c844c9d
                    MATRIX: 856->1|1002->53|1055->71|1068->76|1092->79|1132->85|1152->97|1190->98|1322->195|1341->206|1433->276|1527->340|1570->348|1584->353|1622->369|1670->382|1712->415|1751->416|1782->429|1795->434|1843->436|1857->441|1902->464|1940->466|1954->471|2005->495|2053->508|2067->513|2100->524|2148->537|2162->542|2193->551|2241->564|2255->569|2310->602|2358->615|2372->620|2431->657|2475->666|2496->678|2535->679|2660->768|2680->779|2775->851|2877->922
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18
                    -- GENERATED --
                */
            