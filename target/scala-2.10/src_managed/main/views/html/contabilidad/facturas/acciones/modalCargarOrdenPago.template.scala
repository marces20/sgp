
package views.html.contabilidad.facturas.acciones

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
object modalCargarOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.cargarOrdenPagoMasivo(), 'id -> "formCargarOrdenPagoFactura")/*5.143*/ {_display_(Seq[Any](format.raw/*5.145*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="row">
		<div class="col-sm-3">
			<div class="input-group">
				<input type="text" name="orden_pago" id="orden_pago_modal" class="form-control" value=""/>
				<input type="hidden" name="orden_pago_id" id="orden_pago_id_modal" class="" value=""/>
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchOrdenPago" 
								data-title="Selección de órdenes de pago" 
								data-url=""""),_display_(Seq[Any](/*18.20*/controllers/*18.31*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*18.88*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.orden-pago.simple" 
								data-label="#orden_pago_modal" 
								data-field="#orden_pago_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Orden de Pago"><i class="glyphicon glyphicon-arrow-right"></i> Cargar Orden de Pago</button>
		</div>
	</div>

""")))})),format.raw/*36.2*/("""
<script>
$( function()"""),format.raw/*38.14*/("""{"""),format.raw/*38.15*/("""
	$('#searchOrdenPago').modalSearch();
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
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalCargarOrdenPago.scala.html
                    HASH: 3f645210052d2a8d4a21c729228750cc519d4d6d
                    MATRIX: 825->1|954->47|986->71|1060->28|1088->115|1127->120|1140->126|1284->261|1324->263|1364->269|1376->274|1422->299|1894->735|1914->746|1993->803|2544->1323|2595->1346|2624->1347|2690->1386|2718->1387|2767->1401|2782->1408
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|46->18|46->18|46->18|64->36|66->38|66->38|68->40|68->40|70->42|70->42
                    -- GENERATED --
                */
            