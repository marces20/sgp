
package views.html.contabilidad.facturasLineasImpuestos

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
object indexFacturaLineaImpuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[FacturaLineaImpuesto],Boolean,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[FacturaLineaImpuesto], editable: Boolean,facturaId:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.99*/("""
"""),format.raw/*3.1*/("""
<div id="listaLineaImpuestos" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Retenciones</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("facturasCargarRetencones"))/*8.62*/{_display_(Seq[Any](format.raw/*8.63*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoImpuesto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
			<a class="btn btn-default btn-xs" data-href=""""),_display_(Seq[Any](/*10.50*/controllers/*10.61*/.contabilidad.routes.FacturasLineasImpuestosController.precalcular(facturaId))),format.raw/*10.138*/("""" href="#" id="calcularRetenciones"><i class="glyphicon glyphicon-arrow-down"></i><i class="glyphicon glyphicon-usd"></i> Precalcular Retenciones</a>
			|
			<label class="control-label">Tipo
				<select id="tipoProductoCalculo">
					<option value="servicio">Servicios</option>
					<option value="bien">Bienes</option>
					<option value="seriviciosAgentes">Servicios Agentes</option>
				</select>	
				
			</label>
			|
			<label class="control-label">Alícuota
				<select id="tipoAlicuota">
					<option value="1">21%</option>
					<option value="2">10,5% </option>
					<option value="3"> 0%</option>
				</select>	
				
			</label>
			
			""")))})),format.raw/*30.5*/("""
			
			<div class="loadingCalcularRetenciones loading hide "></div>
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*36.3*/if(paginador.getTotalRowCount == 0)/*36.38*/ {_display_(Seq[Any](format.raw/*36.40*/("""
        <p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay retenciones para esta factura.</p>
    """)))})),format.raw/*38.6*/(""" 

	<table id="listaDeImpuestos" class="table table-striped table-bordered  """),_display_(Seq[Any](/*40.75*/if(paginador.getTotalRowCount() <= 0)/*40.112*/{_display_(Seq[Any](format.raw/*40.113*/("""hide""")))})),format.raw/*40.118*/("""">
		<thead>
			<tr>
				"""),_display_(Seq[Any](/*43.6*/if(editable && Permiso.check("facturasCargarRetencones"))/*43.63*/{_display_(Seq[Any](format.raw/*43.64*/("""
					<th class="accion-editar">#</th>
				""")))})),format.raw/*45.6*/("""
					<th>Descripcion</th>
					<th>Cuenta</th>
					<th>Base</th>
					<th>Importe</th>
					<th>Tipo</th>
				"""),_display_(Seq[Any](/*51.6*/if(editable && Permiso.check("facturasCargarRetencones"))/*51.63*/{_display_(Seq[Any](format.raw/*51.64*/("""
					<th></th>
				""")))})),format.raw/*53.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*57.4*/for(linea <- paginador.getList) yield /*57.35*/ {_display_(Seq[Any](format.raw/*57.37*/("""
			"""),_display_(Seq[Any](/*58.5*/views/*58.10*/.html.contabilidad.facturasLineasImpuestos.lineaImpuesto(linea, editable))),format.raw/*58.83*/("""
		""")))})),format.raw/*59.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*66.9*/views/*66.14*/.html.helpers.paginador(paginador, controllers.contabilidad.routes.FacturasLineasImpuestosController.index()))),format.raw/*66.123*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*74.14*/("""{"""),format.raw/*74.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaImpuestos");
	
	contenedor.on('click', '#calcularRetenciones', function()"""),format.raw/*81.59*/("""{"""),format.raw/*81.60*/("""
		
		var href = $(this).attr('data-href')+'&tipoProductoCalculo='+$('#tipoProductoCalculo').val()+'&tipoAlicuota='+$('#tipoAlicuota').val() ;
		 
		$('#calcularRetenciones').addClass("disabled");
		$('#nuevoImpuesto').addClass("disabled");
		$('.loadingCalcularRetenciones').removeClass('hide');
		
		 
		
		$.get(href, function(resultado)"""),format.raw/*91.34*/("""{"""),format.raw/*91.35*/("""
			if(resultado.success && resultado.nuevo)"""),format.raw/*92.44*/("""{"""),format.raw/*92.45*/("""
				$('#listaDeImpuestos tbody').prepend(resultado.html);
				
			"""),format.raw/*95.4*/("""}"""),format.raw/*95.5*/("""else """),format.raw/*95.10*/("""{"""),format.raw/*95.11*/("""
				alert(resultado.html);
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""  
			
			$('#mensajeSinResultados').remove();
			$('#listaDeImpuestos').removeClass('hide');
			$('#calcularRetenciones').removeClass("disabled");
			$('#nuevoImpuesto').removeClass("disabled");
			$('.loadingCalcularRetenciones').addClass('hide');
		"""),format.raw/*104.3*/("""}"""),format.raw/*104.4*/(""");
		return false;
	"""),format.raw/*106.2*/("""}"""),format.raw/*106.3*/(""");
	
	
	
	contenedor.on('click', '#nuevoImpuesto', function()"""),format.raw/*110.53*/("""{"""),format.raw/*110.54*/("""
		urlContenidoModal = '/contabilidad/factura-linea-impuesto/crear?facturaId='+$('#facturaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*114.2*/("""}"""),format.raw/*114.3*/(""");
	
	contenedor.on('click', '.modificarImpuesto', function()"""),format.raw/*116.57*/("""{"""),format.raw/*116.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Impuesto');	
		return false;
	"""),format.raw/*121.2*/("""}"""),format.raw/*121.3*/(""");
	
	contenedor.on('click', '.eliminarImpuesto', function()"""),format.raw/*123.56*/("""{"""),format.raw/*123.57*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*125.23*/("""{"""),format.raw/*125.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*128.29*/("""{"""),format.raw/*128.30*/("""
				if(data.success)"""),format.raw/*129.21*/("""{"""),format.raw/*129.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*131.5*/("""}"""),format.raw/*131.6*/(""" else """),format.raw/*131.12*/("""{"""),format.raw/*131.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*133.5*/("""}"""),format.raw/*133.6*/("""
			"""),format.raw/*134.4*/("""}"""),format.raw/*134.5*/(""");
		"""),format.raw/*135.3*/("""}"""),format.raw/*135.4*/("""
		return false;
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*139.28*/("""{"""),format.raw/*139.29*/("""
		modalCargaImpuestos = $('<div></div>').dialog("""),format.raw/*140.49*/("""{"""),format.raw/*140.50*/("""
			resizable: false,
		    title: "Cargar Impuesto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*146.35*/("""{"""),format.raw/*146.36*/("""
				$.get(url, function(data)"""),format.raw/*147.30*/("""{"""),format.raw/*147.31*/("""
					modalCargaImpuestos.html(data);
				"""),format.raw/*149.5*/("""}"""),format.raw/*149.6*/(""");
		    """),format.raw/*150.7*/("""}"""),format.raw/*150.8*/(""",
		    close: function(event, ui )"""),format.raw/*151.34*/("""{"""),format.raw/*151.35*/("""
		    	modalCargaImpuestos.dialog('destroy');
			"""),format.raw/*153.4*/("""}"""),format.raw/*153.5*/("""
		  """),format.raw/*154.5*/("""}"""),format.raw/*154.6*/(""");
		
		modalCargaImpuestos.on('click', '.cancelar', function()"""),format.raw/*156.58*/("""{"""),format.raw/*156.59*/("""
			modalCargaImpuestos.dialog('destroy');
			return false;
		"""),format.raw/*159.3*/("""}"""),format.raw/*159.4*/(""");
		
		modalCargaImpuestos.on('submit', function(e)"""),format.raw/*161.47*/("""{"""),format.raw/*161.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*164.42*/("""{"""),format.raw/*164.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*165.45*/("""{"""),format.raw/*165.46*/("""
					$('#listaDeImpuestos tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaDeImpuestos').removeClass('hide');
					modalCargaImpuestos.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*171.5*/("""}"""),format.raw/*171.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*171.56*/("""{"""),format.raw/*171.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaImpuestos.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*176.5*/("""}"""),format.raw/*176.6*/(""" else """),format.raw/*176.12*/("""{"""),format.raw/*176.13*/("""
					modalCargaImpuestos.html(resultado);
				"""),format.raw/*178.5*/("""}"""),format.raw/*178.6*/("""
			"""),format.raw/*179.4*/("""}"""),format.raw/*179.5*/(""");
			return false;
		"""),format.raw/*181.3*/("""}"""),format.raw/*181.4*/(""");
		
		
		return modalCargaImpuestos;
	"""),format.raw/*185.2*/("""}"""),format.raw/*185.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*188.49*/("""{"""),format.raw/*188.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*191.38*/("""{"""),format.raw/*191.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*193.3*/("""}"""),format.raw/*193.4*/(""");
		return false;
	"""),format.raw/*195.2*/("""}"""),format.raw/*195.3*/(""");
"""),format.raw/*196.1*/("""}"""),format.raw/*196.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[FacturaLineaImpuesto],editable:Boolean,facturaId:Long): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,facturaId)
    
    def f:((utils.pagination.Pagination[FacturaLineaImpuesto],Boolean,Long) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,facturaId) => apply(paginador,editable,facturaId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasImpuestos/indexFacturaLineaImpuesto.scala.html
                    HASH: a3d08fabb893c7494ecff9011f3dee5a46d56a86
                    MATRIX: 887->1|1100->98|1128->123|1331->292|1396->349|1434->350|1638->518|1658->529|1758->606|2456->1273|2607->1389|2651->1424|2691->1426|2868->1572|2983->1651|3030->1688|3070->1689|3108->1694|3172->1723|3238->1780|3277->1781|3354->1827|3508->1946|3574->2003|3613->2004|3667->2027|3740->2065|3787->2096|3827->2098|3868->2104|3882->2109|3977->2182|4013->2187|4129->2268|4143->2273|4275->2382|4370->2449|4399->2450|4604->2627|4633->2628|5011->2978|5040->2979|5113->3024|5142->3025|5239->3095|5267->3096|5300->3101|5329->3102|5389->3135|5417->3136|5704->3395|5733->3396|5783->3418|5812->3419|5906->3484|5936->3485|6122->3643|6151->3644|6243->3707|6273->3708|6472->3879|6501->3880|6592->3942|6622->3943|6737->4029|6767->4030|6883->4117|6913->4118|6964->4140|6994->4141|7064->4183|7093->4184|7128->4190|7158->4191|7242->4247|7271->4248|7304->4253|7333->4254|7367->4260|7396->4261|7444->4281|7473->4282|7536->4316|7566->4317|7645->4367|7675->4368|7854->4518|7884->4519|7944->4550|7974->4551|8046->4595|8075->4596|8113->4606|8142->4607|8207->4643|8237->4644|8317->4696|8346->4697|8380->4703|8409->4704|8503->4769|8533->4770|8626->4835|8655->4836|8738->4890|8768->4891|8923->5017|8953->5018|9028->5064|9058->5065|9341->5320|9370->5321|9449->5371|9479->5372|9666->5531|9695->5532|9730->5538|9760->5539|9837->5588|9866->5589|9899->5594|9928->5595|9980->5619|10009->5620|10081->5664|10110->5665|10195->5721|10225->5722|10366->5834|10396->5835|10464->5875|10493->5876|10543->5898|10572->5899|10604->5903|10633->5904
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|38->10|38->10|58->30|64->36|64->36|64->36|66->38|68->40|68->40|68->40|68->40|71->43|71->43|71->43|73->45|79->51|79->51|79->51|81->53|85->57|85->57|85->57|86->58|86->58|86->58|87->59|94->66|94->66|94->66|102->74|102->74|109->81|109->81|119->91|119->91|120->92|120->92|123->95|123->95|123->95|123->95|125->97|125->97|132->104|132->104|134->106|134->106|138->110|138->110|142->114|142->114|144->116|144->116|149->121|149->121|151->123|151->123|153->125|153->125|156->128|156->128|157->129|157->129|159->131|159->131|159->131|159->131|161->133|161->133|162->134|162->134|163->135|163->135|165->137|165->137|167->139|167->139|168->140|168->140|174->146|174->146|175->147|175->147|177->149|177->149|178->150|178->150|179->151|179->151|181->153|181->153|182->154|182->154|184->156|184->156|187->159|187->159|189->161|189->161|192->164|192->164|193->165|193->165|199->171|199->171|199->171|199->171|204->176|204->176|204->176|204->176|206->178|206->178|207->179|207->179|209->181|209->181|213->185|213->185|216->188|216->188|219->191|219->191|221->193|221->193|223->195|223->195|224->196|224->196
                    -- GENERATED --
                */
            