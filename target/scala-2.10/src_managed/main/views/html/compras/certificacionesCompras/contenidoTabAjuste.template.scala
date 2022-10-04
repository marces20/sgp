
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
object contenidoTabAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[CertificacionCompra],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[CertificacionCompra] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(certificacionForm.field("id").value == null || certificacionForm.field("id").value == "")/*4.94*/{_display_(Seq[Any](format.raw/*4.95*/("""
	<p>Para cargar productos primero debe dar de alta la Certificacion</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""

	<script>
		$( function ()"""),format.raw/*9.17*/("""{"""),format.raw/*9.18*/("""
			$.get('"""),_display_(Seq[Any](/*10.12*/controllers/*10.23*/.compras.routes.CertificacionesComprasLineaAjustesController.index(certificacionForm.field("id").value.toLong, formularioCarga))),format.raw/*10.150*/("""', function(data)"""),format.raw/*10.167*/("""{"""),format.raw/*10.168*/("""
				$('#listaLineaAjustes').parent().html(data);
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""")
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>

""")))})),format.raw/*16.2*/("""

<div id="listaLineaAjustes">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[CertificacionCompra]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[CertificacionCompra]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/contenidoTabAjuste.scala.html
                    HASH: ac12b9ce13881c6fb4e439b1b789d0fd3a74e713
                    MATRIX: 845->1|1040->80|1067->104|1103->106|1203->198|1241->199|1332->274|1343->279|1380->280|1435->308|1463->309|1511->321|1531->332|1681->459|1727->476|1757->477|1837->530|1865->531|1896->535|1924->536|1971->552
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|44->16
                    -- GENERATED --
                */
            