
package views.html.compras.pedidosFondos

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
object verPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[PedidoFondo],PedidoFondo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pedidoForm: Form[PedidoFondo], pedido: PedidoFondo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.compras.mainCompras("Vista de Pedidos")/*7.52*/ {_display_(Seq[Any](format.raw/*7.54*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de Pedidos</h1>
			</div>
			
		</div>
	</div>
	
"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.tags.successError())),format.raw/*17.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-10">
		<a href=""""),_display_(Seq[Any](/*21.13*/controllers/*21.24*/.compras.routes.PedidosFondosController.crear())),_display_(Seq[Any](/*21.72*/UriTrack/*21.80*/.get("?"))),format.raw/*21.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*22.13*/controllers/*22.24*/.compras.routes.PedidosFondosController.editar(pedido.id))),_display_(Seq[Any](/*22.82*/UriTrack/*22.90*/.get("&"))),format.raw/*22.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*23.13*/controllers/*23.24*/.compras.routes.PedidosFondosController.eliminar(pedido.id))),_display_(Seq[Any](/*23.84*/UriTrack/*23.92*/.get("&"))),format.raw/*23.101*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*26.13*/UriTrack/*26.21*/.getOnNull(controllers.compras.routes.PedidosFondosController.index().absoluteURL()))),format.raw/*26.105*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">ID</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*32.49*/pedidoForm("id")/*32.65*/.value)),format.raw/*32.71*/("""</p>
		</div> 
		<div class="col-sm-2">
			<label class="control-label">Fecha pedido</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*36.49*/pedidoForm("fecha_pedido")/*36.75*/.value)),format.raw/*36.81*/("""</p>
		</div> 
		<div class="col-sm-1">
			<div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*42.7*/checkbox(pedidoForm("profe"), 'disabled -> "disabled"))),format.raw/*42.61*/("""
				</label>
			</div>
		</div>
	</div>
	<div class="row">
		
	</div>	
	
	"""),_display_(Seq[Any](/*51.3*/views/*51.8*/.html.compras.pedidosFondos.tabsPedidoFondo(false, pedidoForm))),format.raw/*51.70*/("""
""")))})),format.raw/*52.2*/("""


"""))}
    }
    
    def render(pedidoForm:Form[PedidoFondo],pedido:PedidoFondo): play.api.templates.HtmlFormat.Appendable = apply(pedidoForm,pedido)
    
    def f:((Form[PedidoFondo],PedidoFondo) => play.api.templates.HtmlFormat.Appendable) = (pedidoForm,pedido) => apply(pedidoForm,pedido)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/verPedidoFondo.scala.html
                    HASH: 601ddb75341af7b6030011183d7ed743437ba152
                    MATRIX: 828->1|1000->91|1032->115|1106->53|1135->159|1177->167|1189->172|1242->217|1281->219|1464->367|1477->372|1524->397|1635->472|1655->483|1733->531|1750->539|1781->548|1913->644|1933->655|2021->713|2038->721|2069->730|2197->822|2217->833|2307->893|2324->901|2356->910|2556->1074|2573->1082|2680->1166|2943->1393|2968->1409|2996->1415|3177->1560|3212->1586|3240->1592|3399->1716|3475->1770|3595->1855|3608->1860|3692->1922|3726->1925
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|46->17|46->17|46->17|50->21|50->21|50->21|50->21|50->21|51->22|51->22|51->22|51->22|51->22|52->23|52->23|52->23|52->23|52->23|55->26|55->26|55->26|61->32|61->32|61->32|65->36|65->36|65->36|71->42|71->42|80->51|80->51|80->51|81->52
                    -- GENERATED --
                */
            