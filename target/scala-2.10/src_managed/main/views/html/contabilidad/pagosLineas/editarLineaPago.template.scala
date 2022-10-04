
package views.html.contabilidad.pagosLineas

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
object editarLineaPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PagoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[PagoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosLineasController.actualizar())/*5.90*/ {_display_(Seq[Any](format.raw/*5.92*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.contabilidad.pagosLineas.formLineaPago(lineaForm))),format.raw/*6.63*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[PagoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[PagoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagosLineas/editarLineaPago.scala.html
                    HASH: 4e0f18d315a2f98cccc7e9b3b6801f54ab7dcefe
                    MATRIX: 818->1|949->50|981->74|1055->29|1084->118|1124->124|1137->130|1227->212|1266->214|1304->218|1316->223|1392->278|1430->282|1498->329
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            