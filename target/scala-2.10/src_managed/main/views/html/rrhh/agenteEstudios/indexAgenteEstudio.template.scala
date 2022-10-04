
package views.html.rrhh.agenteEstudios

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
object indexAgenteEstudio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteEstudio],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteEstudio], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.1*/("""
<div id="listaAgenteEstudio" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Estudios</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("crearAgenteEstudio"))/*8.56*/{_display_(Seq[Any](format.raw/*8.57*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteEstudio"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			""")))})),format.raw/*10.5*/("""
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*14.3*/if(paginador.getTotalRowCount == 0)/*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
        <p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay estudios cargados.</p>
    """)))})),format.raw/*16.6*/(""" 

	<table id="listaDeAgenteEstudio" class="table table-striped table-bordered  """),_display_(Seq[Any](/*18.79*/if(paginador.getTotalRowCount() <= 0)/*18.116*/{_display_(Seq[Any](format.raw/*18.117*/("""hide""")))})),format.raw/*18.122*/("""">
		<thead>
			<tr>
				"""),_display_(Seq[Any](/*21.6*/if(editable && Permiso.check("editarAgenteEstudio"))/*21.58*/{_display_(Seq[Any](format.raw/*21.59*/("""
					<th class="accion-editar">#</th>
				""")))})),format.raw/*23.6*/("""
					<th>Nivel</th>
					<th>Titulo</th>
					<th>Institucion</th>
					<th>Area</th>
					<th>Estado</th>					
				"""),_display_(Seq[Any](/*29.6*/if(editable && Permiso.check("eliminarAgenteEstudio"))/*29.60*/{_display_(Seq[Any](format.raw/*29.61*/("""
					<th></th>
				""")))})),format.raw/*31.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*35.4*/for(linea <- paginador.getList) yield /*35.35*/ {_display_(Seq[Any](format.raw/*35.37*/("""
			"""),_display_(Seq[Any](/*36.5*/views/*36.10*/.html.rrhh.agenteEstudios.lineaAgenteEstudio(linea, editable))),format.raw/*36.71*/("""
		""")))})),format.raw/*37.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*44.9*/views/*44.14*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesEstudiosController.index()))),format.raw/*44.107*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*52.14*/("""{"""),format.raw/*52.15*/("""
	 
	 
	var contenedor = $("#listaAgenteEstudio");
						     
	contenedor.on('click', '#nuevoAgenteEstudio', function()"""),format.raw/*57.58*/("""{"""),format.raw/*57.59*/("""
		urlContenidoModal = '/rrhh/agente-estudio/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.on('click', '.modificarAgenteEstudio', function()"""),format.raw/*63.62*/("""{"""),format.raw/*63.63*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Estudio');	
		return false;
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteEstudio', function()"""),format.raw/*70.61*/("""{"""),format.raw/*70.62*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*72.23*/("""{"""),format.raw/*72.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*75.29*/("""{"""),format.raw/*75.30*/("""
				if(data.success)"""),format.raw/*76.21*/("""{"""),format.raw/*76.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*78.5*/("""}"""),format.raw/*78.6*/(""" else """),format.raw/*78.12*/("""{"""),format.raw/*78.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*80.5*/("""}"""),format.raw/*80.6*/("""
			"""),format.raw/*81.4*/("""}"""),format.raw/*81.5*/(""");
		"""),format.raw/*82.3*/("""}"""),format.raw/*82.4*/("""
		return false;
	"""),format.raw/*84.2*/("""}"""),format.raw/*84.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*86.28*/("""{"""),format.raw/*86.29*/("""
		modalCargaAgenteEstudio = $('<div></div>').dialog("""),format.raw/*87.53*/("""{"""),format.raw/*87.54*/("""
			resizable: false,
		    title: "Cargar Estudios",
		    height: 600,
		    minHeight:600,
		    width: 800,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*94.35*/("""{"""),format.raw/*94.36*/("""
				$.get(url, function(data)"""),format.raw/*95.30*/("""{"""),format.raw/*95.31*/("""
					modalCargaAgenteEstudio.html(data);
				"""),format.raw/*97.5*/("""}"""),format.raw/*97.6*/(""");
		    """),format.raw/*98.7*/("""}"""),format.raw/*98.8*/(""",
		    close: function(event, ui )"""),format.raw/*99.34*/("""{"""),format.raw/*99.35*/("""
		    	modalCargaAgenteEstudio.dialog('destroy');
			"""),format.raw/*101.4*/("""}"""),format.raw/*101.5*/("""
		  """),format.raw/*102.5*/("""}"""),format.raw/*102.6*/(""");
		
		modalCargaAgenteEstudio.on('click', '.cancelar', function()"""),format.raw/*104.62*/("""{"""),format.raw/*104.63*/("""
			modalCargaAgenteEstudio.dialog('destroy');
			return false;
		"""),format.raw/*107.3*/("""}"""),format.raw/*107.4*/(""");
		
		modalCargaAgenteEstudio.on('submit', function(e)"""),format.raw/*109.51*/("""{"""),format.raw/*109.52*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*112.42*/("""{"""),format.raw/*112.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*113.45*/("""{"""),format.raw/*113.46*/("""
					$('#listaDeAgenteEstudio tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaDeAgenteEstudio').removeClass('hide');
					modalCargaAgenteEstudio.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*119.56*/("""{"""),format.raw/*119.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaAgenteEstudio.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""" else """),format.raw/*124.12*/("""{"""),format.raw/*124.13*/("""
					modalCargaAgenteEstudio.html(resultado);
				"""),format.raw/*126.5*/("""}"""),format.raw/*126.6*/("""
			"""),format.raw/*127.4*/("""}"""),format.raw/*127.5*/(""");
			return false;
		"""),format.raw/*129.3*/("""}"""),format.raw/*129.4*/(""");
		
		
		return modalCargaAgenteEstudio;
	"""),format.raw/*133.2*/("""}"""),format.raw/*133.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*136.49*/("""{"""),format.raw/*136.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*139.38*/("""{"""),format.raw/*139.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*141.3*/("""}"""),format.raw/*141.4*/(""");
		return false;
	"""),format.raw/*143.2*/("""}"""),format.raw/*143.3*/(""");
"""),format.raw/*144.1*/("""}"""),format.raw/*144.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteEstudio],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteEstudio],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteEstudios/indexAgenteEstudio.scala.html
                    HASH: ab3e9eef12f98be812823caf5d6d18252e3e874d
                    MATRIX: 851->1|1042->76|1070->101|1269->266|1328->317|1366->318|1528->449|1609->495|1653->530|1693->532|1858->666|1977->749|2024->786|2064->787|2102->792|2166->821|2227->873|2266->874|2343->920|2502->1044|2565->1098|2604->1099|2658->1122|2731->1160|2778->1191|2818->1193|2859->1199|2873->1204|2956->1265|2992->1270|3108->1351|3122->1356|3238->1449|3333->1516|3362->1517|3515->1642|3544->1643|3711->1783|3739->1784|3835->1852|3864->1853|4061->2023|4089->2024|4184->2091|4213->2092|4327->2178|4356->2179|4471->2266|4500->2267|4550->2289|4579->2290|4648->2332|4676->2333|4710->2339|4739->2340|4822->2396|4850->2397|4882->2402|4910->2403|4943->2409|4971->2410|5018->2430|5046->2431|5108->2465|5137->2466|5219->2520|5248->2521|5448->2693|5477->2694|5536->2725|5565->2726|5640->2774|5668->2775|5705->2785|5733->2786|5797->2822|5826->2823|5910->2879|5939->2880|5973->2886|6002->2887|6100->2956|6130->2957|6227->3026|6256->3027|6343->3085|6373->3086|6528->3212|6558->3213|6633->3259|6663->3260|6958->3527|6987->3528|7066->3578|7096->3579|7287->3742|7316->3743|7351->3749|7381->3750|7462->3803|7491->3804|7524->3809|7553->3810|7605->3834|7634->3835|7710->3883|7739->3884|7824->3940|7854->3941|7995->4053|8025->4054|8093->4094|8122->4095|8172->4117|8201->4118|8233->4122|8262->4123
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|42->14|42->14|42->14|44->16|46->18|46->18|46->18|46->18|49->21|49->21|49->21|51->23|57->29|57->29|57->29|59->31|63->35|63->35|63->35|64->36|64->36|64->36|65->37|72->44|72->44|72->44|80->52|80->52|85->57|85->57|89->61|89->61|91->63|91->63|96->68|96->68|98->70|98->70|100->72|100->72|103->75|103->75|104->76|104->76|106->78|106->78|106->78|106->78|108->80|108->80|109->81|109->81|110->82|110->82|112->84|112->84|114->86|114->86|115->87|115->87|122->94|122->94|123->95|123->95|125->97|125->97|126->98|126->98|127->99|127->99|129->101|129->101|130->102|130->102|132->104|132->104|135->107|135->107|137->109|137->109|140->112|140->112|141->113|141->113|147->119|147->119|147->119|147->119|152->124|152->124|152->124|152->124|154->126|154->126|155->127|155->127|157->129|157->129|161->133|161->133|164->136|164->136|167->139|167->139|169->141|169->141|171->143|171->143|172->144|172->144
                    -- GENERATED --
                */
            