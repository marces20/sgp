
package views.html.administracion.grupos

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
object editarGrupo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Grupo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(grupoForm: Form[Grupo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion("Modificar grupo")/*4.65*/ {_display_(Seq[Any](format.raw/*4.67*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar usuario</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.GruposController.crear)),format.raw/*13.70*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo grupo</a>
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.administracion.routes.UsuariosController.index())),format.raw/*14.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

    """),_display_(Seq[Any](/*20.6*/if(flash.containsKey("error"))/*20.36*/ {_display_(Seq[Any](format.raw/*20.38*/("""
		<div class="alert alert-danger">
			<i class="glyphicon glyphicon-remove-sign"></i>  """),_display_(Seq[Any](/*22.54*/flash/*22.59*/.get("error"))),format.raw/*22.72*/("""
		</div>
    """)))})),format.raw/*24.6*/("""

"""),_display_(Seq[Any](/*26.2*/helper/*26.8*/.form(action = controllers.administracion.routes.GruposController.actualizar())/*26.87*/ {_display_(Seq[Any](format.raw/*26.89*/("""
	"""),_display_(Seq[Any](/*27.3*/inputText(grupoForm("id"), 'hidden -> "hidden"))),format.raw/*27.50*/("""
	"""),_display_(Seq[Any](/*28.3*/views/*28.8*/.html.administracion.grupos.form(grupoForm))),format.raw/*28.51*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*35.2*/("""


""")))})),format.raw/*38.2*/("""
"""))}
    }
    
    def render(grupoForm:Form[Grupo]): play.api.templates.HtmlFormat.Appendable = apply(grupoForm)
    
    def f:((Form[Grupo]) => play.api.templates.HtmlFormat.Appendable) = (grupoForm) => apply(grupoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/grupos/editarGrupo.scala.html
                    HASH: ba395cca25446fc609846b5edea6c26e69d75e48
                    MATRIX: 807->1|934->46|966->70|1040->25|1069->114|1107->118|1119->123|1185->181|1224->183|1418->341|1438->352|1505->397|1644->500|1664->511|1735->560|1972->762|2011->792|2051->794|2178->885|2192->890|2227->903|2275->920|2315->925|2329->931|2417->1010|2457->1012|2496->1016|2565->1063|2604->1067|2617->1072|2682->1115|2942->1344|2980->1351
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|63->35|66->38
                    -- GENERATED --
                */
            