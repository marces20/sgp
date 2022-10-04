
package views.html.dashboard.honorariosNew

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

implicit def /*2.2*/implicitFieldConstructor/*2.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*2.70*/(""" 
"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.dashboard.mainDashboard("Honorarios")/*3.50*/ {_display_(Seq[Any](format.raw/*3.52*/("""

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("javascripts/dashboard/indexHonorariosNew.js"))),format.raw/*5.78*/("""" type="text/javascript"></script>

<div class="row"  style="">
	<div class="col-sm-4" style="">
		<div id="chart_div_honorarios_ejercicio"></div>
	</div>
	
	
<div class="main-box">
	<header class="main-box-header clearfix">
		<h2 class="pull-left">Visitors location</h2>
		<div class="icon-box pull-right">
			<a href="#" class="btn pull-left">
			<i class="fa fa-refresh"></i>
			</a>
			<a href="#" class="btn pull-left">
			<i class="fa fa-cog"></i>
			</a>
		</div>
	</header>
	<div class="main-box-body clearfix">
		<div class="row">
			<div class="col-md-5">
				<div class="map-stats">
					<div class="table-responsive">
<table class="table table-condensed table-hover">
<thead>
<tr>
<th><span>Country</span></th>
<th class="text-center"><span>Last Visit</span></th>
<th class="text-center"><span>Status</span></th>
</tr>
</thead>
<tbody>
<tr>
<td>
USA
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status green">
<i class="fa fa-level-up"></i> 27%
</td>
</tr>
<tr>
<td>
Russia
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status red">
<i class="fa fa-level-down"></i> 43%
</td>
</tr>
<tr>
<td>
China
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status green">
<i class="fa fa-level-up"></i> 18%
</td>
</tr>
<tr>
<td>
India
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status green">
<i class="fa fa-level-up"></i> 63%
</td>
</tr>
<tr>
<td>
Australia
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status red">
<i class="fa fa-level-down"></i> 82%
</td>
</tr>
<tr>
<td>
Canada
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status red">
<i class="fa fa-level-down"></i> 11%
</td>
</tr>
<tr>
<td>
Argentina
</td>
<td class="text-center">
2013/08/08
</td>
<td class="text-center status green">
<i class="fa fa-level-up"></i> 74%
</td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
<div class="col-md-7">

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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorariosNew/index.scala.html
                    HASH: 48feafdd7b2bcb73a95ca9f21fcb2c244129dfcf
                    MATRIX: 888->18|920->42|994->86|1031->89|1043->94|1094->137|1133->139|1184->155|1198->161|1276->218
                    LINES: 29->2|29->2|30->2|31->3|31->3|31->3|31->3|33->5|33->5|33->5
                    -- GENERATED --
                */
            