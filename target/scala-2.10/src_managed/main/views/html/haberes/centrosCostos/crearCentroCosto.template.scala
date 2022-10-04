
package views.html.haberes.centrosCostos

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
object crearCentroCosto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CentroCosto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(centroForm: Form[models.haberes.CentroCosto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Centro Costo")/*4.54*/ {_display_(Seq[Any](format.raw/*4.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Centro</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.CentrosCostosController.guardar())/*15.88*/ {_display_(Seq[Any](format.raw/*15.90*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.centrosCostos.formCentroCosto(centroForm))),format.raw/*16.64*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(centroForm:Form[models.haberes.CentroCosto]): play.api.templates.HtmlFormat.Appendable = apply(centroForm)
    
    def f:((Form[models.haberes.CentroCosto]) => play.api.templates.HtmlFormat.Appendable) = (centroForm) => apply(centroForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/centrosCostos/crearCentroCosto.scala.html
                    HASH: 8e7b4163814203e73b0cd016e7c3561ceb949fac
                    MATRIX: 833->1|989->47|1016->65|1052->67|1064->72|1119->119|1158->121|1330->258|1343->263|1390->288|1436->299|1451->305|1536->381|1576->383|1615->387|1628->392|1705->447|1741->452
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            