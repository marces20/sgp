
package views.html.compras.lineasAjustesOrdenes

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
object formLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenLineaAjuste],OrdenLineaAjuste,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[OrdenLineaAjuste],linea:OrdenLineaAjuste):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""

<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
	$("#cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*10.29*/("""{"""),format.raw/*10.30*/("""allowNegative: true"""),format.raw/*10.49*/("""}"""),format.raw/*10.50*/(""");
	$('#searchProducto,#searchCuentaAnalitica').modalSearch();
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*16.3*/inputText(lineaForm("orden_id"), 'type -> "hidden"))),format.raw/*16.54*/("""
	<div class="col-sm-8">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*19.28*/if(lineaForm.error("producto_id") != null)/*19.70*/ {_display_(Seq[Any](format.raw/*19.72*/("""has-error""")))}/*19.83*/else/*19.88*/{_display_(Seq[Any](format.raw/*19.89*/("""has-required""")))})),format.raw/*19.102*/("""">
			
			"""),_display_(Seq[Any](/*21.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*21.116*/("""
			"""),_display_(Seq[Any](/*22.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*22.83*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*23.114*/controllers/*23.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*23.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
		"""),_display_(Seq[Any](/*25.4*/lineaForm("producto_id")/*25.28*/.error.map/*25.38*/{ error =>_display_(Seq[Any](format.raw/*25.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*26.29*/error/*26.34*/.message)),format.raw/*26.42*/("""</div>
		""")))})),format.raw/*27.4*/("""
	</div>
	
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*35.27*/if(lineaForm.error("precio") != null)/*35.64*/ {_display_(Seq[Any](format.raw/*35.66*/("""has-error""")))}/*35.77*/else/*35.82*/{_display_(Seq[Any](format.raw/*35.83*/("""has-required""")))})),format.raw/*35.96*/("""">
			
			"""),_display_(Seq[Any](/*37.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*37.78*/("""
			
			"""),_display_(Seq[Any](/*39.5*/lineaForm("precio")/*39.24*/.error.map/*39.34*/{ error =>_display_(Seq[Any](format.raw/*39.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*39.70*/error/*39.75*/.message)),format.raw/*39.83*/("""</div>""")))})),format.raw/*39.90*/("""
		</div>
	</div>
		
	<div class="col-sm-2">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*45.27*/if(lineaForm.error("cantidad") != null)/*45.66*/ {_display_(Seq[Any](format.raw/*45.68*/("""has-error""")))}/*45.79*/else/*45.84*/{_display_(Seq[Any](format.raw/*45.85*/("""has-required""")))})),format.raw/*45.98*/("""">
			"""),_display_(Seq[Any](/*46.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*46.82*/("""
			"""),_display_(Seq[Any](/*47.5*/lineaForm("cantidad")/*47.26*/.error.map/*47.36*/{ error =>_display_(Seq[Any](format.raw/*47.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*47.72*/error/*47.77*/.message)),format.raw/*47.85*/("""</div>""")))})),format.raw/*47.92*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*53.27*/if(lineaForm.error("udm_id") != null)/*53.64*/ {_display_(Seq[Any](format.raw/*53.66*/("""has-error""")))}/*53.77*/else/*53.82*/{_display_(Seq[Any](format.raw/*53.83*/("""has-required""")))})),format.raw/*53.96*/("""">
			"""),_display_(Seq[Any](/*54.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*54.147*/("""
			"""),_display_(Seq[Any](/*55.5*/lineaForm("udm_id")/*55.24*/.error.map/*55.34*/{ error =>_display_(Seq[Any](format.raw/*55.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.70*/error/*55.75*/.message)),format.raw/*55.83*/("""</div> """)))})),format.raw/*55.91*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<label for="cuenta" class="control-label">Cuenta Presupuestaria</label>
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
		"""),_display_(Seq[Any](/*77.4*/lineaForm("cuenta_analitica_id")/*77.36*/.error.map/*77.46*/{ error =>_display_(Seq[Any](format.raw/*77.56*/(""" <div class="text-error">"""),_display_(Seq[Any](/*77.82*/error/*77.87*/.message)),format.raw/*77.95*/("""</div> """)))})),format.raw/*77.103*/("""
	</div>
</div>
<div class="row">
	<div class="col-sm-8">
		<label for="nombre" class="control-label">Descripcion</label>
		<div class="form-group """),_display_(Seq[Any](/*83.27*/if(lineaForm.error("nota") != null)/*83.62*/ {_display_(Seq[Any](format.raw/*83.64*/("""has-error""")))})),format.raw/*83.74*/("""">
			"""),_display_(Seq[Any](/*84.5*/inputText(lineaForm("nota"), 'class -> "form-control", 'id -> "nota"))),format.raw/*84.74*/("""
			"""),_display_(Seq[Any](/*85.5*/lineaForm("nota")/*85.22*/.error.map/*85.32*/{ error =>_display_(Seq[Any](format.raw/*85.42*/(""" <div class="text-error">"""),_display_(Seq[Any](/*85.68*/error/*85.73*/.message)),format.raw/*85.81*/("""</div>""")))})),format.raw/*85.88*/("""
		</div>
	</div>	
</div>


<div class="row margin-top-20">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="btn btn-default" id="btn-guardar-linea-ajuste-orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
	</div>
</div>
<script>
$( function()"""),format.raw/*98.14*/("""{"""),format.raw/*98.15*/("""
	if($("#producto").length)"""),format.raw/*99.27*/("""{"""),format.raw/*99.28*/("""
		var options = """),format.raw/*100.17*/("""{"""),format.raw/*100.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*106.30*/("""{"""),format.raw/*106.31*/(""" 
											$("#producto_id").val(obj.id); 
										 """),format.raw/*108.12*/("""}"""),format.raw/*108.13*/("""
			"""),format.raw/*109.4*/("""}"""),format.raw/*109.5*/(""";
		var as_json = new bsn.AutoSuggest('producto', options);
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/("""
		
	if($("#cuentaAnalitica").length)"""),format.raw/*113.34*/("""{"""),format.raw/*113.35*/("""
		var options = """),format.raw/*114.17*/("""{"""),format.raw/*114.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*120.30*/("""{"""),format.raw/*120.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*122.12*/("""}"""),format.raw/*122.13*/("""
			"""),format.raw/*123.4*/("""}"""),format.raw/*123.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*125.2*/("""}"""),format.raw/*125.3*/("""
"""),format.raw/*126.1*/("""}"""),format.raw/*126.2*/(""");
</script>
"""),_display_(Seq[Any](/*128.2*/flash()/*128.9*/.clear())))}
    }
    
    def render(lineaForm:Form[OrdenLineaAjuste],linea:OrdenLineaAjuste): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[OrdenLineaAjuste],OrdenLineaAjuste) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasAjustesOrdenes/formLineaAjuste.scala.html
                    HASH: cfe9fc478db5d1a906a7482d43cd0251f1dc094b
                    MATRIX: 846->1|1007->80|1039->104|1113->59|1142->148|1182->154|1194->159|1240->184|1293->210|1321->211|1413->275|1442->276|1489->295|1518->296|1610->361|1638->362|1712->401|1785->452|1946->577|1997->619|2037->621|2066->632|2079->637|2118->638|2164->651|2212->664|2346->775|2387->781|2487->859|2639->974|2660->985|2732->1034|2967->1234|3000->1258|3019->1268|3067->1278|3133->1308|3147->1313|3177->1321|3219->1332|3396->1473|3442->1510|3482->1512|3511->1523|3524->1528|3563->1529|3608->1542|3656->1555|3751->1628|3797->1639|3825->1658|3844->1668|3892->1678|3954->1704|3968->1709|3998->1717|4037->1724|4213->1864|4261->1903|4301->1905|4330->1916|4343->1921|4382->1922|4427->1935|4470->1943|4569->2020|4610->2026|4640->2047|4659->2057|4707->2067|4769->2093|4783->2098|4813->2106|4852->2113|5006->2231|5052->2268|5092->2270|5121->2281|5134->2286|5173->2287|5218->2300|5261->2308|5426->2450|5467->2456|5495->2475|5514->2485|5562->2495|5624->2521|5638->2526|5668->2534|5708->2542|5892->2690|5951->2740|5991->2742|6020->2753|6033->2758|6072->2759|6118->2772|6161->2780|6282->2878|6323->2884|6438->2977|6665->3168|6685->3179|6769->3241|7082->3519|7123->3551|7142->3561|7190->3571|7252->3597|7266->3602|7296->3610|7337->3618|7527->3772|7571->3807|7611->3809|7653->3819|7696->3827|7787->3896|7828->3902|7854->3919|7873->3929|7921->3939|7983->3965|7997->3970|8027->3978|8066->3985|8501->4392|8530->4393|8586->4421|8615->4422|8662->4440|8692->4441|8862->4582|8892->4583|8979->4641|9009->4642|9042->4647|9071->4648|9162->4711|9191->4712|9259->4751|9289->4752|9336->4770|9366->4771|9556->4932|9586->4933|9680->4998|9710->4999|9743->5004|9772->5005|9870->5075|9899->5076|9929->5078|9958->5079|10010->5095|10026->5102
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|38->10|38->10|38->10|38->10|40->12|40->12|44->16|44->16|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|50->22|50->22|51->23|51->23|51->23|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|73->45|73->45|73->45|73->45|73->45|73->45|73->45|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|96->68|96->68|96->68|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|111->83|111->83|111->83|111->83|112->84|112->84|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|126->98|126->98|127->99|127->99|128->100|128->100|134->106|134->106|136->108|136->108|137->109|137->109|139->111|139->111|141->113|141->113|142->114|142->114|148->120|148->120|150->122|150->122|151->123|151->123|153->125|153->125|154->126|154->126|156->128|156->128
                    -- GENERATED --
                */
            