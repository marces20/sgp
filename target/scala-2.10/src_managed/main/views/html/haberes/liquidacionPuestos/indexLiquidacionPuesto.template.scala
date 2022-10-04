
package views.html.haberes.liquidacionPuestos

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
object indexLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[models.haberes.LiquidacionPuesto],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionPuesto], 
formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/haberes/liquidacionPuesto.js"))),format.raw/*9.76*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*11.2*/getClassEstado/*11.16*/(i:models.haberes.LiquidacionPuesto) = {{
	var classEstado:String = new String()
	
	if(i.estado != null && i.estado.id == 52){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 54){
		classEstado = "cancelada"
	}else if(i.estado != null && i.estado.id == 53){
		classEstado = "autorizado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*2.76*/("""
"""),format.raw/*6.1*/("""
"""),format.raw/*7.70*/(""" 
"""),format.raw/*10.2*/("""
"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.haberes.mainHaberes("Lista Liquidaciones",scripts)/*25.63*/ {_display_(Seq[Any](format.raw/*25.65*/("""
<script>
$( function()"""),format.raw/*27.14*/("""{"""),format.raw/*27.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*27.48*/("""}"""),format.raw/*27.49*/(""")
</script>
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Liquidaciones Puestos</h1>
			</div>
	
			<div class="col-sm-5">
				
				<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"> 
				<i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span></button>

				<ul class="dropdown-menu">
					<!-- <li><a id="reporteReciboSueldo"  href="#" data-url=""""),_display_(Seq[Any](/*42.64*/controllers/*42.75*/.haberes.routes.LiquidacionPuestosReportesController.reciboSueldo())),format.raw/*42.142*/("""">Recibos de Sueldo</a></li> -->
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
						
						"""),_display_(Seq[Any](/*55.8*/if(Permiso.check("liquidacionPuestoPasarAAprobado"))/*55.60*/ {_display_(Seq[Any](format.raw/*55.62*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarAOtraLiquidacion" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*56.121*/controllers/*56.132*/.haberes.routes.LiquidacionPuestosAccionesController.modalPasarAOtraLiquidacion())),format.raw/*56.213*/("""">Pasar a Otra Liquidacion</a></li>		
					  	""")))})),format.raw/*57.10*/("""
						
					  	"""),_display_(Seq[Any](/*59.10*/if(Permiso.check("liquidacionPuestoPasarAPreaprobado"))/*59.65*/ {_display_(Seq[Any](format.raw/*59.67*/("""													  									  				
					    	<li role="presentation"><a role="menuitem" id="accionPasarPreAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*60.116*/controllers/*60.127*/.haberes.routes.LiquidacionPuestosAccionesController.modalPasarPreaprobado())),format.raw/*60.203*/("""">Pasar a Preaprobado</a></li>	
					    """)))})),format.raw/*61.11*/("""
					    """),_display_(Seq[Any](/*62.11*/if(Permiso.check("liquidacionPuestoPasarAAprobado"))/*62.63*/ {_display_(Seq[Any](format.raw/*62.65*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*63.113*/controllers/*63.124*/.haberes.routes.LiquidacionPuestosAccionesController.modalPasarAprobado())),format.raw/*63.197*/("""">Pasar a Aprobado</a></li>	
					    """)))})),format.raw/*64.11*/("""
					    """),_display_(Seq[Any](/*65.11*/if(Permiso.check("liquidacionPuestoPasarABorrador"))/*65.63*/ {_display_(Seq[Any](format.raw/*65.65*/("""		
					    	<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*66.113*/controllers/*66.124*/.haberes.routes.LiquidacionPuestosAccionesController.modalPasarBorrador())),format.raw/*66.197*/("""">Pasar a Borrador</a></li>
					    """)))})),format.raw/*67.11*/("""
					    """),_display_(Seq[Any](/*68.11*/if(Permiso.check("liquidacionPuestoPasarACancelado"))/*68.64*/ {_display_(Seq[Any](format.raw/*68.66*/("""
					    	<li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*69.114*/controllers/*69.125*/.haberes.routes.LiquidacionPuestosAccionesController.modalPasarCancelado())),format.raw/*69.199*/("""">Pasar a Cancelado</a></li>		
					  	""")))})),format.raw/*70.10*/("""
					  	 
					</ul>
				</div>
				<div class="pull-right btn-header">
					<!-- <a href=""""),_display_(Seq[Any](/*75.21*/controllers/*75.32*/.haberes.routes.LiquidacionPuestosController.crear())),format.raw/*75.84*/("""?"""),_display_(Seq[Any](/*75.86*/UriTrack/*75.94*/.encode())),format.raw/*75.103*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Liquidación Puesto</a> -->
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*81.3*/views/*81.8*/.html.tags.successError())),format.raw/*81.33*/("""
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
				<div class="col-sm-4 filtrosEstados" id="filtrosEstados">
				 	<div class="btn-group">
					  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
					 	"""),_display_(Seq[Any](/*89.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*89.68*/("""
					  </button>
					  <button type="button" id="btn-filtro-preaprobado" rel="preaprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>Preaprobado 
					  	"""),_display_(Seq[Any](/*92.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*92.69*/("""
					  </button>
					  <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Aprabado 
					  	"""),_display_(Seq[Any](/*95.10*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*95.69*/("""
					  </button>
					  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
					  	"""),_display_(Seq[Any](/*98.10*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*98.69*/("""
					  </button>
					</div>
				</div>
				
				
			</div>	
			<div class="row">
				
				<div class="col-sm-3">
					<label for="solicitante" class="control-label">Liquidación</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*110.8*/inputText(formBuscador("liquidacionMes.nro_liquidacion_parque"),'class -> "form-control", 'id -> "liquidacion_mes"))),format.raw/*110.123*/("""
						"""),_display_(Seq[Any](/*111.8*/inputText(formBuscador("liquidacion_mes_id"), 'hidden -> "hidden", 'id -> "liquidacion_mes_id"))),format.raw/*111.103*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPuestoLaboral" 
										data-title="Selección de Liquidacion" 
										data-url=""""),_display_(Seq[Any](/*116.22*/controllers/*116.33*/.haberes.routes.LiquidacionMesesController.modalBuscar())),format.raw/*116.89*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.liquidacionMes.simple" 
										data-label="#liquidacion_mes" 
										data-field="#liquidacion_mes_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</div>
				<div class="col-sm-4">
					<label for="solicitante" class="control-label">Puesto Laboral</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*130.8*/inputText(formBuscador("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral_todos"))),format.raw/*130.127*/("""
						"""),_display_(Seq[Any](/*131.8*/inputText(formBuscador("puesto_laboral_id"), 'hidden -> "hidden", 'id -> "puesto_laboral_todos_id"))),format.raw/*131.107*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPuestoLaboral" 
										data-title="Selección de puesto laboral" 
										data-url=""""),_display_(Seq[Any](/*136.22*/controllers/*136.33*/.haberes.routes.PuestosLaboralesController.modalBuscarTodos())),format.raw/*136.94*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.puestoLaboral.simple" 
										data-label="#puesto_laboral_todos" 
										data-field="#puesto_laboral_todos_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</div>
				<div class="col-sm-3">
					<label class="control-label">Categoria</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*150.8*/inputText(formBuscador("categoriaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "categoria_laboral"))),format.raw/*150.125*/("""
						"""),_display_(Seq[Any](/*151.8*/inputText(formBuscador("categoria_laboral_id"), 'hidden -> "hidden", 'id -> "categoria_laboral_id"))),format.raw/*151.107*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal" id="searchCategoriaLaboral" 
								 	data-title="Selección de categoria" 
								 	data-url=""""),_display_(Seq[Any](/*155.22*/controllers/*155.33*/.haberes.routes.CategoriasLaboralesController.modalBuscar())),format.raw/*155.92*/("""" 
								 	data-height="650" data-width="700" 
								 	data-listen="modal.seleccion.categoriaLaboral.simple" 
								 	data-label="#categoria_laboral" 
								 	data-field="#categoria_laboral_id">
						<i class="glyphicon glyphicon-search"></i></a></span>
					</div>
				</div> 
				<div class="col-sm-2">
					<label class="control-label"> 
						C/M
						"""),_display_(Seq[Any](/*166.8*/select(formBuscador("cm"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*166.105*/("""
					</label>
				</div>
				
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label class="control-label">Escala</label>
						<div class="input-group">
							"""),_display_(Seq[Any](/*175.9*/inputText(formBuscador("escalaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "escala_laboral"))),format.raw/*175.120*/("""
							"""),_display_(Seq[Any](/*176.9*/inputText(formBuscador("escala_laboral_id"), 'hidden -> "hidden", 'id -> "escala_laboral_id"))),format.raw/*176.102*/("""
							<span class="input-group-addon">
							<a href="#" class="searchModal" id="searchEscalaLaboral" 
									 	data-title="Selección de escala" 
									 	data-url=""""),_display_(Seq[Any](/*180.23*/controllers/*180.34*/.haberes.routes.EscalasLaboralesController.modalBuscar())),format.raw/*180.90*/("""" 
									 	data-height="650" data-width="700" 
									 	data-listen="modal.seleccion.escalaLaboral.simple" 
									 	data-label="#escala_laboral" data-field="#escala_laboral_id">
							<i class="glyphicon glyphicon-search"></i></a></span>
						</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						Ganancia
						"""),_display_(Seq[Any](/*190.8*/select(formBuscador("ganancias"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*190.112*/("""
					</label>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Ingreso</label>
					<div>
						"""),_display_(Seq[Any](/*196.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*196.136*/("""
						"""),_display_(Seq[Any](/*197.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*197.136*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="buscar" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="limpiar" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*209.16*/controllers/*209.27*/.haberes.routes.LiquidacionPuestosController.index())),format.raw/*209.79*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*216.3*/if(buscador.getTotalRowCount == 0)/*216.37*/ {_display_(Seq[Any](format.raw/*216.39*/("""
        
        <div class="well">
            <em>No se encuentran Liquidaciones</em>
        </div>
        
    """)))}/*222.7*/else/*222.12*/{_display_(Seq[Any](format.raw/*222.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*224.17*/buscador/*224.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*224.57*/(""" resultado(s). 
		
		<table id="listaLiquidacionPuestos" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th width="30">N° Liq.</th>
					<th>Agente</th>
					<th>Periodo</th>
					<th>Total C/A</th>
					<th>Total S/A</th>
					<th>Total Ret.</th>
					<th>Total a Cobrar</th>
					<th>Sueldo Ref</th>
					<th>Direfencia</th>
					<th>Estado</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*247.5*/for(lc <- buscador.getList) yield /*247.32*/ {_display_(Seq[Any](format.raw/*247.34*/("""
				"""),_display_(Seq[Any](/*248.6*/paginadorFicha/*248.20*/.add(lc.id.toString))),format.raw/*248.40*/("""
				<tr class="pointer """),_display_(Seq[Any](/*249.25*/getClassEstado(lc))),format.raw/*249.43*/("""" data-estado=""""),_display_(Seq[Any](/*249.59*/lc/*249.61*/.estado_id)),format.raw/*249.71*/("""" data-href=""""),_display_(Seq[Any](/*249.85*/controllers/*249.96*/.haberes.routes.LiquidacionPuestosController.ver(lc.id))),format.raw/*249.151*/("""&"""),_display_(Seq[Any](/*249.153*/UriTrack/*249.161*/.encode())),format.raw/*249.170*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*250.64*/lc/*250.66*/.id)),format.raw/*250.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*250.103*/lc/*250.105*/.id)),format.raw/*250.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*252.8*/if(Permiso.check("liquidacionPuestoEditar") && lc.liquidacionMes.estado.id != Estado.LIQUIDACION_MES_APROBADO && lc.liquidacionMes.estado.id != Estado.LIQUIDACION_MES_CERRADA)/*252.183*/ {_display_(Seq[Any](format.raw/*252.185*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*253.61*/controllers/*253.72*/.haberes.routes.LiquidacionPuestosController.editar(lc.id))),format.raw/*253.130*/("""&"""),_display_(Seq[Any](/*253.132*/UriTrack/*253.140*/.encode())),format.raw/*253.149*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*256.8*/("""
					</td>
					<td class="numero_liquidacion">"""),_display_(Seq[Any](/*258.38*/(lc.liquidacionMes.nro_liquidacion_parque))),format.raw/*258.80*/("""</td>
					<td>"""),_display_(Seq[Any](/*259.11*/(lc.puestoLaboral.legajo.agente.apellido))),format.raw/*259.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*260.11*/(lc.liquidacionMes.periodo.nombre))),format.raw/*260.45*/("""</td>
					<td class="totalCA" data-valor=""""),_display_(Seq[Any](/*261.39*/lc/*261.41*/.getTotalCA())),format.raw/*261.54*/("""">"""),_display_(Seq[Any](/*261.57*/utils/*261.62*/.NumberUtils.moneda(lc.getTotalCA()))),format.raw/*261.98*/("""</td>
					<td class="totalSA" data-valor=""""),_display_(Seq[Any](/*262.39*/lc/*262.41*/.getTotalSA())),format.raw/*262.54*/("""">"""),_display_(Seq[Any](/*262.57*/utils/*262.62*/.NumberUtils.moneda(lc.getTotalSA()))),format.raw/*262.98*/("""</td>
					<td class="totalRetenciones" data-valor=""""),_display_(Seq[Any](/*263.48*/lc/*263.50*/.getTotalRetenciones())),format.raw/*263.72*/("""">"""),_display_(Seq[Any](/*263.75*/utils/*263.80*/.NumberUtils.moneda(lc.getTotalRetenciones()))),format.raw/*263.125*/("""</td>
					<td class="totalACobrar" data-valor=""""),_display_(Seq[Any](/*264.44*/lc/*264.46*/.getTotalACobrar())),format.raw/*264.64*/("""">"""),_display_(Seq[Any](/*264.67*/utils/*264.72*/.NumberUtils.moneda(lc.getTotalACobrar()))),format.raw/*264.113*/("""</td>
					<td>"""),_display_(Seq[Any](/*265.11*/if(lc.puestoLaboral.sueldo_referencia != null)/*265.57*/{_display_(Seq[Any](_display_(Seq[Any](/*265.59*/utils/*265.64*/.NumberUtils.moneda(lc.puestoLaboral.sueldo_referencia.add(lc.getTotalSA()))))))})),format.raw/*265.141*/("""</td>
					<td class="totalADirefencia" data-valor=""""),_display_(Seq[Any](/*266.48*/if(lc.getTotalACobrar() != null && lc.puestoLaboral.sueldo_referencia != null)/*266.126*/{_display_(Seq[Any](_display_(Seq[Any](/*266.128*/lc/*266.130*/.getTotalACobrar().subtract(lc.puestoLaboral.sueldo_referencia.add(lc.getTotalSA()))))))}/*266.215*/else/*266.219*/{_display_(Seq[Any](format.raw/*266.220*/("""0""")))})),format.raw/*266.222*/("""">
						"""),_display_(Seq[Any](/*267.8*/if(lc.getTotalACobrar() != null && lc.puestoLaboral.sueldo_referencia != null)/*267.86*/{_display_(Seq[Any](_display_(Seq[Any](/*267.88*/utils/*267.93*/.NumberUtils.moneda(lc.getTotalACobrar().subtract(lc.puestoLaboral.sueldo_referencia.add(lc.getTotalSA()))))),format.raw/*267.200*/(""" """)))})),format.raw/*267.202*/("""
						</td>
					<td class="estado" align="center">"""),_display_(Seq[Any](/*269.41*/(lc.estado.nombre))),_display_(Seq[Any](/*269.60*/if(lc.getTieneGanancia())/*269.85*/{_display_(Seq[Any](format.raw/*269.86*/("""<br><span style="color:red; font-weight:bold; font-size:14px;">G</span>""")))})),format.raw/*269.158*/("""</td>
					
					<td>
						"""),_display_(Seq[Any](/*272.8*/if(Permiso.check("liquidacionPuestoEliminar") && lc.liquidacionMes.estado.id != Estado.LIQUIDACION_MES_APROBADO && lc.liquidacionMes.estado.id != Estado.LIQUIDACION_MES_CERRADA)/*272.185*/ {_display_(Seq[Any](format.raw/*272.187*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*273.81*/controllers/*273.92*/.haberes.routes.LiquidacionPuestosController.eliminar(lc.id))),format.raw/*273.152*/("""&"""),_display_(Seq[Any](/*273.154*/UriTrack/*273.162*/.encode())),format.raw/*273.171*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
						""")))})),format.raw/*276.8*/("""
						"""),_display_(Seq[Any](/*277.8*/if(lc.liquidacionMes.estado.id == Estado.LIQUIDACION_MES_APROBADO || lc.liquidacionMes.estado.id == Estado.LIQUIDACION_MES_CERRADA)/*277.139*/ {_display_(Seq[Any](format.raw/*277.141*/("""
							<a class="btn btn-default btn-xs notSeleccion reciboSueldoPorPuesto" data-url=""""),_display_(Seq[Any](/*278.88*/controllers/*278.99*/.haberes.routes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(lc.id))),format.raw/*278.180*/("""">
								"""),_display_(Seq[Any](/*279.10*/lc/*279.12*/.impresiones)),format.raw/*279.24*/(""" <i class="glyphicon glyphicon-list-alt"></i> 
							</a>
							
							<a class="btn btn-default btn-xs notSeleccion reciboSueldoPorPuestoMail" data-url=""""),_display_(Seq[Any](/*282.92*/controllers/*282.103*/.haberes.routes.LiquidacionPuestosReportesController.modalReciboSueldoPorPuestoMail(lc.id))),format.raw/*282.193*/("""">
								"""),_display_(Seq[Any](/*283.10*/lc/*283.12*/.envio_mail)),format.raw/*283.23*/(""" <i class="glyphicon glyphicon-envelope"></i> 
							</a>
						""")))})),format.raw/*285.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*288.15*/("""
             """),_display_(Seq[Any](/*289.15*/paginadorFicha/*289.29*/.guardar())),format.raw/*289.39*/("""
	        </tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="5">Mostrando """),_display_(Seq[Any](/*293.39*/buscador/*293.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*293.79*/(""" resultado(s).</td>
	        		<td><b>Total:</b> <span class="totalCAFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalSAFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalRetencionesFooter"></span></td>
	        		<td><b>Total:</b> <span class="totalACobrarFooter"></span></td>
	        		<td></td>
	        		<td><b>Total:</b> <span class="totalADirefenciaFooter"></span></td>
	        		
	        		<td colspan="4">&nbsp</td>
	        	</tr>
	        </tfoot>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*307.8*/views/*307.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionPuestosController.index()))),format.raw/*307.111*/("""
		</div>
		
		
<script>


$( function () """),format.raw/*314.16*/("""{"""),format.raw/*314.17*/("""
	var trs = $('#listaLiquidacionPuestos tbody tr');
	sumarFilas(trs);
	
	$('#checkAll').click( function() """),format.raw/*318.35*/("""{"""),format.raw/*318.36*/("""
		sumarFilas(trs);
	"""),format.raw/*320.2*/("""}"""),format.raw/*320.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*322.55*/("""{"""),format.raw/*322.56*/("""
		sumarFilas( $('#listaLiquidacionPuestos tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*324.2*/("""}"""),format.raw/*324.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*326.27*/("""{"""),format.raw/*326.28*/("""
		var ca = 0; var sa = 0; var retenciones = 0; var cobrar = 0;var diferencia= 0;
		trs.each( function() """),format.raw/*328.24*/("""{"""),format.raw/*328.25*/("""
			ca += Number($('.totalCA',this).attr("data-valor"));
			sa += Number($('.totalSA',this).attr("data-valor"));
			retenciones += Number($('.totalRetenciones',this).attr("data-valor"));
			cobrar += Number($('.totalACobrar',this).attr("data-valor"));
			diferencia += Number($('.totalADirefencia',this).attr("data-valor"));
		"""),format.raw/*334.3*/("""}"""),format.raw/*334.4*/(""");
		
		$(".totalCAFooter").html(formatNumberPesos(parseFloat(ca).toFixed(2)));
		$(".totalSAFooter").html(formatNumberPesos(parseFloat(sa).toFixed(2)));
		$(".totalRetencionesFooter").html(formatNumberPesos(parseFloat(retenciones).toFixed(2)));
		$(".totalACobrarFooter").html(formatNumberPesos(parseFloat(cobrar).toFixed(2)));
		$(".totalADirefenciaFooter").html(formatNumberPesos(parseFloat(diferencia).toFixed(2)));
	"""),format.raw/*341.2*/("""}"""),format.raw/*341.3*/("""
"""),format.raw/*342.1*/("""}"""),format.raw/*342.2*/(""");
		
</script>		
		
 	 """)))})),format.raw/*346.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionPuesto],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionPuesto],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/indexLiquidacionPuesto.scala.html
                    HASH: c88e49b88ac80245b1c766deffbc0c5107ce036a
                    MATRIX: 917->1|1198->280|1212->287|1296->291|1347->307|1361->313|1436->367|1503->209|1535->233|1593->405|1616->419|1976->151|2003->207|2031->277|2060->403|2088->749|2126->752|2139->757|2204->813|2244->815|2295->838|2324->839|2385->872|2414->873|2941->1364|2961->1375|3051->1442|3589->1945|3650->1997|3690->1999|3848->2120|3869->2131|3973->2212|4052->2259|4105->2276|4169->2331|4209->2333|4392->2479|4413->2490|4512->2566|4586->2608|4633->2619|4694->2671|4734->2673|4884->2786|4905->2797|5001->2870|5072->2909|5119->2920|5180->2972|5220->2974|5372->3089|5393->3100|5489->3173|5559->3211|5606->3222|5668->3275|5708->3277|5859->3391|5880->3402|5977->3476|6049->3516|6178->3609|6198->3620|6272->3672|6310->3674|6327->3682|6359->3691|6555->3852|6568->3857|6615->3882|6986->4218|7067->4277|7305->4479|7386->4538|7606->4722|7687->4781|7918->4976|7999->5035|8261->5261|8400->5376|8444->5384|8563->5479|8785->5664|8806->5675|8885->5731|9370->6180|9513->6299|9557->6307|9680->6406|9905->6594|9926->6605|10010->6666|10480->7100|10621->7217|10665->7225|10788->7324|11000->7499|11021->7510|11103->7569|11506->7936|11627->8033|11841->8211|11976->8322|12021->8331|12138->8424|12348->8597|12369->8608|12448->8664|12840->9020|12968->9124|13143->9263|13295->9391|13339->9399|13491->9527|13896->9895|13917->9906|13992->9958|14135->10065|14179->10099|14220->10101|14357->10220|14371->10225|14411->10226|14470->10248|14488->10256|14543->10288|15122->10831|15166->10858|15207->10860|15249->10866|15273->10880|15316->10900|15378->10925|15419->10943|15472->10959|15484->10961|15517->10971|15568->10985|15589->10996|15668->11051|15708->11053|15727->11061|15760->11070|15863->11136|15875->11138|15901->11141|15973->11175|15986->11177|16013->11180|16075->11206|16261->11381|16303->11383|16401->11444|16422->11455|16504->11513|16544->11515|16563->11523|16596->11532|16697->11601|16783->11650|16848->11692|16901->11708|16965->11749|17018->11765|17075->11799|17156->11843|17168->11845|17204->11858|17244->11861|17259->11866|17318->11902|17399->11946|17411->11948|17447->11961|17487->11964|17502->11969|17561->12005|17651->12058|17663->12060|17708->12082|17748->12085|17763->12090|17832->12135|17918->12184|17930->12186|17971->12204|18011->12207|18026->12212|18091->12253|18144->12269|18200->12315|18249->12317|18264->12322|18369->12399|18459->12452|18548->12530|18598->12532|18611->12534|18711->12619|18726->12623|18767->12624|18803->12626|18849->12636|18937->12714|18986->12716|19001->12721|19132->12828|19168->12830|19258->12883|19308->12902|19343->12927|19383->12928|19489->13000|19554->13029|19742->13206|19784->13208|19902->13289|19923->13300|20007->13360|20047->13362|20066->13370|20099->13379|20209->13457|20253->13465|20395->13596|20437->13598|20562->13686|20583->13697|20688->13778|20737->13790|20749->13792|20784->13804|20979->13962|21001->13973|21115->14063|21164->14075|21176->14077|21210->14088|21308->14154|21377->14190|21429->14205|21453->14219|21486->14229|21613->14319|21631->14327|21686->14359|22297->14934|22312->14939|22434->15037|22505->15079|22535->15080|22670->15186|22700->15187|22749->15208|22778->15209|22866->15268|22896->15269|23015->15360|23044->15361|23104->15392|23134->15393|23268->15498|23298->15499|23653->15826|23682->15827|24131->16248|24160->16249|24189->16250|24218->16251|24275->16276
                    LINES: 26->1|34->8|34->8|36->8|37->9|37->9|37->9|38->7|38->7|38->11|38->11|51->2|52->6|53->7|54->10|55->23|57->25|57->25|57->25|57->25|59->27|59->27|59->27|59->27|74->42|74->42|74->42|87->55|87->55|87->55|88->56|88->56|88->56|89->57|91->59|91->59|91->59|92->60|92->60|92->60|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|97->65|97->65|97->65|98->66|98->66|98->66|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|107->75|107->75|107->75|107->75|107->75|107->75|113->81|113->81|113->81|121->89|121->89|124->92|124->92|127->95|127->95|130->98|130->98|142->110|142->110|143->111|143->111|148->116|148->116|148->116|162->130|162->130|163->131|163->131|168->136|168->136|168->136|182->150|182->150|183->151|183->151|187->155|187->155|187->155|198->166|198->166|207->175|207->175|208->176|208->176|212->180|212->180|212->180|222->190|222->190|228->196|228->196|229->197|229->197|241->209|241->209|241->209|248->216|248->216|248->216|254->222|254->222|254->222|256->224|256->224|256->224|279->247|279->247|279->247|280->248|280->248|280->248|281->249|281->249|281->249|281->249|281->249|281->249|281->249|281->249|281->249|281->249|281->249|282->250|282->250|282->250|282->250|282->250|282->250|284->252|284->252|284->252|285->253|285->253|285->253|285->253|285->253|285->253|288->256|290->258|290->258|291->259|291->259|292->260|292->260|293->261|293->261|293->261|293->261|293->261|293->261|294->262|294->262|294->262|294->262|294->262|294->262|295->263|295->263|295->263|295->263|295->263|295->263|296->264|296->264|296->264|296->264|296->264|296->264|297->265|297->265|297->265|297->265|297->265|298->266|298->266|298->266|298->266|298->266|298->266|298->266|298->266|299->267|299->267|299->267|299->267|299->267|299->267|301->269|301->269|301->269|301->269|301->269|304->272|304->272|304->272|305->273|305->273|305->273|305->273|305->273|305->273|308->276|309->277|309->277|309->277|310->278|310->278|310->278|311->279|311->279|311->279|314->282|314->282|314->282|315->283|315->283|315->283|317->285|320->288|321->289|321->289|321->289|325->293|325->293|325->293|339->307|339->307|339->307|346->314|346->314|350->318|350->318|352->320|352->320|354->322|354->322|356->324|356->324|358->326|358->326|360->328|360->328|366->334|366->334|373->341|373->341|374->342|374->342|378->346
                    -- GENERATED --
                */
            