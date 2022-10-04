
package views.html.dashboard.ultimasCotizaciones

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
object crearUltimaCotizaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[UltimaCotizacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(coForm: Form[UltimaCotizacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	 
""")))};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.mainDashboard("Crear Cotizacion", scripts)/*8.65*/ {_display_(Seq[Any](format.raw/*8.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva Cotizacion</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/views/*17.8*/.html.tags.successError())),format.raw/*17.33*/("""
    
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.form(action = controllers.dashboard.routes.UltimasCotizacionesController.guardarUltimaCotizaciones())/*19.114*/ {_display_(Seq[Any](format.raw/*19.116*/("""

		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.dashboard.ultimasCotizaciones.formUltimaCotizaciones(coForm))),format.raw/*21.75*/("""  
		

	""")))})),format.raw/*24.3*/("""
""")))})))}
    }
    
    def render(coForm:Form[UltimaCotizacion]): play.api.templates.HtmlFormat.Appendable = apply(coForm)
    
    def f:((Form[UltimaCotizacion]) => play.api.templates.HtmlFormat.Appendable) = (coForm) => apply(coForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/ultimasCotizaciones/crearUltimaCotizaciones.scala.html
                    HASH: 4d96a271eaee66bfbf2d3bca901d655d40d48cdd
                    MATRIX: 838->1|963->53|977->60|1061->64|1105->33|1132->51|1159->69|1196->72|1208->77|1274->135|1313->137|1488->277|1501->282|1548->307|1594->318|1609->324|1721->426|1762->428|1803->434|1816->439|1904->505|1944->514
                    LINES: 26->1|29->4|29->4|31->4|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|49->19|51->21|51->21|51->21|54->24
                    -- GENERATED --
                */
            