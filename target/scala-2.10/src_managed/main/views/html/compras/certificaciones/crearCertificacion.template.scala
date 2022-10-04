
package views.html.compras.certificaciones

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
object crearCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Certificacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[Certificacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/certificaciones.js"))),format.raw/*5.74*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear Certificacion Personal", scripts)/*8.73*/ {_display_(Seq[Any](format.raw/*8.75*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva certificacion Personal</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.compras.routes.CertificacionesController.guardar())/*23.90*/ {_display_(Seq[Any](format.raw/*23.92*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.certificaciones.formCertificacion(certificacionForm))),format.raw/*25.75*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.compras.certificaciones.tabsCertificacion(true, certificacionForm))),format.raw/*26.81*/("""	


	""")))})),format.raw/*29.3*/("""
""")))})))}
    }
    
    def render(certificacionForm:Form[Certificacion]): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm)
    
    def f:((Form[Certificacion]) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm) => apply(certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/crearCertificacion.scala.html
                    HASH: 3180583a769f13ae1037e5ec7a68337a8a28d3cc
                    MATRIX: 824->1|957->61|971->68|1055->72|1106->88|1120->94|1193->146|1268->41|1295->59|1322->182|1359->185|1371->190|1445->256|1484->258|1671->410|1710->440|1750->442|1825->482|1839->487|1874->500|1920->515|1966->526|1981->532|2068->610|2108->612|2149->618|2162->623|2250->689|2290->694|2303->699|2397->771|2434->777
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|56->26|56->26|56->26|59->29
                    -- GENERATED --
                */
            