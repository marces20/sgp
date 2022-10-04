
package views.html.rrhh.agente

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
object editarAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Agente],Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteForm: Form[Agente],agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*4.63*/("""" type="text/javascript"></script>
""")))};implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*5.2*/("""
"""),format.raw/*6.70*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.rrhh.mainRrhh("Modificar Agente",scripts)/*8.54*/ {_display_(Seq[Any](format.raw/*8.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Agente</h1>
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
	
	"""),_display_(Seq[Any](/*27.3*/helper/*27.9*/.form(action = controllers.rrhh.routes.AgentesController.actualizarAgente(agente.id))/*27.94*/ {_display_(Seq[Any](format.raw/*27.96*/("""
		"""),_display_(Seq[Any](/*28.4*/inputText(agenteForm("id"), 'hidden -> "hidden"))),format.raw/*28.52*/("""
		"""),_display_(Seq[Any](/*29.4*/views/*29.9*/.html.rrhh.agente.formAgente(agenteForm,agente))),format.raw/*29.56*/("""
		"""),_display_(Seq[Any](/*30.4*/views/*30.9*/.html.rrhh.agente.tabsAgente(true,agenteForm,agente,null))),format.raw/*30.66*/("""
	""")))})),format.raw/*31.3*/("""

""")))})))}
    }
    
    def render(agenteForm:Form[Agente],agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(agenteForm,agente)
    
    def f:((Form[Agente],Agente) => play.api.templates.HtmlFormat.Appendable) = (agenteForm,agente) => apply(agenteForm,agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/editarAgente.scala.html
                    HASH: ec07115d8cd9a10f72bed4b8910ba191053ff522
                    MATRIX: 806->1|939->60|953->67|1037->71|1088->87|1102->93|1164->134|1231->172|1263->196|1337->41|1364->170|1392->240|1429->243|1441->248|1496->295|1535->297|1743->470|1782->500|1822->502|1897->542|1911->547|1946->560|1989->572|2029->577|2043->583|2137->668|2177->670|2216->674|2286->722|2325->726|2338->731|2407->778|2446->782|2459->787|2538->844|2572->847
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|33->6|33->6|34->1|35->5|36->6|38->8|38->8|38->8|38->8|51->21|51->21|51->21|53->23|53->23|53->23|55->25|57->27|57->27|57->27|57->27|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31
                    -- GENERATED --
                */
            