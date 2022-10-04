
package views.html.compras.certificaciones

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
object indexCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Certificacion],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Certificacion], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/compras/certificaciones.js"))),format.raw/*7.74*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 28){
		classEstado = "borrador"
	}else if(i != null && i.id == 32){
		classEstado = "cancelada"
	}else if(i != null && i.id == 31){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.132*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.compras.mainCompras("Lista de Certificaciones Personal", scripts)/*23.78*/ {_display_(Seq[Any](format.raw/*23.80*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de certificaciones Personal</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*38.9*/if(Permiso.check("certificacionesReporteBajas"))/*38.57*/ {_display_(Seq[Any](format.raw/*38.59*/("""
				  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteBajas" data-url=""""),_display_(Seq[Any](/*39.104*/controllers/*39.115*/.compras.routes.CertificacionesReportesController.bajas())),format.raw/*39.172*/(""""> Bajas</a></li>  
				  	""")))})),format.raw/*40.9*/("""
				  	"""),_display_(Seq[Any](/*41.9*/if(Permiso.check("certificacionesReporteCertificacion"))/*41.65*/ {_display_(Seq[Any](format.raw/*41.67*/("""
				  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteCertificacion" data-url=""""),_display_(Seq[Any](/*42.112*/controllers/*42.123*/.compras.routes.CertificacionesReportesController.reporteCertificacion())),format.raw/*42.195*/(""""> Certificacion</a></li>  
				  	""")))})),format.raw/*43.9*/("""
				  	
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteTasas" data-url=""""),_display_(Seq[Any](/*45.103*/controllers/*45.114*/.compras.routes.CertificacionesReportesController.reporteTasas())),format.raw/*45.178*/(""""> Reporte Tasas</a></li>
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteElevaciones" data-url=""""),_display_(Seq[Any](/*46.109*/controllers/*46.120*/.compras.routes.CertificacionesReportesController.reporteElevaciones(true))),format.raw/*46.194*/(""""> Reporte Elevaciones</a></li>
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteElevacionesSinDescuentos" data-url=""""),_display_(Seq[Any](/*47.122*/controllers/*47.133*/.compras.routes.CertificacionesReportesController.reporteElevaciones(false))),format.raw/*47.208*/(""""> Reporte Elevaciones Sin Descuentos</a></li>
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reportePlanillaSueldos" data-url=""""),_display_(Seq[Any](/*48.113*/controllers/*48.124*/.compras.routes.CertificacionesReportesController.reportePlanillaSueldos())),format.raw/*48.198*/(""""> Reporte Planilla Sueldos</a></li>
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
				  	"""),_display_(Seq[Any](/*60.9*/if(Permiso.check("certificacionesPasarCertificado"))/*60.61*/ {_display_(Seq[Any](format.raw/*60.63*/("""
				  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="accionCargarFechaCertificacion" data-url=""""),_display_(Seq[Any](/*61.122*/controllers/*61.133*/.compras.routes.CertificacionesAccionesController.modalEditarFechaCertificacion())),format.raw/*61.214*/(""""> Editar fecha certificacion</a></li>	
				    """)))})),format.raw/*62.10*/("""
				  	"""),_display_(Seq[Any](/*63.9*/if(Permiso.check("certificacionesEditarCuentaAnalitica"))/*63.66*/ {_display_(Seq[Any](format.raw/*63.68*/("""
				  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*64.113*/controllers/*64.124*/.compras.routes.CertificacionesController.modalEditarCuentaAnalica())),format.raw/*64.192*/(""""> Editar cuenta analitica</a></li>	
				    """)))})),format.raw/*65.10*/("""
				    """),_display_(Seq[Any](/*66.10*/if(Permiso.check("certificacionesPasarCurso"))/*66.56*/ {_display_(Seq[Any](format.raw/*66.58*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarEnCurso" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*67.111*/controllers/*67.122*/.compras.routes.CertificacionesAccionesController.modalPasarEnCurso())),format.raw/*67.191*/("""">Pasar a En Curso</a></li>
				    """)))})),format.raw/*68.10*/("""
				    """),_display_(Seq[Any](/*69.10*/if(Permiso.check("certificacionesPasarCertificado"))/*69.62*/ {_display_(Seq[Any](format.raw/*69.64*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarCertificado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*70.115*/controllers/*70.126*/.compras.routes.CertificacionesAccionesController.modalPasarCertificado())),format.raw/*70.199*/("""">Pasar a Certificado</a></li>	
				    """)))})),format.raw/*71.10*/("""
				    """),_display_(Seq[Any](/*72.10*/if(Permiso.check("certificacionesAprobar"))/*72.53*/ {_display_(Seq[Any](format.raw/*72.55*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*73.112*/controllers/*73.123*/.compras.routes.CertificacionesAccionesController.modalPasarAprobado())),format.raw/*73.193*/("""">Pasar a Aprobado</a></li>	
				    """)))})),format.raw/*74.10*/("""
				    """),_display_(Seq[Any](/*75.10*/if(Permiso.check("certificacionesPasarBorrador"))/*75.59*/ {_display_(Seq[Any](format.raw/*75.61*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*76.112*/controllers/*76.123*/.compras.routes.CertificacionesAccionesController.modalPasarBorrador())),format.raw/*76.193*/("""">Pasar a Borrador</a></li>
				    """)))})),format.raw/*77.10*/("""
				    """),_display_(Seq[Any](/*78.10*/if(Permiso.check("certificacionesPasarCancelado"))/*78.60*/ {_display_(Seq[Any](format.raw/*78.62*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*79.113*/controllers/*79.124*/.compras.routes.CertificacionesAccionesController.modalPasarCancelado())),format.raw/*79.195*/("""">Pasar a Cancelado</a></li>		
				  	""")))})),format.raw/*80.9*/("""
				  	"""),_display_(Seq[Any](/*81.9*/if(Permiso.check("certificacionesCrearAguinaldo"))/*81.59*/ {_display_(Seq[Any](format.raw/*81.61*/("""
				  		<li role="presentation"><a role="menuitem" id="accionCrearAguinaldo" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*82.112*/controllers/*82.123*/.compras.routes.CertificacionesAccionesController.modalCrearAguinaldo())),format.raw/*82.194*/("""">Crear Aguinaldo</a></li>
				  	""")))})),format.raw/*83.9*/("""
				  	
				  	<li role="presentation"><a role="menuitem" id="accionDuplicarMasivo" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*85.111*/controllers/*85.122*/.compras.routes.CertificacionesAccionesController.modalDuplicarMasivo())),format.raw/*85.193*/("""">Duplicar</a></li>
				  	"""),_display_(Seq[Any](/*86.9*/if(Permiso.check("certificacionesCrearGuardiasMonosMasivos"))/*86.70*/ {_display_(Seq[Any](format.raw/*86.72*/("""
				  		<li role="presentation">
				  		<a role="menuitem" tabindex="-1"
				  		href=""""),_display_(Seq[Any](/*89.16*/controllers/*89.27*/.compras.routes.CertificacionesController.crearMasivo())),format.raw/*89.82*/("""?"""),_display_(Seq[Any](/*89.84*/UriTrack/*89.92*/.encode())),format.raw/*89.101*/(""""> Crear GM Masivas</a></li>  
				  	""")))})),format.raw/*90.9*/("""
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*95.16*/controllers/*95.27*/.compras.routes.CertificacionesController.crear())),format.raw/*95.76*/("""?"""),_display_(Seq[Any](/*95.78*/UriTrack/*95.86*/.encode())),format.raw/*95.95*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*101.3*/views/*101.8*/.html.tags.successError())),format.raw/*101.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchCertificaciones" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*109.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*109.67*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso 
				  	"""),_display_(Seq[Any](/*112.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*112.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-certificado" rel="certificado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Certificado 
				  	"""),_display_(Seq[Any](/*115.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*115.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-imputado" rel="imputado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok glyphicon-ok-orange"></i><br>Aprobado 
				  	"""),_display_(Seq[Any](/*118.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*118.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*121.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*121.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-descuento" rel="cancelado" class="btn btn-default btn-filtros"><b>-</b><i class="glyphicon glyphicon glyphicon-usd"></i><br>Con descuento 
				  	"""),_display_(Seq[Any](/*124.9*/checkbox(formBuscador("btnFiltro[5]"), 'hidden -> "hidden"))),format.raw/*124.68*/("""
				  </button>
				</div>
				<!-- <div class="btn-group">
					<button type="button" id="btn-filtro-conDsescuento" rel="conDescuento" class="btn btn-default btn-filtros">
						<span class="signoDescuento">%</span><br>Con Descuentos 
				  		"""),_display_(Seq[Any](/*130.10*/checkbox(formBuscador("btnFiltro[5]"), 'hidden -> "hidden"))),format.raw/*130.69*/("""
				  	</button>
				</div> -->
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Referencia
					"""),_display_(Seq[Any](/*141.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*141.93*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*149.8*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*149.91*/("""
						"""),_display_(Seq[Any](/*150.8*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*150.110*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*155.22*/controllers/*155.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*155.84*/("""" 
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
				<label class="control-label">Expediente
					<div class="input-group">
						"""),_display_(Seq[Any](/*171.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*171.93*/("""
						"""),_display_(Seq[Any](/*172.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*172.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*177.22*/controllers/*177.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*177.87*/("""" 
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
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha de certificación</label>
				<div>
				"""),_display_(Seq[Any](/*192.6*/inputText(formBuscador("fecha_certificacion_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*192.151*/("""
				"""),_display_(Seq[Any](/*193.6*/inputText(formBuscador("fecha_certificacion_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*193.151*/("""
				</div>
				
			</div>
			
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					
					"""),_display_(Seq[Any](/*202.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*202.83*/("""
					"""),_display_(Seq[Any](/*203.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*203.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*208.20*/controllers/*208.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*208.84*/("""" 
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
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*221.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*221.166*/("""
				</label>
			</div>	
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Departamento</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*229.7*/inputText(formBuscador("departamento"),'class -> "form-control",'id -> "departamento"))),format.raw/*229.93*/("""
					"""),_display_(Seq[Any](/*230.7*/inputText(formBuscador("departamento_id"),'hidden -> "hidden",'id -> "departamento_id"))),format.raw/*230.94*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchDepartamento" 
								data-title="Selección de Departamento" 
								data-url=""""),_display_(Seq[Any](/*235.20*/controllers/*235.31*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*235.81*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.departamento.simple" 
								data-label="#departamento" 
								data-field="#departamento_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
					</span>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					C/M
					"""),_display_(Seq[Any](/*249.7*/select(formBuscador("cm"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*249.104*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					Tipo Cuenta
					"""),_display_(Seq[Any](/*255.7*/select(formBuscador("tipo_cuenta_id"), 
					TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*256.127*/("""
				</label>
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
				<a href=""""),_display_(Seq[Any](/*268.15*/controllers/*268.26*/.compras.routes.CertificacionesController.index())),format.raw/*268.75*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*276.3*/if(buscador.getTotalRowCount == 0)/*276.37*/ {_display_(Seq[Any](format.raw/*276.39*/("""
        
        <div class="well">
            <em>No se encuentran Certificaciones</em>
        </div>
        
    """)))}/*282.7*/else/*282.12*/{_display_(Seq[Any](format.raw/*282.13*/("""
    	
		<table id="listaCertificaciones" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="8">Mostrando """),_display_(Seq[Any](/*287.39*/buscador/*287.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*287.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="descuentoFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Referencia</th>
					<th width="70">Fecha</th>
					<th width="300">Proveedor</th>
					<th width="95">Expediente</th>
					<th width="95">Periodo</th>
					<th width="95">Tipo Cuenta</th>
					<th width="95">Base</th>
					<th width="95">Descuento</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*310.5*/for(certificacion <- buscador.getList) yield /*310.43*/ {_display_(Seq[Any](format.raw/*310.45*/("""
				"""),_display_(Seq[Any](/*311.6*/paginadorFicha/*311.20*/.add(certificacion.id.toString))),format.raw/*311.51*/("""
				<tr class="pointer """),_display_(Seq[Any](/*312.25*/getClassEstado(certificacion.estado))),format.raw/*312.61*/("""" data-estado=""""),_display_(Seq[Any](/*312.77*/certificacion/*312.90*/.estado_id)),format.raw/*312.100*/("""" data-href=""""),_display_(Seq[Any](/*312.114*/controllers/*312.125*/.compras.routes.CertificacionesController.ver(certificacion.id))),format.raw/*312.188*/("""&"""),_display_(Seq[Any](/*312.190*/UriTrack/*312.198*/.encode())),format.raw/*312.207*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*313.64*/certificacion/*313.77*/.id)),format.raw/*313.80*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*313.114*/certificacion/*313.127*/.id)),format.raw/*313.130*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*314.64*/controllers/*314.75*/.compras.routes.CertificacionesController.editar(certificacion.id))),format.raw/*314.141*/("""&"""),_display_(Seq[Any](/*314.143*/UriTrack/*314.151*/.encode())),format.raw/*314.160*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*315.11*/(certificacion.nombre))),format.raw/*315.33*/("""</td>
					<td class="fechaCertificacion">"""),_display_(Seq[Any](/*316.38*/if(certificacion.fecha_certificacion != null)/*316.83*/{_display_(Seq[Any](_display_(Seq[Any](/*316.85*/(utils.DateUtils.formatDate(certificacion.fecha_certificacion))))))})),format.raw/*316.149*/("""</td>
					<td>"""),_display_(Seq[Any](/*317.11*/if(certificacion.proveedor != null)/*317.46*/{_display_(Seq[Any](_display_(Seq[Any](/*317.48*/(certificacion.proveedor.nombre)))))})),format.raw/*317.81*/("""</td>
					<td>"""),_display_(Seq[Any](/*318.11*/if(certificacion.expediente != null)/*318.47*/{_display_(Seq[Any](_display_(Seq[Any](/*318.49*/certificacion/*318.62*/.expediente.getExpedienteEjercicio()))))})),format.raw/*318.99*/("""</td>
					<td>"""),_display_(Seq[Any](/*319.11*/if(certificacion.periodo != null)/*319.44*/{_display_(Seq[Any](_display_(Seq[Any](/*319.46*/(certificacion.periodo.nombre)))))})),format.raw/*319.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*320.11*/if(certificacion.tipoCuenta != null)/*320.47*/{_display_(Seq[Any](_display_(Seq[Any](/*320.49*/certificacion/*320.62*/.tipoCuenta.nombre))))})),format.raw/*320.81*/("""</td>
					<td class="base" rel=""""),_display_(Seq[Any](/*321.29*/certificacion/*321.42*/.getBase())),format.raw/*321.52*/("""">"""),_display_(Seq[Any](/*321.55*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*321.106*/("""</td>
					<td class="descuento" rel=""""),_display_(Seq[Any](/*322.34*/certificacion/*322.47*/.getDescuento())),format.raw/*322.62*/("""">"""),_display_(Seq[Any](/*322.65*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*322.121*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*323.30*/certificacion/*323.43*/.getTotal())),format.raw/*323.54*/("""">"""),_display_(Seq[Any](/*323.57*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*323.109*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*324.26*/if(certificacion.estado != null)/*324.58*/{_display_(Seq[Any](_display_(Seq[Any](/*324.60*/(certificacion.estado.nombre)))))})),format.raw/*324.90*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*326.81*/controllers/*326.92*/.compras.routes.CertificacionesController.eliminar(certificacion.id))),format.raw/*326.160*/("""&"""),_display_(Seq[Any](/*326.162*/UriTrack/*326.170*/.encode())),format.raw/*326.179*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*331.15*/("""
             """),_display_(Seq[Any](/*332.15*/paginadorFicha/*332.29*/.guardar())),format.raw/*332.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="8">&nbsp</td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="descuentoFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*346.8*/views/*346.13*/.html.helpers.paginador(buscador, controllers.compras.routes.CertificacionesController.index()))),format.raw/*346.108*/("""
		</div>
<script>
$( function ()"""),format.raw/*349.15*/("""{"""),format.raw/*349.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*353.36*/("""{"""),format.raw/*353.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*356.2*/("""}"""),format.raw/*356.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*359.35*/("""{"""),format.raw/*359.36*/("""
		
		b = Number($(this).attr("rel"))+b
	"""),format.raw/*362.2*/("""}"""),format.raw/*362.3*/(""")
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));	
	
	$(".descuento").each(function (index) """),format.raw/*365.40*/("""{"""),format.raw/*365.41*/("""
		
		c = Number($(this).attr("rel"))+c
	"""),format.raw/*368.2*/("""}"""),format.raw/*368.3*/(""")
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*371.36*/("""{"""),format.raw/*371.37*/("""
		
		  	selectAll();
	"""),format.raw/*374.2*/("""}"""),format.raw/*374.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*375.56*/("""{"""),format.raw/*375.57*/("""
		selectTrList();
	"""),format.raw/*377.2*/("""}"""),format.raw/*377.3*/(""");
"""),format.raw/*378.1*/("""}"""),format.raw/*378.2*/(""");

function selectTrList()"""),format.raw/*380.24*/("""{"""),format.raw/*380.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*384.36*/("""{"""),format.raw/*384.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*385.77*/("""{"""),format.raw/*385.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*387.3*/("""}"""),format.raw/*387.4*/("""
	"""),format.raw/*388.2*/("""}"""),format.raw/*388.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*392.35*/("""{"""),format.raw/*392.36*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*393.77*/("""{"""),format.raw/*393.78*/("""
			b = Number($(this).attr("rel"))+b 
		"""),format.raw/*395.3*/("""}"""),format.raw/*395.4*/("""
	"""),format.raw/*396.2*/("""}"""),format.raw/*396.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*400.40*/("""{"""),format.raw/*400.41*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*401.77*/("""{"""),format.raw/*401.78*/("""
			c = Number($(this).attr("rel"))+c 
		"""),format.raw/*403.3*/("""}"""),format.raw/*403.4*/("""
	"""),format.raw/*404.2*/("""}"""),format.raw/*404.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*407.1*/("""}"""),format.raw/*407.2*/("""

function selectAll()"""),format.raw/*409.21*/("""{"""),format.raw/*409.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*413.36*/("""{"""),format.raw/*413.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*416.2*/("""}"""),format.raw/*416.3*/("""else"""),format.raw/*416.7*/("""{"""),format.raw/*416.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*418.2*/("""}"""),format.raw/*418.3*/("""
	
	$(".total").each(function (index) """),format.raw/*420.36*/("""{"""),format.raw/*420.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*422.2*/("""}"""),format.raw/*422.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*426.35*/("""{"""),format.raw/*426.36*/("""
		b = Number($(this).attr("rel"))+b 
	"""),format.raw/*428.2*/("""}"""),format.raw/*428.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*432.40*/("""{"""),format.raw/*432.41*/("""
		c = Number($(this).attr("rel"))+c 
	"""),format.raw/*434.2*/("""}"""),format.raw/*434.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*437.1*/("""}"""),format.raw/*437.2*/("""

</script>		
 	 """)))})),format.raw/*440.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Certificacion],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Certificacion],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/indexCertificacion.scala.html
                    HASH: d5429090898a938f2247143a09cdf0efb90a6c26
                    MATRIX: 891->1|1152->258|1166->265|1250->269|1301->285|1315->291|1388->343|1455->188|1487->212|1545->382|1568->396|1859->131|1887->256|1914->379|1943->656|1981->659|1994->664|2074->735|2114->737|2665->1253|2722->1301|2762->1303|2903->1407|2924->1418|3004->1475|3063->1503|3107->1512|3172->1568|3212->1570|3361->1682|3382->1693|3477->1765|3544->1801|3692->1912|3713->1923|3800->1987|3971->2121|3992->2132|4089->2206|4279->2359|4300->2370|4398->2445|4594->2604|4615->2615|4712->2689|5248->3190|5309->3242|5349->3244|5508->3366|5529->3377|5633->3458|5714->3507|5758->3516|5824->3573|5864->3575|6014->3688|6035->3699|6126->3767|6204->3813|6250->3823|6305->3869|6345->3871|6493->3982|6514->3993|6606->4062|6675->4099|6721->4109|6782->4161|6822->4163|6974->4278|6995->4289|7091->4362|7164->4403|7210->4413|7262->4456|7302->4458|7451->4570|7472->4581|7565->4651|7635->4689|7681->4699|7739->4748|7779->4750|7928->4862|7949->4873|8042->4943|8111->4980|8157->4990|8216->5040|8256->5042|8406->5155|8427->5166|8521->5237|8591->5276|8635->5285|8694->5335|8734->5337|8883->5449|8904->5460|8998->5531|9064->5566|9220->5685|9241->5696|9335->5767|9398->5795|9468->5856|9508->5858|9634->5948|9654->5959|9731->6014|9769->6016|9786->6024|9818->6033|9888->6072|10009->6157|10029->6168|10100->6217|10138->6219|10155->6227|10186->6236|10362->6376|10376->6381|10424->6406|10822->6768|10904->6827|11128->7015|11210->7074|11436->7264|11518->7323|11755->7524|11837->7583|12065->7775|12147->7834|12390->8041|12472->8100|12755->8346|12837->8405|13073->8605|13182->8691|13365->8838|13471->8921|13515->8929|13641->9031|13859->9212|13880->9223|13954->9274|14402->9686|14510->9771|14554->9779|14682->9883|14900->10064|14921->10075|14998->10129|15462->10557|15631->10702|15673->10708|15842->10853|16046->11021|16145->11097|16188->11104|16288->11181|16491->11347|16512->11358|16588->11411|16967->11754|17150->11913|17376->12103|17485->12189|17528->12196|17638->12283|17851->12459|17872->12470|17945->12520|18340->12879|18461->12976|18605->13084|18795->13250|19189->13607|19210->13618|19282->13667|19426->13775|19470->13809|19511->13811|19650->13932|19664->13937|19704->13938|19915->14112|19933->14120|19988->14152|20824->14952|20879->14990|20920->14992|20962->14998|20986->15012|21040->15043|21102->15068|21161->15104|21214->15120|21237->15133|21271->15143|21323->15157|21345->15168|21432->15231|21472->15233|21491->15241|21524->15250|21627->15316|21650->15329|21676->15332|21748->15366|21772->15379|21799->15382|21908->15454|21929->15465|22019->15531|22059->15533|22078->15541|22111->15550|22210->15612|22255->15634|22335->15677|22390->15722|22439->15724|22531->15788|22584->15804|22629->15839|22678->15841|22738->15874|22791->15890|22837->15926|22886->15928|22909->15941|22973->15978|23026->15994|23069->16027|23118->16029|23176->16060|23229->16076|23275->16112|23324->16114|23347->16127|23393->16146|23464->16180|23487->16193|23520->16203|23560->16206|23635->16257|23711->16296|23734->16309|23772->16324|23812->16327|23892->16383|23964->16418|23987->16431|24021->16442|24061->16445|24137->16497|24205->16528|24247->16560|24296->16562|24353->16592|24486->16688|24507->16699|24599->16767|24639->16769|24658->16777|24691->16786|24837->16899|24889->16914|24913->16928|24946->16938|25421->17377|25436->17382|25555->17477|25617->17510|25647->17511|25748->17583|25778->17584|25848->17626|25877->17627|26016->17737|26046->17738|26115->17779|26144->17780|26288->17895|26318->17896|26387->17937|26416->17938|26560->18053|26590->18054|26641->18077|26670->18078|26757->18136|26787->18137|26835->18157|26864->18158|26895->18161|26924->18162|26980->18189|27010->18190|27111->18262|27141->18263|27247->18340|27277->18341|27346->18382|27375->18383|27405->18385|27434->18386|27601->18524|27631->18525|27737->18602|27767->18603|27836->18644|27865->18645|27895->18647|27924->18648|28094->18789|28124->18790|28230->18867|28260->18868|28329->18909|28358->18910|28388->18912|28417->18913|28555->19023|28584->19024|28635->19046|28665->19047|28769->19122|28799->19123|28894->19190|28923->19191|28955->19195|28984->19196|29078->19262|29107->19263|29174->19301|29204->19302|29271->19341|29300->19342|29467->19480|29497->19481|29564->19520|29593->19521|29763->19662|29793->19663|29860->19702|29889->19703|30027->19813|30056->19814|30106->19832
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|70->38|70->38|70->38|71->39|71->39|71->39|72->40|73->41|73->41|73->41|74->42|74->42|74->42|75->43|77->45|77->45|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|80->48|80->48|92->60|92->60|92->60|93->61|93->61|93->61|94->62|95->63|95->63|95->63|96->64|96->64|96->64|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|101->69|101->69|101->69|102->70|102->70|102->70|103->71|104->72|104->72|104->72|105->73|105->73|105->73|106->74|107->75|107->75|107->75|108->76|108->76|108->76|109->77|110->78|110->78|110->78|111->79|111->79|111->79|112->80|113->81|113->81|113->81|114->82|114->82|114->82|115->83|117->85|117->85|117->85|118->86|118->86|118->86|121->89|121->89|121->89|121->89|121->89|121->89|122->90|127->95|127->95|127->95|127->95|127->95|127->95|133->101|133->101|133->101|141->109|141->109|144->112|144->112|147->115|147->115|150->118|150->118|153->121|153->121|156->124|156->124|162->130|162->130|173->141|173->141|181->149|181->149|182->150|182->150|187->155|187->155|187->155|203->171|203->171|204->172|204->172|209->177|209->177|209->177|224->192|224->192|225->193|225->193|234->202|234->202|235->203|235->203|240->208|240->208|240->208|253->221|253->221|261->229|261->229|262->230|262->230|267->235|267->235|267->235|281->249|281->249|287->255|288->256|300->268|300->268|300->268|308->276|308->276|308->276|314->282|314->282|314->282|319->287|319->287|319->287|342->310|342->310|342->310|343->311|343->311|343->311|344->312|344->312|344->312|344->312|344->312|344->312|344->312|344->312|344->312|344->312|344->312|345->313|345->313|345->313|345->313|345->313|345->313|346->314|346->314|346->314|346->314|346->314|346->314|347->315|347->315|348->316|348->316|348->316|348->316|349->317|349->317|349->317|349->317|350->318|350->318|350->318|350->318|350->318|351->319|351->319|351->319|351->319|352->320|352->320|352->320|352->320|352->320|353->321|353->321|353->321|353->321|353->321|354->322|354->322|354->322|354->322|354->322|355->323|355->323|355->323|355->323|355->323|356->324|356->324|356->324|356->324|358->326|358->326|358->326|358->326|358->326|358->326|363->331|364->332|364->332|364->332|378->346|378->346|378->346|381->349|381->349|385->353|385->353|388->356|388->356|391->359|391->359|394->362|394->362|397->365|397->365|400->368|400->368|403->371|403->371|406->374|406->374|407->375|407->375|409->377|409->377|410->378|410->378|412->380|412->380|416->384|416->384|417->385|417->385|419->387|419->387|420->388|420->388|424->392|424->392|425->393|425->393|427->395|427->395|428->396|428->396|432->400|432->400|433->401|433->401|435->403|435->403|436->404|436->404|439->407|439->407|441->409|441->409|445->413|445->413|448->416|448->416|448->416|448->416|450->418|450->418|452->420|452->420|454->422|454->422|458->426|458->426|460->428|460->428|464->432|464->432|466->434|466->434|469->437|469->437|472->440
                    -- GENERATED --
                */
            