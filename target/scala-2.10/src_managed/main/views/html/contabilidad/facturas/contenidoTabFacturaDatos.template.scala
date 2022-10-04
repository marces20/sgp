
package views.html.contabilidad.facturas

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
object contenidoTabFacturaDatos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/if(factura != null)/*6.21*/{_display_(Seq[Any](format.raw/*6.22*/("""
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
						<td><b>"""),_display_(Seq[Any](/*23.15*/if(factura != null && factura.orden != null)/*23.59*/{_display_(Seq[Any](_display_(Seq[Any](/*23.61*/utils/*23.66*/.NumberUtils.moneda(factura.orden.getTotalTotal())))))})),format.raw/*23.117*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*24.15*/if(factura != null && factura.orden != null)/*24.59*/{_display_(Seq[Any](_display_(Seq[Any](/*24.61*/utils/*24.66*/.NumberUtils.moneda(Factura.getTotalMontoFacturasCargadas(factura.id))))))})),format.raw/*24.137*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*25.15*/if(factura != null && factura.orden != null)/*25.59*/{_display_(Seq[Any](_display_(Seq[Any](/*25.61*/utils/*25.66*/.NumberUtils.moneda(factura.orden.getTotalTotal().subtract(Factura.getTotalMontoFacturasCargadas(factura.id)))))))})),format.raw/*25.177*/("""</b></td>
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
						<td>#</td>
					</tr>
					</thead>
					<tbody>
					
					"""),_display_(Seq[Any](/*47.7*/for(s <- Factura.getFacturasDatosCargadas(factura.id) ) yield /*47.62*/{_display_(Seq[Any](format.raw/*47.63*/("""
					
					<tr>
						<td><b>"""),_display_(Seq[Any](/*50.15*/s/*50.16*/.getString("nombre"))),format.raw/*50.36*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*51.15*/s/*51.16*/.getString("numero_factura"))),format.raw/*51.44*/("""</b></td>
						<td><b>"""),_display_(Seq[Any](/*52.15*/utils/*52.20*/.NumberUtils.moneda(s.getBigDecimal("monto")))),format.raw/*52.65*/("""</b></td>
						<td><a class="btn btn-default btn-xs delete-confirm-link" href=""""),_display_(Seq[Any](/*53.72*/controllers/*53.83*/.contabilidad.routes.FacturasController.eliminarFacturaDato(s.getLong("""id""")))),_display_(Seq[Any](/*53.164*/UriTrack/*53.172*/.get("&"))),format.raw/*53.181*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
					</tr>
					""")))})),format.raw/*55.7*/("""
					</tbody>
				</table>
			</div>
		</div>	
	</div>
</div>
""")))})))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabFacturaDatos.scala.html
                    HASH: 808f2456db55def69958d0ed50a74226ea84e367
                    MATRIX: 838->1|1033->113|1065->137|1139->78|1167->181|1205->185|1232->204|1270->205|1700->599|1753->643|1801->645|1815->650|1893->701|1953->725|2006->769|2054->771|2068->776|2166->847|2226->871|2279->915|2327->917|2341->922|2479->1033|2950->1469|3021->1524|3060->1525|3127->1556|3137->1557|3179->1577|3239->1601|3249->1602|3299->1630|3359->1654|3373->1659|3440->1704|3557->1785|3577->1796|3689->1877|3707->1885|3739->1894|3855->1979
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|54->25|54->25|54->25|54->25|54->25|76->47|76->47|76->47|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|82->53|82->53|84->55
                    -- GENERATED --
                */
            