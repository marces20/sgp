
package views.html.patrimonio.lineasCertificaciones

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
object crearLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionServicioLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionServicioLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.LineasCertificacionesController.guardar())/*5.95*/ {_display_(Seq[Any](format.raw/*5.97*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.patrimonio.lineasCertificaciones.formLineaProducto(lineaForm))),format.raw/*6.75*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CertificacionServicioLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionServicioLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasCertificaciones/crearLineaProducto.scala.html
                    HASH: 40902b140a589f7b7ea9e3e460739e30e394c05b
                    MATRIX: 846->1|994->67|1026->91|1100->46|1129->135|1169->141|1182->147|1277->234|1316->236|1354->240|1366->245|1454->312
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            