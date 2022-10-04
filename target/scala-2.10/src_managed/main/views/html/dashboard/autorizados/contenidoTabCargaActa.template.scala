
package views.html.dashboard.autorizados

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
object contenidoTabCargaActa extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],DynamicForm,Long,Autorizado,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada], formBuscador: DynamicForm,idAutorizado:Long,autorizado:Autorizado):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var resto_autorizar=new java.math.BigDecimal(0);

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.158*/("""
"""),format.raw/*3.70*/("""
"""),format.raw/*5.1*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h2>Carga de Autorizados por Acta</h1>
		</div>
		<div class="col-sm-3" style="border: 1px solid grey;">
			<div class="form-group">
				<p style="font-weight: bold;">Total Seleccionado:<span id="totalDeudaSeleccionada">$0.00</span></p>
				<div id="loadingBtnCargaMasiva" class="loading hide"></div>
				<a href="#" id="BtnCargaMasiva"  class="form-control btn btn-default">Carga Masiva</a>
			</div>
		</div>	
	</div>
	
</div>

<div id="contenedorListadoDeudasActas" class="contenedorPaginador ajaxPaginador">

<form action=""""),_display_(Seq[Any](/*24.16*/controllers/*24.27*/.dashboard.routes.AutorizadosController.getListadoDeudasActas())),format.raw/*24.90*/("""" method="GET" id="filtroInformeActa">
	"""),_display_(Seq[Any](/*25.3*/inputText(formBuscador("idAutorizado"), 'hidden -> "hidden"))),format.raw/*25.63*/("""
	<div class="row seccion">
		
	<div class="form-group col-sm-2">
		<label for="nombre" class="control-label">Número
		"""),_display_(Seq[Any](/*30.4*/inputText(formBuscador("acta_numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*30.95*/("""
		</label>
	</div>

	<div class="form-group col-sm-2">
		<label for="nombre" class="control-label">Orden provisión
		"""),_display_(Seq[Any](/*36.4*/inputText(formBuscador("orden_provision"), 'class -> "form-control"))),format.raw/*36.72*/("""
		</label>
	</div>
			
	<div class="col-sm-4">
		<label class="control-label">Proveedor
			<div class="input-group">	
				"""),_display_(Seq[Any](/*43.6*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedorActa"))),format.raw/*43.112*/("""
				"""),_display_(Seq[Any](/*44.6*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_idActa"))),format.raw/*44.93*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedorActa" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*49.20*/controllers/*49.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*49.82*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.proveedor.simple" 
								data-label="#proveedorActa" 
								data-field="#proveedor_idActa">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>
			
	<div class="col-sm-2">
		<label class="control-label">Expediente
			<div class="input-group">
				"""),_display_(Seq[Any](/*65.6*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expedienteActa"))),format.raw/*65.114*/("""
				"""),_display_(Seq[Any](/*66.6*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_idActa"))),format.raw/*66.95*/("""
				
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchExpedienteActa" 
								data-title="Selección de expediente" 
								data-url=""""),_display_(Seq[Any](/*72.20*/controllers/*72.31*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*72.85*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.expediente.simple" 
								data-label="#expedienteActa" 
								data-field="#expediente_idActa">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>  
		
	<div class="col-sm-2">
		<label class="control-label">Ejercicio</label>
			"""),_display_(Seq[Any](/*87.5*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*87.164*/("""
	</div>	
			
	</div>
	
	<div class="row">
	
		<!-- <div class="col-sm-2">
			<label class="control-label"> 
				Cuenta
				"""),_display_(Seq[Any](/*97.6*/select(formBuscador("profe"),options(""->"","profe"->"PROFE","operativa"->"OPERATIVA"), 'class -> "form-control select"))),format.raw/*97.126*/("""
			</label>
		</div> --> 
		<div class="col-sm-2">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*103.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*104.126*/("""
			</label>
		</div>		
			
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<div id="loadingBtnBuscarActa" class="loading hide"></div>
			<button id="BtnBuscarActa"  class="form-control btn btn-primary">Buscar</button>
			</div>
		</div>
		<div class="col-sm-4">
		
		</div>
		
		 
	</div>
</form>
    """),_display_(Seq[Any](/*122.6*/if(buscador.getTotalRowCount == 0)/*122.40*/ {_display_(Seq[Any](format.raw/*122.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*128.7*/else/*128.12*/{_display_(Seq[Any](format.raw/*128.13*/("""
		Mostrando """),_display_(Seq[Any](/*129.14*/buscador/*129.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*129.54*/(""" resultado(s).   
		<table class="table table-striped table-bordered" id="listaInformeActa">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th>Acta</th>
					<th>Cuenta</th>
					<th>Ejercicio</th>
					<th>Periodo</th>
					<th>Institucion</th>
					<th>Fecha acta</th>
					<th width="40">OP</th>
					<th>Proveedor</th>
					<th width="90">Expediente</th>
					<th>Total autorizado</th>
					<th>Total acta</th>
					<th width="90">Total pagado</th>
					<th width="90">Total deuda</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*151.12*/for(informe <- buscador.getList) yield /*151.44*/ {_display_(Seq[Any](format.raw/*151.46*/("""
				<tr >
					<td>
						"""),_display_(Seq[Any](/*154.8*/if(!Ejercicio.isPerimido(informe.ejercicio_id))/*154.55*/{_display_(Seq[Any](format.raw/*154.56*/("""
							"""),_display_(Seq[Any](/*155.9*/if(!informe.es_dolar)/*155.30*/{_display_(Seq[Any](format.raw/*155.31*/("""
								"""),_display_(Seq[Any](/*156.10*/if(informe.acta_numero == "Anticipo")/*156.47*/{_display_(Seq[Any](format.raw/*156.48*/("""
									<input type="checkbox" name="check_listado_informe_acta[]" value="ANT"""),_display_(Seq[Any](/*157.80*/informe/*157.87*/.id)),format.raw/*157.90*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*157.124*/informe/*157.131*/.id_fake)),format.raw/*157.139*/(""""/>
								""")))}/*158.10*/else/*158.14*/{_display_(Seq[Any](format.raw/*158.15*/("""
									"""),_display_(Seq[Any](/*159.11*/if(informe.certificacion_id != null)/*159.47*/{_display_(Seq[Any](format.raw/*159.48*/("""
										<input type="checkbox" name="check_listado_informe_acta[]" value="CC"""),_display_(Seq[Any](/*160.80*/informe/*160.87*/.certificacion_id)),format.raw/*160.104*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*160.138*/informe/*160.145*/.id_fake)),format.raw/*160.153*/(""""/>
									""")))}/*161.11*/else/*161.15*/{_display_(Seq[Any](format.raw/*161.16*/("""
										<input type="checkbox" name="check_listado_informe_acta[]" value="AC"""),_display_(Seq[Any](/*162.80*/informe/*162.87*/.id)),format.raw/*162.90*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*162.124*/informe/*162.131*/.id_fake)),format.raw/*162.139*/(""""/>
									""")))})),format.raw/*163.11*/("""
								""")))})),format.raw/*164.10*/("""
							""")))})),format.raw/*165.9*/("""
						""")))})),format.raw/*166.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*168.11*/informe/*168.18*/.acta_numero)),format.raw/*168.30*/("""
						<br>"""),_display_(Seq[Any](/*169.12*/if(informe.es_dolar)/*169.32*/{_display_(Seq[Any](format.raw/*169.33*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*169.105*/("""
					</td>
					 
					<td>"""),_display_(Seq[Any](/*172.11*/if(informe.tipoCuenta != null)/*172.41*/{_display_(Seq[Any](_display_(Seq[Any](/*172.43*/informe/*172.50*/.tipoCuenta.nombre))))})),format.raw/*172.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*173.11*/if(informe.ejercicio != null)/*173.40*/{_display_(Seq[Any](_display_(Seq[Any](/*173.42*/informe/*173.49*/.ejercicio.nombre))))})),format.raw/*173.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*174.11*/if(informe.periodo != null)/*174.38*/{_display_(Seq[Any](_display_(Seq[Any](/*174.40*/informe/*174.47*/.periodo))))})),format.raw/*174.56*/(""" </td>
					<td>"""),_display_(Seq[Any](/*175.11*/informe/*175.18*/.ordenCompra.deposito.nombre)),format.raw/*175.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*176.11*/utils/*176.16*/.DateUtils.formatDate(informe.fecha))),format.raw/*176.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*177.11*/if(informe.ordenProvision != null)/*177.45*/{_display_(Seq[Any](_display_(Seq[Any](/*177.47*/informe/*177.54*/.ordenProvision.numero))))})),format.raw/*177.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*178.11*/informe/*178.18*/.proveedor.nombre)),format.raw/*178.35*/("""</td>			
					<td>"""),_display_(Seq[Any](/*179.11*/informe/*179.18*/.expediente.getExpedienteEjercicio())),format.raw/*179.54*/("""</td>
					<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*180.47*/informe/*180.54*/.totalAutorizado)),format.raw/*180.70*/("""">"""),_display_(Seq[Any](/*180.73*/utils/*180.78*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*180.122*/("""</td>
					<td class="totalActa" data-valor=""""),_display_(Seq[Any](/*181.41*/informe/*181.48*/.totalActa)),format.raw/*181.58*/("""">"""),_display_(Seq[Any](/*181.61*/utils/*181.66*/.NumberUtils.moneda(informe.totalActa))),format.raw/*181.104*/("""</td>
					<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*182.43*/informe/*182.50*/.totalPagado)),format.raw/*182.62*/("""">"""),_display_(Seq[Any](/*182.65*/utils/*182.70*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*182.110*/("""</td>
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*183.42*/informe/*183.49*/.totalDeuda)),format.raw/*183.60*/("""">"""),_display_(Seq[Any](/*183.63*/utils/*183.68*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*183.107*/("""</td>		
					<td>
						
					 	"""),_display_(Seq[Any](/*186.9*/if(!Ejercicio.isPerimido(informe.ejercicio_id))/*186.56*/{_display_(Seq[Any](format.raw/*186.57*/("""
							"""),_display_(Seq[Any](/*187.9*/if(informe.es_dolar && autorizado.cot_dolar == null)/*187.61*/{_display_(Seq[Any](format.raw/*187.62*/("""
								<span style="color:green;font-weight:bold;font-size: 12px;">EXPEDIENTE MONEDA EXTRANJERA DEBE CARGAR UNA COTIZACION EN EL AUTORIZADO.</span>
							""")))}/*189.9*/else/*189.13*/{_display_(Seq[Any](format.raw/*189.14*/("""
								"""),_display_(Seq[Any](/*190.10*/if(informe.es_dolar && autorizado.tipo_moneda_id == null)/*190.67*/{_display_(Seq[Any](format.raw/*190.68*/("""
									<span style="color:green;font-weight:bold;font-size: 12px;">EXPEDIENTE MONEDA EXTRANJERA DEBE CARGAR UN TIPO DE MONEDA PARA LA COTIZACION.</span>
								""")))}/*192.10*/else/*192.14*/{_display_(Seq[Any](format.raw/*192.15*/(""" 
									 
									"""),_display_(Seq[Any](/*194.11*/if(informe.es_dolar && autorizado.tipo_moneda_id != null && informe.ordenCompra.tipo_moneda != autorizado.tipo_moneda_id.intValue())/*194.143*/{_display_(Seq[Any](format.raw/*194.144*/("""
										<span style="color:green;font-weight:bold;font-size: 12px;">EL TIPO DE MONEDA DEL AUTORIZADO NO CORRESPONDE AL TIPO DE MONEDA DE LA ORDEN.</span>
									""")))}/*196.11*/else/*196.15*/{_display_(Seq[Any](format.raw/*196.16*/("""
										"""),_display_(Seq[Any](/*197.12*/if(autorizado.estado.id ==  models.Estado.AUTORIZADO_ESTADO_BORRADOR)/*197.81*/{_display_(Seq[Any](format.raw/*197.82*/("""
											
											"""),_display_(Seq[Any](/*199.13*/if(informe.ordenProvision != null)/*199.47*/ {_display_(Seq[Any](format.raw/*199.49*/("""
												"""),_display_(Seq[Any](/*200.14*/{resto_autorizar= new java.math.BigDecimal(0)})),format.raw/*200.60*/("""
												"""),_display_(Seq[Any](/*201.14*/{resto_autorizar= informe.totalPagado.add(informe.totalDeuda).subtract(informe.totalAutorizado)})),format.raw/*201.110*/("""
												<a data-url=""""),_display_(Seq[Any](/*202.27*/controllers/*202.38*/.dashboard.routes.AutorizadosController.modalAgregarMontosActas(informe.id,informe.orden_provision_id,idAutorizado,informe.ordenProvision.orden_compra_id,informe.tipo_cuenta_id))),format.raw/*202.215*/("""" href="#"  class="btn btn-default agregarMontos">
													<i class="glyphicon glyphicon-plus"></i>
												</a>
											""")))}/*205.13*/else/*205.17*/{_display_(Seq[Any](format.raw/*205.18*/("""
												"""),_display_(Seq[Any](/*206.14*/if(informe.acta_numero == "CC")/*206.45*/{_display_(Seq[Any](format.raw/*206.46*/("""
													<a data-url=""""),_display_(Seq[Any](/*207.28*/controllers/*207.39*/.dashboard.routes.AutorizadosController.modalAgregarMontosCertificacionesCompras(informe.certificacion_id,idAutorizado,informe.orden_id,informe.tipo_cuenta_id))),format.raw/*207.198*/("""" href="#"  class="btn btn-default agregarMontos">
														<i class="glyphicon glyphicon-plus"></i>
													</a>
												""")))})),format.raw/*210.14*/("""	
											""")))})),format.raw/*211.13*/("""	
										""")))})),format.raw/*212.12*/("""
									""")))})),format.raw/*213.11*/("""
								""")))})),format.raw/*214.10*/("""		
							""")))})),format.raw/*215.9*/("""
						""")))})),format.raw/*216.8*/("""
					</td>
				</tr>
		        """)))})),format.raw/*219.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10"></td>
					<td><b>Total:</b><br /><span id="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span id="actaFooter"></span></td>
					<td><b>Total:</b><br /><span id="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span id="deudaFooter"></span></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*233.8*/views/*233.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.AutorizadosController.getListadoDeudasActas()))),format.raw/*233.122*/("""
		</div>
	""")))})),format.raw/*235.3*/("""
</div>	
<script type="text/javascript">
	$(function()"""),format.raw/*238.14*/("""{"""),format.raw/*238.15*/("""
		
		var trs = $('#listaInformeActa tbody tr');
		 
		$('#checkAll').change( function()"""),format.raw/*242.36*/("""{"""),format.raw/*242.37*/("""
			var table = $(this).closest('table');
			table.find("input[name='check_listado_informe_acta[]']").prop("checked", $(this).prop( "checked" ) );
			var trsx = $('#listaInformeActa tbody tr:has(td:eq(0):has(input:checked))'); 
			sumarFilas(trsx);
		"""),format.raw/*247.3*/("""}"""),format.raw/*247.4*/(""");
		
		 
		
		$('input[name="check_listado_informe_acta[]"]').click( function() """),format.raw/*251.69*/("""{"""),format.raw/*251.70*/("""
			sumarFilas( $('#listaInformeActa tbody tr:has(td:eq(0):has(input:checked))') );
		"""),format.raw/*253.3*/("""}"""),format.raw/*253.4*/(""");
		
		function sumarFilas(trs) """),format.raw/*255.28*/("""{"""),format.raw/*255.29*/("""
			var deudax = 0; 
			trs.each( function() """),format.raw/*257.25*/("""{"""),format.raw/*257.26*/("""
				deudax += Number($('.totalDeuda',this).attr("data-valor"));
			"""),format.raw/*259.4*/("""}"""),format.raw/*259.5*/(""");
			$("#totalDeudaSeleccionada").html(formatNumberPesos(parseFloat(deudax).toFixed(2)));
		"""),format.raw/*261.3*/("""}"""),format.raw/*261.4*/("""
		
		
		
		$('.agregarMontos').click( function() """),format.raw/*265.41*/("""{"""),format.raw/*265.42*/(""" //abrir modal para pasar en PreCurso
			var url = $(this).attr("data-url");
			var dialogo = $('<div id="modalAgregarMontosActas"></div>');
			dialogo.dialog("""),format.raw/*268.19*/("""{"""),format.raw/*268.20*/("""
				title: "Carga Autorizado",
		    	resizable: false,
				autoOpen: true,
				modal: true,
				height: 450,
				width:900,
		        /*buttons: """),format.raw/*275.22*/("""{"""),format.raw/*275.23*/("""
			          Cerrar: function() """),format.raw/*276.33*/("""{"""),format.raw/*276.34*/("""
			            $( this ).dialog( "destroy" );
			          """),format.raw/*278.14*/("""}"""),format.raw/*278.15*/("""
			    """),format.raw/*279.8*/("""}"""),format.raw/*279.9*/(""",*/
		    	close: function(event, ui )"""),format.raw/*280.35*/("""{"""),format.raw/*280.36*/("""
		    		$(this).dialog( "destroy" );
		    	"""),format.raw/*282.8*/("""}"""),format.raw/*282.9*/(""",
			    open: function( event, ui ) """),format.raw/*283.36*/("""{"""),format.raw/*283.37*/("""
					$.post(url, function(data)"""),format.raw/*284.32*/("""{"""),format.raw/*284.33*/("""
						dialogo.html(data);
					"""),format.raw/*286.6*/("""}"""),format.raw/*286.7*/(""");	
			    """),format.raw/*287.8*/("""}"""),format.raw/*287.9*/("""
		      """),format.raw/*288.9*/("""}"""),format.raw/*288.10*/(""");
		"""),format.raw/*289.3*/("""}"""),format.raw/*289.4*/(""");
		
		
		$("#BtnCargaMasiva").click( function() """),format.raw/*292.42*/("""{"""),format.raw/*292.43*/(""" 
			$('#loadingBtnCargaMasiva').removeClass('hide');
			$('#BtnCargaMasiva').hide();
			$('.agregarMontos').hide();
			
			$('#loadingBtnBuscarActa').removeClass('hide');
			$('#BtnBuscarActa').hide();
			
			var url2 = "/dashboard/autorizado/cargarLineasAutorizadosMasivamente";
			var data = "idAutorizado="+$("#idAutorizado").val()+"&"+$("input[name='check_listado_informe_acta[]']").serialize();
			 
			$.ajax("""),format.raw/*303.11*/("""{"""),format.raw/*303.12*/("""
	            url:url2,
	            type: 'POST',
	            data: data,
	            
	            success: function(data1) """),format.raw/*308.39*/("""{"""),format.raw/*308.40*/("""
	            	 
	            	if(data1.error) """),format.raw/*310.31*/("""{"""),format.raw/*310.32*/("""
	            		alert(data1.errorTexto); 
	            		$('#loadingBtnBuscarActa').addClass('hide');
						$('#BtnBuscarActa').show();
						
						$('#loadingBtnCargaMasiva').addClass('hide');
						$('#BtnCargaMasiva').show();
						$('.agregarMontos').show();
	            	"""),format.raw/*318.15*/("""}"""),format.raw/*318.16*/("""else"""),format.raw/*318.20*/("""{"""),format.raw/*318.21*/("""
	            		 
	            		if(data1.success) """),format.raw/*320.34*/("""{"""),format.raw/*320.35*/("""
	            			 
							var contenedorx = $("#contenedorListadoDeudasActas");
							var urlx = contenedorx.find('form').attr("action");
	            			var queryx = contenedorx.find('form').serialize();
	            			 
	            			$.get(urlx+"?"+queryx, function(data2x)"""),format.raw/*326.56*/("""{"""),format.raw/*326.57*/("""
								contenedorx.parent().html(data2x);
								$('#loadingBtnBuscarActa').addClass('hide');
								$('#BtnBuscarActa').show();
								
								$('#loadingBtnCargaMasiva').addClass('hide');
								$('#BtnCargaMasiva').show();
								$('.agregarMontos').show();
							"""),format.raw/*334.8*/("""}"""),format.raw/*334.9*/(""");
							
						"""),format.raw/*336.7*/("""}"""),format.raw/*336.8*/(""" 
	            	"""),format.raw/*337.15*/("""}"""),format.raw/*337.16*/("""
	            	
	            	
	            """),format.raw/*340.14*/("""}"""),format.raw/*340.15*/("""
			"""),format.raw/*341.4*/("""}"""),format.raw/*341.5*/("""); 
		"""),format.raw/*342.3*/("""}"""),format.raw/*342.4*/(""");
		
		
		$('#searchExpedienteActa, #searchProveedorActa').modalSearch();
		
		var contenedor = $("#contenedorListadoDeudasActas");
		contenedor.find('form').on('submit', function(e)"""),format.raw/*348.51*/("""{"""),format.raw/*348.52*/("""
			 
			var url2 = "/dashboard/autorizado/controlCargaCotizacion";
			var data = "idAutorizado="+$("#idAutorizado").val()+"&tipo_moneda_id="+$("#tipo_moneda_id").val()+"&cot_dolar="+$("#cot_dolar").val().replace(",", ".")
			var control = false;
			var url = $(this).attr("action");
			var query = $(this).serialize();
			
			$.ajax("""),format.raw/*356.11*/("""{"""),format.raw/*356.12*/("""
	            url:url2,
	            type: 'POST',
	            data: data,
	            async: false, 
	            success: function(data1) """),format.raw/*361.39*/("""{"""),format.raw/*361.40*/("""
	            	
	            	if(data1.success) """),format.raw/*363.33*/("""{"""),format.raw/*363.34*/("""
						
						alert(data1.texto);
						control = false; 
					"""),format.raw/*367.6*/("""}"""),format.raw/*367.7*/("""else"""),format.raw/*367.11*/("""{"""),format.raw/*367.12*/("""
						
						
						$('#loadingBtnBuscarActa').removeClass('hide');
						$('#BtnBuscarActa').hide();
						$.get(url+"?"+query, function(data2)"""),format.raw/*372.43*/("""{"""),format.raw/*372.44*/("""
							contenedor.parent().html(data2);
							$('#loadingBtnBuscarActa').addClass('hide');
							$('#BtnBuscarActa').show();
						"""),format.raw/*376.7*/("""}"""),format.raw/*376.8*/(""");
						 
					"""),format.raw/*378.6*/("""}"""),format.raw/*378.7*/("""
	            	
	            """),format.raw/*380.14*/("""}"""),format.raw/*380.15*/("""
			"""),format.raw/*381.4*/("""}"""),format.raw/*381.5*/(""");
			
			
			/*$.post(url,data, function(data)"""),format.raw/*384.37*/("""{"""),format.raw/*384.38*/("""
				
				 
				
				if(data.success) """),format.raw/*388.22*/("""{"""),format.raw/*388.23*/("""
					
					alert(data.texto);
					control = false; 
				"""),format.raw/*392.5*/("""}"""),format.raw/*392.6*/("""else"""),format.raw/*392.10*/("""{"""),format.raw/*392.11*/("""
					
					var url = $(this).attr("action");
					var query = $(this).serialize();
					$('#loadingBtnBuscarActa').removeClass('hide');
					$('#BtnBuscarActa').hide();
					$.get(url+"?"+query, function(data)"""),format.raw/*398.41*/("""{"""),format.raw/*398.42*/("""
						contenedor.parent().html(data);
						$('#loadingBtnBuscarActa').addClass('hide');
						$('#BtnBuscarActa').show();
					"""),format.raw/*402.6*/("""}"""),format.raw/*402.7*/(""");
					 
				"""),format.raw/*404.5*/("""}"""),format.raw/*404.6*/("""
				 
			"""),format.raw/*406.4*/("""}"""),format.raw/*406.5*/(""");*/
			
			return control;
			
			
		"""),format.raw/*411.3*/("""}"""),format.raw/*411.4*/(""");
		
		$('.actas').click( function() """),format.raw/*413.33*/("""{"""),format.raw/*413.34*/("""
			var $this = $(this);
			var url = $this.attr('href');
			var oid = $(this).data('data-id-provision');
			$.get(url, function(data) """),format.raw/*417.30*/("""{"""),format.raw/*417.31*/("""
				$this.parent().html(data);
			"""),format.raw/*419.4*/("""}"""),format.raw/*419.5*/(""");
			return false;
		"""),format.raw/*421.3*/("""}"""),format.raw/*421.4*/(""");
		
		var trs = $('#listaInformeActa tbody tr');

		var orden = 0; var pagado = 0; var deuda = 0; var compromiso = 0;var autorizado = 0;
		
		trs.each( function() """),format.raw/*427.24*/("""{"""),format.raw/*427.25*/("""
			autorizado += Number($('.totalAutorizado',this).attr("data-valor"));
			orden += Number($('.totalActa',this).attr("data-valor"));
			pagado += Number($('.totalPagado',this).attr("data-valor"));
			deuda += Number($('.totalDeuda',this).attr("data-valor"));
		"""),format.raw/*432.3*/("""}"""),format.raw/*432.4*/(""");

		$("#actaFooter").html(formatNumberPesos(parseFloat(orden).toFixed(2)));
		$("#pagadoFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
		$("#deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
		$("#autorizadoFooter").html(formatNumberPesos(parseFloat(autorizado).toFixed(2)));
		
		
		if($("#proveedorActa").length)"""),format.raw/*440.33*/("""{"""),format.raw/*440.34*/("""
			var options = """),format.raw/*441.18*/("""{"""),format.raw/*441.19*/("""
					script:"/suggestProveedor/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*447.31*/("""{"""),format.raw/*447.32*/(""" 
												$("#proveedor_idActa").val(obj.id); 
											 """),format.raw/*449.13*/("""}"""),format.raw/*449.14*/("""
				"""),format.raw/*450.5*/("""}"""),format.raw/*450.6*/(""";
			var as_json = new bsn.AutoSuggest('proveedorActa', options);
		"""),format.raw/*452.3*/("""}"""),format.raw/*452.4*/("""
		
		if($("#expedienteActa").length)"""),format.raw/*454.34*/("""{"""),format.raw/*454.35*/("""
			var options = """),format.raw/*455.18*/("""{"""),format.raw/*455.19*/("""
					script:"/suggestExpediente/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*461.31*/("""{"""),format.raw/*461.32*/(""" 
												$("#expediente_idActa").val(obj.id); 
											 """),format.raw/*463.13*/("""}"""),format.raw/*463.14*/("""
				"""),format.raw/*464.5*/("""}"""),format.raw/*464.6*/(""";
			var as_json = new bsn.AutoSuggest('expedienteActa', options);
		"""),format.raw/*466.3*/("""}"""),format.raw/*466.4*/("""
	"""),format.raw/*467.2*/("""}"""),format.raw/*467.3*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],formBuscador:DynamicForm,idAutorizado:Long,autorizado:Autorizado): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,idAutorizado,autorizado)
    
    def f:((utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],DynamicForm,Long,Autorizado) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,idAutorizado,autorizado) => apply(buscador,formBuscador,idAutorizado,autorizado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/contenidoTabCargaActa.scala.html
                    HASH: d81f860c37d00d0de4eb80c5a4269fec8ed0b4e4
                    MATRIX: 911->1|1247->176|1279->200|1354->157|1382->244|1409->323|2047->925|2067->936|2152->999|2228->1040|2310->1100|2465->1220|2578->1311|2732->1430|2822->1498|2981->1622|3110->1728|3151->1734|3260->1821|3471->1996|3491->2007|3564->2058|3992->2451|4123->2559|4164->2565|4275->2654|4491->2834|4511->2845|4587->2899|4996->3273|5178->3432|5338->3557|5481->3677|5624->3784|5813->3949|6220->4320|6264->4354|6305->4356|6439->4472|6453->4477|6493->4478|6544->4492|6562->4500|6617->4532|7262->5140|7311->5172|7352->5174|7416->5202|7473->5249|7513->5250|7558->5259|7589->5280|7629->5281|7676->5291|7723->5328|7763->5329|7880->5409|7897->5416|7923->5419|7995->5453|8013->5460|8045->5468|8078->5481|8092->5485|8132->5486|8180->5497|8226->5533|8266->5534|8383->5614|8400->5621|8441->5638|8513->5672|8531->5679|8563->5687|8597->5701|8611->5705|8651->5706|8768->5786|8785->5793|8811->5796|8883->5830|8901->5837|8933->5845|8980->5859|9023->5869|9064->5878|9104->5886|9163->5908|9180->5915|9215->5927|9264->5939|9294->5959|9334->5960|9440->6032|9506->6061|9546->6091|9595->6093|9612->6100|9658->6119|9711->6135|9750->6164|9799->6166|9816->6173|9861->6191|9914->6207|9951->6234|10000->6236|10017->6243|10053->6252|10107->6269|10124->6276|10175->6304|10228->6320|10243->6325|10302->6361|10355->6377|10399->6411|10448->6413|10465->6420|10515->6443|10568->6459|10585->6466|10625->6483|10681->6502|10698->6509|10757->6545|10846->6597|10863->6604|10902->6620|10942->6623|10957->6628|11025->6672|11108->6718|11125->6725|11158->6735|11198->6738|11213->6743|11275->6781|11360->6829|11377->6836|11412->6848|11452->6851|11467->6856|11531->6896|11615->6943|11632->6950|11666->6961|11706->6964|11721->6969|11784->7008|11853->7041|11910->7088|11950->7089|11995->7098|12057->7150|12097->7151|12274->7309|12288->7313|12328->7314|12375->7324|12442->7381|12482->7382|12667->7547|12681->7551|12721->7552|12781->7575|12924->7707|12965->7708|13152->7875|13166->7879|13206->7880|13255->7892|13334->7961|13374->7962|13436->7987|13480->8021|13521->8023|13572->8037|13641->8083|13692->8097|13812->8193|13876->8220|13897->8231|14098->8408|14252->8542|14266->8546|14306->8547|14357->8561|14398->8592|14438->8593|14503->8621|14524->8632|14707->8791|14877->8928|14924->8942|14970->8955|15014->8966|15057->8976|15100->8987|15140->8995|15206->9028|15657->9443|15672->9448|15805->9557|15849->9569|15932->9623|15962->9624|16079->9712|16109->9713|16388->9964|16417->9965|16527->10046|16557->10047|16671->10133|16700->10134|16762->10167|16792->10168|16866->10213|16896->10214|16992->10282|17021->10283|17142->10376|17171->10377|17250->10427|17280->10428|17468->10587|17498->10588|17674->10735|17704->10736|17766->10769|17796->10770|17885->10830|17915->10831|17951->10839|17980->10840|18047->10878|18077->10879|18150->10924|18179->10925|18245->10962|18275->10963|18336->10995|18366->10996|18426->11028|18455->11029|18494->11040|18523->11041|18560->11050|18590->11051|18623->11056|18652->11057|18731->11107|18761->11108|19206->11524|19236->11525|19393->11653|19423->11654|19499->11701|19529->11702|19836->11980|19866->11981|19899->11985|19929->11986|20009->12037|20039->12038|20347->12317|20377->12318|20681->12594|20710->12595|20755->12612|20784->12613|20829->12629|20859->12630|20932->12674|20962->12675|20994->12679|21023->12680|21057->12686|21086->12687|21298->12870|21328->12871|21691->13205|21721->13206|21892->13348|21922->13349|21999->13397|22029->13398|22120->13461|22149->13462|22182->13466|22212->13467|22386->13612|22416->13613|22578->13747|22607->13748|22651->13764|22680->13765|22738->13794|22768->13795|22800->13799|22829->13800|22905->13847|22935->13848|23002->13886|23032->13887|23118->13945|23147->13946|23180->13950|23210->13951|23449->14161|23479->14162|23636->14291|23665->14292|23707->14306|23736->14307|23774->14317|23803->14318|23869->14356|23898->14357|23965->14395|23995->14396|24159->14531|24189->14532|24252->14567|24281->14568|24331->14590|24360->14591|24554->14756|24584->14757|24874->15019|24903->15020|25285->15373|25315->15374|25362->15392|25392->15393|25563->15535|25593->15536|25685->15599|25715->15600|25748->15605|25777->15606|25873->15674|25902->15675|25968->15712|25998->15713|26045->15731|26075->15732|26247->15875|26277->15876|26370->15940|26400->15941|26433->15946|26462->15947|26559->16016|26588->16017|26618->16019|26647->16020
                    LINES: 26->1|31->3|31->3|32->1|33->3|34->5|53->24|53->24|53->24|54->25|54->25|59->30|59->30|65->36|65->36|72->43|72->43|73->44|73->44|78->49|78->49|78->49|94->65|94->65|95->66|95->66|101->72|101->72|101->72|116->87|116->87|126->97|126->97|132->103|133->104|151->122|151->122|151->122|157->128|157->128|157->128|158->129|158->129|158->129|180->151|180->151|180->151|183->154|183->154|183->154|184->155|184->155|184->155|185->156|185->156|185->156|186->157|186->157|186->157|186->157|186->157|186->157|187->158|187->158|187->158|188->159|188->159|188->159|189->160|189->160|189->160|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|191->162|191->162|191->162|192->163|193->164|194->165|195->166|197->168|197->168|197->168|198->169|198->169|198->169|198->169|201->172|201->172|201->172|201->172|201->172|202->173|202->173|202->173|202->173|202->173|203->174|203->174|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|206->177|206->177|206->177|206->177|206->177|207->178|207->178|207->178|208->179|208->179|208->179|209->180|209->180|209->180|209->180|209->180|209->180|210->181|210->181|210->181|210->181|210->181|210->181|211->182|211->182|211->182|211->182|211->182|211->182|212->183|212->183|212->183|212->183|212->183|212->183|215->186|215->186|215->186|216->187|216->187|216->187|218->189|218->189|218->189|219->190|219->190|219->190|221->192|221->192|221->192|223->194|223->194|223->194|225->196|225->196|225->196|226->197|226->197|226->197|228->199|228->199|228->199|229->200|229->200|230->201|230->201|231->202|231->202|231->202|234->205|234->205|234->205|235->206|235->206|235->206|236->207|236->207|236->207|239->210|240->211|241->212|242->213|243->214|244->215|245->216|248->219|262->233|262->233|262->233|264->235|267->238|267->238|271->242|271->242|276->247|276->247|280->251|280->251|282->253|282->253|284->255|284->255|286->257|286->257|288->259|288->259|290->261|290->261|294->265|294->265|297->268|297->268|304->275|304->275|305->276|305->276|307->278|307->278|308->279|308->279|309->280|309->280|311->282|311->282|312->283|312->283|313->284|313->284|315->286|315->286|316->287|316->287|317->288|317->288|318->289|318->289|321->292|321->292|332->303|332->303|337->308|337->308|339->310|339->310|347->318|347->318|347->318|347->318|349->320|349->320|355->326|355->326|363->334|363->334|365->336|365->336|366->337|366->337|369->340|369->340|370->341|370->341|371->342|371->342|377->348|377->348|385->356|385->356|390->361|390->361|392->363|392->363|396->367|396->367|396->367|396->367|401->372|401->372|405->376|405->376|407->378|407->378|409->380|409->380|410->381|410->381|413->384|413->384|417->388|417->388|421->392|421->392|421->392|421->392|427->398|427->398|431->402|431->402|433->404|433->404|435->406|435->406|440->411|440->411|442->413|442->413|446->417|446->417|448->419|448->419|450->421|450->421|456->427|456->427|461->432|461->432|469->440|469->440|470->441|470->441|476->447|476->447|478->449|478->449|479->450|479->450|481->452|481->452|483->454|483->454|484->455|484->455|490->461|490->461|492->463|492->463|493->464|493->464|495->466|495->466|496->467|496->467
                    -- GENERATED --
                */
            