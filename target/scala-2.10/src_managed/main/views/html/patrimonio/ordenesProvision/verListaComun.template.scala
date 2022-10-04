
package views.html.patrimonio.ordenesProvision

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
object verListaComun extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden: OrdenProvision, buscador: utils.pagination.Pagination[OrdenProvisionLineas]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.70*/("""

	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a href="#contenedorSolicitados"  data-href=""""),_display_(Seq[Any](/*8.68*/controllers/*8.79*/.patrimonio.routes.OrdenesProvisionController.verProductosSolicitados(orden.id))),format.raw/*8.158*/("""" id="menuProductosSolicitados" data-toggle="tab">Solicitados</a></li>
		<li><a id="menuProductosRecepcionados" data-href=""""),_display_(Seq[Any](/*9.54*/controllers/*9.65*/.patrimonio.routes.OrdenesProvisionController.productosRecepcionados(orden.ordenCompra.id))),format.raw/*9.155*/("""" href="#contenedorProductosRecepcionados" data-toggle="tab">Productos recepcionados</a></li>
		<li><a id="menuRecepciones" data-href=""""),_display_(Seq[Any](/*10.43*/controllers/*10.54*/.patrimonio.routes.OrdenesProvisionController.getRecepciones(orden.id))),format.raw/*10.124*/("""" href="#contenedorRecepciones" data-toggle="tab">Recepciones</a></li>
		<li><a id="menuAnulados" data-href=""""),_display_(Seq[Any](/*11.40*/controllers/*11.51*/.patrimonio.routes.AnulacionRecepcionProductosController.productosEnOrden(orden.ordenCompra.id))),format.raw/*11.146*/("""" href="#contenedorAnulados" data-toggle="tab">Productos anulados</a></li>
		<li><a id="menuAjusteOrdenCompra" data-href=""""),_display_(Seq[Any](/*12.49*/controllers/*12.60*/.compras.routes.OrdenesLineasAjustesController.index(orden.ordenCompra.id,false))),format.raw/*12.140*/("""" href="#contenedorAjusteOrdenCompra" data-toggle="tab">Ajustes Orden</a></li>
	</ul>

	<div class="tab-content">
		<div id="contenedorSolicitados" class="contenedor tab-pane active">
			
		</div>
	
		<div id="contenedorProductosRecepcionados" class="contenedor tab-pane">
			
		</div>
		<div id="contenedorRecepciones" class="contenedor tab-pane">
			
		</div>
	
		<div id="contenedorAnulados" class="contenedor tab-pane">
			
		</div>
		
		<div id="contenedorAjusteOrdenCompra" class="contenedor tab-pane">
			
		</div>
	
	</div>
	

<script>
$( function()"""),format.raw/*39.14*/("""{"""),format.raw/*39.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductos");
	
	 
	
	var dialogo = $('<div></div>');
	contenedor.on('click', '.modificarProducto', function()"""),format.raw/*49.57*/("""{"""),format.raw/*49.58*/("""
		lineaParaEditar = $(this).closest('tr');
		var url = $(this).attr('href');
		

		dialogo.dialog("""),format.raw/*54.18*/("""{"""),format.raw/*54.19*/("""
			resizable: false,
		    title: "Modificar producto para anular",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*60.35*/("""{"""),format.raw/*60.36*/("""
				$.get(url, function(data)"""),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
					dialogo.html(data);
				"""),format.raw/*63.5*/("""}"""),format.raw/*63.6*/(""");
		    """),format.raw/*64.7*/("""}"""),format.raw/*64.8*/(""",
		    close: function(event, ui )"""),format.raw/*65.34*/("""{"""),format.raw/*65.35*/("""
		    	dialogo.dialog('destroy');
			"""),format.raw/*67.4*/("""}"""),format.raw/*67.5*/("""
		  """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/(""");
		
		
		
		return false;
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
	
	contenedor.on('click', '.eliminarProducto', function()"""),format.raw/*75.56*/("""{"""),format.raw/*75.57*/("""
		var url = $(this).attr('href');
		var mensaje = "�Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*78.23*/("""{"""),format.raw/*78.24*/("""
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*80.29*/("""{"""),format.raw/*80.30*/("""
				if(data.success)"""),format.raw/*81.21*/("""{"""),format.raw/*81.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*83.5*/("""}"""),format.raw/*83.6*/(""" else """),format.raw/*83.12*/("""{"""),format.raw/*83.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*85.5*/("""}"""),format.raw/*85.6*/("""
			"""),format.raw/*86.4*/("""}"""),format.raw/*86.5*/(""");
		"""),format.raw/*87.3*/("""}"""),format.raw/*87.4*/("""
		return false;
	"""),format.raw/*89.2*/("""}"""),format.raw/*89.3*/(""");
	
	$(document).on('click', '#nuevoProducto', function()"""),format.raw/*91.54*/("""{"""),format.raw/*91.55*/("""
		urlContenidoModal = $(this).attr('href');

		var dialogo = $('<div id="dialogo-anulacion-productos"></div>');
		dialogo.dialog("""),format.raw/*95.18*/("""{"""),format.raw/*95.19*/("""
			resizable: false,
		    title: "Agregar producto para anular",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*101.35*/("""{"""),format.raw/*101.36*/("""
				$.get(urlContenidoModal, function(data)"""),format.raw/*102.44*/("""{"""),format.raw/*102.45*/("""
					dialogo.html(data);
				"""),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""");
		    """),format.raw/*105.7*/("""}"""),format.raw/*105.8*/(""",
		    close: function(event, ui )"""),format.raw/*106.34*/("""{"""),format.raw/*106.35*/("""
		    	dialogo.dialog('destroy');
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/("""
		  """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/(""");
		return false;
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/(""");

	$(document).on('submit', '#formAnulados', function()"""),format.raw/*113.54*/("""{"""),format.raw/*113.55*/("""
		
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.post(url, query, function(data)"""),format.raw/*117.36*/("""{"""),format.raw/*117.37*/("""
			if (data.success) """),format.raw/*118.22*/("""{"""),format.raw/*118.23*/("""
				if(data.nuevo) """),format.raw/*119.20*/("""{"""),format.raw/*119.21*/("""
					 
					$("#listaProductosAnulados").find('tbody').append(data.html);
					
				"""),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""" else """),format.raw/*123.12*/("""{"""),format.raw/*123.13*/("""
					lineaParaEditar.replaceWith(data.html);
				"""),format.raw/*125.5*/("""}"""),format.raw/*125.6*/("""
				dialogo.dialog('close');
			"""),format.raw/*127.4*/("""}"""),format.raw/*127.5*/(""" else """),format.raw/*127.11*/("""{"""),format.raw/*127.12*/("""
				dialogo.html(data);				
			"""),format.raw/*129.4*/("""}"""),format.raw/*129.5*/("""
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");
		return false;
	"""),format.raw/*132.2*/("""}"""),format.raw/*132.3*/(""");
"""),format.raw/*133.1*/("""}"""),format.raw/*133.2*/(""");
</script>"""))}
    }
    
    def render(orden:OrdenProvision,buscador:utils.pagination.Pagination[OrdenProvisionLineas]): play.api.templates.HtmlFormat.Appendable = apply(orden,buscador)
    
    def f:((OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas]) => play.api.templates.HtmlFormat.Appendable) = (orden,buscador) => apply(orden,buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/verListaComun.scala.html
                    HASH: d02c80b254b4709b897c6203273659131c281845
                    MATRIX: 868->1|1095->146|1127->170|1201->85|1230->214|1378->327|1397->338|1498->417|1658->542|1677->553|1789->643|1962->780|1982->791|2075->861|2222->972|2242->983|2360->1078|2520->1202|2540->1213|2643->1293|3255->1877|3284->1878|3528->2094|3557->2095|3689->2199|3718->2200|3911->2365|3940->2366|3999->2397|4028->2398|4087->2430|4115->2431|4152->2441|4180->2442|4244->2478|4273->2479|4340->2519|4368->2520|4401->2526|4429->2527|4490->2561|4518->2562|4608->2624|4637->2625|4786->2746|4815->2747|4894->2798|4923->2799|4973->2821|5002->2822|5071->2864|5099->2865|5133->2871|5162->2872|5245->2928|5273->2929|5305->2934|5333->2935|5366->2941|5394->2942|5441->2962|5469->2963|5557->3023|5586->3024|5748->3158|5777->3159|5969->3322|5999->3323|6073->3368|6103->3369|6163->3401|6192->3402|6230->3412|6259->3413|6324->3449|6354->3450|6422->3490|6451->3491|6485->3497|6514->3498|6564->3520|6593->3521|6681->3580|6711->3581|6854->3695|6884->3696|6936->3719|6966->3720|7016->3741|7046->3742|7163->3831|7192->3832|7227->3838|7257->3839|7337->3891|7366->3892|7429->3927|7458->3928|7493->3934|7523->3935|7585->3969|7614->3970|7646->3974|7675->3975|7725->3997|7754->3998|7786->4002|7815->4003
                    LINES: 26->1|33->5|33->5|34->1|35->5|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|69->39|69->39|79->49|79->49|84->54|84->54|90->60|90->60|91->61|91->61|93->63|93->63|94->64|94->64|95->65|95->65|97->67|97->67|98->68|98->68|103->73|103->73|105->75|105->75|108->78|108->78|110->80|110->80|111->81|111->81|113->83|113->83|113->83|113->83|115->85|115->85|116->86|116->86|117->87|117->87|119->89|119->89|121->91|121->91|125->95|125->95|131->101|131->101|132->102|132->102|134->104|134->104|135->105|135->105|136->106|136->106|138->108|138->108|139->109|139->109|141->111|141->111|143->113|143->113|147->117|147->117|148->118|148->118|149->119|149->119|153->123|153->123|153->123|153->123|155->125|155->125|157->127|157->127|157->127|157->127|159->129|159->129|160->130|160->130|162->132|162->132|163->133|163->133
                    -- GENERATED --
                */
            