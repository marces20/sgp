
package views.html.rrhh.especialidad

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
object modalBusquedaEspecialidad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Especialidad],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Especialidad], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaEspecialidades" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.rrhh.routes.EspecialidadesController.modalBuscar())),format.raw/*6.78*/("""" method="GET">
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
	    <em>No se encuentran Especialidades</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(especialidad <- buscador.getList) yield /*36.43*/ {_display_(Seq[Any](format.raw/*36.45*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/especialidad/*37.28*/.id)),format.raw/*37.31*/("""" class="modalSeleccionEspecialidad">
		<td> """),_display_(Seq[Any](/*38.9*/especialidad/*38.21*/.nombre)),format.raw/*38.28*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.EspecialidadesController.modalBuscar()))),format.raw/*45.109*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaEspecialidades");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.rrhh.routes.EspecialidadesController.get())),format.raw/*53.68*/(""""
	contenedor.find('.modalSeleccionEspecialidad').on('click', function()"""),format.raw/*54.71*/("""{"""),format.raw/*54.72*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.especialidad.simple", data);
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/(""");
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*61.49*/("""{"""),format.raw/*61.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*64.38*/("""{"""),format.raw/*64.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/(""");
		return false;
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/(""");
"""),format.raw/*69.1*/("""}"""),format.raw/*69.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Especialidad],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Especialidad],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/especialidad/modalBusquedaEspecialidad.scala.html
                    HASH: c218b65fcfba3209f66d5b765c88c2423dbaa3d1
                    MATRIX: 859->1|1042->102|1074->126|1148->81|1177->170|1314->272|1333->283|1405->334|1555->449|1663->535|1890->727|1933->761|1973->763|2071->844|2083->849|2121->850|2174->867|2191->875|2245->907|2455->1082|2508->1119|2548->1121|2601->1138|2622->1150|2647->1153|2729->1200|2750->1212|2779->1219|2834->1243|2949->1323|2963->1328|3083->1425|3127->1438|3190->1473|3219->1474|3324->1543|3344->1554|3409->1597|3510->1670|3539->1671|3643->1747|3672->1748|3773->1822|3801->1823|3833->1828|3861->1829|3944->1884|3973->1885|4113->1997|4142->1998|4209->2038|4237->2039|4286->2061|4314->2062|4345->2066|4373->2067
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            