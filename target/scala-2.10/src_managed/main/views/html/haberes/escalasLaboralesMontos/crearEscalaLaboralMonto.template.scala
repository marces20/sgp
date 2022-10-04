
package views.html.haberes.escalasLaboralesMontos

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
object crearEscalaLaboralMonto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.EscalaLaboralMonto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(escalaForm: Form[models.haberes.EscalaLaboralMonto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Montos Escala Laboral")/*4.63*/ {_display_(Seq[Any](format.raw/*4.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva Monto Escala</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.EscalasLaboralesMontosController.guardar())/*15.97*/ {_display_(Seq[Any](format.raw/*15.99*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.escalasLaboralesMontos.formEscalaLaboralMonto(escalaForm))),format.raw/*16.80*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(escalaForm:Form[models.haberes.EscalaLaboralMonto]): play.api.templates.HtmlFormat.Appendable = apply(escalaForm)
    
    def f:((Form[models.haberes.EscalaLaboralMonto]) => play.api.templates.HtmlFormat.Appendable) = (escalaForm) => apply(escalaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaboralesMontos/crearEscalaLaboralMonto.scala.html
                    HASH: a6376989bb26d82faf5272a646fd1437aeced89b
                    MATRIX: 856->1|1019->54|1046->72|1082->74|1094->79|1158->135|1197->137|1375->280|1388->285|1435->310|1481->321|1496->327|1590->412|1630->414|1669->418|1682->423|1775->494|1811->499
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            