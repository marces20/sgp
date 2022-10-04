
package views.html.haberes.liquidacionPuestos.modales

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
object modalReciboSueldoPorPuestoMail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

 

"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.haberes.routes.LiquidacionPuestosReportesController.enviarReciboPorMail(), 'id -> "formEnviarReciboPorMail")/*7.143*/ {_display_(Seq[Any](format.raw/*7.145*/("""	
	
	"""),_display_(Seq[Any](/*9.3*/views/*9.8*/.html.tags.successError())),format.raw/*9.33*/("""
	
	
 	<div class="row">
		<div class="col-sm-5">
			<div class="form-group">
				<label for="email_modal" class="control-label">Email</label> 
				"""),_display_(Seq[Any](/*16.6*/inputText(formBuscador("email"),'class -> "form-control", 'id -> "email"))),format.raw/*16.79*/("""
				"""),_display_(Seq[Any](/*17.6*/inputText(formBuscador("lpid"), 'hidden -> "hidden"))),format.raw/*17.58*/(""" 
				"""),_display_(Seq[Any](/*18.6*/inputText(formBuscador("agente_id"), 'hidden -> "hidden"))),format.raw/*18.63*/(""" 
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="email_modal" class="control-label">Fecha Actualizacion</label> 
				"""),_display_(Seq[Any](/*24.6*/inputText(formBuscador("write_email_date"),'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*24.98*/("""
			</div>
		</div>
		<div class="col-sm-3"><br />
		 	<a  id="actualizarMail" data-url=""""),_display_(Seq[Any](/*28.40*/controllers/*28.51*/.rrhh.routes.AgentesController.actualizarMail())),format.raw/*28.98*/(""""  class="btn btn-default">
			 <i class="glyphicon glyphicon-arrow-right"></i> Actualizar Mail</a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" id="az" class="btn btn-default" title="Enviar Mail">
			<i class="glyphicon glyphicon-arrow-right"></i>Enviar Mail</button>
		</div>
	</div>
""")))})),format.raw/*38.2*/("""
"""),_display_(Seq[Any](/*39.2*/flash()/*39.9*/.clear())),format.raw/*39.17*/("""

"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/modales/modalReciboSueldoPorPuestoMail.scala.html
                    HASH: 5755619c4abb3ae53ca3924865cd52e2171972da
                    MATRIX: 839->1|968->47|1000->71|1074->28|1102->115|1143->122|1156->128|1300->263|1340->265|1380->271|1392->276|1438->301|1622->450|1717->523|1758->529|1832->581|1874->588|1953->645|2147->804|2261->896|2387->986|2407->997|2476->1044|2841->1378|2878->1380|2893->1387|2923->1395
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|37->9|37->9|37->9|44->16|44->16|45->17|45->17|46->18|46->18|52->24|52->24|56->28|56->28|56->28|66->38|67->39|67->39|67->39
                    -- GENERATED --
                */
            