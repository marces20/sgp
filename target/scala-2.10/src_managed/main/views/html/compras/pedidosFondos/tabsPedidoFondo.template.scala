
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
object tabsPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[PedidoFondo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, pedidoForm: Form[PedidoFondo] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.66*/("""

<ul id="pedidoTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Pedidos</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorPedidos">
		"""),_display_(Seq[Any](/*10.4*/views/*10.9*/.html.compras.pedidosFondos.contenidoTabPedido(formularioCarga, pedidoForm))),format.raw/*10.84*/("""	
	</div>
	 

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,pedidoForm:Form[PedidoFondo]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,pedidoForm)
    
    def f:((Boolean,Form[PedidoFondo]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,pedidoForm) => apply(formularioCarga,pedidoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/tabsPedidoFondo.scala.html
                    HASH: d6746eb963b2be149b23a05019dedd49aadecfe7
                    MATRIX: 825->1|983->65|1267->314|1280->319|1377->394
                    LINES: 26->1|29->1|38->10|38->10|38->10
                    -- GENERATED --
                */
            