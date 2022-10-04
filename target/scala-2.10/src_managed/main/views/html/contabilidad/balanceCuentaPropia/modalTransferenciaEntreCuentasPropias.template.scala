
package views.html.contabilidad.balanceCuentaPropia

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
object modalTransferenciaEntreCuentasPropias extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.BalanceCuentaPropiaController.transferenciaEntreCuentasPropias(), 'id -> "formTransferenciaEntreCuentasPropias")/*5.167*/ {_display_(Seq[Any](format.raw/*5.169*/("""	

<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
	$("#importe").numeric_input();
	$(".inputDateMascara").mask("99/99/9999");
	$( ".date" ).mask("99/99/9999");
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/(""");
</script>
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.tags.successError())),format.raw/*14.32*/("""
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*17.28*/if(formBuscador.error("cuenta_propia_id_debito") != null)/*17.85*/ {_display_(Seq[Any](format.raw/*17.87*/("""has-error""")))}/*17.98*/else/*17.103*/{_display_(Seq[Any](format.raw/*17.104*/("""has-required""")))})),format.raw/*17.117*/("""">
				<label class="control-label">Cuenta a Debitar</label>
				"""),_display_(Seq[Any](/*19.6*/select(formBuscador("cuenta_propia_id_debito"),CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*19.175*/(""" 	
			</div>
			"""),_display_(Seq[Any](/*21.5*/formBuscador("cuenta_propia_id_debito")/*21.44*/.error.map/*21.54*/{ error =>_display_(Seq[Any](format.raw/*21.64*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*22.30*/error/*22.35*/.message)),format.raw/*22.43*/("""</div>
			""")))})),format.raw/*23.5*/("""
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*26.28*/if(formBuscador.error("cuenta_propia_id_credito") != null)/*26.86*/ {_display_(Seq[Any](format.raw/*26.88*/("""has-error""")))}/*26.99*/else/*26.104*/{_display_(Seq[Any](format.raw/*26.105*/("""has-required""")))})),format.raw/*26.118*/("""">
				<label class="control-label">Cuenta a Acreditar</label>
				"""),_display_(Seq[Any](/*28.6*/select(formBuscador("cuenta_propia_id_credito"),CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*28.176*/(""" 	
			</div>
			"""),_display_(Seq[Any](/*30.5*/formBuscador("cuenta_propia_id_credito")/*30.45*/.error.map/*30.55*/{ error =>_display_(Seq[Any](format.raw/*30.65*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*31.30*/error/*31.35*/.message)),format.raw/*31.43*/("""</div>
			""")))})),format.raw/*32.5*/("""
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*35.28*/if(formBuscador.error("referencia") != null)/*35.72*/ {_display_(Seq[Any](format.raw/*35.74*/("""has-error""")))}/*35.85*/else/*35.90*/{_display_(Seq[Any](format.raw/*35.91*/("""has-required""")))})),format.raw/*35.104*/("""">
				<label for="inputReferencia" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*37.6*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*37.69*/("""
			</div>
			"""),_display_(Seq[Any](/*39.5*/formBuscador("referencia")/*39.31*/.error.map/*39.41*/{ error =>_display_(Seq[Any](format.raw/*39.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*40.30*/error/*40.35*/.message)),format.raw/*40.43*/("""</div>
			""")))})),format.raw/*41.5*/("""
		</div>
	</div>	
	<div class="row">
		<div class="col-sm-4">
			<label class="control-label">Importe</label>
			<div class="form-group """),_display_(Seq[Any](/*47.28*/if(formBuscador.error("importe") != null)/*47.69*/ {_display_(Seq[Any](format.raw/*47.71*/("""has-error""")))}/*47.82*/else/*47.87*/{_display_(Seq[Any](format.raw/*47.88*/("""has-required""")))})),format.raw/*47.101*/("""">
				"""),_display_(Seq[Any](/*48.6*/inputText(formBuscador("importe"), 'class -> "form-control",'id -> "importe"))),format.raw/*48.83*/("""
				"""),_display_(Seq[Any](/*49.6*/formBuscador("importe")/*49.29*/.error.map/*49.39*/{ error =>_display_(Seq[Any](format.raw/*49.49*/(""" <div class="text-error">"""),_display_(Seq[Any](/*49.75*/error/*49.80*/.message)),format.raw/*49.88*/("""</div>""")))})),format.raw/*49.95*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*53.28*/if(formBuscador.error("fecha") != null)/*53.67*/ {_display_(Seq[Any](format.raw/*53.69*/("""has-error""")))}/*53.80*/else/*53.85*/{_display_(Seq[Any](format.raw/*53.86*/("""has-required""")))})),format.raw/*53.99*/("""">
				<label for="inputFecha" class="control-label">Fecha</label> 
				"""),_display_(Seq[Any](/*55.6*/inputText(formBuscador("fecha"),'class -> "form-control date"))),format.raw/*55.68*/("""
			</div>
			"""),_display_(Seq[Any](/*57.5*/formBuscador("fecha")/*57.26*/.error.map/*57.36*/{ error =>_display_(Seq[Any](format.raw/*57.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*58.30*/error/*58.35*/.message)),format.raw/*58.43*/("""</div>
			""")))})),format.raw/*59.5*/("""
		</div>
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*62.28*/if(formBuscador.error("a_la_orden") != null)/*62.72*/ {_display_(Seq[Any](format.raw/*62.74*/("""has-error""")))})),format.raw/*62.84*/("""">
				<label for="inputAlaorden" class="control-label">A la Orden</label> 
				"""),_display_(Seq[Any](/*64.6*/inputText(formBuscador("a_la_orden"), 'class -> "form-control"))),format.raw/*64.69*/("""
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
		</div>
	</div>
"""),_display_(Seq[Any](/*75.2*/flash()/*75.9*/.clear())),format.raw/*75.17*/("""
""")))})),format.raw/*76.2*/("""
	
		
		"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balanceCuentaPropia/modalTransferenciaEntreCuentasPropias.scala.html
                    HASH: aaddebc15ef5231529d19b9c23aa8daca3e56aec
                    MATRIX: 844->1|973->47|1005->71|1079->28|1107->115|1164->138|1177->144|1345->303|1385->305|1436->329|1464->330|1602->441|1630->442|1679->456|1692->461|1739->486|1847->558|1913->615|1953->617|1982->628|1996->633|2036->634|2082->647|2183->713|2375->882|2427->899|2475->938|2494->948|2542->958|2608->988|2622->993|2652->1001|2694->1012|2792->1074|2859->1132|2899->1134|2928->1145|2942->1150|2982->1151|3028->1164|3131->1232|3324->1402|3376->1419|3425->1459|3444->1469|3492->1479|3558->1509|3572->1514|3602->1522|3644->1533|3742->1595|3795->1639|3835->1641|3864->1652|3877->1657|3916->1658|3962->1671|4080->1754|4165->1817|4215->1832|4250->1858|4269->1868|4317->1878|4383->1908|4397->1913|4427->1921|4469->1932|4643->2070|4693->2111|4733->2113|4762->2124|4775->2129|4814->2130|4860->2143|4903->2151|5002->2228|5043->2234|5075->2257|5094->2267|5142->2277|5204->2303|5218->2308|5248->2316|5287->2323|5395->2395|5443->2434|5483->2436|5512->2447|5525->2452|5564->2453|5609->2466|5717->2539|5801->2601|5851->2616|5881->2637|5900->2647|5948->2657|6014->2687|6028->2692|6058->2700|6100->2711|6198->2773|6251->2817|6291->2819|6333->2829|6449->2910|6534->2973|6901->3305|6916->3312|6946->3320|6979->3322
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|36->8|36->8|40->12|40->12|42->14|42->14|42->14|45->17|45->17|45->17|45->17|45->17|45->17|45->17|47->19|47->19|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|54->26|54->26|54->26|54->26|54->26|54->26|54->26|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|67->39|67->39|67->39|67->39|68->40|68->40|68->40|69->41|75->47|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|83->55|83->55|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|90->62|90->62|90->62|90->62|92->64|92->64|103->75|103->75|103->75|104->76
                    -- GENERATED --
                */
            