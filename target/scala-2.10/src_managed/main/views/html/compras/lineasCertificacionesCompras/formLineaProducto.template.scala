
package views.html.compras.lineasCertificacionesCompras

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionCompraLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionCompraLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$('#searchProductoModal').modalSearch();
	$('#searchCuentaAnalitica').modalSearch();
	$("#descuento, #cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*17.29*/("""{"""),format.raw/*17.30*/("""allowNegative: true"""),format.raw/*17.49*/("""}"""),format.raw/*17.50*/(""");
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/(""");

</script>

 <div class="row">
	"""),_display_(Seq[Any](/*23.3*/inputText(lineaForm("certificacion_compra_id"), 'type -> "hidden"))),format.raw/*23.69*/("""
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*27.28*/if(lineaForm.error("producto_id") != null)/*27.70*/ {_display_(Seq[Any](format.raw/*27.72*/("""has-error""")))}/*27.83*/else/*27.88*/{_display_(Seq[Any](format.raw/*27.89*/("""has-required""")))})),format.raw/*27.102*/("""">
			"""),_display_(Seq[Any](/*28.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*28.122*/("""
			"""),_display_(Seq[Any](/*29.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*29.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*33.19*/controllers/*33.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*33.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*43.4*/lineaForm("producto_id")/*43.28*/.error.map/*43.38*/{ error =>_display_(Seq[Any](format.raw/*43.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*44.29*/error/*44.34*/.message)),format.raw/*44.42*/("""</div>
		""")))})),format.raw/*45.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*49.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*49.78*/ {_display_(Seq[Any](format.raw/*49.80*/("""has-error""")))}/*49.91*/else/*49.96*/{_display_(Seq[Any](format.raw/*49.97*/("""has-required""")))})),format.raw/*49.110*/("""">
			"""),_display_(Seq[Any](/*50.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*50.103*/("""
			"""),_display_(Seq[Any](/*51.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*51.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*57.19*/controllers/*57.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*57.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*66.4*/lineaForm("cuenta_analitica_id")/*66.36*/.error.map/*66.46*/{ error =>_display_(Seq[Any](format.raw/*66.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*67.29*/error/*67.34*/.message)),format.raw/*67.42*/("""</div>
		""")))})),format.raw/*68.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*75.27*/if(lineaForm.error("precio") != null)/*75.64*/ {_display_(Seq[Any](format.raw/*75.66*/("""has-error""")))}/*75.77*/else/*75.82*/{_display_(Seq[Any](format.raw/*75.83*/("""has-required""")))})),format.raw/*75.96*/("""">
			"""),_display_(Seq[Any](/*76.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*76.78*/("""
			"""),_display_(Seq[Any](/*77.5*/lineaForm("precio")/*77.24*/.error.map/*77.34*/{ error =>_display_(Seq[Any](format.raw/*77.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*77.70*/error/*77.75*/.message)),format.raw/*77.83*/("""</div>""")))})),format.raw/*77.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*83.27*/if(lineaForm.error("cantidad") != null)/*83.66*/ {_display_(Seq[Any](format.raw/*83.68*/("""has-error""")))}/*83.79*/else/*83.84*/{_display_(Seq[Any](format.raw/*83.85*/("""has-required""")))})),format.raw/*83.98*/("""">
			"""),_display_(Seq[Any](/*84.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*84.82*/("""
			"""),_display_(Seq[Any](/*85.5*/lineaForm("cantidad")/*85.26*/.error.map/*85.36*/{ error =>_display_(Seq[Any](format.raw/*85.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*85.72*/error/*85.77*/.message)),format.raw/*85.85*/("""</div>""")))})),format.raw/*85.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*90.27*/if(lineaForm.error("udm_id") != null)/*90.64*/ {_display_(Seq[Any](format.raw/*90.66*/("""has-error""")))}/*90.77*/else/*90.82*/{_display_(Seq[Any](format.raw/*90.83*/("""has-required""")))})),format.raw/*90.96*/("""">
			"""),_display_(Seq[Any](/*91.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*91.147*/("""
			"""),_display_(Seq[Any](/*92.5*/lineaForm("udm_id")/*92.24*/.error.map/*92.34*/{ error =>_display_(Seq[Any](format.raw/*92.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*92.70*/error/*92.75*/.message)),format.raw/*92.83*/("""</div> """)))})),format.raw/*92.91*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label for="descuento" class="control-label">Descuento (%)</label>
		<div class="form-group """),_display_(Seq[Any](/*97.27*/if(lineaForm.error("descuento") != null)/*97.67*/ {_display_(Seq[Any](format.raw/*97.69*/("""has-error""")))})),format.raw/*97.79*/("""">
			"""),_display_(Seq[Any](/*98.5*/inputText(lineaForm("descuento"), 'class -> "form-control", 'id -> "descuento", 'id -> "descuento"))),format.raw/*98.104*/("""
		</div>
	</div>
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*110.14*/("""{"""),format.raw/*110.15*/("""
	if($("#producto_modal").length)"""),format.raw/*111.33*/("""{"""),format.raw/*111.34*/("""
		var options = """),format.raw/*112.17*/("""{"""),format.raw/*112.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*118.30*/("""{"""),format.raw/*118.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*120.12*/("""}"""),format.raw/*120.13*/("""
			"""),format.raw/*121.4*/("""}"""),format.raw/*121.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*123.2*/("""}"""),format.raw/*123.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*125.34*/("""{"""),format.raw/*125.35*/("""
		var options = """),format.raw/*126.17*/("""{"""),format.raw/*126.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*132.30*/("""{"""),format.raw/*132.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*134.12*/("""}"""),format.raw/*134.13*/("""
			"""),format.raw/*135.4*/("""}"""),format.raw/*135.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/("""
"""),format.raw/*138.1*/("""}"""),format.raw/*138.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CertificacionCompraLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionCompraLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificacionesCompras/formLineaProducto.scala.html
                    HASH: d002cb69bf707474a102934bedd7e4bcb4529038
                    MATRIX: 847->1|993->65|1025->89|1099->44|1128->133|1182->152|1196->158|1266->207|1339->246|1377->276|1416->278|1539->366|1552->371|1586->384|1629->396|1681->420|1710->421|1902->585|1931->586|1978->605|2007->606|2038->610|2066->611|2142->652|2230->718|2394->846|2445->888|2485->890|2514->901|2527->906|2566->907|2612->920|2655->928|2795->1045|2836->1051|2942->1135|3122->1279|3142->1290|3213->1339|3525->1616|3558->1640|3577->1650|3625->1660|3691->1690|3705->1695|3735->1703|3777->1714|3946->1847|4005->1897|4045->1899|4074->1910|4087->1915|4126->1916|4172->1929|4215->1937|4336->2035|4377->2041|4492->2134|4719->2325|4739->2336|4823->2398|5136->2676|5177->2708|5196->2718|5244->2728|5310->2758|5324->2763|5354->2771|5396->2782|5570->2920|5616->2957|5656->2959|5685->2970|5698->2975|5737->2976|5782->2989|5825->2997|5920->3070|5961->3076|5989->3095|6008->3105|6056->3115|6118->3141|6132->3146|6162->3154|6201->3161|6377->3301|6425->3340|6465->3342|6494->3353|6507->3358|6546->3359|6591->3372|6634->3380|6733->3457|6774->3463|6804->3484|6823->3494|6871->3504|6933->3530|6947->3535|6977->3543|7016->3550|7166->3664|7212->3701|7252->3703|7281->3714|7294->3719|7333->3720|7378->3733|7421->3741|7586->3883|7627->3889|7655->3908|7674->3918|7722->3928|7784->3954|7798->3959|7828->3967|7868->3975|8046->4117|8095->4157|8135->4159|8177->4169|8220->4177|8342->4276|8793->4698|8823->4699|8886->4733|8916->4734|8963->4752|8993->4753|9163->4894|9193->4895|9286->4959|9316->4960|9349->4965|9378->4966|9475->5035|9504->5036|9571->5074|9601->5075|9648->5093|9678->5094|9868->5255|9898->5256|9992->5321|10022->5322|10055->5327|10084->5328|10182->5398|10211->5399|10241->5401|10270->5402
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|45->17|45->17|45->17|45->17|46->18|46->18|51->23|51->23|55->27|55->27|55->27|55->27|55->27|55->27|55->27|56->28|56->28|57->29|57->29|61->33|61->33|61->33|71->43|71->43|71->43|71->43|72->44|72->44|72->44|73->45|77->49|77->49|77->49|77->49|77->49|77->49|77->49|78->50|78->50|79->51|79->51|85->57|85->57|85->57|94->66|94->66|94->66|94->66|95->67|95->67|95->67|96->68|103->75|103->75|103->75|103->75|103->75|103->75|103->75|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|111->83|111->83|111->83|111->83|111->83|111->83|111->83|112->84|112->84|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|118->90|118->90|118->90|118->90|118->90|118->90|118->90|119->91|119->91|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|125->97|125->97|125->97|125->97|126->98|126->98|138->110|138->110|139->111|139->111|140->112|140->112|146->118|146->118|148->120|148->120|149->121|149->121|151->123|151->123|153->125|153->125|154->126|154->126|160->132|160->132|162->134|162->134|163->135|163->135|165->137|165->137|166->138|166->138
                    -- GENERATED --
                */
            