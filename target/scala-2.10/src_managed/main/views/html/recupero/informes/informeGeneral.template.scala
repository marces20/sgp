
package views.html.recupero.informes

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
object informeGeneral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.InformeTotal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.InformeTotal], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/recupero/recuperoFactura.js"))),format.raw/*7.75*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""


"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.recupero.mainRecupero(title = "Informe deudas", scripts)/*11.69*/ {_display_(Seq[Any](format.raw/*11.71*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Informe deudas</h1>
		</div>

		<div class="col-sm-3">
			<a id="generarArchivo" href=""""),_display_(Seq[Any](/*20.34*/controllers/*20.45*/.recupero.routes.RecuperoReportesController.archivoInformeGeneral())),format.raw/*20.112*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-download-alt"></i> Generar archivo</a>
		</div>

	</div>
</div>


<script>

$( function() """),format.raw/*29.15*/("""{"""),format.raw/*29.16*/("""
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))

"""),format.raw/*33.1*/("""}"""),format.raw/*33.2*/(""");

</script>




"""),_display_(Seq[Any](/*40.2*/if(flash.containsKey("success"))/*40.34*/ {_display_(Seq[Any](format.raw/*40.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*41.80*/flash/*41.85*/.get("success"))),format.raw/*41.100*/("""</div>
""")))})),format.raw/*42.2*/("""
"""),_display_(Seq[Any](/*43.2*/if(flash.containsKey("error"))/*43.32*/ {_display_(Seq[Any](format.raw/*43.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*44.83*/flash/*44.88*/.get("error"))),format.raw/*44.101*/("""</div>
""")))})),format.raw/*45.2*/(""" 


    <form action="" method="GET" id="filtroInforme">
		<div class="row seccion">
			
			
		<div class="col-sm-4">
			<label class="control-label">Cliente
				<div class="input-group">	
					"""),_display_(Seq[Any](/*55.7*/inputText(formBuscador("cliente_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "cliente"))),format.raw/*55.132*/("""
					"""),_display_(Seq[Any](/*56.7*/inputText(formBuscador("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*56.86*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCliente" 
									data-title="Selección de cliente" 
									data-url=""""),_display_(Seq[Any](/*61.21*/controllers/*61.32*/.compras.routes.ClientesController.modalBuscar())),format.raw/*61.80*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cliente.simple" 
									data-label="#cliente" 
									data-field="#cliente_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>
		<div class="col-sm-3">
			<div class=" form-group">
				<label class="control-label">Tipo de cliente</label>
				"""),_display_(Seq[Any](/*76.6*/select(formBuscador("cliente_tipo_id"), ClienteTipo.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*76.168*/("""
			</div>
		</div>	
		<div class="col-sm-2">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group">
				
				"""),_display_(Seq[Any](/*83.6*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*83.82*/("""
				"""),_display_(Seq[Any](/*84.6*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*84.83*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*89.19*/controllers/*89.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*89.83*/("""" 
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
			
			
		<div class="col-sm-2">
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*105.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*105.111*/("""
					"""),_display_(Seq[Any](/*106.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*106.92*/("""
					
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*112.21*/controllers/*112.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*112.86*/("""" 
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
			
		
	</div>
	<div class="row">	
	
		
		<div class="col-sm-2">
			<label class="control-label">Ejercicio</label>
				"""),_display_(Seq[Any](/*132.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*132.165*/("""
		</div>	
		<div class="col-sm-2 input-group">
			<label class="control-label">Fecha Factura</label>
			<div>
				"""),_display_(Seq[Any](/*137.6*/inputText(formBuscador("fecha_factura_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_factura_desde", 'placeholder -> "Desde"))),format.raw/*137.150*/("""
				"""),_display_(Seq[Any](/*138.6*/inputText(formBuscador("fecha_factura_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_factura_hasta", 'placeholder -> "Hasta"))),format.raw/*138.150*/("""
			</div>
		</div>
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="mayor_a">Deuda entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*145.7*/inputText(formBuscador("deuda_mayor"), 'class -> "form-control", 'id -> "mayor_a", 'placeholder -> "Mayor a"))),format.raw/*145.116*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*147.10*/inputText(formBuscador("deuda_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*147.101*/("""
				</div>
			</div>
		</div>			
				
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="pago_ma">Pago entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*156.7*/inputText(formBuscador("pago_mayor"), 'class -> "form-control", 'id -> "pago_ma", 'placeholder -> "Mayor a"))),format.raw/*156.115*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*158.10*/inputText(formBuscador("pago_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*158.100*/("""
				</div>
			</div>
		</div>	
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*165.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*165.123*/("""
				"""),_display_(Seq[Any](/*166.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*166.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*169.29*/controllers/*169.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*169.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
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
			<a href=""""),_display_(Seq[Any](/*190.14*/controllers/*190.25*/.recupero.routes.RecuperoReportesController.informeGeneral())),format.raw/*190.85*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
			
		</div>
    </form>
    """),_display_(Seq[Any](/*196.6*/if(buscador.getTotalRowCount == 0)/*196.40*/ {_display_(Seq[Any](format.raw/*196.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*202.7*/else/*202.12*/{_display_(Seq[Any](format.raw/*202.13*/("""
		Mostrando """),_display_(Seq[Any](/*203.14*/buscador/*203.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*203.54*/(""" resultado(s).   
		<table class="table table-striped table-bordered" id="listaInforme">
			<thead>
				<tr>
				    <th width="20"><input type="checkbox" name="checkAll" id="checkAll"/></th>
				    <th>Institucion</th>
					<th width="40">Número</th>
					<th width="60">Fecha</th>
					<th>Cliente</th>
					<th width="90">Total factura</th>
					<th width="90">Total pagos</th>
					<th width="90">Total deuda</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*218.12*/for(informe <- buscador.getList) yield /*218.44*/ {_display_(Seq[Any](format.raw/*218.46*/("""
				<tr>
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*220.64*/informe/*220.71*/.id)),format.raw/*220.74*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*220.108*/informe/*220.115*/.id)),format.raw/*220.118*/(""""/></td>
					<td>"""),_display_(Seq[Any](/*221.11*/if(informe.deposito != null)/*221.39*/{_display_(Seq[Any](_display_(Seq[Any](/*221.41*/informe/*221.48*/.deposito.sigla))))})),format.raw/*221.64*/("""</td>
					<td>"""),_display_(Seq[Any](/*222.11*/informe/*222.18*/.numero)),format.raw/*222.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*223.11*/DateUtils/*223.20*/.formatDate(informe.fecha))),format.raw/*223.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*224.11*/informe/*224.18*/.cliente.nombre)),format.raw/*224.33*/("""</td>
					<td class="totalFactura" data-valor=""""),_display_(Seq[Any](/*225.44*/informe/*225.51*/.totalFactura)),format.raw/*225.64*/("""">"""),_display_(Seq[Any](/*225.67*/utils/*225.72*/.NumberUtils.moneda(informe.totalFactura))),format.raw/*225.113*/("""</td>
					<td class="totalPagos" data-valor=""""),_display_(Seq[Any](/*226.42*/informe/*226.49*/.totalPagos)),format.raw/*226.60*/("""">"""),_display_(Seq[Any](/*226.63*/utils/*226.68*/.NumberUtils.moneda(informe.totalPagos))),format.raw/*226.107*/("""</td>					
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*227.42*/informe/*227.49*/.totalDeuda)),format.raw/*227.60*/("""">"""),_display_(Seq[Any](/*227.63*/utils/*227.68*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*227.107*/("""</td>
				</tr>
		        """)))})),format.raw/*229.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"></td>
					<td><b>Total:</b><br /><span id="facturaFooter"></span></td>
					<td><b>Total:</b><br /><span id="pagosFooter"></span></td>
					<td><b>Total:</b><br /><span id="deudaFooter"></span></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*241.8*/views/*241.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoReportesController.informeGeneral()))),format.raw/*241.119*/("""
		</div>
	""")))})),format.raw/*243.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*247.16*/("""{"""),format.raw/*247.17*/("""
		$('#searchPeriodo, #searchExpediente, #searchCliente').modalSearch();
		
		var trs = $('#listaInforme tbody tr');
		sumarFilas(trs);
		
		
		$('#checkAll').click( function() """),format.raw/*254.36*/("""{"""),format.raw/*254.37*/("""
			sumarFilas($('#listaInforme tbody tr'));
		"""),format.raw/*256.3*/("""}"""),format.raw/*256.4*/(""");
		
		$('input[name="check_listado[]"]').click( function() """),format.raw/*258.56*/("""{"""),format.raw/*258.57*/("""
			sumarFilas( $('#listaInforme tbody tr:has(td:eq(0):has(input:checked))') );
		"""),format.raw/*260.3*/("""}"""),format.raw/*260.4*/(""");
		
		function sumarFilas(trs) """),format.raw/*262.28*/("""{"""),format.raw/*262.29*/("""

			var factura = 0; var pagado = 0; var deuda = 0; 
			
			trs.each( function() """),format.raw/*266.25*/("""{"""),format.raw/*266.26*/("""
				factura += Number($('.totalFactura',this).attr("data-valor"));
				pagado += Number($('.totalPagos',this).attr("data-valor"));
				deuda += Number($('.totalDeuda',this).attr("data-valor"));
			"""),format.raw/*270.4*/("""}"""),format.raw/*270.5*/(""");

			$("#facturaFooter").html(formatNumberPesos(parseFloat(factura).toFixed(2)));
			$("#pagosFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
			$("#deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
		"""),format.raw/*275.3*/("""}"""),format.raw/*275.4*/("""
		

		
	"""),format.raw/*279.2*/("""}"""),format.raw/*279.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.InformeTotal],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.InformeTotal],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/informes/informeGeneral.scala.html
                    HASH: ecde63dc4b1f6434a875d7c73f3ebf663c99e0cd
                    MATRIX: 864->1|1071->209|1085->216|1169->220|1221->237|1235->243|1309->296|1377->118|1409->142|1483->97|1512->186|1541->206|1569->333|1611->340|1624->345|1695->407|1735->409|1951->589|1971->600|2061->667|2245->823|2274->824|2484->1007|2512->1008|2573->1034|2614->1066|2654->1068|2771->1149|2785->1154|2823->1169|2863->1178|2901->1181|2940->1211|2980->1213|3100->1297|3114->1302|3150->1315|3190->1324|3430->1529|3578->1654|3621->1662|3722->1741|3933->1916|3953->1927|4023->1975|4475->2392|4660->2554|4855->2714|4953->2790|4995->2797|5094->2874|5296->3040|5316->3051|5391->3104|5813->3490|5941->3594|5985->3602|6093->3687|6318->3875|6339->3886|6416->3940|6889->4377|7072->4536|7229->4657|7397->4801|7440->4808|7608->4952|7807->5115|7940->5224|8035->5282|8150->5373|8369->5556|8501->5664|8596->5722|8710->5812|8912->5978|9053->6095|9096->6102|9199->6182|9393->6339|9414->6350|9489->6402|10196->7072|10217->7083|10300->7143|10443->7250|10487->7284|10528->7286|10668->7408|10682->7413|10722->7414|10774->7429|10792->7437|10847->7469|11362->7947|11411->7979|11452->7981|11564->8056|11581->8063|11607->8066|11679->8100|11697->8107|11724->8110|11781->8130|11819->8158|11868->8160|11885->8167|11928->8183|11982->8200|11999->8207|12029->8214|12083->8231|12102->8240|12151->8266|12205->8283|12222->8290|12260->8305|12347->8355|12364->8362|12400->8375|12440->8378|12455->8383|12520->8424|12605->8472|12622->8479|12656->8490|12696->8493|12711->8498|12774->8537|12864->8590|12881->8597|12915->8608|12955->8611|12970->8616|13033->8655|13095->8684|13475->9028|13490->9033|13620->9139|13666->9153|13752->9210|13782->9211|13995->9395|14025->9396|14102->9445|14131->9446|14223->9509|14253->9510|14365->9594|14394->9595|14458->9630|14488->9631|14603->9717|14633->9718|14863->9920|14892->9921|15164->10165|15193->10166|15234->10179|15263->10180
                    LINES: 26->1|31->6|31->6|33->6|34->7|34->7|34->7|35->3|35->3|36->1|37->3|38->5|39->8|42->11|42->11|42->11|42->11|51->20|51->20|51->20|60->29|60->29|64->33|64->33|71->40|71->40|71->40|72->41|72->41|72->41|73->42|74->43|74->43|74->43|75->44|75->44|75->44|76->45|86->55|86->55|87->56|87->56|92->61|92->61|92->61|107->76|107->76|114->83|114->83|115->84|115->84|120->89|120->89|120->89|136->105|136->105|137->106|137->106|143->112|143->112|143->112|163->132|163->132|168->137|168->137|169->138|169->138|176->145|176->145|178->147|178->147|187->156|187->156|189->158|189->158|196->165|196->165|197->166|197->166|200->169|200->169|200->169|221->190|221->190|221->190|227->196|227->196|227->196|233->202|233->202|233->202|234->203|234->203|234->203|249->218|249->218|249->218|251->220|251->220|251->220|251->220|251->220|251->220|252->221|252->221|252->221|252->221|252->221|253->222|253->222|253->222|254->223|254->223|254->223|255->224|255->224|255->224|256->225|256->225|256->225|256->225|256->225|256->225|257->226|257->226|257->226|257->226|257->226|257->226|258->227|258->227|258->227|258->227|258->227|258->227|260->229|272->241|272->241|272->241|274->243|278->247|278->247|285->254|285->254|287->256|287->256|289->258|289->258|291->260|291->260|293->262|293->262|297->266|297->266|301->270|301->270|306->275|306->275|310->279|310->279
                    -- GENERATED --
                */
            