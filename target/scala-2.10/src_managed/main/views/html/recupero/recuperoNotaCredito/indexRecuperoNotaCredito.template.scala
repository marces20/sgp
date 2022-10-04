
package views.html.recupero.recuperoNotaCredito

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
object indexRecuperoNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[models.recupero.RecuperoNotaCredito],Boolean,models.recupero.RecuperoFactura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[models.recupero.RecuperoNotaCredito], editable: Boolean,rf:models.recupero.RecuperoFactura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.134*/("""
<div id="listaLineaNotaCreditos" class="contenedorPaginador ajaxPaginador">

<div class="panel panel-default">
		<div class="panel-heading"><b>Notas de Creditos</b>
		
		 	 
		"""),_display_(Seq[Any](/*8.4*/if(rf.estado_id == models.Estado.RECUPERO_FACTURA_APROBADO)/*8.63*/ {_display_(Seq[Any](format.raw/*8.65*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoNotaCredito"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
		""")))})),format.raw/*10.4*/("""	 
		</div>
		<div class="panel-body">
			"""),_display_(Seq[Any](/*13.5*/if(paginador.getTotalRowCount == 0)/*13.40*/ {_display_(Seq[Any](format.raw/*13.42*/("""
        		<p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay Notas de creditos para esta factura.</p>
    		""")))})),format.raw/*15.8*/(""" 
			
			<table id="listaDeNotaCreditos" class="table table-striped table-bordered """),_display_(Seq[Any](/*17.79*/if(paginador.getTotalRowCount() <= 0)/*17.116*/{_display_(Seq[Any](format.raw/*17.117*/("""hide""")))})),format.raw/*17.122*/("""">
				<thead>
					<tr>
						<!--  <th class="accion-editar">#</th>-->
						<th>Planilla</th>
						<th>Fecha</th>
						<th>Producto</th>
						<th>UDM</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>Subtotal</th>
							<th></th>
						
					<tr>	
				</thead>
				<tbody>
				"""),_display_(Seq[Any](/*33.6*/for(linea <- paginador.getList) yield /*33.37*/ {_display_(Seq[Any](format.raw/*33.39*/("""
					"""),_display_(Seq[Any](/*34.7*/views/*34.12*/.html.recupero.recuperoNotaCredito.lineaNotaCredito(linea, editable))),format.raw/*34.80*/("""
				""")))})),format.raw/*35.6*/("""
				</tbody>
			</table>

			<div class="pagination pull-right">		
			    """),_display_(Seq[Any](/*40.9*/views/*40.14*/.html.helpers.paginador(paginador, controllers.recupero.routes.RecuperoNotasCreditosController.index()))),format.raw/*40.117*/("""
			</div>
	</div>
</div>
<script>
$( function()"""),format.raw/*45.14*/("""{"""),format.raw/*45.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaNotaCreditos");

	contenedor.on('click', '#nuevoNotaCredito', function()"""),format.raw/*52.56*/("""{"""),format.raw/*52.57*/("""
		urlContenidoModal = '/recupero/nota-credito-linea/crear?facturaId='+$('#recuperoFacturaId').val();
							
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*57.2*/("""}"""),format.raw/*57.3*/(""");
	
	contenedor.on('click', '.modificarNotaCredito', function()"""),format.raw/*59.60*/("""{"""),format.raw/*59.61*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*64.2*/("""}"""),format.raw/*64.3*/(""");
	
	contenedor.on('click', '.eliminarNotaCredito', function()"""),format.raw/*66.59*/("""{"""),format.raw/*66.60*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*68.23*/("""{"""),format.raw/*68.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*71.29*/("""{"""),format.raw/*71.30*/("""
				if(data.success)"""),format.raw/*72.21*/("""{"""),format.raw/*72.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""" else """),format.raw/*74.12*/("""{"""),format.raw/*74.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*76.5*/("""}"""),format.raw/*76.6*/("""
			"""),format.raw/*77.4*/("""}"""),format.raw/*77.5*/(""");
		"""),format.raw/*78.3*/("""}"""),format.raw/*78.4*/("""
		return false;
	"""),format.raw/*80.2*/("""}"""),format.raw/*80.3*/(""");
	
	
	function mostrarModal(url)"""),format.raw/*83.28*/("""{"""),format.raw/*83.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*84.49*/("""{"""),format.raw/*84.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*90.35*/("""{"""),format.raw/*90.36*/("""
				$.get(url, function(data)"""),format.raw/*91.30*/("""{"""),format.raw/*91.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*93.5*/("""}"""),format.raw/*93.6*/(""");
		    """),format.raw/*94.7*/("""}"""),format.raw/*94.8*/(""",
		    close: function(event, ui )"""),format.raw/*95.34*/("""{"""),format.raw/*95.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""
		  """),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*100.58*/("""{"""),format.raw/*100.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*103.3*/("""}"""),format.raw/*103.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*105.47*/("""{"""),format.raw/*105.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*108.42*/("""{"""),format.raw/*108.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*109.45*/("""{"""),format.raw/*109.46*/("""
					$('#listaLineaNotaCreditos tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaDeNotaCreditos').removeClass('hide');
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
    
    def render(paginador:utils.pagination.Pagination[models.recupero.RecuperoNotaCredito],editable:Boolean,rf:models.recupero.RecuperoFactura): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,rf)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoNotaCredito],Boolean,models.recupero.RecuperoFactura) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,rf) => apply(paginador,editable,rf)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoNotaCredito/indexRecuperoNotaCredito.scala.html
                    HASH: f66769fd417ac6b9cffe62a37454971a039dfac8
                    MATRIX: 920->1|1147->133|1366->318|1433->377|1472->379|1631->507|1712->553|1756->588|1796->590|1983->746|2105->832|2152->869|2192->870|2230->875|2577->1187|2624->1218|2664->1220|2707->1228|2721->1233|2811->1301|2849->1308|2965->1389|2979->1394|3105->1497|3186->1550|3215->1551|3419->1727|3448->1728|3642->1895|3670->1896|3764->1962|3793->1963|3991->2134|4019->2135|4112->2200|4141->2201|4255->2287|4284->2288|4399->2375|4428->2376|4478->2398|4507->2399|4576->2441|4604->2442|4638->2448|4667->2449|4750->2505|4778->2506|4810->2511|4838->2512|4871->2518|4899->2519|4946->2539|4974->2540|5039->2577|5068->2578|5146->2628|5175->2629|5353->2779|5382->2780|5441->2811|5470->2812|5541->2856|5569->2857|5606->2867|5634->2868|5698->2904|5727->2905|5806->2957|5834->2958|5867->2964|5895->2965|5989->3030|6019->3031|6112->3096|6141->3097|6224->3151|6254->3152|6409->3278|6439->3279|6514->3325|6544->3326|6787->3541|6816->3542|6895->3592|6925->3593|7060->3700|7089->3701|7124->3707|7154->3708|7231->3757|7260->3758|7293->3763|7322->3764|7374->3788|7403->3789|7475->3833|7504->3834|7589->3890|7619->3891|7760->4003|7790->4004|7858->4044|7887->4045|7937->4067|7966->4068|7998->4072|8027->4073
                    LINES: 26->1|29->1|36->8|36->8|36->8|38->10|41->13|41->13|41->13|43->15|45->17|45->17|45->17|45->17|61->33|61->33|61->33|62->34|62->34|62->34|63->35|68->40|68->40|68->40|73->45|73->45|80->52|80->52|85->57|85->57|87->59|87->59|92->64|92->64|94->66|94->66|96->68|96->68|99->71|99->71|100->72|100->72|102->74|102->74|102->74|102->74|104->76|104->76|105->77|105->77|106->78|106->78|108->80|108->80|111->83|111->83|112->84|112->84|118->90|118->90|119->91|119->91|121->93|121->93|122->94|122->94|123->95|123->95|125->97|125->97|126->98|126->98|128->100|128->100|131->103|131->103|133->105|133->105|136->108|136->108|137->109|137->109|142->114|142->114|142->114|142->114|145->117|145->117|145->117|145->117|147->119|147->119|148->120|148->120|150->122|150->122|154->126|154->126|157->129|157->129|160->132|160->132|162->134|162->134|164->136|164->136|165->137|165->137
                    -- GENERATED --
                */
            