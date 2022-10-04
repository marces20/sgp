
package views.html.rrhh.agenteAsistenciaLicencia

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
object verAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[AgenteAsistenciaLicencia,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  AgenteAsistenciaLicencia):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.rrhh.agenteAsistenciaLicencia.lineaAgenteAsistenciaLicencia(linea, true))))}
    }
    
    def render(linea:AgenteAsistenciaLicencia): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((AgenteAsistenciaLicencia) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/verAgenteAsistenciaLicencia.scala.html
                    HASH: cea8abf976590314d4f5d5d02d9c1096505ee552
                    MATRIX: 844->1|972->35|1011->40|1023->45
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            