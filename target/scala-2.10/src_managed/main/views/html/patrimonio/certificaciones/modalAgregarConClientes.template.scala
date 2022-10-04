
package views.html.patrimonio.certificaciones

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
object modalAgregarConClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[java.util.Map[Integer, List[com.avaje.ebean.SqlRow]],java.util.Map[Integer, java.math.BigDecimal],java.util.Map[Integer, String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineas:java.util.Map[Integer,List[com.avaje.ebean.SqlRow]],
lineaTotalDisponble:java.util.Map[Integer,java.math.BigDecimal],
lineaProducto:java.util.Map[Integer,String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var hayDisponibles:Boolean = new Boolean(false);

implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*3.45*/("""
"""),format.raw/*7.70*/(""" 
"""),format.raw/*9.1*/("""<div class="col-sm-12">
	<div class="panel panel-default">
		<div class="panel-heading"><b>Lineas con Pacientes</b></div>
		<div class="panel-body">
			<div class="row">
				<table class="table table-bordered table-hover" id="">
					"""),_display_(Seq[Any](/*15.7*/for((key,value) <- lineas) yield /*15.33*/{_display_(Seq[Any](format.raw/*15.34*/("""
						"""),_display_(Seq[Any](/*16.8*/{hayDisponibles = new Boolean(false)})),format.raw/*16.45*/("""
						<thead>
							<tr><td align="center" colspan="4"><b>"""),_display_(Seq[Any](/*18.47*/lineaProducto/*18.60*/.get(key))),format.raw/*18.69*/("""</b></td></tr>
							<tr>
								<td>id-Paciente</td>
								<td>Nombre</td>
								<td>Cantidad Disponible</td>
								<td></td>
							</tr>
						</thead>
						<tbody class="bodyTablasACargar">
							<input id="" type="hidden" value=""""),_display_(Seq[Any](/*27.43*/key)),format.raw/*27.46*/("""" name="linea_orden_id_clientemodal" />
							"""),_display_(Seq[Any](/*28.9*/for(p <- value) yield /*28.24*/{_display_(Seq[Any](format.raw/*28.25*/("""
								"""),_display_(Seq[Any](/*29.10*/if(p.getBigDecimal("cantidad").compareTo(java.math.BigDecimal.ZERO) > 0)/*29.82*/{_display_(Seq[Any](format.raw/*29.83*/("""
									<tr class="tr-carga-pacientes-cantidad">
										<td><b>"""),_display_(Seq[Any](/*31.19*/p/*31.20*/.getString("idPacienteRismi"))),format.raw/*31.49*/("""</b></td>
										<td><b>"""),_display_(Seq[Any](/*32.19*/p/*32.20*/.getString("nombreCliente"))),format.raw/*32.47*/("""</b></td>
										<td><b>"""),_display_(Seq[Any](/*33.19*/p/*33.20*/.getBigDecimal("cantidad"))),format.raw/*33.46*/("""</b></td>
										<td>
										<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*35.81*/p/*35.82*/.getBigDecimal("""cantidad"""))),format.raw/*35.112*/(""""" style="width: 60px" />
										 
										</td>
										<input class="cantidadCargaInicial" type="hidden" name="cantidadCargaInicial" value=""""),_display_(Seq[Any](/*38.97*/p/*38.98*/.getBigDecimal("""cantidad"""))),format.raw/*38.128*/("""""/>
										<input class="cliente_id" type="hidden" name="cliente_id" value=""""),_display_(Seq[Any](/*39.77*/p/*39.78*/.getLong("""cliente_id"""))),format.raw/*39.104*/(""""" />
										
									</tr>
									"""),_display_(Seq[Any](/*42.11*/{hayDisponibles = new Boolean(true)})),format.raw/*42.47*/("""
								""")))})),format.raw/*43.10*/("""
							""")))})),format.raw/*44.9*/("""
							"""),_display_(Seq[Any](/*45.9*/if(lineaTotalDisponble.get(key) != null && lineaTotalDisponble.get(key).compareTo(java.math.BigDecimal.ZERO) > 0)/*45.122*/{_display_(Seq[Any](format.raw/*45.123*/("""
								<tr class="tr-carga-pacientes-cantidad">
									<td><b>SIN PACIENTE</b></td>
									<td><b></b></td>
									<td><b>"""),_display_(Seq[Any](/*49.18*/lineaTotalDisponble/*49.37*/.get(key))),format.raw/*49.46*/("""</b></td>
									<td>
									<input class="cantidadCarga" type="text" name="cantidadCarga" value=""""),_display_(Seq[Any](/*51.80*/lineaTotalDisponble/*51.99*/.get(key))),format.raw/*51.108*/("""" style="width: 60px" />
									</td>
									<input class="cantidadCargaInicial" type="hidden" name="cantidadCargaInicial" value=""""),_display_(Seq[Any](/*53.96*/lineaTotalDisponble/*53.115*/.get(key))),format.raw/*53.124*/(""""/>
									<input class="cliente_id" type="hidden" name="cliente_id" value="0" />
								</tr>
								"""),_display_(Seq[Any](/*56.10*/{hayDisponibles = new Boolean(true)})),format.raw/*56.46*/("""
							""")))})),format.raw/*57.9*/("""
							
							"""),_display_(Seq[Any](/*59.9*/if(!hayDisponibles:Boolean)/*59.36*/{_display_(Seq[Any](format.raw/*59.37*/("""
								<tr class="tr-carga-pacientes-cantidad">
									<td colspan="4" align="center"><b style="color:red">NO HAY CANTIDAD DISPONIBLE PARA ESTE PRODUCTO</b></td>
								</tr>
							""")))})),format.raw/*63.9*/("""
							
						</tbody>
					""")))})),format.raw/*66.7*/("""
					
					
				</table>
			</div>
			<div class="row" >
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<button class="agregarConClienteConCertificacion"  
						data-url=""""),_display_(Seq[Any](/*75.18*/controllers/*75.29*/.patrimonio.routes.CertificacionesServiciosController.agregarLineasConCliente())),format.raw/*75.108*/("""">CREAR CERTIFICACION</button>
				</div>
			</div>
		</div>
	</div>	
</div>
<script>
$( function() """),format.raw/*82.15*/("""{"""),format.raw/*82.16*/("""
	$(".cantidadCarga").numeric_input();
	
	$(document).on('click', '.agregarConClienteConCertificacion', function()"""),format.raw/*85.74*/("""{"""),format.raw/*85.75*/("""
	 
		$this = $(this);
		$this.prop('disabled', true);
		var tr = $(this).closest('tr');
		var url = $(this).attr('data-url');
		/*var idRemito = $('#remitoId').val();*/
		
		var idOrdenProvision = $('#idOrdenProvision').val();
		var datos = new Array();
		var cantidadTotalOrden = 0; 
		$(".bodyTablasACargar").each(function()"""),format.raw/*96.42*/("""{"""),format.raw/*96.43*/("""
			/*alert($(this).find("input[name='linea_orden_id_clientemodal']").val());*/
			
			
			var arrayProperties = new Array();
			
			var cantidadTotal = 0; 
			$(this).find(".tr-carga-pacientes-cantidad").each(function()"""),format.raw/*103.64*/("""{"""),format.raw/*103.65*/("""
				/*alert($(this).find("input[name='cantidadCarga']").val());*/
				
				var datosLinea = new Object();
				datosLinea.clienteId = $(this).find("input[name='cliente_id']").val();
				datosLinea.cantidad = $(this).find("input[name='cantidadCargaInicial']").val();
				datosLinea.cantidadCargar = $(this).find("input[name='cantidadCarga']").val();
				arrayProperties.push(datosLinea);
				
				if($(this).find("input[name='cantidadCarga']").val() != '')"""),format.raw/*112.64*/("""{"""),format.raw/*112.65*/("""
					cantidadTotal = parseFloat(cantidadTotal)+parseFloat($(this).find("input[name='cantidadCarga']").val());
					cantidadTotalOrden = parseFloat(cantidadTotalOrden)+parseFloat($(this).find("input[name='cantidadCarga']").val());
				"""),format.raw/*115.5*/("""}"""),format.raw/*115.6*/("""
				
			"""),format.raw/*117.4*/("""}"""),format.raw/*117.5*/(""")
			
			
			var linea = new Object();
			linea.linea_orden_id = $(this).find("input[name='linea_orden_id_clientemodal']").val();
			linea.cantidadTotal = cantidadTotal;
			linea.datosLinea = arrayProperties;
			if(cantidadTotal > 0)"""),format.raw/*124.25*/("""{"""),format.raw/*124.26*/("""
				datos.push(linea);
			"""),format.raw/*126.4*/("""}"""),format.raw/*126.5*/("""
		"""),format.raw/*127.3*/("""}"""),format.raw/*127.4*/(""");
		
		var datosi = new Object();
		datosi.datos = datos;
		datosi.idOrdenProvision = idOrdenProvision;
		datosi.cantidadTotalOrden = cantidadTotalOrden;
		var myString = JSON.stringify(datosi);
		
		
		/*alert(myString);*/
		/*var linea_orden_id = $('#linea_orden_id_clientemodal').val();
		var cantidadCargar = tr.find('.cantidadCarga').val();
		var cantidad = $(this).attr('data-cantidad');
		var clienteId = $(this).attr('data-clienteId');
		
		
		var datosLinea = new Object();
		datosLinea.clienteId = 1;
		datosLinea.cantidad = 1;
		datosLinea.cantidadCargar = 1;
		 
		var arrayProperties = new Array();
		arrayProperties.push(datosLinea);
		 
		
		var linea = new Object();
		linea.linea_orden_id = 2;
		linea.cantidadTotal = 2;
		linea.datosLinea = arrayProperties;
		
		var linea2 = new Object();
		linea2.linea_orden_id = 22;
		linea2.cantidadTotal = 22;
		linea2.datosLinea = arrayProperties;
		
		var linea3 = new Object();
		linea3.linea_orden_id = 222;
		linea3.cantidadTotal = 222;
		linea3.datosLinea = arrayProperties;
		
		var datos = new Array();
		datos.push(linea);
		datos.push(linea2);
		datos.push(linea3);
		
		var datosi = new Object();
		datosi.datos = datos;
		
		var myString = JSON.stringify(datosi);
		
		*/
		
		$.ajax("""),format.raw/*179.10*/("""{"""),format.raw/*179.11*/("""
	        url: url,
	        type: "post",
	        data:  myString,
	        contentType: "application/json",
	        dataType: "json",
	        success: function(data)"""),format.raw/*185.33*/("""{"""),format.raw/*185.34*/("""
	        	if(data.success)"""),format.raw/*186.27*/("""{"""),format.raw/*186.28*/("""
					window.location = '/patrimonio/certificaciones/editar?id='+data.idCertificacionServicio;	
					
				"""),format.raw/*189.5*/("""}"""),format.raw/*189.6*/("""else"""),format.raw/*189.10*/("""{"""),format.raw/*189.11*/("""
					alert(data.error);
					$this.prop('disabled', false);
					return false; 
				"""),format.raw/*193.5*/("""}"""),format.raw/*193.6*/("""
	        	
	        """),format.raw/*195.10*/("""}"""),format.raw/*195.11*/(""",
	        error:function()"""),format.raw/*196.26*/("""{"""),format.raw/*196.27*/("""
	        	$this.prop('disabled', false);
	        """),format.raw/*198.10*/("""}"""),format.raw/*198.11*/("""
	    """),format.raw/*199.6*/("""}"""),format.raw/*199.7*/(""");
		return false; 
	"""),format.raw/*201.2*/("""}"""),format.raw/*201.3*/(""");
	
"""),format.raw/*203.1*/("""}"""),format.raw/*203.2*/(""");
</script>

"""))}
    }
    
    def render(lineas:java.util.Map[Integer, List[com.avaje.ebean.SqlRow]],lineaTotalDisponble:java.util.Map[Integer, java.math.BigDecimal],lineaProducto:java.util.Map[Integer, String]): play.api.templates.HtmlFormat.Appendable = apply(lineas,lineaTotalDisponble,lineaProducto)
    
    def f:((java.util.Map[Integer, List[com.avaje.ebean.SqlRow]],java.util.Map[Integer, java.math.BigDecimal],java.util.Map[Integer, String]) => play.api.templates.HtmlFormat.Appendable) = (lineas,lineaTotalDisponble,lineaProducto) => apply(lineas,lineaTotalDisponble,lineaProducto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/modalAgregarConClientes.scala.html
                    HASH: 6d0b76aca2cfd97b674fddb872346d305bb45419
                    MATRIX: 941->1|1329->228|1361->252|1435->171|1463->296|1491->376|1761->611|1803->637|1842->638|1885->646|1944->683|2041->744|2063->757|2094->766|2375->1011|2400->1014|2483->1062|2514->1077|2553->1078|2599->1088|2680->1160|2719->1161|2824->1230|2834->1231|2885->1260|2949->1288|2959->1289|3008->1316|3072->1344|3082->1345|3130->1371|3271->1476|3281->1477|3334->1507|3520->1657|3530->1658|3583->1688|3700->1769|3710->1770|3759->1796|3837->1838|3895->1874|3937->1884|3977->1893|4021->1902|4144->2015|4184->2016|4351->2147|4379->2166|4410->2175|4549->2278|4577->2297|4609->2306|4780->2441|4809->2460|4841->2469|4984->2576|5042->2612|5082->2621|5134->2638|5170->2665|5209->2666|5428->2854|5489->2884|5717->3076|5737->3087|5839->3166|5967->3266|5996->3267|6138->3381|6167->3382|6522->3709|6551->3710|6800->3930|6830->3931|7314->4386|7344->4387|7607->4622|7636->4623|7673->4632|7702->4633|7964->4866|7994->4867|8049->4894|8078->4895|8109->4898|8138->4899|9421->6153|9451->6154|9650->6324|9680->6325|9736->6352|9766->6353|9900->6459|9929->6460|9962->6464|9992->6465|10105->6550|10134->6551|10184->6572|10214->6573|10270->6600|10300->6601|10380->6652|10410->6653|10444->6659|10473->6660|10522->6681|10551->6682|10584->6687|10613->6688
                    LINES: 26->1|37->7|37->7|38->3|39->7|40->9|46->15|46->15|46->15|47->16|47->16|49->18|49->18|49->18|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|66->35|66->35|66->35|69->38|69->38|69->38|70->39|70->39|70->39|73->42|73->42|74->43|75->44|76->45|76->45|76->45|80->49|80->49|80->49|82->51|82->51|82->51|84->53|84->53|84->53|87->56|87->56|88->57|90->59|90->59|90->59|94->63|97->66|106->75|106->75|106->75|113->82|113->82|116->85|116->85|127->96|127->96|134->103|134->103|143->112|143->112|146->115|146->115|148->117|148->117|155->124|155->124|157->126|157->126|158->127|158->127|210->179|210->179|216->185|216->185|217->186|217->186|220->189|220->189|220->189|220->189|224->193|224->193|226->195|226->195|227->196|227->196|229->198|229->198|230->199|230->199|232->201|232->201|234->203|234->203
                    -- GENERATED --
                */
            