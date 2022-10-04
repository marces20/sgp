$( function(){
	
	$('#formSearchNovedades').on('submit', function() {
		var url = $(this).attr('action') + '?'+ $(this).serialize();
		getLista(url);
		return false;
	});
	
	$('#buscarAgente').modalSearch();
	$('#buscarServicio').modalSearch();

	
	cal = $('#calendar');
	cal.fullCalendar({
	   header: {
		     left: 'prev,next today',
		      center: 'title',
		      right: 'month,agendaWeek,resourceDay'
	    },
	    lang: 'es',
	    editable: true,
	    timeFormat: 'H:mm',
	    axisFormat: 'H:mm',
	    eventStartEditable: false,
		selectable: true,
		selectHelper: true,
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		eventClick: function(event){
			crearDialogo(event, urlVerNovedad+'?id=' + event.id, "Detalles de guardia");            
		},
		viewRender: function(view,element){
			
			getLista(urlListaNovedades+'?desde='+moment(view.start).format('DD-MM-YYYY')+'&hasta='+moment(view.end).format('DD-MM-YYYY'));

			$.get(urlGetFeriados+'?desde='+moment(view.start).format('DD-MM-YYYY')+'&hasta='+moment(view.end).format('DD-MM-YYYY'), function(data){
				for (var f in data.feriados){
					cal.find('td.fc-day[data-date='+data.feriados[f]+']').css("background-color","#f2f2f2");
				}
			});

		},

	});

	
	function getLista(url) {
		
		$.get(url, function(data){
			cal.fullCalendar( 'removeEvents' );
			events = data;
			cal.fullCalendar('addEventSource', data, true); // stick? = true
			cal.fullCalendar('unselect');
		});
		
	}
	
	 $(document).on('click', '#btnNuevo', function() {
		 crearDialogo ('', urlCrearNovedad, 'Crear guardia');
		 return false;
	 });

	 $(document).on('click', '#btnModificar', function(){
		 var url = $(this).attr('href');
		 dialogo.dialog('option', 'title', 'Modificar');
		 $.get(url, function(data){
			 dialogo.html(data);
		 });
		 
		 return false;
	 })
	 
	 $(document).on('click', '#btnCancelar', function(){
		 dialogo.dialog("close");
		return false;
	 })

	$(document).on('carga-novedad', function(e, data){
		var eventData;
		
		eventData = {
			title: data.nombre,
			start: data.fecha,
			id: data.id,
			color: data.color
		};
		cal.fullCalendar('renderEvent', eventData, true);
		cal.fullCalendar('unselect');
	}); 
	 
	$(document).on('actualiza-novedad', function(e, event){
		cal.fullCalendar('updateEvent', event);
	}); 
	
	
	function crearDialogo (event, url, title) {
		
		dialogo = $('<div></div>');

		dialogo.dialog({
			title: title,
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 500,
			width:850,
	        buttons: {
		          Cerrar: function() {
		            $( this ).dialog( "destroy" );
		          }
		    },
	    	close: function(event, ui ){
	    		$(this).dialog( "destroy" );
	    	},
		    open: function( event, ui ) {
				$.get(url, function(data){
					dialogo.html(data);
				});	
		    }
	    });
		
		 dialogo.on('submit', function(e){

				var form = $(this).find('form');
				var href = $(e.target).attr('action');
				var data = $(e.target).serialize();
				$.post(href, data, function(resultado){
					if(resultado.success) {
						if(resultado.nuevo)
							$(document).trigger( "carga-novedad", resultado.evento);
						else {
							var data = resultado.evento;
							event.title = data.nombre;
							event.start = data.fecha;
							event.id = data.id;
							event.color = data.color;
							$(document).trigger( "actualiza-novedad", event);
						}
						dialogo.dialog('close');	
					} else {
						form.parent().html(resultado);
					}
				});
				return false;
			});	
		
		
	}
			
});

