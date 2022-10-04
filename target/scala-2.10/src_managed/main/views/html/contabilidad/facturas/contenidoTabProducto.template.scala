
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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.63*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(facturaForm.field("id").value == null || facturaForm.field("id").value == "")/*4.82*/{_display_(Seq[Any](format.raw/*4.83*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar productos primero debe dar de alta la factura</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.contabilidad.routes.FacturasLineasController.index(facturaForm.field("id").value.toLong, formularioCarga))),format.raw/*9.129*/("""', function(data)"""),format.raw/*9.146*/("""{"""),format.raw/*9.147*/("""
				$('#listaLineaProductos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm)
    
    def f:((Boolean,Form[Factura]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm) => apply(formularioCarga,facturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabProducto.scala.html
                    HASH: f2cc7ad2a15266a2307cbf01194215ea754d5d2f
                    MATRIX: 826->1|1004->62|1032->88|1069->91|1157->171|1195->172|1328->289|1339->294|1376->295|1432->324|1460->325|1508->338|1527->349|1655->455|1700->472|1729->473|1813->530|1841->531|1873->536|1901->537|1949->554
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            