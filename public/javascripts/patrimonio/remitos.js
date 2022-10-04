$( function() {
	$('#searchProveedor,#searchDeposito').modalSearch();
	
	
	$('#contenedorRecepciones').on('click', '#listaRecepciones tbody td:not(.notSeleccion)', function(){
		var url = $(this).closest('tr').attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Lista de remitos",
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
	});
	
	
	$(document).on('click', '#crearRemito', function () {
		var url = $(this).attr('href');
		var modal = $('<div></div>').dialog({
			resizable: false,
		    title: "Crear remito",
		    height: 450,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) {
				$.get(url, function(data){
					modal.html(data);
				});
		    },
		    close: function(event, ui ){
		    	modal.dialog('destroy');
			}
		  });
		
		modal.on('submit', function(e){
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$.post(href, data, function(resultado){
				if(resultado.success){
					$('#menuRecepiones').click();
					modal.dialog('close');
				} else {
					modal.html(resultado);
				}
			});
			return false;
		});
		return false;
	});
	
	$('#reporteDatosRemitosGeneral').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte",
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
	
	$('#reporteDatosRemitos').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte",
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
	
	$('#accionCambiarRecepcion').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte",
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
	
	$(document).on("submit", '#formCambiarRecepcion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroRecepcion = form.find("#recepcion_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaRemitos tr:has(input:checked) .recep').text(numeroRecepcion);
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
});