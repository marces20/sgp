
package views.html.contabilidad.facturas

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
object modalBusquedaActasAsociadas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,List[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facturaId: Long, listaActas: List[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""

<div id="modalBusquedaActas" class="contenedorPaginador ajaxPaginador">


"""),_display_(Seq[Any](/*8.2*/if(listaActas.size() == 0)/*8.28*/ {_display_(Seq[Any](format.raw/*8.30*/("""
	<div class="well">
	    <em>No se encuentran actas relacionadas</em>
	</div>
""")))}/*12.3*/else/*12.8*/{_display_(Seq[Any](format.raw/*12.9*/("""
    	
		<table id="listaActasModal" class="table table-striped table-bordered table-hover">

			<tbody>
		        """),_display_(Seq[Any](/*17.12*/for(acta <- listaActas) yield /*17.35*/ {_display_(Seq[Any](format.raw/*17.37*/("""
				<tr data-href=""""),_display_(Seq[Any](/*18.21*/controllers/*18.32*/.contabilidad.routes.FacturasController.asignarActasAsociada(facturaId, acta.id))),format.raw/*18.112*/("""">
					<td>"""),_display_(Seq[Any](/*19.11*/acta/*19.15*/.numero)),format.raw/*19.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*20.11*/if(acta.ejercicio != null)/*20.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*20.40*/acta/*20.44*/.ejercicio.nombre))))})),format.raw/*20.62*/("""</td>
					<td>"""),_display_(Seq[Any](/*21.11*/acta/*21.15*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*21.78*/("""</td>
					<td>"""),_display_(Seq[Any](/*22.11*/utils/*22.16*/.NumberUtils.moneda(acta.total))),format.raw/*22.47*/("""</td>
					<td>"""),_display_(Seq[Any](/*23.11*/acta/*23.15*/.ordenProvision.numero)),format.raw/*23.37*/("""</td>
					<td>"""),_display_(Seq[Any](/*24.11*/acta/*24.15*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*24.59*/("""</td>
					<td>"""),_display_(Seq[Any](/*25.11*/DateUtils/*25.20*/.formatDate(acta.fecha))),format.raw/*25.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*26.11*/if(acta.cierre)/*26.26*/ {_display_(Seq[Any](format.raw/*26.28*/("""Cierre""")))}/*26.36*/else/*26.41*/{_display_(Seq[Any](format.raw/*26.42*/("""Parcial""")))})),format.raw/*26.50*/("""</td>
				</tr>
              	""")))})),format.raw/*28.17*/("""
			</tbody>
		</table>
""")))})),format.raw/*31.2*/("""
    
</div>

<style>
#listaActasModal tr """),format.raw/*36.21*/("""{"""),format.raw/*36.22*/("""cursor: pointer"""),format.raw/*36.37*/("""}"""),format.raw/*36.38*/("""
</style>

<script>
$( function()"""),format.raw/*40.14*/("""{"""),format.raw/*40.15*/("""
	var contenedor = $("#modalBusquedaActas");
	

	$(document).off('click', '#listaActasModal tbody tr');
	$(document).on('click', '#listaActasModal tbody tr', function()"""),format.raw/*45.65*/("""{"""),format.raw/*45.66*/("""
		var url = $(this).attr('data-href');
		var $this = $(this);
		$.get(url, function(data)"""),format.raw/*48.28*/("""{"""),format.raw/*48.29*/("""
			if(data.success) """),format.raw/*49.21*/("""{"""),format.raw/*49.22*/("""
				$('#tabActas').click();
				modalSeleccionActa.dialog('destroy');
			"""),format.raw/*52.4*/("""}"""),format.raw/*52.5*/(""" else """),format.raw/*52.11*/("""{"""),format.raw/*52.12*/("""
				alert("No se puede asociar el acta a la factura.");
			"""),format.raw/*54.4*/("""}"""),format.raw/*54.5*/("""
			
		"""),format.raw/*56.3*/("""}"""),format.raw/*56.4*/(""");
	"""),format.raw/*57.2*/("""}"""),format.raw/*57.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*59.49*/("""{"""),format.raw/*59.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*62.38*/("""{"""),format.raw/*62.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/(""");
		return false;
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
"""),format.raw/*67.1*/("""}"""),format.raw/*67.2*/(""");
</script>"""))}
    }
    
    def render(facturaId:Long,listaActas:List[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(facturaId,listaActas)
    
    def f:((Long,List[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (facturaId,listaActas) => apply(facturaId,listaActas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/modalBusquedaActasAsociadas.scala.html
                    HASH: d680ab1f7950378295a70926c6850bb8423a6d37
                    MATRIX: 836->1|995->51|1022->68|1133->145|1167->171|1206->173|1304->254|1316->259|1354->260|1506->376|1545->399|1585->401|1642->422|1662->433|1765->513|1814->526|1827->530|1856->537|1908->553|1943->579|1992->582|2005->586|2049->604|2101->620|2114->624|2199->687|2251->703|2265->708|2318->739|2370->755|2383->759|2427->781|2479->797|2492->801|2558->845|2610->861|2628->870|2673->893|2725->909|2749->924|2789->926|2815->934|2828->939|2867->940|2907->948|2971->980|3027->1005|3097->1047|3126->1048|3169->1063|3198->1064|3259->1097|3288->1098|3484->1266|3513->1267|3631->1357|3660->1358|3709->1379|3738->1380|3839->1454|3867->1455|3901->1461|3930->1462|4017->1522|4045->1523|4079->1530|4107->1531|4138->1535|4166->1536|4247->1589|4276->1590|4413->1699|4442->1700|4507->1738|4535->1739|4582->1759|4610->1760|4640->1763|4668->1764
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|40->12|40->12|40->12|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|54->26|54->26|56->28|59->31|64->36|64->36|64->36|64->36|68->40|68->40|73->45|73->45|76->48|76->48|77->49|77->49|80->52|80->52|80->52|80->52|82->54|82->54|84->56|84->56|85->57|85->57|87->59|87->59|90->62|90->62|92->64|92->64|94->66|94->66|95->67|95->67
                    -- GENERATED --
                */
            