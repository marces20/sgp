
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
object crearExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Expediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(expedienteForm: Form[Expediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.expediente.mainExpediente("Crear expediente")/*4.58*/ {_display_(Seq[Any](format.raw/*4.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo expediente</h1>
			</div>
		</div>
	</div>
    
    """),_display_(Seq[Any](/*14.6*/views/*14.11*/.html.tags.successError())),format.raw/*14.36*/("""
    
    """),_display_(Seq[Any](/*16.6*/helper/*16.12*/.form(action = controllers.expediente.routes.ExpedientesController.guardarExpediente())/*16.99*/ {_display_(Seq[Any](format.raw/*16.101*/("""
		"""),_display_(Seq[Any](/*17.4*/views/*17.9*/.html.expediente.expediente.formExpediente(expedienteForm))),format.raw/*17.67*/("""
	""")))})),format.raw/*18.3*/("""
""")))})),format.raw/*19.2*/("""	"""))}
    }
    
    def render(expedienteForm:Form[Expediente]): play.api.templates.HtmlFormat.Appendable = apply(expedienteForm)
    
    def f:((Form[Expediente]) => play.api.templates.HtmlFormat.Appendable) = (expedienteForm) => apply(expedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/crearExpediente.scala.html
                    HASH: adf87b36fb823c977714be55732a4c2bbbc31c0e
                    MATRIX: 816->1|960->35|987->53|1023->55|1035->60|1094->111|1133->113|1317->262|1331->267|1378->292|1424->303|1439->309|1535->396|1576->398|1615->402|1628->407|1708->465|1742->468|1775->470
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|42->14|42->14|42->14|44->16|44->16|44->16|44->16|45->17|45->17|45->17|46->18|47->19
                    -- GENERATED --
                */
            