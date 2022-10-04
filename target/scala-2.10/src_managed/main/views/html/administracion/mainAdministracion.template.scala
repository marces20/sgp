
package views.html.administracion

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
object mainAdministracion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
		<div class="row">
			<div class="col-sm-2">
				<div class="menu-contenido">
				<ul class="nav nav-pills nav-stacked">
					<li class="titulo">Administración</li>
						<li><a href=""""),_display_(Seq[Any](/*10.21*/controllers/*10.32*/.administracion.routes.UsuariosController.index())),format.raw/*10.81*/("""">Usuarios</a></li>
						<li><a href=""""),_display_(Seq[Any](/*11.21*/controllers/*11.32*/.administracion.routes.PermisosController.index())),format.raw/*11.81*/("""">Permisos</a></li>
				</ul>
				</div>
			</div>
			<div class="col-sm-10">"""),_display_(Seq[Any](/*15.28*/content)),format.raw/*15.35*/("""</div>
		</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/mainAdministracion.scala.html
                    HASH: de4e4056b9c89cdc3fb138b201c8113165cf849d
                    MATRIX: 812->1|983->57|1010->80|1046->82|1082->110|1120->111|1343->298|1363->309|1434->358|1510->398|1530->409|1601->458|1715->536|1744->543
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15
                    -- GENERATED --
                */
            