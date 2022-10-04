
package views.html.haberes.liquidacionAcciones

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
object reporteBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*15.58*/controllers/*15.69*/.haberes.routes.LiquidacionAccionesController.descargarBanco(url))),format.raw/*15.134*/("""">Descargar reporte Banco</a>
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
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionAcciones/reporteBanco.scala.html
                    HASH: 286a4cc74c9f1a8d0ea202b008517340eb89806f
                    MATRIX: 809->1|923->21|962->26|1000->56|1039->58|1158->142|1171->147|1206->160|1245->169|1284->174|1324->206|1363->208|1481->291|1494->296|1531->311|1570->320|1612->327|1627->334|1667->336|1826->459|1846->470|1934->535|2016->586|2056->591|2071->598
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|40->12|40->12|40->12|43->15|43->15|43->15|46->18|48->20|48->20
                    -- GENERATED --
                */
            