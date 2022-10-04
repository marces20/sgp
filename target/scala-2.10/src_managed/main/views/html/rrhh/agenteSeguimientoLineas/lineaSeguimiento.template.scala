
package views.html.rrhh.agenteSeguimientoLineas

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
object lineaSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteSeguimientoLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteSeguimientoLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	"""),_display_(Seq[Any](/*4.3*/if(editable)/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarEvento" 
		href=""""),_display_(Seq[Any](/*6.10*/controllers/*6.21*/.rrhh.routes.AgentesSeguimientoLineasController.editar(linea.id))),format.raw/*6.85*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
	
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.observacion)),format.raw/*9.24*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/if(linea.fecha != null)/*10.30*/{_display_(Seq[Any](_display_(Seq[Any](/*10.32*/(utils.DateUtils.formatDate(linea.fecha))))))})),format.raw/*10.74*/("""</td>
	 
	"""),_display_(Seq[Any](/*12.3*/if(editable)/*12.15*/{_display_(Seq[Any](format.raw/*12.16*/("""
		<td><a class="btn btn-default btn-xs eliminarEvento" href=""""),_display_(Seq[Any](/*13.63*/controllers/*13.74*/.rrhh.routes.AgentesSeguimientoLineasController.eliminar(linea.id))),format.raw/*13.140*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*14.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteSeguimientoLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteSeguimientoLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientoLineas/lineaSeguimiento.scala.html
                    HASH: 134c32381adc82a6ff39d953cecd705d8d312bee
                    MATRIX: 838->1|982->51|1033->67|1046->72|1070->75|1109->80|1129->92|1167->93|1291->182|1310->193|1395->257|1479->311|1522->320|1535->325|1568->337|1615->349|1647->372|1695->374|1763->416|1809->427|1830->439|1869->440|1968->503|1988->514|2077->580|2178->650
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|35->7|37->9|37->9|37->9|38->10|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14
                    -- GENERATED --
                */
            