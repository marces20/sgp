
package views.html.compras.cajaChica.presupuestoLineas

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
object crearLineaPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChicaPresupuestoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CajaChicaPresupuestoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CajaChicaPresupuestoLineasController.guardar())/*5.97*/ {_display_(Seq[Any](format.raw/*5.99*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.cajaChica.presupuestoLineas.formLineaPresupuesto(lineaForm))),format.raw/*6.81*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CajaChicaPresupuestoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CajaChicaPresupuestoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/presupuestoLineas/crearLineaPresupuesto.scala.html
                    HASH: 9d1441eb34146d68c95f3824da795e75bbbda17c
                    MATRIX: 851->1|998->66|1030->90|1104->45|1133->134|1173->140|1186->146|1283->235|1322->237|1360->241|1372->246|1466->319
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            