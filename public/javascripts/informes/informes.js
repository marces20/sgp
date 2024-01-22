$( function(){
	$('.infoObligaciones').on('click', function() {

		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Informacion Obligaciones"});
	});

	function crearDialogo(url){
		var dialogo = $('<div></div>');
		return dialogo.dialog({
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 600,
			width:800,
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