
package views.html.rrhh.agenteEstudios

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
object optionsListSubarea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[EstudioSubarea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(subAreas: List[EstudioSubarea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""
<option value>Seleccionar</option>
"""),_display_(Seq[Any](/*3.2*/for(p <- subAreas) yield /*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""<option value=""""),_display_(Seq[Any](/*3.38*/p/*3.39*/.id.toString)),format.raw/*3.51*/("""">"""),_display_(Seq[Any](/*3.54*/p/*3.55*/.nombre)),format.raw/*3.62*/("""</option>""")))})))}
    }
    
    def render(subAreas:List[EstudioSubarea]): play.api.templates.HtmlFormat.Appendable = apply(subAreas)
    
    def f:((List[EstudioSubarea]) => play.api.templates.HtmlFormat.Appendable) = (subAreas) => apply(subAreas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteEstudios/optionsListSubarea.scala.html
                    HASH: a8d92cd65d2bfb3735df85e5bd81fd390f83e1ea
                    MATRIX: 821->1|947->33|1020->72|1053->90|1092->92|1143->108|1152->109|1185->121|1223->124|1232->125|1260->132
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            