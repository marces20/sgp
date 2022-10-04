
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
object deudasDetallesServicios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],java.util.List[Long],java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],java.util.Map[String, java.math.BigDecimal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],
peridoIds:java.util.List[Long],
pret:java.util.Map[String,java.util.Map[Long,java.math.BigDecimal]],
deudaSinPeriodos:java.util.Map[String,java.math.BigDecimal],
formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalDeudaOtros=new java.math.BigDecimal(0);var totalCompromisoOtros=new java.math.BigDecimal(0);var totalDeudaHearm=new java.math.BigDecimal(0);var totalCompromisoHearm=new java.math.BigDecimal(0);var totalTr=new java.math.BigDecimal(0);var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var columnas =6

import java.lang.String;var proveedorNombre =""

implicit def /*10.2*/implicitFieldConstructor/*10.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*5.27*/("""

"""),format.raw/*10.70*/("""
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.dashboard.mainDashboard("Deudas Servicios")/*14.56*/ {_display_(Seq[Any](format.raw/*14.58*/("""
"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*15.66*/("""

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
				  href=""""),_display_(Seq[Any](/*32.14*/controllers/*32.25*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasDetallesServiciosReportes())),format.raw/*32.114*/("""">Reporte Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*38.2*/{columnas = columnas+peridoIds.size()})),format.raw/*38.40*/("""
<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="">
			<thead>
				<th colspan=""""),_display_(Seq[Any](/*43.19*/columnas)),format.raw/*43.27*/("""" align="center" style="font-size:20px;text-align:center;">OPERARIVA - HEARM</th>
			</thead>
			<thead>
				<th>N° EXP.</th>
				<th>INSTITUCION</th>
				<th>PROVEEDOR</th>
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
						
						"""),_display_(Seq[Any](/*64.8*/if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null)/*64.122*/{_display_(Seq[Any](format.raw/*64.123*/("""
							<td>"""),_display_(Seq[Any](/*65.13*/utils/*65.18*/.NumberUtils.moneda(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString())))),format.raw/*65.141*/("""</td>
							"""),_display_(Seq[Any](/*66.9*/{totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*66.136*/("""
							"""),_display_(Seq[Any](/*67.9*/{totalDeudaHearm = totalDeudaHearm.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*67.152*/("""
						""")))}/*68.8*/else/*68.12*/{_display_(Seq[Any](format.raw/*68.13*/("""
							<td>"""),_display_(Seq[Any](/*69.13*/utils/*69.18*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*69.54*/("""</td>
						""")))})),format.raw/*70.8*/("""
						
						"""),_display_(Seq[Any](/*72.8*/for(pe <-peridoIds) yield /*72.27*/{_display_(Seq[Any](format.raw/*72.28*/("""
							"""),_display_(Seq[Any](/*73.9*/if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null)/*73.221*/{_display_(Seq[Any](format.raw/*73.222*/("""
								<td>"""),_display_(Seq[Any](/*74.14*/utils/*74.19*/.NumberUtils.moneda(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe)))),format.raw/*74.138*/("""</td>
								"""),_display_(Seq[Any](/*75.10*/{totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*75.133*/("""
								"""),_display_(Seq[Any](/*76.10*/{totalDeudaHearm = totalDeudaHearm.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*76.149*/("""
							""")))}/*77.9*/else/*77.13*/{_display_(Seq[Any](format.raw/*77.14*/("""
								<td>"""),_display_(Seq[Any](/*78.14*/utils/*78.19*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*78.55*/("""</td>
							""")))})),format.raw/*79.9*/("""
						""")))})),format.raw/*80.8*/("""
						
						<td>"""),_display_(Seq[Any](/*82.12*/utils/*82.17*/.NumberUtils.moneda(totalTr))),format.raw/*82.45*/("""</td>
					</tr>
				""")))})),format.raw/*84.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="3" align="right"><b>TOTALES</b></td>
					<td></td>
					"""),_display_(Seq[Any](/*90.7*/for(pe <-peridoIds) yield /*90.26*/{_display_(Seq[Any](format.raw/*90.27*/("""
						<td></td>
					""")))})),format.raw/*92.7*/("""
					<td><b>"""),_display_(Seq[Any](/*93.14*/utils/*93.19*/.NumberUtils.moneda(totalDeudaHearm))),format.raw/*93.55*/("""</b></td>
				</tr>
			</tfoot>
		</table>	
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		<table class="table table-bordered table-hover" id="">
			<thead>
				<th colspan=""""),_display_(Seq[Any](/*104.19*/columnas)),format.raw/*104.27*/("""" align="center" style="font-size:20px;text-align:center;">OPERARIVA - OTRAS INSTITUCIONES</th>
			</thead>
			<thead>
				<th>N° EXP.</th>
				<th>INSTITUCION</th>
				<th>PROVEEDOR</th>
				<th>S/D</th>
				"""),_display_(Seq[Any](/*111.6*/for(pe <- peridoIds) yield /*111.26*/{_display_(Seq[Any](format.raw/*111.27*/("""
					<th>"""),_display_(Seq[Any](/*112.11*/Periodo/*112.18*/.find.byId(pe).nombre)),format.raw/*112.39*/("""</th>
				""")))})),format.raw/*113.6*/("""
				<th>TOTAL</th>
			</thead>	
			<tbody>
				
				"""),_display_(Seq[Any](/*118.6*/for(s <- proveedorOtros) yield /*118.30*/{_display_(Seq[Any](format.raw/*118.31*/("""
					"""),_display_(Seq[Any](/*119.7*/{totalTr = new java.math.BigDecimal(0)})),format.raw/*119.46*/("""
					<tr style="background-color:#ffffff;">
						<td>"""),_display_(Seq[Any](/*121.12*/s/*121.13*/.getString("expediente"))),format.raw/*121.37*/("""</td>
						<td>"""),_display_(Seq[Any](/*122.12*/s/*122.13*/.getString("deposito"))),format.raw/*122.35*/("""</td>
						<td>"""),_display_(Seq[Any](/*123.12*/s/*123.13*/.getString("nombre_proveedor"))),format.raw/*123.43*/("""</td>
						 
						"""),_display_(Seq[Any](/*125.8*/if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null)/*125.122*/{_display_(Seq[Any](format.raw/*125.123*/("""
							<td>"""),_display_(Seq[Any](/*126.13*/utils/*126.18*/.NumberUtils.moneda(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString())))),format.raw/*126.141*/("""</td>
							"""),_display_(Seq[Any](/*127.9*/{totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*127.136*/("""
							"""),_display_(Seq[Any](/*128.9*/{totalDeudaOtros = totalDeudaOtros.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()))})),format.raw/*128.152*/("""
						""")))}/*129.8*/else/*129.12*/{_display_(Seq[Any](format.raw/*129.13*/("""
							<td>"""),_display_(Seq[Any](/*130.13*/utils/*130.18*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*130.54*/("""</td>
						""")))})),format.raw/*131.8*/("""
						
						
						"""),_display_(Seq[Any](/*134.8*/for(pe <-peridoIds) yield /*134.27*/{_display_(Seq[Any](format.raw/*134.28*/("""
							"""),_display_(Seq[Any](/*135.9*/if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null)/*135.221*/{_display_(Seq[Any](format.raw/*135.222*/("""
								<td>"""),_display_(Seq[Any](/*136.14*/utils/*136.19*/.NumberUtils.moneda(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe)))),format.raw/*136.138*/("""</td>
								"""),_display_(Seq[Any](/*137.10*/{totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*137.133*/("""
								"""),_display_(Seq[Any](/*138.10*/{totalDeudaOtros = totalDeudaOtros.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe))})),format.raw/*138.149*/("""
							""")))}/*139.9*/else/*139.13*/{_display_(Seq[Any](format.raw/*139.14*/("""
								<td>"""),_display_(Seq[Any](/*140.14*/utils/*140.19*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*140.55*/("""</td>
							""")))})),format.raw/*141.9*/("""
						""")))})),format.raw/*142.8*/("""
						
						<td>"""),_display_(Seq[Any](/*144.12*/utils/*144.17*/.NumberUtils.moneda(totalTr))),format.raw/*144.45*/("""</td>
					</tr>
				""")))})),format.raw/*146.6*/("""
			</tbody>
			<tfoot>
				<tr style="background-color:#dfdfdf;">
					<td colspan="3" align="right"><b>TOTALES</b></td>
					<td></td>
					"""),_display_(Seq[Any](/*152.7*/for(pe <-peridoIds) yield /*152.26*/{_display_(Seq[Any](format.raw/*152.27*/("""
						<td></td>
					""")))})),format.raw/*154.7*/("""
					<td><b>"""),_display_(Seq[Any](/*155.14*/utils/*155.19*/.NumberUtils.moneda(totalDeudaOtros))),format.raw/*155.55*/("""</b></td>
				</tr>
			</tfoot>
		</table>	
	</div>
</div>



""")))})))}
    }
    
    def render(proveedorHEARM:List[com.avaje.ebean.SqlRow],proveedorOtros:List[com.avaje.ebean.SqlRow],peridoIds:java.util.List[Long],pret:java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],deudaSinPeriodos:java.util.Map[String, java.math.BigDecimal],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],java.util.List[Long],java.util.Map[String, java.util.Map[Long, java.math.BigDecimal]],java.util.Map[String, java.math.BigDecimal],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador) => apply(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasDetallesServicios.scala.html
                    HASH: 58adfb6e90139bdc87eae31b1929d43b6b9e0820
                    MATRIX: 1015->1|2071->337|2104->361|2178->279|2208->405|2245->1044|2258->1049|2316->1098|2356->1100|2393->1102|2406->1107|2487->1166|3086->1729|3106->1740|3218->1829|3324->1900|3384->1938|3569->2087|3599->2095|3830->2291|3866->2311|3905->2312|3952->2323|3968->2330|4011->2351|4053->2362|4142->2416|4182->2440|4221->2441|4263->2448|4324->2487|4416->2543|4426->2544|4472->2568|4525->2585|4535->2586|4579->2608|4632->2625|4642->2626|4694->2656|4749->2676|4873->2790|4913->2791|4962->2804|4976->2809|5122->2932|5171->2946|5321->3073|5365->3082|5531->3225|5557->3233|5570->3237|5609->3238|5658->3251|5672->3256|5730->3292|5774->3305|5824->3320|5859->3339|5898->3340|5942->3349|6164->3561|6204->3562|6254->3576|6268->3581|6410->3700|6461->3715|6607->3838|6653->3848|6815->3987|6842->3996|6855->4000|6894->4001|6944->4015|6958->4020|7016->4056|7061->4070|7100->4078|7155->4097|7169->4102|7219->4130|7272->4152|7450->4295|7485->4314|7524->4315|7578->4338|7628->4352|7642->4357|7700->4393|7945->4601|7976->4609|8222->4819|8259->4839|8299->4840|8347->4851|8364->4858|8408->4879|8451->4890|8541->4944|8582->4968|8622->4969|8665->4976|8727->5015|8820->5071|8831->5072|8878->5096|8932->5113|8943->5114|8988->5136|9042->5153|9053->5154|9106->5184|9163->5205|9288->5319|9329->5320|9379->5333|9394->5338|9541->5461|9591->5475|9742->5602|9787->5611|9954->5754|9981->5762|9995->5766|10035->5767|10085->5780|10100->5785|10159->5821|10204->5834|10262->5856|10298->5875|10338->5876|10383->5885|10606->6097|10647->6098|10698->6112|10713->6117|10856->6236|10908->6251|11055->6374|11102->6384|11265->6523|11293->6532|11307->6536|11347->6537|11398->6551|11413->6556|11472->6592|11518->6606|11558->6614|11614->6633|11629->6638|11680->6666|11734->6688|11913->6831|11949->6850|11989->6851|12044->6874|12095->6888|12110->6893|12169->6929
                    LINES: 26->1|43->10|43->10|44->5|46->10|47->14|47->14|47->14|47->14|48->15|48->15|48->15|65->32|65->32|65->32|71->38|71->38|76->43|76->43|83->50|83->50|83->50|84->51|84->51|84->51|85->52|90->57|90->57|90->57|91->58|91->58|93->60|93->60|93->60|94->61|94->61|94->61|95->62|95->62|95->62|97->64|97->64|97->64|98->65|98->65|98->65|99->66|99->66|100->67|100->67|101->68|101->68|101->68|102->69|102->69|102->69|103->70|105->72|105->72|105->72|106->73|106->73|106->73|107->74|107->74|107->74|108->75|108->75|109->76|109->76|110->77|110->77|110->77|111->78|111->78|111->78|112->79|113->80|115->82|115->82|115->82|117->84|123->90|123->90|123->90|125->92|126->93|126->93|126->93|137->104|137->104|144->111|144->111|144->111|145->112|145->112|145->112|146->113|151->118|151->118|151->118|152->119|152->119|154->121|154->121|154->121|155->122|155->122|155->122|156->123|156->123|156->123|158->125|158->125|158->125|159->126|159->126|159->126|160->127|160->127|161->128|161->128|162->129|162->129|162->129|163->130|163->130|163->130|164->131|167->134|167->134|167->134|168->135|168->135|168->135|169->136|169->136|169->136|170->137|170->137|171->138|171->138|172->139|172->139|172->139|173->140|173->140|173->140|174->141|175->142|177->144|177->144|177->144|179->146|185->152|185->152|185->152|187->154|188->155|188->155|188->155
                    -- GENERATED --
                */
            