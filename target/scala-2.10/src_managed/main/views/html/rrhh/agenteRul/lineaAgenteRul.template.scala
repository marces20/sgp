
package views.html.rrhh.agenteRul

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
object lineaAgenteRul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteRul,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteRul, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.39*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(editable && Permiso.check("editarAgenteRul"))/*5.51*/{_display_(Seq[Any](format.raw/*5.52*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarAgenteRul" href=""""),_display_(Seq[Any](/*6.89*/controllers/*6.100*/.rrhh.routes.AgentesRulController.editar(linea.id))),format.raw/*6.150*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
		<td>"""),_display_(Seq[Any](/*8.8*/linea/*8.13*/.tipoRelacionLaboral.nombre)),format.raw/*8.40*/("""</td>
		<td>"""),_display_(Seq[Any](/*9.8*/linea/*9.13*/.institucionExterna.nombre)),format.raw/*9.39*/("""</td>
		<td>"""),_display_(Seq[Any](/*10.8*/linea/*10.13*/.nota)),format.raw/*10.18*/("""</td>
	"""),_display_(Seq[Any](/*11.3*/if(editable && Permiso.check("eliminarAgenteRul"))/*11.53*/{_display_(Seq[Any](format.raw/*11.54*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarAgenteRul" href=""""),_display_(Seq[Any](/*12.86*/controllers/*12.97*/.rrhh.routes.AgentesRulController.eliminar(linea.id))),format.raw/*12.149*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*13.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteRul,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteRul,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteRul/lineaAgenteRul.scala.html
                    HASH: 0f3f0260152de2b114d809383102229a742d8c5f
                    MATRIX: 809->1|962->38|990->63|1041->79|1054->84|1078->87|1118->93|1174->141|1212->142|1337->232|1357->243|1429->293|1514->348|1557->357|1570->362|1618->389|1666->403|1679->408|1726->434|1775->448|1789->453|1816->458|1860->467|1919->517|1958->518|2081->605|2101->616|2176->668|2278->739
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13
                    -- GENERATED --
                */
            