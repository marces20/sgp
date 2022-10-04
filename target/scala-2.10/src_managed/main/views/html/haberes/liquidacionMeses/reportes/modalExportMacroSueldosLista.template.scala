
package views.html.haberes.liquidacionMeses.reportes

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
object modalExportMacroSueldosLista extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""

"""),_display_(Seq[Any](/*7.2*/if(url)/*7.9*/ {_display_(Seq[Any](format.raw/*7.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*10.58*/controllers/*10.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*10.134*/("""">Descargar archivo</a>
		</div>
	</div>
""")))})),format.raw/*13.2*/("""
"""),_display_(Seq[Any](/*14.2*/flash()/*14.9*/.clear())),format.raw/*14.17*/("""
"""))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/reportes/modalExportMacroSueldosLista.scala.html
                    HASH: 0f9433495c554f2431ff1ba7468d018d97b696b1
                    MATRIX: 831->1|953->40|985->64|1059->21|1087->108|1125->112|1137->117|1183->142|1220->145|1234->152|1273->154|1429->274|1449->285|1537->350|1610->392|1647->394|1662->401|1692->409
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|41->13|42->14|42->14|42->14
                    -- GENERATED --
                */
            