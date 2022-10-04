
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
object editarEspecialidad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Especialidad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(especialidadForm: Form[Especialidad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Modificar Especialidad")/*5.52*/ {_display_(Seq[Any](format.raw/*5.54*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Especialidad</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*14.83*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.rrhh.routes.EspecialidadesController.actualizarEspecialidad())/*26.98*/ {_display_(Seq[Any](format.raw/*26.100*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(especialidadForm("id"), 'hidden -> "hidden"))),format.raw/*27.58*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.rrhh.especialidad.formEspecialidad(especialidadForm))),format.raw/*28.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*31.87*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(especialidadForm:Form[Especialidad]): play.api.templates.HtmlFormat.Appendable = apply(especialidadForm)
    
    def f:((Form[Especialidad]) => play.api.templates.HtmlFormat.Appendable) = (especialidadForm) => apply(especialidadForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/especialidad/editarEspecialidad.scala.html
                    HASH: b3112f36fad71094c9c2a644b45fc14ceed6348e
                    MATRIX: 817->1|957->58|989->82|1063->39|1091->126|1128->129|1140->134|1193->179|1232->181|1431->344|1451->355|1530->412|1763->610|1802->640|1842->642|1917->682|1931->687|1966->700|2009->712|2049->717|2063->723|2161->812|2202->814|2241->818|2317->872|2356->876|2369->881|2449->939|2582->1036|2602->1047|2681->1104|2845->1237
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            