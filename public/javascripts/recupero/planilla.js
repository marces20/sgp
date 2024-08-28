$( function () {

	$('#searchExpediente,#searchDeposito,#searchDeposito').modalSearch();
	$("#numero").numeric_input();
	$('#searchPlanilla').modalSearch();

	$('#reporteDesdePlanilla').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Reporte Planilla",
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
				$.post(url,   function(data){
					dialogo.html(data);
				});
		    }
	      });

	});

	$('#reporteDesdePlanillaPagos').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Reporte Planilla",
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
				$.post(url,   function(data){
					dialogo.html(data);
				});
		    }
	      });

	});


});
