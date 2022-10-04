
package views.html.patrimonio.anulacionRecepcion

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
object editarLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Form[OrdenLineaAnulacion],Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, lineaForm: Form[OrdenLineaAnulacion], orden_linea_id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.AnulacionRecepcionProductosController.actualizar(orden_linea_id), 'id -> "formAnulados")/*5.141*/ {_display_(Seq[Any](format.raw/*5.143*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.patrimonio.anulacionRecepcion.formLineaProducto(idOrdenCompra, lineaForm, orden_linea_id))),format.raw/*6.103*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(idOrdenCompra:Long,lineaForm:Form[OrdenLineaAnulacion],orden_linea_id:Long): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineaForm,orden_linea_id)
    
    def f:((Long,Form[OrdenLineaAnulacion],Long) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineaForm,orden_linea_id) => apply(idOrdenCompra,lineaForm,orden_linea_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/editarLineaProducto.scala.html
                    HASH: 57691d53bd89dbef450d3ae6e6e7008e4dfd5706
                    MATRIX: 847->1|1030->102|1062->126|1136->81|1165->170|1205->176|1218->182|1360->315|1400->317|1438->321|1450->326|1567->421|1605->425|1673->472
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            