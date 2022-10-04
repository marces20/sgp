
package views.html.presupuesto.lineaRecursoPresupuestario

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
object crearLineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[LineaRecursoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[LineaRecursoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.presupuesto.routes.LineasRecursosPresupuestariosController.guardar())/*5.104*/ {_display_(Seq[Any](format.raw/*5.106*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.presupuesto.lineaRecursoPresupuestario.formLineaRecurso(lineaForm))),format.raw/*6.80*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default cancelar">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Crear</button>
	    </div>
	</div>
""")))})))}
    }
    
    def render(lineaForm:Form[LineaRecursoPresupuestario]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[LineaRecursoPresupuestario]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/crearLineaRecurso.scala.html
                    HASH: 2a3f3e9c4c786927a309975a41b428123097a337
                    MATRIX: 851->1|999->67|1031->91|1105->46|1134->135|1174->141|1187->147|1292->243|1332->245|1370->249|1382->254|1475->326
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            