
package views.html.dashboard.informesRecupero

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Informes Recupero")/*7.57*/ {_display_(Seq[Any](format.raw/*7.59*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Informes Recupero</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.informesRecupero.navinformes())),format.raw/*17.53*/("""
<div class="row"  style="">
	<div class="col-sm-3" style="">
		 
		<div class="panel panel-default">
			<div class="panel-heading"><b>Descargas</b></div>
			<div class="panel-body">
				<div class="row margin-bottom-25">
					<div class="col-sm-12">
						<a href=""""),_display_(Seq[Any](/*26.17*/controllers/*26.28*/.dashboard.routes.InformesRecuperoReportesController.deudasPorTipoDeCliente(-1))),format.raw/*26.107*/(""""  class="btn btn-default">
						<i class="glyphicon glyphicon glyphicon-signal"></i> Informe General</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informesRecupero/index.scala.html
                    HASH: e77bad32e0aa8e57fe46fdb6eeb17e7b9f56eaeb
                    MATRIX: 929->57|961->81|1035->125|1072->128|1084->133|1142->183|1181->185|1344->313|1357->318|1425->364|1728->631|1748->642|1850->721
                    LINES: 33->5|33->5|34->5|36->7|36->7|36->7|36->7|46->17|46->17|46->17|55->26|55->26|55->26
                    -- GENERATED --
                */
            