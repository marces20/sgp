
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
object deudasResumenInstitucion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[java.util.Map[String, java.util.Map[Long, java.util.Map[String, java.math.BigDecimal]]],List[String],List[String],java.util.Map[String, java.math.BigDecimal],java.util.Map[String, java.math.BigDecimal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:java.util.Map[String,java.util.Map[Long,java.util.Map[String,java.math.BigDecimal]]],
instiOp:List[String],instiProfe:List[String],
instiMontoTotalOperativa:java.util.Map[String,java.math.BigDecimal],
instiMontoTotalProfe:java.util.Map[String,java.math.BigDecimal],
formBuscador: DynamicForm
):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;

import java.lang.Integer;

import java.lang.String;


Seq[Any](format.raw/*6.2*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Deudas Detalles")/*10.55*/ {_display_(Seq[Any](format.raw/*10.57*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*12.66*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas por Institucion Resumen</h1>
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
				  <a id="" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*29.53*/controllers/*29.64*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasResumenPorInstitucionReporte())),format.raw/*29.156*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*39.4*/if(listaFinal.get("OPERATIVA") != null)/*39.43*/{_display_(Seq[Any](format.raw/*39.44*/("""
		<h3>OPERATIVA</h3>
		<table class="table table-striped table-bordered table-hover">
			 
			<thead>	
				<th>Periodo/Institucion</th>
				"""),_display_(Seq[Any](/*45.6*/for(s <- instiOp) yield /*45.23*/{_display_(Seq[Any](format.raw/*45.24*/("""
					<th>"""),_display_(Seq[Any](/*46.11*/s)),format.raw/*46.12*/("""</th>
				""")))})),format.raw/*47.6*/("""
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*50.6*/for((key,value) <- listaFinal.get("OPERATIVA")) yield /*50.53*/{_display_(Seq[Any](format.raw/*50.54*/("""
					<tr>
						<td>"""),_display_(Seq[Any](/*52.12*/Periodo/*52.19*/.find.byId(key).nombre)),format.raw/*52.41*/("""</td>
						"""),_display_(Seq[Any](/*53.8*/for(s <- instiOp) yield /*53.25*/{_display_(Seq[Any](format.raw/*53.26*/("""
							
							<td>
								"""),_display_(Seq[Any](/*56.10*/if(value.get(s) != null)/*56.34*/{_display_(Seq[Any](format.raw/*56.35*/("""
									"""),_display_(Seq[Any](/*57.11*/utils/*57.16*/.NumberUtils.moneda(value.get(s)))),format.raw/*57.49*/("""
								""")))}/*58.10*/else/*58.14*/{_display_(Seq[Any](format.raw/*58.15*/("""
									$0,00
								""")))})),format.raw/*60.10*/("""
							</td>
						""")))})),format.raw/*62.8*/("""
					</tr>
				""")))})),format.raw/*64.6*/("""
			</tbody>
			<tfoot>
			 	<tr>
					<td><b>Totales</b></td>
					"""),_display_(Seq[Any](/*69.7*/for(s <- instiOp) yield /*69.24*/{_display_(Seq[Any](format.raw/*69.25*/("""
						
						<td><b>
							"""),_display_(Seq[Any](/*72.9*/if(instiMontoTotalOperativa.get(s) != null)/*72.52*/{_display_(Seq[Any](format.raw/*72.53*/("""
								"""),_display_(Seq[Any](/*73.10*/utils/*73.15*/.NumberUtils.moneda(instiMontoTotalOperativa.get(s)))),format.raw/*73.67*/("""
							""")))}/*74.9*/else/*74.13*/{_display_(Seq[Any](format.raw/*74.14*/("""
								$0,00
							""")))})),format.raw/*76.9*/("""</b>
						</td>
					""")))})),format.raw/*78.7*/("""
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*82.4*/("""	
	</div>
</div>
<div class="row"  style="">
	<div class="col-sm-12" style="">
		"""),_display_(Seq[Any](/*87.4*/if(listaFinal.get("PROFE") != null)/*87.39*/{_display_(Seq[Any](format.raw/*87.40*/("""
	
		<h3>PROFE</h3>
		<table class="table table-striped table-bordered table-hover">
			
			<thead>	
				<th>Periodo/Institucion</th>
				"""),_display_(Seq[Any](/*94.6*/for(s <- instiProfe) yield /*94.26*/{_display_(Seq[Any](format.raw/*94.27*/("""
					<th>"""),_display_(Seq[Any](/*95.11*/s)),format.raw/*95.12*/("""</th>
				""")))})),format.raw/*96.6*/("""
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*99.6*/for((key,value) <- listaFinal.get("PROFE")) yield /*99.49*/{_display_(Seq[Any](format.raw/*99.50*/("""
					<tr>
						<td>"""),_display_(Seq[Any](/*101.12*/Periodo/*101.19*/.find.byId(key).nombre)),format.raw/*101.41*/("""</td>
						"""),_display_(Seq[Any](/*102.8*/for(s <- instiProfe) yield /*102.28*/{_display_(Seq[Any](format.raw/*102.29*/("""
							
							<td>
								"""),_display_(Seq[Any](/*105.10*/if(value.get(s) != null)/*105.34*/{_display_(Seq[Any](format.raw/*105.35*/("""
									"""),_display_(Seq[Any](/*106.11*/utils/*106.16*/.NumberUtils.moneda(value.get(s)))),format.raw/*106.49*/("""
								""")))}/*107.10*/else/*107.14*/{_display_(Seq[Any](format.raw/*107.15*/("""
									$0,00
								""")))})),format.raw/*109.10*/("""
							</td>
						""")))})),format.raw/*111.8*/("""
					</tr>
				""")))})),format.raw/*113.6*/("""
			</tbody>
			<tfoot>
			 	<tr>
					<td><b>Totales</b></td>
					"""),_display_(Seq[Any](/*118.7*/for(s <- instiProfe) yield /*118.27*/{_display_(Seq[Any](format.raw/*118.28*/("""
						
						<td><b>
							"""),_display_(Seq[Any](/*121.9*/if(instiMontoTotalProfe.get(s) != null)/*121.48*/{_display_(Seq[Any](format.raw/*121.49*/("""
								"""),_display_(Seq[Any](/*122.10*/utils/*122.15*/.NumberUtils.moneda(instiMontoTotalProfe.get(s)))),format.raw/*122.63*/("""
							""")))}/*123.9*/else/*123.13*/{_display_(Seq[Any](format.raw/*123.14*/("""
								$0,00
							""")))})),format.raw/*125.9*/("""</b>
						</td>
					""")))})),format.raw/*127.7*/("""
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*131.4*/("""	
	</div>
</div>
""")))})))}
    }
    
    def render(listaFinal:java.util.Map[String, java.util.Map[Long, java.util.Map[String, java.math.BigDecimal]]],instiOp:List[String],instiProfe:List[String],instiMontoTotalOperativa:java.util.Map[String, java.math.BigDecimal],instiMontoTotalProfe:java.util.Map[String, java.math.BigDecimal],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,instiOp,instiProfe,instiMontoTotalOperativa,instiMontoTotalProfe,formBuscador)
    
    def f:((java.util.Map[String, java.util.Map[Long, java.util.Map[String, java.math.BigDecimal]]],List[String],List[String],java.util.Map[String, java.math.BigDecimal],java.util.Map[String, java.math.BigDecimal],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,instiOp,instiProfe,instiMontoTotalOperativa,instiMontoTotalProfe,formBuscador) => apply(listaFinal,instiOp,instiProfe,instiMontoTotalOperativa,instiMontoTotalProfe,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasResumenInstitucion.scala.html
                    HASH: 5ee7798c0a54c35a1455c96f381a0d98daf60465
                    MATRIX: 1030->1|1510->306|1547->391|1560->396|1617->444|1657->446|1695->449|1708->454|1789->513|2398->1086|2418->1097|2533->1189|2711->1332|2759->1371|2798->1372|2975->1514|3008->1531|3047->1532|3094->1543|3117->1544|3159->1555|3223->1584|3286->1631|3325->1632|3383->1654|3399->1661|3443->1683|3491->1696|3524->1713|3563->1714|3629->1744|3662->1768|3701->1769|3748->1780|3762->1785|3817->1818|3846->1828|3859->1832|3898->1833|3955->1858|4007->1879|4055->1896|4159->1965|4192->1982|4231->1983|4296->2013|4348->2056|4387->2057|4433->2067|4447->2072|4521->2124|4548->2133|4561->2137|4600->2138|4654->2161|4708->2184|4776->2221|4893->2303|4937->2338|4976->2339|5150->2478|5186->2498|5225->2499|5272->2510|5295->2511|5337->2522|5401->2551|5460->2594|5499->2595|5558->2617|5575->2624|5620->2646|5669->2659|5706->2679|5746->2680|5813->2710|5847->2734|5887->2735|5935->2746|5950->2751|6006->2784|6036->2794|6050->2798|6090->2799|6148->2824|6201->2845|6250->2862|6355->2931|6392->2951|6432->2952|6498->2982|6547->3021|6587->3022|6634->3032|6649->3037|6720->3085|6748->3094|6762->3098|6802->3099|6857->3122|6912->3145|6981->3182
                    LINES: 26->1|39->6|40->10|40->10|40->10|40->10|42->12|42->12|42->12|59->29|59->29|59->29|69->39|69->39|69->39|75->45|75->45|75->45|76->46|76->46|77->47|80->50|80->50|80->50|82->52|82->52|82->52|83->53|83->53|83->53|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|90->60|92->62|94->64|99->69|99->69|99->69|102->72|102->72|102->72|103->73|103->73|103->73|104->74|104->74|104->74|106->76|108->78|112->82|117->87|117->87|117->87|124->94|124->94|124->94|125->95|125->95|126->96|129->99|129->99|129->99|131->101|131->101|131->101|132->102|132->102|132->102|135->105|135->105|135->105|136->106|136->106|136->106|137->107|137->107|137->107|139->109|141->111|143->113|148->118|148->118|148->118|151->121|151->121|151->121|152->122|152->122|152->122|153->123|153->123|153->123|155->125|157->127|161->131
                    -- GENERATED --
                */
            