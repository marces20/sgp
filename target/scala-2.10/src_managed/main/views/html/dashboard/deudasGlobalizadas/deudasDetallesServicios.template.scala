
package views.html.dashboard.deudasGlobalizadas

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
object deudasDetallesServicios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],java.util.List[Long],java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],java.util.Map[String, java.math.BigDecimal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],
peridoIds:java.util.List[Long],
pret:java.util.Map[String,java.util.Map[Long,java.math.BigDecimal]],
deudaSinPeriodos:java.util.Map[String,java.math.BigDecimal],formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalDeudaOtros=new java.math.BigDecimal(0);var totalCompromisoOtros=new java.math.BigDecimal(0);var totalDeudaHearm=new java.math.BigDecimal(0);var totalCompromisoHearm=new java.math.BigDecimal(0);var totalTr=new java.math.BigDecimal(0);var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var columnas =6

import java.lang.String;var proveedorNombre =""

implicit def /*9.2*/implicitFieldConstructor/*9.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*4.87*/("""

"""),format.raw/*9.70*/("""
"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.dashboard.mainDashboard("Deudas Servicios")/*13.56*/ {_display_(Seq[Any](format.raw/*13.58*/("""
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*14.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Servicios</h1>
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
				  href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasDetallesServiciosReportes())),format.raw/*31.113*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*37.2*/{columnas = columnas+peridoIds.size()})),format.raw/*37.40*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="">
			<thead>
				<th colspan=""""),_display_(Seq[Any](/*42.19*/columnas)),format.raw/*42.27*/("""" align="center" style="font-size:20px;text-align:center;">OPERARIVA - HEARM</th>
			</thead>
			<thead>
				<th>N° EXP.</th>
				<th>INSTITUCION</th>
				<th>PROVEEDOR</th>
				<th>COMPROMISO</th>
				<th>S/D</th>
				"""),_display_(Seq[Any](/*50.6*/for(pe <- peridoIds) yield /*50.26*/{_display_(Seq[Any](format.raw/*50.27*/("""
					<th>"""),_display_(Seq[Any](/*51.11*/Periodo/*51.18*/.find.byId(pe).nombre)),format.raw/*51.39*/("""</th>
				""")))})),format.raw/*52.6*/("""
				<th>TOTAL</th>
			</thead>	
			<tbody>
				
				"""),_display_(Seq[Any](/*57.6*/for(s <- proveedorHEARM) yield /*57.30*/{_display_(Seq[Any](format.raw/*57.31*/("""
					"""),_display_(Seq[Any](/*58.7*/{totalTr = new java.math.BigDecimal(0)})),format.raw/*58.46*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*60.12*/s/*60.13*/.getString("expediente"))),format.raw/*60.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*61.12*/s/*61.13*/.getString("deposito"))),format.raw/*61.35*/("""</td>
						<td>"""),_display_(Seq[Any](/*62.12*/s/*62.13*/.getString("nombre_proveedor"))),format.raw/*62.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*63.12*/utils/*63.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*63.73*/("""</td>
						"""),_display_(Seq[Any](/*64.8*/{totalCompromisoHearm = totalCompromisoHearm.add(s.getBigDecimal("total_compromiso"))})),format.raw/*64.94*/("""
						
						"""),_display_(Seq[Any](/*66.8*/if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null)/*66.122*/{_display_(Seq[Any](format.raw/*66.123*/("""
							<td>"""),_display_(Seq[Any](/*67.13*/utils/*67.18*/.NumberUtils.moneda(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString())))),format.raw/*67.141*/("""</td>
							"""),_display_(Seq[Any](/*68.9*/{totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*68.136*/("""
							"""),_display_(Seq[Any](/*69.9*/{totalDeudaHearm = totalDeudaHearm.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*69.152*/("""
						""")))}/*70.8*/else/*70.12*/{_display_(Seq[Any](format.raw/*70.13*/("""
							<td>"""),_display_(Seq[Any](/*71.13*/utils/*71.18*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*71.54*/("""</td>
						""")))})),format.raw/*72.8*/("""
						
						"""),_display_(Seq[Any](/*74.8*/for(pe <-peridoIds) yield /*74.27*/{_display_(Seq[Any](format.raw/*74.28*/("""
							"""),_display_(Seq[Any](/*75.9*/if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null)/*75.221*/{_display_(Seq[Any](format.raw/*75.222*/("""
								<td>"""),_display_(Seq[Any](/*76.14*/utils/*76.19*/.NumberUtils.moneda(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe)))),format.raw/*76.138*/("""</td>
								"""),_display_(Seq[Any](/*77.10*/{totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*77.133*/("""
								"""),_display_(Seq[Any](/*78.10*/{totalDeudaHearm = totalDeudaHearm.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*78.149*/("""
							""")))}/*79.9*/else/*79.13*/{_display_(Seq[Any](format.raw/*79.14*/("""
								<td>"""),_display_(Seq[Any](/*80.14*/utils/*80.19*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*80.55*/("""</td>
							""")))})),format.raw/*81.9*/("""
						""")))})),format.raw/*82.8*/("""
						
						<td>"""),_display_(Seq[Any](/*84.12*/utils/*84.17*/.NumberUtils.moneda(totalTr))),format.raw/*84.45*/("""</td>
					</tr>
				""")))})),format.raw/*86.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="3" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*91.14*/utils/*91.19*/.NumberUtils.moneda(totalCompromisoHearm))),format.raw/*91.60*/("""</b></td>
					<td></td>
					"""),_display_(Seq[Any](/*93.7*/for(pe <-peridoIds) yield /*93.26*/{_display_(Seq[Any](format.raw/*93.27*/("""
						<td></td>
					""")))})),format.raw/*95.7*/("""
					<td><b>"""),_display_(Seq[Any](/*96.14*/utils/*96.19*/.NumberUtils.moneda(totalDeudaHearm))),format.raw/*96.55*/("""</b></td>
				</tr>
			</tfoot>
		</table>	
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="">
			<thead>
				<th colspan=""""),_display_(Seq[Any](/*107.19*/columnas)),format.raw/*107.27*/("""" align="center" style="font-size:20px;text-align:center;">OPERARIVA - OTRAS INSTITUCIONES</th>
			</thead>
			<thead>
				<th>N° EXP.</th>
				<th>INSTITUCION</th>
				<th>PROVEEDOR</th>
				<th>COMPROMISO</th>
				<th>S/D</th>
				"""),_display_(Seq[Any](/*115.6*/for(pe <- peridoIds) yield /*115.26*/{_display_(Seq[Any](format.raw/*115.27*/("""
					<th>"""),_display_(Seq[Any](/*116.11*/Periodo/*116.18*/.find.byId(pe).nombre)),format.raw/*116.39*/("""</th>
				""")))})),format.raw/*117.6*/("""
				<th>TOTAL</th>
			</thead>	
			<tbody>
				
				"""),_display_(Seq[Any](/*122.6*/for(s <- proveedorOtros) yield /*122.30*/{_display_(Seq[Any](format.raw/*122.31*/("""
					"""),_display_(Seq[Any](/*123.7*/{totalTr = new java.math.BigDecimal(0)})),format.raw/*123.46*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*125.12*/s/*125.13*/.getString("expediente"))),format.raw/*125.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*126.12*/s/*126.13*/.getString("deposito"))),format.raw/*126.35*/("""</td>
						<td>"""),_display_(Seq[Any](/*127.12*/s/*127.13*/.getString("nombre_proveedor"))),format.raw/*127.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*128.12*/utils/*128.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*128.73*/("""</td>
						"""),_display_(Seq[Any](/*129.8*/{totalCompromisoOtros = totalCompromisoOtros.add(s.getBigDecimal("total_compromiso"))})),format.raw/*129.94*/("""
						
						"""),_display_(Seq[Any](/*131.8*/if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null)/*131.122*/{_display_(Seq[Any](format.raw/*131.123*/("""
							<td>"""),_display_(Seq[Any](/*132.13*/utils/*132.18*/.NumberUtils.moneda(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString())))),format.raw/*132.141*/("""</td>
							"""),_display_(Seq[Any](/*133.9*/{totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*133.136*/("""
							"""),_display_(Seq[Any](/*134.9*/{totalDeudaOtros = totalDeudaOtros.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*134.152*/("""
						""")))}/*135.8*/else/*135.12*/{_display_(Seq[Any](format.raw/*135.13*/("""
							<td>"""),_display_(Seq[Any](/*136.13*/utils/*136.18*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*136.54*/("""</td>
						""")))})),format.raw/*137.8*/("""
						
						
						"""),_display_(Seq[Any](/*140.8*/for(pe <-peridoIds) yield /*140.27*/{_display_(Seq[Any](format.raw/*140.28*/("""
							"""),_display_(Seq[Any](/*141.9*/if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null)/*141.221*/{_display_(Seq[Any](format.raw/*141.222*/("""
								<td>"""),_display_(Seq[Any](/*142.14*/utils/*142.19*/.NumberUtils.moneda(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe)))),format.raw/*142.138*/("""</td>
								"""),_display_(Seq[Any](/*143.10*/{totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*143.133*/("""
								"""),_display_(Seq[Any](/*144.10*/{totalDeudaOtros = totalDeudaOtros.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*144.149*/("""
							""")))}/*145.9*/else/*145.13*/{_display_(Seq[Any](format.raw/*145.14*/("""
								<td>"""),_display_(Seq[Any](/*146.14*/utils/*146.19*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*146.55*/("""</td>
							""")))})),format.raw/*147.9*/("""
						""")))})),format.raw/*148.8*/("""
						
						<td>"""),_display_(Seq[Any](/*150.12*/utils/*150.17*/.NumberUtils.moneda(totalTr))),format.raw/*150.45*/("""</td>
					</tr>
				""")))})),format.raw/*152.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="3" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*157.14*/utils/*157.19*/.NumberUtils.moneda(totalCompromisoOtros))),format.raw/*157.60*/("""</b></td>
					<td></td>
					"""),_display_(Seq[Any](/*159.7*/for(pe <-peridoIds) yield /*159.26*/{_display_(Seq[Any](format.raw/*159.27*/("""
						<td></td>
					""")))})),format.raw/*161.7*/("""
					<td><b>"""),_display_(Seq[Any](/*162.14*/utils/*162.19*/.NumberUtils.moneda(totalDeudaOtros))),format.raw/*162.55*/("""</b></td>
				</tr>
			</tfoot>
		</table>	
	</div>
</div>


<!-- 

 <div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*175.5*/views/*175.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","HEARM",""))),format.raw/*175.82*/("""
			<tbody>
				"""),_display_(Seq[Any](/*177.6*/for(s <- proveedorHEARM) yield /*177.30*/{_display_(Seq[Any](format.raw/*177.31*/("""
					 
					
					"""),_display_(Seq[Any](/*180.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*180.73*/{_display_(Seq[Any](format.raw/*180.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*182.42*/proveedorNombre)),format.raw/*182.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*183.16*/utils/*183.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*183.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*184.16*/utils/*184.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*184.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*188.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*188.49*/("""
						"""),_display_(Seq[Any](/*189.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*189.54*/("""
						"""),_display_(Seq[Any](/*190.8*/{bandera = 0})),format.raw/*190.21*/("""
					""")))})),format.raw/*191.7*/(""" 
					"""),_display_(Seq[Any](/*192.7*/if(bandera == 0)/*192.23*/{_display_(Seq[Any](format.raw/*192.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*194.43*/s/*194.44*/.getString("nombre_proveedor"))),format.raw/*194.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*196.8*/{bandera = 1})),format.raw/*196.21*/("""
					""")))})),format.raw/*197.7*/("""
						"""),_display_(Seq[Any](/*198.8*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*198.67*/("""
						"""),_display_(Seq[Any](/*199.8*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*199.82*/("""
					 
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*202.12*/s/*202.13*/.getInteger("numeroProvision"))),format.raw/*202.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*203.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*203.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*204.12*/s/*204.13*/.getString("expediente"))),format.raw/*204.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*205.12*/s/*205.13*/.getString("nombre_proveedor"))),format.raw/*205.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*206.12*/utils/*206.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*206.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*207.12*/utils/*207.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*207.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*208.12*/s/*208.13*/.getString("rubro"))),format.raw/*208.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*209.12*/s/*209.13*/.getString("descripcion"))),format.raw/*209.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*211.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*211.57*/("""
					"""),_display_(Seq[Any](/*212.7*/{mtcoh= mtcoh.add(s.getBigDecimal("total_compromiso"))})),format.raw/*212.62*/("""
					"""),_display_(Seq[Any](/*213.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*213.50*/("""
					"""),_display_(Seq[Any](/*214.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*214.58*/("""
				""")))})),format.raw/*215.6*/("""
				"""),_display_(Seq[Any](/*216.6*/if(proveedorHEARM.size() >0)/*216.34*/{_display_(Seq[Any](format.raw/*216.35*/(""" 
					<tr>
						<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*218.41*/proveedorNombre)),format.raw/*218.56*/(""" - TOTAL</b></td>
						<td><b>"""),_display_(Seq[Any](/*219.15*/utils/*219.20*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*219.50*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*220.15*/utils/*220.20*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*220.55*/("""</b></td>
						<td colspan="2"></td>
					</tr>
					<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*224.6*/("""	 
				 
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*230.14*/utils/*230.19*/.NumberUtils.moneda(mtdoh))),format.raw/*230.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*231.14*/utils/*231.19*/.NumberUtils.moneda(mtcoh))),format.raw/*231.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*241.5*/views/*241.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","OTRAS INSTITUCIONES",""))),format.raw/*241.96*/("""
			<tbody>
				"""),_display_(Seq[Any](/*243.6*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*243.47*/("""
				"""),_display_(Seq[Any](/*244.6*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*244.52*/("""
				"""),_display_(Seq[Any](/*245.6*/{proveedorNombre = ""})),format.raw/*245.28*/("""	
				"""),_display_(Seq[Any](/*246.6*/{proveedorId = 0})),format.raw/*246.23*/("""	
				"""),_display_(Seq[Any](/*247.6*/{bandera = 0})),format.raw/*247.19*/("""
				"""),_display_(Seq[Any](/*248.6*/for(s <- proveedorOtros) yield /*248.30*/{_display_(Seq[Any](format.raw/*248.31*/("""
					"""),_display_(Seq[Any](/*249.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*249.73*/{_display_(Seq[Any](format.raw/*249.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*251.42*/proveedorNombre)),format.raw/*251.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*252.16*/utils/*252.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*252.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*253.16*/utils/*253.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*253.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*257.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*257.49*/("""
						"""),_display_(Seq[Any](/*258.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*258.54*/("""
						"""),_display_(Seq[Any](/*259.8*/{bandera = 0})),format.raw/*259.21*/("""
					""")))})),format.raw/*260.7*/(""" 
					"""),_display_(Seq[Any](/*261.7*/if(bandera == 0)/*261.23*/{_display_(Seq[Any](format.raw/*261.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*263.43*/s/*263.44*/.getString("nombre_proveedor"))),format.raw/*263.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*265.8*/{bandera = 1})),format.raw/*265.21*/("""
					""")))})),format.raw/*266.7*/("""
					"""),_display_(Seq[Any](/*267.7*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*267.66*/("""
					"""),_display_(Seq[Any](/*268.7*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*268.81*/("""
						
					<tr>
						<td>"""),_display_(Seq[Any](/*271.12*/s/*271.13*/.getInteger("numeroProvision"))),format.raw/*271.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*272.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*272.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*273.12*/s/*273.13*/.getString("expediente"))),format.raw/*273.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*274.12*/s/*274.13*/.getString("nombre_proveedor"))),format.raw/*274.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*275.12*/utils/*275.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*275.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*276.12*/utils/*276.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*276.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*277.12*/s/*277.13*/.getString("rubro"))),format.raw/*277.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*278.12*/s/*278.13*/.getString("descripcion"))),format.raw/*278.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*280.7*/{mtdoo= mtdoo.add(s.getBigDecimal("total_deuda"))})),format.raw/*280.57*/("""
					"""),_display_(Seq[Any](/*281.7*/{mtcoo= mtcoo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*281.62*/("""
					"""),_display_(Seq[Any](/*282.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*282.50*/("""
					"""),_display_(Seq[Any](/*283.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*283.58*/("""	
				""")))})),format.raw/*284.6*/("""
				"""),_display_(Seq[Any](/*285.6*/if(proveedorOtros.size() >0)/*285.34*/{_display_(Seq[Any](format.raw/*285.35*/(""" 
				<tr>
					<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*287.40*/proveedorNombre)),format.raw/*287.55*/(""" - TOTAL</b></td>
					<td><b>"""),_display_(Seq[Any](/*288.14*/utils/*288.19*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*288.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*289.14*/utils/*289.19*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*289.54*/("""</b></td>
					<td colspan="2"></td>
				</tr>
				<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*293.6*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*298.14*/utils/*298.19*/.NumberUtils.moneda(mtdoo))),format.raw/*298.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*299.14*/utils/*299.19*/.NumberUtils.moneda(mtcoo))),format.raw/*299.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>  
-->
""")))})))}
    }
    
    def render(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],peridoIds:java.util.List[Long],pret:java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],deudaSinPeriodos:java.util.Map[String, java.math.BigDecimal],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],java.util.List[Long],java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],java.util.Map[String, java.math.BigDecimal],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador) => apply(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallesServicios.scala.html
                    HASH: 4f3de045d796474fa889caa01f485c2fbb7415de
                    MATRIX: 1014->1|2068->336|2100->360|2174->278|2203->404|2240->1043|2253->1048|2311->1097|2351->1099|2388->1101|2401->1106|2481->1164|3080->1727|3100->1738|3211->1826|3317->1897|3377->1935|3562->2084|3592->2092|3847->2312|3883->2332|3922->2333|3969->2344|3985->2351|4028->2372|4070->2383|4159->2437|4199->2461|4238->2462|4280->2469|4341->2508|4433->2564|4443->2565|4489->2589|4542->2606|4552->2607|4596->2629|4649->2646|4659->2647|4711->2677|4764->2694|4778->2699|4856->2755|4904->2768|5012->2854|5062->2869|5186->2983|5226->2984|5275->2997|5289->3002|5435->3125|5484->3139|5634->3266|5678->3275|5844->3418|5870->3426|5883->3430|5922->3431|5971->3444|5985->3449|6043->3485|6087->3498|6137->3513|6172->3532|6211->3533|6255->3542|6477->3754|6517->3755|6567->3769|6581->3774|6723->3893|6774->3908|6920->4031|6966->4041|7128->4180|7155->4189|7168->4193|7207->4194|7257->4208|7271->4213|7329->4249|7374->4263|7413->4271|7468->4290|7482->4295|7532->4323|7585->4345|7756->4480|7770->4485|7833->4526|7899->4557|7934->4576|7973->4577|8027->4600|8077->4614|8091->4619|8149->4655|8394->4863|8425->4871|8695->5105|8732->5125|8772->5126|8820->5137|8837->5144|8881->5165|8924->5176|9014->5230|9055->5254|9095->5255|9138->5262|9200->5301|9293->5357|9304->5358|9351->5382|9405->5399|9416->5400|9461->5422|9515->5439|9526->5440|9579->5470|9633->5487|9648->5492|9727->5548|9776->5561|9885->5647|9936->5662|10061->5776|10102->5777|10152->5790|10167->5795|10314->5918|10364->5932|10515->6059|10560->6068|10727->6211|10754->6219|10768->6223|10808->6224|10858->6237|10873->6242|10932->6278|10977->6291|11035->6313|11071->6332|11111->6333|11156->6342|11379->6554|11420->6555|11471->6569|11486->6574|11629->6693|11681->6708|11828->6831|11875->6841|12038->6980|12066->6989|12080->6993|12120->6994|12171->7008|12186->7013|12245->7049|12291->7063|12331->7071|12387->7090|12402->7095|12453->7123|12507->7145|12679->7280|12694->7285|12758->7326|12825->7357|12861->7376|12901->7377|12956->7400|13007->7414|13022->7419|13081->7455|13321->7659|13336->7664|13431->7736|13484->7753|13525->7777|13565->7778|13621->7798|13697->7864|13737->7865|13827->7918|13865->7933|13935->7966|13950->7971|14003->8001|14065->8026|14080->8031|14138->8066|14269->8161|14333->8202|14377->8210|14446->8256|14490->8264|14526->8277|14565->8284|14609->8292|14635->8308|14675->8309|14800->8397|14811->8398|14864->8428|14929->8457|14965->8470|15004->8477|15048->8485|15130->8544|15174->8552|15271->8626|15371->8689|15382->8690|15435->8720|15489->8737|15570->8795|15624->8812|15635->8813|15682->8837|15736->8854|15747->8855|15800->8885|15854->8902|15869->8907|15943->8958|15997->8975|16012->8980|16091->9036|16145->9053|16156->9054|16198->9073|16252->9090|16263->9091|16311->9116|16370->9139|16443->9189|16486->9196|16564->9251|16607->9258|16673->9301|16716->9308|16790->9359|16828->9365|16870->9371|16908->9399|16948->9400|17037->9452|17075->9467|17144->9499|17159->9504|17212->9534|17273->9558|17288->9563|17346->9598|17468->9688|17648->9831|17663->9836|17712->9862|17772->9885|17787->9890|17836->9916|18092->10136|18107->10141|18216->10227|18269->10244|18333->10285|18375->10291|18444->10337|18486->10343|18531->10365|18574->10372|18614->10389|18657->10396|18693->10409|18735->10415|18776->10439|18816->10440|18859->10447|18935->10513|18975->10514|19065->10567|19103->10582|19173->10615|19188->10620|19241->10650|19303->10675|19318->10680|19376->10715|19507->10810|19571->10851|19615->10859|19684->10905|19728->10913|19764->10926|19803->10933|19847->10941|19873->10957|19913->10958|20038->11046|20049->11047|20102->11077|20167->11106|20203->11119|20242->11126|20285->11133|20367->11192|20410->11199|20507->11273|20573->11302|20584->11303|20637->11333|20691->11350|20772->11408|20826->11425|20837->11426|20884->11450|20938->11467|20949->11468|21002->11498|21056->11515|21071->11520|21145->11571|21199->11588|21214->11593|21293->11649|21347->11666|21358->11667|21400->11686|21454->11703|21465->11704|21513->11729|21572->11752|21645->11802|21688->11809|21766->11864|21809->11871|21875->11914|21918->11921|21992->11972|22031->11979|22073->11985|22111->12013|22151->12014|22238->12064|22276->12079|22344->12110|22359->12115|22412->12145|22472->12168|22487->12173|22545->12208|22664->12295|22802->12396|22817->12401|22866->12427|22926->12450|22941->12455|22990->12481
                    LINES: 26->1|42->9|42->9|43->4|45->9|46->13|46->13|46->13|46->13|47->14|47->14|47->14|64->31|64->31|64->31|70->37|70->37|75->42|75->42|83->50|83->50|83->50|84->51|84->51|84->51|85->52|90->57|90->57|90->57|91->58|91->58|93->60|93->60|93->60|94->61|94->61|94->61|95->62|95->62|95->62|96->63|96->63|96->63|97->64|97->64|99->66|99->66|99->66|100->67|100->67|100->67|101->68|101->68|102->69|102->69|103->70|103->70|103->70|104->71|104->71|104->71|105->72|107->74|107->74|107->74|108->75|108->75|108->75|109->76|109->76|109->76|110->77|110->77|111->78|111->78|112->79|112->79|112->79|113->80|113->80|113->80|114->81|115->82|117->84|117->84|117->84|119->86|124->91|124->91|124->91|126->93|126->93|126->93|128->95|129->96|129->96|129->96|140->107|140->107|148->115|148->115|148->115|149->116|149->116|149->116|150->117|155->122|155->122|155->122|156->123|156->123|158->125|158->125|158->125|159->126|159->126|159->126|160->127|160->127|160->127|161->128|161->128|161->128|162->129|162->129|164->131|164->131|164->131|165->132|165->132|165->132|166->133|166->133|167->134|167->134|168->135|168->135|168->135|169->136|169->136|169->136|170->137|173->140|173->140|173->140|174->141|174->141|174->141|175->142|175->142|175->142|176->143|176->143|177->144|177->144|178->145|178->145|178->145|179->146|179->146|179->146|180->147|181->148|183->150|183->150|183->150|185->152|190->157|190->157|190->157|192->159|192->159|192->159|194->161|195->162|195->162|195->162|208->175|208->175|208->175|210->177|210->177|210->177|213->180|213->180|213->180|215->182|215->182|216->183|216->183|216->183|217->184|217->184|217->184|221->188|221->188|222->189|222->189|223->190|223->190|224->191|225->192|225->192|225->192|227->194|227->194|227->194|229->196|229->196|230->197|231->198|231->198|232->199|232->199|235->202|235->202|235->202|236->203|236->203|237->204|237->204|237->204|238->205|238->205|238->205|239->206|239->206|239->206|240->207|240->207|240->207|241->208|241->208|241->208|242->209|242->209|242->209|244->211|244->211|245->212|245->212|246->213|246->213|247->214|247->214|248->215|249->216|249->216|249->216|251->218|251->218|252->219|252->219|252->219|253->220|253->220|253->220|257->224|263->230|263->230|263->230|264->231|264->231|264->231|274->241|274->241|274->241|276->243|276->243|277->244|277->244|278->245|278->245|279->246|279->246|280->247|280->247|281->248|281->248|281->248|282->249|282->249|282->249|284->251|284->251|285->252|285->252|285->252|286->253|286->253|286->253|290->257|290->257|291->258|291->258|292->259|292->259|293->260|294->261|294->261|294->261|296->263|296->263|296->263|298->265|298->265|299->266|300->267|300->267|301->268|301->268|304->271|304->271|304->271|305->272|305->272|306->273|306->273|306->273|307->274|307->274|307->274|308->275|308->275|308->275|309->276|309->276|309->276|310->277|310->277|310->277|311->278|311->278|311->278|313->280|313->280|314->281|314->281|315->282|315->282|316->283|316->283|317->284|318->285|318->285|318->285|320->287|320->287|321->288|321->288|321->288|322->289|322->289|322->289|326->293|331->298|331->298|331->298|332->299|332->299|332->299
                    -- GENERATED --
                */
            