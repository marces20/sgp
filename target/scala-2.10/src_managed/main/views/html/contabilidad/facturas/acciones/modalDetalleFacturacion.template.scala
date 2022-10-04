
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
object modalDetalleFacturacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(f:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getClassPorcentajePagado/*3.26*/(i:Factura) = {{
	
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
}};
Seq[Any](format.raw/*1.13*/("""

"""),format.raw/*19.2*/("""


<div class="row">
	<div class="col-sm-6">
		<h4>Expediente: <b>"""),_display_(Seq[Any](/*24.23*/f/*24.24*/.expediente.getExpedienteEjercicio())),format.raw/*24.60*/("""</b></h4>
		<h4>Periodo: <b>"""),_display_(Seq[Any](/*25.20*/f/*25.21*/.periodo.nombre)),format.raw/*25.36*/("""</b></h4>
		<h4>Tipo Cuenta: <b>"""),_display_(Seq[Any](/*26.24*/if(f.tipoCuenta != null)/*26.48*/{_display_(Seq[Any](_display_(Seq[Any](/*26.50*/f/*26.51*/.tipoCuenta.nombre))))})),format.raw/*26.70*/("""</b></h4>
		<h4>Estado actual: 	<b>
						"""),_display_(Seq[Any](/*28.8*/if(f.getSaldoPendiente() != null && !f.getSaldoPendiente().equals(f.base) && (f.estado != null && f.estado.id == 19))/*28.125*/{_display_(Seq[Any](format.raw/*28.126*/("""
							Pagado """),_display_(Seq[Any](/*29.16*/getClassPorcentajePagado(f))),format.raw/*29.43*/("""%
						""")))}/*30.8*/else/*30.12*/{_display_(Seq[Any](format.raw/*30.13*/("""
							"""),_display_(Seq[Any](/*31.9*/if(f.estado != null)/*31.29*/{_display_(Seq[Any](_display_(Seq[Any](/*31.31*/(f.estado.nombre)))))})),format.raw/*31.49*/("""
						""")))})),format.raw/*32.8*/("""
						</b>
		</h4>
	</div>
	<div class="col-sm-6">
		<h4>Base: 	   <b>"""),_display_(Seq[Any](/*37.21*/utils/*37.26*/.NumberUtils.moneda(f.base))),format.raw/*37.53*/("""</b></h4>	
		<h4>Impuestos: <b>"""),_display_(Seq[Any](/*38.22*/utils/*38.27*/.NumberUtils.moneda(f.getTotalImpuesto()))),format.raw/*38.68*/("""</b></h4>	
		<h4>Total: 	   <b>"""),_display_(Seq[Any](/*39.22*/utils/*39.27*/.NumberUtils.moneda(f.getTotal()))),format.raw/*39.60*/("""</b></h4>
		<h4>Saldo Pendiente: 	   <b>"""),_display_(Seq[Any](/*40.32*/utils/*40.37*/.NumberUtils.moneda(f.getSaldoPendiente()))),format.raw/*40.79*/("""</b></h4>	
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<b>Lineas</b>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Cantidad</th>
							<th>UDM</th>
							<th>Precio</th>
							<th>Subtotal</th>
						</tr>
					</thead>
					"""),_display_(Seq[Any](/*60.7*/for(linea <- f.facturaLinea) yield /*60.35*/ {_display_(Seq[Any](format.raw/*60.37*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*62.13*/linea/*62.18*/.producto.nombre)),format.raw/*62.34*/("""</td>
							<td>"""),_display_(Seq[Any](/*63.13*/linea/*63.18*/.cantidad)),format.raw/*63.27*/("""</td>
							<td>"""),_display_(Seq[Any](/*64.13*/linea/*64.18*/.udm.nombre)),format.raw/*64.29*/("""</td>
							<td>"""),_display_(Seq[Any](/*65.13*/utils/*65.18*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*65.55*/("""</td>
							<td>"""),_display_(Seq[Any](/*66.13*/utils/*66.18*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*66.59*/("""</td>
						</tr>
					""")))})),format.raw/*68.7*/("""
				</table>
			</div>
		</div>	
	</div>
</div>
"""),_display_(Seq[Any](/*74.2*/if( f.facturaLineaImpuesto.size() > 0)/*74.40*/{_display_(Seq[Any](format.raw/*74.41*/("""
<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<b>Impuestos</b>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Descripcion</th>
							<th>Cuenta</th>
							<th>Base</th>
							<th>Importe</th>
						</tr>
					</thead>
					"""),_display_(Seq[Any](/*91.7*/for(linea <- f.facturaLineaImpuesto) yield /*91.43*/ {_display_(Seq[Any](format.raw/*91.45*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*93.13*/linea/*93.18*/.nombre)),format.raw/*93.25*/("""</td>
							<td>"""),_display_(Seq[Any](/*94.13*/linea/*94.18*/.cuenta.nombre)),format.raw/*94.32*/("""</td>
							<td>"""),_display_(Seq[Any](/*95.13*/utils/*95.18*/.NumberUtils.moneda(linea.base))),format.raw/*95.49*/("""</td>
							<td>"""),_display_(Seq[Any](/*96.13*/utils/*96.18*/.NumberUtils.moneda(linea.monto))),format.raw/*96.50*/("""</td>
						</tr>
					""")))})),format.raw/*98.7*/("""
				</table>
			</div>
		</div>	
	</div>
</div>
""")))})),format.raw/*104.2*/("""
"""))}
    }
    
    def render(f:Factura): play.api.templates.HtmlFormat.Appendable = apply(f)
    
    def f:((Factura) => play.api.templates.HtmlFormat.Appendable) = (f) => apply(f)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalDetalleFacturacion.scala.html
                    HASH: 8aad73142e31cbaaa03995b6de2386d8ca242c0d
                    MATRIX: 824->1|912->15|944->39|1745->12|1774->810|1877->877|1887->878|1945->914|2010->943|2020->944|2057->959|2126->992|2159->1016|2207->1018|2217->1019|2262->1038|2340->1081|2467->1198|2507->1199|2559->1215|2608->1242|2635->1251|2648->1255|2687->1256|2731->1265|2760->1285|2808->1287|2852->1305|2891->1313|2999->1385|3013->1390|3062->1417|3130->1449|3144->1454|3207->1495|3275->1527|3289->1532|3344->1565|3421->1606|3435->1611|3499->1653|3955->2074|3999->2102|4039->2104|4099->2128|4113->2133|4151->2149|4205->2167|4219->2172|4250->2181|4304->2199|4318->2204|4351->2215|4405->2233|4419->2238|4478->2275|4532->2293|4546->2298|4609->2339|4664->2363|4749->2413|4796->2451|4835->2452|5246->2828|5298->2864|5338->2866|5398->2890|5412->2895|5441->2902|5495->2920|5509->2925|5545->2939|5599->2957|5613->2962|5666->2993|5720->3011|5734->3016|5788->3048|5843->3072|5925->3122
                    LINES: 26->1|28->3|28->3|45->1|47->19|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|88->60|88->60|88->60|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|96->68|102->74|102->74|102->74|119->91|119->91|119->91|121->93|121->93|121->93|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96|126->98|132->104
                    -- GENERATED --
                */
            