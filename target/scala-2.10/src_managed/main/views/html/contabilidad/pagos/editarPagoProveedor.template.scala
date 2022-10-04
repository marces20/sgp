
package views.html.contabilidad.pagos

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
object editarPagoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Pago],Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pagoForm: Form[Pago], pago: Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar pago")/*5.60*/ {_display_(Seq[Any](format.raw/*5.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Modificar pago</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/views/*15.8*/.html.tags.successError())),format.raw/*15.33*/("""
	
	"""),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(action = controllers.contabilidad.routes.PagosController.actualizar(pago.id))/*17.92*/ {_display_(Seq[Any](format.raw/*17.94*/("""
		"""),_display_(Seq[Any](/*18.4*/inputText(pagoForm("id"), 'hidden -> "hidden"))),format.raw/*18.50*/("""
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.contabilidad.pagos.formPagoProveedor(pagoForm))),format.raw/*19.61*/("""
		<hr>
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.contabilidad.pagos.tabsPago(true,pagoForm,pago))),format.raw/*21.62*/("""
		
		<h4>Total Debito: 	<b>"""),_display_(Seq[Any](/*23.26*/utils/*23.31*/.NumberUtils.moneda(pago.total))),format.raw/*23.62*/("""</b></h4>	
		<h4>Total Credito: 	<b>"""),_display_(Seq[Any](/*24.27*/utils/*24.32*/.NumberUtils.moneda(pago.total_credito))),format.raw/*24.71*/("""</b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*25.27*/pago/*25.31*/.estado.nombre)),format.raw/*25.45*/("""</b></h4>
		
		<div class="row margin-bottom-25">	
			
		</div>
	""")))})),format.raw/*30.3*/("""

""")))})))}
    }
    
    def render(pagoForm:Form[Pago],pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(pagoForm,pago)
    
    def f:((Form[Pago],Pago) => play.api.templates.HtmlFormat.Appendable) = (pagoForm,pago) => apply(pagoForm,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/editarPagoProveedor.scala.html
                    HASH: 6473a93cb7bd0dbdc65d50ad5b1abf2bbd6c8412
                    MATRIX: 816->1|952->54|984->78|1058->35|1086->122|1123->125|1135->130|1196->183|1235->185|1405->320|1418->325|1465->350|1505->355|1519->361|1611->444|1651->446|1690->450|1758->496|1797->500|1810->505|1884->557|1930->568|1943->573|2018->626|2083->655|2097->660|2150->691|2223->728|2237->733|2298->772|2371->809|2384->813|2420->827|2517->893
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|45->17|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|58->30
                    -- GENERATED --
                */
            