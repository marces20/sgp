
package views.html.dashboard.informeEstadisticoDeudaProveedores

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
object informeDeudaPorActas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/multiplica/*5.12*/(a:BigDecimal,b:BigDecimal):play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.43*/("""
	"""),_display_(Seq[Any](/*6.3*/(a * b))),format.raw/*6.10*/("""
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.118*/("""
"""),format.raw/*3.70*/(""" 

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.dashboard.mainDashboard(title = "Informe estadistico")/*9.67*/ {_display_(Seq[Any](format.raw/*9.69*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Informe de deuda por actas</h1>
		</div>

		<div class="col-sm-3">
			<a id="generarArchivo" href=""""),_display_(Seq[Any](/*18.34*/controllers/*18.45*/.dashboard.routes.InformeDeudaPorActasController.archivoDeudaPorActas())),format.raw/*18.116*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-download-alt"></i> Generar archivo</a>
		</div>

	</div>
</div>


<script>

$( function() """),format.raw/*27.15*/("""{"""),format.raw/*27.16*/("""
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
	
	/*
	$('#generarArchivo').click( function() """),format.raw/*32.41*/("""{"""),format.raw/*32.42*/("""
		
		var href = $(this).attr('href') + '?descarga=&' + escape(window.location.href.slice(window.location.href.indexOf('?') + 1).split('&'));
		alert(href);
		window.location = href;
		return false;
	"""),format.raw/*38.2*/("""}"""),format.raw/*38.3*/(""");
	*/
"""),format.raw/*40.1*/("""}"""),format.raw/*40.2*/(""");

</script>




"""),_display_(Seq[Any](/*47.2*/if(flash.containsKey("success"))/*47.34*/ {_display_(Seq[Any](format.raw/*47.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*48.80*/flash/*48.85*/.get("success"))),format.raw/*48.100*/("""</div>
""")))})),format.raw/*49.2*/("""
"""),_display_(Seq[Any](/*50.2*/if(flash.containsKey("error"))/*50.32*/ {_display_(Seq[Any](format.raw/*50.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*51.83*/flash/*51.88*/.get("error"))),format.raw/*51.101*/("""</div>
""")))})),format.raw/*52.2*/(""" 


    <form action="" method="GET" id="filtroInforme">
		<div class="row seccion">
			
		<div class="form-group col-sm-2">
			<label for="nombre" class="control-label">Numero
			"""),_display_(Seq[Any](/*60.5*/inputText(formBuscador("acta_numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*60.96*/("""
			</label>
		</div>
	
		<div class="form-group col-sm-2">
			<label for="nombre" class="control-label">Orden provisión
			"""),_display_(Seq[Any](/*66.5*/inputText(formBuscador("orden_provision"), 'class -> "form-control"))),format.raw/*66.73*/("""
			</label>
		</div>
			
		<div class="col-sm-4">
			<label class="control-label">Proveedor
				<div class="input-group">	
					"""),_display_(Seq[Any](/*73.7*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*73.109*/("""
					"""),_display_(Seq[Any](/*74.7*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*74.90*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*79.21*/controllers/*79.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*79.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor" 
									data-field="#proveedor_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>
			
			<div class="col-sm-2">
				<label class="control-label">Expediente
					<div class="input-group">
						"""),_display_(Seq[Any](/*95.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*95.112*/("""
						"""),_display_(Seq[Any](/*96.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*96.93*/("""
						
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*102.22*/controllers/*102.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*102.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
			</div>  
				
			<div class="col-sm-2">
				<label class="control-label">Ejercicio</label>
					"""),_display_(Seq[Any](/*117.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*117.166*/("""
			</div>	
			
	</div>
	
	<div class="row">
		<!--  <div class="col-sm-2">
			<label class="control-label"> 
				Cuenta
				"""),_display_(Seq[Any](/*126.6*/select(formBuscador("profe"),options(""->"Todos","profe"->"PROFE","operativa"->"OPERATIVA"), 'class -> "form-control select"))),format.raw/*126.131*/("""
			</label>
		</div>-->
		<div class="col-sm-2 input-group">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*132.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*133.126*/("""
			</label>
		</div>
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="mayor_a">Deuda entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*140.7*/inputText(formBuscador("deuda_mayor"), 'class -> "form-control", 'id -> "mayor_a", 'placeholder -> "Mayor a"))),format.raw/*140.116*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*142.10*/inputText(formBuscador("deuda_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*142.101*/("""
				</div>
			</div>
		</div>	
		
				
		<div class="col-sm-2">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*151.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*151.123*/("""
				"""),_display_(Seq[Any](/*152.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*152.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*155.29*/controllers/*155.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*155.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-sm-3">
				<label class="control-label"> 
					Tipo
					"""),_display_(Seq[Any](/*166.7*/select(formBuscador("tipo_acta"),options(""->"Ambos","acta"->"Actas","CC"->"Certificaciones","Anticipo"->"Anticipos"), 'class -> "form-control select"))),format.raw/*166.158*/("""
				</label>
			</div>
			<div class="col-sm-3">
				<label class="control-label">Moneda</label>
				<div class="form-group">
					"""),_display_(Seq[Any](/*172.7*/select(formBuscador("tipo_moneda"),TipoMoneda.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*172.163*/("""
				</div>
			</div>		
			<div class="col-sm-3">
				<div class="checkbox">
					<label class="control-label"> 
						Sólo dolar
						"""),_display_(Seq[Any](/*179.8*/checkbox(formBuscador("dolar")))),format.raw/*179.39*/("""
					</label><br>
				</div>
			</div>
			<div class="col-sm-3">
				<label class="control-label"> 
					Emergencia
					"""),_display_(Seq[Any](/*186.7*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*186.112*/("""
				</label>
			</div>	
		</div>	
	</div>
	
	<div class="row">
		
	</div>	
			
	<div class="row">		
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<button  class="form-control btn btn-primary">Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<a href=""""),_display_(Seq[Any](/*206.14*/controllers/*206.25*/.dashboard.routes.InformeDeudaPorActasController.index())),format.raw/*206.81*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
			
		</div>
    </form>
    """),_display_(Seq[Any](/*212.6*/if(buscador.getTotalRowCount == 0)/*212.40*/ {_display_(Seq[Any](format.raw/*212.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*218.7*/else/*218.12*/{_display_(Seq[Any](format.raw/*218.13*/("""
		
		<table class="table table-striped table-bordered" id="listaInforme">
			<thead>
				<tr style="background: #FFFFFF;">
					<td colspan="9">
						Mostrando """),_display_(Seq[Any](/*224.18*/buscador/*224.26*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*224.58*/(""" resultado(s).   
					</td>
					<td><b>Total:</b><br /><span class="actaFooter"></span></td>
					<td><b>Total:</b><br /><span class="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="deudaFooter"></span></td>
				</tr>
				<tr>
					<th>Acta</th>
					<th>Ejercicio</th>
					<th>Institucion</th>
					<th>Rubro</th>
					<th>Fecha acta</th>
					<th width="30">Cuenta</th>
					<th width="40">OP</th>
					<th>Proveedor</th>
					<th width="90">Expediente</th>
					<th>Total acta</th>
					<th>Total autorizado</th>
					<th width="90">Total pagado</th>
					<th width="90">Total deuda</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*248.12*/for(informe <- buscador.getList) yield /*248.44*/ {_display_(Seq[Any](format.raw/*248.46*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*250.11*/informe/*250.18*/.acta_numero)),format.raw/*250.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*251.11*/if(informe.ejercicio != null)/*251.40*/{_display_(Seq[Any](_display_(Seq[Any](/*251.42*/informe/*251.49*/.ejercicio.nombre))))})),format.raw/*251.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*252.11*/informe/*252.18*/.ordenCompra.deposito.nombre)),format.raw/*252.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*253.11*/if(informe.ordenCompra.ordenRubro != null)/*253.53*/{_display_(Seq[Any](_display_(Seq[Any](/*253.55*/informe/*253.62*/.ordenCompra.ordenRubro.nombre))))})),format.raw/*253.93*/("""</td>
					<td>"""),_display_(Seq[Any](/*254.11*/utils/*254.16*/.DateUtils.formatDate(informe.fecha))),format.raw/*254.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*255.11*/if(informe.tipoCuenta != null)/*255.41*/{_display_(Seq[Any](_display_(Seq[Any](/*255.43*/informe/*255.50*/.tipoCuenta.nombre))))})),format.raw/*255.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*256.11*/if(informe.ordenProvision != null)/*256.45*/{_display_(Seq[Any](_display_(Seq[Any](/*256.47*/informe/*256.54*/.ordenProvision.numero))))})),format.raw/*256.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*257.11*/informe/*257.18*/.proveedor.nombre)),format.raw/*257.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*258.11*/informe/*258.18*/.expediente.getExpedienteEjercicio())),format.raw/*258.54*/("""<br>
						"""),_display_(Seq[Any](/*259.8*/if(informe.expediente.emergencia)/*259.41*/{_display_(Seq[Any](format.raw/*259.42*/("""
							<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
						""")))})),format.raw/*261.8*/("""
					</td>
					<td class="totalActa" data-valor=""""),_display_(Seq[Any](/*263.41*/informe/*263.48*/.totalActa)),format.raw/*263.58*/("""">"""),_display_(Seq[Any](/*263.61*/utils/*263.66*/.NumberUtils.moneda(informe.totalActa))),format.raw/*263.104*/("""</td>
					<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*264.47*/informe/*264.54*/.totalAutorizado)),format.raw/*264.70*/("""">"""),_display_(Seq[Any](/*264.73*/utils/*264.78*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*264.122*/("""</td>
					<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*265.43*/informe/*265.50*/.totalPagado)),format.raw/*265.62*/("""">"""),_display_(Seq[Any](/*265.65*/utils/*265.70*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*265.110*/("""</td>
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*266.42*/informe/*266.49*/.totalDeuda)),format.raw/*266.60*/("""">
							
							"""),_display_(Seq[Any](/*268.9*/utils/*268.14*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*268.53*/("""
							
						
					
					</td>					
				</tr>
		        """)))})),format.raw/*274.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="9"></td>
					<td><b>Total:</b><br /><span class="actaFooter"></span></td>
					<td><b>Total:</b><br /><span class="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="deudaFooter"></span></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*287.8*/views/*287.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.InformeDeudaPorActasController.index()))),format.raw/*287.115*/("""
		</div>
	""")))})),format.raw/*289.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*293.16*/("""{"""),format.raw/*293.17*/("""
		$('#searchExpediente, #searchProveedor').modalSearch();
		$('.actas').click( function() """),format.raw/*295.33*/("""{"""),format.raw/*295.34*/("""
			var $this = $(this);
			var url = $this.attr('href');
			var oid = $(this).data('data-id-provision');
			$.get(url, function(data) """),format.raw/*299.30*/("""{"""),format.raw/*299.31*/("""
				$this.parent().html(data);
			"""),format.raw/*301.4*/("""}"""),format.raw/*301.5*/(""");
			return false;
		"""),format.raw/*303.3*/("""}"""),format.raw/*303.4*/(""");
		
		var trs = $('#listaInforme tbody tr');

		var orden = 0;var autorizado = 0; var pagado = 0; var deuda = 0; var compromiso = 0;
		
		trs.each( function() """),format.raw/*309.24*/("""{"""),format.raw/*309.25*/("""
			orden += Number($('.totalActa',this).attr("data-valor"));
			autorizado += Number($('.totalAutorizado',this).attr("data-valor"));
			pagado += Number($('.totalPagado',this).attr("data-valor"));
			deuda += Number($('.totalDeuda',this).attr("data-valor"));
		"""),format.raw/*314.3*/("""}"""),format.raw/*314.4*/(""");

		$(".actaFooter").html(formatNumberPesos(parseFloat(orden).toFixed(2)));
		$(".autorizadoFooter").html(formatNumberPesos(parseFloat(autorizado).toFixed(2)));
		$(".pagadoFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
		$(".deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
		
	"""),format.raw/*321.2*/("""}"""),format.raw/*321.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.informes.InformeDeudaPorActaMaterializada],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoDeudaProveedores/informeDeudaPorActas.scala.html
                    HASH: 1134308d6085a5b47b24f7f278a97d5fe77ffc56
                    MATRIX: 917->1|1127->212|1145->222|1256->253|1294->257|1322->264|1356->138|1388->162|1463->117|1492->206|1523->267|1562->272|1574->277|1642->337|1681->339|1909->531|1929->542|2023->613|2207->769|2236->770|2493->999|2522->1000|2755->1206|2783->1207|2819->1216|2847->1217|2908->1243|2949->1275|2989->1277|3106->1358|3120->1363|3158->1378|3198->1387|3236->1390|3275->1420|3315->1422|3435->1506|3449->1511|3485->1524|3525->1533|3749->1722|3862->1813|4028->1944|4118->2012|4290->2149|4415->2251|4458->2259|4563->2342|4780->2523|4800->2534|4873->2585|5328->3005|5455->3109|5499->3118|5606->3203|5837->3397|5858->3408|5935->3462|6382->3873|6565->4032|6736->4167|6885->4292|7044->4415|7234->4581|7435->4746|7568->4855|7663->4913|7778->5004|7990->5180|8131->5297|8174->5304|8277->5384|8471->5541|8492->5552|8567->5604|9002->6003|9177->6154|9352->6293|9532->6449|9712->6593|9766->6624|9932->6754|10061->6859|10542->7303|10563->7314|10642->7370|10785->7477|10829->7511|10870->7513|11010->7635|11024->7640|11064->7641|11270->7810|11288->7818|11343->7850|12134->8604|12183->8636|12224->8638|12283->8660|12300->8667|12335->8679|12389->8696|12428->8725|12477->8727|12494->8734|12539->8752|12593->8769|12610->8776|12661->8804|12715->8821|12767->8863|12816->8865|12833->8872|12891->8903|12945->8920|12960->8925|13019->8961|13073->8978|13113->9008|13162->9010|13179->9017|13225->9036|13279->9053|13323->9087|13372->9089|13389->9096|13439->9119|13493->9136|13510->9143|13550->9160|13604->9177|13621->9184|13680->9220|13729->9233|13772->9266|13812->9267|13938->9361|14029->9415|14046->9422|14079->9432|14119->9435|14134->9440|14196->9478|14286->9531|14303->9538|14342->9554|14382->9557|14397->9562|14465->9606|14551->9655|14568->9662|14603->9674|14643->9677|14658->9682|14722->9722|14807->9770|14824->9777|14858->9788|14915->9809|14930->9814|14992->9853|15090->9918|15550->10342|15565->10347|15691->10449|15737->10463|15823->10520|15853->10521|15975->10614|16005->10615|16173->10754|16203->10755|16268->10792|16297->10793|16349->10817|16378->10818|16574->10985|16604->10986|16899->11253|16928->11254|17282->11580|17311->11581
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|48->18|48->18|48->18|57->27|57->27|62->32|62->32|68->38|68->38|70->40|70->40|77->47|77->47|77->47|78->48|78->48|78->48|79->49|80->50|80->50|80->50|81->51|81->51|81->51|82->52|90->60|90->60|96->66|96->66|103->73|103->73|104->74|104->74|109->79|109->79|109->79|125->95|125->95|126->96|126->96|132->102|132->102|132->102|147->117|147->117|156->126|156->126|162->132|163->133|170->140|170->140|172->142|172->142|181->151|181->151|182->152|182->152|185->155|185->155|185->155|196->166|196->166|202->172|202->172|209->179|209->179|216->186|216->186|236->206|236->206|236->206|242->212|242->212|242->212|248->218|248->218|248->218|254->224|254->224|254->224|278->248|278->248|278->248|280->250|280->250|280->250|281->251|281->251|281->251|281->251|281->251|282->252|282->252|282->252|283->253|283->253|283->253|283->253|283->253|284->254|284->254|284->254|285->255|285->255|285->255|285->255|285->255|286->256|286->256|286->256|286->256|286->256|287->257|287->257|287->257|288->258|288->258|288->258|289->259|289->259|289->259|291->261|293->263|293->263|293->263|293->263|293->263|293->263|294->264|294->264|294->264|294->264|294->264|294->264|295->265|295->265|295->265|295->265|295->265|295->265|296->266|296->266|296->266|298->268|298->268|298->268|304->274|317->287|317->287|317->287|319->289|323->293|323->293|325->295|325->295|329->299|329->299|331->301|331->301|333->303|333->303|339->309|339->309|344->314|344->314|351->321|351->321
                    -- GENERATED --
                */
            