
package views.html.recupero.recuperoFacturaLineas

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
object indexRecuperoFacturaLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.RecuperoFacturaLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[models.recupero.RecuperoFacturaLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.100*/("""
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
		"""),_display_(Seq[Any](/*31.4*/views/*31.9*/.html.recupero.recuperoFacturaLineas.lineaProducto(linea, editable))),format.raw/*31.76*/("""
	""")))})),format.raw/*32.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*37.6*/views/*37.11*/.html.helpers.paginador(paginador, controllers.recupero.routes.RecuperoFacturaLineasController.index()))),format.raw/*37.114*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*42.14*/("""{"""),format.raw/*42.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*49.53*/("""{"""),format.raw/*49.54*/("""
		urlContenidoModal = '/recupero/factura-linea/crear?facturaId='+$('#recuperoFacturaId').val();
							
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
	
	
	function mostrarModal(url)"""),format.raw/*80.28*/("""{"""),format.raw/*80.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*81.49*/("""{"""),format.raw/*81.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*87.35*/("""{"""),format.raw/*87.36*/("""
				$.get(url, function(data)"""),format.raw/*88.30*/("""{"""),format.raw/*88.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*90.5*/("""}"""),format.raw/*90.6*/(""");
		    """),format.raw/*91.7*/("""}"""),format.raw/*91.8*/(""",
		    close: function(event, ui )"""),format.raw/*92.34*/("""{"""),format.raw/*92.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*94.4*/("""}"""),format.raw/*94.5*/("""
		  """),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*97.58*/("""{"""),format.raw/*97.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*100.3*/("""}"""),format.raw/*100.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*102.47*/("""{"""),format.raw/*102.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*105.42*/("""{"""),format.raw/*105.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*106.45*/("""{"""),format.raw/*106.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*109.5*/("""}"""),format.raw/*109.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*109.56*/("""{"""),format.raw/*109.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*112.5*/("""}"""),format.raw/*112.6*/(""" else """),format.raw/*112.12*/("""{"""),format.raw/*112.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*114.5*/("""}"""),format.raw/*114.6*/("""
			"""),format.raw/*115.4*/("""}"""),format.raw/*115.5*/(""");
			return false;
		"""),format.raw/*117.3*/("""}"""),format.raw/*117.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*121.2*/("""}"""),format.raw/*121.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*124.49*/("""{"""),format.raw/*124.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*127.38*/("""{"""),format.raw/*127.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*129.3*/("""}"""),format.raw/*129.4*/(""");
		return false;
	"""),format.raw/*131.2*/("""}"""),format.raw/*131.3*/(""");
"""),format.raw/*132.1*/("""}"""),format.raw/*132.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[models.recupero.RecuperoFacturaLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoFacturaLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFacturaLineas/indexRecuperoFacturaLinea.scala.html
                    HASH: 5ae8d0483e12001d391ae0b26950138735c8476c
                    MATRIX: 892->1|1085->99|1223->203|1243->215|1281->216|1433->338|1574->444|1595->456|1634->457|1709->501|1912->669|1933->681|1972->682|2024->703|2093->737|2140->768|2180->770|2220->775|2233->780|2322->847|2357->851|2461->920|2475->925|2601->1028|2672->1071|2701->1072|2899->1242|2928->1243|3117->1405|3145->1406|3236->1469|3265->1470|3463->1641|3491->1642|3581->1704|3610->1705|3724->1791|3753->1792|3868->1879|3897->1880|3947->1902|3976->1903|4045->1945|4073->1946|4107->1952|4136->1953|4219->2009|4247->2010|4279->2015|4307->2016|4340->2022|4368->2023|4415->2043|4443->2044|4508->2081|4537->2082|4615->2132|4644->2133|4822->2283|4851->2284|4910->2315|4939->2316|5010->2360|5038->2361|5075->2371|5103->2372|5167->2408|5196->2409|5275->2461|5303->2462|5336->2468|5364->2469|5457->2534|5486->2535|5579->2600|5608->2601|5691->2655|5721->2656|5876->2782|5906->2783|5981->2829|6011->2830|6152->2943|6181->2944|6260->2994|6290->2995|6425->3102|6454->3103|6489->3109|6519->3110|6596->3159|6625->3160|6658->3165|6687->3166|6739->3190|6768->3191|6840->3235|6869->3236|6954->3292|6984->3293|7125->3405|7155->3406|7223->3446|7252->3447|7302->3469|7331->3470|7363->3474|7392->3475
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|52->24|52->24|52->24|54->26|58->30|58->30|58->30|59->31|59->31|59->31|60->32|65->37|65->37|65->37|70->42|70->42|77->49|77->49|82->54|82->54|84->56|84->56|89->61|89->61|91->63|91->63|93->65|93->65|96->68|96->68|97->69|97->69|99->71|99->71|99->71|99->71|101->73|101->73|102->74|102->74|103->75|103->75|105->77|105->77|108->80|108->80|109->81|109->81|115->87|115->87|116->88|116->88|118->90|118->90|119->91|119->91|120->92|120->92|122->94|122->94|123->95|123->95|125->97|125->97|128->100|128->100|130->102|130->102|133->105|133->105|134->106|134->106|137->109|137->109|137->109|137->109|140->112|140->112|140->112|140->112|142->114|142->114|143->115|143->115|145->117|145->117|149->121|149->121|152->124|152->124|155->127|155->127|157->129|157->129|159->131|159->131|160->132|160->132
                    -- GENERATED --
                */
            