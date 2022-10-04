
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
object liquidacionesPorAgrupadoOrganigrama extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,rowParque:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalcant=new java.math.BigDecimal(0);var totalaporte=new java.math.BigDecimal(0);var totalsinaporte=new java.math.BigDecimal(0);var totalret=new java.math.BigDecimal(0);var totalgasto=new java.math.BigDecimal(0);

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*5.70*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Liquidaciones por Organigrama")/*7.69*/ {_display_(Seq[Any](format.raw/*7.71*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/liquidacionesPorProfesion.js"))),format.raw/*12.85*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Liquidaciones Agrupados por Organigrama</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a tabindex="-1" href="#" id="liquidacionesPorAgrupadoOrganigramaReporte" data-url=""""),_display_(Seq[Any](/*26.96*/controllers/*26.107*/.dashboard.routes.LiquidacionesReportesController.liquidacionesPorAgrupadoOrganigrama())),format.raw/*26.194*/("""">Exportar</a></li>
			</div>
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*31.2*/views/*31.7*/.html.tags.successError())),format.raw/*31.32*/("""
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorOrganigrama" method="GET">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*39.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*39.83*/("""
					"""),_display_(Seq[Any](/*40.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*40.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*45.20*/controllers/*45.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*45.84*/("""" 
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
			
			<!-- <div class="col-sm-4">
				<label for="inputOrgranigrama" class="control-label">Departamento/Servicio</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*60.7*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*60.98*/("""
					"""),_display_(Seq[Any](/*61.7*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden",'id -> "organigrama_id"))),format.raw/*61.92*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchOrganigrama" data-title="Selección de Departamento/Servicio" 
	                				data-url=""""),_display_(Seq[Any](/*64.33*/controllers/*64.44*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*64.112*/("""" 
	                				data-height="650" data-width="700" 
	                				data-listen="modal.seleccion.servicio.simple" 
	                				data-label="#organigrama" data-field="#organigrama_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div> -->
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

	 """),_display_(Seq[Any](/*83.4*/if(rowParque != null)/*83.25*/{_display_(Seq[Any](format.raw/*83.26*/("""
		"""),_display_(Seq[Any](/*84.4*/if(rowParque.size() > 0)/*84.28*/{_display_(Seq[Any](format.raw/*84.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PARQUE SALUD</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><b>Organigrama</b></td>
								<td><b>Cantidad</b></td>
								<td align="center"><b>Total Con Aportes</b></td>
								<td align="center"><b>Total Sin Aportes</b></td>
								<td align="center"><b>Retenciones</b></td>	 
								<!-- <td align="center">Total NETO</td> -->
								<td align="center"><b>TOTAL GASTO</b></td>	 	 
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*102.9*/for(rp <- rowParque) yield /*102.29*/{_display_(Seq[Any](format.raw/*102.30*/("""
								 	"""),_display_(Seq[Any](/*103.12*/{totalcant = totalcant.add(rp.getBigDecimal("cantidadEmpleados"))})),format.raw/*103.78*/("""
								 	"""),_display_(Seq[Any](/*104.12*/{totalaporte = totalaporte.add(rp.getBigDecimal("totalConAporte"))})),format.raw/*104.79*/("""
								 	"""),_display_(Seq[Any](/*105.12*/{totalsinaporte = totalsinaporte.add(rp.getBigDecimal("totalSinAporte"))})),format.raw/*105.85*/("""
								 	"""),_display_(Seq[Any](/*106.12*/{totalret = totalret.add(rp.getBigDecimal("totalRetenciones"))})),format.raw/*106.75*/("""
								 	"""),_display_(Seq[Any](/*107.12*/{totalgasto = totalgasto.add(rp.getBigDecimal("totalConAporte").add(rp.getBigDecimal("totalSinAporte")).add(rp.getBigDecimal("totalRetenciones")))})),format.raw/*107.159*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*109.16*/rp/*109.18*/.getString("nombre"))),format.raw/*109.38*/("""</td>
										<td align="center">"""),_display_(Seq[Any](/*110.31*/rp/*110.33*/.getInteger("cantidadEmpleados"))),format.raw/*110.65*/("""</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*112.13*/if(rp.getBigDecimal("totalConAporte").compareTo(java.math.BigDecimal.ZERO) > 0)/*112.92*/{_display_(Seq[Any](format.raw/*112.93*/("""
												"""),_display_(Seq[Any](/*113.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("totalConAporte"))))),format.raw/*113.76*/("""
											""")))})),format.raw/*114.13*/(""" 
										</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*117.13*/if(rp.getBigDecimal("totalSinAporte").compareTo(java.math.BigDecimal.ZERO) > 0)/*117.92*/{_display_(Seq[Any](format.raw/*117.93*/("""
												"""),_display_(Seq[Any](/*118.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("totalSinAporte"))))),format.raw/*118.76*/("""
											""")))})),format.raw/*119.13*/(""" 
										</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*122.13*/if(rp.getBigDecimal("totalRetenciones").compareTo(java.math.BigDecimal.ZERO) > 0)/*122.94*/{_display_(Seq[Any](format.raw/*122.95*/("""
												"""),_display_(Seq[Any](/*123.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("totalRetenciones"))))),format.raw/*123.78*/("""
											""")))})),format.raw/*124.13*/(""" 
										</td>
										<!--<td align="center">	
											 
												"""),_display_(Seq[Any](/*128.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("totalConAporte").add(rp.getBigDecimal("totalSinAporte")).subtract(rp.getBigDecimal("totalRetenciones")))))),format.raw/*128.163*/("""
											 
										</td> -->
										<td align="center">	
											"""),_display_(Seq[Any](/*132.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("totalConAporte").add(rp.getBigDecimal("totalSinAporte")).add(rp.getBigDecimal("totalRetenciones")))))),format.raw/*132.157*/("""
										</td>
									</tr>
								
							""")))})),format.raw/*136.9*/("""					
								<tr>
										<td><b>TOTALES</b></td>
										<td align="center"><b>"""),_display_(Seq[Any](/*139.34*/totalcant)),format.raw/*139.43*/("""</b></td>
										<td align="center">	
											 
												<b>"""),_display_(Seq[Any](/*142.17*/(utils.NumberUtils.moneda(totalaporte)))),format.raw/*142.56*/("""</b>
											 
										</td>
										<td align="center">	
											 
												<b>"""),_display_(Seq[Any](/*147.17*/(utils.NumberUtils.moneda(totalsinaporte)))),format.raw/*147.59*/("""</b>
											 
										</td>
										<td align="center">	
											 
												<b>"""),_display_(Seq[Any](/*152.17*/(utils.NumberUtils.moneda(totalret)))),format.raw/*152.53*/("""</b>
											 
										</td>
										 
										<td align="center">	
											<b>"""),_display_(Seq[Any](/*157.16*/(utils.NumberUtils.moneda(totalgasto)))),format.raw/*157.54*/("""</b>
										</td>
									</tr>
						</tbody>
					</table>		
					
					
				</div>
			</div>	
		""")))})),format.raw/*166.4*/("""
	""")))})),format.raw/*167.3*/("""
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,rowParque:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,rowParque)
    
    def f:((DynamicForm,List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,rowParque) => apply(formBuscador,rowParque)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesPorAgrupadoOrganigrama.scala.html
                    HASH: 5617c79d07b93fd951ed4a9a02e3b29696d3f6d3
                    MATRIX: 862->1|1315->124|1347->148|1421->67|1449->192|1485->441|1497->446|1567->508|1606->510|1656->533|1684->534|1744->567|1772->568|1835->595|1850->601|1936->665|2596->1289|2617->1300|2727->1387|2818->1443|2831->1448|2878->1473|3191->1751|3289->1827|3331->1834|3430->1911|3632->2077|3652->2088|3727->2141|4189->2568|4302->2659|4344->2666|4451->2751|4660->2924|4680->2935|4771->3003|5401->3598|5431->3619|5470->3620|5509->3624|5542->3648|5581->3649|6161->4193|6198->4213|6238->4214|6287->4226|6376->4292|6425->4304|6515->4371|6564->4383|6660->4456|6709->4468|6795->4531|6844->4543|7015->4690|7082->4720|7094->4722|7137->4742|7210->4778|7222->4780|7277->4812|7363->4861|7452->4940|7492->4941|7543->4955|7628->5017|7674->5030|7772->5091|7861->5170|7901->5171|7952->5185|8037->5247|8083->5260|8181->5321|8272->5402|8312->5403|8363->5417|8450->5481|8496->5494|8612->5573|8785->5722|8899->5799|9067->5943|9148->5992|9271->6078|9303->6087|9410->6157|9472->6196|9603->6290|9668->6332|9799->6426|9858->6462|9987->6554|10048->6592|10184->6696|10219->6699
                    LINES: 26->1|35->5|35->5|36->1|37->5|38->7|38->7|38->7|38->7|40->9|40->9|40->9|40->9|43->12|43->12|43->12|57->26|57->26|57->26|62->31|62->31|62->31|70->39|70->39|71->40|71->40|76->45|76->45|76->45|91->60|91->60|92->61|92->61|95->64|95->64|95->64|114->83|114->83|114->83|115->84|115->84|115->84|133->102|133->102|133->102|134->103|134->103|135->104|135->104|136->105|136->105|137->106|137->106|138->107|138->107|140->109|140->109|140->109|141->110|141->110|141->110|143->112|143->112|143->112|144->113|144->113|145->114|148->117|148->117|148->117|149->118|149->118|150->119|153->122|153->122|153->122|154->123|154->123|155->124|159->128|159->128|163->132|163->132|167->136|170->139|170->139|173->142|173->142|178->147|178->147|183->152|183->152|188->157|188->157|197->166|198->167
                    -- GENERATED --
                */
            