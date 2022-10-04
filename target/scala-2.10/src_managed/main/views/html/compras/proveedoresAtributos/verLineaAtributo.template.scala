
package views.html.compras.proveedoresAtributos

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
object verLineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ProveedorAtributo,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  ProveedorAtributo, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.proveedoresAtributos.lineaAtributo(linea, editable))))}
    }
    
    def render(linea:ProveedorAtributo,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ProveedorAtributo,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/verLineaAtributo.scala.html
                    HASH: c7665b0f90808af724601804aa7aa8af360f490c
                    MATRIX: 833->1|973->47|1012->52|1024->57
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            