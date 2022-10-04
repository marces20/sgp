
package views.html.compras.pedidosFondos

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
object crearPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PedidoFondo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pedidoForm: Form[PedidoFondo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	
""")))};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear Pedido", scripts)/*8.57*/ {_display_(Seq[Any](format.raw/*8.59*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo Pedido</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.compras.routes.PedidosFondosController.guardar())/*23.88*/ {_display_(Seq[Any](format.raw/*23.90*/("""
		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.compras.pedidosFondos.formPedidoFondo(pedidoForm))),format.raw/*24.64*/(""" 
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.pedidosFondos.tabsPedidoFondo(true, pedidoForm))),format.raw/*25.70*/("""	
	""")))})),format.raw/*26.3*/("""
""")))})))}
    }
    
    def render(pedidoForm:Form[PedidoFondo]): play.api.templates.HtmlFormat.Appendable = apply(pedidoForm)
    
    def f:((Form[PedidoFondo]) => play.api.templates.HtmlFormat.Appendable) = (pedidoForm) => apply(pedidoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/crearPedidoFondo.scala.html
                    HASH: 8762634361cee4e2c54ffc7bf2e405d417128c55
                    MATRIX: 818->1|942->52|956->59|1040->63|1083->32|1110->50|1137->67|1174->70|1186->75|1244->125|1283->127|1454->263|1493->293|1533->295|1608->335|1622->340|1657->353|1703->368|1749->379|1764->385|1849->461|1889->463|1928->467|1941->472|2018->527|2058->532|2071->537|2154->598|2189->602
                    LINES: 26->1|29->4|29->4|31->4|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|54->24|54->24|54->24|55->25|55->25|55->25|56->26
                    -- GENERATED --
                */
            