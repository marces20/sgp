
package views.html.compras.lineaAjustesCertificacionesCompras

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
object crearLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionesComprasLineaAjustes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionesComprasLineaAjustes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesComprasLineaAjustesController.guardar())/*5.105*/ {_display_(Seq[Any](format.raw/*5.107*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineaAjustesCertificacionesCompras.formLineaProducto(lineaForm))),format.raw/*6.85*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CertificacionesComprasLineaAjustes]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionesComprasLineaAjustes]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineaAjustesCertificacionesCompras/crearLineaProducto.scala.html
                    HASH: 5a3f66da9c129521c575596d6efc7a718ba53e25
                    MATRIX: 864->1|1020->75|1052->99|1126->54|1155->143|1195->149|1208->155|1314->252|1354->254|1392->258|1404->263|1502->340
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            