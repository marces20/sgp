
package views.html.dashboard.autorizadosLineas

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
object indexAutorizadoLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AutorizadoLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AutorizadoLinea], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.79*/("""
<div id="listaLineaAutorizados" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Autorizados</b>
</p>
"""),_display_(Seq[Any](/*7.2*/if(paginador.getTotalRowCount() > 0)/*7.38*/ {_display_(Seq[Any](format.raw/*7.40*/("""
	Mostrando """),_display_(Seq[Any](/*8.13*/paginador/*8.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*8.54*/(""" resultado(s).
""")))})),format.raw/*9.2*/("""
<table id="listaDeAutorizados" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>OP</th>
			<th>Cuenta</th>
			<th>Exp.</th>
			<th>Proveedor</th>
			<th>Monto</th>
			<th>Actas</th>
			"""),_display_(Seq[Any](/*19.5*/if(editable)/*19.17*/{_display_(Seq[Any](format.raw/*19.18*/("""
				<th></th>
			""")))})),format.raw/*21.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*25.3*/for(linea <- paginador.getList) yield /*25.34*/ {_display_(Seq[Any](format.raw/*25.36*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.dashboard.autorizadosLineas.lineaAutorizado(linea, editable))),format.raw/*26.75*/("""
	""")))})),format.raw/*27.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*32.6*/views/*32.11*/.html.helpers.paginador(paginador, controllers.dashboard.routes.AutorizadoLineasController.index()))),format.raw/*32.110*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*37.14*/("""{"""),format.raw/*37.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaAutorizados");

	contenedor.on('click', '.eliminarAutorizado', function()"""),format.raw/*44.58*/("""{"""),format.raw/*44.59*/("""
		var url = $(this).attr('href');
		
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*48.23*/("""{"""),format.raw/*48.24*/("""
			$this = $(this);	
			$.get(url, function(data)"""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""
				if(data.success)"""),format.raw/*51.21*/("""{"""),format.raw/*51.22*/("""
					$this.closest("tr").remove();
					actualizarDatos();
				"""),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""" else """),format.raw/*54.12*/("""{"""),format.raw/*54.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*56.5*/("""}"""),format.raw/*56.6*/("""
			"""),format.raw/*57.4*/("""}"""),format.raw/*57.5*/(""");
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/("""
		return false;
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*62.49*/("""{"""),format.raw/*62.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*65.38*/("""{"""),format.raw/*65.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""");
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
	$('.lineasActas').click( function() """),format.raw/*71.38*/("""{"""),format.raw/*71.39*/("""
		var $this = $(this);
		var url = $this.attr('href');
		var oid = $(this).data('data-id-provision');
		$.get(url, function(data) """),format.raw/*75.29*/("""{"""),format.raw/*75.30*/("""
			$this.parent().html(data);
		"""),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
		return false;
	"""),format.raw/*79.2*/("""}"""),format.raw/*79.3*/(""");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AutorizadoLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AutorizadoLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizadosLineas/indexAutorizadoLinea.scala.html
                    HASH: 1bfeab756620517655fb572c67cded9f89bbc0b6
                    MATRIX: 863->1|1034->78|1181->191|1225->227|1264->229|1313->243|1330->252|1383->284|1430->301|1680->516|1701->528|1740->529|1792->550|1861->584|1908->615|1948->617|1988->622|2001->627|2089->693|2124->697|2228->766|2242->771|2364->870|2435->913|2464->914|2669->1091|2698->1092|2851->1217|2880->1218|2960->1270|2989->1271|3039->1293|3068->1294|3162->1361|3190->1362|3224->1368|3253->1369|3336->1425|3364->1426|3396->1431|3424->1432|3457->1438|3485->1439|3532->1459|3560->1460|3643->1515|3672->1516|3812->1628|3841->1629|3908->1669|3936->1670|3985->1692|4013->1693|4085->1737|4114->1738|4277->1873|4306->1874|4368->1909|4396->1910|4445->1932|4473->1933|4504->1937|4532->1938
                    LINES: 26->1|29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|47->19|47->19|47->19|49->21|53->25|53->25|53->25|54->26|54->26|54->26|55->27|60->32|60->32|60->32|65->37|65->37|72->44|72->44|76->48|76->48|78->50|78->50|79->51|79->51|82->54|82->54|82->54|82->54|84->56|84->56|85->57|85->57|86->58|86->58|88->60|88->60|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|99->71|99->71|103->75|103->75|105->77|105->77|107->79|107->79|108->80|108->80
                    -- GENERATED --
                */
            