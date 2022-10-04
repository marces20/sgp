
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
object modalModificarPaciente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Solicitud],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: Form[Solicitud]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*5.70*/(""" 
	
"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.compras.routes.SolicitudAccionesController.modificarPaciente(), 'id -> "formModificarPacienteDesdeModal")/*7.140*/ {_display_(Seq[Any](format.raw/*7.142*/("""	
	
	"""),_display_(Seq[Any](/*9.3*/views/*9.8*/.html.tags.successError())),format.raw/*9.33*/("""
	
	<div class="row">
		<div class="col-sm-6">
			<label for="paciente" class="control-label">Paciente</label> 
				<div class="input-group">
				"""),_display_(Seq[Any](/*15.6*/inputText(formBuscador("cliente.nombre"),'class -> "form-control", 'id -> "paciente", 'autocomplete -> "off"))),format.raw/*15.115*/("""
				"""),_display_(Seq[Any](/*16.6*/inputText(formBuscador("cliente_id"),'hidden -> "hidden", 'id -> "paciente_id"))),format.raw/*16.85*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPaciente" 
								data-title="Selección de paciente" 
								data-url=""""),_display_(Seq[Any](/*21.20*/controllers/*21.31*/.compras.routes.ClientesController.modalBuscar())),format.raw/*21.79*/(""""
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.cliente.simple"
								data-label="#paciente" 
								data-field="#paciente_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
				<!-- <span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPacienteCarga" 
								data-title="Carga de paciente" 
								data-url=""""),_display_(Seq[Any](/*34.20*/controllers/*34.31*/.compras.routes.ClientesController.modalCarga())),format.raw/*34.78*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.carga.cliente.simple" 
								data-label="#paciente" 
								data-field="#paciente_id">
						<i class="glyphicon glyphicon-plus"></i>
					</a>
				</span> -->
				
                
			</div>
			
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			"""),_display_(Seq[Any](/*51.5*/inputText(formBuscador("departamento_id"),'hidden -> "hidden"))),format.raw/*51.67*/("""
			"""),_display_(Seq[Any](/*52.5*/inputText(formBuscador("id"),'hidden -> "hidden"))),format.raw/*52.54*/("""
			"""),_display_(Seq[Any](/*53.5*/inputText(formBuscador("referencia") ,'hidden -> "hidden"))),format.raw/*53.63*/("""
			<button type="submit" class="btn btn-default" title="Modificar Paciente">
			<i class="glyphicon glyphicon-arrow-right"></i> Modificar Paciente</button>
		</div>
	</div>

""")))})),format.raw/*59.2*/("""

<script>
$( function()"""),format.raw/*62.14*/("""{"""),format.raw/*62.15*/("""
	
	$('#searchPaciente,#searchPacienteCarga').modalSearch();
	
	if($("#paciente").length)"""),format.raw/*66.27*/("""{"""),format.raw/*66.28*/("""
		var options = """),format.raw/*67.17*/("""{"""),format.raw/*67.18*/("""
				script:"/suggestCliente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*73.30*/("""{"""),format.raw/*73.31*/(""" 
											$("#paciente").next().val(obj.id); 
										 """),format.raw/*75.12*/("""}"""),format.raw/*75.13*/("""
			"""),format.raw/*76.4*/("""}"""),format.raw/*76.5*/(""";
		var as_json = new bsn.AutoSuggest('paciente', options);
	"""),format.raw/*78.2*/("""}"""),format.raw/*78.3*/("""
"""),format.raw/*79.1*/("""}"""),format.raw/*79.2*/(""");
</script>
"""),_display_(Seq[Any](/*81.2*/flash()/*81.9*/.clear())))}
    }
    
    def render(formBuscador:Form[Solicitud]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((Form[Solicitud]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalModificarPaciente.scala.html
                    HASH: 61e818410b32d4f0fa19ad2f957bb5be92e814b9
                    MATRIX: 828->1|999->89|1031->113|1105->32|1133->157|1172->162|1185->168|1326->300|1366->302|1406->308|1418->313|1464->338|1646->485|1778->594|1819->600|1920->679|2123->846|2143->857|2213->905|2667->1323|2687->1334|2756->1381|3144->1734|3228->1796|3268->1801|3339->1850|3379->1855|3459->1913|3666->2089|3718->2113|3747->2114|3864->2203|3893->2204|3938->2221|3967->2222|4129->2356|4158->2357|4246->2417|4275->2418|4306->2422|4334->2423|4422->2484|4450->2485|4478->2486|4506->2487|4555->2501|4570->2508
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|45->15|45->15|46->16|46->16|51->21|51->21|51->21|64->34|64->34|64->34|81->51|81->51|82->52|82->52|83->53|83->53|89->59|92->62|92->62|96->66|96->66|97->67|97->67|103->73|103->73|105->75|105->75|106->76|106->76|108->78|108->78|109->79|109->79|111->81|111->81
                    -- GENERATED --
                */
            