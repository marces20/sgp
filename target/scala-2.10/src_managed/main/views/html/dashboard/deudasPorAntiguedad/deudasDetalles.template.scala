
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
object deudasDetalles extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Boolean,Integer,java.util.Map[String, java.util.Map[String, List[List[com.avaje.ebean.SqlRow]]]],String,DynamicForm,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(equipamiento:Boolean,
idProveedor:Integer,
listaFinal:java.util.Map[String,java.util.Map[String,List[List[com.avaje.ebean.SqlRow]]]],
proveedor:String,
formBuscador: DynamicForm,
sinServicio:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0);var mtdos=new java.math.BigDecimal(0);var mtcos=new java.math.BigDecimal(0);var mtdph=new java.math.BigDecimal(0);var mtcph=new java.math.BigDecimal(0);var mtdpo=new java.math.BigDecimal(0);var mtcpo=new java.math.BigDecimal(0);var mtdps=new java.math.BigDecimal(0);var mtcps=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var xx =0

import java.lang.String;var proveedorNombre ="";var fecha =""


Seq[Any](format.raw/*6.21*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Deudas Detalles")/*10.55*/ {_display_(Seq[Any](format.raw/*10.57*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*12.66*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Detalles - """),_display_(Seq[Any](/*17.27*/proveedor)),format.raw/*17.36*/("""</h1>
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
				  <a id="" 
				  role="menuitem" tabindex="-1" 
				  href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasDetallesReporte(idProveedor,equipamiento,0,sinServicio))),format.raw/*31.142*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*41.4*/if(listaFinal.get("OPERATIVA") != null)/*41.43*/{_display_(Seq[Any](format.raw/*41.44*/("""
			"""),_display_(Seq[Any](/*42.5*/if(listaFinal.get("OPERATIVA").get("HEARM") != null)/*42.57*/{_display_(Seq[Any](format.raw/*42.58*/("""
				"""),_display_(Seq[Any](/*43.6*/if(listaFinal.get("OPERATIVA").get("HEARM").size() > 0)/*43.61*/{_display_(Seq[Any](format.raw/*43.62*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*45.8*/views/*45.13*/.html.dashboard.deudasPorAntiguedad.tablaDetalles("OPERATIVA","",proveedor))),format.raw/*45.88*/("""
						<tbody>
							
							"""),_display_(Seq[Any](/*48.9*/for(sx <- listaFinal.get("OPERATIVA").get("HEARM")) yield /*48.60*/{_display_(Seq[Any](format.raw/*48.61*/("""
								"""),_display_(Seq[Any](/*49.10*/for(s <- sx) yield /*49.22*/{_display_(Seq[Any](format.raw/*49.23*/("""
									 
										
										"""),_display_(Seq[Any](/*52.12*/{xx = 1})),format.raw/*52.20*/("""
										"""),_display_(Seq[Any](/*53.12*/if(fecha.compareToIgnoreCase("") != 0 && fecha.compareToIgnoreCase(s.getString("fecha_mes_ano")) != 0)/*53.114*/{_display_(Seq[Any](format.raw/*53.115*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*55.47*/fecha)),format.raw/*55.52*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*56.21*/utils/*56.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*56.56*/("""</b></td>
												<td></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*61.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*61.54*/("""
											"""),_display_(Seq[Any](/*62.13*/{bandera = 0})),format.raw/*62.26*/("""
										""")))})),format.raw/*63.12*/(""" 
										
										"""),_display_(Seq[Any](/*65.12*/if(bandera == 0)/*65.28*/{_display_(Seq[Any](format.raw/*65.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*67.48*/s/*67.49*/.getString("fecha_mes_ano"))),format.raw/*67.76*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*69.13*/{bandera = 1})),format.raw/*69.26*/("""
										""")))})),format.raw/*70.12*/("""
										
										"""),_display_(Seq[Any](/*72.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*72.71*/("""
										 
										<tr>
											<td>"""),_display_(Seq[Any](/*75.17*/s/*75.18*/.getInteger("numeroProvision"))),format.raw/*75.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*76.17*/(utils.DateUtils.formatDate(s.getDate("fecha"))))),format.raw/*76.65*/("""</td>
											<td>"""),_display_(Seq[Any](/*77.17*/s/*77.18*/.getString("expediente"))),format.raw/*77.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*78.17*/s/*78.18*/.getString("nombre_proveedor"))),format.raw/*78.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*79.17*/utils/*79.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*79.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*80.17*/s/*80.18*/.getString("deposito"))),format.raw/*80.40*/("""</td>
											<td>"""),_display_(Seq[Any](/*81.17*/s/*81.18*/.getString("rubro"))),format.raw/*81.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*82.17*/s/*82.18*/.getString("descripcion"))),format.raw/*82.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*84.12*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*84.62*/("""
										"""),_display_(Seq[Any](/*85.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*85.55*/("""
										"""),_display_(Seq[Any](/*86.12*/{fecha = s.getString("fecha_mes_ano")})),format.raw/*86.50*/("""
										"""),_display_(Seq[Any](/*87.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*87.63*/("""
									""")))})),format.raw/*88.11*/("""
								""")))})),format.raw/*89.10*/("""
								
							 
							"""),_display_(Seq[Any](/*92.9*/if(listaFinal.get("OPERATIVA").get("HEARM").size() >0 && xx == 1)/*92.74*/{_display_(Seq[Any](format.raw/*92.75*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*94.44*/fecha)),format.raw/*94.49*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*95.18*/utils/*95.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*95.53*/("""</b></td>
									<td></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*99.9*/("""
							"""),_display_(Seq[Any](/*100.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*100.50*/("""
							"""),_display_(Seq[Any](/*101.9*/{proveedorId =0})),format.raw/*101.25*/("""
							"""),_display_(Seq[Any](/*102.9*/{fecha =""})),format.raw/*102.20*/("""							
							"""),_display_(Seq[Any](/*103.9*/{bandera = 0})),format.raw/*103.22*/("""
							"""),_display_(Seq[Any](/*104.9*/{xx = 0})),format.raw/*104.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*109.17*/utils/*109.22*/.NumberUtils.moneda(mtdoh))),format.raw/*109.48*/("""</b></td>
								<td></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*115.6*/("""
			""")))})),format.raw/*116.5*/("""
		""")))})),format.raw/*117.4*/("""	
	</div>
</div>


<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*124.4*/if(listaFinal.get("PROFE") != null)/*124.39*/{_display_(Seq[Any](format.raw/*124.40*/("""
			"""),_display_(Seq[Any](/*125.5*/if(listaFinal.get("PROFE").get("HEARM") != null)/*125.53*/{_display_(Seq[Any](format.raw/*125.54*/("""
				"""),_display_(Seq[Any](/*126.6*/if(listaFinal.get("PROFE").get("HEARM").size() > 0)/*126.57*/{_display_(Seq[Any](format.raw/*126.58*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*128.8*/views/*128.13*/.html.dashboard.deudasPorAntiguedad.tablaDetalles("PROFE","",proveedor))),format.raw/*128.84*/("""
						<tbody>
							"""),_display_(Seq[Any](/*130.9*/for(sx <- listaFinal.get("PROFE").get("HEARM")) yield /*130.56*/{_display_(Seq[Any](format.raw/*130.57*/("""
								"""),_display_(Seq[Any](/*131.10*/for(s <- sx) yield /*131.22*/{_display_(Seq[Any](format.raw/*131.23*/("""
									"""),_display_(Seq[Any](/*132.11*/if(s.getString("rubro").compareTo("SERVICIOS") != 0)/*132.63*/{_display_(Seq[Any](format.raw/*132.64*/("""
										"""),_display_(Seq[Any](/*133.12*/{xx = 1})),format.raw/*133.20*/("""
										
										"""),_display_(Seq[Any](/*135.12*/if(fecha.compareToIgnoreCase("") != 0 && fecha.compareToIgnoreCase(s.getString("fecha_mes_ano")) != 0)/*135.114*/{_display_(Seq[Any](format.raw/*135.115*/("""
											<tr>
												<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*137.47*/proveedorNombre)),format.raw/*137.62*/(""" - TOTAL</b></td>
												<td><b>"""),_display_(Seq[Any](/*138.21*/utils/*138.26*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*138.56*/("""</b></td>
												<td></td>
												<td colspan="2"></td>
											</tr>
											<tr><td colspan="8"></td></tr>
											"""),_display_(Seq[Any](/*143.13*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*143.54*/("""
											"""),_display_(Seq[Any](/*144.13*/{bandera = 0})),format.raw/*144.26*/("""
										""")))})),format.raw/*145.12*/(""" 
										"""),_display_(Seq[Any](/*146.12*/if(bandera == 0)/*146.28*/{_display_(Seq[Any](format.raw/*146.29*/("""
											<tr style="background-color:#dfdfdf;">
												<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*148.48*/s/*148.49*/.getString("fecha_mes_ano"))),format.raw/*148.76*/("""</b></td>
											</tr>
											"""),_display_(Seq[Any](/*150.13*/{bandera = 1})),format.raw/*150.26*/("""
										""")))})),format.raw/*151.12*/("""
										"""),_display_(Seq[Any](/*152.12*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*152.71*/(""" 
										<tr>
											<td>"""),_display_(Seq[Any](/*154.17*/s/*154.18*/.getInteger("numeroProvision"))),format.raw/*154.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*155.17*/(utils.DateUtils.formatDate(s.getDate("fecha"))))),format.raw/*155.65*/("""</td>
											<td>"""),_display_(Seq[Any](/*156.17*/s/*156.18*/.getString("expediente"))),format.raw/*156.42*/("""</td>
											<td>"""),_display_(Seq[Any](/*157.17*/s/*157.18*/.getString("nombre_proveedor"))),format.raw/*157.48*/("""</td>
											<td>"""),_display_(Seq[Any](/*158.17*/utils/*158.22*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*158.73*/("""</td>
											<td>"""),_display_(Seq[Any](/*159.17*/s/*159.18*/.getString("deposito"))),format.raw/*159.40*/("""</td>
											<td>"""),_display_(Seq[Any](/*160.17*/s/*160.18*/.getString("rubro"))),format.raw/*160.37*/("""</td>
											<td>"""),_display_(Seq[Any](/*161.17*/s/*161.18*/.getString("descripcion"))),format.raw/*161.43*/("""</td>
										</tr>
										"""),_display_(Seq[Any](/*163.12*/{mtdph= mtdph.add(s.getBigDecimal("total_deuda"))})),format.raw/*163.62*/(""" 
										"""),_display_(Seq[Any](/*164.12*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*164.55*/("""
										"""),_display_(Seq[Any](/*165.12*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*165.63*/("""
										"""),_display_(Seq[Any](/*166.12*/{fecha = s.getString("fecha_mes_ano")})),format.raw/*166.50*/("""
									""")))})),format.raw/*167.11*/("""
									
								""")))})),format.raw/*169.10*/("""
								 
							""")))})),format.raw/*171.9*/("""
							"""),_display_(Seq[Any](/*172.9*/if(listaFinal.get("PROFE").get("HEARM").size() >0 && xx == 1)/*172.70*/{_display_(Seq[Any](format.raw/*172.71*/(""" 
								<tr>
									<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*174.44*/fecha)),format.raw/*174.49*/(""" - TOTAL</b></td>
									<td><b>"""),_display_(Seq[Any](/*175.18*/utils/*175.23*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*175.53*/("""</b></td>
									<td></td>
									<td colspan="2"></td>
								</tr>
							""")))})),format.raw/*179.9*/("""
							"""),_display_(Seq[Any](/*180.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*180.50*/("""
							"""),_display_(Seq[Any](/*181.9*/{proveedorId =0})),format.raw/*181.25*/("""
							"""),_display_(Seq[Any](/*182.9*/{bandera = 0})),format.raw/*182.22*/("""
							"""),_display_(Seq[Any](/*183.9*/{xx = 0})),format.raw/*183.17*/("""
							"""),_display_(Seq[Any](/*184.9*/{fecha =""})),format.raw/*184.20*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*189.17*/utils/*189.22*/.NumberUtils.moneda(mtdph))),format.raw/*189.48*/("""</b></td>
								<td></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*195.6*/("""
			""")))})),format.raw/*196.5*/("""
		""")))})),format.raw/*197.4*/("""	
	</div>
</div>





""")))})),format.raw/*205.2*/("""
 

"""))}
    }
    
    def render(equipamiento:Boolean,idProveedor:Integer,listaFinal:java.util.Map[String, java.util.Map[String, List[List[com.avaje.ebean.SqlRow]]]],proveedor:String,formBuscador:DynamicForm,sinServicio:Boolean): play.api.templates.HtmlFormat.Appendable = apply(equipamiento,idProveedor,listaFinal,proveedor,formBuscador,sinServicio)
    
    def f:((Boolean,Integer,java.util.Map[String, java.util.Map[String, List[List[com.avaje.ebean.SqlRow]]]],String,DynamicForm,Boolean) => play.api.templates.HtmlFormat.Appendable) = (equipamiento,idProveedor,listaFinal,proveedor,formBuscador,sinServicio) => apply(equipamiento,idProveedor,listaFinal,proveedor,formBuscador,sinServicio)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasDetalles.scala.html
                    HASH: 264063f634615383b1bd216b7803a425a5b79f01
                    MATRIX: 930->1|1930->201|1967->910|1980->915|2037->963|2077->965|2115->968|2128->973|2209->1032|2343->1130|2374->1139|2888->1617|2908->1628|3048->1745|3226->1888|3274->1927|3313->1928|3353->1933|3414->1985|3453->1986|3494->1992|3558->2047|3597->2048|3726->2142|3740->2147|3837->2222|3903->2253|3970->2304|4009->2305|4055->2315|4083->2327|4122->2328|4192->2362|4222->2370|4270->2382|4382->2484|4422->2485|4521->2548|4548->2553|4622->2591|4636->2596|4688->2626|4861->2763|4924->2804|4973->2817|5008->2830|5052->2842|5112->2866|5137->2882|5176->2883|5310->2981|5320->2982|5369->3009|5444->3048|5479->3061|5523->3073|5582->3096|5663->3155|5743->3199|5753->3200|5805->3230|5863->3252|5933->3300|5991->3322|6001->3323|6047->3347|6105->3369|6115->3370|6167->3400|6225->3422|6239->3427|6312->3478|6370->3500|6380->3501|6424->3523|6482->3545|6492->3546|6533->3565|6591->3587|6601->3588|6648->3613|6717->3646|6789->3696|6837->3708|6902->3751|6950->3763|7010->3801|7058->3813|7131->3864|7174->3875|7216->3885|7278->3912|7352->3977|7391->3978|7485->4036|7512->4041|7583->4076|7597->4081|7649->4111|7762->4193|7807->4202|7871->4243|7916->4252|7955->4268|8000->4277|8034->4288|8086->4304|8122->4317|8167->4326|8198->4334|8351->4450|8366->4455|8415->4481|8566->4600|8603->4605|8639->4609|8759->4693|8804->4728|8844->4729|8885->4734|8943->4782|8983->4783|9025->4789|9086->4840|9126->4841|9256->4935|9271->4940|9365->5011|9424->5034|9488->5081|9528->5082|9575->5092|9604->5104|9644->5105|9692->5116|9754->5168|9794->5169|9843->5181|9874->5189|9934->5212|10047->5314|10088->5315|10188->5378|10226->5393|10301->5431|10316->5436|10369->5466|10543->5603|10607->5644|10657->5657|10693->5670|10738->5682|10788->5695|10814->5711|10854->5712|10989->5810|11000->5811|11050->5838|11126->5877|11162->5890|11207->5902|11256->5914|11338->5973|11408->6006|11419->6007|11472->6037|11531->6059|11602->6107|11661->6129|11672->6130|11719->6154|11778->6176|11789->6177|11842->6207|11901->6229|11916->6234|11990->6285|12049->6307|12060->6308|12105->6330|12164->6352|12175->6353|12217->6372|12276->6394|12287->6395|12335->6420|12405->6453|12478->6503|12528->6516|12594->6559|12643->6571|12717->6622|12766->6634|12827->6672|12871->6683|12924->6703|12975->6722|13020->6731|13091->6792|13131->6793|13226->6851|13254->6856|13326->6891|13341->6896|13394->6926|13508->7008|13553->7017|13617->7058|13662->7067|13701->7083|13746->7092|13782->7105|13827->7114|13858->7122|13903->7131|13937->7142|14090->7258|14105->7263|14154->7289|14305->7408|14342->7413|14378->7417|14433->7440
                    LINES: 26->1|39->6|40->10|40->10|40->10|40->10|42->12|42->12|42->12|47->17|47->17|61->31|61->31|61->31|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|75->45|75->45|75->45|78->48|78->48|78->48|79->49|79->49|79->49|82->52|82->52|83->53|83->53|83->53|85->55|85->55|86->56|86->56|86->56|91->61|91->61|92->62|92->62|93->63|95->65|95->65|95->65|97->67|97->67|97->67|99->69|99->69|100->70|102->72|102->72|105->75|105->75|105->75|106->76|106->76|107->77|107->77|107->77|108->78|108->78|108->78|109->79|109->79|109->79|110->80|110->80|110->80|111->81|111->81|111->81|112->82|112->82|112->82|114->84|114->84|115->85|115->85|116->86|116->86|117->87|117->87|118->88|119->89|122->92|122->92|122->92|124->94|124->94|125->95|125->95|125->95|129->99|130->100|130->100|131->101|131->101|132->102|132->102|133->103|133->103|134->104|134->104|139->109|139->109|139->109|145->115|146->116|147->117|154->124|154->124|154->124|155->125|155->125|155->125|156->126|156->126|156->126|158->128|158->128|158->128|160->130|160->130|160->130|161->131|161->131|161->131|162->132|162->132|162->132|163->133|163->133|165->135|165->135|165->135|167->137|167->137|168->138|168->138|168->138|173->143|173->143|174->144|174->144|175->145|176->146|176->146|176->146|178->148|178->148|178->148|180->150|180->150|181->151|182->152|182->152|184->154|184->154|184->154|185->155|185->155|186->156|186->156|186->156|187->157|187->157|187->157|188->158|188->158|188->158|189->159|189->159|189->159|190->160|190->160|190->160|191->161|191->161|191->161|193->163|193->163|194->164|194->164|195->165|195->165|196->166|196->166|197->167|199->169|201->171|202->172|202->172|202->172|204->174|204->174|205->175|205->175|205->175|209->179|210->180|210->180|211->181|211->181|212->182|212->182|213->183|213->183|214->184|214->184|219->189|219->189|219->189|225->195|226->196|227->197|235->205
                    -- GENERATED --
                */
            