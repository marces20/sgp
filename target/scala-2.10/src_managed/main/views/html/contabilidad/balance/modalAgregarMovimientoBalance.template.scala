
package views.html.contabilidad.balance

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
object modalAgregarMovimientoBalance extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Balance],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: Form[Balance]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.31*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.BalanceController.agregarMovimientoBalance(), 'id -> "formAgregarMovimientoBalance")/*5.139*/ {_display_(Seq[Any](format.raw/*5.141*/("""	

<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
	$('#searchCuenta').modalSearch();
	$("#debito,#deposito").numeric_input();
 	$(".inputDateMascara").mask("99/99/9999");
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/(""");
</script>
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.tags.successError())),format.raw/*14.32*/("""
	<div class="row">
		 
			
			<div class="col-sm-2">	
				<div class="form-group """),_display_(Seq[Any](/*19.29*/if(formBuscador.error("fecha") != null)/*19.68*/ {_display_(Seq[Any](format.raw/*19.70*/("""has-error""")))}/*19.81*/else/*19.86*/{_display_(Seq[Any](format.raw/*19.87*/("""has-required""")))})),format.raw/*19.100*/("""">
					<label for="inputFecha" class="control-label">Fecha</label> 
					"""),_display_(Seq[Any](/*21.7*/inputText(formBuscador("fecha"),'class -> "form-control date inputDateMascara"))),format.raw/*21.86*/("""
				</div>
				"""),_display_(Seq[Any](/*23.6*/formBuscador("fecha")/*23.27*/.error.map/*23.37*/{ error =>_display_(Seq[Any](format.raw/*23.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
			
			 
			
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*31.29*/if(formBuscador.error("cuenta_propia_id") != null)/*31.79*/ {_display_(Seq[Any](format.raw/*31.81*/("""has-error""")))}/*31.92*/else/*31.97*/{_display_(Seq[Any](format.raw/*31.98*/("""has-required""")))})),format.raw/*31.111*/("""">
					<label class="control-label">Cuenta</label>
					"""),_display_(Seq[Any](/*33.7*/select(formBuscador("cuenta_propia_id"),CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*33.169*/(""" 	
				</div>
				"""),_display_(Seq[Any](/*35.6*/formBuscador("cuenta_propia_id")/*35.38*/.error.map/*35.48*/{ error =>_display_(Seq[Any](format.raw/*35.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*36.31*/error/*36.36*/.message)),format.raw/*36.44*/("""</div>
				""")))})),format.raw/*37.6*/("""
			</div>
			
			
			<div class="col-sm-4">
				
				<div class="form-group """),_display_(Seq[Any](/*43.29*/if(formBuscador.error("cuenta_id") != null)/*43.72*/ {_display_(Seq[Any](format.raw/*43.74*/("""has-error""")))}/*43.84*/else/*43.88*/{_display_(Seq[Any](format.raw/*43.89*/("""has-required""")))})),format.raw/*43.102*/("""">
					<label for="inputCuenta" class="control-label">Cuenta</label> 
					<div class="input-group">
					"""),_display_(Seq[Any](/*46.7*/inputText(formBuscador("cuenta.nombre"),'class -> "form-control",'id -> "cuenta"))),format.raw/*46.88*/("""
					"""),_display_(Seq[Any](/*47.7*/inputText(formBuscador("cuenta_id"),'hidden -> "hidden",'id -> "cuenta_id"))),format.raw/*47.82*/("""
					
					
					<span class="input-group-addon"><a href="#" id="searchCuenta" 
																data-title="Selección de expediente" 
																data-url=""""),_display_(Seq[Any](/*52.28*/controllers/*52.39*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*52.91*/("""" 
																data-height="650" data-width="700" 
																data-listen="modal.seleccion.cuenta.simple" 
																data-label="#cuenta" data-field="#cuenta_id">
																<i class="glyphicon glyphicon-search"></i></a></span>
					</div>
				</div>
				"""),_display_(Seq[Any](/*59.6*/formBuscador("cuenta_id")/*59.31*/.error.map/*59.41*/{ error =>_display_(Seq[Any](format.raw/*59.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*60.31*/error/*60.36*/.message)),format.raw/*60.44*/("""</div>
				""")))})),format.raw/*61.6*/("""
			</div>
		 
		 
		  
	 
		 
	</div>				 
		
		
		
	 
	<div class="row">	
		 
			<div class="col-sm-3">
				<label class="control-label">Importe DEBE</label>
				<div class="form-group """),_display_(Seq[Any](/*77.29*/if(formBuscador.error("debe") != null)/*77.67*/ {_display_(Seq[Any](format.raw/*77.69*/("""has-error""")))}/*77.80*/else/*77.85*/{_display_(Seq[Any](format.raw/*77.86*/("""has-required""")))})),format.raw/*77.99*/("""">
					"""),_display_(Seq[Any](/*78.7*/inputText(formBuscador("debe"), 'class -> "form-control",'id -> "debe"))),format.raw/*78.78*/("""
					"""),_display_(Seq[Any](/*79.7*/formBuscador("debe")/*79.27*/.error.map/*79.37*/{ error =>_display_(Seq[Any](format.raw/*79.47*/(""" <div class="text-error">"""),_display_(Seq[Any](/*79.73*/error/*79.78*/.message)),format.raw/*79.86*/("""</div>""")))})),format.raw/*79.93*/("""
				</div>
			</div>
			<div class="col-sm-3">
				<label class="control-label">Importe HABER</label>
				<div class="form-group """),_display_(Seq[Any](/*84.29*/if(formBuscador.error("haber") != null)/*84.68*/ {_display_(Seq[Any](format.raw/*84.70*/("""has-error""")))}/*84.81*/else/*84.86*/{_display_(Seq[Any](format.raw/*84.87*/("""has-required""")))})),format.raw/*84.100*/("""">
					"""),_display_(Seq[Any](/*85.7*/inputText(formBuscador("haber"), 'class -> "form-control",'id -> "haber"))),format.raw/*85.80*/("""
					"""),_display_(Seq[Any](/*86.7*/formBuscador("haber")/*86.28*/.error.map/*86.38*/{ error =>_display_(Seq[Any](format.raw/*86.48*/(""" <div class="text-error">"""),_display_(Seq[Any](/*86.74*/error/*86.79*/.message)),format.raw/*86.87*/("""</div>""")))})),format.raw/*86.94*/("""
				</div>
			</div>
		 
	</div>	

	<div class="row">	
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Estado</label>
				"""),_display_(Seq[Any](/*96.6*/select(formBuscador("estado_id"), options("25"->"Conciliado","26"->"Cancelado"), 'class -> "form-control select"))),format.raw/*96.119*/("""
			</div>
			
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
		</div>
	</div>
 
"""),_display_(Seq[Any](/*110.2*/flash()/*110.9*/.clear())),format.raw/*110.17*/("""
<script>
$( function()"""),format.raw/*112.14*/("""{"""),format.raw/*112.15*/("""
	if($("#proveedor_modal").length)"""),format.raw/*113.34*/("""{"""),format.raw/*113.35*/("""
		var options = """),format.raw/*114.17*/("""{"""),format.raw/*114.18*/("""
				script:"/suggestProveedor/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*120.30*/("""{"""),format.raw/*120.31*/(""" 
											$("#proveedor_id_modal").val(obj.id); 
										 """),format.raw/*122.12*/("""}"""),format.raw/*122.13*/("""
			"""),format.raw/*123.4*/("""}"""),format.raw/*123.5*/(""";
		var as_json = new bsn.AutoSuggest('proveedor_modal', options);
	"""),format.raw/*125.2*/("""}"""),format.raw/*125.3*/("""	
	
	if($("#cuenta").length)"""),format.raw/*127.25*/("""{"""),format.raw/*127.26*/("""
		var options = """),format.raw/*128.17*/("""{"""),format.raw/*128.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*134.30*/("""{"""),format.raw/*134.31*/(""" 
											$("#cuenta_id").val(obj.id); 
										 """),format.raw/*136.12*/("""}"""),format.raw/*136.13*/("""
			"""),format.raw/*137.4*/("""}"""),format.raw/*137.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta', options);
	"""),format.raw/*139.2*/("""}"""),format.raw/*139.3*/("""	
if($("#expediente_modal").length)"""),format.raw/*140.34*/("""{"""),format.raw/*140.35*/("""
	var options = """),format.raw/*141.16*/("""{"""),format.raw/*141.17*/("""
			script:"/suggestExpediente/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*147.29*/("""{"""),format.raw/*147.30*/(""" 
										$("#expediente_id_modal").val(obj.id); 
									 """),format.raw/*149.11*/("""}"""),format.raw/*149.12*/("""
		"""),format.raw/*150.3*/("""}"""),format.raw/*150.4*/(""";
	var as_json = new bsn.AutoSuggest('expediente_modal', options);
"""),format.raw/*152.1*/("""}"""),format.raw/*152.2*/("""	
if($("#orden_pago_modal").length)"""),format.raw/*153.34*/("""{"""),format.raw/*153.35*/("""
	var options = """),format.raw/*154.16*/("""{"""),format.raw/*154.17*/("""
			script:"/contabilidad/suggestOrdenPago/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*160.29*/("""{"""),format.raw/*160.30*/(""" 
										$("#orden_pago_id_modal").val(obj.id); 
									 """),format.raw/*162.11*/("""}"""),format.raw/*162.12*/("""
		"""),format.raw/*163.3*/("""}"""),format.raw/*163.4*/(""";
	var as_json = new bsn.AutoSuggest('orden_pago_modal', options);
"""),format.raw/*165.1*/("""}"""),format.raw/*165.2*/("""	
"""),format.raw/*166.1*/("""}"""),format.raw/*166.2*/(""");
</script>
""")))})),format.raw/*168.2*/("""
"""))}
    }
    
    def render(formBuscador:Form[Balance]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((Form[Balance]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/modalAgregarMovimientoBalance.scala.html
                    HASH: 39f3cc54749b9a78779a98558e008a51b55d1a74
                    MATRIX: 826->1|957->49|989->73|1063->30|1091->117|1148->140|1161->146|1301->277|1341->279|1392->303|1420->304|1569->426|1597->427|1646->441|1659->446|1706->471|1825->554|1873->593|1913->595|1942->606|1955->611|1994->612|2040->625|2150->700|2251->779|2303->796|2333->817|2352->827|2400->837|2467->868|2481->873|2511->881|2554->893|2668->971|2727->1021|2767->1023|2796->1034|2809->1039|2848->1040|2894->1053|2987->1111|3172->1273|3226->1292|3267->1324|3286->1334|3334->1344|3401->1375|3415->1380|3445->1388|3488->1400|3602->1478|3654->1521|3694->1523|3723->1533|3736->1537|3775->1538|3821->1551|3964->1659|4067->1740|4109->1747|4206->1822|4404->1984|4424->1995|4498->2047|4809->2323|4843->2348|4862->2358|4910->2368|4977->2399|4991->2404|5021->2412|5064->2424|5288->2612|5335->2650|5375->2652|5404->2663|5417->2668|5456->2669|5501->2682|5545->2691|5638->2762|5680->2769|5709->2789|5728->2799|5776->2809|5838->2835|5852->2840|5882->2848|5921->2855|6088->2986|6136->3025|6176->3027|6205->3038|6218->3043|6257->3044|6303->3057|6347->3066|6442->3139|6484->3146|6514->3167|6533->3177|6581->3187|6643->3213|6657->3218|6687->3226|6726->3233|6923->3395|7059->3508|7435->3848|7451->3855|7482->3863|7534->3886|7564->3887|7627->3921|7657->3922|7703->3939|7733->3940|7898->4076|7928->4077|8020->4140|8050->4141|8082->4145|8111->4146|8207->4214|8236->4215|8293->4243|8323->4244|8369->4261|8399->4262|8574->4408|8604->4409|8687->4463|8717->4464|8749->4468|8778->4469|8865->4528|8894->4529|8958->4564|8988->4565|9033->4581|9063->4582|9223->4713|9253->4714|9344->4776|9374->4777|9405->4780|9434->4781|9529->4848|9558->4849|9622->4884|9652->4885|9697->4901|9727->4902|9899->5045|9929->5046|10020->5108|10050->5109|10081->5112|10110->5113|10205->5180|10234->5181|10264->5183|10293->5184|10339->5198
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|36->8|36->8|40->12|40->12|42->14|42->14|42->14|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|59->31|59->31|59->31|59->31|59->31|59->31|59->31|61->33|61->33|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|71->43|71->43|71->43|71->43|71->43|71->43|71->43|74->46|74->46|75->47|75->47|80->52|80->52|80->52|87->59|87->59|87->59|87->59|88->60|88->60|88->60|89->61|105->77|105->77|105->77|105->77|105->77|105->77|105->77|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|112->84|112->84|112->84|112->84|112->84|112->84|112->84|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|124->96|124->96|138->110|138->110|138->110|140->112|140->112|141->113|141->113|142->114|142->114|148->120|148->120|150->122|150->122|151->123|151->123|153->125|153->125|155->127|155->127|156->128|156->128|162->134|162->134|164->136|164->136|165->137|165->137|167->139|167->139|168->140|168->140|169->141|169->141|175->147|175->147|177->149|177->149|178->150|178->150|180->152|180->152|181->153|181->153|182->154|182->154|188->160|188->160|190->162|190->162|191->163|191->163|193->165|193->165|194->166|194->166|196->168
                    -- GENERATED --
                */
            