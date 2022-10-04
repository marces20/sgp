
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
object modalCargarFechaOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.cargarFechaOrdenPagoMasivo(), 'id -> "formCargarFechaOrdenPagoFactura")/*5.153*/ {_display_(Seq[Any](format.raw/*5.155*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="fecha_orden_pago_modal" class="control-label">Fecha orden de pago</label> 
				<input name="fecha_orden_pago_modal" id="fecha_orden_pago_modal" class="form-control date"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Fecha Orden de Pago"><i class="glyphicon glyphicon-arrow-right"></i> Cargar Fecha Orden de Pago</button>
		</div>
	</div>

""")))})),format.raw/*22.2*/("""
<script>
$( function()"""),format.raw/*24.14*/("""{"""),format.raw/*24.15*/("""
	$("#fecha_orden_pago_modal").mask("99/99/9999");
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/(""");
</script>
"""),_display_(Seq[Any](/*28.2*/flash()/*28.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalCargarFechaOrdenPago.scala.html
                    HASH: 15b995ddf29e8102d7948d713cbda877a14cd5a9
                    MATRIX: 830->1|959->47|991->71|1065->28|1093->115|1150->138|1163->144|1317->289|1357->291|1397->297|1409->302|1455->327|2012->853|2063->876|2092->877|2170->928|2198->929|2247->943|2262->950
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|50->22|52->24|52->24|54->26|54->26|56->28|56->28
                    -- GENERATED --
                */
            