
package views.html.compras.lineasCertificaciones

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[CertificacionLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  CertificacionLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasCertificaciones.lineaProducto(linea, true))))}
    }
    
    def render(linea:CertificacionLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((CertificacionLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificaciones/verLineaProducto.scala.html
                    HASH: 85ed3c1b5636f2cedeb6e2d50ab76b85822a2ca0
                    MATRIX: 827->1|949->29|988->34|1000->39
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            