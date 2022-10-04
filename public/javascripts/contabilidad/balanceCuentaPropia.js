$( function(){
	/*
	 * Búsqueda por filtros
	 */
	
	$('.searchModal').modalSearch();
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

	
	$('#accionAgregarMovimientoBalanceCuentaPropia').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoMovimiento = crearDialogoGeneral(url);
		dialogoMovimiento.dialog({
											title: "Agregar Movimiento Cuenta Propia",
											height: 370,
											width: 900,
											close: function( event, ui ) {location.reload();},
											buttons:{ "Cerrar": function() { $(this).dialog("close"); location.reload();} },
											});
		
	});
	
	$(document).on("click", '#listaPagosBalance', function(){
		 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Lista Pagos",
	    	resizable: true,
			autoOpen: true,
			modal: true,
			height: 350,
			width:900,
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
	
	$(document).on("submit", '#formAgregarMovimientoBalanceCuentaPropia', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		/*var numeroOp = form.find("#orden_pago").val();*/
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
				/*form.replaceWith(data.html);*/
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#accionTransferenciaEntreCuentasPropias').click( function() { //abrir modal para rechazar factura
		var url = $(this).attr("data-url");
		dialogoMovimiento = crearDialogoGeneral(url);
		dialogoMovimiento.dialog({
											title: "Trasnferencia entre Cuentas Propias",
											height: 370,
											width: 900,
											close: function( event, ui ) {location.reload();},
											buttons:{ "Cerrar": function() { $(this).dialog("close"); location.reload();} },
											});
		
	});
	
	$(document).on("submit", '#formTransferenciaEntreCuentasPropias', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		/*var numeroOp = form.find("#orden_pago").val();*/
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				location.reload();
				/*form.replaceWith(data.html);*/
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
});