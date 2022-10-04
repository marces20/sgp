
package views.html.contabilidad.cuentasAnaliticas

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
object modalBusquedaCuentaAnalitica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CuentaAnalitica],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CuentaAnalitica], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.85*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCuentaAnaliticas" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*6.89*/("""" method="GET">
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
	    <em>No se encuentran Cuentas Analiticas</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(cuenta <- buscador.getList) yield /*37.37*/ {_display_(Seq[Any](format.raw/*37.39*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/cuenta/*38.22*/.id)),format.raw/*38.25*/("""" class="pointer modalSeleccionCuentaAnalitica">
		<td> """),_display_(Seq[Any](/*39.9*/cuenta/*39.15*/.codigo)),format.raw/*39.22*/("""</td>	
		<td> """),_display_(Seq[Any](/*40.9*/cuenta/*40.15*/.nombre)),format.raw/*40.22*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentasAnaliticasController.modalBuscar()))),format.raw/*47.120*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaCuentaAnaliticas");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.contabilidad.routes.CuentasAnaliticasController.get())),format.raw/*55.79*/(""""
	contenedor.find('.modalSeleccionCuentaAnalitica').on('click', function()"""),format.raw/*56.74*/("""{"""),format.raw/*56.75*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.cuentaAnalitica.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[CuentaAnalitica],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CuentaAnalitica],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/modalBusquedaCuentaAnalitica.scala.html
                    HASH: 932a96ee1cecb178792406178e5dfa715f5527cc
                    MATRIX: 878->1|1064->105|1096->129|1170->84|1199->173|1338->277|1357->288|1440->350|1590->465|1698->551|1925->743|1968->777|2008->779|2110->864|2122->869|2160->870|2213->887|2230->895|2284->927|2515->1123|2562->1154|2602->1156|2655->1173|2670->1179|2695->1182|2788->1240|2803->1246|2832->1253|2883->1269|2898->1275|2927->1282|2982->1306|3097->1386|3111->1391|3242->1499|3286->1512|3349->1547|3378->1548|3485->1619|3505->1630|3581->1684|3685->1760|3714->1761|3818->1837|3847->1838|3951->1915|3979->1916|4011->1921|4039->1922|4122->1977|4151->1978|4291->2090|4320->2091|4387->2131|4415->2132|4464->2154|4492->2155|4523->2159|4551->2160
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            