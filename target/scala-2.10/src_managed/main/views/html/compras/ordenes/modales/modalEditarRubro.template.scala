
package views.html.compras.ordenes.modales

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
object modalEditarRubro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.OrdenesAccionesController.editarRubro(), 'id -> "formEditarRubro")/*5.116*/ {_display_(Seq[Any](format.raw/*5.118*/("""	
	<input name="id_orden" id="id_orden" type="hidden" value=""""),_display_(Seq[Any](/*6.61*/id)),format.raw/*6.63*/(""""/>
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row contenedorRubros">
		<div class="col-sm-3">
			<div class="seleccionOrdenRubro form-group """),_display_(Seq[Any](/*10.48*/if(formBuscador.error("orden_rubro_id") != null)/*10.96*/ {_display_(Seq[Any](format.raw/*10.98*/("""has-error""")))})),format.raw/*10.108*/("""">
				<label for="" class="control-label">Rubro</label>
				"""),_display_(Seq[Any](/*12.6*/select(formBuscador("orden_rubro_id"), 
				OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*13.126*/("""
				"""),_display_(Seq[Any](/*14.6*/formBuscador("orden_rubro_id")/*14.36*/.error.map/*14.46*/{ error =>_display_(Seq[Any](format.raw/*14.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*15.31*/error/*15.36*/.message)),format.raw/*15.44*/("""</div>
				""")))})),format.raw/*16.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="seleccionSubrubros form-group """),_display_(Seq[Any](/*20.47*/if(formBuscador.error("orden_subrubro_id") != null)/*20.98*/ {_display_(Seq[Any](format.raw/*20.100*/("""has-error""")))})),format.raw/*20.110*/("""">
				<label for="" class="control-label">Sub-Rubro</label>
				"""),_display_(Seq[Any](/*22.6*/select(formBuscador("orden_subrubro_id"), 
					formBuscador("ordenRubro.id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {OrdenSubrubro.getOrdenSubrubro(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*28.65*/("""
				"""),_display_(Seq[Any](/*29.6*/formBuscador("orden_subrubro_id")/*29.39*/.error.map/*29.49*/{ error =>_display_(Seq[Any](format.raw/*29.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*30.31*/error/*30.36*/.message)),format.raw/*30.44*/("""</div>
				""")))})),format.raw/*31.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<label class="control-label">Detalle Rubro</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*37.6*/inputText(formBuscador("detalle_rubro"), 'class -> "form-control",'id -> "detalle_rubro"))),format.raw/*37.95*/("""
				"""),_display_(Seq[Any](/*38.6*/formBuscador("detalle_rubro")/*38.35*/.error.map/*38.45*/{ error =>_display_(Seq[Any](format.raw/*38.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*39.31*/error/*39.36*/.message)),format.raw/*39.44*/("""</div>
				""")))})),format.raw/*40.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Editar Rubros"><i class="glyphicon glyphicon-arrow-right"></i> 
			Editar</button>
		</div>
	</div>

""")))})),format.raw/*51.2*/("""
<script>
$( function() """),format.raw/*53.15*/("""{"""),format.raw/*53.16*/("""
	
	urlOrdenSubrubro  = '"""),_display_(Seq[Any](/*55.24*/controllers/*55.35*/.compras.routes.OrdenSubrubroController.listOptions())),format.raw/*55.88*/("""';
	
	var contenedorRubros = $('.contenedorRubros');
	
	contenedorRubros.on('change', '.seleccionOrdenRubro .select', function()"""),format.raw/*59.74*/("""{"""),format.raw/*59.75*/("""
		var id = $(this).find('option:selected').val();
		var contenedor = $(this).closest('.contenedorRubros');
		contenedor.find('.seleccionSubrubros .select').find('option:gt(0)').remove();
		
		if(id == "") return false;

		$.get(urlOrdenSubrubro + '?rubroId='+id, function(data)"""),format.raw/*66.58*/("""{"""),format.raw/*66.59*/("""
			contenedor.find('.seleccionSubrubros .select').html(data);
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
	
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>
"""),_display_(Seq[Any](/*73.2*/flash()/*73.9*/.clear())),format.raw/*73.17*/("""








"""))}
    }
    
    def render(formBuscador:DynamicForm,id:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id) => apply(formBuscador,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalEditarRubro.scala.html
                    HASH: 76ad56b62e950285cafbe756fd4e18b0e7db452e
                    MATRIX: 819->1|956->55|988->79|1062->36|1090->123|1147->146|1160->152|1277->260|1317->262|1414->324|1437->326|1477->332|1489->337|1535->362|1680->471|1737->519|1777->521|1820->531|1917->593|2105->758|2146->764|2185->794|2204->804|2252->814|2319->845|2333->850|2363->858|2406->870|2533->961|2593->1012|2634->1014|2677->1024|2778->1090|3141->1431|3182->1437|3224->1470|3243->1480|3291->1490|3358->1521|3372->1526|3402->1534|3445->1546|3612->1678|3723->1767|3764->1773|3802->1802|3821->1812|3869->1822|3936->1853|3950->1858|3980->1866|4023->1878|4290->2114|4342->2138|4371->2139|4433->2165|4453->2176|4528->2229|4684->2357|4713->2358|5019->2636|5048->2637|5140->2702|5168->2703|5199->2707|5227->2708|5259->2713|5287->2714|5336->2728|5351->2735|5381->2743
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|38->10|40->12|41->13|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|48->20|48->20|48->20|48->20|50->22|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|59->31|65->37|65->37|66->38|66->38|66->38|66->38|67->39|67->39|67->39|68->40|79->51|81->53|81->53|83->55|83->55|83->55|87->59|87->59|94->66|94->66|96->68|96->68|97->69|97->69|99->71|99->71|101->73|101->73|101->73
                    -- GENERATED --
                */
            