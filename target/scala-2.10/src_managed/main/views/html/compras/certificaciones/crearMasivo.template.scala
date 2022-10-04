
package views.html.compras.certificaciones

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
object crearMasivo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Certificacion],HashMap[String, List[String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[Certificacion], lista: HashMap[String, List[String]] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/compras/certificaciones.js"))),format.raw/*8.74*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*4.1*/("""
"""),format.raw/*5.70*/(""" 
	
"""),format.raw/*9.2*/("""

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.compras.mainCompras("Crear certificaciones masivamemente para guardias monotributos", scripts)/*11.107*/ {_display_(Seq[Any](format.raw/*11.109*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear certificaciones masivamemente para guardias monotributos</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*21.3*/views/*21.8*/.html.tags.successError())),format.raw/*21.33*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.compras.routes.CertificacionesController.procesarMasivo(), 'id -> "formNovedadesMasivo", 'enctype -> "multipart/form-data")/*23.162*/ {_display_(Seq[Any](format.raw/*23.164*/("""
	
	<div class="row">
	
		<div class="col-sm-2">
			<label class="control-label">Periodo</label> 
			<div class="form-group """),_display_(Seq[Any](/*29.28*/if(nForm.error("periodo_id") != null)/*29.65*/ {_display_(Seq[Any](format.raw/*29.67*/("""has-error""")))}/*29.78*/else/*29.83*/{_display_(Seq[Any](format.raw/*29.84*/("""has-required""")))})),format.raw/*29.97*/("""">
				<div class="input-group">
				"""),_display_(Seq[Any](/*31.6*/inputText(nForm("periodoInicio.nombre"),'class -> "form-control", 'id -> "periodo"))),format.raw/*31.89*/("""
				"""),_display_(Seq[Any](/*32.6*/inputText(nForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*32.77*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*37.21*/controllers/*37.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*37.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>	
			</div>
			"""),_display_(Seq[Any](/*48.5*/nForm("periodo_id")/*48.24*/.error.map/*48.34*/{ error =>_display_(Seq[Any](format.raw/*48.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*48.70*/error/*48.75*/.message)),format.raw/*48.83*/("""</div>""")))})),format.raw/*48.90*/("""
		</div>
	
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*53.29*/if(nForm.error("expediente_id") != null)/*53.69*/ {_display_(Seq[Any](format.raw/*53.71*/("""has-error""")))}/*53.81*/else/*53.85*/{_display_(Seq[Any](format.raw/*53.86*/("""has-required""")))})),format.raw/*53.99*/("""">
				"""),_display_(Seq[Any](/*54.6*/inputText(nForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*54.102*/("""
				"""),_display_(Seq[Any](/*55.6*/inputText(nForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*55.83*/("""
				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*56.119*/controllers/*56.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*56.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*58.5*/nForm("expediente_id")/*58.27*/.error.map/*58.37*/{ error =>_display_(Seq[Any](format.raw/*58.47*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*59.30*/error/*59.35*/.message)),format.raw/*59.43*/("""</div>
			""")))})),format.raw/*60.5*/("""
		</div>
	
	
	
	<div class="col-sm-3">
	<label class="control-label">&nbsp;</label> 
	<div class="form-group """),_display_(Seq[Any](/*67.26*/if(nForm.error("archivo") != null)/*67.60*/ {_display_(Seq[Any](format.raw/*67.62*/("""has-error""")))}/*67.73*/else/*67.78*/{_display_(Seq[Any](format.raw/*67.79*/("""has-required""")))})),format.raw/*67.92*/("""">
		<input type="file" name="archivo">
	</div>
	
	"""),_display_(Seq[Any](/*71.3*/nForm("archivo")/*71.19*/.error.map/*71.29*/{ error =>_display_(Seq[Any](format.raw/*71.39*/(""" <div class="text-error">"""),_display_(Seq[Any](/*71.65*/error/*71.70*/.message)),format.raw/*71.78*/("""</div>""")))})),format.raw/*71.85*/("""
	</div>
	
	
	</div>
	
	
	 

	"""),_display_(Seq[Any](/*80.3*/if(lista != null)/*80.20*/{_display_(Seq[Any](format.raw/*80.21*/("""
	

	 
		<hr />
		<h3>Errores encontrados</h3>
		"""),_display_(Seq[Any](/*86.4*/if(lista.get("archivo") != null)/*86.36*/ {_display_(Seq[Any](format.raw/*86.38*/("""
			"""),_display_(Seq[Any](/*87.5*/if(!lista.get("archivo").isEmpty())/*87.40*/ {_display_(Seq[Any](format.raw/*87.42*/("""
				"""),_display_(Seq[Any](/*88.6*/for(a <- lista.get("archivo")) yield /*88.36*/ {_display_(Seq[Any](format.raw/*88.38*/("""
					"""),_display_(Seq[Any](/*89.7*/Html(a))),format.raw/*89.14*/(""" <br />
				""")))})),format.raw/*90.6*/("""
				 <br />
			""")))})),format.raw/*92.5*/("""
		""")))})),format.raw/*93.4*/("""
		"""),_display_(Seq[Any](/*94.4*/if(lista.get("archivo") != null)/*94.36*/ {_display_(Seq[Any](format.raw/*94.38*/("""
			"""),_display_(Seq[Any](/*95.5*/if(!lista.get("cuit").isEmpty())/*95.37*/ {_display_(Seq[Any](format.raw/*95.39*/("""
				"""),_display_(Seq[Any](/*96.6*/for(c <- lista.get("cuit")) yield /*96.33*/ {_display_(Seq[Any](format.raw/*96.35*/("""
					"""),_display_(Seq[Any](/*97.7*/Html(c))),format.raw/*97.14*/(""" <br />
				""")))})),format.raw/*98.6*/("""
				 <br />
			""")))})),format.raw/*100.5*/("""
		""")))})),format.raw/*101.4*/("""
		"""),_display_(Seq[Any](/*102.4*/if(lista.get("archivo") != null)/*102.36*/ {_display_(Seq[Any](format.raw/*102.38*/("""
			"""),_display_(Seq[Any](/*103.5*/if(!lista.get("concepto").isEmpty())/*103.41*/ {_display_(Seq[Any](format.raw/*103.43*/("""
				"""),_display_(Seq[Any](/*104.6*/for(c <- lista.get("concepto")) yield /*104.37*/ {_display_(Seq[Any](format.raw/*104.39*/("""
					"""),_display_(Seq[Any](/*105.7*/Html(c))),format.raw/*105.14*/(""" <br />
				""")))})),format.raw/*106.6*/("""
				 <br />
			""")))})),format.raw/*108.5*/("""
		""")))})),format.raw/*109.4*/("""
	 
	""")))})),format.raw/*111.3*/("""
	
	
	
	

	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <button type="submit" class="btn btn-sistema">Procesar</button>
	    </div>
	</div>

	""")))})),format.raw/*123.3*/("""
""")))})),format.raw/*124.2*/("""
	"""))}
    }
    
    def render(nForm:Form[Certificacion],lista:HashMap[String, List[String]]): play.api.templates.HtmlFormat.Appendable = apply(nForm,lista)
    
    def f:((Form[Certificacion],HashMap[String, List[String]]) => play.api.templates.HtmlFormat.Appendable) = (nForm,lista) => apply(nForm,lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/crearMasivo.scala.html
                    HASH: f40610dc891ba0f3097c65574f4807c33c787ed8
                    MATRIX: 847->1|1037->195|1051->202|1135->206|1187->223|1201->229|1274->281|1342->120|1374->144|1448->74|1476->117|1505->188|1537->318|1577->323|1590->328|1700->428|1741->430|1969->623|1982->628|2029->653|2077->666|2092->672|2252->822|2293->824|2460->955|2506->992|2546->994|2575->1005|2588->1010|2627->1011|2672->1024|2747->1064|2852->1147|2894->1154|2987->1225|3203->1405|3223->1416|3298->1469|3624->1760|3652->1779|3671->1789|3719->1799|3781->1825|3795->1830|3825->1838|3864->1845|4039->1984|4088->2024|4128->2026|4157->2036|4170->2040|4209->2041|4254->2054|4298->2063|4417->2159|4459->2166|4558->2243|4715->2363|4736->2374|4813->2428|5056->2636|5087->2658|5106->2668|5154->2678|5221->2709|5235->2714|5265->2722|5308->2734|5462->2852|5505->2886|5545->2888|5574->2899|5587->2904|5626->2905|5671->2918|5762->2974|5787->2990|5806->3000|5854->3010|5916->3036|5930->3041|5960->3049|5999->3056|6074->3096|6100->3113|6139->3114|6230->3170|6271->3202|6311->3204|6352->3210|6396->3245|6436->3247|6478->3254|6524->3284|6564->3286|6607->3294|6636->3301|6681->3315|6731->3334|6767->3339|6807->3344|6848->3376|6888->3378|6929->3384|6970->3416|7010->3418|7052->3425|7095->3452|7135->3454|7178->3462|7207->3469|7252->3483|7303->3502|7340->3507|7381->3512|7423->3544|7464->3546|7506->3552|7552->3588|7593->3590|7636->3597|7684->3628|7725->3630|7769->3638|7799->3645|7845->3659|7896->3678|7933->3683|7973->3691|8197->3883|8232->3886
                    LINES: 26->1|31->7|31->7|33->7|34->8|34->8|34->8|35->5|35->5|36->1|37->4|38->5|40->9|42->11|42->11|42->11|42->11|52->21|52->21|52->21|54->23|54->23|54->23|54->23|60->29|60->29|60->29|60->29|60->29|60->29|60->29|62->31|62->31|63->32|63->32|68->37|68->37|68->37|79->48|79->48|79->48|79->48|79->48|79->48|79->48|79->48|84->53|84->53|84->53|84->53|84->53|84->53|84->53|85->54|85->54|86->55|86->55|87->56|87->56|87->56|89->58|89->58|89->58|89->58|90->59|90->59|90->59|91->60|98->67|98->67|98->67|98->67|98->67|98->67|98->67|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|111->80|111->80|111->80|117->86|117->86|117->86|118->87|118->87|118->87|119->88|119->88|119->88|120->89|120->89|121->90|123->92|124->93|125->94|125->94|125->94|126->95|126->95|126->95|127->96|127->96|127->96|128->97|128->97|129->98|131->100|132->101|133->102|133->102|133->102|134->103|134->103|134->103|135->104|135->104|135->104|136->105|136->105|137->106|139->108|140->109|142->111|154->123|155->124
                    -- GENERATED --
                */
            