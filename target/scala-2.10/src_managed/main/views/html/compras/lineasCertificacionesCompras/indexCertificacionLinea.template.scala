
package views.html.compras.lineasCertificacionesCompras

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
object indexCertificacionLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CertificacionCompraLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[CertificacionCompraLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.88*/("""
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
		"""),_display_(Seq[Any](/*32.4*/views/*32.9*/.html.compras.lineasCertificacionesCompras.lineaProducto(linea, editable))),format.raw/*32.82*/("""
	""")))})),format.raw/*33.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*38.6*/views/*38.11*/.html.helpers.paginador(paginador, controllers.compras.routes.CertificacionesComprasLineasController.index()))),format.raw/*38.120*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*43.14*/("""{"""),format.raw/*43.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*50.53*/("""{"""),format.raw/*50.54*/("""
		urlContenidoModal = '/compras/certificacion-compra-linea/crear?certificacionId='+$('#certificacionId').val();
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
    
    def render(paginador:utils.pagination.Pagination[CertificacionCompraLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[CertificacionCompraLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificacionesCompras/indexCertificacionLinea.scala.html
                    HASH: 1ea17bed4c90c006ead2f0b90eb6f8a0c4727426
                    MATRIX: 884->1|1064->87|1202->191|1222->203|1260->204|1412->326|1553->432|1574->444|1613->445|1688->489|1917->683|1938->695|1977->696|2029->717|2098->751|2145->782|2185->784|2225->789|2238->794|2333->867|2368->871|2472->940|2486->945|2618->1054|2689->1097|2718->1098|2916->1268|2945->1269|3141->1438|3169->1439|3260->1502|3289->1503|3487->1674|3515->1675|3605->1737|3634->1738|3748->1824|3777->1825|3892->1912|3921->1913|3971->1935|4000->1936|4069->1978|4097->1979|4131->1985|4160->1986|4243->2042|4271->2043|4303->2048|4331->2049|4364->2055|4392->2056|4439->2076|4467->2077|4529->2111|4558->2112|4636->2162|4665->2163|4843->2313|4872->2314|4931->2345|4960->2346|5031->2390|5059->2391|5096->2401|5124->2402|5188->2438|5217->2439|5296->2491|5324->2492|5357->2498|5385->2499|5478->2564|5507->2565|5599->2630|5627->2631|5710->2685|5740->2686|5895->2812|5925->2813|6000->2859|6030->2860|6171->2973|6200->2974|6279->3024|6309->3025|6444->3132|6473->3133|6508->3139|6538->3140|6615->3189|6644->3190|6677->3195|6706->3196|6758->3220|6787->3221|6859->3265|6888->3266|6973->3322|7003->3323|7144->3435|7174->3436|7242->3476|7271->3477|7321->3499|7350->3500|7382->3504|7411->3505
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|53->25|53->25|53->25|55->27|59->31|59->31|59->31|60->32|60->32|60->32|61->33|66->38|66->38|66->38|71->43|71->43|78->50|78->50|82->54|82->54|84->56|84->56|89->61|89->61|91->63|91->63|93->65|93->65|96->68|96->68|97->69|97->69|99->71|99->71|99->71|99->71|101->73|101->73|102->74|102->74|103->75|103->75|105->77|105->77|107->79|107->79|108->80|108->80|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|119->91|119->91|121->93|121->93|122->94|122->94|124->96|124->96|127->99|127->99|129->101|129->101|132->104|132->104|133->105|133->105|136->108|136->108|136->108|136->108|139->111|139->111|139->111|139->111|141->113|141->113|142->114|142->114|144->116|144->116|148->120|148->120|151->123|151->123|154->126|154->126|156->128|156->128|158->130|158->130|159->131|159->131
                    -- GENERATED --
                */
            