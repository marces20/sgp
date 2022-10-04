
package views.html.presupuesto.balancePresupuestario

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
object indexBalancePresupuestarioPorEjercicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,List[BalancePresupuestario],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,lbp:List[BalancePresupuestario],idEjercicio:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*5.2*/getClassEstadoRP/*5.18*/(l:BalancePresupuestario) = {{
	var classEstado:String = new String()
	
	classEstado = "positivoPresupuesto"
	
	if(l.preventivo.subtract(l.definitivo).add(l.preventivo_rp.subtract(l.definitivo_rp)).compareTo(java.math.BigDecimal.ZERO) != 0 || 
	   l.definitivo.subtract(l.obligacion).add(l.definitivo_rp.subtract(l.obligacion_rp)).compareTo(java.math.BigDecimal.ZERO) != 0	||
	   l.obligacion.subtract(l.pago).add(l.obligacion_rp.subtract(l.pago_rp)).compareTo(java.math.BigDecimal.ZERO) != 0 
	){
		classEstado = "revisarPresupuesto"
	}
	
	if(l.preventivo.subtract(l.definitivo).add(l.preventivo_rp.subtract(l.definitivo_rp)).compareTo(java.math.BigDecimal.ZERO) < 0 || 
	   l.definitivo.subtract(l.obligacion).add(l.definitivo_rp.subtract(l.obligacion_rp)).compareTo(java.math.BigDecimal.ZERO) < 0	||
	   l.obligacion.subtract(l.pago).add(l.obligacion_rp.subtract(l.pago_rp)).compareTo(java.math.BigDecimal.ZERO) < 0 
	){
		classEstado = "negativoPresupuesto"
	}
	
	
	
	classEstado
	
}};def /*30.2*/getClassEstado/*30.16*/(l:BalancePresupuestario) = {{
	var classEstado:String = new String()
	
	classEstado = "positivoPresupuesto"
	
	if(l.preventivo.subtract(l.definitivo).compareTo(java.math.BigDecimal.ZERO) != 0 ||
	   l.definitivo.subtract(l.obligacion).compareTo(java.math.BigDecimal.ZERO) != 0 ||
	   l.obligacion.subtract(l.pago).compareTo(java.math.BigDecimal.ZERO) != 0	
	){
		classEstado = "revisarPresupuesto"
	}
	
	if(l.preventivo.subtract(l.definitivo).compareTo(java.math.BigDecimal.ZERO) < 0 ||
	   l.definitivo.subtract(l.obligacion).compareTo(java.math.BigDecimal.ZERO) < 0 ||
	   l.obligacion.subtract(l.pago).compareTo(java.math.BigDecimal.ZERO) < 0	
	){
		classEstado = "negativoPresupuesto"
	}
	
		
	classEstado
	
}};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*3.70*/(""" 

"""),format.raw/*28.2*/("""

"""),format.raw/*52.2*/("""

"""),_display_(Seq[Any](/*54.2*/views/*54.7*/.html.presupuesto.mainPresupuesto("Balance presupuestario")/*54.66*/ {_display_(Seq[Any](format.raw/*54.68*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Balance presupuestario Por ejercicio</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    
				    <li role="presentation"><a role="menuitem" id="accionReporteExportarDatosPresupuestoControl" 
				    tabindex="-1" 
				    href="#" data-url=""""),_display_(Seq[Any](/*72.29*/controllers/*72.40*/.presupuesto.routes.BalancePresupuestarioReportesController.modalReporteExportarDatosPresupuestoControl())),format.raw/*72.145*/("""">
				    Exportar Datos</a></li>
				    
				    
				    
				    <!-- ------------------------------------------------------------------------- -->
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*80.16*/controllers/*80.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(13))),format.raw/*80.135*/("""">
				    Reporte 2022 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*84.16*/controllers/*84.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(12))),format.raw/*84.135*/("""">
				    Reporte 2021 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*88.16*/controllers/*88.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(9))),format.raw/*88.134*/("""">
				    Reporte 2020 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*92.16*/controllers/*92.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(8))),format.raw/*92.134*/("""">
				    Reporte 2019 Saldos en Preventivos</a></li>
				     <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*96.16*/controllers/*96.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(7))),format.raw/*96.134*/("""">
				    Reporte 2018 Saldos en Preventivos</a></li>
				    <!-- <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*100.16*/controllers/*100.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(6))),format.raw/*100.134*/("""">
				    Reporte 2017 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*104.16*/controllers/*104.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(5))),format.raw/*104.134*/("""">
				    Reporte 2016 Saldos en Preventivos</a></li>
				     <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*108.16*/controllers/*108.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(4))),format.raw/*108.134*/("""">
				    Reporte 2015 Saldos en Preventivos</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" 
				    data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*112.16*/controllers/*112.27*/.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(3))),format.raw/*112.134*/("""">
				    Reporte 2014 Saldos en Preventivos</a></li> -->
				  </ul>
				</div>
				
			</div>
		</div>
	</div>
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row">		
				<div class="col-sm-2">
					<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*126.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select"))),format.raw/*127.38*/("""
					</label>
				</div>
				<div class="col-sm-8">
					<div class="col-sm-3"><h4 style="text-align:center; cursor: pointer; border:1px solid green; padding: 5px; color:green;" class="btnPositivoPresupuesto">CERRADOS</h4></div>
					<div class="col-sm-3"><h4 style="text-align:center; cursor: pointer; border:1px solid blue;padding: 5px;color:blue;" class="btnRevisarPresupuesto">ABIERTOS</h4></div>
					<div class="col-sm-3"><h4 style="text-align:center; cursor: pointer; border:1px solid red;padding: 5px;color:red;" class="btnNegativoPresupuesto">ERRORES</h4></div>
					<div class="col-sm-3"><h4 style="text-align:center; cursor: pointer; border:1px solid black;padding: 5px;" class="btnTodosPresupuesto">TODOS</h4></div>
				</div>
			</div>			
			<div class="row">		
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*147.16*/controllers/*147.27*/.presupuesto.routes.BalancePresupuestarioController.index())),format.raw/*147.86*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
 
		
		
		
	"""),_display_(Seq[Any](/*158.3*/if(lbp != null)/*158.18*/{_display_(Seq[Any](format.raw/*158.19*/("""
		<table class="table table-bordered tablaPresupuesto">
			<thead>
				<tr>
					<th width="30" >Expediente</th>
					
					<th width="30" colspan="2">Preventivo</th>
					<th width="30" colspan="2">Definitivo</th>
					<th width="30" colspan="2">Obligación</th>
					<th width="30" colspan="2">Pago</th>
				</tr>
				<tr>
					<th></th>
					<th>Total</th>
					<th>Disponible</th>
					<th>Total</th>
					<th>Disponible</th>
					<th>Total</th>
					<th>Disponible</th>
					<th colspan="2">Total</th>
				</tr>
			</thead>
			<tbody>	
		"""),_display_(Seq[Any](/*181.4*/for(l <- lbp) yield /*181.17*/ {_display_(Seq[Any](format.raw/*181.19*/("""
			"""),_display_(Seq[Any](/*182.5*/if(BalancePresupuestario.tieneRP(l.expediente.id))/*182.55*/{_display_(Seq[Any](format.raw/*182.56*/("""
				<tr class=""""),_display_(Seq[Any](/*183.17*/getClassEstadoRP(l))),format.raw/*183.36*/("""">
					<td>
						"""),_display_(Seq[Any](/*185.8*/l/*185.9*/.expediente.nombre)),format.raw/*185.27*/("""<br>
						"""),_display_(Seq[Any](/*186.8*/l/*186.9*/.expedienteRp)),format.raw/*186.22*/("""<br>
						TOTAL
					</td>
					<td>
						"""),_display_(Seq[Any](/*190.8*/(utils.NumberUtils.moneda(l.preventivo)))),format.raw/*190.48*/("""<br>
						"""),_display_(Seq[Any](/*191.8*/(utils.NumberUtils.moneda(l.preventivo_rp)))),format.raw/*191.51*/("""<br>
						"""),_display_(Seq[Any](/*192.8*/(utils.NumberUtils.moneda(l.preventivo.add(l.preventivo_rp))))),format.raw/*192.69*/("""
					</td>
					<td class="">
						"""),_display_(Seq[Any](/*195.8*/(utils.NumberUtils.moneda(l.preventivo.subtract(l.definitivo))))),format.raw/*195.71*/("""<br>
						"""),_display_(Seq[Any](/*196.8*/(utils.NumberUtils.moneda(l.preventivo_rp.subtract(l.definitivo_rp))))),format.raw/*196.77*/("""<br>
						"""),_display_(Seq[Any](/*197.8*/(utils.NumberUtils.moneda(l.preventivo.subtract(l.definitivo).add(l.preventivo_rp.subtract(l.definitivo_rp)))))),format.raw/*197.118*/("""
					</td>
					<td>
						"""),_display_(Seq[Any](/*200.8*/(utils.NumberUtils.moneda(l.definitivo)))),format.raw/*200.48*/("""<br>
						"""),_display_(Seq[Any](/*201.8*/(utils.NumberUtils.moneda(l.definitivo_rp)))),format.raw/*201.51*/("""<br>
						"""),_display_(Seq[Any](/*202.8*/(utils.NumberUtils.moneda(l.definitivo.add(l.definitivo_rp))))),format.raw/*202.69*/("""
					</td>
					<td class="">
						"""),_display_(Seq[Any](/*205.8*/(utils.NumberUtils.moneda(l.definitivo.subtract(l.obligacion))))),format.raw/*205.71*/("""<br>
						"""),_display_(Seq[Any](/*206.8*/(utils.NumberUtils.moneda(l.definitivo_rp.subtract(l.obligacion_rp))))),format.raw/*206.77*/("""<br>
						"""),_display_(Seq[Any](/*207.8*/(utils.NumberUtils.moneda(l.definitivo.subtract(l.obligacion).add(l.definitivo_rp.subtract(l.obligacion_rp)))))),format.raw/*207.118*/("""
					</td>
					
					<td>	
						"""),_display_(Seq[Any](/*211.8*/(utils.NumberUtils.moneda(l.obligacion)))),format.raw/*211.48*/("""<br>
						"""),_display_(Seq[Any](/*212.8*/(utils.NumberUtils.moneda(l.obligacion_rp)))),format.raw/*212.51*/("""<br>
						"""),_display_(Seq[Any](/*213.8*/(utils.NumberUtils.moneda(l.obligacion.add(l.obligacion_rp))))),format.raw/*213.69*/("""
					</td>
					<td class="">
						"""),_display_(Seq[Any](/*216.8*/(utils.NumberUtils.moneda(l.obligacion.subtract(l.pago))))),format.raw/*216.65*/("""<br>
						"""),_display_(Seq[Any](/*217.8*/(utils.NumberUtils.moneda(l.obligacion_rp.subtract(l.pago_rp))))),format.raw/*217.71*/("""<br>
						"""),_display_(Seq[Any](/*218.8*/(utils.NumberUtils.moneda(l.obligacion.subtract(l.pago).add(l.obligacion_rp.subtract(l.pago_rp)))))),format.raw/*218.106*/("""
					</td>
					<td colspan="2">
						"""),_display_(Seq[Any](/*221.8*/(utils.NumberUtils.moneda(l.pago)))),format.raw/*221.42*/("""<br>
						"""),_display_(Seq[Any](/*222.8*/(utils.NumberUtils.moneda(l.pago_rp)))),format.raw/*222.45*/("""<br>
						"""),_display_(Seq[Any](/*223.8*/(utils.NumberUtils.moneda(l.pago.add(l.pago_rp))))),format.raw/*223.57*/("""
					</td>
				</tr>	
				 	
			""")))}/*227.5*/else/*227.9*/{_display_(Seq[Any](format.raw/*227.10*/("""
			  	<tr class=""""),_display_(Seq[Any](/*228.19*/getClassEstado(l))),format.raw/*228.36*/("""">
					<td>"""),_display_(Seq[Any](/*229.11*/l/*229.12*/.expediente.nombre)),format.raw/*229.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*230.11*/(utils.NumberUtils.moneda(l.preventivo)))),format.raw/*230.51*/("""</td>
					<td class="">
						"""),_display_(Seq[Any](/*232.8*/(utils.NumberUtils.moneda(l.preventivo.subtract(l.definitivo))))),format.raw/*232.71*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*234.11*/(utils.NumberUtils.moneda(l.definitivo)))),format.raw/*234.51*/("""</td>
					<td class="">
						"""),_display_(Seq[Any](/*236.8*/(utils.NumberUtils.moneda(l.definitivo.subtract(l.obligacion))))),format.raw/*236.71*/("""
					</td>
					
					<td>"""),_display_(Seq[Any](/*239.11*/(utils.NumberUtils.moneda(l.obligacion)))),format.raw/*239.51*/("""</td>
					<td class="">
						"""),_display_(Seq[Any](/*241.8*/(utils.NumberUtils.moneda(l.obligacion.subtract(l.pago))))),format.raw/*241.65*/("""
					</td>
					<td colspan="2">"""),_display_(Seq[Any](/*243.23*/(utils.NumberUtils.moneda(l.pago)))),format.raw/*243.57*/("""</td>
				</tr>	
			""")))})),format.raw/*245.5*/("""
		""")))})),format.raw/*246.4*/("""
			</tbody>
       	</table>
	""")))})),format.raw/*249.3*/("""
""")))})),format.raw/*250.2*/("""
		
<script>
$(function()"""),format.raw/*253.13*/("""{"""),format.raw/*253.14*/("""
	$('#searchCuentaAnalitica').modalSearch();
	$('#searchExpediente').modalSearch();
	
	$('#accionReporteExportarDatosPresupuestoControl').click( function() """),format.raw/*257.71*/("""{"""),format.raw/*257.72*/("""  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog("""),format.raw/*260.31*/("""{"""),format.raw/*260.32*/("""title: "Reporte Presupuesto Control","""),format.raw/*260.69*/("""}"""),format.raw/*260.70*/(""");
	"""),format.raw/*261.2*/("""}"""),format.raw/*261.3*/(""");
	
	$('.btnPositivoPresupuesto').click( function() """),format.raw/*263.49*/("""{"""),format.raw/*263.50*/("""
		$('.positivoPresupuesto').show();
		$('.negativoPresupuesto').hide();
		$('.revisarPresupuesto').hide();
		
	"""),format.raw/*268.2*/("""}"""),format.raw/*268.3*/(""")
	
	$('.btnRevisarPresupuesto').click( function() """),format.raw/*270.48*/("""{"""),format.raw/*270.49*/("""
		$('.positivoPresupuesto').hide();
		$('.negativoPresupuesto').hide();
		$('.revisarPresupuesto').show();
	"""),format.raw/*274.2*/("""}"""),format.raw/*274.3*/(""")
	
	
	
	$('.btnNegativoPresupuesto').click( function() """),format.raw/*278.49*/("""{"""),format.raw/*278.50*/("""
		$('.positivoPresupuesto').hide();
		$('.negativoPresupuesto').show();
		$('.revisarPresupuesto').hide();
	"""),format.raw/*282.2*/("""}"""),format.raw/*282.3*/(""")
	
	$('.btnTodosPresupuesto').click( function() """),format.raw/*284.46*/("""{"""),format.raw/*284.47*/("""
		$('.positivoPresupuesto').show();
		$('.negativoPresupuesto').show();
		$('.revisarPresupuesto').show();
	"""),format.raw/*288.2*/("""}"""),format.raw/*288.3*/(""")
	
"""),format.raw/*290.1*/("""}"""),format.raw/*290.2*/(""");
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm,lbp:List[BalancePresupuestario],idEjercicio:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,lbp,idEjercicio)
    
    def f:((DynamicForm,List[BalancePresupuestario],String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,lbp,idEjercicio) => apply(formBuscador,lbp,idEjercicio)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/balancePresupuestario/indexBalancePresupuestarioPorEjercicio.scala.html
                    HASH: 4deeef82aa88f99dee9c8f27f83c766f71cbf1b2
                    MATRIX: 881->1|1061->98|1093->122|1150->170|1174->186|2175->1176|2198->1190|2942->79|2970->166|3000->1173|3029->1904|3067->1907|3080->1912|3148->1971|3188->1973|3892->2641|3912->2652|4040->2757|4373->3054|4393->3065|4524->3173|4759->3372|4779->3383|4910->3491|5145->3690|5165->3701|5295->3808|5530->4007|5550->4018|5680->4125|5916->4325|5936->4336|6066->4443|6307->4647|6328->4658|6459->4765|6695->4964|6716->4975|6847->5082|7084->5282|7105->5293|7236->5400|7472->5599|7493->5610|7624->5717|7928->5985|8088->6122|9287->7284|9308->7295|9390->7354|9544->7472|9569->7487|9609->7488|10189->8032|10219->8045|10260->8047|10301->8052|10361->8102|10401->8103|10455->8120|10497->8139|10553->8159|10563->8160|10604->8178|10652->8190|10662->8191|10698->8204|10779->8249|10842->8289|10890->8301|10956->8344|11004->8356|11088->8417|11162->8455|11248->8518|11296->8530|11388->8599|11436->8611|11570->8721|11635->8750|11698->8790|11746->8802|11812->8845|11860->8857|11944->8918|12018->8956|12104->9019|12152->9031|12244->9100|12292->9112|12426->9222|12498->9258|12561->9298|12609->9310|12675->9353|12723->9365|12807->9426|12881->9464|12961->9521|13009->9533|13095->9596|13143->9608|13265->9706|13342->9747|13399->9781|13447->9793|13507->9830|13555->9842|13627->9891|13680->9925|13693->9929|13733->9930|13789->9949|13829->9966|13879->9979|13890->9980|13931->9998|13984->10014|14047->10054|14115->10086|14201->10149|14260->10171|14323->10211|14391->10243|14477->10306|14542->10334|14605->10374|14673->10406|14753->10463|14824->10497|14881->10531|14934->10552|14970->10556|15034->10588|15068->10590|15122->10615|15152->10616|15337->10772|15367->10773|15518->10895|15548->10896|15614->10933|15644->10934|15676->10938|15705->10939|15787->10992|15817->10993|15957->11105|15986->11106|16066->11157|16096->11158|16233->11267|16262->11268|16347->11324|16377->11325|16514->11434|16543->11435|16621->11484|16651->11485|16788->11594|16817->11595|16849->11599|16878->11600
                    LINES: 26->1|29->3|29->3|29->5|29->5|52->30|52->30|75->1|76->3|78->28|80->52|82->54|82->54|82->54|82->54|100->72|100->72|100->72|108->80|108->80|108->80|112->84|112->84|112->84|116->88|116->88|116->88|120->92|120->92|120->92|124->96|124->96|124->96|128->100|128->100|128->100|132->104|132->104|132->104|136->108|136->108|136->108|140->112|140->112|140->112|154->126|155->127|175->147|175->147|175->147|186->158|186->158|186->158|209->181|209->181|209->181|210->182|210->182|210->182|211->183|211->183|213->185|213->185|213->185|214->186|214->186|214->186|218->190|218->190|219->191|219->191|220->192|220->192|223->195|223->195|224->196|224->196|225->197|225->197|228->200|228->200|229->201|229->201|230->202|230->202|233->205|233->205|234->206|234->206|235->207|235->207|239->211|239->211|240->212|240->212|241->213|241->213|244->216|244->216|245->217|245->217|246->218|246->218|249->221|249->221|250->222|250->222|251->223|251->223|255->227|255->227|255->227|256->228|256->228|257->229|257->229|257->229|258->230|258->230|260->232|260->232|262->234|262->234|264->236|264->236|267->239|267->239|269->241|269->241|271->243|271->243|273->245|274->246|277->249|278->250|281->253|281->253|285->257|285->257|288->260|288->260|288->260|288->260|289->261|289->261|291->263|291->263|296->268|296->268|298->270|298->270|302->274|302->274|306->278|306->278|310->282|310->282|312->284|312->284|316->288|316->288|318->290|318->290
                    -- GENERATED --
                */
            