
package views.html.patrimonio.baul.lineas

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
object indexProductoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[RemitoLineaBaul],DynamicForm,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[RemitoLineaBaul], formBuscador: DynamicForm, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.106*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/if(formBuscador.field("remito_id").value == null || formBuscador.field("remito_id").value == "")/*5.98*/{_display_(Seq[Any](format.raw/*5.99*/("""
	<p>Para cargar productos primero debe dar de alta el remito</p>
""")))}/*7.3*/else/*7.8*/{_display_(Seq[Any](format.raw/*7.9*/("""

<div id="listaremito" class="contenedorPaginador ajaxPaginador">
		
	"""),_display_(Seq[Any](/*11.3*/if(editable && Permiso.check("remitosCrear"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/("""
		<a class="btn btn-default btn-xs" href="#" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Agregar producto</a>	 	
	""")))})),format.raw/*13.3*/("""	
		
		
	"""),_display_(Seq[Any](/*16.3*/if(paginador.getTotalRowCount == 0)/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
        <p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay productos cargados.</p>
    """)))})),format.raw/*18.6*/(""" 

	<table id="listaDeremito" class="table table-striped table-bordered  """),_display_(Seq[Any](/*20.72*/if(paginador.getTotalRowCount() <= 0)/*20.109*/{_display_(Seq[Any](format.raw/*20.110*/("""hide""")))})),format.raw/*20.115*/("""">
		<thead>
			<tr>
				"""),_display_(Seq[Any](/*23.6*/if(editable && Permiso.check("remitosEliminar"))/*23.54*/{_display_(Seq[Any](format.raw/*23.55*/("""
					<th width="50" class="accion-editar">#</th>
				""")))})),format.raw/*25.6*/("""
					<th>Producto</th>
					<th  width="40">Cantidad</th>
					
				"""),_display_(Seq[Any](/*29.6*/if(editable && Permiso.check("remitosEliminar"))/*29.54*/{_display_(Seq[Any](format.raw/*29.55*/("""
					<th></th>
				""")))})),format.raw/*31.6*/("""
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*35.4*/for(linea <- paginador.getList) yield /*35.35*/ {_display_(Seq[Any](format.raw/*35.37*/("""
			"""),_display_(Seq[Any](/*36.5*/views/*36.10*/.html.patrimonio.baul.lineas.lineasProductoBaul(linea, editable))),format.raw/*36.74*/("""
		""")))})),format.raw/*37.4*/("""
		</tbody>
	</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*44.9*/views/*44.14*/.html.helpers.paginador(paginador, controllers.patrimonio.routes.RemitosLineasBaulController.index()))),format.raw/*44.115*/("""
			</div>
		</div>

<script>
$( function()"""),format.raw/*49.14*/("""{"""),format.raw/*49.15*/("""
	 
	 
	var contenedor = $("#listaremito");
						     
	contenedor.on('click', '#nuevoProducto', function()"""),format.raw/*54.53*/("""{"""),format.raw/*54.54*/("""
		
		urlContenidoModal =  '"""),_display_(Seq[Any](/*56.26*/controllers/*56.37*/.patrimonio.routes.RemitosLineasBaulController.crear(formBuscador.field("remito_id").value.toLong))),format.raw/*56.135*/("""';
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/(""");
	
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*61.57*/("""{"""),format.raw/*61.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar producto');	
		return false;
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*68.56*/("""{"""),format.raw/*68.57*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*70.23*/("""{"""),format.raw/*70.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*73.29*/("""{"""),format.raw/*73.30*/("""
				if(data.success)"""),format.raw/*74.21*/("""{"""),format.raw/*74.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*76.5*/("""}"""),format.raw/*76.6*/(""" else """),format.raw/*76.12*/("""{"""),format.raw/*76.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*78.5*/("""}"""),format.raw/*78.6*/("""
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/(""");
		"""),format.raw/*80.3*/("""}"""),format.raw/*80.4*/("""
		return false;
	"""),format.raw/*82.2*/("""}"""),format.raw/*82.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*84.28*/("""{"""),format.raw/*84.29*/("""
		modalCargaremito = $('<div></div>').dialog("""),format.raw/*85.46*/("""{"""),format.raw/*85.47*/("""
			resizable: false,
		    title: "Cargar productos",
		    height: 600,
		    minHeight:600,
		    width: 800,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""
				$.get(url, function(data)"""),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
					modalCargaremito.html(data);
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
		    """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""",
		    close: function(event, ui )"""),format.raw/*97.34*/("""{"""),format.raw/*97.35*/("""
		    	modalCargaremito.dialog('destroy');
			"""),format.raw/*99.4*/("""}"""),format.raw/*99.5*/("""
		  """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");
		
		modalCargaremito.on('click', '.cancelar', function()"""),format.raw/*102.55*/("""{"""),format.raw/*102.56*/("""
			modalCargaremito.dialog('destroy');
			return false;
		"""),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");
		
		modalCargaremito.on('submit', function(e)"""),format.raw/*107.44*/("""{"""),format.raw/*107.45*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*111.45*/("""{"""),format.raw/*111.46*/("""
					$('#listaDeremito tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaDeremito').removeClass('hide');
					modalCargaremito.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*117.56*/("""{"""),format.raw/*117.57*/("""
					lineaParaEditar.replaceWith(resultado.html);
					modalCargaremito.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*122.5*/("""}"""),format.raw/*122.6*/(""" else """),format.raw/*122.12*/("""{"""),format.raw/*122.13*/("""
					modalCargaremito.html(resultado);
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/("""
			"""),format.raw/*125.4*/("""}"""),format.raw/*125.5*/(""");
			return false;
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/(""");
		
		
		return modalCargaremito;
	"""),format.raw/*131.2*/("""}"""),format.raw/*131.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*134.49*/("""{"""),format.raw/*134.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*137.38*/("""{"""),format.raw/*137.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*139.3*/("""}"""),format.raw/*139.4*/(""");
		return false;
	"""),format.raw/*141.2*/("""}"""),format.raw/*141.3*/(""");
"""),format.raw/*142.1*/("""}"""),format.raw/*142.2*/(""");
</script>

""")))})),format.raw/*145.2*/("""
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[RemitoLineaBaul],formBuscador:DynamicForm,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,formBuscador,editable)
    
    def f:((utils.pagination.Pagination[RemitoLineaBaul],DynamicForm,Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,formBuscador,editable) => apply(paginador,formBuscador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/lineas/indexProductoBaul.scala.html
                    HASH: 72dcd5d6ed67775a16799f4b9a00e11d6138dd5d
                    MATRIX: 867->1|1088->105|1116->130|1155->135|1259->231|1297->232|1383->302|1394->307|1431->308|1542->384|1596->429|1635->430|1800->564|1848->577|1892->612|1932->614|2098->749|2210->825|2257->862|2297->863|2335->868|2399->897|2456->945|2495->946|2583->1003|2692->1077|2749->1125|2788->1126|2842->1149|2915->1187|2962->1218|3002->1220|3043->1226|3057->1231|3143->1295|3179->1300|3295->1381|3309->1386|3433->1487|3509->1535|3538->1536|3679->1649|3708->1650|3775->1681|3795->1692|3916->1790|4001->1848|4029->1849|4120->1912|4149->1913|4347->2084|4375->2085|4465->2147|4494->2148|4608->2234|4637->2235|4752->2322|4781->2323|4831->2345|4860->2346|4929->2388|4957->2389|4991->2395|5020->2396|5103->2452|5131->2453|5163->2458|5191->2459|5224->2465|5252->2466|5299->2486|5327->2487|5389->2521|5418->2522|5493->2569|5522->2570|5723->2743|5752->2744|5811->2775|5840->2776|5908->2817|5936->2818|5973->2828|6001->2829|6065->2865|6094->2866|6170->2915|6198->2916|6232->2922|6261->2923|6352->2985|6382->2986|6472->3048|6501->3049|6581->3100|6611->3101|6766->3227|6796->3228|6871->3274|6901->3275|7175->3521|7204->3522|7283->3572|7313->3573|7494->3726|7523->3727|7558->3733|7588->3734|7662->3780|7691->3781|7724->3786|7753->3787|7805->3811|7834->3812|7903->3853|7932->3854|8017->3910|8047->3911|8188->4023|8218->4024|8286->4064|8315->4065|8365->4087|8394->4088|8426->4092|8455->4093|8505->4111
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|41->13|44->16|44->16|44->16|46->18|48->20|48->20|48->20|48->20|51->23|51->23|51->23|53->25|57->29|57->29|57->29|59->31|63->35|63->35|63->35|64->36|64->36|64->36|65->37|72->44|72->44|72->44|77->49|77->49|82->54|82->54|84->56|84->56|84->56|87->59|87->59|89->61|89->61|94->66|94->66|96->68|96->68|98->70|98->70|101->73|101->73|102->74|102->74|104->76|104->76|104->76|104->76|106->78|106->78|107->79|107->79|108->80|108->80|110->82|110->82|112->84|112->84|113->85|113->85|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|130->102|130->102|133->105|133->105|135->107|135->107|138->110|138->110|139->111|139->111|145->117|145->117|145->117|145->117|150->122|150->122|150->122|150->122|152->124|152->124|153->125|153->125|155->127|155->127|159->131|159->131|162->134|162->134|165->137|165->137|167->139|167->139|169->141|169->141|170->142|170->142|173->145
                    -- GENERATED --
                */
            