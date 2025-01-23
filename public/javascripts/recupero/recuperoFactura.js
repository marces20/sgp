$( function () {
	$('#searchCliente,#searchPlanilla,#searchDeposito,#searchPeriodo,#searchUsuario').modalSearch();
	$("#numero_factura").mask("99999999");
	$('#searchPacienteCarga').click( function() {
		var url = $(this).attr("data-url");
		dialogoSearchPacienteCarga = crearDialogoGeneral(url);
		dialogoSearchPacienteCarga.dialog({title: "Cargar Paciente",height:400});
	});

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');


	var options = {
			script:"/suggestCliente/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) {
										$("#cliente").next().val(obj.id);
									 }
		};
	var as_json = new bsn.AutoSuggest('cliente', options);

	$('.abrirModal').on('click', function() {

		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Informe"});
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

	$('#reportePlanilla').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Reporte Planilla Diaria"});
	});


	$('#reporteRecuperoFacturaExcel').click( function() { //abrir modal para mostrar mensaje informe rentas
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

	$('#imprimirReciboNuevo').click( function() { //abrir modal para mostrar mensaje informe rentas

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Recibo",
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
				$.get(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});
		    }
	    });
	});

	$('.notaDebito').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Notas",
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

	$('.notaCredito').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Notas",
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

	$('.imprimirFacturaAfip').click( function() { //abrir modal para mostrar mensaje informe rentas

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Factura Afip",
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
				$.get(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});
		    }
	    });
	});

	$('.imprimirLibreDeuda').click( function() { //abrir modal para mostrar mensaje informe rentas

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Libre Deuda",
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
				$.get(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});
		    }
	    });
	});

	function getCheckSeleccionados(){
		return $("input[name='check_listado[]']").serialize();
	}
});




$(document).on("submit", '#formPlanilla', function(){
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



$(document).on("submit", '#formCargaClienteDesdeModal', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	var numeroOp = form.find("#orden_pago").val();

	var nombre = form.find("#nombre").val();
	var cuit = form.find("#cuit").val();
	var dni = form.find("#dni").val();
	var id_paciente_rismi = form.find("#id_paciente_rismi").val();
	var referencia = form.find("#referencia").val();

	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {

			$("#cliente_id").val(data.idCliente);
			$("#cliente_nombre").val(data.nombre);

			if(data.profeCliente){
				$("#profeCliente").html("PROFE")
			}else{
				$("#profeCliente").html("")
			}

			dialogoSearchPacienteCarga.dialog( "destroy" );
			form.replaceWith(data.html);
		} else {
			if(data.error) {
				form.replaceWith(data.html);
			}else{
				form.replaceWith(data);
			}

		}
	});

	return false;
});