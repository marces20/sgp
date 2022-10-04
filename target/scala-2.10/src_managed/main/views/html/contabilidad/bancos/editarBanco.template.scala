
package views.html.contabilidad.bancos

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
object editarBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Banco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(bancoForm: Form[Banco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar Banco")/*5.61*/ {_display_(Seq[Any](format.raw/*5.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Banco</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*14.76*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.contabilidad.routes.BancosController.actualizarBanco())/*26.91*/ {_display_(Seq[Any](format.raw/*26.93*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(bancoForm("id"), 'hidden -> "hidden"))),format.raw/*27.51*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.contabilidad.bancos.formBanco(bancoForm))),format.raw/*28.55*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*31.80*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(bancoForm:Form[Banco]): play.api.templates.HtmlFormat.Appendable = apply(bancoForm)
    
    def f:((Form[Banco]) => play.api.templates.HtmlFormat.Appendable) = (bancoForm) => apply(bancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/bancos/editarBanco.scala.html
                    HASH: 680a76978d28ef9616becb2a6590199cda2e29c0
                    MATRIX: 805->1|931->44|963->68|1037->25|1065->112|1102->115|1114->120|1176->174|1215->176|1407->332|1427->343|1499->393|1732->591|1771->621|1811->623|1886->663|1900->668|1935->681|1978->693|2018->698|2032->704|2123->786|2163->788|2202->792|2271->839|2310->843|2323->848|2391->894|2524->991|2544->1002|2616->1052|2780->1185
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            