$( function(){
	$(document).on("click", '.trImpuestos', function(){
		var url = $(this).attr("data-url");
		$("#div-detalle-impuestos").html(getLoading());
		$.get(url, function(data){
			if(data.success) {
				$("#div-detalle-impuestos").html(data.html);
			}
		});
		
	});
});	