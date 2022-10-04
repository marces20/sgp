
package views.html.rrhh.agente

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
object modalBusquedaAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Agente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Agente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaAgentes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*6.71*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
			
		</div>
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*21.2*/if(buscador.getTotalRowCount == 0)/*21.36*/ {_display_(Seq[Any](format.raw/*21.38*/("""
	<div class="well">
	    <em>No se encuentran agentes</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre o Apellido</th>
				<th>Organigrama</th>
				<th>Cuit</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*38.6*/for(agente <- buscador.getList) yield /*38.37*/ {_display_(Seq[Any](format.raw/*38.39*/("""
	<tr data-href=""""),_display_(Seq[Any](/*39.18*/controllers/*39.29*/.rrhh.routes.AgentesController.get(agente.id.toLong))),format.raw/*39.81*/("""" class="modalSeleccionAgente">
		<td>"""),_display_(Seq[Any](/*40.8*/agente/*40.14*/.getNombreCompleto())),format.raw/*40.34*/("""</td>
		<td>"""),_display_(Seq[Any](/*41.8*/if(agente.organigrama != null)/*41.38*/{_display_(Seq[Any](_display_(Seq[Any](/*41.40*/agente/*41.46*/.organigrama.nombre))))})),format.raw/*41.66*/("""</td>
		<td>"""),_display_(Seq[Any](/*42.8*/if(agente.cuit != null)/*42.31*/{_display_(Seq[Any](_display_(Seq[Any](/*42.33*/agente/*42.39*/.cuit))))})),format.raw/*42.45*/("""</td>
	</tr>    
    """)))})),format.raw/*44.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*49.7*/views/*49.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.AgentesController.modalBuscar()))),format.raw/*49.102*/("""
	</div>	
""")))})),format.raw/*51.2*/("""
</div>

<script>
$( function()"""),format.raw/*55.14*/("""{"""),format.raw/*55.15*/("""
	var contenedor = $("#modalBusquedaAgentes");
	contenedor.find('.modalSeleccionAgente').on('click', function()"""),format.raw/*57.65*/("""{"""),format.raw/*57.66*/("""
		var url = $(this).attr('data-href');
		$.get(url, function(data)"""),format.raw/*59.28*/("""{"""),format.raw/*59.29*/("""
			$(document).trigger("modal.seleccion.agente.simple", data);
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""");
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*64.49*/("""{"""),format.raw/*64.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*67.38*/("""{"""),format.raw/*67.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");
		return false;
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/(""");
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Agente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Agente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/modalBusquedaAgente.scala.html
                    HASH: 46137e53ca1e616fb5acd42448438ece251823c1
                    MATRIX: 841->1|1017->94|1049->118|1123->75|1151->162|1278->254|1297->265|1362->309|1508->420|1616->506|1832->687|1875->721|1915->723|2002->793|2014->798|2052->799|2104->815|2121->823|2175->855|2429->1074|2476->1105|2516->1107|2570->1125|2590->1136|2664->1188|2738->1227|2753->1233|2795->1253|2843->1266|2882->1296|2930->1298|2945->1304|2991->1324|3039->1337|3071->1360|3119->1362|3134->1368|3166->1374|3219->1396|3329->1471|3343->1476|3456->1566|3498->1577|3557->1608|3586->1609|3725->1720|3754->1721|3849->1788|3878->1789|3971->1855|3999->1856|4030->1860|4058->1861|4139->1914|4168->1915|4305->2024|4334->2025|4399->2063|4427->2064|4474->2084|4502->2085|4532->2088|4560->2089
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|72->44|77->49|77->49|77->49|79->51|83->55|83->55|85->57|85->57|87->59|87->59|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            