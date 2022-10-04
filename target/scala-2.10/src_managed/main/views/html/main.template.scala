
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._

def /*43.2*/getClassEstadoActive/*43.22*/(i:String) = {{
	var classEstado:String = new String()
	if(request.path.toLowerCase().contains(i.toLowerCase())){
		classEstado = "navbar-brand-active"
	}else{
		classEstado = ""
	}
	classEstado
}};
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
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*13.31*/routes/*13.37*/.Assets.at("plugins/jquery-ui-1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css"))),format.raw/*13.122*/("""" type="text/css" media="screen" charset="utf-8" />




<script src=""""),_display_(Seq[Any](/*18.15*/routes/*18.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.js"))),format.raw/*18.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("plugins/jquery/jquery-2.0.3.min.map"))),format.raw/*19.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*20.15*/routes/*20.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*20.70*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("plugins/bootstrap/js/bootstrap.min.js"))),format.raw/*21.72*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("plugins/autosuggest/js/bsn.AutoSuggest_2.1.3.js"))),format.raw/*22.82*/("""" type="text/javascript" charset="utf-8"></script>
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/general.js"))),format.raw/*23.57*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("javascripts/suggests.js"))),format.raw/*24.58*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*25.15*/routes/*25.21*/.Assets.at("javascripts/modalesInformativos.js"))),format.raw/*25.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("plugins/jquery.maskedinput.js"))),format.raw/*26.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*27.15*/routes/*27.21*/.Assets.at("plugins/jquery-ui-1.10.3/js/jquery-ui-1.10.3.custom.js"))),format.raw/*27.89*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*28.15*/routes/*28.21*/.Assets.at("javascripts/modalesBusqueda.js"))),format.raw/*28.65*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*29.15*/routes/*29.21*/.Assets.at("plugins/jsapi.js"))),format.raw/*29.51*/("""" type="text/javascript"></script>
<script type="text/javascript" src=""""),_display_(Seq[Any](/*30.38*/routes/*30.44*/.Assets.at("plugins/loader.js"))),format.raw/*30.75*/(""""></script>
<script type="text/javascript" src=""""),_display_(Seq[Any](/*31.38*/routes/*31.44*/.Assets.at("/plugins/chart.js/Chart.min.js"))),format.raw/*31.88*/(""""></script>



<!-- <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*35.51*/routes/*35.57*/.Assets.at("plugins/fullcalendar-2.2.7/fullcalendar.min.css"))),format.raw/*35.118*/("""">
<link rel="stylesheet" media="print" href=""""),_display_(Seq[Any](/*36.45*/routes/*36.51*/.Assets.at("plugins/fullcalendar-2.2.7/fullcalendar.print.css"))),format.raw/*36.114*/("""">
<script src=""""),_display_(Seq[Any](/*37.15*/routes/*37.21*/.Assets.at("plugins/fullcalendar-2.2.7/lib/moment.min.js"))),format.raw/*37.79*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*38.15*/routes/*38.21*/.Assets.at("plugins/fullcalendar-2.2.7/fullcalendar.min.js"))),format.raw/*38.81*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*39.15*/routes/*39.21*/.Assets.at("plugins/fullcalendar-2.2.7/lang/es.js"))),format.raw/*39.72*/("""" type="text/javascript"></script> -->

"""),_display_(Seq[Any](/*41.2*/scripts)),format.raw/*41.9*/("""

"""),format.raw/*51.2*/("""

</head>
<body>
	<div class="container" id="header">
		<div  class="col-sm-1">
			<a href="/"><img height="55" alt="Logo" src="/assets/images/logo-solo.png" /></a>
		</div>
		<div  class="col-sm-8">
			<h1 id="tituloHeader">SISTEMA ADMINISTRACION PARQUE DE LA SALUD</h1>
			<h2 class="subtituloHeader"><i>"Parque de la Salud de la Provincia de Misiones Dr. Ramón Madariaga Ley XVII Nº 70"</i></h2>
		</div>

		<div class="col-sm-1" style=" margin-top: 10px"><a style="color: """),_display_(Seq[Any](/*64.69*/if(models.Ticket.tieneSinLeer() && Usuario.getUsuarioSesion() == 1)/*64.136*/ {_display_(Seq[Any](format.raw/*64.138*/("""red""")))}/*64.143*/else/*64.148*/{_display_(Seq[Any](format.raw/*64.149*/("""#fff""")))})),format.raw/*64.154*/("""; font-size: 30px;" href=""""),_display_(Seq[Any](/*64.181*/controllers/*64.192*/.administracion.routes.TicketsController.index())),format.raw/*64.240*/(""""><i class="glyphicon glyphicon-inbox"></i></a></div>
		<div class="col-sm-2" >
		<a class="navbar-brand" style="color:#FFFFFF" href=""""),_display_(Seq[Any](/*66.56*/routes/*66.62*/.Authentication.logout())),format.raw/*66.86*/("""">
		    ("""),_display_(Seq[Any](/*67.9*/if(session.get("nick") != null)/*67.40*/ {_display_(Seq[Any](_display_(Seq[Any](/*67.43*/(session.get("nick"))))))})),format.raw/*67.65*/(""") <i class="glyphicon glyphicon-log-out"></i> Salir</a>
		</div>    
	</div>
	<!-- -------------------------------------------------------------------------------------------- -->
	
	<div class="navbar navbar-menu-principal navbar-static-top "></div>
	<nav class="navbar navbar-default navbarSap">
	  <div class="container-fluid">
		<!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-navSap">
	      
	        <!-- <li class="active"><a class="navbar-brand" href="#">Link <span class="sr-only">(current)</span></a></li>  
	        
	        <li><a class="navbar-brand" href=""""),_display_(Seq[Any](/*81.45*/routes/*81.51*/.Application.index())),format.raw/*81.71*/("""">Inicio</a></li>-->
	        
			"""),_display_(Seq[Any](/*83.5*/if(Modulo.check(Modulo.COMPRAS))/*83.37*/ {_display_(Seq[Any](format.raw/*83.39*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*84.33*/getClassEstadoActive("compras"))),format.raw/*84.64*/("""" href=""""),_display_(Seq[Any](/*84.73*/controllers/*84.84*/.compras.routes.IndexController.index())),format.raw/*84.123*/("""">Compras</a></li>
			""")))})),format.raw/*85.5*/("""
			"""),_display_(Seq[Any](/*86.5*/if(Modulo.check(Modulo.CONTABILIDAD))/*86.42*/ {_display_(Seq[Any](format.raw/*86.44*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*87.33*/getClassEstadoActive("contabilidad"))),format.raw/*87.69*/("""" href=""""),_display_(Seq[Any](/*87.78*/controllers/*87.89*/.contabilidad.routes.IndexController.index())),format.raw/*87.133*/("""">Contabilidad</a></li>
			""")))})),format.raw/*88.5*/("""
			"""),_display_(Seq[Any](/*89.5*/if(Modulo.check(Modulo.EXPEDIENTES))/*89.41*/ {_display_(Seq[Any](format.raw/*89.43*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*90.33*/getClassEstadoActive("expediente"))),format.raw/*90.67*/("""" href=""""),_display_(Seq[Any](/*90.76*/controllers/*90.87*/.expediente.routes.IndexController.index())),format.raw/*90.129*/("""">Expedientes</a></li>
			""")))})),format.raw/*91.5*/("""
			"""),_display_(Seq[Any](/*92.5*/if(Modulo.check(Modulo.RRHH))/*92.34*/ {_display_(Seq[Any](format.raw/*92.36*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*93.33*/getClassEstadoActive("rrhh"))),format.raw/*93.61*/("""" href=""""),_display_(Seq[Any](/*93.70*/controllers/*93.81*/.rrhh.routes.IndexController.index())),format.raw/*93.117*/("""">RRHH</a></li>
			""")))})),format.raw/*94.5*/("""
			
			"""),_display_(Seq[Any](/*96.5*/if(Modulo.check(Modulo.PRESUPUESTO))/*96.41*/ {_display_(Seq[Any](format.raw/*96.43*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*97.33*/getClassEstadoActive("presupuesto"))),format.raw/*97.68*/("""" href=""""),_display_(Seq[Any](/*97.77*/controllers/*97.88*/.presupuesto.routes.IndexController.index())),format.raw/*97.131*/("""">Presupuesto</a></li>
			""")))})),format.raw/*98.5*/("""
			"""),_display_(Seq[Any](/*99.5*/if(Usuario.getUsuarioSesion() == 1 || Modulo.check(Modulo.ADMINISTRACION))/*99.79*/ {_display_(Seq[Any](format.raw/*99.81*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*100.33*/getClassEstadoActive("administracion"))),format.raw/*100.71*/("""" href=""""),_display_(Seq[Any](/*100.80*/controllers/*100.91*/.administracion.routes.IndexController.index())),format.raw/*100.137*/("""">Administración</a></li>
			""")))})),format.raw/*101.5*/("""
			"""),_display_(Seq[Any](/*102.5*/if(Modulo.check(Modulo.RENDICIONES))/*102.41*/ {_display_(Seq[Any](format.raw/*102.43*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*103.33*/getClassEstadoActive("rendiciones"))),format.raw/*103.68*/("""" href=""""),_display_(Seq[Any](/*103.77*/controllers/*103.88*/.rendiciones.routes.IndexController.index())),format.raw/*103.131*/("""">Rendiciones</a></li>
			""")))})),format.raw/*104.5*/("""
			"""),_display_(Seq[Any](/*105.5*/if(Modulo.check(Modulo.PATRIMONIO))/*105.40*/ {_display_(Seq[Any](format.raw/*105.42*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*106.33*/getClassEstadoActive("patrimonio"))),format.raw/*106.67*/("""" href=""""),_display_(Seq[Any](/*106.76*/controllers/*106.87*/.patrimonio.routes.IndexController.index())),format.raw/*106.129*/("""">Patrimonio</a></li>
			""")))})),format.raw/*107.5*/("""
			"""),_display_(Seq[Any](/*108.5*/if(Modulo.check(Modulo.DASHBOARD))/*108.39*/ {_display_(Seq[Any](format.raw/*108.41*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*109.33*/getClassEstadoActive("dashboard"))),format.raw/*109.66*/("""" href=""""),_display_(Seq[Any](/*109.75*/controllers/*109.86*/.dashboard.routes.IndexController.index())),format.raw/*109.127*/("""">Tablero Control</a></li>
			""")))})),format.raw/*110.5*/("""
			"""),_display_(Seq[Any](/*111.5*/if(Modulo.check(Modulo.HABERES))/*111.37*/ {_display_(Seq[Any](format.raw/*111.39*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*112.33*/getClassEstadoActive("haberes"))),format.raw/*112.64*/("""" href=""""),_display_(Seq[Any](/*112.73*/controllers/*112.84*/.haberes.routes.IndexController.index())),format.raw/*112.123*/("""">Haberes</a></li>
			""")))})),format.raw/*113.5*/("""
			"""),_display_(Seq[Any](/*114.5*/if(Modulo.check(Modulo.RECUPERO))/*114.38*/ {_display_(Seq[Any](format.raw/*114.40*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*115.33*/getClassEstadoActive("recupero"))),format.raw/*115.65*/("""" href=""""),_display_(Seq[Any](/*115.74*/controllers/*115.85*/.recupero.routes.IndexController.index())),format.raw/*115.125*/("""">Recupero</a></li>
			""")))})),format.raw/*116.5*/("""
			"""),_display_(Seq[Any](/*117.5*/if(Modulo.check(Modulo.INFORMES))/*117.38*/ {_display_(Seq[Any](format.raw/*117.40*/("""
				<li><a class="navbar-brand """),_display_(Seq[Any](/*118.33*/getClassEstadoActive("recupero"))),format.raw/*118.65*/("""" href=""""),_display_(Seq[Any](/*118.74*/controllers/*118.85*/.informes.routes.IndexController.index())),format.raw/*118.125*/("""">Informes Gerenciales</a></li>
			""")))})),format.raw/*119.5*/("""
	        
	        
	        
	        
	        <!-- <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	            <li class="divider"></li>
	            <li><a href="#">One more separated link</a></li>
	          </ul>
	        </li> -->
	      </ul>
	      
	      
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<div class="navbar navbar-menu-principal navbar-static-top "></div>
	
	
	
	<!--  ---------------------------------------------------------------------------------------------->
	

	<div class="container">
		"""),_display_(Seq[Any](/*150.4*/content)),format.raw/*150.11*/("""
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
                    DATE: Tue Oct 04 11:43:27 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/main.scala.html
                    HASH: acb5c6f494c65d24a37b64a35f8163e82368816c
                    MATRIX: 783->1|938->2807|967->2827|1193->57|1220->80|1293->119|1319->124|1543->312|1558->318|1634->371|1718->419|1733->425|1791->461|1860->494|1875->500|1962->564|2080->646|2095->652|2203->737|2309->807|2324->813|2394->861|2479->910|2494->916|2565->965|2650->1014|2665->1020|2736->1069|2821->1118|2836->1124|2909->1175|2994->1224|3009->1230|3092->1291|3193->1356|3208->1362|3266->1398|3351->1447|3366->1453|3425->1490|3510->1539|3525->1545|3595->1593|3680->1642|3695->1648|3760->1691|3845->1740|3860->1746|3950->1814|4035->1863|4050->1869|4116->1913|4201->1962|4216->1968|4268->1998|4376->2070|4391->2076|4444->2107|4529->2156|4544->2162|4610->2206|4711->2271|4726->2277|4810->2338|4893->2385|4908->2391|4994->2454|5047->2471|5062->2477|5142->2535|5227->2584|5242->2590|5324->2650|5409->2699|5424->2705|5497->2756|5573->2797|5601->2804|5630->3023|6143->3500|6220->3567|6261->3569|6285->3574|6299->3579|6339->3580|6377->3585|6441->3612|6462->3623|6533->3671|6704->3806|6719->3812|6765->3836|6811->3847|6851->3878|6900->3881|6948->3903|7697->4616|7712->4622|7754->4642|7824->4677|7865->4709|7905->4711|7974->4744|8027->4775|8072->4784|8092->4795|8154->4834|8208->4857|8248->4862|8294->4899|8334->4901|8403->4934|8461->4970|8506->4979|8526->4990|8593->5034|8652->5062|8692->5067|8737->5103|8777->5105|8846->5138|8902->5172|8947->5181|8967->5192|9032->5234|9090->5261|9130->5266|9168->5295|9208->5297|9277->5330|9327->5358|9372->5367|9392->5378|9451->5414|9502->5434|9546->5443|9591->5479|9631->5481|9700->5514|9757->5549|9802->5558|9822->5569|9888->5612|9946->5639|9986->5644|10069->5718|10109->5720|10179->5753|10240->5791|10286->5800|10307->5811|10377->5857|10439->5887|10480->5892|10526->5928|10567->5930|10637->5963|10695->5998|10741->6007|10762->6018|10829->6061|10888->6088|10929->6093|10974->6128|11015->6130|11085->6163|11142->6197|11188->6206|11209->6217|11275->6259|11333->6285|11374->6290|11418->6324|11459->6326|11529->6359|11585->6392|11631->6401|11652->6412|11717->6453|11780->6484|11821->6489|11863->6521|11904->6523|11974->6556|12028->6587|12074->6596|12095->6607|12158->6646|12213->6669|12254->6674|12297->6707|12338->6709|12408->6742|12463->6774|12509->6783|12530->6794|12594->6834|12650->6858|12691->6863|12734->6896|12775->6898|12845->6931|12900->6963|12946->6972|12967->6983|13031->7023|13099->7059|14114->8038|14144->8045
                    LINES: 26->1|29->43|29->43|38->1|39->3|43->7|43->7|46->10|46->10|46->10|47->11|47->11|47->11|48->12|48->12|48->12|49->13|49->13|49->13|54->18|54->18|54->18|55->19|55->19|55->19|56->20|56->20|56->20|57->21|57->21|57->21|58->22|58->22|58->22|59->23|59->23|59->23|60->24|60->24|60->24|61->25|61->25|61->25|62->26|62->26|62->26|63->27|63->27|63->27|64->28|64->28|64->28|65->29|65->29|65->29|66->30|66->30|66->30|67->31|67->31|67->31|71->35|71->35|71->35|72->36|72->36|72->36|73->37|73->37|73->37|74->38|74->38|74->38|75->39|75->39|75->39|77->41|77->41|79->51|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|94->66|94->66|94->66|95->67|95->67|95->67|95->67|109->81|109->81|109->81|111->83|111->83|111->83|112->84|112->84|112->84|112->84|112->84|113->85|114->86|114->86|114->86|115->87|115->87|115->87|115->87|115->87|116->88|117->89|117->89|117->89|118->90|118->90|118->90|118->90|118->90|119->91|120->92|120->92|120->92|121->93|121->93|121->93|121->93|121->93|122->94|124->96|124->96|124->96|125->97|125->97|125->97|125->97|125->97|126->98|127->99|127->99|127->99|128->100|128->100|128->100|128->100|128->100|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|131->103|132->104|133->105|133->105|133->105|134->106|134->106|134->106|134->106|134->106|135->107|136->108|136->108|136->108|137->109|137->109|137->109|137->109|137->109|138->110|139->111|139->111|139->111|140->112|140->112|140->112|140->112|140->112|141->113|142->114|142->114|142->114|143->115|143->115|143->115|143->115|143->115|144->116|145->117|145->117|145->117|146->118|146->118|146->118|146->118|146->118|147->119|178->150|178->150
                    -- GENERATED --
                */
            