(function ( $ ) {
	 
    $.fn.contenidoFull = function( options ) {
    	var tiempo = 500;
        var settings = $.extend({
        	inicioFull: false,
        }, options );
 
        if (settings.inicioFull) {
        	tiempo = 0;
        }

    	var menuContenido = $('.menu-contenido').parent();
    	var contenido = $('#contenido');
    	var wMenuInicial = menuContenido.innerWidth();
    	var wContenidoInicial = contenido.outerWidth();
    	var inicialLeft = contenido.position().left;
    	var inicialMenuTop = menuContenido.offset().top;
    	var inicialMenuLeft = menuContenido.offset().left;

    	var wNuevo = $('body').append('<div class="col-md-12">').width() ;
    	
    	var tiempo = 0;
    	
    	menuContenido.find('.titulo:first').append('<a href="#" id="esconde-menu" style="float: right; padding: 3px 10px"><i class="glyphicon glyphicon-backward"></i></a>');
    	
    	$('body').append('<a href="#" id="abre-menu" style="padding: 3px 10px; position: absolute; left: -30px; top: '+inicialMenuTop+' px"><i class="glyphicon glyphicon-forward"></i></a>');
    	
    	$('#esconde-menu').click( function () {
    		menuContenido.css({position: "absolute", width: (wMenuInicial)+"px", marginLeft: "-20px"});
    		menuContenido.animate({"left": "-="+wMenuInicial+"px"}, tiempo, function () {
    			$('#abre-menu').animate({"left": "0px"}, 500);
    		});
    		
    		contenido.css({position: "absolute", width: wContenidoInicial+"px", left: inicialLeft+"px"});
    		contenido.animate({left: "20px", width: (wNuevo - 30)+"px"}, tiempo);
    	});
    	
    	$('#abre-menu').click( function () {
    		$('#abre-menu').animate({"left": "-30px"}, tiempo, function() {
    			menuContenido.animate({"left": (inicialMenuLeft+20)+"px"});
    		}); 
    		contenido.animate({left: inicialLeft+"px", width: wContenidoInicial+"px"}, tiempo);
    	});
    	
    	if(settings.inicioFull) {
    		$('#esconde-menu').click();
    	}
        
    	settings.tiempo = 500;
    };
 
}( jQuery ));