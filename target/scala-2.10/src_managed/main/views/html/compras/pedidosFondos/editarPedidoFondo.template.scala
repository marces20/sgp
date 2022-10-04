
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
object editarPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[PedidoFondo],PedidoFondo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pedidoForm: Form[PedidoFondo],pedido:PedidoFondo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""

""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.compras.mainCompras("Modificar Pedido", scripts)/*9.61*/ {_display_(Seq[Any](format.raw/*9.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar pedido</h1>
			</div>

			<div class="col-sm-5">
				
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*20.16*/controllers/*20.27*/.compras.routes.PedidosFondosController.crear())),format.raw/*20.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Pedido</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*28.3*/if(flash.containsKey("error"))/*28.33*/ {_display_(Seq[Any](format.raw/*28.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*30.5*/flash/*30.10*/.get("error"))),format.raw/*30.23*/("""
		</div>
	""")))})),format.raw/*32.3*/("""
	

	"""),_display_(Seq[Any](/*35.3*/helper/*35.9*/.form(action = controllers.compras.routes.PedidosFondosController.actualizar(pedido.id))/*35.97*/ {_display_(Seq[Any](format.raw/*35.99*/("""

		"""),_display_(Seq[Any](/*37.4*/views/*37.9*/.html.compras.pedidosFondos.formPedidoFondo(pedidoForm))),format.raw/*37.64*/("""
		"""),_display_(Seq[Any](/*38.4*/views/*38.9*/.html.compras.pedidosFondos.tabsPedidoFondo(true, pedidoForm))),format.raw/*38.70*/("""	
	""")))})),format.raw/*39.3*/("""

""")))})))}
    }
    
    def render(pedidoForm:Form[PedidoFondo],pedido:PedidoFondo): play.api.templates.HtmlFormat.Appendable = apply(pedidoForm,pedido)
    
    def f:((Form[PedidoFondo],PedidoFondo) => play.api.templates.HtmlFormat.Appendable) = (pedidoForm,pedido) => apply(pedidoForm,pedido)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/editarPedidoFondo.scala.html
                    HASH: f6b362d15f1c70557a94a79cf376002519e05ed6
                    MATRIX: 831->1|974->141|988->148|1072->152|1106->70|1138->94|1212->51|1240->138|1268->155|1305->158|1317->163|1379->217|1418->219|1654->419|1674->430|1743->477|1919->618|1958->648|1998->650|2073->690|2087->695|2122->708|2165->720|2206->726|2220->732|2317->820|2357->822|2397->827|2410->832|2487->887|2526->891|2539->896|2622->957|2657->961
                    LINES: 26->1|29->5|29->5|31->5|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|50->20|50->20|50->20|58->28|58->28|58->28|60->30|60->30|60->30|62->32|65->35|65->35|65->35|65->35|67->37|67->37|67->37|68->38|68->38|68->38|69->39
                    -- GENERATED --
                */
            