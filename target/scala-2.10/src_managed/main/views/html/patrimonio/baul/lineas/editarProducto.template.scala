
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
object editarProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[RemitoLineaBaul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[RemitoLineaBaul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.RemitosLineasBaulController.actualizar())/*5.94*/ {_display_(Seq[Any](format.raw/*5.96*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.patrimonio.baul.lineas.formProducto(lineaForm))),format.raw/*6.60*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(lineaForm("remito_baul_id"), 'hidden -> "hidden"))),format.raw/*8.62*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[RemitoLineaBaul]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[RemitoLineaBaul]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/lineas/editarProducto.scala.html
                    HASH: 9755069236657eaa38d195be8673a320f057b25d
                    MATRIX: 821->1|958->56|990->80|1064->35|1093->124|1133->130|1146->136|1240->222|1279->224|1317->228|1329->233|1402->285|1440->289|1508->336|1546->340|1626->399
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|36->8
                    -- GENERATED --
                */
            