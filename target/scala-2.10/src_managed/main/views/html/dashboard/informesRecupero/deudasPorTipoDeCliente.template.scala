
package views.html.dashboard.informesRecupero

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
object deudasPorTipoDeCliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Long,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idTipoCliente:Long,
deudasPorPaciente:List[com.avaje.ebean.SqlRow],
deudasPorExtrajero:List[com.avaje.ebean.SqlRow],
deudasPorObrasSociales:List[com.avaje.ebean.SqlRow],
deudasPorArt:List[com.avaje.ebean.SqlRow],
deudasPorSeguro:List[com.avaje.ebean.SqlRow]
):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var ptfactura=new java.math.BigDecimal(0);var ptpago=new java.math.BigDecimal(0);var ptdeuda=new java.math.BigDecimal(0);var mtfactura=new java.math.BigDecimal(0);var mtpago=new java.math.BigDecimal(0);var mtdeuda=new java.math.BigDecimal(0);

import java.lang.Integer;var clienteId =0;var bandera =0

import java.lang.String;var clienteNombre =""

implicit def /*11.2*/implicitFieldConstructor/*11.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*7.2*/("""
"""),format.raw/*11.70*/("""
"""),format.raw/*15.1*/("""
"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.dashboard.mainDashboard("Deudas Recupero")/*16.55*/ {_display_(Seq[Any](format.raw/*16.57*/("""				
						
 

"""),_display_(Seq[Any](/*20.2*/views/*20.7*/.html.dashboard.informesRecupero.navinformes())),format.raw/*20.53*/("""
				

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
				  <a id="" role="menuitem" tabindex="-1" 
				  href=""""),_display_(Seq[Any](/*38.14*/controllers/*38.25*/.dashboard.routes.InformesRecuperoReportesController.deudasPorTipoDeCliente(idTipoCliente))),format.raw/*38.115*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*45.2*/if(deudasPorPaciente.size() >0)/*45.33*/{_display_(Seq[Any](format.raw/*45.34*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*49.5*/views/*49.10*/.html.dashboard.informesRecupero.tablaDetalleDeudas("Pacientes"))),format.raw/*49.74*/("""
			<tbody>
				"""),_display_(Seq[Any](/*51.6*/for(s <- deudasPorPaciente) yield /*51.33*/{_display_(Seq[Any](format.raw/*51.34*/("""
					
					"""),_display_(Seq[Any](/*53.7*/{ptfactura = ptfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*53.68*/("""
					"""),_display_(Seq[Any](/*54.7*/{ptpago = ptpago.add(s.getBigDecimal("total_pago"))})),format.raw/*54.59*/("""
					"""),_display_(Seq[Any](/*55.7*/{ptdeuda = ptdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*55.62*/("""
					 
					 <tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*58.12*/s/*58.13*/.getString("cliente_nombre"))),format.raw/*58.41*/("""</td>
						<td>"""),_display_(Seq[Any](/*59.12*/utils/*59.17*/.NumberUtils.moneda(s.getBigDecimal("total_factura")))),format.raw/*59.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*60.12*/utils/*60.17*/.NumberUtils.moneda(s.getBigDecimal("total_pago")))),format.raw/*60.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*61.12*/utils/*61.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*61.68*/("""</td>
					</tr> 
					
					
					"""),_display_(Seq[Any](/*65.7*/{mtfactura= mtfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*65.67*/("""
					"""),_display_(Seq[Any](/*66.7*/{mtpago= mtpago.add(s.getBigDecimal("total_pago"))})),format.raw/*66.58*/("""
					"""),_display_(Seq[Any](/*67.7*/{mtdeuda= mtdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*67.61*/("""
					"""),_display_(Seq[Any](/*68.7*/{clienteId = s.getInteger("cliente_id")})),format.raw/*68.47*/("""
					"""),_display_(Seq[Any](/*69.7*/{clienteNombre = s.getString("cliente_nombre")})),format.raw/*69.54*/("""
				""")))})),format.raw/*70.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*75.14*/utils/*75.19*/.NumberUtils.moneda(ptfactura))),format.raw/*75.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*76.14*/utils/*76.19*/.NumberUtils.moneda(ptpago))),format.raw/*76.46*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*77.14*/utils/*77.19*/.NumberUtils.moneda(ptdeuda))),format.raw/*77.47*/("""</b></td>
				</tr>
			</tfoot>
		</table>			
	</div>
</div>	
""")))})),format.raw/*83.2*/("""

"""),_display_(Seq[Any](/*85.2*/if(deudasPorExtrajero.size() >0)/*85.34*/{_display_(Seq[Any](format.raw/*85.35*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*89.5*/views/*89.10*/.html.dashboard.informesRecupero.tablaDetalleDeudas("Extranjeros"))),format.raw/*89.76*/("""
			<tbody>
				"""),_display_(Seq[Any](/*91.6*/{ptfactura = new java.math.BigDecimal(0)})),format.raw/*91.47*/("""
				"""),_display_(Seq[Any](/*92.6*/{ptpago = new java.math.BigDecimal(0)})),format.raw/*92.44*/("""
				"""),_display_(Seq[Any](/*93.6*/{ptdeuda = new java.math.BigDecimal(0)})),format.raw/*93.45*/("""
				"""),_display_(Seq[Any](/*94.6*/for(s <- deudasPorExtrajero) yield /*94.34*/{_display_(Seq[Any](format.raw/*94.35*/("""
					
					"""),_display_(Seq[Any](/*96.7*/{ptfactura = ptfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*96.68*/("""
					"""),_display_(Seq[Any](/*97.7*/{ptpago = ptpago.add(s.getBigDecimal("total_pago"))})),format.raw/*97.59*/("""
					"""),_display_(Seq[Any](/*98.7*/{ptdeuda = ptdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*98.62*/("""
					 
					 <tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*101.12*/s/*101.13*/.getString("cliente_nombre"))),format.raw/*101.41*/("""</td>
						<td>"""),_display_(Seq[Any](/*102.12*/utils/*102.17*/.NumberUtils.moneda(s.getBigDecimal("total_factura")))),format.raw/*102.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*103.12*/utils/*103.17*/.NumberUtils.moneda(s.getBigDecimal("total_pago")))),format.raw/*103.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*104.12*/utils/*104.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*104.68*/("""</td>
					</tr> 
					
					
					"""),_display_(Seq[Any](/*108.7*/{mtfactura= mtfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*108.67*/("""
					"""),_display_(Seq[Any](/*109.7*/{mtpago= mtpago.add(s.getBigDecimal("total_pago"))})),format.raw/*109.58*/("""
					"""),_display_(Seq[Any](/*110.7*/{mtdeuda= mtdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*110.61*/("""
					"""),_display_(Seq[Any](/*111.7*/{clienteId = s.getInteger("cliente_id")})),format.raw/*111.47*/("""
					"""),_display_(Seq[Any](/*112.7*/{clienteNombre = s.getString("cliente_nombre")})),format.raw/*112.54*/("""
				""")))})),format.raw/*113.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*118.14*/utils/*118.19*/.NumberUtils.moneda(ptfactura))),format.raw/*118.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*119.14*/utils/*119.19*/.NumberUtils.moneda(ptpago))),format.raw/*119.46*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*120.14*/utils/*120.19*/.NumberUtils.moneda(ptdeuda))),format.raw/*120.47*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>	
""")))})),format.raw/*126.2*/("""

"""),_display_(Seq[Any](/*128.2*/if(deudasPorObrasSociales.size() >0)/*128.38*/{_display_(Seq[Any](format.raw/*128.39*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*132.5*/views/*132.10*/.html.dashboard.informesRecupero.tablaDetalleDeudas("Obras Sociales"))),format.raw/*132.79*/("""
			<tbody>
				"""),_display_(Seq[Any](/*134.6*/{ptfactura = new java.math.BigDecimal(0)})),format.raw/*134.47*/("""
				"""),_display_(Seq[Any](/*135.6*/{ptpago = new java.math.BigDecimal(0)})),format.raw/*135.44*/("""
				"""),_display_(Seq[Any](/*136.6*/{ptdeuda = new java.math.BigDecimal(0)})),format.raw/*136.45*/("""
				"""),_display_(Seq[Any](/*137.6*/for(s <- deudasPorObrasSociales) yield /*137.38*/{_display_(Seq[Any](format.raw/*137.39*/("""
					
					"""),_display_(Seq[Any](/*139.7*/{ptfactura = ptfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*139.68*/("""
					"""),_display_(Seq[Any](/*140.7*/{ptpago = ptpago.add(s.getBigDecimal("total_pago"))})),format.raw/*140.59*/("""
					"""),_display_(Seq[Any](/*141.7*/{ptdeuda = ptdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*141.62*/("""
					 
					 <tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*144.12*/s/*144.13*/.getString("cliente_nombre"))),format.raw/*144.41*/("""</td>
						<td>"""),_display_(Seq[Any](/*145.12*/utils/*145.17*/.NumberUtils.moneda(s.getBigDecimal("total_factura")))),format.raw/*145.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*146.12*/utils/*146.17*/.NumberUtils.moneda(s.getBigDecimal("total_pago")))),format.raw/*146.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*147.12*/utils/*147.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*147.68*/("""</td>
					</tr> 
					
					
					"""),_display_(Seq[Any](/*151.7*/{mtfactura= mtfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*151.67*/("""
					"""),_display_(Seq[Any](/*152.7*/{mtpago= mtpago.add(s.getBigDecimal("total_pago"))})),format.raw/*152.58*/("""
					"""),_display_(Seq[Any](/*153.7*/{mtdeuda= mtdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*153.61*/("""
					"""),_display_(Seq[Any](/*154.7*/{clienteId = s.getInteger("cliente_id")})),format.raw/*154.47*/("""
					"""),_display_(Seq[Any](/*155.7*/{clienteNombre = s.getString("cliente_nombre")})),format.raw/*155.54*/("""
				""")))})),format.raw/*156.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*161.14*/utils/*161.19*/.NumberUtils.moneda(ptfactura))),format.raw/*161.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*162.14*/utils/*162.19*/.NumberUtils.moneda(ptpago))),format.raw/*162.46*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*163.14*/utils/*163.19*/.NumberUtils.moneda(ptdeuda))),format.raw/*163.47*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>	
""")))})),format.raw/*169.2*/("""

"""),_display_(Seq[Any](/*171.2*/if(deudasPorSeguro.size() >0)/*171.31*/{_display_(Seq[Any](format.raw/*171.32*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*175.5*/views/*175.10*/.html.dashboard.informesRecupero.tablaDetalleDeudas("SEGUROS"))),format.raw/*175.72*/("""
			<tbody>
				"""),_display_(Seq[Any](/*177.6*/{ptfactura = new java.math.BigDecimal(0)})),format.raw/*177.47*/("""
				"""),_display_(Seq[Any](/*178.6*/{ptpago = new java.math.BigDecimal(0)})),format.raw/*178.44*/("""
				"""),_display_(Seq[Any](/*179.6*/{ptdeuda = new java.math.BigDecimal(0)})),format.raw/*179.45*/("""
				"""),_display_(Seq[Any](/*180.6*/for(s <- deudasPorSeguro) yield /*180.31*/{_display_(Seq[Any](format.raw/*180.32*/("""
					
					"""),_display_(Seq[Any](/*182.7*/{ptfactura = ptfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*182.68*/("""
					"""),_display_(Seq[Any](/*183.7*/{ptpago = ptpago.add(s.getBigDecimal("total_pago"))})),format.raw/*183.59*/("""
					"""),_display_(Seq[Any](/*184.7*/{ptdeuda = ptdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*184.62*/("""
					 
					 <tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*187.12*/s/*187.13*/.getString("cliente_nombre"))),format.raw/*187.41*/("""</td>
						<td>"""),_display_(Seq[Any](/*188.12*/utils/*188.17*/.NumberUtils.moneda(s.getBigDecimal("total_factura")))),format.raw/*188.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*189.12*/utils/*189.17*/.NumberUtils.moneda(s.getBigDecimal("total_pago")))),format.raw/*189.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*190.12*/utils/*190.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*190.68*/("""</td>
					</tr> 
					
					
					"""),_display_(Seq[Any](/*194.7*/{mtfactura= mtfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*194.67*/("""
					"""),_display_(Seq[Any](/*195.7*/{mtpago= mtpago.add(s.getBigDecimal("total_pago"))})),format.raw/*195.58*/("""
					"""),_display_(Seq[Any](/*196.7*/{mtdeuda= mtdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*196.61*/("""
					"""),_display_(Seq[Any](/*197.7*/{clienteId = s.getInteger("cliente_id")})),format.raw/*197.47*/("""
					"""),_display_(Seq[Any](/*198.7*/{clienteNombre = s.getString("cliente_nombre")})),format.raw/*198.54*/("""
				""")))})),format.raw/*199.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*204.14*/utils/*204.19*/.NumberUtils.moneda(ptfactura))),format.raw/*204.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*205.14*/utils/*205.19*/.NumberUtils.moneda(ptpago))),format.raw/*205.46*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*206.14*/utils/*206.19*/.NumberUtils.moneda(ptdeuda))),format.raw/*206.47*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

""")))})),format.raw/*213.2*/("""

"""),_display_(Seq[Any](/*215.2*/if(deudasPorArt.size() >0)/*215.28*/{_display_(Seq[Any](format.raw/*215.29*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*219.5*/views/*219.10*/.html.dashboard.informesRecupero.tablaDetalleDeudas("ART"))),format.raw/*219.68*/("""
			<tbody>
				"""),_display_(Seq[Any](/*221.6*/{ptfactura = new java.math.BigDecimal(0)})),format.raw/*221.47*/("""
				"""),_display_(Seq[Any](/*222.6*/{ptpago = new java.math.BigDecimal(0)})),format.raw/*222.44*/("""
				"""),_display_(Seq[Any](/*223.6*/{ptdeuda = new java.math.BigDecimal(0)})),format.raw/*223.45*/("""
				"""),_display_(Seq[Any](/*224.6*/for(s <- deudasPorArt) yield /*224.28*/{_display_(Seq[Any](format.raw/*224.29*/("""
					
					"""),_display_(Seq[Any](/*226.7*/{ptfactura = ptfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*226.68*/("""
					"""),_display_(Seq[Any](/*227.7*/{ptpago = ptpago.add(s.getBigDecimal("total_pago"))})),format.raw/*227.59*/("""
					"""),_display_(Seq[Any](/*228.7*/{ptdeuda = ptdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*228.62*/("""
					 
					 <tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*231.12*/s/*231.13*/.getString("cliente_nombre"))),format.raw/*231.41*/("""</td>
						<td>"""),_display_(Seq[Any](/*232.12*/utils/*232.17*/.NumberUtils.moneda(s.getBigDecimal("total_factura")))),format.raw/*232.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*233.12*/utils/*233.17*/.NumberUtils.moneda(s.getBigDecimal("total_pago")))),format.raw/*233.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*234.12*/utils/*234.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*234.68*/("""</td>
					</tr> 
					
					
					"""),_display_(Seq[Any](/*238.7*/{mtfactura= mtfactura.add(s.getBigDecimal("total_factura"))})),format.raw/*238.67*/("""
					"""),_display_(Seq[Any](/*239.7*/{mtpago= mtpago.add(s.getBigDecimal("total_pago"))})),format.raw/*239.58*/("""
					"""),_display_(Seq[Any](/*240.7*/{mtdeuda= mtdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*240.61*/("""
					"""),_display_(Seq[Any](/*241.7*/{clienteId = s.getInteger("cliente_id")})),format.raw/*241.47*/("""
					"""),_display_(Seq[Any](/*242.7*/{clienteNombre = s.getString("cliente_nombre")})),format.raw/*242.54*/("""
				""")))})),format.raw/*243.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*248.14*/utils/*248.19*/.NumberUtils.moneda(ptfactura))),format.raw/*248.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*249.14*/utils/*249.19*/.NumberUtils.moneda(ptpago))),format.raw/*249.46*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*250.14*/utils/*250.19*/.NumberUtils.moneda(ptdeuda))),format.raw/*250.47*/("""</b></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>	
""")))})),format.raw/*256.2*/("""

""")))})))}
    }
    
    def render(idTipoCliente:Long,deudasPorPaciente:List[com.avaje.ebean.SqlRow],deudasPorExtrajero:List[com.avaje.ebean.SqlRow],deudasPorObrasSociales:List[com.avaje.ebean.SqlRow],deudasPorArt:List[com.avaje.ebean.SqlRow],deudasPorSeguro:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(idTipoCliente,deudasPorPaciente,deudasPorExtrajero,deudasPorObrasSociales,deudasPorArt,deudasPorSeguro)
    
    def f:((Long,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (idTipoCliente,deudasPorPaciente,deudasPorExtrajero,deudasPorObrasSociales,deudasPorArt,deudasPorSeguro) => apply(idTipoCliente,deudasPorPaciente,deudasPorExtrajero,deudasPorObrasSociales,deudasPorArt,deudasPorSeguro)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informesRecupero/deudasPorTipoDeCliente.scala.html
                    HASH: 3d2f7d27e8efc476d6aa6ba1a3896afaa31f8d6d
                    MATRIX: 961->1|1739->318|1772->342|1845->261|1874->386|1902->764|1939->766|1952->771|2009->819|2049->821|2100->837|2113->842|2181->888|2775->1446|2795->1457|2908->1547|3015->1619|3055->1650|3094->1651|3265->1787|3279->1792|3365->1856|3417->1873|3460->1900|3499->1901|3547->1914|3630->1975|3672->1982|3746->2034|3788->2041|3865->2096|3965->2160|3975->2161|4025->2189|4078->2206|4092->2211|4167->2264|4220->2281|4234->2286|4306->2336|4359->2353|4373->2358|4446->2409|4517->2445|4599->2505|4641->2512|4714->2563|4756->2570|4832->2624|4874->2631|4936->2671|4978->2678|5047->2725|5084->2731|5243->2854|5257->2859|5309->2889|5368->2912|5382->2917|5431->2944|5490->2967|5504->2972|5554->3000|5648->3063|5686->3066|5727->3098|5766->3099|5937->3235|5951->3240|6039->3306|6091->3323|6154->3364|6195->3370|6255->3408|6296->3414|6357->3453|6398->3459|6442->3487|6481->3488|6529->3501|6612->3562|6654->3569|6728->3621|6770->3628|6847->3683|6948->3747|6959->3748|7010->3776|7064->3793|7079->3798|7155->3851|7209->3868|7224->3873|7297->3923|7351->3940|7366->3945|7440->3996|7512->4032|7595->4092|7638->4099|7712->4150|7755->4157|7832->4211|7875->4218|7938->4258|7981->4265|8051->4312|8089->4318|8249->4441|8264->4446|8317->4476|8377->4499|8392->4504|8442->4531|8502->4554|8517->4559|8568->4587|8660->4647|8699->4650|8745->4686|8785->4687|8957->4823|8972->4828|9064->4897|9117->4914|9181->4955|9223->4961|9284->4999|9326->5005|9388->5044|9430->5050|9479->5082|9519->5083|9568->5096|9652->5157|9695->5164|9770->5216|9813->5223|9891->5278|9992->5342|10003->5343|10054->5371|10108->5388|10123->5393|10199->5446|10253->5463|10268->5468|10341->5518|10395->5535|10410->5540|10484->5591|10556->5627|10639->5687|10682->5694|10756->5745|10799->5752|10876->5806|10919->5813|10982->5853|11025->5860|11095->5907|11133->5913|11293->6036|11308->6041|11361->6071|11421->6094|11436->6099|11486->6126|11546->6149|11561->6154|11612->6182|11704->6242|11743->6245|11782->6274|11822->6275|11994->6411|12009->6416|12094->6478|12147->6495|12211->6536|12253->6542|12314->6580|12356->6586|12418->6625|12460->6631|12502->6656|12542->6657|12591->6670|12675->6731|12718->6738|12793->6790|12836->6797|12914->6852|13015->6916|13026->6917|13077->6945|13131->6962|13146->6967|13222->7020|13276->7037|13291->7042|13364->7092|13418->7109|13433->7114|13507->7165|13579->7201|13662->7261|13705->7268|13779->7319|13822->7326|13899->7380|13942->7387|14005->7427|14048->7434|14118->7481|14156->7487|14316->7610|14331->7615|14384->7645|14444->7668|14459->7673|14509->7700|14569->7723|14584->7728|14635->7756|14727->7816|14766->7819|14802->7845|14842->7846|15014->7982|15029->7987|15110->8045|15163->8062|15227->8103|15269->8109|15330->8147|15372->8153|15434->8192|15476->8198|15515->8220|15555->8221|15604->8234|15688->8295|15731->8302|15806->8354|15849->8361|15927->8416|16028->8480|16039->8481|16090->8509|16144->8526|16159->8531|16235->8584|16289->8601|16304->8606|16377->8656|16431->8673|16446->8678|16520->8729|16592->8765|16675->8825|16718->8832|16792->8883|16835->8890|16912->8944|16955->8951|17018->8991|17061->8998|17131->9045|17169->9051|17329->9174|17344->9179|17397->9209|17457->9232|17472->9237|17522->9264|17582->9287|17597->9292|17648->9320|17740->9380
                    LINES: 26->1|45->11|45->11|46->7|47->11|48->15|49->16|49->16|49->16|49->16|53->20|53->20|53->20|71->38|71->38|71->38|78->45|78->45|78->45|82->49|82->49|82->49|84->51|84->51|84->51|86->53|86->53|87->54|87->54|88->55|88->55|91->58|91->58|91->58|92->59|92->59|92->59|93->60|93->60|93->60|94->61|94->61|94->61|98->65|98->65|99->66|99->66|100->67|100->67|101->68|101->68|102->69|102->69|103->70|108->75|108->75|108->75|109->76|109->76|109->76|110->77|110->77|110->77|116->83|118->85|118->85|118->85|122->89|122->89|122->89|124->91|124->91|125->92|125->92|126->93|126->93|127->94|127->94|127->94|129->96|129->96|130->97|130->97|131->98|131->98|134->101|134->101|134->101|135->102|135->102|135->102|136->103|136->103|136->103|137->104|137->104|137->104|141->108|141->108|142->109|142->109|143->110|143->110|144->111|144->111|145->112|145->112|146->113|151->118|151->118|151->118|152->119|152->119|152->119|153->120|153->120|153->120|159->126|161->128|161->128|161->128|165->132|165->132|165->132|167->134|167->134|168->135|168->135|169->136|169->136|170->137|170->137|170->137|172->139|172->139|173->140|173->140|174->141|174->141|177->144|177->144|177->144|178->145|178->145|178->145|179->146|179->146|179->146|180->147|180->147|180->147|184->151|184->151|185->152|185->152|186->153|186->153|187->154|187->154|188->155|188->155|189->156|194->161|194->161|194->161|195->162|195->162|195->162|196->163|196->163|196->163|202->169|204->171|204->171|204->171|208->175|208->175|208->175|210->177|210->177|211->178|211->178|212->179|212->179|213->180|213->180|213->180|215->182|215->182|216->183|216->183|217->184|217->184|220->187|220->187|220->187|221->188|221->188|221->188|222->189|222->189|222->189|223->190|223->190|223->190|227->194|227->194|228->195|228->195|229->196|229->196|230->197|230->197|231->198|231->198|232->199|237->204|237->204|237->204|238->205|238->205|238->205|239->206|239->206|239->206|246->213|248->215|248->215|248->215|252->219|252->219|252->219|254->221|254->221|255->222|255->222|256->223|256->223|257->224|257->224|257->224|259->226|259->226|260->227|260->227|261->228|261->228|264->231|264->231|264->231|265->232|265->232|265->232|266->233|266->233|266->233|267->234|267->234|267->234|271->238|271->238|272->239|272->239|273->240|273->240|274->241|274->241|275->242|275->242|276->243|281->248|281->248|281->248|282->249|282->249|282->249|283->250|283->250|283->250|289->256
                    -- GENERATED --
                */
            