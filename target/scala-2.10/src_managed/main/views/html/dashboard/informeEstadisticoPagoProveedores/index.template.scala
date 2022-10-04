
package views.html.dashboard.informeEstadisticoPagoProveedores

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.informes.InformeEstadisticoPagoProveedores],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.informes.InformeEstadisticoPagoProveedores], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*5.2*/getClassEstado/*5.16*/(i:Estado) = {{
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
Seq[Any](format.raw/*1.119*/("""
"""),format.raw/*3.70*/(""" 

"""),format.raw/*18.2*/("""
 
"""),_display_(Seq[Any](/*20.2*/views/*20.7*/.html.dashboard.mainDashboard(title = "Informe estadístico")/*20.67*/ {_display_(Seq[Any](format.raw/*20.69*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Informe estadístico de pago a proveedores</h1>
		</div>

		<div class="col-sm-3">
			<a id="generarArchivo" href=""""),_display_(Seq[Any](/*29.34*/controllers/*29.45*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.archivoEstadistico())),format.raw/*29.127*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-download-alt"></i> Generar archivo</a>
		</div>

	</div>
</div>


<script>

$( function() """),format.raw/*38.15*/("""{"""),format.raw/*38.16*/("""
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
	
	/*
	$('#generarArchivo').click( function() """),format.raw/*43.41*/("""{"""),format.raw/*43.42*/("""
		
		var href = $(this).attr('href') + '?descarga=&' + escape(window.location.href.slice(window.location.href.indexOf('?') + 1).split('&'));
		alert(href);
		window.location = href;
		return false;
	"""),format.raw/*49.2*/("""}"""),format.raw/*49.3*/(""");
	*/
"""),format.raw/*51.1*/("""}"""),format.raw/*51.2*/(""");

</script>




"""),_display_(Seq[Any](/*58.2*/if(flash.containsKey("success"))/*58.34*/ {_display_(Seq[Any](format.raw/*58.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*59.80*/flash/*59.85*/.get("success"))),format.raw/*59.100*/("""</div>
""")))})),format.raw/*60.2*/("""
"""),_display_(Seq[Any](/*61.2*/if(flash.containsKey("error"))/*61.32*/ {_display_(Seq[Any](format.raw/*61.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*62.83*/flash/*62.88*/.get("error"))),format.raw/*62.101*/("""</div>
""")))})),format.raw/*63.2*/(""" 


    <form action="" method="GET" id="filtroInforme">
    	<div class="row">
			<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
				<div class="btn-group">
				  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-pencil"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*72.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*72.68*/("""
				  </button>
				  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>En Curso
				  	"""),_display_(Seq[Any](/*76.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*76.68*/("""
				  </button>
				  <button type="button" rel="entregado" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-usd glyphicon-usd-green"></i><br>Pagado
				  	"""),_display_(Seq[Any](/*80.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*80.68*/("""
				  </button>
				  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-ok"></i><br>Conciliado
				  	"""),_display_(Seq[Any](/*84.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*84.68*/("""
				  </button>
				  <button type="button" rel="cancelada" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado
				  	"""),_display_(Seq[Any](/*88.9*/checkbox(formBuscador("btnFiltro[4]"), 'hidden -> "hidden"))),format.raw/*88.68*/("""
				  </button>
				</div>
			</div>
		</div>
		<div class="row seccion">
			<div class="col-sm-4">
				<label class="control-label">Proveedor
					<div class="input-group">	
						"""),_display_(Seq[Any](/*97.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*97.137*/("""
						"""),_display_(Seq[Any](/*98.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*98.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*103.22*/controllers/*103.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*103.84*/("""" 
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
						"""),_display_(Seq[Any](/*119.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*119.112*/("""
						"""),_display_(Seq[Any](/*120.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*120.93*/("""
						
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*126.22*/controllers/*126.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*126.87*/("""" 
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
					"""),_display_(Seq[Any](/*141.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*141.166*/("""
				
			</div>	
			
		<div class="col-sm-2">
			<div class="seleccionOrdenRubro">
				<label for=""""),_display_(Seq[Any](/*147.18*/formBuscador("rubro_id")/*147.42*/.id)),format.raw/*147.45*/("""" class="control-label">Rubro</label>
				"""),_display_(Seq[Any](/*148.6*/select(formBuscador("rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*149.126*/("""
			</div>
		</div>

		 
			
	</div>
	
	<div class="row">
	
		 
				
		 	
		 <div class="col-sm-2 input-group">
			<label class="control-label">Fecha Pago</label>
			<div>
				"""),_display_(Seq[Any](/*165.6*/inputText(formBuscador("fecha_pago_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_desde", 'placeholder -> "Desde"))),format.raw/*165.144*/("""
				"""),_display_(Seq[Any](/*166.6*/inputText(formBuscador("fecha_pago_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_hasta", 'placeholder -> "Hasta"))),format.raw/*166.144*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*172.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*172.123*/("""
				"""),_display_(Seq[Any](/*173.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*173.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*176.29*/controllers/*176.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*176.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
		</div>	
				
		<!-- <div class="col-sm-2">
			<label class="control-label"> 
				PROFE
				"""),_display_(Seq[Any](/*187.6*/select(formBuscador("profe"),options(""->"Todos","si"->"SI","no"->"NO"), 'class -> "form-control select"))),format.raw/*187.111*/("""
			</label>
		</div> -->
		<div class="col-sm-2 input-group">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*193.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*194.126*/("""
			</label>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label"> 
				Impuesto
				"""),_display_(Seq[Any](/*201.6*/select(formBuscador("impuesto"),options(""->"Todos","si"->"SI","no"->"NO"), 'class -> "form-control select"))),format.raw/*201.114*/("""
			</label>
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
			<a href=""""),_display_(Seq[Any](/*214.14*/controllers/*214.25*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.index())),format.raw/*214.94*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
			
		</div>
    </form>
    """),_display_(Seq[Any](/*220.6*/if(buscador.getTotalRowCount == 0)/*220.40*/ {_display_(Seq[Any](format.raw/*220.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*226.7*/else/*226.12*/{_display_(Seq[Any](format.raw/*226.13*/("""
		 
		<table class="table table-striped table-bordered" id="listaInforme">
			<thead>
				<tr style="background: #FFFFFF;">
					<td colspan="5">
						Mostrando """),_display_(Seq[Any](/*232.18*/buscador/*232.26*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*232.58*/(""" resultado(s).  
					</td>
					<td><b>Total:</b><br /><span class="totalFooter"></span></td>
					<td></td>
				</tr>
				<tr>
					<th>Fecha</th> 
					<th>Proveedor</th> 
					<th width="60">Expediente</th>
					<th width="130">Rubro</th>
					<th width="80">Inst.</th>
					<th width="90">Pagado</th>
					<th width="90">Estado</th> 
					
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*249.12*/for(informe <- buscador.getList) yield /*249.44*/ {_display_(Seq[Any](format.raw/*249.46*/("""
				<tr class=""""),_display_(Seq[Any](/*250.17*/getClassEstado(informe.estado))),format.raw/*250.47*/("""">
					<td>"""),_display_(Seq[Any](/*251.11*/if(informe.fecha_pago != null)/*251.41*/{_display_(Seq[Any](_display_(Seq[Any](/*251.43*/(utils.DateUtils.formatDate(informe.fecha_pago))))))})),format.raw/*251.92*/("""</td>
					<td>"""),_display_(Seq[Any](/*252.11*/informe/*252.18*/.proveedor.nombre)),format.raw/*252.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*253.11*/informe/*253.18*/.expediente.getExpedienteEjercicio())),format.raw/*253.54*/("""</td>  
					<td>"""),_display_(Seq[Any](/*254.11*/if(informe.ordenRubro != null)/*254.41*/{_display_(Seq[Any](_display_(Seq[Any](/*254.43*/informe/*254.50*/.ordenRubro.nombre))))})),format.raw/*254.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*255.11*/if(informe.deposito != null)/*255.39*/{_display_(Seq[Any](_display_(Seq[Any](/*255.41*/informe/*255.48*/.deposito.nombre))))})),format.raw/*255.65*/("""</td>
					<td  class="total" data-valor=""""),_display_(Seq[Any](/*256.38*/informe/*256.45*/.total)),format.raw/*256.51*/("""">"""),_display_(Seq[Any](/*256.54*/utils/*256.59*/.NumberUtils.moneda(informe.total))),format.raw/*256.93*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*257.26*/(informe.estado.nombre))),format.raw/*257.49*/("""</td>
				</tr>
		        """)))})),format.raw/*259.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"></td>
					<td><b>Total:</b><br /><span class="totalFooter"></span></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*270.8*/views/*270.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.InformeEstadisticoPagoProveedoresController.index()))),format.raw/*270.128*/("""
		</div>
	""")))})),format.raw/*272.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*276.16*/("""{"""),format.raw/*276.17*/("""
		$('#searchExpediente, #searchProveedor,#searchDeposito').modalSearch();
		
		$('#filtrosEstados button').click( function() """),format.raw/*279.49*/("""{"""),format.raw/*279.50*/("""
			var checkbox = $(this).find(':checkbox');
			checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
			$(this).closest('form').submit();
		"""),format.raw/*283.3*/("""}"""),format.raw/*283.4*/(""");
		
		$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
		
		var trs = $('#listaInforme tbody tr');

		var total = 0; 
		trs.each( function() """),format.raw/*290.24*/("""{"""),format.raw/*290.25*/("""
			total += Number($('.total',this).attr("data-valor")); 
		"""),format.raw/*292.3*/("""}"""),format.raw/*292.4*/(""");

		$(".totalFooter").html(formatNumberPesos(parseFloat(total).toFixed(2))); 
		
	"""),format.raw/*296.2*/("""}"""),format.raw/*296.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.informes.InformeEstadisticoPagoProveedores],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.informes.InformeEstadisticoPagoProveedores],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoPagoProveedores/index.scala.html
                    HASH: 3338c457ce952e10780f2d93009cc1e8e4bcae3c
                    MATRIX: 902->1|1122->139|1154->163|1211->213|1233->227|1600->118|1629->207|1661->563|1702->569|1715->574|1784->634|1824->636|2067->843|2087->854|2192->936|2376->1092|2405->1093|2662->1322|2691->1323|2924->1529|2952->1530|2988->1539|3016->1540|3077->1566|3118->1598|3158->1600|3275->1681|3289->1686|3327->1701|3367->1710|3405->1713|3444->1743|3484->1745|3604->1829|3618->1834|3654->1847|3694->1856|4058->2185|4139->2244|4349->2419|4430->2478|4652->2665|4733->2724|4937->2893|5018->2952|5230->3129|5311->3188|5538->3380|5690->3509|5734->3518|5839->3601|6062->3787|6083->3798|6157->3849|6624->4280|6752->4384|6797->4393|6905->4478|7136->4672|7157->4683|7234->4737|7681->5148|7864->5307|8007->5413|8041->5437|8067->5440|8147->5484|8331->5644|8560->5837|8722->5975|8765->5982|8927->6120|9116->6273|9257->6390|9300->6397|9403->6477|9597->6634|9618->6645|9693->6697|10111->7079|10240->7184|10400->7308|10590->7474|10735->7583|10867->7691|11267->8054|11288->8065|11380->8134|11523->8241|11567->8275|11608->8277|11748->8399|11762->8404|11802->8405|12009->8575|12027->8583|12082->8615|12525->9021|12574->9053|12615->9055|12670->9073|12723->9103|12774->9117|12814->9147|12863->9149|12939->9198|12993->9215|13010->9222|13050->9239|13104->9256|13121->9263|13180->9299|13236->9318|13276->9348|13325->9350|13342->9357|13388->9376|13442->9393|13480->9421|13529->9423|13546->9430|13590->9447|13671->9491|13688->9498|13717->9504|13757->9507|13772->9512|13829->9546|13898->9578|13944->9601|14006->9630|14273->9861|14288->9866|14427->9981|14473->9995|14558->10051|14588->10052|14746->10181|14776->10182|14992->10370|15021->10371|15228->10549|15258->10550|15349->10613|15378->10614|15494->10702|15523->10703
                    LINES: 26->1|29->3|29->3|29->5|29->5|43->1|44->3|46->18|48->20|48->20|48->20|48->20|57->29|57->29|57->29|66->38|66->38|71->43|71->43|77->49|77->49|79->51|79->51|86->58|86->58|86->58|87->59|87->59|87->59|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|100->72|100->72|104->76|104->76|108->80|108->80|112->84|112->84|116->88|116->88|125->97|125->97|126->98|126->98|131->103|131->103|131->103|147->119|147->119|148->120|148->120|154->126|154->126|154->126|169->141|169->141|175->147|175->147|175->147|176->148|177->149|193->165|193->165|194->166|194->166|200->172|200->172|201->173|201->173|204->176|204->176|204->176|215->187|215->187|221->193|222->194|229->201|229->201|242->214|242->214|242->214|248->220|248->220|248->220|254->226|254->226|254->226|260->232|260->232|260->232|277->249|277->249|277->249|278->250|278->250|279->251|279->251|279->251|279->251|280->252|280->252|280->252|281->253|281->253|281->253|282->254|282->254|282->254|282->254|282->254|283->255|283->255|283->255|283->255|283->255|284->256|284->256|284->256|284->256|284->256|284->256|285->257|285->257|287->259|298->270|298->270|298->270|300->272|304->276|304->276|307->279|307->279|311->283|311->283|318->290|318->290|320->292|320->292|324->296|324->296
                    -- GENERATED --
                */
            