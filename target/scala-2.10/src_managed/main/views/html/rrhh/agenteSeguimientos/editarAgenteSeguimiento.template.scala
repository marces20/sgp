
package views.html.rrhh.agenteSeguimientos

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
object editarAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[AgenteSeguimiento],AgenteSeguimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteSeguimientoForm: Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*4.63*/("""" type="text/javascript"></script>
""")))};implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.2*/("""
"""),format.raw/*6.70*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.rrhh.mainRrhh("Modificar Agente Seguimiento",scripts)/*8.66*/ {_display_(Seq[Any](format.raw/*8.68*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Seguimiento</h1>
			</div>
			
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*21.3*/if(flash.containsKey("error"))/*21.33*/ {_display_(Seq[Any](format.raw/*21.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*23.5*/flash/*23.10*/.get("error"))),format.raw/*23.23*/("""
		</div>
	""")))})),format.raw/*25.3*/("""
	
	"""),_display_(Seq[Any](/*27.3*/helper/*27.9*/.form(action = controllers.rrhh.routes.AgentesSeguimientoController.actualizarAgenteSeguimiento(agenteSeguimiento.id))/*27.127*/ {_display_(Seq[Any](format.raw/*27.129*/("""
		"""),_display_(Seq[Any](/*28.4*/inputText(agenteSeguimientoForm("id"), 'hidden -> "hidden"))),format.raw/*28.63*/("""
		"""),_display_(Seq[Any](/*29.4*/views/*29.9*/.html.rrhh.agenteSeguimientos.formAgenteSeguimiento(agenteSeguimientoForm,agenteSeguimiento))),format.raw/*29.101*/("""
		"""),_display_(Seq[Any](/*30.4*/views/*30.9*/.html.rrhh.agenteSeguimientos.tabsAgenteSeguimiento(true,agenteSeguimientoForm,agenteSeguimiento))),format.raw/*30.106*/("""
	""")))})),format.raw/*31.3*/("""

""")))})))}
    }
    
    def render(agenteSeguimientoForm:Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento): play.api.templates.HtmlFormat.Appendable = apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def f:((Form[AgenteSeguimiento],AgenteSeguimiento) => play.api.templates.HtmlFormat.Appendable) = (agenteSeguimientoForm,agenteSeguimiento) => apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/editarAgenteSeguimiento.scala.html
                    HASH: eb805d3350a705bd940b5b30d4facb672767a521
                    MATRIX: 851->1|1028->104|1042->111|1126->115|1177->131|1191->137|1253->178|1320->216|1352->240|1426->85|1453->214|1481->284|1518->287|1530->292|1597->351|1636->353|1849->531|1888->561|1928->563|2003->603|2017->608|2052->621|2095->633|2135->638|2149->644|2277->762|2318->764|2357->768|2438->827|2477->831|2490->836|2605->928|2644->932|2657->937|2777->1034|2811->1037
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|33->6|33->6|34->1|35->5|36->6|38->8|38->8|38->8|38->8|51->21|51->21|51->21|53->23|53->23|53->23|55->25|57->27|57->27|57->27|57->27|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31
                    -- GENERATED --
                */
            