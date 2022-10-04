
package views.html.compras.lineaAjustesCertificacionesCompras

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
object indexCertificacionLinea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[CertificacionesComprasLineaAjustes],Boolean,CertificacionCompra,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[CertificacionesComprasLineaAjustes], editable: Boolean,c:CertificacionCompra):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._


Seq[Any](format.raw/*1.120*/("""
"""),format.raw/*4.1*/("""<div id="listaLineaProductosAjuste" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Ajuste</b>
	"""),_display_(Seq[Any](/*8.3*/if(Permiso.check("certificacionesComprasAgregarLineaAjuste"))/*8.64*/ {_display_(Seq[Any](format.raw/*8.66*/("""
		"""),_display_(Seq[Any](/*9.4*/if(c != null && (c.estado_id == 81))/*9.40*/{_display_(Seq[Any](format.raw/*9.41*/("""
		<a class="btn btn-default btn-xs" href="#" id="nuevoProductoAjuste"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
													   						
		""")))})),format.raw/*12.4*/(""" 	
	""")))})),format.raw/*13.3*/("""
</p>

<table id="listaDeProductosAjuste" class="table table-striped table-bordered">
	<thead>
		<tr>
		 
			<th>Producto</th>
			<th>Cuenta analitica</th>
			<th>UDM</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Subtotal</th>
			 
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*30.3*/for(linea <- paginador.getList) yield /*30.34*/ {_display_(Seq[Any](format.raw/*30.36*/("""
		"""),_display_(Seq[Any](/*31.4*/views/*31.9*/.html.compras.lineaAjustesCertificacionesCompras.lineaProducto(linea, editable))),format.raw/*31.88*/("""
	""")))})),format.raw/*32.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*37.6*/views/*37.11*/.html.helpers.paginador(paginador, controllers.compras.routes.CertificacionesComprasLineaAjustesController.index()))),format.raw/*37.126*/("""
</div>
</div>

<script>
$( function()"""),format.raw/*42.14*/("""{"""),format.raw/*42.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaProductosAjuste");

	contenedor.on('click', '#nuevoProductoAjuste', function()"""),format.raw/*49.59*/("""{"""),format.raw/*49.60*/("""
		
		urlContenidoModal = '/compras/certificacion-linea-ajuste/crear?certificacionId='+$('#certificacionId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*54.2*/("""}"""),format.raw/*54.3*/(""");
	
 	function mostrarModal(url)"""),format.raw/*56.29*/("""{"""),format.raw/*56.30*/("""
		modalCargaProductos = $('<div></div>').dialog("""),format.raw/*57.49*/("""{"""),format.raw/*57.50*/("""
			resizable: false,
		    title: "Cargar Ajuste",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*63.35*/("""{"""),format.raw/*63.36*/("""
				$.get(url, function(data)"""),format.raw/*64.30*/("""{"""),format.raw/*64.31*/("""
					modalCargaProductos.html(data);
				"""),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""");
		    """),format.raw/*67.7*/("""}"""),format.raw/*67.8*/(""",
		    close: function(event, ui )"""),format.raw/*68.34*/("""{"""),format.raw/*68.35*/("""
		    	modalCargaProductos.dialog('destroy');
			"""),format.raw/*70.4*/("""}"""),format.raw/*70.5*/("""
		  """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/(""");
		
		modalCargaProductos.on('click', '.cancelar', function()"""),format.raw/*73.58*/("""{"""),format.raw/*73.59*/("""
			modalCargaProductos.dialog('destroy');
			return false;
		"""),format.raw/*76.3*/("""}"""),format.raw/*76.4*/(""");
		
		modalCargaProductos.on('submit', function(e)"""),format.raw/*78.47*/("""{"""),format.raw/*78.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			
			$("#btn-guardar-linea-ajuste-cc").attr("disabled", true);
			$.post(href, data, function(resultado)"""),format.raw/*83.42*/("""{"""),format.raw/*83.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*84.45*/("""{"""),format.raw/*84.46*/("""
					$('#listaDeProductosAjuste tbody').prepend(resultado.html);
					$('.successAddLineaAjuste').html(resultado.message)
					$('.successAddLineaAjuste').show();
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*89.5*/("""}"""),format.raw/*89.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*89.56*/("""{"""),format.raw/*89.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaProductos.dialog( "destroy" );
				"""),format.raw/*92.5*/("""}"""),format.raw/*92.6*/(""" else """),format.raw/*92.12*/("""{"""),format.raw/*92.13*/("""
					modalCargaProductos.html(resultado);
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""
				$("#btn-guardar-linea-ajuste-cc").attr("disabled", false);
			"""),format.raw/*96.4*/("""}"""),format.raw/*96.5*/(""");
			return false;
		"""),format.raw/*98.3*/("""}"""),format.raw/*98.4*/(""");
		
		
		return modalCargaProductos;
	"""),format.raw/*102.2*/("""}"""),format.raw/*102.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*105.49*/("""{"""),format.raw/*105.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*108.38*/("""{"""),format.raw/*108.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*110.3*/("""}"""),format.raw/*110.4*/(""");
		return false;
	"""),format.raw/*112.2*/("""}"""),format.raw/*112.3*/(""");
"""),format.raw/*113.1*/("""}"""),format.raw/*113.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[CertificacionesComprasLineaAjustes],editable:Boolean,c:CertificacionCompra): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,c)
    
    def f:((utils.pagination.Pagination[CertificacionesComprasLineaAjustes],Boolean,CertificacionCompra) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,c) => apply(paginador,editable,c)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineaAjustesCertificacionesCompras/indexCertificacionLinea.scala.html
                    HASH: 2420ee655007c03fd100427a8c8a3bbf4f79e5ef
                    MATRIX: 920->1|1173->119|1201->162|1340->267|1409->328|1448->330|1487->335|1531->371|1569->372|1751->523|1788->529|2107->813|2154->844|2194->846|2234->851|2247->856|2348->935|2383->939|2487->1008|2501->1013|2639->1128|2710->1171|2739->1172|2949->1354|2978->1355|3178->1528|3206->1529|3269->1564|3298->1565|3376->1615|3405->1616|3581->1764|3610->1765|3669->1796|3698->1797|3769->1841|3797->1842|3834->1852|3862->1853|3926->1889|3955->1890|4034->1942|4062->1943|4095->1949|4123->1950|4216->2015|4245->2016|4337->2081|4365->2082|4447->2136|4476->2137|4697->2330|4726->2331|4800->2377|4829->2378|5075->2597|5103->2598|5181->2648|5210->2649|5344->2756|5372->2757|5406->2763|5435->2764|5511->2813|5539->2814|5635->2883|5663->2884|5714->2908|5742->2909|5814->2953|5843->2954|5928->3010|5958->3011|6099->3123|6129->3124|6197->3164|6226->3165|6276->3187|6305->3188|6337->3192|6366->3193
                    LINES: 26->1|32->1|33->4|37->8|37->8|37->8|38->9|38->9|38->9|41->12|42->13|59->30|59->30|59->30|60->31|60->31|60->31|61->32|66->37|66->37|66->37|71->42|71->42|78->49|78->49|83->54|83->54|85->56|85->56|86->57|86->57|92->63|92->63|93->64|93->64|95->66|95->66|96->67|96->67|97->68|97->68|99->70|99->70|100->71|100->71|102->73|102->73|105->76|105->76|107->78|107->78|112->83|112->83|113->84|113->84|118->89|118->89|118->89|118->89|121->92|121->92|121->92|121->92|123->94|123->94|125->96|125->96|127->98|127->98|131->102|131->102|134->105|134->105|137->108|137->108|139->110|139->110|141->112|141->112|142->113|142->113
                    -- GENERATED --
                */
            