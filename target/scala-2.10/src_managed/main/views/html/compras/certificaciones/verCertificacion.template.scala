
package views.html.compras.certificaciones

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
object verCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Certificacion],Certificacion,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[Certificacion], certificacion: Certificacion, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.121*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(certificacion.id.toString))),format.raw/*6.53*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.compras.mainCompras("Vista de certificacion Personal")/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de certificacion Personal</h1>
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

<div class="row menu-acciones">
	<div class="col-sm-5">
		<a href=""""),_display_(Seq[Any](/*44.13*/controllers/*44.24*/.compras.routes.CertificacionesController.crear())),_display_(Seq[Any](/*44.74*/UriTrack/*44.82*/.get("?"))),format.raw/*44.91*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*45.13*/controllers/*45.24*/.compras.routes.CertificacionesController.editar(certificacion.id))),_display_(Seq[Any](/*45.91*/UriTrack/*45.99*/.get("&"))),format.raw/*45.108*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*46.13*/controllers/*46.24*/.compras.routes.CertificacionesController.duplicar(certificacion.id))),_display_(Seq[Any](/*46.93*/UriTrack/*46.101*/.get("&"))),format.raw/*46.110*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
		<a href=""""),_display_(Seq[Any](/*47.13*/controllers/*47.24*/.compras.routes.CertificacionesController.eliminar(certificacion.id))),_display_(Seq[Any](/*47.93*/UriTrack/*47.101*/.get("&"))),format.raw/*47.110*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-4">
		"""),_display_(Seq[Any](/*50.4*/if(certificacionForm("tipoCuenta").value != null)/*50.53*/{_display_(Seq[Any](format.raw/*50.54*/("""
			<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*51.64*/certificacionForm("tipoCuenta.nombre")/*51.102*/.value)),format.raw/*51.108*/("""</span>
		""")))})),format.raw/*52.4*/("""
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*55.13*/UriTrack/*55.21*/.getOnNull(controllers.compras.routes.CertificacionesController.index().absoluteURL()))),format.raw/*55.107*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
		"""),_display_(Seq[Any](/*57.4*/if(paginadorFicha.getLista().size() > 1)/*57.44*/{_display_(Seq[Any](format.raw/*57.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*60.5*/if(paginadorFicha.hasPrev())/*60.33*/ {_display_(Seq[Any](format.raw/*60.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*61.29*/controllers/*61.40*/.compras.routes.CertificacionesController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*61.116*/UriTrack/*61.124*/.get("&"))),format.raw/*61.133*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*62.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*63.79*/paginadorFicha/*63.93*/.posicionActual())),format.raw/*63.110*/(""" de """),_display_(Seq[Any](/*63.115*/paginadorFicha/*63.129*/.getLista().size())),format.raw/*63.147*/("""</p>
			"""),_display_(Seq[Any](/*64.5*/if(paginadorFicha.hasNext())/*64.33*/ {_display_(Seq[Any](format.raw/*64.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*65.29*/controllers/*65.40*/.compras.routes.CertificacionesController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*65.116*/UriTrack/*65.124*/.get("&"))),format.raw/*65.133*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*66.5*/("""  
		</div>
		""")))})),format.raw/*68.4*/("""
		
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*75.49*/certificacion/*75.62*/.nombre)),format.raw/*75.69*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
			<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*80.49*/controllers/*80.60*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(certificacion.proveedor.id))),format.raw/*80.159*/("""">
					"""),_display_(Seq[Any](/*81.7*/certificacionForm("proveedor.nombre")/*81.44*/.value)),format.raw/*81.50*/("""
				</a>
			</p>
		</div>
		<div class="col-sm-2">
			<label>Expediente</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*87.49*/certificacionForm("expediente.expedienteEjercicio")/*87.100*/.value)),format.raw/*87.106*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Periodo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*91.49*/certificacionForm("periodo.nombre")/*91.84*/.value)),format.raw/*91.90*/("""</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label>Orden de Compras</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*97.49*/if(certificacion.orden != null)/*97.80*/{_display_(Seq[Any](_display_(Seq[Any](/*97.82*/certificacionForm("orden.nombre")/*97.115*/.value))))})),format.raw/*97.122*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha certificacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*101.49*/certificacionForm("fecha_certificacion")/*101.89*/.value)),format.raw/*101.95*/("""</p>
		</div>
		<div class="col-sm-2">
			 <label class="control-label">Tipo Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*105.49*/if(certificacion.tipoCuenta != null)/*105.85*/{_display_(Seq[Any](_display_(Seq[Any](/*105.87*/certificacion/*105.100*/.tipoCuenta.nombre))))})),format.raw/*105.119*/("""</p>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">Creacion Automatica
				"""),_display_(Seq[Any](/*110.6*/checkbox(certificacionForm("creacion_automatica"), 'disabled -> "disabled"))),format.raw/*110.81*/("""</label> 
			</div>
		</div>
	</div>	
	
	"""),_display_(Seq[Any](/*115.3*/views/*115.8*/.html.compras.certificaciones.tabsCertificacion(false, certificacionForm))),format.raw/*115.81*/("""
	<h4>Base: 	   <b>"""),_display_(Seq[Any](/*116.20*/utils/*116.25*/.NumberUtils.moneda(certificacion.getBase()))),format.raw/*116.69*/("""</b></h4>	
	<h4>Descuento: <b>"""),_display_(Seq[Any](/*117.21*/utils/*117.26*/.NumberUtils.moneda(certificacion.getDescuento()))),format.raw/*117.75*/("""</b></h4>	
	<h4>Total: 	   <b>"""),_display_(Seq[Any](/*118.21*/utils/*118.26*/.NumberUtils.moneda(certificacion.getTotal()))),format.raw/*118.71*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*119.26*/certificacion/*119.39*/.estado.nombre)),format.raw/*119.53*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*121.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(certificacion.estado.orden,models.Estado.TIPO_CERTIFICACION)) yield /*121.122*/ {_display_(Seq[Any](format.raw/*121.124*/("""	
			"""),_display_(Seq[Any](/*122.5*/if(estado.orden <= 4)/*122.26*/ {_display_(Seq[Any](format.raw/*122.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*124.16*/controllers/*124.27*/.compras.routes.CertificacionesController.cambiarEstado(certificacionForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*124.144*/UriTrack/*124.152*/.get("&"))),format.raw/*124.161*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*125.56*/estado/*125.62*/.nombre)),format.raw/*125.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*129.5*/("""
		""")))})),format.raw/*130.4*/("""
		"""),_display_(Seq[Any](/*131.4*/if(certificacion.estado.id == models.Estado.CERTIFICACION_ESTADO_CANCELADO)/*131.79*/ {_display_(Seq[Any](format.raw/*131.81*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*133.15*/controllers/*133.26*/.compras.routes.CertificacionesController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_ESTADO_BORRADOR))),_display_(Seq[Any](/*133.170*/UriTrack/*133.178*/.get("&"))),format.raw/*133.187*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*137.4*/else/*137.8*/{_display_(Seq[Any](format.raw/*137.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*139.15*/controllers/*139.26*/.compras.routes.CertificacionesController.cambiarEstado(certificacionForm.field("id").value.toInt, models.Estado.CERTIFICACION_ESTADO_CANCELADO))),_display_(Seq[Any](/*139.171*/UriTrack/*139.179*/.get("&"))),format.raw/*139.188*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Certificacion
				</a>
			</div>
		""")))})),format.raw/*143.4*/("""
	</div>
""")))})),format.raw/*145.2*/("""


"""))}
    }
    
    def render(certificacionForm:Form[Certificacion],certificacion:Certificacion,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm,certificacion,paginadorFicha)
    
    def f:((Form[Certificacion],Certificacion,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm,certificacion,paginadorFicha) => apply(certificacionForm,certificacion,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/verCertificacion.scala.html
                    HASH: 7cf0ac7014c34dba6c72809f69b5450b6220e411
                    MATRIX: 868->1|1107->158|1139->182|1214->120|1243->226|1283->232|1305->246|1363->283|1400->286|1412->291|1480->351|1519->353|2537->1336|2550->1341|2597->1366|2707->1440|2727->1451|2807->1501|2824->1509|2855->1518|2987->1614|3007->1625|3104->1692|3121->1700|3153->1709|3281->1801|3301->1812|3400->1881|3418->1889|3450->1898|3585->1997|3605->2008|3704->2077|3722->2085|3754->2094|3944->2249|4002->2298|4041->2299|4142->2364|4190->2402|4219->2408|4262->2420|4346->2468|4363->2476|4472->2562|4586->2641|4635->2681|4674->2682|4744->2717|4781->2745|4821->2747|4887->2777|4907->2788|5014->2864|5032->2872|5064->2881|5179->2965|5295->3045|5318->3059|5358->3076|5400->3081|5424->3095|5465->3113|5510->3123|5547->3151|5587->3153|5653->3183|5673->3194|5780->3270|5798->3278|5830->3287|5946->3372|5994->3389|6199->3558|6221->3571|6250->3578|6517->3809|6537->3820|6659->3919|6704->3929|6750->3966|6778->3972|6950->4108|7011->4159|7040->4165|7215->4304|7259->4339|7287->4345|7478->4500|7518->4531|7566->4533|7609->4566|7643->4573|7831->4724|7881->4764|7910->4770|8091->4914|8137->4950|8186->4952|8210->4965|8257->4984|8421->5112|8519->5187|8602->5234|8616->5239|8712->5312|8770->5333|8785->5338|8852->5382|8921->5414|8936->5419|9008->5468|9077->5500|9092->5505|9160->5550|9234->5587|9257->5600|9294->5614|9382->5666|9518->5784|9560->5786|9603->5793|9634->5814|9675->5816|9757->5861|9778->5872|9927->5989|9946->5997|9979->6006|10099->6089|10115->6095|10145->6102|10212->6137|10249->6142|10290->6147|10375->6222|10416->6224|10496->6267|10517->6278|10693->6422|10712->6430|10745->6439|10888->6563|10901->6567|10940->6568|11020->6611|11041->6622|11218->6767|11237->6775|11270->6784|11430->6912|11474->6924
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|36->7|36->7|36->7|36->7|69->40|69->40|69->40|73->44|73->44|73->44|73->44|73->44|74->45|74->45|74->45|74->45|74->45|75->46|75->46|75->46|75->46|75->46|76->47|76->47|76->47|76->47|76->47|79->50|79->50|79->50|80->51|80->51|80->51|81->52|84->55|84->55|84->55|86->57|86->57|86->57|89->60|89->60|89->60|90->61|90->61|90->61|90->61|90->61|91->62|92->63|92->63|92->63|92->63|92->63|92->63|93->64|93->64|93->64|94->65|94->65|94->65|94->65|94->65|95->66|97->68|104->75|104->75|104->75|109->80|109->80|109->80|110->81|110->81|110->81|116->87|116->87|116->87|120->91|120->91|120->91|126->97|126->97|126->97|126->97|126->97|130->101|130->101|130->101|134->105|134->105|134->105|134->105|134->105|139->110|139->110|144->115|144->115|144->115|145->116|145->116|145->116|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|150->121|150->121|150->121|151->122|151->122|151->122|153->124|153->124|153->124|153->124|153->124|154->125|154->125|154->125|158->129|159->130|160->131|160->131|160->131|162->133|162->133|162->133|162->133|162->133|166->137|166->137|166->137|168->139|168->139|168->139|168->139|168->139|172->143|174->145
                    -- GENERATED --
                */
            