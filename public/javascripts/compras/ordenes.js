$( function(){
	$("#desde, #hasta").mask("99/99/9999");
	$("#numero_orden_provision, #monto_adelanto").numeric_input();
	$('#numero_presupuesto').mask("99999999");
	$('#searchProducto,#searchServicio,#searchPaciente,#searchProveedor,#searchPeriodo,#searchSolicitud, #searchExpediente, #searchDeposito, #searchResponsable').modalSearch();

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

	$('#editarCuentaAnalitica').click( function(){modalEditarCuentaAnalitica()});

	$('.modalOrdenMail').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Envio Orden Provision Por Mail",
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
				$.get(url,  function(data){
					dialogo.html(data);
				});
		    }
	    });
	});


	$('#reporteControlFacturas').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Control Facturas",
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

	$('#accionOrdenCuadroAdjudicacion').click( function() { //abrir modal para mostrar mensaje genera orden adjudicacion
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Generación de órden según cuadro de sugerencia",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: {
		          Cerrar: function() {
		            $( this ).dialog( "destroy" );
		            window.location.href = '';
		          }
		    },
	    	close: function(event, ui ){
	    		$(this).dialog( "destroy" );
	    	},
		    open: function( event, ui ) {
				$.post(url, getCheckSeleccionados(), function(data){
					dialogo.html(data);
				});
		    },
	    	close: function(event, ui) { window.location.href = '' }
	    });
	});

	$('#accionModificarNumeroFactura').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoGeneral(url);
		dialogo.dialog({title: "Modificar Numero de Factura",height: 400,width:850});
	});

	$(document).on("submit", '#formModificarNumeroFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();

		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$("#inputNumeroFactura").html($("#numero_factura").val());
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionEditarMontoAdelanto').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoEditarMontoAdelanto = crearDialogoGeneral(url);
		dialogoEditarMontoAdelanto.dialog({title: "Editar Monto Adelanto"});
	});

	$(document).on("submit", '#formEditarMontoAdelanto', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.get(url, data, function(data){
			if(data.success) {
				window.location.href = "";
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionCrearDispo').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoEditarMontoAdelanto = crearDialogoGeneral(url);
		dialogoEditarMontoAdelanto.dialog({title: "Crear Dispo"});
	});

	$(document).on("submit", '#formCrearDispo', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();

		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.get(url, data, function(data){
			if(data.success) {
				window.location.href = data.url;
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionEditarRubro').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoEditarRubro = crearDialogoGeneral(url);
		dialogoEditarRubro.dialog({title: "Editar Rubro"});
	});


	$(document).on("submit", '#formEditarRubro', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.get(url, data, function(data){
			if(data.success) {
				window.location.href = "";
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionEditarRubroMasivo').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoEditarRubro = crearDialogoGeneral(url);
		dialogoEditarRubro.dialog({title: "Editar Rubro"});
	});

	$(document).on("submit", '#formEditarRubroMasivo', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
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

	$('#accionEditarCotDolar').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoEditarCotDolar = crearDialogoGeneral(url);
		dialogoEditarCotDolar.dialog({title: "Editar Cotizacion Dolar"});
	});

	$(document).on("submit", '#formEditarCotDolar', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.get(url, data, function(data){
			if(data.success) {
				window.location.href = "";
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionEditarFechaProvision').click( function() {
		var url = $(this).attr("data-url");
		dialogoEditarFechaProvision = crearDialogoGeneral(url);
		dialogoEditarFechaProvision.dialog({title: "Editar Fecha Provision"});
	});

	$(document).on("submit", '#formEditarFechaProvision', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.get(url, data, function(data){
			if(data.success) {
				window.location.href = "";
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});



	$('#accionDuplicarMasivo').click( function() { //abrir modal para duplicar
		var url = $(this).attr("data-url");
		dialogoDuplicarMasivo = crearDialogoGeneral(url);
		dialogoDuplicarMasivo.dialog({title: "Duplicar Certificacion"});
	});

	$('#combinarOrdenesCompra').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Combinando órdenes seleccionadas...</div>');

		dialogo.dialog({
			title: "Combinar órdenes de compra",
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


	$('#cuandroComparativoPrecios').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Creando cuadro comparativo de precios...</div>');

		dialogo.dialog({
			title: "Cuadro comparativo de precios",
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

	$('#controlDolar').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>...</div>');

		dialogo.dialog({
			title: "Control Dolar",
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

	$('.controlProfe').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>...</div>');

		dialogo.dialog({
			title: "Pacientes PROFE",
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

	$('#exportacionDatosConLineas').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>...</div>');

		dialogo.dialog({
			title: "Exportacion Datos",
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

	$('#exportacionDatos').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>...</div>');

		dialogo.dialog({
			title: "Exportacion Datos",
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

	$('#cuadroSugerenciaAdjudicación').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div>Creando cuadro sugerido de precios...</div>');

		dialogo.dialog({
			title: "Cuadro sugerencia de adjudicación",
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

	function getCheckSeleccionados(){
		return $("input[name='check_listado[]']").serialize();
	}

	$('#reporteCertificacionPaciente').click( function() {

		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Certificacion Pacientes",
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

	$('#reporteImputacionDefinitiva').click( function() {
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Reporte Imputacion definitiva",
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

	$(document).on("click", '.actualizarMailProveedorOrden', function(){
		var url = $(this).attr("data-url");
		var div = $("#div-actualizar-mail-proveedor");
		var data = '&'+$(this).closest("tr").find("input[name='ordenId']").serialize()+'&'+$(this).closest("tr").find("input[name='email']").serialize()+'&'+$(this).closest("tr").find("input[name='id_direccion']").serialize();

		if(validar_email($(this).closest("tr").find("input[name='email']").val())){

			$.post(url, data, function(data){
				if(data.success) {
					$("#div-actualizar-mail-proveedor").replaceWith(data.html);
				}
				if(data.error) {
					$("#div-actualizar-mail-proveedor").replaceWith(data.html);
				}

			});
		}else{
			alert("Email Inválido.")
		}
	});

	$(document).on("click", '.enviarMailOrden', function(){
		var url = $(this).attr("data-url");
		var div = $("#div-actualizar-mail-proveedor");
		var data = '&'+$(this).closest("tr").find("input[name='ordenId']").serialize()+'&'+$(this).closest("tr").find("input[name='email']").serialize()+'&'+$(this).closest("tr").find("input[name='id_direccion']").serialize();

		if(validar_email($(this).closest("tr").find("input[name='email']").val())){

			$.post(url, data, function(data){
				if(data.success) {
					$("#div-actualizar-mail-proveedor").replaceWith(data.html);
				}
				if(data.error) {
					$("#div-actualizar-mail-proveedor").replaceWith(data.html);
				}

			});
		}else{
			alert("Email Inválido.")
		}
	});

	$('#accionPasarAuditado').click( function() { //abrir modal para pasar a Aprobado
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Auditado"});
	});

	$(document).on("submit", '#formPasarAuditado', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {

				$('#listaFacturas tr[data-estado="33"]:has(input:checked) .estado').text("Aprobado");
				$('#listaFacturas tr[data-estado="33"]:has(input:checked)').addClass("autorizado")
				$('#listaFacturas tr[data-estado="33"]:has(input:checked)').attr("data-estado","19")
				form.replaceWith(data.html);

			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

});

function validar_email( email )
{
    var regex = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;



    return regex.test(email) ? true : false;
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
	          Cerrar: function() {
	            $( this ).dialog( "destroy" );
	          }
	    	},
    	close: function(event, ui ){
    		$(this).dialog( "destroy" );
    	}
      });
    return false;
}
