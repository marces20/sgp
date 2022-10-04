
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
object formProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Producto],Boolean,List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(productoForm: Form[Producto],editarNombre:Boolean,productoDepositoArray:List[Integer] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-9">
			"""),_display_(Seq[Any](/*7.5*/if(editarNombre)/*7.21*/{_display_(Seq[Any](format.raw/*7.22*/("""
			<div class="form-group """),_display_(Seq[Any](/*8.28*/if(productoForm.error("nombre") != null)/*8.68*/ {_display_(Seq[Any](format.raw/*8.70*/("""has-error""")))}/*8.80*/else/*8.84*/{_display_(Seq[Any](format.raw/*8.85*/("""has-required""")))})),format.raw/*8.98*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*10.6*/inputText(productoForm("nombre"), 'class -> "form-control"))),format.raw/*10.65*/("""
				"""),_display_(Seq[Any](/*11.6*/productoForm("nombre")/*11.28*/.error.map/*11.38*/{ error =>_display_(Seq[Any](format.raw/*11.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*12.31*/error/*12.36*/.message)),format.raw/*12.44*/("""</div>
				""")))})),format.raw/*13.6*/("""
			</div>
			""")))}/*15.5*/else/*15.9*/{_display_(Seq[Any](format.raw/*15.10*/("""
				"""),_display_(Seq[Any](/*16.6*/inputText(productoForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*16.89*/("""
			""")))})),format.raw/*17.5*/("""
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputReferencia" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*25.6*/inputText(productoForm("referencia"), 'class -> "form-control"))),format.raw/*25.69*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCodigoRismi" class="control-label">Codigo Rismi</label> 
				"""),_display_(Seq[Any](/*31.6*/inputText(productoForm("codigo_rismi"), 'class -> "form-control"))),format.raw/*31.71*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCodigoIps" class="control-label">Codigo IPS</label> 
				"""),_display_(Seq[Any](/*37.6*/inputText(productoForm("codigo_ips"), 'class -> "form-control"))),format.raw/*37.69*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*43.28*/if(productoForm.error("categoria_id") != null)/*43.74*/ {_display_(Seq[Any](format.raw/*43.76*/("""has-error""")))}/*43.86*/else/*43.90*/{_display_(Seq[Any](format.raw/*43.91*/("""has-required""")))})),format.raw/*43.104*/("""">
				<label for="inputCategoria" class="control-label">Categor&iacute;a</label> 
				"""),_display_(Seq[Any](/*45.6*/inputText(productoForm("categoria.nombre"),'class -> "form-control"))),format.raw/*45.74*/("""
				"""),_display_(Seq[Any](/*46.6*/inputText(productoForm("categoria_id"),'hidden -> "hidden"))),format.raw/*46.65*/("""
				"""),_display_(Seq[Any](/*47.6*/productoForm("categoria_id")/*47.34*/.error.map/*47.44*/{ error =>_display_(Seq[Any](format.raw/*47.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*48.31*/error/*48.36*/.message)),format.raw/*48.44*/("""</div>
				""")))})),format.raw/*49.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*53.28*/if(productoForm.error("tipo_producto_id") != null)/*53.78*/ {_display_(Seq[Any](format.raw/*53.80*/("""has-error""")))}/*53.90*/else/*53.94*/{_display_(Seq[Any](format.raw/*53.95*/("""has-required""")))})),format.raw/*53.108*/("""">
				<label for="inputTipoProducto" class="control-label">Tipo Producto</label> 
				"""),_display_(Seq[Any](/*55.6*/inputText(productoForm("tipo_producto.nombre"),'class -> "form-control"))),format.raw/*55.78*/("""
				"""),_display_(Seq[Any](/*56.6*/inputText(productoForm("tipo_producto_id"),'hidden -> "hidden"))),format.raw/*56.69*/("""
				"""),_display_(Seq[Any](/*57.6*/productoForm("tipo_producto_id")/*57.38*/.error.map/*57.48*/{ error =>_display_(Seq[Any](format.raw/*57.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*58.31*/error/*58.36*/.message)),format.raw/*58.44*/("""</div>
				""")))})),format.raw/*59.6*/("""
			</div>
		</div>
		<!-- <div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*63.28*/if(productoForm.error("articulo.id") != null)/*63.73*/ {_display_(Seq[Any](format.raw/*63.75*/("""has-error""")))}/*63.85*/else/*63.89*/{_display_(Seq[Any](format.raw/*63.90*/("""has-required""")))})),format.raw/*63.103*/("""">
				<label for="inputArticulo" class="control-label">Articulo</label> 
				"""),_display_(Seq[Any](/*65.6*/inputText(productoForm("articulo.nombre"),'class -> "form-control"))),format.raw/*65.73*/("""
				"""),_display_(Seq[Any](/*66.6*/inputText(productoForm("articulo_id"),'hidden -> "hidden"))),format.raw/*66.64*/("""
				"""),_display_(Seq[Any](/*67.6*/productoForm("articulo_id")/*67.33*/.error.map/*67.43*/{ error =>_display_(Seq[Any](format.raw/*67.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*68.31*/error/*68.36*/.message)),format.raw/*68.44*/("""</div>
				""")))})),format.raw/*69.6*/("""
			</div>
		</div> -->
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*73.28*/if(productoForm.error("udm.id") != null)/*73.68*/ {_display_(Seq[Any](format.raw/*73.70*/("""has-error""")))}/*73.80*/else/*73.84*/{_display_(Seq[Any](format.raw/*73.85*/("""has-required""")))})),format.raw/*73.98*/("""">
				<label for="inputUdm" class="control-label">Udm</label> 
				"""),_display_(Seq[Any](/*75.6*/inputText(productoForm("udm.nombre"),'class -> "form-control"))),format.raw/*75.68*/("""
				"""),_display_(Seq[Any](/*76.6*/inputText(productoForm("udm_id"),'hidden -> "hidden"))),format.raw/*76.59*/("""
				"""),_display_(Seq[Any](/*77.6*/productoForm("udm_id")/*77.28*/.error.map/*77.38*/{ error =>_display_(Seq[Any](format.raw/*77.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*78.31*/error/*78.36*/.message)),format.raw/*78.44*/("""</div>
				""")))})),format.raw/*79.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*85.28*/if(productoForm.error("precio_coste") != null)/*85.74*/ {_display_(Seq[Any](format.raw/*85.76*/("""has-error""")))}/*85.86*/else/*85.90*/{_display_(Seq[Any](format.raw/*85.91*/("""has-required""")))})),format.raw/*85.104*/("""">
				<label for="inputPrecioCoste" class="control-label">Precio Coste</label> 
				"""),_display_(Seq[Any](/*87.6*/inputText(productoForm("precio_coste"), 'class -> "form-control"))),format.raw/*87.71*/("""
				"""),_display_(Seq[Any](/*88.6*/productoForm("precio_coste")/*88.34*/.error.map/*88.44*/{ error =>_display_(Seq[Any](format.raw/*88.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*89.31*/error/*89.36*/.message)),format.raw/*89.44*/("""</div>
				""")))})),format.raw/*90.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*94.28*/if(productoForm.error("cuenta_ingreso.id") != null)/*94.79*/ {_display_(Seq[Any](format.raw/*94.81*/("""has-error""")))}/*94.91*/else/*94.95*/{_display_(Seq[Any](format.raw/*94.96*/("""has-required""")))})),format.raw/*94.109*/("""">
				<label for="inputCuentaIngresos" class="control-label">Cuenta de Ingresos</label> 
				"""),_display_(Seq[Any](/*96.6*/inputText(productoForm("cuenta_ingreso.nombre"),'class -> "form-control"))),format.raw/*96.79*/("""
										 
				"""),_display_(Seq[Any](/*98.6*/inputText(productoForm("cuenta_ingreso_id"),'hidden -> "hidden"))),format.raw/*98.70*/("""
				"""),_display_(Seq[Any](/*99.6*/productoForm("cuenta_ingreso_id")/*99.39*/.error.map/*99.49*/{ error =>_display_(Seq[Any](format.raw/*99.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*100.31*/error/*100.36*/.message)),format.raw/*100.44*/("""</div>
				""")))})),format.raw/*101.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*105.28*/if(productoForm.error("cuenta_gasto.id") != null)/*105.77*/ {_display_(Seq[Any](format.raw/*105.79*/("""has-error""")))}/*105.89*/else/*105.93*/{_display_(Seq[Any](format.raw/*105.94*/("""has-required""")))})),format.raw/*105.107*/("""">
				<label for="inputCuentaGastos" class="control-label">Cuenta de gastos</label> 
				"""),_display_(Seq[Any](/*107.6*/inputText(productoForm("cuenta_gasto.nombre"),'class -> "form-control"))),format.raw/*107.77*/("""
				"""),_display_(Seq[Any](/*108.6*/inputText(productoForm("cuenta_gasto_id"),'hidden -> "hidden"))),format.raw/*108.68*/("""
				"""),_display_(Seq[Any](/*109.6*/productoForm("cuenta_gasto_id")/*109.37*/.error.map/*109.47*/{ error =>_display_(Seq[Any](format.raw/*109.57*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*110.31*/error/*110.36*/.message)),format.raw/*110.44*/("""</div>
				""")))})),format.raw/*111.6*/("""
			</div>
		</div>
		"""),_display_(Seq[Any](/*114.4*/checkbox(productoForm("producto.venta"), 'hidden -> "hidden"))),format.raw/*114.65*/("""
		"""),_display_(Seq[Any](/*115.4*/checkbox(productoForm("producto.compra"), 'hidden -> "hidden"))),format.raw/*115.66*/("""
		<!-- <div class="col-sm-3">
			<div class="form-group">
				<div class="checkbox">
					<label for="inputPuedeSerVendido" class="control-label">
						Puede ser Vendido 
						
					</label>
				</div>
				<div class="checkbox">
					<label for="inputPuedeSerComprado" class="control-label"> 
						Puede ser Comprado
						
					</label>
				</div> 
			</div>
		</div> -->
		
		 
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
					"""),_display_(Seq[Any](/*146.7*/for( d <- Deposito.find.all()) yield /*146.37*/{_display_(Seq[Any](format.raw/*146.38*/("""
						
						<tr>
							<td>
								<input type="checkbox" class="permiso" name="productoDeposito[]" 
								"""),_display_(Seq[Any](/*151.10*/if(productoDepositoArray != null)/*151.43*/{_display_(Seq[Any](format.raw/*151.44*/(""" 
								"""),_display_(Seq[Any](/*152.10*/if(productoDepositoArray.contains(d.id.intValue()))/*152.61*/ {_display_(Seq[Any](format.raw/*152.63*/("""checked""")))}))))})),format.raw/*152.72*/(""" 
								value=""""),_display_(Seq[Any](/*153.17*/d/*153.18*/.id)),format.raw/*153.21*/("""" />
								
							</td>
							<td>"""),_display_(Seq[Any](/*156.13*/d/*156.14*/.nombre)),format.raw/*156.21*/("""</td>
						</tr>
					""")))})),format.raw/*158.7*/("""
				</tbody>	
			</table>
		</div>
	</div>"""))}
    }
    
    def render(productoForm:Form[Producto],editarNombre:Boolean,productoDepositoArray:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(productoForm,editarNombre,productoDepositoArray)
    
    def f:((Form[Producto],Boolean,List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (productoForm,editarNombre,productoDepositoArray) => apply(productoForm,editarNombre,productoDepositoArray)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/formProducto.scala.html
                    HASH: d21c0dd98eef3512529198538a3d3a172b69d1bb
                    MATRIX: 829->1|1025->114|1057->138|1131->95|1159->182|1244->233|1268->249|1306->250|1369->278|1417->318|1456->320|1484->330|1496->334|1534->335|1578->348|1688->423|1769->482|1810->488|1841->510|1860->520|1908->530|1975->561|1989->566|2019->574|2062->586|2095->601|2107->605|2146->606|2187->612|2292->695|2328->700|2535->872|2620->935|2811->1091|2898->1156|3085->1308|3170->1371|3305->1470|3360->1516|3400->1518|3429->1528|3442->1532|3481->1533|3527->1546|3650->1634|3740->1702|3781->1708|3862->1767|3903->1773|3940->1801|3959->1811|4007->1821|4074->1852|4088->1857|4118->1865|4161->1877|4269->1949|4328->1999|4368->2001|4397->2011|4410->2015|4449->2016|4495->2029|4618->2117|4712->2189|4753->2195|4838->2258|4879->2264|4920->2296|4939->2306|4987->2316|5054->2347|5068->2352|5098->2360|5141->2372|5254->2449|5308->2494|5348->2496|5377->2506|5390->2510|5429->2511|5475->2524|5589->2603|5678->2670|5719->2676|5799->2734|5840->2740|5876->2767|5895->2777|5943->2787|6010->2818|6024->2823|6054->2831|6097->2843|6209->2919|6258->2959|6298->2961|6327->2971|6340->2975|6379->2976|6424->2989|6528->3058|6612->3120|6653->3126|6728->3179|6769->3185|6800->3207|6819->3217|6867->3227|6934->3258|6948->3263|6978->3271|7021->3283|7156->3382|7211->3428|7251->3430|7280->3440|7293->3444|7332->3445|7378->3458|7499->3544|7586->3609|7627->3615|7664->3643|7683->3653|7731->3663|7798->3694|7812->3699|7842->3707|7885->3719|7993->3791|8053->3842|8093->3844|8122->3854|8135->3858|8174->3859|8220->3872|8350->3967|8445->4040|8498->4058|8584->4122|8625->4128|8667->4161|8686->4171|8734->4181|8802->4212|8817->4217|8848->4225|8892->4237|9001->4309|9060->4358|9101->4360|9131->4370|9145->4374|9185->4375|9232->4388|9359->4479|9453->4550|9495->4556|9580->4618|9622->4624|9663->4655|9683->4665|9732->4675|9800->4706|9815->4711|9846->4719|9890->4731|9949->4754|10033->4815|10073->4819|10158->4881|10819->5506|10866->5536|10906->5537|11057->5651|11100->5684|11140->5685|11188->5696|11249->5747|11290->5749|11336->5758|11391->5776|11402->5777|11428->5780|11504->5819|11515->5820|11545->5827|11601->5851
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8|36->8|36->8|38->10|38->10|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|43->15|43->15|43->15|44->16|44->16|45->17|53->25|53->25|59->31|59->31|65->37|65->37|71->43|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|74->46|74->46|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|83->55|83->55|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|91->63|91->63|91->63|91->63|91->63|91->63|91->63|93->65|93->65|94->66|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|97->69|101->73|101->73|101->73|101->73|101->73|101->73|101->73|103->75|103->75|104->76|104->76|105->77|105->77|105->77|105->77|106->78|106->78|106->78|107->79|113->85|113->85|113->85|113->85|113->85|113->85|113->85|115->87|115->87|116->88|116->88|116->88|116->88|117->89|117->89|117->89|118->90|122->94|122->94|122->94|122->94|122->94|122->94|122->94|124->96|124->96|126->98|126->98|127->99|127->99|127->99|127->99|128->100|128->100|128->100|129->101|133->105|133->105|133->105|133->105|133->105|133->105|133->105|135->107|135->107|136->108|136->108|137->109|137->109|137->109|137->109|138->110|138->110|138->110|139->111|142->114|142->114|143->115|143->115|174->146|174->146|174->146|179->151|179->151|179->151|180->152|180->152|180->152|180->152|181->153|181->153|181->153|184->156|184->156|184->156|186->158
                    -- GENERATED --
                */
            