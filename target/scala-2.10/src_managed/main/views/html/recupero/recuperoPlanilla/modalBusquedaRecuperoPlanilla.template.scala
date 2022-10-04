
package views.html.recupero.recuperoPlanilla

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
object modalBusquedaRecuperoPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.RecuperoPlanilla],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.RecuperoPlanilla], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.102*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaPlanillas" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*6.85*/("""" method="GET">
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Numero</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Ejercicio</label>
			"""),_display_(Seq[Any](/*15.5*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*15.164*/("""
		</div>

		
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*27.2*/if(buscador.getTotalRowCount == 0)/*27.36*/ {_display_(Seq[Any](format.raw/*27.38*/("""
	<div class="well">
	    <em>No se encuentran planillas</em>
	</div>
""")))}/*31.3*/else/*31.8*/{_display_(Seq[Any](format.raw/*31.9*/("""
    Mostrando """),_display_(Seq[Any](/*32.16*/buscador/*32.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*32.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Expediente</th>
				<th>Institucion</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*44.6*/for(planilla <- buscador.getList) yield /*44.39*/ {_display_(Seq[Any](format.raw/*44.41*/("""
	<tr data-id=""""),_display_(Seq[Any](/*45.16*/planilla/*45.24*/.id)),format.raw/*45.27*/("""" class="modalSeleccionPlanilla pointer">
		<td>"""),_display_(Seq[Any](/*46.8*/planilla/*46.16*/.getRecuperoPlanillaEjercicioDeposito())),format.raw/*46.55*/("""</td>
		<td>"""),_display_(Seq[Any](/*47.8*/planilla/*47.16*/.expediente.getExpedienteEjercicio())),format.raw/*47.52*/("""</td>
	</tr>    
    """)))})),format.raw/*49.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*54.7*/views/*54.12*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoPlanillasController.modalBuscar()))),format.raw/*54.116*/("""
	</div>	
""")))})),format.raw/*56.2*/("""
</div>

<script>
$( function()"""),format.raw/*60.14*/("""{"""),format.raw/*60.15*/("""
	var contenedor = $("#modalBusquedaPlanillas");
	var url = """"),_display_(Seq[Any](/*62.14*/controllers/*62.25*/.recupero.routes.RecuperoPlanillasController.get())),format.raw/*62.75*/(""""
	contenedor.find('.modalSeleccionPlanilla').on('click', function()"""),format.raw/*63.67*/("""{"""),format.raw/*63.68*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*65.38*/("""{"""),format.raw/*65.39*/("""
			$(document).trigger("modal.seleccion.planilla.simple", data);
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""");
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*70.49*/("""{"""),format.raw/*70.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*73.38*/("""{"""),format.raw/*73.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*75.3*/("""}"""),format.raw/*75.4*/(""");
		return false;
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/(""");
"""),format.raw/*78.1*/("""}"""),format.raw/*78.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.RecuperoPlanilla],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoPlanilla],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/modalBusquedaRecuperoPlanilla.scala.html
                    HASH: 9d6a9b19fec8ee4f2052c392307ba7180ac68c38
                    MATRIX: 891->1|1094->122|1126->146|1201->101|1230->190|1362->287|1381->298|1460->356|1610->471|1718->557|1850->654|2032->813|2260->1006|2303->1040|2343->1042|2436->1118|2448->1123|2486->1124|2539->1141|2556->1149|2610->1181|2871->1407|2920->1440|2960->1442|3013->1459|3030->1467|3055->1470|3140->1520|3157->1528|3218->1567|3267->1581|3284->1589|3342->1625|3397->1649|3512->1729|3526->1734|3653->1838|3697->1851|3760->1886|3789->1887|3889->1951|3909->1962|3981->2012|4078->2081|4107->2082|4211->2158|4240->2159|4337->2229|4365->2230|4397->2235|4425->2236|4508->2291|4537->2292|4677->2404|4706->2405|4773->2445|4801->2446|4850->2468|4878->2469|4909->2473|4937->2474
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|43->15|43->15|55->27|55->27|55->27|59->31|59->31|59->31|60->32|60->32|60->32|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|77->49|82->54|82->54|82->54|84->56|88->60|88->60|90->62|90->62|90->62|91->63|91->63|93->65|93->65|95->67|95->67|96->68|96->68|98->70|98->70|101->73|101->73|103->75|103->75|105->77|105->77|106->78|106->78
                    -- GENERATED --
                */
            