
package views.html.compras.ordenes.acciones

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
object resultadoOrdenSegunCuadroSugerenia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/if(flash.containsKey("success"))/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*2.80*/flash/*2.85*/.get("success"))),format.raw/*2.100*/("""</div>
""")))})),format.raw/*3.2*/("""
"""),_display_(Seq[Any](/*4.2*/if(flash.containsKey("error"))/*4.32*/ {_display_(Seq[Any](format.raw/*4.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*5.83*/flash/*5.88*/.get("error"))),format.raw/*5.101*/("""</div>
""")))})),format.raw/*6.2*/(""" 

"""),_display_(Seq[Any](/*8.2*/flash()/*8.9*/.clear())))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/acciones/resultadoOrdenSegunCuadroSugerenia.scala.html
                    HASH: 2ad1914b4db9e02171516ad18093f761dd8ee5b8
                    MATRIX: 918->1|958->33|997->35|1113->116|1126->121|1163->136|1202->145|1239->148|1277->178|1316->180|1435->264|1448->269|1483->282|1522->291|1562->297|1576->304
                    LINES: 29->1|29->1|29->1|30->2|30->2|30->2|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|36->8|36->8
                    -- GENERATED --
                */
            