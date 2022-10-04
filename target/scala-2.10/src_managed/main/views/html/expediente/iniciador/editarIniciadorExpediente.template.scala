
package views.html.expediente.iniciador

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
object editarIniciadorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[IniciadorExpediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(iniciadorExpedienteForm: Form[IniciadorExpediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.expediente.mainExpediente("Modificar Iniciador Expediente")/*5.72*/ {_display_(Seq[Any](format.raw/*5.74*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar iniciador de expediente</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*14.102*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.expediente.routes.IniciadorExpedientesController.actualizarIniciadorExpediente())/*26.117*/ {_display_(Seq[Any](format.raw/*26.119*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(iniciadorExpedienteForm("id"), 'hidden -> "hidden"))),format.raw/*27.65*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.expediente.iniciador.formIniciadorExpediente(iniciadorExpedienteForm))),format.raw/*28.84*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*31.106*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(iniciadorExpedienteForm:Form[IniciadorExpediente]): play.api.templates.HtmlFormat.Appendable = apply(iniciadorExpedienteForm)
    
    def f:((Form[IniciadorExpediente]) => play.api.templates.HtmlFormat.Appendable) = (iniciadorExpedienteForm) => apply(iniciadorExpedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/iniciador/editarIniciadorExpediente.scala.html
                    HASH: 7bd2b266f7fc6bf18588dfd1872e9c4794878d37
                    MATRIX: 834->1|988->72|1020->96|1094->53|1122->140|1159->143|1171->148|1244->213|1283->215|1493->389|1513->400|1612->476|1845->674|1884->704|1924->706|1999->746|2013->751|2048->764|2091->776|2131->781|2145->787|2263->895|2304->897|2343->901|2426->962|2465->966|2478->971|2575->1046|2708->1143|2728->1154|2827->1230|2991->1363
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            