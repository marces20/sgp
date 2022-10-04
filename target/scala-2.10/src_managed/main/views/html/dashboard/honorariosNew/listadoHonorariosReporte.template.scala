
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
object listadoHonorariosReporte extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template20[java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.Map[String, Integer],java.util.Map[String, Integer],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.List[String],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],List[models.haberes.LiquidacionConceptoClasificacion],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(countAgentes:java.util.TreeMap[String,java.util.Map[String,String]],
altaList:java.util.TreeMap[String,java.util.Map[String,String]],
bajaList:java.util.TreeMap[String,java.util.Map[String,String]],
escalasNoCmList:java.util.TreeMap[String,java.util.Map[String,String]],
escalasLaborales:List[models.haberes.EscalaLaboral],
escalasCmList:java.util.TreeMap[String,java.util.Map[String,String]],
escalasProfesionNoCm:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
escalasProfesionCm:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
countServicioNoCm:java.util.Map[String,Integer],
countServicioCm:java.util.Map[String,Integer],
countCostoTotal:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
countCostoSinSacTotal:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
tipoConceptos:java.util.List[String],
countTipoConceptoNoCmTotal:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
countTipoConceptoCmTotal:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
countTipoConceptoNoCmTotalSinSac:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
countTipoConceptoCmTotalSinSac:java.util.TreeMap[String,java.util.Map[String,java.math.BigDecimal]],
lcc:List[models.haberes.LiquidacionConceptoClasificacion],
countCostoTotalPorClasificacionConceptosNoCm:java.util.TreeMap[String,java.util.Map[String,String]],
countCostoTotalPorClasificacionConceptosCm:java.util.TreeMap[String,java.util.Map[String,String]]

):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var x=new java.math.BigDecimal(0);

implicit def /*24.2*/implicitFieldConstructor/*24.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*22.2*/("""
"""),format.raw/*24.70*/(""" 
"""),_display_(Seq[Any](/*26.2*/views/*26.7*/.html.dashboard.mainDashboard("Honorarios")/*26.50*/ {_display_(Seq[Any](format.raw/*26.52*/("""

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
<div class="row">
		<div class="col-sm-12">
			<h2>Cantidad agentes</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Agentes/Periodo</td>
						"""),_display_(Seq[Any](/*52.8*/for((key,value) <- countAgentes) yield /*52.40*/{_display_(Seq[Any](format.raw/*52.41*/("""
							<td>"""),_display_(Seq[Any](/*53.13*/key)),format.raw/*53.16*/("""</td>
						""")))})),format.raw/*54.8*/("""
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>PS</td>
						"""),_display_(Seq[Any](/*60.8*/for((key,value) <- countAgentes) yield /*60.40*/{_display_(Seq[Any](format.raw/*60.41*/("""
							<td>"""),_display_(Seq[Any](/*61.13*/if(value.get("nocm") != null)/*61.42*/{_display_(Seq[Any](_display_(Seq[Any](/*61.44*/value/*61.49*/.get("nocm")))))})),format.raw/*61.62*/("""</td>
						""")))})),format.raw/*62.8*/("""
						</tr>
					<tr>
						<td>CM</td>
						"""),_display_(Seq[Any](/*66.8*/for((key,value) <- countAgentes) yield /*66.40*/{_display_(Seq[Any](format.raw/*66.41*/("""
							<td>"""),_display_(Seq[Any](/*67.13*/if(value.get("cm") != null)/*67.40*/{_display_(Seq[Any](_display_(Seq[Any](/*67.42*/value/*67.47*/.get("cm")))))})),format.raw/*67.58*/("""</td>
						""")))})),format.raw/*68.8*/("""
					</tr>
				</tbody>
			</table>		
		</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad Altas agentes</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*81.7*/for((key,value) <- altaList) yield /*81.35*/{_display_(Seq[Any](format.raw/*81.36*/("""
						<td>"""),_display_(Seq[Any](/*82.12*/key)),format.raw/*82.15*/("""</td>
					""")))})),format.raw/*83.7*/("""
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>PS</td>
					"""),_display_(Seq[Any](/*89.7*/for((key,value) <- altaList) yield /*89.35*/{_display_(Seq[Any](format.raw/*89.36*/("""
						<td>"""),_display_(Seq[Any](/*90.12*/if(value.get("nocm") != null)/*90.41*/{_display_(Seq[Any](_display_(Seq[Any](/*90.43*/value/*90.48*/.get("nocm")))))})),format.raw/*90.61*/("""</td>
					""")))})),format.raw/*91.7*/("""
					</tr>
				<tr>
					<td>CM</td>
					"""),_display_(Seq[Any](/*95.7*/for((key,value) <- altaList) yield /*95.35*/{_display_(Seq[Any](format.raw/*95.36*/("""
						<td>"""),_display_(Seq[Any](/*96.12*/if(value.get("cm") != null)/*96.39*/{_display_(Seq[Any](_display_(Seq[Any](/*96.41*/value/*96.46*/.get("cm")))))})),format.raw/*96.57*/("""</td>
					""")))})),format.raw/*97.7*/("""
				</tr>
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad bajas agentes</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*110.7*/for((key,value) <- bajaList) yield /*110.35*/{_display_(Seq[Any](format.raw/*110.36*/("""
						<td>"""),_display_(Seq[Any](/*111.12*/key)),format.raw/*111.15*/("""</td>
					""")))})),format.raw/*112.7*/("""
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>PS</td>
					"""),_display_(Seq[Any](/*118.7*/for((key,value) <- bajaList) yield /*118.35*/{_display_(Seq[Any](format.raw/*118.36*/("""
						<td>"""),_display_(Seq[Any](/*119.12*/if(value.get("nocm") != null)/*119.41*/{_display_(Seq[Any](_display_(Seq[Any](/*119.43*/value/*119.48*/.get("nocm")))))})),format.raw/*119.61*/("""</td>
					""")))})),format.raw/*120.7*/("""
					</tr>
				<tr>
					<td>CM</td>
					"""),_display_(Seq[Any](/*124.7*/for((key,value) <- bajaList) yield /*124.35*/{_display_(Seq[Any](format.raw/*124.36*/("""
						<td>"""),_display_(Seq[Any](/*125.12*/if(value.get("cm") != null)/*125.39*/{_display_(Seq[Any](_display_(Seq[Any](/*125.41*/value/*125.46*/.get("cm")))))})),format.raw/*125.57*/("""</td>
					""")))})),format.raw/*126.7*/("""
				</tr>
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala Parque Salud</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*139.7*/for((key,value) <- escalasNoCmList) yield /*139.42*/{_display_(Seq[Any](format.raw/*139.43*/("""
						<td>"""),_display_(Seq[Any](/*140.12*/key)),format.raw/*140.15*/("""</td>
						
					""")))})),format.raw/*142.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*146.6*/for(el <- escalasLaborales) yield /*146.33*/{_display_(Seq[Any](format.raw/*146.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*148.11*/el/*148.13*/.nombre)),format.raw/*148.20*/("""</td>
					"""),_display_(Seq[Any](/*149.7*/for((key,value) <- escalasNoCmList) yield /*149.42*/{_display_(Seq[Any](format.raw/*149.43*/("""
						<td>"""),_display_(Seq[Any](/*150.12*/if(value.get(el.nombre) != null)/*150.44*/{_display_(Seq[Any](_display_(Seq[Any](/*150.46*/value/*150.51*/.get(el.nombre)))))})),format.raw/*150.67*/("""</td>
					""")))})),format.raw/*151.7*/("""
				</tr>
				""")))})),format.raw/*153.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*165.7*/for((key,value) <- escalasCmList) yield /*165.40*/{_display_(Seq[Any](format.raw/*165.41*/("""
						<td>"""),_display_(Seq[Any](/*166.12*/key)),format.raw/*166.15*/("""</td>
						
					""")))})),format.raw/*168.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*172.6*/for(el <- escalasLaborales) yield /*172.33*/{_display_(Seq[Any](format.raw/*172.34*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*174.11*/el/*174.13*/.nombre)),format.raw/*174.20*/("""</td>
					"""),_display_(Seq[Any](/*175.7*/for((key,value) <- escalasCmList) yield /*175.40*/{_display_(Seq[Any](format.raw/*175.41*/("""
						<td>"""),_display_(Seq[Any](/*176.12*/if(value.get(el.nombre) != null)/*176.44*/{_display_(Seq[Any](_display_(Seq[Any](/*176.46*/value/*176.51*/.get(el.nombre)))))})),format.raw/*176.67*/("""</td>
					""")))})),format.raw/*177.7*/("""
				</tr>
				""")))})),format.raw/*179.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion PS</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion Ps</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*195.5*/for(el <- escalasLaborales) yield /*195.32*/{_display_(Seq[Any](format.raw/*195.33*/("""
				
				"""),_display_(Seq[Any](/*197.6*/if(escalasProfesionNoCm.get(el.nombre) != null)/*197.53*/{_display_(Seq[Any](format.raw/*197.54*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*202.83*/el/*202.85*/.nombre)),format.raw/*202.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*204.7*/{x =new java.math.BigDecimal(0)})),format.raw/*204.39*/("""
					"""),_display_(Seq[Any](/*205.7*/for((key,value) <- escalasProfesionNoCm.get(el.nombre)) yield /*205.62*/{_display_(Seq[Any](format.raw/*205.63*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*207.13*/key)),format.raw/*207.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*208.13*/value)),format.raw/*208.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*210.8*/{x = x.add(value)})),format.raw/*210.26*/("""
					""")))})),format.raw/*211.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*214.12*/x)),format.raw/*214.13*/("""</td>
					</tr>
				""")))})),format.raw/*216.6*/(""" 
			""")))})),format.raw/*217.5*/("""
			
		</tbody>
		</table>	
	</div>	
</div>
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Escala por Profesion CM</h2>
		 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td colspan="2">Cantidad por Escala por Profesion CM</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*234.5*/for(el <- escalasLaborales) yield /*234.32*/{_display_(Seq[Any](format.raw/*234.33*/("""
				
				"""),_display_(Seq[Any](/*236.6*/if(escalasProfesionCm.get(el.nombre) != null)/*236.51*/{_display_(Seq[Any](format.raw/*236.52*/("""
					"""),_display_(Seq[Any](/*237.7*/{x =new java.math.BigDecimal(0)})),format.raw/*237.39*/("""
					<tr>
						<td align="center" colspan="2" ></td>
					</tr>
					<tr>
						<td align="center" colspan="2" style="font-size: 14px;font-weight: bold;" >"""),_display_(Seq[Any](/*242.83*/el/*242.85*/.nombre)),format.raw/*242.92*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*244.7*/for((key,value) <- escalasProfesionCm.get(el.nombre)) yield /*244.60*/{_display_(Seq[Any](format.raw/*244.61*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*246.13*/key)),format.raw/*246.16*/("""</td>
							<td>"""),_display_(Seq[Any](/*247.13*/value)),format.raw/*247.18*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*249.8*/{x = x.add(value)})),format.raw/*249.26*/("""
					""")))})),format.raw/*250.7*/("""
					<tr>
						<td>Total</td>
						<td>"""),_display_(Seq[Any](/*253.12*/x)),format.raw/*253.13*/("""</td>
					</tr>
				""")))})),format.raw/*255.6*/(""" 
			""")))})),format.raw/*256.5*/("""
		</tbody>
		</table>	
	</div>	
</div>

 
<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Profesion PS</h2> 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td>Servicio</td>
				<td>Cantidad</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*274.5*/for((key,value) <- countServicioNoCm) yield /*274.42*/{_display_(Seq[Any](format.raw/*274.43*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*276.11*/key)),format.raw/*276.14*/("""</td>
					<td>"""),_display_(Seq[Any](/*277.11*/value)),format.raw/*277.16*/("""</td>
				</tr>
			""")))})),format.raw/*279.5*/("""
		</tbody>
		</table>	
	</div>	
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Cantidad por Profesion CM</h2> 
		<table class="table table-bordered">
		<thead>
			<tr>
				<td>Servicio</td>
				<td>Cantidad</td>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*296.5*/for((key,value) <- countServicioCm) yield /*296.40*/{_display_(Seq[Any](format.raw/*296.41*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*298.11*/key)),format.raw/*298.14*/("""</td>
					<td>"""),_display_(Seq[Any](/*299.11*/value)),format.raw/*299.16*/("""</td>
				</tr>
			""")))})),format.raw/*301.5*/("""
		</tbody>
		</table>	
	</div>	
</div>
<hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo total periodo</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*314.7*/for((key,value) <- countCostoTotal) yield /*314.42*/{_display_(Seq[Any](format.raw/*314.43*/("""
						<td>"""),_display_(Seq[Any](/*315.12*/key)),format.raw/*315.15*/("""</td>
					""")))})),format.raw/*316.7*/("""
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>PS</td>
					"""),_display_(Seq[Any](/*322.7*/for((key,value) <- countCostoTotal) yield /*322.42*/{_display_(Seq[Any](format.raw/*322.43*/("""
						<td>"""),_display_(Seq[Any](/*323.12*/if(value.get("nocm") != null)/*323.41*/{_display_(Seq[Any](_display_(Seq[Any](/*323.43*/value/*323.48*/.get("nocm")))))})),format.raw/*323.61*/("""</td>
					""")))})),format.raw/*324.7*/("""
					</tr>
				<tr>
					<td>CM</td>
					"""),_display_(Seq[Any](/*328.7*/for((key,value) <- countCostoTotal) yield /*328.42*/{_display_(Seq[Any](format.raw/*328.43*/("""
						<td>"""),_display_(Seq[Any](/*329.12*/if(value.get("cm") != null)/*329.39*/{_display_(Seq[Any](_display_(Seq[Any](/*329.41*/value/*329.46*/.get("cm")))))})),format.raw/*329.57*/("""</td>
					""")))})),format.raw/*330.7*/("""
				</tr>
			</tbody>
		</table>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Costo total SIN SAC periodo</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*344.7*/for((key,value) <- countCostoSinSacTotal) yield /*344.48*/{_display_(Seq[Any](format.raw/*344.49*/("""
						<td>"""),_display_(Seq[Any](/*345.12*/key)),format.raw/*345.15*/("""</td>
					""")))})),format.raw/*346.7*/("""
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>PS</td>
					"""),_display_(Seq[Any](/*352.7*/for((key,value) <- countCostoSinSacTotal) yield /*352.48*/{_display_(Seq[Any](format.raw/*352.49*/("""
						<td>"""),_display_(Seq[Any](/*353.12*/if(value.get("nocm") != null)/*353.41*/{_display_(Seq[Any](_display_(Seq[Any](/*353.43*/value/*353.48*/.get("nocm")))))})),format.raw/*353.61*/("""</td>
					""")))})),format.raw/*354.7*/("""
					</tr>
				<tr>
					<td>CM</td>
					"""),_display_(Seq[Any](/*358.7*/for((key,value) <- countCostoSinSacTotal) yield /*358.48*/{_display_(Seq[Any](format.raw/*358.49*/("""
						<td>"""),_display_(Seq[Any](/*359.12*/if(value.get("cm") != null)/*359.39*/{_display_(Seq[Any](_display_(Seq[Any](/*359.41*/value/*359.46*/.get("cm")))))})),format.raw/*359.57*/("""</td>
					""")))})),format.raw/*360.7*/("""
				</tr>
			</tbody>
		</table>		
	</div>
</div>

<hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Tipo Concepto PS</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Tipo Concepto/Periodo</td>
					"""),_display_(Seq[Any](/*375.7*/for((key,value) <- countTipoConceptoNoCmTotal) yield /*375.53*/{_display_(Seq[Any](format.raw/*375.54*/("""
						<td>"""),_display_(Seq[Any](/*376.12*/key)),format.raw/*376.15*/("""</td>
					""")))})),format.raw/*377.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*381.6*/for(nombreTc <- tipoConceptos) yield /*381.36*/{_display_(Seq[Any](format.raw/*381.37*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*383.11*/nombreTc)),format.raw/*383.19*/("""</td>
					"""),_display_(Seq[Any](/*384.7*/for((key,value) <- countTipoConceptoNoCmTotal) yield /*384.53*/{_display_(Seq[Any](format.raw/*384.54*/("""
						<td>"""),_display_(Seq[Any](/*385.12*/if(value.get(nombreTc) != null)/*385.43*/{_display_(Seq[Any](_display_(Seq[Any](/*385.45*/value/*385.50*/.get(nombreTc)))))})),format.raw/*385.65*/("""</td>
					""")))})),format.raw/*386.7*/("""
				</tr>
				""")))})),format.raw/*388.6*/("""	
			</tbody>
		</table>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Tipo Concepto CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Tipo Concepto/Periodo</td>
					"""),_display_(Seq[Any](/*401.7*/for((key,value) <- countTipoConceptoCmTotal) yield /*401.51*/{_display_(Seq[Any](format.raw/*401.52*/("""
						<td>"""),_display_(Seq[Any](/*402.12*/key)),format.raw/*402.15*/("""</td>
					""")))})),format.raw/*403.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*407.6*/for(nombreTc <- tipoConceptos) yield /*407.36*/{_display_(Seq[Any](format.raw/*407.37*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*409.11*/nombreTc)),format.raw/*409.19*/("""</td>
					"""),_display_(Seq[Any](/*410.7*/for((key,value) <- countTipoConceptoCmTotal) yield /*410.51*/{_display_(Seq[Any](format.raw/*410.52*/("""
						<td>"""),_display_(Seq[Any](/*411.12*/if(value.get(nombreTc) != null)/*411.43*/{_display_(Seq[Any](_display_(Seq[Any](/*411.45*/value/*411.50*/.get(nombreTc)))))})),format.raw/*411.65*/("""</td>
					""")))})),format.raw/*412.7*/("""
				</tr>
				""")))})),format.raw/*414.6*/("""	
			</tbody>
		</table>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Tipo Concepto PS SIN SAC</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Tipo Concepto/Periodo</td>
					"""),_display_(Seq[Any](/*427.7*/for((key,value) <- countTipoConceptoNoCmTotalSinSac) yield /*427.59*/{_display_(Seq[Any](format.raw/*427.60*/("""
						<td>"""),_display_(Seq[Any](/*428.12*/key)),format.raw/*428.15*/("""</td>
					""")))})),format.raw/*429.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*433.6*/for(nombreTc <- tipoConceptos) yield /*433.36*/{_display_(Seq[Any](format.raw/*433.37*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*435.11*/nombreTc)),format.raw/*435.19*/("""</td>
					"""),_display_(Seq[Any](/*436.7*/for((key,value) <- countTipoConceptoNoCmTotalSinSac) yield /*436.59*/{_display_(Seq[Any](format.raw/*436.60*/("""
						<td>"""),_display_(Seq[Any](/*437.12*/if(value.get(nombreTc) != null)/*437.43*/{_display_(Seq[Any](_display_(Seq[Any](/*437.45*/value/*437.50*/.get(nombreTc)))))})),format.raw/*437.65*/("""</td>
					""")))})),format.raw/*438.7*/("""
				</tr>
				""")))})),format.raw/*440.6*/("""	
			</tbody>
		</table>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Tipo Concepto CM SIN SAC</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Tipo Concepto/Periodo</td>
					"""),_display_(Seq[Any](/*453.7*/for((key,value) <- countTipoConceptoCmTotalSinSac) yield /*453.57*/{_display_(Seq[Any](format.raw/*453.58*/("""
						<td>"""),_display_(Seq[Any](/*454.12*/key)),format.raw/*454.15*/("""</td>
					""")))})),format.raw/*455.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*459.6*/for(nombreTc <- tipoConceptos) yield /*459.36*/{_display_(Seq[Any](format.raw/*459.37*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*461.11*/nombreTc)),format.raw/*461.19*/("""</td>
					"""),_display_(Seq[Any](/*462.7*/for((key,value) <- countTipoConceptoCmTotalSinSac) yield /*462.57*/{_display_(Seq[Any](format.raw/*462.58*/("""
						<td>"""),_display_(Seq[Any](/*463.12*/if(value.get(nombreTc) != null)/*463.43*/{_display_(Seq[Any](_display_(Seq[Any](/*463.45*/value/*463.50*/.get(nombreTc)))))})),format.raw/*463.65*/("""</td>
					""")))})),format.raw/*464.7*/("""
				</tr>
				""")))})),format.raw/*466.6*/("""	
			</tbody>
		</table>		
	</div>
</div>
<hr>
<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Clasificacion de concepto Parque Salud</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*479.7*/for((key,value) <- countCostoTotalPorClasificacionConceptosNoCm) yield /*479.71*/{_display_(Seq[Any](format.raw/*479.72*/("""
						<td>"""),_display_(Seq[Any](/*480.12*/key)),format.raw/*480.15*/("""</td>
						
					""")))})),format.raw/*482.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*486.6*/for(el <- lcc) yield /*486.20*/{_display_(Seq[Any](format.raw/*486.21*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*488.11*/el/*488.13*/.nombre)),format.raw/*488.20*/("""</td>
					"""),_display_(Seq[Any](/*489.7*/for((key,value) <- countCostoTotalPorClasificacionConceptosNoCm) yield /*489.71*/{_display_(Seq[Any](format.raw/*489.72*/("""
						<td>"""),_display_(Seq[Any](/*490.12*/if(value.get(el.nombre) != null)/*490.44*/{_display_(Seq[Any](_display_(Seq[Any](/*490.46*/value/*490.51*/.get(el.nombre)))))})),format.raw/*490.67*/("""</td>
					""")))})),format.raw/*491.7*/("""
				</tr>
				""")))})),format.raw/*493.6*/("""
			</tbody>
		</table>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<h2>Costo por Clasificacion de concepto CM</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Agentes/Periodo</td>
					"""),_display_(Seq[Any](/*506.7*/for((key,value) <- countCostoTotalPorClasificacionConceptosCm) yield /*506.69*/{_display_(Seq[Any](format.raw/*506.70*/("""
						<td>"""),_display_(Seq[Any](/*507.12*/key)),format.raw/*507.15*/("""</td>
						
					""")))})),format.raw/*509.7*/("""
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*513.6*/for(el <- lcc) yield /*513.20*/{_display_(Seq[Any](format.raw/*513.21*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*515.11*/el/*515.13*/.nombre)),format.raw/*515.20*/("""</td>
					"""),_display_(Seq[Any](/*516.7*/for((key,value) <- countCostoTotalPorClasificacionConceptosCm) yield /*516.69*/{_display_(Seq[Any](format.raw/*516.70*/("""
						<td>"""),_display_(Seq[Any](/*517.12*/if(value.get(el.nombre) != null)/*517.44*/{_display_(Seq[Any](_display_(Seq[Any](/*517.46*/value/*517.51*/.get(el.nombre)))))})),format.raw/*517.67*/("""</td>
					""")))})),format.raw/*518.7*/("""
				</tr>
				""")))})),format.raw/*520.6*/("""
			</tbody>
		</table>		
	</div>
</div>
<hr>

""")))})))}
    }
    
    def render(countAgentes:java.util.TreeMap[String, java.util.Map[String, String]],altaList:java.util.TreeMap[String, java.util.Map[String, String]],bajaList:java.util.TreeMap[String, java.util.Map[String, String]],escalasNoCmList:java.util.TreeMap[String, java.util.Map[String, String]],escalasLaborales:List[models.haberes.EscalaLaboral],escalasCmList:java.util.TreeMap[String, java.util.Map[String, String]],escalasProfesionNoCm:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],escalasProfesionCm:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],countServicioNoCm:java.util.Map[String, Integer],countServicioCm:java.util.Map[String, Integer],countCostoTotal:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],countCostoSinSacTotal:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],tipoConceptos:java.util.List[String],countTipoConceptoNoCmTotal:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],countTipoConceptoCmTotal:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],countTipoConceptoNoCmTotalSinSac:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],countTipoConceptoCmTotalSinSac:java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],lcc:List[models.haberes.LiquidacionConceptoClasificacion],countCostoTotalPorClasificacionConceptosNoCm:java.util.TreeMap[String, java.util.Map[String, String]],countCostoTotalPorClasificacionConceptosCm:java.util.TreeMap[String, java.util.Map[String, String]]): play.api.templates.HtmlFormat.Appendable = apply(countAgentes,altaList,bajaList,escalasNoCmList,escalasLaborales,escalasCmList,escalasProfesionNoCm,escalasProfesionCm,countServicioNoCm,countServicioCm,countCostoTotal,countCostoSinSacTotal,tipoConceptos,countTipoConceptoNoCmTotal,countTipoConceptoCmTotal,countTipoConceptoNoCmTotalSinSac,countTipoConceptoCmTotalSinSac,lcc,countCostoTotalPorClasificacionConceptosNoCm,countCostoTotalPorClasificacionConceptosCm)
    
    def f:((java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]],List[models.haberes.EscalaLaboral],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.Map[String, Integer],java.util.Map[String, Integer],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.List[String],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],java.util.TreeMap[String, java.util.Map[String, java.math.BigDecimal]],List[models.haberes.LiquidacionConceptoClasificacion],java.util.TreeMap[String, java.util.Map[String, String]],java.util.TreeMap[String, java.util.Map[String, String]]) => play.api.templates.HtmlFormat.Appendable) = (countAgentes,altaList,bajaList,escalasNoCmList,escalasLaborales,escalasCmList,escalasProfesionNoCm,escalasProfesionCm,countServicioNoCm,countServicioCm,countCostoTotal,countCostoSinSacTotal,tipoConceptos,countTipoConceptoNoCmTotal,countTipoConceptoCmTotal,countTipoConceptoNoCmTotalSinSac,countTipoConceptoCmTotalSinSac,lcc,countCostoTotalPorClasificacionConceptosNoCm,countCostoTotalPorClasificacionConceptosCm) => apply(countAgentes,altaList,bajaList,escalasNoCmList,escalasLaborales,escalasCmList,escalasProfesionNoCm,escalasProfesionCm,countServicioNoCm,countServicioCm,countCostoTotal,countCostoSinSacTotal,tipoConceptos,countTipoConceptoNoCmTotal,countTipoConceptoCmTotal,countTipoConceptoNoCmTotalSinSac,countTipoConceptoCmTotalSinSac,lcc,countCostoTotalPorClasificacionConceptosNoCm,countCostoTotalPorClasificacionConceptosCm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorariosNew/listadoHonorariosReporte.scala.html
                    HASH: de10e345d14ee18a9d3d25477091d7fe82d815cf
                    MATRIX: 1952->1|3662->1563|3695->1587|3769->1544|3798->1631|3836->1698|3849->1703|3901->1746|3941->1748|4671->2443|4719->2475|4758->2476|4807->2489|4832->2492|4876->2505|4983->2577|5031->2609|5070->2610|5119->2623|5157->2652|5205->2654|5219->2659|5258->2672|5302->2685|5385->2733|5433->2765|5472->2766|5521->2779|5557->2806|5605->2808|5619->2813|5656->2824|5700->2837|5962->3064|6006->3092|6045->3093|6093->3105|6118->3108|6161->3120|6262->3186|6306->3214|6345->3215|6393->3227|6431->3256|6479->3258|6493->3263|6532->3276|6575->3288|6654->3332|6698->3360|6737->3361|6785->3373|6821->3400|6869->3402|6883->3407|6920->3418|6963->3430|7222->3653|7267->3681|7307->3682|7356->3694|7382->3697|7426->3709|7528->3775|7573->3803|7613->3804|7662->3816|7701->3845|7750->3847|7765->3852|7805->3865|7849->3877|7929->3921|7974->3949|8014->3950|8063->3962|8100->3989|8149->3991|8164->3996|8202->4007|8246->4019|8515->4252|8567->4287|8607->4288|8656->4300|8682->4303|8733->4322|8808->4361|8852->4388|8892->4389|8949->4409|8961->4411|8991->4418|9039->4430|9091->4465|9131->4466|9180->4478|9222->4510|9271->4512|9286->4517|9329->4533|9373->4545|9421->4561|9670->4774|9720->4807|9760->4808|9809->4820|9835->4823|9886->4842|9961->4881|10005->4908|10045->4909|10102->4929|10114->4931|10144->4938|10192->4950|10242->4983|10282->4984|10331->4996|10373->5028|10422->5030|10437->5035|10480->5051|10524->5063|10572->5079|10897->5368|10941->5395|10981->5396|11028->5407|11085->5454|11125->5455|11320->5613|11332->5615|11362->5622|11421->5645|11476->5677|11519->5684|11591->5739|11631->5740|11692->5764|11718->5767|11773->5785|11801->5790|11862->5815|11903->5833|11942->5840|12022->5883|12046->5884|12100->5906|12138->5912|12466->6204|12510->6231|12550->6232|12597->6243|12652->6288|12692->6289|12735->6296|12790->6328|12985->6486|12997->6488|13027->6495|13086->6518|13156->6571|13196->6572|13257->6596|13283->6599|13338->6617|13366->6622|13427->6647|13468->6665|13507->6672|13587->6715|13611->6716|13665->6738|13703->6744|13998->7003|14052->7040|14092->7041|14149->7061|14175->7064|14228->7080|14256->7085|14308->7105|14601->7362|14653->7397|14693->7398|14750->7418|14776->7421|14829->7437|14857->7442|14909->7462|15159->7676|15211->7711|15251->7712|15300->7724|15326->7727|15370->7739|15472->7805|15524->7840|15564->7841|15613->7853|15652->7882|15701->7884|15716->7889|15756->7902|15800->7914|15880->7958|15932->7993|15972->7994|16021->8006|16058->8033|16107->8035|16122->8040|16160->8051|16204->8063|16469->8292|16527->8333|16567->8334|16616->8346|16642->8349|16686->8361|16788->8427|16846->8468|16886->8469|16935->8481|16974->8510|17023->8512|17038->8517|17078->8530|17122->8542|17202->8586|17260->8627|17300->8628|17349->8640|17386->8667|17435->8669|17450->8674|17488->8685|17532->8697|17807->8936|17870->8982|17910->8983|17959->8995|17985->8998|18029->9010|18104->9049|18151->9079|18191->9080|18248->9100|18279->9108|18327->9120|18390->9166|18430->9167|18479->9179|18520->9210|18569->9212|18584->9217|18626->9232|18670->9244|18718->9260|18979->9485|19040->9529|19080->9530|19129->9542|19155->9545|19199->9557|19274->9596|19321->9626|19361->9627|19418->9647|19449->9655|19497->9667|19558->9711|19598->9712|19647->9724|19688->9755|19737->9757|19752->9762|19794->9777|19838->9789|19886->9805|20155->10038|20224->10090|20264->10091|20313->10103|20339->10106|20383->10118|20458->10157|20505->10187|20545->10188|20602->10208|20633->10216|20681->10228|20750->10280|20790->10281|20839->10293|20880->10324|20929->10326|20944->10331|20986->10346|21030->10358|21078->10374|21347->10607|21414->10657|21454->10658|21503->10670|21529->10673|21573->10685|21648->10724|21695->10754|21735->10755|21792->10775|21823->10783|21871->10795|21938->10845|21978->10846|22027->10858|22068->10889|22117->10891|22132->10896|22174->10911|22218->10923|22266->10939|22547->11184|22628->11248|22668->11249|22717->11261|22743->11264|22794->11283|22869->11322|22900->11336|22940->11337|22997->11357|23009->11359|23039->11366|23087->11378|23168->11442|23208->11443|23257->11455|23299->11487|23348->11489|23363->11494|23406->11510|23450->11522|23498->11538|23764->11768|23843->11830|23883->11831|23932->11843|23958->11846|24009->11865|24084->11904|24115->11918|24155->11919|24212->11939|24224->11941|24254->11948|24302->11960|24381->12022|24421->12023|24470->12035|24512->12067|24561->12069|24576->12074|24619->12090|24663->12102|24711->12118
                    LINES: 26->1|52->24|52->24|53->22|54->24|55->26|55->26|55->26|55->26|81->52|81->52|81->52|82->53|82->53|83->54|89->60|89->60|89->60|90->61|90->61|90->61|90->61|90->61|91->62|95->66|95->66|95->66|96->67|96->67|96->67|96->67|96->67|97->68|110->81|110->81|110->81|111->82|111->82|112->83|118->89|118->89|118->89|119->90|119->90|119->90|119->90|119->90|120->91|124->95|124->95|124->95|125->96|125->96|125->96|125->96|125->96|126->97|139->110|139->110|139->110|140->111|140->111|141->112|147->118|147->118|147->118|148->119|148->119|148->119|148->119|148->119|149->120|153->124|153->124|153->124|154->125|154->125|154->125|154->125|154->125|155->126|168->139|168->139|168->139|169->140|169->140|171->142|175->146|175->146|175->146|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|179->150|179->150|180->151|182->153|194->165|194->165|194->165|195->166|195->166|197->168|201->172|201->172|201->172|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|205->176|205->176|206->177|208->179|224->195|224->195|224->195|226->197|226->197|226->197|231->202|231->202|231->202|233->204|233->204|234->205|234->205|234->205|236->207|236->207|237->208|237->208|239->210|239->210|240->211|243->214|243->214|245->216|246->217|263->234|263->234|263->234|265->236|265->236|265->236|266->237|266->237|271->242|271->242|271->242|273->244|273->244|273->244|275->246|275->246|276->247|276->247|278->249|278->249|279->250|282->253|282->253|284->255|285->256|303->274|303->274|303->274|305->276|305->276|306->277|306->277|308->279|325->296|325->296|325->296|327->298|327->298|328->299|328->299|330->301|343->314|343->314|343->314|344->315|344->315|345->316|351->322|351->322|351->322|352->323|352->323|352->323|352->323|352->323|353->324|357->328|357->328|357->328|358->329|358->329|358->329|358->329|358->329|359->330|373->344|373->344|373->344|374->345|374->345|375->346|381->352|381->352|381->352|382->353|382->353|382->353|382->353|382->353|383->354|387->358|387->358|387->358|388->359|388->359|388->359|388->359|388->359|389->360|404->375|404->375|404->375|405->376|405->376|406->377|410->381|410->381|410->381|412->383|412->383|413->384|413->384|413->384|414->385|414->385|414->385|414->385|414->385|415->386|417->388|430->401|430->401|430->401|431->402|431->402|432->403|436->407|436->407|436->407|438->409|438->409|439->410|439->410|439->410|440->411|440->411|440->411|440->411|440->411|441->412|443->414|456->427|456->427|456->427|457->428|457->428|458->429|462->433|462->433|462->433|464->435|464->435|465->436|465->436|465->436|466->437|466->437|466->437|466->437|466->437|467->438|469->440|482->453|482->453|482->453|483->454|483->454|484->455|488->459|488->459|488->459|490->461|490->461|491->462|491->462|491->462|492->463|492->463|492->463|492->463|492->463|493->464|495->466|508->479|508->479|508->479|509->480|509->480|511->482|515->486|515->486|515->486|517->488|517->488|517->488|518->489|518->489|518->489|519->490|519->490|519->490|519->490|519->490|520->491|522->493|535->506|535->506|535->506|536->507|536->507|538->509|542->513|542->513|542->513|544->515|544->515|544->515|545->516|545->516|545->516|546->517|546->517|546->517|546->517|546->517|547->518|549->520
                    -- GENERATED --
                */
            