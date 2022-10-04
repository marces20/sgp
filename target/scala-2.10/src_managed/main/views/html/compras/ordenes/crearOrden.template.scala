
package views.html.compras.ordenes

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
object crearOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenForm: Form[Orden]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/ordenes.js"))),format.raw/*5.66*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear Orden", scripts)/*8.56*/ {_display_(Seq[Any](format.raw/*8.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear Orden de Compra</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/views/*17.8*/.html.tags.successError())),format.raw/*17.33*/("""
    
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.form(action = controllers.compras.routes.OrdenesController.guardar())/*19.82*/ {_display_(Seq[Any](format.raw/*19.84*/("""

		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.compras.ordenes.formOrden(ordenForm))),format.raw/*21.51*/(""" 
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.compras.ordenes.tabsOrden(true, ordenForm))),format.raw/*22.57*/("""	


	""")))})),format.raw/*25.3*/("""
""")))})))}
    }
    
    def render(ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(ordenForm)
    
    def f:((Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (ordenForm) => apply(ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/crearOrden.scala.html
                    HASH: 8e99f1d78fce1263f361c7322d9add66fee6c184
                    MATRIX: 800->1|917->45|931->52|1015->56|1066->72|1080->78|1145->122|1220->25|1247->43|1274->158|1311->161|1323->166|1380->215|1419->217|1593->356|1606->361|1653->386|1699->397|1714->403|1793->473|1833->475|1874->481|1887->486|1951->528|1991->533|2004->538|2074->586|2111->592
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|49->19|51->21|51->21|51->21|52->22|52->22|52->22|55->25
                    -- GENERATED --
                */
            