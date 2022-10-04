
package views.html.informes.informePresupuesto

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
object creditos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,lugarId:Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.informes.mainInformes("Creditos Presupuestarios")/*7.62*/ {_display_(Seq[Any](format.raw/*7.64*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.informes.navInformes())),format.raw/*9.35*/("""
<script src=""""),_display_(Seq[Any](/*10.15*/routes/*10.21*/.Assets.at("javascripts/informes/creditos.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <script type="text/javascript">
   
      google.charts.load('current', """),format.raw/*15.37*/("""{"""),format.raw/*15.38*/("""'packages':['gauge']"""),format.raw/*15.58*/("""}"""),format.raw/*15.59*/(""");
      google.charts.setOnLoadCallback(drawChart);
      
      google.charts.load('current', """),format.raw/*18.37*/("""{"""),format.raw/*18.38*/("""packages: ['corechart', 'line']"""),format.raw/*18.69*/("""}"""),format.raw/*18.70*/(""");
      google.charts.setOnLoadCallback(drawLogScales);

function drawLogScales() """),format.raw/*21.26*/("""{"""),format.raw/*21.27*/("""
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'X');
      data.addColumn('number', ''); 

      data.addRows([
        ['PREVENTIVO', 692904777],['DEFINITIVO', 692041305],['OBLIGACION',683119855],['PAGO', 45439190]
      ]);
      
      var formatter = new google.visualization.NumberFormat("""),format.raw/*30.61*/("""{"""),format.raw/*30.62*/("""prefix: '$', negativeColor: 'red', negativeParens: true, pattern: '#,###'"""),format.raw/*30.135*/("""}"""),format.raw/*30.136*/(""");
    	  formatter.format(data, 1); 
      
	  var options = """),format.raw/*33.18*/("""{"""),format.raw/*33.19*/("""
    		 pointsVisible: true,	  
        hAxis: """),format.raw/*35.16*/("""{"""),format.raw/*35.17*/("""
          logScale: true
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/(""",
        vAxis: """),format.raw/*38.16*/("""{"""),format.raw/*38.17*/("""
          logScale: false,
          format: 'currency'
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/(""",
        colors: ['#a52714', '#097138']
      """),format.raw/*43.7*/("""}"""),format.raw/*43.8*/(""";

      var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));
      chart.draw(data, options);
"""),format.raw/*47.1*/("""}"""),format.raw/*47.2*/("""
      
function drawChart() """),format.raw/*49.22*/("""{"""),format.raw/*49.23*/("""

	   var data = google.visualization.arrayToDataTable([
	     ['Label', 'Percent'],
	     ['SALDO', 77.59]
	   ]);
	   var formatter = new google.visualization.NumberFormat("""),format.raw/*55.59*/("""{"""),format.raw/*55.60*/("""pattern: "#'%'""""),format.raw/*55.75*/("""}"""),format.raw/*55.76*/(""")
	   formatter.format(data, 1);
	   
	   
	   var options = """),format.raw/*59.19*/("""{"""),format.raw/*59.20*/("""
	   		vAxis: """),format.raw/*60.14*/("""{"""),format.raw/*60.15*/("""
	   		    format: '#%'
	   		"""),format.raw/*62.7*/("""}"""),format.raw/*62.8*/(""",	 
	     redFrom: 80, 
	     redTo: 100,
	     yellowFrom:70, 
	     yellowTo: 80,
	     minorTicks: 10
	   """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/(""";
	
	   var chart = new google.visualization.Gauge(document.getElementById('chart_div'));
	   chart.draw(data, options);
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/("""
</script>
<input type="hidden" id="lugarId" value=""""),_display_(Seq[Any](/*74.43*/if(lugarId != null)/*74.62*/ {_display_(Seq[Any](_display_(Seq[Any](/*74.65*/lugarId))))})),format.raw/*74.73*/("""" />
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Creditos Presupuestarios - Saldos</h1>
		</div>
	</div>
</div>
<div  id="contenedorGraficos">
	
</div>




""")))})))}
    }
    
    def render(formBuscador:DynamicForm,lugarId:Integer): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,lugarId)
    
    def f:((DynamicForm,Integer) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,lugarId) => apply(formBuscador,lugarId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informePresupuesto/creditos.scala.html
                    HASH: e5652cf7620b294a05c636f60eae7e7122205158
                    MATRIX: 818->1|1001->101|1033->125|1107->44|1135->169|1172->172|1184->177|1247->232|1286->234|1323->237|1335->242|1384->270|1435->285|1450->291|1518->337|1746->537|1775->538|1823->558|1852->559|1976->655|2005->656|2064->687|2093->688|2204->771|2233->772|2594->1105|2623->1106|2725->1179|2755->1180|2845->1242|2874->1243|2949->1290|2978->1291|3039->1325|3068->1326|3113->1343|3142->1344|3234->1409|3263->1410|3337->1457|3365->1458|3521->1587|3549->1588|3606->1617|3635->1618|3837->1792|3866->1793|3909->1808|3938->1809|4027->1870|4056->1871|4098->1885|4127->1886|4184->1916|4212->1917|4348->2026|4376->2027|4524->2148|4552->2149|4641->2202|4669->2221|4718->2224|4752->2232
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|40->10|40->10|40->10|45->15|45->15|45->15|45->15|48->18|48->18|48->18|48->18|51->21|51->21|60->30|60->30|60->30|60->30|63->33|63->33|65->35|65->35|67->37|67->37|68->38|68->38|71->41|71->41|73->43|73->43|77->47|77->47|79->49|79->49|85->55|85->55|85->55|85->55|89->59|89->59|90->60|90->60|92->62|92->62|98->68|98->68|102->72|102->72|104->74|104->74|104->74|104->74
                    -- GENERATED --
                */
            