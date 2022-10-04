
package views.html.rrhh.agenteSeguimientos

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
object verAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[AgenteSeguimiento,Form[AgenteSeguimiento],utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteSeguimiento:AgenteSeguimiento,agenteSeguimientoForm: Form[AgenteSeguimiento],paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*6.63*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.134*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.rrhh.mainRrhh("Seguimiento Agentes",scripts)/*10.57*/ {_display_(Seq[Any](format.raw/*10.59*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-5">
				<h1>Vista de Seguimientos</h1>
			</div>
			<div class="col-sm-7">
				<div class="dropdown pull-right">
				 	<button class="btn btn-default dropdown-toggle btn-header" type="button" id="dropdownMenu1" data-toggle="dropdown">
					 	<i class="glyphicon glyphicon-list-alt"></i>
					    Acciones
					    <span class="caret"></span>
				  	</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  </ul>
				</div>
				<div class="dropdown pull-right">
				 	<button class="btn btn-default dropdown-toggle btn-header" type="button" id="dropdownMenu1" data-toggle="dropdown">
					 	<i class="glyphicon glyphicon-list-alt"></i>
					    Reportes
					    <span class="caret"></span>
				  	</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  </ul>
				</div>
			</div>
		</div>
	</div>		
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*41.14*/controllers/*41.25*/.rrhh.routes.AgentesSeguimientoController.crearAgenteSeguimiento())),format.raw/*41.91*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*42.14*/controllers/*42.25*/.rrhh.routes.AgentesSeguimientoController.editarAgenteSeguimiento(agenteSeguimiento.id))),_display_(Seq[Any](/*42.113*/UriTrack/*42.121*/.get("&"))),format.raw/*42.130*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*43.14*/controllers/*43.25*/.rrhh.routes.AgentesSeguimientoController.eliminarAgenteSeguimiento(agenteSeguimiento.id))),_display_(Seq[Any](/*43.115*/UriTrack/*43.123*/.get("&"))),format.raw/*43.132*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*46.14*/UriTrack/*46.22*/.getOnNull(controllers.rrhh.routes.AgentesSeguimientoController.index().absoluteURL()))),format.raw/*46.108*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	<input type="hidden" id="agenteId" name="agenteId" value=""""),_display_(Seq[Any](/*49.61*/agenteSeguimiento/*49.78*/.id)),format.raw/*49.81*/(""""/>
	"""),_display_(Seq[Any](/*50.3*/views/*50.8*/.html.tags.successError())),format.raw/*50.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">Agente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*55.50*/agenteSeguimiento/*55.67*/.agente.apellido)),format.raw/*55.83*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Inicio</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*61.50*/if(agenteSeguimiento.fincio != null)/*61.86*/{_display_(Seq[Any](_display_(Seq[Any](/*61.88*/(utils.DateUtils.formatDate(agenteSeguimiento.fincio))))))})),format.raw/*61.143*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fin</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*67.50*/if(agenteSeguimiento.ffin != null)/*67.84*/{_display_(Seq[Any](_display_(Seq[Any](/*67.86*/(utils.DateUtils.formatDate(agenteSeguimiento.ffin))))))})),format.raw/*67.139*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
		<label class="control-label">Tipo </label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*72.48*/if(agenteSeguimiento.tipoAgenteSeguimiento != null)/*72.99*/{_display_(Seq[Any](_display_(Seq[Any](/*72.101*/agenteSeguimiento/*72.118*/.tipoAgenteSeguimiento.nombre))))})),format.raw/*72.148*/("""</p> 
		</div>
	</div>	
	
	"""),_display_(Seq[Any](/*76.3*/views/*76.8*/.html.rrhh.agenteSeguimientos.tabsAgenteSeguimiento(false, agenteSeguimientoForm,agenteSeguimiento))),format.raw/*76.107*/("""
	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*78.26*/agenteSeguimiento/*78.43*/.estado.nombre)),format.raw/*78.57*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*81.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(agenteSeguimiento.estado.orden,models.Estado.AGENTE_SEGUIMIENTO)) yield /*81.126*/ {_display_(Seq[Any](format.raw/*81.128*/("""	
			"""),_display_(Seq[Any](/*82.5*/if(estado.orden <= 4)/*82.26*/ {_display_(Seq[Any](format.raw/*82.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*84.16*/controllers/*84.27*/.rrhh.routes.AgentesSeguimientoController.cambiarEstado(agenteSeguimiento.id, estado.id.toLong))),_display_(Seq[Any](/*84.123*/UriTrack/*84.131*/.get("&"))),format.raw/*84.140*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*85.56*/estado/*85.62*/.nombre)),format.raw/*85.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*89.5*/("""
		""")))})),format.raw/*90.4*/("""
		
		"""),_display_(Seq[Any](/*92.4*/if(agenteSeguimiento.estado.id == models.Estado.AGENTE_SEGUIMIENTO_CERRADO)/*92.79*/ {_display_(Seq[Any](format.raw/*92.81*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*94.15*/controllers/*94.26*/.rrhh.routes.AgentesSeguimientoController.cambiarEstado(agenteSeguimiento.id, models.Estado.AGENTE_SEGUIMIENTO_BORRADOR))),_display_(Seq[Any](/*94.147*/UriTrack/*94.155*/.get("&"))),format.raw/*94.164*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*98.4*/else/*98.8*/{_display_(Seq[Any](format.raw/*98.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*100.15*/controllers/*100.26*/.rrhh.routes.AgentesSeguimientoController.cambiarEstado(agenteSeguimiento.id, models.Estado.AGENTE_SEGUIMIENTO_CERRADO))),_display_(Seq[Any](/*100.146*/UriTrack/*100.154*/.get("&"))),format.raw/*100.163*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cerrar
				</a>
			</div>
		""")))})),format.raw/*104.4*/("""
		
		
	</div>
	
""")))})))}
    }
    
    def render(agenteSeguimiento:AgenteSeguimiento,agenteSeguimientoForm:Form[AgenteSeguimiento],paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(agenteSeguimiento,agenteSeguimientoForm,paginadorFicha)
    
    def f:((AgenteSeguimiento,Form[AgenteSeguimiento],utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (agenteSeguimiento,agenteSeguimientoForm,paginadorFicha) => apply(agenteSeguimiento,agenteSeguimientoForm,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/verAgenteSeguimiento.scala.html
                    HASH: b3c60905d9834fa66340549c3427bcfd708218a8
                    MATRIX: 880->1|1143->190|1157->197|1241->201|1292->217|1306->223|1368->264|1435->302|1467->326|1542->133|1569->300|1597->370|1636->374|1649->379|1708->429|1748->431|2800->1447|2820->1458|2908->1524|3040->1620|3060->1631|3179->1719|3197->1727|3229->1736|3357->1828|3377->1839|3498->1929|3516->1937|3548->1946|3748->2110|3765->2118|3874->2204|4061->2355|4087->2372|4112->2375|4153->2381|4166->2386|4213->2411|4419->2581|4445->2598|4483->2614|4693->2788|4738->2824|4786->2826|4868->2881|5075->3052|5118->3086|5166->3088|5246->3141|5423->3282|5483->3333|5532->3335|5559->3352|5616->3382|5679->3410|5692->3415|5814->3514|5878->3542|5904->3559|5940->3573|6027->3625|6166->3747|6207->3749|6248->3755|6278->3776|6318->3778|6397->3821|6417->3832|6544->3928|6562->3936|6594->3945|6712->4027|6727->4033|6756->4040|6818->4071|6853->4075|6895->4082|6979->4157|7019->4159|7096->4200|7116->4211|7268->4332|7286->4340|7318->4349|7456->4469|7468->4473|7506->4474|7584->4515|7605->4526|7757->4646|7776->4654|7809->4663|7949->4771
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|73->41|73->41|73->41|74->42|74->42|74->42|74->42|74->42|75->43|75->43|75->43|75->43|75->43|78->46|78->46|78->46|81->49|81->49|81->49|82->50|82->50|82->50|87->55|87->55|87->55|93->61|93->61|93->61|93->61|99->67|99->67|99->67|99->67|104->72|104->72|104->72|104->72|104->72|108->76|108->76|108->76|110->78|110->78|110->78|113->81|113->81|113->81|114->82|114->82|114->82|116->84|116->84|116->84|116->84|116->84|117->85|117->85|117->85|121->89|122->90|124->92|124->92|124->92|126->94|126->94|126->94|126->94|126->94|130->98|130->98|130->98|132->100|132->100|132->100|132->100|132->100|136->104
                    -- GENERATED --
                */
            