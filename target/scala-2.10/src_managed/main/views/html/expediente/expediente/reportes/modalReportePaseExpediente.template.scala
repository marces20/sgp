
package views.html.expediente.expediente.reportes

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
object modalReportePaseExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.tags.successError())),format.raw/*3.32*/("""

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> 
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*9.93*/("""">
	    	Descargar archivo de pase de expedientes
	    	</a>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/reportes/modalReportePaseExpediente.scala.html
                    HASH: da63cfd96872ec392efd24e27d9a0e0a6fd03a94
                    MATRIX: 826->1|940->21|977->24|989->29|1035->54|1072->57|1086->64|1125->66|1287->193|1306->204|1392->269|1502->348|1540->351|1555->358
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|37->9|37->9|37->9|42->14|44->16|44->16
                    -- GENERATED --
                */
            