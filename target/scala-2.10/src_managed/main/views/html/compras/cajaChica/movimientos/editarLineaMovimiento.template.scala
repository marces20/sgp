
package views.html.compras.cajaChica.movimientos

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
object editarLineaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChicaMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CajaChicaMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CajaChicaMovimientosController.actualizar())/*5.94*/ {_display_(Seq[Any](format.raw/*5.96*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.cajaChica.movimientos.formLineaMovimiento(lineaForm))),format.raw/*6.74*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CajaChicaMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CajaChicaMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/movimientos/editarLineaMovimiento.scala.html
                    HASH: c44cfa68e506d101c4eea3247ed6c2e6f2fd25f5
                    MATRIX: 839->1|980->60|1012->84|1086->39|1115->128|1155->134|1168->140|1262->226|1301->228|1339->232|1351->237|1438->303|1476->307|1544->354
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            