
package views.html.rrhh.puesto

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
object editarPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Puesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(puestoForm: Form[Puesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Modificar Puesto")/*5.46*/ {_display_(Seq[Any](format.raw/*5.48*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Puesto</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*14.70*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.rrhh.routes.PuestosController.actualizarPuesto())/*26.85*/ {_display_(Seq[Any](format.raw/*26.87*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(puestoForm("id"), 'hidden -> "hidden"))),format.raw/*27.52*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.rrhh.puesto.formPuesto(puestoForm))),format.raw/*28.49*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*31.74*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(puestoForm:Form[Puesto]): play.api.templates.HtmlFormat.Appendable = apply(puestoForm)
    
    def f:((Form[Puesto]) => play.api.templates.HtmlFormat.Appendable) = (puestoForm) => apply(puestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/puesto/editarPuesto.scala.html
                    HASH: f7a08bbbacf34e7b23362aa4977c0bf406920e70
                    MATRIX: 799->1|927->46|959->70|1033->27|1061->114|1098->117|1110->122|1157->161|1196->163|1389->320|1409->331|1475->375|1708->573|1747->603|1787->605|1862->645|1876->650|1911->663|1954->675|1994->680|2008->686|2093->762|2133->764|2172->768|2242->816|2281->820|2294->825|2356->865|2489->962|2509->973|2575->1017|2739->1150
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            