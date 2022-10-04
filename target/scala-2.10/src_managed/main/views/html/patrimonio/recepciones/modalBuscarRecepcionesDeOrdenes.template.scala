
package views.html.patrimonio.recepciones

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
object modalBuscarRecepcionesDeOrdenes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Recepcion],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Recepcion], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaRecepciones" class="contenedorPaginador ajaxPaginador">


"""),_display_(Seq[Any](/*8.2*/if(buscador.getTotalRowCount == 0)/*8.36*/ {_display_(Seq[Any](format.raw/*8.38*/("""
	<div class="well">
	    <em>No se encuentran recepciones</em>
	</div>
""")))}/*12.3*/else/*12.8*/{_display_(Seq[Any](format.raw/*12.9*/("""
    Mostrando """),_display_(Seq[Any](/*13.16*/buscador/*13.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*13.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*23.6*/for(recepcion <- buscador.getList) yield /*23.40*/ {_display_(Seq[Any](format.raw/*23.42*/("""
	<tr data-id=""""),_display_(Seq[Any](/*24.16*/recepcion/*24.25*/.id)),format.raw/*24.28*/("""" class="modalSeleccionRecepcion pointer">
		<td> """),_display_(Seq[Any](/*25.9*/recepcion/*25.18*/.numero)),format.raw/*25.25*/("""</td>
	</tr>    
    """)))})),format.raw/*27.6*/("""
    </tbody>
    </table>
    
	 
""")))})),format.raw/*32.2*/("""
</div>

<script>
$( function()"""),format.raw/*36.14*/("""{"""),format.raw/*36.15*/("""
	var contenedor = $("#modalBusquedaRecepciones");
	var url = """"),_display_(Seq[Any](/*38.14*/controllers/*38.25*/.patrimonio.routes.RecepcionesController.get())),format.raw/*38.71*/(""""
	contenedor.find('.modalSeleccionRecepcion').on('click', function()"""),format.raw/*39.68*/("""{"""),format.raw/*39.69*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*41.38*/("""{"""),format.raw/*41.39*/("""
			$(document).trigger("modal.seleccion.recepcion.simple", data);
		"""),format.raw/*43.3*/("""}"""),format.raw/*43.4*/(""");
	"""),format.raw/*44.2*/("""}"""),format.raw/*44.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*46.49*/("""{"""),format.raw/*46.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*49.38*/("""{"""),format.raw/*49.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*51.3*/("""}"""),format.raw/*51.4*/(""");
		return false;
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/(""");
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Recepcion],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Recepcion],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/modalBuscarRecepcionesDeOrdenes.scala.html
                    HASH: 8fc99a351d286e1dd400c5d0f91474fc9002649a
                    MATRIX: 867->1|1047->99|1079->123|1153->78|1182->167|1305->256|1347->290|1386->292|1481->370|1493->375|1531->376|1584->393|1601->401|1655->433|1865->608|1915->642|1955->644|2008->661|2026->670|2051->673|2138->725|2156->734|2185->741|2240->765|2312->806|2375->841|2404->842|2506->908|2526->919|2594->965|2692->1035|2721->1036|2825->1112|2854->1113|2952->1184|2980->1185|3012->1190|3040->1191|3123->1246|3152->1247|3292->1359|3321->1360|3388->1400|3416->1401|3465->1423|3493->1424|3524->1428|3552->1429
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|40->12|40->12|40->12|41->13|41->13|41->13|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|55->27|60->32|64->36|64->36|66->38|66->38|66->38|67->39|67->39|69->41|69->41|71->43|71->43|72->44|72->44|74->46|74->46|77->49|77->49|79->51|79->51|81->53|81->53|82->54|82->54
                    -- GENERATED --
                */
            