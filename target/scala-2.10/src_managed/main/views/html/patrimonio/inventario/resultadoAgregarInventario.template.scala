
package views.html.patrimonio.inventario

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
object resultadoAgregarInventario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/if(flash.containsKey("success"))/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*2.80*/flash/*2.85*/.get("success"))),format.raw/*2.100*/("""</div>
""")))})),format.raw/*3.2*/("""
"""),_display_(Seq[Any](/*4.2*/if(flash.containsKey("error"))/*4.32*/ {_display_(Seq[Any](format.raw/*4.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*5.83*/flash/*5.88*/.get("error"))),format.raw/*5.101*/("""</div>
""")))})),format.raw/*6.2*/(""" 

"""),_display_(Seq[Any](/*8.2*/flash()/*8.9*/.clear)))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/inventario/resultadoAgregarInventario.scala.html
                    HASH: d44876c4817e3c0cbae1ce63708b7c2d3effa5ae
                    MATRIX: 907->1|947->33|986->35|1102->116|1115->121|1152->136|1191->145|1228->148|1266->178|1305->180|1424->264|1437->269|1472->282|1511->291|1551->297|1565->304
                    LINES: 29->1|29->1|29->1|30->2|30->2|30->2|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|36->8|36->8
                    -- GENERATED --
                */
            