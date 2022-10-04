
package views.html.haberes.conveniosBancos

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
object crearConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.ConvenioBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(convenioForm: Form[models.haberes.ConvenioBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Convenio Banco")/*4.56*/ {_display_(Seq[Any](format.raw/*4.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Convenio</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.ConveniosBancosController.guardar())/*15.90*/ {_display_(Seq[Any](format.raw/*15.92*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.conveniosBancos.formConvenioBanco(convenioForm))),format.raw/*16.70*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(convenioForm:Form[models.haberes.ConvenioBanco]): play.api.templates.HtmlFormat.Appendable = apply(convenioForm)
    
    def f:((Form[models.haberes.ConvenioBanco]) => play.api.templates.HtmlFormat.Appendable) = (convenioForm) => apply(convenioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/crearConvenioBanco.scala.html
                    HASH: d91d97390381d4a1d93502ffe1881fc236c3e534
                    MATRIX: 839->1|999->51|1026->69|1062->71|1074->76|1131->125|1170->127|1344->266|1357->271|1404->296|1450->307|1465->313|1552->391|1592->393|1631->397|1644->402|1727->463|1763->468
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            