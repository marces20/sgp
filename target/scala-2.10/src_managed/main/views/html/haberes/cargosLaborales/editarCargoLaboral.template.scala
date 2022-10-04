
package views.html.haberes.cargosLaborales

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
object editarCargoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CargoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cargoForm: Form[models.haberes.CargoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Cargo Laboral")/*5.59*/ {_display_(Seq[Any](format.raw/*5.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Cargo laboral</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.CargosLaboralesController.actualizar())/*20.90*/ {_display_(Seq[Any](format.raw/*20.92*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(cargoForm("id"), 'hidden -> "hidden"))),format.raw/*21.51*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.cargosLaborales.formCargoLaboral(cargoForm))),format.raw/*22.66*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(cargoForm:Form[models.haberes.CargoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(cargoForm)
    
    def f:((Form[models.haberes.CargoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (cargoForm) => apply(cargoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/cargosLaborales/editarCargoLaboral.scala.html
                    HASH: 6a64d441e5ea4fe9c11e46ddd4aa269e01c26e9f
                    MATRIX: 838->1|986->66|1018->90|1092->47|1120->134|1157->137|1169->142|1229->194|1268->196|1484->377|1497->382|1544->407|1584->412|1598->418|1688->499|1728->501|1767->505|1836->552|1875->556|1888->561|1967->618|2001->621
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            