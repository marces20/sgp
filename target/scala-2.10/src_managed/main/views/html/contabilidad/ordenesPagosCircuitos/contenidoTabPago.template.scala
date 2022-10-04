
package views.html.contabilidad.ordenesPagosCircuitos

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
object contenidoTabPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPagoCircuito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ocForm: Form[OrdenPagoCircuito] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(ocForm.field("id").value == null || ocForm.field("id").value == "")/*4.72*/{_display_(Seq[Any](format.raw/*4.73*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar productos primero debe dar de alta la OP</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.contabilidad.routes.OrdenesPagosCircuitosLineasController.index(ocForm.field("id").value.toLong))),format.raw/*9.120*/("""', function(data)"""),format.raw/*9.137*/("""{"""),format.raw/*9.138*/("""
				$('#listaLineaPagos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaPagos">

</div>
"""))}
    }
    
    def render(ocForm:Form[OrdenPagoCircuito]): play.api.templates.HtmlFormat.Appendable = apply(ocForm)
    
    def f:((Form[OrdenPagoCircuito]) => play.api.templates.HtmlFormat.Appendable) = (ocForm) => apply(ocForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/contenidoTabPago.scala.html
                    HASH: 5bb699fa2b712742bad94ac0a92d77c85f65970b
                    MATRIX: 837->1|994->41|1022->67|1059->70|1137->140|1175->141|1303->253|1314->258|1351->259|1407->288|1435->289|1483->302|1502->313|1621->410|1666->427|1695->428|1775->481|1803->482|1835->487|1863->488|1911->505
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            