
package views.html.compras.lineasOrdenes

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
object editarLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenLinea],OrdenLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[OrdenLinea],linea:OrdenLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.LineasOrdenesController.actualizar())/*5.87*/ {_display_(Seq[Any](format.raw/*5.89*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.compras.lineasOrdenes.formLineaProducto(lineaForm,linea))),format.raw/*7.70*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*8.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[OrdenLinea],linea:OrdenLinea): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[OrdenLinea],OrdenLinea) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/editarLineaProducto.scala.html
                    HASH: c738c7a0eb2f5cff526185efae129e7ae3dd5034
                    MATRIX: 831->1|980->68|1012->92|1086->47|1115->136|1155->142|1168->148|1255->227|1294->229|1335->236|1347->241|1430->303|1468->307|1536->354
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8
                    -- GENERATED --
                */
            