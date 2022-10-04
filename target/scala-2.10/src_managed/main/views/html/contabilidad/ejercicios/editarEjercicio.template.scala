
package views.html.contabilidad.ejercicios

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
object editarEjercicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Ejercicio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ejercicioForm: Form[Ejercicio]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar Ejercicio")/*5.65*/ {_display_(Seq[Any](format.raw/*5.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Ejercicio</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*14.84*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.contabilidad.routes.EjerciciosController.actualizarEjercicio())/*26.99*/ {_display_(Seq[Any](format.raw/*26.101*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(ejercicioForm("id"), 'hidden -> "hidden"))),format.raw/*27.55*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.contabilidad.ejercicios.formEjercicio(ejercicioForm))),format.raw/*28.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*31.88*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(ejercicioForm:Form[Ejercicio]): play.api.templates.HtmlFormat.Appendable = apply(ejercicioForm)
    
    def f:((Form[Ejercicio]) => play.api.templates.HtmlFormat.Appendable) = (ejercicioForm) => apply(ejercicioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ejercicios/editarEjercicio.scala.html
                    HASH: 5827e86f2704da8a00fd54523595cbb57b65cc8d
                    MATRIX: 817->1|951->52|983->76|1057->33|1085->120|1122->123|1134->128|1200->186|1239->188|1435->348|1455->359|1535->417|1768->615|1807->645|1847->647|1922->687|1936->692|1971->705|2014->717|2054->722|2068->728|2167->818|2208->820|2247->824|2320->875|2359->879|2372->884|2452->942|2585->1039|2605->1050|2685->1108|2849->1241
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            