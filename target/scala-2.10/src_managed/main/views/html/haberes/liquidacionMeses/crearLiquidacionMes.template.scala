
package views.html.haberes.liquidacionMeses

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
object crearLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionMes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lmForm: Form[models.haberes.LiquidacionMes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Liquidacion")/*4.53*/ {_display_(Seq[Any](format.raw/*4.55*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Liquidacion</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LiquidacionMesesController.guardar())/*15.91*/ {_display_(Seq[Any](format.raw/*15.93*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.liquidacionMeses.formLiquidacionMes(lmForm))),format.raw/*16.66*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(lmForm:Form[models.haberes.LiquidacionMes]): play.api.templates.HtmlFormat.Appendable = apply(lmForm)
    
    def f:((Form[models.haberes.LiquidacionMes]) => play.api.templates.HtmlFormat.Appendable) = (lmForm) => apply(lmForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/crearLiquidacionMes.scala.html
                    HASH: d404d51c4f95338ca95faaa0824ae88363db8065
                    MATRIX: 842->1|997->46|1024->64|1060->66|1072->71|1126->117|1165->119|1342->261|1355->266|1402->291|1448->302|1463->308|1551->387|1591->389|1630->393|1643->398|1722->455|1758->460
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            