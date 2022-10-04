
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
object contenidoTabNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.recupero.RecuperoFactura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, recuperoFacturaForm: Form[models.recupero.RecuperoFactura] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.95*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(recuperoFacturaForm.field("id").value == null || recuperoFacturaForm.field("id").value == "")/*4.98*/{_display_(Seq[Any](format.raw/*4.99*/("""
	<p>Para cargar nota de creditos primero debe dar de alta la factura</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.recupero.routes.RecuperoNotasCreditosController.index(recuperoFacturaForm.field("id").value.toLong, formularioCarga))),format.raw/*9.139*/("""', function(data)"""),format.raw/*9.156*/("""{"""),format.raw/*9.157*/("""
			$('#listaLineaNotasCreditos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaNotasCreditos">

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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/contenidoTabNotaCredito.scala.html
                    HASH: 2e2d12a73144341415a4ecc96846a93fe875644d
                    MATRIX: 856->1|1066->94|1094->120|1131->123|1235->219|1273->220|1367->298|1378->303|1415->304|1470->332|1498->333|1545->345|1564->356|1703->473|1748->490|1777->491|1863->550|1891->551|1922->555|1950->556|1998->573
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            