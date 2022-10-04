$( function(){
	$('.searchModal').modalSearch();
	$('#cot_dolar').numeric_input();
	
	$('#reporteAutorizado,#reporteAutorizadoExcel').click( function() { 
		
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		
		dialogo.dialog({
			title: "Reporte Autorizado",
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
				$.get(url, function(data){
					dialogo.html(data);
				});	
		    }
	    });
	});
	
	$(document).on("submit", '#formCargarLineasAutorizados', function(){  
		
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$("#tablaAutorizados tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		$('#loadingAgregarMonto').removeClass('hide');
		$('#btn-agregarMonto').hide();
		
		$.post(url, data, function(data){
			
			if(data.success) {
				$('#modalAgregarMontos').html();
				$('#modalAgregarMontos').dialog( "destroy" );
				$('#loadingAgregarMonto').addClass('hide');
				$('#btn-agregarMonto').show();
				actualizarDatos ();
				$("#formCargaAutorizados").submit();
				$("#filtroInformeActa").submit();
				
			} else {
				  
				if (typeof data.errorEnMontoTotal != 'undefined'){
					 $("#tablaAutorizados").find("#th_monto_general").addClass("alert alert-danger");
						$("#tablaAutorizados").find("#th_monto_general").find(".pErrores").append(data.errorEnMontoTotal);
				}else if (typeof data.errorGeneral != 'undefined'){
					 alert(data.errorGeneral);
				}else{
					
					$.each(data.errores, function(i,texto){
						$("tr[data-id='"+i+"']").addClass("alert alert-danger");
						$("tr[data-id='"+i+"']").find(".pErrores").append(texto);
					})
				}
				$('#loadingAgregarMonto').addClass('hide');
				$('#btn-agregarMonto').show();
				actualizarDatos ();
			}
		});
		
		return false;
	});
	
	
	$(document).on("submit", '#formCargarLineasAutorizadosActas', function(){  
		
		var form = $(this);
		var url = form.attr('action');
		var data = form.serialize();
		var submit = form.find("button[type='submit']");
		submit.replaceWith(getLoading());
		$("#tablaAutorizadosActas tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		$('#loadingAgregarMontoActa').removeClass('hide');
		$('#btn-agregarMontoActa').hide();
		
		$.post(url, data, function(data){
			
			if(data.success) {
				$('#modalAgregarMontosActas').html();
				$('#modalAgregarMontosActas').dialog( "destroy" );
				$('#loadingAgregarMontoActa').addClass('hide');
				$('#btn-agregarMontoActa').show();
				actualizarDatos ();
				
				$("#filtroInformeActa").submit();
				
			} else {
				  
				if (typeof data.errorEnMontoTotal != 'undefined'){
					 $("#tablaAutorizadosActas").find("#th_monto_general").addClass("alert alert-danger");
						$("#tablaAutorizadosActas").find("#th_monto_general").find(".pErrores").append(data.errorEnMontoTotal);
				}else if (typeof data.errorGeneral != 'undefined'){
					 alert(data.errorGeneral);
				}else{
					$.each(data.errores, function(i,texto){
						$("tr[data-id='"+i+"']").addClass("alert alert-danger");
						$("tr[data-id='"+i+"']").find(".pErrores").append(texto);
					})
				}
				
				$('#loadingAgregarMontoActa').addClass('hide');
				$('#btn-agregarMontoActa').show();
				actualizarDatos ();
			}
		});
		
		return false;
	});
	
	$('.tabCarga').on("click", function() { 
		var url = "/dashboard/autorizado/getListadoDeudas?idAutorizado="+$("#idAutorizado").val();
			$("#contenedorCarga").html('<div class="loading"></div>');
			$.get(url,  function(data){
				$("#contenedorCarga").html(data);
			});	
		
	});
	
	$('.tabCargaActa').on("click", function() { 
		var url = "/dashboard/autorizado/getListadoDeudasActas?idAutorizado="+$("#idAutorizado").val();
			$("#contenedorCargaActa").html('<div class="loading"></div>');
			$.get(url,  function(data){
				$("#contenedorCargaActa").html(data);
			});	
		
	});
	
	$('.tabLineas').on("click", function() { 
		
			var url = "/dashboard/autorizado-linea/index?id="+$("#idAutorizado").val()+"&editable="+$("#formularioCarga").val();
			$("#listaLineaAutorizados").html('<div class="loading"></div>');
			$.get(url, function(data){
				$('#listaLineaAutorizados').parent().html(data);
			})
		
	});
	
	$('.tabResumen').on("click", function() { 
		 
		var url = "/dashboard/autorizado/getResumen?id="+$('#idAutorizado').val();
				
		$("#contenedorResumenDiv").html('<div class="loading"></div>');
		$.get(url, function(data){
			$('#contenedorResumenDiv').html(data);
		})
		 
	});
	
	/*$(document).on('change', '#seleccionarTodos', function(){
		$('#tablaAutorizados .checkFila').prop("checked", $(this).prop( "checked" ) );
		seleccionAutorizado( $('#tablaAutorizados tbody tr') );
		$("#tablaAutorizados tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ();
	});
	
	$(document).on('change', '.checkFila', function(){
		seleccionAutorizado( $(this).closest('tr') );
		$("#tablaAutorizados tr").removeClass("alert alert-danger");
		$(".pErrores").html("");
		calcularTotal ();
	});
	
	$(document).on('focusout', '.monto', function(){
		calcularTotal ();
	});
	*/
	
	
	
	

});

function calcularTotal (trs) {
	var n = 0;
	$(".totales").empty();
	$.each(trs, function( ){
		tr = $(this);
		c = tr.find('.checkFila');
		if(c.prop( "checked" )) {
			tr.find('.monto, .montoTotal').removeAttr('disabled');
			
			if(tr.find('.monto').val().length > 0){
				n = Number(tr.find('.monto').val())+n 
			}else{
				n = Number(tr.find('.montoTotal').val())+n 
			}
		} 
	});
	
	$(".totales").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
}

function seleccionAutorizado (trs) {
	 
	$.each(trs, function( ){
		tr = $(this);
		c = tr.find('.checkFila');
		if(c.prop( "checked" )) {
			tr.find('.monto, .montoTotal').removeAttr('disabled');
		} else {
			tr.find('.monto').val('');
			tr.find('.monto, .montoTotal').attr('disabled', 'disabled');
		}
	});
}

function actualizarDatos () {
	var url = "/dashboard/autorizado/getActualizarDatos?idAutorizado="+$("#idAutorizado").val();
	$("#editarTotalLoading").removeClass('hide');
	$("#editarTotal").hide();
	$.get(url,  function(data){
		if(data.success) {
			$("#editarTotal").html(data.total);
		}else{
			
		}
		$("#editarTotal").show();
		$("#editarTotalLoading").addClass('hide');
	});	
}