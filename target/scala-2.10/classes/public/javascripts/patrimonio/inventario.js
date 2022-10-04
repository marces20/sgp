$( function() {

	
	$('#accionModificarPrefijo').click( function() { //abrir modal modificar prefijos
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Cargando...</div>');

		dialogo.dialog({
			title: "Modificar prefijos",
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
	
	
	
	/*
	 * Para la seleccion de la lista de inventario
	 */
	$('.check_all').on('change', function(){
		var c = $(this).prop("checked");
		var target = $(this).attr('data-check');
		if(c) $(target).prop( "checked", true );
		else $(target).prop( "checked", false );
	});
	
	
	
});