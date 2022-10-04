
package views.html.recupero.recuperoFactura

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
object indexRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.RecuperoFactura],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.RecuperoFactura], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/recupero/recuperoFactura.js"))),format.raw/*7.75*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 65){
		classEstado = "borrador"
	}else if(i != null && i.id == 68){
		classEstado = "cancelada"
	}else if(i != null && i.id == 67){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.recupero.mainRecupero("Lista de Facturas", scripts)/*23.64*/ {_display_(Seq[Any](format.raw/*23.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de facturas</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="reporteRecuperoFacturaExcel" href="#" data-url=""""),_display_(Seq[Any](/*38.68*/controllers/*38.79*/.recupero.routes.RecuperoReportesController.reporteFacturasExcel())),format.raw/*38.145*/("""">Reporte Excel</a></li>
				  			   
				  	<li><a id="reportePlanilla" href="#" data-url=""""),_display_(Seq[Any](/*40.56*/controllers/*40.67*/.recupero.routes.RecuperoReportesController.modalPlanilla())),format.raw/*40.126*/("""">Planilla Diaria</a></li>
				  			   	
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*57.16*/controllers/*57.27*/.recupero.routes.RecuperoFacturasController.crear())),format.raw/*57.78*/("""?"""),_display_(Seq[Any](/*57.80*/UriTrack/*57.88*/.encode())),format.raw/*57.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Factura</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*63.3*/views/*63.8*/.html.tags.successError())),format.raw/*63.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchRecuperoFacturas" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*71.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*71.67*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso 
				  	"""),_display_(Seq[Any](/*74.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*74.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Aprobado 
				  	"""),_display_(Seq[Any](/*77.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*77.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*80.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*80.68*/("""
				  </button>
				  <button type="button" rel="pagada" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-usd glyphicon-usd-green"></i><br>Pagada
				  	"""),_display_(Seq[Any](/*84.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*84.68*/("""
				  </button>
				</div>
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Nombre</label>
					<div class="">
					"""),_display_(Seq[Any](/*96.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*96.93*/("""
					</div>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Punto Venta</label>
				<div class="">
				"""),_display_(Seq[Any](/*103.6*/select(formBuscador("puntoventa_id"), 
				PuntoVenta.find.all().map { p => p.id.toString -> p.numero}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*104.126*/("""
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Numero</label>
					<div class="">
					"""),_display_(Seq[Any](/*111.7*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*111.93*/("""
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<label class="control-label">Cliente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*119.8*/inputText(formBuscador("cliente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cliente"))),format.raw/*119.106*/("""
						"""),_display_(Seq[Any](/*120.8*/inputText(formBuscador("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*120.87*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchCliente" 
										data-title="Selección de Clientes" 
										data-url=""""),_display_(Seq[Any](/*125.22*/controllers/*125.33*/.compras.routes.ClientesController.modalBuscar())),format.raw/*125.81*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.cliente.simple" 
										data-label="#cliente" 
										data-field="#cliente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				
			</div>

			
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha de factura</label>
				<div>
				"""),_display_(Seq[Any](/*142.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*142.137*/("""
				"""),_display_(Seq[Any](/*143.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*143.137*/("""
				</div>
				
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label for="planilla" class="control-label">Planilla</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*152.7*/inputText(formBuscador("planilla.recuperoPlanillaEjercicio"),'class -> "form-control", 'id -> "planilla"))),format.raw/*152.112*/("""
					"""),_display_(Seq[Any](/*153.7*/inputText(formBuscador("planilla_id"),'hidden -> "hidden", 'id -> "planilla_id"))),format.raw/*153.87*/("""
	
					<span class="input-group-addon">
					<a href="#" 
					id="searchPlanilla" data-title="Selección de Planilla" 
					data-url=""""),_display_(Seq[Any](/*158.17*/controllers/*158.28*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*158.86*/("""" 
					data-height="650" data-width="700" 
					data-listen="modal.seleccion.planilla.simple" 
					data-label="#planilla" 
					data-field="#planilla_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
			</div>
			<div class="col-sm-4">
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*169.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*169.124*/("""
					"""),_display_(Seq[Any](/*170.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*170.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*173.30*/controllers/*173.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*173.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
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
				<a href=""""),_display_(Seq[Any](/*189.15*/controllers/*189.26*/.recupero.routes.RecuperoFacturasController.index())),format.raw/*189.77*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*197.3*/if(buscador.getTotalRowCount == 0)/*197.37*/ {_display_(Seq[Any](format.raw/*197.39*/("""
        
        <div class="well">
            <em>No se encuentran Facturas</em>
        </div>
        
    """)))}/*203.7*/else/*203.12*/{_display_(Seq[Any](format.raw/*203.13*/("""
    	
		<table id="listaRecuperoFacturas" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="7">Mostrando """),_display_(Seq[Any](/*208.39*/buscador/*208.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*208.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="ncFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Nombre</th>
					<th width="80">Planilla</th>
					<th width="70">Fecha</th>
					<th width="300">Cliente</th>
					<th width="100">N° Factura</th>
					<th width="95">Base</th>
					<th width="95">N/C</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*230.5*/for(rf <- buscador.getList) yield /*230.32*/ {_display_(Seq[Any](format.raw/*230.34*/("""
				
				<tr class="pointer """),_display_(Seq[Any](/*232.25*/getClassEstado(rf.estado))),format.raw/*232.50*/("""" data-estado=""""),_display_(Seq[Any](/*232.66*/rf/*232.68*/.estado_id)),format.raw/*232.78*/("""" data-href=""""),_display_(Seq[Any](/*232.92*/controllers/*232.103*/.recupero.routes.RecuperoFacturasController.ver(rf.id))),format.raw/*232.157*/("""&"""),_display_(Seq[Any](/*232.159*/UriTrack/*232.167*/.encode())),format.raw/*232.176*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*233.64*/rf/*233.66*/.id)),format.raw/*233.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*233.103*/rf/*233.105*/.id)),format.raw/*233.108*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*234.64*/controllers/*234.75*/.recupero.routes.RecuperoFacturasController.editar(rf.id))),format.raw/*234.132*/("""&"""),_display_(Seq[Any](/*234.134*/UriTrack/*234.142*/.encode())),format.raw/*234.151*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*235.11*/(rf.nombre))),format.raw/*235.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*236.11*/if(rf.planilla != null)/*236.34*/{_display_(Seq[Any](_display_(Seq[Any](/*236.36*/rf/*236.38*/.planilla.getRecuperoPlanillaEjercicioDeposito()))))})),format.raw/*236.87*/("""</td>
					<td class="fechaRecuperoFactura">"""),_display_(Seq[Any](/*237.40*/if(rf.fecha != null)/*237.60*/{_display_(Seq[Any](_display_(Seq[Any](/*237.62*/(utils.DateUtils.formatDate(rf.fecha))))))})),format.raw/*237.101*/("""</td>
					<td>"""),_display_(Seq[Any](/*238.11*/if(rf.cliente != null)/*238.33*/{_display_(Seq[Any](_display_(Seq[Any](/*238.35*/(rf.cliente.nombre)))))})),format.raw/*238.55*/("""</td>
					<td>"""),_display_(Seq[Any](/*239.11*/if(rf.numero != null)/*239.32*/{_display_(Seq[Any](_display_(Seq[Any](/*239.34*/(rf.getNumeroFactura())))))})),format.raw/*239.58*/("""</td>
					<td class="base" rel=""""),_display_(Seq[Any](/*240.29*/rf/*240.31*/.getBase())),format.raw/*240.41*/("""">"""),_display_(Seq[Any](/*240.44*/(utils.NumberUtils.moneda(rf.getBase())))),format.raw/*240.84*/("""</td>
					<td class="nc" rel=""""),_display_(Seq[Any](/*241.27*/rf/*241.29*/.getTotalNotaCredito())),format.raw/*241.51*/("""">"""),_display_(Seq[Any](/*241.54*/(utils.NumberUtils.moneda(rf.getTotalNotaCredito())))),format.raw/*241.106*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*242.30*/rf/*242.32*/.getTotal())),format.raw/*242.43*/("""">"""),_display_(Seq[Any](/*242.46*/(utils.NumberUtils.moneda(rf.getTotal())))),format.raw/*242.87*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*243.26*/if(rf.estado != null)/*243.47*/{_display_(Seq[Any](format.raw/*243.48*/("""
					    """),_display_(Seq[Any](/*244.11*/(rf.estado.nombre))),format.raw/*244.29*/("""
						"""),_display_(Seq[Any](/*245.8*/if(rf.getPorcentajePagado().compareTo(java.math.BigDecimal.ZERO) != 0)/*245.78*/ {_display_(Seq[Any](format.raw/*245.80*/("""
							<br/>Pagado """),_display_(Seq[Any](/*246.21*/rf/*246.23*/.getPorcentajePagado())),format.raw/*246.45*/("""%
						""")))})),format.raw/*247.8*/("""					
					""")))})),format.raw/*248.7*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*250.81*/controllers/*250.92*/.recupero.routes.RecuperoFacturasController.eliminar(rf.id))),format.raw/*250.151*/("""&"""),_display_(Seq[Any](/*250.153*/UriTrack/*250.161*/.encode())),format.raw/*250.170*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*255.15*/("""
             
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="7">&nbsp</td>
			        <td><b>Total:</b> <span class="baseFooter"></span></td>
			        <td><b>Total:</b> <span class="ncFooter"></span></td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*270.8*/views/*270.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoFacturasController.index()))),format.raw/*270.110*/("""
		</div>
<script>
$( function ()"""),format.raw/*273.15*/("""{"""),format.raw/*273.16*/("""
	var n = 0;
	var nb = 0;
	var nc = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*279.36*/("""{"""),format.raw/*279.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*282.2*/("""}"""),format.raw/*282.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*285.35*/("""{"""),format.raw/*285.36*/("""
		
		nb = Number($(this).attr("rel"))+nb 
	"""),format.raw/*288.2*/("""}"""),format.raw/*288.3*/(""")
	$(".baseFooter").append(formatNumberPesos(parseFloat(nb).toFixed(2)));
	
	$(".nc").each(function (index) """),format.raw/*291.33*/("""{"""),format.raw/*291.34*/("""
		
		nc = Number($(this).attr("rel"))+nc 
	"""),format.raw/*294.2*/("""}"""),format.raw/*294.3*/(""")
	$(".ncFooter").append(formatNumberPesos(parseFloat(nc).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*297.36*/("""{"""),format.raw/*297.37*/("""
		
		  	selectAll();
	"""),format.raw/*300.2*/("""}"""),format.raw/*300.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*301.56*/("""{"""),format.raw/*301.57*/("""
		selectTrList();
	"""),format.raw/*303.2*/("""}"""),format.raw/*303.3*/(""");
"""),format.raw/*304.1*/("""}"""),format.raw/*304.2*/(""");

function selectTrList()"""),format.raw/*306.24*/("""{"""),format.raw/*306.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*310.36*/("""{"""),format.raw/*310.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*311.77*/("""{"""),format.raw/*311.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*313.3*/("""}"""),format.raw/*313.4*/("""
	"""),format.raw/*314.2*/("""}"""),format.raw/*314.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".base").each(function (index) """),format.raw/*318.35*/("""{"""),format.raw/*318.36*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*319.77*/("""{"""),format.raw/*319.78*/("""
			nb = Number($(this).attr("rel"))+nb 
		"""),format.raw/*321.3*/("""}"""),format.raw/*321.4*/("""
	"""),format.raw/*322.2*/("""}"""),format.raw/*322.3*/(""")
	$(".baseFooter").empty();
	$(".baseFooter").append(formatNumberPesos(parseFloat(nb).toFixed(2)));
	
	$(".nc").each(function (index) """),format.raw/*326.33*/("""{"""),format.raw/*326.34*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*327.77*/("""{"""),format.raw/*327.78*/("""
			nc = Number($(this).attr("rel"))+nc
		"""),format.raw/*329.3*/("""}"""),format.raw/*329.4*/("""
	"""),format.raw/*330.2*/("""}"""),format.raw/*330.3*/(""")
	$(".ncFooter").empty();
	$(".ncFooter").append(formatNumberPesos(parseFloat(nc).toFixed(2)));
"""),format.raw/*333.1*/("""}"""),format.raw/*333.2*/("""

function selectAll()"""),format.raw/*335.21*/("""{"""),format.raw/*335.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*339.36*/("""{"""),format.raw/*339.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*342.2*/("""}"""),format.raw/*342.3*/("""else"""),format.raw/*342.7*/("""{"""),format.raw/*342.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*344.2*/("""}"""),format.raw/*344.3*/("""
	
	$(".total").each(function (index) """),format.raw/*346.36*/("""{"""),format.raw/*346.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*348.2*/("""}"""),format.raw/*348.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*351.1*/("""}"""),format.raw/*351.2*/("""

</script>		
 	 """)))})),format.raw/*354.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.RecuperoFactura],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoFactura],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/indexRecuperoFactura.scala.html
                    HASH: 67bd03a5411af82092472ce676ff46d30d65e565
                    MATRIX: 880->1|1110->227|1124->234|1208->238|1259->254|1273->260|1347->313|1414->157|1446->181|1504->352|1527->366|1818->100|1846->225|1873->349|1902->626|1940->629|1953->634|2019->691|2059->693|2654->1252|2674->1263|2763->1329|2892->1422|2912->1433|2994->1492|3542->2004|3562->2015|3635->2066|3673->2068|3690->2076|3721->2085|3890->2219|3903->2224|3950->2249|4348->2612|4429->2671|4652->2859|4733->2918|4949->3099|5030->3158|5257->3350|5338->3409|5553->3589|5634->3648|5888->3867|5996->3953|6169->4090|6357->4254|6558->4419|6667->4505|6854->4656|6976->4754|7020->4762|7122->4841|7335->5017|7356->5028|7427->5076|7868->5481|8023->5612|8065->5618|8220->5749|8440->5933|8569->6038|8612->6045|8715->6125|8888->6261|8909->6272|8990->6330|9394->6698|9535->6815|9578->6822|9681->6902|9875->7059|9896->7070|9971->7122|10633->7747|10654->7758|10728->7809|10872->7917|10916->7951|10957->7953|11089->8067|11103->8072|11143->8073|11355->8248|11373->8256|11428->8288|12210->9034|12254->9061|12295->9063|12362->9093|12410->9118|12463->9134|12475->9136|12508->9146|12559->9160|12581->9171|12659->9225|12699->9227|12718->9235|12751->9244|12854->9310|12866->9312|12892->9315|12964->9349|12977->9351|13004->9354|13113->9426|13134->9437|13215->9494|13255->9496|13274->9504|13307->9513|13406->9575|13440->9586|13493->9602|13526->9625|13575->9627|13587->9629|13663->9678|13745->9723|13775->9743|13824->9745|13891->9784|13944->9800|13976->9822|14025->9824|14072->9844|14125->9860|14156->9881|14205->9883|14256->9907|14327->9941|14339->9943|14372->9953|14412->9956|14475->9996|14544->10028|14556->10030|14601->10052|14641->10055|14717->10107|14789->10142|14801->10144|14835->10155|14875->10158|14939->10199|15007->10230|15038->10251|15078->10252|15126->10263|15167->10281|15211->10289|15291->10359|15332->10361|15390->10382|15402->10384|15447->10406|15488->10415|15532->10427|15665->10523|15686->10534|15769->10593|15809->10595|15828->10603|15861->10612|16007->10725|16489->11171|16504->11176|16625->11273|16687->11306|16717->11307|16844->11405|16874->11406|16944->11448|16973->11449|17112->11559|17142->11560|17214->11604|17243->11605|17380->11713|17410->11714|17482->11758|17511->11759|17649->11868|17679->11869|17730->11892|17759->11893|17846->11951|17876->11952|17924->11972|17953->11973|17984->11976|18013->11977|18069->12004|18099->12005|18200->12077|18230->12078|18336->12155|18366->12156|18435->12197|18464->12198|18494->12200|18523->12201|18690->12339|18720->12340|18826->12417|18856->12418|18927->12461|18956->12462|18986->12464|19015->12465|19179->12600|19209->12601|19315->12678|19345->12679|19415->12721|19444->12722|19474->12724|19503->12725|19628->12822|19657->12823|19708->12845|19738->12846|19842->12921|19872->12922|19967->12989|19996->12990|20028->12994|20057->12995|20151->13061|20180->13062|20247->13100|20277->13101|20344->13140|20373->13141|20503->13243|20532->13244|20582->13262
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|70->38|70->38|70->38|72->40|72->40|72->40|89->57|89->57|89->57|89->57|89->57|89->57|95->63|95->63|95->63|103->71|103->71|106->74|106->74|109->77|109->77|112->80|112->80|116->84|116->84|128->96|128->96|135->103|136->104|143->111|143->111|151->119|151->119|152->120|152->120|157->125|157->125|157->125|174->142|174->142|175->143|175->143|184->152|184->152|185->153|185->153|190->158|190->158|190->158|201->169|201->169|202->170|202->170|205->173|205->173|205->173|221->189|221->189|221->189|229->197|229->197|229->197|235->203|235->203|235->203|240->208|240->208|240->208|262->230|262->230|262->230|264->232|264->232|264->232|264->232|264->232|264->232|264->232|264->232|264->232|264->232|264->232|265->233|265->233|265->233|265->233|265->233|265->233|266->234|266->234|266->234|266->234|266->234|266->234|267->235|267->235|268->236|268->236|268->236|268->236|268->236|269->237|269->237|269->237|269->237|270->238|270->238|270->238|270->238|271->239|271->239|271->239|271->239|272->240|272->240|272->240|272->240|272->240|273->241|273->241|273->241|273->241|273->241|274->242|274->242|274->242|274->242|274->242|275->243|275->243|275->243|276->244|276->244|277->245|277->245|277->245|278->246|278->246|278->246|279->247|280->248|282->250|282->250|282->250|282->250|282->250|282->250|287->255|302->270|302->270|302->270|305->273|305->273|311->279|311->279|314->282|314->282|317->285|317->285|320->288|320->288|323->291|323->291|326->294|326->294|329->297|329->297|332->300|332->300|333->301|333->301|335->303|335->303|336->304|336->304|338->306|338->306|342->310|342->310|343->311|343->311|345->313|345->313|346->314|346->314|350->318|350->318|351->319|351->319|353->321|353->321|354->322|354->322|358->326|358->326|359->327|359->327|361->329|361->329|362->330|362->330|365->333|365->333|367->335|367->335|371->339|371->339|374->342|374->342|374->342|374->342|376->344|376->344|378->346|378->346|380->348|380->348|383->351|383->351|386->354
                    -- GENERATED --
                */
            