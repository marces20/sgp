
package views.html.recupero.recuperoPago.cheques

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
object indexCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[models.recupero.Cheque],Boolean,models.recupero.Cheque,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[models.recupero.Cheque], editable: Boolean,rf:models.recupero.Cheque):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.112*/("""
<div id="listaCheques" class="contenedorPaginador ajaxPaginador">

<div class="panel panel-default">
		<div class="panel-heading">
			 """),_display_(Seq[Any](/*6.6*/if(editable)/*6.18*/{_display_(Seq[Any](format.raw/*6.19*/("""
				<a class="btn btn-default btn-xs" href="#" id="nuevoCheque"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
			 """)))})),format.raw/*8.6*/("""
		</div>
		<div class="panel-body">
			"""),_display_(Seq[Any](/*11.5*/if(paginador.getTotalRowCount == 0)/*11.40*/ {_display_(Seq[Any](format.raw/*11.42*/("""
        		<p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay cheques</p>
    		""")))})),format.raw/*13.8*/(""" 
						
					   
			<table id="listaChequesTabla" class="table table-striped table-bordered """),_display_(Seq[Any](/*16.77*/if(paginador.getTotalRowCount() <= 0)/*16.114*/{_display_(Seq[Any](format.raw/*16.115*/("""hide""")))})),format.raw/*16.120*/("""">
				<thead>
					<tr>
						 """),_display_(Seq[Any](/*19.9*/if(editable)/*19.21*/{_display_(Seq[Any](format.raw/*19.22*/("""
						<th class="accion-editar">#</th>
						""")))})),format.raw/*21.8*/("""
						<th>Numero</th>
						<th>Fecha</th>
						<th>Banco</th>
						<th>Sucursal</th>
						<th>Monto</th>
						<th>Observaciones</th>
						 """),_display_(Seq[Any](/*28.9*/if(editable)/*28.21*/{_display_(Seq[Any](format.raw/*28.22*/("""
						<th>#</th>
						""")))})),format.raw/*30.8*/("""
					<tr>	
				</thead>
				<tbody>
				"""),_display_(Seq[Any](/*34.6*/for(linea <- paginador.getList) yield /*34.37*/ {_display_(Seq[Any](format.raw/*34.39*/("""
					"""),_display_(Seq[Any](/*35.7*/views/*35.12*/.html.recupero.recuperoPago.cheques.lineaCheque(linea, editable))),format.raw/*35.76*/("""
				""")))})),format.raw/*36.6*/("""
				</tbody>
			</table>

			<div class="pagination pull-right">		
			    """),_display_(Seq[Any](/*41.9*/views/*41.14*/.html.helpers.paginador(paginador, controllers.recupero.routes.RecuperoChequesController.index()))),format.raw/*41.111*/("""
			</div>
	</div>
</div>
<script>
$( function()"""),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaCheques");

	contenedor.on('click', '#nuevoCheque', function()"""),format.raw/*53.51*/("""{"""),format.raw/*53.52*/("""
		urlContenidoModal = '/recupero/pago/cheques/crear?pagoId='+$('#recuperoPagoId').val();
							
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*58.2*/("""}"""),format.raw/*58.3*/(""");
	
	contenedor.on('click', '.modificarCheque', function()"""),format.raw/*60.55*/("""{"""),format.raw/*60.56*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar cheque');	
		return false;
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/(""");
	
	contenedor.on('click', '.eliminarCheque', function()"""),format.raw/*67.54*/("""{"""),format.raw/*67.55*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*69.23*/("""{"""),format.raw/*69.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*72.29*/("""{"""),format.raw/*72.30*/("""
				if(data.success)"""),format.raw/*73.21*/("""{"""),format.raw/*73.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*75.5*/("""}"""),format.raw/*75.6*/(""" else """),format.raw/*75.12*/("""{"""),format.raw/*75.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""
			"""),format.raw/*78.4*/("""}"""),format.raw/*78.5*/(""");
		"""),format.raw/*79.3*/("""}"""),format.raw/*79.4*/("""
		return false;
	"""),format.raw/*81.2*/("""}"""),format.raw/*81.3*/(""");
	
	
	function mostrarModal(url)"""),format.raw/*84.28*/("""{"""),format.raw/*84.29*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*85.49*/("""{"""),format.raw/*85.50*/("""
			resizable: false,
		    title: "Cargar cheque",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*91.35*/("""{"""),format.raw/*91.36*/("""
				$.get(url, function(data)"""),format.raw/*92.30*/("""{"""),format.raw/*92.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""");
		    """),format.raw/*95.7*/("""}"""),format.raw/*95.8*/(""",
		    close: function(event, ui )"""),format.raw/*96.34*/("""{"""),format.raw/*96.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*98.4*/("""}"""),format.raw/*98.5*/("""
		  """),format.raw/*99.5*/("""}"""),format.raw/*99.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*101.58*/("""{"""),format.raw/*101.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*104.3*/("""}"""),format.raw/*104.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*106.47*/("""{"""),format.raw/*106.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*109.42*/("""{"""),format.raw/*109.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*110.45*/("""{"""),format.raw/*110.46*/("""
				 
					$('#listaChequesTabla tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaChequesTabla').removeClass('hide');
					modalCargaProductos.dialog( "destroy" );
					
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*117.56*/("""{"""),format.raw/*117.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*120.5*/("""}"""),format.raw/*120.6*/(""" else """),format.raw/*120.12*/("""{"""),format.raw/*120.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*122.5*/("""}"""),format.raw/*122.6*/("""
			"""),format.raw/*123.4*/("""}"""),format.raw/*123.5*/(""");
			return false;
		"""),format.raw/*125.3*/("""}"""),format.raw/*125.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*129.2*/("""}"""),format.raw/*129.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*132.49*/("""{"""),format.raw/*132.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*135.38*/("""{"""),format.raw/*135.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*137.3*/("""}"""),format.raw/*137.4*/(""");
		return false;
	"""),format.raw/*139.2*/("""}"""),format.raw/*139.3*/(""");
"""),format.raw/*140.1*/("""}"""),format.raw/*140.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[models.recupero.Cheque],editable:Boolean,rf:models.recupero.Cheque): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,rf)
    
    def f:((utils.pagination.Pagination[models.recupero.Cheque],Boolean,models.recupero.Cheque) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,rf) => apply(paginador,editable,rf)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/indexCheque.scala.html
                    HASH: 28bc930bc665a90d10654491b4ad342d29249399
                    MATRIX: 886->1|1091->111|1262->248|1282->260|1320->261|1474->385|1550->426|1594->461|1634->463|1790->588|1920->682|1967->719|2007->720|2045->725|2113->758|2134->770|2173->771|2251->818|2433->965|2454->977|2493->978|2549->1003|2626->1045|2673->1076|2713->1078|2755->1085|2769->1090|2855->1154|2892->1160|3003->1236|3017->1241|3137->1338|3213->1386|3242->1387|3424->1541|3453->1542|3630->1692|3658->1693|3745->1752|3774->1753|3965->1917|3993->1918|4079->1976|4108->1977|4220->2061|4249->2062|4361->2146|4390->2147|4439->2168|4468->2169|4535->2209|4563->2210|4597->2216|4626->2217|4707->2271|4735->2272|4766->2276|4794->2277|4826->2282|4854->2283|4899->2301|4927->2302|4989->2336|5018->2337|5095->2386|5124->2387|5294->2529|5323->2530|5381->2560|5410->2561|5479->2603|5507->2604|5543->2613|5571->2614|5634->2649|5663->2650|5740->2700|5768->2701|5800->2706|5828->2707|5920->2770|5950->2771|6040->2833|6069->2834|6150->2886|6180->2887|6332->3010|6362->3011|6436->3056|6466->3057|6709->3272|6738->3273|6817->3323|6847->3324|6979->3428|7008->3429|7043->3435|7073->3436|7148->3483|7177->3484|7209->3488|7238->3489|7288->3511|7317->3512|7385->3552|7414->3553|7496->3606|7526->3607|7664->3716|7694->3717|7760->3755|7789->3756|7837->3776|7866->3777|7897->3780|7926->3781
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|39->11|39->11|39->11|41->13|44->16|44->16|44->16|44->16|47->19|47->19|47->19|49->21|56->28|56->28|56->28|58->30|62->34|62->34|62->34|63->35|63->35|63->35|64->36|69->41|69->41|69->41|74->46|74->46|81->53|81->53|86->58|86->58|88->60|88->60|93->65|93->65|95->67|95->67|97->69|97->69|100->72|100->72|101->73|101->73|103->75|103->75|103->75|103->75|105->77|105->77|106->78|106->78|107->79|107->79|109->81|109->81|112->84|112->84|113->85|113->85|119->91|119->91|120->92|120->92|122->94|122->94|123->95|123->95|124->96|124->96|126->98|126->98|127->99|127->99|129->101|129->101|132->104|132->104|134->106|134->106|137->109|137->109|138->110|138->110|145->117|145->117|145->117|145->117|148->120|148->120|148->120|148->120|150->122|150->122|151->123|151->123|153->125|153->125|157->129|157->129|160->132|160->132|163->135|163->135|165->137|165->137|167->139|167->139|168->140|168->140
                    -- GENERATED --
                */
            