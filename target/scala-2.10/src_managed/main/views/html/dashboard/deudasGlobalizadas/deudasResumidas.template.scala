
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
object deudasResumidas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template18[String,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Integer,Boolean,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(depositonNombre: String,
proveedoresDestacados: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosServicios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacados: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosServicios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosEquipos: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosProfe: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosProfeServicios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosProfe: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosProfeServicios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosProfeEquipos: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosHonorarios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosHonorarios: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosProfeHonorarios: List[com.avaje.ebean.SqlRow],
proveedoresNoDestacadosProfeHonorarios: List[com.avaje.ebean.SqlRow],
deposito:Integer,ra:Boolean,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var hayra:Boolean = new Boolean(false);var monto_total_deuda_profeho=new java.math.BigDecimal(0);var monto_total_compromiso_profeho=new java.math.BigDecimal(0);var monto_total_deudasho=new java.math.BigDecimal(0);var monto_total_compromisosho=new java.math.BigDecimal(0);var monto_total_ra_tmp=new java.math.BigDecimal(0);var monto_total_compromiso_ra_tmp=new java.math.BigDecimal(0);var monto_total_deuda_profe_nde=new java.math.BigDecimal(0);var monto_total_compromiso_profe_nde=new java.math.BigDecimal(0);var monto_total_deuda_nde=new java.math.BigDecimal(0);var monto_total_compromiso_nde=new java.math.BigDecimal(0);var monto_total_deuda_profens=new java.math.BigDecimal(0);var monto_total_compromiso_profens=new java.math.BigDecimal(0);var monto_total_deuda_profess=new java.math.BigDecimal(0);var monto_total_compromiso_profess=new java.math.BigDecimal(0);var monto_total_compromisoss=new java.math.BigDecimal(0);var monto_total_deudass=new java.math.BigDecimal(0);var monto_total_compromisons=new java.math.BigDecimal(0);var monto_total_deudans=new java.math.BigDecimal(0);var monto_total_deuda_nd=new java.math.BigDecimal(0);var monto_total_compromiso_nd=new java.math.BigDecimal(0);var monto_total_deuda=new java.math.BigDecimal(0);var monto_total_compromiso=new java.math.BigDecimal(0);var monto_total_deuda_profe=new java.math.BigDecimal(0);var monto_total_compromiso_profe=new java.math.BigDecimal(0);var monto_total_deuda_profe_nd=new java.math.BigDecimal(0);var monto_total_compromiso_profe_nd=new java.math.BigDecimal(0) 

implicit def /*20.2*/implicitFieldConstructor/*20.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*16.55*/("""
"""),format.raw/*20.70*/("""
"""),format.raw/*22.1*/("""



"""),_display_(Seq[Any](/*26.2*/views/*26.7*/.html.dashboard.mainDashboard("Deudas Resumen")/*26.54*/ {_display_(Seq[Any](format.raw/*26.56*/("""
"""),_display_(Seq[Any](/*27.2*/views/*27.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*27.65*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Resumen - """),_display_(Seq[Any](/*31.26*/depositonNombre)),format.raw/*31.41*/("""</h1>
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
			  href=""""),_display_(Seq[Any](/*44.13*/controllers/*44.24*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasResumidasReporte(deposito,ra))),format.raw/*44.114*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*52.4*/if(proveedoresDestacados.size() > 0 || proveedoresDestacadosServicios.size() > 0 || proveedoresNoDestacados.size() > 0 || proveedoresNoDestacadosServicios.size() > 0)/*52.170*/{_display_(Seq[Any](format.raw/*52.171*/("""
		<table class="table table-striped table-bordered table-hover" id="listaInforme">
			<thead>
				<th colspan="3" align="center" style="font-size:20px;text-align:center;">OPERATIVA</th>
			</thead>
			<thead>
				<th width="600">PROVEDORES</th>
				<th>MONTO DEUDA</th>
				<th>MONTRO COMPROMISO</th>
			</thead>
			<tbody>
					 
					"""),_display_(Seq[Any](/*64.7*/if(proveedoresDestacados.size() > 0 || proveedoresNoDestacados.size() > 0)/*64.81*/{_display_(Seq[Any](format.raw/*64.82*/("""
						
						"""),_display_(Seq[Any](/*66.8*/if(!ra)/*66.15*/{_display_(Seq[Any](format.raw/*66.16*/("""
							"""),_display_(Seq[Any](/*67.9*/for(pd <- proveedoresDestacados) yield /*67.41*/ {_display_(Seq[Any](format.raw/*67.43*/("""
								"""),_display_(Seq[Any](/*68.10*/if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id")))/*68.89*/{_display_(Seq[Any](format.raw/*68.90*/("""
									"""),_display_(Seq[Any](/*69.11*/{monto_total_ra_tmp= monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"))})),format.raw/*69.88*/("""<!-- +total deuda ra tmp-->
									"""),_display_(Seq[Any](/*70.11*/{monto_total_compromiso_ra_tmp= monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*70.115*/("""<!-- +total compromiso ra tmp -->
								""")))})),format.raw/*71.10*/("""
								"""),_display_(Seq[Any](/*72.10*/{hayra = new Boolean(true)})),format.raw/*72.37*/("""
							""")))})),format.raw/*73.9*/("""
							
							"""),_display_(Seq[Any](/*75.9*/if(hayra)/*75.18*/{_display_(Seq[Any](format.raw/*75.19*/("""
							<tr>
								<td>RA</td>
								<td>"""),_display_(Seq[Any](/*78.14*/utils/*78.19*/.NumberUtils.moneda(monto_total_ra_tmp))),format.raw/*78.58*/("""</td>
								<td>"""),_display_(Seq[Any](/*79.14*/utils/*79.19*/.NumberUtils.moneda(monto_total_compromiso_ra_tmp))),format.raw/*79.69*/("""  </td>
							</tr>
							""")))})),format.raw/*81.9*/("""
						""")))})),format.raw/*82.8*/("""
						
						"""),_display_(Seq[Any](/*84.8*/for(pd <- proveedoresDestacados) yield /*84.40*/ {_display_(Seq[Any](format.raw/*84.42*/("""
							"""),_display_(Seq[Any](/*85.9*/if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id")))/*85.96*/{_display_(Seq[Any](format.raw/*85.97*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*87.15*/pd/*87.17*/.getString("nombre_proveedor"))),format.raw/*87.47*/("""</td>
									<td>"""),_display_(Seq[Any](/*88.15*/utils/*88.20*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*88.72*/("""</td>
									<td>"""),_display_(Seq[Any](/*89.15*/utils/*89.20*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*89.77*/("""  </td>
								</tr>
							""")))}/*91.9*/else/*91.13*/{_display_(Seq[Any](format.raw/*91.14*/("""
								"""),_display_(Seq[Any](/*92.10*/if(ra)/*92.16*/{_display_(Seq[Any](format.raw/*92.17*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*94.15*/pd/*94.17*/.getString("nombre_proveedor"))),format.raw/*94.47*/("""</td>
									<td>"""),_display_(Seq[Any](/*95.15*/utils/*95.20*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*95.72*/("""</td>
									<td>"""),_display_(Seq[Any](/*96.15*/utils/*96.20*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*96.77*/("""  </td>
								</tr>
								""")))})),format.raw/*98.10*/("""
							""")))})),format.raw/*99.9*/("""	
							
							"""),_display_(Seq[Any](/*101.9*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*101.84*/("""<!-- +total deuda -->
							"""),_display_(Seq[Any](/*102.9*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*102.99*/("""<!-- +total compromiso -->
							"""),_display_(Seq[Any](/*103.9*/{monto_total_deudans= monto_total_deudans.add(pd.getBigDecimal("total_deuda"))})),format.raw/*103.88*/("""<!-- +total deuda NS-->
							"""),_display_(Seq[Any](/*104.9*/{monto_total_compromisons= monto_total_compromisons.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*104.103*/("""<!-- +total compromiso NS-->
						""")))})),format.raw/*105.8*/("""
						
						
						"""),_display_(Seq[Any](/*108.8*/if(proveedoresNoDestacados.size() > 0)/*108.46*/{_display_(Seq[Any](format.raw/*108.47*/("""
							<tr id="tr-otrosProveedores">
								"""),_display_(Seq[Any](/*110.10*/for(pd <- proveedoresNoDestacados) yield /*110.44*/ {_display_(Seq[Any](format.raw/*110.46*/("""
									"""),_display_(Seq[Any](/*111.11*/{monto_total_deudans= monto_total_deudans.add(pd.getBigDecimal("total_deuda"))})),format.raw/*111.90*/("""<!-- +total deuda NS-->
									"""),_display_(Seq[Any](/*112.11*/{monto_total_compromisons= monto_total_compromisons.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*112.105*/("""<!-- +total compromiso NS-->
									
									"""),_display_(Seq[Any](/*114.11*/{monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*114.92*/("""<!-- +total deuda ND-->
									"""),_display_(Seq[Any](/*115.11*/{monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*115.107*/("""<!-- +total compromiso ND-->
									
									"""),_display_(Seq[Any](/*117.11*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*117.86*/("""<!-- +total deuda -->
									"""),_display_(Seq[Any](/*118.11*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*118.101*/("""<!-- +total compromiso -->
								""")))})),format.raw/*119.10*/("""
								<td align="right"> <a href="/dashboard/deudasDetallesOtrosProveedoresResumen" target="_blank" >OTROS PROVEEDORES</a></td>
								<td>"""),_display_(Seq[Any](/*121.14*/utils/*121.19*/.NumberUtils.moneda(monto_total_deuda_nd))),format.raw/*121.60*/("""</td>
								<td>"""),_display_(Seq[Any](/*122.14*/utils/*122.19*/.NumberUtils.moneda(monto_total_compromiso_nd))),format.raw/*122.65*/("""</td>
							</tr>
						""")))})),format.raw/*124.8*/("""
						
						"""),_display_(Seq[Any](/*126.8*/if(proveedoresNoDestacadosEquipos.size() > 0)/*126.53*/{_display_(Seq[Any](format.raw/*126.54*/("""
							<tr id="tr-otrosProveedores" >
								"""),_display_(Seq[Any](/*128.10*/for(pd <- proveedoresNoDestacadosEquipos) yield /*128.51*/ {_display_(Seq[Any](format.raw/*128.53*/("""
									"""),_display_(Seq[Any](/*129.11*/{monto_total_deudans= monto_total_deudans.add(pd.getBigDecimal("total_deuda"))})),format.raw/*129.90*/("""<!-- +total deuda NS-->
									"""),_display_(Seq[Any](/*130.11*/{monto_total_compromisons= monto_total_compromisons.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*130.105*/("""<!-- +total compromiso NS-->
									
									"""),_display_(Seq[Any](/*132.11*/{monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"))})),format.raw/*132.94*/("""<!-- +total deuda ND-->
									"""),_display_(Seq[Any](/*133.11*/{monto_total_compromiso_nde= monto_total_compromiso_nde.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*133.109*/("""<!-- +total compromiso ND-->
									
									"""),_display_(Seq[Any](/*135.11*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*135.86*/("""<!-- +total deuda -->
									"""),_display_(Seq[Any](/*136.11*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*136.101*/("""<!-- +total compromiso -->
								""")))})),format.raw/*137.10*/(""" 
								<td align="right"> <a href="/dashboard/deudasDetallesOtrosProveedoresResumen?equipamientos=true" target="_blank" >OTROS PROVEEDORES EQUIPAMIENTO</a></td>
								<td>"""),_display_(Seq[Any](/*139.14*/utils/*139.19*/.NumberUtils.moneda(monto_total_deuda_nde))),format.raw/*139.61*/("""</td>
								<td>"""),_display_(Seq[Any](/*140.14*/utils/*140.19*/.NumberUtils.moneda(monto_total_compromiso_nde))),format.raw/*140.66*/("""</td>
							</tr>
						""")))})),format.raw/*142.8*/("""
						
						<tr>
							<td align="right"><b>SUB-TOTALES</b></td>
							<td><b>"""),_display_(Seq[Any](/*146.16*/utils/*146.21*/.NumberUtils.moneda(monto_total_deudans))),format.raw/*146.61*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*147.16*/utils/*147.21*/.NumberUtils.moneda(monto_total_compromisons))),format.raw/*147.66*/("""</b></td>
						</tr>
					""")))})),format.raw/*149.7*/("""
					
					
					
					"""),_display_(Seq[Any](/*153.7*/if(proveedoresNoDestacadosServicios.size() > 0 || proveedoresDestacadosServicios.size() > 0)/*153.99*/{_display_(Seq[Any](format.raw/*153.100*/("""
						<tr align="center"><td colspan="3"></td></tr>	
						<tr align="center">
							<td colspan="3"><span style="font-weight:bold;font-size:14px;">Servicios</span></td>
						</tr>
						"""),_display_(Seq[Any](/*158.8*/if(proveedoresDestacadosServicios.size() > 0)/*158.53*/{_display_(Seq[Any](format.raw/*158.54*/("""
								
							"""),_display_(Seq[Any](/*160.9*/for(pd <- proveedoresDestacadosServicios) yield /*160.50*/ {_display_(Seq[Any](format.raw/*160.52*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*162.15*/pd/*162.17*/.getString("nombre_proveedor"))),format.raw/*162.47*/("""</td>
									<td>"""),_display_(Seq[Any](/*163.15*/utils/*163.20*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*163.72*/("""</td>
									<td>"""),_display_(Seq[Any](/*164.15*/utils/*164.20*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*164.77*/("""  </td>
								</tr>
								"""),_display_(Seq[Any](/*166.10*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*166.85*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*167.10*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*167.100*/("""<!-- +total compromiso -->
								"""),_display_(Seq[Any](/*168.10*/{monto_total_deudass= monto_total_deudass.add(pd.getBigDecimal("total_deuda"))})),format.raw/*168.89*/("""<!-- +total deuda SS -->
								"""),_display_(Seq[Any](/*169.10*/{monto_total_compromisoss= monto_total_compromisoss.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*169.104*/("""<!-- +total compromiso SS-->
							""")))})),format.raw/*170.9*/("""
							"""),_display_(Seq[Any](/*171.9*/if(proveedoresNoDestacadosServicios.size() > 0)/*171.56*/{_display_(Seq[Any](format.raw/*171.57*/("""
								<tr id="tr-otrosProveedores" >
									"""),_display_(Seq[Any](/*173.11*/{monto_total_deuda_nd =new java.math.BigDecimal(0)})),format.raw/*173.62*/("""
									"""),_display_(Seq[Any](/*174.11*/{monto_total_compromiso_nd =new java.math.BigDecimal(0)})),format.raw/*174.67*/("""
									"""),_display_(Seq[Any](/*175.11*/for(pd <- proveedoresNoDestacadosServicios) yield /*175.54*/ {_display_(Seq[Any](format.raw/*175.56*/("""
										"""),_display_(Seq[Any](/*176.12*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*176.87*/("""<!-- +total deuda -->
										"""),_display_(Seq[Any](/*177.12*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*177.102*/("""<!-- +total compromiso -->
										"""),_display_(Seq[Any](/*178.12*/{monto_total_deudass= monto_total_deudass.add(pd.getBigDecimal("total_deuda"))})),format.raw/*178.91*/("""<!-- +total deuda SS -->
										"""),_display_(Seq[Any](/*179.12*/{monto_total_compromisoss= monto_total_compromisoss.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*179.106*/("""<!-- +total compromiso SS-->
										
										
										"""),_display_(Seq[Any](/*182.12*/{monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*182.93*/("""
										"""),_display_(Seq[Any](/*183.12*/{monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*183.108*/("""
									""")))})),format.raw/*184.11*/(""" 
									<td align="right"><a href="/dashboard/deudasDetallesServiciosResumen" target="_blank" >OTROS PROVEEDORES SERVICIOS</a></td>
									<td>"""),_display_(Seq[Any](/*186.15*/utils/*186.20*/.NumberUtils.moneda(monto_total_deuda_nd))),format.raw/*186.61*/("""</td>
									<td>"""),_display_(Seq[Any](/*187.15*/utils/*187.20*/.NumberUtils.moneda(monto_total_compromiso_nd))),format.raw/*187.66*/("""</td>
								</tr>
							""")))})),format.raw/*189.9*/("""
							<tr>
								<td align="right"><b>SUB-TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*192.17*/utils/*192.22*/.NumberUtils.moneda(monto_total_deudass))),format.raw/*192.62*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*193.17*/utils/*193.22*/.NumberUtils.moneda(monto_total_compromisoss))),format.raw/*193.67*/("""</b></td>
							</tr>
							
							
							
						""")))})),format.raw/*198.8*/("""
					""")))})),format.raw/*199.7*/("""
					
					"""),_display_(Seq[Any](/*201.7*/if(proveedoresNoDestacadosHonorarios.size() > 0 || proveedoresDestacadosHonorarios.size() > 0)/*201.101*/{_display_(Seq[Any](format.raw/*201.102*/("""
						<tr align="center"><td colspan="3"></td></tr>	
						<tr align="center">
							<td colspan="3"><span style="font-weight:bold;font-size:14px;">Honorarios</span></td>
						</tr>	
						"""),_display_(Seq[Any](/*206.8*/if(proveedoresDestacadosHonorarios.size() > 0)/*206.54*/{_display_(Seq[Any](format.raw/*206.55*/("""
							
							"""),_display_(Seq[Any](/*208.9*/for(pd <- proveedoresDestacadosHonorarios) yield /*208.51*/ {_display_(Seq[Any](format.raw/*208.53*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*210.15*/pd/*210.17*/.getString("nombre_proveedor"))),format.raw/*210.47*/("""</td>
									<td>"""),_display_(Seq[Any](/*211.15*/utils/*211.20*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*211.72*/("""</td>
									<td>"""),_display_(Seq[Any](/*212.15*/utils/*212.20*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*212.77*/("""  </td>
								</tr>
								"""),_display_(Seq[Any](/*214.10*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*214.85*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*215.10*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*215.100*/("""<!-- +total compromiso -->
								
								"""),_display_(Seq[Any](/*217.10*/{monto_total_deudasho= monto_total_deudasho.add(pd.getBigDecimal("total_deuda"))})),format.raw/*217.91*/("""<!-- +total deuda SS -->
								"""),_display_(Seq[Any](/*218.10*/{monto_total_compromisosho= monto_total_compromisosho.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*218.106*/("""<!-- +total compromiso SS-->
							""")))})),format.raw/*219.9*/("""
							"""),_display_(Seq[Any](/*220.9*/if(proveedoresNoDestacadosHonorarios.size() > 0)/*220.57*/{_display_(Seq[Any](format.raw/*220.58*/("""
								<tr id="tr-otrosProveedores">
									"""),_display_(Seq[Any](/*222.11*/{monto_total_deuda_nd =new java.math.BigDecimal(0)})),format.raw/*222.62*/("""
									"""),_display_(Seq[Any](/*223.11*/{monto_total_compromiso_nd =new java.math.BigDecimal(0)})),format.raw/*223.67*/("""
									"""),_display_(Seq[Any](/*224.11*/for(pd <- proveedoresNoDestacadosHonorarios) yield /*224.55*/ {_display_(Seq[Any](format.raw/*224.57*/("""
										"""),_display_(Seq[Any](/*225.12*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*225.87*/("""<!-- +total deuda -->
										"""),_display_(Seq[Any](/*226.12*/{monto_total_compromiso= monto_total_compromiso.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*226.102*/("""<!-- +total compromiso -->
										
										"""),_display_(Seq[Any](/*228.12*/{monto_total_deudasho= monto_total_deudasho.add(pd.getBigDecimal("total_deuda"))})),format.raw/*228.93*/("""<!-- +total deuda SS -->
										"""),_display_(Seq[Any](/*229.12*/{monto_total_compromisosho= monto_total_compromisosho.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*229.108*/("""<!-- +total compromiso SS-->
										
										
										"""),_display_(Seq[Any](/*232.12*/{monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*232.93*/("""
										"""),_display_(Seq[Any](/*233.12*/{monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*233.108*/("""
									""")))})),format.raw/*234.11*/(""" 
									<td align="right"><a href="/dashboard/deudasDetallesHonorariosResumen" target="_blank">OTROS PROVEEDORES HONORARIOS</a></td>
									<td>"""),_display_(Seq[Any](/*236.15*/utils/*236.20*/.NumberUtils.moneda(monto_total_deuda_nd))),format.raw/*236.61*/("""</td>
									<td>"""),_display_(Seq[Any](/*237.15*/utils/*237.20*/.NumberUtils.moneda(monto_total_compromiso_nd))),format.raw/*237.66*/("""</td>
								</tr>
							""")))})),format.raw/*239.9*/("""
							<tr>
								<td align="right"><b>SUB-TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*242.17*/utils/*242.22*/.NumberUtils.moneda(monto_total_deudasho))),format.raw/*242.63*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*243.17*/utils/*243.22*/.NumberUtils.moneda(monto_total_compromisosho))),format.raw/*243.68*/("""</b></td>
							</tr>
							
							
							
						""")))})),format.raw/*248.8*/("""
					""")))})),format.raw/*249.7*/("""
					
					
			</tbody>
			<tfoot>
				<tr>
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*256.14*/utils/*256.19*/.NumberUtils.moneda(monto_total_deuda))),format.raw/*256.57*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*257.14*/utils/*257.19*/.NumberUtils.moneda(monto_total_compromiso))),format.raw/*257.62*/("""</b></td>
				</tr>
				<tr>
					<td align="center" colspan="3" style="font-size:18px;text-align:center;">
					<b>TOTAL:"""),_display_(Seq[Any](/*261.16*/utils/*261.21*/.NumberUtils.moneda(monto_total_deuda.add(monto_total_compromiso)))),format.raw/*261.87*/("""
					</b></td>
					
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*267.4*/("""
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*272.4*/if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0 || proveedoresDestacadosProfeServicios.size() > 0)/*272.138*/{_display_(Seq[Any](format.raw/*272.139*/("""
		<table class="table table-striped table-bordered table-hover" id="listaInforme">
			<thead>
				<th colspan="3" align="center" style="font-size:20px;text-align:center;">PROFE</th>
			</thead>
			<thead>
				<th width="600">PROVEDORES</th>
				<th>MONTO DEUDA</th>
				<th>MONTRO COMPROMISO</th>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*283.6*/if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0)/*283.90*/{_display_(Seq[Any](format.raw/*283.91*/("""
					
					"""),_display_(Seq[Any](/*285.7*/{monto_total_ra_tmp = new java.math.BigDecimal(0)})),format.raw/*285.57*/("""
					"""),_display_(Seq[Any](/*286.7*/{monto_total_compromiso_ra_tmp = new java.math.BigDecimal(0)})),format.raw/*286.68*/("""
					"""),_display_(Seq[Any](/*287.7*/{hayra = new Boolean(false)})),format.raw/*287.35*/("""
					"""),_display_(Seq[Any](/*288.7*/if(!ra)/*288.14*/{_display_(Seq[Any](format.raw/*288.15*/("""
						"""),_display_(Seq[Any](/*289.8*/for(pd <- proveedoresDestacadosProfe) yield /*289.45*/ {_display_(Seq[Any](format.raw/*289.47*/("""
							"""),_display_(Seq[Any](/*290.9*/if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id")))/*290.88*/{_display_(Seq[Any](format.raw/*290.89*/("""
								"""),_display_(Seq[Any](/*291.10*/{monto_total_ra_tmp= monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"))})),format.raw/*291.87*/("""<!-- +total deuda ra tmp-->
								"""),_display_(Seq[Any](/*292.10*/{monto_total_compromiso_ra_tmp= monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*292.114*/("""<!-- +total compromiso ra tmp -->
								"""),_display_(Seq[Any](/*293.10*/{hayra = new Boolean(true)})),format.raw/*293.37*/("""
							""")))})),format.raw/*294.9*/("""
						""")))})),format.raw/*295.8*/("""
						
						"""),_display_(Seq[Any](/*297.8*/if(hayra)/*297.17*/{_display_(Seq[Any](format.raw/*297.18*/("""
						<tr>
							<td>RA</td>
							<td>"""),_display_(Seq[Any](/*300.13*/utils/*300.18*/.NumberUtils.moneda(monto_total_ra_tmp))),format.raw/*300.57*/("""</td>
							<td>"""),_display_(Seq[Any](/*301.13*/utils/*301.18*/.NumberUtils.moneda(monto_total_compromiso_ra_tmp))),format.raw/*301.68*/("""  </td>
						</tr>
						""")))})),format.raw/*303.8*/("""
					""")))})),format.raw/*304.7*/("""
					
					"""),_display_(Seq[Any](/*306.7*/for(pd <- proveedoresDestacadosProfe) yield /*306.44*/ {_display_(Seq[Any](format.raw/*306.46*/("""
						"""),_display_(Seq[Any](/*307.8*/if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id")))/*307.95*/{_display_(Seq[Any](format.raw/*307.96*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*309.14*/pd/*309.16*/.getString("nombre_proveedor"))),format.raw/*309.46*/("""</td>
								<td>"""),_display_(Seq[Any](/*310.14*/utils/*310.19*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*310.71*/("""</td>
								<td>"""),_display_(Seq[Any](/*311.14*/utils/*311.19*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*311.76*/("""</td>
							</tr>
						""")))}/*313.8*/else/*313.12*/{_display_(Seq[Any](format.raw/*313.13*/("""
							"""),_display_(Seq[Any](/*314.9*/if(ra)/*314.15*/{_display_(Seq[Any](format.raw/*314.16*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*316.14*/pd/*316.16*/.getString("nombre_proveedor"))),format.raw/*316.46*/("""</td>
								<td>"""),_display_(Seq[Any](/*317.14*/utils/*317.19*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*317.71*/("""</td>
								<td>"""),_display_(Seq[Any](/*318.14*/utils/*318.19*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*318.76*/("""</td>
							</tr>
							""")))})),format.raw/*320.9*/("""
						""")))})),format.raw/*321.8*/("""
						
						"""),_display_(Seq[Any](/*323.8*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*323.95*/("""<!-- +total deuda -->
						"""),_display_(Seq[Any](/*324.8*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*324.110*/("""<!-- +total compromiso -->
						"""),_display_(Seq[Any](/*325.8*/{monto_total_deuda_profens= monto_total_deuda_profens.add(pd.getBigDecimal("total_deuda"))})),format.raw/*325.99*/("""<!-- +total deuda NS -->
						"""),_display_(Seq[Any](/*326.8*/{monto_total_compromiso_profens= monto_total_compromiso_profens.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*326.114*/("""<!-- +total compromiso NS -->
						
					""")))})),format.raw/*328.7*/("""
					"""),_display_(Seq[Any](/*329.7*/if(proveedoresNoDestacadosProfe.size() > 0)/*329.50*/{_display_(Seq[Any](format.raw/*329.51*/("""
						<tr id="tr-otrosProveedoresProfe">
							"""),_display_(Seq[Any](/*331.9*/for(pd <- proveedoresNoDestacadosProfe) yield /*331.48*/ {_display_(Seq[Any](format.raw/*331.50*/("""
							    """),_display_(Seq[Any](/*332.13*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*332.100*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*333.10*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*333.112*/("""<!-- +total compromiso -->
								"""),_display_(Seq[Any](/*334.10*/{monto_total_deuda_profens= monto_total_deuda_profens.add(pd.getBigDecimal("total_deuda"))})),format.raw/*334.101*/("""<!-- +total deuda NS -->
								"""),_display_(Seq[Any](/*335.10*/{monto_total_compromiso_profens= monto_total_compromiso_profens.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*335.116*/("""<!-- +total compromiso NS -->
								"""),_display_(Seq[Any](/*336.10*/{monto_total_deuda_profe_nd= monto_total_deuda_profe_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*336.103*/("""
								"""),_display_(Seq[Any](/*337.10*/{monto_total_compromiso_profe_nd= monto_total_compromiso_profe_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*337.118*/("""
							""")))})),format.raw/*338.9*/(""" 
							<td align="right"><a href="/dashboard/deudasDetallesOtrosProveedoresResumen?equipamientos=false&profe=true" target="_blank"> OTROS PROVEEDORES <span>SUBTOTAL</span> </a> </td>
							<td>"""),_display_(Seq[Any](/*340.13*/utils/*340.18*/.NumberUtils.moneda(monto_total_deuda_profe_nd))),format.raw/*340.65*/("""</td>
							<td>"""),_display_(Seq[Any](/*341.13*/utils/*341.18*/.NumberUtils.moneda(monto_total_compromiso_profe_nd))),format.raw/*341.70*/("""</td>
						</tr>
					""")))})),format.raw/*343.7*/("""
					"""),_display_(Seq[Any](/*344.7*/if(proveedoresNoDestacadosProfeEquipos.size() > 0)/*344.57*/{_display_(Seq[Any](format.raw/*344.58*/("""
						<tr id="tr-otrosProveedoresProfe">
							"""),_display_(Seq[Any](/*346.9*/for(pd <- proveedoresNoDestacadosProfeEquipos) yield /*346.55*/ {_display_(Seq[Any](format.raw/*346.57*/("""
							    """),_display_(Seq[Any](/*347.13*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*347.100*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*348.10*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*348.112*/("""<!-- +total compromiso -->
								
								"""),_display_(Seq[Any](/*350.10*/{monto_total_deuda_profens= monto_total_deuda_profens.add(pd.getBigDecimal("total_deuda"))})),format.raw/*350.101*/("""<!-- +total deuda NS -->
								"""),_display_(Seq[Any](/*351.10*/{monto_total_compromiso_profens= monto_total_compromiso_profens.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*351.116*/("""<!-- +total compromiso NS -->
								
								"""),_display_(Seq[Any](/*353.10*/{monto_total_deuda_profe_nde= monto_total_deuda_profe_nde.add(pd.getBigDecimal("total_deuda"))})),format.raw/*353.105*/("""
								"""),_display_(Seq[Any](/*354.10*/{monto_total_compromiso_profe_nde= monto_total_compromiso_profe_nde.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*354.120*/("""
							""")))})),format.raw/*355.9*/("""
							<td align="right"><a href="/dashboard/deudasDetallesOtrosProveedoresResumen?profe=true&equipamientos=true" target="_blank">OTROS PROVEEDORES EQUIPAMIENTO <span>SUBTOTAL</span></a></td>
							<td>"""),_display_(Seq[Any](/*357.13*/utils/*357.18*/.NumberUtils.moneda(monto_total_deuda_profe_nde))),format.raw/*357.66*/("""</td>
							<td>"""),_display_(Seq[Any](/*358.13*/utils/*358.18*/.NumberUtils.moneda(monto_total_compromiso_profe_nde))),format.raw/*358.71*/("""</td>
						</tr>
					""")))})),format.raw/*360.7*/("""
					<tr>
						<td align="right"><b>SUB-TOTALES</b></td>
						<td><b>"""),_display_(Seq[Any](/*363.15*/utils/*363.20*/.NumberUtils.moneda(monto_total_deuda_profens))),format.raw/*363.66*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*364.15*/utils/*364.20*/.NumberUtils.moneda(monto_total_compromiso_profens))),format.raw/*364.71*/("""</b></td>
					</tr>
				""")))})),format.raw/*366.6*/("""
				
				
				
				
				"""),_display_(Seq[Any](/*371.6*/if(proveedoresDestacadosProfeServicios.size() > 0 || proveedoresNoDestacadosProfeServicios.size() > 0)/*371.108*/{_display_(Seq[Any](format.raw/*371.109*/("""
						<tr align="center"><td colspan="3"></td></tr>	
						<tr align="center">
							<td colspan="3"><span style="font-weight:bold;font-size:14px;">Servicios</span></td>
						</tr>	
						"""),_display_(Seq[Any](/*376.8*/for(pd <- proveedoresDestacadosProfeServicios) yield /*376.54*/ {_display_(Seq[Any](format.raw/*376.56*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*378.14*/pd/*378.16*/.getString("nombre_proveedor"))),format.raw/*378.46*/("""</td>
								<td>"""),_display_(Seq[Any](/*379.14*/utils/*379.19*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*379.71*/("""</td>
								<td>"""),_display_(Seq[Any](/*380.14*/utils/*380.19*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*380.76*/("""  </td>
							</tr>
							"""),_display_(Seq[Any](/*382.9*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*382.96*/("""
							"""),_display_(Seq[Any](/*383.9*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*383.111*/("""
							"""),_display_(Seq[Any](/*384.9*/{monto_total_deuda_profess= monto_total_deuda_profess.add(pd.getBigDecimal("total_deuda"))})),format.raw/*384.100*/("""
							"""),_display_(Seq[Any](/*385.9*/{monto_total_compromiso_profess= monto_total_compromiso_profess.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*385.115*/("""
						""")))})),format.raw/*386.8*/("""
						
						"""),_display_(Seq[Any](/*388.8*/if(proveedoresNoDestacadosProfeServicios.size() > 0)/*388.60*/{_display_(Seq[Any](format.raw/*388.61*/("""
						<tr id="tr-otrosProveedoresProfe" style="cursor:pointer; color:blue;">
						  	"""),_display_(Seq[Any](/*390.11*/{monto_total_deuda_profe_nd =new java.math.BigDecimal(0)})),format.raw/*390.68*/("""
							"""),_display_(Seq[Any](/*391.9*/{monto_total_compromiso_profe_nd =new java.math.BigDecimal(0)})),format.raw/*391.71*/("""
							"""),_display_(Seq[Any](/*392.9*/for(pd <- proveedoresNoDestacadosProfeServicios) yield /*392.57*/ {_display_(Seq[Any](format.raw/*392.59*/("""
							    """),_display_(Seq[Any](/*393.13*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*393.100*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*394.10*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*394.112*/("""<!-- +total compromiso -->
								"""),_display_(Seq[Any](/*395.10*/{monto_total_deuda_profess= monto_total_deuda_profess.add(pd.getBigDecimal("total_deuda"))})),format.raw/*395.101*/("""<!-- +total deuda NS -->
								"""),_display_(Seq[Any](/*396.10*/{monto_total_compromiso_profess= monto_total_compromiso_profess.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*396.116*/("""<!-- +total compromiso NS -->
								
								"""),_display_(Seq[Any](/*398.10*/{monto_total_deuda_profe_nd= monto_total_deuda_profe_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*398.103*/("""
								"""),_display_(Seq[Any](/*399.10*/{monto_total_compromiso_profe_nd= monto_total_compromiso_profe_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*399.118*/("""
							""")))})),format.raw/*400.9*/("""
							<td align="right">OTROS PROVEEDORES <span>SUBTOTAL</span></td>
							<td>"""),_display_(Seq[Any](/*402.13*/utils/*402.18*/.NumberUtils.moneda(monto_total_deuda_profe_nd))),format.raw/*402.65*/("""</td>
							<td>"""),_display_(Seq[Any](/*403.13*/utils/*403.18*/.NumberUtils.moneda(monto_total_compromiso_profe_nd))),format.raw/*403.70*/("""</td>
						</tr>
						""")))})),format.raw/*405.8*/("""
						<tr>
							<td align="right"><b>SUB-TOTALES</b></td>
							<td><b>"""),_display_(Seq[Any](/*408.16*/utils/*408.21*/.NumberUtils.moneda(monto_total_deuda_profess))),format.raw/*408.67*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*409.16*/utils/*409.21*/.NumberUtils.moneda(monto_total_compromiso_profess))),format.raw/*409.72*/("""</b></td>
						</tr>
					""")))})),format.raw/*411.7*/("""
				
				"""),_display_(Seq[Any](/*413.6*/if(proveedoresDestacadosProfeHonorarios.size() > 0 || proveedoresNoDestacadosProfeHonorarios.size() > 0)/*413.110*/{_display_(Seq[Any](format.raw/*413.111*/("""
						<tr align="center"><td colspan="3"></td></tr>	
						<tr align="center">
							<td colspan="3"><span style="font-weight:bold;font-size:14px;">Honorarios</span></td>
						</tr>	
						"""),_display_(Seq[Any](/*418.8*/for(pd <- proveedoresDestacadosProfeHonorarios) yield /*418.55*/ {_display_(Seq[Any](format.raw/*418.57*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*420.14*/pd/*420.16*/.getString("nombre_proveedor"))),format.raw/*420.46*/("""</td>
								<td>"""),_display_(Seq[Any](/*421.14*/utils/*421.19*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*421.71*/("""</td>
								<td>"""),_display_(Seq[Any](/*422.14*/utils/*422.19*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*422.76*/("""  </td>
							</tr>
							"""),_display_(Seq[Any](/*424.9*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*424.96*/("""
							"""),_display_(Seq[Any](/*425.9*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*425.111*/("""
							
							"""),_display_(Seq[Any](/*427.9*/{monto_total_deuda_profeho= monto_total_deuda_profeho.add(pd.getBigDecimal("total_deuda"))})),format.raw/*427.100*/("""
							"""),_display_(Seq[Any](/*428.9*/{monto_total_compromiso_profeho= monto_total_compromiso_profeho.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*428.115*/("""
						""")))})),format.raw/*429.8*/("""
						
						"""),_display_(Seq[Any](/*431.8*/if(proveedoresNoDestacadosProfeHonorarios.size() > 0)/*431.61*/{_display_(Seq[Any](format.raw/*431.62*/("""
						<tr id="tr-otrosProveedoresProfe" style="cursor:pointer; color:blue;">
						  	"""),_display_(Seq[Any](/*433.11*/{monto_total_deuda_profe_nd =new java.math.BigDecimal(0)})),format.raw/*433.68*/("""
							"""),_display_(Seq[Any](/*434.9*/{monto_total_compromiso_profe_nd =new java.math.BigDecimal(0)})),format.raw/*434.71*/("""
							"""),_display_(Seq[Any](/*435.9*/for(pd <- proveedoresNoDestacadosProfeHonorarios) yield /*435.58*/ {_display_(Seq[Any](format.raw/*435.60*/("""
							    """),_display_(Seq[Any](/*436.13*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*436.100*/("""<!-- +total deuda -->
								"""),_display_(Seq[Any](/*437.10*/{monto_total_compromiso_profe= monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*437.112*/("""<!-- +total compromiso -->
								"""),_display_(Seq[Any](/*438.10*/{monto_total_deuda_profeho= monto_total_deuda_profeho.add(pd.getBigDecimal("total_deuda"))})),format.raw/*438.101*/("""<!-- +total deuda NS -->
								"""),_display_(Seq[Any](/*439.10*/{monto_total_compromiso_profeho= monto_total_compromiso_profeho.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*439.116*/("""<!-- +total compromiso NS -->
								
								"""),_display_(Seq[Any](/*441.10*/{monto_total_deuda_profe_nd= monto_total_deuda_profe_nd.add(pd.getBigDecimal("total_deuda"))})),format.raw/*441.103*/("""
								"""),_display_(Seq[Any](/*442.10*/{monto_total_compromiso_profe_nd= monto_total_compromiso_profe_nd.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*442.118*/("""
							""")))})),format.raw/*443.9*/("""
							<td align="right">OTROS PROVEEDORES HONORARIOS <span>SUBTOTAL</span></td>
							<td>"""),_display_(Seq[Any](/*445.13*/utils/*445.18*/.NumberUtils.moneda(monto_total_deuda_profe_nd))),format.raw/*445.65*/("""</td>
							<td>"""),_display_(Seq[Any](/*446.13*/utils/*446.18*/.NumberUtils.moneda(monto_total_compromiso_profe_nd))),format.raw/*446.70*/("""</td>
						</tr>
						""")))})),format.raw/*448.8*/("""
						<tr>
							<td align="right"><b>SUB-TOTALES</b></td>
							<td><b>"""),_display_(Seq[Any](/*451.16*/utils/*451.21*/.NumberUtils.moneda(monto_total_deuda_profeho))),format.raw/*451.67*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*452.16*/utils/*452.21*/.NumberUtils.moneda(monto_total_compromiso_profeho))),format.raw/*452.72*/("""</b></td>
						</tr>
					""")))})),format.raw/*454.7*/("""
					
				
			</tbody>
			<tfoot>
				<tr>
					<td align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*461.14*/utils/*461.19*/.NumberUtils.moneda(monto_total_deuda_profe))),format.raw/*461.63*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*462.14*/utils/*462.19*/.NumberUtils.moneda(monto_total_compromiso_profe))),format.raw/*462.68*/("""</b></td>
				</tr>
				<tr>
					<td align="center" colspan="3" style="font-size:18px;text-align:center;">
					<b>TOTAL:"""),_display_(Seq[Any](/*466.16*/utils/*466.21*/.NumberUtils.moneda(monto_total_deuda_profe.add(monto_total_compromiso_profe)))),format.raw/*466.99*/("""</b>
					</td>
					
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*472.4*/("""
	</div>
</div>

<script>
$( function ()"""),format.raw/*477.15*/("""{"""),format.raw/*477.16*/("""
	$('#tr-otrosProveedores').click( function()"""),format.raw/*478.45*/("""{"""),format.raw/*478.46*/("""
		if($("#listaOtrosProveedores").hasClass("hidden"))"""),format.raw/*479.53*/("""{"""),format.raw/*479.54*/("""
			$( "#listaOtrosProveedores" ).removeClass( "hidden");
		"""),format.raw/*481.3*/("""}"""),format.raw/*481.4*/("""else"""),format.raw/*481.8*/("""{"""),format.raw/*481.9*/("""
			$( "#listaOtrosProveedores" ).addClass( "hidden");
		"""),format.raw/*483.3*/("""}"""),format.raw/*483.4*/("""
	"""),format.raw/*484.2*/("""}"""),format.raw/*484.3*/(""");
	$('#tr-otrosProveedoresProfe').click( function()"""),format.raw/*485.50*/("""{"""),format.raw/*485.51*/("""
		if($("#listaOtrosProveedoresProfe").hasClass("hidden"))"""),format.raw/*486.58*/("""{"""),format.raw/*486.59*/("""
			$( "#listaOtrosProveedoresProfe" ).removeClass( "hidden");
		"""),format.raw/*488.3*/("""}"""),format.raw/*488.4*/("""else"""),format.raw/*488.8*/("""{"""),format.raw/*488.9*/("""
			$( "#listaOtrosProveedoresProfe" ).addClass( "hidden");
		"""),format.raw/*490.3*/("""}"""),format.raw/*490.4*/("""
	"""),format.raw/*491.2*/("""}"""),format.raw/*491.3*/(""");
"""),format.raw/*492.1*/("""}"""),format.raw/*492.2*/(""");	
</script>
""")))})))}
    }
    
    def render(depositonNombre:String,proveedoresDestacados:List[com.avaje.ebean.SqlRow],proveedoresDestacadosServicios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacados:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosServicios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosEquipos:List[com.avaje.ebean.SqlRow],proveedoresDestacadosProfe:List[com.avaje.ebean.SqlRow],proveedoresDestacadosProfeServicios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosProfe:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosProfeServicios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosProfeEquipos:List[com.avaje.ebean.SqlRow],proveedoresDestacadosHonorarios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosHonorarios:List[com.avaje.ebean.SqlRow],proveedoresDestacadosProfeHonorarios:List[com.avaje.ebean.SqlRow],proveedoresNoDestacadosProfeHonorarios:List[com.avaje.ebean.SqlRow],deposito:Integer,ra:Boolean,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(depositonNombre,proveedoresDestacados,proveedoresDestacadosServicios,proveedoresNoDestacados,proveedoresNoDestacadosServicios,proveedoresNoDestacadosEquipos,proveedoresDestacadosProfe,proveedoresDestacadosProfeServicios,proveedoresNoDestacadosProfe,proveedoresNoDestacadosProfeServicios,proveedoresNoDestacadosProfeEquipos,proveedoresDestacadosHonorarios,proveedoresNoDestacadosHonorarios,proveedoresDestacadosProfeHonorarios,proveedoresNoDestacadosProfeHonorarios,deposito,ra,formBuscador)
    
    def f:((String,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Integer,Boolean,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (depositonNombre,proveedoresDestacados,proveedoresDestacadosServicios,proveedoresNoDestacados,proveedoresNoDestacadosServicios,proveedoresNoDestacadosEquipos,proveedoresDestacadosProfe,proveedoresDestacadosProfeServicios,proveedoresNoDestacadosProfe,proveedoresNoDestacadosProfeServicios,proveedoresNoDestacadosProfeEquipos,proveedoresDestacadosHonorarios,proveedoresNoDestacadosHonorarios,proveedoresDestacadosProfeHonorarios,proveedoresNoDestacadosProfeHonorarios,deposito,ra,formBuscador) => apply(depositonNombre,proveedoresDestacados,proveedoresDestacadosServicios,proveedoresNoDestacados,proveedoresNoDestacadosServicios,proveedoresNoDestacadosEquipos,proveedoresDestacadosProfe,proveedoresDestacadosProfeServicios,proveedoresNoDestacadosProfe,proveedoresNoDestacadosProfeServicios,proveedoresNoDestacadosProfeEquipos,proveedoresDestacadosHonorarios,proveedoresNoDestacadosHonorarios,proveedoresDestacadosProfeHonorarios,proveedoresNoDestacadosProfeHonorarios,deposito,ra,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasResumidas.scala.html
                    HASH: a592c7933359b949d940a19235cd269449f65550
                    MATRIX: 1248->1|3920->1021|3953->1045|4028->964|4057->1089|4085->2658|4125->2663|4138->2668|4194->2715|4234->2717|4271->2719|4284->2724|4364->2782|4496->2878|4533->2893|5037->3361|5057->3372|5170->3462|5340->3597|5516->3763|5556->3764|5929->4102|6012->4176|6051->4177|6101->4192|6117->4199|6156->4200|6200->4209|6248->4241|6288->4243|6334->4253|6422->4332|6461->4333|6508->4344|6607->4421|6681->4459|6808->4563|6883->4606|6929->4616|6978->4643|7018->4652|7070->4669|7088->4678|7127->4679|7209->4725|7223->4730|7284->4769|7339->4788|7353->4793|7425->4843|7485->4872|7524->4880|7574->4895|7622->4927|7662->4929|7706->4938|7802->5025|7841->5026|7905->5054|7916->5056|7968->5086|8024->5106|8038->5111|8112->5163|8168->5183|8182->5188|8261->5245|8309->5275|8322->5279|8361->5280|8407->5290|8422->5296|8461->5297|8525->5325|8536->5327|8588->5357|8644->5377|8658->5382|8732->5434|8788->5454|8802->5459|8881->5516|8944->5547|8984->5556|9038->5574|9136->5649|9202->5679|9315->5769|9386->5804|9488->5883|9556->5915|9674->6009|9742->6045|9800->6067|9848->6105|9888->6106|9972->6153|10023->6187|10064->6189|10112->6200|10214->6279|10285->6313|10403->6407|10489->6456|10593->6537|10664->6571|10784->6667|10870->6716|10968->6791|11037->6823|11151->6913|11220->6949|11401->7093|11416->7098|11480->7139|11536->7158|11551->7163|11620->7209|11678->7235|11729->7250|11784->7295|11824->7296|11909->7344|11967->7385|12008->7387|12056->7398|12158->7477|12229->7511|12347->7605|12433->7654|12539->7737|12610->7771|12732->7869|12818->7918|12916->7993|12985->8025|13099->8115|13168->8151|13382->8328|13397->8333|13462->8375|13518->8394|13533->8399|13603->8446|13661->8472|13781->8555|13796->8560|13859->8600|13921->8625|13936->8630|14004->8675|14064->8703|14125->8728|14227->8820|14268->8821|14495->9012|14550->9057|14590->9058|14644->9076|14702->9117|14743->9119|14808->9147|14820->9149|14873->9179|14930->9199|14945->9204|15020->9256|15077->9276|15092->9281|15172->9338|15240->9369|15338->9444|15406->9475|15520->9565|15593->9601|15695->9680|15766->9714|15884->9808|15953->9845|15998->9854|16055->9901|16095->9902|16182->9952|16256->10003|16304->10014|16383->10070|16431->10081|16491->10124|16532->10126|16581->10138|16679->10213|16749->10246|16863->10336|16938->10374|17040->10453|17113->10489|17231->10583|17330->10645|17434->10726|17483->10738|17603->10834|17647->10845|17833->10994|17848->10999|17912->11040|17969->11060|17984->11065|18053->11111|18113->11139|18229->11218|18244->11223|18307->11263|18370->11289|18385->11294|18453->11339|18539->11393|18578->11400|18627->11413|18732->11507|18773->11508|19002->11701|19058->11747|19098->11748|19151->11765|19210->11807|19251->11809|19316->11837|19328->11839|19381->11869|19438->11889|19453->11894|19528->11946|19585->11966|19600->11971|19680->12028|19748->12059|19846->12134|19914->12165|20028->12255|20110->12300|20214->12381|20285->12415|20405->12511|20474->12548|20519->12557|20577->12605|20617->12606|20703->12655|20777->12706|20825->12717|20904->12773|20952->12784|21013->12828|21054->12830|21103->12842|21201->12917|21271->12950|21385->13040|21471->13089|21575->13170|21648->13206|21768->13302|21867->13364|21971->13445|22020->13457|22140->13553|22184->13564|22371->13714|22386->13719|22450->13760|22507->13780|22522->13785|22591->13831|22651->13859|22767->13938|22782->13943|22846->13984|22909->14010|22924->14015|22993->14061|23079->14115|23118->14122|23256->14223|23271->14228|23332->14266|23392->14289|23407->14294|23473->14337|23633->14460|23648->14465|23737->14531|23827->14589|23944->14670|24089->14804|24130->14805|24492->15131|24586->15215|24626->15216|24675->15229|24748->15279|24791->15286|24875->15347|24918->15354|24969->15382|25012->15389|25029->15396|25069->15397|25113->15405|25167->15442|25208->15444|25253->15453|25342->15532|25382->15533|25429->15543|25529->15620|25603->15657|25731->15761|25811->15804|25861->15831|25902->15840|25942->15848|25993->15863|26012->15872|26052->15873|26132->15916|26147->15921|26209->15960|26264->15978|26279->15983|26352->16033|26411->16060|26450->16067|26499->16080|26553->16117|26594->16119|26638->16127|26735->16214|26775->16215|26838->16241|26850->16243|26903->16273|26959->16292|26974->16297|27049->16349|27105->16368|27120->16373|27200->16430|27245->16456|27259->16460|27299->16461|27344->16470|27360->16476|27400->16477|27463->16503|27475->16505|27528->16535|27584->16554|27599->16559|27674->16611|27730->16630|27745->16635|27825->16692|27884->16719|27924->16727|27975->16742|28085->16829|28150->16858|28276->16960|28346->16994|28460->17085|28528->17117|28658->17223|28733->17266|28776->17273|28829->17316|28869->17317|28955->17367|29011->17406|29052->17408|29102->17421|29213->17508|29281->17539|29407->17641|29480->17677|29595->17768|29666->17802|29796->17908|29872->17947|29989->18040|30036->18050|30168->18158|30209->18167|30443->18364|30458->18369|30528->18416|30583->18434|30598->18439|30673->18491|30729->18515|30772->18522|30832->18572|30872->18573|30958->18623|31021->18669|31062->18671|31112->18684|31223->18771|31291->18802|31417->18904|31499->18949|31614->19040|31685->19074|31815->19180|31900->19228|32019->19323|32066->19333|32200->19443|32241->19452|32483->19657|32498->19662|32569->19710|32624->19728|32639->19733|32715->19786|32771->19810|32881->19883|32896->19888|32965->19934|33026->19958|33041->19963|33115->20014|33173->20040|33235->20066|33348->20168|33389->20169|33617->20361|33680->20407|33721->20409|33784->20435|33796->20437|33849->20467|33905->20486|33920->20491|33995->20543|34051->20562|34066->20567|34146->20624|34211->20653|34321->20740|34366->20749|34492->20851|34537->20860|34652->20951|34697->20960|34827->21066|34867->21074|34918->21089|34980->21141|35020->21142|35145->21230|35225->21287|35270->21296|35355->21358|35400->21367|35465->21415|35506->21417|35556->21430|35667->21517|35735->21548|35861->21650|35934->21686|36049->21777|36120->21811|36250->21917|36335->21965|36452->22058|36499->22068|36631->22176|36672->22185|36792->22268|36807->22273|36877->22320|36932->22338|36947->22343|37022->22395|37079->22420|37192->22496|37207->22501|37276->22547|37338->22572|37353->22577|37427->22628|37487->22656|37534->22667|37649->22771|37690->22772|37919->22965|37983->23012|38024->23014|38087->23040|38099->23042|38152->23072|38208->23091|38223->23096|38298->23148|38354->23167|38369->23172|38449->23229|38514->23258|38624->23345|38669->23354|38795->23456|38848->23473|38963->23564|39008->23573|39138->23679|39178->23687|39229->23702|39292->23755|39332->23756|39457->23844|39537->23901|39582->23910|39667->23972|39712->23981|39778->24030|39819->24032|39869->24045|39980->24132|40048->24163|40174->24265|40247->24301|40362->24392|40433->24426|40563->24532|40648->24580|40765->24673|40812->24683|40944->24791|40985->24800|41116->24894|41131->24899|41201->24946|41256->24964|41271->24969|41346->25021|41403->25046|41516->25122|41531->25127|41600->25173|41662->25198|41677->25203|41751->25254|41811->25282|41948->25382|41963->25387|42030->25431|42090->25454|42105->25459|42177->25508|42337->25631|42352->25636|42453->25714|42543->25772|42612->25812|42642->25813|42716->25858|42746->25859|42828->25912|42858->25913|42946->25973|42975->25974|43007->25978|43036->25979|43121->26036|43150->26037|43180->26039|43209->26040|43290->26092|43320->26093|43407->26151|43437->26152|43530->26217|43559->26218|43591->26222|43620->26223|43710->26285|43739->26286|43769->26288|43798->26289|43829->26292|43858->26293
                    LINES: 26->1|50->20|50->20|51->16|52->20|53->22|57->26|57->26|57->26|57->26|58->27|58->27|58->27|62->31|62->31|75->44|75->44|75->44|83->52|83->52|83->52|95->64|95->64|95->64|97->66|97->66|97->66|98->67|98->67|98->67|99->68|99->68|99->68|100->69|100->69|101->70|101->70|102->71|103->72|103->72|104->73|106->75|106->75|106->75|109->78|109->78|109->78|110->79|110->79|110->79|112->81|113->82|115->84|115->84|115->84|116->85|116->85|116->85|118->87|118->87|118->87|119->88|119->88|119->88|120->89|120->89|120->89|122->91|122->91|122->91|123->92|123->92|123->92|125->94|125->94|125->94|126->95|126->95|126->95|127->96|127->96|127->96|129->98|130->99|132->101|132->101|133->102|133->102|134->103|134->103|135->104|135->104|136->105|139->108|139->108|139->108|141->110|141->110|141->110|142->111|142->111|143->112|143->112|145->114|145->114|146->115|146->115|148->117|148->117|149->118|149->118|150->119|152->121|152->121|152->121|153->122|153->122|153->122|155->124|157->126|157->126|157->126|159->128|159->128|159->128|160->129|160->129|161->130|161->130|163->132|163->132|164->133|164->133|166->135|166->135|167->136|167->136|168->137|170->139|170->139|170->139|171->140|171->140|171->140|173->142|177->146|177->146|177->146|178->147|178->147|178->147|180->149|184->153|184->153|184->153|189->158|189->158|189->158|191->160|191->160|191->160|193->162|193->162|193->162|194->163|194->163|194->163|195->164|195->164|195->164|197->166|197->166|198->167|198->167|199->168|199->168|200->169|200->169|201->170|202->171|202->171|202->171|204->173|204->173|205->174|205->174|206->175|206->175|206->175|207->176|207->176|208->177|208->177|209->178|209->178|210->179|210->179|213->182|213->182|214->183|214->183|215->184|217->186|217->186|217->186|218->187|218->187|218->187|220->189|223->192|223->192|223->192|224->193|224->193|224->193|229->198|230->199|232->201|232->201|232->201|237->206|237->206|237->206|239->208|239->208|239->208|241->210|241->210|241->210|242->211|242->211|242->211|243->212|243->212|243->212|245->214|245->214|246->215|246->215|248->217|248->217|249->218|249->218|250->219|251->220|251->220|251->220|253->222|253->222|254->223|254->223|255->224|255->224|255->224|256->225|256->225|257->226|257->226|259->228|259->228|260->229|260->229|263->232|263->232|264->233|264->233|265->234|267->236|267->236|267->236|268->237|268->237|268->237|270->239|273->242|273->242|273->242|274->243|274->243|274->243|279->248|280->249|287->256|287->256|287->256|288->257|288->257|288->257|292->261|292->261|292->261|298->267|303->272|303->272|303->272|314->283|314->283|314->283|316->285|316->285|317->286|317->286|318->287|318->287|319->288|319->288|319->288|320->289|320->289|320->289|321->290|321->290|321->290|322->291|322->291|323->292|323->292|324->293|324->293|325->294|326->295|328->297|328->297|328->297|331->300|331->300|331->300|332->301|332->301|332->301|334->303|335->304|337->306|337->306|337->306|338->307|338->307|338->307|340->309|340->309|340->309|341->310|341->310|341->310|342->311|342->311|342->311|344->313|344->313|344->313|345->314|345->314|345->314|347->316|347->316|347->316|348->317|348->317|348->317|349->318|349->318|349->318|351->320|352->321|354->323|354->323|355->324|355->324|356->325|356->325|357->326|357->326|359->328|360->329|360->329|360->329|362->331|362->331|362->331|363->332|363->332|364->333|364->333|365->334|365->334|366->335|366->335|367->336|367->336|368->337|368->337|369->338|371->340|371->340|371->340|372->341|372->341|372->341|374->343|375->344|375->344|375->344|377->346|377->346|377->346|378->347|378->347|379->348|379->348|381->350|381->350|382->351|382->351|384->353|384->353|385->354|385->354|386->355|388->357|388->357|388->357|389->358|389->358|389->358|391->360|394->363|394->363|394->363|395->364|395->364|395->364|397->366|402->371|402->371|402->371|407->376|407->376|407->376|409->378|409->378|409->378|410->379|410->379|410->379|411->380|411->380|411->380|413->382|413->382|414->383|414->383|415->384|415->384|416->385|416->385|417->386|419->388|419->388|419->388|421->390|421->390|422->391|422->391|423->392|423->392|423->392|424->393|424->393|425->394|425->394|426->395|426->395|427->396|427->396|429->398|429->398|430->399|430->399|431->400|433->402|433->402|433->402|434->403|434->403|434->403|436->405|439->408|439->408|439->408|440->409|440->409|440->409|442->411|444->413|444->413|444->413|449->418|449->418|449->418|451->420|451->420|451->420|452->421|452->421|452->421|453->422|453->422|453->422|455->424|455->424|456->425|456->425|458->427|458->427|459->428|459->428|460->429|462->431|462->431|462->431|464->433|464->433|465->434|465->434|466->435|466->435|466->435|467->436|467->436|468->437|468->437|469->438|469->438|470->439|470->439|472->441|472->441|473->442|473->442|474->443|476->445|476->445|476->445|477->446|477->446|477->446|479->448|482->451|482->451|482->451|483->452|483->452|483->452|485->454|492->461|492->461|492->461|493->462|493->462|493->462|497->466|497->466|497->466|503->472|508->477|508->477|509->478|509->478|510->479|510->479|512->481|512->481|512->481|512->481|514->483|514->483|515->484|515->484|516->485|516->485|517->486|517->486|519->488|519->488|519->488|519->488|521->490|521->490|522->491|522->491|523->492|523->492
                    -- GENERATED --
                */
            