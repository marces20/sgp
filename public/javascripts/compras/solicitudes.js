$( function(){
	$("#desde, #hasta").mask("99/99/9999");

	$("#fechaSolicitud, #fechaLimite, #fechaImputacion").mask("99/99/9999");

	$('#searchInstitucionExterna,#searchObraSocial,#searchProducto,#searchResponsable,#searchCuentaAnalitica, #searchPaciente, #searchServicio, #searchExpediente, #searchSolicitante,#searchMedico, #searchDeposito,#searchUser2').modalSearch();

	$('#editarCuentaAnalitica').click( function(){modalEditarCuentaAnalitica()});

	$('#listadoSolicitud').on('click', '.entregado', function(){
		var mensaje = "¿Confirma que desea modificar?";
		if(confirm(mensaje)){
			var url = $(this).data('url');
			$this = $(this);
			$.get(url, function(data){
				if(data.success){
					$this.find("i").toggleClass('text-success glyphicon-plus, text-muted glyphicon-minus');
					$this.closest("tr").find('.textEntregado').toggle('');
				} else {
					alert("No se puedo modificar el registro.");
				}
			});
		}
		return false;
	});



	$('#importarListaProductos').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Importar productos y cantidades",
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

	$('#reporteCuadroSolicitud').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Cuadro Solicitud",
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

	$('#reporteLineasCotizacion,#reporteLineasCotizacionResumido,#reporteInformeFarmaciaPaciente').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Lineas Cotizacion",
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

	$('#reporteImputacionPreventiva').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Imputacion preventiva",
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

	$('#reporteInformeFarmacia').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe",
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

	$('#reporteInformeFarmaciaPorUsuario').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe",
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



	$('#searchPacienteCarga').click( function() {
		var url = $(this).attr("data-url");
		dialogoSearchPacienteCarga = crearDialogoGeneral(url);
		dialogoSearchPacienteCarga.dialog({title: "Cargar Paciente",height:400});
	});

	$('#modificarPaciente').click( function() {
		var url = $(this).attr("data-url");
		dialogoModificarPacienteDesdeModal = crearDialogoGeneral(url);
		dialogoModificarPacienteDesdeModal.dialog({title: "Modificar Paciente",height:400});
	});

	$('#asignarUsuario').click( function() {

		var url = $(this).attr("data-url");
		dialogoAsignarUsuario = crearDialogoGeneral(url);
		dialogoAsignarUsuario.dialog({title: "Asignar Usuario",height:400});
	});

	$('#accionPasarAprobado').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Aprobado Por Presupuesto"});
	});

	$('#accionPasarAutorizado').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarAutorizado = crearDialogoGeneral(url);
		dialogoPasarAutorizado.dialog({title: "Pasar a Autorizado"});
	});

});

$(document).on("submit", '#formPasarAprobadoPorPresupuesto', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('.listadoSolicitud tr[data-estado="1"]:has(input:checked) .estado').text("Aprobado por Presupuesto");
			$('.listadoSolicitud tr[data-estado="1"]:has(input:checked)').removeClass("borrador")
			$('.listadoSolicitud tr[data-estado="1"]:has(input:checked)').attr("data-estado","4")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});

	return false;
});

$(document).on("submit", '#formPasarAutorizado', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('.listadoSolicitud tr[data-estado="4"]:has(input:checked) .estado').text("Autorizado");
			$('.listadoSolicitud tr[data-estado="4"]:has(input:checked)').addClass("autorizado")
			$('.listadoSolicitud tr[data-estado="4"]:has(input:checked)').attr("data-estado","5")
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

			$("#paciente_id").val(data.idCliente);
			$("#paciente").val(data.nombre);

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

$(document).on("submit", '#formModificarPacienteDesdeModal', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize();
	var submit = form.find("button[type='submit']");


	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {

			$("#pacienteVer").html($("#paciente").val());

			dialogoModificarPacienteDesdeModal.dialog( "destroy" );
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});

	return false;
});

$(document).on("submit", '#formAsignarUsuario', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize();
	var submit = form.find("button[type='submit']");

	submit.replaceWith(getLoading());

	if($("#id_solicitud_modal").val()){

		$.post(url, data, function(data){
			if(data.success) {

				/*$("#pacienteVer").html($("#paciente").val());*/

				dialogoAsignarUsuario.dialog( "destroy" );
				window.location.reload();
			} else {
				form.replaceWith(data);
			}
		});

	}else{

		$.post(url, data+"&"+getCheckSeleccionados(), function(data){
			if(data.success) {
				dialogoAsignarUsuario.dialog( "destroy" );
				window.location.reload();
			} else {
				form.replaceWith(data);
			}
		});

	}

	return false;
});

$(document).on("submit", '#formInformeFarmacia', function(){
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

$(document).on("submit", '#formInformeFarmaciaPorUsuario', function(){
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

function getCheckSeleccionados(){
	return $("input[name='check_listado[]']").serialize();
}

function modalEditarCuentaAnalitica(){

	link = $('#editarCuentaAnalitica').attr("data-url");

	var retorno = false;

	var contenido = $('<div id="modalEditarCuentaAnalitica"></div>');
	$.get(link, function(data){
		contenido.html(data);
	});
    var dialogo = contenido.dialog();

    dialogo.dialog({
        title: "Editar Cuentas Analiticas",
    	resizable: false,
		autoOpen: false,
		modal: true,
		height: 250,
		width:750,
        buttons: {
	          Cancelar: function() {
	            $( this ).dialog( "destroy" );
	          }
	    	},
    	close: function(event, ui ){
    		$(this).dialog( "destroy" );
    	}
      });
    return false;
}


