$( function() {

	$("#desde, #hasta").mask("99/99/9999");

	$("#cantidad, #importe_tope").numeric_input();
	$("#importe").numeric_input({allowNegative: true});

	$('#searchPuestoLaboral, #searchPeriodoInicio,#searchPeriodoConcepto, #searchPeriodoFin, #searchConcepto,#searchOrganigrama').modalSearch();

	$('#puesto_laboral_id').on('change', function(){
		$(document).trigger("novedad.cambio");
	});


	$(document).on('click', '#eliminarNovedadIndex', function(){

		link = $(this).attr("href");
		var retorno = false;
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar el registro?<p></div>');
	    dialogo.dialog({
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar registro",
	        buttons: {
	          Eliminar: function() {
	        	  $.get(link, function(data) {
	        		  if(data.success) {
	        			  window.location.href = "";
	        		  } else {
	        			  alert(data.message);
	        		  }
	        	  });
	        	  $( this ).dialog( "close" );
	          },
	          Cancelar: function( event, ui ) {
	            $( this ).dialog( "close" );
	          }
	        },
		    close: function(){
		    	$( this ).dialog( "destroy" );
		    }
	      });
	    return false;
	})



	//Cuando cambia de inicio, coloco el mismo en periodo de fin... solo si esta vacio
	$('#periodo_inicio_id').on('change', function(){
		var id = $(this).val();
		var nombre = $('#periodo_inicio').val()
		if($('#periodo_hasta_id').val() == "") {
			$('#periodo_hasta_id').val(id);
			$('#periodo_fin').val(nombre);
		}

	});


	$(document).on("novedad.cambio", function() {
		var url = $('#listaNovedades').attr('data-href');

		$.get(url, {puesto_laboral_id: $('#puesto_laboral_id').val()}, function(data) {
			$('#listaNovedades').html(data);
		});

	});

	$(document).trigger("novedad.cambio");

	$('#listaNovedades').on('click', '.eliminarNovedad', function() {
		var url = $(this).attr('href');
		var linea = $(this).closest('tr');
		var dialogo = $('<div><p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span> ¿Está seguro que desea eliminar el registro?<p></div>');
	    dialogo.dialog({
	        resizable: false,
	        height:180,
	        modal: true,
	        title: "Eliminar novedad",
	        buttons: {
	          Eliminar: function() {
	            $.get(url, function(data) {
	            	if(data.success) {
	            		linea.remove();
	            	} else {
	            		alert(data.message);
	            	}
	            });
	            $( this ).dialog( "close" );
	          },
	          Cancelar: function( event, ui ) {
	            $( this ).dialog( "close" );
	          }
	        },
		    close: function(){
		    	$( this ).dialog( "destroy" );
		    }
	      });
		return false;
	});


	var options = {
			script:"/contabilidad/suggestPeriodo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) {
										$("#periodo_concepto_id").val(obj.id);
										$("#periodo_concepto_id").change();
									 }
		};
	var as_json = new bsn.AutoSuggest('periodo_concepto', options);

	var options = {
			script:"/contabilidad/suggestPeriodo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) {
										$("#periodo_inicio_id").val(obj.id);
										$("#periodo_inicio_id").change();
									 }
		};
	var as_json = new bsn.AutoSuggest('periodo_inicio', options);

	var options = {
			script:"/contabilidad/suggestPeriodo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) {
										$("#periodo_hasta_id").val(obj.id);
										$("#periodo_hasta_id").change();
									 }
		};
	var as_json = new bsn.AutoSuggest('periodo_fin', options);

});