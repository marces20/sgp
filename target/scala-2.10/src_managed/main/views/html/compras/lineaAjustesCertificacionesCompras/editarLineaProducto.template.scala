
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
object editarLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionesComprasLineaAjustes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionesComprasLineaAjustes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesComprasLineaAjustesController.actualizar())/*5.108*/ {_display_(Seq[Any](format.raw/*5.110*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineaAjustesCertificacionesCompras.formLineaProducto(lineaForm))),format.raw/*6.85*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[CertificacionesComprasLineaAjustes]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionesComprasLineaAjustes]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineaAjustesCertificacionesCompras/editarLineaProducto.scala.html
                    HASH: 2658f0ef58eadd78ecfa8c95701dd2eb3ecf88dd
                    MATRIX: 865->1|1021->75|1053->99|1127->54|1156->143|1196->149|1209->155|1318->255|1358->257|1396->261|1408->266|1506->343|1544->347|1612->394
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            