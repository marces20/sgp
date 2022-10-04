
package views.html.haberes.escalasLaborales

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
object editarEscalaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.EscalaLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(escalaForm: Form[models.haberes.EscalaLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Escala Laboral")/*5.60*/ {_display_(Seq[Any](format.raw/*5.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Escala laboral</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.EscalasLaboralesController.actualizar())/*20.91*/ {_display_(Seq[Any](format.raw/*20.93*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(escalaForm("id"), 'hidden -> "hidden"))),format.raw/*21.52*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.escalasLaborales.formEscalaLaboral(escalaForm))),format.raw/*22.69*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(escalaForm:Form[models.haberes.EscalaLaboral]): play.api.templates.HtmlFormat.Appendable = apply(escalaForm)
    
    def f:((Form[models.haberes.EscalaLaboral]) => play.api.templates.HtmlFormat.Appendable) = (escalaForm) => apply(escalaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaborales/editarEscalaLaboral.scala.html
                    HASH: 7521d2dcf473889f74153c65b43058b6d7a3d4a5
                    MATRIX: 841->1|991->68|1023->92|1097->49|1125->136|1162->139|1174->144|1235->197|1274->199|1491->381|1504->386|1551->411|1591->416|1605->422|1696->504|1736->506|1775->510|1845->558|1884->562|1897->567|1979->627|2013->630
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            