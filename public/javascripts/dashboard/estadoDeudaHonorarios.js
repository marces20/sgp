$( function(){
	
	var idEjercicio = 3;
	getEstadoDeudaHonorariosPorEjercicio(idEjercicio); 
	getEstadoDeudaHonorariosPorPeriodo(idEjercicio); 
	
});	

google.load('visualization', '1.0', {'packages':['corechart']});
google.load('visualization', '1.0', {'packages':['table']});
/*google.setOnLoadCallback(getGraficoEstadoDeudaHonorariosPorEjercicio);*/

function getEstadoDeudaHonorariosPorPeriodo(idEjercicio){
	var url = '/dashboard/honorarios/getEstadoDeudaPorPeriodo';
	var data = 'idEjercicio='+idEjercicio;
	
	$.post(url, data, function(data){
		var resuArray = [];
		resuArray[0] = ['Periodo', 'Pagado', 'No pagado'];
		resuArray[1] = ['0', 0,0];
		
		if(data.results) {
			var z = 1;
			$.each(data.results, function(idx,ret) {
				var valorTmp = []; 
				valorTmp[0] = idx;
				valorTmp[1] = ret['pagados'];
				valorTmp[2] = ret['no pagados'];		
				resuArray [z] = valorTmp;
				z ++;
				
			});
		} else {
			 
		}
		
		getGraficoEstadoDeudaHonorariosPorPeriodo(resuArray,idEjercicio);
	});
}

function getGraficoEstadoDeudaHonorariosPorPeriodo(rows,idEjercicio){
		 var data2 = google.visualization.arrayToDataTable(rows);
	                                                 
	     var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
	     formatter.format(data2, 1);
	     formatter.format(data2, 2);
	     
	     /*var view = new google.visualization.DataView(data2);
	     view.setColumns([0, 1,{ calc: "stringify",sourceColumn: 1,type: "string",role: "annotation" },2,{ calc: "stringify",sourceColumn: 2,type: "string",role: "annotation" }]);
	     */
	     var options = {
	       				title: 'Estado de deuda por periodo',
	       				'height':500,
	       				titleTextStyle:{fontSize:14},
	       				legend: { position: 'top', maxLines: 3,fontSize: 18,bold: true },
	   					bar: { groupWidth: '95%' },
	   					hAxis: {logScale:true},
	       				vAxis: {title: 'Periodos',  titleTextStyle: {color: 'red'}},
	       				annotations: {textStyle: {fontSize: 18,bold: true}}
	     			  };
	     
	     function selectHandler() {
	          /*var selectedItem = chart2.getSelection()[0];*/
	          var selectedItem = chart2.getSelection();
	          var message = '';
	          var row = '';
	          var column = '';
	          for (var i = 0; i < selectedItem.length; i++) {
	        	    var item = selectedItem[i];
	        	    if (item.row != null && item.column != null) {
	        	      message += '{row:' + item.row + ',column:' + item.column + '}';
	        	      row = item.row;
	        	      column = item.column;
	        	    } else if (item.row != null) {
	        	      message += '{row:' + item.row + '}';
	        	      row = item.row;
	        	    } else if (item.column != null) {
	        	      column = item.column;
	        	      message += '{column:' + item.column + '}';
	        	    }
	          }
	          
	          if (selectedItem && selectedItem.length > 0) {
	        	var topping = data2.getValue(row, 0);
	            getTableEstadoDeudaHonorariosPorPeriodo(topping,column,idEjercicio);
	          }
	        }
	     
	     var chart2 = new google.visualization.BarChart(document.getElementById('chart_div_honorarios_periodo'));
	     google.visualization.events.addListener(chart2, 'select', selectHandler);
	     chart2.draw(data2, options);
	}

function getTableEstadoDeudaHonorariosPorPeriodo(topping,column,idEjercicio){
	 
	var rows = [];
	var url = '';
	var title = ''; 
	var row = [];
	if(column == '1'){
		url = '/dashboard/honorarios/getDataEstadoDeudaPagadosPorPeriodo';
		title = 'Pagados';
	}else{
		if(column == '2'){
			url = '/dashboard/honorarios/getDataEstadoDeudaNoPagadosPorPeriodo';
			title = 'No Pagados';
		}else{
			alert('No se encuentras Datos disponibles.')
			return false;
		}
	}
	
	var data = 'idEjercicio='+idEjercicio+'&nombrePeriodo='+topping;
	
	var divTabla = document.getElementById('table_div_honorarios_periodo');
 	$('#table_div_honorarios_periodo').empty();
 	$('#table_div_honorarios_periodo').append(getLoading());
 	
 	$.post(url, data, function(data){
 		if(data.results) {
 			var c = 0;
 			$.each(data.results, function(idx,valor) {
 				var datos = [];
 				datos[0] = valor['apellido'];
 				datos[1] = valor['expediente'];
 				datos[2] = valor['total'];
 				row[c] = datos;
 				c++;
 			});
 			 
 			var dataTable = new google.visualization.DataTable();
 			dataTable.addColumn('string', 'Proveedor');
 			dataTable.addColumn('string', 'Expediente');
 			dataTable.addColumn('number', 'Total');
 			dataTable.addRows(row);
 		     
 		    var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
 		    formatter.format(dataTable, 2); // Apply formatter to second column

		    var table = new google.visualization.Table(document.getElementById('table_div_honorarios_periodo'));
		    var options = {	'title':'Pagados',width : 750, sort : 'enable',
		    				height:320, 
		    				scrollLeftStartPosition : 50, 
		    				showRowNumber : true,  allowHtml:true };

		    
 		    table.draw(dataTable, options);
 		   $('#table_div_honorarios_periodo').prepend('<h3>'+title+' - '+topping+'</h3>'); 
 		   /* google.visualization.events.addListener(table, 'select', selectHandler);
 		    
 		    function selectHandler() {
 		      alert('A table row was selected');
 		    }*/
 		}	
 	});
	
	
}

function getEstadoDeudaHonorariosPorEjercicio(idEjercicio){
	var url = '/dashboard/honorarios/getEstadoDeudaPorEjercicio';
	var data = 'idEjercicio='+idEjercicio;
	$.post(url, data, function(data){
		var pagadosArray = [];
		pagadosArray[0] = 'Pagados';
		pagadosArray[1] = 0;
		var noPagadosArray = [];
		noPagadosArray[0] = 'No pagados';
		noPagadosArray[1] = 0;
		var resuArray = [pagadosArray,noPagadosArray];
		if(data.results) {
			$.each(data.results, function(idx,valor) {
				pagadosArray[0] = 'Pagados';
				pagadosArray[1] = valor['pagados'];
				noPagadosArray[0] = 'No pagados';
				noPagadosArray[1] = valor['noPagados'];
			});
			
			resuArray = [pagadosArray,noPagadosArray];
		} else {
			
		}
		getGraficoEstadoDeudaHonorariosPorEjercicio(resuArray,idEjercicio);
	});
	
}

function getGraficoEstadoDeudaHonorariosPorEjercicio(rows,idEjercicio){
	 
		var data = new google.visualization.DataTable();
	    data.addColumn('string', 'Estado');
	    data.addColumn('number', 'Monto');
	    data.addRows(rows);
		
	    var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
	    formatter.format(data, 1); // Apply formatter to second column
	    
	    var options = {'title':'Estado de deuda Ejercicio 2014',
	                   'width':410,
	                   'height':350,
	                    titleTextStyle:{fontSize:14},
	                    chartArea:{left:20,top:50,bottom:0,width:'100%',backgroundColor:'#fdc'},
	                    pieSliceText: '%percentage% (%value%)',
	                    legend: { position: 'top',alignment:'center', maxLines: 3,fontSize: 18,bold: true }
	                	 
	    				};
	    
	    function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var topping = data.getValue(selectedItem.row, 0);
            /*alert('The user selected ' + topping);*/
            getTableEstadoDeudaHonorariosPorEjercicio(topping,idEjercicio);
          }
        }
	    
	    // Instantiate and draw our chart, passing in some options.
	    var chart = new google.visualization.PieChart(document.getElementById('chart_div_honorarios_ejercicio'));
	    google.visualization.events.addListener(chart, 'select', selectHandler);    
	    chart.draw(data, options);
}

 

function getTableEstadoDeudaHonorariosPorEjercicio(topping,idEjercicio){
	var rows = [];
	var url = '';
	var title = ''; 
	var row = [];
	if(topping == 'Pagados'){
		url = '/dashboard/honorarios/getDataEstadoDeudaPagadosPorEjercicio';
		title = 'Pagados';
	}else{
		url = '/dashboard/honorarios/getDataEstadoDeudaNoPagadosPorEjercicio';
		title = 'No Pagados';
	}
    var data = 'idEjercicio='+idEjercicio;
 	
 	
 	var divTabla = document.getElementById('table_div_honorarios_ejercicio');
 	$('#table_div_honorarios_ejercicio').empty();
 	$('#table_div_honorarios_ejercicio').append(getLoading());
 	$.post(url, data, function(data){
 		if(data.results) {
 			var c = 0;
 			$.each(data.results, function(idx,valor) {
 				var datos = [];
 				datos[0] = valor['apellido'];
 				datos[1] = valor['expediente'];
 				datos[2] = valor['total'];
 				row[c] = datos;
 				c++;
 			});
 			 
 			var dataTable = new google.visualization.DataTable();
 			dataTable.addColumn('string', 'Proveedor');
 			dataTable.addColumn('string', 'Expediente');
 			dataTable.addColumn('number', 'Total');
 			dataTable.addRows(row);
 		     
 		    var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
 		    formatter.format(dataTable, 2); // Apply formatter to second column

		    var table = new google.visualization.Table(document.getElementById('table_div_honorarios_ejercicio'));
		    var options = {	'title':'Pagados',width : 750, sort : 'enable',
		    				height:320, 
		    				scrollLeftStartPosition : 50, 
		    				showRowNumber : true,  allowHtml:true };

		    
 		    table.draw(dataTable, options);
 		   $('#table_div_honorarios_ejercicio').prepend('<h3>'+title+'</h3>'); 
 		   /* google.visualization.events.addListener(table, 'select', selectHandler);
 		    
 		    function selectHandler() {
 		      alert('A table row was selected');
 		    }*/
 		}	
 	});
}
