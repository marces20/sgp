
package views.html.haberes.liquidacionDetalles

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
object formLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionDetalle],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(detalleForm: Form[models.haberes.LiquidacionDetalle]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 



"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
	$('.searchModal').modalSearch();
	$("#cantidad").numeric_input();
	$("#importe").numeric_input("""),format.raw/*16.30*/("""{"""),format.raw/*16.31*/("""allowNegative: true"""),format.raw/*16.50*/("""}"""),format.raw/*16.51*/(""");
"""),format.raw/*17.1*/("""}"""),format.raw/*17.2*/(""");
</script>
 
<div class="row">
	"""),_display_(Seq[Any](/*21.3*/inputText(detalleForm("liquidacion_puesto_id"), 'type -> "hidden"))),format.raw/*21.69*/("""
	<div class="col-sm-6">
		<label for="concepto_nombre" class="control-label">Concepto</label>
		<div class="input-group """),_display_(Seq[Any](/*24.28*/if(detalleForm.error("liquidacion_concepto_id") != null)/*24.84*/ {_display_(Seq[Any](format.raw/*24.86*/("""has-error""")))}/*24.97*/else/*24.102*/{_display_(Seq[Any](format.raw/*24.103*/("""has-required""")))})),format.raw/*24.116*/("""">
			"""),_display_(Seq[Any](/*25.5*/inputText(detalleForm("liquidacionConcepto.denominacion"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "liquidacion_concepto_modal"))),format.raw/*25.153*/("""
			"""),_display_(Seq[Any](/*26.5*/inputText(detalleForm("liquidacion_concepto_id"), 'hidden -> "hidden", 'id -> "liquidacion_concepto_id_modal"))),format.raw/*26.115*/("""
			<span class="input-group-addon">
				<a href="#" class="searchModal" id="searchProductoModal" 
							data-title="Selección de Concepto" 
							data-url=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*30.90*/(""""
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.concepto.simple" 
							data-label="#liquidacion_concepto_modal" 
							data-field="#liquidacion_concepto_id_modal">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*40.4*/detalleForm("liquidacion_concepto_id")/*40.42*/.error.map/*40.52*/{ error =>_display_(Seq[Any](format.raw/*40.62*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*41.29*/error/*41.34*/.message)),format.raw/*41.42*/("""</div>
		""")))})),format.raw/*42.4*/("""
	</div>
	<div class="col-sm-3">
		<label class="control-label">Importe</label>
		<div class="form-group """),_display_(Seq[Any](/*46.27*/if(detalleForm.error("importe") != null)/*46.67*/ {_display_(Seq[Any](format.raw/*46.69*/("""has-error""")))}/*46.80*/else/*46.85*/{_display_(Seq[Any](format.raw/*46.86*/("""has-required""")))})),format.raw/*46.99*/("""">
			"""),_display_(Seq[Any](/*47.5*/inputText(detalleForm("importe"), 'class -> "form-control", 'id -> "importe"))),format.raw/*47.82*/("""
			"""),_display_(Seq[Any](/*48.5*/detalleForm("importe")/*48.27*/.error.map/*48.37*/{ error =>_display_(Seq[Any](format.raw/*48.47*/(""" <div class="text-error">"""),_display_(Seq[Any](/*48.73*/error/*48.78*/.message)),format.raw/*48.86*/("""</div>""")))})),format.raw/*48.93*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label for="cantidad" class="control-label">Cantidad</label>
		<div class="form-group """),_display_(Seq[Any](/*53.27*/if(detalleForm.error("cantidad") != null)/*53.68*/ {_display_(Seq[Any](format.raw/*53.70*/("""has-error""")))}/*53.81*/else/*53.86*/{_display_(Seq[Any](format.raw/*53.87*/("""has-required""")))})),format.raw/*53.100*/("""">
			"""),_display_(Seq[Any](/*54.5*/inputText(detalleForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*54.84*/("""
			"""),_display_(Seq[Any](/*55.5*/detalleForm("cantidad")/*55.28*/.error.map/*55.38*/{ error =>_display_(Seq[Any](format.raw/*55.48*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.74*/error/*55.79*/.message)),format.raw/*55.87*/("""</div>""")))})),format.raw/*55.94*/("""
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
$( function()"""),format.raw/*66.14*/("""{"""),format.raw/*66.15*/("""
	
	
"""),format.raw/*69.1*/("""}"""),format.raw/*69.2*/(""");
</script>"""))}
    }
    
    def render(detalleForm:Form[models.haberes.LiquidacionDetalle]): play.api.templates.HtmlFormat.Appendable = apply(detalleForm)
    
    def f:((Form[models.haberes.LiquidacionDetalle]) => play.api.templates.HtmlFormat.Appendable) = (detalleForm) => apply(detalleForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/formLiquidacionDetalle.scala.html
                    HASH: dec4a0a2aa807b09250b4e326c1e9e617730bfc7
                    MATRIX: 852->1|1009->76|1041->100|1115->55|1144->144|1188->154|1226->184|1265->186|1388->274|1401->279|1435->292|1478->304|1530->328|1559->329|1687->429|1716->430|1763->449|1792->450|1823->454|1851->455|1925->494|2013->560|2174->685|2239->741|2279->743|2308->754|2322->759|2362->760|2408->773|2451->781|2622->929|2663->935|2796->1045|2996->1209|3016->1220|3098->1280|3433->1580|3480->1618|3499->1628|3547->1638|3613->1668|3627->1673|3657->1681|3699->1692|3845->1802|3894->1842|3934->1844|3963->1855|3976->1860|4015->1861|4060->1874|4103->1882|4202->1959|4243->1965|4274->1987|4293->1997|4341->2007|4403->2033|4417->2038|4447->2046|4486->2053|4658->2189|4708->2230|4748->2232|4777->2243|4790->2248|4829->2249|4875->2262|4918->2270|5019->2349|5060->2355|5092->2378|5111->2388|5159->2398|5221->2424|5235->2429|5265->2437|5304->2444|5711->2823|5740->2824|5775->2832|5803->2833
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|44->16|44->16|44->16|44->16|45->17|45->17|49->21|49->21|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|54->26|54->26|58->30|58->30|58->30|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|74->46|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|94->66|94->66|97->69|97->69
                    -- GENERATED --
                */
            