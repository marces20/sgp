
package views.html

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
object sinPermiso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(urlReferer: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/main("Acceso denegado")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
<style>
	body """),format.raw/*5.7*/("""{"""),format.raw/*5.8*/("""background: rgb(242, 222, 222)"""),format.raw/*5.38*/("""}"""),format.raw/*5.39*/("""
</style> 
    
<div class="">
	<p class="alert alert-danger" style="width: 450px; text-align: center; margin-left: auto ; margin-right: auto; margin-top: 10%; padding: 30px">
		<i class="glyphicon glyphicon-warning-sign" style="font-size: 30px;"></i><br />
		No tiene permiso para realizar esta acción.<br />
		<a href=""""),_display_(Seq[Any](/*12.13*/urlReferer)),format.raw/*12.23*/("""">Volver a la página previa</a>
	</p>
</div>	
			 
		
""")))})))}
    }
    
    def render(urlReferer:String): play.api.templates.HtmlFormat.Appendable = apply(urlReferer)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (urlReferer) => apply(urlReferer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:27 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/sinPermiso.scala.html
                    HASH: 94d25e1d2d34a7d6020e4c860455ab98592b7d17
                    MATRIX: 779->1|893->21|932->26|963->49|1002->51|1045->68|1072->69|1129->99|1157->100|1522->429|1554->439
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|33->5|40->12|40->12
                    -- GENERATED --
                */
            