
package views.html.compras.lineasPedidosFondos

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
object editarLineaPedido extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PedidoFondoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[PedidoFondoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.LineasPedidosFondosController.actualizar())/*5.93*/ {_display_(Seq[Any](format.raw/*5.95*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineasPedidosFondos.formLineaPedido(lineaForm))),format.raw/*6.68*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[PedidoFondoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[PedidoFondoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasPedidosFondos/editarLineaPedido.scala.html
                    HASH: 5b00044b4983b053b23df5f664395d32e404d6a8
                    MATRIX: 830->1|968->57|1000->81|1074->36|1103->125|1143->131|1156->137|1249->222|1288->224|1326->228|1338->233|1419->293|1457->297|1525->344
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            