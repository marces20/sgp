$( function(){
	$('#searchOrganigrama').modalSearch();
});		

$(document).on("click", '#liquidacionesPorProfesionReporte', function(){
	 
	if($("#periodo_id").val().length == 0){
		alert("Debe seleccionar un Periodo");
	}else if($("#profesion_id").val().length == 0){
		alert("Debe seleccionar una Profesion");
	}else{
		window.location="/dashboard/liquidacionesPorProfesionReporte?profesion_id="+$("#profesion_id").val()+"&periodo_id="+$("#periodo_id").val();
	}
	
	
});

$(document).on("click", '#liquidacionesPorEscalaReporte', function(){
	 
	if($("#periodo_id").val().length == 0){
		alert("Debe seleccionar un Periodo");
	}else if($("#escala_laboral_id").val().length == 0){
		alert("Debe seleccionar una Escala");
	}else{
		window.location="/dashboard/liquidacionesPorEscalaReporte?escala_laboral_id="+$("#escala_laboral_id").val()+"&periodo_id="+$("#periodo_id").val();
	}
	
	
});

$(document).on("click", '#liquidacionesPorOrganigramaReporte', function(){
	 
	if($("#periodo_id").val().length == 0){
		alert("Debe seleccionar un Periodo");
	}else if($("#organigrama_id").val().length == 0){
		alert("Debe seleccionar un Servicio");
	}else{
		window.location="/dashboard/liquidacionesPorOrganigramaReporte?organigrama_id="+$("#organigrama_id").val()+"&periodo_id="+$("#periodo_id").val();
	}
	
	
});

$(document).on("click", '#liquidacionesPorAgrupadoOrganigramaReporte', function(){
	 
	if($("#periodo_id").val().length == 0){
		alert("Debe seleccionar un Periodo");
	}else{
		window.location="/dashboard/liquidacionesPorAgrupadoOrganigramaReporte?periodo_id="+$("#periodo_id").val();
	}
	
	
});

$(document).on("click", '.getDetalleLiquidacionClasificacion', function(){
	 
	var url = $(this).attr("data-url");
	var dialogo = $('<div></div>');

	dialogo.dialog({
		title: "Detalles",
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
			$.post(url,  function(data){
				dialogo.html(data);
			});	
	    }
    });
});