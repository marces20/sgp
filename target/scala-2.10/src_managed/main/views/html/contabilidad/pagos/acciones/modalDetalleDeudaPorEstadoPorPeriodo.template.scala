
package views.html.contabilidad.pagos.acciones

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
object modalDetalleDeudaPorEstadoPorPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Certificacion],List[Factura],List[Pago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificaciones:List[Certificacion],facturas:List[Factura],pagos:List[Pago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/getClassEstadoCertificacion/*2.29*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 28){
		classEstado = "borrador"
	}else if(i != null && i.id == 32){
		classEstado = "cancelada"
	}else if(i != null && i.id == 31){
		classEstado = "autorizado"
	}
	classEstado
}};def /*13.2*/getClassEstadoFacturacion/*13.27*/(i:Factura) = {{
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
}};def /*32.2*/getClassPorcentajePagado/*32.26*/(i:Factura) = {{
	
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
}};def /*49.2*/getClassEstadoPagos/*49.21*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 24){
		classEstado = "borrador"
	}else if(i != null && i.id == 26){
		classEstado = "cancelada"
	}else if(i != null && i.id == 23){
		classEstado = "autorizado"
	}
	classEstado
}};def /*60.2*/getTotalBaseCert/*60.18*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getBase())
	}
	total
}};def /*68.2*/getTotalDescuentoCert/*68.23*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getDescuento())
	}
	total
}};def /*76.2*/getTotalTotalCert/*76.19*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotal())
	}
	total
}};def /*83.2*/getTotalBaseFac/*83.17*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getBase())
	}
	total
}};def /*90.2*/getTotalImpuestosFac/*90.22*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotalImpuesto())
	}
	total
}};def /*97.2*/getTotalTotalFac/*97.18*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotal())
	}
	total
}};def /*104.2*/getTotalSaldoFac/*104.18*/(cl:List[Factura]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getSaldoPendiente())
	}
	total
}};def /*111.2*/getTotalSaldoPag/*111.18*/(cl:List[Pago]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.total)
	}
	total
}};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*12.2*/("""
"""),format.raw/*30.2*/("""

"""),format.raw/*48.2*/("""
"""),format.raw/*59.2*/("""
"""),format.raw/*66.2*/("""

"""),format.raw/*74.2*/("""

"""),format.raw/*82.2*/("""
"""),format.raw/*89.2*/("""
"""),format.raw/*96.2*/("""
"""),format.raw/*103.2*/("""
"""),format.raw/*110.2*/("""
"""),format.raw/*117.2*/("""



"""),_display_(Seq[Any](/*121.2*/if(certificaciones.size() > 0)/*121.32*/{_display_(Seq[Any](format.raw/*121.33*/("""
<h3>Certificaciones</h3>
<table class="table table-striped table-bordered tableEstadoGeneral">
	<thead>
		<tr>
			<th width="80">Referencia</th>
			<th width="70">Fecha</th>
			<th width="95">Expediente</th>
			<th width="95">Periodo</th>
			<th width="30">Tipo Cuenta</th>
			<th width="95">Base</th>
			<th width="95">Descuento</th>
			<th width="95">Total</th>
			<th width="100">Estado</th>
			<th width="30">Detalle</th> 
		</tr>
	</thead>
	<tbody>
		"""),_display_(Seq[Any](/*139.4*/for(certificacion <- certificaciones) yield /*139.41*/ {_display_(Seq[Any](format.raw/*139.43*/("""
			<tr class=""""),_display_(Seq[Any](/*140.16*/getClassEstadoCertificacion(certificacion.estado))),format.raw/*140.65*/("""">
				<td>"""),_display_(Seq[Any](/*141.10*/(certificacion.nombre))),format.raw/*141.32*/("""</td>
				<td class="fechaCertificacion">"""),_display_(Seq[Any](/*142.37*/if(certificacion.fecha_certificacion != null)/*142.82*/{_display_(Seq[Any](_display_(Seq[Any](/*142.84*/(utils.DateUtils.formatDate(certificacion.fecha_certificacion))))))})),format.raw/*142.148*/("""</td>
				<td>"""),_display_(Seq[Any](/*143.10*/if(certificacion.expediente != null)/*143.46*/{_display_(Seq[Any](_display_(Seq[Any](/*143.48*/certificacion/*143.61*/.expediente.getExpedienteEjercicio()))))})),format.raw/*143.98*/("""</td>
				<td>"""),_display_(Seq[Any](/*144.10*/if(certificacion.periodo != null)/*144.43*/{_display_(Seq[Any](_display_(Seq[Any](/*144.45*/(certificacion.periodo.nombre)))))})),format.raw/*144.76*/("""</td>
				<td>"""),_display_(Seq[Any](/*145.10*/if(certificacion.tipoCuenta != null)/*145.46*/{_display_(Seq[Any](_display_(Seq[Any](/*145.48*/certificacion/*145.61*/.tipoCuenta.nombre))))})),format.raw/*145.80*/("""</td>
				<td class="base" >"""),_display_(Seq[Any](/*146.24*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*146.75*/("""</td>
				<td class="descuento">"""),_display_(Seq[Any](/*147.28*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*147.84*/("""</td>
				<td class="total">"""),_display_(Seq[Any](/*148.24*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*148.76*/("""</td>
				<td class="estado">
					<div class='tip-top' title='"""),_display_(Seq[Any](/*150.35*/(certificacion.estado.significado))),format.raw/*150.69*/("""'>
					"""),_display_(Seq[Any](/*151.7*/if(certificacion.estado != null)/*151.39*/{_display_(Seq[Any](_display_(Seq[Any](/*151.41*/(certificacion.estado.nombre)))))})),format.raw/*151.71*/("""
					</div>
				</td>
				<td>
					<a href='#' class='detalleCertificacionModal' data-url='"""),_display_(Seq[Any](/*155.63*/controllers/*155.74*/.compras.routes.CertificacionesAccionesController.modalDetalleCertificacion(certificacion.id))),format.raw/*155.167*/("""'>
					<i class='glyphicon glyphicon-tasks'></i></a>
				</td>
			</tr>
		""")))})),format.raw/*159.4*/("""
		<tr>	
			<td colspan='5' style='text-align: right;'><b>Totales:</b></td>
			<td>"""),_display_(Seq[Any](/*162.9*/utils/*162.14*/.NumberUtils.moneda(getTotalBaseCert(certificaciones)))),format.raw/*162.68*/("""</td>
			<td>"""),_display_(Seq[Any](/*163.9*/utils/*163.14*/.NumberUtils.moneda(getTotalDescuentoCert(certificaciones)))),format.raw/*163.73*/("""</td>
			<td>"""),_display_(Seq[Any](/*164.9*/utils/*164.14*/.NumberUtils.moneda(getTotalTotalCert(certificaciones)))),format.raw/*164.69*/("""</td>
			<td colspan='2'></td>
		</tr>
	</tbody>
</table>
""")))})),format.raw/*169.2*/("""

"""),_display_(Seq[Any](/*171.2*/if(facturas.size() > 0)/*171.25*/{_display_(Seq[Any](format.raw/*171.26*/("""
<h3>Facturacion</h3>
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
		"""),_display_(Seq[Any](/*191.4*/for(factura <- facturas) yield /*191.28*/ {_display_(Seq[Any](format.raw/*191.30*/("""
			<tr class=""""),_display_(Seq[Any](/*192.16*/getClassEstadoFacturacion(factura))),format.raw/*192.50*/("""">
				<td>"""),_display_(Seq[Any](/*193.10*/(factura.nombre))),format.raw/*193.26*/("""</td>
				<td class="opg">"""),_display_(Seq[Any](/*194.22*/if(factura.ordenPago != null)/*194.51*/{_display_(Seq[Any](_display_(Seq[Any](/*194.53*/(factura.ordenPago.numero)))))})),format.raw/*194.80*/("""</td>
				<td>"""),_display_(Seq[Any](/*195.10*/(factura.numero_factura))),format.raw/*195.34*/("""</td>
				<td>"""),_display_(Seq[Any](/*196.10*/if(factura.expediente != null)/*196.40*/{_display_(Seq[Any](_display_(Seq[Any](/*196.42*/(factura.expediente.getExpedienteEjercicio())))))})),format.raw/*196.88*/("""</td>
				<td>"""),_display_(Seq[Any](/*197.10*/if(factura.periodo != null)/*197.37*/{_display_(Seq[Any](_display_(Seq[Any](/*197.39*/(factura.periodo.nombre)))))})),format.raw/*197.64*/("""</td>
				<td>"""),_display_(Seq[Any](/*198.10*/if(factura.tipoCuenta != null)/*198.40*/{_display_(Seq[Any](_display_(Seq[Any](/*198.42*/factura/*198.49*/.tipoCuenta.nombre))))})),format.raw/*198.68*/("""</td>
				<td class="totalBase">"""),_display_(Seq[Any](/*199.28*/if(factura.base != null)/*199.52*/{_display_(Seq[Any](_display_(Seq[Any](/*199.54*/(utils.NumberUtils.moneda(factura.base))))))})),format.raw/*199.95*/("""</td>
				<td class="totalImpuestos">"""),_display_(Seq[Any](/*200.33*/(utils.NumberUtils.moneda(factura.getTotalImpuesto())))),format.raw/*200.87*/("""</td>
				<td class="total">"""),_display_(Seq[Any](/*201.24*/(utils.NumberUtils.moneda(factura.getTotal())))),format.raw/*201.70*/("""</td>
				<td class="totalSaldo">"""),_display_(Seq[Any](/*202.29*/(utils.NumberUtils.moneda(factura.getSaldoPendiente())))),format.raw/*202.84*/("""</td>
				<td class="estado" align="center">
					<div class='tip-top' title='"""),_display_(Seq[Any](/*204.35*/(factura.estado.significado))),format.raw/*204.63*/("""'>
					"""),_display_(Seq[Any](/*205.7*/if(factura.getSaldoPendiente() != null && !factura.getSaldoPendiente().equals(factura.base) && (factura.estado != null && factura.estado.id == 19))/*205.154*/{_display_(Seq[Any](format.raw/*205.155*/("""
						Pagado """),_display_(Seq[Any](/*206.15*/getClassPorcentajePagado(factura))),format.raw/*206.48*/("""%
					""")))}/*207.7*/else/*207.11*/{_display_(Seq[Any](format.raw/*207.12*/("""
						"""),_display_(Seq[Any](/*208.8*/if(factura.estado != null)/*208.34*/{_display_(Seq[Any](_display_(Seq[Any](/*208.36*/(factura.estado.nombre)))))})),format.raw/*208.60*/("""
					""")))})),format.raw/*209.7*/("""
					</div>
				</td>
				<td> 
					<a href='#' class='detalleFacturacionModal' data-url='"""),_display_(Seq[Any](/*213.61*/controllers/*213.72*/.contabilidad.routes.FacturasAccionesController.modalDetalleFacturacion(factura.id))),format.raw/*213.155*/("""'>
					<i class='glyphicon glyphicon-tasks'></i></a> 
				</td>	
			</tr>
		""")))})),format.raw/*217.4*/("""
		<tr>	
			<td colspan='6' style='text-align: right;'><b>Totales:</b></td>
			<td>"""),_display_(Seq[Any](/*220.9*/utils/*220.14*/.NumberUtils.moneda(getTotalBaseFac(facturas)))),format.raw/*220.60*/("""</td>
			<td>"""),_display_(Seq[Any](/*221.9*/utils/*221.14*/.NumberUtils.moneda(getTotalImpuestosFac(facturas)))),format.raw/*221.65*/("""</td>
			<td>"""),_display_(Seq[Any](/*222.9*/utils/*222.14*/.NumberUtils.moneda(getTotalTotalFac(facturas)))),format.raw/*222.61*/("""</td> 
			<td>"""),_display_(Seq[Any](/*223.9*/utils/*223.14*/.NumberUtils.moneda(getTotalSaldoFac(facturas)))),format.raw/*223.61*/("""</td> 
			<td colspan='2'></td>
		</tr>
	</tbody>
</table>
""")))})),format.raw/*228.2*/("""

"""),_display_(Seq[Any](/*230.2*/if(pagos.size() > 0)/*230.22*/{_display_(Seq[Any](format.raw/*230.23*/("""
<h3>Pagos</h3>
	<table class="table table-bordered tableEstadoGeneral">
		<thead>
			<tr>
				<th width="100">Fecha</th>
				<th width="70">REF N°</th>
				<th width="70">Orden pago</th>
				<th width="80">Expediente</th>
				<th width="60">Periodo</th>
				<th width="30">Tipo Cuenta</th>
				<th width="100">Total</th>
				<th width="100">Estado</th>
				<th width="30">Detalle</th> 
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*247.4*/for(pago <- pagos) yield /*247.22*/ {_display_(Seq[Any](format.raw/*247.24*/("""
			<tr class=""""),_display_(Seq[Any](/*248.16*/getClassEstadoPagos(pago.estado))),format.raw/*248.48*/("""">
				<td class="fecha">"""),_display_(Seq[Any](/*249.24*/if(pago.fecha_pago != null)/*249.51*/{_display_(Seq[Any](_display_(Seq[Any](/*249.53*/(utils.DateUtils.formatDate(pago.fecha_pago))))))})),format.raw/*249.99*/("""</td>
				<td class="referencia">"""),_display_(Seq[Any](/*250.29*/(pago.referencia))),format.raw/*250.46*/("""</td>
				<td>"""),_display_(Seq[Any](/*251.10*/if(pago.ordenPago != null)/*251.36*/ {_display_(Seq[Any](_display_(Seq[Any](/*251.39*/pago/*251.43*/.ordenPago.numero))))})),format.raw/*251.61*/("""</td>
				<td>"""),_display_(Seq[Any](/*252.10*/if(pago.expediente != null)/*252.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*252.40*/pago/*252.44*/.expediente.getExpedienteEjercicio()))))})),format.raw/*252.81*/("""</td>
				<td>"""),_display_(Seq[Any](/*253.10*/if(pago.periodo != null)/*253.34*/ {_display_(Seq[Any](_display_(Seq[Any](/*253.37*/pago/*253.41*/.periodo.nombre))))})),format.raw/*253.57*/("""</td>
				<td>"""),_display_(Seq[Any](/*254.10*/if(pago.tipoCuenta != null)/*254.37*/{_display_(Seq[Any](_display_(Seq[Any](/*254.39*/pago/*254.43*/.tipoCuenta.nombre))))})),format.raw/*254.62*/("""</td>
				<td class="total" rel=""""),_display_(Seq[Any](/*255.29*/pago/*255.33*/.total)),format.raw/*255.39*/("""">"""),_display_(Seq[Any](/*255.42*/(utils.NumberUtils.moneda(pago.total)))),format.raw/*255.80*/("""</td>
				<td class="estado">
					<div class='tip-top' title='"""),_display_(Seq[Any](/*257.35*/(pago.estado.significado))),format.raw/*257.60*/("""'>
						"""),_display_(Seq[Any](/*258.8*/(pago.estado.nombre))),format.raw/*258.28*/("""
					</div>
				</td>
				<td> 
					<a href='#' class='detallePagoModal' data-url='"""),_display_(Seq[Any](/*262.54*/controllers/*262.65*/.contabilidad.routes.PagosAccionesController.modalDetallePago(pago.id))),format.raw/*262.135*/("""'>
					<i class='glyphicon glyphicon-tasks'></i></a>
				</td>	
			</tr>
		""")))})),format.raw/*266.4*/("""
			<tr>	
        		<td colspan='6' style='text-align: right;'><b>Totales:</b></td>
        		<td>"""),_display_(Seq[Any](/*269.16*/utils/*269.21*/.NumberUtils.moneda(getTotalSaldoPag(pagos)))),format.raw/*269.65*/("""</td>
        		<td colspan="2">&nbsp</td>
	        </tr>
		</tbody>
	</table>

""")))})))}
    }
    
    def render(certificaciones:List[Certificacion],facturas:List[Factura],pagos:List[Pago]): play.api.templates.HtmlFormat.Appendable = apply(certificaciones,facturas,pagos)
    
    def f:((List[Certificacion],List[Factura],List[Pago]) => play.api.templates.HtmlFormat.Appendable) = (certificaciones,facturas,pagos) => apply(certificaciones,facturas,pagos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalDetalleDeudaPorEstadoPorPeriodo.scala.html
                    HASH: 9e9e9ad07aa9eb57897bd345825a007ba3da504f
                    MATRIX: 871->1|1025->80|1060->107|1332->367|1366->392|1892->907|1925->931|2710->1704|2738->1723|3010->1983|3035->1999|3200->2153|3230->2174|3400->2333|3426->2350|3592->2504|3616->2519|3775->2666|3804->2686|3972->2842|3997->2858|4158->3006|4184->3022|4354->3179|4380->3195|4548->78|4576->365|4604->904|4633->1702|4661->1981|4689->2150|4718->2330|4747->2502|4775->2664|4803->2840|4832->3004|4861->3177|4890->3333|4931->3338|4971->3368|5011->3369|5505->3827|5559->3864|5600->3866|5653->3882|5725->3931|5774->3943|5819->3965|5898->4007|5953->4052|6002->4054|6094->4118|6146->4133|6192->4169|6241->4171|6264->4184|6328->4221|6380->4236|6423->4269|6472->4271|6530->4302|6582->4317|6628->4353|6677->4355|6700->4368|6746->4387|6812->4416|6886->4467|6956->4500|7035->4556|7101->4585|7176->4637|7277->4701|7334->4735|7379->4744|7421->4776|7470->4778|7527->4808|7658->4902|7679->4913|7796->5006|7904->5082|8024->5166|8039->5171|8116->5225|8166->5239|8181->5244|8263->5303|8313->5317|8328->5322|8406->5377|8497->5436|8536->5439|8569->5462|8609->5463|9168->5986|9209->6010|9250->6012|9303->6028|9360->6062|9409->6074|9448->6090|9512->6117|9551->6146|9600->6148|9654->6175|9706->6190|9753->6214|9805->6229|9845->6259|9894->6261|9967->6307|10019->6322|10056->6349|10105->6351|10157->6376|10209->6391|10249->6421|10298->6423|10315->6430|10361->6449|10431->6482|10465->6506|10514->6508|10582->6549|10657->6587|10734->6641|10800->6670|10869->6716|10940->6750|11018->6805|11134->6884|11185->6912|11230->6921|11388->7068|11429->7069|11481->7084|11537->7117|11564->7125|11578->7129|11618->7130|11662->7138|11698->7164|11747->7166|11798->7190|11837->7197|11967->7290|11988->7301|12095->7384|12205->7462|12325->7546|12340->7551|12409->7597|12459->7611|12474->7616|12548->7667|12598->7681|12613->7686|12683->7733|12734->7748|12749->7753|12819->7800|12911->7860|12950->7863|12980->7883|13020->7884|13476->8304|13511->8322|13552->8324|13605->8340|13660->8372|13723->8398|13760->8425|13809->8427|13882->8473|13953->8507|13993->8524|14045->8539|14081->8565|14131->8568|14145->8572|14190->8590|14242->8605|14279->8632|14329->8635|14343->8639|14407->8676|14459->8691|14493->8715|14543->8718|14557->8722|14600->8738|14652->8753|14689->8780|14738->8782|14752->8786|14798->8805|14869->8839|14883->8843|14912->8849|14952->8852|15013->8890|15114->8954|15162->8979|15208->8989|15251->9009|15374->9095|15395->9106|15489->9176|15598->9253|15734->9352|15749->9357|15816->9401
                    LINES: 26->1|28->2|28->2|38->13|38->13|55->32|55->32|71->49|71->49|81->60|81->60|87->68|87->68|93->76|93->76|99->83|99->83|105->90|105->90|111->97|111->97|117->104|117->104|123->111|123->111|130->1|131->12|132->30|134->48|135->59|136->66|138->74|140->82|141->89|142->96|143->103|144->110|145->117|149->121|149->121|149->121|167->139|167->139|167->139|168->140|168->140|169->141|169->141|170->142|170->142|170->142|170->142|171->143|171->143|171->143|171->143|171->143|172->144|172->144|172->144|172->144|173->145|173->145|173->145|173->145|173->145|174->146|174->146|175->147|175->147|176->148|176->148|178->150|178->150|179->151|179->151|179->151|179->151|183->155|183->155|183->155|187->159|190->162|190->162|190->162|191->163|191->163|191->163|192->164|192->164|192->164|197->169|199->171|199->171|199->171|219->191|219->191|219->191|220->192|220->192|221->193|221->193|222->194|222->194|222->194|222->194|223->195|223->195|224->196|224->196|224->196|224->196|225->197|225->197|225->197|225->197|226->198|226->198|226->198|226->198|226->198|227->199|227->199|227->199|227->199|228->200|228->200|229->201|229->201|230->202|230->202|232->204|232->204|233->205|233->205|233->205|234->206|234->206|235->207|235->207|235->207|236->208|236->208|236->208|236->208|237->209|241->213|241->213|241->213|245->217|248->220|248->220|248->220|249->221|249->221|249->221|250->222|250->222|250->222|251->223|251->223|251->223|256->228|258->230|258->230|258->230|275->247|275->247|275->247|276->248|276->248|277->249|277->249|277->249|277->249|278->250|278->250|279->251|279->251|279->251|279->251|279->251|280->252|280->252|280->252|280->252|280->252|281->253|281->253|281->253|281->253|281->253|282->254|282->254|282->254|282->254|282->254|283->255|283->255|283->255|283->255|283->255|285->257|285->257|286->258|286->258|290->262|290->262|290->262|294->266|297->269|297->269|297->269
                    -- GENERATED --
                */
            