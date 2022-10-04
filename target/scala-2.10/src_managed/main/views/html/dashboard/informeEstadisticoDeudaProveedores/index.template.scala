
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*6.2*/getActas/*6.10*/(orden_provision_id:Long) = {{
	var num:String = new String()
    for(a <- ActaRecepcion.find.fetch("ejercicio", "nombre").select("numero").where().eq("orden_provision_id", orden_provision_id).findList() ) {num += a.numero+"/"+a.ejercicio.nombre+", "}
	num.replaceAll(", $", "");
}};
Seq[Any](format.raw/*1.122*/("""
"""),format.raw/*3.70*/(""" 


"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.dashboard.mainDashboard(title = "Informe estadístico")/*12.67*/ {_display_(Seq[Any](format.raw/*12.69*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Informe estadístico de deuda a proveedores</h1>
		</div>

		<div class="col-sm-3">
			<a id="generarArchivo" href=""""),_display_(Seq[Any](/*21.34*/controllers/*21.45*/.dashboard.routes.InformeEstadisticoDeudaProveedoresController.archivoEstadistico())),format.raw/*21.128*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-download-alt"></i> Generar archivo</a>
		</div>

	</div>
</div>


<script>

$( function() """),format.raw/*30.15*/("""{"""),format.raw/*30.16*/("""
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
	
	/*
	$('#generarArchivo').click( function() """),format.raw/*35.41*/("""{"""),format.raw/*35.42*/("""
		
		var href = $(this).attr('href') + '?descarga=&' + escape(window.location.href.slice(window.location.href.indexOf('?') + 1).split('&'));
		alert(href);
		window.location = href;
		return false;
	"""),format.raw/*41.2*/("""}"""),format.raw/*41.3*/(""");
	*/
"""),format.raw/*43.1*/("""}"""),format.raw/*43.2*/(""");

</script>




"""),_display_(Seq[Any](/*50.2*/if(flash.containsKey("success"))/*50.34*/ {_display_(Seq[Any](format.raw/*50.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*51.80*/flash/*51.85*/.get("success"))),format.raw/*51.100*/("""</div>
""")))})),format.raw/*52.2*/("""
"""),_display_(Seq[Any](/*53.2*/if(flash.containsKey("error"))/*53.32*/ {_display_(Seq[Any](format.raw/*53.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*54.83*/flash/*54.88*/.get("error"))),format.raw/*54.101*/("""</div>
""")))})),format.raw/*55.2*/(""" 


    <form action="" method="GET" id="filtroInforme">
		<div class="row seccion">
			
			
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">	
						"""),_display_(Seq[Any](/*65.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*65.137*/("""
						"""),_display_(Seq[Any](/*66.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*66.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*71.22*/controllers/*71.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*71.84*/("""" 
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
						"""),_display_(Seq[Any](/*87.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*87.112*/("""
						"""),_display_(Seq[Any](/*88.8*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*88.93*/("""
						
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*94.22*/controllers/*94.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*94.87*/("""" 
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
					"""),_display_(Seq[Any](/*109.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*109.166*/("""
				
			</div>	
			
			<div class="col-sm-2">
				<div class="seleccionOrdenRubro">
					<label for=""""),_display_(Seq[Any](/*115.19*/formBuscador("rubro_id")/*115.43*/.id)),format.raw/*115.46*/("""" class="control-label">Rubro</label>
					"""),_display_(Seq[Any](/*116.7*/select(formBuscador("rubro_id"), 
					OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}
					
					, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*119.68*/("""
				</div>
			</div>

		<!-- <div class="col-sm-2">
			<label class="control-label"> 
				Cuenta
				"""),_display_(Seq[Any](/*126.6*/select(formBuscador("profe"),options(""->"Todos","profe"->"PROFE","operativa"->"OPERATIVA"), 'class -> "form-control select"))),format.raw/*126.131*/("""
			</label>
		</div> -->
		
		<div class="col-sm-2">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*133.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*133.123*/("""
				"""),_display_(Seq[Any](/*134.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*134.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*137.29*/controllers/*137.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*137.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
		</div>
		<div class="col-sm-2 input-group">
			<label class="control-label"> 
				Tipo Cuenta
				"""),_display_(Seq[Any](/*147.6*/select(formBuscador("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*148.126*/("""
			</label>
		</div>
			
	</div>
	
	<div class="row">
	
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="mayor_a">Deuda entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*160.7*/inputText(formBuscador("deuda_mayor"), 'class -> "form-control", 'id -> "mayor_a", 'placeholder -> "Mayor a"))),format.raw/*160.116*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*162.10*/inputText(formBuscador("deuda_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*162.101*/("""
				</div>
			</div>
		</div>			
			
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="pago_ma">Pago entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*171.7*/inputText(formBuscador("pago_mayor"), 'class -> "form-control", 'id -> "pago_ma", 'placeholder -> "Mayor a"))),format.raw/*171.115*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*173.10*/inputText(formBuscador("pago_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*173.100*/("""
				</div>
			</div>
		</div>			
			
		<div class="col-sm-2">		
			<div class="form-group">
				<label for="compromiso_ma">Compromiso entre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*182.7*/inputText(formBuscador("compromiso_mayor"), 'class -> "form-control", 'id -> "compromiso_ma", 'placeholder -> "Mayor a"))),format.raw/*182.127*/("""
					<div class="input-group-addon"> y </div>
		    		"""),_display_(Seq[Any](/*184.10*/inputText(formBuscador("compromiso_menor"), 'class -> "form-control", 'placeholder -> "Menor a"))),format.raw/*184.106*/("""
				</div>
			</div>
		</div>		
		
			
			
		<div class="col-sm-2">
			<label class="control-label">Moneda</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*194.6*/select(formBuscador("tipo_moneda"),TipoMoneda.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*194.162*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="col-sm-4">
				<div class="checkbox">
					<label class="control-label"> 
						Con monto adelanto
						"""),_display_(Seq[Any](/*202.8*/checkbox(formBuscador("monto_adelanto")))),format.raw/*202.48*/("""
					</label><br>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="checkbox">
					<label class="control-label"> 
						Acta Menor a Pago
						"""),_display_(Seq[Any](/*210.8*/checkbox(formBuscador("acta_sin_adelanto_menor_pago")))),format.raw/*210.62*/("""
					</label><br>
				</div>
			</div>	
			<div class="col-sm-2">
				<label class="control-label"> 
					Emergencia
					"""),_display_(Seq[Any](/*217.7*/select(formBuscador("emergencia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*217.112*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label"> 
					Perimido
					"""),_display_(Seq[Any](/*223.7*/select(formBuscador("perimido"),options("NO"->"NO","SI"->"SI"), 'class -> "form-control select"))),format.raw/*223.103*/("""
				</label>
			</div>
		</div>
	</div>
		
		
	 
		
	<div class="row">
		<div class="col-sm-4">
			<div class="col-sm-6">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary">Buscar</button>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*243.15*/controllers/*243.26*/.dashboard.routes.InformeEstadisticoDeudaProveedoresController.index())),format.raw/*243.96*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
	</div>
		 

	 
		
		
    </form>
    """),_display_(Seq[Any](/*254.6*/if(buscador.getTotalRowCount == 0)/*254.40*/ {_display_(Seq[Any](format.raw/*254.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*260.7*/else/*260.12*/{_display_(Seq[Any](format.raw/*260.13*/("""
		 
		<table class="table table-striped table-bordered" id="listaInforme">
			<thead>
				<tr style="background: #FFFFFF;">
					<td colspan="6">
						Mostrando """),_display_(Seq[Any](/*266.18*/buscador/*266.26*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*266.58*/(""" resultado(s).  
					</td>
					<td><b>Total:</b><br /><span class="ordenFooter"></span></td>
					<td><b>Total:</b><br /><span class="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="deudaFooter"></span></td>
					<td><b>Total:</b><br /><span class="compromisoFooter"></span></td>
					<td></td>
				</tr>
				<tr>
					<th width="40">Orden</th>
					<th width="60">Expediente</th>
					<th width="30">Cuenta</th>
					<th width="130">Rubro</th>
					<th width="80">Inst.</th>
					<th>Proveedor</th>
					<th width="90">Orden</th>
					
					<th width="90">Autorizado</th>
					<th width="90">Pagado</th>
					<th width="90">Deuda</th>
					<th width="30">Compromiso</th>
					<th>Acta</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*292.12*/for(informe <- buscador.getList) yield /*292.44*/ {_display_(Seq[Any](format.raw/*292.46*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*294.11*/informe/*294.18*/.numero_orden_provision)),format.raw/*294.41*/("""<br>
						"""),_display_(Seq[Any](/*295.8*/if(informe.tipo_moneda != null)/*295.39*/{_display_(Seq[Any](format.raw/*295.40*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*295.112*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*297.11*/informe/*297.18*/.expediente)),format.raw/*297.29*/("""
						"""),_display_(Seq[Any](/*298.8*/if(informe.expedienteObj.emergencia)/*298.44*/{_display_(Seq[Any](format.raw/*298.45*/("""
							<span style="color:red;font-weight: bold;font-size:11px; ">Emergencia</span>
						""")))})),format.raw/*300.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*302.11*/if(informe.tipoCuenta != null)/*302.41*/ {_display_(Seq[Any](_display_(Seq[Any](/*302.44*/informe/*302.51*/.tipoCuenta.nombre))))})),format.raw/*302.70*/("""</td>
					<td>"""),_display_(Seq[Any](/*303.11*/informe/*303.18*/.rubro)),format.raw/*303.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*304.11*/informe/*304.18*/.deposito.nombre)),format.raw/*304.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*305.11*/informe/*305.18*/.nombreProveedor)),format.raw/*305.34*/("""</td>
					<td class="totalOrden" data-valor=""""),_display_(Seq[Any](/*306.42*/informe/*306.49*/.totalOrden)),format.raw/*306.60*/("""">"""),_display_(Seq[Any](/*306.63*/utils/*306.68*/.NumberUtils.moneda(informe.totalOrden))),format.raw/*306.107*/("""</td>
					
					<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*308.47*/informe/*308.54*/.totalAutorizado)),format.raw/*308.70*/("""">"""),_display_(Seq[Any](/*308.73*/utils/*308.78*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*308.122*/("""</td>
					<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*309.43*/informe/*309.50*/.totalPagado)),format.raw/*309.62*/("""">"""),_display_(Seq[Any](/*309.65*/utils/*309.70*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*309.110*/("""</td>
					<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*310.42*/informe/*310.49*/.totalDeuda)),format.raw/*310.60*/("""">

							"""),_display_(Seq[Any](/*312.9*/utils/*312.14*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*312.53*/("""

					</td>
					<td class="totalCompromiso" data-valor=""""),_display_(Seq[Any](/*315.47*/informe/*315.54*/.totalCompromiso)),format.raw/*315.70*/("""">
					

							"""),_display_(Seq[Any](/*318.9*/utils/*318.14*/.NumberUtils.moneda(informe.totalCompromiso))),format.raw/*318.58*/("""
	
						
					</td>
					"""),_display_(Seq[Any](/*322.7*/if(informe.orden_provision_id != null)/*322.45*/ {_display_(Seq[Any](format.raw/*322.47*/("""
						<td><a href=""""),_display_(Seq[Any](/*323.21*/controllers/*323.32*/.dashboard.routes.InformeEstadisticoDeudaProveedoresController.getActas(informe.orden_provision_id))),format.raw/*323.131*/("""" class="actas"><i class="glyphicon glyphicon-align-justify"></i></a></td>
					""")))}/*324.8*/else/*324.13*/{_display_(Seq[Any](format.raw/*324.14*/("""
						<td></td>
					""")))})),format.raw/*326.7*/("""
					
				</tr>
		        """)))})),format.raw/*329.12*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6"></td>
					<td><b>Total:</b><br /><span class="ordenFooter"></span></td>
					<td><b>Total:</b><br /><span class="autorizadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="pagadoFooter"></span></td>
					<td><b>Total:</b><br /><span class="deudaFooter"></span></td>
					<td><b>Total:</b><br /><span class="compromisoFooter"></span></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*344.8*/views/*344.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.InformeEstadisticoDeudaProveedoresController.index()))),format.raw/*344.129*/("""
		</div>
	""")))})),format.raw/*346.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*350.16*/("""{"""),format.raw/*350.17*/("""
		$('#searchExpediente, #searchProveedor,#searchDeposito').modalSearch();
		$('.actas').click( function() """),format.raw/*352.33*/("""{"""),format.raw/*352.34*/("""
			var $this = $(this);
			var url = $this.attr('href');
			var oid = $(this).data('data-id-provision');
			$.get(url, function(data) """),format.raw/*356.30*/("""{"""),format.raw/*356.31*/("""
				$this.parent().html(data);
			"""),format.raw/*358.4*/("""}"""),format.raw/*358.5*/(""");
			return false;
		"""),format.raw/*360.3*/("""}"""),format.raw/*360.4*/(""");
		
		var trs = $('#listaInforme tbody tr');

		var orden = 0; var pagado = 0; var deuda = 0; var compromiso = 0;var autorizado = 0;
		
		trs.each( function() """),format.raw/*366.24*/("""{"""),format.raw/*366.25*/("""
			orden += Number($('.totalOrden',this).attr("data-valor"));
			autorizado += Number($('.totalAutorizado',this).attr("data-valor"));
			pagado += Number($('.totalPagado',this).attr("data-valor"));
			deuda += Number($('.totalDeuda',this).attr("data-valor"));
			compromiso += Number($('.totalCompromiso',this).attr("data-valor"));
		"""),format.raw/*372.3*/("""}"""),format.raw/*372.4*/(""");

		$(".ordenFooter").html(formatNumberPesos(parseFloat(orden).toFixed(2)));
		$(".autorizadoFooter").html(formatNumberPesos(parseFloat(autorizado).toFixed(2)));
		$(".pagadoFooter").html(formatNumberPesos(parseFloat(pagado).toFixed(2)));
		$(".deudaFooter").html(formatNumberPesos(parseFloat(deuda).toFixed(2)));
		$(".compromisoFooter").html(formatNumberPesos(parseFloat(compromiso).toFixed(2)));
		
	"""),format.raw/*380.2*/("""}"""),format.raw/*380.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.informes.InformeDeudaProveedoresMaterializada],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoDeudaProveedores/index.scala.html
                    HASH: 041b89e85ef7e7e5c97f8d1daa9eae444ef61955
                    MATRIX: 906->1|1128->140|1160->164|1217->213|1233->221|1545->121|1573->208|1604->502|1642->505|1655->510|1724->570|1764->572|1999->771|2019->782|2125->865|2300->1012|2329->1013|2581->1237|2610->1238|2837->1438|2865->1439|2899->1446|2927->1447|2981->1466|3022->1498|3062->1500|3178->1580|3192->1585|3230->1600|3269->1608|3306->1610|3345->1640|3385->1642|3504->1725|3518->1730|3554->1743|3593->1751|3829->1952|3981->2081|4024->2089|4129->2172|4346->2353|4366->2364|4439->2415|4889->2830|5016->2934|5059->2942|5166->3027|5390->3215|5410->3226|5486->3280|5918->3676|6101->3835|6241->3938|6275->3962|6301->3965|6381->4009|6576->4181|6715->4284|6864->4409|7056->4565|7197->4682|7239->4688|7342->4768|7533->4922|7554->4933|7629->4985|8043->5363|8232->5528|8461->5721|8594->5830|8687->5886|8802->5977|9011->6150|9143->6258|9236->6314|9350->6404|9571->6589|9715->6709|9808->6765|9928->6861|10113->7010|10293->7166|10495->7332|10558->7372|10754->7532|10831->7586|10991->7710|11120->7815|11261->7920|11381->8016|11848->8446|11869->8457|11962->8527|12119->8648|12163->8682|12204->8684|12338->8800|12352->8805|12392->8806|12593->8970|12611->8978|12666->9010|13532->9839|13581->9871|13622->9873|13679->9893|13696->9900|13742->9923|13790->9935|13831->9966|13871->9967|13977->10039|14036->10061|14053->10068|14087->10079|14131->10087|14177->10123|14217->10124|14341->10216|14400->10238|14440->10268|14490->10271|14507->10278|14553->10297|14606->10313|14623->10320|14652->10326|14705->10342|14722->10349|14761->10365|14814->10381|14831->10388|14870->10404|14954->10451|14971->10458|15005->10469|15045->10472|15060->10477|15123->10516|15218->10574|15235->10581|15274->10597|15314->10600|15329->10605|15397->10649|15482->10697|15499->10704|15534->10716|15574->10719|15589->10724|15653->10764|15737->10811|15754->10818|15788->10829|15836->10841|15851->10846|15913->10885|16009->10944|16026->10951|16065->10967|16119->10985|16134->10990|16201->11034|16264->11061|16312->11099|16353->11101|16411->11122|16432->11133|16555->11232|16655->11314|16669->11319|16709->11320|16764->11343|16825->11371|17360->11870|17375->11875|17515->11991|17559->12003|17641->12056|17671->12057|17807->12164|17837->12165|18001->12300|18031->12301|18094->12336|18123->12337|18173->12359|18202->12360|18392->12521|18422->12522|18785->12857|18814->12858|19247->13263|19276->13264
                    LINES: 26->1|29->3|29->3|29->6|29->6|34->1|35->3|38->10|40->12|40->12|40->12|40->12|49->21|49->21|49->21|58->30|58->30|63->35|63->35|69->41|69->41|71->43|71->43|78->50|78->50|78->50|79->51|79->51|79->51|80->52|81->53|81->53|81->53|82->54|82->54|82->54|83->55|93->65|93->65|94->66|94->66|99->71|99->71|99->71|115->87|115->87|116->88|116->88|122->94|122->94|122->94|137->109|137->109|143->115|143->115|143->115|144->116|147->119|154->126|154->126|161->133|161->133|162->134|162->134|165->137|165->137|165->137|175->147|176->148|188->160|188->160|190->162|190->162|199->171|199->171|201->173|201->173|210->182|210->182|212->184|212->184|222->194|222->194|230->202|230->202|238->210|238->210|245->217|245->217|251->223|251->223|271->243|271->243|271->243|282->254|282->254|282->254|288->260|288->260|288->260|294->266|294->266|294->266|320->292|320->292|320->292|322->294|322->294|322->294|323->295|323->295|323->295|323->295|325->297|325->297|325->297|326->298|326->298|326->298|328->300|330->302|330->302|330->302|330->302|330->302|331->303|331->303|331->303|332->304|332->304|332->304|333->305|333->305|333->305|334->306|334->306|334->306|334->306|334->306|334->306|336->308|336->308|336->308|336->308|336->308|336->308|337->309|337->309|337->309|337->309|337->309|337->309|338->310|338->310|338->310|340->312|340->312|340->312|343->315|343->315|343->315|346->318|346->318|346->318|350->322|350->322|350->322|351->323|351->323|351->323|352->324|352->324|352->324|354->326|357->329|372->344|372->344|372->344|374->346|378->350|378->350|380->352|380->352|384->356|384->356|386->358|386->358|388->360|388->360|394->366|394->366|400->372|400->372|408->380|408->380
                    -- GENERATED --
                */
            