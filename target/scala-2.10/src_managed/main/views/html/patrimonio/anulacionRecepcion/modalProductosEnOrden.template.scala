
package views.html.patrimonio.anulacionRecepcion

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
object modalProductosEnOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[OrdenProvisionLineas],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, productos: List[OrdenProvisionLineas], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaProductos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.patrimonio.routes.AnulacionRecepcionProductosController.modalProductosEnOrden(idOrdenCompra))),format.raw/*6.120*/("""" method="GET">
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

"""),_display_(Seq[Any](/*21.2*/if(productos.size() == 0)/*21.27*/ {_display_(Seq[Any](format.raw/*21.29*/("""
	<div class="well">
	    <em>No se encuentran productos</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*35.6*/for(linea <- productos) yield /*35.29*/ {_display_(Seq[Any](format.raw/*35.31*/("""
	<tr data-id=""""),_display_(Seq[Any](/*36.16*/linea/*36.21*/.orden_linea_id)),format.raw/*36.36*/("""" class="modalSeleccionProducto">
		<td>"""),_display_(Seq[Any](/*37.8*/linea/*37.13*/.producto.nombre)),format.raw/*37.29*/("""</td>
	</tr>    
    """)))})),format.raw/*39.6*/("""
    </tbody>
    </table>
""")))})),format.raw/*42.2*/("""
</div>

<script>
$( function()"""),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""
	var contenedor = $("#modalBusquedaProductos");
	var url = """"),_display_(Seq[Any](/*48.14*/controllers/*48.25*/.patrimonio.routes.AnulacionRecepcionProductosController.get())),format.raw/*48.87*/(""""

	$(document).off('click', '.modalSeleccionProducto');
	$(document).on('click', '.modalSeleccionProducto', function()"""),format.raw/*51.63*/("""{"""),format.raw/*51.64*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*53.38*/("""{"""),format.raw/*53.39*/("""
			$(document).trigger("modal.seleccion.producto.simple", data);
		"""),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");
	"""),format.raw/*56.2*/("""}"""),format.raw/*56.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*58.49*/("""{"""),format.raw/*58.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*61.38*/("""{"""),format.raw/*61.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/(""");
		return false;
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/(""");
"""),format.raw/*66.1*/("""}"""),format.raw/*66.2*/(""");
</script>"""))}
    }
    
    def render(idOrdenCompra:Long,productos:List[OrdenProvisionLineas],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,productos,formBuscador)
    
    def f:((Long,List[OrdenProvisionLineas],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,productos,formBuscador) => apply(idOrdenCompra,productos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/modalProductosEnOrden.scala.html
                    HASH: 00dfe11934ef7a57fa70c961b48342b0f71de2f4
                    MATRIX: 857->1|1047->109|1079->133|1153->88|1182->177|1314->274|1333->285|1448->378|1598->493|1706->579|1933->771|1967->796|2007->798|2100->874|2112->879|2150->880|2345->1040|2384->1063|2424->1065|2477->1082|2491->1087|2528->1102|2605->1144|2619->1149|2657->1165|2712->1189|2774->1220|2837->1255|2866->1256|2966->1320|2986->1331|3070->1393|3220->1515|3249->1516|3353->1592|3382->1593|3479->1663|3507->1664|3539->1669|3567->1670|3650->1725|3679->1726|3819->1838|3848->1839|3915->1879|3943->1880|3992->1902|4020->1903|4051->1907|4079->1908
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|67->39|70->42|74->46|74->46|76->48|76->48|76->48|79->51|79->51|81->53|81->53|83->55|83->55|84->56|84->56|86->58|86->58|89->61|89->61|91->63|91->63|93->65|93->65|94->66|94->66
                    -- GENERATED --
                */
            