
package views.html.rrhh.agenteSeguimientoLineas

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
object indexLineaSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteSeguimientoLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteSeguimientoLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.86*/("""
<div id="listaLineaEventos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Eventos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoEvento"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDeEventos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar" width="30">#</th>
			""")))})),format.raw/*16.5*/("""
			<th >Observacion</th>
			<th width="60">Fecha</th>
			 
			"""),_display_(Seq[Any](/*20.5*/if(editable)/*20.17*/{_display_(Seq[Any](format.raw/*20.18*/("""
				<th width="30"></th>
			""")))})),format.raw/*22.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*26.3*/for(linea <- paginador.getList) yield /*26.34*/ {_display_(Seq[Any](format.raw/*26.36*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.rrhh.agenteSeguimientoLineas.lineaSeguimiento(linea, editable))),format.raw/*27.77*/("""
	""")))})),format.raw/*28.3*/("""
	</tbody>
</table>
<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*32.6*/views/*32.11*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesSeguimientoLineasController.index()))),format.raw/*32.113*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*37.14*/("""{"""),format.raw/*37.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaEventos");

	contenedor.on('click', '#nuevoEvento', function()"""),format.raw/*44.51*/("""{"""),format.raw/*44.52*/("""
		urlContenidoModal = '/rrhh/seguimiento-linea/crear?seguimientoId='+$('#agenteSeguimientoId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*48.2*/("""}"""),format.raw/*48.3*/(""");
	
	contenedor.on('click', '.modificarEvento', function()"""),format.raw/*50.55*/("""{"""),format.raw/*50.56*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar evento');	
		return false;
	"""),format.raw/*55.2*/("""}"""),format.raw/*55.3*/(""");
	
	contenedor.on('click', '.eliminarEvento', function()"""),format.raw/*57.54*/("""{"""),format.raw/*57.55*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*59.23*/("""{"""),format.raw/*59.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*62.29*/("""{"""),format.raw/*62.30*/("""
				if(data.success)"""),format.raw/*63.21*/("""{"""),format.raw/*63.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*65.5*/("""}"""),format.raw/*65.6*/(""" else """),format.raw/*65.12*/("""{"""),format.raw/*65.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*67.5*/("""}"""),format.raw/*67.6*/("""
			"""),format.raw/*68.4*/("""}"""),format.raw/*68.5*/(""");
		"""),format.raw/*69.3*/("""}"""),format.raw/*69.4*/("""
		return false;
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*73.28*/("""{"""),format.raw/*73.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*74.49*/("""{"""),format.raw/*74.50*/("""
			resizable: false,
		    title: "Cargar evento",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*80.35*/("""{"""),format.raw/*80.36*/("""
				$.get(url, function(data)"""),format.raw/*81.30*/("""{"""),format.raw/*81.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*83.5*/("""}"""),format.raw/*83.6*/(""");
		    """),format.raw/*84.7*/("""}"""),format.raw/*84.8*/(""",
		    close: function(event, ui )"""),format.raw/*85.34*/("""{"""),format.raw/*85.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*87.4*/("""}"""),format.raw/*87.5*/("""
		  """),format.raw/*88.5*/("""}"""),format.raw/*88.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*90.58*/("""{"""),format.raw/*90.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*93.3*/("""}"""),format.raw/*93.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*95.47*/("""{"""),format.raw/*95.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*98.42*/("""{"""),format.raw/*98.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*99.45*/("""{"""),format.raw/*99.46*/("""
					$('#listaDeEventos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*102.5*/("""}"""),format.raw/*102.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*102.56*/("""{"""),format.raw/*102.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""" else """),format.raw/*105.12*/("""{"""),format.raw/*105.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*107.5*/("""}"""),format.raw/*107.6*/("""
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/(""");
			return false;
		"""),format.raw/*110.3*/("""}"""),format.raw/*110.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*114.2*/("""}"""),format.raw/*114.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*117.49*/("""{"""),format.raw/*117.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*120.38*/("""{"""),format.raw/*120.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
		return false;
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/(""");
"""),format.raw/*125.1*/("""}"""),format.raw/*125.2*/(""");
</script>"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteSeguimientoLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteSeguimientoLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientoLineas/indexLineaSeguimiento.scala.html
                    HASH: 3e083312300f7b64ce27af1b72eaaae6c6fde36d
                    MATRIX: 872->1|1050->85|1179->180|1199->192|1237->193|1385->311|1518->409|1539->421|1578->422|1662->475|1761->539|1782->551|1821->552|1882->582|1947->612|1994->643|2034->645|2073->649|2086->654|2176->722|2210->725|2308->788|2322->793|2447->895|2513->933|2542->934|2729->1093|2758->1094|2940->1249|2968->1250|3055->1309|3084->1310|3275->1474|3303->1475|3389->1533|3418->1534|3530->1618|3559->1619|3671->1703|3700->1704|3749->1725|3778->1726|3845->1766|3873->1767|3907->1773|3936->1774|4017->1828|4045->1829|4076->1833|4104->1834|4136->1839|4164->1840|4209->1858|4237->1859|4297->1891|4326->1892|4403->1941|4432->1942|4602->2084|4631->2085|4689->2115|4718->2116|4787->2158|4815->2159|4851->2168|4879->2169|4942->2204|4971->2205|5048->2255|5076->2256|5108->2261|5136->2262|5227->2325|5256->2326|5345->2388|5373->2389|5453->2441|5482->2442|5633->2565|5662->2566|5735->2611|5764->2612|5900->2720|5929->2721|6008->2771|6038->2772|6170->2876|6199->2877|6234->2883|6264->2884|6339->2931|6368->2932|6400->2936|6429->2937|6479->2959|6508->2960|6576->3000|6605->3001|6687->3054|6717->3055|6855->3164|6885->3165|6951->3203|6980->3204|7028->3224|7057->3225|7088->3228|7117->3229
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|48->20|48->20|48->20|50->22|54->26|54->26|54->26|55->27|55->27|55->27|56->28|60->32|60->32|60->32|65->37|65->37|72->44|72->44|76->48|76->48|78->50|78->50|83->55|83->55|85->57|85->57|87->59|87->59|90->62|90->62|91->63|91->63|93->65|93->65|93->65|93->65|95->67|95->67|96->68|96->68|97->69|97->69|99->71|99->71|101->73|101->73|102->74|102->74|108->80|108->80|109->81|109->81|111->83|111->83|112->84|112->84|113->85|113->85|115->87|115->87|116->88|116->88|118->90|118->90|121->93|121->93|123->95|123->95|126->98|126->98|127->99|127->99|130->102|130->102|130->102|130->102|133->105|133->105|133->105|133->105|135->107|135->107|136->108|136->108|138->110|138->110|142->114|142->114|145->117|145->117|148->120|148->120|150->122|150->122|152->124|152->124|153->125|153->125
                    -- GENERATED --
                */
            