
package views.html.contabilidad.ordenesPagos

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
object modalBusquedaOrdenes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenPago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenPago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaOrdenes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*6.84*/("""" method="GET">
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Número</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
		</div>
		<div class="col-sm-3">
			<label class="control-label">Ejercicio</label>
			"""),_display_(Seq[Any](/*14.5*/select(formBuscador("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*14.167*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*25.2*/if(buscador.getTotalRowCount == 0)/*25.36*/ {_display_(Seq[Any](format.raw/*25.38*/("""
	<div class="well">
	    <em>No se encuentran órdenes</em>
	</div>
""")))}/*29.3*/else/*29.8*/{_display_(Seq[Any](format.raw/*29.9*/("""
    Mostrando """),_display_(Seq[Any](/*30.16*/buscador/*30.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*30.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Número</th>
				<th>Ejercicio</th>
				<th>Monto</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*42.6*/for(orden <- buscador.getList) yield /*42.36*/ {_display_(Seq[Any](format.raw/*42.38*/("""
	<tr data-id=""""),_display_(Seq[Any](/*43.16*/orden/*43.21*/.id)),format.raw/*43.24*/("""" class="modalSeleccionExpediente pointer">
		<td> """),_display_(Seq[Any](/*44.9*/orden/*44.14*/.numero)),format.raw/*44.21*/("""</td>
		<td> """),_display_(Seq[Any](/*45.9*/orden/*45.14*/.ejercicio.nombre)),format.raw/*45.31*/("""</td>
		<td> """),_display_(Seq[Any](/*46.9*/(utils.NumberUtils.moneda(orden.monto)))),format.raw/*46.48*/("""</td>
	</tr>    
    """)))})),format.raw/*48.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*53.7*/views/*53.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.OrdenesPagosController.modalBuscar()))),format.raw/*53.115*/("""
	</div>	
""")))})),format.raw/*55.2*/("""
</div>

<script>
$( function()"""),format.raw/*59.14*/("""{"""),format.raw/*59.15*/("""
	var contenedor = $("#modalBusquedaOrdenes");
	var url = """"),_display_(Seq[Any](/*61.14*/controllers/*61.25*/.contabilidad.routes.OrdenesPagosController.get())),format.raw/*61.74*/(""""
	contenedor.find('.modalSeleccionExpediente').on('click', function()"""),format.raw/*62.69*/("""{"""),format.raw/*62.70*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*64.38*/("""{"""),format.raw/*64.39*/("""
			$(document).trigger("modal.seleccion.orden-pago.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[OrdenPago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenPago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagos/modalBusquedaOrdenes.scala.html
                    HASH: 46158b616974da775f91a95608b762e38a515649
                    MATRIX: 859->1|1039->99|1071->123|1145->78|1174->167|1304->262|1323->273|1401->330|1551->445|1659->531|1787->624|1972->786|2198->977|2241->1011|2281->1013|2372->1087|2384->1092|2422->1093|2475->1110|2492->1118|2546->1150|2800->1369|2846->1399|2886->1401|2939->1418|2953->1423|2978->1426|3066->1479|3080->1484|3109->1491|3159->1506|3173->1511|3212->1528|3262->1543|3323->1582|3378->1606|3493->1686|3507->1691|3633->1794|3677->1807|3740->1842|3769->1843|3867->1905|3887->1916|3958->1965|4057->2036|4086->2037|4190->2113|4219->2114|4318->2186|4346->2187|4378->2192|4406->2193|4489->2248|4518->2249|4658->2361|4687->2362|4754->2402|4782->2403|4831->2425|4859->2426|4890->2430|4918->2431
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|42->14|42->14|53->25|53->25|53->25|57->29|57->29|57->29|58->30|58->30|58->30|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|76->48|81->53|81->53|81->53|83->55|87->59|87->59|89->61|89->61|89->61|90->62|90->62|92->64|92->64|94->66|94->66|95->67|95->67|97->69|97->69|100->72|100->72|102->74|102->74|104->76|104->76|105->77|105->77
                    -- GENERATED --
                */
            