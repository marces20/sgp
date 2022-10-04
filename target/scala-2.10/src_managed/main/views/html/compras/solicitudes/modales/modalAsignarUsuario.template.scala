
package views.html.compras.solicitudes.modales

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
object modalAsignarUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,masivo: Boolean = false):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.53*/("""
"""),format.raw/*5.70*/(""" 
	
"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.compras.routes.SolicitudAccionesController.asignarUsuario(), 'id -> "formAsignarUsuario")/*7.124*/ {_display_(Seq[Any](format.raw/*7.126*/("""	
	
	"""),_display_(Seq[Any](/*9.3*/views/*9.8*/.html.tags.successError())),format.raw/*9.33*/("""
	
	"""),_display_(Seq[Any](/*11.3*/if(masivo == false)/*11.22*/{_display_(Seq[Any](format.raw/*11.23*/("""
		"""),_display_(Seq[Any](/*12.4*/inputText(formBuscador("id"),'hidden -> "hidden", 'id -> "id_solicitud_modal"))),format.raw/*12.82*/(""" 
		
	""")))})),format.raw/*14.3*/("""
		<div class="row">
			<div class="col-sm-6">
				<label for="paciente" class="control-label">Usuario</label> 
					<div class="input-group">
					"""),_display_(Seq[Any](/*19.7*/inputText(formBuscador("asignacion_usuario.nombre"),'class -> "form-control", 'id -> "user", 'autocomplete -> "off"))),format.raw/*19.123*/("""
					"""),_display_(Seq[Any](/*20.7*/inputText(formBuscador("asignacion_usuario_id"),'hidden -> "hidden", 'id -> "user_id"))),format.raw/*20.93*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchUser" 
									data-title="Selección de paciente" 
									data-url=""""),_display_(Seq[Any](/*25.21*/controllers/*25.32*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*25.87*/(""""
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.usuario.simple"
									data-label="#user" 
									data-field="#user_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
			 
				</div>
				
			</div>
		</div>
	<div class="row">
		<div class="col-sm-5"><br />
 			
			<button type="submit" class="btn btn-default" title="Asignar Usuario">
			<i class="glyphicon glyphicon-arrow-right"></i> Asignar Usuario</button>
		</div>
	</div>

""")))})),format.raw/*47.2*/("""

<script>
$( function()"""),format.raw/*50.14*/("""{"""),format.raw/*50.15*/("""
	
	$('#searchUser').modalSearch();
	
	if($("#user").length)"""),format.raw/*54.23*/("""{"""),format.raw/*54.24*/("""
		var options = """),format.raw/*55.17*/("""{"""),format.raw/*55.18*/("""
				script:"/administracion/usuarios/suggest/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*61.30*/("""{"""),format.raw/*61.31*/(""" 
											$("#user").next().val(obj.id); 
										 """),format.raw/*63.12*/("""}"""),format.raw/*63.13*/("""
			"""),format.raw/*64.4*/("""}"""),format.raw/*64.5*/(""";
		var as_json = new bsn.AutoSuggest('user', options);
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/("""
"""),format.raw/*67.1*/("""}"""),format.raw/*67.2*/(""");
</script>
"""),_display_(Seq[Any](/*69.2*/flash()/*69.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,masivo:Boolean): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,masivo)
    
    def f:((DynamicForm,Boolean) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,masivo) => apply(formBuscador,masivo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalAsignarUsuario.scala.html
                    HASH: d02ca5ecf011407dfed738771ffb5b720b4b51e5
                    MATRIX: 829->1|1020->109|1052->133|1126->52|1154->177|1193->182|1206->188|1331->304|1371->306|1411->312|1423->317|1469->342|1509->347|1537->366|1576->367|1615->371|1715->449|1753->456|1937->605|2076->721|2118->728|2226->814|2430->982|2450->993|2527->1048|3068->1558|3120->1582|3149->1583|3237->1643|3266->1644|3311->1661|3340->1662|3519->1813|3548->1814|3632->1870|3661->1871|3692->1875|3720->1876|3804->1933|3832->1934|3860->1935|3888->1936|3937->1950|3952->1957
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|41->11|41->11|41->11|42->12|42->12|44->14|49->19|49->19|50->20|50->20|55->25|55->25|55->25|77->47|80->50|80->50|84->54|84->54|85->55|85->55|91->61|91->61|93->63|93->63|94->64|94->64|96->66|96->66|97->67|97->67|99->69|99->69
                    -- GENERATED --
                */
            