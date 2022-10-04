
package views.html.patrimonio.ordenesProvision

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
object modalBusquedaOrdenProvision extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenProvision],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenProvision], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaOrdenProvision" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.patrimonio.routes.OrdenesProvisionController.modalBuscar())),format.raw/*6.86*/("""" method="GET">
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
	    <em>No se encuentran orden de provision</em>
	</div>
""")))}/*31.3*/else/*31.8*/{_display_(Seq[Any](format.raw/*31.9*/("""
    Mostrando """),_display_(Seq[Any](/*32.16*/buscador/*32.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*32.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Ejercicio</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*43.6*/for(op <- buscador.getList) yield /*43.33*/ {_display_(Seq[Any](format.raw/*43.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*44.16*/op/*44.18*/.id)),format.raw/*44.21*/("""" class="modalSeleccionOrdenProvision pointer">
		<td> """),_display_(Seq[Any](/*45.9*/op/*45.11*/.numero)),format.raw/*45.18*/("""</td>
		<td> """),_display_(Seq[Any](/*46.9*/op/*46.11*/.ejercicio.nombre)),format.raw/*46.28*/("""</td>
	</tr>    
    """)))})),format.raw/*48.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*53.7*/views/*53.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.modalBuscar()))),format.raw/*53.117*/("""
	</div>	
""")))})),format.raw/*55.2*/("""
</div>

<script>
$( function()"""),format.raw/*59.14*/("""{"""),format.raw/*59.15*/("""
	var contenedor = $("#modalBusquedaOrdenProvision");
	var url = """"),_display_(Seq[Any](/*61.14*/controllers/*61.25*/.patrimonio.routes.OrdenesProvisionController.get())),format.raw/*61.76*/(""""
	contenedor.find('.modalSeleccionOrdenProvision').on('click', function()"""),format.raw/*62.73*/("""{"""),format.raw/*62.74*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*64.38*/("""{"""),format.raw/*64.39*/("""
			$(document).trigger("modal.seleccion.ordenProvision.simple", data);
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/(""");
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*69.49*/("""{"""),format.raw/*69.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*72.38*/("""{"""),format.raw/*72.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*74.3*/("""}"""),format.raw/*74.4*/(""");
		return false;
	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/(""");
"""),format.raw/*77.1*/("""}"""),format.raw/*77.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenProvision],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenProvision],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/modalBusquedaOrdenProvision.scala.html
                    HASH: 73f34d0464afc1bbcaf1c1e5f126e244bb0589ee
                    MATRIX: 873->1|1057->102|1089->126|1163->83|1191->170|1325->269|1344->280|1424->339|1570->450|1678->536|1805->628|1987->787|2203->968|2246->1002|2286->1004|2384->1085|2396->1090|2434->1091|2486->1107|2503->1115|2557->1147|2780->1335|2823->1362|2863->1364|2915->1380|2926->1382|2951->1385|3042->1441|3053->1443|3082->1450|3131->1464|3142->1466|3181->1483|3234->1505|3344->1580|3358->1585|3486->1690|3528->1701|3587->1732|3616->1733|3719->1800|3739->1811|3812->1862|3914->1936|3943->1937|4045->2011|4074->2012|4175->2086|4203->2087|4234->2091|4262->2092|4343->2145|4372->2146|4509->2255|4538->2256|4603->2294|4631->2295|4678->2315|4706->2316|4736->2319|4764->2320
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|43->15|43->15|55->27|55->27|55->27|59->31|59->31|59->31|60->32|60->32|60->32|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|76->48|81->53|81->53|81->53|83->55|87->59|87->59|89->61|89->61|89->61|90->62|90->62|92->64|92->64|94->66|94->66|95->67|95->67|97->69|97->69|100->72|100->72|102->74|102->74|104->76|104->76|105->77|105->77
                    -- GENERATED --
                */
            