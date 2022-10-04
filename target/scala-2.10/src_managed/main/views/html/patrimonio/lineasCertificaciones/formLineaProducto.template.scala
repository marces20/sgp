
package views.html.patrimonio.lineasCertificaciones

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionServicioLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionServicioLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
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

function copiarPrecio()"""),format.raw/*20.24*/("""{"""),format.raw/*20.25*/("""
	var data = $("#producto_id_modal").serialize(); 
	var url = '/producto/getPrecio';
	$.get(url, data, function(data)"""),format.raw/*23.33*/("""{"""),format.raw/*23.34*/("""
		if(data.success) """),format.raw/*24.20*/("""{"""),format.raw/*24.21*/("""
			$('#precio').val(data.precio)
		"""),format.raw/*26.3*/("""}"""),format.raw/*26.4*/("""else"""),format.raw/*26.8*/("""{"""),format.raw/*26.9*/("""
			alert("No se encuentra el producto.")
		"""),format.raw/*28.3*/("""}"""),format.raw/*28.4*/("""
	"""),format.raw/*29.2*/("""}"""),format.raw/*29.3*/(""");	
"""),format.raw/*30.1*/("""}"""),format.raw/*30.2*/("""
</script>

 <div class="row">		  	
	"""),_display_(Seq[Any](/*34.3*/inputText(lineaForm("certificaciones_servicio_id"), 'type -> "hidden"))),format.raw/*34.73*/("""
	"""),_display_(Seq[Any](/*35.3*/inputText(lineaForm("linea_orden_id"), 'type -> "hidden"))),format.raw/*35.60*/("""
	

	<div class="col-sm-6">
		<div class="form-group """),_display_(Seq[Any](/*39.27*/if(lineaForm.error("producto_id") != null)/*39.69*/ {_display_(Seq[Any](format.raw/*39.71*/("""has-error""")))}/*39.82*/else/*39.87*/{_display_(Seq[Any](format.raw/*39.88*/("""has-required""")))})),format.raw/*39.101*/("""">
		<label for="producto_nombre" class="control-label">Producto</label>
		
			"""),_display_(Seq[Any](/*42.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal",'readonly->"readonly"))),format.raw/*42.144*/("""
			"""),_display_(Seq[Any](/*43.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*43.89*/("""
		</div>
		"""),_display_(Seq[Any](/*45.4*/lineaForm("producto_id")/*45.28*/.error.map/*45.38*/{ error =>_display_(Seq[Any](format.raw/*45.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*46.29*/error/*46.34*/.message)),format.raw/*46.42*/("""</div>
		""")))})),format.raw/*47.4*/("""
	</div>
	<div class="col-sm-6">
	<div class="form-group """),_display_(Seq[Any](/*50.26*/if(lineaForm.error("cuenta_analitica_id") != null)/*50.76*/ {_display_(Seq[Any](format.raw/*50.78*/("""has-error""")))}/*50.89*/else/*50.94*/{_display_(Seq[Any](format.raw/*50.95*/("""has-required""")))})),format.raw/*50.108*/("""">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		
			"""),_display_(Seq[Any](/*53.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica",'readonly->"readonly"))),format.raw/*53.125*/("""
			"""),_display_(Seq[Any](/*54.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*54.98*/("""
			<!-- <span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*60.19*/controllers/*60.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*60.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span> -->
		</div>
		"""),_display_(Seq[Any](/*69.4*/lineaForm("cuenta_analitica_id")/*69.36*/.error.map/*69.46*/{ error =>_display_(Seq[Any](format.raw/*69.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*70.29*/error/*70.34*/.message)),format.raw/*70.42*/("""</div>
		""")))})),format.raw/*71.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*78.27*/if(lineaForm.error("precio") != null)/*78.64*/ {_display_(Seq[Any](format.raw/*78.66*/("""has-error""")))}/*78.77*/else/*78.82*/{_display_(Seq[Any](format.raw/*78.83*/("""has-required""")))})),format.raw/*78.96*/("""">
			"""),_display_(Seq[Any](/*79.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*79.78*/("""
			"""),_display_(Seq[Any](/*80.5*/lineaForm("precio")/*80.24*/.error.map/*80.34*/{ error =>_display_(Seq[Any](format.raw/*80.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*80.70*/error/*80.75*/.message)),format.raw/*80.83*/("""</div>""")))})),format.raw/*80.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*86.27*/if(lineaForm.error("cantidad") != null)/*86.66*/ {_display_(Seq[Any](format.raw/*86.68*/("""has-error""")))}/*86.79*/else/*86.84*/{_display_(Seq[Any](format.raw/*86.85*/("""has-required""")))})),format.raw/*86.98*/("""">
			"""),_display_(Seq[Any](/*87.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*87.82*/("""
			"""),_display_(Seq[Any](/*88.5*/lineaForm("cantidad")/*88.26*/.error.map/*88.36*/{ error =>_display_(Seq[Any](format.raw/*88.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*88.72*/error/*88.77*/.message)),format.raw/*88.85*/("""</div>""")))})),format.raw/*88.92*/("""
		</div>
	</div>

	
	<div class="col-sm-3">
		<label for="descuento" class="control-label">Descuento (%)</label>
		<div class="form-group """),_display_(Seq[Any](/*95.27*/if(lineaForm.error("descuento") != null)/*95.67*/ {_display_(Seq[Any](format.raw/*95.69*/("""has-error""")))})),format.raw/*95.79*/("""">
			"""),_display_(Seq[Any](/*96.5*/inputText(lineaForm("descuento"), 'class -> "form-control", 'id -> "descuento", 'id -> "descuento"))),format.raw/*96.104*/("""
		</div>
	</div>
	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*100.27*/if(lineaForm.error("udm_id") != null)/*100.64*/ {_display_(Seq[Any](format.raw/*100.66*/("""has-error""")))}/*100.77*/else/*100.82*/{_display_(Seq[Any](format.raw/*100.83*/("""has-required""")))})),format.raw/*100.96*/("""">
			"""),_display_(Seq[Any](/*101.5*/select(lineaForm("udm_id"), 
			 Udm.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", 
			'_default -> "Seleccionar",'readonly->"readonly"))),format.raw/*104.53*/("""
			"""),_display_(Seq[Any](/*105.5*/lineaForm("udm_id")/*105.24*/.error.map/*105.34*/{ error =>_display_(Seq[Any](format.raw/*105.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*105.70*/error/*105.75*/.message)),format.raw/*105.83*/("""</div> """)))})),format.raw/*105.91*/("""
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
$( function()"""),format.raw/*117.14*/("""{"""),format.raw/*117.15*/("""
	/*if($("#producto_modal").length)"""),format.raw/*118.35*/("""{"""),format.raw/*118.36*/("""
		var options = """),format.raw/*119.17*/("""{"""),format.raw/*119.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*125.30*/("""{"""),format.raw/*125.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*127.12*/("""}"""),format.raw/*127.13*/("""
			"""),format.raw/*128.4*/("""}"""),format.raw/*128.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*130.2*/("""}"""),format.raw/*130.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*132.34*/("""{"""),format.raw/*132.35*/("""
		var options = """),format.raw/*133.17*/("""{"""),format.raw/*133.18*/("""
				script:"/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*139.30*/("""{"""),format.raw/*139.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*141.12*/("""}"""),format.raw/*141.13*/("""
			"""),format.raw/*142.4*/("""}"""),format.raw/*142.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*144.2*/("""}"""),format.raw/*144.3*/("""*/
"""),format.raw/*145.1*/("""}"""),format.raw/*145.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CertificacionServicioLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionServicioLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasCertificaciones/formLineaProducto.scala.html
                    HASH: caa3d6cf74a3602b98c65c626844935769986bd3
                    MATRIX: 845->1|993->67|1025->91|1099->46|1128->135|1182->154|1196->160|1266->209|1339->248|1377->278|1416->280|1539->368|1552->373|1586->386|1629->398|1681->422|1710->423|1902->587|1931->588|1978->607|2007->608|2038->612|2066->613|2123->642|2152->643|2300->763|2329->764|2378->785|2407->786|2472->824|2500->825|2531->829|2559->830|2632->876|2660->877|2690->880|2718->881|2750->886|2778->887|2855->929|2947->999|2986->1003|3065->1060|3159->1118|3210->1160|3250->1162|3279->1173|3292->1178|3331->1179|3377->1192|3495->1275|3657->1414|3698->1420|3804->1504|3854->1519|3887->1543|3906->1553|3954->1563|4020->1593|4034->1598|4064->1606|4106->1617|4203->1678|4262->1728|4302->1730|4331->1741|4344->1746|4383->1747|4429->1760|4546->1842|4689->1962|4730->1968|4845->2061|5077->2257|5097->2268|5181->2330|5498->2612|5539->2644|5558->2654|5606->2664|5672->2694|5686->2699|5716->2707|5758->2718|5932->2856|5978->2893|6018->2895|6047->2906|6060->2911|6099->2912|6144->2925|6187->2933|6282->3006|6323->3012|6351->3031|6370->3041|6418->3051|6480->3077|6494->3082|6524->3090|6563->3097|6739->3237|6787->3276|6827->3278|6856->3289|6869->3294|6908->3295|6953->3308|6996->3316|7095->3393|7136->3399|7166->3420|7185->3430|7233->3440|7295->3466|7309->3471|7339->3479|7378->3486|7561->3633|7610->3673|7650->3675|7692->3685|7735->3693|7857->3792|8006->3904|8053->3941|8094->3943|8124->3954|8138->3959|8178->3960|8224->3973|8268->3981|8471->4161|8513->4167|8542->4186|8562->4196|8611->4206|8674->4232|8689->4237|8720->4245|8761->4253|9211->4674|9241->4675|9306->4711|9336->4712|9383->4730|9413->4731|9583->4872|9613->4873|9706->4937|9736->4938|9769->4943|9798->4944|9895->5013|9924->5014|9991->5052|10021->5053|10068->5071|10098->5072|10275->5220|10305->5221|10399->5286|10429->5287|10462->5292|10491->5293|10589->5363|10618->5364|10650->5368|10679->5369
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|45->17|45->17|45->17|45->17|46->18|46->18|48->20|48->20|51->23|51->23|52->24|52->24|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|58->30|58->30|62->34|62->34|63->35|63->35|67->39|67->39|67->39|67->39|67->39|67->39|67->39|70->42|70->42|71->43|71->43|73->45|73->45|73->45|73->45|74->46|74->46|74->46|75->47|78->50|78->50|78->50|78->50|78->50|78->50|78->50|81->53|81->53|82->54|82->54|88->60|88->60|88->60|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|106->78|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|114->86|114->86|114->86|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|123->95|123->95|123->95|123->95|124->96|124->96|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|132->104|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|145->117|145->117|146->118|146->118|147->119|147->119|153->125|153->125|155->127|155->127|156->128|156->128|158->130|158->130|160->132|160->132|161->133|161->133|167->139|167->139|169->141|169->141|170->142|170->142|172->144|172->144|173->145|173->145
                    -- GENERATED --
                */
            