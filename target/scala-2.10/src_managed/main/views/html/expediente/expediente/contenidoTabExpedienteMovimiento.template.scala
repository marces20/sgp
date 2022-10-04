
package views.html.expediente.expediente

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
object contenidoTabExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Expediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, expedienteForm: Form[Expediente] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.69*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(expedienteForm.field("id").value == null || expedienteForm.field("id").value == "")/*4.88*/{_display_(Seq[Any](format.raw/*4.89*/("""
	<p>No hay movimientos</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.expediente.routes.ExpedientesMovimientosController.index(expedienteForm.field("id").value.toLong, formularioCarga))),format.raw/*9.137*/("""', function(data)"""),format.raw/*9.154*/("""{"""),format.raw/*9.155*/("""
			$('#listaLineaExpedientesMovimientos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaExpedientesMovimientos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,expedienteForm:Form[Expediente]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,expedienteForm)
    
    def f:((Boolean,Form[Expediente]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,expedienteForm) => apply(formularioCarga,expedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/contenidoTabExpedienteMovimiento.scala.html
                    HASH: dea9a2cae88ab0b5951fe4a1184f6cfbd47c817b
                    MATRIX: 841->1|1025->68|1053->94|1090->97|1184->183|1222->184|1270->216|1281->221|1318->222|1373->250|1401->251|1448->263|1467->274|1604->389|1649->406|1678->407|1773->475|1801->476|1832->480|1860->481|1908->498
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            