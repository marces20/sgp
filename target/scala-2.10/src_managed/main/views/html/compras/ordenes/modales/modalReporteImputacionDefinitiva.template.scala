
package views.html.compras.ordenes.modales

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
object modalReporteImputacionDefinitiva extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.tags.successError())),format.raw/*3.32*/("""
"""),_display_(Seq[Any](/*4.2*/if(url)/*4.9*/ {_display_(Seq[Any](format.raw/*4.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*7.58*/controllers/*7.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*7.134*/("""">
	    	Descargar archivo</a>
		</div>
	</div>
""")))})),format.raw/*11.2*/("""

"""),_display_(Seq[Any](/*13.2*/flash()/*13.9*/.clear())))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalReporteImputacionDefinitiva.scala.html
                    HASH: 75976c15c1f33f0fe142e629f917db5191344979
                    MATRIX: 825->1|939->21|976->24|988->29|1034->54|1070->56|1084->63|1123->65|1278->185|1297->196|1384->261|1464->310|1502->313|1517->320
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|35->7|35->7|35->7|39->11|41->13|41->13
                    -- GENERATED --
                */
            