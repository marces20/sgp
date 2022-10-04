
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
object mainContentDashboard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("stylesheets/theme_styles.css"))),format.raw/*12.94*/("""">

<link rel="stylesheet" href=""""),_display_(Seq[Any](/*14.31*/routes/*14.37*/.Assets.at("plugins/autosuggest/css/autosuggest_inquisitor.css"))),format.raw/*14.101*/("""" type="text/css" media="screen" charset="utf-8" />

<script src=""""),_display_(Seq[Any](/*16.15*/routes/*16.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.js"))),format.raw/*16.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*17.15*/routes/*17.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.map"))),format.raw/*17.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*18.15*/routes/*18.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*18.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("plugins/bootstrap/js/bootstrap.min.js"))),format.raw/*19.72*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*20.15*/routes/*20.21*/.Assets.at("plugins/autosuggest/js/bsn.AutoSuggest_2.1.3.js"))),format.raw/*20.82*/("""" type="text/javascript" charset="utf-8"></script>
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/general.js"))),format.raw/*21.57*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("javascripts/suggests.js"))),format.raw/*22.58*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/modalesInformativos.js"))),format.raw/*23.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("plugins/jquery.maskedinput.js"))),format.raw/*24.64*/("""" type="text/javascript"></script>

<script src=""""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("plugins/jquery-ui-1.10.3/js/jquery-ui-1.10.3.custom.js"))),format.raw/*26.89*/("""" type="text/javascript"></script>
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*27.31*/routes/*27.37*/.Assets.at("plugins/jquery-ui-1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css"))),format.raw/*27.122*/("""" type="text/css" media="screen" charset="utf-8" />

<script src=""""),_display_(Seq[Any](/*29.15*/routes/*29.21*/.Assets.at("javascripts/modalesBusqueda.js"))),format.raw/*29.65*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*30.15*/routes/*30.21*/.Assets.at("plugins/jsapi.js"))),format.raw/*30.51*/("""" type="text/javascript"></script>
<script type="text/javascript" src=""""),_display_(Seq[Any](/*31.38*/routes/*31.44*/.Assets.at("plugins/loader.js"))),format.raw/*31.75*/(""""></script>

"""),_display_(Seq[Any](/*33.2*/scripts)),format.raw/*33.9*/("""

</head>
<body>
	<div class="container" id="header">
		<div  class="col-sm-1">
			<img height="55" alt="Logo" src="/assets/images/logo-solo.png" />
		</div>
		<div  class="col-sm-10">
			<h1 id="tituloHeader">SISTEMA ADMINISTRACION PARQUE DE LA SALUD</h1>
			<h2 class="subtituloHeader"><i>"Parque de la Salud de la Provincia de Misiones Dr. Ramón Madariaga Ley XVII Nº 70"</i></h2>
		</div>
		<div  class="col-sm-2">
			<a class="navbar-brand" style="color:#FFFFFF" href=""""),_display_(Seq[Any](/*46.57*/routes/*46.63*/.Authentication.logout())),format.raw/*46.87*/("""">
		    ("""),_display_(Seq[Any](/*47.9*/if(session.get("nick") != null)/*47.40*/ {_display_(Seq[Any](_display_(Seq[Any](/*47.43*/(session.get("nick"))))))})),format.raw/*47.65*/(""") <i class="glyphicon glyphicon-log-out"></i> Salir</a>
      	</div>	  
		
	</div>
	
	<div class="navbar navbar-menu-principal navbar-static-top " style="min-height: 15px;">
		<div class="container">
			<div class="navbar-header"></div>
			<!--/.nav-collapse -->
		</div>
	</div>
	
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Horonarios <b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<!-- <li><a href=""""),_display_(Seq[Any](/*66.33*/controllers/*66.44*/.dashboard.routes.HonorariosController.index())),format.raw/*66.90*/("""">Estado General</a></li> -->
		            <li><a href=""""),_display_(Seq[Any](/*67.29*/controllers/*67.40*/.dashboard.routes.HonorariosController.estadoGeneralPorAgente())),format.raw/*67.103*/("""">Estado general agente</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*68.29*/controllers/*68.40*/.dashboard.routes.HonorariosController.estadoDeuda())),format.raw/*68.92*/("""">Estado de Deudas</a></li>
		          </ul>
		        </li>
		      </ul>
		      
		    </div>  
		</div>
	</nav>
	
	<div class="container">
		"""),_display_(Seq[Any](/*78.4*/content)),format.raw/*78.11*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/mainContentDashboard.scala.html
                    HASH: 721a43f1e8cf90f4b92ef97862f530b06b013dba
                    MATRIX: 799->1|970->57|997->80|1070->119|1096->124|1320->312|1335->318|1411->371|1495->419|1510->425|1568->461|1652->509|1667->515|1731->557|1801->591|1816->597|1903->661|2006->728|2021->734|2091->782|2176->831|2191->837|2262->886|2347->935|2362->941|2433->990|2518->1039|2533->1045|2606->1096|2691->1145|2706->1151|2789->1212|2890->1277|2905->1283|2963->1319|3048->1368|3063->1374|3122->1411|3207->1460|3222->1466|3292->1514|3377->1563|3392->1569|3457->1612|3543->1662|3558->1668|3648->1736|3749->1801|3764->1807|3872->1892|3975->1959|3990->1965|4056->2009|4141->2058|4156->2064|4208->2094|4316->2166|4331->2172|4384->2203|4433->2217|4461->2224|4972->2699|4987->2705|5033->2729|5079->2740|5119->2771|5168->2774|5216->2796|5945->3489|5965->3500|6033->3546|6127->3604|6147->3615|6233->3678|6330->3739|6350->3750|6424->3802|6606->3949|6635->3956
                    LINES: 26->1|30->1|31->3|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|42->14|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|54->26|54->26|54->26|55->27|55->27|55->27|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|61->33|61->33|74->46|74->46|74->46|75->47|75->47|75->47|75->47|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|106->78|106->78
                    -- GENERATED --
                */
            