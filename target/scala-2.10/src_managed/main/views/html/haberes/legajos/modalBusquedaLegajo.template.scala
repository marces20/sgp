
package views.html.haberes.legajos

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
object modalBusquedaLegajo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.Legajo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.Legajo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.91*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaLegajos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.LegajosController.modalBuscar())),format.raw/*6.74*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Agente</label>
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
	    <em>No se encuentran Legajo</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Agente</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(lc <- buscador.getList) yield /*37.33*/ {_display_(Seq[Any](format.raw/*37.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/lc/*38.18*/.id)),format.raw/*38.21*/("""" class="modalSeleccionLegajo">
		<td> """),_display_(Seq[Any](/*39.9*/lc/*39.11*/.numero)),format.raw/*39.18*/("""</td>
		<td> """),_display_(Seq[Any](/*40.9*/lc/*40.11*/.agente.apellido)),format.raw/*40.27*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.LegajosController.modalBuscar()))),format.raw/*47.105*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaLegajos");
										   
	var url = """"),_display_(Seq[Any](/*56.14*/controllers/*56.25*/.haberes.routes.LegajosController.get())),format.raw/*56.64*/(""""
	contenedor.find('.modalSeleccionLegajo').on('click', function()"""),format.raw/*57.65*/("""{"""),format.raw/*57.66*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*59.38*/("""{"""),format.raw/*59.39*/("""
			$(document).trigger("modal.seleccion.legajo.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.Legajo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.Legajo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/legajos/modalBusquedaLegajo.scala.html
                    HASH: 0bf41012167769adc897a986403bb9077ce0b743
                    MATRIX: 860->1|1052->111|1084->135|1158->90|1187->179|1317->274|1336->285|1404->332|1554->447|1662->533|1889->725|1932->759|1972->761|2062->834|2074->839|2112->840|2165->857|2182->865|2236->897|2467->1093|2510->1120|2550->1122|2603->1139|2614->1141|2639->1144|2715->1185|2726->1187|2755->1194|2805->1209|2816->1211|2854->1227|2909->1251|3024->1331|3038->1336|3154->1429|3198->1442|3261->1477|3290->1478|3403->1555|3423->1566|3484->1605|3579->1672|3608->1673|3712->1749|3741->1750|3836->1818|3864->1819|3896->1824|3924->1825|4007->1880|4036->1881|4176->1993|4205->1994|4272->2034|4300->2035|4349->2057|4377->2058|4408->2062|4436->2063
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|84->56|84->56|84->56|85->57|85->57|87->59|87->59|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            