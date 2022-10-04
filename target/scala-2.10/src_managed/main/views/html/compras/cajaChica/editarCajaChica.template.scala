
package views.html.compras.cajaChica

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
object editarCajaChica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CajaChica],CajaChica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cajaForm: Form[CajaChica],caja:CajaChica):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/cajaChica.js"))),format.raw/*5.68*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Modificar caja chica", scripts)/*8.65*/ {_display_(Seq[Any](format.raw/*8.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Modificar caja chica</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/if(flash.containsKey("error"))/*18.33*/ {_display_(Seq[Any](format.raw/*18.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*20.5*/flash/*20.10*/.get("error"))),format.raw/*20.23*/("""
		</div>
    """)))})),format.raw/*22.6*/("""
    
    """),_display_(Seq[Any](/*24.6*/helper/*24.12*/.form(action = controllers.compras.routes.CajaChicaController.actualizar(caja.id))/*24.94*/ {_display_(Seq[Any](format.raw/*24.96*/("""		 
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.cajaChica.formCajaChica(cajaForm))),format.raw/*25.56*/(""" 
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.compras.cajaChica.tabsMovimientos(true, caja))),format.raw/*26.60*/("""	

	""")))})),format.raw/*28.3*/("""
	
""")))})))}
    }
    
    def render(cajaForm:Form[CajaChica],caja:CajaChica): play.api.templates.HtmlFormat.Appendable = apply(cajaForm,caja)
    
    def f:((Form[CajaChica],CajaChica) => play.api.templates.HtmlFormat.Appendable) = (cajaForm,caja) => apply(cajaForm,caja)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/editarCajaChica.scala.html
                    HASH: 81ed6a89e79b36f085838fbdef5083d94f241c8c
                    MATRIX: 821->1|957->66|971->73|1055->77|1107->94|1121->100|1188->146|1264->43|1292->63|1320->183|1359->188|1371->193|1437->251|1476->253|1661->403|1700->433|1740->435|1817->477|1831->482|1866->495|1914->512|1962->525|1977->531|2068->613|2108->615|2151->623|2164->628|2233->675|2274->681|2287->686|2360->737|2398->744
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|34->1|35->3|36->6|38->8|38->8|38->8|38->8|48->18|48->18|48->18|50->20|50->20|50->20|52->22|54->24|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|58->28
                    -- GENERATED --
                */
            