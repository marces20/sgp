
package views.html.compras.certificaciones

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Certificacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[Certificacion] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(certificacionForm.field("id").value == null || certificacionForm.field("id").value == "")/*4.94*/{_display_(Seq[Any](format.raw/*4.95*/("""
	<p>Para cargar productos primero debe dar de alta la Certificacion</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.compras.routes.LineasCertificacionesController.index(certificacionForm.field("id").value.toLong, formularioCarga))),format.raw/*9.136*/("""', function(data)"""),format.raw/*9.153*/("""{"""),format.raw/*9.154*/("""
			$('#listaLineaProductos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[Certificacion]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[Certificacion]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/contenidoTabProducto.scala.html
                    HASH: 95c03f72e358748a88ef138b38aaab77106c5299
                    MATRIX: 834->1|1024->74|1052->100|1089->103|1189->195|1227->196|1320->273|1331->278|1368->279|1423->307|1451->308|1498->320|1517->331|1653->445|1698->462|1727->463|1809->518|1837->519|1868->523|1896->524|1944->541
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            