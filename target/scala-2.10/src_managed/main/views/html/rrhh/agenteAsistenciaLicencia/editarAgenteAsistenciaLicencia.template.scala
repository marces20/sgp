
package views.html.rrhh.agenteAsistenciaLicencia

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
object editarAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[AgenteAsistenciaLicencia],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteAsistenciaLicencia],puedeEditar:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.65*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesAsistenciasLicenciasController.actualizar())/*5.98*/ {_display_(Seq[Any](format.raw/*5.100*/("""
	
	"""),_display_(Seq[Any](/*7.3*/if(flash.containsKey("error") && !puedeEditar)/*7.49*/ {_display_(Seq[Any](format.raw/*7.51*/("""
		<div class="alert alert-danger">
			<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.53*/flash/*9.58*/.get("error"))),format.raw/*9.71*/("""
		</div>
	""")))}/*11.3*/else/*11.7*/{_display_(Seq[Any](format.raw/*11.8*/("""
		"""),_display_(Seq[Any](/*12.4*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*12.51*/("""
		"""),_display_(Seq[Any](/*13.4*/views/*13.9*/.html.rrhh.agenteAsistenciaLicencia.formAgenteAsistenciaLicencia(lineaForm))),format.raw/*13.84*/("""
	""")))})),format.raw/*14.3*/("""
	
""")))})),format.raw/*16.2*/("""

"""))}
    }
    
    def render(lineaForm:Form[AgenteAsistenciaLicencia],puedeEditar:Boolean): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,puedeEditar)
    
    def f:((Form[AgenteAsistenciaLicencia],Boolean) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,puedeEditar) => apply(lineaForm,puedeEditar)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/editarAgenteAsistenciaLicencia.scala.html
                    HASH: 60756c8b08653b2c53bb3f97755a21e3c9c8da1e
                    MATRIX: 861->1|1027->85|1059->109|1133->64|1162->153|1202->159|1215->165|1313->255|1353->257|1394->264|1448->310|1487->312|1612->402|1625->407|1659->420|1691->434|1703->438|1741->439|1781->444|1850->491|1890->496|1903->501|2000->576|2035->580|2072->586
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|41->13|41->13|41->13|42->14|44->16
                    -- GENERATED --
                */
            