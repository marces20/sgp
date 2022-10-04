
package views.html.contabilidad.ordenesPagosCircuitos

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
object tabsOrdenPagoCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenPagoCircuito],OrdenPagoCircuito,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ocForm: Form[OrdenPagoCircuito] = null,oc:OrdenPagoCircuito):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.63*/("""

	<hr />

	<ul id="facturaTab" class="nav nav-tabs">
		<li class="active"><a class="tabPago" href="#contenedorPagos" data-toggle="tab">Pagos</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorProductos">
			"""),_display_(Seq[Any](/*10.5*/views/*10.10*/.html.contabilidad.ordenesPagosCircuitos.contenidoTabPago(ocForm))),format.raw/*10.75*/("""	
		</div>
	</div>

	"""))}
    }
    
    def render(ocForm:Form[OrdenPagoCircuito],oc:OrdenPagoCircuito): play.api.templates.HtmlFormat.Appendable = apply(ocForm,oc)
    
    def f:((Form[OrdenPagoCircuito],OrdenPagoCircuito) => play.api.templates.HtmlFormat.Appendable) = (ocForm,oc) => apply(ocForm,oc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/tabsOrdenPagoCircuito.scala.html
                    HASH: 3135f65b92c63104f1f95ad36a33586cca5ecdb2
                    MATRIX: 860->1|1015->62|1305->317|1319->322|1406->387
                    LINES: 26->1|29->1|38->10|38->10|38->10
                    -- GENERATED --
                */
            