
package views.html.patrimonio.actaRecepcion

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
object contenidoTabActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaId: Long = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.23*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(actaId == null)/*4.20*/{_display_(Seq[Any](format.raw/*4.21*/("""
	<p>No hay movimientos</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.patrimonio.routes.ActasMovimientosController.index(actaId))),format.raw/*9.81*/("""', function(data)"""),format.raw/*9.98*/("""{"""),format.raw/*9.99*/("""
			$('#listaLineaActasMovimientos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaActasMovimientos">

</div>
"""))}
    }
    
    def render(actaId:Long): play.api.templates.HtmlFormat.Appendable = apply(actaId)
    
    def f:((Long) => play.api.templates.HtmlFormat.Appendable) = (actaId) => apply(actaId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/contenidoTabActaMovimiento.scala.html
                    HASH: b758ead1437f04411e1d99eb1cb2ee988c3e84b4
                    MATRIX: 818->1|955->22|982->46|1018->48|1044->66|1082->67|1128->97|1139->102|1176->103|1229->129|1257->130|1303->141|1322->152|1402->211|1446->228|1474->229|1561->289|1589->290|1619->293|1647->294|1693->309
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            