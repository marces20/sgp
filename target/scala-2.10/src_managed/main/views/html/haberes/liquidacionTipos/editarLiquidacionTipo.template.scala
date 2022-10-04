
package views.html.haberes.liquidacionTipos

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
object editarLiquidacionTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Tipo de Liquidación")/*5.65*/ {_display_(Seq[Any](format.raw/*5.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Tipo de Liquidación</h1>
			</div>
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*17.3*/views/*17.8*/.html.tags.successError())),format.raw/*17.33*/("""
	
	"""),_display_(Seq[Any](/*19.3*/helper/*19.9*/.form(action = controllers.haberes.routes.LiquidacionTiposController.actualizar())/*19.91*/ {_display_(Seq[Any](format.raw/*19.93*/("""
		"""),_display_(Seq[Any](/*20.4*/inputText(tipoForm("id"), 'hidden -> "hidden"))),format.raw/*20.50*/("""
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.haberes.liquidacionTipos.formLiquidacionTipo(tipoForm))),format.raw/*21.69*/("""
	""")))})),format.raw/*22.3*/("""

""")))})))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionTipos/editarLiquidacionTipo.scala.html
                    HASH: 6e62b808ed4c242cbd34dd4b0964d2b18971e005
                    MATRIX: 845->1|995->68|1027->92|1101->49|1129->136|1166->139|1178->144|1244->202|1283->204|1501->387|1514->392|1561->417|1601->422|1615->428|1706->510|1746->512|1785->516|1853->562|1892->566|1905->571|1987->631|2021->634
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|45->17|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|49->21|49->21|49->21|50->22
                    -- GENERATED --
                */
            