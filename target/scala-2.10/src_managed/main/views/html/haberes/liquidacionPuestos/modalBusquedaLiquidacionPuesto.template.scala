
package views.html.haberes.liquidacionPuestos

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
object modalBusquedaLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionPuesto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionPuesto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.102*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaPuestos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.LiquidacionPuestosController.modalBuscar())),format.raw/*6.85*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">N° Liquidaciones</label>
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
	    <em>No se encuentran Liquidaciones</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>N° Liquidación</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(lc <- buscador.getList) yield /*36.33*/ {_display_(Seq[Any](format.raw/*36.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/lc/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionLiquidacionPuesto">
		<td> """),_display_(Seq[Any](/*38.9*/lc/*38.11*/.liquidacionMes.nro_liquidacion_parque)),format.raw/*38.49*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionPuestosController.modalBuscar()))),format.raw/*45.116*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaLiquidacionPuestos");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.haberes.routes.LiquidacionPuestosController.get())),format.raw/*53.75*/(""""
	contenedor.find('.modalSeleccionLiquidacionPuesto').on('click', function()"""),format.raw/*54.76*/("""{"""),format.raw/*54.77*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.liquidacionPuesto.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionPuesto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionPuesto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/modalBusquedaLiquidacionPuesto.scala.html
                    HASH: 59376d4d7346e6772b06a6d971f725bb571193db
                    MATRIX: 893->1|1096->122|1128->146|1203->101|1232->190|1362->285|1381->296|1460->354|1620->479|1745->581|1972->773|2015->807|2055->809|2152->889|2164->894|2202->895|2255->912|2272->920|2326->952|2544->1135|2587->1162|2627->1164|2680->1181|2691->1183|2716->1186|2803->1238|2814->1240|2874->1278|2929->1302|3044->1382|3058->1387|3185->1491|3229->1504|3292->1539|3321->1540|3430->1613|3450->1624|3522->1674|3628->1752|3657->1753|3761->1829|3790->1830|3896->1909|3924->1910|3956->1915|3984->1916|4067->1971|4096->1972|4236->2084|4265->2085|4332->2125|4360->2126|4409->2148|4437->2149|4468->2153|4496->2154
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            