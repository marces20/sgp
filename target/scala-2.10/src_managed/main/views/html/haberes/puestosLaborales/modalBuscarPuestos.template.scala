
package views.html.haberes.puestosLaborales

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
object modalBuscarPuestos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.PuestoLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.PuestoLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaPuestos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.PuestosLaboralesController.modalBuscar())),format.raw/*6.83*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Agente</label>
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
	    <em>No se encuentran puestos laborales</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>N° Legajo</th>	
				<th>Agente</th>
				<th>Organigrama</th>
				<th>CUIT</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*39.6*/for(p <- buscador.getList) yield /*39.32*/ {_display_(Seq[Any](format.raw/*39.34*/("""
	<tr data-id=""""),_display_(Seq[Any](/*40.16*/p/*40.17*/.id)),format.raw/*40.20*/("""" class="modalSeleccionPuestos">
		<td>"""),_display_(Seq[Any](/*41.8*/p/*41.9*/.legajo.numero)),format.raw/*41.23*/("""</td>
		<td>"""),_display_(Seq[Any](/*42.8*/p/*42.9*/.legajo.agente.apellido)),format.raw/*42.32*/("""</td>
		<td>"""),_display_(Seq[Any](/*43.8*/if(p.legajo.agente.organigrama != null)/*43.47*/{_display_(Seq[Any](_display_(Seq[Any](/*43.49*/p/*43.50*/.legajo.agente.organigrama.nombre))))})),format.raw/*43.84*/("""</td>
		<td>"""),_display_(Seq[Any](/*44.8*/if(p.legajo.agente.cuit != null)/*44.40*/{_display_(Seq[Any](_display_(Seq[Any](/*44.42*/p/*44.43*/.legajo.agente.cuit))))})),format.raw/*44.63*/("""</td>
	</tr>    
    """)))})),format.raw/*46.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*51.7*/views/*51.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.PuestosLaboralesController.modalBuscar()))),format.raw/*51.114*/("""
	</div>	
""")))})),format.raw/*53.2*/("""
</div>

<script>
$( function()"""),format.raw/*57.14*/("""{"""),format.raw/*57.15*/("""
	var contenedor = $("#modalBusquedaPuestos");
	var url = """"),_display_(Seq[Any](/*59.14*/controllers/*59.25*/.haberes.routes.PuestosLaboralesController.get())),format.raw/*59.73*/(""""
	contenedor.find('.modalSeleccionPuestos').on('click', function()"""),format.raw/*60.66*/("""{"""),format.raw/*60.67*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*62.38*/("""{"""),format.raw/*62.39*/("""
			$(document).trigger("modal.seleccion.puestoLaboral.simple", data);
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/(""");
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*67.49*/("""{"""),format.raw/*67.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*70.38*/("""{"""),format.raw/*70.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""");
		return false;
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/(""");
	
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.PuestoLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.PuestoLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/modalBuscarPuestos.scala.html
                    HASH: 4d24ef81bbb6fab0178c95de9cb2310ace535eea
                    MATRIX: 875->1|1074->118|1106->142|1180->97|1209->186|1339->281|1358->292|1435->348|1585->463|1693->549|1920->741|1963->775|2003->777|2104->861|2116->866|2154->867|2207->884|2224->892|2278->924|2558->1169|2600->1195|2640->1197|2693->1214|2703->1215|2728->1218|2804->1259|2813->1260|2849->1274|2898->1288|2907->1289|2952->1312|3001->1326|3049->1365|3097->1367|3107->1368|3167->1402|3216->1416|3257->1448|3305->1450|3315->1451|3361->1471|3416->1495|3531->1575|3545->1580|3670->1682|3714->1695|3777->1730|3806->1731|3904->1793|3924->1804|3994->1852|4090->1920|4119->1921|4223->1997|4252->1998|4354->2073|4382->2074|4414->2079|4442->2080|4525->2135|4554->2136|4694->2248|4723->2249|4790->2289|4818->2290|4867->2312|4895->2313|4929->2320|4957->2321
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|74->46|79->51|79->51|79->51|81->53|85->57|85->57|87->59|87->59|87->59|88->60|88->60|90->62|90->62|92->64|92->64|93->65|93->65|95->67|95->67|98->70|98->70|100->72|100->72|102->74|102->74|104->76|104->76
                    -- GENERATED --
                */
            