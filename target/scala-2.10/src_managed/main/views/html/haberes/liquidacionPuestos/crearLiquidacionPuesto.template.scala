
package views.html.haberes.liquidacionPuestos

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
object crearLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionPuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Liquidacion Puesto")/*4.60*/ {_display_(Seq[Any](format.raw/*4.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Liquidacion Puesto</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LiquidacionPuestosController.guardar())/*15.93*/ {_display_(Seq[Any](format.raw/*15.95*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.liquidacionPuestos.formLiquidacionPuesto(baseForm))),format.raw/*16.73*/(""" 
		"""),_display_(Seq[Any](/*17.4*/views/*17.9*/.html.haberes.liquidacionPuestos.tabsLiquidacionPuesto(true,baseForm))),format.raw/*17.78*/("""	
	""")))})),format.raw/*18.3*/("""
""")))})))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/crearLiquidacionPuesto.scala.html
                    HASH: 6d02d20653d06d1fe22a4eabeb5decc7ff014daa
                    MATRIX: 850->1|1010->51|1037->69|1073->71|1085->76|1146->129|1185->131|1369->280|1382->285|1429->310|1475->321|1490->327|1580->408|1620->410|1659->414|1672->419|1758->483|1798->488|1811->493|1902->562|1937->566
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18
                    -- GENERATED --
                */
            