
package views.html.recupero.presupuesto

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.recupero.Presupuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, presupuestoForm: Form[models.recupero.Presupuesto] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(presupuestoForm.field("id").value == null || presupuestoForm.field("id").value == "")/*4.90*/{_display_(Seq[Any](format.raw/*4.91*/("""
	<p>Para cargar productos primero debe dar de alta el presupuesto</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.recupero.routes.PresupuestoLineasController.index(presupuestoForm.field("id").value.toLong, formularioCarga))),format.raw/*9.131*/("""', function(data)"""),format.raw/*9.148*/("""{"""),format.raw/*9.149*/("""
			$('#listaLineaProductos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,presupuestoForm:Form[models.recupero.Presupuesto]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,presupuestoForm)
    
    def f:((Boolean,Form[models.recupero.Presupuesto]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,presupuestoForm) => apply(formularioCarga,presupuestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/contenidoTabProducto.scala.html
                    HASH: 4cba5792c0d14241e9e9c97eed7ccb4e467eae26
                    MATRIX: 845->1|1047->86|1075->112|1112->115|1208->203|1246->204|1337->279|1348->284|1385->285|1440->313|1468->314|1515->326|1534->337|1665->446|1710->463|1739->464|1821->519|1849->520|1880->524|1908->525|1956->542
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            