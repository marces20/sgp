
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
object crearRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoFactura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoFacturaForm: Form[models.recupero.RecuperoFactura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/recupero/recuperoFactura.js"))),format.raw/*5.75*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.recupero.mainRecupero("Crear Factura", scripts)/*8.60*/ {_display_(Seq[Any](format.raw/*8.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva factura</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.recupero.routes.RecuperoFacturasController.guardar())/*23.92*/ {_display_(Seq[Any](format.raw/*23.94*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.recupero.recuperoFactura.formRecuperoFactura(recuperoFacturaForm))),format.raw/*25.80*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.recupero.recuperoFactura.tabsRecuperoFactura(true, recuperoFacturaForm))),format.raw/*26.86*/("""	

	""")))})),format.raw/*28.3*/("""
""")))})))}
    }
    
    def render(recuperoFacturaForm:Form[models.recupero.RecuperoFactura]): play.api.templates.HtmlFormat.Appendable = apply(recuperoFacturaForm)
    
    def f:((Form[models.recupero.RecuperoFactura]) => play.api.templates.HtmlFormat.Appendable) = (recuperoFacturaForm) => apply(recuperoFacturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/crearRecuperoFactura.scala.html
                    HASH: cf06a907543cb784ebf12a2d91a55e722bab3322
                    MATRIX: 845->1|998->81|1012->88|1096->92|1147->108|1161->114|1235->167|1310->61|1337->79|1364->203|1401->206|1413->211|1474->264|1513->266|1685->403|1724->433|1764->435|1839->475|1853->480|1888->493|1934->508|1980->519|1995->525|2084->605|2124->607|2165->613|2178->618|2271->689|2311->694|2324->699|2423->776|2459->781
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|56->26|56->26|56->26|58->28
                    -- GENERATED --
                */
            