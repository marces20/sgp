$( function(){

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');	
	
	$('#accionPasarAprobado').click( function() { //abrir modal para pasar a Aprobado
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Aprobado"});
	});
	
	$('#accionPasarAOtraLiquidacion').click( function() { //abrir modal para pasar a Aprobado
		var url = $(this).attr("data-url");
		dialogoPasarAOtraLiquidacion = crearDialogoGeneral(url);
		dialogoPasarAOtraLiquidacion.dialog({title: "Pasar a otra Liquidacion"});
	});
	
	$('#accionPasarPreAprobado').click( function() { //abrir modal para pasar a PreAprobado
		var url = $(this).attr("data-url");
		dialogoPasarAprobado = crearDialogoGeneral(url);
		dialogoPasarAprobado.dialog({title: "Pasar a Preaprobado"});
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
	
   $('#reporteReciboSueldo').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
	
		dialogo.dialog({
			title: "Recibos de Sueldos",
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
   
   $('.reciboSueldoPorPuesto').click( function() { 
		
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Recibos de Sueldos",
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
   
   $('.reciboSueldoPorPuestoMail').click( function() { 
		
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Recibos de Sueldos Por Mail",
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
	
   $(document).on("submit", '#formEnviarReciboPorMail', function(){
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
   
   $(document).on("submit", '#formPasarAOtraLiquidacion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var numeroLiq = form.find("#liquidacion_mes_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaLiquidacionPuestos tr:has(input:checked) .numero_liquidacion').text(numeroLiq);
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

function validar_email( email ) 
{
    var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    return regex.test(email) ? true : false;
}

$(document).on("click", '#actualizarMail', function() { 
	
	var url = $(this).attr("data-url");
	var form = $("#formEnviarReciboPorMail");
	var data = form.serialize();
	var email = $("#email").val();
	
	/*if(validar_email(email)){*/
	
		$.post(url, data, function(data){
			if(data.success) {
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
	/*}else{
		alert("HA INGRESADO UN MAIL INCORRECTO.");
	}*/
	return false;
});
 




$(document).on("submit", '#formPasarBorradorLiquidacionPuestos', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaLiquidacionPuestos tr[data-estado="54"]:has(input:checked) .estado').text("Borrador");
			$('#listaLiquidacionPuestos tr[data-estado="54"]:has(input:checked)').removeClass("cancelada")
			$('#listaLiquidacionPuestos tr[data-estado="54"]:has(input:checked)').addClass("borrador")
			$('#listaLiquidacionPuestos tr[data-estado="54"]:has(input:checked)').attr("data-estado","52")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarPreaprobadoLiquidacionPuestos', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaLiquidacionPuestos tr[data-estado="52"]:has(input:checked) .estado').text("Preaprobado");
			$('#listaLiquidacionPuestos tr[data-estado="52"]:has(input:checked)').removeClass("borrador");
			$('#listaLiquidacionPuestos tr[data-estado="52"]:has(input:checked)').attr("data-estado","59")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarAprobadoLiquidacionPuestos', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaLiquidacionPuestos tr[data-estado="59"]:has(input:checked) .estado').text("Aprobado");
			$('#listaLiquidacionPuestos tr[data-estado="59"]:has(input:checked)').addClass("autorizado")
			$('#listaLiquidacionPuestos tr[data-estado="59"]:has(input:checked)').attr("data-estado","53")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarCanceladoLiquidacionPuestos', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaLiquidacionPuestos tr:has(input:checked) .estado').text("Cancelada");
			$('#listaLiquidacionPuestos tr:has(input:checked)').addClass("cancelada");
			$('#listaLiquidacionPuestos tr:has(input:checked)').removeClass("borrador");
			$('#listaLiquidacionPuestos tr:has(input:checked)').removeClass("autorizado")
			$('#listaLiquidacionPuestos tr:has(input:checked)').attr("data-estado","52");
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});



