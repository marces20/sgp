
package views.html.contabilidad.facturasLineas

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
object indexFacturaLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[FacturaLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[FacturaLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.76*/("""
<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Productos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
	<a id="eliminarfacturas" href=""""),_display_(Seq[Any](/*8.34*/controllers/*8.45*/.contabilidad.routes.FacturasLineasController.eliminarMasivo())),format.raw/*8.107*/("""" class="btn btn-xs btn-default"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	""")))})),format.raw/*9.3*/("""
</p>

"""),_display_(Seq[Any](/*12.2*/if(paginador.getTotalRowCount() > 0)/*12.38*/ {_display_(Seq[Any](format.raw/*12.40*/("""
	Mostrando """),_display_(Seq[Any](/*13.13*/paginador/*13.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*13.54*/(""" resultado(s).
""")))})),format.raw/*14.2*/("""

<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr data-url=""""),_display_(Seq[Any](/*18.18*/controllers/*18.29*/.contabilidad.routes.FacturasLineasController.eliminarMasivo())),format.raw/*18.91*/("""">

			"""),_display_(Seq[Any](/*20.5*/if(editable)/*20.17*/{_display_(Seq[Any](format.raw/*20.18*/("""
				<th width="30">
					<input type="checkbox" name="checkAll" id="checkAll"/>
				</th>
				<th class="accion-editar">#</th>
			""")))})),format.raw/*25.5*/("""
			<th><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*26.41*/controllers/*26.52*/.contabilidad.routes.FacturasLineasController.index())),format.raw/*26.105*/("""?"""),_display_(Seq[Any](/*26.107*/paginador/*26.116*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "producto.nombre").getCurrentLink())),format.raw/*26.243*/("""">Producto</a></th>
			<th>Cuenta</th>
			<th><a class="ordenPaginador" href=""""),_display_(Seq[Any](/*28.41*/controllers/*28.52*/.contabilidad.routes.FacturasLineasController.index())),format.raw/*28.105*/("""?"""),_display_(Seq[Any](/*28.107*/paginador/*28.116*/.setVar("order", if(paginador.getOrder() == "desc") {"asc"} else {"desc"}).setVar("sortBy", "cuentaAnalitica.nombre").getCurrentLink())),format.raw/*28.250*/("""">Cuenta analitica</a></th>
			<th>Cuenta analitica original</th>
			<th>Cantidad</th>
			<th>UDM</th>
			<th>Precio</th>
			<th>Descuento (%)</th>
			<th>Subtotal desc.</th>
			<th>Subtotal</th>
			"""),_display_(Seq[Any](/*36.5*/if(editable)/*36.17*/{_display_(Seq[Any](format.raw/*36.18*/("""
				<th></th>
			""")))})),format.raw/*38.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*42.3*/for(linea <- paginador.getList) yield /*42.34*/ {_display_(Seq[Any](format.raw/*42.36*/("""
		"""),_display_(Seq[Any](/*43.4*/views/*43.9*/.html.contabilidad.facturasLineas.lineaProducto(linea, editable))),format.raw/*43.73*/("""
	""")))})),format.raw/*44.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*49.6*/views/*49.11*/.html.helpers.paginador(paginador, controllers.contabilidad.routes.FacturasLineasController.index()))),format.raw/*49.111*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	 
	var contenedor = $("#listaLineaProductos");

	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*62.53*/("""{"""),format.raw/*62.54*/("""
		urlContenidoModal = '/contabilidad/factura-linea/crear?facturaId='+$('#facturaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*68.57*/("""{"""),format.raw/*68.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*75.56*/("""{"""),format.raw/*75.57*/("""
		var url = $(this).attr('href');
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*78.23*/("""{"""),format.raw/*78.24*/("""
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*80.29*/("""{"""),format.raw/*80.30*/("""
				if(data.success)"""),format.raw/*81.21*/("""{"""),format.raw/*81.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*83.5*/("""}"""),format.raw/*83.6*/(""" else """),format.raw/*83.12*/("""{"""),format.raw/*83.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*85.5*/("""}"""),format.raw/*85.6*/("""
			"""),format.raw/*86.4*/("""}"""),format.raw/*86.5*/(""");
		"""),format.raw/*87.3*/("""}"""),format.raw/*87.4*/("""
		return false;
	"""),format.raw/*89.2*/("""}"""),format.raw/*89.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*91.28*/("""{"""),format.raw/*91.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*92.49*/("""{"""),format.raw/*92.50*/("""
			resizable: false,
		    title: "Cargar producto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*98.35*/("""{"""),format.raw/*98.36*/("""
				$.get(url, function(data)"""),format.raw/*99.30*/("""{"""),format.raw/*99.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*101.5*/("""}"""),format.raw/*101.6*/(""");
		    """),format.raw/*102.7*/("""}"""),format.raw/*102.8*/(""",
		    close: function(event, ui )"""),format.raw/*103.34*/("""{"""),format.raw/*103.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*105.4*/("""}"""),format.raw/*105.5*/("""
		  """),format.raw/*106.5*/("""}"""),format.raw/*106.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*108.58*/("""{"""),format.raw/*108.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*111.3*/("""}"""),format.raw/*111.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*113.47*/("""{"""),format.raw/*113.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*116.42*/("""{"""),format.raw/*116.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*117.45*/("""{"""),format.raw/*117.46*/("""
					$('#listaDeProductos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*120.5*/("""}"""),format.raw/*120.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*120.56*/("""{"""),format.raw/*120.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""" else """),format.raw/*123.12*/("""{"""),format.raw/*123.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*125.5*/("""}"""),format.raw/*125.6*/("""
			"""),format.raw/*126.4*/("""}"""),format.raw/*126.5*/(""");
			return false;
		"""),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*132.2*/("""}"""),format.raw/*132.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*135.49*/("""{"""),format.raw/*135.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*138.38*/("""{"""),format.raw/*138.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*140.3*/("""}"""),format.raw/*140.4*/(""");
		return false;
	"""),format.raw/*142.2*/("""}"""),format.raw/*142.3*/(""");


	/*
	 * Seleccion de check en la tabla
	 */
	$('#checkAll').change( function()"""),format.raw/*148.35*/("""{"""),format.raw/*148.36*/("""
		var table = $(this).closest('table');
		table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
	"""),format.raw/*151.2*/("""}"""),format.raw/*151.3*/(""");

	$(document).on('click', '#eliminarfacturas', function()"""),format.raw/*153.57*/("""{"""),format.raw/*153.58*/("""
		link = $(this).attr("href");
		var retorno = false;

		if($("input[name='check_listado[]']:checked").length == 0) """),format.raw/*157.62*/("""{"""),format.raw/*157.63*/("""
			alert("Debe seleccionar al menos una linea de factura.");
			return false;
		"""),format.raw/*160.3*/("""}"""),format.raw/*160.4*/("""
		
		
		var ids = $("input[name='check_listado[]']").serialize();
		

		
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar los registros registros seleccionados?<p></div>');
	    dialogo.dialog("""),format.raw/*168.21*/("""{"""),format.raw/*168.22*/("""
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar",
	        buttons: """),format.raw/*173.19*/("""{"""),format.raw/*173.20*/("""
	          Eliminar: function() """),format.raw/*174.33*/("""{"""),format.raw/*174.34*/("""
	            $.post(link, ids, function(data)"""),format.raw/*175.46*/("""{"""),format.raw/*175.47*/("""
	            	if(data.success) """),format.raw/*176.32*/("""{"""),format.raw/*176.33*/("""
	            		location.reload();
	            	"""),format.raw/*178.15*/("""}"""),format.raw/*178.16*/(""" else """),format.raw/*178.22*/("""{"""),format.raw/*178.23*/("""
	            		alert("No se pudo eliminar las lineas de productos.");
	            	"""),format.raw/*180.15*/("""}"""),format.raw/*180.16*/("""
	            """),format.raw/*181.14*/("""}"""),format.raw/*181.15*/(""");
	          """),format.raw/*182.12*/("""}"""),format.raw/*182.13*/(""",
	          Cancelar: function( event, ui ) """),format.raw/*183.44*/("""{"""),format.raw/*183.45*/("""
	            $( this ).dialog( "close" );
	          """),format.raw/*185.12*/("""}"""),format.raw/*185.13*/("""
	        """),format.raw/*186.10*/("""}"""),format.raw/*186.11*/(""",
		    close: function()"""),format.raw/*187.24*/("""{"""),format.raw/*187.25*/("""
		    	$( this ).dialog( "destroy" );
		    """),format.raw/*189.7*/("""}"""),format.raw/*189.8*/("""
	      """),format.raw/*190.8*/("""}"""),format.raw/*190.9*/(""");
	    return false;
	"""),format.raw/*192.2*/("""}"""),format.raw/*192.3*/("""); 
		
	"""),format.raw/*194.2*/("""}"""),format.raw/*194.3*/(""");	
	</script>



"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[FacturaLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[FacturaLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineas/indexFacturaLinea.scala.html
                    HASH: d1122a871592870c0efa53535863b88e4b4c6f7d
                    MATRIX: 857->1|1025->75|1163->179|1183->191|1221->192|1406->342|1425->353|1509->415|1645->521|1691->532|1736->568|1776->570|1826->584|1844->593|1898->625|1946->642|2087->747|2107->758|2191->820|2236->830|2257->842|2296->843|2464->980|2542->1022|2562->1033|2638->1086|2677->1088|2696->1097|2846->1224|2963->1305|2983->1316|3059->1369|3098->1371|3117->1380|3274->1514|3517->1722|3538->1734|3577->1735|3629->1756|3698->1790|3745->1821|3785->1823|3825->1828|3838->1833|3924->1897|3959->1901|4061->1968|4075->1973|4198->2073|4269->2116|4298->2117|4500->2291|4529->2292|4705->2441|4733->2442|4824->2505|4853->2506|5051->2677|5079->2678|5169->2740|5198->2741|5347->2862|5376->2863|5455->2914|5484->2915|5534->2937|5563->2938|5632->2980|5660->2981|5694->2987|5723->2988|5806->3044|5834->3045|5866->3050|5894->3051|5927->3057|5955->3058|6002->3078|6030->3079|6092->3113|6121->3114|6199->3164|6228->3165|6406->3315|6435->3316|6494->3347|6523->3348|6595->3392|6624->3393|6662->3403|6691->3404|6756->3440|6786->3441|6866->3493|6895->3494|6929->3500|6958->3501|7052->3566|7082->3567|7175->3632|7204->3633|7287->3687|7317->3688|7472->3814|7502->3815|7577->3861|7607->3862|7748->3975|7777->3976|7856->4026|7886->4027|8021->4134|8050->4135|8085->4141|8115->4142|8192->4191|8221->4192|8254->4197|8283->4198|8335->4222|8364->4223|8436->4267|8465->4268|8550->4324|8580->4325|8721->4437|8751->4438|8819->4478|8848->4479|8898->4501|8927->4502|9045->4591|9075->4592|9239->4728|9268->4729|9359->4791|9389->4792|9539->4913|9569->4914|9681->4998|9710->4999|10036->5296|10066->5297|10217->5419|10247->5420|10310->5454|10340->5455|10416->5502|10446->5503|10508->5536|10538->5537|10618->5588|10648->5589|10683->5595|10713->5596|10829->5683|10859->5684|10903->5699|10933->5700|10977->5715|11007->5716|11082->5762|11112->5763|11197->5819|11227->5820|11267->5831|11297->5832|11352->5858|11382->5859|11457->5906|11486->5907|11523->5916|11552->5917|11605->5942|11634->5943|11672->5953|11701->5954
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|36->8|36->8|37->9|40->12|40->12|40->12|41->13|41->13|41->13|42->14|46->18|46->18|46->18|48->20|48->20|48->20|53->25|54->26|54->26|54->26|54->26|54->26|54->26|56->28|56->28|56->28|56->28|56->28|56->28|64->36|64->36|64->36|66->38|70->42|70->42|70->42|71->43|71->43|71->43|72->44|77->49|77->49|77->49|82->54|82->54|90->62|90->62|94->66|94->66|96->68|96->68|101->73|101->73|103->75|103->75|106->78|106->78|108->80|108->80|109->81|109->81|111->83|111->83|111->83|111->83|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|119->91|119->91|120->92|120->92|126->98|126->98|127->99|127->99|129->101|129->101|130->102|130->102|131->103|131->103|133->105|133->105|134->106|134->106|136->108|136->108|139->111|139->111|141->113|141->113|144->116|144->116|145->117|145->117|148->120|148->120|148->120|148->120|151->123|151->123|151->123|151->123|153->125|153->125|154->126|154->126|156->128|156->128|160->132|160->132|163->135|163->135|166->138|166->138|168->140|168->140|170->142|170->142|176->148|176->148|179->151|179->151|181->153|181->153|185->157|185->157|188->160|188->160|196->168|196->168|201->173|201->173|202->174|202->174|203->175|203->175|204->176|204->176|206->178|206->178|206->178|206->178|208->180|208->180|209->181|209->181|210->182|210->182|211->183|211->183|213->185|213->185|214->186|214->186|215->187|215->187|217->189|217->189|218->190|218->190|220->192|220->192|222->194|222->194
                    -- GENERATED --
                */
            