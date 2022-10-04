
package views.html.patrimonio.ordenesProvision

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
object verOrdenProvision extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas],utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden: OrdenProvision, buscador: utils.pagination.Pagination[OrdenProvisionLineas], paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*9.2*/scripts/*9.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*9.13*/("""
	<script src=""""),_display_(Seq[Any](/*10.16*/routes/*10.22*/.Assets.at("javascripts/patrimonio/ordenesProvision.js"))),format.raw/*10.78*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*11.16*/routes/*11.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*11.76*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*12.16*/routes/*12.22*/.Assets.at("javascripts/patrimonio/recepciones.js"))),format.raw/*12.73*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*13.16*/routes/*13.22*/.Assets.at("javascripts/patrimonio/remitos.js"))),format.raw/*13.69*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.135*/("""
"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(orden.id.toString))),format.raw/*6.45*/("""


"""),format.raw/*14.2*/("""

"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.patrimonio.mainPatrimonio("Ver orden de provisión", scripts)/*16.73*/ {_display_(Seq[Any](format.raw/*16.75*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-5">
				<h1>Ver orden de provisión """),_display_(Seq[Any](/*21.33*/if(orden.ordenCompra.expediente != null)/*21.73*/{_display_(Seq[Any](format.raw/*21.74*/("""
											"""),_display_(Seq[Any](/*22.13*/if(orden.ordenCompra.expediente.emergencia)/*22.56*/{_display_(Seq[Any](format.raw/*22.57*/("""
												<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*23.103*/("""</h1>
			</div>
			<div class="col-sm-7">
				<div class="dropdown pull-right btn-header">
					 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> 
					 	<i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> 
					 </button>
					  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					  	"""),_display_(Seq[Any](/*31.10*/if(orden.ordenCompra.tipo_orden == "comun" && Permiso.check("anulacionRecepcionProductosCrear"))/*31.106*/ {_display_(Seq[Any](format.raw/*31.108*/("""
							<li role="presentation">
							  	<a role="menuitem" id="accionAnularProductosPedientes" href="#" tabindex="-1" 
					    		data-url=""""),_display_(Seq[Any](/*34.23*/controllers/*34.34*/.patrimonio.routes.OrdenesProvisionController.modalAnularProductosPedientes(orden.id))),format.raw/*34.119*/("""">
					    		Anular Productos Pendientes
					    		</a>
					    	</li>
				    	""")))})),format.raw/*38.11*/("""
				    		<li role="presentation">
							  	<a role="menuitem" id="accionCrearActasDeAjustes" href="#" tabindex="-1" 
					    		data-url=""""),_display_(Seq[Any](/*41.23*/controllers/*41.34*/.patrimonio.routes.OrdenesProvisionController.modalCrearActasDeAjustes(orden.id))),format.raw/*41.114*/("""">
					    		Crear Actas Ajuste Diferencia Cotizacion
					    		</a>
					    	</li>
				    	
					  </ul>    
				</div>	  	
				<div class="dropdown pull-right btn-header">
					 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
					 	<i class="glyphicon glyphicon-list-alt"></i>
					    Reportes
					    <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li role="presentation">
						  	<a role="menuitem" id="" data-url="" tabindex="-1" 
				    		href=""""),_display_(Seq[Any](/*57.18*/controllers/*57.29*/.patrimonio.routes.OrdenesProvisionReportesController.informeGeneral(orden.id))),format.raw/*57.107*/("""">
				    		Informe General</a>
				    	</li>
						<li role="presentation">
						  	<a role="menuitem" id="" data-url="" tabindex="-1" 
				    		href=""""),_display_(Seq[Any](/*62.18*/controllers/*62.29*/.patrimonio.routes.OrdenesProvisionReportesController.informeInventariable(orden.id))),format.raw/*62.113*/("""">
				    		Informe Inventariables</a>
				    	</li>
				    	<li role="presentation">
						  	<a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" data-url="" tabindex="-1" 
				    		href=""""),_display_(Seq[Any](/*67.18*/controllers/*67.29*/.patrimonio.routes.OrdenesProvisionReportesController.informePendiente(orden.id))),format.raw/*67.109*/("""">
				    		Informe Pendientes</a>
				    	</li>
				    	"""),_display_(Seq[Any](/*70.11*/if(Permiso.check("reporteOrdenProvision"))/*70.53*/ {_display_(Seq[Any](format.raw/*70.55*/("""
						  <li>
						  	<a role="menuitem" tabindex="-1" href="#" class="reporteOrdenProvision"  
						  	data-url=""""),_display_(Seq[Any](/*73.21*/controllers/*73.32*/.patrimonio.routes.OrdenesProvisionReportesController.ordenDeProvision(orden.ordenCompra.id,false))),format.raw/*73.130*/("""">Reporte Orden Provision</a>
						  </li>
						
						  <li>
						  	<a role="menuitem" tabindex="-1" href="#" class="reporteNotaCierre"  
						  	data-url=""""),_display_(Seq[Any](/*78.21*/controllers/*78.32*/.patrimonio.routes.OrdenesProvisionReportesController.notaCierre(orden.id,1))),format.raw/*78.108*/("""">Reporte Nota Cierre</a>
						  </li>
						  <li>
						  	<a role="menuitem" tabindex="-1" href="#" class="reporteNotaCierre"  
						  	data-url=""""),_display_(Seq[Any](/*82.21*/controllers/*82.32*/.patrimonio.routes.OrdenesProvisionReportesController.notaCierre(orden.id,2))),format.raw/*82.108*/("""">Reporte Nota Cierre NUEVA!!</a>
						  </li>
				  		""")))})),format.raw/*84.10*/("""
				  		"""),_display_(Seq[Any](/*85.10*/if(Permiso.check("reporteOrdenProvisionSinMonto"))/*85.60*/ {_display_(Seq[Any](format.raw/*85.62*/("""    
						   <li>
						  	<a role="menuitem" tabindex="-1" href="#" class="reporteOrdenProvision"  
						  	data-url=""""),_display_(Seq[Any](/*88.21*/controllers/*88.32*/.patrimonio.routes.OrdenesProvisionReportesController.ordenDeProvision(orden.ordenCompra.id,true))),format.raw/*88.129*/("""">Reporte Orden Provision Sin Montos</a>
						  </li>
						""")))})),format.raw/*90.8*/("""  
				  		<li>
						  	<a role="menuitem" tabindex="-1" href="#" id="reporteAnulados"  
						  	data-url=""""),_display_(Seq[Any](/*93.21*/controllers/*93.32*/.patrimonio.routes.OrdenesProvisionReportesController.reporteAnulados(orden.id))),format.raw/*93.111*/("""">Reporte Anulados</a>
						 </li>
				    </ul>
				</div>
				"""),_display_(Seq[Any](/*97.6*/if(orden.ordenCompra.tipo_orden == "comun")/*97.49*/ {_display_(Seq[Any](format.raw/*97.51*/("""
					"""),_display_(Seq[Any](/*98.7*/if(Permiso.check("recepcionesVer"))/*98.42*/ {_display_(Seq[Any](format.raw/*98.44*/("""
					<div class="pull-right btn-header">
						<a href=""""),_display_(Seq[Any](/*100.17*/controllers/*100.28*/.patrimonio.routes.RecepcionesController.index())),format.raw/*100.76*/("""?orden_provision="""),_display_(Seq[Any](/*100.94*/orden/*100.99*/.numero)),format.raw/*100.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-th-list"></i> Ver recepciones</a>
					</div>
					""")))})),format.raw/*102.7*/("""
					"""),_display_(Seq[Any](/*103.7*/if(Permiso.check("recepcionesCrear"))/*103.44*/ {_display_(Seq[Any](format.raw/*103.46*/("""
					<div class="pull-right btn-header">
						<a href=""""),_display_(Seq[Any](/*105.17*/controllers/*105.28*/.patrimonio.routes.RecepcionesController.crear(orden.id))),format.raw/*105.84*/("""" class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva recepción</a>
					</div>
					""")))})),format.raw/*107.7*/("""
				""")))}/*108.7*/else/*108.12*/{_display_(Seq[Any](format.raw/*108.13*/("""
					"""),_display_(Seq[Any](/*109.7*/if(Permiso.check("certificacionesServiciosCrear"))/*109.57*/ {_display_(Seq[Any](format.raw/*109.59*/("""
					<div class="pull-right btn-header">
						<a href="#" data-url=""""),_display_(Seq[Any](/*111.30*/controllers/*111.41*/.patrimonio.routes.CertificacionesServiciosController.crearDesdeOrdenAjax(orden.id))),format.raw/*111.124*/("""" 
						class="btn btn-default" id="certificar"> <i class="glyphicon glyphicon-plus-sign"></i> Crear certificación</a>
					</div>
					""")))})),format.raw/*114.7*/("""
				
					"""),_display_(Seq[Any](/*116.7*/if(Permiso.check("certificacionesServiciosVer"))/*116.55*/ {_display_(Seq[Any](format.raw/*116.57*/("""
					<div class="pull-right btn-header">
						<a href=""""),_display_(Seq[Any](/*118.17*/controllers/*118.28*/.patrimonio.routes.CertificacionesServiciosController.index())),format.raw/*118.89*/("""?orden_provision="""),_display_(Seq[Any](/*118.107*/orden/*118.112*/.numero)),format.raw/*118.119*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i> Ver certificaciones</a>
					</div>
					""")))})),format.raw/*120.7*/("""
						
				""")))})),format.raw/*122.6*/("""
		
				
			</div>
		</div>
	</div>

"""),_display_(Seq[Any](/*129.2*/views/*129.7*/.html.tags.successError())),format.raw/*129.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-4">
		"""),_display_(Seq[Any](/*133.4*/if(Permiso.check("ordenesProvisionEditar"))/*133.47*/ {_display_(Seq[Any](format.raw/*133.49*/("""
			<a href=""""),_display_(Seq[Any](/*134.14*/controllers/*134.25*/.patrimonio.routes.OrdenesProvisionController.editar(orden.id))),_display_(Seq[Any](/*134.88*/UriTrack/*134.96*/.get("&"))),format.raw/*134.105*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		""")))})),format.raw/*135.4*/("""
		"""),_display_(Seq[Any](/*136.4*/if(Permiso.check("ordenesProvisionEliminar"))/*136.49*/ {_display_(Seq[Any](format.raw/*136.51*/("""
			<a href=""""),_display_(Seq[Any](/*137.14*/controllers/*137.25*/.patrimonio.routes.OrdenesProvisionController.eliminar(orden.id))),_display_(Seq[Any](/*137.90*/UriTrack/*137.98*/.get("&"))),format.raw/*137.107*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*138.4*/("""
	</div>
	<div class="col-sm-4">
		"""),_display_(Seq[Any](/*141.4*/if(orden.ordenCompra.tipo_moneda != null)/*141.45*/{_display_(Seq[Any](format.raw/*141.46*/("""
			<span style="color:green;font-weight:bold;font-size: 24px;">MONEDA EXTRANJERA</span>
		""")))})),format.raw/*143.4*/("""
	</div>
	<div class="col-sm-3 ">
		<a href=""""),_display_(Seq[Any](/*146.13*/UriTrack/*146.21*/.getOnNull(controllers.patrimonio.routes.OrdenesProvisionController.index().absoluteURL()))),format.raw/*146.111*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
				
		"""),_display_(Seq[Any](/*148.4*/if(paginadorFicha.getLista().size() > 1)/*148.44*/{_display_(Seq[Any](format.raw/*148.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*151.5*/if(paginadorFicha.hasPrev())/*151.33*/ {_display_(Seq[Any](format.raw/*151.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*152.29*/controllers/*152.40*/.patrimonio.routes.OrdenesProvisionController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*152.120*/UriTrack/*152.128*/.get("&"))),format.raw/*152.137*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*153.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*154.79*/paginadorFicha/*154.93*/.posicionActual())),format.raw/*154.110*/(""" de """),_display_(Seq[Any](/*154.115*/paginadorFicha/*154.129*/.getLista().size())),format.raw/*154.147*/("""</p>
			"""),_display_(Seq[Any](/*155.5*/if(paginadorFicha.hasNext())/*155.33*/ {_display_(Seq[Any](format.raw/*155.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*156.29*/controllers/*156.40*/.patrimonio.routes.OrdenesProvisionController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*156.120*/UriTrack/*156.128*/.get("&"))),format.raw/*156.137*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*157.5*/("""  
		</div>
		""")))})),format.raw/*159.4*/("""
		
	</div>
</div>



<div class="row">
	<input type="hidden" name="idOrdenProvision" id="idOrdenProvision" value=""""),_display_(Seq[Any](/*167.77*/orden/*167.82*/.id)),format.raw/*167.85*/(""""/>
	<div class="col-sm-3">
		<div class="row">
			<div class="col-sm-6">
				<label class="control-label">N° Orden</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*172.50*/orden/*172.55*/.numero)),format.raw/*172.62*/("""</p>
			</div>
			<div class="col-sm-6">
				<label class="control-label">N° Ord. Compra</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*176.50*/orden/*176.55*/.ordenCompra.nombre)),format.raw/*176.74*/("""</p>
			</div>
		</div>
	</div>


	<div class="col-sm-3">
		<div class="row">
			<div class="col-sm-6">
				<label class="control-label">Ejercicio</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*186.50*/orden/*186.55*/.ejercicio.nombre)),format.raw/*186.72*/("""</p>
			</div>
			<div class="col-sm-6">
				<label class="control-label">Expediente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*190.50*/orden/*190.55*/.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*190.103*/("""</p>
			</div>
		</div>
	</div>


	
	<div class="col-sm-2">
		<label class="control-label">Total</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*199.48*/utils/*199.53*/.NumberUtils.moneda(orden.ordenCompra.getTotal()))),format.raw/*199.102*/("""</p>
	</div>
	
	<div class="col-sm-3">
		<div class="row">
			<div class="col-sm-6">
				<label class="control-label">Fecha Provision</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*206.50*/DateUtils/*206.59*/.formatDate(orden.ordenCompra.fecha_provision))),format.raw/*206.105*/("""</p>
			</div>
			
			<div class="col-sm-6">
				<label class="control-label">Entrega</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*211.50*/DateUtils/*211.59*/.formatDate(orden.plazo_entrega))),format.raw/*211.91*/("""</p>
			</div>
		</div>
	</div>

	
</div>

<div class="row">

	<div class="col-sm-4">
		<label class="control-label">Proveedor</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*223.48*/orden/*223.53*/.ordenCompra.proveedor.nombre)),format.raw/*223.82*/("""</p>
	</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha inicio</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*227.48*/DateUtils/*227.57*/.formatDate(orden.ordenCompra.fecha_inicio))),format.raw/*227.100*/("""</p>
	</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha fin</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*231.48*/DateUtils/*231.57*/.formatDate(orden.ordenCompra.fecha_fin))),format.raw/*231.97*/("""</p>
	</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha Creacion</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*235.48*/DateUtils/*235.57*/.formatDate(orden.create_date))),format.raw/*235.87*/("""</p>
	</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha Cierre</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*239.48*/DateUtils/*239.57*/.formatDate(orden.fcierre))),format.raw/*239.83*/("""</p>
	</div>
</div>

<hr />

<div id="listas">
"""),_display_(Seq[Any](/*246.2*/if(orden.ordenCompra.tipo_orden == "comun")/*246.45*/ {_display_(Seq[Any](format.raw/*246.47*/("""
	"""),_display_(Seq[Any](/*247.3*/views/*247.8*/.html.patrimonio.ordenesProvision.verListaComun(orden, buscador))),format.raw/*247.72*/("""
""")))}/*248.3*/else/*248.8*/{_display_(Seq[Any](format.raw/*248.9*/("""
	"""),_display_(Seq[Any](/*249.3*/views/*249.8*/.html.patrimonio.ordenesProvision.verListaCertificaciones(orden, buscador))),format.raw/*249.82*/("""
""")))})),format.raw/*250.2*/("""
</div>

	<script>
	$( function()"""),format.raw/*254.15*/("""{"""),format.raw/*254.16*/("""
		
		/*
		 * Para la seleccion de la lista de recepciones
		 */
		$('.check_all').on('change', function()"""),format.raw/*259.42*/("""{"""),format.raw/*259.43*/("""
			var c = $(this).prop("checked");
			var target = $(this).attr('data-check');
			if(c) $(target).prop( "checked", true );
			else $(target).prop( "checked", false );
		"""),format.raw/*264.3*/("""}"""),format.raw/*264.4*/(""");
		
		$('#checkAllLineaAnulacion').on('change', function()"""),format.raw/*266.55*/("""{"""),format.raw/*266.56*/("""
			var c = $(this).prop("checked");
			var target = $(this).attr('data-check-linea-anulacion');
			if(c) $(target).prop( "checked", true );
			else $(target).prop( "checked", false );
		"""),format.raw/*271.3*/("""}"""),format.raw/*271.4*/(""");
		
		
		
		
		$(".anularProducto").click( function () """),format.raw/*276.43*/("""{"""),format.raw/*276.44*/("""
			var url = $(this).attr('href');
			var modal = $('<div></div>').dialog("""),format.raw/*278.40*/("""{"""),format.raw/*278.41*/("""
				resizable: false,
			    title: "Anular productos a recepcionar",
			    height: 250,
			    width: 750,
			    modal: true,
			    open: function( event, ui ) """),format.raw/*284.36*/("""{"""),format.raw/*284.37*/("""
					$.get(url, function(data)"""),format.raw/*285.31*/("""{"""),format.raw/*285.32*/("""
						modal.html(data);
					"""),format.raw/*287.6*/("""}"""),format.raw/*287.7*/(""");
			    """),format.raw/*288.8*/("""}"""),format.raw/*288.9*/(""",
			    close: function(event, ui )"""),format.raw/*289.35*/("""{"""),format.raw/*289.36*/("""
			    	modal.dialog('destroy');
				"""),format.raw/*291.5*/("""}"""),format.raw/*291.6*/("""
			  """),format.raw/*292.6*/("""}"""),format.raw/*292.7*/(""");
			
			modal.on('submit', function(e)"""),format.raw/*294.34*/("""{"""),format.raw/*294.35*/("""
				var href = $(e.target).attr('action');
				var data = $(e.target).serialize();
				$.post(href, data, function(resultado)"""),format.raw/*297.43*/("""{"""),format.raw/*297.44*/("""
					if(resultado.success) """),format.raw/*298.28*/("""{"""),format.raw/*298.29*/("""
						modal.dialog('destroy');
						location.reload();
					"""),format.raw/*301.6*/("""}"""),format.raw/*301.7*/(""" else """),format.raw/*301.13*/("""{"""),format.raw/*301.14*/("""
						modal.html(resultado);
					"""),format.raw/*303.6*/("""}"""),format.raw/*303.7*/("""
					
				"""),format.raw/*305.5*/("""}"""),format.raw/*305.6*/(""");
				return false;
			"""),format.raw/*307.4*/("""}"""),format.raw/*307.5*/(""");
			
			
			return false;
		"""),format.raw/*311.3*/("""}"""),format.raw/*311.4*/(""");
		
		function getCheckCertificacionesServiciosSeleccionados()"""),format.raw/*313.59*/("""{"""),format.raw/*313.60*/("""
			return $("input[name='check_listado[]']").serialize();
		"""),format.raw/*315.3*/("""}"""),format.raw/*315.4*/("""
		
		$('#certificar').click( function() """),format.raw/*317.38*/("""{"""),format.raw/*317.39*/("""
			var check = $('.check_productos:checked');
			if(check.length <= 0) """),format.raw/*319.26*/("""{"""),format.raw/*319.27*/("""
				alert("Debe seleccionar al menos un producto.");
				return false;
			"""),format.raw/*322.4*/("""}"""),format.raw/*322.5*/("""

			var idOrdenProvision = $('#idOrdenProvision').val();
			var data = getCheckCertificacionesServiciosSeleccionados();
			var url = $(this).attr("data-url");
			 
			$.post(url, data,function(data)"""),format.raw/*328.35*/("""{"""),format.raw/*328.36*/("""
				if(data.success)"""),format.raw/*329.21*/("""{"""),format.raw/*329.22*/("""
					window.location = '/patrimonio/certificaciones/editar?id='+data.idCertificacionServicio;	
				"""),format.raw/*331.5*/("""}"""),format.raw/*331.6*/("""else"""),format.raw/*331.10*/("""{"""),format.raw/*331.11*/("""
					/**************************/
					if(data.cargarPacientes)"""),format.raw/*333.30*/("""{"""),format.raw/*333.31*/("""
						var url = $(this).attr("data-url");
						var dialogo = $('<div></div>');
				
						dialogo.dialog("""),format.raw/*337.22*/("""{"""),format.raw/*337.23*/("""
							title: "CARGAR PACIENTES",
					    	resizable: false,
							autoOpen: true,
							modal: true,
							height: 450,
							width:750,
					        buttons: """),format.raw/*344.23*/("""{"""),format.raw/*344.24*/("""
						          Cerrar: function() """),format.raw/*345.36*/("""{"""),format.raw/*345.37*/("""
						            $( this ).dialog( "destroy" );
						          """),format.raw/*347.17*/("""}"""),format.raw/*347.18*/("""
						    """),format.raw/*348.11*/("""}"""),format.raw/*348.12*/(""",
					    	close: function(event, ui )"""),format.raw/*349.38*/("""{"""),format.raw/*349.39*/("""
					    		$(this).dialog( "destroy" );
					    	"""),format.raw/*351.11*/("""}"""),format.raw/*351.12*/(""",
						    open: function( event, ui ) """),format.raw/*352.39*/("""{"""),format.raw/*352.40*/("""
								dialogo.html(data.html);
							"""),format.raw/*354.8*/("""}"""),format.raw/*354.9*/("""
					    """),format.raw/*355.10*/("""}"""),format.raw/*355.11*/(""");
					"""),format.raw/*356.6*/("""}"""),format.raw/*356.7*/("""else"""),format.raw/*356.11*/("""{"""),format.raw/*356.12*/("""
						alert("No se puede generar la Certificacion.")
					"""),format.raw/*358.6*/("""}"""),format.raw/*358.7*/("""
				"""),format.raw/*359.5*/("""}"""),format.raw/*359.6*/("""
			"""),format.raw/*360.4*/("""}"""),format.raw/*360.5*/(""");	
			
			return false;
		"""),format.raw/*363.3*/("""}"""),format.raw/*363.4*/(""");
		
		
		
	"""),format.raw/*367.2*/("""}"""),format.raw/*367.3*/(""");
	</script>

""")))})))}
    }
    
    def render(orden:OrdenProvision,buscador:utils.pagination.Pagination[OrdenProvisionLineas],paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(orden,buscador,paginadorFicha)
    
    def f:((OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas],utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (orden,buscador,paginadorFicha) => apply(orden,buscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/verOrdenProvision.scala.html
                    HASH: dbee7393e524d0cbda7c9d98da9674cbabf553cf
                    MATRIX: 904->1|1171->247|1185->254|1269->258|1322->275|1337->281|1415->337|1502->388|1517->394|1593->448|1680->499|1695->505|1768->556|1855->607|1870->613|1939->660|2016->134|2044->194|2081->197|2103->211|2153->240|2186->697|2226->702|2239->707|2314->773|2354->775|2502->887|2551->927|2590->928|2640->942|2692->985|2731->986|2872->1090|3307->1489|3413->1585|3454->1587|3637->1734|3657->1745|3765->1830|3885->1918|4066->2063|4086->2074|4189->2154|4841->2770|4861->2781|4962->2859|5160->3021|5180->3032|5287->3116|5531->3324|5551->3335|5654->3415|5754->3479|5805->3521|5845->3523|6001->3643|6021->3654|6142->3752|6346->3920|6366->3931|6465->4007|6657->4163|6677->4174|6776->4250|6867->4309|6914->4320|6973->4370|7013->4372|7174->4497|7194->4508|7314->4605|7409->4669|7558->4782|7578->4793|7680->4872|7785->4942|7837->4985|7877->4987|7920->4995|7964->5030|8004->5032|8101->5092|8122->5103|8193->5151|8248->5169|8263->5174|8294->5181|8436->5291|8480->5299|8527->5336|8568->5338|8665->5398|8686->5409|8765->5465|8909->5577|8935->5585|8949->5590|8989->5591|9033->5599|9093->5649|9134->5651|9244->5724|9265->5735|9372->5818|9545->5959|9595->5973|9653->6021|9694->6023|9791->6083|9812->6094|9896->6155|9952->6173|9968->6178|9999->6185|10142->6296|10189->6311|10270->6356|10284->6361|10332->6386|10433->6451|10486->6494|10527->6496|10579->6511|10600->6522|10694->6585|10712->6593|10745->6602|10860->6685|10901->6690|10956->6735|10997->6737|11049->6752|11070->6763|11166->6828|11184->6836|11217->6845|11370->6966|11445->7005|11496->7046|11536->7047|11662->7141|11748->7190|11766->7198|11880->7288|11997->7369|12047->7409|12087->7410|12158->7445|12196->7473|12237->7475|12304->7505|12325->7516|12437->7596|12456->7604|12489->7613|12605->7697|12722->7777|12746->7791|12787->7808|12830->7813|12855->7827|12897->7845|12943->7855|12981->7883|13022->7885|13089->7915|13110->7926|13222->8006|13241->8014|13274->8023|13391->8108|13440->8125|13601->8249|13616->8254|13642->8257|13857->8435|13872->8440|13902->8447|14089->8597|14104->8602|14146->8621|14397->8835|14412->8840|14452->8857|14635->9003|14650->9008|14722->9056|14920->9217|14935->9222|15008->9271|15243->9469|15262->9478|15332->9524|15517->9672|15536->9681|15591->9713|15822->9907|15837->9912|15889->9941|16066->10081|16085->10090|16152->10133|16326->10270|16345->10279|16408->10319|16587->10461|16606->10470|16659->10500|16836->10640|16855->10649|16904->10675|16995->10730|17048->10773|17089->10775|17129->10779|17143->10784|17230->10848|17252->10852|17265->10857|17304->10858|17344->10862|17358->10867|17455->10941|17490->10944|17556->10981|17586->10982|17726->11093|17756->11094|17960->11270|17989->11271|18080->11333|18110->11334|18330->11526|18359->11527|18450->11589|18480->11590|18586->11667|18616->11668|18816->11839|18846->11840|18907->11872|18937->11873|18997->11905|19026->11906|19065->11917|19094->11918|19160->11955|19190->11956|19258->11996|19287->11997|19322->12004|19351->12005|19422->12047|19452->12048|19610->12177|19640->12178|19698->12207|19728->12208|19821->12273|19850->12274|19885->12280|19915->12281|19980->12318|20009->12319|20050->12332|20079->12333|20133->12359|20162->12360|20224->12394|20253->12395|20348->12461|20378->12462|20469->12525|20498->12526|20570->12569|20600->12570|20703->12644|20733->12645|20839->12723|20868->12724|21102->12929|21132->12930|21183->12952|21213->12953|21343->13055|21372->13056|21405->13060|21435->13061|21530->13127|21560->13128|21700->13239|21730->13240|21932->13413|21962->13414|22028->13451|22058->13452|22155->13520|22185->13521|22226->13533|22256->13534|22325->13574|22355->13575|22437->13628|22467->13629|22537->13670|22567->13671|22638->13714|22667->13715|22707->13726|22737->13727|22774->13736|22803->13737|22836->13741|22866->13742|22955->13803|22984->13804|23018->13810|23047->13811|23080->13816|23109->13817|23167->13847|23196->13848|23241->13865|23270->13866
                    LINES: 26->1|33->9|33->9|35->9|36->10|36->10|36->10|37->11|37->11|37->11|38->12|38->12|38->12|39->13|39->13|39->13|41->1|42->5|43->6|43->6|43->6|46->14|48->16|48->16|48->16|48->16|53->21|53->21|53->21|54->22|54->22|54->22|55->23|63->31|63->31|63->31|66->34|66->34|66->34|70->38|73->41|73->41|73->41|89->57|89->57|89->57|94->62|94->62|94->62|99->67|99->67|99->67|102->70|102->70|102->70|105->73|105->73|105->73|110->78|110->78|110->78|114->82|114->82|114->82|116->84|117->85|117->85|117->85|120->88|120->88|120->88|122->90|125->93|125->93|125->93|129->97|129->97|129->97|130->98|130->98|130->98|132->100|132->100|132->100|132->100|132->100|132->100|134->102|135->103|135->103|135->103|137->105|137->105|137->105|139->107|140->108|140->108|140->108|141->109|141->109|141->109|143->111|143->111|143->111|146->114|148->116|148->116|148->116|150->118|150->118|150->118|150->118|150->118|150->118|152->120|154->122|161->129|161->129|161->129|165->133|165->133|165->133|166->134|166->134|166->134|166->134|166->134|167->135|168->136|168->136|168->136|169->137|169->137|169->137|169->137|169->137|170->138|173->141|173->141|173->141|175->143|178->146|178->146|178->146|180->148|180->148|180->148|183->151|183->151|183->151|184->152|184->152|184->152|184->152|184->152|185->153|186->154|186->154|186->154|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|188->156|188->156|189->157|191->159|199->167|199->167|199->167|204->172|204->172|204->172|208->176|208->176|208->176|218->186|218->186|218->186|222->190|222->190|222->190|231->199|231->199|231->199|238->206|238->206|238->206|243->211|243->211|243->211|255->223|255->223|255->223|259->227|259->227|259->227|263->231|263->231|263->231|267->235|267->235|267->235|271->239|271->239|271->239|278->246|278->246|278->246|279->247|279->247|279->247|280->248|280->248|280->248|281->249|281->249|281->249|282->250|286->254|286->254|291->259|291->259|296->264|296->264|298->266|298->266|303->271|303->271|308->276|308->276|310->278|310->278|316->284|316->284|317->285|317->285|319->287|319->287|320->288|320->288|321->289|321->289|323->291|323->291|324->292|324->292|326->294|326->294|329->297|329->297|330->298|330->298|333->301|333->301|333->301|333->301|335->303|335->303|337->305|337->305|339->307|339->307|343->311|343->311|345->313|345->313|347->315|347->315|349->317|349->317|351->319|351->319|354->322|354->322|360->328|360->328|361->329|361->329|363->331|363->331|363->331|363->331|365->333|365->333|369->337|369->337|376->344|376->344|377->345|377->345|379->347|379->347|380->348|380->348|381->349|381->349|383->351|383->351|384->352|384->352|386->354|386->354|387->355|387->355|388->356|388->356|388->356|388->356|390->358|390->358|391->359|391->359|392->360|392->360|395->363|395->363|399->367|399->367
                    -- GENERATED --
                */
            