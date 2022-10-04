
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
object crearAgenteEstudio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteEstudio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteEstudio]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesEstudiosController.guardar())/*5.83*/ {_display_(Seq[Any](format.raw/*5.85*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.agenteEstudios.formAgenteEstudio(lineaForm))),format.raw/*6.62*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[AgenteEstudio]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteEstudio]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteEstudios/crearAgenteEstudio.scala.html
                    HASH: 8c6dae8535b372dc31226ce5d060e1f5a8eac87a
                    MATRIX: 820->1|955->54|987->78|1061->33|1090->122|1130->128|1143->134|1226->209|1265->211|1303->215|1315->220|1390->274
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            