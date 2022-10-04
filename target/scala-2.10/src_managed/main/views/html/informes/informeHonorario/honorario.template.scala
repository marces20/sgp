
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
object honorario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template11[DynamicForm,Long,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,
pId:Long,
total:java.math.BigDecimal,
totalp:java.math.BigDecimal,
totalsp:java.math.BigDecimal,
totalParque:java.math.BigDecimal,
totalpParque:java.math.BigDecimal,
totalspParque:java.math.BigDecimal,
totalConvenio:java.math.BigDecimal,
totalpConvenio:java.math.BigDecimal,
totalspConvenio:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*15.2*/implicitFieldConstructor/*15.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*11.38*/("""
"""),format.raw/*15.70*/("""

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.informes.mainInformes("Honorarios - Costo por Periodo")/*17.68*/ {_display_(Seq[Any](format.raw/*17.70*/("""

"""),_display_(Seq[Any](/*19.2*/views/*19.7*/.html.informes.navInformes())),format.raw/*19.35*/("""

"""),_display_(Seq[Any](/*21.2*/views/*21.7*/.html.tags.successError())),format.raw/*21.32*/("""
 
	<div class="row">
		<div class="col-sm-4">
			<h1>Honorarios  - Costo por Periodo</h1>
			 
		
		</div>
		<div class="col-sm-4">
			
		</div>

		<div class="col-sm-4">
			
			 
		
		</div>
	</div>
 
<form action="" method="GET" id="filtroInforme">
    	 
	<div class="row seccion">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*44.28*/if(formBuscador.error("periodo_id") != null)/*44.72*/ {_display_(Seq[Any](format.raw/*44.74*/("""has-error""")))})),format.raw/*44.84*/("""">
				<label for="periodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*47.7*/inputText(formBuscador("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*47.92*/("""
					"""),_display_(Seq[Any](/*48.7*/inputText(formBuscador("periodo.id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*48.85*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*53.21*/controllers/*53.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*53.85*/("""" 
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
				<a href=""""),_display_(Seq[Any](/*75.15*/controllers/*75.26*/.informes.routes.InformesHonorariosController.honorario())),format.raw/*75.83*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
		
	</div>
</form>
<hr>
"""),_display_(Seq[Any](/*82.2*/if(pId != null)/*82.17*/{_display_(Seq[Any](format.raw/*82.18*/("""
<div class="row seccion">
   	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Liquidado</h3>
	          <p>"""),_display_(Seq[Any](/*88.16*/utils/*88.21*/.NumberUtils.moneda(total))),format.raw/*88.47*/("""</p>
	  	  </div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Patronales</h3>
	          <p>"""),_display_(Seq[Any](/*96.16*/utils/*96.21*/.NumberUtils.moneda(totalp))),format.raw/*96.48*/("""</p>
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Liquidado S/P</h3>
	          <p>"""),_display_(Seq[Any](/*104.16*/utils/*104.21*/.NumberUtils.moneda(totalsp))),format.raw/*104.49*/("""</p>
	  	  </div>
		 </div>
	 </div> 
</div>

<div class="row seccion">
   	 <div class="col-sm-3">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h4>Total Liquidado Parque</h4>
	          <p>"""),_display_(Seq[Any](/*115.16*/utils/*115.21*/.NumberUtils.moneda(totalParque))),format.raw/*115.53*/("""</p>
	  	  </div>
		 </div>
	 </div>
	
	 <div class="col-sm-3">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h4>Total Liquidado Parque S/P</h4>
	          <p>"""),_display_(Seq[Any](/*124.16*/utils/*124.21*/.NumberUtils.moneda(totalspParque))),format.raw/*124.55*/("""</p>
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-3">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h4>Total Liquidado Conv.</h4>
	          <p>"""),_display_(Seq[Any](/*132.16*/utils/*132.21*/.NumberUtils.moneda(totalConvenio))),format.raw/*132.55*/("""</p>
	  	  </div>
		 </div>
	 </div>
	
	 <div class="col-sm-3">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h4>Total Liquidado Conv. S/P</h4>
	          <p>"""),_display_(Seq[Any](/*141.16*/utils/*141.21*/.NumberUtils.moneda(totalspConvenio))),format.raw/*141.57*/("""</p>
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
                    <th>Totales Bruto</th>
                     
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>Escala I</td>
                    <td id="escala1parque"></td>
                  </tr> 
                  <tr>
                    <td>Escala II</td>
                    <td id="escala2parque"></td>
                  </tr>
                  <tr>
                    <td>Escala III</td>
                    <td id="escala3parque"></td>
                  </tr>   
                  <tr>
                    <td>Escala IV</td>
                    <td id="escala4parque"></td>
                  </tr>   
                  <tr>
                    <td>Escala V</td>
                    <td id="escala5parque"></td>
                  </tr>
                  <tr>
                    <td style="font-weight:bold;font-size: 15px;">Total</td>
                    <td id="escalaTotalParque" style="font-weight:bold;font-size: 15px;"></td>
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
                    <th>Totales Bruto</th>
                     
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Escala I</td>
                    <td id="escala1convenio"></td>
                  </tr> 
                  <tr>
                    <td>Escala II</td>
                    <td id="escala2convenio"></td>
                  </tr>
                  <tr>
                    <td>Escala III</td>
                    <td id="escala3convenio"></td>
                  </tr>   
                  <tr>
                    <td>Escala IV</td>
                    <td id="escala4convenio"></td>
                  </tr>   
                  <tr>
                    <td>Escala V</td>
                    <td id="escala5convenio"></td>
                  </tr>
                  <tr>
                    <td style="font-weight:bold;font-size: 15px;">Total</td>
                    <td id="escalaTotalConvenio" style="font-weight:bold;font-size: 15px;"></td>
                  </tr>   
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
	</div> 
</div>

<hr>
		
 <h3 class="card-title">Conceptos</h3>
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
                <canvas id="pieChart" style="height:230px; min-height:230px"></canvas>
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
                    <th>Totales Bruto</th>
                     
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>bruto</td>
                    <td id="brutoparque"></td>
                  </tr> 
                  <tr>
                    <td>hca</td>
                    <td id="hcaparque"></td>
                  </tr>
                  <tr>
                    <td>hsa</td>
                    <td id="hsaparque"></td>
                  </tr>   
                  <tr>
                    <td>totalret</td>
                    <td id="retparque"></td>
                  </tr>   
                  <tr>
                    <td>neto</td>
                    <td id="netoparque"></td>
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
            <canvas id="pieChart2" style="height:230px; min-height:230px"></canvas>
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
                    <th>Totales Bruto</th>
                     
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>bruto</td>
                    <td id="brutoconvenio"></td>
                  </tr> 
                  <tr>
                    <td>hca</td>
                    <td id="hcaconvenio"></td>
                  </tr>
                  <tr>
                    <td>hsa</td>
                    <td id="hsaconvenio"></td>
                  </tr>   
                  <tr>
                    <td>totalret</td>
                    <td id="retconvenio"></td>
                  </tr>   
                  <tr>
                    <td>neto</td>
                    <td id="netoconvenio"></td>
                  </tr>   
                  
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
	</div> 
</div>

 
<hr>
		
 <h3 class="card-title">Clasificaciones</h3>
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
                <canvas id="pieChart3" style="height:230px; min-height:230px"></canvas>
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
                    <th>Totales bruto</th>
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>Haber Contrato</td>
                    <td id="haberParque"></td>
                  </tr> 
                  <tr>
                    <td>Guardias</td>
                    <td id="guardiaParque"></td>
                  </tr>
                  <tr>
                    <td>Produccion</td>
                   	<td id="produccionParque"></td>
                  </tr>   
                    
                  <tr>
                    <td>Descuento Ley</td>
                    <td id="descuentosParque"></td>
                  </tr>  
                  <tr>
                    <td>Adicionales</td>
                    <td id="adicionalesParque"></td>
                  </tr> 
                  <tr>
                    <td>Ganancias</td>
                    <td id="gananciasParque"></td>
                  </tr>  
                  <tr>
                    <td>Otros</td>
                    <td id="otrosParque"></td>
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
            <canvas id="pieChart4" style="height:230px; min-height:230px"></canvas>
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
                    <th>Totales bruto</th>
                     
                  </tr>
                </thead>
                <tbody>
				  <tr>
                    <td>Haber Contrato</td>
                    <td id="haberConvenio"></td>
                  </tr> 
                  <tr>
                    <td>Guardias</td>
                    <td id="guardiaConvenio"></td>
                  </tr>
                  <tr>
                    <td>Produccion</td>
                   	<td id="produccionConvenio"></td>
                  </tr>   
                    
                  <tr>
                    <td>Descuento Ley</td>
                    <td id="descuentosConvenio"></td>
                  </tr>  
                  <tr>
                    <td>Adicionales</td>
                    <td id="adicionalesConvenio"></td>
                  </tr> 
                  <tr>
                    <td>Ganancias</td>
                    <td id="gananciasConvenio"></td>
                  </tr>  
                  <tr>
                    <td>Otros</td>
                    <td id="otrosConvenio"></td>
                  </tr>  
                   
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
	</div> 
</div>

<hr>
""")))})),format.raw/*530.2*/("""

<script>

$( function() """),format.raw/*534.15*/("""{"""),format.raw/*534.16*/("""
	$('#searchProveedor,#searchPeriodo').modalSearch();
"""),format.raw/*536.1*/("""}"""),format.raw/*536.2*/(""");

var pieOptions = """),format.raw/*538.18*/("""{"""),format.raw/*538.19*/("""
					maintainAspectRatio : false,
	      			responsive : true,
	    		"""),format.raw/*541.8*/("""}"""),format.raw/*541.9*/("""


var idPeriodo = $('#periodo_id').val();


if(idPeriodo != '')"""),format.raw/*547.20*/("""{"""),format.raw/*547.21*/("""
	var url = '/informes/honorarios/getCostoPorEscala';	
	var data = 'idPeriodo='+idPeriodo+'&convenio=false';
	$.post(url, data, function(data)"""),format.raw/*550.34*/("""{"""),format.raw/*550.35*/("""
		var labels = [];
		var dataEscalaParque = [0,0,0,0,0];
		var totalEscalaParque = 0;
		if(data.success) """),format.raw/*554.20*/("""{"""),format.raw/*554.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*555.45*/("""{"""),format.raw/*555.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*556.43*/("""{"""),format.raw/*556.44*/("""
					 
					switch(valor1) """),format.raw/*558.21*/("""{"""),format.raw/*558.22*/("""
						case '1':
				 			dataEscalaParque[0]= valor2;
				 			$('#escala1parque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))); 
				 		break;
						case '2':
				 			dataEscalaParque[1]= valor2;
				 			$('#escala2parque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))); 
				 		break;
						case '3':
				 			dataEscalaParque[2]= valor2;
				 			$('#escala3parque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))); 
				 		break;
						case '4':
				 			dataEscalaParque[3]= valor2;
				 			$('#escala4parque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
				 		break;
						case '5':
				 			dataEscalaParque[4]= valor2;
				 			$('#escala5parque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
				 		break;
					"""),format.raw/*579.6*/("""}"""),format.raw/*579.7*/("""
					 
					totalEscalaParque = parseFloat(totalEscalaParque) + parseFloat(valor2);
					
				"""),format.raw/*583.5*/("""}"""),format.raw/*583.6*/("""); 
				$('#escalaTotalParque').html(formatNumberPesos(parseFloat(totalEscalaParque).toFixed(2)));
			"""),format.raw/*585.4*/("""}"""),format.raw/*585.5*/(""");
			
			
			
			setDataEscalaParque(dataEscalaParque);
		"""),format.raw/*590.3*/("""}"""),format.raw/*590.4*/("""
	"""),format.raw/*591.2*/("""}"""),format.raw/*591.3*/(""");
	
	var url = '/informes/honorarios/getCostoPorEscala';
	var data = 'idPeriodo='+idPeriodo+'&convenio=true';
	$.post(url, data, function(data)"""),format.raw/*595.34*/("""{"""),format.raw/*595.35*/("""
		var labels = [];
		var dataEscalaConvenio = [0,0,0,0,0];
		var totalEscalaConvenio = 0;
		if(data.success) """),format.raw/*599.20*/("""{"""),format.raw/*599.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*600.45*/("""{"""),format.raw/*600.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*601.43*/("""{"""),format.raw/*601.44*/("""
					 
					switch(valor1) """),format.raw/*603.21*/("""{"""),format.raw/*603.22*/("""
						case '1':
							dataEscalaConvenio[0]= valor2;
							$('#escala1convenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
				  		break;
						case '2':
							dataEscalaConvenio[1]= valor2;
							$('#escala2convenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
				  		break;
						case '3':
							dataEscalaConvenio[2]= valor2;
							$('#escala3convenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
				  		break;
						case '4':
							dataEscalaConvenio[3]= valor2;
							$('#escala4convenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
				  		break;
						case '5':
							dataEscalaConvenio[4]= valor2;
							$('#escala5convenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
				  		break;
					"""),format.raw/*624.6*/("""}"""),format.raw/*624.7*/("""
					totalEscalaConvenio = parseFloat(totalEscalaConvenio) + parseFloat(valor2);
				"""),format.raw/*626.5*/("""}"""),format.raw/*626.6*/("""); 
				$('#escalaTotalConvenio').html(formatNumberPesos(parseFloat(totalEscalaConvenio).toFixed(2)));
			"""),format.raw/*628.4*/("""}"""),format.raw/*628.5*/(""");
			
			setDataEscalaConvenio(dataEscalaConvenio);
		"""),format.raw/*631.3*/("""}"""),format.raw/*631.4*/("""
	"""),format.raw/*632.2*/("""}"""),format.raw/*632.3*/(""");
	
	
	function setDataEscalaParque(data)"""),format.raw/*635.36*/("""{"""),format.raw/*635.37*/("""
		var donutData0        = """),format.raw/*636.27*/("""{"""),format.raw/*636.28*/("""
			      labels: [
			          'Escala I', 
			          'Escala II',
			          'Escala III',
			          'Escala IV',
			          'Escala V'
			      ],
			      datasets: [
			        """),format.raw/*645.12*/("""{"""),format.raw/*645.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc'],
			        """),format.raw/*648.12*/("""}"""),format.raw/*648.13*/("""
			      ]
			    """),format.raw/*650.8*/("""}"""),format.raw/*650.9*/("""
			    
		var pieChartCanvas0 = $('#pieChart0').get(0).getContext('2d')
		var pieData0       = donutData0;
		
		 
		var pieChart0 = new Chart(pieChartCanvas0, """),format.raw/*656.46*/("""{"""),format.raw/*656.47*/("""
			type: 'pie',
			data: pieData0,
			options: pieOptions      
		"""),format.raw/*660.3*/("""}"""),format.raw/*660.4*/(""")
	"""),format.raw/*661.2*/("""}"""),format.raw/*661.3*/("""
	
	function setDataEscalaConvenio(data)"""),format.raw/*663.38*/("""{"""),format.raw/*663.39*/("""
		var donutData00        = """),format.raw/*664.28*/("""{"""),format.raw/*664.29*/("""
			      labels: [
			          'Escala I', 
			          'Escala II',
			          'Escala III',
			          'Escala IV',
			          'Escala V'
			      ],
			      datasets: [
			        """),format.raw/*673.12*/("""{"""),format.raw/*673.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc'],
			        """),format.raw/*676.12*/("""}"""),format.raw/*676.13*/("""
			      ]
			    """),format.raw/*678.8*/("""}"""),format.raw/*678.9*/("""
			    
		var pieChartCanvas00 = $('#pieChart00').get(0).getContext('2d')
		var pieData00       = donutData00;
		
		var pieChart00 = new Chart(pieChartCanvas00, """),format.raw/*683.48*/("""{"""),format.raw/*683.49*/("""
			type: 'pie',
			data: pieData00,
			options: pieOptions      
		"""),format.raw/*687.3*/("""}"""),format.raw/*687.4*/(""")
	"""),format.raw/*688.2*/("""}"""),format.raw/*688.3*/("""
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	var url = '/informes/honorarios/getCostoPorTipoConcepto';
	var data = 'idPeriodo='+idPeriodo+'&convenio=true';
	$.post(url, data, function(data)"""),format.raw/*693.34*/("""{"""),format.raw/*693.35*/("""
		var labels = [];
		var dataConceptoConvenio = [0,0,0,0];
		var brutoc = 0;
		var hcac = 0;
		var hsac = 0;
		var retc = 0;
		var descc = 0;
		if(data.success) """),format.raw/*701.20*/("""{"""),format.raw/*701.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*702.45*/("""{"""),format.raw/*702.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*703.43*/("""{"""),format.raw/*703.44*/("""
					brutoc = brutoc+valor2;  
					switch(valor1) """),format.raw/*705.21*/("""{"""),format.raw/*705.22*/("""
						case '1':
							dataConceptoConvenio[0]= valor2;
							$('#hcaconvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
							hcac = valor2;
						break;
						case '2':
							dataConceptoConvenio[1]= valor2;
							$('#hsaconvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
							hsac = valor2;
				  		break;
						case '3':
							dataConceptoConvenio[2]= valor2;
							$('#retconvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
							retc = valor2;
				  		break;
						case '4'://descuento
							dataConceptoConvenio[3]= valor2;
							descc = valor2; 
				  		break;
					"""),format.raw/*725.6*/("""}"""),format.raw/*725.7*/("""//brutoconvenio hcaconvenio hsaconvenio retconvenio netoconvenio
				"""),format.raw/*726.5*/("""}"""),format.raw/*726.6*/("""); 
			"""),format.raw/*727.4*/("""}"""),format.raw/*727.5*/(""");
			$('#brutoconvenio').html(formatNumberPesos(parseFloat(brutoc).toFixed(2)));
			var netoc = (hcac+hsac+descc)-retc;
			$('#netoconvenio').html(formatNumberPesos(parseFloat(netoc).toFixed(2))) 
			setDataConceptoConvenio(dataConceptoConvenio);
		"""),format.raw/*732.3*/("""}"""),format.raw/*732.4*/("""
	"""),format.raw/*733.2*/("""}"""),format.raw/*733.3*/(""");
	
	var url = '/informes/honorarios/getCostoPorTipoConcepto';
	var data = 'idPeriodo='+idPeriodo+'&convenio=false';
	$.post(url, data, function(data)"""),format.raw/*737.34*/("""{"""),format.raw/*737.35*/("""
		var labels = [];
		var dataConceptoParque = [0,0,0,0];
		var bruto = 0;
		var hca = 0;
		var hsa = 0;
		var ret = 0;
		var desc = 0;
		if(data.success) """),format.raw/*745.20*/("""{"""),format.raw/*745.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*746.45*/("""{"""),format.raw/*746.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*747.43*/("""{"""),format.raw/*747.44*/("""
					bruto = bruto+valor2; 
					switch(valor1) """),format.raw/*749.21*/("""{"""),format.raw/*749.22*/("""
						case '1':
							dataConceptoParque[0]= valor2;
							$('#hcaparque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
							hca = valor2;
						break;
						case '2':
							dataConceptoParque[1]= valor2;
							$('#hsaparque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
							hsa = valor2;
						break;
						case '3':
							dataConceptoParque[2]= valor2;
							$('#retparque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
							ret = valor2;
				  		break;
						case '4'://descuento
							dataConceptoParque[3]= valor2;
							desc = valor2;
							 
				  		break;
					"""),format.raw/*770.6*/("""}"""),format.raw/*770.7*/("""//brutoconvenio hcaconvenio hsaconvenio retconvenio netoconvenio
				"""),format.raw/*771.5*/("""}"""),format.raw/*771.6*/("""); 
			"""),format.raw/*772.4*/("""}"""),format.raw/*772.5*/(""");
			$('#brutoparque').html(formatNumberPesos(parseFloat(bruto).toFixed(2)));
			var neto = (hca+hsa+desc)-ret;
			$('#netoparque').html(formatNumberPesos(parseFloat(neto).toFixed(2)))
			setDataConceptoParque(dataConceptoParque);
		"""),format.raw/*777.3*/("""}"""),format.raw/*777.4*/("""
	"""),format.raw/*778.2*/("""}"""),format.raw/*778.3*/(""");
	
	function setDataConceptoParque(data)"""),format.raw/*780.38*/("""{"""),format.raw/*780.39*/("""
		var donutData        = """),format.raw/*781.26*/("""{"""),format.raw/*781.27*/("""
			      labels: [
			          'Haberes con Aporte', 
			          'Haberes Sin Aporte',
			          'Renteciones',
			          'Descuentos'
			      ],
			      datasets: [
			        """),format.raw/*789.12*/("""{"""),format.raw/*789.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef'],
			        """),format.raw/*792.12*/("""}"""),format.raw/*792.13*/("""
			      ]
			    """),format.raw/*794.8*/("""}"""),format.raw/*794.9*/("""
		
		var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
	    var pieData        = donutData;
	    var pieOptions     = """),format.raw/*798.27*/("""{"""),format.raw/*798.28*/("""
	      maintainAspectRatio : false,
	      responsive : true,
	    """),format.raw/*801.6*/("""}"""),format.raw/*801.7*/("""
	    
	    var pieChart = new Chart(pieChartCanvas, """),format.raw/*803.47*/("""{"""),format.raw/*803.48*/("""
	      type: 'pie',
	      data: pieData,
	      options: pieOptions      
	    """),format.raw/*807.6*/("""}"""),format.raw/*807.7*/(""")
	"""),format.raw/*808.2*/("""}"""),format.raw/*808.3*/("""
	
    function setDataConceptoConvenio(data)"""),format.raw/*810.43*/("""{"""),format.raw/*810.44*/("""
		var donutData2        = """),format.raw/*811.27*/("""{"""),format.raw/*811.28*/("""
			      labels: [
			          'Haberes con Aporte', 
			          'Haberes Sin Aporte',
			          'Renteciones',
			          'Descuentos'
			      ],
			      datasets: [
			        """),format.raw/*819.12*/("""{"""),format.raw/*819.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef'],
			        """),format.raw/*822.12*/("""}"""),format.raw/*822.13*/("""
			      ]
			    """),format.raw/*824.8*/("""}"""),format.raw/*824.9*/("""
	    var pieChartCanvas2 = $('#pieChart2').get(0).getContext('2d')
	    var pieData2       = donutData2;
	    
	    
	    var pieChart2 = new Chart(pieChartCanvas2, """),format.raw/*829.49*/("""{"""),format.raw/*829.50*/("""
	      type: 'pie',
	      data: pieData2,
	      options: pieOptions      
	    """),format.raw/*833.6*/("""}"""),format.raw/*833.7*/(""")
    """),format.raw/*834.5*/("""}"""),format.raw/*834.6*/("""
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var url = '/informes/honorarios/getCostoPorClasificacionConcepto';
	var data = 'idPeriodo='+idPeriodo+'&convenio=false';
	$.post(url, data, function(data)"""),format.raw/*838.34*/("""{"""),format.raw/*838.35*/("""
		var labels = [];
		var dataClasificacionParque = [0,0,0,0,0,0,0];
		var otro = 0; 
		if(data.success) """),format.raw/*842.20*/("""{"""),format.raw/*842.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*843.45*/("""{"""),format.raw/*843.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*844.43*/("""{"""),format.raw/*844.44*/("""
					
					switch(valor1) """),format.raw/*846.21*/("""{"""),format.raw/*846.22*/("""
						case '1':
							dataClasificacionParque[0]= valor2;
							$('#haberParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
						break;
						case '2':
							dataClasificacionParque[1]= valor2;
							$('#guardiaParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
						break;
						case '3':
							dataClasificacionParque[2]= valor2;
							$('#produccionParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
						break;
						case '5':
							dataClasificacionParque[3]= valor2;
							$('#descuentosParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
				  		break;
						case '6': 
							dataClasificacionParque[4]= valor2;
							$('#adicionalesParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
				  		break;
						case '9': 
							dataClasificacionParque[5]= valor2;
							$('#gananciasParque').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
						break;
						default:
							otro = otro + valor2;	
						break;
					"""),format.raw/*874.6*/("""}"""),format.raw/*874.7*/("""
				"""),format.raw/*875.5*/("""}"""),format.raw/*875.6*/("""); 
			"""),format.raw/*876.4*/("""}"""),format.raw/*876.5*/(""");
			dataClasificacionParque[6]= otro;
			$('#otrosParque').html(formatNumberPesos(parseFloat(otro).toFixed(2)))    
			setDataClasificiacionParque(dataClasificacionParque);
		"""),format.raw/*880.3*/("""}"""),format.raw/*880.4*/("""
	"""),format.raw/*881.2*/("""}"""),format.raw/*881.3*/(""");
	
	var data = 'idPeriodo='+idPeriodo+'&convenio=true';
	$.post(url, data, function(data)"""),format.raw/*884.34*/("""{"""),format.raw/*884.35*/("""
		var labels = [];
		var dataClasificacionConvenio = [0,0,0,0,0,0,0];
		var otroc = 0; 
		if(data.success) """),format.raw/*888.20*/("""{"""),format.raw/*888.21*/("""
			$.each(data.results, function(idx,valor) """),format.raw/*889.45*/("""{"""),format.raw/*889.46*/("""
				$.each(valor, function(valor1,valor2) """),format.raw/*890.43*/("""{"""),format.raw/*890.44*/("""
					
					switch(valor1) """),format.raw/*892.21*/("""{"""),format.raw/*892.22*/("""
						case '1':
							dataClasificacionConvenio[0]= valor2;
							$('#haberConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
						break;
						case '2':
							dataClasificacionConvenio[1]= valor2;
							$('#guardiaConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)));
						break;
						case '3':
							dataClasificacionConvenio[2]= valor2;
							$('#produccionConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2)))
						break;
						case '5':
							dataClasificacionConvenio[3]= valor2;
							$('#descuentosConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
				  		break;
						case '6': 
							dataClasificacionConvenio[4]= valor2;
							$('#adicionalesConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
				  		break;
						case '9': 
							dataClasificacionConvenio[5]= valor2;
							$('#gananciasConvenio').html(formatNumberPesos(parseFloat(valor2).toFixed(2))) 
						break;
						default:
							otroc = otroc + valor2;	
						break;
					"""),format.raw/*920.6*/("""}"""),format.raw/*920.7*/("""
				"""),format.raw/*921.5*/("""}"""),format.raw/*921.6*/("""); 
			"""),format.raw/*922.4*/("""}"""),format.raw/*922.5*/(""");
			dataClasificacionConvenio[6]= otroc;
			$('#otrosConvenio').html(formatNumberPesos(parseFloat(otroc).toFixed(2)))    
			setDataClasificiacionConvenio(dataClasificacionConvenio);
		"""),format.raw/*926.3*/("""}"""),format.raw/*926.4*/("""
	"""),format.raw/*927.2*/("""}"""),format.raw/*927.3*/(""");
	
	
	function setDataClasificiacionParque(data)"""),format.raw/*930.44*/("""{"""),format.raw/*930.45*/("""
	
		var donutData3        = """),format.raw/*932.27*/("""{"""),format.raw/*932.28*/("""
			      labels: [
			          'Haber Contrato', 
			          'Guardias',
			          'Produccion',
			          'Descuento Ley',
			          'Adicionales',
			          'Ganancias',
			          'Otros'
			      ],
			      datasets: [
			        """),format.raw/*943.12*/("""{"""),format.raw/*943.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de', '#d2d6de'],
			        """),format.raw/*946.12*/("""}"""),format.raw/*946.13*/("""
			      ]
			    """),format.raw/*948.8*/("""}"""),format.raw/*948.9*/("""
	    var pieChartCanvas3 = $('#pieChart3').get(0).getContext('2d')
	    var pieData3       = donutData3;
	     
	    var pieChart3 = new Chart(pieChartCanvas3, """),format.raw/*952.49*/("""{"""),format.raw/*952.50*/("""
	      type: 'pie',
	      data: pieData3,
	      options: pieOptions      
	    """),format.raw/*956.6*/("""}"""),format.raw/*956.7*/(""")
	"""),format.raw/*957.2*/("""}"""),format.raw/*957.3*/("""
	
	function setDataClasificiacionConvenio(data)"""),format.raw/*959.46*/("""{"""),format.raw/*959.47*/("""
		
		var donutData4        = """),format.raw/*961.27*/("""{"""),format.raw/*961.28*/("""
			      labels: [
			    	  'Haber Contrato', 
			          'Guardias',
			          'Produccion',
			          'Descuento Ley',
			          'Adicionales',
			          'Ganancias',
			          'Otros'
			      ],
			      datasets: [
			        """),format.raw/*972.12*/("""{"""),format.raw/*972.13*/("""
			          data: data,
			          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de', '#d2d6de'],
			        """),format.raw/*975.12*/("""}"""),format.raw/*975.13*/("""
			      ]
			    """),format.raw/*977.8*/("""}"""),format.raw/*977.9*/("""
	    var pieChartCanvas4 = $('#pieChart4').get(0).getContext('2d')
	    var pieData4       = donutData4;
	     
	    var pieChart4 = new Chart(pieChartCanvas4, """),format.raw/*981.49*/("""{"""),format.raw/*981.50*/("""
	      type: 'pie',
	      data: pieData4,
	      options: pieOptions      
	    """),format.raw/*985.6*/("""}"""),format.raw/*985.7*/(""")
	"""),format.raw/*986.2*/("""}"""),format.raw/*986.3*/("""
"""),format.raw/*987.1*/("""}"""),format.raw/*987.2*/("""
/*

$(function () """),format.raw/*990.15*/("""{"""),format.raw/*990.16*/("""

	 
    
    
///////////////////////////////////////////////////////////////
    
    
///////////////////////////////////////////////////////////////
    

	  
 
///////////////////////////////////////////////////////////////


  
"""),format.raw/*1007.1*/("""}"""),format.raw/*1007.2*/(""")*/

</script> 

""")))})))}
    }
    
    def render(formBuscador:DynamicForm,pId:Long,total:java.math.BigDecimal,totalp:java.math.BigDecimal,totalsp:java.math.BigDecimal,totalParque:java.math.BigDecimal,totalpParque:java.math.BigDecimal,totalspParque:java.math.BigDecimal,totalConvenio:java.math.BigDecimal,totalpConvenio:java.math.BigDecimal,totalspConvenio:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,pId,total,totalp,totalsp,totalParque,totalpParque,totalspParque,totalConvenio,totalpConvenio,totalspConvenio)
    
    def f:((DynamicForm,Long,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,pId,total,totalp,totalsp,totalParque,totalpParque,totalspParque,totalConvenio,totalpConvenio,totalspConvenio) => apply(formBuscador,pId,total,totalp,totalsp,totalParque,totalpParque,totalspParque,totalConvenio,totalpConvenio,totalspConvenio)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informeHonorario/honorario.scala.html
                    HASH: f4690e9a42f6588ef28b3832bae8ca7375da49d2
                    MATRIX: 1004->1|1485->398|1518->422|1593->341|1622->466|1660->469|1673->474|1743->535|1783->537|1821->540|1834->545|1884->573|1922->576|1935->581|1982->606|2356->944|2409->988|2449->990|2491->1000|2629->1103|2736->1188|2778->1195|2878->1273|3084->1443|3104->1454|3179->1507|3845->2137|3865->2148|3944->2205|4075->2301|4099->2316|4138->2317|4346->2489|4360->2494|4408->2520|4624->2700|4638->2705|4687->2732|4908->2916|4923->2921|4974->2949|5235->3173|5250->3178|5305->3210|5534->3402|5549->3407|5606->3441|5829->3627|5844->3632|5901->3666|6129->3857|6144->3862|6203->3898|17570->15233|17625->15259|17655->15260|17737->15314|17766->15315|17816->15336|17846->15337|17945->15408|17974->15409|18067->15473|18097->15474|18268->15616|18298->15617|18433->15723|18463->15724|18537->15769|18567->15770|18639->15813|18669->15814|18726->15842|18756->15843|19548->16607|19577->16608|19700->16703|19729->16704|19859->16806|19888->16807|19975->16866|20004->16867|20034->16869|20063->16870|20236->17014|20266->17015|20405->17125|20435->17126|20509->17171|20539->17172|20611->17215|20641->17216|20698->17244|20728->17245|21527->18016|21556->18017|21670->18103|21699->18104|21833->18210|21862->18211|21945->18266|21974->18267|22004->18269|22033->18270|22104->18312|22134->18313|22190->18340|22220->18341|22442->18534|22472->18535|22626->18660|22656->18661|22703->18680|22732->18681|22921->18841|22951->18842|23046->18909|23075->18910|23106->18913|23135->18914|23204->18954|23234->18955|23291->18983|23321->18984|23543->19177|23573->19178|23727->19303|23757->19304|23804->19323|23833->19324|24024->19486|24054->19487|24150->19555|24179->19556|24210->19559|24239->19560|24605->19897|24635->19898|24826->20060|24856->20061|24930->20106|24960->20107|25032->20150|25062->20151|25143->20203|25173->20204|25833->20836|25862->20837|25959->20906|25988->20907|26023->20914|26052->20915|26330->21165|26359->21166|26389->21168|26418->21169|26598->21320|26628->21321|26812->21476|26842->21477|26916->21522|26946->21523|27018->21566|27048->21567|27126->21616|27156->21617|27802->22235|27831->22236|27928->22305|27957->22306|27992->22313|28021->22314|28283->22548|28312->22549|28342->22551|28371->22552|28442->22594|28472->22595|28527->22621|28557->22622|28775->22811|28805->22812|28948->22926|28978->22927|29025->22946|29054->22947|29212->23076|29242->23077|29338->23145|29367->23146|29449->23199|29479->23200|29588->23281|29617->23282|29648->23285|29677->23286|29751->23331|29781->23332|29837->23359|29867->23360|30085->23549|30115->23550|30258->23664|30288->23665|30335->23684|30364->23685|30559->23851|30589->23852|30699->23934|30728->23935|30762->23941|30791->23942|31166->24288|31196->24289|31330->24394|31360->24395|31434->24440|31464->24441|31536->24484|31566->24485|31622->24512|31652->24513|32688->25521|32717->25522|32750->25527|32779->25528|32814->25535|32843->25536|33048->25713|33077->25714|33107->25716|33136->25717|33256->25808|33286->25809|33423->25917|33453->25918|33527->25963|33557->25964|33629->26007|33659->26008|33715->26035|33745->26036|34807->27070|34836->27071|34869->27076|34898->27077|34933->27084|34962->27085|35177->27272|35206->27273|35236->27275|35265->27276|35344->27326|35374->27327|35432->27356|35462->27357|35744->27610|35774->27611|35950->27758|35980->27759|36027->27778|36056->27779|36246->27940|36276->27941|36386->28023|36415->28024|36446->28027|36475->28028|36552->28076|36582->28077|36641->28107|36671->28108|36950->28358|36980->28359|37156->28506|37186->28507|37233->28526|37262->28527|37452->28688|37482->28689|37592->28771|37621->28772|37652->28775|37681->28776|37710->28777|37739->28778|37787->28797|37817->28798|38080->29032|38110->29033
                    LINES: 26->1|43->15|43->15|44->11|45->15|47->17|47->17|47->17|47->17|49->19|49->19|49->19|51->21|51->21|51->21|74->44|74->44|74->44|74->44|77->47|77->47|78->48|78->48|83->53|83->53|83->53|105->75|105->75|105->75|112->82|112->82|112->82|118->88|118->88|118->88|126->96|126->96|126->96|134->104|134->104|134->104|145->115|145->115|145->115|154->124|154->124|154->124|162->132|162->132|162->132|171->141|171->141|171->141|560->530|564->534|564->534|566->536|566->536|568->538|568->538|571->541|571->541|577->547|577->547|580->550|580->550|584->554|584->554|585->555|585->555|586->556|586->556|588->558|588->558|609->579|609->579|613->583|613->583|615->585|615->585|620->590|620->590|621->591|621->591|625->595|625->595|629->599|629->599|630->600|630->600|631->601|631->601|633->603|633->603|654->624|654->624|656->626|656->626|658->628|658->628|661->631|661->631|662->632|662->632|665->635|665->635|666->636|666->636|675->645|675->645|678->648|678->648|680->650|680->650|686->656|686->656|690->660|690->660|691->661|691->661|693->663|693->663|694->664|694->664|703->673|703->673|706->676|706->676|708->678|708->678|713->683|713->683|717->687|717->687|718->688|718->688|723->693|723->693|731->701|731->701|732->702|732->702|733->703|733->703|735->705|735->705|755->725|755->725|756->726|756->726|757->727|757->727|762->732|762->732|763->733|763->733|767->737|767->737|775->745|775->745|776->746|776->746|777->747|777->747|779->749|779->749|800->770|800->770|801->771|801->771|802->772|802->772|807->777|807->777|808->778|808->778|810->780|810->780|811->781|811->781|819->789|819->789|822->792|822->792|824->794|824->794|828->798|828->798|831->801|831->801|833->803|833->803|837->807|837->807|838->808|838->808|840->810|840->810|841->811|841->811|849->819|849->819|852->822|852->822|854->824|854->824|859->829|859->829|863->833|863->833|864->834|864->834|868->838|868->838|872->842|872->842|873->843|873->843|874->844|874->844|876->846|876->846|904->874|904->874|905->875|905->875|906->876|906->876|910->880|910->880|911->881|911->881|914->884|914->884|918->888|918->888|919->889|919->889|920->890|920->890|922->892|922->892|950->920|950->920|951->921|951->921|952->922|952->922|956->926|956->926|957->927|957->927|960->930|960->930|962->932|962->932|973->943|973->943|976->946|976->946|978->948|978->948|982->952|982->952|986->956|986->956|987->957|987->957|989->959|989->959|991->961|991->961|1002->972|1002->972|1005->975|1005->975|1007->977|1007->977|1011->981|1011->981|1015->985|1015->985|1016->986|1016->986|1017->987|1017->987|1020->990|1020->990|1037->1007|1037->1007
                    -- GENERATED --
                */
            