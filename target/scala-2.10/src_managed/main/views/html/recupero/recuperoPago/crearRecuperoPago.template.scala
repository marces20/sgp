
package views.html.recupero.recuperoPago

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
object crearRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoPagoForm: Form[models.recupero.RecuperoPago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/recupero/pago.js"))),format.raw/*5.64*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.recupero.mainRecupero("Crear Pago", scripts)/*8.57*/ {_display_(Seq[Any](format.raw/*8.59*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo pago</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.recupero.routes.RecuperoPagosController.guardar())/*23.89*/ {_display_(Seq[Any](format.raw/*23.91*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.recupero.recuperoPago.formRecuperoPago(recuperoPagoForm,null))),format.raw/*25.76*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.recupero.recuperoPago.tabsRecuperoPago(true,recuperoPagoForm))),format.raw/*26.76*/("""	


	""")))})),format.raw/*29.3*/("""
""")))})))}
    }
    
    def render(recuperoPagoForm:Form[models.recupero.RecuperoPago]): play.api.templates.HtmlFormat.Appendable = apply(recuperoPagoForm)
    
    def f:((Form[models.recupero.RecuperoPago]) => play.api.templates.HtmlFormat.Appendable) = (recuperoPagoForm) => apply(recuperoPagoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/crearRecuperoPago.scala.html
                    HASH: f724ed47e5d7a80692a76ac3659308397ca56a55
                    MATRIX: 836->1|983->75|997->82|1081->86|1132->102|1146->108|1209->150|1284->55|1311->73|1338->186|1375->189|1387->194|1445->244|1484->246|1653->380|1692->410|1732->412|1807->452|1821->457|1856->470|1902->485|1948->496|1963->502|2049->579|2089->581|2130->587|2143->592|2232->659|2272->664|2285->669|2374->736|2411->742
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|56->26|56->26|56->26|59->29
                    -- GENERATED --
                */
            