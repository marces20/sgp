
package views.html.haberes.liquidacionConceptos

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
object modalBusquedaLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionConcepto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionConcepto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.104*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaConceptos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*6.87*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Denominacion</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("denominacion"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.97*/("""
			
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
	    <em>No se encuentran Conceptos</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Codigo</th>	
				<th>Denominacion</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(lc <- buscador.getList) yield /*37.33*/ {_display_(Seq[Any](format.raw/*37.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/lc/*38.18*/.id)),format.raw/*38.21*/("""" class="modalSeleccionConcepto">
		<td>"""),_display_(Seq[Any](/*39.8*/lc/*39.10*/.codigo)),format.raw/*39.17*/("""</td>
		<td>"""),_display_(Seq[Any](/*40.8*/lc/*40.10*/.denominacion)),format.raw/*40.23*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionConceptosController.modalBuscar()))),format.raw/*47.118*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaConceptos");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.haberes.routes.LiquidacionConceptosController.get())),format.raw/*55.77*/(""""
	contenedor.find('.modalSeleccionConcepto').on('click', function()"""),format.raw/*56.67*/("""{"""),format.raw/*56.68*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.concepto.simple", data);
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*63.49*/("""{"""),format.raw/*63.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*66.38*/("""{"""),format.raw/*66.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionConcepto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionConcepto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/modalBusquedaLiquidacionConcepto.scala.html
                    HASH: dbf4300f17dd9088b0e0e3e1cb3824cd852e538b
                    MATRIX: 899->1|1104->124|1136->148|1211->103|1240->192|1372->289|1391->300|1472->360|1628->481|1742->573|1969->765|2012->799|2052->801|2145->877|2157->882|2195->883|2248->900|2265->908|2319->940|2557->1143|2600->1170|2640->1172|2693->1189|2704->1191|2729->1194|2806->1236|2817->1238|2846->1245|2895->1259|2906->1261|2941->1274|2996->1298|3111->1378|3125->1383|3254->1489|3298->1502|3361->1537|3390->1538|3490->1602|3510->1613|3584->1665|3681->1734|3710->1735|3814->1811|3843->1812|3940->1882|3968->1883|4000->1888|4028->1889|4111->1944|4140->1945|4280->2057|4309->2058|4376->2098|4404->2099|4453->2121|4481->2122|4512->2126|4540->2127
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            