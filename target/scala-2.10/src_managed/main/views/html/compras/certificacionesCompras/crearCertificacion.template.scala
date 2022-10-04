
package views.html.compras.certificacionesCompras

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
object crearCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CertificacionCompra],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[CertificacionCompra],obras:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/certificacionesCompras.js"))),format.raw/*5.81*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Crear Certificacion", scripts)/*8.64*/ {_display_(Seq[Any](format.raw/*8.66*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva Certificacion """),_display_(Seq[Any](/*13.36*/if(obras)/*13.45*/{_display_(Seq[Any](format.raw/*13.46*/("""Obras""")))}/*13.52*/else/*13.56*/{_display_(Seq[Any](format.raw/*13.57*/("""Compras""")))})),format.raw/*13.65*/("""</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(flash.containsKey("error"))/*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*19.5*/flash/*19.10*/.get("error"))),format.raw/*19.23*/("""
		</div>
    """)))})),format.raw/*21.6*/("""
    """),_display_(Seq[Any](/*22.6*/if(obras)/*22.15*/{_display_(Seq[Any](format.raw/*22.16*/("""
	    """),_display_(Seq[Any](/*23.7*/helper/*23.13*/.form(action = controllers.compras.routes.CertificacionesObrasController.guardar())/*23.96*/ {_display_(Seq[Any](format.raw/*23.98*/("""
			"""),_display_(Seq[Any](/*24.5*/views/*24.10*/.html.compras.certificacionesCompras.formCertificacion(certificacionForm))),format.raw/*24.83*/(""" 
			"""),_display_(Seq[Any](/*25.5*/views/*25.10*/.html.compras.certificacionesCompras.tabsCertificacion(true, certificacionForm))),format.raw/*25.89*/("""	
		""")))})),format.raw/*26.4*/("""
	""")))}/*27.3*/else/*27.7*/{_display_(Seq[Any](format.raw/*27.8*/("""
		"""),_display_(Seq[Any](/*28.4*/helper/*28.10*/.form(action = controllers.compras.routes.CertificacionesComprasController.guardar())/*28.95*/ {_display_(Seq[Any](format.raw/*28.97*/("""
			"""),_display_(Seq[Any](/*29.5*/views/*29.10*/.html.compras.certificacionesCompras.formCertificacion(certificacionForm))),format.raw/*29.83*/(""" 
			"""),_display_(Seq[Any](/*30.5*/views/*30.10*/.html.compras.certificacionesCompras.tabsCertificacion(true, certificacionForm))),format.raw/*30.89*/("""	
		""")))})),format.raw/*31.4*/("""
	""")))})),format.raw/*32.3*/("""
""")))})))}
    }
    
    def render(certificacionForm:Form[CertificacionCompra],obras:Boolean): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm,obras)
    
    def f:((Form[CertificacionCompra],Boolean) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm,obras) => apply(certificacionForm,obras)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/crearCertificacion.scala.html
                    HASH: 6e2068c89e98cb4e76dd7c17d6fd565c9243b4b2
                    MATRIX: 845->1|998->81|1012->88|1096->92|1147->108|1161->114|1241->173|1316->61|1343->79|1370->209|1407->212|1419->217|1484->274|1523->276|1669->386|1687->395|1726->396|1751->402|1764->406|1803->407|1843->415|1913->450|1952->480|1992->482|2067->522|2081->527|2116->540|2162->555|2203->561|2221->570|2260->571|2302->578|2317->584|2409->667|2449->669|2489->674|2503->679|2598->752|2639->758|2653->763|2754->842|2790->847|2811->850|2823->854|2861->855|2900->859|2915->865|3009->950|3049->952|3089->957|3103->962|3198->1035|3239->1041|3253->1046|3354->1125|3390->1130|3424->1133
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|43->13|43->13|43->13|43->13|43->13|43->13|43->13|47->17|47->17|47->17|49->19|49->19|49->19|51->21|52->22|52->22|52->22|53->23|53->23|53->23|53->23|54->24|54->24|54->24|55->25|55->25|55->25|56->26|57->27|57->27|57->27|58->28|58->28|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31|62->32
                    -- GENERATED --
                */
            