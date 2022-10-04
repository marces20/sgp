
package views.html.expediente.expedientesMovimientos

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
object indexExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ExpedienteMovimiento],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[ExpedienteMovimiento], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.1*/("""<div id="listaExpedientesMovimientos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Movimientos</b>
	 
		<!-- <a class="btn btn-default btn-xs" href="#" id="nuevoExpedienteMovimiento"><i class="glyphicon glyphicon-plus"></i> Pasar a otro servicio</a> -->
 
</p>

"""),_display_(Seq[Any](/*12.2*/if(paginador.getTotalRowCount() > 0)/*12.38*/ {_display_(Seq[Any](format.raw/*12.40*/("""
	Mostrando """),_display_(Seq[Any](/*13.13*/paginador/*13.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*13.54*/(""" resultado(s).
""")))})),format.raw/*14.2*/("""

<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr>

			"""),_display_(Seq[Any](/*20.5*/if(editable)/*20.17*/{_display_(Seq[Any](format.raw/*20.18*/("""
				<!-- <th width="30">
					<input type="checkbox" name="checkAll" id="checkAll"/>
				</th>
				<th class="accion-editar">#</th> -->
			""")))})),format.raw/*25.5*/("""
			<th>Servicio/Depto</th>
			<th>Usuario Rte.</th>
			<th>Fecha llegada</th>
			<th>Fecha salida</th>
			<th>Tiempo en el servicio</th>
			<th></th>
			<th>ops</th>
			
			<th>desc</th>
			
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*39.3*/for(linea <- paginador.getList) yield /*39.34*/ {_display_(Seq[Any](format.raw/*39.36*/("""
		"""),_display_(Seq[Any](/*40.4*/views/*40.9*/.html.expediente.expedientesMovimientos.lineaExpedienteMovimiento(linea, editable))),format.raw/*40.91*/("""
	""")))})),format.raw/*41.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*46.6*/views/*46.11*/.html.helpers.paginador(paginador, controllers.expediente.routes.ExpedientesMovimientosController.index()))),format.raw/*46.117*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	 
	var contenedor = $("#listaExpedientesMovimientos");

	contenedor.on('click', '#nuevoExpedienteMovimiento', function()"""),format.raw/*59.65*/("""{"""),format.raw/*59.66*/("""
		urlContenidoModal = '/expediente/movimiento-linea/crear?expedienteId='+$('#expedienteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*63.2*/("""}"""),format.raw/*63.3*/(""");
	
	contenedor.on('click', '.modificarExpedienteMovimiento', function()"""),format.raw/*65.69*/("""{"""),format.raw/*65.70*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Movimiento');	
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	contenedor.on('click', '.eliminarExpedienteMovimiento', function()"""),format.raw/*72.68*/("""{"""),format.raw/*72.69*/("""
		var url = $(this).attr('href');
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*75.23*/("""{"""),format.raw/*75.24*/("""
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*77.29*/("""{"""),format.raw/*77.30*/("""
				if(data.success)"""),format.raw/*78.21*/("""{"""),format.raw/*78.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*80.5*/("""}"""),format.raw/*80.6*/(""" else """),format.raw/*80.12*/("""{"""),format.raw/*80.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*82.5*/("""}"""),format.raw/*82.6*/("""
			"""),format.raw/*83.4*/("""}"""),format.raw/*83.5*/(""");
		"""),format.raw/*84.3*/("""}"""),format.raw/*84.4*/("""
		return false;
	"""),format.raw/*86.2*/("""}"""),format.raw/*86.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*88.28*/("""{"""),format.raw/*88.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*89.49*/("""{"""),format.raw/*89.50*/("""
			resizable: false,
		    title: "Cargar Movimiento",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*95.35*/("""{"""),format.raw/*95.36*/("""
				$.get(url, function(data)"""),format.raw/*96.30*/("""{"""),format.raw/*96.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");
		    """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""",
		    close: function(event, ui )"""),format.raw/*100.34*/("""{"""),format.raw/*100.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*102.4*/("""}"""),format.raw/*102.5*/("""
		  """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*105.58*/("""{"""),format.raw/*105.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*110.47*/("""{"""),format.raw/*110.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*113.42*/("""{"""),format.raw/*113.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*114.45*/("""{"""),format.raw/*114.46*/("""
					$('#listaExpedientesMovimientos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*117.56*/("""{"""),format.raw/*117.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*120.5*/("""}"""),format.raw/*120.6*/(""" else """),format.raw/*120.12*/("""{"""),format.raw/*120.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*122.5*/("""}"""),format.raw/*122.6*/("""
			"""),format.raw/*123.4*/("""}"""),format.raw/*123.5*/(""");
			return false;
		"""),format.raw/*125.3*/("""}"""),format.raw/*125.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*129.2*/("""}"""),format.raw/*129.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*132.49*/("""{"""),format.raw/*132.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*135.38*/("""{"""),format.raw/*135.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*137.3*/("""}"""),format.raw/*137.4*/(""");
		return false;
	"""),format.raw/*139.2*/("""}"""),format.raw/*139.3*/(""");


		/*
		 * Seleccion de check en la tabla
		 */
		$('#checkAll').change( function()"""),format.raw/*145.36*/("""{"""),format.raw/*145.37*/("""
			var table = $(this).closest('table');
			table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
		"""),format.raw/*148.3*/("""}"""),format.raw/*148.4*/(""");

	
		
"""),format.raw/*152.1*/("""}"""),format.raw/*152.2*/(""");	
</script>



"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[ExpedienteMovimiento],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[ExpedienteMovimiento],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/indexExpedienteMovimiento.scala.html
                    HASH: 83f6e2d63253fba22ee2d72975f7067e4c40a27f
                    MATRIX: 879->1|1077->83|1105->108|1419->387|1464->423|1504->425|1554->439|1572->448|1626->480|1674->497|1811->599|1832->611|1871->612|2048->758|2318->993|2365->1024|2405->1026|2445->1031|2458->1036|2562->1118|2597->1122|2699->1189|2713->1194|2842->1300|2913->1343|2942->1344|3164->1538|3193->1539|3376->1695|3404->1696|3507->1771|3536->1772|3736->1945|3764->1946|3866->2020|3895->2021|4044->2142|4073->2143|4152->2194|4181->2195|4231->2217|4260->2218|4329->2260|4357->2261|4391->2267|4420->2268|4503->2324|4531->2325|4563->2330|4591->2331|4624->2337|4652->2338|4699->2358|4727->2359|4789->2393|4818->2394|4896->2444|4925->2445|5105->2597|5134->2598|5193->2629|5222->2630|5293->2674|5321->2675|5358->2685|5386->2686|5451->2722|5481->2723|5561->2775|5590->2776|5624->2782|5653->2783|5747->2848|5777->2849|5870->2914|5899->2915|5982->2969|6012->2970|6167->3096|6197->3097|6272->3143|6302->3144|6454->3268|6483->3269|6562->3319|6592->3320|6727->3427|6756->3428|6791->3434|6821->3435|6898->3484|6927->3485|6960->3490|6989->3491|7041->3515|7070->3516|7142->3560|7171->3561|7256->3617|7286->3618|7427->3730|7457->3731|7525->3771|7554->3772|7604->3794|7633->3795|7755->3888|7785->3889|7952->4028|7981->4029|8022->4042|8051->4043
                    LINES: 26->1|30->1|31->3|40->12|40->12|40->12|41->13|41->13|41->13|42->14|48->20|48->20|48->20|53->25|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46|74->46|79->51|79->51|87->59|87->59|91->63|91->63|93->65|93->65|98->70|98->70|100->72|100->72|103->75|103->75|105->77|105->77|106->78|106->78|108->80|108->80|108->80|108->80|110->82|110->82|111->83|111->83|112->84|112->84|114->86|114->86|116->88|116->88|117->89|117->89|123->95|123->95|124->96|124->96|126->98|126->98|127->99|127->99|128->100|128->100|130->102|130->102|131->103|131->103|133->105|133->105|136->108|136->108|138->110|138->110|141->113|141->113|142->114|142->114|145->117|145->117|145->117|145->117|148->120|148->120|148->120|148->120|150->122|150->122|151->123|151->123|153->125|153->125|157->129|157->129|160->132|160->132|163->135|163->135|165->137|165->137|167->139|167->139|173->145|173->145|176->148|176->148|180->152|180->152
                    -- GENERATED --
                */
            