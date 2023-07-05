$( function(){
	$('#fecha_conciliacion_desde, #fecha_conciliacion_hasta,#fecha_pago_desde, #fecha_pago_hasta,#fecha_opg_desde,#fecha_opg_hasta,#fecha_entrega_factura_desde,#fecha_entrega_factura_hasta').mask("99/99/9999");
	$('#searchOrdenPago,#searchFactura,#searchCuentaPropia,#searchProveedor, #searchPeriodo, #searchExpediente, #searchPeriodo,#searchCuentaModal').modalSearch();

	/*$('#nfform').mask("a-9999-99999999");*/

	/*
	 * Búsqueda por filtros
	 */
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
		table.find("input[name='id_pago[]']").prop("checked", $(this).prop( "checked" ) );
	});

	function getCheckSeleccionados(){
		return $("input[name='id_pago[]']").serialize();
	}

	/*
	 * Acciones
	 */
	var alertSuccess = $('#alert-success');
	var alertDanger = $('#alert-danger');

	//Acciones para modificar fecha
	var dialogoFecha = null;
	$('#accionModificarFecha').click( function() { //abrir modal para modificar fecha
		var url = $(this).attr("data-url");
		dialogoFecha = crearDialogo(url);
		dialogoFecha.dialog({title: "Editar fecha de los pagos"});
	});


	$(document).on("submit", '#formModificarFecha', function(){ //cuando se envia el formulario para modificar fecha
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="24"]:has(input:checked) .fecha').text( $('#fechaParaModificar').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para modificar fecha
	var dialogoFechaConciliado = null;
	$('#accionModificarFechaConciliado').click( function() { //abrir modal para modificar fecha
		var url = $(this).attr("data-url");
		dialogoFechaConciliado = crearDialogo(url);
		dialogoFechaConciliado.dialog({title: "Editar fecha conciliacion"});
	});

	$(document).on("submit", '#formModificarFechaConciliado', function(){ //cuando se envia el formulario para modificar fecha
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="23"]:has(input:checked) .fechaConciliado').text( $('#fechaParaModificarConciliado').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para modificar fecha
	var dialogoFechaCancelacion = null;
	$('#accionModificarFechaCancelacion').click( function() { //abrir modal para modificar fecha
		var url = $(this).attr("data-url");
		dialogoFechaCancelacion = crearDialogo(url);
		dialogoFechaCancelacion.dialog({title: "Editar fecha cancelacion"});
	});

	$(document).on("submit", '#formModificarFechaCancelacion', function(){ //cuando se envia el formulario para modificar fecha
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
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

	//Acciones para modificar referencia
	$('#accionCrearRefenciaEmbargos').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Crear Refencia Embargos"});
	});

	$(document).on("submit", '#formCrearRefenciaEmbargos', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){

			if(data.success) {
				$('#listaPagos tr[data-estado="24"]:has(input:checked) .referencia').text( $('#referenciaParaMosidicar').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}

		});

		return false;
	});

	//Acciones para modificar referencia
	$('#accionModificarReferencia').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Editar referencia de los pagos"});
	});

	$(document).on("submit", '#formModificarReferencia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="24"]:has(input:checked) .referencia').text( $('#referenciaParaMosidicar').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para modificar paguese
	$('#accionModificarPaguese').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Editar paguese a de los pagos"});
	});

	$(document).on("submit", '#formModificarPaguese', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
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

	//Acciones para modificar Tipo Pago
	$('#accionModificarTipoPago').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Editar Tipo Pago de los pagos"});
	});

	$(document).on("submit", '#formModificarTipoPago', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				var x = "";
				if($('#tipoPago').val() == "trasnferencia"){
					x="MacroOnline";
				}
				if($('#tipoPago').val() == "transferenciaInterbanking"){
					x="Interbanking";
				}
				if($('#tipoPago').val() == "transferenciaMacroProveedores"){
					x="MacroProveedores";
				}
				if($('#tipoPago').val() == "cheque"){
					x="cheque";
				}

				$('#listaPagos tr[data-estado="24"]:has(input:checked) .tipoPago').text( x );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para modificar Tipo Pago
	$('#accionModificarCuentaPropia').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Editar Cuenta Propia de los pagos"});
	});

	$(document).on("submit", '#formModificarCuentaPropia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				var x = "";
				$('#listaPagos tr[data-estado="24"]:has(input:checked) .cuentaPropia').text( $('#cuenta_propia').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para modificar Numero Cheque
	$('#accionModificarNumeroCheque').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Editar numero de cheque de los pagos"});
	});

	$(document).on("submit", '#formModificarNumeroCheque', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
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

	$('#accionModificarNumeroRecibo').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Modificar Numero de Recibo"});
	});

	$(document).on("submit", '#formModificarNumeroRecibo', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();

		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$("#inputNumeroRecibo").html($("#numero_recibo").val());
				form.replaceWith(data.html);
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});


	//Acciones para pagar proveedores de tipo contratados
	$('#accionPagar').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar a proveedores tipo agentes contratados"});
	});

	$(document).on("submit", '#formPagar', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="24"]:has(input:checked) .referencia').text( $('#referenciaParaMosidicar').val() );
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	//Acciones para pagar cheques
	$('#accionPagarCheque').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar Cheque"});
	});

	$(document).on("submit", '#formPagarCheque', function(){
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

	//Acciones para pagar debitos
	$('#accionPagarDebitos').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar Debitos"});
	});




	$(document).on("submit", '#formPagarDebitos', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
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

	//Acciones para pagar proveedores tipo agentes planta
	$('#accionPagarPlanta').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar a proveedores tipo planta"});
	});

	$(document).on("submit", '#formPagarPlanta', function(){
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

	$('#accionPagarEmbargos').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar a embargos Banco Macro"});
	});

	$('#accionPagarEmbargosExternos').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar a embargos Externos"});
	});

	$('#accionPagarExternosInterbankingProveedores').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar Interbanking Proveedores"});
	});

	$('#accionPagarProveedoresMacrosMaviso').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar Proveedores Macro Masivo"});
	});



	//Acciones para pagar proveedores externos
	$('#accionPagarProveedorExterno').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogoPago(url);
		dialogo.dialog({title: "Pagar a proveedores externos"});
	});

	$(document).on("submit", '#formPagarProveedorExterno', function(){
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


	/*
	 *
	 * Informes
	 *
	 */

	$('#reporteInformeMensualRentas').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe mensual de RENTAS",
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


	function crearDialogoPago(url){
		var dialogo = $('<div></div>');
		return dialogo.dialog({
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
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
	}

	$('#accionPasarConciliado').click( function() { //abrir modal para pasar a conciliado
		var url = $(this).attr("data-url");
		dialogoPasarConciliado = crearDialogoGeneral(url);
		dialogoPasarConciliado.dialog({title: "Pasar a Conciliado"});
	});

	$(document).on("submit", '#formPasarConciliadoPago', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="23"]:has(input:checked) .estado').text("Conciliado");
				$('#listaPagos tr[data-estado="23"]:has(input:checked)').removeClass("autorizado")
				$('#listaPagos tr[data-estado="23"]:has(input:checked)').addClass("pagado")
				$('#listaPagos tr[data-estado="23"]:has(input:checked)').attr("data-estado","25")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarBorrador').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Borrador"});
	});

	$(document).on("submit", '#formPasarBorradorPago', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr[data-estado="26"]:has(input:checked) .estado').text("Borrador");
				$('#listaPagos tr[data-estado="26"]:has(input:checked) .fecha').text("");
				$('#listaPagos tr[data-estado="26"]:has(input:checked) .fechaConciliado').text("");
				$('#listaPagos tr[data-estado="26"]:has(input:checked)').removeClass("cancelada")
				$('#listaPagos tr[data-estado="26"]:has(input:checked)').addClass("borrador")
				$('#listaPagos tr[data-estado="26"]:has(input:checked)').attr("data-estado","24")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});

	$('#accionPasarCancelado').click( function() { //abrir modal para pasar a cancelado
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Cancelado"});
	});

	$(document).on("submit", '#formPasarCanceladoPago', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaPagos tr:has(input:checked) .estado').text("Cancelado");
				$('#listaPagos tr:has(input:checked)').removeClass("borrador")
				$('#listaPagos tr:has(input:checked)').removeClass("pagado")
				$('#listaPagos tr:has(input:checked)').removeClass("autorizado")
				$('#listaPagos tr:has(input:checked)').addClass("cancelada")
				$('#listaPagos tr:has(input:checked)').attr("data-estado","26")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});

		return false;
	});



	$('#reporteInformeLotes').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Lotes",
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

	$('#reporteInformeProfe').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe PROFE",
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

	$('#reporteInformeImpuestoMunicipal').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Impuesto Municipal",
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

	$('#reporteInformeRetDgrIibb331').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion DGR IIBB 331",
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

	$('#reporteInformeRetDgrIibb').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion DGR IIBB",
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

	$('#reporteRetencionDgrSellos').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion DGR SELLOS",
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

	$('.reporteRetencionSeguridad').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion Seguridad",
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

	$('#reporteRetencionGcia4245').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion",
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

	$('#reporteRetencionIva').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Rentencion",
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

	$('#reporteInformeMensualImpuestos').click( function() {
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Informe Mensual Impuestos"});
	});

	$(document).on("submit", '#formInformeMensualImpuestos', function(){
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

});
