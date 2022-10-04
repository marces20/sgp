
package views.html.delegacion.depositos

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
object editarDeposito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Deposito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(depositoForm: Form[Deposito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.delegacion.mainDelegaciones("Modificar Deposito")/*5.62*/ {_display_(Seq[Any](format.raw/*5.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar depósito</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*17.5*/flash/*17.10*/.get("error"))),format.raw/*17.23*/("""
		</div>
	""")))})),format.raw/*19.3*/("""
	
	"""),_display_(Seq[Any](/*21.3*/helper/*21.9*/.form(action = controllers.delegacion.routes.DepositosController.actualizar())/*21.87*/ {_display_(Seq[Any](format.raw/*21.89*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(depositoForm("id"), 'hidden -> "hidden"))),format.raw/*22.54*/("""
		"""),_display_(Seq[Any](/*23.4*/views/*23.9*/.html.delegacion.depositos.formDeposito(depositoForm))),format.raw/*23.62*/("""
	""")))})),format.raw/*24.3*/("""

""")))})))}
    }
    
    def render(depositoForm:Form[Deposito]): play.api.templates.HtmlFormat.Appendable = apply(depositoForm)
    
    def f:((Form[Deposito]) => play.api.templates.HtmlFormat.Appendable) = (depositoForm) => apply(depositoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/delegacion/depositos/editarDeposito.scala.html
                    HASH: a4d5bc9e3fa573e00634df634a292e1ab21dd525
                    MATRIX: 812->1|944->50|976->74|1050->31|1078->118|1115->121|1127->126|1190->181|1229->183|1400->319|1439->349|1479->351|1554->391|1568->396|1603->409|1646->421|1686->426|1700->432|1787->510|1827->512|1866->516|1938->566|1977->570|1990->575|2065->628|2099->631
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|49->21|49->21|49->21|49->21|50->22|50->22|51->23|51->23|51->23|52->24
                    -- GENERATED --
                */
            