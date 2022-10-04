
package views.html.patrimonio.certificaciones

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
object crearCertificacionServicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CertificacionServicio],CertificacionServicio,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/( cForm: Form[CertificacionServicio],cs:CertificacionServicio):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Crear certificación")/*6.61*/ {_display_(Seq[Any](format.raw/*6.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear certificación</h1>
			</div>
			
			 
		</div>
	</div> 
    
    """),_display_(Seq[Any](/*18.6*/views/*18.11*/.html.tags.successError())),format.raw/*18.36*/("""
    
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.patrimonio.routes.CertificacionesServiciosController.guardar())/*20.99*/ {_display_(Seq[Any](format.raw/*20.101*/("""
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.patrimonio.certificaciones.formCertificacionServicio(cForm,cs))),format.raw/*21.77*/(""" 
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.patrimonio.certificaciones.tabsCertificacion(true, cForm))),format.raw/*22.72*/("""	
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(cForm:Form[CertificacionServicio],cs:CertificacionServicio): play.api.templates.HtmlFormat.Appendable = apply(cForm,cs)
    
    def f:((Form[CertificacionServicio],CertificacionServicio) => play.api.templates.HtmlFormat.Appendable) = (cForm,cs) => apply(cForm,cs)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/crearCertificacionServicio.scala.html
                    HASH: 0354a5cedc5013a83e653be617a08edff7c33199
                    MATRIX: 865->1|1047->101|1079->125|1153->63|1182->169|1226->179|1238->184|1300->238|1339->240|1542->408|1556->413|1603->438|1648->448|1662->454|1761->544|1802->546|1842->551|1855->556|1945->624|1986->630|1999->635|2084->698|2120->703
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|47->18|47->18|47->18|49->20|49->20|49->20|49->20|50->21|50->21|50->21|51->22|51->22|51->22|52->23
                    -- GENERATED --
                */
            