
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
object tabsAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[AgenteSeguimiento],AgenteSeguimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteSeguimientoForm: Form[AgenteSeguimiento] = null,agenteSeguimiento:AgenteSeguimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.119*/("""

<ul id="seguimientoTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorEventos" data-toggle="tab">Eventos</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorEventos">
		"""),_display_(Seq[Any](/*10.4*/views/*10.9*/.html.rrhh.agenteSeguimientos.contenidoTabEventos(formularioCarga, agenteSeguimientoForm))),format.raw/*10.98*/("""	
	</div>
	 

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,agenteSeguimientoForm:Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteSeguimientoForm,agenteSeguimiento)
    
    def f:((Boolean,Form[AgenteSeguimiento],AgenteSeguimiento) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteSeguimientoForm,agenteSeguimiento) => apply(formularioCarga,agenteSeguimientoForm,agenteSeguimiento)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/tabsAgenteSeguimiento.scala.html
                    HASH: 3fb40a4b62d18e636a065d2ed8feff71599f04b5
                    MATRIX: 857->1|1069->118|1347->361|1360->366|1471->455
                    LINES: 26->1|29->1|38->10|38->10|38->10
                    -- GENERATED --
                */
            