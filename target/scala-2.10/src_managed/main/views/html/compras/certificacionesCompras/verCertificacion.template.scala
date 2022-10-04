
package views.html.compras.certificacionesCompras

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
object verCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Form[CertificacionCompra],CertificacionCompra,utils.pagination.PaginadorFicha,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[CertificacionCompra], certificacion: CertificacionCompra, paginadorFicha: utils.pagination.PaginadorFicha,obras:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.147*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(certificacion.id.toString))),format.raw/*6.53*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.compras.mainCompras("Vista de Certificacion")/*7.58*/ {_display_(Seq[Any](format.raw/*7.60*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de Certificacion """),_display_(Seq[Any](/*11.33*/if(obras)/*11.42*/{_display_(Seq[Any](format.raw/*11.43*/("""Obras""")))}/*11.49*/else/*11.53*/{_display_(Seq[Any](format.raw/*11.54*/("""Compras""")))})),format.raw/*11.62*/("""</h1>
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
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>

			</div>
		</div>
	</div>
	
"""),_display_(Seq[Any](/*40.2*/views/*40.7*/.html.tags.successError())),format.raw/*40.32*/("""
<div class="alert alert-success successAddLineaAjuste" style="display: none;"><i class="glyphicon glyphicon-ok-sign"></i></div>
	
<div class="row menu-acciones">
	<div class="col-sm-5">
		"""),_display_(Seq[Any](/*45.4*/if(obras)/*45.13*/{_display_(Seq[Any](format.raw/*45.14*/("""
			<a href=""""),_display_(Seq[Any](/*46.14*/controllers/*46.25*/.compras.routes.CertificacionesObrasController.crear())),_display_(Seq[Any](/*46.80*/UriTrack/*46.88*/.get("?"))),format.raw/*46.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*47.14*/controllers/*47.25*/.compras.routes.CertificacionesObrasController.editar(certificacion.id))),_display_(Seq[Any](/*47.97*/UriTrack/*47.105*/.get("&"))),format.raw/*47.114*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*48.14*/controllers/*48.25*/.compras.routes.CertificacionesObrasController.duplicar(certificacion.id))),_display_(Seq[Any](/*48.99*/UriTrack/*48.107*/.get("&"))),format.raw/*48.116*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.compras.routes.CertificacionesObrasController.eliminar(certificacion.id))),_display_(Seq[Any](/*49.99*/UriTrack/*49.107*/.get("&"))),format.raw/*49.116*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))}/*50.4*/else/*50.8*/{_display_(Seq[Any](format.raw/*50.9*/("""
			<a href=""""),_display_(Seq[Any](/*51.14*/controllers/*51.25*/.compras.routes.CertificacionesComprasController.crear())),_display_(Seq[Any](/*51.82*/UriTrack/*51.90*/.get("?"))),format.raw/*51.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*52.14*/controllers/*52.25*/.compras.routes.CertificacionesComprasController.editar(certificacion.id))),_display_(Seq[Any](/*52.99*/UriTrack/*52.107*/.get("&"))),format.raw/*52.116*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.compras.routes.CertificacionesComprasController.duplicar(certificacion.id))),_display_(Seq[Any](/*53.101*/UriTrack/*53.109*/.get("&"))),format.raw/*53.118*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
			<a href=""""),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.compras.routes.CertificacionesComprasController.eliminar(certificacion.id))),_display_(Seq[Any](/*54.101*/UriTrack/*54.109*/.get("&"))),format.raw/*54.118*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*55.4*/("""
		
	</div>
	<div class="col-sm-4">
			"""),_display_(Seq[Any](/*59.5*/if(certificacionForm("tipoCuenta").value != null)/*59.54*/{_display_(Seq[Any](format.raw/*59.55*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*60.65*/certificacionForm("tipoCuenta.nombre")/*60.103*/.value)),format.raw/*60.109*/("""</span>
			""")))})),format.raw/*61.5*/("""
	</div>
	<div class="col-sm-3">
		"""),_display_(Seq[Any](/*64.4*/if(obras)/*64.13*/{_display_(Seq[Any](format.raw/*64.14*/("""
			<a href=""""),_display_(Seq[Any](/*65.14*/UriTrack/*65.22*/.getOnNull(controllers.compras.routes.CertificacionesObrasController.index().absoluteURL()))),format.raw/*65.113*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			"""),_display_(Seq[Any](/*66.5*/if(paginadorFicha.getLista().size() > 1)/*66.45*/{_display_(Seq[Any](format.raw/*66.46*/("""
				<div class="btn-group">
					"""),_display_(Seq[Any](/*68.7*/if(paginadorFicha.hasPrev())/*68.35*/ {_display_(Seq[Any](format.raw/*68.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*69.31*/controllers/*69.42*/.compras.routes.CertificacionesObrasController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*69.123*/UriTrack/*69.131*/.get("&"))),format.raw/*69.140*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
					""")))})),format.raw/*70.7*/("""
					<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*71.81*/paginadorFicha/*71.95*/.posicionActual())),format.raw/*71.112*/(""" de """),_display_(Seq[Any](/*71.117*/paginadorFicha/*71.131*/.getLista().size())),format.raw/*71.149*/("""</p>
					"""),_display_(Seq[Any](/*72.7*/if(paginadorFicha.hasNext())/*72.35*/ {_display_(Seq[Any](format.raw/*72.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*73.31*/controllers/*73.42*/.compras.routes.CertificacionesObrasController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*73.123*/UriTrack/*73.131*/.get("&"))),format.raw/*73.140*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
					""")))})),format.raw/*74.7*/("""  
				</div>
			""")))})),format.raw/*76.5*/("""
		""")))}/*77.4*/else/*77.8*/{_display_(Seq[Any](format.raw/*77.9*/("""
			<a href=""""),_display_(Seq[Any](/*78.14*/UriTrack/*78.22*/.getOnNull(controllers.compras.routes.CertificacionesComprasController.index().absoluteURL()))),format.raw/*78.115*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			"""),_display_(Seq[Any](/*79.5*/if(paginadorFicha.getLista().size() > 1)/*79.45*/{_display_(Seq[Any](format.raw/*79.46*/("""
				<div class="btn-group">
					"""),_display_(Seq[Any](/*81.7*/if(paginadorFicha.hasPrev())/*81.35*/ {_display_(Seq[Any](format.raw/*81.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*82.31*/controllers/*82.42*/.compras.routes.CertificacionesComprasController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*82.125*/UriTrack/*82.133*/.get("&"))),format.raw/*82.142*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
					""")))})),format.raw/*83.7*/("""
					<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*84.81*/paginadorFicha/*84.95*/.posicionActual())),format.raw/*84.112*/(""" de """),_display_(Seq[Any](/*84.117*/paginadorFicha/*84.131*/.getLista().size())),format.raw/*84.149*/("""</p>
					"""),_display_(Seq[Any](/*85.7*/if(paginadorFicha.hasNext())/*85.35*/ {_display_(Seq[Any](format.raw/*85.37*/("""
						<a  role="group" href=""""),_display_(Seq[Any](/*86.31*/controllers/*86.42*/.compras.routes.CertificacionesComprasController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*86.125*/UriTrack/*86.133*/.get("&"))),format.raw/*86.142*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
					""")))})),format.raw/*87.7*/("""  
				</div>
			""")))})),format.raw/*89.5*/("""
		""")))})),format.raw/*90.4*/("""
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*96.49*/certificacion/*96.62*/.nombre)),format.raw/*96.69*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
			<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*101.49*/controllers/*101.60*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(certificacion.proveedor.id))),format.raw/*101.159*/("""">
					"""),_display_(Seq[Any](/*102.7*/certificacionForm("proveedor.nombre")/*102.44*/.value)),format.raw/*102.50*/("""
				</a>
			</p>
		</div>
		<div class="col-sm-2">
			<label>Expediente</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*108.49*/certificacionForm("expediente.expedienteEjercicio")/*108.100*/.value)),format.raw/*108.106*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Periodo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*112.49*/certificacionForm("periodo.nombre")/*112.84*/.value)),format.raw/*112.90*/("""</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label>Orden de Compras</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*118.49*/if(certificacion.orden != null)/*118.80*/{_display_(Seq[Any](_display_(Seq[Any](/*118.82*/certificacionForm("orden.nombre")/*118.115*/.value))))})),format.raw/*118.122*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha certificacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*122.49*/certificacionForm("fecha_certificacion")/*122.89*/.value)),format.raw/*122.95*/("""</p>
		</div>
		<!-- <div class="col-sm-1">
			<div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*128.7*/checkbox(certificacionForm("profe"), 'disabled -> "disabled"))),format.raw/*128.68*/("""
				</label>
			</div>
		</div> -->
		<div class="col-sm-2">
			<label class="control-label">Tipo Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*134.49*/if(certificacion.tipoCuenta != null)/*134.85*/{_display_(Seq[Any](_display_(Seq[Any](/*134.87*/certificacion/*134.100*/.tipoCuenta.nombre))))})),format.raw/*134.119*/("""</p>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">Creacion Automatica
				"""),_display_(Seq[Any](/*139.6*/checkbox(certificacionForm("creacion_automatica"), 'disabled -> "disabled"))),format.raw/*139.81*/("""</label> 
			</div>
		</div>
	</div>	
	<input type="hidden" name="certificacionId" id="certificacionId" value=""""),_display_(Seq[Any](/*143.75*/certificacionForm("id")/*143.98*/.value)),format.raw/*143.104*/(""""/>
	"""),_display_(Seq[Any](/*144.3*/views/*144.8*/.html.compras.certificacionesCompras.tabsCertificacion(false, certificacionForm))),format.raw/*144.88*/("""
	<h4>Base: 	   <b>"""),_display_(Seq[Any](/*145.20*/utils/*145.25*/.NumberUtils.moneda(certificacion.getBase()))),format.raw/*145.69*/("""</b></h4>	
	<h4>Descuento: <b>"""),_display_(Seq[Any](/*146.21*/utils/*146.26*/.NumberUtils.moneda(certificacion.getDescuento()))),format.raw/*146.75*/("""</b></h4>	
	<h4>Total: 	   <b>"""),_display_(Seq[Any](/*147.21*/utils/*147.26*/.NumberUtils.moneda(certificacion.getTotal()))),format.raw/*147.71*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*148.26*/certificacion/*148.39*/.estado.nombre)),format.raw/*148.53*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*150.4*/if(obras)/*150.13*/{_display_(Seq[Any](format.raw/*150.14*/("""
			"""),_display_(Seq[Any](/*151.5*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(certificacion.estado.orden,models.Estado.TIPO_CERTIFICACION_COMPRA)) yield /*151.130*/ {_display_(Seq[Any](format.raw/*151.132*/("""	
				"""),_display_(Seq[Any](/*152.6*/if(estado.orden <= 3)/*152.27*/ {_display_(Seq[Any](format.raw/*152.29*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*154.17*/controllers/*154.28*/.compras.routes.CertificacionesObrasController.cambiarEstado(certificacionForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*154.150*/UriTrack/*154.158*/.get("&"))),format.raw/*154.167*/("""" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*155.57*/estado/*155.63*/.nombre)),format.raw/*155.70*/("""
						</a>
					</div>
					
				""")))})),format.raw/*159.6*/("""
			""")))})),format.raw/*160.5*/("""
			"""),_display_(Seq[Any](/*161.5*/if(certificacion.estado.id == models.Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO)/*161.87*/ {_display_(Seq[Any](format.raw/*161.89*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*163.16*/controllers/*163.27*/.compras.routes.CertificacionesObrasController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR))),_display_(Seq[Any](/*163.183*/UriTrack/*163.191*/.get("&"))),format.raw/*163.200*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
					</a>
				</div>
			""")))}/*167.5*/else/*167.9*/{_display_(Seq[Any](format.raw/*167.10*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*169.16*/controllers/*169.27*/.compras.routes.CertificacionesObrasController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO))),_display_(Seq[Any](/*169.184*/UriTrack/*169.192*/.get("&"))),format.raw/*169.201*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Certificacion
					</a>
				</div>
			""")))})),format.raw/*173.5*/("""
		""")))}/*174.4*/else/*174.8*/{_display_(Seq[Any](format.raw/*174.9*/("""
			"""),_display_(Seq[Any](/*175.5*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(certificacion.estado.orden,models.Estado.TIPO_CERTIFICACION_COMPRA)) yield /*175.130*/ {_display_(Seq[Any](format.raw/*175.132*/("""	
				"""),_display_(Seq[Any](/*176.6*/if(estado.orden <= 3)/*176.27*/ {_display_(Seq[Any](format.raw/*176.29*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*178.17*/controllers/*178.28*/.compras.routes.CertificacionesComprasController.cambiarEstado(certificacionForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*178.152*/UriTrack/*178.160*/.get("&"))),format.raw/*178.169*/("""" class="btn btn-default btn-disable-onclick">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*179.57*/estado/*179.63*/.nombre)),format.raw/*179.70*/("""
						</a>
					</div>
					
				""")))})),format.raw/*183.6*/("""
			""")))})),format.raw/*184.5*/("""
			"""),_display_(Seq[Any](/*185.5*/if(certificacion.estado.id == models.Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO)/*185.87*/ {_display_(Seq[Any](format.raw/*185.89*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*187.16*/controllers/*187.27*/.compras.routes.CertificacionesComprasController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR))),_display_(Seq[Any](/*187.185*/UriTrack/*187.193*/.get("&"))),format.raw/*187.202*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
					</a>
				</div>
			""")))}/*191.5*/else/*191.9*/{_display_(Seq[Any](format.raw/*191.10*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*193.16*/controllers/*193.27*/.compras.routes.CertificacionesComprasController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO))),_display_(Seq[Any](/*193.186*/UriTrack/*193.194*/.get("&"))),format.raw/*193.203*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Certificacion
					</a>
				</div>
			""")))})),format.raw/*197.5*/("""
		""")))})),format.raw/*198.4*/("""
	</div>
""")))})),format.raw/*200.2*/("""


"""))}
    }
    
    def render(certificacionForm:Form[CertificacionCompra],certificacion:CertificacionCompra,paginadorFicha:utils.pagination.PaginadorFicha,obras:Boolean): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm,certificacion,paginadorFicha,obras)
    
    def f:((Form[CertificacionCompra],CertificacionCompra,utils.pagination.PaginadorFicha,Boolean) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm,certificacion,paginadorFicha,obras) => apply(certificacionForm,certificacion,paginadorFicha,obras)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/verCertificacion.scala.html
                    HASH: 8d497e23e03333370b7841250ef342d365f08c71
                    MATRIX: 895->1|1160->184|1192->208|1267->146|1296->252|1336->258|1358->272|1416->309|1453->312|1465->317|1524->368|1563->370|1709->480|1727->489|1766->490|1791->496|1804->500|1843->501|1883->509|2784->1375|2797->1380|2844->1405|3074->1600|3092->1609|3131->1610|3182->1625|3202->1636|3287->1691|3304->1699|3335->1708|3468->1805|3488->1816|3590->1888|3608->1896|3640->1905|3769->1998|3789->2009|3893->2083|3911->2091|3943->2100|4079->2200|4099->2211|4203->2285|4221->2293|4253->2302|4392->2423|4404->2427|4442->2428|4493->2443|4513->2454|4600->2511|4617->2519|4648->2528|4781->2625|4801->2636|4905->2710|4923->2718|4955->2727|5084->2820|5104->2831|5211->2907|5229->2915|5261->2924|5397->3024|5417->3035|5524->3111|5542->3119|5574->3128|5726->3249|5805->3293|5863->3342|5902->3343|6004->3409|6052->3447|6081->3453|6125->3466|6199->3505|6217->3514|6256->3515|6307->3530|6324->3538|6438->3629|6549->3705|6598->3745|6637->3746|6709->3783|6746->3811|6786->3813|6854->3845|6874->3856|6986->3937|7004->3945|7036->3954|7153->4040|7271->4122|7294->4136|7334->4153|7376->4158|7400->4172|7441->4190|7488->4202|7525->4230|7565->4232|7633->4264|7653->4275|7765->4356|7783->4364|7815->4373|7933->4460|7984->4480|8007->4485|8019->4489|8057->4490|8108->4505|8125->4513|8241->4606|8352->4682|8401->4722|8440->4723|8512->4760|8549->4788|8589->4790|8657->4822|8677->4833|8791->4916|8809->4924|8841->4933|8958->5019|9076->5101|9099->5115|9139->5132|9181->5137|9205->5151|9246->5169|9293->5181|9330->5209|9370->5211|9438->5243|9458->5254|9572->5337|9590->5345|9622->5354|9740->5441|9791->5461|9827->5466|10028->5631|10050->5644|10079->5651|10347->5882|10368->5893|10491->5992|10537->6002|10584->6039|10613->6045|10786->6181|10848->6232|10878->6238|11054->6377|11099->6412|11128->6418|11320->6573|11361->6604|11410->6606|11454->6639|11489->6646|11677->6797|11727->6837|11756->6843|11920->6971|12004->7032|12209->7200|12255->7236|12304->7238|12328->7251|12375->7270|12539->7398|12637->7473|12790->7589|12823->7612|12853->7618|12896->7625|12910->7630|13013->7710|13071->7731|13086->7736|13153->7780|13222->7812|13237->7817|13309->7866|13378->7898|13393->7903|13461->7948|13535->7985|13558->7998|13595->8012|13683->8064|13702->8073|13742->8074|13784->8080|13927->8205|13969->8207|14013->8215|14044->8236|14085->8238|14169->8285|14190->8296|14344->8418|14363->8426|14396->8435|14537->8539|14553->8545|14583->8552|14654->8591|14692->8597|14734->8603|14826->8685|14867->8687|14949->8732|14970->8743|15158->8899|15177->8907|15210->8916|15377->9064|15390->9068|15430->9069|15512->9114|15533->9125|15722->9282|15741->9290|15774->9299|15958->9451|15982->9456|15995->9460|16034->9461|16076->9467|16219->9592|16261->9594|16305->9602|16336->9623|16377->9625|16461->9672|16482->9683|16638->9807|16657->9815|16690->9824|16831->9928|16847->9934|16877->9941|16948->9980|16986->9986|17028->9992|17120->10074|17161->10076|17243->10121|17264->10132|17454->10290|17473->10298|17506->10307|17673->10455|17686->10459|17726->10460|17808->10505|17829->10516|18020->10675|18039->10683|18072->10692|18256->10844|18293->10849|18337->10861
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|36->7|36->7|36->7|36->7|40->11|40->11|40->11|40->11|40->11|40->11|40->11|69->40|69->40|69->40|74->45|74->45|74->45|75->46|75->46|75->46|75->46|75->46|76->47|76->47|76->47|76->47|76->47|77->48|77->48|77->48|77->48|77->48|78->49|78->49|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|80->51|80->51|81->52|81->52|81->52|81->52|81->52|82->53|82->53|82->53|82->53|82->53|83->54|83->54|83->54|83->54|83->54|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|93->64|93->64|93->64|94->65|94->65|94->65|95->66|95->66|95->66|97->68|97->68|97->68|98->69|98->69|98->69|98->69|98->69|99->70|100->71|100->71|100->71|100->71|100->71|100->71|101->72|101->72|101->72|102->73|102->73|102->73|102->73|102->73|103->74|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|108->79|108->79|110->81|110->81|110->81|111->82|111->82|111->82|111->82|111->82|112->83|113->84|113->84|113->84|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|115->86|115->86|116->87|118->89|119->90|125->96|125->96|125->96|130->101|130->101|130->101|131->102|131->102|131->102|137->108|137->108|137->108|141->112|141->112|141->112|147->118|147->118|147->118|147->118|147->118|151->122|151->122|151->122|157->128|157->128|163->134|163->134|163->134|163->134|163->134|168->139|168->139|172->143|172->143|172->143|173->144|173->144|173->144|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|179->150|179->150|179->150|180->151|180->151|180->151|181->152|181->152|181->152|183->154|183->154|183->154|183->154|183->154|184->155|184->155|184->155|188->159|189->160|190->161|190->161|190->161|192->163|192->163|192->163|192->163|192->163|196->167|196->167|196->167|198->169|198->169|198->169|198->169|198->169|202->173|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|207->178|207->178|207->178|207->178|207->178|208->179|208->179|208->179|212->183|213->184|214->185|214->185|214->185|216->187|216->187|216->187|216->187|216->187|220->191|220->191|220->191|222->193|222->193|222->193|222->193|222->193|226->197|227->198|229->200
                    -- GENERATED --
                */
            