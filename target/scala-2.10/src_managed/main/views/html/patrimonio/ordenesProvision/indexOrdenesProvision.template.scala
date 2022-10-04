
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
object indexOrdenesProvision extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[OrdenProvision],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenProvision], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var ajuste=new java.math.BigDecimal(0);var recepcionado=new java.math.BigDecimal(0);var pendiente=new java.math.BigDecimal(0);var anulados=new java.math.BigDecimal(0);

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/patrimonio/ordenesProvision.js"))),format.raw/*8.78*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*11.2*/getPorcentajeEntregado/*11.24*/(orden:OrdenProvision) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(1)
	var totalRecepcionado:java.math.BigDecimal = new java.math.BigDecimal(0)
	var porcentaje:java.math.BigDecimal = new java.math.BigDecimal(0)
	var cien:java.math.BigDecimal = new java.math.BigDecimal(100)
	
	if(orden != null && orden.totales != null && orden.totales.totalOrden != null){
		if(orden.totales.totalOrden.compareTo(java.math.BigDecimal.ZERO) > 0){
			total = orden.totales.totalOrden
		}
	}
	
	if(orden != null && orden.totales.totalRecepcionado != null && orden.totales.totalRecepcionado.compareTo(java.math.BigDecimal.ZERO) != 0){
		totalRecepcionado = orden.totales.totalRecepcionado
	}
	
	porcentaje = (totalRecepcionado).multiply(cien).divide(total, 2)
	
	
	if(porcentaje.compareTo(cien) > 0) {
	
		 
	
	}
	
	porcentaje
	
}};def /*40.2*/getPediente/*40.13*/(orden:OrdenProvision) = {{
	
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	var totalRecepcionado:java.math.BigDecimal = new java.math.BigDecimal(0)
	var ret:java.math.BigDecimal = new java.math.BigDecimal(0)
	
	if(orden != null && orden.totales != null && orden.totales.totalOrden != null){
		total = orden.totales.totalOrden.setScale(2, java.math.RoundingMode.HALF_UP)
	}
	
	if(orden != null && orden.totales.totalRecepcionado != null){
		totalRecepcionado = orden.totales.totalRecepcionado
	}
	
	ret = total.subtract(totalRecepcionado)
	
	ret 
}};
Seq[Any](format.raw/*1.133*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*9.2*/("""

"""),format.raw/*38.2*/("""

"""),format.raw/*57.2*/("""



"""),_display_(Seq[Any](/*61.2*/views/*61.7*/.html.patrimonio.mainPatrimonio("Ordenes de provisión", scripts)/*61.71*/ {_display_(Seq[Any](format.raw/*61.73*/("""

<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
			
				<h1>Lista de Ordenes de provisión</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li><a id="reporteGeneralOp" href="#" data-url=""""),_display_(Seq[Any](/*76.56*/controllers/*76.67*/.patrimonio.routes.OrdenesProvisionReportesController.reporteGeneralOp())),format.raw/*76.139*/("""">Datos Generales</a></li>
						<li><a id="reporteListaLineasRemitos" href="#" data-url=""""),_display_(Seq[Any](/*77.65*/controllers/*77.76*/.patrimonio.routes.OrdenesProvisionReportesController.reporteListaLineasRemitos())),format.raw/*77.157*/("""">Datos Lineas Remitos</a></li>
						
					</ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i> Acciones<span class="caret"></span>
					</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">AcciÃ³n</a></li>
				  </ul>
				</div>

			</div>
	</div>
</div>	

"""),_display_(Seq[Any](/*95.2*/views/*95.7*/.html.tags.successError())),format.raw/*95.32*/("""
	<form action="" method="GET">
		<div class="row seccion">
			 
			<div class="col-sm-1">
				<div class="form-group">
					<label class="control-label">Numero
					"""),_display_(Seq[Any](/*102.7*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*102.93*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-2">
				<div class="form-group">
					<label class="control-label">Orden de compra
					"""),_display_(Seq[Any](/*110.7*/inputText(formBuscador("orden_compra"), 'class -> "form-control"))),format.raw/*110.72*/("""
					</label>
				</div>
			</div>
				 

			<div class="col-sm-2">
				<label class="control-label">Expediente
					<div class="input-group">
						"""),_display_(Seq[Any](/*119.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*119.93*/("""
						"""),_display_(Seq[Any](/*120.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*120.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="SelecciÃ³n de expediente" 
										data-url=""""),_display_(Seq[Any](/*125.22*/controllers/*125.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*125.87*/("""" 
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
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*141.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*141.91*/("""
						"""),_display_(Seq[Any](/*142.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*142.110*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="SelecciÃ³n de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*147.22*/controllers/*147.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*147.84*/("""" 
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
				<label for="deposito" class="control-label">Institución</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*162.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*162.124*/("""
					"""),_display_(Seq[Any](/*163.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*163.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="SelecciÃ³n de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*166.30*/controllers/*166.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*166.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div>
			<div class="col-sm-1">
				<label class="control-label">Ejercicio
				"""),_display_(Seq[Any](/*175.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*176.65*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Tipo Cuenta</label>
					"""),_display_(Seq[Any](/*181.7*/select(formBuscador("tipo_cuenta_id"), 
					TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*182.127*/("""
			</div>
		</div>	
		<div class="row">
			
			<div class="form-group col-sm-3">
				<label for="nombre" class="control-label">Con acta</label>
				<div>"""),_display_(Seq[Any](/*189.11*/inputRadioGroup(formBuscador("con_acta"), options = Seq("1"->"Completa","0"->"Incompleta", ""->"Ambos"), '_label -> "Gender"))),format.raw/*189.136*/("""</div>
			</div>	
			<div class="col-sm-2">
				<label class="control-label">Rubro
				"""),_display_(Seq[Any](/*193.6*/select(formBuscador("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*194.126*/("""
				 </label>
			</div>
			
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha OP</label>
				<div>
					"""),_display_(Seq[Any](/*201.7*/inputText(formBuscador("fecha_op_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_op_desde", 'placeholder -> "Desde"))),format.raw/*201.141*/("""
					"""),_display_(Seq[Any](/*202.7*/inputText(formBuscador("fecha_op_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_op_hasta", 'placeholder -> "Hasta"))),format.raw/*202.141*/("""
				</div>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Creacion</label>
				<div>
					"""),_display_(Seq[Any](/*208.7*/inputText(formBuscador("create_date_desde"), 'class -> "form-control inputDateMascara", 'id -> "create_date_desde", 'placeholder -> "Desde"))),format.raw/*208.147*/("""
					"""),_display_(Seq[Any](/*209.7*/inputText(formBuscador("create_date_hasta"), 'class -> "form-control inputDateMascara", 'id -> "create_date_hasta", 'placeholder -> "Hasta"))),format.raw/*209.147*/("""
				</div>
			</div>
			<div class="col-sm-3">
				<div class="col-sm-6">
					<div class="checkbox">
						<label class="control-label"> 
							Moneda Extrajera
							"""),_display_(Seq[Any](/*217.9*/checkbox(formBuscador("tipo_moneda")))),format.raw/*217.46*/("""
						</label> 
					</div> 
				</div>
				<div class="col-sm-6">
					<label class="control-label"> 
						Emergencia
						"""),_display_(Seq[Any](/*224.8*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*224.113*/("""
					</label>
				</div>
			</div>

		</div>	
		<div class="row">	
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button type="submit" class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*240.15*/controllers/*240.26*/.patrimonio.routes.OrdenesProvisionController.index())),format.raw/*240.79*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
	</form>
	
	
   """),_display_(Seq[Any](/*248.5*/if(buscador.getTotalRowCount == 0)/*248.39*/ {_display_(Seq[Any](format.raw/*248.41*/("""
        
        <div class="well">
            <em>No se encuentran Ordenes de provisión</em>
        </div>
        
    """)))}/*254.7*/else/*254.12*/{_display_(Seq[Any](format.raw/*254.13*/("""

		Mostrando """),_display_(Seq[Any](/*256.14*/buscador/*256.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*256.54*/(""" resultado(s).   
		<table id="listaOrdenProvision" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>Numero</th>
					<th>Expediente</th>
					<th>Institucion</th>
					<th>Rubro</th>
					<th>Valor</th>
					<th>Ajuste</th>
					<th>Recepcionado</th>
					<th>Pediente</th>
					<th>Entregado</th>
					<th>Anulados</th>
					<th>Proveedor</th>
					<th>Fecha Creacion</th>
					
				</tr>
			</thead>
			<tbody>
			
				"""),_display_(Seq[Any](/*281.6*/for(orden <- buscador.getList) yield /*281.36*/ {_display_(Seq[Any](format.raw/*281.38*/("""
			        """),_display_(Seq[Any](/*282.13*/paginadorFicha/*282.27*/.add(orden.id.toString))),format.raw/*282.50*/("""
					<tr class="pointer" data-href=""""),_display_(Seq[Any](/*283.38*/controllers/*283.49*/.patrimonio.routes.OrdenesProvisionController.ver(orden.id))),format.raw/*283.108*/("""&"""),_display_(Seq[Any](/*283.110*/UriTrack/*283.118*/.encode())),format.raw/*283.127*/("""">
						<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*284.65*/orden/*284.70*/.id)),format.raw/*284.73*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*284.107*/orden/*284.112*/.id)),format.raw/*284.115*/(""""/></td>
						<td>
							<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*286.62*/controllers/*286.73*/.patrimonio.routes.OrdenesProvisionController.editar(orden.id))),format.raw/*286.135*/("""&"""),_display_(Seq[Any](/*286.137*/UriTrack/*286.145*/.encode())),format.raw/*286.154*/("""">
								<i class="glyphicon glyphicon-edit"></i>
							</a>	
						</td>	
						<td>
							"""),_display_(Seq[Any](/*291.9*/(orden.numero))),format.raw/*291.23*/("""<br>"""),_display_(Seq[Any](/*291.28*/if(orden.ordenCompra.tipo_moneda != null)/*291.69*/{_display_(Seq[Any](format.raw/*291.70*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*291.142*/("""
							<br>"""),_display_(Seq[Any](/*292.13*/if(orden.ordenCompra.expediente != null)/*292.53*/{_display_(Seq[Any](format.raw/*292.54*/("""
									"""),_display_(Seq[Any](/*293.11*/if(orden.ordenCompra.expediente.emergencia)/*293.54*/{_display_(Seq[Any](format.raw/*293.55*/("""
										<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
									""")))})),format.raw/*295.11*/("""
								""")))})),format.raw/*296.10*/("""
						</td>
						<td>"""),_display_(Seq[Any](/*298.12*/orden/*298.17*/.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*298.65*/("""</td>
						<td>"""),_display_(Seq[Any](/*299.12*/(orden.ordenCompra.deposito.nombre))),format.raw/*299.47*/("""</td>
						<td>"""),_display_(Seq[Any](/*300.12*/(orden.ordenCompra.ordenRubro.nombre))),format.raw/*300.49*/("""</td>
						<td align="center" class="total" data-valor=""""),_display_(Seq[Any](/*301.53*/orden/*301.58*/.totales.totalOrden)),format.raw/*301.77*/("""">"""),_display_(Seq[Any](/*301.80*/utils/*301.85*/.NumberUtils.moneda(orden.totales.totalOrden))),format.raw/*301.130*/("""</td>
						<td align="center" class="ajuste" data-valor=""""),_display_(Seq[Any](/*302.54*/orden/*302.59*/.ordenCompra.getTotalAjuste())),format.raw/*302.88*/("""">"""),_display_(Seq[Any](/*302.91*/utils/*302.96*/.NumberUtils.moneda(orden.ordenCompra.getTotalAjuste()))),format.raw/*302.151*/("""</td>
						<td align="center" class="recepcionado" data-valor=""""),_display_(Seq[Any](/*303.60*/orden/*303.65*/.totales.totalRecepcionado)),format.raw/*303.91*/("""">"""),_display_(Seq[Any](/*303.94*/utils/*303.99*/.NumberUtils.moneda(orden.totales.totalRecepcionado))),format.raw/*303.151*/("""</td>
						
						<td align="center" class="pendiente" data-valor=""""),_display_(Seq[Any](/*305.57*/getPediente(orden))),format.raw/*305.75*/("""">"""),_display_(Seq[Any](/*305.78*/utils/*305.83*/.NumberUtils.moneda(getPediente(orden)))),format.raw/*305.122*/("""</td>
						
						<td align="center">"""),_display_(Seq[Any](/*307.27*/getPorcentajeEntregado(orden))),format.raw/*307.56*/(""" %</td>
						<td align="center" class="anulados" data-valor=""""),_display_(Seq[Any](/*308.56*/orden/*308.61*/.anulados)),format.raw/*308.70*/("""">"""),_display_(Seq[Any](/*308.73*/utils/*308.78*/.NumberUtils.moneda(orden.getAnulados()))),format.raw/*308.118*/("""</td>
						<td>"""),_display_(Seq[Any](/*309.12*/orden/*309.17*/.ordenCompra.proveedor.nombre)),format.raw/*309.46*/("""</td>
						<td>"""),_display_(Seq[Any](/*310.12*/(DateUtils.formatDate(orden.create_date)))),format.raw/*310.53*/("""</td>
						
					</tr>
					"""),_display_(Seq[Any](/*313.7*/{total = total.add(orden.totales.totalOrden)})),format.raw/*313.52*/("""
					"""),_display_(Seq[Any](/*314.7*/{ajuste = ajuste.add(orden.ordenCompra.getTotalAjuste())})),format.raw/*314.64*/("""
					"""),_display_(Seq[Any](/*315.7*/{recepcionado = recepcionado.add(orden.totales.totalRecepcionado)})),format.raw/*315.73*/("""
					"""),_display_(Seq[Any](/*316.7*/{pendiente = pendiente.add(getPediente(orden))})),format.raw/*316.54*/("""
					"""),_display_(Seq[Any](/*317.7*/{anulados = anulados.add(orden.getAnulados())})),format.raw/*317.53*/("""
				""")))})),format.raw/*318.6*/("""
              	"""),_display_(Seq[Any](/*319.17*/paginadorFicha/*319.31*/.guardar())),format.raw/*319.41*/("""
			</tbody>
			<tfoot>
				<td colspan="5"></td>
				<td align="right">TOTALES:</td>
				<td align="center" class="totalfooter">"""),_display_(Seq[Any](/*324.45*/utils/*324.50*/.NumberUtils.moneda(total))),format.raw/*324.76*/("""</td>
				<td align="center" class="ajustefooter">"""),_display_(Seq[Any](/*325.46*/utils/*325.51*/.NumberUtils.moneda(ajuste))),format.raw/*325.78*/("""</td>
				<td align="center" class="recepcionadofooter">"""),_display_(Seq[Any](/*326.52*/utils/*326.57*/.NumberUtils.moneda(recepcionado))),format.raw/*326.90*/("""</td>
				<td align="center" class="pendientefooter">"""),_display_(Seq[Any](/*327.49*/utils/*327.54*/.NumberUtils.moneda(pendiente))),format.raw/*327.84*/("""</td>
				<td></td>
				<td align="center" class=align="center" align="center" anuladosfooter">"""),_display_(Seq[Any](/*329.77*/utils/*329.82*/.NumberUtils.moneda(anulados))),format.raw/*329.111*/("""</td>
				<td colspan="2"></td>
			</tfoot>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*335.8*/views/*335.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.index()))),format.raw/*335.112*/("""
		</div>
	""")))})),format.raw/*337.3*/("""
""")))})),format.raw/*338.2*/("""

<script>
$( function() """),format.raw/*341.15*/("""{"""),format.raw/*341.16*/("""
	 
	

	var trs = $('#listaOrdenProvision tbody tr');
	
	$('#checkAll').click( function() """),format.raw/*347.35*/("""{"""),format.raw/*347.36*/("""
		sumarFilas(trs);
	"""),format.raw/*349.2*/("""}"""),format.raw/*349.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*351.55*/("""{"""),format.raw/*351.56*/("""
		sumarFilas( $('#listaOrdenProvision tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*353.2*/("""}"""),format.raw/*353.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*355.27*/("""{"""),format.raw/*355.28*/("""
		var total = 0;var ajuste = 0;var recepcionado = 0;var pendiente = 0;var anulados = 0;  
		
		trs.each( function() """),format.raw/*358.24*/("""{"""),format.raw/*358.25*/("""
			total += Number($('.total',this).attr("data-valor"));
			ajuste += Number($('.ajuste',this).attr("data-valor"));
			recepcionado += Number($('.recepcionado',this).attr("data-valor"));
			pendiente += Number($('.pendiente',this).attr("data-valor"));
			anulados += Number($('.anulados',this).attr("data-valor"));
		"""),format.raw/*364.3*/("""}"""),format.raw/*364.4*/(""");
		
		
		$(".totalfooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
		$(".ajustefooter").html(formatNumberPesos(parseFloat(ajuste).toFixed(2)));
		$(".recepcionadofooter").html(formatNumberPesos(parseFloat(recepcionado).toFixed(2)));
		$(".pendientefooter").html(formatNumberPesos(parseFloat(pendiente).toFixed(2)));
		$(".anuladosfooter").html(formatNumberPesos(parseFloat(anulados).toFixed(2)));
	"""),format.raw/*372.2*/("""}"""),format.raw/*372.3*/("""
"""),format.raw/*373.1*/("""}"""),format.raw/*373.2*/(""")

</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenProvision],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[OrdenProvision],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/indexOrdenesProvision.scala.html
                    HASH: 880aeeffb66173140ba257c8835d3b71c95f2a77
                    MATRIX: 899->1|1400->501|1414->508|1498->512|1550->529|1564->535|1641->591|1709->193|1741->217|1799->633|1830->655|2701->1517|2721->1528|3334->132|3363->261|3392->628|3423->1512|3454->2110|3498->2119|3511->2124|3584->2188|3624->2190|4218->2748|4238->2759|4333->2831|4461->2923|4481->2934|4585->3015|5196->3591|5209->3596|5256->3621|5466->3795|5575->3881|5770->4040|5858->4105|6054->4265|6162->4350|6207->4359|6335->4463|6559->4650|6580->4661|6657->4715|7125->5147|7231->5230|7276->5239|7402->5341|7626->5528|7647->5539|7721->5590|8206->6039|8347->6156|8391->6164|8494->6244|8692->6405|8713->6416|8788->6468|9199->6843|9387->7008|9537->7122|9728->7289|9927->7451|10076->7576|10204->7668|10394->7834|10570->7974|10728->8108|10772->8116|10930->8250|11104->8388|11268->8528|11312->8536|11476->8676|11692->8856|11752->8893|11923->9028|12052->9133|12562->9606|12583->9617|12659->9670|12806->9781|12850->9815|12891->9817|13041->9949|13055->9954|13095->9955|13149->9972|13167->9980|13222->10012|13862->10616|13909->10646|13950->10648|14001->10662|14025->10676|14071->10699|14147->10738|14168->10749|14251->10808|14291->10810|14310->10818|14343->10827|14448->10895|14463->10900|14489->10903|14561->10937|14577->10942|14604->10945|14724->11028|14745->11039|14831->11101|14871->11103|14890->11111|14923->11120|15061->11222|15098->11236|15140->11241|15191->11282|15231->11283|15337->11355|15388->11369|15438->11409|15478->11410|15527->11422|15580->11465|15620->11466|15753->11566|15797->11577|15860->11603|15875->11608|15946->11656|16001->11674|16059->11709|16114->11727|16174->11764|16270->11823|16285->11828|16327->11847|16367->11850|16382->11855|16451->11900|16548->11960|16563->11965|16615->11994|16655->11997|16670->12002|16749->12057|16852->12123|16867->12128|16916->12154|16956->12157|16971->12162|17047->12214|17155->12285|17196->12303|17236->12306|17251->12311|17314->12350|17392->12391|17444->12420|17545->12484|17560->12489|17592->12498|17632->12501|17647->12506|17711->12546|17766->12564|17781->12569|17833->12598|17888->12616|17952->12657|18021->12690|18089->12735|18133->12743|18213->12800|18257->12808|18346->12874|18390->12882|18460->12929|18504->12937|18573->12983|18612->12990|18667->13008|18691->13022|18724->13032|18896->13167|18911->13172|18960->13198|19049->13250|19064->13255|19114->13282|19209->13340|19224->13345|19280->13378|19372->13433|19387->13438|19440->13468|19575->13566|19590->13571|19643->13600|19788->13709|19803->13714|19926->13813|19972->13827|20007->13830|20064->13858|20094->13859|20219->13955|20249->13956|20300->13979|20329->13980|20419->14041|20449->14042|20566->14131|20595->14132|20657->14165|20687->14166|20836->14286|20866->14287|21218->14611|21247->14612|21698->15035|21727->15036|21757->15038|21786->15039
                    LINES: 26->1|35->7|35->7|37->7|38->8|38->8|38->8|39->5|39->5|39->11|39->11|66->40|66->40|84->1|85->5|86->9|88->38|90->57|94->61|94->61|94->61|94->61|109->76|109->76|109->76|110->77|110->77|110->77|128->95|128->95|128->95|135->102|135->102|143->110|143->110|152->119|152->119|153->120|153->120|158->125|158->125|158->125|174->141|174->141|175->142|175->142|180->147|180->147|180->147|195->162|195->162|196->163|196->163|199->166|199->166|199->166|208->175|209->176|214->181|215->182|222->189|222->189|226->193|227->194|234->201|234->201|235->202|235->202|241->208|241->208|242->209|242->209|250->217|250->217|257->224|257->224|273->240|273->240|273->240|281->248|281->248|281->248|287->254|287->254|287->254|289->256|289->256|289->256|314->281|314->281|314->281|315->282|315->282|315->282|316->283|316->283|316->283|316->283|316->283|316->283|317->284|317->284|317->284|317->284|317->284|317->284|319->286|319->286|319->286|319->286|319->286|319->286|324->291|324->291|324->291|324->291|324->291|324->291|325->292|325->292|325->292|326->293|326->293|326->293|328->295|329->296|331->298|331->298|331->298|332->299|332->299|333->300|333->300|334->301|334->301|334->301|334->301|334->301|334->301|335->302|335->302|335->302|335->302|335->302|335->302|336->303|336->303|336->303|336->303|336->303|336->303|338->305|338->305|338->305|338->305|338->305|340->307|340->307|341->308|341->308|341->308|341->308|341->308|341->308|342->309|342->309|342->309|343->310|343->310|346->313|346->313|347->314|347->314|348->315|348->315|349->316|349->316|350->317|350->317|351->318|352->319|352->319|352->319|357->324|357->324|357->324|358->325|358->325|358->325|359->326|359->326|359->326|360->327|360->327|360->327|362->329|362->329|362->329|368->335|368->335|368->335|370->337|371->338|374->341|374->341|380->347|380->347|382->349|382->349|384->351|384->351|386->353|386->353|388->355|388->355|391->358|391->358|397->364|397->364|405->372|405->372|406->373|406->373
                    -- GENERATED --
                */
            