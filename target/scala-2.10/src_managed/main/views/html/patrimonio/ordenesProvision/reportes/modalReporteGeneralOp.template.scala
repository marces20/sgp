
package views.html.patrimonio.ordenesProvision.reportes

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
object modalReporteGeneralOp extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
	    	Descargar archivo de general
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
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/reportes/modalReporteGeneralOp.scala.html
                    HASH: 5b84d122c893ad38538f616e57a7bf653dc28988
                    MATRIX: 827->1|941->21|980->26|992->31|1038->56|1077->61|1091->68|1130->70|1296->201|1315->212|1401->277|1504->349|1544->354|1559->361
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|37->9|37->9|37->9|42->14|44->16|44->16
                    -- GENERATED --
                */
            