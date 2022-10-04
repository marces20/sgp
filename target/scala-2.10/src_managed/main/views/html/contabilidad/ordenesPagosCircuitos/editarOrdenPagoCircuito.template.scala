
package views.html.contabilidad.ordenesPagosCircuitos

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
object editarOrdenPagoCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPagoCircuito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formOrden: Form[OrdenPagoCircuito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.38*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar orden de pago Circto")/*5.76*/ {_display_(Seq[Any](format.raw/*5.78*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar orden de pago circuito</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*17.5*/flash/*17.10*/.get("error"))),format.raw/*17.23*/("""
		</div>
	""")))})),format.raw/*19.3*/("""
	
	"""),_display_(Seq[Any](/*21.3*/helper/*21.9*/.form(action = controllers.contabilidad.routes.OrdenesPagosCircuitosController.actualizar())/*21.101*/ {_display_(Seq[Any](format.raw/*21.103*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(formOrden("id"), 'hidden -> "hidden"))),format.raw/*22.51*/("""
													   
		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.contabilidad.ordenesPagosCircuitos.formOrdenPagoCircuito(formOrden))),format.raw/*24.82*/("""
	""")))})),format.raw/*25.3*/("""

""")))})))}
    }
    
    def render(formOrden:Form[OrdenPagoCircuito]): play.api.templates.HtmlFormat.Appendable = apply(formOrden)
    
    def f:((Form[OrdenPagoCircuito]) => play.api.templates.HtmlFormat.Appendable) = (formOrden) => apply(formOrden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/editarOrdenPagoCircuito.scala.html
                    HASH: 83d82db8bb9cb8c6ff03032564f7fffe96fbb8d3
                    MATRIX: 844->1|982->56|1014->80|1088->37|1116->124|1153->127|1165->132|1242->201|1281->203|1466->353|1505->383|1545->385|1620->425|1634->430|1669->443|1712->455|1752->460|1766->466|1868->558|1909->560|1948->564|2017->611|2073->632|2086->637|2181->710|2215->713
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|52->24|53->25
                    -- GENERATED --
                */
            