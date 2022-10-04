
package views.html.haberes.legajos

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
object crearLegajo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Legajo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(legajoForm: Form[models.haberes.Legajo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Legajo")/*4.48*/ {_display_(Seq[Any](format.raw/*4.50*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Legajo</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LegajosController.guardar())/*15.82*/ {_display_(Seq[Any](format.raw/*15.84*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.legajos.formLegajo(legajoForm))),format.raw/*16.53*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(legajoForm:Form[models.haberes.Legajo]): play.api.templates.HtmlFormat.Appendable = apply(legajoForm)
    
    def f:((Form[models.haberes.Legajo]) => play.api.templates.HtmlFormat.Appendable) = (legajoForm) => apply(legajoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/legajos/crearLegajo.scala.html
                    HASH: 71381fb5cab356fedb655de020f30a000d4dc43d
                    MATRIX: 817->1|968->42|995->60|1031->62|1043->67|1092->108|1131->110|1303->247|1316->252|1363->277|1409->288|1424->294|1503->364|1543->366|1582->370|1595->375|1661->419|1697->424
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            