
package views.html.contabilidad.facturas

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
object indexFacturaProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Factura],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Factura], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/facturas.js"))),format.raw/*7.72*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Factura) = {{
	var classEstado:String = new String()
	var saldoPendiente:BigDecimal = i.getSaldoPendiente()
	var base:BigDecimal = i.getBase()
	
	
	if(!saldoPendiente.equals(base) && i.estado != null && i.estado_id == 19){
		classEstado = "pagado"
	}else{
		if(i.estado != null && (i.estado.id == 18 || i.estado.id == 60) ){
			classEstado = "borrador"
		}else if(i.estado != null && i.estado.id == 21){
			classEstado = "cancelada"
		}else if(i.estado != null && i.estado.id == 19){
			classEstado = "autorizado"
		}
	}
	classEstado
}};def /*30.2*/getClassRechazado/*30.19*/(i:Factura) = {{
	var classEstado:String = new String()
	if(i.rechazado != null && i.rechazado){
		classEstado = "bg-rechazado"
	}
	
	classEstado
}};def /*39.2*/getMotivosRechazos/*39.20*/(i:Factura) = {{
	var motivos = new String()
	if(i.rechazado != null && i.rechazado){
		for(r <- i.facturaRechazo){
			if(r.factura_motivo_rechazo_id != null){
				motivos += "- "+r.facturaMotivoRechazo.descripcion+"<br>"
			}else{
				motivos += "- "+r.otro+"<br>" 
			}
			 
		}
	}
	
	motivos
}};def /*55.2*/getClassPorcentajePagado/*55.26*/(i:Factura) = {{
	
	var cien:java.math.BigDecimal = new java.math.BigDecimal(100)
	var porcentaje:java.math.BigDecimal = new java.math.BigDecimal(0)
	var cero:java.math.BigDecimal = new java.math.BigDecimal(0)
	var saldoPendiente:java.math.BigDecimal = i.getSaldoPendiente()
	var base:java.math.BigDecimal = i.base
	if(i.base.compareTo(java.math.BigDecimal.ZERO) > 0){
		if(i.estado != null && i.estado.id == 19){
			if(saldoPendiente.compareTo(java.math.BigDecimal.ZERO) != 0 && base.compareTo(java.math.BigDecimal.ZERO) != 0){
				porcentaje = (base.subtract(saldoPendiente)).multiply(cien).divide(i.base, 2, java.math.RoundingMode.HALF_UP)
			}else{
				porcentaje = new java.math.BigDecimal(0)
			}
			porcentaje = (base.subtract(saldoPendiente)).multiply(cien).divide(i.base, 2, java.math.RoundingMode.HALF_UP)
		}
	}
	porcentaje
}};
Seq[Any](format.raw/*1.126*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*37.2*/("""

"""),format.raw/*53.2*/("""

"""),format.raw/*73.2*/("""

"""),_display_(Seq[Any](/*75.2*/views/*75.7*/.html.contabilidad.mainContabilidad("Lista de facturas", scripts)/*75.72*/ {_display_(Seq[Any](format.raw/*75.74*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Lista de facturas</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"> <i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span></button>

				<ul class="dropdown-menu">
					<li><a id="reporteOrdenDePago"  href="#" data-url=""""),_display_(Seq[Any](/*85.58*/controllers/*85.69*/.contabilidad.routes.FacturasReportesController.ordenDePago())),format.raw/*85.130*/("""">Orden de Pago</a></li>
					<li><a id="OPCservicios"  href="#" data-url=""""),_display_(Seq[Any](/*86.52*/controllers/*86.63*/.contabilidad.routes.FacturasReportesController.OPCservicios())),format.raw/*86.125*/("""">OPC servicios</a></li>
					<li><a id="reporteControlFacturas" href="#" data-url=""""),_display_(Seq[Any](/*87.61*/controllers/*87.72*/.contabilidad.routes.FacturasReportesController.reporteControlFacturas())),format.raw/*87.144*/("""">Control Facturas</a></li>
					<li><a id="reporteLineasFacturas" href="#" data-url=""""),_display_(Seq[Any](/*88.60*/controllers/*88.71*/.contabilidad.routes.FacturasReportesController.reporteLineasFacturas())),format.raw/*88.142*/("""">Lineas Facturas</a></li>
					<li><a id="reporteRendicionSellos" href="#" data-url=""""),_display_(Seq[Any](/*89.61*/controllers/*89.72*/.contabilidad.routes.FacturasReportesController.reporteRendicionSellos())),format.raw/*89.144*/("""">Rendicion Sellos</a></li>
					<li><a id="reporteComprobanteRetencionSellos" href="#" data-url=""""),_display_(Seq[Any](/*90.72*/controllers/*90.83*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionSellos())),format.raw/*90.166*/("""">Comprobante Retencion Sellos</a></li>
					<li><a id="reporteRendicioniibb" href="#" data-url=""""),_display_(Seq[Any](/*91.59*/controllers/*91.70*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencioniibb())),format.raw/*91.151*/("""">Comprobante Retencion IIBB</a></li>
					<li><a id="reporteRendicioniibb370" href="#" data-url=""""),_display_(Seq[Any](/*92.62*/controllers/*92.73*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencioniibb370())),format.raw/*92.157*/("""">Comprobante Retencion IIBB 3,70</a></li>
					<li><a id="reporteRendicionSeguridad" href="#" data-url=""""),_display_(Seq[Any](/*93.64*/controllers/*93.75*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionSeguridad())),format.raw/*93.161*/("""">Comprobante Retencion Investigacion y Seguridad</a></li>
					<li><a id="reporteRendicionLimpieza" href="#" data-url=""""),_display_(Seq[Any](/*94.63*/controllers/*94.74*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionLimpieza())),format.raw/*94.159*/("""">Comprobante Retencion Servicio Limpieza</a></li>
					<li><a id="reporteRendicionReggral" href="#" data-url=""""),_display_(Seq[Any](/*95.62*/controllers/*95.73*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionReggral())),format.raw/*95.157*/("""">Comprobante Retencion Regimen Gral de Contribuciones</a></li>				
					<li><a id="reporteInformeSellos" href="#" data-url=""""),_display_(Seq[Any](/*96.59*/controllers/*96.70*/.contabilidad.routes.FacturasReportesController.modalInformeSellos())),format.raw/*96.138*/("""">Informe Mensual Sellos</a></li>
					<li><a id="reporteComprobanteRetencionMunicipal" href="#" data-url=""""),_display_(Seq[Any](/*97.75*/controllers/*97.86*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionMunicipal())),format.raw/*97.172*/("""">Comprobante Retencion Municipal</a></li>
					<li><a id="reporteComprobanteRetencionGcia" href="#" data-url=""""),_display_(Seq[Any](/*98.70*/controllers/*98.81*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionGcia())),format.raw/*98.162*/("""">Comprobante Retencion Ganancias 4245</a></li>
					<li><a id="reporteComprobanteRetencionIva" href="#" data-url=""""),_display_(Seq[Any](/*99.69*/controllers/*99.80*/.contabilidad.routes.FacturasReportesController.reporteComprobanteRetencionIva())),format.raw/*99.160*/("""">Comprobante Retencion IVA</a></li>
					<li><a id="reporteControlFacturasAFIP" href="#" data-url=""""),_display_(Seq[Any](/*100.65*/controllers/*100.76*/.contabilidad.routes.FacturasReportesController.reporteControlFacturasAFIP())),format.raw/*100.152*/("""">Control Facturas AFIP</a></li>
					
					<li><a id="reporteComisiones" href="#" data-url=""""),_display_(Seq[Any](/*102.56*/controllers/*102.67*/.contabilidad.routes.FacturasReportesController.reporteComisiones())),format.raw/*102.134*/("""">Reporte Comisiones</a></li>
					<li><a id="reporteViatico"  href="#" data-url=""""),_display_(Seq[Any](/*103.54*/controllers/*103.65*/.contabilidad.routes.FacturasReportesController.viatico())),format.raw/*103.122*/("""">Viaticos</a></li>
				
				
				</ul>

			</div>
			<div class="dropdown pull-right btn-header">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
				<ul class="dropdown-menu">
				"""),_display_(Seq[Any](/*112.6*/if(Permiso.check("facturasSolicitud322"))/*112.47*/ {_display_(Seq[Any](format.raw/*112.49*/("""
			  		<li><a id="accionSolicitud322" href="#" data-url=""""),_display_(Seq[Any](/*113.59*/controllers/*113.70*/.contabilidad.routes.FacturasAccionesController.solicitud322())),format.raw/*113.132*/(""""> Solicitud 322</a></li>
			  	""")))})),format.raw/*114.8*/("""
				<li role="presentation" class="dropdown-header">Acciones Masivas</li> 
				"""),_display_(Seq[Any](/*116.6*/if(Permiso.check("facturasPasarEstadoPreCurso"))/*116.54*/ {_display_(Seq[Any](format.raw/*116.56*/("""  	
				  	<li role="presentation"><a role="menuitem" id="accionPasarEnPreCurso" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*117.112*/controllers/*117.123*/.contabilidad.routes.FacturasAccionesController.modalPasarEnPreCurso())),format.raw/*117.193*/("""">Pasar a En PreCurso</a></li>
				""")))})),format.raw/*118.6*/("""  	
				"""),_display_(Seq[Any](/*119.6*/if(Permiso.check("facturasPasarEstadoCurso"))/*119.51*/ {_display_(Seq[Any](format.raw/*119.53*/("""  	
				  	<li role="presentation"><a role="menuitem" id="accionPasarEnCurso" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*120.109*/controllers/*120.120*/.contabilidad.routes.FacturasAccionesController.modalPasarEnCurso())),format.raw/*120.187*/("""">Pasar a En Curso</a></li>
				""")))})),format.raw/*121.6*/("""    
				"""),_display_(Seq[Any](/*122.6*/if(Permiso.check("facturasPasarEstadoPreAprobado"))/*122.57*/ {_display_(Seq[Any](format.raw/*122.59*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarPreAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*123.114*/controllers/*123.125*/.contabilidad.routes.FacturasAccionesController.modalPasarPreAprobado())),format.raw/*123.196*/("""">Pasar a Preaprobado</a></li>	
				""")))})),format.raw/*124.6*/("""    
				"""),_display_(Seq[Any](/*125.6*/if(Permiso.check("facturasPasarEstadoAprobado"))/*125.54*/ {_display_(Seq[Any](format.raw/*125.56*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*126.111*/controllers/*126.122*/.contabilidad.routes.FacturasAccionesController.modalPasarAprobado())),format.raw/*126.190*/("""">Pasar a Aprobado</a></li>	
				""")))})),format.raw/*127.6*/("""    
				"""),_display_(Seq[Any](/*128.6*/if(Permiso.check("facturasPasaarBorrador"))/*128.49*/ {_display_(Seq[Any](format.raw/*128.51*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*129.111*/controllers/*129.122*/.contabilidad.routes.FacturasAccionesController.modalPasarBorrador())),format.raw/*129.190*/("""">Pasar a Borrador</a></li>
				""")))})),format.raw/*130.6*/("""    
				"""),_display_(Seq[Any](/*131.6*/if(Permiso.check("facturasPasarEstadoCancelado"))/*131.55*/ {_display_(Seq[Any](format.raw/*131.57*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*132.112*/controllers/*132.123*/.contabilidad.routes.FacturasAccionesController.modalPasarCancelado())),format.raw/*132.192*/("""">Pasar a Cancelado</a></li>
				""")))})),format.raw/*133.6*/("""    
			    """),_display_(Seq[Any](/*134.9*/if(Permiso.check("facturasCargarOrdenPagoMasiva"))/*134.59*/ {_display_(Seq[Any](format.raw/*134.61*/("""
			    	<li role="presentation"><a role="menuitem" id="accionCargarOrdenPago" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*135.113*/controllers/*135.124*/.contabilidad.routes.FacturasAccionesController.modalCargarOrdenPago())),format.raw/*135.194*/("""">Cargar Orden de pago</a></li>
			    """)))})),format.raw/*136.9*/("""
			    """),_display_(Seq[Any](/*137.9*/if(Permiso.check("facturasFechaOrdenPagoMasiva"))/*137.58*/ {_display_(Seq[Any](format.raw/*137.60*/("""
			    	<li role="presentation"><a role="menuitem" id="accionCargarFechaOrdenPago" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*138.118*/controllers/*138.129*/.contabilidad.routes.FacturasAccionesController.modalCargarFechaOrdenPago())),format.raw/*138.204*/("""">Cargar Fecha Orden de pago</a></li>
			    """)))})),format.raw/*139.9*/("""  
			    """),_display_(Seq[Any](/*140.9*/if(Permiso.check("facturasFecha322Masiva"))/*140.52*/ {_display_(Seq[Any](format.raw/*140.54*/("""
			    	<li role="presentation"><a role="menuitem" id="accionCargarFecha322" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*141.112*/controllers/*141.123*/.contabilidad.routes.FacturasAccionesController.modalCargarFecha322())),format.raw/*141.192*/("""">Cargar Fecha Venc. 322</a></li>
			    """)))})),format.raw/*142.9*/("""  
			    """),_display_(Seq[Any](/*143.9*/if(Permiso.check("marcadoresMasivos"))/*143.47*/ {_display_(Seq[Any](format.raw/*143.49*/("""
			    	<li role="presentation"><a role="menuitem" id="accionMarcadoresMasivos" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*144.115*/controllers/*144.126*/.contabilidad.routes.FacturasAccionesController.modalMarcadoresMasivos())),format.raw/*144.198*/("""">Cargar Marcadores</a></li>
			    """)))})),format.raw/*145.9*/("""  
			    """),_display_(Seq[Any](/*146.9*/if(Permiso.check("facturasFechaOrdenPagoMasiva"))/*146.58*/ {_display_(Seq[Any](format.raw/*146.60*/("""
			    	<li role="presentation"><a role="menuitem" id="accionCargarNumeroFacturaParcial" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*147.124*/controllers/*147.135*/.contabilidad.routes.FacturasAccionesController.modalCargarNumeroFacturaParcial())),format.raw/*147.216*/("""">Cargar N° Factura Parciales</a></li>
			    """)))})),format.raw/*148.9*/("""  
			    </ul>
			</div>
			<div class="pull-right btn-header">
				<a href=""""),_display_(Seq[Any](/*152.15*/controllers/*152.26*/.contabilidad.routes.FacturasController.crear())),format.raw/*152.73*/("""?"""),_display_(Seq[Any](/*152.75*/UriTrack/*152.83*/.encode())),format.raw/*152.92*/(""""  class="btn btn-default pull-right"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Factura</a>
			</div>
</div>
	</div>
</div>
	
	"""),_display_(Seq[Any](/*158.3*/views/*158.8*/.html.tags.successError())),format.raw/*158.33*/("""
	
	
	<div id="actions">
		<form action="" id="formSearchFacturas" method="GET">
			<div class="row" >
				<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
					<div class="btn-group">
					  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
					  	"""),_display_(Seq[Any](/*168.10*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*168.69*/("""
					  </button>
					  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>En PreCurso
					  	"""),_display_(Seq[Any](/*172.10*/checkbox(formBuscador("btnFiltro[9]"), 'hidden -> "hidden"))),format.raw/*172.69*/("""
					  </button>
					  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>En curso
					  	"""),_display_(Seq[Any](/*176.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*176.69*/("""
					  </button>
					  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>PreAprobada
					  	"""),_display_(Seq[Any](/*180.10*/checkbox(formBuscador("btnFiltro[7]"), 'hidden -> "hidden"))),format.raw/*180.69*/("""
					  </button>
					  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-ok"></i><br>Aprobada
					  	"""),_display_(Seq[Any](/*184.10*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*184.69*/("""
					  </button>
					  <button type="button" rel="pagada" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-usd glyphicon-usd-green"></i><br>Pagada
					  	"""),_display_(Seq[Any](/*188.10*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*188.69*/("""
					  </button>
					  <button type="button" rel="pagada" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-registration-mark colorRojoSmall"></i><br>Rechazada
					  	"""),_display_(Seq[Any](/*192.10*/checkbox(formBuscador("btnFiltro[8]"), 'hidden -> "hidden"))),format.raw/*192.69*/("""
					  </button>
					  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelada
					  	"""),_display_(Seq[Any](/*196.10*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*196.69*/("""
					  </button>
					</div>
					<div class="btn-group">
					  <button type="button" rel="debedgr" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-down glyphicon-arrow-down-dgr"></i><br>Debe DGR
					  	"""),_display_(Seq[Any](/*202.10*/checkbox(formBuscador("btnFiltro[5]"), 'hidden -> "hidden"))),format.raw/*202.69*/("""
					  </button>
					  <button type="button" rel="debeafip" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-down glyphicon-arrow-down-afip"></i><br>Debe AFIP
					  	"""),_display_(Seq[Any](/*206.10*/checkbox(formBuscador("btnFiltro[6]"), 'hidden -> "hidden"))),format.raw/*206.69*/("""
					  </button>
					</div>
				</div>
			
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="referencia" class="control-label">Número
							"""),_display_(Seq[Any](/*215.9*/inputText(formBuscador("numero_factura"), 'class -> "form-control"))),format.raw/*215.76*/("""
						</label>
					</div>
				</div>
				
			</div>
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="referencia" class="control-label">Referencia
							"""),_display_(Seq[Any](/*225.9*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*225.72*/("""
						</label>
					</div>
				</div>

				<div class="col-sm-2">
					<label class="control-label">Contraparte
						<div class="input-group">
							"""),_display_(Seq[Any](/*233.9*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*233.111*/("""
							"""),_display_(Seq[Any](/*234.9*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*234.92*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*239.23*/controllers/*239.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*239.85*/("""" 
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
				<!-- <div class="col-sm-2">
					<label class="control-label">Responsable
						<div class="input-group">
							"""),_display_(Seq[Any](/*254.9*/inputText(formBuscador("create_usuario.nombre"), 'name -> "", 'class -> "form-control", 'id -> "create_usuario"))),format.raw/*254.121*/("""
							"""),_display_(Seq[Any](/*255.9*/inputText(formBuscador("create_usuario.id"), 'hidden -> "hidden", 'id -> "create_usuario_id"))),format.raw/*255.102*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchResponsable" 
											data-title="Selección de responsables" 
											data-url=""""),_display_(Seq[Any](/*260.23*/controllers/*260.34*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*260.89*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.usuario.simple" 
											data-label="#create_usuario" 
											data-field="#create_usuario_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
							
						</div>
					</label>
				</div> -->	
				<div class="col-sm-2">
					<label class="control-label">Expediente</label>
						<div class="input-group">
							"""),_display_(Seq[Any](/*276.9*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*276.113*/("""
							"""),_display_(Seq[Any](/*277.9*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*277.94*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchExpediente" 
											data-title="Selección de expediente" 
											data-url=""""),_display_(Seq[Any](/*282.23*/controllers/*282.34*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*282.88*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.expediente.simple" 
											data-label="#expediente" 
											data-field="#expediente_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
				</div>

				<div class="col-sm-2">
					<label for="inputPeriodo" class="control-label">Periodo</label> 
					<div class="input-group">
						
						"""),_display_(Seq[Any](/*298.8*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*298.84*/("""
						"""),_display_(Seq[Any](/*299.8*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*299.85*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*304.21*/controllers/*304.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*304.85*/("""" 
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
				<div class="col-sm-2">
					<label class="control-label">Cuenta Impuesto
						<div class="input-group">
							"""),_display_(Seq[Any](/*318.9*/inputText(formBuscador("cuentaImpuesto.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cuenta_impuesto"))),format.raw/*318.122*/("""
							"""),_display_(Seq[Any](/*319.9*/inputText(formBuscador("cuentaImpuesto.id"), 'hidden -> "hidden", 'id -> "cuenta_impuesto_id"))),format.raw/*319.103*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchCuentaModal" 
											data-title="Selección de Cuenta" 
											data-url=""""),_display_(Seq[Any](/*324.23*/controllers/*324.34*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*324.86*/("""" 
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
					<div class="form-group">
						<label for="desc_ret" class="control-label">Desc. Retencion
							"""),_display_(Seq[Any](/*339.9*/inputText(formBuscador("desc_ret"), 'class -> "form-control"))),format.raw/*339.70*/("""
						</label>
					</div>
				</div>
			</div>
			
			<div class="row">		
				<!-- <div class="col-sm-2 input-group">
					<label class="control-label">Orden de Pago N°</label>
					<div>
					"""),_display_(Seq[Any](/*349.7*/inputText(formBuscador("numero_orden_pago_desde"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_desde", 
							  'style -> "width: 71px;font-size:11px;", 
							  'placeholder -> "Desde"))),format.raw/*353.34*/("""
					"""),_display_(Seq[Any](/*354.7*/inputText(formBuscador("numero_orden_pago_hasta"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_hasta", 
							  'style -> "width: 71px;font-size:11px;", 'placeholder -> "Hasta"))),format.raw/*357.75*/("""
					</div>
					
				</div> -->
				<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*364.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*364.98*/("""
						"""),_display_(Seq[Any](/*365.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*365.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOp" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*370.22*/controllers/*370.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*370.90*/("""" 
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
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha OP</label>
					<div>
						"""),_display_(Seq[Any](/*385.8*/inputText(formBuscador("fecha_op_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_op_desde", 'placeholder -> "Desde"))),format.raw/*385.142*/("""
						"""),_display_(Seq[Any](/*386.8*/inputText(formBuscador("fecha_op_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_op_hasta", 'placeholder -> "Hasta"))),format.raw/*386.142*/("""
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Factura</label>
					<div>
						"""),_display_(Seq[Any](/*392.8*/inputText(formBuscador("fecha_factura_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_factura_desde", 'placeholder -> "Desde"))),format.raw/*392.152*/("""
						"""),_display_(Seq[Any](/*393.8*/inputText(formBuscador("fecha_factura_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_factura_hasta", 'placeholder -> "Hasta"))),format.raw/*393.152*/("""
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Aprobacion</label>
					<div>
						"""),_display_(Seq[Any](/*399.8*/inputText(formBuscador("fecha_aprobacion_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_aprobacion_desde", 'placeholder -> "Desde"))),format.raw/*399.158*/("""
						"""),_display_(Seq[Any](/*400.8*/inputText(formBuscador("fecha_aprobacion_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_aprobacion_hasta", 'placeholder -> "Hasta"))),format.raw/*400.158*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Tipo de proveedor
						"""),_display_(Seq[Any](/*405.8*/select(formBuscador("tipo_proveedor"), options(Proveedor.TIPO_INTERNO ->"Agentes", Proveedor.TIPO_EXTERNO->"Proveedores", Proveedor.TIPO_AGENTE_INTERNO ->"Agentes contratados", Proveedor.TIPO_AGENTE_PLANTA->"Agentes en planta"), 'class -> "form-control select", '_default -> "Todos"))),format.raw/*405.291*/("""
					</label>
				</div>
				<div class="col-sm-2">
				
					<div class="checkbox">
						<!-- <label class="control-label"> 
							PROFE
							"""),_display_(Seq[Any](/*413.9*/checkbox(formBuscador("profe")))),format.raw/*413.40*/("""
						</label><br> -->
						 <label class="control-label"> 
							Guardia
							"""),_display_(Seq[Any](/*417.9*/checkbox(formBuscador("guardia")))),format.raw/*417.42*/("""
						</label> 
					</div> 
				</div>
				
				
			</div>
			<div class="row">
				
			</div>
			<div class="row">
			
				<div class="col-sm-2">
					<div class="form-group">
						<label for="referencia" class="control-label">Acta
							"""),_display_(Seq[Any](/*432.9*/inputText(formBuscador("acta"), 'class -> "form-control"))),format.raw/*432.66*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						Tipo Cuenta
						"""),_display_(Seq[Any](/*439.8*/select(formBuscador("tipo_cuenta_id"), 
						TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*440.128*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<label for="deposito" class="control-label">Institucion</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*446.8*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*446.125*/("""
						"""),_display_(Seq[Any](/*447.8*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*447.88*/("""
						<span class="input-group-addon">
		                	<a href="#" id="searchDeposito" class="searchModal" data-title="Selección de Institucion" 
		                	data-url=""""),_display_(Seq[Any](/*450.31*/controllers/*450.42*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*450.94*/("""" 
		                	data-height="650" data-width="700" 
		                	data-listen="modal.seleccion.deposito.simple" 
		                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
		                </span>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						Emergencia
						"""),_display_(Seq[Any](/*460.8*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*460.113*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*472.16*/controllers/*472.27*/.contabilidad.routes.FacturasController.index())),format.raw/*472.74*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
		<form  id="tabla">
		<table id="listaFacturas" class="table table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="6">Mostrando """),_display_(Seq[Any](/*484.39*/buscador/*484.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*484.79*/(""" resultado(s). </td>
			       	<td><b>Total:</b> <span class="totalBaseFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalImpuestosFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalSaldoFooter"></span></td>
	        		<td colspan="5">&nbsp</td>
			    </tr>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="50">#</th>
					<th width="100">Referencia</th>
					<th width="100">Proveedor</th>
					<!-- <th width="100">Referencia</th> -->
					<th width="100">OPG</th>
					<th width="100">N° Factura</th>
					<!-- <th width="100">Representante</th> -->
					<th width="100">Base</th>
					<th width="100">Total impuestos</th>
					<th width="100">Total</th>
					<th width="100">Saldo pendiente</th>
					<th width="100">Expediente</th>
					<th width="100">Periodo</th>
					<th>Tipo Cuenta</th>
					<th width="100">Estado</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*514.5*/for(factura <- buscador.getList) yield /*514.37*/ {_display_(Seq[Any](format.raw/*514.39*/("""
				"""),_display_(Seq[Any](/*515.6*/paginadorFicha/*515.20*/.add(factura.id.toString))),format.raw/*515.45*/("""
				<tr class="pointer """),_display_(Seq[Any](/*516.25*/getClassEstado(factura))),format.raw/*516.48*/(""" """),_display_(Seq[Any](/*516.50*/getClassRechazado(factura))),format.raw/*516.76*/("""" data-estado=""""),_display_(Seq[Any](/*516.92*/factura/*516.99*/.estado_id)),format.raw/*516.109*/("""" data-href=""""),_display_(Seq[Any](/*516.123*/controllers/*516.134*/.contabilidad.routes.FacturasController.ver(factura.id))),format.raw/*516.189*/("""&"""),_display_(Seq[Any](/*516.191*/UriTrack/*516.199*/.encode())),format.raw/*516.208*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*517.64*/factura/*517.71*/.id)),format.raw/*517.74*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*517.108*/factura/*517.115*/.id)),format.raw/*517.118*/(""""/></td>				
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*519.61*/controllers/*519.72*/.contabilidad.routes.FacturasController.editar(factura.id))),format.raw/*519.130*/("""&"""),_display_(Seq[Any](/*519.132*/UriTrack/*519.140*/.encode())),format.raw/*519.149*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a><br>
						"""),_display_(Seq[Any](/*522.8*/if(factura.rechazado != null &&  factura.rechazado)/*522.59*/{_display_(Seq[Any](format.raw/*522.60*/("""	
						 <span class='preview iconRechazado' 
							 data-content=""""),_display_(Seq[Any](/*524.24*/getMotivosRechazos(factura))),format.raw/*524.51*/("""" 
							 data-container="body" 
							 data-toggle="popover" 
							 data-placement="bottom" ><i class="glyphicon glyphicon-registration-mark colorRojo"></i>
						</span>
						
						""")))})),format.raw/*530.8*/(""" 
					</td>
					<td align="center">
						"""),_display_(Seq[Any](/*533.8*/(factura.nombre))),format.raw/*533.24*/(""" """),_display_(Seq[Any](/*533.26*/if(factura.facturaPrincipal != null)/*533.62*/{_display_(Seq[Any](format.raw/*533.63*/("""Parcial <br>de<br> """),_display_(Seq[Any](/*533.83*/(factura.facturaPrincipal.nombre)))))})),format.raw/*533.117*/("""
						"""),_display_(Seq[Any](/*534.8*/if(factura.expediente != null)/*534.38*/{_display_(Seq[Any](format.raw/*534.39*/("""
							"""),_display_(Seq[Any](/*535.9*/if(factura.expediente.emergencia)/*535.42*/{_display_(Seq[Any](format.raw/*535.43*/("""
								<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
							""")))})),format.raw/*537.9*/("""
						""")))})),format.raw/*538.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*540.11*/if(factura.proveedor != null)/*540.40*/{_display_(Seq[Any](_display_(Seq[Any](/*540.42*/(factura.proveedor.nombre)))))})),format.raw/*540.69*/("""</td>

					<td class="opg">"""),_display_(Seq[Any](/*542.23*/if(factura.ordenPago != null)/*542.52*/{_display_(Seq[Any](_display_(Seq[Any](/*542.54*/(factura.ordenPago.getNombreCompleto())))))})),format.raw/*542.94*/("""</td>
					<td class="nfactura">"""),_display_(Seq[Any](/*543.28*/(factura.numero_factura))),format.raw/*543.52*/("""</td>
					
					<td class="totalBase" data-valor=""""),_display_(Seq[Any](/*545.41*/factura/*545.48*/.base)),format.raw/*545.53*/("""" rel=""""),_display_(Seq[Any](/*545.61*/factura/*545.68*/.base)),format.raw/*545.73*/("""">"""),_display_(Seq[Any](/*545.76*/if(factura.base != null)/*545.100*/{_display_(Seq[Any](_display_(Seq[Any](/*545.102*/(utils.NumberUtils.moneda(factura.base))))))})),format.raw/*545.143*/("""</td>
					<td class="totalImpuestos" data-valor=""""),_display_(Seq[Any](/*546.46*/factura/*546.53*/.getTotalImpuesto())),format.raw/*546.72*/("""" rel=""""),_display_(Seq[Any](/*546.80*/factura/*546.87*/.getTotalImpuesto())),format.raw/*546.106*/("""">"""),_display_(Seq[Any](/*546.109*/(utils.NumberUtils.moneda(factura.getTotalImpuesto())))),format.raw/*546.163*/("""</td>
					<td class="total" data-valor=""""),_display_(Seq[Any](/*547.37*/factura/*547.44*/.getTotal())),format.raw/*547.55*/("""" rel=""""),_display_(Seq[Any](/*547.63*/factura/*547.70*/.getTotal())),format.raw/*547.81*/("""">"""),_display_(Seq[Any](/*547.84*/(utils.NumberUtils.moneda(factura.getTotal())))),format.raw/*547.130*/("""</td>
					<td class="totalSaldo" data-valor=""""),_display_(Seq[Any](/*548.42*/factura/*548.49*/.getSaldoPendiente())),format.raw/*548.69*/("""" rel=""""),_display_(Seq[Any](/*548.77*/factura/*548.84*/.getSaldoPendiente())),format.raw/*548.104*/("""">"""),_display_(Seq[Any](/*548.107*/(utils.NumberUtils.moneda(factura.getSaldoPendiente())))),format.raw/*548.162*/("""</td>
					<td>"""),_display_(Seq[Any](/*549.11*/if(factura.expediente != null)/*549.41*/{_display_(Seq[Any](_display_(Seq[Any](/*549.43*/(factura.expediente.getExpedienteEjercicio())))))})),format.raw/*549.89*/("""</td>
					<td>"""),_display_(Seq[Any](/*550.11*/if(factura.periodo != null)/*550.38*/{_display_(Seq[Any](_display_(Seq[Any](/*550.40*/(factura.periodo.nombre)))))})),format.raw/*550.65*/("""</td>
					<td>"""),_display_(Seq[Any](/*551.11*/if(factura.tipoCuenta != null)/*551.41*/{_display_(Seq[Any](_display_(Seq[Any](/*551.43*/factura/*551.50*/.tipoCuenta.nombre))))})),format.raw/*551.69*/("""</td>
					<td class="estado" align="center">
						"""),_display_(Seq[Any](/*553.8*/if(factura.parcial != null && factura.parcial)/*553.54*/{_display_(Seq[Any](format.raw/*553.55*/("""
							Parcializada
						""")))}/*555.8*/else/*555.12*/{_display_(Seq[Any](format.raw/*555.13*/("""
							"""),_display_(Seq[Any](/*556.9*/if(factura.getSaldoPendiente() != null && !factura.getSaldoPendiente().equals(factura.base) && (factura.estado != null && factura.estado.id == 19))/*556.156*/{_display_(Seq[Any](format.raw/*556.157*/("""
								Pagado """),_display_(Seq[Any](/*557.17*/getClassPorcentajePagado(factura))),format.raw/*557.50*/("""%
							""")))}/*558.9*/else/*558.13*/{_display_(Seq[Any](format.raw/*558.14*/("""
								"""),_display_(Seq[Any](/*559.10*/if(factura.estado != null)/*559.36*/{_display_(Seq[Any](_display_(Seq[Any](/*559.38*/(factura.estado.nombre)))))})),format.raw/*559.62*/("""
							""")))})),format.raw/*560.9*/("""
						""")))})),format.raw/*561.8*/("""
						
					</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*565.81*/controllers/*565.92*/.contabilidad.routes.FacturasController.eliminar(factura.id))),format.raw/*565.152*/("""&"""),_display_(Seq[Any](/*565.154*/UriTrack/*565.162*/.encode())),format.raw/*565.171*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*570.15*/("""
             """),_display_(Seq[Any](/*571.15*/paginadorFicha/*571.29*/.guardar())),format.raw/*571.39*/("""
	        </tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="6">Mostrando """),_display_(Seq[Any](/*575.39*/buscador/*575.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*575.79*/(""" resultado(s).</td>
	        		<td><b>Total:</b> <span class="totalBaseFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalImpuestosFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalSaldoFooter"></span></td>
	        		<td colspan="5">&nbsp</td>
	        	</tr>
	        </tfoot>
        </table>
</form>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*586.8*/views/*586.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.FacturasController.index()))),format.raw/*586.106*/("""
		</div>
		
""")))})),format.raw/*589.2*/("""		
		
<script>


$( function () """),format.raw/*594.16*/("""{"""),format.raw/*594.17*/("""
	var trs = $('#listaFacturas tbody tr');
	sumarFilas(trs);
	
	$('#checkAll').click( function() """),format.raw/*598.35*/("""{"""),format.raw/*598.36*/("""
		sumarFilas(trs);
	"""),format.raw/*600.2*/("""}"""),format.raw/*600.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*602.55*/("""{"""),format.raw/*602.56*/("""
		sumarFilas( $('#listaFacturas tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*604.2*/("""}"""),format.raw/*604.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*606.27*/("""{"""),format.raw/*606.28*/("""
		var base = 0; var impuestos = 0; var total = 0; var saldo = 0;
		trs.each( function() """),format.raw/*608.24*/("""{"""),format.raw/*608.25*/("""
			base += Number($('.totalBase',this).attr("data-valor"));
			impuestos += Number($('.totalImpuestos',this).attr("data-valor"));
			total += Number($('.total',this).attr("data-valor"));
			saldo += Number($('.totalSaldo',this).attr("data-valor"));
		"""),format.raw/*613.3*/("""}"""),format.raw/*613.4*/(""");
		
		$(".totalFooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
		$(".totalBaseFooter").html(formatNumberPesos(parseFloat(base).toFixed(2)));
		$(".totalImpuestosFooter").html(formatNumberPesos(parseFloat(impuestos).toFixed(2)));
		$(".totalSaldoFooter").html(formatNumberPesos(parseFloat(saldo).toFixed(2)));
	"""),format.raw/*619.2*/("""}"""),format.raw/*619.3*/("""
"""),format.raw/*620.1*/("""}"""),format.raw/*620.2*/(""");

/*
$( function ()"""),format.raw/*623.15*/("""{"""),format.raw/*623.16*/("""

	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*626.36*/("""{"""),format.raw/*626.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*628.2*/("""}"""),format.raw/*628.3*/(""")
	$(".totalBase").each(function (index) """),format.raw/*629.40*/("""{"""),format.raw/*629.41*/("""
		b = Number($(this).attr("rel"))+b 
	"""),format.raw/*631.2*/("""}"""),format.raw/*631.3*/(""")
	$(".totalImpuestos").each(function (index) """),format.raw/*632.45*/("""{"""),format.raw/*632.46*/("""
		c = Number($(this).attr("rel"))+c 
	"""),format.raw/*634.2*/("""}"""),format.raw/*634.3*/(""")
	$(".totalSaldo").each(function (index) """),format.raw/*635.41*/("""{"""),format.raw/*635.42*/("""
		d = Number($(this).attr("rel"))+d 
	"""),format.raw/*637.2*/("""}"""),format.raw/*637.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	$(".totalBaseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	$(".totalImpuestosFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	$(".totalSaldoFooter").append(formatNumberPesos(parseFloat(d).toFixed(2)));
	
	
	$( "#checkAll" ).click(function() """),format.raw/*644.36*/("""{"""),format.raw/*644.37*/("""
			selectAll();
	"""),format.raw/*646.2*/("""}"""),format.raw/*646.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*647.56*/("""{"""),format.raw/*647.57*/("""
		selectTrList();
	"""),format.raw/*649.2*/("""}"""),format.raw/*649.3*/(""");
	
"""),format.raw/*651.1*/("""}"""),format.raw/*651.2*/(""");


function selectTrList()"""),format.raw/*654.24*/("""{"""),format.raw/*654.25*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*656.36*/("""{"""),format.raw/*656.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*657.77*/("""{"""),format.raw/*657.78*/("""
			a = Number($(this).attr("rel"))+a
		"""),format.raw/*659.3*/("""}"""),format.raw/*659.4*/("""
	"""),format.raw/*660.2*/("""}"""),format.raw/*660.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$(".totalImpuestos").each(function (index) """),format.raw/*664.45*/("""{"""),format.raw/*664.46*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*665.77*/("""{"""),format.raw/*665.78*/("""
			b = Number($(this).attr("rel"))+b 
		"""),format.raw/*667.3*/("""}"""),format.raw/*667.4*/("""
	"""),format.raw/*668.2*/("""}"""),format.raw/*668.3*/(""")
	$(".totalImpuestosFooter").empty();
	$(".totalImpuestosFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".totalBase").each(function (index) """),format.raw/*672.40*/("""{"""),format.raw/*672.41*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*673.77*/("""{"""),format.raw/*673.78*/("""
			c = Number($(this).attr("rel"))+c
		"""),format.raw/*675.3*/("""}"""),format.raw/*675.4*/("""
	"""),format.raw/*676.2*/("""}"""),format.raw/*676.3*/(""")
	$(".totalBaseFooter").empty();
	$(".totalBaseFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	
	$(".totalSaldo").each(function (index) """),format.raw/*680.41*/("""{"""),format.raw/*680.42*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*681.77*/("""{"""),format.raw/*681.78*/("""
			d = Number($(this).attr("rel"))+d 
		"""),format.raw/*683.3*/("""}"""),format.raw/*683.4*/("""
	"""),format.raw/*684.2*/("""}"""),format.raw/*684.3*/(""")
	$(".totalSaldoFooter").empty();
	$(".totalSaldoFooter").append(formatNumberPesos(parseFloat(d).toFixed(2)));
"""),format.raw/*687.1*/("""}"""),format.raw/*687.2*/("""

function selectAll()"""),format.raw/*689.21*/("""{"""),format.raw/*689.22*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	if($("#checkAll").prop("checked"))"""),format.raw/*691.36*/("""{"""),format.raw/*691.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*694.2*/("""}"""),format.raw/*694.3*/("""else"""),format.raw/*694.7*/("""{"""),format.raw/*694.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*696.2*/("""}"""),format.raw/*696.3*/("""
	
	$(".total").each(function (index) """),format.raw/*698.36*/("""{"""),format.raw/*698.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*700.2*/("""}"""),format.raw/*700.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$(".totalImpuestos").each(function (index) """),format.raw/*704.45*/("""{"""),format.raw/*704.46*/("""
		b = Number($(this).attr("rel"))+b
	"""),format.raw/*706.2*/("""}"""),format.raw/*706.3*/(""")
	$(".totalImpuestosFooter").empty();
	$(".totalImpuestosFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".totalBase").each(function (index) """),format.raw/*710.40*/("""{"""),format.raw/*710.41*/("""
		c = Number($(this).attr("rel"))+c
	"""),format.raw/*712.2*/("""}"""),format.raw/*712.3*/(""")
	$(".totalBaseFooter").empty();
	$(".totalBaseFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	
	$(".totalSaldo").each(function (index) """),format.raw/*716.41*/("""{"""),format.raw/*716.42*/("""
		d = Number($(this).attr("rel"))+d 
	"""),format.raw/*718.2*/("""}"""),format.raw/*718.3*/(""")
	$(".totalSaldoFooter").empty();
	$(".totalSaldoFooter").append(formatNumberPesos(parseFloat(d).toFixed(2)));
	
"""),format.raw/*722.1*/("""}"""),format.raw/*722.2*/("""
*/
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Factura],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Factura],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/indexFacturaProveedor.scala.html
                    HASH: 644705307075d371bc4b0410b6dada8fc8ca6838
                    MATRIX: 886->1|1141->253|1155->260|1239->264|1290->280|1304->286|1375->336|1442->182|1474->206|1532->375|1555->389|2107->930|2133->947|2294->1097|2321->1115|2631->1414|2664->1438|3531->125|3559->250|3587->372|3616->927|3645->1094|3674->1411|3703->2274|3741->2277|3754->2282|3828->2347|3868->2349|4340->2785|4360->2796|4444->2857|4556->2933|4576->2944|4661->3006|4782->3091|4802->3102|4897->3174|5020->3261|5040->3272|5134->3343|5257->3430|5277->3441|5372->3513|5507->3612|5527->3623|5633->3706|5767->3804|5787->3815|5891->3896|6026->3995|6046->4006|6153->4090|6295->4196|6315->4207|6424->4293|6581->4414|6601->4425|6709->4510|6857->4622|6877->4633|6984->4717|7146->4843|7166->4854|7257->4922|7401->5030|7421->5041|7530->5127|7678->5239|7698->5250|7802->5331|7954->5447|7974->5458|8077->5538|8215->5639|8236->5650|8336->5726|8467->5820|8488->5831|8579->5898|8699->5981|8720->5992|8801->6049|9168->6380|9219->6421|9260->6423|9356->6482|9377->6493|9463->6555|9528->6588|9645->6669|9703->6717|9744->6719|9897->6834|9919->6845|10013->6915|10081->6951|10126->6960|10181->7005|10222->7007|10372->7119|10394->7130|10485->7197|10550->7230|10596->7240|10657->7291|10698->7293|10854->7411|10876->7422|10971->7493|11040->7530|11086->7540|11144->7588|11185->7590|11338->7705|11360->7716|11452->7784|11518->7818|11564->7828|11617->7871|11658->7873|11811->7988|11833->7999|11925->8067|11990->8100|12036->8110|12095->8159|12136->8161|12290->8277|12312->8288|12405->8357|12471->8391|12520->8404|12580->8454|12621->8456|12772->8569|12794->8580|12888->8650|12960->8690|13005->8699|13064->8748|13105->8750|13261->8868|13283->8879|13382->8954|13460->9000|13507->9011|13560->9054|13601->9056|13751->9168|13773->9179|13866->9248|13940->9290|13987->9301|14035->9339|14076->9341|14229->9456|14251->9467|14347->9539|14416->9576|14463->9587|14522->9636|14563->9638|14725->9762|14747->9773|14852->9854|14931->9901|15047->9980|15068->9991|15138->10038|15177->10040|15195->10048|15227->10057|15401->10195|15415->10200|15463->10225|15856->10581|15938->10640|16154->10819|16236->10878|16449->11054|16531->11113|16746->11291|16828->11350|17031->11516|17113->11575|17334->11759|17416->11818|17649->12014|17731->12073|17945->12250|18027->12309|18304->12549|18386->12608|18625->12810|18707->12869|18917->13043|19007->13110|19246->13313|19332->13376|19521->13529|19647->13631|19692->13640|19798->13723|20021->13909|20042->13920|20116->13971|20584->14403|20720->14515|20765->14524|20882->14617|21108->14806|21129->14817|21207->14872|21698->15327|21826->15431|21871->15440|21979->15525|22202->15711|22223->15722|22300->15776|22782->16222|22881->16298|22925->16306|23025->16383|23233->16554|23254->16565|23330->16618|23761->17013|23898->17126|23943->17135|24061->17229|24281->17412|24302->17423|24377->17475|24867->17929|24951->17990|25183->18186|25422->18402|25465->18409|25694->18615|25900->18785|26013->18875|26057->18883|26163->18966|26378->19144|26399->19155|26479->19212|26930->19627|27088->19761|27132->19769|27290->19903|27463->20040|27631->20184|27675->20192|27843->20336|28019->20476|28193->20626|28237->20634|28411->20784|28557->20894|28864->21177|29049->21326|29103->21357|29224->21442|29280->21475|29560->21719|29640->21776|29803->21903|29994->22070|30191->22231|30332->22348|30376->22356|30479->22436|30696->22616|30717->22627|30792->22679|31213->23064|31342->23169|31791->23581|31812->23592|31882->23639|32193->23913|32211->23921|32266->23953|33369->25020|33418->25052|33459->25054|33501->25060|33525->25074|33573->25099|33635->25124|33681->25147|33720->25149|33769->25175|33822->25191|33839->25198|33873->25208|33925->25222|33947->25233|34026->25288|34066->25290|34085->25298|34118->25307|34221->25373|34238->25380|34264->25383|34336->25417|34354->25424|34381->25427|34537->25546|34558->25557|34640->25615|34680->25617|34699->25625|34732->25634|34841->25707|34902->25758|34942->25759|35048->25828|35098->25855|35320->26045|35401->26090|35440->26106|35479->26108|35525->26144|35565->26145|35622->26165|35684->26199|35728->26207|35768->26237|35808->26238|35853->26247|35896->26280|35936->26281|36062->26375|36102->26383|36161->26405|36200->26434|36249->26436|36303->26463|36369->26492|36408->26521|36457->26523|36524->26563|36594->26596|36641->26620|36730->26672|36747->26679|36775->26684|36820->26692|36837->26699|36865->26704|36905->26707|36940->26731|36990->26733|37059->26774|37147->26825|37164->26832|37206->26851|37251->26859|37268->26866|37311->26885|37352->26888|37430->26942|37509->26984|37526->26991|37560->27002|37605->27010|37622->27017|37656->27028|37696->27031|37766->27077|37850->27124|37867->27131|37910->27151|37955->27159|37972->27166|38016->27186|38057->27189|38136->27244|38189->27260|38229->27290|38278->27292|38351->27338|38404->27354|38441->27381|38490->27383|38542->27408|38595->27424|38635->27454|38684->27456|38701->27463|38747->27482|38836->27535|38892->27581|38932->27582|38979->27610|38993->27614|39033->27615|39078->27624|39236->27771|39277->27772|39331->27789|39387->27822|39416->27832|39430->27836|39470->27837|39517->27847|39553->27873|39602->27875|39653->27899|39694->27908|39734->27916|39880->28025|39901->28036|39985->28096|40025->28098|40044->28106|40077->28115|40223->28228|40275->28243|40299->28257|40332->28267|40459->28357|40477->28365|40532->28397|41020->28849|41035->28854|41152->28947|41198->28961|41259->28993|41289->28994|41414->29090|41444->29091|41493->29112|41522->29113|41610->29172|41640->29173|41749->29254|41778->29255|41838->29286|41868->29287|41986->29376|42016->29377|42296->29629|42325->29630|42681->29958|42710->29959|42739->29960|42768->29961|42818->29982|42848->29983|42956->30062|42986->30063|43053->30102|43082->30103|43152->30144|43182->30145|43249->30184|43278->30185|43353->30231|43383->30232|43450->30271|43479->30272|43550->30314|43580->30315|43647->30354|43676->30355|44052->30702|44082->30703|44128->30721|44157->30722|44244->30780|44274->30781|44322->30801|44351->30802|44384->30807|44413->30808|44470->30836|44500->30837|44607->30915|44637->30916|44743->30993|44773->30994|44841->31034|44870->31035|44900->31037|44929->31038|45106->31186|45136->31187|45242->31264|45272->31265|45341->31306|45370->31307|45400->31309|45429->31310|45619->31471|45649->31472|45755->31549|45785->31550|45853->31590|45882->31591|45912->31593|45941->31594|46122->31746|46152->31747|46258->31824|46288->31825|46357->31866|46386->31867|46416->31869|46445->31870|46585->31982|46614->31983|46665->32005|46695->32006|46802->32084|46832->32085|46927->32152|46956->32153|46988->32157|47017->32158|47111->32224|47140->32225|47207->32263|47237->32264|47304->32303|47333->32304|47510->32452|47540->32453|47606->32491|47635->32492|47825->32653|47855->32654|47921->32692|47950->32693|48131->32845|48161->32846|48228->32885|48257->32886|48399->33000|48428->33001
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|55->30|55->30|62->39|62->39|76->55|76->55|95->1|96->5|97->8|99->28|101->37|103->53|105->73|107->75|107->75|107->75|107->75|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|134->102|134->102|134->102|135->103|135->103|135->103|144->112|144->112|144->112|145->113|145->113|145->113|146->114|148->116|148->116|148->116|149->117|149->117|149->117|150->118|151->119|151->119|151->119|152->120|152->120|152->120|153->121|154->122|154->122|154->122|155->123|155->123|155->123|156->124|157->125|157->125|157->125|158->126|158->126|158->126|159->127|160->128|160->128|160->128|161->129|161->129|161->129|162->130|163->131|163->131|163->131|164->132|164->132|164->132|165->133|166->134|166->134|166->134|167->135|167->135|167->135|168->136|169->137|169->137|169->137|170->138|170->138|170->138|171->139|172->140|172->140|172->140|173->141|173->141|173->141|174->142|175->143|175->143|175->143|176->144|176->144|176->144|177->145|178->146|178->146|178->146|179->147|179->147|179->147|180->148|184->152|184->152|184->152|184->152|184->152|184->152|190->158|190->158|190->158|200->168|200->168|204->172|204->172|208->176|208->176|212->180|212->180|216->184|216->184|220->188|220->188|224->192|224->192|228->196|228->196|234->202|234->202|238->206|238->206|247->215|247->215|257->225|257->225|265->233|265->233|266->234|266->234|271->239|271->239|271->239|286->254|286->254|287->255|287->255|292->260|292->260|292->260|308->276|308->276|309->277|309->277|314->282|314->282|314->282|330->298|330->298|331->299|331->299|336->304|336->304|336->304|350->318|350->318|351->319|351->319|356->324|356->324|356->324|371->339|371->339|381->349|385->353|386->354|389->357|396->364|396->364|397->365|397->365|402->370|402->370|402->370|417->385|417->385|418->386|418->386|424->392|424->392|425->393|425->393|431->399|431->399|432->400|432->400|437->405|437->405|445->413|445->413|449->417|449->417|464->432|464->432|471->439|472->440|478->446|478->446|479->447|479->447|482->450|482->450|482->450|492->460|492->460|504->472|504->472|504->472|516->484|516->484|516->484|546->514|546->514|546->514|547->515|547->515|547->515|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|548->516|549->517|549->517|549->517|549->517|549->517|549->517|551->519|551->519|551->519|551->519|551->519|551->519|554->522|554->522|554->522|556->524|556->524|562->530|565->533|565->533|565->533|565->533|565->533|565->533|565->533|566->534|566->534|566->534|567->535|567->535|567->535|569->537|570->538|572->540|572->540|572->540|572->540|574->542|574->542|574->542|574->542|575->543|575->543|577->545|577->545|577->545|577->545|577->545|577->545|577->545|577->545|577->545|577->545|578->546|578->546|578->546|578->546|578->546|578->546|578->546|578->546|579->547|579->547|579->547|579->547|579->547|579->547|579->547|579->547|580->548|580->548|580->548|580->548|580->548|580->548|580->548|580->548|581->549|581->549|581->549|581->549|582->550|582->550|582->550|582->550|583->551|583->551|583->551|583->551|583->551|585->553|585->553|585->553|587->555|587->555|587->555|588->556|588->556|588->556|589->557|589->557|590->558|590->558|590->558|591->559|591->559|591->559|591->559|592->560|593->561|597->565|597->565|597->565|597->565|597->565|597->565|602->570|603->571|603->571|603->571|607->575|607->575|607->575|618->586|618->586|618->586|621->589|626->594|626->594|630->598|630->598|632->600|632->600|634->602|634->602|636->604|636->604|638->606|638->606|640->608|640->608|645->613|645->613|651->619|651->619|652->620|652->620|655->623|655->623|658->626|658->626|660->628|660->628|661->629|661->629|663->631|663->631|664->632|664->632|666->634|666->634|667->635|667->635|669->637|669->637|676->644|676->644|678->646|678->646|679->647|679->647|681->649|681->649|683->651|683->651|686->654|686->654|688->656|688->656|689->657|689->657|691->659|691->659|692->660|692->660|696->664|696->664|697->665|697->665|699->667|699->667|700->668|700->668|704->672|704->672|705->673|705->673|707->675|707->675|708->676|708->676|712->680|712->680|713->681|713->681|715->683|715->683|716->684|716->684|719->687|719->687|721->689|721->689|723->691|723->691|726->694|726->694|726->694|726->694|728->696|728->696|730->698|730->698|732->700|732->700|736->704|736->704|738->706|738->706|742->710|742->710|744->712|744->712|748->716|748->716|750->718|750->718|754->722|754->722
                    -- GENERATED --
                */
            