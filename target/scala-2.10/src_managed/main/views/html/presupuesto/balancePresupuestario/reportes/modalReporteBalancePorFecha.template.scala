
package views.html.presupuesto.balancePresupuestario.reportes

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
object modalReporteBalancePorFecha extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,url2: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> 
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*9.93*/("""">Descargar archivo</a>
		</div>
	</div>
	
	
""")))}/*14.2*/else/*14.6*/{_display_(Seq[Any](format.raw/*14.7*/("""

	"""),_display_(Seq[Any](/*16.3*/helper/*16.9*/.form(action = controllers.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalancePorFechaPorExpediente(), 'id -> "formReporteBalancePorFecha")/*16.170*/ {_display_(Seq[Any](format.raw/*16.172*/("""
		"""),_display_(Seq[Any](/*17.4*/if(flash.containsKey("error"))/*17.34*/ {_display_(Seq[Any](format.raw/*17.36*/("""
			<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*18.85*/flash/*18.90*/.get("error"))),format.raw/*18.103*/("""</div>
		""")))})),format.raw/*19.4*/("""
		
		"""),_display_(Seq[Any](/*21.4*/if(flash.containsKey("success"))/*21.36*/ {_display_(Seq[Any](format.raw/*21.38*/("""
			<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*22.84*/flash/*22.89*/.get("success"))),format.raw/*22.104*/("""</div>
		""")))})),format.raw/*23.4*/("""
	
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde Preventivo</label> 
					"""),_display_(Seq[Any](/*29.7*/inputText(formBuscador("fecha_desde_preventivo"), 'class -> "form-control date", 'id -> "fecha_desde_preventivo", 'autofocus -> "autofocus"))),format.raw/*29.147*/("""
				</div>
					"""),_display_(Seq[Any](/*31.7*/formBuscador("fecha_desde_preventivo")/*31.45*/.error.map/*31.55*/{ error =>_display_(Seq[Any](format.raw/*31.65*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*32.32*/error/*32.37*/.message)),format.raw/*32.45*/("""</div>
					""")))})),format.raw/*33.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta Preventivo</label> 
					"""),_display_(Seq[Any](/*38.7*/inputText(formBuscador("fecha_hasta_preventivo"), 'class -> "form-control date", 'id -> "fecha_hasta_preventivo", 'autofocus -> "autofocus"))),format.raw/*38.147*/("""
				</div>
					"""),_display_(Seq[Any](/*40.7*/formBuscador("fecha_hasta_preventivo")/*40.45*/.error.map/*40.55*/{ error =>_display_(Seq[Any](format.raw/*40.65*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*41.32*/error/*41.37*/.message)),format.raw/*41.45*/("""</div>
					""")))})),format.raw/*42.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde Definitivo</label> 
					"""),_display_(Seq[Any](/*47.7*/inputText(formBuscador("fecha_desde_definitivo"), 'class -> "form-control date", 'id -> "fecha_desde_definitivo", 'autofocus -> "autofocus"))),format.raw/*47.147*/("""
				</div>
					"""),_display_(Seq[Any](/*49.7*/formBuscador("fecha_desde_definitivo")/*49.45*/.error.map/*49.55*/{ error =>_display_(Seq[Any](format.raw/*49.65*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*50.32*/error/*50.37*/.message)),format.raw/*50.45*/("""</div>
					""")))})),format.raw/*51.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta Definitivo</label> 
					"""),_display_(Seq[Any](/*56.7*/inputText(formBuscador("fecha_hasta_definitivo"), 'class -> "form-control date", 'id -> "fecha_hasta_definitivo", 'autofocus -> "autofocus"))),format.raw/*56.147*/("""
				</div>
					"""),_display_(Seq[Any](/*58.7*/formBuscador("fecha_hasta_definitivo")/*58.45*/.error.map/*58.55*/{ error =>_display_(Seq[Any](format.raw/*58.65*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*59.32*/error/*59.37*/.message)),format.raw/*59.45*/("""</div>
					""")))})),format.raw/*60.7*/("""
			</div>
			
			
		</div>
		<div class="row">	
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
				"""),_display_(Seq[Any](/*68.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select"))),format.raw/*69.37*/("""
				</label>
			</div>
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*76.3*/("""	
""")))})),format.raw/*77.2*/("""

"""),_display_(Seq[Any](/*79.2*/flash()/*79.9*/.clear())),format.raw/*79.17*/("""
<script>
 $( function () """),format.raw/*81.17*/("""{"""),format.raw/*81.18*/("""
	 $( ".date" ).mask("99/99/9999");
	 
	 $(document).on("submit", '#formReporteBalancePorFecha', function()"""),format.raw/*84.69*/("""{"""),format.raw/*84.70*/("""
			var form = $(this);
			var url = form.attr('action');
			var data = form.serialize();
			var submit = form.find("button[type='submit']");
			submit.replaceWith(getLoading());
			$.post(url, data, function(data)"""),format.raw/*90.36*/("""{"""),format.raw/*90.37*/("""
				if(data.success) """),format.raw/*91.22*/("""{"""),format.raw/*91.23*/("""
					 
					form.replaceWith(data.html);
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""" else """),format.raw/*94.12*/("""{"""),format.raw/*94.13*/("""
					form.replaceWith(data);
				"""),format.raw/*96.5*/("""}"""),format.raw/*96.6*/("""
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/(""");
			
			return false;
		"""),format.raw/*100.3*/("""}"""),format.raw/*100.4*/(""");
	 
	 if($("#cuenta_modal").length)"""),format.raw/*102.32*/("""{"""),format.raw/*102.33*/("""
			var options = """),format.raw/*103.18*/("""{"""),format.raw/*103.19*/("""
					script:"/contabilidad/suggestCuenta/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*109.31*/("""{"""),format.raw/*109.32*/(""" 
												$("#cuenta_id_modal").val(obj.id); 
											 """),format.raw/*111.13*/("""}"""),format.raw/*111.14*/("""
				"""),format.raw/*112.5*/("""}"""),format.raw/*112.6*/(""";
			var as_json = new bsn.AutoSuggest('cuenta_modal', options);
		"""),format.raw/*114.3*/("""}"""),format.raw/*114.4*/("""	
 """),format.raw/*115.2*/("""}"""),format.raw/*115.3*/(""");
</script>"""))}
    }
    
    def render(url:String,url2:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,url2,formBuscador)
    
    def f:((String,String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,url2,formBuscador) => apply(url,url2,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/balancePresupuestario/reportes/modalReporteBalancePorFecha.scala.html
                    HASH: 2cb53c85121a000faf26710fe36054e0364d0708
                    MATRIX: 858->1|1026->86|1058->110|1132->67|1160->154|1198->158|1212->165|1251->167|1413->294|1432->305|1518->370|1582->416|1594->420|1632->421|1671->425|1685->431|1856->592|1897->594|1936->598|1975->628|2015->630|2136->715|2150->720|2186->733|2227->743|2269->750|2310->782|2350->784|2470->868|2484->873|2522->888|2563->898|2769->1069|2932->1209|2985->1227|3032->1265|3051->1275|3099->1285|3167->1317|3181->1322|3211->1330|3255->1343|3449->1502|3612->1642|3665->1660|3712->1698|3731->1708|3779->1718|3847->1750|3861->1755|3891->1763|3935->1776|4129->1935|4292->2075|4345->2093|4392->2131|4411->2141|4459->2151|4527->2183|4541->2188|4571->2196|4615->2209|4809->2368|4972->2508|5025->2526|5072->2564|5091->2574|5139->2584|5207->2616|5221->2621|5251->2629|5295->2642|5453->2765|5611->2901|5849->3108|5883->3111|5921->3114|5936->3121|5966->3129|6020->3155|6049->3156|6184->3263|6213->3264|6455->3478|6484->3479|6534->3501|6563->3502|6636->3548|6664->3549|6698->3555|6727->3556|6788->3590|6816->3591|6847->3595|6875->3596|6929->3622|6958->3623|7024->3660|7054->3661|7101->3679|7131->3680|7312->3832|7342->3833|7433->3895|7463->3896|7496->3901|7525->3902|7620->3969|7649->3970|7680->3973|7709->3974
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|37->9|37->9|37->9|42->14|42->14|42->14|44->16|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|66->38|66->38|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|75->47|75->47|77->49|77->49|77->49|77->49|78->50|78->50|78->50|79->51|84->56|84->56|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|96->68|97->69|104->76|105->77|107->79|107->79|107->79|109->81|109->81|112->84|112->84|118->90|118->90|119->91|119->91|122->94|122->94|122->94|122->94|124->96|124->96|125->97|125->97|128->100|128->100|130->102|130->102|131->103|131->103|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114|143->115|143->115
                    -- GENERATED --
                */
            