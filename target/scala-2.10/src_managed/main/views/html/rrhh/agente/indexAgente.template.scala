
package views.html.rrhh.agente

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
object indexAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Agente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Agente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*6.63*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Agente) = {{
	var classEstado:String = new String()
	
	if(i.estado != null && i.estado.id == 48){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 47){
		classEstado = "cancelada"
	}else if(i.estado != null && i.estado.id == 46){
		classEstado = "autorizado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),format.raw/*22.2*/("""

"""),_display_(Seq[Any](/*24.2*/views/*24.7*/.html.rrhh.mainRrhh("Lista Agentes",scripts)/*24.51*/ {_display_(Seq[Any](format.raw/*24.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Agentes</h1>
			</div>
			 
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*40.9*/if(Permiso.check("reporteDatosAgente"))/*40.48*/ {_display_(Seq[Any](format.raw/*40.50*/("""
				  		<li role="presentation"><a data-title="Datos Agentes" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*41.104*/controllers/*41.115*/.rrhh.routes.AgentesReportesController.reportesDatosAgente())),format.raw/*41.175*/("""" id="modalDatosAgente">Datos Agente</a></li>
				 		<li role="presentation"><a data-title="Certificaciones Agentes" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*42.113*/controllers/*42.124*/.rrhh.routes.AgentesReportesController.reportesCertificacionesAgente())),format.raw/*42.194*/("""" id="modalCertificacionesAgente">Certificaciones Agente</a></li>
				 	""")))})),format.raw/*43.8*/("""
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation" class="dropdown-header">Acciones Masivas</li>
				   
						
					    """),_display_(Seq[Any](/*57.11*/if(Permiso.check("agentePasarCargado"))/*57.50*/ {_display_(Seq[Any](format.raw/*57.52*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarCargado" tabindex="-1" href="#" 
					    	data-url=""""),_display_(Seq[Any](/*59.22*/controllers/*59.33*/.rrhh.routes.AgentesAccionesController.modalPasarACargado())),format.raw/*59.92*/("""">Pasar a Cargado</a></li>
					    """)))})),format.raw/*60.11*/("""
					    """),_display_(Seq[Any](/*61.11*/if(Permiso.check("agentePasarPreAprobado"))/*61.54*/ {_display_(Seq[Any](format.raw/*61.56*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarPreaprobado" tabindex="-1" href="#" 
					    	data-url=""""),_display_(Seq[Any](/*63.22*/controllers/*63.33*/.rrhh.routes.AgentesAccionesController.modalPasarAPreaprobado())),format.raw/*63.96*/("""">Pasar a Preaprobado</a></li>
					    """)))})),format.raw/*64.11*/("""
					    """),_display_(Seq[Any](/*65.11*/if(Permiso.check("agentePasarAprobado"))/*65.51*/ {_display_(Seq[Any](format.raw/*65.53*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarAprobado" tabindex="-1" href="#" 
					    	data-url=""""),_display_(Seq[Any](/*67.22*/controllers/*67.33*/.rrhh.routes.AgentesAccionesController.modalPasarAAprobado())),format.raw/*67.93*/("""">Pasar a Aprobado</a></li>
					    """)))})),format.raw/*68.11*/("""
					    """),_display_(Seq[Any](/*69.11*/if(Permiso.check("agentePasarBorrador"))/*69.51*/ {_display_(Seq[Any](format.raw/*69.53*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" 
					    	data-url=""""),_display_(Seq[Any](/*71.22*/controllers/*71.33*/.rrhh.routes.AgentesAccionesController.modalPasarABorrador())),format.raw/*71.93*/("""">Pasar a Borrador</a></li>
					    """)))})),format.raw/*72.11*/("""
					    """),_display_(Seq[Any](/*73.11*/if(Permiso.check("agentePasarCancelado"))/*73.52*/ {_display_(Seq[Any](format.raw/*73.54*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" 
					    	data-url=""""),_display_(Seq[Any](/*75.22*/controllers/*75.33*/.rrhh.routes.AgentesAccionesController.modalPasarACancelado())),format.raw/*75.94*/("""">Pasar a Cancelado</a></li>
					    """)))})),format.raw/*76.11*/("""
					    
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*82.16*/controllers/*82.27*/.rrhh.routes.AgentesController.crearAgente())),format.raw/*82.71*/("""?"""),_display_(Seq[Any](/*82.73*/UriTrack/*82.81*/.encode())),format.raw/*82.90*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Agente</a>
				</div>
			</div>
			
			 
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*90.3*/views/*90.8*/.html.tags.successError())),format.raw/*90.33*/("""
	
	<div id="actions">
		 
			<form action="" id="formSearchAgentes" method="GET">
			
				<div class="row" >
					<div class="col-sm-5 filtrosEstados" id="filtrosEstados">
						<div class="btn-group">
						  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
						  	"""),_display_(Seq[Any](/*101.11*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*101.70*/("""
						  </button>
						  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-arrow-right"></i><br>Cargado
						  	"""),_display_(Seq[Any](/*105.11*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*105.70*/("""
						 </button>
						 <button type="button" rel="aprobado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-arrow-right"></i><br>Preaprobado
						  	"""),_display_(Seq[Any](/*109.11*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*109.70*/("""
						 </button>
						 <button type="button" rel="aprobado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-ok"></i><br>Aprobada
						  	"""),_display_(Seq[Any](/*113.11*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*113.70*/("""
						 </button>
						 <button type="button" rel="cancelado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
						  	"""),_display_(Seq[Any](/*117.11*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*117.70*/("""
						 </button>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
							<label for="nombre" class="control-label">Nombre
							"""),_display_(Seq[Any](/*124.9*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*124.68*/("""
							</label>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
							<label for="cuit" class="control-label">DNI
							"""),_display_(Seq[Any](/*131.9*/inputText(formBuscador("dni"), 'class -> "form-control"))),format.raw/*131.65*/("""
							</label>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
							<label for="cuit" class="control-label">Cuit
							"""),_display_(Seq[Any](/*138.9*/inputText(formBuscador("cuit"), 'class -> "form-control"))),format.raw/*138.66*/("""
							</label>
						</div>
					</div>
				</div>
				<div class="row">	  
					<div class="col-sm-4">
						<label for="inputOrgranigrama" class="control-label">Departamento/Servicio</label> 
						<div class="input-group">
							"""),_display_(Seq[Any](/*147.9*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*147.100*/("""
							"""),_display_(Seq[Any](/*148.9*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden",'id -> "organigrama_id"))),format.raw/*148.94*/("""
							<span class="input-group-addon">
			                	<a href="#" id="searchOrganigrama" data-title="Selección de Departamento/Servicio" 
			                				data-url=""""),_display_(Seq[Any](/*151.35*/controllers/*151.46*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*151.114*/("""" 
			                				data-height="650" data-width="700" 
			                				data-listen="modal.seleccion.servicio.simple" 
			                				data-label="#organigrama" data-field="#organigrama_id" /> <i class="glyphicon glyphicon-search"></i></a>
			                </span>
						</div>
					</div>
					<div class="col-sm-4">
						<label for="inputProfesion" class="control-label">Profesion</label> 
						<div class="input-group">
							"""),_display_(Seq[Any](/*161.9*/inputText(formBuscador("profesion.nombre"),'class -> "form-control",'id -> "profesion"))),format.raw/*161.96*/("""
							"""),_display_(Seq[Any](/*162.9*/inputText(formBuscador("profesion_id"),'hidden -> "hidden",'id -> "profesion_id"))),format.raw/*162.90*/("""
							<span class="input-group-addon">
			                	<a href="#" id="searchProfesion" data-title="Selección de profesion" 
			                				data-url=""""),_display_(Seq[Any](/*165.35*/controllers/*165.46*/.rrhh.routes.ProfesionesController.modalBuscar())),format.raw/*165.94*/("""" 
			                				data-height="650" data-width="700" 
			                				data-listen="modal.seleccion.profesion.simple" 
			                				data-label="#profesion" data-field="#profesion_id" /> <i class="glyphicon glyphicon-search"></i></a>
			                </span>
						</div>
					</div>
					
					
					
					
						<div class="col-sm-2">
							<label class="control-label"> 
								Activo
								"""),_display_(Seq[Any](/*179.10*/select(formBuscador("activo"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*179.111*/("""
							</label>
						</div>
						<div class="col-sm-2">
							<label class="control-label"> 
								Asignaciones Familiares
								"""),_display_(Seq[Any](/*185.10*/select(formBuscador("asignacion_familiar"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*185.124*/("""
							</label>
						</div>
					 
					
				</div>
					
				<div class="row" >	
					<div class="col-sm-2">
						<div class="form-group">
							<label for="cuit" class="control-label">Tipo Relacion
							"""),_display_(Seq[Any](/*196.9*/select(formBuscador("tipo_relacion_laboral"), 
							TipoRelacionLaboral.find.all().map { p => p.id.toString -> p.nombre}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*198.68*/("""
							</label>
						</div>
					</div>
					<div class="col-sm-2">
						<label class="control-label"> 
							Residente
							"""),_display_(Seq[Any](/*205.9*/select(formBuscador("residente"),options(""->"","SI"->"SI","NO"->"NO","basica"->"Basica","posbasica"->"Posbasica"), 'class -> "form-control select"))),format.raw/*205.157*/("""
						</label>
					</div>
					
					<div class="col-sm-2">
						<div class="checkbox">
							<label class="control-label"> 
								Con RUL
								"""),_display_(Seq[Any](/*213.10*/checkbox(formBuscador("con_rul")))),format.raw/*213.43*/("""
							</label> 
						</div> 
					</div>
					<div class="col-sm-2 input-group">
						<label class="control-label">Fecha Ingreso</label>
						<div>
							"""),_display_(Seq[Any](/*220.9*/inputText(formBuscador("fingreso_desde"), 'class -> "form-control inputDateMascara", 'id -> "fingreso_desde", 'placeholder -> "Desde"))),format.raw/*220.143*/("""
							"""),_display_(Seq[Any](/*221.9*/inputText(formBuscador("fingreso_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fingreso_hasta", 'placeholder -> "Hasta"))),format.raw/*221.143*/("""
						</div>
					</div>
					<div class="col-sm-2 input-group">
						<label class="control-label">Fecha CUD</label>
						<div>
							"""),_display_(Seq[Any](/*227.9*/inputText(formBuscador("fcud_desde"), 'class -> "form-control inputDateMascara", 'id -> "cud_desde", 'placeholder -> "Desde"))),format.raw/*227.134*/("""
							"""),_display_(Seq[Any](/*228.9*/inputText(formBuscador("fcud_hasta"), 'class -> "form-control inputDateMascara", 'id -> "cud_hasta", 'placeholder -> "Hasta"))),format.raw/*228.134*/("""
						</div>
					</div>
				</div>	
				<div class="row" >	
					<div class="col-sm-3">
					<label class="control-label">Escala</label>
						<div class="input-group">
							"""),_display_(Seq[Any](/*236.9*/inputText(formBuscador("escalaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "escala_laboral"))),format.raw/*236.120*/("""
							"""),_display_(Seq[Any](/*237.9*/inputText(formBuscador("escala_laboral_id"), 'hidden -> "hidden", 'id -> "escala_laboral_id"))),format.raw/*237.102*/("""
							<span class="input-group-addon">
							<a href="#" class="searchModal" id="searchEscalaLaboral" 
									 	data-title="Selección de escala" 
									 	data-url=""""),_display_(Seq[Any](/*241.23*/controllers/*241.34*/.haberes.routes.EscalasLaboralesController.modalBuscar())),format.raw/*241.90*/("""" 
									 	data-height="650" data-width="700" 
									 	data-listen="modal.seleccion.escalaLaboral.simple" 
									 	data-label="#escala_laboral" data-field="#escala_laboral_id">
							<i class="glyphicon glyphicon-search"></i></a></span>
						</div>
					</div>	
					<div class="col-sm-3">
						
							<label for="inputEspecialidad" class="control-label">Especialidad</label> 
							<div class="input-group">
								"""),_display_(Seq[Any](/*252.10*/inputText(formBuscador("especialidad.nombre"),'class -> "form-control",'id -> "especialidad"))),format.raw/*252.103*/("""
								"""),_display_(Seq[Any](/*253.10*/inputText(formBuscador("especialidad_id"),'hidden -> "hidden",'id -> "especialidad_id"))),format.raw/*253.97*/("""
								<span class="input-group-addon">
								<a href="#" class="searchModal" id="searchEspecialidad" 
										 	data-title="Selección de Especialidad" 
										 	data-url=""""),_display_(Seq[Any](/*257.24*/controllers/*257.35*/.rrhh.routes.EspecialidadesController.modalBuscar())),format.raw/*257.86*/("""" 
										 	data-height="650" data-width="700" 
										 	data-listen="modal.seleccion.especialidad.simple" 
										 	data-label="#especialidad" data-field="#especialidad_id">
								<i class="glyphicon glyphicon-search"></i></a></span> 
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
						<a href=""""),_display_(Seq[Any](/*274.17*/controllers/*274.28*/.rrhh.routes.AgentesController.indexAgente())),format.raw/*274.72*/(""""  class="form-control btn btn-default">Limpiar</a>
						</div>
					</div>
					
				</div>	
			</form>
	</div>
	
	
	"""),_display_(Seq[Any](/*283.3*/if(buscador.getTotalRowCount == 0)/*283.37*/ {_display_(Seq[Any](format.raw/*283.39*/("""
        
        <div class="well">
            <em>No se encuentran Agentes</em>
        </div>
        
    """)))}/*289.7*/else/*289.12*/{_display_(Seq[Any](format.raw/*289.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*291.14*/buscador/*291.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*291.54*/(""" resultado(s). 
		
		<table  id="listaDeAgente" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="50">#</th>
					<th>Apellido y Nombre</th>
					<th>DNI</th>
					<th>Cuit</th>
					<th>Organigrama</th>
					<th>Profesion</th>
					<th>Especialidad</th>
					<th>Puesto</th>
					<th>Relacion</th>
					<th width="30">Activo</th>
					
					<th width="30">Estado</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*313.5*/for(agente <- buscador.getList) yield /*313.36*/ {_display_(Seq[Any](format.raw/*313.38*/("""
				<tr data-estado=""""),_display_(Seq[Any](/*314.23*/agente/*314.29*/.estado_id)),format.raw/*314.39*/("""" class="pointer """),_display_(Seq[Any](/*314.57*/getClassEstado(agente))),format.raw/*314.79*/("""" data-href=""""),_display_(Seq[Any](/*314.93*/controllers/*314.104*/.rrhh.routes.AgentesController.ver(agente.id))),format.raw/*314.149*/("""&"""),_display_(Seq[Any](/*314.151*/UriTrack/*314.159*/.encode())),format.raw/*314.168*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*315.64*/agente/*315.70*/.id)),format.raw/*315.73*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*315.107*/agente/*315.113*/.id)),format.raw/*315.116*/(""""/></td>
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*317.61*/controllers/*317.72*/.rrhh.routes.AgentesController.editarAgente(agente.id))),format.raw/*317.126*/("""&"""),_display_(Seq[Any](/*317.128*/UriTrack/*317.136*/.encode())),format.raw/*317.145*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*321.11*/(agente.apellido))),format.raw/*321.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*322.11*/(agente.dni))),format.raw/*322.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*323.11*/(agente.cuit))),format.raw/*323.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*324.11*/if(agente.organigrama != null)/*324.41*/{_display_(Seq[Any](_display_(Seq[Any](/*324.43*/(agente.organigrama.nombre)))))})),format.raw/*324.71*/("""</td>
					<td>"""),_display_(Seq[Any](/*325.11*/if(agente.profesion != null)/*325.39*/{_display_(Seq[Any](_display_(Seq[Any](/*325.41*/(agente.profesion.nombre)))))})),format.raw/*325.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*326.11*/if(agente.especialidad != null)/*326.42*/{_display_(Seq[Any](_display_(Seq[Any](/*326.44*/(agente.especialidad.nombre)))))})),format.raw/*326.73*/("""</td>
					<td>"""),_display_(Seq[Any](/*327.11*/if(agente.puesto != null)/*327.36*/{_display_(Seq[Any](_display_(Seq[Any](/*327.38*/(agente.puesto.nombre)))))})),format.raw/*327.61*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*329.8*/agente/*329.14*/.tipo_relacion_laboral/*329.36*/ match/*329.42*/ {/*330.10*/case "1" =>/*330.21*/ {_display_(Seq[Any](format.raw/*330.23*/("""Contrato Relacion Parque de la salud""")))}/*331.7*/case "2" =>/*331.18*/ {_display_(Seq[Any](format.raw/*331.20*/("""Monotributo Parque de la salud""")))}/*332.7*/case "3" =>/*332.18*/ {_display_(Seq[Any](format.raw/*332.20*/("""Contrato Relacion Convenio Ministerio Salud""")))}/*333.7*/case "4" =>/*333.18*/ {_display_(Seq[Any](format.raw/*333.20*/("""Planta Ministerio Salud""")))}/*334.7*/case "5" =>/*334.18*/ {_display_(Seq[Any](format.raw/*334.20*/("""Contrato Relacion Ministerio Salud""")))}/*335.7*/case "6" =>/*335.18*/ {_display_(Seq[Any](format.raw/*335.20*/("""Adscripto Otras Entidades""")))}/*336.7*/case "7" =>/*336.18*/ {_display_(Seq[Any](format.raw/*336.20*/("""Contrato Convenio Nacion""")))}/*337.7*/case "8" =>/*337.18*/ {_display_(Seq[Any](format.raw/*337.20*/("""Planta Temporaria - Otras Entidades""")))}/*338.7*/case "9" =>/*338.18*/ {_display_(Seq[Any](format.raw/*338.20*/("""Otro""")))}/*339.10*/case _ =>/*339.19*/ {}})),format.raw/*340.8*/("""	
						
					</td>
					<td>"""),_display_(Seq[Any](/*343.11*/if(agente.activo != null)/*343.36*/{_display_(Seq[Any](_display_(Seq[Any](/*343.38*/if(agente.activo)/*343.55*/ {_display_(Seq[Any](format.raw/*343.57*/("""Si""")))}/*343.61*/else/*343.66*/{_display_(Seq[Any](format.raw/*343.67*/("""No""")))}))))}/*343.72*/else/*343.76*/{_display_(Seq[Any](format.raw/*343.77*/("""falta cargar""")))})),format.raw/*343.90*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*344.26*/(agente.estado.nombre))),format.raw/*344.48*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*346.81*/controllers/*346.92*/.rrhh.routes.AgentesController.eliminarAgente(agente.id))),format.raw/*346.148*/("""&"""),_display_(Seq[Any](/*346.150*/UriTrack/*346.158*/.encode())),format.raw/*346.167*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*351.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*356.8*/views/*356.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.AgentesController.indexAgente()))),format.raw/*356.103*/("""
		</div>
 	 """)))})),format.raw/*358.5*/("""
""")))})),format.raw/*359.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Agente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Agente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/indexAgente.scala.html
                    HASH: 3106b8d8f76a4aebf6b10e9474f5c0b1892a6fff
                    MATRIX: 833->1|1038->132|1052->139|1136->143|1187->159|1201->165|1263->206|1330->244|1362->268|1420->316|1443->330|1777->75|1804->242|1832->312|1862->634|1900->637|1913->642|1966->686|2006->688|2540->1187|2588->1226|2628->1228|2769->1332|2790->1343|2873->1403|3068->1561|3089->1572|3182->1642|3286->1715|3804->2197|3852->2236|3892->2238|4051->2361|4071->2372|4152->2431|4221->2468|4268->2479|4320->2522|4360->2524|4523->2651|4543->2662|4628->2725|4701->2766|4748->2777|4797->2817|4837->2819|4997->2943|5017->2954|5099->3014|5169->3052|5216->3063|5265->3103|5305->3105|5465->3229|5485->3240|5567->3300|5637->3338|5684->3349|5734->3390|5774->3392|5935->3517|5955->3528|6038->3589|6109->3628|6240->3723|6260->3734|6326->3778|6364->3780|6381->3788|6412->3797|6601->3951|6614->3956|6661->3981|7065->4348|7147->4407|7363->4586|7445->4645|7663->4826|7745->4885|7951->5054|8033->5113|8249->5292|8331->5351|8533->5517|8615->5576|8811->5736|8890->5792|9087->5953|9167->6010|9439->6246|9554->6337|9599->6346|9707->6431|9923->6610|9944->6621|10036->6689|10527->7144|10637->7231|10682->7240|10786->7321|10988->7486|11009->7497|11080->7545|11541->7969|11666->8070|11841->8208|11979->8322|12227->8534|12442->8726|12610->8858|12782->9006|12973->9160|13029->9193|13226->9354|13384->9488|13429->9497|13587->9631|13762->9770|13911->9895|13956->9904|14105->10029|14320->10208|14455->10319|14500->10328|14617->10421|14827->10594|14848->10605|14927->10661|15396->11093|15513->11186|15560->11196|15670->11283|15889->11465|15910->11476|15984->11527|16653->12159|16674->12170|16741->12214|16897->12334|16941->12368|16982->12370|17113->12483|17127->12488|17167->12489|17221->12506|17239->12514|17294->12546|17873->13089|17921->13120|17962->13122|18022->13145|18038->13151|18071->13161|18126->13179|18171->13201|18222->13215|18244->13226|18313->13271|18353->13273|18372->13281|18405->13290|18508->13356|18524->13362|18550->13365|18622->13399|18639->13405|18666->13408|18818->13523|18839->13534|18917->13588|18957->13590|18976->13598|19009->13607|19129->13690|19169->13707|19222->13723|19257->13735|19310->13751|19346->13764|19399->13780|19439->13810|19488->13812|19543->13840|19596->13856|19634->13884|19683->13886|19736->13912|19789->13928|19830->13959|19879->13961|19935->13990|19988->14006|20023->14031|20072->14033|20122->14056|20181->14079|20197->14085|20229->14107|20245->14113|20257->14125|20278->14136|20319->14138|20375->14182|20396->14193|20437->14195|20487->14233|20508->14244|20549->14246|20612->14297|20633->14308|20674->14310|20717->14341|20738->14352|20779->14354|20833->14396|20854->14407|20895->14409|20940->14442|20961->14453|21002->14455|21046->14487|21067->14498|21108->14500|21163->14543|21184->14554|21225->14556|21250->14571|21269->14580|21295->14591|21362->14621|21397->14646|21446->14648|21473->14665|21514->14667|21537->14671|21551->14676|21591->14677|21619->14682|21633->14686|21673->14687|21719->14700|21787->14731|21832->14753|21965->14849|21986->14860|22066->14916|22106->14918|22125->14926|22158->14935|22304->15048|22424->15132|22439->15137|22553->15227|22599->15241|22633->15243
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|37->10|37->10|50->1|51->7|52->8|54->22|56->24|56->24|56->24|56->24|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42|75->43|89->57|89->57|89->57|91->59|91->59|91->59|92->60|93->61|93->61|93->61|95->63|95->63|95->63|96->64|97->65|97->65|97->65|99->67|99->67|99->67|100->68|101->69|101->69|101->69|103->71|103->71|103->71|104->72|105->73|105->73|105->73|107->75|107->75|107->75|108->76|114->82|114->82|114->82|114->82|114->82|114->82|122->90|122->90|122->90|133->101|133->101|137->105|137->105|141->109|141->109|145->113|145->113|149->117|149->117|156->124|156->124|163->131|163->131|170->138|170->138|179->147|179->147|180->148|180->148|183->151|183->151|183->151|193->161|193->161|194->162|194->162|197->165|197->165|197->165|211->179|211->179|217->185|217->185|228->196|230->198|237->205|237->205|245->213|245->213|252->220|252->220|253->221|253->221|259->227|259->227|260->228|260->228|268->236|268->236|269->237|269->237|273->241|273->241|273->241|284->252|284->252|285->253|285->253|289->257|289->257|289->257|306->274|306->274|306->274|315->283|315->283|315->283|321->289|321->289|321->289|323->291|323->291|323->291|345->313|345->313|345->313|346->314|346->314|346->314|346->314|346->314|346->314|346->314|346->314|346->314|346->314|346->314|347->315|347->315|347->315|347->315|347->315|347->315|349->317|349->317|349->317|349->317|349->317|349->317|353->321|353->321|354->322|354->322|355->323|355->323|356->324|356->324|356->324|356->324|357->325|357->325|357->325|357->325|358->326|358->326|358->326|358->326|359->327|359->327|359->327|359->327|361->329|361->329|361->329|361->329|361->330|361->330|361->330|361->331|361->331|361->331|361->332|361->332|361->332|361->333|361->333|361->333|361->334|361->334|361->334|361->335|361->335|361->335|361->336|361->336|361->336|361->337|361->337|361->337|361->338|361->338|361->338|361->339|361->339|361->340|364->343|364->343|364->343|364->343|364->343|364->343|364->343|364->343|364->343|364->343|364->343|364->343|365->344|365->344|367->346|367->346|367->346|367->346|367->346|367->346|372->351|377->356|377->356|377->356|379->358|380->359
                    -- GENERATED --
                */
            