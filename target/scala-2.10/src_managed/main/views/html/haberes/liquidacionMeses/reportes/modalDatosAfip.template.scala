
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
object modalDatosAfip extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

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

	"""),_display_(Seq[Any](/*13.3*/helper/*13.9*/.form(action = controllers.haberes.routes.LiquidacionMesesReportesController.reportesDatosAfip(), 'id -> "formDatosAfip")/*13.130*/ {_display_(Seq[Any](format.raw/*13.132*/("""
		
		<!-- <div class="row">
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
		</div> -->
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/reportes/modalDatosAfip.scala.html
                    HASH: ecb903c259050ded1f0f596dc431233bceaf644e
                    MATRIX: 829->1|977->66|1009->90|1083->47|1111->134|1148->137|1160->142|1206->167|1242->169|1256->176|1295->178|1450->298|1469->309|1556->374|1627->427|1639->431|1677->432|1716->436|1730->442|1861->563|1902->565|2097->725|2201->807|2243->814|2348->897|2550->1063|2570->1074|2645->1127|3149->1600|3182->1602|3220->1605|3235->1612|3265->1620|3320->1647|3349->1648|3445->1716|3474->1717|3520->1735|3549->1736|3730->1889|3759->1890|3850->1953|3879->1954|3911->1959|3939->1960|4034->2028|4062->2029|4091->2031|4119->2032
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|36->8|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|41->13|47->19|47->19|48->20|48->20|53->25|53->25|53->25|68->40|69->41|70->42|70->42|70->42|73->45|73->45|75->47|75->47|76->48|76->48|82->54|82->54|84->56|84->56|85->57|85->57|87->59|87->59|88->60|88->60
                    -- GENERATED --
                */
            