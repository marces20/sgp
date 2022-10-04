
package views.html.expediente.expediente

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
object modalBusquedaExpedienteCopia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Expediente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Expediente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaExpedientes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.expediente.routes.ExpedientesController.modalBuscarCopia())),format.raw/*6.86*/("""" method="GET">
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
		</div>
		
		<div class="col-sm-4">
			<label class="control-label">Descripción</label>
			"""),_display_(Seq[Any](/*15.5*/inputText(formBuscador("descripcion"), 'class -> "form-control"))),format.raw/*15.69*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Ejercicio</label>
			"""),_display_(Seq[Any](/*20.5*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*20.164*/("""
		</div>

		
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*32.2*/if(buscador.getTotalRowCount == 0)/*32.36*/ {_display_(Seq[Any](format.raw/*32.38*/("""
	<div class="well">
	    <em>No se encuentran expedientes</em>
	</div>
""")))}/*36.3*/else/*36.8*/{_display_(Seq[Any](format.raw/*36.9*/("""
    Mostrando """),_display_(Seq[Any](/*37.16*/buscador/*37.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*37.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Descripción</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*48.6*/for(expediente <- buscador.getList) yield /*48.41*/ {_display_(Seq[Any](format.raw/*48.43*/("""
	<tr data-id=""""),_display_(Seq[Any](/*49.16*/expediente/*49.26*/.id)),format.raw/*49.29*/("""" class="modalSeleccionExpediente pointer">
		<td> """),_display_(Seq[Any](/*50.9*/expediente/*50.19*/.getExpedienteEjercicio())),format.raw/*50.44*/("""</td>
		<td> """),_display_(Seq[Any](/*51.9*/expediente/*51.19*/.descripcion)),format.raw/*51.31*/("""</td>
	</tr>    
    """)))})),format.raw/*53.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*58.7*/views/*58.12*/.html.helpers.paginador(buscador, controllers.expediente.routes.ExpedientesController.modalBuscar()))),format.raw/*58.112*/("""
	</div>	
""")))})),format.raw/*60.2*/("""
</div>

<script>
$( function()"""),format.raw/*64.14*/("""{"""),format.raw/*64.15*/("""
	var contenedor = $("#modalBusquedaExpedientes");
	var url = """"),_display_(Seq[Any](/*66.14*/controllers/*66.25*/.expediente.routes.ExpedientesController.get())),format.raw/*66.71*/(""""
	contenedor.find('.modalSeleccionExpediente').on('click', function()"""),format.raw/*67.69*/("""{"""),format.raw/*67.70*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*69.38*/("""{"""),format.raw/*69.39*/("""
			$(document).trigger("modal.seleccion.expediente.simple", data);
		"""),format.raw/*71.3*/("""}"""),format.raw/*71.4*/(""");
	"""),format.raw/*72.2*/("""}"""),format.raw/*72.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*74.49*/("""{"""),format.raw/*74.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*77.38*/("""{"""),format.raw/*77.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*79.3*/("""}"""),format.raw/*79.4*/(""");
		return false;
	"""),format.raw/*81.2*/("""}"""),format.raw/*81.3*/(""");
"""),format.raw/*82.1*/("""}"""),format.raw/*82.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Expediente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Expediente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/modalBusquedaExpedienteCopia.scala.html
                    HASH: 8e4036e8df7ca99ca938cc7c7f695bdf4bfd07da
                    MATRIX: 864->1|1045->100|1077->124|1151->79|1180->168|1314->267|1333->278|1413->337|1563->452|1671->538|1805->637|1891->701|2023->798|2205->957|2433->1150|2476->1184|2516->1186|2611->1264|2623->1269|2661->1270|2714->1287|2731->1295|2785->1327|3021->1528|3072->1563|3112->1565|3165->1582|3184->1592|3209->1595|3297->1648|3316->1658|3363->1683|3413->1698|3432->1708|3466->1720|3521->1744|3636->1824|3650->1829|3773->1929|3817->1942|3880->1977|3909->1978|4011->2044|4031->2055|4099->2101|4198->2172|4227->2173|4331->2249|4360->2250|4459->2322|4487->2323|4519->2328|4547->2329|4630->2384|4659->2385|4799->2497|4828->2498|4895->2538|4923->2539|4972->2561|5000->2562|5031->2566|5059->2567
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|43->15|43->15|48->20|48->20|60->32|60->32|60->32|64->36|64->36|64->36|65->37|65->37|65->37|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|81->53|86->58|86->58|86->58|88->60|92->64|92->64|94->66|94->66|94->66|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72|102->74|102->74|105->77|105->77|107->79|107->79|109->81|109->81|110->82|110->82
                    -- GENERATED --
                */
            