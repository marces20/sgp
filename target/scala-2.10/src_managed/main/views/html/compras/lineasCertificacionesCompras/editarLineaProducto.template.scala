
package views.html.compras.lineasCertificacionesCompras

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
object editarLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionCompraLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionCompraLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesComprasLineasController.actualizar())/*5.102*/ {_display_(Seq[Any](format.raw/*5.104*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineasCertificacionesCompras.formLineaProducto(lineaForm))),format.raw/*6.79*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CertificacionCompraLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionCompraLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificacionesCompras/editarLineaProducto.scala.html
                    HASH: 0319f62232d6b07d0aff406243e0287708c3734b
                    MATRIX: 849->1|995->65|1027->89|1101->44|1130->133|1170->139|1183->145|1286->239|1326->241|1364->245|1376->250|1468->321|1506->325|1574->372
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            