
package views.html.recupero.recuperoPlanilla

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
object formPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoPlanilla],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(planillaForm: Form[models.recupero.RecuperoPlanilla]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*11.17*/if(request().getHeader("referer"))/*11.51*/{_display_(Seq[Any](format.raw/*11.52*/(""" """),_display_(Seq[Any](/*11.54*/request()/*11.63*/.getHeader("referer"))),format.raw/*11.84*/(""" """)))}/*11.87*/else/*11.92*/{_display_(Seq[Any](_display_(Seq[Any](/*11.94*/controllers/*11.105*/.recupero.routes.RecuperoPlanillasController.index())),_display_(Seq[Any](/*11.158*/UriTrack/*11.166*/.decode()))))})),format.raw/*11.176*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*15.5*/if(planillaForm.field("id").value)/*15.39*/{_display_(Seq[Any](format.raw/*15.40*/("""<a href=""""),_display_(Seq[Any](/*15.50*/controllers/*15.61*/.recupero.routes.RecuperoPlanillasController.ver(planillaForm.field("id").value.toLong))),_display_(Seq[Any](/*15.149*/UriTrack/*15.157*/.get("&"))),format.raw/*15.166*/("""" title="Ver planilla" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.267*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*20.3*/inputText(planillaForm("id"), 'type -> "hidden", 'id -> "planillaId"))),format.raw/*20.72*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*21.29*/UriTrack/*21.37*/.getKey())),format.raw/*21.46*/(""" value=""""),_display_(Seq[Any](/*21.55*/UriTrack/*21.63*/.code())),format.raw/*21.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Numero</label> 
			<div class="form-group """),_display_(Seq[Any](/*25.28*/if(planillaForm.error("numero") != null)/*25.68*/ {_display_(Seq[Any](format.raw/*25.70*/("""has-error""")))}/*25.80*/else/*25.84*/{_display_(Seq[Any](format.raw/*25.85*/("""has-required""")))})),format.raw/*25.98*/("""">
				"""),_display_(Seq[Any](/*26.6*/inputText(planillaForm("numero"), 'class -> "form-control", 'id -> "numero"))),format.raw/*26.82*/("""
				
				"""),_display_(Seq[Any](/*28.6*/planillaForm("numero")/*28.28*/.error.map/*28.38*/{ error =>_display_(Seq[Any](format.raw/*28.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*29.31*/error/*29.36*/.message)),format.raw/*29.44*/("""</div>
				""")))})),format.raw/*30.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*35.29*/if(planillaForm.error("expediente_id") != null)/*35.76*/ {_display_(Seq[Any](format.raw/*35.78*/("""has-error""")))}/*35.88*/else/*35.92*/{_display_(Seq[Any](format.raw/*35.93*/("""has-required""")))})),format.raw/*35.106*/("""">
				"""),_display_(Seq[Any](/*36.6*/inputText(planillaForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*36.109*/("""
				"""),_display_(Seq[Any](/*37.6*/inputText(planillaForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*37.90*/("""

				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" 
				data-url=""""),_display_(Seq[Any](/*40.16*/controllers/*40.27*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*40.81*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.expediente.simple" 
				data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
			"""),_display_(Seq[Any](/*46.5*/planillaForm("expediente_id")/*46.34*/.error.map/*46.44*/{ error =>_display_(Seq[Any](format.raw/*46.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*47.31*/error/*47.36*/.message)),format.raw/*47.44*/("""</div>
				""")))})),format.raw/*48.6*/("""
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha planilla</label> 
			<div class="form-group """),_display_(Seq[Any](/*53.28*/if(planillaForm.error("fecha")  != null)/*53.68*/ {_display_(Seq[Any](format.raw/*53.70*/("""has-error""")))}/*53.80*/else/*53.84*/{_display_(Seq[Any](format.raw/*53.85*/("""has-required""")))})),format.raw/*53.98*/("""">
				"""),_display_(Seq[Any](/*54.6*/inputText(planillaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*54.92*/("""
			</div>
			"""),_display_(Seq[Any](/*56.5*/planillaForm("fecha")/*56.26*/.error.map/*56.36*/{ error =>_display_(Seq[Any](format.raw/*56.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*57.30*/error/*57.35*/.message)),format.raw/*57.43*/("""</div>
			""")))})),format.raw/*58.5*/("""
		</div>
		
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group """),_display_(Seq[Any](/*63.29*/if(planillaForm.error("deposito_id") != null)/*63.74*/ {_display_(Seq[Any](format.raw/*63.76*/("""has-error""")))}/*63.86*/else/*63.90*/{_display_(Seq[Any](format.raw/*63.91*/("""has-required""")))})),format.raw/*63.104*/("""">
				"""),_display_(Seq[Any](/*64.6*/inputText(planillaForm("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*64.123*/("""
				"""),_display_(Seq[Any](/*65.6*/inputText(planillaForm("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*65.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*68.29*/controllers/*68.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*68.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*74.5*/planillaForm("deposito_id")/*74.32*/.error.map/*74.42*/{ error =>_display_(Seq[Any](format.raw/*74.52*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*75.30*/error/*75.35*/.message)),format.raw/*75.43*/("""</div>
			""")))})),format.raw/*76.5*/("""
		</div>
	</div>"""))}
    }
    
    def render(planillaForm:Form[models.recupero.RecuperoPlanilla]): play.api.templates.HtmlFormat.Appendable = apply(planillaForm)
    
    def f:((Form[models.recupero.RecuperoPlanilla]) => play.api.templates.HtmlFormat.Appendable) = (planillaForm) => apply(planillaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/formPlanilla.scala.html
                    HASH: bcbd70e71f02918ba0badaf29f4145111ed39af5
                    MATRIX: 839->1|1011->90|1043->114|1117->55|1145->158|1435->412|1478->446|1517->447|1555->449|1573->458|1616->479|1637->482|1650->487|1698->489|1719->500|1803->553|1821->561|1858->571|2057->734|2074->742|2105->751|2242->853|2285->887|2324->888|2370->898|2390->909|2509->997|2527->1005|2559->1014|2693->1115|2752->1139|2843->1208|2908->1237|2925->1245|2956->1254|3001->1263|3018->1271|3047->1278|3207->1402|3256->1442|3296->1444|3325->1454|3338->1458|3377->1459|3422->1472|3465->1480|3563->1556|3609->1567|3640->1589|3659->1599|3707->1609|3774->1640|3788->1645|3818->1653|3861->1665|4039->1807|4095->1854|4135->1856|4164->1866|4177->1870|4216->1871|4262->1884|4305->1892|4431->1995|4472->2001|4578->2085|4739->2210|4759->2221|4835->2275|5096->2501|5134->2530|5153->2540|5201->2550|5268->2581|5282->2586|5312->2594|5355->2606|5512->2727|5561->2767|5601->2769|5630->2779|5643->2783|5682->2784|5727->2797|5770->2805|5878->2891|5928->2906|5958->2927|5977->2937|6025->2947|6091->2977|6105->2982|6135->2990|6177->3001|6347->3135|6401->3180|6441->3182|6470->3192|6483->3196|6522->3197|6568->3210|6611->3218|6751->3335|6792->3341|6894->3421|7084->3575|7104->3586|7178->3638|7494->3919|7530->3946|7549->3956|7597->3966|7663->3996|7677->4001|7707->4009|7749->4020
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|49->20|49->20|50->21|50->21|50->21|50->21|50->21|50->21|54->25|54->25|54->25|54->25|54->25|54->25|54->25|55->26|55->26|57->28|57->28|57->28|57->28|58->29|58->29|58->29|59->30|64->35|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|66->37|66->37|69->40|69->40|69->40|75->46|75->46|75->46|75->46|76->47|76->47|76->47|77->48|82->53|82->53|82->53|82->53|82->53|82->53|82->53|83->54|83->54|85->56|85->56|85->56|85->56|86->57|86->57|86->57|87->58|92->63|92->63|92->63|92->63|92->63|92->63|92->63|93->64|93->64|94->65|94->65|97->68|97->68|97->68|103->74|103->74|103->74|103->74|104->75|104->75|104->75|105->76
                    -- GENERATED --
                */
            