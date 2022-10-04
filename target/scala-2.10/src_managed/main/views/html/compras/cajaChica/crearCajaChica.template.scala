
package views.html.compras.cajaChica

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
object crearCajaChica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChica],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cajaForm: Form[CajaChica]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/cajaChica.js"))),format.raw/*5.68*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear caja chica", scripts)/*8.61*/ {_display_(Seq[Any](format.raw/*8.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear caja chica</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.compras.routes.CajaChicaController.guardar())/*23.84*/ {_display_(Seq[Any](format.raw/*23.86*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.cajaChica.formCajaChica(cajaForm))),format.raw/*25.56*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.compras.cajaChica.tabsMovimientos(true, null))),format.raw/*26.60*/("""	


	""")))})),format.raw/*29.3*/("""
""")))})))}
    }
    
    def render(cajaForm:Form[CajaChica]): play.api.templates.HtmlFormat.Appendable = apply(cajaForm)
    
    def f:((Form[CajaChica]) => play.api.templates.HtmlFormat.Appendable) = (cajaForm) => apply(cajaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/crearCajaChica.scala.html
                    HASH: 9687605766c4e05d4a61581a8f7dade1cfe9d486
                    MATRIX: 810->1|931->51|945->58|1029->62|1081->79|1095->85|1162->131|1238->28|1266->48|1294->168|1333->173|1345->178|1407->232|1446->234|1624->377|1663->407|1703->409|1780->451|1794->456|1829->469|1877->486|1925->499|1940->505|2021->577|2061->579|2103->586|2116->591|2185->638|2226->644|2239->649|2312->700|2352->709
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|56->26|56->26|56->26|59->29
                    -- GENERATED --
                */
            