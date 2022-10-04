
package views.html.compras.proveedoresDatosDgr

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
object verLineaDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ProveedorDatoDgr,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  ProveedorDatoDgr, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.proveedoresDatosDgr.lineaDatosDgr(linea, editable))))}
    }
    
    def render(linea:ProveedorDatoDgr,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ProveedorDatoDgr,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresDatosDgr/verLineaDatosDgr.scala.html
                    HASH: 407e5cfe84a9361f2e6662ac31d499c6a72dfdc4
                    MATRIX: 831->1|970->46|1009->51|1021->56
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            