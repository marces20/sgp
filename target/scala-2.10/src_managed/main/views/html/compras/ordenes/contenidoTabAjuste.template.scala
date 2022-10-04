
package views.html.compras.ordenes

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
object contenidoTabAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, ordenForm: Form[Orden] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.59*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(ordenForm.field("id").value == null || ordenForm.field("id").value == "")/*4.78*/{_display_(Seq[Any](format.raw/*4.79*/("""
	<p>Para cargar productos primero debe dar de alta la Orden</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""

	<script>
		$( function ()"""),format.raw/*9.17*/("""{"""),format.raw/*9.18*/("""
			$.get('"""),_display_(Seq[Any](/*10.12*/controllers/*10.23*/.compras.routes.OrdenesLineasAjustesController.index(ordenForm.field("id").value.toLong, formularioCarga))),format.raw/*10.128*/("""', function(data)"""),format.raw/*10.145*/("""{"""),format.raw/*10.146*/("""
				$('#listaLineaAjustes').parent().html(data);
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""")
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>

""")))})),format.raw/*16.2*/("""

<div id="listaLineaAjustes">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,ordenForm)
    
    def f:((Boolean,Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,ordenForm) => apply(formularioCarga,ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/contenidoTabAjuste.scala.html
                    HASH: 4b33e0051ab126aa2c0a8253c914f4215fb86ebf
                    MATRIX: 816->1|989->58|1016->82|1052->84|1136->160|1174->161|1257->228|1268->233|1305->234|1360->262|1388->263|1436->275|1456->286|1584->391|1630->408|1660->409|1740->462|1768->463|1799->467|1827->468|1874->484
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|44->16
                    -- GENERATED --
                */
            