
package views.html.informes.informeHonorario

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
object honorarioRrhhPorPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[DynamicForm,Long,Integer,Integer,Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,
pId:Long,
total:Integer,
totalconv:Integer,
totalparque:Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*9.2*/implicitFieldConstructor/*9.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*5.21*/("""
"""),format.raw/*9.70*/("""

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.informes.mainInformes("Honorarios - RRHH por Periodo")/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.informes.navInformes())),format.raw/*13.35*/("""

"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.tags.successError())),format.raw/*15.32*/("""

 
<div class="row">
	<div class="col-sm-4">
		<h1>Honorarios  - RRHH por Periodo</h1>
		 
	
	</div>
	<div class="col-sm-4">
		
	</div>

	<div class="col-sm-4">
		
		 
	
	</div>
</div>
 
<form action="" method="GET" id="filtroInforme">
    	 
	<div class="row seccion">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*39.28*/if(formBuscador.error("periodo_id") != null)/*39.72*/ {_display_(Seq[Any](format.raw/*39.74*/("""has-error""")))})),format.raw/*39.84*/("""">
				<label for="periodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*42.7*/inputText(formBuscador("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*42.92*/("""
					"""),_display_(Seq[Any](/*43.7*/inputText(formBuscador("periodo.id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*43.85*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*48.21*/controllers/*48.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*48.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary" id="btn-buscar">Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*70.15*/controllers/*70.26*/.informes.routes.InformesHonorariosController.honorarioRrhhPorPeriodo())),format.raw/*70.97*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
		
	</div>
</form>
<hr>
"""),_display_(Seq[Any](/*77.2*/if(pId != null)/*77.17*/{_display_(Seq[Any](format.raw/*77.18*/("""
<div class="row seccion">
   	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total RRHH</h3>
	          <p>"""),_display_(Seq[Any](/*83.16*/total)),format.raw/*83.21*/("""</p>
	  	  </div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total RRHH PARQUE</h3>
	          <p>"""),_display_(Seq[Any](/*91.16*/totalparque)),format.raw/*91.27*/("""</p>
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total RRHH CONV.</h3>
	          <p>"""),_display_(Seq[Any](/*99.16*/totalconv)),format.raw/*99.25*/("""</p>
	  	  </div>
		 </div>
	 </div> 
</div>
<hr>
 <h3 class="card-title">Escala</h3>
	<div class="row">
		<div class="col-sm-5">
   	 		<!-- PIE CHART -->
            <div class="card card-danger">
              <div class="card-header">
                <h3 class="card-title">Parque</h3>

                <div class="card-tools">
                   
                </div>
              </div>
              <div class="card-body">
                <canvas id="pieChart0" style="height:230px; min-height:230px"></canvas>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
		   
           
		<div class="card card-info">
             
            <div class="card-body p-0">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th></th>
                    <th style="text-align: center;">Totales Agentes</th>
                    <th style="text-align: center;">(%)</th> 
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>Escala I (Otros)</td>
                    <td id="escala1parque" align="center"></td>
                    <td id="porcentajeParque1" align="center"></td>
                  </tr> 
                  <tr>
                    <td>Escala II (Auxiliares)</td>
                    <td id="escala2parque" align="center"></td>
                    <td id="porcentajeParque2" align="center"></td>
                  </tr>
                  <tr>
                    <td>Escala III (Tecnicos)</td>
                    <td id="escala3parque" align="center"></td>
                    <td id="porcentajeParque3" align="center"></td>
                  </tr>   
                  <tr>
                    <td>Escala IV (Profesionales)</td>
                    <td id="escala4parque" align="center"></td>
                    <td id="porcentajeParque4" align="center"></td>
                  </tr>   
                  <tr>
                    <td>Escala V (Medicos)</td>
                    <td id="escala5parque" align="center"></td>
                    <td id="porcentajeParque5" align="center"></td>
                  </tr>   
                  <tr>
                    <td style="font-weight:bold;font-size: 15px;">Total</td>
                    <td id="totalParque" style="font-weight:bold;font-size: 15px;" align="center"></td>
                    <td style="font-weight:bold;font-size: 15px;" align="center">100%</td>
                  </tr> 
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
	</div>
	<div class="col-sm-2">
	</div>
	<div class="col-sm-5">
		<!-- PIE CHART -->
        <div class="card card-danger">
          <div class="card-header">
            <h3 class="card-title">Convenio</h3>

            <div class="card-tools">
               
            </div>
          </div>
          <div class="card-body">
            <canvas id="pieChart00" style="height:230px; min-height:230px"></canvas>
          </div>
          <!-- /.card-body -->
        </div>
        <!-- /.card -->
		<div class="card card-info">
             
            <div class="card-body p-0">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th></th>
                    <th style="text-align: center;">Totales Agentes</th>
                    <th style="text-align: center;">%</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Escala I (Otros)</td>
                    <td id="escala1convenio" align="center"></td>
                    <td id="porcentajeConvenio1" align="center"></td>
                  </tr> 
                  <tr>
                    <td>Escala II (Auxiliares)</td>
                    <td id="escala2convenio" align="center"></td>
                    <td id="porcentajeConvenio2" align="center"></td>
                  </tr>
                  <tr>
                    <td>Escala III (Tecnicos)</td>
                    <td id="escala3convenio" align="center"></td>
                    <td id="porcentajeConvenio3" align="center"></td>
                  </tr>   
                  <tr>
                    <td>Escala IV (Profesionales)</td>
                    <td id="escala4convenio" align="center"></td>
                    <td id="porcentajeConvenio4" align="center"></td>
                  </tr>   
                  <tr>
                    <td>Escala V (Medicos)</td>
                    <td id="escala5convenio" align="center"></td>
                    <td id="porcentajeConvenio5" align="center"></td>
                  </tr>
                  <tr>
                    <td style="font-weight:bold;font-size: 15px;">Total</td>
                    <td id="totalConvenio" style="font-weight:bold;font-size: 15px;" align="center"></td>
                    <td style="font-weight:bold;font-size: 15px;" align="center">100%</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
	</div> 
</div>
<hr>
""")))})),format.raw/*241.2*/("""
""")))})),format.raw/*242.2*/("""

<script>

$( function() """),format.raw/*246.15*/("""{"""),format.raw/*246.16*/("""
	$('#searchProveedor,#searchPeriodo').modalSearch();
"""),format.raw/*248.1*/("""}"""),format.raw/*248.2*/(""");

var pieOptions = """),format.raw/*250.18*/("""{"""),format.raw/*250.19*/("""
					maintainAspectRatio : false,
					responsive : true,
				"""),format.raw/*253.5*/("""}"""),format.raw/*253.6*/("""


var idPeriodo = $('#periodo_id').val();
if(idPeriodo != '')"""),format.raw/*257.20*/("""{"""),format.raw/*257.21*/("""
	
	var url = '/informes/honorarios/getCountRrrhPorEscala';	
	var data = 'idPeriodo='+idPeriodo+'&convenio=false';
	$.post(url, data, function(data)"""),format.raw/*261.34*/("""{"""),format.raw/*261.35*/("""
		var labels = [];
		var dataEscalaParque = [0,0,0,0,0];
		var totalParque = 0;
		
		var porcentajeParque1 = 0;
		var porcentajeParque2 = 0;
		var porcentajeParque3 = 0;
		var porcentajeParque4 = 0;
		var porcentajeParque5 = 0;
		
		if(data.success) """),format.raw/*272.20*/("""{"""),format.raw/*272.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*273.45*/("""{"""),format.raw/*273.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*274.43*/("""{"""),format.raw/*274.44*/("""
					 
					switch(valor1) """),format.raw/*276.21*/("""{"""),format.raw/*276.22*/("""
						case '1':
				 			dataEscalaParque[0]= valor2;
				 			porcentajeParque1 = valor2;
				 			$('#escala1parque').html(valor2); 
				  		break;
						case '2':
				 			dataEscalaParque[1]= valor2;
				 			porcentajeParque2 = valor2;
				 			$('#escala2parque').html(valor2); 
				  		break;
						case '3':
				 			dataEscalaParque[2]= valor2;
				 			porcentajeParque3 = valor2;
				 			$('#escala3parque').html(valor2); 
				  		break;
						case '4':
				 			dataEscalaParque[3]= valor2;
				 			porcentajeParque4 = valor2;
				 			$('#escala4parque').html(valor2); 
				  		break;
						case '5':
				 			dataEscalaParque[4]= valor2;
				 			porcentajeParque5 = valor2;
				 			$('#escala5parque').html(valor2); 
				  		break;
					"""),format.raw/*302.6*/("""}"""),format.raw/*302.7*/("""
					totalParque = parseInt(totalParque) + parseInt(valor2);
				"""),format.raw/*304.5*/("""}"""),format.raw/*304.6*/("""); 
				$('#totalParque').html(parseInt(totalParque));
				
				 	  
				
				$('#porcentajeParque1').html(parseFloat((porcentajeParque1*100)/totalParque).toFixed(2)+"%");
				$('#porcentajeParque2').html(parseFloat((porcentajeParque2*100)/totalParque).toFixed(2)+"%");
				$('#porcentajeParque3').html(parseFloat((porcentajeParque3*100)/totalParque).toFixed(2)+"%");
				$('#porcentajeParque4').html(parseFloat((porcentajeParque4*100)/totalParque).toFixed(2)+"%");
				$('#porcentajeParque5').html(parseFloat((porcentajeParque5*100)/totalParque).toFixed(2)+"%");
				
				
				
				
			"""),format.raw/*318.4*/("""}"""),format.raw/*318.5*/(""");
			 
			setDataEscalaParque(dataEscalaParque);
		"""),format.raw/*321.3*/("""}"""),format.raw/*321.4*/("""
	"""),format.raw/*322.2*/("""}"""),format.raw/*322.3*/(""");
	
	var url = '/informes/honorarios/getCountRrrhPorEscala';
	var data = 'idPeriodo='+idPeriodo+'&convenio=true';
	$.post(url, data, function(data)"""),format.raw/*326.34*/("""{"""),format.raw/*326.35*/("""
		var labels = [];
		var dataEscalaConvenio = [0,0,0,0,0];
		var totalConvenio = 0;
		var porcentajeConvenio1 = 0;
		var porcentajeConvenio2 = 0;
		var porcentajeConvenio3 = 0;
		var porcentajeConvenio4 = 0;
		var porcentajeConvenio5 = 0;
		
		if(data.success) """),format.raw/*336.20*/("""{"""),format.raw/*336.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*337.45*/("""{"""),format.raw/*337.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*338.43*/("""{"""),format.raw/*338.44*/("""
					 
					switch(valor1) """),format.raw/*340.21*/("""{"""),format.raw/*340.22*/("""
						case '1':
							dataEscalaConvenio[0]= valor2;
							$('#escala1convenio').html(valor2); 
							porcentajeConvenio1 = valor2;
				  		break;
						case '2':
							dataEscalaConvenio[1]= valor2;
							$('#escala2convenio').html(valor2); 
							porcentajeConvenio2 = valor2;
				  		break;
						case '3':
							dataEscalaConvenio[2]= valor2;
							$('#escala3convenio').html(valor2); 
							porcentajeConvenio3 = valor2;
				  		break;
						case '4':
							dataEscalaConvenio[3]= valor2;
							$('#escala4convenio').html(valor2);
							porcentajeConvenio4 = valor2;
				  		break;
						case '5':
							dataEscalaConvenio[4]= valor2;
							$('#escala5convenio').html(valor2);
							porcentajeConvenio5 = valor2;
				  		break;
					"""),format.raw/*366.6*/("""}"""),format.raw/*366.7*/("""
					totalConvenio = parseInt(totalConvenio) + parseInt(valor2);
				"""),format.raw/*368.5*/("""}"""),format.raw/*368.6*/("""); 
				$('#totalConvenio').html(parseInt(totalConvenio));
				
				$('#porcentajeConvenio1').html(parseFloat((porcentajeConvenio1*100)/totalConvenio).toFixed(2)+"%");
				$('#porcentajeConvenio2').html(parseFloat((porcentajeConvenio2*100)/totalConvenio).toFixed(2)+"%");
				$('#porcentajeConvenio3').html(parseFloat((porcentajeConvenio3*100)/totalConvenio).toFixed(2)+"%");
				$('#porcentajeConvenio4').html(parseFloat((porcentajeConvenio4*100)/totalConvenio).toFixed(2)+"%");
				$('#porcentajeConvenio5').html(parseFloat((porcentajeConvenio5*100)/totalConvenio).toFixed(2)+"%");
			"""),format.raw/*376.4*/("""}"""),format.raw/*376.5*/(""");
			 
			setDataEscalaConvenio(dataEscalaConvenio);
		"""),format.raw/*379.3*/("""}"""),format.raw/*379.4*/("""
	"""),format.raw/*380.2*/("""}"""),format.raw/*380.3*/(""");
	
	
	function setDataEscalaParque(data)"""),format.raw/*383.36*/("""{"""),format.raw/*383.37*/("""
		var donutData0        = """),format.raw/*384.27*/("""{"""),format.raw/*384.28*/("""
			      labels: [
			          'Escala I', 
			          'Escala II',
			          'Escala III',
			          'Escala IV',
			          'Escala V'
			      ],
			      datasets: [
			        """),format.raw/*393.12*/("""{"""),format.raw/*393.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc'],
			        """),format.raw/*396.12*/("""}"""),format.raw/*396.13*/("""
			      ]
			    """),format.raw/*398.8*/("""}"""),format.raw/*398.9*/("""
			    
		var pieChartCanvas0 = $('#pieChart0').get(0).getContext('2d')
		var pieData0       = donutData0;
		
		 
		var pieChart0 = new Chart(pieChartCanvas0, """),format.raw/*404.46*/("""{"""),format.raw/*404.47*/("""
			type: 'pie',
			data: pieData0,
			options: pieOptions      
		"""),format.raw/*408.3*/("""}"""),format.raw/*408.4*/(""")
	"""),format.raw/*409.2*/("""}"""),format.raw/*409.3*/("""
	
	function setDataEscalaConvenio(data)"""),format.raw/*411.38*/("""{"""),format.raw/*411.39*/("""
		var donutData00        = """),format.raw/*412.28*/("""{"""),format.raw/*412.29*/("""
			      labels: [
			          'Escala I', 
			          'Escala II',
			          'Escala III',
			          'Escala IV',
			          'Escala V'
			      ],
			      datasets: [
			        """),format.raw/*421.12*/("""{"""),format.raw/*421.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc'],
			        """),format.raw/*424.12*/("""}"""),format.raw/*424.13*/("""
			      ]
			    """),format.raw/*426.8*/("""}"""),format.raw/*426.9*/("""
			    
		var pieChartCanvas00 = $('#pieChart00').get(0).getContext('2d')
		var pieData00       = donutData00;
		
		var pieChart00 = new Chart(pieChartCanvas00, """),format.raw/*431.48*/("""{"""),format.raw/*431.49*/("""
			type: 'pie',
			data: pieData00,
			options: pieOptions      
		"""),format.raw/*435.3*/("""}"""),format.raw/*435.4*/(""")
	"""),format.raw/*436.2*/("""}"""),format.raw/*436.3*/("""
	
"""),format.raw/*438.1*/("""}"""),format.raw/*438.2*/("""

</script>"""))}
    }
    
    def render(formBuscador:DynamicForm,pId:Long,total:Integer,totalconv:Integer,totalparque:Integer): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,pId,total,totalconv,totalparque)
    
    def f:((DynamicForm,Long,Integer,Integer,Integer) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,pId,total,totalconv,totalparque) => apply(formBuscador,pId,total,totalconv,totalparque)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informeHonorario/honorarioRrhhPorPeriodo.scala.html
                    HASH: ac17b3067ccfa529dfbf122970b9b0391a35b4dc
                    MATRIX: 852->1|1084->150|1116->174|1190->93|1218->218|1256->221|1269->226|1338->286|1378->288|1416->291|1429->296|1479->324|1517->327|1530->332|1577->357|1936->680|1989->724|2029->726|2071->736|2209->839|2316->924|2358->931|2458->1009|2664->1179|2684->1190|2759->1243|3425->1873|3445->1884|3538->1955|3669->2051|3693->2066|3732->2067|3935->2234|3962->2239|4179->2420|4212->2431|4429->2612|4460->2621|9695->7824|9729->7826|9784->7852|9814->7853|9896->7907|9925->7908|9975->7929|10005->7930|10096->7993|10125->7994|10216->8056|10246->8057|10423->8205|10453->8206|10733->8457|10763->8458|10837->8503|10867->8504|10939->8547|10969->8548|11026->8576|11056->8577|11825->9318|11854->9319|11948->9385|11977->9386|12592->9973|12621->9974|12701->10026|12730->10027|12760->10029|12789->10030|12966->10178|12996->10179|13287->10441|13317->10442|13391->10487|13421->10488|13493->10531|13523->10532|13580->10560|13610->10561|14392->11315|14421->11316|14519->11386|14548->11387|15163->11974|15192->11975|15276->12031|15305->12032|15335->12034|15364->12035|15435->12077|15465->12078|15521->12105|15551->12106|15773->12299|15803->12300|15957->12425|15987->12426|16034->12445|16063->12446|16252->12606|16282->12607|16377->12674|16406->12675|16437->12678|16466->12679|16535->12719|16565->12720|16622->12748|16652->12749|16874->12942|16904->12943|17058->13068|17088->13069|17135->13088|17164->13089|17355->13251|17385->13252|17481->13320|17510->13321|17541->13324|17570->13325|17601->13328|17630->13329
                    LINES: 26->1|37->9|37->9|38->5|39->9|41->11|41->11|41->11|41->11|43->13|43->13|43->13|45->15|45->15|45->15|69->39|69->39|69->39|69->39|72->42|72->42|73->43|73->43|78->48|78->48|78->48|100->70|100->70|100->70|107->77|107->77|107->77|113->83|113->83|121->91|121->91|129->99|129->99|271->241|272->242|276->246|276->246|278->248|278->248|280->250|280->250|283->253|283->253|287->257|287->257|291->261|291->261|302->272|302->272|303->273|303->273|304->274|304->274|306->276|306->276|332->302|332->302|334->304|334->304|348->318|348->318|351->321|351->321|352->322|352->322|356->326|356->326|366->336|366->336|367->337|367->337|368->338|368->338|370->340|370->340|396->366|396->366|398->368|398->368|406->376|406->376|409->379|409->379|410->380|410->380|413->383|413->383|414->384|414->384|423->393|423->393|426->396|426->396|428->398|428->398|434->404|434->404|438->408|438->408|439->409|439->409|441->411|441->411|442->412|442->412|451->421|451->421|454->424|454->424|456->426|456->426|461->431|461->431|465->435|465->435|466->436|466->436|468->438|468->438
                    -- GENERATED --
                */
            