
package views.html.patrimonio.certificaciones

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
object verCertificacionServicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[CertificacionServicio,Form[CertificacionServicio],utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacion: CertificacionServicio,certificacionForm: Form[CertificacionServicio], paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.136*/("""
"""),format.raw/*5.70*/(""" 

"""),_display_(Seq[Any](/*7.2*/paginadorFicha/*7.16*/.setActual(certificacion.id.toString))),format.raw/*7.53*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Detalle certificación de servicio")/*9.75*/ {_display_(Seq[Any](format.raw/*9.77*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Detalle de la certificación</h1>
		</div>			
			
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						"""),_display_(Seq[Any](/*26.8*/if(Permiso.check("certificacionesServiciosVer"))/*26.56*/ {_display_(Seq[Any](format.raw/*26.58*/("""
				  			<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*27.74*/controllers/*27.85*/.patrimonio.routes.CertificacionesReportesController.reporteCertificacion(certificacion.id))),format.raw/*27.176*/("""" id="reporteCertificacion"> Certificacion de servicio</a></li>	
					    """)))})),format.raw/*28.11*/("""
				  </ul>
				</div>

			</div>
			
				 
	</div>
</div> 
 """),_display_(Seq[Any](/*37.3*/views/*37.8*/.html.tags.successError())),format.raw/*37.33*/("""
<div class="row menu-acciones">
	<div class="col-sm-4">
		<a href=""""),_display_(Seq[Any](/*40.13*/controllers/*40.24*/.patrimonio.routes.CertificacionesServiciosController.editar(certificacion.id))),_display_(Seq[Any](/*40.103*/UriTrack/*40.111*/.get("&"))),format.raw/*40.120*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*41.13*/controllers/*41.24*/.patrimonio.routes.CertificacionesServiciosController.eliminar(certificacion.id))),_display_(Seq[Any](/*41.105*/UriTrack/*41.113*/.get("&"))),format.raw/*41.122*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-5">
		"""),_display_(Seq[Any](/*44.4*/if(certificacion.ordenProvision.ordenCompra.tipo_moneda != null)/*44.68*/{_display_(Seq[Any](format.raw/*44.69*/("""
			<span style="color:green;font-weight:bold;font-size: 24px;">MONEDA EXTRANJERA</span>
		""")))})),format.raw/*46.4*/("""
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*49.13*/UriTrack/*49.21*/.getOnNull(controllers.patrimonio.routes.CertificacionesServiciosController.index().absoluteURL()))),format.raw/*49.119*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		 """),_display_(Seq[Any](/*50.5*/if(paginadorFicha.getLista().size() > 1)/*50.45*/{_display_(Seq[Any](format.raw/*50.46*/("""
		
              	
			<div class="btn-group">
				"""),_display_(Seq[Any](/*54.6*/if(paginadorFicha.hasPrev())/*54.34*/ {_display_(Seq[Any](format.raw/*54.36*/("""
					<a  role="group" href=""""),_display_(Seq[Any](/*55.30*/controllers/*55.41*/.patrimonio.routes.CertificacionesServiciosController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*55.129*/UriTrack/*55.137*/.get("&"))),format.raw/*55.146*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
				""")))})),format.raw/*56.6*/("""
				<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*57.80*/paginadorFicha/*57.94*/.posicionActual())),format.raw/*57.111*/(""" de """),_display_(Seq[Any](/*57.116*/paginadorFicha/*57.130*/.getLista().size())),format.raw/*57.148*/("""</p>
				"""),_display_(Seq[Any](/*58.6*/if(paginadorFicha.hasNext())/*58.34*/ {_display_(Seq[Any](format.raw/*58.36*/("""
					<a  role="group" href=""""),_display_(Seq[Any](/*59.30*/controllers/*59.41*/.patrimonio.routes.CertificacionesServiciosController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*59.129*/UriTrack/*59.137*/.get("&"))),format.raw/*59.146*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
				""")))})),format.raw/*60.6*/("""  
			</div>
		""")))})),format.raw/*62.4*/("""
	</div>
</div> 
    
<div class="row">

	<div class="col-sm-2">
		<div class="form-group">
			<label for="nombre" class="control-label">Orden provisión</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*71.49*/certificacion/*71.62*/.ordenProvision.numero)),format.raw/*71.84*/("""</p>
		</div>
	</div>
	
	
	<div class="col-sm-2">
		<div class="form-group">
			<label for="nombre" class="control-label">Expediente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*79.49*/certificacion/*79.62*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*79.125*/("""</p>
		</div>
	</div>

	<div class="col-sm-4">
		<div class="form-group">
			<label for="nombre" class="control-label">Proveedor</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*86.49*/certificacion/*86.62*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*86.106*/("""</p>
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="row">
			<div class="col-sm-6">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*94.50*/if(certificacion.periodo != null)/*94.83*/{_display_(Seq[Any](_display_(Seq[Any](/*94.85*/certificacion/*94.98*/.periodo.nombre))))})),format.raw/*94.114*/("""</p>
			</div>	
			
			<div class="col-sm-6">
				<label for="inputPeriodo" class="control-label">Fecha Certificacion</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*99.50*/DateUtils/*99.59*/.formatDate(certificacion.fecha_certificacion))),format.raw/*99.105*/("""</p>
			</div>
		</div>
		
	</div>
</div>
<div class="row">

	<div class="col-sm-2">
		<div class="form-group">
			<label for="nombre" class="control-label">N° Remito</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*110.49*/if(certificacion.numero_remito != null)/*110.88*/{_display_(Seq[Any](_display_(Seq[Any](/*110.90*/certificacion/*110.103*/.numero_remito))))})),format.raw/*110.118*/("""</p>
		</div>
	</div>
</div>
<hr />

	<!--<div class="col-sm-2">
		<label for="inputPeriodo" class="control-label">Valor</label> 
		<p class="form-control-static form-control"></p>
	</div>	-->
		
	 
		
	<!-- <div class="col-sm-4">
		<label for="inputPeriodo" class="control-label">Responsable</label> 
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*125.48*/certificacion/*125.61*/.create_usuario.nombre)),format.raw/*125.83*/("""</p>
	</div> 			
		
</div>

<!--
<div class="row">

	<div class="col-sm-4">
		<label for="inputPeriodo" class="control-label">&nbsp;</label> 
		<p class="form-control-static">"""),_display_(Seq[Any](/*135.35*/if(certificacion.fecha_certificacion != null)/*135.80*/ {_display_(Seq[Any](format.raw/*135.82*/("""<h4>Certificado el día """),_display_(Seq[Any](/*135.106*/DateUtils/*135.115*/.formatDate(certificacion.fecha_certificacion))),format.raw/*135.161*/("""</h4>""")))}/*135.168*/else/*135.173*/{_display_(Seq[Any](format.raw/*135.174*/(""" <a href="" class="btn btn btn-default"><i class="glyphicon glyphicon-star"  style="color:green"></i> Certificar</a> """)))})),format.raw/*135.292*/("""</p>
	</div>

</div>-->



	"""),_display_(Seq[Any](/*142.3*/views/*142.8*/.html.patrimonio.certificaciones.tabsCertificacion(false, certificacionForm))),format.raw/*142.84*/("""
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*143.26*/certificacion/*143.39*/.estado.nombre)),format.raw/*143.53*/("""</b></h4>

	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*146.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(certificacion.estado.orden,models.Estado.TIPO_CERTIFICACION_SERVICIO)) yield /*146.131*/ {_display_(Seq[Any](format.raw/*146.133*/("""	
			"""),_display_(Seq[Any](/*147.5*/if(estado.orden <= 2)/*147.26*/ {_display_(Seq[Any](format.raw/*147.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*149.16*/controllers/*149.27*/.patrimonio.routes.CertificacionesServiciosController.cambiarEstado(certificacion.id, estado.id.toLong))),_display_(Seq[Any](/*149.131*/UriTrack/*149.139*/.get("&"))),format.raw/*149.148*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*150.56*/estado/*150.62*/.nombre)),format.raw/*150.69*/("""
					</a>
				</div>	
			""")))})),format.raw/*153.5*/("""
		""")))})),format.raw/*154.4*/("""
		"""),_display_(Seq[Any](/*155.4*/if(certificacion.estado.id == models.Estado.CERTIFICACION_SERVICIO_BORRADOR)/*155.80*/ {_display_(Seq[Any](format.raw/*155.82*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*157.15*/controllers/*157.26*/.patrimonio.routes.CertificacionesServiciosController.cambiarEstado(certificacion.id, models.Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA))),_display_(Seq[Any](/*157.164*/UriTrack/*157.172*/.get("&"))),format.raw/*157.181*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Pasar a No Certificada
				</a>
			</div>
		""")))})),format.raw/*161.4*/("""
		
		"""),_display_(Seq[Any](/*163.4*/if(certificacion.estado.id == models.Estado.CERTIFICACION_SERVICIO_CANCELADA)/*163.81*/ {_display_(Seq[Any](format.raw/*163.83*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*165.15*/controllers/*165.26*/.patrimonio.routes.CertificacionesServiciosController.cambiarEstado(certificacion.id, models.Estado.CERTIFICACION_SERVICIO_BORRADOR))),_display_(Seq[Any](/*165.159*/UriTrack/*165.167*/.get("&"))),format.raw/*165.176*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*169.4*/else/*169.8*/{_display_(Seq[Any](format.raw/*169.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*171.15*/controllers/*171.26*/.patrimonio.routes.CertificacionesServiciosController.cambiarEstado(certificacion.id, models.Estado.CERTIFICACION_SERVICIO_CANCELADA))),_display_(Seq[Any](/*171.160*/UriTrack/*171.168*/.get("&"))),format.raw/*171.177*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar certificación
				</a>
			</div>
		""")))})),format.raw/*175.4*/("""

""")))})))}
    }
    
    def render(certificacion:CertificacionServicio,certificacionForm:Form[CertificacionServicio],paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(certificacion,certificacionForm,paginadorFicha)
    
    def f:((CertificacionServicio,Form[CertificacionServicio],utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (certificacion,certificacionForm,paginadorFicha) => apply(certificacion,certificacionForm,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/verCertificacionServicio.scala.html
                    HASH: e437c7b0f7af966e25baad3cb13d0a10a6570634
                    MATRIX: 895->1|1172->196|1204->220|1279->135|1308->264|1348->270|1370->284|1428->321|1467->326|1479->331|1555->399|1594->401|2156->928|2213->976|2253->978|2364->1053|2384->1064|2498->1155|2606->1231|2713->1303|2726->1308|2773->1333|2881->1405|2901->1416|3011->1495|3029->1503|3061->1512|3189->1604|3209->1615|3321->1696|3339->1704|3371->1713|3561->1868|3634->1932|3673->1933|3798->2027|3882->2075|3899->2083|4020->2181|4131->2257|4180->2297|4219->2298|4310->2354|4347->2382|4387->2384|4454->2415|4474->2426|4593->2514|4611->2522|4643->2531|4759->2616|4876->2697|4899->2711|4939->2728|4981->2733|5005->2747|5046->2765|5092->2776|5129->2804|5169->2806|5236->2837|5256->2848|5375->2936|5393->2944|5425->2953|5542->3039|5591->3057|5845->3275|5867->3288|5911->3310|6144->3507|6166->3520|6252->3583|6480->3775|6502->3788|6569->3832|6825->4052|6867->4085|6915->4087|6937->4100|6980->4116|7197->4297|7215->4306|7284->4352|7555->4586|7604->4625|7653->4627|7677->4640|7720->4655|8121->5019|8144->5032|8189->5054|8412->5240|8467->5285|8508->5287|8570->5311|8590->5320|8660->5366|8687->5373|8702->5378|8743->5379|8895->5497|8967->5533|8981->5538|9080->5614|9144->5641|9167->5654|9204->5668|9294->5722|9439->5849|9481->5851|9524->5858|9555->5879|9596->5881|9678->5926|9699->5937|9835->6041|9854->6049|9887->6058|10007->6141|10023->6147|10053->6154|10115->6184|10152->6189|10193->6194|10279->6270|10320->6272|10400->6315|10421->6326|10591->6464|10610->6472|10643->6481|10804->6610|10849->6619|10936->6696|10977->6698|11057->6741|11078->6752|11243->6885|11262->6893|11295->6902|11438->7026|11451->7030|11490->7031|11570->7074|11591->7085|11757->7219|11776->7227|11809->7236|11969->7364
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|39->9|39->9|39->9|39->9|56->26|56->26|56->26|57->27|57->27|57->27|58->28|67->37|67->37|67->37|70->40|70->40|70->40|70->40|70->40|71->41|71->41|71->41|71->41|71->41|74->44|74->44|74->44|76->46|79->49|79->49|79->49|80->50|80->50|80->50|84->54|84->54|84->54|85->55|85->55|85->55|85->55|85->55|86->56|87->57|87->57|87->57|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|89->59|89->59|90->60|92->62|101->71|101->71|101->71|109->79|109->79|109->79|116->86|116->86|116->86|124->94|124->94|124->94|124->94|124->94|129->99|129->99|129->99|140->110|140->110|140->110|140->110|140->110|155->125|155->125|155->125|165->135|165->135|165->135|165->135|165->135|165->135|165->135|165->135|165->135|165->135|172->142|172->142|172->142|173->143|173->143|173->143|176->146|176->146|176->146|177->147|177->147|177->147|179->149|179->149|179->149|179->149|179->149|180->150|180->150|180->150|183->153|184->154|185->155|185->155|185->155|187->157|187->157|187->157|187->157|187->157|191->161|193->163|193->163|193->163|195->165|195->165|195->165|195->165|195->165|199->169|199->169|199->169|201->171|201->171|201->171|201->171|201->171|205->175
                    -- GENERATED --
                */
            