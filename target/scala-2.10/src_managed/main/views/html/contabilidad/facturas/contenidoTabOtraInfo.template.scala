
package views.html.contabilidad.facturas

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
object contenidoTabOtraInfo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.63*/("""
<div class="tab-pane" id="contenedorNotas">
	"""),_display_(Seq[Any](/*3.3*/if(formularioCarga)/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
		<textarea name="comentario" class="form-control" rows="5">"""),_display_(Seq[Any](/*4.62*/facturaForm/*4.73*/.field("comentario").value)),format.raw/*4.99*/("""</textarea>
	""")))}/*5.4*/else/*5.9*/{_display_(Seq[Any](format.raw/*5.10*/("""
		<textarea name="comentario" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*6.82*/facturaForm/*6.93*/.field("comentario").value)),format.raw/*6.119*/("""</textarea>
	""")))})),format.raw/*7.3*/("""
</div>"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm)
    
    def f:((Boolean,Form[Factura]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm) => apply(formularioCarga,facturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabOtraInfo.scala.html
                    HASH: e43cce9023af149b0900429e4b2e769fb1e112a3
                    MATRIX: 826->1|981->62|1062->109|1089->128|1127->129|1224->191|1243->202|1290->228|1321->243|1332->248|1370->249|1487->331|1506->342|1554->368|1598->382
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            