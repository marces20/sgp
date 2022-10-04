
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
object editarPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Periodo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodoForm: Form[Periodo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar Periodo")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Periodo</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*14.80*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.contabilidad.routes.PeriodosController.actualizarPeriodo())/*26.95*/ {_display_(Seq[Any](format.raw/*26.97*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(periodoForm("id"), 'hidden -> "hidden"))),format.raw/*27.53*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.contabilidad.periodos.formPeriodo(periodoForm))),format.raw/*28.61*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*31.84*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(periodoForm:Form[Periodo]): play.api.templates.HtmlFormat.Appendable = apply(periodoForm)
    
    def f:((Form[Periodo]) => play.api.templates.HtmlFormat.Appendable) = (periodoForm) => apply(periodoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/periodos/editarPeriodo.scala.html
                    HASH: 6a14f80c25ac66122cd7c7063d423954b9815866
                    MATRIX: 811->1|941->48|973->72|1047->29|1075->116|1112->119|1124->124|1188->180|1227->182|1421->340|1441->351|1517->405|1750->603|1789->633|1829->635|1904->675|1918->680|1953->693|1996->705|2036->710|2050->716|2145->802|2185->804|2224->808|2295->857|2334->861|2347->866|2421->918|2554->1015|2574->1026|2650->1080|2814->1213
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            