
package views.html.contabilidad.balance

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
object modalBejerman extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,url2: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

"""),_display_(Seq[Any](/*3.2*/if(flash.containsKey("error"))/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*4.83*/flash/*4.88*/.get("error"))),format.raw/*4.101*/("""</div>
""")))})),format.raw/*5.2*/("""

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("success"))/*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*8.82*/flash/*8.87*/.get("success"))),format.raw/*8.102*/("""</div>
""")))})),format.raw/*9.2*/("""


"""),_display_(Seq[Any](/*12.2*/if(url)/*12.9*/ {_display_(Seq[Any](format.raw/*12.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*15.58*/controllers/*15.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*15.134*/("""">
	    	Descargar archivo  USUARIO1.IMP
	    	</a>
		</div>
	</div>
""")))})),format.raw/*20.2*/("""
"""),_display_(Seq[Any](/*21.2*/if(url2)/*21.10*/ {_display_(Seq[Any](format.raw/*21.12*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*24.58*/controllers/*24.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url2))),format.raw/*24.135*/("""">
	    	Descargar archivo  USUARIO2.IMP
	    	</a>
		</div>
	</div>
""")))})),format.raw/*29.2*/("""

"""),_display_(Seq[Any](/*31.2*/flash()/*31.9*/.clear())))}
    }
    
    def render(url:String,url2:String): play.api.templates.HtmlFormat.Appendable = apply(url,url2)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (url,url2) => apply(url,url2)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/modalBejerman.scala.html
                    HASH: 2698d5417af35fb58705ba53537f95938b0f3fc4
                    MATRIX: 810->1|944->41|983->46|1021->76|1060->78|1179->162|1192->167|1227->180|1266->189|1305->194|1345->226|1384->228|1502->311|1515->316|1552->331|1591->340|1633->347|1648->354|1688->356|1847->479|1867->490|1955->555|2061->630|2099->633|2116->641|2156->643|2315->766|2335->777|2424->843|2530->918|2570->923|2585->930
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|40->12|40->12|40->12|43->15|43->15|43->15|48->20|49->21|49->21|49->21|52->24|52->24|52->24|57->29|59->31|59->31
                    -- GENERATED --
                */
            