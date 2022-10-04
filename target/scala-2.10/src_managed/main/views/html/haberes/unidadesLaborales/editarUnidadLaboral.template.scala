
package views.html.haberes.unidadesLaborales

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
object editarUnidadLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.UnidadLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(unidadForm: Form[models.haberes.UnidadLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Unidad Laboral")/*5.60*/ {_display_(Seq[Any](format.raw/*5.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar unidad laboral</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.UnidadesLaboralesController.actualizar())/*20.92*/ {_display_(Seq[Any](format.raw/*20.94*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(unidadForm("id"), 'hidden -> "hidden"))),format.raw/*21.52*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.unidadesLaborales.formUnidadLaboral(unidadForm))),format.raw/*22.70*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(unidadForm:Form[models.haberes.UnidadLaboral]): play.api.templates.HtmlFormat.Appendable = apply(unidadForm)
    
    def f:((Form[models.haberes.UnidadLaboral]) => play.api.templates.HtmlFormat.Appendable) = (unidadForm) => apply(unidadForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/unidadesLaborales/editarUnidadLaboral.scala.html
                    HASH: c5455dc79194b622724903d06ab6862e1c5d24c5
                    MATRIX: 842->1|992->68|1024->92|1098->49|1126->136|1163->139|1175->144|1236->197|1275->199|1492->381|1505->386|1552->411|1592->416|1606->422|1698->505|1738->507|1777->511|1847->559|1886->563|1899->568|1982->629|2016->632
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            