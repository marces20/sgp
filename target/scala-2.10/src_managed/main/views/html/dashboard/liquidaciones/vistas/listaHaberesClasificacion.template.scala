
package views.html.dashboard.liquidaciones.vistas

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
object listaHaberesClasificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.122*/("""
"""),format.raw/*5.70*/("""

	"""),_display_(Seq[Any](/*7.3*/if(rowParque != null)/*7.24*/{_display_(Seq[Any](format.raw/*7.25*/("""
		"""),_display_(Seq[Any](/*8.4*/if(rowParque.size() > 0)/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PARQUE SALUD</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>NOMBRE</td>
								<td>PROFESION</td>
								<td align="center">HABER BRUTO</td>
								<td align="center">GUARDIA</td>
								<td align="center">PRODUCCION</td>	
								<td align="center">ADICIONALES</td>	
								<td align="center">DESCUENTOS</td>	
								<td align="center">NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*27.9*/for(rp <- rowParque) yield /*27.29*/{_display_(Seq[Any](format.raw/*27.30*/("""
								"""),_display_(Seq[Any](/*28.10*/if(rp.getInteger("idTipoRelacion").compareTo(1) == 0)/*28.63*/{_display_(Seq[Any](format.raw/*28.64*/("""
									<tr>
										<td>"""),_display_(Seq[Any](/*30.16*/rp/*30.18*/.getString("nombre"))),format.raw/*30.38*/("""</td>
										<td>"""),_display_(Seq[Any](/*31.16*/rp/*31.18*/.getString("profesion"))),format.raw/*31.41*/("""</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*33.13*/if(rp.getBigDecimal("haber").compareTo(java.math.BigDecimal.ZERO) > 0)/*33.83*/{_display_(Seq[Any](format.raw/*33.84*/("""
												<a href="#" data-url=""""),_display_(Seq[Any](/*34.36*/controllers/*34.47*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),1))),format.raw/*34.194*/("""" class="getDetalleLiquidacionClasificacion">
													"""),_display_(Seq[Any](/*35.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*35.68*/("""
												</a>
											""")))}/*37.13*/else/*37.17*/{_display_(Seq[Any](_display_(Seq[Any](/*37.19*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber")))))))})),format.raw/*37.73*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*40.13*/if(rp.getBigDecimal("guardias").compareTo(java.math.BigDecimal.ZERO) > 0)/*40.86*/{_display_(Seq[Any](format.raw/*40.87*/("""
												<a href="#" data-url=""""),_display_(Seq[Any](/*41.36*/controllers/*41.47*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),2))),format.raw/*41.194*/("""" class="getDetalleLiquidacionClasificacion">
													"""),_display_(Seq[Any](/*42.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*42.71*/("""
												</a>
											""")))}/*44.13*/else/*44.17*/{_display_(Seq[Any](_display_(Seq[Any](/*44.19*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias")))))))})),format.raw/*44.76*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*47.13*/if(rp.getBigDecimal("produccion").compareTo(java.math.BigDecimal.ZERO) > 0)/*47.88*/{_display_(Seq[Any](format.raw/*47.89*/("""
												<a href="#" data-url=""""),_display_(Seq[Any](/*48.36*/controllers/*48.47*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),3))),format.raw/*48.194*/("""" class="getDetalleLiquidacionClasificacion">
													"""),_display_(Seq[Any](/*49.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*49.73*/("""
												</a>
											""")))}/*51.13*/else/*51.17*/{_display_(Seq[Any](_display_(Seq[Any](/*51.19*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion")))))))})),format.raw/*51.78*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*54.13*/if(rp.getBigDecimal("adicional").compareTo(java.math.BigDecimal.ZERO) > 0)/*54.87*/{_display_(Seq[Any](format.raw/*54.88*/("""
												<a href="#" data-url=""""),_display_(Seq[Any](/*55.36*/controllers/*55.47*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),6))),format.raw/*55.194*/("""" class="getDetalleLiquidacionClasificacion">
													"""),_display_(Seq[Any](/*56.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*56.72*/("""
												</a>
											""")))}/*58.13*/else/*58.17*/{_display_(Seq[Any](_display_(Seq[Any](/*58.19*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional")))))))})),format.raw/*58.77*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*61.13*/if(rp.getBigDecimal("descuentos").compareTo(java.math.BigDecimal.ZERO) > 0)/*61.88*/{_display_(Seq[Any](format.raw/*61.89*/("""
												<a href="#" data-url=""""),_display_(Seq[Any](/*62.36*/controllers/*62.47*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),5))),format.raw/*62.194*/("""" class="getDetalleLiquidacionClasificacion">
													"""),_display_(Seq[Any](/*63.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*63.73*/("""
												</a>
											""")))}/*65.13*/else/*65.17*/{_display_(Seq[Any](_display_(Seq[Any](/*65.19*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos")))))))})),format.raw/*65.78*/("""
										</td>
										<td align="center">"""),_display_(Seq[Any](/*67.31*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*67.83*/("""</td>
									</tr>
								""")))})),format.raw/*69.10*/("""
							""")))})),format.raw/*70.9*/("""					
						</tbody>
					</table>		
					
					
				</div>
			</div>	
		""")))})),format.raw/*77.4*/("""
	""")))})),format.raw/*78.3*/("""
	
	"""),_display_(Seq[Any](/*80.3*/if(rowConvenio != null)/*80.26*/{_display_(Seq[Any](format.raw/*80.27*/("""
		"""),_display_(Seq[Any](/*81.4*/if(rowConvenio.size() > 0)/*81.30*/{_display_(Seq[Any](format.raw/*81.31*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>CONVENIO MINISTERIO</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>NOMBRE</td>
								<td>PROFESION</td>
								<td>LUGAR</td>
								<td>HABER BRUTO</td>
								<td>GUARDIA</td>
								<td>PRODUCCION</td>	
								<td>ADICIONALES</td>	
								<td>DESCUENTOS</td>	
								<td>NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*101.9*/for(rp <- rowConvenio) yield /*101.31*/{_display_(Seq[Any](format.raw/*101.32*/("""
								"""),_display_(Seq[Any](/*102.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) == 0)/*102.63*/{_display_(Seq[Any](format.raw/*102.64*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*104.15*/rp/*104.17*/.getString("nombre"))),format.raw/*104.37*/("""</td>
									<td>"""),_display_(Seq[Any](/*105.15*/rp/*105.17*/.getString("PROFESION"))),format.raw/*105.40*/("""</td>
									<td>"""),_display_(Seq[Any](/*106.15*/rp/*106.17*/.getString("organigrama"))),format.raw/*106.42*/("""</td>
									<td align="center">	
										"""),_display_(Seq[Any](/*108.12*/if(rp.getBigDecimal("haber").compareTo(java.math.BigDecimal.ZERO) > 0)/*108.82*/{_display_(Seq[Any](format.raw/*108.83*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*109.35*/controllers/*109.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),1))),format.raw/*109.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*110.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*110.67*/("""
											</a>
										""")))}/*112.12*/else/*112.16*/{_display_(Seq[Any](_display_(Seq[Any](/*112.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber")))))))})),format.raw/*112.72*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*115.12*/if(rp.getBigDecimal("guardias").compareTo(java.math.BigDecimal.ZERO) > 0)/*115.85*/{_display_(Seq[Any](format.raw/*115.86*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*116.35*/controllers/*116.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),2))),format.raw/*116.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*117.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*117.70*/("""
											</a>
										""")))}/*119.12*/else/*119.16*/{_display_(Seq[Any](_display_(Seq[Any](/*119.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias")))))))})),format.raw/*119.75*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*122.12*/if(rp.getBigDecimal("produccion").compareTo(java.math.BigDecimal.ZERO) > 0)/*122.87*/{_display_(Seq[Any](format.raw/*122.88*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*123.35*/controllers/*123.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),3))),format.raw/*123.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*124.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*124.72*/("""
											</a>
										""")))}/*126.12*/else/*126.16*/{_display_(Seq[Any](_display_(Seq[Any](/*126.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion")))))))})),format.raw/*126.77*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*129.12*/if(rp.getBigDecimal("adicional").compareTo(java.math.BigDecimal.ZERO) > 0)/*129.86*/{_display_(Seq[Any](format.raw/*129.87*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*130.35*/controllers/*130.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),6))),format.raw/*130.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*131.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*131.71*/("""
											</a>
										""")))}/*133.12*/else/*133.16*/{_display_(Seq[Any](_display_(Seq[Any](/*133.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional")))))))})),format.raw/*133.76*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*136.12*/if(rp.getBigDecimal("descuentos").compareTo(java.math.BigDecimal.ZERO) > 0)/*136.87*/{_display_(Seq[Any](format.raw/*136.88*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*137.35*/controllers/*137.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),5))),format.raw/*137.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*138.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*138.72*/("""
											</a>
										""")))}/*140.12*/else/*140.16*/{_display_(Seq[Any](_display_(Seq[Any](/*140.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos")))))))})),format.raw/*140.77*/("""
									</td>									
									<td>"""),_display_(Seq[Any](/*142.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*142.67*/("""</td>
								</tr>
								""")))})),format.raw/*144.10*/("""
							""")))})),format.raw/*145.9*/("""					
						</tbody>
					</table>		
					
					
				</div>
			</div>	
		""")))})),format.raw/*152.4*/("""
	""")))})),format.raw/*153.3*/("""
	"""),_display_(Seq[Any](/*154.3*/if(rowPlanta != null)/*154.24*/{_display_(Seq[Any](format.raw/*154.25*/("""
		"""),_display_(Seq[Any](/*155.4*/if(rowPlanta.size() > 0)/*155.28*/{_display_(Seq[Any](format.raw/*155.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PLANTA/OTROS</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>NOMBRE</td>
								<td>PROFESION</td>
								<td>LUGAR</td>
								<td>HABER BRUTO</td>
								<td>GUARDIA</td>
								<td>PRODUCCION</td>	
								<td>ADICIONALES</td>	
								<td>DESCUENTOS</td>	
								<td>NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*175.9*/for(rp <- rowPlanta) yield /*175.29*/{_display_(Seq[Any](format.raw/*175.30*/("""
								"""),_display_(Seq[Any](/*176.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0)/*176.116*/{_display_(Seq[Any](format.raw/*176.117*/("""
								<tr>
									<td>"""),_display_(Seq[Any](/*178.15*/rp/*178.17*/.getString("nombre"))),format.raw/*178.37*/("""</td>
									<td>"""),_display_(Seq[Any](/*179.15*/rp/*179.17*/.getString("profesion"))),format.raw/*179.40*/("""</td>
									<td>"""),_display_(Seq[Any](/*180.15*/rp/*180.17*/.getString("organigrama"))),format.raw/*180.42*/("""</td>
									<td align="center">	
										"""),_display_(Seq[Any](/*182.12*/if(rp.getBigDecimal("haber").compareTo(java.math.BigDecimal.ZERO) > 0)/*182.82*/{_display_(Seq[Any](format.raw/*182.83*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*183.35*/controllers/*183.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),1))),format.raw/*183.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*184.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*184.67*/("""
											</a>
										""")))}/*186.12*/else/*186.16*/{_display_(Seq[Any](_display_(Seq[Any](/*186.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber")))))))})),format.raw/*186.72*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*189.12*/if(rp.getBigDecimal("guardias").compareTo(java.math.BigDecimal.ZERO) > 0)/*189.85*/{_display_(Seq[Any](format.raw/*189.86*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*190.35*/controllers/*190.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),2))),format.raw/*190.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*191.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*191.70*/("""
											</a>
										""")))}/*193.12*/else/*193.16*/{_display_(Seq[Any](_display_(Seq[Any](/*193.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias")))))))})),format.raw/*193.75*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*196.12*/if(rp.getBigDecimal("produccion").compareTo(java.math.BigDecimal.ZERO) > 0)/*196.87*/{_display_(Seq[Any](format.raw/*196.88*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*197.35*/controllers/*197.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),3))),format.raw/*197.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*198.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*198.72*/("""
											</a>
										""")))}/*200.12*/else/*200.16*/{_display_(Seq[Any](_display_(Seq[Any](/*200.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion")))))))})),format.raw/*200.77*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*203.12*/if(rp.getBigDecimal("adicional").compareTo(java.math.BigDecimal.ZERO) > 0)/*203.86*/{_display_(Seq[Any](format.raw/*203.87*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*204.35*/controllers/*204.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),6))),format.raw/*204.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*205.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*205.71*/("""
											</a>
										""")))}/*207.12*/else/*207.16*/{_display_(Seq[Any](_display_(Seq[Any](/*207.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional")))))))})),format.raw/*207.76*/("""
									</td>
									<td align="center">
										"""),_display_(Seq[Any](/*210.12*/if(rp.getBigDecimal("descuentos").compareTo(java.math.BigDecimal.ZERO) > 0)/*210.87*/{_display_(Seq[Any](format.raw/*210.88*/("""
											<a href="#" data-url=""""),_display_(Seq[Any](/*211.35*/controllers/*211.46*/.dashboard.routes.LiquidacionesController.getDetalleLiquidacionClasificacion(rp.getInteger("""idPuestoLaboral"""),rp.getInteger("""idPeriodo"""),5))),format.raw/*211.193*/("""" class="getDetalleLiquidacionClasificacion">
												"""),_display_(Seq[Any](/*212.14*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*212.72*/("""
											</a>
										""")))}/*214.12*/else/*214.16*/{_display_(Seq[Any](_display_(Seq[Any](/*214.18*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos")))))))})),format.raw/*214.77*/("""
									</td>
									<td>"""),_display_(Seq[Any](/*216.15*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*216.67*/("""</td>
								</tr>
								""")))})),format.raw/*218.10*/("""
							""")))})),format.raw/*219.9*/("""					
						</tbody>
					</table>		
					
					
				</div>
			</div>	
		""")))})),format.raw/*226.4*/("""
	""")))})))}
    }
    
    def render(rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(rowParque,rowConvenio,rowPlanta)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (rowParque,rowConvenio,rowPlanta) => apply(rowParque,rowConvenio,rowPlanta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:02 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/vistas/listaHaberesClasificacion.scala.html
                    HASH: 3ee76d317c61f5c46b36b5ad060145739270ca58
                    MATRIX: 905->1|1165->178|1197->202|1272->121|1300->246|1338->250|1367->271|1405->272|1443->276|1475->300|1513->301|2054->807|2090->827|2129->828|2175->838|2237->891|2276->892|2342->922|2353->924|2395->944|2452->965|2463->967|2508->990|2593->1039|2672->1109|2711->1110|2783->1146|2803->1157|2973->1304|3069->1364|3144->1417|3193->1447|3206->1451|3254->1453|3334->1507|3429->1566|3511->1639|3550->1640|3622->1676|3642->1687|3812->1834|3908->1894|3986->1950|4035->1980|4048->1984|4096->1986|4179->2043|4274->2102|4358->2177|4397->2178|4469->2214|4489->2225|4659->2372|4755->2432|4835->2490|4884->2520|4897->2524|4945->2526|5030->2585|5125->2644|5208->2718|5247->2719|5319->2755|5339->2766|5509->2913|5605->2973|5684->3030|5733->3060|5746->3064|5794->3066|5878->3124|5973->3183|6057->3258|6096->3259|6168->3295|6188->3306|6358->3453|6454->3513|6534->3571|6583->3601|6596->3605|6644->3607|6729->3666|6812->3713|6886->3765|6948->3795|6988->3804|7093->3878|7127->3881|7167->3886|7199->3909|7238->3910|7277->3914|7312->3940|7351->3941|7833->4387|7872->4409|7912->4410|7959->4420|8022->4473|8062->4474|8127->4502|8139->4504|8182->4524|8239->4544|8251->4546|8297->4569|8354->4589|8366->4591|8414->4616|8498->4663|8578->4733|8618->4734|8690->4769|8711->4780|8882->4927|8978->4986|9054->5039|9102->5067|9116->5071|9165->5073|9246->5127|9339->5183|9422->5256|9462->5257|9534->5292|9555->5303|9726->5450|9822->5509|9901->5565|9949->5593|9963->5597|10012->5599|10096->5656|10189->5712|10274->5787|10314->5788|10386->5823|10407->5834|10578->5981|10674->6040|10755->6098|10803->6126|10817->6130|10866->6132|10952->6191|11045->6247|11129->6321|11169->6322|11241->6357|11262->6368|11433->6515|11529->6574|11609->6631|11657->6659|11671->6663|11720->6665|11805->6723|11898->6779|11983->6854|12023->6855|12095->6890|12116->6901|12287->7048|12383->7107|12464->7165|12512->7193|12526->7197|12575->7199|12661->7258|12737->7297|12812->7349|12874->7378|12915->7387|13021->7461|13056->7464|13095->7467|13126->7488|13166->7489|13206->7493|13240->7517|13280->7518|13755->7957|13792->7977|13832->7978|13879->7988|13996->8094|14037->8095|14102->8123|14114->8125|14157->8145|14214->8165|14226->8167|14272->8190|14329->8210|14341->8212|14389->8237|14473->8284|14553->8354|14593->8355|14665->8390|14686->8401|14857->8548|14953->8607|15029->8660|15077->8688|15091->8692|15140->8694|15221->8748|15314->8804|15397->8877|15437->8878|15509->8913|15530->8924|15701->9071|15797->9130|15876->9186|15924->9214|15938->9218|15987->9220|16071->9277|16164->9333|16249->9408|16289->9409|16361->9444|16382->9455|16553->9602|16649->9661|16730->9719|16778->9747|16792->9751|16841->9753|16927->9812|17020->9868|17104->9942|17144->9943|17216->9978|17237->9989|17408->10136|17504->10195|17584->10252|17632->10280|17646->10284|17695->10286|17780->10344|17873->10400|17958->10475|17998->10476|18070->10511|18091->10522|18262->10669|18358->10728|18439->10786|18487->10814|18501->10818|18550->10820|18636->10879|18703->10909|18778->10961|18840->10990|18881->10999|18987->11073
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|38->8|38->8|38->8|57->27|57->27|57->27|58->28|58->28|58->28|60->30|60->30|60->30|61->31|61->31|61->31|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|67->37|67->37|67->37|67->37|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|74->44|74->44|74->44|74->44|77->47|77->47|77->47|78->48|78->48|78->48|79->49|79->49|81->51|81->51|81->51|81->51|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|88->58|88->58|88->58|88->58|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|95->65|95->65|95->65|95->65|97->67|97->67|99->69|100->70|107->77|108->78|110->80|110->80|110->80|111->81|111->81|111->81|131->101|131->101|131->101|132->102|132->102|132->102|134->104|134->104|134->104|135->105|135->105|135->105|136->106|136->106|136->106|138->108|138->108|138->108|139->109|139->109|139->109|140->110|140->110|142->112|142->112|142->112|142->112|145->115|145->115|145->115|146->116|146->116|146->116|147->117|147->117|149->119|149->119|149->119|149->119|152->122|152->122|152->122|153->123|153->123|153->123|154->124|154->124|156->126|156->126|156->126|156->126|159->129|159->129|159->129|160->130|160->130|160->130|161->131|161->131|163->133|163->133|163->133|163->133|166->136|166->136|166->136|167->137|167->137|167->137|168->138|168->138|170->140|170->140|170->140|170->140|172->142|172->142|174->144|175->145|182->152|183->153|184->154|184->154|184->154|185->155|185->155|185->155|205->175|205->175|205->175|206->176|206->176|206->176|208->178|208->178|208->178|209->179|209->179|209->179|210->180|210->180|210->180|212->182|212->182|212->182|213->183|213->183|213->183|214->184|214->184|216->186|216->186|216->186|216->186|219->189|219->189|219->189|220->190|220->190|220->190|221->191|221->191|223->193|223->193|223->193|223->193|226->196|226->196|226->196|227->197|227->197|227->197|228->198|228->198|230->200|230->200|230->200|230->200|233->203|233->203|233->203|234->204|234->204|234->204|235->205|235->205|237->207|237->207|237->207|237->207|240->210|240->210|240->210|241->211|241->211|241->211|242->212|242->212|244->214|244->214|244->214|244->214|246->216|246->216|248->218|249->219|256->226
                    -- GENERATED --
                */
            