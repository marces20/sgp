
package views.html.recupero.recuperoNotaCredito

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
object formLineaNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoNotaCredito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[models.recupero.RecuperoNotaCredito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 

<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("plugins/jquery.numeric_input.min.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>

"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$('#searchProductoModal,#searchPlanilla').modalSearch();
	$("#cantidad").numeric_input();
	$("#precio").numeric_input("""),format.raw/*16.29*/("""{"""),format.raw/*16.30*/("""allowNegative: true"""),format.raw/*16.49*/("""}"""),format.raw/*16.50*/(""");
	$("#fecha_nc").mask("99/99/9999");
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/(""");

</script>

 <div class="row">
	"""),_display_(Seq[Any](/*23.3*/inputText(lineaForm("recupero_factura_id"), 'type -> "hidden"))),format.raw/*23.65*/("""
	<div class="col-sm-3">
	 	<label class="control-label">Numero</label> 
		<div class="input-group """),_display_(Seq[Any](/*26.28*/if(lineaForm.error("numero") != null)/*26.65*/ {_display_(Seq[Any](format.raw/*26.67*/("""has-error""")))}/*26.77*/else/*26.81*/{_display_(Seq[Any](format.raw/*26.82*/("""has-required""")))})),format.raw/*26.95*/("""">
		    <span class="input-group-btn">
		    <i class="input-group-addon" style="display:none"></i>
		      """),_display_(Seq[Any](/*29.10*/inputText(lineaForm("numero"), 'class -> "form-control",'id->"numero_nc"))),format.raw/*29.83*/("""
		    </span>
	  	</div>	
	</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha</label> 
		<div class="form-group """),_display_(Seq[Any](/*35.27*/if(lineaForm.error("fecha")  != null)/*35.64*/ {_display_(Seq[Any](format.raw/*35.66*/("""has-error""")))}/*35.76*/else/*35.80*/{_display_(Seq[Any](format.raw/*35.81*/("""has-required""")))})),format.raw/*35.94*/("""">
			"""),_display_(Seq[Any](/*36.5*/inputText(lineaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off",'id->"fecha_nc"))),format.raw/*36.104*/("""
		</div>
		"""),_display_(Seq[Any](/*38.4*/lineaForm("fecha")/*38.22*/.error.map/*38.32*/{ error =>_display_(Seq[Any](format.raw/*38.42*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*39.29*/error/*39.34*/.message)),format.raw/*39.42*/("""</div>
		""")))})),format.raw/*40.4*/("""
	</div>
	<div class="col-sm-6">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*44.28*/if(lineaForm.error("producto_id") != null)/*44.70*/ {_display_(Seq[Any](format.raw/*44.72*/("""has-error""")))}/*44.83*/else/*44.88*/{_display_(Seq[Any](format.raw/*44.89*/("""has-required""")))})),format.raw/*44.102*/("""">
			"""),_display_(Seq[Any](/*45.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*45.122*/("""
			"""),_display_(Seq[Any](/*46.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id_modal"))),format.raw/*46.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*50.19*/controllers/*50.30*/.compras.routes.ProductosController.modalBuscarIps())),format.raw/*50.82*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#producto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*60.4*/lineaForm("producto_id")/*60.28*/.error.map/*60.38*/{ error =>_display_(Seq[Any](format.raw/*60.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*61.29*/error/*61.34*/.message)),format.raw/*61.42*/("""</div>
		""")))})),format.raw/*62.4*/("""
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
		
	<div class="col-sm-2">
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
	<div class="col-sm-2">
		<label for="planilla" class="control-label">Planilla</label> 
		<div class="input-group """),_display_(Seq[Any](/*93.28*/if(lineaForm.error("planilla_id") != null)/*93.70*/ {_display_(Seq[Any](format.raw/*93.72*/("""has-error""")))}/*93.82*/else/*93.86*/{_display_(Seq[Any](format.raw/*93.87*/("""has-required""")))})),format.raw/*93.100*/("""">
			"""),_display_(Seq[Any](/*94.5*/inputText(lineaForm("planilla.recuperoPlanillaEjercicio"),'class -> "form-control", 'id -> "planilla"))),format.raw/*94.107*/("""
			"""),_display_(Seq[Any](/*95.5*/inputText(lineaForm("planilla_id"),'hidden -> "hidden", 'id -> "planilla_id"))),format.raw/*95.82*/("""

			<span class="input-group-addon">
			<a href="#" 
			id="searchPlanilla" data-title="Selección de Planilla" 
			data-url=""""),_display_(Seq[Any](/*100.15*/controllers/*100.26*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*100.84*/("""" 
			data-height="650" data-width="700" 
			data-listen="modal.seleccion.planilla.simple" 
			data-label="#planilla" 
			data-field="#planilla_id">
			<i class="glyphicon glyphicon-search"></i></a></span>
			
		</div>
		"""),_display_(Seq[Any](/*108.4*/lineaForm("planilla_id")/*108.28*/.error.map/*108.38*/{ error =>_display_(Seq[Any](format.raw/*108.48*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*109.30*/error/*109.35*/.message)),format.raw/*109.43*/("""</div>
			""")))})),format.raw/*110.5*/("""
	</div>
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*122.14*/("""{"""),format.raw/*122.15*/("""
	if($("#planilla").length)"""),format.raw/*123.27*/("""{"""),format.raw/*123.28*/("""
		var options = """),format.raw/*124.17*/("""{"""),format.raw/*124.18*/("""
				script:"/recupero/suggestRecuperoPlanilla/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*130.30*/("""{"""),format.raw/*130.31*/(""" 		
											$("#planilla_id").val(obj.id); 
										 """),format.raw/*132.12*/("""}"""),format.raw/*132.13*/("""
			"""),format.raw/*133.4*/("""}"""),format.raw/*133.5*/(""";
		var as_json = new bsn.AutoSuggest('planilla', options);
	"""),format.raw/*135.2*/("""}"""),format.raw/*135.3*/("""
	if($("#producto_modal").length)"""),format.raw/*136.33*/("""{"""),format.raw/*136.34*/("""
		var options = """),format.raw/*137.17*/("""{"""),format.raw/*137.18*/("""
				script:"/suggestProductoPresupuesto/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*143.30*/("""{"""),format.raw/*143.31*/(""" 
											$("#producto_id_modal").val(obj.id); 
										 """),format.raw/*145.12*/("""}"""),format.raw/*145.13*/("""
			"""),format.raw/*146.4*/("""}"""),format.raw/*146.5*/(""";
		var as_json = new bsn.AutoSuggest('producto_modal', options);
	"""),format.raw/*148.2*/("""}"""),format.raw/*148.3*/("""
"""),format.raw/*149.1*/("""}"""),format.raw/*149.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[models.recupero.RecuperoNotaCredito]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[models.recupero.RecuperoNotaCredito]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoNotaCredito/formLineaNotaCredito.scala.html
                    HASH: 60c583ed3e434e182cca84bd9f1fbf74b7b3c957
                    MATRIX: 853->1|1010->76|1042->100|1116->55|1145->144|1199->163|1213->169|1283->218|1356->257|1394->287|1433->289|1556->377|1569->382|1603->395|1646->407|1698->431|1727->432|1878->555|1907->556|1954->575|1983->576|2051->617|2079->618|2155->659|2239->721|2378->824|2424->861|2464->863|2493->873|2506->877|2545->878|2590->891|2739->1004|2834->1077|3007->1214|3053->1251|3093->1253|3122->1263|3135->1267|3174->1268|3219->1281|3262->1289|3384->1388|3434->1403|3461->1421|3480->1431|3528->1441|3594->1471|3608->1476|3638->1484|3680->1495|3850->1629|3901->1671|3941->1673|3970->1684|3983->1689|4022->1690|4068->1703|4111->1711|4251->1828|4292->1834|4398->1918|4578->2062|4598->2073|4672->2125|4984->2402|5017->2426|5036->2436|5084->2446|5150->2476|5164->2481|5194->2489|5236->2500|5416->2644|5462->2681|5502->2683|5531->2694|5544->2699|5583->2700|5628->2713|5671->2721|5766->2794|5807->2800|5835->2819|5854->2829|5902->2839|5964->2865|5978->2870|6008->2878|6047->2885|6223->3025|6271->3064|6311->3066|6340->3077|6353->3082|6392->3083|6437->3096|6480->3104|6579->3181|6620->3187|6650->3208|6669->3218|6717->3228|6779->3254|6793->3259|6823->3267|6862->3274|7012->3388|7058->3425|7098->3427|7127->3438|7140->3443|7179->3444|7224->3457|7267->3465|7432->3607|7473->3613|7501->3632|7520->3642|7568->3652|7630->3678|7644->3683|7674->3691|7714->3699|7888->3837|7939->3879|7979->3881|8008->3891|8021->3895|8060->3896|8106->3909|8149->3917|8274->4019|8315->4025|8414->4102|8583->4234|8604->4245|8685->4303|8951->4533|8985->4557|9005->4567|9054->4577|9122->4608|9137->4613|9168->4621|9212->4633|9655->5047|9685->5048|9742->5076|9772->5077|9819->5095|9849->5096|10036->5254|10066->5255|10155->5315|10185->5316|10218->5321|10247->5322|10338->5385|10367->5386|10430->5420|10460->5421|10507->5439|10537->5440|10718->5592|10748->5593|10841->5657|10871->5658|10904->5663|10933->5664|11030->5733|11059->5734|11089->5736|11118->5737
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|44->16|44->16|44->16|44->16|46->18|46->18|51->23|51->23|54->26|54->26|54->26|54->26|54->26|54->26|54->26|57->29|57->29|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|66->38|66->38|66->38|66->38|67->39|67->39|67->39|68->40|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|73->45|74->46|74->46|78->50|78->50|78->50|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|99->71|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|101->73|101->73|101->73|101->73|101->73|101->73|101->73|101->73|107->79|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|109->81|109->81|109->81|109->81|109->81|109->81|109->81|109->81|114->86|114->86|114->86|114->86|114->86|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|121->93|121->93|121->93|121->93|121->93|121->93|121->93|122->94|122->94|123->95|123->95|128->100|128->100|128->100|136->108|136->108|136->108|136->108|137->109|137->109|137->109|138->110|150->122|150->122|151->123|151->123|152->124|152->124|158->130|158->130|160->132|160->132|161->133|161->133|163->135|163->135|164->136|164->136|165->137|165->137|171->143|171->143|173->145|173->145|174->146|174->146|176->148|176->148|177->149|177->149
                    -- GENERATED --
                */
            