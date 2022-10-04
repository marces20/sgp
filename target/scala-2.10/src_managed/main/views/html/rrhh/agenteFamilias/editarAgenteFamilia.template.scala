
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
object editarAgenteFamilia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteFamilia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteFamilia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesFamiliasController.actualizar())/*5.86*/ {_display_(Seq[Any](format.raw/*5.88*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.agenteFamilias.formAgenteFamilia(lineaForm))),format.raw/*6.62*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[AgenteFamilia]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteFamilia]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteFamilias/editarAgenteFamilia.scala.html
                    HASH: daaf60749680c8b16c13c769c7e58503fcf184e5
                    MATRIX: 821->1|956->54|988->78|1062->33|1091->122|1131->128|1144->134|1230->212|1269->214|1307->218|1319->223|1394->277|1432->281|1500->328
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            