
package views.html.compras.proveedores

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
object modalBusquedaProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Proveedor],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Proveedor], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaProveedores" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*6.78*/("""" method="GET">
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
	    <em>No se encuentran Proveedores</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Cuit</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(proveedor <- buscador.getList) yield /*37.40*/ {_display_(Seq[Any](format.raw/*37.42*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/proveedor/*38.25*/.id)),format.raw/*38.28*/("""" class="modalSeleccionProveedor pointer">
		<td> """),_display_(Seq[Any](/*39.9*/proveedor/*39.18*/.nombre)),format.raw/*39.25*/("""</td>
		<td> """),_display_(Seq[Any](/*40.9*/proveedor/*40.18*/.cuit)),format.raw/*40.23*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.compras.routes.ProveedoresController.modalBuscar()))),format.raw/*47.109*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaProveedores");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.compras.routes.ProveedoresController.get())),format.raw/*55.68*/(""""
	contenedor.find('.modalSeleccionProveedor').on('click', function()"""),format.raw/*56.68*/("""{"""),format.raw/*56.69*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.proveedor.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[Proveedor],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Proveedor],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/modalBusquedaProveedor.scala.html
                    HASH: 6c65a8d256d0fb271db0be49a4f00de7a8e3e3ea
                    MATRIX: 855->1|1034->97|1066->121|1140->78|1168->165|1299->261|1318->272|1390->323|1536->434|1644->520|1860->701|1903->735|1943->737|2034->811|2046->816|2084->817|2136->833|2153->841|2207->873|2425->1056|2475->1090|2515->1092|2567->1108|2585->1117|2610->1120|2696->1171|2714->1180|2743->1187|2792->1201|2810->1210|2837->1215|2890->1237|3000->1312|3014->1317|3134->1414|3176->1425|3235->1456|3264->1457|3364->1521|3384->1532|3449->1575|3546->1644|3575->1645|3677->1719|3706->1720|3802->1789|3830->1790|3861->1794|3889->1795|3970->1848|3999->1849|4136->1958|4165->1959|4230->1997|4258->1998|4305->2018|4333->2019|4363->2022|4391->2023
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            