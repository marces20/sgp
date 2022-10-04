
package views.html.recupero.recuperoPago.cheques

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
object formDatosCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.Cheque],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(chequeForm: Form[models.recupero.Cheque]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""

<div class="row">
	"""),_display_(Seq[Any](/*10.3*/inputText(chequeForm("id_pago_recupero"), 'hidden -> "hidden"))),format.raw/*10.65*/("""
	"""),_display_(Seq[Any](/*11.3*/inputText(chequeForm("id"), 'type -> "hidden"))),format.raw/*11.49*/("""

	<div class="col-sm-2">
		<label class="control-label">Numero</label> 
		<div class="form-group """),_display_(Seq[Any](/*15.27*/if(chequeForm.error("numero") != null)/*15.65*/  {_display_(Seq[Any](format.raw/*15.68*/("""has-error""")))}/*15.79*/else/*15.84*/{_display_(Seq[Any](format.raw/*15.85*/("""has-required""")))})),format.raw/*15.98*/("""">
			"""),_display_(Seq[Any](/*16.5*/inputText(chequeForm("numero"), 'class -> "form-control", 'id -> "numero"))),format.raw/*16.79*/("""
			
			"""),_display_(Seq[Any](/*18.5*/chequeForm("numero")/*18.25*/.error.map/*18.35*/{ error =>_display_(Seq[Any](format.raw/*18.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*19.30*/error/*19.35*/.message)),format.raw/*19.43*/("""</div>
			""")))})),format.raw/*20.5*/("""
		</div>
	</div>
		
	<div class="col-sm-2">	
		<label class="control-label">Fecha</label> 
		<div class="form-group """),_display_(Seq[Any](/*26.27*/if(chequeForm.error("fecha") != null)/*26.64*/  {_display_(Seq[Any](format.raw/*26.67*/("""has-error""")))}/*26.78*/else/*26.83*/{_display_(Seq[Any](format.raw/*26.84*/("""has-required""")))})),format.raw/*26.97*/("""">
			"""),_display_(Seq[Any](/*27.5*/inputText(chequeForm("fecha"), 'class -> "form-control date"))),format.raw/*27.66*/("""
			
			"""),_display_(Seq[Any](/*29.5*/chequeForm("fecha")/*29.24*/.error.map/*29.34*/{ error =>_display_(Seq[Any](format.raw/*29.44*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*30.30*/error/*30.35*/.message)),format.raw/*30.43*/("""</div>
			""")))})),format.raw/*31.5*/("""
		</div>
		
	</div>
	<div class="col-sm-2">
			<label class="control-label">Monto</label> 
			<div class="form-group """),_display_(Seq[Any](/*37.28*/if(chequeForm.error("monto") != null)/*37.65*/ {_display_(Seq[Any](format.raw/*37.67*/("""has-error""")))}/*37.78*/else/*37.83*/{_display_(Seq[Any](format.raw/*37.84*/("""has-required""")))})),format.raw/*37.97*/("""">
				"""),_display_(Seq[Any](/*38.6*/inputText(chequeForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*38.78*/("""
				"""),_display_(Seq[Any](/*39.6*/chequeForm("monto")/*39.25*/.error.map/*39.35*/{ error =>_display_(Seq[Any](format.raw/*39.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*40.31*/error/*40.36*/.message)),format.raw/*40.44*/("""</div>
				""")))})),format.raw/*41.6*/("""
			</div>
		</div>
	<div class="col-sm-3">
		<div class="seleccionBanco form-group """),_display_(Seq[Any](/*45.42*/if(chequeForm.error("banco_id") != null)/*45.82*/ {_display_(Seq[Any](format.raw/*45.84*/("""has-error""")))}/*45.95*/else/*45.100*/{_display_(Seq[Any](format.raw/*45.101*/("""has-required""")))})),format.raw/*45.114*/("""">
			<label for=""""),_display_(Seq[Any](/*46.17*/chequeForm("banco_id")/*46.39*/.id)),format.raw/*46.42*/("""" class="control-label">Banco</label>
			"""),_display_(Seq[Any](/*47.5*/select(chequeForm("banco_id"), Banco.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*47.152*/("""
			"""),_display_(Seq[Any](/*48.5*/chequeForm("banco_id")/*48.27*/.error.map/*48.37*/{ error =>_display_(Seq[Any](format.raw/*48.47*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*49.30*/error/*49.35*/.message)),format.raw/*49.43*/("""</div>
			""")))})),format.raw/*50.5*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<div class="seleccionSucursal form-group """),_display_(Seq[Any](/*55.45*/if(chequeForm.error("sucursal_banco_id") != null)/*55.94*/ {_display_(Seq[Any](format.raw/*55.96*/("""has-error""")))}/*55.107*/else/*55.112*/{_display_(Seq[Any](format.raw/*55.113*/("""has-required""")))})),format.raw/*55.126*/("""">
			<label for=""""),_display_(Seq[Any](/*56.17*/chequeForm("sucursal_banco_id")/*56.48*/.id)),format.raw/*56.51*/("""" class="control-label">Sucursal</label>
			"""),_display_(Seq[Any](/*57.5*/select(chequeForm("sucursal_banco_id"), 
				chequeForm("banco_id").value match {
					case null => {options()}
					case v if v.matches("\\d+") => {SucursalBanco.getSucursales(v.toInt).map { p => p.id.toString -> p.nombre}}
					case _ => {options()}
				}, 
			'class -> "form-control select", 'id -> "sucursal_banco_id", '_default -> "Seleccionar"))),format.raw/*63.92*/("""
			"""),_display_(Seq[Any](/*64.5*/chequeForm("sucursal_banco_id")/*64.36*/.error.map/*64.46*/{ error =>_display_(Seq[Any](format.raw/*64.56*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*65.30*/error/*65.35*/.message)),format.raw/*65.43*/("""</div>
			""")))})),format.raw/*66.5*/("""
		</div>
	</div>


</div>	

<div class="row">

	<div class="col-sm-12">
		<label for="obs" class="control-label">Observaciones</label> 
		"""),_display_(Seq[Any](/*77.4*/textarea(chequeForm("observaciones"), 'class -> "form-control", 'rows -> "4", 'id -> "obs"))),format.raw/*77.95*/("""
	</div>

</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
"""),_display_(Seq[Any](/*88.2*/flash()/*88.9*/.clear())),format.raw/*88.17*/("""

<script>
$( function() """),format.raw/*91.15*/("""{"""),format.raw/*91.16*/("""
	
	
	$( ".date" ).mask("99/99/9999");
	$("#monto,#numero").numeric_input("""),format.raw/*95.36*/("""{"""),format.raw/*95.37*/("""allowNegative: true"""),format.raw/*95.56*/("""}"""),format.raw/*95.57*/(""");
	/*$('#formDatosCheques').on('submit', function() """),format.raw/*96.51*/("""{"""),format.raw/*96.52*/("""
		var url = $(this).attr("action");
		$.post(url, $(this).serialize(), function(data) """),format.raw/*98.51*/("""{"""),format.raw/*98.52*/("""
			$('#datosCheque').html(data);
		"""),format.raw/*100.3*/("""}"""),format.raw/*100.4*/(""");
		return false;
	"""),format.raw/*102.2*/("""}"""),format.raw/*102.3*/(""");*/
	
	
	urlSucursales  = '"""),_display_(Seq[Any](/*105.21*/controllers/*105.32*/.contabilidad.routes.SucursalBancosController.listOptions())),format.raw/*105.91*/("""';
	
	$('.seleccionBanco .select').on('change', function()"""),format.raw/*107.54*/("""{"""),format.raw/*107.55*/("""
		var id = $(this).find('option:selected').val();
		$('#sucursal_banco_id').find('option:gt(0)').remove();
		
		if(id == "") return false;

		$.get(urlSucursales + '?bancoId='+id, function(data)"""),format.raw/*113.55*/("""{"""),format.raw/*113.56*/("""
			$('#sucursal_banco_id').html(data);
		"""),format.raw/*115.3*/("""}"""),format.raw/*115.4*/(""");
	"""),format.raw/*116.2*/("""}"""),format.raw/*116.3*/(""");		
"""),format.raw/*117.1*/("""}"""),format.raw/*117.2*/(""");
</script>"""))}
    }
    
    def render(chequeForm:Form[models.recupero.Cheque]): play.api.templates.HtmlFormat.Appendable = apply(chequeForm)
    
    def f:((Form[models.recupero.Cheque]) => play.api.templates.HtmlFormat.Appendable) = (chequeForm) => apply(chequeForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/formDatosCheque.scala.html
                    HASH: 54df1ff610e265d4f7c54d22810e69b63ce8662a
                    MATRIX: 836->1|998->81|1030->105|1104->43|1133->149|1175->157|1187->162|1233->187|1293->212|1377->274|1416->278|1484->324|1623->427|1670->465|1711->468|1740->479|1753->484|1792->485|1837->498|1880->506|1976->580|2022->591|2051->611|2070->621|2118->631|2185->662|2199->667|2229->675|2272->687|2432->811|2478->848|2519->851|2548->862|2561->867|2600->868|2645->881|2688->889|2771->950|2817->961|2845->980|2864->990|2912->1000|2979->1031|2993->1036|3023->1044|3066->1056|3227->1181|3273->1218|3313->1220|3342->1231|3355->1236|3394->1237|3439->1250|3483->1259|3577->1331|3619->1338|3647->1357|3666->1367|3714->1377|3782->1409|3796->1414|3826->1422|3870->1435|3995->1524|4044->1564|4084->1566|4113->1577|4127->1582|4167->1583|4213->1596|4269->1616|4300->1638|4325->1641|4403->1684|4573->1831|4614->1837|4645->1859|4664->1869|4712->1879|4779->1910|4793->1915|4823->1923|4866->1935|4994->2027|5052->2076|5092->2078|5122->2089|5136->2094|5176->2095|5222->2108|5278->2128|5318->2159|5343->2162|5424->2208|5803->2565|5844->2571|5884->2602|5903->2612|5951->2622|6018->2653|6032->2658|6062->2666|6105->2678|6291->2829|6404->2920|6830->3311|6845->3318|6875->3326|6931->3354|6960->3355|7066->3433|7095->3434|7142->3453|7171->3454|7253->3508|7282->3509|7399->3598|7428->3599|7494->3637|7523->3638|7573->3660|7602->3661|7671->3693|7692->3704|7774->3763|7863->3823|7893->3824|8123->4025|8153->4026|8225->4070|8254->4071|8287->4076|8316->4077|8350->4083|8379->4084
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|39->10|39->10|40->11|40->11|44->15|44->15|44->15|44->15|44->15|44->15|44->15|45->16|45->16|47->18|47->18|47->18|47->18|48->19|48->19|48->19|49->20|55->26|55->26|55->26|55->26|55->26|55->26|55->26|56->27|56->27|58->29|58->29|58->29|58->29|59->30|59->30|59->30|60->31|66->37|66->37|66->37|66->37|66->37|66->37|66->37|67->38|67->38|68->39|68->39|68->39|68->39|69->40|69->40|69->40|70->41|74->45|74->45|74->45|74->45|74->45|74->45|74->45|75->46|75->46|75->46|76->47|76->47|77->48|77->48|77->48|77->48|78->49|78->49|78->49|79->50|84->55|84->55|84->55|84->55|84->55|84->55|84->55|85->56|85->56|85->56|86->57|92->63|93->64|93->64|93->64|93->64|94->65|94->65|94->65|95->66|106->77|106->77|117->88|117->88|117->88|120->91|120->91|124->95|124->95|124->95|124->95|125->96|125->96|127->98|127->98|129->100|129->100|131->102|131->102|134->105|134->105|134->105|136->107|136->107|142->113|142->113|144->115|144->115|145->116|145->116|146->117|146->117
                    -- GENERATED --
                */
            