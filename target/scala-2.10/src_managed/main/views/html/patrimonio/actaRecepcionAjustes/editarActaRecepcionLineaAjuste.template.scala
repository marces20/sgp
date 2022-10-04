
package views.html.patrimonio.actaRecepcionAjustes

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
object editarActaRecepcionLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcionLineaAjuste],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ActaRecepcionLineaAjuste]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.ActaRecepcionLineaAjusteController.actualizar())/*5.101*/ {_display_(Seq[Any](format.raw/*5.103*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.patrimonio.actaRecepcionAjustes.formActaRecepcionLineaAjuste(lineaForm))),format.raw/*6.85*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[ActaRecepcionLineaAjuste]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ActaRecepcionLineaAjuste]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/editarActaRecepcionLineaAjuste.scala.html
                    HASH: 36cab0403d590be6943cf569ec841a293eabc1da
                    MATRIX: 855->1|1001->65|1033->89|1107->44|1136->133|1176->139|1189->145|1291->238|1331->240|1369->244|1381->249|1479->326|1517->330|1585->377
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            