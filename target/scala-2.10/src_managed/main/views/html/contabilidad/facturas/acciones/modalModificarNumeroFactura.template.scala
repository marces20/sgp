
package views.html.contabilidad.facturas.acciones

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
object modalModificarNumeroFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long,p:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.modificarNumeroFactura(), 'id -> "formModificarNumeroFactura")/*5.144*/ {_display_(Seq[Any](format.raw/*5.146*/("""
	<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*6.41*/id)),format.raw/*6.43*/("""" />
	
	"""),_display_(Seq[Any](/*8.3*/views/*8.8*/.html.tags.successError())),format.raw/*8.33*/("""
	
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Facturacion</b></div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>Monto Orden</td>
								<td>Monto Cargado</td>
								<td>Restante</td>
							</tr>
						<thead>
						<tbody>
						<tr>
							<td><b>"""),_display_(Seq[Any](/*25.16*/if(p != null && p.orden != null)/*25.48*/{_display_(Seq[Any](_display_(Seq[Any](/*25.50*/utils/*25.55*/.NumberUtils.moneda(p.orden.getTotalTotal())))))})),format.raw/*25.100*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*26.16*/if(p != null && p.orden != null)/*26.48*/{_display_(Seq[Any](_display_(Seq[Any](/*26.50*/utils/*26.55*/.NumberUtils.moneda(Factura.getTotalMontoFacturasCargadas(p.id))))))})),format.raw/*26.120*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*27.16*/if(p != null && p.orden != null)/*27.48*/{_display_(Seq[Any](_display_(Seq[Any](/*27.50*/utils/*27.55*/.NumberUtils.moneda(p.orden.getTotalTotal().subtract(Factura.getTotalMontoFacturasCargadas(p.id)))))))})),format.raw/*27.154*/("""</b></td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>	
		</div>
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Facturas cargadas</b></div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<thead>
						<tr>
							<td>Factura</td>
							<td>Numero</td>
							<td>Monto</td>
						</tr>
						</thead>
						<tbody>
						
						"""),_display_(Seq[Any](/*48.8*/for(s <- Factura.getFacturasDatosCargadas(p.id) ) yield /*48.57*/{_display_(Seq[Any](format.raw/*48.58*/("""
						
							<tr>
								<td><b>"""),_display_(Seq[Any](/*51.17*/s/*51.18*/.getString("nombre"))),format.raw/*51.38*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*52.17*/s/*52.18*/.getString("numero_factura"))),format.raw/*52.46*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*53.17*/utils/*53.22*/.NumberUtils.moneda(s.getBigDecimal("monto")))),format.raw/*53.67*/("""</b></td>
							</tr>
						""")))})),format.raw/*55.8*/("""
						</tbody>
					</table>
				</div>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*65.28*/if(formBuscador.error("numero_factura") != null)/*65.76*/ {_display_(Seq[Any](format.raw/*65.78*/("""has-error""")))})),format.raw/*65.88*/("""">
				<label for="inputNumeroFactura" class="control-label">N° Factura</label> 
				"""),_display_(Seq[Any](/*67.6*/inputText(formBuscador("numero_factura"), 'class -> "form-control", 'id -> "numero_factura", 'autofocus -> "autofocus"))),format.raw/*67.125*/("""
			</div>
			
			"""),_display_(Seq[Any](/*70.5*/formBuscador("numero_factura")/*70.35*/.error.map/*70.45*/{ error =>_display_(Seq[Any](format.raw/*70.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*71.30*/error/*71.35*/.message)),format.raw/*71.43*/("""</div>
			""")))})),format.raw/*72.5*/("""
		</div>
		
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*76.28*/if(formBuscador.error("monto") != null)/*76.67*/ {_display_(Seq[Any](format.raw/*76.69*/("""has-error""")))})),format.raw/*76.79*/("""">
				<label for="inputNumeroFactura" class="control-label">Monto</label> 
				"""),_display_(Seq[Any](/*78.6*/inputText(formBuscador("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*78.80*/("""
			</div>
			
			"""),_display_(Seq[Any](/*81.5*/formBuscador("monto")/*81.26*/.error.map/*81.36*/{ error =>_display_(Seq[Any](format.raw/*81.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*82.30*/error/*82.35*/.message)),format.raw/*82.43*/("""</div>
			""")))})),format.raw/*83.5*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*91.2*/("""
<script>
$( function()"""),format.raw/*93.14*/("""{"""),format.raw/*93.15*/(""" 
	$('#numero_factura').mask("a-9999-99999999");
	$("#monto").numeric_input("""),format.raw/*95.28*/("""{"""),format.raw/*95.29*/("""allowNegative: true"""),format.raw/*95.48*/("""}"""),format.raw/*95.49*/(""");

"""),format.raw/*97.1*/("""}"""),format.raw/*97.2*/(""")
</script>
"""),_display_(Seq[Any](/*99.2*/flash()/*99.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long,p:Factura): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id,p)
    
    def f:((DynamicForm,Long,Factura) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id,p) => apply(formBuscador,id,p)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalModificarNumeroFactura.scala.html
                    HASH: d163ed17e1b9c8041958f89b16cfae0fad09cbd9
                    MATRIX: 845->1|992->65|1024->89|1098->46|1126->133|1164->137|1177->143|1322->279|1362->281|1438->322|1461->324|1504->333|1516->338|1562->363|2002->767|2043->799|2091->801|2105->806|2177->851|2238->876|2279->908|2327->910|2341->915|2433->980|2494->1005|2535->1037|2583->1039|2597->1044|2723->1143|3198->1583|3263->1632|3302->1633|3374->1669|3384->1670|3426->1690|3488->1716|3498->1717|3548->1745|3610->1771|3624->1776|3691->1821|3752->1851|3930->1993|3987->2041|4027->2043|4069->2053|4190->2139|4332->2258|4386->2277|4425->2307|4444->2317|4492->2327|4558->2357|4572->2362|4602->2370|4644->2381|4745->2446|4793->2485|4833->2487|4875->2497|4991->2578|5087->2652|5141->2671|5171->2692|5190->2702|5238->2712|5304->2742|5318->2747|5348->2755|5390->2766|5616->2961|5667->2984|5696->2985|5800->3061|5829->3062|5876->3081|5905->3082|5936->3086|5964->3087|6012->3100|6027->3107
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|36->8|36->8|36->8|53->25|53->25|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|76->48|76->48|76->48|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|83->55|93->65|93->65|93->65|93->65|95->67|95->67|98->70|98->70|98->70|98->70|99->71|99->71|99->71|100->72|104->76|104->76|104->76|104->76|106->78|106->78|109->81|109->81|109->81|109->81|110->82|110->82|110->82|111->83|119->91|121->93|121->93|123->95|123->95|123->95|123->95|125->97|125->97|127->99|127->99
                    -- GENERATED --
                */
            