
package views.html.contabilidad.pagos

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
object indexPagoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Pago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Pago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/pagos.js"))),format.raw/*7.69*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*9.2*/getClassEstado/*9.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 24){
		classEstado = "borrador"
	}else if(i != null && i.id == 26){
		classEstado = "cancelada"
	}else if(i != null && (i.id == 23)){
		classEstado = "autorizado"
	}else if(i != null && i.id == 25){
		classEstado = "pagado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.74*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),format.raw/*22.2*/("""


"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.contabilidad.mainContabilidad("Lista Pagos", scripts)/*25.66*/ {_display_(Seq[Any](format.raw/*25.68*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de pagos</h1>
			</div>

			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
			
					<div class="btn-group pull-right  btn-header">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownReportes" data-toggle="dropdown">
							<i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							"""),_display_(Seq[Any](/*42.9*/if(Permiso.check("pagosInformeMensualRentas"))/*42.55*/ {_display_(Seq[Any](format.raw/*42.57*/("""
								<li><a id="reporteInformeMensualRentas" href="#" data-url=""""),_display_(Seq[Any](/*43.69*/controllers/*43.80*/.contabilidad.routes.PagosReportesController.modalInformeMensualRentas())),format.raw/*43.152*/("""">Informe mensual de RENTAS</a></li>
							""")))})),format.raw/*44.9*/("""
							<li><a id="reporteInformeLotes" href="#" data-url=""""),_display_(Seq[Any](/*45.60*/controllers/*45.71*/.contabilidad.routes.PagosReportesController.descargarLotes())),format.raw/*45.132*/("""">Informe Lotes</a></li>
							<li><a id="reporteInformeMensualImpuestos" href="#" data-url=""""),_display_(Seq[Any](/*46.71*/controllers/*46.82*/.contabilidad.routes.PagosReportesController.modalInformeMensualImpuestos())),format.raw/*46.157*/("""">Informe Impuestos</a></li>
							<li><a id="reporteRetencionDgrSellos" href="#" data-url=""""),_display_(Seq[Any](/*47.66*/controllers/*47.77*/.contabilidad.routes.PagosReportesController.informeRetDgrSellos())),format.raw/*47.143*/("""">Retencion DGR Sellos</a></li>
							<li><a id="reporteInformeRetDgrIibb" href="#" data-url=""""),_display_(Seq[Any](/*48.65*/controllers/*48.76*/.contabilidad.routes.PagosReportesController.informeRetDgrIibb())),format.raw/*48.140*/("""">Retencion DGR IIBB</a></li>
							<li><a id="reporteInformeRetDgrIibb331" href="#" data-url=""""),_display_(Seq[Any](/*49.68*/controllers/*49.79*/.contabilidad.routes.PagosReportesController.informeRetDgrIibb331())),format.raw/*49.146*/("""">Retencion DGR IIBB 331</a></li>
							<li><a id="reporteRetencionSeguridad" class="reporteRetencionSeguridad" href="#" data-url=""""),_display_(Seq[Any](/*50.100*/controllers/*50.111*/.contabilidad.routes.PagosReportesController.informeRetencionSuss("748"))),format.raw/*50.183*/("""">Retencion SUSS 6% Res. AFIP 1556/04</a></li>
							<li><a id="reporteRetencionSeguridad2" class="reporteRetencionSeguridad" href="#" data-url=""""),_display_(Seq[Any](/*51.101*/controllers/*51.112*/.contabilidad.routes.PagosReportesController.informeRetencionSuss("754"))),format.raw/*51.184*/("""">Retencion SUSS 6% Res. AFIP 1769/04</a></li>
							<li><a id="reporteRetencionSeguridad3" class="reporteRetencionSeguridad" href="#" data-url=""""),_display_(Seq[Any](/*52.101*/controllers/*52.112*/.contabilidad.routes.PagosReportesController.informeRetencionSuss("755"))),format.raw/*52.184*/("""">Retencion SUSS 1% AFIP 2069/06 mof 1784/04</a></li>
							
							<li><a id="reporteRetencionSeguridad4" class="reporteRetencionSeguridad" href="#" data-url=""""),_display_(Seq[Any](/*54.101*/controllers/*54.112*/.contabilidad.routes.PagosReportesController.informeRetencionSuss("740"))),format.raw/*54.184*/("""">Retencion SUSS 2.5% Res AFIP 2682/09</a></li>
							
							
							<li><a id="reporteRetencionGcia4245" href="#" data-url=""""),_display_(Seq[Any](/*57.65*/controllers/*57.76*/.contabilidad.routes.PagosReportesController.informeRetencionGcia4245())),format.raw/*57.147*/("""">Retencion RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4245/18</a></li>
							<li><a id="reporteRetencionIva" href="#" data-url=""""),_display_(Seq[Any](/*58.60*/controllers/*58.71*/.contabilidad.routes.PagosReportesController.informeRetencionIva())),format.raw/*58.137*/("""">Retencion RET. IVA 8,68% RES. AFIP 3164/11</a></li>
							
							<li><a id="reporteInformeImpuestoMunicipal" href="#" data-url=""""),_display_(Seq[Any](/*60.72*/controllers/*60.83*/.contabilidad.routes.PagosReportesController.informeImpuestoMunicipal())),format.raw/*60.154*/("""">Informe Impuesto Municipal</a></li>
							<li><a id="reporteInformeProfe" href="#" data-url=""""),_display_(Seq[Any](/*61.60*/controllers/*61.71*/.contabilidad.routes.PagosReportesController.informeProfe())),format.raw/*61.130*/("""">Informe PROFE</a></li>
						</ul>
					</div>
					
					<div class="dropdown btn-group pull-right  btn-header">
						 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownAcciones" data-toggle="dropdown">
							<i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span>
						 </button>
						 <ul class="dropdown-menu">
						 """),_display_(Seq[Any](/*70.9*/if(Permiso.check("pagosModificarFechaMasivamente"))/*70.60*/ {_display_(Seq[Any](format.raw/*70.62*/("""
						 	<li><a id="accionModificarFecha" href="#" data-url=""""),_display_(Seq[Any](/*71.62*/controllers/*71.73*/.contabilidad.routes.PagosAccionesController.modalModificarFecha())),format.raw/*71.139*/("""">Modificar fecha</a></li>
						 """)))})),format.raw/*72.9*/("""
									   
						 """),_display_(Seq[Any](/*74.9*/if(Permiso.check("pagosModificarReferenciaMasivamente"))/*74.65*/ {_display_(Seq[Any](format.raw/*74.67*/("""
						 	<li><a id="accionModificarReferencia" href="#"  data-url=""""),_display_(Seq[Any](/*75.68*/controllers/*75.79*/.contabilidad.routes.PagosAccionesController.modalModificarReferencia())),format.raw/*75.150*/("""">Modificar referencia</a></li>
						 """)))})),format.raw/*76.9*/("""
						 
						 """),_display_(Seq[Any](/*78.9*/if(Permiso.check("pagosModificarPagueseMasivamente"))/*78.62*/ {_display_(Seq[Any](format.raw/*78.64*/("""
						 	<li><a id="accionModificarPaguese" href="#"  data-url=""""),_display_(Seq[Any](/*79.65*/controllers/*79.76*/.contabilidad.routes.PagosAccionesController.modalModificarPaguese())),format.raw/*79.144*/("""">Modificar Paguese A</a></li>
						 """)))})),format.raw/*80.9*/("""
						 
						 """),_display_(Seq[Any](/*82.9*/if(Permiso.check("pagosModificarFechaConciliadoMasivamente"))/*82.70*/ {_display_(Seq[Any](format.raw/*82.72*/("""
						 	<li><a id="accionModificarFechaConciliado" href="#" data-url=""""),_display_(Seq[Any](/*83.72*/controllers/*83.83*/.contabilidad.routes.PagosAccionesController.modalModificarFechaConciliado())),format.raw/*83.159*/("""">Modificar fecha Conciliacion</a></li> 
						 """)))})),format.raw/*84.9*/("""
						  """),_display_(Seq[Any](/*85.10*/if(Permiso.check("pagosModificarFechaCancelacionMasivamente"))/*85.72*/ {_display_(Seq[Any](format.raw/*85.74*/("""
						 	<li><a id="accionModificarFechaCancelacion" href="#" data-url=""""),_display_(Seq[Any](/*86.73*/controllers/*86.84*/.contabilidad.routes.PagosAccionesController.modalModificarFechaCancelacion())),format.raw/*86.161*/("""">Modificar fecha Cancelacion</a></li>
						 """)))})),format.raw/*87.9*/("""
						 
						 """),_display_(Seq[Any](/*89.9*/if(Permiso.check("pagosModificarNumeroCheque"))/*89.56*/ {_display_(Seq[Any](format.raw/*89.58*/("""
						 	<li><a id="accionModificarNumeroCheque" href="#"  data-url=""""),_display_(Seq[Any](/*90.70*/controllers/*90.81*/.contabilidad.routes.PagosAccionesController.modalModificarNumeroCheque())),format.raw/*90.154*/("""">Modificar N°Cheque</a></li>
						 """)))})),format.raw/*91.9*/("""
						 """),_display_(Seq[Any](/*92.9*/if(Permiso.check("pagosModificarTipoPago"))/*92.52*/ {_display_(Seq[Any](format.raw/*92.54*/("""
						 	<li><a id="accionModificarTipoPago" href="#"  data-url=""""),_display_(Seq[Any](/*93.66*/controllers/*93.77*/.contabilidad.routes.PagosAccionesController.modalModificarTipoPago())),format.raw/*93.146*/("""">Modificar Tipo Pago</a></li>
						 """)))})),format.raw/*94.9*/("""
						  """),_display_(Seq[Any](/*95.10*/if(Permiso.check("pagosModificarCuentaPropia"))/*95.57*/ {_display_(Seq[Any](format.raw/*95.59*/("""
						 	<li><a id="accionModificarCuentaPropia" href="#"  data-url=""""),_display_(Seq[Any](/*96.70*/controllers/*96.81*/.contabilidad.routes.PagosAccionesController.modalModificarCuentaPropia())),format.raw/*96.154*/("""">Modificar Cuenta Propia</a></li>
						 """)))})),format.raw/*97.9*/("""
						 
						  """),_display_(Seq[Any](/*99.10*/if(Permiso.check("pagosPagarProveedoresExternos"))/*99.60*/ {_display_(Seq[Any](format.raw/*99.62*/("""
						 	<li><a id="accionCrearRefenciaEmbargos" href="#" data-url=""""),_display_(Seq[Any](/*100.69*/controllers/*100.80*/.contabilidad.routes.PagosAccionesController.modalCrearRefenciaEmbargos())),format.raw/*100.153*/("""">Crear Ref.Embargos </a></li>
						 """)))})),format.raw/*101.9*/("""
						 
						 	<li class="divider"></li>
						 """),_display_(Seq[Any](/*104.9*/if(Permiso.check("pagosPagarCheques"))/*104.47*/ {_display_(Seq[Any](format.raw/*104.49*/("""
						 	<li><a id="accionPagarCheque" href="#" data-url=""""),_display_(Seq[Any](/*105.59*/controllers/*105.70*/.contabilidad.routes.PagosAccionesController.modalPagarCheques())),format.raw/*105.134*/("""">Pagar cheques</a></li>
						 """)))})),format.raw/*106.9*/("""	
						 """),_display_(Seq[Any](/*107.9*/if(Permiso.check("pagosPagarAgentesContratados"))/*107.58*/ {_display_(Seq[Any](format.raw/*107.60*/("""
						 	<li><a id="accionPagar" href="#" data-url=""""),_display_(Seq[Any](/*108.53*/controllers/*108.64*/.contabilidad.routes.PagosAccionesController.modalPagarInterno())),format.raw/*108.128*/("""">Pagar agentes contratados (Trasnf.)</a></li>
						 """)))})),format.raw/*109.9*/("""
						 """),_display_(Seq[Any](/*110.9*/if(Permiso.check("pagosPagarAgentesPlanta"))/*110.53*/ {_display_(Seq[Any](format.raw/*110.55*/("""	
						 	<li><a id="accionPagarPlanta" href="#" data-url=""""),_display_(Seq[Any](/*111.59*/controllers/*111.70*/.contabilidad.routes.PagosAccionesController.modalPagarPlanta)),format.raw/*111.131*/("""">Pagar agentes en planta (Trasnf.)</a></li>
						 """)))})),format.raw/*112.9*/("""
						 """),_display_(Seq[Any](/*113.9*/if(Permiso.check("pagosPagarProveedoresExternos"))/*113.59*/ {_display_(Seq[Any](format.raw/*113.61*/("""	
						 	<li><a id="accionPagarProveedorExterno" href="#" data-url=""""),_display_(Seq[Any](/*114.69*/controllers/*114.80*/.contabilidad.routes.PagosAccionesController.modalPagarProveedoresExternos())),format.raw/*114.156*/("""">Pagar proveedores externos (Trasnf.)</a></li>
						 """)))})),format.raw/*115.9*/("""
						 
						 """),_display_(Seq[Any](/*117.9*/if(Permiso.check("pagosPagarProveedoresExternos"))/*117.59*/ {_display_(Seq[Any](format.raw/*117.61*/("""	
						 	<li><a id="accionPagarEmbargos" href="#" data-url=""""),_display_(Seq[Any](/*118.61*/controllers/*118.72*/.contabilidad.routes.PagosAccionesController.modalPagarEmbargos())),format.raw/*118.137*/("""">Pagar Embargos Banco Macro</a></li>
						 """)))})),format.raw/*119.9*/("""
						 """),_display_(Seq[Any](/*120.9*/if(Permiso.check("pagosPagarProveedoresExternos"))/*120.59*/ {_display_(Seq[Any](format.raw/*120.61*/("""	
						 	<li><a id="accionPagarEmbargosExternos" href="#" data-url=""""),_display_(Seq[Any](/*121.69*/controllers/*121.80*/.contabilidad.routes.PagosAccionesController.modalPagarEmbargosExternos())),format.raw/*121.153*/("""">Pagar Embargos Externos</a></li>
						 """)))})),format.raw/*122.9*/("""
						 
						 """),_display_(Seq[Any](/*124.9*/if(Permiso.check("pagosPagarProveedoresInterbanking"))/*124.63*/ {_display_(Seq[Any](format.raw/*124.65*/("""	
						 	<li><a id="accionPagarExternosInterbankingProveedores" href="#" 
						 	data-url=""""),_display_(Seq[Any](/*126.20*/controllers/*126.31*/.contabilidad.routes.PagosAccionesController.modalPagarInterbankingProveedores())),format.raw/*126.111*/("""">Pagar Interbanking Proveedores</a></li>
						 """)))})),format.raw/*127.9*/("""
						 
						 """),_display_(Seq[Any](/*129.9*/if(Permiso.check("pagosPagarProveedoresMacrosMaviso"))/*129.63*/ {_display_(Seq[Any](format.raw/*129.65*/("""	
						 	<li><a id="accionPagarProveedoresMacrosMaviso" href="#" 
						 	data-url=""""),_display_(Seq[Any](/*131.20*/controllers/*131.31*/.contabilidad.routes.PagosAccionesController.modalPagarProveedoresMacroMasivos())),format.raw/*131.111*/("""">Pagar Proveedores Macro Masivos</a></li>
						 """)))})),format.raw/*132.9*/("""
						 
						 	<li class="divider"></li>
						 	<li role="presentation" class="dropdown-header">Acciones Masivas</li>
						 	"""),_display_(Seq[Any](/*136.10*/if(Permiso.check("pagosPasarBorradorMasivo"))/*136.55*/ {_display_(Seq[Any](format.raw/*136.57*/("""	
						 	<li role="presentation">
						    	<a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*138.90*/controllers/*138.101*/.contabilidad.routes.PagosAccionesController.modalPasarBorrador())),format.raw/*138.166*/("""">
						    		Pasar a Borrador
						    	</a>
						    </li>
						    """)))})),format.raw/*142.12*/("""
						    """),_display_(Seq[Any](/*143.12*/if(Permiso.check("pagosPasarConciliadoMasivo"))/*143.59*/ {_display_(Seq[Any](format.raw/*143.61*/("""	
						    <li role="presentation">
						    	<a role="menuitem" id="accionPasarConciliado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*145.92*/controllers/*145.103*/.contabilidad.routes.PagosAccionesController.modalPasarConciliado())),format.raw/*145.170*/("""">
						    		Pasar a Conciliado (Cheques)
						    	</a>
						    </li>	
						    """)))})),format.raw/*149.12*/("""
						    """),_display_(Seq[Any](/*150.12*/if(Permiso.check("pagosPasarCanceladoMasivo"))/*150.58*/ {_display_(Seq[Any](format.raw/*150.60*/("""	
						    <li role="presentation">
						    	<a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*152.91*/controllers/*152.102*/.contabilidad.routes.PagosAccionesController.modalPasarCancelado())),format.raw/*152.168*/("""">
						    		Pasar a Cancelado
						    	</a>
						    </li>	
						    """)))})),format.raw/*156.12*/("""
						 </ul>
					 </div>
					 
					<a href=""""),_display_(Seq[Any](/*160.16*/controllers/*160.27*/.contabilidad.routes.PagosController.crear)),format.raw/*160.69*/(""""  class="btn btn-default  btn-header pull-right">
						<i class="glyphicon glyphicon-plus-sign"></i> Nuevo pago
					</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*168.3*/views/*168.8*/.html.tags.successError())),format.raw/*168.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchPagos" method="GET">
			<div class="row">
				<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
					<div class="btn-group">
					  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-pencil"></i><br>Borrador
					  	"""),_display_(Seq[Any](/*177.10*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*177.69*/("""
					  </button>
					  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>En Curso
					  	"""),_display_(Seq[Any](/*181.10*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*181.69*/("""
					  </button>
					  <button type="button" rel="entregado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-usd glyphicon-usd-green"></i><br>Pagado
					  	"""),_display_(Seq[Any](/*185.10*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*185.69*/("""
					  </button>
					  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-ok"></i><br>Conciliado
					  	"""),_display_(Seq[Any](/*189.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*189.69*/("""
					  </button>
					  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
					  	"""),_display_(Seq[Any](/*193.10*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*193.69*/("""
					  </button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Pago</label>
					<div>
						"""),_display_(Seq[Any](/*202.8*/inputText(formBuscador("fecha_pago_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_desde", 'placeholder -> "Desde"))),format.raw/*202.146*/("""
						"""),_display_(Seq[Any](/*203.8*/inputText(formBuscador("fecha_pago_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_hasta", 'placeholder -> "Hasta"))),format.raw/*203.146*/("""
					</div>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Referencia
						"""),_display_(Seq[Any](/*210.8*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*210.71*/("""
						</label>
					</div>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Contraparte
						<div class="input-group">
							"""),_display_(Seq[Any](/*218.9*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*218.111*/("""
							"""),_display_(Seq[Any](/*219.9*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*219.92*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*224.23*/controllers/*224.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*224.85*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.proveedor.simple" 
											data-label="#proveedor" 
											data-field="#proveedor_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				
				<div class="col-sm-2">
				
					<div class="form-group """),_display_(Seq[Any](/*239.30*/if(formBuscador.error("periodo_id") != null)/*239.74*/ {_display_(Seq[Any](format.raw/*239.76*/("""has-error""")))})),format.raw/*239.86*/("""">
						<label for="periodo" class="control-label">Periodo</label> 
						<div class="input-group">
							"""),_display_(Seq[Any](/*242.9*/inputText(formBuscador("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*242.94*/("""
							"""),_display_(Seq[Any](/*243.9*/inputText(formBuscador("periodo.id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*243.87*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchPeriodo" 
											data-title="Selección de Periodo" 
											data-url=""""),_display_(Seq[Any](/*248.23*/controllers/*248.34*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*248.87*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.periodo.simple" 
											data-label="#periodo" 
											data-field="#periodo_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</div>

				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Expediente
						<div class="input-group">
							"""),_display_(Seq[Any](/*265.9*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*265.113*/("""
							"""),_display_(Seq[Any](/*266.9*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*266.94*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchExpediente" 
											data-title="Selección de expediente" 
											data-url=""""),_display_(Seq[Any](/*271.23*/controllers/*271.34*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*271.88*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.expediente.simple" 
											data-label="#expediente" 
											data-field="#expediente_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Ejercicio
						"""),_display_(Seq[Any](/*286.8*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*286.167*/("""
					</label>
				</div>
			</div>
			<div class="row">
				<!--<div class="col-sm-2 input-group">
					  <label class="control-label">Orden de Pago N°
					<div>
					"""),_display_(Seq[Any](/*294.7*/inputText(formBuscador("numero_orden_pago_desde"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_desde", 
							  'style -> "width: 71px;font-size:11px;", 
							  'placeholder -> "Desde"))),format.raw/*298.34*/("""
					"""),_display_(Seq[Any](/*299.7*/inputText(formBuscador("numero_orden_pago_hasta"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_hasta", 
							  'style -> "width: 71px;font-size:11px;", 'placeholder -> "Hasta"))),format.raw/*302.75*/("""
					</div>
					</label>
				</div>-->
				
				<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*310.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*310.98*/("""
						"""),_display_(Seq[Any](/*311.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*311.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPeriodo" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*316.22*/controllers/*316.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*316.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
				</div>
				
				<!-- <div class="col-sm-2 input-group">
					<label class="control-label">Fecha OPG</label>
					<div>
						"""),_display_(Seq[Any](/*332.8*/inputText(formBuscador("fecha_opg_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_opg_desde", 'placeholder -> "Desde"))),format.raw/*332.144*/("""
						"""),_display_(Seq[Any](/*333.8*/inputText(formBuscador("fecha_opg_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_opg_hasta", 'placeholder -> "Hasta"))),format.raw/*333.144*/("""
					</div>
				</div> -->
				
				<div class="col-sm-2">
					<label class="control-label">Tipo de proveedor
						"""),_display_(Seq[Any](/*339.8*/select(formBuscador("tipo_proveedor"), options(Proveedor.TIPO_INTERNO ->"Agentes", Proveedor.TIPO_EXTERNO->"Proveedores", Proveedor.TIPO_AGENTE_INTERNO ->"Agentes contratados", Proveedor.TIPO_AGENTE_PLANTA->"Agentes en planta"), 'class -> "form-control select", '_default -> "Todos"))),format.raw/*339.291*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Cuenta Impuesto
						<div class="input-group">
							"""),_display_(Seq[Any](/*345.9*/inputText(formBuscador("cuentaImpuesto.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cuenta_impuesto"))),format.raw/*345.122*/("""
							"""),_display_(Seq[Any](/*346.9*/inputText(formBuscador("cuentaImpuesto.id"), 'hidden -> "hidden", 'id -> "cuenta_impuesto_id"))),format.raw/*346.103*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchCuentaModal" 
											data-title="Selección de Cuenta" 
											data-url=""""),_display_(Seq[Any](/*351.23*/controllers/*351.34*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*351.86*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.cuenta.simple" 
											data-label="#cuenta_impuesto" 
											data-field="#cuenta_impuesto_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Contraparte factura
						<div class="input-group">
							"""),_display_(Seq[Any](/*366.9*/inputText(formBuscador("factura.proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor_factura"))),format.raw/*366.127*/("""
							"""),_display_(Seq[Any](/*367.9*/inputText(formBuscador("factura.proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_factura_id"))),format.raw/*367.108*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*372.23*/controllers/*372.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*372.85*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.proveedor.simple" 
											data-label="#proveedor_factura" 
											data-field="#proveedor_factura_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Tipo de Contraparte
						"""),_display_(Seq[Any](/*386.8*/select(formBuscador("tipo_proveedor_contraparte"), options(Proveedor.TIPO_INTERNO ->"Agentes", Proveedor.TIPO_EXTERNO->"Proveedores", Proveedor.TIPO_AGENTE_INTERNO ->"Agentes contratados", Proveedor.TIPO_AGENTE_PLANTA->"Agentes en planta"), 'class -> "form-control select", '_default -> "Todos"))),format.raw/*386.303*/("""
					</label>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Entrega Factura</label>
					<div>
						"""),_display_(Seq[Any](/*392.8*/inputText(formBuscador("fecha_entrega_factura_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_entrega_factura_desde", 'placeholder -> "Desde"))),format.raw/*392.168*/("""
						"""),_display_(Seq[Any](/*393.8*/inputText(formBuscador("fecha_entrega_factura_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_entrega_factura_hasta", 'placeholder -> "Hasta"))),format.raw/*393.168*/("""
					</div>
				</div>
			</div>	
			<div class="row">
				
				
				<div class="col-sm-2 input-group">
					<label class="control-label"> 
						<!-- PROFE
						"""),_display_(Seq[Any](/*403.8*/select(formBuscador("profe"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*403.108*/(""" -->
						Tipo Cuenta
						"""),_display_(Seq[Any](/*405.8*/select(formBuscador("tipo_cuenta_id"), 
						TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*406.128*/("""
					</label>
				</div>
				
				<div class="col-sm-2">
					<div class="checkbox">
						<label for="inputGuardia" class="control-label"> 
							Guardia
							"""),_display_(Seq[Any](/*414.9*/checkbox(formBuscador("guardia")))),format.raw/*414.42*/("""
						</label><br>
					</div> 
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Conciliacion</label>
					<div>
						"""),_display_(Seq[Any](/*421.8*/inputText(formBuscador("fecha_conciliacion_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_conciliacion_desde", 'placeholder -> "Desde"))),format.raw/*421.162*/("""
						"""),_display_(Seq[Any](/*422.8*/inputText(formBuscador("fecha_conciliacion_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_conciliacion_hasta", 'placeholder -> "Hasta"))),format.raw/*422.162*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Tipo de pago
						"""),_display_(Seq[Any](/*427.8*/select(formBuscador("tipo_pago"), options("transferencia"->"Macro Online","transferenciaMacroProveedores"->"Macro Proveedores","transferenciaInterbanking"->"Interbanking","cheque"->"Cheque","debito"->"Debito"), 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*427.279*/("""
					</label>
				</div>	
				
				<div class="col-sm-4">
				
					<div class="col-sm-4">
						<label class="control-label"> 
							Impuesto
							"""),_display_(Seq[Any](/*436.9*/select(formBuscador("tipo"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*436.108*/("""
						</label>
					</div>
					<!-- <div class="col-sm-2">
						<div class="form-group">
							<label class="control-label">Estado PP</label>
							"""),_display_(Seq[Any](/*442.9*/select(formBuscador("estado_pp"), 
							Estado.find.where().eq("tipo",Estado.TIPO_PAGO).findList().map { p => p.id.toString -> p.nombre}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*444.68*/(""", 
						</div>
					</div>  -->
					<div class="col-sm-4">
						<label class="control-label"> 
							RP
							"""),_display_(Seq[Any](/*450.9*/select(formBuscador("rp"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*450.106*/("""
						</label>
					</div>
					<!--<div class="col-sm-2">
						<div class="checkbox">
							<label for="inputGuardia" class="control-label"> 
								RP
								"""),_display_(Seq[Any](/*457.10*/checkbox(formBuscador("rp")))),format.raw/*457.38*/("""
							</label><br>
						</div> 
					</div>-->
					<div class="col-sm-4">
						<label class="control-label"> 
							Emergencia
							"""),_display_(Seq[Any](/*464.9*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*464.114*/("""
						</label>
					</div>
				</div>	
			</div>
			<div class="row">
				
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*480.16*/controllers/*480.27*/.contabilidad.routes.PagosController.index())),format.raw/*480.71*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div class="row">
	<div class="col-sm-12">
	"""),_display_(Seq[Any](/*489.3*/if(buscador.getTotalRowCount == 0)/*489.37*/ {_display_(Seq[Any](format.raw/*489.39*/("""
        
        <div class="well">
            <em>No se encuentran Pagos</em>
        </div>
        
    """)))}/*495.7*/else/*495.12*/{_display_(Seq[Any](format.raw/*495.13*/("""
		
		<table id="listaPagos" class="table table-striped table-bordered">
			<thead>
				<tr style="background: #FFFFFF;">	
	        		<td colspan="14">Mostrando """),_display_(Seq[Any](/*500.40*/buscador/*500.48*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*500.80*/(""" resultado(s).</td>
	        		<td><b>Total Debito:</b> <span class="totalFooter"></span></td>
	        		<td><b>Total Credito:</b> <span class="totalCreditoFooter"></span></td>
	        		<td colspan="2">&nbsp</td>
	        	</tr>
				
				<tr>
					<th width="20"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th>#</th>
					<th>Referencia</th>
					<th>Fecha</th>
					<th>Fecha Concil.</th>
					<!-- <th>Entrega Factura</th>-->
					<!-- <th width="80">Fecha Conciliado</th> -->
					<th>C/O</th>
					<th>REF N°</th>
					<th>Contraparte</th>
					<th>Cuenta propia</th>
					<th>T.P.</th>
					<th>Orden pago</th>
					<th>Tipo Cuenta</th>
					<th>Exp.</th>
					<th>Periodo</th>
					<th>Total Debito</th>
					<th>Total Credito</th>
					<th>Estado</th>
					<th width="20">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*530.5*/for(pago <- buscador.getList) yield /*530.34*/ {_display_(Seq[Any](format.raw/*530.36*/("""
				<tr class="pointer """),_display_(Seq[Any](/*531.25*/getClassEstado(pago.estado))),format.raw/*531.52*/("""" data-estado=""""),_display_(Seq[Any](/*531.68*/pago/*531.72*/.estado_id)),format.raw/*531.82*/("""" data-href=""""),_display_(Seq[Any](/*531.96*/controllers/*531.107*/.contabilidad.routes.PagosController.ver(pago.id))),format.raw/*531.156*/("""&"""),_display_(Seq[Any](/*531.158*/UriTrack/*531.166*/.encode())),format.raw/*531.175*/("""">
					<td><input type="checkbox" name="id_pago[]" value=""""),_display_(Seq[Any](/*532.58*/pago/*532.62*/.id)),format.raw/*532.65*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*532.99*/pago/*532.103*/.id)),format.raw/*532.106*/(""""/></td>
					<td class="notSeleccion">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*534.61*/controllers/*534.72*/.contabilidad.routes.PagosController.editar(pago.id))),format.raw/*534.124*/("""&"""),_display_(Seq[Any](/*534.126*/UriTrack/*534.134*/.encode())),format.raw/*534.143*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>				
					<td>"""),_display_(Seq[Any](/*538.11*/(pago.nombre))),format.raw/*538.24*/("""
						"""),_display_(Seq[Any](/*539.8*/if(pago.expediente != null)/*539.35*/{_display_(Seq[Any](format.raw/*539.36*/("""
							"""),_display_(Seq[Any](/*540.9*/if(pago.expediente.emergencia)/*540.39*/{_display_(Seq[Any](format.raw/*540.40*/("""
								<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
							""")))})),format.raw/*542.9*/("""
						""")))})),format.raw/*543.8*/("""
					</td>
					<td class="fecha">"""),_display_(Seq[Any](/*545.25*/if(pago.fecha_pago != null)/*545.52*/{_display_(Seq[Any](_display_(Seq[Any](/*545.54*/(utils.DateUtils.formatDate(pago.fecha_pago))))))})),format.raw/*545.100*/("""</td>
					
					<td class="fechaConciliado">"""),_display_(Seq[Any](/*547.35*/if(pago.fecha_conciliacion != null)/*547.70*/{_display_(Seq[Any](_display_(Seq[Any](/*547.72*/(utils.DateUtils.formatDate(pago.fecha_conciliacion))))))})),format.raw/*547.126*/("""</td> 
					<td>"""),_display_(Seq[Any](/*548.11*/if(pago.factura != null && pago.factura.proveedor != null && pago.tipo == "impuestos")/*548.97*/ {_display_(Seq[Any](_display_(Seq[Any](/*548.100*/(pago.factura.proveedor.nombre)))))})),format.raw/*548.132*/("""</td>
					
					<td class="referencia">"""),_display_(Seq[Any](/*550.30*/(pago.referencia))),format.raw/*550.47*/("""</td>
					<td>"""),_display_(Seq[Any](/*551.11*/(pago.proveedor.nombre))),format.raw/*551.34*/("""</td>
					<td class="cuentaPropia">"""),_display_(Seq[Any](/*552.32*/if(pago.cuentaPropia != null)/*552.61*/ {_display_(Seq[Any](_display_(Seq[Any](/*552.64*/pago/*552.68*/.cuentaPropia.nombre))))})),format.raw/*552.89*/("""</td>
					<td class="tipoPago">
						"""),_display_(Seq[Any](/*554.8*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("cheque") == 0)/*554.77*/{_display_(Seq[Any](format.raw/*554.78*/("""cheque""")))})),format.raw/*554.85*/(""" 
						"""),_display_(Seq[Any](/*555.8*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferencia") == 0)/*555.84*/{_display_(Seq[Any](format.raw/*555.85*/("""MacroOnline""")))})),format.raw/*555.97*/(""" 
						"""),_display_(Seq[Any](/*556.8*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferenciaInterbanking") == 0)/*556.96*/{_display_(Seq[Any](format.raw/*556.97*/("""Interbanking""")))})),format.raw/*556.110*/("""
						"""),_display_(Seq[Any](/*557.8*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("transferenciaMacroProveedores") == 0)/*557.100*/{_display_(Seq[Any](format.raw/*557.101*/("""MacroProveedores""")))})),format.raw/*557.118*/("""
						"""),_display_(Seq[Any](/*558.8*/if(pago.tipo_pago != null && pago.tipo_pago.compareTo("debito") == 0)/*558.77*/{_display_(Seq[Any](format.raw/*558.78*/("""Debito""")))})),format.raw/*558.85*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*560.11*/if(pago.ordenPago != null)/*560.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*560.40*/pago/*560.44*/.ordenPago.getNombreCompleto()))))})),format.raw/*560.75*/("""</td>
					<td>"""),_display_(Seq[Any](/*561.11*/if(pago.tipoCuenta != null)/*561.38*/{_display_(Seq[Any](_display_(Seq[Any](/*561.40*/pago/*561.44*/.tipoCuenta.nombre))))})),format.raw/*561.63*/("""</td>
					<td>"""),_display_(Seq[Any](/*562.11*/if(pago.expediente != null)/*562.38*/ {_display_(Seq[Any](_display_(Seq[Any](/*562.41*/pago/*562.45*/.expediente.getExpedienteEjercicio()))))})),format.raw/*562.82*/("""</td>
					<td>"""),_display_(Seq[Any](/*563.11*/if(pago.periodo != null)/*563.35*/ {_display_(Seq[Any](_display_(Seq[Any](/*563.38*/pago/*563.42*/.periodo.nombre))))})),format.raw/*563.58*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*564.30*/pago/*564.34*/.total)),format.raw/*564.40*/("""">"""),_display_(Seq[Any](/*564.43*/(utils.NumberUtils.moneda(pago.total)))),format.raw/*564.81*/("""</td>
					<td class="totalCredito" rel=""""),_display_(Seq[Any](/*565.37*/pago/*565.41*/.total_credito)),format.raw/*565.55*/("""">"""),_display_(Seq[Any](/*565.58*/(utils.NumberUtils.moneda(pago.total_credito)))),format.raw/*565.104*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*566.26*/(pago.estado.nombre))),format.raw/*566.46*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion"  href=""""),_display_(Seq[Any](/*568.82*/controllers/*568.93*/.contabilidad.routes.PagosController.eliminar(pago.id))),format.raw/*568.147*/("""&"""),_display_(Seq[Any](/*568.149*/UriTrack/*568.157*/.encode())),format.raw/*568.166*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*573.15*/("""
	        </tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="14">Mostrando """),_display_(Seq[Any](/*577.40*/buscador/*577.48*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*577.80*/(""" resultado(s).</td>
	        		<td><b>Total Debito:</b> <span class="totalFooter"></span></td>
	        		<td><b>Total Credito:</b> <span class="totalCreditoFooter"></span></td>
	        		<td colspan="2">&nbsp</td>
	        	</tr>
	        </tfoot>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*586.8*/views/*586.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.PagosController.index()))),format.raw/*586.103*/("""
		</div>
	</div>	
	</div>	
<script>
$( function ()"""),format.raw/*591.15*/("""{"""),format.raw/*591.16*/("""
	
	
	
	if($("#proveedor_factura").length)"""),format.raw/*595.36*/("""{"""),format.raw/*595.37*/("""
		var options = """),format.raw/*596.17*/("""{"""),format.raw/*596.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*602.30*/("""{"""),format.raw/*602.31*/(""" 
											$("#proveedor_factura_id").val(obj.id); 
										 """),format.raw/*604.12*/("""}"""),format.raw/*604.13*/("""
			"""),format.raw/*605.4*/("""}"""),format.raw/*605.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor_factura', options);
	"""),format.raw/*607.2*/("""}"""),format.raw/*607.3*/("""
	
	
	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*611.36*/("""{"""),format.raw/*611.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*613.2*/("""}"""),format.raw/*613.3*/(""")
	
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$(".totalCredito").each(function (index) """),format.raw/*617.43*/("""{"""),format.raw/*617.44*/("""
		b = Number($(this).attr("rel"))+b 
	"""),format.raw/*619.2*/("""}"""),format.raw/*619.3*/(""")
	
	$(".totalCreditoFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*623.36*/("""{"""),format.raw/*623.37*/("""
			selectAll();
	"""),format.raw/*625.2*/("""}"""),format.raw/*625.3*/(""");
	$( "input[name='id_pago[]']" ).click(function() """),format.raw/*626.50*/("""{"""),format.raw/*626.51*/("""
		selectTrList();
	"""),format.raw/*628.2*/("""}"""),format.raw/*628.3*/(""");
"""),format.raw/*629.1*/("""}"""),format.raw/*629.2*/(""");		

function selectTrList()"""),format.raw/*631.24*/("""{"""),format.raw/*631.25*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*633.36*/("""{"""),format.raw/*633.37*/("""
		if($(this).parent().find("input[name='id_pago[]']").prop("checked"))"""),format.raw/*634.71*/("""{"""),format.raw/*634.72*/("""
			a = Number($(this).attr("rel"))+a
		"""),format.raw/*636.3*/("""}"""),format.raw/*636.4*/("""
	"""),format.raw/*637.2*/("""}"""),format.raw/*637.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$(".totalCredito").each(function (index) """),format.raw/*641.43*/("""{"""),format.raw/*641.44*/("""
		if($(this).parent().find("input[name='id_pago[]']").prop("checked"))"""),format.raw/*642.71*/("""{"""),format.raw/*642.72*/("""
			b = Number($(this).attr("rel"))+b
		"""),format.raw/*644.3*/("""}"""),format.raw/*644.4*/("""
	"""),format.raw/*645.2*/("""}"""),format.raw/*645.3*/(""")
	$(".totalCreditoFooter").empty();
	$(".totalCreditoFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
"""),format.raw/*648.1*/("""}"""),format.raw/*648.2*/("""

function selectAll()"""),format.raw/*650.21*/("""{"""),format.raw/*650.22*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	if($("#checkAll").prop("checked"))"""),format.raw/*652.36*/("""{"""),format.raw/*652.37*/("""
		$("input[name='id_pago[]']").prop( "checked", true );
		
	"""),format.raw/*655.2*/("""}"""),format.raw/*655.3*/("""else"""),format.raw/*655.7*/("""{"""),format.raw/*655.8*/("""
		$( "input[name='id_pago[]']").prop( "checked", false );
	"""),format.raw/*657.2*/("""}"""),format.raw/*657.3*/("""
	
	$(".total").each(function (index) """),format.raw/*659.36*/("""{"""),format.raw/*659.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*661.2*/("""}"""),format.raw/*661.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$(".totalCredito").each(function (index) """),format.raw/*665.43*/("""{"""),format.raw/*665.44*/("""
		b= Number($(this).attr("rel"))+b
	"""),format.raw/*667.2*/("""}"""),format.raw/*667.3*/(""")
	$(".totalCreditoFooter").empty();
	$(".totalCreditoFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
"""),format.raw/*670.1*/("""}"""),format.raw/*670.2*/("""


</script>
 	 """)))})),format.raw/*674.5*/("""
""")))})),format.raw/*675.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Pago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Pago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/indexPagoProveedor.scala.html
                    HASH: 33a9ebdb9c237d02d9aa8605a6f1e2ef1890782d
                    MATRIX: 845->1|1048->201|1062->208|1146->212|1197->228|1211->234|1279->281|1346->130|1378->154|1435->319|1457->333|1810->73|1838->198|1866->317|1894->656|1933->660|1946->665|2014->724|2054->726|2587->1224|2642->1270|2682->1272|2787->1341|2807->1352|2902->1424|2978->1469|3074->1529|3094->1540|3178->1601|3309->1696|3329->1707|3427->1782|3557->1876|3577->1887|3666->1953|3798->2049|3818->2060|3905->2124|4038->2221|4058->2232|4148->2299|4318->2432|4339->2443|4434->2515|4618->2662|4639->2673|4734->2745|4918->2892|4939->2903|5034->2975|5233->3137|5254->3148|5349->3220|5513->3348|5533->3359|5627->3430|5784->3551|5804->3562|5893->3628|6062->3761|6082->3772|6176->3843|6309->3940|6329->3951|6411->4010|6820->4384|6880->4435|6920->4437|7018->4499|7038->4510|7127->4576|7193->4611|7250->4633|7315->4689|7355->4691|7459->4759|7479->4770|7573->4841|7644->4881|7696->4898|7758->4951|7798->4953|7899->5018|7919->5029|8010->5097|8080->5136|8132->5153|8202->5214|8242->5216|8350->5288|8370->5299|8469->5375|8549->5424|8595->5434|8666->5496|8706->5498|8815->5571|8835->5582|8935->5659|9013->5706|9065->5723|9121->5770|9161->5772|9267->5842|9287->5853|9383->5926|9452->5964|9496->5973|9548->6016|9588->6018|9690->6084|9710->6095|9802->6164|9872->6203|9918->6213|9974->6260|10014->6262|10120->6332|10140->6343|10236->6416|10310->6459|10364->6477|10423->6527|10463->6529|10569->6598|10590->6609|10687->6682|10758->6721|10845->6772|10893->6810|10934->6812|11030->6871|11051->6882|11139->6946|11204->6979|11250->6989|11309->7038|11350->7040|11440->7093|11461->7104|11549->7168|11636->7223|11681->7232|11735->7276|11776->7278|11873->7338|11894->7349|11979->7410|12064->7463|12109->7472|12169->7522|12210->7524|12317->7594|12338->7605|12438->7681|12527->7738|12580->7755|12640->7805|12681->7807|12780->7869|12801->7880|12890->7945|12968->7991|13013->8000|13073->8050|13114->8052|13221->8122|13242->8133|13339->8206|13414->8249|13467->8266|13531->8320|13572->8322|13703->8416|13724->8427|13828->8507|13910->8557|13963->8574|14027->8628|14068->8630|14191->8716|14212->8727|14316->8807|14399->8858|14567->8989|14622->9034|14663->9036|14824->9160|14846->9171|14935->9236|15043->9311|15092->9323|15149->9370|15190->9372|15355->9500|15377->9511|15468->9578|15589->9666|15638->9678|15694->9724|15735->9726|15899->9853|15921->9864|16011->9930|16121->10007|16208->10057|16229->10068|16294->10110|16496->10276|16510->10281|16558->10306|16937->10648|17019->10707|17231->10882|17313->10941|17537->11128|17619->11187|17825->11356|17907->11415|18121->11592|18203->11651|18421->11833|18583->11971|18627->11979|18789->12117|18977->12269|19063->12332|19256->12489|19382->12591|19427->12600|19533->12683|19756->12869|19777->12880|19851->12931|20268->13311|20322->13355|20363->13357|20406->13367|20551->13476|20659->13561|20704->13570|20805->13648|21022->13828|21043->13839|21119->13892|21579->14316|21707->14420|21752->14429|21860->14514|22083->14700|22104->14711|22181->14765|22617->15165|22800->15324|23006->15494|23245->15710|23288->15717|23517->15923|23735->16105|23848->16195|23892->16203|23998->16286|24218->16469|24239->16480|24319->16537|24781->16963|24941->17099|24985->17107|25145->17243|25300->17362|25607->17645|25786->17788|25923->17901|25968->17910|26086->18004|26306->18187|26327->18198|26402->18250|26882->18694|27024->18812|27069->18821|27192->18920|27415->19106|27436->19117|27510->19168|27964->19586|28283->19881|28460->20022|28644->20182|28688->20190|28872->20350|29073->20515|29197->20615|29263->20645|29454->20812|29655->20977|29711->21010|29909->21172|30087->21326|30131->21334|30309->21488|30450->21593|30745->21864|30934->22017|31057->22116|31247->22270|31478->22478|31630->22594|31751->22691|31954->22857|32005->22885|32182->23026|32311->23131|32767->23550|32788->23561|32855->23605|33042->23756|33086->23790|33127->23792|33256->23903|33270->23908|33310->23909|33509->24071|33527->24079|33582->24111|34466->24959|34512->24988|34553->24990|34616->25016|34666->25043|34719->25059|34733->25063|34766->25073|34817->25087|34839->25098|34912->25147|34952->25149|34971->25157|35004->25166|35102->25227|35116->25231|35142->25234|35213->25268|35228->25272|35255->25275|35392->25375|35413->25386|35489->25438|35529->25440|35548->25448|35581->25457|35705->25544|35741->25557|35785->25565|35822->25592|35862->25593|35907->25602|35947->25632|35987->25633|36113->25727|36153->25735|36226->25771|36263->25798|36312->25800|36386->25846|36469->25892|36514->25927|36563->25929|36645->25983|36699->26000|36795->26086|36846->26089|36906->26121|36984->26162|37024->26179|37077->26195|37123->26218|37197->26255|37236->26284|37286->26287|37300->26291|37348->26312|37424->26352|37503->26421|37543->26422|37583->26429|37628->26438|37714->26514|37754->26515|37799->26527|37844->26536|37942->26624|37982->26625|38029->26638|38073->26646|38176->26738|38217->26739|38268->26756|38312->26764|38391->26833|38431->26834|38471->26841|38530->26863|38566->26889|38616->26892|38630->26896|38688->26927|38741->26943|38778->26970|38827->26972|38841->26976|38887->26995|38940->27011|38977->27038|39027->27041|39041->27045|39105->27082|39158->27098|39192->27122|39242->27125|39256->27129|39299->27145|39371->27180|39385->27184|39414->27190|39454->27193|39515->27231|39594->27273|39608->27277|39645->27291|39685->27294|39755->27340|39823->27371|39866->27391|40000->27488|40021->27499|40099->27553|40139->27555|40158->27563|40191->27572|40337->27685|40465->27776|40483->27784|40538->27816|40889->28131|40904->28136|41018->28226|41098->28277|41128->28278|41199->28320|41229->28321|41275->28338|41305->28339|41470->28475|41500->28476|41594->28541|41624->28542|41656->28546|41685->28547|41783->28617|41812->28618|41923->28700|41953->28701|42020->28740|42049->28741|42198->28861|42228->28862|42295->28901|42324->28902|42473->29022|42503->29023|42549->29041|42578->29042|42659->29094|42689->29095|42737->29115|42766->29116|42797->29119|42826->29120|42884->29149|42914->29150|43021->29228|43051->29229|43151->29300|43181->29301|43249->29341|43278->29342|43308->29344|43337->29345|43512->29491|43542->29492|43642->29563|43672->29564|43740->29604|43769->29605|43799->29607|43828->29608|43972->29724|44001->29725|44052->29747|44082->29748|44189->29826|44219->29827|44308->29888|44337->29889|44369->29893|44398->29894|44486->29954|44515->29955|44582->29993|44612->29994|44679->30033|44708->30034|44883->30180|44913->30181|44978->30218|45007->30219|45151->30335|45180->30336|45229->30353|45263->30355
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->9|37->9|51->1|52->5|53->8|54->22|57->25|57->25|57->25|57->25|74->42|74->42|74->42|75->43|75->43|75->43|76->44|77->45|77->45|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|80->48|80->48|81->49|81->49|81->49|82->50|82->50|82->50|83->51|83->51|83->51|84->52|84->52|84->52|86->54|86->54|86->54|89->57|89->57|89->57|90->58|90->58|90->58|92->60|92->60|92->60|93->61|93->61|93->61|102->70|102->70|102->70|103->71|103->71|103->71|104->72|106->74|106->74|106->74|107->75|107->75|107->75|108->76|110->78|110->78|110->78|111->79|111->79|111->79|112->80|114->82|114->82|114->82|115->83|115->83|115->83|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|121->89|121->89|121->89|122->90|122->90|122->90|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|131->99|131->99|131->99|132->100|132->100|132->100|133->101|136->104|136->104|136->104|137->105|137->105|137->105|138->106|139->107|139->107|139->107|140->108|140->108|140->108|141->109|142->110|142->110|142->110|143->111|143->111|143->111|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|149->117|149->117|149->117|150->118|150->118|150->118|151->119|152->120|152->120|152->120|153->121|153->121|153->121|154->122|156->124|156->124|156->124|158->126|158->126|158->126|159->127|161->129|161->129|161->129|163->131|163->131|163->131|164->132|168->136|168->136|168->136|170->138|170->138|170->138|174->142|175->143|175->143|175->143|177->145|177->145|177->145|181->149|182->150|182->150|182->150|184->152|184->152|184->152|188->156|192->160|192->160|192->160|200->168|200->168|200->168|209->177|209->177|213->181|213->181|217->185|217->185|221->189|221->189|225->193|225->193|234->202|234->202|235->203|235->203|242->210|242->210|250->218|250->218|251->219|251->219|256->224|256->224|256->224|271->239|271->239|271->239|271->239|274->242|274->242|275->243|275->243|280->248|280->248|280->248|297->265|297->265|298->266|298->266|303->271|303->271|303->271|318->286|318->286|326->294|330->298|331->299|334->302|342->310|342->310|343->311|343->311|348->316|348->316|348->316|364->332|364->332|365->333|365->333|371->339|371->339|377->345|377->345|378->346|378->346|383->351|383->351|383->351|398->366|398->366|399->367|399->367|404->372|404->372|404->372|418->386|418->386|424->392|424->392|425->393|425->393|435->403|435->403|437->405|438->406|446->414|446->414|453->421|453->421|454->422|454->422|459->427|459->427|468->436|468->436|474->442|476->444|482->450|482->450|489->457|489->457|496->464|496->464|512->480|512->480|512->480|521->489|521->489|521->489|527->495|527->495|527->495|532->500|532->500|532->500|562->530|562->530|562->530|563->531|563->531|563->531|563->531|563->531|563->531|563->531|563->531|563->531|563->531|563->531|564->532|564->532|564->532|564->532|564->532|564->532|566->534|566->534|566->534|566->534|566->534|566->534|570->538|570->538|571->539|571->539|571->539|572->540|572->540|572->540|574->542|575->543|577->545|577->545|577->545|577->545|579->547|579->547|579->547|579->547|580->548|580->548|580->548|580->548|582->550|582->550|583->551|583->551|584->552|584->552|584->552|584->552|584->552|586->554|586->554|586->554|586->554|587->555|587->555|587->555|587->555|588->556|588->556|588->556|588->556|589->557|589->557|589->557|589->557|590->558|590->558|590->558|590->558|592->560|592->560|592->560|592->560|592->560|593->561|593->561|593->561|593->561|593->561|594->562|594->562|594->562|594->562|594->562|595->563|595->563|595->563|595->563|595->563|596->564|596->564|596->564|596->564|596->564|597->565|597->565|597->565|597->565|597->565|598->566|598->566|600->568|600->568|600->568|600->568|600->568|600->568|605->573|609->577|609->577|609->577|618->586|618->586|618->586|623->591|623->591|627->595|627->595|628->596|628->596|634->602|634->602|636->604|636->604|637->605|637->605|639->607|639->607|643->611|643->611|645->613|645->613|649->617|649->617|651->619|651->619|655->623|655->623|657->625|657->625|658->626|658->626|660->628|660->628|661->629|661->629|663->631|663->631|665->633|665->633|666->634|666->634|668->636|668->636|669->637|669->637|673->641|673->641|674->642|674->642|676->644|676->644|677->645|677->645|680->648|680->648|682->650|682->650|684->652|684->652|687->655|687->655|687->655|687->655|689->657|689->657|691->659|691->659|693->661|693->661|697->665|697->665|699->667|699->667|702->670|702->670|706->674|707->675
                    -- GENERATED --
                */
            