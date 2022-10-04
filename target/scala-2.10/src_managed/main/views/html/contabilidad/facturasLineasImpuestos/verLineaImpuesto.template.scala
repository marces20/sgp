
package views.html.contabilidad.facturasLineasImpuestos

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
object verLineaImpuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[FacturaLineaImpuesto,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  FacturaLineaImpuesto, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.51*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.contabilidad.facturasLineasImpuestos.lineaImpuesto(linea, editable))))}
    }
    
    def render(linea:FacturaLineaImpuesto,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((FacturaLineaImpuesto,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasImpuestos/verLineaImpuesto.scala.html
                    HASH: 5fca6cad5630112efa790d9aaacc8b68247eb197
                    MATRIX: 844->1|987->50|1026->55|1038->60
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            