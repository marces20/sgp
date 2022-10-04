
package views.html.patrimonio.actaRecepcionLineas

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
object listaActaRecepcionLineas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ActaRecepcionLinea],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaRecepcionLinea], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.88*/("""
"""),format.raw/*3.1*/(""" 
"""),format.raw/*4.70*/("""



<div id="resultadoProdutosActas" class="">
"""),_display_(Seq[Any](/*9.2*/helper/*9.8*/.form(action = controllers.patrimonio.routes.ActasRecepcionLineasController.index(), 'id -> "buscadorLineasActa")/*9.121*/ {_display_(Seq[Any](format.raw/*9.123*/("""
<div class="row">	
		
	"""),_display_(Seq[Any](/*12.3*/inputText(formBuscador("acta_id"), 'type -> "hidden"))),format.raw/*12.56*/("""

	<div class="col-sm-5">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*17.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "productoLinea"))),format.raw/*17.124*/("""
			"""),_display_(Seq[Any](/*18.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_linea"))),format.raw/*18.92*/("""
			<span class="input-group-addon"><a href="#" id="searchProductoLinea" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*19.119*/controllers/*19.130*/.compras.routes.ProductosController.modalBuscar())),format.raw/*19.179*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#productoLinea" data-field="#producto_id_linea"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	
</div>
""")))})),format.raw/*32.2*/("""
	<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">
	   """),_display_(Seq[Any](/*34.6*/if(buscador.getTotalRowCount == 0)/*34.40*/ {_display_(Seq[Any](format.raw/*34.42*/("""
	        
	       <div class="well">
	           <em>No se encuentran lineas en esta acta.</em>
	       </div>
	        
	    """)))}/*40.8*/else/*40.13*/{_display_(Seq[Any](format.raw/*40.14*/("""
			
			Mostrando """),_display_(Seq[Any](/*42.15*/buscador/*42.23*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*42.55*/(""" resultado(s).   
			<table id="listaProdutosActas" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Producto</th>
						<th>Cuenta</th>
						<th>UDM</th>
						<th>Cantidad</th>	
						<th>Precio</th>	
						<th>Total</th>			
					</tr>
				</thead>
				<tbody>
			        """),_display_(Seq[Any](/*55.13*/for(linea <- buscador.getList) yield /*55.43*/ {_display_(Seq[Any](format.raw/*55.45*/("""
					<tr class="pointer">
						<td>"""),_display_(Seq[Any](/*57.12*/linea/*57.17*/.producto.nombre)),format.raw/*57.33*/("""</td>
						<td>"""),_display_(Seq[Any](/*58.12*/if(linea.cuentaAnalitica == null)/*58.45*/{_display_(Seq[Any](format.raw/*58.46*/("""No asociada""")))}/*58.59*/else/*58.64*/{_display_(Seq[Any](_display_(Seq[Any](/*58.66*/linea/*58.71*/.cuentaAnalitica.codigo)),format.raw/*58.94*/(""" """),_display_(Seq[Any](/*58.96*/linea/*58.101*/.cuentaAnalitica.nombre))))})),format.raw/*58.125*/("""</td>
						<td>"""),_display_(Seq[Any](/*59.12*/linea/*59.17*/.udm.nombre)),format.raw/*59.28*/("""</td>
						<td>"""),_display_(Seq[Any](/*60.12*/linea/*60.17*/.cantidad)),format.raw/*60.26*/("""</td>
						<td>"""),_display_(Seq[Any](/*61.12*/utils/*61.17*/.NumberUtils.moneda(linea.unitario))),format.raw/*61.52*/("""</td>
						<td>"""),_display_(Seq[Any](/*62.12*/utils/*62.17*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*62.54*/("""</td>
					</tr>
	              	""")))})),format.raw/*64.18*/("""
				</tbody>
			</table>
			
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*69.9*/views/*69.14*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.ActasRecepcionLineasController.index()))),format.raw/*69.117*/("""
			</div>
	        
	    """)))})),format.raw/*72.7*/("""
	</div>     
</div> 


<script>
$( function() """),format.raw/*78.15*/("""{"""),format.raw/*78.16*/("""
	$('#searchProductoLinea').modalSearch();
	var resultados = $('#resultadoProdutosActas');
	
	$('#buscadorLineasActa').submit( function() """),format.raw/*82.46*/("""{"""),format.raw/*82.47*/("""
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data)"""),format.raw/*85.49*/("""{"""),format.raw/*85.50*/("""
			resultados.replaceWith(data);
		"""),format.raw/*87.3*/("""}"""),format.raw/*87.4*/(""");
		
		return false;
	"""),format.raw/*90.2*/("""}"""),format.raw/*90.3*/(""");
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaRecepcionLinea],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[ActaRecepcionLinea],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionLineas/listaActaRecepcionLineas.scala.html
                    HASH: df279c89f81d39697482fc2aeaf474205b64c84d
                    MATRIX: 877->1|1066->111|1098->135|1172->87|1200->107|1230->179|1317->232|1330->238|1452->351|1492->353|1555->381|1630->434|1791->560|1933->679|1974->685|2083->772|2240->892|2261->903|2333->952|2840->1428|2957->1510|3000->1544|3040->1546|3192->1681|3205->1686|3244->1687|3301->1708|3318->1716|3372->1748|3736->2076|3782->2106|3822->2108|3898->2148|3912->2153|3950->2169|4004->2187|4046->2220|4085->2221|4116->2234|4129->2239|4177->2241|4191->2246|4236->2269|4274->2271|4289->2276|4340->2300|4394->2318|4408->2323|4441->2334|4495->2352|4509->2357|4540->2366|4594->2384|4608->2389|4665->2424|4719->2442|4733->2447|4792->2484|4860->2520|4977->2602|4991->2607|5117->2710|5178->2740|5259->2793|5288->2794|5458->2936|5487->2937|5606->3028|5635->3029|5700->3067|5728->3068|5781->3094|5809->3095|5840->3099|5868->3100
                    LINES: 26->1|29->4|29->4|30->1|31->3|32->4|37->9|37->9|37->9|37->9|40->12|40->12|45->17|45->17|46->18|46->18|47->19|47->19|47->19|60->32|62->34|62->34|62->34|68->40|68->40|68->40|70->42|70->42|70->42|83->55|83->55|83->55|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|92->64|97->69|97->69|97->69|100->72|106->78|106->78|110->82|110->82|113->85|113->85|115->87|115->87|118->90|118->90|119->91|119->91
                    -- GENERATED --
                */
            