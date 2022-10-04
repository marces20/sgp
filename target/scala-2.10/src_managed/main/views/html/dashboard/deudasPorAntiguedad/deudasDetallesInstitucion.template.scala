
package views.html.dashboard.deudasPorAntiguedad

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
object deudasDetallesInstitucion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[java.util.Map[String, List[com.avaje.ebean.SqlRow]],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:java.util.Map[String,List[com.avaje.ebean.SqlRow]],formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0);var mtdos=new java.math.BigDecimal(0);var mtcos=new java.math.BigDecimal(0);var mtdph=new java.math.BigDecimal(0);var mtcph=new java.math.BigDecimal(0);var mtdpo=new java.math.BigDecimal(0);var mtcpo=new java.math.BigDecimal(0);var mtdps=new java.math.BigDecimal(0);var mtcps=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var xx =0

import java.lang.String;var institucionNombre ="";var fecha ="";var proveedor =""


Seq[Any](format.raw/*1.91*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.dashboard.mainDashboard("Deudas Detalles")/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*7.66*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Detalles por Institucion</h1>
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
				  href=""""),_display_(Seq[Any](/*25.14*/controllers/*25.25*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasDetallePorInstitucionReporte())),format.raw/*25.117*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		 
			"""),_display_(Seq[Any](/*36.5*/if(listaFinal.get("OPERATIVA") != null)/*36.44*/{_display_(Seq[Any](format.raw/*36.45*/("""
				"""),_display_(Seq[Any](/*37.6*/if(listaFinal.get("OPERATIVA").size() > 0)/*37.48*/{_display_(Seq[Any](format.raw/*37.49*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*39.8*/views/*39.13*/.html.dashboard.deudasPorAntiguedad.tablaDetalles("OPERATIVA","",proveedor))),format.raw/*39.88*/("""
						<tbody>
							
							"""),_display_(Seq[Any](/*42.9*/for(s <- listaFinal.get("OPERATIVA")) yield /*42.46*/{_display_(Seq[Any](format.raw/*42.47*/("""
								 
									 
										
										"""),_display_(Seq[Any](/*46.12*/{xx = 1})),format.raw/*46.20*/("""
										"""),_display_(Seq[Any](/*47.12*/if(institucionNombre.compareToIgnoreCase("") != 0 && institucionNombre.compareToIgnoreCase(s.getString("deposito")) != 0)/*47.133*/{_display_(Seq[Any](format.raw/*47.134*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*49.47*/institucionNombre)),format.raw/*49.64*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*50.21*/utils/*50.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*50.56*/("""</b></td>
												<td></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*55.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*55.54*/("""
											"""),_display_(Seq[Any](/*56.13*/{bandera = 0})),format.raw/*56.26*/("""
										""")))})),format.raw/*57.12*/(""" 
										
										"""),_display_(Seq[Any](/*59.12*/if(bandera == 0)/*59.28*/{_display_(Seq[Any](format.raw/*59.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*61.48*/s/*61.49*/.getString("deposito"))),format.raw/*61.71*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*63.13*/{bandera = 1})),format.raw/*63.26*/("""
										""")))})),format.raw/*64.12*/("""
										
										"""),_display_(Seq[Any](/*66.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*66.71*/("""
										 
										<tr>
											<td>"""),_display_(Seq[Any](/*69.17*/s/*69.18*/.getInteger("numeroProvision"))),format.raw/*69.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*70.17*/(utils.DateUtils.formatDate(s.getDate("fecha"))))),format.raw/*70.65*/("""</td>
											<td>"""),_display_(Seq[Any](/*71.17*/s/*71.18*/.getString("expediente"))),format.raw/*71.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*72.17*/s/*72.18*/.getString("nombre_proveedor"))),format.raw/*72.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*73.17*/utils/*73.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*73.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*74.17*/s/*74.18*/.getString("deposito"))),format.raw/*74.40*/("""</td>
											<td>"""),_display_(Seq[Any](/*75.17*/s/*75.18*/.getString("rubro"))),format.raw/*75.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*76.17*/s/*76.18*/.getString("descripcion"))),format.raw/*76.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*78.12*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*78.62*/("""
										"""),_display_(Seq[Any](/*79.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*79.55*/("""
										"""),_display_(Seq[Any](/*80.12*/{fecha = s.getString("fecha_mes_ano")})),format.raw/*80.50*/("""
										"""),_display_(Seq[Any](/*81.12*/{institucionNombre = s.getString("deposito")})),format.raw/*81.57*/("""
										 
									 
								 
								
							""")))})),format.raw/*86.9*/("""
							"""),_display_(Seq[Any](/*87.9*/if(listaFinal.get("OPERATIVA").size() >0 && xx == 1)/*87.61*/{_display_(Seq[Any](format.raw/*87.62*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*89.44*/institucionNombre)),format.raw/*89.61*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*90.18*/utils/*90.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*90.53*/("""</b></td>
									<td></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*94.9*/("""
							"""),_display_(Seq[Any](/*95.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*95.50*/("""
							"""),_display_(Seq[Any](/*96.9*/{proveedorId =0})),format.raw/*96.25*/("""
							"""),_display_(Seq[Any](/*97.9*/{fecha =""})),format.raw/*97.20*/("""		
							"""),_display_(Seq[Any](/*98.9*/{institucionNombre =""})),format.raw/*98.32*/("""					
							"""),_display_(Seq[Any](/*99.9*/{bandera = 0})),format.raw/*99.22*/("""
							"""),_display_(Seq[Any](/*100.9*/{xx = 0})),format.raw/*100.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*105.17*/utils/*105.22*/.NumberUtils.moneda(mtdoh))),format.raw/*105.48*/("""</b></td>
								<td></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*111.6*/("""
			""")))})),format.raw/*112.5*/("""
		 	
	</div>
</div>


<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*120.4*/if(listaFinal.get("PROFE") != null)/*120.39*/{_display_(Seq[Any](format.raw/*120.40*/("""
			 
				"""),_display_(Seq[Any](/*122.6*/if(listaFinal.get("PROFE").size() > 0)/*122.44*/{_display_(Seq[Any](format.raw/*122.45*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*124.8*/views/*124.13*/.html.dashboard.deudasPorAntiguedad.tablaDetalles("PROFE","",proveedor))),format.raw/*124.84*/("""
						<tbody>
							"""),_display_(Seq[Any](/*126.9*/for(s  <- listaFinal.get("PROFE")) yield /*126.43*/{_display_(Seq[Any](format.raw/*126.44*/("""
								 
									 
								"""),_display_(Seq[Any](/*129.10*/{xx = 1})),format.raw/*129.18*/("""
								
								"""),_display_(Seq[Any](/*131.10*/if(institucionNombre.compareToIgnoreCase("") != 0 && institucionNombre.compareToIgnoreCase(s.getString("deposito")) != 0)/*131.131*/{_display_(Seq[Any](format.raw/*131.132*/("""
									<tr>
										<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*133.45*/institucionNombre)),format.raw/*133.62*/(""" - TOTAL</b></td>
										<td><b>"""),_display_(Seq[Any](/*134.19*/utils/*134.24*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*134.54*/("""</b></td>
										<td></td>
										<td colspan="2"></td>
									</tr>
									<tr><td colspan="8"></td></tr>
									"""),_display_(Seq[Any](/*139.11*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*139.52*/("""
									"""),_display_(Seq[Any](/*140.11*/{bandera = 0})),format.raw/*140.24*/("""
								""")))})),format.raw/*141.10*/(""" 
								"""),_display_(Seq[Any](/*142.10*/if(bandera == 0)/*142.26*/{_display_(Seq[Any](format.raw/*142.27*/("""
									<tr style="background-color:#dfdfdf;">
										<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*144.46*/s/*144.47*/.getString("deposito"))),format.raw/*144.69*/("""</b></td>
									</tr>
									"""),_display_(Seq[Any](/*146.11*/{bandera = 1})),format.raw/*146.24*/("""
								""")))})),format.raw/*147.10*/("""
								"""),_display_(Seq[Any](/*148.10*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*148.69*/(""" 
								<tr>
									<td>"""),_display_(Seq[Any](/*150.15*/s/*150.16*/.getInteger("numeroProvision"))),format.raw/*150.46*/("""</td>
									<td>"""),_display_(Seq[Any](/*151.15*/(utils.DateUtils.formatDate(s.getDate("fecha"))))),format.raw/*151.63*/("""</td>
									<td>"""),_display_(Seq[Any](/*152.15*/s/*152.16*/.getString("expediente"))),format.raw/*152.40*/("""</td>
									<td>"""),_display_(Seq[Any](/*153.15*/s/*153.16*/.getString("nombre_proveedor"))),format.raw/*153.46*/("""</td>
									<td>"""),_display_(Seq[Any](/*154.15*/utils/*154.20*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*154.71*/("""</td>
									<td>"""),_display_(Seq[Any](/*155.15*/s/*155.16*/.getString("deposito"))),format.raw/*155.38*/("""</td>
									<td>"""),_display_(Seq[Any](/*156.15*/s/*156.16*/.getString("rubro"))),format.raw/*156.35*/("""</td>
									<td>"""),_display_(Seq[Any](/*157.15*/s/*157.16*/.getString("descripcion"))),format.raw/*157.41*/("""</td>
								</tr>
								"""),_display_(Seq[Any](/*159.10*/{mtdph= mtdph.add(s.getBigDecimal("total_deuda"))})),format.raw/*159.60*/(""" 
								"""),_display_(Seq[Any](/*160.10*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*160.53*/("""
								"""),_display_(Seq[Any](/*161.10*/{fecha = s.getString("fecha_mes_ano")})),format.raw/*161.48*/("""
								"""),_display_(Seq[Any](/*162.10*/{institucionNombre = s.getString("deposito")})),format.raw/*162.55*/("""	 
							""")))})),format.raw/*163.9*/("""
							
							"""),_display_(Seq[Any](/*165.9*/if(listaFinal.get("PROFE").size() >0 && xx == 1)/*165.57*/{_display_(Seq[Any](format.raw/*165.58*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*167.44*/institucionNombre)),format.raw/*167.61*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*168.18*/utils/*168.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*168.53*/("""</b></td>
									<td></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*172.9*/("""
							"""),_display_(Seq[Any](/*173.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*173.50*/("""
							"""),_display_(Seq[Any](/*174.9*/{proveedorId =0})),format.raw/*174.25*/("""
							"""),_display_(Seq[Any](/*175.9*/{bandera = 0})),format.raw/*175.22*/("""
							"""),_display_(Seq[Any](/*176.9*/{xx = 0})),format.raw/*176.17*/("""
							"""),_display_(Seq[Any](/*177.9*/{fecha =""})),format.raw/*177.20*/("""
							"""),_display_(Seq[Any](/*178.9*/{institucionNombre = ""})),format.raw/*178.33*/("""	
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*183.17*/utils/*183.22*/.NumberUtils.moneda(mtdph))),format.raw/*183.48*/("""</b></td>
								<td></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*189.6*/("""
			""")))})),format.raw/*190.5*/("""
		 	
	</div>
</div>





""")))})),format.raw/*199.2*/("""
 

"""))}
    }
    
    def render(listaFinal:java.util.Map[String, List[com.avaje.ebean.SqlRow]],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,formBuscador)
    
    def f:((java.util.Map[String, List[com.avaje.ebean.SqlRow]],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,formBuscador) => apply(listaFinal,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:59 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasDetallesInstitucion.scala.html
                    HASH: a55e6c95a076137be896c15f4ad166b304ff895b
                    MATRIX: 881->1|1790->90|1826->819|1838->824|1894->872|1933->874|1970->877|1982->882|2062->941|2679->1522|2699->1533|2814->1625|2997->1773|3045->1812|3084->1813|3125->1819|3176->1861|3215->1862|3344->1956|3358->1961|3455->2036|3521->2067|3574->2104|3613->2105|3693->2149|3723->2157|3771->2169|3902->2290|3942->2291|4041->2354|4080->2371|4154->2409|4168->2414|4220->2444|4393->2581|4456->2622|4505->2635|4540->2648|4584->2660|4644->2684|4669->2700|4708->2701|4842->2799|4852->2800|4896->2822|4971->2861|5006->2874|5050->2886|5109->2909|5190->2968|5270->3012|5280->3013|5332->3043|5390->3065|5460->3113|5518->3135|5528->3136|5574->3160|5632->3182|5642->3183|5694->3213|5752->3235|5766->3240|5839->3291|5897->3313|5907->3314|5951->3336|6009->3358|6019->3359|6060->3378|6118->3400|6128->3401|6175->3426|6244->3459|6316->3509|6364->3521|6429->3564|6477->3576|6537->3614|6585->3626|6652->3671|6734->3722|6778->3731|6839->3783|6878->3784|6972->3842|7011->3859|7082->3894|7096->3899|7148->3929|7261->4011|7305->4020|7368->4061|7412->4070|7450->4086|7494->4095|7527->4106|7573->4117|7618->4140|7667->4154|7702->4167|7747->4176|7778->4184|7931->4300|7946->4305|7995->4331|8146->4450|8183->4455|8307->4543|8352->4578|8392->4579|8439->4590|8487->4628|8527->4629|8657->4723|8672->4728|8766->4799|8825->4822|8876->4856|8916->4857|8984->4888|9015->4896|9071->4915|9203->5036|9244->5037|9340->5096|9380->5113|9453->5149|9468->5154|9521->5184|9685->5311|9749->5352|9797->5363|9833->5376|9876->5386|9924->5397|9950->5413|9990->5414|10121->5508|10132->5509|10177->5531|10249->5566|10285->5579|10328->5589|10375->5599|10457->5658|10523->5687|10534->5688|10587->5718|10644->5738|10715->5786|10772->5806|10783->5807|10830->5831|10887->5851|10898->5852|10951->5882|11008->5902|11023->5907|11097->5958|11154->5978|11165->5979|11210->6001|11267->6021|11278->6022|11320->6041|11377->6061|11388->6062|11436->6087|11502->6116|11575->6166|11623->6177|11689->6220|11736->6230|11797->6268|11844->6278|11912->6323|11955->6334|12008->6351|12066->6399|12106->6400|12201->6458|12241->6475|12313->6510|12328->6515|12381->6545|12495->6627|12540->6636|12604->6677|12649->6686|12688->6702|12733->6711|12769->6724|12814->6733|12845->6741|12890->6750|12924->6761|12969->6770|13016->6794|13170->6911|13185->6916|13234->6942|13385->7061|13422->7066|13481->7093
                    LINES: 26->1|34->1|35->5|35->5|35->5|35->5|37->7|37->7|37->7|55->25|55->25|55->25|66->36|66->36|66->36|67->37|67->37|67->37|69->39|69->39|69->39|72->42|72->42|72->42|76->46|76->46|77->47|77->47|77->47|79->49|79->49|80->50|80->50|80->50|85->55|85->55|86->56|86->56|87->57|89->59|89->59|89->59|91->61|91->61|91->61|93->63|93->63|94->64|96->66|96->66|99->69|99->69|99->69|100->70|100->70|101->71|101->71|101->71|102->72|102->72|102->72|103->73|103->73|103->73|104->74|104->74|104->74|105->75|105->75|105->75|106->76|106->76|106->76|108->78|108->78|109->79|109->79|110->80|110->80|111->81|111->81|116->86|117->87|117->87|117->87|119->89|119->89|120->90|120->90|120->90|124->94|125->95|125->95|126->96|126->96|127->97|127->97|128->98|128->98|129->99|129->99|130->100|130->100|135->105|135->105|135->105|141->111|142->112|150->120|150->120|150->120|152->122|152->122|152->122|154->124|154->124|154->124|156->126|156->126|156->126|159->129|159->129|161->131|161->131|161->131|163->133|163->133|164->134|164->134|164->134|169->139|169->139|170->140|170->140|171->141|172->142|172->142|172->142|174->144|174->144|174->144|176->146|176->146|177->147|178->148|178->148|180->150|180->150|180->150|181->151|181->151|182->152|182->152|182->152|183->153|183->153|183->153|184->154|184->154|184->154|185->155|185->155|185->155|186->156|186->156|186->156|187->157|187->157|187->157|189->159|189->159|190->160|190->160|191->161|191->161|192->162|192->162|193->163|195->165|195->165|195->165|197->167|197->167|198->168|198->168|198->168|202->172|203->173|203->173|204->174|204->174|205->175|205->175|206->176|206->176|207->177|207->177|208->178|208->178|213->183|213->183|213->183|219->189|220->190|229->199
                    -- GENERATED --
                */
            