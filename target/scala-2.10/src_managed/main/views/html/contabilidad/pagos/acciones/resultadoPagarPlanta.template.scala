
package views.html.contabilidad.pagos.acciones

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
object resultadoPagarPlanta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/if(flash.containsKey("success"))/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*2.82*/flash/*2.87*/.get("success"))),format.raw/*2.102*/("""</div>
""")))})),format.raw/*3.2*/("""	
"""),_display_(Seq[Any](/*4.2*/flash()/*4.9*/.clear())))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/resultadoPagarPlanta.scala.html
                    HASH: 93018344db8bcdc81d7a033d12994841697f7f69
                    MATRIX: 907->1|947->33|986->35|1104->118|1117->123|1154->138|1193->147|1231->151|1245->158
                    LINES: 29->1|29->1|29->1|30->2|30->2|30->2|31->3|32->4|32->4
                    -- GENERATED --
                */
            