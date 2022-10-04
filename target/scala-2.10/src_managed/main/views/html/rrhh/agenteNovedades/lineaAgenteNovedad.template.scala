
package views.html.rrhh.agenteNovedades

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
object lineaAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteNovedad,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteNovedad, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""" """),_display_(Seq[Any](/*4.26*/if(linea.activo == false)/*4.51*/{_display_(Seq[Any](format.raw/*4.52*/("""class="cancelada"""")))})),format.raw/*4.70*/(""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("editarAgenteNovedad") && linea.activo == true)/*5.79*/{_display_(Seq[Any](format.raw/*5.80*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarAgenteNovedad" href=""""),_display_(Seq[Any](/*6.93*/controllers/*6.104*/.rrhh.routes.AgentesNovedadesController.editar(linea.id))),format.raw/*6.160*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))}/*7.3*/else/*7.7*/{_display_(Seq[Any](format.raw/*7.8*/("""
		<td class="accion-editar"></td>
	""")))})),format.raw/*9.3*/("""
		<td>"""),_display_(Seq[Any](/*10.8*/(utils.DateUtils.formatDate(linea.fecha_inicio)))),format.raw/*10.56*/("""</td>
		<td>"""),_display_(Seq[Any](/*11.8*/linea/*11.13*/.tipoNovedadAgente.nombre)),format.raw/*11.38*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/linea/*12.13*/.escalaLaboral.nombre)),format.raw/*12.34*/("""</td>
		<td>"""),_display_(Seq[Any](/*13.8*/if(linea.carga_horaria != null)/*13.39*/{_display_(Seq[Any](_display_(Seq[Any](/*13.41*/linea/*13.46*/.carga_horaria)),format.raw/*13.60*/(""" horas semanales""")))})),format.raw/*13.77*/("""</td>
		<td>"""),_display_(Seq[Any](/*14.8*/linea/*14.13*/.situacion)),format.raw/*14.23*/("""</td>
		<td>"""),_display_(Seq[Any](/*15.8*/linea/*15.13*/.observaciones)),format.raw/*15.27*/("""</td>
	"""),_display_(Seq[Any](/*16.3*/if(editable && Permiso.check("eliminarAgenteNovedad"))/*16.57*/{_display_(Seq[Any](format.raw/*16.58*/("""
		 
	 
	""")))})),format.raw/*19.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteNovedad,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteNovedad,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/lineaAgenteNovedad.scala.html
                    HASH: d619a0261e157ec4197024c7c0b3289b2d24ca9a
                    MATRIX: 823->1|980->42|1008->67|1059->83|1072->88|1096->91|1134->94|1167->119|1205->120|1254->138|1293->143|1377->219|1415->220|1544->314|1564->325|1642->381|1714->436|1725->440|1762->441|1831->480|1875->489|1945->537|1994->551|2008->556|2055->581|2104->595|2118->600|2161->621|2210->635|2250->666|2298->668|2312->673|2348->687|2397->704|2446->718|2460->723|2492->733|2541->747|2555->752|2591->766|2635->775|2698->829|2737->830|2781->843
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|37->9|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|47->19
                    -- GENERATED --
                */
            