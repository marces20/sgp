
package views.html.contabilidad.balanceCuentaPropia

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
object indexBalanceCuentaPropia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[BalanceCuentaPropia],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[BalanceCuentaPropia], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import java.math.BigDecimal;var debito=new java.math.BigDecimal(0);var deposito=new java.math.BigDecimal(0);

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/balanceCuentaPropia.js"))),format.raw/*7.83*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 24){
		classEstado = "borrador"
	}else if(i != null && i.id == 26){
		classEstado = "cancelada"
	}else if(i != null && (i.id == 23)){
		classEstado = "autorizado"
	}else if(i != null && i.id == 25){
		classEstado = "pagado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.contabilidad.mainContabilidad("Balances Cuentas Propias",scripts)/*25.78*/ {_display_(Seq[Any](format.raw/*25.80*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Balance Cuentas Propia</h1>
		</div>

		<div class="col-sm-5">
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
			  		<a id="generarArchivo" href=""""),_display_(Seq[Any](/*41.38*/controllers/*41.49*/.contabilidad.routes.BalanceCuentaPropiaController.archivoIndex())),format.raw/*41.114*/("""">Generar archivo</a>
				</li>
			  </ul>
			</div>
			
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Acciones
			    <span class="caret"></span>
			 </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	"""),_display_(Seq[Any](/*53.8*/if(Permiso.check("agregarMovimientoBalanceCuentaPropia"))/*53.65*/ {_display_(Seq[Any](format.raw/*53.67*/("""
				<li role="presentation">
			  		<a role="menuitem" id="accionAgregarMovimientoBalanceCuentaPropia" tabindex="-1" href="#" 
			    	   data-url=""""),_display_(Seq[Any](/*56.23*/controllers/*56.34*/.contabilidad.routes.BalanceCuentaPropiaController.modalAgregarMovimientoBalanceCuentaPropia())),format.raw/*56.128*/("""">
			    						   Agregar movimiento a cuenta</a>
			 	</li>
			 	""")))})),format.raw/*59.7*/("""
			 	"""),_display_(Seq[Any](/*60.7*/if(Permiso.check("transferenciaEntreCuentasPropias"))/*60.60*/ {_display_(Seq[Any](format.raw/*60.62*/("""
				<li role="presentation">
			  		<a role="menuitem" id="accionTransferenciaEntreCuentasPropias" tabindex="-1" href="#" 
			    	   data-url=""""),_display_(Seq[Any](/*63.23*/controllers/*63.34*/.contabilidad.routes.BalanceCuentaPropiaController.modalTransferenciaEntreCuentasPropias())),format.raw/*63.124*/("""">
			    						   Transferencias entre cuentas</a>
			 	</li>
			 	""")))})),format.raw/*66.7*/("""
			 	
			 	
			 </ul>
			</div>
		</div>
	</div>
	<div id="actions">
		<form action="" id="formSearchBalanceCuentaPropia" method="GET">
			<div class="row">
				<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
					<div class="btn-group">
					  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>En Curso
					  	"""),_display_(Seq[Any](/*80.10*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*80.69*/("""
					  </button>
					  <button type="button" rel="entregado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-usd glyphicon-usd-green"></i><br>Pagado
					  	"""),_display_(Seq[Any](/*84.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*84.69*/("""
					  </button>
					  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-ok"></i><br>Conciliado
					  	"""),_display_(Seq[Any](/*88.10*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*88.69*/("""
					  </button>
					  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
					  	"""),_display_(Seq[Any](/*92.10*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*92.69*/("""
					  </button>
					</div>
				</div>
			</div>
			<div class="row" >
			
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Referencia
						"""),_display_(Seq[Any](/*102.8*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*102.71*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">N° Cheque
						"""),_display_(Seq[Any](/*109.8*/inputText(formBuscador("numero_cheque"), 'class -> "form-control"))),format.raw/*109.74*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Cuenta
					"""),_display_(Seq[Any](/*115.7*/select(formBuscador("cuenta_propia_id"),
					CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select"))),format.raw/*116.100*/(""" 	
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*122.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*122.112*/("""
						"""),_display_(Seq[Any](/*123.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*123.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*128.22*/controllers/*128.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*128.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label">Contraparte
						<div class="input-group">
							"""),_display_(Seq[Any](/*142.9*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*142.111*/("""
							"""),_display_(Seq[Any](/*143.9*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*143.92*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*148.23*/controllers/*148.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*148.85*/("""" 
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
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*163.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*163.98*/("""
						"""),_display_(Seq[Any](/*164.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*164.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOrdenPago" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*169.22*/controllers/*169.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*169.90*/("""" 
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
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha</label>
					<div>
						"""),_display_(Seq[Any](/*188.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*188.136*/("""
						"""),_display_(Seq[Any](/*189.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*189.136*/("""
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Debito</label>
					<div>
						"""),_display_(Seq[Any](/*195.8*/inputText(formBuscador("fecha_debito_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_debito_desde", 'placeholder -> "Desde"))),format.raw/*195.150*/("""
						"""),_display_(Seq[Any](/*196.8*/inputText(formBuscador("fecha_debito_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_debito_hasta", 'placeholder -> "Hasta"))),format.raw/*196.150*/("""
					</div>
				</div>
				<div class="col-sm-1">
					<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*201.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select" ))),format.raw/*202.39*/("""
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
					<a href=""""),_display_(Seq[Any](/*214.16*/controllers/*214.27*/.contabilidad.routes.BalanceCuentaPropiaController.index())),format.raw/*214.85*/("""?cuenta_propia_id=2"  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
	"""),_display_(Seq[Any](/*223.3*/if(buscador.getTotalRowCount == 0)/*223.37*/ {_display_(Seq[Any](format.raw/*223.39*/("""
        
        <div class="well">
            <em>No se encuentran Lineas</em>
        </div>
        
    """)))}/*229.7*/else/*229.12*/{_display_(Seq[Any](format.raw/*229.13*/("""
		Mostrando """),_display_(Seq[Any](/*230.14*/buscador/*230.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*230.54*/(""" resultado(s). 
		
		<table id="listaBalanceCuentaPropia" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Cuenta</th>
					<th>Fecha Emision</th>
					<th>Fecha</th>
					<th>Fecha Debito</th>
					<th>Fecha Cancelado</th>
					<th>Orden pago</th>
					<th>Exp.</th>
					<!-- <th>Monto OP</th> -->
					<th>Cheque/Trasf.</th>
					<th>REF N°</th>
					<th>a la Orden</th>
					
					<th>Debito</th>
					<th>Deposito</th>
					<th>Estado</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*254.5*/for(bcp <- buscador.getList) yield /*254.33*/ {_display_(Seq[Any](format.raw/*254.35*/("""
				<tr class=" """),_display_(Seq[Any](/*255.18*/getClassEstado(bcp.estado))),format.raw/*255.44*/("""" data-estado="" data-href="">
					<td>"""),_display_(Seq[Any](/*256.11*/if(bcp.cuentaPropia != null)/*256.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*256.42*/bcp/*256.45*/.cuentaPropia.nombre))))})),format.raw/*256.66*/(""" -"""),_display_(Seq[Any](/*256.69*/bcp/*256.72*/.id)),format.raw/*256.75*/(""" </td>
					<td class="fecha">"""),_display_(Seq[Any](/*257.25*/if(bcp.fecha_emision != null)/*257.54*/{_display_(Seq[Any](_display_(Seq[Any](/*257.56*/(utils.DateUtils.formatDate(bcp.fecha_emision))))))}/*257.104*/else/*257.108*/{_display_(Seq[Any](_display_(Seq[Any](/*257.110*/if(bcp.fecha != null)/*257.131*/{_display_(Seq[Any](_display_(Seq[Any](/*257.133*/(utils.DateUtils.formatDate(bcp.fecha))))))}))))})),format.raw/*257.174*/("""</td>
					<td class="fecha">"""),_display_(Seq[Any](/*258.25*/if(bcp.fecha != null)/*258.46*/{_display_(Seq[Any](_display_(Seq[Any](/*258.48*/(utils.DateUtils.formatDate(bcp.fecha))))))})),format.raw/*258.88*/("""</td>
					<td class="fecha">"""),_display_(Seq[Any](/*259.25*/if(bcp.fecha_debito != null)/*259.53*/{_display_(Seq[Any](_display_(Seq[Any](/*259.55*/(utils.DateUtils.formatDate(bcp.fecha_debito))))))})),format.raw/*259.102*/("""</td>
					<td class="fecha">"""),_display_(Seq[Any](/*260.25*/if(bcp.fecha_cancelado != null)/*260.56*/{_display_(Seq[Any](_display_(Seq[Any](/*260.58*/(utils.DateUtils.formatDate(bcp.fecha_cancelado))))))})),format.raw/*260.108*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*262.8*/if(bcp.orden_pago_id != null)/*262.37*/{_display_(Seq[Any](format.raw/*262.38*/("""
							"""),_display_(Seq[Any](/*263.9*/bcp/*263.12*/.ordenPago.getNombreCompleto())),format.raw/*263.42*/("""
						""")))}/*264.8*/else/*264.12*/{_display_(Seq[Any](format.raw/*264.13*/("""
							<a href=""""),_display_(Seq[Any](/*265.18*/controllers/*265.29*/.contabilidad.routes.BalanceCuentaPropiaController.getOrdenes(bcp.id))),format.raw/*265.98*/("""" class="getOrdenes"><i class="glyphicon glyphicon-align-justify"></i></a>
						""")))})),format.raw/*266.8*/("""
					</td>
					<td>
						"""),_display_(Seq[Any](/*269.8*/if(bcp.expediente_id != null)/*269.37*/{_display_(Seq[Any](format.raw/*269.38*/("""
							"""),_display_(Seq[Any](/*270.9*/bcp/*270.12*/.expediente.getExpedienteEjercicio())),format.raw/*270.48*/("""
						""")))}/*271.8*/else/*271.12*/{_display_(Seq[Any](format.raw/*271.13*/("""
						<a href=""""),_display_(Seq[Any](/*272.17*/controllers/*272.28*/.contabilidad.routes.BalanceCuentaPropiaController.getExpedientes(bcp.id))),format.raw/*272.101*/("""" class="getExpedientes"><i class="glyphicon glyphicon-align-justify"></i></a>
						""")))})),format.raw/*273.8*/("""
					</td>
					<td class="">"""),_display_(Seq[Any](/*275.20*/(bcp.numero_cheque))),format.raw/*275.39*/("""</td>
					<td class="referencia">"""),_display_(Seq[Any](/*276.30*/(bcp.referencia))),format.raw/*276.46*/("""</td>
					<td class="">"""),_display_(Seq[Any](/*277.20*/(bcp.a_la_orden))),format.raw/*277.36*/("""</td>
					
					<td class="">"""),_display_(Seq[Any](/*279.20*/(utils.NumberUtils.moneda(bcp.debito)))),format.raw/*279.58*/("""</td>
					<td class="">"""),_display_(Seq[Any](/*280.20*/(utils.NumberUtils.moneda(bcp.deposito)))),format.raw/*280.60*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*281.26*/(bcp.estado.nombre))),format.raw/*281.45*/("""</td>
					<td align="center" class="pointer">
						<a id="listaPagosBalance"  href="#" data-url=""""),_display_(Seq[Any](/*283.54*/controllers/*283.65*/.contabilidad.routes.BalanceCuentaPropiaController.listaPagos(bcp.id))),format.raw/*283.134*/(""""><i class="glyphicon glyphicon-list-alt"></i></a>
					</td>
				</tr>	
				"""),_display_(Seq[Any](/*286.6*/{debito = debito.add(bcp.debito)})),format.raw/*286.39*/("""   
				"""),_display_(Seq[Any](/*287.6*/{deposito = deposito.add(bcp.deposito)})),format.raw/*287.45*/("""   
			""")))})),format.raw/*288.5*/("""
			</tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="10">Mostrando """),_display_(Seq[Any](/*292.40*/buscador/*292.48*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*292.80*/(""" resultado(s).</td>
	        		<td><b>Total Debito:</b> <span class="totalFooter">"""),_display_(Seq[Any](/*293.64*/(utils.NumberUtils.moneda(debito)))),format.raw/*293.98*/("""</span></td>
	        		<td><b>Total Credito:</b> <span class="totalCreditoFooter">"""),_display_(Seq[Any](/*294.72*/(utils.NumberUtils.moneda(deposito)))),format.raw/*294.108*/("""</span></td>
	        		<td colspan="2"></td>
	        	</tr>
	        </tfoot>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*301.8*/views/*301.13*/.html.helpers.paginadorTodos(buscador, controllers.contabilidad.routes.BalanceCuentaPropiaController.index()))),format.raw/*301.122*/("""
		</div>
	""")))})),format.raw/*303.3*/("""
	</div>	
	</div>	
<script type="text/javascript">
	$( function() """),format.raw/*307.16*/("""{"""),format.raw/*307.17*/("""
		$('.getOrdenes').click( function() """),format.raw/*308.38*/("""{"""),format.raw/*308.39*/("""
			var $this = $(this);
			var url = $this.attr('href');
			$.get(url, function(data) """),format.raw/*311.30*/("""{"""),format.raw/*311.31*/("""
				$this.parent().html(data);
			"""),format.raw/*313.4*/("""}"""),format.raw/*313.5*/(""");
			return false;
		"""),format.raw/*315.3*/("""}"""),format.raw/*315.4*/(""");
		$('.getExpedientes').click( function() """),format.raw/*316.42*/("""{"""),format.raw/*316.43*/("""
			var $this = $(this);
			var url = $this.attr('href');
			$.get(url, function(data) """),format.raw/*319.30*/("""{"""),format.raw/*319.31*/("""
				$this.parent().html(data);
			"""),format.raw/*321.4*/("""}"""),format.raw/*321.5*/(""");
			return false;
		"""),format.raw/*323.3*/("""}"""),format.raw/*323.4*/(""");
		
		var baseUrl = $('#generarArchivo').attr('href')
		$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
		
	"""),format.raw/*328.2*/("""}"""),format.raw/*328.3*/(""");
	</script>	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[BalanceCuentaPropia],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[BalanceCuentaPropia],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balanceCuentaPropia/indexBalanceCuentaPropia.scala.html
                    HASH: edee8486e50e6a85b5900e4e8bb2d23df939268b
                    MATRIX: 880->1|1192->310|1206->317|1290->321|1341->337|1355->343|1437->404|1504->239|1536->263|1594->443|1617->457|1970->88|1998->307|2026->440|2055->780|2093->783|2106->788|2186->859|2226->861|2820->1419|2840->1430|2928->1495|3375->1907|3441->1964|3481->1966|3667->2116|3687->2127|3804->2221|3903->2289|3945->2296|4007->2349|4047->2351|4229->2497|4249->2508|4362->2598|4462->2667|4905->3074|4986->3133|5209->3320|5290->3379|5495->3548|5576->3607|5789->3784|5870->3843|6106->4043|6192->4106|6389->4267|6478->4333|6627->4446|6791->4586|6973->4732|7101->4836|7145->4844|7253->4929|7471->5110|7492->5121|7569->5175|8012->5582|8138->5684|8183->5693|8289->5776|8512->5962|8533->5973|8607->6024|9093->6474|9206->6564|9250->6572|9356->6655|9578->6840|9599->6851|9679->6908|10168->7361|10320->7489|10364->7497|10516->7625|10688->7761|10854->7903|10898->7911|11064->8053|11201->8154|11362->8292|11811->8704|11832->8715|11913->8773|12123->8947|12167->8981|12208->8983|12338->9095|12352->9100|12392->9101|12443->9115|12461->9123|12516->9155|13074->9677|13119->9705|13160->9707|13215->9725|13264->9751|13342->9792|13380->9820|13430->9823|13443->9826|13491->9847|13531->9850|13544->9853|13570->9856|13638->9887|13677->9916|13726->9918|13789->9966|13804->9970|13854->9972|13886->9993|13936->9995|14009->10036|14076->10066|14107->10087|14156->10089|14223->10129|14290->10159|14328->10187|14377->10189|14452->10236|14519->10266|14560->10297|14609->10299|14687->10349|14746->10372|14785->10401|14825->10402|14870->10411|14883->10414|14936->10444|14963->10452|14977->10456|15017->10457|15072->10475|15093->10486|15185->10555|15299->10637|15364->10666|15403->10695|15443->10696|15488->10705|15501->10708|15560->10744|15587->10752|15601->10756|15641->10757|15695->10774|15716->10785|15813->10858|15931->10944|15999->10975|16041->10994|16113->11029|16152->11045|16214->11070|16253->11086|16321->11117|16382->11155|16444->11180|16507->11220|16575->11251|16617->11270|16754->11370|16775->11381|16868->11450|16982->11528|17038->11561|17083->11570|17145->11609|17185->11617|17307->11702|17325->11710|17380->11742|17500->11825|17557->11859|17678->11943|17738->11979|17919->12124|17934->12129|18067->12238|18111->12250|18206->12316|18236->12317|18303->12355|18333->12356|18449->12443|18479->12444|18542->12479|18571->12480|18621->12502|18650->12503|18723->12547|18753->12548|18869->12635|18899->12636|18962->12671|18991->12672|19041->12694|19070->12695|19287->12884|19316->12885
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|51->1|52->5|53->8|55->23|57->25|57->25|57->25|57->25|73->41|73->41|73->41|85->53|85->53|85->53|88->56|88->56|88->56|91->59|92->60|92->60|92->60|95->63|95->63|95->63|98->66|112->80|112->80|116->84|116->84|120->88|120->88|124->92|124->92|134->102|134->102|141->109|141->109|147->115|148->116|154->122|154->122|155->123|155->123|160->128|160->128|160->128|174->142|174->142|175->143|175->143|180->148|180->148|180->148|195->163|195->163|196->164|196->164|201->169|201->169|201->169|220->188|220->188|221->189|221->189|227->195|227->195|228->196|228->196|233->201|234->202|246->214|246->214|246->214|255->223|255->223|255->223|261->229|261->229|261->229|262->230|262->230|262->230|286->254|286->254|286->254|287->255|287->255|288->256|288->256|288->256|288->256|288->256|288->256|288->256|288->256|289->257|289->257|289->257|289->257|289->257|289->257|289->257|289->257|289->257|290->258|290->258|290->258|290->258|291->259|291->259|291->259|291->259|292->260|292->260|292->260|292->260|294->262|294->262|294->262|295->263|295->263|295->263|296->264|296->264|296->264|297->265|297->265|297->265|298->266|301->269|301->269|301->269|302->270|302->270|302->270|303->271|303->271|303->271|304->272|304->272|304->272|305->273|307->275|307->275|308->276|308->276|309->277|309->277|311->279|311->279|312->280|312->280|313->281|313->281|315->283|315->283|315->283|318->286|318->286|319->287|319->287|320->288|324->292|324->292|324->292|325->293|325->293|326->294|326->294|333->301|333->301|333->301|335->303|339->307|339->307|340->308|340->308|343->311|343->311|345->313|345->313|347->315|347->315|348->316|348->316|351->319|351->319|353->321|353->321|355->323|355->323|360->328|360->328
                    -- GENERATED --
                */
            