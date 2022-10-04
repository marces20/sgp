
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
object deudasCuentas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Integer,String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listadoPorCuentaHEARM:List[com.avaje.ebean.SqlRow],listadoPorCuentaOtros:List[com.avaje.ebean.SqlRow],idCuenta:Integer,
nombre:String,
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
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.mainDashboard("Deudas Cuenta")/*11.53*/ {_display_(Seq[Any](format.raw/*11.55*/("""
"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*12.65*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas por Cuenta - """),_display_(Seq[Any](/*16.29*/nombre)),format.raw/*16.35*/("""</h1>
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
				  href=""""),_display_(Seq[Any](/*28.14*/controllers/*28.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasCuentasReportes(idCuenta,true))),format.raw/*28.116*/("""">Reporte Excel Resumido</a></li>
				<li role="presentation">
				  <a id="" role="menuitem" tabindex="-1" 
				  href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasCuentasReportes(idCuenta,false))),format.raw/*31.117*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*40.5*/views/*40.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles(nombre,"HEARM",""))),format.raw/*40.77*/("""
			<tbody>
				"""),_display_(Seq[Any](/*42.6*/for(s <- listadoPorCuentaHEARM) yield /*42.37*/{_display_(Seq[Any](format.raw/*42.38*/("""
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
				
					
				""")))})),format.raw/*80.6*/("""
				"""),_display_(Seq[Any](/*81.6*/if(listadoPorCuentaHEARM.size() >0)/*81.41*/{_display_(Seq[Any](format.raw/*81.42*/(""" 
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

<!-- -------------------------------------------------------------------------------- -->

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="listaInforme">
			"""),_display_(Seq[Any](/*109.5*/views/*109.10*/.html.dashboard.deudasGlobalizadas.tablaDetalles(nombre,"OTRAS INSTITUCIONES",""))),format.raw/*109.91*/("""
			<tbody>
				"""),_display_(Seq[Any](/*111.6*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*111.47*/("""
				"""),_display_(Seq[Any](/*112.6*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*112.52*/("""
				"""),_display_(Seq[Any](/*113.6*/{proveedorNombre = ""})),format.raw/*113.28*/("""	
				"""),_display_(Seq[Any](/*114.6*/{bandera = 0})),format.raw/*114.19*/("""
				"""),_display_(Seq[Any](/*115.6*/for(s <- listadoPorCuentaOtros) yield /*115.37*/{_display_(Seq[Any](format.raw/*115.38*/("""
					"""),_display_(Seq[Any](/*116.7*/if(proveedorId != 0 && proveedorId != s.getInteger("proveedorId"))/*116.73*/{_display_(Seq[Any](format.raw/*116.74*/("""
						<tr>
							<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*118.42*/proveedorNombre)),format.raw/*118.57*/(""" - TOTAL</b></td>
							<td><b>"""),_display_(Seq[Any](/*119.16*/utils/*119.21*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*119.51*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*120.16*/utils/*120.21*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*120.56*/("""</b></td>
							<td colspan="2"></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						"""),_display_(Seq[Any](/*124.8*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*124.49*/("""
						"""),_display_(Seq[Any](/*125.8*/{ptmpcompromiso = new java.math.BigDecimal(0)})),format.raw/*125.54*/("""
						"""),_display_(Seq[Any](/*126.8*/{bandera = 0})),format.raw/*126.21*/("""
					""")))})),format.raw/*127.7*/(""" 
					"""),_display_(Seq[Any](/*128.7*/if(bandera == 0)/*128.23*/{_display_(Seq[Any](format.raw/*128.24*/("""
						<tr style="background-color:#dfdfdf;">
							<td colspan="8" align="center"><b>"""),_display_(Seq[Any](/*130.43*/s/*130.44*/.getString("nombre_proveedor"))),format.raw/*130.74*/("""</b></td>
						</tr>
						"""),_display_(Seq[Any](/*132.8*/{bandera = 1})),format.raw/*132.21*/("""
					""")))})),format.raw/*133.7*/("""
					"""),_display_(Seq[Any](/*134.7*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*134.66*/("""
					"""),_display_(Seq[Any](/*135.7*/{ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"))})),format.raw/*135.81*/("""
						
					<tr>
						<td>"""),_display_(Seq[Any](/*138.12*/s/*138.13*/.getInteger("numeroProvision"))),format.raw/*138.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*139.12*/(utils.DateUtils.formatDate(s.getDate("fechaExpediente"))))),format.raw/*139.70*/("""</td>
						<td>"""),_display_(Seq[Any](/*140.12*/s/*140.13*/.getString("expediente"))),format.raw/*140.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*141.12*/s/*141.13*/.getString("nombre_proveedor"))),format.raw/*141.43*/("""</td>
						<td>"""),_display_(Seq[Any](/*142.12*/utils/*142.17*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*142.68*/("""</td>
						<td>"""),_display_(Seq[Any](/*143.12*/utils/*143.17*/.NumberUtils.moneda(s.getBigDecimal("total_compromiso")))),format.raw/*143.73*/("""</td>
						<td>"""),_display_(Seq[Any](/*144.12*/s/*144.13*/.getString("rubro"))),format.raw/*144.32*/("""</td>
						<td>"""),_display_(Seq[Any](/*145.12*/s/*145.13*/.getString("descripcion"))),format.raw/*145.38*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*147.7*/{mtdoo= mtdoo.add(s.getBigDecimal("total_deuda"))})),format.raw/*147.57*/("""
					"""),_display_(Seq[Any](/*148.7*/{mtcoo= mtcoo.add(s.getBigDecimal("total_compromiso"))})),format.raw/*148.62*/("""
					"""),_display_(Seq[Any](/*149.7*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*149.50*/("""
					"""),_display_(Seq[Any](/*150.7*/{proveedorNombre = s.getString("nombre_proveedor")})),format.raw/*150.58*/("""	
				""")))})),format.raw/*151.6*/("""
				"""),_display_(Seq[Any](/*152.6*/if(listadoPorCuentaOtros.size() >0)/*152.41*/{_display_(Seq[Any](format.raw/*152.42*/(""" 
				<tr>
					<td colspan="4" align="right"><b>"""),_display_(Seq[Any](/*154.40*/proveedorNombre)),format.raw/*154.55*/(""" - TOTAL</b></td>
					<td><b>"""),_display_(Seq[Any](/*155.14*/utils/*155.19*/.NumberUtils.moneda(ptmpdeuda))),format.raw/*155.49*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*156.14*/utils/*156.19*/.NumberUtils.moneda(ptmpcompromiso))),format.raw/*156.54*/("""</b></td>
					<td colspan="2"></td>
				</tr>
				<tr><td colspan="8"></td></tr>
				""")))})),format.raw/*160.6*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><b>TOTALES</b></td>
					<td><b>"""),_display_(Seq[Any](/*165.14*/utils/*165.19*/.NumberUtils.moneda(mtdoo))),format.raw/*165.45*/("""</b></td>
					<td><b>"""),_display_(Seq[Any](/*166.14*/utils/*166.19*/.NumberUtils.moneda(mtcoo))),format.raw/*166.45*/("""</b></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
""")))})))}
    }
    
    def render(listadoPorCuentaHEARM:List[com.avaje.ebean.SqlRow],listadoPorCuentaOtros:List[com.avaje.ebean.SqlRow],idCuenta:Integer,nombre:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(listadoPorCuentaHEARM,listadoPorCuentaOtros,idCuenta,nombre,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Integer,String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (listadoPorCuentaHEARM,listadoPorCuentaOtros,idCuenta,nombre,formBuscador) => apply(listadoPorCuentaHEARM,listadoPorCuentaOtros,idCuenta,nombre,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasCuentas.scala.html
                    HASH: da750b34829dda455c427bf1c6640f876920acf8
                    MATRIX: 889->1|1570->220|1602->244|1676->163|1704->288|1741->669|1754->674|1809->720|1849->722|1886->724|1899->729|1979->787|2114->886|2142->892|2646->1360|2666->1371|2780->1462|2938->1584|2958->1595|3073->1687|3313->1892|3327->1897|3416->1964|3468->1981|3515->2012|3554->2013|3596->2020|3671->2086|3710->2087|3799->2140|3836->2155|3905->2188|3919->2193|3971->2223|4032->2248|4046->2253|4103->2288|4233->2383|4296->2424|4339->2432|4407->2478|4450->2486|4485->2499|4523->2506|4566->2514|4591->2530|4630->2531|4754->2619|4764->2620|4816->2650|4880->2679|4915->2692|4953->2699|4996->2707|5077->2766|5120->2774|5216->2848|5315->2911|5325->2912|5377->2942|5430->2959|5510->3017|5563->3034|5573->3035|5619->3059|5672->3076|5682->3077|5734->3107|5787->3124|5801->3129|5874->3180|5927->3197|5941->3202|6019->3258|6072->3275|6082->3276|6123->3295|6176->3312|6186->3313|6233->3338|6291->3361|6363->3411|6405->3418|6482->3473|6524->3480|6589->3523|6631->3530|6704->3581|6752->3598|6793->3604|6837->3639|6876->3640|6964->3692|7001->3707|7069->3739|7083->3744|7135->3774|7195->3798|7209->3803|7266->3838|7387->3928|7566->4071|7580->4076|7628->4102|7687->4125|7701->4130|7749->4156|8097->4468|8112->4473|8216->4554|8269->4571|8333->4612|8375->4618|8444->4664|8486->4670|8531->4692|8574->4699|8610->4712|8652->4718|8700->4749|8740->4750|8783->4757|8859->4823|8899->4824|8989->4877|9027->4892|9097->4925|9112->4930|9165->4960|9227->4985|9242->4990|9300->5025|9431->5120|9495->5161|9539->5169|9608->5215|9652->5223|9688->5236|9727->5243|9771->5251|9797->5267|9837->5268|9962->5356|9973->5357|10026->5387|10091->5416|10127->5429|10166->5436|10209->5443|10291->5502|10334->5509|10431->5583|10497->5612|10508->5613|10561->5643|10615->5660|10696->5718|10750->5735|10761->5736|10808->5760|10862->5777|10873->5778|10926->5808|10980->5825|10995->5830|11069->5881|11123->5898|11138->5903|11217->5959|11271->5976|11282->5977|11324->5996|11378->6013|11389->6014|11437->6039|11496->6062|11569->6112|11612->6119|11690->6174|11733->6181|11799->6224|11842->6231|11916->6282|11955->6289|11997->6295|12042->6330|12082->6331|12169->6381|12207->6396|12275->6427|12290->6432|12343->6462|12403->6485|12418->6490|12476->6525|12595->6612|12733->6713|12748->6718|12797->6744|12857->6767|12872->6772|12921->6798
                    LINES: 26->1|41->7|41->7|42->3|43->7|44->11|44->11|44->11|44->11|45->12|45->12|45->12|49->16|49->16|61->28|61->28|61->28|64->31|64->31|64->31|73->40|73->40|73->40|75->42|75->42|75->42|76->43|76->43|76->43|78->45|78->45|79->46|79->46|79->46|80->47|80->47|80->47|84->51|84->51|85->52|85->52|86->53|86->53|87->54|88->55|88->55|88->55|90->57|90->57|90->57|92->59|92->59|93->60|94->61|94->61|95->62|95->62|98->65|98->65|98->65|99->66|99->66|100->67|100->67|100->67|101->68|101->68|101->68|102->69|102->69|102->69|103->70|103->70|103->70|104->71|104->71|104->71|105->72|105->72|105->72|107->74|107->74|108->75|108->75|109->76|109->76|110->77|110->77|113->80|114->81|114->81|114->81|116->83|116->83|117->84|117->84|117->84|118->85|118->85|118->85|122->89|128->95|128->95|128->95|129->96|129->96|129->96|142->109|142->109|142->109|144->111|144->111|145->112|145->112|146->113|146->113|147->114|147->114|148->115|148->115|148->115|149->116|149->116|149->116|151->118|151->118|152->119|152->119|152->119|153->120|153->120|153->120|157->124|157->124|158->125|158->125|159->126|159->126|160->127|161->128|161->128|161->128|163->130|163->130|163->130|165->132|165->132|166->133|167->134|167->134|168->135|168->135|171->138|171->138|171->138|172->139|172->139|173->140|173->140|173->140|174->141|174->141|174->141|175->142|175->142|175->142|176->143|176->143|176->143|177->144|177->144|177->144|178->145|178->145|178->145|180->147|180->147|181->148|181->148|182->149|182->149|183->150|183->150|184->151|185->152|185->152|185->152|187->154|187->154|188->155|188->155|188->155|189->156|189->156|189->156|193->160|198->165|198->165|198->165|199->166|199->166|199->166
                    -- GENERATED --
                */
            