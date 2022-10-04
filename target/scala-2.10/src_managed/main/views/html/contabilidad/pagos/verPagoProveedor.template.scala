
package views.html.contabilidad.pagos

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
object verPagoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Pago],Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pagoForm: Form[Pago], pago:Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/pagos.js"))),format.raw/*7.69*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.35*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.contabilidad.mainContabilidad("Ficha de pago",scripts)/*10.67*/ {_display_(Seq[Any](format.raw/*10.69*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Ver pago """),_display_(Seq[Any](/*14.19*/if(pago.expediente != null)/*14.46*/{_display_(Seq[Any](_display_(Seq[Any](/*14.48*/if(pago.expediente.emergencia)/*14.78*/{_display_(Seq[Any](format.raw/*14.79*/("""<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*14.169*/("""</h1>
			</div>
			<div class="col-sm-9">
				<div class="dropdown pull-right">
					<div class="btn-group pull-right  btn-header">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownReportes" data-toggle="dropdown">
							<i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a id="reporteCheque" href=""""),_display_(Seq[Any](/*23.41*/controllers/*23.52*/.contabilidad.routes.PagosReportesController.reporteCheque(pago.id))),format.raw/*23.119*/("""">Reporte Cheque</a></li>
						</ul>
					</div>
				</div>
				<div class="dropdown pull-right">
					<div class="btn-group pull-right  btn-header">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownReportes" data-toggle="dropdown">
							<i class="glyphicon glyphicon-list-alt"></i> Acciones <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							"""),_display_(Seq[Any](/*33.9*/if(Permiso.check("pagosModificarNumeroFactura"))/*33.57*/ {_display_(Seq[Any](format.raw/*33.59*/("""
							<li><a id="accionModificarNumeroFactura" data-url=""""),_display_(Seq[Any](/*34.60*/controllers/*34.71*/.contabilidad.routes.PagosAccionesController.modalModificarNumeroFactura(pago.id))),format.raw/*34.152*/("""">Modificar N° Factura</a></li>
							""")))})),format.raw/*35.9*/("""
							"""),_display_(Seq[Any](/*36.9*/if(Permiso.check("pagosModificarNumeroRecibo"))/*36.56*/ {_display_(Seq[Any](format.raw/*36.58*/("""
							<li><a id="accionModificarNumeroRecibo" data-url=""""),_display_(Seq[Any](/*37.59*/controllers/*37.70*/.contabilidad.routes.PagosAccionesController.modalModificarNumeroRecibo(pago.id))),format.raw/*37.150*/("""">Modificar N° Recibo</a></li>
							""")))})),format.raw/*38.9*/("""
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*46.3*/views/*46.8*/.html.tags.successError())),format.raw/*46.33*/("""
	
	<div class="row menu-acciones">
		<div class="col-sm-5">
			<a href=""""),_display_(Seq[Any](/*50.14*/controllers/*50.25*/.contabilidad.routes.PagosController.crear())),_display_(Seq[Any](/*50.70*/UriTrack/*50.78*/.get("?"))),format.raw/*50.87*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*51.14*/controllers/*51.25*/.contabilidad.routes.PagosController.editar(pago.id))),_display_(Seq[Any](/*51.78*/UriTrack/*51.86*/.get("&"))),format.raw/*51.95*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*52.14*/controllers/*52.25*/.contabilidad.routes.PagosController.duplicar(pago.id))),_display_(Seq[Any](/*52.80*/UriTrack/*52.88*/.get("&"))),format.raw/*52.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
			<a href=""""),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.contabilidad.routes.PagosController.eliminar(pago.id))),_display_(Seq[Any](/*53.80*/UriTrack/*53.88*/.get("&"))),format.raw/*53.97*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-5">
			"""),_display_(Seq[Any](/*56.5*/if(pagoForm("tipoCuenta").value != null)/*56.45*/{_display_(Seq[Any](format.raw/*56.46*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*57.65*/pagoForm("tipoCuenta.nombre")/*57.94*/.value)),format.raw/*57.100*/("""</span>
			""")))})),format.raw/*58.5*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*61.14*/UriTrack/*61.22*/.getOnNull(controllers.contabilidad.routes.PagosController.index().absoluteURL()))),format.raw/*61.103*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*70.49*/pagoForm/*70.57*/.field("nombre").value)),format.raw/*70.79*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*74.49*/pagoForm/*74.57*/.field("referencia").value)),format.raw/*74.83*/("""</p>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for=tipo_pago class="control-label">Tipo Pago</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*80.7*/pago/*80.11*/.tipo_pago/*80.21*/ match/*80.27*/ {/*81.10*/case "transferencia" =>/*81.33*/ {_display_(Seq[Any](format.raw/*81.35*/("""Macro Online""")))}/*82.10*/case "transferenciaInterbanking" =>/*82.45*/ {_display_(Seq[Any](format.raw/*82.47*/("""Interbanking""")))}/*83.10*/case "transferenciaMacroProveedores" =>/*83.49*/ {_display_(Seq[Any](format.raw/*83.51*/("""Macro Proveedores""")))}/*84.10*/case "cheque" =>/*84.26*/ {_display_(Seq[Any](format.raw/*84.28*/("""Cheque""")))}/*85.10*/case "debito" =>/*85.26*/ {_display_(Seq[Any](format.raw/*85.28*/("""Debito""")))}})),format.raw/*86.10*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Cheque</label>
			<p class="form-control-static form-control" id="inputNumeroCheque">"""),_display_(Seq[Any](/*92.72*/pagoForm/*92.80*/.field("numero_cheque").value)),format.raw/*92.109*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Factura</label>
			<p class="form-control-static form-control" id="inputNumeroFactura">"""),_display_(Seq[Any](/*96.73*/pagoForm/*96.81*/.field("factura.numero_factura").value)),format.raw/*96.119*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Recibo</label>
			<p class="form-control-static form-control" id="inputNumeroRecibo">"""),_display_(Seq[Any](/*100.72*/pagoForm/*100.80*/.field("recibo").value)),format.raw/*100.102*/("""</p>
		</div>
		
	</div>	
	<div class="row">	
		<div class="col-sm-4">
			<label class="control-label">Contraparte</label>
			<p class="form-control-static form-control">
				<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*108.50*/controllers/*108.61*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(pago.proveedor.id))),format.raw/*108.151*/("""">
					"""),_display_(Seq[Any](/*109.7*/pagoForm/*109.15*/.field("proveedor.nombre").value)),format.raw/*109.47*/("""
				</a>
			</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Expediente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*115.49*/pagoForm/*115.57*/.field("expediente.expedienteEjercicio").value)),format.raw/*115.103*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Periodo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*119.49*/pagoForm/*119.57*/.field("periodo.nombre").value)),format.raw/*119.87*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° orden de pago</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*123.49*/pagoForm/*123.57*/.field("ordenPago.nombreCompleto").value)),format.raw/*123.97*/("""</p>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-sm-4">
			<label class="control-label">Paguese a</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*131.49*/pagoForm/*131.57*/.field("paguese_a").value)),format.raw/*131.82*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha pago</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*136.49*/pagoForm/*136.57*/.field("fecha_pago").value)),format.raw/*136.83*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha Emision</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*140.49*/pagoForm/*140.57*/.field("fecha_emision").value)),format.raw/*140.86*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha Conciliacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*144.49*/pagoForm/*144.57*/.field("fecha_conciliacion").value)),format.raw/*144.91*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha Cancelacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*148.49*/pagoForm/*148.57*/.field("fecha_cancelacion").value)),format.raw/*148.90*/("""</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*154.49*/pagoForm/*154.57*/.field("factura.nombre").value)),format.raw/*154.87*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Cuenta propia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*158.49*/pagoForm/*158.57*/.field("cuentaPropia.numero").value)),format.raw/*158.92*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cuenta impuesto en factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*162.49*/pagoForm/*162.57*/.field("cuentaImpuesto.nombre").value)),format.raw/*162.94*/("""</p>
		</div>
		<div class="col-sm-2">
			<!-- <div class="checkbox">
				<label for="inputProfe" class="control-label"> 
					PROFE
					"""),_display_(Seq[Any](/*168.7*/checkbox(pagoForm("profe"), 'disabled -> "disabled"))),format.raw/*168.59*/("""
				</label>
			</div> -->
			<label class="control-label">Tipo Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*172.49*/if(pago.tipoCuenta != null)/*172.76*/{_display_(Seq[Any](_display_(Seq[Any](/*172.78*/pago/*172.82*/.tipoCuenta.nombre))))})),format.raw/*172.101*/("""</p> 
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label for="inputAPE class="control-label"> 
					Agente Pago Externo
					"""),_display_(Seq[Any](/*178.7*/checkbox(pagoForm("agente_pago_externo"), 'disabled -> "disabled"))),format.raw/*178.73*/("""
				</label>
			</div> 
		</div>
		
	</div>
	<hr>
	"""),_display_(Seq[Any](/*185.3*/views/*185.8*/.html.contabilidad.pagos.tabsPago(false,pagoForm,pagoForm.get()))),format.raw/*185.72*/("""
	
	<h4>Total Debito: 	<b>"""),_display_(Seq[Any](/*187.25*/utils/*187.30*/.NumberUtils.moneda(pago.total))),format.raw/*187.61*/("""</b></h4>	
	<h4>Total Credito: 	<b>"""),_display_(Seq[Any](/*188.26*/utils/*188.31*/.NumberUtils.moneda(pago.total_credito))),format.raw/*188.70*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*189.26*/pago/*189.30*/.estado.nombre)),format.raw/*189.44*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*192.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(pago.estado.orden,models.Estado.TIPO_PAGO)) yield /*192.104*/ {_display_(Seq[Any](format.raw/*192.106*/("""	
			"""),_display_(Seq[Any](/*193.5*/if(estado.orden <= 4)/*193.26*/ {_display_(Seq[Any](format.raw/*193.28*/("""
				"""),_display_(Seq[Any](/*194.6*/if(pago.estado.id == models.Estado.PAGO_ESTADO_BORRADOR && (pago.tipo_pago.compareTo("debito") == 0))/*194.107*/{_display_(Seq[Any](format.raw/*194.108*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*196.17*/controllers/*196.28*/.contabilidad.routes.PagosController.cambiarEstadoTransferenciaConciliado(pagoForm.field("id").value.toInt))),_display_(Seq[Any](/*196.136*/UriTrack/*196.144*/.get("&"))),format.raw/*196.153*/("""" class="btn btn-default">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*197.57*/models/*197.63*/.Estado.getEstado(models.Estado.PAGO_ESTADO_CONCILIADO,Estado.TIPO_PAGO).nombre)),format.raw/*197.142*/("""
						</a>
					</div>
				""")))}/*200.6*/else/*200.10*/{_display_(Seq[Any](format.raw/*200.11*/("""
					"""),_display_(Seq[Any](/*201.7*/if(pago.estado.id == models.Estado.PAGO_ESTADO_EN_CURSO && (pago.tipo_pago.compareTo("transferencia") == 0 || pago.tipo_pago.compareTo("transferenciaMacroProveedores") == 0 || pago.tipo_pago.compareTo("transferenciaInterbanking") == 0))/*201.243*/ {_display_(Seq[Any](format.raw/*201.245*/("""
						<div class="col-sm-3">
							<a href=""""),_display_(Seq[Any](/*203.18*/controllers/*203.29*/.contabilidad.routes.PagosController.cambiarEstadoTransferenciaConciliado(pagoForm.field("id").value.toInt))),_display_(Seq[Any](/*203.137*/UriTrack/*203.145*/.get("&"))),format.raw/*203.154*/("""" class="btn btn-default">
								<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*204.58*/models/*204.64*/.Estado.getEstado(models.Estado.PAGO_ESTADO_CONCILIADO,Estado.TIPO_PAGO).nombre)),format.raw/*204.143*/("""
							</a>
						</div>
					
					""")))}/*208.7*/else/*208.11*/{_display_(Seq[Any](format.raw/*208.12*/("""
						<div class="col-sm-3">
							<a href=""""),_display_(Seq[Any](/*210.18*/controllers/*210.29*/.contabilidad.routes.PagosController.cambiarEstado(pagoForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*210.132*/UriTrack/*210.140*/.get("&"))),format.raw/*210.149*/("""" class="btn btn-default">
								<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*211.58*/estado/*211.64*/.nombre)),format.raw/*211.71*/("""
							</a>
						</div>
					""")))})),format.raw/*214.7*/("""
				""")))})),format.raw/*215.6*/("""
			""")))})),format.raw/*216.5*/("""
		""")))})),format.raw/*217.4*/("""
		"""),_display_(Seq[Any](/*218.4*/if(pago.estado.id == models.Estado.PAGO_ESTADO_CANCELADO)/*218.61*/ {_display_(Seq[Any](format.raw/*218.63*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*220.15*/controllers/*220.26*/.contabilidad.routes.PagosController.cambiarEstado(pagoForm.field("id").value.toInt, models.Estado.PAGO_ESTADO_BORRADOR))),_display_(Seq[Any](/*220.147*/UriTrack/*220.155*/.get("&"))),format.raw/*220.164*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*224.4*/else/*224.8*/{_display_(Seq[Any](format.raw/*224.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*226.15*/controllers/*226.26*/.contabilidad.routes.PagosController.cambiarEstado(pagoForm.field("id").value.toInt, models.Estado.PAGO_ESTADO_CANCELADO))),_display_(Seq[Any](/*226.148*/UriTrack/*226.156*/.get("&"))),format.raw/*226.165*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Pago
				</a>
			</div>
		""")))})),format.raw/*230.4*/("""
	</div>

""")))})))}
    }
    
    def render(pagoForm:Form[Pago],pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(pagoForm,pago)
    
    def f:((Form[Pago],Pago) => play.api.templates.HtmlFormat.Appendable) = (pagoForm,pago) => apply(pagoForm,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/verPagoProveedor.scala.html
                    HASH: c26e142da022afeb6fa6b0e4cd0843e65b813b3a
                    MATRIX: 813->1|980->167|994->174|1078->178|1130->195|1144->201|1212->248|1280->95|1312->119|1386->34|1415->163|1444->285|1484->290|1497->295|1566->355|1606->357|1738->453|1774->480|1822->482|1861->512|1900->513|2027->603|2496->1036|2516->1047|2606->1114|3062->1535|3119->1583|3159->1585|3256->1646|3276->1657|3380->1738|3452->1779|3497->1789|3553->1836|3593->1838|3689->1898|3709->1909|3812->1989|3883->2029|3993->2104|4006->2109|4053->2134|4167->2212|4187->2223|4262->2268|4279->2276|4310->2285|4443->2382|4463->2393|4546->2446|4563->2454|4594->2463|4723->2556|4743->2567|4828->2622|4845->2630|4876->2639|5012->2739|5032->2750|5117->2805|5134->2813|5165->2822|5358->2980|5407->3020|5446->3021|5548->3087|5586->3116|5615->3122|5659->3135|5746->3186|5763->3194|5867->3275|6145->3517|6162->3525|6206->3547|6384->3689|6401->3697|6449->3723|6677->3916|6690->3920|6709->3930|6724->3936|6735->3949|6767->3972|6807->3974|6839->3998|6883->4033|6923->4035|6955->4059|7003->4098|7043->4100|7080->4129|7105->4145|7145->4147|7171->4165|7196->4181|7236->4183|7276->4201|7493->4382|7510->4390|7562->4419|7764->4585|7781->4593|7842->4631|8043->4795|8061->4803|8107->4825|8372->5053|8393->5064|8507->5154|8553->5164|8571->5172|8626->5204|8820->5361|8838->5369|8908->5415|9084->5554|9102->5562|9155->5592|9340->5740|9358->5748|9421->5788|9635->5965|9653->5973|9701->5998|9884->6144|9902->6152|9951->6178|10133->6323|10151->6331|10203->6360|10390->6510|10408->6518|10465->6552|10651->6701|10669->6709|10725->6742|10930->6910|10948->6918|11001->6948|11183->7093|11201->7101|11259->7136|11454->7294|11472->7302|11532->7339|11713->7484|11788->7536|11957->7668|11994->7695|12043->7697|12057->7701|12104->7720|12292->7872|12381->7938|12477->7998|12491->8003|12578->8067|12644->8096|12659->8101|12713->8132|12787->8169|12802->8174|12864->8213|12938->8250|12952->8254|12989->8268|13080->8323|13198->8423|13240->8425|13283->8432|13314->8453|13355->8455|13398->8462|13510->8563|13551->8564|13635->8611|13656->8622|13796->8730|13815->8738|13848->8747|13969->8831|13985->8837|14088->8916|14139->8948|14153->8952|14193->8953|14237->8961|14484->9197|14526->9199|14612->9248|14633->9259|14773->9367|14792->9375|14825->9384|14947->9469|14963->9475|15066->9554|15127->9596|15141->9600|15181->9601|15267->9650|15288->9661|15423->9764|15442->9772|15475->9781|15597->9866|15613->9872|15643->9879|15710->9914|15749->9921|15787->9927|15824->9932|15865->9937|15932->9994|15973->9996|16053->10039|16074->10050|16227->10171|16246->10179|16279->10188|16422->10312|16435->10316|16474->10317|16554->10360|16575->10371|16729->10493|16748->10501|16781->10510|16932->10629
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|42->10|42->10|42->10|42->10|46->14|46->14|46->14|46->14|46->14|46->14|55->23|55->23|55->23|65->33|65->33|65->33|66->34|66->34|66->34|67->35|68->36|68->36|68->36|69->37|69->37|69->37|70->38|78->46|78->46|78->46|82->50|82->50|82->50|82->50|82->50|83->51|83->51|83->51|83->51|83->51|84->52|84->52|84->52|84->52|84->52|85->53|85->53|85->53|85->53|85->53|88->56|88->56|88->56|89->57|89->57|89->57|90->58|93->61|93->61|93->61|102->70|102->70|102->70|106->74|106->74|106->74|112->80|112->80|112->80|112->80|112->81|112->81|112->81|112->82|112->82|112->82|112->83|112->83|112->83|112->84|112->84|112->84|112->85|112->85|112->85|112->86|118->92|118->92|118->92|122->96|122->96|122->96|126->100|126->100|126->100|134->108|134->108|134->108|135->109|135->109|135->109|141->115|141->115|141->115|145->119|145->119|145->119|149->123|149->123|149->123|157->131|157->131|157->131|162->136|162->136|162->136|166->140|166->140|166->140|170->144|170->144|170->144|174->148|174->148|174->148|180->154|180->154|180->154|184->158|184->158|184->158|188->162|188->162|188->162|194->168|194->168|198->172|198->172|198->172|198->172|198->172|204->178|204->178|211->185|211->185|211->185|213->187|213->187|213->187|214->188|214->188|214->188|215->189|215->189|215->189|218->192|218->192|218->192|219->193|219->193|219->193|220->194|220->194|220->194|222->196|222->196|222->196|222->196|222->196|223->197|223->197|223->197|226->200|226->200|226->200|227->201|227->201|227->201|229->203|229->203|229->203|229->203|229->203|230->204|230->204|230->204|234->208|234->208|234->208|236->210|236->210|236->210|236->210|236->210|237->211|237->211|237->211|240->214|241->215|242->216|243->217|244->218|244->218|244->218|246->220|246->220|246->220|246->220|246->220|250->224|250->224|250->224|252->226|252->226|252->226|252->226|252->226|256->230
                    -- GENERATED --
                */
            