
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
object editarPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoPlanilla],models.recupero.RecuperoPlanilla,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(planillaForm: Form[models.recupero.RecuperoPlanilla],planilla:models.recupero.RecuperoPlanilla):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/recupero/planilla.js"))),format.raw/*6.68*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.recupero.mainRecupero("Modificar Planilla", scripts)/*9.65*/ {_display_(Seq[Any](format.raw/*9.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Planilla</h1>
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.recupero.routes.RecuperoPlanillasController.crear())),format.raw/*41.79*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Planilla</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/if(flash.containsKey("error"))/*49.33*/ {_display_(Seq[Any](format.raw/*49.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*51.5*/flash/*51.10*/.get("error"))),format.raw/*51.23*/("""
		</div>
	""")))})),format.raw/*53.3*/("""
	
													  
	"""),_display_(Seq[Any](/*56.3*/helper/*56.9*/.form(action = controllers.recupero.routes.RecuperoPlanillasController.actualizar(planilla.id))/*56.104*/ {_display_(Seq[Any](format.raw/*56.106*/("""

	
		"""),_display_(Seq[Any](/*59.4*/inputText(planillaForm("id"), 'hidden -> "hidden"))),format.raw/*59.54*/("""
		"""),_display_(Seq[Any](/*60.4*/views/*60.9*/.html.recupero.recuperoPlanilla.formPlanilla(planillaForm))),format.raw/*60.67*/("""
		 
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*66.3*/("""

""")))})))}
    }
    
    def render(planillaForm:Form[models.recupero.RecuperoPlanilla],planilla:models.recupero.RecuperoPlanilla): play.api.templates.HtmlFormat.Appendable = apply(planillaForm,planilla)
    
    def f:((Form[models.recupero.RecuperoPlanilla],models.recupero.RecuperoPlanilla) => play.api.templates.HtmlFormat.Appendable) = (planillaForm,planilla) => apply(planillaForm,planilla)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/editarPlanilla.scala.html
                    HASH: 51bfe23eb8680f00644b7c8ec68ff1d6ed1613ef
                    MATRIX: 874->1|1063->187|1077->194|1161->198|1212->214|1226->220|1293->266|1360->116|1392->140|1466->97|1494->184|1522->302|1559->305|1571->310|1637->368|1676->370|2679->1337|2699->1348|2773->1400|2951->1543|2990->1573|3030->1575|3105->1615|3119->1620|3154->1633|3197->1645|3253->1666|3267->1672|3372->1767|3413->1769|3455->1776|3527->1826|3566->1830|3579->1835|3659->1893|3751->1954
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|71->41|71->41|71->41|79->49|79->49|79->49|81->51|81->51|81->51|83->53|86->56|86->56|86->56|86->56|89->59|89->59|90->60|90->60|90->60|96->66
                    -- GENERATED --
                */
            