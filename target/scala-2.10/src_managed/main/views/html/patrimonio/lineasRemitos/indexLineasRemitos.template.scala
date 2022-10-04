
package views.html.patrimonio.lineasRemitos

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
object indexLineasRemitos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[RemitoLinea],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[RemitoLinea], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*5.70*/(""" 
<div id="resultadoLineasRemitos" class="contenedorPaginador ajaxPaginador">
"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.patrimonio.routes.RemitosLineasController.index(), 'id -> "buscadorLineasRemitos")/*7.117*/ {_display_(Seq[Any](format.raw/*7.119*/("""
<div class="row">	
		
	"""),_display_(Seq[Any](/*10.3*/inputText(formBuscador("remito_id"), 'type -> "hidden"))),format.raw/*10.58*/("""

	<div class="col-sm-5">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*15.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "productoLinea"))),format.raw/*15.124*/("""
			"""),_display_(Seq[Any](/*16.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_linea"))),format.raw/*16.92*/("""
			<span class="input-group-addon"><a href="#" id="searchProductoLinea" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*17.119*/controllers/*17.130*/.compras.routes.ProductosController.modalBuscar())),format.raw/*17.179*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#productoLinea" data-field="#producto_id_linea"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	
</div>
""")))})),format.raw/*30.2*/("""


   """),_display_(Seq[Any](/*33.5*/if(buscador.getTotalRowCount == 0)/*33.39*/ {_display_(Seq[Any](format.raw/*33.41*/("""
        
       <div class="well">
           <em>No se encuentran productos en este remitos.</em>
       </div>
        
    """)))}/*39.7*/else/*39.12*/{_display_(Seq[Any](format.raw/*39.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*41.14*/buscador/*41.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*41.54*/(""" resultado(s).   
		<table id="listaRemitos" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th>Precio</th>
					<th width="50">Cantidad</th>	
					<th width="50">UDM</th>	
					<th width="50">Valor</th>			
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*53.12*/for(linea <- buscador.getList) yield /*53.42*/ {_display_(Seq[Any](format.raw/*53.44*/("""
				<tr class="pointer">
					<td>"""),_display_(Seq[Any](/*55.11*/linea/*55.16*/.lineaOrden.producto.nombre)),format.raw/*55.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*56.11*/utils/*56.16*/.NumberUtils.moneda(linea.lineaOrden.precio))),format.raw/*56.60*/("""</td>
					<td>"""),_display_(Seq[Any](/*57.11*/linea/*57.16*/.cantidad)),format.raw/*57.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*58.11*/linea/*58.16*/.lineaOrden.udm.nombre)),format.raw/*58.38*/("""</td>
					<td>"""),_display_(Seq[Any](/*59.11*/utils/*59.16*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*59.53*/("""</td>
				</tr>
              	""")))})),format.raw/*61.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*66.8*/views/*66.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosLineasController.index()))),format.raw/*66.109*/("""
		</div>
        
    """)))})),format.raw/*69.6*/("""
</div>

<script>
$( function() """),format.raw/*73.15*/("""{"""),format.raw/*73.16*/("""
	$('#searchProductoLinea').modalSearch();
	
	var resultados = $('#resultadoLineasRemitos');

	$('#contenedorRemitos').on('submit', '#buscadorLineasRemitos', function() """),format.raw/*78.76*/("""{"""),format.raw/*78.77*/("""
		
		var $this = $(this);
		var url = $(this).attr('action');
		
		$.get(url, $this.serialize(), function(data)"""),format.raw/*83.47*/("""{"""),format.raw/*83.48*/("""
			resultados.replaceWith(data);
		"""),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""");
		
		return false;
	"""),format.raw/*88.2*/("""}"""),format.raw/*88.3*/(""");
"""),format.raw/*89.1*/("""}"""),format.raw/*89.2*/(""");
</script>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[RemitoLinea],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[RemitoLinea],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasRemitos/indexLineasRemitos.scala.html
                    HASH: 302ac646797654bbbfdf27e05813297f832536af
                    MATRIX: 858->1|1080->141|1112->165|1186->80|1215->209|1330->290|1343->296|1461->405|1501->407|1564->435|1641->490|1802->616|1944->735|1985->741|2094->828|2251->948|2272->959|2344->1008|2851->1484|2896->1494|2939->1528|2979->1530|3131->1665|3144->1670|3183->1671|3238->1690|3255->1698|3309->1730|3665->2050|3711->2080|3751->2082|3825->2120|3839->2125|3888->2152|3941->2169|3955->2174|4021->2218|4074->2235|4088->2240|4119->2249|4172->2266|4186->2271|4230->2293|4283->2310|4297->2315|4356->2352|4422->2386|4534->2463|4548->2468|4667->2564|4725->2591|4789->2627|4818->2628|5020->2802|5049->2803|5194->2920|5223->2921|5288->2959|5316->2960|5369->2986|5397->2987|5428->2991|5456->2992
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|40->10|40->10|45->15|45->15|46->16|46->16|47->17|47->17|47->17|60->30|63->33|63->33|63->33|69->39|69->39|69->39|71->41|71->41|71->41|83->53|83->53|83->53|85->55|85->55|85->55|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|91->61|96->66|96->66|96->66|99->69|103->73|103->73|108->78|108->78|113->83|113->83|115->85|115->85|118->88|118->88|119->89|119->89
                    -- GENERATED --
                */
            