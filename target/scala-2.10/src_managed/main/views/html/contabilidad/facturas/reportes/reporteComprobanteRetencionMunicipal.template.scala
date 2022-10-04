
package views.html.contabilidad.facturas.reportes

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
object reporteComprobanteRetencionMunicipal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
	    	<i class="glyphicon glyphicon-save"></i> 
	    	<a href=""""),_display_(Seq[Any](/*16.17*/controllers/*16.28*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*16.93*/("""">
	    	Descargar archivo de comprobante de retencion de municipal
	    	</a>
		</div>
	</div>
""")))})),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/flash()/*23.9*/.clear())))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/reportes/reporteComprobanteRetencionMunicipal.scala.html
                    HASH: f4b82634ed4a0e434e3952b0059ae3618ec23e19
                    MATRIX: 836->1|950->21|989->26|1027->56|1066->58|1185->142|1198->147|1233->160|1272->169|1311->174|1351->206|1390->208|1508->291|1521->296|1558->311|1597->320|1639->327|1654->334|1694->336|1861->467|1881->478|1968->543|2101->645|2141->650|2156->657
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|40->12|40->12|40->12|44->16|44->16|44->16|49->21|51->23|51->23
                    -- GENERATED --
                */
            