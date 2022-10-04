
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
object tabsFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Boolean,Boolean,Form[Factura],Factura,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean,formularioCargaImpuestos: Boolean, facturaForm: Form[Factura] = null,factura:Factura, verDetalle: Boolean = false):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.142*/("""
	
	<hr />

	<ul id="facturaTab" class="nav nav-tabs">
		<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
		
		<!--  <li><a id="tabActas" data-url=""""),_display_(Seq[Any](/*8.41*/controllers/*8.52*/.contabilidad.routes.FacturasController.actasAsociadas(factura.id))),format.raw/*8.118*/("""" href="#contenedorActas" data-toggle="tab">Actas de recepción</a></li>
		-->
		<li><a id="tabOtraInfo" href="#contenedorOtraInfo" data-toggle="tab">Otra Informacion</a></li>
		<li><a id="tabInfoRet" href="#contenedorInfoProveedor" data-toggle="tab">Info para Retenciones</a></li>
		<li><a id="tabParciales" href="#contenedorParciales" data-toggle="tab">Facturas Parciales</a></li>
		<li><a id="tabReintegros" href="#contenedorReintegros" data-toggle="tab">Reintegros</a></li>
		<li><a id="tabFacturaDatos" href="#contenedorFacturaDatos" data-toggle="tab">Numeros Facturas</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorProductos">
			"""),_display_(Seq[Any](/*18.5*/views/*18.10*/.html.contabilidad.facturas.contenidoTabProducto(formularioCarga, facturaForm))),format.raw/*18.88*/("""	
		</div>
		
		<!--  <div class="tab-pane" id="contenedorActas"></div>-->
		<div class="tab-pane" id="contenedorOtraInfo">
			"""),_display_(Seq[Any](/*23.5*/views/*23.10*/.html.contabilidad.facturas.contenidoTabOtraInfo(formularioCarga, facturaForm))),format.raw/*23.88*/("""	
		</div>
		<div class="tab-pane" id="contenedorInfoProveedor">
			<div id="contenedorInfoProveedorDiv">
			
			</div>
		</div>
		<div class="tab-pane" id="contenedorParciales">
			"""),_display_(Seq[Any](/*31.5*/views/*31.10*/.html.contabilidad.facturas.contenidoTabParciales(formularioCarga, facturaForm,factura))),format.raw/*31.97*/("""	
		</div>
		<div class="tab-pane" id="contenedorReintegros">
			"""),_display_(Seq[Any](/*34.5*/views/*34.10*/.html.contabilidad.facturas.contenidoTabReintegros(formularioCarga, facturaForm))),format.raw/*34.90*/("""	
		</div>
		<div class="tab-pane" id="contenedorFacturaDatos">
			"""),_display_(Seq[Any](/*37.5*/views/*37.10*/.html.contabilidad.facturas.contenidoTabFacturaDatos(formularioCarga, facturaForm,factura))),format.raw/*37.100*/("""	
		</div>
		

	</div>

	<hr />

	<div class="row">
		<div class="col-sm-7">
			"""),_display_(Seq[Any](/*47.5*/views/*47.10*/.html.contabilidad.facturas.contenidoTabImpuesto(formularioCargaImpuestos, facturaForm, factura))),format.raw/*47.106*/("""
		</div>
		"""),_display_(Seq[Any](/*49.4*/if(verDetalle)/*49.18*/ {_display_(Seq[Any](format.raw/*49.20*/("""
		<div class="col-sm-5">
			"""),_display_(Seq[Any](/*51.5*/views/*51.10*/.html.contabilidad.facturas.contenidoTabDetalle(formularioCarga, facturaForm,factura))),format.raw/*51.95*/("""
		</div>
		""")))})),format.raw/*53.4*/("""
	</div>
	
	<input id="formularioCargaImpuestos" value=""""),_display_(Seq[Any](/*56.47*/formularioCargaImpuestos)),format.raw/*56.71*/("""" type="hidden"/>
	
	<script>
	
	$( function () """),format.raw/*60.17*/("""{"""),format.raw/*60.18*/("""

		$('#tabInfoRet').on("click", function() """),format.raw/*62.43*/("""{"""),format.raw/*62.44*/(""" 
																						 
			var url = "/contabilidad/facturaProveedor/getInfoRetenciones?id="+$('#facturaId').val()+"&fci="+$('#formularioCargaImpuestos').val();
					
			$("#contenedorInfoProveedorDiv").html('<div class="loading"></div>');
			$.get(url, function(data)"""),format.raw/*67.29*/("""{"""),format.raw/*67.30*/("""
				$('#contenedorInfoProveedorDiv').html(data);
			"""),format.raw/*69.4*/("""}"""),format.raw/*69.5*/(""")
			 
		"""),format.raw/*71.3*/("""}"""),format.raw/*71.4*/(""");
		
		
		/*$('#tabActas').click(function () """),format.raw/*74.38*/("""{"""),format.raw/*74.39*/("""

			var url = $(this).attr("data-url");
			var href = $(this).attr("href");
			$.get(url, function(data) """),format.raw/*78.30*/("""{"""),format.raw/*78.31*/("""
				$(href).html(data);
			"""),format.raw/*80.4*/("""}"""),format.raw/*80.5*/(""");
			
		"""),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");*/
	
		$( function() """),format.raw/*84.17*/("""{"""),format.raw/*84.18*/("""
			var contenedor = $('#contenedorActas');	
			
			
			contenedor.on('click', '.eliminarActaAsociada', function()"""),format.raw/*88.62*/("""{"""),format.raw/*88.63*/("""
				var url = $(this).attr('href');
				var mensaje = "¿Confirma que desea desasociar el acta a la factura?";
				if(confirm(mensaje))"""),format.raw/*91.25*/("""{"""),format.raw/*91.26*/("""
					$this = $(this);
					$.get(url, function(data)"""),format.raw/*93.31*/("""{"""),format.raw/*93.32*/("""
						if(data.success)"""),format.raw/*94.23*/("""{"""),format.raw/*94.24*/("""
							$this.closest("tr").remove();
						"""),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""" else """),format.raw/*96.14*/("""{"""),format.raw/*96.15*/("""
							alert("No se puedo eliminar el registro.");
						"""),format.raw/*98.7*/("""}"""),format.raw/*98.8*/("""
					"""),format.raw/*99.6*/("""}"""),format.raw/*99.7*/(""");
				"""),format.raw/*100.5*/("""}"""),format.raw/*100.6*/("""
				return false;
			"""),format.raw/*102.4*/("""}"""),format.raw/*102.5*/(""");

			modalSeleccionActa = $('<div></div>');
			
			contenedor.on('click', '#cargarActa', function()"""),format.raw/*106.52*/("""{"""),format.raw/*106.53*/("""
				var url = $(this).attr('href');
				modalSeleccionActa = $('<div></div>').dialog("""),format.raw/*108.50*/("""{"""),format.raw/*108.51*/("""
					resizable: false,
				    title: "Seleccionar acta",
				    height: 400,
				    width: 750,
				    modal: false,
				    open: function( event, ui ) """),format.raw/*114.37*/("""{"""),format.raw/*114.38*/("""
						$.get(url, function(data)"""),format.raw/*115.32*/("""{"""),format.raw/*115.33*/("""
							modalSeleccionActa.html(data);
						"""),format.raw/*117.7*/("""}"""),format.raw/*117.8*/(""");
				    """),format.raw/*118.9*/("""}"""),format.raw/*118.10*/(""",
				    close: function(event, ui )"""),format.raw/*119.36*/("""{"""),format.raw/*119.37*/("""
				    	modalSeleccionActa.dialog('destroy');
					"""),format.raw/*121.6*/("""}"""),format.raw/*121.7*/("""
				  """),format.raw/*122.7*/("""}"""),format.raw/*122.8*/(""");
				return false;
			"""),format.raw/*124.4*/("""}"""),format.raw/*124.5*/(""");


			
			modalSeleccionActa.on('click', '.cancelar', function()"""),format.raw/*128.58*/("""{"""),format.raw/*128.59*/("""
				modalSeleccionActa.dialog('destroy');
				return false;
			"""),format.raw/*131.4*/("""}"""),format.raw/*131.5*/(""");
			
			
		"""),format.raw/*134.3*/("""}"""),format.raw/*134.4*/(""");

	
"""),format.raw/*137.1*/("""}"""),format.raw/*137.2*/(""");

</script>
"""))}
    }
    
    def render(formularioCarga:Boolean,formularioCargaImpuestos:Boolean,facturaForm:Form[Factura],factura:Factura,verDetalle:Boolean): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,formularioCargaImpuestos,facturaForm,factura,verDetalle)
    
    def f:((Boolean,Boolean,Form[Factura],Factura,Boolean) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,formularioCargaImpuestos,facturaForm,factura,verDetalle) => apply(formularioCarga,formularioCargaImpuestos,facturaForm,factura,verDetalle)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/tabsFactura.scala.html
                    HASH: c6e1833dbab9dbfdfb2338c30efc4216ac4910a3
                    MATRIX: 841->1|1076->141|1325->355|1344->366|1432->432|2154->1119|2168->1124|2268->1202|2436->1335|2450->1340|2550->1418|2776->1609|2790->1614|2899->1701|3003->1770|3017->1775|3119->1855|3225->1926|3239->1931|3352->2021|3478->2112|3492->2117|3611->2213|3661->2228|3684->2242|3724->2244|3791->2276|3805->2281|3912->2366|3958->2381|4054->2441|4100->2465|4180->2517|4209->2518|4283->2564|4312->2565|4615->2840|4644->2841|4726->2896|4754->2897|4792->2908|4820->2909|4897->2958|4926->2959|5064->3069|5093->3070|5150->3100|5178->3101|5216->3112|5244->3113|5297->3138|5326->3139|5472->3257|5501->3258|5667->3396|5696->3397|5779->3452|5808->3453|5860->3477|5889->3478|5962->3524|5990->3525|6024->3531|6053->3532|6140->3592|6168->3593|6202->3600|6230->3601|6266->3609|6295->3610|6347->3634|6376->3635|6510->3740|6540->3741|6657->3829|6687->3830|6880->3994|6910->3995|6972->4028|7002->4029|7077->4076|7106->4077|7146->4089|7176->4090|7243->4128|7273->4129|7356->4184|7385->4185|7421->4193|7450->4194|7504->4220|7533->4221|7632->4291|7662->4292|7757->4359|7786->4360|7830->4376|7859->4377|7896->4386|7925->4387
                    LINES: 26->1|29->1|36->8|36->8|36->8|46->18|46->18|46->18|51->23|51->23|51->23|59->31|59->31|59->31|62->34|62->34|62->34|65->37|65->37|65->37|75->47|75->47|75->47|77->49|77->49|77->49|79->51|79->51|79->51|81->53|84->56|84->56|88->60|88->60|90->62|90->62|95->67|95->67|97->69|97->69|99->71|99->71|102->74|102->74|106->78|106->78|108->80|108->80|110->82|110->82|112->84|112->84|116->88|116->88|119->91|119->91|121->93|121->93|122->94|122->94|124->96|124->96|124->96|124->96|126->98|126->98|127->99|127->99|128->100|128->100|130->102|130->102|134->106|134->106|136->108|136->108|142->114|142->114|143->115|143->115|145->117|145->117|146->118|146->118|147->119|147->119|149->121|149->121|150->122|150->122|152->124|152->124|156->128|156->128|159->131|159->131|162->134|162->134|165->137|165->137
                    -- GENERATED --
                */
            