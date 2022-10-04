
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
object liquidacionesTotalesPorEscala extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.lang.Integer;var c =0;var x =0

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*5.70*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Liquidaciones Totales por Escalas")/*7.73*/ {_display_(Seq[Any](format.raw/*7.75*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/liquidacionesPorProfesion.js"))),format.raw/*12.85*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Totales Por Escala</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a tabindex="-1" href="#" id="liquidacionesTotalesPorEscala" data-url="">Exportar</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*32.2*/views/*32.7*/.html.tags.successError())),format.raw/*32.32*/("""
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorProfesion" method="GET">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*40.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*40.83*/("""
					"""),_display_(Seq[Any](/*41.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*41.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*46.20*/controllers/*46.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*46.84*/("""" 
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

	"""),_display_(Seq[Any](/*70.3*/if(rowParque != null)/*70.24*/{_display_(Seq[Any](format.raw/*70.25*/("""
		"""),_display_(Seq[Any](/*71.4*/if(rowParque.size() > 0)/*71.28*/{_display_(Seq[Any](format.raw/*71.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PARQUE SALUD</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>ESCALA</td>
								<td>CANTIDAD</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*84.9*/for(rp <- rowParque) yield /*84.29*/{_display_(Seq[Any](format.raw/*84.30*/("""
								"""),_display_(Seq[Any](/*85.10*/if(rp.getInteger("idTipoRelacion").compareTo(1) == 0)/*85.63*/{_display_(Seq[Any](format.raw/*85.64*/("""
									"""),_display_(Seq[Any](/*86.11*/{c = c+rp.getInteger("cant")})),format.raw/*86.40*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*88.31*/rp/*88.33*/.getString("escala"))),format.raw/*88.53*/("""</td>
										<td align="center">"""),_display_(Seq[Any](/*89.31*/rp/*89.33*/.getInteger("cant"))),format.raw/*89.52*/("""</td>
									</tr>
								""")))})),format.raw/*91.10*/("""
							""")))})),format.raw/*92.9*/("""		
							<tr>
										<td></td>
										<td>TOTAL """),_display_(Seq[Any](/*95.22*/c)),format.raw/*95.23*/("""</td>
							</tr>						
						</tbody>
					</table>		
				</div>
			</div>	
		""")))})),format.raw/*101.4*/("""
	""")))})),format.raw/*102.3*/("""
	"""),_display_(Seq[Any](/*103.3*/{c = 0})),format.raw/*103.10*/("""
	"""),_display_(Seq[Any](/*104.3*/if(rowConvenio != null)/*104.26*/{_display_(Seq[Any](format.raw/*104.27*/("""
		"""),_display_(Seq[Any](/*105.4*/if(rowConvenio.size() > 0)/*105.30*/{_display_(Seq[Any](format.raw/*105.31*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>CONVENIO MINISTERIO</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>ESCALA</td>
								<td>CANTIDAD</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*118.9*/for(rp <- rowConvenio) yield /*118.31*/{_display_(Seq[Any](format.raw/*118.32*/("""
								"""),_display_(Seq[Any](/*119.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) == 0)/*119.63*/{_display_(Seq[Any](format.raw/*119.64*/("""
									"""),_display_(Seq[Any](/*120.11*/{c = c+rp.getInteger("cant")})),format.raw/*120.40*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*122.31*/rp/*122.33*/.getString("escala"))),format.raw/*122.53*/("""</td>
										<td align="center">"""),_display_(Seq[Any](/*123.31*/rp/*123.33*/.getInteger("cant"))),format.raw/*123.52*/("""</td>
									</tr>
								""")))})),format.raw/*125.10*/("""
							""")))})),format.raw/*126.9*/("""		
							<tr>
										<td></td>
										<td>TOTAL """),_display_(Seq[Any](/*129.22*/c)),format.raw/*129.23*/("""</td>
							</tr>						
						</tbody>
					</table>		
				</div>
			</div>	
		""")))})),format.raw/*135.4*/("""
	""")))})),format.raw/*136.3*/("""
	
	"""),_display_(Seq[Any](/*138.3*/{c = 0})),format.raw/*138.10*/("""
	"""),_display_(Seq[Any](/*139.3*/if(rowPlanta != null)/*139.24*/{_display_(Seq[Any](format.raw/*139.25*/("""
		"""),_display_(Seq[Any](/*140.4*/if(rowPlanta.size() > 0)/*140.28*/{_display_(Seq[Any](format.raw/*140.29*/("""
			
			<div class="row">
				<div class="col-sm-12">
					<h2>PLANTA PARQUE</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>ESCALA</td>
								<td>CANTIDAD</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*154.9*/for(rp <- rowPlanta) yield /*154.29*/{_display_(Seq[Any](format.raw/*154.30*/("""
								"""),_display_(Seq[Any](/*155.10*/if(!rp.getBoolean("convenio_ministerio"))/*155.51*/{_display_(Seq[Any](format.raw/*155.52*/("""
								"""),_display_(Seq[Any](/*156.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0)/*156.116*/{_display_(Seq[Any](format.raw/*156.117*/("""
									"""),_display_(Seq[Any](/*157.11*/{c = c+rp.getInteger("cant")})),format.raw/*157.40*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*159.31*/rp/*159.33*/.getString("escala"))),format.raw/*159.53*/("""- ( """),_display_(Seq[Any](/*159.58*/rp/*159.60*/.getString("tipoRelacion"))),format.raw/*159.86*/(""" )</td>
										<td align="center">"""),_display_(Seq[Any](/*160.31*/rp/*160.33*/.getInteger("cant"))),format.raw/*160.52*/("""</td>
									</tr>
								""")))})),format.raw/*162.10*/("""
								""")))})),format.raw/*163.10*/("""
							""")))})),format.raw/*164.9*/("""		
							<tr>
										<td></td>
										<td>TOTAL """),_display_(Seq[Any](/*167.22*/c)),format.raw/*167.23*/("""</td>
							</tr>						
						</tbody>
					</table>		
				</div>
			</div>	
			
		""")))})),format.raw/*174.4*/("""
	""")))})),format.raw/*175.3*/("""
	
	"""),_display_(Seq[Any](/*177.3*/{c = 0})),format.raw/*177.10*/("""
	"""),_display_(Seq[Any](/*178.3*/if(rowPlanta != null)/*178.24*/{_display_(Seq[Any](format.raw/*178.25*/("""
		"""),_display_(Seq[Any](/*179.4*/if(rowPlanta.size() > 0)/*179.28*/{_display_(Seq[Any](format.raw/*179.29*/("""
			
			<div class="row">
				<div class="col-sm-12">
					<h2>PLANTA CONVENIO</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>ESCALA</td>
								<td>CANTIDAD</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*193.9*/for(rp <- rowPlanta) yield /*193.29*/{_display_(Seq[Any](format.raw/*193.30*/("""
								"""),_display_(Seq[Any](/*194.10*/if(rp.getBoolean("convenio_ministerio"))/*194.50*/{_display_(Seq[Any](format.raw/*194.51*/("""
								"""),_display_(Seq[Any](/*195.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0)/*195.116*/{_display_(Seq[Any](format.raw/*195.117*/("""
									"""),_display_(Seq[Any](/*196.11*/{c = c+rp.getInteger("cant")})),format.raw/*196.40*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*198.31*/rp/*198.33*/.getString("escala"))),format.raw/*198.53*/("""</td>
										<td align="center">"""),_display_(Seq[Any](/*199.31*/rp/*199.33*/.getInteger("cant"))),format.raw/*199.52*/("""</td>
									</tr>
								""")))})),format.raw/*201.10*/("""
								""")))})),format.raw/*202.10*/("""
							""")))})),format.raw/*203.9*/("""		
							<tr>
										<td></td>
										<td>TOTAL """),_display_(Seq[Any](/*206.22*/c)),format.raw/*206.23*/("""</td>
							</tr>						
						</tbody>
					</table>		
				</div>
			</div>	
			
		""")))})),format.raw/*213.4*/("""
	""")))})),format.raw/*214.3*/("""
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def f:((DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,rowParque,rowConvenio,rowPlanta) => apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesTotalesPorEscala.scala.html
                    HASH: 47331175b728ed376ca861851d7e8bb9a754b6d1
                    MATRIX: 914->1|1244->204|1276->228|1351->147|1379->272|1415->318|1427->323|1501->389|1540->391|1590->414|1618->415|1678->448|1706->449|1769->476|1784->482|1870->546|2561->1202|2574->1207|2621->1232|2932->1508|3030->1584|3072->1591|3171->1668|3373->1834|3393->1845|3468->1898|4065->2460|4095->2481|4134->2482|4173->2486|4206->2510|4245->2511|4531->2762|4567->2782|4606->2783|4652->2793|4714->2846|4753->2847|4800->2858|4851->2887|4932->2932|4943->2934|4985->2954|5057->2990|5068->2992|5109->3011|5171->3041|5211->3050|5303->3106|5326->3107|5439->3188|5474->3191|5513->3194|5543->3201|5582->3204|5615->3227|5655->3228|5695->3232|5731->3258|5771->3259|6065->3517|6104->3539|6144->3540|6191->3550|6254->3603|6294->3604|6342->3615|6394->3644|6476->3689|6488->3691|6531->3711|6604->3747|6616->3749|6658->3768|6721->3798|6762->3807|6855->3863|6879->3864|6992->3945|7027->3948|7068->3953|7098->3960|7137->3963|7168->3984|7208->3985|7248->3989|7282->4013|7322->4014|7614->4270|7651->4290|7691->4291|7738->4301|7789->4342|7829->4343|7876->4353|7993->4459|8034->4460|8082->4471|8134->4500|8216->4545|8228->4547|8271->4567|8313->4572|8325->4574|8374->4600|8449->4638|8461->4640|8503->4659|8566->4689|8609->4699|8650->4708|8743->4764|8767->4765|8884->4850|8919->4853|8960->4858|8990->4865|9029->4868|9060->4889|9100->4890|9140->4894|9174->4918|9214->4919|9508->5177|9545->5197|9585->5198|9632->5208|9682->5248|9722->5249|9769->5259|9886->5365|9927->5366|9975->5377|10027->5406|10109->5451|10121->5453|10164->5473|10237->5509|10249->5511|10291->5530|10354->5560|10397->5570|10438->5579|10531->5635|10555->5636|10672->5721|10707->5724
                    LINES: 26->1|35->5|35->5|36->1|37->5|38->7|38->7|38->7|38->7|40->9|40->9|40->9|40->9|43->12|43->12|43->12|63->32|63->32|63->32|71->40|71->40|72->41|72->41|77->46|77->46|77->46|101->70|101->70|101->70|102->71|102->71|102->71|115->84|115->84|115->84|116->85|116->85|116->85|117->86|117->86|119->88|119->88|119->88|120->89|120->89|120->89|122->91|123->92|126->95|126->95|132->101|133->102|134->103|134->103|135->104|135->104|135->104|136->105|136->105|136->105|149->118|149->118|149->118|150->119|150->119|150->119|151->120|151->120|153->122|153->122|153->122|154->123|154->123|154->123|156->125|157->126|160->129|160->129|166->135|167->136|169->138|169->138|170->139|170->139|170->139|171->140|171->140|171->140|185->154|185->154|185->154|186->155|186->155|186->155|187->156|187->156|187->156|188->157|188->157|190->159|190->159|190->159|190->159|190->159|190->159|191->160|191->160|191->160|193->162|194->163|195->164|198->167|198->167|205->174|206->175|208->177|208->177|209->178|209->178|209->178|210->179|210->179|210->179|224->193|224->193|224->193|225->194|225->194|225->194|226->195|226->195|226->195|227->196|227->196|229->198|229->198|229->198|230->199|230->199|230->199|232->201|233->202|234->203|237->206|237->206|244->213|245->214
                    -- GENERATED --
                */
            