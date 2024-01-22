$( function(){
	$('.infoObligaciones').on('click', function() {
		var url = $(this).attr("data-url");
		var dialogo = crearDialogo(url);
		dialogo.dialog({title: "Informacion Obligaciones"});
	});
});