
package views.html.patrimonio.recepciones

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
object crearRecepcionModal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Recepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recepcionForm: Form[Recepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.patrimonio.routes.RecepcionesController.guardar(), 'id -> "formCrearActaRecepcion")/*6.118*/ {_display_(Seq[Any](format.raw/*6.120*/("""
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.patrimonio.recepciones.formRecepciones(recepcionForm))),format.raw/*7.67*/(""" 
""")))})),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/flash()/*10.9*/.clear())))}
    }
    
    def render(recepcionForm:Form[Recepcion]): play.api.templates.HtmlFormat.Appendable = apply(recepcionForm)
    
    def f:((Form[Recepcion]) => play.api.templates.HtmlFormat.Appendable) = (recepcionForm) => apply(recepcionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/crearRecepcionModal.scala.html
                    HASH: 2bb6fce269d3ddff06ef99e46892bd8fe9bcc2c3
                    MATRIX: 820->1|972->71|1004->95|1078->33|1107->139|1151->149|1164->155|1283->265|1323->267|1361->271|1373->276|1453->335|1487->339|1527->344|1542->351
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|37->8|39->10|39->10
                    -- GENERATED --
                */
            