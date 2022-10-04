
package views.html.rrhh.novedades

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
object crearNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.NovedadesController.guardar(), 'id -> "formNovedades")/*5.101*/ {_display_(Seq[Any](format.raw/*5.103*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.novedades.formNovedad(lineaForm))),format.raw/*6.51*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[Novedad]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[Novedad]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/novedades/crearNovedad.scala.html
                    HASH: df71c40476137c2c6a8c73d10aa9706cd67eb573
                    MATRIX: 803->1|932->48|964->72|1038->27|1067->116|1107->122|1120->128|1222->221|1262->223|1300->227|1312->232|1376->275
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            