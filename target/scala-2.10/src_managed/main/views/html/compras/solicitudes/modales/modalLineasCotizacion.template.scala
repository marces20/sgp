
package views.html.compras.solicitudes.modales

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
object modalLineasCotizacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/if(flash.containsKey("error"))/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*4.83*/flash/*4.88*/.get("error"))),format.raw/*4.101*/("""</div>
""")))})),format.raw/*5.2*/("""

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("success"))/*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*8.82*/flash/*8.87*/.get("success"))),format.raw/*8.102*/("""</div>
""")))})),format.raw/*9.2*/("""

"""),_display_(Seq[Any](/*11.2*/if(url)/*11.9*/ {_display_(Seq[Any](format.raw/*11.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*14.58*/controllers/*14.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*14.134*/("""">Descargar archivo lineas cotizacion</a>
		</div>
	</div>
""")))})),format.raw/*17.2*/("""

"""),_display_(Seq[Any](/*19.2*/flash()/*19.9*/.clear())))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalLineasCotizacion.scala.html
                    HASH: a20646578bde85f1bd4b414b97b580a17da5e815
                    MATRIX: 818->1|932->21|969->24|1007->54|1046->56|1164->139|1177->144|1212->157|1250->165|1287->168|1327->200|1366->202|1483->284|1496->289|1533->304|1571->312|1609->315|1624->322|1664->324|1820->444|1840->455|1928->520|2019->580|2057->583|2072->590
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|42->14|42->14|42->14|45->17|47->19|47->19
                    -- GENERATED --
                */
            