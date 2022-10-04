
package views.html.dashboard.rrhh

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
object profesionalesMedicos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Map[String, List[Integer]],Map[String, List[Double]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(numeros: Map[String, List[Integer]], porcentajes: Map[String, List[Double]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.dashboard.mainDashboard("Informes de profesionales médicos")/*5.73*/ {_display_(Seq[Any](format.raw/*5.75*/("""

	
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Rango etarios de profesionales médicos</h1>
			</div>
		</div>
	</div>
	
	<style>
	table """),format.raw/*17.8*/("""{"""),format.raw/*17.9*/("""width: 500px"""),format.raw/*17.21*/("""}"""),format.raw/*17.22*/("""
	table thead """),format.raw/*18.14*/("""{"""),format.raw/*18.15*/("""padding: 20px; font-size: 16px"""),format.raw/*18.45*/("""}"""),format.raw/*18.46*/("""
	table td """),format.raw/*19.11*/("""{"""),format.raw/*19.12*/("""text-align: right"""),format.raw/*19.29*/("""}"""),format.raw/*19.30*/("""
	</style>
	
	<table class="table-bordered">
		<thead>
			<tr>
				<th colspan="5">Rango etario de Profesionales Médicos Del Parque de la Salud</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th></th>
				<th>Menores de 35</th>
				<th>Entre 36 y 45</th>
				<th>Entre 46 y 55</th>
				<th>Mayores de 55</th>
			</tr>
			<tr>
				<th>Q</th>
				<td>"""),_display_(Seq[Any](/*38.10*/numeros/*38.17*/.get("parque").get(0))),format.raw/*38.38*/("""</td>
				<td>"""),_display_(Seq[Any](/*39.10*/numeros/*39.17*/.get("parque").get(1))),format.raw/*39.38*/("""</td>
				<td>"""),_display_(Seq[Any](/*40.10*/numeros/*40.17*/.get("parque").get(2))),format.raw/*40.38*/("""</td>
				<td>"""),_display_(Seq[Any](/*41.10*/numeros/*41.17*/.get("parque").get(3))),format.raw/*41.38*/("""</td>
			</tr>
			<tr>
				<th>%</th>
				<td>"""),_display_(Seq[Any](/*45.10*/porcentajes/*45.21*/.get("parque").get(0))),format.raw/*45.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*46.10*/porcentajes/*46.21*/.get("parque").get(1))),format.raw/*46.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*47.10*/porcentajes/*47.21*/.get("parque").get(2))),format.raw/*47.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*48.10*/porcentajes/*48.21*/.get("parque").get(3))),format.raw/*48.42*/("""</td>
			</tr>
		</tbody>
	</table>
	<br /><br />
	<table class="table-bordered">
		<thead>
			<tr>
				<th colspan="5">Rango etario de Profesionales Médicos Convenio Ministerio</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th></th>
				<th>Menores de 35</th>
				<th>Entre 36 y 45</th>
				<th>Entre 46 y 55</th>
				<th>Mayores de 55</th>
			</tr>
			<tr>
				<th>Q</th>
				<td>"""),_display_(Seq[Any](/*69.10*/numeros/*69.17*/.get("ministerio").get(0))),format.raw/*69.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*70.10*/numeros/*70.17*/.get("ministerio").get(1))),format.raw/*70.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*71.10*/numeros/*71.17*/.get("ministerio").get(2))),format.raw/*71.42*/("""</td>
				<td>"""),_display_(Seq[Any](/*72.10*/numeros/*72.17*/.get("ministerio").get(3))),format.raw/*72.42*/("""</td>
			</tr>
			<tr>
				<th>%</th>
				<td>"""),_display_(Seq[Any](/*76.10*/porcentajes/*76.21*/.get("ministerio").get(0))),format.raw/*76.46*/("""</td>
				<td>"""),_display_(Seq[Any](/*77.10*/porcentajes/*77.21*/.get("ministerio").get(1))),format.raw/*77.46*/("""</td>
				<td>"""),_display_(Seq[Any](/*78.10*/porcentajes/*78.21*/.get("ministerio").get(2))),format.raw/*78.46*/("""</td>
				<td>"""),_display_(Seq[Any](/*79.10*/porcentajes/*79.21*/.get("ministerio").get(3))),format.raw/*79.46*/("""</td>
			</tr>
		</tbody>
	</table>
	<br /><br />
	<table class="table-bordered">
		<thead>
			<tr>
				<th colspan="5">Rango etario de Profesionales Médicos Total General</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th></th>
				<th>Menores de 35</th>
				<th>Entre 36 y 45</th>
				<th>Entre 46 y 55</th>
				<th>Mayores de 55</th>
			</tr>
			<tr>
				<th>Q</th>
				<td>"""),_display_(Seq[Any](/*100.10*/numeros/*100.17*/.get("totales").get(0))),format.raw/*100.39*/("""</td>
				<td>"""),_display_(Seq[Any](/*101.10*/numeros/*101.17*/.get("totales").get(1))),format.raw/*101.39*/("""</td>
				<td>"""),_display_(Seq[Any](/*102.10*/numeros/*102.17*/.get("totales").get(2))),format.raw/*102.39*/("""</td>
				<td>"""),_display_(Seq[Any](/*103.10*/numeros/*103.17*/.get("totales").get(3))),format.raw/*103.39*/("""</td>
			</tr>
			<tr>
				<th>%</th>
				<td>"""),_display_(Seq[Any](/*107.10*/porcentajes/*107.21*/.get("totales").get(0))),format.raw/*107.43*/("""</td>
				<td>"""),_display_(Seq[Any](/*108.10*/porcentajes/*108.21*/.get("totales").get(1))),format.raw/*108.43*/("""</td>
				<td>"""),_display_(Seq[Any](/*109.10*/porcentajes/*109.21*/.get("totales").get(2))),format.raw/*109.43*/("""</td>
				<td>"""),_display_(Seq[Any](/*110.10*/porcentajes/*110.21*/.get("totales").get(3))),format.raw/*110.43*/("""</td>
			</tr>
		</tbody>
	</table>
""")))})))}
    }
    
    def render(numeros:Map[String, List[Integer]],porcentajes:Map[String, List[Double]]): play.api.templates.HtmlFormat.Appendable = apply(numeros,porcentajes)
    
    def f:((Map[String, List[Integer]],Map[String, List[Double]]) => play.api.templates.HtmlFormat.Appendable) = (numeros,porcentajes) => apply(numeros,porcentajes)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/rrhh/profesionalesMedicos.scala.html
                    HASH: 13ead1fc30f1502d2ba52d82103bbbd99777acac
                    MATRIX: 850->1|1038->78|1066->98|1105->103|1117->108|1191->174|1230->176|1443->362|1471->363|1511->375|1540->376|1583->391|1612->392|1670->422|1699->423|1739->435|1768->436|1813->453|1842->454|2247->823|2263->830|2306->851|2358->867|2374->874|2417->895|2469->911|2485->918|2528->939|2580->955|2596->962|2639->983|2726->1034|2746->1045|2789->1066|2841->1082|2861->1093|2904->1114|2956->1130|2976->1141|3019->1162|3071->1178|3091->1189|3134->1210|3575->1615|3591->1622|3638->1647|3690->1663|3706->1670|3753->1695|3805->1711|3821->1718|3868->1743|3920->1759|3936->1766|3983->1791|4070->1842|4090->1853|4137->1878|4189->1894|4209->1905|4256->1930|4308->1946|4328->1957|4375->1982|4427->1998|4447->2009|4494->2034|4930->2433|4947->2440|4992->2462|5045->2478|5062->2485|5107->2507|5160->2523|5177->2530|5222->2552|5275->2568|5292->2575|5337->2597|5425->2648|5446->2659|5491->2681|5544->2697|5565->2708|5610->2730|5663->2746|5684->2757|5729->2779|5782->2795|5803->2806|5848->2828
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|33->5|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|128->100|128->100|128->100|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|135->107|135->107|135->107|136->108|136->108|136->108|137->109|137->109|137->109|138->110|138->110|138->110
                    -- GENERATED --
                */
            