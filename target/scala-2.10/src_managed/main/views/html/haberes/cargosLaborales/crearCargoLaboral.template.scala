
package views.html.haberes.cargosLaborales

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
object crearCargoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CargoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cargoForm: Form[models.haberes.CargoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Cargo Laboral")/*4.55*/ {_display_(Seq[Any](format.raw/*4.57*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Cargo</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.CargosLaboralesController.guardar())/*15.90*/ {_display_(Seq[Any](format.raw/*15.92*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.cargosLaborales.formCargoLaboral(cargoForm))),format.raw/*16.66*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(cargoForm:Form[models.haberes.CargoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(cargoForm)
    
    def f:((Form[models.haberes.CargoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (cargoForm) => apply(cargoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/cargosLaborales/crearCargoLaboral.scala.html
                    HASH: 8bd965c689ca50555533f1d5228b28186efa213d
                    MATRIX: 837->1|993->47|1020->65|1056->67|1068->72|1124->120|1163->122|1334->258|1347->263|1394->288|1440->299|1455->305|1542->383|1582->385|1621->389|1634->394|1713->451|1749->456
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            