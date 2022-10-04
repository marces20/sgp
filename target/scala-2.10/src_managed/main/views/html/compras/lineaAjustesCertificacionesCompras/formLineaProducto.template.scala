
package views.html.compras.lineaAjustesCertificacionesCompras

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionesComprasLineaAjustes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[CertificacionesComprasLineaAjustes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""
<script>
$(function()"""),format.raw/*9.13*/("""{"""),format.raw/*9.14*/("""
	$('#searchProductoModal').modalSearch();
	$('#searchCuentaAnalitica').modalSearch();
	$("#descuento, #cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*13.29*/("""{"""),format.raw/*13.30*/("""allowNegative: true"""),format.raw/*13.49*/("""}"""),format.raw/*13.50*/(""");
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");

</script>

 <div class="row">
	"""),_display_(Seq[Any](/*19.3*/inputText(lineaForm("certificacion_compra_id"), 'type -> "hidden"))),format.raw/*19.69*/("""
	 
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*23.28*/if(lineaForm.error("producto_id") != null)/*23.70*/ {_display_(Seq[Any](format.raw/*23.72*/("""has-error""")))}/*23.83*/else/*23.88*/{_display_(Seq[Any](format.raw/*23.89*/("""has-required""")))})),format.raw/*23.102*/("""">
			"""),_display_(Seq[Any](/*24.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*24.122*/("""
			"""),_display_(Seq[Any](/*25.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*25.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*29.19*/controllers/*29.30*/.compras.routes.ProductosController.modalBuscar())),format.raw/*29.79*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*39.4*/lineaForm("producto_id")/*39.28*/.error.map/*39.38*/{ error =>_display_(Seq[Any](format.raw/*39.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*40.29*/error/*40.34*/.message)),format.raw/*40.42*/("""</div>
		""")))})),format.raw/*41.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta analitica</label>
		<div class="input-group """),_display_(Seq[Any](/*45.28*/if(lineaForm.error("cuenta_analitica_id") != null)/*45.78*/ {_display_(Seq[Any](format.raw/*45.80*/("""has-error""")))}/*45.91*/else/*45.96*/{_display_(Seq[Any](format.raw/*45.97*/("""has-required""")))})),format.raw/*45.110*/("""">
			"""),_display_(Seq[Any](/*46.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*46.103*/("""
			"""),_display_(Seq[Any](/*47.5*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*47.98*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*53.19*/controllers/*53.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*53.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*62.4*/lineaForm("cuenta_analitica_id")/*62.36*/.error.map/*62.46*/{ error =>_display_(Seq[Any](format.raw/*62.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*63.29*/error/*63.34*/.message)),format.raw/*63.42*/("""</div>
		""")))})),format.raw/*64.4*/("""
	</div>
</div>

<div class="row">
	<div class="col-sm-3">
		<label class="control-label">Precio</label>
		<div class="form-group """),_display_(Seq[Any](/*71.27*/if(lineaForm.error("precio") != null)/*71.64*/ {_display_(Seq[Any](format.raw/*71.66*/("""has-error""")))}/*71.77*/else/*71.82*/{_display_(Seq[Any](format.raw/*71.83*/("""has-required""")))})),format.raw/*71.96*/("""">
			"""),_display_(Seq[Any](/*72.5*/inputText(lineaForm("precio"), 'class -> "form-control", 'id -> "precio"))),format.raw/*72.78*/("""
			"""),_display_(Seq[Any](/*73.5*/lineaForm("precio")/*73.24*/.error.map/*73.34*/{ error =>_display_(Seq[Any](format.raw/*73.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*73.70*/error/*73.75*/.message)),format.raw/*73.83*/("""</div>""")))})),format.raw/*73.90*/("""
		</div>
	</div>
		
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*79.27*/if(lineaForm.error("cantidad") != null)/*79.66*/ {_display_(Seq[Any](format.raw/*79.68*/("""has-error""")))}/*79.79*/else/*79.84*/{_display_(Seq[Any](format.raw/*79.85*/("""has-required""")))})),format.raw/*79.98*/("""">
			"""),_display_(Seq[Any](/*80.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*80.82*/("""
			"""),_display_(Seq[Any](/*81.5*/lineaForm("cantidad")/*81.26*/.error.map/*81.36*/{ error =>_display_(Seq[Any](format.raw/*81.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*81.72*/error/*81.77*/.message)),format.raw/*81.85*/("""</div>""")))})),format.raw/*81.92*/("""
		</div>
	</div>

	<div class="col-sm-3"><label class="control-label">UDM</label>
		<div class="form-group """),_display_(Seq[Any](/*86.27*/if(lineaForm.error("udm_id") != null)/*86.64*/ {_display_(Seq[Any](format.raw/*86.66*/("""has-error""")))}/*86.77*/else/*86.82*/{_display_(Seq[Any](format.raw/*86.83*/("""has-required""")))})),format.raw/*86.96*/("""">
			"""),_display_(Seq[Any](/*87.5*/select(lineaForm("udm_id"), Udm.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*87.147*/("""
			"""),_display_(Seq[Any](/*88.5*/lineaForm("udm_id")/*88.24*/.error.map/*88.34*/{ error =>_display_(Seq[Any](format.raw/*88.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*88.70*/error/*88.75*/.message)),format.raw/*88.83*/("""</div> """)))})),format.raw/*88.91*/("""
		</div>
	</div>
	 
</div>
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" id="btn-guardar-linea-ajuste-cc" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*101.14*/("""{"""),format.raw/*101.15*/("""
	if($("#producto_modal").length)"""),format.raw/*102.33*/("""{"""),format.raw/*102.34*/("""
		var options = """),format.raw/*103.17*/("""{"""),format.raw/*103.18*/("""
				script:"/suggestProducto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*109.30*/("""{"""),format.raw/*109.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*111.12*/("""}"""),format.raw/*111.13*/("""
			"""),format.raw/*112.4*/("""}"""),format.raw/*112.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*114.2*/("""}"""),format.raw/*114.3*/("""
	
	if($("#cuentaAnalitica").length)"""),format.raw/*116.34*/("""{"""),format.raw/*116.35*/("""
		var options = """),format.raw/*117.17*/("""{"""),format.raw/*117.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*123.30*/("""{"""),format.raw/*123.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*125.12*/("""}"""),format.raw/*125.13*/("""
			"""),format.raw/*126.4*/("""}"""),format.raw/*126.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*128.2*/("""}"""),format.raw/*128.3*/("""
"""),format.raw/*129.1*/("""}"""),format.raw/*129.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[CertificacionesComprasLineaAjustes]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[CertificacionesComprasLineaAjustes]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineaAjustesCertificacionesCompras/formLineaProducto.scala.html
                    HASH: 1e8b86811b71b8eadcbfc35c7f84e601434c0d21
                    MATRIX: 863->1|1019->75|1051->99|1125->54|1154->143|1208->162|1222->168|1292->217|1365->256|1377->261|1423->286|1474->310|1502->311|1694->475|1723->476|1770->495|1799->496|1830->500|1858->501|1934->542|2022->608|2187->737|2238->779|2278->781|2307->792|2320->797|2359->798|2405->811|2448->819|2588->936|2629->942|2735->1026|2915->1170|2935->1181|3006->1230|3318->1507|3351->1531|3370->1541|3418->1551|3484->1581|3498->1586|3528->1594|3570->1605|3739->1738|3798->1788|3838->1790|3867->1801|3880->1806|3919->1807|3965->1820|4008->1828|4129->1926|4170->1932|4285->2025|4512->2216|4532->2227|4616->2289|4929->2567|4970->2599|4989->2609|5037->2619|5103->2649|5117->2654|5147->2662|5189->2673|5363->2811|5409->2848|5449->2850|5478->2861|5491->2866|5530->2867|5575->2880|5618->2888|5713->2961|5754->2967|5782->2986|5801->2996|5849->3006|5911->3032|5925->3037|5955->3045|5994->3052|6170->3192|6218->3231|6258->3233|6287->3244|6300->3249|6339->3250|6384->3263|6427->3271|6526->3348|6567->3354|6597->3375|6616->3385|6664->3395|6726->3421|6740->3426|6770->3434|6809->3441|6959->3555|7005->3592|7045->3594|7074->3605|7087->3610|7126->3611|7171->3624|7214->3632|7379->3774|7420->3780|7448->3799|7467->3809|7515->3819|7577->3845|7591->3850|7621->3858|7661->3866|8149->4325|8179->4326|8242->4360|8272->4361|8319->4379|8349->4380|8519->4521|8549->4522|8642->4586|8672->4587|8705->4592|8734->4593|8831->4662|8860->4663|8927->4701|8957->4702|9004->4720|9034->4721|9224->4882|9254->4883|9348->4948|9378->4949|9411->4954|9440->4955|9538->5025|9567->5026|9597->5028|9626->5029
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|41->13|41->13|41->13|41->13|42->14|42->14|47->19|47->19|51->23|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|57->29|57->29|57->29|67->39|67->39|67->39|67->39|68->40|68->40|68->40|69->41|73->45|73->45|73->45|73->45|73->45|73->45|73->45|74->46|74->46|75->47|75->47|81->53|81->53|81->53|90->62|90->62|90->62|90->62|91->63|91->63|91->63|92->64|99->71|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|101->73|101->73|101->73|101->73|101->73|101->73|101->73|101->73|107->79|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|109->81|109->81|109->81|109->81|109->81|109->81|109->81|109->81|114->86|114->86|114->86|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|129->101|129->101|130->102|130->102|131->103|131->103|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114|144->116|144->116|145->117|145->117|151->123|151->123|153->125|153->125|154->126|154->126|156->128|156->128|157->129|157->129
                    -- GENERATED --
                */
            