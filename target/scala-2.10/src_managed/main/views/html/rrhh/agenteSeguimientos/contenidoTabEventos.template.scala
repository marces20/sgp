
package views.html.rrhh.agenteSeguimientos

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
object contenidoTabEventos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[AgenteSeguimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteSeguimientoForm: Form[AgenteSeguimiento] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(agenteSeguimientoForm.field("id").value == null || agenteSeguimientoForm.field("id").value == "")/*4.102*/{_display_(Seq[Any](format.raw/*4.103*/("""
	<p>Para cargar eventos primero debe dar de alta el Seguimiento</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.rrhh.routes.AgentesSeguimientoLineasController.index(agenteSeguimientoForm.field("id").value.toLong, formularioCarga))),format.raw/*9.140*/("""', function(data)"""),format.raw/*9.157*/("""{"""),format.raw/*9.158*/("""
			$('#listaLineaEventos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaEventos">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,agenteSeguimientoForm:Form[AgenteSeguimiento]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteSeguimientoForm)
    
    def f:((Boolean,Form[AgenteSeguimiento]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteSeguimientoForm) => apply(formularioCarga,agenteSeguimientoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/contenidoTabEventos.scala.html
                    HASH: e3509f7591acf303822efc8902a45d2dd405d001
                    MATRIX: 837->1|1034->82|1061->106|1097->108|1206->208|1245->209|1332->280|1343->285|1380->286|1433->312|1461->313|1507->324|1526->335|1666->453|1711->470|1740->471|1818->522|1846->523|1876->526|1904->527|1950->542
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            