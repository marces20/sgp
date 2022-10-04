
package views.html.compras.lineasCertificacionesCompras

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[CertificacionCompraLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  CertificacionCompraLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasCertificacionesCompras.lineaProducto(linea, true))))}
    }
    
    def render(linea:CertificacionCompraLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((CertificacionCompraLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificacionesCompras/verLineaProducto.scala.html
                    HASH: 68a945dbf5dea16d6c80cb3028544f913b5b3051
                    MATRIX: 840->1|968->35|1007->40|1019->45
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            