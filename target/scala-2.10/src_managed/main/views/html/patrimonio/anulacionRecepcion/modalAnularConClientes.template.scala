
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
object modalAnularConClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[java.math.BigDecimal,Long,List[com.avaje.ebean.SqlRow],java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cantidad:java.math.BigDecimal,linea_orden_id:Long,olSqlRow:List[com.avaje.ebean.SqlRow],dispo:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.118*/("""
"""),format.raw/*5.70*/(""" 

<div class="col-sm-12">
	<div class="panel panel-default">
		<div class="panel-heading"><b>Lineas con Pacientes</b></div>
		<div class="panel-body">
			<table class="table table-bordered table-hover" id="">
				<thead>
					<tr>
						<td>id-Paciente</td>
						<td>Nombre</td>
						<td>Cantidad Disponible</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*21.7*/for(p <- olSqlRow) yield /*21.25*/{_display_(Seq[Any](format.raw/*21.26*/("""
						"""),_display_(Seq[Any](/*22.8*/if(p.getBigDecimal("cantidad").compareTo(java.math.BigDecimal.ZERO) > 0)/*22.80*/{_display_(Seq[Any](format.raw/*22.81*/("""
							<tr class="tr-carga-pacientes-cantidad">
								<td><b>"""),_display_(Seq[Any](/*24.17*/p/*24.18*/.getString("idPacienteRismi"))),format.raw/*24.47*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*25.17*/p/*25.18*/.getString("nombreCliente"))),format.raw/*25.45*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*26.17*/p/*26.18*/.getBigDecimal("cantidad"))),format.raw/*26.44*/("""</b></td>
								<td>
								<input class="linea_orden_id" type="hidden" value=""""),_display_(Seq[Any](/*28.61*/linea_orden_id)),format.raw/*28.75*/("""" name="linea_orden_id" /> 	
								<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*29.79*/p/*29.80*/.getBigDecimal("""cantidad"""))),format.raw/*29.110*/(""""" style="width: 60px" />
								<button class="anularConCliente"  data-cantidad=""""),_display_(Seq[Any](/*30.59*/p/*30.60*/.getBigDecimal("""cantidad"""))),format.raw/*30.90*/("""" data-clienteId=""""),_display_(Seq[Any](/*30.109*/p/*30.110*/.getLong("""cliente_id"""))),format.raw/*30.136*/("""" data-url=""""),_display_(Seq[Any](/*30.149*/controllers/*30.160*/.patrimonio.routes.AnulacionRecepcionProductosController.anularConCliente())),format.raw/*30.235*/(""""><i class="glyphicon glyphicon-ok-sign"></i></button> </td></td>
							</tr>
						""")))})),format.raw/*32.8*/("""
					""")))})),format.raw/*33.7*/("""
					
					"""),_display_(Seq[Any](/*35.7*/if(dispo.compareTo(java.math.BigDecimal.ZERO) > 0)/*35.57*/{_display_(Seq[Any](format.raw/*35.58*/("""
						<tr class="tr-carga-pacientes-cantidad">
							<td><b>SIN PACIENTE</b></td>
							<td><b></b></td>
							<td><b>"""),_display_(Seq[Any](/*39.16*/dispo)),format.raw/*39.21*/("""</b></td>
							<td>
							<input class="linea_orden_id" type="hidden" value=""""),_display_(Seq[Any](/*41.60*/linea_orden_id)),format.raw/*41.74*/("""" name="linea_orden_id" /> 	
							<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*42.78*/dispo)),format.raw/*42.83*/("""" style="width: 60px" />
							<button class="anularConCliente"  data-cantidad=""""),_display_(Seq[Any](/*43.58*/dispo)),format.raw/*43.63*/("""" data-clienteId="" data-url=""""),_display_(Seq[Any](/*43.94*/controllers/*43.105*/.patrimonio.routes.AnulacionRecepcionProductosController.anularConCliente())),format.raw/*43.180*/(""""><i class="glyphicon glyphicon-ok-sign"></i></button> </td></td>
						</tr>
					""")))})),format.raw/*45.7*/("""
				</tbody>
			</table>
			<input id="linea_orden_id_clientemodal" type="hidden" value=""""),_display_(Seq[Any](/*48.66*/linea_orden_id)),format.raw/*48.80*/("""" name="linea_orden_id_clientemodal" />
			
		</div>
	</div>	
</div>
<script>
$( function() """),format.raw/*54.15*/("""{"""),format.raw/*54.16*/("""
	$(".cantidadCarga").numeric_input();
	$('.anularConCliente').click( function()"""),format.raw/*56.42*/("""{"""),format.raw/*56.43*/("""
		$this = $(this);
		$this.prop('disabled', true);
		var tr = $(this).closest('tr');
		var idRemito = $('#remitoId').val();
		var linea_orden_id = $('#linea_orden_id_clientemodal').val();
		var url = $(this).attr('data-url');
		var cantidadCargar = tr.find('.cantidadCarga').val();
		var cantidad = $(this).attr('data-cantidad');
		var clienteId = $(this).attr('data-clienteId');
		var observaciones =  $("#obs").val();
		
		$.get(url, """),format.raw/*68.14*/("""{"""),format.raw/*68.15*/("""orden_linea_id: linea_orden_id, clienteId: clienteId, cantidad: cantidad,cantidadCargar:cantidadCargar,observaciones:observaciones"""),format.raw/*68.145*/("""}"""),format.raw/*68.146*/(""", function(data) """),format.raw/*68.163*/("""{"""),format.raw/*68.164*/("""
			 
			if(data.success) """),format.raw/*70.21*/("""{"""),format.raw/*70.22*/("""
				tr.remove();
				$("#tr-"+linea_orden_id).remove();
				$('#menuAnulados').click();
			"""),format.raw/*74.4*/("""}"""),format.raw/*74.5*/(""" else """),format.raw/*74.11*/("""{"""),format.raw/*74.12*/("""
				alert(data.message);
			"""),format.raw/*76.4*/("""}"""),format.raw/*76.5*/("""
			
			if($(".tr-carga-pacientes-cantidad").length == 0)"""),format.raw/*78.53*/("""{"""),format.raw/*78.54*/("""
				 $("#dialogo-carga-pacientes-cantidad").remove();
				 $("#dialogo-anulacion-productos").dialog( "destroy" );
			"""),format.raw/*81.4*/("""}"""),format.raw/*81.5*/("""
			
			$("#tr-"+linea_orden_id).find('.agregar').removeAttr('disabled');
			$this.removeAttr('disabled');
		"""),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""");
	"""),format.raw/*86.2*/("""}"""),format.raw/*86.3*/(""");
	
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/(""");
</script>

"""))}
    }
    
    def render(cantidad:java.math.BigDecimal,linea_orden_id:Long,olSqlRow:List[com.avaje.ebean.SqlRow],dispo:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(cantidad,linea_orden_id,olSqlRow,dispo)
    
    def f:((java.math.BigDecimal,Long,List[com.avaje.ebean.SqlRow],java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (cantidad,linea_orden_id,olSqlRow,dispo) => apply(cantidad,linea_orden_id,olSqlRow,dispo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/modalAnularConClientes.scala.html
                    HASH: 22686eafe7dcc34c434cf5e001ee5b8dd5f72724
                    MATRIX: 890->1|1146->174|1178->198|1253->117|1281->242|1690->616|1724->634|1763->635|1806->643|1887->715|1926->716|2027->781|2037->782|2088->811|2150->837|2160->838|2209->865|2271->891|2281->892|2329->918|2448->1001|2484->1015|2627->1122|2637->1123|2690->1153|2810->1237|2820->1238|2872->1268|2928->1287|2939->1288|2988->1314|3038->1327|3059->1338|3157->1413|3274->1499|3312->1506|3360->1519|3419->1569|3458->1570|3617->1693|3644->1698|3761->1779|3797->1793|3939->1899|3966->1904|4084->1986|4111->1991|4178->2022|4199->2033|4297->2108|4412->2192|4539->2283|4575->2297|4695->2389|4724->2390|4832->2470|4861->2471|5326->2908|5355->2909|5514->3039|5544->3040|5590->3057|5620->3058|5674->3084|5703->3085|5822->3177|5850->3178|5884->3184|5913->3185|5969->3214|5997->3215|6082->3272|6111->3273|6256->3391|6284->3392|6420->3501|6448->3502|6479->3506|6507->3507|6539->3512|6567->3513
                    LINES: 26->1|33->5|33->5|34->1|35->5|51->21|51->21|51->21|52->22|52->22|52->22|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|60->30|60->30|60->30|60->30|60->30|60->30|62->32|63->33|65->35|65->35|65->35|69->39|69->39|71->41|71->41|72->42|72->42|73->43|73->43|73->43|73->43|73->43|75->45|78->48|78->48|84->54|84->54|86->56|86->56|98->68|98->68|98->68|98->68|98->68|98->68|100->70|100->70|104->74|104->74|104->74|104->74|106->76|106->76|108->78|108->78|111->81|111->81|115->85|115->85|116->86|116->86|118->88|118->88
                    -- GENERATED --
                */
            