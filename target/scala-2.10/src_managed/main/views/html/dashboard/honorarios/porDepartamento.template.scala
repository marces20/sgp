
package views.html.dashboard.honorarios

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
object porDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Informa por departamento")/*7.64*/ {_display_(Seq[Any](format.raw/*7.66*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/informePorDepartamento.js"))),format.raw/*12.82*/("""" type="text/javascript"></script>
<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Informe por departamento</h1>
			</div>
		</div>
</div>			
<div id="actions">
	<form action="" id="formSearchLiquidacionesPorPuesto" method="GET">
		<div class="row">
			
			<div class="col-sm-4">

				<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
				"""),_display_(Seq[Any](/*27.6*/inputText(formBuscador("departamento_nombre"),'class -> "form-control",'id -> "departamento"))),format.raw/*27.99*/("""
				"""),_display_(Seq[Any](/*28.6*/inputText(formBuscador("id"),'hidden -> "hidden", 'id -> "organigrama_id"))),format.raw/*28.80*/("""
				"""),_display_(Seq[Any](/*29.6*/formBuscador("organigrama_id")/*29.36*/.error.map/*29.46*/{ error =>_display_(Seq[Any](format.raw/*29.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*30.31*/error/*30.36*/.message)),format.raw/*30.44*/("""</div>
				""")))})),format.raw/*31.6*/("""

			</div>
			
			
		<div class="col-sm-2">
			<label class="control-label">Periodo inicio</label> 
			<div class="form-group">
				<div class="input-group">
				"""),_display_(Seq[Any](/*40.6*/inputText(formBuscador("periodoInicio.nombre"),'class -> "form-control", 'id -> "periodo"))),format.raw/*40.96*/("""
				"""),_display_(Seq[Any](/*41.6*/inputText(formBuscador("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*41.84*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*46.21*/controllers/*46.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*46.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>	
			</div>
		</div>
			
			
			
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
		</div>
	</form>
</div>
<hr>


	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Gráfico totales por departamentos</b></div>
				<div class="panel-body">
					<a href="" class="btn btn-primary" id="nivelSuperior">Nivel superior</a>
					<div id="chart-por-departamento" data-href=""""),_display_(Seq[Any](/*79.51*/controllers/*79.62*/.dashboard.routes.HonorariosController.getHonorarioDepartamento())),format.raw/*79.127*/(""""></div>
					
				</div>
			</div>	
		</div>	
	</div>

	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Información por departamentos</b></div>
				<div class="panel-body">
					<!-- 
					<div id="table_por_departamento"></div>
					-->
					
		<table id="listaInforme" data-href=""""),_display_(Seq[Any](/*95.40*/controllers/*95.51*/.dashboard.routes.HonorariosController.getAgentesTotalDepartamento())),format.raw/*95.119*/("""" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Departamento</th>
					<th width="80">Agentes</th>
					<th width="80">Total</th>
					<th width="100">Retenciones</th>
					<th width="100">Sin aporte</th>
					<th width="100">Con aporte</th>
					<th width="100">Patronales</th>
					<th width="100">Liquidación</th>
				</tr>
			</thead>
			<tbody>

			
			</tbody>
		</table>
				
		<hr />
		
		
		<table id="listaAgentes" data-url-estado=""""),_display_(Seq[Any](/*117.46*/controllers/*117.57*/.dashboard.routes.LiquidacionesController.liquidacionesPorPuesto())),format.raw/*117.123*/("""" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="ordenColumna">Nombre</th>
					<th class="ordenColumna" width="400">Departamento</th>
				</tr>
			</thead>
			<tbody>

			
			</tbody>
		</table>			
					
				</div>
			</div>	
		</div>	
	</div>

""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorarios/porDepartamento.scala.html
                    HASH: 5bf8c785053fe2624d8a3dc161764d87709415c9
                    MATRIX: 810->1|980->89|1012->113|1086->28|1115->157|1154->162|1166->167|1231->224|1270->226|1322->251|1350->252|1410->285|1438->286|1504->316|1519->322|1602->383|2057->803|2172->896|2214->903|2310->977|2352->984|2391->1014|2410->1024|2458->1034|2526->1066|2540->1071|2570->1079|2614->1092|2822->1265|2934->1355|2976->1362|3076->1440|3292->1620|3312->1631|3387->1684|4348->2609|4368->2620|4456->2685|4859->3052|4879->3063|4970->3131|5511->3635|5532->3646|5622->3712
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|39->9|42->12|42->12|42->12|57->27|57->27|58->28|58->28|59->29|59->29|59->29|59->29|60->30|60->30|60->30|61->31|70->40|70->40|71->41|71->41|76->46|76->46|76->46|109->79|109->79|109->79|125->95|125->95|125->95|147->117|147->117|147->117
                    -- GENERATED --
                */
            