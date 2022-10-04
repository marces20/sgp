
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
object deudasDetallas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Boolean,Integer,java.util.Map[String, java.util.Map[String, java.util.Map[Integer, List[com.avaje.ebean.SqlRow]]]],String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ra:Boolean,idProveedor:Integer,
listaFinal:java.util.Map[String,java.util.Map[String,java.util.Map[Integer,List[com.avaje.ebean.SqlRow]]]],
proveedor:String,
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0);var mtdos=new java.math.BigDecimal(0);var mtcos=new java.math.BigDecimal(0);var mtdph=new java.math.BigDecimal(0);var mtcph=new java.math.BigDecimal(0);var mtdpo=new java.math.BigDecimal(0);var mtcpo=new java.math.BigDecimal(0);var mtdps=new java.math.BigDecimal(0);var mtcps=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var xx =0

import java.lang.String;var proveedorNombre =""


Seq[Any](format.raw/*4.27*/("""
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.mainDashboard("Deudas Detalles")/*8.55*/ {_display_(Seq[Any](format.raw/*8.57*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*10.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Detalles - """),_display_(Seq[Any](/*15.27*/proveedor)),format.raw/*15.36*/("""</h1>
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
				  href=""""),_display_(Seq[Any](/*28.14*/controllers/*28.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasDetallesReporte(idProveedor,ra))),format.raw/*28.117*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*38.4*/if(listaFinal.get("OPERATIVA") != null)/*38.43*/{_display_(Seq[Any](format.raw/*38.44*/("""
			"""),_display_(Seq[Any](/*39.5*/if(listaFinal.get("OPERATIVA").get("HEARM") != null)/*39.57*/{_display_(Seq[Any](format.raw/*39.58*/("""
				"""),_display_(Seq[Any](/*40.6*/if(listaFinal.get("OPERATIVA").get("HEARM").size() > 0)/*40.61*/{_display_(Seq[Any](format.raw/*40.62*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*42.8*/views/*42.13*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","HEARM",proveedor))),format.raw/*42.92*/("""
						<tbody>
							"""),_display_(Seq[Any](/*44.9*/for((key,value) <- listaFinal.get("OPERATIVA").get("HEARM")) yield /*44.69*/{_display_(Seq[Any](format.raw/*44.70*/("""
								"""),_display_(Seq[Any](/*45.10*/for(s <- value) yield /*45.25*/{_display_(Seq[Any](format.raw/*45.26*/("""
									"""),_display_(Seq[Any](/*46.11*/if(s.getString("rubro").compareTo("SERVICIOS") != 0)/*46.63*/{_display_(Seq[Any](format.raw/*46.64*/("""
										"""),_display_(Seq[Any](/*47.12*/{xx = 1})),format.raw/*47.20*/("""
										"""),_display_(Seq[Any](/*48.12*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*48.78*/{_display_(Seq[Any](format.raw/*48.79*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*50.47*/proveedorNombre)),format.raw/*50.62*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*51.21*/utils/*51.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*51.56*/("""</b></td>
												<td><b>"""),_display_(Seq[Any](/*52.21*/utils/*52.26*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*52.61*/("""</b></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*56.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*56.54*/("""
											"""),_display_(Seq[Any](/*57.13*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*57.59*/("""
											"""),_display_(Seq[Any](/*58.13*/{bandera = 0})),format.raw/*58.26*/("""
										""")))})),format.raw/*59.12*/(""" 
										"""),_display_(Seq[Any](/*60.12*/if(bandera == 0)/*60.28*/{_display_(Seq[Any](format.raw/*60.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*62.48*/s/*62.49*/.getString("nombre_proveedor"))),format.raw/*62.79*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*64.13*/{bandera = 1})),format.raw/*64.26*/("""
										""")))})),format.raw/*65.12*/("""
										"""),_display_(Seq[Any](/*66.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*66.71*/("""
										"""),_display_(Seq[Any](/*67.12*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*67.86*/("""
										<tr>
											<td>"""),_display_(Seq[Any](/*69.17*/s/*69.18*/.getInteger("numeroProvision"))),format.raw/*69.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*70.17*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*70.75*/("""</td>
											<td>"""),_display_(Seq[Any](/*71.17*/s/*71.18*/.getString("expediente"))),format.raw/*71.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*72.17*/s/*72.18*/.getString("nombre_proveedor"))),format.raw/*72.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*73.17*/utils/*73.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*73.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*74.17*/utils/*74.22*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*74.78*/("""</td>
											<td>"""),_display_(Seq[Any](/*75.17*/s/*75.18*/.getString("rubro"))),format.raw/*75.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*76.17*/s/*76.18*/.getString("descripcion"))),format.raw/*76.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*78.12*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*78.62*/("""
										"""),_display_(Seq[Any](/*79.12*/{mtcoh= mtcoh.add(s.getBigDecimal("total_compromiso"))})),format.raw/*79.67*/("""
										
										"""),_display_(Seq[Any](/*81.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*81.55*/("""
										"""),_display_(Seq[Any](/*82.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*82.63*/("""
									""")))})),format.raw/*83.11*/("""
								""")))})),format.raw/*84.10*/("""
								
							""")))})),format.raw/*86.9*/("""
							"""),_display_(Seq[Any](/*87.9*/if(listaFinal.get("OPERATIVA").get("HEARM").size() >0 && xx == 1)/*87.74*/{_display_(Seq[Any](format.raw/*87.75*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*89.44*/proveedorNombre)),format.raw/*89.59*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*90.18*/utils/*90.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*90.53*/("""</b></td>
									<td><b>"""),_display_(Seq[Any](/*91.18*/utils/*91.23*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*91.58*/("""</b></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*94.9*/("""
							"""),_display_(Seq[Any](/*95.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*95.50*/("""
							"""),_display_(Seq[Any](/*96.9*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*96.55*/("""
							"""),_display_(Seq[Any](/*97.9*/{proveedorId =0})),format.raw/*97.25*/("""
							"""),_display_(Seq[Any](/*98.9*/{bandera = 0})),format.raw/*98.22*/("""
							"""),_display_(Seq[Any](/*99.9*/{xx = 0})),format.raw/*99.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*104.17*/utils/*104.22*/.NumberUtils.moneda(mtdoh))),format.raw/*104.48*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*105.17*/utils/*105.22*/.NumberUtils.moneda(mtcoh))),format.raw/*105.48*/("""</b></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*110.6*/("""
			""")))})),format.raw/*111.5*/("""
		""")))})),format.raw/*112.4*/("""	
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*117.4*/if(listaFinal.get("OPERATIVA") != null)/*117.43*/{_display_(Seq[Any](format.raw/*117.44*/("""
			"""),_display_(Seq[Any](/*118.5*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES") != null)/*118.71*/{_display_(Seq[Any](format.raw/*118.72*/("""
				"""),_display_(Seq[Any](/*119.6*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES").size() > 0)/*119.75*/{_display_(Seq[Any](format.raw/*119.76*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*121.8*/views/*121.13*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","OTRAS INSTITUCIONES",proveedor))),format.raw/*121.106*/("""
						<tbody>
							"""),_display_(Seq[Any](/*123.9*/for((key,value) <- listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES")) yield /*123.83*/{_display_(Seq[Any](format.raw/*123.84*/("""
								"""),_display_(Seq[Any](/*124.10*/for(s <- value) yield /*124.25*/{_display_(Seq[Any](format.raw/*124.26*/("""
									"""),_display_(Seq[Any](/*125.11*/if(s.getString("rubro").compareTo("SERVICIOS") != 0)/*125.63*/{_display_(Seq[Any](format.raw/*125.64*/("""
										"""),_display_(Seq[Any](/*126.12*/{xx = 1})),format.raw/*126.20*/("""
										"""),_display_(Seq[Any](/*127.12*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*127.78*/{_display_(Seq[Any](format.raw/*127.79*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*129.47*/proveedorNombre)),format.raw/*129.62*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*130.21*/utils/*130.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*130.56*/("""</b></td>
												<td><b>"""),_display_(Seq[Any](/*131.21*/utils/*131.26*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*131.61*/("""</b></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*135.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*135.54*/("""
											"""),_display_(Seq[Any](/*136.13*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*136.59*/("""
											"""),_display_(Seq[Any](/*137.13*/{bandera = 0})),format.raw/*137.26*/("""
										""")))})),format.raw/*138.12*/(""" 
										"""),_display_(Seq[Any](/*139.12*/if(bandera == 0)/*139.28*/{_display_(Seq[Any](format.raw/*139.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*141.48*/s/*141.49*/.getString("nombre_proveedor"))),format.raw/*141.79*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*143.13*/{bandera = 1})),format.raw/*143.26*/("""
										""")))})),format.raw/*144.12*/("""
										"""),_display_(Seq[Any](/*145.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*145.71*/("""
										"""),_display_(Seq[Any](/*146.12*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*146.86*/("""
										<tr>
											<td>"""),_display_(Seq[Any](/*148.17*/s/*148.18*/.getInteger("numeroProvision"))),format.raw/*148.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*149.17*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*149.75*/("""</td>
											<td>"""),_display_(Seq[Any](/*150.17*/s/*150.18*/.getString("expediente"))),format.raw/*150.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*151.17*/s/*151.18*/.getString("nombre_proveedor"))),format.raw/*151.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*152.17*/utils/*152.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*152.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*153.17*/utils/*153.22*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*153.78*/("""</td>
											<td>"""),_display_(Seq[Any](/*154.17*/s/*154.18*/.getString("rubro"))),format.raw/*154.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*155.17*/s/*155.18*/.getString("descripcion"))),format.raw/*155.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*157.12*/{mtdoo= mtdoo.add(s.getBigDecimal("total_deuda"))})),format.raw/*157.62*/("""
										"""),_display_(Seq[Any](/*158.12*/{mtcoo= mtcoo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*158.67*/("""
										"""),_display_(Seq[Any](/*159.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*159.55*/("""
										"""),_display_(Seq[Any](/*160.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*160.63*/("""
									""")))})),format.raw/*161.11*/("""	
								""")))})),format.raw/*162.10*/("""
								 
							""")))})),format.raw/*164.9*/("""
							"""),_display_(Seq[Any](/*165.9*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES").size() >0 && xx == 1)/*165.88*/{_display_(Seq[Any](format.raw/*165.89*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*167.44*/proveedorNombre)),format.raw/*167.59*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*168.18*/utils/*168.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*168.53*/("""</b></td>
									<td><b>"""),_display_(Seq[Any](/*169.18*/utils/*169.23*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*169.58*/("""</b></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*172.9*/("""
							"""),_display_(Seq[Any](/*173.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*173.50*/("""
							"""),_display_(Seq[Any](/*174.9*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*174.55*/("""
							"""),_display_(Seq[Any](/*175.9*/{proveedorId =0})),format.raw/*175.25*/("""
							"""),_display_(Seq[Any](/*176.9*/{bandera = 0})),format.raw/*176.22*/("""
							"""),_display_(Seq[Any](/*177.9*/{xx = 0})),format.raw/*177.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*182.17*/utils/*182.22*/.NumberUtils.moneda(mtdoo))),format.raw/*182.48*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*183.17*/utils/*183.22*/.NumberUtils.moneda(mtcoo))),format.raw/*183.48*/("""</b></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*188.6*/("""
			""")))})),format.raw/*189.5*/("""
		""")))})),format.raw/*190.4*/("""	
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*196.4*/if(listaFinal.get("OPERATIVA") != null)/*196.43*/{_display_(Seq[Any](format.raw/*196.44*/("""
			"""),_display_(Seq[Any](/*197.5*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES") != null && listaFinal.get("OPERATIVA").get("HEARM") != null)/*197.123*/{_display_(Seq[Any](format.raw/*197.124*/("""
				<table class="table table-striped table-bordered table-hover" id="listaInforme">
					"""),_display_(Seq[Any](/*199.7*/views/*199.12*/.html.dashboard.deudasGlobalizadas.tablaDetalles("SERVICIOS - OPERATIVA","",proveedor))),format.raw/*199.98*/("""
					<tbody>
					"""),_display_(Seq[Any](/*201.7*/if(listaFinal.get("OPERATIVA").get("HEARM").size() > 0)/*201.62*/{_display_(Seq[Any](format.raw/*201.63*/("""
						"""),_display_(Seq[Any](/*202.8*/for((key,value) <- listaFinal.get("OPERATIVA").get("HEARM")) yield /*202.68*/{_display_(Seq[Any](format.raw/*202.69*/("""
							"""),_display_(Seq[Any](/*203.9*/for(s <- value) yield /*203.24*/{_display_(Seq[Any](format.raw/*203.25*/("""
								"""),_display_(Seq[Any](/*204.10*/if(s.getString("rubro").compareTo("SERVICIOS") == 0)/*204.62*/{_display_(Seq[Any](format.raw/*204.63*/("""
									"""),_display_(Seq[Any](/*205.11*/{xx = 1})),format.raw/*205.19*/("""
									"""),_display_(Seq[Any](/*206.11*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*206.77*/{_display_(Seq[Any](format.raw/*206.78*/("""
										<tr>
											<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*208.46*/proveedorNombre)),format.raw/*208.61*/(""" - TOTAL</b></td>
											<td><b>"""),_display_(Seq[Any](/*209.20*/utils/*209.25*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*209.55*/("""</b></td>
											<td><b>"""),_display_(Seq[Any](/*210.20*/utils/*210.25*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*210.60*/("""</b></td>
											<td colspan="2"></td>
										</tr>
										<tr><td colspan="8"></td></tr>
										"""),_display_(Seq[Any](/*214.12*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*214.53*/("""
										"""),_display_(Seq[Any](/*215.12*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*215.58*/("""
										"""),_display_(Seq[Any](/*216.12*/{bandera = 0})),format.raw/*216.25*/("""
									""")))})),format.raw/*217.11*/(""" 
									"""),_display_(Seq[Any](/*218.11*/if(bandera == 0)/*218.27*/{_display_(Seq[Any](format.raw/*218.28*/("""
										<tr style="background-color:#dfdfdf;">
											<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*220.47*/s/*220.48*/.getString("nombre_proveedor"))),format.raw/*220.78*/("""</b></td>
										</tr>
										"""),_display_(Seq[Any](/*222.12*/{bandera = 1})),format.raw/*222.25*/("""
									""")))})),format.raw/*223.11*/("""
									"""),_display_(Seq[Any](/*224.11*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*224.70*/("""
									"""),_display_(Seq[Any](/*225.11*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*225.85*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*227.16*/s/*227.17*/.getInteger("numeroProvision"))),format.raw/*227.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*228.16*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*228.74*/("""</td>
										<td>"""),_display_(Seq[Any](/*229.16*/s/*229.17*/.getString("expediente"))),format.raw/*229.41*/("""</td>
										<td>"""),_display_(Seq[Any](/*230.16*/s/*230.17*/.getString("nombre_proveedor"))),format.raw/*230.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*231.16*/utils/*231.21*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*231.72*/("""</td>
										<td>"""),_display_(Seq[Any](/*232.16*/utils/*232.21*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*232.77*/("""</td>
										<td>"""),_display_(Seq[Any](/*233.16*/s/*233.17*/.getString("rubro"))),format.raw/*233.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*234.16*/s/*234.17*/.getString("descripcion"))),format.raw/*234.42*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*236.11*/{mtdos= mtdos.add(s.getBigDecimal("total_deuda"))})),format.raw/*236.61*/("""
									"""),_display_(Seq[Any](/*237.11*/{mtcos= mtcos.add(s.getBigDecimal("total_compromiso"))})),format.raw/*237.66*/("""
									"""),_display_(Seq[Any](/*238.11*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*238.54*/("""
									"""),_display_(Seq[Any](/*239.11*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*239.62*/("""
								""")))})),format.raw/*240.10*/("""	
							""")))})),format.raw/*241.9*/("""
						""")))})),format.raw/*242.8*/("""
						"""),_display_(Seq[Any](/*243.8*/if(listaFinal.get("OPERATIVA").get("HEARM").size() >0 && xx == 1)/*243.73*/{_display_(Seq[Any](format.raw/*243.74*/(""" 
							<tr>
								<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*245.43*/proveedorNombre)),format.raw/*245.58*/(""" - TOTAL</b></td>
								<td><b>"""),_display_(Seq[Any](/*246.17*/utils/*246.22*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*246.52*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*247.17*/utils/*247.22*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*247.57*/("""</b></td>
								<td colspan="2"></td>
							</tr>
						""")))})),format.raw/*250.8*/("""
						"""),_display_(Seq[Any](/*251.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*251.49*/("""
						"""),_display_(Seq[Any](/*252.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*252.54*/("""
						"""),_display_(Seq[Any](/*253.8*/{proveedorId =0})),format.raw/*253.24*/("""
						"""),_display_(Seq[Any](/*254.8*/{bandera = 0})),format.raw/*254.21*/("""
						"""),_display_(Seq[Any](/*255.8*/{xx = 0})),format.raw/*255.16*/("""
					""")))})),format.raw/*256.7*/("""
					"""),_display_(Seq[Any](/*257.7*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES").size() > 0)/*257.76*/{_display_(Seq[Any](format.raw/*257.77*/("""
						"""),_display_(Seq[Any](/*258.8*/for((key,value) <- listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES")) yield /*258.82*/{_display_(Seq[Any](format.raw/*258.83*/("""
							"""),_display_(Seq[Any](/*259.9*/for(s <- value) yield /*259.24*/{_display_(Seq[Any](format.raw/*259.25*/("""
								"""),_display_(Seq[Any](/*260.10*/if(s.getString("rubro").compareTo("SERVICIOS") == 0)/*260.62*/{_display_(Seq[Any](format.raw/*260.63*/("""
									"""),_display_(Seq[Any](/*261.11*/{xx = 1})),format.raw/*261.19*/("""
									"""),_display_(Seq[Any](/*262.11*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*262.77*/{_display_(Seq[Any](format.raw/*262.78*/("""
										<tr>
											<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*264.46*/proveedorNombre)),format.raw/*264.61*/(""" - TOTAL</b></td>
											<td><b>"""),_display_(Seq[Any](/*265.20*/utils/*265.25*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*265.55*/("""</b></td>
											<td><b>"""),_display_(Seq[Any](/*266.20*/utils/*266.25*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*266.60*/("""</b></td>
											<td colspan="2"></td>
										</tr>
										<tr><td colspan="8"></td></tr>
										"""),_display_(Seq[Any](/*270.12*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*270.53*/("""
										"""),_display_(Seq[Any](/*271.12*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*271.58*/("""
										"""),_display_(Seq[Any](/*272.12*/{bandera = 0})),format.raw/*272.25*/("""
									""")))})),format.raw/*273.11*/(""" 
									"""),_display_(Seq[Any](/*274.11*/if(bandera == 0)/*274.27*/{_display_(Seq[Any](format.raw/*274.28*/("""
										<tr style="background-color:#dfdfdf;">
											<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*276.47*/s/*276.48*/.getString("nombre_proveedor"))),format.raw/*276.78*/("""</b></td>
										</tr>
										"""),_display_(Seq[Any](/*278.12*/{bandera = 1})),format.raw/*278.25*/("""
									""")))})),format.raw/*279.11*/("""
									"""),_display_(Seq[Any](/*280.11*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*280.70*/("""
									"""),_display_(Seq[Any](/*281.11*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*281.85*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*283.16*/s/*283.17*/.getInteger("numeroProvision"))),format.raw/*283.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*284.16*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*284.74*/("""</td>
										<td>"""),_display_(Seq[Any](/*285.16*/s/*285.17*/.getString("expediente"))),format.raw/*285.41*/("""</td>
										<td>"""),_display_(Seq[Any](/*286.16*/s/*286.17*/.getString("nombre_proveedor"))),format.raw/*286.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*287.16*/utils/*287.21*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*287.72*/("""</td>
										<td>"""),_display_(Seq[Any](/*288.16*/utils/*288.21*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*288.77*/("""</td>
										<td>"""),_display_(Seq[Any](/*289.16*/s/*289.17*/.getString("rubro"))),format.raw/*289.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*290.16*/s/*290.17*/.getString("descripcion"))),format.raw/*290.42*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*292.11*/{mtdos= mtdos.add(s.getBigDecimal("total_deuda"))})),format.raw/*292.61*/("""
									"""),_display_(Seq[Any](/*293.11*/{mtcos= mtcos.add(s.getBigDecimal("total_compromiso"))})),format.raw/*293.66*/("""
									"""),_display_(Seq[Any](/*294.11*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*294.54*/("""
									"""),_display_(Seq[Any](/*295.11*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*295.62*/("""
								""")))})),format.raw/*296.10*/("""	
							""")))})),format.raw/*297.9*/("""
					 	
					  """)))})),format.raw/*299.9*/("""
						  """),_display_(Seq[Any](/*300.10*/if(listaFinal.get("OPERATIVA").get("OTRAS INSTITUCIONES").size() >0 && xx == 1)/*300.89*/{_display_(Seq[Any](format.raw/*300.90*/(""" 
							<tr>
								<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*302.43*/proveedorNombre)),format.raw/*302.58*/(""" - TOTAL</b></td>
								<td><b>"""),_display_(Seq[Any](/*303.17*/utils/*303.22*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*303.52*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*304.17*/utils/*304.22*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*304.57*/("""</b></td>
								<td colspan="2"></td>
							</tr>
						  """)))})),format.raw/*307.10*/("""
						"""),_display_(Seq[Any](/*308.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*308.49*/("""
						"""),_display_(Seq[Any](/*309.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*309.54*/("""
						"""),_display_(Seq[Any](/*310.8*/{proveedorId =0})),format.raw/*310.24*/("""
						"""),_display_(Seq[Any](/*311.8*/{bandera = 0})),format.raw/*311.21*/("""
						"""),_display_(Seq[Any](/*312.8*/{xx = 0})),format.raw/*312.16*/("""
					""")))})),format.raw/*313.7*/("""
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4" align="right"><b>TOTALES</b></td>
							<td><b>"""),_display_(Seq[Any](/*318.16*/utils/*318.21*/.NumberUtils.moneda(mtdos))),format.raw/*318.47*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*319.16*/utils/*319.21*/.NumberUtils.moneda(mtcos))),format.raw/*319.47*/("""</b></td>
							<td colspan="2" align="right"></td>
						</tr>
					</tfoot>
				</table>
			""")))})),format.raw/*324.5*/("""
		""")))})),format.raw/*325.4*/("""	
	</div>
</div>



<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*333.4*/if(listaFinal.get("PROFE") != null)/*333.39*/{_display_(Seq[Any](format.raw/*333.40*/("""
			"""),_display_(Seq[Any](/*334.5*/if(listaFinal.get("PROFE").get("HEARM") != null)/*334.53*/{_display_(Seq[Any](format.raw/*334.54*/("""
				"""),_display_(Seq[Any](/*335.6*/if(listaFinal.get("PROFE").get("HEARM").size() > 0)/*335.57*/{_display_(Seq[Any](format.raw/*335.58*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*337.8*/views/*337.13*/.html.dashboard.deudasGlobalizadas.tablaDetalles("PROFE","HEARM",proveedor))),format.raw/*337.88*/("""
						<tbody>
							"""),_display_(Seq[Any](/*339.9*/for((key,value) <- listaFinal.get("PROFE").get("HEARM")) yield /*339.65*/{_display_(Seq[Any](format.raw/*339.66*/("""
								"""),_display_(Seq[Any](/*340.10*/for(s <- value) yield /*340.25*/{_display_(Seq[Any](format.raw/*340.26*/("""
									"""),_display_(Seq[Any](/*341.11*/if(s.getString("rubro").compareTo("SERVICIOS") != 0)/*341.63*/{_display_(Seq[Any](format.raw/*341.64*/("""
										"""),_display_(Seq[Any](/*342.12*/{xx = 1})),format.raw/*342.20*/("""
										"""),_display_(Seq[Any](/*343.12*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*343.78*/{_display_(Seq[Any](format.raw/*343.79*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*345.47*/proveedorNombre)),format.raw/*345.62*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*346.21*/utils/*346.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*346.56*/("""</b></td>
												<td><b>"""),_display_(Seq[Any](/*347.21*/utils/*347.26*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*347.61*/("""</b></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*351.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*351.54*/("""
											"""),_display_(Seq[Any](/*352.13*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*352.59*/("""
											"""),_display_(Seq[Any](/*353.13*/{bandera = 0})),format.raw/*353.26*/("""
										""")))})),format.raw/*354.12*/(""" 
										"""),_display_(Seq[Any](/*355.12*/if(bandera == 0)/*355.28*/{_display_(Seq[Any](format.raw/*355.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*357.48*/s/*357.49*/.getString("nombre_proveedor"))),format.raw/*357.79*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*359.13*/{bandera = 1})),format.raw/*359.26*/("""
										""")))})),format.raw/*360.12*/("""
										"""),_display_(Seq[Any](/*361.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*361.71*/("""
										"""),_display_(Seq[Any](/*362.12*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*362.86*/("""
										<tr>
											<td>"""),_display_(Seq[Any](/*364.17*/s/*364.18*/.getInteger("numeroProvision"))),format.raw/*364.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*365.17*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*365.75*/("""</td>
											<td>"""),_display_(Seq[Any](/*366.17*/s/*366.18*/.getString("expediente"))),format.raw/*366.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*367.17*/s/*367.18*/.getString("nombre_proveedor"))),format.raw/*367.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*368.17*/utils/*368.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*368.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*369.17*/utils/*369.22*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*369.78*/("""</td>
											<td>"""),_display_(Seq[Any](/*370.17*/s/*370.18*/.getString("rubro"))),format.raw/*370.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*371.17*/s/*371.18*/.getString("descripcion"))),format.raw/*371.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*373.12*/{mtdph= mtdph.add(s.getBigDecimal("total_deuda"))})),format.raw/*373.62*/("""
										"""),_display_(Seq[Any](/*374.12*/{mtcph= mtcph.add(s.getBigDecimal("total_compromiso"))})),format.raw/*374.67*/("""
										"""),_display_(Seq[Any](/*375.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*375.55*/("""
										"""),_display_(Seq[Any](/*376.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*376.63*/("""
									""")))})),format.raw/*377.11*/("""
								""")))})),format.raw/*378.10*/("""
								 
							""")))})),format.raw/*380.9*/("""
							"""),_display_(Seq[Any](/*381.9*/if(listaFinal.get("PROFE").get("HEARM").size() >0 && xx == 1)/*381.70*/{_display_(Seq[Any](format.raw/*381.71*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*383.44*/proveedorNombre)),format.raw/*383.59*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*384.18*/utils/*384.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*384.53*/("""</b></td>
									<td><b>"""),_display_(Seq[Any](/*385.18*/utils/*385.23*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*385.58*/("""</b></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*388.9*/("""
							"""),_display_(Seq[Any](/*389.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*389.50*/("""
							"""),_display_(Seq[Any](/*390.9*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*390.55*/("""
							"""),_display_(Seq[Any](/*391.9*/{proveedorId =0})),format.raw/*391.25*/("""
							"""),_display_(Seq[Any](/*392.9*/{bandera = 0})),format.raw/*392.22*/("""
							"""),_display_(Seq[Any](/*393.9*/{xx = 0})),format.raw/*393.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*398.17*/utils/*398.22*/.NumberUtils.moneda(mtdph))),format.raw/*398.48*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*399.17*/utils/*399.22*/.NumberUtils.moneda(mtcph))),format.raw/*399.48*/("""</b></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*404.6*/("""
			""")))})),format.raw/*405.5*/("""
		""")))})),format.raw/*406.4*/("""	
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*411.4*/if(listaFinal.get("PROFE") != null)/*411.39*/{_display_(Seq[Any](format.raw/*411.40*/("""
			"""),_display_(Seq[Any](/*412.5*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES") != null)/*412.67*/{_display_(Seq[Any](format.raw/*412.68*/("""
				"""),_display_(Seq[Any](/*413.6*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES").size() > 0)/*413.71*/{_display_(Seq[Any](format.raw/*413.72*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*415.8*/views/*415.13*/.html.dashboard.deudasGlobalizadas.tablaDetalles("PROFE","OTRAS INSTITUCIONES",proveedor))),format.raw/*415.102*/("""
						<tbody>
							"""),_display_(Seq[Any](/*417.9*/for((key,value) <- listaFinal.get("PROFE").get("OTRAS INSTITUCIONES")) yield /*417.79*/{_display_(Seq[Any](format.raw/*417.80*/("""
								"""),_display_(Seq[Any](/*418.10*/for(s <- value) yield /*418.25*/{_display_(Seq[Any](format.raw/*418.26*/("""
									"""),_display_(Seq[Any](/*419.11*/if(s.getString("rubro").compareTo("SERVICIOS") != 0)/*419.63*/{_display_(Seq[Any](format.raw/*419.64*/("""
										"""),_display_(Seq[Any](/*420.12*/{xx = 1})),format.raw/*420.20*/("""
										"""),_display_(Seq[Any](/*421.12*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*421.78*/{_display_(Seq[Any](format.raw/*421.79*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*423.47*/proveedorNombre)),format.raw/*423.62*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*424.21*/utils/*424.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*424.56*/("""</b></td>
												<td><b>"""),_display_(Seq[Any](/*425.21*/utils/*425.26*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*425.61*/("""</b></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*429.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*429.54*/("""
											"""),_display_(Seq[Any](/*430.13*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*430.59*/("""
											"""),_display_(Seq[Any](/*431.13*/{bandera = 0})),format.raw/*431.26*/("""
										""")))})),format.raw/*432.12*/(""" 
										"""),_display_(Seq[Any](/*433.12*/if(bandera == 0)/*433.28*/{_display_(Seq[Any](format.raw/*433.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*435.48*/s/*435.49*/.getString("nombre_proveedor"))),format.raw/*435.79*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*437.13*/{bandera = 1})),format.raw/*437.26*/("""
										""")))})),format.raw/*438.12*/("""
										"""),_display_(Seq[Any](/*439.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*439.71*/("""
										"""),_display_(Seq[Any](/*440.12*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*440.86*/("""
										<tr>
											<td>"""),_display_(Seq[Any](/*442.17*/s/*442.18*/.getInteger("numeroProvision"))),format.raw/*442.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*443.17*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*443.75*/("""</td>
											<td>"""),_display_(Seq[Any](/*444.17*/s/*444.18*/.getString("expediente"))),format.raw/*444.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*445.17*/s/*445.18*/.getString("nombre_proveedor"))),format.raw/*445.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*446.17*/utils/*446.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*446.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*447.17*/utils/*447.22*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*447.78*/("""</td>
											<td>"""),_display_(Seq[Any](/*448.17*/s/*448.18*/.getString("rubro"))),format.raw/*448.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*449.17*/s/*449.18*/.getString("descripcion"))),format.raw/*449.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*451.12*/{mtdpo= mtdpo.add(s.getBigDecimal("total_deuda"))})),format.raw/*451.62*/("""
										"""),_display_(Seq[Any](/*452.12*/{mtcpo= mtcpo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*452.67*/("""
										"""),_display_(Seq[Any](/*453.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*453.55*/("""
										"""),_display_(Seq[Any](/*454.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*454.63*/("""
									""")))})),format.raw/*455.11*/("""
								""")))})),format.raw/*456.10*/("""
								"""),_display_(Seq[Any](/*457.10*/if(value.size() >0)/*457.29*/{_display_(Seq[Any](format.raw/*457.30*/(""" 
									<tr>
										<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*459.45*/proveedorNombre)),format.raw/*459.60*/(""" - TOTAL</b></td>
										<td><b>"""),_display_(Seq[Any](/*460.19*/utils/*460.24*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*460.54*/("""</b></td>
										<td><b>"""),_display_(Seq[Any](/*461.19*/utils/*461.24*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*461.59*/("""</b></td>
										<td colspan="2"></td>
									</tr>
								""")))})),format.raw/*464.10*/("""
								"""),_display_(Seq[Any](/*465.10*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*465.51*/("""
								"""),_display_(Seq[Any](/*466.10*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*466.56*/("""
								"""),_display_(Seq[Any](/*467.10*/{proveedorId =0})),format.raw/*467.26*/("""
								"""),_display_(Seq[Any](/*468.10*/{bandera = 0})),format.raw/*468.23*/("""
							""")))})),format.raw/*469.9*/("""
							"""),_display_(Seq[Any](/*470.9*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES").size() >0 && xx == 1)/*470.84*/{_display_(Seq[Any](format.raw/*470.85*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*472.44*/proveedorNombre)),format.raw/*472.59*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*473.18*/utils/*473.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*473.53*/("""</b></td>
									<td><b>"""),_display_(Seq[Any](/*474.18*/utils/*474.23*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*474.58*/("""</b></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*477.9*/("""
							"""),_display_(Seq[Any](/*478.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*478.50*/("""
							"""),_display_(Seq[Any](/*479.9*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*479.55*/("""
							"""),_display_(Seq[Any](/*480.9*/{proveedorId =0})),format.raw/*480.25*/("""
							"""),_display_(Seq[Any](/*481.9*/{bandera = 0})),format.raw/*481.22*/("""
							"""),_display_(Seq[Any](/*482.9*/{xx = 0})),format.raw/*482.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*487.17*/utils/*487.22*/.NumberUtils.moneda(mtdpo))),format.raw/*487.48*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*488.17*/utils/*488.22*/.NumberUtils.moneda(mtcpo))),format.raw/*488.48*/("""</b></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*493.6*/("""
			""")))})),format.raw/*494.5*/("""
		""")))})),format.raw/*495.4*/("""	
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*501.4*/if(listaFinal.get("PROFE") != null)/*501.39*/{_display_(Seq[Any](format.raw/*501.40*/("""
			"""),_display_(Seq[Any](/*502.5*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES") != null && listaFinal.get("PROFE").get("HEARM") != null)/*502.115*/{_display_(Seq[Any](format.raw/*502.116*/("""
				<table class="table table-striped table-bordered table-hover" id="listaInforme">
					"""),_display_(Seq[Any](/*504.7*/views/*504.12*/.html.dashboard.deudasGlobalizadas.tablaDetalles("SERVICIOS - PROFE","",proveedor))),format.raw/*504.94*/("""
					<tbody>
					"""),_display_(Seq[Any](/*506.7*/if(listaFinal.get("PROFE").get("HEARM").size() > 0)/*506.58*/{_display_(Seq[Any](format.raw/*506.59*/("""
						"""),_display_(Seq[Any](/*507.8*/for((key,value) <- listaFinal.get("PROFE").get("HEARM")) yield /*507.64*/{_display_(Seq[Any](format.raw/*507.65*/("""
							"""),_display_(Seq[Any](/*508.9*/for(s <- value) yield /*508.24*/{_display_(Seq[Any](format.raw/*508.25*/("""
								"""),_display_(Seq[Any](/*509.10*/if(s.getString("rubro").compareTo("SERVICIOS") == 0)/*509.62*/{_display_(Seq[Any](format.raw/*509.63*/("""
									"""),_display_(Seq[Any](/*510.11*/{xx = 1})),format.raw/*510.19*/("""
									"""),_display_(Seq[Any](/*511.11*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*511.77*/{_display_(Seq[Any](format.raw/*511.78*/("""
										<tr>
											<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*513.46*/proveedorNombre)),format.raw/*513.61*/(""" - TOTAL</b></td>
											<td><b>"""),_display_(Seq[Any](/*514.20*/utils/*514.25*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*514.55*/("""</b></td>
											<td><b>"""),_display_(Seq[Any](/*515.20*/utils/*515.25*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*515.60*/("""</b></td>
											<td colspan="2"></td>
										</tr>
										<tr><td colspan="8"></td></tr>
										"""),_display_(Seq[Any](/*519.12*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*519.53*/("""
										"""),_display_(Seq[Any](/*520.12*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*520.58*/("""
										"""),_display_(Seq[Any](/*521.12*/{bandera = 0})),format.raw/*521.25*/("""
									""")))})),format.raw/*522.11*/(""" 
									"""),_display_(Seq[Any](/*523.11*/if(bandera == 0)/*523.27*/{_display_(Seq[Any](format.raw/*523.28*/("""
										<tr style="background-color:#dfdfdf;">
											<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*525.47*/s/*525.48*/.getString("nombre_proveedor"))),format.raw/*525.78*/("""</b></td>
										</tr>
										"""),_display_(Seq[Any](/*527.12*/{bandera = 1})),format.raw/*527.25*/("""
									""")))})),format.raw/*528.11*/("""
									"""),_display_(Seq[Any](/*529.11*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*529.70*/("""
									"""),_display_(Seq[Any](/*530.11*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*530.85*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*532.16*/s/*532.17*/.getInteger("numeroProvision"))),format.raw/*532.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*533.16*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*533.74*/("""</td>
										<td>"""),_display_(Seq[Any](/*534.16*/s/*534.17*/.getString("expediente"))),format.raw/*534.41*/("""</td>
										<td>"""),_display_(Seq[Any](/*535.16*/s/*535.17*/.getString("nombre_proveedor"))),format.raw/*535.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*536.16*/utils/*536.21*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*536.72*/("""</td>
										<td>"""),_display_(Seq[Any](/*537.16*/utils/*537.21*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*537.77*/("""</td>
										<td>"""),_display_(Seq[Any](/*538.16*/s/*538.17*/.getString("rubro"))),format.raw/*538.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*539.16*/s/*539.17*/.getString("descripcion"))),format.raw/*539.42*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*541.11*/{mtdps= mtdps.add(s.getBigDecimal("total_deuda"))})),format.raw/*541.61*/("""
									"""),_display_(Seq[Any](/*542.11*/{mtcps= mtcps.add(s.getBigDecimal("total_compromiso"))})),format.raw/*542.66*/("""
									"""),_display_(Seq[Any](/*543.11*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*543.54*/("""
									"""),_display_(Seq[Any](/*544.11*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*544.62*/("""
								""")))})),format.raw/*545.10*/("""	
							""")))})),format.raw/*546.9*/("""
							 
						""")))})),format.raw/*548.8*/("""
						"""),_display_(Seq[Any](/*549.8*/if(listaFinal.get("PROFE").get("HEARM").size() >0 && xx == 1)/*549.69*/{_display_(Seq[Any](format.raw/*549.70*/(""" 
							<tr>
								<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*551.43*/proveedorNombre)),format.raw/*551.58*/(""" - TOTAL</b></td>
								<td><b>"""),_display_(Seq[Any](/*552.17*/utils/*552.22*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*552.52*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*553.17*/utils/*553.22*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*553.57*/("""</b></td>
								<td colspan="2"></td>
							</tr>
						""")))})),format.raw/*556.8*/("""
						"""),_display_(Seq[Any](/*557.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*557.49*/("""
						"""),_display_(Seq[Any](/*558.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*558.54*/("""
						"""),_display_(Seq[Any](/*559.8*/{proveedorId =0})),format.raw/*559.24*/("""
						"""),_display_(Seq[Any](/*560.8*/{bandera = 0})),format.raw/*560.21*/("""
						"""),_display_(Seq[Any](/*561.8*/{xx = 0})),format.raw/*561.16*/("""
					""")))})),format.raw/*562.7*/("""
					"""),_display_(Seq[Any](/*563.7*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES").size() > 0)/*563.72*/{_display_(Seq[Any](format.raw/*563.73*/("""
						"""),_display_(Seq[Any](/*564.8*/for((key,value) <- listaFinal.get("PROFE").get("OTRAS INSTITUCIONES")) yield /*564.78*/{_display_(Seq[Any](format.raw/*564.79*/("""
							"""),_display_(Seq[Any](/*565.9*/for(s <- value) yield /*565.24*/{_display_(Seq[Any](format.raw/*565.25*/("""
								"""),_display_(Seq[Any](/*566.10*/if(s.getString("rubro").compareTo("SERVICIOS") == 0)/*566.62*/{_display_(Seq[Any](format.raw/*566.63*/("""
									"""),_display_(Seq[Any](/*567.11*/{xx = 1})),format.raw/*567.19*/("""
									"""),_display_(Seq[Any](/*568.11*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*568.77*/{_display_(Seq[Any](format.raw/*568.78*/("""
										<tr>
											<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*570.46*/proveedorNombre)),format.raw/*570.61*/(""" - TOTAL</b></td>
											<td><b>"""),_display_(Seq[Any](/*571.20*/utils/*571.25*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*571.55*/("""</b></td>
											<td><b>"""),_display_(Seq[Any](/*572.20*/utils/*572.25*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*572.60*/("""</b></td>
											<td colspan="2"></td>
										</tr>
										<tr><td colspan="8"></td></tr>
										"""),_display_(Seq[Any](/*576.12*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*576.53*/("""
										"""),_display_(Seq[Any](/*577.12*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*577.58*/("""
										"""),_display_(Seq[Any](/*578.12*/{bandera = 0})),format.raw/*578.25*/("""
									""")))})),format.raw/*579.11*/(""" 
									"""),_display_(Seq[Any](/*580.11*/if(bandera == 0)/*580.27*/{_display_(Seq[Any](format.raw/*580.28*/("""
										<tr style="background-color:#dfdfdf;">
											<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*582.47*/s/*582.48*/.getString("nombre_proveedor"))),format.raw/*582.78*/("""</b></td>
										</tr>
										"""),_display_(Seq[Any](/*584.12*/{bandera = 1})),format.raw/*584.25*/("""
									""")))})),format.raw/*585.11*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*587.16*/s/*587.17*/.getInteger("numeroProvision"))),format.raw/*587.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*588.16*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*588.74*/("""</td>
										<td>"""),_display_(Seq[Any](/*589.16*/s/*589.17*/.getString("expediente"))),format.raw/*589.41*/("""</td>
										<td>"""),_display_(Seq[Any](/*590.16*/s/*590.17*/.getString("nombre_proveedor"))),format.raw/*590.47*/("""</td>
										<td>"""),_display_(Seq[Any](/*591.16*/utils/*591.21*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*591.72*/("""</td>
										<td>"""),_display_(Seq[Any](/*592.16*/utils/*592.21*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*592.77*/("""</td>
										<td>"""),_display_(Seq[Any](/*593.16*/s/*593.17*/.getString("rubro"))),format.raw/*593.36*/("""</td>
										<td>"""),_display_(Seq[Any](/*594.16*/s/*594.17*/.getString("descripcion"))),format.raw/*594.42*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*596.11*/{mtdps= mtdps.add(s.getBigDecimal("total_deuda"))})),format.raw/*596.61*/("""
									"""),_display_(Seq[Any](/*597.11*/{mtcps= mtcps.add(s.getBigDecimal("total_compromiso"))})),format.raw/*597.66*/("""
									"""),_display_(Seq[Any](/*598.11*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*598.54*/("""
									"""),_display_(Seq[Any](/*599.11*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*599.62*/("""
								""")))})),format.raw/*600.10*/("""	
							""")))})),format.raw/*601.9*/("""
						""")))})),format.raw/*602.8*/("""
						"""),_display_(Seq[Any](/*603.8*/if(listaFinal.get("PROFE").get("OTRAS INSTITUCIONES").size() >0 && xx == 1)/*603.83*/{_display_(Seq[Any](format.raw/*603.84*/(""" 
							<tr>
								<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*605.43*/proveedorNombre)),format.raw/*605.58*/(""" - TOTAL</b></td>
								<td><b>"""),_display_(Seq[Any](/*606.17*/utils/*606.22*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*606.52*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*607.17*/utils/*607.22*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*607.57*/("""</b></td>
								<td colspan="2"></td>
							</tr>
						""")))})),format.raw/*610.8*/("""
						"""),_display_(Seq[Any](/*611.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*611.49*/("""
						"""),_display_(Seq[Any](/*612.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*612.54*/("""
						"""),_display_(Seq[Any](/*613.8*/{proveedorId =0})),format.raw/*613.24*/("""
						"""),_display_(Seq[Any](/*614.8*/{bandera = 0})),format.raw/*614.21*/("""
						"""),_display_(Seq[Any](/*615.8*/{xx = 0})),format.raw/*615.16*/("""
					""")))})),format.raw/*616.7*/("""
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4" align="right"><b>TOTALES</b></td>
							<td><b>"""),_display_(Seq[Any](/*621.16*/utils/*621.21*/.NumberUtils.moneda(mtdps))),format.raw/*621.47*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*622.16*/utils/*622.21*/.NumberUtils.moneda(mtcps))),format.raw/*622.47*/("""</b></td>
							<td colspan="2" align="right"></td>
						</tr>
					</tfoot>
				</table>
			""")))})),format.raw/*627.5*/("""
		""")))})),format.raw/*628.4*/("""	
	</div>
</div>


""")))})),format.raw/*633.2*/("""
 

"""))}
    }
    
    def render(ra:Boolean,idProveedor:Integer,listaFinal:java.util.Map[String, java.util.Map[String, java.util.Map[Integer, List[com.avaje.ebean.SqlRow]]]],proveedor:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(ra,idProveedor,listaFinal,proveedor,formBuscador)
    
    def f:((Boolean,Integer,java.util.Map[String, java.util.Map[String, java.util.Map[Integer, List[com.avaje.ebean.SqlRow]]]],String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (ra,idProveedor,listaFinal,proveedor,formBuscador) => apply(ra,idProveedor,listaFinal,proveedor,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:54 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallas.scala.html
                    HASH: 5d8802b275a4d38e76bc7409909f7485e73a254e
                    MATRIX: 939->1|1910->186|1946->881|1958->886|2014->934|2053->936|2091->939|2104->944|2184->1002|2318->1100|2349->1109|2856->1580|2876->1591|2991->1683|3169->1826|3217->1865|3256->1866|3296->1871|3357->1923|3396->1924|3437->1930|3501->1985|3540->1986|3669->2080|3683->2085|3784->2164|3842->2187|3918->2247|3957->2248|4003->2258|4034->2273|4073->2274|4120->2285|4181->2337|4220->2338|4268->2350|4298->2358|4346->2370|4421->2436|4460->2437|4559->2500|4596->2515|4670->2553|4684->2558|4736->2588|4802->2618|4816->2623|4873->2658|5024->2773|5087->2814|5136->2827|5204->2873|5253->2886|5288->2899|5332->2911|5381->2924|5406->2940|5445->2941|5579->3039|5589->3040|5641->3070|5716->3109|5751->3122|5795->3134|5843->3146|5924->3205|5972->3217|6068->3291|6136->3323|6146->3324|6198->3354|6256->3376|6336->3434|6394->3456|6404->3457|6450->3481|6508->3503|6518->3504|6570->3534|6628->3556|6642->3561|6715->3612|6773->3634|6787->3639|6865->3695|6923->3717|6933->3718|6974->3737|7032->3759|7042->3760|7089->3785|7158->3818|7230->3868|7278->3880|7355->3935|7414->3958|7479->4001|7527->4013|7600->4064|7643->4075|7685->4085|7734->4103|7778->4112|7852->4177|7891->4178|7985->4236|8022->4251|8093->4286|8107->4291|8159->4321|8222->4348|8236->4353|8293->4388|8387->4451|8431->4460|8494->4501|8538->4510|8606->4556|8650->4565|8688->4581|8732->4590|8767->4603|8811->4612|8841->4620|8994->4736|9009->4741|9058->4767|9121->4793|9136->4798|9185->4824|9318->4925|9355->4930|9391->4934|9509->5016|9558->5055|9598->5056|9639->5061|9715->5127|9755->5128|9797->5134|9876->5203|9916->5204|10046->5298|10061->5303|10178->5396|10237->5419|10328->5493|10368->5494|10415->5504|10447->5519|10487->5520|10535->5531|10597->5583|10637->5584|10686->5596|10717->5604|10766->5616|10842->5682|10882->5683|10982->5746|11020->5761|11095->5799|11110->5804|11163->5834|11230->5864|11245->5869|11303->5904|11455->6019|11519->6060|11569->6073|11638->6119|11688->6132|11724->6145|11769->6157|11819->6170|11845->6186|11885->6187|12020->6285|12031->6286|12084->6316|12160->6355|12196->6368|12241->6380|12290->6392|12372->6451|12421->6463|12518->6537|12587->6569|12598->6570|12651->6600|12710->6622|12791->6680|12850->6702|12861->6703|12908->6727|12967->6749|12978->6750|13031->6780|13090->6802|13105->6807|13179->6858|13238->6880|13253->6885|13332->6941|13391->6963|13402->6964|13444->6983|13503->7005|13514->7006|13562->7031|13632->7064|13705->7114|13754->7126|13832->7181|13881->7193|13947->7236|13996->7248|14070->7299|14114->7310|14158->7321|14209->7340|14254->7349|14343->7428|14383->7429|14478->7487|14516->7502|14588->7537|14603->7542|14656->7572|14720->7599|14735->7604|14793->7639|14888->7702|14933->7711|14997->7752|15042->7761|15111->7807|15156->7816|15195->7832|15240->7841|15276->7854|15321->7863|15352->7871|15505->7987|15520->7992|15569->8018|15632->8044|15647->8049|15696->8075|15829->8176|15866->8181|15902->8185|16021->8268|16070->8307|16110->8308|16151->8313|16280->8431|16321->8432|16449->8524|16464->8529|16573->8615|16629->8635|16694->8690|16734->8691|16778->8699|16855->8759|16895->8760|16940->8769|16972->8784|17012->8785|17059->8795|17121->8847|17161->8848|17209->8859|17240->8867|17288->8878|17364->8944|17404->8945|17502->9006|17540->9021|17614->9058|17629->9063|17682->9093|17748->9122|17763->9127|17821->9162|17969->9273|18033->9314|18082->9326|18151->9372|18200->9384|18236->9397|18280->9408|18329->9420|18355->9436|18395->9437|18528->9533|18539->9534|18592->9564|18666->9601|18702->9614|18746->9625|18794->9636|18876->9695|18924->9706|19021->9780|19088->9810|19099->9811|19152->9841|19210->9862|19291->9920|19349->9941|19360->9942|19407->9966|19465->9987|19476->9988|19529->10018|19587->10039|19602->10044|19676->10095|19734->10116|19749->10121|19828->10177|19886->10198|19897->10199|19939->10218|19997->10239|20008->10240|20056->10265|20124->10296|20197->10346|20245->10357|20323->10412|20371->10423|20437->10466|20485->10477|20559->10528|20602->10538|20644->10548|20684->10556|20728->10564|20803->10629|20843->10630|20936->10686|20974->10701|21045->10735|21060->10740|21113->10770|21176->10796|21191->10801|21249->10836|21341->10896|21385->10904|21449->10945|21493->10953|21562->10999|21606->11007|21645->11023|21689->11031|21725->11044|21769->11052|21800->11060|21839->11067|21882->11074|21961->11143|22001->11144|22045->11152|22136->11226|22176->11227|22221->11236|22253->11251|22293->11252|22340->11262|22402->11314|22442->11315|22490->11326|22521->11334|22569->11345|22645->11411|22685->11412|22783->11473|22821->11488|22895->11525|22910->11530|22963->11560|23029->11589|23044->11594|23102->11629|23250->11740|23314->11781|23363->11793|23432->11839|23481->11851|23517->11864|23561->11875|23610->11887|23636->11903|23676->11904|23809->12000|23820->12001|23873->12031|23947->12068|23983->12081|24027->12092|24075->12103|24157->12162|24205->12173|24302->12247|24369->12277|24380->12278|24433->12308|24491->12329|24572->12387|24630->12408|24641->12409|24688->12433|24746->12454|24757->12455|24810->12485|24868->12506|24883->12511|24957->12562|25015->12583|25030->12588|25109->12644|25167->12665|25178->12666|25220->12685|25278->12706|25289->12707|25337->12732|25405->12763|25478->12813|25526->12824|25604->12879|25652->12890|25718->12933|25766->12944|25840->12995|25883->13005|25925->13015|25974->13032|26021->13042|26110->13121|26150->13122|26243->13178|26281->13193|26352->13227|26367->13232|26420->13262|26483->13288|26498->13293|26556->13328|26651->13390|26695->13398|26759->13439|26803->13447|26872->13493|26916->13501|26955->13517|26999->13525|27035->13538|27079->13546|27110->13554|27149->13561|27297->13672|27312->13677|27361->13703|27423->13728|27438->13733|27487->13759|27615->13855|27651->13859|27772->13944|27817->13979|27857->13980|27898->13985|27956->14033|27996->14034|28038->14040|28099->14091|28139->14092|28269->14186|28284->14191|28382->14266|28441->14289|28514->14345|28554->14346|28601->14356|28633->14371|28673->14372|28721->14383|28783->14435|28823->14436|28872->14448|28903->14456|28952->14468|29028->14534|29068->14535|29168->14598|29206->14613|29281->14651|29296->14656|29349->14686|29416->14716|29431->14721|29489->14756|29641->14871|29705->14912|29755->14925|29824->14971|29874->14984|29910->14997|29955->15009|30005->15022|30031->15038|30071->15039|30206->15137|30217->15138|30270->15168|30346->15207|30382->15220|30427->15232|30476->15244|30558->15303|30607->15315|30704->15389|30773->15421|30784->15422|30837->15452|30896->15474|30977->15532|31036->15554|31047->15555|31094->15579|31153->15601|31164->15602|31217->15632|31276->15654|31291->15659|31365->15710|31424->15732|31439->15737|31518->15793|31577->15815|31588->15816|31630->15835|31689->15857|31700->15858|31748->15883|31818->15916|31891->15966|31940->15978|32018->16033|32067->16045|32133->16088|32182->16100|32256->16151|32300->16162|32343->16172|32394->16191|32439->16200|32510->16261|32550->16262|32645->16320|32683->16335|32755->16370|32770->16375|32823->16405|32887->16432|32902->16437|32960->16472|33055->16535|33100->16544|33164->16585|33209->16594|33278->16640|33323->16649|33362->16665|33407->16674|33443->16687|33488->16696|33519->16704|33672->16820|33687->16825|33736->16851|33799->16877|33814->16882|33863->16908|33996->17009|34033->17014|34069->17018|34187->17100|34232->17135|34272->17136|34313->17141|34385->17203|34425->17204|34467->17210|34542->17275|34582->17276|34712->17370|34727->17375|34840->17464|34899->17487|34986->17557|35026->17558|35073->17568|35105->17583|35145->17584|35193->17595|35255->17647|35295->17648|35344->17660|35375->17668|35424->17680|35500->17746|35540->17747|35640->17810|35678->17825|35753->17863|35768->17868|35821->17898|35888->17928|35903->17933|35961->17968|36113->18083|36177->18124|36227->18137|36296->18183|36346->18196|36382->18209|36427->18221|36477->18234|36503->18250|36543->18251|36678->18349|36689->18350|36742->18380|36818->18419|36854->18432|36899->18444|36948->18456|37030->18515|37079->18527|37176->18601|37245->18633|37256->18634|37309->18664|37368->18686|37449->18744|37508->18766|37519->18767|37566->18791|37625->18813|37636->18814|37689->18844|37748->18866|37763->18871|37837->18922|37896->18944|37911->18949|37990->19005|38049->19027|38060->19028|38102->19047|38161->19069|38172->19070|38220->19095|38290->19128|38363->19178|38412->19190|38490->19245|38539->19257|38605->19300|38654->19312|38728->19363|38772->19374|38815->19384|38862->19394|38891->19413|38931->19414|39028->19474|39066->19489|39139->19525|39154->19530|39207->19560|39272->19588|39287->19593|39345->19628|39444->19694|39491->19704|39555->19745|39602->19755|39671->19801|39718->19811|39757->19827|39804->19837|39840->19850|39881->19859|39926->19868|40011->19943|40051->19944|40146->20002|40184->20017|40256->20052|40271->20057|40324->20087|40388->20114|40403->20119|40461->20154|40556->20217|40601->20226|40665->20267|40710->20276|40779->20322|40824->20331|40863->20347|40908->20356|40944->20369|40989->20378|41020->20386|41173->20502|41188->20507|41237->20533|41300->20559|41315->20564|41364->20590|41497->20691|41534->20696|41570->20700|41689->20783|41734->20818|41774->20819|41815->20824|41936->20934|41977->20935|42105->21027|42120->21032|42225->21114|42281->21134|42342->21185|42382->21186|42426->21194|42499->21250|42539->21251|42584->21260|42616->21275|42656->21276|42703->21286|42765->21338|42805->21339|42853->21350|42884->21358|42932->21369|43008->21435|43048->21436|43146->21497|43184->21512|43258->21549|43273->21554|43326->21584|43392->21613|43407->21618|43465->21653|43613->21764|43677->21805|43726->21817|43795->21863|43844->21875|43880->21888|43924->21899|43973->21911|43999->21927|44039->21928|44172->22024|44183->22025|44236->22055|44310->22092|44346->22105|44390->22116|44438->22127|44520->22186|44568->22197|44665->22271|44732->22301|44743->22302|44796->22332|44854->22353|44935->22411|44993->22432|45004->22433|45051->22457|45109->22478|45120->22479|45173->22509|45231->22530|45246->22535|45320->22586|45378->22607|45393->22612|45472->22668|45530->22689|45541->22690|45583->22709|45641->22730|45652->22731|45700->22756|45768->22787|45841->22837|45889->22848|45967->22903|46015->22914|46081->22957|46129->22968|46203->23019|46246->23029|46288->23039|46337->23056|46381->23064|46452->23125|46492->23126|46585->23182|46623->23197|46694->23231|46709->23236|46762->23266|46825->23292|46840->23297|46898->23332|46990->23392|47034->23400|47098->23441|47142->23449|47211->23495|47255->23503|47294->23519|47338->23527|47374->23540|47418->23548|47449->23556|47488->23563|47531->23570|47606->23635|47646->23636|47690->23644|47777->23714|47817->23715|47862->23724|47894->23739|47934->23740|47981->23750|48043->23802|48083->23803|48131->23814|48162->23822|48210->23833|48286->23899|48326->23900|48424->23961|48462->23976|48536->24013|48551->24018|48604->24048|48670->24077|48685->24082|48743->24117|48891->24228|48955->24269|49004->24281|49073->24327|49122->24339|49158->24352|49202->24363|49251->24375|49277->24391|49317->24392|49450->24488|49461->24489|49514->24519|49588->24556|49624->24569|49668->24580|49735->24610|49746->24611|49799->24641|49857->24662|49938->24720|49996->24741|50007->24742|50054->24766|50112->24787|50123->24788|50176->24818|50234->24839|50249->24844|50323->24895|50381->24916|50396->24921|50475->24977|50533->24998|50544->24999|50586->25018|50644->25039|50655->25040|50703->25065|50771->25096|50844->25146|50892->25157|50970->25212|51018->25223|51084->25266|51132->25277|51206->25328|51249->25338|51291->25348|51331->25356|51375->25364|51460->25439|51500->25440|51593->25496|51631->25511|51702->25545|51717->25550|51770->25580|51833->25606|51848->25611|51906->25646|51998->25706|52042->25714|52106->25755|52150->25763|52219->25809|52263->25817|52302->25833|52346->25841|52382->25854|52426->25862|52457->25870|52496->25877|52644->25988|52659->25993|52708->26019|52770->26044|52785->26049|52834->26075|52962->26171|52998->26175|53050->26195
                    LINES: 26->1|37->4|38->8|38->8|38->8|38->8|40->10|40->10|40->10|45->15|45->15|58->28|58->28|58->28|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|72->42|72->42|72->42|74->44|74->44|74->44|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|78->48|78->48|78->48|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|86->56|86->56|87->57|87->57|88->58|88->58|89->59|90->60|90->60|90->60|92->62|92->62|92->62|94->64|94->64|95->65|96->66|96->66|97->67|97->67|99->69|99->69|99->69|100->70|100->70|101->71|101->71|101->71|102->72|102->72|102->72|103->73|103->73|103->73|104->74|104->74|104->74|105->75|105->75|105->75|106->76|106->76|106->76|108->78|108->78|109->79|109->79|111->81|111->81|112->82|112->82|113->83|114->84|116->86|117->87|117->87|117->87|119->89|119->89|120->90|120->90|120->90|121->91|121->91|121->91|124->94|125->95|125->95|126->96|126->96|127->97|127->97|128->98|128->98|129->99|129->99|134->104|134->104|134->104|135->105|135->105|135->105|140->110|141->111|142->112|147->117|147->117|147->117|148->118|148->118|148->118|149->119|149->119|149->119|151->121|151->121|151->121|153->123|153->123|153->123|154->124|154->124|154->124|155->125|155->125|155->125|156->126|156->126|157->127|157->127|157->127|159->129|159->129|160->130|160->130|160->130|161->131|161->131|161->131|165->135|165->135|166->136|166->136|167->137|167->137|168->138|169->139|169->139|169->139|171->141|171->141|171->141|173->143|173->143|174->144|175->145|175->145|176->146|176->146|178->148|178->148|178->148|179->149|179->149|180->150|180->150|180->150|181->151|181->151|181->151|182->152|182->152|182->152|183->153|183->153|183->153|184->154|184->154|184->154|185->155|185->155|185->155|187->157|187->157|188->158|188->158|189->159|189->159|190->160|190->160|191->161|192->162|194->164|195->165|195->165|195->165|197->167|197->167|198->168|198->168|198->168|199->169|199->169|199->169|202->172|203->173|203->173|204->174|204->174|205->175|205->175|206->176|206->176|207->177|207->177|212->182|212->182|212->182|213->183|213->183|213->183|218->188|219->189|220->190|226->196|226->196|226->196|227->197|227->197|227->197|229->199|229->199|229->199|231->201|231->201|231->201|232->202|232->202|232->202|233->203|233->203|233->203|234->204|234->204|234->204|235->205|235->205|236->206|236->206|236->206|238->208|238->208|239->209|239->209|239->209|240->210|240->210|240->210|244->214|244->214|245->215|245->215|246->216|246->216|247->217|248->218|248->218|248->218|250->220|250->220|250->220|252->222|252->222|253->223|254->224|254->224|255->225|255->225|257->227|257->227|257->227|258->228|258->228|259->229|259->229|259->229|260->230|260->230|260->230|261->231|261->231|261->231|262->232|262->232|262->232|263->233|263->233|263->233|264->234|264->234|264->234|266->236|266->236|267->237|267->237|268->238|268->238|269->239|269->239|270->240|271->241|272->242|273->243|273->243|273->243|275->245|275->245|276->246|276->246|276->246|277->247|277->247|277->247|280->250|281->251|281->251|282->252|282->252|283->253|283->253|284->254|284->254|285->255|285->255|286->256|287->257|287->257|287->257|288->258|288->258|288->258|289->259|289->259|289->259|290->260|290->260|290->260|291->261|291->261|292->262|292->262|292->262|294->264|294->264|295->265|295->265|295->265|296->266|296->266|296->266|300->270|300->270|301->271|301->271|302->272|302->272|303->273|304->274|304->274|304->274|306->276|306->276|306->276|308->278|308->278|309->279|310->280|310->280|311->281|311->281|313->283|313->283|313->283|314->284|314->284|315->285|315->285|315->285|316->286|316->286|316->286|317->287|317->287|317->287|318->288|318->288|318->288|319->289|319->289|319->289|320->290|320->290|320->290|322->292|322->292|323->293|323->293|324->294|324->294|325->295|325->295|326->296|327->297|329->299|330->300|330->300|330->300|332->302|332->302|333->303|333->303|333->303|334->304|334->304|334->304|337->307|338->308|338->308|339->309|339->309|340->310|340->310|341->311|341->311|342->312|342->312|343->313|348->318|348->318|348->318|349->319|349->319|349->319|354->324|355->325|363->333|363->333|363->333|364->334|364->334|364->334|365->335|365->335|365->335|367->337|367->337|367->337|369->339|369->339|369->339|370->340|370->340|370->340|371->341|371->341|371->341|372->342|372->342|373->343|373->343|373->343|375->345|375->345|376->346|376->346|376->346|377->347|377->347|377->347|381->351|381->351|382->352|382->352|383->353|383->353|384->354|385->355|385->355|385->355|387->357|387->357|387->357|389->359|389->359|390->360|391->361|391->361|392->362|392->362|394->364|394->364|394->364|395->365|395->365|396->366|396->366|396->366|397->367|397->367|397->367|398->368|398->368|398->368|399->369|399->369|399->369|400->370|400->370|400->370|401->371|401->371|401->371|403->373|403->373|404->374|404->374|405->375|405->375|406->376|406->376|407->377|408->378|410->380|411->381|411->381|411->381|413->383|413->383|414->384|414->384|414->384|415->385|415->385|415->385|418->388|419->389|419->389|420->390|420->390|421->391|421->391|422->392|422->392|423->393|423->393|428->398|428->398|428->398|429->399|429->399|429->399|434->404|435->405|436->406|441->411|441->411|441->411|442->412|442->412|442->412|443->413|443->413|443->413|445->415|445->415|445->415|447->417|447->417|447->417|448->418|448->418|448->418|449->419|449->419|449->419|450->420|450->420|451->421|451->421|451->421|453->423|453->423|454->424|454->424|454->424|455->425|455->425|455->425|459->429|459->429|460->430|460->430|461->431|461->431|462->432|463->433|463->433|463->433|465->435|465->435|465->435|467->437|467->437|468->438|469->439|469->439|470->440|470->440|472->442|472->442|472->442|473->443|473->443|474->444|474->444|474->444|475->445|475->445|475->445|476->446|476->446|476->446|477->447|477->447|477->447|478->448|478->448|478->448|479->449|479->449|479->449|481->451|481->451|482->452|482->452|483->453|483->453|484->454|484->454|485->455|486->456|487->457|487->457|487->457|489->459|489->459|490->460|490->460|490->460|491->461|491->461|491->461|494->464|495->465|495->465|496->466|496->466|497->467|497->467|498->468|498->468|499->469|500->470|500->470|500->470|502->472|502->472|503->473|503->473|503->473|504->474|504->474|504->474|507->477|508->478|508->478|509->479|509->479|510->480|510->480|511->481|511->481|512->482|512->482|517->487|517->487|517->487|518->488|518->488|518->488|523->493|524->494|525->495|531->501|531->501|531->501|532->502|532->502|532->502|534->504|534->504|534->504|536->506|536->506|536->506|537->507|537->507|537->507|538->508|538->508|538->508|539->509|539->509|539->509|540->510|540->510|541->511|541->511|541->511|543->513|543->513|544->514|544->514|544->514|545->515|545->515|545->515|549->519|549->519|550->520|550->520|551->521|551->521|552->522|553->523|553->523|553->523|555->525|555->525|555->525|557->527|557->527|558->528|559->529|559->529|560->530|560->530|562->532|562->532|562->532|563->533|563->533|564->534|564->534|564->534|565->535|565->535|565->535|566->536|566->536|566->536|567->537|567->537|567->537|568->538|568->538|568->538|569->539|569->539|569->539|571->541|571->541|572->542|572->542|573->543|573->543|574->544|574->544|575->545|576->546|578->548|579->549|579->549|579->549|581->551|581->551|582->552|582->552|582->552|583->553|583->553|583->553|586->556|587->557|587->557|588->558|588->558|589->559|589->559|590->560|590->560|591->561|591->561|592->562|593->563|593->563|593->563|594->564|594->564|594->564|595->565|595->565|595->565|596->566|596->566|596->566|597->567|597->567|598->568|598->568|598->568|600->570|600->570|601->571|601->571|601->571|602->572|602->572|602->572|606->576|606->576|607->577|607->577|608->578|608->578|609->579|610->580|610->580|610->580|612->582|612->582|612->582|614->584|614->584|615->585|617->587|617->587|617->587|618->588|618->588|619->589|619->589|619->589|620->590|620->590|620->590|621->591|621->591|621->591|622->592|622->592|622->592|623->593|623->593|623->593|624->594|624->594|624->594|626->596|626->596|627->597|627->597|628->598|628->598|629->599|629->599|630->600|631->601|632->602|633->603|633->603|633->603|635->605|635->605|636->606|636->606|636->606|637->607|637->607|637->607|640->610|641->611|641->611|642->612|642->612|643->613|643->613|644->614|644->614|645->615|645->615|646->616|651->621|651->621|651->621|652->622|652->622|652->622|657->627|658->628|663->633
                    -- GENERATED --
                */
            