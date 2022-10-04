
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
object crearCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CreditoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(creditoPresupuestarioForm: Form[CreditoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._


Seq[Any](format.raw/*1.58*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.presupuesto.mainPresupuesto("Crear crédito presupuestario")/*4.72*/ {_display_(Seq[Any](format.raw/*4.74*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Credito</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*13.87*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*20.3*/views/*20.8*/.html.tags.successError())),format.raw/*20.33*/("""
    
    """),_display_(Seq[Any](/*22.6*/helper/*22.12*/.form(action = controllers.presupuesto.routes.CreditosPresupuestariosController.guardar())/*22.102*/ {_display_(Seq[Any](format.raw/*22.104*/("""
		"""),_display_(Seq[Any](/*23.4*/views/*23.9*/.html.presupuesto.creditoPresupuestario.formCreditoPresupuestario(creditoPresupuestarioForm))),format.raw/*23.101*/("""
		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.presupuesto.creditoPresupuestario.tabsCreditoPresupuestario(true))),format.raw/*24.80*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*27.19*/controllers/*27.30*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*27.91*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*31.3*/("""
""")))})),format.raw/*32.2*/("""	"""))}
    }
    
    def render(creditoPresupuestarioForm:Form[CreditoPresupuestario]): play.api.templates.HtmlFormat.Appendable = apply(creditoPresupuestarioForm)
    
    def f:((Form[CreditoPresupuestario]) => play.api.templates.HtmlFormat.Appendable) = (creditoPresupuestarioForm) => apply(creditoPresupuestarioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/crearCreditoPresupuestario.scala.html
                    HASH: 07729a7133912cf408ed1a8c61f4f77b6004a033
                    MATRIX: 850->1|1032->57|1068->92|1080->97|1153->162|1192->164|1391->327|1411->338|1494->399|1736->606|1749->611|1796->636|1842->647|1857->653|1957->743|1998->745|2037->749|2050->754|2165->846|2204->850|2217->855|2310->926|2443->1023|2463->1034|2546->1095|2711->1229|2744->1231
                    LINES: 26->1|32->1|33->4|33->4|33->4|33->4|42->13|42->13|42->13|49->20|49->20|49->20|51->22|51->22|51->22|51->22|52->23|52->23|52->23|53->24|53->24|53->24|56->27|56->27|56->27|60->31|61->32
                    -- GENERATED --
                */
            