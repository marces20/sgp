
package views.html.compras.lineasOrdenes.acciones

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
object modalAddClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[OrdenLineaCliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: Long,lineaForm: Form[OrdenLineaCliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(id != null)/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
	"""),_display_(Seq[Any](/*6.3*/inputText(lineaForm("id"), 'hidden -> "hidden", 'id -> "idLineaModalAddCLiente"))),format.raw/*6.83*/("""
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row" style="margin-bottom: 10px;">
		 
				<div class="col-sm-6">
					<label for="cliente" class="control-label">Paciente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*14.8*/inputText(lineaForm("cliente.nombre"), 'class -> "form-control", 'id -> "cliente"))),format.raw/*14.90*/("""
						"""),_display_(Seq[Any](/*15.8*/inputText(lineaForm("cliente_id"), 'hidden -> "hidden", 'id -> "clienteIdModalAddCLiente"))),format.raw/*15.98*/("""
						<span class="input-group-addon">
							<a href="#" 
							   id="searchCliente" 
							   class="searchModal"
							   data-title="Selección de paciente" 
							   data-url=""""),_display_(Seq[Any](/*21.22*/controllers/*21.33*/.compras.routes.ClientesController.modalBuscar())),format.raw/*21.81*/("""" 
							   data-height="650" 
							   data-width="700" 
							   data-listen="modal.seleccion.cliente.simple" 
							   data-label="#cliente" data-field="#clienteIdModalAddCLiente">
							   <i class="glyphicon glyphicon-search"></i>
							 </a>
						</span>
					</div>
				</div>
				<div class="col-sm-4">
					<label for="cliente" class="control-label">Cantidad</label>
					"""),_display_(Seq[Any](/*33.7*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidadModalAddCLiente"))),format.raw/*33.99*/("""
				</div>
			</div>
			<div class="row">
				 
				<div class="col-sm-4 col-sm-offset-4">
					<button type="button" class="btn btn-default" id="guardarOrdenLineaCliente"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
					<button type="button" class="btn btn-default" id="cancelarOrdenLineaCliente"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</button>
				</div>
			</div>
		</div>
	</div>	

""")))}/*46.2*/else/*46.6*/{_display_(Seq[Any](format.raw/*46.7*/("""
	<div class="panel panel-default">
		<div class="panel-body">
			<p>Debe guardar la linea primero para despues poder asignarles Pacientes.</p>
		</div>
	</div>	

""")))})),format.raw/*53.2*/("""

<script>
$( function()"""),format.raw/*56.14*/("""{"""),format.raw/*56.15*/("""
	$('#searchCliente').modalSearch();	
	if($("#clienteIdModalAddCLiente").length)"""),format.raw/*58.43*/("""{"""),format.raw/*58.44*/("""
		var options = """),format.raw/*59.17*/("""{"""),format.raw/*59.18*/("""
				script:"/suggestCliente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*65.30*/("""{"""),format.raw/*65.31*/(""" 
											$("#clienteIdModalAddCLiente").val(obj.id); 
										 """),format.raw/*67.12*/("""}"""),format.raw/*67.13*/("""
			"""),format.raw/*68.4*/("""}"""),format.raw/*68.5*/(""";
		var as_json = new bsn.AutoSuggest('cliente', options);
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/("""
	
	$( "#cancelarOrdenLineaCliente" ).on( "click", function() """),format.raw/*72.60*/("""{"""),format.raw/*72.61*/("""
		$("#modalAddClientes").dialog( "destroy" );
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/(""");
	
	$( "#guardarOrdenLineaCliente" ).on( "click", function() """),format.raw/*76.59*/("""{"""),format.raw/*76.60*/("""
		
		if($('#idLineaModalAddCLiente').val() != '' && $('#clienteIdModalAddCLiente').val() != '')"""),format.raw/*78.93*/("""{"""),format.raw/*78.94*/("""
			var url = '/compras/linea-orden-cliente/guardarAjax';
			var data = 'idLinea='+$('#idLineaModalAddCLiente').val();
			data += '&clienteId='+$('#clienteIdModalAddCLiente').val();
			data += '&cantidad='+$('#cantidadModalAddCLiente').val();
			var urlEliminar = '';
			var cantidad = $('#cantidad').val();
			var cantidadLineaCliente = 0;
			$('.cantidadLineaCliente').each(function(idx,valor)"""),format.raw/*86.55*/("""{"""),format.raw/*86.56*/("""
				cantidadLineaCliente += parseInt($(valor).html())
			"""),format.raw/*88.4*/("""}"""),format.raw/*88.5*/(""");	
			cantidadLineaCliente += parseInt($("#cantidadModalAddCLiente").val());
			
			if(cantidadLineaCliente > cantidad)"""),format.raw/*91.39*/("""{"""),format.raw/*91.40*/("""
				alert('La cantidad por paciente excede a la cantidad de la linea.');
			"""),format.raw/*93.4*/("""}"""),format.raw/*93.5*/("""else"""),format.raw/*93.9*/("""{"""),format.raw/*93.10*/("""
				$.post(url, data, function(data)"""),format.raw/*94.37*/("""{"""),format.raw/*94.38*/("""
					var respuesta = false;
					if(data.results) """),format.raw/*96.23*/("""{"""),format.raw/*96.24*/("""
						$.each(data.results,function(idx,valor)"""),format.raw/*97.46*/("""{"""),format.raw/*97.47*/("""
							if(valor['respuesta'] == true)"""),format.raw/*98.38*/("""{"""),format.raw/*98.39*/("""
								respuesta = true;
								urlEliminar = valor['url'];
							"""),format.raw/*101.8*/("""}"""),format.raw/*101.9*/("""
						"""),format.raw/*102.7*/("""}"""),format.raw/*102.8*/(""")
					"""),format.raw/*103.6*/("""}"""),format.raw/*103.7*/("""
					
					if(respuesta)"""),format.raw/*105.19*/("""{"""),format.raw/*105.20*/("""
							var tr = "<tr>";
							tr += "<td>"+$("#cliente").val()+"</td>";
							tr += "<td class='cantidadLineaCliente'>"+$("#cantidadModalAddCLiente").val()+"</td>";
							tr += '<td><a data-url="'+urlEliminar+'" class="btn btn-default btn-xs notSeleccion eliminarLineaPaciente" href="#">';
							tr += '<i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>';
							tr += "</tr>";
						
							if (!$('.eliminarLineaPaciente').length) """),format.raw/*113.49*/("""{"""),format.raw/*113.50*/("""
								$('#tablaListadoPacientes tbody').empty();
							"""),format.raw/*115.8*/("""}"""),format.raw/*115.9*/("""	
							$('#tablaListadoPacientes tbody').append(tr);
							
							$("#modalAddClientes").dialog( "destroy" );
						
					"""),format.raw/*120.6*/("""}"""),format.raw/*120.7*/("""else"""),format.raw/*120.11*/("""{"""),format.raw/*120.12*/("""
						alert('No se puede guardar el paciente.');
					"""),format.raw/*122.6*/("""}"""),format.raw/*122.7*/("""
				"""),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""");
			"""),format.raw/*124.4*/("""}"""),format.raw/*124.5*/("""	
		"""),format.raw/*125.3*/("""}"""),format.raw/*125.4*/("""else"""),format.raw/*125.8*/("""{"""),format.raw/*125.9*/("""
			alert('Debe ingresar un paciente.')
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/("""
	"""),format.raw/*128.2*/("""}"""),format.raw/*128.3*/(""");
	
	
	function getDatos()"""),format.raw/*131.21*/("""{"""),format.raw/*131.22*/("""
		
	"""),format.raw/*133.2*/("""}"""),format.raw/*133.3*/("""
	
"""),format.raw/*135.1*/("""}"""),format.raw/*135.2*/(""");
</script>"""))}
    }
    
    def render(id:Long,lineaForm:Form[OrdenLineaCliente]): play.api.templates.HtmlFormat.Appendable = apply(id,lineaForm)
    
    def f:((Long,Form[OrdenLineaCliente]) => play.api.templates.HtmlFormat.Appendable) = (id,lineaForm) => apply(id,lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/acciones/modalAddClientes.scala.html
                    HASH: ba2b7e5bb424a8f0c0440f592e833414da7e1f06
                    MATRIX: 838->1|985->65|1017->89|1091->46|1119->133|1157->137|1179->151|1218->153|1255->156|1356->236|1638->483|1742->565|1785->573|1897->663|2120->850|2140->861|2210->909|2634->1298|2748->1390|3194->1818|3206->1822|3244->1823|3439->1987|3491->2011|3520->2012|3628->2092|3657->2093|3702->2110|3731->2111|3893->2245|3922->2246|4019->2315|4048->2316|4079->2320|4107->2321|4194->2381|4222->2382|4312->2444|4341->2445|4416->2493|4444->2494|4535->2557|4564->2558|4688->2654|4717->2655|5140->3050|5169->3051|5254->3109|5282->3110|5430->3230|5459->3231|5563->3308|5591->3309|5622->3313|5651->3314|5716->3351|5745->3352|5824->3403|5853->3404|5927->3450|5956->3451|6022->3489|6051->3490|6149->3560|6178->3561|6213->3568|6242->3569|6277->3576|6306->3577|6360->3602|6390->3603|6872->4056|6902->4057|6989->4116|7018->4117|7172->4243|7201->4244|7234->4248|7264->4249|7347->4304|7376->4305|7409->4310|7438->4311|7472->4317|7501->4318|7533->4322|7562->4323|7594->4327|7623->4328|7693->4370|7722->4371|7752->4373|7781->4374|7837->4401|7867->4402|7900->4407|7929->4408|7960->4411|7989->4412
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|34->6|34->6|42->14|42->14|43->15|43->15|49->21|49->21|49->21|61->33|61->33|74->46|74->46|74->46|81->53|84->56|84->56|86->58|86->58|87->59|87->59|93->65|93->65|95->67|95->67|96->68|96->68|98->70|98->70|100->72|100->72|102->74|102->74|104->76|104->76|106->78|106->78|114->86|114->86|116->88|116->88|119->91|119->91|121->93|121->93|121->93|121->93|122->94|122->94|124->96|124->96|125->97|125->97|126->98|126->98|129->101|129->101|130->102|130->102|131->103|131->103|133->105|133->105|141->113|141->113|143->115|143->115|148->120|148->120|148->120|148->120|150->122|150->122|151->123|151->123|152->124|152->124|153->125|153->125|153->125|153->125|155->127|155->127|156->128|156->128|159->131|159->131|161->133|161->133|163->135|163->135
                    -- GENERATED --
                */
            