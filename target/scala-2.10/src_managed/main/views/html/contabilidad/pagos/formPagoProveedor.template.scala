
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
object formPagoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Pago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pagoForm: Form[Pago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*5.2*/getClassEstadoEditable/*5.24*/(i:String) = {{
	
	var isEditable:Boolean = new Boolean(false)
	if(i == null){
		isEditable = new Boolean(true)
	}
	
	if(i != null){
		var state:Integer = new Integer(i)
		if (state.compareTo(models.Estado.PAGO_ESTADO_BORRADOR) == 0){
			isEditable = new Boolean(true)
		}
	}
	
	isEditable
}};
Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*20.2*/("""
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/contabilidad/pagos.js"))),format.raw/*21.68*/("""" type="text/javascript"></script>


	<div class="row menu-acciones">
		<div class="col-sm-6">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*27.17*/if(request().getHeader("referer"))/*27.51*/{_display_(Seq[Any](format.raw/*27.52*/(""" """),_display_(Seq[Any](/*27.54*/request()/*27.63*/.getHeader("referer"))),format.raw/*27.84*/(""" """)))}/*27.87*/else/*27.92*/{_display_(Seq[Any](_display_(Seq[Any](/*27.94*/controllers/*27.105*/.contabilidad.routes.PagosController.index())),_display_(Seq[Any](/*27.150*/UriTrack/*27.158*/.decode()))))})),format.raw/*27.168*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	    <div class="col-sm-4">
			"""),_display_(Seq[Any](/*30.5*/if(pagoForm("tipoCuenta").value != null)/*30.45*/{_display_(Seq[Any](format.raw/*30.46*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*31.65*/pagoForm("tipoCuenta.nombre")/*31.94*/.value)),format.raw/*31.100*/("""</span>
			""")))})),format.raw/*32.5*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*35.14*/UriTrack/*35.22*/.getOnNull(controllers.contabilidad.routes.PagosController.index().absoluteURL()))),format.raw/*35.103*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*36.5*/if(pagoForm.field("id").value)/*36.35*/{_display_(Seq[Any](format.raw/*36.36*/("""<a href=""""),_display_(Seq[Any](/*36.46*/controllers/*36.57*/.contabilidad.routes.PagosController.ver(pagoForm.field("id").value.toLong))),_display_(Seq[Any](/*36.133*/UriTrack/*36.141*/.get("&"))),format.raw/*36.150*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*36.248*/("""
		</div>
	</div>



	"""),_display_(Seq[Any](/*42.3*/inputText(pagoForm("id"), 'type -> "hidden", 'id -> "pagoId"))),format.raw/*42.64*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*43.29*/UriTrack/*43.37*/.getKey())),format.raw/*43.46*/(""" value=""""),_display_(Seq[Any](/*43.55*/UriTrack/*43.63*/.code())),format.raw/*43.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*46.28*/if(pagoForm.error("nombre") != null)/*46.64*/ {_display_(Seq[Any](format.raw/*46.66*/("""has-error""")))})),format.raw/*46.76*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*48.6*/inputText(pagoForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*48.85*/("""
			</div>
			"""),_display_(Seq[Any](/*50.5*/pagoForm("nombre")/*50.23*/.error.map/*50.33*/{ error =>_display_(Seq[Any](format.raw/*50.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*51.30*/error/*51.35*/.message)),format.raw/*51.43*/("""</div>
			""")))})),format.raw/*52.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*55.28*/if(pagoForm.error("referencia") != null)/*55.68*/ {_display_(Seq[Any](format.raw/*55.70*/("""has-error""")))}/*55.80*/else/*55.84*/{_display_(Seq[Any](format.raw/*55.85*/("""has-required""")))})),format.raw/*55.98*/("""">
				<label for="inputReferencia" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*57.6*/inputText(pagoForm("referencia"), 'class -> "form-control"))),format.raw/*57.65*/("""
			</div>
			"""),_display_(Seq[Any](/*59.5*/pagoForm("referencia")/*59.27*/.error.map/*59.37*/{ error =>_display_(Seq[Any](format.raw/*59.47*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*60.30*/error/*60.35*/.message)),format.raw/*60.43*/("""</div>
			""")))})),format.raw/*61.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*64.28*/if(pagoForm.error("tipo_pago") != null)/*64.67*/ {_display_(Seq[Any](format.raw/*64.69*/("""has-error""")))})),format.raw/*64.79*/("""">
				<label for="tipo_pago" class="control-label">Tipo de Pago</label>
				"""),_display_(Seq[Any](/*66.6*/select(pagoForm("tipo_pago"), options("transferencia"->"Macro Online","transferenciaMacroProveedores"->"Macro Proveedores","transferenciaInterbanking"->"Interbanking","cheque"->"Cheque","debito"->"Debito"), 'class -> "form-control select"))),format.raw/*66.245*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*70.28*/if(pagoForm.error("numero_cheque") != null)/*70.71*/ {_display_(Seq[Any](format.raw/*70.73*/("""has-error""")))})),format.raw/*70.83*/("""">
				<label for="inputNCheque" class="control-label">N° Cheque</label> 
				"""),_display_(Seq[Any](/*72.6*/inputText(pagoForm("numero_cheque"), 'class -> "form-control"))),format.raw/*72.68*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*76.28*/if(pagoForm.error("numero_factura") != null)/*76.72*/ {_display_(Seq[Any](format.raw/*76.74*/("""has-error""")))})),format.raw/*76.84*/("""">
				<label for="inputNFactura" class="control-label">N° Factura</label> 
				"""),_display_(Seq[Any](/*78.6*/inputText(pagoForm("factura.numero_factura"),'id->"nfform", 'class -> "form-control"))),format.raw/*78.91*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*82.28*/if(pagoForm.error("recibo") != null)/*82.64*/ {_display_(Seq[Any](format.raw/*82.66*/("""has-error""")))})),format.raw/*82.76*/("""">
				<label for="inputRecibo" class="control-label">N° Recibo</label> 
				"""),_display_(Seq[Any](/*84.6*/inputText(pagoForm("recibo"), 'class -> "form-control"))),format.raw/*84.61*/("""
			</div>
		</div>
		
	</div>	
	<div class="row">	
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*91.28*/if(pagoForm.error("proveedor_id") != null)/*91.70*/ {_display_(Seq[Any](format.raw/*91.72*/("""has-error""")))}/*91.82*/else/*91.86*/{_display_(Seq[Any](format.raw/*91.87*/("""has-required""")))})),format.raw/*91.100*/("""">
				<label for="inputProveedor" class="control-label">Contraparte</label>
				"""),_display_(Seq[Any](/*93.6*/if(getClassEstadoEditable(pagoForm.field("estado.id").value))/*93.67*/{_display_(Seq[Any](format.raw/*93.68*/(""" 
					<div class="input-group"> 
					"""),_display_(Seq[Any](/*95.7*/inputText(pagoForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*95.92*/("""
					"""),_display_(Seq[Any](/*96.7*/inputText(pagoForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*96.86*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*101.21*/controllers/*101.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*101.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor" 
									data-field="#proveedor_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
					</div>
					"""),_display_(Seq[Any](/*111.7*/pagoForm("proveedor_id")/*111.31*/.error.map/*111.41*/{ error =>_display_(Seq[Any](format.raw/*111.51*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*112.32*/error/*112.37*/.message)),format.raw/*112.45*/("""</div>
					""")))})),format.raw/*113.7*/("""
				""")))}/*114.6*/else/*114.10*/{_display_(Seq[Any](format.raw/*114.11*/("""
					"""),_display_(Seq[Any](/*115.7*/inputText(pagoForm("proveedor.nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*115.96*/("""
					"""),_display_(Seq[Any](/*116.7*/inputText(pagoForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id",'readOnly -> "readOnly"))),format.raw/*116.110*/("""
				""")))})),format.raw/*117.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*121.28*/if(pagoForm.error("expediente_id") != null)/*121.71*/ {_display_(Seq[Any](format.raw/*121.73*/("""has-error""")))}/*121.83*/else/*121.87*/{_display_(Seq[Any](format.raw/*121.88*/("""has-required""")))})),format.raw/*121.101*/("""">
				<label for="inputExpediente" class="control-label">Expediente</label>
				"""),_display_(Seq[Any](/*123.6*/if(getClassEstadoEditable(pagoForm.field("estado.id").value))/*123.67*/{_display_(Seq[Any](format.raw/*123.68*/(""" 
					<div class="input-group">
						"""),_display_(Seq[Any](/*125.8*/inputText(pagoForm("expediente.expedienteEjercicio"),'class -> "form-control",'id -> "expediente"))),format.raw/*125.106*/("""
						"""),_display_(Seq[Any](/*126.8*/inputText(pagoForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*126.88*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*131.22*/controllers/*131.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*131.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
					"""),_display_(Seq[Any](/*141.7*/pagoForm("expediente_id")/*141.32*/.error.map/*141.42*/{ error =>_display_(Seq[Any](format.raw/*141.52*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*142.32*/error/*142.37*/.message)),format.raw/*142.45*/("""</div>
					""")))})),format.raw/*143.7*/("""
				""")))}/*144.6*/else/*144.10*/{_display_(Seq[Any](format.raw/*144.11*/("""
					"""),_display_(Seq[Any](/*145.7*/inputText(pagoForm("expediente.expedienteEjercicio"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*145.110*/("""
					"""),_display_(Seq[Any](/*146.7*/inputText(pagoForm("expediente_id"), 'hidden -> "hidden", 'id -> "proveedor_id",'readOnly -> "readOnly"))),format.raw/*146.111*/("""
				""")))})),format.raw/*147.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*152.28*/if(pagoForm.error("periodo_id") != null)/*152.68*/ {_display_(Seq[Any](format.raw/*152.70*/("""has-error""")))})),format.raw/*152.80*/("""">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*155.7*/inputText(pagoForm("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*155.88*/("""
					"""),_display_(Seq[Any](/*156.7*/inputText(pagoForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*156.81*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*161.21*/controllers/*161.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*161.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*174.28*/if(pagoForm.error("orden_pago_id") != null)/*174.71*/ {_display_(Seq[Any](format.raw/*174.73*/("""has-error""")))}/*174.83*/else/*174.87*/{_display_(Seq[Any](format.raw/*174.88*/("""has-required""")))})),format.raw/*174.101*/("""">
				<label for="orden_pago_id" class="control-label">Orden de pago N° </label> 
				"""),_display_(Seq[Any](/*176.6*/if(getClassEstadoEditable(pagoForm.field("estado.id").value))/*176.67*/{_display_(Seq[Any](format.raw/*176.68*/(""" 
					<div class="input-group">
						"""),_display_(Seq[Any](/*178.8*/inputText(pagoForm("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*178.102*/("""
						"""),_display_(Seq[Any](/*179.8*/inputText(pagoForm("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*179.88*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOrdenPago" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*184.22*/controllers/*184.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*184.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
					"""),_display_(Seq[Any](/*194.7*/pagoForm("orden_pago_id")/*194.32*/.error.map/*194.42*/{ error =>_display_(Seq[Any](format.raw/*194.52*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*195.32*/error/*195.37*/.message)),format.raw/*195.45*/("""</div>
					""")))})),format.raw/*196.7*/("""
				""")))}/*197.6*/else/*197.10*/{_display_(Seq[Any](format.raw/*197.11*/("""
					"""),_display_(Seq[Any](/*198.7*/inputText(pagoForm("ordenPago.nombreCompleto"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*198.104*/("""
					"""),_display_(Seq[Any](/*199.7*/inputText(pagoForm("orden_pago_id"), 'hidden -> "hidden", 'id -> "proveedor_id",'readOnly -> "readOnly"))),format.raw/*199.111*/("""
				""")))})),format.raw/*200.6*/("""
			</div>
		</div>
		
		
	</div>
	<div class="row">
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*209.28*/if(pagoForm.error("paguese_a") != null)/*209.67*/ {_display_(Seq[Any](format.raw/*209.69*/("""has-error""")))})),format.raw/*209.79*/("""">
				<label for="inputPaguesea" class="control-label">Paguese a</label> 
				"""),_display_(Seq[Any](/*211.6*/inputText(pagoForm("paguese_a"), 'class -> "form-control"))),format.raw/*211.64*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*215.28*/if(pagoForm.error("fecha_pago") != null)/*215.68*/ {_display_(Seq[Any](format.raw/*215.70*/("""has-error""")))})),format.raw/*215.80*/("""">
				<label for="inputFechaPago" class="control-label">Fecha Pago</label> 
				"""),_display_(Seq[Any](/*217.6*/inputText(pagoForm("fecha_pago"),'class -> "form-control date"))),format.raw/*217.69*/("""
			</div>
			"""),_display_(Seq[Any](/*219.5*/pagoForm("fecha_pago")/*219.27*/.error.map/*219.37*/{ error =>_display_(Seq[Any](format.raw/*219.47*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*220.30*/error/*220.35*/.message)),format.raw/*220.43*/("""</div>
			""")))})),format.raw/*221.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*224.28*/if(pagoForm.error("fecha_emision") != null)/*224.71*/ {_display_(Seq[Any](format.raw/*224.73*/("""has-error""")))})),format.raw/*224.83*/("""">
				<label for="inputFechaPago" class="control-label">Fecha Emision</label> 
				"""),_display_(Seq[Any](/*226.6*/inputText(pagoForm("fecha_emision"),'class -> "form-control date"))),format.raw/*226.72*/("""
			</div>
			"""),_display_(Seq[Any](/*228.5*/pagoForm("fecha_emision")/*228.30*/.error.map/*228.40*/{ error =>_display_(Seq[Any](format.raw/*228.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*229.30*/error/*229.35*/.message)),format.raw/*229.43*/("""</div>
			""")))})),format.raw/*230.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*233.28*/if(pagoForm.error("fecha_conciliacion") != null)/*233.76*/ {_display_(Seq[Any](format.raw/*233.78*/("""has-error""")))})),format.raw/*233.88*/("""">
				<label for="inputFechaConciliacion" class="control-label">Fecha Conciliacion</label> 
				"""),_display_(Seq[Any](/*235.6*/inputText(pagoForm("fecha_conciliacion"),'class -> "form-control date"))),format.raw/*235.77*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*239.28*/if(pagoForm.error("fecha_cancelacion") != null)/*239.75*/ {_display_(Seq[Any](format.raw/*239.77*/("""has-error""")))})),format.raw/*239.87*/("""">
				<label for="inputFechaCancelacion" class="control-label">Fecha Cancelacion</label> 
				"""),_display_(Seq[Any](/*241.6*/inputText(pagoForm("fecha_cancelacion"),'class -> "form-control date"))),format.raw/*241.76*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*247.28*/if(pagoForm.error("factura_id") != null)/*247.68*/ {_display_(Seq[Any](format.raw/*247.70*/("""has-error""")))}/*247.80*/else/*247.84*/{_display_(Seq[Any](format.raw/*247.85*/("""has-required""")))})),format.raw/*247.98*/("""">
				<label for="factura_id" class="control-label">Factura</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*250.7*/inputText(pagoForm("factura.nombre"), 'class -> "form-control", 'id -> "factura"))),format.raw/*250.88*/("""
					"""),_display_(Seq[Any](/*251.7*/inputText(pagoForm("factura_id"),'hidden -> "hidden", 'id -> "factura_id"))),format.raw/*251.81*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchFactura" 
									data-title="Selección de Facturas" 
									data-url=""""),_display_(Seq[Any](/*256.21*/controllers/*256.32*/.contabilidad.routes.FacturasController.modalBuscar())),format.raw/*256.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.factura.simple" 
									data-label="#factura" 
									data-field="#factura_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*266.6*/pagoForm("factura_id")/*266.28*/.error.map/*266.38*/{ error =>_display_(Seq[Any](format.raw/*266.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*267.31*/error/*267.36*/.message)),format.raw/*267.44*/("""</div>
				""")))})),format.raw/*268.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*273.28*/if(pagoForm.error("cuenta_propia_id") != null)/*273.74*/ {_display_(Seq[Any](format.raw/*273.76*/("""has-error""")))}/*273.86*/else/*273.90*/{_display_(Seq[Any](format.raw/*273.91*/("""has-required""")))})),format.raw/*273.104*/("""">
				<label for="cuenta_propia_id" class="control-label">Cuenta propia</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*276.7*/inputText(pagoForm("cuentaPropia.numero"), 'class -> "form-control", 'id -> "cuenta_propia"))),format.raw/*276.99*/("""
					"""),_display_(Seq[Any](/*277.7*/inputText(pagoForm("cuenta_propia_id"),'hidden -> "hidden", 'id -> "cuenta_propia_id"))),format.raw/*277.93*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuentaPropia" 
									data-title="Selección de Cuenta Propia" 
									data-url=""""),_display_(Seq[Any](/*282.21*/controllers/*282.32*/.contabilidad.routes.CuentasPropiasController.modalBuscar())),format.raw/*282.91*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuentaPropia.simple" 
									data-label="#cuenta_propia" 
									data-field="#cuenta_propia_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*292.6*/pagoForm("cuenta_propia_id")/*292.34*/.error.map/*292.44*/{ error =>_display_(Seq[Any](format.raw/*292.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*293.31*/error/*293.36*/.message)),format.raw/*293.44*/("""</div>
				""")))})),format.raw/*294.6*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group">
				<label for="cuenta_impuesto_id" class="control-label">Cuenta impuesto en factura</label> 
				"""),_display_(Seq[Any](/*301.6*/inputText(pagoForm("cuentaImpuesto.nombre"), 'class -> "form-control", 'id -> "cuenta_impuesto",'readOnly -> "readOnly"))),format.raw/*301.126*/("""
			</div>
		</div>
		<div class="col-sm-2">
			
			<div class="form-group """),_display_(Seq[Any](/*306.28*/if(pagoForm.error("tipo_cuenta_id") != null)/*306.72*/ {_display_(Seq[Any](format.raw/*306.74*/("""has-error""")))})),format.raw/*306.84*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*308.6*/select(pagoForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*308.161*/("""
				"""),_display_(Seq[Any](/*309.6*/pagoForm("tipo_cuenta_id")/*309.32*/.error.map/*309.42*/{ error =>_display_(Seq[Any](format.raw/*309.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*310.31*/error/*310.36*/.message)),format.raw/*310.44*/("""</div>
				""")))})),format.raw/*311.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label for="inputape" class="control-label"> 
					Agente Pago Externo
					"""),_display_(Seq[Any](/*318.7*/checkbox(pagoForm("agente_pago_externo")))),format.raw/*318.48*/("""
				</label>
			</div> 
		</div>
	</div>"""))}
    }
    
    def render(pagoForm:Form[Pago]): play.api.templates.HtmlFormat.Appendable = apply(pagoForm)
    
    def f:((Form[Pago]) => play.api.templates.HtmlFormat.Appendable) = (pagoForm) => apply(pagoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/formPagoProveedor.scala.html
                    HASH: c964109642dd333cd45e037806cded4d1351fb62
                    MATRIX: 809->1|949->58|981->82|1038->129|1068->151|1389->23|1417->126|1446->442|1497->457|1512->463|1581->510|1865->758|1908->792|1947->793|1985->795|2003->804|2046->825|2067->828|2080->833|2128->835|2149->846|2225->891|2243->899|2280->909|2472->1066|2521->1106|2560->1107|2661->1172|2699->1201|2728->1207|2771->1219|2855->1267|2872->1275|2976->1356|3113->1458|3152->1488|3191->1489|3237->1499|3257->1510|3364->1586|3382->1594|3414->1603|3545->1701|3603->1724|3686->1785|3751->1814|3768->1822|3799->1831|3844->1840|3861->1848|3890->1855|4002->1931|4047->1967|4087->1969|4129->1979|4239->2054|4340->2133|4390->2148|4417->2166|4436->2176|4484->2186|4550->2216|4564->2221|4594->2229|4636->2240|4734->2302|4783->2342|4823->2344|4852->2354|4865->2358|4904->2359|4949->2372|5067->2455|5148->2514|5198->2529|5229->2551|5248->2561|5296->2571|5362->2601|5376->2606|5406->2614|5448->2625|5546->2687|5594->2726|5634->2728|5676->2738|5789->2816|6051->3055|6159->3127|6211->3170|6251->3172|6293->3182|6407->3261|6491->3323|6599->3395|6652->3439|6692->3441|6734->3451|6850->3532|6957->3617|7065->3689|7110->3725|7150->3727|7192->3737|7305->3815|7382->3870|7522->3974|7573->4016|7613->4018|7642->4028|7655->4032|7694->4033|7740->4046|7857->4128|7927->4189|7966->4190|8041->4230|8148->4315|8190->4322|8291->4401|8504->4577|8525->4588|8599->4639|8913->4917|8947->4941|8967->4951|9016->4961|9085->4993|9100->4998|9131->5006|9176->5019|9201->5025|9215->5029|9255->5030|9298->5037|9410->5126|9453->5133|9580->5236|9618->5242|9727->5314|9780->5357|9821->5359|9851->5369|9865->5373|9905->5374|9952->5387|10070->5469|10141->5530|10181->5531|10257->5571|10379->5669|10423->5677|10526->5757|10744->5938|10765->5949|10842->6003|11167->6292|11202->6317|11222->6327|11271->6337|11340->6369|11355->6374|11386->6382|11431->6395|11456->6401|11470->6405|11510->6406|11553->6413|11680->6516|11723->6523|11851->6627|11889->6633|12001->6708|12051->6748|12092->6750|12135->6760|12279->6868|12383->6949|12426->6956|12523->7030|12730->7200|12751->7211|12827->7264|13200->7600|13253->7643|13294->7645|13324->7655|13338->7659|13378->7660|13425->7673|13549->7761|13620->7822|13660->7823|13736->7863|13854->7957|13898->7965|14001->8045|14223->8230|14244->8241|14324->8298|14649->8587|14684->8612|14704->8622|14753->8632|14822->8664|14837->8669|14868->8677|14913->8690|14938->8696|14952->8700|14992->8701|15035->8708|15156->8805|15199->8812|15327->8916|15365->8922|15510->9030|15559->9069|15600->9071|15643->9081|15759->9161|15840->9219|15949->9291|15999->9331|16040->9333|16083->9343|16201->9425|16287->9488|16338->9503|16370->9525|16390->9535|16439->9545|16506->9575|16521->9580|16552->9588|16595->9599|16694->9661|16747->9704|16788->9706|16831->9716|16952->9801|17041->9867|17092->9882|17127->9907|17147->9917|17196->9927|17263->9957|17278->9962|17309->9970|17352->9981|17451->10043|17509->10091|17550->10093|17593->10103|17727->10201|17821->10272|17930->10344|17987->10391|18028->10393|18071->10403|18203->10499|18296->10569|18432->10668|18482->10708|18523->10710|18553->10720|18567->10724|18607->10725|18653->10738|18795->10844|18899->10925|18942->10932|19039->11006|19247->11177|19268->11188|19344->11241|19650->11511|19682->11533|19702->11543|19751->11553|19819->11584|19834->11589|19865->11597|19909->11609|20021->11684|20077->11730|20118->11732|20148->11742|20162->11746|20202->11747|20249->11760|20403->11878|20518->11970|20561->11977|20670->12063|20888->12244|20909->12255|20991->12314|21314->12601|21352->12629|21372->12639|21421->12649|21489->12680|21504->12685|21535->12693|21579->12705|21790->12880|21934->13000|22047->13076|22101->13120|22142->13122|22185->13132|22282->13193|22461->13348|22503->13354|22539->13380|22559->13390|22608->13400|22676->13431|22691->13436|22722->13444|22766->13456|22954->13608|23018->13649
                    LINES: 26->1|31->4|31->4|31->5|31->5|47->1|48->4|49->20|50->21|50->21|50->21|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|56->27|59->30|59->30|59->30|60->31|60->31|60->31|61->32|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|71->42|71->42|72->43|72->43|72->43|72->43|72->43|72->43|75->46|75->46|75->46|75->46|77->48|77->48|79->50|79->50|79->50|79->50|80->51|80->51|80->51|81->52|84->55|84->55|84->55|84->55|84->55|84->55|84->55|86->57|86->57|88->59|88->59|88->59|88->59|89->60|89->60|89->60|90->61|93->64|93->64|93->64|93->64|95->66|95->66|99->70|99->70|99->70|99->70|101->72|101->72|105->76|105->76|105->76|105->76|107->78|107->78|111->82|111->82|111->82|111->82|113->84|113->84|120->91|120->91|120->91|120->91|120->91|120->91|120->91|122->93|122->93|122->93|124->95|124->95|125->96|125->96|130->101|130->101|130->101|140->111|140->111|140->111|140->111|141->112|141->112|141->112|142->113|143->114|143->114|143->114|144->115|144->115|145->116|145->116|146->117|150->121|150->121|150->121|150->121|150->121|150->121|150->121|152->123|152->123|152->123|154->125|154->125|155->126|155->126|160->131|160->131|160->131|170->141|170->141|170->141|170->141|171->142|171->142|171->142|172->143|173->144|173->144|173->144|174->145|174->145|175->146|175->146|176->147|181->152|181->152|181->152|181->152|184->155|184->155|185->156|185->156|190->161|190->161|190->161|203->174|203->174|203->174|203->174|203->174|203->174|203->174|205->176|205->176|205->176|207->178|207->178|208->179|208->179|213->184|213->184|213->184|223->194|223->194|223->194|223->194|224->195|224->195|224->195|225->196|226->197|226->197|226->197|227->198|227->198|228->199|228->199|229->200|238->209|238->209|238->209|238->209|240->211|240->211|244->215|244->215|244->215|244->215|246->217|246->217|248->219|248->219|248->219|248->219|249->220|249->220|249->220|250->221|253->224|253->224|253->224|253->224|255->226|255->226|257->228|257->228|257->228|257->228|258->229|258->229|258->229|259->230|262->233|262->233|262->233|262->233|264->235|264->235|268->239|268->239|268->239|268->239|270->241|270->241|276->247|276->247|276->247|276->247|276->247|276->247|276->247|279->250|279->250|280->251|280->251|285->256|285->256|285->256|295->266|295->266|295->266|295->266|296->267|296->267|296->267|297->268|302->273|302->273|302->273|302->273|302->273|302->273|302->273|305->276|305->276|306->277|306->277|311->282|311->282|311->282|321->292|321->292|321->292|321->292|322->293|322->293|322->293|323->294|330->301|330->301|335->306|335->306|335->306|335->306|337->308|337->308|338->309|338->309|338->309|338->309|339->310|339->310|339->310|340->311|347->318|347->318
                    -- GENERATED --
                */
            