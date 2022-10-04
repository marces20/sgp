
package views.html.haberes.legajos

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
object editarLegajo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Legajo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(legajoForm: Form[models.haberes.Legajo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Legajo")/*5.52*/ {_display_(Seq[Any](format.raw/*5.54*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Legajo</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
													 
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.LegajosController.actualizar())/*20.82*/ {_display_(Seq[Any](format.raw/*20.84*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(legajoForm("id"), 'hidden -> "hidden"))),format.raw/*21.52*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.legajos.formLegajo(legajoForm))),format.raw/*22.53*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(legajoForm:Form[models.haberes.Legajo]): play.api.templates.HtmlFormat.Appendable = apply(legajoForm)
    
    def f:((Form[models.haberes.Legajo]) => play.api.templates.HtmlFormat.Appendable) = (legajoForm) => apply(legajoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/legajos/editarLegajo.scala.html
                    HASH: da62643ce003e72f19f1ee4f295351ac2a34f3b9
                    MATRIX: 818->1|961->61|993->85|1067->42|1095->129|1132->132|1144->137|1197->182|1236->184|1445->358|1458->363|1505->388|1558->406|1572->412|1654->485|1694->487|1733->491|1803->539|1842->543|1855->548|1921->592|1955->595
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            