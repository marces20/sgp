
package views.html.contabilidad.sucursalbancos

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
object optionsListSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[SucursalBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(sucursalBancos: List[SucursalBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.39*/("""
<option value>Seleccionar</option>
"""),_display_(Seq[Any](/*3.2*/for(p <- sucursalBancos) yield /*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""<option value=""""),_display_(Seq[Any](/*3.44*/p/*3.45*/.id.toString)),format.raw/*3.57*/("""">"""),_display_(Seq[Any](/*3.60*/p/*3.61*/.nombre)),format.raw/*3.68*/("""</option>""")))})))}
    }
    
    def render(sucursalBancos:List[SucursalBanco]): play.api.templates.HtmlFormat.Appendable = apply(sucursalBancos)
    
    def f:((List[SucursalBanco]) => play.api.templates.HtmlFormat.Appendable) = (sucursalBancos) => apply(sucursalBancos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/optionsListSucursalBanco.scala.html
                    HASH: 1a122f1f0567abbe0b493dea0968423a108da26a
                    MATRIX: 834->1|965->38|1038->77|1077->101|1116->103|1167->119|1176->120|1209->132|1247->135|1256->136|1284->143
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            