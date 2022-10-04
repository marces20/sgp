
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
object crearAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteAsistenciaLicencia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteAsistenciaLicencia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.70*/(""" 
											   
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.rrhh.routes.AgentesAsistenciasLicenciasController.guardar())/*5.95*/ {_display_(Seq[Any](format.raw/*5.97*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.rrhh.agenteAsistenciaLicencia.formAgenteAsistenciaLicencia(lineaForm))),format.raw/*6.83*/("""
												   
	
""")))})))}
    }
    
    def render(lineaForm:Form[AgenteAsistenciaLicencia]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteAsistenciaLicencia]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/crearAgenteAsistenciaLicencia.scala.html
                    HASH: ce2a8206aa0a051461e00047dff19557ba266c7f
                    MATRIX: 852->1|998->65|1030->89|1104->44|1133->133|1187->153|1200->159|1295->246|1334->248|1372->252|1384->257|1480->332
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            