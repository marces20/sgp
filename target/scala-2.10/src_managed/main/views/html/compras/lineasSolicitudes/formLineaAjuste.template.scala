
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
object formLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SolicitudLineaAjuste],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[SolicitudLineaAjuste]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""

"""),_display_(Seq[Any](/*7.2*/inputText(lineaForm("solicitud_id"), 'type -> "hidden"))),format.raw/*7.57*/("""
	<div class="row">
		<div class="col-sm-5">
			<label for="producto_nombre" class="control-label">Producto</label>
			<div class="input-group """),_display_(Seq[Any](/*11.29*/if(lineaForm.error("producto_id") != null)/*11.71*/ {_display_(Seq[Any](format.raw/*11.73*/("""has-error""")))}/*11.84*/else/*11.89*/{_display_(Seq[Any](format.raw/*11.90*/("""has-required""")))})),format.raw/*11.103*/("""">
				"""),_display_(Seq[Any](/*12.6*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*12.117*/("""
				"""),_display_(Seq[Any](/*13.6*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*13.84*/("""
				<span class="input-group-addon"><a href="#" id="searchProducto" 
															data-title="Selección de producto" 
															data-url=""""),_display_(Seq[Any](/*16.27*/controllers/*16.38*/.compras.routes.ProductosController.modalBuscar())),format.raw/*16.87*/("""" 
															data-height="650" 
															data-width="700" 
															data-listen="modal.seleccion.producto.simple" 
															data-label="#producto" data-field="#producto_id">
															<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*23.5*/lineaForm("producto_id")/*23.29*/.error.map/*23.39*/{ error =>_display_(Seq[Any](format.raw/*23.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*24.30*/error/*24.35*/.message)),format.raw/*24.43*/("""</div>
			""")))})),format.raw/*25.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(lineaForm.error("cantidad") != null)/*28.67*/ {_display_(Seq[Any](format.raw/*28.69*/("""has-error""")))}/*28.80*/else/*28.85*/{_display_(Seq[Any](format.raw/*28.86*/("""has-required""")))})),format.raw/*28.99*/("""">
				<label for="cantidad" class="control-label">Cantidad</label>
				"""),_display_(Seq[Any](/*30.6*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*30.83*/("""
				"""),_display_(Seq[Any](/*31.6*/lineaForm("cantidad")/*31.27*/.error.map/*31.37*/{ error =>_display_(Seq[Any](format.raw/*31.47*/(""" <div class="text-error">"""),_display_(Seq[Any](/*31.73*/error/*31.78*/.message)),format.raw/*31.86*/("""</div>""")))})),format.raw/*31.93*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*35.28*/if(lineaForm.error("precio_estimado") != null)/*35.74*/ {_display_(Seq[Any](format.raw/*35.76*/("""has-error""")))}/*35.87*/else/*35.92*/{_display_(Seq[Any](format.raw/*35.93*/("""has-required""")))})),format.raw/*35.106*/("""">
				<label class="control-label">Precio
				"""),_display_(Seq[Any](/*37.6*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precioEstimado"))),format.raw/*37.87*/("""
				</label>
				"""),_display_(Seq[Any](/*39.6*/lineaForm("precio")/*39.25*/.error.map/*39.35*/{ error =>_display_(Seq[Any](format.raw/*39.45*/(""" <div class="text-error">"""),_display_(Seq[Any](/*39.71*/error/*39.76*/.message)),format.raw/*39.84*/("""</div>""")))})),format.raw/*39.91*/("""
			</div>
		</div>
		
	</div>

<div class="row">
	<div class="col-sm-9">
		<label for="cuenta_nombre" class="control-label">Cuenta analítica a ajustar</label>
		<div class="input-group """),_display_(Seq[Any](/*48.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*48.78*/ {_display_(Seq[Any](format.raw/*48.80*/("""has-error""")))}/*48.91*/else/*48.96*/{_display_(Seq[Any](format.raw/*48.97*/("""has-required""")))})),format.raw/*48.110*/("""">
			"""),_display_(Seq[Any](/*49.5*/inputText(lineaForm("CuentaAnalitica.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "cuenta_nombre_ajuste"))),format.raw/*49.135*/("""
			"""),_display_(Seq[Any](/*50.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuenta_analitica_id_ajuste"))),format.raw/*50.106*/("""
			<span class="input-group-addon">
			<a href="#" id="searchCuentaAnalitica" 
						data-title="Selección de cuenta analítica" 
						data-url=""""),_display_(Seq[Any](/*54.18*/controllers/*54.29*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*54.91*/("""" 
						data-height="650" 
						data-width="700" 
						data-listen="modal.seleccion.cuentaAnalitica.simple" 
						data-label="#cuenta_nombre_ajuste" 
						data-field="#cuenta_analitica_id_ajuste"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
		"""),_display_(Seq[Any](/*61.4*/lineaForm("cuenta_analitica_id")/*61.36*/.error.map/*61.46*/{ error =>_display_(Seq[Any](format.raw/*61.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*62.29*/error/*62.34*/.message)),format.raw/*62.42*/("""</div>
		""")))})),format.raw/*63.4*/("""
	</div>
	
	<!-- <div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*67.27*/if(lineaForm.error("valor") != null)/*67.63*/ {_display_(Seq[Any](format.raw/*67.65*/("""has-error""")))}/*67.76*/else/*67.81*/{_display_(Seq[Any](format.raw/*67.82*/("""has-required""")))})),format.raw/*67.95*/("""">
			<label class="control-label">Valor a ajustar
			"""),_display_(Seq[Any](/*69.5*/inputText(lineaForm("valor"), 'class -> "form-control", 'id -> "valor"))),format.raw/*69.76*/("""
			</label>
			"""),_display_(Seq[Any](/*71.5*/lineaForm("valor")/*71.23*/.error.map/*71.33*/{ error =>_display_(Seq[Any](format.raw/*71.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*71.69*/error/*71.74*/.message)),format.raw/*71.82*/("""</div>""")))})),format.raw/*71.89*/("""
		</div>
	</div> -->
	
</div>

<div class="row">	
	<div class="col-sm-12">
		<div class="form-group">
			<label for="cantidad" class="control-label">Observación</label>
			"""),_display_(Seq[Any](/*81.5*/textarea(lineaForm("observacion"), 'class -> "form-control", 'id -> "cantidad", 'rows -> "3"))),format.raw/*81.98*/("""
			"""),_display_(Seq[Any](/*82.5*/lineaForm("observacion")/*82.29*/.error.map/*82.39*/{ error =>_display_(Seq[Any](format.raw/*82.49*/(""" <div class="text-error">"""),_display_(Seq[Any](/*82.75*/error/*82.80*/.message)),format.raw/*82.88*/("""</div>""")))})),format.raw/*82.95*/("""
		</div>
	</div>

</div>

<br />
<p class="help-block">
<b>Nota:</b> El separador de decimales del campo valor es el símbolo ",".<br />
No lleva separador de millar, pero puede presionar la tecla "punto" que automáticamente se transforma en "coma" para mejor manejo del teclado numérico.
</p>
 
<script>
$(function()"""),format.raw/*95.13*/("""{"""),format.raw/*95.14*/("""
	$("#valor").numeric_input("""),format.raw/*96.28*/("""{"""),format.raw/*96.29*/("""allowNegative: true"""),format.raw/*96.48*/("""}"""),format.raw/*96.49*/(""");
	$('#searchCuentaAnalitica,#searchProducto').modalSearch();
	if($("#producto").length)"""),format.raw/*98.27*/("""{"""),format.raw/*98.28*/("""
		var options = """),format.raw/*99.17*/("""{"""),format.raw/*99.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*105.30*/("""{"""),format.raw/*105.31*/(""" 
											$("#producto_id").val(obj.id); 
										 """),format.raw/*107.12*/("""}"""),format.raw/*107.13*/("""
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/(""";
		var as_json = new bsn.AutoSuggest('producto', options);
	"""),format.raw/*110.2*/("""}"""),format.raw/*110.3*/("""
	if($("#cuenta_nombre_ajuste").length)"""),format.raw/*111.39*/("""{"""),format.raw/*111.40*/("""
		var options = """),format.raw/*112.17*/("""{"""),format.raw/*112.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:26,
				cache:false,
				callback: function (obj) """),format.raw/*119.30*/("""{"""),format.raw/*119.31*/(""" 
											$("#cuenta_analitica_id_ajuste").val(obj.id); 
										 """),format.raw/*121.12*/("""}"""),format.raw/*121.13*/("""
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_nombre_ajuste', options);
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/("""
"""),format.raw/*125.1*/("""}"""),format.raw/*125.2*/(""");
</script>"""))}
    }
    
    def render(lineaForm:Form[SolicitudLineaAjuste]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[SolicitudLineaAjuste]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/formLineaAjuste.scala.html
                    HASH: 231da30a8efd25266b5f7961cf803c1e32617862
                    MATRIX: 830->1|971->59|1003->83|1077->40|1105->127|1143->131|1155->136|1201->161|1238->164|1314->219|1494->363|1545->405|1585->407|1614->418|1627->423|1666->424|1712->437|1755->445|1889->556|1930->562|2030->640|2213->787|2233->798|2304->847|2619->1127|2652->1151|2671->1161|2719->1171|2785->1201|2799->1206|2829->1214|2871->1225|2969->1287|3017->1326|3057->1328|3086->1339|3099->1344|3138->1345|3183->1358|3291->1431|3390->1508|3431->1514|3461->1535|3480->1545|3528->1555|3590->1581|3604->1586|3634->1594|3673->1601|3781->1673|3836->1719|3876->1721|3905->1732|3918->1737|3957->1738|4003->1751|4086->1799|4189->1880|4243->1899|4271->1918|4290->1928|4338->1938|4400->1964|4414->1969|4444->1977|4483->1984|4706->2171|4765->2221|4805->2223|4834->2234|4847->2239|4886->2240|4932->2253|4974->2260|5127->2390|5167->2395|5291->2496|5474->2643|5494->2654|5578->2716|5880->2983|5921->3015|5940->3025|5988->3035|6053->3064|6067->3069|6097->3077|6138->3087|6240->3153|6285->3189|6325->3191|6354->3202|6367->3207|6406->3208|6451->3221|6541->3276|6634->3347|6686->3364|6713->3382|6732->3392|6780->3402|6842->3428|6856->3433|6886->3441|6925->3448|7134->3622|7249->3715|7289->3720|7322->3744|7341->3754|7389->3764|7451->3790|7465->3795|7495->3803|7534->3810|7879->4127|7908->4128|7964->4156|7993->4157|8040->4176|8069->4177|8186->4266|8215->4267|8260->4284|8289->4285|8453->4420|8483->4421|8568->4477|8598->4478|8630->4482|8659->4483|8748->4544|8777->4545|8845->4584|8875->4585|8921->4602|8951->4603|9153->4776|9183->4777|9283->4848|9313->4849|9345->4853|9374->4854|9475->4927|9504->4928|9533->4929|9562->4930
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|41->13|41->13|44->16|44->16|44->16|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|76->48|76->48|76->48|76->48|76->48|76->48|76->48|77->49|77->49|78->50|78->50|82->54|82->54|82->54|89->61|89->61|89->61|89->61|90->62|90->62|90->62|91->63|95->67|95->67|95->67|95->67|95->67|95->67|95->67|97->69|97->69|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|123->95|123->95|124->96|124->96|124->96|124->96|126->98|126->98|127->99|127->99|133->105|133->105|135->107|135->107|136->108|136->108|138->110|138->110|139->111|139->111|140->112|140->112|147->119|147->119|149->121|149->121|150->122|150->122|152->124|152->124|153->125|153->125
                    -- GENERATED --
                */
            