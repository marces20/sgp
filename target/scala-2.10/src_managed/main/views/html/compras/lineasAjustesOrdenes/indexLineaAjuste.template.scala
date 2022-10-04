
package views.html.compras.lineasAjustesOrdenes

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
object indexLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[OrdenLineaAjuste],Boolean,Orden,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[OrdenLineaAjuste], editable: Boolean,orden:Orden):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._


Seq[Any](format.raw/*1.92*/("""
"""),format.raw/*4.1*/("""<div id="listaLineaAjustes" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Ajustes por Productos</b>
	"""),_display_(Seq[Any](/*8.3*/if(Permiso.check("ordenesAgregarLineaAjuste"))/*8.49*/ {_display_(Seq[Any](format.raw/*8.51*/("""
		"""),_display_(Seq[Any](/*9.4*/if(orden != null && (orden.estado_id == 11) && editable)/*9.60*/{_display_(Seq[Any](format.raw/*9.61*/("""
		<a class="btn btn-default btn-xs" href="#" id="nuevoAjuste"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
		""")))})),format.raw/*11.4*/("""
	""")))})),format.raw/*12.3*/("""
</p>

"""),_display_(Seq[Any](/*15.2*/if(paginador.getTotalRowCount() <= 0)/*15.39*/{_display_(Seq[Any](format.raw/*15.40*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> No existen lineas de productos para esta orden.</p>
""")))})),format.raw/*17.2*/("""


"""),_display_(Seq[Any](/*20.2*/if(paginador.getTotalRowCount() > 0)/*20.38*/ {_display_(Seq[Any](format.raw/*20.40*/("""
	Mostrando """),_display_(Seq[Any](/*21.13*/paginador/*21.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*21.54*/(""" resultado(s).
""")))})),format.raw/*22.2*/("""


<table id="listaDeAjustes" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th class="accion-editar">#</th>
			<th >Fecha</th>
			<th >Usuario</th>
			<th >Producto</th>
			<th >Cuenta Analitica</th>
			<th>UDM</th>
			<th >Cantidad</th>
			<th>Precio</th>
			<th>Subtotal</th>
			<th>Nota</th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*41.3*/for(linea <- paginador.getList) yield /*41.34*/ {_display_(Seq[Any](format.raw/*41.36*/("""
		"""),_display_(Seq[Any](/*42.4*/views/*42.9*/.html.compras.lineasAjustesOrdenes.lineaAjuste(linea, editable))),format.raw/*42.72*/("""
	""")))})),format.raw/*43.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*48.6*/views/*48.11*/.html.helpers.paginador(paginador, controllers.compras.routes.OrdenesLineasAjustesController.index()))),format.raw/*48.112*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaAjustes");

	contenedor.on('click', '#nuevoAjuste', function()"""),format.raw/*60.51*/("""{"""),format.raw/*60.52*/("""
		urlContenidoModal = '/compras/orden/linea-orden-ajuste/crear?ordenId='+$('#ordenId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*64.2*/("""}"""),format.raw/*64.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*66.57*/("""{"""),format.raw/*66.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/(""");
	
	contenedor.on('click', '.eliminarAjuste', function()"""),format.raw/*73.54*/("""{"""),format.raw/*73.55*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*76.28*/("""{"""),format.raw/*76.29*/("""
			if(data.success)"""),format.raw/*77.20*/("""{"""),format.raw/*77.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/(""" else """),format.raw/*79.11*/("""{"""),format.raw/*79.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*81.4*/("""}"""),format.raw/*81.5*/("""
		"""),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");
		return false;
	"""),format.raw/*84.2*/("""}"""),format.raw/*84.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*86.28*/("""{"""),format.raw/*86.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*87.49*/("""{"""),format.raw/*87.50*/("""
			resizable: false,
		    title: "Cargar Ajuste por Producto",
		    height: 500,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*93.35*/("""{"""),format.raw/*93.36*/("""
				$.get(url, function(data)"""),format.raw/*94.30*/("""{"""),format.raw/*94.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*96.5*/("""}"""),format.raw/*96.6*/(""");
		    """),format.raw/*97.7*/("""}"""),format.raw/*97.8*/(""",
		    close: function(event, ui )"""),format.raw/*98.34*/("""{"""),format.raw/*98.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*100.4*/("""}"""),format.raw/*100.5*/("""
		  """),format.raw/*101.5*/("""}"""),format.raw/*101.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*103.58*/("""{"""),format.raw/*103.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*106.3*/("""}"""),format.raw/*106.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*108.47*/("""{"""),format.raw/*108.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			
			$("#btn-guardar-linea-ajuste-orden").attr("disabled", true);
			$.post(href, data, function(resultado)"""),format.raw/*113.42*/("""{"""),format.raw/*113.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*114.45*/("""{"""),format.raw/*114.46*/("""
					$('#listaDeAjustes tbody').prepend(resultado.html);
					
					$('.successAddLineaAjuste').html(resultado.message)
					$('.successAddLineaAjuste').show();
					
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*121.56*/("""{"""),format.raw/*121.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""" else """),format.raw/*124.12*/("""{"""),format.raw/*124.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*126.5*/("""}"""),format.raw/*126.6*/(""" 
				$("#btn-guardar-linea-ajuste-orden").attr("disabled", false);
			"""),format.raw/*128.4*/("""}"""),format.raw/*128.5*/(""");
			return false;
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*134.2*/("""}"""),format.raw/*134.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*137.49*/("""{"""),format.raw/*137.50*/("""
		 
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*141.38*/("""{"""),format.raw/*141.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*143.3*/("""}"""),format.raw/*143.4*/(""");
		return false;
	"""),format.raw/*145.2*/("""}"""),format.raw/*145.3*/(""");
"""),format.raw/*146.1*/("""}"""),format.raw/*146.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[OrdenLineaAjuste],editable:Boolean,orden:Orden): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,orden)
    
    def f:((utils.pagination.Pagination[OrdenLineaAjuste],Boolean,Orden) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,orden) => apply(paginador,editable,orden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasAjustesOrdenes/indexLineaAjuste.scala.html
                    HASH: b030f0325990342f28f1f4d7beebeb44e476fa1e
                    MATRIX: 867->1|1091->91|1119->134|1265->246|1319->292|1358->294|1397->299|1461->355|1499->356|1652->478|1687->482|1733->493|1779->530|1818->531|1955->637|1997->644|2042->680|2082->682|2132->696|2150->705|2204->737|2252->754|2648->1115|2695->1146|2735->1148|2775->1153|2788->1158|2873->1221|2908->1225|3010->1292|3024->1297|3148->1398|3219->1441|3248->1442|3442->1608|3471->1609|3649->1760|3677->1761|3768->1824|3797->1825|3995->1996|4023->1997|4111->2057|4140->2058|4252->2142|4281->2143|4330->2164|4359->2165|4426->2205|4454->2206|4488->2212|4517->2213|4598->2267|4626->2268|4657->2272|4685->2273|4734->2295|4762->2296|4824->2330|4853->2331|4931->2381|4960->2382|5149->2543|5178->2544|5237->2575|5266->2576|5337->2620|5365->2621|5402->2631|5430->2632|5494->2668|5523->2669|5603->2721|5632->2722|5666->2728|5695->2729|5789->2794|5819->2795|5912->2860|5941->2861|6024->2915|6054->2916|6279->3112|6309->3113|6384->3159|6414->3160|6667->3385|6696->3386|6775->3436|6805->3437|6940->3544|6969->3545|7004->3551|7034->3552|7111->3601|7140->3602|7241->3675|7270->3676|7322->3700|7351->3701|7423->3745|7452->3746|7537->3802|7567->3803|7713->3920|7743->3921|7811->3961|7840->3962|7890->3984|7919->3985|7951->3989|7980->3990
                    LINES: 26->1|32->1|33->4|37->8|37->8|37->8|38->9|38->9|38->9|40->11|41->12|44->15|44->15|44->15|46->17|49->20|49->20|49->20|50->21|50->21|50->21|51->22|70->41|70->41|70->41|71->42|71->42|71->42|72->43|77->48|77->48|77->48|82->53|82->53|89->60|89->60|93->64|93->64|95->66|95->66|100->71|100->71|102->73|102->73|105->76|105->76|106->77|106->77|108->79|108->79|108->79|108->79|110->81|110->81|111->82|111->82|113->84|113->84|115->86|115->86|116->87|116->87|122->93|122->93|123->94|123->94|125->96|125->96|126->97|126->97|127->98|127->98|129->100|129->100|130->101|130->101|132->103|132->103|135->106|135->106|137->108|137->108|142->113|142->113|143->114|143->114|150->121|150->121|150->121|150->121|153->124|153->124|153->124|153->124|155->126|155->126|157->128|157->128|159->130|159->130|163->134|163->134|166->137|166->137|170->141|170->141|172->143|172->143|174->145|174->145|175->146|175->146
                    -- GENERATED --
                */
            