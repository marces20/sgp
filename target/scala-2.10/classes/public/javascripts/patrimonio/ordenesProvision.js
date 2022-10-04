$( function() {
	
	$('#searchProveedor, #searchExpediente,#searchDeposito').modalSearch();
	$("#numero").numeric_input();
	$('#menuProductosSolicitados, #menuProductosRecepcionados,#menuAjusteOrdenCompra,#menuRecepciones, #contenedorProductosRecepcionados, #menuCertificaciones, #menuAnulados').click( function(){
		var url = $(this).attr('data-href');
		var contenedor = $(this).attr('href');

		$.get(url, function(data){
			$(contenedor).html(data);
		});
		
	});
	
	
	
	$('#menuProductosSolicitados').click();
	
	$('#reporteGeneralOp').click( function() { //abrir modal para mostrar mensaje informe rentas
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
	
	$('#reporteListaLineasRemitos').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Lineas Remitos",
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
	
	$('.reporteOrdenProvision').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		dialogo.dialog({
			title: "Reporte Orden de Provision",
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
				$.post(url, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	function getCheckLineasAnulacionesSeleccionados(){
		return $("input[name='check_linea_anulacion[]']").serialize();
	}
	
	$('.reporteNotaCierre').click( function() { 
		var data = getCheckLineasAnulacionesSeleccionados();
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		dialogo.dialog({
			title: "Report Nota Cierre",
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
				$.post(url,data, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$('#reporteAnulados').click( function() { 
		var data = getCheckLineasAnulacionesSeleccionados();
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		dialogo.dialog({
			title: "Report Nota Cierre",
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
				$.post(url,data, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$('#accionAnularProductosPedientes').click( function() { //abrir modal para pasar en PreCurso
		var url = $(this).attr("data-url");
		dialogoPasarEnCurso = crearDialogoGeneral(url);
		dialogoPasarEnCurso.dialog({
									title: "Anular Productos Pendientes",
									close: function(event, ui ){$('#menuAnulados').click();},
									height: 350,
									buttons: {
								          Cerrar: function() {
								        	  $( this ).dialog( "destroy" );
								        	  $('#menuAnulados').click();
								          }
								    }
									});
	});
	
	function getCheckLineasAjusteOrdenSeleccionados(){
		return $("input[name='check_linea_ajuste_orden[]']").serialize();
	}
	
	$('#accionCrearActasDeAjustes').click( function() { //abrir modal para pasar en PreCurso
		 
		var data = getCheckLineasAjusteOrdenSeleccionados();
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		if(data === ""){
			alert ("Debe seleccionar un ajuste.");
		} else{
		
			dialogo.dialog({
				title: "Crear Acta Ajustes Diferencia Cotizacion",
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
					$.get(url,data, function(data){
						dialogo.html(data);
					});	
			    }
		    });
		}
	});
	
	$(document).on("submit", '#formCrearActasDeAjustes', function(){
		var form = $(this);
		var url = form.attr('action');
		var lineasChecks = getCheckLineasAjusteOrdenSeleccionados();
		if(lineasChecks === ""){
			alert ("Debe seleccionar un ajuste.");
		} 
		var data = form.serialize()+"&"+lineasChecks;
		var submit = form.find("button[type='submit']");
		
		
		
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				window.location.href = ""; 
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formAnularProductosPediente', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+"&"+getCheckLineaSolicitadoSeleccionados();
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

function getCheckLineaSolicitadoSeleccionados(){
	return $("input[name='check_linea_solicitados[]']").serialize();
}

function getCheckSeleccionados(){
	return $("input[name='check_listado[]']").serialize();
}