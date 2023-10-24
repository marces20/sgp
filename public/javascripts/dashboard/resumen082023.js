$( function(){

	$('.getDetalleProveedor').on("click", function() {
		var title = $(this).attr("data-title");
		var url = "/dashboard/resumenDetalle082023?title="+title;
			$("#contenedorCarga").html('<div class="loading"></div>');
			$.get(url,  function(data){
				$("#contenedorCarga").html(data);
			});

	});


});