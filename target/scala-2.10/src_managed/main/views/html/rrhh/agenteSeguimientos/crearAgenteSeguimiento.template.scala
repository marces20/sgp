
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
object crearAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[AgenteSeguimiento],AgenteSeguimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteSeguimientoForm: Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*4.63*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.rrhh.mainRrhh("Crear Agente Seguimiento",scripts)/*6.62*/ {_display_(Seq[Any](format.raw/*6.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo Seguimiento</h1>
			</div>
			
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*18.3*/if(flash.containsKey("error"))/*18.33*/ {_display_(Seq[Any](format.raw/*18.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*20.5*/flash/*20.10*/.get("error"))),format.raw/*20.23*/("""
		</div>
    """)))})),format.raw/*22.6*/("""
    
    """),_display_(Seq[Any](/*24.6*/helper/*24.12*/.form(action = controllers.rrhh.routes.AgentesSeguimientoController.guardarAgenteSeguimiento())/*24.107*/ {_display_(Seq[Any](format.raw/*24.109*/("""
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.rrhh.agenteSeguimientos.formAgenteSeguimiento(agenteSeguimientoForm,agenteSeguimiento))),format.raw/*25.101*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.rrhh.agenteSeguimientos.tabsAgenteSeguimiento(false, agenteSeguimientoForm,agenteSeguimiento))),format.raw/*26.108*/("""
	""")))})),format.raw/*27.3*/("""
""")))})),format.raw/*28.2*/("""	"""))}
    }
    
    def render(agenteSeguimientoForm:Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento): play.api.templates.HtmlFormat.Appendable = apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def f:((Form[AgenteSeguimiento],AgenteSeguimiento) => play.api.templates.HtmlFormat.Appendable) = (agenteSeguimientoForm,agenteSeguimiento) => apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/crearAgenteSeguimiento.scala.html
                    HASH: 020723b30788e7eec65aa50039e9c41b8fe344db
                    MATRIX: 850->1|1027->104|1041->111|1125->115|1176->131|1190->137|1252->178|1327->85|1354->214|1390->216|1402->221|1465->276|1504->278|1720->459|1759->489|1799->491|1874->531|1888->536|1923->549|1969->564|2015->575|2030->581|2135->676|2176->678|2215->682|2228->687|2343->779|2382->783|2395->788|2517->887|2551->890|2584->892
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|34->1|35->5|36->6|36->6|36->6|36->6|48->18|48->18|48->18|50->20|50->20|50->20|52->22|54->24|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|57->27|58->28
                    -- GENERATED --
                */
            