
package views.html.dashboard.ultimasCotizaciones

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
object formUltimaCotizaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[UltimaCotizacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(coForm: Form[UltimaCotizacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*4.70*/(""" 
	
<script>	
$(function()"""),format.raw/*7.13*/("""{"""),format.raw/*7.14*/("""
	 
	$("#cotizacion").numeric_input("""),format.raw/*9.33*/("""{"""),format.raw/*9.34*/("""allowNegative: true"""),format.raw/*9.53*/("""}"""),format.raw/*9.54*/(""");
"""),format.raw/*10.1*/("""}"""),format.raw/*10.2*/(""");
</script>	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar cotizacion"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*16.17*/if(request().getHeader("referer"))/*16.51*/{_display_(Seq[Any](format.raw/*16.52*/(""" """),_display_(Seq[Any](/*16.54*/request()/*16.63*/.getHeader("referer"))),format.raw/*16.84*/(""" """)))}/*16.87*/else/*16.92*/{_display_(Seq[Any](_display_(Seq[Any](/*16.94*/controllers/*16.105*/.dashboard.routes.UltimasCotizacionesController.indexUltimaCotizaciones())),_display_(Seq[Any](/*16.179*/UriTrack/*16.187*/.decode()))))})),format.raw/*16.197*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
		 </div>
	</div>
	
	
	"""),_display_(Seq[Any](/*23.3*/inputText(coForm("id"), 'type -> "hidden", 'id -> "coId"))),format.raw/*23.60*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*24.29*/UriTrack/*24.37*/.getKey())),format.raw/*24.46*/(""" value=""""),_display_(Seq[Any](/*24.55*/UriTrack/*24.63*/.code())),format.raw/*24.70*/("""" />
	<div class="row">
		<div class="col-sm-3">
			<label class="control-label">Cotizacion</label>
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(coForm.error("cotizacion") != null)/*28.66*/ {_display_(Seq[Any](format.raw/*28.68*/("""has-error""")))}/*28.79*/else/*28.84*/{_display_(Seq[Any](format.raw/*28.85*/("""has-required""")))})),format.raw/*28.98*/("""">
				"""),_display_(Seq[Any](/*29.6*/inputText(coForm("cotizacion"), 'class -> "form-control",'id -> "cotizacion"))),format.raw/*29.83*/("""
				
			</div>
			"""),_display_(Seq[Any](/*32.5*/coForm("cotizacion")/*32.25*/.error.map/*32.35*/{ error =>_display_(Seq[Any](format.raw/*32.45*/(""" <div class="text-error">"""),_display_(Seq[Any](/*32.71*/error/*32.76*/.message)),format.raw/*32.84*/("""</div>""")))})),format.raw/*32.91*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<div class="form-group """),_display_(Seq[Any](/*36.28*/if(coForm.error("fecha")  != null)/*36.62*/ {_display_(Seq[Any](format.raw/*36.64*/("""has-error""")))}/*36.74*/else/*36.79*/{_display_(Seq[Any](format.raw/*36.80*/("""has-required""")))})),format.raw/*36.93*/("""">
				"""),_display_(Seq[Any](/*37.6*/inputText(coForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*37.86*/("""
			</div>
			"""),_display_(Seq[Any](/*39.5*/coForm("fecha")/*39.20*/.error.map/*39.30*/{ error =>_display_(Seq[Any](format.raw/*39.40*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*40.30*/error/*40.35*/.message)),format.raw/*40.43*/("""</div>
			""")))})),format.raw/*41.5*/("""
		</div> 
		<div class="col-sm-3">
			<label class="control-label">Moneda</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*46.6*/select(coForm("tipo_moneda"),TipoMoneda.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*46.156*/("""
				"""),_display_(Seq[Any](/*47.6*/coForm("tipo_moneda")/*47.27*/.error.map/*47.37*/{ error =>_display_(Seq[Any](format.raw/*47.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*48.31*/error/*48.36*/.message)),format.raw/*48.44*/("""</div>
				""")))})),format.raw/*49.6*/("""
			</div>
		</div>
				
	</div>
	
	 		
		
		
		
		
	
"""))}
    }
    
    def render(coForm:Form[UltimaCotizacion]): play.api.templates.HtmlFormat.Appendable = apply(coForm)
    
    def f:((Form[UltimaCotizacion]) => play.api.templates.HtmlFormat.Appendable) = (coForm) => apply(coForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/ultimasCotizaciones/formUltimaCotizaciones.scala.html
                    HASH: 3e998a782777eed2275adf62b834f61bb7b76984
                    MATRIX: 837->1|987->68|1019->92|1093->33|1121->136|1174->162|1202->163|1265->199|1293->200|1339->219|1367->220|1397->223|1425->224|1728->491|1771->525|1810->526|1848->528|1866->537|1909->558|1930->561|1943->566|1991->568|2012->579|2117->653|2135->661|2172->671|2381->845|2460->902|2525->931|2542->939|2573->948|2618->957|2635->965|2664->972|2827->1099|2874->1137|2914->1139|2943->1150|2956->1155|2995->1156|3040->1169|3083->1177|3182->1254|3237->1274|3266->1294|3285->1304|3333->1314|3395->1340|3409->1345|3439->1353|3478->1360|3623->1469|3666->1503|3706->1505|3735->1515|3748->1520|3787->1521|3832->1534|3875->1542|3977->1622|4027->1637|4051->1652|4070->1662|4118->1672|4184->1702|4198->1707|4228->1715|4270->1726|4421->1842|4594->1992|4635->1998|4665->2019|4684->2029|4732->2039|4799->2070|4813->2075|4843->2083|4886->2095
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|38->9|38->9|38->9|38->9|39->10|39->10|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|57->28|57->28|57->28|57->28|57->28|57->28|57->28|58->29|58->29|61->32|61->32|61->32|61->32|61->32|61->32|61->32|61->32|65->36|65->36|65->36|65->36|65->36|65->36|65->36|66->37|66->37|68->39|68->39|68->39|68->39|69->40|69->40|69->40|70->41|75->46|75->46|76->47|76->47|76->47|76->47|77->48|77->48|77->48|78->49
                    -- GENERATED --
                */
            