
package views.html.patrimonio.inventario

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
object modalBusquedaPrefijos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[InventarioPrefijo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[InventarioPrefijo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalSeleccionPrefijo" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.patrimonio.routes.PrefijosController.modalBuscar())),format.raw/*6.78*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Prefijo o nombre</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("prefijo"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.92*/("""
			
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
	    <em>No se encuentran prefijos</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Prefijo</th>
				<th>Descripción</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(prefijo <- buscador.getList) yield /*37.38*/ {_display_(Seq[Any](format.raw/*37.40*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/prefijo/*38.23*/.id)),format.raw/*38.26*/("""" class="modalSeleccionPrefijo">
		<td> """),_display_(Seq[Any](/*39.9*/prefijo/*39.16*/.prefijo)),format.raw/*39.24*/("""</td>
		<td> """),_display_(Seq[Any](/*40.9*/prefijo/*40.16*/.nombre)),format.raw/*40.23*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.PrefijosController.modalBuscar()))),format.raw/*47.109*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalSeleccionPrefijo");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.patrimonio.routes.PrefijosController.get())),format.raw/*55.68*/(""""
	contenedor.find('.modalSeleccionPrefijo').on('click', function()"""),format.raw/*56.66*/("""{"""),format.raw/*56.67*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			if(data.success)
				$(document).trigger("modal.seleccion.prefijo.simple", data);
			else
				alert(data.message);
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/(""");
	"""),format.raw/*64.2*/("""}"""),format.raw/*64.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*66.49*/("""{"""),format.raw/*66.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*69.38*/("""{"""),format.raw/*69.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*71.3*/("""}"""),format.raw/*71.4*/(""");
		return false;
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[InventarioPrefijo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[InventarioPrefijo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/inventario/modalBusquedaPrefijos.scala.html
                    HASH: f61a8762b73ef5ab78e6d75f9f92e5f3f5839b68
                    MATRIX: 864->1|1052->107|1084->131|1158->86|1187->175|1318->271|1337->282|1409->333|1569->458|1678->545|1905->737|1948->771|1988->773|2080->848|2092->853|2130->854|2183->871|2200->879|2254->911|2491->1113|2539->1145|2579->1147|2632->1164|2648->1171|2673->1174|2750->1216|2766->1223|2796->1231|2846->1246|2862->1253|2891->1260|2946->1284|3061->1364|3075->1369|3195->1466|3239->1479|3302->1514|3331->1515|3430->1578|3450->1589|3515->1632|3611->1700|3640->1701|3744->1777|3773->1778|3926->1904|3954->1905|3986->1910|4014->1911|4097->1966|4126->1967|4266->2079|4295->2080|4362->2120|4390->2121|4439->2143|4467->2144|4498->2148|4526->2149
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|91->63|91->63|92->64|92->64|94->66|94->66|97->69|97->69|99->71|99->71|101->73|101->73|102->74|102->74
                    -- GENERATED --
                */
            