
package views.html.rrhh.agenteFamilias

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
object indexAgenteFamilia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteFamilia],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteFamilia], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.1*/("""
<div id="listaAgenteFamilia" class="contenedorPaginador ajaxPaginador">
		
	<div class="panel panel-default">
		<div class="panel-heading"><b>Familiares</b>
			"""),_display_(Seq[Any](/*8.5*/if(editable && Permiso.check("crearAgenteHijo"))/*8.53*/{_display_(Seq[Any](format.raw/*8.54*/("""
			<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteFamilia"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			""")))})),format.raw/*10.5*/("""
		</div>
		<div class="panel-body">
		
	"""),_display_(Seq[Any](/*14.3*/if(paginador.getTotalRowCount == 0)/*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
        <p id="mensajeSinResultadosFamilia" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay familiares cargados.</p>
    """)))})),format.raw/*16.6*/(""" 

	<table id="listaDeAgenteFamilia" class="table table-striped table-bordered  """),_display_(Seq[Any](/*18.79*/if(paginador.getTotalRowCount() <= 0)/*18.116*/{_display_(Seq[Any](format.raw/*18.117*/("""hide""")))})),format.raw/*18.122*/("""">
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
					<th>Tipo Familiar</th>
					<th>Presentacion</th>
				"""),_display_(Seq[Any](/*31.6*/if(editable && Permiso.check("eliminarAgenteHijo"))/*31.57*/{_display_(Seq[Any](format.raw/*31.58*/("""
					<th></th>
				""")))})),format.raw/*33.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*37.4*/for(linea <- paginador.getList) yield /*37.35*/ {_display_(Seq[Any](format.raw/*37.37*/("""
			"""),_display_(Seq[Any](/*38.5*/views/*38.10*/.html.rrhh.agenteFamilias.lineaAgenteFamilia(linea, editable))),format.raw/*38.71*/("""
		""")))})),format.raw/*39.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*46.9*/views/*46.14*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesFamiliasController.index()))),format.raw/*46.107*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	 
	 
	var contenedor = $("#listaAgenteFamilia");
						     
	contenedor.on('click', '#nuevoAgenteFamilia', function()"""),format.raw/*59.58*/("""{"""),format.raw/*59.59*/("""
		urlContenidoModal = '/rrhh/agente-familia/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*63.2*/("""}"""),format.raw/*63.3*/(""");
	
	contenedor.on('click', '.modificarAgenteFamilia', function()"""),format.raw/*65.62*/("""{"""),format.raw/*65.63*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar familiares');	
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteFamilia', function()"""),format.raw/*72.61*/("""{"""),format.raw/*72.62*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*74.23*/("""{"""),format.raw/*74.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*77.29*/("""{"""),format.raw/*77.30*/("""
				if(data.success)"""),format.raw/*78.21*/("""{"""),format.raw/*78.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*80.5*/("""}"""),format.raw/*80.6*/(""" else """),format.raw/*80.12*/("""{"""),format.raw/*80.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*82.5*/("""}"""),format.raw/*82.6*/("""
			"""),format.raw/*83.4*/("""}"""),format.raw/*83.5*/(""");
		"""),format.raw/*84.3*/("""}"""),format.raw/*84.4*/("""
		return false;
	"""),format.raw/*86.2*/("""}"""),format.raw/*86.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*88.28*/("""{"""),format.raw/*88.29*/("""
		modalCargaAgenteFamilia = $('<div></div>').dialog("""),format.raw/*89.53*/("""{"""),format.raw/*89.54*/("""
			resizable: false,
		    title: "Cargar Familiares",
		    height: 600,
		    minHeight:600,
		    width: 900,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*96.35*/("""{"""),format.raw/*96.36*/("""
				$.get(url, function(data)"""),format.raw/*97.30*/("""{"""),format.raw/*97.31*/("""
					modalCargaAgenteFamilia.html(data);
				"""),format.raw/*99.5*/("""}"""),format.raw/*99.6*/(""");
		    """),format.raw/*100.7*/("""}"""),format.raw/*100.8*/(""",
		    close: function(event, ui )"""),format.raw/*101.34*/("""{"""),format.raw/*101.35*/("""
		    	modalCargaAgenteFamilia.dialog('destroy');
			"""),format.raw/*103.4*/("""}"""),format.raw/*103.5*/("""
		  """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""");
		
		modalCargaAgenteFamilia.on('click', '.cancelar', function()"""),format.raw/*106.62*/("""{"""),format.raw/*106.63*/("""
			modalCargaAgenteFamilia.dialog('destroy');
			return false;
		"""),format.raw/*109.3*/("""}"""),format.raw/*109.4*/(""");
		
		modalCargaAgenteFamilia.on('submit', function(e)"""),format.raw/*111.51*/("""{"""),format.raw/*111.52*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*114.42*/("""{"""),format.raw/*114.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*115.45*/("""{"""),format.raw/*115.46*/("""
					$('#listaDeAgenteFamilia tbody').prepend(resultado.html);
					$('#mensajeSinResultadosFamilia').remove();
					$('#listaDeAgenteFamilia').removeClass('hide');
					modalCargaAgenteFamilia.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*121.56*/("""{"""),format.raw/*121.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaAgenteFamilia.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*126.5*/("""}"""),format.raw/*126.6*/(""" else """),format.raw/*126.12*/("""{"""),format.raw/*126.13*/("""
					modalCargaAgenteFamilia.html(resultado);
				"""),format.raw/*128.5*/("""}"""),format.raw/*128.6*/("""
			"""),format.raw/*129.4*/("""}"""),format.raw/*129.5*/(""");
			return false;
		"""),format.raw/*131.3*/("""}"""),format.raw/*131.4*/(""");
		
		
		return modalCargaAgenteFamilia;
	"""),format.raw/*135.2*/("""}"""),format.raw/*135.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*138.49*/("""{"""),format.raw/*138.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*141.38*/("""{"""),format.raw/*141.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*143.3*/("""}"""),format.raw/*143.4*/(""");
		return false;
	"""),format.raw/*145.2*/("""}"""),format.raw/*145.3*/(""");
"""),format.raw/*146.1*/("""}"""),format.raw/*146.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteFamilia],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteFamilia],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteFamilias/indexAgenteFamilia.scala.html
                    HASH: 2f644d2479969d9e5820b5527aede844b874203a
                    MATRIX: 851->1|1042->76|1070->101|1271->268|1327->316|1365->317|1527->448|1608->494|1652->529|1692->531|1866->674|1985->757|2032->794|2072->795|2110->800|2174->829|2232->878|2271->879|2348->925|2567->1109|2627->1160|2666->1161|2720->1184|2793->1222|2840->1253|2880->1255|2921->1261|2935->1266|3018->1327|3054->1332|3170->1413|3184->1418|3300->1511|3395->1578|3424->1579|3577->1704|3606->1705|3773->1845|3801->1846|3897->1914|3926->1915|4126->2088|4154->2089|4249->2156|4278->2157|4392->2243|4421->2244|4536->2331|4565->2332|4615->2354|4644->2355|4713->2397|4741->2398|4775->2404|4804->2405|4887->2461|4915->2462|4947->2467|4975->2468|5008->2474|5036->2475|5083->2495|5111->2496|5173->2530|5202->2531|5284->2585|5313->2586|5515->2760|5544->2761|5603->2792|5632->2793|5707->2841|5735->2842|5773->2852|5802->2853|5867->2889|5897->2890|5981->2946|6010->2947|6044->2953|6073->2954|6171->3023|6201->3024|6298->3093|6327->3094|6414->3152|6444->3153|6599->3279|6629->3280|6704->3326|6734->3327|7036->3601|7065->3602|7144->3652|7174->3653|7365->3816|7394->3817|7429->3823|7459->3824|7540->3877|7569->3878|7602->3883|7631->3884|7683->3908|7712->3909|7788->3957|7817->3958|7902->4014|7932->4015|8073->4127|8103->4128|8171->4168|8200->4169|8250->4191|8279->4192|8311->4196|8340->4197
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|38->10|42->14|42->14|42->14|44->16|46->18|46->18|46->18|46->18|49->21|49->21|49->21|51->23|59->31|59->31|59->31|61->33|65->37|65->37|65->37|66->38|66->38|66->38|67->39|74->46|74->46|74->46|82->54|82->54|87->59|87->59|91->63|91->63|93->65|93->65|98->70|98->70|100->72|100->72|102->74|102->74|105->77|105->77|106->78|106->78|108->80|108->80|108->80|108->80|110->82|110->82|111->83|111->83|112->84|112->84|114->86|114->86|116->88|116->88|117->89|117->89|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|129->101|129->101|131->103|131->103|132->104|132->104|134->106|134->106|137->109|137->109|139->111|139->111|142->114|142->114|143->115|143->115|149->121|149->121|149->121|149->121|154->126|154->126|154->126|154->126|156->128|156->128|157->129|157->129|159->131|159->131|163->135|163->135|166->138|166->138|169->141|169->141|171->143|171->143|173->145|173->145|174->146|174->146
                    -- GENERATED --
                */
            