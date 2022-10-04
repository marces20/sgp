
package views.html.patrimonio.remitos

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
object verRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Remito,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remito: Remito, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*5.70*/(""" 

"""),_display_(Seq[Any](/*7.2*/paginadorFicha/*7.16*/.setActual(remito.id.toString))),format.raw/*7.46*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Vista de remito")/*9.57*/ {_display_(Seq[Any](format.raw/*9.59*/("""
	<div class="page-header">
		<div class="row" class="page-header">
			<div class="col-sm-7">
				<h1>Vista de remito</h1>
			</div>
		</div>
	</div>
	
	<ol class="breadcrumb">
		<li><a href=""""),_display_(Seq[Any](/*19.17*/controllers/*19.28*/.patrimonio.routes.OrdenesProvisionController.ver(remito.recepcion.ordenProvision.id))),format.raw/*19.113*/("""">Orden de provisión """),_display_(Seq[Any](/*19.135*/remito/*19.141*/.recepcion.ordenProvision.numero)),format.raw/*19.173*/("""</a></li>
		<li><a href=""""),_display_(Seq[Any](/*20.17*/controllers/*20.28*/.patrimonio.routes.RecepcionesController.ver(remito.recepcion.id))),format.raw/*20.93*/("""">Recepción número """),_display_(Seq[Any](/*20.113*/remito/*20.119*/.recepcion.numero)),format.raw/*20.136*/("""</a></li>
		<li class="active">Remito """),_display_(Seq[Any](/*21.30*/remito/*21.36*/.numero)),format.raw/*21.43*/("""</li>
	</ol>
	
	"""),_display_(Seq[Any](/*24.3*/views/*24.8*/.html.tags.successError())),format.raw/*24.33*/("""

	<div class="row menu-acciones">
		<div class="col-sm-4">
		"""),_display_(Seq[Any](/*28.4*/if(Permiso.check("remitosCrear"))/*28.37*/ {_display_(Seq[Any](format.raw/*28.39*/("""
			<a href=""""),_display_(Seq[Any](/*29.14*/controllers/*29.25*/.patrimonio.routes.RemitosController.editar(remito.id))),_display_(Seq[Any](/*29.80*/UriTrack/*29.88*/.get("&"))),format.raw/*29.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		""")))})),format.raw/*30.4*/("""
		"""),_display_(Seq[Any](/*31.4*/if(Permiso.check("remitosEliminar"))/*31.40*/ {_display_(Seq[Any](format.raw/*31.42*/("""
		<a href=""""),_display_(Seq[Any](/*32.13*/controllers/*32.24*/.patrimonio.routes.RemitosController.eliminar(remito.id))),_display_(Seq[Any](/*32.81*/UriTrack/*32.89*/.get("&"))),format.raw/*32.98*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*33.4*/("""
		</div>
		<div class="col-sm-5">
		"""),_display_(Seq[Any](/*36.4*/if(remito.recepcion.ordenProvision.ordenCompra.tipo_moneda != null)/*36.71*/{_display_(Seq[Any](format.raw/*36.72*/("""
			<span style="color:green;font-weight:bold;font-size: 24px;">MONEDA EXTRANJERA</span>
		""")))})),format.raw/*38.4*/("""
		</div>
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*41.14*/UriTrack/*41.22*/.getOnNull(controllers.patrimonio.routes.RemitosController.index().absoluteURL()))),format.raw/*41.103*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			"""),_display_(Seq[Any](/*42.5*/if(paginadorFicha.getLista().size() > 1)/*42.45*/{_display_(Seq[Any](format.raw/*42.46*/("""
		
              	
			<div class="btn-group">
				"""),_display_(Seq[Any](/*46.6*/if(paginadorFicha.hasPrev())/*46.34*/ {_display_(Seq[Any](format.raw/*46.36*/("""
					<a  role="group" href=""""),_display_(Seq[Any](/*47.30*/controllers/*47.41*/.patrimonio.routes.RemitosController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*47.112*/UriTrack/*47.120*/.get("&"))),format.raw/*47.129*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
				""")))})),format.raw/*48.6*/("""
				<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*49.80*/paginadorFicha/*49.94*/.posicionActual())),format.raw/*49.111*/(""" de """),_display_(Seq[Any](/*49.116*/paginadorFicha/*49.130*/.getLista().size())),format.raw/*49.148*/("""</p>
				"""),_display_(Seq[Any](/*50.6*/if(paginadorFicha.hasNext())/*50.34*/ {_display_(Seq[Any](format.raw/*50.36*/("""
					<a  role="group" href=""""),_display_(Seq[Any](/*51.30*/controllers/*51.41*/.patrimonio.routes.RemitosController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*51.112*/UriTrack/*51.120*/.get("&"))),format.raw/*51.129*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
				""")))})),format.raw/*52.6*/("""  
			</div>
			""")))})),format.raw/*54.5*/("""
		
		</div>
	</div>

	<div class="row">
	
		<div class="col-sm-3">
			<div class="row">
				<div class="col-sm-6">
					<label class="control-label">Número</label>
					<p class="form-control-static form-control">"""),_display_(Seq[Any](/*65.51*/remito/*65.57*/.numero)),format.raw/*65.64*/("""</p>
				</div>
				<div class="col-sm-6">
					<label class="control-label">Número de recpeción</label> 
					<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*69.91*/remito/*69.97*/.recepcion.numero)),format.raw/*69.114*/("""</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="row">
				<div class="col-sm-6">
					<label class="control-label">Fecha</label> 
					<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*78.91*/(DateUtils.formatDate(remito.fecha_remito)))),format.raw/*78.134*/("""</p>
				</div>
				<div class="col-sm-6">
					<label class="control-label">Creado</label> 
					<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*82.91*/(DateUtils.formatDate(remito.create_date)))),format.raw/*82.133*/("""</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Expediente</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*89.89*/remito/*89.95*/.recepcion.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*89.168*/("""</p>
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Responsable</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*94.89*/remito/*94.95*/.create_usuario.nombre)),format.raw/*94.117*/("""</p>
		</div>
		
	</div>

	"""),_display_(Seq[Any](/*99.3*/{ val productos = remito.comprobarInventario(); 
		if(productos.size() > 0) {
			<div class="alert alert-info" style="margin-top: 15px"><h4><i class="glyphicon glyphicon-info-sign"></i> Compruebe el inventario de los siguientes productos:</h4></div>
		}
	})),format.raw/*103.3*/("""

	<hr />

	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a id="listaRemitos" data-href=""""),_display_(Seq[Any](/*108.55*/controllers/*108.66*/.patrimonio.routes.RemitosLineasController.index())),format.raw/*108.116*/("""?remito_id="""),_display_(Seq[Any](/*108.128*/remito/*108.134*/.id)),format.raw/*108.137*/("""" href="#contenedorRemitos" data-toggle="tab">Productos del remito</a></li>
	</ul>


	<div class="tab-content">
		<div id="contenedorRemitos" class="tab-pane active">
		
		</div>
	</div>
	
	<script>
	$( function()"""),format.raw/*119.15*/("""{"""),format.raw/*119.16*/("""
		var urlRemitos = $('#listaRemitos').attr("data-href");
		$.get(urlRemitos, function(data)"""),format.raw/*121.35*/("""{"""),format.raw/*121.36*/("""
			$('#contenedorRemitos').html(data);
		"""),format.raw/*123.3*/("""}"""),format.raw/*123.4*/(""");
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(remito:Remito,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(remito,paginadorFicha)
    
    def f:((Remito,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (remito,paginadorFicha) => apply(remito,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/verRemito.scala.html
                    HASH: e6c989aff219dac2c344f1b4dfe0bd300a0e4d9f
                    MATRIX: 829->1|1037->127|1069->151|1143->66|1172->195|1212->201|1234->215|1285->245|1324->250|1336->255|1394->305|1433->307|1672->510|1692->521|1800->606|1859->628|1875->634|1930->666|1993->693|2013->704|2100->769|2157->789|2173->795|2213->812|2289->852|2304->858|2333->865|2388->885|2401->890|2448->915|2550->982|2592->1015|2632->1017|2683->1032|2703->1043|2788->1098|2805->1106|2836->1115|2950->1198|2990->1203|3035->1239|3075->1241|3125->1255|3145->1266|3232->1323|3249->1331|3280->1340|3432->1461|3508->1502|3584->1569|3623->1570|3748->1664|3835->1715|3852->1723|3956->1804|4067->1880|4116->1920|4155->1921|4246->1977|4283->2005|4323->2007|4390->2038|4410->2049|4512->2120|4530->2128|4562->2137|4678->2222|4795->2303|4818->2317|4858->2334|4900->2339|4924->2353|4965->2371|5011->2382|5048->2410|5088->2412|5155->2443|5175->2454|5277->2525|5295->2533|5327->2542|5444->2628|5494->2647|5756->2873|5771->2879|5800->2886|6036->3086|6051->3092|6091->3109|6386->3368|6452->3411|6675->3598|6740->3640|6986->3850|7001->3856|7097->3929|7321->4117|7336->4123|7381->4145|7449->4178|7731->4438|7879->4549|7900->4560|7974->4610|8024->4622|8041->4628|8068->4631|8321->4855|8351->4856|8474->4950|8504->4951|8576->4995|8605->4996|8638->5001|8667->5002
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|39->9|39->9|39->9|39->9|49->19|49->19|49->19|49->19|49->19|49->19|50->20|50->20|50->20|50->20|50->20|50->20|51->21|51->21|51->21|54->24|54->24|54->24|58->28|58->28|58->28|59->29|59->29|59->29|59->29|59->29|60->30|61->31|61->31|61->31|62->32|62->32|62->32|62->32|62->32|63->33|66->36|66->36|66->36|68->38|71->41|71->41|71->41|72->42|72->42|72->42|76->46|76->46|76->46|77->47|77->47|77->47|77->47|77->47|78->48|79->49|79->49|79->49|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|81->51|81->51|82->52|84->54|95->65|95->65|95->65|99->69|99->69|99->69|108->78|108->78|112->82|112->82|119->89|119->89|119->89|124->94|124->94|124->94|129->99|133->103|138->108|138->108|138->108|138->108|138->108|138->108|149->119|149->119|151->121|151->121|153->123|153->123|154->124|154->124
                    -- GENERATED --
                */
            