
package views.html.compras.cajaChica.presupuestoLineas

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
object listaPresupuestoLineas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[CajaChicaPresupuestoLinea],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[CajaChicaPresupuestoLinea],  editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

<div id="listaLineaPresupuesto" class="contenedorPaginador ajaxPaginador">

<p>
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevaLineaPresupuesto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*8.3*/("""
</p>



<table id="listaDeLineaPresupuesto" class="table table-striped table-bordered">
	<thead>
		<tr>
		 	<th>Cuenta analitica</th>
			<th>Monto</th>
			<th></th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*22.3*/for(linea <- lista) yield /*22.22*/ {_display_(Seq[Any](format.raw/*22.24*/("""
		"""),_display_(Seq[Any](/*23.4*/views/*23.9*/.html.compras.cajaChica.presupuestoLineas.lineaPresupuesto(linea, editable))),format.raw/*23.84*/("""
	""")))})),format.raw/*24.3*/("""
	</tbody>
</table>

</div>



<script type="text/javascript">

$( function()"""),format.raw/*34.14*/("""{"""),format.raw/*34.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaPresupuesto");

	contenedor.on('click', '#nuevaLineaPresupuesto', function()"""),format.raw/*41.61*/("""{"""),format.raw/*41.62*/("""
		urlContenidoModal = '/compras/caja-chica-presupuesto/crear?cajaId='+$('#cajaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*45.2*/("""}"""),format.raw/*45.3*/(""");
	 
	
	function mostrarModal(url)"""),format.raw/*48.28*/("""{"""),format.raw/*48.29*/("""
		modalCargaMovimiento = $('<div></div>').dialog("""),format.raw/*49.50*/("""{"""),format.raw/*49.51*/("""
			resizable: false,
		    title: "Cargar Presupuesto",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*55.35*/("""{"""),format.raw/*55.36*/("""
				$.get(url, function(data)"""),format.raw/*56.30*/("""{"""),format.raw/*56.31*/("""
					modalCargaMovimiento.html(data);
				"""),format.raw/*58.5*/("""}"""),format.raw/*58.6*/(""");
		    """),format.raw/*59.7*/("""}"""),format.raw/*59.8*/(""",
		    close: function(event, ui )"""),format.raw/*60.34*/("""{"""),format.raw/*60.35*/("""
		    	modalCargaMovimiento.dialog('destroy');
			"""),format.raw/*62.4*/("""}"""),format.raw/*62.5*/("""
		  """),format.raw/*63.5*/("""}"""),format.raw/*63.6*/(""");
		
		modalCargaMovimiento.on('click', '.cancelar', function()"""),format.raw/*65.59*/("""{"""),format.raw/*65.60*/("""
			modalCargaMovimiento.dialog('destroy');
			return false;
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
		
		modalCargaMovimiento.on('submit', function(e)"""),format.raw/*70.48*/("""{"""),format.raw/*70.49*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*73.42*/("""{"""),format.raw/*73.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*74.45*/("""{"""),format.raw/*74.46*/("""
					$('#listaLineaPresupuesto tbody').prepend(resultado.html);
					modalCargaMovimiento.dialog( "destroy" );
				"""),format.raw/*77.5*/("""}"""),format.raw/*77.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*77.56*/("""{"""),format.raw/*77.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaMovimiento.dialog( "destroy" );
				"""),format.raw/*80.5*/("""}"""),format.raw/*80.6*/(""" else """),format.raw/*80.12*/("""{"""),format.raw/*80.13*/("""
					modalCargaMovimiento.html(resultado);
				"""),format.raw/*82.5*/("""}"""),format.raw/*82.6*/("""
			"""),format.raw/*83.4*/("""}"""),format.raw/*83.5*/(""");
			return false;
		"""),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""");
		
		
		return modalCargaMovimiento;
	"""),format.raw/*89.2*/("""}"""),format.raw/*89.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*92.49*/("""{"""),format.raw/*92.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*95.38*/("""{"""),format.raw/*95.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*97.3*/("""}"""),format.raw/*97.4*/(""");
		return false;
	"""),format.raw/*99.2*/("""}"""),format.raw/*99.3*/(""");
"""),format.raw/*100.1*/("""}"""),format.raw/*100.2*/(""");
</script>"""))}
    }
    
    def render(lista:List[CajaChicaPresupuestoLinea],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(lista,editable)
    
    def f:((List[CajaChicaPresupuestoLinea],Boolean) => play.api.templates.HtmlFormat.Appendable) = (lista,editable) => apply(lista,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/presupuestoLineas/listaPresupuestoLineas.scala.html
                    HASH: 1361683e1a9b59ba450945457e1eb5f64cd5fe43
                    MATRIX: 860->1|1014->61|1132->145|1152->157|1190->158|1348->286|1578->481|1613->500|1653->502|1692->506|1705->511|1802->586|1836->589|1941->666|1970->667|2171->840|2200->841|2370->984|2398->985|2461->1020|2490->1021|2568->1071|2597->1072|2772->1219|2801->1220|2859->1250|2888->1251|2958->1294|2986->1295|3022->1304|3050->1305|3113->1340|3142->1341|3220->1392|3248->1393|3280->1398|3308->1399|3400->1463|3429->1464|3519->1527|3547->1528|3628->1581|3657->1582|3808->1705|3837->1706|3910->1751|3939->1752|4082->1868|4110->1869|4188->1919|4217->1920|4349->2025|4377->2026|4411->2032|4440->2033|4515->2081|4543->2082|4574->2086|4602->2087|4651->2109|4679->2110|4747->2151|4775->2152|4856->2205|4885->2206|5022->2315|5051->2316|5116->2354|5144->2355|5191->2375|5219->2376|5250->2379|5279->2380
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|50->22|50->22|50->22|51->23|51->23|51->23|52->24|62->34|62->34|69->41|69->41|73->45|73->45|76->48|76->48|77->49|77->49|83->55|83->55|84->56|84->56|86->58|86->58|87->59|87->59|88->60|88->60|90->62|90->62|91->63|91->63|93->65|93->65|96->68|96->68|98->70|98->70|101->73|101->73|102->74|102->74|105->77|105->77|105->77|105->77|108->80|108->80|108->80|108->80|110->82|110->82|111->83|111->83|113->85|113->85|117->89|117->89|120->92|120->92|123->95|123->95|125->97|125->97|127->99|127->99|128->100|128->100
                    -- GENERATED --
                */
            