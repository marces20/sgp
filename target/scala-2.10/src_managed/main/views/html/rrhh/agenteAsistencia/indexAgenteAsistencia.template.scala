
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
object indexAgenteAsistencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Agente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Agente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*5.63*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.rrhh.mainRrhh("Lista Agentes Asistencias",scripts)/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Agentes Asistencias</h1>
			</div>
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/views/*20.8*/.html.tags.successError())),format.raw/*20.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchAgenteAsistencia" method="GET">
			 
			<div class="row">	  
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*29.8*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*29.67*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">Cuit
						"""),_display_(Seq[Any](/*36.8*/inputText(formBuscador("cuit"), 'class -> "form-control"))),format.raw/*36.65*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">DNI
						"""),_display_(Seq[Any](/*43.8*/inputText(formBuscador("dni"), 'class -> "form-control"))),format.raw/*43.64*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						Activo
						"""),_display_(Seq[Any](/*50.8*/select(formBuscador("activo"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*50.109*/("""
					</label>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="cuit" class="control-label">Tipo Relacion
						"""),_display_(Seq[Any](/*56.8*/select(formBuscador("tipo_relacion_laboral"), 
						TipoRelacionLaboral.find.all().map { p => p.id.toString -> p.nombre}, 
						'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*58.67*/("""
						</label>
					</div>
				</div>
				
				
			</div>
				
			<div class="row" >	
				<div class="col-sm-6">
					<div class="form-group">
						<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
						"""),_display_(Seq[Any](/*70.8*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*70.99*/("""
						"""),_display_(Seq[Any](/*71.8*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden"))),format.raw/*71.69*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*83.16*/controllers/*83.27*/.rrhh.routes.AgentesAsistenciasController.index())),format.raw/*83.76*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		</form>
	</div>
	"""),_display_(Seq[Any](/*90.3*/if(buscador.getTotalRowCount == 0)/*90.37*/ {_display_(Seq[Any](format.raw/*90.39*/("""
        
        <div class="well">
            <em>No se encuentran Agentes</em>
        </div>
        
    """)))}/*96.7*/else/*96.12*/{_display_(Seq[Any](format.raw/*96.13*/("""
    	Mostrando """),_display_(Seq[Any](/*97.17*/buscador/*97.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*97.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th>Apellido y Nombre</th>
					<th>DNI</th>
					<th>Cuit</th>
					<th>Organigrama</th>
					<th>Profesion</th>
					<th>Especialidad</th>
					<th>Puesto</th>
					<th>Relacion</th>
					<th width="30">Activo</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*115.5*/for(agente <- buscador.getList) yield /*115.36*/ {_display_(Seq[Any](format.raw/*115.38*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*116.37*/controllers/*116.48*/.rrhh.routes.AgentesAsistenciasController.ver(agente.id))),format.raw/*116.104*/("""&"""),_display_(Seq[Any](/*116.106*/UriTrack/*116.114*/.encode())),format.raw/*116.123*/("""">
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*118.61*/controllers/*118.72*/.rrhh.routes.AgentesAsistenciasController.editar(agente.id))),format.raw/*118.131*/("""&"""),_display_(Seq[Any](/*118.133*/UriTrack/*118.141*/.encode())),format.raw/*118.150*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*122.11*/(agente.apellido))),format.raw/*122.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*123.11*/(agente.dni))),format.raw/*123.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*124.11*/(agente.cuit))),format.raw/*124.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*125.11*/if(agente.organigrama != null)/*125.41*/{_display_(Seq[Any](_display_(Seq[Any](/*125.43*/(agente.organigrama.nombre)))))})),format.raw/*125.71*/("""</td>
					<td>"""),_display_(Seq[Any](/*126.11*/if(agente.profesion != null)/*126.39*/{_display_(Seq[Any](_display_(Seq[Any](/*126.41*/(agente.profesion.nombre)))))})),format.raw/*126.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*127.11*/if(agente.especialidad != null)/*127.42*/{_display_(Seq[Any](_display_(Seq[Any](/*127.44*/(agente.especialidad.nombre)))))})),format.raw/*127.73*/("""</td>
					<td>"""),_display_(Seq[Any](/*128.11*/if(agente.puesto != null)/*128.36*/{_display_(Seq[Any](_display_(Seq[Any](/*128.38*/(agente.puesto.nombre)))))})),format.raw/*128.61*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*130.8*/agente/*130.14*/.tipo_relacion_laboral/*130.36*/ match/*130.42*/ {/*131.10*/case "1" =>/*131.21*/ {_display_(Seq[Any](format.raw/*131.23*/("""Contrato Relacion Parque de la salud""")))}/*132.7*/case "2" =>/*132.18*/ {_display_(Seq[Any](format.raw/*132.20*/("""Monotributo Parque de la salud""")))}/*133.7*/case "3" =>/*133.18*/ {_display_(Seq[Any](format.raw/*133.20*/("""Contrato Relacion Convenio Ministerio Salud""")))}/*134.7*/case "4" =>/*134.18*/ {_display_(Seq[Any](format.raw/*134.20*/("""Planta Ministerio Salud""")))}/*135.7*/case "5" =>/*135.18*/ {_display_(Seq[Any](format.raw/*135.20*/("""Contrato Relacion Ministerio Salud""")))}/*136.7*/case "6" =>/*136.18*/ {_display_(Seq[Any](format.raw/*136.20*/("""Adscripto Otras Entidades""")))}/*137.10*/case _ =>/*137.19*/ {}})),format.raw/*138.8*/("""		
					</td>
					<td>"""),_display_(Seq[Any](/*140.11*/if(agente.activo != null)/*140.36*/{_display_(Seq[Any](_display_(Seq[Any](/*140.38*/if(agente.activo)/*140.55*/ {_display_(Seq[Any](format.raw/*140.57*/("""Si""")))}/*140.61*/else/*140.66*/{_display_(Seq[Any](format.raw/*140.67*/("""No""")))}))))}/*140.72*/else/*140.76*/{_display_(Seq[Any](format.raw/*140.77*/("""falta cargar""")))})),format.raw/*140.90*/("""</td>
				</tr>	
			""")))})),format.raw/*142.5*/("""		
			</tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*147.8*/views/*147.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.AgentesAsistenciasController.index()))),format.raw/*147.108*/("""
		</div>
    """)))})),format.raw/*149.6*/("""



""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Agente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Agente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/indexAgenteAsistencia.scala.html
                    HASH: a0f037f710c5f780adcb6bb813f40cb4dae73ed7
                    MATRIX: 853->1|1036->110|1050->117|1134->121|1185->137|1199->143|1261->184|1328->222|1360->246|1434->75|1461->220|1489->290|1527->294|1539->299|1603->355|1642->357|1860->540|1873->545|1920->570|2190->805|2271->864|2460->1018|2539->1075|2727->1228|2805->1284|2962->1406|3086->1507|3271->1657|3483->1847|3758->2087|3871->2178|3914->2186|3997->2247|4400->2614|4420->2625|4491->2674|4636->2784|4679->2818|4719->2820|4849->2933|4862->2938|4901->2939|4954->2956|4971->2964|5025->2996|5439->3374|5487->3405|5528->3407|5602->3444|5623->3455|5703->3511|5743->3513|5762->3521|5795->3530|5941->3639|5962->3650|6045->3709|6085->3711|6104->3719|6137->3728|6257->3811|6297->3828|6350->3844|6385->3856|6438->3872|6474->3885|6527->3901|6567->3931|6616->3933|6671->3961|6724->3977|6762->4005|6811->4007|6864->4033|6917->4049|6958->4080|7007->4082|7063->4111|7116->4127|7151->4152|7200->4154|7250->4177|7309->4200|7325->4206|7357->4228|7373->4234|7385->4246|7406->4257|7447->4259|7503->4303|7524->4314|7565->4316|7615->4354|7636->4365|7677->4367|7740->4418|7761->4429|7802->4431|7845->4462|7866->4473|7907->4475|7961->4517|7982->4528|8023->4530|8069->4566|8088->4575|8114->4586|8175->4610|8210->4635|8259->4637|8286->4654|8327->4656|8350->4660|8364->4665|8404->4666|8432->4671|8446->4675|8486->4676|8532->4689|8585->4710|8701->4790|8716->4795|8835->4890|8882->4905
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|51->20|51->20|51->20|60->29|60->29|67->36|67->36|74->43|74->43|81->50|81->50|87->56|89->58|101->70|101->70|102->71|102->71|114->83|114->83|114->83|121->90|121->90|121->90|127->96|127->96|127->96|128->97|128->97|128->97|146->115|146->115|146->115|147->116|147->116|147->116|147->116|147->116|147->116|149->118|149->118|149->118|149->118|149->118|149->118|153->122|153->122|154->123|154->123|155->124|155->124|156->125|156->125|156->125|156->125|157->126|157->126|157->126|157->126|158->127|158->127|158->127|158->127|159->128|159->128|159->128|159->128|161->130|161->130|161->130|161->130|161->131|161->131|161->131|161->132|161->132|161->132|161->133|161->133|161->133|161->134|161->134|161->134|161->135|161->135|161->135|161->136|161->136|161->136|161->137|161->137|161->138|163->140|163->140|163->140|163->140|163->140|163->140|163->140|163->140|163->140|163->140|163->140|163->140|165->142|170->147|170->147|170->147|172->149
                    -- GENERATED --
                */
            