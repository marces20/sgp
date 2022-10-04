
package views.html.contabilidad.facturasLineas

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[FacturaLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[FacturaLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*3.70*/(""" 



"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$('#searchCuentaModal').modalSearch();
	$('#searchProductoModal').modalSearch();
	$('#searchCuentaAnalitica').modalSearch();
	$('#searchCuentaAnaliticaOriginal').modalSearch();
	$("#descuento, #cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*19.29*/("""{"""),format.raw/*19.30*/("""allowNegative: true"""),format.raw/*19.49*/("""}"""),format.raw/*19.50*/(""");
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*24.3*/inputText(lineaForm("factura_id"), 'type -> "hidden"))),format.raw/*24.56*/("""
	
	<div class="col-sm-12">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*28.28*/if(lineaForm.error("producto_id") != null)/*28.70*/ {_display_(Seq[Any](format.raw/*28.72*/("""has-error""")))}/*28.83*/else/*28.88*/{_display_(Seq[Any](format.raw/*28.89*/("""has-required""")))})),format.raw/*28.102*/("""">
			"""),_display_(Seq[Any](/*29.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*29.122*/("""
			"""),_display_(Seq[Any](/*30.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*30.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*34.19*/controllers/*34.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*34.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*44.4*/lineaForm("producto_id")/*44.28*/.error.map/*44.38*/{ error =>_display_(Seq[Any](format.raw/*44.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*45.29*/error/*45.34*/.message)),format.raw/*45.42*/("""</div>
		""")))})),format.raw/*46.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*53.27*/if(lineaForm.error("precio") != null)/*53.64*/ {_display_(Seq[Any](format.raw/*53.66*/("""has-error""")))}/*53.77*/else/*53.82*/{_display_(Seq[Any](format.raw/*53.83*/("""has-required""")))})),format.raw/*53.96*/("""">
			"""),_display_(Seq[Any](/*54.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*54.78*/("""
			"""),_display_(Seq[Any](/*55.5*/lineaForm("precio")/*55.24*/.error.map/*55.34*/{ error =>_display_(Seq[Any](format.raw/*55.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.70*/error/*55.75*/.message)),format.raw/*55.83*/("""</div>""")))})),format.raw/*55.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*61.27*/if(lineaForm.error("cantidad") != null)/*61.66*/ {_display_(Seq[Any](format.raw/*61.68*/("""has-error""")))}/*61.79*/else/*61.84*/{_display_(Seq[Any](format.raw/*61.85*/("""has-required""")))})),format.raw/*61.98*/("""">
			"""),_display_(Seq[Any](/*62.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*62.82*/("""
			"""),_display_(Seq[Any](/*63.5*/lineaForm("cantidad")/*63.26*/.error.map/*63.36*/{ error =>_display_(Seq[Any](format.raw/*63.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*63.72*/error/*63.77*/.message)),format.raw/*63.85*/("""</div>""")))})),format.raw/*63.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*68.27*/if(lineaForm.error("udm_id") != null)/*68.64*/ {_display_(Seq[Any](format.raw/*68.66*/("""has-error""")))}/*68.77*/else/*68.82*/{_display_(Seq[Any](format.raw/*68.83*/("""has-required""")))})),format.raw/*68.96*/("""">
			"""),_display_(Seq[Any](/*69.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*69.147*/("""
			"""),_display_(Seq[Any](/*70.5*/lineaForm("udm_id")/*70.24*/.error.map/*70.34*/{ error =>_display_(Seq[Any](format.raw/*70.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*70.70*/error/*70.75*/.message)),format.raw/*70.83*/("""</div> """)))})),format.raw/*70.91*/("""
		</div>
	</div>
	
	<!-- 
	<div class="col-sm-3">
		<label for="descuento" class="control-label">Descuento (%)</label>
		<div class="form-group """),_display_(Seq[Any](/*77.27*/if(lineaForm.error("descuento") != null)/*77.67*/ {_display_(Seq[Any](format.raw/*77.69*/("""has-error""")))})),format.raw/*77.79*/("""">
			"""),_display_(Seq[Any](/*78.5*/inputText(lineaForm("descuento"), 'class -> "form-control", 'id -> "descuento", 'id -> "descuento"))),format.raw/*78.104*/("""
		</div>
	</div>
	 -->
</div>
<div class="row">
	<div class="col-sm-12">
		<label for="nombre" class="control-label">Descripción</label>
		<div class="form-group """),_display_(Seq[Any](/*86.27*/if(lineaForm.error("nombre") != null)/*86.64*/ {_display_(Seq[Any](format.raw/*86.66*/("""has-error""")))})),format.raw/*86.76*/("""">
			"""),_display_(Seq[Any](/*87.5*/inputText(lineaForm("nombre"), 'class -> "form-control", 'id -> "nombre"))),format.raw/*87.78*/("""
			"""),_display_(Seq[Any](/*88.5*/lineaForm("nombre")/*88.24*/.error.map/*88.34*/{ error =>_display_(Seq[Any](format.raw/*88.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*88.70*/error/*88.75*/.message)),format.raw/*88.83*/("""</div>""")))})),format.raw/*88.90*/("""
		</div>
	</div>	
</div>
<div class="row">
	
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*96.28*/if(lineaForm.error("cuenta_id") != null)/*96.68*/ {_display_(Seq[Any](format.raw/*96.70*/("""has-error""")))}/*96.81*/else/*96.86*/{_display_(Seq[Any](format.raw/*96.87*/("""has-required""")))})),format.raw/*96.100*/("""">
			"""),_display_(Seq[Any](/*97.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*97.91*/("""
			"""),_display_(Seq[Any](/*98.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*98.84*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModal" 
							data-title="Selección de Cuenta" 
							data-url=""""),_display_(Seq[Any](/*103.19*/controllers/*103.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*103.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal" 
							data-field="#cuenta_id_modal">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*113.4*/lineaForm("cuenta_id")/*113.26*/.error.map/*113.36*/{ error =>_display_(Seq[Any](format.raw/*113.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*114.29*/error/*114.34*/.message)),format.raw/*114.42*/("""</div>
		""")))})),format.raw/*115.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta presupuestaria</label>
		<div class="input-group """),_display_(Seq[Any](/*119.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*119.78*/ {_display_(Seq[Any](format.raw/*119.80*/("""has-error""")))}/*119.91*/else/*119.96*/{_display_(Seq[Any](format.raw/*119.97*/("""has-required""")))})),format.raw/*119.110*/("""">
			"""),_display_(Seq[Any](/*120.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*120.103*/("""
			"""),_display_(Seq[Any](/*121.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*121.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*127.19*/controllers/*127.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*127.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*136.4*/lineaForm("cuenta_analitica_id")/*136.36*/.error.map/*136.46*/{ error =>_display_(Seq[Any](format.raw/*136.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*137.29*/error/*137.34*/.message)),format.raw/*137.42*/("""</div>
		""")))})),format.raw/*138.4*/("""
	</div>
</div>
<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta presupuestaria original</label>
		<div class="input-group """),_display_(Seq[Any](/*144.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*144.78*/ {_display_(Seq[Any](format.raw/*144.80*/("""has-error""")))}/*144.91*/else/*144.96*/{_display_(Seq[Any](format.raw/*144.97*/("""has-required""")))})),format.raw/*144.110*/("""">
			"""),_display_(Seq[Any](/*145.5*/inputText(lineaForm("cuentaAnaliticaOriginal.nombre"), 'class -> "form-control", 'id -> "cuentaAnaliticaOriginal"))),format.raw/*145.119*/("""
			"""),_display_(Seq[Any](/*146.5*/inputText(lineaForm("cuenta_analitica_original_id"), 'hidden -> "hidden", 'id -> "cuentaAnaliticaOriginal_id"))),format.raw/*146.115*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnaliticaOriginal" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica Original" 
				   data-url=""""),_display_(Seq[Any](/*152.19*/controllers/*152.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*152.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnaliticaOriginal.simple" 
				   data-label="#cuentaAnaliticaOriginal" data-field="#cuentaAnaliticaOriginal_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*161.4*/lineaForm("cuenta_analitica_original_id")/*161.45*/.error.map/*161.55*/{ error =>_display_(Seq[Any](format.raw/*161.65*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*162.29*/error/*162.34*/.message)),format.raw/*162.42*/("""</div>
		""")))})),format.raw/*163.4*/("""
	</div>
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*173.14*/("""{"""),format.raw/*173.15*/("""

if($("#producto_modal").length)"""),format.raw/*175.32*/("""{"""),format.raw/*175.33*/("""
		var options = """),format.raw/*176.17*/("""{"""),format.raw/*176.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*182.30*/("""{"""),format.raw/*182.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*184.12*/("""}"""),format.raw/*184.13*/("""
			"""),format.raw/*185.4*/("""}"""),format.raw/*185.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*187.2*/("""}"""),format.raw/*187.3*/("""
if($("#cuenta_modal").length)"""),format.raw/*188.30*/("""{"""),format.raw/*188.31*/("""
	var options = """),format.raw/*189.16*/("""{"""),format.raw/*189.17*/("""
			script:"/contabilidad/suggestCuenta/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*195.29*/("""{"""),format.raw/*195.30*/(""" 
										$("#cuenta_id_modal").val(obj.id); 
									 """),format.raw/*197.11*/("""}"""),format.raw/*197.12*/("""
		"""),format.raw/*198.3*/("""}"""),format.raw/*198.4*/(""";
	var as_json = new bsn.AutoSuggest('cuenta_modal', options);
"""),format.raw/*200.1*/("""}"""),format.raw/*200.2*/("""	
if($("#cuentaAnalitica").length)"""),format.raw/*201.33*/("""{"""),format.raw/*201.34*/("""
	var options = """),format.raw/*202.16*/("""{"""),format.raw/*202.17*/("""
			script:"/contabilidad/suggestCuentaAnalitica/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*208.29*/("""{"""),format.raw/*208.30*/(""" 
										$("#cuentaAnalitica_id").val(obj.id); 
									 """),format.raw/*210.11*/("""}"""),format.raw/*210.12*/("""
		"""),format.raw/*211.3*/("""}"""),format.raw/*211.4*/(""";
	var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
"""),format.raw/*213.1*/("""}"""),format.raw/*213.2*/("""	
if($("#cuentaAnaliticaOriginal").length)"""),format.raw/*214.41*/("""{"""),format.raw/*214.42*/("""
	var options = """),format.raw/*215.16*/("""{"""),format.raw/*215.17*/("""
			script:"/contabilidad/suggestCuentaAnalitica/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*221.29*/("""{"""),format.raw/*221.30*/(""" 
										$("#cuentaAnaliticaOriginal_id").val(obj.id); 
									 """),format.raw/*223.11*/("""}"""),format.raw/*223.12*/("""
		"""),format.raw/*224.3*/("""}"""),format.raw/*224.4*/(""";
	var as_json = new bsn.AutoSuggest('cuentaAnaliticaOriginal', options);
"""),format.raw/*226.1*/("""}"""),format.raw/*226.2*/("""	
"""),format.raw/*227.1*/("""}"""),format.raw/*227.2*/(""");
</script>"""))}
    }
    
    def render(lineaForm:Form[FacturaLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[FacturaLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineas/formLineaProducto.scala.html
                    HASH: a0a1ea7d3a5635bca88b88196d637570d65e76fd
                    MATRIX: 826->1|960->53|992->77|1066->32|1095->121|1139->131|1177->161|1216->163|1339->251|1352->256|1386->269|1429->281|1481->305|1510->306|1796->564|1825->565|1872->584|1901->585|1932->589|1960->590|2034->629|2109->682|2274->811|2325->853|2365->855|2394->866|2407->871|2446->872|2492->885|2535->893|2675->1010|2716->1016|2822->1100|3002->1244|3022->1255|3093->1304|3405->1581|3438->1605|3457->1615|3505->1625|3571->1655|3585->1660|3615->1668|3657->1679|3831->1817|3877->1854|3917->1856|3946->1867|3959->1872|3998->1873|4043->1886|4086->1894|4181->1967|4222->1973|4250->1992|4269->2002|4317->2012|4379->2038|4393->2043|4423->2051|4462->2058|4638->2198|4686->2237|4726->2239|4755->2250|4768->2255|4807->2256|4852->2269|4895->2277|4994->2354|5035->2360|5065->2381|5084->2391|5132->2401|5194->2427|5208->2432|5238->2440|5277->2447|5427->2561|5473->2598|5513->2600|5542->2611|5555->2616|5594->2617|5639->2630|5682->2638|5847->2780|5888->2786|5916->2805|5935->2815|5983->2825|6045->2851|6059->2856|6089->2864|6129->2872|6318->3025|6367->3065|6407->3067|6449->3077|6492->3085|6614->3184|6822->3356|6868->3393|6908->3395|6950->3405|6993->3413|7088->3486|7129->3492|7157->3511|7176->3521|7224->3531|7286->3557|7300->3562|7330->3570|7369->3577|7569->3741|7618->3781|7658->3783|7687->3794|7700->3799|7739->3800|7785->3813|7828->3821|7936->3907|7977->3913|8078->3992|8283->4160|8304->4171|8379->4223|8684->4492|8716->4514|8736->4524|8785->4534|8852->4564|8867->4569|8898->4577|8941->4588|9116->4726|9176->4776|9217->4778|9247->4789|9261->4794|9301->4795|9348->4808|9392->4816|9514->4914|9556->4920|9672->5013|9900->5204|9921->5215|10006->5277|10320->5555|10362->5587|10382->5597|10431->5607|10498->5637|10513->5642|10544->5650|10587->5661|10798->5835|10858->5885|10899->5887|10929->5898|10943->5903|10983->5904|11030->5917|11074->5925|11212->6039|11254->6045|11388->6155|11633->6363|11654->6374|11739->6436|12077->6738|12128->6779|12148->6789|12197->6799|12264->6829|12279->6834|12310->6842|12353->6853|12751->7222|12781->7223|12845->7258|12875->7259|12922->7277|12952->7278|13122->7419|13152->7420|13245->7484|13275->7485|13308->7490|13337->7491|13434->7560|13463->7561|13523->7592|13553->7593|13599->7610|13629->7611|13804->7757|13834->7758|13923->7818|13953->7819|13985->7823|14014->7824|14107->7889|14136->7890|14200->7925|14230->7926|14276->7943|14306->7944|14490->8099|14520->8100|14612->8163|14642->8164|14674->8168|14703->8169|14799->8237|14828->8238|14900->8281|14930->8282|14976->8299|15006->8300|15190->8455|15220->8456|15320->8527|15350->8528|15382->8532|15411->8533|15515->8609|15544->8610|15575->8613|15604->8614
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|47->19|47->19|47->19|47->19|48->20|48->20|52->24|52->24|56->28|56->28|56->28|56->28|56->28|56->28|56->28|57->29|57->29|58->30|58->30|62->34|62->34|62->34|72->44|72->44|72->44|72->44|73->45|73->45|73->45|74->46|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|105->77|105->77|105->77|105->77|106->78|106->78|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|124->96|124->96|124->96|124->96|124->96|124->96|124->96|125->97|125->97|126->98|126->98|131->103|131->103|131->103|141->113|141->113|141->113|141->113|142->114|142->114|142->114|143->115|147->119|147->119|147->119|147->119|147->119|147->119|147->119|148->120|148->120|149->121|149->121|155->127|155->127|155->127|164->136|164->136|164->136|164->136|165->137|165->137|165->137|166->138|172->144|172->144|172->144|172->144|172->144|172->144|172->144|173->145|173->145|174->146|174->146|180->152|180->152|180->152|189->161|189->161|189->161|189->161|190->162|190->162|190->162|191->163|201->173|201->173|203->175|203->175|204->176|204->176|210->182|210->182|212->184|212->184|213->185|213->185|215->187|215->187|216->188|216->188|217->189|217->189|223->195|223->195|225->197|225->197|226->198|226->198|228->200|228->200|229->201|229->201|230->202|230->202|236->208|236->208|238->210|238->210|239->211|239->211|241->213|241->213|242->214|242->214|243->215|243->215|249->221|249->221|251->223|251->223|252->224|252->224|254->226|254->226|255->227|255->227
                    -- GENERATED --
                */
            