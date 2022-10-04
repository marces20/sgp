
package views.html.presupuesto.lineaRecursoPresupuestario

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
object lineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[LineaRecursoPresupuestario,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: LineaRecursoPresupuestario, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.56*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar">
			<a class="btn btn-default btn-xs modificarRecurso" 
			   href=""""),_display_(Seq[Any](/*7.14*/controllers/*7.25*/.presupuesto.routes.LineasRecursosPresupuestariosController.editar(linea.id))),format.raw/*7.101*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*8.3*/("""
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.cuentaAnalitica.codigo)),format.raw/*9.35*/(""" - """),_display_(Seq[Any](/*9.39*/linea/*9.44*/.cuentaAnalitica.nombre)),format.raw/*9.67*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/utils/*10.12*/.NumberUtils.moneda(linea.monto))),format.raw/*10.44*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.nombre)),format.raw/*11.19*/("""</td>
	
	"""),_display_(Seq[Any](/*13.3*/if(editable)/*13.15*/{_display_(Seq[Any](format.raw/*13.16*/("""
		<td><a class="btn btn-default btn-xs eliminarRecurso" 
			   href=""""),_display_(Seq[Any](/*15.14*/controllers/*15.25*/.presupuesto.routes.LineasRecursosPresupuestariosController.eliminar(linea.id))),format.raw/*15.103*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*16.3*/("""
</tr>"""))}
    }
    
    def render(linea:LineaRecursoPresupuestario,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((LineaRecursoPresupuestario,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/lineaRecurso.scala.html
                    HASH: 4bb524e1a11eb082f11bd26f9a5c9a10537a2eb6
                    MATRIX: 848->1|996->55|1049->73|1062->78|1086->81|1126->87|1146->99|1184->100|1320->201|1339->212|1437->288|1522->343|1564->351|1577->356|1621->379|1660->383|1673->388|1717->411|1765->424|1779->429|1833->461|1881->474|1895->479|1924->486|1971->498|1992->510|2031->511|2140->584|2160->595|2261->673|2363->744
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|35->7|35->7|35->7|36->8|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|41->13|41->13|41->13|43->15|43->15|43->15|44->16
                    -- GENERATED --
                */
            