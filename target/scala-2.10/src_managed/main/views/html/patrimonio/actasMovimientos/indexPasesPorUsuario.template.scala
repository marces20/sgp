
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
object indexPasesPorUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[ActaMovimiento],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaMovimiento], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var ajustes=new java.math.BigDecimal(0);var tt=new java.math.BigDecimal(0);

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*9.76*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.133*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*7.1*/("""
"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.patrimonio.mainPatrimonio("Actas Pases", scripts)/*12.62*/ {_display_(Seq[Any](format.raw/*12.64*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Actas Pases Por Usuario</h1>
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
  
<form action="" id="buscadorActasRecepcion" method="GET">
	<div class="row" >
		<!-- <div class="col-sm-2 input-group">
			<label class="control-label"> 
				Servicio/depto
				"""),_display_(Seq[Any](/*55.6*/select(formBuscador("organigrama_id"), 
				Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
				"form-control select", '_default -> "Seleccionar"))),format.raw/*57.55*/("""
			</label>
		</div>-->
		
		<div class="form-group col-sm-2">
			<label for="nombre" class="control-label">Número Acta
			"""),_display_(Seq[Any](/*63.5*/inputText(formBuscador("numero"), 'class -> "form-control"))),format.raw/*63.64*/("""
			</label>
		</div>
			
		<div class="col-sm-2">
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*70.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*70.92*/("""
					"""),_display_(Seq[Any](/*71.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*71.111*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpedienteActa" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*76.21*/controllers/*76.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*76.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente" 
									data-field="#expediente_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
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
			<a href=""""),_display_(Seq[Any](/*97.14*/controllers/*97.25*/.patrimonio.routes.ActasMovimientosController.indexPasesPorUsuario())),format.raw/*97.93*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
</form> 

	"""),_display_(Seq[Any](/*103.3*/if(buscador.getTotalRowCount == 0)/*103.37*/ {_display_(Seq[Any](format.raw/*103.39*/("""
        
        <div class="well">
            <em>No se encuentran pases</em>
        </div>
        
    """)))}/*109.7*/else/*109.12*/{_display_(Seq[Any](format.raw/*109.13*/("""
		
		
		
		Mostrando """),_display_(Seq[Any](/*113.14*/buscador/*113.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*113.54*/(""" resultado(s).   
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<!-- <th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th> -->
					<th>Acta</th>
					<th>Expediente</th>
					<th>Servicio/Depto</th>
					<th>Usuario Rte.</th>
					<th>Fecha llegada</th>
					<th>Fecha salida</th>
					<th>Tiempo en el servicio</th>
					 
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*131.12*/for(pase <- buscador.getList) yield /*131.41*/ {_display_(Seq[Any](format.raw/*131.43*/("""
			        """),_display_(Seq[Any](/*132.13*/paginadorFicha/*132.27*/.add(pase.id.toString))),format.raw/*132.49*/("""
					<tr class="" data-href="">
						<!-- <td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*134.70*/pase/*134.74*/.id)),format.raw/*134.77*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*134.111*/pase/*134.115*/.id)),format.raw/*134.118*/(""""/></td> -->
						<td>"""),_display_(Seq[Any](/*135.12*/pase/*135.16*/.acta.getNombre())),format.raw/*135.33*/("""</td>
						<td>"""),_display_(Seq[Any](/*136.12*/pase/*136.16*/.acta.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*136.84*/("""</td>
						<td>"""),_display_(Seq[Any](/*137.12*/pase/*137.16*/.organigrama.nombre)),format.raw/*137.35*/("""</td>
						<td>"""),_display_(Seq[Any](/*138.12*/pase/*138.16*/.usuario.nombre)),format.raw/*138.31*/("""</td>
						<td>"""),_display_(Seq[Any](/*139.12*/utils/*139.17*/.DateUtils.formatDate(pase.fecha_llegada,"dd/MM/yyyy HH:mm:ss"))),format.raw/*139.80*/("""</td>
						<td>"""),_display_(Seq[Any](/*140.12*/utils/*140.17*/.DateUtils.formatDate(pase.fecha_salida,"dd/MM/yyyy HH:mm:ss"))),format.raw/*140.79*/("""</td>
						<td>"""),_display_(Seq[Any](/*141.12*/ActaMovimiento/*141.26*/.tiempoEnMovimiento(pase))),format.raw/*141.51*/("""</td>
						 
					</tr>
					
				""")))})),format.raw/*145.6*/("""
				"""),_display_(Seq[Any](/*146.6*/paginadorFicha/*146.20*/.guardar())),format.raw/*146.30*/(""" 
			</tbody>
			<tfoot>
				<td colspan="5"></td>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*153.8*/views/*153.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.ActasMovimientosController.indexPasesPorUsuario()))),format.raw/*153.127*/("""
		</div>
	""")))})),format.raw/*155.3*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaMovimiento],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[ActaMovimiento],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/indexPasesPorUsuario.scala.html
                    HASH: 42cbd1f98f2965189499f30a13546ce850d5d91b
                    MATRIX: 898->1|1303->404|1317->411|1401->415|1452->431|1466->437|1541->491|1608->189|1640->213|1715->132|1743->257|1771->402|1799->527|1837->530|1850->535|1914->590|1954->592|2970->1573|2983->1578|3030->1603|3247->1785|3506->2022|3666->2147|3747->2206|3912->2336|4019->2421|4061->2428|4188->2532|4404->2712|4424->2723|4500->2777|5199->3440|5219->3451|5309->3519|5436->3610|5480->3644|5521->3646|5650->3757|5664->3762|5704->3763|5764->3786|5782->3794|5837->3826|6346->4298|6392->4327|6433->4329|6483->4342|6507->4356|6552->4378|6691->4480|6705->4484|6731->4487|6803->4521|6818->4525|6845->4528|6906->4552|6920->4556|6960->4573|7014->4590|7028->4594|7119->4662|7173->4679|7187->4683|7229->4702|7283->4719|7297->4723|7335->4738|7389->4755|7404->4760|7490->4823|7544->4840|7559->4845|7644->4907|7698->4924|7722->4938|7770->4963|7838->4999|7880->5005|7904->5019|7937->5029|8092->5148|8107->5153|8245->5267|8289->5279
                    LINES: 26->1|35->8|35->8|37->8|38->9|38->9|38->9|39->5|39->5|40->1|41->5|42->7|43->10|45->12|45->12|45->12|45->12|81->48|81->48|81->48|88->55|90->57|96->63|96->63|103->70|103->70|104->71|104->71|109->76|109->76|109->76|130->97|130->97|130->97|136->103|136->103|136->103|142->109|142->109|142->109|146->113|146->113|146->113|164->131|164->131|164->131|165->132|165->132|165->132|167->134|167->134|167->134|167->134|167->134|167->134|168->135|168->135|168->135|169->136|169->136|169->136|170->137|170->137|170->137|171->138|171->138|171->138|172->139|172->139|172->139|173->140|173->140|173->140|174->141|174->141|174->141|178->145|179->146|179->146|179->146|186->153|186->153|186->153|188->155
                    -- GENERATED --
                */
            