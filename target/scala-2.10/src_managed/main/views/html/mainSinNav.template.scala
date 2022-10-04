
package views.html

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
object mainSinNav extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*11.46*/routes/*11.52*/.Assets.at("stylesheets/styles.css"))),format.raw/*11.88*/("""">
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*12.31*/routes/*12.37*/.Assets.at("plugins/autosuggest/css/autosuggest_inquisitor.css"))),format.raw/*12.101*/("""" type="text/css" media="screen" charset="utf-8" />

<script src=""""),_display_(Seq[Any](/*14.15*/routes/*14.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.js"))),format.raw/*14.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*15.15*/routes/*15.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.map"))),format.raw/*15.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*16.15*/routes/*16.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*16.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*17.15*/routes/*17.21*/.Assets.at("plugins/bootstrap/js/bootstrap.min.js"))),format.raw/*17.72*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*18.15*/routes/*18.21*/.Assets.at("plugins/autosuggest/js/bsn.AutoSuggest_2.1.3.js"))),format.raw/*18.82*/("""" type="text/javascript" charset="utf-8"></script>
<script src=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("javascripts/general.js"))),format.raw/*19.57*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*20.15*/routes/*20.21*/.Assets.at("javascripts/suggests.js"))),format.raw/*20.58*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/modalesInformativos.js"))),format.raw/*21.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("plugins/jquery.maskedinput.js"))),format.raw/*22.64*/("""" type="text/javascript"></script>

<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("plugins/jquery-ui-1.10.3/js/jquery-ui-1.10.3.custom.js"))),format.raw/*24.89*/("""" type="text/javascript"></script>
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*25.31*/routes/*25.37*/.Assets.at("plugins/jquery-ui-1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css"))),format.raw/*25.122*/("""" type="text/css" media="screen" charset="utf-8" />

<script src=""""),_display_(Seq[Any](/*27.15*/routes/*27.21*/.Assets.at("javascripts/modalesBusqueda.js"))),format.raw/*27.65*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*28.15*/routes/*28.21*/.Assets.at("plugins/jsapi.js"))),format.raw/*28.51*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*30.2*/scripts)),format.raw/*30.9*/("""

</head>
<body>
	<div class="container" id="header">
		<div id="left"><img alt="Logo" src="/assets/images/banner.png" /></div>
		<div id="right">
			<h1>Parque de la Salud de la Provincia de Misiones Dr. Ramón Madariaga Ley XVII Nº 70</h1>
		</div>
	</div>

	<div class="navbar navbar-menu-principal navbar-static-top " style="min-height: 15px;">
		<div class="container">
			<div class="navbar-header"></div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">
		"""),_display_(Seq[Any](/*49.4*/content)),format.raw/*49.11*/("""
	</div>
	
	
</body>
</html>"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:27 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/mainSinNav.scala.html
                    HASH: 91690c2143136546f385cce70c4a9c3b37fea925
                    MATRIX: 789->1|960->57|987->80|1060->119|1086->124|1310->312|1325->318|1401->371|1485->419|1500->425|1558->461|1627->494|1642->500|1729->564|1832->631|1847->637|1917->685|2002->734|2017->740|2088->789|2173->838|2188->844|2259->893|2344->942|2359->948|2432->999|2517->1048|2532->1054|2615->1115|2716->1180|2731->1186|2789->1222|2874->1271|2889->1277|2948->1314|3033->1363|3048->1369|3118->1417|3203->1466|3218->1472|3283->1515|3369->1565|3384->1571|3474->1639|3575->1704|3590->1710|3698->1795|3801->1862|3816->1868|3882->1912|3967->1961|3982->1967|4034->1997|4106->2034|4134->2041|4652->2524|4681->2531
                    LINES: 26->1|30->1|31->3|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|55->27|55->27|55->27|56->28|56->28|56->28|58->30|58->30|77->49|77->49
                    -- GENERATED --
                */
            