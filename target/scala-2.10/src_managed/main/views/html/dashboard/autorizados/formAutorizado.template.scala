
package views.html.dashboard.autorizados

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
object formAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Autorizado],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(autorizadoForm: Form[Autorizado]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar autorizado"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*11.17*/if(request().getHeader("referer"))/*11.51*/{_display_(Seq[Any](format.raw/*11.52*/(""" """),_display_(Seq[Any](/*11.54*/request()/*11.63*/.getHeader("referer"))),format.raw/*11.84*/(""" """)))}/*11.87*/else/*11.92*/{_display_(Seq[Any](_display_(Seq[Any](/*11.94*/controllers/*11.105*/.dashboard.routes.AutorizadosController.index())),_display_(Seq[Any](/*11.153*/UriTrack/*11.161*/.decode()))))})),format.raw/*11.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*15.5*/if(autorizadoForm.field("id").value)/*15.41*/{_display_(Seq[Any](format.raw/*15.42*/("""<a href=""""),_display_(Seq[Any](/*15.52*/controllers/*15.63*/.dashboard.routes.AutorizadosController.ver(autorizadoForm.field("id").value.toLong))),_display_(Seq[Any](/*15.148*/UriTrack/*15.156*/.get("&"))),format.raw/*15.165*/("""" title="Ver autorizado" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.268*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*20.3*/inputText(autorizadoForm("id"), 'type -> "hidden", 'id -> "autorizadoId"))),format.raw/*20.76*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*21.29*/UriTrack/*21.37*/.getKey())),format.raw/*21.46*/(""" value=""""),_display_(Seq[Any](/*21.55*/UriTrack/*21.63*/.code())),format.raw/*21.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label> 
			<div class="form-group """),_display_(Seq[Any](/*25.28*/if(autorizadoForm.error("nombre") != null)/*25.70*/ {_display_(Seq[Any](format.raw/*25.72*/("""has-error""")))})),format.raw/*25.82*/("""">
				"""),_display_(Seq[Any](/*26.6*/inputText(autorizadoForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*26.91*/("""
				
				"""),_display_(Seq[Any](/*28.6*/autorizadoForm("nombre")/*28.30*/.error.map/*28.40*/{ error =>_display_(Seq[Any](format.raw/*28.50*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*29.31*/error/*29.36*/.message)),format.raw/*29.44*/("""</div>
				""")))})),format.raw/*30.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Descripcion</label> 
			<div class="form-group">
				"""),_display_(Seq[Any](/*36.6*/inputText(autorizadoForm("descripcion"), 'class -> "form-control"))),format.raw/*36.72*/("""
				
				 
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<div class="form-group """),_display_(Seq[Any](/*43.28*/if(autorizadoForm.error("fecha")  != null)/*43.70*/ {_display_(Seq[Any](format.raw/*43.72*/("""has-error""")))}/*43.82*/else/*43.86*/{_display_(Seq[Any](format.raw/*43.87*/("""has-required""")))})),format.raw/*43.100*/("""">
				"""),_display_(Seq[Any](/*44.6*/inputText(autorizadoForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*44.94*/("""
			</div>
			"""),_display_(Seq[Any](/*46.5*/autorizadoForm("fecha")/*46.28*/.error.map/*46.38*/{ error =>_display_(Seq[Any](format.raw/*46.48*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*47.30*/error/*47.35*/.message)),format.raw/*47.43*/("""</div>
			""")))})),format.raw/*48.5*/("""
		</div> 
		
		
		
		<!--<div class="col-sm-1">
			<div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*57.7*/checkbox(autorizadoForm("profe"),'id-> "profe"))),format.raw/*57.54*/("""
				</label>
			</div>
		</div>-->
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*62.28*/if(autorizadoForm.error("tipo_cuenta_id") != null)/*62.78*/ {_display_(Seq[Any](format.raw/*62.80*/("""has-error""")))})),format.raw/*62.90*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*64.6*/select(autorizadoForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*64.167*/("""
				"""),_display_(Seq[Any](/*65.6*/autorizadoForm("tipo_cuenta_id")/*65.38*/.error.map/*65.48*/{ error =>_display_(Seq[Any](format.raw/*65.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*66.31*/error/*66.36*/.message)),format.raw/*66.44*/("""</div>
				""")))})),format.raw/*67.6*/("""
			</div>
		</div> 
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*74.28*/if(autorizadoForm.error("cot_dolar") != null)/*74.73*/ {_display_(Seq[Any](format.raw/*74.75*/("""has-error""")))}/*74.85*/else/*74.89*/{_display_(Seq[Any](format.raw/*74.90*/("""has-required""")))})),format.raw/*74.103*/("""">
			<label class="control-label">Cotización</label>
				"""),_display_(Seq[Any](/*76.6*/inputText(autorizadoForm("cot_dolar"), 'class -> "form-control",'id -> "cot_dolar"))),format.raw/*76.89*/("""
				"""),_display_(Seq[Any](/*77.6*/autorizadoForm("cot_dolar")/*77.33*/.error.map/*77.43*/{ error =>_display_(Seq[Any](format.raw/*77.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*78.31*/error/*78.36*/.message)),format.raw/*78.44*/("""</div>
				""")))})),format.raw/*79.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*83.28*/if(autorizadoForm.error("tipo_moneda_id") != null)/*83.78*/ {_display_(Seq[Any](format.raw/*83.80*/("""has-error""")))}/*83.90*/else/*83.94*/{_display_(Seq[Any](format.raw/*83.95*/("""has-required""")))})),format.raw/*83.108*/("""">
			<label class="control-label">Moneda</label>
			
				"""),_display_(Seq[Any](/*86.6*/select(autorizadoForm("tipo_moneda_id"),TipoMoneda.find.all().map { p => p.id.toString -> p.nombre},'id -> "tipo_moneda_id", 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*86.191*/("""
				"""),_display_(Seq[Any](/*87.6*/autorizadoForm("tipo_moneda_id")/*87.38*/.error.map/*87.48*/{ error =>_display_(Seq[Any](format.raw/*87.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*88.31*/error/*88.36*/.message)),format.raw/*88.44*/("""</div>
				""")))})),format.raw/*89.6*/("""
			</div>
		</div>
	</div>
	 		
		
		
		
		
	
"""))}
    }
    
    def render(autorizadoForm:Form[Autorizado]): play.api.templates.HtmlFormat.Appendable = apply(autorizadoForm)
    
    def f:((Form[Autorizado]) => play.api.templates.HtmlFormat.Appendable) = (autorizadoForm) => apply(autorizadoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/formAutorizado.scala.html
                    HASH: 04eed02f02e61c90971a682f01d57a55545def5a
                    MATRIX: 815->1|967->70|999->94|1073->35|1101->138|1396->397|1439->431|1478->432|1516->434|1534->443|1577->464|1598->467|1611->472|1659->474|1680->485|1759->533|1777->541|1814->551|2013->714|2030->722|2061->731|2198->833|2243->869|2282->870|2328->880|2348->891|2464->976|2482->984|2514->993|2650->1096|2709->1120|2804->1193|2869->1222|2886->1230|2917->1239|2962->1248|2979->1256|3008->1263|3172->1391|3223->1433|3263->1435|3305->1445|3348->1453|3455->1538|3501->1549|3534->1573|3553->1583|3601->1593|3668->1624|3682->1629|3712->1637|3755->1649|3921->1780|4009->1846|4175->1976|4226->2018|4266->2020|4295->2030|4308->2034|4347->2035|4393->2048|4436->2056|4546->2144|4596->2159|4628->2182|4647->2192|4695->2202|4761->2232|4775->2237|4805->2245|4847->2256|5009->2383|5078->2430|5202->2518|5261->2568|5301->2570|5343->2580|5439->2641|5623->2802|5664->2808|5705->2840|5724->2850|5772->2860|5839->2891|5853->2896|5883->2904|5926->2916|6064->3018|6118->3063|6158->3065|6187->3075|6200->3079|6239->3080|6285->3093|6379->3152|6484->3235|6525->3241|6561->3268|6580->3278|6628->3288|6695->3319|6709->3324|6739->3332|6782->3344|6890->3416|6949->3466|6989->3468|7018->3478|7031->3482|7070->3483|7116->3496|7210->3555|7418->3740|7459->3746|7500->3778|7519->3788|7567->3798|7634->3829|7648->3834|7678->3842|7721->3854
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|49->20|49->20|50->21|50->21|50->21|50->21|50->21|50->21|54->25|54->25|54->25|54->25|55->26|55->26|57->28|57->28|57->28|57->28|58->29|58->29|58->29|59->30|65->36|65->36|72->43|72->43|72->43|72->43|72->43|72->43|72->43|73->44|73->44|75->46|75->46|75->46|75->46|76->47|76->47|76->47|77->48|86->57|86->57|91->62|91->62|91->62|91->62|93->64|93->64|94->65|94->65|94->65|94->65|95->66|95->66|95->66|96->67|103->74|103->74|103->74|103->74|103->74|103->74|103->74|105->76|105->76|106->77|106->77|106->77|106->77|107->78|107->78|107->78|108->79|112->83|112->83|112->83|112->83|112->83|112->83|112->83|115->86|115->86|116->87|116->87|116->87|116->87|117->88|117->88|117->88|118->89
                    -- GENERATED --
                */
            