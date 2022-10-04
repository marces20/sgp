
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
object crearAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteNovedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteNovedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesNovedadesController.guardar())/*5.84*/ {_display_(Seq[Any](format.raw/*5.86*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.agenteNovedades.formAgenteNovedad(lineaForm))),format.raw/*6.63*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[AgenteNovedad]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteNovedad]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/crearAgenteNovedad.scala.html
                    HASH: 7d953ffc3d2b8e6bdebbd27c33a153ff4d624233
                    MATRIX: 821->1|956->54|988->78|1062->33|1091->122|1131->128|1144->134|1228->210|1267->212|1305->216|1317->221|1393->276
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            