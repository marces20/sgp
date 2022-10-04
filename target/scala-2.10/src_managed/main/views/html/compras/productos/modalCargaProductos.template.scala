
package views.html.compras.productos

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
object modalCargaProductos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Producto],List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(productoForm: Form[Producto],productoDepositoArray:List[Integer] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""

"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.compras.routes.ProductosController.guardarProductoDesdeModal(),'id -> "formGuardarProductoDesdeModal")/*7.137*/ {_display_(Seq[Any](format.raw/*7.139*/("""
	
	<div class="row">
		<div class="col-sm-9">
			<div class="form-group """),_display_(Seq[Any](/*11.28*/if(productoForm.error("nombre") != null)/*11.68*/ {_display_(Seq[Any](format.raw/*11.70*/("""has-error""")))}/*11.80*/else/*11.84*/{_display_(Seq[Any](format.raw/*11.85*/("""has-required""")))})),format.raw/*11.98*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*13.6*/inputText(productoForm("nombre"), 'class -> "form-control"))),format.raw/*13.65*/("""
				"""),_display_(Seq[Any](/*14.6*/productoForm("nombre")/*14.28*/.error.map/*14.38*/{ error =>_display_(Seq[Any](format.raw/*14.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*15.31*/error/*15.36*/.message)),format.raw/*15.44*/("""</div>
				""")))})),format.raw/*16.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*22.28*/if(productoForm.error("categoria_id") != null)/*22.74*/ {_display_(Seq[Any](format.raw/*22.76*/("""has-error""")))}/*22.86*/else/*22.90*/{_display_(Seq[Any](format.raw/*22.91*/("""has-required""")))})),format.raw/*22.104*/("""">
				<label for="inputCategoria" class="control-label">Categor&iacute;a</label> 
				"""),_display_(Seq[Any](/*24.6*/inputText(productoForm("categoria.nombre"),'class -> "form-control"))),format.raw/*24.74*/("""
				"""),_display_(Seq[Any](/*25.6*/inputText(productoForm("categoria_id"),'hidden -> "hidden"))),format.raw/*25.65*/("""
				"""),_display_(Seq[Any](/*26.6*/productoForm("categoria_id")/*26.34*/.error.map/*26.44*/{ error =>_display_(Seq[Any](format.raw/*26.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*27.31*/error/*27.36*/.message)),format.raw/*27.44*/("""</div>
				""")))})),format.raw/*28.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*32.28*/if(productoForm.error("tipo_producto_id") != null)/*32.78*/ {_display_(Seq[Any](format.raw/*32.80*/("""has-error""")))}/*32.90*/else/*32.94*/{_display_(Seq[Any](format.raw/*32.95*/("""has-required""")))})),format.raw/*32.108*/("""">
				<label for="inputTipoProducto" class="control-label">Tipo Producto</label> 
				"""),_display_(Seq[Any](/*34.6*/inputText(productoForm("tipo_producto.nombre"),'class -> "form-control"))),format.raw/*34.78*/("""
				"""),_display_(Seq[Any](/*35.6*/inputText(productoForm("tipo_producto_id"),'hidden -> "hidden"))),format.raw/*35.69*/("""
				"""),_display_(Seq[Any](/*36.6*/productoForm("tipo_producto_id")/*36.38*/.error.map/*36.48*/{ error =>_display_(Seq[Any](format.raw/*36.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*37.31*/error/*37.36*/.message)),format.raw/*37.44*/("""</div>
				""")))})),format.raw/*38.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*42.28*/if(productoForm.error("udm.id") != null)/*42.68*/ {_display_(Seq[Any](format.raw/*42.70*/("""has-error""")))}/*42.80*/else/*42.84*/{_display_(Seq[Any](format.raw/*42.85*/("""has-required""")))})),format.raw/*42.98*/("""">
				<label for="inputUdm" class="control-label">Udm</label> 
				"""),_display_(Seq[Any](/*44.6*/inputText(productoForm("udm.nombre"),'class -> "form-control"))),format.raw/*44.68*/("""
				"""),_display_(Seq[Any](/*45.6*/inputText(productoForm("udm_id"),'hidden -> "hidden"))),format.raw/*45.59*/("""
				"""),_display_(Seq[Any](/*46.6*/productoForm("udm_id")/*46.28*/.error.map/*46.38*/{ error =>_display_(Seq[Any](format.raw/*46.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*47.31*/error/*47.36*/.message)),format.raw/*47.44*/("""</div>
				""")))})),format.raw/*48.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="50">#</th>
						<th width="100">Deposito</th>
					
					</tr>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*63.7*/for( d <- Deposito.find.all()) yield /*63.37*/{_display_(Seq[Any](format.raw/*63.38*/("""
						
						<tr>
							<td>
								<input type="checkbox" class="permiso" name="productoDeposito[]" 
								"""),_display_(Seq[Any](/*68.10*/if(productoDepositoArray != null)/*68.43*/{_display_(Seq[Any](format.raw/*68.44*/(""" 
								"""),_display_(Seq[Any](/*69.10*/if(productoDepositoArray.contains(d.id.intValue()))/*69.61*/ {_display_(Seq[Any](format.raw/*69.63*/("""checked""")))}))))})),format.raw/*69.72*/(""" 
								value=""""),_display_(Seq[Any](/*70.17*/d/*70.18*/.id)),format.raw/*70.21*/("""" />
								
							</td>
							<td>"""),_display_(Seq[Any](/*73.13*/d/*73.14*/.nombre)),format.raw/*73.21*/("""</td>
						</tr>
					""")))})),format.raw/*75.7*/("""
				</tbody>	
			</table>
		</div>
	</div>
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      """),_display_(Seq[Any](/*82.9*/inputText(productoForm("precio_coste"),'hidden->"hidden"))),format.raw/*82.66*/(""" 
	      <button type="submit" class="btn btn-sistema" id="btn-guardar-producto-modal">Guardar</button>
	    </div>
	</div>

<script>
$(document).off( "submit", "#formGuardarProductoDesdeModal" )
$(document).on("submit", '#formGuardarProductoDesdeModal', function()"""),format.raw/*89.70*/("""{"""),format.raw/*89.71*/("""
	var form = $(this);
	var url = form.attr('action');
	var data = form.serialize();
	var submit = form.find("button[type='submit']");
	submit.replaceWith(getLoading());
	
	$("#btn-guardar-producto-modal").attr("disabled","disabled");
	$.post(url, data, function(data)"""),format.raw/*97.34*/("""{"""),format.raw/*97.35*/("""
	
		if(data.success) """),format.raw/*99.20*/("""{"""),format.raw/*99.21*/("""
			$("#producto_id").val(data.idProducto);
			$("#producto").val(data.nombre);
			dialogoProductoCarga.dialog( "destroy" );
			form.replaceWith(data.html);
		"""),format.raw/*104.3*/("""}"""),format.raw/*104.4*/(""" else """),format.raw/*104.10*/("""{"""),format.raw/*104.11*/("""
			form.replaceWith(data);
		"""),format.raw/*106.3*/("""}"""),format.raw/*106.4*/("""
	"""),format.raw/*107.2*/("""}"""),format.raw/*107.3*/(""");
	
	return false;
"""),format.raw/*110.1*/("""}"""),format.raw/*110.2*/(""");
$( function()"""),format.raw/*111.14*/("""{"""),format.raw/*111.15*/("""
	if($("#categoria_nombre").length)"""),format.raw/*112.35*/("""{"""),format.raw/*112.36*/("""
		var options = """),format.raw/*113.17*/("""{"""),format.raw/*113.18*/("""
				script:"/suggestCategoria/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*119.30*/("""{"""),format.raw/*119.31*/(""" 
											$("#categoria_nombre").next().val(obj.id); 
										 """),format.raw/*121.12*/("""}"""),format.raw/*121.13*/("""
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/(""";
		var as_json = new bsn.AutoSuggest('categoria_nombre', options);
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/("""
	if($("#tipo_producto_nombre").length)"""),format.raw/*125.39*/("""{"""),format.raw/*125.40*/("""
		var options = """),format.raw/*126.17*/("""{"""),format.raw/*126.18*/("""
				script:"/suggestTipoProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*132.30*/("""{"""),format.raw/*132.31*/(""" 
											$("#tipo_producto_nombre").next().val(obj.id); 
										 """),format.raw/*134.12*/("""}"""),format.raw/*134.13*/("""
			"""),format.raw/*135.4*/("""}"""),format.raw/*135.5*/(""";
		var as_json = new bsn.AutoSuggest('tipo_producto_nombre', options);
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/("""
	if($("#udm_nombre").length)"""),format.raw/*138.29*/("""{"""),format.raw/*138.30*/("""
		var options = """),format.raw/*139.17*/("""{"""),format.raw/*139.18*/("""
				script:"/suggestUdm/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*145.30*/("""{"""),format.raw/*145.31*/(""" 
											$("#udm_nombre").next().val(obj.id); 
										 """),format.raw/*147.12*/("""}"""),format.raw/*147.13*/("""
			"""),format.raw/*148.4*/("""}"""),format.raw/*148.5*/(""";
		var as_json = new bsn.AutoSuggest('udm_nombre', options);
	"""),format.raw/*150.2*/("""}"""),format.raw/*150.3*/("""
"""),format.raw/*151.1*/("""}"""),format.raw/*151.2*/(""");	 
</script>
""")))})),format.raw/*153.2*/("""	"""))}
    }
    
    def render(productoForm:Form[Producto],productoDepositoArray:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(productoForm,productoDepositoArray)
    
    def f:((Form[Producto],List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (productoForm,productoDepositoArray) => apply(productoForm,productoDepositoArray)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/modalCargaProductos.scala.html
                    HASH: 9ccb1659dbcc9e8c350d2637d1cdd399ece28a1d
                    MATRIX: 828->1|1003->93|1035->117|1109->74|1137->161|1174->164|1186->169|1232->194|1269->197|1282->203|1420->332|1460->334|1570->408|1619->448|1659->450|1688->460|1701->464|1740->465|1785->478|1895->553|1976->612|2017->618|2048->640|2067->650|2115->660|2182->691|2196->696|2226->704|2269->716|2404->815|2459->861|2499->863|2528->873|2541->877|2580->878|2626->891|2749->979|2839->1047|2880->1053|2961->1112|3002->1118|3039->1146|3058->1156|3106->1166|3173->1197|3187->1202|3217->1210|3260->1222|3368->1294|3427->1344|3467->1346|3496->1356|3509->1360|3548->1361|3594->1374|3717->1462|3811->1534|3852->1540|3937->1603|3978->1609|4019->1641|4038->1651|4086->1661|4153->1692|4167->1697|4197->1705|4240->1717|4348->1789|4397->1829|4437->1831|4466->1841|4479->1845|4518->1846|4563->1859|4667->1928|4751->1990|4792->1996|4867->2049|4908->2055|4939->2077|4958->2087|5006->2097|5073->2128|5087->2133|5117->2141|5160->2153|5455->2413|5501->2443|5540->2444|5690->2558|5732->2591|5771->2592|5818->2603|5878->2654|5918->2656|5963->2665|6017->2683|6027->2684|6052->2687|6127->2726|6137->2727|6166->2734|6221->2758|6384->2886|6463->2943|6756->3208|6785->3209|7080->3476|7109->3477|7159->3499|7188->3500|7375->3659|7404->3660|7439->3666|7469->3667|7527->3697|7556->3698|7586->3700|7615->3701|7663->3721|7692->3722|7737->3738|7767->3739|7831->3774|7861->3775|7907->3792|7937->3793|8102->3929|8132->3930|8229->3998|8259->3999|8291->4003|8320->4004|8417->4073|8446->4074|8514->4113|8544->4114|8590->4131|8620->4132|8788->4271|8818->4272|8919->4344|8949->4345|8981->4349|9010->4350|9111->4423|9140->4424|9198->4453|9228->4454|9274->4471|9304->4472|9463->4602|9493->4603|9584->4665|9614->4666|9646->4670|9675->4671|9766->4734|9795->4735|9824->4736|9853->4737|9901->4753
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|35->7|39->11|39->11|39->11|39->11|39->11|39->11|39->11|41->13|41->13|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|55->27|56->28|60->32|60->32|60->32|60->32|60->32|60->32|60->32|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|73->45|73->45|74->46|74->46|74->46|74->46|75->47|75->47|75->47|76->48|91->63|91->63|91->63|96->68|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|101->73|101->73|101->73|103->75|110->82|110->82|117->89|117->89|125->97|125->97|127->99|127->99|132->104|132->104|132->104|132->104|134->106|134->106|135->107|135->107|138->110|138->110|139->111|139->111|140->112|140->112|141->113|141->113|147->119|147->119|149->121|149->121|150->122|150->122|152->124|152->124|153->125|153->125|154->126|154->126|160->132|160->132|162->134|162->134|163->135|163->135|165->137|165->137|166->138|166->138|167->139|167->139|173->145|173->145|175->147|175->147|176->148|176->148|178->150|178->150|179->151|179->151|181->153
                    -- GENERATED --
                */
            