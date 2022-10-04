
package views.html.contabilidad.balanceCuentaPropia

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
object modalAgregarMovimientoBalanceCuentaPropiar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[BalanceCuentaPropia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: Form[BalanceCuentaPropia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.BalanceCuentaPropiaController.agregarMovimientoBalanceCuentaPropia(), 'id -> "formAgregarMovimientoBalanceCuentaPropia")/*5.175*/ {_display_(Seq[Any](format.raw/*5.177*/("""	

<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
	$('#searchExpedienteModal,#searchOrdenPagoModal,#searchProveedorModal').modalSearch();
	$("#debito,#deposito").numeric_input();
 	$(".inputDateMascara").mask("99/99/9999");
 	$( ".date" ).mask("99/99/9999");
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/(""");
</script>
"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.tags.successError())),format.raw/*15.32*/("""
	<div class="row">
		<div class="col-sm-7">
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*19.29*/if(formBuscador.error("fecha") != null)/*19.68*/ {_display_(Seq[Any](format.raw/*19.70*/("""has-error""")))}/*19.81*/else/*19.86*/{_display_(Seq[Any](format.raw/*19.87*/("""has-required""")))})),format.raw/*19.100*/("""">
					<label for="inputFecha" class="control-label">Fecha</label> 
					"""),_display_(Seq[Any](/*21.7*/inputText(formBuscador("fecha"),'class -> "form-control date "))),format.raw/*21.70*/(""" 
				</div>
				"""),_display_(Seq[Any](/*23.6*/formBuscador("fecha")/*23.27*/.error.map/*23.37*/{ error =>_display_(Seq[Any](format.raw/*23.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*28.29*/if(formBuscador.error("fecha_debito") != null)/*28.75*/ {_display_(Seq[Any](format.raw/*28.77*/("""has-error""")))}/*28.88*/else/*28.93*/{_display_(Seq[Any](format.raw/*28.94*/("""has-required""")))})),format.raw/*28.107*/("""">
					<label for="inputFechaDebito" class="control-label">Fecha Debito</label> 
					"""),_display_(Seq[Any](/*30.7*/inputText(formBuscador("fecha_debito"),'class -> "form-control date"))),format.raw/*30.76*/("""
				</div>
				"""),_display_(Seq[Any](/*32.6*/formBuscador("fecha_debito")/*32.34*/.error.map/*32.44*/{ error =>_display_(Seq[Any](format.raw/*32.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*33.31*/error/*33.36*/.message)),format.raw/*33.44*/("""</div>
				""")))})),format.raw/*34.6*/("""
			</div>
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*37.29*/if(formBuscador.error("fecha_cancelado") != null)/*37.78*/ {_display_(Seq[Any](format.raw/*37.80*/("""has-error""")))}/*37.91*/else/*37.96*/{_display_(Seq[Any](format.raw/*37.97*/("""has-required""")))})),format.raw/*37.110*/("""">
					<label for="inputFechaDebito" class="control-label">Fec. Cancelado</label> 
					"""),_display_(Seq[Any](/*39.7*/inputText(formBuscador("fecha_cancelado"),'class -> "form-control date"))),format.raw/*39.79*/("""
				</div>
				"""),_display_(Seq[Any](/*41.6*/formBuscador("fecha_cancelado")/*41.37*/.error.map/*41.47*/{ error =>_display_(Seq[Any](format.raw/*41.57*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*42.31*/error/*42.36*/.message)),format.raw/*42.44*/("""</div>
				""")))})),format.raw/*43.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*47.28*/if(formBuscador.error("numero_cheque") != null)/*47.75*/ {_display_(Seq[Any](format.raw/*47.77*/("""has-error""")))}/*47.88*/else/*47.93*/{_display_(Seq[Any](format.raw/*47.94*/("""has-required""")))})),format.raw/*47.107*/("""">
				<label for="inputCheque" class="control-label">Cheque/Trasf.</label> 
				"""),_display_(Seq[Any](/*49.6*/inputText(formBuscador("numero_cheque"),'class -> "form-control"))),format.raw/*49.71*/("""
			</div>
			"""),_display_(Seq[Any](/*51.5*/formBuscador("numero_cheque")/*51.34*/.error.map/*51.44*/{ error =>_display_(Seq[Any](format.raw/*51.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*52.30*/error/*52.35*/.message)),format.raw/*52.43*/("""</div>
			""")))})),format.raw/*53.5*/("""
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*56.28*/if(formBuscador.error("referencia") != null)/*56.72*/ {_display_(Seq[Any](format.raw/*56.74*/("""has-error""")))}/*56.85*/else/*56.90*/{_display_(Seq[Any](format.raw/*56.91*/("""has-required""")))})),format.raw/*56.104*/("""">
				<label for="inputReferencia" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*58.6*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*58.69*/("""
			</div>
			"""),_display_(Seq[Any](/*60.5*/formBuscador("referencia")/*60.31*/.error.map/*60.41*/{ error =>_display_(Seq[Any](format.raw/*60.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*61.30*/error/*61.35*/.message)),format.raw/*61.43*/("""</div>
			""")))})),format.raw/*62.5*/("""
		</div>
		
		
	</div>	
	<div class="row">	
		<div class="col-sm-6">
			<div class="form-group """),_display_(Seq[Any](/*69.28*/if(formBuscador.error("cuenta_propia_id") != null)/*69.78*/ {_display_(Seq[Any](format.raw/*69.80*/("""has-error""")))}/*69.91*/else/*69.96*/{_display_(Seq[Any](format.raw/*69.97*/("""has-required""")))})),format.raw/*69.110*/("""">
				<label class="control-label">Cuenta</label>
				"""),_display_(Seq[Any](/*71.6*/select(formBuscador("cuenta_propia_id"),CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*71.168*/(""" 	
			</div>
			"""),_display_(Seq[Any](/*73.5*/formBuscador("cuenta_propia_id")/*73.37*/.error.map/*73.47*/{ error =>_display_(Seq[Any](format.raw/*73.57*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*74.30*/error/*74.35*/.message)),format.raw/*74.43*/("""</div>
			""")))})),format.raw/*75.5*/("""
		</div>
		<div class="col-sm-3">
			<label class="control-label">Importe Deposito</label>
			<div class="form-group """),_display_(Seq[Any](/*79.28*/if(formBuscador.error("deposito") != null)/*79.70*/ {_display_(Seq[Any](format.raw/*79.72*/("""has-error""")))}/*79.83*/else/*79.88*/{_display_(Seq[Any](format.raw/*79.89*/("""has-required""")))})),format.raw/*79.102*/("""">
				"""),_display_(Seq[Any](/*80.6*/inputText(formBuscador("deposito"), 'class -> "form-control",'id -> "deposito"))),format.raw/*80.85*/("""
				"""),_display_(Seq[Any](/*81.6*/formBuscador("deposito")/*81.30*/.error.map/*81.40*/{ error =>_display_(Seq[Any](format.raw/*81.50*/(""" <div class="text-error">"""),_display_(Seq[Any](/*81.76*/error/*81.81*/.message)),format.raw/*81.89*/("""</div>""")))})),format.raw/*81.96*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<label class="control-label">Importe Debito</label>
			<div class="form-group """),_display_(Seq[Any](/*86.28*/if(formBuscador.error("debito") != null)/*86.68*/ {_display_(Seq[Any](format.raw/*86.70*/("""has-error""")))}/*86.81*/else/*86.86*/{_display_(Seq[Any](format.raw/*86.87*/("""has-required""")))})),format.raw/*86.100*/("""">
				"""),_display_(Seq[Any](/*87.6*/inputText(formBuscador("debito"), 'class -> "form-control",'id -> "haber"))),format.raw/*87.80*/("""
				"""),_display_(Seq[Any](/*88.6*/formBuscador("debito")/*88.28*/.error.map/*88.38*/{ error =>_display_(Seq[Any](format.raw/*88.48*/(""" <div class="text-error">"""),_display_(Seq[Any](/*88.74*/error/*88.79*/.message)),format.raw/*88.87*/("""</div>""")))})),format.raw/*88.94*/("""
			</div>
		</div>
		
	</div>	

	<div class="row">	
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Estado</label>
				"""),_display_(Seq[Any](/*98.6*/select(formBuscador("estado_id"), options("25"->"Conciliado","26"->"Cancelado"), 'class -> "form-control select"))),format.raw/*98.119*/("""
			</div>
			
		</div>
		<div class="col-sm-6">
			<div class="form-group """),_display_(Seq[Any](/*103.28*/if(formBuscador.error("a_la_orden") != null)/*103.72*/ {_display_(Seq[Any](format.raw/*103.74*/("""has-error""")))})),format.raw/*103.84*/("""">
				<label for="inputAlaorden" class="control-label">A la Orden</label> 
				"""),_display_(Seq[Any](/*105.6*/inputText(formBuscador("a_la_orden"), 'class -> "form-control"))),format.raw/*105.69*/("""
			</div>
		</div>
		<!-- <div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*109.28*/if(formBuscador.error("expediente_id") != null)/*109.75*/ {_display_(Seq[Any](format.raw/*109.77*/("""has-error""")))})),format.raw/*109.87*/("""">
				<label for="inputExpediente" class="control-label">Expediente</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*112.7*/inputText(formBuscador("expediente.expedienteEjercicio"),'class -> "form-control",'id -> "expediente_modal"))),format.raw/*112.115*/("""
					"""),_display_(Seq[Any](/*113.7*/inputText(formBuscador("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id_modal"))),format.raw/*113.97*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpedienteModal" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*118.21*/controllers/*118.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*118.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_modal" 
									data-field="#expediente_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*128.6*/formBuscador("expediente_id")/*128.35*/.error.map/*128.45*/{ error =>_display_(Seq[Any](format.raw/*128.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*129.31*/error/*129.36*/.message)),format.raw/*129.44*/("""</div>
				""")))})),format.raw/*130.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*134.28*/if(formBuscador.error("orden_pago_id") != null)/*134.75*/ {_display_(Seq[Any](format.raw/*134.77*/("""has-error""")))})),format.raw/*134.87*/("""">
				<label for="orden_pago_id" class="control-label">Orden de pago N° </label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*137.7*/inputText(formBuscador("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago_modal"))),format.raw/*137.111*/("""
					"""),_display_(Seq[Any](/*138.7*/inputText(formBuscador("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id_modal"))),format.raw/*138.97*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchOrdenPagoModal" 
									data-title="Selección de órdenes de pago" 
									data-url=""""),_display_(Seq[Any](/*143.21*/controllers/*143.32*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*143.89*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.orden-pago.simple" 
									data-label="#orden_pago_modal" 
									data-field="#orden_pago_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*153.6*/formBuscador("orden_pago_id")/*153.35*/.error.map/*153.45*/{ error =>_display_(Seq[Any](format.raw/*153.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*154.31*/error/*154.36*/.message)),format.raw/*154.44*/("""</div>
				""")))})),format.raw/*155.6*/("""
			</div>
		</div>	 -->
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*159.28*/if(formBuscador.error("proveedor_id") != null)/*159.74*/ {_display_(Seq[Any](format.raw/*159.76*/("""has-error""")))})),format.raw/*159.86*/("""">
				<label for="inputProveedor" class="control-label">Proveedor</label>
				<div class="input-group"> 
					"""),_display_(Seq[Any](/*162.7*/inputText(formBuscador("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor_modal"))),format.raw/*162.102*/("""
					"""),_display_(Seq[Any](/*163.7*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id_modal"))),format.raw/*163.96*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedorModal" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*168.21*/controllers/*168.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*168.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor_modal" 
									data-field="#proveedor_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*178.6*/formBuscador("proveedor_id")/*178.34*/.error.map/*178.44*/{ error =>_display_(Seq[Any](format.raw/*178.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*179.31*/error/*179.36*/.message)),format.raw/*179.44*/("""</div>
				""")))})),format.raw/*180.6*/("""
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
		</div>
	</div>
 
"""),_display_(Seq[Any](/*192.2*/flash()/*192.9*/.clear())),format.raw/*192.17*/("""
<script>
$( function()"""),format.raw/*194.14*/("""{"""),format.raw/*194.15*/("""
	if($("#proveedor_modal").length)"""),format.raw/*195.34*/("""{"""),format.raw/*195.35*/("""
		var options = """),format.raw/*196.17*/("""{"""),format.raw/*196.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*202.30*/("""{"""),format.raw/*202.31*/(""" 
											$("#proveedor_id_modal").val(obj.id); 
										 """),format.raw/*204.12*/("""}"""),format.raw/*204.13*/("""
			"""),format.raw/*205.4*/("""}"""),format.raw/*205.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor_modal', options);
	"""),format.raw/*207.2*/("""}"""),format.raw/*207.3*/("""		
if($("#expediente_modal").length)"""),format.raw/*208.34*/("""{"""),format.raw/*208.35*/("""
	var options = """),format.raw/*209.16*/("""{"""),format.raw/*209.17*/("""
			script:"/suggestExpediente/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*215.29*/("""{"""),format.raw/*215.30*/(""" 
										$("#expediente_id_modal").val(obj.id); 
									 """),format.raw/*217.11*/("""}"""),format.raw/*217.12*/("""
		"""),format.raw/*218.3*/("""}"""),format.raw/*218.4*/(""";
	var as_json = new bsn.AutoSuggest('expediente_modal', options);
"""),format.raw/*220.1*/("""}"""),format.raw/*220.2*/("""	
if($("#orden_pago_modal").length)"""),format.raw/*221.34*/("""{"""),format.raw/*221.35*/("""
	var options = """),format.raw/*222.16*/("""{"""),format.raw/*222.17*/("""
			script:"/contabilidad/suggestOrdenPago/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*228.29*/("""{"""),format.raw/*228.30*/(""" 
										$("#orden_pago_id_modal").val(obj.id); 
									 """),format.raw/*230.11*/("""}"""),format.raw/*230.12*/("""
		"""),format.raw/*231.3*/("""}"""),format.raw/*231.4*/(""";
	var as_json = new bsn.AutoSuggest('orden_pago_modal', options);
"""),format.raw/*233.1*/("""}"""),format.raw/*233.2*/("""	
"""),format.raw/*234.1*/("""}"""),format.raw/*234.2*/(""");
</script>
""")))})),format.raw/*236.2*/("""
"""))}
    }
    
    def render(formBuscador:Form[BalanceCuentaPropia]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((Form[BalanceCuentaPropia]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropiar.scala.html
                    HASH: dc61ff9f3db34ef01c009b3f4414bef0fc58604c
                    MATRIX: 863->1|1006->61|1038->85|1112->42|1140->129|1197->152|1210->158|1386->325|1426->327|1477->351|1505->352|1742->562|1770->563|1819->577|1832->582|1879->607|2014->706|2062->745|2102->747|2131->758|2144->763|2183->764|2229->777|2339->852|2424->915|2477->933|2507->954|2526->964|2574->974|2641->1005|2655->1010|2685->1018|2728->1030|2829->1095|2884->1141|2924->1143|2953->1154|2966->1159|3005->1160|3051->1173|3174->1261|3265->1330|3317->1347|3354->1375|3373->1385|3421->1395|3488->1426|3502->1431|3532->1439|3575->1451|3676->1516|3734->1565|3774->1567|3803->1578|3816->1583|3855->1584|3901->1597|4026->1687|4120->1759|4172->1776|4212->1807|4231->1817|4279->1827|4346->1858|4360->1863|4390->1871|4433->1883|4541->1955|4597->2002|4637->2004|4666->2015|4679->2020|4718->2021|4764->2034|4881->2116|4968->2181|5018->2196|5056->2225|5075->2235|5123->2245|5189->2275|5203->2280|5233->2288|5275->2299|5373->2361|5426->2405|5466->2407|5495->2418|5508->2423|5547->2424|5593->2437|5711->2520|5796->2583|5846->2598|5881->2624|5900->2634|5948->2644|6014->2674|6028->2679|6058->2687|6100->2698|6233->2795|6292->2845|6332->2847|6361->2858|6374->2863|6413->2864|6459->2877|6550->2933|6735->3095|6787->3112|6828->3144|6847->3154|6895->3164|6961->3194|6975->3199|7005->3207|7047->3218|7202->3337|7253->3379|7293->3381|7322->3392|7335->3397|7374->3398|7420->3411|7463->3419|7564->3498|7605->3504|7638->3528|7657->3538|7705->3548|7767->3574|7781->3579|7811->3587|7850->3594|8013->3721|8062->3761|8102->3763|8131->3774|8144->3779|8183->3780|8229->3793|8272->3801|8368->3875|8409->3881|8440->3903|8459->3913|8507->3923|8569->3949|8583->3954|8613->3962|8652->3969|8846->4128|8982->4241|9095->4317|9149->4361|9190->4363|9233->4373|9350->4454|9436->4517|9550->4594|9607->4641|9648->4643|9691->4653|9840->4766|9972->4874|10015->4881|10128->4971|10346->5152|10367->5163|10444->5217|10771->5508|10810->5537|10830->5547|10879->5557|10947->5588|10962->5593|10993->5601|11037->5613|11146->5685|11203->5732|11244->5734|11287->5744|11442->5863|11570->5967|11613->5974|11726->6064|11948->6249|11969->6260|12049->6317|12376->6608|12415->6637|12435->6647|12484->6657|12552->6688|12567->6693|12598->6701|12642->6713|12756->6790|12812->6836|12853->6838|12896->6848|13044->6960|13163->7055|13206->7062|13318->7151|13536->7332|13557->7343|13631->7394|13955->7682|13993->7710|14013->7720|14062->7730|14130->7761|14145->7766|14176->7774|14220->7786|14590->8120|14606->8127|14637->8135|14689->8158|14719->8159|14782->8193|14812->8194|14858->8211|14888->8212|15053->8348|15083->8349|15175->8412|15205->8413|15237->8417|15266->8418|15362->8486|15391->8487|15456->8523|15486->8524|15531->8540|15561->8541|15721->8672|15751->8673|15842->8735|15872->8736|15903->8739|15932->8740|16027->8807|16056->8808|16120->8843|16150->8844|16195->8860|16225->8861|16397->9004|16427->9005|16518->9067|16548->9068|16579->9071|16608->9072|16703->9139|16732->9140|16762->9142|16791->9143|16837->9157
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|36->8|36->8|41->13|41->13|43->15|43->15|43->15|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|60->32|60->32|60->32|60->32|61->33|61->33|61->33|62->34|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|67->39|69->41|69->41|69->41|69->41|70->42|70->42|70->42|71->43|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|84->56|84->56|84->56|84->56|84->56|84->56|84->56|86->58|86->58|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|97->69|97->69|97->69|97->69|97->69|97->69|97->69|99->71|99->71|101->73|101->73|101->73|101->73|102->74|102->74|102->74|103->75|107->79|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|109->81|109->81|109->81|109->81|109->81|109->81|109->81|109->81|114->86|114->86|114->86|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|126->98|126->98|131->103|131->103|131->103|131->103|133->105|133->105|137->109|137->109|137->109|137->109|140->112|140->112|141->113|141->113|146->118|146->118|146->118|156->128|156->128|156->128|156->128|157->129|157->129|157->129|158->130|162->134|162->134|162->134|162->134|165->137|165->137|166->138|166->138|171->143|171->143|171->143|181->153|181->153|181->153|181->153|182->154|182->154|182->154|183->155|187->159|187->159|187->159|187->159|190->162|190->162|191->163|191->163|196->168|196->168|196->168|206->178|206->178|206->178|206->178|207->179|207->179|207->179|208->180|220->192|220->192|220->192|222->194|222->194|223->195|223->195|224->196|224->196|230->202|230->202|232->204|232->204|233->205|233->205|235->207|235->207|236->208|236->208|237->209|237->209|243->215|243->215|245->217|245->217|246->218|246->218|248->220|248->220|249->221|249->221|250->222|250->222|256->228|256->228|258->230|258->230|259->231|259->231|261->233|261->233|262->234|262->234|264->236
                    -- GENERATED --
                */
            