
package views.html.rrhh.agenteNovedades

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
object verAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteNovedad,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  AgenteNovedad, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.rrhh.agenteNovedades.lineaAgenteNovedad(linea, editable))))}
    }
    
    def render(linea:AgenteNovedad,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteNovedad,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/verAgenteNovedad.scala.html
                    HASH: d9e6a083987960ec4a4812bd094ee298060dd2fd
                    MATRIX: 821->1|957->43|996->48|1008->53
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            