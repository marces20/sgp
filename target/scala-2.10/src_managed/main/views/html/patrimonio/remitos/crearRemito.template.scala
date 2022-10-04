
package views.html.patrimonio.remitos

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
object crearRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Remito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remitoForm: Form[Remito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Crear remito")/*6.54*/ {_display_(Seq[Any](format.raw/*6.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear remito</h1>
			</div>
			
			 
		</div>
	</div> 
    
    
	"""),_display_(Seq[Any](/*19.3*/helper/*19.9*/.form(action = controllers.patrimonio.routes.RemitosController.guardar(), 'id -> "formCrearRemito")/*19.108*/ {_display_(Seq[Any](format.raw/*19.110*/("""
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.patrimonio.remitos.formRemito(remitoForm))),format.raw/*20.56*/(""" 
	""")))})),format.raw/*21.3*/("""

""")))})))}
    }
    
    def render(remitoForm:Form[Remito]): play.api.templates.HtmlFormat.Appendable = apply(remitoForm)
    
    def f:((Form[Remito]) => play.api.templates.HtmlFormat.Appendable) = (remitoForm) => apply(remitoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/crearRemito.scala.html
                    HASH: aea4d872e32024ee70c6ed5f093e4784aa1d9c3d
                    MATRIX: 805->1|951->65|983->89|1057->27|1086->133|1130->143|1142->148|1197->195|1236->197|1435->361|1449->367|1558->466|1599->468|1639->473|1652->478|1721->525|1757->530
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|48->19|48->19|48->19|48->19|49->20|49->20|49->20|50->21
                    -- GENERATED --
                */
            