
package views.html.haberes.liquidacionTipos

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
object crearLiquidacionTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Tipo de Liquidación")/*4.61*/ {_display_(Seq[Any](format.raw/*4.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Tipo de Liquidación</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.LiquidacionTiposController.guardar())/*15.91*/ {_display_(Seq[Any](format.raw/*15.93*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.liquidacionTipos.formLiquidacionTipo(tipoForm))),format.raw/*16.69*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionTipos/crearLiquidacionTipo.scala.html
                    HASH: 0d11bf94787fee2977bc7062fb23314f90c5003c
                    MATRIX: 844->1|1002->49|1029->67|1065->69|1077->74|1139->128|1178->130|1363->280|1376->285|1423->310|1469->321|1484->327|1572->406|1612->408|1651->412|1664->417|1746->477|1782->482
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            