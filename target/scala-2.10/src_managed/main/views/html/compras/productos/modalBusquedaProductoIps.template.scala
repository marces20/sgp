
package views.html.compras.productos

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
object modalBusquedaProductoIps extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Producto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Producto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaProductos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.ProductosController.modalBuscarIps())),format.raw/*6.79*/("""" method="GET">
	<div class="row">
		<div class="col-sm-5">
			<label class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
		</div>
		<div class="col-sm-5">
			<label class="control-label">codigo</label>
			"""),_display_(Seq[Any](/*14.5*/inputText(formBuscador("codigo"), 'class -> "form-control"))),format.raw/*14.64*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*24.2*/if(buscador.getTotalRowCount == 0)/*24.36*/ {_display_(Seq[Any](format.raw/*24.38*/("""
	<div class="well">
	    <em>No se encuentran Productos</em>
	</div>
""")))}/*28.3*/else/*28.8*/{_display_(Seq[Any](format.raw/*28.9*/("""
    Mostrando """),_display_(Seq[Any](/*29.16*/buscador/*29.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*29.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Referencia</th>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*42.6*/for(producto <- buscador.getList) yield /*42.39*/ {_display_(Seq[Any](format.raw/*42.41*/("""
	<tr data-id=""""),_display_(Seq[Any](/*43.16*/producto/*43.24*/.id)),format.raw/*43.27*/("""" class="modalSeleccionProducto">
		<td>"""),_display_(Seq[Any](/*44.8*/producto/*44.16*/.referencia)),format.raw/*44.27*/("""</td>
		<td>"""),_display_(Seq[Any](/*45.8*/producto/*45.16*/.codigo_ips)),format.raw/*45.27*/("""</td>
		<td>"""),_display_(Seq[Any](/*46.8*/producto/*46.16*/.nombre)),format.raw/*46.23*/("""</td>
		<td>"""),_display_(Seq[Any](/*47.8*/(utils.NumberUtils.moneda(producto.precio_coste)))),format.raw/*47.57*/("""</td>
	</tr>    
    """)))})),format.raw/*49.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*54.7*/views/*54.12*/.html.helpers.paginador(buscador, controllers.compras.routes.ProductosController.modalBuscarIps()))),format.raw/*54.110*/("""
	</div>	
""")))})),format.raw/*56.2*/("""
</div>

<script>
$( function()"""),format.raw/*60.14*/("""{"""),format.raw/*60.15*/("""
	var contenedor = $("#modalBusquedaProductos");
	var url = """"),_display_(Seq[Any](/*62.14*/controllers/*62.25*/.compras.routes.ProductosController.get())),format.raw/*62.66*/(""""

	$(document).off('click', '.modalSeleccionProducto');
	$(document).on('click', '.modalSeleccionProducto', function()"""),format.raw/*65.63*/("""{"""),format.raw/*65.64*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*67.38*/("""{"""),format.raw/*67.39*/("""
			$(document).trigger("modal.seleccion.producto.simple", data);
		"""),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*72.49*/("""{"""),format.raw/*72.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*75.38*/("""{"""),format.raw/*75.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
		return false;
	"""),format.raw/*79.2*/("""}"""),format.raw/*79.3*/(""");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Producto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Producto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/modalBusquedaProductoIps.scala.html
                    HASH: 653718a9b524219e709d7645563a9ed25ba809b4
                    MATRIX: 854->1|1032->96|1064->120|1138->77|1166->164|1295->258|1314->269|1387->321|1533->432|1641->518|1762->604|1843->663|2055->840|2098->874|2138->876|2227->948|2239->953|2277->954|2329->970|2346->978|2400->1010|2664->1239|2713->1272|2753->1274|2805->1290|2822->1298|2847->1301|2923->1342|2940->1350|2973->1361|3021->1374|3038->1382|3071->1393|3119->1406|3136->1414|3165->1421|3213->1434|3284->1483|3337->1505|3447->1580|3461->1585|3582->1683|3624->1694|3683->1725|3712->1726|3810->1788|3830->1799|3893->1840|4040->1959|4069->1960|4171->2034|4200->2035|4295->2103|4323->2104|4354->2108|4382->2109|4463->2162|4492->2163|4629->2272|4658->2273|4723->2311|4751->2312|4798->2332|4826->2333|4856->2336|4884->2337
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|42->14|42->14|52->24|52->24|52->24|56->28|56->28|56->28|57->29|57->29|57->29|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|77->49|82->54|82->54|82->54|84->56|88->60|88->60|90->62|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|98->70|98->70|100->72|100->72|103->75|103->75|105->77|105->77|107->79|107->79|108->80|108->80
                    -- GENERATED --
                */
            