
package views.html.compras.clientes

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
object crearCliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/clientes.js"))),format.raw/*5.67*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear cliente", scripts)/*8.58*/ {_display_(Seq[Any](format.raw/*8.60*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Crear nuevo cliente</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/if(flash.containsKey("success"))/*17.34*/ {_display_(Seq[Any](format.raw/*17.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*19.50*/flash/*19.55*/.get("success"))),format.raw/*19.70*/("""
	</div>
""")))})),format.raw/*21.2*/("""
"""),_display_(Seq[Any](/*22.2*/if(flash.containsKey("error"))/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*24.52*/flash/*24.57*/.get("error"))),format.raw/*24.70*/("""
	</div>
""")))})),format.raw/*26.2*/("""

"""),_display_(Seq[Any](/*28.2*/helper/*28.8*/.form(action = controllers.compras.routes.ClientesController.guardar())/*28.79*/ {_display_(Seq[Any](format.raw/*28.81*/("""
	"""),_display_(Seq[Any](/*29.3*/views/*29.8*/.html.compras.clientes.form(clienteForm))),format.raw/*29.48*/("""
""")))})),format.raw/*30.2*/("""

""")))})),format.raw/*32.2*/("""
"""))}
    }
    
    def render(clienteForm:Form[Cliente]): play.api.templates.HtmlFormat.Appendable = apply(clienteForm)
    
    def f:((Form[Cliente]) => play.api.templates.HtmlFormat.Appendable) = (clienteForm) => apply(clienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/crearCliente.scala.html
                    HASH: 70333bf6a3b873b932625ffb2c1d216db63902d5
                    MATRIX: 805->1|927->122|941->129|1025->133|1077->150|1091->156|1157->201|1225->50|1257->74|1331->29|1360->118|1389->238|1428->243|1440->248|1499->299|1538->301|1712->440|1753->472|1793->474|1916->561|1930->566|1967->581|2010->593|2048->596|2087->626|2127->628|2251->716|2265->721|2300->734|2343->746|2383->751|2397->757|2477->828|2517->830|2556->834|2569->839|2631->879|2665->882|2701->887
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|33->3|33->3|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|52->22|52->22|52->22|54->24|54->24|54->24|56->26|58->28|58->28|58->28|58->28|59->29|59->29|59->29|60->30|62->32
                    -- GENERATED --
                */
            