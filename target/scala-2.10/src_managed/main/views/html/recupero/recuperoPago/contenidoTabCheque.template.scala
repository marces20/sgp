
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
object contenidoTabCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.recupero.RecuperoPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, recuperoPagoForm: Form[models.recupero.RecuperoPago] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(recuperoPagoForm.field("id").value == null || recuperoPagoForm.field("id").value == "")/*4.92*/{_display_(Seq[Any](format.raw/*4.93*/("""
	<p>Para cargar cheque primero debe dar de alta el pago</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.recupero.routes.RecuperoChequesController.index(recuperoPagoForm.field("id").value.toLong, formularioCarga))),format.raw/*9.130*/("""', function(data)"""),format.raw/*9.147*/("""{"""),format.raw/*9.148*/("""
			$('#listaLineaCheques').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaCheques">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,recuperoPagoForm:Form[models.recupero.RecuperoPago]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,recuperoPagoForm)
    
    def f:((Boolean,Form[models.recupero.RecuperoPago]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,recuperoPagoForm) => apply(formularioCarga,recuperoPagoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/contenidoTabCheque.scala.html
                    HASH: b9defe98bdd26b33981ba4a1106e0c34f463dc93
                    MATRIX: 845->1|1049->88|1077->114|1114->117|1212->207|1250->208|1331->273|1342->278|1379->279|1434->307|1462->308|1509->320|1528->331|1658->439|1703->456|1732->457|1812->510|1840->511|1871->515|1899->516|1947->533
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            