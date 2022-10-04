
package views.html.contabilidad.cuentaBancarias

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
object formCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CuentaBancaria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaBancariaForm: Form[CuentaBancaria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.70*/(""" 
<script>
$( function()"""),format.raw/*5.14*/("""{"""),format.raw/*5.15*/("""
$('#searchProveedor').modalSearch();
$( "#cbu" ).mask("9999999999999999999999");
$( "#numero_cuenta" ).mask("999999999999999");
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/(""");


</script>	
	 
	<div class="row menu-acciones">
		<div class="col-sm-10">
	      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
	      <a href=""""),_display_(Seq[Any](/*17.18*/controllers/*17.29*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*17.97*/("""" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
    </div>
	"""),_display_(Seq[Any](/*20.3*/inputText(cuentaBancariaForm("estado_id"),'type -> "hidden", 'class -> "form-control"))),format.raw/*20.89*/("""
	"""),_display_(Seq[Any](/*21.3*/inputText(cuentaBancariaForm("id"),'type -> "hidden", 'class -> "form-control"))),format.raw/*21.82*/("""
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*24.28*/if(cuentaBancariaForm.error("proveedor_id") != null)/*24.80*/ {_display_(Seq[Any](format.raw/*24.82*/("""has-error""")))}/*24.92*/else/*24.96*/{_display_(Seq[Any](format.raw/*24.97*/("""has-required""")))})),format.raw/*24.110*/("""">
				<label for="inputProveedor" class="control-label">Proveedor</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*27.7*/inputText(cuentaBancariaForm("proveedor.nombre"),'class -> "form-control",'id -> "proveedor"))),format.raw/*27.100*/("""
					"""),_display_(Seq[Any](/*28.7*/inputText(cuentaBancariaForm("proveedor_id"),'hidden -> "hidden",'id -> "proveedor_id"))),format.raw/*28.94*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*33.21*/controllers/*33.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*33.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor" 
									data-field="#proveedor_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*43.6*/cuentaBancariaForm("proveedor_id")/*43.40*/.error.map/*43.50*/{ error =>_display_(Seq[Any](format.raw/*43.60*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*44.31*/error/*44.36*/.message)),format.raw/*44.44*/("""</div>
				""")))})),format.raw/*45.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*49.28*/if(cuentaBancariaForm.error("numero_cuenta") != null)/*49.81*/ {_display_(Seq[Any](format.raw/*49.83*/("""has-error""")))}/*49.93*/else/*49.97*/{_display_(Seq[Any](format.raw/*49.98*/("""has-required""")))})),format.raw/*49.111*/("""">
				<label for="inputNombre" class="control-label">Numero Cuenta</label> 
				"""),_display_(Seq[Any](/*51.6*/inputText(cuentaBancariaForm("numero_cuenta"), 'class -> "form-control",'id->"numero_cuenta"))),format.raw/*51.99*/("""
				"""),_display_(Seq[Any](/*52.6*/cuentaBancariaForm("numero_cuenta")/*52.41*/.error.map/*52.51*/{ error =>_display_(Seq[Any](format.raw/*52.61*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*53.31*/error/*53.36*/.message)),format.raw/*53.44*/("""</div>
				""")))})),format.raw/*54.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*58.28*/if(cuentaBancariaForm.error("cbu") != null)/*58.71*/ {_display_(Seq[Any](format.raw/*58.73*/("""has-error""")))}/*58.83*/else/*58.87*/{_display_(Seq[Any](format.raw/*58.88*/("""has-required""")))})),format.raw/*58.101*/("""">
				<label for="inputNombre" class="control-label">CBU</label> 
				"""),_display_(Seq[Any](/*60.6*/inputText(cuentaBancariaForm("cbu"), 'class -> "form-control",'id -> "cbu" ))),format.raw/*60.82*/("""
				"""),_display_(Seq[Any](/*61.6*/cuentaBancariaForm("cbu")/*61.31*/.error.map/*61.41*/{ error =>_display_(Seq[Any](format.raw/*61.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*62.31*/error/*62.36*/.message)),format.raw/*62.44*/("""</div>
				""")))})),format.raw/*63.6*/("""
			</div>
		</div>
	</div>
	<div class="row contenedorUbicacion">
		<div class="col-sm-4">
			<div class="seleccionBanco form-group """),_display_(Seq[Any](/*69.43*/if(cuentaBancariaForm.error("banco_id") != null)/*69.91*/ {_display_(Seq[Any](format.raw/*69.93*/("""has-error""")))}/*69.103*/else/*69.107*/{_display_(Seq[Any](format.raw/*69.108*/("""has-required""")))})),format.raw/*69.121*/("""">
				<label for=""""),_display_(Seq[Any](/*70.18*/cuentaBancariaForm("banco_id")/*70.48*/.id)),format.raw/*70.51*/("""" class="control-label">Banco</label>
				"""),_display_(Seq[Any](/*71.6*/select(cuentaBancariaForm("banco_id"), Banco.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*71.161*/("""
				"""),_display_(Seq[Any](/*72.6*/cuentaBancariaForm("banco_id")/*72.36*/.error.map/*72.46*/{ error =>_display_(Seq[Any](format.raw/*72.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*73.31*/error/*73.36*/.message)),format.raw/*73.44*/("""</div>
				""")))})),format.raw/*74.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="seleccionSucursal form-group """),_display_(Seq[Any](/*78.46*/if(cuentaBancariaForm.error("sucursal_banco_id") != null)/*78.103*/ {_display_(Seq[Any](format.raw/*78.105*/("""has-error""")))}/*78.115*/else/*78.119*/{_display_(Seq[Any](format.raw/*78.120*/("""has-required""")))})),format.raw/*78.133*/("""">
				<label for=""""),_display_(Seq[Any](/*79.18*/cuentaBancariaForm("sucursal_banco_id")/*79.57*/.id)),format.raw/*79.60*/("""" class="control-label">Sucursal</label>
				"""),_display_(Seq[Any](/*80.6*/select(cuentaBancariaForm("sucursal_banco_id"), 
					cuentaBancariaForm("banco_id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {SucursalBanco.getSucursales(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*86.65*/("""
				"""),_display_(Seq[Any](/*87.6*/cuentaBancariaForm("sucursal_banco_id")/*87.45*/.error.map/*87.55*/{ error =>_display_(Seq[Any](format.raw/*87.65*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*88.31*/error/*88.36*/.message)),format.raw/*88.44*/("""</div>
				""")))})),format.raw/*89.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="checkbox" style="display: none;">
				<label class="control-label"> 
					Activo
					"""),_display_(Seq[Any](/*96.7*/checkbox(cuentaBancariaForm("activo")))),format.raw/*96.45*/("""
				</label>
			</div>
			<div class="checkbox">
				<label class="control-label"> 
					Predeterminada
					"""),_display_(Seq[Any](/*102.7*/checkbox(cuentaBancariaForm("predeterminada")))),format.raw/*102.53*/("""
				</label>
			</div>
		</div>
		 
	</div>
<script>
	$( function() """),format.raw/*109.16*/("""{"""),format.raw/*109.17*/("""
		
		urlSucursales  = '"""),_display_(Seq[Any](/*111.22*/controllers/*111.33*/.contabilidad.routes.SucursalBancosController.listOptions())),format.raw/*111.92*/("""';
		
		$('.seleccionBanco .select').on('change', function()"""),format.raw/*113.55*/("""{"""),format.raw/*113.56*/("""
			var id = $(this).find('option:selected').val();
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionSucursal .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlSucursales + '?bancoId='+id, function(data)"""),format.raw/*120.56*/("""{"""),format.raw/*120.57*/("""
				contenedor.find('.seleccionSucursal .select').html(data);
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/(""");
		"""),format.raw/*123.3*/("""}"""),format.raw/*123.4*/(""");
		
		
	
	"""),format.raw/*127.2*/("""}"""),format.raw/*127.3*/(""");
</script>"""))}
    }
    
    def render(cuentaBancariaForm:Form[CuentaBancaria]): play.api.templates.HtmlFormat.Appendable = apply(cuentaBancariaForm)
    
    def f:((Form[CuentaBancaria]) => play.api.templates.HtmlFormat.Appendable) = (cuentaBancariaForm) => apply(cuentaBancariaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/formCuentaBancaria.scala.html
                    HASH: 205de5c19a27a52cc5bbb5fb4bbb0fdd75eaff7e
                    MATRIX: 830->1|974->62|1006->86|1080->43|1108->130|1159->154|1187->155|1342->284|1369->285|1618->498|1638->509|1728->577|1877->691|1985->777|2023->780|2124->859|2232->931|2293->983|2333->985|2362->995|2375->999|2414->1000|2460->1013|2607->1125|2723->1218|2765->1225|2874->1312|3086->1488|3106->1499|3179->1550|3490->1826|3533->1860|3552->1870|3600->1880|3667->1911|3681->1916|3711->1924|3754->1936|3862->2008|3924->2061|3964->2063|3993->2073|4006->2077|4045->2078|4091->2091|4208->2173|4323->2266|4364->2272|4408->2307|4427->2317|4475->2327|4542->2358|4556->2363|4586->2371|4629->2383|4737->2455|4789->2498|4829->2500|4858->2510|4871->2514|4910->2515|4956->2528|5063->2600|5161->2676|5202->2682|5236->2707|5255->2717|5303->2727|5370->2758|5384->2763|5414->2771|5457->2783|5627->2917|5684->2965|5724->2967|5754->2977|5768->2981|5808->2982|5854->2995|5910->3015|5949->3045|5974->3048|6052->3091|6230->3246|6271->3252|6310->3282|6329->3292|6377->3302|6444->3333|6458->3338|6488->3346|6531->3358|6657->3448|6724->3505|6765->3507|6795->3517|6809->3521|6849->3522|6895->3535|6951->3555|6999->3594|7024->3597|7105->3643|7472->3988|7513->3994|7561->4033|7580->4043|7628->4053|7695->4084|7709->4089|7739->4097|7782->4109|7964->4256|8024->4294|8171->4405|8240->4451|8338->4520|8368->4521|8430->4546|8451->4557|8533->4616|8622->4676|8652->4677|8964->4960|8994->4961|9088->5027|9117->5028|9150->5033|9179->5034|9219->5046|9248->5047
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|37->9|37->9|45->17|45->17|45->17|48->20|48->20|49->21|49->21|52->24|52->24|52->24|52->24|52->24|52->24|52->24|55->27|55->27|56->28|56->28|61->33|61->33|61->33|71->43|71->43|71->43|71->43|72->44|72->44|72->44|73->45|77->49|77->49|77->49|77->49|77->49|77->49|77->49|79->51|79->51|80->52|80->52|80->52|80->52|81->53|81->53|81->53|82->54|86->58|86->58|86->58|86->58|86->58|86->58|86->58|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|91->63|97->69|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|100->72|100->72|100->72|100->72|101->73|101->73|101->73|102->74|106->78|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|107->79|108->80|114->86|115->87|115->87|115->87|115->87|116->88|116->88|116->88|117->89|124->96|124->96|130->102|130->102|137->109|137->109|139->111|139->111|139->111|141->113|141->113|148->120|148->120|150->122|150->122|151->123|151->123|155->127|155->127
                    -- GENERATED --
                */
            