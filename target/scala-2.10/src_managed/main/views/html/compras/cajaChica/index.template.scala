
package views.html.compras.cajaChica

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[CajaChica],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CajaChica],  formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*20.2*/scripts/*20.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*20.13*/("""
	<script src=""""),_display_(Seq[Any](/*21.16*/routes/*21.22*/.Assets.at("javascripts/compras/cajaChica.js"))),format.raw/*21.68*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*8.2*/getClassEstado/*8.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 89){
		classEstado = "caja-abierta"
	} else if(i != null && i.id == 91){
		classEstado = "borrador"
	} else if(i != null && i.id == 92){
		classEstado = "cancelada"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.129*/("""
"""),format.raw/*5.70*/(""" 


"""),format.raw/*19.2*/("""
"""),format.raw/*22.2*/("""

"""),_display_(Seq[Any](/*24.2*/views/*24.7*/.html.compras.mainCompras("Lista de caja chica",scripts)/*24.63*/ {_display_(Seq[Any](format.raw/*24.65*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de caja chica</h1>
			</div>
			<div class="col-sm-5">
				
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*33.16*/controllers/*33.27*/.compras.routes.CajaChicaController.crear())),format.raw/*33.70*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva caja chica</a>
				</div>
			</div>
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*40.3*/views/*40.8*/.html.tags.successError())),format.raw/*40.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchCajaChica" method="GET">
		<div class="row">
			<div class="col-sm-4 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
			 	
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*49.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*49.68*/("""
				  </button>
			 	
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Abierta
				 	"""),_display_(Seq[Any](/*53.8*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*53.67*/("""
				  </button>
				  
				  <button type="button" id="btn-filtro-cerrada" rel="cerrada" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-down size-14"></i><br>Cerrada 
				  	"""),_display_(Seq[Any](/*57.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*57.68*/("""
				  </button>
				  
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
				  	"""),_display_(Seq[Any](/*61.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*61.68*/("""
				  </button>
				  
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Referencia
					"""),_display_(Seq[Any](/*69.7*/inputText(formBuscador("referencia"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*69.97*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">N° Cheque
					"""),_display_(Seq[Any](/*76.7*/inputText(formBuscador("cheque"), 'class -> "form-control"))),format.raw/*76.66*/("""
					</label>
				</div>
			</div>
		</div>	
		<div class="row">	
			<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*85.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*85.98*/("""
						"""),_display_(Seq[Any](/*86.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*86.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOrdenPago" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*91.22*/controllers/*91.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*91.90*/("""" 
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
			
			<div class="col-sm-2">
				<label class="control-label" for="expediente">Expediente</label>
					<div class="form-group">
						<div class="input-group">
							"""),_display_(Seq[Any](/*108.9*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*108.94*/("""
							"""),_display_(Seq[Any](/*109.9*/inputText(formBuscador("expediente.nombre"), 'name -> "expediente", 'class -> "form-control", 'id -> "expediente"))),format.raw/*109.123*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchExpediente" 
											data-title="Selección de expediente" 
											data-url=""""),_display_(Seq[Any](/*114.23*/controllers/*114.34*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*114.88*/("""" 
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
			</div> 
			<div class="col-sm-2">
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*129.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*129.124*/("""
					"""),_display_(Seq[Any](/*130.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*130.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*133.30*/controllers/*133.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*133.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha</label>
				<div>
				"""),_display_(Seq[Any](/*143.6*/inputText(formBuscador("fecha_caja_desde"), 'class -> "form-control dateMask inputDateMascara", 'name -> "desde", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*143.160*/("""
				"""),_display_(Seq[Any](/*144.6*/inputText(formBuscador("fecha_caja_hasta"), 'class -> "form-control dateMask inputDateMascara", 'name -> "hasta", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*144.160*/("""
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*149.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*149.166*/("""
				</label>
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
				<a href=""""),_display_(Seq[Any](/*166.15*/controllers/*166.26*/.compras.routes.CajaChicaController.index())),format.raw/*166.69*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*173.3*/if(buscador.getTotalRowCount == 0)/*173.37*/ {_display_(Seq[Any](format.raw/*173.39*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>

    """)))}/*179.7*/else/*179.12*/{_display_(Seq[Any](format.raw/*179.13*/("""
    	
		<table id="listaCajaChica" class="table table-striped table-bordered">
			<thead>

				<tr>
					<th width="30">#</th>
					<th width="80">Referencia</th>
					<th width="70">Fecha</th>
					<th width="95">OP</th>
					<th width="95">Expediente</th>
					<th width="80">Institucion</th>
					<th width="95">Monto límite</th>
					<th width="95">Total</th>
					<th width="95">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*198.5*/for(caja <- buscador.getList) yield /*198.34*/ {_display_(Seq[Any](format.raw/*198.36*/("""
				"""),_display_(Seq[Any](/*199.6*/paginadorFicha/*199.20*/.add(caja.id.toString))),format.raw/*199.42*/("""
				<tr class="pointer """),_display_(Seq[Any](/*200.25*/getClassEstado(caja.estado))),format.raw/*200.52*/("""" data-estado=""""),_display_(Seq[Any](/*200.68*/caja/*200.72*/.estado_id)),format.raw/*200.82*/("""" data-href=""""),_display_(Seq[Any](/*200.96*/controllers/*200.107*/.compras.routes.CajaChicaController.ver(caja.id))),format.raw/*200.155*/("""&"""),_display_(Seq[Any](/*200.157*/UriTrack/*200.165*/.encode())),format.raw/*200.174*/("""">
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*201.64*/controllers/*201.75*/.compras.routes.CajaChicaController.editar(caja.id))),format.raw/*201.126*/("""&"""),_display_(Seq[Any](/*201.128*/UriTrack/*201.136*/.encode())),format.raw/*201.145*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*202.11*/(caja.referencia))),format.raw/*202.28*/("""</td>
					<td class="fechacaja">"""),_display_(Seq[Any](/*203.29*/utils/*203.34*/.DateUtils.formatDate(caja.fecha))),format.raw/*203.67*/("""</td>
					<td class="opg">"""),_display_(Seq[Any](/*204.23*/if(caja.ordenPago != null)/*204.49*/{_display_(Seq[Any](_display_(Seq[Any](/*204.51*/(caja.ordenPago.getNombreCompleto())))))})),format.raw/*204.88*/("""</td>
					<td>"""),_display_(Seq[Any](/*205.11*/if(caja.expediente != null)/*205.38*/{_display_(Seq[Any](_display_(Seq[Any](/*205.40*/caja/*205.44*/.expediente.getExpedienteEjercicio()))))})),format.raw/*205.81*/("""</td>
					<td>"""),_display_(Seq[Any](/*206.11*/if(caja.deposito != null)/*206.36*/{_display_(Seq[Any](_display_(Seq[Any](/*206.38*/caja/*206.42*/.deposito.sigla))))})),format.raw/*206.58*/("""</td>
					<td class="limite" rel=""""),_display_(Seq[Any](/*207.31*/caja/*207.35*/.monto_limite)),format.raw/*207.48*/("""">"""),_display_(Seq[Any](/*207.51*/utils/*207.56*/.NumberUtils.moneda(caja.monto_limite))),format.raw/*207.94*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*208.30*/caja/*208.34*/.getTotal())),format.raw/*208.45*/("""">"""),_display_(Seq[Any](/*208.48*/utils/*208.53*/.NumberUtils.moneda(caja.getTotal()))),format.raw/*208.89*/("""</td>
					<td class="" rel="">"""),_display_(Seq[Any](/*209.27*/(caja.estado.nombre))),format.raw/*209.47*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*211.81*/controllers/*211.92*/.compras.routes.CajaChicaController.eliminar(caja.id))),format.raw/*211.145*/("""&"""),_display_(Seq[Any](/*211.147*/UriTrack/*211.155*/.encode())),format.raw/*211.164*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*216.15*/("""
             """),_display_(Seq[Any](/*217.15*/paginadorFicha/*217.29*/.guardar())),format.raw/*217.39*/("""
	        </tbody>
			<tfoot>
	        	<tr>	
	        		<td colspan="5">&nbsp</td>
	        		<td colspan="5">Mostrando """),_display_(Seq[Any](/*222.39*/buscador/*222.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*222.79*/(""" resultado(s).</td>
	        	</tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*228.8*/views/*228.13*/.html.helpers.paginador(buscador, controllers.compras.routes.CajaChicaController.index()))),format.raw/*228.102*/("""
		</div>
		
	""")))})),format.raw/*231.3*/("""
		
		
<script type="text/javascript">

$( function ()"""),format.raw/*236.15*/("""{"""),format.raw/*236.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*240.36*/("""{"""),format.raw/*240.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*243.2*/("""}"""),format.raw/*243.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".limite").each(function (index) """),format.raw/*246.37*/("""{"""),format.raw/*246.38*/("""
		
		b = Number($(this).attr("rel"))+b
	"""),format.raw/*249.2*/("""}"""),format.raw/*249.3*/(""")
	$(".limiteFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));	
	
	$(".descuento").each(function (index) """),format.raw/*252.40*/("""{"""),format.raw/*252.41*/("""
		
		c = Number($(this).attr("rel"))+c
	"""),format.raw/*255.2*/("""}"""),format.raw/*255.3*/(""")
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*258.36*/("""{"""),format.raw/*258.37*/("""
		
		  	selectAll();
	"""),format.raw/*261.2*/("""}"""),format.raw/*261.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*262.56*/("""{"""),format.raw/*262.57*/("""
		selectTrList();
	"""),format.raw/*264.2*/("""}"""),format.raw/*264.3*/(""");
"""),format.raw/*265.1*/("""}"""),format.raw/*265.2*/(""");

function selectTrList()"""),format.raw/*267.24*/("""{"""),format.raw/*267.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*271.36*/("""{"""),format.raw/*271.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*272.77*/("""{"""),format.raw/*272.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*274.3*/("""}"""),format.raw/*274.4*/("""
	"""),format.raw/*275.2*/("""}"""),format.raw/*275.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".limite").each(function (index) """),format.raw/*279.37*/("""{"""),format.raw/*279.38*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*280.77*/("""{"""),format.raw/*280.78*/("""
			b = Number($(this).attr("rel"))+b 
		"""),format.raw/*282.3*/("""}"""),format.raw/*282.4*/("""
	"""),format.raw/*283.2*/("""}"""),format.raw/*283.3*/(""")
	$(".limiteFooter").empty();
	$(".limiteFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*287.40*/("""{"""),format.raw/*287.41*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*288.77*/("""{"""),format.raw/*288.78*/("""
			c = Number($(this).attr("rel"))+c 
		"""),format.raw/*290.3*/("""}"""),format.raw/*290.4*/("""
	"""),format.raw/*291.2*/("""}"""),format.raw/*291.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*294.1*/("""}"""),format.raw/*294.2*/("""

function selectAll()"""),format.raw/*296.21*/("""{"""),format.raw/*296.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*300.36*/("""{"""),format.raw/*300.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*303.2*/("""}"""),format.raw/*303.3*/("""else"""),format.raw/*303.7*/("""{"""),format.raw/*303.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*305.2*/("""}"""),format.raw/*305.3*/("""
	
	$(".total").each(function (index) """),format.raw/*307.36*/("""{"""),format.raw/*307.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*309.2*/("""}"""),format.raw/*309.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$(".limite").each(function (index) """),format.raw/*313.37*/("""{"""),format.raw/*313.38*/("""
		b = Number($(this).attr("rel"))+b 
	"""),format.raw/*315.2*/("""}"""),format.raw/*315.3*/(""")
	$(".limiteFooter").empty();
	$(".limiteFooter").append(formatNumberPesos(parseFloat(b).toFixed(2)));
	
	$(".descuento").each(function (index) """),format.raw/*319.40*/("""{"""),format.raw/*319.41*/("""
		c = Number($(this).attr("rel"))+c 
	"""),format.raw/*321.2*/("""}"""),format.raw/*321.3*/(""")
	$(".descuentoFooter").empty();
	$(".descuentoFooter").append(formatNumberPesos(parseFloat(c).toFixed(2)));
"""),format.raw/*324.1*/("""}"""),format.raw/*324.2*/("""

</script>		

""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[CajaChica],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[CajaChica],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/index.scala.html
                    HASH: 9525df337ce73aa274b116fe2d61ccb5210bd057
                    MATRIX: 868->1|1130->557|1145->564|1230->568|1283->585|1298->591|1366->637|1434->189|1466->213|1523->265|1545->279|1851->128|1880->257|1914->554|1943->674|1983->679|1996->684|2061->740|2101->742|2349->954|2369->965|2434->1008|2616->1155|2629->1160|2676->1185|3083->1557|3164->1616|3385->1802|3466->1861|3706->2066|3787->2125|4024->2327|4105->2386|4312->2558|4424->2648|4620->2809|4701->2868|4947->3079|5059->3169|5103->3178|5208->3261|5434->3451|5454->3462|5533->3519|6061->4011|6169->4096|6215->4106|6353->4220|6581->4411|6602->4422|6679->4476|7176->4937|7317->5054|7361->5062|7464->5142|7661->5302|7682->5313|7757->5365|8195->5767|8373->5921|8416->5928|8594->6082|8732->6184|8915->6343|9368->6759|9389->6770|9455->6813|9602->6924|9646->6958|9687->6960|9819->7074|9833->7079|9873->7080|10389->7560|10435->7589|10476->7591|10519->7598|10543->7612|10588->7634|10651->7660|10701->7687|10754->7703|10768->7707|10801->7717|10852->7731|10874->7742|10946->7790|10986->7792|11005->7800|11038->7809|11142->7876|11163->7887|11238->7938|11278->7940|11297->7948|11330->7957|11430->8020|11470->8037|11542->8072|11557->8077|11613->8110|11679->8139|11715->8165|11764->8167|11828->8204|11882->8221|11919->8248|11968->8250|11982->8254|12046->8291|12100->8308|12135->8333|12184->8335|12198->8339|12241->8355|12315->8392|12329->8396|12365->8409|12405->8412|12420->8417|12481->8455|12554->8491|12568->8495|12602->8506|12642->8509|12657->8514|12716->8550|12786->8583|12829->8603|12964->8701|12985->8712|13062->8765|13102->8767|13121->8775|13154->8784|13305->8902|13358->8918|13382->8932|13415->8942|13579->9069|13597->9077|13652->9109|13819->9240|13834->9245|13947->9334|13997->9352|14085->9411|14115->9412|14220->9488|14250->9489|14323->9534|14352->9535|14496->9650|14526->9651|14598->9695|14627->9696|14776->9816|14806->9817|14878->9861|14907->9862|15054->9980|15084->9981|15138->10007|15167->10008|15255->10067|15285->10068|15335->10090|15364->10091|15396->10095|15425->10096|15483->10125|15513->10126|15618->10202|15648->10203|15755->10281|15785->10282|15856->10325|15885->10326|15916->10329|15945->10330|16118->10474|16148->10475|16255->10553|16285->10554|16356->10597|16385->10598|16416->10601|16445->10602|16623->10751|16653->10752|16760->10830|16790->10831|16861->10874|16890->10875|16921->10878|16950->10879|17091->10992|17120->10993|17173->11017|17203->11018|17311->11097|17341->11098|17439->11168|17468->11169|17500->11173|17529->11174|17625->11242|17654->11243|17723->11283|17753->11284|17822->11325|17851->11326|18024->11470|18054->11471|18123->11512|18152->11513|18330->11662|18360->11663|18429->11704|18458->11705|18599->11818|18628->11819
                    LINES: 26->1|33->20|33->20|35->20|36->21|36->21|36->21|37->5|37->5|37->8|37->8|49->1|50->5|53->19|54->22|56->24|56->24|56->24|56->24|65->33|65->33|65->33|72->40|72->40|72->40|81->49|81->49|85->53|85->53|89->57|89->57|93->61|93->61|101->69|101->69|108->76|108->76|117->85|117->85|118->86|118->86|123->91|123->91|123->91|140->108|140->108|141->109|141->109|146->114|146->114|146->114|161->129|161->129|162->130|162->130|165->133|165->133|165->133|175->143|175->143|176->144|176->144|181->149|181->149|198->166|198->166|198->166|205->173|205->173|205->173|211->179|211->179|211->179|230->198|230->198|230->198|231->199|231->199|231->199|232->200|232->200|232->200|232->200|232->200|232->200|232->200|232->200|232->200|232->200|232->200|233->201|233->201|233->201|233->201|233->201|233->201|234->202|234->202|235->203|235->203|235->203|236->204|236->204|236->204|236->204|237->205|237->205|237->205|237->205|237->205|238->206|238->206|238->206|238->206|238->206|239->207|239->207|239->207|239->207|239->207|239->207|240->208|240->208|240->208|240->208|240->208|240->208|241->209|241->209|243->211|243->211|243->211|243->211|243->211|243->211|248->216|249->217|249->217|249->217|254->222|254->222|254->222|260->228|260->228|260->228|263->231|268->236|268->236|272->240|272->240|275->243|275->243|278->246|278->246|281->249|281->249|284->252|284->252|287->255|287->255|290->258|290->258|293->261|293->261|294->262|294->262|296->264|296->264|297->265|297->265|299->267|299->267|303->271|303->271|304->272|304->272|306->274|306->274|307->275|307->275|311->279|311->279|312->280|312->280|314->282|314->282|315->283|315->283|319->287|319->287|320->288|320->288|322->290|322->290|323->291|323->291|326->294|326->294|328->296|328->296|332->300|332->300|335->303|335->303|335->303|335->303|337->305|337->305|339->307|339->307|341->309|341->309|345->313|345->313|347->315|347->315|351->319|351->319|353->321|353->321|356->324|356->324
                    -- GENERATED --
                */
            