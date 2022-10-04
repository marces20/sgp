
package views.html.informes.informeObligacion

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
object obligacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.informes.mainInformes("Obligaciones")/*7.50*/ {_display_(Seq[Any](format.raw/*7.52*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.informes.navInformes())),format.raw/*9.35*/("""


<!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
         
          <!-- /.col (LEFT) -->
          <div class="col-md-12">
           

            <!-- BAR CHART -->
            <div class="card card-success">
              <div class="card-header">
                <h3 class="card-title">Obligaciones</h3>

                 
              </div>
              <div class="card-body">
                <div class="chart">
                  <canvas id="barChart" style="height:230px; min-height:230px"></canvas>
                </div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

             

          </div>
          <!-- /.col (RIGHT) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
<!-- /.content -->
	<table class="table table-bordered">
       <thead>                  
         <tr>
           <th style="width: 10px">#</th>
           <th align="center">Enero</th>
           <th align="center">Febrero</th>
           <th align="center">Marzo</th>
           <th align="center">Abril</th>
           <th align="center">Mayo</th>
           <th align="center">Junio</th> 
         </tr>
       </thead>
       <tbody>
         <tr>
           <td>ESTUDIOS MEDICOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>MEDICAMENTOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>OTROS SERVICIOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>HONORARIOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>SERVICIOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>INSUMOS VARIOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>EQUIPAMIENTOS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>PROTESIS</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
         <tr>
           <td>REFACCIONES</td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
            
         </tr>
       </tbody>
     </table> 

<script>
/*
<option value="2">ESTUDIOS MEDICOS</option>
<option value="3">INSUMOS VARIOS</option>
<option value="4">MEDICAMENTOS</option>
<option value="6">PROTESIS</option>


<option value="5">OTROS SERVICIOS</option>

<option value="7">SERVICIOS</option>
<option value="8">HONORARIOS</option>

<option value="1">EQUIPAMIENTOS</option>
<option value="9">REFACCIONES</option>
*/

var url = '/informes/obligaciones/getObligaciones';
var row = [];
var data;
var estudios = [];
var medicamentos = [];
var otroservicios = [];
var honorarios = [];
var servicios = [];
var insumos = [];
var equipamientos = [];
var protesis = [];
var refacciones = [];

$.post(url, data, function(data)"""),format.raw/*182.33*/("""{"""),format.raw/*182.34*/("""
	var labels = [];
	
	if(data.success) """),format.raw/*185.19*/("""{"""),format.raw/*185.20*/("""
		$.each(data.results, function(idx,valor) """),format.raw/*186.44*/("""{"""),format.raw/*186.45*/("""
			
			console.log("------------------");
			console.log(Object.keys(valor).length);
			console.log("------------------");
			
			var count = Object.keys(valor).length;
			var estudios = [];
			
			
			$.each(valor, function(valor1,valor2) """),format.raw/*196.42*/("""{"""),format.raw/*196.43*/("""
				//console.log(valor1);
				//console.log(valor2);
				
				labels.push(valor1);
				estudios.push(0);
				medicamentos.push(0);
				otroservicios.push(0);
				honorarios.push(0);
				servicios.push(0);
				insumos.push(0);
				equipamientos.push(0);
				protesis.push(0);
				refacciones.push(0);
				
				
				$.each(valor2, function(valor21,valor22) """),format.raw/*212.46*/("""{"""),format.raw/*212.47*/("""
					console.log('ESTUDIOS MEDICOS');
					
					switch(valor21) """),format.raw/*215.22*/("""{"""),format.raw/*215.23*/("""
					  case 'ESTUDIOS MEDICOS':
					 		estudios.pop();
							estudios.push(valor22);
					  		break;
					  case 'MEDICAMENTOS':
						  	medicamentos.pop();
						  	medicamentos.push(valor22);
					    break;
					  case 'OTROS SERVICIOS':
						  	otroservicios.pop();
						  	otroservicios.push(valor22);
						    break;  
					  case 'HONORARIOS':
						  	honorarios.pop();
						  	honorarios.push(valor22);
						    break;
					  case 'SERVICIOS':
						  	servicios.pop();
						  	servicios.push(valor22);
						    break;
					  case 'INSUMOS VARIOS':
						  	insumos.pop();
						  	insumos.push(valor22);
						    break;
					  case 'EQUIPAMIENTOS':
						  	equipamientos.pop();
						  	equipamientos.push(valor22);
						    break;
					  case 'PROTESIS':
						  	protesis.pop();
						  	protesis.push(valor22);
						    break;
					  case 'REFACCIONES':
						  	refacciones.pop();
						  	refacciones.push(valor22);
						    break;
					"""),format.raw/*252.6*/("""}"""),format.raw/*252.7*/("""
					
					
				 
					
					
				"""),format.raw/*258.5*/("""}"""),format.raw/*258.6*/(""");
				
				
				
				
			"""),format.raw/*263.4*/("""}"""),format.raw/*263.5*/(""");
			console.log(estudios);
			
			setData(labels,estudios,medicamentos,otroservicios,honorarios,servicios,insumos,equipamientos,protesis,refacciones);
		"""),format.raw/*267.3*/("""}"""),format.raw/*267.4*/(""");
		
	"""),format.raw/*269.2*/("""}"""),format.raw/*269.3*/("""
	
	
	
"""),format.raw/*273.1*/("""}"""),format.raw/*273.2*/(""");

$(function () """),format.raw/*275.15*/("""{"""),format.raw/*275.16*/("""
  /* ChartJS
   * -------
   * Here we will create a few charts using ChartJS
   */
   

  
"""),format.raw/*283.1*/("""}"""),format.raw/*283.2*/(""")

function setData(labels,estudios,medicamentos,otroservicios,honorarios,servicios,insumos,equipamientos,protesis,refacciones)"""),format.raw/*285.125*/("""{"""),format.raw/*285.126*/("""
	var datasets= [];
	datasets.push("""),format.raw/*287.16*/("""{"""),format.raw/*287.17*/("""label : 'ESTUDIOS MEDICOS', backgroundColor     : 'rgba(255, 76, 82, 0.8)',data : estudios"""),format.raw/*287.107*/("""}"""),format.raw/*287.108*/(""");
	datasets.push("""),format.raw/*288.16*/("""{"""),format.raw/*288.17*/("""label : 'MEDICAMENTOS', backgroundColor     : 'rgba(245, 176, 65 , 0.8)',data : medicamentos"""),format.raw/*288.109*/("""}"""),format.raw/*288.110*/(""");
	datasets.push("""),format.raw/*289.16*/("""{"""),format.raw/*289.17*/("""label : 'OTROS SERVICIOS', backgroundColor     : 'rgba(255, 255, 51, 0.8)',data : otroservicios"""),format.raw/*289.112*/("""}"""),format.raw/*289.113*/(""");
	datasets.push("""),format.raw/*290.16*/("""{"""),format.raw/*290.17*/("""label : 'HONORARIOS', backgroundColor     : 'rgba(123, 199, 77,0.8)',data : honorarios"""),format.raw/*290.103*/("""}"""),format.raw/*290.104*/(""");
	datasets.push("""),format.raw/*291.16*/("""{"""),format.raw/*291.17*/("""label:  'SERVICIOS',backgroundColor     : 'rgba(60,141,188,0.9)',data : servicios"""),format.raw/*291.98*/("""}"""),format.raw/*291.99*/(""");
	datasets.push("""),format.raw/*292.16*/("""{"""),format.raw/*292.17*/("""label : 'INSUMOS VARIOS', backgroundColor     : 'rgba(95, 211, 239, 0.8)',data : insumos"""),format.raw/*292.105*/("""}"""),format.raw/*292.106*/(""");
	datasets.push("""),format.raw/*293.16*/("""{"""),format.raw/*293.17*/("""label : 'EQUIPAMIENTOS', backgroundColor     : 'rgba(148, 99, 247, 0.8)',data : equipamientos"""),format.raw/*293.110*/("""}"""),format.raw/*293.111*/(""");
	datasets.push("""),format.raw/*294.16*/("""{"""),format.raw/*294.17*/("""label : 'PROTESIS', backgroundColor     : 'rgba(44, 62, 80, 0.8)',data : protesis"""),format.raw/*294.98*/("""}"""),format.raw/*294.99*/(""");
	datasets.push("""),format.raw/*295.16*/("""{"""),format.raw/*295.17*/("""label : 'REFACCIONES', backgroundColor     : 'rgba(210, 214, 222, 0.8)',data : refacciones"""),format.raw/*295.107*/("""}"""),format.raw/*295.108*/(""");


	
	var areaChartData = """),format.raw/*299.22*/("""{"""),format.raw/*299.23*/("""
	  	      labels  : labels ,
	  	      datasets: datasets
	  	    """),format.raw/*302.9*/("""}"""),format.raw/*302.10*/("""
	 
	  var barChartCanvas = $('#barChart').get(0).getContext('2d')
	  var barChartData = jQuery.extend(true, """),format.raw/*305.43*/("""{"""),format.raw/*305.44*/("""}"""),format.raw/*305.45*/(""", areaChartData)
	  barChartData.datasets[0] = areaChartData.datasets[0]
	  barChartData.datasets[1] = areaChartData.datasets[1]

	  var barChartOptions = """),format.raw/*309.26*/("""{"""),format.raw/*309.27*/("""
	    responsive              : true,
	    maintainAspectRatio     : true,
	    datasetFill             : false,
	    tooltips: """),format.raw/*313.16*/("""{"""),format.raw/*313.17*/("""
				    callbacks: """),format.raw/*314.20*/("""{"""),format.raw/*314.21*/("""
				      label: function(tooltipItems, data) """),format.raw/*315.47*/("""{"""),format.raw/*315.48*/("""
				        return data.labels[tooltipItems.index] +   data.datasets[0].data[tooltipItems.index].toLocaleString();
				      """),format.raw/*317.11*/("""}"""),format.raw/*317.12*/("""
				    """),format.raw/*318.9*/("""}"""),format.raw/*318.10*/("""
				  """),format.raw/*319.7*/("""}"""),format.raw/*319.8*/(""",
		  scales: """),format.raw/*320.13*/("""{"""),format.raw/*320.14*/("""
		        yAxes: ["""),format.raw/*321.19*/("""{"""),format.raw/*321.20*/("""
		          ticks: """),format.raw/*322.20*/("""{"""),format.raw/*322.21*/("""
		            beginAtZero: true,
		            callback: function(value, index, values) """),format.raw/*324.56*/("""{"""),format.raw/*324.57*/("""
		              if(parseInt(value) >= 1000)"""),format.raw/*325.44*/("""{"""),format.raw/*325.45*/("""
		                return '$' + value.toString().replace(/\B(?=(\d"""),format.raw/*326.66*/("""{"""),format.raw/*326.67*/("""3"""),format.raw/*326.68*/("""}"""),format.raw/*326.69*/(""")+(?!\d))/g, ",");
		              """),format.raw/*327.17*/("""}"""),format.raw/*327.18*/(""" else """),format.raw/*327.24*/("""{"""),format.raw/*327.25*/("""
		                return '$' + value;
		              """),format.raw/*329.17*/("""}"""),format.raw/*329.18*/("""
		            """),format.raw/*330.15*/("""}"""),format.raw/*330.16*/("""
		          """),format.raw/*331.13*/("""}"""),format.raw/*331.14*/("""
		        """),format.raw/*332.11*/("""}"""),format.raw/*332.12*/("""]
		      """),format.raw/*333.9*/("""}"""),format.raw/*333.10*/("""
	  """),format.raw/*334.4*/("""}"""),format.raw/*334.5*/("""

	  var barChart = new Chart(barChartCanvas, """),format.raw/*336.45*/("""{"""),format.raw/*336.46*/("""
	    type: 'bar',
	    data: barChartData,
	    options: barChartOptions
	  """),format.raw/*340.4*/("""}"""),format.raw/*340.5*/(""")
"""),format.raw/*341.1*/("""}"""),format.raw/*341.2*/("""

/*function getCertificaciones()"""),format.raw/*343.32*/("""{"""),format.raw/*343.33*/("""
	var url = '/dashboard/estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente';
	var data = 'proveedorId='+$('#proveedor_id').val();
	
	$.post(url, data, function(data)"""),format.raw/*347.34*/("""{"""),format.raw/*347.35*/("""
		var tr = "";
		if(data.results && data.results.length > 0) """),format.raw/*349.47*/("""{"""),format.raw/*349.48*/("""
			 
			$.each(data.results, function(idx,ret) """),format.raw/*351.43*/("""{"""),format.raw/*351.44*/("""
				 
					ret.referencia ;
			"""),format.raw/*354.4*/("""}"""),format.raw/*354.5*/(""");
			
		"""),format.raw/*356.3*/("""}"""),format.raw/*356.4*/(""" else """),format.raw/*356.10*/("""{"""),format.raw/*356.11*/("""
			 
		"""),format.raw/*358.3*/("""}"""),format.raw/*358.4*/("""
		
	"""),format.raw/*360.2*/("""}"""),format.raw/*360.3*/(""");
"""),format.raw/*361.1*/("""}"""),format.raw/*361.2*/("""*/



</script>     
    
""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informeObligacion/obligacion.scala.html
                    HASH: d93160b0d06baefe21fe70b13ca2265d54febd30
                    MATRIX: 811->1|978->85|1010->109|1084->28|1112->153|1149->156|1161->161|1212->204|1251->206|1288->209|1300->214|1349->242|5203->4067|5233->4068|5301->4107|5331->4108|5404->4152|5434->4153|5704->4394|5734->4395|6120->4752|6150->4753|6245->4819|6275->4820|7271->5788|7300->5789|7363->5824|7392->5825|7446->5851|7475->5852|7658->6007|7687->6008|7722->6015|7751->6016|7786->6023|7815->6024|7862->6042|7892->6043|8013->6136|8042->6137|8199->6264|8230->6265|8294->6300|8324->6301|8444->6391|8475->6392|8522->6410|8552->6411|8674->6503|8705->6504|8752->6522|8782->6523|8907->6618|8938->6619|8985->6637|9015->6638|9131->6724|9162->6725|9209->6743|9239->6744|9349->6825|9379->6826|9426->6844|9456->6845|9574->6933|9605->6934|9652->6952|9682->6953|9805->7046|9836->7047|9883->7065|9913->7066|10023->7147|10053->7148|10100->7166|10130->7167|10250->7257|10281->7258|10338->7286|10368->7287|10463->7354|10493->7355|10631->7464|10661->7465|10691->7466|10875->7621|10905->7622|11062->7750|11092->7751|11141->7771|11171->7772|11247->7819|11277->7820|11432->7946|11462->7947|11499->7956|11529->7957|11564->7964|11593->7965|11636->7979|11666->7980|11714->7999|11744->8000|11793->8020|11823->8021|11941->8110|11971->8111|12044->8155|12074->8156|12169->8222|12199->8223|12229->8224|12259->8225|12323->8260|12353->8261|12388->8267|12418->8268|12502->8323|12532->8324|12576->8339|12606->8340|12648->8353|12678->8354|12718->8365|12748->8366|12786->8376|12816->8377|12848->8381|12877->8382|12952->8428|12982->8429|13087->8506|13116->8507|13146->8509|13175->8510|13237->8543|13267->8544|13471->8719|13501->8720|13592->8782|13622->8783|13699->8831|13729->8832|13789->8864|13818->8865|13855->8874|13884->8875|13919->8881|13949->8882|13985->8890|14014->8891|14047->8896|14076->8897|14107->8900|14136->8901
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|212->182|212->182|215->185|215->185|216->186|216->186|226->196|226->196|242->212|242->212|245->215|245->215|282->252|282->252|288->258|288->258|293->263|293->263|297->267|297->267|299->269|299->269|303->273|303->273|305->275|305->275|313->283|313->283|315->285|315->285|317->287|317->287|317->287|317->287|318->288|318->288|318->288|318->288|319->289|319->289|319->289|319->289|320->290|320->290|320->290|320->290|321->291|321->291|321->291|321->291|322->292|322->292|322->292|322->292|323->293|323->293|323->293|323->293|324->294|324->294|324->294|324->294|325->295|325->295|325->295|325->295|329->299|329->299|332->302|332->302|335->305|335->305|335->305|339->309|339->309|343->313|343->313|344->314|344->314|345->315|345->315|347->317|347->317|348->318|348->318|349->319|349->319|350->320|350->320|351->321|351->321|352->322|352->322|354->324|354->324|355->325|355->325|356->326|356->326|356->326|356->326|357->327|357->327|357->327|357->327|359->329|359->329|360->330|360->330|361->331|361->331|362->332|362->332|363->333|363->333|364->334|364->334|366->336|366->336|370->340|370->340|371->341|371->341|373->343|373->343|377->347|377->347|379->349|379->349|381->351|381->351|384->354|384->354|386->356|386->356|386->356|386->356|388->358|388->358|390->360|390->360|391->361|391->361
                    -- GENERATED --
                */
            