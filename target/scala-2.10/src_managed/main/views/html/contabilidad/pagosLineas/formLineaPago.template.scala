
package views.html.contabilidad.pagosLineas

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
object formLineaPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PagoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[PagoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""
<script>
$(function()"""),format.raw/*11.13*/("""{"""),format.raw/*11.14*/("""
	$('#searchCuentaModal').modalSearch();
	$('#searchCuentaAnalitica').modalSearch();
	$("#monto_credito_modal,#monto_modal").numeric_input();
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*19.3*/inputText(lineaForm("pago_id"), 'type -> "hidden"))),format.raw/*19.53*/("""
	<!-- <div class="col-sm-3">
		<label class="control-label">Importe Original</label>
		<div class="form-group """),_display_(Seq[Any](/*22.27*/if(lineaForm.error("monto_original") != null)/*22.72*/ {_display_(Seq[Any](format.raw/*22.74*/("""has-error""")))}/*22.85*/else/*22.90*/{_display_(Seq[Any](format.raw/*22.91*/("""has-required""")))})),format.raw/*22.104*/("""">
			"""),_display_(Seq[Any](/*23.5*/inputText(lineaForm("monto_original"), 'class -> "form-control",'id -> "monto_original"))),format.raw/*23.93*/("""
			"""),_display_(Seq[Any](/*24.5*/lineaForm("monto_original")/*24.32*/.error.map/*24.42*/{ error =>_display_(Seq[Any](format.raw/*24.52*/(""" <div class="text-error">"""),_display_(Seq[Any](/*24.78*/error/*24.83*/.message)),format.raw/*24.91*/("""</div>""")))})),format.raw/*24.98*/("""
		</div>
	</div> -->
	<div class="col-sm-3">
		<label class="control-label">Importe a Debitar</label>
		<div class="form-group """),_display_(Seq[Any](/*29.27*/if(lineaForm.error("monto") != null)/*29.63*/ {_display_(Seq[Any](format.raw/*29.65*/("""has-error""")))}/*29.76*/else/*29.81*/{_display_(Seq[Any](format.raw/*29.82*/("""has-required""")))})),format.raw/*29.95*/("""">
			"""),_display_(Seq[Any](/*30.5*/inputText(lineaForm("monto"), 'class -> "form-control",'id -> "monto_modal"))),format.raw/*30.81*/("""
			"""),_display_(Seq[Any](/*31.5*/lineaForm("monto")/*31.23*/.error.map/*31.33*/{ error =>_display_(Seq[Any](format.raw/*31.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*31.69*/error/*31.74*/.message)),format.raw/*31.82*/("""</div>""")))})),format.raw/*31.89*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label class="control-label">Importe a Creditar</label>
		<div class="form-group """),_display_(Seq[Any](/*36.27*/if(lineaForm.error("monto_credito") != null)/*36.71*/ {_display_(Seq[Any](format.raw/*36.73*/("""has-error""")))}/*36.84*/else/*36.89*/{_display_(Seq[Any](format.raw/*36.90*/("""has-required""")))})),format.raw/*36.103*/("""">
			"""),_display_(Seq[Any](/*37.5*/inputText(lineaForm("monto_credito"), 'class -> "form-control",'id -> "monto_credito_modal"))),format.raw/*37.97*/("""
			"""),_display_(Seq[Any](/*38.5*/lineaForm("monto_credito")/*38.31*/.error.map/*38.41*/{ error =>_display_(Seq[Any](format.raw/*38.51*/(""" <div class="text-error">"""),_display_(Seq[Any](/*38.77*/error/*38.82*/.message)),format.raw/*38.90*/("""</div>""")))})),format.raw/*38.97*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*45.28*/if(lineaForm.error("cuenta_id") != null)/*45.68*/ {_display_(Seq[Any](format.raw/*45.70*/("""has-error""")))}/*45.81*/else/*45.86*/{_display_(Seq[Any](format.raw/*45.87*/("""has-required""")))})),format.raw/*45.100*/("""">
			"""),_display_(Seq[Any](/*46.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*46.91*/("""
			"""),_display_(Seq[Any](/*47.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*47.84*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModal" 
							data-title="Selección de Cuenta" 
							data-url=""""),_display_(Seq[Any](/*52.19*/controllers/*52.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*52.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal" 
							data-field="#cuenta_id_modal">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*62.4*/lineaForm("cuenta_id")/*62.26*/.error.map/*62.36*/{ error =>_display_(Seq[Any](format.raw/*62.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*63.29*/error/*63.34*/.message)),format.raw/*63.42*/("""</div>
		""")))})),format.raw/*64.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta Presupuestaria</label>
		<div class="input-group """),_display_(Seq[Any](/*68.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*68.78*/ {_display_(Seq[Any](format.raw/*68.80*/("""has-error""")))}/*68.91*/else/*68.96*/{_display_(Seq[Any](format.raw/*68.97*/("""has-required""")))})),format.raw/*68.110*/("""">
			"""),_display_(Seq[Any](/*69.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "cuentaAnalitica"))),format.raw/*69.130*/("""
			"""),_display_(Seq[Any](/*70.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*70.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*76.19*/controllers/*76.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*76.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*85.4*/lineaForm("cuenta_analitica_id")/*85.36*/.error.map/*85.46*/{ error =>_display_(Seq[Any](format.raw/*85.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*86.29*/error/*86.34*/.message)),format.raw/*86.42*/("""</div>
		""")))})),format.raw/*87.4*/("""
	</div>
</div>
<div class="row margin-top-20">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
	</div>
</div>
<script>
$( function()"""),format.raw/*97.14*/("""{"""),format.raw/*97.15*/("""
if($("#cuenta_modal").length)"""),format.raw/*98.30*/("""{"""),format.raw/*98.31*/("""
	var options = """),format.raw/*99.16*/("""{"""),format.raw/*99.17*/("""
			script:"/contabilidad/suggestCuenta/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*105.29*/("""{"""),format.raw/*105.30*/(""" 
										$("#cuenta_id_modal").val(obj.id); 
									 """),format.raw/*107.11*/("""}"""),format.raw/*107.12*/("""
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""";
	var as_json = new bsn.AutoSuggest('cuenta_modal', options);
"""),format.raw/*110.1*/("""}"""),format.raw/*110.2*/("""	
if($("#cuentaAnalitica").length)"""),format.raw/*111.33*/("""{"""),format.raw/*111.34*/("""
	var options = """),format.raw/*112.16*/("""{"""),format.raw/*112.17*/("""
			script:"/contabilidad/suggestCuentaAnalitica/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*118.29*/("""{"""),format.raw/*118.30*/(""" 
										$("#cuentaAnalitica_id").val(obj.id); 
									 """),format.raw/*120.11*/("""}"""),format.raw/*120.12*/("""
		"""),format.raw/*121.3*/("""}"""),format.raw/*121.4*/(""";
	var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
"""),format.raw/*123.1*/("""}"""),format.raw/*123.2*/("""	
"""),format.raw/*124.1*/("""}"""),format.raw/*124.2*/(""");
</script>
"""),_display_(Seq[Any](/*126.2*/flash()/*126.9*/.clear())),format.raw/*126.17*/("""
"""))}
    }
    
    def render(lineaForm:Form[PagoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[PagoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagosLineas/formLineaPago.scala.html
                    HASH: ccbb96664cb3bdeba89d3087a30acd8105be9a25
                    MATRIX: 816->1|947->50|979->74|1053->29|1082->118|1122->124|1160->154|1199->156|1322->244|1335->249|1369->262|1411->274|1463->298|1492->299|1665->445|1693->446|1767->485|1839->535|1990->650|2044->695|2084->697|2113->708|2126->713|2165->714|2211->727|2254->735|2364->823|2405->829|2441->856|2460->866|2508->876|2570->902|2584->907|2614->915|2653->922|2823->1056|2868->1092|2908->1094|2937->1105|2950->1110|2989->1111|3034->1124|3077->1132|3175->1208|3216->1214|3243->1232|3262->1242|3310->1252|3372->1278|3386->1283|3416->1291|3455->1298|3622->1429|3675->1473|3715->1475|3744->1486|3757->1491|3796->1492|3842->1505|3885->1513|3999->1605|4040->1611|4075->1637|4094->1647|4142->1657|4204->1683|4218->1688|4248->1696|4287->1703|4483->1863|4532->1903|4572->1905|4601->1916|4614->1921|4653->1922|4699->1935|4742->1943|4850->2029|4891->2035|4992->2114|5196->2282|5216->2293|5290->2345|5594->2614|5625->2636|5644->2646|5692->2656|5758->2686|5772->2691|5802->2699|5844->2710|6018->2848|6077->2898|6117->2900|6146->2911|6159->2916|6198->2917|6244->2930|6287->2938|6435->3063|6476->3069|6591->3162|6818->3353|6838->3364|6922->3426|7235->3704|7276->3736|7295->3746|7343->3756|7409->3786|7423->3791|7453->3799|7495->3810|7879->4166|7908->4167|7967->4198|7996->4199|8041->4216|8070->4217|8245->4363|8275->4364|8364->4424|8394->4425|8426->4429|8455->4430|8548->4495|8577->4496|8641->4531|8671->4532|8717->4549|8747->4550|8931->4705|8961->4706|9053->4769|9083->4770|9115->4774|9144->4775|9240->4843|9269->4844|9300->4847|9329->4848|9381->4864|9397->4871|9428->4879
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|39->11|39->11|43->15|43->15|47->19|47->19|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|57->29|57->29|57->29|57->29|57->29|57->29|57->29|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|73->45|73->45|73->45|73->45|73->45|73->45|73->45|74->46|74->46|75->47|75->47|80->52|80->52|80->52|90->62|90->62|90->62|90->62|91->63|91->63|91->63|92->64|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|98->70|98->70|104->76|104->76|104->76|113->85|113->85|113->85|113->85|114->86|114->86|114->86|115->87|125->97|125->97|126->98|126->98|127->99|127->99|133->105|133->105|135->107|135->107|136->108|136->108|138->110|138->110|139->111|139->111|140->112|140->112|146->118|146->118|148->120|148->120|149->121|149->121|151->123|151->123|152->124|152->124|154->126|154->126|154->126
                    -- GENERATED --
                */
            