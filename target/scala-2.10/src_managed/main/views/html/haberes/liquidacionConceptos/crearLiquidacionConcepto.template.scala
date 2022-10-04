
package views.html.haberes.liquidacionConceptos

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
object crearLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConcepto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(conceptoForm: Form[models.haberes.LiquidacionConcepto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/script/*3.8*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.12*/("""
<script src=""""),_display_(Seq[Any](/*4.15*/routes/*4.21*/.Assets.at("javascripts/haberes/baseCalculo.js"))),format.raw/*4.69*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.haberes.mainHaberes("Crear Concepto", script)/*6.58*/ {_display_(Seq[Any](format.raw/*6.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Concepto</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*15.3*/views/*15.8*/.html.tags.successError())),format.raw/*15.33*/("""
    
    """),_display_(Seq[Any](/*17.6*/helper/*17.12*/.form(action = controllers.haberes.routes.LiquidacionConceptosController.guardar())/*17.95*/ {_display_(Seq[Any](format.raw/*17.97*/("""
		"""),_display_(Seq[Any](/*18.4*/views/*18.9*/.html.haberes.liquidacionConceptos.formLiquidacionConcepto(conceptoForm))),format.raw/*18.81*/(""" 	
	""")))})),format.raw/*19.3*/("""
""")))})))}
    }
    
    def render(conceptoForm:Form[models.haberes.LiquidacionConcepto]): play.api.templates.HtmlFormat.Appendable = apply(conceptoForm)
    
    def f:((Form[models.haberes.LiquidacionConcepto]) => play.api.templates.HtmlFormat.Appendable) = (conceptoForm) => apply(conceptoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/crearLiquidacionConcepto.scala.html
                    HASH: 84cc8e38ff53455098c127f107aaab03a2ae6f4f
                    MATRIX: 856->1|1005->76|1018->82|1102->86|1152->101|1166->107|1235->155|1310->57|1337->191|1373->193|1385->198|1444->249|1483->251|1657->390|1670->395|1717->420|1763->431|1778->437|1870->520|1910->522|1949->526|1962->531|2056->603|2092->608
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|34->1|35->5|36->6|36->6|36->6|36->6|45->15|45->15|45->15|47->17|47->17|47->17|47->17|48->18|48->18|48->18|49->19
                    -- GENERATED --
                */
            