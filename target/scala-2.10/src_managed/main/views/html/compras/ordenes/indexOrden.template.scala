
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
object indexOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Orden],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Orden], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/compras/ordenes.js"))),format.raw/*7.66*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 12){
		classEstado = "borrador"
	}else if(i != null && i.id == 13){
		classEstado = "cancelada"
	}else if(i != null && i.id == 11){
		classEstado = "autorizado"
	}else if(i != null && i.id == 87){
		classEstado = "ordenPrecurso"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.124*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.compras.mainCompras("Lista de órdenes", scripts)/*25.61*/ {_display_(Seq[Any](format.raw/*25.63*/("""
	<div class="page-header">
	
	
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Ordenes de Compra</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				   
				    """),_display_(Seq[Any](/*43.10*/if(Permiso.check("ordenesImputacionDefinitiva"))/*43.58*/ {_display_(Seq[Any](format.raw/*43.60*/("""
				    <li role="presentation"><a role="menuitem" id="reporteImputacionDefinitiva" data-url=""""),_display_(Seq[Any](/*44.96*/controllers/*44.107*/.compras.routes.OrdenesReportesController.reporteImputacionDefinitivaGlobal())),format.raw/*44.184*/("""" tabindex="-1" href="#">Imputaci&oacute;n Definitiva</a></li>
				    """)))})),format.raw/*45.10*/("""
				    """),_display_(Seq[Any](/*46.10*/if(Permiso.check("ordenesCompraCuadroComparativo"))/*46.61*/ {_display_(Seq[Any](format.raw/*46.63*/("""
				    <li role="presentation"><a id="cuandroComparativoPrecios" data-url=""""),_display_(Seq[Any](/*47.78*/controllers/*47.89*/.compras.routes.OrdenesReportesController.cuadroComparativoPrecios())),format.raw/*47.157*/("""" href="#">Cuadro comparativo de precios</a></li>
				    """)))})),format.raw/*48.10*/("""
				    """),_display_(Seq[Any](/*49.10*/if(Permiso.check("ordenesCompraReporteCuadroAdjudicacion"))/*49.69*/ {_display_(Seq[Any](format.raw/*49.71*/("""
				    <li role="presentation"><a id="cuadroSugerenciaAdjudicación" data-url=""""),_display_(Seq[Any](/*50.81*/controllers/*50.92*/.compras.routes.OrdenesReportesController.cuadroSugerenciaAdjudicación())),format.raw/*50.164*/("""" href="#">Cuadro sugerencia adjudicación</a></li>
				    """)))})),format.raw/*51.10*/("""
				    """),_display_(Seq[Any](/*52.10*/if(Permiso.check("ordenesCompraReporteCuadroAdjudicacion"))/*52.69*/ {_display_(Seq[Any](format.raw/*52.71*/("""
				    <li role="presentation"><a id="exportacionDatos" data-url=""""),_display_(Seq[Any](/*53.69*/controllers/*53.80*/.compras.routes.OrdenesReportesController.exportacionDatos())),format.raw/*53.140*/("""" href="#">Exportacion Datos</a></li>
				    """)))})),format.raw/*54.10*/("""
				     """),_display_(Seq[Any](/*55.11*/if(Permiso.check("ordenesCompraReporteCuadroAdjudicacion"))/*55.70*/ {_display_(Seq[Any](format.raw/*55.72*/("""
				    <li role="presentation"><a id="exportacionDatosConLineas" data-url=""""),_display_(Seq[Any](/*56.78*/controllers/*56.89*/.compras.routes.OrdenesReportesController.exportacionDatosConLineas())),format.raw/*56.158*/("""" href="#">Exportacion Datos Detallado</a></li>
				    """)))})),format.raw/*57.10*/("""
				    """),_display_(Seq[Any](/*58.10*/if(Permiso.check("ordenesCompraReporteControlDolar"))/*58.63*/ {_display_(Seq[Any](format.raw/*58.65*/("""
				    <li role="presentation"><a id="controlDolar" data-url=""""),_display_(Seq[Any](/*59.65*/controllers/*59.76*/.compras.routes.OrdenesReportesController.controlDolar())),format.raw/*59.132*/("""" href="#">Control Dolar</a></li>
				    """)))})),format.raw/*60.10*/("""
				    """),_display_(Seq[Any](/*61.10*/if(Permiso.check("ordenesCompraReporteControProfe"))/*61.62*/ {_display_(Seq[Any](format.raw/*61.64*/("""
				    <li role="presentation"><a class="controlProfe" data-url=""""),_display_(Seq[Any](/*62.68*/controllers/*62.79*/.compras.routes.OrdenesReportesController.controlProfe(12))),format.raw/*62.137*/("""" href="#">Control PROFE 2021</a></li>
				    <li role="presentation"><a class="controlProfe" data-url=""""),_display_(Seq[Any](/*63.68*/controllers/*63.79*/.compras.routes.OrdenesReportesController.controlProfe(13))),format.raw/*63.137*/("""" href="#">Control PROFE 2022</a></li>
				    """)))})),format.raw/*64.10*/("""
				  	
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
					</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  					 
				  """),_display_(Seq[Any](/*77.8*/if(Permiso.check("ordenesCompraAccionGenerarOrdenCuadroAdjudicacion"))/*77.78*/ {_display_(Seq[Any](format.raw/*77.80*/("""
				 	<li role="presentation"><a id="accionOrdenCuadroAdjudicacion" href="#" data-url=""""),_display_(Seq[Any](/*78.89*/controllers/*78.100*/.compras.routes.OrdenesAccionesController.generarOrdenSegunCuadroSugerenia())),format.raw/*78.176*/("""" role="menuitem" tabindex="-1">Generar órden según cuadro adjudicación</a></li>
				  """)))})),format.raw/*79.8*/("""

				  """),_display_(Seq[Any](/*81.8*/if(Permiso.check("ordenesCompraCombinar"))/*81.50*/ {_display_(Seq[Any](format.raw/*81.52*/("""
				 	<li role="presentation"><a id="combinarOrdenesCompra" href="#" data-url=""""),_display_(Seq[Any](/*82.81*/controllers/*82.92*/.compras.routes.OrdenesAccionesController.combinar())),format.raw/*82.144*/("""" role="menuitem" tabindex="-1">Combinar ordenes de compra</a></li>
				  """)))})),format.raw/*83.8*/("""
				  	<li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Importar productos y cantidades</a></li>
				    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Aprobar Ordenes de Compra</a></li>
				    """),_display_(Seq[Any](/*86.10*/if(Permiso.check("ordenesComprasModificarCuentaAnalitica"))/*86.69*/ {_display_(Seq[Any](format.raw/*86.71*/("""
				    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*87.114*/controllers/*87.125*/.compras.routes.OrdenesController.modalEditarCuentaAnalica("index"))),format.raw/*87.192*/("""">Editar cuenta analitica</a></li>
				  	""")))})),format.raw/*88.9*/("""
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*93.16*/controllers/*93.27*/.compras.routes.OrdenesController.crear())),format.raw/*93.68*/("""?"""),_display_(Seq[Any](/*93.70*/UriTrack/*93.78*/.encode())),format.raw/*93.87*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Orden</a>
				</div>
			</div>
	</div>
	
	"""),_display_(Seq[Any](/*98.3*/if(flash.containsKey("success"))/*98.35*/ {_display_(Seq[Any](format.raw/*98.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*99.81*/flash/*99.86*/.get("success"))),format.raw/*99.101*/("""</div>
	""")))})),format.raw/*100.3*/("""
	"""),_display_(Seq[Any](/*101.3*/if(flash.containsKey("error"))/*101.33*/ {_display_(Seq[Any](format.raw/*101.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*102.84*/flash/*102.89*/.get("error"))),format.raw/*102.102*/("""</div>
	""")))})),format.raw/*103.3*/("""
	
	
	<div id="actions">
		<form action="" id="formSearchOrdenes" method="GET">
		<div class="row">
			<div class="col-sm-6 filtrosEstados" style="margin:0 0 5px 0px;" id="filtrosEstados">
				<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*112.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*112.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-enprecurso" rel="enprecurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-list-alt"></i><br>En PreCurso
				  	"""),_display_(Seq[Any](/*115.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*115.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso
				  	"""),_display_(Seq[Any](/*118.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*118.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok glyphicon-ok-orange"></i><br>Aprobado
				  	"""),_display_(Seq[Any](/*121.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*121.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
				  	"""),_display_(Seq[Any](/*124.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*124.68*/("""
				  </button>
				  
				</div>
			</div>
		</div>	 
		<div class="row">
    		<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Referencia
					"""),_display_(Seq[Any](/*134.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*134.93*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Responsable
					<div class="input-group">
						"""),_display_(Seq[Any](/*141.8*/inputText(formBuscador("create_usuario.id"), 'hidden -> "hidden", 'id -> "create_usuario_id"))),format.raw/*141.101*/("""
						"""),_display_(Seq[Any](/*142.8*/inputText(formBuscador("create_usuario.nombre"), 'name -> "", 'class -> "form-control", 'id -> "create_usuario"))),format.raw/*142.120*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchResponsable" 
										data-title="Selección de responsables" 
										data-url=""""),_display_(Seq[Any](/*147.22*/controllers/*147.33*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*147.88*/("""" 
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
			</div>
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*162.8*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*162.91*/("""
						"""),_display_(Seq[Any](/*163.8*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*163.110*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*168.22*/controllers/*168.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*168.84*/("""" 
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
						"""),_display_(Seq[Any](/*184.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*184.93*/("""
						"""),_display_(Seq[Any](/*185.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*185.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*190.22*/controllers/*190.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*190.87*/("""" 
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
				<label class="control-label">N° Orden de Provision</label>
				<div>	
				"""),_display_(Seq[Any](/*205.6*/inputText(formBuscador("numero_orden_provision_desde"), 
							  'class -> "form-control inputDesdeHasta", 
							  'id -> "numero_orden_pago_desde", 
							  'placeholder -> "Desde"))),format.raw/*208.34*/("""
				"""),_display_(Seq[Any](/*209.6*/inputText(formBuscador("numero_orden_provision_hasta"), 
						  'class -> "form-control inputDesdeHasta", 
						  'id -> "numero_orden_pago_hasta", 
						  'placeholder -> "Hasta"))),format.raw/*212.33*/("""
					  
				</div>	
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Fin</label>
				<div>
				"""),_display_(Seq[Any](/*219.6*/inputText(formBuscador("fecha_fin_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*219.132*/("""
				"""),_display_(Seq[Any](/*220.6*/inputText(formBuscador("fecha_fin_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*220.132*/("""
				</div>
				
			</div>    		
		</div>

		
		<div class="row">
			
			<div class="col-sm-2">
				<label class="control-label">Paciente
					<div class="input-group">
						"""),_display_(Seq[Any](/*232.8*/inputText(formBuscador("paciente_id"), 'hidden -> "hidden", 'id -> "paciente_id"))),format.raw/*232.89*/("""
						"""),_display_(Seq[Any](/*233.8*/inputText(formBuscador("paciente"), 'class -> "form-control", 'id -> "paciente"))),format.raw/*233.88*/("""
						<span class="input-group-addon"><a href="#" id="searchPaciente" data-title="Selección de pacientes" data-url=""""),_display_(Seq[Any](/*234.118*/controllers/*234.129*/.compras.routes.ClientesController.modalBuscar())),format.raw/*234.177*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.cliente.simple" data-label="#paciente" data-field="#paciente_id"><i class="glyphicon glyphicon-search"></i></a></span>
					</div>
				</label>
			</div>
			
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*241.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*241.166*/("""
				</label>
			</div>
			

			<div class="col-sm-4">
					<label for="producto_nombre" class="control-label">Producto</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*249.8*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*249.122*/("""
						"""),_display_(Seq[Any](/*250.8*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*250.89*/("""
						<span class="input-group-addon"><a href="#" id="searchProducto" 
																	data-title="Selección de producto" 
																	data-url=""""),_display_(Seq[Any](/*253.29*/controllers/*253.40*/.compras.routes.ProductosController.modalBuscar())),format.raw/*253.89*/("""" 
																	data-height="650" 
																	data-width="700" 
																	data-listen="modal.seleccion.producto.simple" 
																	data-label="#producto" data-field="#producto_id">
																	<i class="glyphicon glyphicon-search"></i></a></span>
					</div>
				</div>
			<div class="col-sm-2">
				<label class="control-label">Rubro
				"""),_display_(Seq[Any](/*263.6*/select(formBuscador("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*264.126*/("""
				 </label>
			</div>
			<div class="col-sm-2">
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*270.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*270.124*/("""
					"""),_display_(Seq[Any](/*271.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*271.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*274.30*/controllers/*274.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*274.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div>
		</div>	
		<div class="row">	
			<div class="col-sm-2">
				<div class="checkbox">
					<label class="control-label"> 
						Moneda Extrajera
						"""),_display_(Seq[Any](/*287.8*/checkbox(formBuscador("tipo_moneda")))),format.raw/*287.45*/("""
					</label> 
				</div> 
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					<!--  PROFE
					"""),_display_(Seq[Any](/*294.7*/select(formBuscador("profe"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*294.107*/("""-->
					Tipo Cuenta
					"""),_display_(Seq[Any](/*296.7*/select(formBuscador("tipo_cuenta_id"), 
					TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*297.127*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					Emergencia
					"""),_display_(Seq[Any](/*303.7*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*303.112*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					Perimido
					"""),_display_(Seq[Any](/*309.7*/select(formBuscador("perimido"),options("NO"->"NO","SI"->"SI"), 'class -> "form-control select"))),format.raw/*309.103*/("""
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
				<a href=""""),_display_(Seq[Any](/*322.15*/controllers/*322.26*/.compras.routes.OrdenesController.index())),format.raw/*322.67*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>

		</div>

		</form>
	</div>
	
	
	<div class="row">
		
	</div>
	
	"""),_display_(Seq[Any](/*336.3*/if(buscador.getTotalRowCount == 0)/*336.37*/ {_display_(Seq[Any](format.raw/*336.39*/("""
        
        <div class="well">
            <em>No se encuentran Ordenes</em>
        </div>
        
    """)))}/*342.7*/else/*342.12*/{_display_(Seq[Any](format.raw/*342.13*/("""
    	
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr style="background: #FFFFFF;">
			        <td colspan="9">Mostrando """),_display_(Seq[Any](/*348.39*/buscador/*348.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*348.79*/(""" resultado(s). </td>
			        <td><b>Base</b><br><span class="baseFooter"></span></td>
			        <td><b>Ajuste</b><br><span class="ajusteFooter"></span></td>
			        <td><b>Total</b><br><span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Referencia</th>
					<th width="70">Fecha</th>
					<th width="300">Proveedor</th>
					<th width="70">Provisión</th>
					<th width="70">Inicio</th>
					<th width="70">Fin</th>
					<th width="95">Expediente</th>
					<th width="95">Base</th>
					<th width="95">Ajuste</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*372.5*/for(orden <- buscador.getList) yield /*372.35*/ {_display_(Seq[Any](format.raw/*372.37*/("""
				"""),_display_(Seq[Any](/*373.6*/paginadorFicha/*373.20*/.add(orden.id.toString))),format.raw/*373.43*/("""
				<tr class="pointer """),_display_(Seq[Any](/*374.25*/getClassEstado(orden.estado))),format.raw/*374.53*/("""" data-href=""""),_display_(Seq[Any](/*374.67*/controllers/*374.78*/.compras.routes.OrdenesController.ver(orden.id))),format.raw/*374.125*/("""&"""),_display_(Seq[Any](/*374.127*/UriTrack/*374.135*/.encode())),format.raw/*374.144*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*375.64*/orden/*375.69*/.id)),format.raw/*375.72*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*375.106*/orden/*375.111*/.id)),format.raw/*375.114*/(""""/></td>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*377.61*/controllers/*377.72*/.compras.routes.OrdenesController.editar(orden.id))),format.raw/*377.122*/("""&"""),_display_(Seq[Any](/*377.124*/UriTrack/*377.132*/.encode())),format.raw/*377.141*/(""""><i class="glyphicon glyphicon-edit"></i></a>
						"""),_display_(Seq[Any](/*378.8*/if(orden.tipo_moneda != null)/*378.37*/{_display_(Seq[Any](format.raw/*378.38*/("""<span style="color:green;font-weight:bold;">M.E.</span>""")))})),format.raw/*378.94*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*380.11*/(orden.nombre))),format.raw/*380.25*/("""
						"""),_display_(Seq[Any](/*381.8*/if(orden.expediente != null)/*381.36*/{_display_(Seq[Any](format.raw/*381.37*/("""
							"""),_display_(Seq[Any](/*382.9*/if(orden.expediente.emergencia)/*382.40*/{_display_(Seq[Any](format.raw/*382.41*/("""
								<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
							""")))})),format.raw/*384.9*/("""
						""")))})),format.raw/*385.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*387.11*/if(orden.fecha_orden != null)/*387.40*/{_display_(Seq[Any](_display_(Seq[Any](/*387.42*/(utils.DateUtils.formatDate(orden.fecha_orden))))))})),format.raw/*387.90*/("""</td>
					<td>"""),_display_(Seq[Any](/*388.11*/if(orden.proveedor != null)/*388.38*/{_display_(Seq[Any](_display_(Seq[Any](/*388.40*/(orden.proveedor.nombre)))))})),format.raw/*388.65*/("""</td>
					<td>"""),_display_(Seq[Any](/*389.11*/(orden.numero_orden_provision))),format.raw/*389.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*390.11*/if(orden.fecha_inicio != null)/*390.41*/{_display_(Seq[Any](_display_(Seq[Any](/*390.43*/(utils.DateUtils.formatDate(orden.fecha_inicio))))))})),format.raw/*390.92*/("""</td>
					<td>"""),_display_(Seq[Any](/*391.11*/if(orden.fecha_fin != null)/*391.38*/{_display_(Seq[Any](_display_(Seq[Any](/*391.40*/(utils.DateUtils.formatDate(orden.fecha_fin))))))})),format.raw/*391.86*/("""</td>
					<td>"""),_display_(Seq[Any](/*392.11*/if(orden.expediente != null)/*392.39*/{_display_(Seq[Any](_display_(Seq[Any](/*392.41*/(orden.expediente.getExpedienteEjercicio())))))})),format.raw/*392.85*/("""</td>
					<td class="base" rel=""""),_display_(Seq[Any](/*393.29*/orden/*393.34*/.getTotal())),format.raw/*393.45*/("""">"""),_display_(Seq[Any](/*393.48*/(utils.NumberUtils.moneda(orden.getTotal())))),format.raw/*393.92*/("""</td>
					<td class="ajuste" rel=""""),_display_(Seq[Any](/*394.31*/orden/*394.36*/.getTotalAjuste())),format.raw/*394.53*/("""">"""),_display_(Seq[Any](/*394.56*/(utils.NumberUtils.moneda(orden.getTotalAjuste())))),format.raw/*394.106*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*395.30*/orden/*395.35*/.getTotalTotal())),format.raw/*395.51*/("""">"""),_display_(Seq[Any](/*395.54*/(utils.NumberUtils.moneda(orden.getTotalTotal())))),format.raw/*395.103*/("""</td>
					<td>"""),_display_(Seq[Any](/*396.11*/if(orden.estado != null)/*396.35*/{_display_(Seq[Any](_display_(Seq[Any](/*396.37*/(orden.estado.nombre)))))})),format.raw/*396.59*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*398.81*/controllers/*398.92*/.compras.routes.OrdenesController.eliminar(orden.id))),format.raw/*398.144*/("""&"""),_display_(Seq[Any](/*398.146*/UriTrack/*398.154*/.encode())),format.raw/*398.163*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*403.15*/("""
             """),_display_(Seq[Any](/*404.15*/paginadorFicha/*404.29*/.guardar())),format.raw/*404.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="9">&nbsp</td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="ajusteFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    			
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*418.8*/views/*418.13*/.html.helpers.paginador(buscador, controllers.compras.routes.OrdenesController.index()))),format.raw/*418.100*/("""
		</div>
<script>
$( function ()"""),format.raw/*421.15*/("""{"""),format.raw/*421.16*/("""
	var n = 0;
	var n2 = 0;
	var n3 = 0;
	$(".total").each(function (index) """),format.raw/*425.36*/("""{"""),format.raw/*425.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*428.2*/("""}"""),format.raw/*428.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*431.35*/("""{"""),format.raw/*431.36*/("""
		
		n2 = Number($(this).attr("rel"))+n2 
	"""),format.raw/*434.2*/("""}"""),format.raw/*434.3*/(""")
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*437.37*/("""{"""),format.raw/*437.38*/("""
		
		n3 = Number($(this).attr("rel"))+n3 
	"""),format.raw/*440.2*/("""}"""),format.raw/*440.3*/(""")
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*443.36*/("""{"""),format.raw/*443.37*/("""
		
		  	selectAll();
	"""),format.raw/*446.2*/("""}"""),format.raw/*446.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*447.56*/("""{"""),format.raw/*447.57*/("""
		selectTrList();
	"""),format.raw/*449.2*/("""}"""),format.raw/*449.3*/(""");
"""),format.raw/*450.1*/("""}"""),format.raw/*450.2*/(""");

function selectTrList()"""),format.raw/*452.24*/("""{"""),format.raw/*452.25*/("""
	var n = 0;
	var n2 = 0;
	var n3 = 0;
	$(".total").each(function (index) """),format.raw/*456.36*/("""{"""),format.raw/*456.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*457.77*/("""{"""),format.raw/*457.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*459.3*/("""}"""),format.raw/*459.4*/("""
	"""),format.raw/*460.2*/("""}"""),format.raw/*460.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*464.35*/("""{"""),format.raw/*464.36*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*465.77*/("""{"""),format.raw/*465.78*/("""
			n2 = Number($(this).attr("rel"))+n2 
		"""),format.raw/*467.3*/("""}"""),format.raw/*467.4*/("""
	"""),format.raw/*468.2*/("""}"""),format.raw/*468.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*472.37*/("""{"""),format.raw/*472.38*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*473.77*/("""{"""),format.raw/*473.78*/("""
			n3 = Number($(this).attr("rel"))+n3 
		"""),format.raw/*475.3*/("""}"""),format.raw/*475.4*/("""
	"""),format.raw/*476.2*/("""}"""),format.raw/*476.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
"""),format.raw/*479.1*/("""}"""),format.raw/*479.2*/("""

function selectAll()"""),format.raw/*481.21*/("""{"""),format.raw/*481.22*/("""
	var n = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*483.36*/("""{"""),format.raw/*483.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*486.2*/("""}"""),format.raw/*486.3*/("""else"""),format.raw/*486.7*/("""{"""),format.raw/*486.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*488.2*/("""}"""),format.raw/*488.3*/("""
	
	$(".total").each(function (index) """),format.raw/*490.36*/("""{"""),format.raw/*490.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*492.2*/("""}"""),format.raw/*492.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*496.35*/("""{"""),format.raw/*496.36*/("""
		n2 = Number($(this).attr("rel"))+n2 
	"""),format.raw/*498.2*/("""}"""),format.raw/*498.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(n2).toFixed(2)));
	
	$(".ajuste").each(function (index) """),format.raw/*502.37*/("""{"""),format.raw/*502.38*/("""
		n3 = Number($(this).attr("rel"))+n3 
	"""),format.raw/*504.2*/("""}"""),format.raw/*504.3*/(""")
	$(".ajusteFooter").empty();
	$(".ajusteFooter").append(formatNumberPesos(parseFloat(n3).toFixed(2)));
"""),format.raw/*507.1*/("""}"""),format.raw/*507.2*/("""

</script>		
 	 """)))})),format.raw/*510.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Orden],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Orden],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/indexOrden.scala.html
                    HASH: bf38133c316187150b1a04c5876b11d7f7d1cf18
                    MATRIX: 867->1|1120->250|1134->257|1218->261|1269->277|1283->283|1348->327|1415->180|1447->204|1505->366|1528->380|1887->123|1915->248|1942->363|1971->708|2009->711|2022->716|2085->770|2125->772|2683->1294|2740->1342|2780->1344|2912->1440|2933->1451|3033->1528|3137->1600|3183->1610|3243->1661|3283->1663|3397->1741|3417->1752|3508->1820|3599->1879|3645->1889|3713->1948|3753->1950|3870->2031|3890->2042|3985->2114|4077->2174|4123->2184|4191->2243|4231->2245|4336->2314|4356->2325|4439->2385|4518->2432|4565->2443|4633->2502|4673->2504|4787->2582|4807->2593|4899->2662|4988->2719|5034->2729|5096->2782|5136->2784|5237->2849|5257->2860|5336->2916|5411->2959|5457->2969|5518->3021|5558->3023|5662->3091|5682->3102|5763->3160|5905->3266|5925->3277|6006->3335|6086->3383|6528->3790|6607->3860|6647->3862|6772->3951|6793->3962|6892->4038|7011->4126|7055->4135|7106->4177|7146->4179|7263->4260|7283->4271|7358->4323|7464->4398|7767->4665|7835->4724|7875->4726|8026->4840|8047->4851|8137->4918|8211->4961|8332->5046|8352->5057|8415->5098|8453->5100|8470->5108|8501->5117|8659->5240|8700->5272|8740->5274|8857->5355|8871->5360|8909->5375|8950->5384|8989->5387|9029->5417|9070->5419|9191->5503|9206->5508|9243->5521|9284->5530|9704->5914|9786->5973|10015->6166|10097->6225|10320->6412|10402->6471|10638->6671|10720->6730|10947->6921|11029->6980|11263->7178|11372->7264|11553->7409|11670->7502|11714->7510|11850->7622|12071->7806|12092->7817|12170->7872|12624->8290|12730->8373|12774->8381|12900->8483|13118->8664|13139->8675|13213->8726|13661->9138|13769->9223|13813->9231|13941->9335|14159->9516|14180->9527|14257->9581|14716->10004|14925->10190|14967->10196|15173->10379|15344->10514|15494->10640|15536->10646|15686->10772|15898->10948|16002->11029|16046->11037|16149->11117|16305->11235|16327->11246|16399->11294|16734->11593|16917->11752|17119->11918|17257->12032|17301->12040|17405->12121|17595->12274|17616->12285|17688->12334|18093->12703|18282->12868|18474->13024|18615->13141|18658->13148|18761->13228|18955->13385|18976->13396|19051->13448|19529->13890|19589->13927|19747->14049|19871->14149|19934->14176|20124->14342|20267->14449|20396->14554|20537->14659|20657->14755|21055->15116|21076->15127|21140->15168|21316->15308|21360->15342|21401->15344|21532->15457|21546->15462|21586->15463|21773->15613|21791->15621|21846->15653|22708->16479|22755->16509|22796->16511|22838->16517|22862->16531|22908->16554|22970->16579|23021->16607|23072->16621|23093->16632|23164->16679|23204->16681|23223->16689|23256->16698|23359->16764|23374->16769|23400->16772|23472->16806|23488->16811|23515->16814|23631->16893|23652->16904|23726->16954|23766->16956|23785->16964|23818->16973|23908->17027|23947->17056|23987->17057|24076->17113|24135->17135|24172->17149|24216->17157|24254->17185|24294->17186|24339->17195|24380->17226|24420->17227|24546->17321|24586->17329|24645->17351|24684->17380|24733->17382|24808->17430|24861->17446|24898->17473|24947->17475|24999->17500|25052->17516|25105->17546|25158->17562|25198->17592|25247->17594|25323->17643|25376->17659|25413->17686|25462->17688|25535->17734|25588->17750|25626->17778|25675->17780|25746->17824|25817->17858|25832->17863|25866->17874|25906->17877|25973->17921|26046->17957|26061->17962|26101->17979|26141->17982|26215->18032|26287->18067|26302->18072|26341->18088|26381->18091|26454->18140|26507->18156|26541->18180|26590->18182|26639->18204|26772->18300|26793->18311|26869->18363|26909->18365|26928->18373|26961->18382|27107->18495|27159->18510|27183->18524|27216->18534|27690->18972|27705->18977|27816->19064|27878->19097|27908->19098|28011->19172|28041->19173|28111->19215|28140->19216|28279->19326|28309->19327|28381->19371|28410->19372|28551->19484|28581->19485|28653->19529|28682->19530|28824->19643|28854->19644|28905->19667|28934->19668|29021->19726|29051->19727|29099->19747|29128->19748|29159->19751|29188->19752|29244->19779|29274->19780|29377->19854|29407->19855|29513->19932|29543->19933|29612->19974|29641->19975|29671->19977|29700->19978|29867->20116|29897->20117|30003->20194|30033->20195|30104->20238|30133->20239|30163->20241|30192->20242|30360->20381|30390->20382|30496->20459|30526->20460|30597->20503|30626->20504|30656->20506|30685->20507|30818->20612|30847->20613|30898->20635|30928->20636|31006->20685|31036->20686|31131->20753|31160->20754|31192->20758|31221->20759|31315->20825|31344->20826|31411->20864|31441->20865|31508->20904|31537->20905|31704->21043|31734->21044|31803->21085|31832->21086|32000->21225|32030->21226|32099->21267|32128->21268|32261->21373|32290->21374|32340->21392
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|51->1|52->5|53->8|55->23|57->25|57->25|57->25|57->25|75->43|75->43|75->43|76->44|76->44|76->44|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|81->49|81->49|81->49|82->50|82->50|82->50|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|87->55|87->55|87->55|88->56|88->56|88->56|89->57|90->58|90->58|90->58|91->59|91->59|91->59|92->60|93->61|93->61|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|109->77|109->77|109->77|110->78|110->78|110->78|111->79|113->81|113->81|113->81|114->82|114->82|114->82|115->83|118->86|118->86|118->86|119->87|119->87|119->87|120->88|125->93|125->93|125->93|125->93|125->93|125->93|130->98|130->98|130->98|131->99|131->99|131->99|132->100|133->101|133->101|133->101|134->102|134->102|134->102|135->103|144->112|144->112|147->115|147->115|150->118|150->118|153->121|153->121|156->124|156->124|166->134|166->134|173->141|173->141|174->142|174->142|179->147|179->147|179->147|194->162|194->162|195->163|195->163|200->168|200->168|200->168|216->184|216->184|217->185|217->185|222->190|222->190|222->190|237->205|240->208|241->209|244->212|251->219|251->219|252->220|252->220|264->232|264->232|265->233|265->233|266->234|266->234|266->234|273->241|273->241|281->249|281->249|282->250|282->250|285->253|285->253|285->253|295->263|296->264|302->270|302->270|303->271|303->271|306->274|306->274|306->274|319->287|319->287|326->294|326->294|328->296|329->297|335->303|335->303|341->309|341->309|354->322|354->322|354->322|368->336|368->336|368->336|374->342|374->342|374->342|380->348|380->348|380->348|404->372|404->372|404->372|405->373|405->373|405->373|406->374|406->374|406->374|406->374|406->374|406->374|406->374|406->374|407->375|407->375|407->375|407->375|407->375|407->375|409->377|409->377|409->377|409->377|409->377|409->377|410->378|410->378|410->378|410->378|412->380|412->380|413->381|413->381|413->381|414->382|414->382|414->382|416->384|417->385|419->387|419->387|419->387|419->387|420->388|420->388|420->388|420->388|421->389|421->389|422->390|422->390|422->390|422->390|423->391|423->391|423->391|423->391|424->392|424->392|424->392|424->392|425->393|425->393|425->393|425->393|425->393|426->394|426->394|426->394|426->394|426->394|427->395|427->395|427->395|427->395|427->395|428->396|428->396|428->396|428->396|430->398|430->398|430->398|430->398|430->398|430->398|435->403|436->404|436->404|436->404|450->418|450->418|450->418|453->421|453->421|457->425|457->425|460->428|460->428|463->431|463->431|466->434|466->434|469->437|469->437|472->440|472->440|475->443|475->443|478->446|478->446|479->447|479->447|481->449|481->449|482->450|482->450|484->452|484->452|488->456|488->456|489->457|489->457|491->459|491->459|492->460|492->460|496->464|496->464|497->465|497->465|499->467|499->467|500->468|500->468|504->472|504->472|505->473|505->473|507->475|507->475|508->476|508->476|511->479|511->479|513->481|513->481|515->483|515->483|518->486|518->486|518->486|518->486|520->488|520->488|522->490|522->490|524->492|524->492|528->496|528->496|530->498|530->498|534->502|534->502|536->504|536->504|539->507|539->507|542->510
                    -- GENERATED --
                */
            