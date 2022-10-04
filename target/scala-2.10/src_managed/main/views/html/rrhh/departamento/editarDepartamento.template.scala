
package views.html.rrhh.departamento

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
object editarDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Departamento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(departamentoForm: Form[Departamento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Modificar Departamento")/*5.52*/ {_display_(Seq[Any](format.raw/*5.54*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Departamento</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*14.82*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.rrhh.routes.DepartamentosController.actualizarDepartamento())/*26.97*/ {_display_(Seq[Any](format.raw/*26.99*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(departamentoForm("id"), 'hidden -> "hidden"))),format.raw/*27.58*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.rrhh.departamento.formDepartamento(departamentoForm))),format.raw/*28.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*31.86*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(departamentoForm:Form[Departamento]): play.api.templates.HtmlFormat.Appendable = apply(departamentoForm)
    
    def f:((Form[Departamento]) => play.api.templates.HtmlFormat.Appendable) = (departamentoForm) => apply(departamentoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/departamento/editarDepartamento.scala.html
                    HASH: 7f4b3485527adbcfea88227274164c780bfb2ff6
                    MATRIX: 817->1|957->58|989->82|1063->39|1091->126|1128->129|1140->134|1193->179|1232->181|1431->344|1451->355|1529->411|1762->609|1801->639|1841->641|1916->681|1930->686|1965->699|2008->711|2048->716|2062->722|2159->810|2199->812|2238->816|2314->870|2353->874|2366->879|2446->937|2579->1034|2599->1045|2677->1101|2841->1234
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            