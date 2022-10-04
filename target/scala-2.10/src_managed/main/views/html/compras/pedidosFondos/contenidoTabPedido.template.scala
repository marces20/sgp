
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
object contenidoTabPedido extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[PedidoFondo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, pedidoForm: Form[PedidoFondo] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.66*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(pedidoForm.field("id").value == null || pedidoForm.field("id").value == "")/*4.80*/{_display_(Seq[Any](format.raw/*4.81*/("""
	<p>Para cargar productos primero debe dar de alta el Pedido</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.compras.routes.LineasPedidosFondosController.index(pedidoForm.field("id").value.toLong, formularioCarga))),format.raw/*9.127*/("""', function(data)"""),format.raw/*9.144*/("""{"""),format.raw/*9.145*/("""
			$('#listaLineaPedidos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaPedidos">

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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/contenidoTabPedido.scala.html
                    HASH: c0042dfcacbd35d5eb51c9e2aed6453d566197cd
                    MATRIX: 828->1|1009->65|1037->91|1074->94|1160->172|1198->173|1284->243|1295->248|1332->249|1387->277|1415->278|1462->290|1481->301|1608->406|1653->423|1682->424|1762->477|1790->478|1821->482|1849->483|1897->500
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            