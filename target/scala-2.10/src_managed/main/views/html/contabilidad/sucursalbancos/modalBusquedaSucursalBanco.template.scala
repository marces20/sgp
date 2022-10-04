
package views.html.contabilidad.sucursalbancos

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
object modalBusquedaSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[SucursalBanco],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[SucursalBanco], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaSucursalBancos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.SucursalBancosController.modalBuscar())),format.raw/*6.86*/("""" method="GET">
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
	    <em>No se encuentran Sucursal Banco</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Banco</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(sucursalBanco <- buscador.getList) yield /*37.44*/ {_display_(Seq[Any](format.raw/*37.46*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/sucursalBanco/*38.29*/.id)),format.raw/*38.32*/("""" class="modalSeleccionPeriodo">
		<td>"""),_display_(Seq[Any](/*39.8*/sucursalBanco/*39.21*/.nombre)),format.raw/*39.28*/("""</td>
		<td>"""),_display_(Seq[Any](/*40.8*/sucursalBanco/*40.21*/.banco.nombre)),format.raw/*40.34*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.SucursalBancosController.modalBuscar()))),format.raw/*47.117*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaSucursalBancos");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.contabilidad.routes.SucursalBancosController.get())),format.raw/*55.76*/(""""
	contenedor.find('.modalSeleccionSucursalBanco').on('click', function()"""),format.raw/*56.72*/("""{"""),format.raw/*56.73*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.sucursalBanco.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[SucursalBanco],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[SucursalBanco],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/modalBusquedaSucursalBanco.scala.html
                    HASH: df35e04b4aa63c2087a1cf0f7f7828203a60168d
                    MATRIX: 871->1|1055->103|1087->127|1161->82|1190->171|1327->273|1346->284|1426->343|1576->458|1684->544|1911->736|1954->770|1994->772|2092->853|2104->858|2142->859|2195->876|2212->884|2266->916|2496->1111|2550->1149|2590->1151|2643->1168|2665->1181|2690->1184|2766->1225|2788->1238|2817->1245|2866->1259|2888->1272|2923->1285|2978->1309|3093->1389|3107->1394|3235->1499|3279->1512|3342->1547|3371->1548|3476->1617|3496->1628|3569->1679|3671->1753|3700->1754|3804->1830|3833->1831|3935->1906|3963->1907|3995->1912|4023->1913|4106->1968|4135->1969|4275->2081|4304->2082|4371->2122|4399->2123|4448->2145|4476->2146|4507->2150|4535->2151
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            