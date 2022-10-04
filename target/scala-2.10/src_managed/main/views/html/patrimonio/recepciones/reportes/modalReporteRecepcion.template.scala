
package views.html.patrimonio.recepciones.reportes

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
object modalReporteRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

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
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/reportes/modalReporteRecepcion.scala.html
                    HASH: 2bdb7cdeb40c6eb9a83f49f628f9c0413f726b06
                    MATRIX: 829->1|964->42|1003->47|1015->52|1061->77|1100->82|1114->89|1153->91|1319->222|1338->233|1424->298|1527->370|1567->375|1585->384|1625->386|1665->391|1698->402|1732->405|1772->410|1787->417
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|37->9|37->9|37->9|42->14|44->16|44->16|44->16|45->17|45->17|46->18|48->20|48->20
                    -- GENERATED --
                */
            