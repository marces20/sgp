
package views.html.haberes.liquidacionConceptos

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
object formLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConcepto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(conceptoForm: Form[models.haberes.LiquidacionConcepto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*6.70*/(""" 
<script>
$( function()"""),format.raw/*8.14*/("""{"""),format.raw/*8.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*8.48*/("""}"""),format.raw/*8.49*/(""")
</script>	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar concepto"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*13.14*/if(request().getHeader("referer"))/*13.48*/{_display_(Seq[Any](format.raw/*13.49*/(""" """),_display_(Seq[Any](/*13.51*/request()/*13.60*/.getHeader("referer"))),format.raw/*13.81*/(""" """)))}/*13.84*/else/*13.89*/{_display_(Seq[Any](_display_(Seq[Any](/*13.91*/controllers/*13.102*/.haberes.routes.LiquidacionConceptosController.index())),_display_(Seq[Any](/*13.157*/UriTrack/*13.165*/.decode()))))})),format.raw/*13.175*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*16.14*/UriTrack/*16.22*/.decode())),format.raw/*16.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*17.5*/if(conceptoForm.field("id").value)/*17.39*/{_display_(Seq[Any](format.raw/*17.40*/("""<a href=""""),_display_(Seq[Any](/*17.50*/controllers/*17.61*/.haberes.routes.LiquidacionConceptosController.ver(conceptoForm.field("id").value.toLong))),_display_(Seq[Any](/*17.151*/UriTrack/*17.159*/.get("&"))),format.raw/*17.168*/("""" title="Ver concepto" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*17.269*/("""
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*22.28*/if(conceptoForm.error("codigo") != null)/*22.68*/ {_display_(Seq[Any](format.raw/*22.70*/("""has-error""")))}/*22.80*/else/*22.84*/{_display_(Seq[Any](format.raw/*22.85*/("""has-required""")))})),format.raw/*22.98*/("""">
				<label for="inputCodigo" class="control-label">Codigo</label> 
				
				"""),_display_(Seq[Any](/*25.6*/if(conceptoForm.field("id").value)/*25.40*/{_display_(Seq[Any](format.raw/*25.41*/("""
					"""),_display_(Seq[Any](/*26.7*/inputText(conceptoForm("codigo"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*26.90*/("""
				""")))}/*27.6*/else/*27.10*/{_display_(Seq[Any](format.raw/*27.11*/("""
					"""),_display_(Seq[Any](/*28.7*/inputText(conceptoForm("codigo"), 'class -> "form-control"))),format.raw/*28.66*/("""
					"""),_display_(Seq[Any](/*29.7*/conceptoForm("codigo")/*29.29*/.error.map/*29.39*/{ error =>_display_(Seq[Any](format.raw/*29.49*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*30.32*/error/*30.37*/.message)),format.raw/*30.45*/("""</div>
					""")))})),format.raw/*31.7*/("""
				""")))})),format.raw/*32.6*/("""
				
			</div>
		</div>
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*37.28*/if(conceptoForm.error("denominacion") != null)/*37.74*/ {_display_(Seq[Any](format.raw/*37.76*/("""has-error""")))}/*37.86*/else/*37.90*/{_display_(Seq[Any](format.raw/*37.91*/("""has-required""")))})),format.raw/*37.104*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				
				"""),_display_(Seq[Any](/*40.6*/if(conceptoForm.field("id").value)/*40.40*/{_display_(Seq[Any](format.raw/*40.41*/("""
					"""),_display_(Seq[Any](/*41.7*/inputText(conceptoForm("denominacion"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*41.96*/("""
				""")))}/*42.6*/else/*42.10*/{_display_(Seq[Any](format.raw/*42.11*/("""
					"""),_display_(Seq[Any](/*43.7*/inputText(conceptoForm("denominacion"), 'class -> "form-control"))),format.raw/*43.72*/("""
					"""),_display_(Seq[Any](/*44.7*/conceptoForm("denominacion")/*44.35*/.error.map/*44.45*/{ error =>_display_(Seq[Any](format.raw/*44.55*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*45.32*/error/*45.37*/.message)),format.raw/*45.45*/("""</div>
					""")))})),format.raw/*46.7*/("""
				""")))})),format.raw/*47.6*/("""
				
			</div>
		</div>
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*52.28*/if(conceptoForm.error("abreviatura") != null)/*52.73*/ {_display_(Seq[Any](format.raw/*52.75*/("""has-error""")))})),format.raw/*52.85*/("""">
				<label for="inputDenominacion" class="control-label">Abreviatura</label> 
				"""),_display_(Seq[Any](/*54.6*/inputText(conceptoForm("abreviatura"), 'class -> "form-control"))),format.raw/*54.70*/("""
				"""),_display_(Seq[Any](/*55.6*/conceptoForm("abreviatura")/*55.33*/.error.map/*55.43*/{ error =>_display_(Seq[Any](format.raw/*55.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*56.31*/error/*56.36*/.message)),format.raw/*56.44*/("""</div>
				""")))})),format.raw/*57.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*63.28*/if(conceptoForm.error("fecha_baja") != null)/*63.72*/ {_display_(Seq[Any](format.raw/*63.74*/("""has-error""")))})),format.raw/*63.84*/("""">
				<label for="fecha_baja" class="control-label">Fecha baja</label> 
				"""),_display_(Seq[Any](/*65.6*/inputText(conceptoForm("fecha_baja"),'class -> "form-control date", 'id -> "fecha_baja"))),format.raw/*65.94*/("""
			</div>
		</div>
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*69.28*/if(conceptoForm.error("liquidacion_concepto_tipo_id") != null)/*69.90*/ {_display_(Seq[Any](format.raw/*69.92*/("""has-error""")))}/*69.102*/else/*69.106*/{_display_(Seq[Any](format.raw/*69.107*/("""has-required""")))})),format.raw/*69.120*/("""">
				<label for="liquidacion_concepto_tipo_id" class="control-label">Tipo</label> 
				
					"""),_display_(Seq[Any](/*72.7*/select(conceptoForm("liquidacion_concepto_tipo_id"), 
					LiquidacionConceptoTipo.find.all().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*74.66*/(""", 
			</div>
			"""),_display_(Seq[Any](/*76.5*/conceptoForm("liquidacion_concepto_tipo_id")/*76.49*/.error.map/*76.59*/{ error =>_display_(Seq[Any](format.raw/*76.69*/("""<div class="text-error">"""),_display_(Seq[Any](/*76.94*/error/*76.99*/.message)),format.raw/*76.107*/("""</div>""")))})),format.raw/*76.114*/("""
		</div>
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*79.28*/if(conceptoForm.error("liquidacion_base_calculo_id") != null)/*79.89*/ {_display_(Seq[Any](format.raw/*79.91*/("""has-error""")))}/*79.101*/else/*79.105*/{_display_(Seq[Any](format.raw/*79.106*/("""has-required""")))})),format.raw/*79.119*/("""">
				<label for="liquidacion_base_calculo_id" class="control-label">Base Calculo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*82.7*/inputText(conceptoForm("liquidacionBaseCalculo.nombre"), 'class -> "form-control", 'id -> "liquidacion_base_calculo"))),format.raw/*82.124*/("""
					"""),_display_(Seq[Any](/*83.7*/inputText(conceptoForm("liquidacion_base_calculo_id"),'hidden -> "hidden", 'id -> "liquidacion_base_calculo_id"))),format.raw/*83.119*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchBaseCalculo" 
									data-title="Selección de base calculo" 
									data-url=""""),_display_(Seq[Any](/*88.21*/controllers/*88.32*/.haberes.routes.LiquidacionBaseCalculosController.modalBuscar())),format.raw/*88.95*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.liquidacion-base-calculo.simple" 
									data-label="#liquidacion_base_calculo" 
									data-field="#liquidacion_base_calculo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
			"""),_display_(Seq[Any](/*99.5*/conceptoForm("liquidacion_base_calculo_id")/*99.48*/.error.map/*99.58*/{ error =>_display_(Seq[Any](format.raw/*99.68*/("""<div class="text-error">"""),_display_(Seq[Any](/*99.93*/error/*99.98*/.message)),format.raw/*99.106*/("""</div>""")))})),format.raw/*99.113*/("""
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*104.28*/if(conceptoForm.error("liquidacion_concepto_clasificacion_id") != null)/*104.99*/ {_display_(Seq[Any](format.raw/*104.101*/("""has-error""")))}/*104.111*/else/*104.115*/{_display_(Seq[Any](format.raw/*104.116*/("""has-required""")))})),format.raw/*104.129*/("""">
				<label for="liquidacion_concepto_clasificacion_id" class="control-label">Clasificacion</label> 
				
					"""),_display_(Seq[Any](/*107.7*/select(conceptoForm("liquidacion_concepto_clasificacion_id"), 
					LiquidacionConceptoClasificacion.find.all().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*109.66*/("""
			</div>
			"""),_display_(Seq[Any](/*111.5*/conceptoForm("liquidacion_concepto_clasificacion_id")/*111.58*/.error.map/*111.68*/{ error =>_display_(Seq[Any](format.raw/*111.78*/("""<div class="text-error">"""),_display_(Seq[Any](/*111.103*/error/*111.108*/.message)),format.raw/*111.116*/("""</div>""")))})),format.raw/*111.123*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label"> 
				Deduce ganancias
				"""),_display_(Seq[Any](/*116.6*/select(conceptoForm("deduce_ganancias"),options("false"->"NO","true"->"SI"), 'class -> "form-control select"))),format.raw/*116.115*/("""
			</label>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label"> 
				Reporte ganancias
				"""),_display_(Seq[Any](/*123.6*/select(conceptoForm("reporte_ganancias"),options("false"->"NO","true"->"SI"), 'class -> "form-control select"))),format.raw/*123.116*/("""
			</label>
		</div>
	</div>"""))}
    }
    
    def render(conceptoForm:Form[models.haberes.LiquidacionConcepto]): play.api.templates.HtmlFormat.Appendable = apply(conceptoForm)
    
    def f:((Form[models.haberes.LiquidacionConcepto]) => play.api.templates.HtmlFormat.Appendable) = (conceptoForm) => apply(conceptoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/formLiquidacionConcepto.scala.html
                    HASH: f8fa8195cbf8e0870758212cc1f1514da04cff0d
                    MATRIX: 855->1|1076->139|1108->163|1182->57|1210->207|1261->231|1289->232|1349->265|1377->266|1637->490|1680->524|1719->525|1757->527|1775->536|1818->557|1839->560|1852->565|1900->567|1921->578|2007->633|2025->641|2062->651|2258->811|2275->819|2306->828|2443->930|2486->964|2525->965|2571->975|2591->986|2712->1076|2730->1084|2762->1093|2896->1194|3022->1284|3071->1324|3111->1326|3140->1336|3153->1340|3192->1341|3237->1354|3352->1434|3395->1468|3434->1469|3476->1476|3581->1559|3605->1565|3618->1569|3657->1570|3699->1577|3780->1636|3822->1643|3853->1665|3872->1675|3920->1685|3988->1717|4002->1722|4032->1730|4076->1743|4113->1749|4226->1826|4281->1872|4321->1874|4350->1884|4363->1888|4402->1889|4448->1902|4575->1994|4618->2028|4657->2029|4699->2036|4810->2125|4834->2131|4847->2135|4886->2136|4928->2143|5015->2208|5057->2215|5094->2243|5113->2253|5161->2263|5229->2295|5243->2300|5273->2308|5317->2321|5354->2327|5467->2404|5521->2449|5561->2451|5603->2461|5724->2547|5810->2611|5851->2617|5887->2644|5906->2654|5954->2664|6021->2695|6035->2700|6065->2708|6108->2720|6243->2819|6296->2863|6336->2865|6378->2875|6491->2953|6601->3041|6709->3113|6780->3175|6820->3177|6850->3187|6864->3191|6904->3192|6950->3205|7081->3301|7302->3500|7354->3517|7407->3561|7426->3571|7474->3581|7535->3606|7549->3611|7580->3619|7620->3626|7718->3688|7788->3749|7828->3751|7858->3761|7872->3765|7912->3766|7958->3779|8121->3907|8261->4024|8303->4031|8438->4143|8653->4322|8673->4333|8758->4396|9123->4726|9175->4769|9194->4779|9242->4789|9303->4814|9317->4819|9348->4827|9388->4834|9514->4923|9595->4994|9637->4996|9668->5006|9683->5010|9724->5011|9771->5024|9921->5138|10161->5355|10212->5370|10275->5423|10295->5433|10344->5443|10407->5468|10423->5473|10455->5481|10496->5488|10627->5583|10760->5692|10907->5803|11041->5913
                    LINES: 26->1|35->6|35->6|36->1|37->6|39->8|39->8|39->8|39->8|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|47->16|47->16|47->16|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|53->22|53->22|53->22|53->22|53->22|53->22|53->22|56->25|56->25|56->25|57->26|57->26|58->27|58->27|58->27|59->28|59->28|60->29|60->29|60->29|60->29|61->30|61->30|61->30|62->31|63->32|68->37|68->37|68->37|68->37|68->37|68->37|68->37|71->40|71->40|71->40|72->41|72->41|73->42|73->42|73->42|74->43|74->43|75->44|75->44|75->44|75->44|76->45|76->45|76->45|77->46|78->47|83->52|83->52|83->52|83->52|85->54|85->54|86->55|86->55|86->55|86->55|87->56|87->56|87->56|88->57|94->63|94->63|94->63|94->63|96->65|96->65|100->69|100->69|100->69|100->69|100->69|100->69|100->69|103->72|105->74|107->76|107->76|107->76|107->76|107->76|107->76|107->76|107->76|110->79|110->79|110->79|110->79|110->79|110->79|110->79|113->82|113->82|114->83|114->83|119->88|119->88|119->88|130->99|130->99|130->99|130->99|130->99|130->99|130->99|130->99|135->104|135->104|135->104|135->104|135->104|135->104|135->104|138->107|140->109|142->111|142->111|142->111|142->111|142->111|142->111|142->111|142->111|147->116|147->116|154->123|154->123
                    -- GENERATED --
                */
            