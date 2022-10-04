
package views.html.compras.cajaChica.movimientos

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
object formLineaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChicaMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CajaChicaMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>

$(function()"""),format.raw/*14.13*/("""{"""),format.raw/*14.14*/("""
							 	
	$('#searchProductoModal,#searchProveedorModal,#searchCuentaAnalitica').modalSearch();
	 
	$("#cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*19.29*/("""{"""),format.raw/*19.30*/("""allowNegative: true"""),format.raw/*19.49*/("""}"""),format.raw/*19.50*/(""");
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""");

</script>

 <div class="row">
 	"""),_display_(Seq[Any](/*25.4*/inputText(lineaForm("id"), 'type -> "hidden"))),format.raw/*25.49*/("""
	"""),_display_(Seq[Any](/*26.3*/inputText(lineaForm("caja_chica_id"), 'type -> "hidden"))),format.raw/*26.59*/("""
	
	<div class="col-sm-6">
		<label for="proveedor_nombre" class="control-label">Proveedor</label>
		<div class="input-group """),_display_(Seq[Any](/*30.28*/if(lineaForm.error("proveedor_id") != null)/*30.71*/ {_display_(Seq[Any](format.raw/*30.73*/("""has-error""")))}/*30.84*/else/*30.89*/{_display_(Seq[Any](format.raw/*30.90*/("""has-required""")))})),format.raw/*30.103*/("""">
			"""),_display_(Seq[Any](/*31.5*/inputText(lineaForm("proveedor.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "proveedor_modal"))),format.raw/*31.124*/("""
			"""),_display_(Seq[Any](/*32.5*/inputText(lineaForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id_modal"))),format.raw/*32.91*/("""
			<span class="input-group-addon">
             	<a href="#" id="searchProveedorModal" 
             				data-title="Selección de proveedor" 
             				data-url=""""),_display_(Seq[Any](/*36.29*/controllers/*36.40*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*36.91*/("""" 
             				data-height="650" data-width="700" 
             				data-listen="modal.seleccion.proveedor.simple" 
             				data-label="#proveedor_modal" 
             				data-field="#proveedor_id_modal"> 
             				 
             				<i class="glyphicon glyphicon-search"></i></a>
             </span> 
		</div>
		"""),_display_(Seq[Any](/*45.4*/lineaForm("proveedor_id")/*45.29*/.error.map/*45.39*/{ error =>_display_(Seq[Any](format.raw/*45.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*46.29*/error/*46.34*/.message)),format.raw/*46.42*/("""</div>
		""")))})),format.raw/*47.4*/("""
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*50.27*/if(lineaForm.error("numero_factura") != null)/*50.72*/ {_display_(Seq[Any](format.raw/*50.74*/("""has-error""")))})),format.raw/*50.84*/("""">
			<label for="inputNumeroFactura" class="control-label">N° de factura</label> 
			"""),_display_(Seq[Any](/*52.5*/inputText(lineaForm("numero_factura"), 'class -> "form-control"))),format.raw/*52.69*/("""
		</div>
		"""),_display_(Seq[Any](/*54.4*/lineaForm("numero_factura")/*54.31*/.error.map/*54.41*/{ error =>_display_(Seq[Any](format.raw/*54.51*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*55.29*/error/*55.34*/.message)),format.raw/*55.42*/("""</div>
		""")))})),format.raw/*56.4*/("""
	</div>
	<div class="col-sm-2">
		<b>Inventariable</b>
		<div class="row">
			<div class="col-sm-5">
				<div class="radio  """),_display_(Seq[Any](/*62.25*/if(lineaForm.error("inventariable") != null)/*62.69*/ {_display_(Seq[Any](format.raw/*62.71*/("""has-error""")))}/*62.82*/else/*62.87*/{_display_(Seq[Any](format.raw/*62.88*/("""has-required""")))})),format.raw/*62.101*/("""">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*64.8*/inputRadioGroup(lineaForm("inventariable"), options = Seq("true"->"SI")))),format.raw/*64.80*/("""
					</label>
				</div>
			</div>	
			<div class="col-sm-5">	
				<div class="radio """),_display_(Seq[Any](/*69.24*/if(lineaForm.error("inventariable") != null)/*69.68*/ {_display_(Seq[Any](format.raw/*69.70*/("""has-error""")))}/*69.81*/else/*69.86*/{_display_(Seq[Any](format.raw/*69.87*/("""has-required""")))})),format.raw/*69.100*/("""">
					<label class="control-label"> 
						"""),_display_(Seq[Any](/*71.8*/inputRadioGroup(lineaForm("inventariable"), options = Seq("false"->"NO")))),format.raw/*71.81*/("""
					</label>
				</div>
			</div>
			"""),_display_(Seq[Any](/*75.5*/lineaForm("inventariable")/*75.31*/.error.map/*75.41*/{ error =>_display_(Seq[Any](format.raw/*75.51*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*76.29*/error/*76.34*/.message)),format.raw/*76.42*/("""</div>
			""")))})),format.raw/*77.5*/("""
		</div>	
	</div>			
</div>	
<div class="row">	
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*85.28*/if(lineaForm.error("producto_id") != null)/*85.70*/ {_display_(Seq[Any](format.raw/*85.72*/("""has-error""")))}/*85.83*/else/*85.88*/{_display_(Seq[Any](format.raw/*85.89*/("""has-required""")))})),format.raw/*85.102*/("""">
			"""),_display_(Seq[Any](/*86.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control",  'id -> "producto_modal"))),format.raw/*86.96*/("""
			"""),_display_(Seq[Any](/*87.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*87.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*91.19*/controllers/*91.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*91.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*102.4*/lineaForm("producto_id")/*102.28*/.error.map/*102.38*/{ error =>_display_(Seq[Any](format.raw/*102.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*103.29*/error/*103.34*/.message)),format.raw/*103.42*/("""</div>
		""")))})),format.raw/*104.4*/("""
	</div>
	
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*109.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*109.78*/ {_display_(Seq[Any](format.raw/*109.80*/("""has-error""")))}/*109.91*/else/*109.96*/{_display_(Seq[Any](format.raw/*109.97*/("""has-required""")))})),format.raw/*109.110*/("""">
			"""),_display_(Seq[Any](/*110.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*110.103*/("""
			"""),_display_(Seq[Any](/*111.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*111.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*117.19*/controllers/*117.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*117.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*126.4*/lineaForm("cuenta_analitica_id")/*126.36*/.error.map/*126.46*/{ error =>_display_(Seq[Any](format.raw/*126.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*127.29*/error/*127.34*/.message)),format.raw/*127.42*/("""</div>
		""")))})),format.raw/*128.4*/("""
	</div>
</div>

<div class="row">

	<div class="col-sm-3">
		<label class="control-label" for="fecha">Fecha Rendicion</label> 
		<div class="form-group """),_display_(Seq[Any](/*136.27*/if(lineaForm.error("fecha") != null)/*136.63*/ {_display_(Seq[Any](format.raw/*136.65*/("""has-error""")))}/*136.76*/else/*136.81*/{_display_(Seq[Any](format.raw/*136.82*/("""has-required""")))})),format.raw/*136.95*/("""">
			"""),_display_(Seq[Any](/*137.5*/inputText(lineaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off", 'id -> "fecha"))),format.raw/*137.104*/("""
		</div>
		"""),_display_(Seq[Any](/*139.4*/lineaForm("fecha")/*139.22*/.error.map/*139.32*/{ error =>_display_(Seq[Any](format.raw/*139.42*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*140.29*/error/*140.34*/.message)),format.raw/*140.42*/("""</div>
		""")))})),format.raw/*141.4*/("""
	</div>

	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*146.27*/if(lineaForm.error("precio") != null)/*146.64*/ {_display_(Seq[Any](format.raw/*146.66*/("""has-error""")))}/*146.77*/else/*146.82*/{_display_(Seq[Any](format.raw/*146.83*/("""has-required""")))})),format.raw/*146.96*/("""">
			"""),_display_(Seq[Any](/*147.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*147.78*/("""
			"""),_display_(Seq[Any](/*148.5*/lineaForm("precio")/*148.24*/.error.map/*148.34*/{ error =>_display_(Seq[Any](format.raw/*148.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*148.70*/error/*148.75*/.message)),format.raw/*148.83*/("""</div>""")))})),format.raw/*148.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*154.27*/if(lineaForm.error("cantidad") != null)/*154.66*/ {_display_(Seq[Any](format.raw/*154.68*/("""has-error""")))}/*154.79*/else/*154.84*/{_display_(Seq[Any](format.raw/*154.85*/("""has-required""")))})),format.raw/*154.98*/("""">
			"""),_display_(Seq[Any](/*155.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*155.82*/("""
			"""),_display_(Seq[Any](/*156.5*/lineaForm("cantidad")/*156.26*/.error.map/*156.36*/{ error =>_display_(Seq[Any](format.raw/*156.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*156.72*/error/*156.77*/.message)),format.raw/*156.85*/("""</div>""")))})),format.raw/*156.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*161.27*/if(lineaForm.error("udm_id") != null)/*161.64*/ {_display_(Seq[Any](format.raw/*161.66*/("""has-error""")))}/*161.77*/else/*161.82*/{_display_(Seq[Any](format.raw/*161.83*/("""has-required""")))})),format.raw/*161.96*/("""">
			"""),_display_(Seq[Any](/*162.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*162.147*/("""
			"""),_display_(Seq[Any](/*163.5*/lineaForm("udm_id")/*163.24*/.error.map/*163.34*/{ error =>_display_(Seq[Any](format.raw/*163.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*163.70*/error/*163.75*/.message)),format.raw/*163.83*/("""</div> """)))})),format.raw/*163.91*/("""
		</div>
	</div>

</div>


<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
"""),_display_(Seq[Any](/*176.2*/flash()/*176.9*/.clear())),format.raw/*176.17*/("""
<script>
$( function()"""),format.raw/*178.14*/("""{"""),format.raw/*178.15*/("""
	
	$( ".date" ).mask("99/99/9999");
	
	if($("#producto_modal").length)"""),format.raw/*182.33*/("""{"""),format.raw/*182.34*/("""
		var options = """),format.raw/*183.17*/("""{"""),format.raw/*183.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*189.30*/("""{"""),format.raw/*189.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*191.12*/("""}"""),format.raw/*191.13*/("""
			"""),format.raw/*192.4*/("""}"""),format.raw/*192.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*194.2*/("""}"""),format.raw/*194.3*/("""
	
	if($("#proveedor_modal").length)"""),format.raw/*196.34*/("""{"""),format.raw/*196.35*/("""
		var options = """),format.raw/*197.17*/("""{"""),format.raw/*197.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*203.30*/("""{"""),format.raw/*203.31*/(""" 
											$("#proveedor_id_modal").val(obj.id); 
										 """),format.raw/*205.12*/("""}"""),format.raw/*205.13*/("""
			"""),format.raw/*206.4*/("""}"""),format.raw/*206.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor_modal', options);
	"""),format.raw/*208.2*/("""}"""),format.raw/*208.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*210.34*/("""{"""),format.raw/*210.35*/("""
		var options = """),format.raw/*211.17*/("""{"""),format.raw/*211.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*217.30*/("""{"""),format.raw/*217.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*219.12*/("""}"""),format.raw/*219.13*/("""
			"""),format.raw/*220.4*/("""}"""),format.raw/*220.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*222.2*/("""}"""),format.raw/*222.3*/("""
"""),format.raw/*223.1*/("""}"""),format.raw/*223.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CajaChicaMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CajaChicaMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/movimientos/formLineaMovimiento.scala.html
                    HASH: 56dc54f2eb33d803e2f0af62c89da5e31e8e225a
                    MATRIX: 837->1|978->60|1010->84|1084->39|1113->128|1167->147|1181->153|1251->202|1324->241|1362->271|1401->273|1524->361|1537->366|1571->379|1614->391|1668->417|1697->418|1892->585|1921->586|1968->605|1997->606|2028->610|2056->611|2133->653|2200->698|2239->702|2317->758|2483->888|2535->931|2575->933|2604->944|2617->949|2656->950|2702->963|2745->971|2887->1090|2928->1096|3036->1182|3248->1358|3268->1369|3341->1420|3723->1767|3757->1792|3776->1802|3824->1812|3890->1842|3904->1847|3934->1855|3976->1866|4074->1928|4128->1973|4168->1975|4210->1985|4334->2074|4420->2138|4470->2153|4506->2180|4525->2190|4573->2200|4639->2230|4653->2235|4683->2243|4725->2254|4893->2386|4946->2430|4986->2432|5015->2443|5028->2448|5067->2449|5113->2462|5196->2510|5290->2582|5418->2674|5471->2718|5511->2720|5540->2731|5553->2736|5592->2737|5638->2750|5721->2798|5816->2871|5895->2915|5930->2941|5949->2951|5997->2961|6063->2991|6077->2996|6107->3004|6150->3016|6366->3196|6417->3238|6457->3240|6486->3251|6499->3256|6538->3257|6584->3270|6627->3278|6740->3369|6781->3375|6887->3459|7067->3603|7087->3614|7158->3663|7480->3949|7514->3973|7534->3983|7583->3993|7650->4023|7665->4028|7696->4036|7739->4047|7912->4183|7972->4233|8013->4235|8043->4246|8057->4251|8097->4252|8144->4265|8188->4273|8310->4371|8352->4377|8468->4470|8696->4661|8717->4672|8802->4734|9116->5012|9158->5044|9178->5054|9227->5064|9294->5094|9309->5099|9340->5107|9383->5118|9582->5280|9628->5316|9669->5318|9699->5329|9713->5334|9753->5335|9799->5348|9843->5356|9966->5455|10017->5470|10045->5488|10065->5498|10114->5508|10181->5538|10196->5543|10227->5551|10270->5562|10418->5673|10465->5710|10506->5712|10536->5723|10550->5728|10590->5729|10636->5742|10680->5750|10776->5823|10818->5829|10847->5848|10867->5858|10916->5868|10979->5894|10994->5899|11025->5907|11065->5914|11242->6054|11291->6093|11332->6095|11362->6106|11376->6111|11416->6112|11462->6125|11506->6133|11606->6210|11648->6216|11679->6237|11699->6247|11748->6257|11811->6283|11826->6288|11857->6296|11897->6303|12048->6417|12095->6454|12136->6456|12166->6467|12180->6472|12220->6473|12266->6486|12310->6494|12476->6636|12518->6642|12547->6661|12567->6671|12616->6681|12679->6707|12694->6712|12725->6720|12766->6728|13205->7131|13221->7138|13252->7146|13306->7171|13336->7172|13440->7247|13470->7248|13517->7266|13547->7267|13717->7408|13747->7409|13840->7473|13870->7474|13903->7479|13932->7480|14029->7549|14058->7550|14125->7588|14155->7589|14202->7607|14232->7608|14403->7750|14433->7751|14527->7816|14557->7817|14590->7822|14619->7823|14717->7893|14746->7894|14813->7932|14843->7933|14890->7951|14920->7952|15110->8113|15140->8114|15234->8179|15264->8180|15297->8185|15326->8186|15424->8256|15453->8257|15483->8259|15512->8260
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|42->14|42->14|47->19|47->19|47->19|47->19|48->20|48->20|53->25|53->25|54->26|54->26|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|60->32|60->32|64->36|64->36|64->36|73->45|73->45|73->45|73->45|74->46|74->46|74->46|75->47|78->50|78->50|78->50|78->50|80->52|80->52|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|90->62|90->62|90->62|90->62|90->62|90->62|90->62|92->64|92->64|97->69|97->69|97->69|97->69|97->69|97->69|97->69|99->71|99->71|103->75|103->75|103->75|103->75|104->76|104->76|104->76|105->77|113->85|113->85|113->85|113->85|113->85|113->85|113->85|114->86|114->86|115->87|115->87|119->91|119->91|119->91|130->102|130->102|130->102|130->102|131->103|131->103|131->103|132->104|137->109|137->109|137->109|137->109|137->109|137->109|137->109|138->110|138->110|139->111|139->111|145->117|145->117|145->117|154->126|154->126|154->126|154->126|155->127|155->127|155->127|156->128|164->136|164->136|164->136|164->136|164->136|164->136|164->136|165->137|165->137|167->139|167->139|167->139|167->139|168->140|168->140|168->140|169->141|174->146|174->146|174->146|174->146|174->146|174->146|174->146|175->147|175->147|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|182->154|182->154|182->154|182->154|182->154|182->154|182->154|183->155|183->155|184->156|184->156|184->156|184->156|184->156|184->156|184->156|184->156|189->161|189->161|189->161|189->161|189->161|189->161|189->161|190->162|190->162|191->163|191->163|191->163|191->163|191->163|191->163|191->163|191->163|204->176|204->176|204->176|206->178|206->178|210->182|210->182|211->183|211->183|217->189|217->189|219->191|219->191|220->192|220->192|222->194|222->194|224->196|224->196|225->197|225->197|231->203|231->203|233->205|233->205|234->206|234->206|236->208|236->208|238->210|238->210|239->211|239->211|245->217|245->217|247->219|247->219|248->220|248->220|250->222|250->222|251->223|251->223
                    -- GENERATED --
                */
            