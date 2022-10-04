google.load('visualization', '1.0', {'packages':['corechart','table']});
$( function(){
	getDatos();
	getDatosEstadoDeudaChart();
	
	$('.nav-tabs li .tabCertificaciones').click(function (e) {
		getCertificaciones();
	});
	$('.nav-tabs li .tabFacturacion').click(function (e) {
		getFacturacion();
	});
	$('.nav-tabs li .tabPagos').click(function (e) {
		getPagos();
	});
	
	$('#searchProveedor').modalSearch();

});	



 
function getDatos(){
	var url = '/dashboard/estadoGeneralAgente/getDatosEstadoGeneralPorAgente';
	var data = 'proveedorId='+$('#proveedor_id').val();
	
	$.post(url, data, function(data){
		if(data.results) {
			$.each(data.results, function(idx,ret) {
				$(".nombre").append(ret.nombre);
				$(".cuit").append(ret.cuit);
				$(".relacion").append(ret.relacion);
			});
		} else {
			$(".nombre").append("");
			$(".cuit").append("");
			$(".relacion").append("");
		}
	});
}

function getDatosEstadoDeudaChart() {
	var url = '/dashboard/estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo';
	  
	var data = 'proveedorId='+$('#proveedor_id').val();
	
	$('#chart_pagos').html('<div id="loading-bg-50"></div>');
	$('#chart_certificaciones').html('<div id="loading-bg-50"></div>');
	$('#chart_facturacion').html('<div id="loading-bg-50"></div>');
	
	$.post(url, data, function(data){
		if(data.results) {
			
			accionGraficoCertificacion(data.results)
			
			$.each(data.results, function(idx,ret) {
				
				if(idx == "DeudasGenerales"){
					$.each(ret, function(idx2,ret2) {
						if(idx2 == "datos"){
							
							$.each(ret2, function(idx3,ret3) {
								
								if(idx3 == 'DeudaTotal'){
									$('#cuadroDeuda').html(formatNumberPesos(ret3));
								}
								if(idx3 == 'DeudaExigible'){
									$('#cuadroDeudaExigible').html(formatNumberPesos(ret3));
								}
								if(idx3 == 'Pagado'){
									$('#cuadroTotalPagado').html(formatNumberPesos(ret3));
								}
							});	
						}
					});
				}
				
			});
		}else{
			
		}
		
		
	});		
}

function accionGraficoCertificacion(results){
	var resuArrayCertificacion = [];
	resuArrayCertificacion[0] = ['Periodo', 'Certificadas', 'Aprobadas'];
	resuArrayCertificacion[1] = ['0', 0,0];
	
	$.each(results, function(idx,ret) {
		if(idx == "Certificaciones"){
			var z = 1;
			$.each(ret, function(idx2,ret2) {
				var valorTmp = []; 
				valorTmp[0] = idx2;
				valorTmp[1] = ret2['Certificado'];
				valorTmp[2] = ret2['Aprobado'];		
				resuArrayCertificacion [z] = valorTmp;
				z ++;
			});
		}
	});
	getGraficoCertificacion(resuArrayCertificacion);
	accionGraficoFacturacion(results)
} 

function accionGraficoFacturacion(results){
	var resuArrayFacturacion = [];
	resuArrayFacturacion[0] = ['Periodo', 'Esperando Aprobacion', 'Aprobadas'];
	resuArrayFacturacion[1] = ['0', 0,0];
	
	$.each(results, function(idx,ret) {
		if(idx == "Facturas"){
			var z = 1;
			$.each(ret, function(idx2,ret2) {
				var valorTmp = []; 
				valorTmp[0] = idx2;
				valorTmp[1] = ret2['Esperando'];
				valorTmp[2] = ret2['Aprobado'];		
				resuArrayFacturacion [z] = valorTmp;
				z ++;
			});
		}	
	});
	getGraficoFacturacion(resuArrayFacturacion);
	accionGraficoDeuda(results)
} 

function accionGraficoDeuda(results){
	var resuArrayDeuda = [];
	resuArrayDeuda[0] = ['Periodo', 'No Pagado', 'Pagado'];
	resuArrayDeuda[1] = ['0', 0,0];
	
	$.each(results, function(idx,ret) {
		if(idx == "Deuda"){
			var z = 1;
			$.each(ret, function(idx2,ret2) {
				var valorTmp = []; 
				valorTmp[0] = idx2;
				valorTmp[1] = ret2['NoPagado'];
				valorTmp[2] = ret2['Pagado'];		
				resuArrayDeuda [z] = valorTmp;
				z ++;
			});
		}
	});
	getGraficoDeuda(resuArrayDeuda);
} 

function getGraficoDeuda(resuArrayDeuda){
	
	var dataDeuda = google.visualization.arrayToDataTable(resuArrayDeuda);
	var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
	formatter.format(dataDeuda, 1);
	formatter.format(dataDeuda, 2);
	
  	var options = {
  		legend: { position: 'top'},
  		colors: ['#DC3912','green'],
  		hAxis: {title: 'Periodos', titleTextStyle: {color: 'blue'}},
  		vAxis: {format:'$#,###'}
  	  };
  	function selectHandlerDeuda() {
  		var selectedItem = chartDeuda.getSelection();
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
  			var topping = dataDeuda.getValue(row, 0);
            var posX = $('#chart_pagos').position().left - document.scrollLeft;
            var posY = $('#chart_pagos').position().top - document.scrollTop;
            var url = "/contabilidad/accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo?nombrePeriodo="+topping+"&estado="+column+"&proveedorId="+$('#proveedor_id').val();
    		var dialogo = crearDialogoGeneral(url);
    		dialogo.dialog({title: "Estado Deuda",height:450,width:900,position:[posX, posY]});
    		return false;
          }
  	}
  	$('#chart_pagos').html('');
  	var chartDeuda = new google.visualization.ColumnChart(document.getElementById('chart_pagos'));
  	google.visualization.events.addListener(chartDeuda, 'select', selectHandlerDeuda);
  	chartDeuda.draw(dataDeuda, options);
}

function getGraficoCertificacion(resuArrayCertificacion){
	
	var data = google.visualization.arrayToDataTable(resuArrayCertificacion);
	var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
	formatter.format(data, 1);
	formatter.format(data, 2);
	
  	var options = {
  		legend: { position: 'top'},
  		colors: ['#DC3912','green'],
  		hAxis: {title: 'Periodos', titleTextStyle: {color: 'blue'}},
  		vAxis: {format:'$#,###'}
  	  };
  	
  	function selectHandlerCertificacion() {
  		var selectedItem = chartCertificacion.getSelection();
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
        	var topping = data.getValue(row, 0);
            var posX = $('#chart_certificaciones').position().left - document.scrollLeft;
            var posY = $('#chart_certificaciones').position().top - document.scrollTop;
            var url = "/compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo?nombrePeriodo="+topping+"&estado="+column+"&proveedorId="+$('#proveedor_id').val();
    		var dialogo = crearDialogoGeneral(url);
    		dialogo.dialog({title: "Certificacion",height:450,position:[posX, posY]});
    		return false;
          }
  	}
  	
	$('#chart_certificaciones').html('');
	var chartCertificacion = new google.visualization.ColumnChart(document.getElementById('chart_certificaciones'));
  	google.visualization.events.addListener(chartCertificacion, 'select', selectHandlerCertificacion);
  	chartCertificacion.draw(data, options);	
}

function getGraficoFacturacion(resuArrayFacturacion){
	
	var data = google.visualization.arrayToDataTable(resuArrayFacturacion);
	var formatter = new google.visualization.NumberFormat({prefix: '$', negativeColor: 'red', negativeParens: true});
	formatter.format(data, 1);
	formatter.format(data, 2);
	
  	var options = {
  		legend: { position: 'top'},
  		colors: ['#DC3912','green'],
  		hAxis: {title: 'Periodos', titleTextStyle: {color: 'blue'}},
  		vAxis: {format:'$#,###'}
  	  };
  	
  	function selectHandlerFacturacion() {
  		var selectedItem = chartFacturacion.getSelection();
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
  			var topping = data.getValue(row, 0);
            var posX = $('#chart_facturacion').position().left - document.scrollLeft;
            var posY = $('#chart_facturacion').position().top - document.scrollTop;
            var url = "/contabilidad/facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo?nombrePeriodo="+topping+"&estado="+column+"&proveedorId="+$('#proveedor_id').val();
    		var dialogo = crearDialogoGeneral(url);
    		dialogo.dialog({title: "Facturacion",height:450,width:900,position:[posX, posY]});
    		return false;
          }
  	}
  	
	$('#chart_facturacion').html('');
  	var chartFacturacion = new google.visualization.ColumnChart(document.getElementById('chart_facturacion'));
  	google.visualization.events.addListener(chartFacturacion, 'select', selectHandlerFacturacion);
  	chartFacturacion.draw(data, options);
	
}

function getPagos(){
	var url = '/dashboard/estadoGeneralAgente/getPagosEstadoGeneralPorAgente';
	var data = 'proveedorId='+$('#proveedor_id').val();
	
	$.post(url, data, function(data){
		var tr = "";
		if(data.results && data.results.length > 0) {
			$(".tableEstadoGeneralAgentePagos tbody").empty();
			$.each(data.results, function(idx,ret) {
				tr += "<tr class='"+ret.classEstado+"'>";
					tr += "<td>"+ret.fecha+"</td>";
					tr += "<td>"+ret.referencia+"</td>";
					tr += "<td>"+ret.op+"</td>";
					tr += "<td>"+ret.expediente+"</td>";
					tr += "<td>"+ret.periodo+"</td>";
					tr += "<td>"+ret.profe+"</td>";
					tr += "<td>"+ret.total+"</td>";
					tr += "<td><div class='tip-top' title='"+ret.estadoSignificado+"'>"+ret.estado+"</div></td>";
					tr += "<td>" ;
					tr += "<a href='#' class='detallePagoModal' data-url='/contabilidad/accionesPagoProveedor/modalDetallePago?id="+ret.id+"'>" ;
					tr += "<i class='glyphicon glyphicon-tasks'></i></a>" ;
					tr += "</td>";
				tr += "</tr>";
			});
			tr += "<tr>";
			tr += "<td colspan='6' style='text-align: right;'><b>Totales:</b></td>";
			tr += "<td><b>"+data.totalTotal+"</b></td>";
			tr += "<td colspan='2'></td>";
			tr += "</tr>";
			 
			
		}else {
			tr += "<tr>";
				tr += "<td colspan='10' ><p><b>No contiene pagos</b></p></td>";
			tr += "</tr>";
		}
		
		$(".tableEstadoGeneralAgentePagos tbody").append(tr);
	});	
}

function getFacturacion(){
	var url = '/dashboard/estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente';
	var data = 'proveedorId='+$('#proveedor_id').val();
	$.post(url, data, function(data){
		var tr = "";
		if(data.results && data.results.length > 0) {
				
			$(".tableEstadoGeneralAgenteFacturacion tbody").empty();
			$.each(data.results, function(idx,ret) {
				tr += "<tr class='"+ret.classEstado+"'>";
					tr += "<td>"+ret.referencia+"</td>";
					tr += "<td>"+ret.OP+"</td>";
					tr += "<td>"+ret.numero+"</td>";
					tr += "<td>"+ret.expediente+"</td>";
					tr += "<td>"+ret.periodo+"</td>";
					tr += "<td>"+ret.profe+"</td>";
					tr += "<td>"+ret.base+"</td>";
					tr += "<td>"+ret.impuestos+"</td>";
					tr += "<td>"+ret.total+"</td>";
					tr += "<td>"+ret.saldo+"</td>";
					tr += "<td><div class='tip-top' title='"+ret.estadoSignificado+"'>"+ret.estado+"</div></td>";
					tr += "<td>" ;
					tr += "<a href='#' class='detalleFacturacionModal' data-url='/contabilidad/facturaProveedor/modalDetalleFacturacion?id="+ret.id+"'>" ;
					tr += "<i class='glyphicon glyphicon-tasks'></i></a>" ;
					tr += "</td>";
				tr += "</tr>";
			});
			
			tr += "<tr>";
				tr += "<td colspan='6' style='text-align: right;'><b>Totales:</b></td>";
				tr += "<td><b>"+data.totalBase+"</b></td>";
				tr += "<td><b>"+data.totalImpuestos+"</b></td>";
				tr += "<td><b>"+data.totalTotal+"</b></td>";
				tr += "<td><b>"+data.totalSaldo+"</b></td>";
				tr += "<td colspan='2'></td>";
			tr += "</tr>";
			
		 
		}else {
			tr += "<tr>";
				tr += "<td colspan='10' ><p><b>No contiene facturaciones</b></p></td>";
			tr += "</tr>";
		}
		
		$(".tableEstadoGeneralAgenteFacturacion tbody").append(tr);
	});

	
}

function getCertificaciones(){
	var url = '/dashboard/estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente';
	var data = 'proveedorId='+$('#proveedor_id').val();
	
	$.post(url, data, function(data){
		var tr = "";
		if(data.results && data.results.length > 0) {
			$(".tableEstadoGeneralAgente tbody").empty();
			$.each(data.results, function(idx,ret) {
				tr += "<tr class='"+ret.classEstado+"'>";
					tr += "<td>"+ret.referencia+"</td>";
					tr += "<td>"+ret.fecha+"</td>";
					tr += "<td>"+ret.expediente+"</td>";
					tr += "<td>"+ret.periodo+"</td>";
					tr += "<td>"+ret.profe+"</td>";
					tr += "<td>"+ret.base+"</td>";
					tr += "<td>"+ret.descuento+"</td>";
					tr += "<td>"+ret.total+"</td>";
					tr += "<td><div class='tip-top' title='"+ret.estadoSignificado+"'>"+ret.estado+"</div></td>";
					
					tr += "<td>" ;
							tr += "<a href='#' class='detalleCertificacionModal' data-url='/compras/certificacion/modalDetalleCertificacion?id="+ret.id+"'>" ;
							tr += "<i class='glyphicon glyphicon-tasks'></i></a>" ;
					tr += "</td>";
				tr += "</tr>";
			});
			
			tr += "<tr>";
				tr += "<td colspan='5' style='text-align: right;'><b>Totales:</b></td>";
				tr += "<td><b>"+data.base+"</b></td>";
				tr += "<td><b>"+data.descuento+"</b></td>";
				tr += "<td><b>"+data.total+"</b></td>";
				tr += "<td colspan='2'></td>";
			tr += "</tr>";
			
		} else {
			tr += "<tr>";
				tr += "<td colspan='10' ><p><b>No contiene certificaciones</b></p></td>";
			tr += "</tr>";
		}
		
		$(".tableEstadoGeneralAgente tbody").append(tr);
	});
}
