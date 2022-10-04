
package views.html.dashboard.autorizados.modales

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
object modalAgregarMontos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[ActaRecepcion],Long,Long,Long,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaActas: List[ActaRecepcion],idAutorizado:Long,idOp:Long,idOrdenCompra:Long,tipo_cuenta_id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var monto_t=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.102*/("""
"""),format.raw/*3.1*/("""<form action=""""),_display_(Seq[Any](/*3.16*/controllers/*3.27*/.dashboard.routes.AutorizadosController.cargarLineasAutorizados())),format.raw/*3.92*/("""" method="POST" id="formCargarLineasAutorizados">

<input type="hidden" name="idAutorizado" value=""""),_display_(Seq[Any](/*5.50*/idAutorizado)),format.raw/*5.62*/(""""/>
<input type="hidden" name="idOp" value=""""),_display_(Seq[Any](/*6.42*/idOp)),format.raw/*6.46*/(""""/>
<input type="hidden" name=idOrdenCompra value=""""),_display_(Seq[Any](/*7.49*/idOrdenCompra)),format.raw/*7.62*/(""""/>
<input type="hidden" name="profe" value=""/> 
<input type="hidden" name="tipo_cuenta_id" value=""""),_display_(Seq[Any](/*9.52*/tipo_cuenta_id)),format.raw/*9.66*/(""""/> 



<table id="tablaAutorizados" class="table table-bordered table-hover">
	<thead>
		<tr>
 			<th colspan="3" align="right">
	 			 <span style="font-weight:bold;font-size:14px;">TOTAL A CARGAR</span>
			</th>
			<th colspan="2" align="center">
	 			 <span class="totales" style="font-weight:bold;font-size:14px;">$0.00</span>
			</th>
 		</tr>
 		<tr>
			<th colspan="3" align="left">
				<span>CARGA MONTO GENERAL</span>
				
			</th>
			<th width="100" colspan="2" align="right" id="th_monto_general">
				<input type="input" name="monto_general" class="monto_general form-control" />
				<p class="pErrores" style="font-weight:bold;"></p>
			</th>
		</tr>		
	</thead>
</table>	
"""),_display_(Seq[Any](/*35.2*/if(listaActas.size() > 0)/*35.27*/{_display_(Seq[Any](format.raw/*35.28*/("""

<input type="hidden" name="tiene_actas" class="form-control" value="true"  />
<table id="tablaAutorizados2" class="table table-bordered table-hover">
	<thead>
		<tr>
			<th width="30">
				<input type="checkbox" name="" id="seleccionarTodos"/>
			</th>
			<th width="40">N°</th>
			<th width="40">Fecha</th>
			<th width="40">Periodo</th>
			<th width="100">Total</th>
			<th width="100">Monto a Cargar</th>
		</tr>
	</thead>
	<tbody>
		
	   		"""),_display_(Seq[Any](/*53.8*/for(a <- listaActas) yield /*53.28*/ {_display_(Seq[Any](format.raw/*53.30*/("""
				<tr data-id=""""),_display_(Seq[Any](/*54.19*/a/*54.20*/.id)),format.raw/*54.23*/("""" class="seleccionarFila">
					<td>
						<input type="checkbox" class="checkFila" name="id[]" value=""""),_display_(Seq[Any](/*56.68*/a/*56.69*/.id)),format.raw/*56.72*/(""""/>
					</td>
					<td>"""),_display_(Seq[Any](/*58.11*/a/*58.12*/.numero)),format.raw/*58.19*/("""</td>
					<td align="center">"""),_display_(Seq[Any](/*59.26*/if(a.fecha != null)/*59.45*/{_display_(Seq[Any](_display_(Seq[Any](/*59.47*/(utils.DateUtils.formatDate(a.fecha))))))})),format.raw/*59.85*/("""</td>
					<td>"""),_display_(Seq[Any](/*60.11*/if(a.periodo_id != null)/*60.35*/ {_display_(Seq[Any](_display_(Seq[Any](/*60.38*/Periodo/*60.45*/.find.byId(a.periodo_id).nombre))))})),format.raw/*60.77*/("""</td>
					<td align="center">
						"""),_display_(Seq[Any](/*62.8*/(utils.NumberUtils.moneda(a.getTotal())))),format.raw/*62.48*/("""
						<input type="hidden" name="monto_total[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*63.109*/a/*63.110*/.getTotal())),format.raw/*63.121*/(""""/>
						<input type="hidden" name="monto_deuda[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*64.109*/a/*64.110*/.getTotal())),format.raw/*64.121*/(""""/>
					</td>
					<td>
						<input type="input" name="monto[]" disabled="disabled" class="monto form-control" />
						<p class="pErrores" style="font-weight:bold;"></p>
					</td>
				</tr>    
				"""),_display_(Seq[Any](/*71.6*/{monto_t= monto_t.add(a.getTotal())})),format.raw/*71.42*/("""
		 	""")))})),format.raw/*72.6*/("""	 	
		 	<tr>
					<td colspan="4" align="right"><span style="font-weight:bold;font-size:14px;">Total Actas</span></td>
					<td align="center">
						"""),_display_(Seq[Any](/*76.8*/(utils.NumberUtils.moneda(monto_t)))),format.raw/*76.43*/("""
						<input type="hidden" name="monto_t" class="" value=""""),_display_(Seq[Any](/*77.60*/monto_t)),format.raw/*77.67*/(""""/>
					</td>
					<td></td>
			</tr>		
   	</tbody>
   	<tfoot>
   		<tr>
 			<td colspan="4" align="right">
	 			 <span style="font-weight:bold;font-size:14px;">TOTAL A CARGAR</span>
			</td>
			<td colspan="2" align="center">
	 			 <span class="totales" style="font-weight:bold;font-size:14px;">$0.00</span>
			</td>
 		</tr>
 		<tr>
 			<td colspan="6" align="center">
	 			
			</td>
 		</tr>
	</tfoot>
 </table>
 """)))})),format.raw/*98.3*/("""  
   <div class="col-sm-12">
   <div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<div id="loadingAgregarMonto" class="loading hide"></div>
		<button  id="btn-agregarMonto" class="form-control btn btn-primary">Cargar</button>
	</div>
	</div>	
 </form>  
 
 
 
 
 
<script>
$( function()"""),format.raw/*113.14*/("""{"""),format.raw/*113.15*/("""
	$(".monto,.monto_general").numeric_input("""),format.raw/*114.43*/("""{"""),format.raw/*114.44*/("""allowNegative: false"""),format.raw/*114.64*/("""}"""),format.raw/*114.65*/(""");
	
	$('.monto').focusout( function()"""),format.raw/*116.34*/("""{"""),format.raw/*116.35*/("""
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*118.2*/("""}"""),format.raw/*118.3*/(""");
	
	$('.checkFila').change( function()"""),format.raw/*120.36*/("""{"""),format.raw/*120.37*/("""	
		seleccionAutorizado( $(this).closest('tr') );
		$("#tablaAutorizados2 tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*125.2*/("""}"""),format.raw/*125.3*/(""");
	
	
	$('#seleccionarTodos').change( function()"""),format.raw/*128.43*/("""{"""),format.raw/*128.44*/("""
		var table = $(this).closest('table');
		table.find("input[name='id[]']").prop("checked", $(this).prop("checked"));
		seleccionAutorizado( $('#tablaAutorizados2 tbody tr') );
		$("#tablaAutorizados2 tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*135.2*/("""}"""),format.raw/*135.3*/(""");
"""),format.raw/*136.1*/("""}"""),format.raw/*136.2*/(""");
</script>"""))}
    }
    
    def render(listaActas:List[ActaRecepcion],idAutorizado:Long,idOp:Long,idOrdenCompra:Long,tipo_cuenta_id:Long): play.api.templates.HtmlFormat.Appendable = apply(listaActas,idAutorizado,idOp,idOrdenCompra,tipo_cuenta_id)
    
    def f:((List[ActaRecepcion],Long,Long,Long,Long) => play.api.templates.HtmlFormat.Appendable) = (listaActas,idAutorizado,idOp,idOrdenCompra,tipo_cuenta_id) => apply(listaActas,idAutorizado,idOp,idOrdenCompra,tipo_cuenta_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/modales/modalAgregarMontos.scala.html
                    HASH: 922c19a8bfee95f36839d86d685385a600d986f7
                    MATRIX: 850->1|1114->101|1141->172|1191->187|1210->198|1296->263|1431->363|1464->375|1544->420|1569->424|1656->476|1690->489|1826->590|1861->604|2583->1291|2617->1316|2656->1317|3138->1764|3174->1784|3214->1786|3269->1805|3279->1806|3304->1809|3444->1913|3454->1914|3479->1917|3540->1942|3550->1943|3579->1950|3646->1981|3674->2000|3722->2002|3786->2040|3838->2056|3871->2080|3920->2083|3936->2090|3994->2122|4067->2160|4129->2200|4275->2309|4286->2310|4320->2321|4469->2433|4480->2434|4514->2445|4752->2648|4810->2684|4847->2690|5033->2841|5090->2876|5186->2936|5215->2943|5666->3363|6018->3686|6048->3687|6120->3730|6150->3731|6199->3751|6229->3752|6296->3790|6326->3791|6402->3839|6431->3840|6500->3880|6530->3881|6746->4069|6775->4070|6853->4119|6883->4120|7226->4435|7255->4436|7286->4439|7315->4440
                    LINES: 26->1|30->1|31->3|31->3|31->3|31->3|33->5|33->5|34->6|34->6|35->7|35->7|37->9|37->9|63->35|63->35|63->35|81->53|81->53|81->53|82->54|82->54|82->54|84->56|84->56|84->56|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|99->71|99->71|100->72|104->76|104->76|105->77|105->77|126->98|141->113|141->113|142->114|142->114|142->114|142->114|144->116|144->116|146->118|146->118|148->120|148->120|153->125|153->125|156->128|156->128|163->135|163->135|164->136|164->136
                    -- GENERATED --
                */
            