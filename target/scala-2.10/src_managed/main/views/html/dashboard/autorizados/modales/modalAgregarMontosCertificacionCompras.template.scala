
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
object modalAgregarMontosCertificacionCompras extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[CertificacionCompra],Long,Long,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaCert: List[CertificacionCompra],idAutorizado:Long,idOrdenCompra:Long,tipo_cuenta_id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var monto_t=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.97*/("""
"""),format.raw/*3.1*/("""<form action=""""),_display_(Seq[Any](/*3.16*/controllers/*3.27*/.dashboard.routes.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras())),format.raw/*3.114*/("""" method="POST" id="formCargarLineasAutorizadosActas">

<input type="hidden" name="idAutorizado" value=""""),_display_(Seq[Any](/*5.50*/idAutorizado)),format.raw/*5.62*/(""""/>
<input type="hidden" name="profe" value=""/>
<input type="hidden" name="idOrdenCompra" value=""""),_display_(Seq[Any](/*7.51*/idOrdenCompra)),format.raw/*7.64*/(""""/> 
<input type="hidden" name="tipo_cuenta_id" value=""""),_display_(Seq[Any](/*8.52*/tipo_cuenta_id)),format.raw/*8.66*/(""""/> 

<table id="tablaAutorizadosActas" class="table table-bordered table-hover">
	<thead>
		<tr>
 			<th colspan="4" align="right">
	 			 <span style="font-weight:bold;font-size:14px;">TOTAL A CARGAR</span>
			</th>
			<th colspan="2" align="center">
	 			 <span class="totales" style="font-weight:bold;font-size:14px;">$0.00</span>
			</th>
 		</tr>
 		 
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
		
	   		"""),_display_(Seq[Any](/*35.8*/for(a <- listaCert) yield /*35.27*/ {_display_(Seq[Any](format.raw/*35.29*/("""
				<tr data-id=""""),_display_(Seq[Any](/*36.19*/a/*36.20*/.id)),format.raw/*36.23*/("""" class="seleccionarFila">
					<td>
						<input type="checkbox" class="checkFila" name="id[]" value=""""),_display_(Seq[Any](/*38.68*/a/*38.69*/.id)),format.raw/*38.72*/(""""/>
					</td>
					<td>CC</td>
					
					<td align="center">"""),_display_(Seq[Any](/*42.26*/if(a.fecha_certificacion != null)/*42.59*/{_display_(Seq[Any](_display_(Seq[Any](/*42.61*/(utils.DateUtils.formatDate(a.fecha_certificacion))))))})),format.raw/*42.113*/("""</td>
					<td>"""),_display_(Seq[Any](/*43.11*/if(a.periodo_id != null)/*43.35*/ {_display_(Seq[Any](_display_(Seq[Any](/*43.38*/Periodo/*43.45*/.find.byId(a.periodo_id).nombre))))})),format.raw/*43.77*/("""</td>
					<td align="center">
						"""),_display_(Seq[Any](/*45.8*/(utils.NumberUtils.moneda(a.base)))),format.raw/*45.42*/("""
						<input type="hidden" name="monto_total[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*46.109*/a/*46.110*/.base)),format.raw/*46.115*/(""""/>
					</td>
					<td>
						<input type="input" name="monto[]" disabled="disabled" class="monto form-control" />
						<p class="pErrores" style="font-weight:bold;"></p>
					</td>
				</tr>    
				"""),_display_(Seq[Any](/*53.6*/{monto_t= monto_t.add(a.getTotal())})),format.raw/*53.42*/("""
		 	""")))})),format.raw/*54.6*/("""	 	
		 	<tr>
					<td colspan="4" align="right"><span style="font-weight:bold;font-size:14px;">Total Certificaciones</span></td>
					<td align="center">
						"""),_display_(Seq[Any](/*58.8*/(utils.NumberUtils.moneda(monto_t)))),format.raw/*58.43*/("""
						<input type="hidden" name="monto_t" class="" value=""""),_display_(Seq[Any](/*59.60*/monto_t)),format.raw/*59.67*/(""""/>
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
	 			<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<div id="loadingAgregarMontoActa" class="loading hide"></div>
					<button  id="btn-agregarMontoActa" class="form-control btn btn-primary">Cargar</button>
				</div>
			</td>
 		</tr>
	</tfoot>
   </table>
 </form>  
 
 
 
 
 
<script>
$( function()"""),format.raw/*91.14*/("""{"""),format.raw/*91.15*/("""
	$(".monto,.monto_general").numeric_input("""),format.raw/*92.43*/("""{"""),format.raw/*92.44*/("""allowNegative: false"""),format.raw/*92.64*/("""}"""),format.raw/*92.65*/(""");
	
	$('.monto').focusout( function()"""),format.raw/*94.34*/("""{"""),format.raw/*94.35*/("""
		calcularTotal ($("#tablaAutorizados tr"));
	"""),format.raw/*96.2*/("""}"""),format.raw/*96.3*/(""");
	
	$('.checkFila').change( function()"""),format.raw/*98.36*/("""{"""),format.raw/*98.37*/("""	
		seleccionAutorizado( $(this).closest('tr') );
		$("#tablaAutorizadosActas tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal($("#tablaAutorizados tr"));
	"""),format.raw/*103.2*/("""}"""),format.raw/*103.3*/(""");
	
	$('#seleccionarTodos').change( function()"""),format.raw/*105.43*/("""{"""),format.raw/*105.44*/("""
		var table = $(this).closest('table');
		table.find("input[name='id[]']").prop("checked", $(this).prop("checked"));
		seleccionAutorizado( $('#tablaAutorizadosActas tbody tr') );
		$("#tablaAutorizadosActas tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizadosActas tr"));
	"""),format.raw/*112.2*/("""}"""),format.raw/*112.3*/(""");
	 
	
	
"""),format.raw/*116.1*/("""}"""),format.raw/*116.2*/(""");
</script>"""))}
    }
    
    def render(listaCert:List[CertificacionCompra],idAutorizado:Long,idOrdenCompra:Long,tipo_cuenta_id:Long): play.api.templates.HtmlFormat.Appendable = apply(listaCert,idAutorizado,idOrdenCompra,tipo_cuenta_id)
    
    def f:((List[CertificacionCompra],Long,Long,Long) => play.api.templates.HtmlFormat.Appendable) = (listaCert,idAutorizado,idOrdenCompra,tipo_cuenta_id) => apply(listaCert,idAutorizado,idOrdenCompra,tipo_cuenta_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/modales/modalAgregarMontosCertificacionCompras.scala.html
                    HASH: c52cd7767b0dff21515d062cae8c1b3ee0e740ca
                    MATRIX: 871->1|1129->96|1156->167|1206->182|1225->193|1334->280|1474->385|1507->397|1641->496|1675->509|1766->565|1801->579|2482->1225|2517->1244|2557->1246|2612->1265|2622->1266|2647->1269|2787->1373|2797->1374|2822->1377|2921->1440|2963->1473|3011->1475|3090->1527|3142->1543|3175->1567|3224->1570|3240->1577|3298->1609|3371->1647|3427->1681|3573->1790|3584->1791|3612->1796|3850->1999|3908->2035|3945->2041|4141->2202|4198->2237|4294->2297|4323->2304|5071->3024|5100->3025|5171->3068|5200->3069|5248->3089|5277->3090|5343->3128|5372->3129|5446->3176|5474->3177|5542->3217|5571->3218|5789->3408|5818->3409|5894->3456|5924->3457|6279->3784|6308->3785|6346->3795|6375->3796
                    LINES: 26->1|30->1|31->3|31->3|31->3|31->3|33->5|33->5|35->7|35->7|36->8|36->8|63->35|63->35|63->35|64->36|64->36|64->36|66->38|66->38|66->38|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|73->45|73->45|74->46|74->46|74->46|81->53|81->53|82->54|86->58|86->58|87->59|87->59|119->91|119->91|120->92|120->92|120->92|120->92|122->94|122->94|124->96|124->96|126->98|126->98|131->103|131->103|133->105|133->105|140->112|140->112|144->116|144->116
                    -- GENERATED --
                */
            