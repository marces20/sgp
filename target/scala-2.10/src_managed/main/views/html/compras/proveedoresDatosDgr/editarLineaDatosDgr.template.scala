
package views.html.compras.proveedoresDatosDgr

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
object editarLineaDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ProveedorDatoDgr],ProveedorDatoDgr,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ProveedorDatoDgr],linea:ProveedorDatoDgr):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.ProveedorDatosDgrController.actualizar())/*5.91*/ {_display_(Seq[Any](format.raw/*5.93*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.proveedoresDatosDgr.formLineaDatosDgr(lineaForm,linea))),format.raw/*7.76*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*8.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[ProveedorDatoDgr],linea:ProveedorDatoDgr): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[ProveedorDatoDgr],ProveedorDatoDgr) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresDatosDgr/editarLineaDatosDgr.scala.html
                    HASH: 47271361ffc0bf616d8e1395ed53971152fcafdb
                    MATRIX: 849->1|1010->80|1042->104|1116->59|1145->148|1185->154|1198->160|1289->243|1328->245|1369->252|1381->257|1470->325|1508->329|1576->376
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8
                    -- GENERATED --
                */
            