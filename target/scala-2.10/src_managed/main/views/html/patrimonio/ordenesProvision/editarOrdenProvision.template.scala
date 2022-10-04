
package views.html.patrimonio.ordenesProvision

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
object editarOrdenProvision extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenProvision],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(opForm: Form[OrdenProvision]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/patrimonio/ordenesProvision.js"))),format.raw/*7.78*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""	
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Modificar orden de provisión", scripts)/*9.79*/ {_display_(Seq[Any](format.raw/*9.81*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar orden de provisión</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*18.14*/controllers/*18.25*/.patrimonio.routes.OrdenesProvisionController.index())),format.raw/*18.78*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			<a href=""""),_display_(Seq[Any](/*19.14*/controllers/*19.25*/.patrimonio.routes.OrdenesProvisionController.ver(opForm.field("id").value.toLong))),_display_(Seq[Any](/*19.108*/UriTrack/*19.116*/.get("&"))),format.raw/*19.125*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*24.2*/helper/*24.8*/.form(action = controllers.patrimonio.routes.OrdenesProvisionController.actualizar())/*24.93*/ {_display_(Seq[Any](format.raw/*24.95*/("""

	"""),_display_(Seq[Any](/*26.3*/views/*26.8*/.html.patrimonio.ordenesProvision.form(opForm))),format.raw/*26.54*/("""
""")))})),format.raw/*27.2*/("""


""")))})),format.raw/*30.2*/("""
"""))}
    }
    
    def render(opForm:Form[OrdenProvision]): play.api.templates.HtmlFormat.Appendable = apply(opForm)
    
    def f:((Form[OrdenProvision]) => play.api.templates.HtmlFormat.Appendable) = (opForm) => apply(opForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/editarOrdenProvision.scala.html
                    HASH: 5b0f6afe9b0f445e41c641e7febaafbbc6a9c699
                    MATRIX: 831->1|995->164|1009->171|1093->175|1145->192|1159->198|1236->254|1304->92|1336->116|1410->31|1439->160|1468->291|1506->295|1518->300|1598->372|1637->374|1842->543|1862->554|1937->607|2058->692|2078->703|2192->786|2210->794|2242->803|2407->933|2421->939|2515->1024|2555->1026|2596->1032|2609->1037|2677->1083|2711->1086|2749->1093
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|41->9|41->9|41->9|41->9|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|56->24|56->24|56->24|56->24|58->26|58->26|58->26|59->27|62->30
                    -- GENERATED --
                */
            