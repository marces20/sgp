
package views.html.patrimonio.actaRecepcion

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
object indexActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[ActaRecepcion],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaRecepcion], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var ajustes=new java.math.BigDecimal(0);var tt=new java.math.BigDecimal(0);

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*9.76*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*12.2*/getClassEstado/*12.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 38){
		classEstado = "borrador"
	}else if(i != null && i.id == 41){
		classEstado = "cancelada"
	}else if(i != null && i.id == 40){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.132*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*7.1*/("""
"""),format.raw/*10.2*/("""
 
"""),format.raw/*23.2*/(""" 
 
 
"""),_display_(Seq[Any](/*26.2*/views/*26.7*/.html.patrimonio.mainPatrimonio("Actas de recepción", scripts)/*26.69*/ {_display_(Seq[Any](format.raw/*26.71*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de actas</h1>
			</div>			
			<div class="col-sm-5">
							 
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*36.16*/controllers/*36.27*/.patrimonio.routes.ActasRecepcionController.crear)),format.raw/*36.76*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Acta</a>
				</div> 
				 
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li><a id="reporteGeneralActa" href="#" data-url=""""),_display_(Seq[Any](/*44.58*/controllers/*44.69*/.patrimonio.routes.ActasRecepcionReportesController.reporteGeneralActa())),format.raw/*44.141*/("""">Datos Generales</a></li>
						<li><a id="reporteListadoInventariable" href="#" data-url=""""),_display_(Seq[Any](/*45.67*/controllers/*45.78*/.patrimonio.routes.ActasRecepcionReportesController.modalListadoInventariable())),format.raw/*45.157*/("""">Listado Inventariables</a></li>
						<li><a id="reporteLineasActas" href="#" data-url=""""),_display_(Seq[Any](/*46.58*/controllers/*46.69*/.patrimonio.routes.ActasRecepcionReportesController.reporteLineasActas())),format.raw/*46.141*/("""">Datos Lineas</a></li>
					</ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	 """),_display_(Seq[Any](/*57.10*/if(Permiso.check("expedientesPasarAOtroServicio"))/*57.60*/ {_display_(Seq[Any](format.raw/*57.62*/("""
				    <li role="presentation"><a role="menuitem" id="accionPasarOtroServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*59.29*/controllers/*59.40*/.patrimonio.routes.ActasMovimientosController.modalPasarOtroServicio())),format.raw/*59.110*/("""">
				    						   Pasar a otro servicio</a>
				 	</li>
				 	""")))})),format.raw/*62.8*/("""
				 	"""),_display_(Seq[Any](/*63.8*/if(Permiso.check("expedientesCancelarPase"))/*63.52*/ {_display_(Seq[Any](format.raw/*63.54*/("""
				 	<li role="presentation"><a role="menuitem" id="cancelarPaseLista" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*65.29*/controllers/*65.40*/.patrimonio.routes.ActasMovimientosController.cancelarPaseLista())),format.raw/*65.105*/("""">
				    						   Cancelar Pases</a>
				 	</li>
				 	""")))})),format.raw/*68.8*/("""
				 	"""),_display_(Seq[Any](/*69.8*/if(Permiso.check("expedientesAsignarMiServicio"))/*69.57*/ {_display_(Seq[Any](format.raw/*69.59*/("""
				  	<li role="presentation">
				  		<a role="menuitem" id="accionAsignarMiServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*72.29*/controllers/*72.40*/.patrimonio.routes.ActasMovimientosController.modalAsignarMiServicio())),format.raw/*72.110*/("""">
				    						   Asignar a Mi Servicio</a>
				 	</li>
				 	""")))})),format.raw/*75.8*/("""
				  </ul>
				</div>
				
			</div>
		</div>
	</div>

"""),_display_(Seq[Any](/*83.2*/views/*83.7*/.html.tags.successError())),format.raw/*83.32*/("""
<form action="" id="buscadorActasRecepcion" method="GET">
		<div class="row" >
			<div class="col-sm-6 filtrosEstados" id="filtrosEstados">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*90.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*90.68*/("""
				  </button>
				  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>En curso
				  	"""),_display_(Seq[Any](/*94.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*94.68*/("""
				  </button>
				  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>Preajuste
				  	"""),_display_(Seq[Any](/*98.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*98.68*/("""
				  </button>
				  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-ok"></i><br>Aprobada
				  	"""),_display_(Seq[Any](/*102.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*102.68*/("""
				  </button>
				  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelada
				  	"""),_display_(Seq[Any](/*106.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*106.68*/("""
				  </button>
				</div>
			</div>
		</div>	
		<div class="row" >
			<div class="form-group col-sm-2">
				<label for="nombre" class="control-label">Orden provisión
				"""),_display_(Seq[Any](/*114.6*/inputText(formBuscador("orden_provision"), 'class -> "form-control"))),format.raw/*114.74*/("""
				</label>
			</div>
			<div class="form-group col-sm-2">
				<label for="nombre" class="control-label">Número Acta
				"""),_display_(Seq[Any](/*119.6*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*119.92*/("""
				</label>
			</div>
			
			<!--  <div class="form-group col-sm-2">
				<label for="nombre" class="control-label">Orden compra
				"""),_display_(Seq[Any](/*125.6*/inputText(formBuscador("orden_compra"), 'class -> "form-control"))),format.raw/*125.71*/("""
				</label>
			</div>-->
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*131.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*131.91*/("""
						"""),_display_(Seq[Any](/*132.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*132.110*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedorActa" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*137.22*/controllers/*137.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*137.84*/("""" 
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
						"""),_display_(Seq[Any](/*152.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*152.93*/("""
						"""),_display_(Seq[Any](/*153.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*153.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpedienteActa" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*158.22*/controllers/*158.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*158.87*/("""" 
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
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*173.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*173.124*/("""
					"""),_display_(Seq[Any](/*174.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*174.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDepositoActa" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*177.30*/controllers/*177.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*177.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Rubro
				"""),_display_(Seq[Any](/*186.6*/select(formBuscador("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*187.126*/("""
				 </label>
			</div>
		</div>


		<div class="row">
			
		
		<div class="form-group col-sm-4">
			<label for="nombre" class="control-label">Tipo de acta</label>
			<div>"""),_display_(Seq[Any](/*198.10*/inputRadioGroup(formBuscador("tipo"), options = Seq("productos"->"Productos","servicios"->"Servicios","ambos"->"Ambos"), '_label -> "Gender"))),format.raw/*198.151*/("""</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*203.5*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*204.64*/("""
			</label>
		</div>
	
		<div class="col-sm-2 input-group">
			<label class="control-label">Fecha</label>
			<div>
				"""),_display_(Seq[Any](/*211.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*211.128*/("""
				"""),_display_(Seq[Any](/*212.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*212.128*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*219.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*220.126*/("""
			</label>
		</div>
			
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label"> 
					Moneda Extrajera
					"""),_display_(Seq[Any](/*228.7*/checkbox(formBuscador("tipo_moneda")))),format.raw/*228.44*/("""
				</label> 
			</div> 
		</div>	
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label"> 
				Emergencia
				"""),_display_(Seq[Any](/*238.6*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*238.111*/("""
			</label>
		</div>
		<div class="col-sm-2 input-group">
				<label class="control-label"> 
					Servicio/depto
					"""),_display_(Seq[Any](/*244.7*/select(formBuscador("organigrama_id"), 
					Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
					"form-control select", '_default -> "Seleccionar"))),format.raw/*246.56*/("""
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
			<a href=""""),_display_(Seq[Any](/*259.14*/controllers/*259.25*/.patrimonio.routes.ActasRecepcionController.index())),format.raw/*259.76*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
	</form>

   """),_display_(Seq[Any](/*265.5*/if(buscador.getTotalRowCount == 0)/*265.39*/ {_display_(Seq[Any](format.raw/*265.41*/("""
        
       <div class="well">
           <em>No se encuentran actas de recepción</em>
       </div>
        
    """)))}/*271.7*/else/*271.12*/{_display_(Seq[Any](format.raw/*271.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*273.14*/buscador/*273.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*273.54*/(""" resultado(s).   
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th >Acta</th>
					<th width="70">Ejercicio</th>
					<th width="70">Periodo</th>
					<th width="80">Expediente</th>
					<th>OP</th>
					<th>Proveedor</th>
					<th>Institucion</th>
					<th width="100">Subtotal</th>
					<th width="100">Ajuste</th>
					<th width="100">Total</th>
					
					<th width="100">Fecha</th>
					<th width="80">Tipo</th>
					<th>Tipo Cuenta</th>
					<th width="80">Estado</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*298.12*/for(acta <- buscador.getList) yield /*298.41*/ {_display_(Seq[Any](format.raw/*298.43*/("""
			        """),_display_(Seq[Any](/*299.13*/paginadorFicha/*299.27*/.add(acta.id.toString))),format.raw/*299.49*/("""
					<tr class="pointer """),_display_(Seq[Any](/*300.26*/getClassEstado(acta.estado))),format.raw/*300.53*/("""" data-href=""""),_display_(Seq[Any](/*300.67*/controllers/*300.78*/.patrimonio.routes.ActasRecepcionController.ver(acta.id))),format.raw/*300.134*/("""&"""),_display_(Seq[Any](/*300.136*/UriTrack/*300.144*/.encode())),format.raw/*300.153*/("""">
						<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*301.65*/acta/*301.69*/.id)),format.raw/*301.72*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*301.106*/acta/*301.110*/.id)),format.raw/*301.113*/(""""/></td>
						<td>"""),_display_(Seq[Any](/*302.12*/acta/*302.16*/.numero)),format.raw/*302.23*/(""" 
							"""),_display_(Seq[Any](/*303.9*/if(acta.ordenProvision != null)/*303.40*/{_display_(Seq[Any](format.raw/*303.41*/("""
								-"""),_display_(Seq[Any](/*304.11*/if(acta.ordenProvision.ordenCompra.tipo_moneda != null)/*304.66*/{_display_(Seq[Any](format.raw/*304.67*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*304.139*/("""
							""")))})),format.raw/*305.9*/("""<br>
							
							"""),_display_(Seq[Any](/*307.9*/if(acta.ordenProvision.ordenCompra.expediente != null)/*307.63*/{_display_(Seq[Any](format.raw/*307.64*/("""
								"""),_display_(Seq[Any](/*308.10*/if(acta.ordenProvision.ordenCompra.expediente.emergencia)/*308.67*/{_display_(Seq[Any](format.raw/*308.68*/("""
									<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
								""")))})),format.raw/*310.10*/("""
							""")))})),format.raw/*311.9*/("""
						</td>
						<td>"""),_display_(Seq[Any](/*313.12*/if(acta.ejercicio != null)/*313.38*/ {_display_(Seq[Any](_display_(Seq[Any](/*313.41*/acta/*313.45*/.ejercicio.nombre))))})),format.raw/*313.63*/("""</td>
						<td>"""),_display_(Seq[Any](/*314.12*/if(acta.periodo != null)/*314.36*/ {_display_(Seq[Any](_display_(Seq[Any](/*314.39*/acta/*314.43*/.periodo.nombre))))})),format.raw/*314.59*/("""</td>
						<td>"""),_display_(Seq[Any](/*315.12*/if(acta.ordenProvision != null)/*315.43*/ {_display_(Seq[Any](_display_(Seq[Any](/*315.46*/acta/*315.50*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio()))))})),format.raw/*315.114*/("""</td>
						<td>"""),_display_(Seq[Any](/*316.12*/if(acta.ordenProvision != null)/*316.43*/ {_display_(Seq[Any](format.raw/*316.45*/(""" """),_display_(Seq[Any](/*316.47*/acta/*316.51*/.ordenProvision.numero))))})),format.raw/*316.74*/("""</td>
						<td>"""),_display_(Seq[Any](/*317.12*/if(acta.ordenProvision != null)/*317.43*/ {_display_(Seq[Any](_display_(Seq[Any](/*317.46*/acta/*317.50*/.ordenProvision.ordenCompra.proveedor.nombre))))})),format.raw/*317.95*/("""</td>
						<td>"""),_display_(Seq[Any](/*318.12*/if(acta.ordenProvision != null)/*318.43*/ {_display_(Seq[Any](_display_(Seq[Any](/*318.46*/acta/*318.50*/.ordenProvision.ordenCompra.deposito.nombre))))})),format.raw/*318.94*/("""</td>
						<td class="total" data-valor=""""),_display_(Seq[Any](/*319.38*/acta/*319.42*/.getSubTotal())),format.raw/*319.56*/("""">"""),_display_(Seq[Any](/*319.59*/utils/*319.64*/.NumberUtils.moneda(acta.getSubTotal()))),format.raw/*319.103*/("""</td>
						<td class="ajustes" data-valor=""""),_display_(Seq[Any](/*320.40*/acta/*320.44*/.getTotalAjustesConLineasAjustes())),format.raw/*320.78*/("""">"""),_display_(Seq[Any](/*320.81*/utils/*320.86*/.NumberUtils.moneda(acta.getTotalAjustesConLineasAjustes()))),format.raw/*320.145*/("""</td>
						<td class="tt" data-valor=""""),_display_(Seq[Any](/*321.35*/acta/*321.39*/.getTotal())),format.raw/*321.50*/("""">"""),_display_(Seq[Any](/*321.53*/utils/*321.58*/.NumberUtils.moneda(acta.getTotal()))),format.raw/*321.94*/("""</td>
						<td>"""),_display_(Seq[Any](/*322.12*/DateUtils/*322.21*/.formatDate(acta.fecha))),format.raw/*322.44*/("""</td>
						<td>"""),_display_(Seq[Any](/*323.12*/if(acta.cierre)/*323.27*/ {_display_(Seq[Any](format.raw/*323.29*/("""Cierre""")))}/*323.37*/else/*323.42*/{_display_(Seq[Any](format.raw/*323.43*/("""Parcial""")))})),format.raw/*323.51*/("""</td>
						<td>"""),_display_(Seq[Any](/*324.12*/if(acta.ordenProvision != null && acta.ordenProvision.ordenCompra.tipoCuenta != null)/*324.97*/ {_display_(Seq[Any](format.raw/*324.99*/("""
							"""),_display_(Seq[Any](/*325.9*/acta/*325.13*/.ordenProvision.ordenCompra.tipoCuenta.nombre))))})),format.raw/*325.59*/("""</td>
						<td>"""),_display_(Seq[Any](/*326.12*/acta/*326.16*/.estado.nombre)),format.raw/*326.30*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*328.7*/{total = total.add(acta.getSubTotal())})),format.raw/*328.46*/("""
					"""),_display_(Seq[Any](/*329.7*/{ajustes = ajustes.add(acta.getTotalAjustesConLineasAjustes())})),format.raw/*329.70*/("""
					"""),_display_(Seq[Any](/*330.7*/{tt = tt.add(acta.getTotal())})),format.raw/*330.37*/("""
				""")))})),format.raw/*331.6*/("""
				"""),_display_(Seq[Any](/*332.6*/paginadorFicha/*332.20*/.guardar())),format.raw/*332.30*/(""" 
			</tbody>
			<tfoot>
				<td colspan="7"></td>
				<td align="right">TOTALES:</td>
				<td class="totalfooter">"""),_display_(Seq[Any](/*337.30*/utils/*337.35*/.NumberUtils.moneda(total))),format.raw/*337.61*/("""</td>
				<td class="ajustesfooter">"""),_display_(Seq[Any](/*338.32*/utils/*338.37*/.NumberUtils.moneda(ajustes))),format.raw/*338.65*/("""</td>
				<td class="ttfooter">"""),_display_(Seq[Any](/*339.27*/utils/*339.32*/.NumberUtils.moneda(tt))),format.raw/*339.55*/("""</td>
				<td colspan="2"></td>
			</tfoot>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*345.8*/views/*345.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.ActasRecepcionController.index()))),format.raw/*345.110*/("""
		</div>
    """)))})),format.raw/*347.6*/("""
""")))})),format.raw/*348.2*/("""

<script>
$( function()"""),format.raw/*351.14*/("""{"""),format.raw/*351.15*/("""
	
	$("#desde, #hasta").mask("99/99/9999");
	
	var resultados = $('#resultadoActasRecepcion');
	
	var trs = $('#listaActasRecepcion tbody tr');
	 
	
	$('#checkAll').click( function() """),format.raw/*360.35*/("""{"""),format.raw/*360.36*/("""
		sumarFilas(trs);
	"""),format.raw/*362.2*/("""}"""),format.raw/*362.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*364.55*/("""{"""),format.raw/*364.56*/("""
		sumarFilas( $('#listaActasRecepcion tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*366.2*/("""}"""),format.raw/*366.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*368.27*/("""{"""),format.raw/*368.28*/("""
		var total = 0; var ajustes = 0; var tt = 0;
		trs.each( function() """),format.raw/*370.24*/("""{"""),format.raw/*370.25*/("""
			total += Number($('.total',this).attr("data-valor"));
			ajustes += Number($('.ajustes',this).attr("data-valor"));
			tt += Number($('.tt',this).attr("data-valor"));
			 
		"""),format.raw/*375.3*/("""}"""),format.raw/*375.4*/(""");
		
		$(".totalfooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
		$(".ajustesfooter").html(formatNumberPesos(parseFloat(ajustes).toFixed(2)));
		$(".ttfooter").html(formatNumberPesos(parseFloat(tt).toFixed(2)));
		 
	"""),format.raw/*381.2*/("""}"""),format.raw/*381.3*/("""
	
	
"""),format.raw/*384.1*/("""}"""),format.raw/*384.2*/(""")
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaRecepcion],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[ActaRecepcion],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/indexActaRecepcion.scala.html
                    HASH: 6ac655331cbd136e7f29e98e817e2b56aa21467c
                    MATRIX: 892->1|1300->410|1314->417|1398->421|1450->438|1464->444|1539->498|1607->192|1639->216|1697->541|1720->555|2022->131|2051->260|2080->407|2109->535|2141->826|2186->836|2199->841|2270->903|2310->905|2562->1121|2582->1132|2653->1181|3211->1703|3231->1714|3326->1786|3456->1880|3476->1891|3578->1970|3706->2062|3726->2073|3821->2145|4279->2567|4338->2617|4378->2619|4549->2754|4569->2765|4662->2835|4761->2903|4805->2912|4858->2956|4898->2958|5061->3085|5081->3096|5169->3161|5261->3222|5305->3231|5363->3280|5403->3282|5583->3426|5603->3437|5696->3507|5795->3575|5896->3641|5909->3646|5956->3671|6310->3990|6391->4049|6602->4225|6683->4284|6894->4460|6975->4519|7177->4685|7259->4744|7472->4921|7554->4980|7771->5161|7862->5229|8027->5358|8136->5444|8313->5585|8401->5650|8577->5790|8683->5873|8728->5882|8854->5984|9081->6174|9102->6185|9176->6236|9638->6662|9746->6747|9791->6756|9919->6860|10146->7050|10167->7061|10244->7115|10733->7568|10874->7685|10918->7693|11021->7773|11222->7937|11243->7948|11318->8000|11725->8371|11915->8537|12137->8722|12302->8863|12433->8958|12620->9122|12784->9250|12930->9372|12973->9379|13119->9501|13265->9611|13455->9777|13639->9925|13699->9962|13889->10116|14018->10221|14180->10347|14444->10588|14887->10994|14908->11005|14982->11056|15117->11155|15161->11189|15202->11191|15347->11318|15361->11323|15401->11324|15457->11343|15475->11351|15530->11383|16274->12090|16320->12119|16361->12121|16412->12135|16436->12149|16481->12171|16545->12198|16595->12225|16646->12239|16667->12250|16747->12306|16787->12308|16806->12316|16839->12325|16944->12393|16958->12397|16984->12400|17056->12434|17071->12438|17098->12441|17156->12462|17170->12466|17200->12473|17247->12484|17288->12515|17328->12516|17377->12528|17442->12583|17482->12584|17588->12656|17630->12666|17689->12689|17753->12743|17793->12744|17841->12755|17908->12812|17948->12813|18079->12911|18121->12921|18184->12947|18220->12973|18270->12976|18284->12980|18329->12998|18384->13016|18418->13040|18468->13043|18482->13047|18525->13063|18580->13081|18621->13112|18671->13115|18685->13119|18777->13183|18832->13201|18873->13232|18914->13234|18953->13236|18967->13240|19017->13263|19072->13281|19113->13312|19163->13315|19177->13319|19249->13364|19304->13382|19345->13413|19395->13416|19409->13420|19480->13464|19561->13508|19575->13512|19612->13526|19652->13529|19667->13534|19730->13573|19813->13619|19827->13623|19884->13657|19924->13660|19939->13665|20022->13724|20100->13765|20114->13769|20148->13780|20188->13783|20203->13788|20262->13824|20317->13842|20336->13851|20382->13874|20437->13892|20462->13907|20503->13909|20530->13917|20544->13922|20584->13923|20625->13931|20680->13949|20775->14034|20816->14036|20862->14046|20876->14050|20949->14096|21004->14114|21018->14118|21055->14132|21116->14157|21178->14196|21222->14204|21308->14267|21352->14275|21405->14305|21444->14312|21487->14319|21511->14333|21544->14343|21702->14464|21717->14469|21766->14495|21841->14533|21856->14538|21907->14566|21977->14599|21992->14604|22038->14627|22183->14736|22198->14741|22319->14838|22368->14855|22403->14858|22459->14885|22489->14886|22710->15078|22740->15079|22791->15102|22820->15103|22910->15164|22940->15165|23057->15254|23086->15255|23148->15288|23178->15289|23279->15361|23309->15362|23519->15544|23548->15545|23816->15785|23845->15786|23881->15794|23910->15795
                    LINES: 26->1|35->8|35->8|37->8|38->9|38->9|38->9|39->5|39->5|39->12|39->12|51->1|52->5|53->7|54->10|56->23|59->26|59->26|59->26|59->26|69->36|69->36|69->36|77->44|77->44|77->44|78->45|78->45|78->45|79->46|79->46|79->46|90->57|90->57|90->57|92->59|92->59|92->59|95->62|96->63|96->63|96->63|98->65|98->65|98->65|101->68|102->69|102->69|102->69|105->72|105->72|105->72|108->75|116->83|116->83|116->83|123->90|123->90|127->94|127->94|131->98|131->98|135->102|135->102|139->106|139->106|147->114|147->114|152->119|152->119|158->125|158->125|164->131|164->131|165->132|165->132|170->137|170->137|170->137|185->152|185->152|186->153|186->153|191->158|191->158|191->158|206->173|206->173|207->174|207->174|210->177|210->177|210->177|219->186|220->187|231->198|231->198|236->203|237->204|244->211|244->211|245->212|245->212|252->219|253->220|261->228|261->228|271->238|271->238|277->244|279->246|292->259|292->259|292->259|298->265|298->265|298->265|304->271|304->271|304->271|306->273|306->273|306->273|331->298|331->298|331->298|332->299|332->299|332->299|333->300|333->300|333->300|333->300|333->300|333->300|333->300|333->300|334->301|334->301|334->301|334->301|334->301|334->301|335->302|335->302|335->302|336->303|336->303|336->303|337->304|337->304|337->304|337->304|338->305|340->307|340->307|340->307|341->308|341->308|341->308|343->310|344->311|346->313|346->313|346->313|346->313|346->313|347->314|347->314|347->314|347->314|347->314|348->315|348->315|348->315|348->315|348->315|349->316|349->316|349->316|349->316|349->316|349->316|350->317|350->317|350->317|350->317|350->317|351->318|351->318|351->318|351->318|351->318|352->319|352->319|352->319|352->319|352->319|352->319|353->320|353->320|353->320|353->320|353->320|353->320|354->321|354->321|354->321|354->321|354->321|354->321|355->322|355->322|355->322|356->323|356->323|356->323|356->323|356->323|356->323|356->323|357->324|357->324|357->324|358->325|358->325|358->325|359->326|359->326|359->326|361->328|361->328|362->329|362->329|363->330|363->330|364->331|365->332|365->332|365->332|370->337|370->337|370->337|371->338|371->338|371->338|372->339|372->339|372->339|378->345|378->345|378->345|380->347|381->348|384->351|384->351|393->360|393->360|395->362|395->362|397->364|397->364|399->366|399->366|401->368|401->368|403->370|403->370|408->375|408->375|414->381|414->381|417->384|417->384
                    -- GENERATED --
                */
            