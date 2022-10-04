
package views.html.contabilidad.facturas

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
object formFacturaProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facturaForm: Form[Factura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*7.2*/getClassEstadoEditable/*7.24*/(i:String) = {{
	var isEditable:Boolean = new Boolean(false)
	
	
	if(i == null || (i.compareTo("18") == 0) ){
		isEditable = new Boolean(true)
	}
	
	isEditable
}};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*5.70*/(""" 

"""),format.raw/*16.2*/("""
<script>
$( function()"""),format.raw/*18.14*/("""{"""),format.raw/*18.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*18.48*/("""}"""),format.raw/*18.49*/(""")
</script>


	<div class="row menu-acciones">
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default" title="Guardar factura"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	
	    	"""),_display_(Seq[Any](/*26.8*/if(facturaForm.field("estado.id").value != null && (facturaForm.field("estado.id").value.toInt ==  models.Estado.FACTURA_ESTADO_ENCURSO))/*26.145*/{_display_(Seq[Any](format.raw/*26.146*/("""
	    		<button type="submit" id="guardarPreaprobar" name="guardarPreaprobar" class="btn btn-default" title="Guardar y preaprobar factura">
	    			<i class="glyphicon glyphicon-floppy-disk"></i> 
	    			<i class="glyphicon glyphicon-arrow-right"></i>
	    			Guardar y Preaprobar
	    		</button>
	    	""")))})),format.raw/*32.8*/("""
	    	<a href=""""),_display_(Seq[Any](/*33.17*/if(request().getHeader("referer"))/*33.51*/{_display_(Seq[Any](format.raw/*33.52*/(""" """),_display_(Seq[Any](/*33.54*/request()/*33.63*/.getHeader("referer"))),format.raw/*33.84*/(""" """)))}/*33.87*/else/*33.92*/{_display_(Seq[Any](_display_(Seq[Any](/*33.94*/controllers/*33.105*/.contabilidad.routes.FacturasController.index())),_display_(Seq[Any](/*33.153*/UriTrack/*33.161*/.decode()))))})),format.raw/*33.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	    <div class="col-sm-4">
			"""),_display_(Seq[Any](/*36.5*/if(facturaForm("tipoCuenta").value != null)/*36.48*/{_display_(Seq[Any](format.raw/*36.49*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*37.65*/facturaForm("tipoCuenta.nombre")/*37.97*/.value)),format.raw/*37.103*/("""</span>
			""")))})),format.raw/*38.5*/("""
		</div>
	    <div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*41.14*/UriTrack/*41.22*/.decode())),format.raw/*41.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*42.5*/if(facturaForm.field("id").value)/*42.38*/{_display_(Seq[Any](format.raw/*42.39*/("""<a href=""""),_display_(Seq[Any](/*42.49*/controllers/*42.60*/.contabilidad.routes.FacturasController.ver(facturaForm.field("id").value.toLong))),_display_(Seq[Any](/*42.142*/UriTrack/*42.150*/.get("&"))),format.raw/*42.159*/("""" title="Ver factura" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*42.259*/("""
		</div>
	</div>

	<input type="hidden" name="""),_display_(Seq[Any](/*46.29*/UriTrack/*46.37*/.getKey())),format.raw/*46.46*/(""" value=""""),_display_(Seq[Any](/*46.55*/UriTrack/*46.63*/.code())),format.raw/*46.70*/("""" />
	"""),_display_(Seq[Any](/*47.3*/inputText(facturaForm("id"), 'type -> "hidden", 'id -> "facturaId"))),format.raw/*47.70*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*50.28*/if(facturaForm.error("nombre") != null)/*50.67*/ {_display_(Seq[Any](format.raw/*50.69*/("""has-error""")))})),format.raw/*50.79*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*52.6*/inputText(facturaForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*52.88*/("""
				"""),_display_(Seq[Any](/*53.6*/facturaForm("nombre")/*53.27*/.error.map/*53.37*/{ error =>_display_(Seq[Any](format.raw/*53.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*54.31*/error/*54.36*/.message)),format.raw/*54.44*/("""</div>
				""")))})),format.raw/*55.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*59.28*/if(facturaForm.error("referencia") != null)/*59.71*/ {_display_(Seq[Any](format.raw/*59.73*/("""has-error""")))})),format.raw/*59.83*/("""">
				<label for="inputNombre" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*61.6*/inputText(facturaForm("referencia"), 'class -> "form-control"))),format.raw/*61.68*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*66.28*/if(facturaForm.error("proveedor_id") != null)/*66.73*/ {_display_(Seq[Any](format.raw/*66.75*/("""has-error""")))}/*66.85*/else/*66.89*/{_display_(Seq[Any](format.raw/*66.90*/("""has-required""")))})),format.raw/*66.103*/("""">
				<label for="inputProveedor" class="control-label">Contraparte</label>
				"""),_display_(Seq[Any](/*68.6*/if(getClassEstadoEditable(facturaForm.field("estado.id").value))/*68.70*/{_display_(Seq[Any](format.raw/*68.71*/(""" 
					<div class="input-group">
						"""),_display_(Seq[Any](/*70.8*/inputText(facturaForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*70.96*/("""
						"""),_display_(Seq[Any](/*71.8*/inputText(facturaForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*71.90*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*76.22*/controllers/*76.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*76.84*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.proveedor.simple" 
										data-label="#proveedor" 
										data-field="#proveedor_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
						
						"""),_display_(Seq[Any](/*86.8*/facturaForm("proveedor_id")/*86.35*/.error.map/*86.45*/{ error =>_display_(Seq[Any](format.raw/*86.55*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*87.33*/error/*87.38*/.message)),format.raw/*87.46*/("""</div>
						""")))})),format.raw/*88.8*/("""
					</div>
				""")))}/*90.6*/else/*90.10*/{_display_(Seq[Any](format.raw/*90.11*/("""
					"""),_display_(Seq[Any](/*91.7*/inputText(facturaForm("proveedor.nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*91.99*/("""
					"""),_display_(Seq[Any](/*92.7*/inputText(facturaForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id",'readOnly -> "readOnly"))),format.raw/*92.113*/("""
				""")))})),format.raw/*93.6*/("""
			</div>
		</div>
		 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*98.28*/if(facturaForm.error("expediente_id") != null)/*98.74*/ {_display_(Seq[Any](format.raw/*98.76*/("""has-error""")))}/*98.86*/else/*98.90*/{_display_(Seq[Any](format.raw/*98.91*/("""has-required""")))})),format.raw/*98.104*/("""">
				<label for="inputExpediente" class="control-label">Expediente</label>
				"""),_display_(Seq[Any](/*100.6*/if(getClassEstadoEditable(facturaForm.field("estado.id").value))/*100.70*/{_display_(Seq[Any](format.raw/*100.71*/(""" 
					<div class="input-group">
						"""),_display_(Seq[Any](/*102.8*/inputText(facturaForm("expediente.expedienteEjercicio"),'class -> "form-control",'id -> "expediente"))),format.raw/*102.109*/("""
						"""),_display_(Seq[Any](/*103.8*/inputText(facturaForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*103.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*108.22*/controllers/*108.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*108.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
					"""),_display_(Seq[Any](/*118.7*/facturaForm("expediente_id")/*118.35*/.error.map/*118.45*/{ error =>_display_(Seq[Any](format.raw/*118.55*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*119.32*/error/*119.37*/.message)),format.raw/*119.45*/("""</div>
					""")))})),format.raw/*120.7*/("""
				""")))}/*121.6*/else/*121.10*/{_display_(Seq[Any](format.raw/*121.11*/("""
					"""),_display_(Seq[Any](/*122.7*/inputText(facturaForm("expediente.expedienteEjercicio"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*122.113*/("""	
					"""),_display_(Seq[Any](/*123.7*/inputText(facturaForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id",'readOnly -> "readOnly"))),format.raw/*123.114*/("""		
				""")))})),format.raw/*124.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*128.28*/if(facturaForm.error("periodo_id") != null)/*128.71*/ {_display_(Seq[Any](format.raw/*128.73*/("""has-error""")))})),format.raw/*128.83*/("""">
				<label for="periodo" class="control-label">Periodo</label>
				"""),_display_(Seq[Any](/*130.6*/if(getClassEstadoEditable(facturaForm.field("estado.id").value))/*130.70*/{_display_(Seq[Any](format.raw/*130.71*/(""" 
					<div class="input-group">
						"""),_display_(Seq[Any](/*132.8*/inputText(facturaForm("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*132.92*/("""
						"""),_display_(Seq[Any](/*133.8*/inputText(facturaForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*133.85*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPeriodo" 
										data-title="Selección de Periodo" 
										data-url=""""),_display_(Seq[Any](/*138.22*/controllers/*138.33*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*138.86*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.periodo.simple" 
										data-label="#periodo" 
										data-field="#periodo_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				""")))}/*148.6*/else/*148.10*/{_display_(Seq[Any](format.raw/*148.11*/("""
					"""),_display_(Seq[Any](/*149.7*/inputText(facturaForm("periodo.nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*149.97*/("""			
				""")))})),format.raw/*150.6*/("""
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*157.28*/if(facturaForm.error("numero_factura") != null)/*157.75*/ {_display_(Seq[Any](format.raw/*157.77*/("""has-error""")))})),format.raw/*157.87*/("""">
				<label for="inputNumeroFactura" class="control-label">N° de factura</label> 
				"""),_display_(Seq[Any](/*159.6*/inputText(facturaForm("numero_factura"),'id->"nfform", 'class -> "form-control"))),format.raw/*159.86*/("""
			</div>
			"""),_display_(Seq[Any](/*161.5*/facturaForm("numero_factura")/*161.34*/.error.map/*161.44*/{ error =>_display_(Seq[Any](format.raw/*161.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*162.31*/error/*162.36*/.message)),format.raw/*162.44*/("""</div>
				""")))})),format.raw/*163.6*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*166.28*/if(facturaForm.error("fecha_factura") != null)/*166.74*/ {_display_(Seq[Any](format.raw/*166.76*/("""has-error""")))})),format.raw/*166.86*/("""">
				<label for="fecha_factura" class="control-label">Fecha factura</label> 
				"""),_display_(Seq[Any](/*168.6*/inputText(facturaForm("fecha_factura"),'class -> "form-control date", 'id -> "fecha_factura"))),format.raw/*168.99*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*172.28*/if(facturaForm.error("fecha_recepcion") != null)/*172.76*/ {_display_(Seq[Any](format.raw/*172.78*/("""has-error""")))})),format.raw/*172.88*/("""">
				<label class="control-label">
					Fecha recepción
					"""),_display_(Seq[Any](/*175.7*/inputText(facturaForm("fecha_recepcion"),'class -> "form-control date"))),format.raw/*175.78*/("""
				</label> 
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*181.28*/if(facturaForm.error("fecha_aprobacion") != null)/*181.77*/ {_display_(Seq[Any](format.raw/*181.79*/("""has-error""")))})),format.raw/*181.89*/("""">
				<label class="control-label">
					Fecha aprobación
					"""),_display_(Seq[Any](/*184.7*/inputText(facturaForm("fecha_aprobacion"),'class -> "form-control date"))),format.raw/*184.79*/("""
				</label> 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="fecha_orden_pago" class="control-label">Fecha vencimiento 322</label> 
				"""),_display_(Seq[Any](/*191.6*/inputText(facturaForm("fecha_vencimiento_322"),'class -> "form-control date", 'id -> "fecha_vencimiento_322"))),format.raw/*191.115*/("""
			</div>
		</div>
		<!-- <div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label"> 
					PROFE
					"""),_display_(Seq[Any](/*198.7*/checkbox(facturaForm("profe")))),format.raw/*198.37*/("""
				</label>
			</div> 
		</div> -->
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*203.28*/if(facturaForm.error("tipo_cuenta_id") != null)/*203.75*/ {_display_(Seq[Any](format.raw/*203.77*/("""has-error""")))})),format.raw/*203.87*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*205.6*/select(facturaForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*205.164*/("""
				"""),_display_(Seq[Any](/*206.6*/facturaForm("tipo_cuenta_id")/*206.35*/.error.map/*206.45*/{ error =>_display_(Seq[Any](format.raw/*206.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*207.31*/error/*207.36*/.message)),format.raw/*207.44*/("""</div>
				""")))})),format.raw/*208.6*/("""
			</div>
		</div>
	</div>	
	
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*215.28*/if(facturaForm.error("cuenta_id") != null)/*215.70*/ {_display_(Seq[Any](format.raw/*215.72*/("""has-error""")))}/*215.82*/else/*215.86*/{_display_(Seq[Any](format.raw/*215.87*/("""has-required""")))})),format.raw/*215.100*/("""">
				<label for="inputCuenta" class="control-label">Cuenta</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*218.7*/inputText(facturaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta"))),format.raw/*218.89*/("""
					"""),_display_(Seq[Any](/*219.7*/inputText(facturaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id"))),format.raw/*219.82*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuenta" 
									data-title="Selección de Cuenta" 
									data-url=""""),_display_(Seq[Any](/*224.21*/controllers/*224.32*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*224.84*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuenta.simple" 
									data-label="#cuenta" 
									data-field="#cuenta_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
			"""),_display_(Seq[Any](/*235.5*/facturaForm("cuenta_id")/*235.29*/.error.map/*235.39*/{ error =>_display_(Seq[Any](format.raw/*235.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*236.31*/error/*236.36*/.message)),format.raw/*236.44*/("""</div>
				""")))})),format.raw/*237.6*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*240.28*/if(facturaForm.error("orden_pago_id") != null)/*240.74*/ {_display_(Seq[Any](format.raw/*240.76*/("""has-error""")))})),format.raw/*240.86*/("""">
				<label for="orden_pago_id" class="control-label">Orden de pago N° </label>
				"""),_display_(Seq[Any](/*242.6*/if(getClassEstadoEditable(facturaForm.field("estado.id").value))/*242.70*/{_display_(Seq[Any](format.raw/*242.71*/("""  
					<div class="input-group">
						"""),_display_(Seq[Any](/*244.8*/inputText(facturaForm("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*244.105*/("""
						"""),_display_(Seq[Any](/*245.8*/inputText(facturaForm("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*245.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOrdenPago" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*250.22*/controllers/*250.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*250.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				""")))}/*260.6*/else/*260.10*/{_display_(Seq[Any](format.raw/*260.11*/("""
					"""),_display_(Seq[Any](/*261.7*/inputText(facturaForm("ordenPago.nombreCompleto"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*261.107*/("""			
				""")))})),format.raw/*262.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*266.28*/if(facturaForm.error("fecha_orden_pago") != null)/*266.77*/ {_display_(Seq[Any](format.raw/*266.79*/("""has-error""")))})),format.raw/*266.89*/("""">
				<label for="fecha_orden_pago" class="control-label">Fecha orden de pago</label> 
				"""),_display_(Seq[Any](/*268.6*/if(getClassEstadoEditable(facturaForm.field("estado.id").value))/*268.70*/{_display_(Seq[Any](format.raw/*268.71*/("""
					"""),_display_(Seq[Any](/*269.7*/inputText(facturaForm("fecha_orden_pago"),'class -> "form-control date", 'id -> "fecha_orden_pago"))),format.raw/*269.106*/("""
				""")))}/*270.6*/else/*270.10*/{_display_(Seq[Any](format.raw/*270.11*/("""
					"""),_display_(Seq[Any](/*271.7*/inputText(facturaForm("fecha_orden_pago"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*271.99*/("""			
				""")))})),format.raw/*272.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*276.28*/if(facturaForm.error("cot_dolar") != null)/*276.70*/ {_display_(Seq[Any](format.raw/*276.72*/("""has-error""")))})),format.raw/*276.82*/("""">
				<label class="control-label">Cot. dolar</label>
				<div class="form-group">
					"""),_display_(Seq[Any](/*279.7*/inputText(facturaForm("cot_dolar"), 'class -> "form-control",'id -> "cot_dolar"))),format.raw/*279.87*/("""
					"""),_display_(Seq[Any](/*280.7*/facturaForm("cot_dolar")/*280.31*/.error.map/*280.41*/{ error =>_display_(Seq[Any](format.raw/*280.51*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*281.32*/error/*281.37*/.message)),format.raw/*281.45*/("""</div>
					""")))})),format.raw/*282.7*/("""
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe libre deuda DGR
					"""),_display_(Seq[Any](/*292.7*/checkbox(facturaForm("debe_dgr")))),format.raw/*292.40*/("""
				</label>
			</div> 
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe libre deuda DGR aguinaldo
					"""),_display_(Seq[Any](/*300.7*/checkbox(facturaForm("debe_dgr_aguinaldo")))),format.raw/*300.50*/("""
				</label>
			</div> 
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe constancia AFIP
					"""),_display_(Seq[Any](/*308.7*/checkbox(facturaForm("debe_afip")))),format.raw/*308.41*/("""
				</label>
			</div> 
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label"> 
					Debe Judicial
					"""),_display_(Seq[Any](/*316.7*/checkbox(facturaForm("debe_judicial")))),format.raw/*316.45*/("""
				</label>
			</div> 
		</div>
		
		
		
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">Creacion Automatica
				"""),_display_(Seq[Any](/*328.6*/checkbox(facturaForm("creacion_automatica")))),format.raw/*328.50*/("""</label> 
			</div>
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">Agente Pago Externo
				"""),_display_(Seq[Any](/*334.6*/checkbox(facturaForm("agente_pago_externo")))),format.raw/*334.50*/("""</label> 
			</div>
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">Produccion
				"""),_display_(Seq[Any](/*340.6*/checkbox(facturaForm("produccion")))),format.raw/*340.41*/("""</label> 
			</div>
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debito Automatico
					"""),_display_(Seq[Any](/*347.7*/checkbox(facturaForm("debito_automatico")))),format.raw/*347.49*/("""
				</label>
			</div> 
		</div>
	</div>"""))}
    }
    
    def render(facturaForm:Form[Factura]): play.api.templates.HtmlFormat.Appendable = apply(facturaForm)
    
    def f:((Form[Factura]) => play.api.templates.HtmlFormat.Appendable) = (facturaForm) => apply(facturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/formFacturaProveedor.scala.html
                    HASH: f5ac944c14309b959914e5c51f548cdfde11d131
                    MATRIX: 818->1|986->86|1018->110|1075->158|1105->180|1296->29|1324->154|1354->341|1405->364|1434->365|1495->398|1524->399|1784->624|1931->761|1971->762|2308->1068|2361->1085|2404->1119|2443->1120|2481->1122|2499->1131|2542->1152|2563->1155|2576->1160|2624->1162|2645->1173|2724->1221|2742->1229|2779->1239|2971->1396|3023->1439|3062->1440|3163->1505|3204->1537|3233->1543|3276->1555|3363->1606|3380->1614|3411->1623|3548->1725|3590->1758|3629->1759|3675->1769|3695->1780|3808->1862|3826->1870|3858->1879|3991->1979|4074->2026|4091->2034|4122->2043|4167->2052|4184->2060|4213->2067|4255->2074|4344->2141|4452->2213|4500->2252|4540->2254|4582->2264|4692->2339|4796->2421|4837->2427|4867->2448|4886->2458|4934->2468|5001->2499|5015->2504|5045->2512|5088->2524|5196->2596|5248->2639|5288->2641|5330->2651|5444->2730|5528->2792|5639->2867|5693->2912|5733->2914|5762->2924|5775->2928|5814->2929|5860->2942|5977->3024|6050->3088|6089->3089|6164->3129|6274->3217|6317->3225|6421->3307|6638->3488|6658->3499|6731->3550|7048->3832|7084->3859|7103->3869|7151->3879|7220->3912|7234->3917|7264->3925|7309->3939|7345->3957|7358->3961|7397->3962|7439->3969|7553->4061|7595->4068|7724->4174|7761->4180|7873->4256|7928->4302|7968->4304|7997->4314|8010->4318|8049->4319|8095->4332|8213->4414|8287->4478|8327->4479|8403->4519|8528->4620|8572->4628|8678->4711|8896->4892|8917->4903|8994->4957|9319->5246|9357->5274|9377->5284|9426->5294|9495->5326|9510->5331|9541->5339|9586->5352|9611->5358|9625->5362|9665->5363|9708->5370|9838->5476|9882->5484|10013->5591|10053->5599|10162->5671|10215->5714|10256->5716|10299->5726|10406->5797|10480->5861|10520->5862|10596->5902|10703->5986|10747->5994|10847->6071|11059->6246|11080->6257|11156->6310|11454->6589|11468->6593|11508->6594|11551->6601|11664->6691|11705->6700|11844->6802|11901->6849|11942->6851|11985->6861|12110->6950|12213->7030|12264->7045|12303->7074|12323->7084|12372->7094|12440->7125|12455->7130|12486->7138|12530->7150|12629->7212|12685->7258|12726->7260|12769->7270|12889->7354|13005->7447|13114->7519|13172->7567|13213->7569|13256->7579|13356->7643|13450->7714|13576->7803|13635->7852|13676->7854|13719->7864|13820->7929|13915->8001|14130->8180|14263->8289|14427->8417|14480->8447|14607->8537|14664->8584|14705->8586|14748->8596|14845->8657|15027->8815|15069->8821|15108->8850|15128->8860|15177->8870|15245->8901|15260->8906|15291->8914|15335->8926|15474->9028|15526->9070|15567->9072|15597->9082|15611->9086|15651->9087|15698->9100|15840->9206|15945->9288|15988->9295|16086->9370|16291->9538|16312->9549|16387->9601|16699->9877|16733->9901|16753->9911|16802->9921|16870->9952|16885->9957|16916->9965|16960->9977|17059->10039|17115->10085|17156->10087|17199->10097|17322->10184|17396->10248|17436->10249|17513->10290|17634->10387|17678->10395|17784->10478|18006->10663|18027->10674|18107->10731|18414->11019|18428->11023|18468->11024|18511->11031|18635->11131|18676->11140|18785->11212|18844->11261|18885->11263|18928->11273|19057->11366|19131->11430|19171->11431|19214->11438|19337->11537|19362->11543|19376->11547|19416->11548|19459->11555|19574->11647|19615->11656|19724->11728|19776->11770|19817->11772|19860->11782|19986->11872|20089->11952|20132->11959|20166->11983|20186->11993|20235->12003|20304->12035|20319->12040|20350->12048|20395->12061|20607->12237|20663->12270|20861->12432|20927->12475|21115->12627|21172->12661|21353->12806|21414->12844|21629->13023|21696->13067|21870->13205|21937->13249|22102->13378|22160->13413|22340->13557|22405->13599
                    LINES: 26->1|33->5|33->5|33->7|33->7|43->1|44->5|46->16|48->18|48->18|48->18|48->18|56->26|56->26|56->26|62->32|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|63->33|66->36|66->36|66->36|67->37|67->37|67->37|68->38|71->41|71->41|71->41|72->42|72->42|72->42|72->42|72->42|72->42|72->42|72->42|72->42|76->46|76->46|76->46|76->46|76->46|76->46|77->47|77->47|80->50|80->50|80->50|80->50|82->52|82->52|83->53|83->53|83->53|83->53|84->54|84->54|84->54|85->55|89->59|89->59|89->59|89->59|91->61|91->61|96->66|96->66|96->66|96->66|96->66|96->66|96->66|98->68|98->68|98->68|100->70|100->70|101->71|101->71|106->76|106->76|106->76|116->86|116->86|116->86|116->86|117->87|117->87|117->87|118->88|120->90|120->90|120->90|121->91|121->91|122->92|122->92|123->93|128->98|128->98|128->98|128->98|128->98|128->98|128->98|130->100|130->100|130->100|132->102|132->102|133->103|133->103|138->108|138->108|138->108|148->118|148->118|148->118|148->118|149->119|149->119|149->119|150->120|151->121|151->121|151->121|152->122|152->122|153->123|153->123|154->124|158->128|158->128|158->128|158->128|160->130|160->130|160->130|162->132|162->132|163->133|163->133|168->138|168->138|168->138|178->148|178->148|178->148|179->149|179->149|180->150|187->157|187->157|187->157|187->157|189->159|189->159|191->161|191->161|191->161|191->161|192->162|192->162|192->162|193->163|196->166|196->166|196->166|196->166|198->168|198->168|202->172|202->172|202->172|202->172|205->175|205->175|211->181|211->181|211->181|211->181|214->184|214->184|221->191|221->191|228->198|228->198|233->203|233->203|233->203|233->203|235->205|235->205|236->206|236->206|236->206|236->206|237->207|237->207|237->207|238->208|245->215|245->215|245->215|245->215|245->215|245->215|245->215|248->218|248->218|249->219|249->219|254->224|254->224|254->224|265->235|265->235|265->235|265->235|266->236|266->236|266->236|267->237|270->240|270->240|270->240|270->240|272->242|272->242|272->242|274->244|274->244|275->245|275->245|280->250|280->250|280->250|290->260|290->260|290->260|291->261|291->261|292->262|296->266|296->266|296->266|296->266|298->268|298->268|298->268|299->269|299->269|300->270|300->270|300->270|301->271|301->271|302->272|306->276|306->276|306->276|306->276|309->279|309->279|310->280|310->280|310->280|310->280|311->281|311->281|311->281|312->282|322->292|322->292|330->300|330->300|338->308|338->308|346->316|346->316|358->328|358->328|364->334|364->334|370->340|370->340|377->347|377->347
                    -- GENERATED --
                */
            