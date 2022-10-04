$( function(){
	

	$('#searchExpediente,#searchOrdenPago,#searchDeposito').modalSearch();
	$("#monto_limite,#monto_inicial").numeric_input();
	
	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.attr('checked', 'checked');
		$(this).closest('form').submit();
	});
	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');
});

