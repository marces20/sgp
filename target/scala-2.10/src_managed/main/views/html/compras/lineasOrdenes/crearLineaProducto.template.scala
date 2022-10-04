
package views.html.compras.lineasOrdenes

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
object crearLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenLinea],OrdenLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[OrdenLinea],linea:OrdenLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.LineasOrdenesController.guardar())/*5.84*/ {_display_(Seq[Any](format.raw/*5.86*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.lineasOrdenes.formLineaProducto(lineaForm,linea))),format.raw/*7.70*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[OrdenLinea],linea:OrdenLinea): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[OrdenLinea],OrdenLinea) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/crearLineaProducto.scala.html
                    HASH: 31e14030b6a16eb3c20d53167749c5360cfc2c9a
                    MATRIX: 830->1|979->68|1011->92|1085->47|1114->136|1154->142|1167->148|1251->224|1290->226|1331->233|1343->238|1426->300
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7
                    -- GENERATED --
                */
            