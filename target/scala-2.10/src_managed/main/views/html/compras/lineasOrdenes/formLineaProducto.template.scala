
package views.html.compras.lineasOrdenes

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenLinea],OrdenLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[OrdenLinea],linea:OrdenLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<script>
$(function()"""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
	$("#precio, #cantidad").numeric_input();
	$('#searchProducto, #searchCliente, #searchDepartamento, #searchCuentaAnalitica').modalSearch();
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*19.3*/inputText(lineaForm("orden_id"), 'type -> "hidden"))),format.raw/*19.54*/("""
	<div class="col-sm-8">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*22.28*/if(lineaForm.error("producto_id") != null)/*22.70*/ {_display_(Seq[Any](format.raw/*22.72*/("""has-error""")))}/*22.83*/else/*22.88*/{_display_(Seq[Any](format.raw/*22.89*/("""has-required""")))})),format.raw/*22.102*/("""">
			
			"""),_display_(Seq[Any](/*24.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*24.116*/("""
			"""),_display_(Seq[Any](/*25.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*25.83*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*26.114*/controllers/*26.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*26.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
		"""),_display_(Seq[Any](/*28.4*/lineaForm("producto_id")/*28.28*/.error.map/*28.38*/{ error =>_display_(Seq[Any](format.raw/*28.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*29.29*/error/*29.34*/.message)),format.raw/*29.42*/("""</div>
		""")))})),format.raw/*30.4*/("""
	</div>
	<div class="col-sm-4">
		<label for="cliente" class="control-label">Servicio</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*35.5*/inputText(lineaForm("departamento.nombre"), 'class -> "form-control", 'id -> "departamento"))),format.raw/*35.97*/("""
			"""),_display_(Seq[Any](/*36.5*/inputText(lineaForm("departamento_id"), 'hidden -> "hidden", 'id -> "departamento_id"))),format.raw/*36.91*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchDepartamento" 
				   class="searchModal"
				   data-title="Selección de Servicio" 
				   data-url=""""),_display_(Seq[Any](/*42.19*/controllers/*42.30*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*42.80*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.departamento.simple" 
				   data-label="#departamento" data-field="#departamento_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*57.27*/if(lineaForm.error("precio") != null)/*57.64*/ {_display_(Seq[Any](format.raw/*57.66*/("""has-error""")))}/*57.77*/else/*57.82*/{_display_(Seq[Any](format.raw/*57.83*/("""has-required""")))})),format.raw/*57.96*/("""">
			
			"""),_display_(Seq[Any](/*59.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*59.78*/("""
			
			"""),_display_(Seq[Any](/*61.5*/lineaForm("precio")/*61.24*/.error.map/*61.34*/{ error =>_display_(Seq[Any](format.raw/*61.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*61.70*/error/*61.75*/.message)),format.raw/*61.83*/("""</div>""")))})),format.raw/*61.90*/("""
		</div>
	</div>
		
	<div class="col-sm-2">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*67.27*/if(lineaForm.error("cantidad") != null)/*67.66*/ {_display_(Seq[Any](format.raw/*67.68*/("""has-error""")))}/*67.79*/else/*67.84*/{_display_(Seq[Any](format.raw/*67.85*/("""has-required""")))})),format.raw/*67.98*/("""">
			"""),_display_(Seq[Any](/*68.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*68.82*/("""
			"""),_display_(Seq[Any](/*69.5*/lineaForm("cantidad")/*69.26*/.error.map/*69.36*/{ error =>_display_(Seq[Any](format.raw/*69.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*69.72*/error/*69.77*/.message)),format.raw/*69.85*/("""</div>""")))})),format.raw/*69.92*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*75.27*/if(lineaForm.error("udm_id") != null)/*75.64*/ {_display_(Seq[Any](format.raw/*75.66*/("""has-error""")))}/*75.77*/else/*75.82*/{_display_(Seq[Any](format.raw/*75.83*/("""has-required""")))})),format.raw/*75.96*/("""">
			"""),_display_(Seq[Any](/*76.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*76.147*/("""
			"""),_display_(Seq[Any](/*77.5*/lineaForm("udm_id")/*77.24*/.error.map/*77.34*/{ error =>_display_(Seq[Any](format.raw/*77.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*77.70*/error/*77.75*/.message)),format.raw/*77.83*/("""</div> """)))})),format.raw/*77.91*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<label for="cuenta" class="control-label">Cuenta Presupuestaria</label>
		<div class="input-group """),_display_(Seq[Any](/*82.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*82.78*/ {_display_(Seq[Any](format.raw/*82.80*/("""has-error""")))}/*82.91*/else/*82.96*/{_display_(Seq[Any](format.raw/*82.97*/("""has-required""")))})),format.raw/*82.110*/("""">
			"""),_display_(Seq[Any](/*83.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*83.103*/("""
			"""),_display_(Seq[Any](/*84.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*84.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*90.19*/controllers/*90.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*90.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*99.4*/lineaForm("cuenta_analitica_id")/*99.36*/.error.map/*99.46*/{ error =>_display_(Seq[Any](format.raw/*99.56*/(""" <div class="text-error">"""),_display_(Seq[Any](/*99.82*/error/*99.87*/.message)),format.raw/*99.95*/("""</div> """)))})),format.raw/*99.103*/("""
	</div>
</div>
<div class="row">
	<div class="col-sm-8">
		<label for="nombre" class="control-label">Descripcion</label>
		<div class="form-group """),_display_(Seq[Any](/*105.27*/if(lineaForm.error("nombre") != null)/*105.64*/ {_display_(Seq[Any](format.raw/*105.66*/("""has-error""")))})),format.raw/*105.76*/("""">
			"""),_display_(Seq[Any](/*106.5*/inputText(lineaForm("nota"), 'class -> "form-control", 'id -> "nombre"))),format.raw/*106.76*/("""
			"""),_display_(Seq[Any](/*107.5*/lineaForm("nota")/*107.22*/.error.map/*107.32*/{ error =>_display_(Seq[Any](format.raw/*107.42*/(""" <div class="text-error">"""),_display_(Seq[Any](/*107.68*/error/*107.73*/.message)),format.raw/*107.81*/("""</div>""")))})),format.raw/*107.88*/("""
		</div>
	</div>	
	<!-- <div class="col-sm-4">
		<label for="cliente" class="control-label">Paciente</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*113.5*/inputText(lineaForm("cliente.nombre"), 'class -> "form-control", 'id -> "cliente"))),format.raw/*113.87*/("""
			"""),_display_(Seq[Any](/*114.5*/inputText(lineaForm("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*114.81*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCliente" 
				   class="searchModal"
				   data-title="Selección de paciente" 
				   data-url=""""),_display_(Seq[Any](/*120.19*/controllers/*120.30*/.compras.routes.ClientesController.modalBuscar())),format.raw/*120.78*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cliente.simple" 
				   data-label="#cliente" data-field="#cliente_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
	</div> -->
	<div class="col-sm-4">
		<label for="cliente" class="control-label">&nbsp </label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*133.5*/if(linea != null && linea.ordenLineaCliente != null && linea.id != null)/*133.77*/{_display_(Seq[Any](format.raw/*133.78*/("""
				<button type="button" id="addClientes" class="btn btn-default" 
				data-url=""""),_display_(Seq[Any](/*135.16*/controllers/*135.27*/.compras.routes.LineasOrdenesController.modalAddClientes(linea.id))),format.raw/*135.93*/("""">
				<i class="glyphicon glyphicon-user"></i> Agregar Pacientes
				</button>
			""")))})),format.raw/*138.5*/("""
		</div>
	</div>
</div>


<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<table class="table table-striped table-bordered" id="tablaListadoPacientes">	
			<thead>
				<tr>
					<th width="100" align="center">Paciente</th>
					<th width="30" align="center">Cantidad</th>
					<th width="30" align="center">#</th>
				</tr>	
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*156.6*/if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0)/*156.96*/{_display_(Seq[Any](format.raw/*156.97*/("""
					"""),_display_(Seq[Any](/*157.7*/for(olp <- linea.ordenLineaCliente) yield /*157.42*/ {_display_(Seq[Any](format.raw/*157.44*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*159.13*/(olp.cliente.nombre))),format.raw/*159.33*/("""</td>
							<td class='cantidadLineaCliente'>"""),_display_(Seq[Any](/*160.42*/(olp.cantidad))),format.raw/*160.56*/("""</td>
							<td>
								<a data-url=""""),_display_(Seq[Any](/*162.23*/controllers/*162.34*/.compras.routes.OrdenesLineasClientesController.eliminarAjax(olp.id))),format.raw/*162.102*/("""" class="btn btn-default btn-xs notSeleccion eliminarLineaPaciente" href="#">
									<i class="glyphicon glyphicon-trash icono-eliminar"></i>
								</a>
							</td>
						</tr>		
					""")))})),format.raw/*167.7*/("""
				""")))}/*168.6*/else/*168.10*/{_display_(Seq[Any](format.raw/*168.11*/("""
					<tr>
						<td colspan="3">No contiene Pacientes</td>
					</tr>			
				""")))})),format.raw/*172.6*/("""
			</tbody>
		</table>
	</div>	
</div>

<div class="row margin-top-20">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
	</div>
</div>
<script>
$( function()"""),format.raw/*185.14*/("""{"""),format.raw/*185.15*/("""
	
	$("#tablaListadoPacientes").on( "click",".eliminarLineaPaciente", function() """),format.raw/*187.79*/("""{"""),format.raw/*187.80*/("""
		var url = $(this).attr("data-url");
		var tr = $(this).closest('tr');
		$.post(url,function(data)"""),format.raw/*190.28*/("""{"""),format.raw/*190.29*/("""
			var respuesta = false;
			if(data.results) """),format.raw/*192.21*/("""{"""),format.raw/*192.22*/("""
				$.each(data.results,function(idx,valor)"""),format.raw/*193.44*/("""{"""),format.raw/*193.45*/("""
					if(valor['respuesta'] == true)"""),format.raw/*194.36*/("""{"""),format.raw/*194.37*/("""
						respuesta = true;
					"""),format.raw/*196.6*/("""}"""),format.raw/*196.7*/("""
				"""),format.raw/*197.5*/("""}"""),format.raw/*197.6*/(""")
			"""),format.raw/*198.4*/("""}"""),format.raw/*198.5*/("""
			
			if(respuesta)"""),format.raw/*200.17*/("""{"""),format.raw/*200.18*/("""
				tr.remove();
				if(!$('.eliminarLineaPaciente').length)"""),format.raw/*202.44*/("""{"""),format.raw/*202.45*/("""
					var trNo = '<tr><td colspan="3">No contiene Pacientes</td></tr>'
					$('#tablaListadoPacientes tbody').append(trNo);
				"""),format.raw/*205.5*/("""}"""),format.raw/*205.6*/("""
			"""),format.raw/*206.4*/("""}"""),format.raw/*206.5*/("""else"""),format.raw/*206.9*/("""{"""),format.raw/*206.10*/("""
				alert('No se puede eliminar el regristro.')
			"""),format.raw/*208.4*/("""}"""),format.raw/*208.5*/("""
		"""),format.raw/*209.3*/("""}"""),format.raw/*209.4*/(""");	
		
		return false;
	"""),format.raw/*212.2*/("""}"""),format.raw/*212.3*/(""");
	
	$( "#addClientes" ).on( "click", function() """),format.raw/*214.46*/("""{"""),format.raw/*214.47*/("""
		 
		var url = $(this).attr("data-url");
		var dialogo = $('<div id="modalAddClientes"></div>');

		dialogo.dialog("""),format.raw/*219.18*/("""{"""),format.raw/*219.19*/("""
			title: "Agregar Paciente",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: """),format.raw/*226.19*/("""{"""),format.raw/*226.20*/("""
		          Cerrar: function() """),format.raw/*227.32*/("""{"""),format.raw/*227.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*229.13*/("""}"""),format.raw/*229.14*/("""
		    """),format.raw/*230.7*/("""}"""),format.raw/*230.8*/(""",
	    	close: function(event, ui )"""),format.raw/*231.34*/("""{"""),format.raw/*231.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*233.7*/("""}"""),format.raw/*233.8*/(""",
		    open: function( event, ui ) """),format.raw/*234.35*/("""{"""),format.raw/*234.36*/("""
				$.get(url, function(data)"""),format.raw/*235.30*/("""{"""),format.raw/*235.31*/("""
					dialogo.html(data);
				"""),format.raw/*237.5*/("""}"""),format.raw/*237.6*/(""");	
		    """),format.raw/*238.7*/("""}"""),format.raw/*238.8*/("""
	    """),format.raw/*239.6*/("""}"""),format.raw/*239.7*/(""");
		return false;
	"""),format.raw/*241.2*/("""}"""),format.raw/*241.3*/(""");
	
	if($("#producto").length)"""),format.raw/*243.27*/("""{"""),format.raw/*243.28*/("""
		var options = """),format.raw/*244.17*/("""{"""),format.raw/*244.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*250.30*/("""{"""),format.raw/*250.31*/(""" 
											$("#producto_id").val(obj.id); 
										 """),format.raw/*252.12*/("""}"""),format.raw/*252.13*/("""
			"""),format.raw/*253.4*/("""}"""),format.raw/*253.5*/(""";
		var as_json = new bsn.AutoSuggest('producto', options);
	"""),format.raw/*255.2*/("""}"""),format.raw/*255.3*/("""
	
	if($("#cliente").length)"""),format.raw/*257.26*/("""{"""),format.raw/*257.27*/("""
		var options = """),format.raw/*258.17*/("""{"""),format.raw/*258.18*/("""
				script:"/suggestCliente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*264.30*/("""{"""),format.raw/*264.31*/(""" 
											$("#cliente_id").val(obj.id); 
										 """),format.raw/*266.12*/("""}"""),format.raw/*266.13*/("""
			"""),format.raw/*267.4*/("""}"""),format.raw/*267.5*/(""";
		var as_json = new bsn.AutoSuggest('cliente', options);
	"""),format.raw/*269.2*/("""}"""),format.raw/*269.3*/("""
	
	if($("#departamento").length)"""),format.raw/*271.31*/("""{"""),format.raw/*271.32*/("""
		var options = """),format.raw/*272.17*/("""{"""),format.raw/*272.18*/("""
				script:"/suggestDepartamento/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:26,
				cache:false,
				callback: function (obj) """),format.raw/*279.30*/("""{"""),format.raw/*279.31*/(""" 
											$("#departamento_id").val(obj.id); 
										 """),format.raw/*281.12*/("""}"""),format.raw/*281.13*/("""
			"""),format.raw/*282.4*/("""}"""),format.raw/*282.5*/(""";
		var as_json = new bsn.AutoSuggest('departamento', options);
	"""),format.raw/*284.2*/("""}"""),format.raw/*284.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*286.34*/("""{"""),format.raw/*286.35*/("""
		var options = """),format.raw/*287.17*/("""{"""),format.raw/*287.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*293.30*/("""{"""),format.raw/*293.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*295.12*/("""}"""),format.raw/*295.13*/("""
			"""),format.raw/*296.4*/("""}"""),format.raw/*296.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*298.2*/("""}"""),format.raw/*298.3*/("""
"""),format.raw/*299.1*/("""}"""),format.raw/*299.2*/(""");
</script>
"""))}
    }
    
    def render(lineaForm:Form[OrdenLinea],linea:OrdenLinea): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[OrdenLinea],OrdenLinea) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/formLineaProducto.scala.html
                    HASH: 979c10ecf910d0ed34aa0e3d0c5e81fbea5757b1
                    MATRIX: 829->1|978->68|1010->92|1084->47|1113->136|1153->142|1191->172|1230->174|1353->262|1366->267|1400->280|1442->292|1496->318|1525->319|1696->463|1724->464|1798->503|1871->554|2032->679|2083->721|2123->723|2152->734|2165->739|2204->740|2250->753|2298->766|2432->877|2473->883|2573->961|2725->1076|2746->1087|2818->1136|3053->1336|3086->1360|3105->1370|3153->1380|3219->1410|3233->1415|3263->1423|3305->1434|3472->1566|3586->1658|3627->1664|3735->1750|3951->1930|3971->1941|4043->1991|4481->2393|4527->2430|4567->2432|4596->2443|4609->2448|4648->2449|4693->2462|4741->2475|4836->2548|4882->2559|4910->2578|4929->2588|4977->2598|5039->2624|5053->2629|5083->2637|5122->2644|5298->2784|5346->2823|5386->2825|5415->2836|5428->2841|5467->2842|5512->2855|5555->2863|5654->2940|5695->2946|5725->2967|5744->2977|5792->2987|5854->3013|5868->3018|5898->3026|5937->3033|6091->3151|6137->3188|6177->3190|6206->3201|6219->3206|6258->3207|6303->3220|6346->3228|6511->3370|6552->3376|6580->3395|6599->3405|6647->3415|6709->3441|6723->3446|6753->3454|6793->3462|6977->3610|7036->3660|7076->3662|7105->3673|7118->3678|7157->3679|7203->3692|7246->3700|7367->3798|7408->3804|7523->3897|7750->4088|7770->4099|7854->4161|8167->4439|8208->4471|8227->4481|8275->4491|8337->4517|8351->4522|8381->4530|8422->4538|8613->4692|8660->4729|8701->4731|8744->4741|8788->4749|8882->4820|8924->4826|8951->4843|8971->4853|9020->4863|9083->4889|9098->4894|9129->4902|9169->4909|9353->5057|9458->5139|9500->5145|9599->5221|9811->5396|9832->5407|9903->5455|10322->5838|10404->5910|10444->5911|10567->5997|10588->6008|10677->6074|10796->6161|11231->6560|11331->6650|11371->6651|11415->6659|11467->6694|11508->6696|11571->6722|11614->6742|11699->6790|11736->6804|11815->6846|11836->6857|11928->6925|12155->7120|12181->7127|12195->7131|12235->7132|12350->7215|12763->7599|12793->7600|12905->7683|12935->7684|13067->7787|13097->7788|13175->7837|13205->7838|13279->7883|13309->7884|13375->7921|13405->7922|13465->7954|13494->7955|13528->7961|13557->7962|13591->7968|13620->7969|13672->7992|13702->7993|13794->8056|13824->8057|13983->8188|14012->8189|14045->8194|14074->8195|14106->8199|14136->8200|14218->8254|14247->8255|14279->8259|14308->8260|14363->8287|14392->8288|14473->8340|14503->8341|14654->8463|14684->8464|14858->8609|14888->8610|14950->8643|14980->8644|15069->8704|15099->8705|15135->8713|15164->8714|15229->8750|15259->8751|15332->8796|15361->8797|15427->8834|15457->8835|15517->8866|15547->8867|15607->8899|15636->8900|15675->8911|15704->8912|15739->8919|15768->8920|15818->8942|15847->8943|15909->8976|15939->8977|15986->8995|16016->8996|16186->9137|16216->9138|16303->9196|16333->9197|16366->9202|16395->9203|16486->9266|16515->9267|16574->9297|16604->9298|16651->9316|16681->9317|16850->9457|16880->9458|16966->9515|16996->9516|17029->9521|17058->9522|17148->9584|17177->9585|17241->9620|17271->9621|17318->9639|17348->9640|17541->9804|17571->9805|17662->9867|17692->9868|17725->9873|17754->9874|17849->9941|17878->9942|17945->9980|17975->9981|18022->9999|18052->10000|18242->10161|18272->10162|18366->10227|18396->10228|18429->10233|18458->10234|18556->10304|18585->10305|18615->10307|18644->10308
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|43->15|43->15|47->19|47->19|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|53->25|53->25|54->26|54->26|54->26|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|63->35|63->35|64->36|64->36|70->42|70->42|70->42|85->57|85->57|85->57|85->57|85->57|85->57|85->57|87->59|87->59|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|95->67|95->67|95->67|95->67|95->67|95->67|95->67|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|103->75|103->75|103->75|103->75|103->75|103->75|103->75|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|110->82|110->82|110->82|110->82|110->82|110->82|110->82|111->83|111->83|112->84|112->84|118->90|118->90|118->90|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|133->105|133->105|133->105|133->105|134->106|134->106|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|141->113|141->113|142->114|142->114|148->120|148->120|148->120|161->133|161->133|161->133|163->135|163->135|163->135|166->138|184->156|184->156|184->156|185->157|185->157|185->157|187->159|187->159|188->160|188->160|190->162|190->162|190->162|195->167|196->168|196->168|196->168|200->172|213->185|213->185|215->187|215->187|218->190|218->190|220->192|220->192|221->193|221->193|222->194|222->194|224->196|224->196|225->197|225->197|226->198|226->198|228->200|228->200|230->202|230->202|233->205|233->205|234->206|234->206|234->206|234->206|236->208|236->208|237->209|237->209|240->212|240->212|242->214|242->214|247->219|247->219|254->226|254->226|255->227|255->227|257->229|257->229|258->230|258->230|259->231|259->231|261->233|261->233|262->234|262->234|263->235|263->235|265->237|265->237|266->238|266->238|267->239|267->239|269->241|269->241|271->243|271->243|272->244|272->244|278->250|278->250|280->252|280->252|281->253|281->253|283->255|283->255|285->257|285->257|286->258|286->258|292->264|292->264|294->266|294->266|295->267|295->267|297->269|297->269|299->271|299->271|300->272|300->272|307->279|307->279|309->281|309->281|310->282|310->282|312->284|312->284|314->286|314->286|315->287|315->287|321->293|321->293|323->295|323->295|324->296|324->296|326->298|326->298|327->299|327->299
                    -- GENERATED --
                */
            