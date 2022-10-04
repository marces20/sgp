
package views.html.patrimonio.lineasRemitos

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
object enRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[RemitoLinea],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[RemitoLinea], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*5.70*/(""" 
<div class="contenedorPaginador ajaxPaginador">



<div id="filtroBuscador" class="row">	
	"""),_display_(Seq[Any](/*11.3*/helper/*11.9*/.form(action = controllers.patrimonio.routes.RemitosLineasController.index(), 'id -> "buscadorLineasRemitos")/*11.118*/ {_display_(Seq[Any](format.raw/*11.120*/("""	
		"""),_display_(Seq[Any](/*12.4*/inputText(formBuscador("id_remito"), 'type -> "hidden", 'id -> "idRemito"))),format.raw/*12.78*/("""
	
		<div class="col-sm-5">
			<label for="producto" class="control-label">Producto</label>
			"""),_display_(Seq[Any](/*16.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "productoLinea"))),format.raw/*16.124*/("""
		</div>
		
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*25.3*/("""
</div>



   """),_display_(Seq[Any](/*30.5*/if(buscador.getTotalRowCount == 0)/*30.39*/ {_display_(Seq[Any](format.raw/*30.41*/("""
        
       <div class="well">
           <em>No se encuentran productos en este remitos.</em>
       </div>
        
    """)))}/*36.7*/else/*36.12*/{_display_(Seq[Any](format.raw/*36.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*38.14*/buscador/*38.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*38.54*/(""" resultado(s).   
		<table id="listaProductos" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th width="50">UDM</th>	
					<th width="100">Precio</th>
					<th width="275">Cantidad</th>	
								
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*50.12*/for(linea <- buscador.getList) yield /*50.42*/ {_display_(Seq[Any](format.raw/*50.44*/("""
				<tr class="pointer" style=""""),_display_(Seq[Any](/*51.33*/if(CuentaAnalitica.getCuentasParaInventario().contains(linea.lineaOrden.cuenta_analitica_id.toInt))/*51.132*/ {_display_(Seq[Any](format.raw/*51.134*/("""color:blue""")))})),format.raw/*51.145*/("""">
					<td>"""),_display_(Seq[Any](/*52.11*/linea/*52.16*/.lineaOrden.producto.nombre)),format.raw/*52.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*53.11*/linea/*53.16*/.lineaOrden.udm.nombre)),format.raw/*53.38*/("""</td>
					<td>"""),_display_(Seq[Any](/*54.11*/utils/*54.16*/.NumberUtils.moneda(linea.lineaOrden.precio))),format.raw/*54.60*/("""</td>
					<td>
						<input class="remito_id" type="hidden" value=""""),_display_(Seq[Any](/*56.54*/linea/*56.59*/.remito_id)),format.raw/*56.69*/("""" name="remito_id" />
						<input class="linea_orden_id" type="hidden" value=""""),_display_(Seq[Any](/*57.59*/linea/*57.64*/.linea_orden_id)),format.raw/*57.79*/("""" name="linea_orden__id" />
						<input class="id" type="hidden" value=""""),_display_(Seq[Any](/*58.47*/linea/*58.52*/.id)),format.raw/*58.55*/("""" name="id" /> 
						<input class="cantidad" type="text" name="cantidad" value=""""),_display_(Seq[Any](/*59.67*/linea/*59.72*/.cantidad)),format.raw/*59.81*/("""" style="width: 60px" /> 
						<button class="agregar"><i class="glyphicon glyphicon-ok-sign"></i></button> 
						
						"""),_display_(Seq[Any](/*62.8*/if(CuentaAnalitica.getCuentasParaInventario().contains(linea.lineaOrden.cuenta_analitica_id.toInt))/*62.107*/{_display_(Seq[Any](format.raw/*62.108*/("""
						<button class="agregarNumeroInventario" data-url=""""),_display_(Seq[Any](/*63.58*/controllers/*63.69*/.patrimonio.routes.InventarioController.registrarModal(linea.id))),format.raw/*63.133*/(""""><i class="glyphicon glyphicon-barcode"></i></button> 
						""")))})),format.raw/*64.8*/("""
						"""),_display_(Seq[Any](/*65.8*/if(Permiso.check("remitosEliminar"))/*65.44*/ {_display_(Seq[Any](format.raw/*65.46*/("""
							<button style="margin-left: 20px" class="eliminarLinea pull-right" data-href=""""),_display_(Seq[Any](/*66.87*/controllers/*66.98*/.patrimonio.routes.RemitosLineasController.eliminar(linea.id))),format.raw/*66.159*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></button>
						""")))})),format.raw/*67.8*/("""
					</td>
				</tr>
              	""")))})),format.raw/*70.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*75.8*/views/*75.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosLineasController.enRemito()))),format.raw/*75.112*/("""
		</div>
        
    """)))})),format.raw/*78.6*/("""
</div>


<script>
$( function() """),format.raw/*83.15*/("""{"""),format.raw/*83.16*/("""

	$('#listaProductos tbody tr .cantidad').keypress(function(e) """),format.raw/*85.63*/("""{"""),format.raw/*85.64*/("""
		var btn = $(this).closest('tr').find('.agregar');
	    if(e.which == 13) """),format.raw/*87.24*/("""{"""),format.raw/*87.25*/("""
	    	btn.click();
	    """),format.raw/*89.6*/("""}"""),format.raw/*89.7*/("""
	"""),format.raw/*90.2*/("""}"""),format.raw/*90.3*/(""");
	
	$('#listaProductos tbody tr .agregar').click( function()"""),format.raw/*92.58*/("""{"""),format.raw/*92.59*/("""
		$this = $(this);
		var tr = $(this).closest('tr');
		var inputAgregar = tr.find('.cantidad');
		inputAgregar.prop('disabled', true);
		$this.prop('disabled', true);
		var cantidad = inputAgregar.val();
		
		var id = tr.find('.id').val();
		var remito_id = tr.find('.remito_id').val();
		var linea_orden_id = tr.find('.linea_orden_id').val();
		$.post('"""),_display_(Seq[Any](/*103.12*/controllers/*103.23*/.patrimonio.routes.RemitosLineasController.modificar())),format.raw/*103.77*/("""', """),format.raw/*103.80*/("""{"""),format.raw/*103.81*/("""cantidad:cantidad, id: id, remito_id:remito_id, linea_orden_id:linea_orden_id """),format.raw/*103.159*/("""}"""),format.raw/*103.160*/(""", function(data) """),format.raw/*103.177*/("""{"""),format.raw/*103.178*/("""
			if(data.success) """),format.raw/*104.21*/("""{"""),format.raw/*104.22*/("""
				alert("La cantidad se ha modificado correctamente.");
			"""),format.raw/*106.4*/("""}"""),format.raw/*106.5*/(""" else """),format.raw/*106.11*/("""{"""),format.raw/*106.12*/("""
				alert(data.message);
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/("""
			inputAgregar.removeAttr('disabled');
			$this.removeAttr('disabled');
		"""),format.raw/*111.3*/("""}"""),format.raw/*111.4*/(""");
	"""),format.raw/*112.2*/("""}"""),format.raw/*112.3*/(""");

	$('.agregarNumeroInventario').click( function() """),format.raw/*114.50*/("""{"""),format.raw/*114.51*/(""" //abrir modal para mostrar mensaje informe rentas
		var tr = $(this).closest('tr');
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Cargando...</div>');
		
		dialogo.dialog("""),format.raw/*119.18*/("""{"""),format.raw/*119.19*/("""
			title: "Registro de inventario",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 550,
			width:750,
	        buttons: """),format.raw/*126.19*/("""{"""),format.raw/*126.20*/("""
		          Cerrar: function() """),format.raw/*127.32*/("""{"""),format.raw/*127.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/("""
		    """),format.raw/*130.7*/("""}"""),format.raw/*130.8*/(""",
	    	close: function(event, ui )"""),format.raw/*131.34*/("""{"""),format.raw/*131.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*133.7*/("""}"""),format.raw/*133.8*/(""",
		    open: function( event, ui ) """),format.raw/*134.35*/("""{"""),format.raw/*134.36*/("""
				$.get(url, function(data)"""),format.raw/*135.30*/("""{"""),format.raw/*135.31*/("""
					dialogo.html(data);
				"""),format.raw/*137.5*/("""}"""),format.raw/*137.6*/(""");	
		    """),format.raw/*138.7*/("""}"""),format.raw/*138.8*/("""
	    """),format.raw/*139.6*/("""}"""),format.raw/*139.7*/(""");
	"""),format.raw/*140.2*/("""}"""),format.raw/*140.3*/(""");
	
	
	var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar el registro?<p></div>');
	$('.eliminarLinea').on('click', function()"""),format.raw/*144.44*/("""{"""),format.raw/*144.45*/("""
		$this = $(this);
		var link = $(this).attr("data-href");
		var tr = $(this).closest('tr');
		
	    dialogo.dialog("""),format.raw/*149.21*/("""{"""),format.raw/*149.22*/("""
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar registro",
	        buttons: """),format.raw/*154.19*/("""{"""),format.raw/*154.20*/("""
	          Eliminar: function() """),format.raw/*155.33*/("""{"""),format.raw/*155.34*/("""
	        	$this.prop('disabled', true);
	            $.get(link, function(data)"""),format.raw/*157.40*/("""{"""),format.raw/*157.41*/("""
	            	if(data.success) """),format.raw/*158.32*/("""{"""),format.raw/*158.33*/("""
	            		tr.remove();
	            	"""),format.raw/*160.15*/("""}"""),format.raw/*160.16*/(""" else """),format.raw/*160.22*/("""{"""),format.raw/*160.23*/("""
	            		alert(data.message);
	            	"""),format.raw/*162.15*/("""}"""),format.raw/*162.16*/("""
	            	dialogo.dialog( "destroy" );
	            """),format.raw/*164.14*/("""}"""),format.raw/*164.15*/(""");
	          """),format.raw/*165.12*/("""}"""),format.raw/*165.13*/(""",
	          Cancelar: function( event, ui ) """),format.raw/*166.44*/("""{"""),format.raw/*166.45*/("""
	        	  dialogo.dialog( "destroy" );
	          """),format.raw/*168.12*/("""}"""),format.raw/*168.13*/("""
	        """),format.raw/*169.10*/("""}"""),format.raw/*169.11*/(""",
		    close: function()"""),format.raw/*170.24*/("""{"""),format.raw/*170.25*/("""
		    	$( this ).dialog( "destroy" );
		    """),format.raw/*172.7*/("""}"""),format.raw/*172.8*/(""",
	      """),format.raw/*173.8*/("""}"""),format.raw/*173.9*/(""");
	    return false;
	"""),format.raw/*175.2*/("""}"""),format.raw/*175.3*/(""");
	
"""),format.raw/*177.1*/("""}"""),format.raw/*177.2*/(""");
</script>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[RemitoLinea],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[RemitoLinea],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasRemitos/enRemito.scala.html
                    HASH: 587353368d3fb759da1c9bf8bfb5f30a3dbf2cf2
                    MATRIX: 848->1|1070->141|1102->165|1176->80|1205->209|1340->309|1354->315|1473->424|1514->426|1555->432|1651->506|1786->606|1928->725|2226->992|2281->1012|2324->1046|2364->1048|2516->1183|2529->1188|2568->1189|2623->1208|2640->1216|2694->1248|3040->1558|3086->1588|3126->1590|3196->1624|3305->1723|3346->1725|3390->1736|3440->1750|3454->1755|3503->1782|3556->1799|3570->1804|3614->1826|3667->1843|3681->1848|3747->1892|3854->1963|3868->1968|3900->1978|4017->2059|4031->2064|4068->2079|4179->2154|4193->2159|4218->2162|4337->2245|4351->2250|4382->2259|4544->2386|4653->2485|4693->2486|4788->2545|4808->2556|4895->2620|4990->2684|5034->2693|5079->2729|5119->2731|5243->2819|5263->2830|5347->2891|5454->2967|5527->3008|5639->3085|5653->3090|5775->3189|5833->3216|5899->3254|5928->3255|6022->3321|6051->3322|6157->3400|6186->3401|6240->3428|6268->3429|6298->3432|6326->3433|6418->3497|6447->3498|6851->3865|6872->3876|6949->3930|6981->3933|7011->3934|7119->4012|7150->4013|7197->4030|7228->4031|7279->4053|7309->4054|7401->4118|7430->4119|7465->4125|7495->4126|7554->4157|7583->4158|7690->4237|7719->4238|7752->4243|7781->4244|7865->4299|7895->4300|8117->4493|8147->4494|8327->4645|8357->4646|8419->4679|8449->4680|8538->4740|8568->4741|8604->4749|8633->4750|8698->4786|8728->4787|8801->4832|8830->4833|8896->4870|8926->4871|8986->4902|9016->4903|9076->4935|9105->4936|9144->4947|9173->4948|9208->4955|9237->4956|9270->4961|9299->4962|9550->5184|9580->5185|9731->5307|9761->5308|9921->5439|9951->5440|10014->5474|10044->5475|10155->5557|10185->5558|10247->5591|10277->5592|10351->5637|10381->5638|10416->5644|10446->5645|10528->5698|10558->5699|10646->5758|10676->5759|10720->5774|10750->5775|10825->5821|10855->5822|10939->5877|10969->5878|11009->5889|11039->5890|11094->5916|11124->5917|11199->5964|11228->5965|11266->5975|11295->5976|11348->6001|11377->6002|11412->6009|11441->6010
                    LINES: 26->1|33->5|33->5|34->1|35->5|41->11|41->11|41->11|41->11|42->12|42->12|46->16|46->16|55->25|60->30|60->30|60->30|66->36|66->36|66->36|68->38|68->38|68->38|80->50|80->50|80->50|81->51|81->51|81->51|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|84->54|84->54|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|92->62|92->62|92->62|93->63|93->63|93->63|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|100->70|105->75|105->75|105->75|108->78|113->83|113->83|115->85|115->85|117->87|117->87|119->89|119->89|120->90|120->90|122->92|122->92|133->103|133->103|133->103|133->103|133->103|133->103|133->103|133->103|133->103|134->104|134->104|136->106|136->106|136->106|136->106|138->108|138->108|141->111|141->111|142->112|142->112|144->114|144->114|149->119|149->119|156->126|156->126|157->127|157->127|159->129|159->129|160->130|160->130|161->131|161->131|163->133|163->133|164->134|164->134|165->135|165->135|167->137|167->137|168->138|168->138|169->139|169->139|170->140|170->140|174->144|174->144|179->149|179->149|184->154|184->154|185->155|185->155|187->157|187->157|188->158|188->158|190->160|190->160|190->160|190->160|192->162|192->162|194->164|194->164|195->165|195->165|196->166|196->166|198->168|198->168|199->169|199->169|200->170|200->170|202->172|202->172|203->173|203->173|205->175|205->175|207->177|207->177
                    -- GENERATED --
                */
            