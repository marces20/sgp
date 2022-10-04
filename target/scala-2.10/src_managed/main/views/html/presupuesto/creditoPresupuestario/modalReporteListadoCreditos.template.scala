
package views.html.presupuesto.creditoPresupuestario

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
object modalReporteListadoCreditos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.tags.successError())),format.raw/*3.32*/("""

"""),_display_(Seq[Any](/*5.2*/if(url == null)/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""

""")))}/*7.2*/else/*7.6*/{_display_(Seq[Any](format.raw/*7.7*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*10.58*/controllers/*10.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*10.134*/("""">
	    	Descargar archivo listado Creditos</a>
		</div>
	</div>
""")))})),format.raw/*14.2*/("""

"""),_display_(Seq[Any](/*16.2*/flash()/*16.9*/.clear())))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/modalReporteListadoCreditos.scala.html
                    HASH: 48edffda1b61b63af035f3e94b5058f7219a3f20
                    MATRIX: 830->1|944->21|981->24|993->29|1039->54|1076->57|1099->72|1138->74|1158->77|1169->81|1206->82|1362->202|1382->213|1470->278|1567->344|1605->347|1620->354
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|42->14|44->16|44->16
                    -- GENERATED --
                */
            