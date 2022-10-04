
package views.html.haberes.liquidacionMeses

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
object modalBusquedaLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionMes],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionMes], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.99*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaMeses" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.LiquidacionMesesController.modalBuscar())),format.raw/*6.83*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">N° Liquidación</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("nro_liquidacion_parque"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.107*/("""
			
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
	    <em>No se encuentran Liquidación</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>N° Liquidación</th>
				<th>Titulo</th>
				<th>Convenio</th>
				<th>Periodo</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*39.6*/for(lc <- buscador.getList) yield /*39.33*/ {_display_(Seq[Any](format.raw/*39.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*40.16*/lc/*40.18*/.id)),format.raw/*40.21*/("""" class="modalSeleccionLiquidacionMes">
		<td>"""),_display_(Seq[Any](/*41.8*/lc/*41.10*/.nro_liquidacion_parque)),format.raw/*41.33*/("""</td>
		<td>"""),_display_(Seq[Any](/*42.8*/lc/*42.10*/.titulo)),format.raw/*42.17*/("""</td>
		<td>"""),_display_(Seq[Any](/*43.8*/if(lc.convenio_ministerio)/*43.34*/{_display_(Seq[Any](format.raw/*43.35*/("""SI""")))}/*43.38*/else/*43.42*/{_display_(Seq[Any](format.raw/*43.43*/("""NO""")))})),format.raw/*43.46*/("""</td>
		<td>"""),_display_(Seq[Any](/*44.8*/(lc.periodo.nombre))),format.raw/*44.27*/("""</td>
	</tr>    
    """)))})),format.raw/*46.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*51.7*/views/*51.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionMesesController.modalBuscar()))),format.raw/*51.114*/("""
	</div>	
""")))})),format.raw/*53.2*/("""
</div>

<script>
$( function()"""),format.raw/*57.14*/("""{"""),format.raw/*57.15*/("""
	var contenedor = $("#modalBusquedaMeses");
										   
	var url = """"),_display_(Seq[Any](/*60.14*/controllers/*60.25*/.haberes.routes.LiquidacionMesesController.get())),format.raw/*60.73*/(""""
	contenedor.find('.modalSeleccionLiquidacionMes').on('click', function()"""),format.raw/*61.73*/("""{"""),format.raw/*61.74*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*63.38*/("""{"""),format.raw/*63.39*/("""
			$(document).trigger("modal.seleccion.liquidacionMes.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionMes],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionMes],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/modalBusquedaLiquidacionMes.scala.html
                    HASH: 766f29ff19d2e9b18e033f4dcf34c78dc54c103a
                    MATRIX: 885->1|1085->119|1117->143|1191->98|1220->187|1348->280|1367->291|1444->347|1602->470|1727->572|1954->764|1997->798|2037->800|2132->878|2144->883|2182->884|2235->901|2252->909|2306->941|2590->1190|2633->1217|2673->1219|2726->1236|2737->1238|2762->1241|2845->1289|2856->1291|2901->1314|2950->1328|2961->1330|2990->1337|3039->1351|3074->1377|3113->1378|3135->1381|3148->1385|3187->1386|3222->1389|3271->1403|3312->1422|3367->1446|3482->1526|3496->1531|3621->1633|3665->1646|3728->1681|3757->1682|3868->1757|3888->1768|3958->1816|4061->1891|4090->1892|4194->1968|4223->1969|4326->2045|4354->2046|4386->2051|4414->2052|4497->2107|4526->2108|4666->2220|4695->2221|4762->2261|4790->2262|4839->2284|4867->2285|4898->2289|4926->2290
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|74->46|79->51|79->51|79->51|81->53|85->57|85->57|88->60|88->60|88->60|89->61|89->61|91->63|91->63|93->65|93->65|94->66|94->66|96->68|96->68|99->71|99->71|101->73|101->73|103->75|103->75|104->76|104->76
                    -- GENERATED --
                */
            