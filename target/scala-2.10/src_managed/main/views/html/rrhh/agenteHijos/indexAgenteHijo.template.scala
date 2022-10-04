
package views.html.rrhh.agenteHijos

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
object indexAgenteHijo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteHijo],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteHijo], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.74*/("""
"""),format.raw/*3.1*/("""
<div id="listaAgenteHijo" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Hijos</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("crearAgenteHijo"))/*8.53*/{_display_(Seq[Any](format.raw/*8.54*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteHijo"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			""")))})),format.raw/*10.5*/("""
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*14.3*/if(paginador.getTotalRowCount == 0)/*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
        <p id="mensajeSinResultadosHijo" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay hijos cargados.</p>
    """)))})),format.raw/*16.6*/(""" 

	<table id="listaDeAgenteHijo" class="table table-striped table-bordered  """),_display_(Seq[Any](/*18.76*/if(paginador.getTotalRowCount() <= 0)/*18.113*/{_display_(Seq[Any](format.raw/*18.114*/("""hide""")))})),format.raw/*18.119*/("""">
		<thead>
			<tr>
				"""),_display_(Seq[Any](/*21.6*/if(editable && Permiso.check("editarAgenteHijo"))/*21.55*/{_display_(Seq[Any](format.raw/*21.56*/("""
					<th class="accion-editar">#</th>
				""")))})),format.raw/*23.6*/("""
					<th>Nombre</th>
					<th>Dni</th>
					<th>Edad</th>
					<th>Nivel Estudio</th>
					<th>Estado Estudio</th>
					
				"""),_display_(Seq[Any](/*30.6*/if(editable && Permiso.check("eliminarAgenteHijo"))/*30.57*/{_display_(Seq[Any](format.raw/*30.58*/("""
					<th></th>
				""")))})),format.raw/*32.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*36.4*/for(linea <- paginador.getList) yield /*36.35*/ {_display_(Seq[Any](format.raw/*36.37*/("""
			"""),_display_(Seq[Any](/*37.5*/views/*37.10*/.html.rrhh.agenteHijos.lineaAgenteHijo(linea, editable))),format.raw/*37.65*/("""
		""")))})),format.raw/*38.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*45.9*/views/*45.14*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesHijosController.index()))),format.raw/*45.104*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	 
	 
	var contenedor = $("#listaAgenteHijo");
						     
	contenedor.on('click', '#nuevoAgenteHijo', function()"""),format.raw/*58.55*/("""{"""),format.raw/*58.56*/("""
		urlContenidoModal = '/rrhh/agente-hijo/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.on('click', '.modificarAgenteHijo', function()"""),format.raw/*64.59*/("""{"""),format.raw/*64.60*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar hijo');	
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteHijo', function()"""),format.raw/*71.58*/("""{"""),format.raw/*71.59*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*73.23*/("""{"""),format.raw/*73.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*76.29*/("""{"""),format.raw/*76.30*/("""
				if(data.success)"""),format.raw/*77.21*/("""{"""),format.raw/*77.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*79.5*/("""}"""),format.raw/*79.6*/(""" else """),format.raw/*79.12*/("""{"""),format.raw/*79.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*81.5*/("""}"""),format.raw/*81.6*/("""
			"""),format.raw/*82.4*/("""}"""),format.raw/*82.5*/(""");
		"""),format.raw/*83.3*/("""}"""),format.raw/*83.4*/("""
		return false;
	"""),format.raw/*85.2*/("""}"""),format.raw/*85.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*87.28*/("""{"""),format.raw/*87.29*/("""
		modalCargaAgenteHijo = $('<div></div>').dialog("""),format.raw/*88.50*/("""{"""),format.raw/*88.51*/("""
			resizable: false,
		    title: "Cargar Hijos",
		    height: 600,
		    minHeight:600,
		    width: 900,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*95.35*/("""{"""),format.raw/*95.36*/("""
				$.get(url, function(data)"""),format.raw/*96.30*/("""{"""),format.raw/*96.31*/("""
					modalCargaAgenteHijo.html(data);
				"""),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");
		    """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""",
		    close: function(event, ui )"""),format.raw/*100.34*/("""{"""),format.raw/*100.35*/("""
		    	modalCargaAgenteHijo.dialog('destroy');
			"""),format.raw/*102.4*/("""}"""),format.raw/*102.5*/("""
		  """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
		
		modalCargaAgenteHijo.on('click', '.cancelar', function()"""),format.raw/*105.59*/("""{"""),format.raw/*105.60*/("""
			modalCargaAgenteHijo.dialog('destroy');
			return false;
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""");
		
		modalCargaAgenteHijo.on('submit', function(e)"""),format.raw/*110.48*/("""{"""),format.raw/*110.49*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*113.42*/("""{"""),format.raw/*113.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*114.45*/("""{"""),format.raw/*114.46*/("""
					$('#listaDeAgenteHijo tbody').prepend(resultado.html);
					$('#mensajeSinResultadosHijo').remove();
					$('#listaDeAgenteHijo').removeClass('hide');
					modalCargaAgenteHijo.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*120.5*/("""}"""),format.raw/*120.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*120.56*/("""{"""),format.raw/*120.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaAgenteHijo.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*125.5*/("""}"""),format.raw/*125.6*/(""" else """),format.raw/*125.12*/("""{"""),format.raw/*125.13*/("""
					modalCargaAgenteHijo.html(resultado);
				"""),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""
			"""),format.raw/*128.4*/("""}"""),format.raw/*128.5*/(""");
			return false;
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");
		
		
		return modalCargaAgenteHijo;
	"""),format.raw/*134.2*/("""}"""),format.raw/*134.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*137.49*/("""{"""),format.raw/*137.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*140.38*/("""{"""),format.raw/*140.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*142.3*/("""}"""),format.raw/*142.4*/(""");
		return false;
	"""),format.raw/*144.2*/("""}"""),format.raw/*144.3*/(""");
"""),format.raw/*145.1*/("""}"""),format.raw/*145.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteHijo],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteHijo],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteHijos/indexAgenteHijo.scala.html
                    HASH: ad7834cceaa9f127d91a0979cafcc0b266001ffa
                    MATRIX: 842->1|1030->73|1058->98|1251->257|1307->305|1345->306|1504->434|1585->480|1629->515|1669->517|1835->652|1951->732|1998->769|2038->770|2076->775|2140->804|2198->853|2237->854|2314->900|2483->1034|2543->1085|2582->1086|2636->1109|2709->1147|2756->1178|2796->1180|2837->1186|2851->1191|2928->1246|2964->1251|3080->1332|3094->1337|3207->1427|3302->1494|3331->1495|3478->1614|3507->1615|3671->1752|3699->1753|3792->1818|3821->1819|4015->1986|4043->1987|4135->2051|4164->2052|4278->2138|4307->2139|4422->2226|4451->2227|4501->2249|4530->2250|4599->2292|4627->2293|4661->2299|4690->2300|4773->2356|4801->2357|4833->2362|4861->2363|4894->2369|4922->2370|4969->2390|4997->2391|5059->2425|5088->2426|5167->2477|5196->2478|5393->2647|5422->2648|5481->2679|5510->2680|5582->2725|5610->2726|5647->2736|5675->2737|5740->2773|5770->2774|5851->2827|5880->2828|5914->2834|5943->2835|6038->2901|6068->2902|6162->2968|6191->2969|6275->3024|6305->3025|6460->3151|6490->3152|6565->3198|6595->3199|6885->3461|6914->3462|6993->3512|7023->3513|7211->3673|7240->3674|7275->3680|7305->3681|7383->3731|7412->3732|7445->3737|7474->3738|7526->3762|7555->3763|7628->3808|7657->3809|7742->3865|7772->3866|7913->3978|7943->3979|8011->4019|8040->4020|8090->4042|8119->4043|8151->4047|8180->4048
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|42->14|42->14|42->14|44->16|46->18|46->18|46->18|46->18|49->21|49->21|49->21|51->23|58->30|58->30|58->30|60->32|64->36|64->36|64->36|65->37|65->37|65->37|66->38|73->45|73->45|73->45|81->53|81->53|86->58|86->58|90->62|90->62|92->64|92->64|97->69|97->69|99->71|99->71|101->73|101->73|104->76|104->76|105->77|105->77|107->79|107->79|107->79|107->79|109->81|109->81|110->82|110->82|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|123->95|123->95|124->96|124->96|126->98|126->98|127->99|127->99|128->100|128->100|130->102|130->102|131->103|131->103|133->105|133->105|136->108|136->108|138->110|138->110|141->113|141->113|142->114|142->114|148->120|148->120|148->120|148->120|153->125|153->125|153->125|153->125|155->127|155->127|156->128|156->128|158->130|158->130|162->134|162->134|165->137|165->137|168->140|168->140|170->142|170->142|172->144|172->144|173->145|173->145
                    -- GENERATED --
                */
            