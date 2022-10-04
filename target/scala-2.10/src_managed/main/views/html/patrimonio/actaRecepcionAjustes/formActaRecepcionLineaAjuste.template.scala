
package views.html.patrimonio.actaRecepcionAjustes

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
object formActaRecepcionLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcionLineaAjuste],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ActaRecepcionLineaAjuste]):play.api.templates.HtmlFormat.Appendable = {
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
	"""),_display_(Seq[Any](/*34.3*/inputText(lineaForm("acta_id"), 'type -> "hidden"))),format.raw/*34.53*/("""
	

	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*39.28*/if(lineaForm.error("producto_id") != null)/*39.70*/ {_display_(Seq[Any](format.raw/*39.72*/("""has-error""")))}/*39.83*/else/*39.88*/{_display_(Seq[Any](format.raw/*39.89*/("""has-required""")))})),format.raw/*39.102*/("""">
			"""),_display_(Seq[Any](/*40.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal2"))),format.raw/*40.123*/("""
			"""),_display_(Seq[Any](/*41.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal2"))),format.raw/*41.90*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*45.19*/controllers/*45.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*45.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal2" 
							data-field="#producto_id_modal2">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span> 
		</div>
		"""),_display_(Seq[Any](/*55.4*/lineaForm("producto_id")/*55.28*/.error.map/*55.38*/{ error =>_display_(Seq[Any](format.raw/*55.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*56.29*/error/*56.34*/.message)),format.raw/*56.42*/("""</div>
		""")))})),format.raw/*57.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*61.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*61.78*/ {_display_(Seq[Any](format.raw/*61.80*/("""has-error""")))}/*61.91*/else/*61.96*/{_display_(Seq[Any](format.raw/*61.97*/("""has-required""")))})),format.raw/*61.110*/("""">
			"""),_display_(Seq[Any](/*62.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*62.103*/("""
			"""),_display_(Seq[Any](/*63.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*63.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*69.19*/controllers/*69.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*69.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*78.4*/lineaForm("cuenta_analitica_id")/*78.36*/.error.map/*78.46*/{ error =>_display_(Seq[Any](format.raw/*78.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*79.29*/error/*79.34*/.message)),format.raw/*79.42*/("""</div>
		""")))})),format.raw/*80.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*87.27*/if(lineaForm.error("precio") != null)/*87.64*/ {_display_(Seq[Any](format.raw/*87.66*/("""has-error""")))}/*87.77*/else/*87.82*/{_display_(Seq[Any](format.raw/*87.83*/("""has-required""")))})),format.raw/*87.96*/("""">
			"""),_display_(Seq[Any](/*88.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*88.78*/("""
			"""),_display_(Seq[Any](/*89.5*/lineaForm("precio")/*89.24*/.error.map/*89.34*/{ error =>_display_(Seq[Any](format.raw/*89.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*89.70*/error/*89.75*/.message)),format.raw/*89.83*/("""</div>""")))})),format.raw/*89.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*95.27*/if(lineaForm.error("cantidad") != null)/*95.66*/ {_display_(Seq[Any](format.raw/*95.68*/("""has-error""")))}/*95.79*/else/*95.84*/{_display_(Seq[Any](format.raw/*95.85*/("""has-required""")))})),format.raw/*95.98*/("""">
			"""),_display_(Seq[Any](/*96.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*96.82*/("""
			"""),_display_(Seq[Any](/*97.5*/lineaForm("cantidad")/*97.26*/.error.map/*97.36*/{ error =>_display_(Seq[Any](format.raw/*97.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*97.72*/error/*97.77*/.message)),format.raw/*97.85*/("""</div>""")))})),format.raw/*97.92*/("""
		</div>
	</div>

	
	 
	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*104.27*/if(lineaForm.error("udm_id") != null)/*104.64*/ {_display_(Seq[Any](format.raw/*104.66*/("""has-error""")))}/*104.77*/else/*104.82*/{_display_(Seq[Any](format.raw/*104.83*/("""has-required""")))})),format.raw/*104.96*/("""">
			"""),_display_(Seq[Any](/*105.5*/select(lineaForm("udm_id"), 
			 Udm.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", 
			'_default -> "Seleccionar",'readonly->"readonly"))),format.raw/*108.53*/("""
			"""),_display_(Seq[Any](/*109.5*/lineaForm("udm_id")/*109.24*/.error.map/*109.34*/{ error =>_display_(Seq[Any](format.raw/*109.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*109.70*/error/*109.75*/.message)),format.raw/*109.83*/("""</div> """)))})),format.raw/*109.91*/("""
		</div>
	</div>
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" id="btn-guardar-linea-ajuste-acta" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
<script>
$( function()"""),format.raw/*121.14*/("""{"""),format.raw/*121.15*/("""
	if($("#producto_modal").length)"""),format.raw/*122.33*/("""{"""),format.raw/*122.34*/("""
		var options = """),format.raw/*123.17*/("""{"""),format.raw/*123.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*129.30*/("""{"""),format.raw/*129.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*131.12*/("""}"""),format.raw/*131.13*/("""
			"""),format.raw/*132.4*/("""}"""),format.raw/*132.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*134.2*/("""}"""),format.raw/*134.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*136.34*/("""{"""),format.raw/*136.35*/("""
		var options = """),format.raw/*137.17*/("""{"""),format.raw/*137.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*143.30*/("""{"""),format.raw/*143.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*145.12*/("""}"""),format.raw/*145.13*/("""
			"""),format.raw/*146.4*/("""}"""),format.raw/*146.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*148.2*/("""}"""),format.raw/*148.3*/("""
"""),format.raw/*149.1*/("""}"""),format.raw/*149.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[ActaRecepcionLineaAjuste]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ActaRecepcionLineaAjuste]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/formActaRecepcionLineaAjuste.scala.html
                    HASH: 6d90bcaa338d6bcb45476284a8e0c1746ddc42b9
                    MATRIX: 853->1|999->65|1031->89|1105->44|1134->133|1188->152|1202->158|1272->207|1345->246|1383->276|1422->278|1545->366|1558->371|1592->384|1635->396|1687->420|1716->421|1908->585|1937->586|1984->605|2013->606|2044->610|2072->611|2129->640|2158->641|2306->761|2335->762|2384->783|2413->784|2478->822|2506->823|2537->827|2565->828|2638->874|2666->875|2696->878|2724->879|2756->884|2784->885|2861->927|2933->977|3099->1107|3150->1149|3190->1151|3219->1162|3232->1167|3271->1168|3317->1181|3360->1189|3501->1307|3542->1313|3649->1398|3829->1542|3849->1553|3920->1602|4235->1882|4268->1906|4287->1916|4335->1926|4401->1956|4415->1961|4445->1969|4487->1980|4656->2113|4715->2163|4755->2165|4784->2176|4797->2181|4836->2182|4882->2195|4925->2203|5046->2301|5087->2307|5202->2400|5429->2591|5449->2602|5533->2664|5846->2942|5887->2974|5906->2984|5954->2994|6020->3024|6034->3029|6064->3037|6106->3048|6280->3186|6326->3223|6366->3225|6395->3236|6408->3241|6447->3242|6492->3255|6535->3263|6630->3336|6671->3342|6699->3361|6718->3371|6766->3381|6828->3407|6842->3412|6872->3420|6911->3427|7087->3567|7135->3606|7175->3608|7204->3619|7217->3624|7256->3625|7301->3638|7344->3646|7443->3723|7484->3729|7514->3750|7533->3760|7581->3770|7643->3796|7657->3801|7687->3809|7726->3816|7884->3937|7931->3974|7972->3976|8002->3987|8016->3992|8056->3993|8102->4006|8146->4014|8349->4194|8391->4200|8420->4219|8440->4229|8489->4239|8552->4265|8567->4270|8598->4278|8639->4286|9124->4742|9154->4743|9217->4777|9247->4778|9294->4796|9324->4797|9494->4938|9524->4939|9617->5003|9647->5004|9680->5009|9709->5010|9806->5079|9835->5080|9902->5118|9932->5119|9979->5137|10009->5138|10199->5299|10229->5300|10323->5365|10353->5366|10386->5371|10415->5372|10513->5442|10542->5443|10572->5445|10601->5446
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|45->17|45->17|45->17|45->17|46->18|46->18|48->20|48->20|51->23|51->23|52->24|52->24|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|58->30|58->30|62->34|62->34|67->39|67->39|67->39|67->39|67->39|67->39|67->39|68->40|68->40|69->41|69->41|73->45|73->45|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|85->57|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|91->63|91->63|97->69|97->69|97->69|106->78|106->78|106->78|106->78|107->79|107->79|107->79|108->80|115->87|115->87|115->87|115->87|115->87|115->87|115->87|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|123->95|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|132->104|132->104|132->104|132->104|132->104|132->104|132->104|133->105|136->108|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|149->121|149->121|150->122|150->122|151->123|151->123|157->129|157->129|159->131|159->131|160->132|160->132|162->134|162->134|164->136|164->136|165->137|165->137|171->143|171->143|173->145|173->145|174->146|174->146|176->148|176->148|177->149|177->149
                    -- GENERATED --
                */
            