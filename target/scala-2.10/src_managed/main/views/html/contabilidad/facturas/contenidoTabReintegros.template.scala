
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
object contenidoTabReintegros extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.63*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(facturaForm.field("id").value == null || facturaForm.field("id").value == "")/*4.82*/{_display_(Seq[Any](format.raw/*4.83*/("""
	<!--<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar impuestos primero debe dar de alta la factura</p>-->
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.contabilidad.routes.FacturasLineasReintegrosController.index(facturaForm.field("id").value.toLong, formularioCarga))),format.raw/*9.139*/("""', function(data)"""),format.raw/*9.156*/("""{"""),format.raw/*9.157*/("""
				$('#listaLineaReintegros').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaReintegros">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm)
    
    def f:((Boolean,Form[Factura]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm) => apply(formularioCarga,facturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabReintegros.scala.html
                    HASH: eb79745283dbab782c222f1ea609021818ee8fd0
                    MATRIX: 828->1|1005->62|1032->86|1068->88|1156->168|1194->169|1332->291|1343->296|1380->297|1434->324|1462->325|1509->337|1528->348|1666->464|1711->481|1740->482|1823->538|1851->539|1882->543|1910->544|1956->559
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            