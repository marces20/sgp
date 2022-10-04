
package views.html.recupero.presupuestoLineas

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.PresupuestoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[models.recupero.PresupuestoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.53*/("""
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
	
	$(document).on('modal.seleccion.producto.simple', function (event, respuesta) """),format.raw/*16.80*/("""{"""),format.raw/*16.81*/("""
		$('#precio').val(respuesta.costo);
	"""),format.raw/*18.2*/("""}"""),format.raw/*18.3*/(""");
	
	
	
	$('#searchCuentaAnalitica').modalSearch();
	$("#cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*24.29*/("""{"""),format.raw/*24.30*/("""allowNegative: true"""),format.raw/*24.49*/("""}"""),format.raw/*24.50*/(""");
	$('#searchCuentaModal').modalSearch();
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/(""");

</script>

 <div class="row">
	"""),_display_(Seq[Any](/*31.3*/inputText(lineaForm("presupuesto_id"), 'type -> "hidden"))),format.raw/*31.60*/("""
	
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*35.28*/if(lineaForm.error("producto_id") != null)/*35.70*/ {_display_(Seq[Any](format.raw/*35.72*/("""has-error""")))}/*35.83*/else/*35.88*/{_display_(Seq[Any](format.raw/*35.89*/("""has-required""")))})),format.raw/*35.102*/("""">
			"""),_display_(Seq[Any](/*36.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*36.122*/("""
			"""),_display_(Seq[Any](/*37.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*37.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*41.19*/controllers/*41.30*/.compras.routes.ProductosController.modalBuscarIps())),format.raw/*41.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*51.4*/lineaForm("producto_id")/*51.28*/.error.map/*51.38*/{ error =>_display_(Seq[Any](format.raw/*51.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*52.29*/error/*52.34*/.message)),format.raw/*52.42*/("""</div>
		""")))})),format.raw/*53.4*/("""
	</div>
	
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*61.27*/if(lineaForm.error("precio") != null)/*61.64*/ {_display_(Seq[Any](format.raw/*61.66*/("""has-error""")))}/*61.77*/else/*61.82*/{_display_(Seq[Any](format.raw/*61.83*/("""has-required""")))})),format.raw/*61.96*/("""">
			"""),_display_(Seq[Any](/*62.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*62.78*/("""
			"""),_display_(Seq[Any](/*63.5*/lineaForm("precio")/*63.24*/.error.map/*63.34*/{ error =>_display_(Seq[Any](format.raw/*63.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*63.70*/error/*63.75*/.message)),format.raw/*63.83*/("""</div>""")))})),format.raw/*63.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*69.27*/if(lineaForm.error("cantidad") != null)/*69.66*/ {_display_(Seq[Any](format.raw/*69.68*/("""has-error""")))}/*69.79*/else/*69.84*/{_display_(Seq[Any](format.raw/*69.85*/("""has-required""")))})),format.raw/*69.98*/("""">
			"""),_display_(Seq[Any](/*70.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*70.82*/("""
			"""),_display_(Seq[Any](/*71.5*/lineaForm("cantidad")/*71.26*/.error.map/*71.36*/{ error =>_display_(Seq[Any](format.raw/*71.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*71.72*/error/*71.77*/.message)),format.raw/*71.85*/("""</div>""")))})),format.raw/*71.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*76.27*/if(lineaForm.error("udm_id") != null)/*76.64*/ {_display_(Seq[Any](format.raw/*76.66*/("""has-error""")))}/*76.77*/else/*76.82*/{_display_(Seq[Any](format.raw/*76.83*/("""has-required""")))})),format.raw/*76.96*/("""">
			"""),_display_(Seq[Any](/*77.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*77.147*/("""
			"""),_display_(Seq[Any](/*78.5*/lineaForm("udm_id")/*78.24*/.error.map/*78.34*/{ error =>_display_(Seq[Any](format.raw/*78.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*78.70*/error/*78.75*/.message)),format.raw/*78.83*/("""</div> """)))})),format.raw/*78.91*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*85.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*85.78*/ {_display_(Seq[Any](format.raw/*85.80*/("""has-error""")))}/*85.91*/else/*85.96*/{_display_(Seq[Any](format.raw/*85.97*/("""has-required""")))})),format.raw/*85.110*/("""">
			"""),_display_(Seq[Any](/*86.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*86.103*/("""
			"""),_display_(Seq[Any](/*87.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*87.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*93.19*/controllers/*93.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*93.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*102.4*/lineaForm("cuenta_analitica_id")/*102.36*/.error.map/*102.46*/{ error =>_display_(Seq[Any](format.raw/*102.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*103.29*/error/*103.34*/.message)),format.raw/*103.42*/("""</div>
		""")))})),format.raw/*104.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*108.28*/if(lineaForm.error("cuenta_id") != null)/*108.68*/ {_display_(Seq[Any](format.raw/*108.70*/("""has-error""")))}/*108.81*/else/*108.86*/{_display_(Seq[Any](format.raw/*108.87*/("""has-required""")))})),format.raw/*108.100*/("""">
			"""),_display_(Seq[Any](/*109.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*109.91*/("""
			"""),_display_(Seq[Any](/*110.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*110.84*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModal" 
							data-title="Selección de Cuenta" 
							data-url=""""),_display_(Seq[Any](/*115.19*/controllers/*115.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*115.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal" 
							data-field="#cuenta_id_modal">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*125.4*/lineaForm("cuenta_id")/*125.26*/.error.map/*125.36*/{ error =>_display_(Seq[Any](format.raw/*125.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*126.29*/error/*126.34*/.message)),format.raw/*126.42*/("""</div>
		""")))})),format.raw/*127.4*/("""
	</div>
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*138.14*/("""{"""),format.raw/*138.15*/("""

		var options = """),format.raw/*140.17*/("""{"""),format.raw/*140.18*/("""
				script:"/suggestProductoPresupuesto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*146.30*/("""{"""),format.raw/*146.31*/(""" 
											$("#producto_id_modal").val(obj.id);
											$("#precio").val(obj.precio);
										 """),format.raw/*149.12*/("""}"""),format.raw/*149.13*/("""
			"""),format.raw/*150.4*/("""}"""),format.raw/*150.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);


		var options = """),format.raw/*154.17*/("""{"""),format.raw/*154.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*160.30*/("""{"""),format.raw/*160.31*/(""" 
											$("#cuenta_id_modal").val(obj.id); 
										 """),format.raw/*162.12*/("""}"""),format.raw/*162.13*/("""
			"""),format.raw/*163.4*/("""}"""),format.raw/*163.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_modal', options);


		var options = """),format.raw/*167.17*/("""{"""),format.raw/*167.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*173.30*/("""{"""),format.raw/*173.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*175.12*/("""}"""),format.raw/*175.13*/("""
			"""),format.raw/*176.4*/("""}"""),format.raw/*176.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);

"""),format.raw/*179.1*/("""}"""),format.raw/*179.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[models.recupero.PresupuestoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[models.recupero.PresupuestoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuestoLineas/formLineaProducto.scala.html
                    HASH: c554c31be417aa4f1c276082c9b22acdbef742bf
                    MATRIX: 845->1|999->73|1031->97|1105->52|1134->141|1188->160|1202->166|1272->215|1345->254|1383->284|1422->286|1545->374|1558->379|1592->392|1635->404|1687->428|1716->429|1871->556|1900->557|1968->598|1996->599|2144->719|2173->720|2220->739|2249->740|2321->785|2349->786|2425->827|2504->884|2668->1012|2719->1054|2759->1056|2788->1067|2801->1072|2840->1073|2886->1086|2929->1094|3069->1211|3110->1217|3216->1301|3396->1445|3416->1456|3490->1508|3802->1785|3835->1809|3854->1819|3902->1829|3968->1859|3982->1864|4012->1872|4054->1883|4231->2024|4277->2061|4317->2063|4346->2074|4359->2079|4398->2080|4443->2093|4486->2101|4581->2174|4622->2180|4650->2199|4669->2209|4717->2219|4779->2245|4793->2250|4823->2258|4862->2265|5038->2405|5086->2444|5126->2446|5155->2457|5168->2462|5207->2463|5252->2476|5295->2484|5394->2561|5435->2567|5465->2588|5484->2598|5532->2608|5594->2634|5608->2639|5638->2647|5677->2654|5827->2768|5873->2805|5913->2807|5942->2818|5955->2823|5994->2824|6039->2837|6082->2845|6247->2987|6288->2993|6316->3012|6335->3022|6383->3032|6445->3058|6459->3063|6489->3071|6529->3079|6735->3249|6794->3299|6834->3301|6863->3312|6876->3317|6915->3318|6961->3331|7004->3339|7125->3437|7166->3443|7281->3536|7508->3727|7528->3738|7612->3800|7926->4078|7968->4110|7988->4120|8037->4130|8104->4160|8119->4165|8150->4173|8193->4184|8353->4307|8403->4347|8444->4349|8474->4360|8488->4365|8528->4366|8575->4379|8619->4387|8728->4473|8770->4479|8872->4558|9077->4726|9098->4737|9173->4789|9478->5058|9510->5080|9530->5090|9579->5100|9646->5130|9661->5135|9692->5143|9735->5154|10176->5566|10206->5567|10255->5587|10285->5588|10466->5740|10496->5741|10630->5846|10660->5847|10693->5852|10722->5853|10839->5941|10869->5942|11050->6094|11080->6095|11171->6157|11201->6158|11234->6163|11263->6164|11378->6250|11408->6251|11598->6412|11628->6413|11722->6478|11752->6479|11785->6484|11814->6485|11913->6556|11942->6557
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|44->16|44->16|46->18|46->18|52->24|52->24|52->24|52->24|54->26|54->26|59->31|59->31|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|65->37|65->37|69->41|69->41|69->41|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|97->69|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|104->76|104->76|104->76|104->76|104->76|104->76|104->76|105->77|105->77|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|113->85|113->85|113->85|113->85|113->85|113->85|113->85|114->86|114->86|115->87|115->87|121->93|121->93|121->93|130->102|130->102|130->102|130->102|131->103|131->103|131->103|132->104|136->108|136->108|136->108|136->108|136->108|136->108|136->108|137->109|137->109|138->110|138->110|143->115|143->115|143->115|153->125|153->125|153->125|153->125|154->126|154->126|154->126|155->127|166->138|166->138|168->140|168->140|174->146|174->146|177->149|177->149|178->150|178->150|182->154|182->154|188->160|188->160|190->162|190->162|191->163|191->163|195->167|195->167|201->173|201->173|203->175|203->175|204->176|204->176|207->179|207->179
                    -- GENERATED --
                */
            