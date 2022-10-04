
package views.html.compras.lineasPedidosFondos

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
object formLineaPedido extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PedidoFondoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[PedidoFondoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$("#monto").numeric_input("""),format.raw/*14.28*/("""{"""),format.raw/*14.29*/("""allowNegative: true"""),format.raw/*14.48*/("""}"""),format.raw/*14.49*/(""");
	$('#searchExpedienteModal,#searchProveedor').modalSearch();
"""),format.raw/*16.1*/("""}"""),format.raw/*16.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*20.3*/inputText(lineaForm("pedido_fondo_id"), 'type -> "hidden"))),format.raw/*20.61*/("""
	
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Monto</label>
		<div class="form-group """),_display_(Seq[Any](/*24.27*/if(lineaForm.error("monto") != null)/*24.63*/ {_display_(Seq[Any](format.raw/*24.65*/("""has-error""")))}/*24.76*/else/*24.81*/{_display_(Seq[Any](format.raw/*24.82*/("""has-required""")))})),format.raw/*24.95*/("""">
			"""),_display_(Seq[Any](/*25.5*/inputText(lineaForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*25.76*/("""
			"""),_display_(Seq[Any](/*26.5*/lineaForm("monto")/*26.23*/.error.map/*26.33*/{ error =>_display_(Seq[Any](format.raw/*26.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*26.69*/error/*26.74*/.message)),format.raw/*26.82*/("""</div>""")))})),format.raw/*26.89*/("""
		</div>
	</div>
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Expediente</label>
		<div class="input-group """),_display_(Seq[Any](/*32.28*/if(lineaForm.error("expediente_id") != null)/*32.72*/ {_display_(Seq[Any](format.raw/*32.74*/("""has-error""")))}/*32.85*/else/*32.90*/{_display_(Seq[Any](format.raw/*32.91*/("""has-required""")))})),format.raw/*32.104*/("""">
			"""),_display_(Seq[Any](/*33.5*/inputText(lineaForm("expediente.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "expediente_modal"))),format.raw/*33.126*/("""
			"""),_display_(Seq[Any](/*34.5*/inputText(lineaForm("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id_modal"))),format.raw/*34.93*/("""
			<span class="input-group-addon">
				<a href="#" id="searchExpedienteModal" 
							data-title="Selección de expediente" 
							data-url=""""),_display_(Seq[Any](/*38.19*/controllers/*38.30*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*38.84*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.expediente.simple" 
							data-label="#expediente_modal" 
							data-field="#expediente_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*48.4*/lineaForm("expediente_id")/*48.30*/.error.map/*48.40*/{ error =>_display_(Seq[Any](format.raw/*48.50*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*49.29*/error/*49.34*/.message)),format.raw/*49.42*/("""</div>
		""")))})),format.raw/*50.4*/("""
	</div>
	
</div>

<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Proveedoor</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*59.5*/inputText(lineaForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*59.91*/("""
			"""),_display_(Seq[Any](/*60.5*/inputText(lineaForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*60.85*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchProveedor" 
				   class="searchModal"
				   data-title="Selección de Proveedor" 
				   data-url=""""),_display_(Seq[Any](/*66.19*/controllers/*66.30*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*66.81*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.proveedor.simple" 
				   data-label="#proveedor" data-field="#proveedor_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
	</div>
	<div class="col-sm-6">
		<label class="control-label">Concepto</label>
		<div class="form-group """),_display_(Seq[Any](/*78.27*/if(lineaForm.error("concepto") != null)/*78.66*/ {_display_(Seq[Any](format.raw/*78.68*/("""has-error""")))}/*78.79*/else/*78.84*/{_display_(Seq[Any](format.raw/*78.85*/("""has-required""")))})),format.raw/*78.98*/("""">
			"""),_display_(Seq[Any](/*79.5*/inputText(lineaForm("concepto"), 'class -> "form-control", 'id -> "concepto"))),format.raw/*79.82*/("""
			"""),_display_(Seq[Any](/*80.5*/lineaForm("concepto")/*80.26*/.error.map/*80.36*/{ error =>_display_(Seq[Any](format.raw/*80.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*80.72*/error/*80.77*/.message)),format.raw/*80.85*/("""</div>""")))})),format.raw/*80.92*/("""
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
$( function()"""),format.raw/*94.14*/("""{"""),format.raw/*94.15*/("""
	if($("#expediente_modal").length)"""),format.raw/*95.35*/("""{"""),format.raw/*95.36*/("""
		var options = """),format.raw/*96.17*/("""{"""),format.raw/*96.18*/("""
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*102.30*/("""{"""),format.raw/*102.31*/(""" 
											$("#expediente_id_modal").val(obj.id); 
										 """),format.raw/*104.12*/("""}"""),format.raw/*104.13*/("""
			"""),format.raw/*105.4*/("""}"""),format.raw/*105.5*/(""";
		var as_json = new bsn.AutoSuggest('expediente_modal', options);
	"""),format.raw/*107.2*/("""}"""),format.raw/*107.3*/("""
	
	if($("#proveedor").length)"""),format.raw/*109.28*/("""{"""),format.raw/*109.29*/("""
		var options = """),format.raw/*110.17*/("""{"""),format.raw/*110.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*116.30*/("""{"""),format.raw/*116.31*/(""" 
											$("#proveedor_id").val(obj.id); 
										 """),format.raw/*118.12*/("""}"""),format.raw/*118.13*/("""
			"""),format.raw/*119.4*/("""}"""),format.raw/*119.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor', options);
	"""),format.raw/*121.2*/("""}"""),format.raw/*121.3*/("""
"""),format.raw/*122.1*/("""}"""),format.raw/*122.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[PedidoFondoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[PedidoFondoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasPedidosFondos/formLineaPedido.scala.html
                    HASH: 51aa028659ba6ed19c435ca98617944c62e6c099
                    MATRIX: 828->1|966->57|998->81|1072->36|1101->125|1155->144|1169->150|1239->199|1312->238|1350->268|1389->270|1512->358|1525->363|1559->376|1602->388|1654->412|1683->413|1740->442|1769->443|1816->462|1845->463|1938->529|1966->530|2040->569|2120->627|2273->744|2318->780|2358->782|2387->793|2400->798|2439->799|2484->812|2527->820|2620->891|2661->897|2688->915|2707->925|2755->935|2817->961|2831->966|2861->974|2900->981|3085->1130|3138->1174|3178->1176|3207->1187|3220->1192|3259->1193|3305->1206|3348->1214|3492->1335|3533->1341|3643->1429|3827->1577|3847->1588|3923->1642|4241->1925|4276->1951|4295->1961|4343->1971|4409->2001|4423->2006|4453->2014|4495->2025|4695->2190|4803->2276|4844->2282|4946->2362|5160->2540|5180->2551|5253->2602|5655->2968|5703->3007|5743->3009|5772->3020|5785->3025|5824->3026|5869->3039|5912->3047|6011->3124|6052->3130|6082->3151|6101->3161|6149->3171|6211->3197|6225->3202|6255->3210|6294->3217|6749->3644|6778->3645|6842->3681|6871->3682|6917->3700|6946->3701|7118->3844|7148->3845|7243->3911|7273->3912|7306->3917|7335->3918|7434->3989|7463->3990|7524->4022|7554->4023|7601->4041|7631->4042|7802->4184|7832->4185|7920->4244|7950->4245|7983->4250|8012->4251|8104->4315|8133->4316|8163->4318|8192->4319
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|42->14|42->14|42->14|42->14|44->16|44->16|48->20|48->20|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|60->32|60->32|60->32|60->32|60->32|60->32|60->32|61->33|61->33|62->34|62->34|66->38|66->38|66->38|76->48|76->48|76->48|76->48|77->49|77->49|77->49|78->50|87->59|87->59|88->60|88->60|94->66|94->66|94->66|106->78|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|122->94|122->94|123->95|123->95|124->96|124->96|130->102|130->102|132->104|132->104|133->105|133->105|135->107|135->107|137->109|137->109|138->110|138->110|144->116|144->116|146->118|146->118|147->119|147->119|149->121|149->121|150->122|150->122
                    -- GENERATED --
                */
            