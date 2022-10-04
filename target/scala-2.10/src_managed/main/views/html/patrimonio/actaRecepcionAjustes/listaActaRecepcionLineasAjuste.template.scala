
package views.html.patrimonio.actaRecepcionAjustes

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
object listaActaRecepcionLineasAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ActaRecepcionLineaAjuste],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaRecepcionLineaAjuste], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*3.1*/(""" 
"""),format.raw/*4.70*/("""



<div id="" class="">

	<div id="" class="contenedorPaginador ajaxPaginador">
	   """),_display_(Seq[Any](/*11.6*/if(buscador.getTotalRowCount == 0)/*11.40*/ {_display_(Seq[Any](format.raw/*11.42*/("""
	        
	       <div class="well">
	           <em>No se encuentran lineas en esta acta.</em>
	       </div>
	        
	    """)))}/*17.8*/else/*17.13*/{_display_(Seq[Any](format.raw/*17.14*/("""
			
			Mostrando """),_display_(Seq[Any](/*19.15*/buscador/*19.23*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*19.55*/(""" resultado(s).   
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
			        """),_display_(Seq[Any](/*32.13*/for(linea <- buscador.getList) yield /*32.43*/ {_display_(Seq[Any](format.raw/*32.45*/("""
					<tr class="pointer">
						<td>"""),_display_(Seq[Any](/*34.12*/linea/*34.17*/.producto.nombre)),format.raw/*34.33*/("""</td>
						<td>"""),_display_(Seq[Any](/*35.12*/if(linea.cuentaAnalitica == null)/*35.45*/{_display_(Seq[Any](format.raw/*35.46*/("""No asociada""")))}/*35.59*/else/*35.64*/{_display_(Seq[Any](_display_(Seq[Any](/*35.66*/linea/*35.71*/.cuentaAnalitica.codigo)),format.raw/*35.94*/(""" """),_display_(Seq[Any](/*35.96*/linea/*35.101*/.cuentaAnalitica.nombre))))})),format.raw/*35.125*/("""</td>
						<td>"""),_display_(Seq[Any](/*36.12*/linea/*36.17*/.udm.nombre)),format.raw/*36.28*/("""</td>
						<td>"""),_display_(Seq[Any](/*37.12*/linea/*37.17*/.cantidad)),format.raw/*37.26*/("""</td>
						<td>"""),_display_(Seq[Any](/*38.12*/utils/*38.17*/.NumberUtils.moneda(linea.precio))),format.raw/*38.50*/("""</td>
						<td>"""),_display_(Seq[Any](/*39.12*/utils/*39.17*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*39.54*/("""</td>
					</tr>
	              	""")))})),format.raw/*41.18*/("""
				</tbody>
			</table>
			
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*46.9*/views/*46.14*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.ActasRecepcionLineasController.index()))),format.raw/*46.117*/("""
			</div>
	        
	    """)))})),format.raw/*49.7*/("""
	</div>     
</div> 


<script>
$( function() """),format.raw/*55.15*/("""{"""),format.raw/*55.16*/("""
	$('#searchProductoLinea').modalSearch();
	var resultados = $('#resultadoProdutosActas');
	
	$('#buscadorLineasActa').submit( function() """),format.raw/*59.46*/("""{"""),format.raw/*59.47*/("""
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data)"""),format.raw/*62.49*/("""{"""),format.raw/*62.50*/("""
			resultados.replaceWith(data);
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/(""");
		
		return false;
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
"""),format.raw/*68.1*/("""}"""),format.raw/*68.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaRecepcionLineaAjuste],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[ActaRecepcionLineaAjuste],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/listaActaRecepcionLineasAjuste.scala.html
                    HASH: d67124ea614b13e18f3f97d939b29ab9f9179a3f
                    MATRIX: 890->1|1085->117|1117->141|1191->93|1219->113|1249->185|1377->278|1420->312|1460->314|1612->449|1625->454|1664->455|1721->476|1738->484|1792->516|2156->844|2202->874|2242->876|2318->916|2332->921|2370->937|2424->955|2466->988|2505->989|2536->1002|2549->1007|2597->1009|2611->1014|2656->1037|2694->1039|2709->1044|2760->1068|2814->1086|2828->1091|2861->1102|2915->1120|2929->1125|2960->1134|3014->1152|3028->1157|3083->1190|3137->1208|3151->1213|3210->1250|3278->1286|3395->1368|3409->1373|3535->1476|3596->1506|3677->1559|3706->1560|3876->1702|3905->1703|4024->1794|4053->1795|4118->1833|4146->1834|4199->1860|4227->1861|4258->1865|4286->1866
                    LINES: 26->1|29->4|29->4|30->1|31->3|32->4|39->11|39->11|39->11|45->17|45->17|45->17|47->19|47->19|47->19|60->32|60->32|60->32|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|74->46|74->46|74->46|77->49|83->55|83->55|87->59|87->59|90->62|90->62|92->64|92->64|95->67|95->67|96->68|96->68
                    -- GENERATED --
                */
            