
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
object navmovimientoscuentas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="row"  style="">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      	<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes Financieros <b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<li><a href=""""),_display_(Seq[Any](/*9.28*/controllers/*9.39*/.dashboard.routes.MovimientosCuentasController.resumenFinancieroGeneral())),format.raw/*9.112*/("""">Resumen Financiero General</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*10.28*/controllers/*10.39*/.dashboard.routes.MovimientosCuentasController.resumenFinancieroDetalle())),format.raw/*10.112*/("""">Resumen Financiero por Tipo Orden</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*11.28*/controllers/*11.39*/.dashboard.routes.MovimientosCuentasController.resumenFinancieroDetallePorInstitucion())),format.raw/*11.126*/("""">Resumen Financiero por Institucion</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Conciliacion<b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<li><a href=""""),_display_(Seq[Any](/*17.28*/controllers/*17.39*/.dashboard.routes.MovimientosCuentasController.conciliacion())),format.raw/*17.100*/("""">Conciliacion</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>  
		</div>
	</nav>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/movimientosCuentas/navmovimientoscuentas.scala.html
                    HASH: 51988337650ddc4e45cc73bc95aade391112de3b
                    MATRIX: 900->0|1377->442|1396->453|1491->526|1592->591|1612->602|1708->675|1816->747|1836->758|1946->845|2269->1132|2289->1143|2373->1204
                    LINES: 29->1|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|45->17|45->17|45->17
                    -- GENERATED --
                */
            