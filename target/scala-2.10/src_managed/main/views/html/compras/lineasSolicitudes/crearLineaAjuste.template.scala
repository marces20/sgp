
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
object crearLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SolicitudLineaAjuste],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[SolicitudLineaAjuste]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.AjustesSolicitudesController.guardar())/*5.89*/ {_display_(Seq[Any](format.raw/*5.91*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.compras.lineasSolicitudes.formLineaAjuste(lineaForm))),format.raw/*6.66*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default cancelar">Cancelar</a>
	      <button type="submit" id="btn-guardar-linea-ajuste-solicitudes" class="btn btn-sistema">Crear</button>
	    </div>
	</div>
""")))})))}
    }
    
    def render(lineaForm:Form[SolicitudLineaAjuste]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[SolicitudLineaAjuste]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/crearLineaAjuste.scala.html
                    HASH: 0ec10d24cce4c52405a3f97ac88e8c9149d06027
                    MATRIX: 831->1|972->59|1004->83|1078->40|1106->127|1144->131|1157->137|1246->218|1285->220|1322->223|1334->228|1413->286
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            