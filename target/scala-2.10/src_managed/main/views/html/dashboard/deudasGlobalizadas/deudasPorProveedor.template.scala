
package views.html.dashboard.deudasGlobalizadas

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
object deudasPorProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Deudas por Proveedor")/*7.60*/ {_display_(Seq[Any](format.raw/*7.62*/("""
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*8.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Globalizadas</h1>
		</div>
		
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	
			  	
			  </ul>
			</div>
			
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-cog"></i>
			    Acciones
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation" class="dropdown-header">Acciones Masivas</li>
			  </ul>
			</div>
				
			
		</div>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
	</div>
</div>

<script>
$( function ()"""),format.raw/*50.15*/("""{"""),format.raw/*50.16*/("""
	$('#tr-otrosProveedores').click( function()"""),format.raw/*51.45*/("""{"""),format.raw/*51.46*/("""
		if($("#listaOtrosProveedores").hasClass("hidden"))"""),format.raw/*52.53*/("""{"""),format.raw/*52.54*/("""
			$( "#listaOtrosProveedores" ).removeClass( "hidden");
		"""),format.raw/*54.3*/("""}"""),format.raw/*54.4*/("""else"""),format.raw/*54.8*/("""{"""),format.raw/*54.9*/("""
			$( "#listaOtrosProveedores" ).addClass( "hidden");
		"""),format.raw/*56.3*/("""}"""),format.raw/*56.4*/("""
	"""),format.raw/*57.2*/("""}"""),format.raw/*57.3*/(""");
	$('#tr-otrosProveedoresProfe').click( function()"""),format.raw/*58.50*/("""{"""),format.raw/*58.51*/("""
		if($("#listaOtrosProveedoresProfe").hasClass("hidden"))"""),format.raw/*59.58*/("""{"""),format.raw/*59.59*/("""
			$( "#listaOtrosProveedoresProfe" ).removeClass( "hidden");
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/("""else"""),format.raw/*61.8*/("""{"""),format.raw/*61.9*/("""
			$( "#listaOtrosProveedoresProfe" ).addClass( "hidden");
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/("""
	"""),format.raw/*64.2*/("""}"""),format.raw/*64.3*/(""");
"""),format.raw/*65.1*/("""}"""),format.raw/*65.2*/(""");	
</script>
""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasPorProveedor.scala.html
                    HASH: 54cd5e7e1fb83bf922b72b78c6da0abba73e22c6
                    MATRIX: 821->1|988->85|1020->109|1094->28|1122->153|1159->156|1171->161|1232->214|1271->216|1307->218|1319->223|1398->281|2519->1374|2548->1375|2621->1420|2650->1421|2731->1474|2760->1475|2847->1535|2875->1536|2906->1540|2934->1541|3018->1598|3046->1599|3075->1601|3103->1602|3183->1654|3212->1655|3298->1713|3327->1714|3419->1779|3447->1780|3478->1784|3506->1785|3595->1847|3623->1848|3652->1850|3680->1851|3710->1854|3738->1855
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|38->8|38->8|38->8|80->50|80->50|81->51|81->51|82->52|82->52|84->54|84->54|84->54|84->54|86->56|86->56|87->57|87->57|88->58|88->58|89->59|89->59|91->61|91->61|91->61|91->61|93->63|93->63|94->64|94->64|95->65|95->65
                    -- GENERATED --
                */
            