
package views.html.compras.cajaChica

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
object ver extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[CajaChica,utils.pagination.PaginadorFicha,Form[CajaChica],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(caja: CajaChica, paginadorFicha: utils.pagination.PaginadorFicha,cajaForm: Form[CajaChica]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(caja.id.toString))),format.raw/*6.44*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Vista de caja chica")/*8.55*/ {_display_(Seq[Any](format.raw/*8.57*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de caja chica</h1>
			</div>
		
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation">
					  <a id="" role="menuitem" tabindex="-1" 
					  href=""""),_display_(Seq[Any](/*25.15*/controllers/*25.26*/.compras.routes.CajaChicaController.reporteImputacionPreventivaLista(caja.id))),format.raw/*25.103*/("""">Imputacion Preventiva</a></li>
					<li role="presentation">
					  <a id="" role="menuitem" tabindex="-1" 
					  href=""""),_display_(Seq[Any](/*28.15*/controllers/*28.26*/.compras.routes.CajaChicaController.reporteImputacionPreventivaAjustesLista(caja.id))),format.raw/*28.110*/("""">Imputacion Preventiva Ajustes</a></li>  
				  	<li role="presentation">
					  <a id="" role="menuitem" tabindex="-1" 
					  href=""""),_display_(Seq[Any](/*31.15*/controllers/*31.26*/.compras.routes.CajaChicaController.reporteImputacionDefinitiva(caja.id))),format.raw/*31.98*/("""">Imputacion Definitiva</a></li> 
					<li role="presentation">
					  <a id="" role="menuitem" tabindex="-1" 
					  href=""""),_display_(Seq[Any](/*34.15*/controllers/*34.26*/.compras.routes.CajaChicaController.reporteCajaChica(caja.id))),format.raw/*34.87*/("""">Resumen</a></li> 
					  <li role="presentation">
					  <a id="" role="menuitem" tabindex="-1" 
					  href=""""),_display_(Seq[Any](/*37.15*/controllers/*37.26*/.compras.routes.CajaChicaController.reporteCajaChicaOrdenCargo(caja.id))),format.raw/*37.97*/("""">Orden Cargo</a></li>    
				  	
				  </ul>
				</div>
			</div>
		</div>
	</div>
	
"""),_display_(Seq[Any](/*45.2*/views/*45.7*/.html.tags.successError())),format.raw/*45.32*/("""
"""),_display_(Seq[Any](/*46.2*/inputText(cajaForm("id"), 'type -> "hidden",'id -> "cajaId"))),format.raw/*46.62*/("""
<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*49.13*/controllers/*49.24*/.compras.routes.CajaChicaController.crear())),_display_(Seq[Any](/*49.68*/UriTrack/*49.76*/.get("?"))),format.raw/*49.85*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*50.13*/controllers/*50.24*/.compras.routes.CajaChicaController.editar(caja.id))),_display_(Seq[Any](/*50.76*/UriTrack/*50.84*/.get("&"))),format.raw/*50.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*51.13*/controllers/*51.24*/.compras.routes.CajaChicaController.eliminar(caja.id))),_display_(Seq[Any](/*51.78*/UriTrack/*51.86*/.get("&"))),format.raw/*51.95*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*54.13*/UriTrack/*54.21*/.getOnNull(controllers.compras.routes.CajaChicaController.index().absoluteURL()))),format.raw/*54.101*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
		"""),_display_(Seq[Any](/*56.4*/if(paginadorFicha.getLista().size() > 1)/*56.44*/{_display_(Seq[Any](format.raw/*56.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*59.5*/if(paginadorFicha.hasPrev())/*59.33*/ {_display_(Seq[Any](format.raw/*59.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*60.29*/controllers/*60.40*/.compras.routes.CajaChicaController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*60.110*/UriTrack/*60.118*/.get("&"))),format.raw/*60.127*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*61.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*62.79*/paginadorFicha/*62.93*/.posicionActual())),format.raw/*62.110*/(""" de """),_display_(Seq[Any](/*62.115*/paginadorFicha/*62.129*/.getLista().size())),format.raw/*62.147*/("""</p>
			"""),_display_(Seq[Any](/*63.5*/if(paginadorFicha.hasNext())/*63.33*/ {_display_(Seq[Any](format.raw/*63.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*64.29*/controllers/*64.40*/.compras.routes.CajaChicaController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*64.110*/UriTrack/*64.118*/.get("&"))),format.raw/*64.127*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*65.5*/("""  
		</div>
		""")))})),format.raw/*67.4*/("""
		
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*74.49*/caja/*74.53*/.nombre)),format.raw/*74.60*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*78.49*/caja/*78.53*/.referencia)),format.raw/*78.64*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*82.49*/utils/*82.54*/.DateUtils.formatDate(caja.fecha))),format.raw/*82.87*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Monto límite</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*86.49*/utils/*86.54*/.NumberUtils.moneda(caja.monto_limite))),format.raw/*86.92*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Cheque</label>
			<p class="form-control-static form-control" id="inputNumeroCheque">"""),_display_(Seq[Any](/*90.72*/caja/*90.76*/.numero_cheque)),format.raw/*90.90*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Monto Cheque</label>
			<p class="form-control-static form-control" id="inputNumeroCheque">"""),_display_(Seq[Any](/*94.72*/if(caja.monto_cheque != null)/*94.101*/{_display_(Seq[Any](_display_(Seq[Any](/*94.103*/utils/*94.108*/.NumberUtils.moneda(caja.monto_cheque)))))})),format.raw/*94.147*/("""</p>
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*100.49*/caja/*100.53*/.deposito.nombre)),format.raw/*100.69*/("""</p>
		</div>
		<div class="col-sm-2">
			<label>Expediente</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*104.49*/caja/*104.53*/.expediente.getExpedienteEjercicio())),format.raw/*104.89*/("""</p>
		</div>
		<div class="col-sm-2">
			<label>Orden de pago N° </label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*108.49*/if(caja.ordenPago != null)/*108.75*/{_display_(Seq[Any](_display_(Seq[Any](/*108.77*/caja/*108.81*/.ordenPago.getNombreCompleto()))))})),format.raw/*108.112*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Cuenta propia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*112.49*/caja/*112.53*/.cuentaPropia.numero)),format.raw/*112.73*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Orden Cargo</label>
			<p class="form-control-static form-control" id="inputNumeroCheque">"""),_display_(Seq[Any](/*116.72*/if(caja.orden_cargo != null)/*116.100*/{_display_(Seq[Any](_display_(Seq[Any](/*116.102*/caja/*116.106*/.orden_cargo))))})),format.raw/*116.119*/("""</p>
		</div>
	</div>
	

	
	
	"""),_display_(Seq[Any](/*123.3*/views/*123.8*/.html.compras.cajaChica.tabsMovimientos(false, caja))),format.raw/*123.60*/("""	
	
	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*126.26*/caja/*126.30*/.estado.nombre)),format.raw/*126.44*/("""</b></h4>
	<h4>Total: 	<b>"""),_display_(Seq[Any](/*127.18*/utils/*127.23*/.NumberUtils.moneda(caja.getTotal()))),format.raw/*127.59*/("""</b></h4>
	<h4>Total Disponible: 	<b>"""),_display_(Seq[Any](/*128.29*/utils/*128.34*/.NumberUtils.moneda(caja.getTotalDisponible()))),format.raw/*128.80*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*130.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(caja.estado.orden, models.Estado.TIPO_CAJA_CHICA)) yield /*130.111*/ {_display_(Seq[Any](format.raw/*130.113*/("""	
			"""),_display_(Seq[Any](/*131.5*/if(estado.orden <= 5)/*131.26*/ {_display_(Seq[Any](format.raw/*131.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*133.16*/controllers/*133.27*/.compras.routes.CajaChicaController.cambiarEstado(caja.id, estado.id.toLong))),_display_(Seq[Any](/*133.104*/UriTrack/*133.112*/.get("&"))),format.raw/*133.121*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*134.56*/estado/*134.62*/.nombre)),format.raw/*134.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*138.5*/("""
		""")))})),format.raw/*139.4*/("""
		"""),_display_(Seq[Any](/*140.4*/if(caja.estado.id == models.Estado.CAJA_CHICA_CANCELADA)/*140.60*/ {_display_(Seq[Any](format.raw/*140.62*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*142.15*/controllers/*142.26*/.compras.routes.CajaChicaController.cambiarEstado(caja.id, models.Estado.CAJA_CHICA_BORRADOR))),_display_(Seq[Any](/*142.120*/UriTrack/*142.128*/.get("&"))),format.raw/*142.137*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*146.4*/else/*146.8*/{_display_(Seq[Any](format.raw/*146.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*148.15*/controllers/*148.26*/.compras.routes.CajaChicaController.cambiarEstado(caja.id, models.Estado.CAJA_CHICA_CANCELADA))),_display_(Seq[Any](/*148.121*/UriTrack/*148.129*/.get("&"))),format.raw/*148.138*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Caja
				</a>
			</div>
		""")))})),format.raw/*152.4*/("""
	</div>
	
	
""")))})),format.raw/*156.2*/("""


"""))}
    }
    
    def render(caja:CajaChica,paginadorFicha:utils.pagination.PaginadorFicha,cajaForm:Form[CajaChica]): play.api.templates.HtmlFormat.Appendable = apply(caja,paginadorFicha,cajaForm)
    
    def f:((CajaChica,utils.pagination.PaginadorFicha,Form[CajaChica]) => play.api.templates.HtmlFormat.Appendable) = (caja,paginadorFicha,cajaForm) => apply(caja,paginadorFicha,cajaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/ver.scala.html
                    HASH: dd37ed56e7fc6262f1ab21a6ce3f64a64ce2dcc4
                    MATRIX: 841->1|1053->131|1085->155|1159->93|1188->199|1228->205|1250->219|1299->247|1338->252|1350->257|1406->305|1445->307|2082->908|2102->919|2202->996|2365->1123|2385->1134|2492->1218|2667->1357|2687->1368|2781->1440|2945->1568|2965->1579|3048->1640|3200->1756|3220->1767|3313->1838|3444->1934|3457->1939|3504->1964|3542->1967|3624->2027|3732->2099|3752->2110|3826->2154|3843->2162|3874->2171|4006->2267|4026->2278|4108->2330|4125->2338|4156->2347|4284->2439|4304->2450|4388->2504|4405->2512|4436->2521|4636->2685|4653->2693|4756->2773|4870->2852|4919->2892|4958->2893|5028->2928|5065->2956|5105->2958|5171->2988|5191->2999|5292->3069|5310->3077|5342->3086|5457->3170|5573->3250|5596->3264|5636->3281|5678->3286|5702->3300|5743->3318|5788->3328|5825->3356|5865->3358|5931->3388|5951->3399|6052->3469|6070->3477|6102->3486|6218->3571|6266->3588|6467->3753|6480->3757|6509->3764|6687->3906|6700->3910|6733->3921|6906->4058|6920->4063|6975->4096|7155->4240|7169->4245|7229->4283|7429->4447|7442->4451|7478->4465|7681->4632|7720->4661|7769->4663|7784->4668|7850->4707|8077->4897|8091->4901|8130->4917|8288->5038|8302->5042|8361->5078|8526->5206|8562->5232|8611->5234|8625->5238|8684->5269|8866->5414|8880->5418|8923->5438|9126->5604|9165->5632|9215->5634|9230->5638|9271->5651|9345->5689|9359->5694|9434->5746|9505->5780|9519->5784|9556->5798|9621->5826|9636->5831|9695->5867|9771->5906|9786->5911|9855->5957|9943->6009|10068->6116|10110->6118|10153->6125|10184->6146|10225->6148|10307->6193|10328->6204|10437->6281|10456->6289|10489->6298|10609->6381|10625->6387|10655->6394|10722->6429|10759->6434|10800->6439|10866->6495|10907->6497|10987->6540|11008->6551|11134->6645|11153->6653|11186->6662|11329->6786|11342->6790|11381->6791|11461->6834|11482->6845|11609->6940|11628->6948|11661->6957|11812->7076|11862->7094
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|37->8|37->8|37->8|37->8|54->25|54->25|54->25|57->28|57->28|57->28|60->31|60->31|60->31|63->34|63->34|63->34|66->37|66->37|66->37|74->45|74->45|74->45|75->46|75->46|78->49|78->49|78->49|78->49|78->49|79->50|79->50|79->50|79->50|79->50|80->51|80->51|80->51|80->51|80->51|83->54|83->54|83->54|85->56|85->56|85->56|88->59|88->59|88->59|89->60|89->60|89->60|89->60|89->60|90->61|91->62|91->62|91->62|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|93->64|93->64|94->65|96->67|103->74|103->74|103->74|107->78|107->78|107->78|111->82|111->82|111->82|115->86|115->86|115->86|119->90|119->90|119->90|123->94|123->94|123->94|123->94|123->94|129->100|129->100|129->100|133->104|133->104|133->104|137->108|137->108|137->108|137->108|137->108|141->112|141->112|141->112|145->116|145->116|145->116|145->116|145->116|152->123|152->123|152->123|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|159->130|159->130|159->130|160->131|160->131|160->131|162->133|162->133|162->133|162->133|162->133|163->134|163->134|163->134|167->138|168->139|169->140|169->140|169->140|171->142|171->142|171->142|171->142|171->142|175->146|175->146|175->146|177->148|177->148|177->148|177->148|177->148|181->152|185->156
                    -- GENERATED --
                */
            