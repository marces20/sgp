
package views.html.haberes.conveniosBancos

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
object editarConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.ConvenioBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(convenioForm: Form[models.haberes.ConvenioBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Convenio Banco")/*5.60*/ {_display_(Seq[Any](format.raw/*5.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Convenio Banco</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
													 
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.ConveniosBancosController.actualizar())/*20.90*/ {_display_(Seq[Any](format.raw/*20.92*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(convenioForm("id"), 'hidden -> "hidden"))),format.raw/*21.54*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.conveniosBancos.formConvenioBanco(convenioForm))),format.raw/*22.70*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(convenioForm:Form[models.haberes.ConvenioBanco]): play.api.templates.HtmlFormat.Appendable = apply(convenioForm)
    
    def f:((Form[models.haberes.ConvenioBanco]) => play.api.templates.HtmlFormat.Appendable) = (convenioForm) => apply(convenioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/editarConvenioBanco.scala.html
                    HASH: 44e824641f5e3e89c7946fad2b0004632a7dfa84
                    MATRIX: 840->1|992->70|1024->94|1098->51|1126->138|1163->141|1175->146|1236->199|1275->201|1492->383|1505->388|1552->413|1605->431|1619->437|1709->518|1749->520|1788->524|1860->574|1899->578|1912->583|1995->644|2029->647
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            