
package views.html.haberes.liquidacionMeses.reportes

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
object modalControlDatosAfipGanancias extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.tags.successError())),format.raw/*4.32*/("""
"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">Descargar archivo de informe</a>
		</div>
	</div>
""")))}/*11.2*/else/*11.6*/{_display_(Seq[Any](format.raw/*11.7*/("""
	
	"""),_display_(Seq[Any](/*13.3*/helper/*13.9*/.form(action = controllers.haberes.routes.LiquidacionMesesReportesController.reportesControlDatosAfipGanancias(), 'id -> "formControlDatosAfipGanancias")/*13.162*/ {_display_(Seq[Any](format.raw/*13.164*/("""
		
		<div class="row">
			<div class="col-sm-3">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*19.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo_modal"))),format.raw/*19.89*/("""
					"""),_display_(Seq[Any](/*20.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id_modal"))),format.raw/*20.90*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*25.20*/controllers/*25.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*25.84*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.periodo.simple" 
								data-label="#periodo_modal" 
								data-field="#periodo_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
					</span>
				</div>
			</div>
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Crear Archvio</button>
			</div>
		</div>
	""")))})),format.raw/*40.3*/("""
""")))})),format.raw/*41.2*/("""	
"""),_display_(Seq[Any](/*42.2*/flash()/*42.9*/.clear())),format.raw/*42.17*/("""

<script>
 $( function () """),format.raw/*45.17*/("""{"""),format.raw/*45.18*/("""
	 $('.searchModal').modalSearch();
	 if($("#periodo_modal").length)"""),format.raw/*47.33*/("""{"""),format.raw/*47.34*/("""
			var options = """),format.raw/*48.18*/("""{"""),format.raw/*48.19*/("""
					script:"/contabilidad/suggestPeriodo/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*54.31*/("""{"""),format.raw/*54.32*/(""" 
												$("#periodo_id_modal").val(obj.id); 
											 """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/("""
				"""),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""";
			var as_json = new bsn.AutoSuggest('periodo_modal', options);
		"""),format.raw/*59.3*/("""}"""),format.raw/*59.4*/("""
 """),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
 </script>		"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/reportes/modalControlDatosAfipGanancias.scala.html
                    HASH: dd7f5bfe5e66f1a1ed173e49fcbe234892e17dbb
                    MATRIX: 845->1|993->66|1025->90|1099->47|1127->134|1164->137|1176->142|1222->167|1258->169|1272->176|1311->178|1466->298|1485->309|1572->374|1643->427|1655->431|1693->432|1733->437|1747->443|1910->596|1951->598|2141->753|2245->835|2287->842|2392->925|2594->1091|2614->1102|2689->1155|3189->1624|3222->1626|3260->1629|3275->1636|3305->1644|3360->1671|3389->1672|3485->1740|3514->1741|3560->1759|3589->1760|3770->1913|3799->1914|3890->1977|3919->1978|3951->1983|3979->1984|4074->2052|4102->2053|4131->2055|4159->2056
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|36->8|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|41->13|47->19|47->19|48->20|48->20|53->25|53->25|53->25|68->40|69->41|70->42|70->42|70->42|73->45|73->45|75->47|75->47|76->48|76->48|82->54|82->54|84->56|84->56|85->57|85->57|87->59|87->59|88->60|88->60
                    -- GENERATED --
                */
            