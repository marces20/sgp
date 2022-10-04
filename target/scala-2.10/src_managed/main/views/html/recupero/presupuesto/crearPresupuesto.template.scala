
package views.html.recupero.presupuesto

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
object crearPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.Presupuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(presupuestoForm: Form[models.recupero.Presupuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/recupero/presupuesto.js"))),format.raw/*5.71*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.recupero.mainRecupero("Crear Presupuesto", scripts)/*8.64*/ {_display_(Seq[Any](format.raw/*8.66*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo presupuesto</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.recupero.routes.PresupuestosController.guardar())/*23.88*/ {_display_(Seq[Any](format.raw/*23.90*/("""

		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.recupero.presupuesto.formPresupuesto(presupuestoForm))),format.raw/*25.68*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.recupero.presupuesto.tabsPresupuesto(true, presupuestoForm))),format.raw/*26.74*/("""	


	""")))})),format.raw/*29.3*/("""
""")))})))}
    }
    
    def render(presupuestoForm:Form[models.recupero.Presupuesto]): play.api.templates.HtmlFormat.Appendable = apply(presupuestoForm)
    
    def f:((Form[models.recupero.Presupuesto]) => play.api.templates.HtmlFormat.Appendable) = (presupuestoForm) => apply(presupuestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/crearPresupuesto.scala.html
                    HASH: 1f34fe108a53ceddcf5973df3d6a3eadd2da5188
                    MATRIX: 833->1|978->73|992->80|1076->84|1127->100|1141->106|1211->155|1286->53|1313->71|1340->191|1377->194|1389->199|1454->256|1493->258|1669->399|1708->429|1748->431|1823->471|1837->476|1872->489|1918->504|1964->515|1979->521|2064->597|2104->599|2145->605|2158->610|2239->669|2279->674|2292->679|2379->744|2416->750
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|49->19|49->19|49->19|51->21|53->23|53->23|53->23|53->23|55->25|55->25|55->25|56->26|56->26|56->26|59->29
                    -- GENERATED --
                */
            