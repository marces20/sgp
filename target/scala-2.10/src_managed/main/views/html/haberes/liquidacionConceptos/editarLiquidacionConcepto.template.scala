
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
object editarLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConcepto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(conceptoForm: Form[models.haberes.LiquidacionConcepto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Concepto")/*5.54*/ {_display_(Seq[Any](format.raw/*5.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Concepto</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.LiquidacionConceptosController.actualizar())/*20.95*/ {_display_(Seq[Any](format.raw/*20.97*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(conceptoForm("id"), 'hidden -> "hidden"))),format.raw/*21.54*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.liquidacionConceptos.formLiquidacionConcepto(conceptoForm))),format.raw/*22.81*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(conceptoForm:Form[models.haberes.LiquidacionConcepto]): play.api.templates.HtmlFormat.Appendable = apply(conceptoForm)
    
    def f:((Form[models.haberes.LiquidacionConcepto]) => play.api.templates.HtmlFormat.Appendable) = (conceptoForm) => apply(conceptoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/editarLiquidacionConcepto.scala.html
                    HASH: 0092288c0c7d5cedd4134550839341a5e4a727c0
                    MATRIX: 857->1|1015->76|1047->100|1121->57|1149->144|1186->147|1198->152|1253->199|1292->201|1503->377|1516->382|1563->407|1603->412|1617->418|1712->504|1752->506|1791->510|1863->560|1902->564|1915->569|2009->641|2043->644
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            