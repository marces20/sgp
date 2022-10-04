
package views.html.rrhh.tipoResidencia

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
object editarTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoResidencia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tpForm: Form[TipoResidencia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Modificar Tipo Residencia")/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Tipo Residencia</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*14.86*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.rrhh.routes.TipoResidenciasController.actualizarTipoResidencia())/*26.101*/ {_display_(Seq[Any](format.raw/*26.103*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(tpForm("id"), 'hidden -> "hidden"))),format.raw/*27.48*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.rrhh.tipoResidencia.formTipoResidencia(tpForm))),format.raw/*28.61*/("""
		 
	""")))})),format.raw/*30.3*/("""

""")))})))}
    }
    
    def render(tpForm:Form[TipoResidencia]): play.api.templates.HtmlFormat.Appendable = apply(tpForm)
    
    def f:((Form[TipoResidencia]) => play.api.templates.HtmlFormat.Appendable) = (tpForm) => apply(tpForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/editarTipoResidencia.scala.html
                    HASH: 2e02724629428f26e3b473733be07058c2d17d83
                    MATRIX: 823->1|955->50|987->74|1061->31|1089->118|1126->121|1138->126|1194->174|1233->176|1435->342|1455->353|1537->413|1770->611|1809->641|1849->643|1924->683|1938->688|1973->701|2016->713|2056->718|2070->724|2172->816|2213->818|2252->822|2318->866|2357->870|2370->875|2444->927|2482->934
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|58->30
                    -- GENERATED --
                */
            