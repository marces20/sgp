
package views.html.compras.certificacionesCompras

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
object indexCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[CertificacionCompra],DynamicForm,utils.pagination.PaginadorFicha,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CertificacionCompra], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha,obras:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/compras/certificacionesCompras.js"))),format.raw/*7.81*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 79){
		classEstado = "borrador"
	}else if(i != null && i.id == 82){
		classEstado = "cancelada"
	}else if(i != null && i.id == 81){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.152*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.compras.mainCompras("Lista de Certificaciones Compras", scripts)/*23.77*/ {_display_(Seq[Any](format.raw/*23.79*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Certificaciones """),_display_(Seq[Any](/*27.35*/if(obras)/*27.44*/{_display_(Seq[Any](format.raw/*27.45*/("""Obras""")))}/*27.51*/else/*27.55*/{_display_(Seq[Any](format.raw/*27.56*/("""Compras""")))})),format.raw/*27.64*/("""</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*38.9*/if(obras)/*38.18*/{_display_(Seq[Any](format.raw/*38.19*/("""
						
					""")))}/*40.7*/else/*40.11*/{_display_(Seq[Any](format.raw/*40.12*/("""
					  	"""),_display_(Seq[Any](/*41.10*/if(Permiso.check("certificacionesComprasReporteCertificacion"))/*41.73*/ {_display_(Seq[Any](format.raw/*41.75*/("""
					  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="reporteCertificacion" data-url=""""),_display_(Seq[Any](/*42.113*/controllers/*42.124*/.compras.routes.CertificacionesComprasReportesController.reporteCertificacion())),format.raw/*42.203*/(""""> Certificacion</a></li>  
					  	""")))})),format.raw/*43.10*/("""
				  	""")))})),format.raw/*44.9*/("""
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
				  	"""),_display_(Seq[Any](/*56.9*/if(obras)/*56.18*/{_display_(Seq[Any](format.raw/*56.19*/("""
						
					""")))}/*58.7*/else/*58.11*/{_display_(Seq[Any](format.raw/*58.12*/("""
						"""),_display_(Seq[Any](/*59.8*/if(Permiso.check("certificacionesComprasPasarCertificado"))/*59.67*/ {_display_(Seq[Any](format.raw/*59.69*/("""
				  			<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="accionCargarFechaCertificacion" data-url=""""),_display_(Seq[Any](/*60.123*/controllers/*60.134*/.compras.routes.CertificacionesComprasAccionesController.modalEditarFechaCertificacion())),format.raw/*60.222*/(""""> Editar fecha certificacion</a></li>	
					    """)))})),format.raw/*61.11*/("""
					  	"""),_display_(Seq[Any](/*62.10*/if(Permiso.check("certificacionesComprasEditarCuentaAnalitica"))/*62.74*/ {_display_(Seq[Any](format.raw/*62.76*/("""
					  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*63.114*/controllers/*63.125*/.compras.routes.CertificacionesComprasController.modalEditarCuentaAnalica())),format.raw/*63.200*/(""""> Editar cuenta analitica</a></li>	
					    """)))})),format.raw/*64.11*/("""
					    """),_display_(Seq[Any](/*65.11*/if(Permiso.check("certificacionesComprasPasarEnCurso"))/*65.66*/ {_display_(Seq[Any](format.raw/*65.68*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarEnCurso" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*66.112*/controllers/*66.123*/.compras.routes.CertificacionesComprasAccionesController.modalPasarEnCurso())),format.raw/*66.199*/("""">Pasar a En Curso</a></li>
					    """)))})),format.raw/*67.11*/("""
					    """),_display_(Seq[Any](/*68.11*/if(Permiso.check("certificacionesComprasPasarCertificado"))/*68.70*/ {_display_(Seq[Any](format.raw/*68.72*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarCertificado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*69.116*/controllers/*69.127*/.compras.routes.CertificacionesComprasAccionesController.modalPasarCertificado())),format.raw/*69.207*/("""">Pasar a Certificado</a></li>	
					    """)))})),format.raw/*70.11*/("""
					    """),_display_(Seq[Any](/*71.11*/if(Permiso.check("certificacionesComprasPasarBorrador"))/*71.67*/ {_display_(Seq[Any](format.raw/*71.69*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*72.113*/controllers/*72.124*/.compras.routes.CertificacionesComprasAccionesController.modalPasarBorrador())),format.raw/*72.201*/("""">Pasar a Borrador</a></li>
					    """)))})),format.raw/*73.11*/("""
					    """),_display_(Seq[Any](/*74.11*/if(Permiso.check("certificacionesComprasPasarCancelado"))/*74.68*/ {_display_(Seq[Any](format.raw/*74.70*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*75.114*/controllers/*75.125*/.compras.routes.CertificacionesComprasAccionesController.modalPasarCancelado())),format.raw/*75.203*/("""">Pasar a Cancelado</a></li>		
					  	""")))})),format.raw/*76.10*/("""
					""")))})),format.raw/*77.7*/("""
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					"""),_display_(Seq[Any](/*82.7*/if(obras)/*82.16*/{_display_(Seq[Any](format.raw/*82.17*/("""
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.compras.routes.CertificacionesObrasController.crear())),format.raw/*83.82*/("""?"""),_display_(Seq[Any](/*83.84*/UriTrack/*83.92*/.encode())),format.raw/*83.101*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
					""")))}/*84.7*/else/*84.11*/{_display_(Seq[Any](format.raw/*84.12*/("""
					  	<a href=""""),_display_(Seq[Any](/*85.19*/controllers/*85.30*/.compras.routes.CertificacionesComprasController.crear())),format.raw/*85.86*/("""?"""),_display_(Seq[Any](/*85.88*/UriTrack/*85.96*/.encode())),format.raw/*85.105*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
				  	""")))})),format.raw/*86.9*/("""
					
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*93.3*/views/*93.8*/.html.tags.successError())),format.raw/*93.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchCertificaciones" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*101.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*101.67*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso 
				  	"""),_display_(Seq[Any](/*104.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*104.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-certificado" rel="certificado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Certificado 
				  	"""),_display_(Seq[Any](/*107.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*107.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*110.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*110.68*/("""
				  </button>
				</div>
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Referencia
					"""),_display_(Seq[Any](/*121.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*121.93*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*129.8*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*129.91*/("""
						"""),_display_(Seq[Any](/*130.8*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*130.110*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*135.22*/controllers/*135.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*135.84*/("""" 
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
						"""),_display_(Seq[Any](/*151.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*151.93*/("""
						"""),_display_(Seq[Any](/*152.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*152.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*157.22*/controllers/*157.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*157.87*/("""" 
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
				"""),_display_(Seq[Any](/*172.6*/inputText(formBuscador("fecha_certificacion_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*172.151*/("""
				"""),_display_(Seq[Any](/*173.6*/inputText(formBuscador("fecha_certificacion_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*173.151*/("""
				</div>
				
			</div>
			
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					
					"""),_display_(Seq[Any](/*182.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*182.83*/("""
					"""),_display_(Seq[Any](/*183.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*183.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*188.20*/controllers/*188.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*188.84*/("""" 
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
					"""),_display_(Seq[Any](/*201.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*201.166*/("""
				</label>
			</div>	
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Departamento</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*209.7*/inputText(formBuscador("departamento"),'class -> "form-control",'id -> "departamento"))),format.raw/*209.93*/("""
					"""),_display_(Seq[Any](/*210.7*/inputText(formBuscador("departamento_id"),'hidden -> "hidden",'id -> "departamento_id"))),format.raw/*210.94*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchDepartamento" 
								data-title="Selección de Departamento" 
								data-url=""""),_display_(Seq[Any](/*215.20*/controllers/*215.31*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*215.81*/("""" 
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
				<label class="control-label">Rubro
				"""),_display_(Seq[Any](/*228.6*/select(formBuscador("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*229.126*/("""
				 </label>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					Tipo Cuenta
					"""),_display_(Seq[Any](/*235.7*/select(formBuscador("tipo_cuenta_id"), 
					TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*236.127*/("""
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
				<a href=""""),_display_(Seq[Any](/*248.15*/controllers/*248.26*/.compras.routes.CertificacionesComprasController.index())),format.raw/*248.82*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*256.3*/if(buscador.getTotalRowCount == 0)/*256.37*/ {_display_(Seq[Any](format.raw/*256.39*/("""
        
        <div class="well">
            <em>No se encuentran Certificaciones</em>
        </div>
        
    """)))}/*262.7*/else/*262.12*/{_display_(Seq[Any](format.raw/*262.13*/("""
    	
		<table id="listaCertificaciones" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="8">Mostrando """),_display_(Seq[Any](/*267.39*/buscador/*267.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*267.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="descuentoFooter"></span></td>
			        <td><b>Total:</b> <span class="ajusteFooter"></span></td>
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
					<th width="95">Ajuste</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*292.5*/for(certificacion <- buscador.getList) yield /*292.43*/ {_display_(Seq[Any](format.raw/*292.45*/("""
				"""),_display_(Seq[Any](/*293.6*/paginadorFicha/*293.20*/.add(certificacion.id.toString))),format.raw/*293.51*/("""
				
				<tr class="pointer """),_display_(Seq[Any](/*295.25*/getClassEstado(certificacion.estado))),format.raw/*295.61*/("""" 
					data-estado=""""),_display_(Seq[Any](/*296.20*/certificacion/*296.33*/.estado_id)),format.raw/*296.43*/("""" 
					"""),_display_(Seq[Any](/*297.7*/if(obras)/*297.16*/{_display_(Seq[Any](format.raw/*297.17*/("""
						data-href=""""),_display_(Seq[Any](/*298.19*/controllers/*298.30*/.compras.routes.CertificacionesObrasController.ver(certificacion.id))),format.raw/*298.98*/("""&"""),_display_(Seq[Any](/*298.100*/UriTrack/*298.108*/.encode())),format.raw/*298.117*/(""""
					""")))}/*299.7*/else/*299.11*/{_display_(Seq[Any](format.raw/*299.12*/("""
						data-href=""""),_display_(Seq[Any](/*300.19*/controllers/*300.30*/.compras.routes.CertificacionesComprasController.ver(certificacion.id))),format.raw/*300.100*/("""&"""),_display_(Seq[Any](/*300.102*/UriTrack/*300.110*/.encode())),format.raw/*300.119*/(""""
					""")))})),format.raw/*301.7*/(""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*302.64*/certificacion/*302.77*/.id)),format.raw/*302.80*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*302.114*/certificacion/*302.127*/.id)),format.raw/*302.130*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" 
					"""),_display_(Seq[Any](/*304.7*/if(obras)/*304.16*/{_display_(Seq[Any](format.raw/*304.17*/("""
						href=""""),_display_(Seq[Any](/*305.14*/controllers/*305.25*/.compras.routes.CertificacionesObrasController.editar(certificacion.id))),format.raw/*305.96*/("""&"""),_display_(Seq[Any](/*305.98*/UriTrack/*305.106*/.encode())),format.raw/*305.115*/(""""
					""")))}/*306.7*/else/*306.11*/{_display_(Seq[Any](format.raw/*306.12*/("""
						href=""""),_display_(Seq[Any](/*307.14*/controllers/*307.25*/.compras.routes.CertificacionesComprasController.editar(certificacion.id))),format.raw/*307.98*/("""&"""),_display_(Seq[Any](/*307.100*/UriTrack/*307.108*/.encode())),format.raw/*307.117*/(""""
					""")))})),format.raw/*308.7*/("""
					>
					<i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*311.11*/(certificacion.nombre))),format.raw/*311.33*/("""</td>
					<td class="fechaCertificacion">"""),_display_(Seq[Any](/*312.38*/if(certificacion.fecha_certificacion != null)/*312.83*/{_display_(Seq[Any](_display_(Seq[Any](/*312.85*/(utils.DateUtils.formatDate(certificacion.fecha_certificacion))))))})),format.raw/*312.149*/("""</td>
					<td>"""),_display_(Seq[Any](/*313.11*/if(certificacion.proveedor != null)/*313.46*/{_display_(Seq[Any](_display_(Seq[Any](/*313.48*/(certificacion.proveedor.nombre)))))})),format.raw/*313.81*/("""</td>
					<td>"""),_display_(Seq[Any](/*314.11*/if(certificacion.expediente != null)/*314.47*/{_display_(Seq[Any](_display_(Seq[Any](/*314.49*/certificacion/*314.62*/.expediente.getExpedienteEjercicio()))))})),format.raw/*314.99*/("""</td>
					<td>"""),_display_(Seq[Any](/*315.11*/if(certificacion.periodo != null)/*315.44*/{_display_(Seq[Any](_display_(Seq[Any](/*315.46*/(certificacion.periodo.nombre)))))})),format.raw/*315.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*316.11*/if(certificacion.tipoCuenta != null)/*316.47*/{_display_(Seq[Any](_display_(Seq[Any](/*316.49*/certificacion/*316.62*/.tipoCuenta.nombre))))})),format.raw/*316.81*/("""</td>
					<td class="base" rel=""""),_display_(Seq[Any](/*317.29*/certificacion/*317.42*/.getBase())),format.raw/*317.52*/("""">"""),_display_(Seq[Any](/*317.55*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*317.106*/("""</td>
					<td class="descuento" rel=""""),_display_(Seq[Any](/*318.34*/certificacion/*318.47*/.getDescuento())),format.raw/*318.62*/("""">"""),_display_(Seq[Any](/*318.65*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*318.121*/("""</td>
					<td class="ajuste" rel=""""),_display_(Seq[Any](/*319.31*/certificacion/*319.44*/.getTotalAjuste())),format.raw/*319.61*/("""">"""),_display_(Seq[Any](/*319.64*/(utils.NumberUtils.moneda(certificacion.getTotalAjuste())))),format.raw/*319.122*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*320.30*/certificacion/*320.43*/.getTotal())),format.raw/*320.54*/("""">"""),_display_(Seq[Any](/*320.57*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*320.109*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*321.26*/if(certificacion.estado != null)/*321.58*/{_display_(Seq[Any](_display_(Seq[Any](/*321.60*/(certificacion.estado.nombre)))))})),format.raw/*321.90*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" 
							"""),_display_(Seq[Any](/*324.9*/if(obras)/*324.18*/{_display_(Seq[Any](format.raw/*324.19*/("""
								href=""""),_display_(Seq[Any](/*325.16*/controllers/*325.27*/.compras.routes.CertificacionesObrasController.eliminar(certificacion.id))),format.raw/*325.100*/("""&"""),_display_(Seq[Any](/*325.102*/UriTrack/*325.110*/.encode())),format.raw/*325.119*/(""""
							""")))}/*326.9*/else/*326.13*/{_display_(Seq[Any](format.raw/*326.14*/("""
								href=""""),_display_(Seq[Any](/*327.16*/controllers/*327.27*/.compras.routes.CertificacionesComprasController.eliminar(certificacion.id))),format.raw/*327.102*/("""&"""),_display_(Seq[Any](/*327.104*/UriTrack/*327.112*/.encode())),format.raw/*327.121*/(""""
							""")))})),format.raw/*328.9*/("""><i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*332.15*/("""
             """),_display_(Seq[Any](/*333.15*/paginadorFicha/*333.29*/.guardar())),format.raw/*333.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="8">&nbsp</td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="descuentoFooter"></span></td>
			        <td><b>Total:</b> <span class="ajusteFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
			"""),_display_(Seq[Any](/*348.5*/if(obras)/*348.14*/{_display_(Seq[Any](format.raw/*348.15*/("""
				"""),_display_(Seq[Any](/*349.6*/views/*349.11*/.html.helpers.paginador(buscador, controllers.compras.routes.CertificacionesObrasController.index()))),format.raw/*349.111*/("""
			""")))}/*350.5*/else/*350.9*/{_display_(Seq[Any](format.raw/*350.10*/("""
				"""),_display_(Seq[Any](/*351.6*/views/*351.11*/.html.helpers.paginador(buscador, controllers.compras.routes.CertificacionesComprasController.index()))),format.raw/*351.113*/("""
			""")))})),format.raw/*352.5*/("""
		    
		</div>
<script>
$( function ()"""),format.raw/*356.15*/("""{"""),format.raw/*356.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	var z = 0;
	$(".total").each(function (index) """),format.raw/*361.36*/("""{"""),format.raw/*361.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*364.2*/("""}"""),format.raw/*364.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*367.37*/("""{"""),format.raw/*367.38*/("""
		
		z = Number($(this).attr("rel"))+z 
	"""),format.raw/*370.2*/("""}"""),format.raw/*370.3*/(""")
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(z).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*373.35*/("""{"""),format.raw/*373.36*/("""
		
		b = Number($(this).attr("rel"))+b
	"""),format.raw/*376.2*/("""}"""),format.raw/*376.3*/(""")
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));	
	
	$(".descuento").each(function (index) """),format.raw/*379.40*/("""{"""),format.raw/*379.41*/("""
		
		c = Number($(this).attr("rel"))+c
	"""),format.raw/*382.2*/("""}"""),format.raw/*382.3*/(""")
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*385.36*/("""{"""),format.raw/*385.37*/("""
		
		  	selectAll();
	"""),format.raw/*388.2*/("""}"""),format.raw/*388.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*389.56*/("""{"""),format.raw/*389.57*/("""
		selectTrList();
	"""),format.raw/*391.2*/("""}"""),format.raw/*391.3*/(""");
"""),format.raw/*392.1*/("""}"""),format.raw/*392.2*/(""");

function selectTrList()"""),format.raw/*394.24*/("""{"""),format.raw/*394.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	var z = 0;
	$(".total").each(function (index) """),format.raw/*399.36*/("""{"""),format.raw/*399.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*400.77*/("""{"""),format.raw/*400.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*402.3*/("""}"""),format.raw/*402.4*/("""
	"""),format.raw/*403.2*/("""}"""),format.raw/*403.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*407.37*/("""{"""),format.raw/*407.38*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*408.77*/("""{"""),format.raw/*408.78*/("""
			z = Number($(this).attr("rel"))+z 
		"""),format.raw/*410.3*/("""}"""),format.raw/*410.4*/("""
	"""),format.raw/*411.2*/("""}"""),format.raw/*411.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(z).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*415.35*/("""{"""),format.raw/*415.36*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*416.77*/("""{"""),format.raw/*416.78*/("""
			b = Number($(this).attr("rel"))+b 
		"""),format.raw/*418.3*/("""}"""),format.raw/*418.4*/("""
	"""),format.raw/*419.2*/("""}"""),format.raw/*419.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*423.40*/("""{"""),format.raw/*423.41*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*424.77*/("""{"""),format.raw/*424.78*/("""
			c = Number($(this).attr("rel"))+c 
		"""),format.raw/*426.3*/("""}"""),format.raw/*426.4*/("""
	"""),format.raw/*427.2*/("""}"""),format.raw/*427.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*430.1*/("""}"""),format.raw/*430.2*/("""

function selectAll()"""),format.raw/*432.21*/("""{"""),format.raw/*432.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	var z = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*437.36*/("""{"""),format.raw/*437.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*440.2*/("""}"""),format.raw/*440.3*/("""else"""),format.raw/*440.7*/("""{"""),format.raw/*440.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*442.2*/("""}"""),format.raw/*442.3*/("""
	
	$(".total").each(function (index) """),format.raw/*444.36*/("""{"""),format.raw/*444.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*446.2*/("""}"""),format.raw/*446.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*450.37*/("""{"""),format.raw/*450.38*/("""
		z = Number($(this).attr("rel"))+z 
	"""),format.raw/*452.2*/("""}"""),format.raw/*452.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(z).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*456.35*/("""{"""),format.raw/*456.36*/("""
		b = Number($(this).attr("rel"))+b 
	"""),format.raw/*458.2*/("""}"""),format.raw/*458.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*462.40*/("""{"""),format.raw/*462.41*/("""
		c = Number($(this).attr("rel"))+c 
	"""),format.raw/*464.2*/("""}"""),format.raw/*464.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*467.1*/("""}"""),format.raw/*467.2*/("""

</script>		
 	 """)))})),format.raw/*470.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[CertificacionCompra],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha,obras:Boolean): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha,obras)
    
    def f:((utils.pagination.Pagination[CertificacionCompra],DynamicForm,utils.pagination.PaginadorFicha,Boolean) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha,obras) => apply(buscador,formBuscador,paginadorFicha,obras)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/indexCertificacion.scala.html
                    HASH: 422607202b02d1a38de3801d448136c2deef8c4a
                    MATRIX: 912->1|1193->278|1207->285|1291->289|1342->305|1356->311|1436->370|1503->208|1535->232|1593->409|1616->423|1907->151|1935->276|1962->406|1991->683|2029->686|2042->691|2121->761|2161->763|2306->872|2324->881|2363->882|2388->888|2401->892|2440->893|2480->901|2915->1301|2933->1310|2972->1311|3004->1325|3017->1329|3056->1330|3102->1340|3174->1403|3214->1405|3364->1518|3385->1529|3487->1608|3556->1645|3596->1654|4096->2119|4114->2128|4153->2129|4185->2143|4198->2147|4237->2148|4280->2156|4348->2215|4388->2217|4548->2340|4569->2351|4680->2439|4762->2489|4808->2499|4881->2563|4921->2565|5072->2679|5093->2690|5191->2765|5270->2812|5317->2823|5381->2878|5421->2880|5570->2992|5591->3003|5690->3079|5760->3117|5807->3128|5875->3187|5915->3189|6068->3305|6089->3316|6192->3396|6266->3438|6313->3449|6378->3505|6418->3507|6568->3620|6589->3631|6689->3708|6759->3746|6806->3757|6872->3814|6912->3816|7063->3930|7084->3941|7185->4019|7257->4059|7295->4066|7406->4142|7424->4151|7463->4152|7516->4169|7536->4180|7612->4234|7650->4236|7667->4244|7699->4253|7820->4356|7833->4360|7872->4361|7927->4380|7947->4391|8025->4447|8063->4449|8080->4457|8112->4466|8248->4571|8333->4621|8346->4626|8393->4651|8791->5013|8873->5072|9097->5260|9179->5319|9405->5509|9487->5568|9715->5760|9797->5819|10028->6014|10137->6100|10320->6247|10426->6330|10470->6338|10596->6440|10814->6621|10835->6632|10909->6683|11357->7095|11465->7180|11509->7188|11637->7292|11855->7473|11876->7484|11953->7538|12417->7966|12586->8111|12628->8117|12797->8262|13001->8430|13100->8506|13143->8513|13243->8590|13446->8756|13467->8767|13543->8820|13922->9163|14105->9322|14331->9512|14440->9598|14483->9605|14593->9692|14806->9868|14827->9879|14900->9929|15289->10282|15478->10447|15623->10556|15813->10722|16207->11079|16228->11090|16307->11146|16451->11254|16495->11288|16536->11290|16675->11411|16689->11416|16729->11417|16940->11591|16958->11599|17013->11631|17950->12532|18005->12570|18046->12572|18088->12578|18112->12592|18166->12623|18233->12653|18292->12689|18351->12711|18374->12724|18407->12734|18452->12743|18471->12752|18511->12753|18567->12772|18588->12783|18679->12851|18719->12853|18738->12861|18771->12870|18798->12878|18812->12882|18852->12883|18908->12902|18929->12913|19023->12983|19063->12985|19082->12993|19115->13002|19155->13010|19257->13075|19280->13088|19306->13091|19378->13125|19402->13138|19429->13141|19537->13213|19556->13222|19596->13223|19647->13237|19668->13248|19762->13319|19801->13321|19820->13329|19853->13338|19880->13346|19894->13350|19934->13351|19985->13365|20006->13376|20102->13449|20142->13451|20161->13459|20194->13468|20234->13476|20344->13549|20389->13571|20469->13614|20524->13659|20573->13661|20665->13725|20718->13741|20763->13776|20812->13778|20872->13811|20925->13827|20971->13863|21020->13865|21043->13878|21107->13915|21160->13931|21203->13964|21252->13966|21310->13997|21363->14013|21409->14049|21458->14051|21481->14064|21527->14083|21598->14117|21621->14130|21654->14140|21694->14143|21769->14194|21845->14233|21868->14246|21906->14261|21946->14264|22026->14320|22099->14356|22122->14369|22162->14386|22202->14389|22284->14447|22356->14482|22379->14495|22413->14506|22453->14509|22529->14561|22597->14592|22639->14624|22688->14626|22745->14656|22879->14754|22898->14763|22938->14764|22991->14780|23012->14791|23109->14864|23149->14866|23168->14874|23201->14883|23230->14893|23244->14897|23284->14898|23337->14914|23358->14925|23457->15000|23497->15002|23516->15010|23549->15019|23591->15029|23728->15133|23780->15148|23804->15162|23837->15172|24378->15677|24397->15686|24437->15687|24479->15693|24494->15698|24618->15798|24642->15803|24655->15807|24695->15808|24737->15814|24752->15819|24878->15921|24915->15926|24984->15966|25014->15967|25127->16051|25157->16052|25227->16094|25256->16095|25397->16207|25427->16208|25497->16250|25526->16251|25666->16362|25696->16363|25765->16404|25794->16405|25938->16520|25968->16521|26037->16562|26066->16563|26210->16678|26240->16679|26291->16702|26320->16703|26407->16761|26437->16762|26485->16782|26514->16783|26545->16786|26574->16787|26630->16814|26660->16815|26773->16899|26803->16900|26909->16977|26939->16978|27008->17019|27037->17020|27067->17022|27096->17023|27265->17163|27295->17164|27401->17241|27431->17242|27500->17283|27529->17284|27559->17286|27588->17287|27757->17427|27787->17428|27893->17505|27923->17506|27992->17547|28021->17548|28051->17550|28080->17551|28250->17692|28280->17693|28386->17770|28416->17771|28485->17812|28514->17813|28544->17815|28573->17816|28711->17926|28740->17927|28791->17949|28821->17950|28938->18038|28968->18039|29063->18106|29092->18107|29124->18111|29153->18112|29247->18178|29276->18179|29343->18217|29373->18218|29440->18257|29469->18258|29638->18398|29668->18399|29735->18438|29764->18439|29933->18579|29963->18580|30030->18619|30059->18620|30229->18761|30259->18762|30326->18801|30355->18802|30493->18912|30522->18913|30572->18931
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|59->27|59->27|59->27|59->27|59->27|59->27|59->27|70->38|70->38|70->38|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42|75->43|76->44|88->56|88->56|88->56|90->58|90->58|90->58|91->59|91->59|91->59|92->60|92->60|92->60|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|97->65|97->65|97->65|98->66|98->66|98->66|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|103->71|103->71|103->71|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|109->77|114->82|114->82|114->82|115->83|115->83|115->83|115->83|115->83|115->83|116->84|116->84|116->84|117->85|117->85|117->85|117->85|117->85|117->85|118->86|125->93|125->93|125->93|133->101|133->101|136->104|136->104|139->107|139->107|142->110|142->110|153->121|153->121|161->129|161->129|162->130|162->130|167->135|167->135|167->135|183->151|183->151|184->152|184->152|189->157|189->157|189->157|204->172|204->172|205->173|205->173|214->182|214->182|215->183|215->183|220->188|220->188|220->188|233->201|233->201|241->209|241->209|242->210|242->210|247->215|247->215|247->215|260->228|261->229|267->235|268->236|280->248|280->248|280->248|288->256|288->256|288->256|294->262|294->262|294->262|299->267|299->267|299->267|324->292|324->292|324->292|325->293|325->293|325->293|327->295|327->295|328->296|328->296|328->296|329->297|329->297|329->297|330->298|330->298|330->298|330->298|330->298|330->298|331->299|331->299|331->299|332->300|332->300|332->300|332->300|332->300|332->300|333->301|334->302|334->302|334->302|334->302|334->302|334->302|336->304|336->304|336->304|337->305|337->305|337->305|337->305|337->305|337->305|338->306|338->306|338->306|339->307|339->307|339->307|339->307|339->307|339->307|340->308|343->311|343->311|344->312|344->312|344->312|344->312|345->313|345->313|345->313|345->313|346->314|346->314|346->314|346->314|346->314|347->315|347->315|347->315|347->315|348->316|348->316|348->316|348->316|348->316|349->317|349->317|349->317|349->317|349->317|350->318|350->318|350->318|350->318|350->318|351->319|351->319|351->319|351->319|351->319|352->320|352->320|352->320|352->320|352->320|353->321|353->321|353->321|353->321|356->324|356->324|356->324|357->325|357->325|357->325|357->325|357->325|357->325|358->326|358->326|358->326|359->327|359->327|359->327|359->327|359->327|359->327|360->328|364->332|365->333|365->333|365->333|380->348|380->348|380->348|381->349|381->349|381->349|382->350|382->350|382->350|383->351|383->351|383->351|384->352|388->356|388->356|393->361|393->361|396->364|396->364|399->367|399->367|402->370|402->370|405->373|405->373|408->376|408->376|411->379|411->379|414->382|414->382|417->385|417->385|420->388|420->388|421->389|421->389|423->391|423->391|424->392|424->392|426->394|426->394|431->399|431->399|432->400|432->400|434->402|434->402|435->403|435->403|439->407|439->407|440->408|440->408|442->410|442->410|443->411|443->411|447->415|447->415|448->416|448->416|450->418|450->418|451->419|451->419|455->423|455->423|456->424|456->424|458->426|458->426|459->427|459->427|462->430|462->430|464->432|464->432|469->437|469->437|472->440|472->440|472->440|472->440|474->442|474->442|476->444|476->444|478->446|478->446|482->450|482->450|484->452|484->452|488->456|488->456|490->458|490->458|494->462|494->462|496->464|496->464|499->467|499->467|502->470
                    -- GENERATED --
                */
            