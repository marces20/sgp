
package views.html.contabilidad.balanceCuentaPropia

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
object listaPagos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Pago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pagos: List[Pago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/getClassEstado/*2.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 24){
		classEstado = "borrador"
	}else if(i != null && i.id == 26){
		classEstado = "cancelada"
	}else if(i != null && (i.id == 23)){
		classEstado = "autorizado"
	}else if(i != null && i.id == 25){
		classEstado = "pagado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.21*/("""
"""),format.raw/*15.2*/("""

"""),_display_(Seq[Any](/*17.2*/if(pagos != null)/*17.19*/{_display_(Seq[Any](format.raw/*17.20*/("""
	"""),_display_(Seq[Any](/*18.3*/if(pagos.size() > 0)/*18.23*/{_display_(Seq[Any](format.raw/*18.24*/("""
		<div class="row">
			<div class="col-sm-12">
				
				<h2>Pagos</h2>
					
				<table class="table table-bordered">
					<thead>
						<tr>
							 
							 
							<th>Referencia</th>
							<th>Fecha</th>
							<th>Fecha Concil.</th>
							<!-- <th>Entrega Factura</th>-->
							<!-- <th width="80">Fecha Conciliado</th> -->
							<th>C/O</th>
							<th>REF N°</th>
							<th>Contraparte</th>
							<th>Cuenta propia</th>
							<th>T.P.</th>
							<th>Orden pago</th>
							<th>Tipo Cuenta</th>
							<th>Exp.</th>
							<th>Periodo</th>
							<th>Total Debito</th>
							<th>Total Credito</th>
							<th>Estado</th>
							 
						</tr>
					</thead>
					<tbody>
					"""),_display_(Seq[Any](/*50.7*/for(pago <- pagos) yield /*50.25*/ {_display_(Seq[Any](format.raw/*50.27*/("""
						<tr class="pointer """),_display_(Seq[Any](/*51.27*/getClassEstado(pago.estado))),format.raw/*51.54*/("""" data-estado=""""),_display_(Seq[Any](/*51.70*/pago/*51.74*/.estado_id)),format.raw/*51.84*/("""">
							 
							 			
							<td>"""),_display_(Seq[Any](/*54.13*/(pago.nombre))),format.raw/*54.26*/("""</td>
							<td class="fecha">"""),_display_(Seq[Any](/*55.27*/if(pago.fecha_pago != null)/*55.54*/{_display_(Seq[Any](_display_(Seq[Any](/*55.56*/(utils.DateUtils.formatDate(pago.fecha_pago))))))})),format.raw/*55.102*/("""</td>
							<!--<td class="fechax">"""),_display_(Seq[Any](/*56.32*/if(pago.factura != null && pago.factura.fecha_recepcion != null)/*56.96*/{_display_(Seq[Any](_display_(Seq[Any](/*56.98*/(utils.DateUtils.formatDate(pago.factura.fecha_recepcion))))))})),format.raw/*56.157*/("""</td>-->
							<td class="fechaConciliado">"""),_display_(Seq[Any](/*57.37*/if(pago.fecha_conciliacion != null)/*57.72*/{_display_(Seq[Any](_display_(Seq[Any](/*57.74*/(utils.DateUtils.formatDate(pago.fecha_conciliacion))))))})),format.raw/*57.128*/("""</td> 
							<td>"""),_display_(Seq[Any](/*58.13*/if(pago.factura != null && pago.factura.proveedor != null && pago.tipo == "impuestos")/*58.99*/ {_display_(Seq[Any](_display_(Seq[Any](/*58.102*/(pago.factura.proveedor.nombre)))))})),format.raw/*58.134*/("""</td>
							
							<td class="referencia">"""),_display_(Seq[Any](/*60.32*/(pago.referencia))),format.raw/*60.49*/("""</td>
							<td>"""),_display_(Seq[Any](/*61.13*/(pago.proveedor.nombre))),format.raw/*61.36*/("""</td>
							<td>"""),_display_(Seq[Any](/*62.13*/if(pago.cuentaPropia != null)/*62.42*/ {_display_(Seq[Any](_display_(Seq[Any](/*62.45*/pago/*62.49*/.cuentaPropia.nombre))))})),format.raw/*62.70*/("""</td>
							<td class="tipoPago">
								"""),_display_(Seq[Any](/*64.10*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("cheque") == 0)/*64.79*/{_display_(Seq[Any](format.raw/*64.80*/("""cheque""")))})),format.raw/*64.87*/(""" 
								"""),_display_(Seq[Any](/*65.10*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("debito") == 0)/*65.79*/{_display_(Seq[Any](format.raw/*65.80*/("""debito""")))})),format.raw/*65.87*/(""" 
								"""),_display_(Seq[Any](/*66.10*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferencia") == 0)/*66.86*/{_display_(Seq[Any](format.raw/*66.87*/("""MacroOnline""")))})),format.raw/*66.99*/(""" 
								"""),_display_(Seq[Any](/*67.10*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferenciaInterbanking") == 0)/*67.98*/{_display_(Seq[Any](format.raw/*67.99*/("""Interbanking""")))})),format.raw/*67.112*/("""
								"""),_display_(Seq[Any](/*68.10*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferenciaMacroProveedores") == 0)/*68.102*/{_display_(Seq[Any](format.raw/*68.103*/("""MacroProveedores""")))})),format.raw/*68.120*/("""
							</td>
							<td>"""),_display_(Seq[Any](/*70.13*/if(pago.ordenPago != null)/*70.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*70.42*/pago/*70.46*/.ordenPago.getNombreCompleto()))))})),format.raw/*70.77*/("""</td>
							<td>"""),_display_(Seq[Any](/*71.13*/if(pago.tipoCuenta != null)/*71.40*/{_display_(Seq[Any](_display_(Seq[Any](/*71.42*/pago/*71.46*/.tipoCuenta.nombre))))})),format.raw/*71.65*/("""</td>
							<td>"""),_display_(Seq[Any](/*72.13*/if(pago.expediente != null)/*72.40*/ {_display_(Seq[Any](_display_(Seq[Any](/*72.43*/pago/*72.47*/.expediente.getExpedienteEjercicio()))))})),format.raw/*72.84*/("""</td>
							<td>"""),_display_(Seq[Any](/*73.13*/if(pago.periodo != null)/*73.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*73.40*/pago/*73.44*/.periodo.nombre))))})),format.raw/*73.60*/("""</td>
							<td class="total" rel=""""),_display_(Seq[Any](/*74.32*/pago/*74.36*/.total)),format.raw/*74.42*/("""">"""),_display_(Seq[Any](/*74.45*/(utils.NumberUtils.moneda(pago.total)))),format.raw/*74.83*/("""</td>
							<td class="totalCredito" rel=""""),_display_(Seq[Any](/*75.39*/pago/*75.43*/.total_credito)),format.raw/*75.57*/("""">"""),_display_(Seq[Any](/*75.60*/(utils.NumberUtils.moneda(pago.total_credito)))),format.raw/*75.106*/("""</td>
							<td class="estado">"""),_display_(Seq[Any](/*76.28*/(pago.estado.nombre))),format.raw/*76.48*/("""</td>
							 
						</tr>
		             """)))})),format.raw/*79.17*/("""
			        </tbody>
			        <tfoot>
			        	<tr>	
			        		<td colspan="12">.</td>
			        		<td></td>
			        		<td></td>
			        		<td colspan="1">&nbsp</td>
			        	</tr>
			        </tfoot>
				</table>	
				
			</div>		
		</div>		
	""")))})),format.raw/*93.3*/("""
""")))})))}
    }
    
    def render(pagos:List[Pago]): play.api.templates.HtmlFormat.Appendable = apply(pagos)
    
    def f:((List[Pago]) => play.api.templates.HtmlFormat.Appendable) = (pagos) => apply(pagos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balanceCuentaPropia/listaPagos.scala.html
                    HASH: 52f3b780bd65b4decdf585819cd58ace8f8549ad
                    MATRIX: 816->1|912->22|934->36|1287->20|1315->359|1353->362|1379->379|1418->380|1456->383|1485->403|1524->404|2250->1095|2284->1113|2324->1115|2387->1142|2436->1169|2488->1185|2501->1189|2533->1199|2605->1235|2640->1248|2708->1280|2744->1307|2792->1309|2865->1355|2938->1392|3011->1456|3059->1458|3145->1517|3226->1562|3270->1597|3318->1599|3399->1653|3454->1672|3549->1758|3599->1761|3658->1793|3739->1838|3778->1855|3832->1873|3877->1896|3931->1914|3969->1943|4018->1946|4031->1950|4078->1971|4158->2015|4236->2084|4275->2085|4314->2092|4361->2103|4439->2172|4478->2173|4517->2180|4564->2191|4649->2267|4688->2268|4732->2280|4779->2291|4876->2379|4915->2380|4961->2393|5007->2403|5109->2495|5149->2496|5199->2513|5261->2539|5296->2565|5345->2568|5358->2572|5415->2603|5469->2621|5505->2648|5553->2650|5566->2654|5611->2673|5665->2691|5701->2718|5750->2721|5763->2725|5826->2762|5880->2780|5913->2804|5962->2807|5975->2811|6017->2827|6090->2864|6103->2868|6131->2874|6170->2877|6230->2915|6310->2959|6323->2963|6359->2977|6398->2980|6467->3026|6536->3059|6578->3079|6653->3122|6947->3385
                    LINES: 26->1|28->2|28->2|42->1|43->15|45->17|45->17|45->17|46->18|46->18|46->18|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|82->54|82->54|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|88->60|88->60|89->61|89->61|90->62|90->62|90->62|90->62|90->62|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|98->70|98->70|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|104->76|104->76|107->79|121->93
                    -- GENERATED --
                */
            