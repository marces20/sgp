
package views.html.compras.proveedoresAtributos

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
object editarLineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ProveedorAtributo],ProveedorAtributo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ProveedorAtributo],linea:ProveedorAtributo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.ProveedorAtributosController.actualizar())/*5.92*/ {_display_(Seq[Any](format.raw/*5.94*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.proveedoresAtributos.formLineaAtributo(lineaForm,linea))),format.raw/*7.77*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*8.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[ProveedorAtributo],linea:ProveedorAtributo): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[ProveedorAtributo],ProveedorAtributo) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/editarLineaAtributo.scala.html
                    HASH: f10b8ecf2a09f1a86093536087109b550599f6f5
                    MATRIX: 852->1|1015->82|1047->106|1121->61|1150->150|1190->156|1203->162|1295->246|1334->248|1375->255|1387->260|1477->329|1515->333|1583->380
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8
                    -- GENERATED --
                */
            