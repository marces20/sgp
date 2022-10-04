
package views.html.contabilidad.cuentasAnaliticas

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CuentaAnalitica],CuentaAnalitica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[CuentaAnalitica], cuentaPadre: CuentaAnalitica):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*3.70*/("""
<script>
$(function()"""),format.raw/*5.13*/("""{"""),format.raw/*5.14*/("""
	$('#searchCuentaAnalitica').modalSearch();
"""),format.raw/*7.1*/("""}"""),format.raw/*7.2*/(""");
</script>

 <div class="row">
	<div class="col-sm-3">
		<div class="form-group">
			<label for="nombre" class="control-label">Cuenta Padre</label>
			<p>"""),_display_(Seq[Any](/*14.8*/cuentaPadre/*14.19*/.nombre)),format.raw/*14.26*/("""</p>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*19.27*/if(cuentaForm.error("codigo") != null)/*19.65*/ {_display_(Seq[Any](format.raw/*19.67*/("""has-error""")))}/*19.78*/else/*19.83*/{_display_(Seq[Any](format.raw/*19.84*/("""has-required""")))})),format.raw/*19.97*/("""">
			<label for="codigo" class="control-label">Código</label>
			"""),_display_(Seq[Any](/*21.5*/inputText(cuentaForm("codigo"), 'class -> "form-control"))),format.raw/*21.62*/("""
			"""),_display_(Seq[Any](/*22.5*/cuentaForm("codigo")/*22.25*/.error.map/*22.35*/{ error =>_display_(Seq[Any](format.raw/*22.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*23.30*/error/*23.35*/.message)),format.raw/*23.43*/("""</div>
			""")))})),format.raw/*24.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*29.27*/if(cuentaForm.error("nombre") != null)/*29.65*/ {_display_(Seq[Any](format.raw/*29.67*/("""has-error""")))}/*29.78*/else/*29.83*/{_display_(Seq[Any](format.raw/*29.84*/("""has-required""")))})),format.raw/*29.97*/("""">
			<label for="nombre" class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*31.5*/inputText(cuentaForm("nombre"), 'class -> "form-control"))),format.raw/*31.62*/("""
			"""),_display_(Seq[Any](/*32.5*/cuentaForm("nombre")/*32.25*/.error.map/*32.35*/{ error =>_display_(Seq[Any](format.raw/*32.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*33.30*/error/*33.35*/.message)),format.raw/*33.43*/("""</div>
			""")))})),format.raw/*34.5*/("""
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*39.27*/if(cuentaForm.error("tipo_partida") != null)/*39.71*/ {_display_(Seq[Any](format.raw/*39.73*/("""has-error""")))}/*39.84*/else/*39.89*/{_display_(Seq[Any](format.raw/*39.90*/("""has-required""")))})),format.raw/*39.103*/("""">
			<label for="tipo_partida" class="control-label">Tipo partida</label>
			"""),_display_(Seq[Any](/*41.5*/inputText(cuentaForm("tipo_partida"), 'class -> "form-control"))),format.raw/*41.68*/("""
			"""),_display_(Seq[Any](/*42.5*/cuentaForm("tipo_partida")/*42.31*/.error.map/*42.41*/{ error =>_display_(Seq[Any](format.raw/*42.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*43.30*/error/*43.35*/.message)),format.raw/*43.43*/("""</div>
			""")))})),format.raw/*44.5*/("""
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-6">
		<label for="cuenta" class="control-label">Cuenta presupuestaria a reportar</label>
		<div class="input-group """),_display_(Seq[Any](/*52.28*/if(cuentaForm.error("cuenta_reporta_id") != null)/*52.77*/ {_display_(Seq[Any](format.raw/*52.79*/("""has-error""")))}/*52.90*/else/*52.95*/{_display_(Seq[Any](format.raw/*52.96*/("""has-required""")))})),format.raw/*52.109*/("""">
			"""),_display_(Seq[Any](/*53.5*/inputText(cuentaForm("cuentaReporta.nombre"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*53.102*/("""
			"""),_display_(Seq[Any](/*54.5*/inputText(cuentaForm("cuenta_reporta_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*54.97*/("""
			<span class="input-group-addon">
				<a href="#" 
				   id="searchCuentaAnalitica" 
				   class="searchModal"
				   data-title="Selección de Cuenta Analitica" 
				   data-url=""""),_display_(Seq[Any](/*60.19*/controllers/*60.30*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*60.92*/("""" 
				   data-height="650" 
				   data-width="700" 
				   data-listen="modal.seleccion.cuentaAnalitica.simple" 
				   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
				   <i class="glyphicon glyphicon-search"></i>
				 </a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*69.4*/cuentaForm("cuenta_analitica_id")/*69.37*/.error.map/*69.47*/{ error =>_display_(Seq[Any](format.raw/*69.57*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*70.29*/error/*70.34*/.message)),format.raw/*70.42*/("""</div>
		""")))})),format.raw/*71.4*/("""
	</div>
	<div class="col-sm-2">
		<div class="checkbox" """),_display_(Seq[Any](/*74.26*/if(cuentaForm.error("activo") != null)/*74.64*/ {_display_(Seq[Any](format.raw/*74.66*/("""has-error""")))})),format.raw/*74.76*/("""">
			<label class="control-label"> """),_display_(Seq[Any](/*75.35*/checkbox(cuentaForm("ejecutable")))),format.raw/*75.69*/(""" ¿Ejecutable?</label>
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="checkbox" """),_display_(Seq[Any](/*80.26*/if(cuentaForm.error("activo") != null)/*80.64*/ {_display_(Seq[Any](format.raw/*80.66*/("""has-error""")))})),format.raw/*80.76*/("""">
			<label class="control-label"> """),_display_(Seq[Any](/*81.35*/checkbox(cuentaForm("carga_credito")))),format.raw/*81.72*/(""" ¿Carga crédito?</label>
		</div>
	</div>
</div>
<script>
$( function()"""),format.raw/*86.14*/("""{"""),format.raw/*86.15*/("""
	if($("#cuentaAnalitica").length)"""),format.raw/*87.34*/("""{"""),format.raw/*87.35*/("""
		var options = """),format.raw/*88.17*/("""{"""),format.raw/*88.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*94.30*/("""{"""),format.raw/*94.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*96.12*/("""}"""),format.raw/*96.13*/("""
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*99.2*/("""}"""),format.raw/*99.3*/("""	
"""),format.raw/*100.1*/("""}"""),format.raw/*100.2*/(""");
</script>"""))}
    }
    
    def render(cuentaForm:Form[CuentaAnalitica],cuentaPadre:CuentaAnalitica): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[CuentaAnalitica],CuentaAnalitica) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/form.scala.html
                    HASH: d0f22008ec46d3634b165aee7ff1052f74c24fd2
                    MATRIX: 835->1|1003->87|1035->111|1109->66|1138->155|1189->179|1217->180|1290->227|1317->228|1516->392|1536->403|1565->410|1680->489|1727->527|1767->529|1796->540|1809->545|1848->546|1893->559|1997->628|2076->685|2117->691|2146->711|2165->721|2213->731|2280->762|2294->767|2324->775|2367->787|2478->862|2525->900|2565->902|2594->913|2607->918|2646->919|2691->932|2795->1001|2874->1058|2915->1064|2944->1084|2963->1094|3011->1104|3078->1135|3092->1140|3122->1148|3165->1160|3276->1235|3329->1279|3369->1281|3398->1292|3411->1297|3450->1298|3496->1311|3612->1392|3697->1455|3738->1461|3773->1487|3792->1497|3840->1507|3907->1538|3921->1543|3951->1551|3994->1563|4218->1751|4276->1800|4316->1802|4345->1813|4358->1818|4397->1819|4443->1832|4486->1840|4606->1937|4647->1943|4761->2035|4988->2226|5008->2237|5092->2299|5405->2577|5447->2610|5466->2620|5514->2630|5580->2660|5594->2665|5624->2673|5666->2684|5763->2745|5810->2783|5850->2785|5892->2795|5966->2833|6022->2867|6153->2962|6200->3000|6240->3002|6282->3012|6356->3050|6415->3087|6519->3163|6548->3164|6611->3199|6640->3200|6686->3218|6715->3219|6904->3380|6933->3381|7026->3446|7055->3447|7087->3452|7115->3453|7212->3523|7240->3524|7271->3527|7300->3528
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|35->7|35->7|42->14|42->14|42->14|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|57->29|57->29|57->29|57->29|57->29|57->29|57->29|59->31|59->31|60->32|60->32|60->32|60->32|61->33|61->33|61->33|62->34|67->39|67->39|67->39|67->39|67->39|67->39|67->39|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|72->44|80->52|80->52|80->52|80->52|80->52|80->52|80->52|81->53|81->53|82->54|82->54|88->60|88->60|88->60|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|102->74|102->74|102->74|102->74|103->75|103->75|108->80|108->80|108->80|108->80|109->81|109->81|114->86|114->86|115->87|115->87|116->88|116->88|122->94|122->94|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100
                    -- GENERATED --
                */
            