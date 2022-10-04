
package views.html.rrhh.profesion

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
object modalBusquedaProfesion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Profesion],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Profesion], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaProfesiones" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.rrhh.routes.ProfesionesController.modalBuscar())),format.raw/*6.75*/("""" method="GET">
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
	    <em>No se encuentran Profesiones</em>
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
    	
    """),_display_(Seq[Any](/*36.6*/for(profesion <- buscador.getList) yield /*36.40*/ {_display_(Seq[Any](format.raw/*36.42*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/profesion/*37.25*/.id)),format.raw/*37.28*/("""" class="modalSeleccionProfesion">
		<td> """),_display_(Seq[Any](/*38.9*/profesion/*38.18*/.nombre)),format.raw/*38.25*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.ProfesionesController.modalBuscar()))),format.raw/*45.106*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaProfesiones");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.rrhh.routes.ProfesionesController.get())),format.raw/*53.65*/(""""
	contenedor.find('.modalSeleccionProfesion').on('click', function()"""),format.raw/*54.68*/("""{"""),format.raw/*54.69*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.profesion.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[Profesion],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Profesion],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/profesion/modalBusquedaProfesion.scala.html
                    HASH: e8e835540ade6681b8a0bfc1d16229b318ff8185
                    MATRIX: 850->1|1030->99|1062->123|1136->78|1165->167|1299->266|1318->277|1387->325|1537->440|1645->526|1872->718|1915->752|1955->754|2050->832|2062->837|2100->838|2153->855|2170->863|2224->895|2434->1070|2484->1104|2524->1106|2577->1123|2595->1132|2620->1135|2699->1179|2717->1188|2746->1195|2801->1219|2916->1299|2930->1304|3047->1398|3091->1411|3154->1446|3183->1447|3285->1513|3305->1524|3367->1564|3465->1634|3494->1635|3598->1711|3627->1712|3725->1783|3753->1784|3785->1789|3813->1790|3896->1845|3925->1846|4065->1958|4094->1959|4161->1999|4189->2000|4238->2022|4266->2023|4297->2027|4325->2028
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            