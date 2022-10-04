
package views.html.presupuesto.creditoPresupuestario

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
object editarCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CreditoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(creditoForm: Form[CreditoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*4.70*/("""

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.presupuesto.mainPresupuesto("Modificar Credito Presupuestario")/*6.76*/ {_display_(Seq[Any](format.raw/*6.78*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Crédito presupuestario</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*15.15*/controllers/*15.26*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*15.87*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*21.3*/views/*21.8*/.html.tags.successError())),format.raw/*21.33*/("""
	
	"""),_display_(Seq[Any](/*23.3*/helper/*23.9*/.form(action = controllers.presupuesto.routes.CreditosPresupuestariosController.actualizar())/*23.102*/ {_display_(Seq[Any](format.raw/*23.104*/("""
		"""),_display_(Seq[Any](/*24.4*/inputText(creditoForm("id"), 'hidden -> "hidden"))),format.raw/*24.53*/("""
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.presupuesto.creditoPresupuestario.formCreditoPresupuestario(creditoForm))),format.raw/*25.87*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.presupuesto.creditoPresupuestario.tabsCreditoPresupuestario(true,creditoForm.get()))),format.raw/*26.98*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*29.19*/controllers/*29.30*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*29.91*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*33.3*/("""

""")))})))}
    }
    
    def render(creditoForm:Form[CreditoPresupuestario]): play.api.templates.HtmlFormat.Appendable = apply(creditoForm)
    
    def f:((Form[CreditoPresupuestario]) => play.api.templates.HtmlFormat.Appendable) = (creditoForm) => apply(creditoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/editarCreditoPresupuestario.scala.html
                    HASH: a94f0c46406d8247e86fe09ab958aa9d7dfde36f
                    MATRIX: 851->1|1011->78|1043->102|1117->43|1145->146|1182->149|1194->154|1271->223|1310->225|1519->398|1539->409|1622->470|1855->668|1868->673|1915->698|1955->703|1969->709|2072->802|2113->804|2152->808|2223->857|2262->861|2275->866|2375->944|2414->948|2427->953|2538->1042|2671->1139|2691->1150|2774->1211|2938->1344
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|44->15|44->15|44->15|50->21|50->21|50->21|52->23|52->23|52->23|52->23|53->24|53->24|54->25|54->25|54->25|55->26|55->26|55->26|58->29|58->29|58->29|62->33
                    -- GENERATED --
                */
            