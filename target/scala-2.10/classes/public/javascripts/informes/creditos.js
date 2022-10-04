$( function(){
	
	getDatosInformesCreditosPresupuestarios();
	
	
});
google.charts.load('current', {'packages':['gauge']});
google.charts.load('current', {packages: ['corechart', 'line']});

function getDatosInformesCreditosPresupuestarios(){
	
	if($('#lugarId').val() != null){
		var data = 'lugarId='+$('#lugarId').val(); 
		var url = '/informes/getDatosInformesCreditosPresupuestarios';
		
		$.get(url, data, function(data){
			 
			if(data.success) {
				var s = "";
				var d = "";
				$.each(data.results, function(idx,valor) {
					
					d = '<div class="row"  style="">';
						d += '<div class="col-sm-12 center-block">';
							d += '<center>';
								d += '<h3>'+valor['cuenta']+'</h3>';
							d += '</center>';
						d += '</div>';
					d += '</div>';
				
					d += '<div class="row"  style="border-bottom: 1px solid #e5e3e3;">';
						d += '<div class="col-sm-3" style="">';
							d += '<div id="'+valor['cuenta_analitica_padre_id']+'_1" style=""></div>';
						d += '</div>';
						d += '<div class="col-sm-9" style="">';
							d += '<div id="'+valor['cuenta_analitica_padre_id']+'_2"  style=""></div>';
						d += '</div>';
					d += '</div>';
					 
					var html = $.parseHTML( d );
					$("#contenedorGraficos").append( html );
					 
					/*GRAFICO RELOJ*/
				   var data = google.visualization.arrayToDataTable([
				     ['Label', 'Percent'],
				     ['SALDO', valor['saldo']]
				   ]);
				   var formatter = new google.visualization.NumberFormat({pattern: "#'%'"})
				   formatter.format(data, 1);
				   
				   var options = {
				   		vAxis: {
				   		    format: '#%'
				   		},	 
				     redFrom: 80, 
				     redTo: 100,
				     yellowFrom:70, 
				     yellowTo: 80,
				     minorTicks: 10
				   };
				
				   var chart = new google.visualization.Gauge(document.getElementById(valor['cuenta_analitica_padre_id']+'_1'));
					   chart.draw(data, options);
					
					/* GRAFICO LINE*/
					var data = new google.visualization.DataTable();
				      data.addColumn('string', 'X');
				      data.addColumn('number', ''); 
	
				      data.addRows([
				        ['PREVENTIVO', valor['preventivo']],['DEFINITIVO', valor['definitivo']],['OBLIGACION',valor['obligacion']],['PAGO', valor['pago']]
				      ]);
				      
				      var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true, pattern: '#,###'});
				    	  formatter.format(data, 1); 
				      
					  var options = {
				    		 pointsVisible: true,	  
				        hAxis: {
				          logScale: true
				        },
				        vAxis: {
				          logScale: false,
				          format: 'currency'
				        },
				        colors: ['#a52714', '#097138']
				      };
	
				      var chart = new google.visualization.LineChart(document.getElementById(valor['cuenta_analitica_padre_id']+'_2'));
				      chart.draw(data, options);
				});
			}else{
				alert("No se han podido obtener los datos.")
			}
		});
		
		
	}
}