
package views.html.rrhh.agente.modales

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
object modalPasarAAprobado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesAccionesController.pasarAAprobado(), 'id -> "formPasarAprobado")/*5.118*/ {_display_(Seq[Any](format.raw/*5.120*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="Pasar a Aprobado"><i class="glyphicon glyphicon-arrow-right"></i> Pasar a Aprobado</button>
	</div>

""")))})),format.raw/*13.2*/("""
"""),_display_(Seq[Any](/*14.2*/flash()/*14.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/modales/modalPasarAAprobado.scala.html
                    HASH: 749d8b156a0fc898ff7d7c3761232a66fb4439fb
                    MATRIX: 813->1|942->47|974->71|1048->28|1076->115|1115->120|1128->126|1247->236|1287->238|1327->244|1339->249|1385->274|1606->464|1643->466|1658->473
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|41->13|42->14|42->14
                    -- GENERATED --
                */
            