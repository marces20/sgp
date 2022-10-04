
package views.html.patrimonio.anulacionRecepcion

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
object crearLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Form[OrdenLineaAnulacion],List[OrdenProvisionLineas],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, lineaForm: Form[OrdenLineaAnulacion],opl:List[OrdenProvisionLineas]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.92*/("""
"""),format.raw/*3.70*/(""" 


	
	<table id="listaProductos" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>	
				<th>Producto</th>
				<th>Pendiente</th>
				<th>Anular</th>
			</tr>
		</thead>	
		<tbody>
			"""),_display_(Seq[Any](/*16.5*/for(o <- opl) yield /*16.18*/{_display_(Seq[Any](format.raw/*16.19*/("""
				"""),_display_(Seq[Any](/*17.6*/if(o.pendiente.compareTo(java.math.BigDecimal.ZERO) > 0)/*17.62*/{_display_(Seq[Any](format.raw/*17.63*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*19.11*/o/*19.12*/.producto.nombre)),format.raw/*19.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*20.11*/o/*20.12*/.pendiente)),format.raw/*20.22*/("""</td>
					<td>
						<input class="linea_orden_id" type="hidden" value=""""),_display_(Seq[Any](/*22.59*/o/*22.60*/.orden_linea_id)),format.raw/*22.75*/("""" name="linea_orden_id" /> 
						<input class="cantidad" type="text" name="cantidad" value=""""),_display_(Seq[Any](/*23.67*/o/*23.68*/.pendiente)),format.raw/*23.78*/("""" style="width: 60px"/>
						<button class="anular" data-url=""""),_display_(Seq[Any](/*24.41*/controllers/*24.52*/.patrimonio.routes.AnulacionRecepcionProductosController.modalAnularConClientes())),format.raw/*24.133*/("""">
						<i class="glyphicon glyphicon-ok-sign"></i></button>
					</td>
				</tr>	
				""")))})),format.raw/*28.6*/("""	
			""")))})),format.raw/*29.5*/("""
			<tr>
				<td colspan="3">
					<div class="col-sm-12">
						<label for="obs" class="control-label">Observaciones</label> 
						"""),_display_(Seq[Any](/*34.8*/textarea(lineaForm("observaciones"), 'class -> "form-control", 'rows -> "4", 'id -> "obs"))),format.raw/*34.98*/("""
					</div>
				</td>
			</tr>
		</tbody>
	</table>
<script>
$( function() """),format.raw/*41.15*/("""{"""),format.raw/*41.16*/("""
	$(".cantidad").numeric_input();
	$('#listaProductos tbody tr .anular').click( function()"""),format.raw/*43.57*/("""{"""),format.raw/*43.58*/("""
		$this = $(this);
		$this.prop('disabled', true);
		var tr = $(this).closest('tr')
		var cantidad = tr.find('.cantidad').val().replace(",",".");
		var linea_orden_id = tr.find('.linea_orden_id').val();
		var observaciones =  $("#obs").val();
		
		var url = $(this).attr("data-url");
		
		$.get('"""),_display_(Seq[Any](/*53.11*/controllers/*53.22*/.patrimonio.routes.AnulacionRecepcionProductosController.tienePacientes())),format.raw/*53.95*/("""', """),format.raw/*53.98*/("""{"""),format.raw/*53.99*/("""orden_linea_id: linea_orden_id"""),format.raw/*53.129*/("""}"""),format.raw/*53.130*/(""", function(datac) """),format.raw/*53.148*/("""{"""),format.raw/*53.149*/("""
			if(datac.success)"""),format.raw/*54.21*/("""{"""),format.raw/*54.22*/("""
			
				$.post('"""),_display_(Seq[Any](/*56.14*/controllers/*56.25*/.patrimonio.routes.AnulacionRecepcionProductosController.controlesAnularConCliente())),format.raw/*56.109*/("""', """),format.raw/*56.112*/("""{"""),format.raw/*56.113*/("""cantidad:cantidad, orden_linea_id: linea_orden_id,observaciones:observaciones"""),format.raw/*56.190*/("""}"""),format.raw/*56.191*/(""", function(data) """),format.raw/*56.208*/("""{"""),format.raw/*56.209*/("""
					if(data.message) """),format.raw/*57.23*/("""{"""),format.raw/*57.24*/("""
						alert(data.message);
						$this.removeAttr('disabled');
					"""),format.raw/*60.6*/("""}"""),format.raw/*60.7*/(""" else """),format.raw/*60.13*/("""{"""),format.raw/*60.14*/("""
						
						var dialogo = $('<div id="dialogo-carga-pacientes-cantidad"></div>');
						dialogo.dialog("""),format.raw/*63.22*/("""{"""),format.raw/*63.23*/("""
					    	resizable: false,
							autoOpen: true,
							modal: true,
							height: 350,
							width:750,
							position: 'top',
							title: "Anular cantidades de cada Paciente",
							buttons: """),format.raw/*71.17*/("""{"""),format.raw/*71.18*/("""
						          Cerrar: function() """),format.raw/*72.36*/("""{"""),format.raw/*72.37*/("""
						            $( this ).dialog( "destroy" );
						            $("#dialogo-anulacion-productos").dialog( "destroy" );
						            $this.removeAttr('disabled');
						            $('#menuAnulados').click();
						          """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/("""
						    """),format.raw/*78.11*/("""}"""),format.raw/*78.12*/(""",
					    	close: function(event, ui )"""),format.raw/*79.38*/("""{"""),format.raw/*79.39*/("""
					    		$(this).dialog( "destroy" );
					    		$("#dialogo-anulacion-productos").dialog( "destroy" );
					    		$this.removeAttr('disabled');
					    		$('#menuAnulados').click();
					    	"""),format.raw/*84.11*/("""}"""),format.raw/*84.12*/(""",
						    open: function( event, ui ) """),format.raw/*85.39*/("""{"""),format.raw/*85.40*/("""
								$.get(url,"""),format.raw/*86.19*/("""{"""),format.raw/*86.20*/("""cantidad:cantidad, orden_linea_id: linea_orden_id,observaciones:observaciones"""),format.raw/*86.97*/("""}"""),format.raw/*86.98*/(""", function(data)"""),format.raw/*86.114*/("""{"""),format.raw/*86.115*/("""
									dialogo.html(data);
								"""),format.raw/*88.9*/("""}"""),format.raw/*88.10*/(""");	
								
						    """),format.raw/*90.11*/("""}"""),format.raw/*90.12*/("""
					      """),format.raw/*91.12*/("""}"""),format.raw/*91.13*/(""");
						 
					"""),format.raw/*93.6*/("""}"""),format.raw/*93.7*/("""
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""");
			"""),format.raw/*95.4*/("""}"""),format.raw/*95.5*/("""else"""),format.raw/*95.9*/("""{"""),format.raw/*95.10*/("""
			
				$.post('"""),_display_(Seq[Any](/*97.14*/controllers/*97.25*/.patrimonio.routes.AnulacionRecepcionProductosController.anular())),format.raw/*97.90*/("""', """),format.raw/*97.93*/("""{"""),format.raw/*97.94*/("""cantidad:cantidad, orden_linea_id: linea_orden_id,observaciones:observaciones"""),format.raw/*97.171*/("""}"""),format.raw/*97.172*/(""", function(data) """),format.raw/*97.189*/("""{"""),format.raw/*97.190*/("""
					 
					if(data.success) """),format.raw/*99.23*/("""{"""),format.raw/*99.24*/("""
						tr.remove();
						$("#dialogo-anulacion-productos").dialog( "destroy" );
					"""),format.raw/*102.6*/("""}"""),format.raw/*102.7*/(""" else """),format.raw/*102.13*/("""{"""),format.raw/*102.14*/("""
						alert(data.message);
					"""),format.raw/*104.6*/("""}"""),format.raw/*104.7*/("""
					$this.removeAttr('disabled');
					$('#menuAnulados').click();
				"""),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""");
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/("""
		"""),format.raw/*109.3*/("""}"""),format.raw/*109.4*/(""");
	"""),format.raw/*110.2*/("""}"""),format.raw/*110.3*/(""");
	
	
"""),format.raw/*113.1*/("""}"""),format.raw/*113.2*/(""");
</script>	
 
"""))}
    }
    
    def render(idOrdenCompra:Long,lineaForm:Form[OrdenLineaAnulacion],opl:List[OrdenProvisionLineas]): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineaForm,opl)
    
    def f:((Long,Form[OrdenLineaAnulacion],List[OrdenProvisionLineas]) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineaForm,opl) => apply(idOrdenCompra,lineaForm,opl)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/crearLineaProducto.scala.html
                    HASH: 69f741ee683843cd3da2e31c9f364d223a7282b8
                    MATRIX: 868->1|1061->112|1093->136|1167->91|1196->180|1453->402|1482->415|1521->416|1563->423|1628->479|1667->480|1725->502|1735->503|1773->519|1826->536|1836->537|1868->547|1980->623|1990->624|2027->639|2158->734|2168->735|2200->745|2301->810|2321->821|2425->902|2549->995|2587->1002|2761->1141|2873->1231|2984->1314|3013->1315|3133->1407|3162->1408|3506->1716|3526->1727|3621->1800|3652->1803|3681->1804|3740->1834|3770->1835|3817->1853|3847->1854|3897->1876|3926->1877|3982->1897|4002->1908|4109->1992|4141->1995|4171->1996|4277->2073|4307->2074|4353->2091|4383->2092|4435->2116|4464->2117|4563->2189|4591->2190|4625->2196|4654->2197|4790->2305|4819->2306|5057->2516|5086->2517|5151->2554|5180->2555|5446->2793|5475->2794|5515->2806|5544->2807|5612->2847|5641->2848|5871->3050|5900->3051|5969->3092|5998->3093|6046->3113|6075->3114|6180->3191|6209->3192|6254->3208|6284->3209|6351->3249|6380->3250|6433->3275|6462->3276|6503->3289|6532->3290|6577->3308|6605->3309|6638->3315|6666->3316|6700->3323|6728->3324|6759->3328|6788->3329|6844->3349|6864->3360|6951->3425|6982->3428|7011->3429|7117->3506|7147->3507|7193->3524|7223->3525|7283->3557|7312->3558|7429->3647|7458->3648|7493->3654|7523->3655|7586->3690|7615->3691|7719->3767|7748->3768|7783->3775|7812->3776|7844->3780|7873->3781|7906->3786|7935->3787|7973->3797|8002->3798
                    LINES: 26->1|29->3|29->3|30->1|31->3|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|56->28|57->29|62->34|62->34|69->41|69->41|71->43|71->43|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|85->57|85->57|88->60|88->60|88->60|88->60|91->63|91->63|99->71|99->71|100->72|100->72|105->77|105->77|106->78|106->78|107->79|107->79|112->84|112->84|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|116->88|116->88|118->90|118->90|119->91|119->91|121->93|121->93|122->94|122->94|123->95|123->95|123->95|123->95|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|127->99|127->99|130->102|130->102|130->102|130->102|132->104|132->104|135->107|135->107|136->108|136->108|137->109|137->109|138->110|138->110|141->113|141->113
                    -- GENERATED --
                */
            