$( function(){

	$("#fechax").mask("99/99/9999");

	$('#searchOrganigrama,#searchAgente,#searchProfesion,#searchTipoResidencia,#searchEscalaLaboral,#searchEspecialidad,#searchPeriodo').modalSearch();
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

	$('#exportacionNovedadesLicencias').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>...</div>');

		dialogo.dialog({
			title: "Exportacion Novedades",
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

		    }
	    });

		$.post(url, getCheckSeleccionados(), function(data){
			if(data.url) {
				window.location.href = data.url;
			}
			dialogo.html(data);
		});

	});

	$('#modalDatosRulAgente').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Datos Agente RUL",
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

	$('#modalDatosAgente').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Datos Agente",
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

	$('#modalCertificacionesAgente').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Certificaciones Agente",
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

	$('#replicarProveedor').on('click', function() {

		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Informacion Proveedor"});
	});

	$(document).on("submit", '#formReplicarProveedor', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#agenteId").serialize();
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

	$('.reporteLicencia').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Ficha Licencias",
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
				$.post(url, $("input[name='check_listado_inasistencia[]']").serialize(), function(data){
					dialogo.html(data);
				});
		    }
	    });
	});

	$('.reporteLicenciaMedica').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Ficha Licencias",
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
				$.post(url, $("input[name='check_listado_inasistencia[]']").serialize(), function(data){
					dialogo.html(data);
				});
		    }
	    });
	});


	$('#accionLicenciaPasarBorrador').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Borrador"});
	});

	$(document).on("submit", '#formPasarBorradorLicencia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado_inasistencia[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="95"]:has(input:checked) .estado').text("Borrador");
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="95"]:has(input:checked)').removeClass("cancelada")
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="95"]:has(input:checked)').addClass("borrador")
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="95"]:has(input:checked)').attr("data-estado","93")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionLicenciaPasarPreAprobado').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a PreAprobado"});
	});

	$(document).on("submit", '#formPasarPreAprobadoLicencia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado_inasistencia[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="93"]:has(input:checked) .estado').text("PreAprobado");
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="93"]:has(input:checked)').removeClass("borrador")
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="93"]:has(input:checked)').addClass("licenciaPreaprobado")
				$('#listaDeAgenteAsistenciaLicencias tr[data-estado="93"]:has(input:checked)').attr("data-estado","96")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionLicenciaPasarAprobado').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Aprobado"});
	});

	$(document).on("submit", '#formPasarAprobadoLicencia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado_inasistencia[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked) .estado').text("Aprobado");
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').removeClass("borrador")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').removeClass("licenciaPreaprobado")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').addClass("autorizado")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').attr("data-estado","94")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionLicenciaPasarCancelado').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Cancelado"});
	});

	$(document).on("submit", '#formPasarCanceladoLicencia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado_inasistencia[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked) .estado').text("Cancelado");
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').removeClass("borrador")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').removeClass("autorizado")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').addClass("cancelada")
				$('#listaDeAgenteAsistenciaLicencias tr:has(input:checked)').attr("data-estado","95")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	/*************************************************************************/
	$('#accionPasarCargado').click( function() { //abrir modal para pasar a cargado
		var url = $(this).attr("data-url");
		dialogoPasarCargado = crearDialogoGeneral(url);
		dialogoPasarCargado.dialog({title: "Pasar a Cargado"});
	});

	$(document).on("submit", '#formPasarCargado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgente tr[data-estado="48"]:has(input:checked) .estado').text("Cargado");
				$('#listaDeAgente tr[data-estado="48"]:has(input:checked)').removeClass("borrador")
				$('#listaDeAgente tr[data-estado="48"]:has(input:checked)').attr("data-estado","45")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarPreaprobado').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarPreaprobado = crearDialogoGeneral(url);
		dialogoPasarPreaprobado.dialog({title: "Pasar a Preaprobado"});
	});

	$(document).on("submit", '#formPasarPreaprobado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgente tr[data-estado="45"]:has(input:checked) .estado').text("Preaprobado");
				$('#listaDeAgente tr[data-estado="45"]:has(input:checked)').attr("data-estado","51")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarAprobado').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Aprobado"});
	});

	$(document).on("submit", '#formPasarAprobado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgente tr[data-estado="51"]:has(input:checked) .estado').text("Aprobado");
				$('#listaDeAgente tr[data-estado="51"]:has(input:checked)').addClass("autorizado")
				$('#listaDeAgente tr[data-estado="51"]:has(input:checked)').attr("data-estado","46")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarBorrador').click( function() {
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
				$('#listaDeAgente tr[data-estado="47"]:has(input:checked) .estado').text("Borrador");
				$('#listaDeAgente tr[data-estado="47"]:has(input:checked)').removeClass("cancelada")
				$('#listaDeAgente tr[data-estado="47"]:has(input:checked)').addClass("borrador")
				$('#listaDeAgente tr[data-estado="47"]:has(input:checked)').attr("data-estado","48")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarCancelado').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarCancelado = crearDialogoGeneral(url);
		dialogoPasarCancelado.dialog({title: "Pasar a Cancelado"});
	});

	$(document).on("submit", '#formPasarCancelado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaDeAgente tr:has(input:checked) .estado').text("Cancelado");
				$('#listaDeAgente tr:has(input:checked)').removeClass("borrador")
				$('#listaDeAgente tr:has(input:checked)').removeClass("autorizado")
				$('#listaDeAgente tr:has(input:checked)').addClass("cancelada")
				$('#listaDeAgente tr:has(input:checked)').attr("data-estado","47")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});
});
function getCheckSeleccionados(){
	return $("input[name='check_listado[]']").serialize();
}