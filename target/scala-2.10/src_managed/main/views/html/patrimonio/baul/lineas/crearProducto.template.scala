
package views.html.patrimonio.baul.lineas

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
object crearProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[RemitoLineaBaul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[RemitoLineaBaul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.RemitosLineasBaulController.guardar())/*5.91*/ {_display_(Seq[Any](format.raw/*5.93*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.patrimonio.baul.lineas.formProducto(lineaForm))),format.raw/*6.60*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[RemitoLineaBaul]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[RemitoLineaBaul]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/lineas/crearProducto.scala.html
                    HASH: 5bc6e31127a7ca0f705b8b37333478c0e95b79c8
                    MATRIX: 820->1|957->56|989->80|1063->35|1092->124|1132->130|1145->136|1236->219|1275->221|1313->225|1325->230|1398->282
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            