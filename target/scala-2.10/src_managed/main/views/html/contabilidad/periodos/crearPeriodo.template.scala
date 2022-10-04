
package views.html.contabilidad.periodos

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
object crearPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Periodo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodoForm: Form[Periodo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear Periodo")/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Periodo</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*13.80*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.contabilidad.routes.PeriodosController.guardarPeriodo())/*26.95*/ {_display_(Seq[Any](format.raw/*26.97*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.contabilidad.periodos.formPeriodo(periodoForm))),format.raw/*27.61*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*30.84*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(periodoForm:Form[Periodo]): play.api.templates.HtmlFormat.Appendable = apply(periodoForm)
    
    def f:((Form[Periodo]) => play.api.templates.HtmlFormat.Appendable) = (periodoForm) => apply(periodoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/periodos/crearPeriodo.scala.html
                    HASH: 04efde9e72fceebf54974960798d88421c7697a9
                    MATRIX: 810->1|948->29|975->47|1011->49|1023->54|1083->106|1122->108|1321->271|1341->282|1417->336|1659->543|1698->573|1738->575|1813->615|1827->620|1862->633|1908->648|1954->659|1969->665|2061->748|2101->750|2140->754|2153->759|2227->811|2360->908|2380->919|2456->973|2621->1107|2654->1109
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            