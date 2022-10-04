
package views.html.compras.ordenes

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
object verOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Form[Orden],Orden,OrdenProvision,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenForm: Form[Orden], orden: Orden,op:OrdenProvision, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

import models.auth._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/compras/ordenes.js"))),format.raw/*9.66*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.107*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(orden.id.toString))),format.raw/*6.45*/("""

"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.compras.mainCompras("Vista de orden", scripts)/*12.59*/ {_display_(Seq[Any](format.raw/*12.61*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-6">
				<h1>Vista de Orden de Compra """),_display_(Seq[Any](/*16.35*/if(orden.expediente != null)/*16.63*/{_display_(Seq[Any](_display_(Seq[Any](/*16.65*/if(orden.expediente.emergencia)/*16.96*/{_display_(Seq[Any](format.raw/*16.97*/("""<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*16.187*/("""</h1>
			</div>
			<div class="col-sm-6">
			 	
			 	<div class="dropdown pull-right">  	
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*27.9*/if(Permiso.check("ordenesImputacionDefinitiva"))/*27.57*/ {_display_(Seq[Any](format.raw/*27.59*/("""
				  		<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*28.73*/controllers/*28.84*/.compras.routes.OrdenesReportesController.reporteImputacionDefinitiva(orden.id))),format.raw/*28.163*/("""">Imputaci&oacute;n definitiva</a></li>
					""")))})),format.raw/*29.7*/("""
					"""),_display_(Seq[Any](/*30.7*/if(Permiso.check("reporteOrdenProvisionMail"))/*30.53*/ {_display_(Seq[Any](format.raw/*30.55*/("""
					  <li>
					  	<a role="menuitem" tabindex="-1" href="#" class="modalOrdenMail"  
					  	data-url=""""),_display_(Seq[Any](/*33.20*/controllers/*33.31*/.compras.routes.OrdenesAccionesController.modalOrdenMail(orden.id))),format.raw/*33.97*/("""">Enviar Orden Provision por mail</a>
					  </li>
					""")))})),format.raw/*35.7*/("""  
					"""),_display_(Seq[Any](/*36.7*/if(Permiso.check("reporteOrdenProvision"))/*36.49*/ {_display_(Seq[Any](format.raw/*36.51*/("""    		
					  <li>
					  	<a role="menuitem" tabindex="-1" href="#" class="reporteOrdenProvision"  
					  	data-url=""""),_display_(Seq[Any](/*39.20*/controllers/*39.31*/.patrimonio.routes.OrdenesProvisionReportesController.ordenDeProvision(orden.id,false))),format.raw/*39.117*/("""">Reporte Orden Provision</a>
					  </li>
					""")))})),format.raw/*41.7*/("""
					"""),_display_(Seq[Any](/*42.7*/if(Permiso.check("reporteOrdenProvisionSinMonto"))/*42.57*/ {_display_(Seq[Any](format.raw/*42.59*/("""  
					  <li>
					  	<a role="menuitem" tabindex="-1" href="#" class="reporteOrdenProvision"  
					  	data-url=""""),_display_(Seq[Any](/*45.20*/controllers/*45.31*/.patrimonio.routes.OrdenesProvisionReportesController.ordenDeProvision(orden.id,true))),format.raw/*45.116*/("""">Reporte Orden Provision Sin Montos</a>
					  </li>
				  	""")))})),format.raw/*47.9*/("""
				  	"""),_display_(Seq[Any](/*48.9*/if(Permiso.check("reporteOrdenLineas"))/*48.48*/ {_display_(Seq[Any](format.raw/*48.50*/("""
					  <li>
					  	<a role="menuitem" tabindex="-1" 
					  	href=""""),_display_(Seq[Any](/*51.16*/controllers/*51.27*/.compras.routes.OrdenesReportesController.listadoLineas(orden.id))),format.raw/*51.92*/("""">Exportar Lineas</a>
					  </li>
				  	""")))})),format.raw/*53.9*/("""
				  	"""),_display_(Seq[Any](/*54.9*/if(orden.estado.id == models.Estado.ORDEN_ESTADO_APROBADO)/*54.67*/ {_display_(Seq[Any](format.raw/*54.69*/("""
				  	<li>
				  	<a role="menuitem" tabindex="-1" href="#" id="reporteCertificacionPaciente" 
				  	data-url=""""),_display_(Seq[Any](/*57.19*/controllers/*57.30*/.compras.routes.OrdenesReportesController.reporteCertificacionPaciente(orden.id))),format.raw/*57.110*/("""">Certificacion Pacientes</a>
				  	</li>
				   	""")))})),format.raw/*59.10*/("""
					</ul>	  
				</div>
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
					<ul class="dropdown-menu">
						"""),_display_(Seq[Any](/*65.8*/if(Permiso.check("ordenesEditarMontoAdelanto"))/*65.55*/ {_display_(Seq[Any](format.raw/*65.57*/("""
		    				<li role="presentation"><a role="menuitem" id="accionEditarMontoAdelanto" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*66.119*/controllers/*66.130*/.compras.routes.OrdenesAccionesController.modalEditarMontoAdelanto(orden.id))),format.raw/*66.206*/("""">Editar Monto Adelanto</a></li>
		    				<li role="presentation"><a role="menuitem" id="accionEditarCotDolar" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*67.114*/controllers/*67.125*/.compras.routes.OrdenesAccionesController.modalEditarCotDolar(orden.id))),format.raw/*67.196*/("""">Editar Cotizacion Dolar</a></li>
		    			""")))})),format.raw/*68.11*/("""
		    			"""),_display_(Seq[Any](/*69.11*/if(Permiso.check("ordenesEditarFechaProvision"))/*69.59*/ {_display_(Seq[Any](format.raw/*69.61*/("""
		    				<li role="presentation"><a role="menuitem" id="accionEditarFechaProvision" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*70.120*/controllers/*70.131*/.compras.routes.OrdenesAccionesController.modalEditarFechaProvision(orden.id))),format.raw/*70.208*/("""">Editar Fecha Provision</a></li>
		    				<li role="presentation"><a role="menuitem" id="accionEditarRubro" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*71.111*/controllers/*71.122*/.compras.routes.OrdenesAccionesController.modalEditarRubro(orden.id))),format.raw/*71.190*/("""">Editar Rubro</a></li>
		    			""")))})),format.raw/*72.11*/("""  
		    			
		    			
		    			"""),_display_(Seq[Any](/*75.11*/if(Permiso.check("dispoCrear"))/*75.42*/ {_display_(Seq[Any](format.raw/*75.44*/("""
		    				<li role="presentation"><a role="menuitem" id="accionCrearDispo" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*76.110*/controllers/*76.121*/.compras.routes.OrdenesAccionesController.modalCrearDispo(orden.id))),format.raw/*76.188*/("""">Crear Dispo</a></li>
					 	""")))})),format.raw/*77.9*/("""
					 </ul>
				</div>
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*81.16*/controllers/*81.27*/.compras.routes.OrdenesController.crear())),_display_(Seq[Any](/*81.69*/UriTrack/*81.77*/.get("?"))),format.raw/*81.86*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Orden</a>
				</div>
				
				"""),_display_(Seq[Any](/*84.6*/if(Permiso.check("dashboardInformeDeudaPorActas") && orden.tipo_moneda != null)/*84.85*/ {_display_(Seq[Any](format.raw/*84.87*/("""
					<div class="pull-right btn-header">
				 	 
				 		<a target="_blank"  href="/dashboard/controlDeudaMonedaExtranjera?orden_id="""),_display_(Seq[Any](/*87.84*/orden/*87.89*/.id)),format.raw/*87.92*/("""" class="btn btn-default">
				 		<i class="glyphicon glyphicon glyphicon-signal"></i>
				 		</a>
				 	</div>
			 	""")))})),format.raw/*91.7*/("""
			</div> 
		</div>
	</div>
	
"""),_display_(Seq[Any](/*96.2*/views/*96.7*/.html.tags.successError())),format.raw/*96.32*/("""

	<div class="alert alert-success successAddLineaAjuste" style="display: none;"><i class="glyphicon glyphicon-ok-sign"></i></div>
	 
	<div class="row menu-acciones">
		<div class="col-sm-4">
			<a href=""""),_display_(Seq[Any](/*102.14*/controllers/*102.25*/.compras.routes.OrdenesController.crear())),_display_(Seq[Any](/*102.67*/UriTrack/*102.75*/.get("?"))),format.raw/*102.84*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*103.14*/controllers/*103.25*/.compras.routes.OrdenesController.editar(orden.id))),_display_(Seq[Any](/*103.76*/UriTrack/*103.84*/.get("&"))),format.raw/*103.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*104.14*/controllers/*104.25*/.compras.routes.OrdenesController.duplicar(orden.id))),_display_(Seq[Any](/*104.78*/UriTrack/*104.86*/.get("&"))),format.raw/*104.95*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
			<a href=""""),_display_(Seq[Any](/*105.14*/controllers/*105.25*/.compras.routes.OrdenesController.eliminar(orden.id))),_display_(Seq[Any](/*105.78*/UriTrack/*105.86*/.get("&"))),format.raw/*105.95*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
			
		</div>
		<div class="col-sm-4">
			"""),_display_(Seq[Any](/*109.5*/if(ordenForm("tipoCuenta").value != null)/*109.46*/{_display_(Seq[Any](format.raw/*109.47*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*110.65*/ordenForm("tipoCuenta.nombre")/*110.95*/.value)),format.raw/*110.101*/("""</span>
			""")))})),format.raw/*111.5*/("""
		</div>
		<div class="col-sm-3">
			"""),_display_(Seq[Any](/*114.5*/if(op != null)/*114.19*/{_display_(Seq[Any](format.raw/*114.20*/("""
				<a href=""""),_display_(Seq[Any](/*115.15*/controllers/*115.26*/.patrimonio.routes.OrdenesProvisionController.ver(op.id))),format.raw/*115.82*/("""&"""),_display_(Seq[Any](/*115.84*/UriTrack/*115.92*/.encode())),format.raw/*115.101*/("""" class="btn btn-default"><i class="glyphicon glyphicon glyphicon-share"></i> Orden Provision</a>
			""")))})),format.raw/*116.5*/("""
			<a href=""""),_display_(Seq[Any](/*117.14*/UriTrack/*117.22*/.getOnNull(controllers.compras.routes.OrdenesController.index().absoluteURL()))),format.raw/*117.100*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			
		"""),_display_(Seq[Any](/*119.4*/if(paginadorFicha.getLista().size() > 1)/*119.44*/{_display_(Seq[Any](format.raw/*119.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*122.5*/if(paginadorFicha.hasPrev())/*122.33*/ {_display_(Seq[Any](format.raw/*122.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*123.29*/controllers/*123.40*/.compras.routes.OrdenesController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*123.108*/UriTrack/*123.116*/.get("&"))),format.raw/*123.125*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*124.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*125.79*/paginadorFicha/*125.93*/.posicionActual())),format.raw/*125.110*/(""" de """),_display_(Seq[Any](/*125.115*/paginadorFicha/*125.129*/.getLista().size())),format.raw/*125.147*/("""</p>
			"""),_display_(Seq[Any](/*126.5*/if(paginadorFicha.hasNext())/*126.33*/ {_display_(Seq[Any](format.raw/*126.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*127.29*/controllers/*127.40*/.compras.routes.OrdenesController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*127.108*/UriTrack/*127.116*/.get("&"))),format.raw/*127.125*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*128.5*/("""  
		</div>
		""")))})),format.raw/*130.4*/("""
			
			
		</div>
	</div>


	<input type="hidden" name="ordenId" id="ordenId" value=""""),_display_(Seq[Any](/*137.59*/ordenForm("id")/*137.74*/.value)),format.raw/*137.80*/(""""/>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*141.49*/orden/*141.54*/.nombre)),format.raw/*141.61*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*145.89*/ordenForm("proveedor.nombre")/*145.118*/.value)),format.raw/*145.124*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha orden</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*149.49*/ordenForm("fecha_orden")/*149.73*/.value)),format.raw/*149.79*/("""</p>
		</div>
		<div class="col-sm-2">
			<label>Expediente - <span style="color:red;font-weight: bold;">"""),_display_(Seq[Any](/*152.68*/(utils.DateUtils.formatDate(orden.expediente.fecha)))),format.raw/*152.120*/("""</span></label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*153.49*/ordenForm("expediente.expedienteEjercicio")/*153.92*/.value)),format.raw/*153.98*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Periodo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*157.49*/ordenForm("periodo.nombre")/*157.76*/.value)),format.raw/*157.82*/("""</p>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label>Solicitud de Compras</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*164.49*/if(orden.solicitud != null)/*164.76*/{_display_(Seq[Any](_display_(Seq[Any](/*164.78*/orden/*164.83*/.solicitud.referencia))))})),format.raw/*164.105*/("""</p>
		</div>
		<div class="col-sm-2">
			<label>Orden de provisión</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*168.49*/ordenForm("numero_orden_provision")/*168.84*/.value)),format.raw/*168.90*/("""</p>
		</div>
		<div class="col-sm-2">
			<label>Fecha provisión</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*172.49*/ordenForm("fecha_provision")/*172.77*/.value)),format.raw/*172.83*/("""</p>
		</div>	
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*176.49*/ordenForm("deposito.nombre")/*176.77*/.value)),format.raw/*176.83*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Tipo contratación</label>
			<p class="form-control-static form-control">
			
				"""),_display_(Seq[Any](/*182.6*/ordenForm("tipo_contratacion")/*182.36*/.value/*182.42*/ match/*182.48*/ {/*183.6*/case "compras" =>/*183.23*/ {_display_(Seq[Any](format.raw/*183.25*/("""Compra Directa""")))}/*184.6*/case "licitacion" =>/*184.26*/ {_display_(Seq[Any](format.raw/*184.28*/("""Licitacion Pública""")))}/*185.6*/case "licitacion_pri" =>/*185.30*/ {_display_(Seq[Any](format.raw/*185.32*/("""Licitacion Privada""")))}/*186.6*/case "contratacion" =>/*186.28*/ {_display_(Seq[Any](format.raw/*186.30*/("""Contratacion""")))}/*187.6*/case "contratacion_directa" =>/*187.36*/ {_display_(Seq[Any](format.raw/*187.38*/("""Contratacion Directa""")))}/*188.6*/case "concurso_precios" =>/*188.32*/ {_display_(Seq[Any](format.raw/*188.34*/("""Concurso de Precios""")))}/*189.9*/case _ =>/*189.18*/ {}})),format.raw/*190.6*/("""
			</p>
		</div>
	</div>	 
	<div class="row" id="">
		<div class="col-sm-4">
			<label class="control-label">Tipo Orden</label>
			<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*198.6*/ordenForm("tipo_orden")/*198.29*/.value/*198.35*/ match/*198.41*/ {/*199.6*/case "comun" =>/*199.21*/ {_display_(Seq[Any](format.raw/*199.23*/("""Recepcion de Productos (Patrimonio)""")))}/*200.6*/case "servicio" =>/*200.24*/ {_display_(Seq[Any](format.raw/*200.26*/("""Certificacion de Servicios (Patrimonio)""")))}/*201.6*/case "personal" =>/*201.24*/ {_display_(Seq[Any](format.raw/*201.26*/("""Contratos Personal (Personal)""")))}/*202.6*/case "certificacioncompra" =>/*202.35*/ {_display_(Seq[Any](format.raw/*202.37*/("""Certificaciones Compras (Compras)""")))}/*203.6*/case "haberesrelacion" =>/*203.31*/ {_display_(Seq[Any](format.raw/*203.33*/("""Haberes Contratos Relacion (Liquidaciones)""")))}/*204.6*/case "sinop" =>/*204.21*/ {_display_(Seq[Any](format.raw/*204.23*/("""Sin Orden de Provision (Compras)""")))}/*205.6*/case "imputacion" =>/*205.26*/ {_display_(Seq[Any](format.raw/*205.28*/("""Imputacion Presupuesto (Contabilidad)""")))}/*206.6*/case "certificacionobra" =>/*206.33*/ {_display_(Seq[Any](format.raw/*206.35*/("""Certificaciones Obras (Infraestructura)""")))}/*207.6*/case _ =>/*207.15*/ {}})),format.raw/*208.6*/("""
			</p>
		</div>
		<div class="col-sm-3">
			<!-- <div class="col-sm-6">
				<div class="checkbox">
					<label class="control-label">Creacion Automatica
					"""),_display_(Seq[Any](/*215.7*/checkbox(ordenForm("creacion_automatica"), 'disabled -> "disabled"))),format.raw/*215.74*/("""</label> 
				</div>
			</div>
			<div class="col-sm-6">
				<div class="checkbox">
					<label class="control-label"> 
						Profe
						"""),_display_(Seq[Any](/*222.8*/checkbox(ordenForm("profe"), 'disabled -> "disabled"))),format.raw/*222.61*/("""
					</label>
				</div>
			</div> -->
			<label class="control-label">Tipo Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*227.49*/if(orden.tipoCuenta != null)/*227.77*/{_display_(Seq[Any](_display_(Seq[Any](/*227.79*/orden/*227.84*/.tipoCuenta.nombre))))})),format.raw/*227.103*/("""</p>
		</div>
		<div class="col-sm-3">
			<div class="col-sm-6">
				<label class="control-label">Fecha inicio</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*232.50*/ordenForm("fecha_inicio")/*232.75*/.value)),format.raw/*232.81*/("""</p>
			</div>
			<div class="col-sm-6">
				<label class="control-label">Fecha fin</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*236.50*/ordenForm("fecha_fin")/*236.72*/.value)),format.raw/*236.78*/("""</p>
			</div>	
		</div>		
		<div class="col-sm-2">
			<label class="control-label">Fecha entrega</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*241.49*/ordenForm("fecha_entrega")/*241.75*/.value)),format.raw/*241.81*/("""</p>
		</div>
	</div>
	<div class="row contenedorRubros">
		<div class="col-sm-3">
			<div class="">
				<label for="" class="control-label">Rubro</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*249.7*/if(orden.ordenRubro != null)/*249.35*/{_display_(Seq[Any](format.raw/*249.36*/("""
						"""),_display_(Seq[Any](/*250.8*/orden/*250.13*/.ordenRubro.nombre)),format.raw/*250.31*/("""
					""")))})),format.raw/*251.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="">
				<label for="" class="control-label">Sub-Rubro</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*259.7*/if(orden.ordenSubrubro != null)/*259.38*/{_display_(Seq[Any](format.raw/*259.39*/("""
						"""),_display_(Seq[Any](/*260.8*/orden/*260.13*/.ordenSubrubro.nombre)),format.raw/*260.34*/("""
					""")))})),format.raw/*261.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="">
				<label for="" class="control-label">Detalle Rubro</label>	
				<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*269.6*/ordenForm("detalle_rubro")/*269.32*/.value)),format.raw/*269.38*/("""
				</p>
			</div>
		</div>
		
		
		<div class="col-sm-3">
			<div class="row">
		
				<div class="col-sm-6">
					<div class="">
						<label for="" class="control-label">Monto adelanto</label>	
						<p class="form-control-static form-control">
						"""),_display_(Seq[Any](/*282.8*/utils/*282.13*/.NumberUtils.moneda(orden.monto_adelanto, 2))),format.raw/*282.57*/("""
						</p>
					</div>
				</div>
				
				<div class="col-sm-6">
					<div class="">
						<label for="" class="control-label">Cotización</label>	
						<p class="form-control-static form-control">
						"""),_display_(Seq[Any](/*291.8*/if(orden.tipo_moneda != null)/*291.37*/ {_display_(Seq[Any](format.raw/*291.39*/("""
							"""),_display_(Seq[Any](/*292.9*/UltimaCotizacion/*292.25*/.getMoneda(orden.tipo_moneda))),format.raw/*292.54*/(""" 
							"""),_display_(Seq[Any](/*293.9*/utils/*293.14*/.NumberUtils.moneda(orden.cot_dolar, 2))),format.raw/*293.53*/("""
						""")))})),format.raw/*294.8*/("""
						</p>
					</div>
				</div>
		
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="">
				<label for="" class="control-label">N° Presupuesto</label>	
				<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*308.6*/ordenForm("numero_presupuesto")/*308.37*/.value)),format.raw/*308.43*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-10">
			<div class="">
				<label for="" class="control-label">Plazo Entrega</label>	
				<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*316.6*/ordenForm("plazo_entrega")/*316.32*/.value)),format.raw/*316.38*/("""
				</p>
			</div>
		</div>
	</div>	
	"""),_display_(Seq[Any](/*321.3*/if(Orden.getOrdenHija(orden.id) != null)/*321.43*/{_display_(Seq[Any](format.raw/*321.44*/("""
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<span style="color:green;font-size: 25px;font-weight: bold;">ORDEN HIJA """),_display_(Seq[Any](/*325.78*/Orden/*325.83*/.getOrdenHija(orden.id))),format.raw/*325.106*/("""</span>
			</div>
		</div>
	""")))})),format.raw/*328.3*/("""
	
	"""),_display_(Seq[Any](/*330.3*/if(Orden.getOrdenPadre(orden.id) != null)/*330.44*/{_display_(Seq[Any](format.raw/*330.45*/("""
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<span style="color:green;font-size: 25px;font-weight: bold;">ORDEN PADRE """),_display_(Seq[Any](/*334.79*/Orden/*334.84*/.getOrdenPadre(orden.id))),format.raw/*334.108*/("""</span>
			</div>
		</div>
	""")))})),format.raw/*337.3*/("""
	"""),_display_(Seq[Any](/*338.3*/views/*338.8*/.html.compras.ordenes.tabsOrden(false, ordenForm))),format.raw/*338.57*/("""
	
	"""),_display_(Seq[Any](/*340.3*/if(orden.cot_dolar != null && orden.cot_dolar.compareTo(java.math.BigDecimal.ZERO) > 0)/*340.90*/{_display_(Seq[Any](format.raw/*340.91*/("""
	
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-striped table-bordered">
					<thead>
						<tr style="background: #FFFFFF;">
							<td>PESOS</td>
							<td>MONEDA EXTRANJERA</td>
						</tr>
					</thead>
					<tbody>
						<tr style="background: #FFFFFF;">
							<td>
								<h4>Base: 	<b>"""),_display_(Seq[Any](/*354.24*/utils/*354.29*/.NumberUtils.moneda(orden.getTotal()))),format.raw/*354.66*/("""</b></h4>	
							</td>
							<td>
								<h4>Base: 	<b>"""),_display_(Seq[Any](/*357.24*/utils/*357.29*/.NumberUtils.moneda(orden.getTotalDolar(), orden.tipo_moneda))),format.raw/*357.90*/("""</b></h4>
							</td>
						</tr>
						<tr style="background: #FFFFFF;">
							<td>
								<h4>Ajuste sin D/C: <b>"""),_display_(Seq[Any](/*362.33*/utils/*362.38*/.NumberUtils.moneda(orden.getTotalAjusteSinDiferenciaCotizacion()))),format.raw/*362.104*/("""</b></h4>	
							</td>
							<td>
								<h4>Ajuste sin D/C: <b>"""),_display_(Seq[Any](/*365.33*/utils/*365.38*/.NumberUtils.moneda(orden.getTotalDolarAjusteSinDiferenciaCotizacion(), orden.tipo_moneda))),format.raw/*365.128*/("""</b></h4>
							</td>
						</tr>
						<tr style="background: #FFFFFF;">
							<td>
								<h4>Total sin D/C: 	<b>"""),_display_(Seq[Any](/*370.33*/utils/*370.38*/.NumberUtils.moneda(orden.getTotalTotalSinDiferenciaCotizacion()))),format.raw/*370.103*/("""</b></h4>
							</td>
							<td>
								<h4>Total: 	<b>"""),_display_(Seq[Any](/*373.25*/utils/*373.30*/.NumberUtils.moneda(orden.getTotalDolarSinDiferenciaCotizacio(), orden.tipo_moneda))),format.raw/*373.113*/("""</b></h4>
							</td>
						</tr>
						<tr style="background: #FFFFFF;">
							<td>
								<h4>Ajuste D/C: <b>"""),_display_(Seq[Any](/*378.29*/utils/*378.34*/.NumberUtils.moneda(orden.getTotalAjusteConDiferenciaCotizacion()))),format.raw/*378.100*/("""</b></h4>	
							</td>
							<td>
								
							</td>
						</tr>
						 
						<tr style="background: #FFFFFF;">
							<td>
								<h4>Total con D/C: <b>"""),_display_(Seq[Any](/*387.32*/utils/*387.37*/.NumberUtils.moneda(orden.getTotalTotal()))),format.raw/*387.79*/("""</b></h4>	
							</td>
							<td>
								
							</td>
						</tr>
						
							
					</tbody>
				</table>
					
				
			</div>
		</div>
	
	""")))}/*402.3*/else/*402.7*/{_display_(Seq[Any](format.raw/*402.8*/("""
		<h4>Base: 	<b>"""),_display_(Seq[Any](/*403.18*/utils/*403.23*/.NumberUtils.moneda(orden.getTotal()))),format.raw/*403.60*/("""</b></h4>	
		<h4>Ajuste: <b>"""),_display_(Seq[Any](/*404.19*/utils/*404.24*/.NumberUtils.moneda(orden.getTotalAjuste()))),format.raw/*404.67*/("""</b></h4>	
		<h4>Total: 	<b>"""),_display_(Seq[Any](/*405.19*/utils/*405.24*/.NumberUtils.moneda(orden.getTotalTotal()))),format.raw/*405.66*/("""</b></h4>	
	""")))})),format.raw/*406.3*/("""
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*407.26*/orden/*407.31*/.estado.nombre)),format.raw/*407.45*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*409.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(orden.estado.orden,models.Estado.TIPO_ORDEN)) yield /*409.106*/ {_display_(Seq[Any](format.raw/*409.108*/("""	
			"""),_display_(Seq[Any](/*410.5*/if(estado.orden <= 5)/*410.26*/ {_display_(Seq[Any](format.raw/*410.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*412.16*/controllers/*412.27*/.compras.routes.OrdenesController.cambiarEstado(ordenForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*412.128*/UriTrack/*412.136*/.get("&"))),format.raw/*412.145*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*413.56*/estado/*413.62*/.nombre)),format.raw/*413.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*417.5*/("""
		""")))})),format.raw/*418.4*/("""
		"""),_display_(Seq[Any](/*419.4*/if(orden.estado.id == models.Estado.ORDEN_ESTADO_CANCELADO)/*419.63*/ {_display_(Seq[Any](format.raw/*419.65*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*421.15*/controllers/*421.26*/.compras.routes.OrdenesController.cambiarEstado(ordenForm.field("id").value.toInt, models.Estado.ORDEN_ESTADO_BORRADOR))),_display_(Seq[Any](/*421.146*/UriTrack/*421.154*/.get("&"))),format.raw/*421.163*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*425.4*/else/*425.8*/{_display_(Seq[Any](format.raw/*425.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*427.15*/controllers/*427.26*/.compras.routes.OrdenesController.cambiarEstado(ordenForm.field("id").value.toInt, models.Estado.ORDEN_ESTADO_CANCELADO))),_display_(Seq[Any](/*427.147*/UriTrack/*427.155*/.get("&"))),format.raw/*427.164*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Orden
				</a>
			</div>
		""")))})),format.raw/*431.4*/("""
	</div>
<script>
$( function()"""),format.raw/*434.14*/("""{"""),format.raw/*434.15*/("""
	$('.reporteOrdenProvision').click( function() """),format.raw/*435.48*/("""{"""),format.raw/*435.49*/(""" 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		dialogo.dialog("""),format.raw/*439.18*/("""{"""),format.raw/*439.19*/("""
			title: "Report Orden de Provision",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: """),format.raw/*446.19*/("""{"""),format.raw/*446.20*/("""
		          Cerrar: function() """),format.raw/*447.32*/("""{"""),format.raw/*447.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*449.13*/("""}"""),format.raw/*449.14*/("""
		    """),format.raw/*450.7*/("""}"""),format.raw/*450.8*/(""",
	    	close: function(event, ui )"""),format.raw/*451.34*/("""{"""),format.raw/*451.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*453.7*/("""}"""),format.raw/*453.8*/(""",
		    open: function( event, ui ) """),format.raw/*454.35*/("""{"""),format.raw/*454.36*/("""
				$.post(url, function(data)"""),format.raw/*455.31*/("""{"""),format.raw/*455.32*/("""
					dialogo.html(data);
				"""),format.raw/*457.5*/("""}"""),format.raw/*457.6*/(""");	
		    """),format.raw/*458.7*/("""}"""),format.raw/*458.8*/("""
	    """),format.raw/*459.6*/("""}"""),format.raw/*459.7*/(""");
	"""),format.raw/*460.2*/("""}"""),format.raw/*460.3*/(""");
"""),format.raw/*461.1*/("""}"""),format.raw/*461.2*/(""");
</script>	
""")))})),format.raw/*463.2*/("""


"""))}
    }
    
    def render(ordenForm:Form[Orden],orden:Orden,op:OrdenProvision,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(ordenForm,orden,op,paginadorFicha)
    
    def f:((Form[Orden],Orden,OrdenProvision,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (ordenForm,orden,op,paginadorFicha) => apply(ordenForm,orden,op,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/verOrden.scala.html
                    HASH: d0828bbb83943c248c971a25d75475fc4eaece50
                    MATRIX: 851->1|1090->287|1104->294|1188->298|1240->315|1254->321|1319->365|1387->167|1419->191|1494->106|1523->235|1561->239|1583->253|1633->282|1664->402|1704->407|1717->412|1778->464|1818->466|1966->578|2003->606|2051->608|2091->639|2130->640|2257->730|2708->1146|2765->1194|2805->1196|2915->1270|2935->1281|3037->1360|3115->1407|3158->1415|3213->1461|3253->1463|3399->1573|3419->1584|3507->1650|3597->1709|3642->1719|3693->1761|3733->1763|3892->1886|3912->1897|4021->1983|4103->2034|4146->2042|4205->2092|4245->2094|4400->2213|4420->2224|4528->2309|4623->2373|4668->2383|4716->2422|4756->2424|4865->2497|4885->2508|4972->2573|5048->2618|5093->2628|5160->2686|5200->2688|5354->2806|5374->2817|5477->2897|5563->2951|5915->3268|5971->3315|6011->3317|6168->3437|6189->3448|6288->3524|6472->3671|6493->3682|6587->3753|6665->3799|6713->3811|6770->3859|6810->3861|6968->3982|6989->3993|7089->4070|7271->4215|7292->4226|7383->4294|7450->4329|7522->4365|7562->4396|7602->4398|7750->4509|7771->4520|7861->4587|7924->4619|8043->4702|8063->4713|8135->4755|8152->4763|8183->4772|8331->4885|8419->4964|8459->4966|8631->5102|8645->5107|8670->5110|8823->5232|8895->5269|8908->5274|8955->5299|9203->5510|9224->5521|9297->5563|9315->5571|9347->5580|9481->5677|9502->5688|9584->5739|9602->5747|9634->5756|9764->5849|9785->5860|9869->5913|9887->5921|9919->5930|10056->6030|10077->6041|10161->6094|10179->6102|10211->6111|10410->6274|10461->6315|10501->6316|10604->6382|10644->6412|10674->6418|10719->6431|10797->6473|10821->6487|10861->6488|10914->6504|10935->6515|11014->6571|11053->6573|11071->6581|11104->6590|11239->6693|11291->6708|11309->6716|11411->6794|11527->6874|11577->6914|11617->6915|11688->6950|11726->6978|11767->6980|11834->7010|11855->7021|11955->7089|11974->7097|12007->7106|12123->7190|12240->7270|12264->7284|12305->7301|12348->7306|12373->7320|12415->7338|12461->7348|12499->7376|12540->7378|12607->7408|12628->7419|12728->7487|12747->7495|12780->7504|12897->7589|12946->7606|13076->7699|13101->7714|13130->7720|13318->7871|13333->7876|13363->7883|13582->8065|13622->8094|13652->8100|13832->8243|13866->8267|13895->8273|14041->8382|14117->8434|14220->8500|14273->8543|14302->8549|14478->8688|14515->8715|14544->8721|14744->8884|14781->8911|14830->8913|14845->8918|14895->8940|15060->9068|15105->9103|15134->9109|15296->9234|15334->9262|15363->9268|15560->9428|15598->9456|15627->9462|15823->9622|15863->9652|15879->9658|15895->9664|15906->9673|15933->9690|15974->9692|16008->9714|16038->9734|16079->9736|16117->9762|16151->9786|16192->9788|16230->9814|16262->9836|16303->9838|16335->9858|16375->9888|16416->9890|16456->9918|16492->9944|16533->9946|16572->9976|16591->9985|16617->9995|16843->10185|16876->10208|16892->10214|16908->10220|16919->10229|16944->10244|16985->10246|17040->10289|17068->10307|17109->10309|17168->10356|17196->10374|17237->10376|17286->10413|17325->10442|17366->10444|17419->10485|17454->10510|17495->10512|17557->10562|17582->10577|17623->10579|17675->10619|17705->10639|17746->10641|17803->10686|17840->10713|17881->10715|17940->10762|17959->10771|17985->10781|18189->10949|18279->11016|18461->11162|18537->11215|18719->11360|18757->11388|18806->11390|18821->11395|18868->11414|19079->11588|19114->11613|19143->11619|19326->11765|19358->11787|19387->11793|19584->11953|19620->11979|19649->11985|19903->12203|19941->12231|19981->12232|20026->12241|20041->12246|20082->12264|20122->12272|20351->12465|20392->12496|20432->12497|20477->12506|20492->12511|20536->12532|20576->12540|20809->12737|20845->12763|20874->12769|21178->13037|21193->13042|21260->13086|21512->13302|21551->13331|21592->13333|21638->13343|21664->13359|21716->13388|21763->13399|21778->13404|21840->13443|21881->13452|22179->13714|22220->13745|22249->13751|22483->13949|22519->13975|22548->13981|22629->14026|22679->14066|22719->14067|22916->14227|22931->14232|22978->14255|23042->14287|23085->14294|23136->14335|23176->14336|23374->14497|23389->14502|23437->14526|23501->14558|23541->14562|23555->14567|23627->14616|23670->14623|23767->14710|23807->14711|24186->15053|24201->15058|24261->15095|24360->15157|24375->15162|24459->15223|24620->15347|24635->15352|24725->15418|24833->15489|24848->15494|24962->15584|25123->15708|25138->15713|25227->15778|25326->15840|25341->15845|25448->15928|25605->16048|25620->16053|25710->16119|25917->16289|25932->16294|25997->16336|26177->16497|26190->16501|26229->16502|26285->16521|26300->16526|26360->16563|26427->16593|26442->16598|26508->16641|26575->16671|26590->16676|26655->16718|26701->16732|26765->16759|26780->16764|26817->16778|26905->16830|27025->16932|27067->16934|27110->16941|27141->16962|27182->16964|27264->17009|27285->17020|27418->17121|27437->17129|27470->17138|27610->17241|27626->17247|27656->17254|27723->17289|27760->17294|27801->17299|27870->17358|27911->17360|27991->17403|28012->17414|28164->17534|28183->17542|28216->17551|28379->17695|28392->17699|28431->17700|28511->17743|28532->17754|28685->17875|28704->17883|28737->17892|28909->18032|28972->18066|29002->18067|29080->18116|29110->18117|29237->18215|29267->18216|29450->18370|29480->18371|29542->18404|29572->18405|29661->18465|29691->18466|29727->18474|29756->18475|29821->18511|29851->18512|29924->18557|29953->18558|30019->18595|30049->18596|30110->18628|30140->18629|30200->18661|30229->18662|30268->18673|30297->18674|30332->18681|30361->18682|30394->18687|30423->18688|30455->18692|30484->18693|30533->18710
                    LINES: 26->1|33->8|33->8|35->8|36->9|36->9|36->9|37->5|37->5|38->1|39->5|40->6|40->6|40->6|42->10|44->12|44->12|44->12|44->12|48->16|48->16|48->16|48->16|48->16|48->16|59->27|59->27|59->27|60->28|60->28|60->28|61->29|62->30|62->30|62->30|65->33|65->33|65->33|67->35|68->36|68->36|68->36|71->39|71->39|71->39|73->41|74->42|74->42|74->42|77->45|77->45|77->45|79->47|80->48|80->48|80->48|83->51|83->51|83->51|85->53|86->54|86->54|86->54|89->57|89->57|89->57|91->59|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|101->69|101->69|101->69|102->70|102->70|102->70|103->71|103->71|103->71|104->72|107->75|107->75|107->75|108->76|108->76|108->76|109->77|113->81|113->81|113->81|113->81|113->81|116->84|116->84|116->84|119->87|119->87|119->87|123->91|128->96|128->96|128->96|134->102|134->102|134->102|134->102|134->102|135->103|135->103|135->103|135->103|135->103|136->104|136->104|136->104|136->104|136->104|137->105|137->105|137->105|137->105|137->105|141->109|141->109|141->109|142->110|142->110|142->110|143->111|146->114|146->114|146->114|147->115|147->115|147->115|147->115|147->115|147->115|148->116|149->117|149->117|149->117|151->119|151->119|151->119|154->122|154->122|154->122|155->123|155->123|155->123|155->123|155->123|156->124|157->125|157->125|157->125|157->125|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|159->127|159->127|160->128|162->130|169->137|169->137|169->137|173->141|173->141|173->141|177->145|177->145|177->145|181->149|181->149|181->149|184->152|184->152|185->153|185->153|185->153|189->157|189->157|189->157|196->164|196->164|196->164|196->164|196->164|200->168|200->168|200->168|204->172|204->172|204->172|208->176|208->176|208->176|214->182|214->182|214->182|214->182|214->183|214->183|214->183|214->184|214->184|214->184|214->185|214->185|214->185|214->186|214->186|214->186|214->187|214->187|214->187|214->188|214->188|214->188|214->189|214->189|214->190|222->198|222->198|222->198|222->198|222->199|222->199|222->199|222->200|222->200|222->200|222->201|222->201|222->201|222->202|222->202|222->202|222->203|222->203|222->203|222->204|222->204|222->204|222->205|222->205|222->205|222->206|222->206|222->206|222->207|222->207|222->208|229->215|229->215|236->222|236->222|241->227|241->227|241->227|241->227|241->227|246->232|246->232|246->232|250->236|250->236|250->236|255->241|255->241|255->241|263->249|263->249|263->249|264->250|264->250|264->250|265->251|273->259|273->259|273->259|274->260|274->260|274->260|275->261|283->269|283->269|283->269|296->282|296->282|296->282|305->291|305->291|305->291|306->292|306->292|306->292|307->293|307->293|307->293|308->294|322->308|322->308|322->308|330->316|330->316|330->316|335->321|335->321|335->321|339->325|339->325|339->325|342->328|344->330|344->330|344->330|348->334|348->334|348->334|351->337|352->338|352->338|352->338|354->340|354->340|354->340|368->354|368->354|368->354|371->357|371->357|371->357|376->362|376->362|376->362|379->365|379->365|379->365|384->370|384->370|384->370|387->373|387->373|387->373|392->378|392->378|392->378|401->387|401->387|401->387|416->402|416->402|416->402|417->403|417->403|417->403|418->404|418->404|418->404|419->405|419->405|419->405|420->406|421->407|421->407|421->407|423->409|423->409|423->409|424->410|424->410|424->410|426->412|426->412|426->412|426->412|426->412|427->413|427->413|427->413|431->417|432->418|433->419|433->419|433->419|435->421|435->421|435->421|435->421|435->421|439->425|439->425|439->425|441->427|441->427|441->427|441->427|441->427|445->431|448->434|448->434|449->435|449->435|453->439|453->439|460->446|460->446|461->447|461->447|463->449|463->449|464->450|464->450|465->451|465->451|467->453|467->453|468->454|468->454|469->455|469->455|471->457|471->457|472->458|472->458|473->459|473->459|474->460|474->460|475->461|475->461|477->463
                    -- GENERATED --
                */
            