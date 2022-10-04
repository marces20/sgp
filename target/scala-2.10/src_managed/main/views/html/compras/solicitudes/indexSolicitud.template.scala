
package views.html.compras.solicitudes

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
object indexSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[Solicitud],DynamicForm,String,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Solicitud], formBuscador: DynamicForm,searchIndex: String, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/compras/solicitudes.js"))),format.raw/*6.70*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*9.2*/getTotal/*9.10*/(lista:List[Solicitud]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(l <- lista){
		if(l.total != null)
			total = l.total.add(total)
	}
	total
}};def /*19.2*/getClassEstado/*19.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 1){
		classEstado = "borrador"
	}else if(i != null && i.id == 6){
		classEstado = "cancelada"
	}else if(i != null && i.id == 5){
		classEstado = "autorizado"
	}else if(i != null && i.id == 83){
		classEstado = "reservadoStockSolicitud"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""

"""),format.raw/*16.2*/("""


"""),format.raw/*32.2*/("""

"""),_display_(Seq[Any](/*34.2*/views/*34.7*/.html.compras.mainCompras("Lista Solicitudes", scripts)/*34.62*/ {_display_(Seq[Any](format.raw/*34.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Solicitudes</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*49.9*/if(!Permiso.check("noVerPrecios"))/*49.43*/ {_display_(Seq[Any](format.raw/*49.45*/("""	
				    <!--<li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Solicitud de compra</a></li> -->
				    <li role="presentation"><a role="menuitem" id="reporteImputacionPreventiva" data-url=""""),_display_(Seq[Any](/*51.96*/controllers/*51.107*/.compras.routes.SolicitudesReportesController.reporteImputacionPreventivaLista())),format.raw/*51.187*/("""" tabindex="-1" href="#">Imputaci&oacute;n preventiva</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteCuadroSolicitud" data-url=""""),_display_(Seq[Any](/*52.91*/controllers/*52.102*/.compras.routes.SolicitudesReportesController.reporteCuadroSolicitud())),format.raw/*52.172*/("""" tabindex="-1" href="#">Cuadro Solicitud</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteLineasCotizacion" data-url=""""),_display_(Seq[Any](/*53.92*/controllers/*53.103*/.compras.routes.SolicitudesReportesController.reporteLineasCotizacion(1))),format.raw/*53.175*/("""" tabindex="-1" href="#">Exporta Lineas Cotizacion</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteLineasCotizacionResumido" data-url=""""),_display_(Seq[Any](/*54.100*/controllers/*54.111*/.compras.routes.SolicitudesReportesController.reporteLineasCotizacion(2))),format.raw/*54.183*/("""" tabindex="-1" href="#">Exporta Lineas Cotizacion Resumido</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteLineasCotizacionResumido" data-url=""""),_display_(Seq[Any](/*55.100*/controllers/*55.111*/.compras.routes.SolicitudesReportesController.reporteLineasCotizacion(3))),format.raw/*55.183*/("""" tabindex="-1" href="#">Exporta Lineas Cotizacion Resumido Con Precio</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteInformeFarmacia" data-url=""""),_display_(Seq[Any](/*56.91*/controllers/*56.102*/.compras.routes.SolicitudesReportesController.modalInformeFarmacia())),format.raw/*56.170*/("""" tabindex="-1" href="#">Informe Farmacia</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteInformeFarmaciaPorUsuario" data-url=""""),_display_(Seq[Any](/*57.101*/controllers/*57.112*/.compras.routes.SolicitudesReportesController.modalInformeFarmaciaPorUsuario())),format.raw/*57.190*/("""" tabindex="-1" href="#">Informe Farmacia Por Usuario</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteInformeFarmaciaPaciente" data-url=""""),_display_(Seq[Any](/*58.99*/controllers/*58.110*/.compras.routes.SolicitudesReportesController.informeFarmaciaPaciente())),format.raw/*58.181*/("""" tabindex="-1" href="#">Informe Farmacia Pacientes/Servicios</a></li>
				    """)))})),format.raw/*59.10*/("""											   																										 
				    <!-- <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Informe de ajuste preventiva</a></li> -->
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<!--<li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Importar precios de productos</a></li>-->
				    """),_display_(Seq[Any](/*72.10*/if(Permiso.check("solicitudesComprasEditarCuentaAnalitica"))/*72.70*/ {_display_(Seq[Any](format.raw/*72.72*/("""
				    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*73.114*/controllers/*73.125*/.compras.routes.SolicitudesController.modalEditarCuentaAnalica())),format.raw/*73.189*/("""">Editar cuenta analitica</a></li>
				    """)))})),format.raw/*74.10*/("""
				    
				   """),_display_(Seq[Any](/*76.9*/if(Permiso.check("solicitudesAprobacionMasiva"))/*76.57*/ {_display_(Seq[Any](format.raw/*76.59*/("""
				   <li role="presentation"><a role="menuitem" id="accionPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*77.110*/controllers/*77.121*/.compras.routes.SolicitudAccionesController.modalPasarAprobadoPorPresupuesto())),format.raw/*77.199*/("""">Pasar a Aprobado por Presupuesto</a></li>
				   <li role="presentation"><a role="menuitem" id="accionPasarAutorizado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*78.112*/controllers/*78.123*/.compras.routes.SolicitudAccionesController.modalPasarAutorizado())),format.raw/*78.189*/("""">Pasar a Autorizado</a></li>	
				   """)))})),format.raw/*79.9*/("""  
				   
				   """),_display_(Seq[Any](/*81.9*/if(Permiso.check("asignarUsuarios"))/*81.45*/ {_display_(Seq[Any](format.raw/*81.47*/("""
					   <li role="presentation">
					    	<a role="menuitem" tabindex="-1" href="#" id="asignarUsuario" 
					    		data-url=""""),_display_(Seq[Any](/*84.23*/controllers/*84.34*/.compras.routes.SolicitudAccionesController.modalAsignarUsuario(0))),format.raw/*84.100*/("""">Asignar Usuario</a></li>
					""")))})),format.raw/*85.7*/("""
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*90.16*/controllers/*90.27*/.compras.routes.SolicitudesController.crearSolicitud(searchIndex))),format.raw/*90.92*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Solicitud</a>
				</div>
			</div>
			
		</div>
	</div>
			
	"""),_display_(Seq[Any](/*97.3*/if(flash.containsKey("success"))/*97.35*/ {_display_(Seq[Any](format.raw/*97.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*98.81*/flash/*98.86*/.get("success"))),format.raw/*98.101*/("""</div>
	""")))})),format.raw/*99.3*/("""
	"""),_display_(Seq[Any](/*100.3*/if(flash.containsKey("error"))/*100.33*/ {_display_(Seq[Any](format.raw/*100.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*101.84*/flash/*101.89*/.get("error"))),format.raw/*101.102*/("""</div>
	""")))})),format.raw/*102.3*/("""

	<div id="actions">
		<form action="" method="GET">

			<div class="row">
			
				<div class="col-sm-2">
					<label class="control-label">Referencia
					"""),_display_(Seq[Any](/*111.7*/inputText(formBuscador("referencia"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*111.97*/("""
					</label>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Pedido Rismi
					"""),_display_(Seq[Any](/*117.7*/inputText(formBuscador("pedido_rismi"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*117.99*/("""
					</label>
				</div>

				<div class="col-sm-2 input-group">
					<label for="desde" class="control-label">Fecha de solicitud</label>
					<div>
					"""),_display_(Seq[Any](/*124.7*/inputText(formBuscador("desde"), 
							  'class -> "form-control inputDateMascara", 
							  'id -> "desde", 
							  'placeholder -> "Desde"))),format.raw/*127.34*/("""
					"""),_display_(Seq[Any](/*128.7*/inputText(formBuscador("hasta"), 
					 		   'class -> "form-control inputDateMascara", 
					 		   'id -> "hasta", 
					 		   'placeholder -> "Hasta"))),format.raw/*131.36*/("""
					 		   
					 		   
					</div>
					
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Responsable
						<div class="input-group">
							"""),_display_(Seq[Any](/*141.9*/inputText(formBuscador("responsable_id"), 'hidden -> "hidden", 'id -> "responsable_id"))),format.raw/*141.96*/("""
							"""),_display_(Seq[Any](/*142.9*/inputText(formBuscador("usuario"), 'name -> "", 'class -> "form-control", 'id -> "responsable"))),format.raw/*142.104*/("""
							<span class="input-group-addon">
							<a href="#" id="searchResponsable" 
										data-title="Selección de responsables" 
										data-url=""""),_display_(Seq[Any](/*146.22*/controllers/*146.33*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*146.88*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.usuario.simple" 
										data-label="#responsable" 
										data-field="#responsable_id">
							<i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</label>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Paciente
						<div class="input-group">
							"""),_display_(Seq[Any](/*160.9*/inputText(formBuscador("paciente_id"), 'hidden -> "hidden", 'id -> "paciente_id"))),format.raw/*160.90*/("""
							"""),_display_(Seq[Any](/*161.9*/inputText(formBuscador("paciente"), 'class -> "form-control", 'id -> "paciente"))),format.raw/*161.89*/("""
							<span class="input-group-addon"><a href="#" id="searchPaciente" data-title="Selección de responsables" data-url=""""),_display_(Seq[Any](/*162.122*/controllers/*162.133*/.compras.routes.ClientesController.modalBuscar())),format.raw/*162.181*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.cliente.simple" data-label="#paciente" data-field="#paciente_id"><i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</label>
				</div>

				<div class="col-sm-2">
					<label class="control-label">Servicio
						<div class="input-group">
							"""),_display_(Seq[Any](/*170.9*/inputText(formBuscador("servicio_id"), 'hidden -> "hidden", 'id -> "servicio_id"))),format.raw/*170.90*/("""
							"""),_display_(Seq[Any](/*171.9*/inputText(formBuscador("servicio"), 'class -> "form-control"))),format.raw/*171.70*/("""
							<span class="input-group-addon"><a href="#" id="searchServicio" data-title="Selección de servicio" data-url=""""),_display_(Seq[Any](/*172.118*/controllers/*172.129*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*172.179*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.departamento.simple" data-label="#servicio" data-field="#servicio_id"><i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</label>
				</div>
			</div>		
			
			<div class="row">
				<div class="col-sm-2">
					<label class="control-label">Solicitante
						<div class="input-group">
							"""),_display_(Seq[Any](/*182.9*/inputText(formBuscador("solicitante_id"), 'hidden -> "hidden", 'id -> "solicitante_id"))),format.raw/*182.96*/("""
							"""),_display_(Seq[Any](/*183.9*/inputText(formBuscador("solicitante"), 'name -> "", 'class -> "form-control", 'id -> "solicitante"))),format.raw/*183.108*/("""
							<span class="input-group-addon">
							<a href="#" id="searchResponsable" 
										data-title="Selección de solicitante" 
										data-url=""""),_display_(Seq[Any](/*187.22*/controllers/*187.33*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*187.88*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.usuario.simple" 
										data-label="#solicitante" 
										data-field="#solicitante_id">
							<i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</label>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Expediente
						<div class="input-group">
							"""),_display_(Seq[Any](/*201.9*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*201.94*/("""
							"""),_display_(Seq[Any](/*202.9*/inputText(formBuscador("expediente"), 'class -> "form-control", 'id -> "expediente"))),format.raw/*202.93*/("""
							<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*203.122*/controllers/*203.133*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*203.187*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</label>
				</div>
				
				<div class="col-sm-4">
					<label for="producto_nombre" class="control-label">Producto</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*211.8*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*211.122*/("""
						"""),_display_(Seq[Any](/*212.8*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*212.89*/("""
						<span class="input-group-addon"><a href="#" id="searchProducto" 
																	data-title="Selección de producto" 
																	data-url=""""),_display_(Seq[Any](/*215.29*/controllers/*215.40*/.compras.routes.ProductosController.modalBuscar())),format.raw/*215.89*/("""" 
																	data-height="650" 
																	data-width="700" 
																	data-listen="modal.seleccion.producto.simple" 
																	data-label="#producto" data-field="#producto_id">
																	<i class="glyphicon glyphicon-search"></i></a></span>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*225.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*225.166*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						RECU
						"""),_display_(Seq[Any](/*231.8*/select(formBuscador("recuperable"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*231.114*/("""
					</label>
				</div>
			</div>	
			<div class="row">
				<div class="col-sm-2">
					<label class="control-label">Estado
						"""),_display_(Seq[Any](/*238.8*/select(formBuscador("estado"), Estado.getEstados(models.Estado.TIPO_SOLICITUD).map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*238.186*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">N° Liquidación
						"""),_display_(Seq[Any](/*244.8*/inputText(formBuscador("nro_liquidacion_parque"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*244.110*/("""
						</label>
					</div>
				</div>
				
				<div class="col-sm-4">
					<label for="cuenta" class="control-label">Cuenta Presupuestaria Padre</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*252.8*/inputText(formBuscador("cuenta"), 'class -> "form-control", 'id -> "cuentaAnaliticaHija"))),format.raw/*252.97*/("""
						"""),_display_(Seq[Any](/*253.8*/inputText(formBuscador("cuenta_analitica_padre_id"), 'hidden -> "hidden", 'id -> "cuentaAnaliticaHija_id"))),format.raw/*253.114*/("""
						<span class="input-group-addon">
							<a href="#" 
							   id="searchCuentaAnalitica" 
							   class="searchModal"
							   data-title="Selección de cuenta analítica" 
							   data-url=""""),_display_(Seq[Any](/*259.22*/controllers/*259.33*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*259.95*/("""" 
							   data-height="650" 
							   data-width="700" 
							   data-listen="modal.seleccion.cuentaAnalitica.simple" 
							   data-label="#cuentaAnaliticaHija" 
							   data-field="#cuentaAnaliticaHija_id">
							   <i class="glyphicon glyphicon-search"></i>
							 </a>
						</span>
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label for="desde" class="control-label">Fecha de preventiva</label>
					<div>
					"""),_display_(Seq[Any](/*273.7*/inputText(formBuscador("fdesdepreventiva"), 
							  'class -> "form-control inputDateMascara", 
							  'id -> "fdesdepreventiva", 
							  'placeholder -> "Desde"))),format.raw/*276.34*/("""
					"""),_display_(Seq[Any](/*277.7*/inputText(formBuscador("fhastapreventiva"), 
					 		   'class -> "form-control inputDateMascara", 
					 		   'id -> "fhastapreventiva", 
					 		    
					 		   'placeholder -> "Hasta"))),format.raw/*281.36*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<label for="obpaciente" class="control-label">Obra Social Pac.</label>
					<div class="input-group"> 
						"""),_display_(Seq[Any](/*287.8*/inputText(formBuscador("obrasocial.nombre"),'class -> "form-control", 'id -> "obrasocial", 'autocomplete -> "off"))),format.raw/*287.122*/("""
						"""),_display_(Seq[Any](/*288.8*/inputText(formBuscador("obrasocial_id"),'hidden -> "hidden", 'id -> "obrasocial_id"))),format.raw/*288.92*/("""
						<span class="input-group-addon">
							<a href="#" id="searchObraSocial" 
							data-title="Selección de obra social" 
							data-url=""""),_display_(Seq[Any](/*292.19*/controllers/*292.30*/.compras.routes.ObrasSocialesController.modalBuscar())),format.raw/*292.83*/("""" 
							data-height="650" data-width="700" 
							data-listen="modal.seleccion.ob.simple" 
							data-label="#obrasocial" data-field="#obrasocial_id"><i class="glyphicon glyphicon-search"></i></a>
						</span>
					</div>
				</div>
			</div>
			
			
					
			
			<div class="row">	
			
				<div class="col-sm-2">
					<label for="paciente" class="control-label">Usuario Asignado</label> 
						<div class="input-group">
						"""),_display_(Seq[Any](/*309.8*/inputText(formBuscador("asignacion_usuario.nombre"),'class -> "form-control", 'id -> "user2", 'autocomplete -> "off"))),format.raw/*309.125*/("""
						"""),_display_(Seq[Any](/*310.8*/inputText(formBuscador("asignacion_usuario_id"),'hidden -> "hidden", 'id -> "user_id2"))),format.raw/*310.95*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchUser2" 
										data-title="Selección de Usuario" 
										data-url=""""),_display_(Seq[Any](/*315.22*/controllers/*315.33*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*315.88*/(""""
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.usuario.simple"
										data-label="#user2" 
										data-field="#user_id2">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
				 
					</div>
				</div>
				<div class="col-sm-3">
					<div class="col-sm-6">
						<label class="control-label"> 
							<!--PROFE
							"""),_display_(Seq[Any](/*331.9*/select(formBuscador("profe"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*331.109*/("""-->
							Tipo Cuenta
							"""),_display_(Seq[Any](/*333.9*/select(formBuscador("tipo_cuenta_id"), 
							TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*334.129*/("""
						</label>
					</div>
				
					<div class="col-sm-6">
						<label class="control-label"> 
							Repo Stock
							"""),_display_(Seq[Any](/*341.9*/select(formBuscador("repo_stock"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*341.114*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-3">
				
					<div class="col-sm-6">
						<label class="control-label"> 
							Emergencia
							"""),_display_(Seq[Any](/*350.9*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*350.114*/("""
						</label>
					</div>
					
					<div class="col-sm-6">
						<label class="control-label"> 
							Entregado
							"""),_display_(Seq[Any](/*357.9*/select(formBuscador("entregado"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*357.113*/("""
						</label>
					</div>
				</div>
				
				
				
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*373.16*/controllers/*373.27*/.compras.routes.SolicitudesController.index())),format.raw/*373.72*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		
		</form>
	</div>

	"""),_display_(Seq[Any](/*382.3*/if(buscador.getTotalRowCount == 0)/*382.37*/ {_display_(Seq[Any](format.raw/*382.39*/("""
        
        <div class="well">
            <em>No se encuentran Solicitudes</em>
        </div>
        
    """)))}/*388.7*/else/*388.12*/{_display_(Seq[Any](format.raw/*388.13*/("""
    	<div class="row">
    		<div class="col-sm-12">
			<table id="listadoSolicitud" class="table table-striped table-bordered table-hover listadoSolicitud">
				<thead>
					<tr style="background: #FFFFFF;">
						
				        <td colspan="11">Mostrando """),_display_(Seq[Any](/*395.41*/buscador/*395.49*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*395.81*/(""" resultado(s).</td>
				        """),_display_(Seq[Any](/*396.14*/if(!Permiso.check("noVerPrecios"))/*396.48*/ {_display_(Seq[Any](format.raw/*396.50*/("""
				        <td><b>Total:</b> <span class="baseFooter"></span></td>
				        <td><b>Total:</b> <span class="ajusteFooter"></span></td>
				        <td><b>Total:</b> <span class="totalFooter"></span></td>
				        <td colspan="2">&nbsp</td>
				        """)))}/*401.14*/else/*401.18*/{_display_(Seq[Any](format.raw/*401.19*/("""
				        <td colspan="5">&nbsp</td>
				        """)))})),format.raw/*403.14*/("""
			        </tr>
					<tr>
						<th><input type="checkbox" name="checkAll" id="checkAll"/></th>
						<th>#</th>
						<th>Referencia</th>
						<th>Ref. Sigpar</th>
						<th>Responsable</th>
						<th>Fecha de Solicitud</th>
						<th>Expediente</th>
						<th>Servicio</th>
						<th>Paciente</th>
						<th>Medico Solicitante</th>
						<!--<th>PROFE</th>-->
						<th>Tipo Cuenta</th> 
						<th>Base</th>
						<th>Ajuste</th>
						<th>Total</th>
						<th>Estado</th>
						<th>#</th> 
					</tr>
				</thead>
				<tbody>
				"""),_display_(Seq[Any](/*426.6*/for(solicitud <- buscador.getList) yield /*426.40*/ {_display_(Seq[Any](format.raw/*426.42*/("""
					"""),_display_(Seq[Any](/*427.7*/paginadorFicha/*427.21*/.add(solicitud.id.toString))),format.raw/*427.48*/("""
					 <tr class="pointer """),_display_(Seq[Any](/*428.27*/getClassEstado(solicitud.estado))),format.raw/*428.59*/("""" data-estado=""""),_display_(Seq[Any](/*428.75*/solicitud/*428.84*/.estado_id)),format.raw/*428.94*/("""" data-href=""""),_display_(Seq[Any](/*428.108*/controllers/*428.119*/.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex))),format.raw/*428.186*/(""""> 
						<td>
							<input type="checkbox" name="check_listado[]" class="notSeleccion" value=""""),_display_(Seq[Any](/*430.83*/solicitud/*430.92*/.id)),format.raw/*430.95*/("""" id="check-"""),_display_(Seq[Any](/*430.108*/solicitud/*430.117*/.id)),format.raw/*430.120*/(""""/>
						</td>
						<td>
							<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*433.62*/controllers/*433.73*/.compras.routes.SolicitudesController.editar(solicitud.id,searchIndex))),format.raw/*433.143*/("""">
								<i class="glyphicon glyphicon-edit"></i>
							</a>
						</td>
						<td align="center">
							"""),_display_(Seq[Any](/*438.9*/(solicitud.referencia))),format.raw/*438.31*/("""
							 """),_display_(Seq[Any](/*439.10*/if(solicitud.tipoCuenta != null)/*439.42*/{_display_(Seq[Any](format.raw/*439.43*/("""
								"""),_display_(Seq[Any](/*440.10*/if(solicitud.tipoCuenta.nombre == "PROFE")/*440.52*/{_display_(Seq[Any](format.raw/*440.53*/("""
									<span style="color:red;font-weight: bold;font-size:14px; ">PROFE</span></br>
								""")))})),format.raw/*442.10*/("""
							""")))})),format.raw/*443.9*/(""" 
							<!--"""),_display_(Seq[Any](/*444.13*/if(solicitud.profe != null && solicitud.profe)/*444.59*/{_display_(Seq[Any](format.raw/*444.60*/("""
								<span style="color:red;font-weight: bold;font-size:14px; ">PROFE</span></br>
							""")))})),format.raw/*446.9*/("""-->
							
							"""),_display_(Seq[Any](/*448.9*/if(solicitud.recuperable != null && solicitud.recuperable)/*448.67*/{_display_(Seq[Any](format.raw/*448.68*/("""
								<span style="color:orange;font-weight: bold;font-size:11px; ">Recuperable</span>
							""")))})),format.raw/*450.9*/("""
							"""),_display_(Seq[Any](/*451.9*/if(solicitud.expediente != null)/*451.41*/{_display_(Seq[Any](format.raw/*451.42*/("""
								"""),_display_(Seq[Any](/*452.10*/if(solicitud.expediente.emergencia)/*452.45*/{_display_(Seq[Any](format.raw/*452.46*/("""
									<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
								""")))})),format.raw/*454.10*/("""
							""")))})),format.raw/*455.9*/("""
							"""),_display_(Seq[Any](/*456.9*/if(solicitud.entregado != null && solicitud.entregado)/*456.63*/{_display_(Seq[Any](format.raw/*456.64*/("""
								<span class="textEntregado" style="color:green;font-weight: bold;font-size:11px; ">Entregado</span>
							""")))})),format.raw/*458.9*/("""
						</td>
						<td>"""),_display_(Seq[Any](/*460.12*/(solicitud.referencia_sigpar))),format.raw/*460.41*/("""</td>
						<td>
							"""),_display_(Seq[Any](/*462.9*/if(solicitud.asignacion_usuario_id != null)/*462.52*/{_display_(Seq[Any](format.raw/*462.53*/("""
								"""),_display_(Seq[Any](/*463.10*/solicitud/*463.19*/.asignacion_usuario.nombre)),format.raw/*463.45*/("""
							""")))}/*464.9*/else/*464.13*/{_display_(Seq[Any](format.raw/*464.14*/("""
								"""),_display_(Seq[Any](/*465.10*/if(solicitud.usuario != null)/*465.39*/{_display_(Seq[Any](_display_(Seq[Any](/*465.41*/solicitud/*465.50*/.usuario.nombre))))})),format.raw/*465.66*/("""
							""")))})),format.raw/*466.9*/("""
						</td>
						<td>"""),_display_(Seq[Any](/*468.12*/if(solicitud.date_start != null)/*468.44*/{_display_(Seq[Any](_display_(Seq[Any](/*468.46*/(utils.DateUtils.formatDate(solicitud.date_start))))))})),format.raw/*468.97*/("""</td>
						<td>"""),_display_(Seq[Any](/*469.12*/if(solicitud.expediente != null)/*469.44*/{_display_(Seq[Any](_display_(Seq[Any](/*469.46*/(solicitud.expediente.getExpedienteEjercicio())))))})),format.raw/*469.94*/("""</td>
						<td>"""),_display_(Seq[Any](/*470.12*/if(solicitud.departamento != null)/*470.46*/{_display_(Seq[Any](_display_(Seq[Any](/*470.48*/solicitud/*470.57*/.departamento.nombre))))})),format.raw/*470.78*/("""</td>
						<td>"""),_display_(Seq[Any](/*471.12*/if(solicitud.cliente != null)/*471.41*/{_display_(Seq[Any](format.raw/*471.42*/("""
									"""),_display_(Seq[Any](/*472.11*/solicitud/*472.20*/.cliente.nombre)),format.raw/*472.35*/(""" 
									"""),_display_(Seq[Any](/*473.11*/if(solicitud.cliente.id_paciente_rismi != null)/*473.58*/{_display_(Seq[Any](format.raw/*473.59*/("""
											-ID: """),_display_(Seq[Any](/*474.18*/solicitud/*474.27*/.cliente.id_paciente_rismi)),format.raw/*474.53*/("""
									""")))})),format.raw/*475.11*/("""
									"""),_display_(Seq[Any](/*476.11*/if(solicitud.cliente.obrasocial != null && solicitud.cliente.obrasocial.id == 442)/*476.93*/{_display_(Seq[Any](format.raw/*476.94*/("""
										- <span style="color:red;font-size:11px;font-weight: bold;">PROFE</span>
									""")))})),format.raw/*478.11*/("""
							""")))})),format.raw/*479.9*/("""
						</td>
						<!-- <td>"""),_display_(Seq[Any](/*481.17*/solicitud/*481.26*/.origen)),format.raw/*481.33*/("""</td> -->
						<td>"""),_display_(Seq[Any](/*482.12*/if(solicitud.medico != null)/*482.40*/{_display_(Seq[Any](_display_(Seq[Any](/*482.42*/solicitud/*482.51*/.medico.apellido))))})),format.raw/*482.68*/("""</td>	
						<td align="center">
							 """),_display_(Seq[Any](/*484.10*/if(solicitud.tipoCuenta != null)/*484.42*/{_display_(Seq[Any](format.raw/*484.43*/("""
								"""),_display_(Seq[Any](/*485.10*/solicitud/*485.19*/.tipoCuenta.nombre)),format.raw/*485.37*/("""
							""")))})),format.raw/*486.9*/("""
							<!--"""),_display_(Seq[Any](/*487.13*/if(solicitud.profe != null && solicitud.profe)/*487.59*/{_display_(Seq[Any](format.raw/*487.60*/("""
								SI
							""")))}/*489.9*/else/*489.13*/{_display_(Seq[Any](format.raw/*489.14*/("""
								NO
							""")))})),format.raw/*491.9*/("""-->
						</td>
						<td class="base" rel=""""),_display_(Seq[Any](/*493.30*/solicitud/*493.39*/.getTotal())),format.raw/*493.50*/("""" >
						"""),_display_(Seq[Any](/*494.8*/if(!Permiso.check("noVerPrecios"))/*494.42*/ {_display_(Seq[Any](format.raw/*494.44*/("""
							"""),_display_(Seq[Any](/*495.9*/(utils.NumberUtils.moneda(solicitud.getTotal())))),format.raw/*495.57*/("""
						""")))})),format.raw/*496.8*/("""
						</td>
						<td class="ajuste" rel=""""),_display_(Seq[Any](/*498.32*/solicitud/*498.41*/.getTotalAjuste())),format.raw/*498.58*/("""" >
						"""),_display_(Seq[Any](/*499.8*/if(!Permiso.check("noVerPrecios"))/*499.42*/ {_display_(Seq[Any](format.raw/*499.44*/("""	
							"""),_display_(Seq[Any](/*500.9*/(utils.NumberUtils.moneda(solicitud.getTotalAjuste())))),format.raw/*500.63*/("""
						""")))})),format.raw/*501.8*/("""	
						</td>
						<td class="total" rel=""""),_display_(Seq[Any](/*503.31*/solicitud/*503.40*/.getTotalTotal())),format.raw/*503.56*/("""" >
						"""),_display_(Seq[Any](/*504.8*/if(!Permiso.check("noVerPrecios"))/*504.42*/ {_display_(Seq[Any](format.raw/*504.44*/("""	
							"""),_display_(Seq[Any](/*505.9*/(utils.NumberUtils.moneda(solicitud.getTotalTotal())))),format.raw/*505.62*/("""
						""")))})),format.raw/*506.8*/("""	
						</td>
						<td class="estado">"""),_display_(Seq[Any](/*508.27*/if(solicitud.estado != null)/*508.55*/{_display_(Seq[Any](_display_(Seq[Any](/*508.57*/solicitud/*508.66*/.estado.nombre))))})),format.raw/*508.81*/("""</td>
						<td>
							<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*510.82*/controllers/*510.93*/.compras.routes.SolicitudesController.eliminar(solicitud.id,searchIndex))),format.raw/*510.165*/("""">
								<i class="glyphicon glyphicon-trash icono-eliminar"></i>
							</a>
							"""),_display_(Seq[Any](/*513.9*/if(Permiso.check("solicitudEntregado"))/*513.48*/ {_display_(Seq[Any](format.raw/*513.50*/("""
							<br/><br/>
							<a class="btn btn-default btn-xs notSeleccion entregado"  
								data-url=""""),_display_(Seq[Any](/*516.20*/controllers/*516.31*/.compras.routes.SolicitudesController.modificarEntregado(solicitud.id))),format.raw/*516.101*/("""">
								<i class="glyphicon glyphicon-plus """),_display_(Seq[Any](/*517.45*/if(solicitud.entregado != null && solicitud.entregado)/*517.99*/{_display_(Seq[Any](format.raw/*517.100*/("""text-muted glyphicon-minus""")))}/*517.128*/else/*517.133*/{_display_(Seq[Any](format.raw/*517.134*/("""text-success glyphicon-plus""")))})),format.raw/*517.162*/(""" "></i>
							</a>
							""")))})),format.raw/*519.9*/("""
						</td>
					</tr>
					
	             """)))})),format.raw/*523.16*/("""
	             """),_display_(Seq[Any](/*524.16*/paginadorFicha/*524.30*/.guardar())),format.raw/*524.40*/("""
		        </tbody>
		        <tfoot>
			        <tr>
			        	
				        <td colspan=11">Mostrando """),_display_(Seq[Any](/*529.40*/buscador/*529.48*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*529.80*/(""" resultado(s).</td>
				        """),_display_(Seq[Any](/*530.14*/if(!Permiso.check("noVerPrecios"))/*530.48*/ {_display_(Seq[Any](format.raw/*530.50*/("""
				        <td><b>Total:</b> <span class="baseFooter"></span></td>
				        <td><b>Total:</b> <span class="ajusteFooter"></span></td>
				        <td><b>Total:</b> <span class="totalFooter"></span></td>
				        <td colspan="2">&nbsp</td>
				        """)))}/*535.14*/else/*535.18*/{_display_(Seq[Any](format.raw/*535.19*/("""
				        	<td colspan="5">&nbsp</td>
				        """)))})),format.raw/*537.14*/("""
			        </tr>
				</tfoot>
	        </table>
	        </div>
    	</div>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*544.8*/views/*544.13*/.html.helpers.paginador(buscador, controllers.compras.routes.SolicitudesController.index()))),format.raw/*544.104*/("""
		</div>
<script>
$( function ()"""),format.raw/*547.15*/("""{"""),format.raw/*547.16*/("""
	
	
	
	
	$('.entregado').click( function() """),format.raw/*552.36*/("""{"""),format.raw/*552.37*/("""
		var btn = $(this);
		var url = btn.attr("data-url");
	"""),format.raw/*555.2*/("""}"""),format.raw/*555.3*/(""")
	
	
	var n = 0;
	var n2 = 0;
	var n3 = 0;
	$(".total").each(function (index) """),format.raw/*561.36*/("""{"""),format.raw/*561.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*564.2*/("""}"""),format.raw/*564.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*567.35*/("""{"""),format.raw/*567.36*/("""
		
		n2 = Number($(this).attr("rel"))+n2
	"""),format.raw/*570.2*/("""}"""),format.raw/*570.3*/(""")
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*573.37*/("""{"""),format.raw/*573.38*/("""
		
		n3 = Number($(this).attr("rel"))+n3
	"""),format.raw/*576.2*/("""}"""),format.raw/*576.3*/(""")
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*579.36*/("""{"""),format.raw/*579.37*/("""
		
		  	selectAll();
	"""),format.raw/*582.2*/("""}"""),format.raw/*582.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*583.56*/("""{"""),format.raw/*583.57*/("""
		selectTrList();
	"""),format.raw/*585.2*/("""}"""),format.raw/*585.3*/(""");
"""),format.raw/*586.1*/("""}"""),format.raw/*586.2*/(""");

function selectTrList()"""),format.raw/*588.24*/("""{"""),format.raw/*588.25*/("""
	var n = 0;
	var n2 = 0;
	var n3 = 0;
	$(".total").each(function (index) """),format.raw/*592.36*/("""{"""),format.raw/*592.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*593.77*/("""{"""),format.raw/*593.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*595.3*/("""}"""),format.raw/*595.4*/("""
	"""),format.raw/*596.2*/("""}"""),format.raw/*596.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*600.35*/("""{"""),format.raw/*600.36*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*601.77*/("""{"""),format.raw/*601.78*/("""
			n2 = Number($(this).attr("rel"))+n2
		"""),format.raw/*603.3*/("""}"""),format.raw/*603.4*/("""
	"""),format.raw/*604.2*/("""}"""),format.raw/*604.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*608.37*/("""{"""),format.raw/*608.38*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*609.77*/("""{"""),format.raw/*609.78*/("""
			n3 = Number($(this).attr("rel"))+n3
		"""),format.raw/*611.3*/("""}"""),format.raw/*611.4*/("""
	"""),format.raw/*612.2*/("""}"""),format.raw/*612.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
	
"""),format.raw/*616.1*/("""}"""),format.raw/*616.2*/("""

function selectAll()"""),format.raw/*618.21*/("""{"""),format.raw/*618.22*/("""
	var n = 0; 
	var n2 = 0; 
	var n3 = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*622.36*/("""{"""),format.raw/*622.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*625.2*/("""}"""),format.raw/*625.3*/("""else"""),format.raw/*625.7*/("""{"""),format.raw/*625.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*627.2*/("""}"""),format.raw/*627.3*/("""
	
	$(".total").each(function (index) """),format.raw/*629.36*/("""{"""),format.raw/*629.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*631.2*/("""}"""),format.raw/*631.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*635.35*/("""{"""),format.raw/*635.36*/("""
		n2 = Number($(this).attr("rel"))+n2
	"""),format.raw/*637.2*/("""}"""),format.raw/*637.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*641.37*/("""{"""),format.raw/*641.38*/("""
		n3 = Number($(this).attr("rel"))+n3
	"""),format.raw/*643.2*/("""}"""),format.raw/*643.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
"""),format.raw/*646.1*/("""}"""),format.raw/*646.2*/("""

</script>
 	 """)))})),format.raw/*649.5*/(""" 

""")))})),format.raw/*651.2*/("""
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Solicitud],formBuscador:DynamicForm,searchIndex:String,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,searchIndex,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Solicitud],DynamicForm,String,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,searchIndex,paginadorFicha) => apply(buscador,formBuscador,searchIndex,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/indexSolicitud.scala.html
                    HASH: 2657a597343a05941496800d0a7176cd14652108
                    MATRIX: 886->1|1147->259|1161->266|1245->270|1296->286|1310->292|1379->340|1446->188|1478->212|1535->379|1551->387|1737->563|1760->577|2126->147|2154->256|2182->376|2211->559|2241->912|2279->915|2292->920|2356->975|2396->977|2929->1475|2972->1509|3012->1511|3273->1736|3294->1747|3397->1827|3586->1980|3607->1991|3700->2061|3878->2203|3899->2214|3994->2286|4190->2445|4211->2456|4306->2528|4511->2696|4532->2707|4627->2779|4833->2949|4854->2960|4945->3028|5133->3179|5154->3190|5255->3268|5452->3429|5473->3440|5567->3511|5679->3591|6419->4295|6488->4355|6528->4357|6679->4471|6700->4482|6787->4546|6863->4590|6916->4608|6973->4656|7013->4658|7160->4768|7181->4779|7282->4857|7474->5012|7495->5023|7584->5089|7654->5128|7708->5147|7753->5183|7793->5185|7958->5314|7978->5325|8067->5391|8131->5424|8252->5509|8272->5520|8359->5585|8535->5726|8576->5758|8616->5760|8733->5841|8747->5846|8785->5861|8825->5870|8864->5873|8904->5903|8945->5905|9066->5989|9081->5994|9118->6007|9159->6016|9353->6174|9466->6264|9613->6375|9728->6467|9920->6623|10089->6769|10132->6776|10307->6928|10515->7100|10625->7187|10670->7196|10789->7291|10981->7446|11002->7457|11080->7512|11523->7919|11627->8000|11672->8009|11775->8089|11935->8211|11957->8222|12029->8270|12399->8604|12503->8685|12548->8694|12632->8755|12788->8873|12810->8884|12884->8934|13298->9312|13408->9399|13453->9408|13576->9507|13767->9661|13788->9672|13866->9727|14311->10136|14419->10221|14464->10230|14571->10314|14731->10436|14753->10447|14831->10501|15240->10874|15378->10988|15422->10996|15526->11077|15716->11230|15737->11241|15809->11290|16221->11666|16404->11825|16547->11932|16677->12038|16846->12171|17048->12349|17237->12502|17363->12604|17591->12796|17703->12885|17747->12893|17877->12999|18117->13202|18138->13213|18223->13275|18709->13725|18900->13893|18943->13900|19153->14087|19355->14253|19493->14367|19537->14375|19644->14459|19827->14605|19848->14616|19924->14669|20393->15102|20534->15219|20578->15227|20688->15314|20898->15487|20919->15498|20997->15553|21435->15955|21559->16055|21626->16086|21818->16254|21978->16378|22107->16483|22305->16645|22434->16750|22594->16874|22722->16978|23156->17375|23177->17386|23245->17431|23395->17545|23439->17579|23480->17581|23615->17698|23629->17703|23669->17704|23963->17961|23981->17969|24036->18001|24106->18034|24150->18068|24191->18070|24471->18330|24485->18334|24525->18335|24611->18388|25184->18925|25235->18959|25276->18961|25319->18968|25343->18982|25393->19009|25457->19036|25512->19068|25565->19084|25584->19093|25617->19103|25669->19117|25691->19128|25782->19195|25917->19293|25936->19302|25962->19305|26013->19318|26033->19327|26060->19330|26186->19419|26207->19430|26301->19500|26447->19610|26492->19632|26539->19642|26581->19674|26621->19675|26668->19685|26720->19727|26760->19728|26889->19824|26930->19833|26981->19847|27037->19893|27077->19894|27203->19988|27259->20008|27327->20066|27367->20067|27497->20165|27542->20174|27584->20206|27624->20207|27671->20217|27716->20252|27756->20253|27885->20349|27926->20358|27971->20367|28035->20421|28075->20422|28224->20539|28285->20563|28337->20592|28398->20617|28451->20660|28491->20661|28538->20671|28557->20680|28606->20706|28634->20715|28648->20719|28688->20720|28735->20730|28774->20759|28823->20761|28842->20770|28885->20786|28926->20795|28987->20819|29029->20851|29078->20853|29156->20904|29210->20921|29252->20953|29301->20955|29376->21003|29430->21020|29474->21054|29523->21056|29542->21065|29590->21086|29644->21103|29683->21132|29723->21133|29771->21144|29790->21153|29828->21168|29877->21180|29934->21227|29974->21228|30029->21246|30048->21255|30097->21281|30141->21292|30189->21303|30281->21385|30321->21386|30448->21480|30489->21489|30555->21518|30574->21527|30604->21534|30662->21555|30700->21583|30749->21585|30768->21594|30812->21611|30891->21653|30933->21685|30973->21686|31020->21696|31039->21705|31080->21723|31121->21732|31171->21745|31227->21791|31267->21792|31306->21812|31320->21816|31360->21817|31412->21837|31494->21882|31513->21891|31547->21902|31594->21913|31638->21947|31679->21949|31724->21958|31795->22006|31835->22014|31916->22058|31935->22067|31975->22084|32022->22095|32066->22129|32107->22131|32153->22141|32230->22195|32270->22203|32351->22247|32370->22256|32409->22272|32456->22283|32500->22317|32541->22319|32587->22329|32663->22382|32703->22390|32780->22430|32818->22458|32867->22460|32886->22469|32928->22484|33063->22582|33084->22593|33180->22665|33304->22753|33353->22792|33394->22794|33535->22898|33556->22909|33650->22979|33734->23026|33798->23080|33839->23081|33887->23109|33902->23114|33943->23115|34005->23143|34065->23171|34143->23216|34196->23232|34220->23246|34253->23256|34396->23362|34414->23370|34469->23402|34539->23435|34583->23469|34624->23471|34904->23731|34918->23735|34958->23736|35045->23790|35203->23912|35218->23917|35333->24008|35395->24041|35425->24042|35498->24086|35528->24087|35613->24144|35642->24145|35750->24224|35780->24225|35850->24267|35879->24268|36018->24378|36048->24379|36119->24422|36148->24423|36289->24535|36319->24536|36390->24579|36419->24580|36561->24693|36591->24694|36642->24717|36671->24718|36758->24776|36788->24777|36836->24797|36865->24798|36896->24801|36925->24802|36981->24829|37011->24830|37114->24904|37144->24905|37250->24982|37280->24983|37349->25024|37378->25025|37408->25027|37437->25028|37604->25166|37634->25167|37740->25244|37770->25245|37840->25287|37869->25288|37899->25290|37928->25291|38096->25430|38126->25431|38232->25508|38262->25509|38332->25551|38361->25552|38391->25554|38420->25555|38555->25662|38584->25663|38635->25685|38665->25686|38771->25763|38801->25764|38896->25831|38925->25832|38957->25836|38986->25837|39080->25903|39109->25904|39176->25942|39206->25943|39273->25982|39302->25983|39469->26121|39499->26122|39567->26162|39596->26163|39764->26302|39794->26303|39862->26343|39891->26344|40024->26449|40053->26450|40101->26466|40137->26470
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->4|35->4|35->9|35->9|42->19|42->19|56->1|57->4|58->7|60->16|63->32|65->34|65->34|65->34|65->34|80->49|80->49|80->49|82->51|82->51|82->51|83->52|83->52|83->52|84->53|84->53|84->53|85->54|85->54|85->54|86->55|86->55|86->55|87->56|87->56|87->56|88->57|88->57|88->57|89->58|89->58|89->58|90->59|103->72|103->72|103->72|104->73|104->73|104->73|105->74|107->76|107->76|107->76|108->77|108->77|108->77|109->78|109->78|109->78|110->79|112->81|112->81|112->81|115->84|115->84|115->84|116->85|121->90|121->90|121->90|128->97|128->97|128->97|129->98|129->98|129->98|130->99|131->100|131->100|131->100|132->101|132->101|132->101|133->102|142->111|142->111|148->117|148->117|155->124|158->127|159->128|162->131|172->141|172->141|173->142|173->142|177->146|177->146|177->146|191->160|191->160|192->161|192->161|193->162|193->162|193->162|201->170|201->170|202->171|202->171|203->172|203->172|203->172|213->182|213->182|214->183|214->183|218->187|218->187|218->187|232->201|232->201|233->202|233->202|234->203|234->203|234->203|242->211|242->211|243->212|243->212|246->215|246->215|246->215|256->225|256->225|262->231|262->231|269->238|269->238|275->244|275->244|283->252|283->252|284->253|284->253|290->259|290->259|290->259|304->273|307->276|308->277|312->281|318->287|318->287|319->288|319->288|323->292|323->292|323->292|340->309|340->309|341->310|341->310|346->315|346->315|346->315|362->331|362->331|364->333|365->334|372->341|372->341|381->350|381->350|388->357|388->357|404->373|404->373|404->373|413->382|413->382|413->382|419->388|419->388|419->388|426->395|426->395|426->395|427->396|427->396|427->396|432->401|432->401|432->401|434->403|457->426|457->426|457->426|458->427|458->427|458->427|459->428|459->428|459->428|459->428|459->428|459->428|459->428|459->428|461->430|461->430|461->430|461->430|461->430|461->430|464->433|464->433|464->433|469->438|469->438|470->439|470->439|470->439|471->440|471->440|471->440|473->442|474->443|475->444|475->444|475->444|477->446|479->448|479->448|479->448|481->450|482->451|482->451|482->451|483->452|483->452|483->452|485->454|486->455|487->456|487->456|487->456|489->458|491->460|491->460|493->462|493->462|493->462|494->463|494->463|494->463|495->464|495->464|495->464|496->465|496->465|496->465|496->465|496->465|497->466|499->468|499->468|499->468|499->468|500->469|500->469|500->469|500->469|501->470|501->470|501->470|501->470|501->470|502->471|502->471|502->471|503->472|503->472|503->472|504->473|504->473|504->473|505->474|505->474|505->474|506->475|507->476|507->476|507->476|509->478|510->479|512->481|512->481|512->481|513->482|513->482|513->482|513->482|513->482|515->484|515->484|515->484|516->485|516->485|516->485|517->486|518->487|518->487|518->487|520->489|520->489|520->489|522->491|524->493|524->493|524->493|525->494|525->494|525->494|526->495|526->495|527->496|529->498|529->498|529->498|530->499|530->499|530->499|531->500|531->500|532->501|534->503|534->503|534->503|535->504|535->504|535->504|536->505|536->505|537->506|539->508|539->508|539->508|539->508|539->508|541->510|541->510|541->510|544->513|544->513|544->513|547->516|547->516|547->516|548->517|548->517|548->517|548->517|548->517|548->517|548->517|550->519|554->523|555->524|555->524|555->524|560->529|560->529|560->529|561->530|561->530|561->530|566->535|566->535|566->535|568->537|575->544|575->544|575->544|578->547|578->547|583->552|583->552|586->555|586->555|592->561|592->561|595->564|595->564|598->567|598->567|601->570|601->570|604->573|604->573|607->576|607->576|610->579|610->579|613->582|613->582|614->583|614->583|616->585|616->585|617->586|617->586|619->588|619->588|623->592|623->592|624->593|624->593|626->595|626->595|627->596|627->596|631->600|631->600|632->601|632->601|634->603|634->603|635->604|635->604|639->608|639->608|640->609|640->609|642->611|642->611|643->612|643->612|647->616|647->616|649->618|649->618|653->622|653->622|656->625|656->625|656->625|656->625|658->627|658->627|660->629|660->629|662->631|662->631|666->635|666->635|668->637|668->637|672->641|672->641|674->643|674->643|677->646|677->646|680->649|682->651
                    -- GENERATED --
                */
            