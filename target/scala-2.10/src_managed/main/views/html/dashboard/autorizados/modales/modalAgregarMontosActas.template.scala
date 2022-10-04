
package views.html.dashboard.autorizados.modales

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
object modalAgregarMontosActas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[ActaRecepcion],Long,Long,Long,models.informes.InformeDeudaPorActaMaterializada,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaActas: List[ActaRecepcion],idAutorizado:Long,idOp:Long,idOrdenCompra:Long,ida:models.informes.InformeDeudaPorActaMaterializada,tipo_cuenta_id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var monto_t=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.155*/("""
"""),format.raw/*3.1*/("""<form action=""""),_display_(Seq[Any](/*3.16*/controllers/*3.27*/.dashboard.routes.AutorizadosController.cargarLineasAutorizados())),format.raw/*3.92*/("""" method="POST" id="formCargarLineasAutorizadosActas">

<input type="hidden" name="idAutorizado" value=""""),_display_(Seq[Any](/*5.50*/idAutorizado)),format.raw/*5.62*/(""""/>
<input type="hidden" name="idOp" value=""""),_display_(Seq[Any](/*6.42*/idOp)),format.raw/*6.46*/(""""/>
<input type="hidden" name="profe" value=""/>
<input type="hidden" name="idOrdenCompra" value=""""),_display_(Seq[Any](/*8.51*/idOrdenCompra)),format.raw/*8.64*/(""""/> 
<input type="hidden" name="tipo_cuenta_id" value=""""),_display_(Seq[Any](/*9.52*/tipo_cuenta_id)),format.raw/*9.66*/(""""/> 

<table id="tablaAutorizadosActas" class="table table-bordered table-hover">
	<thead>
		<tr>
 			<th colspan="4" align="right">
	 			 <span style="font-weight:bold;font-size:14px;">TOTAL A CARGAR</span>
			</th>
			<th colspan="4" align="center">
	 			 <span class="totales" style="font-weight:bold;font-size:14px;">$0.00</span>
			</th>
 		</tr>
 		 
		<tr>
			<th width="30">
				<input type="checkbox" name="" id="seleccionarTodos"/>
			</th>
			<th width="40">N°</th>
			<th width="40">Fecha</th>
			<th width="40">Periodo</th>
			<th width="100">Total</th>
			<th width="100">Deuda Limite</th>
			<th width="100">Total Deuda</th>
			<th width="100">Monto a Cargar</th>
		</tr>
		
	</thead>
	<tbody>
		
	   		"""),_display_(Seq[Any](/*38.8*/for(a <- listaActas) yield /*38.28*/ {_display_(Seq[Any](format.raw/*38.30*/("""
				<tr data-id=""""),_display_(Seq[Any](/*39.19*/a/*39.20*/.id)),format.raw/*39.23*/("""" class="seleccionarFila">
					<td>
						<input type="checkbox" class="checkFila" name="id[]" value=""""),_display_(Seq[Any](/*41.68*/a/*41.69*/.id)),format.raw/*41.72*/(""""/>
					</td>
					<td>"""),_display_(Seq[Any](/*43.11*/a/*43.12*/.numero)),format.raw/*43.19*/("""</td>
					
					<td align="center">"""),_display_(Seq[Any](/*45.26*/if(a.fecha != null)/*45.45*/{_display_(Seq[Any](_display_(Seq[Any](/*45.47*/(utils.DateUtils.formatDate(a.fecha))))))})),format.raw/*45.85*/("""</td>
					<td>"""),_display_(Seq[Any](/*46.11*/if(a.periodo_id != null)/*46.35*/ {_display_(Seq[Any](_display_(Seq[Any](/*46.38*/Periodo/*46.45*/.find.byId(a.periodo_id).nombre))))})),format.raw/*46.77*/("""</td>
					<td align="center">
						"""),_display_(Seq[Any](/*48.8*/(utils.NumberUtils.moneda(a.getTotal())))),format.raw/*48.48*/("""
						<input type="hidden" name="monto_total[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*49.109*/a/*49.110*/.getTotal())),format.raw/*49.121*/(""""/>
					</td>
					<td align="center">
						"""),_display_(Seq[Any](/*52.8*/(utils.NumberUtils.moneda(ida.totalDeudaLimite)))),format.raw/*52.56*/("""
						<input type="hidden" name="monto_deuda_limite[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*53.116*/ida/*53.119*/.totalDeudaLimite)),format.raw/*53.136*/(""""/>
					</td>
					<td align="center">
						"""),_display_(Seq[Any](/*56.8*/(utils.NumberUtils.moneda(ida.totalDeuda)))),format.raw/*56.50*/("""
						<input type="hidden" name="monto_deuda[]" disabled="disabled" class="montoTotal form-control" value=""""),_display_(Seq[Any](/*57.109*/ida/*57.112*/.totalDeuda)),format.raw/*57.123*/(""""/>
					</td>
					<td>
						<input type="input" name="monto[]" disabled="disabled" class="monto form-control" />
						<p class="pErrores" style="font-weight:bold;"></p>
					</td>
				</tr>    
				"""),_display_(Seq[Any](/*64.6*/{monto_t= monto_t.add(a.getTotal())})),format.raw/*64.42*/("""
		 	""")))})),format.raw/*65.6*/("""	 	
		 	<tr>
					<td colspan="4" align="right"><span style="font-weight:bold;font-size:14px;">Total Actas</span></td>
					<td align="center">
						"""),_display_(Seq[Any](/*69.8*/(utils.NumberUtils.moneda(monto_t)))),format.raw/*69.43*/("""
						<input type="hidden" name="monto_t" class="" value=""""),_display_(Seq[Any](/*70.60*/monto_t)),format.raw/*70.67*/(""""/>
					</td>
					<td colspan="3" align="center"></td>
					 
			</tr>		
   	</tbody>
   	<tfoot>
   		<tr>
 			<td colspan="4" align="right">
	 			 <span style="font-weight:bold;font-size:14px;">TOTAL A CARGAR</span>
			</td>
			<td colspan="5" align="center">
	 			 <span class="totales" style="font-weight:bold;font-size:14px;">$0.00</span>
			</td>
 		</tr>
 		<tr>
 			<td colspan="8" align="center">
	 			<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<div id="loadingAgregarMontoActa" class="loading hide"></div>
					<button  id="btn-agregarMontoActa" class="form-control btn btn-primary">Cargar</button>
				</div>
			</td>
 		</tr>
	</tfoot>
   </table>
 </form>  
 
 
 
 
 
<script>
$( function()"""),format.raw/*103.14*/("""{"""),format.raw/*103.15*/("""
	$(".monto,.monto_general").numeric_input("""),format.raw/*104.43*/("""{"""),format.raw/*104.44*/("""allowNegative: false"""),format.raw/*104.64*/("""}"""),format.raw/*104.65*/(""");
	
	$('.monto').focusout( function()"""),format.raw/*106.34*/("""{"""),format.raw/*106.35*/("""
		calcularTotal ($("#tablaAutorizados tr"));
	"""),format.raw/*108.2*/("""}"""),format.raw/*108.3*/(""");
	
	$('.checkFila').change( function()"""),format.raw/*110.36*/("""{"""),format.raw/*110.37*/("""	
		seleccionAutorizado( $(this).closest('tr') );
		$("#tablaAutorizadosActas tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal($("#tablaAutorizados tr"));
	"""),format.raw/*115.2*/("""}"""),format.raw/*115.3*/(""");
	
	$('#seleccionarTodos').change( function()"""),format.raw/*117.43*/("""{"""),format.raw/*117.44*/("""
		var table = $(this).closest('table');
		table.find("input[name='id[]']").prop("checked", $(this).prop("checked"));
		seleccionAutorizado( $('#tablaAutorizadosActas tbody tr') );
		$("#tablaAutorizadosActas tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ($("#tablaAutorizadosActas tr"));
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/(""");
	 
	
	
"""),format.raw/*128.1*/("""}"""),format.raw/*128.2*/(""");
</script>"""))}
    }
    
    def render(listaActas:List[ActaRecepcion],idAutorizado:Long,idOp:Long,idOrdenCompra:Long,ida:models.informes.InformeDeudaPorActaMaterializada,tipo_cuenta_id:Long): play.api.templates.HtmlFormat.Appendable = apply(listaActas,idAutorizado,idOp,idOrdenCompra,ida,tipo_cuenta_id)
    
    def f:((List[ActaRecepcion],Long,Long,Long,models.informes.InformeDeudaPorActaMaterializada,Long) => play.api.templates.HtmlFormat.Appendable) = (listaActas,idAutorizado,idOp,idOrdenCompra,ida,tipo_cuenta_id) => apply(listaActas,idAutorizado,idOp,idOrdenCompra,ida,tipo_cuenta_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/modales/modalAgregarMontosActas.scala.html
                    HASH: 780ea099e2c5b712958cfe86cc0ecbfdab19d7dd
                    MATRIX: 904->1|1221->154|1248->225|1298->240|1317->251|1403->316|1543->421|1576->433|1656->478|1681->482|1815->581|1849->594|1940->650|1975->664|2729->1383|2765->1403|2805->1405|2860->1424|2870->1425|2895->1428|3035->1532|3045->1533|3070->1536|3131->1561|3141->1562|3170->1569|3243->1606|3271->1625|3319->1627|3383->1665|3435->1681|3468->1705|3517->1708|3533->1715|3591->1747|3664->1785|3726->1825|3872->1934|3883->1935|3917->1946|3999->1993|4069->2041|4222->2157|4235->2160|4275->2177|4357->2224|4421->2266|4567->2375|4580->2378|4614->2389|4852->2592|4910->2628|4947->2634|5133->2785|5190->2820|5286->2880|5315->2887|6098->3641|6128->3642|6200->3685|6230->3686|6279->3706|6309->3707|6376->3745|6406->3746|6481->3793|6510->3794|6579->3834|6609->3835|6827->4025|6856->4026|6932->4073|6962->4074|7317->4401|7346->4402|7384->4412|7413->4413
                    LINES: 26->1|30->1|31->3|31->3|31->3|31->3|33->5|33->5|34->6|34->6|36->8|36->8|37->9|37->9|66->38|66->38|66->38|67->39|67->39|67->39|69->41|69->41|69->41|71->43|71->43|71->43|73->45|73->45|73->45|73->45|74->46|74->46|74->46|74->46|74->46|76->48|76->48|77->49|77->49|77->49|80->52|80->52|81->53|81->53|81->53|84->56|84->56|85->57|85->57|85->57|92->64|92->64|93->65|97->69|97->69|98->70|98->70|131->103|131->103|132->104|132->104|132->104|132->104|134->106|134->106|136->108|136->108|138->110|138->110|143->115|143->115|145->117|145->117|152->124|152->124|156->128|156->128
                    -- GENERATED --
                */
            