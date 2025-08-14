$( function(){


	urlGet  = window.location.search.replace("?","");
	$('#formSearchNovedades').on('submit', function() {

		var url = urlListaNovedades + '?'+ $(this).serialize();

		getLista(url);

	});

	$('#buscarAgente,#buscarServicio,#searchAgente,#searchPeriodo').modalSearch();

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.prop('checked', true);


		$('#filtrosEstados button:not(:has(:checkbox:checked))').removeClass('activeFiltro');
		$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

		$(this).closest('form').submit();
	});

	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');



	cal = $('#calendar');
	cal.fullCalendar({
	   header: {
		     left: 'prev,next today',
		      center: 'title',
		      right: 'month,agendaWeek,resourceDay'
	    },
	    lang: 'es',
	    //editable: true,
	    //timeFormat: 'H:mm',
	    //axisFormat: 'H:mm',

	    //eventStartEditable: false,
	    //selectable: true,
	    //selectHelper: true,
	    //editable: true,
		//eventLimit: true, // allow "more" link when too many events
		displayEventTime: false,
		eventClick: function(event){
			crearDialogo(event, urlVerNovedad+'?id=' + event.id, "Detalles de guardia");
		},
		viewRender: function(view,element){

			getLista(urlListaNovedades+'?desde='+moment(view.start).format('DD-MM-YYYY')+'&hasta='+moment(view.end).format('DD-MM-YYYY')+'&'+urlGet);

			$.get(urlGetFeriados+'?desde='+moment(view.start).format('DD-MM-YYYY')+'&hasta='+moment(view.end).format('DD-MM-YYYY')+'&'+urlGet, function(data){
				for (var f in data.feriados){
					cal.find('td.fc-day[data-date='+data.feriados[f]+']').css("background-color","#ffe0e9");
				}
			});

		},
		dayClick: function(date, jsEvent, view) {
			crearDialogo ('', urlCrearNovedad+"?fecha="+date.format("DD/MM/YYYY"), 'Crear Novedad');
			return false;

			  //alert('Clicked on: ' + date.format('DD/MM/YYYY'));
			//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
			//alert('Current view: ' + view.name);

		    // change the day's background color just for fun
		    //$(this).css('background-color', 'red');

		  }


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
		 crearDialogoMasivo ('', urlCrearNovedadMasiva, 'Crear Novedad');
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


	function crearDialogoMasivo (event, url, title) {

		dialogo = $('<div></div>');

		dialogo.dialog({
			title: title,
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 600,
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
						if(resultado.nuevo){
							//$(document).trigger( "carga-novedad", resultado.evento);
							 location.reload();


						}else{
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

	function crearDialogo (event, url, title) {

		dialogo = $('<div></div>');

		dialogo.dialog({
			title: title,
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 600,
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

