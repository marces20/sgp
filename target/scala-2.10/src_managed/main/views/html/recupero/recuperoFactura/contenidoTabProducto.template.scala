
package views.html.recupero.recuperoFactura

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.recupero.RecuperoFactura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, recuperoFacturaForm: Form[models.recupero.RecuperoFactura] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.95*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(recuperoFacturaForm.field("id").value == null || recuperoFacturaForm.field("id").value == "")/*4.98*/{_display_(Seq[Any](format.raw/*4.99*/("""
	<p>Para cargar productos primero debe dar de alta la factura</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.recupero.routes.RecuperoFacturaLineasController.index(recuperoFacturaForm.field("id").value.toLong, formularioCarga))),format.raw/*9.139*/("""', function(data)"""),format.raw/*9.156*/("""{"""),format.raw/*9.157*/("""
			$('#listaLineaProductos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,recuperoFacturaForm:Form[models.recupero.RecuperoFactura]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,recuperoFacturaForm)
    
    def f:((Boolean,Form[models.recupero.RecuperoFactura]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,recuperoFacturaForm) => apply(formularioCarga,recuperoFacturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/contenidoTabProducto.scala.html
                    HASH: 03dcc1cee0705b96b5c14dcec7db4fbc3a3d2f81
                    MATRIX: 853->1|1063->94|1091->120|1128->123|1232->219|1270->220|1357->291|1368->296|1405->297|1460->325|1488->326|1535->338|1554->349|1693->466|1738->483|1767->484|1849->539|1877->540|1908->544|1936->545|1984->562
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            