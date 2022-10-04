$( function() {

	
	$('#searchProveedorActa,#searchOrdenProvision, #searchExpedienteActa,#searchPeriodo, #searchDepositoActa').modalSearch();
		
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');	
		
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
	
	$('#accionCerrarCircuitoPase').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoExpedienteMovimiento = crearDialogoGeneral(url);
		dialogoExpedienteMovimiento.dialog({
											title: "Cerrar Circuito",
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
	
	$(document).on("submit", '#formCierreCircuito', function(){
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
	
	
	$(document).on("click", '.aceptarPase', function(){
		var url = $(this).attr("data-url"); 
		var id = $(this).attr("id").replace('aceptar-', ''); 
		
		$('#rechazar-'+id).hide();
		$('#aceptar-'+id).hide();
		$('.loading-'+id).show();
		
		$.post(url,  function(data){
			if(data.success) {
				$('#aceptar-'+id).parent('td').parent('tr').remove()
			} else {
				$('#rechazar-'+id).show()
				$('#aceptar-'+id).show();
			}
		});
		
		return false;
	});
	
	$(document).on('click', '.rechazarPase', function(){
		var url = $(this).attr("data-url"); 
		var id = $(this).attr("id").replace('rechazar-', ''); 
		
		$('#rechazar-'+id).hide();
		$('#aceptar-'+id).hide();
		$('.loading-'+id).show();
		
		$.post(url,  function(data){
			if(data.success) {
				$('#rechazar-'+id).parent('td').parent('tr').remove()
			} else {
				$('#rechazar-'+id).show()
				$('#aceptar-'+id).show();
			}
		});
		
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
	
	
						 
	$('#reporteGeneralActa').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte General",
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
	
	$('#reporteLineasActas').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Lineas",
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
	
	$(document).on("submit", '#formGuardarActaRecepcion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#listaRecepciones input[name='check_listado[]']").serialize();
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

    	var data = $("#listaRecepciones input[name='check_listado[]']").serialize();
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
		var data = form.serialize()+'&'+$("#listaRecepciones input[name='check_listado[]']").serialize();
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
	
	$('#reporteListadoInventariable').click( function() {  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Listado Inventariables"});
	});
	
	$(document).on("submit", '#formListadoInventariable', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	
});

function getCheckSeleccionados(){
	return $("input[name='check_listado[]']").serialize();
}