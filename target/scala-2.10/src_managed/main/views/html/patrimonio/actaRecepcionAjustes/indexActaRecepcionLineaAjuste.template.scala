
package views.html.patrimonio.actaRecepcionAjustes

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
object indexActaRecepcionLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ActaRecepcionLineaAjuste],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[ActaRecepcionLineaAjuste], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.88*/("""
<div id="listaLineaLineaAjuste" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Ajustes</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
		<a class="btn btn-default btn-xs" href="#" id="nuevoLineaAjuste"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDeLineaAjuste" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Producto</th>
			<th>Cuenta</th>
			<th>UDM</th>
			<th>Cantidad</th>	
			<th>Precio</th>	
			<th>Total</th>		
			"""),_display_(Seq[Any](/*23.5*/if(editable)/*23.17*/{_display_(Seq[Any](format.raw/*23.18*/("""
				<th></th>
			""")))})),format.raw/*25.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*29.3*/for(linea <- paginador.getList) yield /*29.34*/ {_display_(Seq[Any](format.raw/*29.36*/("""
		"""),_display_(Seq[Any](/*30.4*/views/*30.9*/.html.patrimonio.actaRecepcionAjustes.lineaActaRecepcionLineaAjuste(linea, editable))),format.raw/*30.93*/("""
	""")))})),format.raw/*31.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*36.6*/views/*36.11*/.html.helpers.paginador(paginador, controllers.patrimonio.routes.ActaRecepcionLineaAjusteController.index()))),format.raw/*36.119*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*41.14*/("""{"""),format.raw/*41.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaLineaAjuste");

	contenedor.on('click', '#nuevoLineaAjuste', function()"""),format.raw/*48.56*/("""{"""),format.raw/*48.57*/("""
		urlContenidoModal = '/patrimonio/acta-linea-ajuste/crear?actaId='+$('#acta_id').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*52.2*/("""}"""),format.raw/*52.3*/(""");
	
	contenedor.on('click', '.modificarLineaAjuste', function()"""),format.raw/*54.60*/("""{"""),format.raw/*54.61*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Linea Ajuste');	
		return false;
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/(""");
	
	contenedor.on('click', '.eliminarLineaAjuste', function()"""),format.raw/*61.59*/("""{"""),format.raw/*61.60*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*64.28*/("""{"""),format.raw/*64.29*/("""
			if(data.success)"""),format.raw/*65.20*/("""{"""),format.raw/*65.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*67.4*/("""}"""),format.raw/*67.5*/(""" else """),format.raw/*67.11*/("""{"""),format.raw/*67.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*69.4*/("""}"""),format.raw/*69.5*/("""
		"""),format.raw/*70.3*/("""}"""),format.raw/*70.4*/(""");
		return false;
	"""),format.raw/*72.2*/("""}"""),format.raw/*72.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*74.28*/("""{"""),format.raw/*74.29*/("""
		
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*76.49*/("""{"""),format.raw/*76.50*/("""
			resizable: false,
		    title: "Cargar Linea Ajuste",
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
			$("#btn-guardar-linea-ajuste-acta").attr("disabled", true);
			$.post(href, data, function(resultado)"""),format.raw/*101.42*/("""{"""),format.raw/*101.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*102.45*/("""{"""),format.raw/*102.46*/("""
					$('#listaDeLineaAjuste tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*105.56*/("""{"""),format.raw/*105.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*108.5*/("""}"""),format.raw/*108.6*/(""" else """),format.raw/*108.12*/("""{"""),format.raw/*108.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*110.5*/("""}"""),format.raw/*110.6*/("""
				$("#btn-guardar-linea-ajuste-acta").attr("disabled", false);
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
    
    def render(paginador:utils.pagination.Pagination[ActaRecepcionLineaAjuste],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[ActaRecepcionLineaAjuste],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/indexActaRecepcionLineaAjuste.scala.html
                    HASH: dc79fcd43d59310efa077dc3e7941eaa813f3748
                    MATRIX: 885->1|1065->87|1203->191|1223->203|1261->204|1417->330|1560->438|1581->450|1620->451|1695->495|1860->625|1881->637|1920->638|1972->659|2041->693|2088->724|2128->726|2168->731|2181->736|2287->820|2322->824|2426->893|2440->898|2571->1006|2642->1049|2671->1050|2874->1225|2903->1226|3076->1372|3104->1373|3198->1439|3227->1440|3429->1615|3457->1616|3550->1681|3579->1682|3691->1766|3720->1767|3769->1788|3798->1789|3865->1829|3893->1830|3927->1836|3956->1837|4037->1891|4065->1892|4096->1896|4124->1897|4173->1919|4201->1920|4263->1954|4292->1955|4374->2009|4403->2010|4585->2164|4614->2165|4673->2196|4702->2197|4773->2241|4801->2242|4838->2252|4866->2253|4930->2289|4959->2290|5038->2342|5066->2343|5099->2349|5127->2350|5220->2415|5249->2416|5341->2481|5369->2482|5451->2536|5480->2537|5699->2727|5729->2728|5804->2774|5834->2775|5977->2890|6006->2891|6085->2941|6115->2942|6250->3049|6279->3050|6314->3056|6344->3057|6421->3106|6450->3107|6549->3178|6578->3179|6630->3203|6659->3204|6731->3248|6760->3249|6845->3305|6875->3306|7016->3418|7046->3419|7114->3459|7143->3460|7193->3482|7222->3483|7254->3487|7283->3488
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|51->23|51->23|51->23|53->25|57->29|57->29|57->29|58->30|58->30|58->30|59->31|64->36|64->36|64->36|69->41|69->41|76->48|76->48|80->52|80->52|82->54|82->54|87->59|87->59|89->61|89->61|92->64|92->64|93->65|93->65|95->67|95->67|95->67|95->67|97->69|97->69|98->70|98->70|100->72|100->72|102->74|102->74|104->76|104->76|110->82|110->82|111->83|111->83|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|123->95|123->95|125->97|125->97|129->101|129->101|130->102|130->102|133->105|133->105|133->105|133->105|136->108|136->108|136->108|136->108|138->110|138->110|140->112|140->112|142->114|142->114|146->118|146->118|149->121|149->121|152->124|152->124|154->126|154->126|156->128|156->128|157->129|157->129
                    -- GENERATED --
                */
            