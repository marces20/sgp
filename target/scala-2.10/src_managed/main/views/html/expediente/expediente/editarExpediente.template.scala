
package views.html.expediente.expediente

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
object editarExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Expediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(expedienteForm: Form[Expediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.expediente.mainExpediente("Modificar expediente")/*5.62*/ {_display_(Seq[Any](format.raw/*5.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar expediente</h1>
			</div>
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*16.3*/views/*16.8*/.html.tags.successError())),format.raw/*16.33*/("""
	
	
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.expediente.routes.ExpedientesController.actualizarExpediente())/*20.99*/ {_display_(Seq[Any](format.raw/*20.101*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(expedienteForm("id"), 'hidden -> "hidden"))),format.raw/*21.56*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.expediente.expediente.formExpediente(expedienteForm))),format.raw/*22.67*/("""
		"""),_display_(Seq[Any](/*23.4*/views/*23.9*/.html.expediente.expediente.tabsExpediente(true, expedienteForm))),format.raw/*23.73*/("""	
	""")))})),format.raw/*24.3*/("""

""")))})))}
    }
    
    def render(expedienteForm:Form[Expediente]): play.api.templates.HtmlFormat.Appendable = apply(expedienteForm)
    
    def f:((Form[Expediente]) => play.api.templates.HtmlFormat.Appendable) = (expedienteForm) => apply(expedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/editarExpediente.scala.html
                    HASH: 426cda43c227bc1d0d6ffebd92c087685053f65f
                    MATRIX: 817->1|953->54|985->78|1059->35|1087->122|1124->125|1136->130|1199->185|1238->187|1415->329|1428->334|1475->359|1519->368|1533->374|1632->464|1673->466|1712->470|1786->522|1825->526|1838->531|1918->589|1957->593|1970->598|2056->662|2091->666
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|44->16|44->16|44->16|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24
                    -- GENERATED --
                */
            