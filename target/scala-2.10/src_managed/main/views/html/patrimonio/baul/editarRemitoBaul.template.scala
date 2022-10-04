
package views.html.patrimonio.baul

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
object editarRemitoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[RemitoBaul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/( cForm: Form[RemitoBaul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Ediar remito en baúl")/*6.62*/ {_display_(Seq[Any](format.raw/*6.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar remito en baúl</h1>
			</div>
			
			 
		</div>
	</div> 
    
    """),_display_(Seq[Any](/*18.6*/views/*18.11*/.html.tags.successError())),format.raw/*18.36*/("""
    
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.patrimonio.routes.RemitosBaulController.actualizar())/*20.89*/ {_display_(Seq[Any](format.raw/*20.91*/("""
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.patrimonio.baul.formRemitoBaul(cForm))),format.raw/*21.52*/(""" 
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.patrimonio.baul.tabsProductoRemitoBaul(true,  cForm.field("id").value.toLong))),format.raw/*22.92*/("""	
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(cForm:Form[RemitoBaul]): play.api.templates.HtmlFormat.Appendable = apply(cForm)
    
    def f:((Form[RemitoBaul]) => play.api.templates.HtmlFormat.Appendable) = (cForm) => apply(cForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/editarRemitoBaul.scala.html
                    HASH: d00f8c6a9e6e7be62ea579f4eddbea319828ddb2
                    MATRIX: 811->1|957->65|989->89|1063->27|1092->133|1136->143|1148->148|1211->203|1250->205|1455->375|1469->380|1516->405|1561->415|1575->421|1664->501|1704->503|1744->508|1757->513|1822->556|1863->562|1876->567|1981->650|2017->655
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|47->18|47->18|47->18|49->20|49->20|49->20|49->20|50->21|50->21|50->21|51->22|51->22|51->22|52->23
                    -- GENERATED --
                */
            