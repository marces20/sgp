
package views.html.haberes.puestosLaborales.acciones

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
object modalCrearNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

																					
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.haberes.routes.PuestosLaboralesAccionesController.crearNovedadesBasicas(), 'id -> "formCrearNovedadesBasicas")/*6.145*/ {_display_(Seq[Any](format.raw/*6.147*/("""											
 	
 	"""),_display_(Seq[Any](/*8.4*/views/*8.9*/.html.tags.successError())),format.raw/*8.34*/("""
 	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="periodo" class="control-label">Periodo Desde</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*15.7*/inputText(formBuscador("periodo_desde.nombre"), 'class -> "form-control", 'id -> "periodo_desde"))),format.raw/*15.104*/("""
					"""),_display_(Seq[Any](/*16.7*/inputText(formBuscador("periodo_desde_id"),'hidden -> "hidden", 'id -> "periodo_desde_id"))),format.raw/*16.97*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoDesde" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*21.21*/controllers/*21.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*21.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_desde" 
									data-field="#periodo_desde_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group ">
				<label for="periodo" class="control-label">Periodo Hasta</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*37.7*/inputText(formBuscador("periodoHasta.nombre"), 'class -> "form-control", 'id -> "periodo_hasta"))),format.raw/*37.103*/("""
					"""),_display_(Seq[Any](/*38.7*/inputText(formBuscador("periodo_hasta_id"),'hidden -> "hidden", 'id -> "periodo_hasta_id"))),format.raw/*38.97*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoHasta" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*43.21*/controllers/*43.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*43.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_hasta" 
									data-field="#periodo_hasta_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Crear Novedades"><i class="glyphicon glyphicon-arrow-right"></i> Crear Novedades</button>
		</div>
	</div>

""")))})),format.raw/*63.2*/(""" 
<script>
$( function()"""),format.raw/*65.14*/("""{"""),format.raw/*65.15*/("""
	$('#searchPeriodoDesde').modalSearch();
	$('#searchPeriodoHasta').modalSearch();
"""),format.raw/*68.1*/("""}"""),format.raw/*68.2*/(""");
</script>
"""),_display_(Seq[Any](/*70.2*/flash()/*70.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/acciones/modalCrearNovedades.scala.html
                    HASH: a09478378f2e03c4b1fe6a0d84cd6a54c3928a89
                    MATRIX: 827->1|956->47|988->71|1062->28|1090->115|1150->141|1163->147|1309->284|1349->286|1401->304|1413->309|1459->334|1675->515|1795->612|1837->619|1949->709|2160->884|2180->895|2255->948|2745->1403|2864->1499|2906->1506|3018->1596|3229->1771|3249->1782|3324->1835|3877->2357|3929->2381|3958->2382|4068->2465|4096->2466|4145->2480|4160->2487
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|34->6|36->8|36->8|36->8|43->15|43->15|44->16|44->16|49->21|49->21|49->21|65->37|65->37|66->38|66->38|71->43|71->43|71->43|91->63|93->65|93->65|96->68|96->68|98->70|98->70
                    -- GENERATED --
                */
            