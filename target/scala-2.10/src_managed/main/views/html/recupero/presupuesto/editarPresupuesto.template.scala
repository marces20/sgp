
package views.html.recupero.presupuesto

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
object editarPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.Presupuesto],models.recupero.Presupuesto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(presupuestoForm: Form[models.recupero.Presupuesto],presupuesto:models.recupero.Presupuesto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/recupero/presupuesto.js"))),format.raw/*6.71*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.recupero.mainRecupero("Modificar presupuesto", scripts)/*9.68*/ {_display_(Seq[Any](format.raw/*9.70*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar presupuesto</h1>
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.recupero.routes.PresupuestosController.crear())),format.raw/*41.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Presupuesto</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/if(flash.containsKey("error"))/*49.33*/ {_display_(Seq[Any](format.raw/*49.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*51.5*/flash/*51.10*/.get("error"))),format.raw/*51.23*/("""
		</div>
	""")))})),format.raw/*53.3*/("""
	

	"""),_display_(Seq[Any](/*56.3*/helper/*56.9*/.form(action = controllers.recupero.routes.PresupuestosController.actualizar(presupuesto.id))/*56.102*/ {_display_(Seq[Any](format.raw/*56.104*/("""

	
		"""),_display_(Seq[Any](/*59.4*/inputText(presupuestoForm("id"), 'hidden -> "hidden"))),format.raw/*59.57*/("""
		"""),_display_(Seq[Any](/*60.4*/views/*60.9*/.html.recupero.presupuesto.formPresupuesto(presupuestoForm))),format.raw/*60.68*/("""
		"""),_display_(Seq[Any](/*61.4*/views/*61.9*/.html.recupero.presupuesto.tabsPresupuesto(true, presupuestoForm))),format.raw/*61.74*/("""	
		<h4>Total: 		<b></b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*63.27*/presupuesto/*63.38*/.estado.nombre)),format.raw/*63.52*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*68.3*/("""

""")))})))}
    }
    
    def render(presupuestoForm:Form[models.recupero.Presupuesto],presupuesto:models.recupero.Presupuesto): play.api.templates.HtmlFormat.Appendable = apply(presupuestoForm,presupuesto)
    
    def f:((Form[models.recupero.Presupuesto],models.recupero.Presupuesto) => play.api.templates.HtmlFormat.Appendable) = (presupuestoForm,presupuesto) => apply(presupuestoForm,presupuesto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/editarPresupuesto.scala.html
                    HASH: eaa089a3343e09a40a669c4f83613e1889a2222e
                    MATRIX: 862->1|1047->183|1061->190|1145->194|1196->210|1210->216|1280->265|1347->112|1379->136|1453->93|1481->180|1509->301|1546->304|1558->309|1627->370|1666->372|2672->1342|2692->1353|2761->1400|2942->1546|2981->1576|3021->1578|3096->1618|3110->1623|3145->1636|3188->1648|3229->1654|3243->1660|3346->1753|3387->1755|3429->1762|3504->1815|3543->1819|3556->1824|3637->1883|3676->1887|3689->1892|3776->1957|3869->2014|3889->2025|3925->2039|4022->2105
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|71->41|71->41|71->41|79->49|79->49|79->49|81->51|81->51|81->51|83->53|86->56|86->56|86->56|86->56|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|93->63|93->63|93->63|98->68
                    -- GENERATED --
                */
            