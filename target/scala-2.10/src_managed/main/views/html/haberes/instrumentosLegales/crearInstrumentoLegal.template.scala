
package views.html.haberes.instrumentosLegales

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
object crearInstrumentoLegal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.InstrumentoLegal],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ilForm: Form[models.haberes.InstrumentoLegal]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Instrumento Legal")/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Instrumento Legal</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.InstrumentosLegalesController.guardar())/*15.94*/ {_display_(Seq[Any](format.raw/*15.96*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.instrumentosLegales.formInstrumentoLegal(ilForm))),format.raw/*16.71*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(ilForm:Form[models.haberes.InstrumentoLegal]): play.api.templates.HtmlFormat.Appendable = apply(ilForm)
    
    def f:((Form[models.haberes.InstrumentoLegal]) => play.api.templates.HtmlFormat.Appendable) = (ilForm) => apply(ilForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/instrumentosLegales/crearInstrumentoLegal.scala.html
                    HASH: 3ef3874144d9f04f09100999c0c934668d618348
                    MATRIX: 849->1|1006->48|1033->66|1069->68|1081->73|1141->125|1180->127|1363->275|1376->280|1423->305|1469->316|1484->322|1575->404|1615->406|1654->410|1667->415|1751->477|1787->482
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            