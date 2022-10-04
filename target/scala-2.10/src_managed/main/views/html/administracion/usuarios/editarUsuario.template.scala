
package views.html.administracion.usuarios

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
object editarUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Usuario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuarioForm: Form[Usuario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion("Modificar usuario")/*4.67*/ {_display_(Seq[Any](format.raw/*4.69*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar usuario</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.UsuariosController.crear)),format.raw/*13.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo usuario</a>
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.administracion.routes.UsuariosController.index())),format.raw/*14.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*20.2*/if(flash.containsKey("success"))/*20.34*/ {_display_(Seq[Any](format.raw/*20.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*22.50*/flash/*22.55*/.get("success"))),format.raw/*22.70*/("""
	</div>
""")))})),format.raw/*24.2*/("""
"""),_display_(Seq[Any](/*25.2*/if(flash.containsKey("error"))/*25.32*/ {_display_(Seq[Any](format.raw/*25.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*27.52*/flash/*27.57*/.get("error"))),format.raw/*27.70*/("""
	</div>
""")))})),format.raw/*29.2*/("""

"""),_display_(Seq[Any](/*31.2*/helper/*31.8*/.form(action = controllers.administracion.routes.UsuariosController.actualizar())/*31.89*/ {_display_(Seq[Any](format.raw/*31.91*/("""
	"""),_display_(Seq[Any](/*32.3*/inputText(usuarioForm("id"), 'hidden -> "hidden"))),format.raw/*32.52*/("""
	"""),_display_(Seq[Any](/*33.3*/views/*33.8*/.html.administracion.usuarios.form(usuarioForm))),format.raw/*33.55*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*40.2*/("""


""")))})),format.raw/*43.2*/("""
"""))}
    }
    
    def render(usuarioForm:Form[Usuario]): play.api.templates.HtmlFormat.Appendable = apply(usuarioForm)
    
    def f:((Form[Usuario]) => play.api.templates.HtmlFormat.Appendable) = (usuarioForm) => apply(usuarioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/editarUsuario.scala.html
                    HASH: 3fae20f6a9fc24db47afc3e24fbebfc64d9ff56f
                    MATRIX: 813->1|944->50|976->74|1050->29|1079->118|1117->122|1129->127|1197->187|1236->189|1430->347|1450->358|1519->405|1660->510|1680->521|1751->570|1984->768|2025->800|2065->802|2188->889|2202->894|2239->909|2282->921|2320->924|2359->954|2399->956|2523->1044|2537->1049|2572->1062|2615->1074|2655->1079|2669->1085|2759->1166|2799->1168|2838->1172|2909->1221|2948->1225|2961->1230|3030->1277|3290->1506|3328->1513
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|53->25|55->27|55->27|55->27|57->29|59->31|59->31|59->31|59->31|60->32|60->32|61->33|61->33|61->33|68->40|71->43
                    -- GENERATED --
                */
            