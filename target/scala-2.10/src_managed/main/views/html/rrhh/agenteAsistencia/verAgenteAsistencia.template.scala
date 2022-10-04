
package views.html.rrhh.agenteAsistencia

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
object verAgenteAsistencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Agente,Form[AgenteAsistenciaLicencia],Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agente:Agente,lineaForm: Form[AgenteAsistenciaLicencia],tipoLicencia:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*6.63*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.rrhh.mainRrhh("Asistencias Agentes",scripts)/*10.57*/ {_display_(Seq[Any](format.raw/*10.59*/("""
<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Asistencias Agentes</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="reporteLicencia" href="#" data-url=""""),_display_(Seq[Any](/*25.56*/controllers/*25.67*/.rrhh.routes.AgentesAsistenciasReportesController.reporteLicencia())),format.raw/*25.134*/("""">Ficha Licencia</a></li>
				  	<li><a id="reporteLicenciaMedica" href="#" data-url=""""),_display_(Seq[Any](/*26.62*/controllers/*26.73*/.rrhh.routes.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral())),format.raw/*26.155*/("""">Ficha Licencia Medicina Laboral</a></li>
				  </ul>
				</div>
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
					<ul class="dropdown-menu">
						"""),_display_(Seq[Any](/*32.8*/if(Permiso.check("agentesLicenciasPasarBorrador"))/*32.58*/ {_display_(Seq[Any](format.raw/*32.60*/("""    
					    	<li role="presentation"><a role="menuitem" id="accionLicenciaPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*33.121*/controllers/*33.132*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarBorrador())),format.raw/*33.203*/("""">Pasar a Borrador</a></li>
						""")))})),format.raw/*34.8*/("""  
						"""),_display_(Seq[Any](/*35.8*/if(Permiso.check("agentesLicenciasPasarPreAprobado"))/*35.61*/ {_display_(Seq[Any](format.raw/*35.63*/("""   
							<li role="presentation"><a role="menuitem" id="accionLicenciaPasarPreAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*36.121*/controllers/*36.132*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarPreAprobado())),format.raw/*36.206*/("""">Pasar a PreAprobado</a></li>
						""")))})),format.raw/*37.8*/("""
						"""),_display_(Seq[Any](/*38.8*/if(Permiso.check("agentesLicenciasPasarAprobado"))/*38.58*/ {_display_(Seq[Any](format.raw/*38.60*/("""   	
							<li role="presentation"><a role="menuitem" id="accionLicenciaPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*39.118*/controllers/*39.129*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarAprobado())),format.raw/*39.200*/("""">Pasar a Aprobado</a></li>
						""")))})),format.raw/*40.8*/("""  
						"""),_display_(Seq[Any](/*41.8*/if(Permiso.check("agentesLicenciasPasarCancelado"))/*41.59*/ {_display_(Seq[Any](format.raw/*41.61*/("""    
					    	<li role="presentation"><a role="menuitem" id="accionLicenciaPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*42.122*/controllers/*42.133*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarCancelado())),format.raw/*42.205*/("""">Pasar a Cancelado</a></li>
						""")))})),format.raw/*43.8*/("""  												  									 																							
					</ul>
				</div>	
			</div>
			
			
		</div>
	</div>
</hr>
<form action=""""),_display_(Seq[Any](/*52.16*/controllers/*52.27*/.rrhh.routes.AgentesAsistenciasController.ver(agente.id))),_display_(Seq[Any](/*52.84*/UriTrack/*52.92*/.get("&"))),format.raw/*52.101*/("""" method="GET" id="formb">
<div class="row menu-acciones">
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*55.13*/controllers/*55.24*/.rrhh.routes.AgentesAsistenciasController.editar(agente.id))),_display_(Seq[Any](/*55.84*/UriTrack/*55.92*/.get("&"))),format.raw/*55.101*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
	</div>	
	<div class="col-sm-6">
		<div class="form-group">
			<label for="" class="control-label">Tipo Licencia</label>
			"""),_display_(Seq[Any](/*60.5*/select(lineaForm("tipoLicencia"), 
						TipoLicencia.find.all().map { p => p.id.toString -> p.nombre},
						'class -> "form-control select", 
						'_default -> "Seleccionar",'id -> "tipoLicencia"))),format.raw/*63.56*/(""" 
			
			 
		</div>
	</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*75.13*/UriTrack/*75.21*/.getOnNull(controllers.rrhh.routes.AgentesAsistenciasController.index().absoluteURL()))),format.raw/*75.107*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
	</div>
	<input type="hidden" value=""""),_display_(Seq[Any](/*77.31*/agente/*77.37*/.id)),format.raw/*77.40*/("""" id="agenteId"/>
	<input type="hidden" value=""""),_display_(Seq[Any](/*78.31*/agente/*78.37*/.id)),format.raw/*78.40*/("""" id="id" name="id"/>
	<input type="hidden" value=""""),_display_(Seq[Any](/*79.31*/UriTrack/*79.39*/.get("&"))),format.raw/*79.48*/("""" id="id" name="id"/>
</div>
</form>
<h2>"""),_display_(Seq[Any](/*82.6*/agente/*82.12*/.apellido)),format.raw/*82.21*/(""" - Fecha Ingreso """),_display_(Seq[Any](/*82.39*/DateUtils/*82.48*/.formatDate(agente.fingreso,"dd/MM/yyyy"))),format.raw/*82.89*/("""</h2>


"""),_display_(Seq[Any](/*85.2*/views/*85.7*/.html.rrhh.agenteAsistencia.tabsAgenteAsistencia(agente,false,tipoLicencia))),format.raw/*85.82*/("""

<script>
$(document).on("change", '#tipoLicencia', function()"""),format.raw/*88.53*/("""{"""),format.raw/*88.54*/("""
	var form = $("#formb");
	var url = form.attr('action')+"&tipoLicencia="+$( "#tipoLicencia option:selected" ).val();
	window.location.href = url;
	return false;
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/(""");

</script>  

""")))})))}
    }
    
    def render(agente:Agente,lineaForm:Form[AgenteAsistenciaLicencia],tipoLicencia:Long): play.api.templates.HtmlFormat.Appendable = apply(agente,lineaForm,tipoLicencia)
    
    def f:((Agente,Form[AgenteAsistenciaLicencia],Long) => play.api.templates.HtmlFormat.Appendable) = (agente,lineaForm,tipoLicencia) => apply(agente,lineaForm,tipoLicencia)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/verAgenteAsistencia.scala.html
                    HASH: 8cf174c2ff9ae1795535741cd2b0bd1bb9212c32
                    MATRIX: 846->1|1052->133|1066->140|1150->144|1201->160|1215->166|1277->207|1344->245|1376->269|1450->76|1477->243|1505->313|1544->317|1557->322|1616->372|1656->374|2242->924|2262->935|2352->1002|2475->1089|2495->1100|2600->1182|2986->1533|3045->1583|3085->1585|3247->1710|3268->1721|3362->1792|3428->1827|3473->1837|3535->1890|3575->1892|3736->2016|3757->2027|3854->2101|3923->2139|3966->2147|4025->2197|4065->2199|4224->2321|4245->2332|4339->2403|4405->2438|4450->2448|4510->2499|4550->2501|4713->2627|4734->2638|4829->2710|4896->2746|5061->2875|5081->2886|5168->2943|5185->2951|5217->2960|5348->3055|5368->3066|5458->3126|5475->3134|5507->3143|5746->3347|5967->3546|6276->3819|6293->3827|6402->3913|6548->4023|6563->4029|6588->4032|6672->4080|6687->4086|6712->4089|6800->4141|6817->4149|6848->4158|6925->4200|6940->4206|6971->4215|7025->4233|7043->4242|7106->4283|7150->4292|7163->4297|7260->4372|7351->4435|7380->4436|7569->4598|7597->4599
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|57->25|57->25|57->25|58->26|58->26|58->26|64->32|64->32|64->32|65->33|65->33|65->33|66->34|67->35|67->35|67->35|68->36|68->36|68->36|69->37|70->38|70->38|70->38|71->39|71->39|71->39|72->40|73->41|73->41|73->41|74->42|74->42|74->42|75->43|84->52|84->52|84->52|84->52|84->52|87->55|87->55|87->55|87->55|87->55|92->60|95->63|107->75|107->75|107->75|109->77|109->77|109->77|110->78|110->78|110->78|111->79|111->79|111->79|114->82|114->82|114->82|114->82|114->82|114->82|117->85|117->85|117->85|120->88|120->88|125->93|125->93
                    -- GENERATED --
                */
            