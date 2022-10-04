
package views.html.rrhh.agenteNovedades

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
object indexAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteNovedad],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteNovedad], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.1*/("""
<div id="listaAgenteNovedad" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Datos Contractuales</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("crearAgenteNovedad"))/*8.56*/{_display_(Seq[Any](format.raw/*8.57*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteNovedad"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			""")))})),format.raw/*10.5*/("""
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*14.3*/if(paginador.getTotalRowCount == 0)/*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
        <p id="mensajeSinResultadosNovedad" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay Datos cargados.</p>
    """)))})),format.raw/*16.6*/(""" 

	<table id="listaDeAgenteNovedad" class="table table-striped table-bordered  """),_display_(Seq[Any](/*18.79*/if(paginador.getTotalRowCount() <= 0)/*18.116*/{_display_(Seq[Any](format.raw/*18.117*/("""hide""")))})),format.raw/*18.122*/("""">
		<thead>
			<tr>
				 
					<th class="accion-editar">#</th>
				 
					<th>Fecha</th>
					<th>Tipo Modificacion</th>
					<th>Agrupamiento</th>
					<th>Horas Semanales</th>
					<th>Situación Contractual</th>
					<th>Observaciones</th>
				 
					 
				 
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*36.4*/for(linea <- paginador.getList) yield /*36.35*/ {_display_(Seq[Any](format.raw/*36.37*/("""
			"""),_display_(Seq[Any](/*37.5*/views/*37.10*/.html.rrhh.agenteNovedades.lineaAgenteNovedad(linea, editable))),format.raw/*37.72*/("""
		""")))})),format.raw/*38.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*45.9*/views/*45.14*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesNovedadesController.index()))),format.raw/*45.108*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	 
	 
	var contenedor = $("#listaAgenteNovedad");
						     
	contenedor.on('click', '#nuevoAgenteNovedad', function()"""),format.raw/*58.58*/("""{"""),format.raw/*58.59*/("""
		urlContenidoModal = '/rrhh/agente-novedad/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.on('click', '.modificarAgenteNovedad', function()"""),format.raw/*64.62*/("""{"""),format.raw/*64.63*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Datos');	
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteNovedad', function()"""),format.raw/*71.61*/("""{"""),format.raw/*71.62*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*73.23*/("""{"""),format.raw/*73.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*76.29*/("""{"""),format.raw/*76.30*/("""
				if(data.success)"""),format.raw/*77.21*/("""{"""),format.raw/*77.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*79.5*/("""}"""),format.raw/*79.6*/(""" else """),format.raw/*79.12*/("""{"""),format.raw/*79.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*81.5*/("""}"""),format.raw/*81.6*/("""
			"""),format.raw/*82.4*/("""}"""),format.raw/*82.5*/(""");
		"""),format.raw/*83.3*/("""}"""),format.raw/*83.4*/("""
		return false;
	"""),format.raw/*85.2*/("""}"""),format.raw/*85.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*87.28*/("""{"""),format.raw/*87.29*/("""
		modalCargaAgenteNovedad = $('<div></div>').dialog("""),format.raw/*88.53*/("""{"""),format.raw/*88.54*/("""
			resizable: false,
		    title: "Cargar Novedad",
		    height: 600,
		    minHeight:600,
		    width: 800,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*95.35*/("""{"""),format.raw/*95.36*/("""
				$.get(url, function(data)"""),format.raw/*96.30*/("""{"""),format.raw/*96.31*/("""
					modalCargaAgenteNovedad.html(data);
				"""),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");
		    """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""",
		    close: function(event, ui )"""),format.raw/*100.34*/("""{"""),format.raw/*100.35*/("""
		    	modalCargaAgenteNovedad.dialog('destroy');
			"""),format.raw/*102.4*/("""}"""),format.raw/*102.5*/("""
		  """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
		
		modalCargaAgenteNovedad.on('click', '.cancelar', function()"""),format.raw/*105.62*/("""{"""),format.raw/*105.63*/("""
			modalCargaAgenteNovedad.dialog('destroy');
			return false;
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""");
		
		modalCargaAgenteNovedad.on('submit', function(e)"""),format.raw/*110.51*/("""{"""),format.raw/*110.52*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*113.42*/("""{"""),format.raw/*113.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*114.45*/("""{"""),format.raw/*114.46*/("""
					$('#listaDeAgenteNovedad tbody').prepend(resultado.html);
					$('#mensajeSinResultadosNovedad').remove();
					$('#listaDeAgenteNovedad').removeClass('hide');
					modalCargaAgenteNovedad.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*120.5*/("""}"""),format.raw/*120.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*120.56*/("""{"""),format.raw/*120.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaAgenteNovedad.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*125.5*/("""}"""),format.raw/*125.6*/(""" else """),format.raw/*125.12*/("""{"""),format.raw/*125.13*/("""
					modalCargaAgenteNovedad.html(resultado);
				"""),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""
			"""),format.raw/*128.4*/("""}"""),format.raw/*128.5*/(""");
			return false;
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");
		
		
		return modalCargaAgenteNovedad;
	"""),format.raw/*134.2*/("""}"""),format.raw/*134.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*137.49*/("""{"""),format.raw/*137.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*140.38*/("""{"""),format.raw/*140.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*142.3*/("""}"""),format.raw/*142.4*/(""");
		return false;
	"""),format.raw/*144.2*/("""}"""),format.raw/*144.3*/(""");
"""),format.raw/*145.1*/("""}"""),format.raw/*145.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteNovedad],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteNovedad],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/indexAgenteNovedad.scala.html
                    HASH: 94f57f962005e76ffe05040601fd1f36c4e3885c
                    MATRIX: 852->1|1043->76|1071->101|1281->277|1340->328|1378->329|1540->460|1621->506|1665->541|1705->543|1874->681|1993->764|2040->801|2080->802|2118->807|2467->1121|2514->1152|2554->1154|2595->1160|2609->1165|2693->1227|2729->1232|2845->1313|2859->1318|2976->1412|3071->1479|3100->1480|3253->1605|3282->1606|3449->1746|3477->1747|3573->1815|3602->1816|3797->1984|3825->1985|3920->2052|3949->2053|4063->2139|4092->2140|4207->2227|4236->2228|4286->2250|4315->2251|4384->2293|4412->2294|4446->2300|4475->2301|4558->2357|4586->2358|4618->2363|4646->2364|4679->2370|4707->2371|4754->2391|4782->2392|4844->2426|4873->2427|4955->2481|4984->2482|5183->2653|5212->2654|5271->2685|5300->2686|5375->2734|5403->2735|5440->2745|5468->2746|5533->2782|5563->2783|5647->2839|5676->2840|5710->2846|5739->2847|5837->2916|5867->2917|5964->2986|5993->2987|6080->3045|6110->3046|6265->3172|6295->3173|6370->3219|6400->3220|6702->3494|6731->3495|6810->3545|6840->3546|7031->3709|7060->3710|7095->3716|7125->3717|7206->3770|7235->3771|7268->3776|7297->3777|7349->3801|7378->3802|7454->3850|7483->3851|7568->3907|7598->3908|7739->4020|7769->4021|7837->4061|7866->4062|7916->4084|7945->4085|7977->4089|8006->4090
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|42->14|42->14|42->14|44->16|46->18|46->18|46->18|46->18|64->36|64->36|64->36|65->37|65->37|65->37|66->38|73->45|73->45|73->45|81->53|81->53|86->58|86->58|90->62|90->62|92->64|92->64|97->69|97->69|99->71|99->71|101->73|101->73|104->76|104->76|105->77|105->77|107->79|107->79|107->79|107->79|109->81|109->81|110->82|110->82|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|123->95|123->95|124->96|124->96|126->98|126->98|127->99|127->99|128->100|128->100|130->102|130->102|131->103|131->103|133->105|133->105|136->108|136->108|138->110|138->110|141->113|141->113|142->114|142->114|148->120|148->120|148->120|148->120|153->125|153->125|153->125|153->125|155->127|155->127|156->128|156->128|158->130|158->130|162->134|162->134|165->137|165->137|168->140|168->140|170->142|170->142|172->144|172->144|173->145|173->145
                    -- GENERATED --
                */
            