
package views.html.rrhh.agenteRul

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
object indexAgenteRul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteRul],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteRul], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*3.1*/("""
<div id="listaAgenteRul" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Datos RUL</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("crearAgenteRul"))/*8.52*/{_display_(Seq[Any](format.raw/*8.53*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteRul"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			""")))})),format.raw/*10.5*/("""
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*14.3*/if(paginador.getTotalRowCount == 0)/*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
        <p id="mensajeSinResultadosRul" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay Datos cargados.</p>
    """)))})),format.raw/*16.6*/(""" 

	<table id="listaDeAgenteRul" class="table table-striped table-bordered  """),_display_(Seq[Any](/*18.75*/if(paginador.getTotalRowCount() <= 0)/*18.112*/{_display_(Seq[Any](format.raw/*18.113*/("""hide""")))})),format.raw/*18.118*/("""">
		<thead>
			<tr>
				"""),_display_(Seq[Any](/*21.6*/if(editable && Permiso.check("editarAgenteRul"))/*21.54*/{_display_(Seq[Any](format.raw/*21.55*/("""
					<th class="accion-editar">#</th>
				""")))})),format.raw/*23.6*/("""
					<th>Tipo Relación Laboral</th>
					<th>Institucion</th>
					<th>Nota</th>
				"""),_display_(Seq[Any](/*27.6*/if(editable && Permiso.check("eliminarAgenteRul"))/*27.56*/{_display_(Seq[Any](format.raw/*27.57*/("""
					<th></th>
				""")))})),format.raw/*29.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*33.4*/for(linea <- paginador.getList) yield /*33.35*/ {_display_(Seq[Any](format.raw/*33.37*/("""
			"""),_display_(Seq[Any](/*34.5*/views/*34.10*/.html.rrhh.agenteRul.lineaAgenteRul(linea, editable))),format.raw/*34.62*/("""
		""")))})),format.raw/*35.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*42.9*/views/*42.14*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesRulController.index()))),format.raw/*42.102*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*50.14*/("""{"""),format.raw/*50.15*/("""
	 
	 
	var contenedor = $("#listaAgenteRul");
						     
	contenedor.on('click', '#nuevoAgenteRul', function()"""),format.raw/*55.54*/("""{"""),format.raw/*55.55*/("""
		urlContenidoModal = '/rrhh/agente-rul/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/(""");
	
	contenedor.on('click', '.modificarAgenteRul', function()"""),format.raw/*61.58*/("""{"""),format.raw/*61.59*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Datos Rul');	
		return false;
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteRul', function()"""),format.raw/*68.57*/("""{"""),format.raw/*68.58*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*70.23*/("""{"""),format.raw/*70.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*73.29*/("""{"""),format.raw/*73.30*/("""
				if(data.success)"""),format.raw/*74.21*/("""{"""),format.raw/*74.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*76.5*/("""}"""),format.raw/*76.6*/(""" else """),format.raw/*76.12*/("""{"""),format.raw/*76.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*78.5*/("""}"""),format.raw/*78.6*/("""
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/(""");
		"""),format.raw/*80.3*/("""}"""),format.raw/*80.4*/("""
		return false;
	"""),format.raw/*82.2*/("""}"""),format.raw/*82.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*84.28*/("""{"""),format.raw/*84.29*/("""
		modalCargaAgenteRul = $('<div></div>').dialog("""),format.raw/*85.49*/("""{"""),format.raw/*85.50*/("""
			resizable: false,
		    title: "Cargar Rul",
		    height: 600,
		    minHeight:600,
		    width: 800,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""
				$.get(url, function(data)"""),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
					modalCargaAgenteRul.html(data);
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
		    """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""",
		    close: function(event, ui )"""),format.raw/*97.34*/("""{"""),format.raw/*97.35*/("""
		    	modalCargaAgenteRul.dialog('destroy');
			"""),format.raw/*99.4*/("""}"""),format.raw/*99.5*/("""
		  """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");
		
		modalCargaAgenteRul.on('click', '.cancelar', function()"""),format.raw/*102.58*/("""{"""),format.raw/*102.59*/("""
			modalCargaAgenteRul.dialog('destroy');
			return false;
		"""),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");
		
		modalCargaAgenteRul.on('submit', function(e)"""),format.raw/*107.47*/("""{"""),format.raw/*107.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*111.45*/("""{"""),format.raw/*111.46*/("""
					$('#listaDeAgenteRul tbody').prepend(resultado.html);
					$('#mensajeSinResultadosRul').remove();
					$('#listaDeAgenteRul').removeClass('hide');
					modalCargaAgenteRul.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*117.56*/("""{"""),format.raw/*117.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaAgenteRul.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*122.5*/("""}"""),format.raw/*122.6*/(""" else """),format.raw/*122.12*/("""{"""),format.raw/*122.13*/("""
					modalCargaAgenteRul.html(resultado);
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/("""
			"""),format.raw/*125.4*/("""}"""),format.raw/*125.5*/(""");
			return false;
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/(""");
		
		
		return modalCargaAgenteRul;
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
    
    def render(paginador:utils.pagination.Pagination[AgenteRul],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteRul],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteRul/indexAgenteRul.scala.html
                    HASH: ae5244f2b0b724fac4e05bdc44ebc23577873aeb
                    MATRIX: 838->1|1025->72|1053->97|1249->259|1304->306|1342->307|1500->434|1581->480|1625->515|1665->517|1830->651|1945->730|1992->767|2032->768|2070->773|2134->802|2191->850|2230->851|2307->897|2433->988|2492->1038|2531->1039|2585->1062|2658->1100|2705->1131|2745->1133|2786->1139|2800->1144|2874->1196|2910->1201|3026->1282|3040->1287|3151->1375|3246->1442|3275->1443|3420->1560|3449->1561|3612->1697|3640->1698|3732->1762|3761->1763|3960->1935|3988->1936|4079->1999|4108->2000|4222->2086|4251->2087|4366->2174|4395->2175|4445->2197|4474->2198|4543->2240|4571->2241|4605->2247|4634->2248|4717->2304|4745->2305|4777->2310|4805->2311|4838->2317|4866->2318|4913->2338|4941->2339|5003->2373|5032->2374|5110->2424|5139->2425|5334->2592|5363->2593|5422->2624|5451->2625|5522->2669|5550->2670|5587->2680|5615->2681|5679->2717|5708->2718|5787->2770|5815->2771|5849->2777|5878->2778|5972->2843|6002->2844|6095->2909|6124->2910|6207->2964|6237->2965|6392->3091|6422->3092|6497->3138|6527->3139|6813->3397|6842->3398|6921->3448|6951->3449|7138->3608|7167->3609|7202->3615|7232->3616|7309->3665|7338->3666|7371->3671|7400->3672|7452->3696|7481->3697|7553->3741|7582->3742|7667->3798|7697->3799|7838->3911|7868->3912|7936->3952|7965->3953|8015->3975|8044->3976|8076->3980|8105->3981
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|42->14|42->14|42->14|44->16|46->18|46->18|46->18|46->18|49->21|49->21|49->21|51->23|55->27|55->27|55->27|57->29|61->33|61->33|61->33|62->34|62->34|62->34|63->35|70->42|70->42|70->42|78->50|78->50|83->55|83->55|87->59|87->59|89->61|89->61|94->66|94->66|96->68|96->68|98->70|98->70|101->73|101->73|102->74|102->74|104->76|104->76|104->76|104->76|106->78|106->78|107->79|107->79|108->80|108->80|110->82|110->82|112->84|112->84|113->85|113->85|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|130->102|130->102|133->105|133->105|135->107|135->107|138->110|138->110|139->111|139->111|145->117|145->117|145->117|145->117|150->122|150->122|150->122|150->122|152->124|152->124|153->125|153->125|155->127|155->127|159->131|159->131|162->134|162->134|165->137|165->137|167->139|167->139|169->141|169->141|170->142|170->142
                    -- GENERATED --
                */
            