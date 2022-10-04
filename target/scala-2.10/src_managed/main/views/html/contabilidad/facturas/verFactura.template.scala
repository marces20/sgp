
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
object verFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Factura],Factura,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(factura: Form[Factura],facturaObj:Factura, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.util.HashMap; var oo = new HashMap[String,Date] ;

import java.math.BigDecimal; var vencimiento349 = new Date(); 

import java.lang.String;var nui ="";

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/contabilidad/facturas.js"))),format.raw/*6.72*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""
"""),_display_(Seq[Any](/*12.2*/paginadorFicha/*12.16*/.setActual(facturaObj.id.toString))),format.raw/*12.50*/("""

"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.contabilidad.mainContabilidad("Vista Factura",scripts)/*14.67*/ {_display_(Seq[Any](format.raw/*14.69*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-4">
			<h1>Vista de factura """),_display_(Seq[Any](/*19.26*/if(facturaObj.expediente != null)/*19.59*/{_display_(Seq[Any](_display_(Seq[Any](/*19.61*/if(facturaObj.expediente.emergencia)/*19.97*/{_display_(Seq[Any](format.raw/*19.98*/("""<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*19.188*/("""</h1>
		</div>
		<div class="col-sm-3">
			
			"""),_display_(Seq[Any](/*23.5*/{oo = Orden349.getLastOrden349(facturaObj.orden_id)})),format.raw/*23.57*/("""
			"""),_display_(Seq[Any](/*24.5*/if(oo != null)/*24.19*/{_display_(Seq[Any](format.raw/*24.20*/("""
				
				"""),_display_(Seq[Any](/*26.6*/for((key,value) <- oo) yield /*26.28*/{_display_(Seq[Any](format.raw/*26.29*/("""
				
					"""),_display_(Seq[Any](/*28.7*/{vencimiento349 = value})),format.raw/*28.31*/("""
					"""),_display_(Seq[Any](/*29.7*/{nui = key})),format.raw/*29.18*/("""
				""")))})),format.raw/*30.6*/("""
				"""),_display_(Seq[Any](/*31.6*/if(vencimiento349 != null && utils.DateUtils.compareDate(vencimiento349,new Date()) < 0)/*31.94*/{_display_(Seq[Any](format.raw/*31.95*/("""
					<span style="color:red;font-size: 15px;font-weight: bold;">Vto 349: """),_display_(Seq[Any](/*32.75*/utils/*32.80*/.DateUtils.formatDate(vencimiento349))),format.raw/*32.117*/(""" - NUI:"""),_display_(Seq[Any](/*32.125*/nui)),format.raw/*32.128*/(""" </span>
				""")))}/*33.6*/else/*33.10*/{_display_(Seq[Any](format.raw/*33.11*/("""
					"""),_display_(Seq[Any](/*34.7*/if(vencimiento349 != null && utils.DateUtils.compareDate(vencimiento349,new Date()) >= 0)/*34.96*/{_display_(Seq[Any](format.raw/*34.97*/("""
					<span style="color:green;font-size: 15px;font-weight: bold;">Vto 349: """),_display_(Seq[Any](/*35.77*/utils/*35.82*/.DateUtils.formatDate(vencimiento349))),format.raw/*35.119*/("""- NUI:"""),_display_(Seq[Any](/*35.126*/nui)),format.raw/*35.129*/("""</span>
					""")))})),format.raw/*36.7*/("""
				""")))})),format.raw/*37.6*/("""
			""")))})),format.raw/*38.5*/("""
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  </ul>
			</div>
			<div class="dropdown pull-right">
				<div class="btn-group pull-right  btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownReportes" data-toggle="dropdown">
						<i class="glyphicon glyphicon-list-alt"></i> Acciones <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						"""),_display_(Seq[Any](/*56.8*/if(Permiso.check("pagosModificarNumeroFactura"))/*56.56*/ {_display_(Seq[Any](format.raw/*56.58*/("""
						<li><a id="accionModificarNumeroFactura" data-url=""""),_display_(Seq[Any](/*57.59*/controllers/*57.70*/.contabilidad.routes.FacturasAccionesController.modalModificarNumeroFactura(facturaObj.id))),format.raw/*57.160*/("""">Modificar N° Factura</a></li>
						""")))})),format.raw/*58.8*/("""
						"""),_display_(Seq[Any](/*59.8*/if(Permiso.check("importarListaComisiones"))/*59.52*/ {_display_(Seq[Any](format.raw/*59.54*/("""
							<li><a id="importarListaComisiones" href="#" data-url=""""),_display_(Seq[Any](/*60.64*/controllers/*60.75*/.contabilidad.routes.FacturasAccionesController.modalImportarListaComisiones())),format.raw/*60.153*/("""">Importar Comisiones</a></li>
						""")))})),format.raw/*61.8*/("""
						"""),_display_(Seq[Any](/*62.8*/if(Permiso.check("cargar349"))/*62.38*/ {_display_(Seq[Any](format.raw/*62.40*/("""
							<li><a id="cargar349" href="#" data-url=""""),_display_(Seq[Any](/*63.50*/controllers/*63.61*/.contabilidad.routes.FacturasAccionesController.modalCargar349(facturaObj.id))),format.raw/*63.138*/("""">Cargar 349</a></li>
						""")))})),format.raw/*64.8*/("""
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*72.2*/views/*72.7*/.html.tags.successError())),format.raw/*72.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-5">
		<a href=""""),_display_(Seq[Any](/*76.13*/controllers/*76.24*/.contabilidad.routes.FacturasController.crear())),_display_(Seq[Any](/*76.72*/UriTrack/*76.80*/.get("?"))),format.raw/*76.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*77.13*/controllers/*77.24*/.contabilidad.routes.FacturasController.editar(factura.field("id").value.toLong))),_display_(Seq[Any](/*77.105*/UriTrack/*77.113*/.get("&"))),format.raw/*77.122*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<!-- <a href=""""),_display_(Seq[Any](/*78.18*/controllers/*78.29*/.contabilidad.routes.FacturasController.duplicar(factura.field("id").value.toLong))),_display_(Seq[Any](/*78.112*/UriTrack/*78.120*/.get("&"))),format.raw/*78.129*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a> -->
		"""),_display_(Seq[Any](/*79.4*/if(facturaObj.estado_id == models.Estado.FACTURA_ESTADO_BORRADOR && (facturaObj.parcial == null || facturaObj.parcial) )/*79.124*/{_display_(Seq[Any](format.raw/*79.125*/("""
			<a href=""""),_display_(Seq[Any](/*80.14*/controllers/*80.25*/.contabilidad.routes.FacturasController.crearFacturaParcial(factura.field("id").value.toLong))),_display_(Seq[Any](/*80.119*/UriTrack/*80.127*/.get("&"))),format.raw/*80.136*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-copyright-mark"></i> Crear Parcial</a>
		""")))})),format.raw/*81.4*/("""
		<a href=""""),_display_(Seq[Any](/*82.13*/controllers/*82.24*/.contabilidad.routes.FacturasController.eliminar(factura.field("id").value.toLong))),_display_(Seq[Any](/*82.107*/UriTrack/*82.115*/.get("&"))),format.raw/*82.124*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-4">
		"""),_display_(Seq[Any](/*85.4*/if(factura("tipoCuenta").value != null)/*85.43*/{_display_(Seq[Any](format.raw/*85.44*/("""
			<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*86.64*/factura("tipoCuenta.nombre")/*86.92*/.value)),format.raw/*86.98*/("""</span>
		""")))})),format.raw/*87.4*/("""
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*90.13*/UriTrack/*90.21*/.getOnNull(controllers.contabilidad.routes.FacturasController.index().absoluteURL()))),format.raw/*90.105*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
		"""),_display_(Seq[Any](/*92.4*/if(paginadorFicha.getLista().size() > 1)/*92.44*/{_display_(Seq[Any](format.raw/*92.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*95.5*/if(paginadorFicha.hasPrev())/*95.33*/ {_display_(Seq[Any](format.raw/*95.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*96.29*/controllers/*96.40*/.contabilidad.routes.FacturasController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*96.114*/UriTrack/*96.122*/.get("&"))),format.raw/*96.131*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*97.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*98.79*/paginadorFicha/*98.93*/.posicionActual())),format.raw/*98.110*/(""" de """),_display_(Seq[Any](/*98.115*/paginadorFicha/*98.129*/.getLista().size())),format.raw/*98.147*/("""</p>
			"""),_display_(Seq[Any](/*99.5*/if(paginadorFicha.hasNext())/*99.33*/ {_display_(Seq[Any](format.raw/*99.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*100.29*/controllers/*100.40*/.contabilidad.routes.FacturasController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*100.114*/UriTrack/*100.122*/.get("&"))),format.raw/*100.131*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*101.5*/("""  
		</div>
		""")))})),format.raw/*103.4*/("""
		
	</div>
</div>
"""),_display_(Seq[Any](/*107.2*/inputText(factura("id"), 'hidden -> "hidden",'id -> "facturaId"))),format.raw/*107.66*/("""
<input type="hidden" name="idFactura" id="idFactura" value='"""),_display_(Seq[Any](/*108.62*/factura/*108.69*/.field("id").value)),format.raw/*108.87*/("""' />
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*113.49*/factura/*113.56*/.field("nombre").value)),format.raw/*113.78*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*119.49*/factura/*119.56*/.field("referencia").value)),format.raw/*119.82*/("""</p>
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Contraparte</label>
			<p class="form-control-static form-control">
				<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*126.50*/controllers/*126.61*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(facturaObj.proveedor.id))),format.raw/*126.157*/("""">
					"""),_display_(Seq[Any](/*127.7*/factura/*127.14*/.field("proveedor.nombre").value)),format.raw/*127.46*/("""
				</a>
			</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Expediente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*135.49*/factura/*135.56*/.field("expediente.expedienteEjercicio").value)),format.raw/*135.102*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Periodo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*141.49*/factura/*141.56*/.field("periodo.nombre").value)),format.raw/*141.86*/("""</p>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">N° de factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*150.49*/factura/*150.56*/.field("numero_factura").value)),format.raw/*150.86*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*156.49*/factura/*156.56*/.field("fecha_factura").value)),format.raw/*156.85*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha recepción</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*162.49*/factura/*162.56*/.field("fecha_recepcion").value)),format.raw/*162.87*/("""</p>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha aprobación</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*169.49*/factura/*169.56*/.field("fecha_aprobacion").value)),format.raw/*169.88*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha vencimiento 322</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*175.49*/factura/*175.56*/.field("fecha_vencimiento_322").value)),format.raw/*175.93*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<!-- <div class="checkbox">
			PROFE """),_display_(Seq[Any](/*180.11*/checkbox(factura("profe"), 'disabled -> "disabled"))),format.raw/*180.62*/("""
		</div> -->
		<label class="control-label">Tipo Cuenta</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*183.48*/if(facturaObj.tipoCuenta != null)/*183.81*/{_display_(Seq[Any](_display_(Seq[Any](/*183.83*/facturaObj/*183.93*/.tipoCuenta.nombre))))})),format.raw/*183.112*/("""</p> 
	</div>
</div>

<div class="row">
	
	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*192.49*/factura/*192.56*/.field("cuenta.nombre").value)),format.raw/*192.85*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Orden de pago N°</label>
			<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*199.6*/if(facturaObj.ordenPago != null)/*199.38*/{_display_(Seq[Any](format.raw/*199.39*/(""" 
					"""),_display_(Seq[Any](/*200.7*/factura/*200.14*/.field("ordenPago.nombreCompleto").value)),format.raw/*200.54*/("""
				""")))})),format.raw/*201.6*/("""
			</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha orden de pago</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*208.49*/factura/*208.56*/.field("fecha_orden_pago").value)),format.raw/*208.88*/("""</p>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Cot. dólar</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*215.49*/utils/*215.54*/.NumberUtils.moneda(facturaObj.cot_dolar, 2))),format.raw/*215.98*/("""</p>
		</div>
	</div>
	
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="checkbox">
			Debe libre deuda DGR """),_display_(Seq[Any](/*223.26*/checkbox(factura("debe_dgr"), 'disabled -> "disabled"))),format.raw/*223.80*/("""
		</div> 
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			Debe libre deuda DGR Aguinaldo """),_display_(Seq[Any](/*228.36*/checkbox(factura("debe_dgr_aguinaldo"), 'disabled -> "disabled"))),format.raw/*228.100*/("""
		</div> 
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			Debe constancia AFIP """),_display_(Seq[Any](/*233.26*/checkbox(factura("debe_afip"), 'disabled -> "disabled"))),format.raw/*233.81*/("""
		</div> 
	</div>
	<div class="col-sm-2">
		<div class="checkbox">
			Debe Judicial """),_display_(Seq[Any](/*238.19*/checkbox(factura("debe_judicial"), 'disabled -> "disabled"))),format.raw/*238.78*/("""
		</div> 
	</div>
	
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="checkbox">
			<label class="control-label">Creacion Automatica
			"""),_display_(Seq[Any](/*247.5*/checkbox(factura("creacion_automatica"), 'disabled -> "disabled"))),format.raw/*247.70*/("""</label> 
		</div>
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			<label class="control-label">Agente Pago Externo
			"""),_display_(Seq[Any](/*253.5*/checkbox(factura("agente_pago_externo"), 'disabled -> "disabled"))),format.raw/*253.70*/("""</label> 
		</div>
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			<label class="control-label">Produccion
			"""),_display_(Seq[Any](/*259.5*/checkbox(factura("produccion"), 'disabled -> "disabled"))),format.raw/*259.61*/("""</label> 
		</div>
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			Debito Automatico """),_display_(Seq[Any](/*264.23*/checkbox(factura("debito_automatico"), 'disabled -> "disabled"))),format.raw/*264.86*/("""
		</div> 
	</div>
</div>
"""),_display_(Seq[Any](/*268.2*/views/*268.7*/.html.contabilidad.facturas.tabsFactura(false,false,factura,facturaObj, true))),format.raw/*268.84*/("""


<div class="row margin-bottom-25">
	"""),_display_(Seq[Any](/*272.3*/if(facturaObj.facturaParciales != null && facturaObj.facturaParciales.size() > 0)/*272.84*/{_display_(Seq[Any](format.raw/*272.85*/("""
		<div class="col-sm-3"><h4><b>FACTURA PARCIALIZADA</b></h4></div>
	""")))}/*274.3*/else/*274.7*/{_display_(Seq[Any](format.raw/*274.8*/("""	
		"""),_display_(Seq[Any](/*275.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(facturaObj.estado.orden,models.Estado.TIPO_FACTURA)) yield /*275.113*/ {_display_(Seq[Any](format.raw/*275.115*/("""	
			"""),_display_(Seq[Any](/*276.5*/if(estado.orden <= 5)/*276.26*/ {_display_(Seq[Any](format.raw/*276.28*/("""
				"""),_display_(Seq[Any](/*277.6*/if(facturaObj.debito_automatico != null && facturaObj.debito_automatico)/*277.78*/ {_display_(Seq[Any](format.raw/*277.80*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*279.17*/controllers/*279.28*/.contabilidad.routes.FacturasController.cambiarEstadoAprobado(factura.field("id").value.toInt))),_display_(Seq[Any](/*279.123*/UriTrack/*279.131*/.get("&"))),format.raw/*279.140*/("""" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*280.57*/models/*280.63*/.Estado.getEstado(models.Estado.FACTURA_ESTADO_APROBADO,Estado.TIPO_FACTURA).nombre)),format.raw/*280.146*/("""
						</a>
					</div>
				""")))}/*283.6*/else/*283.10*/{_display_(Seq[Any](format.raw/*283.11*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*285.17*/controllers/*285.28*/.contabilidad.routes.FacturasController.cambiarEstado(factura.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*285.133*/UriTrack/*285.141*/.get("&"))),format.raw/*285.150*/("""" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*286.57*/estado/*286.63*/.nombre)),format.raw/*286.70*/("""
						</a>
					</div>
					"""),_display_(Seq[Any](/*289.7*/if(facturaObj.estado.id ==  models.Estado.FACTURA_ESTADO_BORRADOR)/*289.73*/{_display_(Seq[Any](format.raw/*289.74*/("""
						<div class="col-sm-3">
							<a href=""""),_display_(Seq[Any](/*291.18*/controllers/*291.29*/.contabilidad.routes.FacturasController.cambiarEstadoPrecargado(factura.field("id").value.toInt, estado.id.toLong,true))),_display_(Seq[Any](/*291.149*/UriTrack/*291.157*/.get("&"))),format.raw/*291.166*/("""" class="btn btn-default btn-disable-onclick">
								<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*292.58*/estado/*292.64*/.nombre)),format.raw/*292.71*/(""" Precargado
							</a>
						</div>
					""")))})),format.raw/*295.7*/("""
					
				""")))})),format.raw/*297.6*/("""
				"""),_display_(Seq[Any](/*298.6*/if(facturaObj.estado.id ==  models.Estado.FACTURA_ESTADO_PREAPROBADO)/*298.75*/{_display_(Seq[Any](format.raw/*298.76*/("""
					<div class="col-sm-3">
						<a data-url=""""),_display_(Seq[Any](/*300.21*/controllers/*300.32*/.contabilidad.routes.FacturasAccionesController.modalRechazarFactura())),format.raw/*300.102*/("""" href="#" id="rechazarFactura" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-left glyphicon-arrow-left-green"></i> Rechazar
						</a>
					</div>
				""")))})),format.raw/*304.6*/("""
			""")))})),format.raw/*305.5*/("""
		""")))})),format.raw/*306.4*/("""
		"""),_display_(Seq[Any](/*307.4*/if(facturaObj.estado.id == models.Estado.FACTURA_ESTADO_CANCELADO)/*307.70*/ {_display_(Seq[Any](format.raw/*307.72*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*309.15*/controllers/*309.26*/.contabilidad.routes.FacturasController.cambiarEstado(factura.field("id").value.toInt, models.Estado.FACTURA_ESTADO_BORRADOR))),_display_(Seq[Any](/*309.152*/UriTrack/*309.160*/.get("&"))),format.raw/*309.169*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*313.4*/else/*313.8*/{_display_(Seq[Any](format.raw/*313.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*315.15*/controllers/*315.26*/.contabilidad.routes.FacturasController.cambiarEstado(factura.field("id").value.toInt, models.Estado.FACTURA_ESTADO_CANCELADO))),_display_(Seq[Any](/*315.153*/UriTrack/*315.161*/.get("&"))),format.raw/*315.170*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Factura
				</a>
			</div>
		""")))})),format.raw/*319.4*/("""
	""")))})),format.raw/*320.3*/("""
</div>





""")))})))}
    }
    
    def render(factura:Form[Factura],facturaObj:Factura,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(factura,facturaObj,paginadorFicha)
    
    def f:((Form[Factura],Factura,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (factura,facturaObj,paginadorFicha) => apply(factura,facturaObj,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/verFactura.scala.html
                    HASH: 0ad123333be5f145ac20e394eca3719766314de7
                    MATRIX: 848->1|1242->203|1256->210|1340->214|1392->231|1406->237|1477->287|1545->131|1577->155|1651->93|1680->199|1709->324|1747->518|1770->532|1826->566|1866->571|1879->576|1948->636|1988->638|2126->740|2168->773|2216->775|2261->811|2300->812|2427->902|2514->954|2588->1006|2629->1012|2652->1026|2691->1027|2739->1040|2777->1062|2816->1063|2865->1077|2911->1101|2954->1109|2987->1120|3025->1127|3067->1134|3164->1222|3203->1223|3315->1299|3329->1304|3389->1341|3434->1349|3460->1352|3493->1367|3506->1371|3545->1372|3588->1380|3686->1469|3725->1470|3839->1548|3853->1553|3913->1590|3957->1597|3983->1600|4029->1615|4067->1622|4104->1628|4894->2383|4951->2431|4991->2433|5087->2493|5107->2504|5220->2594|5291->2634|5335->2643|5388->2687|5428->2689|5529->2754|5549->2765|5650->2843|5720->2882|5764->2891|5803->2921|5843->2923|5930->2974|5950->2985|6050->3062|6111->3092|6213->3159|6226->3164|6273->3189|6383->3263|6403->3274|6481->3322|6498->3330|6529->3339|6661->3435|6681->3446|6793->3527|6811->3535|6843->3544|6976->3641|6996->3652|7110->3735|7128->3743|7160->3752|7289->3846|7419->3966|7459->3967|7510->3982|7530->3993|7655->4087|7673->4095|7705->4104|7836->4204|7886->4218|7906->4229|8020->4312|8038->4320|8070->4329|8260->4484|8308->4523|8347->4524|8448->4589|8485->4617|8513->4623|8556->4635|8640->4683|8657->4691|8764->4775|8878->4854|8927->4894|8966->4895|9036->4930|9073->4958|9113->4960|9179->4990|9199->5001|9304->5075|9322->5083|9354->5092|9469->5176|9585->5256|9608->5270|9648->5287|9690->5292|9714->5306|9755->5324|9800->5334|9837->5362|9877->5364|9944->5394|9965->5405|10071->5479|10090->5487|10123->5496|10240->5581|10289->5598|10349->5622|10436->5686|10536->5749|10553->5756|10594->5774|10805->5948|10822->5955|10867->5977|11082->6155|11099->6162|11148->6188|11414->6417|11435->6428|11555->6524|11601->6534|11618->6541|11673->6573|11903->6766|11920->6773|11990->6819|12202->6994|12219->7001|12272->7031|12519->7241|12536->7248|12589->7278|12807->7459|12824->7466|12876->7495|13096->7678|13113->7685|13167->7716|13391->7903|13408->7910|13463->7942|13689->8131|13706->8138|13766->8175|13894->8266|13968->8317|14120->8432|14163->8465|14212->8467|14232->8477|14279->8496|14513->8693|14530->8700|14582->8729|14808->8919|14850->8951|14890->8952|14935->8961|14952->8968|15015->9008|15054->9015|15283->9207|15300->9214|15355->9246|15573->9427|15588->9432|15655->9476|15823->9607|15900->9661|16045->9769|16133->9833|16268->9931|16346->9986|16474->10077|16556->10136|16752->10296|16840->10361|17014->10499|17102->10564|17267->10693|17346->10749|17486->10852|17572->10915|17639->10946|17653->10951|17753->11028|17833->11072|17924->11153|17964->11154|18055->11226|18068->11230|18107->11231|18149->11237|18276->11346|18318->11348|18361->11355|18392->11376|18433->11378|18476->11385|18558->11457|18599->11459|18683->11506|18704->11517|18831->11612|18850->11620|18883->11629|19024->11733|19040->11739|19147->11822|19198->11854|19212->11858|19252->11859|19336->11906|19357->11917|19494->12022|19513->12030|19546->12039|19687->12143|19703->12149|19733->12156|19802->12189|19878->12255|19918->12256|20004->12305|20025->12316|20177->12436|20196->12444|20229->12453|20371->12558|20387->12564|20417->12571|20495->12617|20541->12631|20584->12638|20663->12707|20703->12708|20791->12759|20812->12770|20906->12840|21137->13039|21175->13045|21212->13050|21253->13055|21329->13121|21370->13123|21450->13166|21471->13177|21629->13303|21648->13311|21681->13320|21844->13464|21857->13468|21896->13469|21976->13512|21997->13523|22156->13650|22175->13658|22208->13667|22382->13809|22418->13813
                    LINES: 26->1|39->5|39->5|41->5|42->6|42->6|42->6|43->4|43->4|44->1|45->4|46->7|47->12|47->12|47->12|49->14|49->14|49->14|49->14|54->19|54->19|54->19|54->19|54->19|54->19|58->23|58->23|59->24|59->24|59->24|61->26|61->26|61->26|63->28|63->28|64->29|64->29|65->30|66->31|66->31|66->31|67->32|67->32|67->32|67->32|67->32|68->33|68->33|68->33|69->34|69->34|69->34|70->35|70->35|70->35|70->35|70->35|71->36|72->37|73->38|91->56|91->56|91->56|92->57|92->57|92->57|93->58|94->59|94->59|94->59|95->60|95->60|95->60|96->61|97->62|97->62|97->62|98->63|98->63|98->63|99->64|107->72|107->72|107->72|111->76|111->76|111->76|111->76|111->76|112->77|112->77|112->77|112->77|112->77|113->78|113->78|113->78|113->78|113->78|114->79|114->79|114->79|115->80|115->80|115->80|115->80|115->80|116->81|117->82|117->82|117->82|117->82|117->82|120->85|120->85|120->85|121->86|121->86|121->86|122->87|125->90|125->90|125->90|127->92|127->92|127->92|130->95|130->95|130->95|131->96|131->96|131->96|131->96|131->96|132->97|133->98|133->98|133->98|133->98|133->98|133->98|134->99|134->99|134->99|135->100|135->100|135->100|135->100|135->100|136->101|138->103|142->107|142->107|143->108|143->108|143->108|148->113|148->113|148->113|154->119|154->119|154->119|161->126|161->126|161->126|162->127|162->127|162->127|170->135|170->135|170->135|176->141|176->141|176->141|185->150|185->150|185->150|191->156|191->156|191->156|197->162|197->162|197->162|204->169|204->169|204->169|210->175|210->175|210->175|215->180|215->180|218->183|218->183|218->183|218->183|218->183|227->192|227->192|227->192|234->199|234->199|234->199|235->200|235->200|235->200|236->201|243->208|243->208|243->208|250->215|250->215|250->215|258->223|258->223|263->228|263->228|268->233|268->233|273->238|273->238|282->247|282->247|288->253|288->253|294->259|294->259|299->264|299->264|303->268|303->268|303->268|307->272|307->272|307->272|309->274|309->274|309->274|310->275|310->275|310->275|311->276|311->276|311->276|312->277|312->277|312->277|314->279|314->279|314->279|314->279|314->279|315->280|315->280|315->280|318->283|318->283|318->283|320->285|320->285|320->285|320->285|320->285|321->286|321->286|321->286|324->289|324->289|324->289|326->291|326->291|326->291|326->291|326->291|327->292|327->292|327->292|330->295|332->297|333->298|333->298|333->298|335->300|335->300|335->300|339->304|340->305|341->306|342->307|342->307|342->307|344->309|344->309|344->309|344->309|344->309|348->313|348->313|348->313|350->315|350->315|350->315|350->315|350->315|354->319|355->320
                    -- GENERATED --
                */
            