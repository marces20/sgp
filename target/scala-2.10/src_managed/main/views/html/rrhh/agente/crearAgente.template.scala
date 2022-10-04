
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
object crearAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Agente],Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteForm: Form[Agente],agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*4.63*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.rrhh.mainRrhh("Crear Agente",scripts)/*6.50*/ {_display_(Seq[Any](format.raw/*6.52*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nuevo Agente</h1>
			</div>
			
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*18.3*/if(flash.containsKey("error"))/*18.33*/ {_display_(Seq[Any](format.raw/*18.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*20.5*/flash/*20.10*/.get("error"))),format.raw/*20.23*/("""
		</div>
    """)))})),format.raw/*22.6*/("""
    
    """),_display_(Seq[Any](/*24.6*/helper/*24.12*/.form(action = controllers.rrhh.routes.AgentesController.guardarAgente())/*24.85*/ {_display_(Seq[Any](format.raw/*24.87*/("""
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.rrhh.agente.formAgente(agenteForm,agente))),format.raw/*25.56*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.rrhh.agente.tabsAgente(false, agenteForm,agente,null))),format.raw/*26.68*/("""
	""")))})),format.raw/*27.3*/("""
""")))})),format.raw/*28.2*/("""	"""))}
    }
    
    def render(agenteForm:Form[Agente],agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(agenteForm,agente)
    
    def f:((Form[Agente],Agente) => play.api.templates.HtmlFormat.Appendable) = (agenteForm,agente) => apply(agenteForm,agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/crearAgente.scala.html
                    HASH: 380968ee585503c55c289bbe533f5ee735aff771
                    MATRIX: 805->1|938->60|952->67|1036->71|1087->87|1101->93|1163->134|1238->41|1265->170|1301->172|1313->177|1364->220|1403->222|1614->398|1653->428|1693->430|1768->470|1782->475|1817->488|1863->503|1909->514|1924->520|2006->593|2046->595|2085->599|2098->604|2167->651|2206->655|2219->660|2300->719|2334->722|2367->724
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|34->1|35->5|36->6|36->6|36->6|36->6|48->18|48->18|48->18|50->20|50->20|50->20|52->22|54->24|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26|57->27|58->28
                    -- GENERATED --
                */
            