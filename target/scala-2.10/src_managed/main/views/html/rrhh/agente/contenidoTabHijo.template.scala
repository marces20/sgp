
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
object contenidoTabHijo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Agente],Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteForm: Form[Agente] = null,agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(agenteForm.field("id").value == null || agenteForm.field("id").value == "")/*4.80*/{_display_(Seq[Any](format.raw/*4.81*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar hijos primero debe guardar el agente</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.rrhh.routes.AgentesHijosController.index(agenteForm.field("id").value.toLong, formularioCarga))),format.raw/*9.118*/("""', function(data)"""),format.raw/*9.135*/("""{"""),format.raw/*9.136*/("""
				$('#listaAgenteHijo').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaAgenteHijo">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,agenteForm:Form[Agente],agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteForm,agente)
    
    def f:((Boolean,Form[Agente],Agente) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteForm,agente) => apply(formularioCarga,agenteForm,agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/contenidoTabHijo.scala.html
                    HASH: 39a42a0cca9d221d687d5e28ae6561d2b3ca0499
                    MATRIX: 818->1|1007->74|1034->98|1070->100|1156->178|1194->179|1316->285|1327->290|1364->291|1418->318|1446->319|1493->331|1512->342|1629->437|1674->454|1703->455|1781->506|1809->507|1840->511|1868->512|1914->527
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            