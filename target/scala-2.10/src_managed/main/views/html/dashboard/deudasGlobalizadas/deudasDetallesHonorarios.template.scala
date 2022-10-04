
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
object deudasDetallesHonorarios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorHEARM:List[com.avaje.ebean.SqlRow],
proveedorOtros:List[com.avaje.ebean.SqlRow],
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0

import java.lang.String;var proveedorNombre =""

implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*3.27*/("""
"""),format.raw/*7.70*/("""
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.mainDashboard("Deudas Servicios")/*11.56*/ {_display_(Seq[Any](format.raw/*11.58*/("""
"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*12.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Honorarios</h1>
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
				  href=""""),_display_(Seq[Any](/*29.14*/controllers/*29.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasDetallesHonorariosReportes())),format.raw/*29.114*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*38.5*/views/*38.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","HEARM",""))),format.raw/*38.82*/("""
			<tbody>
				"""),_display_(Seq[Any](/*40.6*/for(s <- proveedorHEARM) yield /*40.30*/{_display_(Seq[Any](format.raw/*40.31*/("""
					 
					
					"""),_display_(Seq[Any](/*43.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*43.73*/{_display_(Seq[Any](format.raw/*43.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*45.42*/proveedorNombre)),format.raw/*45.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*46.16*/utils/*46.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*46.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*47.16*/utils/*47.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*47.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*51.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*51.49*/("""
						"""),_display_(Seq[Any](/*52.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*52.54*/("""
						"""),_display_(Seq[Any](/*53.8*/{bandera = 0})),format.raw/*53.21*/("""
					""")))})),format.raw/*54.7*/(""" 
					"""),_display_(Seq[Any](/*55.7*/if(bandera == 0)/*55.23*/{_display_(Seq[Any](format.raw/*55.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*57.43*/s/*57.44*/.getString("nombre_proveedor"))),format.raw/*57.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*59.8*/{bandera = 1})),format.raw/*59.21*/("""
					""")))})),format.raw/*60.7*/("""
						"""),_display_(Seq[Any](/*61.8*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*61.67*/("""
						"""),_display_(Seq[Any](/*62.8*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*62.82*/("""
					 
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*65.12*/s/*65.13*/.getInteger("numeroProvision"))),format.raw/*65.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*66.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*66.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*67.12*/s/*67.13*/.getString("expediente"))),format.raw/*67.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*68.12*/s/*68.13*/.getString("nombre_proveedor"))),format.raw/*68.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*69.12*/utils/*69.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*69.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*70.12*/utils/*70.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*70.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*71.12*/s/*71.13*/.getString("rubro"))),format.raw/*71.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*72.12*/s/*72.13*/.getString("descripcion"))),format.raw/*72.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*74.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*74.57*/("""
					"""),_display_(Seq[Any](/*75.7*/{mtcoh= mtcoh.add(s.getBigDecimal("total_compromiso"))})),format.raw/*75.62*/("""
					"""),_display_(Seq[Any](/*76.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*76.50*/("""
					"""),_display_(Seq[Any](/*77.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*77.58*/("""
				""")))})),format.raw/*78.6*/("""
				"""),_display_(Seq[Any](/*79.6*/if(proveedorHEARM.size() >0)/*79.34*/{_display_(Seq[Any](format.raw/*79.35*/(""" 
					<tr>
						<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*81.41*/proveedorNombre)),format.raw/*81.56*/(""" - TOTAL</b></td>
						<td><b>"""),_display_(Seq[Any](/*82.15*/utils/*82.20*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*82.50*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*83.15*/utils/*83.20*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*83.55*/("""</b></td>
						<td colspan="2"></td>
					</tr>
					<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*87.6*/("""	 
				 
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*93.14*/utils/*93.19*/.NumberUtils.moneda(mtdoh))),format.raw/*93.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*94.14*/utils/*94.19*/.NumberUtils.moneda(mtcoh))),format.raw/*94.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*104.5*/views/*104.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles("OPERATIVA","OTRAS INSTITUCIONES",""))),format.raw/*104.96*/("""
			<tbody>
				"""),_display_(Seq[Any](/*106.6*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*106.47*/("""
				"""),_display_(Seq[Any](/*107.6*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*107.52*/("""
				"""),_display_(Seq[Any](/*108.6*/{proveedorNombre = ""})),format.raw/*108.28*/("""	
				"""),_display_(Seq[Any](/*109.6*/{proveedorId = 0})),format.raw/*109.23*/("""	
				"""),_display_(Seq[Any](/*110.6*/{bandera = 0})),format.raw/*110.19*/("""
				"""),_display_(Seq[Any](/*111.6*/for(s <- proveedorOtros) yield /*111.30*/{_display_(Seq[Any](format.raw/*111.31*/("""
					"""),_display_(Seq[Any](/*112.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*112.73*/{_display_(Seq[Any](format.raw/*112.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*114.42*/proveedorNombre)),format.raw/*114.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*115.16*/utils/*115.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*115.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*116.16*/utils/*116.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*116.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*120.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*120.49*/("""
						"""),_display_(Seq[Any](/*121.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*121.54*/("""
						"""),_display_(Seq[Any](/*122.8*/{bandera = 0})),format.raw/*122.21*/("""
					""")))})),format.raw/*123.7*/(""" 
					"""),_display_(Seq[Any](/*124.7*/if(bandera == 0)/*124.23*/{_display_(Seq[Any](format.raw/*124.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*126.43*/s/*126.44*/.getString("nombre_proveedor"))),format.raw/*126.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*128.8*/{bandera = 1})),format.raw/*128.21*/("""
					""")))})),format.raw/*129.7*/("""
					"""),_display_(Seq[Any](/*130.7*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*130.66*/("""
					"""),_display_(Seq[Any](/*131.7*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*131.81*/("""
						
					<tr>
						<td>"""),_display_(Seq[Any](/*134.12*/s/*134.13*/.getInteger("numeroProvision"))),format.raw/*134.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*135.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*135.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*136.12*/s/*136.13*/.getString("expediente"))),format.raw/*136.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*137.12*/s/*137.13*/.getString("nombre_proveedor"))),format.raw/*137.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*138.12*/utils/*138.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*138.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*139.12*/utils/*139.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*139.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*140.12*/s/*140.13*/.getString("rubro"))),format.raw/*140.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*141.12*/s/*141.13*/.getString("descripcion"))),format.raw/*141.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*143.7*/{mtdoo= mtdoo.add(s.getBigDecimal("total_deuda"))})),format.raw/*143.57*/("""
					"""),_display_(Seq[Any](/*144.7*/{mtcoo= mtcoo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*144.62*/("""
					"""),_display_(Seq[Any](/*145.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*145.50*/("""
					"""),_display_(Seq[Any](/*146.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*146.58*/("""	
				""")))})),format.raw/*147.6*/("""
				"""),_display_(Seq[Any](/*148.6*/if(proveedorOtros.size() >0)/*148.34*/{_display_(Seq[Any](format.raw/*148.35*/(""" 
				<tr>
					<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*150.40*/proveedorNombre)),format.raw/*150.55*/(""" - TOTAL</b></td>
					<td><b>"""),_display_(Seq[Any](/*151.14*/utils/*151.19*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*151.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*152.14*/utils/*152.19*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*152.54*/("""</b></td>
					<td colspan="2"></td>
				</tr>
				<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*156.6*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*161.14*/utils/*161.19*/.NumberUtils.moneda(mtdoo))),format.raw/*161.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*162.14*/utils/*162.19*/.NumberUtils.moneda(mtcoo))),format.raw/*162.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

""")))})))}
    }
    
    def render(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorHEARM,proveedorOtros,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorHEARM,proveedorOtros,formBuscador) => apply(proveedorHEARM,proveedorOtros,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallesHonorarios.scala.html
                    HASH: ba9d5560989811462663bbdd96ebcbec686ee6ad
                    MATRIX: 885->1|1521->175|1553->199|1627->118|1655->243|1692->624|1705->629|1763->678|1803->680|1840->682|1853->687|1933->745|2533->1309|2553->1320|2665->1409|2905->1614|2919->1619|3013->1691|3065->1708|3105->1732|3144->1733|3199->1753|3274->1819|3313->1820|3402->1873|3439->1888|3508->1921|3522->1926|3574->1956|3635->1981|3649->1986|3706->2021|3836->2116|3899->2157|3942->2165|4010->2211|4053->2219|4088->2232|4126->2239|4169->2247|4194->2263|4233->2264|4357->2352|4367->2353|4419->2383|4483->2412|4518->2425|4556->2432|4599->2440|4680->2499|4723->2507|4819->2581|4918->2644|4928->2645|4980->2675|5033->2692|5113->2750|5166->2767|5176->2768|5222->2792|5275->2809|5285->2810|5337->2840|5390->2857|5404->2862|5477->2913|5530->2930|5544->2935|5622->2991|5675->3008|5685->3009|5726->3028|5779->3045|5789->3046|5836->3071|5894->3094|5966->3144|6008->3151|6085->3206|6127->3213|6192->3256|6234->3263|6307->3314|6344->3320|6385->3326|6422->3354|6461->3355|6549->3407|6586->3422|6654->3454|6668->3459|6720->3489|6780->3513|6794->3518|6851->3553|6972->3643|7151->3786|7165->3791|7213->3817|7272->3840|7286->3845|7334->3871|7590->4091|7605->4096|7714->4182|7767->4199|7831->4240|7873->4246|7942->4292|7984->4298|8029->4320|8072->4327|8112->4344|8155->4351|8191->4364|8233->4370|8274->4394|8314->4395|8357->4402|8433->4468|8473->4469|8563->4522|8601->4537|8671->4570|8686->4575|8739->4605|8801->4630|8816->4635|8874->4670|9005->4765|9069->4806|9113->4814|9182->4860|9226->4868|9262->4881|9301->4888|9345->4896|9371->4912|9411->4913|9536->5001|9547->5002|9600->5032|9665->5061|9701->5074|9740->5081|9783->5088|9865->5147|9908->5154|10005->5228|10071->5257|10082->5258|10135->5288|10189->5305|10270->5363|10324->5380|10335->5381|10382->5405|10436->5422|10447->5423|10500->5453|10554->5470|10569->5475|10643->5526|10697->5543|10712->5548|10791->5604|10845->5621|10856->5622|10898->5641|10952->5658|10963->5659|11011->5684|11070->5707|11143->5757|11186->5764|11264->5819|11307->5826|11373->5869|11416->5876|11490->5927|11529->5934|11571->5940|11609->5968|11649->5969|11736->6019|11774->6034|11842->6065|11857->6070|11910->6100|11970->6123|11985->6128|12043->6163|12162->6250|12300->6351|12315->6356|12364->6382|12424->6405|12439->6410|12488->6436
                    LINES: 26->1|41->7|41->7|42->3|43->7|44->11|44->11|44->11|44->11|45->12|45->12|45->12|62->29|62->29|62->29|71->38|71->38|71->38|73->40|73->40|73->40|76->43|76->43|76->43|78->45|78->45|79->46|79->46|79->46|80->47|80->47|80->47|84->51|84->51|85->52|85->52|86->53|86->53|87->54|88->55|88->55|88->55|90->57|90->57|90->57|92->59|92->59|93->60|94->61|94->61|95->62|95->62|98->65|98->65|98->65|99->66|99->66|100->67|100->67|100->67|101->68|101->68|101->68|102->69|102->69|102->69|103->70|103->70|103->70|104->71|104->71|104->71|105->72|105->72|105->72|107->74|107->74|108->75|108->75|109->76|109->76|110->77|110->77|111->78|112->79|112->79|112->79|114->81|114->81|115->82|115->82|115->82|116->83|116->83|116->83|120->87|126->93|126->93|126->93|127->94|127->94|127->94|137->104|137->104|137->104|139->106|139->106|140->107|140->107|141->108|141->108|142->109|142->109|143->110|143->110|144->111|144->111|144->111|145->112|145->112|145->112|147->114|147->114|148->115|148->115|148->115|149->116|149->116|149->116|153->120|153->120|154->121|154->121|155->122|155->122|156->123|157->124|157->124|157->124|159->126|159->126|159->126|161->128|161->128|162->129|163->130|163->130|164->131|164->131|167->134|167->134|167->134|168->135|168->135|169->136|169->136|169->136|170->137|170->137|170->137|171->138|171->138|171->138|172->139|172->139|172->139|173->140|173->140|173->140|174->141|174->141|174->141|176->143|176->143|177->144|177->144|178->145|178->145|179->146|179->146|180->147|181->148|181->148|181->148|183->150|183->150|184->151|184->151|184->151|185->152|185->152|185->152|189->156|194->161|194->161|194->161|195->162|195->162|195->162
                    -- GENERATED --
                */
            