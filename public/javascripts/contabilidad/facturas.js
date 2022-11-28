$( function(){
	$("#fecha_op_desde, #fecha_op_hasta,#fecha_factura_desde, #fecha_factura_hasta,#fecha_aprobacion_desde, #fecha_aprobacion_hasta").mask("99/99/9999");
	$('#nfform').mask("a-9999-99999999");
	$('.searchModal').modalSearch();
	
	$('.preview').popover({
	    'trigger':'hover',
	    'html':true,
	    'content':function(){
	        return data('data-content');
	    }
	});
	
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
	
	
	/*
	 * Seleccion de check en la tabla
	 */
	$('#checkAll').change( function(){
		var table = $(this).closest('table');
		table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
		$(this).trigger("cambio.lista.seleccion");
	});
	
	function getCheckFacturaSeleccionados(){
		return $("input[name='check_listado[]']").serialize();
	}
	
	$('#importarListaComisiones').click( function() { 
		
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Importar Comisiones",
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
	
	$('#accionSolicitud322').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Solicitud 322",
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
				$.post(url, getCheckFacturaSeleccionados(), function(data){
					dialogo.html(data);
				});	
		    }
	      });
		
	});
	
	$('#accionCerrarFondoPermanente').click( function() { //abrir modal CerrarFondoPermanente
		var url = $(this).attr("data-url");
		dialogoCerrarFondoPermanente = crearDialogoGeneral(url);
		dialogoCerrarFondoPermanente.dialog({title: "Cerrar Fondo Permanente"});
	});
	
	$(document).on("submit", '#formCerrarFondoPermanente', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				/*form.replaceWith(data.html);*/
				location.reload();
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#cargar349').click( function() { //abrir modal para pasar en PreCurso
		var url = $(this).attr("data-url");
		dialogoCargar349 = crearDialogoGeneral(url);
		dialogoCargar349.dialog({title: "Cargar 349"});
	});
	
	$(document).on("submit", '#formCargar349', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				/*form.replaceWith(data.html);*/
				location.reload();
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#accionPasarEnPreCurso').click( function() { //abrir modal para pasar en PreCurso
		var url = $(this).attr("data-url");
		dialogoPasarEnCurso = crearDialogoGeneral(url);
		dialogoPasarEnCurso.dialog({title: "Pasar a En PreCurso"});
	});
	$('#accionPasarEnCurso').click( function() { //abrir modal para pasar en Curso
		var url = $(this).attr("data-url");
		dialogoPasarEnCurso = crearDialogoGeneral(url);
		dialogoPasarEnCurso.dialog({title: "Pasar a En Curso"});
	});
	$('#accionPasarAprobado').click( function() { //abrir modal para pasar a Aprobado
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Aprobado"});
	});
	
	$('#accionPasarBorrador').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Borrador"});
	});
	
	$('#accionPasarCancelado').click( function() { //abrir modal para pasar a cancelado
		var url = $(this).attr("data-url");
		dialogoPasarCancelado = crearDialogoGeneral(url);
		dialogoPasarCancelado.dialog({title: "Pasar a Cancelado"});
	});
	$('#accionPasarPreAprobado').click( function() { //abrir modal para pasar a PreAprobado
		var url = $(this).attr("data-url");
		dialogoPasarPreAprobado = crearDialogoGeneral(url);
		dialogoPasarPreAprobado.dialog({title: "Pasar a Preaprobado"});
	});
	
	$('#accionCargarOrdenPago').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoCargarOrdenPago = crearDialogoGeneral(url);
		dialogoCargarOrdenPago.dialog({title: "Cargar Orden de Pago"});
	});
	
	$('#accionCargarFechaOrdenPago').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoCargarFechaOrdenPago = crearDialogoGeneral(url);
		dialogoCargarFechaOrdenPago.dialog({title: "Cargar Fecha Orden de Pago"});
	});
	
	$('#accionCargarNumeroFacturaParcial').click( function() {  
		var url = $(this).attr("data-url");
		dialogoCargarNumeroFacturaParcial = crearDialogoGeneral(url);
		dialogoCargarNumeroFacturaParcial.dialog({title: "Cargar N° Factura"});
	});
	
	$('#accionCargarFecha322').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoCargarFechaOrdenPago = crearDialogoGeneral(url);
		dialogoCargarFechaOrdenPago.dialog({title: "Cargar Fecha vencimiento 322"});
	});
	
	$('#accionMarcadoresMasivos').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoCargarFechaOrdenPago = crearDialogoGeneral(url);
		dialogoCargarFechaOrdenPago.dialog({title: "Cargar Marcadores"});
	});
	
	$('#rechazarFactura').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoRechazarFactura = crearDialogoGeneral(url);
		dialogoRechazarFactura.dialog({title: "Rechazar Factura",height: 450,});
	});
	
	$(document).on("submit", '#formRechazarFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("#idFactura").serialize();
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
	
	$(document).on("submit", '#formPasarEnPreCursoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr[data-estado="18"]:has(input:checked) .estado').text("Precurso");
				$('#listaFacturas tr[data-estado="18"]:has(input:checked)').attr("data-estado","60")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formPasarEnCursoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr[data-estado="60"]:has(input:checked) .estado').text("En Curso");
				$('#listaFacturas tr[data-estado="60"]:has(input:checked)').removeClass("borrador");
				$('#listaFacturas tr[data-estado="60"]:has(input:checked)').attr("data-estado","17")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formPasarPreAprobadoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr[data-estado="17"]:has(input:checked) .estado').text("Preaprobado");
				$('#listaFacturas tr[data-estado="17"]:has(input:checked) span.iconRechazado').remove();
				$('#listaFacturas tr[data-estado="17"]:has(input:checked)').removeClass('bg-rechazado');
				$('#listaFacturas tr[data-estado="17"]:has(input:checked)').attr("data-estado","33");
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formPasarAprobadoFactura', function(){
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

	$(document).on("submit", '#formPasarBorradorFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr[data-estado="21"]:has(input:checked) .estado').text("Borrador");
				$('#listaFacturas tr[data-estado="21"]:has(input:checked)').removeClass("cancelada")
				$('#listaFacturas tr[data-estado="21"]:has(input:checked)').addClass("borrador")
				$('#listaFacturas tr[data-estado="21"]:has(input:checked)').attr("data-estado","18")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});

	$(document).on("submit", '#formPasarCanceladoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr:has(input:checked) .estado').text("Cancelada");
				$('#listaFacturas tr:has(input:checked)').addClass("cancelada");
				$('#listaFacturas tr:has(input:checked)').removeClass("borrador");
				$('#listaFacturas tr:has(input:checked)').removeClass("autorizado")
				$('#listaFacturas tr:has(input:checked)').attr("data-estado","21");
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formCargarOrdenPagoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroOp = form.find("#orden_pago_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr:has(input:checked) .opg').text(numeroOp);
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formMarcadoresMasivos', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var debe_dgr = form.find("#debe_dgr").val();
		var debe_dgr_aguinaldo = form.find("#debe_dgr_aguinaldo").val();
		var debe_afip = form.find("#debe_afip").val();
		var debe_judicial = form.find("#debe_judicial").val();
		
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				/*$('#listaFacturas tr:has(input:checked) .opg').text(numeroOp);*/
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formCargarNumeroFacturaParcial', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var nfactura = form.find("#nfactura_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaFacturas tr:has(input:checked) .nfactura').text(nfactura);
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	
	$(document).on("submit", '#formCargarFechaOrdenPagoFactura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroOp = form.find("#fecha_orden_pago_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				/*$('#listaFacturas tr:has(input:checked) .opg').text(numeroOp);*/
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$(document).on("submit", '#formCargarFecha322Factura', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroOp = form.find("#fecha_322_modal").val();
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
	
	$('#accionModificarNumeroFactura').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
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
	
	/*
	 * Reportes
	 */
	$('#OPCservicios').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Reporte OPC servicios",
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
				$.post(url, getCheckFacturaSeleccionados(), function(data){
					dialogo.html(data);
				});	
		    }
	      });
		
	});
	
	$('#reporteOrdenDePago').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Reporte Orden de Pago",
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
				$.post(url, getCheckFacturaSeleccionados(), function(data){
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
	
	$('#reporteLineasFacturas').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Lineas Facturas",
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
	
	$('#reporteFacturasCargadas').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Facturas Cargadas",
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
	
	$('#reporteComprobanteRetencionMunicipal').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Retencion Municipal",
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
	
	$('#reporteViatico').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Viaticos",
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
	
	$('#reporteComisiones').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Comisiones",
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
	
	$('#reporteFondo').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Fondo Permanente",
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
	
	$('#reporteComprobanteRetencionGcia').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Retencion",
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
	
	$('#reporteComprobanteRetencionIva').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Retencion",
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
	
	$('#reporteControlFacturasAFIP').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Control Facturas AFIP",
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
	
	$('#reporteComprobanteRetencionSellos').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Retencion Sellos",
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
	
	$('#reporteRendicionSellos').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Rendicion Sellos",
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
	

	$('#reporteRendicioniibb').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante IIBB",
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
	
	$('#reporteRendicioniibb370').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante IIBB 3,70",
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
	
	$('#reporteRendicionSeguridad').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Seguridad",
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
	
	$('#reporteRendicionLimpieza').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Limpieza",
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
	
	$('#reporteRendicionReggral').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Comprobante Reggral",
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
	
	
	function getCheckSeleccionados(){
		return $("input[name='check_listado[]']").serialize();
	}
	
	$('#reporteInformeSellos').click( function() {  
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Informe Sellos",height: 350});
	});
	
	$(document).on("submit", '#formInformeSellos', function(){
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
	
	function crearDialogo(url){
		var dialogo = $('<div></div>');
		return dialogo.dialog({
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
				$.get(url, function(data){
					dialogo.html(data);
				});	
		    }
	      });
	}
	
});	
