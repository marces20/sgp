
package views.html.patrimonio.remitos

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
object indexRemitosAjax extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Remito],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Remito], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*5.70*/(""" 

<div id="resultadoRemitos" class="contenedorPaginador ajaxPaginador">
"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = controllers.patrimonio.routes.RemitosController.indexAjax(), 'id -> "buscadorRemitos")/*8.109*/ {_display_(Seq[Any](format.raw/*8.111*/("""

<div class="row">	

	"""),_display_(Seq[Any](/*12.3*/inputText(formBuscador("recepcion_id"), 'type -> "hidden"))),format.raw/*12.61*/("""

	<div class="form-group col-sm-2">
		<label for="numero" class="control-label">Número
		"""),_display_(Seq[Any](/*16.4*/inputText(formBuscador("numero"), 'class -> "form-control", 'numero -> "form-control", 'autofocus -> "autofocus"))),format.raw/*16.117*/("""
		</label>
	</div>

	<div class="col-sm-5">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*23.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*23.119*/("""
			"""),_display_(Seq[Any](/*24.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*24.86*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*25.114*/controllers/*25.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*25.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	
</div>
""")))})),format.raw/*38.2*/("""


   """),_display_(Seq[Any](/*41.5*/if(buscador.getTotalRowCount == 0)/*41.39*/ {_display_(Seq[Any](format.raw/*41.41*/("""
        
       <div class="well">
           <em>No se encuentran remitos</em>
       </div>
        
    """)))}/*47.7*/else/*47.12*/{_display_(Seq[Any](format.raw/*47.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*49.14*/buscador/*49.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*49.54*/(""" resultado(s).   
		<table id="listaRemitos" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="100">Número</th>
					<th width="100">Fecha</th>
					<th width="100">Total</th>
					<th>Responsable</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*60.12*/for(remito <- buscador.getList) yield /*60.43*/ {_display_(Seq[Any](format.raw/*60.45*/("""
				<tr class="pointer" data-url=""""),_display_(Seq[Any](/*61.36*/controllers/*61.47*/.patrimonio.routes.RemitosController.ver(remito.id))),format.raw/*61.98*/("""">
					<td>"""),_display_(Seq[Any](/*62.11*/remito/*62.17*/.numero)),format.raw/*62.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*63.11*/DateUtils/*63.20*/.formatDate(remito.create_date))),format.raw/*63.51*/("""</td>
					<td>"""),_display_(Seq[Any](/*64.11*/utils/*64.16*/.NumberUtils.moneda(remito.total))),format.raw/*64.49*/("""</td>
					<td>"""),_display_(Seq[Any](/*65.11*/remito/*65.17*/.create_usuario.nombre)),format.raw/*65.39*/("""</td>
				</tr>
              	""")))})),format.raw/*67.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*72.8*/views/*72.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosController.indexAjax()))),format.raw/*72.107*/("""
		</div>
        
    """)))})),format.raw/*75.6*/("""

<script>
$( function() """),format.raw/*78.15*/("""{"""),format.raw/*78.16*/("""
	$('#searchProducto').modalSearch();
	
	var resultados = $('#resultadoRemitos');
	
	$('#buscadorRemitos').submit( function() """),format.raw/*83.43*/("""{"""),format.raw/*83.44*/("""
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data)"""),format.raw/*86.49*/("""{"""),format.raw/*86.50*/("""
			resultados.replaceWith(data);
		"""),format.raw/*88.3*/("""}"""),format.raw/*88.4*/(""");
		
		return false;
	"""),format.raw/*91.2*/("""}"""),format.raw/*91.3*/(""");
	
	
	$('#listaRemitos tbody tr').click( function() """),format.raw/*94.48*/("""{"""),format.raw/*94.49*/("""
		window.location = $(this).attr("data-url");;
	"""),format.raw/*96.2*/("""}"""),format.raw/*96.3*/(""");
"""),format.raw/*97.1*/("""}"""),format.raw/*97.2*/(""")
</script>
</div>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Remito],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Remito],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/indexRemitosAjax.scala.html
                    HASH: 2e3eb30854aede808a36ad01b43a1ed6b3a8af4f
                    MATRIX: 845->1|1062->136|1094->160|1168->75|1197->204|1308->281|1321->287|1431->388|1471->390|1534->418|1614->476|1744->571|1880->684|2062->831|2199->945|2240->951|2343->1032|2495->1147|2516->1158|2588->1207|3084->1672|3129->1682|3172->1716|3212->1718|3345->1834|3358->1839|3397->1840|3452->1859|3469->1867|3523->1899|3858->2198|3905->2229|3945->2231|4018->2268|4038->2279|4111->2330|4161->2344|4176->2350|4205->2357|4258->2374|4276->2383|4329->2414|4382->2431|4396->2436|4451->2469|4504->2486|4519->2492|4563->2514|4629->2548|4741->2625|4755->2630|4872->2724|4930->2751|4986->2779|5015->2780|5174->2911|5203->2912|5322->3003|5351->3004|5416->3042|5444->3043|5497->3069|5525->3070|5610->3127|5639->3128|5717->3179|5745->3180|5776->3184|5804->3185
                    LINES: 26->1|33->5|33->5|34->1|35->5|38->8|38->8|38->8|38->8|42->12|42->12|46->16|46->16|53->23|53->23|54->24|54->24|55->25|55->25|55->25|68->38|71->41|71->41|71->41|77->47|77->47|77->47|79->49|79->49|79->49|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|97->67|102->72|102->72|102->72|105->75|108->78|108->78|113->83|113->83|116->86|116->86|118->88|118->88|121->91|121->91|124->94|124->94|126->96|126->96|127->97|127->97
                    -- GENERATED --
                */
            