
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
object listadoHonorariosReporte2 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(

escalasLaborales:List[models.haberes.EscalaLaboral],

countCostoTotalPorEscalaNoCm:java.util.TreeMap[String,java.util.Map[String,String]],
countCostoTotalPorEscalaCm:java.util.TreeMap[String,java.util.Map[String,String]],
countCostoTotalPorEscalaNoCmSinSac:java.util.TreeMap[String,java.util.Map[String,String]],
countCostoTotalPorEscalaCmSinSac:java.util.TreeMap[String,java.util.Map[String,String]],
totalFinalUnicoPeriodoPorEscalaNoCmTmp:List[com.avaje.ebean.SqlRow],
totalFinalUnicoPeriodoPorEscalaCmTmp:List[com.avaje.ebean.SqlRow],
totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac:List[com.avaje.ebean.SqlRow],
totalFinalUnicoPeriodoPorEscalaCmTmpSinSac:List[com.avaje.ebean.SqlRow]
):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*15.2*/implicitFieldConstructor/*15.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*13.2*/("""
"""),format.raw/*15.70*/(""" 
"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.dashboard.mainDashboard("Honorarios")/*16.50*/ {_display_(Seq[Any](format.raw/*16.52*/("""

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
		<h2>Costo TOTAL NETO por Escala Parque Salud</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*44.7*/for((key,value) <- countCostoTotalPorEscalaNoCm) yield /*44.55*/{_display_(Seq[Any](format.raw/*44.56*/("""
						<td>"""),_display_(Seq[Any](/*45.12*/key)),format.raw/*45.15*/("""</td>
						
					""")))})),format.raw/*47.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*51.6*/for(el <- escalasLaborales) yield /*51.33*/{_display_(Seq[Any](format.raw/*51.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*53.11*/el/*53.13*/.nombre)),format.raw/*53.20*/("""</td>
					"""),_display_(Seq[Any](/*54.7*/for((key,value) <- countCostoTotalPorEscalaNoCm) yield /*54.55*/{_display_(Seq[Any](format.raw/*54.56*/("""
						<td>"""),_display_(Seq[Any](/*55.12*/if(value.get(el.nombre) != null)/*55.44*/{_display_(Seq[Any](_display_(Seq[Any](/*55.46*/value/*55.51*/.get(el.nombre)))))})),format.raw/*55.67*/("""</td>
					""")))})),format.raw/*56.7*/("""
				</tr>
				""")))})),format.raw/*58.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo TOTAL NETO por Escala CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*70.7*/for((key,value) <- countCostoTotalPorEscalaCm) yield /*70.53*/{_display_(Seq[Any](format.raw/*70.54*/("""
						<td>"""),_display_(Seq[Any](/*71.12*/key)),format.raw/*71.15*/("""</td>
						
					""")))})),format.raw/*73.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*77.6*/for(el <- escalasLaborales) yield /*77.33*/{_display_(Seq[Any](format.raw/*77.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*79.11*/el/*79.13*/.nombre)),format.raw/*79.20*/("""</td>
					"""),_display_(Seq[Any](/*80.7*/for((key,value) <- countCostoTotalPorEscalaCm) yield /*80.53*/{_display_(Seq[Any](format.raw/*80.54*/("""
						<td>"""),_display_(Seq[Any](/*81.12*/if(value.get(el.nombre) != null)/*81.44*/{_display_(Seq[Any](_display_(Seq[Any](/*81.46*/value/*81.51*/.get(el.nombre)))))})),format.raw/*81.67*/("""</td>
					""")))})),format.raw/*82.7*/("""
				</tr>
				""")))})),format.raw/*84.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo TOTAL NETO por Escala Parque Salud SIN SAC</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*96.7*/for((key,value) <- countCostoTotalPorEscalaNoCmSinSac) yield /*96.61*/{_display_(Seq[Any](format.raw/*96.62*/("""
						<td>"""),_display_(Seq[Any](/*97.12*/key)),format.raw/*97.15*/("""</td>
						
					""")))})),format.raw/*99.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*103.6*/for(el <- escalasLaborales) yield /*103.33*/{_display_(Seq[Any](format.raw/*103.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*105.11*/el/*105.13*/.nombre)),format.raw/*105.20*/("""</td>
					"""),_display_(Seq[Any](/*106.7*/for((key,value) <- countCostoTotalPorEscalaNoCmSinSac) yield /*106.61*/{_display_(Seq[Any](format.raw/*106.62*/("""
						<td>"""),_display_(Seq[Any](/*107.12*/if(value.get(el.nombre) != null)/*107.44*/{_display_(Seq[Any](_display_(Seq[Any](/*107.46*/value/*107.51*/.get(el.nombre)))))})),format.raw/*107.67*/("""</td>
					""")))})),format.raw/*108.7*/("""
				</tr>
				""")))})),format.raw/*110.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo TOTAL NETO por Escala CM SIN SAC</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*122.7*/for((key,value) <- countCostoTotalPorEscalaCmSinSac) yield /*122.59*/{_display_(Seq[Any](format.raw/*122.60*/("""
						<td>"""),_display_(Seq[Any](/*123.12*/key)),format.raw/*123.15*/("""</td>
						
					""")))})),format.raw/*125.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*129.6*/for(el <- escalasLaborales) yield /*129.33*/{_display_(Seq[Any](format.raw/*129.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*131.11*/el/*131.13*/.nombre)),format.raw/*131.20*/("""</td>
					"""),_display_(Seq[Any](/*132.7*/for((key,value) <- countCostoTotalPorEscalaCmSinSac) yield /*132.59*/{_display_(Seq[Any](format.raw/*132.60*/("""
						<td>"""),_display_(Seq[Any](/*133.12*/if(value.get(el.nombre) != null)/*133.44*/{_display_(Seq[Any](_display_(Seq[Any](/*133.46*/value/*133.51*/.get(el.nombre)))))})),format.raw/*133.67*/("""</td>
					""")))})),format.raw/*134.7*/("""
				</tr>
				""")))})),format.raw/*136.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<hr><hr>
<div class="row">
	<div class="col-sm-12">
		<h2>TOTAL por Escala PS</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Escala</td>
					<td>HCA</td>
					<td>HSA</td>
					<td>Jubilacion</td>
					<td>OS</td>
					<td>SS</td>
					<td>SV</td>
					<td>IG</td>
					<td>OI</td>					
					<td>Total Ret.</td>
					<td>HP Jub.</td>
					<td>HP OS</td>
					<td>Neto</td>
					<td>Total Bruto</td>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*165.6*/for(el <- totalFinalUnicoPeriodoPorEscalaNoCmTmp) yield /*165.55*/{_display_(Seq[Any](format.raw/*165.56*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*167.11*/el/*167.13*/.getString("nombre"))),format.raw/*167.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*168.11*/el/*168.13*/.getBigDecimal("hca"))),format.raw/*168.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*169.11*/el/*169.13*/.getBigDecimal("hsa"))),format.raw/*169.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*170.11*/el/*170.13*/.getBigDecimal("jubilacion"))),format.raw/*170.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*171.11*/el/*171.13*/.getBigDecimal("os"))),format.raw/*171.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*172.11*/el/*172.13*/.getBigDecimal("ss"))),format.raw/*172.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*173.11*/el/*173.13*/.getBigDecimal("sv"))),format.raw/*173.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*174.11*/el/*174.13*/.getBigDecimal("ig"))),format.raw/*174.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*175.11*/el/*175.13*/.getBigDecimal("oi"))),format.raw/*175.33*/("""</td>
					<td></td>
					<td>"""),_display_(Seq[Any](/*177.11*/el/*177.13*/.getBigDecimal("hpjub"))),format.raw/*177.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*178.11*/el/*178.13*/.getBigDecimal("hpos"))),format.raw/*178.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*179.11*/el/*179.13*/.getBigDecimal("neto"))),format.raw/*179.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*180.11*/el/*180.13*/.getBigDecimal("bruto"))),format.raw/*180.36*/("""</td>
					
				</tr>
				""")))})),format.raw/*183.6*/("""
			</tbody>
		</table>		
	</div>
</div>	
<div class="row">
	<div class="col-sm-12">
		<h2>TOTAL por Escala CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Escala</td>
					<td>HCA</td>
					<td>HSA</td>
					<td>Jubilacion</td>
					<td>OS</td>
					<td>SS</td>
					<td>SV</td>
					<td>IG</td>
					<td>OI</td>	
					<td>Total Ret.</td>
					<td>HP Jub.</td>
					<td>HP OS</td>
					<td>Neto</td>
					<td>Total Bruto</td>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*211.6*/for(el <- totalFinalUnicoPeriodoPorEscalaCmTmp) yield /*211.53*/{_display_(Seq[Any](format.raw/*211.54*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*213.11*/el/*213.13*/.getString("nombre"))),format.raw/*213.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*214.11*/el/*214.13*/.getBigDecimal("hca"))),format.raw/*214.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*215.11*/el/*215.13*/.getBigDecimal("hsa"))),format.raw/*215.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*216.11*/el/*216.13*/.getBigDecimal("jubilacion"))),format.raw/*216.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*217.11*/el/*217.13*/.getBigDecimal("os"))),format.raw/*217.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*218.11*/el/*218.13*/.getBigDecimal("ss"))),format.raw/*218.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*219.11*/el/*219.13*/.getBigDecimal("sv"))),format.raw/*219.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*220.11*/el/*220.13*/.getBigDecimal("ig"))),format.raw/*220.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*221.11*/el/*221.13*/.getBigDecimal("oi"))),format.raw/*221.33*/("""</td>
					<td></td>
					<td>"""),_display_(Seq[Any](/*223.11*/el/*223.13*/.getBigDecimal("hpjub"))),format.raw/*223.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*224.11*/el/*224.13*/.getBigDecimal("hpos"))),format.raw/*224.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*225.11*/el/*225.13*/.getBigDecimal("neto"))),format.raw/*225.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*226.11*/el/*226.13*/.getBigDecimal("bruto"))),format.raw/*226.36*/("""</td>
					
				</tr>
				""")))})),format.raw/*229.6*/("""
			</tbody>
		</table>		
	</div>
</div>	
<hr><hr>
<div class="row">
	<div class="col-sm-12">
		<h2>TOTAL por Escala PS Sin Sac</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Escala</td>
					<td>HCA</td>
					<td>HSA</td>
					<td>Jubilacion</td>
					<td>OS</td>
					<td>SS</td>
					<td>SV</td>
					<td>IG</td>
					<td>OI</td>	
					<td>Total Ret.</td>
					<td>HP Jub.</td>
					<td>HP OS</td>
					<td>Neto</td>
					<td>Total Bruto</td>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*258.6*/for(el <- totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac) yield /*258.61*/{_display_(Seq[Any](format.raw/*258.62*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*260.11*/el/*260.13*/.getString("nombre"))),format.raw/*260.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*261.11*/el/*261.13*/.getBigDecimal("hca"))),format.raw/*261.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*262.11*/el/*262.13*/.getBigDecimal("hsa"))),format.raw/*262.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*263.11*/el/*263.13*/.getBigDecimal("jubilacion"))),format.raw/*263.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*264.11*/el/*264.13*/.getBigDecimal("os"))),format.raw/*264.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*265.11*/el/*265.13*/.getBigDecimal("ss"))),format.raw/*265.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*266.11*/el/*266.13*/.getBigDecimal("sv"))),format.raw/*266.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*267.11*/el/*267.13*/.getBigDecimal("ig"))),format.raw/*267.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*268.11*/el/*268.13*/.getBigDecimal("oi"))),format.raw/*268.33*/("""</td>
					<td></td>
					<td>"""),_display_(Seq[Any](/*270.11*/el/*270.13*/.getBigDecimal("hpjub"))),format.raw/*270.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*271.11*/el/*271.13*/.getBigDecimal("hpos"))),format.raw/*271.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*272.11*/el/*272.13*/.getBigDecimal("neto"))),format.raw/*272.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*273.11*/el/*273.13*/.getBigDecimal("bruto"))),format.raw/*273.36*/("""</td>
					
				</tr>
				""")))})),format.raw/*276.6*/("""
			</tbody>
		</table>		
	</div>
</div>	
<div class="row">
	<div class="col-sm-12">
		<h2>TOTAL por Escala CM Sin Sac</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Escala</td>
					<td>HCA</td>
					<td>HSA</td>
					<td>Jubilacion</td>
					<td>OS</td>
					<td>SS</td>
					<td>SV</td>
					<td>IG</td>
					<td>OI</td>	
					<td>Total Ret.</td>
					<td>HP Jub.</td>
					<td>HP OS</td>
					<td>Neto</td>
					<td>Total Bruto</td>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*304.6*/for(el <- totalFinalUnicoPeriodoPorEscalaCmTmpSinSac) yield /*304.59*/{_display_(Seq[Any](format.raw/*304.60*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*306.11*/el/*306.13*/.getString("nombre"))),format.raw/*306.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*307.11*/el/*307.13*/.getBigDecimal("hca"))),format.raw/*307.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*308.11*/el/*308.13*/.getBigDecimal("hsa"))),format.raw/*308.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*309.11*/el/*309.13*/.getBigDecimal("jubilacion"))),format.raw/*309.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*310.11*/el/*310.13*/.getBigDecimal("os"))),format.raw/*310.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*311.11*/el/*311.13*/.getBigDecimal("ss"))),format.raw/*311.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*312.11*/el/*312.13*/.getBigDecimal("sv"))),format.raw/*312.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*313.11*/el/*313.13*/.getBigDecimal("ig"))),format.raw/*313.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*314.11*/el/*314.13*/.getBigDecimal("oi"))),format.raw/*314.33*/("""</td>
					<td></td>
					<td>"""),_display_(Seq[Any](/*316.11*/el/*316.13*/.getBigDecimal("hpjub"))),format.raw/*316.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*317.11*/el/*317.13*/.getBigDecimal("hpos"))),format.raw/*317.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*318.11*/el/*318.13*/.getBigDecimal("neto"))),format.raw/*318.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*319.11*/el/*319.13*/.getBigDecimal("bruto"))),format.raw/*319.36*/("""</td>
					
				</tr>
				""")))})),format.raw/*322.6*/("""
			</tbody>
		</table>		
	</div>
</div>	


""")))})))}
    }
    
    def render(escalasLaborales:List[models.haberes.EscalaLaboral],countCostoTotalPorEscalaNoCm:java.util.TreeMap[String, java.util.Map[String, String]],countCostoTotalPorEscalaCm:java.util.TreeMap[String, java.util.Map[String, String]],countCostoTotalPorEscalaNoCmSinSac:java.util.TreeMap[String, java.util.Map[String, String]],countCostoTotalPorEscalaCmSinSac:java.util.TreeMap[String, java.util.Map[String, String]],totalFinalUnicoPeriodoPorEscalaNoCmTmp:List[com.avaje.ebean.SqlRow],totalFinalUnicoPeriodoPorEscalaCmTmp:List[com.avaje.ebean.SqlRow],totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac:List[com.avaje.ebean.SqlRow],totalFinalUnicoPeriodoPorEscalaCmTmpSinSac:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(escalasLaborales,countCostoTotalPorEscalaNoCm,countCostoTotalPorEscalaCm,countCostoTotalPorEscalaNoCmSinSac,countCostoTotalPorEscalaCmSinSac,totalFinalUnicoPeriodoPorEscalaNoCmTmp,totalFinalUnicoPeriodoPorEscalaCmTmp,totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac,totalFinalUnicoPeriodoPorEscalaCmTmpSinSac)
    
    def f:((List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (escalasLaborales,countCostoTotalPorEscalaNoCm,countCostoTotalPorEscalaCm,countCostoTotalPorEscalaNoCmSinSac,countCostoTotalPorEscalaCmSinSac,totalFinalUnicoPeriodoPorEscalaNoCmTmp,totalFinalUnicoPeriodoPorEscalaCmTmp,totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac,totalFinalUnicoPeriodoPorEscalaCmTmpSinSac) => apply(escalasLaborales,countCostoTotalPorEscalaNoCm,countCostoTotalPorEscalaCm,countCostoTotalPorEscalaNoCmSinSac,countCostoTotalPorEscalaCmSinSac,totalFinalUnicoPeriodoPorEscalaNoCmTmp,totalFinalUnicoPeriodoPorEscalaCmTmp,totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac,totalFinalUnicoPeriodoPorEscalaCmTmpSinSac)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorariosNew/listadoHonorariosReporte2.scala.html
                    HASH: 8ee0a88879506ade5038d11a4511dc1cc76ab92f
                    MATRIX: 1190->1|1982->709|2015->733|2089->690|2118->777|2156->780|2169->785|2221->828|2261->830|3018->1552|3082->1600|3121->1601|3169->1613|3194->1616|3244->1635|3318->1674|3361->1701|3400->1702|3456->1722|3467->1724|3496->1731|3543->1743|3607->1791|3646->1792|3694->1804|3735->1836|3783->1838|3797->1843|3839->1859|3882->1871|3929->1887|4185->2108|4247->2154|4286->2155|4334->2167|4359->2170|4409->2189|4483->2228|4526->2255|4565->2256|4621->2276|4632->2278|4661->2285|4708->2297|4770->2343|4809->2344|4857->2356|4898->2388|4946->2390|4960->2395|5002->2411|5045->2423|5092->2439|5366->2678|5436->2732|5475->2733|5523->2745|5548->2748|5598->2767|5673->2806|5717->2833|5757->2834|5814->2854|5826->2856|5856->2863|5904->2875|5975->2929|6015->2930|6064->2942|6106->2974|6155->2976|6170->2981|6213->2997|6257->3009|6305->3025|6570->3254|6639->3306|6679->3307|6728->3319|6754->3322|6805->3341|6880->3380|6924->3407|6964->3408|7021->3428|7033->3430|7063->3437|7111->3449|7180->3501|7220->3502|7269->3514|7311->3546|7360->3548|7375->3553|7418->3569|7462->3581|7510->3597|8051->4102|8117->4151|8157->4152|8214->4172|8226->4174|8269->4194|8322->4210|8334->4212|8378->4233|8431->4249|8443->4251|8487->4272|8540->4288|8552->4290|8603->4318|8656->4334|8668->4336|8711->4356|8764->4372|8776->4374|8819->4394|8872->4410|8884->4412|8927->4432|8980->4448|8992->4450|9035->4470|9088->4486|9100->4488|9143->4508|9211->4539|9223->4541|9269->4564|9322->4580|9334->4582|9379->4604|9432->4620|9444->4622|9489->4644|9542->4660|9554->4662|9600->4685|9659->4712|10188->5205|10252->5252|10292->5253|10349->5273|10361->5275|10404->5295|10457->5311|10469->5313|10513->5334|10566->5350|10578->5352|10622->5373|10675->5389|10687->5391|10738->5419|10791->5435|10803->5437|10846->5457|10899->5473|10911->5475|10954->5495|11007->5511|11019->5513|11062->5533|11115->5549|11127->5551|11170->5571|11223->5587|11235->5589|11278->5609|11346->5640|11358->5642|11404->5665|11457->5681|11469->5683|11514->5705|11567->5721|11579->5723|11624->5745|11677->5761|11689->5763|11735->5786|11794->5813|12340->6323|12412->6378|12452->6379|12509->6399|12521->6401|12564->6421|12617->6437|12629->6439|12673->6460|12726->6476|12738->6478|12782->6499|12835->6515|12847->6517|12898->6545|12951->6561|12963->6563|13006->6583|13059->6599|13071->6601|13114->6621|13167->6637|13179->6639|13222->6659|13275->6675|13287->6677|13330->6697|13383->6713|13395->6715|13438->6735|13506->6766|13518->6768|13564->6791|13617->6807|13629->6809|13674->6831|13727->6847|13739->6849|13784->6871|13837->6887|13849->6889|13895->6912|13954->6939|14491->7440|14561->7493|14601->7494|14658->7514|14670->7516|14713->7536|14766->7552|14778->7554|14822->7575|14875->7591|14887->7593|14931->7614|14984->7630|14996->7632|15047->7660|15100->7676|15112->7678|15155->7698|15208->7714|15220->7716|15263->7736|15316->7752|15328->7754|15371->7774|15424->7790|15436->7792|15479->7812|15532->7828|15544->7830|15587->7850|15655->7881|15667->7883|15713->7906|15766->7922|15778->7924|15823->7946|15876->7962|15888->7964|15933->7986|15986->8002|15998->8004|16044->8027|16103->8054
                    LINES: 26->1|41->15|41->15|42->13|43->15|44->16|44->16|44->16|44->16|72->44|72->44|72->44|73->45|73->45|75->47|79->51|79->51|79->51|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|84->56|86->58|98->70|98->70|98->70|99->71|99->71|101->73|105->77|105->77|105->77|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|109->81|109->81|110->82|112->84|124->96|124->96|124->96|125->97|125->97|127->99|131->103|131->103|131->103|133->105|133->105|133->105|134->106|134->106|134->106|135->107|135->107|135->107|135->107|135->107|136->108|138->110|150->122|150->122|150->122|151->123|151->123|153->125|157->129|157->129|157->129|159->131|159->131|159->131|160->132|160->132|160->132|161->133|161->133|161->133|161->133|161->133|162->134|164->136|193->165|193->165|193->165|195->167|195->167|195->167|196->168|196->168|196->168|197->169|197->169|197->169|198->170|198->170|198->170|199->171|199->171|199->171|200->172|200->172|200->172|201->173|201->173|201->173|202->174|202->174|202->174|203->175|203->175|203->175|205->177|205->177|205->177|206->178|206->178|206->178|207->179|207->179|207->179|208->180|208->180|208->180|211->183|239->211|239->211|239->211|241->213|241->213|241->213|242->214|242->214|242->214|243->215|243->215|243->215|244->216|244->216|244->216|245->217|245->217|245->217|246->218|246->218|246->218|247->219|247->219|247->219|248->220|248->220|248->220|249->221|249->221|249->221|251->223|251->223|251->223|252->224|252->224|252->224|253->225|253->225|253->225|254->226|254->226|254->226|257->229|286->258|286->258|286->258|288->260|288->260|288->260|289->261|289->261|289->261|290->262|290->262|290->262|291->263|291->263|291->263|292->264|292->264|292->264|293->265|293->265|293->265|294->266|294->266|294->266|295->267|295->267|295->267|296->268|296->268|296->268|298->270|298->270|298->270|299->271|299->271|299->271|300->272|300->272|300->272|301->273|301->273|301->273|304->276|332->304|332->304|332->304|334->306|334->306|334->306|335->307|335->307|335->307|336->308|336->308|336->308|337->309|337->309|337->309|338->310|338->310|338->310|339->311|339->311|339->311|340->312|340->312|340->312|341->313|341->313|341->313|342->314|342->314|342->314|344->316|344->316|344->316|345->317|345->317|345->317|346->318|346->318|346->318|347->319|347->319|347->319|350->322
                    -- GENERATED --
                */
            