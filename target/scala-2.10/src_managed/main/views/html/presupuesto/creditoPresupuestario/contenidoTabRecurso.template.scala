
package views.html.presupuesto.creditoPresupuestario

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
object contenidoTabRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,CreditoPresupuestario,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, creditoPresupuestario: CreditoPresupuestario = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(creditoPresupuestario == null)/*4.35*/{_display_(Seq[Any](format.raw/*4.36*/("""
	<p>Para cargar lineas primero debe dar de alta el crédito presupuestario.</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.presupuesto.routes.LineasRecursosPresupuestariosController.index(creditoPresupuestario.id, formularioCarga))),format.raw/*9.131*/("""', function(data)"""),format.raw/*9.148*/("""{"""),format.raw/*9.149*/("""
				$('#listaLineaRecursos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaRecursos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,creditoPresupuestario:CreditoPresupuestario): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,creditoPresupuestario)
    
    def f:((Boolean,CreditoPresupuestario) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,creditoPresupuestario) => apply(formularioCarga,creditoPresupuestario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/contenidoTabRecurso.scala.html
                    HASH: 437bd14635f77fb33f099ca7985361c2c002cc01
                    MATRIX: 845->1|1040->80|1067->104|1103->106|1144->139|1182->140|1280->222|1291->227|1328->228|1382->255|1410->256|1457->268|1476->279|1606->387|1651->404|1680->405|1761->459|1789->460|1820->464|1848->465|1894->480
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            