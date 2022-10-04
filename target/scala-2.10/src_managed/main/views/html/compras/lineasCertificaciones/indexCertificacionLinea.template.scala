
package views.html.compras.lineasCertificaciones

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
object indexCertificacionLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CertificacionLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[CertificacionLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.82*/("""
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
			<th>Producto</th>
			<th>Cuenta analitica</th>
			<th>Cantidad</th>
			<th>UDM</th>
			<th>Precio</th>
			<th>Descuento (%)</th>
			<th>Subtotal desc.</th>
			<th>Subtotal</th>
			"""),_display_(Seq[Any](/*25.5*/if(editable)/*25.17*/{_display_(Seq[Any](format.raw/*25.18*/("""
				<th></th>
			""")))})),format.raw/*27.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*31.3*/for(linea <- paginador.getList) yield /*31.34*/ {_display_(Seq[Any](format.raw/*31.36*/("""
		"""),_display_(Seq[Any](/*32.4*/views/*32.9*/.html.compras.lineasCertificaciones.lineaProducto(linea, editable))),format.raw/*32.75*/("""
	""")))})),format.raw/*33.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*38.6*/views/*38.11*/.html.helpers.paginador(paginador, controllers.compras.routes.LineasCertificacionesController.index()))),format.raw/*38.113*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*43.14*/("""{"""),format.raw/*43.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*50.53*/("""{"""),format.raw/*50.54*/("""
		urlContenidoModal = '/compras/certificacion-linea/crear?certificacionId='+$('#certificacionId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*54.2*/("""}"""),format.raw/*54.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*56.57*/("""{"""),format.raw/*56.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*63.56*/("""{"""),format.raw/*63.57*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*65.23*/("""{"""),format.raw/*65.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*68.29*/("""{"""),format.raw/*68.30*/("""
				if(data.success)"""),format.raw/*69.21*/("""{"""),format.raw/*69.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*71.5*/("""}"""),format.raw/*71.6*/(""" else """),format.raw/*71.12*/("""{"""),format.raw/*71.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""
			"""),format.raw/*74.4*/("""}"""),format.raw/*74.5*/(""");
		"""),format.raw/*75.3*/("""}"""),format.raw/*75.4*/("""
		return false;
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*79.28*/("""{"""),format.raw/*79.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*80.49*/("""{"""),format.raw/*80.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*86.35*/("""{"""),format.raw/*86.36*/("""
				$.get(url, function(data)"""),format.raw/*87.30*/("""{"""),format.raw/*87.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*89.5*/("""}"""),format.raw/*89.6*/(""");
		    """),format.raw/*90.7*/("""}"""),format.raw/*90.8*/(""",
		    close: function(event, ui )"""),format.raw/*91.34*/("""{"""),format.raw/*91.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*93.4*/("""}"""),format.raw/*93.5*/("""
		  """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*96.58*/("""{"""),format.raw/*96.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*99.3*/("""}"""),format.raw/*99.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*101.47*/("""{"""),format.raw/*101.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*104.42*/("""{"""),format.raw/*104.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*105.45*/("""{"""),format.raw/*105.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*108.5*/("""}"""),format.raw/*108.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*108.56*/("""{"""),format.raw/*108.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*111.5*/("""}"""),format.raw/*111.6*/(""" else """),format.raw/*111.12*/("""{"""),format.raw/*111.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*113.5*/("""}"""),format.raw/*113.6*/("""
			"""),format.raw/*114.4*/("""}"""),format.raw/*114.5*/(""");
			return false;
		"""),format.raw/*116.3*/("""}"""),format.raw/*116.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*120.2*/("""}"""),format.raw/*120.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*123.49*/("""{"""),format.raw/*123.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*126.38*/("""{"""),format.raw/*126.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");
		return false;
	"""),format.raw/*130.2*/("""}"""),format.raw/*130.3*/(""");
"""),format.raw/*131.1*/("""}"""),format.raw/*131.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[CertificacionLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[CertificacionLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificaciones/indexCertificacionLinea.scala.html
                    HASH: 33a4f8e101f40587523b42be7830c47d4cd22c8d
                    MATRIX: 871->1|1045->81|1183->185|1203->197|1241->198|1393->320|1534->426|1555->438|1594->439|1669->483|1898->677|1919->689|1958->690|2010->711|2079->745|2126->776|2166->778|2206->783|2219->788|2307->854|2342->858|2446->927|2460->932|2585->1034|2656->1077|2685->1078|2883->1248|2912->1249|3101->1411|3129->1412|3220->1475|3249->1476|3447->1647|3475->1648|3565->1710|3594->1711|3708->1797|3737->1798|3852->1885|3881->1886|3931->1908|3960->1909|4029->1951|4057->1952|4091->1958|4120->1959|4203->2015|4231->2016|4263->2021|4291->2022|4324->2028|4352->2029|4399->2049|4427->2050|4489->2084|4518->2085|4596->2135|4625->2136|4803->2286|4832->2287|4891->2318|4920->2319|4991->2363|5019->2364|5056->2374|5084->2375|5148->2411|5177->2412|5256->2464|5284->2465|5317->2471|5345->2472|5438->2537|5467->2538|5559->2603|5587->2604|5670->2658|5700->2659|5855->2785|5885->2786|5960->2832|5990->2833|6131->2946|6160->2947|6239->2997|6269->2998|6404->3105|6433->3106|6468->3112|6498->3113|6575->3162|6604->3163|6637->3168|6666->3169|6718->3193|6747->3194|6819->3238|6848->3239|6933->3295|6963->3296|7104->3408|7134->3409|7202->3449|7231->3450|7281->3472|7310->3473|7342->3477|7371->3478
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|53->25|53->25|53->25|55->27|59->31|59->31|59->31|60->32|60->32|60->32|61->33|66->38|66->38|66->38|71->43|71->43|78->50|78->50|82->54|82->54|84->56|84->56|89->61|89->61|91->63|91->63|93->65|93->65|96->68|96->68|97->69|97->69|99->71|99->71|99->71|99->71|101->73|101->73|102->74|102->74|103->75|103->75|105->77|105->77|107->79|107->79|108->80|108->80|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|119->91|119->91|121->93|121->93|122->94|122->94|124->96|124->96|127->99|127->99|129->101|129->101|132->104|132->104|133->105|133->105|136->108|136->108|136->108|136->108|139->111|139->111|139->111|139->111|141->113|141->113|142->114|142->114|144->116|144->116|148->120|148->120|151->123|151->123|154->126|154->126|156->128|156->128|158->130|158->130|159->131|159->131
                    -- GENERATED --
                */
            