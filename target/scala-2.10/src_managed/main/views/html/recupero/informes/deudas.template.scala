
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
object deudas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.InformeTotal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.InformeTotal], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.recupero.mainRecupero(title = "Informe deudas")/*6.60*/ {_display_(Seq[Any](format.raw/*6.62*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Informe deudas</h1>
		</div>

		<div class="col-sm-3">
			<a id="generarArchivo" href=""""),_display_(Seq[Any](/*15.34*/controllers/*15.45*/.recupero.routes.RecuperoReportesController.archivoInformeDeuda())),format.raw/*15.110*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-download-alt"></i> Generar archivo</a>
		</div>

	</div>
</div>


<script>

$( function() """),format.raw/*24.15*/("""{"""),format.raw/*24.16*/("""
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))

"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/(""");

</script>




"""),_display_(Seq[Any](/*35.2*/if(flash.containsKey("success"))/*35.34*/ {_display_(Seq[Any](format.raw/*35.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*36.80*/flash/*36.85*/.get("success"))),format.raw/*36.100*/("""</div>
""")))})),format.raw/*37.2*/("""
"""),_display_(Seq[Any](/*38.2*/if(flash.containsKey("error"))/*38.32*/ {_display_(Seq[Any](format.raw/*38.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*39.83*/flash/*39.88*/.get("error"))),format.raw/*39.101*/("""</div>
""")))})),format.raw/*40.2*/(""" 


    <form action="" method="GET" id="filtroInforme">
		<div class="row seccion">
			
			
		<div class="col-sm-4">
			<label class="control-label">Cliente
				<div class="input-group">	
					"""),_display_(Seq[Any](/*50.7*/inputText(formBuscador("cliente_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "cliente"))),format.raw/*50.132*/("""
					"""),_display_(Seq[Any](/*51.7*/inputText(formBuscador("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*51.86*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCliente" 
									data-title="Selección de cliente" 
									data-url=""""),_display_(Seq[Any](/*56.21*/controllers/*56.32*/.compras.routes.ClientesController.modalBuscar())),format.raw/*56.80*/("""" 
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
			
		<div class="col-sm-2">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group">
				
				"""),_display_(Seq[Any](/*73.6*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*73.82*/("""
				"""),_display_(Seq[Any](/*74.6*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*74.83*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*79.19*/controllers/*79.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*79.83*/("""" 
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
					"""),_display_(Seq[Any](/*95.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*95.111*/("""
					"""),_display_(Seq[Any](/*96.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*96.92*/("""
					
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*102.21*/controllers/*102.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*102.86*/("""" 
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
				"""),_display_(Seq[Any](/*117.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*117.165*/("""
			
		</div>	
	</div>
	<div class="row">	
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="mayor_a">Deuda entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*126.7*/inputText(formBuscador("deuda_mayor"), 'class -> "form-control", 'id -> "mayor_a", 'placeholder -> "Mayor a"))),format.raw/*126.116*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*128.10*/inputText(formBuscador("deuda_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*128.101*/("""
				</div>
			</div>
		</div>			
				
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="pago_ma">Pago entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*137.7*/inputText(formBuscador("pago_mayor"), 'class -> "form-control", 'id -> "pago_ma", 'placeholder -> "Mayor a"))),format.raw/*137.115*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*139.10*/inputText(formBuscador("pago_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*139.100*/("""
				</div>
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
			<a href=""""),_display_(Seq[Any](/*157.14*/controllers/*157.25*/.recupero.routes.RecuperoReportesController.informeDeuda())),format.raw/*157.83*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
			
		</div>
    </form>
    """),_display_(Seq[Any](/*163.6*/if(buscador.getTotalRowCount == 0)/*163.40*/ {_display_(Seq[Any](format.raw/*163.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*169.7*/else/*169.12*/{_display_(Seq[Any](format.raw/*169.13*/("""
		Mostrando """),_display_(Seq[Any](/*170.14*/buscador/*170.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*170.54*/(""" resultado(s).   
		<table class="table table-striped table-bordered" id="listaInforme">
			<thead>
				<tr>
				    <th width="20"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="40">Número</th>
					<th width="60">Fecha</th>
					<th>Cliente</th>
					<th width="90">Total factura</th>
					<th width="90">Total pagos</th>
					<th width="90">Total deuda</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*184.12*/for(informe <- buscador.getList) yield /*184.44*/ {_display_(Seq[Any](format.raw/*184.46*/("""
				<tr>
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*186.64*/informe/*186.71*/.id)),format.raw/*186.74*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*186.108*/informe/*186.115*/.id)),format.raw/*186.118*/(""""/></td>
					<td>"""),_display_(Seq[Any](/*187.11*/informe/*187.18*/.numero)),format.raw/*187.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*188.11*/DateUtils/*188.20*/.formatDate(informe.fecha))),format.raw/*188.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*189.11*/informe/*189.18*/.cliente.nombre)),format.raw/*189.33*/("""</td>
					<td class="totalFactura" data-valor=""""),_display_(Seq[Any](/*190.44*/informe/*190.51*/.totalFactura)),format.raw/*190.64*/("""">"""),_display_(Seq[Any](/*190.67*/utils/*190.72*/.NumberUtils.moneda(informe.totalFactura))),format.raw/*190.113*/("""</td>
					<td class="totalPagos" data-valor=""""),_display_(Seq[Any](/*191.42*/informe/*191.49*/.totalPagos)),format.raw/*191.60*/("""">"""),_display_(Seq[Any](/*191.63*/utils/*191.68*/.NumberUtils.moneda(informe.totalPagos))),format.raw/*191.107*/("""</td>					
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*192.42*/informe/*192.49*/.totalDeuda)),format.raw/*192.60*/("""">"""),_display_(Seq[Any](/*192.63*/utils/*192.68*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*192.107*/("""</td>
				</tr>
		        """)))})),format.raw/*194.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4"></td>
					<td><b>Total:</b><br /><span id="facturaFooter"></span></td>
					<td><b>Total:</b><br /><span id="pagosFooter"></span></td>
					<td><b>Total:</b><br /><span id="deudaFooter"></span></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*206.8*/views/*206.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoReportesController.informeDeuda()))),format.raw/*206.117*/("""
		</div>
	""")))})),format.raw/*208.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*212.16*/("""{"""),format.raw/*212.17*/("""
		$('#searchPeriodo, #searchExpediente, #searchCliente').modalSearch();
		
		var trs = $('#listaInforme tbody tr');
		sumarFilas(trs);
		
		
		$('#checkAll').click( function() """),format.raw/*219.36*/("""{"""),format.raw/*219.37*/("""
			sumarFilas($('#listaInforme tbody tr'));
		"""),format.raw/*221.3*/("""}"""),format.raw/*221.4*/(""");
		
		$('input[name="check_listado[]"]').click( function() """),format.raw/*223.56*/("""{"""),format.raw/*223.57*/("""
			sumarFilas( $('#listaInforme tbody tr:has(td:eq(0):has(input:checked))') );
		"""),format.raw/*225.3*/("""}"""),format.raw/*225.4*/(""");
		
		function sumarFilas(trs) """),format.raw/*227.28*/("""{"""),format.raw/*227.29*/("""

			var factura = 0; var pagado = 0; var deuda = 0; 
			
			trs.each( function() """),format.raw/*231.25*/("""{"""),format.raw/*231.26*/("""
				factura += Number($('.totalFactura',this).attr("data-valor"));
				pagado += Number($('.totalPagos',this).attr("data-valor"));
				deuda += Number($('.totalDeuda',this).attr("data-valor"));
			"""),format.raw/*235.4*/("""}"""),format.raw/*235.5*/(""");

			$("#facturaFooter").html(formatNumberPesos(parseFloat(factura).toFixed(2)));
			$("#pagosFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
			$("#deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
		"""),format.raw/*240.3*/("""}"""),format.raw/*240.4*/("""
		

		
	"""),format.raw/*244.2*/("""}"""),format.raw/*244.3*/(""");
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/informes/deudas.scala.html
                    HASH: 54b65689a3a371798edd5a789f0d0c50e9773ec7
                    MATRIX: 856->1|1072->118|1104->142|1178->97|1207->186|1236->206|1273->209|1285->214|1346->267|1385->269|1601->449|1621->460|1709->525|1893->681|1922->682|2132->865|2160->866|2221->892|2262->924|2302->926|2419->1007|2433->1012|2471->1027|2511->1036|2549->1039|2588->1069|2628->1071|2748->1155|2762->1160|2798->1173|2838->1182|3078->1387|3226->1512|3269->1520|3370->1599|3581->1774|3601->1785|3671->1833|4145->2272|4243->2348|4285->2355|4384->2432|4586->2598|4606->2609|4681->2662|5102->3048|5229->3152|5272->3160|5379->3245|5604->3433|5625->3444|5702->3498|6134->3894|6317->4053|6541->4241|6674->4350|6769->4408|6884->4499|7103->4682|7235->4790|7330->4848|7444->4938|7894->5351|7915->5362|7996->5420|8139->5527|8183->5561|8224->5563|8364->5685|8378->5690|8418->5691|8470->5706|8488->5714|8543->5746|9028->6194|9077->6226|9118->6228|9230->6303|9247->6310|9273->6313|9345->6347|9363->6354|9390->6357|9447->6377|9464->6384|9494->6391|9548->6408|9567->6417|9616->6443|9670->6460|9687->6467|9725->6482|9812->6532|9829->6539|9865->6552|9905->6555|9920->6560|9985->6601|10070->6649|10087->6656|10121->6667|10161->6670|10176->6675|10239->6714|10329->6767|10346->6774|10380->6785|10420->6788|10435->6793|10498->6832|10560->6861|10940->7205|10955->7210|11083->7314|11129->7328|11215->7385|11245->7386|11458->7570|11488->7571|11565->7620|11594->7621|11686->7684|11716->7685|11828->7769|11857->7770|11921->7805|11951->7806|12066->7892|12096->7893|12326->8095|12355->8096|12627->8340|12656->8341|12697->8354|12726->8355
                    LINES: 26->1|31->3|31->3|32->1|33->3|34->5|35->6|35->6|35->6|35->6|44->15|44->15|44->15|53->24|53->24|57->28|57->28|64->35|64->35|64->35|65->36|65->36|65->36|66->37|67->38|67->38|67->38|68->39|68->39|68->39|69->40|79->50|79->50|80->51|80->51|85->56|85->56|85->56|102->73|102->73|103->74|103->74|108->79|108->79|108->79|124->95|124->95|125->96|125->96|131->102|131->102|131->102|146->117|146->117|155->126|155->126|157->128|157->128|166->137|166->137|168->139|168->139|186->157|186->157|186->157|192->163|192->163|192->163|198->169|198->169|198->169|199->170|199->170|199->170|213->184|213->184|213->184|215->186|215->186|215->186|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|219->190|219->190|219->190|219->190|219->190|219->190|220->191|220->191|220->191|220->191|220->191|220->191|221->192|221->192|221->192|221->192|221->192|221->192|223->194|235->206|235->206|235->206|237->208|241->212|241->212|248->219|248->219|250->221|250->221|252->223|252->223|254->225|254->225|256->227|256->227|260->231|260->231|264->235|264->235|269->240|269->240|273->244|273->244
                    -- GENERATED --
                */
            