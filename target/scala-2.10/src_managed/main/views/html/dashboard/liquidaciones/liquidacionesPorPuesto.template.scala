
package views.html.dashboard.liquidaciones

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
object liquidacionesPorPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,puesto_laboral_id:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Liquidaciones por Puesto Laboral")/*7.72*/ {_display_(Seq[Any](format.raw/*7.74*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/liquidacionesPorPuesto.js"))),format.raw/*12.82*/("""" type="text/javascript"></script>
<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Liquidaciones por Puesto Laboral</h1>
			</div>
		</div>
</div>			
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorPuesto" method="GET">
			<div class="col-sm-4">
				<label for="solicitante" class="control-label">Puesto Laboral</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*27.7*/inputText(formBuscador("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral"))),format.raw/*27.120*/("""
					"""),_display_(Seq[Any](/*28.7*/inputText(formBuscador("puesto_id"), 'hidden -> "hidden", 'id -> "puesto_id"))),format.raw/*28.84*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPuestoLaboral" 
									data-title="Selección de puesto laboral" 
									data-url=""""),_display_(Seq[Any](/*33.21*/controllers/*33.32*/.haberes.routes.PuestosLaboralesController.modalBuscar())),format.raw/*33.88*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.puestoLaboral.simple" 
									data-label="#puesto_laboral" 
									data-field="#puesto_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
				<div class="col-sm-2">
					<label for="inputPeriodo" class="control-label">Periodo de inicio</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*47.8*/inputText(formBuscador("periodo_inicio"),'class -> "form-control",'id -> "periodo_inicio"))),format.raw/*47.98*/("""
						"""),_display_(Seq[Any](/*48.8*/inputText(formBuscador("periodo_inicio_id"),'hidden -> "hidden",'id -> "periodo_inicio_id"))),format.raw/*48.99*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*53.21*/controllers/*53.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*53.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_inicio" 
									data-field="#periodo_inicio_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
						</span>
					</div>
				</div>
			
				<div class="col-sm-2">
					<label for="inputPeriodo" class="control-label">Periodo de fin</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*68.8*/inputText(formBuscador("periodo_fin"),'class -> "form-control",'id -> "periodo_fin"))),format.raw/*68.92*/("""
						"""),_display_(Seq[Any](/*69.8*/inputText(formBuscador("periodo_fin_id"),'hidden -> "hidden",'id -> "periodo_fin_id"))),format.raw/*69.93*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoFin" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*74.21*/controllers/*74.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*74.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_fin" 
									data-field="#periodo_fin_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
						</span>
					</div>
				</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			</form>
		</div>
	</form>
</div>
<hr>

<div id="piechart"></div>



"""),_display_(Seq[Any](/*101.2*/if(puesto_laboral_id != null && !puesto_laboral_id.isEmpty())/*101.63*/{_display_(Seq[Any](format.raw/*101.64*/("""	
	<input type="hidden" name="puesto_laboral_id" id="puesto_laboral_id" value=""""),_display_(Seq[Any](/*102.79*/(puesto_laboral_id))),format.raw/*102.98*/(""""/>
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Datos</b>
				</div>
				<div class="panel-body" id="div-datos-puestos">
					
				
				</div>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Liquidaciones</b>
				</div>
				<div class="panel-body" id="div-ultimas-liquidaciones">
					
				
				</div>
			</div>	
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Liquidaciones Agrupadas por Clasificacion Concepto</b>
				</div>
				<div class="panel-body" id="div-clasificacion-concepto">
					
				
				</div>
			</div>	
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Variacion de montos a cobrar por Periodo</b>
				</div>
				<div class="panel-body" id="div-liquidacion-periodo">
					
				
				</div>
			</div>	
		</div>	
	</div>	
	
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Variacion de montos a cobrar por Periodo por clasificacion de conceptos</b>
				</div>
				<div class="panel-body" id="div-liquidacion-periodo-clasificacion">
					
				
				</div>
			</div>	
		</div>	
	</div>		
	
	
""")))})),format.raw/*167.2*/("""
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,puesto_laboral_id:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,puesto_laboral_id)
    
    def f:((DynamicForm,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,puesto_laboral_id) => apply(formBuscador,puesto_laboral_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesPorPuesto.scala.html
                    HASH: bcf212030aa513245d5dd3c898541722b1667d95
                    MATRIX: 827->1|1019->110|1051->134|1125->53|1153->178|1190->181|1202->186|1275->251|1314->253|1364->276|1392->277|1452->310|1480->311|1543->338|1558->344|1641->405|2136->865|2272->978|2314->985|2413->1062|2632->1245|2652->1256|2730->1312|3197->1744|3309->1834|3352->1842|3465->1933|3678->2110|3698->2121|3773->2174|4246->2612|4352->2696|4395->2704|4502->2789|4712->2963|4732->2974|4807->3027|5447->3631|5518->3692|5558->3693|5675->3773|5717->3792|7160->5203
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|39->9|42->12|42->12|42->12|57->27|57->27|58->28|58->28|63->33|63->33|63->33|77->47|77->47|78->48|78->48|83->53|83->53|83->53|98->68|98->68|99->69|99->69|104->74|104->74|104->74|131->101|131->101|131->101|132->102|132->102|197->167
                    -- GENERATED --
                */
            