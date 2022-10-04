
package views.html.haberes.puestosLaborales

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
object crearPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.PuestoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(puestoForm: Form[models.haberes.PuestoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Puesto Laboral")/*4.56*/ {_display_(Seq[Any](format.raw/*4.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Puesto Laboral</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.PuestosLaboralesController.guardar())/*15.91*/ {_display_(Seq[Any](format.raw/*15.93*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.puestosLaborales.formPuestoLaboral(puestoForm))),format.raw/*16.69*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(puestoForm:Form[models.haberes.PuestoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(puestoForm)
    
    def f:((Form[models.haberes.PuestoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (puestoForm) => apply(puestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/crearPuestoLaboral.scala.html
                    HASH: 21ab39938523bd06ccffed18e9221e3ad33b7b0e
                    MATRIX: 840->1|998->49|1025->67|1061->69|1073->74|1130->123|1169->125|1349->270|1362->275|1409->300|1455->311|1470->317|1558->396|1598->398|1637->402|1650->407|1732->467|1768->472
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            