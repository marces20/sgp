
package views.html.compras.lineasPedidosFondos

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
object indexPedidoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[PedidoFondoLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[PedidoFondoLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.80*/("""
<div id="listaLineaPedidos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Pedidos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoPedido"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDePedidos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Expediente</th>
			<th>Proveedor</th>
			<th>Monto</th>
			<th>Concepto</th>
			"""),_display_(Seq[Any](/*21.5*/if(editable)/*21.17*/{_display_(Seq[Any](format.raw/*21.18*/("""
				<th></th>
			""")))})),format.raw/*23.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*27.3*/for(linea <- paginador.getList) yield /*27.34*/ {_display_(Seq[Any](format.raw/*27.36*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.compras.lineasPedidosFondos.lineaPedido(linea, editable))),format.raw/*28.71*/("""
	""")))})),format.raw/*29.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*34.6*/views/*34.11*/.html.helpers.paginador(paginador, controllers.compras.routes.LineasPedidosFondosController.index()))),format.raw/*34.111*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*39.14*/("""{"""),format.raw/*39.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaPedidos");

	contenedor.on('click', '#nuevoPedido', function()"""),format.raw/*46.51*/("""{"""),format.raw/*46.52*/("""
		urlContenidoModal = '/compras/pedido-fondo-linea/crear?pedidoFondoId='+$('#id').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*50.2*/("""}"""),format.raw/*50.3*/(""");
	
	contenedor.on('click', '.modificarPedido', function()"""),format.raw/*52.55*/("""{"""),format.raw/*52.56*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar pedido');	
		return false;
	"""),format.raw/*57.2*/("""}"""),format.raw/*57.3*/(""");
	
	contenedor.on('click', '.eliminarPedido', function()"""),format.raw/*59.54*/("""{"""),format.raw/*59.55*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*62.28*/("""{"""),format.raw/*62.29*/("""
			if(data.success)"""),format.raw/*63.20*/("""{"""),format.raw/*63.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*65.4*/("""}"""),format.raw/*65.5*/(""" else """),format.raw/*65.11*/("""{"""),format.raw/*65.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*67.4*/("""}"""),format.raw/*67.5*/("""
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*72.28*/("""{"""),format.raw/*72.29*/("""
		modalCargaPedido = $('<div></div>').dialog("""),format.raw/*73.46*/("""{"""),format.raw/*73.47*/("""
			resizable: false,
		    title: "Cargar pedido",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*79.35*/("""{"""),format.raw/*79.36*/("""
				$.get(url, function(data)"""),format.raw/*80.30*/("""{"""),format.raw/*80.31*/("""
					modalCargaPedido.html(data);
				"""),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""");
		    """),format.raw/*83.7*/("""}"""),format.raw/*83.8*/(""",
		    close: function(event, ui )"""),format.raw/*84.34*/("""{"""),format.raw/*84.35*/("""
		    	modalCargaPedido.dialog('destroy');
			"""),format.raw/*86.4*/("""}"""),format.raw/*86.5*/("""
		  """),format.raw/*87.5*/("""}"""),format.raw/*87.6*/(""");
		
		modalCargaPedido.on('click', '.cancelar', function()"""),format.raw/*89.55*/("""{"""),format.raw/*89.56*/("""
			modalCargaPedido.dialog('destroy');
			return false;
		"""),format.raw/*92.3*/("""}"""),format.raw/*92.4*/(""");
		
		modalCargaPedido.on('submit', function(e)"""),format.raw/*94.44*/("""{"""),format.raw/*94.45*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*97.42*/("""{"""),format.raw/*97.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*98.45*/("""{"""),format.raw/*98.46*/("""
					$('#listaDePedidos tbody').prepend(resultado.html);
					modalCargaPedido.dialog( "destroy" );
				"""),format.raw/*101.5*/("""}"""),format.raw/*101.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*101.56*/("""{"""),format.raw/*101.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaPedido.dialog( "destroy" );
				"""),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""" else """),format.raw/*104.12*/("""{"""),format.raw/*104.13*/("""
					modalCargaPedido.html(resultado);
				"""),format.raw/*106.5*/("""}"""),format.raw/*106.6*/("""
			"""),format.raw/*107.4*/("""}"""),format.raw/*107.5*/(""");
			return false;
		"""),format.raw/*109.3*/("""}"""),format.raw/*109.4*/(""");
		
		
		return modalCargaPedido;
	"""),format.raw/*113.2*/("""}"""),format.raw/*113.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*116.49*/("""{"""),format.raw/*116.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*119.38*/("""{"""),format.raw/*119.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*121.3*/("""}"""),format.raw/*121.4*/(""");
		return false;
	"""),format.raw/*123.2*/("""}"""),format.raw/*123.3*/(""");
"""),format.raw/*124.1*/("""}"""),format.raw/*124.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[PedidoFondoLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[PedidoFondoLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasPedidosFondos/indexPedidoLinea.scala.html
                    HASH: a4c975d7185e46a90e8f8974445ec6892a39bce0
                    MATRIX: 860->1|1032->79|1161->174|1181->186|1219->187|1367->305|1500->403|1521->415|1560->416|1633->458|1757->547|1778->559|1817->560|1867->579|1932->609|1979->640|2019->642|2058->646|2071->651|2155->713|2189->716|2288->780|2302->785|2425->885|2491->923|2520->924|2707->1083|2736->1084|2905->1226|2933->1227|3020->1286|3049->1287|3240->1451|3268->1452|3354->1510|3383->1511|3492->1592|3521->1593|3569->1613|3598->1614|3663->1652|3691->1653|3725->1659|3754->1660|3833->1712|3861->1713|3891->1716|3919->1717|3966->1737|3994->1738|4054->1770|4083->1771|4157->1817|4186->1818|4356->1960|4385->1961|4443->1991|4472->1992|4538->2031|4566->2032|4602->2041|4630->2042|4693->2077|4722->2078|4796->2125|4824->2126|4856->2131|4884->2132|4972->2192|5001->2193|5087->2252|5115->2253|5192->2302|5221->2303|5372->2426|5401->2427|5474->2472|5503->2473|5636->2578|5665->2579|5744->2629|5774->2630|5903->2731|5932->2732|5967->2738|5997->2739|6069->2783|6098->2784|6130->2788|6159->2789|6209->2811|6238->2812|6303->2849|6332->2850|6414->2903|6444->2904|6582->3013|6612->3014|6678->3052|6707->3053|6755->3073|6784->3074|6815->3077|6844->3078
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|49->21|49->21|49->21|51->23|55->27|55->27|55->27|56->28|56->28|56->28|57->29|62->34|62->34|62->34|67->39|67->39|74->46|74->46|78->50|78->50|80->52|80->52|85->57|85->57|87->59|87->59|90->62|90->62|91->63|91->63|93->65|93->65|93->65|93->65|95->67|95->67|96->68|96->68|98->70|98->70|100->72|100->72|101->73|101->73|107->79|107->79|108->80|108->80|110->82|110->82|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|117->89|117->89|120->92|120->92|122->94|122->94|125->97|125->97|126->98|126->98|129->101|129->101|129->101|129->101|132->104|132->104|132->104|132->104|134->106|134->106|135->107|135->107|137->109|137->109|141->113|141->113|144->116|144->116|147->119|147->119|149->121|149->121|151->123|151->123|152->124|152->124
                    -- GENERATED --
                */
            