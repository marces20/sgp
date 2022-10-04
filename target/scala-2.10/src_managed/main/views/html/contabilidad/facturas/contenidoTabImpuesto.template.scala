
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
object contenidoTabImpuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(facturaForm.field("id").value == null || facturaForm.field("id").value == "")/*4.82*/{_display_(Seq[Any](format.raw/*4.83*/("""
	<!--<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar impuestos primero debe dar de alta la factura</p>-->
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.contabilidad.routes.FacturasLineasImpuestosController.index(facturaForm.field("id").value.toLong, formularioCarga))),format.raw/*9.138*/("""', function(data)"""),format.raw/*9.155*/("""{"""),format.raw/*9.156*/("""
				$('#listaLineaImpuestos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaImpuestos">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabImpuesto.scala.html
                    HASH: 49b5c2cbea79214cf6648e0e4cbe8fda6f6ef7c2
                    MATRIX: 834->1|1027->78|1054->102|1090->104|1178->184|1216->185|1354->307|1365->312|1402->313|1456->340|1484->341|1531->353|1550->364|1687->479|1732->496|1761->497|1843->552|1871->553|1902->557|1930->558|1976->573
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            