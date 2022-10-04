$( function(){
	
	$('#searchCliente,#searchDeposito,#searchDeposito').modalSearch();
	
	$('#searchPacienteCarga').click( function() {  
		var url = $(this).attr("data-url");
		dialogoSearchPacienteCarga = crearDialogoGeneral(url);
		dialogoSearchPacienteCarga.dialog({title: "Cargar Paciente",height:400});
	});
	
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
	
	
	var options = {
			script:"/suggestCliente/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) { 
										$("#cliente").next().val(obj.id); 
									 }
		};
	var as_json = new bsn.AutoSuggest('cliente', options);
	
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
			 
			$("#cliente_id").val(data.idCliente);
			$("#cliente_nombre").val(data.nombre);
			
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