
package views.html.contabilidad.pagos

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
object contenidoTabPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, pago: Pago = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(pago == null)/*4.18*/{_display_(Seq[Any](format.raw/*4.19*/("""
	<p>Para cargar pago primero debe dar de alta el Pago</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""

	<script>
		$( function ()"""),format.raw/*9.17*/("""{"""),format.raw/*9.18*/("""
			$.get('"""),_display_(Seq[Any](/*10.12*/controllers/*10.23*/.contabilidad.routes.PagosLineasController.index(pago.id, formularioCarga))),format.raw/*10.97*/("""', function(data)"""),format.raw/*10.114*/("""{"""),format.raw/*10.115*/("""
				$('#listaLineaPagos').parent().html(data);
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""")
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>
""")))})),format.raw/*15.2*/("""

<div id="listaLineaPagos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,pago)
    
    def f:((Boolean,Pago) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,pago) => apply(formularioCarga,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/contenidoTabPago.scala.html
                    HASH: 2bc9fd815a11ba7558632d00f40dc5e9b5958a49
                    MATRIX: 810->1|972->46|1000->72|1037->75|1061->91|1099->92|1178->155|1189->160|1226->161|1284->192|1312->193|1361->206|1381->217|1477->291|1523->308|1553->309|1633->362|1661->363|1693->368|1721->369|1769->386
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|43->15
                    -- GENERATED --
                */
            