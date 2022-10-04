$( function() {


	$("#desde, #hasta").mask("99/99/9999");
	$('#searchProveedor, #searchResponsable,#searchDeposito, #searchExpediente').modalSearch();
	
	var resultados = $('#resultadoRecepciones');
	
	$('#contenedorRecepciones').on('submit', '#buscadorRecepciones', function() {
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data){
			$('#resultadoRecepciones').replaceWith(data);
		});
		
		return false;
	});
	
	$('#cargarRemitosMasivos').click( function() { 
		
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Cargar Remitos Masivos",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 500,
			width:750,
	        buttons: {
		          Cerrar: function() {
		        	  window.location.reload();  
		            $( this ).dialog( "destroy" );
		          }
		    },
	    	close: function(event, ui ){
	    		window.location.reload();
	    		$(this).dialog( "destroy" );
	    	},
		    open: function( event, ui ) {
				$.post(url, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	
	$('#reporteLineasRecepciones').click( function() { //abrir modal para mostrar mensaje informe rentas
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
	
	$('#reporteDatosRecepciones').click( function() { //abrir modal para mostrar mensaje informe rentas
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
	
	
	/*
	 * Para la seleccion de la lista de recepciones
	 */
	$('.check_all').on('change', function(){
		var c = $(this).prop("checked");
		var target = $(this).attr('data-check');
		if(c) $(target).prop( "checked", true );
		else $(target).prop( "checked", false );
	});
	
	
	$('#contenedorRecepciones').on('click', '#crearRecepcion', function () {
		var url = $(this).attr('href');
		var modal = $('<div></div>').dialog({
			resizable: false,
		    title: "Crear recepción",
		    height: 200,
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

	
	$(document).on('click', '.delete-confirm', function(){
		link = $(this).attr("href");
		var retorno = false;
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar el registro?<p></div>');
	    dialogo.dialog({
	        resizable: false,
	        height:180,
	        width: 400,
	        modal: true,
	        title: "Eliminar registro",
	        buttons: {
	          Eliminar: function() {
	            $.get(link, function(data) {
	            	if(data.success) {
		            	$('#menuRecepiones').click();
		            	dialogo.dialog("close");
	            	} else {
	            		dialogo.html(data);
	            	}
	            })
	          },
	          Cancelar: function( event, ui ) {
	            $( this ).dialog( "close" );
	          }
	        },
		    close: function(){
		    	$( this ).dialog( "destroy" );
		    }
	      });
	    return false;
	});	
	
	
});