
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
object editarLineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[LineaRecursoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[LineaRecursoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.presupuesto.routes.LineasRecursosPresupuestariosController.actualizar())/*5.107*/ {_display_(Seq[Any](format.raw/*5.109*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.presupuesto.lineaRecursoPresupuestario.formLineaRecurso(lineaForm))),format.raw/*6.80*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default cancelar">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Modificar</button>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/editarLineaRecurso.scala.html
                    HASH: b1258b5f0346bdd0f8f6eb1de2c6ff7525b9254b
                    MATRIX: 852->1|1000->67|1032->91|1106->46|1135->135|1175->141|1188->147|1296->246|1336->248|1374->252|1386->257|1479->329|1517->333|1585->380
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            