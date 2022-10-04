
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
object modalBusquedaProductoSolicitudes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Producto],DynamicForm,Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Producto], formBuscador: DynamicForm,s:Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaProductos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.ProductosController.modalBuscarSolicitudes(s.id))),format.raw/*6.91*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Nombre</label>
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
	    <em>No se encuentran Productos</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(producto <- buscador.getList) yield /*36.39*/ {_display_(Seq[Any](format.raw/*36.41*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/producto/*37.24*/.id)),format.raw/*37.27*/("""" class="modalSeleccionProducto">
		<td> """),_display_(Seq[Any](/*38.9*/producto/*38.17*/.nombre)),format.raw/*38.24*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginadorProductosSolicitud(buscador, controllers.compras.routes.ProductosController.modalBuscarSolicitudes(s.id)))),format.raw/*45.140*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaProductos");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.compras.routes.ProductosController.get())),format.raw/*53.66*/(""""

	$(document).off('click', '.modalSeleccionProducto');
	$(document).on('click', '.modalSeleccionProducto', function()"""),format.raw/*56.63*/("""{"""),format.raw/*56.64*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.producto.simple", data);
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*63.49*/("""{"""),format.raw/*63.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"&"+query, function(data)"""),format.raw/*66.38*/("""{"""),format.raw/*66.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Producto],formBuscador:DynamicForm,s:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,s)
    
    def f:((utils.pagination.Pagination[Producto],DynamicForm,Solicitud) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,s) => apply(buscador,formBuscador,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/modalBusquedaProductoSolicitudes.scala.html
                    HASH: 53c4c5366e954e56ce9a24e262e3c98b1792a272
                    MATRIX: 872->1|1062->108|1094->132|1168->89|1196->176|1325->270|1344->281|1429->345|1575->456|1683->542|1899->723|1942->757|1982->759|2071->831|2083->836|2121->837|2173->853|2190->861|2244->893|2444->1058|2493->1091|2533->1093|2585->1109|2602->1117|2627->1120|2704->1162|2721->1170|2750->1177|2803->1199|2913->1274|2927->1279|3078->1407|3120->1418|3179->1449|3208->1450|3306->1512|3326->1523|3389->1564|3536->1683|3565->1684|3667->1758|3696->1759|3791->1827|3819->1828|3850->1832|3878->1833|3959->1886|3988->1887|4125->1996|4154->1997|4219->2035|4247->2036|4294->2056|4322->2057|4352->2060|4380->2061
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            