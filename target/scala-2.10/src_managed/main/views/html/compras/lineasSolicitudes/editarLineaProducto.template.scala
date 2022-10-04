
package views.html.compras.lineasSolicitudes

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
object editarLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[SolicitudLinea],Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[SolicitudLinea],s:Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.LineasSolicitudesController.actualizar())/*5.91*/ {_display_(Seq[Any](format.raw/*5.93*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineasSolicitudes.formLineaProducto(lineaForm,s))),format.raw/*6.70*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default cancelar">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Modificar</button>
	    </div>
	</div>
""")))})))}
    }
    
    def render(lineaForm:Form[SolicitudLinea],s:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,s)
    
    def f:((Form[SolicitudLinea],Solicitud) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,s) => apply(lineaForm,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/editarLineaProducto.scala.html
                    HASH: 1cf21a0886068b656ffc7ea7a160cf20fcf6b2fa
                    MATRIX: 838->1|986->67|1018->91|1092->46|1121->135|1161->141|1174->147|1265->230|1304->232|1342->236|1354->241|1437->303|1475->307|1543->354
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            