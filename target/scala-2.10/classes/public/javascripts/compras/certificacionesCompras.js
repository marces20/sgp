$( function(){
	
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
	
	$('#editarCuentaAnalitica').click( function(){modalEditarCuentaAnalitica()});
	
	$('#searchOrden,#searchProveedor,#searchExpediente,#searchPeriodo,#searchDepartamento').modalSearch();
	
	$('#accionPasarEnCurso').click( function() { //abrir modal para pasar en Curso
		var url = $(this).attr("data-url");
		dialogoPasarEnCurso = crearDialogoGeneral(url);
		dialogoPasarEnCurso.dialog({title: "Pasar a En Curso"});
	});
	$('#accionPasarCertificado').click( function() { //abrir modal para pasar a Certificado
		var url = $(this).attr("data-url");
		dialogoPasarCertificado = crearDialogoGeneral(url);
		dialogoPasarCertificado.dialog({title: "Pasar a Certificado"});
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
	
	$('#accionCargarFechaCertificacion').click( function() {  
		var url = $(this).attr("data-url");
		dialogoCargarFechaCertificacion = crearDialogoGeneral(url);
		dialogoCargarFechaCertificacion.dialog({title: "Cargar Fecha Certificacion"});
	});
	
	
	$(document).on("submit", '#formCargarFecharCertificacion', function(){
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
		var submit = form.find("button[type='submit']");
		var fechaCertificacion = form.find("#fecha_certificacion_modal").val();
		submit.replaceWith(getLoading());
		$.post(url, data, function(data){
			if(data.success) {
				$('#listaCertificaciones tr:has(input:checked) .fechaCertificacion').text(fechaCertificacion);
				
				form.replaceWith(data.html);
			} else {
				form.replaceWith(data);
			}
		});
		
		return false;
	});
	
	$('#reporteCertificacion').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog({
			title: "Informe Certificaciones",
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
				$.post(url, $("input[name='check_listado[]']").serialize(), function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
})

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

$(document).on("submit", '#formPasarEnCursoCertificacion', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaCertificaciones tr[data-estado="79"]:has(input:checked) .estado').text("En Curso");
			$('#listaCertificaciones tr[data-estado="79"]:has(input:checked)').removeClass("borrador");
			$('#listaCertificaciones tr[data-estado="79"]:has(input:checked)').attr("data-estado","80")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarCertificadoCertificacion', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaCertificaciones tr[data-estado="80"]:has(input:checked) .estado').text("Certificado");
			$('#listaCertificaciones tr[data-estado="80"]:has(input:checked)').removeClass("borrador");
			$('#listaCertificaciones tr[data-estado="80"]:has(input:checked)').addClass("autorizado")
			$('#listaCertificaciones tr[data-estado="80"]:has(input:checked)').attr("data-estado","81");
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarBorradorCertificacion', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaCertificaciones tr[data-estado="82"]:has(input:checked) .estado').text("Borrador");
			$('#listaCertificaciones tr[data-estado="82"]:has(input:checked)').removeClass("cancelada")
			$('#listaCertificaciones tr[data-estado="82"]:has(input:checked)').addClass("borrador")
			$('#listaCertificaciones tr[data-estado="82"]:has(input:checked)').attr("data-estado","79")
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

$(document).on("submit", '#formPasarCanceladoCertificacion', function(){
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize()+'&'+$("input[name='check_listado[]']").serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	$.post(url, data, function(data){
		if(data.success) {
			$('#listaCertificaciones tr:has(input:checked) .estado').text("Cancelada");
			$('#listaCertificaciones tr:has(input:checked)').addClass("cancelada");
			$('#listaCertificaciones tr:has(input:checked)').removeClass("borrador");
			$('#listaCertificaciones tr:has(input:checked)').removeClass("autorizado")
			$('#listaCertificaciones tr:has(input:checked)').attr("data-estado","82");
			form.replaceWith(data.html);
		} else {
			form.replaceWith(data);
		}
	});
	
	return false;
});

