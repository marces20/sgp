
package views.html.patrimonio.certificaciones

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
object indexCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[CertificacionServicio],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CertificacionServicio], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var descuento=new java.math.BigDecimal(0);var tt=new java.math.BigDecimal(0);

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/patrimonio/certificacionesServicios.js"))),format.raw/*8.86*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*11.2*/getClassEstado/*11.16*/(i:CertificacionServicio) = {{
	var classEstado:String = new String()
	 
	if(i.estado != null && i.estado.id == 43){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 44){
		classEstado = "cancelada"
	}else if(i.estado != null && i.estado.id == 42){
		classEstado = "autorizado"
	}
	 
	classEstado
}};
Seq[Any](format.raw/*1.140*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*9.2*/("""

"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.patrimonio.mainPatrimonio("Certificaciones de servicios", scripts)/*25.79*/ {_display_(Seq[Any](format.raw/*25.81*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de certificaciones</h1>
			</div>
			
			<div class="dropdown pull-right btn-header">
			
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-cog"></i>	Acciones	<span class="caret"></span>
				</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				 		"""),_display_(Seq[Any](/*39.9*/if(Permiso.check("actaRecepcionCrear"))/*39.48*/ {_display_(Seq[Any](format.raw/*39.50*/("""
				 		<li role="presentation"><a id="accionCrearActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*40.85*/controllers/*40.96*/.patrimonio.routes.ActasRecepcionCertificacionesAccionesController.crear())),format.raw/*40.170*/("""" role="menuitem" tabindex="-1">Crear acta de rececpción</a></li>
				 		""")))})),format.raw/*41.9*/("""
				 		"""),_display_(Seq[Any](/*42.9*/if(Permiso.check("actaRecepcionRevocar"))/*42.50*/ {_display_(Seq[Any](format.raw/*42.52*/("""
				 		<li role="presentation"><a id="revocarActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*43.81*/controllers/*43.92*/.patrimonio.routes.ActasRecepcionCertificacionesAccionesController.revocar())),format.raw/*43.168*/("""" role="menuitem" tabindex="-1">Revocar acta de rececpción</a></li>
				 		""")))})),format.raw/*44.9*/("""
				 		"""),_display_(Seq[Any](/*45.9*/if(Permiso.check("actaRecepcionAsignar"))/*45.50*/ {_display_(Seq[Any](format.raw/*45.52*/("""
				 		<li role="presentation"><a id="accionAsignarActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*46.87*/controllers/*46.98*/.patrimonio.routes.ActasRecepcionCertificacionesAccionesController.modalAsignar())),format.raw/*46.179*/("""" role="menuitem" tabindex="-1">Asignar acta de rececpción</a></li>
				 		""")))})),format.raw/*47.9*/("""
					</ul>
			</div>
			
		</div>
	</div>
	"""),_display_(Seq[Any](/*53.3*/views/*53.8*/.html.tags.successError())),format.raw/*53.33*/("""
	<form action="" id="buscadorCertificaciones" method="GET">
 
	<div class="row" >
		<div class="col-sm-4 filtrosEstados" id="filtrosEstados">
			<div class="btn-group">
			  <button type="button" class="btn btn-default btn-filtros">
			  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
			  	"""),_display_(Seq[Any](/*61.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*61.67*/("""
			  </button>
			  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
			  	<i class="glyphicon glyphicon-ok"></i><br>Certificada
			  	"""),_display_(Seq[Any](/*65.8*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*65.67*/("""
			  </button>
			  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
			  	<i class="glyphicon glyphicon-arrow-down size-14"></i><br>No certificada
			  	"""),_display_(Seq[Any](/*69.8*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*69.67*/("""
			  </button>
			  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
			  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelada
			  	"""),_display_(Seq[Any](/*73.8*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*73.67*/("""
			  </button>
			</div>
		</div>
	</div>	
	<div class="row">
		 
		<div class="form-group col-sm-2">
			<label for="numero" class="control-label">Número
			"""),_display_(Seq[Any](/*82.5*/inputText(formBuscador("id"), 'class -> "form-control", 'numero -> "form-control", 'autofocus -> "autofocus"))),format.raw/*82.114*/("""
			</label>
		</div>
		
		<div class="form-group col-sm-2">
			<label for="numero" class="control-label">Orden provisión
			"""),_display_(Seq[Any](/*88.5*/inputText(formBuscador("orden_provision"), 'class -> "form-control", 'numero -> "form-control"))),format.raw/*88.100*/("""
			</label>
		</div>
			

		<div class="form-group col-sm-2">
			<label for="nombre" class="control-label">Acta
			"""),_display_(Seq[Any](/*95.5*/inputText(formBuscador("acta"), 'class -> "form-control"))),format.raw/*95.62*/("""
			</label>
		</div>
		 
		<div class="col-sm-2">
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*102.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*102.92*/("""
					"""),_display_(Seq[Any](/*103.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*103.111*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*108.21*/controllers/*108.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*108.86*/("""" 
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
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group">
				
				"""),_display_(Seq[Any](/*125.6*/inputText(formBuscador("periodo_nombre"),'class -> "form-control",'id -> "periodo"))),format.raw/*125.89*/("""
				"""),_display_(Seq[Any](/*126.6*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*126.83*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*131.19*/controllers/*131.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*131.83*/("""" 
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
	
		<div class="col-sm-2 input-group">
			<label class="control-label">Fecha</label>
			<div>
				"""),_display_(Seq[Any](/*146.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*146.128*/("""
				"""),_display_(Seq[Any](/*147.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*147.128*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label for="producto" class="control-label">Producto</label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*155.6*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*155.120*/("""
				"""),_display_(Seq[Any](/*156.6*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*156.87*/("""
				<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*157.115*/controllers/*157.126*/.compras.routes.ProductosController.modalBuscar())),format.raw/*157.175*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
		</div>

		<div class="col-sm-2">
			<label class="control-label">Proveedor
				<div class="input-group">
					"""),_display_(Seq[Any](/*164.7*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*164.90*/("""
					"""),_display_(Seq[Any](/*165.7*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*165.109*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*170.21*/controllers/*170.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*170.83*/("""" 
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
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*185.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*185.123*/("""
				"""),_display_(Seq[Any](/*186.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*186.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*189.29*/controllers/*189.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*189.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Rubro
			"""),_display_(Seq[Any](/*198.5*/select(formBuscador("orden_rubro_id"), 
			OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*199.125*/("""
			 </label>
		</div>
		<div class="col-sm-2">
			<label class="control-label"> 
				Con Acta
				"""),_display_(Seq[Any](/*205.6*/select(formBuscador("conacta"),options(""->"Todos","si"->"SI","no"->"NO"), 'class -> "form-control select"))),format.raw/*205.113*/("""
			</label>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*210.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*211.126*/("""
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
			</div>
		</div>	
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*224.15*/controllers/*224.26*/.patrimonio.routes.CertificacionesServiciosController.index())),format.raw/*224.87*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
 	</form>


   """),_display_(Seq[Any](/*231.5*/if(buscador.getTotalRowCount == 0)/*231.39*/ {_display_(Seq[Any](format.raw/*231.41*/("""
        
       <div class="well">
           <em>No se encuentran remitos</em>
       </div>
        
    """)))}/*237.7*/else/*237.12*/{_display_(Seq[Any](format.raw/*237.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*239.14*/buscador/*239.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*239.54*/(""" resultado(s).   
		<table id="listaCertificaciones" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" class="check_all" id="checkAll" data-check=".check_certificaciones" /></th>
					<th width="30"></th>
					<th width="60">ID</th>
					<th width="80">Expediente</th>
					<th>OP</th>
					<th>Acta</th>
					<th width="70">Periodo</th>
					<th>Proveedor</th>
					<th>Institucion</th>
					<th width="110">Base</th>
					<th width="110">Descuento</th>
					<th width="110">Total</th>
					<th width="80">Fecha</th>
					<th>Fecha Provision</th>
					<th width="80">Estado</th>
					<th width="30"></th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*262.12*/for(certificacion <- buscador.getList) yield /*262.50*/ {_display_(Seq[Any](format.raw/*262.52*/("""
		        """),_display_(Seq[Any](/*263.12*/paginadorFicha/*263.26*/.add(certificacion.id.toString))),format.raw/*263.57*/("""
				<tr class="pointer """),_display_(Seq[Any](/*264.25*/getClassEstado(certificacion))),format.raw/*264.54*/("""" data-href=""""),_display_(Seq[Any](/*264.68*/controllers/*264.79*/.patrimonio.routes.CertificacionesServiciosController.ver(certificacion.id))),format.raw/*264.154*/("""&"""),_display_(Seq[Any](/*264.156*/UriTrack/*264.164*/.encode())),format.raw/*264.173*/("""">
					<td><input name="check_listado[]" value=""""),_display_(Seq[Any](/*265.48*/certificacion/*265.61*/.id)),format.raw/*265.64*/("""" type="checkbox" class="check_certificaciones notSeleccion" /></td>
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*267.61*/controllers/*267.72*/.patrimonio.routes.CertificacionesServiciosController.editar(certificacion.id))),format.raw/*267.150*/("""&"""),_display_(Seq[Any](/*267.152*/UriTrack/*267.160*/.encode())),format.raw/*267.169*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*271.11*/certificacion/*271.24*/.id)),format.raw/*271.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*272.11*/if(certificacion.ordenProvision != null)/*272.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*272.54*/certificacion/*272.67*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio()))))})),format.raw/*272.131*/("""</td>
					<td>"""),_display_(Seq[Any](/*273.11*/certificacion/*273.24*/.ordenProvision.numero)),format.raw/*273.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*274.11*/if(certificacion.acta != null)/*274.41*/ {_display_(Seq[Any](_display_(Seq[Any](/*274.44*/certificacion/*274.57*/.acta.numero))))})),format.raw/*274.70*/("""</td>
					<td>"""),_display_(Seq[Any](/*275.11*/if(certificacion.periodo != null)/*275.44*/ {_display_(Seq[Any](_display_(Seq[Any](/*275.47*/certificacion/*275.60*/.periodo.nombre))))})),format.raw/*275.76*/("""</td>
					<td>"""),_display_(Seq[Any](/*276.11*/certificacion/*276.24*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*276.68*/("""</td>
					<td>"""),_display_(Seq[Any](/*277.11*/if(certificacion.ordenProvision != null)/*277.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*277.54*/certificacion/*277.67*/.ordenProvision.ordenCompra.deposito.nombre))))})),format.raw/*277.111*/("""</td>
					<td class="total" data-valor=""""),_display_(Seq[Any](/*278.37*/certificacion/*278.50*/.getBase())),format.raw/*278.60*/("""">"""),_display_(Seq[Any](/*278.63*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*278.114*/("""</td>
					<td class="descuento" data-valor=""""),_display_(Seq[Any](/*279.41*/certificacion/*279.54*/.getDescuento())),format.raw/*279.69*/("""">"""),_display_(Seq[Any](/*279.72*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*279.128*/("""</td>
					<td class="tt" data-valor=""""),_display_(Seq[Any](/*280.34*/certificacion/*280.47*/.getTotal())),format.raw/*280.58*/("""">"""),_display_(Seq[Any](/*280.61*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*280.113*/("""</td>
					<td>"""),_display_(Seq[Any](/*281.11*/DateUtils/*281.20*/.formatDate(certificacion.fecha_certificacion))),format.raw/*281.66*/("""</td>
					<td>"""),_display_(Seq[Any](/*282.11*/if(certificacion.ordenProvision.ordenCompra.fecha_provision != null)/*282.79*/ {_display_(Seq[Any](format.raw/*282.81*/("""
							"""),_display_(Seq[Any](/*283.9*/DateUtils/*283.18*/.formatDate(certificacion.ordenProvision.ordenCompra.fecha_provision))),format.raw/*283.87*/("""
						""")))})),format.raw/*284.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*286.11*/certificacion/*286.24*/.estado.nombre)),format.raw/*286.38*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*288.81*/controllers/*288.92*/.patrimonio.routes.CertificacionesServiciosController.eliminar(certificacion.id))),format.raw/*288.172*/("""&"""),_display_(Seq[Any](/*288.174*/UriTrack/*288.182*/.encode())),format.raw/*288.191*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
					"""),_display_(Seq[Any](/*293.7*/{total = total.add(certificacion.getBase())})),format.raw/*293.51*/("""
					"""),_display_(Seq[Any](/*294.7*/{descuento = descuento.add(certificacion.getDescuento())})),format.raw/*294.64*/("""
					"""),_display_(Seq[Any](/*295.7*/{tt = tt.add(certificacion.getTotal())})),format.raw/*295.46*/("""
				""")))})),format.raw/*296.6*/("""
				"""),_display_(Seq[Any](/*297.6*/paginadorFicha/*297.20*/.guardar())),format.raw/*297.30*/("""
            </tbody>
            <tfoot>
				<td colspan="8"></td>
				<td align="right">TOTALES:</td>
				<td class="totalfooter">"""),_display_(Seq[Any](/*302.30*/utils/*302.35*/.NumberUtils.moneda(total))),format.raw/*302.61*/("""</td>
				<td class="descuentofooter">"""),_display_(Seq[Any](/*303.34*/utils/*303.39*/.NumberUtils.moneda(descuento))),format.raw/*303.69*/("""</td>
				<td class="ttfooter">"""),_display_(Seq[Any](/*304.27*/utils/*304.32*/.NumberUtils.moneda(tt))),format.raw/*304.55*/("""</td>
				<td colspan="4"></td>
			</tfoot>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*310.8*/views/*310.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.CertificacionesServiciosController.index()))),format.raw/*310.120*/("""
		</div>
        
    """)))})),format.raw/*313.6*/("""
""")))})),format.raw/*314.2*/("""
<script>
$( function() """),format.raw/*316.15*/("""{"""),format.raw/*316.16*/("""
	$('#searchProducto, #searchResponsable, #searchPeriodo').modalSearch();

	/*
	 * Para la seleccion de la lista de recepciones
	 */
	$('#listaCertificaciones .check_all').on('change', function()"""),format.raw/*322.63*/("""{"""),format.raw/*322.64*/("""
		var c = $(this).prop("checked");
		var target = $(this).attr('data-check');
		if(c) $(target).prop( "checked", true );
		else $(target).prop( "checked", false );
	"""),format.raw/*327.2*/("""}"""),format.raw/*327.3*/(""");
	
	var trs = $('#listaCertificaciones tbody tr');
	 
	
	$('#checkAll').click( function() """),format.raw/*332.35*/("""{"""),format.raw/*332.36*/("""
		sumarFilas(trs);
	"""),format.raw/*334.2*/("""}"""),format.raw/*334.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*336.55*/("""{"""),format.raw/*336.56*/("""
		sumarFilas( $('#listaCertificaciones tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*338.2*/("""}"""),format.raw/*338.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*340.27*/("""{"""),format.raw/*340.28*/("""
		var total = 0; var descuento = 0; var tt = 0;
		trs.each( function() """),format.raw/*342.24*/("""{"""),format.raw/*342.25*/("""
			total += Number($('.total',this).attr("data-valor"));
			descuento += Number($('.descuento',this).attr("data-valor"));
			tt += Number($('.tt',this).attr("data-valor"));
			 
		"""),format.raw/*347.3*/("""}"""),format.raw/*347.4*/(""");
		
		$(".totalfooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
		$(".descuentofooter").html(formatNumberPesos(parseFloat(descuento).toFixed(2)));
		$(".ttfooter").html(formatNumberPesos(parseFloat(tt).toFixed(2)));
		 
	"""),format.raw/*353.2*/("""}"""),format.raw/*353.3*/("""

"""),format.raw/*355.1*/("""}"""),format.raw/*355.2*/(""")
</script>

"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[CertificacionServicio],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[CertificacionServicio],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/indexCertificacion.scala.html
                    HASH: a1fb6b0338388abd0406a031580f8e194ddf9576
                    MATRIX: 902->1|1320->418|1334->425|1418->429|1470->446|1484->452|1569->516|1637->200|1669->224|1727->558|1750->572|2114->139|2143->268|2172->553|2203->905|2243->910|2256->915|2337->987|2377->989|2894->1471|2942->1510|2982->1512|3104->1598|3124->1609|3221->1683|3327->1758|3372->1768|3422->1809|3462->1811|3580->1893|3600->1904|3699->1980|3807->2057|3852->2067|3902->2108|3942->2110|4066->2198|4086->2209|4190->2290|4298->2367|4384->2418|4397->2423|4444->2448|4797->2766|4878->2825|5079->2991|5160->3050|5379->3234|5460->3293|5668->3466|5749->3525|5952->3693|6084->3802|6251->3934|6369->4029|6528->4153|6607->4210|6780->4347|6888->4432|6932->4440|7060->4544|7278->4725|7299->4736|7376->4790|7862->5240|7968->5323|8011->5330|8111->5407|8314->5573|8335->5584|8411->5637|8819->6009|8965->6131|9008->6138|9154->6260|9368->6438|9506->6552|9549->6559|9653->6640|9807->6756|9829->6767|9902->6816|10254->7132|10360->7215|10404->7223|10530->7325|10748->7506|10769->7517|10843->7568|11313->8002|11454->8119|11497->8126|11600->8206|11794->8363|11815->8374|11890->8426|12288->8788|12477->8953|12619->9059|12750->9166|12895->9275|13085->9441|13543->9862|13564->9873|13648->9934|13786->10036|13830->10070|13871->10072|14005->10188|14019->10193|14059->10194|14115->10213|14133->10221|14188->10253|14967->10995|15022->11033|15063->11035|15113->11048|15137->11062|15191->11093|15254->11119|15306->11148|15357->11162|15378->11173|15477->11248|15517->11250|15536->11258|15569->11267|15657->11318|15680->11331|15706->11334|15920->11511|15941->11522|16043->11600|16083->11602|16102->11610|16135->11619|16259->11706|16282->11719|16308->11722|16362->11739|16412->11779|16462->11782|16485->11795|16577->11859|16631->11876|16654->11889|16699->11911|16753->11928|16793->11958|16843->11961|16866->11974|16906->11987|16960->12004|17003->12037|17053->12040|17076->12053|17119->12069|17173->12086|17196->12099|17263->12143|17317->12160|17367->12200|17417->12203|17440->12216|17512->12260|17592->12303|17615->12316|17648->12326|17688->12329|17763->12380|17847->12427|17870->12440|17908->12455|17948->12458|18028->12514|18105->12554|18128->12567|18162->12578|18202->12581|18278->12633|18332->12650|18351->12659|18420->12705|18474->12722|18552->12790|18593->12792|18639->12802|18658->12811|18750->12880|18791->12889|18852->12913|18875->12926|18912->12940|19047->13038|19068->13049|19172->13129|19212->13131|19231->13139|19264->13148|19410->13258|19477->13302|19521->13310|19601->13367|19645->13375|19707->13414|19746->13421|19789->13428|19813->13442|19846->13452|20021->13590|20036->13595|20085->13621|20162->13661|20177->13666|20230->13696|20300->13729|20315->13734|20361->13757|20506->13866|20521->13871|20652->13978|20711->14005|20746->14008|20801->14034|20831->14035|21061->14236|21091->14237|21290->14408|21319->14409|21445->14506|21475->14507|21526->14530|21555->14531|21645->14592|21675->14593|21793->14683|21822->14684|21884->14717|21914->14718|22017->14792|22047->14793|22261->14979|22290->14980|22562->15224|22591->15225|22623->15229|22652->15230
                    LINES: 26->1|35->7|35->7|37->7|38->8|38->8|38->8|39->5|39->5|39->11|39->11|52->1|53->5|54->9|56->23|58->25|58->25|58->25|58->25|72->39|72->39|72->39|73->40|73->40|73->40|74->41|75->42|75->42|75->42|76->43|76->43|76->43|77->44|78->45|78->45|78->45|79->46|79->46|79->46|80->47|86->53|86->53|86->53|94->61|94->61|98->65|98->65|102->69|102->69|106->73|106->73|115->82|115->82|121->88|121->88|128->95|128->95|135->102|135->102|136->103|136->103|141->108|141->108|141->108|158->125|158->125|159->126|159->126|164->131|164->131|164->131|179->146|179->146|180->147|180->147|188->155|188->155|189->156|189->156|190->157|190->157|190->157|197->164|197->164|198->165|198->165|203->170|203->170|203->170|218->185|218->185|219->186|219->186|222->189|222->189|222->189|231->198|232->199|238->205|238->205|243->210|244->211|257->224|257->224|257->224|264->231|264->231|264->231|270->237|270->237|270->237|272->239|272->239|272->239|295->262|295->262|295->262|296->263|296->263|296->263|297->264|297->264|297->264|297->264|297->264|297->264|297->264|297->264|298->265|298->265|298->265|300->267|300->267|300->267|300->267|300->267|300->267|304->271|304->271|304->271|305->272|305->272|305->272|305->272|305->272|306->273|306->273|306->273|307->274|307->274|307->274|307->274|307->274|308->275|308->275|308->275|308->275|308->275|309->276|309->276|309->276|310->277|310->277|310->277|310->277|310->277|311->278|311->278|311->278|311->278|311->278|312->279|312->279|312->279|312->279|312->279|313->280|313->280|313->280|313->280|313->280|314->281|314->281|314->281|315->282|315->282|315->282|316->283|316->283|316->283|317->284|319->286|319->286|319->286|321->288|321->288|321->288|321->288|321->288|321->288|326->293|326->293|327->294|327->294|328->295|328->295|329->296|330->297|330->297|330->297|335->302|335->302|335->302|336->303|336->303|336->303|337->304|337->304|337->304|343->310|343->310|343->310|346->313|347->314|349->316|349->316|355->322|355->322|360->327|360->327|365->332|365->332|367->334|367->334|369->336|369->336|371->338|371->338|373->340|373->340|375->342|375->342|380->347|380->347|386->353|386->353|388->355|388->355
                    -- GENERATED --
                */
            