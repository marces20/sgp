
package views.html.compras.clientes

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
object modalBusquedaClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Cliente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Cliente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaClientes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.ClientesController.modalBuscar())),format.raw/*6.75*/("""" method="GET">
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
	    <em>No se encuentran clientes</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>ID-Rismi</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*38.6*/for(cliente <- buscador.getList) yield /*38.38*/ {_display_(Seq[Any](format.raw/*38.40*/("""
	<tr data-id=""""),_display_(Seq[Any](/*39.16*/cliente/*39.23*/.id)),format.raw/*39.26*/("""" class="modalSeleccionClientes">
		<td>"""),_display_(Seq[Any](/*40.8*/cliente/*40.15*/.nombre)),format.raw/*40.22*/("""</td>
		<td>"""),_display_(Seq[Any](/*41.8*/if(cliente.dni != null)/*41.31*/{_display_(Seq[Any](_display_(Seq[Any](/*41.33*/cliente/*41.40*/.dni))))})),format.raw/*41.45*/("""</td>
		<td>"""),_display_(Seq[Any](/*42.8*/if(cliente.id_paciente_rismi != null)/*42.45*/{_display_(Seq[Any](_display_(Seq[Any](/*42.47*/cliente/*42.54*/.id_paciente_rismi))))})),format.raw/*42.73*/("""</td>
	</tr>    
    """)))})),format.raw/*44.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*49.7*/views/*49.12*/.html.helpers.paginador(buscador, controllers.compras.routes.ClientesController.modalBuscar()))),format.raw/*49.106*/("""
	</div>	
""")))})),format.raw/*51.2*/("""
</div>

<script>
$( function()"""),format.raw/*55.14*/("""{"""),format.raw/*55.15*/("""
	var contenedor = $("#modalBusquedaClientes");
	var url = """"),_display_(Seq[Any](/*57.14*/controllers/*57.25*/.compras.routes.ClientesController.get())),format.raw/*57.65*/(""""
	contenedor.find('.modalSeleccionClientes').on('click', function()"""),format.raw/*58.67*/("""{"""),format.raw/*58.68*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*60.38*/("""{"""),format.raw/*60.39*/("""
			if(data.success)
				$(document).trigger("modal.seleccion.cliente.simple", data);
			else
				alert(data.message);
		"""),format.raw/*65.3*/("""}"""),format.raw/*65.4*/(""");
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*68.49*/("""{"""),format.raw/*68.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*71.38*/("""{"""),format.raw/*71.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*73.3*/("""}"""),format.raw/*73.4*/(""");
		return false;
	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/(""");
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Cliente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Cliente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/modalBusquedaClientes.scala.html
                    HASH: eb4ee4c0f6806b9da4befb00a3d884cda725134e
                    MATRIX: 849->1|1027->97|1059->121|1133->76|1162->165|1293->261|1312->272|1381->320|1531->435|1639->521|1866->713|1909->747|1949->749|2041->824|2053->829|2091->830|2144->847|2161->855|2215->887|2466->1103|2514->1135|2554->1137|2607->1154|2623->1161|2648->1164|2725->1206|2741->1213|2770->1220|2819->1234|2851->1257|2899->1259|2915->1266|2946->1271|2995->1285|3041->1322|3089->1324|3105->1331|3150->1350|3205->1374|3320->1454|3334->1459|3451->1553|3495->1566|3558->1601|3587->1602|3686->1665|3706->1676|3768->1716|3865->1785|3894->1786|3998->1862|4027->1863|4180->1989|4208->1990|4240->1995|4268->1996|4351->2051|4380->2052|4520->2164|4549->2165|4616->2205|4644->2206|4693->2228|4721->2229|4752->2233|4780->2234
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|72->44|77->49|77->49|77->49|79->51|83->55|83->55|85->57|85->57|85->57|86->58|86->58|88->60|88->60|93->65|93->65|94->66|94->66|96->68|96->68|99->71|99->71|101->73|101->73|103->75|103->75|104->76|104->76
                    -- GENERATED --
                */
            