$( function() {

	$('#searchPeriodoInicio, #searchPeriodoFin').modalSearch();

	
	
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