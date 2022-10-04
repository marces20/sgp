
package views.html.recupero.recuperoFactura

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
object contenidoTabDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[models.recupero.RecuperoFactura] = null,factura:models.recupero.RecuperoFactura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.127*/("""

<div class="panel panel-default">
	<div class="panel-heading"><b>Detalles</b></div>
	<div class="panel-body">
	
		<div class="row margin-bottom-25">
			<div class="col-sm-12">
				<h4>Base: 	<b>"""),_display_(Seq[Any](/*9.20*/if(factura.getBase() != null)/*9.49*/{_display_(Seq[Any](_display_(Seq[Any](/*9.51*/utils/*9.56*/.NumberUtils.moneda(factura.getBase())))))}/*9.95*/else/*9.99*/{_display_(Seq[Any](format.raw/*9.100*/("""0,00""")))})),format.raw/*9.105*/("""</b></h4>
				<h4>Total: 	<b>"""),_display_(Seq[Any](/*10.21*/if(factura.getTotal() != null)/*10.51*/{_display_(Seq[Any](_display_(Seq[Any](/*10.53*/utils/*10.58*/.NumberUtils.moneda(factura.getTotal())))))}/*10.98*/else/*10.102*/{_display_(Seq[Any](format.raw/*10.103*/("""0,00""")))})),format.raw/*10.108*/("""</b></h4>
				<h4>Total Notas Creditos: 	<b>"""),_display_(Seq[Any](/*11.36*/if(factura.getTotalNotaCredito() != null)/*11.77*/{_display_(Seq[Any](_display_(Seq[Any](/*11.79*/utils/*11.84*/.NumberUtils.moneda(factura.getTotalNotaCredito())))))}/*11.135*/else/*11.139*/{_display_(Seq[Any](format.raw/*11.140*/("""0,00""")))})),format.raw/*11.145*/("""</b></h4>
				<h4>Saldo pendiente: 	<b>"""),_display_(Seq[Any](/*12.31*/if(factura.getSaldoPendiente() != null)/*12.70*/{_display_(Seq[Any](_display_(Seq[Any](/*12.72*/utils/*12.77*/.NumberUtils.moneda(factura.getSaldoPendiente())))))}/*12.126*/else/*12.130*/{_display_(Seq[Any](format.raw/*12.131*/("""0,00""")))})),format.raw/*12.136*/("""</b></h4>
				
				<h4>Estado: 
					<b>"""),_display_(Seq[Any](/*15.10*/factura/*15.17*/.estado.nombre)),format.raw/*15.31*/("""</b>
				</h4>
			</div>
		</div>

	</div>
</div>	
"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[models.recupero.RecuperoFactura],factura:models.recupero.RecuperoFactura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/contenidoTabDetalle.scala.html
                    HASH: 34f39534288ad9bd344d0fffcb1e273d85c9d747
                    MATRIX: 884->1|1104->126|1344->331|1381->360|1428->362|1441->367|1492->406|1504->410|1543->411|1580->416|1647->447|1686->477|1734->479|1748->484|1801->524|1815->528|1855->529|1893->534|1975->580|2025->621|2073->623|2087->628|2152->679|2166->683|2206->684|2244->689|2321->730|2369->769|2417->771|2431->776|2494->825|2508->829|2548->830|2586->835|2666->879|2682->886|2718->900
                    LINES: 26->1|29->1|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|40->12|43->15|43->15|43->15
                    -- GENERATED --
                */
            