
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
object crearDeposito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Deposito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(depositoForm: Form[Deposito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.delegacion.mainDelegaciones("Crear Deposito")/*4.58*/ {_display_(Seq[Any](format.raw/*4.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo depósito</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/if(flash.containsKey("error"))/*13.33*/ {_display_(Seq[Any](format.raw/*13.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*15.5*/flash/*15.10*/.get("error"))),format.raw/*15.23*/("""
		</div>
    """)))})),format.raw/*17.6*/("""
    
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.form(action = controllers.delegacion.routes.DepositosController.guardar())/*19.87*/ {_display_(Seq[Any](format.raw/*19.89*/("""
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.delegacion.depositos.formDeposito(depositoForm))),format.raw/*20.62*/(""" 	
	""")))})),format.raw/*21.3*/("""
""")))})))}
    }
    
    def render(depositoForm:Form[Deposito]): play.api.templates.HtmlFormat.Appendable = apply(depositoForm)
    
    def f:((Form[Deposito]) => play.api.templates.HtmlFormat.Appendable) = (depositoForm) => apply(depositoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/delegacion/depositos/crearDeposito.scala.html
                    HASH: f6f66ce442cc65b550bf664dd4cdb8b513a19745
                    MATRIX: 811->1|951->31|978->49|1014->51|1026->56|1085->107|1124->109|1298->248|1337->278|1377->280|1452->320|1466->325|1501->338|1547->353|1593->364|1608->370|1692->445|1732->447|1771->451|1784->456|1859->509|1895->514
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21
                    -- GENERATED --
                */
            