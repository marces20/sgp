
package views.html.compras.cajaChica.movimientos

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
object listaMovimientos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[CajaChicaMovimiento],Boolean,CajaChica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[CajaChicaMovimiento],  editable: Boolean,cc:CajaChica):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var saldoTotal=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.69*/("""
"""),format.raw/*3.1*/("""


"""),_display_(Seq[Any](/*6.2*/{saldoTotal = cc.monto_limite})),format.raw/*6.32*/("""
<div id="listaLineaMovimientos" class="contenedorPaginador ajaxPaginador">

<p>
	"""),_display_(Seq[Any](/*10.3*/if(editable)/*10.15*/{_display_(Seq[Any](format.raw/*10.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoMovimiento"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*12.3*/("""
</p>



<table id="listaDeProductos" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*20.5*/if(editable)/*20.17*/{_display_(Seq[Any](format.raw/*20.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*22.5*/("""
			<th>Proveedor</th>
			<th>Producto</th>
			<th>N°F</th>
			<th>Fecha Rendicion</th>
			<th>Cuenta analitica</th>
			<th>UDM</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Total</th>
			"""),_display_(Seq[Any](/*32.5*/if(!editable)/*32.18*/{_display_(Seq[Any](format.raw/*32.19*/("""<th>Saldo</th>""")))})),format.raw/*32.34*/("""
			"""),_display_(Seq[Any](/*33.5*/if(editable)/*33.17*/{_display_(Seq[Any](format.raw/*33.18*/("""
				<th></th>
			""")))})),format.raw/*35.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*39.3*/for(linea <- lista) yield /*39.22*/ {_display_(Seq[Any](format.raw/*39.24*/("""
		"""),_display_(Seq[Any](/*40.4*/{saldoTotal = saldoTotal.subtract(linea.getTotal())})),format.raw/*40.56*/("""
		"""),_display_(Seq[Any](/*41.4*/views/*41.9*/.html.compras.cajaChica.movimientos.lineaMovimiento(linea, editable,saldoTotal))),format.raw/*41.88*/("""
		 
		
	""")))})),format.raw/*44.3*/("""
	</tbody>
</table>

</div>



<script type="text/javascript">

$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaMovimientos");

	contenedor.on('click', '#nuevoMovimiento', function()"""),format.raw/*61.55*/("""{"""),format.raw/*61.56*/("""
		urlContenidoModal = '/compras/caja-chica-movimientos/crear?cajaId='+$('#cajaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/(""");
	
	contenedor.on('click', '.modificarMovimiento', function()"""),format.raw/*67.59*/("""{"""),format.raw/*67.60*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*72.2*/("""}"""),format.raw/*72.3*/(""");
	
	contenedor.on('click', '.eliminarMovimmiento', function()"""),format.raw/*74.59*/("""{"""),format.raw/*74.60*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*76.23*/("""{"""),format.raw/*76.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*79.29*/("""{"""),format.raw/*79.30*/("""
				if(data.success)"""),format.raw/*80.21*/("""{"""),format.raw/*80.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""" else """),format.raw/*82.12*/("""{"""),format.raw/*82.13*/("""
					alert(data.messagge);
				"""),format.raw/*84.5*/("""}"""),format.raw/*84.6*/("""
			"""),format.raw/*85.4*/("""}"""),format.raw/*85.5*/(""");
		"""),format.raw/*86.3*/("""}"""),format.raw/*86.4*/("""
		return false;
	"""),format.raw/*88.2*/("""}"""),format.raw/*88.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*90.28*/("""{"""),format.raw/*90.29*/("""
		modalCargaMovimiento = $('<div></div>').dialog("""),format.raw/*91.50*/("""{"""),format.raw/*91.51*/("""
			resizable: false,
		    title: "Cargar movimiento",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*97.35*/("""{"""),format.raw/*97.36*/("""
				$.get(url, function(data)"""),format.raw/*98.30*/("""{"""),format.raw/*98.31*/("""
					modalCargaMovimiento.html(data);
				"""),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");
		    """),format.raw/*101.7*/("""}"""),format.raw/*101.8*/(""",
		    close: function(event, ui )"""),format.raw/*102.34*/("""{"""),format.raw/*102.35*/("""
		    	modalCargaMovimiento.dialog('destroy');
			"""),format.raw/*104.4*/("""}"""),format.raw/*104.5*/("""
		  """),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""");
		
		modalCargaMovimiento.on('click', '.cancelar', function()"""),format.raw/*107.59*/("""{"""),format.raw/*107.60*/("""
			modalCargaMovimiento.dialog('destroy');
			return false;
		"""),format.raw/*110.3*/("""}"""),format.raw/*110.4*/(""");
		
		modalCargaMovimiento.on('submit', function(e)"""),format.raw/*112.48*/("""{"""),format.raw/*112.49*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*115.42*/("""{"""),format.raw/*115.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*116.45*/("""{"""),format.raw/*116.46*/("""
					$('#listaLineaMovimientos tbody').prepend(resultado.html);
					modalCargaMovimiento.dialog( "destroy" );
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*119.56*/("""{"""),format.raw/*119.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaMovimiento.dialog( "destroy" );
				"""),format.raw/*122.5*/("""}"""),format.raw/*122.6*/(""" else """),format.raw/*122.12*/("""{"""),format.raw/*122.13*/("""
					modalCargaMovimiento.html(resultado);
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/("""
			"""),format.raw/*125.4*/("""}"""),format.raw/*125.5*/(""");
			return false;
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/(""");
		
		
		return modalCargaMovimiento;
	"""),format.raw/*131.2*/("""}"""),format.raw/*131.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*134.49*/("""{"""),format.raw/*134.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*137.38*/("""{"""),format.raw/*137.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*139.3*/("""}"""),format.raw/*139.4*/(""");
		return false;
	"""),format.raw/*141.2*/("""}"""),format.raw/*141.3*/(""");
"""),format.raw/*142.1*/("""}"""),format.raw/*142.2*/(""");
</script>
"""))}
    }
    
    def render(lista:List[CajaChicaMovimiento],editable:Boolean,cc:CajaChica): play.api.templates.HtmlFormat.Appendable = apply(lista,editable,cc)
    
    def f:((List[CajaChicaMovimiento],Boolean,CajaChica) => play.api.templates.HtmlFormat.Appendable) = (lista,editable,cc) => apply(lista,editable,cc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/movimientos/listaMovimientos.scala.html
                    HASH: dab514194979fd3211ba7c4d4ac513247ce1b478
                    MATRIX: 852->1|1086->68|1114->144|1155->151|1206->181|1328->268|1349->280|1388->281|1543->405|1688->515|1709->527|1748->528|1823->572|2063->777|2085->790|2124->791|2171->806|2212->812|2233->824|2272->825|2324->846|2393->880|2428->899|2468->901|2508->906|2582->958|2622->963|2635->968|2736->1047|2780->1060|2895->1147|2924->1148|3126->1322|3155->1323|3329->1470|3357->1471|3450->1536|3479->1537|3677->1708|3705->1709|3798->1774|3827->1775|3941->1861|3970->1862|4085->1949|4114->1950|4164->1972|4193->1973|4262->2015|4290->2016|4324->2022|4353->2023|4414->2057|4442->2058|4474->2063|4502->2064|4535->2070|4563->2071|4610->2091|4638->2092|4700->2126|4729->2127|4808->2178|4837->2179|5017->2331|5046->2332|5105->2363|5134->2364|5207->2409|5236->2410|5274->2420|5303->2421|5368->2457|5398->2458|5479->2511|5508->2512|5542->2518|5571->2519|5666->2585|5696->2586|5790->2652|5819->2653|5903->2708|5933->2709|6088->2835|6118->2836|6193->2882|6223->2883|6370->3002|6399->3003|6478->3053|6508->3054|6644->3162|6673->3163|6708->3169|6738->3170|6816->3220|6845->3221|6878->3226|6907->3227|6959->3251|6988->3252|7061->3297|7090->3298|7175->3354|7205->3355|7346->3467|7376->3468|7444->3508|7473->3509|7523->3531|7552->3532|7584->3536|7613->3537
                    LINES: 26->1|30->1|31->3|34->6|34->6|38->10|38->10|38->10|40->12|48->20|48->20|48->20|50->22|60->32|60->32|60->32|60->32|61->33|61->33|61->33|63->35|67->39|67->39|67->39|68->40|68->40|69->41|69->41|69->41|72->44|82->54|82->54|89->61|89->61|93->65|93->65|95->67|95->67|100->72|100->72|102->74|102->74|104->76|104->76|107->79|107->79|108->80|108->80|110->82|110->82|110->82|110->82|112->84|112->84|113->85|113->85|114->86|114->86|116->88|116->88|118->90|118->90|119->91|119->91|125->97|125->97|126->98|126->98|128->100|128->100|129->101|129->101|130->102|130->102|132->104|132->104|133->105|133->105|135->107|135->107|138->110|138->110|140->112|140->112|143->115|143->115|144->116|144->116|147->119|147->119|147->119|147->119|150->122|150->122|150->122|150->122|152->124|152->124|153->125|153->125|155->127|155->127|159->131|159->131|162->134|162->134|165->137|165->137|167->139|167->139|169->141|169->141|170->142|170->142
                    -- GENERATED --
                */
            