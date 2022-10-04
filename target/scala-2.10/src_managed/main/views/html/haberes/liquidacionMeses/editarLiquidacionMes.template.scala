
package views.html.haberes.liquidacionMeses

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
object editarLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionMes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lmForm: Form[models.haberes.LiquidacionMes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Liquidacion")/*5.57*/ {_display_(Seq[Any](format.raw/*5.59*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Liquidacion</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/views/*15.8*/.html.tags.successError())),format.raw/*15.33*/("""
	
	"""),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(action = controllers.haberes.routes.LiquidacionMesesController.actualizar())/*17.91*/ {_display_(Seq[Any](format.raw/*17.93*/("""
		"""),_display_(Seq[Any](/*18.4*/inputText(lmForm("id"), 'hidden -> "hidden"))),format.raw/*18.48*/("""
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.haberes.liquidacionMeses.formLiquidacionMes(lmForm))),format.raw/*19.66*/("""
	""")))})),format.raw/*20.3*/("""

""")))})))}
    }
    
    def render(lmForm:Form[models.haberes.LiquidacionMes]): play.api.templates.HtmlFormat.Appendable = apply(lmForm)
    
    def f:((Form[models.haberes.LiquidacionMes]) => play.api.templates.HtmlFormat.Appendable) = (lmForm) => apply(lmForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/editarLiquidacionMes.scala.html
                    HASH: 1001bf2ba887b01c7c3c3be00e802ef86b869c32
                    MATRIX: 843->1|990->65|1022->89|1096->46|1124->133|1161->136|1173->141|1231->191|1270->193|1444->332|1457->337|1504->362|1544->367|1558->373|1649->455|1689->457|1728->461|1794->505|1833->509|1846->514|1925->571|1959->574
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|45->17|46->18|46->18|47->19|47->19|47->19|48->20
                    -- GENERATED --
                */
            