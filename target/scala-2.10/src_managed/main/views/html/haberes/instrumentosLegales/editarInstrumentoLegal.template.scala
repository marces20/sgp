
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
object editarInstrumentoLegal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.InstrumentoLegal],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ilForm: Form[models.haberes.InstrumentoLegal]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Instrumento Legal")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Instrumento Legal</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
													 
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.InstrumentosLegalesController.actualizar())/*20.94*/ {_display_(Seq[Any](format.raw/*20.96*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(ilForm("id"), 'hidden -> "hidden"))),format.raw/*21.48*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.instrumentosLegales.formInstrumentoLegal(ilForm))),format.raw/*22.71*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(ilForm:Form[models.haberes.InstrumentoLegal]): play.api.templates.HtmlFormat.Appendable = apply(ilForm)
    
    def f:((Form[models.haberes.InstrumentoLegal]) => play.api.templates.HtmlFormat.Appendable) = (ilForm) => apply(ilForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/instrumentosLegales/editarInstrumentoLegal.scala.html
                    HASH: d700c776822d1ac84b9bfac9506be07f01357c21
                    MATRIX: 850->1|999->67|1031->91|1105->48|1133->135|1170->138|1182->143|1246->199|1285->201|1505->386|1518->391|1565->416|1618->434|1632->440|1726->525|1766->527|1805->531|1871->575|1910->579|1923->584|2007->646|2041->649
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            