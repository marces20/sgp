
package views.html.patrimonio.certificaciones

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
object contenidoTabPaciente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionServicio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[CertificacionServicio] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*3.1*/("""
<script>
$( function ()"""),format.raw/*5.15*/("""{"""),format.raw/*5.16*/("""
	$.get('"""),_display_(Seq[Any](/*6.10*/controllers/*6.21*/.patrimonio.routes.LineasCertificacionesController.getListaLineasPacientes(certificacionForm.field("id").value.toLong))),format.raw/*6.139*/("""', function(data)"""),format.raw/*6.156*/("""{"""),format.raw/*6.157*/("""
		$('#listaLineaPacientes').html(data.html);
	"""),format.raw/*8.2*/("""}"""),format.raw/*8.3*/(""")
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/(""");
</script>


<div id="listaLineaPacientes">

</div>
"""))}
    }
    
    def render(certificacionForm:Form[CertificacionServicio]): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm)
    
    def f:((Form[CertificacionServicio]) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm) => apply(certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/contenidoTabPaciente.scala.html
                    HASH: 695cb02e2ba688de92c78b333e8dd342d5d4ef30
                    MATRIX: 837->1|1008->56|1035->80|1086->104|1114->105|1159->115|1178->126|1318->244|1363->261|1392->262|1465->309|1492->310|1520->312|1547->313
                    LINES: 26->1|30->1|31->3|33->5|33->5|34->6|34->6|34->6|34->6|34->6|36->8|36->8|37->9|37->9
                    -- GENERATED --
                */
            