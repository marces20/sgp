
package views.html.compras.ordenes

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
object formOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenForm: Form[Orden]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*10.17*/if(request().getHeader("referer"))/*10.51*/{_display_(Seq[Any](format.raw/*10.52*/(""" """),_display_(Seq[Any](/*10.54*/request()/*10.63*/.getHeader("referer"))),format.raw/*10.84*/(""" """)))}/*10.87*/else/*10.92*/{_display_(Seq[Any](_display_(Seq[Any](/*10.94*/controllers/*10.105*/.compras.routes.OrdenesController.index())),_display_(Seq[Any](/*10.147*/UriTrack/*10.155*/.decode()))))})),format.raw/*10.165*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	    <div class="col-sm-5">
			"""),_display_(Seq[Any](/*13.5*/if(ordenForm("tipoCuenta").value != null)/*13.46*/{_display_(Seq[Any](format.raw/*13.47*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*14.65*/ordenForm("tipoCuenta.nombre")/*14.95*/.value)),format.raw/*14.101*/("""</span>
			""")))})),format.raw/*15.5*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*18.14*/UriTrack/*18.22*/.getOnNull(controllers.compras.routes.OrdenesController.index().absoluteURL()))),format.raw/*18.100*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*19.5*/if(ordenForm.field("id").value)/*19.36*/{_display_(Seq[Any](format.raw/*19.37*/("""<a href=""""),_display_(Seq[Any](/*19.47*/controllers/*19.58*/.compras.routes.OrdenesController.ver(ordenForm.field("id").value.toLong))),_display_(Seq[Any](/*19.132*/UriTrack/*19.140*/.get("&"))),format.raw/*19.149*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*19.247*/("""
		</div>
	</div>
	
	<input type="hidden" name="""),_display_(Seq[Any](/*23.29*/UriTrack/*23.37*/.getKey())),format.raw/*23.46*/(""" value=""""),_display_(Seq[Any](/*23.55*/UriTrack/*23.63*/.code())),format.raw/*23.70*/("""" />
	"""),_display_(Seq[Any](/*24.3*/inputText(ordenForm("id"), 'type -> "hidden", 'id -> "ordenId"))),format.raw/*24.66*/("""
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label> 
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(ordenForm.error("nombre") != null)/*28.65*/ {_display_(Seq[Any](format.raw/*28.67*/("""has-error""")))})),format.raw/*28.77*/("""">
				"""),_display_(Seq[Any](/*29.6*/inputText(ordenForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*29.86*/("""
				"""),_display_(Seq[Any](/*30.6*/ordenForm("nombre")/*30.25*/.error.map/*30.35*/{ error =>_display_(Seq[Any](format.raw/*30.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*31.31*/error/*31.36*/.message)),format.raw/*31.44*/("""</div>
				""")))})),format.raw/*32.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<div class="input-group """),_display_(Seq[Any](/*37.29*/if(ordenForm.error("proveedor_id") != null)/*37.72*/ {_display_(Seq[Any](format.raw/*37.74*/("""has-error""")))}/*37.84*/else/*37.88*/{_display_(Seq[Any](format.raw/*37.89*/("""has-required""")))})),format.raw/*37.102*/("""">	
				"""),_display_(Seq[Any](/*38.6*/inputText(ordenForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*38.92*/("""
				"""),_display_(Seq[Any](/*39.6*/inputText(ordenForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*39.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de proveedor" data-url=""""),_display_(Seq[Any](/*41.97*/controllers/*41.108*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*41.159*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.proveedor.simple" data-label="#proveedor" data-field="#proveedor_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*44.5*/ordenForm("proveedor_id")/*44.30*/.error.map/*44.40*/{ error =>_display_(Seq[Any](format.raw/*44.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*45.30*/error/*45.35*/.message)),format.raw/*45.43*/("""</div>
			""")))})),format.raw/*46.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha orden</label> 
			<div class="form-group ">
				"""),_display_(Seq[Any](/*51.6*/inputText(ordenForm("fecha_orden"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*51.95*/("""
			</div>
			"""),_display_(Seq[Any](/*53.5*/ordenForm("fecha_orden")/*53.29*/.error.map/*53.39*/{ error =>_display_(Seq[Any](format.raw/*53.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*54.30*/error/*54.35*/.message)),format.raw/*54.43*/("""</div>
			""")))})),format.raw/*55.5*/("""
		</div>
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*59.29*/if(ordenForm.error("expediente_id") != null)/*59.73*/ {_display_(Seq[Any](format.raw/*59.75*/("""has-error""")))}/*59.85*/else/*59.89*/{_display_(Seq[Any](format.raw/*59.90*/("""has-required""")))})),format.raw/*59.103*/("""">
				"""),_display_(Seq[Any](/*60.6*/inputText(ordenForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*60.106*/("""
				"""),_display_(Seq[Any](/*61.6*/inputText(ordenForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*61.87*/("""
				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*62.119*/controllers/*62.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*62.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*64.5*/ordenForm("expediente_id")/*64.31*/.error.map/*64.41*/{ error =>_display_(Seq[Any](format.raw/*64.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*65.30*/error/*65.35*/.message)),format.raw/*65.43*/("""</div>
			""")))})),format.raw/*66.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Periodo</label> 
			<div class="form-group """),_display_(Seq[Any](/*70.28*/if(ordenForm.error("periodo.id") != null)/*70.69*/ {_display_(Seq[Any](format.raw/*70.71*/("""has-error""")))})),format.raw/*70.81*/("""">
				<div class="input-group">
				"""),_display_(Seq[Any](/*72.6*/inputText(ordenForm("periodo.nombre"),'class -> "form-control", 'id -> "periodo"))),format.raw/*72.87*/("""
				"""),_display_(Seq[Any](/*73.6*/inputText(ordenForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*73.81*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*78.21*/controllers/*78.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*78.85*/("""" 
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
		
	
	</div>
	
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Solicitud de Compras</label>
			<div class="input-group """),_display_(Seq[Any](/*98.29*/if(ordenForm.error("solicitud_id") != null)/*98.72*/ {_display_(Seq[Any](format.raw/*98.74*/("""has-error""")))})),format.raw/*98.84*/("""">
				
				"""),_display_(Seq[Any](/*100.6*/inputText(ordenForm("solicitud.referencia"),'class -> "form-control",'id -> "solicitud"))),format.raw/*100.94*/(""" 
				"""),_display_(Seq[Any](/*101.6*/inputText(ordenForm("solicitud_id"),'hidden -> "hidden",'id -> "solicitud_id"))),format.raw/*101.84*/("""
				<span class="input-group-addon"><a href="#" id="searchSolicitud" 
															data-title="Selección de solicitud" 
															data-url=""""),_display_(Seq[Any](/*104.27*/controllers/*104.38*/.compras.routes.SolicitudesController.modalBuscar())),format.raw/*104.89*/("""" 
															data-height="650" 
															data-width="700" 
															data-listen="modal.seleccion.solicitud.simple" 
															data-label="#solicitud" 
															data-field="#solicitud_id">
															<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Orden de provisión</label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*116.6*/inputText(ordenForm("numero_orden_provision"), 'class -> "form-control",'id -> "numero_orden_provision"))),format.raw/*116.110*/("""
				<span class="input-group-addon">
				<a href="#" id="getLastNumeroProvision" 
							data-url=""""),_display_(Seq[Any](/*119.19*/controllers/*119.30*/.patrimonio.routes.OrdenesProvisionController.getLastNumeroProvision())),format.raw/*119.100*/(""""
				/><i class="glyphicon glyphicon-record"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*122.5*/ordenForm("numero_orden_provision")/*122.40*/.error.map/*122.50*/{ error =>_display_(Seq[Any](format.raw/*122.60*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*123.30*/error/*123.35*/.message)),format.raw/*123.43*/("""</div>
			""")))})),format.raw/*124.5*/("""
			<div class="hide errorOp text-error"></div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha provisión</label> 
			<div class="form-group """),_display_(Seq[Any](/*129.28*/if(ordenForm.error("fecha_provision")  != null)/*129.75*/ {_display_(Seq[Any](format.raw/*129.77*/("""has-error""")))})),format.raw/*129.87*/("""">
				"""),_display_(Seq[Any](/*130.6*/inputText(ordenForm("fecha_provision"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*130.99*/("""
			</div>
			"""),_display_(Seq[Any](/*132.5*/ordenForm("fecha_provision")/*132.33*/.error.map/*132.43*/{ error =>_display_(Seq[Any](format.raw/*132.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*133.30*/error/*133.35*/.message)),format.raw/*133.43*/("""</div>
			""")))})),format.raw/*134.5*/("""
		</div>
		
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group """),_display_(Seq[Any](/*139.29*/if(ordenForm.error("deposito_id") != null)/*139.71*/ {_display_(Seq[Any](format.raw/*139.73*/("""has-error""")))}/*139.83*/else/*139.87*/{_display_(Seq[Any](format.raw/*139.88*/("""has-required""")))})),format.raw/*139.101*/("""">
				"""),_display_(Seq[Any](/*140.6*/inputText(ordenForm("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*140.120*/("""
				"""),_display_(Seq[Any](/*141.6*/inputText(ordenForm("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*141.83*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*144.29*/controllers/*144.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*144.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*150.5*/ordenForm("deposito_id")/*150.29*/.error.map/*150.39*/{ error =>_display_(Seq[Any](format.raw/*150.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*151.30*/error/*151.35*/.message)),format.raw/*151.43*/("""</div>
			""")))})),format.raw/*152.5*/("""
		</div>		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*155.28*/if(ordenForm.error("tipo_contratacion") != null)/*155.76*/ {_display_(Seq[Any](format.raw/*155.78*/("""has-error""")))})),format.raw/*155.88*/("""">
				<label class="control-label">Tipo contratación
				"""),_display_(Seq[Any](/*157.6*/select(ordenForm("tipo_contratacion"), options("compras"->"Compra Directa",
														"licitacion"->"Licitacion Pública",
														"licitacion_pri"->"Licitacion Privada",
														"contratacion"->"Contratacion",
														"contratacion_directa"->"Contratacion Directa",
														"concurso_precios"->"Concurso de Precios"
														), 
				'class -> "form-control select"))),format.raw/*164.37*/("""</label>
			</div>
		</div>		
				
	</div>
	<div class="row" id="">
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*172.28*/if(ordenForm.error("tipo_orden") != null)/*172.69*/ {_display_(Seq[Any](format.raw/*172.71*/("""has-error""")))})),format.raw/*172.81*/("""">
				<label class="control-label">Tipo Orden</label>
				"""),_display_(Seq[Any](/*174.6*/select(ordenForm("tipo_orden"), options(
														""->"Seleccion Tipo de Orden",
														"comun"->"Recepcion de Productos (Patrimonio)",
														"servicio"->"Certificacion de Servicios (Patrimonio)",
														"personal"->"Contratos Personal (Personal)",
														"certificacioncompra"->"Certificaciones Compras (Compras)",
														"certificacionobra"->"Certificaciones Obras (Infraestructura)",
														"haberesrelacion"->"Haberes Contratos Relacion (Liquidaciones)",
														"imputacion"->"Imputacion Presupuesto (Contabilidad)"), 
				'class -> "form-control select",'id -> "tipo_orden_id"))),format.raw/*183.60*/("""
				<!-- "sinop"->"Sin Orden de Provision (Compras)", -->
				"""),_display_(Seq[Any](/*185.6*/ordenForm("tipo_orden")/*185.29*/.error.map/*185.39*/{ error =>_display_(Seq[Any](format.raw/*185.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*186.31*/error/*186.36*/.message)),format.raw/*186.44*/("""</div>
				""")))})),format.raw/*187.6*/("""
			</div>
		</div>	
		<div class="col-sm-3">
			<!--<div class="col-sm-6">
				<div class="checkbox">
					<label class="control-label">Creacion Automatica
					"""),_display_(Seq[Any](/*194.7*/checkbox(ordenForm("creacion_automatica")))),format.raw/*194.49*/("""</label> 
				</div>
			</div>
			  <div class="col-sm-6">
				<div class="checkbox">
					<label class="control-label"> 
						Profe
						"""),_display_(Seq[Any](/*201.8*/checkbox(ordenForm("profe")))),format.raw/*201.36*/("""
					</label>
				</div>
			</div>-->
			<input type="hidden" name="creacion_automatica" id="creacion_automatica" value="true"/>
			 
			<div class="form-group """),_display_(Seq[Any](/*207.28*/if(ordenForm.error("tipo_cuenta_id") != null)/*207.73*/ {_display_(Seq[Any](format.raw/*207.75*/("""has-error""")))})),format.raw/*207.85*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*209.6*/select(ordenForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*209.162*/("""
				"""),_display_(Seq[Any](/*210.6*/ordenForm("tipo_cuenta_id")/*210.33*/.error.map/*210.43*/{ error =>_display_(Seq[Any](format.raw/*210.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*211.31*/error/*211.36*/.message)),format.raw/*211.44*/("""</div>
				""")))})),format.raw/*212.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">	
			<div class="col-sm-6">
				<div class="form-group """),_display_(Seq[Any](/*218.29*/if(ordenForm.error("fecha_inicio") != null)/*218.72*/ {_display_(Seq[Any](format.raw/*218.74*/("""has-error""")))})),format.raw/*218.84*/("""">
					<label class="control-label">Fecha inicio</label> 
					"""),_display_(Seq[Any](/*220.7*/inputText(ordenForm("fecha_inicio"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*220.97*/("""
					"""),_display_(Seq[Any](/*221.7*/ordenForm("fecha_inicio")/*221.32*/.error.map/*221.42*/{ error =>_display_(Seq[Any](format.raw/*221.52*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*222.32*/error/*222.37*/.message)),format.raw/*222.45*/("""</div>
					""")))})),format.raw/*223.7*/("""
				</div>
			</div>
				
			<div class="col-sm-6">
				<div class="form-group """),_display_(Seq[Any](/*228.29*/if(ordenForm.error("fecha_fin") != null)/*228.69*/ {_display_(Seq[Any](format.raw/*228.71*/("""has-error""")))})),format.raw/*228.81*/("""">
					<label class="control-label">Fecha fin</label> 
					"""),_display_(Seq[Any](/*230.7*/inputText(ordenForm("fecha_fin"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*230.94*/("""
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*235.28*/if(ordenForm.error("fecha_entrega") != null)/*235.72*/ {_display_(Seq[Any](format.raw/*235.74*/("""has-error""")))})),format.raw/*235.84*/("""">
				<label class="control-label">Fecha entrega</label> 
				"""),_display_(Seq[Any](/*237.6*/inputText(ordenForm("fecha_entrega"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*237.97*/("""
				"""),_display_(Seq[Any](/*238.6*/ordenForm("fecha_entrega")/*238.32*/.error.map/*238.42*/{ error =>_display_(Seq[Any](format.raw/*238.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*239.31*/error/*239.36*/.message)),format.raw/*239.44*/("""</div>
				""")))})),format.raw/*240.6*/("""
			</div>
		</div>
	</div>
	
	
	<div class="row contenedorRubros">
		<div class="col-sm-3">
			<div class="seleccionOrdenRubro form-group """),_display_(Seq[Any](/*248.48*/if(ordenForm.error("orden_rubro_id") != null)/*248.93*/ {_display_(Seq[Any](format.raw/*248.95*/("""has-error""")))})),format.raw/*248.105*/("""">
				<label for=""""),_display_(Seq[Any](/*249.18*/ordenForm("orden_rubro_id")/*249.45*/.id)),format.raw/*249.48*/("""" class="control-label">Rubro</label>
				"""),_display_(Seq[Any](/*250.6*/select(ordenForm("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*251.126*/("""
				"""),_display_(Seq[Any](/*252.6*/ordenForm("orden_rubro_id")/*252.33*/.error.map/*252.43*/{ error =>_display_(Seq[Any](format.raw/*252.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*253.31*/error/*253.36*/.message)),format.raw/*253.44*/("""</div>
				""")))})),format.raw/*254.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="seleccionSubrubros form-group """),_display_(Seq[Any](/*258.47*/if(ordenForm.error("orden_subrubro_id") != null)/*258.95*/ {_display_(Seq[Any](format.raw/*258.97*/("""has-error""")))})),format.raw/*258.107*/("""">
				<label for=""""),_display_(Seq[Any](/*259.18*/ordenForm("orden_subrubro_id")/*259.48*/.id)),format.raw/*259.51*/("""" class="control-label">Sub-Rubro</label>
				"""),_display_(Seq[Any](/*260.6*/select(ordenForm("orden_subrubro_id"), 
					ordenForm("ordenRubro.id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {OrdenSubrubro.getOrdenSubrubro(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*266.65*/("""
				"""),_display_(Seq[Any](/*267.6*/ordenForm("orden_subrubro_id")/*267.36*/.error.map/*267.46*/{ error =>_display_(Seq[Any](format.raw/*267.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*268.31*/error/*268.36*/.message)),format.raw/*268.44*/("""</div>
				""")))})),format.raw/*269.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Detalle Rubro</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*276.6*/inputText(ordenForm("detalle_rubro"), 'class -> "form-control",'id -> "detalle_rubro"))),format.raw/*276.92*/("""
				"""),_display_(Seq[Any](/*277.6*/ordenForm("detalle_rubro")/*277.32*/.error.map/*277.42*/{ error =>_display_(Seq[Any](format.raw/*277.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*278.31*/error/*278.36*/.message)),format.raw/*278.44*/("""</div>
				""")))})),format.raw/*279.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Monto adelanto</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*286.6*/inputText(ordenForm("monto_adelanto"), 'class -> "form-control",'id -> "monto_adelanto"))),format.raw/*286.94*/("""
				"""),_display_(Seq[Any](/*287.6*/ordenForm("monto_adelanto")/*287.33*/.error.map/*287.43*/{ error =>_display_(Seq[Any](format.raw/*287.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*288.31*/error/*288.36*/.message)),format.raw/*288.44*/("""</div>
				""")))})),format.raw/*289.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="row">

				<div class="col-sm-6">
					<label class="control-label">Cotización</label>
					<div class="form-group">
						"""),_display_(Seq[Any](/*299.8*/inputText(ordenForm("cot_dolar"), 'class -> "form-control",'id -> "monto_adelanto"))),format.raw/*299.91*/("""
						"""),_display_(Seq[Any](/*300.8*/ordenForm("cot_dolar")/*300.30*/.error.map/*300.40*/{ error =>_display_(Seq[Any](format.raw/*300.50*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*301.33*/error/*301.38*/.message)),format.raw/*301.46*/("""</div>
						""")))})),format.raw/*302.8*/("""
					</div>
				</div>
				
				<div class="col-sm-6">
					<label class="control-label">Moneda</label>
					<div class="form-group">
						"""),_display_(Seq[Any](/*309.8*/select(ordenForm("tipo_moneda"),TipoMoneda.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*309.161*/("""
						"""),_display_(Seq[Any](/*310.8*/ordenForm("tipo_moneda")/*310.32*/.error.map/*310.42*/{ error =>_display_(Seq[Any](format.raw/*310.52*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*311.33*/error/*311.38*/.message)),format.raw/*311.46*/("""</div>
						""")))})),format.raw/*312.8*/("""
					</div>
				</div>
			</div>		
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">N° Presupuesto</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*322.6*/inputText(ordenForm("numero_presupuesto"), 'class -> "form-control",'id -> "numero_presupuesto"))),format.raw/*322.102*/("""
			</div>
		</div>
		<div class="col-sm-10">
			<label class="control-label">Plazo Entrega</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*328.6*/inputText(ordenForm("plazo_entrega"), 'class -> "form-control",'id -> "detalle_rubro"))),format.raw/*328.92*/("""
			</div>
		</div>
	</div>
<script>
$( function() """),format.raw/*333.15*/("""{"""),format.raw/*333.16*/("""
	
	$('#getLastNumeroProvision').click( function() """),format.raw/*335.49*/("""{"""),format.raw/*335.50*/("""  
		if($("#expediente_id").val() == "")"""),format.raw/*336.38*/("""{"""),format.raw/*336.39*/("""
			alert ("Debe tener asignado un expediente para poder sugerir el N° provision.");
		"""),format.raw/*338.3*/("""}"""),format.raw/*338.4*/("""else"""),format.raw/*338.8*/("""{"""),format.raw/*338.9*/(""" 
			if($('#tipo_orden_id option:selected').val() == "comun" || $('#tipo_orden_id option:selected').val() == "servicio")"""),format.raw/*339.119*/("""{"""),format.raw/*339.120*/("""
				var url = $(this).attr("data-url");
				var data = $("#expediente_id").serialize();
				$.post(url, data, function(data)"""),format.raw/*342.37*/("""{"""),format.raw/*342.38*/("""
					if(data.success) """),format.raw/*343.23*/("""{"""),format.raw/*343.24*/("""
						$(".errorOp").html("N° sugerido: "+data.numero);
						$(".errorOp").removeClass("hide");
					"""),format.raw/*346.6*/("""}"""),format.raw/*346.7*/(""" else """),format.raw/*346.13*/("""{"""),format.raw/*346.14*/("""
						$(".errorOp").html(data.message)
						$(".errorOp").removeClass("hide");
					"""),format.raw/*349.6*/("""}"""),format.raw/*349.7*/("""
				"""),format.raw/*350.5*/("""}"""),format.raw/*350.6*/(""");
			"""),format.raw/*351.4*/("""}"""),format.raw/*351.5*/("""else"""),format.raw/*351.9*/("""{"""),format.raw/*351.10*/("""
				alert ("El tipo de orden de ser certificacion o recepción de patrimonio.");
			"""),format.raw/*353.4*/("""}"""),format.raw/*353.5*/("""
		"""),format.raw/*354.3*/("""}"""),format.raw/*354.4*/("""
	"""),format.raw/*355.2*/("""}"""),format.raw/*355.3*/(""");
	
	 
	
	urlOrdenSubrubro  = '"""),_display_(Seq[Any](/*359.24*/controllers/*359.35*/.compras.routes.OrdenSubrubroController.listOptions())),format.raw/*359.88*/("""';
	
	var contenedorRubros = $('.contenedorRubros');
	
	contenedorRubros.on('change', '.seleccionOrdenRubro .select', function()"""),format.raw/*363.74*/("""{"""),format.raw/*363.75*/("""
		var id = $(this).find('option:selected').val();
		var contenedor = $(this).closest('.contenedorRubros');
		contenedor.find('.seleccionSubrubros .select').find('option:gt(0)').remove();
		
		if(id == "") return false;

		$.get(urlOrdenSubrubro + '?rubroId='+id, function(data)"""),format.raw/*370.58*/("""{"""),format.raw/*370.59*/("""
			contenedor.find('.seleccionSubrubros .select').html(data);
		"""),format.raw/*372.3*/("""}"""),format.raw/*372.4*/(""");
	"""),format.raw/*373.2*/("""}"""),format.raw/*373.3*/(""");
	
"""),format.raw/*375.1*/("""}"""),format.raw/*375.2*/(""");
</script>
	"""))}
    }
    
    def render(ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(ordenForm)
    
    def f:((Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (ordenForm) => apply(ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/formOrden.scala.html
                    HASH: 69f58ac195e67ef4274a2a3a6d953d8623874f36
                    MATRIX: 799->1|941->60|973->84|1047->25|1075->128|1328->345|1371->379|1410->380|1448->382|1466->391|1509->412|1530->415|1543->420|1591->422|1612->433|1685->475|1703->483|1740->493|1932->650|1982->691|2021->692|2122->757|2161->787|2190->793|2233->805|2317->853|2334->861|2435->939|2572->1041|2612->1072|2651->1073|2697->1083|2717->1094|2822->1168|2840->1176|2872->1185|3003->1283|3087->1331|3104->1339|3135->1348|3180->1357|3197->1365|3226->1372|3268->1379|3353->1442|3513->1566|3559->1603|3599->1605|3641->1615|3684->1623|3786->1703|3827->1709|3855->1728|3874->1738|3922->1748|3989->1779|4003->1784|4033->1792|4076->1804|4236->1928|4288->1971|4328->1973|4357->1983|4370->1987|4409->1988|4455->2001|4499->2010|4607->2096|4648->2102|4750->2182|4920->2316|4941->2327|5015->2378|5273->2601|5307->2626|5326->2636|5374->2646|5440->2676|5454->2681|5484->2689|5526->2700|5683->2822|5794->2911|5844->2926|5877->2950|5896->2960|5944->2970|6010->3000|6024->3005|6054->3013|6096->3024|6264->3156|6317->3200|6357->3202|6386->3212|6399->3216|6438->3217|6484->3230|6527->3238|6650->3338|6691->3344|6794->3425|6950->3544|6971->3555|7048->3609|7289->3815|7324->3841|7343->3851|7391->3861|7457->3891|7471->3896|7501->3904|7543->3915|7690->4026|7740->4067|7780->4069|7822->4079|7895->4117|7998->4198|8039->4204|8136->4279|8341->4448|8361->4459|8436->4512|8907->4947|8959->4990|8999->4992|9041->5002|9090->5015|9201->5103|9244->5110|9345->5188|9531->5337|9552->5348|9626->5399|10084->5821|10212->5925|10350->6026|10371->6037|10465->6107|10577->6183|10622->6218|10642->6228|10691->6238|10758->6268|10773->6273|10804->6281|10847->6292|11050->6458|11107->6505|11148->6507|11191->6517|11235->6525|11351->6618|11402->6633|11440->6661|11460->6671|11509->6681|11576->6711|11591->6716|11622->6724|11665->6735|11836->6869|11888->6911|11929->6913|11959->6923|11973->6927|12013->6928|12060->6941|12104->6949|12242->7063|12284->7069|12384->7146|12575->7300|12596->7311|12671->7363|12988->7644|13022->7668|13042->7678|13091->7688|13158->7718|13173->7723|13204->7731|13247->7742|13348->7806|13406->7854|13447->7856|13490->7866|13585->7925|14006->8323|14166->8446|14217->8487|14258->8489|14301->8499|14397->8559|15057->9196|15157->9260|15190->9283|15210->9293|15259->9303|15327->9334|15342->9339|15373->9347|15417->9359|15616->9522|15681->9564|15858->9705|15909->9733|16108->9895|16163->9940|16204->9942|16247->9952|16344->10013|16524->10169|16566->10175|16603->10202|16623->10212|16672->10222|16740->10253|16755->10258|16786->10266|16830->10278|16970->10381|17023->10424|17064->10426|17107->10436|17208->10501|17321->10591|17364->10598|17399->10623|17419->10633|17468->10643|17537->10675|17552->10680|17583->10688|17628->10701|17746->10782|17796->10822|17837->10824|17880->10834|17978->10896|18088->10983|18208->11066|18262->11110|18303->11112|18346->11122|18446->11186|18560->11277|18602->11283|18638->11309|18658->11319|18707->11329|18775->11360|18790->11365|18821->11373|18865->11385|19042->11525|19097->11570|19138->11572|19182->11582|19239->11602|19276->11629|19302->11632|19381->11675|19567->11837|19609->11843|19646->11870|19666->11880|19715->11890|19783->11921|19798->11926|19829->11934|19873->11946|20001->12037|20059->12085|20100->12087|20144->12097|20201->12117|20241->12147|20267->12150|20350->12197|20708->12532|20750->12538|20790->12568|20810->12578|20859->12588|20927->12619|20942->12624|20973->12632|21017->12644|21188->12779|21297->12865|21339->12871|21375->12897|21395->12907|21444->12917|21512->12948|21527->12953|21558->12961|21602->12973|21774->13109|21885->13197|21927->13203|21964->13230|21984->13240|22033->13250|22101->13281|22116->13286|22147->13294|22191->13306|22414->13493|22520->13576|22564->13584|22596->13606|22616->13616|22665->13626|22735->13659|22750->13664|22781->13672|22827->13686|23005->13828|23182->13981|23226->13989|23260->14013|23280->14023|23329->14033|23399->14066|23414->14071|23445->14079|23491->14093|23712->14278|23832->14374|24001->14507|24110->14593|24190->14644|24220->14645|24300->14696|24330->14697|24399->14737|24429->14738|24544->14825|24573->14826|24605->14830|24634->14831|24784->14951|24815->14952|24969->15077|24999->15078|25051->15101|25081->15102|25211->15204|25240->15205|25275->15211|25305->15212|25419->15298|25448->15299|25481->15304|25510->15305|25544->15311|25573->15312|25605->15316|25635->15317|25747->15401|25776->15402|25807->15405|25836->15406|25866->15408|25895->15409|25965->15442|25986->15453|26062->15506|26219->15634|26249->15635|26556->15913|26586->15914|26679->15979|26708->15980|26740->15984|26769->15985|26802->15990|26831->15991
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|42->13|42->13|42->13|43->14|43->14|43->14|44->15|47->18|47->18|47->18|48->19|48->19|48->19|48->19|48->19|48->19|48->19|48->19|48->19|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|57->28|57->28|57->28|57->28|58->29|58->29|59->30|59->30|59->30|59->30|60->31|60->31|60->31|61->32|66->37|66->37|66->37|66->37|66->37|66->37|66->37|67->38|67->38|68->39|68->39|70->41|70->41|70->41|73->44|73->44|73->44|73->44|74->45|74->45|74->45|75->46|80->51|80->51|82->53|82->53|82->53|82->53|83->54|83->54|83->54|84->55|88->59|88->59|88->59|88->59|88->59|88->59|88->59|89->60|89->60|90->61|90->61|91->62|91->62|91->62|93->64|93->64|93->64|93->64|94->65|94->65|94->65|95->66|99->70|99->70|99->70|99->70|101->72|101->72|102->73|102->73|107->78|107->78|107->78|127->98|127->98|127->98|127->98|129->100|129->100|130->101|130->101|133->104|133->104|133->104|145->116|145->116|148->119|148->119|148->119|151->122|151->122|151->122|151->122|152->123|152->123|152->123|153->124|158->129|158->129|158->129|158->129|159->130|159->130|161->132|161->132|161->132|161->132|162->133|162->133|162->133|163->134|168->139|168->139|168->139|168->139|168->139|168->139|168->139|169->140|169->140|170->141|170->141|173->144|173->144|173->144|179->150|179->150|179->150|179->150|180->151|180->151|180->151|181->152|184->155|184->155|184->155|184->155|186->157|193->164|201->172|201->172|201->172|201->172|203->174|212->183|214->185|214->185|214->185|214->185|215->186|215->186|215->186|216->187|223->194|223->194|230->201|230->201|236->207|236->207|236->207|236->207|238->209|238->209|239->210|239->210|239->210|239->210|240->211|240->211|240->211|241->212|247->218|247->218|247->218|247->218|249->220|249->220|250->221|250->221|250->221|250->221|251->222|251->222|251->222|252->223|257->228|257->228|257->228|257->228|259->230|259->230|264->235|264->235|264->235|264->235|266->237|266->237|267->238|267->238|267->238|267->238|268->239|268->239|268->239|269->240|277->248|277->248|277->248|277->248|278->249|278->249|278->249|279->250|280->251|281->252|281->252|281->252|281->252|282->253|282->253|282->253|283->254|287->258|287->258|287->258|287->258|288->259|288->259|288->259|289->260|295->266|296->267|296->267|296->267|296->267|297->268|297->268|297->268|298->269|305->276|305->276|306->277|306->277|306->277|306->277|307->278|307->278|307->278|308->279|315->286|315->286|316->287|316->287|316->287|316->287|317->288|317->288|317->288|318->289|328->299|328->299|329->300|329->300|329->300|329->300|330->301|330->301|330->301|331->302|338->309|338->309|339->310|339->310|339->310|339->310|340->311|340->311|340->311|341->312|351->322|351->322|357->328|357->328|362->333|362->333|364->335|364->335|365->336|365->336|367->338|367->338|367->338|367->338|368->339|368->339|371->342|371->342|372->343|372->343|375->346|375->346|375->346|375->346|378->349|378->349|379->350|379->350|380->351|380->351|380->351|380->351|382->353|382->353|383->354|383->354|384->355|384->355|388->359|388->359|388->359|392->363|392->363|399->370|399->370|401->372|401->372|402->373|402->373|404->375|404->375
                    -- GENERATED --
                */
            