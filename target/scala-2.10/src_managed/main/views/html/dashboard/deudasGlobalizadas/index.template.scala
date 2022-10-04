
package views.html.dashboard.deudasGlobalizadas

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Deudas Globalizadas")/*7.59*/ {_display_(Seq[Any](format.raw/*7.61*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.deudasGlobalizadas.navdeudas(formBuscador))),format.raw/*17.65*/("""
"""),_display_(Seq[Any](/*18.2*/views/*18.7*/.html.tags.successError())),format.raw/*18.32*/("""
<div class="row"  style="">
	<div class="col-sm-6" style="">
		 
		<div class="panel panel-default">
			<div class="panel-heading"><b>Descargas</b></div>
			<div class="panel-body">
				<div class="row margin-bottom-25">
					<div class="col-sm-6">
						<a href=""""),_display_(Seq[Any](/*27.17*/controllers/*27.28*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasInformeGeneral())),format.raw/*27.105*/(""""  class="btn btn-default">
						<i class="glyphicon glyphicon glyphicon-signal"></i> Informe General</a>
					</div>
					<div class="col-sm-6">
						<a href=""""),_display_(Seq[Any](/*31.17*/controllers/*31.28*/.dashboard.routes.DeudasGlobalizadasReportesController.deudasInformeGeneralResumen())),format.raw/*31.112*/(""""  class="btn btn-default">
						<i class="glyphicon glyphicon glyphicon-signal"></i> Informe General RESUMEN</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	
""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/index.scala.html
                    HASH: cf7961971c18b96a8c235ba10915d45756eeea0b
                    MATRIX: 808->1|975->85|1007->109|1081->28|1109->153|1146->156|1158->161|1218->213|1257->215|1409->332|1422->337|1502->395|1539->397|1552->402|1599->427|1901->693|1921->704|2021->781|2220->944|2240->955|2347->1039
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|47->17|47->17|47->17|48->18|48->18|48->18|57->27|57->27|57->27|61->31|61->31|61->31
                    -- GENERATED --
                */
            