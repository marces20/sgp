
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
object crearUnidadLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.UnidadLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(unidadForm: Form[models.haberes.UnidadLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Unidad Laboral")/*4.56*/ {_display_(Seq[Any](format.raw/*4.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva Unidad</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.UnidadesLaboralesController.guardar())/*15.92*/ {_display_(Seq[Any](format.raw/*15.94*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.unidadesLaborales.formUnidadLaboral(unidadForm))),format.raw/*16.70*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(unidadForm:Form[models.haberes.UnidadLaboral]): play.api.templates.HtmlFormat.Appendable = apply(unidadForm)
    
    def f:((Form[models.haberes.UnidadLaboral]) => play.api.templates.HtmlFormat.Appendable) = (unidadForm) => apply(unidadForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/unidadesLaborales/crearUnidadLaboral.scala.html
                    HASH: 14f7f46a530ef630b656175f4cc1e19da153d1a3
                    MATRIX: 841->1|999->49|1026->67|1062->69|1074->74|1131->123|1170->125|1342->262|1355->267|1402->292|1448->303|1463->309|1552->389|1592->391|1631->395|1644->400|1727->461|1763->466
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            