
package views.html.haberes.liquidacionConceptoTipos

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
object editarLiquidacionConceptoTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConceptoTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionConceptoTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Tipo de Concepto")/*5.62*/ {_display_(Seq[Any](format.raw/*5.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Tipo de Concepto</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/views/*15.8*/.html.tags.successError())),format.raw/*15.33*/("""
	
	"""),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(action = controllers.haberes.routes.LiquidacionConceptoTiposController.actualizar())/*17.99*/ {_display_(Seq[Any](format.raw/*17.101*/("""
		"""),_display_(Seq[Any](/*18.4*/inputText(tipoForm("id"), 'hidden -> "hidden"))),format.raw/*18.50*/("""
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.haberes.liquidacionConceptoTipos.formLiquidacionConceptoTipo(tipoForm))),format.raw/*19.85*/("""
	""")))})),format.raw/*20.3*/("""

""")))})))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionConceptoTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionConceptoTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptoTipos/editarLiquidacionConceptoTipo.scala.html
                    HASH: b9398db078dfc37d4518293fb88c12f91cf88119
                    MATRIX: 869->1|1027->76|1059->100|1133->57|1161->144|1198->147|1210->152|1273->207|1312->209|1491->353|1504->358|1551->383|1591->388|1605->394|1704->484|1745->486|1784->490|1852->536|1891->540|1904->545|2002->621|2036->624
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|45->17|46->18|46->18|47->19|47->19|47->19|48->20
                    -- GENERATED --
                */
            