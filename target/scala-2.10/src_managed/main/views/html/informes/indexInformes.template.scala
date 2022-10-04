
package views.html.informes

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
object indexInformes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/views/*1.7*/.html.informes.mainInformes("Informes Gerenciales")/*1.58*/ {_display_(Seq[Any](format.raw/*1.60*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.informes.navInformes())),format.raw/*3.35*/("""

""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/indexInformes.scala.html
                    HASH: 437cb59936890fe405926315b1eee2d240be9077
                    MATRIX: 881->1|893->6|952->57|991->59|1028->62|1040->67|1089->95
                    LINES: 29->1|29->1|29->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            