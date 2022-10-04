
package views.html.haberes.liquidacionPuestos.modales

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
object modalPasarAOtraLiquidacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.LiquidacionPuestosAccionesController.pasarAOtraLiquidacion(), 'id -> "formPasarAOtraLiquidacion")/*5.147*/ {_display_(Seq[Any](format.raw/*5.149*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="row">
		<div class="col-sm-3">
			<div class="input-group">
				<input type="text" name="liquidacion_mes_modal" id="liquidacion_mes_modal" class="form-control inputNumericMask" value=""/>
				<input type="hidden" name="liquidacion_mes_id_modal" id="liquidacion_mes_id_modal" class="" value=""/>
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchLiquidacionMes" 
								data-title="Selección de Liquidacion" 
								data-url=""""),_display_(Seq[Any](/*18.20*/controllers/*18.31*/.haberes.routes.LiquidacionMesesController.modalBuscar())),format.raw/*18.87*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.liquidacionMes.simple" 
								data-label="#liquidacion_mes_modal" 
								data-field="#liquidacion_mes_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Pasar a otra liquidacion"><i class="glyphicon glyphicon-arrow-right"></i> Pasar a otra liquidacion</button>
		</div>
	</div>

""")))})),format.raw/*36.2*/("""
<script>
$( function()"""),format.raw/*38.14*/("""{"""),format.raw/*38.15*/("""
	$('#searchLiquidacionMes').modalSearch();
	
	if($("#liquidacion_mes_modal").length)"""),format.raw/*41.40*/("""{"""),format.raw/*41.41*/("""
		var options = """),format.raw/*42.17*/("""{"""),format.raw/*42.18*/("""
				script:"/suggestLiquidacionMes/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*48.30*/("""{"""),format.raw/*48.31*/(""" 
											$("#liquidacion_mes_id_modal").val(obj.id); 
										 """),format.raw/*50.12*/("""}"""),format.raw/*50.13*/("""
			"""),format.raw/*51.4*/("""}"""),format.raw/*51.5*/(""";
		var as_json = new bsn.AutoSuggest('liquidacion_mes_modal', options);
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/("""
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/(""");
</script>
"""),_display_(Seq[Any](/*56.2*/flash()/*56.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/modales/modalPasarAOtraLiquidacion.scala.html
                    HASH: 306563b4aab0fb0b9e16389d0c45198055241e9c
                    MATRIX: 835->1|964->47|996->71|1070->28|1098->115|1137->120|1150->126|1298->265|1338->267|1378->273|1390->278|1436->303|1958->789|1978->800|2056->856|2628->1397|2679->1420|2708->1421|2821->1506|2850->1507|2895->1524|2924->1525|3093->1666|3122->1667|3219->1736|3248->1737|3279->1741|3307->1742|3408->1816|3436->1817|3464->1818|3492->1819|3541->1833|3556->1840
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|46->18|46->18|46->18|64->36|66->38|66->38|69->41|69->41|70->42|70->42|76->48|76->48|78->50|78->50|79->51|79->51|81->53|81->53|82->54|82->54|84->56|84->56
                    -- GENERATED --
                */
            