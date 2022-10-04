
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
object indexActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ActaMovimiento],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[ActaMovimiento], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.78*/("""
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

			 
			<th>Servicio/Depto</th>
			<th>Usuario Rte.</th>
			<th>Usuario Recp.</th>
			<th>Fecha llegada</th>
			<th>Fecha salida</th>
			<th>Tiempo en el servicio</th>
			<th>Estado</th>
			<th></th>
			<th>desc</th>
			
			 
			 
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*36.3*/for(linea <- paginador.getList) yield /*36.34*/ {_display_(Seq[Any](format.raw/*36.36*/("""
		"""),_display_(Seq[Any](/*37.4*/views/*37.9*/.html.patrimonio.actasMovimientos.lineaActaMovimiento(linea, editable))),format.raw/*37.79*/("""
	""")))})),format.raw/*38.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*43.6*/views/*43.11*/.html.helpers.paginador(paginador, controllers.patrimonio.routes.ActasMovimientosController.index()))),format.raw/*43.111*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*48.14*/("""{"""),format.raw/*48.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	 
	var contenedor = $("#listaActasMovimientos");

	contenedor.on('click', '#nuevoActaMovimiento', function()"""),format.raw/*56.59*/("""{"""),format.raw/*56.60*/("""
		urlContenidoModal = '/patrimonio/movimiento-linea/crear?actaId='+$('#actaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
	
	contenedor.on('click', '.modificarActaMovimiento', function()"""),format.raw/*62.63*/("""{"""),format.raw/*62.64*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Movimiento');	
		return false;
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
	
	contenedor.on('click', '.eliminarActaMovimiento', function()"""),format.raw/*69.62*/("""{"""),format.raw/*69.63*/("""
		var url = $(this).attr('href');
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*72.23*/("""{"""),format.raw/*72.24*/("""
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*74.29*/("""{"""),format.raw/*74.30*/("""
				if(data.success)"""),format.raw/*75.21*/("""{"""),format.raw/*75.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*77.5*/("""}"""),format.raw/*77.6*/(""" else """),format.raw/*77.12*/("""{"""),format.raw/*77.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*79.5*/("""}"""),format.raw/*79.6*/("""
			"""),format.raw/*80.4*/("""}"""),format.raw/*80.5*/(""");
		"""),format.raw/*81.3*/("""}"""),format.raw/*81.4*/("""
		return false;
	"""),format.raw/*83.2*/("""}"""),format.raw/*83.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*85.28*/("""{"""),format.raw/*85.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*86.49*/("""{"""),format.raw/*86.50*/("""
			resizable: false,
		    title: "Cargar Movimiento",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""
				$.get(url, function(data)"""),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
		    """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""",
		    close: function(event, ui )"""),format.raw/*97.34*/("""{"""),format.raw/*97.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*99.4*/("""}"""),format.raw/*99.5*/("""
		  """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*102.58*/("""{"""),format.raw/*102.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*107.47*/("""{"""),format.raw/*107.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*111.45*/("""{"""),format.raw/*111.46*/("""
					$('#listaActasMovimientos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*114.5*/("""}"""),format.raw/*114.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*114.56*/("""{"""),format.raw/*114.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else """),format.raw/*117.12*/("""{"""),format.raw/*117.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/("""
			"""),format.raw/*120.4*/("""}"""),format.raw/*120.5*/(""");
			return false;
		"""),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*126.2*/("""}"""),format.raw/*126.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*129.49*/("""{"""),format.raw/*129.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*132.38*/("""{"""),format.raw/*132.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*134.3*/("""}"""),format.raw/*134.4*/(""");
		return false;
	"""),format.raw/*136.2*/("""}"""),format.raw/*136.3*/(""");


		/*
		 * Seleccion de check en la tabla
		 */
		$('#checkAll').change( function()"""),format.raw/*142.36*/("""{"""),format.raw/*142.37*/("""
			var table = $(this).closest('table');
			table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
		"""),format.raw/*145.3*/("""}"""),format.raw/*145.4*/(""");

	
		
"""),format.raw/*149.1*/("""}"""),format.raw/*149.2*/(""");	
</script>



"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[ActaMovimiento],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[ActaMovimiento],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/indexActaMovimiento.scala.html
                    HASH: a2affbc8b4f2884784f0a9bc15dd2fd09381e3d6
                    MATRIX: 861->1|1053->77|1081->102|1395->381|1440->417|1480->419|1530->433|1548->442|1602->474|1650->491|2059->865|2106->896|2146->898|2186->903|2199->908|2291->978|2326->982|2428->1049|2442->1054|2565->1154|2636->1197|2665->1198|2875->1380|2904->1381|3075->1525|3103->1526|3200->1595|3229->1596|3429->1769|3457->1770|3553->1838|3582->1839|3731->1960|3760->1961|3839->2012|3868->2013|3918->2035|3947->2036|4016->2078|4044->2079|4078->2085|4107->2086|4190->2142|4218->2143|4250->2148|4278->2149|4311->2155|4339->2156|4386->2176|4414->2177|4476->2211|4505->2212|4583->2262|4612->2263|4792->2415|4821->2416|4880->2447|4909->2448|4980->2492|5008->2493|5045->2503|5073->2504|5137->2540|5166->2541|5245->2593|5273->2594|5307->2600|5336->2601|5430->2666|5460->2667|5553->2732|5582->2733|5665->2787|5695->2788|5850->2914|5880->2915|5955->2961|5985->2962|6131->3080|6160->3081|6239->3131|6269->3132|6404->3239|6433->3240|6468->3246|6498->3247|6575->3296|6604->3297|6637->3302|6666->3303|6718->3327|6747->3328|6819->3372|6848->3373|6933->3429|6963->3430|7104->3542|7134->3543|7202->3583|7231->3584|7281->3606|7310->3607|7432->3700|7462->3701|7629->3840|7658->3841|7699->3854|7728->3855
                    LINES: 26->1|30->1|31->3|40->12|40->12|40->12|41->13|41->13|41->13|42->14|64->36|64->36|64->36|65->37|65->37|65->37|66->38|71->43|71->43|71->43|76->48|76->48|84->56|84->56|88->60|88->60|90->62|90->62|95->67|95->67|97->69|97->69|100->72|100->72|102->74|102->74|103->75|103->75|105->77|105->77|105->77|105->77|107->79|107->79|108->80|108->80|109->81|109->81|111->83|111->83|113->85|113->85|114->86|114->86|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|130->102|130->102|133->105|133->105|135->107|135->107|138->110|138->110|139->111|139->111|142->114|142->114|142->114|142->114|145->117|145->117|145->117|145->117|147->119|147->119|148->120|148->120|150->122|150->122|154->126|154->126|157->129|157->129|160->132|160->132|162->134|162->134|164->136|164->136|170->142|170->142|173->145|173->145|177->149|177->149
                    -- GENERATED --
                */
            