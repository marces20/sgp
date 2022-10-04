
package views.html.haberes.liquidacionMeses

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
object verLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[models.haberes.LiquidacionMes],models.haberes.LiquidacionMes,List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.LiquidacionMes],lc:models.haberes.LiquidacionMes, dataPorConcepto:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/haberes/liquidacionMes.js"))),format.raw/*6.73*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.126*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.haberes.mainHaberes("Vista Liquidación",scripts)/*10.61*/ {_display_(Seq[Any](format.raw/*10.63*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Liquidación</h1>
			</div>
			<div class="col-sm-5">
			
			 	<div class="dropdown pull-right">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
					<i class="glyphicon glyphicon-list-alt"></i>
					   Reportes
					<span class="caret"></span>
					</button>
				  	<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  		"""),_display_(Seq[Any](/*25.10*/if(Permiso.check("lmReporteOrdenDePago"))/*25.51*/ {_display_(Seq[Any](format.raw/*25.53*/("""
				  			<li role="presentation"><a id="ordenDePago" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*26.91*/controllers/*26.102*/.haberes.routes.LiquidacionMesesReportesController.ordenDePago(lc.id))),format.raw/*26.171*/("""">Orden de Pago</a></li>
				  		""")))})),format.raw/*27.10*/("""
				  		"""),_display_(Seq[Any](/*28.10*/if(Permiso.check("lmReporteDatosGenerales"))/*28.54*/ {_display_(Seq[Any](format.raw/*28.56*/("""
				  		<li role="presentation"><a id="datosGenerales" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*29.93*/controllers/*29.104*/.haberes.routes.LiquidacionMesesReportesController.datosGenerales(lc.id))),format.raw/*29.176*/("""">Datos Generales</a></li>
				  		""")))})),format.raw/*30.10*/("""
				  		"""),_display_(Seq[Any](/*31.10*/if(Permiso.check("lmReporteListadoDePuestoLaboral"))/*31.62*/ {_display_(Seq[Any](format.raw/*31.64*/("""
				  		<li role="presentation"><a id="listadoDePuestoLaboral" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*32.101*/controllers/*32.112*/.haberes.routes.LiquidacionMesesReportesController.listadoDePuestoLaboral(lc.id))),format.raw/*32.192*/("""">Listado Puestos</a></li>
				  		""")))})),format.raw/*33.10*/("""
				  		"""),_display_(Seq[Any](/*34.10*/if(Permiso.check("lmReporteListadoDePuestoLaboralAgrupamiento"))/*34.74*/ {_display_(Seq[Any](format.raw/*34.76*/("""
				  		<li role="presentation"><a id="listadoDePuestoLaboralAgrupamiento" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*35.113*/controllers/*35.124*/.haberes.routes.LiquidacionMesesReportesController.listadoPorEscalaPorPuestoLaboral(lc.id))),format.raw/*35.214*/("""">Listado Agrupamiento</a></li>
				  		""")))})),format.raw/*36.10*/("""
				  		"""),_display_(Seq[Any](/*37.10*/if(Permiso.check("lmReporteControlDescuentosBasicos"))/*37.64*/ {_display_(Seq[Any](format.raw/*37.66*/("""
				  		<li role="presentation"><a id="controlDescuentosBasicos" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*38.103*/controllers/*38.114*/.haberes.routes.LiquidacionMesesReportesController.controlDescuentosBasicos(lc.id))),format.raw/*38.196*/("""">Control Descuentos Basicos</a></li>
				  		""")))})),format.raw/*39.10*/("""
				  		"""),_display_(Seq[Any](/*40.10*/if(Permiso.check("lmReporteListadoPorConceptosPorPuestoLaboral"))/*40.75*/ {_display_(Seq[Any](format.raw/*40.77*/("""
				  		<li role="presentation"><a id="listadoPorConceptosPorPuestoLaboral" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*41.114*/controllers/*41.125*/.haberes.routes.LiquidacionMesesReportesController.listadoPorConceptosPorPuestoLaboral(lc.id))),format.raw/*41.218*/("""">Listado por Conceptos por agente</a></li>
				  		""")))})),format.raw/*42.10*/("""
				  		"""),_display_(Seq[Any](/*43.10*/if(Permiso.check("lmReporteListadoSeguroVida"))/*43.57*/ {_display_(Seq[Any](format.raw/*43.59*/("""
				  		<li role="presentation"><a id="listadoSeguroVida" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*44.96*/controllers/*44.107*/.haberes.routes.LiquidacionMesesReportesController.listadoSeguroVida(lc.id))),format.raw/*44.182*/("""">Listado Seguro de Vida</a></li>
				  		""")))})),format.raw/*45.10*/("""
				  		"""),_display_(Seq[Any](/*46.10*/if(Permiso.check("lmReporteListadoSeguroSepelio"))/*46.60*/ {_display_(Seq[Any](format.raw/*46.62*/("""
				  		<li role="presentation"><a id="listadoSeguroSepelio" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*47.99*/controllers/*47.110*/.haberes.routes.LiquidacionMesesReportesController.listadoSeguroSepelio(lc.id))),format.raw/*47.188*/("""">Listado Seguro de Sepelio</a></li>
				  		""")))})),format.raw/*48.10*/("""
				  		"""),_display_(Seq[Any](/*49.10*/if(Permiso.check("lmReporteListadoJubilacion"))/*49.57*/ {_display_(Seq[Any](format.raw/*49.59*/("""
				  		<li role="presentation"><a id="listadoJubilacion" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*50.96*/controllers/*50.107*/.haberes.routes.LiquidacionMesesReportesController.listadoJubilacion(lc.id))),format.raw/*50.182*/("""">Listado Jubilacion</a></li>
				  		""")))})),format.raw/*51.10*/("""
				  		"""),_display_(Seq[Any](/*52.10*/if(Permiso.check("lmReporteListadoObraSocial"))/*52.57*/ {_display_(Seq[Any](format.raw/*52.59*/("""
				  		<li role="presentation"><a id="listadoObraSocial" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*53.96*/controllers/*53.107*/.haberes.routes.LiquidacionMesesReportesController.listadoObraSocial(lc.id))),format.raw/*53.182*/("""">Listado Obra Social</a></li>
				  		""")))})),format.raw/*54.10*/("""
				  		"""),_display_(Seq[Any](/*55.10*/if(Permiso.check("lmReporteListadoGeneral"))/*55.54*/ {_display_(Seq[Any](format.raw/*55.56*/("""
				  		<li role="presentation"><a id="listadoGeneral" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*56.93*/controllers/*56.104*/.haberes.routes.LiquidacionMesesReportesController.listadoGeneral(lc.id))),format.raw/*56.176*/("""">Listado Completo</a></li>
				  		""")))})),format.raw/*57.10*/("""
				  		"""),_display_(Seq[Any](/*58.10*/if(Permiso.check("lmReporteTotalPorConcepto"))/*58.56*/ {_display_(Seq[Any](format.raw/*58.58*/("""
				  		<li role="presentation"><a id="totalPorConcepto" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*59.95*/controllers/*59.106*/.haberes.routes.LiquidacionMesesReportesController.totalPorConceptos(lc.id))),format.raw/*59.181*/("""">Total por conceptos</a></li>
				  		""")))})),format.raw/*60.10*/("""
				  		"""),_display_(Seq[Any](/*61.10*/if(Permiso.check("lmReporteComparativoCertificacion"))/*61.64*/ {_display_(Seq[Any](format.raw/*61.66*/("""
				  		<li role="presentation"><a id="comparativoCertificacion" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*62.103*/controllers/*62.114*/.haberes.routes.LiquidacionMesesReportesController.comparativoCertificacion(lc.id))),format.raw/*62.196*/("""">Comparativo con certificación</a></li>
				  		""")))})),format.raw/*63.10*/("""
				  		"""),_display_(Seq[Any](/*64.10*/if(Permiso.check("lmReporteComparativoPeriodoAnterior"))/*64.66*/ {_display_(Seq[Any](format.raw/*64.68*/("""
				  		<li role="presentation"><a id="comparativoPeriodoAnterior" role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*65.105*/controllers/*65.116*/.haberes.routes.LiquidacionMesesReportesController.listadoDePuestoLaboralComparativoPeriodo(lc.id))),format.raw/*65.214*/("""">Comparativo Periodo anterior</a></li>
						""")))})),format.raw/*66.8*/("""					
					</ul>	  
				</div> 
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*70.16*/controllers/*70.27*/.haberes.routes.LiquidacionMesesController.crear())),format.raw/*70.77*/(""""  class="pull-right btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Liquidación</a>
				</div>
					
			</div>
		</div>
	</div>		

"""),_display_(Seq[Any](/*77.2*/views/*77.7*/.html.tags.successError())),format.raw/*77.32*/("""
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*81.14*/controllers/*81.25*/.haberes.routes.LiquidacionMesesController.editar(lc.id))),_display_(Seq[Any](/*81.82*/UriTrack/*81.90*/.get("&"))),format.raw/*81.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*82.14*/controllers/*82.25*/.haberes.routes.LiquidacionMesesController.eliminar(lc.id))),_display_(Seq[Any](/*82.84*/UriTrack/*82.92*/.get("&"))),format.raw/*82.101*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*85.14*/UriTrack/*85.22*/.getOnNull(controllers.haberes.routes.LiquidacionMesesController.index().absoluteURL()))),format.raw/*85.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="liquidacionMesId" name="liquidacionMesId" value=""""),_display_(Seq[Any](/*89.77*/lc/*89.79*/.id)),format.raw/*89.82*/(""""/>
	<div class="row">
		<div class="col-sm-2">
			<b>Convenio Ministerio</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*97.9*/inputRadioGroup(lcForm("convenio_ministerio"), options = Seq("true"->"SI"), 'disabled -> "disabled"))),format.raw/*97.109*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*104.9*/inputRadioGroup(lcForm("convenio_ministerio"),options = Seq("false"->"NO"), 'disabled -> "disabled"))),format.raw/*104.109*/("""
						</label>
					</div>
				</div>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">N° Liquidación</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*113.50*/lcForm/*113.56*/.field("nro_liquidacion_parque").value)),format.raw/*113.94*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Titulo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*119.50*/lcForm/*119.56*/.field("titulo").value)),format.raw/*119.78*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for=""""),_display_(Seq[Any](/*124.18*/lcForm("liquidacionTipo"))),format.raw/*124.43*/("""" class="control-label">Liquidacion Tipo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*125.50*/lcForm/*125.56*/.field("liquidacionTipo.nombre").value)),format.raw/*125.94*/("""</p>
			</div>
		</div> 
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="fechaLiquidacion" class="control-label">Fecha Liquidacion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*133.50*/lcForm/*133.56*/.field("fecha_liquidacion").value)),format.raw/*133.89*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="periodo" class="control-label">Periodo</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*139.50*/lcForm/*139.56*/.field("periodo.nombre").value)),format.raw/*139.86*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="expediente" class="control-label">Expediente</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*145.50*/lcForm/*145.56*/.field("expediente.expedienteEjercicio").value)),format.raw/*145.102*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="ordenPago" class="control-label">Orden de pago N°</label> 
				<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*152.6*/if(lc.ordenPago != null)/*152.30*/{_display_(Seq[Any](format.raw/*152.31*/(""" 
					"""),_display_(Seq[Any](/*153.7*/lcForm/*153.13*/.field("ordenPago.ordenEjercicio").value)),format.raw/*153.53*/("""
				""")))})),format.raw/*154.6*/("""
				</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="fecha_orden_pago" class="control-label">Fecha orden de pago</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*161.50*/lcForm/*161.56*/.field("fecha_orden_pago").value)),format.raw/*161.88*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="fecha_pago" class="control-label">Fecha de pago</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*167.50*/lcForm/*167.56*/.field("fecha_pago").value)),format.raw/*167.82*/("""</p> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="expediente" class="control-label">Expediente Aporte</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*175.50*/lcForm/*175.56*/.field("expedienteAporte.expedienteEjercicio").value)),format.raw/*175.108*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="expediente" class="control-label">Exp. Seguro Vida</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*181.50*/lcForm/*181.56*/.field("expedienteSeguroVida.expedienteEjercicio").value)),format.raw/*181.112*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="expediente" class="control-label">Exp. Seguro Sepelio</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*187.50*/lcForm/*187.56*/.field("expedienteSeguroSepelio.expedienteEjercicio").value)),format.raw/*187.115*/("""</p> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="expediente" class="control-label">Exp. Contribuciones</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*193.50*/lcForm/*193.56*/.field("expedienteContribuciones.expedienteEjercicio").value)),format.raw/*193.116*/("""</p> 
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for=""""),_display_(Seq[Any](/*198.18*/lcForm("comentario"))),format.raw/*198.38*/("""" class="control-label">Comentario</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*199.50*/lcForm/*199.56*/.field("comentario").value)),format.raw/*199.82*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		
	</div>
	<hr>
	<div class="row">
		<div class="col-sm-5">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Totales</b></div>
				<div class="panel-body">
			
					<div class="row margin-bottom-25">
						<div class="col-sm-12">
							<h4>Total Personas: <b>"""),_display_(Seq[Any](/*215.32*/lc/*215.34*/.cantidad_liquidaciones_puestos)),format.raw/*215.65*/("""</b></h4>
							<h4>Total C/A: 	<b>"""),_display_(Seq[Any](/*216.28*/if(lc.getTotalCA() != null)/*216.55*/{_display_(Seq[Any](_display_(Seq[Any](/*216.57*/utils/*216.62*/.NumberUtils.moneda(lc.getTotalCA())))))})),format.raw/*216.99*/("""</b></h4>
							<h4>Total S/A: 	<b>"""),_display_(Seq[Any](/*217.28*/if(lc.getTotalSA() != null)/*217.55*/{_display_(Seq[Any](_display_(Seq[Any](/*217.57*/utils/*217.62*/.NumberUtils.moneda(lc.getTotalSA())))))})),format.raw/*217.99*/("""</b></h4>
							<hr>
							<h4>Retenciones</h4>
							<h4>Total OS.:<b>"""),_display_(Seq[Any](/*220.26*/if(lc.getTotalOs() != null)/*220.53*/{_display_(Seq[Any](_display_(Seq[Any](/*220.55*/utils/*220.60*/.NumberUtils.moneda(lc.getTotalOs())))))})),format.raw/*220.97*/("""</b></h4>
							<h4>Total Jubilacion:<b>"""),_display_(Seq[Any](/*221.33*/if(lc.getTotalJubilacion() != null)/*221.68*/{_display_(Seq[Any](_display_(Seq[Any](/*221.70*/utils/*221.75*/.NumberUtils.moneda(lc.getTotalJubilacion())))))})),format.raw/*221.120*/("""</b></h4>
							<h4>Total S.Sepelio:<b>"""),_display_(Seq[Any](/*222.32*/if(lc.getTotalSeguroSepelio() != null)/*222.70*/{_display_(Seq[Any](_display_(Seq[Any](/*222.72*/utils/*222.77*/.NumberUtils.moneda(lc.getTotalSeguroSepelio())))))})),format.raw/*222.125*/("""</b></h4>
							<h4>Total S.Vida:<b>"""),_display_(Seq[Any](/*223.29*/if(lc.getTotalSeguroVida() != null)/*223.64*/{_display_(Seq[Any](_display_(Seq[Any](/*223.66*/utils/*223.71*/.NumberUtils.moneda(lc.getTotalSeguroVida())))))})),format.raw/*223.116*/("""</b></h4>
							<h4>Total Imp.Gcias:<b>"""),_display_(Seq[Any](/*224.32*/if(lc.getTotalImpuestoGanancia() != null)/*224.73*/{_display_(Seq[Any](_display_(Seq[Any](/*224.75*/utils/*224.80*/.NumberUtils.moneda(lc.getTotalImpuestoGanancia())))))})),format.raw/*224.131*/("""</b></h4>
							<h4>Total Embargo:<b>"""),_display_(Seq[Any](/*225.30*/if(lc.getTotalEmbargo() != null)/*225.62*/{_display_(Seq[Any](_display_(Seq[Any](/*225.64*/utils/*225.69*/.NumberUtils.moneda(lc.getTotalEmbargo())))))})),format.raw/*225.111*/("""</b></h4>
							<h4>Total C.PrestaFacil:<b>"""),_display_(Seq[Any](/*226.36*/if(lc.getTotalPrestafacil() != null)/*226.72*/{_display_(Seq[Any](_display_(Seq[Any](/*226.74*/utils/*226.79*/.NumberUtils.moneda(lc.getTotalPrestafacil())))))})),format.raw/*226.125*/("""</b></h4>
							<h4>Total C.Iprodha:<b>"""),_display_(Seq[Any](/*227.32*/if(lc.getTotalIprodha() != null)/*227.64*/{_display_(Seq[Any](_display_(Seq[Any](/*227.66*/utils/*227.71*/.NumberUtils.moneda(lc.getTotalIprodha())))))})),format.raw/*227.113*/("""</b></h4>
							
							"""),_display_(Seq[Any](/*229.9*/if(lc.getTotalMutual() != null)/*229.40*/{_display_(Seq[Any](format.raw/*229.41*/("""
								<h4>Total Federacion:<b>"""),_display_(Seq[Any](/*230.34*/utils/*230.39*/.NumberUtils.moneda(lc.getTotalMutual()))),format.raw/*230.79*/("""</b></h4>
							""")))})),format.raw/*231.9*/("""
							
							"""),_display_(Seq[Any](/*233.9*/if(lc.getTotalCuotaMutual() != null)/*233.45*/{_display_(Seq[Any](format.raw/*233.46*/("""
								<h4>Total Cuota Fed.:<b>"""),_display_(Seq[Any](/*234.34*/utils/*234.39*/.NumberUtils.moneda(lc.getTotalCuotaMutual()))),format.raw/*234.84*/("""</b></h4>
							""")))})),format.raw/*235.9*/("""
							"""),_display_(Seq[Any](/*236.9*/if(lc.getTotalYacare() != null)/*236.40*/{_display_(Seq[Any](format.raw/*236.41*/("""
								<h4>Total Yacare:<b>"""),_display_(Seq[Any](/*237.30*/utils/*237.35*/.NumberUtils.moneda(lc.getTotalYacare()))),format.raw/*237.75*/("""</b></h4>
							""")))})),format.raw/*238.9*/("""
							
							<hr>
							<h3><b>Total Ret.: """),_display_(Seq[Any](/*241.28*/if(lc.getTotalRetenciones() != null)/*241.64*/{_display_(Seq[Any](_display_(Seq[Any](/*241.66*/utils/*241.71*/.NumberUtils.moneda(lc.getTotalRetenciones())))))})),format.raw/*241.117*/("""</b></h3>
							<h3><b>Total a Cobrar: """),_display_(Seq[Any](/*242.32*/if(lc.getTotalACobrar() != null)/*242.64*/{_display_(Seq[Any](_display_(Seq[Any](/*242.66*/utils/*242.71*/.NumberUtils.moneda(lc.getTotalACobrar())))))})),format.raw/*242.113*/("""</b></h3>
							<h3><b>Costo Liquidacion S/P: """),_display_(Seq[Any](/*243.39*/if(lc.getSubTotalAPagar() != null)/*243.73*/{_display_(Seq[Any](_display_(Seq[Any](/*243.75*/utils/*243.80*/.NumberUtils.moneda(lc.getSubTotalAPagar())))))})),format.raw/*243.124*/("""</b></h3>
							<hr>
							<h4>Total C/P Obra Social: 	<b>"""),_display_(Seq[Any](/*245.40*/if(lc.getContribucionesPatronalesObraSocial() != null)/*245.94*/{_display_(Seq[Any](_display_(Seq[Any](/*245.96*/utils/*245.101*/.NumberUtils.moneda(lc.getContribucionesPatronalesObraSocial())))))})),format.raw/*245.165*/("""</b></h4>
							<h4>Total C/P Jubilacion: 	<b>"""),_display_(Seq[Any](/*246.39*/if(lc.getContribucionesPatronalesJubilacion() != null)/*246.93*/{_display_(Seq[Any](_display_(Seq[Any](/*246.95*/utils/*246.100*/.NumberUtils.moneda(lc.getContribucionesPatronalesJubilacion())))))})),format.raw/*246.164*/("""</b></h4>
							<h4>Costo Total Liquidacion: 	<b>"""),_display_(Seq[Any](/*247.42*/if(lc.getTotalAPagar() != null)/*247.73*/{_display_(Seq[Any](_display_(Seq[Any](/*247.75*/utils/*247.80*/.NumberUtils.moneda(lc.getTotalAPagar())))))})),format.raw/*247.121*/("""</b></h4>
							
							<h4>Estado: 
								<b>"""),_display_(Seq[Any](/*250.13*/lc/*250.15*/.estado.nombre)),format.raw/*250.29*/("""</b>
							</h4>
						</div>
					</div>
		
				</div>
			</div>
		</div>
		<div class="col-sm-3">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Acciones</b></div>
				<div class="panel-body">
					<div class="row margin-bottom-25">
						<div class="col-sm-12">
							"""),_display_(Seq[Any](/*264.9*/if(lc.estado.id == Estado.LIQUIDACION_MES_BORRADOR && Permiso.check("liquidacionMesPreliquidarGeneral"))/*264.113*/{_display_(Seq[Any](format.raw/*264.114*/("""
								<a href=""""),_display_(Seq[Any](/*265.19*/controllers/*265.30*/.haberes.routes.LiquidacionMesesController.preliquidar(lc.id))),format.raw/*265.91*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-ok"></i> Preliquidar</a>
							""")))})),format.raw/*267.9*/("""
						</div>
					</div>
					<div class="row margin-bottom-25">
						<div class="col-sm-12">
							
							"""),_display_(Seq[Any](/*273.9*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(lc.estado.orden,models.Estado.TIPO_LIQUIDACION_MESES)) yield /*273.120*/ {_display_(Seq[Any](format.raw/*273.122*/("""	
								"""),_display_(Seq[Any](/*274.10*/if(estado.orden <=6)/*274.30*/ {_display_(Seq[Any](format.raw/*274.32*/("""
									<div class="margin-bottom-25">
									<a href=""""),_display_(Seq[Any](/*276.20*/controllers/*276.31*/.haberes.routes.LiquidacionMesesController.cambiarEstado(lcForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*276.138*/UriTrack/*276.146*/.get("&"))),format.raw/*276.155*/("""" class="btn btn-default">
										<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*277.60*/estado/*277.66*/.nombre)),format.raw/*277.73*/("""
									</a>
									</div>
								""")))})),format.raw/*280.10*/("""
							""")))})),format.raw/*281.9*/("""
							<div class="margin-bottom-25">
							"""),_display_(Seq[Any](/*283.9*/if(lc.estado.id == models.Estado.LIQUIDACION_MES_CANCELADO)/*283.68*/ {_display_(Seq[Any](format.raw/*283.70*/("""
								<a href=""""),_display_(Seq[Any](/*284.19*/controllers/*284.30*/.haberes.routes.LiquidacionMesesController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.LIQUIDACION_MES_BORRADOR))),_display_(Seq[Any](/*284.159*/UriTrack/*284.167*/.get("&"))),format.raw/*284.176*/("""" class="btn btn-default">
									<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
								</a>
							""")))}/*287.9*/else/*287.13*/{_display_(Seq[Any](format.raw/*287.14*/("""
								<a href=""""),_display_(Seq[Any](/*288.19*/controllers/*288.30*/.haberes.routes.LiquidacionMesesController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.LIQUIDACION_MES_CANCELADO))),_display_(Seq[Any](/*288.160*/UriTrack/*288.168*/.get("&"))),format.raw/*288.177*/("""" class="btn btn-default">
									<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Liquidacion
								</a>
							""")))})),format.raw/*291.9*/("""
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="col-sm-4">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Archivos</b></div>
				<div class="panel-body">
					<div class="row margin-bottom-25">
						"""),_display_(Seq[Any](/*304.8*/if(lc.estado.id == models.Estado.LIQUIDACION_MES_APROBADO || lc.estado.id == models.Estado.LIQUIDACION_MES_CERRADA)/*304.123*/ {_display_(Seq[Any](format.raw/*304.125*/("""
							<div class="col-sm-12 margin-bottom-25">
								<a href=""""),_display_(Seq[Any](/*306.19*/controllers/*306.30*/.haberes.routes.LiquidacionPuestosReportesController.reciboSueldosByLiquidacionMes(lc.id))),format.raw/*306.119*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-list-alt"></i> Recibos de Sueldos</a>
								
							</div>
							<!-- <div class="col-sm-12 margin-bottom-25">
								<a id="exportBanco" data-url=""""),_display_(Seq[Any](/*311.40*/controllers/*311.51*/.haberes.routes.LiquidacionAccionesController.exportMacroSueldos(lc.id,false))),format.raw/*311.128*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-floppy-open"></i> Datos exportacion MACRO SUELDOS</a>
								
							</div> -->
							<div class="col-sm-12 margin-bottom-25">
								<a id="exportBancoNew" data-url=""""),_display_(Seq[Any](/*316.43*/controllers/*316.54*/.haberes.routes.LiquidacionAccionesController.exportMacroSueldos(lc.id,true))),format.raw/*316.130*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-floppy-open"></i> Datos exportacion MACRO SUELDOS NUEVO</a>
								
							</div>
							<div class="col-sm-12 margin-bottom-25">
								<a id="exportBanco" data-url=""""),_display_(Seq[Any](/*321.40*/controllers/*321.51*/.haberes.routes.LiquidacionAccionesController.exportBanco(lc.id))),format.raw/*321.115*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-floppy-open"></i> Datos exportacion banco</a>
								
							</div>
							<div class="col-sm-12 margin-bottom-25">
								<a href=""""),_display_(Seq[Any](/*326.19*/controllers/*326.30*/.haberes.routes.LiquidacionAccionesController.exportIps(lc.id))),format.raw/*326.92*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-info-sign"></i> Datos IPS</a>
								
							</div>
							<div class="col-sm-12 margin-bottom-25">
								<a href=""""),_display_(Seq[Any](/*331.19*/controllers/*331.30*/.haberes.routes.LiquidacionAccionesController.exportAfip(lc.id))),format.raw/*331.93*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-th-large"></i> Datos AFIP</a>
								
							</div>
							<div class="col-sm-12">
								<a href=""""),_display_(Seq[Any](/*336.19*/controllers/*336.30*/.haberes.routes.LiquidacionPuestosReportesController.libroSueldos(lc.id))),format.raw/*336.102*/(""""  class="btn btn-default">
								<i class="glyphicon glyphicon-align-justify"></i> Libro de Sueldos</a>
								
							</div>
						""")))})),format.raw/*340.8*/("""
					</div>
				</div>
			</div>
		</div> 	  	 	  	 
	</div> 
	<hr>
	<div class="row">
	 	<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Concepto</th>
					<th>Cantidad</th>
					<th>Haberes C/A</th>
					<th>Haberes S/A</th>
					<th>Desc.</th>
					<th>Contrib.</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*361.6*/for(lcd <- dataPorConcepto) yield /*361.33*/ {_display_(Seq[Any](format.raw/*361.35*/("""
				<tr>
					<td>
						<a class="exportDatosPorConceptoxx" 
						   href=""""),_display_(Seq[Any](/*365.17*/controllers/*365.28*/.haberes.routes.LiquidacionMesesReportesController.exportDatosPorConcepto(lc.id,lcd.getLong("""id""")))),format.raw/*365.130*/("""">
						   """),_display_(Seq[Any](/*366.11*/lcd/*366.14*/.getString("codigo"))),format.raw/*366.34*/("""</a>
					</td>
					<td>"""),_display_(Seq[Any](/*368.11*/lcd/*368.14*/.getString("deno"))),format.raw/*368.32*/("""</td>
					<td>"""),_display_(Seq[Any](/*369.11*/lcd/*369.14*/.getInteger("totalCantidad"))),format.raw/*369.42*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*371.8*/if(lcd.getInteger("tipo") == models.haberes.LiquidacionConceptoTipo.HABERES_CON_APORTE || lcd.getInteger("tipo") == models.haberes.LiquidacionConceptoTipo.DESCUENTOS)/*371.174*/{_display_(Seq[Any](format.raw/*371.175*/("""
							"""),_display_(Seq[Any](/*372.9*/utils/*372.14*/.NumberUtils.moneda(lcd.getBigDecimal("importe")))),format.raw/*372.63*/("""
						""")))})),format.raw/*373.8*/("""
					</td>
					<td>
						"""),_display_(Seq[Any](/*376.8*/if(lcd.getInteger("tipo") == models.haberes.LiquidacionConceptoTipo.HABERES_SIN_APORTE)/*376.95*/{_display_(Seq[Any](format.raw/*376.96*/("""
							"""),_display_(Seq[Any](/*377.9*/utils/*377.14*/.NumberUtils.moneda(lcd.getBigDecimal("importe")))),format.raw/*377.63*/("""
						""")))})),format.raw/*378.8*/("""
					</td>
					<td>
						"""),_display_(Seq[Any](/*381.8*/if(lcd.getInteger("tipo") == models.haberes.LiquidacionConceptoTipo.RETENCIONES)/*381.88*/{_display_(Seq[Any](format.raw/*381.89*/("""
							"""),_display_(Seq[Any](/*382.9*/utils/*382.14*/.NumberUtils.moneda(lcd.getBigDecimal("importe")))),format.raw/*382.63*/("""
						""")))})),format.raw/*383.8*/("""
					</td>
					<td>
						"""),_display_(Seq[Any](/*386.8*/if(lcd.getInteger("tipo") == models.haberes.LiquidacionConceptoTipo.CONTRIBUCIONES_PATRONALES)/*386.102*/{_display_(Seq[Any](format.raw/*386.103*/("""
							"""),_display_(Seq[Any](/*387.9*/utils/*387.14*/.NumberUtils.moneda(lcd.getBigDecimal("importe")))),format.raw/*387.63*/("""
						""")))})),format.raw/*388.8*/("""
					</td>
				</tr>
				""")))})),format.raw/*391.6*/("""
	        </tbody>
        </table>
	</div>  
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.LiquidacionMes],lc:models.haberes.LiquidacionMes,dataPorConcepto:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc,dataPorConcepto)
    
    def f:((Form[models.haberes.LiquidacionMes],models.haberes.LiquidacionMes,List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc,dataPorConcepto) => apply(lcForm,lc,dataPorConcepto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/verLiquidacionMes.scala.html
                    HASH: 7e2b937d4ac4fb8f2362028d28062ade931cee89
                    MATRIX: 899->1|1154->182|1168->189|1252->193|1303->209|1317->215|1389->266|1456->304|1488->328|1563->125|1590->302|1618->372|1657->376|1670->381|1733->435|1773->437|2305->933|2355->974|2395->976|2522->1067|2543->1078|2635->1147|2701->1181|2747->1191|2800->1235|2840->1237|2969->1330|2990->1341|3085->1413|3153->1449|3199->1459|3260->1511|3300->1513|3438->1614|3459->1625|3562->1705|3630->1741|3676->1751|3749->1815|3789->1817|3939->1930|3960->1941|4073->2031|4146->2072|4192->2082|4255->2136|4295->2138|4435->2241|4456->2252|4561->2334|4640->2381|4686->2391|4760->2456|4800->2458|4951->2572|4972->2583|5088->2676|5173->2729|5219->2739|5275->2786|5315->2788|5447->2884|5468->2895|5566->2970|5641->3013|5687->3023|5746->3073|5786->3075|5921->3174|5942->3185|6043->3263|6121->3309|6167->3319|6223->3366|6263->3368|6395->3464|6416->3475|6514->3550|6585->3589|6631->3599|6687->3646|6727->3648|6859->3744|6880->3755|6978->3830|7050->3870|7096->3880|7149->3924|7189->3926|7318->4019|7339->4030|7434->4102|7503->4139|7549->4149|7604->4195|7644->4197|7775->4292|7796->4303|7894->4378|7966->4418|8012->4428|8075->4482|8115->4484|8255->4587|8276->4598|8381->4680|8463->4730|8509->4740|8574->4796|8614->4798|8756->4903|8777->4914|8898->5012|8976->5059|9099->5146|9119->5157|9191->5207|9380->5361|9393->5366|9440->5391|9551->5466|9571->5477|9658->5534|9675->5542|9706->5551|9834->5643|9854->5654|9943->5713|9960->5721|9992->5730|10192->5894|10209->5902|10319->5989|10524->6158|10535->6160|10560->6163|10791->6359|10914->6459|11086->6595|11210->6695|11464->6912|11480->6918|11541->6956|11752->7130|11768->7136|11813->7158|11944->7252|11992->7277|12127->7375|12143->7381|12204->7419|12477->7655|12493->7661|12549->7694|12776->7884|12792->7890|12845->7920|13079->8117|13095->8123|13165->8169|13408->8376|13442->8400|13482->8401|13526->8409|13542->8415|13605->8455|13643->8461|13897->8678|13913->8684|13968->8716|14205->8916|14221->8922|14270->8948|14538->9179|14554->9185|14630->9237|14870->9440|14886->9446|14966->9502|15209->9708|15225->9714|15308->9773|15551->9979|15567->9985|15651->10045|15783->10140|15826->10160|15955->10252|15971->10258|16020->10284|16390->10617|16402->10619|16456->10650|16530->10687|16567->10714|16616->10716|16631->10721|16695->10758|16769->10795|16806->10822|16855->10824|16870->10829|16934->10866|17046->10941|17083->10968|17132->10970|17147->10975|17211->11012|17290->11054|17335->11089|17384->11091|17399->11096|17472->11141|17550->11182|17598->11220|17647->11222|17662->11227|17738->11275|17813->11313|17858->11348|17907->11350|17922->11355|17995->11400|18073->11441|18124->11482|18173->11484|18188->11489|18267->11540|18343->11579|18385->11611|18434->11613|18449->11618|18519->11660|18601->11705|18647->11741|18696->11743|18711->11748|18785->11794|18863->11835|18905->11867|18954->11869|18969->11874|19039->11916|19101->11942|19142->11973|19182->11974|19253->12008|19268->12013|19331->12053|19381->12071|19434->12088|19480->12124|19520->12125|19591->12159|19606->12164|19674->12209|19724->12227|19769->12236|19810->12267|19850->12268|19917->12298|19932->12303|19995->12343|20045->12361|20130->12409|20176->12445|20225->12447|20240->12452|20314->12498|20392->12539|20434->12571|20483->12573|20498->12578|20568->12620|20653->12668|20697->12702|20746->12704|20761->12709|20833->12753|20931->12814|20995->12868|21044->12870|21060->12875|21152->12939|21237->12987|21301->13041|21350->13043|21366->13048|21458->13112|21546->13163|21587->13194|21636->13196|21651->13201|21720->13242|21807->13292|21819->13294|21856->13308|22188->13604|22303->13708|22344->13709|22400->13728|22421->13739|22505->13800|22636->13899|22784->14011|22913->14122|22955->14124|23003->14135|23033->14155|23074->14157|23171->14217|23192->14228|23331->14335|23350->14343|23383->14352|23506->14438|23522->14444|23552->14451|23625->14491|23666->14500|23749->14547|23818->14606|23859->14608|23915->14627|23936->14638|24097->14767|24116->14775|24149->14784|24291->14907|24305->14911|24345->14912|24401->14931|24422->14942|24584->15072|24603->15080|24636->15089|24793->15214|25094->15479|25220->15594|25262->15596|25366->15663|25387->15674|25500->15763|25756->15982|25777->15993|25878->16070|26152->16307|26173->16318|26273->16394|26546->16630|26567->16641|26655->16705|26893->16906|26914->16917|26999->16979|27221->17164|27242->17175|27328->17238|27533->17406|27554->17417|27650->17489|27819->17626|28217->17988|28261->18015|28302->18017|28418->18096|28439->18107|28565->18209|28615->18222|28628->18225|28671->18245|28734->18271|28747->18274|28788->18292|28841->18308|28854->18311|28905->18339|28964->18362|29141->18528|29182->18529|29227->18538|29242->18543|29314->18592|29354->18600|29419->18629|29516->18716|29556->18717|29601->18726|29616->18731|29688->18780|29728->18788|29793->18817|29883->18897|29923->18898|29968->18907|29983->18912|30055->18961|30095->18969|30160->18998|30265->19092|30306->19093|30351->19102|30366->19107|30438->19156|30478->19164|30537->19191
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|57->25|57->25|57->25|58->26|58->26|58->26|59->27|60->28|60->28|60->28|61->29|61->29|61->29|62->30|63->31|63->31|63->31|64->32|64->32|64->32|65->33|66->34|66->34|66->34|67->35|67->35|67->35|68->36|69->37|69->37|69->37|70->38|70->38|70->38|71->39|72->40|72->40|72->40|73->41|73->41|73->41|74->42|75->43|75->43|75->43|76->44|76->44|76->44|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|81->49|81->49|81->49|82->50|82->50|82->50|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|87->55|87->55|87->55|88->56|88->56|88->56|89->57|90->58|90->58|90->58|91->59|91->59|91->59|92->60|93->61|93->61|93->61|94->62|94->62|94->62|95->63|96->64|96->64|96->64|97->65|97->65|97->65|98->66|102->70|102->70|102->70|109->77|109->77|109->77|113->81|113->81|113->81|113->81|113->81|114->82|114->82|114->82|114->82|114->82|117->85|117->85|117->85|121->89|121->89|121->89|129->97|129->97|136->104|136->104|145->113|145->113|145->113|151->119|151->119|151->119|156->124|156->124|157->125|157->125|157->125|165->133|165->133|165->133|171->139|171->139|171->139|177->145|177->145|177->145|184->152|184->152|184->152|185->153|185->153|185->153|186->154|193->161|193->161|193->161|199->167|199->167|199->167|207->175|207->175|207->175|213->181|213->181|213->181|219->187|219->187|219->187|225->193|225->193|225->193|230->198|230->198|231->199|231->199|231->199|247->215|247->215|247->215|248->216|248->216|248->216|248->216|248->216|249->217|249->217|249->217|249->217|249->217|252->220|252->220|252->220|252->220|252->220|253->221|253->221|253->221|253->221|253->221|254->222|254->222|254->222|254->222|254->222|255->223|255->223|255->223|255->223|255->223|256->224|256->224|256->224|256->224|256->224|257->225|257->225|257->225|257->225|257->225|258->226|258->226|258->226|258->226|258->226|259->227|259->227|259->227|259->227|259->227|261->229|261->229|261->229|262->230|262->230|262->230|263->231|265->233|265->233|265->233|266->234|266->234|266->234|267->235|268->236|268->236|268->236|269->237|269->237|269->237|270->238|273->241|273->241|273->241|273->241|273->241|274->242|274->242|274->242|274->242|274->242|275->243|275->243|275->243|275->243|275->243|277->245|277->245|277->245|277->245|277->245|278->246|278->246|278->246|278->246|278->246|279->247|279->247|279->247|279->247|279->247|282->250|282->250|282->250|296->264|296->264|296->264|297->265|297->265|297->265|299->267|305->273|305->273|305->273|306->274|306->274|306->274|308->276|308->276|308->276|308->276|308->276|309->277|309->277|309->277|312->280|313->281|315->283|315->283|315->283|316->284|316->284|316->284|316->284|316->284|319->287|319->287|319->287|320->288|320->288|320->288|320->288|320->288|323->291|336->304|336->304|336->304|338->306|338->306|338->306|343->311|343->311|343->311|348->316|348->316|348->316|353->321|353->321|353->321|358->326|358->326|358->326|363->331|363->331|363->331|368->336|368->336|368->336|372->340|393->361|393->361|393->361|397->365|397->365|397->365|398->366|398->366|398->366|400->368|400->368|400->368|401->369|401->369|401->369|403->371|403->371|403->371|404->372|404->372|404->372|405->373|408->376|408->376|408->376|409->377|409->377|409->377|410->378|413->381|413->381|413->381|414->382|414->382|414->382|415->383|418->386|418->386|418->386|419->387|419->387|419->387|420->388|423->391
                    -- GENERATED --
                */
            