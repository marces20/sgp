
package views.html.haberes.novedades

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
object crearMasivo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.Novedad],HashMap[String, List[String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[models.haberes.Novedad], lista: HashMap[String, List[String]] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import models.haberes._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/haberes/novedades-masivo.js"))),format.raw/*9.75*/("""" type="text/javascript"></script>
""")))};implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.70*/(""" 
	
"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.haberes.mainHaberes("Crear novedades masivamente", scripts)/*12.72*/ {_display_(Seq[Any](format.raw/*12.74*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear novedades masivamente</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*21.3*/views/*21.8*/.html.tags.successError())),format.raw/*21.33*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.haberes.routes.NovedadesAccionesController.procesarMasivo(), 'id -> "formNovedadesMasivo", 'enctype -> "multipart/form-data")/*23.164*/ {_display_(Seq[Any](format.raw/*23.166*/("""
	
	<div class="row">
	
		<div class="col-sm-2">
			<label class="control-label">Periodo</label> 
			<div class="form-group """),_display_(Seq[Any](/*29.28*/if(nForm.error("periodo_id") != null)/*29.65*/ {_display_(Seq[Any](format.raw/*29.67*/("""has-error""")))}/*29.78*/else/*29.83*/{_display_(Seq[Any](format.raw/*29.84*/("""has-required""")))})),format.raw/*29.97*/("""">
				<div class="input-group">
				"""),_display_(Seq[Any](/*31.6*/inputText(nForm("periodoInicio.nombre"),'class -> "form-control", 'id -> "periodo"))),format.raw/*31.89*/("""
				"""),_display_(Seq[Any](/*32.6*/inputText(nForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*32.77*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*37.21*/controllers/*37.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*37.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>	
			</div>
			"""),_display_(Seq[Any](/*48.5*/nForm("periodo_id")/*48.24*/.error.map/*48.34*/{ error =>_display_(Seq[Any](format.raw/*48.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*48.70*/error/*48.75*/.message)),format.raw/*48.83*/("""</div>""")))})),format.raw/*48.90*/("""
		</div>
	
		<div class="col-sm-2 """),_display_(Seq[Any](/*51.25*/if(nForm.error("liquidacion_tipo_id") != null)/*51.71*/ {_display_(Seq[Any](format.raw/*51.73*/("""has-error""")))}/*51.85*/else/*51.90*/{_display_(Seq[Any](format.raw/*51.91*/("""has-required""")))})),format.raw/*51.104*/("""">
			<label class="control-label">Tipo
			"""),_display_(Seq[Any](/*53.5*/select(nForm("liquidacion_tipo_id"), models.haberes.LiquidacionTipo.getTipos().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*53.183*/("""
			</label>
			"""),_display_(Seq[Any](/*55.5*/nForm("liquidacion_tipo_id")/*55.33*/.error.map/*55.43*/{ error =>_display_(Seq[Any](format.raw/*55.53*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.79*/error/*55.84*/.message)),format.raw/*55.92*/("""</div>""")))})),format.raw/*55.99*/("""
		</div>
	
	
	
	<div class="col-sm-3">
	<label class="control-label">&nbsp;</label> 
	<div class="form-group """),_display_(Seq[Any](/*62.26*/if(nForm.error("archivo") != null)/*62.60*/ {_display_(Seq[Any](format.raw/*62.62*/("""has-error""")))}/*62.73*/else/*62.78*/{_display_(Seq[Any](format.raw/*62.79*/("""has-required""")))})),format.raw/*62.92*/("""">
		<input type="file" name="archivo">
	</div>
	
	"""),_display_(Seq[Any](/*66.3*/nForm("archivo")/*66.19*/.error.map/*66.29*/{ error =>_display_(Seq[Any](format.raw/*66.39*/(""" <div class="text-error">"""),_display_(Seq[Any](/*66.65*/error/*66.70*/.message)),format.raw/*66.78*/("""</div>""")))})),format.raw/*66.85*/("""
	</div>
	
	
	</div>
	
	
	 

	"""),_display_(Seq[Any](/*75.3*/if(lista != null)/*75.20*/{_display_(Seq[Any](format.raw/*75.21*/("""
	

	 
		<hr />
		<h3>Errores encontrados</h3>
		"""),_display_(Seq[Any](/*81.4*/if(lista.get("archivo") != null)/*81.36*/ {_display_(Seq[Any](format.raw/*81.38*/("""
			"""),_display_(Seq[Any](/*82.5*/if(!lista.get("archivo").isEmpty())/*82.40*/ {_display_(Seq[Any](format.raw/*82.42*/("""
				"""),_display_(Seq[Any](/*83.6*/for(a <- lista.get("archivo")) yield /*83.36*/ {_display_(Seq[Any](format.raw/*83.38*/("""
					"""),_display_(Seq[Any](/*84.7*/Html(a))),format.raw/*84.14*/(""" <br />
				""")))})),format.raw/*85.6*/("""
				 <br />
			""")))})),format.raw/*87.5*/("""
		""")))})),format.raw/*88.4*/("""
		"""),_display_(Seq[Any](/*89.4*/if(lista.get("archivo") != null)/*89.36*/ {_display_(Seq[Any](format.raw/*89.38*/("""
			"""),_display_(Seq[Any](/*90.5*/if(!lista.get("cuit").isEmpty())/*90.37*/ {_display_(Seq[Any](format.raw/*90.39*/("""
				"""),_display_(Seq[Any](/*91.6*/for(c <- lista.get("cuit")) yield /*91.33*/ {_display_(Seq[Any](format.raw/*91.35*/("""
					"""),_display_(Seq[Any](/*92.7*/Html(c))),format.raw/*92.14*/(""" <br />
				""")))})),format.raw/*93.6*/("""
				 <br />
			""")))})),format.raw/*95.5*/("""
		""")))})),format.raw/*96.4*/("""
		"""),_display_(Seq[Any](/*97.4*/if(lista.get("archivo") != null)/*97.36*/ {_display_(Seq[Any](format.raw/*97.38*/("""
			"""),_display_(Seq[Any](/*98.5*/if(!lista.get("concepto").isEmpty())/*98.41*/ {_display_(Seq[Any](format.raw/*98.43*/("""
				"""),_display_(Seq[Any](/*99.6*/for(c <- lista.get("concepto")) yield /*99.37*/ {_display_(Seq[Any](format.raw/*99.39*/("""
					"""),_display_(Seq[Any](/*100.7*/Html(c))),format.raw/*100.14*/(""" <br />
				""")))})),format.raw/*101.6*/("""
				 <br />
			""")))})),format.raw/*103.5*/("""
		""")))})),format.raw/*104.4*/("""
	 
	""")))})),format.raw/*106.3*/("""
	
	
	
	

	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <button type="submit" class="btn btn-sistema">Procesar</button>
	    </div>
	</div>

	""")))})),format.raw/*118.3*/("""
""")))})),format.raw/*119.2*/("""
	"""))}
    }
    
    def render(nForm:Form[models.haberes.Novedad],lista:HashMap[String, List[String]]): play.api.templates.HtmlFormat.Appendable = apply(nForm,lista)
    
    def f:((Form[models.haberes.Novedad],HashMap[String, List[String]]) => play.api.templates.HtmlFormat.Appendable) = (nForm,lista) => apply(nForm,lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/crearMasivo.scala.html
                    HASH: b0ca05dcc4a734fe2979d4abdef107208903efe5
                    MATRIX: 850->1|1075->230|1089->237|1173->241|1225->258|1239->264|1313->317|1381->155|1413->179|1487->83|1515->103|1544->223|1577->354|1617->359|1630->364|1704->429|1744->431|1934->586|1947->591|1994->616|2042->629|2057->635|2219->787|2260->789|2427->920|2473->957|2513->959|2542->970|2555->975|2594->976|2639->989|2714->1029|2819->1112|2861->1119|2954->1190|3170->1370|3190->1381|3265->1434|3591->1725|3619->1744|3638->1754|3686->1764|3748->1790|3762->1795|3792->1803|3831->1810|3906->1849|3961->1895|4001->1897|4030->1909|4043->1914|4082->1915|4128->1928|4209->1974|4410->2152|4464->2171|4501->2199|4520->2209|4568->2219|4630->2245|4644->2250|4674->2258|4713->2265|4867->2383|4910->2417|4950->2419|4979->2430|4992->2435|5031->2436|5076->2449|5167->2505|5192->2521|5211->2531|5259->2541|5321->2567|5335->2572|5365->2580|5404->2587|5479->2627|5505->2644|5544->2645|5635->2701|5676->2733|5716->2735|5757->2741|5801->2776|5841->2778|5883->2785|5929->2815|5969->2817|6012->2825|6041->2832|6086->2846|6136->2865|6172->2870|6212->2875|6253->2907|6293->2909|6334->2915|6375->2947|6415->2949|6457->2956|6500->2983|6540->2985|6583->2993|6612->3000|6657->3014|6707->3033|6743->3038|6783->3043|6824->3075|6864->3077|6905->3083|6950->3119|6990->3121|7032->3128|7079->3159|7119->3161|7163->3169|7193->3176|7239->3190|7290->3209|7327->3214|7367->3222|7591->3414|7626->3417
                    LINES: 26->1|33->8|33->8|35->8|36->9|36->9|36->9|37->6|37->6|38->1|39->3|40->6|42->10|44->12|44->12|44->12|44->12|53->21|53->21|53->21|55->23|55->23|55->23|55->23|61->29|61->29|61->29|61->29|61->29|61->29|61->29|63->31|63->31|64->32|64->32|69->37|69->37|69->37|80->48|80->48|80->48|80->48|80->48|80->48|80->48|80->48|83->51|83->51|83->51|83->51|83->51|83->51|83->51|85->53|85->53|87->55|87->55|87->55|87->55|87->55|87->55|87->55|87->55|94->62|94->62|94->62|94->62|94->62|94->62|94->62|98->66|98->66|98->66|98->66|98->66|98->66|98->66|98->66|107->75|107->75|107->75|113->81|113->81|113->81|114->82|114->82|114->82|115->83|115->83|115->83|116->84|116->84|117->85|119->87|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|125->93|127->95|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|133->101|135->103|136->104|138->106|150->118|151->119
                    -- GENERATED --
                */
            