
package views.html.rrhh.agente

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
object contenidoTabEstudio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Agente],Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteForm: Form[Agente] = null,agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(agenteForm.field("id").value == null || agenteForm.field("id").value == "")/*4.80*/{_display_(Seq[Any](format.raw/*4.81*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar estudios primero debe guardar el agente</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.rrhh.routes.AgentesEstudiosController.index(agenteForm.field("id").value.toLong, formularioCarga))),format.raw/*9.121*/("""', function(data)"""),format.raw/*9.138*/("""{"""),format.raw/*9.139*/("""
				$('#listaAgenteEstudio').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaAgenteEstudio">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,agenteForm:Form[Agente],agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteForm,agente)
    
    def f:((Boolean,Form[Agente],Agente) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteForm,agente) => apply(formularioCarga,agenteForm,agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/contenidoTabEstudio.scala.html
                    HASH: 3a0cd51d791759cd7f11e0cef05c00c8e6754e8e
                    MATRIX: 821->1|1010->74|1037->98|1073->100|1159->178|1197->179|1322->288|1333->293|1370->294|1424->321|1452->322|1499->334|1518->345|1638->443|1683->460|1712->461|1793->515|1821->516|1852->520|1880->521|1926->536
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            