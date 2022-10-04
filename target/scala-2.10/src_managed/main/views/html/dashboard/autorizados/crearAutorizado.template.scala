
package views.html.dashboard.autorizados

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
object crearAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Autorizado],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(autorizadoForm: Form[Autorizado]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/dashboard/autorizado.js"))),format.raw/*5.71*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.dashboard.mainDashboard("Crear Autorizado", scripts)/*8.65*/ {_display_(Seq[Any](format.raw/*8.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo Autorizado</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/views/*17.8*/.html.tags.successError())),format.raw/*17.33*/("""
    
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.form(action = controllers.dashboard.routes.AutorizadosController.guardar())/*19.88*/ {_display_(Seq[Any](format.raw/*19.90*/("""

		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.dashboard.autorizados.formAutorizado(autorizadoForm))),format.raw/*21.67*/(""" 
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.dashboard.autorizados.tabsAutorizados(true, autorizadoForm))),format.raw/*22.74*/("""
		

	""")))})),format.raw/*25.3*/("""
""")))})))}
    }
    
    def render(autorizadoForm:Form[Autorizado]): play.api.templates.HtmlFormat.Appendable = apply(autorizadoForm)
    
    def f:((Form[Autorizado]) => play.api.templates.HtmlFormat.Appendable) = (autorizadoForm) => apply(autorizadoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/crearAutorizado.scala.html
                    HASH: b36e8882519b9cdfa428bd64a8ceff17ee49e7b1
                    MATRIX: 816->1|943->55|957->62|1041->66|1092->82|1106->88|1176->137|1251->35|1278->53|1305->173|1342->176|1354->181|1420->239|1459->241|1634->381|1647->386|1694->411|1740->422|1755->428|1840->504|1880->506|1921->512|1934->517|2014->575|2054->580|2067->585|2154->650|2192->657
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|49->19|51->21|51->21|51->21|52->22|52->22|52->22|55->25
                    -- GENERATED --
                */
            