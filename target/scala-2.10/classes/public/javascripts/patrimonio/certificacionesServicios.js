$( function() {

	$('#searchProveedor, #searchExpediente,#searchDeposito').modalSearch();
	
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
	
	$(document).on("submit", '#formGuardarActaRecepcion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#listaCertificaciones input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	
	$('#accionCrearActaRecepcion').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Cargando...</div>');

		dialogo.dialog({
			title: "Crear acta recepción",
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
				$.get(url, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	

	$('#revocarActaRecepcion').click( function() { //Accion paara revocar acta de las recepciones
		var url = $(this).attr("data-url");

    	var data = $("#listaCertificaciones input[name='check_listado[]']").serialize();
		$.post(url,data, function(data){
			if(data.success) {
				location.reload();
			} else {
				alert(data.messagge);
			}
		});	
	});

	
	
	var dialogoAsignarActa;
	$('#accionAsignarActaRecepcion').click( function() { //abrir modal para asignar acta a las recepciones
		
		var url = $(this).attr("data-url");
		dialogoAsignarActa = $('<div>Cargando...</div>');

		dialogoAsignarActa.dialog({
			title: "Asignar acta de recepción",
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
				$.get(url, function(data){
					dialogoAsignarActa.html(data);
				});	
		    }
	    });
	});
	
	
	$(document).on("submit", '#formAsignarActaRecepcion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#listaCertificaciones input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	
});