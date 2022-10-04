
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
object deudasDetallesOtros extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String,Boolean,Boolean,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorHEARM:List[com.avaje.ebean.SqlRow],
proveedorOtros:List[com.avaje.ebean.SqlRow],
cuenta:String,profe:Boolean,
equipamientos:Boolean,
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0

import java.lang.String;var proveedorNombre =""

implicit def /*9.2*/implicitFieldConstructor/*9.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*5.27*/("""
"""),format.raw/*9.70*/("""
"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.dashboard.mainDashboard("Deudas Otros")/*13.52*/ {_display_(Seq[Any](format.raw/*13.54*/("""
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*14.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Otros Proveedores - HEARM</h1>
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
				  href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasDetallesOtrosReportes(profe,equipamientos))),format.raw/*31.128*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*40.5*/views/*40.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles(cuenta,"HEARM",""))),format.raw/*40.77*/("""
			<tbody>
				"""),_display_(Seq[Any](/*42.6*/for(s <- proveedorHEARM) yield /*42.30*/{_display_(Seq[Any](format.raw/*42.31*/("""
					 
					
					"""),_display_(Seq[Any](/*45.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*45.73*/{_display_(Seq[Any](format.raw/*45.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*47.42*/proveedorNombre)),format.raw/*47.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*48.16*/utils/*48.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*48.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*49.16*/utils/*49.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*49.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*53.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*53.49*/("""
						"""),_display_(Seq[Any](/*54.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*54.54*/("""
						"""),_display_(Seq[Any](/*55.8*/{bandera = 0})),format.raw/*55.21*/("""
					""")))})),format.raw/*56.7*/(""" 
					"""),_display_(Seq[Any](/*57.7*/if(bandera == 0)/*57.23*/{_display_(Seq[Any](format.raw/*57.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*59.43*/s/*59.44*/.getString("nombre_proveedor"))),format.raw/*59.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*61.8*/{bandera = 1})),format.raw/*61.21*/("""
					""")))})),format.raw/*62.7*/("""
						"""),_display_(Seq[Any](/*63.8*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*63.67*/("""
						"""),_display_(Seq[Any](/*64.8*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*64.82*/("""
					 
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*67.12*/s/*67.13*/.getInteger("numeroProvision"))),format.raw/*67.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*68.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*68.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*69.12*/s/*69.13*/.getString("expediente"))),format.raw/*69.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*70.12*/s/*70.13*/.getString("nombre_proveedor"))),format.raw/*70.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*71.12*/utils/*71.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*71.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*72.12*/utils/*72.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*72.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*73.12*/s/*73.13*/.getString("rubro"))),format.raw/*73.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*74.12*/s/*74.13*/.getString("descripcion"))),format.raw/*74.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*76.7*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*76.57*/("""
					"""),_display_(Seq[Any](/*77.7*/{mtcoh= mtcoh.add(s.getBigDecimal("total_compromiso"))})),format.raw/*77.62*/("""
					"""),_display_(Seq[Any](/*78.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*78.50*/("""
					"""),_display_(Seq[Any](/*79.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*79.58*/("""
				""")))})),format.raw/*80.6*/("""
				"""),_display_(Seq[Any](/*81.6*/if(proveedorHEARM.size() >0)/*81.34*/{_display_(Seq[Any](format.raw/*81.35*/(""" 
					<tr>
						<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*83.41*/proveedorNombre)),format.raw/*83.56*/(""" - TOTAL</b></td>
						<td><b>"""),_display_(Seq[Any](/*84.15*/utils/*84.20*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*84.50*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*85.15*/utils/*85.20*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*85.55*/("""</b></td>
						<td colspan="2"></td>
					</tr>
					<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*89.6*/("""	 
				 
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*95.14*/utils/*95.19*/.NumberUtils.moneda(mtdoh))),format.raw/*95.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*96.14*/utils/*96.19*/.NumberUtils.moneda(mtcoh))),format.raw/*96.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*107.5*/views/*107.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles(cuenta,"OTRAS INSTITUCIONES",""))),format.raw/*107.91*/("""
			<tbody>
				"""),_display_(Seq[Any](/*109.6*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*109.47*/("""
				"""),_display_(Seq[Any](/*110.6*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*110.52*/("""
				"""),_display_(Seq[Any](/*111.6*/{proveedorNombre = ""})),format.raw/*111.28*/("""	
				"""),_display_(Seq[Any](/*112.6*/{bandera = 0})),format.raw/*112.19*/("""
				"""),_display_(Seq[Any](/*113.6*/for(s <- proveedorOtros) yield /*113.30*/{_display_(Seq[Any](format.raw/*113.31*/("""
					"""),_display_(Seq[Any](/*114.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*114.73*/{_display_(Seq[Any](format.raw/*114.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*116.42*/proveedorNombre)),format.raw/*116.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*117.16*/utils/*117.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*117.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*118.16*/utils/*118.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*118.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*122.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*122.49*/("""
						"""),_display_(Seq[Any](/*123.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*123.54*/("""
						"""),_display_(Seq[Any](/*124.8*/{bandera = 0})),format.raw/*124.21*/("""
					""")))})),format.raw/*125.7*/(""" 
					"""),_display_(Seq[Any](/*126.7*/if(bandera == 0)/*126.23*/{_display_(Seq[Any](format.raw/*126.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*128.43*/s/*128.44*/.getString("nombre_proveedor"))),format.raw/*128.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*130.8*/{bandera = 1})),format.raw/*130.21*/("""
					""")))})),format.raw/*131.7*/("""
					"""),_display_(Seq[Any](/*132.7*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*132.66*/("""
					"""),_display_(Seq[Any](/*133.7*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*133.81*/("""
						
					<tr>
						<td>"""),_display_(Seq[Any](/*136.12*/s/*136.13*/.getInteger("numeroProvision"))),format.raw/*136.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*137.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*137.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*138.12*/s/*138.13*/.getString("expediente"))),format.raw/*138.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*139.12*/s/*139.13*/.getString("nombre_proveedor"))),format.raw/*139.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*140.12*/utils/*140.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*140.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*141.12*/utils/*141.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*141.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*142.12*/s/*142.13*/.getString("rubro"))),format.raw/*142.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*143.12*/s/*143.13*/.getString("descripcion"))),format.raw/*143.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*145.7*/{mtdoo= mtdoo.add(s.getBigDecimal("total_deuda"))})),format.raw/*145.57*/("""
					"""),_display_(Seq[Any](/*146.7*/{mtcoo= mtcoo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*146.62*/("""
					"""),_display_(Seq[Any](/*147.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*147.50*/("""
					"""),_display_(Seq[Any](/*148.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*148.58*/("""	
				""")))})),format.raw/*149.6*/("""
				"""),_display_(Seq[Any](/*150.6*/if(proveedorOtros.size() >0)/*150.34*/{_display_(Seq[Any](format.raw/*150.35*/(""" 
				<tr>
					<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*152.40*/proveedorNombre)),format.raw/*152.55*/(""" - TOTAL</b></td>
					<td><b>"""),_display_(Seq[Any](/*153.14*/utils/*153.19*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*153.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*154.14*/utils/*154.19*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*154.54*/("""</b></td>
					<td colspan="2"></td>
				</tr>
				<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*158.6*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*163.14*/utils/*163.19*/.NumberUtils.moneda(mtdoo))),format.raw/*163.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*164.14*/utils/*164.19*/.NumberUtils.moneda(mtcoo))),format.raw/*164.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
""")))})),format.raw/*171.2*/("""
"""))}
    }
    
    def render(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],cuenta:String,profe:Boolean,equipamientos:Boolean,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String,Boolean,Boolean,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador) => apply(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasDetallesOtros.scala.html
                    HASH: 5c1577bad133c06c3a33e27c8ee5e772533fe0cc
                    MATRIX: 903->1|1591->227|1623->251|1697->170|1725->295|1762->676|1775->681|1829->726|1869->728|1906->730|1919->735|1999->793|2614->1372|2634->1383|2760->1486|3000->1691|3014->1696|3103->1763|3155->1780|3195->1804|3234->1805|3289->1825|3364->1891|3403->1892|3492->1945|3529->1960|3598->1993|3612->1998|3664->2028|3725->2053|3739->2058|3796->2093|3926->2188|3989->2229|4032->2237|4100->2283|4143->2291|4178->2304|4216->2311|4259->2319|4284->2335|4323->2336|4447->2424|4457->2425|4509->2455|4573->2484|4608->2497|4646->2504|4689->2512|4770->2571|4813->2579|4909->2653|5008->2716|5018->2717|5070->2747|5123->2764|5203->2822|5256->2839|5266->2840|5312->2864|5365->2881|5375->2882|5427->2912|5480->2929|5494->2934|5567->2985|5620->3002|5634->3007|5712->3063|5765->3080|5775->3081|5816->3100|5869->3117|5879->3118|5926->3143|5984->3166|6056->3216|6098->3223|6175->3278|6217->3285|6282->3328|6324->3335|6397->3386|6434->3392|6475->3398|6512->3426|6551->3427|6639->3479|6676->3494|6744->3526|6758->3531|6810->3561|6870->3585|6884->3590|6941->3625|7062->3715|7241->3858|7255->3863|7303->3889|7362->3912|7376->3917|7424->3943|7681->4164|7696->4169|7800->4250|7853->4267|7917->4308|7959->4314|8028->4360|8070->4366|8115->4388|8158->4395|8194->4408|8236->4414|8277->4438|8317->4439|8360->4446|8436->4512|8476->4513|8566->4566|8604->4581|8674->4614|8689->4619|8742->4649|8804->4674|8819->4679|8877->4714|9008->4809|9072->4850|9116->4858|9185->4904|9229->4912|9265->4925|9304->4932|9348->4940|9374->4956|9414->4957|9539->5045|9550->5046|9603->5076|9668->5105|9704->5118|9743->5125|9786->5132|9868->5191|9911->5198|10008->5272|10074->5301|10085->5302|10138->5332|10192->5349|10273->5407|10327->5424|10338->5425|10385->5449|10439->5466|10450->5467|10503->5497|10557->5514|10572->5519|10646->5570|10700->5587|10715->5592|10794->5648|10848->5665|10859->5666|10901->5685|10955->5702|10966->5703|11014->5728|11073->5751|11146->5801|11189->5808|11267->5863|11310->5870|11376->5913|11419->5920|11493->5971|11532->5978|11574->5984|11612->6012|11652->6013|11739->6063|11777->6078|11845->6109|11860->6114|11913->6144|11973->6167|11988->6172|12046->6207|12165->6294|12303->6395|12318->6400|12367->6426|12427->6449|12442->6454|12491->6480|12609->6566
                    LINES: 26->1|43->9|43->9|44->5|45->9|46->13|46->13|46->13|46->13|47->14|47->14|47->14|64->31|64->31|64->31|73->40|73->40|73->40|75->42|75->42|75->42|78->45|78->45|78->45|80->47|80->47|81->48|81->48|81->48|82->49|82->49|82->49|86->53|86->53|87->54|87->54|88->55|88->55|89->56|90->57|90->57|90->57|92->59|92->59|92->59|94->61|94->61|95->62|96->63|96->63|97->64|97->64|100->67|100->67|100->67|101->68|101->68|102->69|102->69|102->69|103->70|103->70|103->70|104->71|104->71|104->71|105->72|105->72|105->72|106->73|106->73|106->73|107->74|107->74|107->74|109->76|109->76|110->77|110->77|111->78|111->78|112->79|112->79|113->80|114->81|114->81|114->81|116->83|116->83|117->84|117->84|117->84|118->85|118->85|118->85|122->89|128->95|128->95|128->95|129->96|129->96|129->96|140->107|140->107|140->107|142->109|142->109|143->110|143->110|144->111|144->111|145->112|145->112|146->113|146->113|146->113|147->114|147->114|147->114|149->116|149->116|150->117|150->117|150->117|151->118|151->118|151->118|155->122|155->122|156->123|156->123|157->124|157->124|158->125|159->126|159->126|159->126|161->128|161->128|161->128|163->130|163->130|164->131|165->132|165->132|166->133|166->133|169->136|169->136|169->136|170->137|170->137|171->138|171->138|171->138|172->139|172->139|172->139|173->140|173->140|173->140|174->141|174->141|174->141|175->142|175->142|175->142|176->143|176->143|176->143|178->145|178->145|179->146|179->146|180->147|180->147|181->148|181->148|182->149|183->150|183->150|183->150|185->152|185->152|186->153|186->153|186->153|187->154|187->154|187->154|191->158|196->163|196->163|196->163|197->164|197->164|197->164|204->171
                    -- GENERATED --
                */
            