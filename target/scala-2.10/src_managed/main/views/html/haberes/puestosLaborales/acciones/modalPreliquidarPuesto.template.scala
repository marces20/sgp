
package views.html.haberes.puestosLaborales.acciones

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
object modalPreliquidarPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.PuestosLaboralesAccionesController.preliquidarPuesto(), 'id -> "formPreliquidarPuesto")/*5.137*/ {_display_(Seq[Any](format.raw/*5.139*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="row">
		<div class="col-sm-3">
			<div class="input-group">
				<input type="text" name="liquidacion" id="liquidacion_modal" class="form-control" value=""/>
				<input type="hidden" name="liquidacion_id" id="liquidacion_id_modal" class="" value=""/>
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchLiquidacion" 
								data-title="Selección de liquidacion" 
								data-url=""""),_display_(Seq[Any](/*18.20*/controllers/*18.31*/.haberes.routes.LiquidacionMesesController.modalBuscar())),format.raw/*18.87*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.liquidacionMes.simple" 
								data-label="#liquidacion_modal" 
								data-field="#liquidacion_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Preliquidar"><i class="glyphicon glyphicon-arrow-right"></i> Preliquidar</button>
		</div>
	</div>

""")))})),format.raw/*36.2*/("""
<script>
$( function()"""),format.raw/*38.14*/("""{"""),format.raw/*38.15*/("""
	$('#searchLiquidacion').modalSearch();
"""),format.raw/*40.1*/("""}"""),format.raw/*40.2*/(""");
</script>
"""),_display_(Seq[Any](/*42.2*/flash()/*42.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/acciones/modalPreliquidarPuesto.scala.html
                    HASH: b70b4455f8ded53b6715764fdf6775c715170eac
                    MATRIX: 830->1|959->47|991->71|1065->28|1093->115|1132->120|1145->126|1283->255|1323->257|1363->263|1375->268|1421->293|1895->731|1915->742|1993->798|2531->1305|2582->1328|2611->1329|2679->1370|2707->1371|2756->1385|2771->1392
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|46->18|46->18|46->18|64->36|66->38|66->38|68->40|68->40|70->42|70->42
                    -- GENERATED --
                */
            