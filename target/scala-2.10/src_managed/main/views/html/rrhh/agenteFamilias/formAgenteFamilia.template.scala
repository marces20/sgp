
package views.html.rrhh.agenteFamilias

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
object formAgenteFamilia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteFamilia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteFamilia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*12.55*/("""
	<div class="col-sm-3">
	</div>
	<div class="col-sm-6">
		<div class="form-group """),_display_(Seq[Any](/*16.27*/if(lineaForm.error("tipo_familia_id") != null)/*16.73*/ {_display_(Seq[Any](format.raw/*16.75*/("""has-error""")))}/*16.85*/else/*16.89*/{_display_(Seq[Any](format.raw/*16.90*/("""has-required""")))})),format.raw/*16.103*/("""">
			<label for=""""),_display_(Seq[Any](/*17.17*/lineaForm("tipo_familia_id"))),format.raw/*17.45*/("""" class="control-label">Tipo Familiar</label>
			"""),_display_(Seq[Any](/*18.5*/select(lineaForm("tipo_familia_id"), 
			TipoFamiliar.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*20.64*/(""", 
			
			"""),_display_(Seq[Any](/*22.5*/lineaForm("tipo_familia_id")/*22.33*/.error.map/*22.43*/{ error =>_display_(Seq[Any](format.raw/*22.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*23.30*/error/*23.35*/.message)),format.raw/*23.43*/("""</div>
			""")))})),format.raw/*24.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputFpresentacion" class="control-label">Fecha Presentacion</label> 
			"""),_display_(Seq[Any](/*30.5*/inputText(lineaForm("fpresentacion"), 'class -> "form-control", 'id -> "fpresentacion"))),format.raw/*30.92*/("""
		</div>
	</div>
	 
</div>	
<div class="row">
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*37.27*/if(lineaForm.error("nombre") != null)/*37.64*/ {_display_(Seq[Any](format.raw/*37.66*/("""has-error""")))}/*37.76*/else/*37.80*/{_display_(Seq[Any](format.raw/*37.81*/("""has-required""")))})),format.raw/*37.94*/("""">
			<label for="inputNombre" class="control-label">Apellido y Nombre</label> 
			"""),_display_(Seq[Any](/*39.5*/inputText(lineaForm("nombre"), 'class -> "form-control"))),format.raw/*39.61*/("""
			"""),_display_(Seq[Any](/*40.5*/lineaForm("nombre")/*40.24*/.error.map/*40.34*/{ error =>_display_(Seq[Any](format.raw/*40.44*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*41.30*/error/*41.35*/.message)),format.raw/*41.43*/("""</div>
			""")))})),format.raw/*42.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*46.27*/if(lineaForm.error("dni") != null)/*46.61*/ {_display_(Seq[Any](format.raw/*46.63*/("""has-error""")))}/*46.73*/else/*46.77*/{_display_(Seq[Any](format.raw/*46.78*/("""has-required""")))})),format.raw/*46.91*/("""">
			<label for="inputDni" class="control-label">Documento</label> 
			"""),_display_(Seq[Any](/*48.5*/inputText(lineaForm("dni"), 'class -> "form-control", 'id -> "dni_familia"))),format.raw/*48.80*/("""
			"""),_display_(Seq[Any](/*49.5*/lineaForm("dni")/*49.21*/.error.map/*49.31*/{ error =>_display_(Seq[Any](format.raw/*49.41*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*50.30*/error/*50.35*/.message)),format.raw/*50.43*/("""</div>
			""")))})),format.raw/*51.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*55.27*/if(lineaForm.error("fnacimiento") != null)/*55.69*/ {_display_(Seq[Any](format.raw/*55.71*/("""has-error""")))}/*55.81*/else/*55.85*/{_display_(Seq[Any](format.raw/*55.86*/("""has-required""")))})),format.raw/*55.99*/("""">
			<label for="inputFnacimiento" class="control-label">Nacimiento</label> 
			"""),_display_(Seq[Any](/*57.5*/inputText(lineaForm("fnacimiento"), 'class -> "form-control", 'id -> "fnacimiento"))),format.raw/*57.88*/("""
			"""),_display_(Seq[Any](/*58.5*/lineaForm("fnacimiento")/*58.29*/.error.map/*58.39*/{ error =>_display_(Seq[Any](format.raw/*58.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*59.30*/error/*59.35*/.message)),format.raw/*59.43*/("""</div>
			""")))})),format.raw/*60.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*64.27*/if(lineaForm.error("sexo") != null)/*64.62*/ {_display_(Seq[Any](format.raw/*64.64*/("""has-error""")))}/*64.74*/else/*64.78*/{_display_(Seq[Any](format.raw/*64.79*/("""has-required""")))})),format.raw/*64.92*/("""">
			<label for=""""),_display_(Seq[Any](/*65.17*/lineaForm("sexo"))),format.raw/*65.34*/("""" class="control-label">Sexo</label>
			"""),_display_(Seq[Any](/*66.5*/select(lineaForm("sexo"), options("male"->"Masculino","famele"->"Femenino"), 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*67.64*/("""
			"""),_display_(Seq[Any](/*68.5*/lineaForm("sexo")/*68.22*/.error.map/*68.32*/{ error =>_display_(Seq[Any](format.raw/*68.42*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*69.30*/error/*69.35*/.message)),format.raw/*69.43*/("""</div>
			""")))})),format.raw/*70.5*/("""
		</div>
	</div>
	<div class="col-sm-2 """),_display_(Seq[Any](/*73.24*/if(lineaForm.error("activo") != null)/*73.61*/ {_display_(Seq[Any](format.raw/*73.63*/("""has-error""")))}/*73.73*/else/*73.77*/{_display_(Seq[Any](format.raw/*73.78*/("""has-required""")))})),format.raw/*73.91*/("""">
		<b>¿Vive?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*79.8*/inputRadioGroup(lineaForm("vive"), options = Seq("true"->"Si")))),format.raw/*79.71*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*86.8*/inputRadioGroup(lineaForm("vive"),options = Seq("false"->"No")))),format.raw/*86.71*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*91.4*/lineaForm("vive")/*91.21*/.error.map/*91.31*/{ error =>_display_(Seq[Any](format.raw/*91.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*92.29*/error/*92.34*/.message)),format.raw/*92.42*/("""</div>
		""")))})),format.raw/*93.4*/("""
	</div> 
</div>

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputCodigoConvivencia" class="control-label">Codigo Convivencia</label> 
			"""),_display_(Seq[Any](/*101.5*/inputText(lineaForm("cod_convivencia"), 'class -> "form-control"))),format.raw/*101.70*/("""
			"""),_display_(Seq[Any](/*102.5*/lineaForm("cod_convivencia")/*102.33*/.error.map/*102.43*/{ error =>_display_(Seq[Any](format.raw/*102.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*103.30*/error/*103.35*/.message)),format.raw/*103.43*/("""</div>
			""")))})),format.raw/*104.5*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputCodigoActividad" class="control-label">Codigo Actividad</label> 
			"""),_display_(Seq[Any](/*110.5*/inputText(lineaForm("cod_actividad"), 'class -> "form-control"))),format.raw/*110.68*/("""
			"""),_display_(Seq[Any](/*111.5*/lineaForm("cod_actividad")/*111.31*/.error.map/*111.41*/{ error =>_display_(Seq[Any](format.raw/*111.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*112.30*/error/*112.35*/.message)),format.raw/*112.43*/("""</div>
			""")))})),format.raw/*113.5*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*117.27*/if(lineaForm.error("estado_civil_id") != null)/*117.73*/ {_display_(Seq[Any](format.raw/*117.75*/("""has-error""")))}/*117.85*/else/*117.89*/{_display_(Seq[Any](format.raw/*117.90*/("""has-required""")))})),format.raw/*117.103*/("""">
			<label for=""""),_display_(Seq[Any](/*118.17*/lineaForm("estado_civil_id"))),format.raw/*118.45*/("""" class="control-label">Estado Civil</label>
			"""),_display_(Seq[Any](/*119.5*/select(lineaForm("estado_civil_id"), 
			EstadoCivil.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*121.64*/("""
			
			"""),_display_(Seq[Any](/*123.5*/lineaForm("estado_civil_id")/*123.33*/.error.map/*123.43*/{ error =>_display_(Seq[Any](format.raw/*123.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*124.30*/error/*124.35*/.message)),format.raw/*124.43*/("""</div>
			""")))})),format.raw/*125.5*/("""
		</div>
	</div>
</div>	
<div class="row">
	
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*134.27*/if(lineaForm.error("estudio_nivel_id") != null)/*134.74*/ {_display_(Seq[Any](format.raw/*134.76*/("""has-error""")))})),format.raw/*134.86*/("""">
			<label for=""""),_display_(Seq[Any](/*135.17*/lineaForm("estudio_nivel_id"))),format.raw/*135.46*/("""" class="control-label">Estudio Nivel</label>
			"""),_display_(Seq[Any](/*136.5*/select(lineaForm("estudio_nivel_id"), 
			EstudioNivel.find.orderBy("orden asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*138.64*/("""
			
			"""),_display_(Seq[Any](/*140.5*/lineaForm("estudio_nivel_id")/*140.34*/.error.map/*140.44*/{ error =>_display_(Seq[Any](format.raw/*140.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*141.30*/error/*141.35*/.message)),format.raw/*141.43*/("""</div>
			""")))})),format.raw/*142.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*147.27*/if(lineaForm.error("estudio_estado_id") != null)/*147.75*/ {_display_(Seq[Any](format.raw/*147.77*/("""has-error""")))})),format.raw/*147.87*/("""">
			<label for=""""),_display_(Seq[Any](/*148.17*/lineaForm("estudio_estado_id"))),format.raw/*148.47*/("""" class="control-label">Estudio Estado</label>
			"""),_display_(Seq[Any](/*149.5*/select(lineaForm("estudio_estado_id"), 
			EstudioEstado.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*151.64*/("""
			
			"""),_display_(Seq[Any](/*153.5*/lineaForm("estudio_estado_id")/*153.35*/.error.map/*153.45*/{ error =>_display_(Seq[Any](format.raw/*153.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*154.30*/error/*154.35*/.message)),format.raw/*154.43*/("""</div>
			""")))})),format.raw/*155.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputFinicioCAr" class="control-label">Inicio Certificado</label> 
			"""),_display_(Seq[Any](/*162.5*/inputText(lineaForm("finicio_certificado_ar"), 'class -> "form-control", 'id -> "finicio_certificado_ar"))),format.raw/*162.110*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputFfinCAr" class="control-label">Fin Certificado</label> 
			"""),_display_(Seq[Any](/*168.5*/inputText(lineaForm("ffin_certificado_ar"), 'class -> "form-control", 'id -> "ffin_certificado_ar"))),format.raw/*168.104*/("""
		</div>
	</div>
	
	
</div>	
<div class="row">	
	<div class="col-sm-2 """),_display_(Seq[Any](/*175.24*/if(lineaForm.error("discapacidad") != null)/*175.67*/ {_display_(Seq[Any](format.raw/*175.69*/("""has-error""")))}/*175.79*/else/*175.83*/{_display_(Seq[Any](format.raw/*175.84*/("""has-required""")))})),format.raw/*175.97*/("""">
		<b>¿Discapacidad?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*181.8*/inputRadioGroup(lineaForm("discapacidad"), options = Seq("true"->"Si")))),format.raw/*181.79*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*188.8*/inputRadioGroup(lineaForm("discapacidad"),options = Seq("false"->"No")))),format.raw/*188.79*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*193.4*/lineaForm("discapacidad")/*193.29*/.error.map/*193.39*/{ error =>_display_(Seq[Any](format.raw/*193.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*194.29*/error/*194.34*/.message)),format.raw/*194.42*/("""</div>
		""")))})),format.raw/*195.4*/("""
	</div> 
	<div class="col-sm-2">
		<div class="form-group">
			<label for="inputNombre" class="control-label">Nivel Discapacidad %</label> 
			"""),_display_(Seq[Any](/*200.5*/inputText(lineaForm("discapacidad_nivel"), 'class -> "form-control",'id->"discapacidadNivel"))),format.raw/*200.98*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label for="inputFfinCAr" class="control-label">Fecha Fin Discapacidad</label> 
			"""),_display_(Seq[Any](/*206.5*/inputText(lineaForm("f_discapacidad"), 'class -> "form-control", 'id -> "f_discapacidad"))),format.raw/*206.94*/("""
		</div>
	</div>
	<div class="col-sm-2 """),_display_(Seq[Any](/*209.24*/if(lineaForm.error("discapacidad") != null)/*209.67*/ {_display_(Seq[Any](format.raw/*209.69*/("""has-error""")))}/*209.79*/else/*209.83*/{_display_(Seq[Any](format.raw/*209.84*/("""has-required""")))})),format.raw/*209.97*/("""">
		<b>¿Adoptado?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*215.8*/inputRadioGroup(lineaForm("adoptado"), options = Seq("true"->"Si")))),format.raw/*215.75*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*222.8*/inputRadioGroup(lineaForm("adoptado"),options = Seq("false"->"No")))),format.raw/*222.75*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*227.4*/lineaForm("discapacidad")/*227.29*/.error.map/*227.39*/{ error =>_display_(Seq[Any](format.raw/*227.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*228.29*/error/*228.34*/.message)),format.raw/*228.42*/("""</div>
		""")))})),format.raw/*229.4*/("""
	</div> 
	<div class="col-sm-4 """),_display_(Seq[Any](/*231.24*/if(lineaForm.error("carga_en_conyugue") != null)/*231.72*/ {_display_(Seq[Any](format.raw/*231.74*/("""has-error""")))}/*231.84*/else/*231.88*/{_display_(Seq[Any](format.raw/*231.89*/("""has-required""")))})),format.raw/*231.102*/("""">
		<b>¿Cargado en Conyugue?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*237.8*/inputRadioGroup(lineaForm("carga_en_conyugue"), options = Seq("true"->"Si")))),format.raw/*237.84*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*244.8*/inputRadioGroup(lineaForm("carga_en_conyugue"),options = Seq("false"->"No")))),format.raw/*244.84*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*249.4*/lineaForm("carga_en_conyugue")/*249.34*/.error.map/*249.44*/{ error =>_display_(Seq[Any](format.raw/*249.54*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*250.29*/error/*250.34*/.message)),format.raw/*250.42*/("""</div>
		""")))})),format.raw/*251.4*/("""
	</div> 
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*262.14*/("""{"""),format.raw/*262.15*/("""
	$("#discapacidadNivel").numeric_input();
	$("#discapacidadNivel").mask("99");
	
	$("#dni_familia").mask("99999999");
	$("#fnacimiento,#f_discapacidad,#fpresentacion,#finicio_certificado_ar,#ffin_certificado_ar").mask("99/99/9999");
"""),format.raw/*268.1*/("""}"""),format.raw/*268.2*/(""");
</script>	


"""),_display_(Seq[Any](/*272.2*/flash()/*272.9*/.clear())))}
    }
    
    def render(lineaForm:Form[AgenteFamilia]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteFamilia]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteFamilias/formAgenteFamilia.scala.html
                    HASH: e969d833f0ae28354446ae8c6e925815fe7784e1
                    MATRIX: 819->1|954->54|986->78|1060->33|1089->122|1129->128|1167->158|1206->160|1329->248|1342->253|1376->266|1418->278|1478->303|1552->355|1675->442|1730->488|1770->490|1799->500|1812->504|1851->505|1897->518|1953->538|2003->566|2089->617|2281->787|2329->800|2366->828|2385->838|2433->848|2500->879|2514->884|2544->892|2587->904|2786->1068|2895->1155|3035->1259|3081->1296|3121->1298|3150->1308|3163->1312|3202->1313|3247->1326|3368->1412|3446->1468|3487->1474|3515->1493|3534->1503|3582->1513|3649->1544|3663->1549|3693->1557|3736->1569|3844->1641|3887->1675|3927->1677|3956->1687|3969->1691|4008->1692|4053->1705|4163->1780|4260->1855|4301->1861|4326->1877|4345->1887|4393->1897|4460->1928|4474->1933|4504->1941|4547->1953|4655->2025|4706->2067|4746->2069|4775->2079|4788->2083|4827->2084|4872->2097|4991->2181|5096->2264|5137->2270|5170->2294|5189->2304|5237->2314|5304->2345|5318->2350|5348->2358|5391->2370|5499->2442|5543->2477|5583->2479|5612->2489|5625->2493|5664->2494|5709->2507|5765->2527|5804->2544|5881->2586|6045->2728|6086->2734|6112->2751|6131->2761|6179->2771|6246->2802|6260->2807|6290->2815|6333->2827|6413->2871|6459->2908|6499->2910|6528->2920|6541->2924|6580->2925|6625->2938|6798->3076|6883->3139|7054->3275|7139->3338|7227->3391|7253->3408|7272->3418|7320->3428|7386->3458|7400->3463|7430->3471|7472->3482|7696->3670|7784->3735|7826->3741|7864->3769|7884->3779|7933->3789|8001->3820|8016->3825|8047->3833|8091->3845|8291->4009|8377->4072|8419->4078|8455->4104|8475->4114|8524->4124|8592->4155|8607->4160|8638->4168|8682->4180|8791->4252|8847->4298|8888->4300|8918->4310|8932->4314|8972->4315|9019->4328|9076->4348|9127->4376|9213->4426|9405->4595|9452->4606|9490->4634|9510->4644|9559->4654|9627->4685|9642->4690|9673->4698|9717->4710|9884->4840|9941->4887|9982->4889|10025->4899|10082->4919|10134->4948|10221->4999|10441->5196|10488->5207|10527->5236|10547->5246|10596->5256|10664->5287|10679->5292|10710->5300|10754->5312|10866->5387|10924->5435|10965->5437|11008->5447|11065->5467|11118->5497|11206->5549|11402->5722|11449->5733|11489->5763|11509->5773|11558->5783|11626->5814|11641->5819|11672->5827|11716->5839|11916->6003|12045->6108|12236->6263|12359->6362|12475->6441|12528->6484|12569->6486|12599->6496|12613->6500|12653->6501|12699->6514|12881->6660|12975->6731|13147->6867|13241->6938|13330->6991|13365->7016|13385->7026|13434->7036|13501->7066|13516->7071|13547->7079|13590->7090|13776->7240|13892->7333|14090->7495|14202->7584|14283->7628|14336->7671|14377->7673|14407->7683|14421->7687|14461->7688|14507->7701|14685->7843|14775->7910|14947->8046|15037->8113|15126->8166|15161->8191|15181->8201|15230->8211|15297->8241|15312->8246|15343->8254|15386->8265|15458->8300|15516->8348|15557->8350|15587->8360|15601->8364|15641->8365|15688->8378|15877->8531|15976->8607|16148->8743|16247->8819|16336->8872|16376->8902|16396->8912|16445->8922|16512->8952|16527->8957|16558->8965|16601->8976|17002->9348|17032->9349|17300->9589|17329->9590|17386->9611|17402->9618
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|46->18|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|58->30|58->30|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|67->39|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|74->46|74->46|74->46|74->46|74->46|74->46|74->46|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|78->50|79->51|83->55|83->55|83->55|83->55|83->55|83->55|83->55|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|92->64|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|94->66|95->67|96->68|96->68|96->68|96->68|97->69|97->69|97->69|98->70|101->73|101->73|101->73|101->73|101->73|101->73|101->73|107->79|107->79|114->86|114->86|119->91|119->91|119->91|119->91|120->92|120->92|120->92|121->93|129->101|129->101|130->102|130->102|130->102|130->102|131->103|131->103|131->103|132->104|138->110|138->110|139->111|139->111|139->111|139->111|140->112|140->112|140->112|141->113|145->117|145->117|145->117|145->117|145->117|145->117|145->117|146->118|146->118|147->119|149->121|151->123|151->123|151->123|151->123|152->124|152->124|152->124|153->125|162->134|162->134|162->134|162->134|163->135|163->135|164->136|166->138|168->140|168->140|168->140|168->140|169->141|169->141|169->141|170->142|175->147|175->147|175->147|175->147|176->148|176->148|177->149|179->151|181->153|181->153|181->153|181->153|182->154|182->154|182->154|183->155|190->162|190->162|196->168|196->168|203->175|203->175|203->175|203->175|203->175|203->175|203->175|209->181|209->181|216->188|216->188|221->193|221->193|221->193|221->193|222->194|222->194|222->194|223->195|228->200|228->200|234->206|234->206|237->209|237->209|237->209|237->209|237->209|237->209|237->209|243->215|243->215|250->222|250->222|255->227|255->227|255->227|255->227|256->228|256->228|256->228|257->229|259->231|259->231|259->231|259->231|259->231|259->231|259->231|265->237|265->237|272->244|272->244|277->249|277->249|277->249|277->249|278->250|278->250|278->250|279->251|290->262|290->262|296->268|296->268|300->272|300->272
                    -- GENERATED --
                */
            