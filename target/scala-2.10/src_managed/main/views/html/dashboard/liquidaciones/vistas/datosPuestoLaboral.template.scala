
package views.html.dashboard.liquidaciones.vistas

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
object datosPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.haberes.PuestoLaboral,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pl:models.haberes.PuestoLaboral):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.35*/("""
"""),format.raw/*5.70*/("""


<h4>"""),_display_(Seq[Any](/*8.6*/pl/*8.8*/.legajo.agente.apellido)),format.raw/*8.31*/("""</h4>
<h4><b>Especialidad:</b> """),_display_(Seq[Any](/*9.27*/pl/*9.29*/.legajo.agente.especialidad.nombre)),format.raw/*9.63*/("""</h4>
<h4><b>Depto/Servicio:</b>"""),_display_(Seq[Any](/*10.28*/if(pl.legajo.agente.organigrama != null)/*10.68*/{_display_(Seq[Any](format.raw/*10.69*/(""" """),_display_(Seq[Any](/*10.71*/pl/*10.73*/.legajo.agente.organigrama.nombre))))})),format.raw/*10.107*/("""</h4>"""))}
    }
    
    def render(pl:models.haberes.PuestoLaboral): play.api.templates.HtmlFormat.Appendable = apply(pl)
    
    def f:((models.haberes.PuestoLaboral) => play.api.templates.HtmlFormat.Appendable) = (pl) => apply(pl)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/vistas/datosPuestoLaboral.scala.html
                    HASH: babb630de2d729d286698fc81b737a70b160de76
                    MATRIX: 840->1|1013->91|1045->115|1119->34|1147->159|1189->167|1198->169|1242->192|1309->224|1319->226|1374->260|1443->293|1492->333|1531->334|1569->336|1580->338|1641->372
                    LINES: 26->1|33->5|33->5|34->1|35->5|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|40->10|40->10|40->10
                    -- GENERATED --
                */
            