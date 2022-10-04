
package views.html.contabilidad.ordenesPagosCircuitos

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
object indexOrdenPagoCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenPagoCircuito],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenPagoCircuito], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/ordenPagoCircuitos.js"))),format.raw/*7.82*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*9.2*/getClassEstado/*9.16*/(i:OrdenPagoCircuito) = {{
	var classEstado:String = new String()

	if(i.estado != null && (i.estado.id == 73) ){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 77){
		classEstado = "cancelada"
	}else if(i.estado != null && (i.estado.id == 74 || i.estado.id == 75 || i.estado.id == 76)){
		classEstado = "autorizado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/(""" 
"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.contabilidad.mainContabilidad("Lista de Circuito Ordenes de Pago",scripts)/*23.87*/ {_display_(Seq[Any](format.raw/*23.89*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Lista de Circuito Ordenes de Pagos</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"> <i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span></button>
			</div>
			<div class="dropdown pull-right btn-header">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
				<ul class="dropdown-menu">
					"""),_display_(Seq[Any](/*37.7*/if(Permiso.check("ordenesPagosCircuitoPasarBorrador"))/*37.61*/ {_display_(Seq[Any](format.raw/*37.63*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*38.111*/controllers/*38.122*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalPasarBorrador())),format.raw/*38.203*/("""">Pasar a Borrador</a></li>
					""")))})),format.raw/*39.7*/("""  
					"""),_display_(Seq[Any](/*40.7*/if(Permiso.check("ordenesPagosCircuitoPasarContabilidad"))/*40.65*/ {_display_(Seq[Any](format.raw/*40.67*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarContabilidad" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*41.115*/controllers/*41.126*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalPasarContabilidad())),format.raw/*41.211*/("""">Pasar a Contabilidad</a></li>
					""")))})),format.raw/*42.7*/(""" 
					"""),_display_(Seq[Any](/*43.7*/if(Permiso.check("ordenesPagosCircuitoPasarRendiciones"))/*43.64*/ {_display_(Seq[Any](format.raw/*43.66*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarRendiciones" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*44.114*/controllers/*44.125*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalPasarRendiciones())),format.raw/*44.209*/("""">Pasar a Rendiciones</a></li>
					""")))})),format.raw/*45.7*/(""" 
					"""),_display_(Seq[Any](/*46.7*/if(Permiso.check("ordenesPagosCircuitoPasarRendido"))/*46.60*/ {_display_(Seq[Any](format.raw/*46.62*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarRendido" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*47.110*/controllers/*47.121*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalPasarRendido())),format.raw/*47.201*/("""">Pasar a Rendido</a></li>
					""")))})),format.raw/*48.7*/(""" 
					"""),_display_(Seq[Any](/*49.7*/if(Permiso.check("ordenesPagosCircuitoPasarCancelado"))/*49.62*/ {_display_(Seq[Any](format.raw/*49.64*/("""    
				    <li role="presentation"><a role="menuitem" id="accionPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*50.112*/controllers/*50.123*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalPasarCancelado())),format.raw/*50.205*/("""">Pasar a Cancelado</a></li>
					""")))})),format.raw/*51.7*/(""" 
					"""),_display_(Seq[Any](/*52.7*/if(Permiso.check("ordenesPagosCircuitoEditar"))/*52.54*/ {_display_(Seq[Any](format.raw/*52.56*/("""
			    		<li role="presentation"><a role="menuitem" id="accionCargarExpedienteFisico" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*53.121*/controllers/*53.132*/.contabilidad.routes.OrdenesPagosCircuitosAccionesController.modalCargarExpedienteFisico())),format.raw/*53.222*/("""">Cargar Expediente Fisico</a></li>
			    	""")))})),format.raw/*54.10*/("""  
				</ul>
			</div>	
				
			<div class="pull-right btn-header">
				
			</div>
		</div>
	</div>
</div>
<div id="actions">
	<form action="" id="formSearchPagos" method="GET">
		<div class="row">
			<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
				<div class="btn-group">
				  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-pencil"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*71.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*71.68*/("""
				  </button>
				  <button type="button" rel="contabilidad" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>Contabilidad
				  	"""),_display_(Seq[Any](/*75.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*75.68*/("""
				  </button>
				  <button type="button" rel="rendiciones" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>Rendiciones
				  	"""),_display_(Seq[Any](/*79.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*79.68*/("""
				  </button>
				   <button type="button" rel="rendido" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>Rendido
				  	"""),_display_(Seq[Any](/*83.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*83.68*/("""
				  </button>
				  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
				  	"""),_display_(Seq[Any](/*87.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*87.68*/("""
				  </button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*96.8*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*96.110*/("""
						"""),_display_(Seq[Any](/*97.8*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*97.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*102.22*/controllers/*102.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*102.84*/("""" 
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
						"""),_display_(Seq[Any](/*117.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*117.112*/("""
						"""),_display_(Seq[Any](/*118.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*118.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*123.22*/controllers/*123.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*123.87*/("""" 
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
			<!-- <div class="col-sm-2 input-group">
				<label class="control-label">Orden de Pago N°
				<div>
				"""),_display_(Seq[Any](/*138.6*/inputText(formBuscador("numero_orden_pago_desde"), 
						  'class -> "form-control", 
						  'id -> "numero_orden_pago_desde", 
						  'style -> "width: 71px;font-size:11px;", 
						  'placeholder -> "Desde"))),format.raw/*142.33*/("""
				"""),_display_(Seq[Any](/*143.6*/inputText(formBuscador("numero_orden_pago_hasta"), 
						  'class -> "form-control", 
						  'id -> "numero_orden_pago_hasta", 
						  'style -> "width: 71px;font-size:11px;", 'placeholder -> "Hasta"))),format.raw/*146.74*/("""
				</div>
				</label>
			</div> -->
			<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*153.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*153.98*/("""
						"""),_display_(Seq[Any](/*154.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*154.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOp" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*159.22*/controllers/*159.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*159.90*/("""" 
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
		</div>	
		<div class="row">	
			<div class="col-sm-2">
				<label class="control-label">Cuenta
				"""),_display_(Seq[Any](/*175.6*/select(formBuscador("cuenta_propia"),CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*175.165*/(""" 	
				</label>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Pago</label>
				<div>
					"""),_display_(Seq[Any](/*181.7*/inputText(formBuscador("fecha_pago_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_desde", 'placeholder -> "Desde"))),format.raw/*181.145*/("""
					"""),_display_(Seq[Any](/*182.7*/inputText(formBuscador("fecha_pago_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_hasta", 'placeholder -> "Hasta"))),format.raw/*182.145*/("""
				</div>
			</div>
		
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Ultima</label>
				<div>
					"""),_display_(Seq[Any](/*189.7*/inputText(formBuscador("fecha_ultima_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_ultima_desde", 'placeholder -> "Desde"))),format.raw/*189.149*/("""
					"""),_display_(Seq[Any](/*190.7*/inputText(formBuscador("fecha_ultima_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_ultima_hasta", 'placeholder -> "Hasta"))),format.raw/*190.149*/("""
				</div>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Contabilidad</label>
				<div>
					"""),_display_(Seq[Any](/*196.7*/inputText(formBuscador("fecha_conta_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_conta_desde", 'placeholder -> "Desde"))),format.raw/*196.147*/("""
					"""),_display_(Seq[Any](/*197.7*/inputText(formBuscador("fecha_conta_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_conta_hasta", 'placeholder -> "Hasta"))),format.raw/*197.147*/("""
				</div>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Rendiciones</label>
				<div>
					"""),_display_(Seq[Any](/*203.7*/inputText(formBuscador("fecha_rendi_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_rendi_desde", 'placeholder -> "Desde"))),format.raw/*203.147*/("""
					"""),_display_(Seq[Any](/*204.7*/inputText(formBuscador("fecha_rendi_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_rendi_hasta", 'placeholder -> "Hasta"))),format.raw/*204.147*/("""
				</div>
			</div>
		</div>		
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary">Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*218.15*/controllers/*218.26*/.contabilidad.routes.OrdenesPagosCircuitosController.index())),format.raw/*218.86*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
				
		</div>
	</form>
</div>
"""),_display_(Seq[Any](/*225.2*/views/*225.7*/.html.tags.successError())),format.raw/*225.32*/("""
"""),_display_(Seq[Any](/*226.2*/if(buscador.getTotalRowCount == 0)/*226.36*/ {_display_(Seq[Any](format.raw/*226.38*/("""
        
        <div class="well">
            <em>No se encuentran órdenes de pago completadas para el circuito</em>
        </div>
        
    """)))}/*232.7*/else/*232.12*/{_display_(Seq[Any](format.raw/*232.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*234.14*/buscador/*234.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*234.54*/(""" resultado(s). 
		
		<table id="listaOpc" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="40">Proveedor</th>
					<th width="40">OP</th>
					<th width="40">Expediente</th>
					<th width="40">Exp. Fisico</th>
					<th width="40">Cuenta</th>
					<th width="40">Fecha Pago</th>
					<th width="40">Fecha Ultima</th>
					<th width="40">Fecha Creacion</th>
					<th width="40">Fecha Contabilidad</th>
					<th width="40">Fecha Rendiciones</th>
					<th width="40">Fecha Rendido</th>
					<th width="40">Total</th>
					<th width="30">Estado</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*258.5*/for(orden <- buscador.getList) yield /*258.35*/ {_display_(Seq[Any](format.raw/*258.37*/("""	
				<tr class="pointer """),_display_(Seq[Any](/*259.25*/getClassEstado(orden))),format.raw/*259.46*/("""" data-estado=""""),_display_(Seq[Any](/*259.62*/orden/*259.67*/.estado_id)),format.raw/*259.77*/("""" data-href=""""),_display_(Seq[Any](/*259.91*/controllers/*259.102*/.contabilidad.routes.OrdenesPagosCircuitosController.ver(orden.id))),format.raw/*259.168*/("""&"""),_display_(Seq[Any](/*259.170*/UriTrack/*259.178*/.encode())),format.raw/*259.187*/("""">
					<td>
						<input type="checkbox" name="id_pago[]" value=""""),_display_(Seq[Any](/*261.55*/orden/*261.60*/.id)),format.raw/*261.63*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*261.97*/orden/*261.102*/.id)),format.raw/*261.105*/(""""/>
					</td>
					<td>"""),_display_(Seq[Any](/*263.11*/orden/*263.16*/.proveedor.nombre)),format.raw/*263.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*264.11*/orden/*264.16*/.ordenPago.getNombreCompleto())),format.raw/*264.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*265.11*/if(orden.expediente != null)/*265.39*/{_display_(Seq[Any](_display_(Seq[Any](/*265.41*/(orden.expediente.getExpedienteEjercicio())))))})),format.raw/*265.85*/("""</td>
					<td class="expFisico">"""),_display_(Seq[Any](/*266.29*/if(orden.expedienteFisico != null)/*266.63*/{_display_(Seq[Any](_display_(Seq[Any](/*266.65*/(orden.expedienteFisico.getExpedienteEjercicio())))))})),format.raw/*266.115*/("""</td>
					<td>"""),_display_(Seq[Any](/*267.11*/if(orden.cuentaPropia != null)/*267.41*/{_display_(Seq[Any](_display_(Seq[Any](/*267.43*/(orden.cuentaPropia.numero)))))})),format.raw/*267.71*/("""</td>
					<td>"""),_display_(Seq[Any](/*268.11*/if(orden.fecha_pago != null)/*268.39*/{_display_(Seq[Any](_display_(Seq[Any](/*268.41*/(utils.DateUtils.formatDate(orden.fecha_pago))))))})),format.raw/*268.88*/("""</td>
					<td>"""),_display_(Seq[Any](/*269.11*/if(orden.fecha_mayor != null)/*269.40*/{_display_(Seq[Any](_display_(Seq[Any](/*269.42*/(utils.DateUtils.formatDate(orden.fecha_mayor))))))})),format.raw/*269.90*/("""</td>
					<td>"""),_display_(Seq[Any](/*270.11*/if(orden.fecha_creacion != null)/*270.43*/{_display_(Seq[Any](_display_(Seq[Any](/*270.45*/(utils.DateUtils.formatDate(orden.fecha_creacion))))))})),format.raw/*270.96*/("""</td>
					<td>"""),_display_(Seq[Any](/*271.11*/if(orden.fecha_contabilidad != null)/*271.47*/{_display_(Seq[Any](_display_(Seq[Any](/*271.49*/(utils.DateUtils.formatDate(orden.fecha_contabilidad))))))})),format.raw/*271.104*/("""</td>
					<td>"""),_display_(Seq[Any](/*272.11*/if(orden.fecha_rendiciones != null)/*272.46*/{_display_(Seq[Any](_display_(Seq[Any](/*272.48*/(utils.DateUtils.formatDate(orden.fecha_rendiciones))))))})),format.raw/*272.102*/("""</td>
					<td>"""),_display_(Seq[Any](/*273.11*/if(orden.fecha_rendicion != null)/*273.44*/{_display_(Seq[Any](_display_(Seq[Any](/*273.46*/(utils.DateUtils.formatDate(orden.fecha_rendicion))))))})),format.raw/*273.98*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*274.30*/orden/*274.35*/.total)),format.raw/*274.41*/("""">"""),_display_(Seq[Any](/*274.44*/(utils.NumberUtils.moneda(orden.total)))),format.raw/*274.83*/("""</td>
					<td class="estado" align="center">
						"""),_display_(Seq[Any](/*276.8*/if(orden.estado != null)/*276.32*/{_display_(Seq[Any](_display_(Seq[Any](/*276.34*/(orden.estado.nombre)))))})),format.raw/*276.56*/("""
					</td>
				</tr>	
				
			""")))})),format.raw/*280.5*/("""
	        </tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="10">Mostrando """),_display_(Seq[Any](/*284.40*/buscador/*284.48*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*284.80*/(""" resultado(s).</td>
	        		<td><b>Total:</b> <span class="totalFooter"></span></td>
	        		<td>&nbsp</td>
	        	</tr>
	        </tfoot>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*292.8*/views/*292.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.OrdenesPagosCircuitosController.index()))),format.raw/*292.119*/("""
		</div>
<script>
$( function ()"""),format.raw/*295.15*/("""{"""),format.raw/*295.16*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*297.36*/("""{"""),format.raw/*297.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*299.2*/("""}"""),format.raw/*299.3*/(""")
	
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*303.36*/("""{"""),format.raw/*303.37*/("""
		selectAll();
	"""),format.raw/*305.2*/("""}"""),format.raw/*305.3*/(""");
	$( "input[name='id_pago[]']" ).click(function() """),format.raw/*306.50*/("""{"""),format.raw/*306.51*/("""
		selectTrList();
	"""),format.raw/*308.2*/("""}"""),format.raw/*308.3*/(""");
"""),format.raw/*309.1*/("""}"""),format.raw/*309.2*/(""");
function selectTrList()"""),format.raw/*310.24*/("""{"""),format.raw/*310.25*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	$(".total").each(function (index) """),format.raw/*312.36*/("""{"""),format.raw/*312.37*/("""
		if($(this).parent().find("input[name='id_pago[]']").prop("checked"))"""),format.raw/*313.71*/("""{"""),format.raw/*313.72*/("""
			a = Number($(this).attr("rel"))+a
		"""),format.raw/*315.3*/("""}"""),format.raw/*315.4*/("""
	"""),format.raw/*316.2*/("""}"""),format.raw/*316.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
"""),format.raw/*319.1*/("""}"""),format.raw/*319.2*/("""

function selectAll()"""),format.raw/*321.21*/("""{"""),format.raw/*321.22*/("""
	var a = 0;var b = 0;var c = 0;var d = 0;
	if($("#checkAll").prop("checked"))"""),format.raw/*323.36*/("""{"""),format.raw/*323.37*/("""
		$("input[name='id_pago[]']").prop( "checked", true );
		
	"""),format.raw/*326.2*/("""}"""),format.raw/*326.3*/("""else"""),format.raw/*326.7*/("""{"""),format.raw/*326.8*/("""
		$( "input[name='id_pago[]']").prop( "checked", false );
	"""),format.raw/*328.2*/("""}"""),format.raw/*328.3*/("""
	
	$(".total").each(function (index) """),format.raw/*330.36*/("""{"""),format.raw/*330.37*/("""
		a = Number($(this).attr("rel"))+a 
	"""),format.raw/*332.2*/("""}"""),format.raw/*332.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(a).toFixed(2)));
"""),format.raw/*335.1*/("""}"""),format.raw/*335.2*/("""
</script>
	""")))})),format.raw/*337.3*/("""
""")))})),format.raw/*338.2*/("""	

"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenPagoCircuito],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenPagoCircuito],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/indexOrdenPagoCircuito.scala.html
                    HASH: f2d12956dcade734f90f2b4d5916ec3fbe1adc4f
                    MATRIX: 878->1|1094->213|1108->220|1192->224|1243->240|1257->246|1338->306|1405->143|1437->167|1494->345|1516->359|1907->86|1935->211|1962->342|1991->720|2029->723|2042->728|2131->808|2171->810|2868->1472|2931->1526|2971->1528|3123->1643|3144->1654|3248->1735|3313->1769|3357->1778|3424->1836|3464->1838|3620->1957|3641->1968|3749->2053|3818->2091|3861->2099|3927->2156|3967->2158|4122->2276|4143->2287|4250->2371|4318->2408|4361->2416|4423->2469|4463->2471|4614->2585|4635->2596|4738->2676|4802->2709|4845->2717|4909->2772|4949->2774|5102->2890|5123->2901|5228->2983|5294->3018|5337->3026|5393->3073|5433->3075|5591->3196|5612->3207|5725->3297|5802->3342|6275->3780|6356->3839|6571->4019|6652->4078|6865->4256|6946->4315|7152->4486|7233->4545|7441->4718|7522->4777|7731->4951|7856->5053|7899->5061|8004->5144|8222->5325|8243->5336|8317->5387|8764->5798|8892->5902|8936->5910|9044->5995|9262->6176|9283->6187|9360->6241|9810->6655|10045->6867|10087->6873|10313->7076|10523->7250|10636->7340|10680->7348|10786->7431|11001->7609|11022->7620|11102->7677|11547->8086|11730->8245|11898->8377|12060->8515|12103->8522|12265->8660|12434->8793|12600->8935|12643->8942|12809->9084|12981->9220|13145->9360|13188->9367|13352->9507|13523->9642|13687->9782|13730->9789|13894->9929|14317->10315|14338->10326|14421->10386|14561->10490|14575->10495|14623->10520|14661->10522|14705->10556|14746->10558|14914->10708|14928->10713|14968->10714|15022->10731|15040->10739|15095->10771|15838->11478|15885->11508|15926->11510|15989->11536|16033->11557|16086->11573|16101->11578|16134->11588|16185->11602|16207->11613|16297->11679|16337->11681|16356->11689|16389->11698|16493->11765|16508->11770|16534->11773|16605->11807|16621->11812|16648->11815|16710->11840|16725->11845|16765->11862|16818->11878|16833->11883|16886->11913|16939->11929|16977->11957|17026->11959|17097->12003|17168->12037|17212->12071|17261->12073|17339->12123|17392->12139|17432->12169|17481->12171|17536->12199|17589->12215|17627->12243|17676->12245|17750->12292|17803->12308|17842->12337|17891->12339|17966->12387|18019->12403|18061->12435|18110->12437|18188->12488|18241->12504|18287->12540|18336->12542|18419->12597|18472->12613|18517->12648|18566->12650|18648->12704|18701->12720|18744->12753|18793->12755|18872->12807|18944->12842|18959->12847|18988->12853|19028->12856|19090->12895|19179->12948|19213->12972|19262->12974|19311->12996|19375->13028|19503->13119|19521->13127|19576->13159|19825->13372|19840->13377|19970->13483|20032->13516|20062->13517|20169->13595|20199->13596|20266->13635|20295->13636|20437->13749|20467->13750|20512->13767|20541->13768|20622->13820|20652->13821|20700->13841|20729->13842|20760->13845|20789->13846|20844->13872|20874->13873|20981->13951|21011->13952|21111->14023|21141->14024|21209->14064|21238->14065|21268->14067|21297->14068|21427->14170|21456->14171|21507->14193|21537->14194|21644->14272|21674->14273|21763->14334|21792->14335|21824->14339|21853->14340|21941->14400|21970->14401|22037->14439|22067->14440|22134->14479|22163->14480|22293->14582|22322->14583|22367->14596|22401->14598
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->9|37->9|50->1|51->5|52->8|53->21|55->23|55->23|55->23|55->23|69->37|69->37|69->37|70->38|70->38|70->38|71->39|72->40|72->40|72->40|73->41|73->41|73->41|74->42|75->43|75->43|75->43|76->44|76->44|76->44|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|81->49|81->49|81->49|82->50|82->50|82->50|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|103->71|103->71|107->75|107->75|111->79|111->79|115->83|115->83|119->87|119->87|128->96|128->96|129->97|129->97|134->102|134->102|134->102|149->117|149->117|150->118|150->118|155->123|155->123|155->123|170->138|174->142|175->143|178->146|185->153|185->153|186->154|186->154|191->159|191->159|191->159|207->175|207->175|213->181|213->181|214->182|214->182|221->189|221->189|222->190|222->190|228->196|228->196|229->197|229->197|235->203|235->203|236->204|236->204|250->218|250->218|250->218|257->225|257->225|257->225|258->226|258->226|258->226|264->232|264->232|264->232|266->234|266->234|266->234|290->258|290->258|290->258|291->259|291->259|291->259|291->259|291->259|291->259|291->259|291->259|291->259|291->259|291->259|293->261|293->261|293->261|293->261|293->261|293->261|295->263|295->263|295->263|296->264|296->264|296->264|297->265|297->265|297->265|297->265|298->266|298->266|298->266|298->266|299->267|299->267|299->267|299->267|300->268|300->268|300->268|300->268|301->269|301->269|301->269|301->269|302->270|302->270|302->270|302->270|303->271|303->271|303->271|303->271|304->272|304->272|304->272|304->272|305->273|305->273|305->273|305->273|306->274|306->274|306->274|306->274|306->274|308->276|308->276|308->276|308->276|312->280|316->284|316->284|316->284|324->292|324->292|324->292|327->295|327->295|329->297|329->297|331->299|331->299|335->303|335->303|337->305|337->305|338->306|338->306|340->308|340->308|341->309|341->309|342->310|342->310|344->312|344->312|345->313|345->313|347->315|347->315|348->316|348->316|351->319|351->319|353->321|353->321|355->323|355->323|358->326|358->326|358->326|358->326|360->328|360->328|362->330|362->330|364->332|364->332|367->335|367->335|369->337|370->338
                    -- GENERATED --
                */
            