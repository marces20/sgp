
package views.html.haberes.liquidacionBaseCalculos

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
object editarLiquidacionBaseCalculo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionBaseCalculo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionBaseCalculo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Base Calculo")/*5.58*/ {_display_(Seq[Any](format.raw/*5.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Base Calculo</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.haberes.routes.LiquidacionBaseCalculosController.index())),format.raw/*14.83*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/views/*20.8*/.html.tags.successError())),format.raw/*20.33*/("""
	
	"""),_display_(Seq[Any](/*22.3*/helper/*22.9*/.form(action = controllers.haberes.routes.LiquidacionBaseCalculosController.actualizar())/*22.98*/ {_display_(Seq[Any](format.raw/*22.100*/("""
		"""),_display_(Seq[Any](/*23.4*/inputText(baseForm("id"), 'hidden -> "hidden"))),format.raw/*23.50*/("""
		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.haberes.liquidacionBaseCalculos.formLiquidacionBaseCalculo(baseForm))),format.raw/*24.83*/("""
	""")))})),format.raw/*25.3*/("""

""")))})))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionBaseCalculo]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionBaseCalculo]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionBaseCalculos/editarLiquidacionBaseCalculo.scala.html
                    HASH: d99f74bedb7adea192f9b0272e4f38051573ff59
                    MATRIX: 866->1|1023->75|1055->99|1129->56|1157->143|1194->146|1206->151|1265->202|1304->204|1503->367|1523->378|1602->435|1835->633|1848->638|1895->663|1935->668|1949->674|2047->763|2088->765|2127->769|2195->815|2234->819|2247->824|2343->898|2377->901
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|52->24|52->24|52->24|53->25
                    -- GENERATED --
                */
            