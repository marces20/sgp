
package views.html.compras.ordenes

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
object modalBusquedaOrdenes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Orden],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Orden], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaOrdenes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.OrdenesController.modalBuscar())),format.raw/*6.74*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Referencia</label>
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
	    <em>No se encuentran ordenes</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Referencia</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(orden <- buscador.getList) yield /*36.36*/ {_display_(Seq[Any](format.raw/*36.38*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/orden/*37.21*/.id)),format.raw/*37.24*/("""" class="modalSeleccionOrdenes">
		<td>"""),_display_(Seq[Any](/*38.8*/orden/*38.13*/.nombre)),format.raw/*38.20*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.compras.routes.OrdenesController.modalBuscar()))),format.raw/*45.105*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaOrdenes");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.compras.routes.OrdenesController.get())),format.raw/*53.64*/(""""
	contenedor.find('.modalSeleccionOrdenes').on('click', function()"""),format.raw/*54.66*/("""{"""),format.raw/*54.67*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			if(data.success)		  
				$(document).trigger("modal.seleccion.orden.simple", data);
			else
				alert(data.message);
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
    
    def render(buscador:utils.pagination.Pagination[Orden],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Orden],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modalBusquedaOrdenes.scala.html
                    HASH: a70a0a4fef25b1b9d83348a14cd41a78e65b8782
                    MATRIX: 845->1|1021->95|1053->119|1127->74|1156->163|1286->258|1305->269|1373->316|1527->435|1635->521|1862->713|1905->747|1945->749|2036->823|2048->828|2086->829|2139->846|2156->854|2210->886|2424->1065|2470->1095|2510->1097|2563->1114|2577->1119|2602->1122|2678->1163|2692->1168|2721->1175|2776->1199|2891->1279|2905->1284|3021->1377|3065->1390|3128->1425|3157->1426|3255->1488|3275->1499|3336->1538|3432->1606|3461->1607|3565->1683|3594->1684|3749->1812|3777->1813|3809->1818|3837->1819|3920->1874|3949->1875|4089->1987|4118->1988|4185->2028|4213->2029|4262->2051|4290->2052|4321->2056|4349->2057
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            