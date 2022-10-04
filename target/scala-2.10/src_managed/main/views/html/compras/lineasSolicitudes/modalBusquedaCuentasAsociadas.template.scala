
package views.html.compras.lineasSolicitudes

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
object modalBusquedaCuentasAsociadas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,utils.pagination.Pagination[CuentaAnalitica],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idSolicitud: Long, buscador: utils.pagination.Pagination[CuentaAnalitica], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.104*/("""

"""),format.raw/*4.70*/(""" 

<div id="modalBusquedaCuenta" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*7.16*/controllers/*7.27*/.contabilidad.routes.CuentasAnaliticasController.modalBuscarCuentasAsociadas())),format.raw/*7.105*/("""" method="GET">
	"""),_display_(Seq[Any](/*8.3*/inputText(formBuscador("solicitud_id"), 'hidden -> "hidden"))),format.raw/*8.63*/("""
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*12.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*12.91*/("""
		</div>
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*22.2*/if(buscador.getTotalRowCount() == 0)/*22.38*/ {_display_(Seq[Any](format.raw/*22.40*/("""
	<div class="well">
	    <em>No se encuentran cuentas asociadas</em>
	</div>
""")))}/*26.3*/else/*26.8*/{_display_(Seq[Any](format.raw/*26.9*/("""
    Mostrando """),_display_(Seq[Any](/*27.16*/buscador/*27.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*27.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th width="270">Código</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*38.6*/for(cuenta <- buscador.getList) yield /*38.37*/ {_display_(Seq[Any](format.raw/*38.39*/("""
	<tr data-href=""""),_display_(Seq[Any](/*39.18*/controllers/*39.29*/.contabilidad.routes.CuentasAnaliticasController.get(cuenta.id))),format.raw/*39.92*/("""" class="pointer modalSeleccionCuenta">
		<td> """),_display_(Seq[Any](/*40.9*/cuenta/*40.15*/.codigo)),format.raw/*40.22*/("""</td>
		<td> """),_display_(Seq[Any](/*41.9*/cuenta/*41.15*/.nombre)),format.raw/*41.22*/("""</td>
	</tr>    
    """)))})),format.raw/*43.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*48.7*/views/*48.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentasAnaliticasController.modalBuscarCuentasAsociadas(idSolicitud)))),format.raw/*48.147*/("""
	</div>	
""")))})),format.raw/*50.2*/("""
</div>

<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	var contenedor = $("#modalBusquedaCuenta");

	$(document).off('click', '.modalSeleccionCuenta');
	$(document).on('click', '.modalSeleccionCuenta', function()"""),format.raw/*58.61*/("""{"""),format.raw/*58.62*/("""
		var url = $(this).attr('data-href');
		$.get(url, function(data)"""),format.raw/*60.28*/("""{"""),format.raw/*60.29*/("""
			if(data.success)
				$(document).trigger("modal.seleccion.cuenta.simple", data);
			else
				alert(data.message);
			
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/(""");
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*69.49*/("""{"""),format.raw/*69.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*72.38*/("""{"""),format.raw/*72.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*74.3*/("""}"""),format.raw/*74.4*/(""");
		return false;
	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/(""");
"""),format.raw/*77.1*/("""}"""),format.raw/*77.2*/(""");
</script>"""))}
    }
    
    def render(idSolicitud:Long,buscador:utils.pagination.Pagination[CuentaAnalitica],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(idSolicitud,buscador,formBuscador)
    
    def f:((Long,utils.pagination.Pagination[CuentaAnalitica],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (idSolicitud,buscador,formBuscador) => apply(idSolicitud,buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/modalBusquedaCuentasAsociadas.scala.html
                    HASH: 45cd845263ff008bb0ed43c78dee38d0e82d3ea6
                    MATRIX: 879->1|1084->126|1116->150|1191->103|1222->194|1351->288|1370->299|1470->377|1523->396|1604->456|1739->556|1847->642|2069->829|2114->865|2154->867|2255->951|2267->956|2305->957|2358->974|2375->982|2429->1014|2672->1222|2719->1253|2759->1255|2814->1274|2834->1285|2919->1348|3003->1397|3018->1403|3047->1410|3097->1425|3112->1431|3141->1438|3196->1462|3311->1542|3325->1547|3483->1682|3527->1695|3590->1730|3619->1731|3810->1894|3839->1895|3936->1964|3965->1965|4122->2095|4150->2096|4182->2101|4210->2102|4293->2157|4322->2158|4462->2270|4491->2271|4558->2311|4586->2312|4635->2334|4663->2335|4694->2339|4722->2340
                    LINES: 26->1|29->4|29->4|30->1|32->4|35->7|35->7|35->7|36->8|36->8|40->12|40->12|50->22|50->22|50->22|54->26|54->26|54->26|55->27|55->27|55->27|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|71->43|76->48|76->48|76->48|78->50|82->54|82->54|86->58|86->58|88->60|88->60|94->66|94->66|95->67|95->67|97->69|97->69|100->72|100->72|102->74|102->74|104->76|104->76|105->77|105->77
                    -- GENERATED --
                */
            