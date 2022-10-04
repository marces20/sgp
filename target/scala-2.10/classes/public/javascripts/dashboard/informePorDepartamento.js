var div;
var data;
var options;
var chart;
var table;
var geoView;
var form;
google.load("visualization", "1", {packages:["corechart", "table"]});

google.setOnLoadCallback(function(){
	form = $('#formSearchLiquidacionesPorPuesto');
	drawChart(form.serialize())
});

//Columnas del JSON
var definicionColumnas = {
	cols: [
	       {label: 'Departamento', type: 'string'},
	       {label: 'Total', type: 'number', p:{style: 'width: 100px'}},
	       {label: 'IdDepto', type: 'number'},
	       {label: 'Total de agentes', type: 'number'},
       ]};

function drawChart(datos) {
	div = $('#chart-por-departamento');

    options = {
    		  width: 700,
    		  height: 440,
    		  sliceVisibilityThreshold:0,
    		  legend:{position: 'center', width:'500px'},
    };

    //Para el gráfico
    chart = new google.visualization.PieChart(document.getElementById('chart-por-departamento'));

    google.visualization.events.addListener(chart, 'select', function() {
        var selectedItem = chart.getSelection()[0];
        if (selectedItem) {
        	var id = tableChart.getValue(selectedItem.row, 2);
        	var nombre = tableChart.getValue(selectedItem.row, 0);
        	chart.draw(tableChart, null);
        	draw(id, nombre);
        } else {
        	
        }
    });

    draw($('#organigrama_id').val(), '');	    
}

function draw(id, departamento) {
    if(departamento == '') {
    	departamento = $('#departamento').val();
    }
    
	$.get(div.attr('data-href'), 'id='+id+'&departamento_nombre='+departamento+'&periodo_id='+$('#periodo_id').val(), function(result){
		var tbody = $('#listaInforme tbody');
		tbody.empty();
		superior = "";
	    if(result.superior > 0) {
	    	superior = result.superior;
	    	nombreSuperior = result.nombreSuperior;
		    $('#organigrama_id').val(superior);
		    $('#departamento').val(nombreSuperior);
	    }

	    tableChart = new google.visualization.DataTable(definicionColumnas);
	    tableChart.addRows(result.result);
		
		var view = new google.visualization.DataView(tableChart);
		view.setColumns([0,1,2]);
		
		chart.draw(view, options);

		$.each(result.result, function(k, v){
			tbody.append("<tr data-depto=\""+v[2]+"\" class=\"pointer\">" +
							"<td>"+v[0]+"</td>" +
							"<td>"+v[3].cantidadEmpleados+"</td>" +
							"<td>"+v[1].f+"</td>" +
							"<td>"+v[3].totalRetenciones+"</td>" +
							"<td>"+v[3].totalSinAporte+"</td>" +
							"<td>"+v[3].totalConAporte+"</td>" +
							"<td>"+v[3].totalPatronales+"</td>" +
							"<td>"+v[3].totalLiquidacion+"</td>" +
						"</tr>");
			$('.icon-ordenar').remove();
			$('.ordenColumna').each( function() {
				var celda = $(this);
				celda.append('<i class="icon-ordenar glyphicon glyphicon-sort pull-right"></i>');
				celda.css('cursor', 'pointer');
	
			});
		});
		
		
		
		var tbodyAgentes = $('#listaAgentes tbody');
		var url = $('#listaInforme').attr('data-href');
		$('#listaInforme tbody tr').on('click', function() {
			var periodo = $('#periodo_id').val();
			var depto = $(this).attr("data-depto");
			tbodyAgentes.html("Cargando...");
			$.get(url + "?periodo_id="+periodo+"&id="+depto, function(data) {	
				tbodyAgentes.empty();
				
				$.each(data.result, function(i, item){
					tbodyAgentes.append("<tr data-id=\""+item.id+"\" class=\"pointer\">" +
							"<td>"+item.agente+"</td>" +
							"<td>"+item.nombre+"</td>" +
						 "</tr> " 
					);
				});

			});
			
		});

	});


}



$( function() {
	$('#listaAgentes tbody').on('click', ' tr', function () {
		window.location = $('#listaAgentes').attr('data-url-estado') + "?puesto_id=" + $(this).attr('data-id');
		return false;
	});
	
	
	$('.ordenColumna').each( function() {
		var celda = $(this);
		celda.append('<i class="icon-ordenar glyphicon glyphicon-sort pull-right"></i>');
		celda.css('cursor', 'pointer')

	});
	
	$('#listaInforme').on('click', '.ordenColumna', function(){
	    var table = $(this).parents('table').eq(0);
	    table.find('.icon-ordenar').remove();
	    var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
	    this.asc = !this.asc;

	    if (!this.asc){
	    	rows = rows.reverse();
	    	$(this).append('<i class="icon-ordenar glyphicon glyphicon-sort-by-alphabet-alt pull-right"></i>');
	    } else {
	    	$(this).append('<i class="icon-ordenar glyphicon glyphicon glyphicon-sort-by-alphabet pull-right"></i>');
	    }
	    for (var i = 0; i < rows.length; i++){table.append(rows[i])}
	});
	
	function comparer(index) {
	    return function(a, b) {
	        var valA = getCellValue(a, index), valB = getCellValue(b, index)
	        valA = valA.replace(/\$|\.|\,/g, ''); valB = valB.replace(/\$|\.|\,/g, '');
	        return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.localeCompare(valB)
	    }
	}
	function getCellValue(row, index){ return $(row).children('td').eq(index).html() }
	

	
	
	$('#nivelSuperior').click( function() {
		draw(superior, nombreSuperior);
		return false;
	});
	
	var options = {
			script:"/suggestOrganigrama/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) { 
										$("#departamento").next().val(obj.id); 
									 }
		};
	var as_json = new bsn.AutoSuggest('departamento', options);

});