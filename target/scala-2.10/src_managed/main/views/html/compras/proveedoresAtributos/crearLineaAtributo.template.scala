
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
object crearLineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ProveedorAtributo],ProveedorAtributo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ProveedorAtributo],linea:ProveedorAtributo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.ProveedorAtributosController.guardar())/*5.89*/ {_display_(Seq[Any](format.raw/*5.91*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.proveedoresAtributos.formLineaAtributo(lineaForm,linea))),format.raw/*7.77*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[ProveedorAtributo],linea:ProveedorAtributo): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[ProveedorAtributo],ProveedorAtributo) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/crearLineaAtributo.scala.html
                    HASH: 87aa0f5ed69d4cf42f8a28a4e46655fd6cc6142f
                    MATRIX: 851->1|1014->82|1046->106|1120->61|1149->150|1189->156|1202->162|1291->243|1330->245|1371->252|1383->257|1473->326
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7
                    -- GENERATED --
                */
            