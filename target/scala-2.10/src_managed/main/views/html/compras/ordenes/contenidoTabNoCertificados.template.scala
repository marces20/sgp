
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
object contenidoTabNoCertificados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, ordenForm: Form[Orden] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.59*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(ordenForm.field("id").value == null || ordenForm.field("id").value == "")/*4.78*/{_display_(Seq[Any](format.raw/*4.79*/("""
	<p>Para ver productos primero debe dar de alta la Orden</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""

	<script>
		$( function ()"""),format.raw/*9.17*/("""{"""),format.raw/*9.18*/("""
			$.get('"""),_display_(Seq[Any](/*10.12*/controllers/*10.23*/.patrimonio.routes.AnulacionRecepcionProductosController.verLineasNoCertificadas(ordenForm.field("id").value.toLong))),format.raw/*10.139*/("""', function(data)"""),format.raw/*10.156*/("""{"""),format.raw/*10.157*/("""
				$('#listaLineaNoCertificados').parent().html(data);
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""")
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>

""")))})),format.raw/*16.2*/("""

<div id="listaLineaNoCertificados">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,ordenForm)
    
    def f:((Boolean,Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,ordenForm) => apply(formularioCarga,ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/contenidoTabNoCertificados.scala.html
                    HASH: 0128a87a258e2546105f981e00e4a7db876dc67f
                    MATRIX: 824->1|997->58|1024->82|1060->84|1144->160|1182->161|1262->225|1273->230|1310->231|1365->259|1393->260|1441->272|1461->283|1600->399|1646->416|1676->417|1763->477|1791->478|1822->482|1850->483|1897->499
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|44->16
                    -- GENERATED --
                */
            