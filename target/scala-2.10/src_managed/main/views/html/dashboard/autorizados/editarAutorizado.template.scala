
package views.html.dashboard.autorizados

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
object editarAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Autorizado],Autorizado,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(autorizadoForm: Form[Autorizado],autorizado:Autorizado):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/dashboard/autorizado.js"))),format.raw/*6.71*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.dashboard.mainDashboard("Modificar Autorizados", scripts)/*9.70*/ {_display_(Seq[Any](format.raw/*9.72*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Autorizado</h1>
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
				  	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.dashboard.routes.AutorizadosController.crear())),format.raw/*41.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Autorizado</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/views/*49.8*/.html.tags.successError())),format.raw/*49.33*/("""

	"""),_display_(Seq[Any](/*51.3*/helper/*51.9*/.form(action = controllers.dashboard.routes.AutorizadosController.actualizar(autorizado.id))/*51.101*/ {_display_(Seq[Any](format.raw/*51.103*/("""

	
		"""),_display_(Seq[Any](/*54.4*/inputText(autorizadoForm("id"), 'hidden -> "hidden",'id -> "idAutorizado"))),format.raw/*54.78*/("""
		"""),_display_(Seq[Any](/*55.4*/views/*55.9*/.html.dashboard.autorizados.formAutorizado(autorizadoForm))),format.raw/*55.67*/("""
		"""),_display_(Seq[Any](/*56.4*/views/*56.9*/.html.dashboard.autorizados.tabsAutorizados(true, autorizadoForm,autorizado))),format.raw/*56.85*/("""
		
		
	
		<h4>Total: 		<div id="editarTotalLoading" class="loading hide"></div><b id="editarTotal">"""),_display_(Seq[Any](/*60.93*/utils/*60.98*/.NumberUtils.moneda(autorizado.getTotal()))),format.raw/*60.140*/("""</b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*61.27*/autorizado/*61.37*/.estado.nombre)),format.raw/*61.51*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*66.3*/("""

""")))})))}
    }
    
    def render(autorizadoForm:Form[Autorizado],autorizado:Autorizado): play.api.templates.HtmlFormat.Appendable = apply(autorizadoForm,autorizado)
    
    def f:((Form[Autorizado],Autorizado) => play.api.templates.HtmlFormat.Appendable) = (autorizadoForm,autorizado) => apply(autorizadoForm,autorizado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/editarAutorizado.scala.html
                    HASH: 7943b0b9327ddd1effca2fb2a68924ab765c2482
                    MATRIX: 828->1|977->147|991->154|1075->158|1126->174|1140->180|1210->229|1277->76|1309->100|1383->57|1411->144|1439->265|1476->268|1488->273|1559->336|1598->338|2603->1307|2623->1318|2692->1365|2872->1510|2885->1515|2932->1540|2971->1544|2985->1550|3087->1642|3128->1644|3170->1651|3266->1725|3305->1729|3318->1734|3398->1792|3437->1796|3450->1801|3548->1877|3686->1979|3700->1984|3765->2026|3838->2063|3857->2073|3893->2087|3990->2153
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|71->41|71->41|71->41|79->49|79->49|79->49|81->51|81->51|81->51|81->51|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|90->60|90->60|90->60|91->61|91->61|91->61|96->66
                    -- GENERATED --
                */
            