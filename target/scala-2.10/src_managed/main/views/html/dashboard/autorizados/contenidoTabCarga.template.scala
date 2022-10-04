
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
object contenidoTabCarga extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],DynamicForm,Long,Autorizado,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada], formBuscador: DynamicForm,idAutorizado:Long,autorizado:Autorizado):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var resto_autorizar=new java.math.BigDecimal(0); 

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.162*/("""
"""),format.raw/*3.70*/("""
"""),format.raw/*5.1*/("""
<div class="row">
	<div class="col-sm-9">
		<h2>Carga de Autorizados por OP</h1>
	</div>
</div>
<div id="contenedorListadoDeudas" class="contenedorPaginador ajaxPaginador">
	<form action=""""),_display_(Seq[Any](/*12.17*/controllers/*12.28*/.dashboard.routes.AutorizadosController.getListadoDeudas())),format.raw/*12.86*/("""" method="GET" id="formCargaAutorizados">
		"""),_display_(Seq[Any](/*13.4*/inputText(formBuscador("idAutorizado"), 'hidden -> "hidden"))),format.raw/*13.64*/("""
		<div class="row seccion">
			
			<div class="col-sm-4">
				<label class="control-label">Proveedor
					<div class="input-group">	
						"""),_display_(Seq[Any](/*19.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*19.137*/("""
						"""),_display_(Seq[Any](/*20.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*20.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*25.22*/controllers/*25.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*25.84*/("""" 
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
						"""),_display_(Seq[Any](/*41.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*41.112*/("""
						"""),_display_(Seq[Any](/*42.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*42.93*/("""
						
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*48.22*/controllers/*48.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*48.87*/("""" 
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
				<label class="control-label">Ejercicio</label>
					"""),_display_(Seq[Any](/*63.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*63.166*/("""
				
			</div>	
			
		<div class="col-sm-2">
			<div class="seleccionOrdenRubro">
				<label for=""""),_display_(Seq[Any](/*69.18*/formBuscador("rubro_id")/*69.42*/.id)),format.raw/*69.45*/("""" class="control-label">Rubro</label>
				"""),_display_(Seq[Any](/*70.6*/select(formBuscador("rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*71.126*/("""
			</div>
		</div>

		<!-- <div class="col-sm-2">
			<label class="control-label"> 
				Cuenta
				"""),_display_(Seq[Any](/*78.6*/select(formBuscador("profe"),options(""->"","profe"->"PROFE","operativa"->"OPERATIVA"), 'class -> "form-control select"))),format.raw/*78.126*/("""
			</label>
		</div> --> 
		<div class="col-sm-2">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*84.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*85.126*/("""
			</label>
		</div>	
	</div>
	
	<div class="row">
		 
		<div class="col-sm-4">
			<label class="control-label">Institucion
				<div class="input-group">
					"""),_display_(Seq[Any](/*95.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*95.124*/("""
					"""),_display_(Seq[Any](/*96.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*96.87*/("""
					
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de Institucion" 
									data-url=""""),_display_(Seq[Any](/*102.21*/controllers/*102.32*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*102.84*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.deposito.simple" 
									data-label="#deposito_nombre" 
									data-field="#deposito_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>  
		<!-- <div class="col-sm-2">		
			<div class="form-group">
				<label for="mayor_a">Deuda entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*118.7*/inputText(formBuscador("deuda_mayor"), 'class -> "form-control", 'id -> "mayor_a", 'placeholder -> "Mayor a"))),format.raw/*118.116*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*120.10*/inputText(formBuscador("deuda_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*120.101*/("""
				</div>
			</div>
		</div> 	
				
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="pago_ma">Pago entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*129.7*/inputText(formBuscador("pago_mayor"), 'class -> "form-control", 'id -> "pago_ma", 'placeholder -> "Mayor a"))),format.raw/*129.115*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*131.10*/inputText(formBuscador("pago_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*131.100*/("""
				</div>
			</div>
		</div>			
				
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="compromiso_ma">Compromiso entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*140.7*/inputText(formBuscador("compromiso_mayor"), 'class -> "form-control", 'id -> "compromiso_ma", 'placeholder -> "Mayor a"))),format.raw/*140.127*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*142.10*/inputText(formBuscador("compromiso_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*142.106*/("""
				</div>
			</div>
		</div>		-->		
			
				
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<div id="loadingBtnBuscar" class="loading hide"></div>
			<button id="BtnBuscar" class="form-control btn btn-primary">Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			 
		</div>
			
		</div>
    </form>

	"""),_display_(Seq[Any](/*162.3*/if(buscador.getTotalRowCount == 0)/*162.37*/ {_display_(Seq[Any](format.raw/*162.39*/("""
		<div class="well">
		    <em>No se encuentran resultados</em>
		</div>
	""")))}/*166.4*/else/*166.9*/{_display_(Seq[Any](format.raw/*166.10*/("""
	    Mostrando """),_display_(Seq[Any](/*167.17*/buscador/*167.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*167.57*/(""" resultado(s). 
	    	
		<table class="table table-striped table-bordered table-hover" id="listaInforme">
			<thead>
				<tr>
					<th width="40">Orden</th>
					<th width="60">Expediente</th>
					<th width="30">Cuenta</th>
					<th width="130">Rubro</th>
					<th width="80">Inst.</th>
					<th>Proveedor</th>
					<th width="90">Orden</th>
					<th width="90">Autorizado</th>
					<th width="90">Pagado</th>
					<th width="90">Deuda</th>
					<th width="30">Compromiso</th>
					<th>Acta</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
	    		"""),_display_(Seq[Any](/*188.9*/for(informe <- buscador.getList) yield /*188.41*/ {_display_(Seq[Any](format.raw/*188.43*/("""
				<tr data-id=""""),_display_(Seq[Any](/*189.19*/informe/*189.26*/.id)),format.raw/*189.29*/("""" class="modalSeleccionIniciadorExpediente">
					<td>"""),_display_(Seq[Any](/*190.11*/informe/*190.18*/.numero_orden_provision)),format.raw/*190.41*/("""
						<br>"""),_display_(Seq[Any](/*191.12*/if(informe.tipo_moneda != null)/*191.43*/{_display_(Seq[Any](format.raw/*191.44*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*191.116*/("""

					</td>
					<td>"""),_display_(Seq[Any](/*194.11*/informe/*194.18*/.expediente)),format.raw/*194.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*195.11*/if(informe.tipoCuenta != null)/*195.41*/{_display_(Seq[Any](_display_(Seq[Any](/*195.43*/informe/*195.50*/.tipoCuenta.nombre))))})),format.raw/*195.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*196.11*/informe/*196.18*/.rubro)),format.raw/*196.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*197.11*/informe/*197.18*/.deposito.nombre)),format.raw/*197.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*198.11*/informe/*198.18*/.nombreProveedor)),format.raw/*198.34*/("""</td>
					<td class="totalOrden" data-valor=""""),_display_(Seq[Any](/*199.42*/informe/*199.49*/.totalOrden)),format.raw/*199.60*/("""">"""),_display_(Seq[Any](/*199.63*/utils/*199.68*/.NumberUtils.moneda(informe.totalOrden))),format.raw/*199.107*/("""</td>
					<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*200.47*/informe/*200.54*/.totalAutorizado)),format.raw/*200.70*/("""">"""),_display_(Seq[Any](/*200.73*/utils/*200.78*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*200.122*/("""</td>
					<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*201.43*/informe/*201.50*/.totalPagado)),format.raw/*201.62*/("""">"""),_display_(Seq[Any](/*201.65*/utils/*201.70*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*201.110*/("""</td>
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*202.42*/informe/*202.49*/.totalDeuda)),format.raw/*202.60*/("""">"""),_display_(Seq[Any](/*202.63*/utils/*202.68*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*202.107*/("""</td>
					<td class="totalCompromiso" data-valor=""""),_display_(Seq[Any](/*203.47*/informe/*203.54*/.totalCompromiso)),format.raw/*203.70*/("""">"""),_display_(Seq[Any](/*203.73*/utils/*203.78*/.NumberUtils.moneda(informe.totalCompromiso))),format.raw/*203.122*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*205.8*/if(informe.orden_provision_id != null)/*205.46*/ {_display_(Seq[Any](format.raw/*205.48*/("""
							<a href=""""),_display_(Seq[Any](/*206.18*/controllers/*206.29*/.dashboard.routes.InformeEstadisticoDeudaProveedoresController.getActas(informe.orden_provision_id))),format.raw/*206.128*/("""" class="actas">
							<i class="glyphicon glyphicon-align-justify"></i></a>
						""")))})),format.raw/*208.8*/(""" 
					</td>
					<td>
					
						 	
							"""),_display_(Seq[Any](/*213.9*/if(autorizado.estado.id ==  models.Estado.AUTORIZADO_ESTADO_BORRADOR && !Ejercicio.isPerimido(informe.ejercicio_id))/*213.125*/{_display_(Seq[Any](format.raw/*213.126*/("""
								"""),_display_(Seq[Any](/*214.10*/if(informe.orden_provision_id != null)/*214.48*/ {_display_(Seq[Any](format.raw/*214.50*/("""
									"""),_display_(Seq[Any](/*215.11*/{resto_autorizar= new java.math.BigDecimal(0)})),format.raw/*215.57*/("""
									"""),_display_(Seq[Any](/*216.11*/{resto_autorizar= informe.totalPagado.add(informe.totalDeuda).subtract(informe.totalAutorizado)})),format.raw/*216.107*/("""
									<a data-url=""""),_display_(Seq[Any](/*217.24*/controllers/*217.35*/.dashboard.routes.AutorizadosController.modalAgregarMontos(informe.orden_provision_id,idAutorizado,informe.ordenProvision.orden_compra_id,informe.tipo_cuenta_id))),format.raw/*217.196*/("""" href="#"  class="btn btn-default agregarMontos">
										<i class="glyphicon glyphicon-plus"></i>
									</a>
								""")))}/*220.10*/else/*220.14*/{_display_(Seq[Any](format.raw/*220.15*/("""
									<a data-url=""""),_display_(Seq[Any](/*221.24*/controllers/*221.35*/.dashboard.routes.AutorizadosController.modalAgregarMontosSinOp(idAutorizado,informe.orden_id,informe.tipo_cuenta_id))),format.raw/*221.152*/("""" href="#"  class="btn btn-default agregarMontos">
										<i class="glyphicon glyphicon-plus"></i>
									</a>
								""")))})),format.raw/*224.10*/("""
							""")))})),format.raw/*225.9*/("""
						 
					</td>
				</tr>    
			 	""")))})),format.raw/*229.7*/("""
	    	</tbody>
	    	<tfoot>
				<tr>
					<td colspan="6"></td>
					<td><b>Total:</b><br /><span id="ordenFooter"></span></td>
					<td><b>Total:</b><br /><span id="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span id="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span id="deudaFooter"></span></td>
					<td><b>Total:</b><br /><span id="compromisoFooter"></span></td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
	    </table>
    
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*245.8*/views/*245.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.AutorizadosController.getListadoDeudas()))),format.raw/*245.117*/("""
		</div>	
	""")))})),format.raw/*247.3*/("""
</div>	
<script>
$( function()"""),format.raw/*250.14*/("""{"""),format.raw/*250.15*/("""
	
	
	
	$('.agregarMontos').click( function() """),format.raw/*254.40*/("""{"""),format.raw/*254.41*/(""" //abrir modal para pasar en PreCurso
		var url = $(this).attr("data-url");
		var dialogo = $('<div id="modalAgregarMontos"></div>');
		dialogo.dialog("""),format.raw/*257.18*/("""{"""),format.raw/*257.19*/("""
			title: "Carga Autorizado",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 450,
			width:900,
	        /*buttons: """),format.raw/*264.21*/("""{"""),format.raw/*264.22*/("""
		          Cerrar: function() """),format.raw/*265.32*/("""{"""),format.raw/*265.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*267.13*/("""}"""),format.raw/*267.14*/("""
		    """),format.raw/*268.7*/("""}"""),format.raw/*268.8*/(""",*/
	    	close: function(event, ui )"""),format.raw/*269.34*/("""{"""),format.raw/*269.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*271.7*/("""}"""),format.raw/*271.8*/(""",
		    open: function( event, ui ) """),format.raw/*272.35*/("""{"""),format.raw/*272.36*/("""
				$.post(url, function(data)"""),format.raw/*273.31*/("""{"""),format.raw/*273.32*/("""
					dialogo.html(data);
				"""),format.raw/*275.5*/("""}"""),format.raw/*275.6*/(""");	
		    """),format.raw/*276.7*/("""}"""),format.raw/*276.8*/("""
	      """),format.raw/*277.8*/("""}"""),format.raw/*277.9*/(""");
	"""),format.raw/*278.2*/("""}"""),format.raw/*278.3*/(""");
	
	$('.searchModal').modalSearch();
	var contenedor = $("#contenedorListadoDeudas");
	/*var url = """"),_display_(Seq[Any](/*282.16*/controllers/*282.27*/.expediente.routes.IniciadorExpedientesController.get())),format.raw/*282.82*/(""""
	contenedor.find('.modalSeleccionIniciadorExpediente').on('click', function()"""),format.raw/*283.78*/("""{"""),format.raw/*283.79*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*285.38*/("""{"""),format.raw/*285.39*/("""
			$(document).trigger("modal.seleccion.iniciadorExpediente.simple", data);
		"""),format.raw/*287.3*/("""}"""),format.raw/*287.4*/(""");
	"""),format.raw/*288.2*/("""}"""),format.raw/*288.3*/(""");*/
	
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*292.49*/("""{"""),format.raw/*292.50*/("""
		
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$('#loadingBtnBuscar').removeClass('hide');
		$('#BtnBuscar').hide();
		$.get(url+"?"+query, function(data)"""),format.raw/*298.38*/("""{"""),format.raw/*298.39*/("""
			contenedor.parent().html(data);
			$('#loadingBtnBuscar').addClass('hide');
			$('#BtnBuscar').show();
		"""),format.raw/*302.3*/("""}"""),format.raw/*302.4*/(""");
		return false;
	"""),format.raw/*304.2*/("""}"""),format.raw/*304.3*/(""");
	
	$('.actas').click( function() """),format.raw/*306.32*/("""{"""),format.raw/*306.33*/("""
		var $this = $(this);
		var url = $this.attr('href');
		var oid = $(this).data('data-id-provision');
		$.get(url, function(data) """),format.raw/*310.29*/("""{"""),format.raw/*310.30*/("""
			$this.parent().html(data);
		"""),format.raw/*312.3*/("""}"""),format.raw/*312.4*/(""");
		return false;
	"""),format.raw/*314.2*/("""}"""),format.raw/*314.3*/(""");
	
	var trs = $('#listaInforme tbody tr');

	var orden = 0; var pagado = 0; var deuda = 0; var compromiso = 0;var autorizado = 0;
	
	trs.each( function() """),format.raw/*320.23*/("""{"""),format.raw/*320.24*/("""
		orden += Number($('.totalOrden',this).attr("data-valor"));
		autorizado += Number($('.totalAutorizado',this).attr("data-valor"));
		pagado += Number($('.totalPagado',this).attr("data-valor"));
		deuda += Number($('.totalDeuda',this).attr("data-valor"));
		compromiso += Number($('.totalCompromiso',this).attr("data-valor"));
	"""),format.raw/*326.2*/("""}"""),format.raw/*326.3*/(""");

	$("#ordenFooter").html(formatNumberPesos(parseFloat(orden).toFixed(2)));
	$("#autorizadoFooter").html(formatNumberPesos(parseFloat(autorizado).toFixed(2)));
	$("#pagadoFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
	$("#deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
	$("#compromisoFooter").html(formatNumberPesos(parseFloat(compromiso).toFixed(2)));
	
	if($("#proveedor").length)"""),format.raw/*334.28*/("""{"""),format.raw/*334.29*/("""
		var options = """),format.raw/*335.17*/("""{"""),format.raw/*335.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*341.30*/("""{"""),format.raw/*341.31*/(""" 
											$("#proveedor_id").val(obj.id); 
										 """),format.raw/*343.12*/("""}"""),format.raw/*343.13*/("""
			"""),format.raw/*344.4*/("""}"""),format.raw/*344.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor', options);
	"""),format.raw/*346.2*/("""}"""),format.raw/*346.3*/("""
	
	if($("#deposito_nombre").length)"""),format.raw/*348.34*/("""{"""),format.raw/*348.35*/("""
		var options = """),format.raw/*349.17*/("""{"""),format.raw/*349.18*/("""
				script:"/suggestDeposito/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*355.30*/("""{"""),format.raw/*355.31*/(""" 
											$("#deposito_id").val(obj.id); 
										 """),format.raw/*357.12*/("""}"""),format.raw/*357.13*/("""
			"""),format.raw/*358.4*/("""}"""),format.raw/*358.5*/(""";
		var as_json = new bsn.AutoSuggest('deposito_nombre', options);
	"""),format.raw/*360.2*/("""}"""),format.raw/*360.3*/("""
	
	if($("#expediente").length)"""),format.raw/*362.29*/("""{"""),format.raw/*362.30*/("""
		var options = """),format.raw/*363.17*/("""{"""),format.raw/*363.18*/("""
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*369.30*/("""{"""),format.raw/*369.31*/(""" 
											$("#expediente_id").val(obj.id); 
										 """),format.raw/*371.12*/("""}"""),format.raw/*371.13*/("""
			"""),format.raw/*372.4*/("""}"""),format.raw/*372.5*/(""";
		var as_json = new bsn.AutoSuggest('expediente', options);
	"""),format.raw/*374.2*/("""}"""),format.raw/*374.3*/("""
	
"""),format.raw/*376.1*/("""}"""),format.raw/*376.2*/(""");
</script>	
   """))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],formBuscador:DynamicForm,idAutorizado:Long,autorizado:Autorizado): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,idAutorizado,autorizado)
    
    def f:((utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],DynamicForm,Long,Autorizado) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,idAutorizado,autorizado) => apply(buscador,formBuscador,idAutorizado,autorizado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/contenidoTabCarga.scala.html
                    HASH: a418c8bd3ca4e1059f9154f4d19428567fe76712
                    MATRIX: 911->1|1252->180|1284->204|1359->161|1387->248|1414->328|1640->518|1660->529|1740->587|1820->632|1902->692|2078->833|2230->962|2273->970|2378->1053|2595->1234|2615->1245|2688->1296|3138->1711|3265->1815|3308->1823|3415->1908|3639->2096|3659->2107|3735->2161|4166->2557|4348->2716|4484->2816|4517->2840|4542->2843|4620->2886|4802->3045|4938->3146|5081->3266|5223->3373|5411->3538|5607->3699|5747->3816|5789->3823|5891->3903|6111->4086|6132->4097|6207->4149|6682->4588|6815->4697|6908->4753|7023->4844|7232->5017|7364->5125|7457->5181|7571->5271|7793->5457|7937->5577|8030->5633|8150->5729|8569->6112|8613->6146|8654->6148|8749->6225|8762->6230|8802->6231|8856->6248|8874->6256|8929->6288|9519->6842|9568->6874|9609->6876|9665->6895|9682->6902|9708->6905|9800->6960|9817->6967|9863->6990|9912->7002|9953->7033|9993->7034|10099->7106|10159->7129|10176->7136|10210->7147|10263->7163|10303->7193|10352->7195|10369->7202|10415->7221|10468->7237|10485->7244|10514->7250|10567->7266|10584->7273|10623->7289|10676->7305|10693->7312|10732->7328|10816->7375|10833->7382|10867->7393|10907->7396|10922->7401|10985->7440|11074->7492|11091->7499|11130->7515|11170->7518|11185->7523|11253->7567|11338->7615|11355->7622|11390->7634|11430->7637|11445->7642|11509->7682|11593->7729|11610->7736|11644->7747|11684->7750|11699->7755|11762->7794|11851->7846|11868->7853|11907->7869|11947->7872|11962->7877|12030->7921|12089->7944|12137->7982|12178->7984|12233->8002|12254->8013|12377->8112|12494->8197|12576->8243|12703->8359|12744->8360|12791->8370|12839->8408|12880->8410|12928->8421|12997->8467|13045->8478|13165->8574|13226->8598|13247->8609|13432->8770|13577->8895|13591->8899|13631->8900|13692->8924|13713->8935|13854->9052|14012->9177|14053->9186|14125->9226|14671->9736|14686->9741|14814->9845|14859->9858|14919->9889|14949->9890|15024->9936|15054->9937|15234->10088|15264->10089|15433->10229|15463->10230|15524->10262|15554->10263|15641->10321|15671->10322|15706->10329|15735->10330|15801->10367|15831->10368|15902->10411|15931->10412|15996->10448|16026->10449|16086->10480|16116->10481|16174->10511|16203->10512|16241->10522|16270->10523|16306->10531|16335->10532|16367->10536|16396->10537|16536->10640|16557->10651|16635->10706|16743->10785|16773->10786|16876->10860|16906->10861|17013->10940|17042->10941|17074->10945|17103->10946|17191->11005|17221->11006|17434->11190|17464->11191|17601->11300|17630->11301|17678->11321|17707->11322|17772->11358|17802->11359|17962->11490|17992->11491|18053->11524|18082->11525|18130->11545|18159->11546|18344->11702|18374->11703|18731->12032|18760->12033|19214->12458|19244->12459|19290->12476|19320->12477|19485->12613|19515->12614|19601->12671|19631->12672|19663->12676|19692->12677|19782->12739|19811->12740|19876->12776|19906->12777|19952->12794|19982->12795|20146->12930|20176->12931|20261->12987|20291->12988|20323->12992|20352->12993|20448->13061|20477->13062|20537->13093|20567->13094|20613->13111|20643->13112|20809->13249|20839->13250|20926->13308|20956->13309|20988->13313|21017->13314|21108->13377|21137->13378|21168->13381|21197->13382
                    LINES: 26->1|31->3|31->3|32->1|33->3|34->5|41->12|41->12|41->12|42->13|42->13|48->19|48->19|49->20|49->20|54->25|54->25|54->25|70->41|70->41|71->42|71->42|77->48|77->48|77->48|92->63|92->63|98->69|98->69|98->69|99->70|100->71|107->78|107->78|113->84|114->85|124->95|124->95|125->96|125->96|131->102|131->102|131->102|147->118|147->118|149->120|149->120|158->129|158->129|160->131|160->131|169->140|169->140|171->142|171->142|191->162|191->162|191->162|195->166|195->166|195->166|196->167|196->167|196->167|217->188|217->188|217->188|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|220->191|223->194|223->194|223->194|224->195|224->195|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|227->198|227->198|227->198|228->199|228->199|228->199|228->199|228->199|228->199|229->200|229->200|229->200|229->200|229->200|229->200|230->201|230->201|230->201|230->201|230->201|230->201|231->202|231->202|231->202|231->202|231->202|231->202|232->203|232->203|232->203|232->203|232->203|232->203|234->205|234->205|234->205|235->206|235->206|235->206|237->208|242->213|242->213|242->213|243->214|243->214|243->214|244->215|244->215|245->216|245->216|246->217|246->217|246->217|249->220|249->220|249->220|250->221|250->221|250->221|253->224|254->225|258->229|274->245|274->245|274->245|276->247|279->250|279->250|283->254|283->254|286->257|286->257|293->264|293->264|294->265|294->265|296->267|296->267|297->268|297->268|298->269|298->269|300->271|300->271|301->272|301->272|302->273|302->273|304->275|304->275|305->276|305->276|306->277|306->277|307->278|307->278|311->282|311->282|311->282|312->283|312->283|314->285|314->285|316->287|316->287|317->288|317->288|321->292|321->292|327->298|327->298|331->302|331->302|333->304|333->304|335->306|335->306|339->310|339->310|341->312|341->312|343->314|343->314|349->320|349->320|355->326|355->326|363->334|363->334|364->335|364->335|370->341|370->341|372->343|372->343|373->344|373->344|375->346|375->346|377->348|377->348|378->349|378->349|384->355|384->355|386->357|386->357|387->358|387->358|389->360|389->360|391->362|391->362|392->363|392->363|398->369|398->369|400->371|400->371|401->372|401->372|403->374|403->374|405->376|405->376
                    -- GENERATED --
                */
            