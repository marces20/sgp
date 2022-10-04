
package views.html.patrimonio.actasMovimientos

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
object indexGeneralActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[ActaMovimiento],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaMovimiento], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var ajustes=new java.math.BigDecimal(0);var tt=new java.math.BigDecimal(0);

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
		<script src=""""),_display_(Seq[Any](/*9.17*/routes/*9.23*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*9.77*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.133*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*7.1*/("""
"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.patrimonio.mainPatrimonio("Actas Pases", scripts)/*12.62*/ {_display_(Seq[Any](format.raw/*12.64*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Actas Pases</h1>
		</div>			
		<div class="col-sm-5">
						 
			<div class="pull-right btn-header">
				 
			</div> 
			 
			<div class="dropdown pull-right btn-header">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
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
			
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*48.2*/views/*48.7*/.html.tags.successError())),format.raw/*48.32*/("""
<!--  
<form action="" id="buscadorActasRecepcion" method="GET">
	<div class="row" >
		<div class="col-sm-2 input-group">
			<label class="control-label"> 
				Servicio/depto
				"""),_display_(Seq[Any](/*55.6*/select(formBuscador("organigrama_id"), 
				Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
				"form-control select", '_default -> "Seleccionar"))),format.raw/*57.55*/("""
			</label>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i>  Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<a href=""""),_display_(Seq[Any](/*69.14*/controllers/*69.25*/.patrimonio.routes.ActasMovimientosController.indexGeneral())),format.raw/*69.85*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
</form> -->

	"""),_display_(Seq[Any](/*75.3*/if(buscador.getTotalRowCount == 0)/*75.37*/ {_display_(Seq[Any](format.raw/*75.39*/("""
        
        <div class="well">
            <em>No se encuentran pases</em>
        </div>
        
    """)))}/*81.7*/else/*81.12*/{_display_(Seq[Any](format.raw/*81.13*/("""
		
		
		
		Mostrando """),_display_(Seq[Any](/*85.14*/buscador/*85.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*85.54*/(""" resultado(s).   
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<!-- <th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th> -->
					<th >Acta</th>
					<th>Servicio/Depto</th>
					<th>Usuario Rte.</th>
					<th>Fecha llegada</th>
					<th>Fecha salida</th>
					<th>Tiempo en el servicio</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*103.12*/for(pase <- buscador.getList) yield /*103.41*/ {_display_(Seq[Any](format.raw/*103.43*/("""
			        """),_display_(Seq[Any](/*104.13*/paginadorFicha/*104.27*/.add(pase.id.toString))),format.raw/*104.49*/("""
					<tr class="" data-href="">
						<!-- <td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*106.70*/pase/*106.74*/.id)),format.raw/*106.77*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*106.111*/pase/*106.115*/.id)),format.raw/*106.118*/(""""/></td> -->
						<td>"""),_display_(Seq[Any](/*107.12*/pase/*107.16*/.acta.getNombre())),format.raw/*107.33*/("""</td>
						<td>"""),_display_(Seq[Any](/*108.12*/pase/*108.16*/.organigrama.nombre)),format.raw/*108.35*/("""</td>
						<td>"""),_display_(Seq[Any](/*109.12*/pase/*109.16*/.usuario.nombre)),format.raw/*109.31*/("""</td>
						<td>"""),_display_(Seq[Any](/*110.12*/utils/*110.17*/.DateUtils.formatDate(pase.fecha_llegada,"dd/MM/yyyy HH:mm:ss"))),format.raw/*110.80*/("""</td>
						<td>"""),_display_(Seq[Any](/*111.12*/utils/*111.17*/.DateUtils.formatDate(pase.fecha_salida,"dd/MM/yyyy HH:mm:ss"))),format.raw/*111.79*/("""</td>
						<td>"""),_display_(Seq[Any](/*112.12*/ActaMovimiento/*112.26*/.tiempoEnMovimiento(pase))),format.raw/*112.51*/("""</td>
						<td align="center">
							"""),_display_(Seq[Any](/*114.9*/if(pase.cierre != true)/*114.32*/{_display_(Seq[Any](format.raw/*114.33*/("""
								<button data-url=""""),_display_(Seq[Any](/*115.28*/controllers/*115.39*/.patrimonio.routes.ActasMovimientosController.rechazarPase(pase.id))),format.raw/*115.106*/("""" class="form-control btn btn-default rechazarPase" id="rechazar-"""),_display_(Seq[Any](/*115.172*/pase/*115.176*/.id)),format.raw/*115.179*/("""">
									<i class="glyphicon glyphicon-remove" style="font-size:18px;color:red"></i>
								</button>
								<div id="loading2" class="loading-"""),_display_(Seq[Any](/*118.44*/pase/*118.48*/.id)),format.raw/*118.51*/(""""  style="display:none;"></div>
							""")))})),format.raw/*119.9*/("""
						</td> 
						<td align="center">
							<button data-url=""""),_display_(Seq[Any](/*122.27*/controllers/*122.38*/.patrimonio.routes.ActasMovimientosController.aceptarPase(pase.id))),format.raw/*122.104*/("""" class="form-control btn btn-default aceptarPase" id="aceptar-"""),_display_(Seq[Any](/*122.168*/pase/*122.172*/.id)),format.raw/*122.175*/("""" >
								<i class="glyphicon glyphicon-ok" style="font-size:18px;color:green"></i>
							</button>
							<div id="loading2" class="loading-"""),_display_(Seq[Any](/*125.43*/pase/*125.47*/.id)),format.raw/*125.50*/("""" style="display:none;"></div>
							
						</td> 
					</tr>
					
				""")))})),format.raw/*130.6*/("""
				"""),_display_(Seq[Any](/*131.6*/paginadorFicha/*131.20*/.guardar())),format.raw/*131.30*/(""" 
			</tbody>
			<tfoot>
				<td colspan="7"></td>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*138.8*/views/*138.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.ActasMovimientosController.indexGeneral()))),format.raw/*138.119*/("""
		</div>
	""")))})),format.raw/*140.3*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaMovimiento],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[ActaMovimiento],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/indexGeneralActaMovimiento.scala.html
                    HASH: 62cb3b29ad98309d2dd941e0751468014c83968a
                    MATRIX: 904->1|1309->404|1323->411|1407->415|1459->432|1473->438|1548->492|1615->189|1647->213|1722->132|1750->257|1778->402|1806->528|1844->531|1857->536|1921->591|1961->593|2965->1562|2978->1567|3025->1592|3241->1773|3500->2010|3925->2399|3945->2410|4027->2470|4156->2564|4199->2598|4239->2600|4367->2711|4380->2716|4419->2717|4478->2740|4495->2748|4549->2780|5057->3251|5103->3280|5144->3282|5194->3295|5218->3309|5263->3331|5402->3433|5416->3437|5442->3440|5514->3474|5529->3478|5556->3481|5617->3505|5631->3509|5671->3526|5725->3543|5739->3547|5781->3566|5835->3583|5849->3587|5887->3602|5941->3619|5956->3624|6042->3687|6096->3704|6111->3709|6196->3771|6250->3788|6274->3802|6322->3827|6398->3867|6431->3890|6471->3891|6536->3919|6557->3930|6648->3997|6752->4063|6767->4067|6794->4070|6980->4219|6994->4223|7020->4226|7092->4266|7195->4332|7216->4343|7306->4409|7408->4473|7423->4477|7450->4480|7632->4625|7646->4629|7672->4632|7778->4706|7820->4712|7844->4726|7877->4736|8032->4855|8047->4860|8177->4966|8221->4978
                    LINES: 26->1|35->8|35->8|37->8|38->9|38->9|38->9|39->5|39->5|40->1|41->5|42->7|43->10|45->12|45->12|45->12|45->12|81->48|81->48|81->48|88->55|90->57|102->69|102->69|102->69|108->75|108->75|108->75|114->81|114->81|114->81|118->85|118->85|118->85|136->103|136->103|136->103|137->104|137->104|137->104|139->106|139->106|139->106|139->106|139->106|139->106|140->107|140->107|140->107|141->108|141->108|141->108|142->109|142->109|142->109|143->110|143->110|143->110|144->111|144->111|144->111|145->112|145->112|145->112|147->114|147->114|147->114|148->115|148->115|148->115|148->115|148->115|148->115|151->118|151->118|151->118|152->119|155->122|155->122|155->122|155->122|155->122|155->122|158->125|158->125|158->125|163->130|164->131|164->131|164->131|171->138|171->138|171->138|173->140
                    -- GENERATED --
                */
            