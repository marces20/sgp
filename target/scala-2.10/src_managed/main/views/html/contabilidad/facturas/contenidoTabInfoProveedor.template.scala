
package views.html.contabilidad.facturas

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
object contenidoTabInfoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(factura != null)/*5.21*/{_display_(Seq[Any](format.raw/*5.22*/("""
<div class="row">
	<div class="col-sm-3">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Facturacion</b></div>
			<div class="panel-body">
				<h4>Monto Orden: 		<b>"""),_display_(Seq[Any](/*11.28*/if(factura != null && factura.orden != null)/*11.72*/{_display_(Seq[Any](_display_(Seq[Any](/*11.74*/utils/*11.79*/.NumberUtils.moneda(factura.orden.getTotal())))))})),format.raw/*11.125*/("""</b></h4>
				<!-- 
				<h4>Monto Bienes: 		<b>"""),_display_(Seq[Any](/*13.29*/if(factura != null)/*13.48*/{_display_(Seq[Any](_display_(Seq[Any](/*13.50*/utils/*13.55*/.NumberUtils.moneda(Factura.getTotalPorBienes(factura.id))))))}/*13.114*/else/*13.118*/{_display_(Seq[Any](format.raw/*13.119*/("""0,00""")))})),format.raw/*13.124*/("""</b></h4>
				<h4>Monto Servicios: 	<b>"""),_display_(Seq[Any](/*14.31*/if(factura != null)/*14.50*/{_display_(Seq[Any](_display_(Seq[Any](/*14.52*/utils/*14.57*/.NumberUtils.moneda(Factura.getTotalPorServicios(factura.id))))))}/*14.119*/else/*14.123*/{_display_(Seq[Any](format.raw/*14.124*/("""0,00""")))})),format.raw/*14.129*/("""</b></h4>
				 -->
			</div>
		</div>	
	</div>
	<div class="col-sm-9">
		<div class="panel panel-default">
			<div class="panel-heading" id="listaLineaAtributos">
				<b>Proveedor</b>
				"""),_display_(Seq[Any](/*23.6*/if(formularioCarga)/*23.25*/{_display_(Seq[Any](format.raw/*23.26*/("""
					<a class="btn btn-default btn-xs" data-href=""""),_display_(Seq[Any](/*24.52*/controllers/*24.63*/.compras.routes.ProveedorAtributosController.crear(factura.proveedor.id.toString))),format.raw/*24.144*/(""""
					href="#" id="nuevoAtributo"><i class="glyphicon glyphicon-plus"></i> Nuevo Atributo</a>
				""")))})),format.raw/*26.6*/("""
			</div>
			<div class="panel-body">
				<table id="listaDeAtributos" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Gcias</th>
							<th>Exento IVA</th>
							<th>AFIP Condicion</th>
							<th>Suss Tipo</th>
							<th>DGR Condicion</th>
							<th>Exento Sello</th>
							 
							<th>F.Ex. Gcias</th>
							<th>F.Ex. Suss</th>
							<th>F.Ex. IIBB</th>
							<th>F.Ex. Sellos</th>
							<th>Fecha Creacion</th>
							
						<tr>	
					</thead>
					<tbody>
					"""),_display_(Seq[Any](/*48.7*/if(factura != null && factura.proveedor != null && factura.proveedor.getLastAtributo() != null)/*48.102*/{_display_(Seq[Any](format.raw/*48.103*/("""
						
						"""),_display_(Seq[Any](/*50.8*/views/*50.13*/.html.compras.proveedoresAtributos.lineaAtributo(factura.proveedor.getLastAtributo(),false))),format.raw/*50.104*/("""
						
					""")))})),format.raw/*52.7*/("""
					</tbody>
				</table>
				
			</div>
		</div>	
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Otros Pagos en el mismo Mes</b></div>
			<div class="panel-body">
				"""),_display_(Seq[Any](/*65.6*/views/*65.11*/.html.contabilidad.facturas.listaFactura(Factura.facturasDelMismoMes(factura),factura))),format.raw/*65.97*/("""
			</div>
		</div>	
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Otros Pagos con sellos de la misma orden</b></div>
			<div class="panel-body">
				"""),_display_(Seq[Any](/*75.6*/views/*75.11*/.html.contabilidad.facturas.listaFactura(Factura.facturasConSellosMismaOrden(factura),factura))),format.raw/*75.105*/("""
			</div>
		</div>	
	</div>
</div>
<script>
$( function()"""),format.raw/*81.14*/("""{"""),format.raw/*81.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaAtributos");

	contenedor.on('click', '#nuevoAtributo', function()"""),format.raw/*88.53*/("""{"""),format.raw/*88.54*/("""
		/*urlContenidoModal = '/compras/linea-proveedor-atributo/crear?proveedorId='+$('#proveedorId').val();*/
		var urlContenidoModal = $(this).attr('data-href')
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*93.2*/("""}"""),format.raw/*93.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*95.28*/("""{"""),format.raw/*95.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*96.49*/("""{"""),format.raw/*96.50*/("""
			resizable: false,
		    title: "Cargar atributo",
		    height: 500,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*102.35*/("""{"""),format.raw/*102.36*/("""
				$.get(url, function(data)"""),format.raw/*103.30*/("""{"""),format.raw/*103.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""");
		    """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""",
		    close: function(event, ui )"""),format.raw/*107.34*/("""{"""),format.raw/*107.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*109.4*/("""}"""),format.raw/*109.5*/("""
		  """),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*112.58*/("""{"""),format.raw/*112.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*115.3*/("""}"""),format.raw/*115.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*117.47*/("""{"""),format.raw/*117.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*120.42*/("""{"""),format.raw/*120.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*121.45*/("""{"""),format.raw/*121.46*/("""
					$('#listaDeAtributos tbody').prepend(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*124.56*/("""{"""),format.raw/*124.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*127.5*/("""}"""),format.raw/*127.6*/(""" else """),format.raw/*127.12*/("""{"""),format.raw/*127.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*129.5*/("""}"""),format.raw/*129.6*/("""
			"""),format.raw/*130.4*/("""}"""),format.raw/*130.5*/(""");
			return false;
		"""),format.raw/*132.3*/("""}"""),format.raw/*132.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*136.2*/("""}"""),format.raw/*136.3*/("""
"""),format.raw/*137.1*/("""}"""),format.raw/*137.2*/(""");
</script>	
""")))})))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabInfoProveedor.scala.html
                    HASH: 5df0bc5824d092ff5dc1ee4310d77bcc6959524c
                    MATRIX: 839->1|1018->97|1050->121|1124->78|1152->165|1190->169|1217->188|1255->189|1480->378|1533->422|1581->424|1595->429|1668->475|1752->523|1780->542|1828->544|1842->549|1915->608|1929->612|1969->613|2007->618|2083->658|2111->677|2159->679|2173->684|2249->746|2263->750|2303->751|2341->756|2565->945|2593->964|2632->965|2720->1017|2740->1028|2844->1109|2975->1209|3519->1718|3624->1813|3664->1814|3714->1829|3728->1834|3842->1925|3887->1939|4173->2190|4187->2195|4295->2281|4562->2513|4576->2518|4693->2612|4779->2670|4808->2671|4999->2834|5028->2835|5266->3046|5294->3047|5354->3079|5383->3080|5460->3129|5489->3130|5662->3274|5692->3275|5751->3305|5781->3306|5851->3348|5880->3349|5917->3358|5946->3359|6010->3394|6040->3395|6118->3445|6147->3446|6180->3451|6209->3452|6301->3515|6331->3516|6421->3578|6450->3579|6531->3631|6561->3632|6713->3755|6743->3756|6817->3801|6847->3802|6985->3912|7014->3913|7093->3963|7123->3964|7255->4068|7284->4069|7319->4075|7349->4076|7424->4123|7453->4124|7485->4128|7514->4129|7564->4151|7593->4152|7661->4192|7690->4193|7719->4194|7748->4195
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|39->11|39->11|39->11|39->11|39->11|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|51->23|51->23|51->23|52->24|52->24|52->24|54->26|76->48|76->48|76->48|78->50|78->50|78->50|80->52|93->65|93->65|93->65|103->75|103->75|103->75|109->81|109->81|116->88|116->88|121->93|121->93|123->95|123->95|124->96|124->96|130->102|130->102|131->103|131->103|133->105|133->105|134->106|134->106|135->107|135->107|137->109|137->109|138->110|138->110|140->112|140->112|143->115|143->115|145->117|145->117|148->120|148->120|149->121|149->121|152->124|152->124|152->124|152->124|155->127|155->127|155->127|155->127|157->129|157->129|158->130|158->130|160->132|160->132|164->136|164->136|165->137|165->137
                    -- GENERATED --
                */
            