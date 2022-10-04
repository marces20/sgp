
package views.html.recupero.recuperoPago

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
object verRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoPagoForm: Form[models.recupero.RecuperoPago], recuperoPago: models.recupero.RecuperoPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.100*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.recupero.mainRecupero("Vista de pago")/*7.51*/ {_display_(Seq[Any](format.raw/*7.53*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de pago</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.70*/controllers/*21.81*/.recupero.routes.RecuperoReportesController.imprimirRecibo(recuperoPago.id))),format.raw/*21.156*/("""">Imprimir recibo</a></li>
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
	<div class="col-sm-9">
		<!--<a href=""""),_display_(Seq[Any](/*44.17*/controllers/*44.28*/.recupero.routes.RecuperoPagosController.crear())),_display_(Seq[Any](/*44.77*/UriTrack/*44.85*/.get("?"))),format.raw/*44.94*/(""""  class="btn btn-default">
		<i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>-->
		"""),_display_(Seq[Any](/*46.4*/if(recuperoPago.estado_id == models.Estado.RECUPERO_PAGO_BORRADOR)/*46.70*/{_display_(Seq[Any](format.raw/*46.71*/("""
			"""),_display_(Seq[Any](/*47.5*/if(recuperoPago.parcializada == null || recuperoPago.parcializada)/*47.71*/{_display_(Seq[Any](format.raw/*47.72*/("""
				<a href=""""),_display_(Seq[Any](/*48.15*/controllers/*48.26*/.recupero.routes.RecuperoPagosController.crearPagoParcial(recuperoPago.id))),_display_(Seq[Any](/*48.101*/UriTrack/*48.109*/.get("&"))),format.raw/*48.118*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-copyright-mark"></i> Crear Parcial</a>
			""")))})),format.raw/*49.5*/("""
		""")))})),format.raw/*50.4*/("""
		"""),_display_(Seq[Any](/*51.4*/if(recuperoPago.parcializada == null || !recuperoPago.parcializada)/*51.71*/{_display_(Seq[Any](format.raw/*51.72*/("""
			<a href=""""),_display_(Seq[Any](/*52.14*/controllers/*52.25*/.recupero.routes.RecuperoPagosController.editar(recuperoPago.id))),_display_(Seq[Any](/*52.90*/UriTrack/*52.98*/.get("&"))),format.raw/*52.107*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.recupero.routes.RecuperoPagosController.eliminar(recuperoPago.id))),_display_(Seq[Any](/*53.92*/UriTrack/*53.100*/.get("&"))),format.raw/*53.109*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*54.4*/("""
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*57.13*/UriTrack/*57.21*/.getOnNull(controllers.recupero.routes.RecuperoPagosController.index().absoluteURL()))),format.raw/*57.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*63.49*/recuperoPago/*63.61*/.nombre)),format.raw/*63.68*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Numero</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*67.49*/recuperoPago/*67.61*/.numero)),format.raw/*67.68*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*72.6*/recuperoPagoForm("cliente.nombre")/*72.40*/.value)),format.raw/*72.46*/("""
			</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha </label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*77.49*/recuperoPagoForm("fecha")/*77.74*/.value)),format.raw/*77.80*/("""</p>
		</div>
		
	</div>
		
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Planilla</label>
			<p class="form-control-static form-control">
			"""),_display_(Seq[Any](/*86.5*/if(recuperoPago.planilla_id != null)/*86.41*/{_display_(Seq[Any](format.raw/*86.42*/("""
				"""),_display_(Seq[Any](/*87.6*/recuperoPago/*87.18*/.planilla.getRecuperoPlanillaEjercicio())),format.raw/*87.58*/("""
			""")))})),format.raw/*88.5*/("""
			</p>
		</div>	
		<div class="col-sm-4">
			<label class="control-label">Concepto</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*93.49*/recuperoPago/*93.61*/.concepto)),format.raw/*93.70*/("""</p>
		</div>
	
		<div class="col-sm-2">
			<label class="control-label">Importe</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*98.49*/utils/*98.54*/.NumberUtils.moneda(recuperoPago.total))),format.raw/*98.93*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Tipo de pago </label>
			<p class="form-control-static form-control">
			"""),_display_(Seq[Any](/*103.5*/recuperoPagoForm("tipoPago")/*103.33*/.value/*103.39*/ match/*103.45*/ {/*104.10*/case "efectivo" =>/*104.28*/ {_display_(Seq[Any](format.raw/*104.30*/("""Efectivo""")))}/*105.7*/case "cheque" =>/*105.23*/ {_display_(Seq[Any](format.raw/*105.25*/("""Cheque""")))}/*106.7*/case "tarjeta" =>/*106.24*/ {_display_(Seq[Any](format.raw/*106.26*/("""Tarjeta""")))}/*107.7*/case "transferencia" =>/*107.30*/ {_display_(Seq[Any](format.raw/*107.32*/("""Transferencia""")))}/*108.10*/case _ =>/*108.19*/ {}})),format.raw/*109.7*/("""
			
			</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*115.49*/recuperoPago/*115.61*/.recuperoFactura.getNumeroFactura())),format.raw/*115.96*/("""</p>
		</div>
	</div>	
		
		
		
	"""),_display_(Seq[Any](/*121.3*/views/*121.8*/.html.recupero.recuperoPago.tabsRecuperoPago(false, recuperoPagoForm,recuperoPago))),format.raw/*121.90*/("""
	
		
		
	<h4>Estado actual: 	
		"""),_display_(Seq[Any](/*126.4*/if(recuperoPago.parcializada != null && recuperoPago.parcializada)/*126.70*/{_display_(Seq[Any](format.raw/*126.71*/("""
			<b>Parcializada</b>
		""")))}/*128.4*/else/*128.8*/{_display_(Seq[Any](format.raw/*128.9*/("""
			<b>"""),_display_(Seq[Any](/*129.8*/recuperoPago/*129.20*/.estado.nombre)),format.raw/*129.34*/("""</b>
		""")))})),format.raw/*130.4*/("""
	</h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*133.4*/if(recuperoPago.parcializada != null && recuperoPago.parcializada)/*133.70*/{_display_(Seq[Any](format.raw/*133.71*/("""
		
		""")))}/*135.4*/else/*135.8*/{_display_(Seq[Any](format.raw/*135.9*/("""
			"""),_display_(Seq[Any](/*136.5*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(recuperoPago.estado.orden,models.Estado.TIPO_RECUPERO_PAGO)) yield /*136.122*/ {_display_(Seq[Any](format.raw/*136.124*/("""	
				"""),_display_(Seq[Any](/*137.6*/if(estado.orden <= 4)/*137.27*/ {_display_(Seq[Any](format.raw/*137.29*/("""
					<div class="col-sm-3">
						<a href=""""),_display_(Seq[Any](/*139.17*/controllers/*139.28*/.recupero.routes.RecuperoPagosController.cambiarEstado(recuperoPagoForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*139.143*/UriTrack/*139.151*/.get("&"))),format.raw/*139.160*/("""" class="btn btn-default">
							<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*140.57*/estado/*140.63*/.nombre)),format.raw/*140.70*/("""
						</a>
					</div>
					
				""")))})),format.raw/*144.6*/("""
			""")))})),format.raw/*145.5*/("""
			"""),_display_(Seq[Any](/*146.5*/if(recuperoPago.estado.id == models.Estado.RECUPERO_PAGO_CANCELADO)/*146.72*/ {_display_(Seq[Any](format.raw/*146.74*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*148.16*/controllers/*148.27*/.recupero.routes.RecuperoPagosController.cambiarEstado(recuperoPagoForm.field("id").value.toInt, models.Estado.RECUPERO_PAGO_BORRADOR))),_display_(Seq[Any](/*148.162*/UriTrack/*148.170*/.get("&"))),format.raw/*148.179*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
					</a>
				</div>
			""")))}/*152.5*/else/*152.9*/{_display_(Seq[Any](format.raw/*152.10*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*154.16*/controllers/*154.27*/.recupero.routes.RecuperoPagosController.cambiarEstado(recuperoPagoForm.field("id").value.toInt, models.Estado.RECUPERO_PAGO_CANCELADO))),_display_(Seq[Any](/*154.163*/UriTrack/*154.171*/.get("&"))),format.raw/*154.180*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Pago
					</a>
				</div>
			""")))})),format.raw/*158.5*/("""
		""")))})),format.raw/*159.4*/("""
	</div>
""")))})),format.raw/*161.2*/("""








<script>
$( function() """),format.raw/*171.15*/("""{"""),format.raw/*171.16*/("""
	
"""),format.raw/*173.1*/("""}"""),format.raw/*173.2*/(""");
</script>

"""))}
    }
    
    def render(recuperoPagoForm:Form[models.recupero.RecuperoPago],recuperoPago:models.recupero.RecuperoPago): play.api.templates.HtmlFormat.Appendable = apply(recuperoPagoForm,recuperoPago)
    
    def f:((Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago) => play.api.templates.HtmlFormat.Appendable) = (recuperoPagoForm,recuperoPago) => apply(recuperoPagoForm,recuperoPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/verRecuperoPago.scala.html
                    HASH: 057a03bf361dc3d990e9dc7796e58e946f9cf072
                    MATRIX: 863->1|1081->137|1113->161|1188->99|1217->205|1259->213|1271->218|1323->262|1362->264|1963->829|1983->840|2081->915|2603->1402|2616->1407|2663->1432|2777->1510|2797->1521|2876->1570|2893->1578|2924->1587|3053->1681|3128->1747|3167->1748|3208->1754|3283->1820|3322->1821|3374->1837|3394->1848|3500->1923|3518->1931|3550->1940|3682->2041|3718->2046|3758->2051|3834->2118|3873->2119|3924->2134|3944->2145|4039->2210|4056->2218|4088->2227|4217->2320|4237->2331|4334->2398|4352->2406|4384->2415|4536->2536|4620->2584|4637->2592|4745->2677|5012->2908|5033->2920|5062->2927|5236->3065|5257->3077|5286->3084|5507->3270|5550->3304|5578->3310|5757->3453|5791->3478|5819->3484|6036->3666|6081->3702|6120->3703|6162->3710|6183->3722|6245->3762|6282->3768|6464->3914|6485->3926|6516->3935|6694->4077|6708->4082|6769->4121|6955->4271|6993->4299|7009->4305|7025->4311|7037->4324|7065->4342|7106->4344|7134->4361|7160->4377|7201->4379|7227->4394|7254->4411|7295->4413|7322->4429|7355->4452|7396->4454|7430->4479|7449->4488|7475->4499|7664->4651|7686->4663|7744->4698|7820->4738|7834->4743|7939->4825|8014->4864|8090->4930|8130->4931|8178->4960|8191->4964|8230->4965|8275->4974|8297->4986|8334->5000|8375->5009|8462->5060|8538->5126|8578->5127|8606->5136|8619->5140|8658->5141|8700->5147|8835->5264|8877->5266|8921->5274|8952->5295|8993->5297|9077->5344|9098->5355|9245->5470|9264->5478|9297->5487|9418->5571|9434->5577|9464->5584|9535->5623|9573->5629|9615->5635|9692->5702|9733->5704|9815->5749|9836->5760|10003->5895|10022->5903|10055->5912|10202->6040|10215->6044|10255->6045|10337->6090|10358->6101|10526->6237|10545->6245|10578->6254|10733->6377|10770->6382|10814->6394|10885->6436|10915->6437|10948->6442|10977->6443
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|50->21|50->21|50->21|69->40|69->40|69->40|73->44|73->44|73->44|73->44|73->44|75->46|75->46|75->46|76->47|76->47|76->47|77->48|77->48|77->48|77->48|77->48|78->49|79->50|80->51|80->51|80->51|81->52|81->52|81->52|81->52|81->52|82->53|82->53|82->53|82->53|82->53|83->54|86->57|86->57|86->57|92->63|92->63|92->63|96->67|96->67|96->67|101->72|101->72|101->72|106->77|106->77|106->77|115->86|115->86|115->86|116->87|116->87|116->87|117->88|122->93|122->93|122->93|127->98|127->98|127->98|132->103|132->103|132->103|132->103|132->104|132->104|132->104|132->105|132->105|132->105|132->106|132->106|132->106|132->107|132->107|132->107|132->108|132->108|132->109|138->115|138->115|138->115|144->121|144->121|144->121|149->126|149->126|149->126|151->128|151->128|151->128|152->129|152->129|152->129|153->130|156->133|156->133|156->133|158->135|158->135|158->135|159->136|159->136|159->136|160->137|160->137|160->137|162->139|162->139|162->139|162->139|162->139|163->140|163->140|163->140|167->144|168->145|169->146|169->146|169->146|171->148|171->148|171->148|171->148|171->148|175->152|175->152|175->152|177->154|177->154|177->154|177->154|177->154|181->158|182->159|184->161|194->171|194->171|196->173|196->173
                    -- GENERATED --
                */
            