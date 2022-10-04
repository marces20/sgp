
package views.html.recupero.presupuestoLineas

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
object indexPresupuestoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.PresupuestoLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[models.recupero.PresupuestoLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.96*/("""
<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Productos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Codigo</th>
			<th>Producto</th>
			<!-- <th>Cuenta analitica</th> -->
			<th>UDM</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Subtotal</th>
			"""),_display_(Seq[Any](/*24.5*/if(editable)/*24.17*/{_display_(Seq[Any](format.raw/*24.18*/("""
				<th></th>
			""")))})),format.raw/*26.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*30.3*/for(linea <- paginador.getList) yield /*30.34*/ {_display_(Seq[Any](format.raw/*30.36*/("""
		"""),_display_(Seq[Any](/*31.4*/views/*31.9*/.html.recupero.presupuestoLineas.lineaProducto(linea, editable))),format.raw/*31.72*/("""
	""")))})),format.raw/*32.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*37.6*/views/*37.11*/.html.helpers.paginador(paginador, controllers.recupero.routes.PresupuestoLineasController.index()))),format.raw/*37.110*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*42.14*/("""{"""),format.raw/*42.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*49.53*/("""{"""),format.raw/*49.54*/("""
		urlContenidoModal = '/recupero/presupuesto-linea/crear?presupuestoId='+$('#presupuestoId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*55.57*/("""{"""),format.raw/*55.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*62.56*/("""{"""),format.raw/*62.57*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*65.28*/("""{"""),format.raw/*65.29*/("""
			if(data.success)"""),format.raw/*66.20*/("""{"""),format.raw/*66.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*68.4*/("""}"""),format.raw/*68.5*/(""" else """),format.raw/*68.11*/("""{"""),format.raw/*68.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*70.4*/("""}"""),format.raw/*70.5*/("""
		"""),format.raw/*71.3*/("""}"""),format.raw/*71.4*/(""");
		return false;
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*75.28*/("""{"""),format.raw/*75.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*76.49*/("""{"""),format.raw/*76.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*82.35*/("""{"""),format.raw/*82.36*/("""
				$.get(url, function(data)"""),format.raw/*83.30*/("""{"""),format.raw/*83.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*85.5*/("""}"""),format.raw/*85.6*/(""");
		    """),format.raw/*86.7*/("""}"""),format.raw/*86.8*/(""",
		    close: function(event, ui )"""),format.raw/*87.34*/("""{"""),format.raw/*87.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*89.4*/("""}"""),format.raw/*89.5*/("""
		  """),format.raw/*90.5*/("""}"""),format.raw/*90.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*92.58*/("""{"""),format.raw/*92.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*95.3*/("""}"""),format.raw/*95.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*97.47*/("""{"""),format.raw/*97.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*100.42*/("""{"""),format.raw/*100.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*101.45*/("""{"""),format.raw/*101.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*104.56*/("""{"""),format.raw/*104.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""" else """),format.raw/*107.12*/("""{"""),format.raw/*107.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*109.5*/("""}"""),format.raw/*109.6*/("""
			"""),format.raw/*110.4*/("""}"""),format.raw/*110.5*/(""");
			return false;
		"""),format.raw/*112.3*/("""}"""),format.raw/*112.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*116.2*/("""}"""),format.raw/*116.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*119.49*/("""{"""),format.raw/*119.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*122.38*/("""{"""),format.raw/*122.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*124.3*/("""}"""),format.raw/*124.4*/(""");
		return false;
	"""),format.raw/*126.2*/("""}"""),format.raw/*126.3*/(""");
"""),format.raw/*127.1*/("""}"""),format.raw/*127.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[models.recupero.PresupuestoLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[models.recupero.PresupuestoLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuestoLineas/indexPresupuestoLinea.scala.html
                    HASH: 68ed47636d1176878110fe7d7dbc37db32557709
                    MATRIX: 880->1|1068->95|1206->199|1226->211|1264->212|1416->334|1557->440|1578->452|1617->453|1692->497|1895->665|1916->677|1955->678|2007->699|2076->733|2123->764|2163->766|2203->771|2216->776|2301->839|2336->843|2440->912|2454->917|2576->1016|2647->1059|2676->1060|2874->1230|2903->1231|3087->1388|3115->1389|3206->1452|3235->1453|3433->1624|3461->1625|3551->1687|3580->1688|3692->1772|3721->1773|3770->1794|3799->1795|3866->1835|3894->1836|3928->1842|3957->1843|4038->1897|4066->1898|4097->1902|4125->1903|4174->1925|4202->1926|4264->1960|4293->1961|4371->2011|4400->2012|4578->2162|4607->2163|4666->2194|4695->2195|4766->2239|4794->2240|4831->2250|4859->2251|4923->2287|4952->2288|5031->2340|5059->2341|5092->2347|5120->2348|5213->2413|5242->2414|5334->2479|5362->2480|5444->2534|5473->2535|5628->2661|5658->2662|5733->2708|5763->2709|5904->2822|5933->2823|6012->2873|6042->2874|6177->2981|6206->2982|6241->2988|6271->2989|6348->3038|6377->3039|6410->3044|6439->3045|6491->3069|6520->3070|6592->3114|6621->3115|6706->3171|6736->3172|6877->3284|6907->3285|6975->3325|7004->3326|7054->3348|7083->3349|7115->3353|7144->3354
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|52->24|52->24|52->24|54->26|58->30|58->30|58->30|59->31|59->31|59->31|60->32|65->37|65->37|65->37|70->42|70->42|77->49|77->49|81->53|81->53|83->55|83->55|88->60|88->60|90->62|90->62|93->65|93->65|94->66|94->66|96->68|96->68|96->68|96->68|98->70|98->70|99->71|99->71|101->73|101->73|103->75|103->75|104->76|104->76|110->82|110->82|111->83|111->83|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|123->95|123->95|125->97|125->97|128->100|128->100|129->101|129->101|132->104|132->104|132->104|132->104|135->107|135->107|135->107|135->107|137->109|137->109|138->110|138->110|140->112|140->112|144->116|144->116|147->119|147->119|150->122|150->122|152->124|152->124|154->126|154->126|155->127|155->127
                    -- GENERATED --
                */
            