
package views.html.dashboard.deudasPorAntiguedad

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

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Deudas Por Antiguedad")/*7.61*/ {_display_(Seq[Any](format.raw/*7.63*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas por Antiguedad</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*17.66*/("""
<div class="row"  style="">
	<div class="col-sm-6" style="">
		 
		<div class="panel panel-default">
			<div class="panel-heading"><b>Descargas</b></div>
			<div class="panel-body">
				<div class="row margin-bottom-25">
					<div class="col-sm-6">
						<a href=""""),_display_(Seq[Any](/*26.17*/controllers/*26.28*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasInformeGeneral())),format.raw/*26.106*/(""""  class="btn btn-default">
						<i class="glyphicon glyphicon glyphicon-signal"></i> Informe General</a>
					</div>
					<div class="col-sm-6">
						<a href=""""),_display_(Seq[Any](/*30.17*/controllers/*30.28*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasInformeGeneralNuevo())),format.raw/*30.111*/(""""  class="btn btn-default">
						<i class="glyphicon glyphicon glyphicon-signal"></i> Informe General NUEVO RESUMEN</a>
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
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/index.scala.html
                    HASH: 80bf8b73b498fe3ad8f733ee4cd5959eb6689775
                    MATRIX: 809->1|976->85|1008->109|1082->28|1110->153|1147->156|1159->161|1221->215|1260->217|1427->349|1440->354|1521->413|1823->679|1843->690|1944->768|2143->931|2163->942|2269->1025
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|47->17|47->17|47->17|56->26|56->26|56->26|60->30|60->30|60->30
                    -- GENERATED --
                */
            