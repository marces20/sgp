
package views.html.patrimonio.remitos

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
object modalReporteRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,error: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.43*/("""

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

"""),_display_(Seq[Any](/*16.2*/if(error)/*16.11*/ {_display_(Seq[Any](format.raw/*16.13*/("""
	 """),_display_(Seq[Any](/*17.4*/Html(error))),format.raw/*17.15*/("""
""")))})),format.raw/*18.2*/("""

"""),_display_(Seq[Any](/*20.2*/flash()/*20.9*/.clear())))}
    }
    
    def render(url:String,error:String): play.api.templates.HtmlFormat.Appendable = apply(url,error)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (url,error) => apply(url,error)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/modalReporteRemito.scala.html
                    HASH: 2bdb7cdeb40c6eb9a83f49f628f9c0413f726b06
                    MATRIX: 813->1|948->42|987->47|999->52|1045->77|1084->82|1098->89|1137->91|1303->222|1322->233|1408->298|1511->370|1551->375|1569->384|1609->386|1649->391|1682->402|1716->405|1756->410|1771->417
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|37->9|37->9|37->9|42->14|44->16|44->16|44->16|45->17|45->17|46->18|48->20|48->20
                    -- GENERATED --
                */
            