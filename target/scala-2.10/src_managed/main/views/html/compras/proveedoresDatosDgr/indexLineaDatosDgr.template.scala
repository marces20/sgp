
package views.html.compras.proveedoresDatosDgr

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
object indexLineaDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ProveedorDatoDgr],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[ProveedorDatoDgr], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.80*/("""
<div id="listaLineaDatoDgr" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Datos DGR</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoDatoDgr"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

"""),_display_(Seq[Any](/*11.2*/if(paginador.getTotalRowCount() <= 0)/*11.39*/{_display_(Seq[Any](format.raw/*11.40*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> No existen datos DGR para este proveedor.</p>
""")))})),format.raw/*13.2*/("""


"""),_display_(Seq[Any](/*16.2*/if(paginador.getTotalRowCount() > 0)/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
	Mostrando """),_display_(Seq[Any](/*17.13*/paginador/*17.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*17.54*/(""" resultado(s).
""")))})),format.raw/*18.2*/("""

<table id="listaDeDatoDgr" class="table table-striped table-bordered">
	<thead>
		<tr>
			
			 
			
			<th>Periodo</th>
			<th>Regimen</th>
			<th>CUIT</th>
			<th>Razon Social</th>
			<th>Alicuota</th>
			<th>Motivo</th>
			<th>Tipo Contribuyente</th>
			<th>Tipo Documento</th>
			<th>N° Documento</th>
			<th>Fecha Creacion</th>
			<th></th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*40.3*/for(linea <- paginador.getList) yield /*40.34*/ {_display_(Seq[Any](format.raw/*40.36*/("""
		"""),_display_(Seq[Any](/*41.4*/views/*41.9*/.html.compras.proveedoresDatosDgr.lineaDatosDgr(linea, editable))),format.raw/*41.73*/("""
	""")))})),format.raw/*42.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*47.6*/views/*47.11*/.html.helpers.paginador(paginador, controllers.compras.routes.ProveedorDatosDgrController.index()))),format.raw/*47.109*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*52.14*/("""{"""),format.raw/*52.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaDatoDgr");

	contenedor.on('click', '#nuevoDatoDgr', function()"""),format.raw/*59.52*/("""{"""),format.raw/*59.53*/("""
		urlContenidoModal = '/compras/linea-proveedor-datodgr/crear?cuit='+$('#cuit').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*63.2*/("""}"""),format.raw/*63.3*/(""");
	
	contenedor.on('click', '.modificarDatoDgr', function()"""),format.raw/*65.56*/("""{"""),format.raw/*65.57*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Datos Dgr');	
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	contenedor.on('click', '.eliminarDatoDgr', function()"""),format.raw/*72.55*/("""{"""),format.raw/*72.56*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*75.28*/("""{"""),format.raw/*75.29*/("""
			if(data.success)"""),format.raw/*76.20*/("""{"""),format.raw/*76.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*78.4*/("""}"""),format.raw/*78.5*/(""" else """),format.raw/*78.11*/("""{"""),format.raw/*78.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*80.4*/("""}"""),format.raw/*80.5*/("""
		"""),format.raw/*81.3*/("""}"""),format.raw/*81.4*/(""");
		return false;
	"""),format.raw/*83.2*/("""}"""),format.raw/*83.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*85.28*/("""{"""),format.raw/*85.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*86.49*/("""{"""),format.raw/*86.50*/("""
			resizable: false,
		    title: "Cargar Datos Dgr",
		    height: 500,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""
				$.get(url, function(data)"""),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
		    """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""",
		    close: function(event, ui )"""),format.raw/*97.34*/("""{"""),format.raw/*97.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*99.4*/("""}"""),format.raw/*99.5*/("""
		  """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*102.58*/("""{"""),format.raw/*102.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*107.47*/("""{"""),format.raw/*107.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*111.45*/("""{"""),format.raw/*111.46*/("""
					$('#listaDeDatoDgr tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*114.5*/("""}"""),format.raw/*114.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*114.56*/("""{"""),format.raw/*114.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else """),format.raw/*117.12*/("""{"""),format.raw/*117.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/("""
			"""),format.raw/*120.4*/("""}"""),format.raw/*120.5*/(""");
			return false;
		"""),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*126.2*/("""}"""),format.raw/*126.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*129.49*/("""{"""),format.raw/*129.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*132.38*/("""{"""),format.raw/*132.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*134.3*/("""}"""),format.raw/*134.4*/(""");
		return false;
	"""),format.raw/*136.2*/("""}"""),format.raw/*136.3*/(""");
"""),format.raw/*137.1*/("""}"""),format.raw/*137.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[ProveedorDatoDgr],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[ProveedorDatoDgr],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresDatosDgr/indexLineaDatosDgr.scala.html
                    HASH: 3e0763e3f33e11b1b3631bb81456273035af8f5b
                    MATRIX: 862->1|1034->79|1170->181|1190->193|1228->194|1379->315|1425->326|1471->363|1510->364|1641->464|1683->471|1728->507|1768->509|1818->523|1836->532|1890->564|1938->581|2371->979|2418->1010|2458->1012|2498->1017|2511->1022|2597->1086|2632->1090|2734->1157|2748->1162|2869->1260|2940->1303|2969->1304|3164->1471|3193->1472|3364->1616|3392->1617|3482->1679|3511->1680|3710->1852|3738->1853|3827->1914|3856->1915|3968->1999|3997->2000|4046->2021|4075->2022|4142->2062|4170->2063|4204->2069|4233->2070|4314->2124|4342->2125|4373->2129|4401->2130|4450->2152|4478->2153|4540->2187|4569->2188|4647->2238|4676->2239|4855->2390|4884->2391|4943->2422|4972->2423|5043->2467|5071->2468|5108->2478|5136->2479|5200->2515|5229->2516|5308->2568|5336->2569|5370->2575|5399->2576|5493->2641|5523->2642|5616->2707|5645->2708|5728->2762|5758->2763|5913->2889|5943->2890|6018->2936|6048->2937|6187->3048|6216->3049|6295->3099|6325->3100|6460->3207|6489->3208|6524->3214|6554->3215|6631->3264|6660->3265|6693->3270|6722->3271|6774->3295|6803->3296|6875->3340|6904->3341|6989->3397|7019->3398|7160->3510|7190->3511|7258->3551|7287->3552|7337->3574|7366->3575|7398->3579|7427->3580
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|39->11|39->11|39->11|41->13|44->16|44->16|44->16|45->17|45->17|45->17|46->18|68->40|68->40|68->40|69->41|69->41|69->41|70->42|75->47|75->47|75->47|80->52|80->52|87->59|87->59|91->63|91->63|93->65|93->65|98->70|98->70|100->72|100->72|103->75|103->75|104->76|104->76|106->78|106->78|106->78|106->78|108->80|108->80|109->81|109->81|111->83|111->83|113->85|113->85|114->86|114->86|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|130->102|130->102|133->105|133->105|135->107|135->107|138->110|138->110|139->111|139->111|142->114|142->114|142->114|142->114|145->117|145->117|145->117|145->117|147->119|147->119|148->120|148->120|150->122|150->122|154->126|154->126|157->129|157->129|160->132|160->132|162->134|162->134|164->136|164->136|165->137|165->137
                    -- GENERATED --
                */
            