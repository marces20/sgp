
package views.html.patrimonio.lineasCertificaciones

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
object indexCertificacionLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CertificacionServicioLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[CertificacionServicioLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.90*/("""
<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Servicios</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<!-- <a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>-->	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Producto</th>
			<th>Cuenta Analitica</th>
			<th>Cantidad</th>
			<th>UDM</th>
			<th>Precio</th>
			<th>Descuento (%)</th>
			<th>Subtotal desc.</th>
			<th>Subtotal</th>
			<th>Pacientes</th>
			"""),_display_(Seq[Any](/*26.5*/if(editable)/*26.17*/{_display_(Seq[Any](format.raw/*26.18*/("""
				<th></th>
			""")))})),format.raw/*28.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*32.3*/for(linea <- paginador.getList) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
		"""),_display_(Seq[Any](/*33.4*/views/*33.9*/.html.patrimonio.lineasCertificaciones.lineaProducto(linea, editable))),format.raw/*33.78*/("""
	""")))})),format.raw/*34.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*39.6*/views/*39.11*/.html.helpers.paginador(paginador, controllers.patrimonio.routes.LineasCertificacionesController.index()))),format.raw/*39.116*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*51.53*/("""{"""),format.raw/*51.54*/("""
		urlContenidoModal = '/patrimonio/certificacion-linea/crear?certificacionId='+$('#certificacionId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*55.2*/("""}"""),format.raw/*55.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*57.57*/("""{"""),format.raw/*57.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*64.56*/("""{"""),format.raw/*64.57*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*67.28*/("""{"""),format.raw/*67.29*/("""
			if(data.success)"""),format.raw/*68.20*/("""{"""),format.raw/*68.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*70.4*/("""}"""),format.raw/*70.5*/(""" else """),format.raw/*70.11*/("""{"""),format.raw/*70.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*72.4*/("""}"""),format.raw/*72.5*/("""
		"""),format.raw/*73.3*/("""}"""),format.raw/*73.4*/(""");
		return false;
	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*77.28*/("""{"""),format.raw/*77.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*78.49*/("""{"""),format.raw/*78.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*84.35*/("""{"""),format.raw/*84.36*/("""
				$.get(url, function(data)"""),format.raw/*85.30*/("""{"""),format.raw/*85.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*87.5*/("""}"""),format.raw/*87.6*/(""");
		    """),format.raw/*88.7*/("""}"""),format.raw/*88.8*/(""",
		    close: function(event, ui )"""),format.raw/*89.34*/("""{"""),format.raw/*89.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*91.4*/("""}"""),format.raw/*91.5*/("""
		  """),format.raw/*92.5*/("""}"""),format.raw/*92.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*94.58*/("""{"""),format.raw/*94.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*97.3*/("""}"""),format.raw/*97.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*99.47*/("""{"""),format.raw/*99.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*102.42*/("""{"""),format.raw/*102.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*103.45*/("""{"""),format.raw/*103.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*106.5*/("""}"""),format.raw/*106.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*106.56*/("""{"""),format.raw/*106.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*109.5*/("""}"""),format.raw/*109.6*/(""" else """),format.raw/*109.12*/("""{"""),format.raw/*109.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*111.5*/("""}"""),format.raw/*111.6*/("""
			"""),format.raw/*112.4*/("""}"""),format.raw/*112.5*/(""");
			return false;
		"""),format.raw/*114.3*/("""}"""),format.raw/*114.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*118.2*/("""}"""),format.raw/*118.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*121.49*/("""{"""),format.raw/*121.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*124.38*/("""{"""),format.raw/*124.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*126.3*/("""}"""),format.raw/*126.4*/(""");
		return false;
	"""),format.raw/*128.2*/("""}"""),format.raw/*128.3*/(""");
"""),format.raw/*129.1*/("""}"""),format.raw/*129.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[CertificacionServicioLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[CertificacionServicioLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasCertificaciones/indexCertificacionLinea.scala.html
                    HASH: 0f89dcc04e9b8b335501cd50a61f25d2c33aabfb
                    MATRIX: 882->1|1064->89|1202->193|1222->205|1260->206|1420->336|1561->442|1582->454|1621->455|1696->499|1948->716|1969->728|2008->729|2060->750|2129->784|2176->815|2216->817|2256->822|2269->827|2360->896|2395->900|2499->969|2513->974|2641->1079|2712->1122|2741->1123|2939->1293|2968->1294|3160->1459|3188->1460|3279->1523|3308->1524|3506->1695|3534->1696|3624->1758|3653->1759|3765->1843|3794->1844|3843->1865|3872->1866|3939->1906|3967->1907|4001->1913|4030->1914|4111->1968|4139->1969|4170->1973|4198->1974|4247->1996|4275->1997|4337->2031|4366->2032|4444->2082|4473->2083|4651->2233|4680->2234|4739->2265|4768->2266|4839->2310|4867->2311|4904->2321|4932->2322|4996->2358|5025->2359|5104->2411|5132->2412|5165->2418|5193->2419|5286->2484|5315->2485|5407->2550|5435->2551|5517->2605|5546->2606|5701->2732|5731->2733|5806->2779|5836->2780|5977->2893|6006->2894|6085->2944|6115->2945|6250->3052|6279->3053|6314->3059|6344->3060|6421->3109|6450->3110|6483->3115|6512->3116|6564->3140|6593->3141|6665->3185|6694->3186|6779->3242|6809->3243|6950->3355|6980->3356|7048->3396|7077->3397|7127->3419|7156->3420|7188->3424|7217->3425
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|54->26|54->26|54->26|56->28|60->32|60->32|60->32|61->33|61->33|61->33|62->34|67->39|67->39|67->39|72->44|72->44|79->51|79->51|83->55|83->55|85->57|85->57|90->62|90->62|92->64|92->64|95->67|95->67|96->68|96->68|98->70|98->70|98->70|98->70|100->72|100->72|101->73|101->73|103->75|103->75|105->77|105->77|106->78|106->78|112->84|112->84|113->85|113->85|115->87|115->87|116->88|116->88|117->89|117->89|119->91|119->91|120->92|120->92|122->94|122->94|125->97|125->97|127->99|127->99|130->102|130->102|131->103|131->103|134->106|134->106|134->106|134->106|137->109|137->109|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114|146->118|146->118|149->121|149->121|152->124|152->124|154->126|154->126|156->128|156->128|157->129|157->129
                    -- GENERATED --
                */
            