
package views.html.dashboard.movimientosCuentas

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

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Movimientos Cuentas")/*7.59*/ {_display_(Seq[Any](format.raw/*7.61*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Movimientos Cuentas</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.movimientosCuentas.navmovimientoscuentas())),format.raw/*17.65*/("""
<div class="row"  style="">
	<div class="col-sm-3" style="">
		 
		<div class="panel panel-default">
			<div class="panel-heading"><b>Descargas</b></div>
			<div class="panel-body">
				<div class="row margin-bottom-25">
					<div class="col-sm-12">
						<a href=""  class="btn btn-default">
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/index.scala.html
                    HASH: 3c4789ddc091449bd2c9ed5a033ec6f1275a2ec6
                    MATRIX: 931->57|963->81|1037->125|1074->128|1086->133|1146->185|1185->187|1350->317|1363->322|1443->380
                    LINES: 33->5|33->5|34->5|36->7|36->7|36->7|36->7|46->17|46->17|46->17
                    -- GENERATED --
                */
            