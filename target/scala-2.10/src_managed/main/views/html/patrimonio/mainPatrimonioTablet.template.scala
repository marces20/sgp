
package views.html.patrimonio

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
object mainPatrimonioTablet extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
<title>"""),_display_(Seq[Any](/*7.9*/title)),format.raw/*7.14*/("""</title>
<link rel="shortcut icon" href="/assets/images/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Assets.at("plugins/bootstrap/css/bootstrap.min.css"))),format.raw/*10.105*/("""">

"""),_display_(Seq[Any](/*12.2*/scripts)),format.raw/*12.9*/("""

</head>
<body>

	<div class="container">
		"""),_display_(Seq[Any](/*18.4*/content)),format.raw/*18.11*/("""
	</div>
	
	
</body>
</html>
"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/mainPatrimonioTablet.scala.html
                    HASH: b537fa1c9aafcc8093af6d09e47b3956e1078dcf
                    MATRIX: 810->1|981->57|1008->80|1081->119|1107->124|1331->312|1346->318|1422->371|1462->376|1490->383|1571->429|1600->436
                    LINES: 26->1|30->1|31->3|35->7|35->7|38->10|38->10|38->10|40->12|40->12|46->18|46->18
                    -- GENERATED --
                */
            