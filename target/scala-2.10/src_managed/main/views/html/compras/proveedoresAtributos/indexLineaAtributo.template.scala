
package views.html.compras.proveedoresAtributos

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
object indexLineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ProveedorAtributo],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[ProveedorAtributo], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.81*/("""
<div id="listaLineaAtributos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Atributos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoAtributo"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

"""),_display_(Seq[Any](/*11.2*/if(paginador.getTotalRowCount() <= 0)/*11.39*/{_display_(Seq[Any](format.raw/*11.40*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> No existen atributos para este proveedor.</p>
""")))})),format.raw/*13.2*/("""


"""),_display_(Seq[Any](/*16.2*/if(paginador.getTotalRowCount() > 0)/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
	Mostrando """),_display_(Seq[Any](/*17.13*/paginador/*17.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*17.54*/(""" resultado(s).
""")))})),format.raw/*18.2*/("""

<table id="listaDeAtributos" class="table table-striped table-bordered">
	<thead>
		<tr>
			
			 
			
			<th>Gcias</th>
			<th>Exento IVA</th>
			<th>AFIP Condicion</th>
			<th>Suss Tipo</th>
			<th>DGR Condicion</th>
			<th>Exento Sello</th>
			<!-- <th>Fecha Exto. DGR</th> -->
			<th>Fecha Exto. Afip Gcias</th>
			<th>Fecha Exto. Afip Suss</th>
			<th>Fecha Exto. DGR IIBB</th>
			<th>Fecha Exto. DGR Sellos</th>
			<th>Fecha Creacion</th>
			 
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*42.3*/for(linea <- paginador.getList) yield /*42.34*/ {_display_(Seq[Any](format.raw/*42.36*/("""
		"""),_display_(Seq[Any](/*43.4*/views/*43.9*/.html.compras.proveedoresAtributos.lineaAtributo(linea, editable))),format.raw/*43.74*/("""
	""")))})),format.raw/*44.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*49.6*/views/*49.11*/.html.helpers.paginador(paginador, controllers.compras.routes.ProveedorAtributosController.index()))),format.raw/*49.110*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaAtributos");

	contenedor.on('click', '#nuevoAtributo', function()"""),format.raw/*61.53*/("""{"""),format.raw/*61.54*/("""
		urlContenidoModal = '/compras/linea-proveedor-atributo/crear?proveedorId='+$('#proveedorId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/(""");
	
	contenedor.on('click', '.modificarAtributo', function()"""),format.raw/*67.57*/("""{"""),format.raw/*67.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar atributo');	
		return false;
	"""),format.raw/*72.2*/("""}"""),format.raw/*72.3*/(""");
	
	contenedor.on('click', '.eliminarAtributo', function()"""),format.raw/*74.56*/("""{"""),format.raw/*74.57*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*77.28*/("""{"""),format.raw/*77.29*/("""
			if(data.success)"""),format.raw/*78.20*/("""{"""),format.raw/*78.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*80.4*/("""}"""),format.raw/*80.5*/(""" else """),format.raw/*80.11*/("""{"""),format.raw/*80.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*82.4*/("""}"""),format.raw/*82.5*/("""
		"""),format.raw/*83.3*/("""}"""),format.raw/*83.4*/(""");
		return false;
	"""),format.raw/*85.2*/("""}"""),format.raw/*85.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*87.28*/("""{"""),format.raw/*87.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*88.49*/("""{"""),format.raw/*88.50*/("""
			resizable: false,
		    title: "Cargar atributo",
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
					$('#listaDeAtributos tbody').prepend(resultado.html);
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
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*134.38*/("""{"""),format.raw/*134.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*136.3*/("""}"""),format.raw/*136.4*/(""");
		return false;
	"""),format.raw/*138.2*/("""}"""),format.raw/*138.3*/(""");
"""),format.raw/*139.1*/("""}"""),format.raw/*139.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[ProveedorAtributo],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[ProveedorAtributo],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/indexLineaAtributo.scala.html
                    HASH: 061dc40797f574f8f1935dc4f58847cf2374525e
                    MATRIX: 864->1|1037->80|1175->184|1195->196|1233->197|1385->319|1431->330|1477->367|1516->368|1647->468|1689->475|1734->511|1774->513|1824->527|1842->536|1896->568|1944->585|2483->1089|2530->1120|2570->1122|2610->1127|2623->1132|2710->1197|2745->1201|2847->1268|2861->1273|2983->1372|3054->1415|3083->1416|3281->1586|3310->1587|3496->1746|3524->1747|3615->1810|3644->1811|3842->1982|3870->1983|3960->2045|3989->2046|4101->2130|4130->2131|4179->2152|4208->2153|4275->2193|4303->2194|4337->2200|4366->2201|4447->2255|4475->2256|4506->2260|4534->2261|4583->2283|4611->2284|4673->2318|4702->2319|4780->2369|4809->2370|4987->2520|5016->2521|5075->2552|5104->2553|5175->2597|5203->2598|5240->2608|5268->2609|5332->2645|5361->2646|5441->2698|5470->2699|5504->2705|5533->2706|5627->2771|5657->2772|5750->2837|5779->2838|5862->2892|5892->2893|6047->3019|6077->3020|6152->3066|6182->3067|6323->3180|6352->3181|6431->3231|6461->3232|6596->3339|6625->3340|6660->3346|6690->3347|6767->3396|6796->3397|6829->3402|6858->3403|6910->3427|6939->3428|7011->3472|7040->3473|7125->3529|7155->3530|7296->3642|7326->3643|7394->3683|7423->3684|7473->3706|7502->3707|7534->3711|7563->3712
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|39->11|39->11|39->11|41->13|44->16|44->16|44->16|45->17|45->17|45->17|46->18|70->42|70->42|70->42|71->43|71->43|71->43|72->44|77->49|77->49|77->49|82->54|82->54|89->61|89->61|93->65|93->65|95->67|95->67|100->72|100->72|102->74|102->74|105->77|105->77|106->78|106->78|108->80|108->80|108->80|108->80|110->82|110->82|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|122->94|122->94|123->95|123->95|125->97|125->97|126->98|126->98|127->99|127->99|129->101|129->101|130->102|130->102|132->104|132->104|135->107|135->107|137->109|137->109|140->112|140->112|141->113|141->113|144->116|144->116|144->116|144->116|147->119|147->119|147->119|147->119|149->121|149->121|150->122|150->122|152->124|152->124|156->128|156->128|159->131|159->131|162->134|162->134|164->136|164->136|166->138|166->138|167->139|167->139
                    -- GENERATED --
                */
            