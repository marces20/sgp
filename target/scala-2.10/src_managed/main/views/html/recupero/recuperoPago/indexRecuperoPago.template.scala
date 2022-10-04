
package views.html.recupero.recuperoPago

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
object indexRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.RecuperoPago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.RecuperoPago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/recupero/pago.js"))),format.raw/*7.64*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 69){
		classEstado = "borrador"
	}else if(i != null && i.id == 72){
		classEstado = "cancelada"
	}else if(i != null && i.id == 71){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.recupero.mainRecupero("Lista de Pagos", scripts)/*23.61*/ {_display_(Seq[Any](format.raw/*23.63*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Pagos</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="reporteRecuperoPagoExcel" href="#" data-url=""""),_display_(Seq[Any](/*38.65*/controllers/*38.76*/.recupero.routes.RecuperoReportesController.reportePagosExcel())),format.raw/*38.139*/("""">Reporte Excel</a></li>
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
					
				<!-- <div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*54.16*/controllers/*54.27*/.recupero.routes.RecuperoPagosController.crear())),format.raw/*54.75*/("""?"""),_display_(Seq[Any](/*54.77*/UriTrack/*54.85*/.encode())),format.raw/*54.94*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Pago</a>
				</div> -->
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*60.3*/views/*60.8*/.html.tags.successError())),format.raw/*60.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchRecuperoPagos" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*68.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*68.67*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso 
				  	"""),_display_(Seq[Any](/*71.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*71.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Aprobado 
				  	"""),_display_(Seq[Any](/*74.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*74.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*77.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*77.68*/("""
				  </button>
				</div>
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Nombre
					"""),_display_(Seq[Any](/*88.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*88.93*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-4">
				<label class="control-label">Cliente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*96.8*/inputText(formBuscador("cliente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cliente"))),format.raw/*96.106*/("""
						"""),_display_(Seq[Any](/*97.8*/inputText(formBuscador("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*97.87*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchCliente" 
										data-title="Selección de Clientes" 
										data-url=""""),_display_(Seq[Any](/*102.22*/controllers/*102.33*/.compras.routes.ClientesController.modalBuscar())),format.raw/*102.81*/("""" 
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
			<div class="col-sm-2">
				<div class=" form-group">
					<label class="control-label">Tipo de cliente</label>
					"""),_display_(Seq[Any](/*117.7*/select(formBuscador("cliente_tipo_id"), ClienteTipo.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*117.169*/("""
				</div>
			</div>	
			<div class="col-sm-4">
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*123.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*123.124*/("""
					"""),_display_(Seq[Any](/*124.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*124.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*127.30*/controllers/*127.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*127.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div>
		</div>	
		<div class="row">		
			
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha de Pago</label>
				<div>
				"""),_display_(Seq[Any](/*140.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*140.137*/("""
				"""),_display_(Seq[Any](/*141.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*141.137*/("""
				</div>
				
			</div>
			<div class="col-sm-2">
				<label class="control-label">Punto Venta</label>
				<div class="">
				"""),_display_(Seq[Any](/*148.6*/select(formBuscador("puntoventa_id"), 
				PuntoVenta.find.all().map { p => p.id.toString -> p.numero}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*149.126*/("""
				</div> 
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Numero Factura
					"""),_display_(Seq[Any](/*155.7*/inputText(formBuscador("numero_factura"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*155.101*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-2" >
				<label class="control-label">Tipo de pago</label>
				<div class="">
					"""),_display_(Seq[Any](/*163.7*/select(formBuscador("tipoPago"),options(""->"Todos","efectivo"->"Efectivo","cheque"->"Cheque","tarjeta"->"Tarjeta","transferencia"->"Transferencia"), 'class -> "form-control select", 'id -> "tipoPago"))),format.raw/*163.208*/("""
				</div>
			</div>
			<div class="col-sm-2">
				<label for="planilla" class="control-label">Planilla</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*169.7*/inputText(formBuscador("planilla.recuperoPlanillaEjercicio"),'class -> "form-control", 'id -> "planilla"))),format.raw/*169.112*/("""
					"""),_display_(Seq[Any](/*170.7*/inputText(formBuscador("planilla_id"),'hidden -> "hidden", 'id -> "planilla_id"))),format.raw/*170.87*/("""
	
					<span class="input-group-addon">
					<a href="#" 
					id="searchPlanilla" data-title="Selección de Planilla" 
					data-url=""""),_display_(Seq[Any](/*175.17*/controllers/*175.28*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*175.86*/("""" 
					data-height="650" data-width="700" 
					data-listen="modal.seleccion.planilla.simple" 
					data-label="#planilla" 
					data-field="#planilla_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
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
				<a href=""""),_display_(Seq[Any](/*195.15*/controllers/*195.26*/.recupero.routes.RecuperoPagosController.index())),format.raw/*195.74*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*203.3*/if(buscador.getTotalRowCount == 0)/*203.37*/ {_display_(Seq[Any](format.raw/*203.39*/("""
        
        <div class="well">
            <em>No se encuentran Pagos</em>
        </div>
        
    """)))}/*209.7*/else/*209.12*/{_display_(Seq[Any](format.raw/*209.13*/("""
    	
		<table id="listaRecuperoFacturas" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="7">Mostrando """),_display_(Seq[Any](/*214.39*/buscador/*214.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*214.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="3">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Nombre</th>
					<th width="80">Planilla</th>
					<th width="70">Fecha</th>
					<th width="300">Cliente</th>
					<th width="">N° Factura</th>
					<th width="95">Total</th>
					<th width="95">Tipo de pago</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*233.5*/for(rf <- buscador.getList) yield /*233.32*/ {_display_(Seq[Any](format.raw/*233.34*/("""
				
				<tr class="pointer """),_display_(Seq[Any](/*235.25*/getClassEstado(rf.estado))),format.raw/*235.50*/("""" data-estado=""""),_display_(Seq[Any](/*235.66*/rf/*235.68*/.estado_id)),format.raw/*235.78*/("""" data-href=""""),_display_(Seq[Any](/*235.92*/controllers/*235.103*/.recupero.routes.RecuperoPagosController.ver(rf.id))),format.raw/*235.154*/("""&"""),_display_(Seq[Any](/*235.156*/UriTrack/*235.164*/.encode())),format.raw/*235.173*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*236.64*/rf/*236.66*/.id)),format.raw/*236.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*236.103*/rf/*236.105*/.id)),format.raw/*236.108*/(""""/></td>
					 
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*238.64*/controllers/*238.75*/.recupero.routes.RecuperoPagosController.editar(rf.id))),format.raw/*238.129*/("""&"""),_display_(Seq[Any](/*238.131*/UriTrack/*238.139*/.encode())),format.raw/*238.148*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*239.11*/(rf.nombre))),format.raw/*239.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*240.11*/if(rf.planilla != null)/*240.34*/{_display_(Seq[Any](_display_(Seq[Any](/*240.36*/rf/*240.38*/.planilla.getRecuperoPlanillaEjercicioDeposito()))))})),format.raw/*240.87*/("""</td>
					<td class="fechaRecuperoFactura">"""),_display_(Seq[Any](/*241.40*/if(rf.fecha != null)/*241.60*/{_display_(Seq[Any](_display_(Seq[Any](/*241.62*/(utils.DateUtils.formatDate(rf.fecha))))))})),format.raw/*241.101*/("""</td>
					<td>"""),_display_(Seq[Any](/*242.11*/if(rf.cliente != null)/*242.33*/{_display_(Seq[Any](_display_(Seq[Any](/*242.35*/(rf.cliente.nombre)))))})),format.raw/*242.55*/("""</td>
					<td>"""),_display_(Seq[Any](/*243.11*/if(rf.recuperoFactura != null)/*243.41*/{_display_(Seq[Any](_display_(Seq[Any](/*243.43*/(rf.recuperoFactura.getNumeroFactura())))))})),format.raw/*243.83*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*244.30*/rf/*244.32*/.total)),format.raw/*244.38*/("""">"""),_display_(Seq[Any](/*244.41*/(utils.NumberUtils.moneda(rf.total)))),format.raw/*244.77*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*245.26*/rf/*245.28*/.getTextoTipoPago())),format.raw/*245.47*/("""</td>
					<td class="estado">
						"""),_display_(Seq[Any](/*247.8*/if(rf.parcializada != null && rf.parcializada)/*247.54*/{_display_(Seq[Any](format.raw/*247.55*/("""
							Parcializada
						""")))}/*249.8*/else/*249.12*/{_display_(Seq[Any](format.raw/*249.13*/("""
							"""),_display_(Seq[Any](/*250.9*/(rf.estado.nombre))),format.raw/*250.27*/("""
						""")))})),format.raw/*251.8*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*253.81*/controllers/*253.92*/.recupero.routes.RecuperoPagosController.eliminar(rf.id))),format.raw/*253.148*/("""&"""),_display_(Seq[Any](/*253.150*/UriTrack/*253.158*/.encode())),format.raw/*253.167*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*258.15*/("""
             
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="7">&nbsp</td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="3">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*271.8*/views/*271.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoPagosController.index()))),format.raw/*271.107*/("""
		</div>
<script>
$( function ()"""),format.raw/*274.15*/("""{"""),format.raw/*274.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*278.36*/("""{"""),format.raw/*278.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*281.2*/("""}"""),format.raw/*281.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*284.36*/("""{"""),format.raw/*284.37*/("""
		
		  	selectAll();
	"""),format.raw/*287.2*/("""}"""),format.raw/*287.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*288.56*/("""{"""),format.raw/*288.57*/("""
		selectTrList();
	"""),format.raw/*290.2*/("""}"""),format.raw/*290.3*/(""");
"""),format.raw/*291.1*/("""}"""),format.raw/*291.2*/(""");

function selectTrList()"""),format.raw/*293.24*/("""{"""),format.raw/*293.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*297.36*/("""{"""),format.raw/*297.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*298.77*/("""{"""),format.raw/*298.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*300.3*/("""}"""),format.raw/*300.4*/("""
	"""),format.raw/*301.2*/("""}"""),format.raw/*301.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*304.1*/("""}"""),format.raw/*304.2*/("""

function selectAll()"""),format.raw/*306.21*/("""{"""),format.raw/*306.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*310.36*/("""{"""),format.raw/*310.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*313.2*/("""}"""),format.raw/*313.3*/("""else"""),format.raw/*313.7*/("""{"""),format.raw/*313.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*315.2*/("""}"""),format.raw/*315.3*/("""
	
	$(".total").each(function (index) """),format.raw/*317.36*/("""{"""),format.raw/*317.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*319.2*/("""}"""),format.raw/*319.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*322.1*/("""}"""),format.raw/*322.2*/("""

</script>		
 	 """)))})),format.raw/*325.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.RecuperoPago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoPago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/indexRecuperoPago.scala.html
                    HASH: 89f50927f593142419248526983a76794212ef46
                    MATRIX: 871->1|1098->224|1112->231|1196->235|1247->251|1261->257|1324->299|1391->154|1423->178|1481->338|1504->352|1794->97|1822->222|1849->335|1878->612|1916->615|1929->620|1992->674|2032->676|2621->1229|2641->1240|2727->1303|3264->1804|3284->1815|3354->1863|3392->1865|3409->1873|3440->1882|3610->2017|3623->2022|3670->2047|4065->2407|4146->2466|4369->2654|4450->2713|4666->2894|4747->2953|4974->3145|5055->3204|5281->3395|5389->3481|5577->3634|5698->3732|5741->3740|5842->3819|6055->3995|6076->4006|6147->4054|6592->4463|6778->4625|6968->4779|7109->4896|7152->4903|7255->4983|7449->5140|7470->5151|7545->5203|8017->5639|8172->5770|8214->5776|8369->5907|8535->6037|8723->6201|8905->6347|9023->6441|9205->6587|9430->6788|9616->6938|9745->7043|9788->7050|9891->7130|10064->7266|10085->7277|10166->7335|10806->7938|10827->7949|10898->7997|11042->8105|11086->8139|11127->8141|11256->8252|11270->8257|11310->8258|11522->8433|11540->8441|11595->8473|12221->9063|12265->9090|12306->9092|12373->9122|12421->9147|12474->9163|12486->9165|12519->9175|12570->9189|12592->9200|12667->9251|12707->9253|12726->9261|12759->9270|12862->9336|12874->9338|12900->9341|12972->9375|12985->9377|13012->9380|13128->9459|13149->9470|13227->9524|13267->9526|13286->9534|13319->9543|13418->9605|13452->9616|13505->9632|13538->9655|13587->9657|13599->9659|13675->9708|13757->9753|13787->9773|13836->9775|13903->9814|13956->9830|13988->9852|14037->9854|14084->9874|14137->9890|14177->9920|14226->9922|14293->9962|14365->9997|14377->9999|14406->10005|14446->10008|14505->10044|14573->10075|14585->10077|14627->10096|14701->10134|14757->10180|14797->10181|14844->10209|14858->10213|14898->10214|14943->10223|14984->10241|15024->10249|15157->10345|15178->10356|15258->10412|15298->10414|15317->10422|15350->10431|15496->10544|15846->10858|15861->10863|15979->10957|16041->10990|16071->10991|16172->11063|16202->11064|16272->11106|16301->11107|16441->11218|16471->11219|16522->11242|16551->11243|16638->11301|16668->11302|16716->11322|16745->11323|16776->11326|16805->11327|16861->11354|16891->11355|16992->11427|17022->11428|17128->11505|17158->11506|17227->11547|17256->11548|17286->11550|17315->11551|17445->11653|17474->11654|17525->11676|17555->11677|17659->11752|17689->11753|17784->11820|17813->11821|17845->11825|17874->11826|17968->11892|17997->11893|18064->11931|18094->11932|18161->11971|18190->11972|18320->12074|18349->12075|18399->12093
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|70->38|70->38|70->38|86->54|86->54|86->54|86->54|86->54|86->54|92->60|92->60|92->60|100->68|100->68|103->71|103->71|106->74|106->74|109->77|109->77|120->88|120->88|128->96|128->96|129->97|129->97|134->102|134->102|134->102|149->117|149->117|155->123|155->123|156->124|156->124|159->127|159->127|159->127|172->140|172->140|173->141|173->141|180->148|181->149|187->155|187->155|195->163|195->163|201->169|201->169|202->170|202->170|207->175|207->175|207->175|227->195|227->195|227->195|235->203|235->203|235->203|241->209|241->209|241->209|246->214|246->214|246->214|265->233|265->233|265->233|267->235|267->235|267->235|267->235|267->235|267->235|267->235|267->235|267->235|267->235|267->235|268->236|268->236|268->236|268->236|268->236|268->236|270->238|270->238|270->238|270->238|270->238|270->238|271->239|271->239|272->240|272->240|272->240|272->240|272->240|273->241|273->241|273->241|273->241|274->242|274->242|274->242|274->242|275->243|275->243|275->243|275->243|276->244|276->244|276->244|276->244|276->244|277->245|277->245|277->245|279->247|279->247|279->247|281->249|281->249|281->249|282->250|282->250|283->251|285->253|285->253|285->253|285->253|285->253|285->253|290->258|303->271|303->271|303->271|306->274|306->274|310->278|310->278|313->281|313->281|316->284|316->284|319->287|319->287|320->288|320->288|322->290|322->290|323->291|323->291|325->293|325->293|329->297|329->297|330->298|330->298|332->300|332->300|333->301|333->301|336->304|336->304|338->306|338->306|342->310|342->310|345->313|345->313|345->313|345->313|347->315|347->315|349->317|349->317|351->319|351->319|354->322|354->322|357->325
                    -- GENERATED --
                */
            