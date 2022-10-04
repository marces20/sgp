
package views.html.dashboard.autorizados

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
object contenidoTabLineas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Autorizado],Autorizado,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, autorizadoForm: Form[Autorizado] = null,autorizado:Autorizado= null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.97*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/if(autorizado == null)/*5.24*/{_display_(Seq[Any](format.raw/*5.25*/("""
	<p>Para cargar autorizado primero debe dar de alta el Autorizado</p>
""")))}/*7.3*/else/*7.8*/{_display_(Seq[Any](format.raw/*7.9*/("""
	<script>
		$( function ()"""),format.raw/*9.17*/("""{"""),format.raw/*9.18*/("""
			$.get('"""),_display_(Seq[Any](/*10.12*/controllers/*10.23*/.dashboard.routes.AutorizadoLineasController.index(autorizado.id, formularioCarga))),format.raw/*10.105*/("""', function(data)"""),format.raw/*10.122*/("""{"""),format.raw/*10.123*/("""
				$('#listaLineaAutorizados').parent().html(data);
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""")
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>
""")))})),format.raw/*15.2*/("""

<div id="listaLineaAutorizados">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,autorizadoForm:Form[Autorizado],autorizado:Autorizado): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,autorizadoForm,autorizado)
    
    def f:((Boolean,Form[Autorizado],Autorizado) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,autorizadoForm,autorizado) => apply(formularioCarga,autorizadoForm,autorizado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/contenidoTabLineas.scala.html
                    HASH: 9f2a794c7832fd3c20aa83488d82a46e9e21cb53
                    MATRIX: 838->1|1049->96|1077->121|1113->123|1143->145|1181->146|1270->219|1281->224|1318->225|1372->252|1400->253|1448->265|1468->276|1573->358|1619->375|1649->376|1733->433|1761->434|1792->438|1820->439|1866->454
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|43->15
                    -- GENERATED --
                */
            