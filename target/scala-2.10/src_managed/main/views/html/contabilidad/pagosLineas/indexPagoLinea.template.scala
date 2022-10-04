
package views.html.contabilidad.pagosLineas

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
object indexPagoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[PagoLinea],Boolean,Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[PagoLinea], editable: Boolean,pago: Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.84*/("""
<div id="listaLineaPagos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Pagos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable && pago.estado_id == models.Estado.PAGO_ESTADO_BORRADOR)/*6.71*/{_display_(Seq[Any](format.raw/*6.72*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoPago"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDePagos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable && pago.estado_id == models.Estado.PAGO_ESTADO_BORRADOR)/*14.73*/{_display_(Seq[Any](format.raw/*14.74*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Contraparte</th> 
			<th>Cuenta</th>
			<th>Cuenta Analitica</th>
			<th>Periodo</th>
			<th>Fecha Pago</th>
			<!-- <th>Importe Original</th> -->
			<th>Importe Debito</th>
			<th>Importe Credito</th>
			"""),_display_(Seq[Any](/*25.5*/if(editable && pago.estado_id == models.Estado.PAGO_ESTADO_BORRADOR)/*25.73*/{_display_(Seq[Any](format.raw/*25.74*/("""
				<th></th>
			""")))})),format.raw/*27.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*31.3*/for(linea <- paginador.getList) yield /*31.34*/ {_display_(Seq[Any](format.raw/*31.36*/("""
		"""),_display_(Seq[Any](/*32.4*/views/*32.9*/.html.contabilidad.pagosLineas.lineaPago(linea, editable,pago))),format.raw/*32.71*/("""
	""")))})),format.raw/*33.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*38.6*/views/*38.11*/.html.helpers.paginador(paginador, controllers.contabilidad.routes.PagosLineasController.index()))),format.raw/*38.108*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*43.14*/("""{"""),format.raw/*43.15*/("""
	/**
	 * Ventana de carga linea de  Pagos en pago
	 */
	 
	var contenedor = $("#listaLineaPagos");

	contenedor.on('click', '#nuevoPago', function()"""),format.raw/*50.49*/("""{"""),format.raw/*50.50*/("""
		urlContenidoModal = '/contabilidad/pago-linea/crear?pagoId='+$('#pagoId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*54.2*/("""}"""),format.raw/*54.3*/(""");
	
	contenedor.on('click', '.modificarPago', function()"""),format.raw/*56.53*/("""{"""),format.raw/*56.54*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar pago');	
		return false;
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.on('click', '.eliminarPago', function()"""),format.raw/*63.52*/("""{"""),format.raw/*63.53*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*66.28*/("""{"""),format.raw/*66.29*/("""
			if(data.success)"""),format.raw/*67.20*/("""{"""),format.raw/*67.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*69.4*/("""}"""),format.raw/*69.5*/(""" else """),format.raw/*69.11*/("""{"""),format.raw/*69.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*71.4*/("""}"""),format.raw/*71.5*/("""
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""");
		return false;
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*76.28*/("""{"""),format.raw/*76.29*/("""
		modalCargaPagos = $('<div></div>').dialog("""),format.raw/*77.45*/("""{"""),format.raw/*77.46*/("""
			resizable: false,
		    title: "Cargar pago",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*83.35*/("""{"""),format.raw/*83.36*/("""
				$.get(url, function(data)"""),format.raw/*84.30*/("""{"""),format.raw/*84.31*/("""
					modalCargaPagos.html(data);
				"""),format.raw/*86.5*/("""}"""),format.raw/*86.6*/(""");
		    """),format.raw/*87.7*/("""}"""),format.raw/*87.8*/(""",
		    close: function(event, ui )"""),format.raw/*88.34*/("""{"""),format.raw/*88.35*/("""
		    	modalCargaPagos.dialog('destroy');
			"""),format.raw/*90.4*/("""}"""),format.raw/*90.5*/("""
		  """),format.raw/*91.5*/("""}"""),format.raw/*91.6*/(""");
		
		modalCargaPagos.on('click', '.cancelar', function()"""),format.raw/*93.54*/("""{"""),format.raw/*93.55*/("""
			modalCargaPagos.dialog('destroy');
			return false;
		"""),format.raw/*96.3*/("""}"""),format.raw/*96.4*/(""");
		
		modalCargaPagos.on('submit', function(e)"""),format.raw/*98.43*/("""{"""),format.raw/*98.44*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*101.42*/("""{"""),format.raw/*101.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*102.45*/("""{"""),format.raw/*102.46*/("""
					$('#listaDePagos tbody').prepend(resultado.html);
					modalCargaPagos.dialog( "destroy" );
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*105.56*/("""{"""),format.raw/*105.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaPagos.dialog( "destroy" );
				"""),format.raw/*108.5*/("""}"""),format.raw/*108.6*/(""" else """),format.raw/*108.12*/("""{"""),format.raw/*108.13*/("""
					modalCargaPagos.html(resultado);
				"""),format.raw/*110.5*/("""}"""),format.raw/*110.6*/("""
			"""),format.raw/*111.4*/("""}"""),format.raw/*111.5*/(""");
			return false;
		"""),format.raw/*113.3*/("""}"""),format.raw/*113.4*/(""");
		
		
		return modalCargaPagos;
	"""),format.raw/*117.2*/("""}"""),format.raw/*117.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*120.49*/("""{"""),format.raw/*120.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*123.38*/("""{"""),format.raw/*123.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*125.3*/("""}"""),format.raw/*125.4*/(""");
		return false;
	"""),format.raw/*127.2*/("""}"""),format.raw/*127.3*/(""");
"""),format.raw/*128.1*/("""}"""),format.raw/*128.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[PagoLinea],editable:Boolean,pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,pago)
    
    def f:((utils.pagination.Pagination[PagoLinea],Boolean,Pago) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,pago) => apply(paginador,editable,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagosLineas/indexPagoLinea.scala.html
                    HASH: ab7e54dec78f09580970764790a33b1f77795db0
                    MATRIX: 853->1|1029->83|1159->179|1235->247|1273->248|1421->366|1558->468|1635->536|1674->537|1749->581|2007->804|2084->872|2123->873|2175->894|2244->928|2291->959|2331->961|2371->966|2384->971|2468->1033|2503->1037|2605->1104|2619->1109|2739->1206|2810->1249|2839->1250|3023->1406|3052->1407|3219->1547|3247->1548|3334->1607|3363->1608|3557->1775|3585->1776|3671->1834|3700->1835|3812->1919|3841->1920|3890->1941|3919->1942|3986->1982|4014->1983|4048->1989|4077->1990|4158->2044|4186->2045|4217->2049|4245->2050|4294->2072|4322->2073|4384->2107|4413->2108|4487->2154|4516->2155|4690->2301|4719->2302|4778->2333|4807->2334|4874->2374|4902->2375|4939->2385|4967->2386|5031->2422|5060->2423|5135->2471|5163->2472|5196->2478|5224->2479|5313->2540|5342->2541|5430->2602|5458->2603|5536->2653|5565->2654|5720->2780|5750->2781|5825->2827|5855->2828|5988->2933|6017->2934|6096->2984|6126->2985|6257->3088|6286->3089|6321->3095|6351->3096|6424->3141|6453->3142|6486->3147|6515->3148|6567->3172|6596->3173|6664->3213|6693->3214|6778->3270|6808->3271|6949->3383|6979->3384|7047->3424|7076->3425|7126->3447|7155->3448|7187->3452|7216->3453
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|53->25|53->25|53->25|55->27|59->31|59->31|59->31|60->32|60->32|60->32|61->33|66->38|66->38|66->38|71->43|71->43|78->50|78->50|82->54|82->54|84->56|84->56|89->61|89->61|91->63|91->63|94->66|94->66|95->67|95->67|97->69|97->69|97->69|97->69|99->71|99->71|100->72|100->72|102->74|102->74|104->76|104->76|105->77|105->77|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|116->88|116->88|118->90|118->90|119->91|119->91|121->93|121->93|124->96|124->96|126->98|126->98|129->101|129->101|130->102|130->102|133->105|133->105|133->105|133->105|136->108|136->108|136->108|136->108|138->110|138->110|139->111|139->111|141->113|141->113|145->117|145->117|148->120|148->120|151->123|151->123|153->125|153->125|155->127|155->127|156->128|156->128
                    -- GENERATED --
                */
            