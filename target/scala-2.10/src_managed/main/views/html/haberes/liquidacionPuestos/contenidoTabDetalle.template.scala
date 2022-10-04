
package views.html.haberes.liquidacionPuestos

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
object contenidoTabDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, lpForm: Form[models.haberes.LiquidacionPuesto] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(lpForm.field("id").value == null || lpForm.field("id").value == "")/*4.72*/{_display_(Seq[Any](format.raw/*4.73*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar detalles primero debe dar de alta la liquidacion</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.haberes.routes.LiquidacionDetallesController.index(lpForm.field("id").value.toLong, formularioCarga))),format.raw/*9.124*/("""', function(data)"""),format.raw/*9.141*/("""{"""),format.raw/*9.142*/("""
				$('#listaLiquidacionDetalles').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""
		 
<div id="listaLiquidacionDetalles">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,lpForm:Form[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,lpForm)
    
    def f:((Boolean,Form[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,lpForm) => apply(formularioCarga,lpForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/contenidoTabDetalle.scala.html
                    HASH: 7e7a8871b1952843507ee67f5eaec58142c250b0
                    MATRIX: 855->1|1053->82|1081->108|1118->111|1196->181|1234->182|1370->302|1381->307|1418->308|1474->337|1502->338|1550->351|1569->362|1692->463|1737->480|1766->481|1855->543|1883->544|1915->549|1943->550|1991->567
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            