
package views.html.compras.certificacionesCompras

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[CertificacionCompra],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[CertificacionCompra] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(certificacionForm.field("id").value == null || certificacionForm.field("id").value == "")/*4.94*/{_display_(Seq[Any](format.raw/*4.95*/("""
	<p>Para cargar productos primero debe dar de alta la Certificacion</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.compras.routes.CertificacionesComprasLineasController.index(certificacionForm.field("id").value.toLong, formularioCarga))),format.raw/*9.143*/("""', function(data)"""),format.raw/*9.160*/("""{"""),format.raw/*9.161*/("""
			$('#listaLineaProductos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[CertificacionCompra]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[CertificacionCompra]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/contenidoTabProducto.scala.html
                    HASH: 331733afc0b9bd8664e07092c2c4830aa9cc6454
                    MATRIX: 847->1|1043->80|1071->106|1108->109|1208->201|1246->202|1339->279|1350->284|1387->285|1442->313|1470->314|1517->326|1536->337|1679->458|1724->475|1753->476|1835->531|1863->532|1894->536|1922->537|1970->554
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            