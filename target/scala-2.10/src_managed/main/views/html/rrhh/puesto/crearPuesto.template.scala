
package views.html.rrhh.puesto

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
object crearPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Puesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(puestoForm: Form[Puesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.rrhh.mainRrhh("Crear Puesto")/*4.42*/ {_display_(Seq[Any](format.raw/*4.44*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Puesto</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*13.70*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
    """)))})),format.raw/*24.6*/("""
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.rrhh.routes.PuestosController.guardarPuesto())/*26.85*/ {_display_(Seq[Any](format.raw/*26.87*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.rrhh.puesto.formPuesto(puestoForm))),format.raw/*27.49*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*30.74*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(puestoForm:Form[Puesto]): play.api.templates.HtmlFormat.Appendable = apply(puestoForm)
    
    def f:((Form[Puesto]) => play.api.templates.HtmlFormat.Appendable) = (puestoForm) => apply(puestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/puesto/crearPuesto.scala.html
                    HASH: bfd7cda04f4f83dcfd1f23acfb370663afb6c331
                    MATRIX: 798->1|934->27|961->45|997->47|1009->52|1052->87|1091->89|1289->251|1309->262|1375->306|1617->513|1656->543|1696->545|1771->585|1785->590|1820->603|1866->618|1912->629|1927->635|2009->708|2049->710|2088->714|2101->719|2163->759|2296->856|2316->867|2382->911|2547->1045|2580->1047
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            