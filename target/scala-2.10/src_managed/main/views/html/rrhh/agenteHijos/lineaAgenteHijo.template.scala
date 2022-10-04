
package views.html.rrhh.agenteHijos

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
object lineaAgenteHijo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteHijo,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteHijo, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("editarAgenteHijo"))/*5.52*/{_display_(Seq[Any](format.raw/*5.53*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarAgenteHijo" href=""""),_display_(Seq[Any](/*6.90*/controllers/*6.101*/.rrhh.routes.AgentesHijosController.editar(linea.id))),format.raw/*6.153*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
		<td>"""),_display_(Seq[Any](/*8.8*/linea/*8.13*/.nombre)),format.raw/*8.20*/("""</td>
		<td>"""),_display_(Seq[Any](/*9.8*/linea/*9.13*/.dni)),format.raw/*9.17*/("""</td>
		<td>"""),_display_(Seq[Any](/*10.8*/linea/*10.13*/.getEdad())),format.raw/*10.23*/("""</td>
		<td>"""),_display_(Seq[Any](/*11.8*/if(linea.estudioNivel != null)/*11.38*/{_display_(Seq[Any](format.raw/*11.39*/(""" """),_display_(Seq[Any](/*11.41*/linea/*11.46*/.estudioNivel.nombre)),format.raw/*11.66*/(""" """)))})),format.raw/*11.68*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/if(linea.estudioEstado != null)/*12.39*/ {_display_(Seq[Any](format.raw/*12.41*/(""" """),_display_(Seq[Any](/*12.43*/linea/*12.48*/.estudioEstado.nombre)),format.raw/*12.69*/(""" """)))})),format.raw/*12.71*/("""</td>
	"""),_display_(Seq[Any](/*13.3*/if(editable && Permiso.check("eliminarAgenteHijo"))/*13.54*/{_display_(Seq[Any](format.raw/*13.55*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarAgenteHijo" href=""""),_display_(Seq[Any](/*14.87*/controllers/*14.98*/.rrhh.routes.AgentesHijosController.eliminar(linea.id))),format.raw/*14.152*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*15.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteHijo,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteHijo,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteHijos/lineaAgenteHijo.scala.html
                    HASH: e1662deb46894bc1d2e1c65622eda5c482667322
                    MATRIX: 813->1|967->39|995->64|1046->80|1059->85|1083->88|1123->94|1180->143|1218->144|1344->235|1364->246|1438->298|1523->353|1566->362|1579->367|1607->374|1655->388|1668->393|1693->397|1742->411|1756->416|1788->426|1837->440|1876->470|1915->471|1953->473|1967->478|2009->498|2043->500|2092->514|2132->545|2172->547|2210->549|2224->554|2267->575|2301->577|2345->586|2405->637|2444->638|2568->726|2588->737|2665->791|2767->862
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15
                    -- GENERATED --
                */
            