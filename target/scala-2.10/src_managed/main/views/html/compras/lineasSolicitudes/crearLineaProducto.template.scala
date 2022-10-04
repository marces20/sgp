
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
object crearLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[SolicitudLinea],Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[SolicitudLinea],s:Solicitud = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.LineasSolicitudesController.guardar())/*5.88*/ {_display_(Seq[Any](format.raw/*5.90*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineasSolicitudes.formLineaProducto(lineaForm,s))),format.raw/*6.70*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default cancelar">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Crear</button>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/crearLineaProducto.scala.html
                    HASH: 87228d746e991e607e45444e415037999b94f427
                    MATRIX: 837->1|992->74|1024->98|1098->53|1127->142|1167->148|1180->154|1268->234|1307->236|1345->240|1357->245|1440->307
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            