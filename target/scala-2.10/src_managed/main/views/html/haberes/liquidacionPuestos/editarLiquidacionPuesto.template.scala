
package views.html.haberes.liquidacionPuestos

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
object editarLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionPuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Liquidacion Puesto")/*5.64*/ {_display_(Seq[Any](format.raw/*5.66*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Liquidacion</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.LiquidacionPuestosController.actualizar())/*20.93*/ {_display_(Seq[Any](format.raw/*20.95*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(baseForm("id"), 'hidden -> "hidden"))),format.raw/*21.50*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.liquidacionPuestos.formLiquidacionPuesto(baseForm))),format.raw/*22.73*/("""
		"""),_display_(Seq[Any](/*23.4*/views/*23.9*/.html.haberes.liquidacionPuestos.tabsLiquidacionPuesto(true,baseForm))),format.raw/*23.78*/("""
	""")))})),format.raw/*24.3*/("""

""")))})))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/editarLiquidacionPuesto.scala.html
                    HASH: 9e36a4a6cb22d4f26fc9ce3ce08d31af8ca73451
                    MATRIX: 851->1|1003->70|1035->94|1109->51|1137->138|1174->141|1186->146|1251->203|1290->205|1504->384|1517->389|1564->414|1604->419|1618->425|1711->509|1751->511|1790->515|1858->561|1897->565|1910->570|1996->634|2035->638|2048->643|2139->712|2173->715
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24
                    -- GENERATED --
                */
            