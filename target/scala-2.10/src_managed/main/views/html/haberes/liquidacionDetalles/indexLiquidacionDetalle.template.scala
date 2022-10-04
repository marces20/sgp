
package views.html.haberes.liquidacionDetalles

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
object indexLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[models.haberes.LiquidacionDetalle],Boolean,models.haberes.LiquidacionPuesto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[models.haberes.LiquidacionDetalle], editable: Boolean,lc:models.haberes.LiquidacionPuesto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.133*/("""
"""),format.raw/*5.1*/("""
<div id="listaLiquidacionDetalles" class="contenedorPaginador ajaxPaginador">

	<p>
	
		"""),_display_(Seq[Any](/*10.4*/if(editable && Permiso.check("liquidacionDetalleAgregar"))/*10.62*/{_display_(Seq[Any](format.raw/*10.63*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoLiquidacionDetalle"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
		""")))})),format.raw/*12.4*/("""
	</p>
	
	<table id="listaDeLiquidacionDetalles" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th class="accion-editar">#</th>
				<th>Concepto</th>
				<th style="text-align: center;">Cantidad</th>
				<th style="text-align: center;">Haberes C/A</th>
				<th style="text-align: center;">Haberes S/A</th>
				<th style="text-align: center;">Descuentos</th>
				<th></th>
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*28.4*/for(detalle <- paginador.getList) yield /*28.37*/ {_display_(Seq[Any](format.raw/*28.39*/("""
			"""),_display_(Seq[Any](/*29.5*/views/*29.10*/.html.haberes.liquidacionDetalles.lineaLiquidacionDetalle(detalle, editable))),format.raw/*29.86*/("""
		""")))})),format.raw/*30.4*/("""
		</tbody>
		<tfoot>
			"""),_display_(Seq[Any](/*33.5*/views/*33.10*/.html.haberes.liquidacionDetalles.footFineaLiquidacionDetalle(lc))),format.raw/*33.75*/("""
		</tfoot>
		
	</table>
	
	 
</div>

<script>
$( function()"""),format.raw/*42.14*/("""{"""),format.raw/*42.15*/("""
	/*
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLiquidacionDetalles");

	contenedor.on('click', '#nuevoLiquidacionDetalle', function()"""),format.raw/*49.63*/("""{"""),format.raw/*49.64*/("""
		urlContenidoModal = '/haberes/liquidacion-detalle/crear?liquidacionPuestoId='+$('#liquidacionPuestoId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/(""");
	
	contenedor.on('click', '.modificarLiquidacionDetalle', function()"""),format.raw/*55.67*/("""{"""),format.raw/*55.68*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Detalle');	
		return false;
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
	
	contenedor.on('click', '.eliminarv', function()"""),format.raw/*62.49*/("""{"""),format.raw/*62.50*/("""
		var url = $(this).attr('href');
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*65.23*/("""{"""),format.raw/*65.24*/("""
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*67.29*/("""{"""),format.raw/*67.30*/("""
				if(data.success)"""),format.raw/*68.21*/("""{"""),format.raw/*68.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*70.5*/("""}"""),format.raw/*70.6*/(""" else """),format.raw/*70.12*/("""{"""),format.raw/*70.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*72.5*/("""}"""),format.raw/*72.6*/("""
			"""),format.raw/*73.4*/("""}"""),format.raw/*73.5*/(""");
		"""),format.raw/*74.3*/("""}"""),format.raw/*74.4*/("""
		return false;
	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*78.28*/("""{"""),format.raw/*78.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*79.49*/("""{"""),format.raw/*79.50*/("""
			resizable: false,
		    title: "Cargar Detalle",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*85.35*/("""{"""),format.raw/*85.36*/("""
				$.get(url, function(data)"""),format.raw/*86.30*/("""{"""),format.raw/*86.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*88.5*/("""}"""),format.raw/*88.6*/(""");
		    """),format.raw/*89.7*/("""}"""),format.raw/*89.8*/(""",
		    close: function(event, ui )"""),format.raw/*90.34*/("""{"""),format.raw/*90.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*92.4*/("""}"""),format.raw/*92.5*/("""
		  """),format.raw/*93.5*/("""}"""),format.raw/*93.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*95.58*/("""{"""),format.raw/*95.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*98.3*/("""}"""),format.raw/*98.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*100.47*/("""{"""),format.raw/*100.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*103.42*/("""{"""),format.raw/*103.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*104.45*/("""{"""),format.raw/*104.46*/("""
					$('#listaDeLiquidacionDetalles tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*107.56*/("""{"""),format.raw/*107.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""" else """),format.raw/*110.12*/("""{"""),format.raw/*110.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""
			"""),format.raw/*113.4*/("""}"""),format.raw/*113.5*/(""");
			return false;
		"""),format.raw/*115.3*/("""}"""),format.raw/*115.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*119.2*/("""}"""),format.raw/*119.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*122.49*/("""{"""),format.raw/*122.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*125.38*/("""{"""),format.raw/*125.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/(""");
		return false;
	"""),format.raw/*129.2*/("""}"""),format.raw/*129.3*/(""");
"""),format.raw/*130.1*/("""}"""),format.raw/*130.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[models.haberes.LiquidacionDetalle],editable:Boolean,lc:models.haberes.LiquidacionPuesto): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,lc)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionDetalle],Boolean,models.haberes.LiquidacionPuesto) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,lc) => apply(paginador,editable,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/indexLiquidacionDetalle.scala.html
                    HASH: 7343a7fe3f3dad2877689300ec723a9a344ac56a
                    MATRIX: 917->1|1200->132|1228->192|1358->287|1425->345|1464->346|1630->481|2106->922|2155->955|2195->957|2236->963|2250->968|2348->1044|2384->1049|2448->1078|2462->1083|2549->1148|2646->1217|2675->1218|2887->1402|2916->1403|3113->1573|3141->1574|3242->1647|3271->1648|3468->1818|3496->1819|3579->1874|3608->1875|3757->1996|3786->1997|3865->2048|3894->2049|3944->2071|3973->2072|4042->2114|4070->2115|4104->2121|4133->2122|4216->2178|4244->2179|4276->2184|4304->2185|4337->2191|4365->2192|4412->2212|4440->2213|4502->2247|4531->2248|4609->2298|4638->2299|4815->2448|4844->2449|4903->2480|4932->2481|5003->2525|5031->2526|5068->2536|5096->2537|5160->2573|5189->2574|5268->2626|5296->2627|5329->2633|5357->2634|5450->2699|5479->2700|5571->2765|5599->2766|5682->2820|5712->2821|5867->2947|5897->2948|5972->2994|6002->2995|6153->3118|6182->3119|6261->3169|6291->3170|6426->3277|6455->3278|6490->3284|6520->3285|6597->3334|6626->3335|6659->3340|6688->3341|6740->3365|6769->3366|6841->3410|6870->3411|6955->3467|6985->3468|7126->3580|7156->3581|7224->3621|7253->3622|7303->3644|7332->3645|7364->3649|7393->3650
                    LINES: 26->1|34->1|35->5|40->10|40->10|40->10|42->12|58->28|58->28|58->28|59->29|59->29|59->29|60->30|63->33|63->33|63->33|72->42|72->42|79->49|79->49|83->53|83->53|85->55|85->55|90->60|90->60|92->62|92->62|95->65|95->65|97->67|97->67|98->68|98->68|100->70|100->70|100->70|100->70|102->72|102->72|103->73|103->73|104->74|104->74|106->76|106->76|108->78|108->78|109->79|109->79|115->85|115->85|116->86|116->86|118->88|118->88|119->89|119->89|120->90|120->90|122->92|122->92|123->93|123->93|125->95|125->95|128->98|128->98|130->100|130->100|133->103|133->103|134->104|134->104|137->107|137->107|137->107|137->107|140->110|140->110|140->110|140->110|142->112|142->112|143->113|143->113|145->115|145->115|149->119|149->119|152->122|152->122|155->125|155->125|157->127|157->127|159->129|159->129|160->130|160->130
                    -- GENERATED --
                */
            