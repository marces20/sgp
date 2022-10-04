$( function(){
	 
	
	$('.infoProveedor').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Informacion Proveedor"});
	});
	
	$( document ).on( "click", ".detalleCertificacionModal", function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Detalle Certificacion",height:450,position: 'center'});
		return false; 
	});
	
	$( document ).on( "click", ".detalleFacturacionModal", function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Detalle Facturacion",height:450,width:900,position: 'center'});
		return false; 
	});
	
	$( document ).on( "click", ".detallePagoModal", function() {
		var url = $(this).attr("data-url");
		/*var posX = $(this).position().left - $(window).scrollLeft;
        var posY = $(this).position().top -$(window).scrollTop();*/
		var dialogo = crearDialogoGeneral(url);
		dialogo.dialog({title: "Detalle Pago",height:450,position: 'center'});
		return false; 
	});
	
	function crearDialogo(url){
		var dialogo = $('<div></div>');
		return dialogo.dialog({
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 350,
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
	}

});