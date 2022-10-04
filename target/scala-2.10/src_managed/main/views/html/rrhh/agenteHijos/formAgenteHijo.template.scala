
package views.html.rrhh.agenteHijos

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
object formAgenteHijo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteHijo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteHijo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.31*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*12.55*/("""
	
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*15.27*/if(lineaForm.error("nombre") != null)/*15.64*/ {_display_(Seq[Any](format.raw/*15.66*/("""has-error""")))}/*15.76*/else/*15.80*/{_display_(Seq[Any](format.raw/*15.81*/("""has-required""")))})),format.raw/*15.94*/("""">
			<label for="inputNombre" class="control-label">Apellido y Nombre</label> 
			"""),_display_(Seq[Any](/*17.5*/inputText(lineaForm("nombre"), 'class -> "form-control"))),format.raw/*17.61*/("""
			"""),_display_(Seq[Any](/*18.5*/lineaForm("nombre")/*18.24*/.error.map/*18.34*/{ error =>_display_(Seq[Any](format.raw/*18.44*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*19.30*/error/*19.35*/.message)),format.raw/*19.43*/("""</div>
			""")))})),format.raw/*20.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*24.27*/if(lineaForm.error("dni") != null)/*24.61*/ {_display_(Seq[Any](format.raw/*24.63*/("""has-error""")))}/*24.73*/else/*24.77*/{_display_(Seq[Any](format.raw/*24.78*/("""has-required""")))})),format.raw/*24.91*/("""">
			<label for="inputDni" class="control-label">Documento</label> 
			"""),_display_(Seq[Any](/*26.5*/inputText(lineaForm("dni"), 'class -> "form-control", 'id -> "dni_hijo"))),format.raw/*26.77*/("""
			"""),_display_(Seq[Any](/*27.5*/lineaForm("dni")/*27.21*/.error.map/*27.31*/{ error =>_display_(Seq[Any](format.raw/*27.41*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*28.30*/error/*28.35*/.message)),format.raw/*28.43*/("""</div>
			""")))})),format.raw/*29.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*33.27*/if(lineaForm.error("fnacimiento") != null)/*33.69*/ {_display_(Seq[Any](format.raw/*33.71*/("""has-error""")))}/*33.81*/else/*33.85*/{_display_(Seq[Any](format.raw/*33.86*/("""has-required""")))})),format.raw/*33.99*/("""">
			<label for="inputFnacimiento" class="control-label">Nacimiento</label> 
			"""),_display_(Seq[Any](/*35.5*/inputText(lineaForm("fnacimiento"), 'class -> "form-control", 'id -> "fnacimiento"))),format.raw/*35.88*/("""
			"""),_display_(Seq[Any](/*36.5*/lineaForm("fnacimiento")/*36.29*/.error.map/*36.39*/{ error =>_display_(Seq[Any](format.raw/*36.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*37.30*/error/*37.35*/.message)),format.raw/*37.43*/("""</div>
			""")))})),format.raw/*38.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*42.27*/if(lineaForm.error("sexo") != null)/*42.62*/ {_display_(Seq[Any](format.raw/*42.64*/("""has-error""")))}/*42.74*/else/*42.78*/{_display_(Seq[Any](format.raw/*42.79*/("""has-required""")))})),format.raw/*42.92*/("""">
			<label for=""""),_display_(Seq[Any](/*43.17*/lineaForm("sexo"))),format.raw/*43.34*/("""" class="control-label">Sexo</label>
			"""),_display_(Seq[Any](/*44.5*/select(lineaForm("sexo"), options("male"->"Masculino","famele"->"Femenino"), 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*45.64*/("""
			"""),_display_(Seq[Any](/*46.5*/lineaForm("sexo")/*46.22*/.error.map/*46.32*/{ error =>_display_(Seq[Any](format.raw/*46.42*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*47.30*/error/*47.35*/.message)),format.raw/*47.43*/("""</div>
			""")))})),format.raw/*48.5*/("""
		</div>
	</div>
	<div class="col-sm-2 """),_display_(Seq[Any](/*51.24*/if(lineaForm.error("activo") != null)/*51.61*/ {_display_(Seq[Any](format.raw/*51.63*/("""has-error""")))}/*51.73*/else/*51.77*/{_display_(Seq[Any](format.raw/*51.78*/("""has-required""")))})),format.raw/*51.91*/("""">
		<b>¿Vive?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*57.8*/inputRadioGroup(lineaForm("vive"), options = Seq("true"->"Si")))),format.raw/*57.71*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*64.8*/inputRadioGroup(lineaForm("vive"),options = Seq("false"->"No")))),format.raw/*64.71*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*69.4*/lineaForm("vive")/*69.21*/.error.map/*69.31*/{ error =>_display_(Seq[Any](format.raw/*69.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*70.29*/error/*70.34*/.message)),format.raw/*70.42*/("""</div>
		""")))})),format.raw/*71.4*/("""
	</div> 
</div>

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputCodigoConvivencia" class="control-label">Codigo Convivencia</label> 
			"""),_display_(Seq[Any](/*79.5*/inputText(lineaForm("cod_convivencia"), 'class -> "form-control"))),format.raw/*79.70*/("""
			"""),_display_(Seq[Any](/*80.5*/lineaForm("cod_convivencia")/*80.33*/.error.map/*80.43*/{ error =>_display_(Seq[Any](format.raw/*80.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*81.30*/error/*81.35*/.message)),format.raw/*81.43*/("""</div>
			""")))})),format.raw/*82.5*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputCodigoActividad" class="control-label">Codigo Actividad</label> 
			"""),_display_(Seq[Any](/*88.5*/inputText(lineaForm("cod_actividad"), 'class -> "form-control"))),format.raw/*88.68*/("""
			"""),_display_(Seq[Any](/*89.5*/lineaForm("cod_actividad")/*89.31*/.error.map/*89.41*/{ error =>_display_(Seq[Any](format.raw/*89.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*90.30*/error/*90.35*/.message)),format.raw/*90.43*/("""</div>
			""")))})),format.raw/*91.5*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*95.27*/if(lineaForm.error("estado_civil_id") != null)/*95.73*/ {_display_(Seq[Any](format.raw/*95.75*/("""has-error""")))}/*95.85*/else/*95.89*/{_display_(Seq[Any](format.raw/*95.90*/("""has-required""")))})),format.raw/*95.103*/("""">
			<label for=""""),_display_(Seq[Any](/*96.17*/lineaForm("estado_civil_id"))),format.raw/*96.45*/("""" class="control-label">Estado Civil</label>
			"""),_display_(Seq[Any](/*97.5*/select(lineaForm("estado_civil_id"), 
			EstadoCivil.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*99.64*/("""
			
			"""),_display_(Seq[Any](/*101.5*/lineaForm("estado_civil_id")/*101.33*/.error.map/*101.43*/{ error =>_display_(Seq[Any](format.raw/*101.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*102.30*/error/*102.35*/.message)),format.raw/*102.43*/("""</div>
			""")))})),format.raw/*103.5*/("""
		</div>
	</div>
</div>	
<div class="row">
	
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*112.27*/if(lineaForm.error("estudio_nivel_id") != null)/*112.74*/ {_display_(Seq[Any](format.raw/*112.76*/("""has-error""")))})),format.raw/*112.86*/("""">
			<label for=""""),_display_(Seq[Any](/*113.17*/lineaForm("estudio_nivel_id"))),format.raw/*113.46*/("""" class="control-label">Estudio Nivel</label>
			"""),_display_(Seq[Any](/*114.5*/select(lineaForm("estudio_nivel_id"), 
			EstudioNivel.find.orderBy("orden asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*116.64*/("""
			
			"""),_display_(Seq[Any](/*118.5*/lineaForm("estudio_nivel_id")/*118.34*/.error.map/*118.44*/{ error =>_display_(Seq[Any](format.raw/*118.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*119.30*/error/*119.35*/.message)),format.raw/*119.43*/("""</div>
			""")))})),format.raw/*120.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*125.27*/if(lineaForm.error("estudio_estado_id") != null)/*125.75*/ {_display_(Seq[Any](format.raw/*125.77*/("""has-error""")))})),format.raw/*125.87*/("""">
			<label for=""""),_display_(Seq[Any](/*126.17*/lineaForm("estudio_estado_id"))),format.raw/*126.47*/("""" class="control-label">Estudio Estado</label>
			"""),_display_(Seq[Any](/*127.5*/select(lineaForm("estudio_estado_id"), 
			EstudioEstado.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*129.64*/("""
			
			"""),_display_(Seq[Any](/*131.5*/lineaForm("estudio_estado_id")/*131.35*/.error.map/*131.45*/{ error =>_display_(Seq[Any](format.raw/*131.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*132.30*/error/*132.35*/.message)),format.raw/*132.43*/("""</div>
			""")))})),format.raw/*133.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputFinicioCAr" class="control-label">Inicio Certificado</label> 
			"""),_display_(Seq[Any](/*140.5*/inputText(lineaForm("finicio_certificado_ar"), 'class -> "form-control", 'id -> "finicio_certificado_ar"))),format.raw/*140.110*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputFfinCAr" class="control-label">Fin Certificado</label> 
			"""),_display_(Seq[Any](/*146.5*/inputText(lineaForm("ffin_certificado_ar"), 'class -> "form-control", 'id -> "ffin_certificado_ar"))),format.raw/*146.104*/("""
		</div>
	</div>
	
	
</div>	
<div class="row">	
	<div class="col-sm-2 """),_display_(Seq[Any](/*153.24*/if(lineaForm.error("discapacidad") != null)/*153.67*/ {_display_(Seq[Any](format.raw/*153.69*/("""has-error""")))}/*153.79*/else/*153.83*/{_display_(Seq[Any](format.raw/*153.84*/("""has-required""")))})),format.raw/*153.97*/("""">
		<b>¿Discapacidad?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*159.8*/inputRadioGroup(lineaForm("discapacidad"), options = Seq("true"->"Si")))),format.raw/*159.79*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*166.8*/inputRadioGroup(lineaForm("discapacidad"),options = Seq("false"->"No")))),format.raw/*166.79*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*171.4*/lineaForm("discapacidad")/*171.29*/.error.map/*171.39*/{ error =>_display_(Seq[Any](format.raw/*171.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*172.29*/error/*172.34*/.message)),format.raw/*172.42*/("""</div>
		""")))})),format.raw/*173.4*/("""
	</div> 
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputNombre" class="control-label">Nivel Discapacidad %</label> 
			"""),_display_(Seq[Any](/*178.5*/inputText(lineaForm("discapacidad_nivel"), 'class -> "form-control",'id->"discapacidadNivel"))),format.raw/*178.98*/("""
		</div>
	</div>
	<div class="col-sm-2 """),_display_(Seq[Any](/*181.24*/if(lineaForm.error("discapacidad") != null)/*181.67*/ {_display_(Seq[Any](format.raw/*181.69*/("""has-error""")))}/*181.79*/else/*181.83*/{_display_(Seq[Any](format.raw/*181.84*/("""has-required""")))})),format.raw/*181.97*/("""">
		<b>¿Adoptado?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*187.8*/inputRadioGroup(lineaForm("adoptado"), options = Seq("true"->"Si")))),format.raw/*187.75*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*194.8*/inputRadioGroup(lineaForm("adoptado"),options = Seq("false"->"No")))),format.raw/*194.75*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*199.4*/lineaForm("discapacidad")/*199.29*/.error.map/*199.39*/{ error =>_display_(Seq[Any](format.raw/*199.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*200.29*/error/*200.34*/.message)),format.raw/*200.42*/("""</div>
		""")))})),format.raw/*201.4*/("""
	</div> 
	<div class="col-sm-4 """),_display_(Seq[Any](/*203.24*/if(lineaForm.error("carga_en_conyugue") != null)/*203.72*/ {_display_(Seq[Any](format.raw/*203.74*/("""has-error""")))}/*203.84*/else/*203.88*/{_display_(Seq[Any](format.raw/*203.89*/("""has-required""")))})),format.raw/*203.102*/("""">
		<b>¿Cargado en Conyugue?</b>
		<div class="row">
			<div class="col-sm-3">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*209.8*/inputRadioGroup(lineaForm("carga_en_conyugue"), options = Seq("true"->"Si")))),format.raw/*209.84*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="radio">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*216.8*/inputRadioGroup(lineaForm("carga_en_conyugue"),options = Seq("false"->"No")))),format.raw/*216.84*/("""
					</label>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*221.4*/lineaForm("carga_en_conyugue")/*221.34*/.error.map/*221.44*/{ error =>_display_(Seq[Any](format.raw/*221.54*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*222.29*/error/*222.34*/.message)),format.raw/*222.42*/("""</div>
		""")))})),format.raw/*223.4*/("""
	</div> 
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*234.14*/("""{"""),format.raw/*234.15*/("""
	$("#discapacidadNivel").numeric_input();
	$("#discapacidadNivel").mask("99");
	
	$("#dni_hijo").mask("99999999");
	$("#fnacimiento,#finicio_certificado_ar,#ffin_certificado_ar").mask("99/99/9999");
"""),format.raw/*240.1*/("""}"""),format.raw/*240.2*/(""");
</script>	


"""),_display_(Seq[Any](/*244.2*/flash()/*244.9*/.clear())))}
    }
    
    def render(lineaForm:Form[AgenteHijo]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteHijo]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteHijos/formAgenteHijo.scala.html
                    HASH: e49d98b392713a8a793a0c8a56487671e89d80e3
                    MATRIX: 810->1|942->51|974->75|1048->30|1077->119|1117->125|1155->155|1194->157|1317->245|1330->250|1364->263|1406->275|1466->300|1540->352|1632->408|1678->445|1718->447|1747->457|1760->461|1799->462|1844->475|1965->561|2043->617|2084->623|2112->642|2131->652|2179->662|2246->693|2260->698|2290->706|2333->718|2441->790|2484->824|2524->826|2553->836|2566->840|2605->841|2650->854|2760->929|2854->1001|2895->1007|2920->1023|2939->1033|2987->1043|3054->1074|3068->1079|3098->1087|3141->1099|3249->1171|3300->1213|3340->1215|3369->1225|3382->1229|3421->1230|3466->1243|3585->1327|3690->1410|3731->1416|3764->1440|3783->1450|3831->1460|3898->1491|3912->1496|3942->1504|3985->1516|4093->1588|4137->1623|4177->1625|4206->1635|4219->1639|4258->1640|4303->1653|4359->1673|4398->1690|4475->1732|4639->1874|4680->1880|4706->1897|4725->1907|4773->1917|4840->1948|4854->1953|4884->1961|4927->1973|5007->2017|5053->2054|5093->2056|5122->2066|5135->2070|5174->2071|5219->2084|5392->2222|5477->2285|5648->2421|5733->2484|5821->2537|5847->2554|5866->2564|5914->2574|5980->2604|5994->2609|6024->2617|6066->2628|6289->2816|6376->2881|6417->2887|6454->2915|6473->2925|6521->2935|6588->2966|6602->2971|6632->2979|6675->2991|6874->3155|6959->3218|7000->3224|7035->3250|7054->3260|7102->3270|7169->3301|7183->3306|7213->3314|7256->3326|7364->3398|7419->3444|7459->3446|7488->3456|7501->3460|7540->3461|7586->3474|7642->3494|7692->3522|7777->3572|7968->3741|8015->3752|8053->3780|8073->3790|8122->3800|8190->3831|8205->3836|8236->3844|8280->3856|8447->3986|8504->4033|8545->4035|8588->4045|8645->4065|8697->4094|8784->4145|9004->4342|9051->4353|9090->4382|9110->4392|9159->4402|9227->4433|9242->4438|9273->4446|9317->4458|9429->4533|9487->4581|9528->4583|9571->4593|9628->4613|9681->4643|9769->4695|9965->4868|10012->4879|10052->4909|10072->4919|10121->4929|10189->4960|10204->4965|10235->4973|10279->4985|10479->5149|10608->5254|10799->5409|10922->5508|11038->5587|11091->5630|11132->5632|11162->5642|11176->5646|11216->5647|11262->5660|11444->5806|11538->5877|11710->6013|11804->6084|11893->6137|11928->6162|11948->6172|11997->6182|12064->6212|12079->6217|12110->6225|12153->6236|12339->6386|12455->6479|12536->6523|12589->6566|12630->6568|12660->6578|12674->6582|12714->6583|12760->6596|12938->6738|13028->6805|13200->6941|13290->7008|13379->7061|13414->7086|13434->7096|13483->7106|13550->7136|13565->7141|13596->7149|13639->7160|13711->7195|13769->7243|13810->7245|13840->7255|13854->7259|13894->7260|13941->7273|14130->7426|14229->7502|14401->7638|14500->7714|14589->7767|14629->7797|14649->7807|14698->7817|14765->7847|14780->7852|14811->7860|14854->7871|15255->8243|15285->8244|15519->8450|15548->8451|15605->8472|15621->8479
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|43->15|43->15|43->15|43->15|43->15|43->15|43->15|45->17|45->17|46->18|46->18|46->18|46->18|47->19|47->19|47->19|48->20|52->24|52->24|52->24|52->24|52->24|52->24|52->24|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|57->29|61->33|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|70->42|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|72->44|73->45|74->46|74->46|74->46|74->46|75->47|75->47|75->47|76->48|79->51|79->51|79->51|79->51|79->51|79->51|79->51|85->57|85->57|92->64|92->64|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|107->79|107->79|108->80|108->80|108->80|108->80|109->81|109->81|109->81|110->82|116->88|116->88|117->89|117->89|117->89|117->89|118->90|118->90|118->90|119->91|123->95|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|125->97|127->99|129->101|129->101|129->101|129->101|130->102|130->102|130->102|131->103|140->112|140->112|140->112|140->112|141->113|141->113|142->114|144->116|146->118|146->118|146->118|146->118|147->119|147->119|147->119|148->120|153->125|153->125|153->125|153->125|154->126|154->126|155->127|157->129|159->131|159->131|159->131|159->131|160->132|160->132|160->132|161->133|168->140|168->140|174->146|174->146|181->153|181->153|181->153|181->153|181->153|181->153|181->153|187->159|187->159|194->166|194->166|199->171|199->171|199->171|199->171|200->172|200->172|200->172|201->173|206->178|206->178|209->181|209->181|209->181|209->181|209->181|209->181|209->181|215->187|215->187|222->194|222->194|227->199|227->199|227->199|227->199|228->200|228->200|228->200|229->201|231->203|231->203|231->203|231->203|231->203|231->203|231->203|237->209|237->209|244->216|244->216|249->221|249->221|249->221|249->221|250->222|250->222|250->222|251->223|262->234|262->234|268->240|268->240|272->244|272->244
                    -- GENERATED --
                */
            