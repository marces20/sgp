$( function(){

	$("#desde, #hasta,#desde_baja, #hasta_baja").mask("99/99/9999");

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');


	$('#accionCrearNovedadesBasica').click( function() { //abrir modal para crear novedades basicas
		var url = $(this).attr("data-url");
		dialogoCrearNoveades = crearDialogoGeneral(url);
		dialogoCrearNoveades.dialog({title: "Crear Noveades Basicas"});
	});

	$(document).on("submit", '#formCrearNovedadesBasicas', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
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

	$('#preliquidarPuestoFinal').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoPreliquidarPuesto = crearDialogoGeneral(url);
		dialogoPreliquidarPuesto.dialog({title: "Preliquidar Puesto",height: 250,});
	});

	$(document).on("submit", '#formPreliquidarPuestoFinal', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#puestoLaboralId").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#preliquidarPuesto').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoPreliquidarPuesto = crearDialogoGeneral(url);
		dialogoPreliquidarPuesto.dialog({title: "Preliquidar Puesto",height: 450,});
	});

	$(document).on("submit", '#formPreliquidarPuesto', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#puestoLaboralId").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});


	/*$(document).on("submit", '#formBuscarDatosGananciasEnArchivos', function(){
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
	});*/

	$('#accionActivar, #accionDesactivar').click( function() {
		var url = $(this).attr("data-url");
		var t = $(this).attr("data-title");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: t,
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


	$('#altasMasivas').click( function() {
		var url = $(this).attr("data-url");
		var t = $(this).attr("data-title");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: t,
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

	$('#altasMasivasNuevo').click( function() {
		var url = $(this).attr("data-url");
		var t = $(this).attr("data-title");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: t,
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

	$('#listadoGeneral').click( function() {
		var url = $(this).attr("data-url");
		var t = $(this).attr("data-title");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: t,
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


	$('#buscarDatosGananciasEnArchivos').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Cargar datos Ganancias",
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
				$.get(url, function(data){
					dialogo.html(data);
				});
		    }
	    });
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

	$('#accionPasarBorrador').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Borrador"});
	});

	$(document).on("submit", '#formPasarBorrador', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {

				$('#listaDePuesto tr[data-estado="109"]:has(input:checked)').removeClass("autorizado")
				$('#listaDePuesto tr[data-estado="109"]:has(input:checked)').addClass("borrador")
				$('#listaDePuesto tr[data-estado="109"]:has(input:checked)').attr("data-estado","55")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarControlado').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Controlado"});
	});

	$(document).on("submit", '#formPasarControlado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {

				$('#listaDePuesto tr[data-estado="55"]:has(input:checked)').removeClass("borrador")
				$('#listaDePuesto tr[data-estado="55"]:has(input:checked)').addClass("autorizado")
				$('#listaDePuesto tr[data-estado="55"]:has(input:checked)').attr("data-estado","109")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	function getCheckSeleccionados(){
		return $("input[name='check_listado[]']").serialize();
	}

	$('#modalDetalle').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Datos Detalles",
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


})