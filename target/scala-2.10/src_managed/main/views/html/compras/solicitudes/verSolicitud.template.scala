
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
object verSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Form[Solicitud],Solicitud,String,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(solicitudForm: Form[Solicitud],solicitud:Solicitud,searchIndex:String, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/compras/solicitudes.js"))),format.raw/*8.70*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.122*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(solicitud.id.toString))),format.raw/*6.49*/("""
"""),format.raw/*9.2*/("""

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.compras.mainCompras("Vista Solicitud", scripts)/*11.60*/ {_display_(Seq[Any](format.raw/*11.62*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de solicitud """),_display_(Seq[Any](/*15.29*/if(solicitud.expediente != null)/*15.61*/{_display_(Seq[Any](_display_(Seq[Any](/*15.63*/if(solicitud.expediente.emergencia)/*15.98*/{_display_(Seq[Any](format.raw/*15.99*/("""<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*15.189*/("""</h1>
			</div>
			<div class="col-sm-5">
			 	<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*25.9*/if(!Permiso.check("noVerPrecios"))/*25.43*/ {_display_(Seq[Any](format.raw/*25.45*/("""
					    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Solicitud de compra</a></li>
					    """),_display_(Seq[Any](/*27.11*/if(Permiso.check("solicitudesVerReporteImputacionPreventva"))/*27.72*/ {_display_(Seq[Any](format.raw/*27.74*/("""
					    	<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*28.75*/controllers/*28.86*/.compras.routes.SolicitudesReportesController.reporteImputacionPreventiva(solicitudForm.field("id").value.toLong))),format.raw/*28.199*/("""">Imputaci&oacute;n preventiva</a></li>
					    """)))})),format.raw/*29.11*/("""
					     """),_display_(Seq[Any](/*30.12*/if(Permiso.check("solicitudesReportePedidoAbastecimiento"))/*30.71*/ {_display_(Seq[Any](format.raw/*30.73*/("""
					    	<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*31.75*/controllers/*31.86*/.compras.routes.SolicitudesReportesController.reportePedidoAbastecimiento(solicitudForm.field("id").value.toLong))),format.raw/*31.199*/("""">Pedido Abastecimiento</a></li>
					    """)))})),format.raw/*32.11*/("""
					    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Exportaci&oacute;n de lineas</a></li>
					    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Informe de ajuste preventiva</a></li>
				  	""")))})),format.raw/*35.9*/("""
				  </ul>
				</div>
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
					<ul class="dropdown-menu">
				 	"""),_display_(Seq[Any](/*41.8*/if(Permiso.check("solicitudesModificarPaciente"))/*41.57*/ {_display_(Seq[Any](format.raw/*41.59*/("""
				    	<li role="presentation">
				    	<a role="menuitem" tabindex="-1" href="#" id="modificarPaciente" data-url=""""),_display_(Seq[Any](/*43.86*/controllers/*43.97*/.compras.routes.SolicitudAccionesController.modalModificarPaciente(solicitudForm.field("id").value.toLong))),format.raw/*43.203*/("""">Modificar Paciente</a></li>
				    """)))})),format.raw/*44.10*/("""
				    """),_display_(Seq[Any](/*45.10*/if(Permiso.check("asignarUsuarios"))/*45.46*/ {_display_(Seq[Any](format.raw/*45.48*/("""
				    	<li role="presentation">
				    	<a role="menuitem" tabindex="-1" href="#" id="asignarUsuario" 
				    		data-url=""""),_display_(Seq[Any](/*48.22*/controllers/*48.33*/.compras.routes.SolicitudAccionesController.modalAsignarUsuario(solicitudForm.field("id").value.toLong))),format.raw/*48.136*/("""">Asignar Usuario</a></li>
					""")))})),format.raw/*49.7*/("""
					</ul>
				</div>
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*53.16*/controllers/*53.27*/.compras.routes.SolicitudesController.crearSolicitud(searchIndex))),format.raw/*53.92*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Solicitud</a>
				</div>
			</div> 
		</div>
	</div>
	

	
	
"""),_display_(Seq[Any](/*62.2*/views/*62.7*/.html.tags.successError())),format.raw/*62.32*/("""

	<div class="row menu-acciones">
		<div class="col-sm-5">
			<a href=""""),_display_(Seq[Any](/*66.14*/controllers/*66.25*/.compras.routes.SolicitudesController.crearSolicitud(searchIndex))),format.raw/*66.90*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*67.14*/controllers/*67.25*/.compras.routes.SolicitudesController.editar(solicitudForm.field("id").value.toLong,searchIndex))),format.raw/*67.121*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			"""),_display_(Seq[Any](/*68.5*/if(Permiso.check("solicitudesDuplicar"))/*68.45*/ {_display_(Seq[Any](format.raw/*68.47*/("""
				<a href=""""),_display_(Seq[Any](/*69.15*/controllers/*69.26*/.compras.routes.SolicitudesController.duplicar(solicitudForm.field("id").value.toLong,searchIndex))),format.raw/*69.124*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
			""")))})),format.raw/*70.5*/("""
			<a href=""""),_display_(Seq[Any](/*71.14*/controllers/*71.25*/.compras.routes.SolicitudesController.eliminar(solicitudForm.field("id").value.toLong,searchIndex))),format.raw/*71.123*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-4">
			"""),_display_(Seq[Any](/*74.5*/if(solicitudForm("asignacion_usuario_id").value != null)/*74.61*/{_display_(Seq[Any](format.raw/*74.62*/("""
				<span style="color:red;font-size: 15px;font-weight: bold;">"""),_display_(Seq[Any](/*75.65*/solicitudForm("asignacion_usuario.nombre")/*75.107*/.value)),format.raw/*75.113*/("""</span>
			""")))})),format.raw/*76.5*/("""
		</div>
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*79.14*/controllers/*79.25*/.compras.routes.SolicitudesController.redirectSearchIndex(searchIndex))),format.raw/*79.95*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			
		"""),_display_(Seq[Any](/*81.4*/if(paginadorFicha.getLista().size() > 1)/*81.44*/{_display_(Seq[Any](format.raw/*81.45*/("""
		<div class="btn-group">
			"""),_display_(Seq[Any](/*83.5*/if(paginadorFicha.hasPrev())/*83.33*/ {_display_(Seq[Any](format.raw/*83.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*84.29*/controllers/*84.40*/.compras.routes.SolicitudesController.ver(paginadorFicha.prev().toLong, searchIndex))),_display_(Seq[Any](/*84.125*/UriTrack/*84.133*/.get("&"))),format.raw/*84.142*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))}/*85.6*/else/*85.11*/{_display_(Seq[Any](format.raw/*85.12*/("""
				<a  role="group" href="" class="btn btn-default disabled"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*87.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*88.79*/paginadorFicha/*88.93*/.posicionActual())),format.raw/*88.110*/(""" de """),_display_(Seq[Any](/*88.115*/paginadorFicha/*88.129*/.getLista().size())),format.raw/*88.147*/("""</p>
			"""),_display_(Seq[Any](/*89.5*/if(paginadorFicha.hasNext())/*89.33*/ {_display_(Seq[Any](format.raw/*89.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*90.29*/controllers/*90.40*/.compras.routes.SolicitudesController.ver(paginadorFicha.next().toLong, searchIndex))),_display_(Seq[Any](/*90.125*/UriTrack/*90.133*/.get("&"))),format.raw/*90.142*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))}/*91.6*/else/*91.11*/{_display_(Seq[Any](format.raw/*91.12*/("""
				<a  role="group" href="" class="btn btn-default disabled"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*93.5*/(""" 
		</div>
		""")))})),format.raw/*95.4*/("""
			
		</div>
		

		
	</div>
	 
	<input type="hidden" name="solicitudId" id="solicitudId" value=""""),_display_(Seq[Any](/*103.67*/solicitud/*103.76*/.id)),format.raw/*103.79*/(""""/>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Referencia</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*108.50*/solicitud/*108.59*/.referencia)),format.raw/*108.70*/("""</p>
			</div>
		</div>
		
		<div class="col-sm-3">
			<label for="solicitante" class="control-label">Solicitante</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*114.49*/if(solicitud.solicitante != null)/*114.82*/{_display_(Seq[Any](_display_(Seq[Any](/*114.84*/solicitud/*114.93*/.solicitante.apellido))))})),format.raw/*114.115*/("""</p>
		</div>
		
		<div class="col-sm-3">
			<label for="servicio" class="control-label">Servicio</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*119.49*/if(solicitud.departamento != null)/*119.83*/{_display_(Seq[Any](_display_(Seq[Any](/*119.85*/solicitud/*119.94*/.departamento.nombre))))})),format.raw/*119.115*/("""</p>
		</div>
		
		<!-- <div class="col-sm-3">
			<div class="form-group">
				<label for=""""),_display_(Seq[Any](/*124.18*/solicitudForm("dirigida")/*124.43*/.id)),format.raw/*124.46*/("""" class="control-label">Dirigido a</label>
				<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*126.6*/solicitud/*126.15*/.dirigida/*126.24*/ match/*126.30*/ {/*127.9*/case "compras" =>/*127.26*/ {_display_(Seq[Any](format.raw/*127.28*/("""A Compras""")))}/*128.9*/case "patrimonio" =>/*128.29*/ {_display_(Seq[Any](format.raw/*128.31*/("""A Patrimonio""")))}/*129.9*/case _ =>/*129.18*/ {}})),format.raw/*130.6*/("""
				</p>
			</div>
		</div> -->
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputDeposito" class="control-label">Institucion</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*137.50*/if(solicitud.deposito != null)/*137.80*/{_display_(Seq[Any](_display_(Seq[Any](/*137.82*/solicitud/*137.91*/.deposito.nombre))))})),format.raw/*137.108*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Expediente</label>
					<p class="form-control-static form-control">"""),_display_(Seq[Any](/*146.51*/if(solicitud.expediente != null)/*146.83*/{_display_(Seq[Any](_display_(Seq[Any](/*146.85*/solicitud/*146.94*/.expediente.getExpedienteEjercicio()))))})),format.raw/*146.131*/("""</p>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCliente" class="control-label">
					Paciente
				</label>
				<p class="form-control-static form-control" id="pacienteVer">
				"""),_display_(Seq[Any](/*156.6*/if(solicitud.cliente != null)/*156.35*/{_display_(Seq[Any](_display_(Seq[Any](/*156.37*/solicitud/*156.46*/.cliente.nombre))))})),format.raw/*156.62*/("""
				</p>
			</div>
		</div>

		<!-- <div class="col-sm-3">
			<div class="form-group">
				<label for="inputOrigen" class="control-label">Médico</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*164.50*/solicitud/*164.59*/.origen)),format.raw/*164.66*/("""</p>
			</div>
		</div> -->
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputMedico" class="control-label">Médico Solicitante</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*170.50*/if(solicitud.medico != null)/*170.78*/{_display_(Seq[Any](_display_(Seq[Any](/*170.80*/solicitud/*170.89*/.medico.apellido))))})),format.raw/*170.106*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="prioridad" class="control-label">Prioridad</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*177.7*/solicitud/*177.16*/.prioridad/*177.26*/ match/*177.32*/ {/*178.10*/case "baja" =>/*178.24*/ {_display_(Seq[Any](format.raw/*178.26*/("""Baja""")))}/*179.10*/case "media" =>/*179.25*/ {_display_(Seq[Any](format.raw/*179.27*/("""Media""")))}/*180.10*/case "alta" =>/*180.24*/ {_display_(Seq[Any](format.raw/*180.26*/("""Alta""")))}/*181.10*/case _ =>/*181.19*/ {}})),format.raw/*182.7*/("""
				</p>
			</div>
		</div>
	</div>
	
	<div class="row">
		
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputFechaStart" class="control-label">Fecha Solicitud</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*193.50*/solicitudForm("date_start")/*193.77*/.value)),format.raw/*193.83*/("""</p>
			</div>
		</div>
		
		<!-- <div class="col-sm-2">
			<div class="form-group">
				<label for="inputFechaEnd" class="control-label">Fecha Límite</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*200.50*/solicitud/*200.59*/.date_end)),format.raw/*200.68*/("""</p>
			</div>
		</div> -->
		<div class="col-sm-3">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="inputFechaImputacion" class="control-label">Fecha imp. preventiva</label> 
					<p class="form-control-static form-control date">"""),_display_(Seq[Any](/*207.56*/solicitudForm("fecha_imputacion")/*207.89*/.value)),format.raw/*207.95*/("""</p>
				</div>
			</div>
			 
			<div class="col-sm-6">
				<div class="form-group">
					<label class="control-label">Pedido Rismi</label>
					<p class="form-control-static form-control">"""),_display_(Seq[Any](/*214.51*/solicitud/*214.60*/.pedido_rismi_id)),format.raw/*214.76*/("""</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="tipo_cuenta" class="control-label">Tipo Cuenta</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*222.7*/if(solicitud.tipoCuenta != null)/*222.39*/{_display_(Seq[Any](format.raw/*222.40*/("""
						"""),_display_(Seq[Any](/*223.8*/solicitud/*223.17*/.tipoCuenta.nombre)),format.raw/*223.35*/("""
					""")))})),format.raw/*224.7*/("""
				</p>
			</div>
		</div>
		
		<div class="col-sm-3">
			<!-- <div class="col-sm-4">
				<div class="checkbox">
					<label>
						Profe """),_display_(Seq[Any](/*233.14*/checkbox(solicitudForm("profe"), 'disabled -> "disabled"))),format.raw/*233.71*/("""
					</label>
				</div> 
			</div> -->
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Repo Stock """),_display_(Seq[Any](/*240.19*/checkbox(solicitudForm("repo_stock"), 'disabled -> "disabled"))),format.raw/*240.81*/("""
					</label>
				</div> 
			</div>
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Recuperable Profe """),_display_(Seq[Any](/*247.26*/checkbox(solicitudForm("recuperable"), 'disabled -> "disabled"))),format.raw/*247.89*/("""
					</label>
				</div> 
			</div>
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Entregado """),_display_(Seq[Any](/*254.18*/checkbox(solicitudForm("entregado"), 'disabled -> "disabled"))),format.raw/*254.79*/("""
					</label>
				</div> 
			</div>
		</div>
		
		
		
	</div>

	"""),_display_(Seq[Any](/*264.3*/views/*264.8*/.html.compras.solicitudes.tabsSolicitud(false, solicitudForm))),format.raw/*264.69*/("""
	"""),_display_(Seq[Any](/*265.3*/if(!Permiso.check("noVerPrecios"))/*265.37*/ {_display_(Seq[Any](format.raw/*265.39*/("""
	<h4>Base: 	<b>"""),_display_(Seq[Any](/*266.17*/utils/*266.22*/.NumberUtils.moneda(solicitud.total))),format.raw/*266.58*/("""</b></h4>	
	<h4>Total Ajuste: 	<b>"""),_display_(Seq[Any](/*267.25*/utils/*267.30*/.NumberUtils.moneda(solicitud.totalAjuste))),format.raw/*267.72*/("""</b></h4>
	<h4>Total: 	<b>"""),_display_(Seq[Any](/*268.18*/utils/*268.23*/.NumberUtils.moneda(solicitud.getTotalTotal()))),format.raw/*268.69*/("""</b></h4>
	""")))})),format.raw/*269.3*/("""
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*270.26*/solicitud/*270.35*/.estado.nombre)),format.raw/*270.49*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*273.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(solicitud.estado.orden,models.Estado.TIPO_SOLICITUD)) yield /*273.114*/ {_display_(Seq[Any](format.raw/*273.116*/("""	
			"""),_display_(Seq[Any](/*274.5*/if(estado.orden <= 7)/*274.26*/ {_display_(Seq[Any](format.raw/*274.28*/("""
				"""),_display_(Seq[Any](/*275.6*/if(Permiso.check("verTodasLasSolicitudes") && solicitud.create_usuario.departamento_id == null)/*275.101*/{_display_(Seq[Any](format.raw/*275.102*/("""
					"""),_display_(Seq[Any](/*276.7*/if(solicitud.estado_id == Estado.SOLICITUD_ESTADO_ENCURSO)/*276.65*/{_display_(Seq[Any](format.raw/*276.66*/("""
						<div class="col-sm-3">
							<a href=""""),_display_(Seq[Any](/*278.18*/controllers/*278.29*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, Estado.SOLICITUD_ESTADO_PREAPROBADO ,searchIndex))),format.raw/*278.169*/("""" class="btn btn-default btn-disable-onclick">
								<i class="glyphicon glyphicon-arrow-right"></i> Pasar a preaprobado
							</a>
						</div>
					""")))}/*282.7*/else/*282.11*/{_display_(Seq[Any](format.raw/*282.12*/("""
						"""),_display_(Seq[Any](/*283.8*/if(solicitud.estado_id == Estado.SOLICITUD_ESTADO_PREAPROBADO)/*283.70*/{_display_(Seq[Any](format.raw/*283.71*/("""
							<div class="col-sm-3">
								<a href=""""),_display_(Seq[Any](/*285.19*/controllers/*285.30*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, Estado.SOLICITUD_ESTADO_ADMINISTRACION ,searchIndex))),format.raw/*285.173*/("""" class="btn btn-default btn-disable-onclick">
									<i class="glyphicon glyphicon-arrow-right"></i> Aprobado por Administración
								</a>
							</div>
						""")))}/*289.8*/else/*289.12*/{_display_(Seq[Any](format.raw/*289.13*/("""
							<div class="col-sm-3">
								<a href=""""),_display_(Seq[Any](/*291.19*/controllers/*291.30*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, estado.id.toLong,searchIndex))),format.raw/*291.150*/("""" class="btn btn-default btn-disable-onclick">
									<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*292.59*/estado/*292.65*/.nombre)),format.raw/*292.72*/("""
								</a>
							</div>
						""")))})),format.raw/*295.8*/("""
					""")))})),format.raw/*296.7*/("""
				""")))}/*297.6*/else/*297.10*/{_display_(Seq[Any](format.raw/*297.11*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*299.17*/controllers/*299.28*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, estado.id.toLong,searchIndex))),format.raw/*299.148*/("""" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*300.57*/estado/*300.63*/.nombre)),format.raw/*300.70*/("""
						</a>
					</div>
				""")))})),format.raw/*303.6*/("""
			""")))})),format.raw/*304.5*/("""
		""")))})),format.raw/*305.4*/("""
		"""),_display_(Seq[Any](/*306.4*/if(solicitud.estado.id == models.Estado.SOLICITUD_ESTADO_CANCELADO)/*306.71*/ {_display_(Seq[Any](format.raw/*306.73*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*308.15*/controllers/*308.26*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, models.Estado.SOLICITUD_ESTADO_BORRADOR,searchIndex))),format.raw/*308.169*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*312.4*/else/*312.8*/{_display_(Seq[Any](format.raw/*312.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*314.15*/controllers/*314.26*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, models.Estado.SOLICITUD_ESTADO_CANCELADO,searchIndex))),format.raw/*314.170*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Solicitud
				</a>
			</div>
		""")))})),format.raw/*318.4*/("""	 
		
		"""),_display_(Seq[Any](/*320.4*/if(solicitud.estado.id != models.Estado.SOLICITUD_ESTADO_RESERVADO && Permiso.check("solicitudesPasarReservado") )/*320.118*/ {_display_(Seq[Any](format.raw/*320.120*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*322.15*/controllers/*322.26*/.compras.routes.SolicitudesController.cambiarEstado(solicitudForm.field("id").value.toInt, models.Estado.SOLICITUD_ESTADO_RESERVADO,searchIndex))),format.raw/*322.170*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-registration-mark"></i> Reservado/Stock
				</a>
			</div>
		""")))})),format.raw/*326.4*/("""
	</div>
""")))})))}
    }
    
    def render(solicitudForm:Form[Solicitud],solicitud:Solicitud,searchIndex:String,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(solicitudForm,solicitud,searchIndex,paginadorFicha)
    
    def f:((Form[Solicitud],Solicitud,String,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (solicitudForm,solicitud,searchIndex,paginadorFicha) => apply(solicitudForm,solicitud,searchIndex,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/verSolicitud.scala.html
                    HASH: 25d3f007cbb89bf4f0369b1a022810d54fc95294
                    MATRIX: 859->1|1113->304|1127->311|1211->315|1263->332|1277->338|1346->386|1414->182|1446->206|1521->121|1550->250|1588->254|1610->268|1664->301|1692->423|1732->428|1745->433|1807->486|1847->488|1989->594|2030->626|2078->628|2122->663|2161->664|2288->754|2729->1160|2772->1194|2812->1196|2982->1330|3052->1391|3092->1393|3204->1469|3224->1480|3360->1593|3443->1644|3492->1657|3560->1716|3600->1718|3712->1794|3732->1805|3868->1918|3944->1962|4247->2234|4597->2549|4655->2598|4695->2600|4853->2722|4873->2733|5002->2839|5074->2879|5121->2890|5166->2926|5206->2928|5373->3059|5393->3070|5519->3173|5584->3207|5702->3289|5722->3300|5809->3365|5993->3514|6006->3519|6053->3544|6166->3621|6186->3632|6273->3697|6406->3794|6426->3805|6545->3901|6664->3985|6713->4025|6753->4027|6805->4043|6825->4054|6946->4152|7068->4243|7119->4258|7139->4269|7260->4367|7453->4525|7518->4581|7557->4582|7659->4648|7711->4690|7740->4696|7784->4709|7871->4760|7891->4771|7983->4841|8098->4921|8147->4961|8186->4962|8254->4995|8291->5023|8331->5025|8397->5055|8417->5066|8533->5151|8551->5159|8583->5168|8685->5253|8698->5258|8737->5259|8890->5381|9006->5461|9029->5475|9069->5492|9111->5497|9135->5511|9176->5529|9221->5539|9258->5567|9298->5569|9364->5599|9384->5610|9500->5695|9518->5703|9550->5712|9653->5798|9666->5803|9705->5804|9859->5927|9906->5943|10049->6049|10068->6058|10094->6061|10313->6243|10332->6252|10366->6263|10580->6440|10623->6473|10672->6475|10691->6484|10741->6506|10937->6665|10981->6699|11030->6701|11049->6710|11098->6731|11232->6828|11267->6853|11293->6856|11428->6955|11447->6964|11466->6973|11482->6979|11493->6991|11520->7008|11561->7010|11590->7030|11620->7050|11661->7052|11693->7075|11712->7084|11738->7094|11991->7310|12031->7340|12080->7342|12099->7351|12144->7368|12398->7585|12440->7617|12489->7619|12508->7628|12573->7665|12850->7906|12889->7935|12938->7937|12957->7946|13000->7962|13249->8174|13268->8183|13298->8190|13550->8405|13588->8433|13637->8435|13656->8444|13701->8461|13943->8667|13962->8676|13982->8686|13998->8692|14010->8705|14034->8719|14075->8721|14100->8737|14125->8752|14166->8754|14192->8771|14216->8785|14257->8787|14282->8803|14301->8812|14327->8823|14618->9077|14655->9104|14684->9110|14937->9326|14956->9335|14988->9344|15287->9606|15330->9639|15359->9645|15594->9843|15613->9852|15652->9868|15910->10090|15952->10122|15992->10123|16037->10132|16056->10141|16097->10159|16137->10167|16324->10317|16404->10374|16573->10506|16658->10568|16830->10703|16916->10766|17080->10893|17164->10954|17276->11030|17290->11035|17374->11096|17414->11100|17458->11134|17499->11136|17554->11154|17569->11159|17628->11195|17701->11231|17716->11236|17781->11278|17846->11306|17861->11311|17930->11357|17975->11370|18039->11397|18058->11406|18095->11420|18186->11475|18314->11585|18356->11587|18399->11594|18430->11615|18471->11617|18514->11624|18620->11719|18661->11720|18705->11728|18773->11786|18813->11787|18899->11836|18920->11847|19084->11987|19261->12145|19275->12149|19315->12150|19360->12159|19432->12221|19472->12222|19560->12273|19581->12284|19748->12427|19937->12597|19951->12601|19991->12602|20079->12653|20100->12664|20244->12784|20387->12890|20403->12896|20433->12903|20503->12941|20543->12949|20569->12956|20583->12960|20623->12961|20707->13008|20728->13019|20872->13139|21013->13243|21029->13249|21059->13256|21123->13288|21161->13294|21198->13299|21239->13304|21316->13371|21357->13373|21437->13416|21458->13427|21625->13570|21788->13714|21801->13718|21840->13719|21920->13762|21941->13773|22109->13917|22285->14061|22332->14072|22457->14186|22499->14188|22579->14231|22600->14242|22768->14386|22948->14534
                    LINES: 26->1|33->7|33->7|35->7|36->8|36->8|36->8|37->5|37->5|38->1|39->5|40->6|40->6|40->6|41->9|43->11|43->11|43->11|43->11|47->15|47->15|47->15|47->15|47->15|47->15|57->25|57->25|57->25|59->27|59->27|59->27|60->28|60->28|60->28|61->29|62->30|62->30|62->30|63->31|63->31|63->31|64->32|67->35|73->41|73->41|73->41|75->43|75->43|75->43|76->44|77->45|77->45|77->45|80->48|80->48|80->48|81->49|85->53|85->53|85->53|94->62|94->62|94->62|98->66|98->66|98->66|99->67|99->67|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|103->71|103->71|103->71|106->74|106->74|106->74|107->75|107->75|107->75|108->76|111->79|111->79|111->79|113->81|113->81|113->81|115->83|115->83|115->83|116->84|116->84|116->84|116->84|116->84|117->85|117->85|117->85|119->87|120->88|120->88|120->88|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|122->90|122->90|123->91|123->91|123->91|125->93|127->95|135->103|135->103|135->103|140->108|140->108|140->108|146->114|146->114|146->114|146->114|146->114|151->119|151->119|151->119|151->119|151->119|156->124|156->124|156->124|158->126|158->126|158->126|158->126|158->127|158->127|158->127|158->128|158->128|158->128|158->129|158->129|158->130|165->137|165->137|165->137|165->137|165->137|174->146|174->146|174->146|174->146|174->146|184->156|184->156|184->156|184->156|184->156|192->164|192->164|192->164|198->170|198->170|198->170|198->170|198->170|205->177|205->177|205->177|205->177|205->178|205->178|205->178|205->179|205->179|205->179|205->180|205->180|205->180|205->181|205->181|205->182|216->193|216->193|216->193|223->200|223->200|223->200|230->207|230->207|230->207|237->214|237->214|237->214|245->222|245->222|245->222|246->223|246->223|246->223|247->224|256->233|256->233|263->240|263->240|270->247|270->247|277->254|277->254|287->264|287->264|287->264|288->265|288->265|288->265|289->266|289->266|289->266|290->267|290->267|290->267|291->268|291->268|291->268|292->269|293->270|293->270|293->270|296->273|296->273|296->273|297->274|297->274|297->274|298->275|298->275|298->275|299->276|299->276|299->276|301->278|301->278|301->278|305->282|305->282|305->282|306->283|306->283|306->283|308->285|308->285|308->285|312->289|312->289|312->289|314->291|314->291|314->291|315->292|315->292|315->292|318->295|319->296|320->297|320->297|320->297|322->299|322->299|322->299|323->300|323->300|323->300|326->303|327->304|328->305|329->306|329->306|329->306|331->308|331->308|331->308|335->312|335->312|335->312|337->314|337->314|337->314|341->318|343->320|343->320|343->320|345->322|345->322|345->322|349->326
                    -- GENERATED --
                */
            