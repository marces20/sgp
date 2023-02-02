$( function(){
	
	$('#searchProveedor,#searchExpediente,#searchOp').modalSearch();
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
	
	
	$('#accionPasarBorrador').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Borrador"});
	});
	
	$(document).on("submit", '#formPasarBorradorOpc', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr[data-estado="77"]:has(input:checked) .estado').text("Borrador");
				$('#listaOpc tr[data-estado="77"]:has(input:checked)').removeClass("cancelada")
				$('#listaOpc tr[data-estado="77"]:has(input:checked)').addClass("borrador")
				$('#listaOpc tr[data-estado="77"]:has(input:checked)').attr("data-estado","73")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#reporteLineasCircuitoOp').click( function() { //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Lineas ops",
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
		
	$('#accionPasarContabilidad').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Contabilidad"});
	});
	
	$(document).on("submit", '#formPasarContabilidadOpc', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr[data-estado="73"]:has(input:checked) .estado').text("Contabilidad");
				$('#listaOpc tr[data-estado="73"]:has(input:checked)').removeClass("borrador")
				$('#listaOpc tr[data-estado="73"]:has(input:checked)').addClass("autorizado")
				$('#listaOpc tr[data-estado="73"]:has(input:checked)').attr("data-estado","74")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#accionPasarRendiciones').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Rendiciones"});
	});
	
	$(document).on("submit", '#formPasarRendicionesOpc', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr[data-estado="74"]:has(input:checked) .estado').text("Rendiciones");
				$('#listaOpc tr[data-estado="74"]:has(input:checked)').attr("data-estado","75")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
		
	$('#accionPasarRendido').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Rendido"});
	});
	
	$(document).on("submit", '#formPasarRendidoOpc', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr[data-estado="75"]:has(input:checked) .estado').text("Rendido");
				$('#listaOpc tr[data-estado="75"]:has(input:checked)').attr("data-estado","76")
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#accionPasarCancelado').click( function() { //abrir modal para pasar a borrador
		var url = $(this).attr("data-url");
		dialogoPasarBorrador = crearDialogoGeneral(url);
		dialogoPasarBorrador.dialog({title: "Pasar a Cancelado"});
	});
	
	$(document).on("submit", '#formPasarCanceladoOpc', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr:has(input:checked) .estado').text("Cancelada");
				$('#listaOpc tr:has(input:checked)').addClass("cancelada");
				$('#listaOpc tr:has(input:checked)').removeClass("borrador");
				$('#listaOpc tr:has(input:checked)').removeClass("autorizado")
				$('#listaOpc tr:has(input:checked)').attr("data-estado","77");
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#accionCargarExpedienteFisico').click( function() { //abrir modal para cargar Orden de pago
		var url = $(this).attr("data-url");
		dialogoCargarExpedienteFisico = crearDialogoGeneral(url);
		dialogoCargarExpedienteFisico.dialog({title: "Cargar Expediente Fisico"});
	});
	
	$(document).on("submit", '#formCargarExpedienteFisico', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='id_pago[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroOp = form.find("#expedienteFisico").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaOpc tr:has(input:checked) .expFisico').text(numeroOp);
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
});	