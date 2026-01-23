$( function(){

	$('#buscarAgente,#buscarServicio,#searchAgente,#searchPeriodo,#searchOrganigrama').modalSearch();

	$('#filtrosEstados button').click( function() {
		var checkbox = $(this).find(':checkbox');
		checkbox.is(':checked') ? checkbox.removeAttr('checked') : checkbox.prop('checked', true);


		$('#filtrosEstados button:not(:has(:checkbox:checked))').removeClass('activeFiltro');
		$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

		$(this).closest('form').submit();
	});

	$('#filtrosEstados button:has(:checkbox:checked)').addClass('activeFiltro');

});
