
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
object contenidoTabPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Boolean,Form[Agente],Agente,List[models.haberes.PuestoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteForm: Form[Agente] = null,agente:Agente,pl:List[models.haberes.PuestoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.113*/("""
"""),format.raw/*3.1*/("""

<div id="listaAgentePuesto" class="contenedorPaginador ajaxPaginador">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Datos Puesto Laboral</b></div>
			<div class="panel-body">
			
				<table id="listaDeAgentePuesto" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Escala</th>	
							<th>Fecha Posesion</th>
							<th>Fecha Baja</th>
						</tr>
					</thead>
					<tbody>
						"""),_display_(Seq[Any](/*19.8*/for(lc <- pl) yield /*19.21*/{_display_(Seq[Any](format.raw/*19.22*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*21.14*/(lc.escalaLaboral.nombre))),format.raw/*21.39*/("""</td>
								<td>"""),_display_(Seq[Any](/*22.14*/(utils.DateUtils.formatDate(lc.fecha_posesion)))),format.raw/*22.61*/("""</td>
								<td>"""),_display_(Seq[Any](/*23.14*/(utils.DateUtils.formatDate(lc.fecha_baja)))),format.raw/*23.57*/("""</td>
							</tr>
						""")))})),format.raw/*25.8*/("""
 						
					</tbody>
				</table>		
			</div>
		</div>	
		
</div>		"""))}
    }
    
    def render(formularioCarga:Boolean,agenteForm:Form[Agente],agente:Agente,pl:List[models.haberes.PuestoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteForm,agente,pl)
    
    def f:((Boolean,Form[Agente],Agente,List[models.haberes.PuestoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteForm,agente,pl) => apply(formularioCarga,agenteForm,agente,pl)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/contenidoTabPuestoLaboral.scala.html
                    HASH: f1c6a8cb7874af2eeffdb3c0ec2ffd080bf20feb
                    MATRIX: 862->1|1090->112|1117->136|1589->573|1618->586|1657->587|1719->613|1766->638|1821->657|1890->704|1945->723|2010->766|2067->792
                    LINES: 26->1|30->1|31->3|47->19|47->19|47->19|49->21|49->21|50->22|50->22|51->23|51->23|53->25
                    -- GENERATED --
                */
            