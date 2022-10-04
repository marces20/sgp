
package views.html.contabilidad.facturas

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
object modalBusquedaFacturas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Factura],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Factura], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaFacturas" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.FacturasController.modalBuscar())),format.raw/*6.80*/("""" method="GET">
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
	    <em>No se encuentran facturas</em>
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
    	
    """),_display_(Seq[Any](/*36.6*/for(factura <- buscador.getList) yield /*36.38*/ {_display_(Seq[Any](format.raw/*36.40*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/factura/*37.23*/.id)),format.raw/*37.26*/("""" class="modalSeleccionFacturas">
		<td>"""),_display_(Seq[Any](/*38.8*/factura/*38.15*/.nombre)),format.raw/*38.22*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.FacturasController.modalBuscar()))),format.raw/*45.111*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaFacturas");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.contabilidad.routes.FacturasController.get())),format.raw/*53.70*/(""""
	contenedor.find('.modalSeleccionFacturas').on('click', function()"""),format.raw/*54.67*/("""{"""),format.raw/*54.68*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			if(data.success)		  
				$(document).trigger("modal.seleccion.factura.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[Factura],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Factura],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/modalBusquedaFacturas.scala.html
                    HASH: f291d9b1ed021b2a47db3872fec323c5d81fbaca
                    MATRIX: 854->1|1032->97|1064->121|1138->76|1167->165|1298->261|1317->272|1391->325|1545->444|1653->530|1880->722|1923->756|1963->758|2055->833|2067->838|2105->839|2158->856|2175->864|2229->896|2443->1075|2491->1107|2531->1109|2584->1126|2600->1133|2625->1136|2702->1178|2718->1185|2747->1192|2802->1216|2917->1296|2931->1301|3053->1400|3097->1413|3160->1448|3189->1449|3288->1512|3308->1523|3375->1568|3472->1637|3501->1638|3605->1714|3634->1715|3791->1845|3819->1846|3851->1851|3879->1852|3962->1907|3991->1908|4131->2020|4160->2021|4227->2061|4255->2062|4304->2084|4332->2085|4363->2089|4391->2090
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            