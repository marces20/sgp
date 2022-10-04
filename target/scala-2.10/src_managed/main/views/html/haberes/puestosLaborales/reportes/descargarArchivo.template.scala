
package views.html.haberes.puestosLaborales.reportes

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
object descargarArchivo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.tags.successError())),format.raw/*3.32*/("""

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.haberes.routes.PuestosLaboralesReportesController.descargarArchivo(url))),format.raw/*8.141*/("""">Descargar archivo</a>
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
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/reportes/descargarArchivo.scala.html
                    HASH: dee5aeb2495a93331194b0d6e23b34cd6a60b62d
                    MATRIX: 819->1|933->21|972->26|984->31|1030->56|1069->61|1083->68|1122->70|1280->193|1299->204|1393->276|1469->321|1509->326|1524->333
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|36->8|36->8|36->8|39->11|41->13|41->13
                    -- GENERATED --
                */
            