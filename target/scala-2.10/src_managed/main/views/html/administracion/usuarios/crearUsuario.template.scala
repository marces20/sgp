
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
object crearUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Usuario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuarioForm: Form[Usuario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion("Crear usuario")/*4.63*/ {_display_(Seq[Any](format.raw/*4.65*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Crear nuevo usuario</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.UsuariosController.index())),format.raw/*13.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*19.2*/if(flash.containsKey("success"))/*19.34*/ {_display_(Seq[Any](format.raw/*19.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*21.50*/flash/*21.55*/.get("success"))),format.raw/*21.70*/("""
	</div>
""")))})),format.raw/*23.2*/("""
"""),_display_(Seq[Any](/*24.2*/if(flash.containsKey("error"))/*24.32*/ {_display_(Seq[Any](format.raw/*24.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*26.52*/flash/*26.57*/.get("error"))),format.raw/*26.70*/("""
	</div>
""")))})),format.raw/*28.2*/("""

"""),_display_(Seq[Any](/*30.2*/helper/*30.8*/.form(action = controllers.administracion.routes.UsuariosController.guardar())/*30.86*/ {_display_(Seq[Any](format.raw/*30.88*/("""
	"""),_display_(Seq[Any](/*31.3*/views/*31.8*/.html.administracion.usuarios.form(usuarioForm))),format.raw/*31.55*/("""
	
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href=""""),_display_(Seq[Any](/*35.17*/(controllers.administracion.routes.UsuariosController.crear()))),format.raw/*35.79*/("""" class="btn btn-default">Cancelar</a>
      <button type="submit" class="btn btn-sistema">Crear</button>
    </div>
</div>
	
""")))})),format.raw/*40.2*/("""

""")))})),format.raw/*42.2*/("""
"""))}
    }
    
    def render(usuarioForm:Form[Usuario]): play.api.templates.HtmlFormat.Appendable = apply(usuarioForm)
    
    def f:((Form[Usuario]) => play.api.templates.HtmlFormat.Appendable) = (usuarioForm) => apply(usuarioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/crearUsuario.scala.html
                    HASH: dac007e73e9b25f7a11ef266c3fdf5347f986ac5
                    MATRIX: 812->1|943->50|975->74|1049->29|1078->118|1116->122|1128->127|1192->183|1231->185|1431->349|1451->360|1522->409|1755->607|1796->639|1836->641|1959->728|1973->733|2010->748|2053->760|2091->763|2130->793|2170->795|2294->883|2308->888|2343->901|2386->913|2426->918|2440->924|2527->1002|2567->1004|2606->1008|2619->1013|2688->1060|2821->1157|2905->1219|3068->1351|3104->1356
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|47->19|47->19|47->19|49->21|49->21|49->21|51->23|52->24|52->24|52->24|54->26|54->26|54->26|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|63->35|63->35|68->40|70->42
                    -- GENERATED --
                */
            