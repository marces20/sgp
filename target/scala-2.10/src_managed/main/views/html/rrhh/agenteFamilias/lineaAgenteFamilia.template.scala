
package views.html.rrhh.agenteFamilias

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
object lineaAgenteFamilia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteFamilia,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteFamilia, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("editarAgenteHijo"))/*5.52*/{_display_(Seq[Any](format.raw/*5.53*/("""
		<td class="accion-editar">
		<a class="btn btn-default btn-xs modificarAgenteFamilia" href=""""),_display_(Seq[Any](/*7.67*/controllers/*7.78*/.rrhh.routes.AgentesFamiliasController.editar(linea.id))),format.raw/*7.133*/("""">
		<i class="glyphicon glyphicon-edit"></i></a>
		</td>
	""")))})),format.raw/*10.3*/("""
		<td>"""),_display_(Seq[Any](/*11.8*/linea/*11.13*/.nombre)),format.raw/*11.20*/(""" """),_display_(Seq[Any](/*11.22*/if(linea.discapacidad != null && linea.discapacidad)/*11.74*/{_display_(Seq[Any](format.raw/*11.75*/("""<img width="17" height="17" src="/assets/images/discapacidad.gif" alt=""/>""")))})),format.raw/*11.150*/(""" """),_display_(Seq[Any](/*11.152*/if(linea.vive != null && !linea.vive)/*11.189*/{_display_(Seq[Any](format.raw/*11.190*/("""<img width="17" height="22" src="/assets/images/difunto.png" alt=""/>""")))})),format.raw/*11.260*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/linea/*12.13*/.dni)),format.raw/*12.17*/("""</td>
		<td>"""),_display_(Seq[Any](/*13.8*/linea/*13.13*/.getEdad())),format.raw/*13.23*/("""</td>
		<td>"""),_display_(Seq[Any](/*14.8*/if(linea.estudioNivel != null)/*14.38*/{_display_(Seq[Any](format.raw/*14.39*/(""" """),_display_(Seq[Any](/*14.41*/linea/*14.46*/.estudioNivel.nombre)),format.raw/*14.66*/(""" """)))})),format.raw/*14.68*/("""</td>
		<td>"""),_display_(Seq[Any](/*15.8*/if(linea.estudioEstado != null)/*15.39*/ {_display_(Seq[Any](format.raw/*15.41*/(""" """),_display_(Seq[Any](/*15.43*/linea/*15.48*/.estudioEstado.nombre)),format.raw/*15.69*/(""" """)))})),format.raw/*15.71*/("""</td>
		<td>"""),_display_(Seq[Any](/*16.8*/if(linea.tipoFamiliar != null)/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/(""" """),_display_(Seq[Any](/*16.42*/linea/*16.47*/.tipoFamiliar.nombre)),format.raw/*16.67*/(""" """)))})),format.raw/*16.69*/("""</td>
		<td>"""),_display_(Seq[Any](/*17.8*/if(linea.fpresentacion != null)/*17.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*17.42*/(utils.DateUtils.formatDate(linea.fpresentacion))))))})),format.raw/*17.92*/("""</td>
		
	"""),_display_(Seq[Any](/*19.3*/if(editable && Permiso.check("eliminarAgenteHijo"))/*19.54*/{_display_(Seq[Any](format.raw/*19.55*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarAgenteFamilia" href=""""),_display_(Seq[Any](/*20.90*/controllers/*20.101*/.rrhh.routes.AgentesFamiliasController.eliminar(linea.id))),format.raw/*20.158*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*21.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteFamilia,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteFamilia,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteFamilias/lineaAgenteFamilia.scala.html
                    HASH: 625e45923c9141f6d306b93451106f49ad0c048a
                    MATRIX: 822->1|979->42|1007->67|1058->83|1071->88|1095->91|1135->97|1192->146|1230->147|1363->245|1382->256|1459->311|1553->374|1597->383|1611->388|1640->395|1678->397|1739->449|1778->450|1886->525|1925->527|1972->564|2012->565|2115->635|2164->649|2178->654|2204->658|2253->672|2267->677|2299->687|2348->701|2387->731|2426->732|2464->734|2478->739|2520->759|2554->761|2603->775|2643->806|2683->808|2721->810|2735->815|2778->836|2812->838|2861->852|2900->882|2940->884|2978->886|2992->891|3034->911|3068->913|3117->927|3157->958|3206->961|3282->1011|3330->1024|3390->1075|3429->1076|3556->1167|3577->1178|3657->1235|3759->1306
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|49->21
                    -- GENERATED --
                */
            