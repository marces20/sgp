
package views.html.contabilidad.facturas.acciones

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
object modalDetalleFacturacionPorEstadoPorPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facturas:List[Factura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getClassEstado/*3.16*/(i:Factura) = {{
	var classEstado:String = new String()
	var saldoPendiente:BigDecimal = i.getSaldoPendiente()
	var base:BigDecimal = i.getBase()
	
	if(!saldoPendiente.equals(base) && i.estado != null && i.estado_id == 19){
		classEstado = "pagado"
	}else{
		if(i.estado != null && i.estado.id == 18){
			classEstado = "borrador"
		}else if(i.estado != null && i.estado.id == 21){
			classEstado = "cancelada"
		}else if(i.estado != null && i.estado.id == 19){
			classEstado = "autorizado"
		}
	}
	classEstado
}};def /*22.2*/getClassPorcentajePagado/*22.26*/(i:Factura) = {{
	
	var cien:java.math.BigDecimal = new java.math.BigDecimal(100)
	var porcentaje:java.math.BigDecimal = new java.math.BigDecimal(0)
	var cero:java.math.BigDecimal = new java.math.BigDecimal(0)
	var saldoPendiente:java.math.BigDecimal = i.getSaldoPendiente()
	var base:java.math.BigDecimal = i.base
	if(i.estado != null && i.estado.id == 19){
		if(saldoPendiente.compareTo(java.math.BigDecimal.ZERO) != 0 && base.compareTo(java.math.BigDecimal.ZERO) != 0){
			porcentaje = (base.subtract(saldoPendiente)).multiply(cien).divide(i.base, 2, java.math.RoundingMode.HALF_UP)
		}else{
			porcentaje = new java.math.BigDecimal(0)
		}
		porcentaje = (base.subtract(saldoPendiente)).multiply(cien).divide(i.base, 2, java.math.RoundingMode.HALF_UP)
	}
	porcentaje
}};def /*40.2*/getTotalBase/*40.14*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getBase())
	}
	total
}};def /*47.2*/getTotalImpuestos/*47.19*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotalImpuesto())
	}
	total
}};def /*54.2*/getTotalTotal/*54.15*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotal())
	}
	total
}};def /*61.2*/getTotalSaldo/*61.15*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getSaldoPendiente())
	}
	total
}};
Seq[Any](format.raw/*1.26*/("""

"""),format.raw/*20.2*/("""

"""),format.raw/*38.2*/("""

"""),format.raw/*46.2*/("""
"""),format.raw/*53.2*/("""
"""),format.raw/*60.2*/("""
"""),format.raw/*67.2*/("""
<table class="table table-bordered tableEstadoGeneral">
	<thead>
		<tr>
			<th width="100">Referencia</th>
			<th width="70">OPG</th>
			<th width="100">N° Factura</th>
			<th width="95">Expediente</th>
			<th width="95">Periodo</th>
			<th width="30">Tipo Cuenta</th>
			<th width="100">Base</th>
			<th width="100">Total impuestos</th>
			<th width="100">Total</th>
			<th width="100">Saldo pendiente</th>
			<th width="100">Estado</th>
			<th width="30">Detalle</th> 
		</tr>
	</thead>
	<tbody>
		"""),_display_(Seq[Any](/*86.4*/for(factura <- facturas) yield /*86.28*/ {_display_(Seq[Any](format.raw/*86.30*/("""
			<tr class=""""),_display_(Seq[Any](/*87.16*/getClassEstado(factura))),format.raw/*87.39*/("""">
				<td>"""),_display_(Seq[Any](/*88.10*/(factura.nombre))),format.raw/*88.26*/("""</td>
				<td class="opg">"""),_display_(Seq[Any](/*89.22*/if(factura.ordenPago != null)/*89.51*/{_display_(Seq[Any](_display_(Seq[Any](/*89.53*/(factura.ordenPago.numero)))))})),format.raw/*89.80*/("""</td>
				<td>"""),_display_(Seq[Any](/*90.10*/(factura.numero_factura))),format.raw/*90.34*/("""</td>
				<td>"""),_display_(Seq[Any](/*91.10*/if(factura.expediente != null)/*91.40*/{_display_(Seq[Any](_display_(Seq[Any](/*91.42*/(factura.expediente.getExpedienteEjercicio())))))})),format.raw/*91.88*/("""</td>
				<td>"""),_display_(Seq[Any](/*92.10*/if(factura.periodo != null)/*92.37*/{_display_(Seq[Any](_display_(Seq[Any](/*92.39*/(factura.periodo.nombre)))))})),format.raw/*92.64*/("""</td>
				<td>"""),_display_(Seq[Any](/*93.10*/if(factura.tipoCuenta != null)/*93.40*/{_display_(Seq[Any](_display_(Seq[Any](/*93.42*/factura/*93.49*/.tipoCuenta.nombre))))})),format.raw/*93.68*/("""</td>
				<td class="totalBase">"""),_display_(Seq[Any](/*94.28*/if(factura.base != null)/*94.52*/{_display_(Seq[Any](_display_(Seq[Any](/*94.54*/(utils.NumberUtils.moneda(factura.base))))))})),format.raw/*94.95*/("""</td>
				<td class="totalImpuestos">"""),_display_(Seq[Any](/*95.33*/(utils.NumberUtils.moneda(factura.getTotalImpuesto())))),format.raw/*95.87*/("""</td>
				<td class="total">"""),_display_(Seq[Any](/*96.24*/(utils.NumberUtils.moneda(factura.getTotal())))),format.raw/*96.70*/("""</td>
				<td class="totalSaldo">"""),_display_(Seq[Any](/*97.29*/(utils.NumberUtils.moneda(factura.getSaldoPendiente())))),format.raw/*97.84*/("""</td>
				<td class="estado" align="center">
					<div class='tip-top' title='"""),_display_(Seq[Any](/*99.35*/(factura.estado.significado))),format.raw/*99.63*/("""'>
					"""),_display_(Seq[Any](/*100.7*/if(factura.getSaldoPendiente() != null && !factura.getSaldoPendiente().equals(factura.base) && (factura.estado != null && factura.estado.id == 19))/*100.154*/{_display_(Seq[Any](format.raw/*100.155*/("""
						Pagado """),_display_(Seq[Any](/*101.15*/getClassPorcentajePagado(factura))),format.raw/*101.48*/("""%
					""")))}/*102.7*/else/*102.11*/{_display_(Seq[Any](format.raw/*102.12*/("""
						"""),_display_(Seq[Any](/*103.8*/if(factura.estado != null)/*103.34*/{_display_(Seq[Any](_display_(Seq[Any](/*103.36*/(factura.estado.nombre)))))})),format.raw/*103.60*/("""
					""")))})),format.raw/*104.7*/("""
					</div>
				</td>
				<td> 
					<a href='#' class='detalleFacturacionModal' data-url='"""),_display_(Seq[Any](/*108.61*/controllers/*108.72*/.contabilidad.routes.FacturasAccionesController.modalDetalleFacturacion(factura.id))),format.raw/*108.155*/("""'>
					<i class='glyphicon glyphicon-tasks'></i></a> 
				</td>	
			</tr>
		""")))})),format.raw/*112.4*/("""
		
		<tr>	
			<td colspan='6' style='text-align: right;'><b>Totales:</b></td>
			<td>"""),_display_(Seq[Any](/*116.9*/utils/*116.14*/.NumberUtils.moneda(getTotalBase(facturas)))),format.raw/*116.57*/("""</td>
			<td>"""),_display_(Seq[Any](/*117.9*/utils/*117.14*/.NumberUtils.moneda(getTotalImpuestos(facturas)))),format.raw/*117.62*/("""</td>
			<td>"""),_display_(Seq[Any](/*118.9*/utils/*118.14*/.NumberUtils.moneda(getTotalTotal(facturas)))),format.raw/*118.58*/("""</td> 
			<td>"""),_display_(Seq[Any](/*119.9*/utils/*119.14*/.NumberUtils.moneda(getTotalSaldo(facturas)))),format.raw/*119.58*/("""</td> 
			<td colspan='2'></td>
		</tr>
	</tbody>
</table>


					 
					
					
					
					
					"""))}
    }
    
    def render(facturas:List[Factura]): play.api.templates.HtmlFormat.Appendable = apply(facturas)
    
    def f:((List[Factura]) => play.api.templates.HtmlFormat.Appendable) = (facturas) => apply(facturas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalDetalleFacturacionPorEstadoPorPeriodo.scala.html
                    HASH: de28b0babf361bf0c88e55cf3fecbb572c863625
                    MATRIX: 849->1|950->28|972->42|1498->557|1531->581|2316->1355|2337->1367|2496->1514|2522->1531|2690->1687|2712->1700|2872->1848|2894->1861|3079->25|3108->554|3137->1352|3166->1512|3194->1685|3222->1846|3250->2016|3787->2518|3827->2542|3867->2544|3919->2560|3964->2583|4012->2595|4050->2611|4113->2638|4151->2667|4199->2669|4252->2696|4303->2711|4349->2735|4400->2750|4439->2780|4487->2782|4559->2828|4610->2843|4646->2870|4694->2872|4745->2897|4796->2912|4835->2942|4883->2944|4899->2951|4944->2970|5013->3003|5046->3027|5094->3029|5161->3070|5235->3108|5311->3162|5376->3191|5444->3237|5514->3271|5591->3326|5706->3405|5756->3433|5801->3442|5959->3589|6000->3590|6052->3605|6108->3638|6135->3646|6149->3650|6189->3651|6233->3659|6269->3685|6318->3687|6369->3711|6408->3718|6538->3811|6559->3822|6666->3905|6776->3983|6899->4070|6914->4075|6980->4118|7030->4132|7045->4137|7116->4185|7166->4199|7181->4204|7248->4248|7299->4263|7314->4268|7381->4312
                    LINES: 26->1|28->3|28->3|45->22|45->22|61->40|61->40|67->47|67->47|73->54|73->54|79->61|79->61|86->1|88->20|90->38|92->46|93->53|94->60|95->67|114->86|114->86|114->86|115->87|115->87|116->88|116->88|117->89|117->89|117->89|117->89|118->90|118->90|119->91|119->91|119->91|119->91|120->92|120->92|120->92|120->92|121->93|121->93|121->93|121->93|121->93|122->94|122->94|122->94|122->94|123->95|123->95|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|128->100|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|132->104|136->108|136->108|136->108|140->112|144->116|144->116|144->116|145->117|145->117|145->117|146->118|146->118|146->118|147->119|147->119|147->119
                    -- GENERATED --
                */
            