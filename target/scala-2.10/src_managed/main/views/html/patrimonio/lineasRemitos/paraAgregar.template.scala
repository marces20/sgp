
package views.html.patrimonio.lineasRemitos

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
object paraAgregar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenProvisionLineas],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenProvisionLineas], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*5.70*/(""" 



<div class="contenedorPaginador ajaxPaginador">

<div id="filtroBuscador" class="row">	
	"""),_display_(Seq[Any](/*12.3*/helper/*12.9*/.form(action = controllers.patrimonio.routes.RemitosLineasController.paraAgregar(), 'id -> "buscadorroductosAgregarRemitos")/*12.133*/ {_display_(Seq[Any](format.raw/*12.135*/("""
	"""),_display_(Seq[Any](/*13.3*/inputText(formBuscador("id_remito"), 'type -> "hidden", 'id -> "remitoId"))),format.raw/*13.77*/("""

	<div class="col-sm-5">
		<label for="producto" class="control-label">Producto</label>
			"""),_display_(Seq[Any](/*17.5*/inputText(formBuscador("producto"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "productoLinea"))),format.raw/*17.117*/("""
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	
	<div class="col-sm-2 col-sm-offset-3">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<a id="agregarTodos" href=""""),_display_(Seq[Any](/*31.31*/controllers/*31.42*/.patrimonio.routes.RemitosLineasController.recepcionarTodos(formBuscador.get("id_remito").toLong))),format.raw/*31.139*/("""" class="form-control"><i class="glyphicon glyphicon-cloud-download"></i> Agregar todos</a>
		</div>
	</div>
	
	""")))})),format.raw/*35.3*/("""
</div>



   """),_display_(Seq[Any](/*40.5*/if(buscador.getTotalRowCount == 0)/*40.39*/ {_display_(Seq[Any](format.raw/*40.41*/("""
        
       <div class="well">
           <em>No se encuentran productos para agregar.</em>
       </div>
        
    """)))}/*46.7*/else/*46.12*/{_display_(Seq[Any](format.raw/*46.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*48.14*/buscador/*48.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*48.54*/(""" resultado(s).   
		<table id="listaProductos" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="600">Producto</th>
					<th width="50">Pendiente</th>	
					<th width="50">UDM</th>
					<th width="100">Valor</th>
					<th></th>				
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*60.12*/for(linea <- buscador.getList()) yield /*60.44*/ {_display_(Seq[Any](format.raw/*60.46*/("""
				<tr class="pointer" id="tr-"""),_display_(Seq[Any](/*61.33*/linea/*61.38*/.orden_linea_id)),format.raw/*61.53*/("""">
					<td>"""),_display_(Seq[Any](/*62.11*/linea/*62.16*/.producto.nombre)),format.raw/*62.32*/("""</td>
					<td>"""),_display_(Seq[Any](/*63.11*/linea/*63.16*/.getPendiente())),format.raw/*63.31*/("""</td>
					<td>"""),_display_(Seq[Any](/*64.11*/linea/*64.16*/.udm)),format.raw/*64.20*/("""</td>
					<td>"""),_display_(Seq[Any](/*65.11*/utils/*65.16*/.NumberUtils.moneda(linea.precio))),format.raw/*65.49*/("""</td>
					<td><input class="linea_orden_id" type="hidden" value=""""),_display_(Seq[Any](/*66.62*/linea/*66.67*/.orden_linea_id)),format.raw/*66.82*/("""" name="linea_orden_id" /> 
					<input class="cantidad" type="text" name="cantidad" value=""""),_display_(Seq[Any](/*67.66*/linea/*67.71*/.getPendiente())),format.raw/*67.86*/("""" style="width: 60px" /> 
					<button class="agregar" data-url=""""),_display_(Seq[Any](/*68.41*/controllers/*68.52*/.patrimonio.routes.RemitosLineasController.modalAgregarConClientes())),format.raw/*68.120*/(""""><i class="glyphicon glyphicon-ok-sign"></i></button> </td>
				</tr>
              	""")))})),format.raw/*70.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*75.8*/views/*75.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosLineasController.paraAgregar()))),format.raw/*75.115*/("""
		</div>
        
    """)))})),format.raw/*78.6*/("""
</div>

<script>
$( function() """),format.raw/*82.15*/("""{"""),format.raw/*82.16*/("""
	$('#searchProductoLinea').modalSearch();
	
	$(".cantidad").numeric_input();
	$('#agregarTodos').click( function() """),format.raw/*86.39*/("""{"""),format.raw/*86.40*/("""
		
	"""),format.raw/*88.2*/("""}"""),format.raw/*88.3*/(""");
	
	var idRemito = $('#remitoId').val();
	$('#listaProductos tbody tr .cantidad').keypress(function(e) """),format.raw/*91.63*/("""{"""),format.raw/*91.64*/("""
		var btn = $(this).closest('tr').find('.agregar');
	    if(e.which == 13) """),format.raw/*93.24*/("""{"""),format.raw/*93.25*/("""
	    	btn.click();
	    """),format.raw/*95.6*/("""}"""),format.raw/*95.7*/("""
	"""),format.raw/*96.2*/("""}"""),format.raw/*96.3*/(""");
	
	$('#listaProductos tbody tr .agregar').click( function()"""),format.raw/*98.58*/("""{"""),format.raw/*98.59*/("""
		$this = $(this);
		$this.prop('disabled', true);
		var tr = $(this).closest('tr')
		var cantidad = tr.find('.cantidad').val();
		var linea_orden_id = tr.find('.linea_orden_id').val();
		 
		
		var url = $(this).attr("data-url");
		
		$.get('"""),_display_(Seq[Any](/*108.11*/controllers/*108.22*/.patrimonio.routes.RemitosLineasController.tienePacientes())),format.raw/*108.81*/("""', """),format.raw/*108.84*/("""{"""),format.raw/*108.85*/("""linea_orden_id: linea_orden_id"""),format.raw/*108.115*/("""}"""),format.raw/*108.116*/(""", function(datac) """),format.raw/*108.134*/("""{"""),format.raw/*108.135*/("""
			if(datac.success)"""),format.raw/*109.21*/("""{"""),format.raw/*109.22*/("""
			
				$.post('"""),_display_(Seq[Any](/*111.14*/controllers/*111.25*/.patrimonio.routes.RemitosLineasController.controlesAgregarConCliente())),format.raw/*111.96*/("""', """),format.raw/*111.99*/("""{"""),format.raw/*111.100*/("""remito_id: idRemito, cantidad:cantidad, linea_orden_id: linea_orden_id"""),format.raw/*111.170*/("""}"""),format.raw/*111.171*/(""", function(data) """),format.raw/*111.188*/("""{"""),format.raw/*111.189*/("""
					if(data.message) """),format.raw/*112.23*/("""{"""),format.raw/*112.24*/("""
						alert(data.message);
						$this.removeAttr('disabled');
					"""),format.raw/*115.6*/("""}"""),format.raw/*115.7*/(""" else """),format.raw/*115.13*/("""{"""),format.raw/*115.14*/("""
						
						var dialogo = $('<div id="dialogo-carga-pacientes-cantidad"></div>');
						dialogo.dialog("""),format.raw/*118.22*/("""{"""),format.raw/*118.23*/("""
					    	resizable: false,
							autoOpen: true,
							modal: true,
							height: 350,
							width:750,
							position: 'top',
							title: "Cargar cantidades de cada Paciente",
							buttons: """),format.raw/*126.17*/("""{"""),format.raw/*126.18*/("""
						          Cerrar: function() """),format.raw/*127.36*/("""{"""),format.raw/*127.37*/("""
						            $( this ).dialog( "destroy" );
						            $this.removeAttr('disabled');
						          """),format.raw/*130.17*/("""}"""),format.raw/*130.18*/("""
						    """),format.raw/*131.11*/("""}"""),format.raw/*131.12*/(""",
					    	close: function(event, ui )"""),format.raw/*132.38*/("""{"""),format.raw/*132.39*/("""
					    		$(this).dialog( "destroy" );
					    		$this.removeAttr('disabled');
					    	"""),format.raw/*135.11*/("""}"""),format.raw/*135.12*/(""",
						    open: function( event, ui ) """),format.raw/*136.39*/("""{"""),format.raw/*136.40*/("""
								$.get(url,"""),format.raw/*137.19*/("""{"""),format.raw/*137.20*/("""remito_id: idRemito, cantidad:cantidad, linea_orden_id: linea_orden_id"""),format.raw/*137.90*/("""}"""),format.raw/*137.91*/(""", function(data)"""),format.raw/*137.107*/("""{"""),format.raw/*137.108*/("""
									dialogo.html(data);
								"""),format.raw/*139.9*/("""}"""),format.raw/*139.10*/(""");	
								
						    """),format.raw/*141.11*/("""}"""),format.raw/*141.12*/("""
					      """),format.raw/*142.12*/("""}"""),format.raw/*142.13*/(""");
						 
					"""),format.raw/*144.6*/("""}"""),format.raw/*144.7*/("""
				"""),format.raw/*145.5*/("""}"""),format.raw/*145.6*/(""");
			"""),format.raw/*146.4*/("""}"""),format.raw/*146.5*/("""else"""),format.raw/*146.9*/("""{"""),format.raw/*146.10*/("""
			
				$.post('"""),_display_(Seq[Any](/*148.14*/controllers/*148.25*/.patrimonio.routes.RemitosLineasController.agregar())),format.raw/*148.77*/("""', """),format.raw/*148.80*/("""{"""),format.raw/*148.81*/("""remito_id: idRemito, cantidad:cantidad, linea_orden_id: linea_orden_id"""),format.raw/*148.151*/("""}"""),format.raw/*148.152*/(""", function(data) """),format.raw/*148.169*/("""{"""),format.raw/*148.170*/("""
					 
					if(data.success) """),format.raw/*150.23*/("""{"""),format.raw/*150.24*/("""
						tr.remove();
					"""),format.raw/*152.6*/("""}"""),format.raw/*152.7*/(""" else """),format.raw/*152.13*/("""{"""),format.raw/*152.14*/("""
						alert(data.message);
					"""),format.raw/*154.6*/("""}"""),format.raw/*154.7*/("""
					$this.removeAttr('disabled');
				"""),format.raw/*156.5*/("""}"""),format.raw/*156.6*/(""");
			"""),format.raw/*157.4*/("""}"""),format.raw/*157.5*/("""
		"""),format.raw/*158.3*/("""}"""),format.raw/*158.4*/(""");
	"""),format.raw/*159.2*/("""}"""),format.raw/*159.3*/(""");
	
	
	
	var resultados = $('#resultadoLineasRemitos');
	
	$('#buscadorLineasRemitos').submit( function() """),format.raw/*165.49*/("""{"""),format.raw/*165.50*/("""
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data)"""),format.raw/*168.49*/("""{"""),format.raw/*168.50*/("""
			resultados.replaceWith(data);
		"""),format.raw/*170.3*/("""}"""),format.raw/*170.4*/(""");
		
		return false;
	"""),format.raw/*173.2*/("""}"""),format.raw/*173.3*/(""");
	
	
"""),format.raw/*176.1*/("""}"""),format.raw/*176.2*/(""");
</script>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenProvisionLineas],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenProvisionLineas],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasRemitos/paraAgregar.scala.html
                    HASH: c00c35a040028a9d0f6dc8c779e6774363428e09
                    MATRIX: 860->1|1091->150|1123->174|1197->89|1226->218|1363->320|1377->326|1511->450|1552->452|1591->456|1687->530|1819->627|1954->739|2410->1159|2430->1170|2550->1267|2698->1384|2753->1404|2796->1438|2836->1440|2985->1572|2998->1577|3037->1578|3092->1597|3109->1605|3163->1637|3529->1967|3577->1999|3617->2001|3687->2035|3701->2040|3738->2055|3788->2069|3802->2074|3840->2090|3893->2107|3907->2112|3944->2127|3997->2144|4011->2149|4037->2153|4090->2170|4104->2175|4159->2208|4263->2276|4277->2281|4314->2296|4444->2390|4458->2395|4495->2410|4598->2477|4618->2488|4709->2556|4830->2645|4942->2722|4956->2727|5081->2829|5139->2856|5203->2892|5232->2893|5380->3013|5409->3014|5443->3021|5471->3022|5607->3130|5636->3131|5742->3209|5771->3210|5825->3237|5853->3238|5883->3241|5911->3242|6003->3306|6032->3307|6324->3562|6345->3573|6427->3632|6459->3635|6489->3636|6549->3666|6580->3667|6628->3685|6659->3686|6710->3708|6740->3709|6797->3729|6818->3740|6912->3811|6944->3814|6975->3815|7075->3885|7106->3886|7153->3903|7184->3904|7237->3928|7267->3929|7367->4001|7396->4002|7431->4008|7461->4009|7598->4117|7628->4118|7867->4328|7897->4329|7963->4366|7993->4367|8139->4484|8169->4485|8210->4497|8240->4498|8309->4538|8339->4539|8463->4634|8493->4635|8563->4676|8593->4677|8642->4697|8672->4698|8771->4768|8801->4769|8847->4785|8878->4786|8946->4826|8976->4827|9030->4852|9060->4853|9102->4866|9132->4867|9178->4885|9207->4886|9241->4892|9270->4893|9305->4900|9334->4901|9366->4905|9396->4906|9453->4926|9474->4937|9549->4989|9581->4992|9611->4993|9711->5063|9742->5064|9789->5081|9820->5082|9881->5114|9911->5115|9966->5142|9995->5143|10030->5149|10060->5150|10123->5185|10152->5186|10222->5228|10251->5229|10286->5236|10315->5237|10347->5241|10376->5242|10409->5247|10438->5248|10580->5361|10610->5362|10730->5453|10760->5454|10826->5492|10855->5493|10909->5519|10938->5520|10976->5530|11005->5531
                    LINES: 26->1|33->5|33->5|34->1|35->5|42->12|42->12|42->12|42->12|43->13|43->13|47->17|47->17|61->31|61->31|61->31|65->35|70->40|70->40|70->40|76->46|76->46|76->46|78->48|78->48|78->48|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|97->67|97->67|98->68|98->68|98->68|100->70|105->75|105->75|105->75|108->78|112->82|112->82|116->86|116->86|118->88|118->88|121->91|121->91|123->93|123->93|125->95|125->95|126->96|126->96|128->98|128->98|138->108|138->108|138->108|138->108|138->108|138->108|138->108|138->108|138->108|139->109|139->109|141->111|141->111|141->111|141->111|141->111|141->111|141->111|141->111|141->111|142->112|142->112|145->115|145->115|145->115|145->115|148->118|148->118|156->126|156->126|157->127|157->127|160->130|160->130|161->131|161->131|162->132|162->132|165->135|165->135|166->136|166->136|167->137|167->137|167->137|167->137|167->137|167->137|169->139|169->139|171->141|171->141|172->142|172->142|174->144|174->144|175->145|175->145|176->146|176->146|176->146|176->146|178->148|178->148|178->148|178->148|178->148|178->148|178->148|178->148|178->148|180->150|180->150|182->152|182->152|182->152|182->152|184->154|184->154|186->156|186->156|187->157|187->157|188->158|188->158|189->159|189->159|195->165|195->165|198->168|198->168|200->170|200->170|203->173|203->173|206->176|206->176
                    -- GENERATED --
                */
            