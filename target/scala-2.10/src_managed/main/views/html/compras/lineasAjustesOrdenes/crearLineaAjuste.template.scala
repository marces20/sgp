
package views.html.compras.lineasAjustesOrdenes

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
object crearLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenLineaAjuste],OrdenLineaAjuste,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[OrdenLineaAjuste],linea:OrdenLineaAjuste):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.OrdenesLineasAjustesController.guardar())/*5.91*/ {_display_(Seq[Any](format.raw/*5.93*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.lineasAjustesOrdenes.formLineaAjuste(lineaForm,linea))),format.raw/*7.75*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[OrdenLineaAjuste],linea:OrdenLineaAjuste): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[OrdenLineaAjuste],OrdenLineaAjuste) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasAjustesOrdenes/crearLineaAjuste.scala.html
                    HASH: 58e5026053d4a92ef1310c041f7a43c25e35a67c
                    MATRIX: 847->1|1008->80|1040->104|1114->59|1143->148|1183->154|1196->160|1287->243|1326->245|1367->252|1379->257|1467->324
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7
                    -- GENERATED --
                */
            