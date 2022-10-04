
package views.html.patrimonio.actaRecepcion

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
object verActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[ActaRecepcion,utils.pagination.PaginadorFicha,Date,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(acta: ActaRecepcion, paginadorFicha: utils.pagination.PaginadorFicha,fechaDispo:Date):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*9.2*/scripts/*9.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*9.13*/("""
	<script src=""""),_display_(Seq[Any](/*10.16*/routes/*10.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*10.76*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.88*/("""
"""),format.raw/*5.70*/(""" 

"""),_display_(Seq[Any](/*7.2*/paginadorFicha/*7.16*/.setActual(acta.id.toString))),format.raw/*7.44*/("""

"""),format.raw/*11.2*/("""

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.patrimonio.mainPatrimonio("Vista de acta", scripts)/*13.64*/ {_display_(Seq[Any](format.raw/*13.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-4">
				<h1>Vista de acta """),_display_(Seq[Any](/*17.24*/if(acta.ordenProvision.ordenCompra.expediente  != null)/*17.79*/{_display_(Seq[Any](format.raw/*17.80*/("""
									"""),_display_(Seq[Any](/*18.11*/if(acta.ordenProvision.ordenCompra.expediente.emergencia)/*18.68*/{_display_(Seq[Any](format.raw/*18.69*/("""
										<span style="color:red;font-weight: bold;font-size:14px; ">(Emergencia Sanitaria)</span>""")))}))))})),format.raw/*19.101*/("""</h1>
			</div>
			<div class="col-sm-3">
				"""),_display_(Seq[Any](/*22.6*/if(fechaDispo != null)/*22.28*/{_display_(Seq[Any](format.raw/*22.29*/("""
				<h1><span style="color:red;font-weight: bold;font-size:14px; ">Fecha Dispo: """),_display_(Seq[Any](/*23.82*/(DateUtils.formatDate(fechaDispo)))),format.raw/*23.116*/("""</span></h1>
				""")))})),format.raw/*24.6*/("""
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						"""),_display_(Seq[Any](/*32.8*/if(Permiso.check("actaRecepcionReporte"))/*32.49*/ {_display_(Seq[Any](format.raw/*32.51*/("""
						<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*33.71*/controllers/*33.82*/.patrimonio.routes.ActasRecepcionReportesController.reporte(acta.id))),format.raw/*33.150*/("""">Reporte acta de recepción</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*34.71*/controllers/*34.82*/.patrimonio.routes.ActasRecepcionReportesController.reporteActaCierre(acta.id))),format.raw/*34.160*/("""">Reporte acta de cierre</a></li>
						""")))})),format.raw/*35.8*/("""
					</ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  	
				  	"""),_display_(Seq[Any](/*48.9*/if(Permiso.check("expedientesPasarAOtroServicio"))/*48.59*/ {_display_(Seq[Any](format.raw/*48.61*/("""
					  	<li role="presentation">
					  		<a role="menuitem" id="accionPasarOtroServicio" tabindex="-1" href="#" 
					    						   data-url=""""),_display_(Seq[Any](/*51.30*/controllers/*51.41*/.patrimonio.routes.ActasMovimientosController.modalPasarOtroServicioIndividual(acta.id))),format.raw/*51.128*/("""">
					    						   Pasar a otro servicio</a>
					    						   
					 	</li>
					 	
					 	<li role="presentation">
					  		<a role="menuitem" id="accionCerrarCircuitoPase" tabindex="-1" href="#" 
					    						   data-url=""""),_display_(Seq[Any](/*58.30*/controllers/*58.41*/.patrimonio.routes.ActasMovimientosController.modalCierreCircuitoIndividual(acta.id))),format.raw/*58.125*/("""">
					    						   Cerrar Circuito Pases</a>
					    						   
					 	</li>
				 	""")))})),format.raw/*62.8*/("""
				 	
				 	"""),_display_(Seq[Any](/*64.8*/if(Permiso.check("expedientesCancelarPase"))/*64.52*/ {_display_(Seq[Any](format.raw/*64.54*/("""
				    	<li><a id="cancelarPase" href="#" data-url=""""),_display_(Seq[Any](/*65.55*/controllers/*65.66*/.patrimonio.routes.ActasMovimientosController.cancelarPase(acta.id))),format.raw/*65.133*/("""">Cancelar Pase</a></li>
				  	""")))})),format.raw/*66.9*/("""
				  	"""),_display_(Seq[Any](/*67.9*/if(Permiso.check("expedientesAsignarMiServicio"))/*67.58*/ {_display_(Seq[Any](format.raw/*67.60*/("""
					  	<li role="presentation">
					  		<a role="menuitem" id="asignarMiServicio" tabindex="-1" href="#" 
					    						   data-url=""""),_display_(Seq[Any](/*70.30*/controllers/*70.41*/.patrimonio.routes.ActasMovimientosController.asignarMiServicio(acta.id))),format.raw/*70.113*/("""">
					    						   Asignar a Mi Servicio</a>
					 	</li>
				 	""")))})),format.raw/*73.8*/("""
				  </ul>
				</div>
				
			</div>
		</div>	
	</div>
	
	"""),_display_(Seq[Any](/*81.3*/views/*81.8*/.html.tags.successError())),format.raw/*81.33*/("""

	<div class="row menu-acciones">
		<div class="col-sm-4">
		"""),_display_(Seq[Any](/*85.4*/if(Permiso.check("actaRecepcionCrear"))/*85.43*/ {_display_(Seq[Any](format.raw/*85.45*/("""
			<a href=""""),_display_(Seq[Any](/*86.14*/controllers/*86.25*/.patrimonio.routes.ActasRecepcionController.editar(acta.id))),_display_(Seq[Any](/*86.85*/UriTrack/*86.93*/.get("&"))),format.raw/*86.102*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		""")))})),format.raw/*87.4*/("""
		"""),_display_(Seq[Any](/*88.4*/if(Permiso.check("actaRecepcionEliminar"))/*88.46*/ {_display_(Seq[Any](format.raw/*88.48*/("""
			<a href=""""),_display_(Seq[Any](/*89.14*/controllers/*89.25*/.patrimonio.routes.ActasRecepcionController.eliminar(acta.id))),_display_(Seq[Any](/*89.87*/UriTrack/*89.95*/.get("&"))),format.raw/*89.104*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*90.4*/("""
		</div>
		<div class="col-sm-5">
			"""),_display_(Seq[Any](/*93.5*/if(acta.ordenProvision != null)/*93.36*/{_display_(Seq[Any](format.raw/*93.37*/("""
				"""),_display_(Seq[Any](/*94.6*/if(acta.ordenProvision.ordenCompra.tipo_moneda != null)/*94.61*/{_display_(Seq[Any](format.raw/*94.62*/("""
					<span style="color:green;font-weight:bold;font-size: 18px;">MONEDA EXTRANJERA</span> -
				""")))})),format.raw/*96.6*/("""
			""")))})),format.raw/*97.5*/("""
			"""),_display_(Seq[Any](/*98.5*/if(acta.servicio != null)/*98.30*/ {_display_(Seq[Any](format.raw/*98.32*/(""" 
				<span style="color:red;font-weight:bold;font-size: 18px;">Depto/Servicio - """),_display_(Seq[Any](/*99.81*/acta/*99.85*/.servicio)),format.raw/*99.94*/("""</span>
			""")))})),format.raw/*100.5*/("""
		</div>
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*103.14*/UriTrack/*103.22*/.getOnNull(controllers.patrimonio.routes.ActasRecepcionController.index().absoluteURL()))),format.raw/*103.110*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			 """),_display_(Seq[Any](/*104.6*/if(paginadorFicha.getLista().size() > 1)/*104.46*/{_display_(Seq[Any](format.raw/*104.47*/("""
				<div class="btn-group">
					"""),_display_(Seq[Any](/*106.7*/if(paginadorFicha.hasPrev())/*106.35*/ {_display_(Seq[Any](format.raw/*106.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*107.31*/controllers/*107.42*/.patrimonio.routes.ActasRecepcionController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*107.120*/UriTrack/*107.128*/.get("&"))),format.raw/*107.137*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
					""")))})),format.raw/*108.7*/("""
					<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*109.81*/paginadorFicha/*109.95*/.posicionActual())),format.raw/*109.112*/(""" de """),_display_(Seq[Any](/*109.117*/paginadorFicha/*109.131*/.getLista().size())),format.raw/*109.149*/("""</p>
					"""),_display_(Seq[Any](/*110.7*/if(paginadorFicha.hasNext())/*110.35*/ {_display_(Seq[Any](format.raw/*110.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*111.31*/controllers/*111.42*/.patrimonio.routes.ActasRecepcionController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*111.120*/UriTrack/*111.128*/.get("&"))),format.raw/*111.137*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
					""")))})),format.raw/*112.7*/("""  
				</div>
			""")))})),format.raw/*114.5*/("""
		</div>
	</div>



	<div class="row">
		<input type="hidden" id="idActa" name="idActa" value=""""),_display_(Seq[Any](/*121.58*/acta/*121.62*/.id)),format.raw/*121.65*/(""""/>
		<div class="col-sm-2">
			<label class="control-label">Número</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*124.49*/acta/*124.53*/.numero)),format.raw/*124.60*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Orden de provisión</label> 
			<p class="form-control-static form-control">
			"""),_display_(Seq[Any](/*130.5*/if(acta.ordenProvision != null)/*130.36*/ {_display_(Seq[Any](format.raw/*130.38*/("""
				"""),_display_(Seq[Any](/*131.6*/acta/*131.10*/.ordenProvision.numero)),format.raw/*131.32*/(""" 
			""")))}/*132.5*/else/*132.9*/{_display_(Seq[Any](format.raw/*132.10*/("""
				"""),_display_(Seq[Any](/*133.6*/if(acta.recepciones.size() > 0)/*133.37*/ {_display_(Seq[Any](format.raw/*133.39*/(""" """),_display_(Seq[Any](/*133.41*/acta/*133.45*/.recepciones.get(0).ordenProvision.numero)),format.raw/*133.86*/(""" """)))})),format.raw/*133.88*/(""" 
				"""),_display_(Seq[Any](/*134.6*/if(acta.certificaciones.size() > 0)/*134.41*/ {_display_(Seq[Any](format.raw/*134.43*/(""" """),_display_(Seq[Any](/*134.45*/acta/*134.49*/.certificaciones.get(0).ordenProvision.numero)),format.raw/*134.94*/(""" """)))})),format.raw/*134.96*/("""
			""")))})),format.raw/*135.5*/("""
			</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Orden de compra</label> 
			<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*142.6*/if(acta.ordenProvision.ordenCompra != null)/*142.49*/ {_display_(Seq[Any](format.raw/*142.51*/("""
					"""),_display_(Seq[Any](/*143.7*/acta/*143.11*/.ordenProvision.ordenCompra.nombre)),format.raw/*143.45*/("""
				""")))}/*144.6*/else/*144.10*/{_display_(Seq[Any](format.raw/*144.11*/("""
					"""),_display_(Seq[Any](/*145.7*/if(acta.recepciones.size() > 0)/*145.38*/ {_display_(Seq[Any](format.raw/*145.40*/(""" """),_display_(Seq[Any](/*145.42*/acta/*145.46*/.recepciones.get(0).ordenProvision.ordenCompra.nombre)),format.raw/*145.99*/(""" """)))})),format.raw/*145.101*/(""" 
					"""),_display_(Seq[Any](/*146.7*/if(acta.certificaciones.size() > 0)/*146.42*/ {_display_(Seq[Any](format.raw/*146.44*/(""" """),_display_(Seq[Any](/*146.46*/acta/*146.50*/.certificaciones.get(0).ordenProvision.ordenCompra.nombre)),format.raw/*146.107*/(""" """)))})),format.raw/*146.109*/("""
				""")))})),format.raw/*147.6*/("""
			</p>
			
		</div>
		
		<div class="col-sm-3">
			<div class="col-sm-6">
				<label class="control-label">Ejercicio</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*155.50*/if(acta.ejercicio != null)/*155.76*/ {_display_(Seq[Any](_display_(Seq[Any](/*155.79*/acta/*155.83*/.ejercicio.nombre))))})),format.raw/*155.101*/("""</p>
			</div>
			
			<div class="col-sm-6">
				<label class="control-label">Fecha</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*160.50*/(DateUtils.formatDate(acta.fecha)))),format.raw/*160.84*/("""</p>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="col-sm-6">
				<label class="control-label">Tipo</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*167.50*/if(acta.cierre)/*167.65*/ {_display_(Seq[Any](format.raw/*167.67*/(""" Cierre """)))}/*167.77*/else/*167.82*/{_display_(Seq[Any](format.raw/*167.83*/(""" Parcial """)))})),format.raw/*167.93*/("""</p>
			</div>	
			<div class="col-sm-6">
				<div class="">
					<label for="" class="control-label">Cotización</label>	
					<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*173.7*/if(acta.ordenProvision.ordenCompra.tipo_moneda != null)/*173.62*/ {_display_(Seq[Any](format.raw/*173.64*/("""
						"""),_display_(Seq[Any](/*174.8*/UltimaCotizacion/*174.24*/.getMoneda(acta.ordenProvision.ordenCompra.tipo_moneda))),format.raw/*174.79*/(""" 
						"""),_display_(Seq[Any](/*175.8*/utils/*175.13*/.NumberUtils.moneda(acta.cot_dolar, 2))),format.raw/*175.51*/("""
					""")))})),format.raw/*176.7*/("""
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Total</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*186.49*/utils/*186.54*/.NumberUtils.moneda(acta.getSubTotal()))),format.raw/*186.93*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Ajustes</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*191.49*/utils/*191.54*/.NumberUtils.moneda(acta.getTotalAjustesConLineasAjustes()))),format.raw/*191.113*/("""</p>
		</div>
		
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*197.6*/if(acta.ordenProvision != null)/*197.37*/ {_display_(Seq[Any](_display_(Seq[Any](/*197.40*/acta/*197.44*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*197.88*/(""" """)))})),format.raw/*197.90*/("""
			</p>
		</div>
		
		<div class="col-sm-4">
			<label class="control-label">Responsable</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*203.49*/acta/*203.53*/.create_usuario.nombre)),format.raw/*203.75*/("""</p>
		</div>
		
	</div>

	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Periodo</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*211.49*/if(acta.periodo != null)/*211.73*/ {_display_(Seq[Any](_display_(Seq[Any](/*211.76*/acta/*211.80*/.periodo.nombre))))})),format.raw/*211.96*/("""</p>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-10">
			<label class="control-label">Observaciones</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*218.49*/acta/*218.53*/.observaciones)),format.raw/*218.67*/("""</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-10">
			<label class="control-label">Nota Interna</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*224.49*/acta/*224.53*/.nota_interna)),format.raw/*224.66*/("""</p>
		</div>
	</div>
	
	

<hr />
	
	"""),_display_(Seq[Any](/*232.3*/views/*232.8*/.html.patrimonio.actaRecepcion.tabsActaRecepcion(false, acta))),format.raw/*232.69*/("""
	
	
	



	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*239.26*/acta/*239.30*/.estado.nombre)),format.raw/*239.44*/("""</b></h4>

	<div class="row margin-bottom-25">	
	
		"""),_display_(Seq[Any](/*243.4*/if(acta.ordenProvision != null && acta.ordenProvision.ordenCompra.tipo_moneda != null && acta.estado.id == models.Estado.ACTA_ESTADO_ENCURSO && acta.estado.id != models.Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES)/*243.212*/{_display_(Seq[Any](format.raw/*243.213*/("""
			
				
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*247.16*/controllers/*247.27*/.patrimonio.routes.ActasRecepcionController.cambiarEstado(acta.id, models.Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES))),_display_(Seq[Any](/*247.141*/UriTrack/*247.149*/.get("&"))),format.raw/*247.158*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon glyphicon-usd" style="color:green;"></i> Precalcular Ajustes
					</a>
				</div>
			
		""")))}/*252.4*/else/*252.8*/{_display_(Seq[Any](format.raw/*252.9*/("""		
			"""),_display_(Seq[Any](/*253.5*/if(acta.estado.id == models.Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES)/*253.72*/{_display_(Seq[Any](format.raw/*253.73*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*255.16*/controllers/*255.27*/.patrimonio.routes.ActasRecepcionController.cambiarEstado(acta.id, Estado.getEstado(Estado.ACTA_ESTADO_APROBADA,Estado.TIPO_ACTA).id.toLong))),_display_(Seq[Any](/*255.168*/UriTrack/*255.176*/.get("&"))),format.raw/*255.185*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*256.56*/Estado/*256.62*/.getEstado(Estado.ACTA_ESTADO_APROBADA,Estado.TIPO_ACTA).nombre)),format.raw/*256.125*/("""
					</a>
				</div>	
			""")))}/*259.5*/else/*259.9*/{_display_(Seq[Any](format.raw/*259.10*/("""
				"""),_display_(Seq[Any](/*260.6*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(acta.estado.orden,models.Estado.TIPO_ACTA)) yield /*260.106*/ {_display_(Seq[Any](format.raw/*260.108*/("""	
					"""),_display_(Seq[Any](/*261.7*/if(estado.orden <= 4)/*261.28*/ {_display_(Seq[Any](format.raw/*261.30*/("""
						<div class="col-sm-3">
							<a href=""""),_display_(Seq[Any](/*263.18*/controllers/*263.29*/.patrimonio.routes.ActasRecepcionController.cambiarEstado(acta.id, estado.id.toLong))),_display_(Seq[Any](/*263.114*/UriTrack/*263.122*/.get("&"))),format.raw/*263.131*/("""" class="btn btn-default btn-disable-onclick">
								<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*264.58*/estado/*264.64*/.nombre)),format.raw/*264.71*/("""
							</a>
						</div>	
					""")))})),format.raw/*267.7*/("""
				""")))})),format.raw/*268.6*/("""
			""")))})),format.raw/*269.5*/("""
		""")))})),format.raw/*270.4*/("""
		"""),_display_(Seq[Any](/*271.4*/if(acta.estado.id == models.Estado.ACTA_ESTADO_CANCELADA)/*271.61*/ {_display_(Seq[Any](format.raw/*271.63*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*273.15*/controllers/*273.26*/.patrimonio.routes.ActasRecepcionController.cambiarEstado(acta.id, models.Estado.ACTA_ESTADO_BORRADOR))),_display_(Seq[Any](/*273.129*/UriTrack/*273.137*/.get("&"))),format.raw/*273.146*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*277.4*/else/*277.8*/{_display_(Seq[Any](format.raw/*277.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*279.15*/controllers/*279.26*/.patrimonio.routes.ActasRecepcionController.cambiarEstado(acta.id, models.Estado.ACTA_ESTADO_CANCELADA))),_display_(Seq[Any](/*279.130*/UriTrack/*279.138*/.get("&"))),format.raw/*279.147*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Acta
				</a>
			</div>
		""")))})),format.raw/*283.4*/("""
	</div>



	
	
""")))})),format.raw/*290.2*/("""


"""))}
    }
    
    def render(acta:ActaRecepcion,paginadorFicha:utils.pagination.PaginadorFicha,fechaDispo:Date): play.api.templates.HtmlFormat.Appendable = apply(acta,paginadorFicha,fechaDispo)
    
    def f:((ActaRecepcion,utils.pagination.PaginadorFicha,Date) => play.api.templates.HtmlFormat.Appendable) = (acta,paginadorFicha,fechaDispo) => apply(acta,paginadorFicha,fechaDispo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/verActaRecepcion.scala.html
                    HASH: 4154556a85bada335583c74c7d09e1080162e3af
                    MATRIX: 854->1|1074->269|1088->276|1172->280|1225->297|1240->303|1316->357|1384->148|1416->172|1490->87|1519->216|1559->222|1581->236|1630->264|1661->394|1701->399|1714->404|1780->461|1820->463|1957->564|2021->619|2060->620|2108->632|2174->689|2213->690|2352->792|2437->842|2468->864|2507->865|2626->948|2683->982|2733->1001|3147->1380|3197->1421|3237->1423|3345->1495|3365->1506|3456->1574|3600->1682|3620->1693|3721->1771|3794->1813|4250->2234|4309->2284|4349->2286|4532->2433|4552->2444|4662->2531|4935->2768|4955->2779|5062->2863|5183->2953|5235->2970|5288->3014|5328->3016|5420->3072|5440->3083|5530->3150|5595->3184|5640->3194|5698->3243|5738->3245|5915->3386|5935->3397|6030->3469|6131->3539|6235->3608|6248->3613|6295->3638|6397->3705|6445->3744|6485->3746|6536->3761|6556->3772|6646->3832|6663->3840|6695->3849|6809->3932|6849->3937|6900->3979|6940->3981|6991->3996|7011->4007|7103->4069|7120->4077|7152->4086|7304->4207|7381->4249|7421->4280|7460->4281|7502->4288|7566->4343|7605->4344|7736->4444|7773->4450|7814->4456|7848->4481|7888->4483|8007->4566|8020->4570|8051->4579|8096->4592|8184->4643|8202->4651|8314->4739|8427->4816|8477->4856|8517->4857|8590->4894|8628->4922|8669->4924|8738->4956|8759->4967|8869->5045|8888->5053|8921->5062|9039->5148|9158->5230|9182->5244|9223->5261|9266->5266|9291->5280|9333->5298|9381->5310|9419->5338|9460->5340|9529->5372|9550->5383|9660->5461|9679->5469|9712->5478|9831->5565|9883->5585|10024->5689|10038->5693|10064->5696|10228->5823|10242->5827|10272->5834|10468->5994|10509->6025|10550->6027|10593->6034|10607->6038|10652->6060|10678->6067|10691->6071|10731->6072|10774->6079|10815->6110|10856->6112|10895->6114|10909->6118|10973->6159|11008->6161|11052->6169|11097->6204|11138->6206|11177->6208|11191->6212|11259->6257|11294->6259|11332->6265|11531->6428|11584->6471|11625->6473|11669->6481|11683->6485|11740->6519|11766->6526|11780->6530|11820->6531|11864->6539|11905->6570|11946->6572|11985->6574|11999->6578|12075->6631|12111->6633|12156->6642|12201->6677|12242->6679|12281->6681|12295->6685|12376->6742|12412->6744|12451->6751|12673->6936|12709->6962|12759->6965|12773->6969|12819->6987|13003->7134|13060->7168|13278->7349|13303->7364|13344->7366|13373->7376|13387->7381|13427->7382|13470->7392|13690->7576|13755->7631|13796->7633|13841->7642|13867->7658|13945->7713|13991->7723|14006->7728|14067->7766|14107->7774|14344->7974|14359->7979|14421->8018|14602->8162|14617->8167|14700->8226|14888->8378|14929->8409|14979->8412|14993->8416|15060->8460|15095->8462|15285->8615|15299->8619|15344->8641|15556->8816|15590->8840|15640->8843|15654->8847|15697->8863|15913->9042|15927->9046|15964->9060|16176->9235|16190->9239|16226->9252|16308->9298|16322->9303|16406->9364|16485->9406|16499->9410|16536->9424|16629->9481|16848->9689|16889->9690|16982->9746|17003->9757|17149->9871|17168->9879|17201->9888|17397->10065|17410->10069|17449->10070|17493->10078|17570->10145|17610->10146|17692->10191|17713->10202|17886->10343|17905->10351|17938->10360|18078->10463|18094->10469|18181->10532|18230->10562|18243->10566|18283->10567|18326->10574|18444->10674|18486->10676|18531->10685|18562->10706|18603->10708|18689->10757|18710->10768|18827->10853|18846->10861|18879->10870|19021->10975|19037->10981|19067->10988|19135->11024|19174->11031|19212->11037|19249->11042|19290->11047|19357->11104|19398->11106|19478->11149|19499->11160|19634->11263|19653->11271|19686->11280|19849->11424|19862->11428|19901->11429|19981->11472|20002->11483|20138->11587|20157->11595|20190->11604|20361->11743|20417->11767
                    LINES: 26->1|33->9|33->9|35->9|36->10|36->10|36->10|37->5|37->5|38->1|39->5|41->7|41->7|41->7|43->11|45->13|45->13|45->13|45->13|49->17|49->17|49->17|50->18|50->18|50->18|51->19|54->22|54->22|54->22|55->23|55->23|56->24|64->32|64->32|64->32|65->33|65->33|65->33|66->34|66->34|66->34|67->35|80->48|80->48|80->48|83->51|83->51|83->51|90->58|90->58|90->58|94->62|96->64|96->64|96->64|97->65|97->65|97->65|98->66|99->67|99->67|99->67|102->70|102->70|102->70|105->73|113->81|113->81|113->81|117->85|117->85|117->85|118->86|118->86|118->86|118->86|118->86|119->87|120->88|120->88|120->88|121->89|121->89|121->89|121->89|121->89|122->90|125->93|125->93|125->93|126->94|126->94|126->94|128->96|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|135->103|135->103|135->103|136->104|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|139->107|139->107|140->108|141->109|141->109|141->109|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111|143->111|143->111|144->112|146->114|153->121|153->121|153->121|156->124|156->124|156->124|162->130|162->130|162->130|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|165->133|165->133|165->133|165->133|166->134|166->134|166->134|166->134|166->134|166->134|166->134|167->135|174->142|174->142|174->142|175->143|175->143|175->143|176->144|176->144|176->144|177->145|177->145|177->145|177->145|177->145|177->145|177->145|178->146|178->146|178->146|178->146|178->146|178->146|178->146|179->147|187->155|187->155|187->155|187->155|187->155|192->160|192->160|199->167|199->167|199->167|199->167|199->167|199->167|199->167|205->173|205->173|205->173|206->174|206->174|206->174|207->175|207->175|207->175|208->176|218->186|218->186|218->186|223->191|223->191|223->191|229->197|229->197|229->197|229->197|229->197|229->197|235->203|235->203|235->203|243->211|243->211|243->211|243->211|243->211|250->218|250->218|250->218|256->224|256->224|256->224|264->232|264->232|264->232|271->239|271->239|271->239|275->243|275->243|275->243|279->247|279->247|279->247|279->247|279->247|284->252|284->252|284->252|285->253|285->253|285->253|287->255|287->255|287->255|287->255|287->255|288->256|288->256|288->256|291->259|291->259|291->259|292->260|292->260|292->260|293->261|293->261|293->261|295->263|295->263|295->263|295->263|295->263|296->264|296->264|296->264|299->267|300->268|301->269|302->270|303->271|303->271|303->271|305->273|305->273|305->273|305->273|305->273|309->277|309->277|309->277|311->279|311->279|311->279|311->279|311->279|315->283|322->290
                    -- GENERATED --
                */
            