
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
object indexLineaSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[SolicitudLinea],Boolean,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[SolicitudLinea], editable: Boolean, btnEliminar: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.100*/("""
<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Productos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
	<a id="eliminarLineas" href=""""),_display_(Seq[Any](/*8.32*/controllers/*8.43*/.compras.routes.LineasSolicitudesController.eliminarMasivo())),format.raw/*8.103*/("""" class="btn btn-xs btn-default"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>	 	
	""")))})),format.raw/*9.3*/("""
</p>

"""),_display_(Seq[Any](/*12.2*/if(paginador.getTotalRowCount() <= 0)/*12.39*/{_display_(Seq[Any](format.raw/*12.40*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> No existen lineas de productos para esta solicitud.</p>
""")))})),format.raw/*14.2*/(""" 

"""),_display_(Seq[Any](/*16.2*/if(paginador.getTotalRowCount() > 0)/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
	Mostrando """),_display_(Seq[Any](/*17.13*/paginador/*17.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*17.54*/(""" resultado(s).
""")))})),format.raw/*18.2*/("""

<table id="listaDeProductos" class="table table-striped table-bordered """),_display_(Seq[Any](/*20.73*/if(paginador.getTotalRowCount() <= 0)/*20.110*/{_display_(Seq[Any](format.raw/*20.111*/("""hide""")))})),format.raw/*20.116*/("""">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*23.5*/if(editable)/*23.17*/{_display_(Seq[Any](format.raw/*23.18*/("""
				<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
				<th class="accion-editar">#</th>
			""")))})),format.raw/*26.5*/("""
			<th><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*27.41*/controllers/*27.52*/.compras.routes.LineasSolicitudesController.index())),format.raw/*27.103*/("""?"""),_display_(Seq[Any](/*27.105*/paginador/*27.114*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "producto.nombre").getCurrentLink())),format.raw/*27.241*/("""">Producto</a></th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*30.41*/controllers/*30.52*/.compras.routes.LineasSolicitudesController.index())),format.raw/*30.103*/("""?"""),_display_(Seq[Any](/*30.105*/paginador/*30.114*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "cuentaAnalitica.nombre").getCurrentLink())),format.raw/*30.248*/("""">Cuenta analitica</a></th>
			<th>UDM</th>
			<th>Subtotal</th>
			"""),_display_(Seq[Any](/*33.5*/if(editable)/*33.17*/{_display_(Seq[Any](format.raw/*33.18*/("""
				<th></th>
			""")))})),format.raw/*35.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*39.3*/for(linea <- paginador.getList) yield /*39.34*/ {_display_(Seq[Any](format.raw/*39.36*/("""
		"""),_display_(Seq[Any](/*40.4*/views/*40.9*/.html.compras.lineasSolicitudes.lineaProducto(linea, editable,btnEliminar))),format.raw/*40.83*/("""
	""")))})),format.raw/*41.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*46.6*/views/*46.11*/.html.helpers.paginador(paginador, controllers.compras.routes.LineasSolicitudesController.index()))),format.raw/*46.109*/("""
</div>

</div>

<script>
$( function()"""),format.raw/*52.14*/("""{"""),format.raw/*52.15*/("""
	/**
	 * Ventana de carga linea de productos en solicitudes
	 */
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*59.53*/("""{"""),format.raw/*59.54*/("""
		var deposito = 1;
		if($('#deposito_id').val().length > 0)"""),format.raw/*61.41*/("""{"""),format.raw/*61.42*/("""
			deposito = $('#deposito_id').val();
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/("""
		urlContenidoModal = '/compras/linea-solicitud/crear?solicitudId='+$('#solicitudId').val()+"&idDeposito="+deposito;
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*69.57*/("""{"""),format.raw/*69.58*/("""
		var deposito = 1;
		if($('#deposito_id').val().length > 0)"""),format.raw/*71.41*/("""{"""),format.raw/*71.42*/("""
			deposito = $('#deposito_id').val();
		"""),format.raw/*73.3*/("""}"""),format.raw/*73.4*/("""
		
		var href = $(this).attr('href')+"&idDeposito="+deposito;
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal(href);
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*80.2*/("""}"""),format.raw/*80.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*82.56*/("""{"""),format.raw/*82.57*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*84.23*/("""{"""),format.raw/*84.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*87.29*/("""{"""),format.raw/*87.30*/("""
				if(data.success)"""),format.raw/*88.21*/("""{"""),format.raw/*88.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*90.5*/("""}"""),format.raw/*90.6*/(""" else """),format.raw/*90.12*/("""{"""),format.raw/*90.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*92.5*/("""}"""),format.raw/*92.6*/("""
			"""),format.raw/*93.4*/("""}"""),format.raw/*93.5*/(""");
		"""),format.raw/*94.3*/("""}"""),format.raw/*94.4*/("""
		return false;
	"""),format.raw/*96.2*/("""}"""),format.raw/*96.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*98.28*/("""{"""),format.raw/*98.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*99.49*/("""{"""),format.raw/*99.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 450,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*105.35*/("""{"""),format.raw/*105.36*/("""
				$.get(url, function(data)"""),format.raw/*106.30*/("""{"""),format.raw/*106.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*108.5*/("""}"""),format.raw/*108.6*/(""");
		    """),format.raw/*109.7*/("""}"""),format.raw/*109.8*/(""",
		    close: function(event, ui )"""),format.raw/*110.34*/("""{"""),format.raw/*110.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*112.4*/("""}"""),format.raw/*112.5*/("""
		  """),format.raw/*113.5*/("""}"""),format.raw/*113.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*115.58*/("""{"""),format.raw/*115.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*118.3*/("""}"""),format.raw/*118.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*120.47*/("""{"""),format.raw/*120.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*123.42*/("""{"""),format.raw/*123.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*124.45*/("""{"""),format.raw/*124.46*/("""
					$('#listaDeProductos').removeClass('hide');
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*128.5*/("""}"""),format.raw/*128.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*128.56*/("""{"""),format.raw/*128.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*131.5*/("""}"""),format.raw/*131.6*/(""" else """),format.raw/*131.12*/("""{"""),format.raw/*131.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*133.5*/("""}"""),format.raw/*133.6*/("""
			"""),format.raw/*134.4*/("""}"""),format.raw/*134.5*/(""");
			return false;
		"""),format.raw/*136.3*/("""}"""),format.raw/*136.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*140.2*/("""}"""),format.raw/*140.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*143.49*/("""{"""),format.raw/*143.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*146.38*/("""{"""),format.raw/*146.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*148.3*/("""}"""),format.raw/*148.4*/(""");
		return false;
	"""),format.raw/*150.2*/("""}"""),format.raw/*150.3*/(""");
	
	
	/*
	 * Seleccion de check en la tabla
	 */
	$('#checkAll').change( function()"""),format.raw/*156.35*/("""{"""),format.raw/*156.36*/("""
		var table = $(this).closest('table');
		table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
	"""),format.raw/*159.2*/("""}"""),format.raw/*159.3*/(""");

	$(document).on('click', '#eliminarLineas', function()"""),format.raw/*161.55*/("""{"""),format.raw/*161.56*/("""
		link = $(this).attr("href");
		var retorno = false;

		if($("input[name='check_listado[]']:checked").length == 0) """),format.raw/*165.62*/("""{"""),format.raw/*165.63*/("""
			alert("Debe seleccionar al menos una linea de productos.");
			return false;
		"""),format.raw/*168.3*/("""}"""),format.raw/*168.4*/("""
		
		
		var ids = $("input[name='check_listado[]']").serialize();
		

		
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar los registros registros seleccionados?<p></div>');
	    dialogo.dialog("""),format.raw/*176.21*/("""{"""),format.raw/*176.22*/("""
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar",
	        buttons: """),format.raw/*181.19*/("""{"""),format.raw/*181.20*/("""
	          Eliminar: function() """),format.raw/*182.33*/("""{"""),format.raw/*182.34*/("""
	            $.post(link, ids, function(data)"""),format.raw/*183.46*/("""{"""),format.raw/*183.47*/("""
	            	if(data.success) """),format.raw/*184.32*/("""{"""),format.raw/*184.33*/("""
	            		location.reload();
	            	"""),format.raw/*186.15*/("""}"""),format.raw/*186.16*/(""" else """),format.raw/*186.22*/("""{"""),format.raw/*186.23*/("""
	            		alert("No se pudo eliminar las lineas de productos.");
	            	"""),format.raw/*188.15*/("""}"""),format.raw/*188.16*/("""
	            """),format.raw/*189.14*/("""}"""),format.raw/*189.15*/(""");
	          """),format.raw/*190.12*/("""}"""),format.raw/*190.13*/(""",
	          Cancelar: function( event, ui ) """),format.raw/*191.44*/("""{"""),format.raw/*191.45*/("""
	            $( this ).dialog( "close" );
	          """),format.raw/*193.12*/("""}"""),format.raw/*193.13*/("""
	        """),format.raw/*194.10*/("""}"""),format.raw/*194.11*/(""",
		    close: function()"""),format.raw/*195.24*/("""{"""),format.raw/*195.25*/("""
		    	$( this ).dialog( "destroy" );
		    """),format.raw/*197.7*/("""}"""),format.raw/*197.8*/("""
	      """),format.raw/*198.8*/("""}"""),format.raw/*198.9*/(""");
	    return false;
	"""),format.raw/*200.2*/("""}"""),format.raw/*200.3*/("""); 
	
"""),format.raw/*202.1*/("""}"""),format.raw/*202.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[SolicitudLinea],editable:Boolean,btnEliminar:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,btnEliminar)
    
    def f:((utils.pagination.Pagination[SolicitudLinea],Boolean,Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,btnEliminar) => apply(paginador,editable,btnEliminar)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/indexLineaSolicitud.scala.html
                    HASH: 6e247830eebe658a09c0a3d4a6f30be9affa32d0
                    MATRIX: 867->1|1060->99|1198->203|1218->215|1256->216|1439->364|1458->375|1540->435|1679->544|1725->555|1771->592|1810->593|1951->703|1992->709|2037->745|2077->747|2127->761|2145->770|2199->802|2247->819|2359->895|2406->932|2446->933|2484->938|2545->964|2566->976|2605->977|2760->1101|2838->1143|2858->1154|2932->1205|2971->1207|2990->1216|3140->1343|3279->1446|3299->1457|3373->1508|3412->1510|3431->1519|3588->1653|3695->1725|3716->1737|3755->1738|3807->1759|3876->1793|3923->1824|3963->1826|4003->1831|4016->1836|4112->1910|4147->1914|4249->1981|4263->1986|4384->2084|4457->2129|4486->2130|4688->2304|4717->2305|4808->2368|4837->2369|4908->2413|4936->2414|5137->2588|5165->2589|5256->2652|5285->2653|5376->2716|5405->2717|5476->2761|5504->2762|5750->2981|5778->2982|5868->3044|5897->3045|6011->3131|6040->3132|6155->3219|6184->3220|6234->3242|6263->3243|6332->3285|6360->3286|6394->3292|6423->3293|6506->3349|6534->3350|6566->3355|6594->3356|6627->3362|6655->3363|6702->3383|6730->3384|6792->3418|6821->3419|6899->3469|6928->3470|7107->3620|7137->3621|7197->3652|7227->3653|7299->3697|7328->3698|7366->3708|7395->3709|7460->3745|7490->3746|7570->3798|7599->3799|7633->3805|7662->3806|7756->3871|7786->3872|7879->3937|7908->3938|7991->3992|8021->3993|8176->4119|8206->4120|8281->4166|8311->4167|8502->4330|8531->4331|8610->4381|8640->4382|8775->4489|8804->4490|8839->4496|8869->4497|8946->4546|8975->4547|9008->4552|9037->4553|9089->4577|9118->4578|9190->4622|9219->4623|9304->4679|9334->4680|9475->4792|9505->4793|9573->4833|9602->4834|9652->4856|9681->4857|9801->4948|9831->4949|9995->5085|10024->5086|10113->5146|10143->5147|10293->5268|10323->5269|10437->5355|10466->5356|10792->5653|10822->5654|10973->5776|11003->5777|11066->5811|11096->5812|11172->5859|11202->5860|11264->5893|11294->5894|11374->5945|11404->5946|11439->5952|11469->5953|11585->6040|11615->6041|11659->6056|11689->6057|11733->6072|11763->6073|11838->6119|11868->6120|11953->6176|11983->6177|12023->6188|12053->6189|12108->6215|12138->6216|12213->6263|12242->6264|12279->6273|12308->6274|12361->6299|12390->6300|12426->6308|12455->6309
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|36->8|36->8|37->9|40->12|40->12|40->12|42->14|44->16|44->16|44->16|45->17|45->17|45->17|46->18|48->20|48->20|48->20|48->20|51->23|51->23|51->23|54->26|55->27|55->27|55->27|55->27|55->27|55->27|58->30|58->30|58->30|58->30|58->30|58->30|61->33|61->33|61->33|63->35|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46|74->46|80->52|80->52|87->59|87->59|89->61|89->61|91->63|91->63|95->67|95->67|97->69|97->69|99->71|99->71|101->73|101->73|108->80|108->80|110->82|110->82|112->84|112->84|115->87|115->87|116->88|116->88|118->90|118->90|118->90|118->90|120->92|120->92|121->93|121->93|122->94|122->94|124->96|124->96|126->98|126->98|127->99|127->99|133->105|133->105|134->106|134->106|136->108|136->108|137->109|137->109|138->110|138->110|140->112|140->112|141->113|141->113|143->115|143->115|146->118|146->118|148->120|148->120|151->123|151->123|152->124|152->124|156->128|156->128|156->128|156->128|159->131|159->131|159->131|159->131|161->133|161->133|162->134|162->134|164->136|164->136|168->140|168->140|171->143|171->143|174->146|174->146|176->148|176->148|178->150|178->150|184->156|184->156|187->159|187->159|189->161|189->161|193->165|193->165|196->168|196->168|204->176|204->176|209->181|209->181|210->182|210->182|211->183|211->183|212->184|212->184|214->186|214->186|214->186|214->186|216->188|216->188|217->189|217->189|218->190|218->190|219->191|219->191|221->193|221->193|222->194|222->194|223->195|223->195|225->197|225->197|226->198|226->198|228->200|228->200|230->202|230->202
                    -- GENERATED --
                */
            