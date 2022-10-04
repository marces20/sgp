
package views.html.haberes.escalasLaboralesMontos

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
object editarEscalaLaboralMonto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.EscalaLaboralMonto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(escalaForm: Form[models.haberes.EscalaLaboralMonto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Monto Escala Laboral")/*5.66*/ {_display_(Seq[Any](format.raw/*5.68*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Monto Escala laboral</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.EscalasLaboralesMontosController.actualizar())/*20.97*/ {_display_(Seq[Any](format.raw/*20.99*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(escalaForm("id"), 'hidden -> "hidden"))),format.raw/*21.52*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.escalasLaboralesMontos.formEscalaLaboralMonto(escalaForm))),format.raw/*22.80*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(escalaForm:Form[models.haberes.EscalaLaboralMonto]): play.api.templates.HtmlFormat.Appendable = apply(escalaForm)
    
    def f:((Form[models.haberes.EscalaLaboralMonto]) => play.api.templates.HtmlFormat.Appendable) = (escalaForm) => apply(escalaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaboralesMontos/editarEscalaLaboralMonto.scala.html
                    HASH: 10965ca0c34d7a7a16592d56cdc125b181be4b67
                    MATRIX: 857->1|1012->73|1044->97|1118->54|1146->141|1183->144|1195->149|1262->208|1301->210|1524->398|1537->403|1584->428|1624->433|1638->439|1735->527|1775->529|1814->533|1884->581|1923->585|1936->590|2029->661|2063->664
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            