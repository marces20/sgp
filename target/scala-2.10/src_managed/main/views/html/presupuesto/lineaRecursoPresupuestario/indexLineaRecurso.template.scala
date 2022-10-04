
package views.html.presupuesto.lineaRecursoPresupuestario

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
object indexLineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[LineaRecursoPresupuestario],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[LineaRecursoPresupuestario], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.90*/("""
<div id="listaLineaRecursoPresupuestario" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Recursos</b>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoRecurso"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>

<table id="listaDeLineaRecursoPresupuestario" class="table table-striped table-bordered">
	<thead>
		<tr>
			"""),_display_(Seq[Any](/*14.5*/if(editable)/*14.17*/{_display_(Seq[Any](format.raw/*14.18*/("""
				<th class="accion-editar">#</th>
			""")))})),format.raw/*16.5*/("""
			<th>Cuenta Analitica</th>
			<th>Monto</th>
			<th>Observacion</th>
			"""),_display_(Seq[Any](/*20.5*/if(editable)/*20.17*/{_display_(Seq[Any](format.raw/*20.18*/("""
				<th></th>
			""")))})),format.raw/*22.5*/("""
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*26.3*/for(linea <- paginador.getList) yield /*26.34*/ {_display_(Seq[Any](format.raw/*26.36*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.presupuesto.lineaRecursoPresupuestario.lineaRecurso(linea, editable))),format.raw/*27.83*/("""
	""")))})),format.raw/*28.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*33.6*/views/*33.11*/.html.helpers.paginador(paginador, controllers.presupuesto.routes.LineasRecursosPresupuestariosController.index()))),format.raw/*33.125*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*38.14*/("""{"""),format.raw/*38.15*/("""
	/**
	 * Ventana de carga linea de recursos en presupuesto
	 */
	 
	var contenedor = $("#listaLineaRecursoPresupuestario");

	contenedor.on('click', '#nuevoRecurso', function()"""),format.raw/*45.52*/("""{"""),format.raw/*45.53*/("""
		urlContenidoModal = '/presupuesto/linea-recurso/crear?creditoPresupuestarioId='+$('#creditoPresupuestarioId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*49.2*/("""}"""),format.raw/*49.3*/(""");
	
	contenedor.on('click', '.modificarRecurso', function()"""),format.raw/*51.56*/("""{"""),format.raw/*51.57*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Recurso');	
		return false;
	"""),format.raw/*56.2*/("""}"""),format.raw/*56.3*/(""");
	
	contenedor.on('click', '.eliminarRecurso', function()"""),format.raw/*58.55*/("""{"""),format.raw/*58.56*/("""
		var url = $(this).attr('href');
		$this = $(this);
		$.get(url, function(data)"""),format.raw/*61.28*/("""{"""),format.raw/*61.29*/("""
			if(data.success)"""),format.raw/*62.20*/("""{"""),format.raw/*62.21*/("""
				$this.closest("tr").remove();
			"""),format.raw/*64.4*/("""}"""),format.raw/*64.5*/(""" else """),format.raw/*64.11*/("""{"""),format.raw/*64.12*/("""
				alert("No se puedo eliminar el registro.");
			"""),format.raw/*66.4*/("""}"""),format.raw/*66.5*/("""
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""");
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*71.28*/("""{"""),format.raw/*71.29*/("""
		modalCargaRecursos = $('<div></div>').dialog("""),format.raw/*72.48*/("""{"""),format.raw/*72.49*/("""
			resizable: false,
		    title: "Cargar Recursos",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*78.35*/("""{"""),format.raw/*78.36*/("""
				$.get(url, function(data)"""),format.raw/*79.30*/("""{"""),format.raw/*79.31*/("""
					modalCargaRecursos.html(data);
				"""),format.raw/*81.5*/("""}"""),format.raw/*81.6*/(""");
		    """),format.raw/*82.7*/("""}"""),format.raw/*82.8*/(""",
		    close: function(event, ui )"""),format.raw/*83.34*/("""{"""),format.raw/*83.35*/("""
		    	modalCargaRecursos.dialog('destroy');
			"""),format.raw/*85.4*/("""}"""),format.raw/*85.5*/("""
		  """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/(""");
		
		modalCargaRecursos.on('click', '.cancelar', function()"""),format.raw/*88.57*/("""{"""),format.raw/*88.58*/("""
			modalCargaRecursos.dialog('destroy');
			return false;
		"""),format.raw/*91.3*/("""}"""),format.raw/*91.4*/(""");
		
		modalCargaRecursos.on('submit', function(e)"""),format.raw/*93.46*/("""{"""),format.raw/*93.47*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*96.42*/("""{"""),format.raw/*96.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*97.45*/("""{"""),format.raw/*97.46*/("""
					$('#listaDeLineaRecursoPresupuestario tbody').prepend(resultado.html);
					modalCargaRecursos.dialog( "destroy" );
				"""),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*100.56*/("""{"""),format.raw/*100.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaRecursos.dialog( "destroy" );
				"""),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""" else """),format.raw/*103.12*/("""{"""),format.raw/*103.13*/("""
					modalCargaRecursos.html(resultado);
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/("""
			"""),format.raw/*106.4*/("""}"""),format.raw/*106.5*/(""");
			return false;
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""");
		
		
		return modalCargaRecursos;
	"""),format.raw/*112.2*/("""}"""),format.raw/*112.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*115.49*/("""{"""),format.raw/*115.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*118.38*/("""{"""),format.raw/*118.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");
		return false;
	"""),format.raw/*122.2*/("""}"""),format.raw/*122.3*/(""");
"""),format.raw/*123.1*/("""}"""),format.raw/*123.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[LineaRecursoPresupuestario],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[LineaRecursoPresupuestario],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/indexLineaRecurso.scala.html
                    HASH: 0dbbf992bdcfd7919ca2fbb03056ac32de940fbe
                    MATRIX: 882->1|1064->89|1213->204|1233->216|1271->217|1422->338|1580->461|1601->473|1640->474|1715->518|1830->598|1851->610|1890->611|1942->632|2011->666|2058->697|2098->699|2138->704|2151->709|2247->783|2282->787|2384->854|2398->859|2535->973|2606->1016|2635->1017|2847->1201|2876->1202|3079->1378|3107->1379|3197->1441|3226->1442|3423->1612|3451->1613|3540->1674|3569->1675|3681->1759|3710->1760|3759->1781|3788->1782|3855->1822|3883->1823|3917->1829|3946->1830|4027->1884|4055->1885|4086->1889|4114->1890|4163->1912|4191->1913|4253->1947|4282->1948|4359->1997|4388->1998|4566->2148|4595->2149|4654->2180|4683->2181|4753->2224|4781->2225|4818->2235|4846->2236|4910->2272|4939->2273|5017->2324|5045->2325|5078->2331|5106->2332|5198->2396|5227->2397|5318->2461|5346->2462|5427->2515|5456->2516|5610->2642|5639->2643|5713->2689|5742->2690|5899->2819|5928->2820|6007->2870|6037->2871|6171->2977|6200->2978|6235->2984|6265->2985|6341->3033|6370->3034|6403->3039|6432->3040|6484->3064|6513->3065|6584->3108|6613->3109|6698->3165|6728->3166|6869->3278|6899->3279|6967->3319|6996->3320|7046->3342|7075->3343|7107->3347|7136->3348
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|42->14|42->14|42->14|44->16|48->20|48->20|48->20|50->22|54->26|54->26|54->26|55->27|55->27|55->27|56->28|61->33|61->33|61->33|66->38|66->38|73->45|73->45|77->49|77->49|79->51|79->51|84->56|84->56|86->58|86->58|89->61|89->61|90->62|90->62|92->64|92->64|92->64|92->64|94->66|94->66|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72|106->78|106->78|107->79|107->79|109->81|109->81|110->82|110->82|111->83|111->83|113->85|113->85|114->86|114->86|116->88|116->88|119->91|119->91|121->93|121->93|124->96|124->96|125->97|125->97|128->100|128->100|128->100|128->100|131->103|131->103|131->103|131->103|133->105|133->105|134->106|134->106|136->108|136->108|140->112|140->112|143->115|143->115|146->118|146->118|148->120|148->120|150->122|150->122|151->123|151->123
                    -- GENERATED --
                */
            