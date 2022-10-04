
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
object editarCertificacionServicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CertificacionServicio],CertificacionServicio,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cForm: Form[CertificacionServicio],cs:CertificacionServicio):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.63*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Editar certificación de servicio")/*6.74*/ {_display_(Seq[Any](format.raw/*6.76*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar certificación de servicio</h1>
			</div>			 
		</div>
	</div> 
    
    """),_display_(Seq[Any](/*16.6*/views/*16.11*/.html.tags.successError())),format.raw/*16.36*/("""
  
	"""),_display_(Seq[Any](/*18.3*/helper/*18.9*/.form(action = controllers.patrimonio.routes.CertificacionesServiciosController.actualizar(cs.id), 'id -> "formEditarRemito")/*18.134*/ {_display_(Seq[Any](format.raw/*18.136*/("""
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.patrimonio.certificaciones.formCertificacionServicio(cForm,cs))),format.raw/*19.77*/(""" 
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.patrimonio.certificaciones.tabsCertificacion(true, cForm))),format.raw/*20.72*/("""	
	""")))})),format.raw/*21.3*/("""
	
""")))})))}
    }
    
    def render(cForm:Form[CertificacionServicio],cs:CertificacionServicio): play.api.templates.HtmlFormat.Appendable = apply(cForm,cs)
    
    def f:((Form[CertificacionServicio],CertificacionServicio) => play.api.templates.HtmlFormat.Appendable) = (cForm,cs) => apply(cForm,cs)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/editarCertificacionServicio.scala.html
                    HASH: bfacba02ee7d2c7a0f4b9276fb0f2fb2d4829802
                    MATRIX: 866->1|1047->100|1079->124|1153->62|1182->168|1222->174|1234->179|1309->246|1348->248|1557->422|1571->427|1618->452|1661->460|1675->466|1810->591|1851->593|1891->598|1904->603|1994->671|2035->677|2048->682|2133->745|2169->750
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|45->16|45->16|45->16|47->18|47->18|47->18|47->18|48->19|48->19|48->19|49->20|49->20|49->20|50->21
                    -- GENERATED --
                */
            