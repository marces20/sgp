
package views.html.contabilidad.ordenesPagos

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
object editarOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formOrden: Form[OrdenPago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar orden de pago")/*5.69*/ {_display_(Seq[Any](format.raw/*5.71*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar orden de pago</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*17.5*/flash/*17.10*/.get("error"))),format.raw/*17.23*/("""
		</div>
	""")))})),format.raw/*19.3*/("""
	
	"""),_display_(Seq[Any](/*21.3*/helper/*21.9*/.form(action = controllers.contabilidad.routes.OrdenesPagosController.actualizar())/*21.92*/ {_display_(Seq[Any](format.raw/*21.94*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(formOrden("id"), 'hidden -> "hidden"))),format.raw/*22.51*/("""

		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.contabilidad.ordenesPagos.formOrdenPago(formOrden))),format.raw/*24.65*/("""
	""")))})),format.raw/*25.3*/("""
<script>
$(function()"""),format.raw/*27.13*/("""{"""),format.raw/*27.14*/("""
	$('.searchModal').modalSearch(); 
"""),format.raw/*29.1*/("""}"""),format.raw/*29.2*/(""");
</script>

""")))})))}
    }
    
    def render(formOrden:Form[OrdenPago]): play.api.templates.HtmlFormat.Appendable = apply(formOrden)
    
    def f:((Form[OrdenPago]) => play.api.templates.HtmlFormat.Appendable) = (formOrden) => apply(formOrden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagos/editarOrdenPago.scala.html
                    HASH: 5e6451e51b16c946d4720e6e487dbdf76487a2de
                    MATRIX: 819->1|949->48|981->72|1055->29|1083->116|1120->119|1132->124|1202->186|1241->188|1417->329|1456->359|1496->361|1571->401|1585->406|1620->419|1663->431|1703->436|1717->442|1809->525|1849->527|1888->531|1957->578|1997->583|2010->588|2088->644|2122->647|2172->669|2201->670|2264->706|2292->707
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|52->24|53->25|55->27|55->27|57->29|57->29
                    -- GENERATED --
                */
            