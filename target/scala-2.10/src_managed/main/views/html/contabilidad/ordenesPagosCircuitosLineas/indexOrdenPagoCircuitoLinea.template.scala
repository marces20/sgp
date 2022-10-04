
package views.html.contabilidad.ordenesPagosCircuitosLineas

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
object indexOrdenPagoCircuitoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[utils.pagination.Pagination[OrdenPagoCircuitoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[OrdenPagoCircuitoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.67*/("""
<div id="listaOrdenPagoCircuitoLineas" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Orden Pago Circuito Linea</b>
	 
</p>

<table id="listaDeOrdenPagoCircuitoLineas" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Id</th> 
			<th>Referencia</th>
			<th>Proveedor</th>
			<th>Periodo</th>
			<th>Total</th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*20.3*/for(linea <- paginador.getList) yield /*20.34*/ {_display_(Seq[Any](format.raw/*20.36*/("""
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.contabilidad.ordenesPagosCircuitosLineas.lineaOrdenPagoCircuitoLinea(linea))),format.raw/*21.90*/("""
	""")))})),format.raw/*22.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*27.6*/views/*27.11*/.html.helpers.paginador(paginador, controllers.contabilidad.routes.OrdenesPagosCircuitosLineasController.index()))),format.raw/*27.124*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*32.14*/("""{"""),format.raw/*32.15*/("""
	/**
	 * Ventana de carga linea de  Pagos en pago
	 */
	 
	var contenedor = $("#listaOrdenPagoCircuitoLineas");

	 
	/* function mostrarModal(url)"""),format.raw/*40.31*/("""{"""),format.raw/*40.32*/("""
		modalCargaPagos = $('<div></div>').dialog("""),format.raw/*41.45*/("""{"""),format.raw/*41.46*/("""
			resizable: false,
		    title: "Cargar pago",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*47.35*/("""{"""),format.raw/*47.36*/("""
				$.get(url, function(data)"""),format.raw/*48.30*/("""{"""),format.raw/*48.31*/("""
					modalCargaPagos.html(data);
				"""),format.raw/*50.5*/("""}"""),format.raw/*50.6*/(""");
		    """),format.raw/*51.7*/("""}"""),format.raw/*51.8*/(""",
		    close: function(event, ui )"""),format.raw/*52.34*/("""{"""),format.raw/*52.35*/("""
		    	modalCargaPagos.dialog('destroy');
			"""),format.raw/*54.4*/("""}"""),format.raw/*54.5*/("""
		  """),format.raw/*55.5*/("""}"""),format.raw/*55.6*/(""");
		
		modalCargaPagos.on('click', '.cancelar', function()"""),format.raw/*57.54*/("""{"""),format.raw/*57.55*/("""
			modalCargaPagos.dialog('destroy');
			return false;
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
		
		modalCargaPagos.on('submit', function(e)"""),format.raw/*62.43*/("""{"""),format.raw/*62.44*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*65.42*/("""{"""),format.raw/*65.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*66.45*/("""{"""),format.raw/*66.46*/("""
					$('#listaDePagos tbody').prepend(resultado.html);
					modalCargaPagos.dialog( "destroy" );
				"""),format.raw/*69.5*/("""}"""),format.raw/*69.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*69.56*/("""{"""),format.raw/*69.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaPagos.dialog( "destroy" );
				"""),format.raw/*72.5*/("""}"""),format.raw/*72.6*/(""" else """),format.raw/*72.12*/("""{"""),format.raw/*72.13*/("""
					modalCargaPagos.html(resultado);
				"""),format.raw/*74.5*/("""}"""),format.raw/*74.6*/("""
			"""),format.raw/*75.4*/("""}"""),format.raw/*75.5*/(""");
			return false;
		"""),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
		
		
		return modalCargaPagos;
	"""),format.raw/*81.2*/("""}"""),format.raw/*81.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*84.49*/("""{"""),format.raw/*84.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*87.38*/("""{"""),format.raw/*87.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*89.3*/("""}"""),format.raw/*89.4*/(""");
		return false;
	"""),format.raw/*91.2*/("""}"""),format.raw/*91.3*/(""");*/
"""),format.raw/*92.1*/("""}"""),format.raw/*92.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[OrdenPagoCircuitoLinea]): play.api.templates.HtmlFormat.Appendable = apply(paginador)
    
    def f:((utils.pagination.Pagination[OrdenPagoCircuitoLinea]) => play.api.templates.HtmlFormat.Appendable) = (paginador) => apply(paginador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitosLineas/indexOrdenPagoCircuitoLinea.scala.html
                    HASH: d77e24bb0727a16a7a0860e1a88157cb38b2cd63
                    MATRIX: 882->1|1041->66|1457->447|1504->478|1544->480|1584->485|1597->490|1700->571|1735->575|1837->642|1851->647|1987->760|2058->803|2087->804|2270->959|2299->960|2373->1006|2402->1007|2576->1153|2605->1154|2664->1185|2693->1186|2760->1226|2788->1227|2825->1237|2853->1238|2917->1274|2946->1275|3021->1323|3049->1324|3082->1330|3110->1331|3199->1392|3228->1393|3316->1454|3344->1455|3422->1505|3451->1506|3605->1632|3634->1633|3708->1679|3737->1680|3869->1785|3897->1786|3975->1836|4004->1837|4134->1940|4162->1941|4196->1947|4225->1948|4297->1993|4325->1994|4357->1999|4385->2000|4436->2024|4464->2025|4531->2065|4559->2066|4643->2122|4672->2123|4812->2235|4841->2236|4908->2276|4936->2277|4985->2299|5013->2300|5046->2306|5074->2307
                    LINES: 26->1|29->1|48->20|48->20|48->20|49->21|49->21|49->21|50->22|55->27|55->27|55->27|60->32|60->32|68->40|68->40|69->41|69->41|75->47|75->47|76->48|76->48|78->50|78->50|79->51|79->51|80->52|80->52|82->54|82->54|83->55|83->55|85->57|85->57|88->60|88->60|90->62|90->62|93->65|93->65|94->66|94->66|97->69|97->69|97->69|97->69|100->72|100->72|100->72|100->72|102->74|102->74|103->75|103->75|105->77|105->77|109->81|109->81|112->84|112->84|115->87|115->87|117->89|117->89|119->91|119->91|120->92|120->92
                    -- GENERATED --
                */
            