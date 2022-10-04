
package views.html.haberes.liquidacionConceptoTipos

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
object crearLiquidacionConceptoTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConceptoTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionConceptoTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Tipo de Concepto")/*4.58*/ {_display_(Seq[Any](format.raw/*4.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Tipo de Concepto</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LiquidacionConceptoTiposController.guardar())/*15.99*/ {_display_(Seq[Any](format.raw/*15.101*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.liquidacionConceptoTipos.formLiquidacionConceptoTipo(tipoForm))),format.raw/*16.85*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionConceptoTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionConceptoTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptoTipos/crearLiquidacionConceptoTipo.scala.html
                    HASH: 4edeef593e26a15768990556fb491ad9a55821e6
                    MATRIX: 868->1|1034->57|1061->75|1097->77|1109->82|1168->133|1207->135|1389->282|1402->287|1449->312|1495->323|1510->329|1606->416|1647->418|1686->422|1699->427|1797->503|1833->508
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            