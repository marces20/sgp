
package views.html.administracion.localidades

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
object optionsListLocalidades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Localidad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(localidades: List[Localidad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""
<option value>Seleccionar</option>
"""),_display_(Seq[Any](/*3.2*/for(p <- localidades) yield /*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""<option value=""""),_display_(Seq[Any](/*3.41*/p/*3.42*/.id.toString)),format.raw/*3.54*/("""">"""),_display_(Seq[Any](/*3.57*/p/*3.58*/.nombre)),format.raw/*3.65*/("""</option>""")))})))}
    }
    
    def render(localidades:List[Localidad]): play.api.templates.HtmlFormat.Appendable = apply(localidades)
    
    def f:((List[Localidad]) => play.api.templates.HtmlFormat.Appendable) = (localidades) => apply(localidades)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/localidades/optionsListLocalidades.scala.html
                    HASH: 3e89100e3b6c10448343f9c6a76a85967c177590
                    MATRIX: 827->1|951->31|1024->70|1060->91|1099->93|1150->109|1159->110|1192->122|1230->125|1239->126|1267->133
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            