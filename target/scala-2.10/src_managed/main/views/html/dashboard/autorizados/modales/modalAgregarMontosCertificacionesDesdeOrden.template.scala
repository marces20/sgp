
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
object modalAgregarMontosCertificacionesDesdeOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[CertificacionCompra],Long,Long,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaCerti: List[CertificacionCompra],idAutorizado:Long,idOrdenCompra:Long,tipo_cuenta_id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var monto_t=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.1*/("""<form action=""""),_display_(Seq[Any](/*3.16*/controllers/*3.27*/.dashboard.routes.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras())),format.raw/*3.114*/("""" method="POST" id="formCargarLineasAutorizados">

<input type="hidden" name="idAutorizado" value=""""),_display_(Seq[Any](/*5.50*/idAutorizado)),format.raw/*5.62*/(""""/>
<input type="hidden" name=idOrdenCompra value=""""),_display_(Seq[Any](/*6.49*/idOrdenCompra)),format.raw/*6.62*/(""""/>
<input type="hidden" name="profe" value=""/> 
<input type="hidden" name="tipo_cuenta_id" value=""""),_display_(Seq[Any](/*8.52*/tipo_cuenta_id)),format.raw/*8.66*/(""""/> 


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
"""),_display_(Seq[Any](/*33.2*/if(listaCerti.size() > 0)/*33.27*/{_display_(Seq[Any](format.raw/*33.28*/("""

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
		
	   		"""),_display_(Seq[Any](/*51.8*/for(a <- listaCerti) yield /*51.28*/ {_display_(Seq[Any](format.raw/*51.30*/("""
				<tr data-id=""""),_display_(Seq[Any](/*52.19*/a/*52.20*/.id)),format.raw/*52.23*/("""" class="seleccionarFila">
					<td>
						<input type="checkbox" class="checkFila" name="id[]" value=""""),_display_(Seq[Any](/*54.68*/a/*54.69*/.id)),format.raw/*54.72*/(""""/>
					</td>
					<td>CC</td>
					<td align="center">"""),_display_(Seq[Any](/*57.26*/if(a.fecha_certificacion != null)/*57.59*/{_display_(Seq[Any](_display_(Seq[Any](/*57.61*/(utils.DateUtils.formatDate(a.fecha_certificacion))))))})),format.raw/*57.113*/("""</td>
					<td>"""),_display_(Seq[Any](/*58.11*/if(a.periodo_id != null)/*58.35*/ {_display_(Seq[Any](_display_(Seq[Any](/*58.38*/Periodo/*58.45*/.find.byId(a.periodo_id).nombre))))})),format.raw/*58.77*/("""</td>
					<td align="center">
						"""),_display_(Seq[Any](/*60.8*/(utils.NumberUtils.moneda(a.getTotal())))),format.raw/*60.48*/("""
						<input type="hidden" name="monto_total[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*61.109*/a/*61.110*/.getTotal())),format.raw/*61.121*/(""""/>
					</td>
					<td>
						<input type="input" name="monto[]" disabled="disabled" class="monto form-control" />
						<p class="pErrores" style="font-weight:bold;"></p>
					</td>
				</tr>    
				"""),_display_(Seq[Any](/*68.6*/{monto_t= monto_t.add(a.getTotal())})),format.raw/*68.42*/("""
		 	""")))})),format.raw/*69.6*/("""	 	
		 	<tr>
					<td colspan="4" align="right"><span style="font-weight:bold;font-size:14px;">Total Certificaciones</span></td>
					<td align="center">
						"""),_display_(Seq[Any](/*73.8*/(utils.NumberUtils.moneda(monto_t)))),format.raw/*73.43*/("""
						<input type="hidden" name="monto_t" class="" value=""""),_display_(Seq[Any](/*74.60*/monto_t)),format.raw/*74.67*/(""""/>
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
 """)))})),format.raw/*95.3*/("""  
   <div class="col-sm-12">
   <div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<div id="loadingAgregarMonto" class="loading hide"></div>
		<button  id="btn-agregarMonto" class="form-control btn btn-primary">Cargar</button>
	</div>
	</div>	
 </form>  
 
 
 
 
 
<script>
$( function()"""),format.raw/*110.14*/("""{"""),format.raw/*110.15*/("""
	$(".monto,.monto_general").numeric_input("""),format.raw/*111.43*/("""{"""),format.raw/*111.44*/("""allowNegative: false"""),format.raw/*111.64*/("""}"""),format.raw/*111.65*/(""");
	
	$('.monto').focusout( function()"""),format.raw/*113.34*/("""{"""),format.raw/*113.35*/("""
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*115.2*/("""}"""),format.raw/*115.3*/(""");
	
	$('.checkFila').change( function()"""),format.raw/*117.36*/("""{"""),format.raw/*117.37*/("""	
		seleccionAutorizado( $(this).closest('tr') );
		$("#tablaAutorizados2 tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*122.2*/("""}"""),format.raw/*122.3*/(""");
	
	
	$('#seleccionarTodos').change( function()"""),format.raw/*125.43*/("""{"""),format.raw/*125.44*/("""
		var table = $(this).closest('table');
		table.find("input[name='id[]']").prop("checked", $(this).prop("checked"));
		seleccionAutorizado( $('#tablaAutorizados2 tbody tr') );
		$("#tablaAutorizados2 tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizados2 tr"));
	"""),format.raw/*132.2*/("""}"""),format.raw/*132.3*/(""");
"""),format.raw/*133.1*/("""}"""),format.raw/*133.2*/(""");
</script>"""))}
    }
    
    def render(listaCerti:List[CertificacionCompra],idAutorizado:Long,idOrdenCompra:Long,tipo_cuenta_id:Long): play.api.templates.HtmlFormat.Appendable = apply(listaCerti,idAutorizado,idOrdenCompra,tipo_cuenta_id)
    
    def f:((List[CertificacionCompra],Long,Long,Long) => play.api.templates.HtmlFormat.Appendable) = (listaCerti,idAutorizado,idOrdenCompra,tipo_cuenta_id) => apply(listaCerti,idAutorizado,idOrdenCompra,tipo_cuenta_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/modales/modalAgregarMontosCertificacionesDesdeOrden.scala.html
                    HASH: b24417410f68bc5baa5155e1e3b9495d81d4d466
                    MATRIX: 876->1|1135->97|1162->168|1212->183|1231->194|1340->281|1475->381|1508->393|1595->445|1629->458|1765->559|1800->573|2521->1259|2555->1284|2594->1285|3076->1732|3112->1752|3152->1754|3207->1773|3217->1774|3242->1777|3382->1881|3392->1882|3417->1885|3510->1942|3552->1975|3600->1977|3679->2029|3731->2045|3764->2069|3813->2072|3829->2079|3887->2111|3960->2149|4022->2189|4168->2298|4179->2299|4213->2310|4451->2513|4509->2549|4546->2555|4742->2716|4799->2751|4895->2811|4924->2818|5375->3238|5727->3561|5757->3562|5829->3605|5859->3606|5908->3626|5938->3627|6005->3665|6035->3666|6111->3714|6140->3715|6209->3755|6239->3756|6455->3944|6484->3945|6562->3994|6592->3995|6935->4310|6964->4311|6995->4314|7024->4315
                    LINES: 26->1|30->1|31->3|31->3|31->3|31->3|33->5|33->5|34->6|34->6|36->8|36->8|61->33|61->33|61->33|79->51|79->51|79->51|80->52|80->52|80->52|82->54|82->54|82->54|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|88->60|88->60|89->61|89->61|89->61|96->68|96->68|97->69|101->73|101->73|102->74|102->74|123->95|138->110|138->110|139->111|139->111|139->111|139->111|141->113|141->113|143->115|143->115|145->117|145->117|150->122|150->122|153->125|153->125|160->132|160->132|161->133|161->133
                    -- GENERATED --
                */
            