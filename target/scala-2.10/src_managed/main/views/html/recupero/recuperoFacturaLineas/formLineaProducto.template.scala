
package views.html.recupero.recuperoFacturaLineas

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoFacturaLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[models.recupero.RecuperoFacturaLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$(document).on('modal.seleccion.producto.simple', function (event, respuesta) """),format.raw/*14.80*/("""{"""),format.raw/*14.81*/("""
		$('#precio').val(respuesta.costo);
	"""),format.raw/*16.2*/("""}"""),format.raw/*16.3*/(""");
	$('#searchProductoModal').modalSearch();
	$('#searchCuentaAnalitica').modalSearch();
	$("#cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*20.29*/("""{"""),format.raw/*20.30*/("""allowNegative: true"""),format.raw/*20.49*/("""}"""),format.raw/*20.50*/(""");
	$('#searchCuentaModal').modalSearch();
"""),format.raw/*22.1*/("""}"""),format.raw/*22.2*/(""");

</script>

 <div class="row">
	"""),_display_(Seq[Any](/*27.3*/inputText(lineaForm("recupero_factura_id"), 'type -> "hidden"))),format.raw/*27.65*/("""
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*31.28*/if(lineaForm.error("producto_id") != null)/*31.70*/ {_display_(Seq[Any](format.raw/*31.72*/("""has-error""")))}/*31.83*/else/*31.88*/{_display_(Seq[Any](format.raw/*31.89*/("""has-required""")))})),format.raw/*31.102*/("""">
			"""),_display_(Seq[Any](/*32.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*32.122*/("""
			"""),_display_(Seq[Any](/*33.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*33.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*37.19*/controllers/*37.30*/.compras.routes.ProductosController.modalBuscarIps())),format.raw/*37.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*47.4*/lineaForm("producto_id")/*47.28*/.error.map/*47.38*/{ error =>_display_(Seq[Any](format.raw/*47.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*48.29*/error/*48.34*/.message)),format.raw/*48.42*/("""</div>
		""")))})),format.raw/*49.4*/("""
	</div>
	
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*57.27*/if(lineaForm.error("precio") != null)/*57.64*/ {_display_(Seq[Any](format.raw/*57.66*/("""has-error""")))}/*57.77*/else/*57.82*/{_display_(Seq[Any](format.raw/*57.83*/("""has-required""")))})),format.raw/*57.96*/("""">
			"""),_display_(Seq[Any](/*58.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*58.78*/("""
			"""),_display_(Seq[Any](/*59.5*/lineaForm("precio")/*59.24*/.error.map/*59.34*/{ error =>_display_(Seq[Any](format.raw/*59.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*59.70*/error/*59.75*/.message)),format.raw/*59.83*/("""</div>""")))})),format.raw/*59.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*65.27*/if(lineaForm.error("cantidad") != null)/*65.66*/ {_display_(Seq[Any](format.raw/*65.68*/("""has-error""")))}/*65.79*/else/*65.84*/{_display_(Seq[Any](format.raw/*65.85*/("""has-required""")))})),format.raw/*65.98*/("""">
			"""),_display_(Seq[Any](/*66.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*66.82*/("""
			"""),_display_(Seq[Any](/*67.5*/lineaForm("cantidad")/*67.26*/.error.map/*67.36*/{ error =>_display_(Seq[Any](format.raw/*67.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*67.72*/error/*67.77*/.message)),format.raw/*67.85*/("""</div>""")))})),format.raw/*67.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*72.27*/if(lineaForm.error("udm_id") != null)/*72.64*/ {_display_(Seq[Any](format.raw/*72.66*/("""has-error""")))}/*72.77*/else/*72.82*/{_display_(Seq[Any](format.raw/*72.83*/("""has-required""")))})),format.raw/*72.96*/("""">
			"""),_display_(Seq[Any](/*73.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*73.147*/("""
			"""),_display_(Seq[Any](/*74.5*/lineaForm("udm_id")/*74.24*/.error.map/*74.34*/{ error =>_display_(Seq[Any](format.raw/*74.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*74.70*/error/*74.75*/.message)),format.raw/*74.83*/("""</div> """)))})),format.raw/*74.91*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*81.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*81.78*/ {_display_(Seq[Any](format.raw/*81.80*/("""has-error""")))}/*81.91*/else/*81.96*/{_display_(Seq[Any](format.raw/*81.97*/("""has-required""")))})),format.raw/*81.110*/("""">
			"""),_display_(Seq[Any](/*82.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*82.103*/("""
			"""),_display_(Seq[Any](/*83.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*83.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*89.19*/controllers/*89.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*89.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*98.4*/lineaForm("cuenta_analitica_id")/*98.36*/.error.map/*98.46*/{ error =>_display_(Seq[Any](format.raw/*98.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*99.29*/error/*99.34*/.message)),format.raw/*99.42*/("""</div>
		""")))})),format.raw/*100.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*104.28*/if(lineaForm.error("cuenta_id") != null)/*104.68*/ {_display_(Seq[Any](format.raw/*104.70*/("""has-error""")))}/*104.81*/else/*104.86*/{_display_(Seq[Any](format.raw/*104.87*/("""has-required""")))})),format.raw/*104.100*/("""">
			"""),_display_(Seq[Any](/*105.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*105.91*/("""
			"""),_display_(Seq[Any](/*106.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*106.84*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModal" 
							data-title="Selección de Cuenta" 
							data-url=""""),_display_(Seq[Any](/*111.19*/controllers/*111.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*111.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal" 
							data-field="#cuenta_id_modal">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*121.4*/lineaForm("cuenta_id")/*121.26*/.error.map/*121.36*/{ error =>_display_(Seq[Any](format.raw/*121.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*122.29*/error/*122.34*/.message)),format.raw/*122.42*/("""</div>
		""")))})),format.raw/*123.4*/("""
	</div>
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*134.14*/("""{"""),format.raw/*134.15*/("""
	if($("#producto_modal").length)"""),format.raw/*135.33*/("""{"""),format.raw/*135.34*/("""
		var options = """),format.raw/*136.17*/("""{"""),format.raw/*136.18*/("""
				script:"/suggestProductoPresupuesto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*142.30*/("""{"""),format.raw/*142.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
											$("#precio").val(obj.precio);
										 """),format.raw/*145.12*/("""}"""),format.raw/*145.13*/("""
			"""),format.raw/*146.4*/("""}"""),format.raw/*146.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*148.2*/("""}"""),format.raw/*148.3*/("""
	if($("#cuenta_modal").length)"""),format.raw/*149.31*/("""{"""),format.raw/*149.32*/("""
		var options = """),format.raw/*150.17*/("""{"""),format.raw/*150.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*156.30*/("""{"""),format.raw/*156.31*/(""" 
											$("#cuenta_id_modal").val(obj.id); 
										 """),format.raw/*158.12*/("""}"""),format.raw/*158.13*/("""
			"""),format.raw/*159.4*/("""}"""),format.raw/*159.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_modal', options);
	"""),format.raw/*161.2*/("""}"""),format.raw/*161.3*/("""	
	if($("#cuentaAnalitica").length)"""),format.raw/*162.34*/("""{"""),format.raw/*162.35*/("""
		var options = """),format.raw/*163.17*/("""{"""),format.raw/*163.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*169.30*/("""{"""),format.raw/*169.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*171.12*/("""}"""),format.raw/*171.13*/("""
			"""),format.raw/*172.4*/("""}"""),format.raw/*172.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*174.2*/("""}"""),format.raw/*174.3*/("""
"""),format.raw/*175.1*/("""}"""),format.raw/*175.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[models.recupero.RecuperoFacturaLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[models.recupero.RecuperoFacturaLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFacturaLineas/formLineaProducto.scala.html
                    HASH: bc9cf9ae67883ccad9933474da44c2b00e304bfe
                    MATRIX: 853->1|1011->77|1043->101|1117->56|1146->145|1200->164|1214->170|1284->219|1357->258|1395->288|1434->290|1557->378|1570->383|1604->396|1647->408|1699->432|1728->433|1837->514|1866->515|1934->556|1962->557|2144->711|2173->712|2220->731|2249->732|2321->777|2349->778|2425->819|2509->881|2673->1009|2724->1051|2764->1053|2793->1064|2806->1069|2845->1070|2891->1083|2934->1091|3074->1208|3115->1214|3221->1298|3401->1442|3421->1453|3495->1505|3807->1782|3840->1806|3859->1816|3907->1826|3973->1856|3987->1861|4017->1869|4059->1880|4236->2021|4282->2058|4322->2060|4351->2071|4364->2076|4403->2077|4448->2090|4491->2098|4586->2171|4627->2177|4655->2196|4674->2206|4722->2216|4784->2242|4798->2247|4828->2255|4867->2262|5043->2402|5091->2441|5131->2443|5160->2454|5173->2459|5212->2460|5257->2473|5300->2481|5399->2558|5440->2564|5470->2585|5489->2595|5537->2605|5599->2631|5613->2636|5643->2644|5682->2651|5832->2765|5878->2802|5918->2804|5947->2815|5960->2820|5999->2821|6044->2834|6087->2842|6252->2984|6293->2990|6321->3009|6340->3019|6388->3029|6450->3055|6464->3060|6494->3068|6534->3076|6740->3246|6799->3296|6839->3298|6868->3309|6881->3314|6920->3315|6966->3328|7009->3336|7130->3434|7171->3440|7286->3533|7513->3724|7533->3735|7617->3797|7930->4075|7971->4107|7990->4117|8038->4127|8104->4157|8118->4162|8148->4170|8191->4181|8351->4304|8401->4344|8442->4346|8472->4357|8486->4362|8526->4363|8573->4376|8617->4384|8726->4470|8768->4476|8870->4555|9075->4723|9096->4734|9171->4786|9476->5055|9508->5077|9528->5087|9577->5097|9644->5127|9659->5132|9690->5140|9733->5151|10174->5563|10204->5564|10267->5598|10297->5599|10344->5617|10374->5618|10555->5770|10585->5771|10720->5877|10750->5878|10783->5883|10812->5884|10909->5953|10938->5954|10999->5986|11029->5987|11076->6005|11106->6006|11287->6158|11317->6159|11408->6221|11438->6222|11471->6227|11500->6228|11595->6295|11624->6296|11689->6332|11719->6333|11766->6351|11796->6352|11986->6513|12016->6514|12110->6579|12140->6580|12173->6585|12202->6586|12300->6656|12329->6657|12359->6659|12388->6660
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|42->14|42->14|44->16|44->16|48->20|48->20|48->20|48->20|50->22|50->22|55->27|55->27|59->31|59->31|59->31|59->31|59->31|59->31|59->31|60->32|60->32|61->33|61->33|65->37|65->37|65->37|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|85->57|85->57|85->57|85->57|85->57|85->57|85->57|86->58|86->58|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|93->65|93->65|93->65|93->65|93->65|93->65|93->65|94->66|94->66|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|100->72|100->72|100->72|100->72|100->72|100->72|100->72|101->73|101->73|102->74|102->74|102->74|102->74|102->74|102->74|102->74|102->74|109->81|109->81|109->81|109->81|109->81|109->81|109->81|110->82|110->82|111->83|111->83|117->89|117->89|117->89|126->98|126->98|126->98|126->98|127->99|127->99|127->99|128->100|132->104|132->104|132->104|132->104|132->104|132->104|132->104|133->105|133->105|134->106|134->106|139->111|139->111|139->111|149->121|149->121|149->121|149->121|150->122|150->122|150->122|151->123|162->134|162->134|163->135|163->135|164->136|164->136|170->142|170->142|173->145|173->145|174->146|174->146|176->148|176->148|177->149|177->149|178->150|178->150|184->156|184->156|186->158|186->158|187->159|187->159|189->161|189->161|190->162|190->162|191->163|191->163|197->169|197->169|199->171|199->171|200->172|200->172|202->174|202->174|203->175|203->175
                    -- GENERATED --
                */
            