
package views.html.compras.lineasSolicitudes

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[SolicitudLinea],Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[SolicitudLinea],s:Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

 <div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("solicitud_id"), 'type -> "hidden"))),format.raw/*12.58*/("""

	<div class="col-sm-5">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*16.28*/if(lineaForm.error("producto_id") != null)/*16.70*/ {_display_(Seq[Any](format.raw/*16.72*/("""has-error""")))}/*16.83*/else/*16.88*/{_display_(Seq[Any](format.raw/*16.89*/("""has-required""")))})),format.raw/*16.102*/("""">
			"""),_display_(Seq[Any](/*17.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "productoSolicitud"))),format.raw/*17.125*/("""
			"""),_display_(Seq[Any](/*18.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_solicitud"))),format.raw/*18.93*/("""
			<span class="input-group-addon">
											<a href="#" id="searchProducto" 
											data-title="Selección de producto" 
											data-url=""""),_display_(Seq[Any](/*22.23*/controllers/*22.34*/.compras.routes.ProductosController.modalBuscarSolicitudes(s.id))),format.raw/*22.98*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.producto.simple" 
											data-label="#productoSolicitud" 
											data-field="#producto_id_solicitud">
											<i class="glyphicon glyphicon-search"></i></a></span>
														
			<span class="input-group-addon">
				<a href="#" id="searchProductoCarga" 
				data-title="Selección de producto" 
				data-url=""""),_display_(Seq[Any](/*33.16*/controllers/*33.27*/.compras.routes.ProductosController.modalCarga())),format.raw/*33.75*/("""" 
				data-height="650" 
				data-width="700" 
				data-listen="modal.seleccion.producto.simple" 
				data-label="#producto" data-field="#producto_id">
				<i class="glyphicon glyphicon-plus"></i></a></span>											
				 
		</div>
		"""),_display_(Seq[Any](/*41.4*/lineaForm("producto_id")/*41.28*/.error.map/*41.38*/{ error =>_display_(Seq[Any](format.raw/*41.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*42.29*/error/*42.34*/.message)),format.raw/*42.42*/("""</div>
		""")))})),format.raw/*43.4*/("""
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*47.27*/if(lineaForm.error("precio_estimado") != null)/*47.73*/ {_display_(Seq[Any](format.raw/*47.75*/("""has-error""")))}/*47.86*/else/*47.91*/{_display_(Seq[Any](format.raw/*47.92*/("""has-required""")))})),format.raw/*47.105*/("""">
			<label class="control-label">Precio estimado
			"""),_display_(Seq[Any](/*49.5*/inputText(lineaForm("precio_estimado"), 'class -> "form-control", 'id -> "precioEstimado"))),format.raw/*49.95*/("""
			</label>
			"""),_display_(Seq[Any](/*51.5*/lineaForm("precio_estimado")/*51.33*/.error.map/*51.43*/{ error =>_display_(Seq[Any](format.raw/*51.53*/(""" <div class="text-error">"""),_display_(Seq[Any](/*51.79*/error/*51.84*/.message)),format.raw/*51.92*/("""</div>""")))})),format.raw/*51.99*/("""
		</div>
	</div>
	
</div>

<div class="row">	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*59.27*/if(lineaForm.error("cantidad") != null)/*59.66*/ {_display_(Seq[Any](format.raw/*59.68*/("""has-error""")))}/*59.79*/else/*59.84*/{_display_(Seq[Any](format.raw/*59.85*/("""has-required""")))})),format.raw/*59.98*/("""">
			<label for="cantidad" class="control-label">Cantidad</label>
			"""),_display_(Seq[Any](/*61.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*61.82*/("""
			"""),_display_(Seq[Any](/*62.5*/lineaForm("cantidad")/*62.26*/.error.map/*62.36*/{ error =>_display_(Seq[Any](format.raw/*62.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*62.72*/error/*62.77*/.message)),format.raw/*62.85*/("""</div>""")))})),format.raw/*62.92*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*67.27*/if(lineaForm.error("udm_id") != null)/*67.64*/ {_display_(Seq[Any](format.raw/*67.66*/("""has-error""")))}/*67.77*/else/*67.82*/{_display_(Seq[Any](format.raw/*67.83*/("""has-required""")))})),format.raw/*67.96*/("""">
			<label class="control-label">UDM
			"""),_display_(Seq[Any](/*69.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*69.147*/("""
			</label>
			"""),_display_(Seq[Any](/*71.5*/lineaForm("udm_id")/*71.24*/.error.map/*71.34*/{ error =>_display_(Seq[Any](format.raw/*71.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*71.70*/error/*71.75*/.message)),format.raw/*71.83*/("""</div> """)))})),format.raw/*71.91*/("""
		</div>
	</div>
	
	<div class="col-sm-5">
		<label for="cuenta_presupuestaria" class="control-label">Cuenta Presupuestaria</label>
		<div class="input-group """),_display_(Seq[Any](/*77.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*77.78*/ {_display_(Seq[Any](format.raw/*77.80*/("""has-error""")))}/*77.91*/else/*77.96*/{_display_(Seq[Any](format.raw/*77.97*/("""has-required""")))})),format.raw/*77.110*/("""">
			"""),_display_(Seq[Any](/*78.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuenta_analitica"))),format.raw/*78.104*/("""
			"""),_display_(Seq[Any](/*79.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuenta_analitica_id"))),format.raw/*79.99*/("""
			
			<span class="input-group-addon"><a href="#" 
												id="searchCuentaAnalitica" 
												data-title="Selección de cuenta analítica" 
												data-url=""""),_display_(Seq[Any](/*84.24*/controllers/*84.35*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*84.97*/("""" 
												data-height="650" 
												data-width="700" 
												data-listen="modal.seleccion.cuentaAnalitica.simple" 
												data-label="#cuenta_analitica" data-field="#cuenta_analitica_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
		"""),_display_(Seq[Any](/*90.4*/lineaForm("cuenta_analitica_id")/*90.36*/.error.map/*90.46*/{ error =>_display_(Seq[Any](format.raw/*90.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*91.29*/error/*91.34*/.message)),format.raw/*91.42*/("""</div>
		""")))})),format.raw/*92.4*/("""
	</div>
	
</div>	

<br />
<p class="help-block">
<b>Nota:</b> El separador de decimales de los campos cantidad y precio es el símbolo ",".<br />
No llevan separador de millar, pero puede presionar la tecla "punto" que automáticamente se transforma en "coma" para mejor manejo del teclado numérico.
</p>

<script>
$(function()"""),format.raw/*104.13*/("""{"""),format.raw/*104.14*/("""
	
	
	$('#searchProductoCarga').click( function() """),format.raw/*107.46*/("""{"""),format.raw/*107.47*/(""" 
		var url = $(this).attr("data-url");
		dialogoProductoCarga = crearDialogoGeneral(url);
		dialogoProductoCarga.dialog("""),format.raw/*110.31*/("""{"""),format.raw/*110.32*/("""title: "Cargar Producto",height:500"""),format.raw/*110.67*/("""}"""),format.raw/*110.68*/(""");
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/(""");
	
	$("#precioEstimado, #cantidad").numeric_input();
	$('#searchProducto,#searchCuentaAnalitica').modalSearch();
	
	if($("#productoSolicitud").length)"""),format.raw/*116.36*/("""{"""),format.raw/*116.37*/("""
		var idDeposito = $('#deposito_id').val();
		if($("#deposito_id").val().length > 0)"""),format.raw/*118.41*/("""{"""),format.raw/*118.42*/("""
			var options = """),format.raw/*119.18*/("""{"""),format.raw/*119.19*/("""
					script:"/suggestProductoSolicitud/"+idDeposito+"/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*125.31*/("""{"""),format.raw/*125.32*/(""" 
												$("#producto_id_solicitud").val(obj.id); 
											 """),format.raw/*127.13*/("""}"""),format.raw/*127.14*/("""
				"""),format.raw/*128.5*/("""}"""),format.raw/*128.6*/(""";
			var as_json = new bsn.AutoSuggest('productoSolicitud', options);
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/("""else"""),format.raw/*130.8*/("""{"""),format.raw/*130.9*/("""
			var options = """),format.raw/*131.18*/("""{"""),format.raw/*131.19*/("""
					script:"/suggestProducto/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*137.31*/("""{"""),format.raw/*137.32*/(""" 
												$("#producto_id_solicitud").val(obj.id); 
											 """),format.raw/*139.13*/("""}"""),format.raw/*139.14*/("""
				"""),format.raw/*140.5*/("""}"""),format.raw/*140.6*/(""";
			var as_json = new bsn.AutoSuggest('productoSolicitud', options);
		"""),format.raw/*142.3*/("""}"""),format.raw/*142.4*/("""
	"""),format.raw/*143.2*/("""}"""),format.raw/*143.3*/("""
	
	if($("#cuenta_analitica").length)"""),format.raw/*145.35*/("""{"""),format.raw/*145.36*/("""
		var options = """),format.raw/*146.17*/("""{"""),format.raw/*146.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*152.30*/("""{"""),format.raw/*152.31*/(""" 
											$("#cuenta_analitica_id").val(obj.id); 
										 """),format.raw/*154.12*/("""}"""),format.raw/*154.13*/("""
			"""),format.raw/*155.4*/("""}"""),format.raw/*155.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_analitica', options);
	"""),format.raw/*157.2*/("""}"""),format.raw/*157.3*/("""
"""),format.raw/*158.1*/("""}"""),format.raw/*158.2*/(""");
</script>"""))}
    }
    
    def render(lineaForm:Form[SolicitudLinea],s:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,s)
    
    def f:((Form[SolicitudLinea],Solicitud) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,s) => apply(lineaForm,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/formLineaProducto.scala.html
                    HASH: bf9097b94f64368fee288f617235a587772cfeb5
                    MATRIX: 836->1|984->67|1016->91|1090->46|1119->135|1159->141|1197->171|1236->173|1359->261|1372->266|1406->279|1448->291|1509->317|1586->372|1749->499|1800->541|1840->543|1869->554|1882->559|1921->560|1967->573|2010->581|2153->701|2194->707|2304->795|2494->949|2514->960|2600->1024|3072->1460|3092->1471|3162->1519|3443->1765|3476->1789|3495->1799|3543->1809|3609->1839|3623->1844|3653->1852|3695->1863|3796->1928|3851->1974|3891->1976|3920->1987|3933->1992|3972->1993|4018->2006|4110->2063|4222->2153|4276->2172|4313->2200|4332->2210|4380->2220|4442->2246|4456->2251|4486->2259|4525->2266|4666->2371|4714->2410|4754->2412|4783->2423|4796->2428|4835->2429|4880->2442|4988->2515|5087->2592|5128->2598|5158->2619|5177->2629|5225->2639|5287->2665|5301->2670|5331->2678|5370->2685|5480->2759|5526->2796|5566->2798|5595->2809|5608->2814|5647->2815|5692->2828|5772->2873|5937->3015|5991->3034|6019->3053|6038->3063|6086->3073|6148->3099|6162->3104|6192->3112|6232->3120|6434->3286|6493->3336|6533->3338|6562->3349|6575->3354|6614->3355|6660->3368|6703->3376|6825->3475|6866->3481|6982->3575|7195->3752|7215->3763|7299->3825|7613->4104|7654->4136|7673->4146|7721->4156|7787->4186|7801->4191|7831->4199|7873->4210|8240->4548|8270->4549|8352->4602|8382->4603|8535->4727|8565->4728|8629->4763|8659->4764|8692->4769|8721->4770|8907->4927|8937->4928|9053->5015|9083->5016|9131->5035|9161->5036|9361->5207|9391->5208|9490->5278|9520->5279|9554->5285|9583->5286|9685->5360|9714->5361|9746->5365|9775->5366|9823->5385|9853->5386|10029->5533|10059->5534|10158->5604|10188->5605|10222->5611|10251->5612|10353->5686|10382->5687|10413->5690|10442->5691|10510->5730|10540->5731|10587->5749|10617->5750|10807->5911|10837->5912|10932->5978|10962->5979|10995->5984|11024->5985|11123->6056|11152->6057|11182->6059|11211->6060
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|46->18|46->18|50->22|50->22|50->22|61->33|61->33|61->33|69->41|69->41|69->41|69->41|70->42|70->42|70->42|71->43|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|87->59|87->59|87->59|87->59|87->59|87->59|87->59|89->61|89->61|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|95->67|95->67|95->67|95->67|95->67|95->67|95->67|97->69|97->69|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|105->77|105->77|105->77|105->77|105->77|105->77|105->77|106->78|106->78|107->79|107->79|112->84|112->84|112->84|118->90|118->90|118->90|118->90|119->91|119->91|119->91|120->92|132->104|132->104|135->107|135->107|138->110|138->110|138->110|138->110|139->111|139->111|144->116|144->116|146->118|146->118|147->119|147->119|153->125|153->125|155->127|155->127|156->128|156->128|158->130|158->130|158->130|158->130|159->131|159->131|165->137|165->137|167->139|167->139|168->140|168->140|170->142|170->142|171->143|171->143|173->145|173->145|174->146|174->146|180->152|180->152|182->154|182->154|183->155|183->155|185->157|185->157|186->158|186->158
                    -- GENERATED --
                */
            