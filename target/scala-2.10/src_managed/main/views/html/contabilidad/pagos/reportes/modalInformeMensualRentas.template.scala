
package views.html.contabilidad.pagos.reportes

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
object modalInformeMensualRentas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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


"""),_display_(Seq[Any](/*12.2*/if(url)/*12.9*/ {_display_(Seq[Any](format.raw/*12.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*15.58*/controllers/*15.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*15.134*/("""">Descargar archivo de informe mensual</a>
		</div>
	</div>
""")))})),format.raw/*18.2*/("""

"""),_display_(Seq[Any](/*20.2*/flash()/*20.9*/.clear())))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/reportes/modalInformeMensualRentas.scala.html
                    HASH: 2969af06c90603366cdac9703e7ed7fd1b555c9a
                    MATRIX: 822->1|936->21|975->26|1013->56|1052->58|1171->142|1184->147|1219->160|1258->169|1297->174|1337->206|1376->208|1494->291|1507->296|1544->311|1583->320|1625->327|1640->334|1680->336|1839->459|1859->470|1947->535|2042->599|2082->604|2097->611
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|40->12|40->12|40->12|43->15|43->15|43->15|46->18|48->20|48->20
                    -- GENERATED --
                */
            