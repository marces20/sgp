
package views.html.rrhh.tipoResidencia

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
object modalBusquedaTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[TipoResidencia],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[TipoResidencia], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaTipoResidencias" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.rrhh.routes.TipoResidenciasController.modalBuscar())),format.raw/*6.79*/("""" method="GET">
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
	    <em>No se encuentran Tipo Residencias</em>
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
    	
    """),_display_(Seq[Any](/*36.6*/for(tr <- buscador.getList) yield /*36.33*/ {_display_(Seq[Any](format.raw/*36.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/tr/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionTipoResidencia">
		<td> """),_display_(Seq[Any](/*38.9*/tr/*38.11*/.nombre)),format.raw/*38.18*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.TipoResidenciasController.modalBuscar()))),format.raw/*45.110*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaTipoResidencias");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.rrhh.routes.TipoResidenciasController.get())),format.raw/*53.69*/(""""
	contenedor.find('.modalSeleccionTipoResidencia').on('click', function()"""),format.raw/*54.73*/("""{"""),format.raw/*54.74*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.tipoResidencia.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[TipoResidencia],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[TipoResidencia],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/modalBusquedaTipoResidencia.scala.html
                    HASH: 7c3abedb1a6cc39670bb507e279dbc6a78cda16b
                    MATRIX: 865->1|1049->102|1081->126|1155->83|1183->170|1318->270|1337->281|1410->333|1556->444|1664->530|1880->711|1923->745|1963->747|2059->826|2071->831|2109->832|2161->848|2178->856|2232->888|2432->1053|2475->1080|2515->1082|2567->1098|2578->1100|2603->1103|2686->1151|2697->1153|2726->1160|2779->1182|2889->1257|2903->1262|3024->1360|3066->1371|3125->1402|3154->1403|3258->1471|3278->1482|3344->1526|3446->1600|3475->1601|3577->1675|3606->1676|3707->1750|3735->1751|3766->1755|3794->1756|3875->1809|3904->1810|4041->1919|4070->1920|4135->1958|4163->1959|4210->1979|4238->1980|4268->1983|4296->1984
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            