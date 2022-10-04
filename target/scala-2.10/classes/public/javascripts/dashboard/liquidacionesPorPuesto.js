
$( function(){
	
	 
	
	$(document).on("click", '#reporteReciboSueldo', function(){
		 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Recibos de Sueldos",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: {
		          Cerrar: function() {
		            $( this ).dialog( "destroy" );
		          }
		    },
	    	close: function(event, ui ){
	    		$(this).dialog( "destroy" );
	    	},
		    open: function( event, ui ) {
				$.post(url,  function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$(document).on("click", '.trUltimasLiquidaciones td:not(.notSeleccion)', function(){
		var url = $(this).parent().attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Detalle liquidacion",
	    	resizable: true,
			autoOpen: true,
			modal: true,
			height: 450,
			width:750,
	        buttons: {
		          Cerrar: function() {
		            $( this ).dialog( "destroy" );
		          }
		    },
	    	close: function(event, ui ){
	    		$(this).dialog( "destroy" );
	    	},
		    open: function( event, ui ) {
		    	$.get(url,function(data){
					dialogo.html(data);
				});	
		    }
	      });
	});
	
	getLiquidacionesPorPuesto();
	liquidacionesPorPeriodo();
	liquidacionesPorPeriodoPorClasificacion();
	
	
	var options = {
			script:"/contabilidad/suggestPeriodo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) { 
										$("#periodo_inicio_id").val(obj.id); 
										$("#periodo_inicio_id").change();
									 }
		};
	var as_json = new bsn.AutoSuggest('periodo_inicio', options);
	
	var options = {
			script:"/contabilidad/suggestPeriodo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) { 
										$("#periodo_hasta_id").val(obj.id); 
										$("#periodo_hasta_id").change();
									 }
		};
});	
google.load('visualization', '1', {packages: ['corechart', 'line']});

function liquidacionesPorPeriodoPorClasificacion() {
	
	if($('#puesto_laboral_id').val() != null){
		var data = 'puesto_laboral_id='+$('#puesto_laboral_id').val();
		data += '&periodo_inicio_id='+$('#periodo_inicio_id').val();
		data += '&periodo_fin_id='+$('#periodo_fin_id').val();
		
		var url = '/dashboard/getLiquidacionesPorPuestoPorPeriodoPorClasificacion';
		var row = [];
		$.get(url, data, function(data){
			if(data.success) {
				
				var c = 0;
	 			$.each(data.results, function(idx,valor) {
	 				var datos = [];
	 				datos[0] = valor['periodo'];
	 				datos[1] = valor['haber'];
	 				datos[2] = valor['guardias'];
	 				datos[3] = valor['produccion'];
	 				datos[4] = valor['adicionales'];
	 				row[c] = datos;
	 				c++;
	 			});
			
	 			var data = new google.visualization.DataTable();
			    data.addColumn('string', 'X');
			    data.addColumn('number', 'Haber Contrato');
			    data.addColumn('number', 'Guardias');
			    data.addColumn('number', 'Produccion');
			    data.addColumn('number', 'Adicionales');
			
			    data.addRows(row);
			
			    var options = {
			      hAxis: {
			        title: 'Periodo' 
			      },
			      pointSize: 6,
			      vAxis: {format:'$###,###,###.00'},
			      legend: { position: 'top', maxLines: 3,fontSize: 18,bold: true },
			    };
			
			    var chart = new google.visualization.LineChart(document.getElementById('div-liquidacion-periodo-clasificacion'));
			
			    chart.draw(data, options);
	
			}else{
				alert("No se han podido obtener los datos.")
			}
		});
	 }	
  }


function liquidacionesPorPeriodo() {
	
	if($('#puesto_laboral_id').val() != null){
		var data = 'puesto_laboral_id='+$('#puesto_laboral_id').val();
		data += '&periodo_inicio_id='+$('#periodo_inicio_id').val();
		data += '&periodo_fin_id='+$('#periodo_fin_id').val();
		var url = '/dashboard/getLiquidacionesPorPuestoPorPeriodo';
		var row = [];
		$.get(url, data, function(data){
			if(data.success) {
				
				var c = 0;
	 			$.each(data.results, function(idx,valor) {
	 				var datos = [];
	 				datos[0] = valor['periodo'];
	 				datos[1] = valor['valor'];
	 				row[c] = datos;
	 				c++;
	 			});
			
	 			var data = new google.visualization.DataTable();
			    data.addColumn('string', 'X');
			    data.addColumn('number', 'Total a cobrar');
			
			    data.addRows(row);
			
			    var options = {
			      hAxis: {
			        title: 'Periodo' 
			      },
			      pointSize: 6,
			      vAxis: {format:'$###,###,###.00'},
			      legend: { position: 'top', maxLines: 3,fontSize: 18,bold: true },
			    };
			
			    var chart = new google.visualization.LineChart(document.getElementById('div-liquidacion-periodo'));
			
			    chart.draw(data, options);
	
			}else{
				alert("No se han podido obtener los datos.")
			}
		});
	 }	
  }



function getLiquidacionesPorPuesto(){
	
	if($('#puesto_laboral_id').val() != null){
		var data = 'puesto_laboral_id='+$('#puesto_laboral_id').val();
		data += '&periodo_inicio_id='+$('#periodo_inicio_id').val();
		data += '&periodo_fin_id='+$('#periodo_fin_id').val();
		var url = '/dashboard/getLiquidacionesPorPuesto';
		
		
		$("#div-ultimas-liquidaciones").html(getLoading ());
		$("#div-clasificacion-concepto").html(getLoading ());
		$("#div-datos-puestos").html(getLoading ());
		$.get(url, data, function(data){
			if(data.success) {
				$("#div-ultimas-liquidaciones").html(data.html);
				$("#div-clasificacion-concepto").html(data.html2);
				$("#div-datos-puestos").html(data.htmlDatosPuesto);
				
			}else{
				alert("No se han podido obtener los datos.")
			}
		});
		
		
	}
}



