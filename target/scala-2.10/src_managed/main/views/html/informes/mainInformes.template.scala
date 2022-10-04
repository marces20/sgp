
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
object mainInformes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*7.27*/content)),format.raw/*7.34*/("""</div>
		<div class="col-sm-1"></div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/mainInformes.scala.html
                    HASH: 96b651884109c51743e1f88c29e2685ba7fdfe63
                    MATRIX: 800->1|971->57|998->80|1034->82|1070->110|1108->111|1220->188|1248->195
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|35->7|35->7
                    -- GENERATED --
                */
            