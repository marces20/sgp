
package views.html.contabilidad.pagos

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
object crearPagoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Pago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pagoForm: Form[Pago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear pago")/*4.56*/ {_display_(Seq[Any](format.raw/*4.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo pago</h1>
			</div>
			
			 
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*16.3*/views/*16.8*/.html.tags.successError())),format.raw/*16.33*/("""
    
    """),_display_(Seq[Any](/*18.6*/helper/*18.12*/.form(action = controllers.contabilidad.routes.PagosController.guardar())/*18.85*/ {_display_(Seq[Any](format.raw/*18.87*/("""
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.contabilidad.pagos.formPagoProveedor(pagoForm))),format.raw/*19.61*/("""
		<hr>
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.contabilidad.pagos.tabsPago(true,pagoForm,null))),format.raw/*21.62*/("""	
	""")))})),format.raw/*22.3*/("""
""")))})),format.raw/*23.2*/("""	"""))}
    }
    
    def render(pagoForm:Form[Pago]): play.api.templates.HtmlFormat.Appendable = apply(pagoForm)
    
    def f:((Form[Pago]) => play.api.templates.HtmlFormat.Appendable) = (pagoForm) => apply(pagoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/crearPagoProveedor.scala.html
                    HASH: 37e36954439724bef89bd49435fcb88c10bc8046
                    MATRIX: 810->1|942->23|969->41|1005->43|1017->48|1074->97|1113->99|1294->245|1307->250|1354->275|1400->286|1415->292|1497->365|1537->367|1576->371|1589->376|1663->428|1709->439|1722->444|1797->497|1832->501|1865->503
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|44->16|44->16|44->16|46->18|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|50->22|51->23
                    -- GENERATED --
                */
            