
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
object barraIzqAdministracion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/(message))),format.raw/*3.11*/("""
<div id="content-left">
	<div id="barraNavegacionIzquierda">
		<ul>
			<li class="padre"><a href="">Compa&ntilde;ias</a></li>
			<li class="padre"><a href="">Grupos</a></li>
			<li class="padre"><a href="">Usuarios</a></li>
		</ul>
	</div>
</div>"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/tags/barraIzqAdministracion.scala.html
                    HASH: 1932a5bf462066f62b1cbbf9868c3fa72dd6e1d1
                    MATRIX: 796->1|907->18|944->21|974->30
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            