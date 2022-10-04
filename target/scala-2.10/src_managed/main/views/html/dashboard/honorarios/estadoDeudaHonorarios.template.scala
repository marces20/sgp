
package views.html.dashboard.honorarios

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
object estadoDeudaHonorarios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*2.2*/implicitFieldConstructor/*2.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*2.70*/(""" 
"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.dashboard.mainDashboard("Estado de deudas - Honorarios")/*3.69*/ {_display_(Seq[Any](format.raw/*3.71*/("""

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("javascripts/dashboard/estadoDeudaHonorarios.js"))),format.raw/*5.81*/("""" type="text/javascript"></script>
	
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Estado de deuda honorarios</h1>
			</div>
		</div>
	</div>
	
	<div class="row"  style="border-bottom: 1px solid #999999;padding-bottom: 5px;">
		<div class="col-sm-4" style="">
			<div id="chart_div_honorarios_ejercicio"></div>
		</div>
		<div class="col-sm-8" style="">
			<div id='table_div_honorarios_ejercicio'></div>
		</div>
	</div>
	<div class="row">
 		<div class="col-sm-4" style=" ">
 			<div id="chart_div_honorarios_periodo"></div>
 		</div>
 		<div class="col-sm-8" style="padding-top:40px;">
 			<div id="table_div_honorarios_periodo"></div>
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
                    DATE: Tue Oct 04 11:43:57 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorarios/estadoDeudaHonorarios.scala.html
                    HASH: f179d3877662387e327b34054c9d6a6eea32f022
                    MATRIX: 901->18|933->42|1007->86|1044->89|1056->94|1126->156|1165->158|1216->174|1230->180|1311->240
                    LINES: 29->2|29->2|30->2|31->3|31->3|31->3|31->3|33->5|33->5|33->5
                    -- GENERATED --
                */
            