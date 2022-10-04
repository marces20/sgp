
package views.html.dashboard.presupuesto

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

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Informes Presupuesto")/*7.60*/ {_display_(Seq[Any](format.raw/*7.62*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Informes Presupuesto</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.dashboard.presupuesto.navPresupuesto())),format.raw/*17.51*/("""
<div class="row"  style="">
	<div class="col-sm-3" style="">
		 
		
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/presupuesto/index.scala.html
                    HASH: b50ecd2889c67350512fdb118f1ca8806b4d9a85
                    MATRIX: 924->57|956->81|1030->125|1067->128|1079->133|1140->186|1179->188|1345->319|1358->324|1424->368
                    LINES: 33->5|33->5|34->5|36->7|36->7|36->7|36->7|46->17|46->17|46->17
                    -- GENERATED --
                */
            