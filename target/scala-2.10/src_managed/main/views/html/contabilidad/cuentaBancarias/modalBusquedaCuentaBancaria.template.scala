
package views.html.contabilidad.cuentaBancarias

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
object modalBusquedaCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CuentaBancaria],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CuentaBancaria], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCuentaBancarias" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.CuentaBancariasController.modalBuscar())),format.raw/*6.87*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Numero Cuenta</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("numero_cuenta"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.98*/("""
			
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
	    <em>No se encuentran Cuenta Bancarias</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero Cuenta</th>
				<th>Proveedor</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(cuentaBancaria <- buscador.getList) yield /*37.45*/ {_display_(Seq[Any](format.raw/*37.47*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/cuentaBancaria/*38.30*/.id)),format.raw/*38.33*/("""" class="modalSeleccionCuentaBancaria">
		<td> """),_display_(Seq[Any](/*39.9*/cuentaBancaria/*39.23*/.numero_cuenta)),format.raw/*39.37*/("""</td>
		<td> """),_display_(Seq[Any](/*40.9*/if(cuentaBancaria.proveedor != null)/*40.45*/{_display_(Seq[Any](_display_(Seq[Any](/*40.47*/(cuentaBancaria.proveedor.nombre)))))})),format.raw/*40.81*/("""</td>
							 
	</tr>    
    """)))})),format.raw/*43.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*48.7*/views/*48.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentaBancariasController.modalBuscar()))),format.raw/*48.118*/("""
	</div>	
""")))})),format.raw/*50.2*/("""
</div>

<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	var contenedor = $("#modalBusquedaCuentaBancarias");
	var url = """"),_display_(Seq[Any](/*56.14*/controllers/*56.25*/.contabilidad.routes.CuentaBancariasController.get())),format.raw/*56.77*/(""""
	contenedor.find('.modalSeleccionCuentaBancaria').on('click', function()"""),format.raw/*57.73*/("""{"""),format.raw/*57.74*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*59.38*/("""{"""),format.raw/*59.39*/("""
			$(document).trigger("modal.seleccion.cuentaBancaria.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[CuentaBancaria],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CuentaBancaria],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/modalBusquedaCuentaBancaria.scala.html
                    HASH: c670df8125b1dcbdc92f49ea192a386cd9262386
                    MATRIX: 874->1|1059->104|1091->128|1165->83|1194->172|1332->275|1351->286|1432->346|1589->468|1704->561|1931->753|1974->787|2014->789|2114->872|2126->877|2164->878|2217->895|2234->903|2288->935|2529->1141|2584->1180|2624->1182|2677->1199|2700->1213|2725->1216|2809->1265|2832->1279|2868->1293|2918->1308|2963->1344|3011->1346|3071->1380|3136->1414|3251->1494|3265->1499|3394->1605|3438->1618|3501->1653|3530->1654|3636->1724|3656->1735|3730->1787|3833->1862|3862->1863|3966->1939|3995->1940|4098->2016|4126->2017|4158->2022|4186->2023|4269->2078|4298->2079|4438->2191|4467->2192|4534->2232|4562->2233|4611->2255|4639->2256|4670->2260|4698->2261
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|68->40|71->43|76->48|76->48|76->48|78->50|82->54|82->54|84->56|84->56|84->56|85->57|85->57|87->59|87->59|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            