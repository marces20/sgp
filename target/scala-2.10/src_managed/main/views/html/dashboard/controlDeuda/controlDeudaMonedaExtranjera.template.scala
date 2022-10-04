
package views.html.dashboard.controlDeuda

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
object controlDeudaMonedaExtranjera extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[List[models.informes.InformeDeudaProveedoresMaterializada],List[models.AutorizadoLinea],List[models.Factura],Orden,List[com.avaje.ebean.SqlRow],java.math.BigDecimal,DynamicForm,List[models.Factura],List[models.AutorizadoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(r:List[models.informes.InformeDeudaProveedoresMaterializada],
al:List[models.AutorizadoLinea],
f:List[models.Factura],
o:Orden,rowActas:List[com.avaje.ebean.SqlRow],
ultimaCotizacion:java.math.BigDecimal,
formBuscador: DynamicForm,
fh:List[models.Factura],
alHijo:List[models.AutorizadoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalDeudaDolar=new java.math.BigDecimal(0);var totalDeuda=new java.math.BigDecimal(0);var totalActa=new java.math.BigDecimal(0);var totalActaDolar=new java.math.BigDecimal(0);var totalAutorizadoDolar=new java.math.BigDecimal(0);var totalAutorizado=new java.math.BigDecimal(0);var totalFacturaDolar=new java.math.BigDecimal(0);var totalFactura=new java.math.BigDecimal(0);

def /*13.2*/scripts/*13.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.13*/("""
	<script src=""""),_display_(Seq[Any](/*14.16*/routes/*14.22*/.Assets.at("javascripts/dashboard/autorizado.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
""")))};implicit def /*12.2*/implicitFieldConstructor/*12.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*8.37*/("""
"""),format.raw/*12.70*/("""
"""),format.raw/*15.2*/("""
"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.mainDashboard(title = "Listado Deuda Autorizado Distinto de Pagado", scripts)/*17.100*/ {_display_(Seq[Any](format.raw/*17.102*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Listado Control Moneda Extranjera</h1>
		</div>
		<div class="col-sm-3">
		</div>
	</div>
</div>

<div id="actions">
	<form action="" method="GET">
		<div class="row">
			 
				<div class="col-sm-2">
					<label class="control-label">Orden de Compras</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*35.8*/inputText(formBuscador("orden.nombre"),'class -> "form-control", 'id -> "orden"))),format.raw/*35.88*/("""
						"""),_display_(Seq[Any](/*36.8*/inputText(formBuscador("orden_id"),'hidden -> "hidden", 'id -> "orden_id"))),format.raw/*36.82*/("""
						
						<span class="input-group-addon"><a href="#" 
						id="searchOrden" 
						class="searchModal"
						data-title="Selección de orden" 
						data-url=""""),_display_(Seq[Any](/*42.18*/controllers/*42.29*/.compras.routes.OrdenesController.modalBuscar())),format.raw/*42.76*/("""" 
						data-height="650" data-width="700" 
						data-listen="modal.seleccion.orden.simple" 
						data-label="#orden" 
						data-field="#orden_id"><i class="glyphicon glyphicon-search"></i></a></span>
						
					</div>
				</div>
		</div>
			<div class="row">	
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*61.16*/controllers/*61.27*/.compras.routes.SolicitudesController.index())),format.raw/*61.72*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		
	</form>
</div>
"""),_display_(Seq[Any](/*69.2*/if(o.cot_dolar != null && o.tipo_moneda != null)/*69.50*/{_display_(Seq[Any](format.raw/*69.51*/("""
<div class="row">
	<div class="col-sm-6">	 
		<table class="table table-striped table-bordered" id="">
			<thead>
				<tr align="center">
					<th  colspan="5">ORDEN """),_display_(Seq[Any](/*75.30*/utils/*75.35*/.NumberUtils.moneda(o.cot_dolar))),format.raw/*75.67*/(""" - Ultima Cotizacion:"""),_display_(Seq[Any](/*75.89*/utils/*75.94*/.NumberUtils.moneda(ultimaCotizacion))),format.raw/*75.131*/("""</th>
				</tr>
				<tr>
					<th align="center">Monto Base</th>
					<!-- <th align="center">Ajuste Con Diferencia Cotizacion</th> -->
					<th align="center">Ajuste Sin Diferencia Cotizacion</th>
					<th align="center">Total Dolar</th>
				</tr>
			</thead>
			<tbody>
				 <tr>
	        		<td align="right">"""),_display_(Seq[Any](/*86.31*/utils/*86.36*/.NumberUtils.moneda(o.getTotal()))),format.raw/*86.69*/("""</td>
	        		<!-- <td align="right"></td> -->
					<td align="right">"""),_display_(Seq[Any](/*88.25*/utils/*88.30*/.NumberUtils.moneda(o.getTotalAjusteSinDiferenciaCotizacion()))),format.raw/*88.92*/("""</td>
					<td align="right">US"""),_display_(Seq[Any](/*89.27*/utils/*89.32*/.NumberUtils.moneda(o.getTotalDolarSinDiferenciaCotizacio()))),format.raw/*89.92*/("""</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-sm-6">	 
		"""),_display_(Seq[Any](/*95.4*/if(rowActas.size() > 0)/*95.27*/{_display_(Seq[Any](format.raw/*95.28*/("""
			"""),_display_(Seq[Any](/*96.5*/for(ac <- rowActas) yield /*96.24*/ {_display_(Seq[Any](format.raw/*96.26*/("""
				"""),_display_(Seq[Any](/*97.6*/{totalActa = totalActa.add(ac.getBigDecimal("total"))})),format.raw/*97.60*/("""
				"""),_display_(Seq[Any](/*98.6*/{totalActaDolar = totalActaDolar.add(ac.getBigDecimal("total_dolar"))})),format.raw/*98.76*/("""
			""")))})),format.raw/*99.5*/("""
		""")))})),format.raw/*100.4*/("""
		"""),_display_(Seq[Any](/*101.4*/if(rowActas.size() == 0 || ( o.monto_adelanto != null && o.monto_adelanto.compareTo(BigDecimal.ZERO) > 0 && o.monto_adelanto.compareTo(totalActa) > 0) )/*101.156*/{_display_(Seq[Any](format.raw/*101.157*/("""
			<table class="table table-striped table-bordered" id="">
				<thead>
					<tr align="center">
						<th  colspan="3">MONTO ADELANTO NO TIENE ACTAS - COTIZACION DE LA ORDEN:"""),_display_(Seq[Any](/*105.80*/utils/*105.85*/.NumberUtils.moneda(o.cot_dolar))),format.raw/*105.117*/("""</th>
					</tr>
					<tr>
						<th align="center">Monto</th>
						<th align="center">Total Dolar</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*113.7*/if(o.monto_adelanto != null && o.monto_adelanto.compareTo(BigDecimal.ZERO) > 0)/*113.86*/{_display_(Seq[Any](format.raw/*113.87*/("""
					<td align="right">"""),_display_(Seq[Any](/*114.25*/utils/*114.30*/.NumberUtils.moneda( o.monto_adelanto))),format.raw/*114.68*/("""</td>
			        <td align="right">US"""),_display_(Seq[Any](/*115.33*/utils/*115.38*/.NumberUtils.moneda(o.monto_adelanto.divide(o.cot_dolar, 2, java.math.RoundingMode.HALF_UP)))),format.raw/*115.130*/("""</td>
			        """)))})),format.raw/*116.13*/("""
				</tbody>
			</table>
			"""),_display_(Seq[Any](/*119.5*/{totalActa = BigDecimal.ZERO})),format.raw/*119.34*/("""
			"""),_display_(Seq[Any](/*120.5*/{totalActaDolar = BigDecimal.ZERO})),format.raw/*120.39*/("""
		""")))}/*121.4*/else/*121.8*/{_display_(Seq[Any](format.raw/*121.9*/("""
			"""),_display_(Seq[Any](/*122.5*/{totalActa = BigDecimal.ZERO})),format.raw/*122.34*/("""
			"""),_display_(Seq[Any](/*123.5*/{totalActaDolar = BigDecimal.ZERO})),format.raw/*123.39*/("""
			<table class="table table-striped table-bordered" id="">
				<thead>
					<tr align="center">
						<th  colspan="3">ACTAS """),_display_(Seq[Any](/*127.31*/utils/*127.36*/.NumberUtils.moneda(o.cot_dolar))),format.raw/*127.68*/("""</th>
					</tr>
					<tr>
						<th align="center">Monto</th>
						<th align="center">Cotizacion</th>
						<th align="center">Total Dolar</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*136.7*/for(ac <- rowActas) yield /*136.26*/ {_display_(Seq[Any](format.raw/*136.28*/("""
						<tr>
			        		<td align="right">"""),_display_(Seq[Any](/*138.33*/utils/*138.38*/.NumberUtils.moneda(ac.getBigDecimal("total")))),format.raw/*138.84*/("""</td>
			        		<td align="right"><!-- </a>"""),_display_(Seq[Any](/*139.42*/utils/*139.47*/.NumberUtils.moneda(ac.getBigDecimal("cotizacion")))),format.raw/*139.98*/(""" --></td>
			        		<td align="right">US"""),_display_(Seq[Any](/*140.35*/utils/*140.40*/.NumberUtils.moneda(ac.getBigDecimal("total_dolar")))),format.raw/*140.92*/("""</td>
			        		"""),_display_(Seq[Any](/*141.15*/{totalActa = totalActa.add(ac.getBigDecimal("total"))})),format.raw/*141.69*/("""
							"""),_display_(Seq[Any](/*142.9*/{totalActaDolar = totalActaDolar.add(ac.getBigDecimal("total_dolar"))})),format.raw/*142.79*/("""
							
						</tr>
					""")))})),format.raw/*145.7*/("""
				</tbody>
				<tfoot>
					<tr>
						<td align="right"><b>TOTAL:</b>"""),_display_(Seq[Any](/*149.39*/utils/*149.44*/.NumberUtils.moneda(totalActa))),format.raw/*149.74*/("""</td>
						<td align="right"></td>
						<td align="right"><b>TOTAL:</b>US"""),_display_(Seq[Any](/*151.41*/utils/*151.46*/.NumberUtils.moneda(totalActaDolar))),format.raw/*151.81*/("""</td>
					</tr>
				</tfoot>
			</table>
		""")))})),format.raw/*155.4*/("""
	</div>
	
</div>
<div class="row">
	
	<div class="col-sm-6">	 
		<table class="table table-striped table-bordered" id="">
			<thead>
				<tr align="center">
					<th  colspan="4">AUTORIZADOS</th>
				</tr>
				<tr>
					<th align="center">ID</th>
					<th align="center">Monto</th>
					<th align="center">Cotizacion</th>
					<th align="center">Total Dolar</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*175.6*/for(a <- al) yield /*175.18*/ {_display_(Seq[Any](format.raw/*175.20*/("""
		        	<tr>
		        		<td align="right">"""),_display_(Seq[Any](/*177.32*/a/*177.33*/.autorizado.nombre)),format.raw/*177.51*/("""</td>
						<td align="right">"""),_display_(Seq[Any](/*178.26*/utils/*178.31*/.NumberUtils.moneda(a.monto))),format.raw/*178.59*/("""</td>
						"""),_display_(Seq[Any](/*179.8*/if(a.cot_dolar != null)/*179.31*/{_display_(Seq[Any](format.raw/*179.32*/("""
							<td align="right">"""),_display_(Seq[Any](/*180.27*/utils/*180.32*/.NumberUtils.moneda(a.cot_dolar))),format.raw/*180.64*/("""</td>
						""")))}/*181.8*/else/*181.12*/{_display_(Seq[Any](format.raw/*181.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*183.8*/("""
						"""),_display_(Seq[Any](/*184.8*/if(a.monto != null && a.cot_dolar != null)/*184.50*/{_display_(Seq[Any](format.raw/*184.51*/("""
							<td align="right">US"""),_display_(Seq[Any](/*185.29*/utils/*185.34*/.NumberUtils.moneda(a.monto.divide(a.cot_dolar, 2, java.math.RoundingMode.HALF_UP)))),format.raw/*185.117*/("""</td>		
						""")))}/*186.8*/else/*186.12*/{_display_(Seq[Any](format.raw/*186.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*188.8*/("""
					</tr>
					"""),_display_(Seq[Any](/*190.7*/{totalAutorizado = totalAutorizado.add(a.monto)})),format.raw/*190.55*/("""
					"""),_display_(Seq[Any](/*191.7*/if(a.monto != null && a.cot_dolar != null)/*191.49*/{_display_(Seq[Any](format.raw/*191.50*/("""
						"""),_display_(Seq[Any](/*192.8*/{totalAutorizadoDolar = totalAutorizadoDolar.add(a.monto.divide(a.cot_dolar, 2, java.math.RoundingMode.HALF_UP)  )})),format.raw/*192.123*/("""
					""")))})),format.raw/*193.7*/("""
		        """)))})),format.raw/*194.12*/("""
		        """),_display_(Seq[Any](/*195.12*/if(alHijo.size() > 0)/*195.33*/{_display_(Seq[Any](format.raw/*195.34*/("""
		        	<tr align="center">
						<th  colspan="3">HIJA</th>
					</tr>
		        """)))})),format.raw/*199.12*/("""
		        
		        """),_display_(Seq[Any](/*201.12*/for(ahh <- alHijo) yield /*201.30*/ {_display_(Seq[Any](format.raw/*201.32*/("""
		        	<tr>
		        		<td align="right">"""),_display_(Seq[Any](/*203.32*/ahh/*203.35*/.autorizado.nombre)),format.raw/*203.53*/("""</td>
						<td align="right">"""),_display_(Seq[Any](/*204.26*/utils/*204.31*/.NumberUtils.moneda(ahh.monto))),format.raw/*204.61*/("""</td>
						"""),_display_(Seq[Any](/*205.8*/if(ahh.cot_dolar != null)/*205.33*/{_display_(Seq[Any](format.raw/*205.34*/("""
							<td align="right">"""),_display_(Seq[Any](/*206.27*/utils/*206.32*/.NumberUtils.moneda(ahh.cot_dolar))),format.raw/*206.66*/("""</td>
						""")))}/*207.8*/else/*207.12*/{_display_(Seq[Any](format.raw/*207.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*209.8*/("""
						"""),_display_(Seq[Any](/*210.8*/if(ahh.monto != null && ahh.cot_dolar != null)/*210.54*/{_display_(Seq[Any](format.raw/*210.55*/("""
							<td align="right">US"""),_display_(Seq[Any](/*211.29*/utils/*211.34*/.NumberUtils.moneda(ahh.monto.divide(ahh.cot_dolar, 2, java.math.RoundingMode.HALF_UP)))),format.raw/*211.121*/("""</td>		
						""")))}/*212.8*/else/*212.12*/{_display_(Seq[Any](format.raw/*212.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*214.8*/("""
					</tr>
					"""),_display_(Seq[Any](/*216.7*/{totalAutorizado = totalAutorizado.add(ahh.monto)})),format.raw/*216.57*/("""
					"""),_display_(Seq[Any](/*217.7*/if(ahh.monto != null && ahh.cot_dolar != null)/*217.53*/{_display_(Seq[Any](format.raw/*217.54*/("""
						"""),_display_(Seq[Any](/*218.8*/{totalAutorizadoDolar = totalAutorizadoDolar.add(ahh.monto.divide(ahh.cot_dolar, 2, java.math.RoundingMode.HALF_UP)  )})),format.raw/*218.127*/("""
					""")))})),format.raw/*219.7*/("""
		        """)))})),format.raw/*220.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td align="right"><b>TOTAL:</b>"""),_display_(Seq[Any](/*225.38*/utils/*225.43*/.NumberUtils.moneda(totalAutorizado))),format.raw/*225.79*/("""</td>
					<td></td>				
					<td align="right"><b>TOTAL:</b>US"""),_display_(Seq[Any](/*227.40*/utils/*227.45*/.NumberUtils.moneda(totalAutorizadoDolar))),format.raw/*227.86*/("""</td>
				</tr>
			</tfoot>
		</table>
	</div>	 

	<div class="col-sm-6">	 
		<table class="table table-striped table-bordered" id="">
			<thead>
				<tr align="center">
					<th  colspan="3">FACTURAS</th>
				</tr>
				<tr>
					<th align="center">Monto</th>
					<th align="center">Cotizacion</th>
					<th align="center">Total Dolar</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*246.6*/for(fx <- f) yield /*246.18*/ {_display_(Seq[Any](format.raw/*246.20*/("""
		        	<tr>
						<td align="right">"""),_display_(Seq[Any](/*248.26*/utils/*248.31*/.NumberUtils.moneda(fx.getBase()))),format.raw/*248.64*/("""</td>
						"""),_display_(Seq[Any](/*249.8*/if(fx.cot_dolar != null)/*249.32*/{_display_(Seq[Any](format.raw/*249.33*/("""	
							<td align="right">"""),_display_(Seq[Any](/*250.27*/utils/*250.32*/.NumberUtils.moneda(fx.cot_dolar))),format.raw/*250.65*/("""</td>	
						""")))}/*251.8*/else/*251.12*/{_display_(Seq[Any](format.raw/*251.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*253.8*/("""
						
						"""),_display_(Seq[Any](/*255.8*/if(fx.getBase() != null && fx.cot_dolar != null)/*255.56*/{_display_(Seq[Any](format.raw/*255.57*/("""		
							<td align="right">US"""),_display_(Seq[Any](/*256.29*/utils/*256.34*/.NumberUtils.moneda(fx.getBase().divide(fx.cot_dolar, 2, java.math.RoundingMode.HALF_UP)))),format.raw/*256.123*/("""</td>	
						""")))}/*257.8*/else/*257.12*/{_display_(Seq[Any](format.raw/*257.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*259.8*/("""
					</tr>
					"""),_display_(Seq[Any](/*261.7*/{totalFactura = totalFactura.add(fx.getBase())})),format.raw/*261.54*/("""
					"""),_display_(Seq[Any](/*262.7*/if(fx.getBase() != null && fx.cot_dolar != null)/*262.55*/{_display_(Seq[Any](format.raw/*262.56*/("""		
						"""),_display_(Seq[Any](/*263.8*/{totalFacturaDolar = totalFacturaDolar.add(fx.getBase().divide(fx.cot_dolar, 2, java.math.RoundingMode.HALF_UP))})),format.raw/*263.121*/("""
					""")))})),format.raw/*264.7*/("""
					
		        """)))})),format.raw/*266.12*/("""
		        """),_display_(Seq[Any](/*267.12*/if(fh.size() > 0)/*267.29*/{_display_(Seq[Any](format.raw/*267.30*/("""
		        	<tr align="center">
						<th  colspan="3">HIJA</th>
					</tr>
		        """)))})),format.raw/*271.12*/("""
		        """),_display_(Seq[Any](/*272.12*/for(fhh <- fh) yield /*272.26*/ {_display_(Seq[Any](format.raw/*272.28*/("""
		        	<tr>
						<td align="right" >"""),_display_(Seq[Any](/*274.27*/utils/*274.32*/.NumberUtils.moneda(fhh.getBase()))),format.raw/*274.66*/("""</td>
						"""),_display_(Seq[Any](/*275.8*/if(fhh.cot_dolar != null)/*275.33*/{_display_(Seq[Any](format.raw/*275.34*/("""	
							<td align="right">"""),_display_(Seq[Any](/*276.27*/utils/*276.32*/.NumberUtils.moneda(fhh.cot_dolar))),format.raw/*276.66*/("""</td>	
						""")))}/*277.8*/else/*277.12*/{_display_(Seq[Any](format.raw/*277.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*279.8*/("""
						
						"""),_display_(Seq[Any](/*281.8*/if(fhh.getBase() != null && fhh.cot_dolar != null)/*281.58*/{_display_(Seq[Any](format.raw/*281.59*/("""		
							<td align="right">US"""),_display_(Seq[Any](/*282.29*/utils/*282.34*/.NumberUtils.moneda(fhh.getBase().divide(fhh.cot_dolar, 2, java.math.RoundingMode.HALF_UP)))),format.raw/*282.125*/("""</td>	
						""")))}/*283.8*/else/*283.12*/{_display_(Seq[Any](format.raw/*283.13*/("""
							<td align="right">NO TIENE COTIZACION</td>
						""")))})),format.raw/*285.8*/("""
					</tr>
					"""),_display_(Seq[Any](/*287.7*/{totalFactura = totalFactura.add(fhh.getBase())})),format.raw/*287.55*/("""
					"""),_display_(Seq[Any](/*288.7*/if(fhh.getBase() != null && fhh.cot_dolar != null)/*288.57*/{_display_(Seq[Any](format.raw/*288.58*/("""		
						"""),_display_(Seq[Any](/*289.8*/{totalFacturaDolar = totalFacturaDolar.add(fhh.getBase().divide(fhh.cot_dolar, 2, java.math.RoundingMode.HALF_UP))})),format.raw/*289.123*/("""
					""")))})),format.raw/*290.7*/("""
					
		        """)))})),format.raw/*292.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td align="right"><b>TOTAL:</b>"""),_display_(Seq[Any](/*296.38*/utils/*296.43*/.NumberUtils.moneda(totalFactura))),format.raw/*296.76*/("""</td>
					<td></td>				
					<td align="right"><b>TOTAL:</b>US"""),_display_(Seq[Any](/*298.40*/utils/*298.45*/.NumberUtils.moneda(totalFacturaDolar))),format.raw/*298.83*/("""</td>
				</tr>
			</tfoot>
		</table>
	</div>	 
</div>
<div class="row">
	<div class="col-sm-6">	 
		<table class="table table-striped table-bordered" id="">
			<thead>
				<tr align="center">
					<th>DEUDA DOLAR</th>
					<th>DEUDA PESOS</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					"""),_display_(Seq[Any](/*315.7*/if(totalActaDolar.compareTo(BigDecimal.ZERO) == 0 && o.monto_adelanto != null)/*315.85*/{_display_(Seq[Any](format.raw/*315.86*/("""
						"""),_display_(Seq[Any](/*316.8*/{totalActaDolar = o.monto_adelanto.divide(o.cot_dolar, 2, java.math.RoundingMode.HALF_UP);})),format.raw/*316.99*/("""
					""")))})),format.raw/*317.7*/("""
				
					"""),_display_(Seq[Any](/*319.7*/if(totalAutorizadoDolar.compareTo(totalFacturaDolar) >= 0)/*319.65*/{_display_(Seq[Any](format.raw/*319.66*/("""
						"""),_display_(Seq[Any](/*320.8*/{totalDeuda = totalActaDolar.subtract(totalAutorizadoDolar).multiply(ultimaCotizacion)})),format.raw/*320.95*/("""
						"""),_display_(Seq[Any](/*321.8*/{totalDeudaDolar = totalActaDolar.subtract(totalAutorizadoDolar)})),format.raw/*321.73*/("""
						
					""")))}/*323.7*/else/*323.11*/{_display_(Seq[Any](format.raw/*323.12*/("""
						"""),_display_(Seq[Any](/*324.8*/{totalDeuda = totalActaDolar.subtract(totalFacturaDolar).multiply(ultimaCotizacion)})),format.raw/*324.92*/("""
						"""),_display_(Seq[Any](/*325.8*/{totalDeudaDolar = totalActaDolar.subtract(totalFacturaDolar)})),format.raw/*325.70*/("""
					""")))})),format.raw/*326.7*/("""
					<td align="right">
	        			US"""),_display_(Seq[Any](/*328.16*/utils/*328.21*/.NumberUtils.moneda(totalDeudaDolar))),format.raw/*328.57*/(""" <br> 
	        		</td>
	        		<td align="right">
	        		
	        			"""),_display_(Seq[Any](/*332.14*/utils/*332.19*/.NumberUtils.moneda(totalDeuda))),format.raw/*332.50*/("""<br> 
	        		</td>
	        	</tr>
				
			</tbody>
		</table>
	</div>
</div>	
""")))}/*340.2*/else/*340.6*/{_display_(Seq[Any](format.raw/*340.7*/("""
<div class="row">
	<div class="col-sm-4">
		<p>NO ES UN EXPEDIENTE EN MONEDA EXTRAJERA.</p>
	</div>	 
</div>

""")))})),format.raw/*347.2*/("""
""")))})))}
    }
    
    def render(r:List[models.informes.InformeDeudaProveedoresMaterializada],al:List[models.AutorizadoLinea],f:List[models.Factura],o:Orden,rowActas:List[com.avaje.ebean.SqlRow],ultimaCotizacion:java.math.BigDecimal,formBuscador:DynamicForm,fh:List[models.Factura],alHijo:List[models.AutorizadoLinea]): play.api.templates.HtmlFormat.Appendable = apply(r,al,f,o,rowActas,ultimaCotizacion,formBuscador,fh,alHijo)
    
    def f:((List[models.informes.InformeDeudaProveedoresMaterializada],List[models.AutorizadoLinea],List[models.Factura],Orden,List[com.avaje.ebean.SqlRow],java.math.BigDecimal,DynamicForm,List[models.Factura],List[models.AutorizadoLinea]) => play.api.templates.HtmlFormat.Appendable) = (r,al,f,o,rowActas,ultimaCotizacion,formBuscador,fh,alHijo) => apply(r,al,f,o,rowActas,ultimaCotizacion,formBuscador,fh,alHijo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/controlDeuda/controlDeudaMonedaExtranjera.scala.html
                    HASH: 3452bc42bc837b10bea2abbab5852c9da2a621cb
                    MATRIX: 1040->1|1872->422|1887->429|1972->433|2024->449|2039->455|2110->504|2178->352|2211->376|2285->295|2314->420|2342->540|2379->948|2392->953|2495->1046|2536->1048|2947->1424|3049->1504|3092->1512|3188->1586|3389->1751|3409->1762|3478->1809|4123->2418|4143->2429|4210->2474|4355->2584|4412->2632|4451->2633|4655->2801|4669->2806|4723->2838|4781->2860|4795->2865|4855->2902|5203->3214|5217->3219|5272->3252|5382->3326|5396->3331|5480->3393|5548->3425|5562->3430|5644->3490|5755->3566|5787->3589|5826->3590|5866->3595|5901->3614|5941->3616|5982->3622|6058->3676|6099->3682|6191->3752|6227->3757|6263->3761|6303->3765|6466->3917|6507->3918|6721->4095|6736->4100|6792->4132|6975->4279|7064->4358|7104->4359|7166->4384|7181->4389|7242->4427|7317->4465|7332->4470|7448->4562|7499->4580|7565->4610|7617->4639|7658->4644|7715->4678|7738->4682|7751->4686|7790->4687|7831->4692|7883->4721|7924->4726|7981->4760|8146->4888|8161->4893|8216->4925|8440->5113|8476->5132|8517->5134|8598->5178|8613->5183|8682->5229|8766->5276|8781->5281|8855->5332|8936->5376|8951->5381|9026->5433|9083->5453|9160->5507|9205->5516|9298->5586|9357->5613|9468->5687|9483->5692|9536->5722|9649->5798|9664->5803|9722->5838|9799->5883|10237->6285|10266->6297|10307->6299|10392->6347|10403->6348|10444->6366|10512->6397|10527->6402|10578->6430|10627->6443|10660->6466|10700->6467|10764->6494|10779->6499|10834->6531|10866->6544|10880->6548|10920->6549|11010->6607|11054->6615|11106->6657|11146->6658|11212->6687|11227->6692|11334->6775|11368->6790|11382->6794|11422->6795|11512->6853|11566->6871|11637->6919|11680->6926|11732->6968|11772->6969|11816->6977|11955->7092|11994->7099|12039->7111|12088->7123|12119->7144|12159->7145|12279->7232|12339->7255|12374->7273|12415->7275|12500->7323|12513->7326|12554->7344|12622->7375|12637->7380|12690->7410|12739->7423|12774->7448|12814->7449|12878->7476|12893->7481|12950->7515|12982->7528|12996->7532|13036->7533|13126->7591|13170->7599|13226->7645|13266->7646|13332->7675|13347->7680|13458->7767|13492->7782|13506->7786|13546->7787|13636->7845|13690->7863|13763->7913|13806->7920|13862->7966|13902->7967|13946->7975|14089->8094|14128->8101|14173->8113|14295->8198|14310->8203|14369->8239|14470->8303|14485->8308|14549->8349|14964->8728|14993->8740|15034->8742|15113->8784|15128->8789|15184->8822|15233->8835|15267->8859|15307->8860|15372->8888|15387->8893|15443->8926|15476->8940|15490->8944|15530->8945|15620->9003|15671->9018|15729->9066|15769->9067|15837->9098|15852->9103|15965->9192|15998->9206|16012->9210|16052->9211|16142->9269|16196->9287|16266->9334|16309->9341|16367->9389|16407->9390|16453->9400|16590->9513|16629->9520|16680->9538|16729->9550|16756->9567|16796->9568|16916->9655|16965->9667|16996->9681|17037->9683|17117->9726|17132->9731|17189->9765|17238->9778|17273->9803|17313->9804|17378->9832|17393->9837|17450->9871|17483->9885|17497->9889|17537->9890|17627->9948|17678->9963|17738->10013|17778->10014|17846->10045|17861->10050|17976->10141|18009->10155|18023->10159|18063->10160|18153->10218|18207->10236|18278->10284|18321->10291|18381->10341|18421->10342|18467->10352|18606->10467|18645->10474|18696->10492|18803->10562|18818->10567|18874->10600|18975->10664|18990->10669|19051->10707|19381->11001|19469->11079|19509->11080|19553->11088|19667->11179|19706->11186|19754->11198|19822->11256|19862->11257|19906->11265|20016->11352|20060->11360|20148->11425|20181->11439|20195->11443|20235->11444|20279->11452|20386->11536|20430->11544|20515->11606|20554->11613|20631->11653|20646->11658|20705->11694|20821->11773|20836->11778|20890->11809|20993->11893|21006->11897|21045->11898|21189->12010
                    LINES: 26->1|42->13|42->13|44->13|45->14|45->14|45->14|46->12|46->12|47->8|48->12|49->15|50->17|50->17|50->17|50->17|68->35|68->35|69->36|69->36|75->42|75->42|75->42|94->61|94->61|94->61|102->69|102->69|102->69|108->75|108->75|108->75|108->75|108->75|108->75|119->86|119->86|119->86|121->88|121->88|121->88|122->89|122->89|122->89|128->95|128->95|128->95|129->96|129->96|129->96|130->97|130->97|131->98|131->98|132->99|133->100|134->101|134->101|134->101|138->105|138->105|138->105|146->113|146->113|146->113|147->114|147->114|147->114|148->115|148->115|148->115|149->116|152->119|152->119|153->120|153->120|154->121|154->121|154->121|155->122|155->122|156->123|156->123|160->127|160->127|160->127|169->136|169->136|169->136|171->138|171->138|171->138|172->139|172->139|172->139|173->140|173->140|173->140|174->141|174->141|175->142|175->142|178->145|182->149|182->149|182->149|184->151|184->151|184->151|188->155|208->175|208->175|208->175|210->177|210->177|210->177|211->178|211->178|211->178|212->179|212->179|212->179|213->180|213->180|213->180|214->181|214->181|214->181|216->183|217->184|217->184|217->184|218->185|218->185|218->185|219->186|219->186|219->186|221->188|223->190|223->190|224->191|224->191|224->191|225->192|225->192|226->193|227->194|228->195|228->195|228->195|232->199|234->201|234->201|234->201|236->203|236->203|236->203|237->204|237->204|237->204|238->205|238->205|238->205|239->206|239->206|239->206|240->207|240->207|240->207|242->209|243->210|243->210|243->210|244->211|244->211|244->211|245->212|245->212|245->212|247->214|249->216|249->216|250->217|250->217|250->217|251->218|251->218|252->219|253->220|258->225|258->225|258->225|260->227|260->227|260->227|279->246|279->246|279->246|281->248|281->248|281->248|282->249|282->249|282->249|283->250|283->250|283->250|284->251|284->251|284->251|286->253|288->255|288->255|288->255|289->256|289->256|289->256|290->257|290->257|290->257|292->259|294->261|294->261|295->262|295->262|295->262|296->263|296->263|297->264|299->266|300->267|300->267|300->267|304->271|305->272|305->272|305->272|307->274|307->274|307->274|308->275|308->275|308->275|309->276|309->276|309->276|310->277|310->277|310->277|312->279|314->281|314->281|314->281|315->282|315->282|315->282|316->283|316->283|316->283|318->285|320->287|320->287|321->288|321->288|321->288|322->289|322->289|323->290|325->292|329->296|329->296|329->296|331->298|331->298|331->298|348->315|348->315|348->315|349->316|349->316|350->317|352->319|352->319|352->319|353->320|353->320|354->321|354->321|356->323|356->323|356->323|357->324|357->324|358->325|358->325|359->326|361->328|361->328|361->328|365->332|365->332|365->332|373->340|373->340|373->340|380->347
                    -- GENERATED --
                */
            