$( function(){
	
	
	
	$('#accionPasarOtroServicio').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoExpedienteMovimiento = crearDialogoGeneral(url);
		dialogoExpedienteMovimiento.dialog({
											title: "Pasar a Otro servicio",
											height: 350,
											close: function( event, ui ) {location.reload();},
											buttons:{ "Cerrar": function() { $(this).dialog("close"); location.reload();} },
											});
		
	});
	
	$('#accionAsignarMiServicio').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoExpedienteMovimiento = crearDialogoGeneral(url);
		dialogoExpedienteMovimiento.dialog({
											title: "Asignar a mi servicio",
											height: 350,
											close: function( event, ui ) {location.reload();},
											buttons:{ "Cerrar": function() { $(this).dialog("close"); location.reload();} },
											});
		
	});
	
	$(document).on("submit", '#formAsignarAMiServicioMasivo', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		/*var numeroOp = form.find("#orden_pago").val();*/
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				form.replaceWith(data.html);
				/*dialogoExpedienteMovimiento.dialog('close');
				location.reload();*/
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formPasarOtroServicio', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		/*var numeroOp = form.find("#orden_pago").val();*/
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				form.replaceWith(data.html);
				/*dialogoExpedienteMovimiento.dialog('close');
				location.reload();*/
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	
	$(document).on('click', '#cancelarPase', function(){
		var url = $(this).attr('data-url');
		var mensaje = "¿Confirma que desea cancelar el pase?";
		if(confirm(mensaje)){
			$this = $(this);
			$.get(url, function(data){
				if(data.success){
					location.reload();
				} else {
					alert(data.error);
				}
			});
		}
		return false;
	});
	
	$(document).on('click', '#asignarMiServicio', function(){
		var url = $(this).attr('data-url');
		var mensaje = "¿Confirma Asignarlo a su servicio?";
		if(confirm(mensaje)){
			$this = $(this);
			$.get(url, function(data){
				if(data.success){
					location.reload();
				} else {
					alert(data.error);
				}
			});
		}
		return false;
	});
	
	$(document).on('click', '#cancelarPaseLista', function(){
		var url = $(this).attr('data-url');
		var mensaje = "¿Confirma que desea cancelar el pase?";
		if(confirm(mensaje)){
			$this = $(this);
			$.post(url,  getCheckSeleccionados(),function(data){
				if(data.success){
					location.reload();
				} else {
					alert(data.error);
				}
			});
		}
		return false;
	});
	
	
	
	
	$('#reporteTapaExpedienteMasivo').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Tapa Expediente",
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
				$.post(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$('#reporteListadoExpediente').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Listado Expediente",
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
				$.post(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$('#reportePaseExpedienteListado').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Pase Expedientes",
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
				$.post(url, getCheckSeleccionados(),  function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
		
	$('.reportePaseExpedienteListadoCodigo').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Pase Expedientes",
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
		
		return false;
	});
	
	$('#reportePaseExpediente').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Pase Expedientes",
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

});

function getCheckSeleccionados(){
	return $("input[name='check_listado[]']").serialize();
}