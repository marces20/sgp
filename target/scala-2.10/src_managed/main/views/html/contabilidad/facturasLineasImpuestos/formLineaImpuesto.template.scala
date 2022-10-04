
package views.html.contabilidad.facturasLineasImpuestos

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
object formLineaImpuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[FacturaLineaImpuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[FacturaLineaImpuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 

<script>
$(function()"""),format.raw/*6.13*/("""{"""),format.raw/*6.14*/("""
	$("#monto, #base").numeric_input();
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/(""");
</script>

"""),_display_(Seq[Any](/*11.2*/if(flash.containsKey("error"))/*11.32*/ {_display_(Seq[Any](format.raw/*11.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*13.52*/flash/*13.57*/.get("error"))),format.raw/*13.70*/("""
	</div>
""")))})),format.raw/*15.2*/("""
<script>
$(function()"""),format.raw/*17.13*/("""{"""),format.raw/*17.14*/("""
	$('#searchCuentaModalRete').modalSearch();
	$('#nombre_impuesto').focus( function() """),format.raw/*19.42*/("""{"""),format.raw/*19.43*/("""
		if($('#cuenta_id_modal_rete').val() != '' && $('#cuenta_id_modal_rete').val() == 263)"""),format.raw/*20.88*/("""{"""),format.raw/*20.89*/("""
			url = $('#nombre_impuesto').attr("dataUrl");
			url= "/contabilidad/factura-linea-impuesto/getSecuenciaRetencionSellos"
			var data = "";
			$.post(url, data, function(data)"""),format.raw/*24.36*/("""{"""),format.raw/*24.37*/("""
				if(data.success) """),format.raw/*25.22*/("""{"""),format.raw/*25.23*/("""
					$('#nombre_impuesto').val(data.sec);
				"""),format.raw/*27.5*/("""}"""),format.raw/*27.6*/("""
			"""),format.raw/*28.4*/("""}"""),format.raw/*28.5*/(""");	
		"""),format.raw/*29.3*/("""}"""),format.raw/*29.4*/("""
		 
		if($('#cuenta_id_modal_rete').val() != '' && $('#cuenta_id_modal_rete').val() == 284)"""),format.raw/*31.88*/("""{"""),format.raw/*31.89*/("""
			url = $('#nombre_impuesto').attr("dataUrl");
			url= "/contabilidad/factura-linea-impuesto/getSecuenciaGanancias"
			var data = "";
			$.post(url, data, function(data)"""),format.raw/*35.36*/("""{"""),format.raw/*35.37*/("""
				if(data.success) """),format.raw/*36.22*/("""{"""),format.raw/*36.23*/("""
					$('#nombre_impuesto').val(data.sec);
				"""),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""
			"""),format.raw/*39.4*/("""}"""),format.raw/*39.5*/(""");	
		"""),format.raw/*40.3*/("""}"""),format.raw/*40.4*/("""
		
		if($('#cuenta_id_modal_rete').val() != '')"""),format.raw/*42.45*/("""{"""),format.raw/*42.46*/("""
			if($('#cuenta_id_modal_rete').val() == 284 || $('#cuenta_id_modal_rete').val() == 544)"""),format.raw/*43.90*/("""{"""),format.raw/*43.91*/("""
				url = $('#nombre_impuesto').attr("dataUrl");
				url= "/contabilidad/factura-linea-impuesto/getSecuenciaGanancias"
				var data = "";
				$.post(url, data, function(data)"""),format.raw/*47.37*/("""{"""),format.raw/*47.38*/("""
					if(data.success) """),format.raw/*48.23*/("""{"""),format.raw/*48.24*/("""
						$('#nombre_impuesto').val(data.sec);
					"""),format.raw/*50.6*/("""}"""),format.raw/*50.7*/("""
				"""),format.raw/*51.5*/("""}"""),format.raw/*51.6*/(""");	
			"""),format.raw/*52.4*/("""}"""),format.raw/*52.5*/("""	
		"""),format.raw/*53.3*/("""}"""),format.raw/*53.4*/("""
		
		if($('#cuenta_id_modal_rete').val() != '')"""),format.raw/*55.45*/("""{"""),format.raw/*55.46*/("""
			if($('#cuenta_id_modal_rete').val() == 110 || $('#cuenta_id_modal_rete').val() == 276)"""),format.raw/*56.90*/("""{"""),format.raw/*56.91*/("""
				url = $('#nombre_impuesto').attr("dataUrl");
				url= "/contabilidad/factura-linea-impuesto/getSecuenciaIIBB"
				var data = "";
				$.post(url, data, function(data)"""),format.raw/*60.37*/("""{"""),format.raw/*60.38*/("""
					if(data.success) """),format.raw/*61.23*/("""{"""),format.raw/*61.24*/("""
						$('#nombre_impuesto').val(data.sec);
					"""),format.raw/*63.6*/("""}"""),format.raw/*63.7*/("""
				"""),format.raw/*64.5*/("""}"""),format.raw/*64.6*/(""");	
			"""),format.raw/*65.4*/("""}"""),format.raw/*65.5*/("""	
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/("""
		
		
		
		if($('#cuenta_id_modal_rete').val() != '' && $('#cuenta_id_modal_rete').val() == 258)"""),format.raw/*70.88*/("""{"""),format.raw/*70.89*/("""
			url = $('#nombre_impuesto').attr("dataUrl");
			url= "/contabilidad/factura-linea-impuesto/getSecuenciaIva"
			var data = "";
			$.post(url, data, function(data)"""),format.raw/*74.36*/("""{"""),format.raw/*74.37*/("""
				if(data.success) """),format.raw/*75.22*/("""{"""),format.raw/*75.23*/("""
					$('#nombre_impuesto').val(data.sec);
				"""),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""
			"""),format.raw/*78.4*/("""}"""),format.raw/*78.5*/(""");	
		"""),format.raw/*79.3*/("""}"""),format.raw/*79.4*/("""
		
		if($('#cuenta_id_modal_rete').val() != '' && $('#cuenta_id_modal_rete').val() == 283)"""),format.raw/*81.88*/("""{"""),format.raw/*81.89*/("""
			url = $('#nombre_impuesto').attr("dataUrl");
			url= "/contabilidad/factura-linea-impuesto/getSecuenciaRetencionMunicipal"
			var data = "";
			$.post(url, data, function(data)"""),format.raw/*85.36*/("""{"""),format.raw/*85.37*/("""
				if(data.success) """),format.raw/*86.22*/("""{"""),format.raw/*86.23*/("""
					$('#nombre_impuesto').val(data.sec);
				"""),format.raw/*88.5*/("""}"""),format.raw/*88.6*/("""
			"""),format.raw/*89.4*/("""}"""),format.raw/*89.5*/(""");	
		"""),format.raw/*90.3*/("""}"""),format.raw/*90.4*/("""
	"""),format.raw/*91.2*/("""}"""),format.raw/*91.3*/(""");
	
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/(""");
</script>

<div class="row">
	"""),_display_(Seq[Any](/*97.3*/inputText(lineaForm("factura_id"), 'type -> "hidden"))),format.raw/*97.56*/("""
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*100.28*/if(lineaForm.error("cuenta_id") != null)/*100.68*/ {_display_(Seq[Any](format.raw/*100.70*/("""has-error""")))}/*100.81*/else/*100.86*/{_display_(Seq[Any](format.raw/*100.87*/("""has-required""")))})),format.raw/*100.100*/("""">
			
			"""),_display_(Seq[Any](/*102.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal_rete"))),format.raw/*102.96*/("""
			"""),_display_(Seq[Any](/*103.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal_rete"))),format.raw/*103.89*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModalRete" 
							data-title="Selección de cuenta" 
							data-url=""""),_display_(Seq[Any](/*108.19*/controllers/*108.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*108.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal_rete" 
							data-field="#cuenta_id_modal_rete">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*118.4*/lineaForm("cuenta_id")/*118.26*/.error.map/*118.36*/{ error =>_display_(Seq[Any](format.raw/*118.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*119.29*/error/*119.34*/.message)),format.raw/*119.42*/("""</div>
		""")))})),format.raw/*120.4*/("""
	</div>
	<div class="col-sm-2">
		<label class="control-label">Descripción</label>
		<div class="form-group """),_display_(Seq[Any](/*124.27*/if(lineaForm.error("nombre") != null)/*124.64*/ {_display_(Seq[Any](format.raw/*124.66*/("""has-error""")))}/*124.77*/else/*124.82*/{_display_(Seq[Any](format.raw/*124.83*/("""has-required""")))})),format.raw/*124.96*/("""">
			"""),_display_(Seq[Any](/*125.5*/inputText(lineaForm("nombre"), 'class -> "form-control", 'id -> "nombre_impuesto",'dataUrl -> "/contabilidad/factura-linea-impuesto/getSecuenciaRetencionSellos"))),format.raw/*125.166*/("""
			"""),_display_(Seq[Any](/*126.5*/lineaForm("nombre")/*126.24*/.error.map/*126.34*/{ error =>_display_(Seq[Any](format.raw/*126.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*126.70*/error/*126.75*/.message)),format.raw/*126.83*/("""</div>""")))})),format.raw/*126.90*/("""
		</div>
	</div>
</div>	
<div class="row">	
	<div class="col-sm-3">
		<label class="control-label">Base</label>
		<div class="form-group """),_display_(Seq[Any](/*133.27*/if(lineaForm.error("base") != null)/*133.62*/ {_display_(Seq[Any](format.raw/*133.64*/("""has-error""")))}/*133.74*/else/*133.79*/{_display_(Seq[Any](format.raw/*133.80*/("""has-required""")))})),format.raw/*133.93*/("""">
			"""),_display_(Seq[Any](/*134.5*/inputText(lineaForm("base"), 'class -> "form-control", 'id -> "base"))),format.raw/*134.74*/("""
			"""),_display_(Seq[Any](/*135.5*/lineaForm("base")/*135.22*/.error.map/*135.32*/{ error =>_display_(Seq[Any](format.raw/*135.42*/(""" <div class="text-error">"""),_display_(Seq[Any](/*135.68*/error/*135.73*/.message)),format.raw/*135.81*/("""</div>""")))})),format.raw/*135.88*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label class="control-label">Importe</label>
		<div class="form-group """),_display_(Seq[Any](/*140.27*/if(lineaForm.error("monto") != null)/*140.63*/ {_display_(Seq[Any](format.raw/*140.65*/("""has-error""")))}/*140.76*/else/*140.81*/{_display_(Seq[Any](format.raw/*140.82*/("""has-required""")))})),format.raw/*140.95*/("""">
			"""),_display_(Seq[Any](/*141.5*/inputText(lineaForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*141.76*/("""
			"""),_display_(Seq[Any](/*142.5*/lineaForm("monto")/*142.23*/.error.map/*142.33*/{ error =>_display_(Seq[Any](format.raw/*142.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*142.69*/error/*142.74*/.message)),format.raw/*142.82*/("""</div>""")))})),format.raw/*142.89*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
			<label class="control-label"> 
				Tipo
				"""),_display_(Seq[Any](/*149.6*/select(lineaForm("tipo"),options("1"->"SERVICIOS","2"->"BIENES","3"->"SERVICIOS AGENTES"), 'class -> "form-control select"))),format.raw/*149.129*/("""
			</label>
		</div>
	
</div>
 
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*162.14*/("""{"""),format.raw/*162.15*/("""

if($("#cuenta_modal_rete").length)"""),format.raw/*164.35*/("""{"""),format.raw/*164.36*/("""
		var options = """),format.raw/*165.17*/("""{"""),format.raw/*165.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*171.30*/("""{"""),format.raw/*171.31*/(""" 
											$("#cuenta_id_modal_rete").val(obj.id); 
										 """),format.raw/*173.12*/("""}"""),format.raw/*173.13*/("""
			"""),format.raw/*174.4*/("""}"""),format.raw/*174.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_modal_rete', options);
	"""),format.raw/*176.2*/("""}"""),format.raw/*176.3*/("""
"""),format.raw/*177.1*/("""}"""),format.raw/*177.2*/(""");
</script>	


"""),_display_(Seq[Any](/*181.2*/flash()/*181.9*/.clear())))}
    }
    
    def render(lineaForm:Form[FacturaLineaImpuesto]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[FacturaLineaImpuesto]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasImpuestos/formLineaImpuesto.scala.html
                    HASH: eb14cdaea4de7f7053509bacab0bce141ff2bfe9
                    MATRIX: 843->1|985->61|1017->85|1091->40|1120->129|1174->156|1202->157|1268->197|1295->198|1348->216|1387->246|1427->248|1551->336|1565->341|1600->354|1643->366|1695->390|1724->391|1840->479|1869->480|1986->569|2015->570|2224->751|2253->752|2304->775|2333->776|2409->825|2437->826|2469->831|2497->832|2531->839|2559->840|2681->934|2710->935|2913->1110|2942->1111|2993->1134|3022->1135|3098->1184|3126->1185|3158->1190|3186->1191|3220->1198|3248->1199|3326->1249|3355->1250|3474->1341|3503->1342|3710->1521|3739->1522|3791->1546|3820->1547|3898->1598|3926->1599|3959->1605|3987->1606|4022->1614|4050->1615|4082->1620|4110->1621|4188->1671|4217->1672|4336->1763|4365->1764|4567->1938|4596->1939|4648->1963|4677->1964|4755->2015|4783->2016|4816->2022|4844->2023|4879->2031|4907->2032|4939->2037|4967->2038|5096->2139|5125->2140|5322->2309|5351->2310|5402->2333|5431->2334|5507->2383|5535->2384|5567->2389|5595->2390|5629->2397|5657->2398|5778->2491|5807->2492|6019->2676|6048->2677|6099->2700|6128->2701|6204->2750|6232->2751|6264->2756|6292->2757|6326->2764|6354->2765|6384->2768|6412->2769|6446->2776|6474->2777|6547->2815|6622->2868|6773->2982|6823->3022|6864->3024|6894->3035|6908->3040|6948->3041|6995->3054|7044->3067|7158->3158|7200->3164|7307->3248|7516->3420|7537->3431|7612->3483|7927->3762|7959->3784|7979->3794|8028->3804|8095->3834|8110->3839|8141->3847|8184->3858|8335->3972|8382->4009|8423->4011|8453->4022|8467->4027|8507->4028|8553->4041|8597->4049|8782->4210|8824->4216|8853->4235|8873->4245|8922->4255|8985->4281|9000->4286|9031->4294|9071->4301|9254->4447|9299->4482|9340->4484|9370->4494|9384->4499|9424->4500|9470->4513|9514->4521|9606->4590|9648->4596|9675->4613|9695->4623|9744->4633|9807->4659|9822->4664|9853->4672|9893->4679|10050->4799|10096->4835|10137->4837|10167->4848|10181->4853|10221->4854|10267->4867|10311->4875|10405->4946|10447->4952|10475->4970|10495->4980|10544->4990|10607->5016|10622->5021|10653->5029|10693->5036|10828->5135|10975->5258|11393->5647|11423->5648|11490->5686|11520->5687|11567->5705|11597->5706|11778->5858|11808->5859|11904->5926|11934->5927|11967->5932|11996->5933|12096->6005|12125->6006|12155->6008|12184->6009|12241->6030|12257->6037
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|43->15|45->17|45->17|47->19|47->19|48->20|48->20|52->24|52->24|53->25|53->25|55->27|55->27|56->28|56->28|57->29|57->29|59->31|59->31|63->35|63->35|64->36|64->36|66->38|66->38|67->39|67->39|68->40|68->40|70->42|70->42|71->43|71->43|75->47|75->47|76->48|76->48|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|83->55|83->55|84->56|84->56|88->60|88->60|89->61|89->61|91->63|91->63|92->64|92->64|93->65|93->65|94->66|94->66|98->70|98->70|102->74|102->74|103->75|103->75|105->77|105->77|106->78|106->78|107->79|107->79|109->81|109->81|113->85|113->85|114->86|114->86|116->88|116->88|117->89|117->89|118->90|118->90|119->91|119->91|121->93|121->93|125->97|125->97|128->100|128->100|128->100|128->100|128->100|128->100|128->100|130->102|130->102|131->103|131->103|136->108|136->108|136->108|146->118|146->118|146->118|146->118|147->119|147->119|147->119|148->120|152->124|152->124|152->124|152->124|152->124|152->124|152->124|153->125|153->125|154->126|154->126|154->126|154->126|154->126|154->126|154->126|154->126|161->133|161->133|161->133|161->133|161->133|161->133|161->133|162->134|162->134|163->135|163->135|163->135|163->135|163->135|163->135|163->135|163->135|168->140|168->140|168->140|168->140|168->140|168->140|168->140|169->141|169->141|170->142|170->142|170->142|170->142|170->142|170->142|170->142|170->142|177->149|177->149|190->162|190->162|192->164|192->164|193->165|193->165|199->171|199->171|201->173|201->173|202->174|202->174|204->176|204->176|205->177|205->177|209->181|209->181
                    -- GENERATED --
                */
            