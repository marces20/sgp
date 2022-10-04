
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
object editarAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteNovedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteNovedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesNovedadesController.actualizar())/*5.87*/ {_display_(Seq[Any](format.raw/*5.89*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.agenteNovedades.formAgenteNovedad(lineaForm))),format.raw/*6.63*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[AgenteNovedad]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteNovedad]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/editarAgenteNovedad.scala.html
                    HASH: 4837dbe9298348d8e552c5b292a70e8e199661c7
                    MATRIX: 822->1|957->54|989->78|1063->33|1092->122|1132->128|1145->134|1232->213|1271->215|1309->219|1321->224|1397->279|1435->283|1503->330
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            