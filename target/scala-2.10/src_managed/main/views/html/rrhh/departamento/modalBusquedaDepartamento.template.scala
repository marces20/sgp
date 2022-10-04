
package views.html.rrhh.departamento

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
object modalBusquedaDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Departamento],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Departamento], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaDepartamentos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*6.77*/("""" method="GET">
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
	    <em>No se encuentran departamentos</em>
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
    	
    """),_display_(Seq[Any](/*36.6*/for(usuario <- buscador.getList) yield /*36.38*/ {_display_(Seq[Any](format.raw/*36.40*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/usuario/*37.23*/.id)),format.raw/*37.26*/("""" class="modalSeleccionDepartamento">
		<td> """),_display_(Seq[Any](/*38.9*/usuario/*38.16*/.nombre)),format.raw/*38.23*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.DepartamentosController.modalBuscar()))),format.raw/*45.108*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaDepartamentos");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.rrhh.routes.DepartamentosController.get())),format.raw/*53.67*/(""""
	contenedor.find('.modalSeleccionDepartamento').on('click', function()"""),format.raw/*54.71*/("""{"""),format.raw/*54.72*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.departamento.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[Departamento],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Departamento],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/departamento/modalBusquedaDepartamento.scala.html
                    HASH: e2a88266e6747a5cb1ed0309398d87382b5cb21f
                    MATRIX: 859->1|1042->102|1074->126|1148->81|1177->170|1313->271|1332->282|1403->332|1553->447|1661->533|1888->725|1931->759|1971->761|2068->841|2080->846|2118->847|2171->864|2188->872|2242->904|2452->1079|2500->1111|2540->1113|2593->1130|2609->1137|2634->1140|2716->1187|2732->1194|2761->1201|2816->1225|2931->1305|2945->1310|3064->1406|3108->1419|3171->1454|3200->1455|3304->1523|3324->1534|3388->1576|3489->1649|3518->1650|3622->1726|3651->1727|3752->1801|3780->1802|3812->1807|3840->1808|3923->1863|3952->1864|4092->1976|4121->1977|4188->2017|4216->2018|4265->2040|4293->2041|4324->2045|4352->2046
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            