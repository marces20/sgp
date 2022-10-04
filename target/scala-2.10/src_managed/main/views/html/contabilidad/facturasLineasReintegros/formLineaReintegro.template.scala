
package views.html.contabilidad.facturasLineasReintegros

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
object formLineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[FacturaLineaReintegro],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[FacturaLineaReintegro]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/(""" 

 

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$('#searchCuentaModalReintegro').modalSearch();
	$('#searchCuentaAnaliticaModalReintegro').modalSearch();
	$('#searchCuentaImpuestoModalReintegro').modalSearch();
	$("#monto").numeric_input();
	
"""),format.raw/*19.1*/("""}"""),format.raw/*19.2*/(""");
</script>

<div class="row">
	"""),_display_(Seq[Any](/*23.3*/inputText(lineaForm("factura_id"), 'type -> "hidden"))),format.raw/*23.56*/("""
	<div class="col-sm-4">
		<label for="cuenta" class="control-label">Cuenta</label>
		<div class="input-group """),_display_(Seq[Any](/*26.28*/if(lineaForm.error("cuenta_id") != null)/*26.68*/ {_display_(Seq[Any](format.raw/*26.70*/("""has-error""")))}/*26.81*/else/*26.86*/{_display_(Seq[Any](format.raw/*26.87*/("""has-required""")))})),format.raw/*26.100*/("""">
																					 
			"""),_display_(Seq[Any](/*28.5*/inputText(lineaForm("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal_reintegro"))),format.raw/*28.101*/("""
			"""),_display_(Seq[Any](/*29.5*/inputText(lineaForm("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal_reintegro"))),format.raw/*29.94*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaModalReintegro" 
								
							data-title="Selección de cuenta" 
							data-url=""""),_display_(Seq[Any](/*35.19*/controllers/*35.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*35.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_modal_reintegro" 
							data-field="#cuenta_id_modal_reintegro">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*45.4*/lineaForm("cuenta_id")/*45.26*/.error.map/*45.36*/{ error =>_display_(Seq[Any](format.raw/*45.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*46.29*/error/*46.34*/.message)),format.raw/*46.42*/("""</div>
		""")))})),format.raw/*47.4*/("""
	</div>
	<div class="col-sm-4">
		<label for="cuenta" class="control-label">Cuenta Presupuestaria</label>
		<div class="input-group """),_display_(Seq[Any](/*51.28*/if(lineaForm.error("cuenta_id") != null)/*51.68*/ {_display_(Seq[Any](format.raw/*51.70*/("""has-error""")))}/*51.81*/else/*51.86*/{_display_(Seq[Any](format.raw/*51.87*/("""has-required""")))})),format.raw/*51.100*/("""">
			
			"""),_display_(Seq[Any](/*53.5*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'id -> "cuenta_analitica_modal_reintegro"))),format.raw/*53.120*/("""
			"""),_display_(Seq[Any](/*54.5*/inputText(lineaForm("cuenta_analitica_id"),'hidden -> "hidden", 'id -> "cuenta_analitica_id_modal_reintegro"))),format.raw/*54.114*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaAnaliticaModalReintegro" 
							data-title="Selección de cuenta Presupuestaria" 
							data-url=""""),_display_(Seq[Any](/*59.19*/controllers/*59.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*59.92*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuentaAnalitica.simple" 
							data-label="#cuenta_analitica_modal_reintegro" 
							data-field="#cuenta_analitica_id_modal_reintegro">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*69.4*/lineaForm("cuenta_analitica_id")/*69.36*/.error.map/*69.46*/{ error =>_display_(Seq[Any](format.raw/*69.56*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*70.29*/error/*70.34*/.message)),format.raw/*70.42*/("""</div>
		""")))})),format.raw/*71.4*/("""
	</div>
	<div class="col-sm-4">
		<label for="cuenta" class="control-label">Cuenta Impuesto</label>
		<div class="input-group ">
			
			"""),_display_(Seq[Any](/*77.5*/inputText(lineaForm("cuentaImpuesto.nombre"), 'class -> "form-control", 'id -> "cuenta_impuesto_modal_reintegro"))),format.raw/*77.118*/("""
			"""),_display_(Seq[Any](/*78.5*/inputText(lineaForm("cuenta_impuesto_id"),'hidden -> "hidden", 'id -> "cuenta_impuesto_id_modal_reintegro"))),format.raw/*78.112*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchCuentaImpuestoModalReintegro" 
								
							data-title="Selección de cuenta" 
							data-url=""""),_display_(Seq[Any](/*84.19*/controllers/*84.30*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*84.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.cuenta.simple" 
							data-label="#cuenta_impuesto_modal_reintegro" 
							data-field="#cuenta_impuesto_id_modal_reintegro">
					<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div> 
	</div>
	
</div>	
<div class="row">	
	<div class="col-sm-3">
		<label class="control-label">Importe</label>
		<div class="form-group """),_display_(Seq[Any](/*100.27*/if(lineaForm.error("monto") != null)/*100.63*/ {_display_(Seq[Any](format.raw/*100.65*/("""has-error""")))}/*100.76*/else/*100.81*/{_display_(Seq[Any](format.raw/*100.82*/("""has-required""")))})),format.raw/*100.95*/("""">
			"""),_display_(Seq[Any](/*101.5*/inputText(lineaForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*101.76*/("""
			"""),_display_(Seq[Any](/*102.5*/lineaForm("monto")/*102.23*/.error.map/*102.33*/{ error =>_display_(Seq[Any](format.raw/*102.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*102.69*/error/*102.74*/.message)),format.raw/*102.82*/("""</div>""")))})),format.raw/*102.89*/("""
		</div>
	</div>
	<div class="col-sm-9">
		<label for="Descripción" class="control-label">Descripción</label>
		<div class="input-group """),_display_(Seq[Any](/*107.28*/if(lineaForm.error("descripcion") != null)/*107.70*/ {_display_(Seq[Any](format.raw/*107.72*/("""has-error""")))})),format.raw/*107.82*/("""">
			"""),_display_(Seq[Any](/*108.5*/textarea(lineaForm("descripcion"), 'class -> "form-control", 'id -> "descripcion", 'rows -> "3", 'cols -> "50"))),format.raw/*108.116*/("""
			"""),_display_(Seq[Any](/*109.5*/lineaForm("descripcion")/*109.29*/.error.map/*109.39*/{ error =>_display_(Seq[Any](format.raw/*109.49*/(""" <div class="text-error">"""),_display_(Seq[Any](/*109.75*/error/*109.80*/.message)),format.raw/*109.88*/("""</div>""")))})),format.raw/*109.95*/("""
		</div>
	</div>	
</div>
 
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*121.14*/("""{"""),format.raw/*121.15*/("""

	if($("#cuenta_modal_reintegro").length)"""),format.raw/*123.41*/("""{"""),format.raw/*123.42*/("""
		var options = """),format.raw/*124.17*/("""{"""),format.raw/*124.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*130.30*/("""{"""),format.raw/*130.31*/(""" 
											$("#cuenta_id_modal_reintegro").val(obj.id); 
										 """),format.raw/*132.12*/("""}"""),format.raw/*132.13*/("""
			"""),format.raw/*133.4*/("""}"""),format.raw/*133.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_modal_reintegro', options);
	"""),format.raw/*135.2*/("""}"""),format.raw/*135.3*/("""
 
	if($("#cuenta_impuesto_modal_reintegro").length)"""),format.raw/*137.50*/("""{"""),format.raw/*137.51*/("""
		var options = """),format.raw/*138.17*/("""{"""),format.raw/*138.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*144.30*/("""{"""),format.raw/*144.31*/(""" 
											$("#cuenta_impuesto_id_modal_reintegro").val(obj.id); 
										 """),format.raw/*146.12*/("""}"""),format.raw/*146.13*/("""
			"""),format.raw/*147.4*/("""}"""),format.raw/*147.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_impuesto_modal_reintegro', options);
	"""),format.raw/*149.2*/("""}"""),format.raw/*149.3*/("""
	if($("#cuenta_analitica_modal_reintegro").length)"""),format.raw/*150.51*/("""{"""),format.raw/*150.52*/("""
		var options = """),format.raw/*151.17*/("""{"""),format.raw/*151.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*157.30*/("""{"""),format.raw/*157.31*/(""" 
											$("#cuenta_analitica_id_modal_reintegro").val(obj.id); 
										 """),format.raw/*159.12*/("""}"""),format.raw/*159.13*/("""
			"""),format.raw/*160.4*/("""}"""),format.raw/*160.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_analitica_modal_reintegro', options);
	"""),format.raw/*162.2*/("""}"""),format.raw/*162.3*/("""
"""),format.raw/*163.1*/("""}"""),format.raw/*163.2*/(""");
</script>	


"""),_display_(Seq[Any](/*167.2*/flash()/*167.9*/.clear())))}
    }
    
    def render(lineaForm:Form[FacturaLineaReintegro]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[FacturaLineaReintegro]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/formLineaReintegro.scala.html
                    HASH: ae32c53c33774ce577e0ddcb9d7b88bb8bae1005
                    MATRIX: 846->1|989->62|1021->86|1095->41|1124->130|1169->141|1207->171|1246->173|1369->261|1382->266|1416->279|1459->291|1511->315|1540->316|1770->519|1798->520|1871->558|1946->611|2096->725|2145->765|2185->767|2214->778|2227->783|2266->784|2312->797|2379->829|2498->925|2539->931|2650->1020|2873->1207|2893->1218|2967->1270|3291->1559|3322->1581|3341->1591|3389->1601|3455->1631|3469->1636|3499->1644|3541->1655|3715->1793|3764->1833|3804->1835|3833->1846|3846->1851|3885->1852|3931->1865|3979->1878|4117->1993|4158->1999|4290->2108|4527->2309|4547->2320|4631->2382|4984->2700|5025->2732|5044->2742|5092->2752|5158->2782|5172->2787|5202->2795|5244->2806|5423->2950|5559->3063|5600->3069|5730->3176|5961->3371|5981->3382|6055->3434|6537->3879|6583->3915|6624->3917|6654->3928|6668->3933|6708->3934|6754->3947|6798->3955|6892->4026|6934->4032|6962->4050|6982->4060|7031->4070|7094->4096|7109->4101|7140->4109|7180->4116|7360->4259|7412->4301|7453->4303|7496->4313|7540->4321|7675->4432|7717->4438|7751->4462|7771->4472|7820->4482|7883->4508|7898->4513|7929->4521|7969->4528|8381->4911|8411->4912|8484->4956|8514->4957|8561->4975|8591->4976|8772->5128|8802->5129|8903->5201|8933->5202|8966->5207|8995->5208|9100->5285|9129->5286|9212->5340|9242->5341|9289->5359|9319->5360|9500->5512|9530->5513|9640->5594|9670->5595|9703->5600|9732->5601|9846->5687|9875->5688|9956->5740|9986->5741|10033->5759|10063->5760|10253->5921|10283->5922|10394->6004|10424->6005|10457->6010|10486->6011|10601->6098|10630->6099|10660->6101|10689->6102|10746->6123|10762->6130
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|47->19|47->19|51->23|51->23|54->26|54->26|54->26|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|63->35|63->35|63->35|73->45|73->45|73->45|73->45|74->46|74->46|74->46|75->47|79->51|79->51|79->51|79->51|79->51|79->51|79->51|81->53|81->53|82->54|82->54|87->59|87->59|87->59|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|105->77|105->77|106->78|106->78|112->84|112->84|112->84|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|130->102|130->102|130->102|130->102|130->102|130->102|130->102|130->102|135->107|135->107|135->107|135->107|136->108|136->108|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|149->121|149->121|151->123|151->123|152->124|152->124|158->130|158->130|160->132|160->132|161->133|161->133|163->135|163->135|165->137|165->137|166->138|166->138|172->144|172->144|174->146|174->146|175->147|175->147|177->149|177->149|178->150|178->150|179->151|179->151|185->157|185->157|187->159|187->159|188->160|188->160|190->162|190->162|191->163|191->163|195->167|195->167
                    -- GENERATED --
                */
            