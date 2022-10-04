
package views.html.rrhh.agenteEstudios

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
object lineaAgenteEstudio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteEstudio,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteEstudio, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("editarAgenteEstudio"))/*5.55*/{_display_(Seq[Any](format.raw/*5.56*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarAgenteEstudio" href=""""),_display_(Seq[Any](/*6.93*/controllers/*6.104*/.rrhh.routes.AgentesEstudiosController.editar(linea.id))),format.raw/*6.159*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
		<td>"""),_display_(Seq[Any](/*8.8*/linea/*8.13*/.estudioNivel.nombre)),format.raw/*8.33*/("""</td>
		<td>"""),_display_(Seq[Any](/*9.8*/linea/*9.13*/.titulo)),format.raw/*9.20*/("""</td>
		<td>"""),_display_(Seq[Any](/*10.8*/if(linea.otra_institucion == null || linea.otra_institucion.isEmpty())/*10.78*/{_display_(Seq[Any](_display_(Seq[Any](/*10.80*/linea/*10.85*/.estudioInstitucion.nombre))))}/*10.112*/else/*10.116*/{_display_(Seq[Any](_display_(Seq[Any](/*10.118*/linea/*10.123*/.otra_institucion))))})),format.raw/*10.141*/("""</td>
		<td>"""),_display_(Seq[Any](/*11.8*/if(linea.estudioSubarea != null)/*11.40*/ {_display_(Seq[Any](_display_(Seq[Any](/*11.43*/linea/*11.48*/.estudioSubarea.nombre))))})),format.raw/*11.71*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/if(linea.estudioEstado != null)/*12.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*12.42*/linea/*12.47*/.estudioEstado.nombre))))})),format.raw/*12.69*/("""</td>
	"""),_display_(Seq[Any](/*13.3*/if(editable && Permiso.check("eliminarAgenteEstudio"))/*13.57*/{_display_(Seq[Any](format.raw/*13.58*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarAgenteEstudio" href=""""),_display_(Seq[Any](/*14.90*/controllers/*14.101*/.rrhh.routes.AgentesEstudiosController.eliminar(linea.id))),format.raw/*14.158*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*15.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteEstudio,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteEstudio,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteEstudios/lineaAgenteEstudio.scala.html
                    HASH: 7de13a8f5d40628839a61d397aacf7d49533c0fe
                    MATRIX: 822->1|979->42|1007->67|1058->83|1071->88|1095->91|1135->97|1195->149|1233->150|1362->244|1382->255|1459->310|1544->365|1587->374|1600->379|1641->399|1689->413|1702->418|1730->425|1779->439|1858->509|1906->511|1920->516|1961->543|1975->547|2024->549|2039->554|2084->572|2133->586|2174->618|2223->621|2237->626|2286->649|2335->663|2375->694|2424->697|2438->702|2486->724|2530->733|2593->787|2632->788|2759->879|2780->890|2860->947|2962->1018
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15
                    -- GENERATED --
                */
            