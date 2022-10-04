
package views.html.dashboard.autorizados

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
object verAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Autorizado],Autorizado,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(autorizadoForm: Form[Autorizado], autorizado: Autorizado, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/dashboard/autorizado.js"))),format.raw/*8.71*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.109*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/paginadorFicha/*6.16*/.setActual(autorizado.id.toString))),format.raw/*6.50*/("""
"""),format.raw/*9.2*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Vista de Autorizados",scripts)/*10.68*/ {_display_(Seq[Any](format.raw/*10.70*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de Autorizado</h1>
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
					  	<a role="menuitem" id="reporteAutorizado" href="#" tabindex="-1"					  													     
			    		data-url=""""),_display_(Seq[Any](/*26.21*/controllers/*26.32*/.dashboard.routes.AutorizadosController.reporteAutorizado(autorizado.id))),format.raw/*26.104*/("""">
			    		Reporte Autorizado</a>
			    		
			    	</li>
			    	 <li role="presentation">
					  	<a role="menuitem" id="reporteAutorizadoExcel" href="#" tabindex="-1"					  													     
			    		data-url=""""),_display_(Seq[Any](/*32.21*/controllers/*32.32*/.dashboard.routes.AutorizadosController.reporteAutorizadoExcel(autorizado.id))),format.raw/*32.109*/("""">
			    		Reporte Autorizado Excel</a>
			    		
			    	</li>
			    	 <li role="presentation">
					  	<a role="menuitem" id="reporteAutorizadoExcel" href="#" tabindex="-1"					  													     
			    		data-url=""""),_display_(Seq[Any](/*38.21*/controllers/*38.32*/.dashboard.routes.AutorizadosController.reporteAutorizadoRemitos(autorizado.id))),format.raw/*38.111*/("""">
			    		Reporte Autorizado Remito</a>
			    		
			    	</li>
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
	
"""),_display_(Seq[Any](/*60.2*/views/*60.7*/.html.tags.successError())),format.raw/*60.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*64.13*/controllers/*64.24*/.dashboard.routes.AutorizadosController.crear())),_display_(Seq[Any](/*64.72*/UriTrack/*64.80*/.get("?"))),format.raw/*64.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*65.13*/controllers/*65.24*/.dashboard.routes.AutorizadosController.editar(autorizado.id))),_display_(Seq[Any](/*65.86*/UriTrack/*65.94*/.get("&"))),format.raw/*65.103*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*66.13*/controllers/*66.24*/.dashboard.routes.AutorizadosController.eliminar(autorizado.id))),_display_(Seq[Any](/*66.88*/UriTrack/*66.96*/.get("&"))),format.raw/*66.105*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*69.13*/UriTrack/*69.21*/.getOnNull(controllers.dashboard.routes.AutorizadosController.index().absoluteURL()))),format.raw/*69.105*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
		"""),_display_(Seq[Any](/*71.4*/if(paginadorFicha.getLista().size() > 1)/*71.44*/{_display_(Seq[Any](format.raw/*71.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*74.5*/if(paginadorFicha.hasPrev())/*74.33*/ {_display_(Seq[Any](format.raw/*74.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*75.29*/controllers/*75.40*/.dashboard.routes.AutorizadosController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*75.114*/UriTrack/*75.122*/.get("&"))),format.raw/*75.131*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*76.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*77.79*/paginadorFicha/*77.93*/.posicionActual())),format.raw/*77.110*/(""" de """),_display_(Seq[Any](/*77.115*/paginadorFicha/*77.129*/.getLista().size())),format.raw/*77.147*/("""</p>
			"""),_display_(Seq[Any](/*78.5*/if(paginadorFicha.hasNext())/*78.33*/ {_display_(Seq[Any](format.raw/*78.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*79.29*/controllers/*79.40*/.dashboard.routes.AutorizadosController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*79.114*/UriTrack/*79.122*/.get("&"))),format.raw/*79.131*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*80.5*/("""  
		</div>
		""")))})),format.raw/*82.4*/("""
		
	</div>
</div>
	"""),_display_(Seq[Any](/*86.3*/inputText(autorizadoForm("id"), 'type -> "hidden", 'id -> "idAutorizado"))),format.raw/*86.76*/("""
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*90.49*/autorizado/*90.59*/.nombre)),format.raw/*90.66*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Descripcion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*94.49*/autorizado/*94.59*/.descripcion)),format.raw/*94.71*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*98.49*/autorizadoForm("fecha")/*98.72*/.value)),format.raw/*98.78*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Tipo Cuenta</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*102.49*/if(autorizado.tipoCuenta != null)/*102.82*/{_display_(Seq[Any](_display_(Seq[Any](/*102.84*/autorizado/*102.94*/.tipoCuenta.nombre))))})),format.raw/*102.113*/("""</p> 
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-2">
			<label class="control-label">Cotizacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*108.49*/autorizadoForm("cot_dolar")/*108.76*/.value)),format.raw/*108.82*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Tipo Moneda</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*112.49*/if(autorizado.tipoMoneda != null)/*112.82*/{_display_(Seq[Any](_display_(Seq[Any](/*112.84*/autorizado/*112.94*/.tipoMoneda.nombre))))})),format.raw/*112.113*/("""</p> 
		</div>
	 
		
	</div>
	 
	"""),_display_(Seq[Any](/*118.3*/views/*118.8*/.html.dashboard.autorizados.tabsAutorizados(false, autorizadoForm,autorizado))),format.raw/*118.85*/("""
	
	
	<h4>Total: 	   <b>"""),_display_(Seq[Any](/*121.21*/utils/*121.26*/.NumberUtils.moneda(autorizado.getTotal()))),format.raw/*121.68*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*122.26*/autorizado/*122.36*/.estado.nombre)),format.raw/*122.50*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*124.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(autorizado.estado.orden,models.Estado.TIPO_AUTORIZADO)) yield /*124.116*/ {_display_(Seq[Any](format.raw/*124.118*/("""	
			"""),_display_(Seq[Any](/*125.5*/if(estado.orden <= 3)/*125.26*/ {_display_(Seq[Any](format.raw/*125.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*127.16*/controllers/*127.27*/.dashboard.routes.AutorizadosController.cambiarEstado(autorizadoForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*127.139*/UriTrack/*127.147*/.get("&"))),format.raw/*127.156*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*128.56*/estado/*128.62*/.nombre)),format.raw/*128.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*132.5*/("""
		""")))})),format.raw/*133.4*/("""
		"""),_display_(Seq[Any](/*134.4*/if(autorizado.estado.id == models.Estado.AUTORIZADO_ESTADO_CANCELADO)/*134.73*/ {_display_(Seq[Any](format.raw/*134.75*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*136.15*/controllers/*136.26*/.dashboard.routes.AutorizadosController.cambiarEstado(autorizadoForm.field("id").value.toInt, models.Estado.AUTORIZADO_ESTADO_BORRADOR))),_display_(Seq[Any](/*136.162*/UriTrack/*136.170*/.get("&"))),format.raw/*136.179*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*140.4*/else/*140.8*/{_display_(Seq[Any](format.raw/*140.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*142.15*/controllers/*142.26*/.dashboard.routes.AutorizadosController.cambiarEstado(autorizadoForm.field("id").value.toInt, models.Estado.AUTORIZADO_ESTADO_CANCELADO))),_display_(Seq[Any](/*142.163*/UriTrack/*142.171*/.get("&"))),format.raw/*142.180*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Autorizado
				</a>
			</div>
		""")))})),format.raw/*146.4*/("""
	</div>
""")))})),format.raw/*148.2*/("""


"""))}
    }
    
    def render(autorizadoForm:Form[Autorizado],autorizado:Autorizado,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(autorizadoForm,autorizado,paginadorFicha)
    
    def f:((Form[Autorizado],Autorizado,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (autorizadoForm,autorizado,paginadorFicha) => apply(autorizadoForm,autorizado,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/verAutorizado.scala.html
                    HASH: a489d1b4b14d0ca42cf4ac95e1106954aa5e29d2
                    MATRIX: 857->1|1075->271|1089->278|1173->282|1225->299|1239->305|1309->354|1377->146|1409->170|1484->108|1513->214|1553->220|1575->234|1630->268|1658->391|1696->394|1709->399|1779->460|1819->462|2510->1117|2530->1128|2625->1200|2883->1422|2903->1433|3003->1510|3267->1738|3287->1749|3389->1828|3953->2357|3966->2362|4013->2387|4123->2461|4143->2472|4221->2520|4238->2528|4269->2537|4401->2633|4421->2644|4513->2706|4530->2714|4562->2723|4690->2815|4710->2826|4804->2890|4821->2898|4853->2907|5053->3071|5070->3079|5177->3163|5291->3242|5340->3282|5379->3283|5449->3318|5486->3346|5526->3348|5592->3378|5612->3389|5717->3463|5735->3471|5767->3480|5882->3564|5998->3644|6021->3658|6061->3675|6103->3680|6127->3694|6168->3712|6213->3722|6250->3750|6290->3752|6356->3782|6376->3793|6481->3867|6499->3875|6531->3884|6647->3969|6695->3986|6755->4011|6850->4084|7034->4232|7053->4242|7082->4249|7261->4392|7280->4402|7314->4414|7487->4551|7519->4574|7547->4580|7727->4723|7770->4756|7819->4758|7839->4768|7886->4787|8097->4961|8134->4988|8163->4994|8343->5137|8386->5170|8435->5172|8455->5182|8502->5201|8578->5241|8592->5246|8692->5323|8757->5351|8772->5356|8837->5398|8911->5435|8931->5445|8968->5459|9056->5511|9186->5623|9228->5625|9271->5632|9302->5653|9343->5655|9425->5700|9446->5711|9590->5823|9609->5831|9642->5840|9762->5923|9778->5929|9808->5936|9875->5971|9912->5976|9953->5981|10032->6050|10073->6052|10153->6095|10174->6106|10342->6242|10361->6250|10394->6259|10537->6383|10550->6387|10589->6388|10669->6431|10690->6442|10859->6579|10878->6587|10911->6596|11068->6721|11112->6733
                    LINES: 26->1|31->7|31->7|33->7|34->8|34->8|34->8|35->4|35->4|36->1|37->4|39->6|39->6|39->6|40->9|41->10|41->10|41->10|41->10|57->26|57->26|57->26|63->32|63->32|63->32|69->38|69->38|69->38|91->60|91->60|91->60|95->64|95->64|95->64|95->64|95->64|96->65|96->65|96->65|96->65|96->65|97->66|97->66|97->66|97->66|97->66|100->69|100->69|100->69|102->71|102->71|102->71|105->74|105->74|105->74|106->75|106->75|106->75|106->75|106->75|107->76|108->77|108->77|108->77|108->77|108->77|108->77|109->78|109->78|109->78|110->79|110->79|110->79|110->79|110->79|111->80|113->82|117->86|117->86|121->90|121->90|121->90|125->94|125->94|125->94|129->98|129->98|129->98|133->102|133->102|133->102|133->102|133->102|139->108|139->108|139->108|143->112|143->112|143->112|143->112|143->112|149->118|149->118|149->118|152->121|152->121|152->121|153->122|153->122|153->122|155->124|155->124|155->124|156->125|156->125|156->125|158->127|158->127|158->127|158->127|158->127|159->128|159->128|159->128|163->132|164->133|165->134|165->134|165->134|167->136|167->136|167->136|167->136|167->136|171->140|171->140|171->140|173->142|173->142|173->142|173->142|173->142|177->146|179->148
                    -- GENERATED --
                */
            