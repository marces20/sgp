
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
object formAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Agente],Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteForm: Form[Agente],agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*4.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar agente"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*9.14*/if(request().getHeader("referer"))/*9.48*/{_display_(Seq[Any](format.raw/*9.49*/(""" """),_display_(Seq[Any](/*9.51*/request()/*9.60*/.getHeader("referer"))),format.raw/*9.81*/(""" """)))}/*9.84*/else/*9.89*/{_display_(Seq[Any](_display_(Seq[Any](/*9.91*/controllers/*9.102*/.rrhh.routes.AgentesController.indexAgente())),_display_(Seq[Any](/*9.147*/UriTrack/*9.155*/.decode()))))})),format.raw/*9.165*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/UriTrack/*12.22*/.decode())),format.raw/*12.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*13.5*/if(agenteForm.field("id").value)/*13.37*/{_display_(Seq[Any](format.raw/*13.38*/("""<a href=""""),_display_(Seq[Any](/*13.48*/controllers/*13.59*/.rrhh.routes.AgentesController.ver(agenteForm.field("id").value.toLong))),_display_(Seq[Any](/*13.131*/UriTrack/*13.139*/.get("&"))),format.raw/*13.148*/("""" title="Ver agente" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*13.247*/("""
		</div>
	</div>
	
	<input type="hidden" name="""),_display_(Seq[Any](/*17.29*/UriTrack/*17.37*/.getKey())),format.raw/*17.46*/(""" value=""""),_display_(Seq[Any](/*17.55*/UriTrack/*17.63*/.code())),format.raw/*17.70*/("""" />
	"""),_display_(Seq[Any](/*18.3*/inputText(agenteForm("id"), 'type -> "hidden", 'id -> "agenteId"))),format.raw/*18.68*/("""
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*21.28*/if(agenteForm.error("apellido") != null)/*21.68*/ {_display_(Seq[Any](format.raw/*21.70*/("""has-error""")))}/*21.80*/else/*21.84*/{_display_(Seq[Any](format.raw/*21.85*/("""has-required""")))})),format.raw/*21.98*/("""">
				<label for="inputNombre" class="control-label">Apellido y Nombre</label> 
				"""),_display_(Seq[Any](/*23.6*/inputText(agenteForm("apellido"), 'class -> "form-control"))),format.raw/*23.65*/("""
				"""),_display_(Seq[Any](/*24.6*/agenteForm("apellido")/*24.28*/.error.map/*24.38*/{ error =>_display_(Seq[Any](format.raw/*24.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*25.31*/error/*25.36*/.message)),format.raw/*25.44*/("""</div>
				""")))})),format.raw/*26.6*/("""
			</div>
		</div>
		<div class="col-sm-2 """),_display_(Seq[Any](/*29.25*/if(agenteForm.error("planta") != null)/*29.63*/ {_display_(Seq[Any](format.raw/*29.65*/("""has-error""")))}/*29.75*/else/*29.79*/{_display_(Seq[Any](format.raw/*29.80*/("""has-required""")))})),format.raw/*29.93*/("""">
			<b>Tipo de relación</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*35.9*/inputRadioGroup(agenteForm("planta"), options = Seq("true"->"Planta")))),format.raw/*35.79*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*42.9*/inputRadioGroup(agenteForm("planta"),options = Seq("false"->"Contratado")))),format.raw/*42.83*/("""
						</label>
					</div>
				</div>
			</div>
			"""),_display_(Seq[Any](/*47.5*/agenteForm("planta")/*47.25*/.error.map/*47.35*/{ error =>_display_(Seq[Any](format.raw/*47.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*48.30*/error/*48.35*/.message)),format.raw/*48.43*/("""</div>
			""")))})),format.raw/*49.5*/("""
		</div> 
		<div class="col-sm-2 """),_display_(Seq[Any](/*51.25*/if(agenteForm.error("activo") != null)/*51.63*/ {_display_(Seq[Any](format.raw/*51.65*/("""has-error""")))}/*51.75*/else/*51.79*/{_display_(Seq[Any](format.raw/*51.80*/("""has-required""")))})),format.raw/*51.93*/("""">
			<b>¿Agente activo?</b>
			<div class="row">
				<div class="col-sm-3">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*57.9*/inputRadioGroup(agenteForm("activo"), options = Seq("true"->"Si")))),format.raw/*57.75*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-9">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*64.9*/inputRadioGroup(agenteForm("activo"),options = Seq("false"->"No")))),format.raw/*64.75*/("""
						</label>
					</div>
				</div>
			</div>
			"""),_display_(Seq[Any](/*69.5*/agenteForm("activo")/*69.25*/.error.map/*69.35*/{ error =>_display_(Seq[Any](format.raw/*69.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*70.30*/error/*70.35*/.message)),format.raw/*70.43*/("""</div>
			""")))})),format.raw/*71.5*/("""
		</div> 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*74.28*/if(agenteForm.error("tipo_relacion_laboral") != null)/*74.81*/ {_display_(Seq[Any](format.raw/*74.83*/("""has-error""")))}/*74.93*/else/*74.97*/{_display_(Seq[Any](format.raw/*74.98*/("""has-required""")))})),format.raw/*74.111*/("""">
				<label for=""""),_display_(Seq[Any](/*75.18*/agenteForm("tipo_relacion_laboral"))),format.raw/*75.53*/("""" class="control-label">Tipo Relacion Laboral</label>
				"""),_display_(Seq[Any](/*76.6*/select(agenteForm("tipo_relacion_laboral"), 
				TipoRelacionLaboral.find.all().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*78.65*/("""
				
				"""),_display_(Seq[Any](/*80.6*/agenteForm("tipo_relacion_laboral")/*80.41*/.error.map/*80.51*/{ error =>_display_(Seq[Any](format.raw/*80.61*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*81.31*/error/*81.36*/.message)),format.raw/*81.44*/("""</div>
				""")))})),format.raw/*82.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputMatricula" class="control-label">Matr&iacute;cula</label> 
				"""),_display_(Seq[Any](/*88.6*/inputText(agenteForm("pin"), 'class -> "form-control"))),format.raw/*88.60*/("""
			</div>
		</div> 
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*94.28*/if(agenteForm.error("dni") != null)/*94.63*/ {_display_(Seq[Any](format.raw/*94.65*/("""has-error""")))}/*94.75*/else/*94.79*/{_display_(Seq[Any](format.raw/*94.80*/("""has-required""")))})),format.raw/*94.93*/("""">
				<label for="inputNombre" class="control-label">Documento</label> 
				"""),_display_(Seq[Any](/*96.6*/inputText(agenteForm("dni"), 'class -> "form-control", 'id -> "dni"))),format.raw/*96.74*/("""
				"""),_display_(Seq[Any](/*97.6*/agenteForm("dni")/*97.23*/.error.map/*97.33*/{ error =>_display_(Seq[Any](format.raw/*97.43*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*98.31*/error/*98.36*/.message)),format.raw/*98.44*/("""</div>
				""")))})),format.raw/*99.6*/("""
			</div>
		</div>
		<div class="col-sm-2 """),_display_(Seq[Any](/*102.25*/if(agenteForm.error("cuit") != null)/*102.61*/ {_display_(Seq[Any](format.raw/*102.63*/("""has-error""")))}/*102.73*/else/*102.77*/{_display_(Seq[Any](format.raw/*102.78*/("""has-required""")))})),format.raw/*102.91*/("""">
			<div class="form-group">
				<label for="inputCuit" class="control-label">Cuil</label> 
				"""),_display_(Seq[Any](/*105.6*/inputText(agenteForm("cuit"), 'class -> "form-control", 'id -> "cuit"))),format.raw/*105.76*/("""
			</div>
				"""),_display_(Seq[Any](/*107.6*/agenteForm("cuit")/*107.24*/.error.map/*107.34*/{ error =>_display_(Seq[Any](format.raw/*107.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*108.31*/error/*108.36*/.message)),format.raw/*108.44*/("""</div>
				""")))})),format.raw/*109.6*/("""
		</div> 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*112.28*/if(agenteForm.error("sexo") != null)/*112.64*/ {_display_(Seq[Any](format.raw/*112.66*/("""has-error""")))}/*112.76*/else/*112.80*/{_display_(Seq[Any](format.raw/*112.81*/("""has-required""")))})),format.raw/*112.94*/("""">
				<label for=""""),_display_(Seq[Any](/*113.18*/agenteForm("sexo"))),format.raw/*113.36*/("""" class="control-label">Sexo</label>
				"""),_display_(Seq[Any](/*114.6*/select(agenteForm("sexo"), options("male"->"Masculino","famele"->"Femenino"), 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*115.65*/("""
				"""),_display_(Seq[Any](/*116.6*/agenteForm("sexo")/*116.24*/.error.map/*116.34*/{ error =>_display_(Seq[Any](format.raw/*116.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*117.31*/error/*117.36*/.message)),format.raw/*117.44*/("""</div>
				""")))})),format.raw/*118.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*122.28*/if(agenteForm.error("fnacimiento") != null)/*122.71*/ {_display_(Seq[Any](format.raw/*122.73*/("""has-error""")))}/*122.83*/else/*122.87*/{_display_(Seq[Any](format.raw/*122.88*/("""has-required""")))})),format.raw/*122.101*/("""">
				<label for="inputNombre" class="control-label">Fecha nacimiento</label> 
				"""),_display_(Seq[Any](/*124.6*/inputText(agenteForm("fnacimiento"), 'class -> "form-control", 'id -> "nacimiento"))),format.raw/*124.89*/("""
				"""),_display_(Seq[Any](/*125.6*/agenteForm("fnacimiento")/*125.31*/.error.map/*125.41*/{ error =>_display_(Seq[Any](format.raw/*125.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*126.31*/error/*126.36*/.message)),format.raw/*126.44*/("""</div>
				""")))})),format.raw/*127.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*131.28*/if(agenteForm.error("estado_civil") != null)/*131.72*/ {_display_(Seq[Any](format.raw/*131.74*/("""has-error""")))}/*131.84*/else/*131.88*/{_display_(Seq[Any](format.raw/*131.89*/("""has-required""")))})),format.raw/*131.102*/("""">
				<label for=""""),_display_(Seq[Any](/*132.18*/agenteForm("estado_civil"))),format.raw/*132.44*/("""" class="control-label">Estado Civil</label>
				"""),_display_(Seq[Any](/*133.6*/select(agenteForm("estado_civil"), 
				EstadoCivil.find.all().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*135.65*/(""" 
				
				"""),_display_(Seq[Any](/*137.6*/agenteForm("estado_civil")/*137.32*/.error.map/*137.42*/{ error =>_display_(Seq[Any](format.raw/*137.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*138.31*/error/*138.36*/.message)),format.raw/*138.44*/("""</div>
				""")))})),format.raw/*139.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputFIngreso" class="control-label">Fecha Matrimonio</label> 
				"""),_display_(Seq[Any](/*145.6*/inputText(agenteForm("finicio_matrimonio"), 'class -> "form-control", 'id -> "finicio_matrimonio"))),format.raw/*145.104*/("""
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*152.28*/if(agenteForm.error("fingresooriginal") != null)/*152.76*/ {_display_(Seq[Any](format.raw/*152.78*/("""has-error""")))}/*152.88*/else/*152.92*/{_display_(Seq[Any](format.raw/*152.93*/("""has-required""")))})),format.raw/*152.106*/("""">
				<label for="inputFIngresoOriginal" class="control-label">Fecha Ingreso Principal</label> 
				"""),_display_(Seq[Any](/*154.6*/inputText(agenteForm("fingresooriginal"), 'class -> "form-control", 'id -> "ingresooriginal"))),format.raw/*154.99*/("""
				"""),_display_(Seq[Any](/*155.6*/agenteForm("fingresooriginal")/*155.36*/.error.map/*155.46*/{ error =>_display_(Seq[Any](format.raw/*155.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*156.31*/error/*156.36*/.message)),format.raw/*156.44*/("""</div>
				""")))})),format.raw/*157.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*161.28*/if(agenteForm.error("fingreso") != null)/*161.68*/ {_display_(Seq[Any](format.raw/*161.70*/("""has-error""")))}/*161.80*/else/*161.84*/{_display_(Seq[Any](format.raw/*161.85*/("""has-required""")))})),format.raw/*161.98*/("""">
				<label for="inputFIngreso" class="control-label">Fecha Ingreso</label> 
				"""),_display_(Seq[Any](/*163.6*/inputText(agenteForm("fingreso"), 'class -> "form-control", 'id -> "ingreso"))),format.raw/*163.83*/("""
				"""),_display_(Seq[Any](/*164.6*/agenteForm("fingreso")/*164.28*/.error.map/*164.38*/{ error =>_display_(Seq[Any](format.raw/*164.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*165.31*/error/*165.36*/.message)),format.raw/*165.44*/("""</div>
				""")))})),format.raw/*166.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*170.28*/if(agenteForm.error("fbaja") != null)/*170.65*/ {_display_(Seq[Any](format.raw/*170.67*/("""has-error""")))}/*170.77*/else/*170.81*/{_display_(Seq[Any](format.raw/*170.82*/("""has-required""")))})),format.raw/*170.95*/("""">
				<label for="inputFBaja" class="control-label">Fecha Baja</label> 
				"""),_display_(Seq[Any](/*172.6*/inputText(agenteForm("fbaja"), 'class -> "form-control", 'id -> "fbaja"))),format.raw/*172.78*/("""
				"""),_display_(Seq[Any](/*173.6*/agenteForm("fbaja")/*173.25*/.error.map/*173.35*/{ error =>_display_(Seq[Any](format.raw/*173.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*174.31*/error/*174.36*/.message)),format.raw/*174.44*/("""</div>
				""")))})),format.raw/*175.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputFIngreso" class="control-label">N° Legajo</label> 
				
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputNombre" class="control-label">N° Legajo Externo</label> 
				"""),_display_(Seq[Any](/*187.6*/inputText(agenteForm("nro_legajo_externo"), 'class -> "form-control", 'id -> "nro_legajo_externo"))),format.raw/*187.104*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label"> 
				Asignaciones Familiares
				"""),_display_(Seq[Any](/*194.6*/select(agenteForm("asignacion_familiar"),options("true"->"SI","false"->"NO"), 'class -> "form-control select"))),format.raw/*194.116*/("""
			</label>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Licencia Conducir</label>
				 """),_display_(Seq[Any](/*201.7*/select(agenteForm("tipo_licencia_conducir_id"), 
				TipoLicenciaConducir.find.all().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*203.65*/("""				
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputFLicenciaConducit" class="control-label">Fecha L.Conducir</label> 
				"""),_display_(Seq[Any](/*208.6*/inputText(agenteForm("flicencia_conducir"), 'class -> "form-control", 'id -> "flicencia_conducir"))),format.raw/*208.104*/("""
		 
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputCud" class="control-label">C.U.D.</label> 
				"""),_display_(Seq[Any](/*215.6*/inputText(agenteForm("cud"), 'class -> "form-control", 'id -> "cud"))),format.raw/*215.74*/("""
		 
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
				"""),_display_(Seq[Any](/*230.6*/inputText(agenteForm("conyugue_nombre"), 'class -> "form-control"))),format.raw/*230.72*/("""
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputConyugueDni" class="control-label">DNI</label> 
				"""),_display_(Seq[Any](/*236.6*/inputText(agenteForm("conyugue_dni"), 'class -> "form-control",'id -> "conyugue_dni"))),format.raw/*236.91*/("""
			</div>
		</div> 
		
	</div>	 -->
	<div class="row">
		<div class="col-sm-12">
			<hr>
			<h3>Datos Contactos</h3>
			
		</div>
	</div>
	<div class="row">
		 
			<div class="col-sm-2">
				<div class="form-group">
					<label for="inputCalle" class="control-label">Calle banco</label> 
					"""),_display_(Seq[Any](/*253.7*/inputText(agenteForm("calle_banco"), 'class -> "form-control"))),format.raw/*253.69*/("""
				</div>
			</div> 
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*257.29*/if(agenteForm.error("calle") != null)/*257.66*/ {_display_(Seq[Any](format.raw/*257.68*/("""has-error""")))}/*257.78*/else/*257.82*/{_display_(Seq[Any](format.raw/*257.83*/("""has-required""")))})),format.raw/*257.96*/("""">
					<label for="inputCalle" class="control-label">Calle</label> 
					"""),_display_(Seq[Any](/*259.7*/inputText(agenteForm("calle"), 'class -> "form-control"))),format.raw/*259.63*/("""
					"""),_display_(Seq[Any](/*260.7*/agenteForm("calle")/*260.26*/.error.map/*260.36*/{ error =>_display_(Seq[Any](format.raw/*260.46*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*261.32*/error/*261.37*/.message)),format.raw/*261.45*/("""</div>
					""")))})),format.raw/*262.7*/("""
				</div>
			</div> 
		 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*267.28*/if(agenteForm.error("numero") != null)/*267.66*/ {_display_(Seq[Any](format.raw/*267.68*/("""has-error""")))}/*267.78*/else/*267.82*/{_display_(Seq[Any](format.raw/*267.83*/("""has-required""")))})),format.raw/*267.96*/("""">
				<label for="inputNumero" class="control-label">Número</label> 
				"""),_display_(Seq[Any](/*269.6*/inputText(agenteForm("numero"), 'class -> "form-control"))),format.raw/*269.63*/("""
				"""),_display_(Seq[Any](/*270.6*/agenteForm("numero")/*270.26*/.error.map/*270.36*/{ error =>_display_(Seq[Any](format.raw/*270.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*271.31*/error/*271.36*/.message)),format.raw/*271.44*/("""</div>
				""")))})),format.raw/*272.6*/("""
			</div>
		</div> 
		<div class="col-sm-1">
			<div class="form-group">
				<label for="inputPiso" class="control-label">Piso</label> 
				"""),_display_(Seq[Any](/*278.6*/inputText(agenteForm("piso"), 'class -> "form-control"))),format.raw/*278.61*/("""
			</div>
		</div> 
		<div class="col-sm-1">
			<div class="form-group">
				<label for="inputDepto" class="control-label">Depto</label> 
				"""),_display_(Seq[Any](/*284.6*/inputText(agenteForm("depto"), 'class -> "form-control"))),format.raw/*284.62*/("""
			</div>
		</div> 
		<div class="col-sm-1">
			<div class="form-group  """),_display_(Seq[Any](/*288.29*/if(agenteForm.error("zip") != null)/*288.64*/ {_display_(Seq[Any](format.raw/*288.66*/("""has-error""")))}/*288.76*/else/*288.80*/{_display_(Seq[Any](format.raw/*288.81*/("""has-required""")))})),format.raw/*288.94*/("""">
				<label for="inputTelefono" class="control-label">C.P</label> 
				"""),_display_(Seq[Any](/*290.6*/inputText(agenteForm("zip"), 'class -> "form-control"))),format.raw/*290.60*/("""
				"""),_display_(Seq[Any](/*291.6*/agenteForm("zip")/*291.23*/.error.map/*291.33*/{ error =>_display_(Seq[Any](format.raw/*291.43*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*292.31*/error/*292.36*/.message)),format.raw/*292.44*/("""</div>
				""")))})),format.raw/*293.6*/("""
			</div>
		</div> 
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*300.28*/if(agenteForm.error("telefono") != null)/*300.68*/ {_display_(Seq[Any](format.raw/*300.70*/("""has-error""")))}/*300.80*/else/*300.84*/{_display_(Seq[Any](format.raw/*300.85*/("""has-required""")))})),format.raw/*300.98*/("""">
				<label for="inputTelefono" class="control-label">Tel&eacute;fono</label> 
				"""),_display_(Seq[Any](/*302.6*/inputText(agenteForm("telefono"), 'class -> "form-control"))),format.raw/*302.65*/("""
				"""),_display_(Seq[Any](/*303.6*/agenteForm("telefono")/*303.28*/.error.map/*303.38*/{ error =>_display_(Seq[Any](format.raw/*303.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*304.31*/error/*304.36*/.message)),format.raw/*304.44*/("""</div>
				""")))})),format.raw/*305.6*/("""
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputTelefono" class="control-label">Celular</label> 
				"""),_display_(Seq[Any](/*311.6*/inputText(agenteForm("mobile"), 'class -> "form-control"))),format.raw/*311.63*/("""
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputTelefono" class="control-label">Tel. Alternativo</label> 
				"""),_display_(Seq[Any](/*317.6*/inputText(agenteForm("fax"), 'class -> "form-control"))),format.raw/*317.60*/("""
			</div>
		</div> 
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*321.28*/if(agenteForm.error("email") != null)/*321.65*/ {_display_(Seq[Any](format.raw/*321.67*/("""has-error""")))}/*321.77*/else/*321.81*/{_display_(Seq[Any](format.raw/*321.82*/("""has-required""")))})),format.raw/*321.95*/("""">
				<label for="inputTelefono" class="control-label">Email</label> 
				"""),_display_(Seq[Any](/*323.6*/inputText(agenteForm("email"), 'class -> "form-control"))),format.raw/*323.62*/("""
				"""),_display_(Seq[Any](/*324.6*/agenteForm("email")/*324.25*/.error.map/*324.35*/{ error =>_display_(Seq[Any](format.raw/*324.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*325.31*/error/*325.36*/.message)),format.raw/*325.44*/("""</div>
				""")))})),format.raw/*326.6*/("""
			</div>
		</div> 
	</div>
	<div class="row contenedorUbicacion">
		<div class="col-sm-4">
			<div class="seleccionPais form-group """),_display_(Seq[Any](/*332.42*/if(agenteForm.error("localidad.provincia.pais.id") != null)/*332.101*/ {_display_(Seq[Any](format.raw/*332.103*/("""has-error""")))})),format.raw/*332.113*/("""">
				<label for=""""),_display_(Seq[Any](/*333.18*/agenteForm("localidad.provincia.pais.id")/*333.59*/.id)),format.raw/*333.62*/("""" class="control-label">País</label>
				"""),_display_(Seq[Any](/*334.6*/select(agenteForm("localidad.provincia.pais.id"), Pais.find.orderBy("nombre").findList().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*334.194*/("""
				"""),_display_(Seq[Any](/*335.6*/agenteForm("localidad.provincia.pais.id")/*335.47*/.error.map/*335.57*/{ error =>_display_(Seq[Any](format.raw/*335.67*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*336.31*/error/*336.36*/.message)),format.raw/*336.44*/("""</div>
				""")))})),format.raw/*337.6*/("""
			</div>
		</div>
	
		<div class="col-sm-4">
			<div class="seleccionProvincia form-group """),_display_(Seq[Any](/*342.47*/if(agenteForm.error("localidad.provincia.id") != null)/*342.101*/ {_display_(Seq[Any](format.raw/*342.103*/("""has-error""")))})),format.raw/*342.113*/("""">
				<label for=""""),_display_(Seq[Any](/*343.18*/agenteForm("localidad.provincia.id")/*343.54*/.id)),format.raw/*343.57*/("""" class="control-label">Provincia</label>
				"""),_display_(Seq[Any](/*344.6*/select(agenteForm("localidad.provincia.id"), 
					agenteForm("localidad.provincia.pais.id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {Provincia.getProvincias(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*350.65*/("""
				"""),_display_(Seq[Any](/*351.6*/agenteForm("localidad.provincia.id")/*351.42*/.error.map/*351.52*/{ error =>_display_(Seq[Any](format.raw/*351.62*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*352.31*/error/*352.36*/.message)),format.raw/*352.44*/("""</div>
				""")))})),format.raw/*353.6*/("""
			</div>
		</div>
	
		<div class="col-sm-4">
			<div class="seleccionLocalidad form-group """),_display_(Seq[Any](/*358.47*/if(agenteForm.error("localidad_id") != null)/*358.91*/ {_display_(Seq[Any](format.raw/*358.93*/("""has-error""")))}/*358.104*/else/*358.109*/{_display_(Seq[Any](format.raw/*358.110*/("""has-required""")))})),format.raw/*358.123*/("""">
				<label for=""""),_display_(Seq[Any](/*359.18*/agenteForm("localidad.id")/*359.44*/.id)),format.raw/*359.47*/("""" class="control-label">Localidad</label>
				"""),_display_(Seq[Any](/*360.6*/select(agenteForm("localidad_id"), 
					agenteForm("localidad.provincia.id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {Localidad.getLocalidades(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*366.65*/("""
				"""),_display_(Seq[Any](/*367.6*/agenteForm("localidad_id")/*367.32*/.error.map/*367.42*/{ error =>_display_(Seq[Any](format.raw/*367.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*368.31*/error/*368.36*/.message)),format.raw/*368.44*/("""</div>
				""")))})),format.raw/*369.6*/("""
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
			<div class="form-group """),_display_(Seq[Any](/*381.28*/if(agenteForm.error("organigrama_id") != null)/*381.74*/ {_display_(Seq[Any](format.raw/*381.76*/("""has-error""")))}/*381.86*/else/*381.90*/{_display_(Seq[Any](format.raw/*381.91*/("""has-required""")))})),format.raw/*381.104*/("""">
				<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
				"""),_display_(Seq[Any](/*383.6*/inputText(agenteForm("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*383.95*/("""
				"""),_display_(Seq[Any](/*384.6*/inputText(agenteForm("organigrama_id"),'hidden -> "hidden"))),format.raw/*384.65*/("""
				"""),_display_(Seq[Any](/*385.6*/agenteForm("organigrama_id")/*385.34*/.error.map/*385.44*/{ error =>_display_(Seq[Any](format.raw/*385.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*386.31*/error/*386.36*/.message)),format.raw/*386.44*/("""</div>
				""")))})),format.raw/*387.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label for="inputDepartamento" class="control-label">Profesion</label> 
			<div class="input-group """),_display_(Seq[Any](/*392.29*/if(agenteForm.error("profesion.id") != null)/*392.73*/ {_display_(Seq[Any](format.raw/*392.75*/("""has-error""")))}/*392.85*/else/*392.89*/{_display_(Seq[Any](format.raw/*392.90*/("""has-required""")))})),format.raw/*392.103*/("""">
				"""),_display_(Seq[Any](/*393.6*/inputText(agenteForm("profesion.nombre"),'class -> "form-control",'id -> "profesion"))),format.raw/*393.91*/("""
				"""),_display_(Seq[Any](/*394.6*/inputText(agenteForm("profesion_id"),'hidden -> "hidden",'id -> "profesion_id"))),format.raw/*394.85*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchProfesion" data-title="Selección de profesion" 
                				data-url=""""),_display_(Seq[Any](/*397.32*/controllers/*397.43*/.rrhh.routes.ProfesionesController.modalBuscar())),format.raw/*397.91*/("""" 
                				data-height="650" data-width="700" 
                				data-listen="modal.seleccion.profesion.simple" 
                				data-label="#profesion" data-field="#profesion_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*403.5*/agenteForm("profesion_id")/*403.31*/.error.map/*403.41*/{ error =>_display_(Seq[Any](format.raw/*403.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*404.30*/error/*404.35*/.message)),format.raw/*404.43*/("""</div>
			""")))})),format.raw/*405.5*/("""
		</div>
	</div>
	
	
	<div class="row">
		<!-- <div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*412.28*/if(agenteForm.error("departamento.id") != null)/*412.75*/ {_display_(Seq[Any](format.raw/*412.77*/("""has-error""")))}/*412.87*/else/*412.91*/{})),format.raw/*412.93*/("""">
				<label for="inputDepartamento" class="control-label">Departamento</label> 
				"""),_display_(Seq[Any](/*414.6*/inputText(agenteForm("departamento.nombre"),'class -> "form-control"))),format.raw/*414.75*/("""
				"""),_display_(Seq[Any](/*415.6*/inputText(agenteForm("departamento.id"),'hidden -> "hidden"))),format.raw/*415.66*/("""
				"""),_display_(Seq[Any](/*416.6*/agenteForm("departamento.id")/*416.35*/.error.map/*416.45*/{ error =>_display_(Seq[Any](format.raw/*416.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*417.31*/error/*417.36*/.message)),format.raw/*417.44*/("""</div>
				""")))})),format.raw/*418.6*/("""
			</div>
		</div> -->
		
		<div class="col-sm-4">
			<label for="inputDepartamento" class="control-label">Residencia</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*425.6*/inputText(agenteForm("tipoResidencia.nombre"),'class -> "form-control",'id -> "tipoResidencia"))),format.raw/*425.101*/("""
				"""),_display_(Seq[Any](/*426.6*/inputText(agenteForm("tipo_residencia_id"),'hidden -> "hidden",'id -> "tipo_residencia_id"))),format.raw/*426.97*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchTipoResidencia" data-title="Selección de Tipo Residencia" 
                				data-url=""""),_display_(Seq[Any](/*429.32*/controllers/*429.43*/.rrhh.routes.TipoResidenciasController.modalBuscar())),format.raw/*429.95*/("""" 
                				data-height="650" data-width="700" 
                				data-listen="modal.seleccion.tipoResidencia.simple" 
                				data-label="#tipoResidencia" 
                				data-field="#tipo_residencia_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*439.28*/if(agenteForm.error("especialidad.id") != null)/*439.75*/ {_display_(Seq[Any](format.raw/*439.77*/("""has-error""")))}/*439.87*/else/*439.91*/{})),format.raw/*439.93*/("""">
				<label for="inputEspecialidad" class="control-label">Especialidad</label> 
				"""),_display_(Seq[Any](/*441.6*/inputText(agenteForm("especialidad.nombre"),'class -> "form-control"))),format.raw/*441.75*/("""
				"""),_display_(Seq[Any](/*442.6*/inputText(agenteForm("especialidad_id"),'hidden -> "hidden"))),format.raw/*442.66*/("""
				"""),_display_(Seq[Any](/*443.6*/agenteForm("especialidad_id")/*443.35*/.error.map/*443.45*/{ error =>_display_(Seq[Any](format.raw/*443.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*444.31*/error/*444.36*/.message)),format.raw/*444.44*/("""</div>
				""")))})),format.raw/*445.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*449.28*/if(agenteForm.error("puesto.id") != null)/*449.69*/ {_display_(Seq[Any](format.raw/*449.71*/("""has-error""")))}/*449.81*/else/*449.85*/{})),format.raw/*449.87*/("""">
				<label for="inputPuesto" class="control-label">Puesto</label> 
				"""),_display_(Seq[Any](/*451.6*/inputText(agenteForm("puesto.nombre"),'class -> "form-control"))),format.raw/*451.69*/("""
				"""),_display_(Seq[Any](/*452.6*/inputText(agenteForm("puesto.id"),'hidden -> "hidden"))),format.raw/*452.60*/("""
				"""),_display_(Seq[Any](/*453.6*/agenteForm("puesto.id")/*453.29*/.error.map/*453.39*/{ error =>_display_(Seq[Any](format.raw/*453.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*454.31*/error/*454.36*/.message)),format.raw/*454.44*/("""</div>
				""")))})),format.raw/*455.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			"""),_display_(Seq[Any](/*461.5*/views/*461.10*/.html.rrhh.agente.contenidoTabNovedad(true, agenteForm, agente:Agente))),format.raw/*461.80*/("""
		</div>
	</div>
	
<script>
	$( function() """),format.raw/*466.16*/("""{"""),format.raw/*466.17*/("""
		$("#cuit").mask("99999999999");
		$("#dni,#conyugue_dni").mask("99999999");
		$("#nacimiento,#flicencia_conducir, #ingreso,#ingresooriginal,#fbaja,#finicio_matrimonio,#cud").mask("99/99/9999");
		urlProvincias  = '"""),_display_(Seq[Any](/*470.22*/controllers/*470.33*/.administracion.routes.ProvinciasController.listOptions())),format.raw/*470.90*/("""';
		urlLocalidades = '"""),_display_(Seq[Any](/*471.22*/controllers/*471.33*/.administracion.routes.LocalidadesController.listOptions())),format.raw/*471.91*/("""';
		
		$('.seleccionPais .select').on('change', function()"""),format.raw/*473.54*/("""{"""),format.raw/*473.55*/("""
			var id = $(this).find('option:selected').val();
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionProvincia .select, .seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlProvincias + '?paisId='+id, function(data)"""),format.raw/*480.55*/("""{"""),format.raw/*480.56*/("""
				contenedor.find('.seleccionProvincia .select').html(data);
			"""),format.raw/*482.4*/("""}"""),format.raw/*482.5*/(""");
		"""),format.raw/*483.3*/("""}"""),format.raw/*483.4*/(""");
		
		$('.seleccionProvincia .select').on('change', function()"""),format.raw/*485.59*/("""{"""),format.raw/*485.60*/("""
			var id = $(this).find('option:selected').val();
			
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlLocalidades + '?provinciaId='+id, function(data)"""),format.raw/*493.61*/("""{"""),format.raw/*493.62*/("""
				contenedor.find('.seleccionLocalidad .select').html(data);
			"""),format.raw/*495.4*/("""}"""),format.raw/*495.5*/(""");
		"""),format.raw/*496.3*/("""}"""),format.raw/*496.4*/(""");
	
	"""),format.raw/*498.2*/("""}"""),format.raw/*498.3*/(""");
</script>	
	"""))}
    }
    
    def render(agenteForm:Form[Agente],agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(agenteForm,agente)
    
    def f:((Form[Agente],Agente) => play.api.templates.HtmlFormat.Appendable) = (agenteForm,agente) => apply(agenteForm,agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/formAgente.scala.html
                    HASH: 8db445ce6c29e0df1637f4e8c2c60b9d080f3aff
                    MATRIX: 804->1|962->76|994->100|1068->41|1096->144|1344->357|1386->391|1424->392|1461->394|1478->403|1520->424|1540->427|1552->432|1599->434|1619->445|1694->490|1711->498|1747->508|1943->668|1960->676|1991->685|2128->787|2169->819|2208->820|2254->830|2274->841|2377->913|2395->921|2427->930|2559->1029|2643->1077|2660->1085|2691->1094|2736->1103|2753->1111|2782->1118|2824->1125|2911->1190|3019->1262|3068->1302|3108->1304|3137->1314|3150->1318|3189->1319|3234->1332|3355->1418|3436->1477|3477->1483|3508->1505|3527->1515|3575->1525|3642->1556|3656->1561|3686->1569|3729->1581|3809->1625|3856->1663|3896->1665|3925->1675|3938->1679|3977->1680|4022->1693|4205->1841|4297->1911|4468->2047|4564->2121|4652->2174|4681->2194|4700->2204|4748->2214|4814->2244|4828->2249|4858->2257|4900->2268|4971->2303|5018->2341|5058->2343|5087->2353|5100->2357|5139->2358|5184->2371|5366->2518|5454->2584|5625->2720|5713->2786|5801->2839|5830->2859|5849->2869|5897->2879|5963->2909|5977->2914|6007->2922|6049->2933|6148->2996|6210->3049|6250->3051|6279->3061|6292->3065|6331->3066|6377->3079|6433->3099|6490->3134|6584->3193|6790->3377|6836->3388|6880->3423|6899->3433|6947->3443|7014->3474|7028->3479|7058->3487|7101->3499|7294->3657|7370->3711|7507->3812|7551->3847|7591->3849|7620->3859|7633->3863|7672->3864|7717->3877|7831->3956|7921->4024|7963->4031|7989->4048|8008->4058|8056->4068|8123->4099|8137->4104|8167->4112|8210->4124|8291->4168|8337->4204|8378->4206|8408->4216|8422->4220|8462->4221|8508->4234|8643->4333|8736->4403|8788->4419|8816->4437|8836->4447|8885->4457|8953->4488|8968->4493|8999->4501|9043->4513|9143->4576|9189->4612|9230->4614|9260->4624|9274->4628|9314->4629|9360->4642|9417->4662|9458->4680|9536->4722|9702->4865|9744->4871|9772->4889|9792->4899|9841->4909|9909->4940|9924->4945|9955->4953|9999->4965|10108->5037|10161->5080|10202->5082|10232->5092|10246->5096|10286->5097|10333->5110|10455->5196|10561->5279|10604->5286|10639->5311|10659->5321|10708->5331|10776->5362|10791->5367|10822->5375|10866->5387|10975->5459|11029->5503|11070->5505|11100->5515|11114->5519|11154->5520|11201->5533|11258->5553|11307->5579|11393->5629|11583->5796|11631->5808|11667->5834|11687->5844|11736->5854|11804->5885|11819->5890|11850->5898|11894->5910|12087->6067|12209->6165|12348->6267|12406->6315|12447->6317|12477->6327|12491->6331|12531->6332|12578->6345|12716->6447|12832->6540|12874->6546|12914->6576|12934->6586|12983->6596|13051->6627|13066->6632|13097->6640|13141->6652|13250->6724|13300->6764|13341->6766|13371->6776|13385->6780|13425->6781|13471->6794|13591->6878|13691->6955|13733->6961|13765->6983|13785->6993|13834->7003|13902->7034|13917->7039|13948->7047|13992->7059|14101->7131|14148->7168|14189->7170|14219->7180|14233->7184|14273->7185|14319->7198|14433->7276|14528->7348|14570->7354|14599->7373|14619->7383|14668->7393|14736->7424|14751->7429|14782->7437|14826->7449|15167->7754|15289->7852|15440->7967|15574->8077|15748->8215|15960->8404|16156->8564|16278->8662|16460->8808|16551->8876|16872->9161|16961->9227|17145->9375|17253->9460|17584->9755|17669->9817|17783->9894|17830->9931|17871->9933|17901->9943|17915->9947|17955->9948|18001->9961|18112->10036|18191->10092|18234->10099|18263->10118|18283->10128|18332->10138|18401->10170|18416->10175|18447->10183|18492->10196|18608->10275|18656->10313|18697->10315|18727->10325|18741->10329|18781->10330|18827->10343|18938->10418|19018->10475|19060->10481|19090->10501|19110->10511|19159->10521|19227->10552|19242->10557|19273->10565|19317->10577|19495->10719|19573->10774|19753->10918|19832->10974|19943->11048|19988->11083|20029->11085|20059->11095|20073->11099|20113->11100|20159->11113|20269->11187|20346->11241|20388->11247|20415->11264|20435->11274|20484->11284|20552->11315|20567->11320|20598->11328|20642->11340|20782->11443|20832->11483|20873->11485|20903->11495|20917->11499|20957->11500|21003->11513|21125->11599|21207->11658|21249->11664|21281->11686|21301->11696|21350->11706|21418->11737|21433->11742|21464->11750|21508->11762|21693->11911|21773->11968|21967->12126|22044->12180|22154->12253|22201->12290|22242->12292|22272->12302|22286->12306|22326->12307|22372->12320|22484->12396|22563->12452|22605->12458|22634->12477|22654->12487|22703->12497|22771->12528|22786->12533|22817->12541|22861->12553|23032->12687|23102->12746|23144->12748|23188->12758|23245->12778|23296->12819|23322->12822|23400->12864|23612->13052|23654->13058|23705->13099|23725->13109|23774->13119|23842->13150|23857->13155|23888->13163|23932->13175|24062->13268|24127->13322|24169->13324|24213->13334|24270->13354|24316->13390|24342->13393|24425->13440|24797->13789|24839->13795|24885->13831|24905->13841|24954->13851|25022->13882|25037->13887|25068->13895|25112->13907|25242->14000|25296->14044|25337->14046|25368->14057|25383->14062|25424->14063|25471->14076|25528->14096|25564->14122|25590->14125|25673->14172|26031->14507|26073->14513|26109->14539|26129->14549|26178->14559|26246->14590|26261->14595|26292->14603|26336->14615|26570->14812|26626->14858|26667->14860|26697->14870|26711->14874|26751->14875|26798->14888|26929->14983|27041->15072|27083->15078|27165->15137|27207->15143|27245->15171|27265->15181|27314->15191|27382->15222|27397->15227|27428->15235|27472->15247|27657->15395|27711->15439|27752->15441|27782->15451|27796->15455|27836->15456|27883->15469|27927->15477|28035->15562|28077->15568|28179->15647|28372->15803|28393->15814|28464->15862|28786->16148|28822->16174|28842->16184|28891->16194|28958->16224|28973->16229|29004->16237|29047->16248|29182->16346|29239->16393|29280->16395|29310->16405|29324->16409|29349->16411|29472->16498|29564->16567|29606->16573|29689->16633|29731->16639|29770->16668|29790->16678|29839->16688|29907->16719|29922->16724|29953->16732|29997->16744|30195->16906|30314->17001|30356->17007|30470->17098|30674->17265|30695->17276|30770->17328|31190->17711|31247->17758|31288->17760|31318->17770|31332->17774|31357->17776|31480->17863|31572->17932|31614->17938|31697->17998|31739->18004|31778->18033|31798->18043|31847->18053|31915->18084|31930->18089|31961->18097|32005->18109|32114->18181|32165->18222|32206->18224|32236->18234|32250->18238|32275->18240|32386->18315|32472->18378|32514->18384|32591->18438|32633->18444|32666->18467|32686->18477|32735->18487|32803->18518|32818->18523|32849->18531|32893->18543|33006->18620|33021->18625|33114->18695|33187->18739|33217->18740|33472->18958|33493->18969|33573->19026|33634->19050|33655->19061|33736->19119|33824->19178|33854->19179|34195->19491|34225->19492|34320->19559|34349->19560|34382->19565|34411->19566|34504->19630|34534->19631|34856->19924|34886->19925|34981->19992|35010->19993|35043->19998|35072->19999|35106->20005|35135->20006
                    LINES: 26->1|31->4|31->4|32->1|33->4|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|41->12|41->12|41->12|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|50->21|50->21|50->21|50->21|50->21|50->21|50->21|52->23|52->23|53->24|53->24|53->24|53->24|54->25|54->25|54->25|55->26|58->29|58->29|58->29|58->29|58->29|58->29|58->29|64->35|64->35|71->42|71->42|76->47|76->47|76->47|76->47|77->48|77->48|77->48|78->49|80->51|80->51|80->51|80->51|80->51|80->51|80->51|86->57|86->57|93->64|93->64|98->69|98->69|98->69|98->69|99->70|99->70|99->70|100->71|103->74|103->74|103->74|103->74|103->74|103->74|103->74|104->75|104->75|105->76|107->78|109->80|109->80|109->80|109->80|110->81|110->81|110->81|111->82|117->88|117->88|123->94|123->94|123->94|123->94|123->94|123->94|123->94|125->96|125->96|126->97|126->97|126->97|126->97|127->98|127->98|127->98|128->99|131->102|131->102|131->102|131->102|131->102|131->102|131->102|134->105|134->105|136->107|136->107|136->107|136->107|137->108|137->108|137->108|138->109|141->112|141->112|141->112|141->112|141->112|141->112|141->112|142->113|142->113|143->114|144->115|145->116|145->116|145->116|145->116|146->117|146->117|146->117|147->118|151->122|151->122|151->122|151->122|151->122|151->122|151->122|153->124|153->124|154->125|154->125|154->125|154->125|155->126|155->126|155->126|156->127|160->131|160->131|160->131|160->131|160->131|160->131|160->131|161->132|161->132|162->133|164->135|166->137|166->137|166->137|166->137|167->138|167->138|167->138|168->139|174->145|174->145|181->152|181->152|181->152|181->152|181->152|181->152|181->152|183->154|183->154|184->155|184->155|184->155|184->155|185->156|185->156|185->156|186->157|190->161|190->161|190->161|190->161|190->161|190->161|190->161|192->163|192->163|193->164|193->164|193->164|193->164|194->165|194->165|194->165|195->166|199->170|199->170|199->170|199->170|199->170|199->170|199->170|201->172|201->172|202->173|202->173|202->173|202->173|203->174|203->174|203->174|204->175|216->187|216->187|223->194|223->194|230->201|232->203|237->208|237->208|244->215|244->215|259->230|259->230|265->236|265->236|282->253|282->253|286->257|286->257|286->257|286->257|286->257|286->257|286->257|288->259|288->259|289->260|289->260|289->260|289->260|290->261|290->261|290->261|291->262|296->267|296->267|296->267|296->267|296->267|296->267|296->267|298->269|298->269|299->270|299->270|299->270|299->270|300->271|300->271|300->271|301->272|307->278|307->278|313->284|313->284|317->288|317->288|317->288|317->288|317->288|317->288|317->288|319->290|319->290|320->291|320->291|320->291|320->291|321->292|321->292|321->292|322->293|329->300|329->300|329->300|329->300|329->300|329->300|329->300|331->302|331->302|332->303|332->303|332->303|332->303|333->304|333->304|333->304|334->305|340->311|340->311|346->317|346->317|350->321|350->321|350->321|350->321|350->321|350->321|350->321|352->323|352->323|353->324|353->324|353->324|353->324|354->325|354->325|354->325|355->326|361->332|361->332|361->332|361->332|362->333|362->333|362->333|363->334|363->334|364->335|364->335|364->335|364->335|365->336|365->336|365->336|366->337|371->342|371->342|371->342|371->342|372->343|372->343|372->343|373->344|379->350|380->351|380->351|380->351|380->351|381->352|381->352|381->352|382->353|387->358|387->358|387->358|387->358|387->358|387->358|387->358|388->359|388->359|388->359|389->360|395->366|396->367|396->367|396->367|396->367|397->368|397->368|397->368|398->369|410->381|410->381|410->381|410->381|410->381|410->381|410->381|412->383|412->383|413->384|413->384|414->385|414->385|414->385|414->385|415->386|415->386|415->386|416->387|421->392|421->392|421->392|421->392|421->392|421->392|421->392|422->393|422->393|423->394|423->394|426->397|426->397|426->397|432->403|432->403|432->403|432->403|433->404|433->404|433->404|434->405|441->412|441->412|441->412|441->412|441->412|441->412|443->414|443->414|444->415|444->415|445->416|445->416|445->416|445->416|446->417|446->417|446->417|447->418|454->425|454->425|455->426|455->426|458->429|458->429|458->429|468->439|468->439|468->439|468->439|468->439|468->439|470->441|470->441|471->442|471->442|472->443|472->443|472->443|472->443|473->444|473->444|473->444|474->445|478->449|478->449|478->449|478->449|478->449|478->449|480->451|480->451|481->452|481->452|482->453|482->453|482->453|482->453|483->454|483->454|483->454|484->455|490->461|490->461|490->461|495->466|495->466|499->470|499->470|499->470|500->471|500->471|500->471|502->473|502->473|509->480|509->480|511->482|511->482|512->483|512->483|514->485|514->485|522->493|522->493|524->495|524->495|525->496|525->496|527->498|527->498
                    -- GENERATED --
                */
            