
package views.html.patrimonio.remitos

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
object indexRemitos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Remito],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Remito], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/patrimonio/remitos.js"))),format.raw/*8.69*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*9.76*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.125*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*10.2*/("""
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.patrimonio.mainPatrimonio("Lista de remitos", scripts)/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de remitos</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li><a id="reporteDatosRemitosGeneral" href="#" data-url=""""),_display_(Seq[Any](/*24.66*/controllers/*24.77*/.patrimonio.routes.RemitosController.reporteDatosRemitosGeneral())),format.raw/*24.142*/("""">Lista Datos General</a></li>	
						<li><a id="reporteDatosRemitos" href="#" data-url=""""),_display_(Seq[Any](/*25.59*/controllers/*25.70*/.patrimonio.routes.RemitosController.reporteDatosRemitos())),format.raw/*25.128*/("""">Lista Datos</a></li>	
					</ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-cog"></i>	Acciones	<span class="caret"></span>
				</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						"""),_display_(Seq[Any](/*35.8*/if(Permiso.check("cambiarRecepcionDeRemitos"))/*35.54*/ {_display_(Seq[Any](format.raw/*35.56*/("""
						<li role="presentation"><a role="menuitem" id="accionCambiarRecepcion" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*36.112*/controllers/*36.123*/.patrimonio.routes.RemitosController.modalCambiarRecepcion())),format.raw/*36.183*/("""">Cambiar Recepcion</a></li>
						""")))})),format.raw/*37.8*/("""
					</ul>
					 
				</div>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*44.3*/views/*44.8*/.html.tags.successError())),format.raw/*44.33*/("""

"""),_display_(Seq[Any](/*46.2*/helper/*46.8*/.form(action = controllers.patrimonio.routes.RemitosController.index(), 'id -> "buscadorRemitos")/*46.105*/ {_display_(Seq[Any](format.raw/*46.107*/("""
<div class="row">	


	<div class="form-group col-sm-2">
		<label for="numero" class="control-label">Número</label>
		"""),_display_(Seq[Any](/*52.4*/inputText(formBuscador("numero"), 'class -> "form-control", 'numero -> "form-control", 'autofocus -> "autofocus"))),format.raw/*52.117*/("""
		
	</div>
	
	<div class="form-group col-sm-2">
		<label for="numero" class="control-label">Recepción</label>
		"""),_display_(Seq[Any](/*58.4*/inputText(formBuscador("numeroRecepcion"), 'class -> "form-control", 'numero -> "form-control"))),format.raw/*58.99*/("""
		
	</div>
	
	<div class="form-group col-sm-1">
		<label for="nombre" class="control-label">Acta</label>
		"""),_display_(Seq[Any](/*64.4*/inputText(formBuscador("acta"), 'class -> "form-control"))),format.raw/*64.61*/("""
		
	</div>
	
	<div class="form-group col-sm-1">
		<label for="nombre" class="control-label">Op</label>
		"""),_display_(Seq[Any](/*70.4*/inputText(formBuscador("orden_provision"), 'class -> "form-control"))),format.raw/*70.72*/("""
		
	</div>

	<div class="col-sm-2">
		<label class="control-label">Expediente
			<div class="input-group">
				"""),_display_(Seq[Any](/*77.6*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*77.91*/("""
				"""),_display_(Seq[Any](/*78.6*/inputText(formBuscador("expediente"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*78.103*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchExpediente" 
								data-title="Selección de expediente" 
								data-url=""""),_display_(Seq[Any](/*83.20*/controllers/*83.31*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*83.85*/("""" 
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
		<label for="deposito" class="control-label">Institucion</label> 
		<div class="input-group">
			"""),_display_(Seq[Any](/*98.5*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*98.122*/("""
			"""),_display_(Seq[Any](/*99.5*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*99.85*/("""
			<span class="input-group-addon">
               	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
               	data-url=""""),_display_(Seq[Any](/*102.28*/controllers/*102.39*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*102.91*/("""" 
               	data-height="650" data-width="700" 
               	data-listen="modal.seleccion.deposito.simple" 
               	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
               </span>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="checkbox">
			<label class="control-label"> 
				Moneda Extrajera
				"""),_display_(Seq[Any](/*113.6*/checkbox(formBuscador("tipo_moneda")))),format.raw/*113.43*/("""
			</label> 
		</div> 
	</div>
</div>

<div class="row">

	<div class="col-sm-4">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*124.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*124.119*/("""
			"""),_display_(Seq[Any](/*125.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*125.86*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*126.114*/controllers/*126.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*126.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>
	
	<div class="col-sm-4">
		<label class="control-label">Proveedor</label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*133.6*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*133.89*/("""
				"""),_display_(Seq[Any](/*134.6*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*134.108*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedor" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*139.20*/controllers/*139.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*139.82*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.proveedor.simple" 
								data-label="#proveedor" 
								data-field="#proveedor_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		
	</div>
	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha Remito</label>
		<div>
			"""),_display_(Seq[Any](/*154.5*/inputText(formBuscador("fecha_remito_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_remito_desde", 'placeholder -> "Desde"))),format.raw/*154.147*/("""
			"""),_display_(Seq[Any](/*155.5*/inputText(formBuscador("fecha_remito_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_remito_hasta", 'placeholder -> "Hasta"))),format.raw/*155.147*/("""
		</div>
	</div>
	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha Creacion</label>
		<div>
			"""),_display_(Seq[Any](/*161.5*/inputText(formBuscador("create_date_desde"), 'class -> "form-control inputDateMascara", 'id -> "create_date_desde", 'placeholder -> "Desde"))),format.raw/*161.145*/("""
			"""),_display_(Seq[Any](/*162.5*/inputText(formBuscador("create_date_hasta"), 'class -> "form-control inputDateMascara", 'id -> "create_date_hasta", 'placeholder -> "Hasta"))),format.raw/*162.145*/("""
		</div>
	</div>
	
</div>	
<div class="row">	
	<div class="col-sm-4">
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>	
				<a href=""""),_display_(Seq[Any](/*179.15*/controllers/*179.26*/.patrimonio.routes.RemitosController.index())),format.raw/*179.70*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>

	</div>	
	
</div>


""")))})),format.raw/*189.2*/("""


   """),_display_(Seq[Any](/*192.5*/if(buscador.getTotalRowCount == 0)/*192.39*/ {_display_(Seq[Any](format.raw/*192.41*/("""
        
       <div class="well">
           <em>No se encuentran remitos</em>
       </div>
        
    """)))}/*198.7*/else/*198.12*/{_display_(Seq[Any](format.raw/*198.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*200.14*/buscador/*200.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*200.54*/(""" resultado(s).   
		<table id="listaRemitos" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" id="checkAll" class="check_all" data-check=".check_remito" /></th>
					<th>Número</th>
					<th>Institucion</th>
					<th>Recepción</th>
					<th>Acta</th>
					<th>OP</th>
					<th width="80">Expediente</th>
					<th>Proveedor</th>
					<th width="110">Total</th>
					<th width="80">Fecha</th>
					
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*218.12*/for(remito <- buscador.getList) yield /*218.43*/ {_display_(Seq[Any](format.raw/*218.45*/("""
		        	"""),_display_(Seq[Any](/*219.13*/paginadorFicha/*219.27*/.add(remito.id.toString))),format.raw/*219.51*/("""
					<tr class="pointer" data-href=""""),_display_(Seq[Any](/*220.38*/controllers/*220.49*/.patrimonio.routes.RemitosController.ver(remito.id))),format.raw/*220.100*/("""&"""),_display_(Seq[Any](/*220.102*/UriTrack/*220.110*/.encode())),format.raw/*220.119*/("""">
						<td><input name="check_listado[]" value=""""),_display_(Seq[Any](/*221.49*/remito/*221.55*/.id)),format.raw/*221.58*/("""" type="checkbox" class="check_recepcion notSeleccion" /></td>
						<td>"""),_display_(Seq[Any](/*222.12*/remito/*222.18*/.numero)),format.raw/*222.25*/("""</td>
						<td>"""),_display_(Seq[Any](/*223.12*/remito/*223.18*/.recepcion.ordenProvision.ordenCompra.deposito.nombre)),format.raw/*223.71*/("""</td>
						<td class="recep">"""),_display_(Seq[Any](/*224.26*/remito/*224.32*/.recepcion.numero)),format.raw/*224.49*/(""" """),_display_(Seq[Any](/*224.51*/if(remito.recepcion.ordenProvision.ordenCompra.tipo_moneda != null)/*224.118*/{_display_(Seq[Any](format.raw/*224.119*/("""- <span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*224.193*/("""</td>
						<td>"""),_display_(Seq[Any](/*225.12*/if(remito.recepcion.acta != null)/*225.45*/ {_display_(Seq[Any](format.raw/*225.47*/(""" """),_display_(Seq[Any](/*225.49*/remito/*225.55*/.recepcion.acta.numero)),format.raw/*225.77*/(""" """)))})),format.raw/*225.79*/("""</td>
						<td>"""),_display_(Seq[Any](/*226.12*/remito/*226.18*/.recepcion.ordenProvision.numero)),format.raw/*226.50*/("""</td>
						<td>"""),_display_(Seq[Any](/*227.12*/remito/*227.18*/.recepcion.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*227.91*/("""</td>
						<td>"""),_display_(Seq[Any](/*228.12*/remito/*228.18*/.recepcion.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*228.72*/("""</td>
						<td class="total" data-valor=""""),_display_(Seq[Any](/*229.38*/remito/*229.44*/.getTotal())),format.raw/*229.55*/("""">"""),_display_(Seq[Any](/*229.58*/utils/*229.63*/.NumberUtils.moneda(remito.getTotal()))),format.raw/*229.101*/("""</td>
						<td>"""),_display_(Seq[Any](/*230.12*/DateUtils/*230.21*/.formatDate(remito.fecha_remito))),format.raw/*230.53*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*232.7*/{total = total.add(remito.getTotal())})),format.raw/*232.45*/("""
              	""")))})),format.raw/*233.17*/("""
              	"""),_display_(Seq[Any](/*234.17*/paginadorFicha/*234.31*/.guardar())),format.raw/*234.41*/(""" 
			</tbody>
			<tfoot>
				<td colspan="6"></td>
				<td align="right">TOTALES:</td>
				<td class="totalfooter">"""),_display_(Seq[Any](/*239.30*/utils/*239.35*/.NumberUtils.moneda(total))),format.raw/*239.61*/("""</td>
				<td></td>
			</tfoot>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*245.8*/views/*245.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosController.index()))),format.raw/*245.103*/("""
		</div>
        
    """)))})),format.raw/*248.6*/("""
""")))})),format.raw/*249.2*/("""
<script>
$( function() """),format.raw/*251.15*/("""{"""),format.raw/*251.16*/("""
	$('#searchProducto, #searchResponsable, #searchExpediente').modalSearch();
	

	var trs = $('#listaRemitos tbody tr');
	
	$('#checkAll').click( function() """),format.raw/*257.35*/("""{"""),format.raw/*257.36*/("""
		sumarFilas(trs);
	"""),format.raw/*259.2*/("""}"""),format.raw/*259.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*261.55*/("""{"""),format.raw/*261.56*/("""
		sumarFilas( $('#listaRemitos tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*263.2*/("""}"""),format.raw/*263.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*265.27*/("""{"""),format.raw/*265.28*/("""
		var total = 0;  
		trs.each( function() """),format.raw/*267.24*/("""{"""),format.raw/*267.25*/("""
			total += Number($('.total',this).attr("data-valor"));
		"""),format.raw/*269.3*/("""}"""),format.raw/*269.4*/(""");
		
		$(".totalfooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
	"""),format.raw/*272.2*/("""}"""),format.raw/*272.3*/("""
"""),format.raw/*273.1*/("""}"""),format.raw/*273.2*/(""")
</script>

"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Remito],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Remito],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/indexRemitos.scala.html
                    HASH: 214cc07a4839d40b3b514433bf5e94bc38885e72
                    MATRIX: 873->1|1199->326|1213->333|1297->337|1349->354|1363->360|1431->407|1517->458|1531->464|1606->518|1674->185|1706->209|1781->124|1810->253|1840->555|1878->558|1891->563|1960->623|2000->625|2582->1171|2602->1182|2690->1247|2817->1338|2837->1349|2918->1407|3356->1810|3411->1856|3451->1858|3601->1971|3622->1982|3705->2042|3773->2079|3874->2145|3887->2150|3934->2175|3974->2180|3988->2186|4095->2283|4136->2285|4296->2410|4432->2523|4587->2643|4704->2738|4854->2853|4933->2910|5081->3023|5171->3091|5326->3211|5433->3296|5475->3303|5595->3400|5807->3576|5827->3587|5903->3641|6361->4064|6501->4181|6542->4187|6644->4267|6835->4421|6856->4432|6931->4484|7367->4884|7427->4921|7652->5110|7790->5224|7832->5230|7936->5311|8089->5426|8111->5437|8184->5486|8539->5805|8645->5888|8688->5895|8814->5997|9027->6173|9048->6184|9122->6235|9546->6623|9712->6765|9754->6771|9920->6913|10082->7039|10246->7179|10288->7185|10452->7325|10976->7812|10997->7823|11064->7867|11210->7981|11256->7991|11300->8025|11341->8027|11475->8143|11489->8148|11529->8149|11585->8168|11603->8176|11658->8208|12224->8737|12272->8768|12313->8770|12364->8784|12388->8798|12435->8822|12511->8861|12532->8872|12607->8923|12647->8925|12666->8933|12699->8942|12788->8994|12804->9000|12830->9003|12942->9078|12958->9084|12988->9091|13043->9109|13059->9115|13135->9168|13204->9200|13220->9206|13260->9223|13299->9225|13377->9292|13418->9293|13526->9367|13581->9385|13624->9418|13665->9420|13704->9422|13720->9428|13765->9450|13800->9452|13855->9470|13871->9476|13926->9508|13981->9526|13997->9532|14093->9605|14148->9623|14164->9629|14241->9683|14322->9727|14338->9733|14372->9744|14412->9747|14427->9752|14489->9790|14544->9808|14563->9817|14618->9849|14679->9874|14740->9912|14791->9930|14846->9948|14870->9962|14903->9972|15061->10093|15076->10098|15125->10124|15258->10221|15273->10226|15387->10316|15446->10343|15481->10346|15536->10372|15566->10373|15757->10535|15787->10536|15838->10559|15867->10560|15957->10621|15987->10622|16097->10704|16126->10705|16188->10738|16218->10739|16292->10784|16322->10785|16412->10847|16441->10848|16554->10933|16583->10934|16613->10936|16642->10937
                    LINES: 26->1|35->7|35->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|40->5|40->5|41->1|42->5|43->10|44->11|44->11|44->11|44->11|57->24|57->24|57->24|58->25|58->25|58->25|68->35|68->35|68->35|69->36|69->36|69->36|70->37|77->44|77->44|77->44|79->46|79->46|79->46|79->46|85->52|85->52|91->58|91->58|97->64|97->64|103->70|103->70|110->77|110->77|111->78|111->78|116->83|116->83|116->83|131->98|131->98|132->99|132->99|135->102|135->102|135->102|146->113|146->113|157->124|157->124|158->125|158->125|159->126|159->126|159->126|166->133|166->133|167->134|167->134|172->139|172->139|172->139|187->154|187->154|188->155|188->155|194->161|194->161|195->162|195->162|212->179|212->179|212->179|222->189|225->192|225->192|225->192|231->198|231->198|231->198|233->200|233->200|233->200|251->218|251->218|251->218|252->219|252->219|252->219|253->220|253->220|253->220|253->220|253->220|253->220|254->221|254->221|254->221|255->222|255->222|255->222|256->223|256->223|256->223|257->224|257->224|257->224|257->224|257->224|257->224|257->224|258->225|258->225|258->225|258->225|258->225|258->225|258->225|259->226|259->226|259->226|260->227|260->227|260->227|261->228|261->228|261->228|262->229|262->229|262->229|262->229|262->229|262->229|263->230|263->230|263->230|265->232|265->232|266->233|267->234|267->234|267->234|272->239|272->239|272->239|278->245|278->245|278->245|281->248|282->249|284->251|284->251|290->257|290->257|292->259|292->259|294->261|294->261|296->263|296->263|298->265|298->265|300->267|300->267|302->269|302->269|305->272|305->272|306->273|306->273
                    -- GENERATED --
                */
            