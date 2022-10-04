
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
object crearFacturaProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facturaForm: Form[Factura],factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._


Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Crear Factura")/*5.59*/ {_display_(Seq[Any](format.raw/*5.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva factura</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*14.3*/views/*14.8*/.html.tags.successError())),format.raw/*14.33*/("""
    
    """),_display_(Seq[Any](/*16.6*/helper/*16.12*/.form(action = controllers.contabilidad.routes.FacturasController.guardar())/*16.88*/ {_display_(Seq[Any](format.raw/*16.90*/("""
		"""),_display_(Seq[Any](/*17.4*/views/*17.9*/.html.contabilidad.facturas.formFacturaProveedor(facturaForm))),format.raw/*17.70*/("""
		"""),_display_(Seq[Any](/*18.4*/views/*18.9*/.html.contabilidad.facturas.tabsFactura(false, false,facturaForm,factura))),format.raw/*18.82*/("""	
	""")))})),format.raw/*19.3*/("""
""")))})),format.raw/*20.2*/("""	"""))}
    }
    
    def render(facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(facturaForm,factura)
    
    def f:((Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (facturaForm,factura) => apply(facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/crearFacturaProveedor.scala.html
                    HASH: 16a5e9fcec82cd8e8032cfea4443f121983adb35
                    MATRIX: 827->1|997->45|1024->79|1060->81|1072->86|1132->138|1171->140|1344->278|1357->283|1404->308|1450->319|1465->325|1550->401|1590->403|1629->407|1642->412|1725->473|1764->477|1777->482|1872->555|1907->559|1940->561
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|43->14|43->14|43->14|45->16|45->16|45->16|45->16|46->17|46->17|46->17|47->18|47->18|47->18|48->19|49->20
                    -- GENERATED --
                */
            