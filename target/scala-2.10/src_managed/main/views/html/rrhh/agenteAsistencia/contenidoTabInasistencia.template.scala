
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
object contenidoTabInasistencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Agente,Boolean,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agente:Agente,formularioCarga: Boolean,tipoLicencia:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.60*/("""

"""),format.raw/*4.1*/("""
<script>
	$( function ()"""),format.raw/*6.16*/("""{"""),format.raw/*6.17*/("""
		$.get('"""),_display_(Seq[Any](/*7.11*/controllers/*7.22*/.rrhh.routes.AgentesAsistenciasLicenciasController.index(agente.id, formularioCarga,tipoLicencia))),format.raw/*7.119*/("""', function(data)"""),format.raw/*7.136*/("""{"""),format.raw/*7.137*/("""
			$('#listaLicencias').parent().html(data);
		"""),format.raw/*9.3*/("""}"""),format.raw/*9.4*/(""")
	"""),format.raw/*10.2*/("""}"""),format.raw/*10.3*/(""");
</script>

<div id="listaLicencias">

</div>
"""))}
    }
    
    def render(agente:Agente,formularioCarga:Boolean,tipoLicencia:Long): play.api.templates.HtmlFormat.Appendable = apply(agente,formularioCarga,tipoLicencia)
    
    def f:((Agente,Boolean,Long) => play.api.templates.HtmlFormat.Appendable) = (agente,formularioCarga,tipoLicencia) => apply(agente,formularioCarga,tipoLicencia)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/contenidoTabInasistencia.scala.html
                    HASH: ada763edcfb4f8147d141619d77f9869675066b9
                    MATRIX: 828->1|1002->59|1030->84|1082->109|1110->110|1156->121|1175->132|1294->229|1339->246|1368->247|1442->295|1469->296|1499->299|1527->300
                    LINES: 26->1|30->1|32->4|34->6|34->6|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10
                    -- GENERATED --
                */
            