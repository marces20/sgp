
package views.html.recupero.presupuestoLineas

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.recupero.PresupuestoLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  models.recupero.PresupuestoLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.recupero.presupuestoLineas.lineaProducto(linea, true))))}
    }
    
    def render(linea:models.recupero.PresupuestoLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((models.recupero.PresupuestoLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuestoLineas/verLineaProducto.scala.html
                    HASH: a9f75eedc3fcf152ea5989dbb9372541c2fb4386
                    MATRIX: 838->1|974->43|1013->48|1025->53
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            