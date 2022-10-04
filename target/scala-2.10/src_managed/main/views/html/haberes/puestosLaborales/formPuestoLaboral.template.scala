
package views.html.haberes.puestosLaborales

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
object formPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.PuestoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(puestoForm: Form[models.haberes.PuestoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*6.70*/(""" 
<script>
$( function()"""),format.raw/*8.14*/("""{"""),format.raw/*8.15*/(""" 
	$('.searchModal').modalSearch();
	$("#sueldo_referencia").numeric_input();
 	
	if($("#liquidacion_mes").length)"""),format.raw/*12.34*/("""{"""),format.raw/*12.35*/("""
		var options = """),format.raw/*13.17*/("""{"""),format.raw/*13.18*/("""
				script:"/suggestLiquidacionMes/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*19.30*/("""{"""),format.raw/*19.31*/(""" 
											$("#liquidacion_mes_id").val(obj.id); 
										 """),format.raw/*21.12*/("""}"""),format.raw/*21.13*/("""
			"""),format.raw/*22.4*/("""}"""),format.raw/*22.5*/(""";
		var as_json = new bsn.AutoSuggest('liquidacion_mes', options);
	"""),format.raw/*24.2*/("""}"""),format.raw/*24.3*/("""
"""),format.raw/*25.1*/("""}"""),format.raw/*25.2*/(""")
</script>	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar puesto laboral"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*30.14*/if(request().getHeader("referer"))/*30.48*/{_display_(Seq[Any](format.raw/*30.49*/(""" """),_display_(Seq[Any](/*30.51*/request()/*30.60*/.getHeader("referer"))),format.raw/*30.81*/(""" """)))}/*30.84*/else/*30.89*/{_display_(Seq[Any](_display_(Seq[Any](/*30.91*/controllers/*30.102*/.haberes.routes.PuestosLaboralesController.index())),_display_(Seq[Any](/*30.153*/UriTrack/*30.161*/.decode()))))})),format.raw/*30.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*33.14*/UriTrack/*33.22*/.decode())),format.raw/*33.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		  
		
		<div class="col-sm-3">
			<label class="control-label">Legajo</label>
				<div class="input-group """),_display_(Seq[Any](/*41.30*/if(puestoForm.error("legajo_id") != null)/*41.71*/ {_display_(Seq[Any](format.raw/*41.73*/("""has-error""")))}/*41.83*/else/*41.87*/{_display_(Seq[Any](format.raw/*41.88*/("""has-required""")))})),format.raw/*41.101*/("""">
					"""),_display_(Seq[Any](/*42.7*/inputText(puestoForm("legajo.agente.apellido"), 'name -> "", 'class -> "form-control", 'id -> "legajo"))),format.raw/*42.110*/("""
					"""),_display_(Seq[Any](/*43.7*/inputText(puestoForm("legajo_id"), 'hidden -> "hidden", 'id -> "legajo_id"))),format.raw/*43.82*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchLegajo" 
							 	data-title="Selección de legajo" 
							 	data-url=""""),_display_(Seq[Any](/*48.21*/controllers/*48.32*/.haberes.routes.LegajosController.modalBuscar())),format.raw/*48.79*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.legajo.simple" 
							 	data-label="#legajo" data-field="#legajo_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*54.6*/puestoForm("legajo_id")/*54.29*/.error.map/*54.39*/{ error =>_display_(Seq[Any](format.raw/*54.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*55.31*/error/*55.36*/.message)),format.raw/*55.44*/("""</div>
				""")))})),format.raw/*56.6*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">Estado
				"""),_display_(Seq[Any](/*61.6*/select(puestoForm("activo"), options("true"->"Activo", "false"->"Inactivo"), 'class -> "form-control"))),format.raw/*61.108*/("""
				</label>
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label"> 
				Envio mail
				"""),_display_(Seq[Any](/*68.6*/select(puestoForm("mail_automatico"),options("true"->"SI","false"->"NO"), 'class -> "form-control select"))),format.raw/*68.112*/("""
			</label>
		</div>
		<div class="col-sm-2 """),_display_(Seq[Any](/*71.25*/if(puestoForm.error("convenio_ministerio") != null)/*71.76*/ {_display_(Seq[Any](format.raw/*71.78*/("""has-error""")))}/*71.88*/else/*71.92*/{_display_(Seq[Any](format.raw/*71.93*/("""has-required""")))})),format.raw/*71.106*/("""">
			<b>Convenio Ministerio</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*77.9*/inputRadioGroup(puestoForm("convenio_ministerio"), options = Seq("true"->"SI")))),format.raw/*77.88*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*84.9*/inputRadioGroup(puestoForm("convenio_ministerio"),options = Seq("false"->"NO")))),format.raw/*84.88*/("""
						</label>
					</div>
				</div>
			</div>
			"""),_display_(Seq[Any](/*89.5*/puestoForm("convenio_ministerio")/*89.38*/.error.map/*89.48*/{ error =>_display_(Seq[Any](format.raw/*89.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*90.30*/error/*90.35*/.message)),format.raw/*90.43*/("""</div>
			""")))})),format.raw/*91.5*/("""
		</div> 
		<div class="col-sm-2">
			<label class="control-label">Cargo Laboral</label>
				<div class="input-group """),_display_(Seq[Any](/*95.30*/if(puestoForm.error("cargo_laboral_id") != null)/*95.78*/ {_display_(Seq[Any](format.raw/*95.80*/("""has-error""")))}/*95.90*/else/*95.94*/{_display_(Seq[Any](format.raw/*95.95*/("""has-required""")))})),format.raw/*95.108*/("""">
					"""),_display_(Seq[Any](/*96.7*/inputText(puestoForm("cargoLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cargo_laboral"))),format.raw/*96.114*/("""
					"""),_display_(Seq[Any](/*97.7*/inputText(puestoForm("cargo_laboral_id"), 'hidden -> "hidden", 'id -> "cargo_laboral_id"))),format.raw/*97.96*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchCargoLaboral" 
							 	data-title="Selección de Cargo" 
							 	data-url=""""),_display_(Seq[Any](/*101.21*/controllers/*101.32*/.haberes.routes.CargosLaboralesController.modalBuscar())),format.raw/*101.87*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.cargoLaboral.simple" 
							 	data-label="#cargo_laboral" data-field="#cargo_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*107.6*/puestoForm("cargo_laboral_id")/*107.36*/.error.map/*107.46*/{ error =>_display_(Seq[Any](format.raw/*107.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*108.31*/error/*108.36*/.message)),format.raw/*108.44*/("""</div>
				""")))})),format.raw/*109.6*/("""
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-3">
			<label class="control-label">Escala</label>
				<div class="input-group """),_display_(Seq[Any](/*115.30*/if(puestoForm.error("escala_laboral_id") != null)/*115.79*/ {_display_(Seq[Any](format.raw/*115.81*/("""has-error""")))}/*115.91*/else/*115.95*/{_display_(Seq[Any](format.raw/*115.96*/("""has-required""")))})),format.raw/*115.109*/("""">
					"""),_display_(Seq[Any](/*116.7*/inputText(puestoForm("escalaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "escala_laboral"))),format.raw/*116.116*/("""
					"""),_display_(Seq[Any](/*117.7*/inputText(puestoForm("escala_laboral_id"), 'hidden -> "hidden", 'id -> "escala_laboral_id"))),format.raw/*117.98*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchEscalaLaboral" 
							 	data-title="Selección de escala" 
							 	data-url=""""),_display_(Seq[Any](/*121.21*/controllers/*121.32*/.haberes.routes.EscalasLaboralesController.modalBuscar())),format.raw/*121.88*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.escalaLaboral.simple" 
							 	data-label="#escala_laboral" data-field="#escala_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*127.6*/puestoForm("escala_laboral_id")/*127.37*/.error.map/*127.47*/{ error =>_display_(Seq[Any](format.raw/*127.57*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*128.31*/error/*128.36*/.message)),format.raw/*128.44*/("""</div>
				""")))})),format.raw/*129.6*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Departamento</label>
				<div class="input-group """),_display_(Seq[Any](/*134.30*/if(puestoForm.error("departamento_id") != null)/*134.77*/ {_display_(Seq[Any](format.raw/*134.79*/("""has-error""")))}/*134.89*/else/*134.93*/{_display_(Seq[Any](format.raw/*134.94*/("""has-required""")))})),format.raw/*134.107*/("""">
					"""),_display_(Seq[Any](/*135.7*/inputText(puestoForm("departamento.nombre"), 'name -> "", 'class -> "form-control", 'id -> "departamento"))),format.raw/*135.113*/("""
					"""),_display_(Seq[Any](/*136.7*/inputText(puestoForm("departamento_id"), 'hidden -> "hidden", 'id -> "departamento_id"))),format.raw/*136.94*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchDepartamento" 
							 	data-title="Selección de departamento" 
							 	data-url=""""),_display_(Seq[Any](/*140.21*/controllers/*140.32*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*140.82*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.departamento.simple" 
							 	data-label="#departamento" data-field="#departamento_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*146.6*/puestoForm("departamento_id")/*146.35*/.error.map/*146.45*/{ error =>_display_(Seq[Any](format.raw/*146.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*147.31*/error/*147.36*/.message)),format.raw/*147.44*/("""</div>
				""")))})),format.raw/*148.6*/("""
		</div>
		<div class="col-sm-3">
			<label for="inputEspecialidad" class="control-label">Especialidad</label> 
			<div class="input-group">
				
				"""),_display_(Seq[Any](/*154.6*/inputText(puestoForm("especialidad.nombre"),'class -> "form-control", 'id -> "especialidad"))),format.raw/*154.98*/("""
				"""),_display_(Seq[Any](/*155.6*/inputText(puestoForm("especialidad_id"),'hidden -> "hidden", 'id -> "especialidad_id"))),format.raw/*155.92*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchEspecialidad" 
							 	data-title="Selección de especialidad" 
							 	data-url=""""),_display_(Seq[Any](/*159.21*/controllers/*159.32*/.rrhh.routes.EspecialidadesController.modalBuscar())),format.raw/*159.83*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.especialidad.simple" 
							 	data-label="#especialidad" 
							 	data-field="#especialidad_id">
					<i class="glyphicon glyphicon-search"></i></a>
				</span>
			</div>
		</div>
		<div class="col-sm-3">
			<label class="control-label">Categoria Interna</label>
				<div class="input-group """),_display_(Seq[Any](/*170.30*/if(puestoForm.error("categoria_laboral_id") != null)/*170.82*/ {_display_(Seq[Any](format.raw/*170.84*/("""has-error""")))}/*170.94*/else/*170.98*/{_display_(Seq[Any](format.raw/*170.99*/("""has-required""")))})),format.raw/*170.112*/("""">
					"""),_display_(Seq[Any](/*171.7*/inputText(puestoForm("categoriaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "categoria_laboral"))),format.raw/*171.122*/("""
					"""),_display_(Seq[Any](/*172.7*/inputText(puestoForm("categoria_laboral_id"), 'hidden -> "hidden", 'id -> "categoria_laboral_id"))),format.raw/*172.104*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchCategoriaLaboral" 
							 	data-title="Selección de categoria" 
							 	data-url=""""),_display_(Seq[Any](/*176.21*/controllers/*176.32*/.haberes.routes.CategoriasLaboralesController.modalBuscar())),format.raw/*176.91*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.categoriaLaboral.simple" 
							 	data-label="#categoria_laboral" data-field="#categoria_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*182.6*/puestoForm("categoria_laboral_id")/*182.40*/.error.map/*182.50*/{ error =>_display_(Seq[Any](format.raw/*182.60*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*183.31*/error/*183.36*/.message)),format.raw/*183.44*/("""</div>
				""")))})),format.raw/*184.6*/("""
		</div> 
		
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*190.28*/if(puestoForm.error("fecha_posesion") != null)/*190.74*/ {_display_(Seq[Any](format.raw/*190.76*/("""has-error""")))})),format.raw/*190.86*/("""">
				<label for="fechaPosesion" class="control-label">Fecha Posesion</label> 
				"""),_display_(Seq[Any](/*192.6*/inputText(puestoForm("fecha_posesion"),'class -> "form-control date"))),format.raw/*192.75*/("""
			</div>
			"""),_display_(Seq[Any](/*194.5*/puestoForm("fecha_posesion")/*194.33*/.error.map/*194.43*/{ error =>_display_(Seq[Any](format.raw/*194.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*195.30*/error/*195.35*/.message)),format.raw/*195.43*/("""</div>
			""")))})),format.raw/*196.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*199.28*/if(puestoForm.error("fecha_baja") != null)/*199.70*/ {_display_(Seq[Any](format.raw/*199.72*/("""has-error""")))})),format.raw/*199.82*/("""">
				<label for="fechaBaja" class="control-label">Fecha Baja</label> 
				"""),_display_(Seq[Any](/*201.6*/inputText(puestoForm("fecha_baja"),'class -> "form-control date"))),format.raw/*201.71*/("""
			</div>
			"""),_display_(Seq[Any](/*203.5*/puestoForm("fecha_baja")/*203.29*/.error.map/*203.39*/{ error =>_display_(Seq[Any](format.raw/*203.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*204.30*/error/*204.35*/.message)),format.raw/*204.43*/("""</div>
			""")))})),format.raw/*205.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*208.28*/if(puestoForm.error("fecha_telegrama") != null)/*208.75*/ {_display_(Seq[Any](format.raw/*208.77*/("""has-error""")))})),format.raw/*208.87*/("""">
				<label for="fechaTelegrama" class="control-label">Fecha Telegrama</label> 
				"""),_display_(Seq[Any](/*210.6*/inputText(puestoForm("fecha_telegrama"),'class -> "form-control date"))),format.raw/*210.76*/("""
			</div>
			"""),_display_(Seq[Any](/*212.5*/puestoForm("fecha_baja")/*212.29*/.error.map/*212.39*/{ error =>_display_(Seq[Any](format.raw/*212.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*213.30*/error/*213.35*/.message)),format.raw/*213.43*/("""</div>
			""")))})),format.raw/*214.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Liquidación</label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*219.6*/inputText(puestoForm("liquidacionMes.nombreLiquidacion"), 'name -> "", 'class -> "form-control", 'id -> "liquidacion_mes"))),format.raw/*219.128*/("""
				"""),_display_(Seq[Any](/*220.6*/inputText(puestoForm("liquidacion_mes_id"), 'hidden -> "hidden", 'id -> "liquidacion_mes_id"))),format.raw/*220.99*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchLiquidacionMes" 
								data-title="Selección de Liquidacion" 
								data-url=""""),_display_(Seq[Any](/*225.20*/controllers/*225.31*/.haberes.routes.LiquidacionMesesController.modalBuscar())),format.raw/*225.87*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.liquidacionMes.simple" 
								data-label="#liquidacion_mes" 
								data-field="#liquidacion_mes_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Sueldo referencia</label>
			<div class="form-group """),_display_(Seq[Any](/*240.28*/if(puestoForm.error("sueldo_referencia") != null)/*240.77*/ {_display_(Seq[Any](format.raw/*240.79*/("""has-error""")))})),format.raw/*240.89*/("""">	
				"""),_display_(Seq[Any](/*241.6*/inputText(puestoForm("sueldo_referencia"), 'class -> "form-control", 'id -> "sueldo_referencia"))),format.raw/*241.102*/("""
				"""),_display_(Seq[Any](/*242.6*/puestoForm("sueldo_referencia")/*242.37*/.error.map/*242.47*/{ error =>_display_(Seq[Any](format.raw/*242.57*/(""" <div class="text-error">"""),_display_(Seq[Any](/*242.83*/error/*242.88*/.message)),format.raw/*242.96*/("""</div>""")))})),format.raw/*242.103*/("""
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-3">
			<label class="control-label">Centro Costo</label>
				<div class="input-group """),_display_(Seq[Any](/*250.30*/if(puestoForm.error("centro_costo_id") != null)/*250.77*/ {_display_(Seq[Any](format.raw/*250.79*/("""has-error""")))}/*250.89*/else/*250.93*/{_display_(Seq[Any](format.raw/*250.94*/("""has-required""")))})),format.raw/*250.107*/("""">
					"""),_display_(Seq[Any](/*251.7*/inputText(puestoForm("centrolCosto.nombre"), 'name -> "", 'class -> "form-control", 'id -> "centro_costo"))),format.raw/*251.113*/("""
					"""),_display_(Seq[Any](/*252.7*/inputText(puestoForm("centro_costo_id"), 'hidden -> "hidden", 'id -> "centro_costo_id"))),format.raw/*252.94*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchCentroCosto" 
							 	data-title="Selección de costo" 
							 	data-url=""""),_display_(Seq[Any](/*256.21*/controllers/*256.32*/.haberes.routes.CentrosCostosController.modalBuscar())),format.raw/*256.85*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.centroCosto.simple" 
							 	data-label="#centro_costo" data-field="#centro_costo_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*262.6*/puestoForm("centro_costo_id")/*262.35*/.error.map/*262.45*/{ error =>_display_(Seq[Any](format.raw/*262.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*263.31*/error/*263.36*/.message)),format.raw/*263.44*/("""</div>
				""")))})),format.raw/*264.6*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Unidad Laboral</label>
				<div class="input-group """),_display_(Seq[Any](/*269.30*/if(puestoForm.error("unidad_laboral_id") != null)/*269.79*/ {_display_(Seq[Any](format.raw/*269.81*/("""has-error""")))}/*269.91*/else/*269.95*/{_display_(Seq[Any](format.raw/*269.96*/("""has-required""")))})),format.raw/*269.109*/("""">
					"""),_display_(Seq[Any](/*270.7*/inputText(puestoForm("unidadLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "unidad_laboral"))),format.raw/*270.116*/("""
					"""),_display_(Seq[Any](/*271.7*/inputText(puestoForm("unidad_laboral_id"), 'hidden -> "hidden", 'id -> "unidad_laboral_id"))),format.raw/*271.98*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchUnidadLaboral" 
							 	data-title="Selección de unidad" 
							 	data-url=""""),_display_(Seq[Any](/*275.21*/controllers/*275.32*/.haberes.routes.UnidadesLaboralesController.modalBuscar())),format.raw/*275.89*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.unidadLaboral.simple" 
							 	data-label="#unidad_laboral" data-field="#unidad_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*281.6*/puestoForm("unidad_laboral_id")/*281.37*/.error.map/*281.47*/{ error =>_display_(Seq[Any](format.raw/*281.57*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*282.31*/error/*282.36*/.message)),format.raw/*282.44*/("""</div>
				""")))})),format.raw/*283.6*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Instrumento Legal</label>
				<div class="input-group """),_display_(Seq[Any](/*288.30*/if(puestoForm.error("instrumento_legal_id") != null)/*288.82*/ {_display_(Seq[Any](format.raw/*288.84*/("""has-error""")))}/*288.94*/else/*288.98*/{_display_(Seq[Any](format.raw/*288.99*/("""has-required""")))})),format.raw/*288.112*/("""">
					"""),_display_(Seq[Any](/*289.7*/inputText(puestoForm("instrumentoLegal.nombre"), 'name -> "", 'class -> "form-control", 'id -> "instrumento_legal"))),format.raw/*289.122*/("""
					"""),_display_(Seq[Any](/*290.7*/inputText(puestoForm("instrumento_legal_id"), 'hidden -> "hidden", 'id -> "instrumento_legal_id"))),format.raw/*290.104*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchInstrumentoLegal" 
							 	data-title="Selección de Instrumento" 
							 	data-url=""""),_display_(Seq[Any](/*294.21*/controllers/*294.32*/.haberes.routes.InstrumentosLegalesController.modalBuscar())),format.raw/*294.91*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.instrumentoLegal.simple" 
							 	data-label="#instrumento_legal" data-field="#instrumento_legal_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*300.6*/puestoForm("instrumento_legal_id")/*300.40*/.error.map/*300.50*/{ error =>_display_(Seq[Any](format.raw/*300.60*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*301.31*/error/*301.36*/.message)),format.raw/*301.44*/("""</div>
				""")))})),format.raw/*302.6*/("""
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Convenio Banco</label>
				<div class="input-group """),_display_(Seq[Any](/*307.30*/if(puestoForm.error("convenio_banco_id") != null)/*307.79*/ {_display_(Seq[Any](format.raw/*307.81*/("""has-error""")))}/*307.91*/else/*307.95*/{_display_(Seq[Any](format.raw/*307.96*/("""has-required""")))})),format.raw/*307.109*/("""">
					"""),_display_(Seq[Any](/*308.7*/inputText(puestoForm("convenioBanco.nombre"), 'name -> "", 'class -> "form-control", 'id -> "convenio_banco"))),format.raw/*308.116*/("""
					"""),_display_(Seq[Any](/*309.7*/inputText(puestoForm("convenio_banco_id"), 'hidden -> "hidden", 'id -> "convenio_banco_id"))),format.raw/*309.98*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchConvenioBanco" 
							 	data-title="Selección de convenio" 
							 	data-url=""""),_display_(Seq[Any](/*313.21*/controllers/*313.32*/.haberes.routes.ConveniosBancosController.modalBuscar())),format.raw/*313.87*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.convenioBanco.simple" 
							 	data-label="#convenio_banco" data-field="#convenio_banco_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*319.6*/puestoForm("convenio_banco_id")/*319.37*/.error.map/*319.47*/{ error =>_display_(Seq[Any](format.raw/*319.57*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*320.31*/error/*320.36*/.message)),format.raw/*320.44*/("""</div>
				""")))})),format.raw/*321.6*/("""
		</div>
		
	</div>
"""))}
    }
    
    def render(puestoForm:Form[models.haberes.PuestoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(puestoForm)
    
    def f:((Form[models.haberes.PuestoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (puestoForm) => apply(puestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/formPuestoLaboral.scala.html
                    HASH: bba89bb9aa49d5bcf5bd14925d52176187ef2a54
                    MATRIX: 839->1|1052->131|1084->155|1158->49|1186->199|1237->223|1265->224|1407->338|1436->339|1481->356|1510->357|1679->498|1708->499|1799->562|1828->563|1859->567|1887->568|1982->636|2010->637|2038->638|2066->639|2332->869|2375->903|2414->904|2452->906|2470->915|2513->936|2534->939|2547->944|2595->946|2616->957|2698->1008|2716->1016|2753->1026|2949->1186|2966->1194|2997->1203|3277->1447|3327->1488|3367->1490|3396->1500|3409->1504|3448->1505|3494->1518|3538->1527|3664->1630|3706->1637|3803->1712|4005->1878|4025->1889|4094->1936|4361->2168|4393->2191|4412->2201|4460->2211|4527->2242|4541->2247|4571->2255|4614->2267|4770->2388|4895->2490|5042->2602|5171->2708|5253->2754|5313->2805|5353->2807|5382->2817|5395->2821|5434->2822|5480->2835|5666->2986|5767->3065|5938->3201|6039->3280|6127->3333|6169->3366|6188->3376|6236->3386|6302->3416|6316->3421|6346->3429|6388->3440|6543->3559|6600->3607|6640->3609|6669->3619|6682->3623|6721->3624|6767->3637|6811->3646|6941->3753|6983->3760|7094->3849|7294->4012|7315->4023|7393->4078|7681->4330|7721->4360|7741->4370|7790->4380|7858->4411|7873->4416|7904->4424|7948->4436|8125->4576|8184->4625|8225->4627|8255->4637|8269->4641|8309->4642|8356->4655|8401->4664|8534->4773|8577->4780|8691->4871|8893->5036|8914->5047|8993->5103|9284->5358|9325->5389|9345->5399|9394->5409|9462->5440|9477->5445|9508->5453|9552->5465|9709->5585|9766->5632|9807->5634|9837->5644|9851->5648|9891->5649|9938->5662|9983->5671|10113->5777|10156->5784|10266->5871|10473->6041|10494->6052|10567->6102|10853->6352|10892->6381|10912->6391|10961->6401|11029->6432|11044->6437|11075->6445|11119->6457|11307->6609|11422->6701|11464->6707|11573->6793|11779->6962|11800->6973|11874->7024|12291->7404|12353->7456|12394->7458|12424->7468|12438->7472|12478->7473|12525->7486|12570->7495|12709->7610|12752->7617|12873->7714|13081->7885|13102->7896|13184->7955|13484->8219|13528->8253|13548->8263|13597->8273|13665->8304|13680->8309|13711->8317|13755->8329|13885->8422|13941->8468|13982->8470|14025->8480|14146->8565|14238->8634|14289->8649|14327->8677|14347->8687|14396->8697|14463->8727|14478->8732|14509->8740|14552->8751|14651->8813|14703->8855|14744->8857|14787->8867|14900->8944|14988->9009|15039->9024|15073->9048|15093->9058|15142->9068|15209->9098|15224->9103|15255->9111|15298->9122|15397->9184|15454->9231|15495->9233|15538->9243|15661->9330|15754->9400|15805->9415|15839->9439|15859->9449|15908->9459|15975->9489|15990->9494|16021->9502|16064->9513|16224->9637|16370->9759|16412->9765|16528->9858|16741->10034|16762->10045|16841->10101|17282->10505|17341->10554|17382->10556|17425->10566|17470->10575|17590->10671|17632->10677|17673->10708|17693->10718|17742->10728|17805->10754|17820->10759|17851->10767|17892->10774|18085->10930|18142->10977|18183->10979|18213->10989|18227->10993|18267->10994|18314->11007|18359->11016|18489->11122|18532->11129|18642->11216|18841->11378|18862->11389|18938->11442|19223->11691|19262->11720|19282->11730|19331->11740|19399->11771|19414->11776|19445->11784|19489->11796|19648->11918|19707->11967|19748->11969|19778->11979|19792->11983|19832->11984|19879->11997|19924->12006|20057->12115|20100->12122|20214->12213|20416->12378|20437->12389|20517->12446|20808->12701|20849->12732|20869->12742|20918->12752|20986->12783|21001->12788|21032->12796|21076->12808|21238->12933|21300->12985|21341->12987|21371->12997|21385->13001|21425->13002|21472->13015|21517->13024|21656->13139|21699->13146|21820->13243|22030->13416|22051->13427|22133->13486|22433->13750|22477->13784|22497->13794|22546->13804|22614->13835|22629->13840|22660->13848|22704->13860|22863->13982|22922->14031|22963->14033|22993->14043|23007->14047|23047->14048|23094->14061|23139->14070|23272->14179|23315->14186|23429->14277|23633->14444|23654->14455|23732->14510|24023->14765|24064->14796|24084->14806|24133->14816|24201->14847|24216->14852|24247->14860|24291->14872
                    LINES: 26->1|35->6|35->6|36->1|37->6|39->8|39->8|43->12|43->12|44->13|44->13|50->19|50->19|52->21|52->21|53->22|53->22|55->24|55->24|56->25|56->25|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|61->30|64->33|64->33|64->33|72->41|72->41|72->41|72->41|72->41|72->41|72->41|73->42|73->42|74->43|74->43|79->48|79->48|79->48|85->54|85->54|85->54|85->54|86->55|86->55|86->55|87->56|92->61|92->61|99->68|99->68|102->71|102->71|102->71|102->71|102->71|102->71|102->71|108->77|108->77|115->84|115->84|120->89|120->89|120->89|120->89|121->90|121->90|121->90|122->91|126->95|126->95|126->95|126->95|126->95|126->95|126->95|127->96|127->96|128->97|128->97|132->101|132->101|132->101|138->107|138->107|138->107|138->107|139->108|139->108|139->108|140->109|146->115|146->115|146->115|146->115|146->115|146->115|146->115|147->116|147->116|148->117|148->117|152->121|152->121|152->121|158->127|158->127|158->127|158->127|159->128|159->128|159->128|160->129|165->134|165->134|165->134|165->134|165->134|165->134|165->134|166->135|166->135|167->136|167->136|171->140|171->140|171->140|177->146|177->146|177->146|177->146|178->147|178->147|178->147|179->148|185->154|185->154|186->155|186->155|190->159|190->159|190->159|201->170|201->170|201->170|201->170|201->170|201->170|201->170|202->171|202->171|203->172|203->172|207->176|207->176|207->176|213->182|213->182|213->182|213->182|214->183|214->183|214->183|215->184|221->190|221->190|221->190|221->190|223->192|223->192|225->194|225->194|225->194|225->194|226->195|226->195|226->195|227->196|230->199|230->199|230->199|230->199|232->201|232->201|234->203|234->203|234->203|234->203|235->204|235->204|235->204|236->205|239->208|239->208|239->208|239->208|241->210|241->210|243->212|243->212|243->212|243->212|244->213|244->213|244->213|245->214|250->219|250->219|251->220|251->220|256->225|256->225|256->225|271->240|271->240|271->240|271->240|272->241|272->241|273->242|273->242|273->242|273->242|273->242|273->242|273->242|273->242|281->250|281->250|281->250|281->250|281->250|281->250|281->250|282->251|282->251|283->252|283->252|287->256|287->256|287->256|293->262|293->262|293->262|293->262|294->263|294->263|294->263|295->264|300->269|300->269|300->269|300->269|300->269|300->269|300->269|301->270|301->270|302->271|302->271|306->275|306->275|306->275|312->281|312->281|312->281|312->281|313->282|313->282|313->282|314->283|319->288|319->288|319->288|319->288|319->288|319->288|319->288|320->289|320->289|321->290|321->290|325->294|325->294|325->294|331->300|331->300|331->300|331->300|332->301|332->301|332->301|333->302|338->307|338->307|338->307|338->307|338->307|338->307|338->307|339->308|339->308|340->309|340->309|344->313|344->313|344->313|350->319|350->319|350->319|350->319|351->320|351->320|351->320|352->321
                    -- GENERATED --
                */
            