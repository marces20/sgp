
package views.html.expediente.dispo

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
object crearDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Dispo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formDispo: Form[Dispo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.expediente.mainExpediente("Crear Disposicion")/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva Disposicion</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.expediente.routes.DisposController.index())),format.raw/*13.69*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
    """)))})),format.raw/*24.6*/("""
    """),_display_(Seq[Any](/*25.6*/helper/*25.12*/.form(action = controllers.expediente.routes.DisposController.guardar())/*25.84*/ {_display_(Seq[Any](format.raw/*25.86*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.expediente.dispo.formDispo(formDispo))),format.raw/*26.52*/("""
	""")))})),format.raw/*27.3*/("""
""")))})),format.raw/*28.2*/("""	"""))}
    }
    
    def render(formDispo:Form[Dispo]): play.api.templates.HtmlFormat.Appendable = apply(formDispo)
    
    def f:((Form[Dispo]) => play.api.templates.HtmlFormat.Appendable) = (formDispo) => apply(formDispo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/crearDispo.scala.html
                    HASH: 13fd0e9df7335acf7bc7bb68b43d04ecfb74be68
                    MATRIX: 801->1|936->25|964->45|1001->48|1013->53|1073->105|1112->107|1324->283|1344->294|1409->337|1658->551|1697->581|1737->583|1814->625|1828->630|1863->643|1911->660|1953->667|1968->673|2049->745|2089->747|2129->752|2142->757|2207->800|2242->804|2276->807
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|56->28
                    -- GENERATED --
                */
            