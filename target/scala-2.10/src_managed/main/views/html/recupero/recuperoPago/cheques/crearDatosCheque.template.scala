
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
object crearDatosCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.Cheque],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(chequeForm: Form[models.recupero.Cheque]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*4.70*/(""" 

 

"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = controllers.recupero.routes.RecuperoChequesController.guardar(), 'id -> "formDatosCheques")/*8.114*/ {_display_(Seq[Any](format.raw/*8.116*/("""
	"""),_display_(Seq[Any](/*9.3*/views/*9.8*/.html.recupero.recuperoPago.cheques.formDatosCheque(chequeForm))),format.raw/*9.71*/("""
""")))})))}
    }
    
    def render(chequeForm:Form[models.recupero.Cheque]): play.api.templates.HtmlFormat.Appendable = apply(chequeForm)
    
    def f:((Form[models.recupero.Cheque]) => play.api.templates.HtmlFormat.Appendable) = (chequeForm) => apply(chequeForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/crearDatosCheque.scala.html
                    HASH: 5ed7cee06567a20c1eaf38f849c9064b83c4cd8e
                    MATRIX: 837->1|999->81|1031->105|1105->43|1134->149|1179->160|1192->166|1307->272|1347->274|1385->278|1397->283|1481->346
                    LINES: 26->1|31->4|31->4|32->1|33->4|37->8|37->8|37->8|37->8|38->9|38->9|38->9
                    -- GENERATED --
                */
            