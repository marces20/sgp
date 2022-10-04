$( function(){
	$(document).on('click', '.delete-confirm-link', function(){
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
	            window.location.href = link;
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
	
	$('table tr.pointer td:not(:has(.notSeleccion))').click( function(){
		window.location.href = $(this).closest('tr').attr('data-href');
	});
	$(document).on('click', '.btn-disable-onclick', function(){
		$('.btn-disable-onclick').attr("disabled", true);
	});
	
	$(".inputNumericMask").numeric_input();
	
	jQuery(function($){
        $.datepicker.regional['es'] = {
                closeText: 'Cerrar',
                prevText: '&#x3c;Ant',
                nextText: 'Sig&#x3e;',
                currentText: 'Hoy',
                monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
                'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
                monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
                'Jul','Ago','Sep','Oct','Nov','Dic'],
                dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
                dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
                dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
                weekHeader: 'Sm',
                dateFormat: 'dd/mm/yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
        $.datepicker.setDefaults($.datepicker.regional['es']);
	});
	
	$('#checkAll').change( function(){
		var table = $(this).closest('table');
		table.find("input[name='check_listado[]']").prop("checked", $(this).prop( "checked" ) );
		$(this).trigger("cambio.lista.seleccion");
	});
	
	$( ".datepicker" ).datepicker();
	$( ".date" ).mask("99/99/9999");
	$( ".dateMask" ).mask("99/99/9999");
	$( ".inputDateMascara" ).mask("99/99/9999");
	
	$(document).on('mouseover', '.tip-top', function(){
		$(".tip-top").tooltip({placement : 'top'});
	});
	$(document).on('mouseover', '.tip-right', function(){
	    $(".tip-right").tooltip({placement : 'right'});
	});
	$(document).on('mouseover', '.tip-bottom', function(){
		$(".tip-bottom").tooltip({placement : 'bottom'});
	});
	$(document).on('mouseover', '.tip-left', function(){
	    $(".tip-left").tooltip({ placement : 'left'});
	});
	
	$('#getExpedientesSinFirma').click( function() { 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Expedientes sin firma",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 400,
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
	
	$('#getDiferenciaAutorizadoPagos').click( function() {  
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Diferencias Entre Autorizados y Pagados",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 400,
			width:800,
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
	
	$('#getExpedientesRecepcionSinFirma').click( function() { //abrir modal para mostrar mensaje solicitud 322
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		dialogo.dialog({
			title: "Expedientes con Recepciones sin firma",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 400,
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
});

function getLoading () {
	return $('<div id="loading"></div>');
}

function getLoading () {
	return $('<div id="loading2"></div>');
}

function formatNumberPesos(n){
	x = "$0.00";
	x = Number(n).toFixed(2).replace(/./g, function(c, i, a) {
	    return i && c !== "." && !((a.length - i) % 3) ? ',' + c : c;
	});
	 
	var r;
	 
	if(x.indexOf(".") > 1){
		var elem = x.split('.');
		r = elem[0].replace(/,/g,".")+","+elem[1];
		
	}else{
		r = x.replace(",",".");
	}
	
	return "$"+r;
}

function crearDialogoGeneral(url){
	var dialogo = $('<div></div>');
	return dialogo.dialog({
    	resizable: false,
		autoOpen: true,
		modal: true,
		height: 250,
		width:750,
		position: 'top',
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
}

