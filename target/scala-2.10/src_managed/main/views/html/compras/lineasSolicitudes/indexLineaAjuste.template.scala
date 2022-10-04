
package views.html.compras.lineasSolicitudes

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
object indexLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[SolicitudLineaAjuste],Boolean,Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[SolicitudLineaAjuste], editable: Boolean, solicitud: Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import models.auth._


Seq[Any](format.raw/*1.106*/("""
"""),format.raw/*4.1*/("""<div id="listaLineaAjustes" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Ajustes</b>
	"""),_display_(Seq[Any](/*8.3*/if(Permiso.check("solicitudAgregaLineaAjuste"))/*8.50*/ {_display_(Seq[Any](format.raw/*8.52*/("""
		"""),_display_(Seq[Any](/*9.4*/if(solicitud != null && (solicitud.estado_id == 4 || solicitud.estado_id == 5))/*9.83*/{_display_(Seq[Any](format.raw/*9.84*/("""
		<a class="btn btn-default btn-xs" href="#" id="nuevoAjuste"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
		""")))})),format.raw/*11.4*/("""
	""")))})),format.raw/*12.3*/("""
</p>

"""),_display_(Seq[Any](/*15.2*/if(paginador.getTotalRowCount() <= 0)/*15.39*/{_display_(Seq[Any](format.raw/*15.40*/("""
	<p id="mensaje"><i class="glyphicon glyphicon-info-sign"></i> No existen ajustes en esta solicitud.<p>
""")))})),format.raw/*17.2*/("""

<table id="listaDeAjustes" class="table table-striped table-bordered """),_display_(Seq[Any](/*19.71*/if(paginador.getTotalRowCount() <= 0)/*19.108*/{_display_(Seq[Any](format.raw/*19.109*/("""hide""")))})),format.raw/*19.114*/("""">
	<thead>
		<tr>
			<th width="220">Codificación</th>
			<th>Nombre de cuenta analítica</th>
			<th>Producto</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Total</th>
			<th width="50">Observación</th>
			"""),_display_(Seq[Any](/*29.5*/if(editable)/*29.17*/{_display_(Seq[Any](format.raw/*29.18*/("""
				<!-- <th width="50"></th> -->
			""")))})),format.raw/*31.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*35.3*/for(linea <- paginador.getList) yield /*35.34*/ {_display_(Seq[Any](format.raw/*35.36*/("""
		"""),_display_(Seq[Any](/*36.4*/views/*36.9*/.html.compras.lineasSolicitudes.lineaAjuste(linea, editable,solicitud))),format.raw/*36.79*/("""
	""")))})),format.raw/*37.3*/("""
	</tbody>
</table>

Mostrando """),_display_(Seq[Any](/*41.12*/paginador/*41.21*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*41.53*/(""" resultado(s).
<div class="pagination pull-right">
    """),_display_(Seq[Any](/*43.6*/views/*43.11*/.html.helpers.paginador(paginador, controllers.compras.routes.AjustesSolicitudesController.index()))),format.raw/*43.110*/("""
</div>


</div>

<script>
$( function()"""),format.raw/*50.14*/("""{"""),format.raw/*50.15*/("""
	/**
	 * Ventana de carga linea de Ajuste en solicitudes
	 */
	 
	var contenedor = $("#listaLineaAjustes");

	contenedor.on('click', '#nuevoAjuste', function()"""),format.raw/*57.51*/("""{"""),format.raw/*57.52*/("""
		urlContenidoModal = '/compras/ajuste-solicitud/crear?solicitudId='+$('#solicitudId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.on('click', '.eliminarAjuste', function()"""),format.raw/*63.54*/("""{"""),format.raw/*63.55*/("""
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
		modalCargaAjustes = $('<div></div>').dialog("""),format.raw/*77.47*/("""{"""),format.raw/*77.48*/("""
			resizable: false,
		    title: "Cargar Ajuste",
		    height: 500,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*83.35*/("""{"""),format.raw/*83.36*/("""
				$.get(url, function(data)"""),format.raw/*84.30*/("""{"""),format.raw/*84.31*/("""
					modalCargaAjustes.html(data);
				"""),format.raw/*86.5*/("""}"""),format.raw/*86.6*/(""");
		    """),format.raw/*87.7*/("""}"""),format.raw/*87.8*/(""",
		    close: function(event, ui )"""),format.raw/*88.34*/("""{"""),format.raw/*88.35*/("""
		    	modalCargaAjustes.dialog('destroy');
			"""),format.raw/*90.4*/("""}"""),format.raw/*90.5*/("""
		  """),format.raw/*91.5*/("""}"""),format.raw/*91.6*/(""");
		
		modalCargaAjustes.on('click', '.cancelar', function()"""),format.raw/*93.56*/("""{"""),format.raw/*93.57*/("""
			modalCargaAjustes.dialog('destroy');
			return false;
		"""),format.raw/*96.3*/("""}"""),format.raw/*96.4*/(""");
		
		modalCargaAjustes.on('submit', function(e)"""),format.raw/*98.45*/("""{"""),format.raw/*98.46*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			
			$("#btn-guardar-linea-ajuste-solicitudes").attr("disabled", true);
			
			$.post(href, data, function(resultado)"""),format.raw/*104.42*/("""{"""),format.raw/*104.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*105.45*/("""{"""),format.raw/*105.46*/("""
					$('#listaDeAjustes').removeClass('hide');
					$('#mensaje').remove();
					$('#listaDeAjustes tbody').prepend(resultado.html);
					modalCargaAjustes.dialog( "destroy" );
				"""),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*110.56*/("""{"""),format.raw/*110.57*/("""
					$(resultado.html).insertAfter(lineaAjusteParaEditar);
					lineaAjusteParaEditar.remove();
					modalCargaAjustes.dialog( "destroy" );
				"""),format.raw/*114.5*/("""}"""),format.raw/*114.6*/(""" else """),format.raw/*114.12*/("""{"""),format.raw/*114.13*/("""
					modalCargaAjustes.html(resultado);
				"""),format.raw/*116.5*/("""}"""),format.raw/*116.6*/("""
				$("#btn-guardar-linea-ajuste-solicitudes").attr("disabled",false);
			"""),format.raw/*118.4*/("""}"""),format.raw/*118.5*/(""");
			return false;
		"""),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");
		return modalCargaAjustes;
	"""),format.raw/*122.2*/("""}"""),format.raw/*122.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*125.49*/("""{"""),format.raw/*125.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*128.38*/("""{"""),format.raw/*128.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");
		return false;
	"""),format.raw/*132.2*/("""}"""),format.raw/*132.3*/(""");
"""),format.raw/*133.1*/("""}"""),format.raw/*133.2*/(""");
</script>"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[SolicitudLineaAjuste],editable:Boolean,solicitud:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,solicitud)
    
    def f:((utils.pagination.Pagination[SolicitudLineaAjuste],Boolean,Solicitud) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,solicitud) => apply(paginador,editable,solicitud)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/indexLineaAjuste.scala.html
                    HASH: d3ac77fff3fb127baa75c5df73579d725d40ae95
                    MATRIX: 872->1|1108->105|1135->144|1263->238|1318->285|1357->287|1395->291|1482->370|1520->371|1671->491|1705->494|1748->502|1794->539|1833->540|1970->646|2078->718|2125->755|2165->756|2203->761|2451->974|2472->986|2511->987|2581->1026|2646->1056|2693->1087|2733->1089|2772->1093|2785->1098|2877->1168|2911->1171|2979->1203|2997->1212|3051->1244|3142->1300|3156->1305|3278->1404|3346->1444|3375->1445|3563->1605|3592->1606|3766->1753|3794->1754|3880->1812|3909->1813|4018->1894|4047->1895|4095->1915|4124->1916|4189->1954|4217->1955|4251->1961|4280->1962|4359->2014|4387->2015|4417->2018|4445->2019|4492->2039|4520->2040|4580->2072|4609->2073|4684->2120|4713->2121|4883->2263|4912->2264|4970->2294|4999->2295|5066->2335|5094->2336|5130->2345|5158->2346|5221->2381|5250->2382|5325->2430|5353->2431|5385->2436|5413->2437|5502->2498|5531->2499|5618->2559|5646->2560|5724->2610|5753->2611|5983->2812|6013->2813|6087->2858|6117->2859|6327->3041|6356->3042|6435->3092|6465->3093|6638->3238|6667->3239|6702->3245|6732->3246|6805->3291|6834->3292|6937->3367|6966->3368|7016->3390|7045->3391|7105->3423|7134->3424|7216->3477|7246->3478|7384->3587|7414->3588|7480->3626|7509->3627|7557->3647|7586->3648|7617->3651|7646->3652
                    LINES: 26->1|32->1|33->4|37->8|37->8|37->8|38->9|38->9|38->9|40->11|41->12|44->15|44->15|44->15|46->17|48->19|48->19|48->19|48->19|58->29|58->29|58->29|60->31|64->35|64->35|64->35|65->36|65->36|65->36|66->37|70->41|70->41|70->41|72->43|72->43|72->43|79->50|79->50|86->57|86->57|90->61|90->61|92->63|92->63|95->66|95->66|96->67|96->67|98->69|98->69|98->69|98->69|100->71|100->71|101->72|101->72|103->74|103->74|105->76|105->76|106->77|106->77|112->83|112->83|113->84|113->84|115->86|115->86|116->87|116->87|117->88|117->88|119->90|119->90|120->91|120->91|122->93|122->93|125->96|125->96|127->98|127->98|133->104|133->104|134->105|134->105|139->110|139->110|139->110|139->110|143->114|143->114|143->114|143->114|145->116|145->116|147->118|147->118|149->120|149->120|151->122|151->122|154->125|154->125|157->128|157->128|159->130|159->130|161->132|161->132|162->133|162->133
                    -- GENERATED --
                */
            