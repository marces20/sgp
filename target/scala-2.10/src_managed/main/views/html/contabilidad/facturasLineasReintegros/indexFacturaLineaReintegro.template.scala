
package views.html.contabilidad.facturasLineasReintegros

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
object indexFacturaLineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[utils.pagination.Pagination[FacturaLineaReintegro],Boolean,Long,Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[FacturaLineaReintegro], editable: Boolean,facturaId:Long,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.116*/("""
"""),format.raw/*3.1*/("""
<div id="listaLineaReintegros" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Reintegros</b>
	"""),_display_(Seq[Any](/*8.3*/if(Permiso.check("facturasCargarReintegro"))/*8.47*/ {_display_(Seq[Any](format.raw/*8.49*/("""  
		"""),_display_(Seq[Any](/*9.4*/if(factura != null)/*9.23*/{_display_(Seq[Any](format.raw/*9.24*/("""
			"""),_display_(Seq[Any](/*10.5*/if(factura.estado.id ==  models.Estado.FACTURA_ESTADO_APROBADO)/*10.68*/{_display_(Seq[Any](format.raw/*10.69*/("""
				<a class="btn btn-default btn-xs" href="#" id="nuevoReintegro"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>
			""")))})),format.raw/*12.5*/("""
		""")))})),format.raw/*13.4*/("""
	""")))})),format.raw/*14.3*/("""
</p>		
	<div class="panel panel-default">
		
		<div class="panel-body">
		
		"""),_display_(Seq[Any](/*20.4*/if(paginador.getTotalRowCount == 0)/*20.39*/ {_display_(Seq[Any](format.raw/*20.41*/("""
	        <p id="mensajeSinResultados" class="well"><i class="glyphicon glyphicon-info-sign"></i> No hay reintegros para esta factura.</p>
	    """)))})),format.raw/*22.7*/(""" 
	
		<table id="listaDeReintegros" class="table table-striped table-bordered  """),_display_(Seq[Any](/*24.77*/if(paginador.getTotalRowCount() <= 0)/*24.114*/{_display_(Seq[Any](format.raw/*24.115*/("""hide""")))})),format.raw/*24.120*/("""">
			<thead>
				<tr>
					"""),_display_(Seq[Any](/*27.7*/if(factura.estado.id ==  models.Estado.FACTURA_ESTADO_APROBADO && Permiso.check("facturasEditarReintegros"))/*27.115*/{_display_(Seq[Any](format.raw/*27.116*/("""
						<th class="accion-editar">#</th>
					""")))})),format.raw/*29.7*/("""
						
						<th>Cuenta</th>
						<th>Cuenta Presupuestaria</th>
						<th>Cuenta Impuesto</th>
						<th>Importe</th>
						<th>Descripcion</th>
					"""),_display_(Seq[Any](/*36.7*/if(factura.estado.id ==  models.Estado.FACTURA_ESTADO_APROBADO && Permiso.check("facturasEliminarReintegros"))/*36.117*/{_display_(Seq[Any](format.raw/*36.118*/("""
						<th></th>
					""")))})),format.raw/*38.7*/("""
				<tr>	
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*42.5*/for(linea <- paginador.getList) yield /*42.36*/ {_display_(Seq[Any](format.raw/*42.38*/("""
				"""),_display_(Seq[Any](/*43.6*/views/*43.11*/.html.contabilidad.facturasLineasReintegros.lineaReintegro(linea, editable,factura:Factura))),format.raw/*43.102*/("""
			""")))})),format.raw/*44.5*/("""
			</tbody>
		</table>


		
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*51.9*/views/*51.14*/.html.helpers.paginador(paginador, controllers.contabilidad.routes.FacturasLineasReintegrosController.index()))),format.raw/*51.124*/("""
			</div>
		</div>
	</div>
</div>


<script>
$( function()"""),format.raw/*59.14*/("""{"""),format.raw/*59.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#listaLineaReintegros");
	
	contenedor.on('click', '#nuevoReintegro', function()"""),format.raw/*66.54*/("""{"""),format.raw/*66.55*/("""
		urlContenidoModal = '/contabilidad/factura-linea-reintegro/crear?facturaId='+$('#facturaId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
	
	contenedor.on('click', '.modificarReintegro', function()"""),format.raw/*72.58*/("""{"""),format.raw/*72.59*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Reintegro');	
		return false;
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/(""");
	
	contenedor.on('click', '.eliminarReintegro', function()"""),format.raw/*79.57*/("""{"""),format.raw/*79.58*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*81.23*/("""{"""),format.raw/*81.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*84.29*/("""{"""),format.raw/*84.30*/("""
				if(data.success)"""),format.raw/*85.21*/("""{"""),format.raw/*85.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*87.5*/("""}"""),format.raw/*87.6*/(""" else """),format.raw/*87.12*/("""{"""),format.raw/*87.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*89.5*/("""}"""),format.raw/*89.6*/("""
			"""),format.raw/*90.4*/("""}"""),format.raw/*90.5*/(""");
		"""),format.raw/*91.3*/("""}"""),format.raw/*91.4*/("""
		return false;
	"""),format.raw/*93.2*/("""}"""),format.raw/*93.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*95.28*/("""{"""),format.raw/*95.29*/("""
		modalCargaReintegros = $('<div></div>').dialog("""),format.raw/*96.50*/("""{"""),format.raw/*96.51*/("""
			resizable: false,
		    title: "Cargar Reintegro",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*102.35*/("""{"""),format.raw/*102.36*/("""
				$.get(url, function(data)"""),format.raw/*103.30*/("""{"""),format.raw/*103.31*/("""
					modalCargaReintegros.html(data);
				"""),format.raw/*105.5*/("""}"""),format.raw/*105.6*/(""");
		    """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""",
		    close: function(event, ui )"""),format.raw/*107.34*/("""{"""),format.raw/*107.35*/("""
		    	modalCargaReintegros.dialog('destroy');
			"""),format.raw/*109.4*/("""}"""),format.raw/*109.5*/("""
		  """),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""");
		
		modalCargaReintegros.on('click', '.cancelar', function()"""),format.raw/*112.59*/("""{"""),format.raw/*112.60*/("""
			modalCargaReintegros.dialog('destroy');
			return false;
		"""),format.raw/*115.3*/("""}"""),format.raw/*115.4*/(""");
		
		modalCargaReintegros.on('submit', function(e)"""),format.raw/*117.48*/("""{"""),format.raw/*117.49*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado)"""),format.raw/*120.42*/("""{"""),format.raw/*120.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*121.45*/("""{"""),format.raw/*121.46*/("""
					$('#listaDeReintegros tbody').prepend(resultado.html);
					$('#mensajeSinResultados').remove();
					$('#listaDeReintegros').removeClass('hide');
					modalCargaReintegros.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/				
				"""),format.raw/*127.5*/("""}"""),format.raw/*127.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*127.56*/("""{"""),format.raw/*127.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaReintegros.dialog( "destroy" );
					/*aca va funcion Actualizar cuadrito*/
					
				"""),format.raw/*132.5*/("""}"""),format.raw/*132.6*/(""" else """),format.raw/*132.12*/("""{"""),format.raw/*132.13*/("""
					modalCargaReintegros.html(resultado);
				"""),format.raw/*134.5*/("""}"""),format.raw/*134.6*/("""
			"""),format.raw/*135.4*/("""}"""),format.raw/*135.5*/(""");
			return false;
		"""),format.raw/*137.3*/("""}"""),format.raw/*137.4*/(""");
		
		
		return modalCargaReintegros;
	"""),format.raw/*141.2*/("""}"""),format.raw/*141.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*144.49*/("""{"""),format.raw/*144.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*147.38*/("""{"""),format.raw/*147.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*149.3*/("""}"""),format.raw/*149.4*/(""");
		return false;
	"""),format.raw/*151.2*/("""}"""),format.raw/*151.3*/(""");
"""),format.raw/*152.1*/("""}"""),format.raw/*152.2*/(""");
</script>
"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[FacturaLineaReintegro],editable:Boolean,facturaId:Long,factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable,facturaId,factura)
    
    def f:((utils.pagination.Pagination[FacturaLineaReintegro],Boolean,Long,Factura) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable,facturaId,factura) => apply(paginador,editable,facturaId,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/indexFacturaLineaReintegro.scala.html
                    HASH: 8bc33be76c13b8eea1b58b375f7151a2d58916c1
                    MATRIX: 898->1|1129->115|1157->140|1297->246|1349->290|1388->292|1429->299|1456->318|1494->319|1535->325|1607->388|1646->389|1802->514|1838->519|1873->523|1993->608|2037->643|2077->645|2255->792|2373->874|2420->911|2460->912|2498->917|2565->949|2683->1057|2723->1058|2802->1106|2998->1267|3118->1377|3158->1378|3214->1403|3291->1445|3338->1476|3378->1478|3420->1485|3434->1490|3548->1581|3585->1587|3703->1670|3717->1675|3850->1785|3945->1852|3974->1853|4175->2026|4204->2027|4390->2186|4418->2187|4510->2251|4539->2252|4738->2424|4766->2425|4857->2488|4886->2489|5000->2575|5029->2576|5144->2663|5173->2664|5223->2686|5252->2687|5321->2729|5349->2730|5383->2736|5412->2737|5495->2793|5523->2794|5555->2799|5583->2800|5616->2806|5644->2807|5691->2827|5719->2828|5781->2862|5810->2863|5889->2914|5918->2915|6098->3066|6128->3067|6188->3098|6218->3099|6291->3144|6320->3145|6358->3155|6387->3156|6452->3192|6482->3193|6563->3246|6592->3247|6626->3253|6655->3254|6750->3320|6780->3321|6874->3387|6903->3388|6987->3443|7017->3444|7172->3570|7202->3571|7277->3617|7307->3618|7593->3876|7622->3877|7701->3927|7731->3928|7919->4088|7948->4089|7983->4095|8013->4096|8091->4146|8120->4147|8153->4152|8182->4153|8234->4177|8263->4178|8336->4223|8365->4224|8450->4280|8480->4281|8621->4393|8651->4394|8719->4434|8748->4435|8798->4457|8827->4458|8859->4462|8888->4463
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|41->13|42->14|48->20|48->20|48->20|50->22|52->24|52->24|52->24|52->24|55->27|55->27|55->27|57->29|64->36|64->36|64->36|66->38|70->42|70->42|70->42|71->43|71->43|71->43|72->44|79->51|79->51|79->51|87->59|87->59|94->66|94->66|98->70|98->70|100->72|100->72|105->77|105->77|107->79|107->79|109->81|109->81|112->84|112->84|113->85|113->85|115->87|115->87|115->87|115->87|117->89|117->89|118->90|118->90|119->91|119->91|121->93|121->93|123->95|123->95|124->96|124->96|130->102|130->102|131->103|131->103|133->105|133->105|134->106|134->106|135->107|135->107|137->109|137->109|138->110|138->110|140->112|140->112|143->115|143->115|145->117|145->117|148->120|148->120|149->121|149->121|155->127|155->127|155->127|155->127|160->132|160->132|160->132|160->132|162->134|162->134|163->135|163->135|165->137|165->137|169->141|169->141|172->144|172->144|175->147|175->147|177->149|177->149|179->151|179->151|180->152|180->152
                    -- GENERATED --
                */
            