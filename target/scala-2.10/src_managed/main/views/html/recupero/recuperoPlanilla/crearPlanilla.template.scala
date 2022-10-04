
package views.html.recupero.recuperoPlanilla

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
object crearPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoPlanilla],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(planillaForm: Form[models.recupero.RecuperoPlanilla]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/recupero/planilla.js"))),format.raw/*5.68*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.recupero.mainRecupero("Crear Planilla", scripts)/*8.61*/ {_display_(Seq[Any](format.raw/*8.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva planilla</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.recupero.routes.RecuperoPlanillasController.guardar())/*23.93*/ {_display_(Seq[Any](format.raw/*23.95*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.recupero.recuperoPlanilla.formPlanilla(planillaForm))),format.raw/*25.67*/(""" 


	""")))})),format.raw/*28.3*/("""
""")))})))}
    }
    
    def render(planillaForm:Form[models.recupero.RecuperoPlanilla]): play.api.templates.HtmlFormat.Appendable = apply(planillaForm)
    
    def f:((Form[models.recupero.RecuperoPlanilla]) => play.api.templates.HtmlFormat.Appendable) = (planillaForm) => apply(planillaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/crearPlanilla.scala.html
                    HASH: 27679223d0609527dc2c227b5dda372854e290e4
                    MATRIX: 840->1|987->75|1001->82|1085->86|1136->102|1150->108|1217->154|1292->55|1319->73|1346->190|1383->193|1395->198|1457->252|1496->254|1669->392|1708->422|1748->424|1823->464|1837->469|1872->482|1918->497|1964->508|1979->514|2069->595|2109->597|2150->603|2163->608|2243->666|2280->672
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|58->28
                    -- GENERATED --
                */
            