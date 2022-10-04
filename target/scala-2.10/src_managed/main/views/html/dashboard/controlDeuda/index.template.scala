
package views.html.dashboard.controlDeuda

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

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*4.70*/("""

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.dashboard.mainDashboard("Control Deuda")/*6.53*/ {_display_(Seq[Any](format.raw/*6.55*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Control Deuda</h1>
		</div>
	</div>
</div>

<div class="row"  style="">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      	<!-- <li class="active"><a href=""""),_display_(Seq[Any](/*21.44*/controllers/*21.55*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas())),format.raw/*21.119*/("""">Deudas Resumen <span class="sr-only">(current)</span></a></li> -->
		        <li class="dropdown">
		         	
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Control Deuda<b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<!-- <li><a href=""""),_display_(Seq[Any](/*26.33*/controllers/*26.44*/.dashboard.routes.ControlDeudaController.autorizadoDistintoDePagado())),format.raw/*26.113*/("""">Listado Deuda Autorizado Distinto de Pagado</a></li>-->
		          	<li><a href=""""),_display_(Seq[Any](/*27.28*/controllers/*27.39*/.dashboard.routes.ControlDeudaController.controlDeudaMonedaExtranjera())),format.raw/*27.110*/("""">Control Deuda Moneda Extranjera</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*28.28*/controllers/*28.39*/.dashboard.routes.ControlDeudaController.autorizadoDistintoDePagado())),format.raw/*28.108*/("""">Diferencia entre pagado y autorizado</a></li>
		          </ul>
		        </li>
		        </ul>
		    </div>  
		</div>
	</nav>
</div>


""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/controlDeuda/index.scala.html
                    HASH: 6aff2eb22bb615c508ff6c3730c35ccd4564723a
                    MATRIX: 925->56|957->80|1031->124|1068->127|1080->132|1134->178|1173->180|1602->573|1622->584|1709->648|2040->943|2060->954|2152->1023|2273->1108|2293->1119|2387->1190|2493->1260|2513->1271|2605->1340
                    LINES: 33->4|33->4|34->4|36->6|36->6|36->6|36->6|51->21|51->21|51->21|56->26|56->26|56->26|57->27|57->27|57->27|58->28|58->28|58->28
                    -- GENERATED --
                */
            