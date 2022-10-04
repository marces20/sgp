
package views.html.contabilidad.misPagos

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
object editarMiPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[MiPago],MiPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formMiPago: Form[MiPago],miPago:MiPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar mi pago")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar mi pago</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*17.5*/flash/*17.10*/.get("error"))),format.raw/*17.23*/("""
		</div>
	""")))})),format.raw/*19.3*/("""
	
	"""),_display_(Seq[Any](/*21.3*/helper/*21.9*/.form(action = controllers.contabilidad.routes.MisPagosController.actualizar(miPago.id))/*21.97*/ {_display_(Seq[Any](format.raw/*21.99*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(formMiPago("id"), 'hidden -> "hidden"))),format.raw/*22.52*/("""

		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.contabilidad.misPagos.formMiPago(formMiPago))),format.raw/*24.59*/("""
	""")))})),format.raw/*25.3*/("""

""")))})))}
    }
    
    def render(formMiPago:Form[MiPago],miPago:MiPago): play.api.templates.HtmlFormat.Appendable = apply(formMiPago,miPago)
    
    def f:((Form[MiPago],MiPago) => play.api.templates.HtmlFormat.Appendable) = (formMiPago,miPago) => apply(formMiPago,miPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/misPagos/editarMiPago.scala.html
                    HASH: d9387adaac2436945d0b095e32d66bcc3ee388fb
                    MATRIX: 816->1|958->60|990->84|1064->41|1092->128|1129->131|1141->136|1205->192|1244->194|1414->329|1453->359|1493->361|1568->401|1582->406|1617->419|1660->431|1700->436|1714->442|1811->530|1851->532|1890->536|1960->584|2000->589|2013->594|2085->644|2119->647
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|52->24|53->25
                    -- GENERATED --
                */
            