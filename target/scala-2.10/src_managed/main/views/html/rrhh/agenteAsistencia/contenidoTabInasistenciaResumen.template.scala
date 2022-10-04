
package views.html.rrhh.agenteAsistencia

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
object contenidoTabInasistenciaResumen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Agente,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agente:Agente,formularioCarga: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""
<script>
	$( function ()"""),format.raw/*6.16*/("""{"""),format.raw/*6.17*/("""
		
	"""),format.raw/*8.2*/("""}"""),format.raw/*8.3*/(""");
</script>

<div id="listaLicenciasResumen">

</div>"""))}
    }
    
    def render(agente:Agente,formularioCarga:Boolean): play.api.templates.HtmlFormat.Appendable = apply(agente,formularioCarga)
    
    def f:((Agente,Boolean) => play.api.templates.HtmlFormat.Appendable) = (agente,formularioCarga) => apply(agente,formularioCarga)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/contenidoTabInasistenciaResumen.scala.html
                    HASH: d394a2804f6b4f762fbbff62ded22562b6b1a0d7
                    MATRIX: 830->1|986->41|1014->66|1066->91|1094->92|1125->97|1152->98
                    LINES: 26->1|30->1|32->4|34->6|34->6|36->8|36->8
                    -- GENERATED --
                */
            