
package views.html.contabilidad.facturasLineasReintegros

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
object verLineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[FacturaLineaReintegro,Boolean,Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  FacturaLineaReintegro, editable: Boolean,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.68*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.contabilidad.facturasLineasReintegros.lineaReintegro(linea, editable,factura))))}
    }
    
    def render(linea:FacturaLineaReintegro,editable:Boolean,factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,factura)
    
    def f:((FacturaLineaReintegro,Boolean,Factura) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,factura) => apply(linea,editable,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/verLineaReintegro.scala.html
                    HASH: 40d8ece2430ef1dc83949063b819847c1684320f
                    MATRIX: 855->1|1015->67|1054->72|1066->77
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            