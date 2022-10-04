
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
object contenidoTabDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.79*/("""

<div class="panel panel-default">
	<div class="panel-heading"><b>Detalles</b></div>
	<div class="panel-body">
	
		<div class="row margin-bottom-25">
			<div class="col-sm-12">
				<h4>Base: 	<b>"""),_display_(Seq[Any](/*9.20*/if(factura.getBase() != null)/*9.49*/{_display_(Seq[Any](_display_(Seq[Any](/*9.51*/utils/*9.56*/.NumberUtils.moneda(factura.getBase())))))}/*9.95*/else/*9.99*/{_display_(Seq[Any](format.raw/*9.100*/("""0,00""")))})),format.raw/*9.105*/("""</b></h4>
				<h4>Total: 	<b>"""),_display_(Seq[Any](/*10.21*/if(factura.getTotal() != null)/*10.51*/{_display_(Seq[Any](_display_(Seq[Any](/*10.53*/utils/*10.58*/.NumberUtils.moneda(factura.getTotal())))))}/*10.98*/else/*10.102*/{_display_(Seq[Any](format.raw/*10.103*/("""0,00""")))})),format.raw/*10.108*/("""</b></h4>
				<h4>Total Retenciones: 	<b>"""),_display_(Seq[Any](/*11.33*/if(factura.getTotalImpuesto() != null)/*11.71*/{_display_(Seq[Any](_display_(Seq[Any](/*11.73*/utils/*11.78*/.NumberUtils.moneda(factura.getTotalImpuesto())))))}/*11.126*/else/*11.130*/{_display_(Seq[Any](format.raw/*11.131*/("""0,00""")))})),format.raw/*11.136*/("""</b></h4>
				<h4>Saldo pendiente: 	<b>"""),_display_(Seq[Any](/*12.31*/if(factura.getSaldoPendiente() != null)/*12.70*/{_display_(Seq[Any](_display_(Seq[Any](/*12.72*/utils/*12.77*/.NumberUtils.moneda(factura.getSaldoPendiente())))))}/*12.126*/else/*12.130*/{_display_(Seq[Any](format.raw/*12.131*/("""0,00""")))})),format.raw/*12.136*/("""</b></h4>
				
				<h4>Estado: 
					"""),_display_(Seq[Any](/*15.7*/if(factura.facturaParciales != null && factura.facturaParciales.size() > 0)/*15.82*/{_display_(Seq[Any](format.raw/*15.83*/("""
						<b>Parcializada</b>
					""")))}/*17.7*/else/*17.11*/{_display_(Seq[Any](format.raw/*17.12*/("""
						<b>"""),_display_(Seq[Any](/*18.11*/factura/*18.18*/.estado.nombre)),format.raw/*18.32*/("""</b>
					""")))})),format.raw/*19.7*/("""	
					
				</h4>
			</div>
		</div>

	</div>
</div>"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabDetalle.scala.html
                    HASH: ba99888e7e1e417adad4afa213c9cb39f39ec9ca
                    MATRIX: 833->1|1004->78|1244->283|1281->312|1328->314|1341->319|1392->358|1404->362|1443->363|1480->368|1547->399|1586->429|1634->431|1648->436|1701->476|1715->480|1755->481|1793->486|1872->529|1919->567|1967->569|1981->574|2043->622|2057->626|2097->627|2135->632|2212->673|2260->712|2308->714|2322->719|2385->768|2399->772|2439->773|2477->778|2553->819|2637->894|2676->895|2729->930|2742->934|2781->935|2829->947|2845->954|2881->968|2924->980
                    LINES: 26->1|29->1|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|40->12|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            