
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
object modalCargarFecha322 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.cargarFecha322Masivo(), 'id -> "formCargarFecha322Factura")/*5.141*/ {_display_(Seq[Any](format.raw/*5.143*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="fecha_322_modal" class="control-label">Fecha vencimiento 322</label> 
				<input name="fecha_322_modal" id="fecha_322_modal" class="form-control date"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Fecha vencimiento 322"><i class="glyphicon glyphicon-arrow-right"></i> Cargar Fecha vencimiento 322</button>
		</div>
	</div>

""")))})),format.raw/*22.2*/("""
<script>
$( function()"""),format.raw/*24.14*/("""{"""),format.raw/*24.15*/("""
	$("#fecha_322_modal").mask("99/99/9999");
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalCargarFecha322.scala.html
                    HASH: 8afdb81d13e38f577a34d8e2e3c5135c2dcbeacf
                    MATRIX: 824->1|953->47|985->71|1059->28|1087->115|1144->138|1157->144|1299->277|1339->279|1379->285|1391->290|1437->315|1979->826|2030->849|2059->850|2130->894|2158->895|2207->909|2222->916
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|50->22|52->24|52->24|54->26|54->26|56->28|56->28
                    -- GENERATED --
                */
            