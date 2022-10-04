
package views.html.tags

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
object successError extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/if(flash.containsKey("success"))/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*2.80*/Html(flash.get("success")))),format.raw/*2.106*/("""</div>
""")))})),format.raw/*3.2*/("""
"""),_display_(Seq[Any](/*4.2*/if(flash.containsKey("error"))/*4.32*/ {_display_(Seq[Any](format.raw/*4.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*5.83*/Html(flash.get("error")))),format.raw/*5.107*/("""</div>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/tags/successError.scala.html
                    HASH: 65aeb214a7f597cea63f8f46e8e0cdba0b591a51
                    MATRIX: 876->1|916->33|955->35|1070->115|1118->141|1156->149|1192->151|1230->181|1269->183|1387->266|1433->290
                    LINES: 29->1|29->1|29->1|30->2|30->2|31->3|32->4|32->4|32->4|33->5|33->5
                    -- GENERATED --
                */
            