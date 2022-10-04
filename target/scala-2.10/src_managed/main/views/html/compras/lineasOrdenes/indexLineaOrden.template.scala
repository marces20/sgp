
package views.html.compras.lineasOrdenes

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
object indexLineaOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[OrdenLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.74*/("""
<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Productos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
	<a id="eliminarfacturas" href=""""),_display_(Seq[Any](/*8.34*/controllers/*8.45*/.compras.routes.LineasOrdenesController.eliminarMasivo())),format.raw/*8.101*/("""" class="btn btn-xs btn-default"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>	 	
	""")))})),format.raw/*9.3*/("""
</p>

"""),_display_(Seq[Any](/*12.2*/if(paginador.getTotalRowCount() <= 0)/*12.39*/{_display_(Seq[Any](format.raw/*12.40*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> No existen lineas de productos para esta orden.</p>
""")))})),format.raw/*14.2*/("""


"""),_display_(Seq[Any](/*17.2*/if(paginador.getTotalRowCount() > 0)/*17.38*/ {_display_(Seq[Any](format.raw/*17.40*/("""
	Mostrando """),_display_(Seq[Any](/*18.13*/paginador/*18.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*18.54*/(""" resultado(s).
""")))})),format.raw/*19.2*/("""

<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*24.5*/if(editable)/*24.17*/{_display_(Seq[Any](format.raw/*24.18*/("""
				<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
				<th class="accion-editar">#</th>
			""")))})),format.raw/*27.5*/("""
			<th width="350"><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*28.53*/controllers/*28.64*/.compras.routes.LineasOrdenesController.index())),format.raw/*28.111*/("""?"""),_display_(Seq[Any](/*28.113*/paginador/*28.122*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "producto.nombre").getCurrentLink())),format.raw/*28.249*/("""">Producto</a></th>
			<th width="40">Cantidad</th>
			<th>UDM</th>
			<th>Precio</th>
			<th width="200"><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*32.53*/controllers/*32.64*/.compras.routes.LineasOrdenesController.index())),format.raw/*32.111*/("""?"""),_display_(Seq[Any](/*32.113*/paginador/*32.122*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "cuentaAnalitica.nombre").getCurrentLink())),format.raw/*32.256*/("""">Cuenta analitica</a></th>
			<th>Servicio</th>
			<th>Subtotal</th>
			<th></th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*39.3*/for(linea <- paginador.getList) yield /*39.34*/ {_display_(Seq[Any](format.raw/*39.36*/("""
		"""),_display_(Seq[Any](/*40.4*/views/*40.9*/.html.compras.lineasOrdenes.lineaProducto(linea, editable))),format.raw/*40.67*/("""
	""")))})),format.raw/*41.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*46.6*/views/*46.11*/.html.helpers.paginador(paginador, controllers.compras.routes.LineasOrdenesController.index()))),format.raw/*46.105*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*58.53*/("""{"""),format.raw/*58.54*/("""
		urlContenidoModal = '/compras/linea-orden/crear?ordenId='+$('#ordenId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*64.57*/("""{"""),format.raw/*64.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*71.56*/("""{"""),format.raw/*71.57*/("""
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
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*88.49*/("""{"""),format.raw/*88.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 500,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*94.35*/("""{"""),format.raw/*94.36*/("""
				$.get(url, function(data)"""),format.raw/*95.30*/("""{"""),format.raw/*95.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*97.5*/("""}"""),format.raw/*97.6*/(""");
		    """),format.raw/*98.7*/("""}"""),format.raw/*98.8*/(""",
		    close: function(event, ui )"""),format.raw/*99.34*/("""{"""),format.raw/*99.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*101.4*/("""}"""),format.raw/*101.5*/("""
		  """),format.raw/*102.5*/("""}"""),format.raw/*102.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*104.58*/("""{"""),format.raw/*104.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*107.3*/("""}"""),format.raw/*107.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*109.47*/("""{"""),format.raw/*109.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*112.42*/("""{"""),format.raw/*112.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*113.45*/("""{"""),format.raw/*113.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*116.5*/("""}"""),format.raw/*116.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*116.56*/("""{"""),format.raw/*116.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""" else """),format.raw/*119.12*/("""{"""),format.raw/*119.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*121.5*/("""}"""),format.raw/*121.6*/("""
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/(""");
			return false;
		"""),format.raw/*124.3*/("""}"""),format.raw/*124.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*128.2*/("""}"""),format.raw/*128.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*131.49*/("""{"""),format.raw/*131.50*/("""
		alert("xxxxx");
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
	$('#checkAll').change( function()"""),format.raw/*146.35*/("""{"""),format.raw/*146.36*/("""
		var table = $(this).closest('table');
		table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
	"""),format.raw/*149.2*/("""}"""),format.raw/*149.3*/(""");

	$(document).on('click', '#eliminarfacturas', function()"""),format.raw/*151.57*/("""{"""),format.raw/*151.58*/("""
		link = $(this).attr("href");
		var retorno = false;

		if($("input[name='check_listado[]']:checked").length == 0) """),format.raw/*155.62*/("""{"""),format.raw/*155.63*/("""
			alert("Debe seleccionar al menos una linea de factura.");
			return false;
		"""),format.raw/*158.3*/("""}"""),format.raw/*158.4*/("""
		
		
		var ids = $("input[name='check_listado[]']").serialize();
		

		
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar los registros registros seleccionados?<p></div>');
	    dialogo.dialog("""),format.raw/*166.21*/("""{"""),format.raw/*166.22*/("""
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar",
	        buttons: """),format.raw/*171.19*/("""{"""),format.raw/*171.20*/("""
	          Eliminar: function() """),format.raw/*172.33*/("""{"""),format.raw/*172.34*/("""
	            $.post(link, ids, function(data)"""),format.raw/*173.46*/("""{"""),format.raw/*173.47*/("""
	            	if(data.success) """),format.raw/*174.32*/("""{"""),format.raw/*174.33*/("""
	            		location.reload();
	            	"""),format.raw/*176.15*/("""}"""),format.raw/*176.16*/(""" else """),format.raw/*176.22*/("""{"""),format.raw/*176.23*/("""
	            		alert("No se pudo eliminar las lineas de productos.");
	            	"""),format.raw/*178.15*/("""}"""),format.raw/*178.16*/("""
	            """),format.raw/*179.14*/("""}"""),format.raw/*179.15*/(""");
	          """),format.raw/*180.12*/("""}"""),format.raw/*180.13*/(""",
	          Cancelar: function( event, ui ) """),format.raw/*181.44*/("""{"""),format.raw/*181.45*/("""
	            $( this ).dialog( "close" );
	          """),format.raw/*183.12*/("""}"""),format.raw/*183.13*/("""
	        """),format.raw/*184.10*/("""}"""),format.raw/*184.11*/(""",
		    close: function()"""),format.raw/*185.24*/("""{"""),format.raw/*185.25*/("""
		    	$( this ).dialog( "destroy" );
		    """),format.raw/*187.7*/("""}"""),format.raw/*187.8*/("""
	      """),format.raw/*188.8*/("""}"""),format.raw/*188.9*/(""");
	    return false;
	"""),format.raw/*190.2*/("""}"""),format.raw/*190.3*/("""); 
	
	
	
"""),format.raw/*194.1*/("""}"""),format.raw/*194.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[OrdenLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[OrdenLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/indexLineaOrden.scala.html
                    HASH: da3d79dda2958f32bd8dd2fd2abca6377c5e4219
                    MATRIX: 847->1|1013->73|1151->177|1171->189|1209->190|1394->340|1413->351|1491->407|1630->516|1676->527|1722->564|1761->565|1898->671|1940->678|1985->714|2025->716|2075->730|2093->739|2147->771|2195->788|2330->888|2351->900|2390->901|2545->1025|2635->1079|2655->1090|2725->1137|2764->1139|2783->1148|2933->1275|3112->1418|3132->1429|3202->1476|3241->1478|3260->1487|3417->1621|3571->1740|3618->1771|3658->1773|3698->1778|3711->1783|3791->1841|3826->1845|3928->1912|3942->1917|4059->2011|4130->2054|4159->2055|4357->2225|4386->2226|4551->2364|4579->2365|4670->2428|4699->2429|4897->2600|4925->2601|5015->2663|5044->2664|5158->2750|5187->2751|5302->2838|5331->2839|5381->2861|5410->2862|5479->2904|5507->2905|5541->2911|5570->2912|5653->2968|5681->2969|5713->2974|5741->2975|5774->2981|5802->2982|5849->3002|5877->3003|5939->3037|5968->3038|6046->3088|6075->3089|6253->3239|6282->3240|6341->3271|6370->3272|6441->3316|6469->3317|6506->3327|6534->3328|6598->3364|6627->3365|6707->3417|6736->3418|6770->3424|6799->3425|6893->3490|6923->3491|7016->3556|7045->3557|7128->3611|7158->3612|7313->3738|7343->3739|7418->3785|7448->3786|7589->3899|7618->3900|7697->3950|7727->3951|7862->4058|7891->4059|7926->4065|7956->4066|8033->4115|8062->4116|8095->4121|8124->4122|8176->4146|8205->4147|8277->4191|8306->4192|8391->4248|8421->4249|8581->4380|8611->4381|8679->4421|8708->4422|8758->4444|8787->4445|8909->4538|8939->4539|9103->4675|9132->4676|9223->4738|9253->4739|9403->4860|9433->4861|9545->4945|9574->4946|9900->5243|9930->5244|10081->5366|10111->5367|10174->5401|10204->5402|10280->5449|10310->5450|10372->5483|10402->5484|10482->5535|10512->5536|10547->5542|10577->5543|10693->5630|10723->5631|10767->5646|10797->5647|10841->5662|10871->5663|10946->5709|10976->5710|11061->5766|11091->5767|11131->5778|11161->5779|11216->5805|11246->5806|11321->5853|11350->5854|11387->5863|11416->5864|11469->5889|11498->5890|11540->5904|11569->5905
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|36->8|36->8|37->9|40->12|40->12|40->12|42->14|45->17|45->17|45->17|46->18|46->18|46->18|47->19|52->24|52->24|52->24|55->27|56->28|56->28|56->28|56->28|56->28|56->28|60->32|60->32|60->32|60->32|60->32|60->32|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46|74->46|79->51|79->51|86->58|86->58|90->62|90->62|92->64|92->64|97->69|97->69|99->71|99->71|101->73|101->73|104->76|104->76|105->77|105->77|107->79|107->79|107->79|107->79|109->81|109->81|110->82|110->82|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|122->94|122->94|123->95|123->95|125->97|125->97|126->98|126->98|127->99|127->99|129->101|129->101|130->102|130->102|132->104|132->104|135->107|135->107|137->109|137->109|140->112|140->112|141->113|141->113|144->116|144->116|144->116|144->116|147->119|147->119|147->119|147->119|149->121|149->121|150->122|150->122|152->124|152->124|156->128|156->128|159->131|159->131|163->135|163->135|165->137|165->137|167->139|167->139|174->146|174->146|177->149|177->149|179->151|179->151|183->155|183->155|186->158|186->158|194->166|194->166|199->171|199->171|200->172|200->172|201->173|201->173|202->174|202->174|204->176|204->176|204->176|204->176|206->178|206->178|207->179|207->179|208->180|208->180|209->181|209->181|211->183|211->183|212->184|212->184|213->185|213->185|215->187|215->187|216->188|216->188|218->190|218->190|222->194|222->194
                    -- GENERATED --
                */
            