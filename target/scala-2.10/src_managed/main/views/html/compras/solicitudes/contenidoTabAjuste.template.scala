
package views.html.compras.solicitudes

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
object contenidoTabAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Solicitud],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, solicitudForm: Form[Solicitud] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(solicitudForm.field("id").value == null || solicitudForm.field("id").value == "")/*4.86*/{_display_(Seq[Any](format.raw/*4.87*/("""
	<p>Para cargar ajustes primero debe dar de alta la solicitud</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.compras.routes.AjustesSolicitudesController.index(solicitudForm.field("id").value.toLong, formularioCarga))),format.raw/*9.130*/("""', function(data)"""),format.raw/*9.147*/("""{"""),format.raw/*9.148*/("""
				$('#listaLineaAjustes').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaAjustes">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,solicitudForm:Form[Solicitud]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,solicitudForm)
    
    def f:((Boolean,Form[Solicitud]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,solicitudForm) => apply(formularioCarga,solicitudForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/contenidoTabAjuste.scala.html
                    HASH: 04ba4fee17429d473800a94acf4c6af2ec5f8d5c
                    MATRIX: 824->1|1005->66|1032->90|1068->92|1160->176|1198->177|1283->246|1294->251|1331->252|1385->279|1413->280|1460->292|1479->303|1608->410|1653->427|1682->428|1762->481|1790->482|1821->486|1849->487|1895->502
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            