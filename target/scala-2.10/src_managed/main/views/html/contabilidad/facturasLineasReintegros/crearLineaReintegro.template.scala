
package views.html.contabilidad.facturasLineasReintegros

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
object crearLineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[FacturaLineaReintegro],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[FacturaLineaReintegro]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasLineasReintegrosController.guardar())/*5.100*/ {_display_(Seq[Any](format.raw/*5.102*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.contabilidad.facturasLineasReintegros.formLineaReintegro(lineaForm))),format.raw/*6.81*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[FacturaLineaReintegro]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[FacturaLineaReintegro]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/crearLineaReintegro.scala.html
                    HASH: bc5246c24baaea745ef5354c30e948e33aaba542
                    MATRIX: 847->1|990->62|1022->86|1096->41|1125->130|1165->136|1178->142|1279->234|1319->236|1357->240|1369->245|1463->318
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            