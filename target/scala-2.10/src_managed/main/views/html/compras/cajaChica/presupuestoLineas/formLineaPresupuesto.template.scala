
package views.html.compras.cajaChica.presupuestoLineas

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
object formLineaPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChicaPresupuestoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CajaChicaPresupuestoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>

$(function()"""),format.raw/*14.13*/("""{"""),format.raw/*14.14*/("""
							 	
	$('#searchCuentaAnalitica').modalSearch();
	$("#monto").numeric_input("""),format.raw/*17.28*/("""{"""),format.raw/*17.29*/("""allowNegative: true"""),format.raw/*17.48*/("""}"""),format.raw/*17.49*/(""");
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/(""");

</script>

 <div class="row">
 	"""),_display_(Seq[Any](/*23.4*/inputText(lineaForm("id"), 'type -> "hidden"))),format.raw/*23.49*/("""
	"""),_display_(Seq[Any](/*24.3*/inputText(lineaForm("caja_chica_id"), 'type -> "hidden"))),format.raw/*24.59*/("""
	
	  
	
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*30.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*30.78*/ {_display_(Seq[Any](format.raw/*30.80*/("""has-error""")))}/*30.91*/else/*30.96*/{_display_(Seq[Any](format.raw/*30.97*/("""has-required""")))})),format.raw/*30.110*/("""">
			"""),_display_(Seq[Any](/*31.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*31.103*/("""
			"""),_display_(Seq[Any](/*32.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*32.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*38.19*/controllers/*38.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*38.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*47.4*/lineaForm("cuenta_analitica_id")/*47.36*/.error.map/*47.46*/{ error =>_display_(Seq[Any](format.raw/*47.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*48.29*/error/*48.34*/.message)),format.raw/*48.42*/("""</div>
		""")))})),format.raw/*49.4*/("""
	</div>
	
	<div class="col-sm-3">
		<label class="control-label">Monto</label>
		<div class="form-group """),_display_(Seq[Any](/*54.27*/if(lineaForm.error("monto") != null)/*54.63*/ {_display_(Seq[Any](format.raw/*54.65*/("""has-error""")))}/*54.76*/else/*54.81*/{_display_(Seq[Any](format.raw/*54.82*/("""has-required""")))})),format.raw/*54.95*/("""">
			"""),_display_(Seq[Any](/*55.5*/inputText(lineaForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*55.76*/("""
			"""),_display_(Seq[Any](/*56.5*/lineaForm("monto")/*56.23*/.error.map/*56.33*/{ error =>_display_(Seq[Any](format.raw/*56.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*56.69*/error/*56.74*/.message)),format.raw/*56.82*/("""</div>""")))})),format.raw/*56.89*/("""
		</div>
	</div>
</div>


<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
"""),_display_(Seq[Any](/*68.2*/flash()/*68.9*/.clear())),format.raw/*68.17*/("""
<script>
$( function()"""),format.raw/*70.14*/("""{"""),format.raw/*70.15*/("""
 
	 
	 
	if($("#cuentaAnalitica").length)"""),format.raw/*74.34*/("""{"""),format.raw/*74.35*/("""
		var options = """),format.raw/*75.17*/("""{"""),format.raw/*75.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*81.30*/("""{"""),format.raw/*81.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*83.12*/("""}"""),format.raw/*83.13*/("""
			"""),format.raw/*84.4*/("""}"""),format.raw/*84.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*86.2*/("""}"""),format.raw/*86.3*/("""
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CajaChicaPresupuestoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CajaChicaPresupuestoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/presupuestoLineas/formLineaPresupuesto.scala.html
                    HASH: a792ee487cd7eabdf31a27832195a62b5d0f6463
                    MATRIX: 850->1|997->66|1029->90|1103->45|1132->134|1186->153|1200->159|1270->208|1343->247|1381->277|1420->279|1543->367|1556->372|1590->385|1633->397|1687->423|1716->424|1829->509|1858->510|1905->529|1934->530|1965->534|1993->535|2070->577|2137->622|2176->626|2254->682|2425->817|2484->867|2524->869|2553->880|2566->885|2605->886|2651->899|2694->907|2815->1005|2856->1011|2971->1104|3198->1295|3218->1306|3302->1368|3615->1646|3656->1678|3675->1688|3723->1698|3789->1728|3803->1733|3833->1741|3875->1752|4022->1863|4067->1899|4107->1901|4136->1912|4149->1917|4188->1918|4233->1931|4276->1939|4369->2010|4410->2016|4437->2034|4456->2044|4504->2054|4566->2080|4580->2085|4610->2093|4649->2100|5085->2501|5100->2508|5130->2516|5183->2541|5212->2542|5286->2588|5315->2589|5361->2607|5390->2608|5579->2769|5608->2770|5701->2835|5730->2836|5762->2841|5790->2842|5887->2912|5915->2913|5944->2915|5972->2916
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|42->14|42->14|45->17|45->17|45->17|45->17|46->18|46->18|51->23|51->23|52->24|52->24|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|60->32|60->32|66->38|66->38|66->38|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|82->54|82->54|82->54|82->54|82->54|82->54|82->54|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|96->68|96->68|96->68|98->70|98->70|102->74|102->74|103->75|103->75|109->81|109->81|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87
                    -- GENERATED --
                */
            