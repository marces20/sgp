
package views.html.haberes.liquidacionBaseCalculos

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
object crearLiquidacionBaseCalculo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionBaseCalculo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionBaseCalculo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Base Calculo")/*4.54*/ {_display_(Seq[Any](format.raw/*4.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Base Calculo</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LiquidacionBaseCalculosController.guardar())/*15.98*/ {_display_(Seq[Any](format.raw/*15.100*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.liquidacionBaseCalculos.formLiquidacionBaseCalculo(baseForm))),format.raw/*16.83*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionBaseCalculo]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionBaseCalculo]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionBaseCalculos/crearLiquidacionBaseCalculo.scala.html
                    HASH: 1aec0d78ae78a93d8d7c22cd163d8baa172f8a5e
                    MATRIX: 865->1|1030->56|1057->74|1093->76|1105->81|1160->128|1199->130|1377->273|1390->278|1437->303|1483->314|1498->320|1593->406|1634->408|1673->412|1686->417|1782->491|1818->496
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            