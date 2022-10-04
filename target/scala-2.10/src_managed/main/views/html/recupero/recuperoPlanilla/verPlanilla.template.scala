
package views.html.recupero.recuperoPlanilla

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
object verPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoPlanilla],models.recupero.RecuperoPlanilla,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(planillaForm: Form[models.recupero.RecuperoPlanilla], planilla: models.recupero.RecuperoPlanilla):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/recupero/planilla.js"))),format.raw/*6.68*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.100*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""


"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.recupero.mainRecupero("Vista de planilla", scripts)/*10.64*/ {_display_(Seq[Any](format.raw/*10.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de planilla</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="reporteDesdePlanilla" href="#" data-url=""""),_display_(Seq[Any](/*24.61*/controllers/*24.72*/.recupero.routes.RecuperoReportesController.informeDesdePlanilla(planilla.id))),format.raw/*24.149*/("""">Planilla Diaria</a></li>
				  			
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

			</div>
		</div>
	</div>
	
"""),_display_(Seq[Any](/*44.2*/views/*44.7*/.html.tags.successError())),format.raw/*44.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*48.13*/controllers/*48.24*/.recupero.routes.RecuperoPlanillasController.crear())),_display_(Seq[Any](/*48.77*/UriTrack/*48.85*/.get("?"))),format.raw/*48.94*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*49.13*/controllers/*49.24*/.recupero.routes.RecuperoPlanillasController.editar(planilla.id))),_display_(Seq[Any](/*49.89*/UriTrack/*49.97*/.get("&"))),format.raw/*49.106*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*50.13*/controllers/*50.24*/.recupero.routes.RecuperoPlanillasController.eliminar(planilla.id))),_display_(Seq[Any](/*50.91*/UriTrack/*50.99*/.get("&"))),format.raw/*50.108*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*53.13*/UriTrack/*53.21*/.getOnNull(controllers.recupero.routes.RecuperoPlanillasController.index().absoluteURL()))),format.raw/*53.110*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Numero</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*59.49*/planilla/*59.57*/.numero)),format.raw/*59.64*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Expediente</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*64.6*/if(planilla.expediente != null)/*64.37*/{_display_(Seq[Any](_display_(Seq[Any](/*64.39*/planilla/*64.47*/.expediente.getExpedienteEjercicio()))))})),format.raw/*64.84*/("""
			</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*69.49*/planillaForm("fecha")/*69.70*/.value)),format.raw/*69.76*/("""</p>
		</div>
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*73.49*/planillaForm("deposito.nombre")/*73.80*/.value)),format.raw/*73.86*/("""</p>
		</div>
	</div>
		
		
	<hr />	
		
	 
	 
""")))})),format.raw/*82.2*/("""


"""))}
    }
    
    def render(planillaForm:Form[models.recupero.RecuperoPlanilla],planilla:models.recupero.RecuperoPlanilla): play.api.templates.HtmlFormat.Appendable = apply(planillaForm,planilla)
    
    def f:((Form[models.recupero.RecuperoPlanilla],models.recupero.RecuperoPlanilla) => play.api.templates.HtmlFormat.Appendable) = (planillaForm,planilla) => apply(planillaForm,planilla)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/verPlanilla.scala.html
                    HASH: 93a3e2b731a188a94c32821fdf0fa1243590a735
                    MATRIX: 871->1|1080->209|1094->216|1178->220|1230->237|1244->243|1311->289|1379->137|1411->161|1486->99|1515->205|1544->326|1586->333|1599->338|1665->395|1705->397|2301->957|2321->968|2421->1045|2954->1543|2967->1548|3014->1573|3124->1647|3144->1658|3227->1711|3244->1719|3275->1728|3407->1824|3427->1835|3522->1900|3539->1908|3571->1917|3699->2009|3719->2020|3816->2087|3833->2095|3865->2104|4065->2268|4082->2276|4194->2365|4461->2596|4478->2604|4507->2611|4731->2800|4771->2831|4819->2833|4836->2841|4899->2878|5077->3020|5107->3041|5135->3047|5330->3206|5370->3237|5398->3243|5485->3299
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->4|35->4|36->1|37->4|38->7|41->10|41->10|41->10|41->10|55->24|55->24|55->24|75->44|75->44|75->44|79->48|79->48|79->48|79->48|79->48|80->49|80->49|80->49|80->49|80->49|81->50|81->50|81->50|81->50|81->50|84->53|84->53|84->53|90->59|90->59|90->59|95->64|95->64|95->64|95->64|95->64|100->69|100->69|100->69|104->73|104->73|104->73|113->82
                    -- GENERATED --
                */
            