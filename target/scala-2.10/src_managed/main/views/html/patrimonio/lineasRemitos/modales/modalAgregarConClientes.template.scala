
package views.html.patrimonio.lineasRemitos.modales

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
object modalAgregarConClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Long,java.math.BigDecimal,Long,List[com.avaje.ebean.SqlRow],java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remito_id:Long,cantidad:java.math.BigDecimal,linea_orden_id:Long,olSqlRow:List[com.avaje.ebean.SqlRow],dispo:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.133*/("""
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
								<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*28.79*/p/*28.80*/.getBigDecimal("""cantidad"""))),format.raw/*28.110*/(""""" style="width: 60px" />
								<button class="agregarConCliente"  data-cantidad=""""),_display_(Seq[Any](/*29.60*/p/*29.61*/.getBigDecimal("""cantidad"""))),format.raw/*29.91*/("""" data-clienteId=""""),_display_(Seq[Any](/*29.110*/p/*29.111*/.getLong("""cliente_id"""))),format.raw/*29.137*/("""" data-url=""""),_display_(Seq[Any](/*29.150*/controllers/*29.161*/.patrimonio.routes.RemitosLineasController.agregarConCliente())),format.raw/*29.223*/(""""><i class="glyphicon glyphicon-ok-sign"></i></button> </td>
							</tr>
						""")))})),format.raw/*31.8*/("""
					""")))})),format.raw/*32.7*/("""
					
					"""),_display_(Seq[Any](/*34.7*/if(dispo.compareTo(java.math.BigDecimal.ZERO) > 0)/*34.57*/{_display_(Seq[Any](format.raw/*34.58*/("""
						<tr class="tr-carga-pacientes-cantidad">
							<td><b>SIN PACIENTE</b></td>
							<td><b></b></td>
							<td><b>"""),_display_(Seq[Any](/*38.16*/dispo)),format.raw/*38.21*/("""</b></td>
							<td>
							<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*40.78*/dispo)),format.raw/*40.83*/("""" style="width: 60px" />
							<button class="agregarConCliente"  data-cantidad=""""),_display_(Seq[Any](/*41.59*/dispo)),format.raw/*41.64*/("""" data-clienteId="" data-url=""""),_display_(Seq[Any](/*41.95*/controllers/*41.106*/.patrimonio.routes.RemitosLineasController.agregarConCliente())),format.raw/*41.168*/(""""><i class="glyphicon glyphicon-ok-sign"></i></button> </td> 
						</tr>
					""")))})),format.raw/*43.7*/("""
				</tbody>
			</table>
			<input id="linea_orden_id_clientemodal" type="hidden" value=""""),_display_(Seq[Any](/*46.66*/linea_orden_id)),format.raw/*46.80*/("""" name="linea_orden_id_clientemodal" />
			
		</div>
	</div>	
</div>
<script>
$( function() """),format.raw/*52.15*/("""{"""),format.raw/*52.16*/("""
	$(".cantidadCarga").numeric_input();
	$('.agregarConCliente').click( function()"""),format.raw/*54.43*/("""{"""),format.raw/*54.44*/("""
		$this = $(this);
		$this.prop('disabled', true);
		var tr = $(this).closest('tr');
		var idRemito = $('#remitoId').val();
		var linea_orden_id = $('#linea_orden_id_clientemodal').val();
		var url = $(this).attr('data-url');
		var cantidadCargar = tr.find('.cantidadCarga').val();
		var cantidad = $(this).attr('data-cantidad');
		var clienteId = $(this).attr('data-clienteId');
		
		$.get(url, """),format.raw/*65.14*/("""{"""),format.raw/*65.15*/("""remito_id: idRemito, linea_orden_id: linea_orden_id, clienteId: clienteId, cantidad: cantidad,cantidadCargar:cantidadCargar"""),format.raw/*65.138*/("""}"""),format.raw/*65.139*/(""", function(data) """),format.raw/*65.156*/("""{"""),format.raw/*65.157*/("""
			 
			if(data.success) """),format.raw/*67.21*/("""{"""),format.raw/*67.22*/("""
				tr.remove();
				$("#tr-"+linea_orden_id).remove();
				
			"""),format.raw/*71.4*/("""}"""),format.raw/*71.5*/(""" else """),format.raw/*71.11*/("""{"""),format.raw/*71.12*/("""
				alert(data.message);
			"""),format.raw/*73.4*/("""}"""),format.raw/*73.5*/("""
			
			if($(".tr-carga-pacientes-cantidad").length == 0)"""),format.raw/*75.53*/("""{"""),format.raw/*75.54*/("""
				 $("#dialogo-carga-pacientes-cantidad").remove();
			"""),format.raw/*77.4*/("""}"""),format.raw/*77.5*/("""
			
			$("#tr-"+linea_orden_id).find('.agregar').removeAttr('disabled');
			$this.removeAttr('disabled');
		"""),format.raw/*81.3*/("""}"""),format.raw/*81.4*/(""");
	"""),format.raw/*82.2*/("""}"""),format.raw/*82.3*/(""");
	
"""),format.raw/*84.1*/("""}"""),format.raw/*84.2*/(""");
</script>

"""))}
    }
    
    def render(remito_id:Long,cantidad:java.math.BigDecimal,linea_orden_id:Long,olSqlRow:List[com.avaje.ebean.SqlRow],dispo:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(remito_id,cantidad,linea_orden_id,olSqlRow,dispo)
    
    def f:((Long,java.math.BigDecimal,Long,List[com.avaje.ebean.SqlRow],java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (remito_id,cantidad,linea_orden_id,olSqlRow,dispo) => apply(remito_id,cantidad,linea_orden_id,olSqlRow,dispo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasRemitos/modales/modalAgregarConClientes.scala.html
                    HASH: dad047190e1aab4e265d17f1185f6c0e07b9527e
                    MATRIX: 899->1|1170->189|1202->213|1277->132|1305->257|1714->631|1748->649|1787->650|1830->658|1911->730|1950->731|2051->796|2061->797|2112->826|2174->852|2184->853|2233->880|2295->906|2305->907|2353->933|2490->1034|2500->1035|2553->1065|2674->1150|2684->1151|2736->1181|2792->1200|2803->1201|2852->1227|2902->1240|2923->1251|3008->1313|3120->1394|3158->1401|3206->1414|3265->1464|3304->1465|3463->1588|3490->1593|3625->1692|3652->1697|3771->1780|3798->1785|3865->1816|3886->1827|3971->1889|4082->1969|4209->2060|4245->2074|4365->2166|4394->2167|4503->2248|4532->2249|4957->2646|4986->2647|5138->2770|5168->2771|5214->2788|5244->2789|5298->2815|5327->2816|5419->2881|5447->2882|5481->2888|5510->2889|5566->2918|5594->2919|5679->2976|5708->2977|5793->3035|5821->3036|5957->3145|5985->3146|6016->3150|6044->3151|6076->3156|6104->3157
                    LINES: 26->1|33->5|33->5|34->1|35->5|51->21|51->21|51->21|52->22|52->22|52->22|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|58->28|58->28|58->28|59->29|59->29|59->29|59->29|59->29|59->29|59->29|59->29|59->29|61->31|62->32|64->34|64->34|64->34|68->38|68->38|70->40|70->40|71->41|71->41|71->41|71->41|71->41|73->43|76->46|76->46|82->52|82->52|84->54|84->54|95->65|95->65|95->65|95->65|95->65|95->65|97->67|97->67|101->71|101->71|101->71|101->71|103->73|103->73|105->75|105->75|107->77|107->77|111->81|111->81|112->82|112->82|114->84|114->84
                    -- GENERATED --
                */
            