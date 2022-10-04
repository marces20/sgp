
package views.html.haberes.centrosCostos

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
object editarCentroCosto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CentroCosto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(centroForm: Form[models.haberes.CentroCosto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Centro Costo")/*5.58*/ {_display_(Seq[Any](format.raw/*5.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Centro Costo</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
													 
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.CentrosCostosController.actualizar())/*20.88*/ {_display_(Seq[Any](format.raw/*20.90*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(centroForm("id"), 'hidden -> "hidden"))),format.raw/*21.52*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.centrosCostos.formCentroCosto(centroForm))),format.raw/*22.64*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(centroForm:Form[models.haberes.CentroCosto]): play.api.templates.HtmlFormat.Appendable = apply(centroForm)
    
    def f:((Form[models.haberes.CentroCosto]) => play.api.templates.HtmlFormat.Appendable) = (centroForm) => apply(centroForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/centrosCostos/editarCentroCosto.scala.html
                    HASH: 1497507f7e703603c3d0a603bfd043b0fddac609
                    MATRIX: 834->1|982->66|1014->90|1088->47|1116->134|1153->137|1165->142|1224->193|1263->195|1478->375|1491->380|1538->405|1591->423|1605->429|1693->508|1733->510|1772->514|1842->562|1881->566|1894->571|1971->626|2005->629
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            