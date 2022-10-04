
package views.html.rrhh.especialidad

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
object crearEspecialidad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Especialidad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(especialidadForm: Form[Especialidad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.rrhh.mainRrhh("Crear Especialidad")/*4.48*/ {_display_(Seq[Any](format.raw/*4.50*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Especialidad</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*13.83*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.rrhh.routes.EspecialidadesController.guardarEspecialidad())/*26.98*/ {_display_(Seq[Any](format.raw/*26.100*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.rrhh.especialidad.formEspecialidad(especialidadForm))),format.raw/*27.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*30.87*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(especialidadForm:Form[Especialidad]): play.api.templates.HtmlFormat.Appendable = apply(especialidadForm)
    
    def f:((Form[Especialidad]) => play.api.templates.HtmlFormat.Appendable) = (especialidadForm) => apply(especialidadForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/especialidad/crearEspecialidad.scala.html
                    HASH: 5a02f80d5e682da9fb5460a8f05ce1fa34273b56
                    MATRIX: 816->1|964->39|991->57|1027->59|1039->64|1088->105|1127->107|1331->275|1351->286|1430->343|1672->550|1711->580|1751->582|1826->622|1840->627|1875->640|1921->655|1967->666|1982->672|2077->758|2118->760|2157->764|2170->769|2250->827|2383->924|2403->935|2482->992|2647->1126|2680->1128
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            