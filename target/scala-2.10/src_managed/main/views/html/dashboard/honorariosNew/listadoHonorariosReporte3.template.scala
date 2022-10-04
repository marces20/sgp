
package views.html.dashboard.honorariosNew

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
object listadoHonorariosReporte3 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(
escalasLaborales:List[models.haberes.EscalaLaboral],
escalasLiquidacionesNoCmList:java.util.TreeMap[String,java.util.Map[String,String]],
escalasLiquidacionesCmList:java.util.TreeMap[String,java.util.Map[String,String]],
escalasAsistencialProfesionNoCmList:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
escalasNoAsistencialProfesionNoCmList:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
escalasAsistencialProfesionCmList:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
escalasNoAsistencialProfesionCmList:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]]


):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var x=new java.math.BigDecimal(0);

implicit def /*13.2*/implicitFieldConstructor/*13.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*11.2*/("""
"""),format.raw/*13.70*/(""" 
"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.dashboard.mainDashboard("Honorarios")/*15.50*/ {_display_(Seq[Any](format.raw/*15.52*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Estado de Honorarios</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<hr><hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad En liquidaciones por Escala Parque Salud</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*43.7*/for((key,value) <- escalasLiquidacionesNoCmList) yield /*43.55*/{_display_(Seq[Any](format.raw/*43.56*/("""
						<td>"""),_display_(Seq[Any](/*44.12*/key)),format.raw/*44.15*/("""</td>
						
					""")))})),format.raw/*46.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*50.6*/for(el <- escalasLaborales) yield /*50.33*/{_display_(Seq[Any](format.raw/*50.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*52.11*/el/*52.13*/.nombre)),format.raw/*52.20*/("""</td>
					"""),_display_(Seq[Any](/*53.7*/for((key,value) <- escalasLiquidacionesNoCmList) yield /*53.55*/{_display_(Seq[Any](format.raw/*53.56*/("""
						<td>"""),_display_(Seq[Any](/*54.12*/if(value.get(el.nombre) != null)/*54.44*/{_display_(Seq[Any](_display_(Seq[Any](/*54.46*/value/*54.51*/.get(el.nombre)))))})),format.raw/*54.67*/("""</td>
					""")))})),format.raw/*55.7*/("""
				</tr>
				""")))})),format.raw/*57.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad liquidaciones por Escala CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*69.7*/for((key,value) <- escalasLiquidacionesCmList) yield /*69.53*/{_display_(Seq[Any](format.raw/*69.54*/("""
						<td>"""),_display_(Seq[Any](/*70.12*/key)),format.raw/*70.15*/("""</td>
						
					""")))})),format.raw/*72.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*76.6*/for(el <- escalasLaborales) yield /*76.33*/{_display_(Seq[Any](format.raw/*76.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*78.11*/el/*78.13*/.nombre)),format.raw/*78.20*/("""</td>
					"""),_display_(Seq[Any](/*79.7*/for((key,value) <- escalasLiquidacionesCmList) yield /*79.53*/{_display_(Seq[Any](format.raw/*79.54*/("""
						<td>"""),_display_(Seq[Any](/*80.12*/if(value.get(el.nombre) != null)/*80.44*/{_display_(Seq[Any](_display_(Seq[Any](/*80.46*/value/*80.51*/.get(el.nombre)))))})),format.raw/*80.67*/("""</td>
					""")))})),format.raw/*81.7*/("""
				</tr>
				""")))})),format.raw/*83.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<hr><hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion Asistencia PS</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion Asistencia PS</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*100.5*/for(el <- escalasLaborales) yield /*100.32*/{_display_(Seq[Any](format.raw/*100.33*/("""
				"""),_display_(Seq[Any](/*101.6*/if(escalasAsistencialProfesionNoCmList.get(el.nombre) != null)/*101.68*/{_display_(Seq[Any](format.raw/*101.69*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*106.83*/el/*106.85*/.nombre)),format.raw/*106.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*108.7*/{x =new java.math.BigDecimal(0)})),format.raw/*108.39*/("""
					"""),_display_(Seq[Any](/*109.7*/for((key,value) <- escalasAsistencialProfesionNoCmList.get(el.nombre)) yield /*109.77*/{_display_(Seq[Any](format.raw/*109.78*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*111.13*/key)),format.raw/*111.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*112.13*/value)),format.raw/*112.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*114.8*/{x = x.add(value)})),format.raw/*114.26*/("""
					""")))})),format.raw/*115.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*118.12*/x)),format.raw/*118.13*/("""</td>
					</tr>
				""")))})),format.raw/*120.6*/(""" 
			""")))})),format.raw/*121.5*/("""
		</tbody>
		</table>	
	</div>	
</div>	
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion No Asistencial PS</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion No Asistencial Ps</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*137.5*/for(el <- escalasLaborales) yield /*137.32*/{_display_(Seq[Any](format.raw/*137.33*/("""
				"""),_display_(Seq[Any](/*138.6*/if(escalasNoAsistencialProfesionNoCmList.get(el.nombre) != null)/*138.70*/{_display_(Seq[Any](format.raw/*138.71*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*143.83*/el/*143.85*/.nombre)),format.raw/*143.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*145.7*/{x =new java.math.BigDecimal(0)})),format.raw/*145.39*/("""
					"""),_display_(Seq[Any](/*146.7*/for((key,value) <- escalasNoAsistencialProfesionNoCmList.get(el.nombre)) yield /*146.79*/{_display_(Seq[Any](format.raw/*146.80*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*148.13*/key)),format.raw/*148.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*149.13*/value)),format.raw/*149.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*151.8*/{x = x.add(value)})),format.raw/*151.26*/("""
					""")))})),format.raw/*152.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*155.12*/x)),format.raw/*155.13*/("""</td>
					</tr>
				""")))})),format.raw/*157.6*/(""" 
			""")))})),format.raw/*158.5*/("""
		</tbody>
		</table>	
	</div>	
</div>	
<hr><hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion Asistencial CM</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion CM</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*175.5*/for(el <- escalasLaborales) yield /*175.32*/{_display_(Seq[Any](format.raw/*175.33*/("""
				"""),_display_(Seq[Any](/*176.6*/if(escalasAsistencialProfesionCmList.get(el.nombre) != null)/*176.66*/{_display_(Seq[Any](format.raw/*176.67*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*181.83*/el/*181.85*/.nombre)),format.raw/*181.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*183.7*/{x =new java.math.BigDecimal(0)})),format.raw/*183.39*/("""
					"""),_display_(Seq[Any](/*184.7*/for((key,value) <- escalasAsistencialProfesionCmList.get(el.nombre)) yield /*184.75*/{_display_(Seq[Any](format.raw/*184.76*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*186.13*/key)),format.raw/*186.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*187.13*/value)),format.raw/*187.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*189.8*/{x = x.add(value)})),format.raw/*189.26*/("""
					""")))})),format.raw/*190.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*193.12*/x)),format.raw/*193.13*/("""</td>
					</tr>
				""")))})),format.raw/*195.6*/(""" 
			""")))})),format.raw/*196.5*/("""
		</tbody>
		</table>	
	</div>	
</div>	
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion No Asistencial CM</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion No Asistencial CM</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*212.5*/for(el <- escalasLaborales) yield /*212.32*/{_display_(Seq[Any](format.raw/*212.33*/("""
				"""),_display_(Seq[Any](/*213.6*/if(escalasNoAsistencialProfesionCmList.get(el.nombre) != null)/*213.68*/{_display_(Seq[Any](format.raw/*213.69*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*218.83*/el/*218.85*/.nombre)),format.raw/*218.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*220.7*/{x =new java.math.BigDecimal(0)})),format.raw/*220.39*/("""
					"""),_display_(Seq[Any](/*221.7*/for((key,value) <- escalasNoAsistencialProfesionCmList.get(el.nombre)) yield /*221.77*/{_display_(Seq[Any](format.raw/*221.78*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*223.13*/key)),format.raw/*223.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*224.13*/value)),format.raw/*224.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*226.8*/{x = x.add(value)})),format.raw/*226.26*/("""
					""")))})),format.raw/*227.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*230.12*/x)),format.raw/*230.13*/("""</td>
					</tr>
				""")))})),format.raw/*232.6*/(""" 
			""")))})),format.raw/*233.5*/("""
		</tbody>
		</table>	
	</div>	
</div>	
""")))})))}
    }
    
    def render(escalasLaborales:List[models.haberes.EscalaLaboral],escalasLiquidacionesNoCmList:java.util.TreeMap[String, java.util.Map[String, String]],escalasLiquidacionesCmList:java.util.TreeMap[String, java.util.Map[String, String]],escalasAsistencialProfesionNoCmList:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],escalasNoAsistencialProfesionNoCmList:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],escalasAsistencialProfesionCmList:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],escalasNoAsistencialProfesionCmList:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]]): play.api.templates.HtmlFormat.Appendable = apply(escalasLaborales,escalasLiquidacionesNoCmList,escalasLiquidacionesCmList,escalasAsistencialProfesionNoCmList,escalasNoAsistencialProfesionNoCmList,escalasAsistencialProfesionCmList,escalasNoAsistencialProfesionCmList)
    
    def f:((List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]]) => play.api.templates.HtmlFormat.Appendable) = (escalasLaborales,escalasLiquidacionesNoCmList,escalasLiquidacionesCmList,escalasAsistencialProfesionNoCmList,escalasNoAsistencialProfesionNoCmList,escalasAsistencialProfesionCmList,escalasNoAsistencialProfesionCmList) => apply(escalasLaborales,escalasLiquidacionesNoCmList,escalasLiquidacionesCmList,escalasAsistencialProfesionNoCmList,escalasNoAsistencialProfesionNoCmList,escalasAsistencialProfesionCmList,escalasNoAsistencialProfesionCmList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorariosNew/listadoHonorariosReporte3.scala.html
                    HASH: f34b933d57e7f78d9390bb627e99303a6c41b915
                    MATRIX: 1244->1|2060->669|2093->693|2167->650|2196->737|2234->804|2247->809|2299->852|2339->854|3105->1585|3169->1633|3208->1634|3256->1646|3281->1649|3331->1668|3405->1707|3448->1734|3487->1735|3543->1755|3554->1757|3583->1764|3630->1776|3694->1824|3733->1825|3781->1837|3822->1869|3870->1871|3884->1876|3926->1892|3969->1904|4016->1920|4278->2147|4340->2193|4379->2194|4427->2206|4452->2209|4502->2228|4576->2267|4619->2294|4658->2295|4714->2315|4725->2317|4754->2324|4801->2336|4863->2382|4902->2383|4950->2395|4991->2427|5039->2429|5053->2434|5095->2450|5138->2462|5185->2478|5541->2798|5585->2825|5625->2826|5667->2832|5739->2894|5779->2895|5974->3053|5986->3055|6016->3062|6075->3085|6130->3117|6173->3124|6260->3194|6300->3195|6361->3219|6387->3222|6442->3240|6470->3245|6531->3270|6572->3288|6611->3295|6691->3338|6715->3339|6769->3361|6807->3367|7162->3686|7206->3713|7246->3714|7288->3720|7362->3784|7402->3785|7597->3943|7609->3945|7639->3952|7698->3975|7753->4007|7796->4014|7885->4086|7925->4087|7986->4111|8012->4114|8067->4132|8095->4137|8156->4162|8197->4180|8236->4187|8316->4230|8340->4231|8394->4253|8432->4259|8778->4569|8822->4596|8862->4597|8904->4603|8974->4663|9014->4664|9209->4822|9221->4824|9251->4831|9310->4854|9365->4886|9408->4893|9493->4961|9533->4962|9594->4986|9620->4989|9675->5007|9703->5012|9764->5037|9805->5055|9844->5062|9924->5105|9948->5106|10002->5128|10040->5134|10395->5453|10439->5480|10479->5481|10521->5487|10593->5549|10633->5550|10828->5708|10840->5710|10870->5717|10929->5740|10984->5772|11027->5779|11114->5849|11154->5850|11215->5874|11241->5877|11296->5895|11324->5900|11385->5925|11426->5943|11465->5950|11545->5993|11569->5994|11623->6016|11661->6022
                    LINES: 26->1|41->13|41->13|42->11|43->13|44->15|44->15|44->15|44->15|72->43|72->43|72->43|73->44|73->44|75->46|79->50|79->50|79->50|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|83->54|83->54|84->55|86->57|98->69|98->69|98->69|99->70|99->70|101->72|105->76|105->76|105->76|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|109->80|109->80|110->81|112->83|129->100|129->100|129->100|130->101|130->101|130->101|135->106|135->106|135->106|137->108|137->108|138->109|138->109|138->109|140->111|140->111|141->112|141->112|143->114|143->114|144->115|147->118|147->118|149->120|150->121|166->137|166->137|166->137|167->138|167->138|167->138|172->143|172->143|172->143|174->145|174->145|175->146|175->146|175->146|177->148|177->148|178->149|178->149|180->151|180->151|181->152|184->155|184->155|186->157|187->158|204->175|204->175|204->175|205->176|205->176|205->176|210->181|210->181|210->181|212->183|212->183|213->184|213->184|213->184|215->186|215->186|216->187|216->187|218->189|218->189|219->190|222->193|222->193|224->195|225->196|241->212|241->212|241->212|242->213|242->213|242->213|247->218|247->218|247->218|249->220|249->220|250->221|250->221|250->221|252->223|252->223|253->224|253->224|255->226|255->226|256->227|259->230|259->230|261->232|262->233
                    -- GENERATED --
                */
            