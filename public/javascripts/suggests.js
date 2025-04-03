$(document).ready(function(){
	if($("#idaInstitucionExterna").length){
		var options = {
				script:"/suggestInstitucionExterna/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#idaInstitucionExternaIdModalAddCLiente").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('idaInstitucionExterna', options);
	}

	if($("#vueltaInstitucionExterna").length){
		var options = {
				script:"/suggestInstitucionExterna/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#vueltaInstitucionExternaIdModalAddCLiente").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('vueltaInstitucionExterna', options);
	}

	if($("#user2").length){
		var options = {
				script:"/administracion/usuarios/suggest/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#user2").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('user2', options);
	}


	if($("#cie").length){
		var options = {
				script:"/suggestCie/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cie_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cie', options);
	}


	if($("#planilla").length){
		var options = {
				script:"/recupero/suggestRecuperoPlanilla/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#planilla_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('planilla', options);
	}

	if($("#tipoResidencia").length){
		var options = {
				script:"/suggestTipoResidencia/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#tipo_residencia_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('tipoResidencia', options);
	}

	if($("#ordenProvision").length){
		var options = {
				script:"/patrimonio/suggestOrdenProvision/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#ordenProvision_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('ordenProvision', options);
	}
	if($("#obrasocial").length){
		var options = {
				script:"/suggestOb/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#obrasocial_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('obrasocial', options);
	}
	if($("#profesion").length){
		var options = {
				script:"/suggestProfesion/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#profesion_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('profesion', options);
	}

	if($("#cuenta_impuesto").length){
		var options = {
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuenta_impuesto_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuenta_impuesto', options);
	}
	if($("#concepto").length){
		var options = {
				script:"/suggestConcepto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#concepto").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('concepto', options);
	}

	if($("#organigrama").length){
		var options = {
				script:"/suggestOrganigrama/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#organigrama").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('organigrama', options);
	}

	if($("#puesto_laboral").length){
		var options = {
				script:"/suggestPuestoLaboral/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#puesto_laboral").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('puesto_laboral', options);
	}

	if($("#puesto_laboral_todos").length){
		var options = {
				script:"/suggestPuestoLaboralTodos/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#puesto_laboral_todos").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('puesto_laboral_todos', options);
	}

	if($("#articulo_nombre").length){
		var options = {
				script:"/suggestArticulo/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#articulo_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('articulo_nombre', options);
	}

	if($("#categoria_nombre").length){
		var options = {
				script:"/suggestCategoria/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#categoria_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('categoria_nombre', options);
	}

	if($("#parent_categoria_nombre").length){
		var options = {
				script:"/suggestCategoria/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#parent_categoria_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('parent_categoria_nombre', options);
	}

	if($("#tipo_producto_nombre").length){
		var options = {
				script:"/suggestTipoProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#tipo_producto_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('tipo_producto_nombre', options);
	}

	if($("#cuenta_ingreso_nombre").length){
		var options = {
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuenta_ingreso_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuenta_ingreso_nombre', options);
	}

	if($("#cuenta_gasto_nombre").length){
		var options = {
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuenta_gasto_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuenta_gasto_nombre', options);
	}

	if($("#udm_nombre").length){
		var options = {
				script:"/suggestUdm/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#udm_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('udm_nombre', options);
	}

	if($("#ejercicio_nombre").length){
		var options = {
				script:"/contabilidad/suggestEjercicio/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#ejercicio_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('ejercicio_nombre', options);
	}
	if($("#iniciador_nombre").length){
		var options = {
				script:"/suggestIniciador/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#iniciador_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('iniciador_nombre', options);
	}
	if($("#parent_departamento_nombre").length){
		var options = {
				script:"/suggestDepartamento/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:26,
				cache:false,
				callback: function (obj) {
											$("#parent_departamento_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('parent_departamento_nombre', options);
	}

	if($("#departamento_nombre").length){
		var options = {
				script:"/suggestDepartamento/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:26,
				cache:false,
				callback: function (obj) {
											$("#departamento_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('departamento_nombre', options);
	}

	if($("#especialidad_nombre").length){
		var options = {
				script:"/suggestEspecialidad/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#especialidad_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('especialidad_nombre', options);
	}

	if($("#puesto_nombre").length){
		var options = {
				script:"/suggestPuesto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#puesto_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('puesto_nombre', options);
	}

	if($("#banco_nombre").length){
		var options = {
				script:"/contabilidad/suggestBanco/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#banco_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('banco_nombre', options);
	}

	if($("#localidad_nombre").length){
		var options = {
				script:"/suggestLocalidad/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#localidad_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('localidad_nombre', options);
	}

	if($("#proveedor").length){
		var options = {
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#proveedor_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('proveedor', options);
	}

	if($("#proveedor_padre").length){
		var options = {
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#proveedor_padre_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('proveedor_padre', options);
	}

	if($("#solicitante").length){
		var options = {
				script:"/suggestAgente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#solicitante_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('solicitante', options);
	}

	if($("#agente").length){
		var options = {
				script:"/suggestAgente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#agente_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('agente', options);
	}

	if($("#medico").length){
		var options = {
				script:"/suggestAgente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#medico_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('medico', options);
	}

	if($("#deposito_nombre").length){
		var options = {
				script:"/suggestDeposito/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#deposito_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('deposito_nombre', options);
	}

	if($("#cliente_nombre").length){
		var options = {
				script:"/suggestCliente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cliente_nombre").next().val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cliente_nombre', options);
	}

	if($("#create_usuario").length){
		var options = {
				script:"/administracion/usuarios/suggest/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#create_usuario_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('create_usuario', options);
	}

	if($("#producto").length){
		var options = {
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#producto_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('producto', options);
	}

	if($("#expediente").length){
		var options = {
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expediente', options);
	}

	if($("#expedienteFisico").length){
		var options = {
				script:"/suggestExpedienteCopia/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_fisico_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expedienteFisico', options);
	}
	if($("#periodo").length){
		var options = {
				script:"/contabilidad/suggestPeriodo/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#periodo_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('periodo', options);
	}
	if($("#responsable").length){
		var options = {
				script:"/administracion/usuarios/suggest/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#responsable_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('responsable', options);
	}

	if($("#paciente").length){
		var options = {
				script:"/suggestCliente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#paciente_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('paciente', options);
	}

	if($("#servicio").length){
		var options = {
				script:"/suggestDepartamento/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:26,
				cache:false,
				callback: function (obj) {
											$("#servicio_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('servicio', options);
	}

	if($("#cuentaAnalitica").length){
		var options = {
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuentaAnalitica_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	}

	if($("#cuentaAnaliticaHija").length){
		var options = {
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuentaAnaliticaHija_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuentaAnaliticaHija', options);
	}

	if($("#cuenta").length){
		var options = {
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#cuenta_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('cuenta', options);
	}

	if($("#orden_pago").length){
		var options = {
				script:"/contabilidad/suggestOrdenPago/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#orden_pago_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('orden_pago', options);
	}

	if($("#categoria_laboral").length){
		var options = {
				script:"/haberes/categoriaLaboral/suggestCategoriaLaboral/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#categoria_laboral_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('categoria_laboral', options);
	}

	if($("#escala_laboral").length){
		var options = {
				script:"/haberes/escalaLaboral/suggestEscalaLaboral/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#escala_laboral_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('escala_laboral', options);
	}

	if($("#expediente_aporte").length){
		var options = {
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_aporte_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expediente_aporte', options);
	}
	if($("#expediente_segurovida").length){
		var options = {
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_segurovida_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expediente_segurovida', options);
	}
	if($("#expediente_contribuciones").length){
		var options = {
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_contribuciones_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expediente_contribuciones', options);
	}
	if($("#expediente_segurosepelio").length){
		var options = {
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#expediente_segurosepelio_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('expediente_segurosepelio', options);
	}

	if($("#liquidacion_mes").length){
		var options = {
				script:"/suggestLiquidacionMes/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) {
											$("#iquidacion_mes_id").val(obj.id);
										 }
			};
		var as_json = new bsn.AutoSuggest('iquidacion_mes', options);
	}



})
