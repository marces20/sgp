
package views.html.recupero.recuperoPago.cheques

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
object editarDatosCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.Cheque],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(chequeForm: Form[models.recupero.Cheque]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.recupero.routes.RecuperoChequesController.actualizar(), 'id -> "formDatosCheques")/*6.117*/ {_display_(Seq[Any](format.raw/*6.119*/("""
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.recupero.recuperoPago.cheques.formDatosCheque(chequeForm))),format.raw/*7.71*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(chequeForm("id"), 'hidden -> "hidden"))),format.raw/*8.51*/("""
""")))})),format.raw/*9.2*/("""

 """))}
    }
    
    def render(chequeForm:Form[models.recupero.Cheque]): play.api.templates.HtmlFormat.Appendable = apply(chequeForm)
    
    def f:((Form[models.recupero.Cheque]) => play.api.templates.HtmlFormat.Appendable) = (chequeForm) => apply(chequeForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/editarDatosCheque.scala.html
                    HASH: 63a0c112073075967dbc77cc3013576947fec31b
                    MATRIX: 838->1|1000->81|1032->105|1106->43|1135->149|1175->155|1188->161|1306->270|1346->272|1384->276|1396->281|1480->344|1518->348|1587->396|1620->399
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|37->8|37->8|38->9
                    -- GENERATED --
                */
            