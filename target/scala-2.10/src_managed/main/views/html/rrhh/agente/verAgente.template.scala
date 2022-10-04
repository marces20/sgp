
package views.html.rrhh.agente

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
object verAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Agente],Agente,List[models.haberes.PuestoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteForm: Form[Agente],agente:Agente,pl:List[models.haberes.PuestoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*5.63*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.rrhh.mainRrhh("Vista Agente",scripts)/*9.50*/ {_display_(Seq[Any](format.raw/*9.52*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-5">
				<h1>Vista de Agente</h1>
			</div>
			<div class="col-sm-7">
				<div class="dropdown pull-right">
				 	<button class="btn btn-default dropdown-toggle btn-header" type="button" id="dropdownMenu1" data-toggle="dropdown">
					 	<i class="glyphicon glyphicon-list-alt"></i>
					    Acciones
					    <span class="caret"></span>
				  	</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a data-url=""""),_display_(Seq[Any](/*23.47*/controllers/*23.58*/.rrhh.routes.AgentesAccionesController.modalReplicarProveedor(agente.id))),format.raw/*23.130*/("""" role="menuitem" id="replicarProveedor" tabindex="-1" href="#">Replicar en Proveedor</a></li>
				  </ul>
				</div>
				<div class="dropdown pull-right">
				 	<button class="btn btn-default dropdown-toggle btn-header" type="button" id="dropdownMenu1" data-toggle="dropdown">
					 	<i class="glyphicon glyphicon-list-alt"></i>
					    Reportes
					    <span class="caret"></span>
				  	</button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a href=""""),_display_(Seq[Any](/*33.43*/controllers/*33.54*/.rrhh.routes.AgentesReportesController.ficha(agente.id))),format.raw/*33.109*/("""" role="menuitem" id="" tabindex="-1" href="#">Ficha</a></li>
				    <li role="presentation"><a href=""""),_display_(Seq[Any](/*34.43*/controllers/*34.54*/.rrhh.routes.AgentesReportesController.fichaAptitud(agente.id))),format.raw/*34.116*/("""" role="menuitem" id="" tabindex="-1" href="#">Ficha Aptitud Psico-Fisico</a></li>
				  </ul>
				</div>
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*42.14*/controllers/*42.25*/.rrhh.routes.AgentesController.crearAgente())),format.raw/*42.69*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*43.14*/controllers/*43.25*/.rrhh.routes.AgentesController.editarAgente(agente.id))),_display_(Seq[Any](/*43.80*/UriTrack/*43.88*/.get("&"))),format.raw/*43.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*44.14*/controllers/*44.25*/.rrhh.routes.AgentesController.eliminarAgente(agente.id))),_display_(Seq[Any](/*44.82*/UriTrack/*44.90*/.get("&"))),format.raw/*44.99*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*47.14*/UriTrack/*47.22*/.getOnNull(controllers.rrhh.routes.AgentesController.indexAgente().absoluteURL()))),format.raw/*47.103*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="agenteId" name="agenteId" value=""""),_display_(Seq[Any](/*51.61*/agente/*51.67*/.id)),format.raw/*51.70*/(""""/>
	"""),_display_(Seq[Any](/*52.3*/views/*52.8*/.html.tags.successError())),format.raw/*52.33*/("""
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Apellido y Nombre</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*57.50*/agente/*57.56*/.apellido)),format.raw/*57.65*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<b>Tipo de relación</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*66.9*/inputRadioGroup(agenteForm("planta"), options = Seq("true"->"Planta"), 'disabled -> "disabled"))),format.raw/*66.104*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*73.9*/inputRadioGroup(agenteForm("planta"),options = Seq("false"->"Contratado"), 'disabled -> "disabled"))),format.raw/*73.108*/("""
						</label>
					</div>
				</div>
			</div>
		</div> 
		
		<div class="col-sm-2">
			<b>¿Agente activo?</b>
			<div class="row">
				<div class="col-sm-3">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*86.9*/inputRadioGroup(agenteForm("activo"), options = Seq("true"->"Si"), 'disabled -> "disabled"))),format.raw/*86.100*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-9">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*93.9*/inputRadioGroup(agenteForm("activo"),options = Seq("false"->"No"), 'disabled -> "disabled"))),format.raw/*93.100*/("""
						</label>
					</div>
				</div>
			</div>
		</div> 	
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Tipo Relacion Laboral</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*103.7*/agente/*103.13*/.tipo_relacion_laboral/*103.35*/ match/*103.41*/ {/*104.10*/case "1" =>/*104.21*/ {_display_(Seq[Any](format.raw/*104.23*/("""Contrato Relacion Parque de la salud""")))}/*105.7*/case "2" =>/*105.18*/ {_display_(Seq[Any](format.raw/*105.20*/("""Contrato Sin Relacion Parque de la salud""")))}/*106.7*/case "3" =>/*106.18*/ {_display_(Seq[Any](format.raw/*106.20*/("""Contrato Relacion Convenio Ministerio Salud""")))}/*107.7*/case "4" =>/*107.18*/ {_display_(Seq[Any](format.raw/*107.20*/("""Planta Ministerio Salud""")))}/*108.7*/case "5" =>/*108.18*/ {_display_(Seq[Any](format.raw/*108.20*/("""Contrato Relacion Ministerio Salud""")))}/*109.7*/case "6" =>/*109.18*/ {_display_(Seq[Any](format.raw/*109.20*/("""Adscripto Otras Entidades""")))}/*110.7*/case "7" =>/*110.18*/ {_display_(Seq[Any](format.raw/*110.20*/("""Contrato Convenio Nacion""")))}/*111.7*/case "8" =>/*111.18*/ {_display_(Seq[Any](format.raw/*111.20*/("""Planta Temporaria - Otras Entidades""")))}/*112.7*/case "9" =>/*112.18*/ {_display_(Seq[Any](format.raw/*112.20*/("""Otro""")))}/*113.10*/case _ =>/*113.19*/ {}})),format.raw/*114.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Matr&iacute;cula</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*121.50*/agente/*121.56*/.pin)),format.raw/*121.60*/("""</p>
			</div>
		</div> 
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Documento</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*129.50*/agente/*129.56*/.dni)),format.raw/*129.60*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Cuil</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*135.50*/agente/*135.56*/.cuit)),format.raw/*135.61*/("""</p>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="creacion_orden_compra" class="control-label"> Sexo</label>
				<p class="form-control-static form-control">
				
					"""),_display_(Seq[Any](/*143.7*/agente/*143.13*/.sexo/*143.18*/ match/*143.24*/ {/*144.10*/case "male" =>/*144.24*/ {_display_(Seq[Any](format.raw/*144.26*/("""Masculino""")))}/*145.10*/case "famele" =>/*145.26*/ {_display_(Seq[Any](format.raw/*145.28*/("""Femenino""")))}/*146.10*/case _ =>/*146.19*/ {}})),format.raw/*147.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Nacimiento</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*154.50*/agenteForm("fnacimiento")/*154.75*/.value)),format.raw/*154.81*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Estado Civil</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*161.7*/agente/*161.13*/.estado_civil/*161.26*/ match/*161.32*/ {/*162.10*/case "1" =>/*162.21*/ {_display_(Seq[Any](format.raw/*162.23*/("""Soltero/a""")))}/*163.7*/case "2" =>/*163.18*/ {_display_(Seq[Any](format.raw/*163.20*/("""Casado/a""")))}/*164.7*/case "3" =>/*164.18*/ {_display_(Seq[Any](format.raw/*164.20*/("""Separado/a de Hecho""")))}/*165.7*/case "4" =>/*165.18*/ {_display_(Seq[Any](format.raw/*165.20*/("""Unido de Hecho""")))}/*166.7*/case "5" =>/*166.18*/ {_display_(Seq[Any](format.raw/*166.20*/("""Separado Legal""")))}/*167.7*/case "6" =>/*167.18*/ {_display_(Seq[Any](format.raw/*167.20*/("""Divorciado""")))}/*168.7*/case "7" =>/*168.18*/ {_display_(Seq[Any](format.raw/*168.20*/("""Viudo/a""")))}/*169.7*/case "8" =>/*169.18*/ {_display_(Seq[Any](format.raw/*169.20*/("""Concubinato""")))}/*170.7*/case "9" =>/*170.18*/ {_display_(Seq[Any](format.raw/*170.20*/("""En Blanco""")))}/*171.10*/case _ =>/*171.19*/ {}})),format.raw/*172.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Matrimonio</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*179.50*/agenteForm("finicio_matrimonio")/*179.82*/.value)),format.raw/*179.88*/(""" </p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Ingreso Principal</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*187.50*/agenteForm("fingresooriginal")/*187.80*/.value)),format.raw/*187.86*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Ingreso</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*193.50*/agenteForm("fingreso")/*193.72*/.value)),format.raw/*193.78*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Baja</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*199.50*/agenteForm("fbaja")/*199.69*/.value)),format.raw/*199.75*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">N° Legajo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*205.50*/agenteForm("legajos[0].numero")/*205.81*/.value)),format.raw/*205.87*/(""" </p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">N° Legajo Externo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*211.50*/agenteForm("nro_legajo_externo")/*211.82*/.value)),format.raw/*211.88*/(""" </p>
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Asignaciones Familiares</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*219.7*/if(agenteForm("asignacion_familiar").value == "true")/*219.60*/{_display_(Seq[Any](format.raw/*219.61*/("""SI""")))}/*219.64*/else/*219.68*/{_display_(Seq[Any](format.raw/*219.69*/("""NO""")))})),format.raw/*219.72*/("""
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Licencia Conducir</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*227.49*/if(agente.tipo_licencia_conducir_id != null)/*227.93*/{_display_(Seq[Any](_display_(Seq[Any](/*227.95*/agente/*227.101*/.tipoLicenciaConducir.nombre))))})),format.raw/*227.130*/("""</p>
				 			
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha L.Conducir</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*233.50*/agenteForm("flicencia_conducir")/*233.82*/.value)),format.raw/*233.88*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">C.U.D.</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*239.50*/agenteForm("cud")/*239.67*/.value)),format.raw/*239.73*/("""</p>
			</div>
		</div>
	</div>	
	<!-- <div class="row">
		<div class="col-sm-12">
			<hr>
			<h3>Datos Conyuge</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputConyugueNombre" class="control-label">Nombre</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*253.50*/agente/*253.56*/.conyugue_nombre)),format.raw/*253.72*/("""</p>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputConyugueDni" class="control-label">DNI</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*259.50*/agente/*259.56*/.conyugue_dni)),format.raw/*259.69*/("""</p>
			</div>
		</div> 
	</div> -->
	<div class="row">
		<div class="col-sm-12">
			<hr>
			<h3>Datos Contactos</h3>
		</div>
	</div>
	<div class="row">
		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="inputCalle" class="control-label">Calle Banco</label> 
					<p class="form-control-static form-control">"""),_display_(Seq[Any](/*274.51*/agente/*274.57*/.calle_banco)),format.raw/*274.69*/("""</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="inputCalle" class="control-label">Calle</label> 
					<p class="form-control-static form-control">"""),_display_(Seq[Any](/*280.51*/agente/*280.57*/.calle)),format.raw/*280.63*/("""</p>
				</div>
			</div> 
		
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputNumero" class="control-label">Número</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*287.50*/agente/*287.56*/.numero)),format.raw/*287.63*/("""</p>
			</div>
		</div>
		<div class="col-sm-1">
			<div class="form-group">
				<label for="inputPiso" class="control-label">Piso</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*293.50*/agente/*293.56*/.piso)),format.raw/*293.61*/("""</p>
			</div>
		</div>
		<div class="col-sm-1">
			<div class="form-group">
				<label for="inputDepto" class="control-label">Depto</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*299.50*/agente/*299.56*/.depto)),format.raw/*299.62*/("""</p>
			</div>
		</div> 
		<div class="col-sm-1">
			<div class="form-group">
				<label for="inputCP" class="control-label">C.P</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*305.50*/agente/*305.56*/.zip)),format.raw/*305.60*/("""</p>
			</div>
		</div> 
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputTelefono" class="control-label">Tel&eacute;fono</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*313.50*/agente/*313.56*/.telefono)),format.raw/*313.65*/("""</p>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputCelular" class="control-label">Celular</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*319.50*/agente/*319.56*/.mobile)),format.raw/*319.63*/("""</p>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputFax" class="control-label">Tel. Alternativo</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*325.50*/agente/*325.56*/.fax)),format.raw/*325.60*/("""</p>
			</div>
		</div> 
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*331.50*/agente/*331.56*/.email)),format.raw/*331.62*/("""</p>
			</div>
		</div> 
	</div>
	<div class="row contenedorUbicacion">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="" class="control-label">País</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*339.50*/if(agente.localidad!= null)/*339.77*/{_display_(Seq[Any](_display_(Seq[Any](/*339.79*/agente/*339.85*/.localidad.provincia.pais.nombre))))})),format.raw/*339.118*/("""</p>
			</div>
		</div>
	
		<div class="col-sm-4">
			<div class="seleccionProvincia form-group">
				<label for="" class="control-label">Provincia</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*346.50*/if(agente.localidad!= null)/*346.77*/{_display_(Seq[Any](_display_(Seq[Any](/*346.79*/agente/*346.85*/.localidad.provincia.nombre))))})),format.raw/*346.113*/("""</p>
			</div>
		</div>
	
		<div class="col-sm-4">
			<div class="seleccionLocalidad form-group">
				<label for="" class="control-label">Localidad</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*353.50*/if(agente.localidad!= null)/*353.77*/{_display_(Seq[Any](_display_(Seq[Any](/*353.79*/agente/*353.85*/.localidad.nombre))))})),format.raw/*353.103*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<hr>
			<h3>Datos Ocupación</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-8">
			<div class="form-group">
				<label class="control-label">Departamento/Servicio</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*367.50*/if(agente.organigrama != null)/*367.80*/{_display_(Seq[Any](_display_(Seq[Any](/*367.82*/agente/*367.88*/.organigrama.nombre))))})),format.raw/*367.108*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Profesion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*373.50*/if(agente.profesion != null)/*373.78*/{_display_(Seq[Any](_display_(Seq[Any](/*373.80*/agente/*373.86*/.profesion.nombre))))})),format.raw/*373.104*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<!--  <div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Departamento</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*381.50*/if(agente.departamento != null)/*381.81*/{_display_(Seq[Any](_display_(Seq[Any](/*381.83*/agente/*381.89*/.departamento.nombre))))})),format.raw/*381.110*/("""</p>
			</div>
		</div>-->
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Residencia</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*387.50*/if(agente.tipoResidencia != null)/*387.83*/{_display_(Seq[Any](_display_(Seq[Any](/*387.85*/agente/*387.91*/.tipoResidencia.nombre))))})),format.raw/*387.114*/("""</p>
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Especialidad</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*394.50*/if(agente.especialidad != null)/*394.81*/{_display_(Seq[Any](_display_(Seq[Any](/*394.83*/agente/*394.89*/.especialidad.nombre))))})),format.raw/*394.110*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Puesto</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*400.50*/if(agente.puesto != null)/*400.75*/{_display_(Seq[Any](_display_(Seq[Any](/*400.77*/agente/*400.83*/.puesto.nombre))))})),format.raw/*400.98*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			"""),_display_(Seq[Any](/*406.5*/views/*406.10*/.html.rrhh.agente.contenidoTabNovedad(false, agenteForm, agente:Agente))),format.raw/*406.81*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*411.3*/views/*411.8*/.html.rrhh.agente.tabsAgente(false,agenteForm,agente,pl))),format.raw/*411.64*/("""
	<hr/>
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*413.26*/agente/*413.32*/.estado.nombre)),format.raw/*413.46*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*415.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(agente.estado.orden,models.Estado.TIPO_AGENTE)) yield /*415.108*/ {_display_(Seq[Any](format.raw/*415.110*/("""	
			"""),_display_(Seq[Any](/*416.5*/if(estado.orden <= 5)/*416.26*/ {_display_(Seq[Any](format.raw/*416.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*418.16*/controllers/*418.27*/.rrhh.routes.AgentesController.cambiarEstado(agenteForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*418.126*/UriTrack/*418.134*/.get("&"))),format.raw/*418.143*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*419.56*/estado/*419.62*/.nombre)),format.raw/*419.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*423.5*/("""
		""")))})),format.raw/*424.4*/("""
		"""),_display_(Seq[Any](/*425.4*/if(agente.estado.id == models.Estado.AGENTE_CANCELADO)/*425.58*/ {_display_(Seq[Any](format.raw/*425.60*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*427.15*/controllers/*427.26*/.rrhh.routes.AgentesController.cambiarEstado(agenteForm.field("id").value.toInt, models.Estado.AGENTE_BORRADOR))),_display_(Seq[Any](/*427.138*/UriTrack/*427.146*/.get("&"))),format.raw/*427.155*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*431.4*/else/*431.8*/{_display_(Seq[Any](format.raw/*431.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*433.15*/controllers/*433.26*/.rrhh.routes.AgentesController.cambiarEstado(agenteForm.field("id").value.toInt, models.Estado.AGENTE_CANCELADO))),_display_(Seq[Any](/*433.139*/UriTrack/*433.147*/.get("&"))),format.raw/*433.156*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Agente
				</a>
			</div>
		""")))})),format.raw/*437.4*/("""
	</div>
""")))})))}
    }
    
    def render(agenteForm:Form[Agente],agente:Agente,pl:List[models.haberes.PuestoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(agenteForm,agente,pl)
    
    def f:((Form[Agente],Agente,List[models.haberes.PuestoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (agenteForm,agente,pl) => apply(agenteForm,agente,pl)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/verAgente.scala.html
                    HASH: 63e4c10b9c4392d1b6de09baa3bd6eea9020d074
                    MATRIX: 838->1|1025->114|1039->121|1123->125|1174->141|1188->147|1250->188|1317->226|1349->250|1423->79|1450->224|1478->294|1516->298|1528->303|1579->346|1618->348|2200->894|2220->905|2315->977|2872->1498|2892->1509|2970->1564|3110->1668|3130->1679|3215->1741|3458->1948|3478->1959|3544->2003|3676->2099|3696->2110|3781->2165|3798->2173|3829->2182|3957->2274|3977->2285|4064->2342|4081->2350|4112->2359|4312->2523|4329->2531|4433->2612|4622->2765|4637->2771|4662->2774|4703->2780|4716->2785|4763->2810|4980->2991|4995->2997|5026->3006|5255->3200|5373->3295|5544->3431|5666->3530|5932->3761|6046->3852|6217->3988|6331->4079|6598->4310|6614->4316|6646->4338|6662->4344|6674->4356|6695->4367|6736->4369|6792->4413|6813->4424|6854->4426|6914->4474|6935->4485|6976->4487|7039->4538|7060->4549|7101->4551|7144->4582|7165->4593|7206->4595|7260->4637|7281->4648|7322->4650|7367->4683|7388->4694|7429->4696|7473->4728|7494->4739|7535->4741|7590->4784|7611->4795|7652->4797|7677->4812|7696->4821|7722->4831|7948->5020|7964->5026|7991->5030|8233->5235|8249->5241|8276->5245|8485->5417|8501->5423|8529->5428|8778->5641|8794->5647|8809->5652|8825->5658|8837->5670|8861->5684|8902->5686|8932->5706|8958->5722|8999->5724|9028->5743|9047->5752|9073->5762|9299->5951|9334->5976|9363->5982|9585->6168|9601->6174|9624->6187|9640->6193|9652->6205|9673->6216|9714->6218|9743->6235|9764->6246|9805->6248|9833->6264|9854->6275|9895->6277|9934->6304|9955->6315|9996->6317|10030->6339|10051->6350|10092->6352|10126->6374|10147->6385|10188->6387|10218->6405|10239->6416|10280->6418|10307->6433|10328->6444|10369->6446|10400->6465|10421->6476|10462->6478|10492->6498|10511->6507|10537->6517|10763->6706|10805->6738|10834->6744|11090->6963|11130->6993|11159->6999|11377->7180|11409->7202|11438->7208|11653->7386|11682->7405|11711->7411|11925->7588|11966->7619|11995->7625|12218->7811|12260->7843|12289->7849|12526->8050|12589->8103|12629->8104|12652->8107|12666->8111|12706->8112|12742->8115|12966->8302|13020->8346|13069->8348|13086->8354|13143->8383|13363->8566|13405->8598|13434->8604|13645->8778|13672->8795|13701->8801|14068->9131|14084->9137|14123->9153|14356->9349|14372->9355|14408->9368|14779->9702|14795->9708|14830->9720|15064->9917|15080->9923|15109->9929|15345->10128|15361->10134|15391->10141|15617->10330|15633->10336|15661->10341|15889->10532|15905->10538|15934->10544|16158->10731|16174->10737|16201->10741|16470->10973|16486->10979|16518->10988|16751->11184|16767->11190|16797->11197|17035->11398|17051->11404|17078->11408|17307->11600|17323->11606|17352->11612|17616->11839|17653->11866|17702->11868|17718->11874|17779->11907|18021->12112|18058->12139|18107->12141|18123->12147|18179->12175|18421->12380|18458->12407|18507->12409|18523->12415|18569->12433|18920->12747|18960->12777|19009->12779|19025->12785|19073->12805|19287->12982|19325->13010|19374->13012|19390->13018|19436->13036|19686->13249|19727->13280|19776->13282|19792->13288|19841->13309|20059->13490|20102->13523|20151->13525|20167->13531|20218->13554|20438->13737|20479->13768|20528->13770|20544->13776|20593->13797|20804->13971|20839->13996|20888->13998|20904->14004|20946->14019|21063->14100|21078->14105|21172->14176|21232->14200|21246->14205|21325->14261|21395->14294|21411->14300|21448->14314|21534->14364|21656->14468|21698->14470|21740->14476|21771->14497|21812->14499|21892->14542|21913->14553|22044->14652|22063->14660|22096->14669|22215->14751|22231->14757|22261->14764|22324->14795|22360->14799|22400->14803|22464->14857|22505->14859|22583->14900|22604->14911|22748->15023|22767->15031|22800->15040|22939->15160|22952->15164|22991->15165|23069->15206|23090->15217|23235->15330|23254->15338|23287->15347|23436->15464
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|54->23|54->23|54->23|64->33|64->33|64->33|65->34|65->34|65->34|73->42|73->42|73->42|74->43|74->43|74->43|74->43|74->43|75->44|75->44|75->44|75->44|75->44|78->47|78->47|78->47|82->51|82->51|82->51|83->52|83->52|83->52|88->57|88->57|88->57|97->66|97->66|104->73|104->73|117->86|117->86|124->93|124->93|134->103|134->103|134->103|134->103|134->104|134->104|134->104|134->105|134->105|134->105|134->106|134->106|134->106|134->107|134->107|134->107|134->108|134->108|134->108|134->109|134->109|134->109|134->110|134->110|134->110|134->111|134->111|134->111|134->112|134->112|134->112|134->113|134->113|134->114|141->121|141->121|141->121|149->129|149->129|149->129|155->135|155->135|155->135|163->143|163->143|163->143|163->143|163->144|163->144|163->144|163->145|163->145|163->145|163->146|163->146|163->147|170->154|170->154|170->154|177->161|177->161|177->161|177->161|177->162|177->162|177->162|177->163|177->163|177->163|177->164|177->164|177->164|177->165|177->165|177->165|177->166|177->166|177->166|177->167|177->167|177->167|177->168|177->168|177->168|177->169|177->169|177->169|177->170|177->170|177->170|177->171|177->171|177->172|184->179|184->179|184->179|192->187|192->187|192->187|198->193|198->193|198->193|204->199|204->199|204->199|210->205|210->205|210->205|216->211|216->211|216->211|224->219|224->219|224->219|224->219|224->219|224->219|224->219|232->227|232->227|232->227|232->227|232->227|238->233|238->233|238->233|244->239|244->239|244->239|258->253|258->253|258->253|264->259|264->259|264->259|279->274|279->274|279->274|285->280|285->280|285->280|292->287|292->287|292->287|298->293|298->293|298->293|304->299|304->299|304->299|310->305|310->305|310->305|318->313|318->313|318->313|324->319|324->319|324->319|330->325|330->325|330->325|336->331|336->331|336->331|344->339|344->339|344->339|344->339|344->339|351->346|351->346|351->346|351->346|351->346|358->353|358->353|358->353|358->353|358->353|372->367|372->367|372->367|372->367|372->367|378->373|378->373|378->373|378->373|378->373|386->381|386->381|386->381|386->381|386->381|392->387|392->387|392->387|392->387|392->387|399->394|399->394|399->394|399->394|399->394|405->400|405->400|405->400|405->400|405->400|411->406|411->406|411->406|416->411|416->411|416->411|418->413|418->413|418->413|420->415|420->415|420->415|421->416|421->416|421->416|423->418|423->418|423->418|423->418|423->418|424->419|424->419|424->419|428->423|429->424|430->425|430->425|430->425|432->427|432->427|432->427|432->427|432->427|436->431|436->431|436->431|438->433|438->433|438->433|438->433|438->433|442->437
                    -- GENERATED --
                */
            