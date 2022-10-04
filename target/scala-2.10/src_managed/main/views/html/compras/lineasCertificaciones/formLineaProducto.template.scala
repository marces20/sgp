
package views.html.compras.lineasCertificaciones

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.39*/("""
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
	"""),_display_(Seq[Any](/*34.3*/inputText(lineaForm("certificacion_id"), 'type -> "hidden"))),format.raw/*34.62*/("""
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*38.28*/if(lineaForm.error("producto_id") != null)/*38.70*/ {_display_(Seq[Any](format.raw/*38.72*/("""has-error""")))}/*38.83*/else/*38.88*/{_display_(Seq[Any](format.raw/*38.89*/("""has-required""")))})),format.raw/*38.102*/("""">
			"""),_display_(Seq[Any](/*39.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*39.122*/("""
			"""),_display_(Seq[Any](/*40.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*40.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*44.19*/controllers/*44.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*44.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*54.4*/lineaForm("producto_id")/*54.28*/.error.map/*54.38*/{ error =>_display_(Seq[Any](format.raw/*54.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*55.29*/error/*55.34*/.message)),format.raw/*55.42*/("""</div>
		""")))})),format.raw/*56.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*60.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*60.78*/ {_display_(Seq[Any](format.raw/*60.80*/("""has-error""")))}/*60.91*/else/*60.96*/{_display_(Seq[Any](format.raw/*60.97*/("""has-required""")))})),format.raw/*60.110*/("""">
			"""),_display_(Seq[Any](/*61.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*61.103*/("""
			"""),_display_(Seq[Any](/*62.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*62.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*68.19*/controllers/*68.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*68.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*77.4*/lineaForm("cuenta_analitica_id")/*77.36*/.error.map/*77.46*/{ error =>_display_(Seq[Any](format.raw/*77.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*78.29*/error/*78.34*/.message)),format.raw/*78.42*/("""</div>
		""")))})),format.raw/*79.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*86.27*/if(lineaForm.error("precio") != null)/*86.64*/ {_display_(Seq[Any](format.raw/*86.66*/("""has-error""")))}/*86.77*/else/*86.82*/{_display_(Seq[Any](format.raw/*86.83*/("""has-required""")))})),format.raw/*86.96*/("""">
			"""),_display_(Seq[Any](/*87.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*87.78*/("""
			"""),_display_(Seq[Any](/*88.5*/lineaForm("precio")/*88.24*/.error.map/*88.34*/{ error =>_display_(Seq[Any](format.raw/*88.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*88.70*/error/*88.75*/.message)),format.raw/*88.83*/("""</div>""")))})),format.raw/*88.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*94.27*/if(lineaForm.error("cantidad") != null)/*94.66*/ {_display_(Seq[Any](format.raw/*94.68*/("""has-error""")))}/*94.79*/else/*94.84*/{_display_(Seq[Any](format.raw/*94.85*/("""has-required""")))})),format.raw/*94.98*/("""">
			"""),_display_(Seq[Any](/*95.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*95.82*/("""
			"""),_display_(Seq[Any](/*96.5*/lineaForm("cantidad")/*96.26*/.error.map/*96.36*/{ error =>_display_(Seq[Any](format.raw/*96.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*96.72*/error/*96.77*/.message)),format.raw/*96.85*/("""</div>""")))})),format.raw/*96.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*101.27*/if(lineaForm.error("udm_id") != null)/*101.64*/ {_display_(Seq[Any](format.raw/*101.66*/("""has-error""")))}/*101.77*/else/*101.82*/{_display_(Seq[Any](format.raw/*101.83*/("""has-required""")))})),format.raw/*101.96*/("""">
			"""),_display_(Seq[Any](/*102.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*102.147*/("""
			"""),_display_(Seq[Any](/*103.5*/lineaForm("udm_id")/*103.24*/.error.map/*103.34*/{ error =>_display_(Seq[Any](format.raw/*103.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*103.70*/error/*103.75*/.message)),format.raw/*103.83*/("""</div> """)))})),format.raw/*103.91*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label for="descuento" class="control-label">Descuento (%)</label>
		<div class="form-group """),_display_(Seq[Any](/*108.27*/if(lineaForm.error("descuento") != null)/*108.67*/ {_display_(Seq[Any](format.raw/*108.69*/("""has-error""")))})),format.raw/*108.79*/("""">
			"""),_display_(Seq[Any](/*109.5*/inputText(lineaForm("descuento"), 'class -> "form-control", 'id -> "descuento", 'id -> "descuento"))),format.raw/*109.104*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-3">
		<a href="#" id="copiarPrecio" onclick="copiarPrecio();return false;" class="btn btn-default" title="Copiar precio">
		<i class="glyphicon glyphicon-floppy-remove"></i> Copiar precio de lista</a>
	</div>
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*127.14*/("""{"""),format.raw/*127.15*/("""
	if($("#producto_modal").length)"""),format.raw/*128.33*/("""{"""),format.raw/*128.34*/("""
		var options = """),format.raw/*129.17*/("""{"""),format.raw/*129.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*135.30*/("""{"""),format.raw/*135.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*137.12*/("""}"""),format.raw/*137.13*/("""
			"""),format.raw/*138.4*/("""}"""),format.raw/*138.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*140.2*/("""}"""),format.raw/*140.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*142.34*/("""{"""),format.raw/*142.35*/("""
		var options = """),format.raw/*143.17*/("""{"""),format.raw/*143.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*149.30*/("""{"""),format.raw/*149.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*151.12*/("""}"""),format.raw/*151.13*/("""
			"""),format.raw/*152.4*/("""}"""),format.raw/*152.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*154.2*/("""}"""),format.raw/*154.3*/("""
"""),format.raw/*155.1*/("""}"""),format.raw/*155.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CertificacionLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasCertificaciones/formLineaProducto.scala.html
                    HASH: 5c57fd0214541e07416a0bfe92c35887a5a59314
                    MATRIX: 834->1|974->59|1006->83|1080->38|1109->127|1163->146|1177->152|1247->201|1320->240|1358->270|1397->272|1520->360|1533->365|1567->378|1610->390|1662->414|1691->415|1883->579|1912->580|1959->599|1988->600|2019->604|2047->605|2104->634|2133->635|2281->755|2310->756|2359->777|2388->778|2453->816|2481->817|2512->821|2540->822|2613->868|2641->869|2671->872|2699->873|2731->878|2759->879|2831->916|2912->975|3076->1103|3127->1145|3167->1147|3196->1158|3209->1163|3248->1164|3294->1177|3337->1185|3477->1302|3518->1308|3624->1392|3804->1536|3824->1547|3895->1596|4207->1873|4240->1897|4259->1907|4307->1917|4373->1947|4387->1952|4417->1960|4459->1971|4628->2104|4687->2154|4727->2156|4756->2167|4769->2172|4808->2173|4854->2186|4897->2194|5018->2292|5059->2298|5174->2391|5401->2582|5421->2593|5505->2655|5818->2933|5859->2965|5878->2975|5926->2985|5992->3015|6006->3020|6036->3028|6078->3039|6252->3177|6298->3214|6338->3216|6367->3227|6380->3232|6419->3233|6464->3246|6507->3254|6602->3327|6643->3333|6671->3352|6690->3362|6738->3372|6800->3398|6814->3403|6844->3411|6883->3418|7059->3558|7107->3597|7147->3599|7176->3610|7189->3615|7228->3616|7273->3629|7316->3637|7415->3714|7456->3720|7486->3741|7505->3751|7553->3761|7615->3787|7629->3792|7659->3800|7698->3807|7849->3921|7896->3958|7937->3960|7967->3971|7981->3976|8021->3977|8067->3990|8111->3998|8277->4140|8319->4146|8348->4165|8368->4175|8417->4185|8480->4211|8495->4216|8526->4224|8567->4232|8746->4374|8796->4414|8837->4416|8880->4426|8924->4434|9047->4533|9758->5215|9788->5216|9851->5250|9881->5251|9928->5269|9958->5270|10128->5411|10158->5412|10251->5476|10281->5477|10314->5482|10343->5483|10440->5552|10469->5553|10536->5591|10566->5592|10613->5610|10643->5611|10833->5772|10863->5773|10957->5838|10987->5839|11020->5844|11049->5845|11147->5915|11176->5916|11206->5918|11235->5919
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|45->17|45->17|45->17|45->17|46->18|46->18|48->20|48->20|51->23|51->23|52->24|52->24|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|58->30|58->30|62->34|62->34|66->38|66->38|66->38|66->38|66->38|66->38|66->38|67->39|67->39|68->40|68->40|72->44|72->44|72->44|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|96->68|96->68|96->68|105->77|105->77|105->77|105->77|106->78|106->78|106->78|107->79|114->86|114->86|114->86|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|122->94|122->94|122->94|122->94|122->94|122->94|122->94|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|129->101|129->101|129->101|129->101|129->101|129->101|129->101|130->102|130->102|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|136->108|136->108|136->108|136->108|137->109|137->109|155->127|155->127|156->128|156->128|157->129|157->129|163->135|163->135|165->137|165->137|166->138|166->138|168->140|168->140|170->142|170->142|171->143|171->143|177->149|177->149|179->151|179->151|180->152|180->152|182->154|182->154|183->155|183->155
                    -- GENERATED --
                */
            